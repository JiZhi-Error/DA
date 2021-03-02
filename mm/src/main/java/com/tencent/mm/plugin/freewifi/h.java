package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class h {
    private String userAgent;
    private com.tencent.mm.plugin.freewifi.g.b wMN;

    /* synthetic */ h(byte b2) {
        this();
    }

    public static class b {
        private static h wMW = new h((byte) 0);

        static {
            AppMethodBeat.i(24659);
            AppMethodBeat.o(24659);
        }
    }

    private h() {
        AppMethodBeat.i(24660);
        this.wMN = j.dNo();
        AppMethodBeat.o(24660);
    }

    public final synchronized void a(ah ahVar) {
        AppMethodBeat.i(24661);
        dMx();
        if (ahVar == null || ahVar.KCR == null) {
            Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
            AppMethodBeat.o(24661);
        } else {
            this.wMN.dNM();
            if (ahVar.KCR.version == -1) {
                this.wMN.byC();
                Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
                this.wMN.dNM();
                AppMethodBeat.o(24661);
            } else {
                if (ahVar.KCR.version > dMy()) {
                    Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", Integer.valueOf(ahVar.KCR.version), Integer.valueOf(dMy()));
                    Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + ahVar.KCR.version);
                    Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + ahVar.KCR.Loq);
                    Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + ahVar.KCR.Lor);
                    Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + ahVar.KCR.dFc);
                    Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + ahVar.KCR.dFb);
                    Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + ahVar.KCR.Los);
                    Na(ahVar.KCR.Loq);
                    Nb(ahVar.KCR.Lor);
                    axI(ahVar.KCR.dFc);
                    axH(ahVar.KCR.dFb);
                    axJ(ahVar.KCR.Los);
                    MZ(ahVar.KCR.version);
                    Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
                    this.wMN.dNM();
                }
                AppMethodBeat.o(24661);
            }
        }
    }

    public enum a {
        version("version", "2"),
        httpConnectTimeoutMillis("httpConnectTimeoutMillis", "5000"),
        httpReadTimeoutMillis("httpReadTimeoutMillis", "5000"),
        pingEnabled("pingEnabled", "1"),
        pingUrl("pingUrl", HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e21) + "/wifi/echo"),
        threeTwoBlackUrl("threeTwoBlackUrl", HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e21) + "/wifi/echo.html");
        
        String key;
        String wMU;

        public static a valueOf(String str) {
            AppMethodBeat.i(24657);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(24657);
            return aVar;
        }

        static {
            AppMethodBeat.i(24658);
            AppMethodBeat.o(24658);
        }

        private a(String str, String str2) {
            this.key = str;
            this.wMU = str2;
        }
    }

    private synchronized void dMx() {
        AppMethodBeat.i(24662);
        try {
            String axY = this.wMN.axY(a.version.key);
            if (!m.eP(axY) && Integer.valueOf(axY).intValue() < Integer.valueOf(a.version.wMU).intValue()) {
                Na(Integer.valueOf(a.httpConnectTimeoutMillis.wMU).intValue());
                Nb(Integer.valueOf(a.httpReadTimeoutMillis.wMU).intValue());
                axI(a.pingUrl.wMU);
                axH(a.pingEnabled.wMU);
                axJ(a.threeTwoBlackUrl.wMU);
                MZ(Integer.valueOf(a.version.wMU).intValue());
            }
            AppMethodBeat.o(24662);
        } catch (Exception e2) {
            Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.m(e2));
            AppMethodBeat.o(24662);
        }
    }

    public final synchronized int dMy() {
        int i2;
        AppMethodBeat.i(24663);
        dMx();
        try {
            String axY = this.wMN.axY(a.version.key);
            if (m.eP(axY)) {
                i2 = Integer.valueOf(a.version.wMU).intValue();
                AppMethodBeat.o(24663);
            } else {
                i2 = Integer.valueOf(axY).intValue();
                AppMethodBeat.o(24663);
            }
        } catch (Exception e2) {
            i2 = Util.getInt(a.version.wMU, 0);
            AppMethodBeat.o(24663);
        }
        return i2;
    }

    private synchronized void MZ(int i2) {
        AppMethodBeat.i(24664);
        if (i2 > Util.getInt(a.version.wMU, 0)) {
            j.dNo().hv(a.version.key, String.valueOf(i2));
        }
        AppMethodBeat.o(24664);
    }

    public final int dMz() {
        AppMethodBeat.i(24665);
        dMx();
        try {
            String axY = this.wMN.axY(a.httpConnectTimeoutMillis.key);
            if (m.eP(axY)) {
                int intValue = Integer.valueOf(a.httpConnectTimeoutMillis.wMU).intValue();
                AppMethodBeat.o(24665);
                return intValue;
            }
            int intValue2 = Integer.valueOf(axY).intValue();
            AppMethodBeat.o(24665);
            return intValue2;
        } catch (Exception e2) {
            int i2 = Util.getInt(a.httpConnectTimeoutMillis.wMU, 0);
            AppMethodBeat.o(24665);
            return i2;
        }
    }

    private static void Na(int i2) {
        AppMethodBeat.i(24666);
        if (i2 > 0) {
            j.dNo().hv(a.httpConnectTimeoutMillis.key, String.valueOf(i2));
        }
        AppMethodBeat.o(24666);
    }

    public final int dMA() {
        AppMethodBeat.i(24667);
        dMx();
        try {
            String axY = this.wMN.axY(a.httpReadTimeoutMillis.key);
            if (m.eP(axY)) {
                int intValue = Integer.valueOf(a.httpReadTimeoutMillis.wMU).intValue();
                AppMethodBeat.o(24667);
                return intValue;
            }
            int intValue2 = Integer.valueOf(axY).intValue();
            AppMethodBeat.o(24667);
            return intValue2;
        } catch (Exception e2) {
            int i2 = Util.getInt(a.httpReadTimeoutMillis.wMU, 0);
            AppMethodBeat.o(24667);
            return i2;
        }
    }

    private void Nb(int i2) {
        AppMethodBeat.i(24668);
        if (i2 > 0) {
            this.wMN.hv(a.httpReadTimeoutMillis.key, String.valueOf(i2));
        }
        AppMethodBeat.o(24668);
    }

    public final String dMB() {
        AppMethodBeat.i(24669);
        dMx();
        try {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.wMN.axY(a.pingEnabled.key))) {
                AppMethodBeat.o(24669);
                return AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            AppMethodBeat.o(24669);
            return "1";
        } catch (Exception e2) {
            String str = a.pingEnabled.wMU;
            AppMethodBeat.o(24669);
            return str;
        }
    }

    private void axH(String str) {
        AppMethodBeat.i(24670);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "1".equals(str)) {
            try {
                this.wMN.hv(a.pingEnabled.key, str);
                AppMethodBeat.o(24670);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(24670);
    }

    public final String getPingUrl() {
        AppMethodBeat.i(24671);
        dMx();
        try {
            String axY = this.wMN.axY(a.pingUrl.key);
            if (m.eP(axY)) {
                String str = a.pingUrl.wMU;
                AppMethodBeat.o(24671);
                return str;
            }
            Uri.parse(axY);
            AppMethodBeat.o(24671);
            return axY;
        } catch (Exception e2) {
            String str2 = a.pingUrl.wMU;
            AppMethodBeat.o(24671);
            return str2;
        }
    }

    private void axI(String str) {
        AppMethodBeat.i(24672);
        if (!m.eP(str)) {
            try {
                Uri.parse(str);
                this.wMN.hv(a.pingUrl.key, str);
                AppMethodBeat.o(24672);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(24672);
    }

    public final String dMC() {
        AppMethodBeat.i(24673);
        dMx();
        try {
            String axY = this.wMN.axY(a.threeTwoBlackUrl.key);
            if (m.eP(axY)) {
                String str = a.threeTwoBlackUrl.wMU;
                AppMethodBeat.o(24673);
                return str;
            }
            Uri.parse(axY);
            AppMethodBeat.o(24673);
            return axY;
        } catch (Exception e2) {
            String str2 = a.threeTwoBlackUrl.wMU;
            AppMethodBeat.o(24673);
            return str2;
        }
    }

    private void axJ(String str) {
        AppMethodBeat.i(24674);
        if (!m.eP(str)) {
            try {
                Uri.parse(str);
                this.wMN.hv(a.threeTwoBlackUrl.key, str);
                AppMethodBeat.o(24674);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(24674);
    }

    public final String getUserAgent() {
        AppMethodBeat.i(24675);
        if (m.eP(this.userAgent)) {
            this.userAgent = z.cr(MMApplicationContext.getContext(), null).toLowerCase();
        }
        String str = this.userAgent;
        AppMethodBeat.o(24675);
        return str;
    }
}
