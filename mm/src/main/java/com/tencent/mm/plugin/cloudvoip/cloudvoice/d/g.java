package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;

public final class g {
    boolean isStart = false;
    final Object qrY = new Object();
    a qrZ = new a();
    f.a qsa = new f.a();

    public g() {
        AppMethodBeat.i(90793);
        AppMethodBeat.o(90793);
    }

    public final int a(b bVar, int i2, int i3, int i4) {
        int i5 = 0;
        AppMethodBeat.i(90794);
        Log.v("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "hy: start play with %d, %d, %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        synchronized (this.qrY) {
            try {
                if (this.isStart) {
                    Log.d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
                    i5 = -1;
                } else {
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", Integer.valueOf(hashCode()));
                    a aVar = this.qrZ;
                    p.h(bVar, "devCallBack");
                    if (aVar.qrz == null) {
                        aVar.qrz = new c();
                        c cVar = aVar.qrz;
                        if (cVar != null) {
                            cVar.N(i2, i3, i4, 0);
                        }
                    }
                    c cVar2 = aVar.qrz;
                    if (cVar2 != null) {
                        cVar2.F(MMApplicationContext.getContext(), false);
                    }
                    c cVar3 = aVar.qrz;
                    if (cVar3 != null) {
                        cVar3.GTi = bVar;
                    }
                    c cVar4 = aVar.qrz;
                    if (cVar4 != null) {
                        i5 = cVar4.fFp();
                    }
                    this.qsa.gLm = SystemClock.elapsedRealtime();
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.qsa.apr());
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
                    this.isStart = true;
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", Integer.valueOf(i5));
                    AppMethodBeat.o(90794);
                }
            } finally {
                AppMethodBeat.o(90794);
            }
        }
        return i5;
    }
}
