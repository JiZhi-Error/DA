package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.video.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.thumbplayer.core.common.TPDecoderType;

@TargetApi(16)
public final class c extends com.google.android.exoplayer2.e.b {
    private static final int[] bHY = {1920, 1600, 1440, TAVExporter.VIDEO_EXPORT_HEIGHT, 960, JsApiOperateRecentUsageList.CTRL_INDEX, 640, TAVPlayer.VIDEO_PLAYER_WIDTH, 480};
    private final d bHZ;
    private long bIA;
    private int bIB;
    private final e.a bIa;
    private final long bIb;
    private final int bIc;
    private final boolean bId;
    private final long[] bIe;
    private Format[] bIf;
    private a bIg;
    private boolean bIh;
    private Surface bIi;
    private int bIj;
    private boolean bIk;
    private long bIl;
    private long bIm;
    private int bIn;
    private int bIo;
    private int bIp;
    private float bIq;
    private int bIr;
    private int bIs;
    private int bIt;
    private float bIu;
    private int bIv;
    private int bIw;
    private int bIx;
    private float bIy;
    b bIz;
    private int bdQ;
    private boolean bfX;
    private final Context context;
    private Surface surface;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context2, com.google.android.exoplayer2.e.c cVar, long j2, com.google.android.exoplayer2.drm.b<d> bVar, Handler handler, e eVar, int i2) {
        super(2, cVar, bVar, false);
        boolean z = false;
        AppMethodBeat.i(93269);
        this.bIb = j2;
        this.bIc = i2;
        this.context = context2.getApplicationContext();
        this.bHZ = new d(context2);
        this.bIa = new e.a(handler, eVar);
        if (x.SDK_INT <= 22 && "foster".equals(x.DEVICE) && "NVIDIA".equals(x.MANUFACTURER)) {
            z = true;
        }
        this.bId = z;
        this.bIe = new long[10];
        this.bIA = -9223372036854775807L;
        this.bIl = -9223372036854775807L;
        this.bIr = -1;
        this.bIs = -1;
        this.bIu = -1.0f;
        this.bIq = -1.0f;
        this.bIj = 1;
        xx();
        AppMethodBeat.o(93269);
    }

    @Override // com.google.android.exoplayer2.e.b
    public final int a(com.google.android.exoplayer2.e.c cVar, Format format) {
        boolean z;
        boolean z2;
        int i2 = 0;
        AppMethodBeat.i(93270);
        String str = format.bdq;
        if (!j.by(str)) {
            AppMethodBeat.o(93270);
            return 0;
        }
        DrmInitData drmInitData = format.bdt;
        if (drmInitData != null) {
            z = false;
            for (int i3 = 0; i3 < drmInitData.bhC; i3++) {
                z |= drmInitData.bhB[i3].bhD;
            }
        } else {
            z = false;
        }
        com.google.android.exoplayer2.e.a d2 = cVar.d(str, z);
        if (d2 == null) {
            AppMethodBeat.o(93270);
            return 1;
        }
        String str2 = format.bdn;
        if (str2 == null || d2.mimeType == null) {
            z2 = true;
        } else {
            String bA = j.bA(str2);
            if (bA == null) {
                z2 = true;
            } else if (d2.mimeType.equals(bA)) {
                Pair<Integer, Integer> bi = com.google.android.exoplayer2.e.d.bi(str2);
                if (bi != null) {
                    MediaCodecInfo.CodecProfileLevel[] uZ = d2.uZ();
                    int length = uZ.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            d2.bh("codec.profileLevel, " + str2 + ", " + bA);
                            z2 = false;
                            break;
                        }
                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = uZ[i4];
                        if (codecProfileLevel.profile == ((Integer) bi.first).intValue() && codecProfileLevel.level >= ((Integer) bi.second).intValue()) {
                            z2 = true;
                            break;
                        }
                        i4++;
                    }
                } else {
                    z2 = true;
                }
            } else {
                d2.bh("codec.mime " + str2 + ", " + bA);
                z2 = false;
            }
        }
        if (z2 && format.width > 0 && format.height > 0) {
            if (x.SDK_INT >= 21) {
                z2 = d2.a(format.width, format.height, (double) format.bdu);
            } else {
                z2 = format.width * format.height <= com.google.android.exoplayer2.e.d.vg();
                if (!z2) {
                    new StringBuilder("FalseCheck [legacyFrameSize, ").append(format.width).append("x").append(format.height).append("] [").append(x.bHH).append("]");
                }
            }
        }
        int i5 = d2.bsX ? 16 : 8;
        if (d2.bfX) {
            i2 = 32;
        }
        int i6 = i2 | i5 | (z2 ? 4 : 3);
        AppMethodBeat.o(93270);
        return i6;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
    public final void aN(boolean z) {
        boolean z2;
        AppMethodBeat.i(93271);
        super.aN(z);
        this.bdQ = this.bbE.bdQ;
        if (this.bdQ != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.bfX = z2;
        e.a aVar = this.bIa;
        com.google.android.exoplayer2.b.d dVar = this.btJ;
        if (aVar.bIT != null) {
            aVar.handler.post(new Runnable(dVar) {
                /* class com.google.android.exoplayer2.video.e.a.AnonymousClass1 */
                final /* synthetic */ com.google.android.exoplayer2.b.d beQ;

                {
                    this.beQ = r2;
                }

                public final void run() {
                    AppMethodBeat.i(93309);
                    a.this.bIT.a(this.beQ);
                    AppMethodBeat.o(93309);
                }
            });
        }
        d dVar2 = this.bHZ;
        dVar2.bIL = false;
        if (dVar2.bIF) {
            dVar2.bIE.handler.sendEmptyMessage(1);
        }
        AppMethodBeat.o(93271);
    }

    @Override // com.google.android.exoplayer2.a
    public final void a(Format[] formatArr, long j2) {
        AppMethodBeat.i(93272);
        this.bIf = formatArr;
        if (this.bIA == -9223372036854775807L) {
            this.bIA = j2;
        } else {
            if (this.bIB == this.bIe.length) {
                new StringBuilder("Too many stream changes, so dropping offset: ").append(this.bIe[this.bIB - 1]);
            } else {
                this.bIB++;
            }
            this.bIe[this.bIB - 1] = j2;
        }
        super.a(formatArr, j2);
        AppMethodBeat.o(93272);
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
    public final void a(long j2, boolean z) {
        AppMethodBeat.i(93273);
        super.a(j2, z);
        xv();
        this.bIo = 0;
        if (this.bIB != 0) {
            this.bIA = this.bIe[this.bIB - 1];
            this.bIB = 0;
        }
        if (z) {
            xu();
            AppMethodBeat.o(93273);
            return;
        }
        this.bIl = -9223372036854775807L;
        AppMethodBeat.o(93273);
    }

    @Override // com.google.android.exoplayer2.e.b, com.google.android.exoplayer2.r
    public final boolean isReady() {
        AppMethodBeat.i(93274);
        if (super.isReady() && (this.bIk || ((this.bIi != null && this.surface == this.bIi) || this.btk == null || this.bfX))) {
            this.bIl = -9223372036854775807L;
            AppMethodBeat.o(93274);
            return true;
        } else if (this.bIl == -9223372036854775807L) {
            AppMethodBeat.o(93274);
            return false;
        } else if (SystemClock.elapsedRealtime() < this.bIl) {
            AppMethodBeat.o(93274);
            return true;
        } else {
            this.bIl = -9223372036854775807L;
            AppMethodBeat.o(93274);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
    public final void onStarted() {
        AppMethodBeat.i(93275);
        super.onStarted();
        this.bIn = 0;
        this.bIm = SystemClock.elapsedRealtime();
        AppMethodBeat.o(93275);
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
    public final void onStopped() {
        AppMethodBeat.i(93276);
        this.bIl = -9223372036854775807L;
        xA();
        super.onStopped();
        AppMethodBeat.o(93276);
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
    public final void te() {
        AppMethodBeat.i(93277);
        this.bIr = -1;
        this.bIs = -1;
        this.bIu = -1.0f;
        this.bIq = -1.0f;
        this.bIA = -9223372036854775807L;
        this.bIB = 0;
        xx();
        xv();
        d dVar = this.bHZ;
        if (dVar.bIF) {
            dVar.bIE.handler.sendEmptyMessage(2);
        }
        this.bIz = null;
        this.bfX = false;
        try {
            super.te();
        } finally {
            this.bIa.e(this.btJ);
            AppMethodBeat.o(93277);
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.f.b
    public final void c(int i2, Object obj) {
        AppMethodBeat.i(93278);
        if (i2 == 1) {
            Surface surface2 = (Surface) obj;
            if (surface2 == null) {
                if (this.bIi != null) {
                    surface2 = this.bIi;
                } else {
                    com.google.android.exoplayer2.e.a aVar = this.btl;
                    if (aVar != null && aY(aVar.bsY)) {
                        this.bIi = DummySurface.j(this.context, aVar.bsY);
                        surface2 = this.bIi;
                    }
                }
            }
            if (this.surface != surface2) {
                this.surface = surface2;
                int i3 = this.state;
                if (i3 == 1 || i3 == 2) {
                    MediaCodec mediaCodec = this.btk;
                    if (x.SDK_INT < 23 || mediaCodec == null || surface2 == null || this.bIh) {
                        vb();
                        va();
                    } else {
                        mediaCodec.setOutputSurface(surface2);
                    }
                }
                if (surface2 == null || surface2 == this.bIi) {
                    xx();
                    xv();
                } else {
                    xz();
                    xv();
                    if (i3 == 2) {
                        xu();
                        AppMethodBeat.o(93278);
                        return;
                    }
                }
                AppMethodBeat.o(93278);
                return;
            }
            if (!(surface2 == null || surface2 == this.bIi)) {
                xz();
                if (this.bIk) {
                    this.bIa.d(this.surface);
                }
            }
            AppMethodBeat.o(93278);
        } else if (i2 == 4) {
            this.bIj = ((Integer) obj).intValue();
            MediaCodec mediaCodec2 = this.btk;
            if (mediaCodec2 != null) {
                mediaCodec2.setVideoScalingMode(this.bIj);
            }
            AppMethodBeat.o(93278);
        } else {
            super.c(i2, obj);
            AppMethodBeat.o(93278);
        }
    }

    @Override // com.google.android.exoplayer2.e.b
    public final boolean a(com.google.android.exoplayer2.e.a aVar) {
        AppMethodBeat.i(93279);
        if (this.surface != null || aY(aVar.bsY)) {
            AppMethodBeat.o(93279);
            return true;
        }
        AppMethodBeat.o(93279);
        return false;
    }

    @Override // com.google.android.exoplayer2.e.b
    public final void a(com.google.android.exoplayer2.e.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        a aVar2;
        boolean z;
        AppMethodBeat.i(93280);
        Format[] formatArr = this.bIf;
        int i2 = format.width;
        int i3 = format.height;
        int l = l(format);
        if (formatArr.length == 1) {
            aVar2 = new a(i2, i3, l);
        } else {
            boolean z2 = false;
            int length = formatArr.length;
            int i4 = 0;
            while (i4 < length) {
                Format format2 = formatArr[i4];
                if (b(aVar.bsX, format, format2)) {
                    z = (format2.width == -1 || format2.height == -1) | z2;
                    i2 = Math.max(i2, format2.width);
                    i3 = Math.max(i3, format2.height);
                    l = Math.max(l, l(format2));
                } else {
                    z = z2;
                }
                i4++;
                z2 = z;
            }
            if (z2) {
                new StringBuilder("Resolutions unknown. Codec max resolution: ").append(i2).append("x").append(i3);
                Point a2 = a(aVar, format);
                if (a2 != null) {
                    i2 = Math.max(i2, a2.x);
                    i3 = Math.max(i3, a2.y);
                    l = Math.max(l, g(format.bdq, i2, i3));
                    new StringBuilder("Codec max resolution adjusted to: ").append(i2).append("x").append(i3);
                }
            }
            aVar2 = new a(i2, i3, l);
        }
        this.bIg = aVar2;
        a aVar3 = this.bIg;
        boolean z3 = this.bId;
        int i5 = this.bdQ;
        MediaFormat tw = format.tw();
        tw.setInteger("max-width", aVar3.width);
        tw.setInteger("max-height", aVar3.height);
        if (aVar3.bIC != -1) {
            tw.setInteger("max-input-size", aVar3.bIC);
        }
        if (z3) {
            tw.setInteger("auto-frc", 0);
        }
        if (i5 != 0) {
            tw.setFeatureEnabled("tunneled-playback", true);
            tw.setInteger("audio-session-id", i5);
        }
        if (this.surface == null) {
            com.google.android.exoplayer2.i.a.checkState(aY(aVar.bsY));
            if (this.bIi == null) {
                this.bIi = DummySurface.j(this.context, aVar.bsY);
            }
            this.surface = this.bIi;
        }
        mediaCodec.configure(tw, this.surface, mediaCrypto, 0);
        if (x.SDK_INT >= 23 && this.bfX) {
            this.bIz = new b(this, mediaCodec, (byte) 0);
        }
        AppMethodBeat.o(93280);
    }

    @Override // com.google.android.exoplayer2.e.b
    public final void vb() {
        AppMethodBeat.i(93281);
        try {
            super.vb();
            if (this.bIi != null) {
                if (this.surface == this.bIi) {
                    this.surface = null;
                }
                this.bIi.release();
                this.bIi = null;
                AppMethodBeat.o(93281);
                return;
            }
            AppMethodBeat.o(93281);
        } catch (Throwable th) {
            if (this.bIi != null) {
                if (this.surface == this.bIi) {
                    this.surface = null;
                }
                this.bIi.release();
                this.bIi = null;
            }
            AppMethodBeat.o(93281);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.e.b
    public final void d(String str, long j2, long j3) {
        boolean z;
        AppMethodBeat.i(93282);
        e.a aVar = this.bIa;
        if (aVar.bIT != null) {
            aVar.handler.post(new Runnable(str, j2, j3) {
                /* class com.google.android.exoplayer2.video.e.a.AnonymousClass2 */
                final /* synthetic */ String beS;
                final /* synthetic */ long beT;
                final /* synthetic */ long beU;

                {
                    this.beS = r3;
                    this.beT = r4;
                    this.beU = r6;
                }

                public final void run() {
                    AppMethodBeat.i(93310);
                    a.this.bIT.b(this.beS, this.beT, this.beU);
                    AppMethodBeat.o(93310);
                }
            });
        }
        if ((("deb".equals(x.DEVICE) || "flo".equals(x.DEVICE)) && "OMX.qcom.video.decoder.avc".equals(str)) || ("tcl_eu".equals(x.DEVICE) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
            z = true;
        } else {
            z = false;
        }
        this.bIh = z;
        AppMethodBeat.o(93282);
    }

    @Override // com.google.android.exoplayer2.e.b
    public final void e(Format format) {
        float f2;
        AppMethodBeat.i(93283);
        super.e(format);
        e.a aVar = this.bIa;
        if (aVar.bIT != null) {
            aVar.handler.post(new Runnable(format) {
                /* class com.google.android.exoplayer2.video.e.a.AnonymousClass3 */
                final /* synthetic */ Format beV;

                {
                    this.beV = r2;
                }

                public final void run() {
                    AppMethodBeat.i(93311);
                    a.this.bIT.c(this.beV);
                    AppMethodBeat.o(93311);
                }
            });
        }
        if (format.bdw == -1.0f) {
            f2 = 1.0f;
        } else {
            f2 = format.bdw;
        }
        this.bIq = f2;
        this.bIp = m(format);
        AppMethodBeat.o(93283);
    }

    @Override // com.google.android.exoplayer2.e.b
    public final void vd() {
        AppMethodBeat.i(93284);
        if (x.SDK_INT < 23 && this.bfX) {
            xw();
        }
        AppMethodBeat.o(93284);
    }

    @Override // com.google.android.exoplayer2.e.b
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        AppMethodBeat.i(93285);
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.bIr = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.bIs = integer2;
        this.bIu = this.bIq;
        if (x.SDK_INT < 21) {
            this.bIt = this.bIp;
        } else if (this.bIp == 90 || this.bIp == 270) {
            int i2 = this.bIr;
            this.bIr = this.bIs;
            this.bIs = i2;
            this.bIu = 1.0f / this.bIu;
        }
        mediaCodec.setVideoScalingMode(this.bIj);
        AppMethodBeat.o(93285);
    }

    @Override // com.google.android.exoplayer2.e.b
    public final boolean a(boolean z, Format format, Format format2) {
        AppMethodBeat.i(93286);
        if (!b(z, format, format2) || format2.width > this.bIg.width || format2.height > this.bIg.height || l(format2) > this.bIg.bIC) {
            AppMethodBeat.o(93286);
            return false;
        }
        AppMethodBeat.o(93286);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c7  */
    @Override // com.google.android.exoplayer2.e.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long r20, long r22, android.media.MediaCodec r24, java.nio.ByteBuffer r25, int r26, int r27, long r28, boolean r30) {
        /*
        // Method dump skipped, instructions count: 544
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.c.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    private void a(MediaCodec mediaCodec, int i2) {
        AppMethodBeat.i(93288);
        v.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        v.endSection();
        this.btJ.bhm++;
        AppMethodBeat.o(93288);
    }

    private void b(MediaCodec mediaCodec, int i2) {
        AppMethodBeat.i(93289);
        xy();
        v.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        v.endSection();
        this.btJ.bhl++;
        this.bIo = 0;
        xw();
        AppMethodBeat.o(93289);
    }

    @TargetApi(21)
    private void a(MediaCodec mediaCodec, int i2, long j2) {
        AppMethodBeat.i(93290);
        xy();
        v.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j2);
        v.endSection();
        this.btJ.bhl++;
        this.bIo = 0;
        xw();
        AppMethodBeat.o(93290);
    }

    private boolean aY(boolean z) {
        AppMethodBeat.i(93291);
        if (x.SDK_INT < 23 || this.bfX || (z && !DummySurface.ak(this.context))) {
            AppMethodBeat.o(93291);
            return false;
        }
        AppMethodBeat.o(93291);
        return true;
    }

    private void xu() {
        AppMethodBeat.i(93292);
        this.bIl = this.bIb > 0 ? SystemClock.elapsedRealtime() + this.bIb : -9223372036854775807L;
        AppMethodBeat.o(93292);
    }

    private void xv() {
        MediaCodec mediaCodec;
        AppMethodBeat.i(93293);
        this.bIk = false;
        if (x.SDK_INT >= 23 && this.bfX && (mediaCodec = this.btk) != null) {
            this.bIz = new b(this, mediaCodec, (byte) 0);
        }
        AppMethodBeat.o(93293);
    }

    /* access modifiers changed from: package-private */
    public final void xw() {
        AppMethodBeat.i(93294);
        if (!this.bIk) {
            this.bIk = true;
            this.bIa.d(this.surface);
        }
        AppMethodBeat.o(93294);
    }

    private void xx() {
        this.bIv = -1;
        this.bIw = -1;
        this.bIy = -1.0f;
        this.bIx = -1;
    }

    private void xy() {
        AppMethodBeat.i(93295);
        if (!((this.bIr == -1 && this.bIs == -1) || (this.bIv == this.bIr && this.bIw == this.bIs && this.bIx == this.bIt && this.bIy == this.bIu))) {
            this.bIa.b(this.bIr, this.bIs, this.bIt, this.bIu);
            this.bIv = this.bIr;
            this.bIw = this.bIs;
            this.bIx = this.bIt;
            this.bIy = this.bIu;
        }
        AppMethodBeat.o(93295);
    }

    private void xz() {
        AppMethodBeat.i(93296);
        if (!(this.bIv == -1 && this.bIw == -1)) {
            this.bIa.b(this.bIv, this.bIw, this.bIx, this.bIy);
        }
        AppMethodBeat.o(93296);
    }

    private void xA() {
        AppMethodBeat.i(93297);
        if (this.bIn > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.bIa.m(this.bIn, elapsedRealtime - this.bIm);
            this.bIn = 0;
            this.bIm = elapsedRealtime;
        }
        AppMethodBeat.o(93297);
    }

    private static boolean as(long j2) {
        return j2 < -30000;
    }

    private static Point a(com.google.android.exoplayer2.e.a aVar, Format format) {
        int i2;
        Point point;
        AppMethodBeat.i(93298);
        boolean z = format.height > format.width;
        int i3 = z ? format.height : format.width;
        int i4 = z ? format.width : format.height;
        float f2 = ((float) i4) / ((float) i3);
        int[] iArr = bHY;
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            int i7 = (int) (((float) i6) * f2);
            if (i6 <= i3 || i7 <= i4) {
                AppMethodBeat.o(93298);
                return null;
            }
            if (x.SDK_INT >= 21) {
                if (z) {
                    i2 = i7;
                } else {
                    i2 = i6;
                }
                if (!z) {
                    i6 = i7;
                }
                if (aVar.bsZ == null) {
                    aVar.bh("align.caps");
                    point = null;
                } else {
                    MediaCodecInfo.VideoCapabilities videoCapabilities = aVar.bsZ.getVideoCapabilities();
                    if (videoCapabilities == null) {
                        aVar.bh("align.vCaps");
                        point = null;
                    } else {
                        int widthAlignment = videoCapabilities.getWidthAlignment();
                        int heightAlignment = videoCapabilities.getHeightAlignment();
                        point = new Point(x.bi(i2, widthAlignment) * widthAlignment, x.bi(i6, heightAlignment) * heightAlignment);
                    }
                }
                if (aVar.a(point.x, point.y, (double) format.bdu)) {
                    AppMethodBeat.o(93298);
                    return point;
                }
            } else {
                int bi = x.bi(i6, 16) * 16;
                int bi2 = x.bi(i7, 16) * 16;
                if (bi * bi2 <= com.google.android.exoplayer2.e.d.vg()) {
                    Point point2 = new Point(z ? bi2 : bi, z ? bi : bi2);
                    AppMethodBeat.o(93298);
                    return point2;
                }
            }
        }
        AppMethodBeat.o(93298);
        return null;
    }

    private static int l(Format format) {
        AppMethodBeat.i(93299);
        if (format.bdr != -1) {
            int size = format.bds.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i2 += format.bds.get(i3).length;
            }
            int i4 = format.bdr + i2;
            AppMethodBeat.o(93299);
            return i4;
        }
        int g2 = g(format.bdq, format.width, format.height);
        AppMethodBeat.o(93299);
        return g2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int g(String str, int i2, int i3) {
        char c2;
        int i4;
        int i5 = 2;
        AppMethodBeat.i(93300);
        if (i2 == -1 || i3 == -1) {
            AppMethodBeat.o(93300);
            return -1;
        }
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals(TPDecoderType.TP_CODEC_MIMETYPE_VP9)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                i4 = i2 * i3;
                break;
            case 2:
                if (!"BRAVIA 4K 2015".equals(x.MODEL)) {
                    i4 = x.bi(i2, 16) * x.bi(i3, 16) * 16 * 16;
                    break;
                } else {
                    AppMethodBeat.o(93300);
                    return -1;
                }
            case 3:
                i4 = i2 * i3;
                break;
            case 4:
            case 5:
                i4 = i2 * i3;
                i5 = 4;
                break;
            default:
                AppMethodBeat.o(93300);
                return -1;
        }
        int i6 = (i4 * 3) / (i5 * 2);
        AppMethodBeat.o(93300);
        return i6;
    }

    private static boolean b(boolean z, Format format, Format format2) {
        AppMethodBeat.i(93301);
        if (!format.bdq.equals(format2.bdq) || m(format) != m(format2) || (!z && !(format.width == format2.width && format.height == format2.height))) {
            AppMethodBeat.o(93301);
            return false;
        }
        AppMethodBeat.o(93301);
        return true;
    }

    private static int m(Format format) {
        if (format.bdv == -1) {
            return 0;
        }
        return format.bdv;
    }

    protected static final class a {
        public final int bIC;
        public final int height;
        public final int width;

        public a(int i2, int i3, int i4) {
            this.width = i2;
            this.height = i3;
            this.bIC = i4;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(23)
    public final class b implements MediaCodec.OnFrameRenderedListener {
        /* synthetic */ b(c cVar, MediaCodec mediaCodec, byte b2) {
            this(mediaCodec);
        }

        private b(MediaCodec mediaCodec) {
            AppMethodBeat.i(93267);
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
            AppMethodBeat.o(93267);
        }

        public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
            AppMethodBeat.i(93268);
            if (this != c.this.bIz) {
                AppMethodBeat.o(93268);
                return;
            }
            c.this.xw();
            AppMethodBeat.o(93268);
        }
    }
}
