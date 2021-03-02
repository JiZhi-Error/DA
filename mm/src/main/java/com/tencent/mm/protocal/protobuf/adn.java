package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class adn extends a {
    public SKBuiltinBuffer_t KHp;
    public String LoE;
    public String LoF;
    public int LoG;
    public int LoH;
    public String LoI;
    public int LoJ;
    public String LoK;
    public String LoL;
    public int LoM;
    public int LoN;
    public LinkedList<dpt> LoO = new LinkedList<>();
    public String LoP;
    public int LoQ;
    public int LoR;
    public int LoS;
    public int LoT;
    public String UserName;
    public int kdY;
    public String ked;
    public String oUJ;
    public String xNU;

    public adn() {
        AppMethodBeat.i(32174);
        AppMethodBeat.o(32174);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32175);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHp == null) {
                b bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(32175);
                throw bVar;
            }
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.LoE != null) {
                aVar.e(3, this.LoE);
            }
            if (this.LoF != null) {
                aVar.e(4, this.LoF);
            }
            aVar.aM(5, this.kdY);
            if (this.KHp != null) {
                aVar.ni(6, this.KHp.computeSize());
                this.KHp.writeFields(aVar);
            }
            aVar.aM(7, this.LoG);
            aVar.aM(8, this.LoH);
            if (this.LoI != null) {
                aVar.e(9, this.LoI);
            }
            aVar.aM(10, this.LoJ);
            if (this.LoK != null) {
                aVar.e(11, this.LoK);
            }
            if (this.LoL != null) {
                aVar.e(12, this.LoL);
            }
            aVar.aM(13, this.LoM);
            aVar.aM(14, this.LoN);
            aVar.e(15, 8, this.LoO);
            if (this.LoP != null) {
                aVar.e(16, this.LoP);
            }
            aVar.aM(17, this.LoQ);
            aVar.aM(18, this.LoR);
            if (this.xNU != null) {
                aVar.e(19, this.xNU);
            }
            aVar.aM(20, this.LoS);
            aVar.aM(21, this.LoT);
            if (this.ked != null) {
                aVar.e(22, this.ked);
            }
            AppMethodBeat.o(32175);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.LoE != null) {
                f2 += g.a.a.b.b.a.f(3, this.LoE);
            }
            if (this.LoF != null) {
                f2 += g.a.a.b.b.a.f(4, this.LoF);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.kdY);
            if (this.KHp != null) {
                bu += g.a.a.a.nh(6, this.KHp.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.LoG) + g.a.a.b.b.a.bu(8, this.LoH);
            if (this.LoI != null) {
                bu2 += g.a.a.b.b.a.f(9, this.LoI);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.LoJ);
            if (this.LoK != null) {
                bu3 += g.a.a.b.b.a.f(11, this.LoK);
            }
            if (this.LoL != null) {
                bu3 += g.a.a.b.b.a.f(12, this.LoL);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(13, this.LoM) + g.a.a.b.b.a.bu(14, this.LoN) + g.a.a.a.c(15, 8, this.LoO);
            if (this.LoP != null) {
                bu4 += g.a.a.b.b.a.f(16, this.LoP);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(17, this.LoQ) + g.a.a.b.b.a.bu(18, this.LoR);
            if (this.xNU != null) {
                bu5 += g.a.a.b.b.a.f(19, this.xNU);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(20, this.LoS) + g.a.a.b.b.a.bu(21, this.LoT);
            if (this.ked != null) {
                bu6 += g.a.a.b.b.a.f(22, this.ked);
            }
            AppMethodBeat.o(32175);
            return bu6;
        } else if (i2 == 2) {
            this.LoO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHp == null) {
                b bVar2 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(32175);
                throw bVar2;
            }
            AppMethodBeat.o(32175);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            adn adn = (adn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    adn.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                case 2:
                    adn.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                case 3:
                    adn.LoE = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                case 4:
                    adn.LoF = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                case 5:
                    adn.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        adn.KHp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32175);
                    return 0;
                case 7:
                    adn.LoG = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 8:
                    adn.LoH = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 9:
                    adn.LoI = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                case 10:
                    adn.LoJ = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 11:
                    adn.LoK = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                case 12:
                    adn.LoL = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                case 13:
                    adn.LoM = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 14:
                    adn.LoN = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dpt dpt = new dpt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dpt.populateBuilderWithField(aVar5, dpt, a.getNextFieldNumber(aVar5))) {
                        }
                        adn.LoO.add(dpt);
                    }
                    AppMethodBeat.o(32175);
                    return 0;
                case 16:
                    adn.LoP = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                case 17:
                    adn.LoQ = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 18:
                    adn.LoR = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 19:
                    adn.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                case 20:
                    adn.LoS = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 21:
                    adn.LoT = aVar3.UbS.zi();
                    AppMethodBeat.o(32175);
                    return 0;
                case 22:
                    adn.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(32175);
                    return 0;
                default:
                    AppMethodBeat.o(32175);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32175);
            return -1;
        }
    }
}
