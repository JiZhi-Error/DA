package com.tencent.mm.audio.mix.g.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.g.f;
import com.tencent.mm.audio.mix.i.b;

public final class c extends a {
    private static long dxV = 0;
    private static long dxW = 0;

    public c(int i2, int i3, d dVar, f fVar) {
        super(i2, i3, dVar, fVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.g.a.a
    public final boolean createAudioTrack() {
        AppMethodBeat.i(136951);
        b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack");
        if (this.dxO > 1) {
            b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack fail count reach MAX COUNT");
            AppMethodBeat.o(136951);
            return false;
        }
        int i2 = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i2, 2);
        if (minBufferSize <= 0) {
            b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack miniBufferSize %d is illegal", Integer.valueOf(minBufferSize));
            AppMethodBeat.o(136951);
            return false;
        }
        if (this.dxQ > 1.0d) {
            minBufferSize = (int) (this.dxQ * ((double) minBufferSize));
        }
        if (this.bfn == null) {
            b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "new AudioTrack");
            System.currentTimeMillis();
            this.bfn = new AudioTrack(3, this.sampleRate, i2, 2, minBufferSize, 1);
            this.dxO++;
            dxT.incrementAndGet();
        }
        if (this.bfn == null || this.bfn.getState() != 1) {
            dxS.incrementAndGet();
            b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "play_count:%d, fail_count:%d", Integer.valueOf(dxT.get()), Integer.valueOf(dxS.get()));
            b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audio track not initialized");
            if (this.bfn != null) {
                b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "AudioTrack getState:%d", Integer.valueOf(this.bfn.getState()));
                try {
                    this.bfn.release();
                    this.bfn = null;
                } catch (Exception e2) {
                    b.printErrStackTrace("MicroMsg.Mix.AudioPcmStreamPlayComponent", e2, "AudioTrack release", new Object[0]);
                }
            }
            AppMethodBeat.o(136951);
            return false;
        }
        dxU.incrementAndGet();
        b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audioTrackCount:%d", Integer.valueOf(dxU.get()));
        AppMethodBeat.o(136951);
        return true;
    }

    @Override // com.tencent.mm.audio.mix.g.a.a
    public final void Y(byte[] bArr) {
        AppMethodBeat.i(136952);
        if (this.bfn == null) {
            b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack before");
            if (!createAudioTrack()) {
                if (this.dxR != null) {
                    this.dxR.onError(707);
                }
                b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack fail");
                AppMethodBeat.o(136952);
                return;
            }
            b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack success");
            try {
                j(this.dxQ);
                this.bfn.play();
                this.bfn.setStereoVolume(this.volume, this.volume);
            } catch (IllegalStateException e2) {
                b.printErrStackTrace("MicroMsg.Mix.AudioPcmStreamPlayComponent", e2, "setStereoVolume", new Object[0]);
            }
            b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack after");
        }
        if (this.dxR != null) {
            this.dxR.Zg();
        }
        this.bfn.setStereoVolume(this.volume, this.volume);
        this.bfn.write(bArr, 0, bArr.length);
        AppMethodBeat.o(136952);
    }

    @Override // com.tencent.mm.audio.mix.g.a.a
    public final void ZT() {
        AppMethodBeat.i(136953);
        super.ZT();
        b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "playFlush");
        AppMethodBeat.o(136953);
    }
}
