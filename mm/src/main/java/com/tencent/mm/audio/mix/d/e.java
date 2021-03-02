package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.g.a.a;
import com.tencent.mm.audio.mix.g.d;
import com.tencent.mm.audio.mix.h.c;
import com.tencent.mm.audio.mix.i.b;
import java.nio.ByteBuffer;

public final class e extends d {
    private Object duI = new Object();
    private a dvG;

    public e(d dVar, c cVar) {
        super(dVar, cVar);
        AppMethodBeat.i(136810);
        AppMethodBeat.o(136810);
    }

    @Override // com.tencent.mm.audio.mix.d.d, com.tencent.mm.audio.mix.d.l
    public final void onRelease() {
        AppMethodBeat.i(136811);
        super.onRelease();
        b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "releasePlayComponent");
        synchronized (this.duI) {
            try {
                if (this.dvG != null) {
                    this.dvG.release();
                    this.dvG = null;
                }
            } finally {
                AppMethodBeat.o(136811);
            }
        }
    }

    @Override // com.tencent.mm.audio.mix.d.c
    public final void YW() {
    }

    @Override // com.tencent.mm.audio.mix.d.l, com.tencent.mm.audio.mix.d.c
    public final void pause() {
        AppMethodBeat.i(136812);
        super.pause();
        synchronized (this.duI) {
            try {
                if (this.dvG != null) {
                    this.dvG.pause();
                }
            } finally {
                AppMethodBeat.o(136812);
            }
        }
    }

    @Override // com.tencent.mm.audio.mix.d.l, com.tencent.mm.audio.mix.d.c
    public final void YV() {
        AppMethodBeat.i(136813);
        b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
        je(5);
        this.dvr.set(true);
        this.dvt.set(false);
        Zc();
        AppMethodBeat.o(136813);
    }

    @Override // com.tencent.mm.audio.mix.d.l, com.tencent.mm.audio.mix.d.c
    public final void seek(int i2) {
        AppMethodBeat.i(136814);
        super.seek(i2);
        synchronized (this.duI) {
            try {
                if (this.dvG != null) {
                    this.dvG.seek(i2);
                }
            } finally {
                AppMethodBeat.o(136814);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.d.c
    public final void Zh() {
        AppMethodBeat.i(136815);
        b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
        super.Zh();
        synchronized (this.duI) {
            try {
                if (this.dvG != null) {
                    this.dvG.reset();
                }
            } finally {
                AppMethodBeat.o(136815);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.d.c
    public final void c(com.tencent.mm.audio.mix.a.e eVar) {
        AppMethodBeat.i(136816);
        if (Za().dtU) {
            this.sampleRate = 44100;
            this.channels = 2;
        } else {
            this.sampleRate = eVar.sampleRate;
            this.channels = eVar.channels;
        }
        byte[] bArr = eVar.dtQ;
        if (!this.dvo.get()) {
            if (this.dvG == null) {
                com.tencent.mm.audio.mix.a.d Za = Za();
                if (!Za.aBQ || Za.duration > 2000) {
                    this.dvG = new com.tencent.mm.audio.mix.g.a.c(this.sampleRate, this.channels, Za, this);
                } else {
                    this.dvG = new com.tencent.mm.audio.mix.g.a.b(this.sampleRate, this.channels, Za, this);
                }
                this.dvG.i(this.dvk.iJH);
                this.dvG.setVolume((float) this.dvk.iJG, (float) this.dvk.iJG);
            }
            if (this.dvG != null) {
                this.dvG.Y(bArr);
            }
        }
        if (eVar.dub) {
            com.tencent.mm.audio.mix.b.d.YH().b(eVar);
        }
        AppMethodBeat.o(136816);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.d.c
    public final void Zi() {
        AppMethodBeat.i(136817);
        b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
        super.Zi();
        if (this.dvG != null) {
            this.dvG.ZT();
            if (this.dvG instanceof com.tencent.mm.audio.mix.g.a.b) {
                do {
                    boolean z = this.dvq.get();
                    Zb();
                    if (!this.dvr.get()) {
                        if (z) {
                            b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
                            this.dvG.resume();
                        }
                        if (this.dvr.get()) {
                            break;
                        }
                    } else {
                        break;
                    }
                } while (this.dvq.get());
            }
        }
        AppMethodBeat.o(136817);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.d.d
    public final void a(com.tencent.mm.audio.mix.a.d dVar, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(136818);
        b(dVar, byteBuffer, i2);
        AppMethodBeat.o(136818);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.d.d
    public final void b(com.tencent.mm.audio.mix.a.d dVar) {
        AppMethodBeat.i(136819);
        if (this.dvl != null) {
            this.dvl.YR();
        }
        c(dVar);
        dVar.complete();
        AppMethodBeat.o(136819);
    }

    @Override // com.tencent.mm.audio.mix.d.c
    public final void Zj() {
        AppMethodBeat.i(136820);
        synchronized (this.duI) {
            try {
                if (this.dvG != null) {
                    this.dvG.setVolume(0.0f, 0.0f);
                }
            } finally {
                AppMethodBeat.o(136820);
            }
        }
    }

    @Override // com.tencent.mm.audio.mix.d.l, com.tencent.mm.audio.mix.d.c
    public final long getCurrentPosition() {
        AppMethodBeat.i(177344);
        synchronized (this.duI) {
            try {
                if (this.dvG != null) {
                    return this.dvG.getCurrentPosition();
                }
                AppMethodBeat.o(177344);
                return -1;
            } finally {
                AppMethodBeat.o(177344);
            }
        }
    }
}
