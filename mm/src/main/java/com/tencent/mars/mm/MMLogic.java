package com.tencent.mars.mm;

import android.util.Xml;
import com.hilive.mediasdk.SdkInfo;
import com.huawei.easygo.sdk.constant.EasyGoCode;
import com.tencent.luggage.game.d.c;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.appbrand.af.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.ad.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.ac;
import com.tencent.mm.plugin.appbrand.jsapi.l.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.p.ae;
import com.tencent.mm.plugin.appbrand.jsapi.p.ap;
import com.tencent.mm.plugin.appbrand.jsapi.p.w;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.u;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.mm.plugin.appbrand.jsapi.y.e;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import com.tencent.mm.protocal.protobuf.ebz;
import com.tencent.mm.protocal.protobuf.ecb;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.wxmm.v2helper;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class MMLogic {
    public static final int MM_STAT_CGI_INFO = 1;
    public static final int MM_STAT_CGI_NETWORK_COST = 7;
    public static final int MM_STAT_DNS = 8;
    public static final int MM_STAT_LONGLINK_BUILD = 3;
    public static final int MM_STAT_LONGLINK_CONNECT = 4;
    public static final int MM_STAT_LONGLINK_DISCONNECT = 5;
    public static final int MM_STAT_LONGLINK_FUNC_CONNECT = 6;
    public static final int MM_STAT_NETWORK_UNREACHABLE = 2;
    public static final int MM_Stat_Local_GetHostByName = 11;
    public static final int MM_Stat_Network_Changed = 10;
    public static final int MM_Stat_Noop_Send = 9;
    private static long lastReportTime = 0;
    static final List<Integer> payCgis = Arrays.asList(385, 386, 387, Integer.valueOf((int) w.CTRL_INDEX), Integer.valueOf((int) ae.CTRL_INDEX), 390, 391, 392, 393, 394, Integer.valueOf((int) c.CTRL_INDEX), 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 410, Integer.valueOf((int) v2helper.EMethodSetPlayerPreCorrectCofOff), 461, 462, 463, Integer.valueOf((int) u.CTRL_INDEX), Integer.valueOf((int) JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX), Integer.valueOf((int) bg.CTRL_INDEX), Integer.valueOf((int) a.CTRL_INDEX), Integer.valueOf((int) a.C0672a.CTRL_INDEX), Integer.valueOf((int) d.CTRL_INDEX), 470, 471, Integer.valueOf((int) e.CTRL_INDEX), 473, Integer.valueOf((int) JsApiAddDownloadTask.CTRL_INDEX), Integer.valueOf((int) JsApiCancelDownloadTask.CTRL_INDEX), Integer.valueOf((int) JsApiOpenAdCanvas.CTRL_INDEX), Integer.valueOf((int) b.CTRL_INDEX), Integer.valueOf((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX), 479, Integer.valueOf((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.CTRL_INDEX), Integer.valueOf((int) m.CTRL_INDEX), Integer.valueOf((int) com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX), Integer.valueOf((int) com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX), 508, 509, 514, Integer.valueOf((int) EasyGoCode.InvokedErrCode.SECURITY_EXCEPTION), 525, Integer.valueOf((int) ac.CTRL_INDEX), Integer.valueOf((int) r.CTRL_INDEX), 565, 566, 567, 568, 569, 570, 571, 573, 580, 583, Integer.valueOf((int) ap.CTRL_INDEX), Integer.valueOf((int) com.tencent.luggage.game.d.a.CTRL_INDEX), 586, 587, 588, Integer.valueOf((int) f.CTRL_INDEX), Integer.valueOf((int) af.CTRL_INDEX), 591, Integer.valueOf((int) com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.CTRL_INDEX), Integer.valueOf((int) com.tencent.mm.plugin.appbrand.jsapi.fakenative.b.CTRL_INDEX), 600, 606, Integer.valueOf((int) SdkInfo.ErrCode.kErrCodeFormatUnSupport), Integer.valueOf((int) h.CTRL_INDEX), Integer.valueOf((int) TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION), 844, 859, 1002, 1019, 1109, Integer.valueOf((int) FaceManager.FACE_ACQUIRED_NOSE_OCCLUSION), 1211, 1230, 1241, 1256, 1257, 1259, 1273, 1274, 1275, 1276, Integer.valueOf((int) TAVExporter.VIDEO_EXPORT_HEIGHT), 1281, 1283, 1301, 1304, 1305, 1317, 1318, 1321, 1323, 1324, 1335, 1336, 1338, 1340, 1344, 1348, 1349, 1370, 1371, 1376, 1378, 1380, 1384, 1385, 1386, 1395, 1398, 1399, 1477, 1488, 1495, 1501, 1502, 1503, 1504, 1505, 1506, 1507, 1508, 1509, 1510, 1511, 1512, 1513, 1514, 1515, 1516, 1517, 1520, 1525, 1527, 1529, 1530, 1531, 1535, 1536, 1537, 1540, 1542, 1543, 1544, 1545, 1551, 1552, 1554, 1555, 1556, 1558, 1559, 1560, 1561, 1562, 1563, 1564, 1565, 1566, 1568, 1569, 1570, 1571, 1572, 1573, 1574, 1575, 1577, 1579, 1580, 1581, 1582, 1584, 1585, 1586, 1588, 1589, 1590, 1591, 1592, 1593, 1594, 1595, 1596, 1597, 1598, 1599, 1600, 1601, 1602, 1603, 1604, 1605, 1606, 1607, 1608, 1610, 1612, 1613, 1614, 1616, 1617, 1618, 1622, 1623, 1624, 1625, 1628, 1629, 1630, 1631, 1633, 1638, 1639, 1640, 1641, 1643, 1644, 1645, 1647, 1648, 1649, 1650, 1652, 1653, 1654, 1655, 1656, 1659, 1663, 1664, 1665, 1666, 1667, 1668, 1669, 1672, 1674, 1675, 1676, 1679, 1680, 1682, 1684, 1685, 1686, 1688, 1689, 1691, 1692, 1694, 1695, 1697, 1698, 1699, 1724, 1725, 1735, 1736, 1737, 1742, 1752, 1753, 1754, 1767, 1768, 1769, 1770, 1773, 1779, 1782, 1786, 1800, 1805, 1809, 1811, 1813, 1820, 1827, 1830, 1836, 1837, 1855, 1859, 1867, 1878, 1888, 1891, 1903, 1904, 1906, 1907, 1914, 1916, 1917, 1922, 1923, 1930, 1950, 1953, 1958, 1960, 1963, 1964, 1965, 1966, 1967, 1970, 1971, 1972, 1973, 1976, 1978, 1979, 1981, Integer.valueOf((int) Exif.PARSE_EXIF_ERROR_NO_EXIF), Integer.valueOf((int) Exif.PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN), Integer.valueOf((int) Exif.PARSE_EXIF_ERROR_CORRUPT), 1986, 1987, 1988, 1990, 1992, 1993, 1997, 1999, 2501, 2504, 2505, 2506, 2507, 2508, 2512, 2514, 2515, 2516, 2519, 2520, 2527, 2529, 2532, 2533, 2541, 2542, 2544, 2545, 2547, 2549, 2551, 2553, 2554, 2556, 2557, 2561, 2562, 2565, 2567, 2568, 2570, 2573, 2576, 2581, 2584, 2585, 2589, 2590, 2595, 2598, 2607, 2609, 2612, 2613, 2614, 2615, 2616, 2618, 2620, 2621, 2622, 2626, 2628, 2629, 2630, 2632, 2633, 2635, 2642, 2652, 2654, 2655, 2658, 2659, 2661, 2662, 2663, 2665, 2666, 2668, 2671, 2672, 2673, 2675, 2677, 2680, 2682, 2685, 2686, 2687, 2689, 2693, 2694, 2696, 2697, 2699, 2702, 2704, 2705, 2708, 2713, 2714, 2715, 2719, 2720, 2722, 2724, 2725, 2726, 2728, 2730, 2732, 2736, 2737, 2739, 2740, 2741, 2742, 2745, 2750, 2752, 2753, 2755, 2756, 2760, 2764, 2765, 2767, 2773, 2774, 2780, 2783, 2784, 2786, 2791, 2796, 2797, 2798, 2800, 2801, 2803, 2806, 2807, 2811, 2814, 2815, 2817, 2820, 2821, 2823, 2824, 2825, 2826, 2828, 2840, 2841, 2844, 2845, 2847, 2848, 2849, 2850, 2851, 2852, 2853, 2856, 2858, 2860, 2861, 2862, 2863, 2867, 2868, 2870, 2871, 2872, 2876, 2878, 2880, 2882, 2886, 2887, 2888, 2892, 2894, 2896, 2901, 2907, 2910, 2911, 2916, 2923, 2924, 2925, 2926, 2927, 2928, 2929, 2930, 2931, 2935, 2938, 2939, 2941, 2952, 2956, 2958, 2960, 2961, 2969, 2970, 2971, 2976, 2980, 2983, 2984, 2987, 2990, 2992, 2993, 2996, 2997, 3505, 3521, 3555, 3570, 3572, 3573, 3584, 3591, 3634, 3651, 3665, 3671, 3708, 3730, 3766, 3768, 3774, 3780, 3781, 3795, 3801, 3857, 3858, 3885, 3920, 3962, 3989);
    private static int totalMobileRecv = 0;
    private static int totalMobileSend = 0;
    private static int totalWifiRecv = 0;
    private static int totalWifiSend = 0;

    public static class NetworkIdInfo {
        public byte[] ctx;
        public byte[] networkId;
    }

    public static native void addHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    public static native void clearLocalHostCache();

    public static native void forceUseV6(boolean z);

    private static native void getHostIps(String str, GetDnsReturn getDnsReturn);

    public static native String[] getIPsString(boolean z);

    public static native String getIspId();

    public static native void getLocalHostList(String[] strArr, String str);

    public static native NetworkIdInfo getNetworkId(String str);

    public static native String getNetworkServerIp();

    private static native void getSnsIps(boolean z, GetDnsReturn getDnsReturn);

    private static native void getSnsIpsWithHostName(String str, boolean z, GetDnsReturn getDnsReturn);

    public static native void recoverLinkAddrs();

    public static native void reportCGIServerError(int i2, int i3);

    public static native void reportFailIp(String str);

    public static native void reportV6Status(boolean z);

    public static native void saveAuthLongIPs(String str, String[] strArr);

    public static native void saveAuthLongList(Object obj, int[] iArr);

    public static native void saveAuthPorts(int[] iArr, int[] iArr2);

    public static native void saveAuthShortIPs(String str, String[] strArr);

    public static native void saveAuthShortList(Object obj, int[] iArr);

    public static native void setDebugHost(String str);

    public static native void setDebugIP(String str, String str2, String str3, String str4);

    public static native void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    public static native void setMmtlsCtrlInfo(boolean z);

    public static native void setNetworkId(String str, String str2, String str3, int i2);

    public static native void setNewDnsDebugHost(String str, String str2);

    public static native void switchProcessActiveState(boolean z);

    public static native void uploadFile(String str, String str2, String str3);

    public static native void uploadLog(int[] iArr, boolean z, String str, String str2);

    public static class ReportInfo {
        public long actionId = 0;
        public long beginTime = 0;
        public String clientIp = "";
        public long connCostTime = 0;
        public long connTotalCostTime = 0;
        public long dnsCostTime = 0;
        public int dnsErrType = 0;
        public String dnsSvrIp = "";
        public int endFlag = 0;
        public int endStep = 0;
        public long endTime = 0;
        public int errCode = 0;
        public int errType = 0;
        public long expand1 = 0;
        public long expand2 = 0;
        public String extraInfo = "";
        public long firstPkgTime = 0;
        public String host = "";
        public String ip = "";
        public int ipType = 0;
        public boolean isSocket = false;
        public int localIp = 0;
        public long netSignal = 0;
        public int netType = 0;
        public int newNetType = 0;
        public long newdnsCostTime = 0;
        public int newdnsErrCode = 0;
        public int newdnsErrType = 0;
        public int port = 0;
        public long recvSize = 0;
        public int refTime1 = 0;
        public int refTime2 = 0;
        public int refTime3 = 0;
        public int retryCount = 0;
        public long rtType = 0;
        public long sendSize = 0;
        public int subNetType = 0;
        public int usedIpIndex = 0;

        public String toString() {
            return String.format("actionId:%d, rtType:%d, begin:%d, end:%d, cost:%d, ip:%s, port:%d, isSocket:%b, netType:%d, ipType:%d, sendSize:%d, recvSize:%d, errType:%d, errCode:%d, netSignal:%d, retryCount:%d, expand1:%d, clientip:%s, expand2:%d, newNetType:%d, subNetType:%d, extraInfo:%s, host:%s, endStep:%d, endFlag:%d", Long.valueOf(this.actionId), Long.valueOf(this.rtType), Long.valueOf(this.beginTime), Long.valueOf(this.endTime), Long.valueOf(this.endTime - this.beginTime), this.ip, Integer.valueOf(this.port), Boolean.valueOf(this.isSocket), Integer.valueOf(this.netType), Integer.valueOf(this.ipType), Long.valueOf(this.sendSize), Long.valueOf(this.recvSize), Integer.valueOf(this.errType), Integer.valueOf(this.errCode), Long.valueOf(this.netSignal), Integer.valueOf(this.retryCount), Long.valueOf(this.expand1), this.clientIp, Long.valueOf(this.expand2), Integer.valueOf(this.newNetType), Integer.valueOf(this.subNetType), this.extraInfo, this.host, Integer.valueOf(this.endStep), Integer.valueOf(this.endFlag));
        }
    }

    private static String getCurLanguage() {
        try {
            return LocaleUtil.getApplicationLanguage();
        } catch (Exception e2) {
            return "";
        }
    }

    private static String getUserIDCLocale() {
        try {
            return Util.isOverseasUser(MMApplicationContext.getContext()) ? WeChatBrands.AppInfo.LANG_HK : WeChatBrands.AppInfo.LANG_CN;
        } catch (Exception e2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class GetDnsReturn {
        public String[] aryIps;
        public int length;
        public int type;

        private GetDnsReturn() {
            this.type = 0;
            this.aryIps = new String[50];
        }
    }

    public static int getSnsIpsForScene(List<String> list, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        GetDnsReturn getDnsReturn = new GetDnsReturn();
        getSnsIps(z, getDnsReturn);
        for (int i2 = 0; i2 < getDnsReturn.length; i2++) {
            list.add(getDnsReturn.aryIps[i2]);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.actionId = 11;
        reportInfo.beginTime = currentTimeMillis;
        reportInfo.endTime = currentTimeMillis2;
        reportInfo.clientIp = "mmsns.qpic.cn";
        reportInfo.ip = getDnsReturn.length > 0 ? getDnsReturn.aryIps[0] : TRTCCloudDef.TRTC_SDK_VERSION;
        reportStat(reportInfo);
        return getDnsReturn.type;
    }

    public static int getSnsIpsForSceneWithHostName(List<String> list, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        GetDnsReturn getDnsReturn = new GetDnsReturn();
        getSnsIpsWithHostName(str, z, getDnsReturn);
        for (int i2 = 0; i2 < getDnsReturn.length; i2++) {
            list.add(getDnsReturn.aryIps[i2]);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.actionId = 11;
        reportInfo.beginTime = currentTimeMillis;
        reportInfo.endTime = currentTimeMillis2;
        reportInfo.clientIp = str;
        reportInfo.ip = getDnsReturn.length > 0 ? getDnsReturn.aryIps[0] : TRTCCloudDef.TRTC_SDK_VERSION;
        reportStat(reportInfo);
        return getDnsReturn.type;
    }

    public static int getHostByName(String str, List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        GetDnsReturn getDnsReturn = new GetDnsReturn();
        getHostIps(str, getDnsReturn);
        for (int i2 = 0; i2 < getDnsReturn.length; i2++) {
            list.add(getDnsReturn.aryIps[i2]);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.actionId = 11;
        reportInfo.beginTime = currentTimeMillis;
        reportInfo.endTime = currentTimeMillis2;
        reportInfo.clientIp = str;
        reportInfo.ip = getDnsReturn.length > 0 ? getDnsReturn.aryIps[0] : TRTCCloudDef.TRTC_SDK_VERSION;
        reportStat(reportInfo);
        return getDnsReturn.type;
    }

    /* access modifiers changed from: private */
    public static int getJavaActionId(long j2) {
        switch ((int) j2) {
            case 1:
                return 10955;
            case 2:
                return 10104;
            case 3:
                return 10103;
            case 4:
                return 10105;
            case 5:
                return 10102;
            case 6:
                return 10101;
            case 7:
                return 1105;
            case 8:
                return 10428;
            case 9:
                return -1;
            case 10:
                return -2;
            case 11:
                return -3;
            default:
                return 0;
        }
    }

    public static void reportStat(final ReportInfo reportInfo) {
        try {
            com.tencent.mm.network.af.bkj().post(new Runnable() {
                /* class com.tencent.mars.mm.MMLogic.AnonymousClass1 */

                public final void run() {
                    int javaActionId = MMLogic.getJavaActionId(reportInfo.actionId);
                    if (javaActionId == 0) {
                        Log.e("C2Java", "ActionId Can not convert");
                        return;
                    }
                    reportInfo.actionId = (long) javaActionId;
                }
            });
        } catch (Exception e2) {
        }
    }

    private static void reportFlow(int i2, int i3, int i4, int i5) {
        totalWifiRecv += i2;
        totalWifiSend += i3;
        totalMobileRecv += i4;
        totalMobileSend += i5;
        int i6 = totalMobileRecv + totalMobileSend + totalWifiRecv + totalWifiSend;
        final com.tencent.mm.network.a.b bVar = com.tencent.mm.network.af.bkh().jFR;
        Log.i("C2Java", "reportNetFlow time[%d,%d] sum:%d wr[%d,%d] ws[%d,%d] mr[%d,%d] ms[%d,%d] fgbg:%b Moniter:%s", Long.valueOf(lastReportTime), Long.valueOf(Util.secondsToNow(lastReportTime)), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(totalWifiRecv), Integer.valueOf(i3), Integer.valueOf(totalWifiSend), Integer.valueOf(i4), Integer.valueOf(totalMobileRecv), Integer.valueOf(i5), Integer.valueOf(totalMobileSend), Boolean.valueOf(CrashReportFactory.foreground), bVar);
        if (bVar != null) {
            if (i6 >= 102400 || Util.secondsToNow(lastReportTime) >= 30) {
                lastReportTime = Util.nowSecond();
                final int i7 = totalWifiRecv;
                totalWifiRecv = 0;
                final int i8 = totalWifiSend;
                totalWifiSend = 0;
                final int i9 = totalMobileRecv;
                totalMobileRecv = 0;
                final int i10 = totalMobileSend;
                totalMobileSend = 0;
                try {
                    com.tencent.mm.network.af.bkj().post(new Runnable() {
                        /* class com.tencent.mars.mm.MMLogic.AnonymousClass2 */

                        public final void run() {
                            try {
                                bVar.u(i7, i8, i9, i10);
                            } catch (Throwable th) {
                                Log.e("C2Java", "reportFlowData :%s", Util.stackTraceToString(th));
                            }
                        }
                    });
                } catch (Throwable th) {
                    Log.e("C2Java", "reportFlowData :%s", Util.stackTraceToString(th));
                }
            }
        }
    }

    private static int getLogIdSubType(long j2, String str) {
        if (j2 != 11108) {
            return 0;
        }
        try {
            if (!payCgis.contains(Integer.valueOf(Integer.parseInt(str)))) {
                return 0;
            }
            Log.d("C2Java", "gettype 1");
            return 1;
        } catch (Exception e2) {
            return 0;
        }
    }

    private static void onOOBNotify(final String str) {
        Log.i("C2Java", "onOOBNotify:".concat(String.valueOf(str)));
        if (com.tencent.mm.network.af.bkn() == null) {
            Assert.assertTrue(false);
            return;
        }
        try {
            com.tencent.mm.network.af.bkj().post(new Runnable() {
                /* class com.tencent.mars.mm.MMLogic.AnonymousClass3 */

                public final void run() {
                    com.tencent.mm.network.af.bkn().j(268369923, Util.isNullOrNil(str) ? null : str.getBytes());
                }
            });
        } catch (Exception e2) {
            Log.e("C2Java", "onOOBNotify :%s", Util.stackTraceToString(e2));
        }
    }

    private static void notifyNewSpeedTestReport(byte[] bArr, int i2, int i3, int i4, int i5, String str, int i6, String str2, int i7, int i8) {
        if (com.tencent.mm.network.af.bkn() == null) {
            Log.e("C2Java", "notifyNewSpeedTestReport failed");
            return;
        }
        ecb ecb = new ecb();
        ecb.Ncf = i2;
        ecb.Ncg = i3;
        ecb.Nch = i4;
        ecb.Nci = i5;
        ecb.Mpw = com.tencent.mm.bw.b.cD(bArr);
        ecb.Ncd = "";
        ecb.Ncc = "";
        ecb.Nce = "";
        if (i8 == 3) {
            ecb.Ncc = "dual";
        }
        ebz ebz = new ebz();
        ebz ebz2 = new ebz();
        ebz.ip = str;
        ebz.port = i6;
        ebz2.ip = str2;
        ebz2.port = i7;
        ecb.Nck = ebz;
        ecb.Ncj = ebz2;
        Log.d("C2Java", "notifyNewSpeedTestReport origin cookie: " + new String(bArr) + ", origin size : " + bArr.length + ", covert cookie size " + ecb.Mpw.zy.length);
        try {
            final byte[] byteArray = ecb.toByteArray();
            com.tencent.mm.network.af.bkj().post(new Runnable() {
                /* class com.tencent.mars.mm.MMLogic.AnonymousClass4 */

                public final void run() {
                    com.tencent.mm.network.af.bkn().j(a.C0691a.CTRL_INDEX, byteArray);
                }
            });
        } catch (Exception e2) {
            Log.e("C2Java", "notifyNewSpeedTestReport :%s", Util.stackTraceToString(e2));
        }
    }

    private static int getXAgreementId() {
        Log.d("zyzhang", "getXAgreementId");
        int i2 = WeChatBrands.UserInfo.xagreementId;
        Log.i("C2Java", "MMLogic get xagreement id %s", Integer.valueOf(i2));
        return i2;
    }

    private static void onDisasterNodeNotify(String str) {
        Log.i("MicroMsg.MMDisasterInfoHandle", "onDisasterNodeNotify:\n".concat(String.valueOf(str)));
        XmlPullParser newPullParser = Xml.newPullParser();
        ArrayList<String> arrayList = new ArrayList();
        try {
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        if ("host".equals(newPullParser.getName())) {
                            arrayList.add(newPullParser.nextText());
                            break;
                        } else {
                            break;
                        }
                }
            }
            for (String str2 : arrayList) {
                Log.i("MicroMsg.MMDisasterInfoHandle", "host ".concat(String.valueOf(str2)));
            }
            com.tencent.mm.network.w.aL(arrayList);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMDisasterInfoHandle", "exception:%s", Util.stackTraceToString(e2));
        }
    }
}
