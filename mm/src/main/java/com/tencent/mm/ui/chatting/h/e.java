package com.tencent.mm.ui.chatting.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.chatting.h.d;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e implements d {
    f PDP;
    c PDQ;
    private AtomicBoolean iLz = new AtomicBoolean(false);
    final Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.ui.chatting.h.e.AnonymousClass1 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(36426);
            d.C2097d dVar = (d.C2097d) message.obj;
            if (dVar.iLz.get()) {
                Log.w("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] cancel update!!!");
                AppMethodBeat.o(36426);
                return;
            }
            switch (message.what) {
                case 1:
                    boolean b2 = e.this.PDP.b(dVar.PDL);
                    if (b2) {
                        dVar.PDO = e.this.PDQ.jv(dVar.PDM);
                        e.this.PDP.a(dVar);
                    }
                    Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! isAvailableUpdate=%s result:%s", Boolean.valueOf(b2), dVar.toString());
                    break;
            }
            AppMethodBeat.o(36426);
        }
    };
    private final MMHandler sZa;

    public e(f fVar, c cVar) {
        AppMethodBeat.i(36429);
        this.PDP = fVar;
        this.PDQ = cVar;
        this.sZa = new MMHandler("ListDataLoader$");
        AppMethodBeat.o(36429);
    }

    @Override // com.tencent.mm.ui.chatting.h.d
    public final void a(d.a aVar, boolean z, d.c cVar) {
        AppMethodBeat.i(36430);
        Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", aVar, Boolean.valueOf(z), Long.valueOf(Thread.currentThread().getId()));
        a aVar2 = new a(aVar, z, cVar, this.iLz);
        if (z) {
            aVar2.run();
            AppMethodBeat.o(36430);
            return;
        }
        this.sZa.post(aVar2);
        AppMethodBeat.o(36430);
    }

    @Override // com.tencent.mm.ui.chatting.h.d
    public final void cancel() {
        AppMethodBeat.i(36431);
        synchronized (this) {
            try {
                Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
                this.iLz.set(true);
                this.iLz = new AtomicBoolean(false);
                this.sZa.removeCallbacksAndMessages(null);
                this.mMainHandler.removeCallbacksAndMessages(null);
            } finally {
                AppMethodBeat.o(36431);
            }
        }
    }

    class a implements Runnable {
        d.a PDL;
        d.c PDS;
        boolean ebI;
        AtomicBoolean iLz;

        a(d.a aVar, boolean z, d.c cVar, AtomicBoolean atomicBoolean) {
            this.PDL = aVar;
            this.ebI = z;
            this.PDS = cVar;
            this.iLz = atomicBoolean;
        }

        public final void run() {
            AppMethodBeat.i(36428);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                final d.C2097d dVar = new d.C2097d(this.PDL, this.iLz);
                e.this.PDQ.a(this.PDL, this.PDS.b(dVar), dVar, new d.b() {
                    /* class com.tencent.mm.ui.chatting.h.e.a.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.chatting.h.d.b
                    public final void next() {
                        AppMethodBeat.i(36427);
                        a.this.PDS.c(dVar);
                        a aVar = a.this;
                        d.C2097d dVar = dVar;
                        synchronized (e.this) {
                            try {
                                if (aVar.iLz.get()) {
                                    Log.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                                    return;
                                }
                                Message message = new Message();
                                message.what = 1;
                                message.obj = dVar;
                                if (!aVar.ebI || Looper.myLooper() != Looper.getMainLooper()) {
                                    e.this.mMainHandler.sendMessage(message);
                                } else {
                                    e.this.mMainHandler.handleMessage(message);
                                }
                                AppMethodBeat.o(36427);
                            } finally {
                                AppMethodBeat.o(36427);
                            }
                        }
                    }
                });
            } catch (ArrayIndexOutOfBoundsException e2) {
                Log.printErrStackTrace("MicroMsg.ChattingLoader.ListDataLoader", e2, "", new Object[0]);
            }
            Log.d("MicroMsg.ChattingLoader.ListDataLoader", "[LoadTask.run] cost:%dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(36428);
        }
    }
}
