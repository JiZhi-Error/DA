package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bfd extends dpc {
    public LinkedList<bfe> LOI = new LinkedList<>();
    public bfe LOJ;
    public int LOK;
    public bey LOL;
    public String LOM;
    public String LOO;
    public cfm LOP;
    public dju LgT;
    public cdh Lus;
    public int dDN = 0;
    public LinkedList<bez> dkr = new LinkedList<>();
    public int egY;
    public int egZ;
    public int eha;
    public long eht;
    public int qwe;
    public String qwn = "ok";
    public String yPK;
    public String yQE;
    public int yRN;
    public String yRO;
    public String yRP;
    public String yVA;
    public String yVC;
    public String yVD;
    public int yVJ;
    public String yVb;
    public long yVi;
    public long yVj;
    public String yVk;
    public int yVm;
    public int yVn;
    public String yVo;
    public String yVy;
    public int yVz;
    public int yWN;

    public bfd() {
        AppMethodBeat.i(214296);
        AppMethodBeat.o(214296);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214297);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214297);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dDN);
            if (this.qwn != null) {
                aVar.e(3, this.qwn);
            }
            if (this.yQE != null) {
                aVar.e(4, this.yQE);
            }
            aVar.bb(5, this.eht);
            aVar.aM(6, this.yWN);
            aVar.bb(7, this.yVi);
            aVar.aM(8, this.qwe);
            aVar.bb(9, this.yVj);
            aVar.aM(10, this.egY);
            aVar.aM(11, this.yVm);
            aVar.aM(12, this.yVn);
            aVar.aM(13, this.eha);
            aVar.aM(14, this.egZ);
            if (this.yVb != null) {
                aVar.e(15, this.yVb);
            }
            if (this.yPK != null) {
                aVar.e(16, this.yPK);
            }
            if (this.yVk != null) {
                aVar.e(17, this.yVk);
            }
            if (this.yVo != null) {
                aVar.e(18, this.yVo);
            }
            aVar.e(19, 8, this.LOI);
            aVar.e(20, 8, this.dkr);
            aVar.aM(21, this.yRN);
            if (this.yRP != null) {
                aVar.e(22, this.yRP);
            }
            if (this.yVy != null) {
                aVar.e(23, this.yVy);
            }
            if (this.yRO != null) {
                aVar.e(24, this.yRO);
            }
            if (this.LgT != null) {
                aVar.ni(25, this.LgT.computeSize());
                this.LgT.writeFields(aVar);
            }
            if (this.LOO != null) {
                aVar.e(26, this.LOO);
            }
            if (this.LOM != null) {
                aVar.e(27, this.LOM);
            }
            aVar.aM(28, this.yVz);
            if (this.yVA != null) {
                aVar.e(29, this.yVA);
            }
            if (this.LOP != null) {
                aVar.ni(30, this.LOP.computeSize());
                this.LOP.writeFields(aVar);
            }
            aVar.aM(31, this.LOK);
            aVar.aM(32, this.yVJ);
            if (this.Lus != null) {
                aVar.ni(33, this.Lus.computeSize());
                this.Lus.writeFields(aVar);
            }
            if (this.yVC != null) {
                aVar.e(34, this.yVC);
            }
            if (this.yVD != null) {
                aVar.e(35, this.yVD);
            }
            if (this.LOL != null) {
                aVar.ni(36, this.LOL.computeSize());
                this.LOL.writeFields(aVar);
            }
            if (this.LOJ != null) {
                aVar.ni(37, this.LOJ.computeSize());
                this.LOJ.writeFields(aVar);
            }
            AppMethodBeat.o(214297);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.yQE != null) {
                nh += g.a.a.b.b.a.f(4, this.yQE);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.eht) + g.a.a.b.b.a.bu(6, this.yWN) + g.a.a.b.b.a.r(7, this.yVi) + g.a.a.b.b.a.bu(8, this.qwe) + g.a.a.b.b.a.r(9, this.yVj) + g.a.a.b.b.a.bu(10, this.egY) + g.a.a.b.b.a.bu(11, this.yVm) + g.a.a.b.b.a.bu(12, this.yVn) + g.a.a.b.b.a.bu(13, this.eha) + g.a.a.b.b.a.bu(14, this.egZ);
            if (this.yVb != null) {
                r += g.a.a.b.b.a.f(15, this.yVb);
            }
            if (this.yPK != null) {
                r += g.a.a.b.b.a.f(16, this.yPK);
            }
            if (this.yVk != null) {
                r += g.a.a.b.b.a.f(17, this.yVk);
            }
            if (this.yVo != null) {
                r += g.a.a.b.b.a.f(18, this.yVo);
            }
            int c2 = r + g.a.a.a.c(19, 8, this.LOI) + g.a.a.a.c(20, 8, this.dkr) + g.a.a.b.b.a.bu(21, this.yRN);
            if (this.yRP != null) {
                c2 += g.a.a.b.b.a.f(22, this.yRP);
            }
            if (this.yVy != null) {
                c2 += g.a.a.b.b.a.f(23, this.yVy);
            }
            if (this.yRO != null) {
                c2 += g.a.a.b.b.a.f(24, this.yRO);
            }
            if (this.LgT != null) {
                c2 += g.a.a.a.nh(25, this.LgT.computeSize());
            }
            if (this.LOO != null) {
                c2 += g.a.a.b.b.a.f(26, this.LOO);
            }
            if (this.LOM != null) {
                c2 += g.a.a.b.b.a.f(27, this.LOM);
            }
            int bu = c2 + g.a.a.b.b.a.bu(28, this.yVz);
            if (this.yVA != null) {
                bu += g.a.a.b.b.a.f(29, this.yVA);
            }
            if (this.LOP != null) {
                bu += g.a.a.a.nh(30, this.LOP.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(31, this.LOK) + g.a.a.b.b.a.bu(32, this.yVJ);
            if (this.Lus != null) {
                bu2 += g.a.a.a.nh(33, this.Lus.computeSize());
            }
            if (this.yVC != null) {
                bu2 += g.a.a.b.b.a.f(34, this.yVC);
            }
            if (this.yVD != null) {
                bu2 += g.a.a.b.b.a.f(35, this.yVD);
            }
            if (this.LOL != null) {
                bu2 += g.a.a.a.nh(36, this.LOL.computeSize());
            }
            if (this.LOJ != null) {
                bu2 += g.a.a.a.nh(37, this.LOJ.computeSize());
            }
            AppMethodBeat.o(214297);
            return bu2;
        } else if (i2 == 2) {
            this.LOI.clear();
            this.dkr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214297);
                throw bVar2;
            }
            AppMethodBeat.o(214297);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfd bfd = (bfd) objArr[1];
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
                        bfd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(214297);
                    return 0;
                case 2:
                    bfd.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 3:
                    bfd.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 4:
                    bfd.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 5:
                    bfd.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(214297);
                    return 0;
                case 6:
                    bfd.yWN = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 7:
                    bfd.yVi = aVar3.UbS.zl();
                    AppMethodBeat.o(214297);
                    return 0;
                case 8:
                    bfd.qwe = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 9:
                    bfd.yVj = aVar3.UbS.zl();
                    AppMethodBeat.o(214297);
                    return 0;
                case 10:
                    bfd.egY = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 11:
                    bfd.yVm = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 12:
                    bfd.yVn = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 13:
                    bfd.eha = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 14:
                    bfd.egZ = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 15:
                    bfd.yVb = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 16:
                    bfd.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 17:
                    bfd.yVk = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 18:
                    bfd.yVo = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bfe bfe = new bfe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfe.populateBuilderWithField(aVar5, bfe, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bfd.LOI.add(bfe);
                    }
                    AppMethodBeat.o(214297);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bez bez = new bez();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bez.populateBuilderWithField(aVar6, bez, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bfd.dkr.add(bez);
                    }
                    AppMethodBeat.o(214297);
                    return 0;
                case 21:
                    bfd.yRN = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 22:
                    bfd.yRP = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 23:
                    bfd.yVy = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 24:
                    bfd.yRO = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dju dju = new dju();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dju.populateBuilderWithField(aVar7, dju, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bfd.LgT = dju;
                    }
                    AppMethodBeat.o(214297);
                    return 0;
                case 26:
                    bfd.LOO = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 27:
                    bfd.LOM = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 28:
                    bfd.yVz = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 29:
                    bfd.yVA = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 30:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        cfm cfm = new cfm();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = cfm.populateBuilderWithField(aVar8, cfm, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bfd.LOP = cfm;
                    }
                    AppMethodBeat.o(214297);
                    return 0;
                case 31:
                    bfd.LOK = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 32:
                    bfd.yVJ = aVar3.UbS.zi();
                    AppMethodBeat.o(214297);
                    return 0;
                case 33:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        cdh cdh = new cdh();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cdh.populateBuilderWithField(aVar9, cdh, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bfd.Lus = cdh;
                    }
                    AppMethodBeat.o(214297);
                    return 0;
                case 34:
                    bfd.yVC = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 35:
                    bfd.yVD = aVar3.UbS.readString();
                    AppMethodBeat.o(214297);
                    return 0;
                case 36:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        bey bey = new bey();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = bey.populateBuilderWithField(aVar10, bey, dpc.getNextFieldNumber(aVar10))) {
                        }
                        bfd.LOL = bey;
                    }
                    AppMethodBeat.o(214297);
                    return 0;
                case 37:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        bfe bfe2 = new bfe();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = bfe2.populateBuilderWithField(aVar11, bfe2, dpc.getNextFieldNumber(aVar11))) {
                        }
                        bfd.LOJ = bfe2;
                    }
                    AppMethodBeat.o(214297);
                    return 0;
                default:
                    AppMethodBeat.o(214297);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214297);
            return -1;
        }
    }
}
