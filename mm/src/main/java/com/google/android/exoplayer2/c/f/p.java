package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;

public final class p implements e {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.f.p.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(92270);
            e[] eVarArr = {new p()};
            AppMethodBeat.o(92270);
            return eVarArr;
        }
    };
    private final u bnh;
    private g bph;
    private final SparseArray<a> bsg;
    private final m bsh;
    private boolean bsi;
    private boolean bsj;
    private boolean bsk;

    static {
        AppMethodBeat.i(92278);
        AppMethodBeat.o(92278);
    }

    public p() {
        this(new u(0));
        AppMethodBeat.i(92272);
        AppMethodBeat.o(92272);
    }

    private p(u uVar) {
        AppMethodBeat.i(92273);
        this.bnh = uVar;
        this.bsh = new m(4096);
        this.bsg = new SparseArray<>();
        AppMethodBeat.o(92273);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(92274);
        byte[] bArr = new byte[14];
        fVar.b(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255))) {
            AppMethodBeat.o(92274);
            return false;
        } else if ((bArr[4] & 196) != 68) {
            AppMethodBeat.o(92274);
            return false;
        } else if ((bArr[6] & 4) != 4) {
            AppMethodBeat.o(92274);
            return false;
        } else if ((bArr[8] & 4) != 4) {
            AppMethodBeat.o(92274);
            return false;
        } else if ((bArr[9] & 1) != 1) {
            AppMethodBeat.o(92274);
            return false;
        } else if ((bArr[12] & 3) != 3) {
            AppMethodBeat.o(92274);
            return false;
        } else {
            fVar.dQ(bArr[13] & 7);
            fVar.b(bArr, 0, 3);
            if (1 == ((bArr[2] & 255) | ((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8))) {
                AppMethodBeat.o(92274);
                return true;
            }
            AppMethodBeat.o(92274);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        AppMethodBeat.i(92275);
        this.bph = gVar;
        gVar.a(new l.a(-9223372036854775807L));
        AppMethodBeat.o(92275);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        AppMethodBeat.i(92276);
        this.bnh.bHG = -9223372036854775807L;
        for (int i2 = 0; i2 < this.bsg.size(); i2++) {
            a valueAt = this.bsg.valueAt(i2);
            valueAt.bsc = false;
            valueAt.bsl.uK();
        }
        AppMethodBeat.o(92276);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(92277);
        if (!fVar.b(this.bsh.data, 0, 4, true)) {
            AppMethodBeat.o(92277);
            return -1;
        }
        this.bsh.setPosition(0);
        int readInt = this.bsh.readInt();
        if (readInt == 441) {
            AppMethodBeat.o(92277);
            return -1;
        } else if (readInt == 442) {
            fVar.b(this.bsh.data, 0, 10);
            this.bsh.setPosition(9);
            fVar.dP((this.bsh.readUnsignedByte() & 7) + 14);
            AppMethodBeat.o(92277);
            return 0;
        } else if (readInt == 443) {
            fVar.b(this.bsh.data, 0, 2);
            this.bsh.setPosition(0);
            fVar.dP(this.bsh.readUnsignedShort() + 6);
            AppMethodBeat.o(92277);
            return 0;
        } else if (((readInt & -256) >> 8) != 1) {
            fVar.dP(1);
            AppMethodBeat.o(92277);
            return 0;
        } else {
            int i2 = readInt & 255;
            a aVar = this.bsg.get(i2);
            if (!this.bsi) {
                if (aVar == null) {
                    h hVar = null;
                    if (!this.bsj && i2 == 189) {
                        hVar = new b();
                        this.bsj = true;
                    } else if (!this.bsj && (i2 & TbsListener.ErrorCode.EXCEED_INCR_UPDATE) == 192) {
                        hVar = new m();
                        this.bsj = true;
                    } else if (!this.bsk && (i2 & 240) == 224) {
                        hVar = new i();
                        this.bsk = true;
                    }
                    if (hVar != null) {
                        hVar.a(this.bph, new v.d(i2, 256));
                        aVar = new a(hVar, this.bnh);
                        this.bsg.put(i2, aVar);
                    }
                }
                if ((this.bsj && this.bsk) || fVar.getPosition() > 1048576) {
                    this.bsi = true;
                    this.bph.uy();
                }
            }
            fVar.b(this.bsh.data, 0, 2);
            this.bsh.setPosition(0);
            int readUnsignedShort = this.bsh.readUnsignedShort() + 6;
            if (aVar == null) {
                fVar.dP(readUnsignedShort);
            } else {
                this.bsh.reset(readUnsignedShort);
                fVar.readFully(this.bsh.data, 0, readUnsignedShort);
                this.bsh.setPosition(6);
                m mVar = this.bsh;
                mVar.readBytes(aVar.brZ.data, 0, 3);
                aVar.brZ.setPosition(0);
                aVar.brZ.en(8);
                aVar.bsa = aVar.brZ.uI();
                aVar.bsb = aVar.brZ.uI();
                aVar.brZ.en(6);
                aVar.bsd = aVar.brZ.em(8);
                mVar.readBytes(aVar.brZ.data, 0, aVar.bsd);
                aVar.brZ.setPosition(0);
                aVar.timeUs = 0;
                if (aVar.bsa) {
                    aVar.brZ.en(4);
                    aVar.brZ.en(1);
                    aVar.brZ.en(1);
                    long em = (((long) aVar.brZ.em(3)) << 30) | ((long) (aVar.brZ.em(15) << 15)) | ((long) aVar.brZ.em(15));
                    aVar.brZ.en(1);
                    if (!aVar.bsc && aVar.bsb) {
                        aVar.brZ.en(4);
                        aVar.brZ.en(1);
                        aVar.brZ.en(1);
                        aVar.brZ.en(1);
                        aVar.bnh.ao((((long) aVar.brZ.em(3)) << 30) | ((long) (aVar.brZ.em(15) << 15)) | ((long) aVar.brZ.em(15)));
                        aVar.bsc = true;
                    }
                    aVar.timeUs = aVar.bnh.ao(em);
                }
                aVar.bsl.c(aVar.timeUs, true);
                aVar.bsl.t(mVar);
                aVar.bsl.uL();
                this.bsh.eY(this.bsh.capacity());
            }
            AppMethodBeat.o(92277);
            return 0;
        }
    }

    static final class a {
        final u bnh;
        final com.google.android.exoplayer2.i.l brZ = new com.google.android.exoplayer2.i.l(new byte[64]);
        boolean bsa;
        boolean bsb;
        boolean bsc;
        int bsd;
        final h bsl;
        long timeUs;

        public a(h hVar, u uVar) {
            AppMethodBeat.i(92271);
            this.bsl = hVar;
            this.bnh = uVar;
            AppMethodBeat.o(92271);
        }
    }
}
