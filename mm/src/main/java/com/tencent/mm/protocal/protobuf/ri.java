package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ri extends dpc {
    public int Cpq = 0;
    public String Cpr;
    public String Cps;
    public String Cpt;
    public String Cpu;
    public String KHM;
    public String KHN;
    public String KHO;
    public eig KYA;
    public String KYB;
    public int KYC;
    public int KYD;
    public int KYE;
    public b KYF;
    public int KYG;
    public int KYH;
    public int KYI;
    public rb KYJ;
    public ea KYK;
    public dz KYL;
    public zg KYM;
    public String KYf;
    public String KYt;
    public dyf KYu;
    public String KYv;
    public String KYw;
    public int KYx;
    public int KYy;
    public int KYz;
    public String dNQ;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91375);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91375);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            if (this.dNQ != null) {
                aVar.e(4, this.dNQ);
            }
            if (this.KYt != null) {
                aVar.e(5, this.KYt);
            }
            if (this.KYu != null) {
                aVar.ni(6, this.KYu.computeSize());
                this.KYu.writeFields(aVar);
            }
            if (this.KHM != null) {
                aVar.e(7, this.KHM);
            }
            if (this.KHO != null) {
                aVar.e(8, this.KHO);
            }
            if (this.KYv != null) {
                aVar.e(9, this.KYv);
            }
            if (this.KYw != null) {
                aVar.e(10, this.KYw);
            }
            aVar.aM(11, this.KYx);
            if (this.KHN != null) {
                aVar.e(12, this.KHN);
            }
            if (this.KYf != null) {
                aVar.e(13, this.KYf);
            }
            aVar.aM(14, this.KYy);
            aVar.aM(15, this.KYz);
            if (this.KYA != null) {
                aVar.ni(16, this.KYA.computeSize());
                this.KYA.writeFields(aVar);
            }
            if (this.KYB != null) {
                aVar.e(17, this.KYB);
            }
            aVar.aM(18, this.KYC);
            aVar.aM(19, this.KYD);
            aVar.aM(20, this.KYE);
            if (this.KYF != null) {
                aVar.c(21, this.KYF);
            }
            aVar.aM(22, this.KYG);
            aVar.aM(23, this.Cpq);
            if (this.Cpr != null) {
                aVar.e(24, this.Cpr);
            }
            if (this.Cps != null) {
                aVar.e(25, this.Cps);
            }
            aVar.aM(26, this.KYH);
            if (this.Cpt != null) {
                aVar.e(27, this.Cpt);
            }
            if (this.Cpu != null) {
                aVar.e(28, this.Cpu);
            }
            aVar.aM(29, this.KYI);
            if (this.KYJ != null) {
                aVar.ni(30, this.KYJ.computeSize());
                this.KYJ.writeFields(aVar);
            }
            if (this.KYK != null) {
                aVar.ni(31, this.KYK.computeSize());
                this.KYK.writeFields(aVar);
            }
            if (this.KYL != null) {
                aVar.ni(32, this.KYL.computeSize());
                this.KYL.writeFields(aVar);
            }
            if (this.KYM != null) {
                aVar.ni(33, this.KYM.computeSize());
                this.KYM.writeFields(aVar);
            }
            AppMethodBeat.o(91375);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.dNQ != null) {
                nh += g.a.a.b.b.a.f(4, this.dNQ);
            }
            if (this.KYt != null) {
                nh += g.a.a.b.b.a.f(5, this.KYt);
            }
            if (this.KYu != null) {
                nh += g.a.a.a.nh(6, this.KYu.computeSize());
            }
            if (this.KHM != null) {
                nh += g.a.a.b.b.a.f(7, this.KHM);
            }
            if (this.KHO != null) {
                nh += g.a.a.b.b.a.f(8, this.KHO);
            }
            if (this.KYv != null) {
                nh += g.a.a.b.b.a.f(9, this.KYv);
            }
            if (this.KYw != null) {
                nh += g.a.a.b.b.a.f(10, this.KYw);
            }
            int bu = nh + g.a.a.b.b.a.bu(11, this.KYx);
            if (this.KHN != null) {
                bu += g.a.a.b.b.a.f(12, this.KHN);
            }
            if (this.KYf != null) {
                bu += g.a.a.b.b.a.f(13, this.KYf);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.KYy) + g.a.a.b.b.a.bu(15, this.KYz);
            if (this.KYA != null) {
                bu2 += g.a.a.a.nh(16, this.KYA.computeSize());
            }
            if (this.KYB != null) {
                bu2 += g.a.a.b.b.a.f(17, this.KYB);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(18, this.KYC) + g.a.a.b.b.a.bu(19, this.KYD) + g.a.a.b.b.a.bu(20, this.KYE);
            if (this.KYF != null) {
                bu3 += g.a.a.b.b.a.b(21, this.KYF);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(22, this.KYG) + g.a.a.b.b.a.bu(23, this.Cpq);
            if (this.Cpr != null) {
                bu4 += g.a.a.b.b.a.f(24, this.Cpr);
            }
            if (this.Cps != null) {
                bu4 += g.a.a.b.b.a.f(25, this.Cps);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(26, this.KYH);
            if (this.Cpt != null) {
                bu5 += g.a.a.b.b.a.f(27, this.Cpt);
            }
            if (this.Cpu != null) {
                bu5 += g.a.a.b.b.a.f(28, this.Cpu);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(29, this.KYI);
            if (this.KYJ != null) {
                bu6 += g.a.a.a.nh(30, this.KYJ.computeSize());
            }
            if (this.KYK != null) {
                bu6 += g.a.a.a.nh(31, this.KYK.computeSize());
            }
            if (this.KYL != null) {
                bu6 += g.a.a.a.nh(32, this.KYL.computeSize());
            }
            if (this.KYM != null) {
                bu6 += g.a.a.a.nh(33, this.KYM.computeSize());
            }
            AppMethodBeat.o(91375);
            return bu6;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91375);
                throw bVar2;
            }
            AppMethodBeat.o(91375);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ri riVar = (ri) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        riVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91375);
                    return 0;
                case 2:
                    riVar.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 3:
                    riVar.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 4:
                    riVar.dNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 5:
                    riVar.KYt = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dyf dyf = new dyf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dyf.populateBuilderWithField(aVar5, dyf, dpc.getNextFieldNumber(aVar5))) {
                        }
                        riVar.KYu = dyf;
                    }
                    AppMethodBeat.o(91375);
                    return 0;
                case 7:
                    riVar.KHM = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 8:
                    riVar.KHO = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 9:
                    riVar.KYv = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 10:
                    riVar.KYw = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 11:
                    riVar.KYx = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 12:
                    riVar.KHN = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 13:
                    riVar.KYf = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 14:
                    riVar.KYy = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 15:
                    riVar.KYz = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eig eig = new eig();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eig.populateBuilderWithField(aVar6, eig, dpc.getNextFieldNumber(aVar6))) {
                        }
                        riVar.KYA = eig;
                    }
                    AppMethodBeat.o(91375);
                    return 0;
                case 17:
                    riVar.KYB = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 18:
                    riVar.KYC = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 19:
                    riVar.KYD = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 20:
                    riVar.KYE = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 21:
                    riVar.KYF = aVar3.UbS.hPo();
                    AppMethodBeat.o(91375);
                    return 0;
                case 22:
                    riVar.KYG = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 23:
                    riVar.Cpq = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 24:
                    riVar.Cpr = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 25:
                    riVar.Cps = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 26:
                    riVar.KYH = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 27:
                    riVar.Cpt = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 28:
                    riVar.Cpu = aVar3.UbS.readString();
                    AppMethodBeat.o(91375);
                    return 0;
                case 29:
                    riVar.KYI = aVar3.UbS.zi();
                    AppMethodBeat.o(91375);
                    return 0;
                case 30:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        rb rbVar = new rb();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = rbVar.populateBuilderWithField(aVar7, rbVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        riVar.KYJ = rbVar;
                    }
                    AppMethodBeat.o(91375);
                    return 0;
                case 31:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ea eaVar = new ea();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eaVar.populateBuilderWithField(aVar8, eaVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        riVar.KYK = eaVar;
                    }
                    AppMethodBeat.o(91375);
                    return 0;
                case 32:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dz dzVar = new dz();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dzVar.populateBuilderWithField(aVar9, dzVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        riVar.KYL = dzVar;
                    }
                    AppMethodBeat.o(91375);
                    return 0;
                case 33:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        zg zgVar = new zg();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = zgVar.populateBuilderWithField(aVar10, zgVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        riVar.KYM = zgVar;
                    }
                    AppMethodBeat.o(91375);
                    return 0;
                default:
                    AppMethodBeat.o(91375);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91375);
            return -1;
        }
    }
}
