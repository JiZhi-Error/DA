package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.wcdb.FileUtils;

public final class l {
    boolean isStart = false;
    final Object qrY = new Object();
    c qrz = null;
    f.a qsa = new f.a();

    public l() {
        AppMethodBeat.i(114414);
        AppMethodBeat.o(114414);
    }

    public final int a(b bVar, int i2, int i3) {
        int i4 = -1;
        AppMethodBeat.i(114415);
        synchronized (this.qrY) {
            try {
                if (this.isStart) {
                    Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
                } else {
                    Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", Integer.valueOf(hashCode()));
                    if (this.qrz == null) {
                        int i5 = ae.gKu.gFd;
                        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_flag, -1);
                        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_s = %d", Integer.valueOf(i5));
                        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_x = %d", Integer.valueOf(a2));
                        this.qrz = new c();
                        byte[] bArr = {0};
                        if (i5 <= 0 || a2 <= 0) {
                            this.qrz.N(i2, 1, i3, 0);
                        } else {
                            bArr[0] = 1;
                            this.qrz.N(i2, 2, i3, 0);
                        }
                        ac.eol().zMd.setAppCmd(FileUtils.S_IRWXU, bArr, 1);
                    }
                    this.qrz.F(MMApplicationContext.getContext(), false);
                    this.qrz.GTi = bVar;
                    if (ac.eom().zMV != null) {
                        ac.eom().zMV.Yl();
                        ac.eom().zMV.zHb = this.qrz;
                    }
                    Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
                    this.isStart = true;
                    this.qsa.gLm = SystemClock.elapsedRealtime();
                    i4 = this.qrz.fFp();
                    Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.qsa.apr());
                    Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", Integer.valueOf(i4));
                    AppMethodBeat.o(114415);
                }
            } finally {
                AppMethodBeat.o(114415);
            }
        }
        return i4;
    }
}
