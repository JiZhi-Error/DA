package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public interface ax extends az {
    void C(String str, int i2);

    void CY(String str);

    void Xc();

    int a(Notification notification, boolean z);

    Notification a(Notification notification, int i2, int i3, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    Notification a(Notification notification, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4, PendingIntent pendingIntent2, String str5, PendingIntent pendingIntent3, String str6);

    Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    void a(int i2, Notification notification, boolean z);

    String ala();

    void alb();

    void alc();

    int c(Notification notification);

    @Override // com.tencent.mm.model.az
    void cancel(int i2);

    void cancelNotification(String str);

    void dh(boolean z);

    void di(boolean z);

    void dj(boolean z);

    void nR(int i2);

    void nS(int i2);

    @Override // com.tencent.mm.model.az
    void notify(int i2, Notification notification);

    void r(int i2, String str);
}
