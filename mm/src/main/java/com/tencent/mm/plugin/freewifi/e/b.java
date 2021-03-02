package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.freewifi.e.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b {
    private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static b wPt = new b((byte) 0);

        static {
            AppMethodBeat.i(24870);
            AppMethodBeat.o(24870);
        }
    }

    public static b dNH() {
        AppMethodBeat.i(24871);
        b bVar = a.wPt;
        AppMethodBeat.o(24871);
        return bVar;
    }

    public static void aB(Intent intent) {
        int i2;
        int i3;
        boolean z = true;
        AppMethodBeat.i(24872);
        if (intent == null) {
            AppMethodBeat.o(24872);
            return;
        }
        String stringExtra = intent.getStringExtra("free_wifi_ap_key");
        if (!m.eP(stringExtra)) {
            int intExtra = intent.getIntExtra("free_wifi_threeone_startup_type", 0);
            if (2 == intExtra) {
                i2 = 11;
            } else if (3 == intExtra) {
                i2 = 12;
            } else if (4 == intExtra) {
                i2 = 13;
            } else {
                i2 = 1;
            }
            intent.putExtra("free_wifi_channel_id", i2);
            intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
            m.f(intent, intent.getStringExtra("free_wifi_schema_ticket"));
            intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.aw(intent) + "_" + m.ay(intent) + "_" + m.az(intent) + "_" + System.currentTimeMillis());
            boolean B = d.a.wPx.B(intent.getIntExtra("free_wifi_threeone_startup_type", 0), intent.getStringExtra("free_wifi_ap_key"), intent.getStringExtra("free_wifi_schema_ticket"));
            k.a dMF = k.dMF();
            dMF.ssid = m.axM(TAG);
            dMF.bssid = m.axN(TAG);
            dMF.dFd = stringExtra;
            dMF.quX = intent.getStringExtra("free_wifi_schema_ticket");
            dMF.wNc = m.ay(intent);
            dMF.wNd = k.b.GetThreeOneLock.wNO;
            dMF.wNe = k.b.GetThreeOneLock.name;
            dMF.channel = m.az(intent);
            if (B) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            dMF.result = i3;
            k dMH = dMF.dMH();
            if (B) {
                z = false;
            }
            dMH.c(intent, z).dMG();
            Log.i(TAG, "getLock = ".concat(String.valueOf(B)));
            m.axP("type=" + intent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + B);
            if (B) {
                m.f(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                intent.setClass(MMApplicationContext.getContext(), FreeWifiNetCheckUI.class);
                intent.addFlags(67108864);
                c.b(MMApplicationContext.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
        }
        AppMethodBeat.o(24872);
    }
}
