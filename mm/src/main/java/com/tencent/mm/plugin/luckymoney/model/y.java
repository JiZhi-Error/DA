package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class y extends a {
    public int egY;
    public int status;
    public String yQE;
    public String yVe;
    public long yVh;
    public long yVj;
    public String yVk;
    public int yVv;
    public String yWn;
    public long yWo;
    public String yWp;
    public String yWq;
    public String yWr;
    public long yWs;
    public int yWt;
    public String yWu;
    public String yWv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91257);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.yWn != null) {
                aVar.e(1, this.yWn);
            }
            if (this.yVe != null) {
                aVar.e(2, this.yVe);
            }
            aVar.bb(3, this.yWo);
            if (this.yWp != null) {
                aVar.e(4, this.yWp);
            }
            aVar.aM(5, this.egY);
            if (this.yWq != null) {
                aVar.e(6, this.yWq);
            }
            if (this.yWr != null) {
                aVar.e(7, this.yWr);
            }
            aVar.bb(8, this.yVj);
            aVar.bb(9, this.yWs);
            aVar.bb(10, this.yVh);
            aVar.aM(11, this.status);
            aVar.aM(12, this.yWt);
            if (this.yVk != null) {
                aVar.e(13, this.yVk);
            }
            if (this.yQE != null) {
                aVar.e(14, this.yQE);
            }
            aVar.aM(15, this.yVv);
            if (this.yWu != null) {
                aVar.e(16, this.yWu);
            }
            if (this.yWv != null) {
                aVar.e(17, this.yWv);
            }
            AppMethodBeat.o(91257);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.yWn != null ? g.a.a.b.b.a.f(1, this.yWn) + 0 : 0;
            if (this.yVe != null) {
                f2 += g.a.a.b.b.a.f(2, this.yVe);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.yWo);
            if (this.yWp != null) {
                r += g.a.a.b.b.a.f(4, this.yWp);
            }
            int bu = r + g.a.a.b.b.a.bu(5, this.egY);
            if (this.yWq != null) {
                bu += g.a.a.b.b.a.f(6, this.yWq);
            }
            if (this.yWr != null) {
                bu += g.a.a.b.b.a.f(7, this.yWr);
            }
            int r2 = bu + g.a.a.b.b.a.r(8, this.yVj) + g.a.a.b.b.a.r(9, this.yWs) + g.a.a.b.b.a.r(10, this.yVh) + g.a.a.b.b.a.bu(11, this.status) + g.a.a.b.b.a.bu(12, this.yWt);
            if (this.yVk != null) {
                r2 += g.a.a.b.b.a.f(13, this.yVk);
            }
            if (this.yQE != null) {
                r2 += g.a.a.b.b.a.f(14, this.yQE);
            }
            int bu2 = r2 + g.a.a.b.b.a.bu(15, this.yVv);
            if (this.yWu != null) {
                bu2 += g.a.a.b.b.a.f(16, this.yWu);
            }
            if (this.yWv != null) {
                bu2 += g.a.a.b.b.a.f(17, this.yWv);
            }
            AppMethodBeat.o(91257);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91257);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.yWn = aVar3.UbS.readString();
                    AppMethodBeat.o(91257);
                    return 0;
                case 2:
                    yVar.yVe = aVar3.UbS.readString();
                    AppMethodBeat.o(91257);
                    return 0;
                case 3:
                    yVar.yWo = aVar3.UbS.zl();
                    AppMethodBeat.o(91257);
                    return 0;
                case 4:
                    yVar.yWp = aVar3.UbS.readString();
                    AppMethodBeat.o(91257);
                    return 0;
                case 5:
                    yVar.egY = aVar3.UbS.zi();
                    AppMethodBeat.o(91257);
                    return 0;
                case 6:
                    yVar.yWq = aVar3.UbS.readString();
                    AppMethodBeat.o(91257);
                    return 0;
                case 7:
                    yVar.yWr = aVar3.UbS.readString();
                    AppMethodBeat.o(91257);
                    return 0;
                case 8:
                    yVar.yVj = aVar3.UbS.zl();
                    AppMethodBeat.o(91257);
                    return 0;
                case 9:
                    yVar.yWs = aVar3.UbS.zl();
                    AppMethodBeat.o(91257);
                    return 0;
                case 10:
                    yVar.yVh = aVar3.UbS.zl();
                    AppMethodBeat.o(91257);
                    return 0;
                case 11:
                    yVar.status = aVar3.UbS.zi();
                    AppMethodBeat.o(91257);
                    return 0;
                case 12:
                    yVar.yWt = aVar3.UbS.zi();
                    AppMethodBeat.o(91257);
                    return 0;
                case 13:
                    yVar.yVk = aVar3.UbS.readString();
                    AppMethodBeat.o(91257);
                    return 0;
                case 14:
                    yVar.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(91257);
                    return 0;
                case 15:
                    yVar.yVv = aVar3.UbS.zi();
                    AppMethodBeat.o(91257);
                    return 0;
                case 16:
                    yVar.yWu = aVar3.UbS.readString();
                    AppMethodBeat.o(91257);
                    return 0;
                case 17:
                    yVar.yWv = aVar3.UbS.readString();
                    AppMethodBeat.o(91257);
                    return 0;
                default:
                    AppMethodBeat.o(91257);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91257);
            return -1;
        }
    }
}
