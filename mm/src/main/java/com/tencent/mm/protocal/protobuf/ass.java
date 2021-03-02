package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ass extends dpc {
    public LinkedList<awq> FoQ = new LinkedList<>();
    public awn LBR;
    public int LDA;
    public int LDB;
    public int LDC;
    public int LDD;
    public int LDE;
    public int LDF;
    public awu LDG;
    public int LDH;
    public LinkedList<aut> LDI = new LinkedList<>();
    public LinkedList<axl> LDJ = new LinkedList<>();
    public avi LDK;
    public b LDx;
    public LinkedList<FinderContact> LDz = new LinkedList<>();
    public int ViE;
    public long ViF;
    public awe liveInfo;

    public ass() {
        AppMethodBeat.i(209422);
        AppMethodBeat.o(209422);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209423);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LDz);
            aVar.e(3, 8, this.FoQ);
            if (this.liveInfo != null) {
                aVar.ni(4, this.liveInfo.computeSize());
                this.liveInfo.writeFields(aVar);
            }
            if (this.LDx != null) {
                aVar.c(5, this.LDx);
            }
            aVar.aM(6, this.LDA);
            aVar.aM(7, this.LDB);
            aVar.aM(8, this.LDC);
            if (this.LBR != null) {
                aVar.ni(9, this.LBR.computeSize());
                this.LBR.writeFields(aVar);
            }
            aVar.aM(10, this.LDD);
            aVar.aM(11, this.LDE);
            aVar.aM(12, this.LDF);
            if (this.LDG != null) {
                aVar.ni(13, this.LDG.computeSize());
                this.LDG.writeFields(aVar);
            }
            aVar.aM(14, this.LDH);
            aVar.e(15, 8, this.LDI);
            aVar.e(16, 8, this.LDJ);
            if (this.LDK != null) {
                aVar.ni(17, this.LDK.computeSize());
                this.LDK.writeFields(aVar);
            }
            aVar.aM(18, this.ViE);
            aVar.bb(19, this.ViF);
            AppMethodBeat.o(209423);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LDz) + g.a.a.a.c(3, 8, this.FoQ);
            if (this.liveInfo != null) {
                nh += g.a.a.a.nh(4, this.liveInfo.computeSize());
            }
            if (this.LDx != null) {
                nh += g.a.a.b.b.a.b(5, this.LDx);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.LDA) + g.a.a.b.b.a.bu(7, this.LDB) + g.a.a.b.b.a.bu(8, this.LDC);
            if (this.LBR != null) {
                bu += g.a.a.a.nh(9, this.LBR.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.LDD) + g.a.a.b.b.a.bu(11, this.LDE) + g.a.a.b.b.a.bu(12, this.LDF);
            if (this.LDG != null) {
                bu2 += g.a.a.a.nh(13, this.LDG.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.LDH) + g.a.a.a.c(15, 8, this.LDI) + g.a.a.a.c(16, 8, this.LDJ);
            if (this.LDK != null) {
                bu3 += g.a.a.a.nh(17, this.LDK.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(18, this.ViE) + g.a.a.b.b.a.r(19, this.ViF);
            AppMethodBeat.o(209423);
            return bu4;
        } else if (i2 == 2) {
            this.LDz.clear();
            this.FoQ.clear();
            this.LDI.clear();
            this.LDJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209423);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ass ass = (ass) objArr[1];
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
                        ass.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209423);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderContact.populateBuilderWithField(aVar5, finderContact, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ass.LDz.add(finderContact);
                    }
                    AppMethodBeat.o(209423);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        awq awq = new awq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awq.populateBuilderWithField(aVar6, awq, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ass.FoQ.add(awq);
                    }
                    AppMethodBeat.o(209423);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        awe awe = new awe();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = awe.populateBuilderWithField(aVar7, awe, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ass.liveInfo = awe;
                    }
                    AppMethodBeat.o(209423);
                    return 0;
                case 5:
                    ass.LDx = aVar3.UbS.hPo();
                    AppMethodBeat.o(209423);
                    return 0;
                case 6:
                    ass.LDA = aVar3.UbS.zi();
                    AppMethodBeat.o(209423);
                    return 0;
                case 7:
                    ass.LDB = aVar3.UbS.zi();
                    AppMethodBeat.o(209423);
                    return 0;
                case 8:
                    ass.LDC = aVar3.UbS.zi();
                    AppMethodBeat.o(209423);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        awn awn = new awn();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = awn.populateBuilderWithField(aVar8, awn, dpc.getNextFieldNumber(aVar8))) {
                        }
                        ass.LBR = awn;
                    }
                    AppMethodBeat.o(209423);
                    return 0;
                case 10:
                    ass.LDD = aVar3.UbS.zi();
                    AppMethodBeat.o(209423);
                    return 0;
                case 11:
                    ass.LDE = aVar3.UbS.zi();
                    AppMethodBeat.o(209423);
                    return 0;
                case 12:
                    ass.LDF = aVar3.UbS.zi();
                    AppMethodBeat.o(209423);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        awu awu = new awu();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = awu.populateBuilderWithField(aVar9, awu, dpc.getNextFieldNumber(aVar9))) {
                        }
                        ass.LDG = awu;
                    }
                    AppMethodBeat.o(209423);
                    return 0;
                case 14:
                    ass.LDH = aVar3.UbS.zi();
                    AppMethodBeat.o(209423);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        aut aut = new aut();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = aut.populateBuilderWithField(aVar10, aut, dpc.getNextFieldNumber(aVar10))) {
                        }
                        ass.LDI.add(aut);
                    }
                    AppMethodBeat.o(209423);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        axl axl = new axl();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = axl.populateBuilderWithField(aVar11, axl, dpc.getNextFieldNumber(aVar11))) {
                        }
                        ass.LDJ.add(axl);
                    }
                    AppMethodBeat.o(209423);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        avi avi = new avi();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = avi.populateBuilderWithField(aVar12, avi, dpc.getNextFieldNumber(aVar12))) {
                        }
                        ass.LDK = avi;
                    }
                    AppMethodBeat.o(209423);
                    return 0;
                case 18:
                    ass.ViE = aVar3.UbS.zi();
                    AppMethodBeat.o(209423);
                    return 0;
                case 19:
                    ass.ViF = aVar3.UbS.zl();
                    AppMethodBeat.o(209423);
                    return 0;
                default:
                    AppMethodBeat.o(209423);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209423);
            return -1;
        }
    }
}
