package com.tencent.xweb.internal;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.e;
import java.util.regex.Pattern;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class a {

    public static class b {
        public int SCI = -1;
        public int SCJ = -1;
        public int SCK = -1;
        public int SCL = -1;
        public int SCM = -1;
        public int SCN = -1;
        public int SCO = -1;
        public int SCP = -1;
        public int SCQ = -1;
        public int SCR = -1;
        public String SCS = "";
        public String SCT = "";
        public int SCU = -1;
        public int SCV = -1;
        public int SCW = -1;
        public int SCX = -1;
        public int SCY = -1;
        public int SCZ = -1;
        public int SDa = -1;
        public double SDb = -1.0d;
        public double SDc = -1.0d;
        public String SDd = "";
        public String SDe = "";
        public int SDf = -1;
        public int SDg = -1;
        public int SDh = -1;
        public int SDi = -1;
        public String SDj = null;
        public String SDk = null;
        public String SDl = null;
        public String SDm = null;
        public int SDn = -1;
        public int SDo = -1;
        public String SDp;
        public String SDq;

        public String htv() {
            AppMethodBeat.i(156951);
            String runtimeAbi = XWalkEnvironment.getRuntimeAbi();
            AppMethodBeat.o(156951);
            return runtimeAbi;
        }

        public final boolean htw() {
            AppMethodBeat.i(156952);
            boolean Ep = Ep(false);
            AppMethodBeat.o(156952);
            return Ep;
        }

        public final boolean Ep(boolean z) {
            int i2;
            AppMethodBeat.i(219065);
            int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
            int installedNewstVersionForPredownAbi = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
            int tbsSDKVersion = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
            int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
            if (XWalkEnvironment.getApplicationContext().getApplicationInfo() != null) {
                i2 = XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion;
            } else {
                i2 = 0;
            }
            boolean z2 = z || bd(XWalkEnvironment.getGrayValue(), this.SCU, this.SCV);
            if (!bd(installedNewstVersionForCurAbi, this.SCK, this.SCL) || !bd(installedNewstVersionForPredownAbi, this.SCM, this.SCN) || !bd(XWalkEnvironment.SDK_VERSION, this.SCI, this.SCJ) || !bd(tbsSDKVersion, this.SDf, this.SDg) || !bd(installedTbsCoreVersion, this.SDh, this.SDi) || !bd(Build.VERSION.SDK_INT, this.SCO, this.SCP) || !bd(i2, this.SCQ, this.SCR) || !z2 || !bd(XWalkEnvironment.getTodayGrayValue(), this.SCW, this.SCX) || bsu(this.SCS) || oe(this.SDd, XWalkEnvironment.getPackageName()) || !hty()) {
                AppMethodBeat.o(219065);
                return false;
            } else if (this.SDa > 0 && XWalkEnvironment.getUserType() != this.SDa) {
                AppMethodBeat.o(219065);
                return false;
            } else if (this.SCT != null && this.SCT.trim() != null && !this.SCT.trim().isEmpty() && !bsu(this.SCT)) {
                AppMethodBeat.o(219065);
                return false;
            } else if (this.SDe != null && this.SDe.trim() != null && !this.SDe.trim().isEmpty() && !oe(this.SDe, XWalkEnvironment.getPackageName())) {
                AppMethodBeat.o(219065);
                return false;
            } else if ((this.SCY > 0 || this.SCZ > 0) && !bd(XWalkEnvironment.getChromiunVersion(), this.SCY, this.SCZ)) {
                AppMethodBeat.o(219065);
                return false;
            } else if ((htx() || !TextUtils.isEmpty(this.SDk)) && !od(this.SDk, htv())) {
                Log.i("xweb.internal.ConfigDef", "not match runtimeabis, white abis is " + this.SDk + ", cur runtime abi is " + XWalkEnvironment.getRuntimeAbi());
                AppMethodBeat.o(219065);
                return false;
            } else if (!TextUtils.isEmpty(this.SDj) && !od(this.SDj, XWalkEnvironment.getDeviceAbi())) {
                Log.i("xweb.internal.ConfigDef", "not match deviceAbis, white abis is " + this.SDj + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
                AppMethodBeat.o(219065);
                return false;
            } else if (!TextUtils.isEmpty(this.SDm) && od(this.SDm, XWalkEnvironment.getRuntimeAbi())) {
                Log.i("xweb.internal.ConfigDef", " match blackRuntimeAbis, black abis is " + this.SDm + ", cur runtime abi is " + htv());
                AppMethodBeat.o(219065);
                return false;
            } else if (TextUtils.isEmpty(this.SDl) || !od(this.SDl, XWalkEnvironment.getDeviceAbi())) {
                int appClientVersion = XWalkEnvironment.getAppClientVersion();
                if (appClientVersion > 0 && !bd(appClientVersion, this.SDn, this.SDo)) {
                    Log.i("xweb.internal.ConfigDef", " match AppClientVersion, failed cur client ver is ".concat(String.valueOf(appClientVersion)));
                    AppMethodBeat.o(219065);
                    return false;
                } else if (!TextUtils.isEmpty(this.SDp) && !XWalkEnvironment.containsAppInfo(this.SDp)) {
                    Log.i("xweb.internal.ConfigDef", " match appInfoWhiteList failed  ");
                    AppMethodBeat.o(219065);
                    return false;
                } else if (TextUtils.isEmpty(this.SDq) || !XWalkEnvironment.containsAppInfo(this.SDq)) {
                    AppMethodBeat.o(219065);
                    return true;
                } else {
                    Log.i("xweb.internal.ConfigDef", " match appInfoBlackList failed  ");
                    AppMethodBeat.o(219065);
                    return false;
                }
            } else {
                Log.i("xweb.internal.ConfigDef", " match blackDeviceAbis, black abis is " + this.SDl + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
                AppMethodBeat.o(219065);
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public boolean htx() {
            return false;
        }

        private static boolean od(String str, String str2) {
            AppMethodBeat.i(156953);
            if (str == null) {
                AppMethodBeat.o(156953);
                return false;
            }
            String[] split = str.split("\\|");
            if (split == null || split.length < 0) {
                AppMethodBeat.o(156953);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                AppMethodBeat.o(156953);
                return false;
            } else {
                String trim = str2.trim();
                for (String str3 : split) {
                    if (!TextUtils.isEmpty(str3) && str3.trim().equalsIgnoreCase(trim)) {
                        AppMethodBeat.o(156953);
                        return true;
                    }
                }
                AppMethodBeat.o(156953);
                return false;
            }
        }

        private static boolean bsu(String str) {
            AppMethodBeat.i(156954);
            String str2 = "";
            if (Build.BRAND != null) {
                str2 = str2 + Build.BRAND;
            }
            if (Build.MODEL != null) {
                str2 = str2 + " " + Build.MODEL;
            }
            if (Build.MANUFACTURER != null) {
                str2 = str2 + " " + Build.MANUFACTURER;
            }
            if (str == null || str2 == null || str.isEmpty()) {
                AppMethodBeat.o(156954);
                return false;
            }
            boolean oe = oe(str, str2);
            AppMethodBeat.o(156954);
            return oe;
        }

        private static boolean oe(String str, String str2) {
            boolean z = false;
            AppMethodBeat.i(156955);
            if (str == null || str.isEmpty() || str.trim() == null || str.trim().isEmpty()) {
                AppMethodBeat.o(156955);
            } else if (str2 == null || str2.isEmpty()) {
                AppMethodBeat.o(156955);
            } else {
                try {
                    z = Pattern.compile(str).matcher(str2.toUpperCase()).find();
                } catch (Exception e2) {
                    XWalkEnvironment.addXWalkInitializeLog("ConfigDef", " _IsMatchRex compile strRex failed");
                }
                AppMethodBeat.o(156955);
            }
            return z;
        }

        private static boolean bd(int i2, int i3, int i4) {
            if (i4 > 0 && i2 > i4) {
                return false;
            }
            if (i3 <= 0 || i2 >= i3) {
                return true;
            }
            return false;
        }

        private static boolean G(double d2) {
            if (d2 < 0.0d || d2 >= 24.0d) {
                return false;
            }
            return true;
        }

        private boolean hty() {
            AppMethodBeat.i(219066);
            if (G(this.SDb) || G(this.SDc)) {
                double htS = e.htS();
                if (this.SDc > 0.0d && htS > this.SDc) {
                    AppMethodBeat.o(219066);
                    return false;
                } else if (this.SDb <= 0.0d || htS >= this.SDb) {
                    AppMethodBeat.o(219066);
                    return true;
                } else {
                    AppMethodBeat.o(219066);
                    return false;
                }
            } else {
                AppMethodBeat.o(219066);
                return true;
            }
        }
    }

    public static class c extends b {
        static String SDr = null;

        /* access modifiers changed from: protected */
        @Override // com.tencent.xweb.internal.a.b
        public final boolean htx() {
            AppMethodBeat.i(156956);
            boolean is64BitRuntime = XWalkEnvironment.is64BitRuntime();
            AppMethodBeat.o(156956);
            return is64BitRuntime;
        }

        @Override // com.tencent.xweb.internal.a.b
        public final String htv() {
            AppMethodBeat.i(156957);
            if (!TextUtils.isEmpty(SDr)) {
                String str = SDr;
                AppMethodBeat.o(156957);
                return str;
            }
            String htv = super.htv();
            AppMethodBeat.o(156957);
            return htv;
        }

        public static void bsv(String str) {
            SDr = str;
        }

        public static boolean htz() {
            AppMethodBeat.i(219067);
            if (!XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(SDr)) {
                AppMethodBeat.o(219067);
                return true;
            }
            AppMethodBeat.o(219067);
            return false;
        }
    }

    /* renamed from: com.tencent.xweb.internal.a$a  reason: collision with other inner class name */
    public static class C2231a {
        public b SCE = new b();
        public String SCF;
        public String SCG;
        public String SCH;

        public C2231a() {
            AppMethodBeat.i(156950);
            AppMethodBeat.o(156950);
        }
    }
}
