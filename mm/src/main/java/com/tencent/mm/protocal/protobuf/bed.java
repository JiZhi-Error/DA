package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bed extends dpc {
    public String HIt;
    public FinderContact LAJ;
    public LinkedList<aus> LEV = new LinkedList<>();
    public int LEW;
    public long LEY;
    public int LNK;
    public String LNL;
    public String LNM;
    public String LNN;
    public int LNO;
    public int LNP;
    public aet LNQ;
    public int LNR;
    public int LNS;
    public bel LNT;
    public int LNU;
    public ddl LNV;
    public int LNW;
    public String LNX;
    public String LNY;
    public ax LNZ;
    public int VjI;
    public String VjJ;
    public int actionType;
    public int foreign_user_flag;
    public int vIE;
    public int vMq;
    public azn verifyInfo;
    public bel wxaShopInfo;

    public bed() {
        AppMethodBeat.i(259372);
        AppMethodBeat.o(259372);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169074);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.actionType);
            if (this.verifyInfo != null) {
                aVar.ni(3, this.verifyInfo.computeSize());
                this.verifyInfo.writeFields(aVar);
            }
            if (this.LAJ != null) {
                aVar.ni(4, this.LAJ.computeSize());
                this.LAJ.writeFields(aVar);
            }
            aVar.aM(5, this.LNK);
            if (this.LNL != null) {
                aVar.e(6, this.LNL);
            }
            if (this.LNM != null) {
                aVar.e(7, this.LNM);
            }
            if (this.LNN != null) {
                aVar.e(8, this.LNN);
            }
            aVar.aM(9, this.LNO);
            aVar.aM(10, this.vMq);
            aVar.aM(11, this.LNP);
            aVar.aM(12, this.vIE);
            if (this.LNQ != null) {
                aVar.ni(13, this.LNQ.computeSize());
                this.LNQ.writeFields(aVar);
            }
            aVar.aM(14, this.LNR);
            aVar.aM(15, this.LNS);
            if (this.HIt != null) {
                aVar.e(16, this.HIt);
            }
            if (this.LNT != null) {
                aVar.ni(17, this.LNT.computeSize());
                this.LNT.writeFields(aVar);
            }
            if (this.wxaShopInfo != null) {
                aVar.ni(18, this.wxaShopInfo.computeSize());
                this.wxaShopInfo.writeFields(aVar);
            }
            aVar.aM(19, this.LNU);
            if (this.LNV != null) {
                aVar.ni(21, this.LNV.computeSize());
                this.LNV.writeFields(aVar);
            }
            aVar.aM(22, this.LNW);
            if (this.LNX != null) {
                aVar.e(23, this.LNX);
            }
            aVar.aM(24, this.foreign_user_flag);
            if (this.LNY != null) {
                aVar.e(25, this.LNY);
            }
            if (this.LNZ != null) {
                aVar.ni(26, this.LNZ.computeSize());
                this.LNZ.writeFields(aVar);
            }
            aVar.aM(27, this.VjI);
            if (this.VjJ != null) {
                aVar.e(28, this.VjJ);
            }
            aVar.e(29, 8, this.LEV);
            aVar.aM(30, this.LEW);
            aVar.bb(31, this.LEY);
            AppMethodBeat.o(169074);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.actionType);
            if (this.verifyInfo != null) {
                nh += g.a.a.a.nh(3, this.verifyInfo.computeSize());
            }
            if (this.LAJ != null) {
                nh += g.a.a.a.nh(4, this.LAJ.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.LNK);
            if (this.LNL != null) {
                bu += g.a.a.b.b.a.f(6, this.LNL);
            }
            if (this.LNM != null) {
                bu += g.a.a.b.b.a.f(7, this.LNM);
            }
            if (this.LNN != null) {
                bu += g.a.a.b.b.a.f(8, this.LNN);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.LNO) + g.a.a.b.b.a.bu(10, this.vMq) + g.a.a.b.b.a.bu(11, this.LNP) + g.a.a.b.b.a.bu(12, this.vIE);
            if (this.LNQ != null) {
                bu2 += g.a.a.a.nh(13, this.LNQ.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.LNR) + g.a.a.b.b.a.bu(15, this.LNS);
            if (this.HIt != null) {
                bu3 += g.a.a.b.b.a.f(16, this.HIt);
            }
            if (this.LNT != null) {
                bu3 += g.a.a.a.nh(17, this.LNT.computeSize());
            }
            if (this.wxaShopInfo != null) {
                bu3 += g.a.a.a.nh(18, this.wxaShopInfo.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(19, this.LNU);
            if (this.LNV != null) {
                bu4 += g.a.a.a.nh(21, this.LNV.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(22, this.LNW);
            if (this.LNX != null) {
                bu5 += g.a.a.b.b.a.f(23, this.LNX);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(24, this.foreign_user_flag);
            if (this.LNY != null) {
                bu6 += g.a.a.b.b.a.f(25, this.LNY);
            }
            if (this.LNZ != null) {
                bu6 += g.a.a.a.nh(26, this.LNZ.computeSize());
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(27, this.VjI);
            if (this.VjJ != null) {
                bu7 += g.a.a.b.b.a.f(28, this.VjJ);
            }
            int c2 = bu7 + g.a.a.a.c(29, 8, this.LEV) + g.a.a.b.b.a.bu(30, this.LEW) + g.a.a.b.b.a.r(31, this.LEY);
            AppMethodBeat.o(169074);
            return c2;
        } else if (i2 == 2) {
            this.LEV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169074);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bed bed = (bed) objArr[1];
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
                        bed.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(169074);
                    return 0;
                case 2:
                    bed.actionType = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        azn azn = new azn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = azn.populateBuilderWithField(aVar5, azn, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bed.verifyInfo = azn;
                    }
                    AppMethodBeat.o(169074);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderContact.populateBuilderWithField(aVar6, finderContact, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bed.LAJ = finderContact;
                    }
                    AppMethodBeat.o(169074);
                    return 0;
                case 5:
                    bed.LNK = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 6:
                    bed.LNL = aVar3.UbS.readString();
                    AppMethodBeat.o(169074);
                    return 0;
                case 7:
                    bed.LNM = aVar3.UbS.readString();
                    AppMethodBeat.o(169074);
                    return 0;
                case 8:
                    bed.LNN = aVar3.UbS.readString();
                    AppMethodBeat.o(169074);
                    return 0;
                case 9:
                    bed.LNO = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 10:
                    bed.vMq = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 11:
                    bed.LNP = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 12:
                    bed.vIE = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aet aet = new aet();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aet.populateBuilderWithField(aVar7, aet, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bed.LNQ = aet;
                    }
                    AppMethodBeat.o(169074);
                    return 0;
                case 14:
                    bed.LNR = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 15:
                    bed.LNS = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 16:
                    bed.HIt = aVar3.UbS.readString();
                    AppMethodBeat.o(169074);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bel bel = new bel();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bel.populateBuilderWithField(aVar8, bel, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bed.LNT = bel;
                    }
                    AppMethodBeat.o(169074);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bel bel2 = new bel();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bel2.populateBuilderWithField(aVar9, bel2, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bed.wxaShopInfo = bel2;
                    }
                    AppMethodBeat.o(169074);
                    return 0;
                case 19:
                    bed.LNU = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 20:
                default:
                    AppMethodBeat.o(169074);
                    return -1;
                case 21:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        ddl ddl = new ddl();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = ddl.populateBuilderWithField(aVar10, ddl, dpc.getNextFieldNumber(aVar10))) {
                        }
                        bed.LNV = ddl;
                    }
                    AppMethodBeat.o(169074);
                    return 0;
                case 22:
                    bed.LNW = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 23:
                    bed.LNX = aVar3.UbS.readString();
                    AppMethodBeat.o(169074);
                    return 0;
                case 24:
                    bed.foreign_user_flag = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 25:
                    bed.LNY = aVar3.UbS.readString();
                    AppMethodBeat.o(169074);
                    return 0;
                case 26:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        ax axVar = new ax();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = axVar.populateBuilderWithField(aVar11, axVar, dpc.getNextFieldNumber(aVar11))) {
                        }
                        bed.LNZ = axVar;
                    }
                    AppMethodBeat.o(169074);
                    return 0;
                case 27:
                    bed.VjI = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 28:
                    bed.VjJ = aVar3.UbS.readString();
                    AppMethodBeat.o(169074);
                    return 0;
                case 29:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        aus aus = new aus();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = aus.populateBuilderWithField(aVar12, aus, dpc.getNextFieldNumber(aVar12))) {
                        }
                        bed.LEV.add(aus);
                    }
                    AppMethodBeat.o(169074);
                    return 0;
                case 30:
                    bed.LEW = aVar3.UbS.zi();
                    AppMethodBeat.o(169074);
                    return 0;
                case 31:
                    bed.LEY = aVar3.UbS.zl();
                    AppMethodBeat.o(169074);
                    return 0;
            }
        } else {
            AppMethodBeat.o(169074);
            return -1;
        }
    }
}
