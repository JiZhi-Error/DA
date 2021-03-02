package com.tencent.mm.plugin.n;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.a.h;
import com.tencent.mm.plugin.a.m;
import com.tencent.mm.plugin.a.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.soter.core.biometric.FaceManager;
import java.nio.ByteBuffer;
import java.util.Iterator;

public final class a extends i {
    private AudioTrack bfn;
    private int channels;
    private boolean guh = false;
    private int sampleRate;

    public a(h hVar, MMHandler mMHandler) {
        super(hVar, mMHandler);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.n.i
    public final boolean a(long j2, long j3, z zVar, ByteBuffer byteBuffer, int i2, MediaCodec.BufferInfo bufferInfo) {
        boolean z;
        AppMethodBeat.i(133893);
        Log.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", info(), Integer.valueOf(this.state), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2));
        if (!e.QA(this.state)) {
            Log.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", info(), Integer.valueOf(this.state));
            AppMethodBeat.o(133893);
            return false;
        }
        if (this.bfn == null) {
            Log.i("MicroMsg.AudioTrackDataSource", "%s init audio track, sampleRate:%s, channels:%s", info(), Integer.valueOf(getSampleRate()), Integer.valueOf(getChannels()));
            int i3 = getChannels() == 1 ? 4 : 12;
            this.bfn = new e(3, getSampleRate(), i3, AudioTrack.getMinBufferSize(getSampleRate(), i3, 2));
            if (this.bfn == null || this.bfn.getState() == 1) {
                setMute(this.guh);
                z = true;
            } else {
                Log.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", info(), Integer.valueOf(this.bfn.getState()));
                this.bfn.release();
                this.bfn = null;
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(133893);
                return false;
            }
        }
        if (e.Qu(this.state) && (this.bfn.getPlayState() == 2 || this.bfn.getPlayState() == 1)) {
            onStart();
        }
        if (e.Qv(this.state) && this.bfn.getPlayState() == 3) {
            onPause();
        }
        try {
            this.zrC.zru = bufferInfo.presentationTimeUs;
            byte[] bArr = new byte[bufferInfo.size];
            byteBuffer.get(bArr);
            byteBuffer.clear();
            long currentTicks = Util.currentTicks();
            if (bArr.length > 0) {
                this.bfn.write(bArr, 0, bArr.length);
            }
            Log.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track, size:%s, cost:%s", info(), Integer.valueOf(i2), Long.valueOf(this.zrC.zru), Integer.valueOf(bufferInfo.size), Long.valueOf(Util.ticksToNow(currentTicks)));
            zVar.releaseOutputBuffer(i2, false);
        } catch (Exception e2) {
            Log.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", info(), e2.toString());
        }
        AppMethodBeat.o(133893);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.n.i
    public final void onStart() {
        AppMethodBeat.i(133894);
        Log.i("MicroMsg.AudioTrackDataSource", "%s on start", info());
        if (this.bfn != null && this.bfn.getState() == 1) {
            this.bfn.play();
        }
        AppMethodBeat.o(133894);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.n.i
    public final void onPause() {
        AppMethodBeat.i(133895);
        Log.i("MicroMsg.AudioTrackDataSource", "%s on pause", info());
        if (this.bfn != null && this.bfn.getState() == 1) {
            this.bfn.pause();
        }
        AppMethodBeat.o(133895);
    }

    @Override // com.tencent.mm.plugin.n.i
    public final void release() {
        AppMethodBeat.i(133896);
        try {
            this.bfn.flush();
            this.bfn.release();
        } catch (Exception e2) {
        }
        super.release();
        AppMethodBeat.o(133896);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(133897);
        if (this.bfn == null) {
            Log.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", info(), Boolean.valueOf(z));
            this.guh = z;
            AppMethodBeat.o(133897);
        } else if (d.oE(21)) {
            Log.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", info(), Boolean.valueOf(z));
            if (z) {
                this.bfn.setStereoVolume(0.0f, 0.0f);
                AppMethodBeat.o(133897);
                return;
            }
            this.bfn.setStereoVolume(1.0f, 1.0f);
            AppMethodBeat.o(133897);
        } else {
            Log.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", info(), Boolean.valueOf(z));
            qZ(z);
            AppMethodBeat.o(133897);
        }
    }

    @TargetApi(21)
    private void qZ(boolean z) {
        AppMethodBeat.i(133898);
        if (z) {
            this.bfn.setVolume(0.0f);
            AppMethodBeat.o(133898);
            return;
        }
        this.bfn.setVolume(1.0f);
        AppMethodBeat.o(133898);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.n.i
    public final boolean a(z zVar) {
        p pVar;
        boolean z;
        AppMethodBeat.i(133899);
        Log.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", info());
        MediaFormat ejl = ejl();
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_video_check_encoder_delay, false) | WeChatEnvironment.hasDebugger();
        if (d.oE(28)) {
            a2 = false;
        }
        if (a2) {
            ejl.setInteger("encoder-delay", 0);
            ejl.setInteger("encoder-padding", 0);
            h hVar = new h();
            long currentTimeMillis = System.currentTimeMillis();
            boolean Sy = hVar.Sy(this.path);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (Sy) {
                m mVar = hVar.jQz;
                Iterator<p> it = hVar.jQA.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        pVar = null;
                        break;
                    }
                    pVar = it.next();
                    if (pVar.jRq != null) {
                        if (pVar.jRq.jQt == ((long) com.tencent.mm.plugin.a.g.jQq)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                long j2 = mVar.jQs;
                if (pVar.jRr != null && pVar.jRr.jQb.size() == 1) {
                    com.tencent.mm.plugin.a.d dVar = pVar.jRr;
                    com.tencent.mm.plugin.a.g gVar = pVar.jRq;
                    long j3 = gVar.duration;
                    long j4 = gVar.jQs;
                    long longValue = dVar.jQb.get(0).longValue();
                    long longValue2 = dVar.jQa.get(0).longValue();
                    long j5 = longValue + ((longValue2 * j4) / j2);
                    int sampleRate2 = getSampleRate();
                    long j6 = j3 - j5;
                    long j7 = (((long) sampleRate2) * longValue) / j4;
                    long j8 = (((long) sampleRate2) * j6) / j4;
                    int i2 = 0;
                    try {
                        i2 = ejl.getInteger("encoder-delay");
                    } catch (Exception e2) {
                    }
                    Log.i("MicroMsg.AudioTrackDataSource", "mediaDuration:%s, editStartTime:%s, editDuration:%s, editEndTime:%s, paddingTimeUnits:%s, encoderDelay:%s, encoderPadding:%s, sampleRate:%s, oriEncoderDelay:%s, trackFormat:%s", Long.valueOf(j3), Long.valueOf(longValue), Long.valueOf(longValue2), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Integer.valueOf(sampleRate2), Integer.valueOf(i2), ejl);
                    if (j7 > 2147483647L || j8 > 2147483647L) {
                        Log.i("MicroMsg.AudioTrackDataSource", "ignore set encoder-delay and encoder-padding and reset to 0");
                    } else {
                        ejl.setInteger("encoder-delay", (int) j7);
                        ejl.setInteger("encoder-padding", (int) j8);
                        Log.i("MicroMsg.AudioTrackDataSource", "set encoder-delay:%s, encoder-padding:%s", Long.valueOf(j7), Long.valueOf(j8));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(FaceManager.FACE_WITH_EYES_CLOSED, 0);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1117, 1, currentTimeMillis2 - currentTimeMillis);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1117, 3, (long) i2);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1117, 4, (long) ((int) j7));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1117, 5, (long) (((int) j7) - i2));
                    }
                }
            }
        }
        zVar.a(ejl, (Surface) null, 0);
        AppMethodBeat.o(133899);
        return false;
    }

    private int getChannels() {
        AppMethodBeat.i(133900);
        if (this.channels == 0) {
            this.channels = this.zrH.getInteger("channel-count");
        }
        int i2 = this.channels;
        AppMethodBeat.o(133900);
        return i2;
    }

    private int getSampleRate() {
        AppMethodBeat.i(133901);
        if (this.sampleRate == 0) {
            this.sampleRate = this.zrH.getInteger("sample-rate");
        }
        int i2 = this.sampleRate;
        AppMethodBeat.o(133901);
        return i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.n.i
    public final void a(z zVar, MediaFormat mediaFormat) {
        AppMethodBeat.i(133902);
        super.a(zVar, mediaFormat);
        Log.i("MicroMsg.AudioTrackDataSource", "%s on output format changed: %s", info(), mediaFormat);
        if (mediaFormat.containsKey("sample-rate")) {
            this.sampleRate = mediaFormat.getInteger("sample-rate");
        }
        AppMethodBeat.o(133902);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.n.i
    public final String type() {
        return SlookAirButtonRecentMediaAdapter.AUDIO_TYPE;
    }
}
