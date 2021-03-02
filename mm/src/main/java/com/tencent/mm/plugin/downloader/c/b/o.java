package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class o extends a {
    public String gqB;
    public int qHm;
    public String qHn;
    public String qHo;
    public String qHp;
    public String qHq;
    public int qHr;
    public String qHs;
    public String qHt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153075);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.qHm);
            if (this.gqB != null) {
                aVar.e(2, this.gqB);
            }
            if (this.qHn != null) {
                aVar.e(3, this.qHn);
            }
            if (this.qHo != null) {
                aVar.e(4, this.qHo);
            }
            if (this.qHp != null) {
                aVar.e(5, this.qHp);
            }
            if (this.qHq != null) {
                aVar.e(6, this.qHq);
            }
            aVar.aM(7, this.qHr);
            if (this.qHs != null) {
                aVar.e(8, this.qHs);
            }
            if (this.qHt != null) {
                aVar.e(9, this.qHt);
            }
            AppMethodBeat.o(153075);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.qHm) + 0;
            if (this.gqB != null) {
                bu += g.a.a.b.b.a.f(2, this.gqB);
            }
            if (this.qHn != null) {
                bu += g.a.a.b.b.a.f(3, this.qHn);
            }
            if (this.qHo != null) {
                bu += g.a.a.b.b.a.f(4, this.qHo);
            }
            if (this.qHp != null) {
                bu += g.a.a.b.b.a.f(5, this.qHp);
            }
            if (this.qHq != null) {
                bu += g.a.a.b.b.a.f(6, this.qHq);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.qHr);
            if (this.qHs != null) {
                bu2 += g.a.a.b.b.a.f(8, this.qHs);
            }
            if (this.qHt != null) {
                bu2 += g.a.a.b.b.a.f(9, this.qHt);
            }
            AppMethodBeat.o(153075);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153075);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.qHm = aVar3.UbS.zi();
                    AppMethodBeat.o(153075);
                    return 0;
                case 2:
                    oVar.gqB = aVar3.UbS.readString();
                    AppMethodBeat.o(153075);
                    return 0;
                case 3:
                    oVar.qHn = aVar3.UbS.readString();
                    AppMethodBeat.o(153075);
                    return 0;
                case 4:
                    oVar.qHo = aVar3.UbS.readString();
                    AppMethodBeat.o(153075);
                    return 0;
                case 5:
                    oVar.qHp = aVar3.UbS.readString();
                    AppMethodBeat.o(153075);
                    return 0;
                case 6:
                    oVar.qHq = aVar3.UbS.readString();
                    AppMethodBeat.o(153075);
                    return 0;
                case 7:
                    oVar.qHr = aVar3.UbS.zi();
                    AppMethodBeat.o(153075);
                    return 0;
                case 8:
                    oVar.qHs = aVar3.UbS.readString();
                    AppMethodBeat.o(153075);
                    return 0;
                case 9:
                    oVar.qHt = aVar3.UbS.readString();
                    AppMethodBeat.o(153075);
                    return 0;
                default:
                    AppMethodBeat.o(153075);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153075);
            return -1;
        }
    }
}
