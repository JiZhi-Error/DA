package com.tencent.mm.plugin.wear.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class j {
    MMHandler ndA;

    public j() {
        AppMethodBeat.i(30036);
        if (d.oF(18)) {
            this.ndA = new a("WearWorker_worker_thread");
            Log.i("MicroMsg.Wear.WearWorker", "start worker");
        }
        AppMethodBeat.o(30036);
    }

    public final void a(com.tencent.mm.plugin.wear.model.f.d dVar) {
        AppMethodBeat.i(30037);
        if (this.ndA != null) {
            this.ndA.sendMessage(this.ndA.obtainMessage(0, dVar));
        }
        AppMethodBeat.o(30037);
    }

    class a extends MMHandler {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(30035);
            com.tencent.mm.plugin.wear.model.f.d dVar = (com.tencent.mm.plugin.wear.model.f.d) message.obj;
            if (dVar != null) {
                try {
                    dVar.run();
                    AppMethodBeat.o(30035);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Wear.WearWorker", e2.getCause(), "run task %s occur exception", dVar.getName());
                }
            }
            AppMethodBeat.o(30035);
        }
    }
}
