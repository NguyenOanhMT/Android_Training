package com.nguyenoanh.managerstudent.util;

import android.app.Activity;
import android.content.Intent;

import com.nguyenoanh.managerstudent.Activity.AddActivity;
import com.nguyenoanh.managerstudent.AppConstants;
import com.nguyenoanh.managerstudent.Database.InforStudent;

public class NavigatorUtils implements AppConstants {
//    public static void redirectToPwdScreen(Activity activity,
//                                           InforStudent student) {
//        Intent intent = new Intent(activity, PwdActivity.class);
//        intent.putExtra(INTENT_TASK, student);
//        activity.startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
//    }

    public static void redirectToEditTaskScreen(Activity activity,
                                                InforStudent student) {
        Intent intent = new Intent(activity, AddActivity.class);
        intent.putExtra(INTENT_TASK, student);
        activity.startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
    }

    public static void redirectToViewNoteScreen(Activity activity,
                                                InforStudent student) {
        Intent intent = new Intent(activity, AddActivity.class);
        intent.putExtra(INTENT_TASK, student);
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        activity.startActivity(intent);
        activity.finish();
    }
}
