package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class jg extends a {
    public String CiX;
    public int CiY;
    public int CiZ;
    public String Cja;
    public String Cjb;
    public String Cjc;
    public long Cjf;
    public LinkedList<ajr> KNO = new LinkedList<>();
    public String KNP;
    public String KNQ;
    public String dDj;
    public String ynT;

    public jg() {
        AppMethodBeat.i(72420);
        AppMethodBeat.o(72420);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72421);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dDj != null) {
                aVar.e(1, this.dDj);
            }
            if (this.ynT != null) {
                aVar.e(2, this.ynT);
            }
            if (this.CiX != null) {
                aVar.e(3, this.CiX);
            }
            aVar.aM(4, this.CiY);
            aVar.aM(5, this.CiZ);
            aVar.e(6, 8, this.KNO);
            if (this.Cja != null) {
                aVar.e(7, this.Cja);
            }
            if (this.Cjb != null) {
                aVar.e(8, this.Cjb);
            }
            if (this.Cjc != null) {
                aVar.e(9, this.Cjc);
            }
            if (this.KNP != null) {
                aVar.e(10, this.KNP);
            }
            if (this.KNQ != null) {
                aVar.e(11, this.KNQ);
            }
            aVar.bb(12, this.Cjf);
            AppMethodBeat.o(72421);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dDj != null ? g.a.a.b.b.a.f(1, this.dDj) + 0 : 0;
            if (this.ynT != null) {
                f2 += g.a.a.b.b.a.f(2, this.ynT);
            }
            if (this.CiX != null) {
                f2 += g.a.a.b.b.a.f(3, this.CiX);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.CiY) + g.a.a.b.b.a.bu(5, this.CiZ) + g.a.a.a.c(6, 8, this.KNO);
            if (this.Cja != null) {
                bu += g.a.a.b.b.a.f(7, this.Cja);
            }
            if (this.Cjb != null) {
                bu += g.a.a.b.b.a.f(8, this.Cjb);
            }
            if (this.Cjc != null) {
                bu += g.a.a.b.b.a.f(9, this.Cjc);
            }
            if (this.KNP != null) {
                bu += g.a.a.b.b.a.f(10, this.KNP);
            }
            if (this.KNQ != null) {
                bu += g.a.a.b.b.a.f(11, this.KNQ);
            }
            int r = bu + g.a.a.b.b.a.r(12, this.Cjf);
            AppMethodBeat.o(72421);
            return r;
        } else if (i2 == 2) {
            this.KNO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72421);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            jg jgVar = (jg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jgVar.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(72421);
                    return 0;
                case 2:
                    jgVar.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(72421);
                    return 0;
                case 3:
                    jgVar.CiX = aVar3.UbS.readString();
                    AppMethodBeat.o(72421);
                    return 0;
                case 4:
                    jgVar.CiY = aVar3.UbS.zi();
                    AppMethodBeat.o(72421);
                    return 0;
                case 5:
                    jgVar.CiZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72421);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ajr ajr = new ajr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ajr.populateBuilderWithField(aVar4, ajr, a.getNextFieldNumber(aVar4))) {
                        }
                        jgVar.KNO.add(ajr);
                    }
                    AppMethodBeat.o(72421);
                    return 0;
                case 7:
                    jgVar.Cja = aVar3.UbS.readString();
                    AppMethodBeat.o(72421);
                    return 0;
                case 8:
                    jgVar.Cjb = aVar3.UbS.readString();
                    AppMethodBeat.o(72421);
                    return 0;
                case 9:
                    jgVar.Cjc = aVar3.UbS.readString();
                    AppMethodBeat.o(72421);
                    return 0;
                case 10:
                    jgVar.KNP = aVar3.UbS.readString();
                    AppMethodBeat.o(72421);
                    return 0;
                case 11:
                    jgVar.KNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(72421);
                    return 0;
                case 12:
                    jgVar.Cjf = aVar3.UbS.zl();
                    AppMethodBeat.o(72421);
                    return 0;
                default:
                    AppMethodBeat.o(72421);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72421);
            return -1;
        }
    }
}
