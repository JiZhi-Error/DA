package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class t extends a {
    public String AOj;
    public String HEn;
    public String HEo;
    public String HEp;
    public int HFi;
    public int HFj;
    public long HFk;
    public String HFl;
    public String HFm;
    public String HFn;
    public double HFo;
    public double HFp;
    public int HFq;
    public String HFr;
    public String HFs;
    public LinkedList<b> HFt = new LinkedList<>();

    public t() {
        AppMethodBeat.i(91304);
        AppMethodBeat.o(91304);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91305);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.HFi);
            aVar.aM(2, this.HFj);
            aVar.bb(3, this.HFk);
            if (this.HFl != null) {
                aVar.e(4, this.HFl);
            }
            if (this.HEn != null) {
                aVar.e(5, this.HEn);
            }
            if (this.HFm != null) {
                aVar.e(6, this.HFm);
            }
            if (this.HFn != null) {
                aVar.e(7, this.HFn);
            }
            if (this.HEo != null) {
                aVar.e(8, this.HEo);
            }
            if (this.HEp != null) {
                aVar.e(9, this.HEp);
            }
            aVar.e(10, this.HFo);
            aVar.e(11, this.HFp);
            aVar.aM(12, this.HFq);
            if (this.HFr != null) {
                aVar.e(13, this.HFr);
            }
            if (this.AOj != null) {
                aVar.e(14, this.AOj);
            }
            if (this.HFs != null) {
                aVar.e(16, this.HFs);
            }
            aVar.e(17, 6, this.HFt);
            AppMethodBeat.o(91305);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.HFi) + 0 + g.a.a.b.b.a.bu(2, this.HFj) + g.a.a.b.b.a.r(3, this.HFk);
            if (this.HFl != null) {
                bu += g.a.a.b.b.a.f(4, this.HFl);
            }
            if (this.HEn != null) {
                bu += g.a.a.b.b.a.f(5, this.HEn);
            }
            if (this.HFm != null) {
                bu += g.a.a.b.b.a.f(6, this.HFm);
            }
            if (this.HFn != null) {
                bu += g.a.a.b.b.a.f(7, this.HFn);
            }
            if (this.HEo != null) {
                bu += g.a.a.b.b.a.f(8, this.HEo);
            }
            if (this.HEp != null) {
                bu += g.a.a.b.b.a.f(9, this.HEp);
            }
            int fS = bu + g.a.a.b.b.a.fS(10) + 8 + g.a.a.b.b.a.fS(11) + 8 + g.a.a.b.b.a.bu(12, this.HFq);
            if (this.HFr != null) {
                fS += g.a.a.b.b.a.f(13, this.HFr);
            }
            if (this.AOj != null) {
                fS += g.a.a.b.b.a.f(14, this.AOj);
            }
            if (this.HFs != null) {
                fS += g.a.a.b.b.a.f(16, this.HFs);
            }
            int c2 = fS + g.a.a.a.c(17, 6, this.HFt);
            AppMethodBeat.o(91305);
            return c2;
        } else if (i2 == 2) {
            this.HFt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91305);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.HFi = aVar3.UbS.zi();
                    AppMethodBeat.o(91305);
                    return 0;
                case 2:
                    tVar.HFj = aVar3.UbS.zi();
                    AppMethodBeat.o(91305);
                    return 0;
                case 3:
                    tVar.HFk = aVar3.UbS.zl();
                    AppMethodBeat.o(91305);
                    return 0;
                case 4:
                    tVar.HFl = aVar3.UbS.readString();
                    AppMethodBeat.o(91305);
                    return 0;
                case 5:
                    tVar.HEn = aVar3.UbS.readString();
                    AppMethodBeat.o(91305);
                    return 0;
                case 6:
                    tVar.HFm = aVar3.UbS.readString();
                    AppMethodBeat.o(91305);
                    return 0;
                case 7:
                    tVar.HFn = aVar3.UbS.readString();
                    AppMethodBeat.o(91305);
                    return 0;
                case 8:
                    tVar.HEo = aVar3.UbS.readString();
                    AppMethodBeat.o(91305);
                    return 0;
                case 9:
                    tVar.HEp = aVar3.UbS.readString();
                    AppMethodBeat.o(91305);
                    return 0;
                case 10:
                    tVar.HFo = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91305);
                    return 0;
                case 11:
                    tVar.HFp = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91305);
                    return 0;
                case 12:
                    tVar.HFq = aVar3.UbS.zi();
                    AppMethodBeat.o(91305);
                    return 0;
                case 13:
                    tVar.HFr = aVar3.UbS.readString();
                    AppMethodBeat.o(91305);
                    return 0;
                case 14:
                    tVar.AOj = aVar3.UbS.readString();
                    AppMethodBeat.o(91305);
                    return 0;
                case 15:
                default:
                    AppMethodBeat.o(91305);
                    return -1;
                case 16:
                    tVar.HFs = aVar3.UbS.readString();
                    AppMethodBeat.o(91305);
                    return 0;
                case 17:
                    tVar.HFt.add(aVar3.UbS.hPo());
                    AppMethodBeat.o(91305);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91305);
            return -1;
        }
    }
}
