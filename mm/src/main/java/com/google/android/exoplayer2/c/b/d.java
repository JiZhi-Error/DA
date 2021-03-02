package com.google.android.exoplayer2.c.b;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class d implements e {
    private static final byte[] biM = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] biN = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static long biO = 1000;
    static final byte[] biP = x.bG("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] biQ = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static long biR = 10000;
    private static final byte[] biS = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID biT = new UUID(72057594037932032L, -9223371306706625679L);
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.b.d.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(92003);
            e[] eVarArr = {new d()};
            AppMethodBeat.o(92003);
            return eVarArr;
        }
    };
    long bdJ;
    private final m biB;
    private final m biC;
    final f biG;
    private final b biU;
    final SparseArray<b> biV;
    final boolean biW;
    private final m biX;
    final m biY;
    private final m biZ;
    final m bin;
    g bir;
    int bjA;
    int bjB;
    private int bjC;
    private boolean bjD;
    private boolean bjE;
    private boolean bjF;
    private boolean bjG;
    private byte bjH;
    private int bjI;
    private int bjJ;
    private int bjK;
    private boolean bjL;
    boolean bjM;
    private final m bja;
    private final m bjb;
    private final m bjc;
    private ByteBuffer bjd;
    long bje;
    long bjf;
    long bjg;
    long bjh;
    b bji;
    boolean bjj;
    int bjk;
    long bjl;
    boolean bjm;
    long bjn;
    private long bjo;
    long bjp;
    com.google.android.exoplayer2.i.h bjq;
    com.google.android.exoplayer2.i.h bjr;
    boolean bjs;
    int bjt;
    long bju;
    long bjv;
    int bjw;
    int bjx;
    int[] bjy;
    int bjz;

    static {
        AppMethodBeat.i(92029);
        AppMethodBeat.o(92029);
    }

    public d() {
        this(0);
    }

    public d(int i2) {
        this(new a(), i2);
        AppMethodBeat.i(92014);
        AppMethodBeat.o(92014);
    }

    private d(b bVar, int i2) {
        boolean z = false;
        AppMethodBeat.i(92015);
        this.bjf = -1;
        this.bjg = -9223372036854775807L;
        this.bjh = -9223372036854775807L;
        this.bdJ = -9223372036854775807L;
        this.bjn = -1;
        this.bjo = -1;
        this.bjp = -9223372036854775807L;
        this.biU = bVar;
        this.biU.a(new a(this, (byte) 0));
        this.biW = (i2 & 1) == 0 ? true : z;
        this.biG = new f();
        this.biV = new SparseArray<>();
        this.bin = new m(4);
        this.biX = new m(ByteBuffer.allocate(4).putInt(-1).array());
        this.biY = new m(4);
        this.biB = new m(k.bGT);
        this.biC = new m(4);
        this.biZ = new m();
        this.bja = new m();
        this.bjb = new m(8);
        this.bjc = new m();
        AppMethodBeat.o(92015);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 143
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(com.google.android.exoplayer2.c.f r11) {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.b.d.a(com.google.android.exoplayer2.c.f):boolean");
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        this.bir = gVar;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        AppMethodBeat.i(92017);
        this.bjp = -9223372036854775807L;
        this.bjt = 0;
        this.biU.reset();
        this.biG.reset();
        uA();
        AppMethodBeat.o(92017);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final int a(f fVar, com.google.android.exoplayer2.c.k kVar) {
        boolean z;
        AppMethodBeat.i(92018);
        this.bjL = false;
        boolean z2 = true;
        while (z2 && !this.bjL) {
            boolean c2 = this.biU.c(fVar);
            if (c2) {
                long position = fVar.getPosition();
                if (this.bjm) {
                    this.bjo = position;
                    kVar.position = this.bjn;
                    this.bjm = false;
                    z = true;
                } else if (!this.bjj || this.bjo == -1) {
                    z = false;
                } else {
                    kVar.position = this.bjo;
                    this.bjo = -1;
                    z = true;
                }
                if (z) {
                    AppMethodBeat.o(92018);
                    return 1;
                }
            }
            z2 = c2;
        }
        if (z2) {
            AppMethodBeat.o(92018);
            return 0;
        }
        AppMethodBeat.o(92018);
        return -1;
    }

    static int dX(int i2) {
        switch (i2) {
            case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
            case r.CTRL_INDEX /*{ENCODED_INT: 136}*/:
            case 155:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*{ENCODED_INT: 159}*/:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /*{ENCODED_INT: 176}*/:
            case 179:
            case 186:
            case 215:
            case 231:
            case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /*{ENCODED_INT: 241}*/:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX /*{ENCODED_INT: 134}*/:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /*{ENCODED_INT: 174}*/:
            case 183:
            case 187:
            case TbsListener.ErrorCode.EXCEED_INCR_UPDATE /*{ENCODED_INT: 224}*/:
            case TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR /*{ENCODED_INT: 225}*/:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case TbsListener.ErrorCode.STARTDOWNLOAD_4 /*{ENCODED_INT: 163}*/:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean dY(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar, long j2) {
        AppMethodBeat.i(92019);
        if ("S_TEXT/UTF8".equals(bVar.bjO)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, biO, biN);
        } else if ("S_TEXT/ASS".equals(bVar.bjO)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, biR, biS);
        }
        bVar.biA.a(j2, this.bjB, this.bjK, 0, bVar.bjS);
        this.bjL = true;
        uA();
        AppMethodBeat.o(92019);
    }

    private void uA() {
        AppMethodBeat.i(92020);
        this.bjC = 0;
        this.bjK = 0;
        this.bjJ = 0;
        this.bjD = false;
        this.bjE = false;
        this.bjG = false;
        this.bjI = 0;
        this.bjH = 0;
        this.bjF = false;
        this.biZ.reset();
        AppMethodBeat.o(92020);
    }

    /* access modifiers changed from: package-private */
    public final void b(f fVar, int i2) {
        AppMethodBeat.i(92021);
        if (this.bin.limit >= i2) {
            AppMethodBeat.o(92021);
            return;
        }
        if (this.bin.capacity() < i2) {
            this.bin.n(Arrays.copyOf(this.bin.data, Math.max(this.bin.data.length * 2, i2)), this.bin.limit);
        }
        fVar.readFully(this.bin.data, this.bin.limit, i2 - this.bin.limit);
        this.bin.eY(i2);
        AppMethodBeat.o(92021);
    }

    /* access modifiers changed from: package-private */
    public final void a(f fVar, b bVar, int i2) {
        boolean z;
        int i3;
        AppMethodBeat.i(92022);
        if ("S_TEXT/UTF8".equals(bVar.bjO)) {
            a(fVar, biM, i2);
            AppMethodBeat.o(92022);
        } else if ("S_TEXT/ASS".equals(bVar.bjO)) {
            a(fVar, biQ, i2);
            AppMethodBeat.o(92022);
        } else {
            com.google.android.exoplayer2.c.m mVar = bVar.biA;
            if (!this.bjD) {
                if (bVar.bjQ) {
                    this.bjB &= -1073741825;
                    if (!this.bjE) {
                        fVar.readFully(this.bin.data, 0, 1);
                        this.bjC++;
                        if ((this.bin.data[0] & 128) == 128) {
                            o oVar = new o("Extension bit is set in signal byte");
                            AppMethodBeat.o(92022);
                            throw oVar;
                        }
                        this.bjH = this.bin.data[0];
                        this.bjE = true;
                    }
                    if ((this.bjH & 1) == 1) {
                        if ((this.bjH & 2) == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.bjB |= 1073741824;
                        if (!this.bjF) {
                            fVar.readFully(this.bjb.data, 0, 8);
                            this.bjC += 8;
                            this.bjF = true;
                            byte[] bArr = this.bin.data;
                            if (z) {
                                i3 = 128;
                            } else {
                                i3 = 0;
                            }
                            bArr[0] = (byte) (i3 | 8);
                            this.bin.setPosition(0);
                            mVar.a(this.bin, 1);
                            this.bjK++;
                            this.bjb.setPosition(0);
                            mVar.a(this.bjb, 8);
                            this.bjK += 8;
                        }
                        if (z) {
                            if (!this.bjG) {
                                fVar.readFully(this.bin.data, 0, 1);
                                this.bjC++;
                                this.bin.setPosition(0);
                                this.bjI = this.bin.readUnsignedByte();
                                this.bjG = true;
                            }
                            int i4 = this.bjI * 4;
                            this.bin.reset(i4);
                            fVar.readFully(this.bin.data, 0, i4);
                            this.bjC = i4 + this.bjC;
                            short s = (short) ((this.bjI / 2) + 1);
                            int i5 = (s * 6) + 2;
                            if (this.bjd == null || this.bjd.capacity() < i5) {
                                this.bjd = ByteBuffer.allocate(i5);
                            }
                            this.bjd.position(0);
                            this.bjd.putShort(s);
                            int i6 = 0;
                            int i7 = 0;
                            while (i7 < this.bjI) {
                                int xk = this.bin.xk();
                                if (i7 % 2 == 0) {
                                    this.bjd.putShort((short) (xk - i6));
                                } else {
                                    this.bjd.putInt(xk - i6);
                                }
                                i7++;
                                i6 = xk;
                            }
                            int i8 = (i2 - this.bjC) - i6;
                            if (this.bjI % 2 == 1) {
                                this.bjd.putInt(i8);
                            } else {
                                this.bjd.putShort((short) i8);
                                this.bjd.putInt(0);
                            }
                            this.bjc.n(this.bjd.array(), i5);
                            mVar.a(this.bjc, i5);
                            this.bjK += i5;
                        }
                    }
                } else if (bVar.bjR != null) {
                    this.biZ.n(bVar.bjR, bVar.bjR.length);
                }
                this.bjD = true;
            }
            int i9 = this.biZ.limit + i2;
            if ("V_MPEG4/ISO/AVC".equals(bVar.bjO) || "V_MPEGH/ISO/HEVC".equals(bVar.bjO)) {
                byte[] bArr2 = this.biC.data;
                bArr2[0] = 0;
                bArr2[1] = 0;
                bArr2[2] = 0;
                int i10 = bVar.biD;
                int i11 = 4 - bVar.biD;
                while (this.bjC < i9) {
                    if (this.bjJ == 0) {
                        int min = Math.min(i10, this.biZ.xd());
                        fVar.readFully(bArr2, i11 + min, i10 - min);
                        if (min > 0) {
                            this.biZ.readBytes(bArr2, i11, min);
                        }
                        this.bjC += i10;
                        this.biC.setPosition(0);
                        this.bjJ = this.biC.xk();
                        this.biB.setPosition(0);
                        mVar.a(this.biB, 4);
                        this.bjK += 4;
                    } else {
                        this.bjJ -= a(fVar, mVar, this.bjJ);
                    }
                }
            } else {
                while (this.bjC < i9) {
                    a(fVar, mVar, i9 - this.bjC);
                }
            }
            if ("A_VORBIS".equals(bVar.bjO)) {
                this.biX.setPosition(0);
                mVar.a(this.biX, 4);
                this.bjK += 4;
            }
            AppMethodBeat.o(92022);
        }
    }

    private void a(f fVar, byte[] bArr, int i2) {
        AppMethodBeat.i(92023);
        int length = bArr.length + i2;
        if (this.bja.capacity() < length) {
            this.bja.data = Arrays.copyOf(bArr, length + i2);
        } else {
            System.arraycopy(bArr, 0, this.bja.data, 0, bArr.length);
        }
        fVar.readFully(this.bja.data, bArr.length, i2);
        this.bja.reset(length);
        AppMethodBeat.o(92023);
    }

    private void a(b bVar, String str, int i2, long j2, byte[] bArr) {
        AppMethodBeat.i(92024);
        a(this.bja.data, this.bjv, str, i2, j2, bArr);
        bVar.biA.a(this.bja, this.bja.limit);
        this.bjK += this.bja.limit;
        AppMethodBeat.o(92024);
    }

    private static void a(byte[] bArr, long j2, String str, int i2, long j3, byte[] bArr2) {
        byte[] bG;
        AppMethodBeat.i(92025);
        if (j2 == -9223372036854775807L) {
            bG = bArr2;
        } else {
            int i3 = (int) (j2 / 3600000000L);
            long j4 = j2 - (((long) (i3 * LocalCache.TIME_HOUR)) * TimeUtil.SECOND_TO_US);
            int i4 = (int) (j4 / 60000000);
            long j5 = j4 - (((long) (i4 * 60)) * TimeUtil.SECOND_TO_US);
            int i5 = (int) (j5 / TimeUtil.SECOND_TO_US);
            bG = x.bG(String.format(Locale.US, str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf((int) ((j5 - (((long) i5) * TimeUtil.SECOND_TO_US)) / j3))));
        }
        System.arraycopy(bG, 0, bArr, i2, bArr2.length);
        AppMethodBeat.o(92025);
    }

    private int a(f fVar, com.google.android.exoplayer2.c.m mVar, int i2) {
        int a2;
        AppMethodBeat.i(92026);
        int xd = this.biZ.xd();
        if (xd > 0) {
            a2 = Math.min(i2, xd);
            mVar.a(this.biZ, a2);
        } else {
            a2 = mVar.a(fVar, i2, false);
        }
        this.bjC += a2;
        this.bjK += a2;
        AppMethodBeat.o(92026);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final long M(long j2) {
        AppMethodBeat.i(92027);
        if (this.bjg == -9223372036854775807L) {
            o oVar = new o("Can't scale timecode prior to timecodeScale being set.");
            AppMethodBeat.o(92027);
            throw oVar;
        }
        long b2 = x.b(j2, this.bjg, 1000);
        AppMethodBeat.o(92027);
        return b2;
    }

    static int[] d(int[] iArr, int i2) {
        AppMethodBeat.i(92028);
        if (iArr == null) {
            int[] iArr2 = new int[i2];
            AppMethodBeat.o(92028);
            return iArr2;
        } else if (iArr.length >= i2) {
            AppMethodBeat.o(92028);
            return iArr;
        } else {
            int[] iArr3 = new int[Math.max(iArr.length * 2, i2)];
            AppMethodBeat.o(92028);
            return iArr3;
        }
    }

    final class a implements c {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.c.b.c
        public final int dX(int i2) {
            AppMethodBeat.i(92004);
            int dX = d.dX(i2);
            AppMethodBeat.o(92004);
            return dX;
        }

        @Override // com.google.android.exoplayer2.c.b.c
        public final boolean dY(int i2) {
            AppMethodBeat.i(92005);
            boolean dY = d.dY(i2);
            AppMethodBeat.o(92005);
            return dY;
        }

        @Override // com.google.android.exoplayer2.c.b.c
        public final void f(int i2, long j2, long j3) {
            AppMethodBeat.i(92006);
            d dVar = d.this;
            switch (i2) {
                case 160:
                    dVar.bjM = false;
                    AppMethodBeat.o(92006);
                    return;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /*{ENCODED_INT: 174}*/:
                    dVar.bji = new b((byte) 0);
                    AppMethodBeat.o(92006);
                    return;
                case 187:
                    dVar.bjs = false;
                    AppMethodBeat.o(92006);
                    return;
                case 19899:
                    dVar.bjk = -1;
                    dVar.bjl = -1;
                    AppMethodBeat.o(92006);
                    return;
                case 20533:
                    dVar.bji.bjQ = true;
                    AppMethodBeat.o(92006);
                    return;
                case 21968:
                    dVar.bji.bjV = true;
                    break;
                case 25152:
                    AppMethodBeat.o(92006);
                    return;
                case 408125543:
                    if (dVar.bjf == -1 || dVar.bjf == j2) {
                        dVar.bjf = j2;
                        dVar.bje = j3;
                        AppMethodBeat.o(92006);
                        return;
                    }
                    o oVar = new o("Multiple Segment elements not supported");
                    AppMethodBeat.o(92006);
                    throw oVar;
                case 475249515:
                    dVar.bjq = new com.google.android.exoplayer2.i.h();
                    dVar.bjr = new com.google.android.exoplayer2.i.h();
                    AppMethodBeat.o(92006);
                    return;
                case 524531317:
                    if (!dVar.bjj) {
                        if (!dVar.biW || dVar.bjn == -1) {
                            dVar.bir.a(new l.a(dVar.bdJ));
                            dVar.bjj = true;
                            AppMethodBeat.o(92006);
                            return;
                        }
                        dVar.bjm = true;
                        AppMethodBeat.o(92006);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(92006);
        }

        @Override // com.google.android.exoplayer2.c.b.c
        public final void dZ(int i2) {
            boolean z;
            String str;
            List singletonList;
            Format a2;
            byte[] bArr;
            int i3;
            l lVar;
            AppMethodBeat.i(92007);
            d dVar = d.this;
            switch (i2) {
                case 160:
                    if (dVar.bjt == 2) {
                        if (!dVar.bjM) {
                            dVar.bjB |= 1;
                        }
                        dVar.a(dVar.biV.get(dVar.bjz), dVar.bju);
                        dVar.bjt = 0;
                        AppMethodBeat.o(92007);
                        return;
                    }
                    break;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /*{ENCODED_INT: 174}*/:
                    String str2 = dVar.bji.bjO;
                    if ("V_VP8".equals(str2) || "V_VP9".equals(str2) || "V_MPEG2".equals(str2) || "V_MPEG4/ISO/SP".equals(str2) || "V_MPEG4/ISO/ASP".equals(str2) || "V_MPEG4/ISO/AP".equals(str2) || "V_MPEG4/ISO/AVC".equals(str2) || "V_MPEGH/ISO/HEVC".equals(str2) || "V_MS/VFW/FOURCC".equals(str2) || "V_THEORA".equals(str2) || "A_OPUS".equals(str2) || "A_VORBIS".equals(str2) || "A_AAC".equals(str2) || "A_MPEG/L2".equals(str2) || "A_MPEG/L3".equals(str2) || "A_AC3".equals(str2) || "A_EAC3".equals(str2) || "A_TRUEHD".equals(str2) || "A_DTS".equals(str2) || "A_DTS/EXPRESS".equals(str2) || "A_DTS/LOSSLESS".equals(str2) || "A_FLAC".equals(str2) || "A_MS/ACM".equals(str2) || "A_PCM/INT/LIT".equals(str2) || "S_TEXT/UTF8".equals(str2) || "S_TEXT/ASS".equals(str2) || "S_VOBSUB".equals(str2) || "S_HDMV/PGS".equals(str2) || "S_DVBSUB".equals(str2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        b bVar = dVar.bji;
                        g gVar = dVar.bir;
                        int i4 = dVar.bji.number;
                        int i5 = -1;
                        int i6 = -1;
                        List list = null;
                        String str3 = bVar.bjO;
                        char c2 = 65535;
                        switch (str3.hashCode()) {
                            case -2095576542:
                                if (str3.equals("V_MPEG4/ISO/AP")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                            case -2095575984:
                                if (str3.equals("V_MPEG4/ISO/SP")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case -1985379776:
                                if (str3.equals("A_MS/ACM")) {
                                    c2 = 22;
                                    break;
                                }
                                break;
                            case -1784763192:
                                if (str3.equals("A_TRUEHD")) {
                                    c2 = 17;
                                    break;
                                }
                                break;
                            case -1730367663:
                                if (str3.equals("A_VORBIS")) {
                                    c2 = '\n';
                                    break;
                                }
                                break;
                            case -1482641358:
                                if (str3.equals("A_MPEG/L2")) {
                                    c2 = '\r';
                                    break;
                                }
                                break;
                            case -1482641357:
                                if (str3.equals("A_MPEG/L3")) {
                                    c2 = 14;
                                    break;
                                }
                                break;
                            case -1373388978:
                                if (str3.equals("V_MS/VFW/FOURCC")) {
                                    c2 = '\b';
                                    break;
                                }
                                break;
                            case -933872740:
                                if (str3.equals("S_DVBSUB")) {
                                    c2 = 28;
                                    break;
                                }
                                break;
                            case -538363189:
                                if (str3.equals("V_MPEG4/ISO/ASP")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case -538363109:
                                if (str3.equals("V_MPEG4/ISO/AVC")) {
                                    c2 = 6;
                                    break;
                                }
                                break;
                            case -425012669:
                                if (str3.equals("S_VOBSUB")) {
                                    c2 = 26;
                                    break;
                                }
                                break;
                            case -356037306:
                                if (str3.equals("A_DTS/LOSSLESS")) {
                                    c2 = 20;
                                    break;
                                }
                                break;
                            case 62923557:
                                if (str3.equals("A_AAC")) {
                                    c2 = '\f';
                                    break;
                                }
                                break;
                            case 62923603:
                                if (str3.equals("A_AC3")) {
                                    c2 = 15;
                                    break;
                                }
                                break;
                            case 62927045:
                                if (str3.equals("A_DTS")) {
                                    c2 = 18;
                                    break;
                                }
                                break;
                            case 82338133:
                                if (str3.equals("V_VP8")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 82338134:
                                if (str3.equals("V_VP9")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 99146302:
                                if (str3.equals("S_HDMV/PGS")) {
                                    c2 = 27;
                                    break;
                                }
                                break;
                            case 444813526:
                                if (str3.equals("V_THEORA")) {
                                    c2 = '\t';
                                    break;
                                }
                                break;
                            case 542569478:
                                if (str3.equals("A_DTS/EXPRESS")) {
                                    c2 = 19;
                                    break;
                                }
                                break;
                            case 725957860:
                                if (str3.equals("A_PCM/INT/LIT")) {
                                    c2 = 23;
                                    break;
                                }
                                break;
                            case 738597099:
                                if (str3.equals("S_TEXT/ASS")) {
                                    c2 = 25;
                                    break;
                                }
                                break;
                            case 855502857:
                                if (str3.equals("V_MPEGH/ISO/HEVC")) {
                                    c2 = 7;
                                    break;
                                }
                                break;
                            case 1422270023:
                                if (str3.equals("S_TEXT/UTF8")) {
                                    c2 = 24;
                                    break;
                                }
                                break;
                            case 1809237540:
                                if (str3.equals("V_MPEG2")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 1950749482:
                                if (str3.equals("A_EAC3")) {
                                    c2 = 16;
                                    break;
                                }
                                break;
                            case 1950789798:
                                if (str3.equals("A_FLAC")) {
                                    c2 = 21;
                                    break;
                                }
                                break;
                            case 1951062397:
                                if (str3.equals("A_OPUS")) {
                                    c2 = 11;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                str = "video/x-vnd.on2.vp8";
                                break;
                            case 1:
                                str = TPDecoderType.TP_CODEC_MIMETYPE_VP9;
                                break;
                            case 2:
                                str = "video/mpeg2";
                                break;
                            case 3:
                            case 4:
                            case 5:
                                str = "video/mp4v-es";
                                if (bVar.bjT == null) {
                                    singletonList = null;
                                } else {
                                    singletonList = Collections.singletonList(bVar.bjT);
                                }
                                list = singletonList;
                                break;
                            case 6:
                                str = "video/avc";
                                com.google.android.exoplayer2.video.a K = com.google.android.exoplayer2.video.a.K(new m(bVar.bjT));
                                list = K.bds;
                                bVar.biD = K.biD;
                                break;
                            case 7:
                                str = TPDecoderType.TP_CODEC_MIMETYPE_HEVC;
                                com.google.android.exoplayer2.video.b M = com.google.android.exoplayer2.video.b.M(new m(bVar.bjT));
                                list = M.bds;
                                bVar.biD = M.biD;
                                break;
                            case '\b':
                                list = b.i(new m(bVar.bjT));
                                if (list != null) {
                                    str = "video/wvc1";
                                    break;
                                } else {
                                    str = "video/x-unknown";
                                    break;
                                }
                            case '\t':
                                str = "video/x-unknown";
                                break;
                            case '\n':
                                str = "audio/vorbis";
                                i5 = 8192;
                                list = b.q(bVar.bjT);
                                break;
                            case 11:
                                str = "audio/opus";
                                i5 = 5760;
                                list = new ArrayList(3);
                                list.add(bVar.bjT);
                                list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(bVar.bkm).array());
                                list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(bVar.bkn).array());
                                break;
                            case '\f':
                                str = EncoderWriter.OUTPUT_AUDIO_MIME_TYPE;
                                list = Collections.singletonList(bVar.bjT);
                                break;
                            case '\r':
                                str = "audio/mpeg-L2";
                                i5 = 4096;
                                break;
                            case 14:
                                str = "audio/mpeg";
                                i5 = 4096;
                                break;
                            case 15:
                                str = "audio/ac3";
                                break;
                            case 16:
                                str = "audio/eac3";
                                break;
                            case 17:
                                str = "audio/true-hd";
                                break;
                            case 18:
                            case 19:
                                str = "audio/vnd.dts";
                                break;
                            case 20:
                                str = "audio/vnd.dts.hd";
                                break;
                            case 21:
                                str = "audio/flac";
                                list = Collections.singletonList(bVar.bjT);
                                break;
                            case 22:
                                str = "audio/raw";
                                if (b.j(new m(bVar.bjT))) {
                                    i6 = x.fg(bVar.bkl);
                                    if (i6 == 0) {
                                        i6 = -1;
                                        str = "audio/x-unknown";
                                        new StringBuilder("Unsupported PCM bit depth: ").append(bVar.bkl).append(". Setting mimeType to ").append(str);
                                        break;
                                    }
                                } else {
                                    str = "audio/x-unknown";
                                    break;
                                }
                                break;
                            case 23:
                                str = "audio/raw";
                                i6 = x.fg(bVar.bkl);
                                if (i6 == 0) {
                                    i6 = -1;
                                    str = "audio/x-unknown";
                                    new StringBuilder("Unsupported PCM bit depth: ").append(bVar.bkl).append(". Setting mimeType to ").append(str);
                                    break;
                                }
                                break;
                            case 24:
                                str = "application/x-subrip";
                                break;
                            case 25:
                                str = "text/x-ssa";
                                break;
                            case 26:
                                str = "application/vobsub";
                                list = Collections.singletonList(bVar.bjT);
                                break;
                            case 27:
                                str = "application/pgs";
                                break;
                            case 28:
                                str = "application/dvbsubs";
                                list = Collections.singletonList(new byte[]{bVar.bjT[0], bVar.bjT[1], bVar.bjT[2], bVar.bjT[3]});
                                break;
                            default:
                                o oVar = new o("Unrecognized codec identifier.");
                                AppMethodBeat.o(92007);
                                throw oVar;
                        }
                        int i7 = (bVar.bkp ? 1 : 0) | 0 | (bVar.bko ? 2 : 0);
                        if (j.bx(str)) {
                            a2 = Format.a(Integer.toString(i4), str, -1, i5, bVar.channelCount, bVar.sampleRate, i6, list, bVar.bdt, i7, bVar.language);
                        } else if (j.by(str)) {
                            if (bVar.bjU == 0) {
                                bVar.displayWidth = bVar.displayWidth == -1 ? bVar.width : bVar.displayWidth;
                                if (bVar.displayHeight == -1) {
                                    i3 = bVar.height;
                                } else {
                                    i3 = bVar.displayHeight;
                                }
                                bVar.displayHeight = i3;
                            }
                            float f2 = -1.0f;
                            if (!(bVar.displayWidth == -1 || bVar.displayHeight == -1)) {
                                f2 = ((float) (bVar.height * bVar.displayWidth)) / ((float) (bVar.width * bVar.displayHeight));
                            }
                            ColorInfo colorInfo = null;
                            if (bVar.bjV) {
                                if (bVar.bkb == -1.0f || bVar.bkc == -1.0f || bVar.bkd == -1.0f || bVar.bke == -1.0f || bVar.bkf == -1.0f || bVar.bkg == -1.0f || bVar.bkh == -1.0f || bVar.bki == -1.0f || bVar.bkj == -1.0f || bVar.bkk == -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = new byte[25];
                                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                                    wrap.put((byte) 0);
                                    wrap.putShort((short) ((int) ((bVar.bkb * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.bkc * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.bkd * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.bke * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.bkf * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.bkg * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.bkh * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.bki * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) (bVar.bkj + 0.5f)));
                                    wrap.putShort((short) ((int) (bVar.bkk + 0.5f)));
                                    wrap.putShort((short) bVar.bjZ);
                                    wrap.putShort((short) bVar.bka);
                                }
                                colorInfo = new ColorInfo(bVar.bjW, bVar.bjY, bVar.bjX, bArr);
                            }
                            a2 = Format.a(Integer.toString(i4), str, i5, bVar.width, bVar.height, list, -1, f2, bVar.bdy, bVar.bdx, colorInfo, bVar.bdt);
                        } else if ("application/x-subrip".equals(str)) {
                            a2 = Format.a(Integer.toString(i4), str, i7, bVar.language, bVar.bdt);
                        } else if ("text/x-ssa".equals(str)) {
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(d.biP);
                            arrayList.add(bVar.bjT);
                            a2 = Format.a(Integer.toString(i4), str, i7, bVar.language, -1, bVar.bdt, MAlarmHandler.NEXT_FIRE_INTERVAL, arrayList);
                        } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                            a2 = Format.a(Integer.toString(i4), str, list, bVar.language, bVar.bdt);
                        } else {
                            o oVar2 = new o("Unexpected MIME type.");
                            AppMethodBeat.o(92007);
                            throw oVar2;
                        }
                        bVar.biA = gVar.dV(bVar.number);
                        bVar.biA.f(a2);
                        dVar.biV.put(dVar.bji.number, dVar.bji);
                    }
                    dVar.bji = null;
                    AppMethodBeat.o(92007);
                    return;
                case 19899:
                    if (dVar.bjk == -1 || dVar.bjl == -1) {
                        o oVar3 = new o("Mandatory element SeekID or SeekPosition not found");
                        AppMethodBeat.o(92007);
                        throw oVar3;
                    } else if (dVar.bjk == 475249515) {
                        dVar.bjn = dVar.bjl;
                        AppMethodBeat.o(92007);
                        return;
                    }
                    break;
                case 25152:
                    if (dVar.bji.bjQ) {
                        if (dVar.bji.bjS == null) {
                            o oVar4 = new o("Encrypted Track found but ContentEncKeyID was not found");
                            AppMethodBeat.o(92007);
                            throw oVar4;
                        }
                        dVar.bji.bdt = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.b.bbJ, "video/webm", dVar.bji.bjS.bih));
                        AppMethodBeat.o(92007);
                        return;
                    }
                    break;
                case 28032:
                    if (dVar.bji.bjQ && dVar.bji.bjR != null) {
                        o oVar5 = new o("Combining encryption and compression is not supported");
                        AppMethodBeat.o(92007);
                        throw oVar5;
                    }
                case 357149030:
                    if (dVar.bjg == -9223372036854775807L) {
                        dVar.bjg = TimeUtil.SECOND_TO_US;
                    }
                    if (dVar.bjh != -9223372036854775807L) {
                        dVar.bdJ = dVar.M(dVar.bjh);
                        AppMethodBeat.o(92007);
                        return;
                    }
                    break;
                case 374648427:
                    if (dVar.biV.size() != 0) {
                        dVar.bir.uy();
                        break;
                    } else {
                        o oVar6 = new o("No valid tracks were found");
                        AppMethodBeat.o(92007);
                        throw oVar6;
                    }
                case 475249515:
                    if (!dVar.bjj) {
                        g gVar2 = dVar.bir;
                        if (dVar.bjf == -1 || dVar.bdJ == -9223372036854775807L || dVar.bjq == null || dVar.bjq.size == 0 || dVar.bjr == null || dVar.bjr.size != dVar.bjq.size) {
                            dVar.bjq = null;
                            dVar.bjr = null;
                            lVar = new l.a(dVar.bdJ);
                        } else {
                            int i8 = dVar.bjq.size;
                            int[] iArr = new int[i8];
                            long[] jArr = new long[i8];
                            long[] jArr2 = new long[i8];
                            long[] jArr3 = new long[i8];
                            for (int i9 = 0; i9 < i8; i9++) {
                                jArr3[i9] = dVar.bjq.get(i9);
                                jArr[i9] = dVar.bjf + dVar.bjr.get(i9);
                            }
                            for (int i10 = 0; i10 < i8 - 1; i10++) {
                                iArr[i10] = (int) (jArr[i10 + 1] - jArr[i10]);
                                jArr2[i10] = jArr3[i10 + 1] - jArr3[i10];
                            }
                            iArr[i8 - 1] = (int) ((dVar.bjf + dVar.bje) - jArr[i8 - 1]);
                            jArr2[i8 - 1] = dVar.bdJ - jArr3[i8 - 1];
                            dVar.bjq = null;
                            dVar.bjr = null;
                            lVar = new com.google.android.exoplayer2.c.a(iArr, jArr, jArr2, jArr3);
                        }
                        gVar2.a(lVar);
                        dVar.bjj = true;
                        AppMethodBeat.o(92007);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(92007);
        }

        @Override // com.google.android.exoplayer2.c.b.c
        public final void i(int i2, long j2) {
            boolean z = true;
            AppMethodBeat.i(92008);
            d dVar = d.this;
            switch (i2) {
                case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
                    dVar.bji.type = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case r.CTRL_INDEX /*{ENCODED_INT: 136}*/:
                    b bVar = dVar.bji;
                    if (j2 != 1) {
                        z = false;
                    }
                    bVar.bko = z;
                    AppMethodBeat.o(92008);
                    return;
                case 155:
                    dVar.bjv = dVar.M(j2);
                    AppMethodBeat.o(92008);
                    return;
                case JsApiGetBackgroundAudioState.CTRL_INDEX /*{ENCODED_INT: 159}*/:
                    dVar.bji.channelCount = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /*{ENCODED_INT: 176}*/:
                    dVar.bji.width = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case 179:
                    dVar.bjq.add(dVar.M(j2));
                    AppMethodBeat.o(92008);
                    return;
                case 186:
                    dVar.bji.height = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case 215:
                    dVar.bji.number = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case 231:
                    dVar.bjp = dVar.M(j2);
                    AppMethodBeat.o(92008);
                    return;
                case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /*{ENCODED_INT: 241}*/:
                    if (!dVar.bjs) {
                        dVar.bjr.add(j2);
                        dVar.bjs = true;
                        AppMethodBeat.o(92008);
                        return;
                    }
                    break;
                case 251:
                    dVar.bjM = true;
                    AppMethodBeat.o(92008);
                    return;
                case 16980:
                    if (j2 != 3) {
                        o oVar = new o("ContentCompAlgo " + j2 + " not supported");
                        AppMethodBeat.o(92008);
                        throw oVar;
                    }
                    break;
                case 17029:
                    if (j2 < 1 || j2 > 2) {
                        o oVar2 = new o("DocTypeReadVersion " + j2 + " not supported");
                        AppMethodBeat.o(92008);
                        throw oVar2;
                    }
                case 17143:
                    if (j2 != 1) {
                        o oVar3 = new o("EBMLReadVersion " + j2 + " not supported");
                        AppMethodBeat.o(92008);
                        throw oVar3;
                    }
                    break;
                case 18401:
                    if (j2 != 5) {
                        o oVar4 = new o("ContentEncAlgo " + j2 + " not supported");
                        AppMethodBeat.o(92008);
                        throw oVar4;
                    }
                    break;
                case 18408:
                    if (j2 != 1) {
                        o oVar5 = new o("AESSettingsCipherMode " + j2 + " not supported");
                        AppMethodBeat.o(92008);
                        throw oVar5;
                    }
                    break;
                case 20529:
                    if (j2 != 0) {
                        o oVar6 = new o("ContentEncodingOrder " + j2 + " not supported");
                        AppMethodBeat.o(92008);
                        throw oVar6;
                    }
                    break;
                case 20530:
                    if (j2 != 1) {
                        o oVar7 = new o("ContentEncodingScope " + j2 + " not supported");
                        AppMethodBeat.o(92008);
                        throw oVar7;
                    }
                    break;
                case 21420:
                    dVar.bjl = dVar.bjf + j2;
                    AppMethodBeat.o(92008);
                    return;
                case 21432:
                    switch ((int) j2) {
                        case 0:
                            dVar.bji.bdx = 0;
                            AppMethodBeat.o(92008);
                            return;
                        case 1:
                            dVar.bji.bdx = 2;
                            AppMethodBeat.o(92008);
                            return;
                        case 3:
                            dVar.bji.bdx = 1;
                            AppMethodBeat.o(92008);
                            return;
                        case 15:
                            dVar.bji.bdx = 3;
                            AppMethodBeat.o(92008);
                            return;
                        default:
                            AppMethodBeat.o(92008);
                            return;
                    }
                case 21680:
                    dVar.bji.displayWidth = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case 21682:
                    dVar.bji.bjU = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case 21690:
                    dVar.bji.displayHeight = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case 21930:
                    b bVar2 = dVar.bji;
                    if (j2 != 1) {
                        z = false;
                    }
                    bVar2.bkp = z;
                    AppMethodBeat.o(92008);
                    return;
                case 21945:
                    switch ((int) j2) {
                        case 1:
                            dVar.bji.bjY = 2;
                            AppMethodBeat.o(92008);
                            return;
                        case 2:
                            dVar.bji.bjY = 1;
                            AppMethodBeat.o(92008);
                            return;
                        default:
                            AppMethodBeat.o(92008);
                            return;
                    }
                case 21946:
                    switch ((int) j2) {
                        case 1:
                        case 6:
                        case 7:
                            dVar.bji.bjX = 3;
                            AppMethodBeat.o(92008);
                            return;
                        case 16:
                            dVar.bji.bjX = 6;
                            AppMethodBeat.o(92008);
                            return;
                        case 18:
                            dVar.bji.bjX = 7;
                            AppMethodBeat.o(92008);
                            return;
                        default:
                            AppMethodBeat.o(92008);
                            return;
                    }
                case 21947:
                    dVar.bji.bjV = true;
                    switch ((int) j2) {
                        case 1:
                            dVar.bji.bjW = 1;
                            AppMethodBeat.o(92008);
                            return;
                        case 2:
                        case 3:
                        case 8:
                        default:
                            AppMethodBeat.o(92008);
                            return;
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            dVar.bji.bjW = 2;
                            AppMethodBeat.o(92008);
                            return;
                        case 9:
                            dVar.bji.bjW = 6;
                            AppMethodBeat.o(92008);
                            return;
                    }
                case 21948:
                    dVar.bji.bjZ = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case 21949:
                    dVar.bji.bka = (int) j2;
                    break;
                case 22186:
                    dVar.bji.bkm = j2;
                    AppMethodBeat.o(92008);
                    return;
                case 22203:
                    dVar.bji.bkn = j2;
                    AppMethodBeat.o(92008);
                    return;
                case 25188:
                    dVar.bji.bkl = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case 2352003:
                    dVar.bji.bjP = (int) j2;
                    AppMethodBeat.o(92008);
                    return;
                case 2807729:
                    dVar.bjg = j2;
                    AppMethodBeat.o(92008);
                    return;
            }
            AppMethodBeat.o(92008);
        }

        @Override // com.google.android.exoplayer2.c.b.c
        public final void b(int i2, double d2) {
            d dVar = d.this;
            switch (i2) {
                case 181:
                    dVar.bji.sampleRate = (int) d2;
                    return;
                case 17545:
                    dVar.bjh = (long) d2;
                    return;
                case 21969:
                    dVar.bji.bkb = (float) d2;
                    return;
                case 21970:
                    dVar.bji.bkc = (float) d2;
                    return;
                case 21971:
                    dVar.bji.bkd = (float) d2;
                    return;
                case 21972:
                    dVar.bji.bke = (float) d2;
                    return;
                case 21973:
                    dVar.bji.bkf = (float) d2;
                    return;
                case 21974:
                    dVar.bji.bkg = (float) d2;
                    return;
                case 21975:
                    dVar.bji.bkh = (float) d2;
                    return;
                case 21976:
                    dVar.bji.bki = (float) d2;
                    return;
                case 21977:
                    dVar.bji.bkj = (float) d2;
                    return;
                case 21978:
                    dVar.bji.bkk = (float) d2;
                    return;
                default:
                    return;
            }
        }

        @Override // com.google.android.exoplayer2.c.b.c
        public final void d(int i2, String str) {
            AppMethodBeat.i(92009);
            d dVar = d.this;
            switch (i2) {
                case com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX /*{ENCODED_INT: 134}*/:
                    dVar.bji.bjO = str;
                    AppMethodBeat.o(92009);
                    return;
                case 17026:
                    if (!"webm".equals(str) && !"matroska".equals(str)) {
                        o oVar = new o("DocType " + str + " not supported");
                        AppMethodBeat.o(92009);
                        throw oVar;
                    }
                case 2274716:
                    dVar.bji.language = str;
                    break;
            }
            AppMethodBeat.o(92009);
        }

        @Override // com.google.android.exoplayer2.c.b.c
        public final void a(int i2, int i3, f fVar) {
            int i4;
            int i5;
            AppMethodBeat.i(92010);
            d dVar = d.this;
            switch (i2) {
                case 161:
                case TbsListener.ErrorCode.STARTDOWNLOAD_4 /*{ENCODED_INT: 163}*/:
                    if (dVar.bjt == 0) {
                        dVar.bjz = (int) dVar.biG.a(fVar, false, true, 8);
                        dVar.bjA = dVar.biG.length;
                        dVar.bjv = -9223372036854775807L;
                        dVar.bjt = 1;
                        dVar.bin.reset();
                    }
                    b bVar = dVar.biV.get(dVar.bjz);
                    if (bVar == null) {
                        fVar.dP(i3 - dVar.bjA);
                        dVar.bjt = 0;
                        AppMethodBeat.o(92010);
                        return;
                    }
                    if (dVar.bjt == 1) {
                        dVar.b(fVar, 3);
                        int i6 = (dVar.bin.data[2] & 6) >> 1;
                        if (i6 == 0) {
                            dVar.bjx = 1;
                            dVar.bjy = d.d(dVar.bjy, 1);
                            dVar.bjy[0] = (i3 - dVar.bjA) - 3;
                        } else if (i2 != 163) {
                            o oVar = new o("Lacing only supported in SimpleBlocks.");
                            AppMethodBeat.o(92010);
                            throw oVar;
                        } else {
                            dVar.b(fVar, 4);
                            dVar.bjx = (dVar.bin.data[3] & 255) + 1;
                            dVar.bjy = d.d(dVar.bjy, dVar.bjx);
                            if (i6 == 2) {
                                Arrays.fill(dVar.bjy, 0, dVar.bjx, ((i3 - dVar.bjA) - 4) / dVar.bjx);
                            } else if (i6 == 1) {
                                int i7 = 0;
                                int i8 = 4;
                                for (int i9 = 0; i9 < dVar.bjx - 1; i9++) {
                                    dVar.bjy[i9] = 0;
                                    do {
                                        i8++;
                                        dVar.b(fVar, i8);
                                        i4 = dVar.bin.data[i8 - 1] & 255;
                                        int[] iArr = dVar.bjy;
                                        iArr[i9] = iArr[i9] + i4;
                                    } while (i4 == 255);
                                    i7 += dVar.bjy[i9];
                                }
                                dVar.bjy[dVar.bjx - 1] = ((i3 - dVar.bjA) - i8) - i7;
                            } else if (i6 == 3) {
                                int i10 = 0;
                                int i11 = 4;
                                for (int i12 = 0; i12 < dVar.bjx - 1; i12++) {
                                    dVar.bjy[i12] = 0;
                                    i11++;
                                    dVar.b(fVar, i11);
                                    if (dVar.bin.data[i11 - 1] == 0) {
                                        o oVar2 = new o("No valid varint length mask found");
                                        AppMethodBeat.o(92010);
                                        throw oVar2;
                                    }
                                    long j2 = 0;
                                    int i13 = 0;
                                    while (true) {
                                        if (i13 < 8) {
                                            int i14 = 1 << (7 - i13);
                                            if ((dVar.bin.data[i11 - 1] & i14) != 0) {
                                                int i15 = i11 - 1;
                                                i11 += i13;
                                                dVar.b(fVar, i11);
                                                j2 = (long) (dVar.bin.data[i15] & 255 & (i14 ^ -1));
                                                for (int i16 = i15 + 1; i16 < i11; i16++) {
                                                    j2 = (j2 << 8) | ((long) (dVar.bin.data[i16] & 255));
                                                }
                                                if (i12 > 0) {
                                                    j2 -= (1 << ((i13 * 7) + 6)) - 1;
                                                }
                                            } else {
                                                i13++;
                                            }
                                        }
                                    }
                                    if (j2 < -2147483648L || j2 > 2147483647L) {
                                        o oVar3 = new o("EBML lacing sample size out of range.");
                                        AppMethodBeat.o(92010);
                                        throw oVar3;
                                    }
                                    int i17 = (int) j2;
                                    int[] iArr2 = dVar.bjy;
                                    if (i12 != 0) {
                                        i17 += dVar.bjy[i12 - 1];
                                    }
                                    iArr2[i12] = i17;
                                    i10 += dVar.bjy[i12];
                                }
                                dVar.bjy[dVar.bjx - 1] = ((i3 - dVar.bjA) - i11) - i10;
                            } else {
                                o oVar4 = new o("Unexpected lacing value: ".concat(String.valueOf(i6)));
                                AppMethodBeat.o(92010);
                                throw oVar4;
                            }
                        }
                        dVar.bju = dVar.bjp + dVar.M((long) ((dVar.bin.data[0] << 8) | (dVar.bin.data[1] & 255)));
                        boolean z = (dVar.bin.data[2] & 8) == 8;
                        int i18 = bVar.type == 2 || (i2 == 163 && (dVar.bin.data[2] & 128) == 128) ? 1 : 0;
                        if (z) {
                            i5 = Integer.MIN_VALUE;
                        } else {
                            i5 = 0;
                        }
                        dVar.bjB = i5 | i18;
                        dVar.bjt = 2;
                        dVar.bjw = 0;
                    }
                    if (i2 == 163) {
                        while (dVar.bjw < dVar.bjx) {
                            dVar.a(fVar, bVar, dVar.bjy[dVar.bjw]);
                            dVar.a(bVar, dVar.bju + ((long) ((dVar.bjw * bVar.bjP) / 1000)));
                            dVar.bjw++;
                        }
                        dVar.bjt = 0;
                        AppMethodBeat.o(92010);
                        return;
                    }
                    dVar.a(fVar, bVar, dVar.bjy[0]);
                    AppMethodBeat.o(92010);
                    return;
                case 16981:
                    dVar.bji.bjR = new byte[i3];
                    fVar.readFully(dVar.bji.bjR, 0, i3);
                    AppMethodBeat.o(92010);
                    return;
                case 18402:
                    byte[] bArr = new byte[i3];
                    fVar.readFully(bArr, 0, i3);
                    dVar.bji.bjS = new m.a(1, bArr, 0, 0);
                    AppMethodBeat.o(92010);
                    return;
                case 21419:
                    Arrays.fill(dVar.biY.data, (byte) 0);
                    fVar.readFully(dVar.biY.data, 4 - i3, i3);
                    dVar.biY.setPosition(0);
                    dVar.bjk = (int) dVar.biY.dE();
                    AppMethodBeat.o(92010);
                    return;
                case 25506:
                    dVar.bji.bjT = new byte[i3];
                    fVar.readFully(dVar.bji.bjT, 0, i3);
                    AppMethodBeat.o(92010);
                    return;
                case 30322:
                    dVar.bji.bdy = new byte[i3];
                    fVar.readFully(dVar.bji.bdy, 0, i3);
                    AppMethodBeat.o(92010);
                    return;
                default:
                    o oVar5 = new o("Unexpected id: ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(92010);
                    throw oVar5;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        public DrmInitData bdt;
        public int bdx;
        public byte[] bdy;
        public com.google.android.exoplayer2.c.m biA;
        public int biD;
        public String bjO;
        public int bjP;
        public boolean bjQ;
        public byte[] bjR;
        public m.a bjS;
        public byte[] bjT;
        public int bjU;
        public boolean bjV;
        public int bjW;
        public int bjX;
        public int bjY;
        public int bjZ;
        public int bka;
        public float bkb;
        public float bkc;
        public float bkd;
        public float bke;
        public float bkf;
        public float bkg;
        public float bkh;
        public float bki;
        public float bkj;
        public float bkk;
        public int bkl;
        public long bkm;
        public long bkn;
        public boolean bko;
        public boolean bkp;
        public int channelCount;
        public int displayHeight;
        public int displayWidth;
        public int height;
        String language;
        public int number;
        public int sampleRate;
        public int type;
        public int width;

        private b() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.bjU = 0;
            this.bdy = null;
            this.bdx = -1;
            this.bjV = false;
            this.bjW = -1;
            this.bjX = -1;
            this.bjY = -1;
            this.bjZ = 1000;
            this.bka = 200;
            this.bkb = -1.0f;
            this.bkc = -1.0f;
            this.bkd = -1.0f;
            this.bke = -1.0f;
            this.bkf = -1.0f;
            this.bkg = -1.0f;
            this.bkh = -1.0f;
            this.bki = -1.0f;
            this.bkj = -1.0f;
            this.bkk = -1.0f;
            this.channelCount = 1;
            this.bkl = -1;
            this.sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
            this.bkm = 0;
            this.bkn = 0;
            this.bkp = true;
            this.language = "eng";
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        static List<byte[]> i(com.google.android.exoplayer2.i.m mVar) {
            AppMethodBeat.i(92011);
            try {
                mVar.eZ(16);
                if (mVar.xg() != 826496599) {
                    AppMethodBeat.o(92011);
                    return null;
                }
                byte[] bArr = mVar.data;
                for (int i2 = mVar.position + 20; i2 < bArr.length - 4; i2++) {
                    if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 1 && bArr[i2 + 3] == 15) {
                        List<byte[]> singletonList = Collections.singletonList(Arrays.copyOfRange(bArr, i2, bArr.length));
                        AppMethodBeat.o(92011);
                        return singletonList;
                    }
                }
                o oVar = new o("Failed to find FourCC VC1 initialization data");
                AppMethodBeat.o(92011);
                throw oVar;
            } catch (ArrayIndexOutOfBoundsException e2) {
                o oVar2 = new o("Error parsing FourCC VC1 codec private");
                AppMethodBeat.o(92011);
                throw oVar2;
            }
        }

        static List<byte[]> q(byte[] bArr) {
            int i2 = 0;
            AppMethodBeat.i(92012);
            try {
                if (bArr[0] != 2) {
                    o oVar = new o("Error parsing vorbis codec private");
                    AppMethodBeat.o(92012);
                    throw oVar;
                }
                int i3 = 0;
                int i4 = 1;
                while (bArr[i4] == -1) {
                    i4++;
                    i3 += 255;
                }
                int i5 = i4 + 1;
                int i6 = i3 + bArr[i4];
                while (bArr[i5] == -1) {
                    i2 += 255;
                    i5++;
                }
                int i7 = i5 + 1;
                int i8 = i2 + bArr[i5];
                if (bArr[i7] != 1) {
                    o oVar2 = new o("Error parsing vorbis codec private");
                    AppMethodBeat.o(92012);
                    throw oVar2;
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i7, bArr2, 0, i6);
                int i9 = i6 + i7;
                if (bArr[i9] != 3) {
                    o oVar3 = new o("Error parsing vorbis codec private");
                    AppMethodBeat.o(92012);
                    throw oVar3;
                }
                int i10 = i8 + i9;
                if (bArr[i10] != 5) {
                    o oVar4 = new o("Error parsing vorbis codec private");
                    AppMethodBeat.o(92012);
                    throw oVar4;
                }
                byte[] bArr3 = new byte[(bArr.length - i10)];
                System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                AppMethodBeat.o(92012);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException e2) {
                o oVar5 = new o("Error parsing vorbis codec private");
                AppMethodBeat.o(92012);
                throw oVar5;
            }
        }

        static boolean j(com.google.android.exoplayer2.i.m mVar) {
            AppMethodBeat.i(92013);
            try {
                int xe = mVar.xe();
                if (xe == 1) {
                    AppMethodBeat.o(92013);
                    return true;
                } else if (xe == 65534) {
                    mVar.setPosition(24);
                    if (mVar.readLong() == d.biT.getMostSignificantBits() && mVar.readLong() == d.biT.getLeastSignificantBits()) {
                        AppMethodBeat.o(92013);
                        return true;
                    }
                    AppMethodBeat.o(92013);
                    return false;
                } else {
                    AppMethodBeat.o(92013);
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                o oVar = new o("Error parsing MS/ACM codec private");
                AppMethodBeat.o(92013);
                throw oVar;
            }
        }
    }
}
