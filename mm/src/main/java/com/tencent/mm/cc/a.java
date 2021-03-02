package com.tencent.mm.cc;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zh;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a {
    private static boolean NCT = true;
    public static String NCU = "screenResolution_density_dpi";
    public static String NCV = "screenResolution_density_dpi_new";
    public static String NCW = "screenResolution_density_report_new";
    public static String NCX = "screenResolution_density_report_pad";
    public static String NCY = "screenResolution_target_field";
    public static String NCZ = "screenResolution_isModifyDensity";
    static float NDa = 1.0f;
    private static boolean NDb = false;
    static AbstractC0287a NDc;
    private static Boolean NDd = null;
    private static Boolean NDe = null;
    private static Boolean NDf = null;
    private static boolean NDi = false;
    private static boolean NDj;
    static int qOF = 0;
    DisplayMetrics NCS;
    private Method NDg = null;
    private Field NDh = null;
    DisplayMetrics aJm;

    /* renamed from: com.tencent.mm.cc.a$a  reason: collision with other inner class name */
    public interface AbstractC0287a {
        void Wu();
    }

    static {
        AppMethodBeat.i(141210);
        NDj = false;
        if (Build.BRAND != null) {
            String lowerCase = Build.BRAND.toLowerCase();
            if ((lowerCase.contains("huawei") || lowerCase.contains("honor")) && Build.VERSION.SDK_INT == 24) {
                NDj = true;
            }
        }
        AppMethodBeat.o(141210);
    }

    public static void a(AbstractC0287a aVar) {
        NDc = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0114  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.util.DisplayMetrics r7) {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.cc.a.<init>(android.util.DisplayMetrics):void");
    }

    public static DisplayMetrics b(DisplayMetrics displayMetrics) {
        float f2;
        float f3;
        float f4;
        AppMethodBeat.i(141188);
        float gvu = (float) gvu();
        if (ao.gJJ() >= 600) {
            gvu = 700.0f;
        } else if (ao.gJJ() >= 533) {
            gvu = 600.0f;
        } else {
            NDa = 400.0f / gvu;
        }
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        float f5 = ((float) min) / gvu;
        Log.i("MicroMsg.MMDensityManager", "applyScreenAdaptiveDensity originWidth:%s, originheight:%s, targetField:%s", Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Float.valueOf(gvu));
        if (ao.gJP() == 0 || qOF == 0) {
            f2 = f5;
        } else {
            if (min != 0) {
                f3 = ((float) qOF) / ((float) min);
            } else {
                f3 = 1.0f;
            }
            if (ao.gJQ() != ao.gJP()) {
                f4 = f3 * (((float) ao.gJQ()) / ((float) ao.gJP()));
            } else {
                f4 = 1.0f;
            }
            if (f4 < 0.95f) {
                f4 = 0.95f;
            }
            if (ao.gJH() || ao.gJI()) {
                if (f4 > 1.5f) {
                    f4 = 1.5f;
                }
            } else if (f4 > 1.2f) {
                f4 = 1.2f;
            }
            NDa *= f4;
            float f6 = f5 * f4;
            Log.i("MicroMsg.MMDensityManager", "scale targetDensity:%s , DeviceDpi:%s, WindowDpi:%s, DeviceWidth:%s, DisplayWidth:%s, dpiScale:%s", Float.valueOf(f6), Integer.valueOf(ao.gJP()), Integer.valueOf(ao.gJQ()), Integer.valueOf(qOF), Integer.valueOf(min), Float.valueOf(f4));
            f2 = f6;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        displayMetrics2.scaledDensity = (displayMetrics.scaledDensity / displayMetrics.density) * f2;
        displayMetrics2.densityDpi = (int) (160.0f * f2);
        displayMetrics2.density = f2;
        AppMethodBeat.o(141188);
        return displayMetrics2;
    }

    public static float gvi() {
        return NDa;
    }

    public static boolean gvj() {
        AppMethodBeat.i(141189);
        try {
            if (Util.getInt(d.cRY().b("clicfg_android_density_check_kill_enable", "1", false, true), 1) > 0) {
                AppMethodBeat.o(141189);
                return true;
            }
            AppMethodBeat.o(141189);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMDensityManager", e2, "isOpenKillSelf", new Object[0]);
            AppMethodBeat.o(141189);
            return false;
        }
    }

    private static boolean gvk() {
        AppMethodBeat.i(141190);
        if (NDd == null) {
            try {
                if (Util.getInt(d.cRY().b("clicfg_screen_adaptive_huawei_four", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 1) > 0) {
                    Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
                    NDd = Boolean.TRUE;
                } else {
                    NDd = Boolean.FALSE;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMDensityManager", e2, "isOpenHuaWeiSpecialAll", new Object[0]);
                NDd = Boolean.FALSE;
            }
        }
        boolean booleanValue = NDd.booleanValue();
        AppMethodBeat.o(141190);
        return booleanValue;
    }

    private static boolean gvl() {
        AppMethodBeat.i(141191);
        if (NDe == null) {
            try {
                if (Util.getInt(d.cRY().b("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
                    Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
                    NDe = Boolean.TRUE;
                } else {
                    NDe = Boolean.FALSE;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMDensityManager", e2, "isOpenHuaWeiSpecial360", new Object[0]);
                NDe = Boolean.FALSE;
            }
        }
        boolean booleanValue = NDe.booleanValue();
        AppMethodBeat.o(141191);
        return booleanValue;
    }

    public static boolean gvm() {
        AppMethodBeat.i(141192);
        try {
            if (Util.getInt(d.cRY().b("clicfg_screen_adaptive", "1", false, true), 1) > 0) {
                AppMethodBeat.o(141192);
                return true;
            }
            AppMethodBeat.o(141192);
            return false;
        } catch (Exception | UnsatisfiedLinkError e2) {
            Log.printErrStackTrace("MicroMsg.MMDensityManager", e2, "isOpenScreenAdaptiveForMM", new Object[0]);
            AppMethodBeat.o(141192);
            return false;
        }
    }

    private static boolean gvn() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(141193);
        try {
            com.tencent.mm.l.a anB = a.C0367a.anB();
            if (anB != null) {
                z = anB.Wo();
            } else {
                z = false;
            }
            if (Util.getInt(d.cRY().b("clicfg_screen_adaptive_appbrand", "1", false, true), 1) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || !z) {
                AppMethodBeat.o(141193);
                return false;
            }
            AppMethodBeat.o(141193);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMDensityManager", e2, "isOpenScreenAdaptiveForAppBrand", new Object[0]);
            AppMethodBeat.o(141193);
            return false;
        }
    }

    private static boolean gvo() {
        AppMethodBeat.i(141194);
        try {
            if (Util.getInt(d.cRY().b("clicfg_screen_adaptive_tool", "1", false, true), 1) > 0) {
                AppMethodBeat.o(141194);
                return true;
            }
            AppMethodBeat.o(141194);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMDensityManager", e2, "isOpenScreenAdaptiveForTool", new Object[0]);
            AppMethodBeat.o(141194);
            return false;
        }
    }

    public final DisplayMetrics getDisplayMetrics() {
        AppMethodBeat.i(141195);
        if (gvs()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(this.aJm);
            AppMethodBeat.o(141195);
            return displayMetrics;
        }
        DisplayMetrics displayMetrics2 = this.NCS;
        AppMethodBeat.o(141195);
        return displayMetrics2;
    }

    public static float gvp() {
        AppMethodBeat.i(141196);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f2 = displayMetrics.density;
        AppMethodBeat.o(141196);
        return f2;
    }

    public final Configuration g(Configuration configuration) {
        AppMethodBeat.i(141197);
        if (gvs()) {
            Configuration configuration2 = new Configuration(configuration);
            configuration2.densityDpi = getDisplayMetrics().densityDpi;
            gvq();
            AppMethodBeat.o(141197);
            return configuration2;
        }
        AppMethodBeat.o(141197);
        return configuration;
    }

    /* access modifiers changed from: package-private */
    public final void gvq() {
        AppMethodBeat.i(141198);
        try {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            if (this.NDg == null) {
                Method declaredMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", Integer.TYPE);
                declaredMethod.setAccessible(true);
                this.NDg = declaredMethod;
            }
            this.NDg.invoke(null, Integer.valueOf(displayMetrics.densityDpi));
            if (this.NDh == null) {
                this.NDh = DisplayMetrics.class.getDeclaredField("DENSITY_DEVICE");
                d(this.NDh);
            }
            this.NDh.setInt(null, displayMetrics.densityDpi);
            AppMethodBeat.o(141198);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMDensityManager", e2, "", new Object[0]);
            AppMethodBeat.o(141198);
        }
    }

    static boolean gvr() {
        AppMethodBeat.i(141199);
        if (com.tencent.mm.cb.a.je(MMApplicationContext.getContext()) != 0.8f || gvu() == 440) {
            AppMethodBeat.o(141199);
            return false;
        }
        AppMethodBeat.o(141199);
        return true;
    }

    static String c(DisplayMetrics displayMetrics) {
        AppMethodBeat.i(141200);
        String format = String.format("scaledDensity:%s densityDpi:%s density:%s", Float.valueOf(displayMetrics.scaledDensity), Integer.valueOf(displayMetrics.densityDpi), Float.valueOf(displayMetrics.density));
        AppMethodBeat.o(141200);
        return format;
    }

    private static void d(Field field) {
        AppMethodBeat.i(141201);
        if (NDi) {
            AppMethodBeat.o(141201);
            return;
        }
        try {
            field.setAccessible(true);
            Field declaredField = Field.class.getDeclaredField("accessFlags");
            declaredField.setAccessible(true);
            declaredField.setInt(field, field.getModifiers() & -17);
            AppMethodBeat.o(141201);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMDensityManager", e2, "", new Object[0]);
            NDi = true;
            AppMethodBeat.o(141201);
        }
    }

    public static boolean gvs() {
        AppMethodBeat.i(141202);
        if (!NCT || gvt()) {
            AppMethodBeat.o(141202);
            return false;
        }
        AppMethodBeat.o(141202);
        return true;
    }

    public static boolean gvt() {
        AppMethodBeat.i(141203);
        String str = Build.BRAND;
        if (!Util.isNullOrNil(str)) {
            if (NDj) {
                AppMethodBeat.o(141203);
                return true;
            } else if (gvk() && ao.Pi()) {
                Log.i("MicroMsg.MMDensityManager", "dancy huaweiSpecial all!!");
                AppMethodBeat.o(141203);
                return true;
            } else if (gvl() && NDb) {
                AppMethodBeat.o(141203);
                return true;
            } else if (str.contains("samsung") && Build.VERSION.SDK_INT == 23) {
                AppMethodBeat.o(141203);
                return true;
            }
        }
        AppMethodBeat.o(141203);
        return false;
    }

    public static void ajy(int i2) {
        AppMethodBeat.i(141204);
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(NCY, i2);
        AppMethodBeat.o(141204);
    }

    public static int gvu() {
        AppMethodBeat.i(141205);
        int i2 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt(NCY, 400);
        AppMethodBeat.o(141205);
        return i2;
    }

    static /* synthetic */ boolean gvv() {
        AppMethodBeat.i(141206);
        zh zhVar = new zh();
        EventCenter.instance.publish(zhVar);
        if (zhVar.efu.dya) {
            AppMethodBeat.o(141206);
            return true;
        }
        AppMethodBeat.o(141206);
        return false;
    }

    static /* synthetic */ boolean gvw() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(141207);
        if (Util.getInt(d.cRY().b("clicfg_screen_adaptive_huawei_three", "1", false, true), 1) > 0) {
            Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360!!");
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecial360 change killSelfAndCallUp now:%s, original:%s", Boolean.valueOf(z), Boolean.valueOf(gvl()));
        if (Util.getInt(d.cRY().b("clicfg_screen_adaptive_huawei_four", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 1) > 0) {
            Log.i("MicroMsg.MMDensityManager", "isOpenHuaWeiSpecialAll!!");
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("MicroMsg.MMDensityManager", "nowisOpenHuaWeiSpecialAll change killSelfAndCallUp now:%s, original:%s", Boolean.valueOf(z2), Boolean.valueOf(gvk()));
        if (z == gvl() && z2 == gvk()) {
            AppMethodBeat.o(141207);
            return false;
        }
        AppMethodBeat.o(141207);
        return true;
    }

    static /* synthetic */ void gvx() {
        AppMethodBeat.i(141208);
        e.INSTANCE.idkeyStat(1055, 1, 1, false);
        Log.i("MicroMsg.MMDensityManager", "killSelfAndCallUp, mIcheckDensitylistener:%s", NDc);
        if (NDc != null) {
            NDc.Wu();
        }
        AppMethodBeat.o(141208);
    }

    static /* synthetic */ boolean gvy() {
        AppMethodBeat.i(141209);
        int i2 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt(NCV, 0);
        ao.gJO();
        int i3 = ao.gJO().densityDpi;
        if (i2 == 0) {
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(NCV, i3);
        }
        Log.i("MicroMsg.MMDensityManager", "dancy densityChangeNew, mDensityDpi:%s,  mCurrentDensityDpi:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 || i2 == i3) {
            AppMethodBeat.o(141209);
            return false;
        }
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(NCV, i3);
        AppMethodBeat.o(141209);
        return true;
    }
}
