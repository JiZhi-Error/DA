package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d.a;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class e implements com.google.android.exoplayer2.c.e {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.d.e.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final com.google.android.exoplayer2.c.e[] ux() {
            AppMethodBeat.i(92075);
            com.google.android.exoplayer2.c.e[] eVarArr = {new e()};
            AppMethodBeat.o(92075);
            return eVarArr;
        }
    };
    private static final int bmZ = x.bJ("seig");
    private static final byte[] bna = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private long bdJ;
    private final m biB;
    private g bir;
    private int bis;
    private int bjJ;
    private int bjK;
    private final j bnb;
    private final SparseArray<b> bnc;
    private final m bnd;
    private final m bne;
    private final m bnf;
    private final m bng;
    private final u bnh;
    private final m bni;
    private final byte[] bnj;
    private final Stack<a.C0101a> bnk;
    private final LinkedList<a> bnl;
    private int bnm;
    private long bnn;
    private int bno;
    private m bnp;
    private long bnq;
    private int bnr;
    private long bns;
    private b bnt;
    private boolean bnu;
    private com.google.android.exoplayer2.c.m bnv;
    private com.google.android.exoplayer2.c.m[] bnw;
    private boolean bnx;
    private final int flags;
    private int sampleSize;

    static {
        AppMethodBeat.i(92104);
        AppMethodBeat.o(92104);
    }

    public e() {
        this(0);
    }

    public e(int i2) {
        this(i2, null);
    }

    public e(int i2, u uVar) {
        this(i2, uVar, (byte) 0);
    }

    private e(int i2, u uVar, byte b2) {
        AppMethodBeat.i(196028);
        this.flags = i2 | 0;
        this.bnh = uVar;
        this.bnb = null;
        this.bni = new m(16);
        this.biB = new m(k.bGT);
        this.bnd = new m(5);
        this.bne = new m();
        this.bnf = new m(1);
        this.bng = new m();
        this.bnj = new byte[16];
        this.bnk = new Stack<>();
        this.bnl = new LinkedList<>();
        this.bnc = new SparseArray<>();
        this.bdJ = -9223372036854775807L;
        this.bns = -9223372036854775807L;
        uF();
        AppMethodBeat.o(196028);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(92081);
        boolean g2 = i.g(fVar);
        AppMethodBeat.o(92081);
        return g2;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        AppMethodBeat.i(92082);
        this.bir = gVar;
        if (this.bnb != null) {
            b bVar = new b(gVar.dV(0));
            bVar.a(this.bnb, new c(0, 0, 0, 0));
            this.bnc.put(0, bVar);
            uG();
            this.bir.uy();
        }
        AppMethodBeat.o(92082);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        AppMethodBeat.i(92083);
        int size = this.bnc.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.bnc.valueAt(i2).reset();
        }
        this.bnl.clear();
        this.bnr = 0;
        this.bnk.clear();
        uF();
        AppMethodBeat.o(92083);
    }

    /* JADX WARNING: Removed duplicated region for block: B:267:0x0066 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0501 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.c.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.c.f r26, com.google.android.exoplayer2.c.k r27) {
        /*
        // Method dump skipped, instructions count: 2096
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.d.e.a(com.google.android.exoplayer2.c.f, com.google.android.exoplayer2.c.k):int");
    }

    private void uF() {
        this.bis = 0;
        this.bno = 0;
    }

    private void O(long j2) {
        AppMethodBeat.i(92085);
        while (!this.bnk.isEmpty() && this.bnk.peek().bmy == j2) {
            c(this.bnk.pop());
        }
        uF();
        AppMethodBeat.o(92085);
    }

    private void c(a.C0101a aVar) {
        AppMethodBeat.i(92086);
        if (aVar.type == a.blk) {
            d(aVar);
            AppMethodBeat.o(92086);
        } else if (aVar.type == a.blt) {
            e(aVar);
            AppMethodBeat.o(92086);
        } else {
            if (!this.bnk.isEmpty()) {
                this.bnk.peek().a(aVar);
            }
            AppMethodBeat.o(92086);
        }
    }

    private void d(a.C0101a aVar) {
        boolean z = true;
        int i2 = 0;
        AppMethodBeat.i(92087);
        com.google.android.exoplayer2.i.a.checkState(this.bnb == null, "Unexpected moov box.");
        DrmInitData t = t(aVar.bmz);
        a.C0101a eg = aVar.eg(a.blv);
        SparseArray sparseArray = new SparseArray();
        long j2 = -9223372036854775807L;
        int size = eg.bmz.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = eg.bmz.get(i3);
            if (bVar.type == a.blh) {
                Pair<Integer, c> l = l(bVar.bmB);
                sparseArray.put(((Integer) l.first).intValue(), l.second);
            } else if (bVar.type == a.blw) {
                j2 = m(bVar.bmB);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar.bmA.size();
        for (int i4 = 0; i4 < size2; i4++) {
            a.C0101a aVar2 = aVar.bmA.get(i4);
            if (aVar2.type == a.blm) {
                j a2 = b.a(aVar2, aVar.ef(a.bll), j2, t, (this.flags & 32) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.id, a2);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.bnc.size() == 0) {
            while (i2 < size3) {
                j jVar = (j) sparseArray2.valueAt(i2);
                b bVar2 = new b(this.bir.dV(i2));
                bVar2.a(jVar, (c) sparseArray.get(jVar.id));
                this.bnc.put(jVar.id, bVar2);
                this.bdJ = Math.max(this.bdJ, jVar.bdJ);
                i2++;
            }
            uG();
            this.bir.uy();
            AppMethodBeat.o(92087);
            return;
        }
        if (this.bnc.size() != size3) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        while (i2 < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i2);
            this.bnc.get(jVar2.id).a(jVar2, (c) sparseArray.get(jVar2.id));
            i2++;
        }
        AppMethodBeat.o(92087);
    }

    private void e(a.C0101a aVar) {
        AppMethodBeat.i(92088);
        a(aVar, this.bnc, this.flags, this.bnj);
        DrmInitData t = t(aVar.bmz);
        if (t != null) {
            int size = this.bnc.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.bnc.valueAt(i2).b(t);
            }
        }
        AppMethodBeat.o(92088);
    }

    private void uG() {
        AppMethodBeat.i(92089);
        if ((this.flags & 4) != 0 && this.bnv == null) {
            this.bnv = this.bir.dV(this.bnc.size());
            this.bnv.f(Format.d("application/x-emsg", MAlarmHandler.NEXT_FIRE_INTERVAL));
        }
        if ((this.flags & 8) != 0 && this.bnw == null) {
            com.google.android.exoplayer2.c.m dV = this.bir.dV(this.bnc.size() + 1);
            dV.f(Format.bc("application/cea-608"));
            this.bnw = new com.google.android.exoplayer2.c.m[]{dV};
        }
        AppMethodBeat.o(92089);
    }

    private static Pair<Integer, c> l(m mVar) {
        AppMethodBeat.i(92090);
        mVar.setPosition(12);
        Pair<Integer, c> create = Pair.create(Integer.valueOf(mVar.readInt()), new c(mVar.xk() - 1, mVar.xk(), mVar.xk(), mVar.readInt()));
        AppMethodBeat.o(92090);
        return create;
    }

    private static long m(m mVar) {
        AppMethodBeat.i(92091);
        mVar.setPosition(8);
        if (a.ec(mVar.readInt()) == 0) {
            long dE = mVar.dE();
            AppMethodBeat.o(92091);
            return dE;
        }
        long xm = mVar.xm();
        AppMethodBeat.o(92091);
        return xm;
    }

    private static void a(a.C0101a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) {
        AppMethodBeat.i(92092);
        int size = aVar.bmA.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.C0101a aVar2 = aVar.bmA.get(i3);
            if (aVar2.type == a.blu) {
                b(aVar2, sparseArray, i2, bArr);
            }
        }
        AppMethodBeat.o(92092);
    }

    private static void b(a.C0101a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) {
        AppMethodBeat.i(92093);
        b a2 = a(aVar.ef(a.blg).bmB, sparseArray, i2);
        if (a2 == null) {
            AppMethodBeat.o(92093);
            return;
        }
        l lVar = a2.bnz;
        long j2 = lVar.boP;
        a2.reset();
        if (aVar.ef(a.blf) != null && (i2 & 2) == 0) {
            j2 = n(aVar.ef(a.blf).bmB);
        }
        a(aVar, a2, j2, i2);
        k ei = a2.bnA.ei(lVar.boy.bmV);
        a.b ef = aVar.ef(a.blL);
        if (ef != null) {
            a(ei, ef.bmB, lVar);
        }
        a.b ef2 = aVar.ef(a.blM);
        if (ef2 != null) {
            a(ef2.bmB, lVar);
        }
        a.b ef3 = aVar.ef(a.blQ);
        if (ef3 != null) {
            a(ef3.bmB, 0, lVar);
        }
        a.b ef4 = aVar.ef(a.blN);
        a.b ef5 = aVar.ef(a.blO);
        if (!(ef4 == null || ef5 == null)) {
            a(ef4.bmB, ef5.bmB, ei != null ? ei.bov : null, lVar);
        }
        int size = aVar.bmz.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = aVar.bmz.get(i3);
            if (bVar.type == a.blP) {
                a(bVar.bmB, lVar, bArr);
            }
        }
        AppMethodBeat.o(92093);
    }

    private static void a(a.C0101a aVar, b bVar, long j2, int i2) {
        int i3;
        AppMethodBeat.i(92094);
        int i4 = 0;
        int i5 = 0;
        List<a.b> list = aVar.bmz;
        int size = list.size();
        int i6 = 0;
        while (i6 < size) {
            a.b bVar2 = list.get(i6);
            if (bVar2.type == a.bli) {
                m mVar = bVar2.bmB;
                mVar.setPosition(12);
                int xk = mVar.xk();
                if (xk > 0) {
                    i3 = xk + i5;
                    i4++;
                    i6++;
                    i5 = i3;
                }
            }
            i3 = i5;
            i6++;
            i5 = i3;
        }
        bVar.bnE = 0;
        bVar.bnD = 0;
        bVar.bnC = 0;
        bVar.bnz.bd(i4, i5);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar3 = list.get(i9);
            if (bVar3.type == a.bli) {
                i8 = a(bVar, i7, j2, i2, bVar3.bmB, i8);
                i7++;
            }
        }
        AppMethodBeat.o(92094);
    }

    private static void a(k kVar, m mVar, l lVar) {
        int i2;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(92095);
        int i3 = kVar.bow;
        mVar.setPosition(8);
        if ((a.ed(mVar.readInt()) & 1) == 1) {
            mVar.eZ(8);
        }
        int readUnsignedByte = mVar.readUnsignedByte();
        int xk = mVar.xk();
        if (xk != lVar.sampleCount) {
            o oVar = new o("Length mismatch: " + xk + ", " + lVar.sampleCount);
            AppMethodBeat.o(92095);
            throw oVar;
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = lVar.boK;
            i2 = 0;
            int i4 = 0;
            while (i4 < xk) {
                int readUnsignedByte2 = mVar.readUnsignedByte();
                int i5 = i2 + readUnsignedByte2;
                if (readUnsignedByte2 > i3) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[i4] = z;
                i4++;
                i2 = i5;
            }
        } else {
            if (readUnsignedByte <= i3) {
                z2 = false;
            }
            i2 = (readUnsignedByte * xk) + 0;
            Arrays.fill(lVar.boK, 0, xk, z2);
        }
        lVar.ej(i2);
        AppMethodBeat.o(92095);
    }

    private static void a(m mVar, l lVar) {
        AppMethodBeat.i(92096);
        mVar.setPosition(8);
        int readInt = mVar.readInt();
        if ((a.ed(readInt) & 1) == 1) {
            mVar.eZ(8);
        }
        int xk = mVar.xk();
        if (xk != 1) {
            o oVar = new o("Unexpected saio entry count: ".concat(String.valueOf(xk)));
            AppMethodBeat.o(92096);
            throw oVar;
        }
        int ec = a.ec(readInt);
        lVar.boB = (ec == 0 ? mVar.dE() : mVar.xm()) + lVar.boB;
        AppMethodBeat.o(92096);
    }

    private static b a(m mVar, SparseArray<b> sparseArray, int i2) {
        AppMethodBeat.i(92097);
        mVar.setPosition(8);
        int ed = a.ed(mVar.readInt());
        int readInt = mVar.readInt();
        if ((i2 & 16) != 0) {
            readInt = 0;
        }
        b bVar = sparseArray.get(readInt);
        if (bVar == null) {
            AppMethodBeat.o(92097);
            return null;
        }
        if ((ed & 1) != 0) {
            long xm = mVar.xm();
            bVar.bnz.boA = xm;
            bVar.bnz.boB = xm;
        }
        c cVar = bVar.bnB;
        bVar.bnz.boy = new c((ed & 2) != 0 ? mVar.xk() - 1 : cVar.bmV, (ed & 8) != 0 ? mVar.xk() : cVar.duration, (ed & 16) != 0 ? mVar.xk() : cVar.size, (ed & 32) != 0 ? mVar.xk() : cVar.flags);
        AppMethodBeat.o(92097);
        return bVar;
    }

    private static long n(m mVar) {
        AppMethodBeat.i(92098);
        mVar.setPosition(8);
        if (a.ec(mVar.readInt()) == 1) {
            long xm = mVar.xm();
            AppMethodBeat.o(92098);
            return xm;
        }
        long dE = mVar.dE();
        AppMethodBeat.o(92098);
        return dE;
    }

    private static int a(b bVar, int i2, long j2, int i3, m mVar, int i4) {
        boolean z;
        long j3;
        int readInt;
        AppMethodBeat.i(92099);
        mVar.setPosition(8);
        int ed = a.ed(mVar.readInt());
        j jVar = bVar.bnA;
        l lVar = bVar.bnz;
        c cVar = lVar.boy;
        lVar.boE[i2] = mVar.xk();
        lVar.boD[i2] = lVar.boA;
        if ((ed & 1) != 0) {
            long[] jArr = lVar.boD;
            jArr[i2] = jArr[i2] + ((long) mVar.readInt());
        }
        boolean z2 = (ed & 4) != 0;
        int i5 = cVar.flags;
        if (z2) {
            i5 = mVar.xk();
        }
        boolean z3 = (ed & 256) != 0;
        boolean z4 = (ed & 512) != 0;
        boolean z5 = (ed & 1024) != 0;
        if ((ed & 2048) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (jVar.bor != null && jVar.bor.length == 1 && jVar.bor[0] == 0) {
            j3 = x.b(jVar.bos[0], 1000, jVar.boo);
        } else {
            j3 = 0;
        }
        int[] iArr = lVar.boF;
        int[] iArr2 = lVar.boG;
        long[] jArr2 = lVar.boH;
        boolean[] zArr = lVar.boI;
        boolean z6 = jVar.type == 2 && (i3 & 1) != 0;
        int i6 = i4 + lVar.boE[i2];
        long j4 = jVar.boo;
        if (i2 > 0) {
            j2 = lVar.boP;
        }
        long j5 = j2;
        while (i4 < i6) {
            int xk = z3 ? mVar.xk() : cVar.duration;
            int xk2 = z4 ? mVar.xk() : cVar.size;
            if (i4 != 0 || !z2) {
                readInt = z5 ? mVar.readInt() : cVar.flags;
            } else {
                readInt = i5;
            }
            if (z) {
                iArr2[i4] = (int) ((((long) mVar.readInt()) * 1000) / j4);
            } else {
                iArr2[i4] = 0;
            }
            jArr2[i4] = x.b(j5, 1000, j4) - j3;
            iArr[i4] = xk2;
            zArr[i4] = ((readInt >> 16) & 1) == 0 && (!z6 || i4 == 0);
            j5 += (long) xk;
            i4++;
        }
        lVar.boP = j5;
        AppMethodBeat.o(92099);
        return i6;
    }

    private static void a(m mVar, l lVar, byte[] bArr) {
        AppMethodBeat.i(92100);
        mVar.setPosition(8);
        mVar.readBytes(bArr, 0, 16);
        if (!Arrays.equals(bArr, bna)) {
            AppMethodBeat.o(92100);
            return;
        }
        a(mVar, 16, lVar);
        AppMethodBeat.o(92100);
    }

    private static void a(m mVar, int i2, l lVar) {
        boolean z;
        AppMethodBeat.i(92101);
        mVar.setPosition(i2 + 8);
        int ed = a.ed(mVar.readInt());
        if ((ed & 1) != 0) {
            o oVar = new o("Overriding TrackEncryptionBox parameters is unsupported.");
            AppMethodBeat.o(92101);
            throw oVar;
        }
        if ((ed & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        int xk = mVar.xk();
        if (xk != lVar.sampleCount) {
            o oVar2 = new o("Length mismatch: " + xk + ", " + lVar.sampleCount);
            AppMethodBeat.o(92101);
            throw oVar2;
        }
        Arrays.fill(lVar.boK, 0, xk, z);
        lVar.ej(mVar.xd());
        lVar.q(mVar);
        AppMethodBeat.o(92101);
    }

    private static void a(m mVar, m mVar2, String str, l lVar) {
        boolean z;
        AppMethodBeat.i(92102);
        mVar.setPosition(8);
        int readInt = mVar.readInt();
        if (mVar.readInt() != bmZ) {
            AppMethodBeat.o(92102);
            return;
        }
        if (a.ec(readInt) == 1) {
            mVar.eZ(4);
        }
        if (mVar.readInt() != 1) {
            o oVar = new o("Entry count in sbgp != 1 (unsupported).");
            AppMethodBeat.o(92102);
            throw oVar;
        }
        mVar2.setPosition(8);
        int readInt2 = mVar2.readInt();
        if (mVar2.readInt() != bmZ) {
            AppMethodBeat.o(92102);
            return;
        }
        int ec = a.ec(readInt2);
        if (ec == 1) {
            if (mVar2.dE() == 0) {
                o oVar2 = new o("Variable length description in sgpd found (unsupported)");
                AppMethodBeat.o(92102);
                throw oVar2;
            }
        } else if (ec >= 2) {
            mVar2.eZ(4);
        }
        if (mVar2.dE() != 1) {
            o oVar3 = new o("Entry count in sgpd != 1 (unsupported).");
            AppMethodBeat.o(92102);
            throw oVar3;
        }
        mVar2.eZ(1);
        int readUnsignedByte = mVar2.readUnsignedByte();
        int i2 = (readUnsignedByte & 240) >> 4;
        int i3 = readUnsignedByte & 15;
        if (mVar2.readUnsignedByte() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(92102);
            return;
        }
        int readUnsignedByte2 = mVar2.readUnsignedByte();
        byte[] bArr = new byte[16];
        mVar2.readBytes(bArr, 0, 16);
        byte[] bArr2 = null;
        if (readUnsignedByte2 == 0) {
            int readUnsignedByte3 = mVar2.readUnsignedByte();
            bArr2 = new byte[readUnsignedByte3];
            mVar2.readBytes(bArr2, 0, readUnsignedByte3);
        }
        lVar.boJ = true;
        lVar.boL = new k(true, str, readUnsignedByte2, bArr, i2, i3, bArr2);
        AppMethodBeat.o(92102);
    }

    private static DrmInitData t(List<a.b> list) {
        AppMethodBeat.i(92103);
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = list.get(i2);
            if (bVar.type == a.blD) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.bmB.data;
                UUID r = h.r(bArr);
                if (r != null) {
                    arrayList.add(new DrmInitData.SchemeData(r, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            AppMethodBeat.o(92103);
            return null;
        }
        DrmInitData drmInitData = new DrmInitData(arrayList);
        AppMethodBeat.o(92103);
        return drmInitData;
    }

    static final class a {
        public final long bny;
        public final int size;

        public a(long j2, int i2) {
            this.bny = j2;
            this.size = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        public final com.google.android.exoplayer2.c.m biA;
        public j bnA;
        public c bnB;
        public int bnC;
        public int bnD;
        public int bnE;
        public final l bnz = new l();

        public b(com.google.android.exoplayer2.c.m mVar) {
            AppMethodBeat.i(92076);
            this.biA = mVar;
            AppMethodBeat.o(92076);
        }

        public final void a(j jVar, c cVar) {
            AppMethodBeat.i(92077);
            this.bnA = (j) com.google.android.exoplayer2.i.a.checkNotNull(jVar);
            this.bnB = (c) com.google.android.exoplayer2.i.a.checkNotNull(cVar);
            this.biA.f(jVar.bdF);
            reset();
            AppMethodBeat.o(92077);
        }

        public final void reset() {
            AppMethodBeat.i(92078);
            this.bnz.reset();
            this.bnC = 0;
            this.bnE = 0;
            this.bnD = 0;
            AppMethodBeat.o(92078);
        }

        public final void b(DrmInitData drmInitData) {
            AppMethodBeat.i(92079);
            k ei = this.bnA.ei(this.bnz.boy.bmV);
            this.biA.f(this.bnA.bdF.a(drmInitData.bg(ei != null ? ei.bov : null)));
            AppMethodBeat.o(92079);
        }
    }
}
