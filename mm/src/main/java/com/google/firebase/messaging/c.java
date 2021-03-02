package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.content.b;
import android.text.TextUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class c {
    private static c bMV;
    private final Context bLv;
    private Bundle bMW;
    private Method bMX;
    private Method bMY;
    private final AtomicInteger bMZ = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private c(Context context) {
        AppMethodBeat.i(116792);
        this.bLv = context.getApplicationContext();
        AppMethodBeat.o(116792);
    }

    @TargetApi(26)
    private final Notification a(CharSequence charSequence, String str, int i2, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        AppMethodBeat.i(116794);
        Notification.Builder smallIcon = new Notification.Builder(this.bLv).setAutoCancel(true).setSmallIcon(i2);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            if (this.bMX == null) {
                this.bMX = bU("setChannelId");
            }
            if (this.bMX == null) {
                this.bMX = bU("setChannel");
            }
            if (this.bMX != null) {
                try {
                    this.bMX.invoke(smallIcon, str2);
                } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e2) {
                }
            }
        }
        Notification build = smallIcon.build();
        AppMethodBeat.o(116794);
        return build;
    }

    static synchronized c at(Context context) {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(116789);
            if (bMV == null) {
                bMV = new c(context);
            }
            cVar = bMV;
            AppMethodBeat.o(116789);
        }
        return cVar;
    }

    private static void b(Intent intent, Bundle bundle) {
        AppMethodBeat.i(116800);
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
        AppMethodBeat.o(116800);
    }

    @TargetApi(26)
    private static Method bU(String str) {
        AppMethodBeat.i(116795);
        try {
            Method method = Notification.Builder.class.getMethod(str, String.class);
            AppMethodBeat.o(116795);
            return method;
        } catch (NoSuchMethodException | SecurityException e2) {
            AppMethodBeat.o(116795);
            return null;
        }
    }

    private final Integer bV(String str) {
        Integer num = null;
        AppMethodBeat.i(116798);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(116798);
        } else {
            if (!TextUtils.isEmpty(str)) {
                try {
                    num = Integer.valueOf(Color.parseColor(str));
                    AppMethodBeat.o(116798);
                } catch (IllegalArgumentException e2) {
                    new StringBuilder(String.valueOf(str).length() + 54).append("Color ").append(str).append(" not valid. Notification will use default color.");
                }
            }
            int i2 = yB().getInt("com.google.firebase.messaging.default_notification_color", 0);
            if (i2 != 0) {
                try {
                    num = Integer.valueOf(b.n(this.bLv, i2));
                    AppMethodBeat.o(116798);
                } catch (Resources.NotFoundException e3) {
                }
            }
            AppMethodBeat.o(116798);
        }
        return num;
    }

    static String c(Bundle bundle, String str) {
        AppMethodBeat.i(116790);
        String string = bundle.getString(str);
        if (string == null) {
            string = bundle.getString(str.replace("gcm.n.", "gcm.notification."));
        }
        AppMethodBeat.o(116790);
        return string;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: java.lang.String[] */
    /* JADX WARN: Multi-variable type inference failed */
    private static Object[] d(Bundle bundle, String str) {
        AppMethodBeat.i(116791);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String c2 = c(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(c2)) {
            AppMethodBeat.o(116791);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(c2);
            String[] strArr = new String[jSONArray.length()];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                strArr[i2] = jSONArray.opt(i2);
            }
            AppMethodBeat.o(116791);
            return strArr;
        } catch (JSONException e2) {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf("_loc_args");
            String substring = (valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).substring(6);
            new StringBuilder(String.valueOf(substring).length() + 41 + String.valueOf(c2).length()).append("Malformed ").append(substring).append(": ").append(c2).append("  Default value will be used.");
            AppMethodBeat.o(116791);
            return null;
        }
    }

    @TargetApi(26)
    private final boolean fA(int i2) {
        AppMethodBeat.i(116797);
        if (Build.VERSION.SDK_INT != 26) {
            AppMethodBeat.o(116797);
            return true;
        }
        try {
            if (this.bLv.getResources().getDrawable(i2, null) instanceof AdaptiveIconDrawable) {
                new StringBuilder(77).append("Adaptive icons cannot be used in notifications. Ignoring icon id: ").append(i2);
                AppMethodBeat.o(116797);
                return false;
            }
            AppMethodBeat.o(116797);
            return true;
        } catch (Resources.NotFoundException e2) {
            AppMethodBeat.o(116797);
            return false;
        }
    }

    private final Bundle yB() {
        AppMethodBeat.i(116801);
        if (this.bMW != null) {
            Bundle bundle = this.bMW;
            AppMethodBeat.o(116801);
            return bundle;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.bLv.getPackageManager().getApplicationInfo(this.bLv.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            Bundle bundle2 = Bundle.EMPTY;
            AppMethodBeat.o(116801);
            return bundle2;
        }
        this.bMW = applicationInfo.metaData;
        Bundle bundle3 = this.bMW;
        AppMethodBeat.o(116801);
        return bundle3;
    }

    @TargetApi(26)
    private final String zzn(String str) {
        AppMethodBeat.i(116799);
        if (!PlatformVersion.isAtLeastO()) {
            AppMethodBeat.o(116799);
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.bLv.getSystemService(NotificationManager.class);
        try {
            if (this.bMY == null) {
                this.bMY = notificationManager.getClass().getMethod("getNotificationChannel", String.class);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.bMY.invoke(notificationManager, str) != null) {
                    AppMethodBeat.o(116799);
                    return str;
                }
                new StringBuilder(String.valueOf(str).length() + 122).append("Notification Channel requested (").append(str).append(") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string = yB().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (!TextUtils.isEmpty(string)) {
                if (this.bMY.invoke(notificationManager, string) != null) {
                    AppMethodBeat.o(116799);
                    return string;
                }
            }
            if (this.bMY.invoke(notificationManager, "fcm_fallback_notification_channel") == null) {
                Class<?> cls = Class.forName("android.app.NotificationChannel");
                Object newInstance = cls.getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance("fcm_fallback_notification_channel", this.bLv.getString(R.string.cdb), 3);
                notificationManager.getClass().getMethod("createNotificationChannel", cls).invoke(notificationManager, newInstance);
            }
            AppMethodBeat.o(116799);
            return "fcm_fallback_notification_channel";
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | LinkageError | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            AppMethodBeat.o(116799);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0320  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m(android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 847
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.c.m(android.os.Bundle):boolean");
    }

    private final String zzd(Bundle bundle, String str) {
        AppMethodBeat.i(116796);
        String c2 = c(bundle, str);
        if (!TextUtils.isEmpty(c2)) {
            AppMethodBeat.o(116796);
            return c2;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        String c3 = c(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(c3)) {
            AppMethodBeat.o(116796);
            return null;
        }
        Resources resources = this.bLv.getResources();
        int identifier = resources.getIdentifier(c3, "string", this.bLv.getPackageName());
        if (identifier == 0) {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf("_loc_key");
            String substring = (valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).substring(6);
            new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(c3).length()).append(substring).append(" resource not found: ").append(c3).append(" Default value will be used.");
            AppMethodBeat.o(116796);
            return null;
        }
        Object[] d2 = d(bundle, str);
        if (d2 == null) {
            String string = resources.getString(identifier);
            AppMethodBeat.o(116796);
            return string;
        }
        try {
            String string2 = resources.getString(identifier, d2);
            AppMethodBeat.o(116796);
            return string2;
        } catch (MissingFormatArgumentException e2) {
            String arrays = Arrays.toString(d2);
            new StringBuilder(String.valueOf(c3).length() + 58 + String.valueOf(arrays).length()).append("Missing format argument for ").append(c3).append(": ").append(arrays).append(" Default value will be used.");
            AppMethodBeat.o(116796);
            return null;
        }
    }
}
