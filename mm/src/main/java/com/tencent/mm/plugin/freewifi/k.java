package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    public static Map<String, String> wMY = new HashMap<String, String>() {
        /* class com.tencent.mm.plugin.freewifi.k.AnonymousClass1 */

        {
            AppMethodBeat.i(24682);
            b[] values = b.values();
            for (b bVar : values) {
                put(bVar.name, bVar.wNP);
            }
            AppMethodBeat.o(24682);
        }
    };
    private String bssid;
    private int channel;
    private String dFd;
    private String dFe;
    private String quX;
    private int result;
    private String resultMsg;
    private String ssid;
    private int wMZ;
    private String wNa;
    private String wNb;
    private int wNc;
    private long wNd;
    private String wNe;
    private String wNf;
    private long wNg;

    /* synthetic */ k(byte b2) {
        this();
    }

    public enum b {
        GetFrontPage(10, "getFrontPage", "a"),
        GetFrontPageReturn(11, "getFrontpageReturn", LocaleUtil.ARABIC),
        GetFrontPageReturnDataCheck(12, "getFrontPageReturnDataCheck", "ard"),
        AddNetwork(20, "addNetwork", "n"),
        GetBackPage(30, "getBackPage", "b"),
        GetBackPageReturn(31, "getBackPageReturn", "br"),
        GetBackPage33(32, "getBackPage33", "b33"),
        GetBackPage33Return(33, "getBackPage33Return", "b33r"),
        BackpageFinished(40, "backpageFinished", "bf"),
        QinghuaiBackpageFinished(50, "qinghuaiBackpageFinished", "qbf"),
        ScanNearFieldWifiAndReport(110, "scanNearFieldWifiAndReport", "sc"),
        GetThreeOneLock(290, "getThreeOneLock", "31lk"),
        GetPortalApInfo(300, "getPortalApInfo", "o"),
        GetPortalApInfoReturn(301, "getPortalApInfoReturn", "or"),
        GetPortalApInfoReturnDataCheck(302, "getPortalApInfoReturnDataCheck", "ord"),
        FrontPageUIClosed(303, "frontPageUIClosed", "af"),
        FrontPageUIClosedByGoBack(311, "frontPageUIClosedByGoBack", "afg"),
        FrontPageUIClosedByGoSuc(312, "frontPageUIClosedByGoSuc", "afs"),
        FrontPageUIClosedByGoContactInfoUI(313, "frontPageUIClosedByGoContactInfoUI", "afc"),
        ThreeOneAuth(305, "threeOneAuth", "31a"),
        ThreeTwoAuth(306, "threeTwoAuth", "32a"),
        ThreeTwoBlack(307, "threeTwoAuthBlack", "32ab"),
        ThreeThreeAuth(308, "threeThreeAuth", "33a"),
        GetPcFrontPage(210, "getPcFrontPage", "pca"),
        GetPcFrontPageReturn(211, "getPcFrontPageReturn", "pcar"),
        SetPcLoginUserInfo(212, "setPcLoginUserInfo", "pcset"),
        SetPcLoginUserInfoReturn(212, "setPcLoginUserInfoReturn", "pcsetr"),
        ManufacturerConnectLoading(500, "manufacturerConnectLoading", "mld"),
        CopyPwdPageUIClosedByGoBack(600, "CopyPwdPageUIClosedByGoBack", "cpg");
        
        public String name;
        public long wNO;
        String wNP;

        public static b valueOf(String str) {
            AppMethodBeat.i(24686);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(24686);
            return bVar;
        }

        static {
            AppMethodBeat.i(24688);
            AppMethodBeat.o(24688);
        }

        private b(long j2, String str, String str2) {
            AppMethodBeat.i(24687);
            if (j2 > 999 || j2 < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("code must be between 0 and 999");
                AppMethodBeat.o(24687);
                throw illegalArgumentException;
            }
            this.wNO = j2;
            this.name = str;
            this.wNP = str2;
            AppMethodBeat.o(24687);
        }
    }

    static {
        AppMethodBeat.i(24693);
        AppMethodBeat.o(24693);
    }

    public static String axK(String str) {
        AppMethodBeat.i(24689);
        String axL = m.axL(wMY.get(str));
        AppMethodBeat.o(24689);
        return axL;
    }

    private k() {
    }

    public static a dMF() {
        AppMethodBeat.i(24690);
        a aVar = new a((byte) 0);
        AppMethodBeat.o(24690);
        return aVar;
    }

    public final k dMG() {
        AppMethodBeat.i(24691);
        h.INSTANCE.a(12804, m.axL(this.ssid), m.axL(this.bssid), m.axL(this.dFe), m.axL(this.dFd), Integer.valueOf(this.wMZ), m.axL(this.wNa), m.axL(this.wNb), m.axL(this.quX), Integer.valueOf(this.wNc), Long.valueOf(this.wNd), m.axL(this.wNe), Integer.valueOf(this.result), Integer.valueOf(this.channel), m.axL(this.wNf), Long.valueOf(this.wNg), m.axL(this.resultMsg));
        AppMethodBeat.o(24691);
        return this;
    }

    public final k c(Intent intent, boolean z) {
        AppMethodBeat.i(24692);
        try {
            final int ay = m.ay(intent);
            if (ay != 31) {
                AppMethodBeat.o(24692);
                return this;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TPDownloadProxyEnum.USER_SSID, this.ssid);
                jSONObject.put(TPDownloadProxyEnum.USER_BSSID, this.bssid);
                jSONObject.put("clientMac", this.dFe);
                jSONObject.put("apKey", this.dFd);
                jSONObject.put("qrtype", this.wMZ);
                jSONObject.put("mpShopId", this.wNa);
                jSONObject.put("mpAppId", this.wNb);
                jSONObject.put("sessionKey", this.quX);
                jSONObject.put("protocolType", this.wNc);
                jSONObject.put("stageCode", this.wNd);
                jSONObject.put("stageName", this.wNe);
                jSONObject.put("result", this.result);
                jSONObject.put("channel", this.channel);
                jSONObject.put("mpUserName", this.wNf);
                jSONObject.put("timeCost", this.wNg);
                jSONObject.put("resultMsg", this.resultMsg);
                jSONObject.put("logCurrentTimeMillis", System.currentTimeMillis());
            } catch (JSONException e2) {
                Log.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "JSONException e. " + m.m(e2));
            }
            String jSONObject2 = jSONObject.toString();
            String stringExtra = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
            if (m.eP(stringExtra)) {
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", jSONObject2);
            } else {
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", stringExtra + "," + jSONObject2);
            }
            final long currentTimeMillis = System.currentTimeMillis();
            final String stringExtra2 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID");
            final String stringExtra3 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
            if (z) {
                j.dNr().dMZ().post(new Runnable() {
                    /* class com.tencent.mm.plugin.freewifi.k.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(24683);
                        j.dNp().b(stringExtra2, ay, stringExtra3, currentTimeMillis);
                        if (m.dML()) {
                            com.tencent.mm.plugin.freewifi.f.b.pl(1);
                        }
                        AppMethodBeat.o(24683);
                    }
                });
            }
            AppMethodBeat.o(24692);
            return this;
        } catch (Exception e3) {
            Log.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "reportWifiServer() write to local file exception. " + m.m(e3));
        }
    }

    public static class a {
        public String bssid;
        public int channel;
        public String dFd;
        public String dFe;
        public String quX;
        public int result;
        public String resultMsg;
        public String ssid;
        private int wMZ;
        public String wNa;
        public String wNb;
        public int wNc;
        public long wNd;
        public String wNe;
        public String wNf;
        private long wNg;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
        }

        public final k dMH() {
            AppMethodBeat.i(24684);
            k kVar = new k((byte) 0);
            kVar.ssid = this.ssid;
            kVar.bssid = this.bssid;
            kVar.dFe = this.dFe;
            kVar.dFd = this.dFd;
            kVar.wMZ = this.wMZ;
            kVar.wNa = this.wNa;
            kVar.wNb = this.wNb;
            kVar.quX = this.quX;
            kVar.wNc = this.wNc;
            kVar.wNd = (long) Integer.valueOf("1" + String.format("%03d", Integer.valueOf(this.wNc)) + String.format("%03d", Long.valueOf(this.wNd))).intValue();
            kVar.wNe = this.wNe;
            kVar.result = this.result;
            kVar.channel = this.channel;
            kVar.wNf = this.wNf;
            kVar.wNg = this.wNg;
            kVar.resultMsg = this.resultMsg;
            AppMethodBeat.o(24684);
            return kVar;
        }
    }
}
