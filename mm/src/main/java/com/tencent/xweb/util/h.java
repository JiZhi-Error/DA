package com.tencent.xweb.util;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.p.ah;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.af;
import com.tencent.xweb.internal.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class h {
    public static String SAg = "";
    private static boolean SEH = false;
    static WebView.c SEI = WebView.c.WV_KIND_NONE;
    static af SEJ = null;
    static boolean SEK = false;
    public static String sessionId = "";

    public static class b {

        public static class a {
            public static int ID = 19307;
            public static int SEM = 1;
            public static int SEN = 2;
            public static int SEO = 1;
            public static int SEP = 2;
        }
    }

    public static void h(WebView.c cVar) {
        SEI = cVar;
    }

    public static class a {
        int SEL = 0;
        StringBuilder bDv = new StringBuilder();

        public a(int i2) {
            AppMethodBeat.i(175648);
            this.SEL = i2;
            AppMethodBeat.o(175648);
        }

        public final a eL(Object obj) {
            AppMethodBeat.i(175649);
            if (this.bDv.length() > 0) {
                this.bDv.append(",");
            }
            this.bDv.append(obj.toString());
            AppMethodBeat.o(175649);
            return this;
        }
    }

    private static boolean htU() {
        AppMethodBeat.i(157015);
        if (SEI != WebView.c.WV_KIND_CW || WebView.getCurWebType() == SEI) {
            AppMethodBeat.o(157015);
            return false;
        }
        AppMethodBeat.o(157015);
        return true;
    }

    private static boolean htV() {
        AppMethodBeat.i(157016);
        if (WebView.getCurWebType() != WebView.c.WV_KIND_CW || WebView.getCurWebType() == SEI) {
            AppMethodBeat.o(157016);
            return false;
        }
        AppMethodBeat.o(157016);
        return true;
    }

    public static void bsG(String str) {
        if (str != null) {
            SAg = str;
        }
    }

    public static void mO(int i2, int i3) {
        AppMethodBeat.i(157017);
        if (SEJ == null) {
            AppMethodBeat.o(157017);
            return;
        }
        SharedPreferences mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld("REPORT_DAILY");
        String str = "id_" + i2 + "_key_" + i3;
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (format.equals(mMKVSharedTransportOld.getString(str, ""))) {
            AppMethodBeat.o(157017);
            return;
        }
        SEJ.n((long) i2, (long) i3, 1);
        mMKVSharedTransportOld.edit().putString(str, format).commit();
        AppMethodBeat.o(157017);
    }

    public static void htW() {
        AppMethodBeat.i(219087);
        String runtimeAbi = XWalkEnvironment.getRuntimeAbi();
        String str = XWalkEnvironment.RUNTIME_ABI_ARM32_STR.equals(runtimeAbi) ? XWalkEnvironment.RUNTIME_ABI_ARM64_STR : XWalkEnvironment.RUNTIME_ABI_ARM32_STR;
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion(runtimeAbi);
        int installedNewstVersion2 = XWalkEnvironment.getInstalledNewstVersion(str);
        Log.i("WXWebReporter", "reportCoreInstalled cur abi ver = " + installedNewstVersion + ", predown ver = " + installedNewstVersion2);
        boolean of = c.of("report_core_ver", String.valueOf(installedNewstVersion));
        if (c.bsx("report_core_daily") || of) {
            if (installedNewstVersion <= 0) {
                aJ(1367, 251);
            } else {
                aJ(1367, (long) ((installedNewstVersion % 100) + 0));
            }
        }
        boolean of2 = c.of("report_core_ver_predown", String.valueOf(installedNewstVersion2));
        if (c.bsx("report_core_daily_predown") || of2) {
            if (installedNewstVersion2 <= 0) {
                aJ(1367, 252);
            } else {
                aJ(1367, (long) ((installedNewstVersion2 % 100) + 100));
            }
        }
        if (XWalkEnvironment.RUNTIME_ABI_ARM32_STR.equalsIgnoreCase(runtimeAbi)) {
            String deviceAbi = XWalkEnvironment.getDeviceAbi();
            if (XWalkEnvironment.RUNTIME_ABI_ARM32_STR.equalsIgnoreCase(deviceAbi)) {
                mO(1367, 253);
                AppMethodBeat.o(219087);
                return;
            } else if (XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(deviceAbi)) {
                mO(1367, 254);
            }
        }
        AppMethodBeat.o(219087);
    }

    public static void i(WebView.c cVar) {
        String concat;
        String str;
        int i2;
        AppMethodBeat.i(157018);
        if (SEJ == null) {
            AppMethodBeat.o(157018);
            return;
        }
        if (cVar == WebView.c.WV_KIND_CW) {
            concat = "REPORT_APK_VER_TIME";
        } else {
            concat = "REPORT_APK_VER_TIME_".concat(String.valueOf(cVar));
        }
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String string = XWalkEnvironment.getSharedPreferences().getString(concat, "");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        if (cVar == WebView.c.WV_KIND_CW) {
            int i3 = XWalkEnvironment.getSharedPreferences().getInt("REPORT_XWEB_APK_VER", 0);
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            if (availableVersion <= 0) {
                AppMethodBeat.o(157018);
                return;
            } else if (availableVersion != i3 || !format.equals(str)) {
                SEJ.n(577, (long) ((availableVersion % 50) + 100), 1);
                XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", availableVersion).commit();
            }
        }
        if (format.equals(str)) {
            AppMethodBeat.o(157018);
            return;
        }
        if (cVar == WebView.c.WV_KIND_CW) {
            if (XWalkEnvironment.getAvailableVersion() <= 0) {
                AppMethodBeat.o(157018);
                return;
            }
            i2 = 99;
        } else if (cVar == WebView.c.WV_KIND_SYS) {
            i2 = 97;
        } else if (cVar == WebView.c.WV_KIND_X5) {
            i2 = 98;
        } else {
            AppMethodBeat.o(157018);
            return;
        }
        SEJ.n(577, (long) i2, 1);
        XWalkEnvironment.getSharedPreferences().edit().putString(concat, format).commit();
        AppMethodBeat.o(157018);
    }

    public static void a(af afVar) {
        SEJ = afVar;
    }

    public static void dz(int i2, String str) {
        AppMethodBeat.i(157019);
        if (SEJ != null) {
            SEJ.kvStat(i2, str);
        }
        AppMethodBeat.o(157019);
    }

    public static void OQ(long j2) {
        AppMethodBeat.i(157020);
        if (SEJ != null) {
            SEJ.n(577, j2, 1);
        }
        AppMethodBeat.o(157020);
    }

    public static void s(long j2, long j3, long j4) {
        AppMethodBeat.i(157021);
        if (SEJ != null) {
            SEJ.n(j2, j3, j4);
        }
        AppMethodBeat.o(157021);
    }

    public static void aJ(long j2, long j3) {
        AppMethodBeat.i(219088);
        Log.i("WXWebReporter", "report idkey id = " + j2 + " key = " + j3 + " value = 1");
        if (SEJ != null) {
            SEJ.n(j2, j3, 1);
        }
        AppMethodBeat.o(219088);
    }

    public static void bsH(String str) {
        int i2 = 73;
        AppMethodBeat.i(157022);
        if (SEJ != null) {
            SEJ.n(577, 0, 1);
            if (SAg.equals("toolsmp") && str != null && bsI(str) == 2) {
                SEJ.n(903, 101, 1);
            }
            if (SAg.equals("toolsmp")) {
                if (WebView.getCurWebType() == WebView.c.WV_KIND_CW) {
                    SEJ.n(903, 105, 1);
                } else if (WebView.getCurWebType() == WebView.c.WV_KIND_X5) {
                    SEJ.n(903, 104, 1);
                }
            } else if (SAg.equals("tools") && str != null && bsI(str) == 1) {
                SEJ.n(903, 103, 1);
            }
            if (!SEH) {
                if (SAg.equals("tools")) {
                    i2 = 70;
                } else if (!SAg.equals("appbrand") && !SAg.equals("support")) {
                    i2 = -1;
                }
                int ordinal = WebView.getCurWebType().ordinal() - 1;
                if (i2 >= 70 && ordinal >= 0) {
                    SEH = true;
                    mO(ah.CTRL_INDEX, i2 + ordinal);
                }
            }
        }
        AppMethodBeat.o(157022);
    }

    private static int htX() {
        AppMethodBeat.i(157023);
        int i2 = -1;
        if (SAg.equals("mm")) {
            i2 = 30;
        } else if (SAg.equals("tools")) {
            i2 = 36;
        } else if (SAg.equals("toolsmp")) {
            i2 = 42;
        } else if (SAg.equals("appbrand")) {
            i2 = 48;
        } else if (SAg.equals("support")) {
            i2 = 54;
        }
        AppMethodBeat.o(157023);
        return i2;
    }

    public static synchronized void a(String str, WebView webView) {
        int i2;
        int i3;
        synchronized (h.class) {
            AppMethodBeat.i(175650);
            if (SEJ == null) {
                AppMethodBeat.o(175650);
            } else {
                if (!SEK) {
                    if ("toolsmp".equals(SAg)) {
                        if (htU()) {
                            mO(903, 106);
                        } else if (htV()) {
                            mO(903, 108);
                        }
                    }
                    int htX = htX();
                    int ordinal = WebView.getCurWebType().ordinal() - 1;
                    if (htX >= 30 && ordinal >= 0) {
                        SEK = true;
                        mO(903, htX + 3 + ordinal);
                    }
                }
                if (webView.isX5WrappedSysKernel()) {
                    if (SAg.equals("mm")) {
                        i2 = 79;
                        i3 = 74;
                    } else if (SAg.equals("tools")) {
                        i2 = 75;
                        i3 = 70;
                    } else if (SAg.equals("toolsmp")) {
                        i2 = 75;
                        i3 = 71;
                    } else if (SAg.equals("appbrand")) {
                        i2 = 77;
                        i3 = 72;
                    } else if (SAg.equals("support")) {
                        i2 = 78;
                        i3 = 73;
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        SEJ.n(903, (long) i3, 1);
                    }
                    if (i2 != 0) {
                        mO(903, i2);
                    }
                }
                if (str != null && "https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(str.trim())) {
                    SEJ.n(903, 102, 1);
                }
                int htX2 = htX();
                int ordinal2 = WebView.getCurWebType().ordinal() - 1;
                if (htX2 >= 30 && ordinal2 >= 0) {
                    SEJ.n(903, (long) (htX2 + 0 + ordinal2), 1);
                }
                if ("toolsmp".equals(SAg)) {
                    if (htU()) {
                        SEJ.n(903, 107, 1);
                        AppMethodBeat.o(175650);
                    } else if (htV()) {
                        SEJ.n(903, 109, 1);
                    }
                }
                AppMethodBeat.o(175650);
            }
        }
    }

    public static void htY() {
        AppMethodBeat.i(157025);
        if (SEJ != null) {
            SEJ.n(577, 1, 1);
        }
        AppMethodBeat.o(157025);
    }

    public static void OR(long j2) {
        AppMethodBeat.i(157026);
        if (SEJ != null && j2 > 0 && j2 < 300000) {
            SEJ.bc(2, 3, (int) j2);
        }
        AppMethodBeat.o(157026);
    }

    public static void htZ() {
        AppMethodBeat.i(157027);
        if (SEJ != null) {
            SEJ.n(577, 46, 1);
        }
        AppMethodBeat.o(157027);
    }

    public static void hua() {
        AppMethodBeat.i(157028);
        if (SEJ != null) {
            SEJ.n(577, 47, 1);
        }
        AppMethodBeat.o(157028);
    }

    public static void OS(long j2) {
        AppMethodBeat.i(157029);
        if (SEJ != null && j2 > 0 && j2 < 300000) {
            SEJ.bc(48, 49, (int) j2);
        }
        AppMethodBeat.o(157029);
    }

    public static void hub() {
        AppMethodBeat.i(157030);
        if (SEJ != null) {
            SEJ.n(577, 42, 1);
        }
        AppMethodBeat.o(157030);
    }

    public static void huc() {
        AppMethodBeat.i(157031);
        if (SEJ != null) {
            SEJ.n(577, 43, 1);
        }
        AppMethodBeat.o(157031);
    }

    public static void OT(long j2) {
        AppMethodBeat.i(157032);
        if (SEJ != null && j2 > 0 && j2 < 300000) {
            SEJ.bc(44, 45, (int) j2);
        }
        AppMethodBeat.o(157032);
    }

    public static void hP(String str, int i2) {
        AppMethodBeat.i(157033);
        if (SEJ != null) {
            bsH(str);
            sessionId = UUID.randomUUID().toString().replace("-", "");
            SEJ.n(577, 4, 1);
            SEJ.a(XWalkEnvironment.getAvailableVersion(), bsI(str), sessionId, JsRuntime.hsu() == null ? 100 : JsRuntime.hsu().ordinal(), 0, 0, 0, i2);
        }
        AppMethodBeat.o(157033);
    }

    public static void d(String str, int i2, long j2, int i3) {
        AppMethodBeat.i(157034);
        if (SEJ != null) {
            htY();
            SEJ.n(577, 5, 1);
            SEJ.kvStat(15003, "");
            SEJ.a(XWalkEnvironment.getAvailableVersion(), bsI(str), sessionId, JsRuntime.hsu() == null ? 100 : JsRuntime.hsu().ordinal(), 1, i2, (int) j2, i3);
        }
        AppMethodBeat.o(157034);
    }

    public static void u(String str, long j2, int i2) {
        AppMethodBeat.i(157035);
        OR(j2);
        if (SEJ != null && j2 > 0 && j2 < 300000) {
            SEJ.bc(6, 7, (int) j2);
            SEJ.a(XWalkEnvironment.getAvailableVersion(), bsI(str), sessionId, JsRuntime.hsu() == null ? 100 : JsRuntime.hsu().ordinal(), 1, 0, (int) j2, i2);
        }
        AppMethodBeat.o(157035);
    }

    public static int bsI(String str) {
        AppMethodBeat.i(157036);
        if (str.startsWith("https://servicewechat.com/")) {
            AppMethodBeat.o(157036);
            return 0;
        } else if (str.startsWith("http://mp.weixin.qq.com/") || str.startsWith("https://mp.weixin.qq.com/") || str.startsWith("https://servicewechat.com/preload/") || str.startsWith("http://mp.weixinbridge.com/")) {
            AppMethodBeat.o(157036);
            return 1;
        } else {
            AppMethodBeat.o(157036);
            return 2;
        }
    }

    public static void hud() {
        AppMethodBeat.i(157037);
        if (SEJ != null) {
            SEJ.n(577, 52, 1);
        }
        AppMethodBeat.o(157037);
    }

    public static void hue() {
        AppMethodBeat.i(157038);
        if (SEJ != null) {
            SEJ.n(577, 53, 1);
        }
        AppMethodBeat.o(157038);
    }

    public static void huf() {
        AppMethodBeat.i(157039);
        if (SEJ != null) {
            SEJ.n(577, 54, 1);
        }
        AppMethodBeat.o(157039);
    }

    public static void hug() {
        AppMethodBeat.i(157040);
        if (SEJ != null) {
            SEJ.n(577, 55, 1);
        }
        AppMethodBeat.o(157040);
    }

    public static void huh() {
        AppMethodBeat.i(157041);
        if (SEJ != null) {
            SEJ.n(577, 56, 1);
        }
        AppMethodBeat.o(157041);
    }

    public static void hui() {
        AppMethodBeat.i(157042);
        if (SEJ != null) {
            SEJ.n(577, 57, 1);
        }
        AppMethodBeat.o(157042);
    }

    public static void huj() {
        AppMethodBeat.i(157043);
        if (SEJ != null) {
            SEJ.n(577, 58, 1);
        }
        AppMethodBeat.o(157043);
    }

    public static void huk() {
        AppMethodBeat.i(157044);
        if (SEJ != null) {
            SEJ.n(577, 59, 1);
        }
        AppMethodBeat.o(157044);
    }

    public static void bY(int i2, boolean z) {
        AppMethodBeat.i(157045);
        if (SEJ != null) {
            int i3 = 0;
            switch (i2) {
                case 0:
                    if (!z) {
                        i3 = JsApiGetBackgroundAudioState.CTRL_INDEX;
                        break;
                    } else {
                        i3 = TbsListener.ErrorCode.STARTDOWNLOAD_4;
                        break;
                    }
                case 1:
                    if (!z) {
                        i3 = 160;
                        break;
                    } else {
                        i3 = TbsListener.ErrorCode.STARTDOWNLOAD_5;
                        break;
                    }
                case 2:
                    if (!z) {
                        i3 = 161;
                        break;
                    } else {
                        i3 = TbsListener.ErrorCode.STARTDOWNLOAD_6;
                        break;
                    }
                case 3:
                    if (!z) {
                        i3 = TbsListener.ErrorCode.STARTDOWNLOAD_3;
                        break;
                    } else {
                        i3 = 166;
                        break;
                    }
            }
            if (i3 > 0) {
                SEJ.n(577, (long) i3, 1);
            }
        }
        AppMethodBeat.o(157045);
    }

    public static void bZ(int i2, boolean z) {
        AppMethodBeat.i(157046);
        if (SEJ != null) {
            int i3 = 0;
            switch (i2) {
                case 0:
                    if (!z) {
                        i3 = 151;
                        break;
                    } else {
                        i3 = 155;
                        break;
                    }
                case 1:
                    if (!z) {
                        i3 = 152;
                        break;
                    } else {
                        i3 = 156;
                        break;
                    }
                case 2:
                    if (!z) {
                        i3 = 153;
                        break;
                    } else {
                        i3 = 157;
                        break;
                    }
                case 3:
                    if (!z) {
                        i3 = 154;
                        break;
                    } else {
                        i3 = 158;
                        break;
                    }
            }
            if (i3 > 0) {
                SEJ.n(577, (long) i3, 1);
            }
        }
        AppMethodBeat.o(157046);
    }

    public static void hul() {
        AppMethodBeat.i(157047);
        if (SEJ != null) {
            SEJ.n(577, 167, 1);
        }
        AppMethodBeat.o(157047);
    }

    public static void hum() {
        AppMethodBeat.i(157048);
        if (SEJ != null) {
            SEJ.n(577, 9, 1);
        }
        AppMethodBeat.o(157048);
    }

    public static void OU(long j2) {
        AppMethodBeat.i(157049);
        if (SEJ != null && SEJ != null && j2 > 0 && j2 < 600000) {
            SEJ.bc(11, 12, (int) j2);
        }
        AppMethodBeat.o(157049);
    }

    public static void hun() {
        AppMethodBeat.i(157050);
        if (SEJ != null) {
            SEJ.n(577, 10, 1);
        }
        AppMethodBeat.o(157050);
    }

    public static void huo() {
        AppMethodBeat.i(157051);
        if (SEJ != null) {
            SEJ.n(577, 60, 1);
        }
        AppMethodBeat.o(157051);
    }

    public static void a(WebView.c cVar, int i2) {
        int i3 = 0;
        AppMethodBeat.i(175651);
        if (c.bsx("kv_" + b.a.ID + cVar.toString() + "_" + i2)) {
            a aVar = new a(b.a.ID);
            aVar.eL(Integer.valueOf(i2));
            if (cVar == WebView.c.WV_KIND_CW) {
                aVar.eL(Integer.valueOf(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
            } else if (cVar == WebView.c.WV_KIND_X5) {
                try {
                    i3 = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
                } catch (Exception e2) {
                    Log.e("onUseCoreFailed", "get tbs core version failed");
                }
                aVar.eL(Integer.valueOf(i3));
            } else if (cVar == WebView.c.WV_KIND_SYS) {
                aVar.eL(Integer.valueOf(XWalkEnvironment.safeGetChromiunVersion()));
            } else {
                aVar.eL(0);
            }
            aVar.eL(Integer.valueOf((int) XWalkEnvironment.SDK_VERSION));
            if (XWalkEnvironment.RUNTIME_ABI_ARM32_STR.equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
                aVar.eL(Integer.valueOf(b.a.SEO));
            } else if (XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
                aVar.eL(Integer.valueOf(b.a.SEP));
            }
            aVar.eL(Integer.valueOf(cVar.ordinal()));
            dz(aVar.SEL, aVar.bDv.toString());
        }
        AppMethodBeat.o(175651);
    }

    public static void j(WebView.c cVar) {
        AppMethodBeat.i(157052);
        if (SEJ == null) {
            AppMethodBeat.o(157052);
            return;
        }
        if (cVar == WebView.c.WV_KIND_CW) {
            SEJ.n(577, 61, 1);
            mO(ah.CTRL_INDEX, 62);
        }
        AppMethodBeat.o(157052);
    }

    public static void hup() {
        AppMethodBeat.i(157053);
        if (SEJ != null) {
            SEJ.n(577, 20, 1);
        }
        AppMethodBeat.o(157053);
    }

    public static void OV(long j2) {
        AppMethodBeat.i(157054);
        if (SEJ != null && SEJ != null && j2 > 0 && j2 < 600000) {
            SEJ.bc(22, 23, (int) j2);
        }
        AppMethodBeat.o(157054);
    }

    public static void huq() {
        AppMethodBeat.i(157055);
        if (SEJ != null) {
            SEJ.n(577, 21, 1);
        }
        AppMethodBeat.o(157055);
    }

    public static void hur() {
        AppMethodBeat.i(157056);
        if (SEJ != null) {
            SEJ.n(577, 25, 1);
        }
        AppMethodBeat.o(157056);
    }

    public static void OW(long j2) {
        AppMethodBeat.i(157057);
        if (SEJ != null && SEJ != null && j2 > 0 && j2 < 600000) {
            SEJ.bc(27, 28, (int) j2);
        }
        AppMethodBeat.o(157057);
    }

    public static void hus() {
        AppMethodBeat.i(157058);
        if (SEJ != null) {
            SEJ.n(577, 26, 1);
        }
        AppMethodBeat.o(157058);
    }

    public static void hut() {
        AppMethodBeat.i(157059);
        if (SEJ != null) {
            SEJ.n(577, 14, 1);
        }
        AppMethodBeat.o(157059);
    }

    public static void huu() {
        AppMethodBeat.i(157060);
        if (SEJ != null) {
            SEJ.n(577, 15, 1);
        }
        AppMethodBeat.o(157060);
    }

    public static void OX(long j2) {
        AppMethodBeat.i(157061);
        if (SEJ != null && SEJ != null && j2 > 0 && j2 < 120000) {
            SEJ.bc(16, 17, (int) j2);
        }
        AppMethodBeat.o(157061);
    }

    public static void huv() {
        AppMethodBeat.i(157062);
        if (SEJ == null) {
            AppMethodBeat.o(157062);
            return;
        }
        SEJ.n(577, 83, 1);
        AppMethodBeat.o(157062);
    }

    public static void k(WebView.c cVar) {
        int i2;
        AppMethodBeat.i(157063);
        if (SEJ == null) {
            AppMethodBeat.o(157063);
            return;
        }
        switch (cVar) {
            case WV_KIND_CW:
                i2 = 82;
                break;
            case WV_KIND_X5:
                i2 = 81;
                break;
            case WV_KIND_SYS:
                i2 = 80;
                break;
            default:
                AppMethodBeat.o(157063);
                return;
        }
        SEJ.n(577, (long) i2, 1);
        AppMethodBeat.o(157063);
    }

    public static void huw() {
        AppMethodBeat.i(157064);
        if (SEJ == null) {
            AppMethodBeat.o(157064);
            return;
        }
        SEJ.n(577, 87, 1);
        AppMethodBeat.o(157064);
    }

    public static void l(WebView.c cVar) {
        int i2;
        AppMethodBeat.i(157065);
        if (SEJ == null) {
            AppMethodBeat.o(157065);
            return;
        }
        switch (cVar) {
            case WV_KIND_CW:
                i2 = 86;
                break;
            case WV_KIND_X5:
                i2 = 85;
                break;
            case WV_KIND_SYS:
                i2 = 84;
                break;
            default:
                AppMethodBeat.o(157065);
                return;
        }
        SEJ.n(577, (long) i2, 1);
        AppMethodBeat.o(157065);
    }

    public static void hux() {
        AppMethodBeat.i(157066);
        if (SEJ != null) {
            SEJ.n(577, 180, 1);
        }
        AppMethodBeat.o(157066);
    }

    public static void huy() {
        AppMethodBeat.i(157067);
        if (SEJ != null) {
            SEJ.n(577, 181, 1);
        }
        AppMethodBeat.o(157067);
    }

    public static void huz() {
        AppMethodBeat.i(157068);
        if (SEJ != null) {
            SEJ.n(577, 182, 1);
        }
        AppMethodBeat.o(157068);
    }

    public static void huA() {
        AppMethodBeat.i(157069);
        if (SEJ != null) {
            SEJ.n(577, 183, 1);
        }
        AppMethodBeat.o(157069);
    }

    public static void huB() {
        AppMethodBeat.i(157070);
        if (SEJ != null) {
            SEJ.n(577, 184, 1);
        }
        AppMethodBeat.o(157070);
    }

    public static void huC() {
        AppMethodBeat.i(157071);
        if (SEJ != null) {
            SEJ.n(577, 189, 1);
        }
        AppMethodBeat.o(157071);
    }

    public static void huD() {
        AppMethodBeat.i(157072);
        if (SEJ != null) {
            SEJ.n(577, 190, 1);
        }
        AppMethodBeat.o(157072);
    }

    public static void dJ(String str, boolean z) {
        AppMethodBeat.i(219089);
        if (SEJ == null) {
            AppMethodBeat.o(219089);
            return;
        }
        int i2 = z ? 51 : 60;
        if (XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str)) {
            SEJ.n(577, 185, 1);
            AppMethodBeat.o(219089);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            SEJ.n(1068, (long) i2, 1);
            AppMethodBeat.o(219089);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            SEJ.n(1071, (long) i2, 1);
            AppMethodBeat.o(219089);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            SEJ.n(1069, (long) i2, 1);
            AppMethodBeat.o(219089);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            SEJ.n(1070, (long) i2, 1);
            AppMethodBeat.o(219089);
        } else {
            if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
                SEJ.n(1544, (long) i2, 1);
            }
            AppMethodBeat.o(219089);
        }
    }

    public static void dK(String str, boolean z) {
        AppMethodBeat.i(219090);
        if (SEJ == null) {
            AppMethodBeat.o(219090);
            return;
        }
        int i2 = z ? 52 : 61;
        if (XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str)) {
            SEJ.n(577, 186, 1);
            AppMethodBeat.o(219090);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            SEJ.n(1068, (long) i2, 1);
            AppMethodBeat.o(219090);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            SEJ.n(1071, (long) i2, 1);
            AppMethodBeat.o(219090);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            SEJ.n(1069, (long) i2, 1);
            AppMethodBeat.o(219090);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            SEJ.n(1070, (long) i2, 1);
            AppMethodBeat.o(219090);
        } else {
            if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
                SEJ.n(1544, (long) i2, 1);
            }
            AppMethodBeat.o(219090);
        }
    }

    public static void dL(String str, boolean z) {
        AppMethodBeat.i(219091);
        if (SEJ == null) {
            AppMethodBeat.o(219091);
            return;
        }
        int i2 = z ? 54 : 62;
        if (XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str)) {
            SEJ.n(577, 187, 1);
            AppMethodBeat.o(219091);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            SEJ.n(1068, (long) i2, 1);
            AppMethodBeat.o(219091);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            SEJ.n(1071, (long) i2, 1);
            AppMethodBeat.o(219091);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            SEJ.n(1069, (long) i2, 1);
            AppMethodBeat.o(219091);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            SEJ.n(1070, (long) i2, 1);
            AppMethodBeat.o(219091);
        } else {
            if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
                SEJ.n(1544, (long) i2, 1);
            }
            AppMethodBeat.o(219091);
        }
    }

    public static void dM(String str, boolean z) {
        AppMethodBeat.i(219092);
        if (SEJ == null) {
            AppMethodBeat.o(219092);
            return;
        }
        int i2 = z ? 55 : 63;
        if (XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str)) {
            SEJ.n(577, 188, 1);
            AppMethodBeat.o(219092);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            SEJ.n(1068, (long) i2, 1);
            AppMethodBeat.o(219092);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            SEJ.n(1071, (long) i2, 1);
            AppMethodBeat.o(219092);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            SEJ.n(1069, (long) i2, 1);
            AppMethodBeat.o(219092);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            SEJ.n(1070, (long) i2, 1);
            AppMethodBeat.o(219092);
        } else {
            if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
                SEJ.n(1544, (long) i2, 1);
            }
            AppMethodBeat.o(219092);
        }
    }

    public static void bsJ(String str) {
        AppMethodBeat.i(219093);
        if (SEJ == null) {
            AppMethodBeat.o(219093);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            SEJ.n(1068, 57, 1);
            AppMethodBeat.o(219093);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            SEJ.n(1071, 57, 1);
            AppMethodBeat.o(219093);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            SEJ.n(1069, 57, 1);
            AppMethodBeat.o(219093);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            SEJ.n(1070, 57, 1);
            AppMethodBeat.o(219093);
        } else {
            if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
                SEJ.n(1544, 57, 1);
            }
            AppMethodBeat.o(219093);
        }
    }

    public static void dN(String str, boolean z) {
        AppMethodBeat.i(219094);
        if (SEJ == null) {
            AppMethodBeat.o(219094);
            return;
        }
        int i2 = z ? 59 : 65;
        if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            SEJ.n(1068, (long) i2, 1);
            AppMethodBeat.o(219094);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            SEJ.n(1071, (long) i2, 1);
            AppMethodBeat.o(219094);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            SEJ.n(1069, (long) i2, 1);
            AppMethodBeat.o(219094);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            SEJ.n(1070, (long) i2, 1);
            AppMethodBeat.o(219094);
        } else {
            if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
                SEJ.n(1544, (long) i2, 1);
            }
            AppMethodBeat.o(219094);
        }
    }

    public static void bsK(String str) {
        AppMethodBeat.i(157079);
        if (SEJ == null) {
            AppMethodBeat.o(157079);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            SEJ.n(1068, 66, 1);
            AppMethodBeat.o(157079);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            SEJ.n(1071, 66, 1);
            AppMethodBeat.o(157079);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            SEJ.n(1069, 66, 1);
            AppMethodBeat.o(157079);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            SEJ.n(1070, 66, 1);
            AppMethodBeat.o(157079);
        } else {
            if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
                SEJ.n(1544, 66, 1);
            }
            AppMethodBeat.o(157079);
        }
    }

    public static void bsL(String str) {
        AppMethodBeat.i(157080);
        if (str == null || str.isEmpty() || SEJ == null) {
            AppMethodBeat.o(157080);
        } else if (str.equalsIgnoreCase("ppt") || str.equalsIgnoreCase("pptx")) {
            SEJ.n(1068, 67, 1);
            AppMethodBeat.o(157080);
        } else if (str.equalsIgnoreCase("pdf")) {
            SEJ.n(1071, 67, 1);
            AppMethodBeat.o(157080);
        } else if (str.equalsIgnoreCase("doc") || str.equalsIgnoreCase("docx")) {
            SEJ.n(1069, 67, 1);
            AppMethodBeat.o(157080);
        } else {
            if (str.equalsIgnoreCase("xls") || str.equalsIgnoreCase("xlsx")) {
                SEJ.n(1070, 67, 1);
            }
            AppMethodBeat.o(157080);
        }
    }

    public static void bsM(String str) {
        AppMethodBeat.i(157081);
        if (str == null || str.isEmpty() || SEJ == null) {
            AppMethodBeat.o(157081);
        } else if (str.equalsIgnoreCase("ppt") || str.equalsIgnoreCase("pptx")) {
            SEJ.n(1068, 68, 1);
            AppMethodBeat.o(157081);
        } else if (str.equalsIgnoreCase("pdf")) {
            SEJ.n(1071, 68, 1);
            AppMethodBeat.o(157081);
        } else if (str.equalsIgnoreCase("doc") || str.equalsIgnoreCase("docx")) {
            SEJ.n(1069, 68, 1);
            AppMethodBeat.o(157081);
        } else {
            if (str.equalsIgnoreCase("xls") || str.equalsIgnoreCase("xlsx")) {
                SEJ.n(1070, 68, 1);
            }
            AppMethodBeat.o(157081);
        }
    }

    public static void huE() {
        AppMethodBeat.i(157082);
        if (SEJ == null) {
            AppMethodBeat.o(157082);
            return;
        }
        SEJ.n(577, 88, 1);
        AppMethodBeat.o(157082);
    }

    public static boolean asU(int i2) {
        return i2 == 15625 || i2 == 15626;
    }

    public static boolean eEa() {
        return SEJ != null;
    }

    public static void asV(int i2) {
        int i3;
        AppMethodBeat.i(157083);
        if (!"toolsmp".equals(SAg)) {
            AppMethodBeat.o(157083);
            return;
        }
        if (WebView.getCurWebType() == WebView.c.WV_KIND_CW) {
            i3 = 200;
        } else if (WebView.getCurWebType() == WebView.c.WV_KIND_X5) {
            i3 = 220;
        } else {
            AppMethodBeat.o(157083);
            return;
        }
        if (i2 < 0) {
            i2 = 3;
        } else if (i2 > 9) {
            i2 = 4;
        }
        s(903, (long) (i3 + i2), 1);
        AppMethodBeat.o(157083);
    }

    public static void Eq(boolean z) {
        int i2;
        int i3;
        AppMethodBeat.i(157084);
        if (!"toolsmp".equals(SAg)) {
            AppMethodBeat.o(157084);
            return;
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (WebView.getCurWebType() == WebView.c.WV_KIND_CW) {
            i3 = 180;
        } else if (WebView.getCurWebType() == WebView.c.WV_KIND_X5) {
            i3 = 190;
        } else {
            AppMethodBeat.o(157084);
            return;
        }
        s(903, (long) (i2 + i3), 1);
        AppMethodBeat.o(157084);
    }

    public static void huF() {
        AppMethodBeat.i(157085);
        s(938, 89, 1);
        AppMethodBeat.o(157085);
    }

    public static void huG() {
        AppMethodBeat.i(157086);
        s(938, 90, 1);
        AppMethodBeat.o(157086);
    }

    public static void huH() {
        AppMethodBeat.i(157087);
        s(938, 91, 1);
        AppMethodBeat.o(157087);
    }

    public static void dO(String str, boolean z) {
        AppMethodBeat.i(219095);
        s(1511, (long) ((z ? 0 : 100) + (e.bsD(str).intValue() % 100)), 1);
        AppMethodBeat.o(219095);
    }
}
