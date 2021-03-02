package com.google.android.exoplayer2.source.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.b;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f.c;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.b.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class f extends d {
    private static final AtomicInteger bxS = new AtomicInteger();
    private final u bnh;
    private final boolean bou;
    private volatile boolean bwg;
    private e bwk;
    private final List<Format> bxB;
    public final int bxT;
    public final a.C0114a bxU;
    private final g bxV;
    private final j bxW;
    private final boolean bxX;
    private final String bxY;
    private final e bxZ;
    private final boolean bya;
    private final boolean byb;
    private final boolean byc;
    private final com.google.android.exoplayer2.metadata.id3.a byd;
    private final m bye;
    private int byf;
    private int byg;
    private boolean byh;
    private j byi;
    volatile boolean byj;
    public final int uid;

    static {
        AppMethodBeat.i(62833);
        AppMethodBeat.o(62833);
    }

    public final void a(j jVar) {
        this.byi = jVar;
        int i2 = this.uid;
        boolean z = this.bya;
        jVar.byC = i2;
        for (com.google.android.exoplayer2.source.m mVar : jVar.bvQ) {
            mVar.bwO.bwM = i2;
        }
        if (z) {
            for (com.google.android.exoplayer2.source.m mVar2 : jVar.bvQ) {
                mVar2.bwX = true;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.a
    public final long vN() {
        return (long) this.byg;
    }

    @Override // com.google.android.exoplayer2.h.t.c
    public final void vA() {
        this.bwg = true;
    }

    @Override // com.google.android.exoplayer2.h.t.c
    public final boolean vB() {
        return this.bwg;
    }

    @Override // com.google.android.exoplayer2.h.t.c
    public final void vC() {
        j al;
        boolean z;
        long j2;
        e aVar;
        Metadata d2;
        boolean z2;
        e eVar;
        String str;
        String str2 = null;
        int i2 = 0;
        AppMethodBeat.i(62832);
        if (this.bwk == null && !this.byc) {
            if (ITPPlayer.TP_MIMETYPE_TEXT_VTT.equals(this.bxU.bdF.bdq) || this.bxY.endsWith(".webvtt") || this.bxY.endsWith(".vtt")) {
                eVar = new l(this.bxk.language, this.bnh);
                z2 = true;
            } else if (!this.byb) {
                eVar = this.bxZ;
                z2 = false;
            } else if (this.bxY.endsWith(".mp4") || this.bxY.startsWith(".m4", this.bxY.length() - 4)) {
                eVar = new com.google.android.exoplayer2.c.d.e(0, this.bnh);
                z2 = true;
            } else {
                int i3 = 16;
                List<Format> list = this.bxB;
                if (list != null) {
                    i3 = 48;
                } else {
                    list = Collections.emptyList();
                }
                String str3 = this.bxk.bdn;
                if (!TextUtils.isEmpty(str3)) {
                    if (str3 != null) {
                        String[] split = str3.split(",");
                        int length = split.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                str = com.google.android.exoplayer2.i.j.bA(split[i4]);
                                if (str != null && com.google.android.exoplayer2.i.j.bx(str)) {
                                    break;
                                }
                                i4++;
                            } else {
                                break;
                            }
                        }
                    }
                    str = null;
                    if (!EncoderWriter.OUTPUT_AUDIO_MIME_TYPE.equals(str)) {
                        i3 |= 2;
                    }
                    if (str3 != null) {
                        String[] split2 = str3.split(",");
                        int length2 = split2.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 < length2) {
                                String bA = com.google.android.exoplayer2.i.j.bA(split2[i5]);
                                if (bA != null && com.google.android.exoplayer2.i.j.by(bA)) {
                                    str2 = bA;
                                    break;
                                }
                                i5++;
                            } else {
                                break;
                            }
                        }
                    }
                    if (!"video/avc".equals(str2)) {
                        i3 |= 4;
                    }
                }
                eVar = new com.google.android.exoplayer2.c.f.u(2, this.bnh, new com.google.android.exoplayer2.c.f.e(i3, list));
                z2 = true;
            }
            if (z2) {
                eVar.a(this.byi);
            }
            this.bwk = eVar;
        }
        if (!(this.bxZ == this.bwk || this.byh || this.bxW == null)) {
            j al2 = this.bxW.al((long) this.byf);
            try {
                b bVar = new b(this.bxV, al2.bEP, this.bxV.a(al2));
                int i6 = 0;
                while (i6 == 0) {
                    try {
                        if (this.bwg) {
                            break;
                        }
                        i6 = this.bwk.a(bVar, null);
                    } catch (Throwable th) {
                        this.byf = (int) (bVar.getPosition() - this.bxW.bEP);
                        AppMethodBeat.o(62832);
                        throw th;
                    }
                }
                this.byf = (int) (bVar.getPosition() - this.bxW.bEP);
                x.a(this.bhK);
                this.byh = true;
            } catch (Throwable th2) {
                x.a(this.bhK);
                AppMethodBeat.o(62832);
                throw th2;
            }
        }
        if (!this.bwg) {
            if (this.bou) {
                al = this.bxj;
                z = this.byg != 0;
            } else {
                al = this.bxj.al((long) this.byg);
                z = false;
            }
            if (!this.bxX) {
                this.bnh.xt();
            } else if (this.bnh.bqk == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                this.bnh.an(this.bxn);
            }
            try {
                b bVar2 = new b(this.bhK, al.bEP, this.bhK.a(al));
                if (this.bwk == null) {
                    bVar2.uv();
                    if (bVar2.b(this.bye.data, 0, 10, true)) {
                        this.bye.reset(10);
                        if (this.bye.xf() == com.google.android.exoplayer2.metadata.id3.a.bqj) {
                            this.bye.eZ(3);
                            int xj = this.bye.xj();
                            int i7 = xj + 10;
                            if (i7 > this.bye.capacity()) {
                                byte[] bArr = this.bye.data;
                                this.bye.reset(i7);
                                System.arraycopy(bArr, 0, this.bye.data, 0, 10);
                            }
                            if (bVar2.b(this.bye.data, 10, xj, true) && (d2 = this.byd.d(this.bye.data, xj)) != null) {
                                int length3 = d2.btX.length;
                                int i8 = 0;
                                while (true) {
                                    if (i8 >= length3) {
                                        break;
                                    }
                                    Metadata.Entry entry = d2.btX[i8];
                                    if (entry instanceof PrivFrame) {
                                        PrivFrame privFrame = (PrivFrame) entry;
                                        if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.buA)) {
                                            System.arraycopy(privFrame.buB, 0, this.bye.data, 0, 8);
                                            this.bye.reset(8);
                                            j2 = this.bye.readLong();
                                            break;
                                        }
                                    }
                                    i8++;
                                }
                            }
                        }
                    }
                    j2 = -9223372036854775807L;
                    long ao = j2 != -9223372036854775807L ? this.bnh.ao(j2) : this.bxn;
                    if (this.bxY.endsWith(".aac")) {
                        aVar = new c(ao);
                    } else if (this.bxY.endsWith(".ac3") || this.bxY.endsWith(".ec3")) {
                        aVar = new com.google.android.exoplayer2.c.f.a(ao);
                    } else if (this.bxY.endsWith(".mp3")) {
                        aVar = new com.google.android.exoplayer2.c.c.b(0, ao);
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown extension for audio file: " + this.bxY);
                        AppMethodBeat.o(62832);
                        throw illegalArgumentException;
                    }
                    aVar.a(this.byi);
                    this.bwk = aVar;
                }
                if (z) {
                    bVar2.dP(this.byg);
                }
                while (i2 == 0) {
                    try {
                        if (this.bwg) {
                            break;
                        }
                        i2 = this.bwk.a(bVar2, null);
                    } catch (Throwable th3) {
                        this.byg = (int) (bVar2.getPosition() - this.bxj.bEP);
                        AppMethodBeat.o(62832);
                        throw th3;
                    }
                }
                this.byg = (int) (bVar2.getPosition() - this.bxj.bEP);
                x.a(this.bhK);
                this.byj = true;
            } catch (Throwable th4) {
                x.a(this.bhK);
                AppMethodBeat.o(62832);
                throw th4;
            }
        }
        AppMethodBeat.o(62832);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.google.android.exoplayer2.h.g r15, com.google.android.exoplayer2.h.j r16, com.google.android.exoplayer2.h.j r17, com.google.android.exoplayer2.source.b.a.a.C0114a r18, java.util.List<com.google.android.exoplayer2.Format> r19, int r20, java.lang.Object r21, long r22, long r24, int r26, int r27, boolean r28, com.google.android.exoplayer2.i.u r29, com.google.android.exoplayer2.source.b.f r30, byte[] r31, byte[] r32) {
        /*
        // Method dump skipped, instructions count: 236
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.f.<init>(com.google.android.exoplayer2.h.g, com.google.android.exoplayer2.h.j, com.google.android.exoplayer2.h.j, com.google.android.exoplayer2.source.b.a.a$a, java.util.List, int, java.lang.Object, long, long, int, int, boolean, com.google.android.exoplayer2.i.u, com.google.android.exoplayer2.source.b.f, byte[], byte[]):void");
    }
}
