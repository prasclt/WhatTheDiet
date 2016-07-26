package com.microsoft.hack.whatthediet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by prmeno on 7/26/2016.
 */
public class Helper {

    public static void launchQRScanner(Fragment fragment) {
        if (fragment == null) {
            return;
        }

        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        fragment.startActivityForResult(intent, 0);
    }
}
