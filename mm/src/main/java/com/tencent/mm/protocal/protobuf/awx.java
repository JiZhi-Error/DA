package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class awx extends a {
    public int LHA;
    public int LHB;
    public LinkedList<axr> LHC = new LinkedList<>();
    public int height;
    public long hyH;
    public int hyI;
    public int hyJ;
    public int hyK;
    public int hyL;
    public int hyM;
    public int hyN;
    public int hyO;
    public int hyP;
    public int hyQ;
    public int hyR;
    public int hyS;
    public int hyT;
    public int hyU;
    public int hyX;
    public int hyY;
    public int hyZ;
    public int hza;
    public int hzb;
    public String hzc;
    public int hzd;
    public float hze;
    public float hzf;
    public int width;

    public awx() {
        AppMethodBeat.i(209549);
        AppMethodBeat.o(209549);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209550);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.hyH);
            aVar.aM(2, this.width);
            aVar.aM(3, this.height);
            aVar.aM(4, this.hyI);
            aVar.aM(5, this.hyJ);
            aVar.aM(6, this.hyK);
            aVar.aM(7, this.hyL);
            aVar.aM(8, this.hyM);
            aVar.aM(9, this.hyN);
            aVar.aM(10, this.hyO);
            aVar.aM(11, this.hyP);
            aVar.aM(12, this.hyQ);
            aVar.aM(13, this.hyR);
            aVar.aM(14, this.hyS);
            aVar.aM(15, this.hyT);
            aVar.aM(16, this.hyU);
            aVar.aM(17, this.LHA);
            aVar.aM(18, this.LHB);
            aVar.e(19, 8, this.LHC);
            aVar.aM(20, this.hyX);
            aVar.aM(21, this.hyY);
            aVar.aM(22, this.hyZ);
            aVar.aM(23, this.hza);
            aVar.aM(24, this.hzb);
            if (this.hzc != null) {
                aVar.e(25, this.hzc);
            }
            aVar.aM(26, this.hzd);
            aVar.E(27, this.hze);
            aVar.E(28, this.hzf);
            AppMethodBeat.o(209550);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.hyH) + 0 + g.a.a.b.b.a.bu(2, this.width) + g.a.a.b.b.a.bu(3, this.height) + g.a.a.b.b.a.bu(4, this.hyI) + g.a.a.b.b.a.bu(5, this.hyJ) + g.a.a.b.b.a.bu(6, this.hyK) + g.a.a.b.b.a.bu(7, this.hyL) + g.a.a.b.b.a.bu(8, this.hyM) + g.a.a.b.b.a.bu(9, this.hyN) + g.a.a.b.b.a.bu(10, this.hyO) + g.a.a.b.b.a.bu(11, this.hyP) + g.a.a.b.b.a.bu(12, this.hyQ) + g.a.a.b.b.a.bu(13, this.hyR) + g.a.a.b.b.a.bu(14, this.hyS) + g.a.a.b.b.a.bu(15, this.hyT) + g.a.a.b.b.a.bu(16, this.hyU) + g.a.a.b.b.a.bu(17, this.LHA) + g.a.a.b.b.a.bu(18, this.LHB) + g.a.a.a.c(19, 8, this.LHC) + g.a.a.b.b.a.bu(20, this.hyX) + g.a.a.b.b.a.bu(21, this.hyY) + g.a.a.b.b.a.bu(22, this.hyZ) + g.a.a.b.b.a.bu(23, this.hza) + g.a.a.b.b.a.bu(24, this.hzb);
            if (this.hzc != null) {
                r += g.a.a.b.b.a.f(25, this.hzc);
            }
            int bu = r + g.a.a.b.b.a.bu(26, this.hzd) + g.a.a.b.b.a.fS(27) + 4 + g.a.a.b.b.a.fS(28) + 4;
            AppMethodBeat.o(209550);
            return bu;
        } else if (i2 == 2) {
            this.LHC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209550);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awx awx = (awx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awx.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(209550);
                    return 0;
                case 2:
                    awx.width = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 3:
                    awx.height = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 4:
                    awx.hyI = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 5:
                    awx.hyJ = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 6:
                    awx.hyK = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 7:
                    awx.hyL = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 8:
                    awx.hyM = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 9:
                    awx.hyN = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 10:
                    awx.hyO = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 11:
                    awx.hyP = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 12:
                    awx.hyQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 13:
                    awx.hyR = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 14:
                    awx.hyS = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 15:
                    awx.hyT = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 16:
                    awx.hyU = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 17:
                    awx.LHA = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 18:
                    awx.LHB = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        axr axr = new axr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = axr.populateBuilderWithField(aVar4, axr, a.getNextFieldNumber(aVar4))) {
                        }
                        awx.LHC.add(axr);
                    }
                    AppMethodBeat.o(209550);
                    return 0;
                case 20:
                    awx.hyX = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 21:
                    awx.hyY = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 22:
                    awx.hyZ = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 23:
                    awx.hza = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 24:
                    awx.hzb = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 25:
                    awx.hzc = aVar3.UbS.readString();
                    AppMethodBeat.o(209550);
                    return 0;
                case 26:
                    awx.hzd = aVar3.UbS.zi();
                    AppMethodBeat.o(209550);
                    return 0;
                case 27:
                    awx.hze = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209550);
                    return 0;
                case 28:
                    awx.hzf = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209550);
                    return 0;
                default:
                    AppMethodBeat.o(209550);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209550);
            return -1;
        }
    }
}
