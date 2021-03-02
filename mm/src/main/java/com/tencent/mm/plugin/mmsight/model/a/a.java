package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static int wEc = 4;
    static int zvb = 4;
    MMHandler handler;
    boolean stop = false;
    MMHandler[] zvc;
    int zvd = 0;
    private int zve = 0;
    private LinkedList<b> zvf = new LinkedList<>();
    private AbstractC1480a zvg;
    b.a zvh = new b.a() {
        /* class com.tencent.mm.plugin.mmsight.model.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.mmsight.model.a.b.a
        public final void a(final b bVar) {
            AppMethodBeat.i(89464);
            a.this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.mmsight.model.a.a.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(89463);
                    a.a(a.this, bVar);
                    AppMethodBeat.o(89463);
                }
            });
            AppMethodBeat.o(89464);
        }
    };

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1480a {
        void output(byte[] bArr);
    }

    public a(AbstractC1480a aVar) {
        AppMethodBeat.i(89465);
        this.zvg = aVar;
        zvb = -1;
        if (CaptureMMProxy.getInstance() != null) {
            zvb = CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_THREADCOUNT_INT_SYNC, -1);
        }
        if (zvb == -1) {
            zvb = Runtime.getRuntime().availableProcessors();
            zvb = Math.min(wEc, zvb);
            Log.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", Integer.valueOf(zvb), Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        } else {
            Log.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", Integer.valueOf(zvb));
        }
        this.zvc = new MMHandler[zvb];
        SightVideoJNI.initScaleAndRoateBuffer(zvb);
        for (int i2 = 0; i2 < this.zvc.length; i2++) {
            this.zvc[i2] = new MMHandler("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i2)));
        }
        this.stop = false;
        AppMethodBeat.o(89465);
    }

    private void ejU() {
        boolean z;
        AppMethodBeat.i(89466);
        Log.i("MicroMsg.ForwardMgr", "processBufList %d %d", Integer.valueOf(this.zvf.size()), Integer.valueOf(this.zve));
        while (this.zvf.size() != 0) {
            Log.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", Integer.valueOf(this.zvf.size()), Integer.valueOf(this.zve));
            Iterator<b> it = this.zvf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    continue;
                    break;
                }
                b next = it.next();
                if (this.zve == next.zvo) {
                    this.zve++;
                    this.zvg.output(next.zvm);
                    this.zvf.remove(next);
                    z = true;
                    continue;
                    break;
                }
            }
            if (!z) {
                AppMethodBeat.o(89466);
                return;
            }
        }
        AppMethodBeat.o(89466);
    }

    public final boolean ejV() {
        return this.zve == this.zvd;
    }

    public final void stop() {
        AppMethodBeat.i(89467);
        Log.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", Util.getStack().toString());
        for (int i2 = 0; i2 < this.zvc.length; i2++) {
            if (this.zvc[i2] != null) {
                this.zvc[i2].getSerial().RUS.quit();
                this.zvc[i2] = null;
            }
        }
        SightVideoJNI.releaseScaleAndRoateBuffer(zvb);
        this.stop = true;
        AppMethodBeat.o(89467);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(89468);
        try {
            stop();
        } catch (Throwable th) {
        }
        super.finalize();
        AppMethodBeat.o(89468);
    }

    static /* synthetic */ void a(a aVar, b bVar) {
        AppMethodBeat.i(89469);
        Log.i("MicroMsg.ForwardMgr", "receive buf bufIndex: %d receiveIndex: %d", Integer.valueOf(bVar.zvo), Integer.valueOf(aVar.zve));
        if (aVar.zve == bVar.zvo) {
            aVar.zve++;
            aVar.zvg.output(bVar.zvm);
            aVar.ejU();
            AppMethodBeat.o(89469);
            return;
        }
        aVar.zvf.add(bVar);
        aVar.ejU();
        AppMethodBeat.o(89469);
    }
}
