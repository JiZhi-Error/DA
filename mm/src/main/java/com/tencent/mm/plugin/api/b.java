package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends com.tencent.mm.plugin.mmsight.api.b {
    private d kxS;
    private VideoTransPara kxT;

    public static class a implements b.a {
        @Override // com.tencent.mm.plugin.mmsight.api.b.a
        public final com.tencent.mm.plugin.mmsight.api.b bqG() {
            AppMethodBeat.i(89186);
            b bVar = new b();
            AppMethodBeat.o(89186);
            return bVar;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.api.b
    public final void a(com.tencent.mm.remoteservice.d dVar, VideoTransPara videoTransPara) {
        AppMethodBeat.i(89187);
        if (dVar != null) {
            CaptureMMProxy.createProxy(new CaptureMMProxy(dVar));
        }
        k.d(videoTransPara);
        this.kxT = videoTransPara;
        AppMethodBeat.o(89187);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.b
    public final void b(com.tencent.mm.remoteservice.d dVar, VideoTransPara videoTransPara) {
        AppMethodBeat.i(89188);
        if (dVar != null) {
            CaptureMMProxy.createProxy(new CaptureMMProxy(dVar));
        }
        k.d(videoTransPara);
        k.zuy.gIP = 1;
        this.kxT = videoTransPara;
        AppMethodBeat.o(89188);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.b
    public final d bqF() {
        AppMethodBeat.i(89189);
        if (this.kxT != null) {
            l.ekc();
            this.kxS = l.q(this.kxT);
        }
        if (this.kxS instanceof m) {
            Log.i("MicroMsg.MMSightFFMpegRecorder", "setStopOnCameraDataThread: %s", Boolean.TRUE);
            ((m) this.kxS).isU = true;
        }
        d dVar = this.kxS;
        AppMethodBeat.o(89189);
        return dVar;
    }
}
