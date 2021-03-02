package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bhg extends a {
    public int KCD;
    public int LQY;
    public String LRh;
    public String LRi;
    public String LRj;
    public String LRk;
    public String LRl;
    public int LRm;
    public int LRn;
    public int LRo;
    public b LRp;
    public LinkedList<ccc> LRq = new LinkedList<>();
    public String Title;
    public String UserName;
    public String iAc;
    public String xJH;

    public bhg() {
        AppMethodBeat.i(223887);
        AppMethodBeat.o(223887);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152549);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LQY);
            if (this.LRh != null) {
                aVar.e(2, this.LRh);
            }
            if (this.LRi != null) {
                aVar.e(3, this.LRi);
            }
            aVar.aM(4, this.KCD);
            if (this.Title != null) {
                aVar.e(5, this.Title);
            }
            if (this.iAc != null) {
                aVar.e(6, this.iAc);
            }
            if (this.UserName != null) {
                aVar.e(7, this.UserName);
            }
            if (this.LRj != null) {
                aVar.e(8, this.LRj);
            }
            if (this.xJH != null) {
                aVar.e(10, this.xJH);
            }
            if (this.LRk != null) {
                aVar.e(11, this.LRk);
            }
            if (this.LRl != null) {
                aVar.e(12, this.LRl);
            }
            aVar.aM(13, this.LRm);
            aVar.aM(14, this.LRn);
            aVar.aM(15, this.LRo);
            if (this.LRp != null) {
                aVar.c(16, this.LRp);
            }
            aVar.e(17, 8, this.LRq);
            AppMethodBeat.o(152549);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LQY) + 0;
            if (this.LRh != null) {
                bu += g.a.a.b.b.a.f(2, this.LRh);
            }
            if (this.LRi != null) {
                bu += g.a.a.b.b.a.f(3, this.LRi);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.KCD);
            if (this.Title != null) {
                bu2 += g.a.a.b.b.a.f(5, this.Title);
            }
            if (this.iAc != null) {
                bu2 += g.a.a.b.b.a.f(6, this.iAc);
            }
            if (this.UserName != null) {
                bu2 += g.a.a.b.b.a.f(7, this.UserName);
            }
            if (this.LRj != null) {
                bu2 += g.a.a.b.b.a.f(8, this.LRj);
            }
            if (this.xJH != null) {
                bu2 += g.a.a.b.b.a.f(10, this.xJH);
            }
            if (this.LRk != null) {
                bu2 += g.a.a.b.b.a.f(11, this.LRk);
            }
            if (this.LRl != null) {
                bu2 += g.a.a.b.b.a.f(12, this.LRl);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.LRm) + g.a.a.b.b.a.bu(14, this.LRn) + g.a.a.b.b.a.bu(15, this.LRo);
            if (this.LRp != null) {
                bu3 += g.a.a.b.b.a.b(16, this.LRp);
            }
            int c2 = bu3 + g.a.a.a.c(17, 8, this.LRq);
            AppMethodBeat.o(152549);
            return c2;
        } else if (i2 == 2) {
            this.LRq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152549);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhg bhg = (bhg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bhg.LQY = aVar3.UbS.zi();
                    AppMethodBeat.o(152549);
                    return 0;
                case 2:
                    bhg.LRh = aVar3.UbS.readString();
                    AppMethodBeat.o(152549);
                    return 0;
                case 3:
                    bhg.LRi = aVar3.UbS.readString();
                    AppMethodBeat.o(152549);
                    return 0;
                case 4:
                    bhg.KCD = aVar3.UbS.zi();
                    AppMethodBeat.o(152549);
                    return 0;
                case 5:
                    bhg.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(152549);
                    return 0;
                case 6:
                    bhg.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(152549);
                    return 0;
                case 7:
                    bhg.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152549);
                    return 0;
                case 8:
                    bhg.LRj = aVar3.UbS.readString();
                    AppMethodBeat.o(152549);
                    return 0;
                case 9:
                default:
                    AppMethodBeat.o(152549);
                    return -1;
                case 10:
                    bhg.xJH = aVar3.UbS.readString();
                    AppMethodBeat.o(152549);
                    return 0;
                case 11:
                    bhg.LRk = aVar3.UbS.readString();
                    AppMethodBeat.o(152549);
                    return 0;
                case 12:
                    bhg.LRl = aVar3.UbS.readString();
                    AppMethodBeat.o(152549);
                    return 0;
                case 13:
                    bhg.LRm = aVar3.UbS.zi();
                    AppMethodBeat.o(152549);
                    return 0;
                case 14:
                    bhg.LRn = aVar3.UbS.zi();
                    AppMethodBeat.o(152549);
                    return 0;
                case 15:
                    bhg.LRo = aVar3.UbS.zi();
                    AppMethodBeat.o(152549);
                    return 0;
                case 16:
                    bhg.LRp = aVar3.UbS.hPo();
                    AppMethodBeat.o(152549);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccc ccc = new ccc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccc.populateBuilderWithField(aVar4, ccc, a.getNextFieldNumber(aVar4))) {
                        }
                        bhg.LRq.add(ccc);
                    }
                    AppMethodBeat.o(152549);
                    return 0;
            }
        } else {
            AppMethodBeat.o(152549);
            return -1;
        }
    }
}
