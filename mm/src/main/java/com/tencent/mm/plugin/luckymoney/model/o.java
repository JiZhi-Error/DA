package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class o extends a {
    public int qww;
    public String yPA;
    public String yPB;
    public int yPv;
    public double yPw;
    public double yPx;
    public double yPy;
    public double yPz;
    public String yUR;
    public String yUS;
    public int yUT;
    public String yUU;
    public String yUV;
    public String yUW;
    public String yUX;
    public boolean yUY;
    public l yUZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91252);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.yPv);
            aVar.e(2, this.yPy);
            if (this.yUR != null) {
                aVar.e(3, this.yUR);
            }
            if (this.yUS != null) {
                aVar.e(4, this.yUS);
            }
            aVar.e(5, this.yPw);
            aVar.e(6, this.yPz);
            aVar.e(7, this.yPx);
            aVar.aM(8, this.yUT);
            aVar.aM(9, this.qww);
            if (this.yPA != null) {
                aVar.e(10, this.yPA);
            }
            if (this.yPB != null) {
                aVar.e(11, this.yPB);
            }
            if (this.yUU != null) {
                aVar.e(12, this.yUU);
            }
            if (this.yUV != null) {
                aVar.e(13, this.yUV);
            }
            if (this.yUW != null) {
                aVar.e(14, this.yUW);
            }
            if (this.yUX != null) {
                aVar.e(15, this.yUX);
            }
            aVar.cc(16, this.yUY);
            if (this.yUZ != null) {
                aVar.ni(17, this.yUZ.computeSize());
                this.yUZ.writeFields(aVar);
            }
            AppMethodBeat.o(91252);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.yPv) + 0 + g.a.a.b.b.a.fS(2) + 8;
            if (this.yUR != null) {
                bu += g.a.a.b.b.a.f(3, this.yUR);
            }
            if (this.yUS != null) {
                bu += g.a.a.b.b.a.f(4, this.yUS);
            }
            int fS = bu + g.a.a.b.b.a.fS(5) + 8 + g.a.a.b.b.a.fS(6) + 8 + g.a.a.b.b.a.fS(7) + 8 + g.a.a.b.b.a.bu(8, this.yUT) + g.a.a.b.b.a.bu(9, this.qww);
            if (this.yPA != null) {
                fS += g.a.a.b.b.a.f(10, this.yPA);
            }
            if (this.yPB != null) {
                fS += g.a.a.b.b.a.f(11, this.yPB);
            }
            if (this.yUU != null) {
                fS += g.a.a.b.b.a.f(12, this.yUU);
            }
            if (this.yUV != null) {
                fS += g.a.a.b.b.a.f(13, this.yUV);
            }
            if (this.yUW != null) {
                fS += g.a.a.b.b.a.f(14, this.yUW);
            }
            if (this.yUX != null) {
                fS += g.a.a.b.b.a.f(15, this.yUX);
            }
            int fS2 = fS + g.a.a.b.b.a.fS(16) + 1;
            if (this.yUZ != null) {
                fS2 += g.a.a.a.nh(17, this.yUZ.computeSize());
            }
            AppMethodBeat.o(91252);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91252);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oVar.yPv = aVar3.UbS.zi();
                    AppMethodBeat.o(91252);
                    return 0;
                case 2:
                    oVar.yPy = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91252);
                    return 0;
                case 3:
                    oVar.yUR = aVar3.UbS.readString();
                    AppMethodBeat.o(91252);
                    return 0;
                case 4:
                    oVar.yUS = aVar3.UbS.readString();
                    AppMethodBeat.o(91252);
                    return 0;
                case 5:
                    oVar.yPw = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91252);
                    return 0;
                case 6:
                    oVar.yPz = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91252);
                    return 0;
                case 7:
                    oVar.yPx = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91252);
                    return 0;
                case 8:
                    oVar.yUT = aVar3.UbS.zi();
                    AppMethodBeat.o(91252);
                    return 0;
                case 9:
                    oVar.qww = aVar3.UbS.zi();
                    AppMethodBeat.o(91252);
                    return 0;
                case 10:
                    oVar.yPA = aVar3.UbS.readString();
                    AppMethodBeat.o(91252);
                    return 0;
                case 11:
                    oVar.yPB = aVar3.UbS.readString();
                    AppMethodBeat.o(91252);
                    return 0;
                case 12:
                    oVar.yUU = aVar3.UbS.readString();
                    AppMethodBeat.o(91252);
                    return 0;
                case 13:
                    oVar.yUV = aVar3.UbS.readString();
                    AppMethodBeat.o(91252);
                    return 0;
                case 14:
                    oVar.yUW = aVar3.UbS.readString();
                    AppMethodBeat.o(91252);
                    return 0;
                case 15:
                    oVar.yUX = aVar3.UbS.readString();
                    AppMethodBeat.o(91252);
                    return 0;
                case 16:
                    oVar.yUY = aVar3.UbS.yZ();
                    AppMethodBeat.o(91252);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = new l();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oVar.yUZ = lVar;
                    }
                    AppMethodBeat.o(91252);
                    return 0;
                default:
                    AppMethodBeat.o(91252);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91252);
            return -1;
        }
    }
}
