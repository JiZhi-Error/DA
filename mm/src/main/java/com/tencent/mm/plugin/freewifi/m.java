package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.aw.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.ui.MMWizardActivity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public final class m {
    private static SimpleDateFormat oMZ = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

    public interface a {
        void f(int i2, int i3, String str, q qVar);
    }

    public static boolean eP(String str) {
        AppMethodBeat.i(24704);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(24704);
            return true;
        }
        AppMethodBeat.o(24704);
        return false;
    }

    static {
        AppMethodBeat.i(24732);
        AppMethodBeat.o(24732);
    }

    public static String removeSsidQuote(String str) {
        AppMethodBeat.i(24705);
        if (eP(str)) {
            AppMethodBeat.o(24705);
            return "";
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        AppMethodBeat.o(24705);
        return str;
    }

    public static boolean dMI() {
        AppMethodBeat.i(24706);
        String topActivityName = Util.getTopActivityName(MMApplicationContext.getContext());
        if (topActivityName == null || !topActivityName.toLowerCase().startsWith(MMApplicationContext.getSourcePackageName())) {
            AppMethodBeat.o(24706);
            return false;
        }
        AppMethodBeat.o(24706);
        return true;
    }

    public static void av(Intent intent) {
        AppMethodBeat.i(24707);
        if (eP(intent.getStringExtra("free_wifi_sessionkey"))) {
            f(intent, dMJ());
        }
        AppMethodBeat.o(24707);
    }

    public static String dMJ() {
        AppMethodBeat.i(24708);
        String replace = UUID.randomUUID().toString().replace("-", "");
        AppMethodBeat.o(24708);
        return replace;
    }

    public static void f(Intent intent, String str) {
        AppMethodBeat.i(24709);
        intent.putExtra("free_wifi_sessionkey", str);
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
        AppMethodBeat.o(24709);
    }

    public static String aw(Intent intent) {
        AppMethodBeat.i(24710);
        String axL = axL(intent.getStringExtra("free_wifi_sessionkey"));
        AppMethodBeat.o(24710);
        return axL;
    }

    public static int ax(Intent intent) {
        AppMethodBeat.i(24711);
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", intExtra);
        AppMethodBeat.o(24711);
        return intExtra;
    }

    public static int ay(Intent intent) {
        AppMethodBeat.i(24712);
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        AppMethodBeat.o(24712);
        return intExtra;
    }

    public static int az(Intent intent) {
        AppMethodBeat.i(24713);
        int intExtra = intent.getIntExtra("free_wifi_channel_id", 0);
        AppMethodBeat.o(24713);
        return intExtra;
    }

    public static String aA(Intent intent) {
        AppMethodBeat.i(24714);
        String stringExtra = intent.getStringExtra("free_wifi_ap_key");
        AppMethodBeat.o(24714);
        return stringExtra;
    }

    public static String axL(String str) {
        return str == null ? "" : str;
    }

    public static String axM(String str) {
        AppMethodBeat.i(24715);
        String connectedWifiSsid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
        Log.i(str, "getConnectedWifiSsid()=".concat(String.valueOf(connectedWifiSsid)));
        AppMethodBeat.o(24715);
        return connectedWifiSsid;
    }

    public static String axN(String str) {
        AppMethodBeat.i(24716);
        String connectedWifiBssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
        Log.i(str, "getConnectedWifiBssid()=".concat(String.valueOf(connectedWifiBssid)));
        AppMethodBeat.o(24716);
        return connectedWifiBssid;
    }

    public static String axO(String str) {
        AppMethodBeat.i(24717);
        String connectedWifiClientMac = NetStatusUtil.getConnectedWifiClientMac(MMApplicationContext.getContext());
        Log.i(str, "getConnectedWifiClientMac()=".concat(String.valueOf(connectedWifiClientMac)));
        AppMethodBeat.o(24717);
        return connectedWifiClientMac;
    }

    public static String l(Exception exc) {
        AppMethodBeat.i(24718);
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String axL = axL(stringWriter.toString());
        if (axL.length() > 1024) {
            axL = axL.substring(0, 1024);
        }
        AppMethodBeat.o(24718);
        return axL;
    }

    public static String m(Exception exc) {
        AppMethodBeat.i(24719);
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String axL = axL(stringWriter.toString());
        AppMethodBeat.o(24719);
        return axL;
    }

    public static String a(int i2, k.b bVar, int i3) {
        Object valueOf;
        AppMethodBeat.i(24720);
        Log.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", Integer.valueOf(i2), bVar.name, Long.valueOf(bVar.wNO), Integer.valueOf(i3));
        int abs = Math.abs(i3);
        StringBuilder append = new StringBuilder().append(String.format("%02d", Integer.valueOf(i2))).append(String.format("%03d", Long.valueOf(bVar.wNO)));
        if (abs <= 999) {
            valueOf = String.format("%03d", Integer.valueOf(abs));
        } else {
            valueOf = Integer.valueOf(abs);
        }
        String sb = append.append(valueOf).toString();
        AppMethodBeat.o(24720);
        return sb;
    }

    public static void a(Intent intent, String str, final int i2, int i3, final FreeWifiFrontPageUI freeWifiFrontPageUI, final String str2) {
        AppMethodBeat.i(24721);
        a(intent, str, i2, i3, new a() {
            /* class com.tencent.mm.plugin.freewifi.m.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.freewifi.m.a
            public final void f(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(24701);
                if (i2 == 0 && i3 == 0) {
                    if (!(qVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                        AppMethodBeat.o(24701);
                        return;
                    }
                    ih dNz = ((com.tencent.mm.plugin.freewifi.d.a) qVar).dNz();
                    if (dNz != null) {
                        Log.i(str2, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", dNz.KGX, dNz.oUJ, dNz.UserName, Integer.valueOf(dNz.KMt), dNz.KMu, dNz.keb, dNz.KMv);
                        FreeWifiFrontPageUI freeWifiFrontPageUI = freeWifiFrontPageUI;
                        FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.SUCCESS;
                        FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                        bVar.wRL = dNz;
                        freeWifiFrontPageUI.a(dVar, bVar);
                        AppMethodBeat.o(24701);
                        return;
                    }
                    Log.i(str2, "backPageInfo is null");
                    FreeWifiFrontPageUI freeWifiFrontPageUI2 = freeWifiFrontPageUI;
                    FreeWifiFrontPageUI.d dVar2 = FreeWifiFrontPageUI.d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.wRo = m.a(i2, k.b.GetBackPageReturn, 21);
                    freeWifiFrontPageUI2.a(dVar2, aVar);
                    AppMethodBeat.o(24701);
                } else if (!m.gC(i2, i3) || m.eP(str)) {
                    FreeWifiFrontPageUI freeWifiFrontPageUI3 = freeWifiFrontPageUI;
                    FreeWifiFrontPageUI.d dVar3 = FreeWifiFrontPageUI.d.FAIL;
                    FreeWifiFrontPageUI.a aVar2 = new FreeWifiFrontPageUI.a();
                    aVar2.wRo = m.a(i2, k.b.GetBackPageReturn, i3);
                    freeWifiFrontPageUI3.a(dVar3, aVar2);
                    AppMethodBeat.o(24701);
                } else {
                    FreeWifiFrontPageUI freeWifiFrontPageUI4 = freeWifiFrontPageUI;
                    FreeWifiFrontPageUI.d dVar4 = FreeWifiFrontPageUI.d.FAIL;
                    FreeWifiFrontPageUI.a aVar3 = new FreeWifiFrontPageUI.a();
                    aVar3.text = str;
                    aVar3.wRo = m.a(i2, k.b.GetBackPageReturn, i3);
                    freeWifiFrontPageUI4.a(dVar4, aVar3);
                    AppMethodBeat.o(24701);
                }
            }
        }, str2);
        AppMethodBeat.o(24721);
    }

    public static void a(final Intent intent, final String str, final int i2, final int i3, final a aVar, final String str2) {
        AppMethodBeat.i(24722);
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.m.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(24703);
                k.a dMF = k.dMF();
                dMF.ssid = m.axM(str2);
                dMF.bssid = m.axN(str2);
                dMF.dFe = m.axO(str2);
                dMF.dFd = str;
                dMF.quX = m.aw(intent);
                dMF.wNc = i2;
                dMF.wNd = k.b.GetBackPage.wNO;
                dMF.wNe = k.b.GetBackPage.name;
                dMF.channel = m.az(intent);
                dMF.result = 0;
                dMF.dMH().dMG();
                String axN = m.axN(str2);
                String axM = m.axM(str2);
                int dNc = d.dNc();
                Log.i(str2, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + NetStatusUtil.getNetType(MMApplicationContext.getContext()));
                Log.i(str2, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.aw(intent), Integer.valueOf(m.ax(intent)), str, axN, axM, Integer.valueOf(dNc));
                new com.tencent.mm.plugin.freewifi.d.a(str, axN, axM, dNc, i3, m.aw(intent)).c(new i() {
                    /* class com.tencent.mm.plugin.freewifi.m.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(24702);
                        Log.i(str2, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", m.aw(intent), Integer.valueOf(m.ax(intent)), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        k.a dMF = k.dMF();
                        dMF.ssid = m.axM(str2);
                        dMF.bssid = m.axN(str2);
                        dMF.dFe = m.axO(str2);
                        dMF.dFd = str;
                        dMF.quX = m.aw(intent);
                        dMF.wNc = m.ay(intent);
                        dMF.wNd = k.b.GetBackPage33Return.wNO;
                        dMF.wNe = k.b.GetBackPage33Return.name;
                        dMF.channel = m.az(intent);
                        dMF.result = i3;
                        dMF.resultMsg = str;
                        dMF.dMH().c(intent, true).dMG();
                        aVar.f(i2, i3, str, qVar);
                        AppMethodBeat.o(24702);
                    }
                });
                AppMethodBeat.o(24703);
            }
        });
        AppMethodBeat.o(24722);
    }

    public static int dMK() {
        String str;
        AppMethodBeat.i(24723);
        l.a bnZ = l.bnZ();
        if (bnZ == l.a.NO_INIT || bnZ == l.a.SET_MOBILE) {
            AppMethodBeat.o(24723);
            return 1;
        }
        bg.aVF();
        String str2 = (String) c.azQ().get(6, (Object) null);
        if (eP(str2)) {
            AppMethodBeat.o(24723);
            return 1;
        }
        if (str2.startsWith("+")) {
            str = PhoneFormater.extractCountryCode(str2);
        } else {
            str = "86";
        }
        if ("86".equals(str)) {
            AppMethodBeat.o(24723);
            return 2;
        }
        AppMethodBeat.o(24723);
        return 3;
    }

    public static void fT(Context context) {
        b.a bs;
        AppMethodBeat.i(24724);
        Intent intent = new Intent(context, BindMContactUI.class);
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        if (!Util.isNullOrNil(simCountryIso) && (bs = b.bs(simCountryIso, context.getString(R.string.bj8))) != null) {
            intent.putExtra("country_name", bs.jbZ);
            intent.putExtra("couttry_code", bs.jbY);
        }
        MMWizardActivity.ay(context, intent);
        AppMethodBeat.o(24724);
    }

    public static boolean gB(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return true;
        }
        return false;
    }

    public static boolean gC(int i2, int i3) {
        if (i2 != 4 || i3 > -30000 || i3 <= -31000) {
            return false;
        }
        return true;
    }

    public static int n(Exception exc) {
        AppMethodBeat.i(24725);
        if (exc instanceof SocketTimeoutException) {
            String m = m(exc);
            if (m.indexOf(".read") != -1) {
                AppMethodBeat.o(24725);
                return 105;
            } else if (m.indexOf(".connect") != -1) {
                AppMethodBeat.o(24725);
                return 104;
            } else {
                AppMethodBeat.o(24725);
                return 101;
            }
        } else if (exc instanceof ConnectException) {
            AppMethodBeat.o(24725);
            return 106;
        } else if (exc instanceof UnknownHostException) {
            AppMethodBeat.o(24725);
            return 102;
        } else {
            AppMethodBeat.o(24725);
            return 101;
        }
    }

    public static boolean l(Map<String, String> map, String str) {
        AppMethodBeat.i(24726);
        Log.i(str, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.KyO);
        String str2 = map.get(".sysmsg.apply_versions.version_desc.$minInclude");
        String str3 = map.get(".sysmsg.apply_versions.version_desc.$maxInclude");
        Log.i(str, "checkMsgPushedVersion. min0=%s,max0=%s", str2, str3);
        if (eP(str2) && eP(str3)) {
            AppMethodBeat.o(24726);
            return false;
        } else if (hq(str2, str3)) {
            AppMethodBeat.o(24726);
            return true;
        } else {
            int i2 = 1;
            while (true) {
                String str4 = map.get(".sysmsg.apply_versions.version_desc#" + i2 + ".$minInclude");
                String str5 = map.get(".sysmsg.apply_versions.version_desc#" + i2 + ".$maxInclude");
                Log.i(str, "checkMsgPushedVersion. min" + i2 + "=%s,max" + i2 + "=%s", str4, str5);
                if (eP(str4) && eP(str5)) {
                    AppMethodBeat.o(24726);
                    return false;
                } else if (hq(str4, str5)) {
                    AppMethodBeat.o(24726);
                    return true;
                } else {
                    i2++;
                }
            }
        }
    }

    private static boolean hq(String str, String str2) {
        AppMethodBeat.i(24727);
        int i2 = Util.getInt(str, 0);
        int i3 = Util.getInt(str2, 0);
        if (i2 == 0 && i3 != 0 && com.tencent.mm.protocal.d.KyO <= i3) {
            AppMethodBeat.o(24727);
            return true;
        } else if (i2 != 0 && i3 == 0 && com.tencent.mm.protocal.d.KyO >= i2) {
            AppMethodBeat.o(24727);
            return true;
        } else if (i2 == 0 || i3 == 0 || com.tencent.mm.protocal.d.KyO < i2 || com.tencent.mm.protocal.d.KyO > i3) {
            AppMethodBeat.o(24727);
            return false;
        } else {
            AppMethodBeat.o(24727);
            return true;
        }
    }

    public static boolean dML() {
        AppMethodBeat.i(24728);
        if (((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            Log.i("TAG", "isWifiConnected()=true");
            AppMethodBeat.o(24728);
            return true;
        }
        Log.i("TAG", "isWifiConnected()=false");
        AppMethodBeat.o(24728);
        return false;
    }

    public static ahc dMM() {
        AppMethodBeat.i(24729);
        ahc ahc = new ahc();
        ahc.deviceBrand = com.tencent.mm.protocal.d.KyI;
        if (d.wMJ == null || d.wMJ.equals("")) {
            ahc.LqM = axO("MicroMsg.FreeWifi.Utils");
        } else {
            ahc.LqM = d.wMJ;
        }
        ahc.deviceModel = com.tencent.mm.protocal.d.KyJ;
        ahc.osName = com.tencent.mm.protocal.d.KyL;
        ahc.osVersion = com.tencent.mm.protocal.d.KyM;
        AppMethodBeat.o(24729);
        return ahc;
    }

    public static String a(String str, LinkedHashMap<String, Class> linkedHashMap, MAutoStorage mAutoStorage, String str2) {
        AppMethodBeat.i(24730);
        if (linkedHashMap.size() == 0) {
            AppMethodBeat.o(24730);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(APLogFileUtil.SEPARATOR_LINE);
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, Class> entry : linkedHashMap.entrySet()) {
            sb2.append(entry.getKey()).append(",");
        }
        if (sb2.length() > 0) {
            sb2.delete(sb2.length() - 1, sb2.length());
        }
        String str3 = "select " + sb2.toString() + " from " + str;
        for (Map.Entry<String, Class> entry2 : linkedHashMap.entrySet()) {
            sb.append(entry2.getKey()).append("\t");
        }
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        Cursor rawQuery = mAutoStorage.rawQuery(str3, new String[0]);
        while (rawQuery.moveToNext()) {
            try {
                int i2 = 0;
                for (Map.Entry<String, Class> entry3 : linkedHashMap.entrySet()) {
                    Class value = entry3.getValue();
                    if (value == String.class) {
                        sb.append(rawQuery.getString(i2));
                    } else if (value == Integer.TYPE) {
                        sb.append(rawQuery.getInt(i2));
                    } else if (value == Long.TYPE) {
                        sb.append(rawQuery.getLong(i2));
                    } else if (value == Float.TYPE) {
                        sb.append(rawQuery.getFloat(i2));
                    } else if (value == Double.TYPE) {
                        sb.append(rawQuery.getDouble(i2));
                    } else {
                        Log.e(str2, "unkonwn type " + value.toString());
                        sb.append(rawQuery.getString(i2));
                    }
                    sb.append("\t");
                    i2++;
                }
                sb.append(APLogFileUtil.SEPARATOR_LINE);
            } catch (Exception e2) {
                Log.i(str2, "print " + str + "error." + e2.getMessage());
                return "";
            } finally {
                rawQuery.close();
                AppMethodBeat.o(24730);
            }
        }
        Log.i(str2, sb.toString());
        return sb.toString();
    }

    public static void axP(String str) {
        AppMethodBeat.i(24731);
        Log.i("FreeWifi", str);
        AppMethodBeat.o(24731);
    }
}
