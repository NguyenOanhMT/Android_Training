package com.nguyenoanh.buttonled;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.google.android.things.contrib.driver.button.Button;
import com.google.android.things.contrib.driver.button.ButtonInputDriver;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManager;


import java.io.IOException;


public class ButtonLed extends AppCompatActivity {

    private static final String TAG = ButtonLed.class.getSimpleName();

    private Gpio mLedGpio;
    private ButtonInputDriver mButtonInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_led);

        Log.i(TAG, "Starting Button Led");

        PeripheralManager pioServer = PeripheralManager.getInstance();

        try{
            Log.i(TAG, "Config Gpio");
            mLedGpio = pioServer.openGpio(BoardDefault.getGPIOForLED());
            mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        }catch (IOException e){
            Log.e(TAG,"Error config Gpio",e);
        }

        try{
            Log.i(TAG, "registering button driver"+ BoardDefault.getGPIOForButton());
            //Gpio state change
            mButtonInput = new ButtonInputDriver(
                    BoardDefault.getGPIOForButton(),
                    Button.LogicState.PRESSED_WHEN_LOW,
                    KeyEvent.KEYCODE_SPACE
            );

            mButtonInput.register();
        } catch (IOException e) {
            Log.e(TAG, "Error config GPIO", e);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SPACE) {
            // Turn on the LED
            setLedValue(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SPACE) {
            // Turn off the LED
            setLedValue(false);

            return true;
        }

        return super.onKeyUp(keyCode, event);
    }

    //Update the value of the LED output
    private void setLedValue(boolean value) {
        try {
            mLedGpio.setValue(value);
        } catch (IOException e) {
            Log.e(TAG, "Error updating GPIO value", e);
        }
    }

    @Override
    protected void onStop(){
        Log.d(TAG, "Calling onStop");
        if (mButtonInput != null) {
            mButtonInput.unregister();//cancel register
            try {
                Log.d(TAG, "Unregistering button");
                mButtonInput.close();
            } catch (IOException e) {
                Log.e(TAG, "Error closing Button driver", e);
            } finally{
                mButtonInput = null;
            }
        }

        if (mLedGpio != null) {
            try {
                Log.d(TAG, "Unregistering LED");
                mLedGpio.close();
            } catch (IOException e) {
                Log.e(TAG, "Error closing LED GPIO", e);
            } finally{
                mLedGpio = null;
            }
        }
        super.onStop();
    }
}
/*
// Read from the database
myRef.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        String value = dataSnapshot.getValue(String.class);
        Log.d(TAG, "Value is: " + value);
        }

@Override
public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
        }
        });
*/