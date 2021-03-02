package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@TargetApi(19)
public class HCEService extends HostApduService {
    private String mAppId = null;

    public void onCreate() {
        AppMethodBeat.i(136155);
        super.onCreate();
        Log.i("MicroMsg.HCEService", "alvinluo HCEService onCreate");
        AppMethodBeat.o(136155);
    }

    public void onDestroy() {
        AppMethodBeat.i(136156);
        super.onDestroy();
        Log.i("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
        b.mhH.bHT();
        AppMethodBeat.o(136156);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(136157);
        Log.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", Long.valueOf(currentTimeMillis));
        if (intent == null) {
            int onStartCommand = super.onStartCommand(intent, i2, i3);
            AppMethodBeat.o(136157);
            return onStartCommand;
        }
        try {
            b bVar = b.mhH;
            Log.i("MicroMsg.HCEServiceMgr", "alvinluo setHceService");
            bVar.mhG = this;
            bVar.MU = (ResultReceiver) intent.getParcelableExtra("HCE_Result_Receiver");
            this.mAppId = intent.getStringExtra("key_appid");
            b bVar2 = b.mhH;
            bVar2.mhf = intent.getIntExtra("key_time_limit", 1500);
            if (bVar2.mhf < 1500) {
                Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d smaller than: %d and set a valid value", Integer.valueOf(bVar2.mhf), 1500);
                bVar2.mhf = 1500;
            }
            if (bVar2.mhf > 60000) {
                Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d, bigger than: %d and set a valid value", Integer.valueOf(bVar2.mhf), 60000);
                bVar2.mhf = 60000;
            }
            Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService valid timeLimit: %d", Integer.valueOf(bVar2.mhf));
            b bVar3 = b.mhH;
            String str = this.mAppId;
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_aid_list");
            bVar3.mAppId = str;
            bVar3.mhy = stringArrayListExtra;
            b.mhH.bHS();
            b.mhH.mhz = false;
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.HCEService", e2, "under dos attack(?): invalid key_result_receiver", new Object[0]);
        }
        int onStartCommand2 = super.onStartCommand(intent, i2, i3);
        AppMethodBeat.o(136157);
        return onStartCommand2;
    }

    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        AppMethodBeat.i(136158);
        Log.i("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", c.aL(bArr));
        byte[] encode = Base64.encode(bArr, 2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_apdu_command", new String(encode, StandardCharsets.UTF_8));
        b.mhH.a(31, this.mAppId, bundle2);
        AppMethodBeat.o(136158);
        return null;
    }

    public void onDeactivated(int i2) {
        AppMethodBeat.i(136159);
        Log.i("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", Integer.valueOf(i2));
        b.mhH.mhB = false;
        b.mhH.mhC = false;
        Bundle bundle = new Bundle();
        bundle.putInt("key_on_deactivated_reason", i2);
        b.mhH.b(this.mAppId, 41, bundle);
        AppMethodBeat.o(136159);
    }
}
