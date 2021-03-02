package com.tencent.mm.plugin.sns.device.appstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public abstract class ApkInstalledWatcher extends BroadcastReceiver {
    /* access modifiers changed from: protected */
    public abstract boolean aOB(String str);

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    String aW = aW(intent);
                    if (!TextUtils.isEmpty(aW)) {
                        aOB(aW);
                    }
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    TextUtils.isEmpty(aW(intent));
                }
            } catch (Throwable th) {
            }
        }
    }

    private static String aW(Intent intent) {
        try {
            return intent.getData().getSchemeSpecificPart();
        } catch (Throwable th) {
            return "";
        }
    }
}
