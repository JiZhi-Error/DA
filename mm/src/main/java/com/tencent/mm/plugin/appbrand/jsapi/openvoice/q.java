package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class q {
    private static String TAG = "MicroMsg.OpenVoice.VoIpLogicHandler";

    public static void aaB(String str) {
        AppMethodBeat.i(226948);
        Log.i(TAG, "hy:showFloatBall, appId:%s, is1v1:%s", str, Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.INSTANCE.qtC));
        if (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.INSTANCE.qtB) {
            a aVar = new a();
            aVar.mJH.appId = str;
            aVar.mJH.beL = 16;
            aVar.mJH.dDe = 1;
            EventCenter.instance.publish(aVar);
        }
        AppMethodBeat.o(226948);
    }

    public static void aaC(String str) {
        AppMethodBeat.i(226949);
        if (TextUtils.isEmpty(str)) {
            Log.i(TAG, "closeFloatBall, appId is empty");
            AppMethodBeat.o(226949);
            return;
        }
        Log.i(TAG, "hy:closeFloatBall, appId:%s", str);
        a aVar = new a();
        aVar.mJH.appId = str;
        aVar.mJH.beL = 16;
        aVar.mJH.dDe = 2;
        EventCenter.instance.publish(aVar);
        AppMethodBeat.o(226949);
    }

    public static boolean bIi() {
        AppMethodBeat.i(226950);
        Log.i(TAG, "hy:handUpVoIPTalking, is1v1:%s", Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.INSTANCE.qtC));
        if (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.INSTANCE.qtB) {
            Log.i(TAG, "hy:handUpVoIPTalking, stop voip talking");
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.INSTANCE.a(new b<String>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.q.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                    AppMethodBeat.i(226947);
                    Log.i(q.TAG, "hy:handUp VoIP Talking exit room");
                    AppMethodBeat.o(226947);
                }
            }, q.a.ReasonWeappStopFromPassiveFloatBall);
            AppMethodBeat.o(226950);
            return true;
        }
        Log.i(TAG, "hy:handUpVoIPTalking, voip is stopped");
        AppMethodBeat.o(226950);
        return false;
    }
}
