package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c implements QueueWorkerThread.ThreadObject {
    public BlockingQueue<g.a> jlE = new ArrayBlockingQueue(1024);
    public String mFileName = null;

    public c() {
        AppMethodBeat.i(148377);
        AppMethodBeat.o(148377);
    }

    @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
    public final boolean onPostExecute() {
        return false;
    }

    @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
    public final boolean doInBackground() {
        AppMethodBeat.i(148378);
        Log.d("MicroMsg.SpeexEncoderWorker", "doEncode");
        d dVar = new d();
        String bfO = b.bfO();
        try {
            Log.i("MicroMsg.SpeexEncoderWorker", "path ".concat(String.valueOf(bfO)));
            o oVar = new o(bfO);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            dVar.hz(bfO + this.mFileName + ".temp");
            while (this.jlE.size() > 0) {
                g.a poll = this.jlE.poll();
                if (poll.buf != null && poll.dAc > 0) {
                    dVar.a(poll, 0, false);
                }
            }
            dVar.abP();
            try {
                new o(bfO + this.mFileName + ".temp").am(new o(bfO + this.mFileName + ".spx"));
            } catch (Exception e2) {
                Log.e("MicroMsg.SpeexEncoderWorker", "exception:%s", Util.stackTraceToString(e2));
            }
            e.bfX().start();
        } catch (Exception e3) {
            Log.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", e3);
        }
        AppMethodBeat.o(148378);
        return true;
    }
}
