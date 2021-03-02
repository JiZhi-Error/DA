package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public class FCMInstanceIDListenerService extends FirebaseInstanceIdService {
    @Override // com.google.firebase.iid.FirebaseInstanceIdService
    public final void onTokenRefresh() {
        AppMethodBeat.i(127565);
        String token = FirebaseInstanceId.yc().getToken();
        Log.i("MicroMsg.FCM.FCMInstanceIDListenerService", "Refreshed token: ".concat(String.valueOf(token)));
        g.aAf();
        if (a.azo()) {
            b cXf = b.cXf();
            if (cXf != null) {
                cXf.asA(token);
                AppMethodBeat.o(127565);
                return;
            }
            Log.w("MicroMsg.FCM.FCMInstanceIDListenerService", "fcmRegister null, not reg token");
            AppMethodBeat.o(127565);
            return;
        }
        Log.w("MicroMsg.FCM.FCMInstanceIDListenerService", "User is not logined, not reg token");
        AppMethodBeat.o(127565);
    }
}
