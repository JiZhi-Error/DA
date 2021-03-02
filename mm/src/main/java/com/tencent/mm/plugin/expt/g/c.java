package com.tencent.mm.plugin.expt.g;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class c {
    static c sKi;

    c() {
    }

    /* access modifiers changed from: package-private */
    public static class a implements b<Bundle, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<IPCVoid> dVar) {
            AppMethodBeat.i(122364);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("key_page_flow_name");
            int i2 = bundle2.getInt("key_page_flow_type");
            Log.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "MMPageFlowReceiver async receive action name[%s-%d-%d] type[%d]", string, Integer.valueOf(bundle2.getInt("key_page_flow_hashcode", 0)), Long.valueOf(bundle2.getLong("key_page_flow_time_stamp", 0)), Integer.valueOf(i2));
            try {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.expt.g.c.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(122363);
                        d.cRu().cRw();
                        AppMethodBeat.o(122363);
                    }
                });
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMPageFlowSenderByIPCInvoker", e2, "post to main thread error? [%s]", e2.toString());
            }
            h.INSTANCE.idkeyStat(932, 101, 1, false);
            AppMethodBeat.o(122364);
        }
    }
}
