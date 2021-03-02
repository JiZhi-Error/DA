package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class dko extends a {
    public String MOA;
    public String MOB;
    public int MOu;
    public String MOv;
    public String MOw;
    public String MOx;
    public String MOy;
    public bzt MOz;
    public String gTT;
    public String nHd;
    public String nHe;
    public String nHf;
    public String nHg;
    public int nHh;
    public String nHi;
    public String qGI;
    public double score;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50101);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.nHh);
            aVar.aM(2, this.MOu);
            if (this.gTT != null) {
                aVar.e(3, this.gTT);
            }
            if (this.nHf != null) {
                aVar.e(4, this.nHf);
            }
            if (this.nHg != null) {
                aVar.e(5, this.nHg);
            }
            if (this.MOv != null) {
                aVar.e(6, this.MOv);
            }
            if (this.qGI != null) {
                aVar.e(7, this.qGI);
            }
            if (this.MOw != null) {
                aVar.e(8, this.MOw);
            }
            if (this.MOx != null) {
                aVar.e(9, this.MOx);
            }
            aVar.e(10, this.score);
            if (this.MOy != null) {
                aVar.e(11, this.MOy);
            }
            if (this.nHd != null) {
                aVar.e(12, this.nHd);
            }
            if (this.MOz != null) {
                aVar.ni(14, this.MOz.computeSize());
                this.MOz.writeFields(aVar);
            }
            if (this.nHe != null) {
                aVar.e(15, this.nHe);
            }
            if (this.MOA != null) {
                aVar.e(16, this.MOA);
            }
            if (this.MOB != null) {
                aVar.e(17, this.MOB);
            }
            if (this.nHi != null) {
                aVar.e(18, this.nHi);
            }
            AppMethodBeat.o(50101);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.nHh) + 0 + g.a.a.b.b.a.bu(2, this.MOu);
            if (this.gTT != null) {
                bu += g.a.a.b.b.a.f(3, this.gTT);
            }
            if (this.nHf != null) {
                bu += g.a.a.b.b.a.f(4, this.nHf);
            }
            if (this.nHg != null) {
                bu += g.a.a.b.b.a.f(5, this.nHg);
            }
            if (this.MOv != null) {
                bu += g.a.a.b.b.a.f(6, this.MOv);
            }
            if (this.qGI != null) {
                bu += g.a.a.b.b.a.f(7, this.qGI);
            }
            if (this.MOw != null) {
                bu += g.a.a.b.b.a.f(8, this.MOw);
            }
            if (this.MOx != null) {
                bu += g.a.a.b.b.a.f(9, this.MOx);
            }
            int fS = bu + g.a.a.b.b.a.fS(10) + 8;
            if (this.MOy != null) {
                fS += g.a.a.b.b.a.f(11, this.MOy);
            }
            if (this.nHd != null) {
                fS += g.a.a.b.b.a.f(12, this.nHd);
            }
            if (this.MOz != null) {
                fS += g.a.a.a.nh(14, this.MOz.computeSize());
            }
            if (this.nHe != null) {
                fS += g.a.a.b.b.a.f(15, this.nHe);
            }
            if (this.MOA != null) {
                fS += g.a.a.b.b.a.f(16, this.MOA);
            }
            if (this.MOB != null) {
                fS += g.a.a.b.b.a.f(17, this.MOB);
            }
            if (this.nHi != null) {
                fS += g.a.a.b.b.a.f(18, this.nHi);
            }
            AppMethodBeat.o(50101);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50101);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dko dko = (dko) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dko.nHh = aVar3.UbS.zi();
                    AppMethodBeat.o(50101);
                    return 0;
                case 2:
                    dko.MOu = aVar3.UbS.zi();
                    AppMethodBeat.o(50101);
                    return 0;
                case 3:
                    dko.gTT = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 4:
                    dko.nHf = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 5:
                    dko.nHg = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 6:
                    dko.MOv = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 7:
                    dko.qGI = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 8:
                    dko.MOw = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 9:
                    dko.MOx = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 10:
                    dko.score = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(50101);
                    return 0;
                case 11:
                    dko.MOy = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 12:
                    dko.nHd = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 13:
                default:
                    AppMethodBeat.o(50101);
                    return -1;
                case 14:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bzt bzt = new bzt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bzt.populateBuilderWithField(aVar4, bzt, a.getNextFieldNumber(aVar4))) {
                        }
                        dko.MOz = bzt;
                    }
                    AppMethodBeat.o(50101);
                    return 0;
                case 15:
                    dko.nHe = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 16:
                    dko.MOA = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 17:
                    dko.MOB = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
                case 18:
                    dko.nHi = aVar3.UbS.readString();
                    AppMethodBeat.o(50101);
                    return 0;
            }
        } else {
            AppMethodBeat.o(50101);
            return -1;
        }
    }
}
