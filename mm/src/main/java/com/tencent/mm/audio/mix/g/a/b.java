package com.tencent.mm.audio.mix.g.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.g.f;

public final class b extends a {
    private static long dxV = 0;
    private static long dxW = 0;
    private Thread aGs;

    public b(int i2, int i3, d dVar, f fVar) {
        super(i2, i3, dVar, fVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.g.a.a
    public final boolean createAudioTrack() {
        int i2;
        AppMethodBeat.i(136945);
        if (this.dxO > 1) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "createAudioTrack fail count reach MAX COUNT");
            AppMethodBeat.o(136945);
            return false;
        }
        int i3 = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i3, 2);
        if (this.duL != null && this.duL.size() > 0) {
            minBufferSize = this.duL.size() * 3536;
        }
        if (this.dxQ > 1.0d) {
            i2 = (int) (((double) minBufferSize) * this.dxQ);
        } else {
            i2 = minBufferSize;
        }
        if (this.bfn == null) {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "new AudioTrack");
            System.currentTimeMillis();
            this.bfn = new AudioTrack(3, this.sampleRate, i3, 2, i2, 0);
            this.dxO++;
            dxT.incrementAndGet();
        }
        if (this.bfn == null || this.bfn.getState() != 2) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audio track not initialized");
            dxS.incrementAndGet();
            if (this.bfn != null) {
                com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack getState:%d", Integer.valueOf(this.bfn.getState()));
                try {
                    this.bfn.release();
                    this.bfn = null;
                } catch (Exception e2) {
                    com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e2, "AudioTrack release", new Object[0]);
                }
            }
            AppMethodBeat.o(136945);
            return false;
        }
        dxU.incrementAndGet();
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audioTrackCount:%d", Integer.valueOf(dxU.get()));
        AppMethodBeat.o(136945);
        return true;
    }

    @Override // com.tencent.mm.audio.mix.g.a.a
    public final void Y(byte[] bArr) {
        int i2;
        AppMethodBeat.i(136946);
        if (this.bfn == null) {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack before");
            if (!createAudioTrack()) {
                if (this.dxR != null) {
                    this.dxR.onError(707);
                }
                com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack fail");
                AppMethodBeat.o(136946);
                return;
            }
            try {
                AudioTrack audioTrack = this.bfn;
                if (audioTrack != null) {
                    audioTrack.setStereoVolume(this.volume, this.volume);
                }
            } catch (IllegalStateException e2) {
                com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e2, "setStereoVolume", new Object[0]);
            }
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack after and success!");
        }
        if (this.byteBuffer == null) {
            if (this.duL != null) {
                i2 = this.duL.size() * 3536;
            } else {
                i2 = 3536;
            }
            if (i2 == 0) {
                i2 = 3536;
            }
            if (bArr.length == 3536) {
                i2++;
            }
            this.byteBuffer = new byte[i2];
        }
        if (this.dxP + bArr.length <= this.byteBuffer.length) {
            System.arraycopy(bArr, 0, this.byteBuffer, this.dxP, bArr.length);
            this.dxP += bArr.length;
        }
        AppMethodBeat.o(136946);
    }

    @Override // com.tencent.mm.audio.mix.g.a.a
    public final void ZT() {
        AppMethodBeat.i(136947);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "playFlush play_count:%d, fail_count:%d", Integer.valueOf(dxT.get()), Integer.valueOf(dxS.get()));
        if (this.bfn != null) {
            if (this.dxR != null) {
                this.dxR.Zg();
            }
            AudioTrack audioTrack = this.bfn;
            if (audioTrack.getState() == 2 && audioTrack.write(this.byteBuffer, 0, this.byteBuffer.length) <= 0) {
                com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack write fail, should write length:%d", Integer.valueOf(this.byteBuffer.length));
                this.dxR.onError(708);
                AppMethodBeat.o(136947);
                return;
            } else if (audioTrack.getState() == 1) {
                audioTrack.reloadStaticData();
                j(this.dxQ);
                audioTrack.play();
                this.aGs = Thread.currentThread();
                try {
                    long j2 = this.duL.duration;
                    if (j2 <= 0) {
                        j2 = 2000;
                    }
                    Thread.sleep(j2);
                    AppMethodBeat.o(136947);
                    return;
                } catch (Exception e2) {
                    com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
                }
            }
        }
        AppMethodBeat.o(136947);
    }

    @Override // com.tencent.mm.audio.mix.g.a.a
    public final void resume() {
        AppMethodBeat.i(136948);
        AudioTrack audioTrack = this.bfn;
        if (audioTrack != null && audioTrack.getState() == 1) {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "resume");
            if (this.dxR != null) {
                this.dxR.Zg();
            }
            try {
                audioTrack.setStereoVolume(this.volume, this.volume);
            } catch (IllegalStateException e2) {
                com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e2, "setStereoVolume", new Object[0]);
            }
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play startPos:%d", Integer.valueOf(this.bNu));
            audioTrack.setPlaybackHeadPosition(this.bNu);
            audioTrack.play();
            try {
                long j2 = this.duL.duration;
                if (j2 <= 0) {
                    j2 = 2000;
                }
                Thread.sleep(j2);
                AppMethodBeat.o(136948);
                return;
            } catch (Exception e3) {
                com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
            }
        }
        AppMethodBeat.o(136948);
    }

    @Override // com.tencent.mm.audio.mix.g.a.a
    public final void pause() {
        AppMethodBeat.i(136949);
        AudioTrack audioTrack = this.bfn;
        if (audioTrack != null) {
            int state = audioTrack.getState();
            int playState = audioTrack.getPlayState();
            if (state == 1 && playState == 3) {
                try {
                    audioTrack.pause();
                    this.bNu = audioTrack.getPlaybackHeadPosition();
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "pause startPos :%d", Integer.valueOf(this.bNu));
                    if (this.aGs != null) {
                        this.aGs.interrupt();
                    }
                    AppMethodBeat.o(136949);
                    return;
                } catch (Exception e2) {
                    com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e2, "pause", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(136949);
    }

    @Override // com.tencent.mm.audio.mix.g.a.a
    public final void reset() {
        AppMethodBeat.i(136950);
        super.reset();
        releaseAudioTrack();
        this.aGs = null;
        AppMethodBeat.o(136950);
    }
}
