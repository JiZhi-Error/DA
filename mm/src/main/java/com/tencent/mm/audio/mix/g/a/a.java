package com.tencent.mm.audio.mix.g.a;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.g.f;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a {
    protected static volatile AtomicInteger dxS = new AtomicInteger(0);
    protected static volatile AtomicInteger dxT = new AtomicInteger(0);
    protected static volatile AtomicInteger dxU = new AtomicInteger(0);
    protected int bNu = 0;
    protected volatile AudioTrack bfn;
    protected byte[] byteBuffer;
    protected int channels = 0;
    protected long cqe = -1;
    protected d duL;
    protected int dxO = 0;
    protected int dxP = 0;
    protected double dxQ = 0.0d;
    protected f dxR;
    protected int sampleRate = 0;
    protected float volume = 1.0f;

    /* access modifiers changed from: protected */
    public abstract boolean createAudioTrack();

    public a(int i2, int i3, d dVar, f fVar) {
        this.sampleRate = i2;
        this.channels = i3;
        this.duL = dVar;
        this.dxR = fVar;
    }

    public void Y(byte[] bArr) {
    }

    public void ZT() {
    }

    public void resume() {
    }

    public void pause() {
    }

    public final void seek(int i2) {
        b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", Integer.valueOf(this.bNu));
        this.bNu = i2;
    }

    public final void setVolume(float f2, float f3) {
        try {
            if (this.bfn != null && (this.bfn.getState() == 1 || this.bfn.getState() == 2)) {
                this.bfn.setStereoVolume(f2, f3);
            }
        } catch (IllegalStateException e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e2, r.NAME, new Object[0]);
        } catch (Exception e3) {
            b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e3, r.NAME, new Object[0]);
        }
        this.volume = f2;
    }

    public final void release() {
        releaseAudioTrack();
        this.dxR = null;
        this.duL = null;
        this.byteBuffer = null;
        this.dxO = 0;
        this.dxP = 0;
    }

    /* access modifiers changed from: protected */
    public final void releaseAudioTrack() {
        try {
            if (this.bfn != null) {
                dxU.decrementAndGet();
            }
            if (!(this.bfn == null || this.bfn.getState() == 0)) {
                this.bfn.stop();
                this.bfn.flush();
            }
            if (this.bfn != null) {
                this.bfn.release();
                this.bfn = null;
            }
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e2, "releaseAudioTrack", new Object[0]);
        }
    }

    public void reset() {
        this.dxO = 0;
        this.dxP = 0;
        if (this.byteBuffer != null) {
            Arrays.fill(this.byteBuffer, 0, this.byteBuffer.length, (byte) 0);
        }
    }

    public final void i(double d2) {
        this.dxQ = d2;
    }

    public final void j(double d2) {
        if (Build.VERSION.SDK_INT >= 23) {
            b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "setPlaybackRate:%f", Double.valueOf(d2));
            try {
                if (this.bfn == null) {
                    return;
                }
                if (this.bfn.getState() == 1 || this.bfn.getState() == 2) {
                    PlaybackParams playbackParams = this.bfn.getPlaybackParams();
                    playbackParams.setSpeed((float) d2);
                    this.bfn.setPlaybackParams(playbackParams);
                }
            } catch (IllegalStateException e2) {
                b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e2, "setPlaybackRate", new Object[0]);
            } catch (Exception e3) {
                b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e3, "setPlaybackRate", new Object[0]);
            }
        }
    }

    public final long getCurrentPosition() {
        try {
            if (this.bfn == null || this.bfn.getState() == 0) {
                return this.cqe;
            }
            long round = Math.round((((double) ((long) this.bfn.getPlaybackHeadPosition())) / ((double) this.bfn.getSampleRate())) * 1000.0d);
            this.cqe = round;
            return round;
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e2, "getCurrentPosition", new Object[0]);
            return -1;
        }
    }
}
