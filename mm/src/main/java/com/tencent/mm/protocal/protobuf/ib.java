package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ib extends a {
    public String Id;
    public String KLZ;
    public String KMa;
    public int KMb;
    public long KMc;
    public int KMd;
    public long KMe;
    public long KMf;
    public long KMg;
    public String KMh;
    public long KMi;
    public double KMj;
    public int KMk;
    public String KMl;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(87872);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            if (this.KLZ != null) {
                aVar.e(2, this.KLZ);
            }
            if (this.KMa != null) {
                aVar.e(3, this.KMa);
            }
            aVar.aM(4, this.KMb);
            aVar.bb(5, this.KMc);
            aVar.aM(6, this.KMd);
            aVar.aM(7, this.oTW);
            aVar.bb(8, this.KMe);
            aVar.bb(9, this.KMf);
            aVar.bb(10, this.KMg);
            if (this.KMh != null) {
                aVar.e(11, this.KMh);
            }
            aVar.bb(12, this.KMi);
            aVar.e(13, this.KMj);
            aVar.aM(14, this.KMk);
            if (this.KMl != null) {
                aVar.e(15, this.KMl);
            }
            AppMethodBeat.o(87872);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Id != null ? g.a.a.b.b.a.f(1, this.Id) + 0 : 0;
            if (this.KLZ != null) {
                f2 += g.a.a.b.b.a.f(2, this.KLZ);
            }
            if (this.KMa != null) {
                f2 += g.a.a.b.b.a.f(3, this.KMa);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.KMb) + g.a.a.b.b.a.r(5, this.KMc) + g.a.a.b.b.a.bu(6, this.KMd) + g.a.a.b.b.a.bu(7, this.oTW) + g.a.a.b.b.a.r(8, this.KMe) + g.a.a.b.b.a.r(9, this.KMf) + g.a.a.b.b.a.r(10, this.KMg);
            if (this.KMh != null) {
                bu += g.a.a.b.b.a.f(11, this.KMh);
            }
            int r = bu + g.a.a.b.b.a.r(12, this.KMi) + g.a.a.b.b.a.fS(13) + 8 + g.a.a.b.b.a.bu(14, this.KMk);
            if (this.KMl != null) {
                r += g.a.a.b.b.a.f(15, this.KMl);
            }
            AppMethodBeat.o(87872);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(87872);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ib ibVar = (ib) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ibVar.Id = aVar3.UbS.readString();
                    AppMethodBeat.o(87872);
                    return 0;
                case 2:
                    ibVar.KLZ = aVar3.UbS.readString();
                    AppMethodBeat.o(87872);
                    return 0;
                case 3:
                    ibVar.KMa = aVar3.UbS.readString();
                    AppMethodBeat.o(87872);
                    return 0;
                case 4:
                    ibVar.KMb = aVar3.UbS.zi();
                    AppMethodBeat.o(87872);
                    return 0;
                case 5:
                    ibVar.KMc = aVar3.UbS.zl();
                    AppMethodBeat.o(87872);
                    return 0;
                case 6:
                    ibVar.KMd = aVar3.UbS.zi();
                    AppMethodBeat.o(87872);
                    return 0;
                case 7:
                    ibVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(87872);
                    return 0;
                case 8:
                    ibVar.KMe = aVar3.UbS.zl();
                    AppMethodBeat.o(87872);
                    return 0;
                case 9:
                    ibVar.KMf = aVar3.UbS.zl();
                    AppMethodBeat.o(87872);
                    return 0;
                case 10:
                    ibVar.KMg = aVar3.UbS.zl();
                    AppMethodBeat.o(87872);
                    return 0;
                case 11:
                    ibVar.KMh = aVar3.UbS.readString();
                    AppMethodBeat.o(87872);
                    return 0;
                case 12:
                    ibVar.KMi = aVar3.UbS.zl();
                    AppMethodBeat.o(87872);
                    return 0;
                case 13:
                    ibVar.KMj = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(87872);
                    return 0;
                case 14:
                    ibVar.KMk = aVar3.UbS.zi();
                    AppMethodBeat.o(87872);
                    return 0;
                case 15:
                    ibVar.KMl = aVar3.UbS.readString();
                    AppMethodBeat.o(87872);
                    return 0;
                default:
                    AppMethodBeat.o(87872);
                    return -1;
            }
        } else {
            AppMethodBeat.o(87872);
            return -1;
        }
    }
}
