package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.e.d;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b extends com.google.android.exoplayer2.a {
    private static final byte[] bta = x.bK("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private final com.google.android.exoplayer2.drm.b<d> bbV;
    private Format bdF;
    private ByteBuffer[] bfQ;
    private boolean btA;
    private int btB;
    private int btC;
    private boolean btD;
    private boolean btE;
    private boolean btF;
    private boolean btG;
    private boolean btH;
    private boolean btI;
    protected com.google.android.exoplayer2.b.d btJ;
    private final c btb;
    private final boolean btc;
    private final e btd;
    private final e bte;
    private final k btf;
    private final List<Long> btg;
    private final MediaCodec.BufferInfo bth;
    private com.google.android.exoplayer2.drm.a<d> bti;
    private com.google.android.exoplayer2.drm.a<d> btj;
    protected MediaCodec btk;
    protected a btl;
    private int btm;
    private boolean btn;
    private boolean bto;
    private boolean btp;
    private boolean btq;
    private boolean btr;
    private boolean bts;
    private boolean btt;
    private boolean btu;
    private ByteBuffer[] btv;
    private long btw;
    private int btx;
    private int bty;
    private boolean btz;

    /* access modifiers changed from: protected */
    public abstract int a(c cVar, Format format);

    /* access modifiers changed from: protected */
    public abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    /* access modifiers changed from: protected */
    public abstract boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z);

    public static class a extends Exception {
        public final boolean btK;
        public final String btL;
        public final String btM;
        public final String mimeType;

        public a(Format format, Throwable th, boolean z, int i2) {
            super("Decoder init failed: [" + i2 + "], " + format, th);
            AppMethodBeat.i(92357);
            this.mimeType = format.bdq;
            this.btK = z;
            this.btL = null;
            this.btM = "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i2 < 0 ? "neg_" : "") + Math.abs(i2);
            AppMethodBeat.o(92357);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            String str2 = null;
            AppMethodBeat.i(92358);
            this.mimeType = format.bdq;
            this.btK = z;
            this.btL = str;
            if (x.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                str2 = ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            this.btM = str2;
            AppMethodBeat.o(92358);
        }
    }

    public b(int i2, c cVar, com.google.android.exoplayer2.drm.b<d> bVar, boolean z) {
        super(i2);
        com.google.android.exoplayer2.i.a.checkState(x.SDK_INT >= 16);
        this.btb = (c) com.google.android.exoplayer2.i.a.checkNotNull(cVar);
        this.bbV = bVar;
        this.btc = z;
        this.btd = new e(0);
        this.bte = new e(0);
        this.btf = new k();
        this.btg = new ArrayList();
        this.bth = new MediaCodec.BufferInfo();
        this.btB = 0;
        this.btC = 0;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.s
    public final int td() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.s
    public final int b(Format format) {
        boolean us;
        try {
            int a2 = a(this.btb, format);
            if ((a2 & 7) <= 2) {
                return a2;
            }
            com.google.android.exoplayer2.drm.b<d> bVar = this.bbV;
            if (format.bdt == null) {
                us = true;
            } else if (bVar == null) {
                us = false;
            } else {
                us = bVar.us();
            }
            if (!us) {
                return (a2 & -8) | 2;
            }
            return a2;
        } catch (d.b e2) {
            throw com.google.android.exoplayer2.e.b(e2, this.index);
        }
    }

    /* access modifiers changed from: protected */
    public a a(c cVar, Format format, boolean z) {
        return cVar.d(format.bdq, z);
    }

    /* access modifiers changed from: protected */
    public final void va() {
        boolean z;
        MediaCrypto mediaCrypto;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (this.btk == null && this.bdF != null) {
            this.bti = this.btj;
            String str = this.bdF.bdq;
            if (this.bti != null) {
                com.google.android.exoplayer2.drm.d ur = this.bti.ur();
                if (ur == null) {
                    a.C0105a uq = this.bti.uq();
                    if (uq != null) {
                        throw com.google.android.exoplayer2.e.b(uq, this.index);
                    }
                    return;
                }
                MediaCrypto mediaCrypto2 = ur.bhE;
                if (ur.bhF || !ur.bhE.requiresSecureDecoderComponent(str)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                z = z7;
                mediaCrypto = mediaCrypto2;
            } else {
                z = false;
                mediaCrypto = null;
            }
            if (this.btl == null) {
                try {
                    this.btl = a(this.btb, this.bdF, z);
                    if (this.btl == null && z) {
                        this.btl = a(this.btb, this.bdF, false);
                        if (this.btl != null) {
                            new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.btl.name).append(".");
                        }
                    }
                } catch (d.b e2) {
                    a(new a(this.bdF, e2, z, -49998));
                }
                if (this.btl == null) {
                    a(new a(this.bdF, (Throwable) null, z, -49999));
                }
            }
            if (a(this.btl)) {
                String str2 = this.btl.name;
                if (x.SDK_INT <= 24 && "OMX.Exynos.avc.dec.secure".equals(str2) && (x.MODEL.startsWith("SM-T585") || x.MODEL.startsWith("SM-A520"))) {
                    i2 = 2;
                } else if (x.SDK_INT >= 24 || ((!"OMX.Nvidia.h264.decode".equals(str2) && !"OMX.Nvidia.h264.decode.secure".equals(str2)) || (!"flounder".equals(x.DEVICE) && !"flounder_lte".equals(x.DEVICE) && !"grouper".equals(x.DEVICE) && !"tilapia".equals(x.DEVICE)))) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                this.btm = i2;
                Format format = this.bdF;
                if (x.SDK_INT >= 21 || !format.bds.isEmpty() || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str2)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.btn = z2;
                if (x.SDK_INT < 18 || ((x.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (x.SDK_INT == 19 && x.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2))))) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.bto = z3;
                if (x.SDK_INT > 17 || (!"OMX.rk.video_decoder.avc".equals(str2) && !"OMX.allwinner.video.decoder.avc".equals(str2))) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                this.btp = z4;
                if ((x.SDK_INT > 23 || !"OMX.google.vorbis.decoder".equals(str2)) && (x.SDK_INT > 19 || !"hb2000".equals(x.DEVICE) || (!"OMX.amlogic.avc.decoder.awesome".equals(str2) && !"OMX.amlogic.avc.decoder.awesome.secure".equals(str2)))) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                this.btq = z5;
                if (x.SDK_INT != 21 || !"OMX.google.aac.decoder".equals(str2)) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                this.btr = z6;
                Format format2 = this.bdF;
                if (x.SDK_INT <= 18 && format2.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                    z8 = true;
                }
                this.bts = z8;
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    v.beginSection("createCodec:".concat(String.valueOf(str2)));
                    this.btk = MediaCodec.createByCodecName(str2);
                    v.endSection();
                    v.beginSection("configureCodec");
                    a(this.btl, this.btk, this.bdF, mediaCrypto);
                    v.endSection();
                    v.beginSection("startCodec");
                    this.btk.start();
                    v.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    d(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.btv = this.btk.getInputBuffers();
                    this.bfQ = this.btk.getOutputBuffers();
                } catch (Exception e3) {
                    a(new a(this.bdF, e3, z, str2));
                }
                this.btw = this.state == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.btx = -1;
                this.bty = -1;
                this.btI = true;
                this.btJ.bhi++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(a aVar) {
        return true;
    }

    @Override // com.google.android.exoplayer2.a
    public void aN(boolean z) {
        this.btJ = new com.google.android.exoplayer2.b.d();
    }

    @Override // com.google.android.exoplayer2.a
    public void a(long j2, boolean z) {
        this.btF = false;
        this.btG = false;
        if (this.btk != null) {
            this.btw = -9223372036854775807L;
            this.btx = -1;
            this.bty = -1;
            this.btI = true;
            this.btH = false;
            this.btz = false;
            this.btg.clear();
            this.btt = false;
            this.btu = false;
            if (this.bto || (this.btq && this.btE)) {
                vb();
                va();
            } else if (this.btC != 0) {
                vb();
                va();
            } else {
                this.btk.flush();
                this.btD = false;
            }
            if (this.btA && this.bdF != null) {
                this.btB = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void te() {
        this.bdF = null;
        try {
            vb();
        } finally {
            this.bti = null;
            this.btj = null;
        }
    }

    /* access modifiers changed from: protected */
    public void vb() {
        this.btw = -9223372036854775807L;
        this.btx = -1;
        this.bty = -1;
        this.btH = false;
        this.btz = false;
        this.btg.clear();
        this.btv = null;
        this.bfQ = null;
        this.btl = null;
        this.btA = false;
        this.btD = false;
        this.btn = false;
        this.bto = false;
        this.btm = 0;
        this.btp = false;
        this.btq = false;
        this.bts = false;
        this.btt = false;
        this.btu = false;
        this.btE = false;
        this.btB = 0;
        this.btC = 0;
        this.btd.aKP = null;
        if (this.btk != null) {
            this.btJ.bhj++;
            try {
                this.btk.stop();
                try {
                    this.btk.release();
                } finally {
                    this.btk = null;
                    if (!(this.bti == null || this.btj == this.bti)) {
                        this.bti = null;
                    }
                }
            } catch (Throwable th) {
                this.btk = null;
                if (!(this.bti == null || this.btj == this.bti)) {
                    this.bti = null;
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void onStarted() {
    }

    @Override // com.google.android.exoplayer2.a
    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.r
    public final void e(long j2, long j3) {
        if (this.btG) {
            ua();
            return;
        }
        if (this.bdF == null) {
            this.bte.clear();
            int a2 = a(this.btf, this.bte, true);
            if (a2 == -5) {
                e(this.btf.bdF);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.i.a.checkState(this.bte.ud());
                this.btF = true;
                ve();
                return;
            } else {
                return;
            }
        }
        va();
        if (this.btk != null) {
            v.beginSection("drainAndFeed");
            do {
            } while (g(j2, j3));
            do {
            } while (vc());
            v.endSection();
            return;
        }
        this.bbF.Y(j2 - this.bbG);
        this.bte.clear();
        int a3 = a(this.btf, this.bte, false);
        if (a3 == -5) {
            e(this.btf.bdF);
        } else if (a3 == -4) {
            com.google.android.exoplayer2.i.a.checkState(this.bte.ud());
            this.btF = true;
            ve();
        }
    }

    private boolean vc() {
        int a2;
        int i2;
        boolean z;
        if (this.btk == null || this.btC == 2 || this.btF) {
            return false;
        }
        if (this.btx < 0) {
            this.btx = this.btk.dequeueInputBuffer(0);
            if (this.btx < 0) {
                return false;
            }
            this.btd.aKP = this.btv[this.btx];
            this.btd.clear();
        }
        if (this.btC == 1) {
            if (!this.btp) {
                this.btE = true;
                this.btk.queueInputBuffer(this.btx, 0, 0, 0, 4);
                this.btx = -1;
            }
            this.btC = 2;
            return false;
        } else if (this.btt) {
            this.btt = false;
            this.btd.aKP.put(bta);
            this.btk.queueInputBuffer(this.btx, 0, bta.length, 0, 0);
            this.btx = -1;
            this.btD = true;
            return true;
        } else {
            if (this.btH) {
                i2 = 0;
                a2 = -4;
            } else {
                if (this.btB == 1) {
                    for (int i3 = 0; i3 < this.bdF.bds.size(); i3++) {
                        this.btd.aKP.put(this.bdF.bds.get(i3));
                    }
                    this.btB = 2;
                }
                int position = this.btd.aKP.position();
                a2 = a(this.btf, this.btd, false);
                i2 = position;
            }
            if (a2 == -3) {
                return false;
            }
            if (a2 == -5) {
                if (this.btB == 2) {
                    this.btd.clear();
                    this.btB = 1;
                }
                e(this.btf.bdF);
                return true;
            } else if (this.btd.ud()) {
                if (this.btB == 2) {
                    this.btd.clear();
                    this.btB = 1;
                }
                this.btF = true;
                if (!this.btD) {
                    ve();
                    return false;
                }
                try {
                    if (this.btp) {
                        return false;
                    }
                    this.btE = true;
                    this.btk.queueInputBuffer(this.btx, 0, 0, 0, 4);
                    this.btx = -1;
                    return false;
                } catch (MediaCodec.CryptoException e2) {
                    throw com.google.android.exoplayer2.e.b(e2, this.index);
                }
            } else if (!this.btI || this.btd.ue()) {
                this.btI = false;
                boolean uh = this.btd.uh();
                if (this.bti == null || (!uh && this.btc)) {
                    z = false;
                } else {
                    int state = this.bti.getState();
                    if (state == 1) {
                        throw com.google.android.exoplayer2.e.b(this.bti.uq(), this.index);
                    }
                    z = state != 4;
                }
                this.btH = z;
                if (this.btH) {
                    return false;
                }
                if (this.btn && !uh) {
                    com.google.android.exoplayer2.i.k.h(this.btd.aKP);
                    if (this.btd.aKP.position() == 0) {
                        return true;
                    }
                    this.btn = false;
                }
                try {
                    long j2 = this.btd.timeUs;
                    if (this.btd.uc()) {
                        this.btg.add(Long.valueOf(j2));
                    }
                    this.btd.ui();
                    vd();
                    if (uh) {
                        MediaCodec.CryptoInfo cryptoInfo = this.btd.bhp.bhf;
                        if (i2 != 0) {
                            if (cryptoInfo.numBytesOfClearData == null) {
                                cryptoInfo.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = cryptoInfo.numBytesOfClearData;
                            iArr[0] = i2 + iArr[0];
                        }
                        this.btk.queueSecureInputBuffer(this.btx, 0, cryptoInfo, j2, 0);
                    } else {
                        this.btk.queueInputBuffer(this.btx, 0, this.btd.aKP.limit(), j2, 0);
                    }
                    this.btx = -1;
                    this.btD = true;
                    this.btB = 0;
                    this.btJ.bhk++;
                    return true;
                } catch (MediaCodec.CryptoException e3) {
                    throw com.google.android.exoplayer2.e.b(e3, this.index);
                }
            } else {
                this.btd.clear();
                if (this.btB == 2) {
                    this.btB = 1;
                }
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d(String str, long j2, long j3) {
    }

    /* access modifiers changed from: protected */
    public void e(Format format) {
        boolean z;
        Format format2 = this.bdF;
        this.bdF = format;
        if (!x.j(this.bdF.bdt, format2 == null ? null : format2.bdt)) {
            if (this.bdF.bdt == null) {
                this.btj = null;
            } else if (this.bbV == null) {
                throw com.google.android.exoplayer2.e.b(new IllegalStateException("Media requires a DrmSessionManager"), this.index);
            } else {
                com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> bVar = this.bbV;
                Looper.myLooper();
                this.btj = bVar.ut();
                if (this.btj == this.bti) {
                }
            }
        }
        if (this.btj == this.bti && this.btk != null && a(this.btl.bsX, format2, this.bdF)) {
            this.btA = true;
            this.btB = 1;
            if (this.btm == 2 || (this.btm == 1 && this.bdF.width == format2.width && this.bdF.height == format2.height)) {
                z = true;
            } else {
                z = false;
            }
            this.btt = z;
        } else if (this.btD) {
            this.btC = 1;
        } else {
            vb();
            va();
        }
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    /* access modifiers changed from: protected */
    public void vd() {
    }

    /* access modifiers changed from: protected */
    public boolean a(boolean z, Format format, Format format2) {
        return false;
    }

    @Override // com.google.android.exoplayer2.r
    public boolean tB() {
        return this.btG;
    }

    @Override // com.google.android.exoplayer2.r
    public boolean isReady() {
        boolean isReady;
        if (this.bdF != null && !this.btH) {
            if (this.bbH) {
                isReady = this.bbI;
            } else {
                isReady = this.bbF.isReady();
            }
            if (isReady || this.bty >= 0 || (this.btw != -9223372036854775807L && SystemClock.elapsedRealtime() < this.btw)) {
                return true;
            }
        }
        return false;
    }

    private boolean g(long j2, long j3) {
        boolean a2;
        boolean z;
        if (this.bty < 0) {
            if (!this.btr || !this.btE) {
                this.bty = this.btk.dequeueOutputBuffer(this.bth, 0);
            } else {
                try {
                    this.bty = this.btk.dequeueOutputBuffer(this.bth, 0);
                } catch (IllegalStateException e2) {
                    ve();
                    if (this.btG) {
                        vb();
                    }
                    return false;
                }
            }
            if (this.bty >= 0) {
                if (this.btu) {
                    this.btu = false;
                    this.btk.releaseOutputBuffer(this.bty, false);
                    this.bty = -1;
                    return true;
                } else if ((this.bth.flags & 4) != 0) {
                    ve();
                    this.bty = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.bfQ[this.bty];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.bth.offset);
                        byteBuffer.limit(this.bth.offset + this.bth.size);
                    }
                    long j4 = this.bth.presentationTimeUs;
                    int size = this.btg.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z = false;
                            break;
                        } else if (this.btg.get(i2).longValue() == j4) {
                            this.btg.remove(i2);
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    this.btz = z;
                }
            } else if (this.bty == -2) {
                MediaFormat outputFormat = this.btk.getOutputFormat();
                if (this.btm != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.btu = true;
                } else {
                    if (this.bts) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.btk, outputFormat);
                }
                return true;
            } else if (this.bty == -3) {
                this.bfQ = this.btk.getOutputBuffers();
                return true;
            } else {
                if (this.btp && (this.btF || this.btC == 2)) {
                    ve();
                }
                return false;
            }
        }
        if (!this.btr || !this.btE) {
            a2 = a(j2, j3, this.btk, this.bfQ[this.bty], this.bty, this.bth.flags, this.bth.presentationTimeUs, this.btz);
        } else {
            try {
                a2 = a(j2, j3, this.btk, this.bfQ[this.bty], this.bty, this.bth.flags, this.bth.presentationTimeUs, this.btz);
            } catch (IllegalStateException e3) {
                ve();
                if (this.btG) {
                    vb();
                }
                return false;
            }
        }
        if (!a2) {
            return false;
        }
        long j5 = this.bth.presentationTimeUs;
        this.bty = -1;
        return true;
    }

    /* access modifiers changed from: protected */
    public void ua() {
    }

    private void ve() {
        if (this.btC == 2) {
            vb();
            va();
            return;
        }
        this.btG = true;
        ua();
    }

    private void a(a aVar) {
        throw com.google.android.exoplayer2.e.b(aVar, this.index);
    }
}
