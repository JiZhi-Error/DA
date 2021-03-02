package com.tencent.b.a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.TimeZone;

final class b {
    static a dfv;
    Integer dfw = null;
    String dfx = null;

    /* access modifiers changed from: package-private */
    public static class a {
        String appVersion;
        Context ctx;
        int dfA;
        String dfB;
        String dfC;
        String dfD;
        String dfE;
        int dfF;
        String dfG;
        String dfH;
        String dfy;
        DisplayMetrics dfz;
        String imsi;
        String language;
        String model;
        String packageName;
        String timezone;

        private a(Context context) {
            TelephonyManager telephonyManager;
            AppMethodBeat.i(87626);
            this.dfy = "2.21";
            this.dfA = Build.VERSION.SDK_INT;
            this.model = Build.MODEL;
            this.dfB = Build.MANUFACTURER;
            this.language = Locale.getDefault().getLanguage();
            this.dfC = "WX";
            this.dfF = 0;
            this.packageName = null;
            this.ctx = null;
            this.dfG = null;
            this.dfH = null;
            this.ctx = context.getApplicationContext();
            try {
                this.appVersion = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                s.Ug();
            }
            this.dfz = new DisplayMetrics();
            ((WindowManager) this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.dfz);
            if (s.checkPermission(context, "android.permission.READ_PHONE_STATE") && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                this.dfD = telephonyManager.getSimOperator();
                this.imsi = telephonyManager.getSubscriberId();
            }
            this.timezone = TimeZone.getDefault().getID();
            this.dfE = s.bz(this.ctx);
            this.packageName = this.ctx.getPackageName();
            this.dfH = s.Ui();
            AppMethodBeat.o(87626);
        }

        /* synthetic */ a(Context context, byte b2) {
            this(context);
        }
    }

    private static synchronized a bp(Context context) {
        a aVar;
        synchronized (b.class) {
            AppMethodBeat.i(87627);
            if (dfv == null) {
                dfv = new a(context.getApplicationContext(), (byte) 0);
            }
            aVar = dfv;
            AppMethodBeat.o(87627);
        }
        return aVar;
    }

    public b(Context context) {
        AppMethodBeat.i(87628);
        try {
            bp(context);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                this.dfw = Integer.valueOf(telephonyManager.getNetworkType());
            }
            this.dfx = s.bA(context);
            AppMethodBeat.o(87628);
        } catch (Throwable th) {
            s.Ug();
            AppMethodBeat.o(87628);
        }
    }
}
