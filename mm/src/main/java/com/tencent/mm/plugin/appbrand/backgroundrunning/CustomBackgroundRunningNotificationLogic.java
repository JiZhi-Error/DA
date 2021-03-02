package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.jsapi.n;

public abstract class CustomBackgroundRunningNotificationLogic implements n {
    public abstract Notification byP();

    public abstract void byQ();

    public abstract int getNotificationId();

    @Keep
    public CustomBackgroundRunningNotificationLogic(String str) {
    }
}
