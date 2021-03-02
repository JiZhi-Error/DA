package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements e, l {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.a.b.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(91978);
            e[] eVarArr = {new b()};
            AppMethodBeat.o(91978);
            return eVarArr;
        }
    };
    private static final int bim = x.bJ("FLV");
    private final m bin = new m(4);
    private final m bio = new m(9);
    private final m bip = new m(11);
    private final m biq = new m();
    private g bir;
    private int bis = 1;
    private int bit;
    public int biu;
    public int biv;
    public long biw;
    private a bix;
    private e biy;
    private c biz;

    static {
        AppMethodBeat.i(91983);
        AppMethodBeat.o(91983);
    }

    public b() {
        AppMethodBeat.i(91979);
        AppMethodBeat.o(91979);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(91980);
        fVar.b(this.bin.data, 0, 3);
        this.bin.setPosition(0);
        if (this.bin.xf() != bim) {
            AppMethodBeat.o(91980);
            return false;
        }
        fVar.b(this.bin.data, 0, 2);
        this.bin.setPosition(0);
        if ((this.bin.readUnsignedShort() & 250) != 0) {
            AppMethodBeat.o(91980);
            return false;
        }
        fVar.b(this.bin.data, 0, 4);
        this.bin.setPosition(0);
        int readInt = this.bin.readInt();
        fVar.uv();
        fVar.dQ(readInt);
        fVar.b(this.bin.data, 0, 4);
        this.bin.setPosition(0);
        if (this.bin.readInt() == 0) {
            AppMethodBeat.o(91980);
            return true;
        }
        AppMethodBeat.o(91980);
        return false;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        this.bir = gVar;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        this.bis = 1;
        this.bit = 0;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final int a(f fVar, k kVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(91981);
        while (true) {
            switch (this.bis) {
                case 1:
                    if (!fVar.a(this.bio.data, 0, 9, true)) {
                        z4 = false;
                    } else {
                        this.bio.setPosition(0);
                        this.bio.eZ(4);
                        int readUnsignedByte = this.bio.readUnsignedByte();
                        boolean z5 = (readUnsignedByte & 4) != 0;
                        if ((readUnsignedByte & 1) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z5 && this.bix == null) {
                            this.bix = new a(this.bir.dV(8));
                        }
                        if (z3 && this.biy == null) {
                            this.biy = new e(this.bir.dV(9));
                        }
                        if (this.biz == null) {
                            this.biz = new c();
                        }
                        this.bir.uy();
                        this.bir.a(this);
                        this.bit = (this.bio.readInt() - 9) + 4;
                        this.bis = 2;
                        z4 = true;
                    }
                    if (z4) {
                        break;
                    } else {
                        AppMethodBeat.o(91981);
                        return -1;
                    }
                case 2:
                    fVar.dP(this.bit);
                    this.bit = 0;
                    this.bis = 3;
                    break;
                case 3:
                    if (!fVar.a(this.bip.data, 0, 11, true)) {
                        z2 = false;
                    } else {
                        this.bip.setPosition(0);
                        this.biu = this.bip.readUnsignedByte();
                        this.biv = this.bip.xf();
                        this.biw = (long) this.bip.xf();
                        this.biw = (((long) (this.bip.readUnsignedByte() << 24)) | this.biw) * 1000;
                        this.bip.eZ(3);
                        this.bis = 4;
                        z2 = true;
                    }
                    if (z2) {
                        break;
                    } else {
                        AppMethodBeat.o(91981);
                        return -1;
                    }
                case 4:
                    if (this.biu == 8 && this.bix != null) {
                        this.bix.b(b(fVar), this.biw);
                        z = true;
                    } else if (this.biu == 9 && this.biy != null) {
                        this.biy.b(b(fVar), this.biw);
                        z = true;
                    } else if (this.biu != 18 || this.biz == null) {
                        fVar.dP(this.biv);
                        z = false;
                    } else {
                        this.biz.b(b(fVar), this.biw);
                        z = true;
                    }
                    this.bit = 4;
                    this.bis = 2;
                    if (!z) {
                        break;
                    } else {
                        AppMethodBeat.o(91981);
                        return 0;
                    }
                    break;
            }
        }
    }

    private m b(f fVar) {
        AppMethodBeat.i(91982);
        if (this.biv > this.biq.capacity()) {
            this.biq.n(new byte[Math.max(this.biq.capacity() * 2, this.biv)], 0);
        } else {
            this.biq.setPosition(0);
        }
        this.biq.eY(this.biv);
        fVar.readFully(this.biq.data, 0, this.biv);
        m mVar = this.biq;
        AppMethodBeat.o(91982);
        return mVar;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final boolean uu() {
        return false;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long getDurationUs() {
        return this.biz.bdJ;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long L(long j2) {
        return 0;
    }
}
