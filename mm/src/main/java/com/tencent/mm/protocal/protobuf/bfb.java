package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bfb extends dpc {
    public LinkedList<bfe> LOI = new LinkedList<>();
    public bfe LOJ;
    public int LOK;
    public bey LOL;
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
    public int yVv;
    public String yVy;
    public int yVz;
    public int yWN;

    public bfb() {
        AppMethodBeat.i(214293);
        AppMethodBeat.o(214293);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214294);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214294);
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
            aVar.aM(4, this.yWN);
            aVar.aM(5, this.qwe);
            aVar.bb(6, this.yVj);
            if (this.yQE != null) {
                aVar.e(7, this.yQE);
            }
            aVar.bb(8, this.eht);
            if (this.yPK != null) {
                aVar.e(9, this.yPK);
            }
            aVar.aM(10, this.yVm);
            if (this.yVk != null) {
                aVar.e(11, this.yVk);
            }
            aVar.e(12, 8, this.LOI);
            aVar.aM(13, this.egY);
            aVar.aM(14, this.yVn);
            aVar.aM(15, this.egZ);
            aVar.aM(16, this.eha);
            if (this.yVb != null) {
                aVar.e(17, this.yVb);
            }
            if (this.yVo != null) {
                aVar.e(18, this.yVo);
            }
            aVar.aM(19, this.yVv);
            aVar.bb(20, this.yVi);
            aVar.e(21, 8, this.dkr);
            if (this.LOJ != null) {
                aVar.ni(22, this.LOJ.computeSize());
                this.LOJ.writeFields(aVar);
            }
            aVar.aM(23, this.yRN);
            if (this.yRP != null) {
                aVar.e(24, this.yRP);
            }
            if (this.yVy != null) {
                aVar.e(25, this.yVy);
            }
            if (this.yRO != null) {
                aVar.e(26, this.yRO);
            }
            aVar.aM(27, this.yVz);
            if (this.yVA != null) {
                aVar.e(28, this.yVA);
            }
            aVar.aM(29, this.LOK);
            aVar.aM(30, this.yVJ);
            if (this.yVC != null) {
                aVar.e(31, this.yVC);
            }
            if (this.yVD != null) {
                aVar.e(32, this.yVD);
            }
            if (this.LOL != null) {
                aVar.ni(33, this.LOL.computeSize());
                this.LOL.writeFields(aVar);
            }
            AppMethodBeat.o(214294);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.yWN) + g.a.a.b.b.a.bu(5, this.qwe) + g.a.a.b.b.a.r(6, this.yVj);
            if (this.yQE != null) {
                bu += g.a.a.b.b.a.f(7, this.yQE);
            }
            int r = bu + g.a.a.b.b.a.r(8, this.eht);
            if (this.yPK != null) {
                r += g.a.a.b.b.a.f(9, this.yPK);
            }
            int bu2 = r + g.a.a.b.b.a.bu(10, this.yVm);
            if (this.yVk != null) {
                bu2 += g.a.a.b.b.a.f(11, this.yVk);
            }
            int c2 = bu2 + g.a.a.a.c(12, 8, this.LOI) + g.a.a.b.b.a.bu(13, this.egY) + g.a.a.b.b.a.bu(14, this.yVn) + g.a.a.b.b.a.bu(15, this.egZ) + g.a.a.b.b.a.bu(16, this.eha);
            if (this.yVb != null) {
                c2 += g.a.a.b.b.a.f(17, this.yVb);
            }
            if (this.yVo != null) {
                c2 += g.a.a.b.b.a.f(18, this.yVo);
            }
            int bu3 = c2 + g.a.a.b.b.a.bu(19, this.yVv) + g.a.a.b.b.a.r(20, this.yVi) + g.a.a.a.c(21, 8, this.dkr);
            if (this.LOJ != null) {
                bu3 += g.a.a.a.nh(22, this.LOJ.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(23, this.yRN);
            if (this.yRP != null) {
                bu4 += g.a.a.b.b.a.f(24, this.yRP);
            }
            if (this.yVy != null) {
                bu4 += g.a.a.b.b.a.f(25, this.yVy);
            }
            if (this.yRO != null) {
                bu4 += g.a.a.b.b.a.f(26, this.yRO);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(27, this.yVz);
            if (this.yVA != null) {
                bu5 += g.a.a.b.b.a.f(28, this.yVA);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(29, this.LOK) + g.a.a.b.b.a.bu(30, this.yVJ);
            if (this.yVC != null) {
                bu6 += g.a.a.b.b.a.f(31, this.yVC);
            }
            if (this.yVD != null) {
                bu6 += g.a.a.b.b.a.f(32, this.yVD);
            }
            if (this.LOL != null) {
                bu6 += g.a.a.a.nh(33, this.LOL.computeSize());
            }
            AppMethodBeat.o(214294);
            return bu6;
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
                AppMethodBeat.o(214294);
                throw bVar2;
            }
            AppMethodBeat.o(214294);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfb bfb = (bfb) objArr[1];
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
                        bfb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(214294);
                    return 0;
                case 2:
                    bfb.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 3:
                    bfb.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 4:
                    bfb.yWN = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 5:
                    bfb.qwe = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 6:
                    bfb.yVj = aVar3.UbS.zl();
                    AppMethodBeat.o(214294);
                    return 0;
                case 7:
                    bfb.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 8:
                    bfb.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(214294);
                    return 0;
                case 9:
                    bfb.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 10:
                    bfb.yVm = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 11:
                    bfb.yVk = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bfe bfe = new bfe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfe.populateBuilderWithField(aVar5, bfe, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bfb.LOI.add(bfe);
                    }
                    AppMethodBeat.o(214294);
                    return 0;
                case 13:
                    bfb.egY = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 14:
                    bfb.yVn = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 15:
                    bfb.egZ = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 16:
                    bfb.eha = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 17:
                    bfb.yVb = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 18:
                    bfb.yVo = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 19:
                    bfb.yVv = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 20:
                    bfb.yVi = aVar3.UbS.zl();
                    AppMethodBeat.o(214294);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bez bez = new bez();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bez.populateBuilderWithField(aVar6, bez, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bfb.dkr.add(bez);
                    }
                    AppMethodBeat.o(214294);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bfe bfe2 = new bfe();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bfe2.populateBuilderWithField(aVar7, bfe2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bfb.LOJ = bfe2;
                    }
                    AppMethodBeat.o(214294);
                    return 0;
                case 23:
                    bfb.yRN = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 24:
                    bfb.yRP = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 25:
                    bfb.yVy = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 26:
                    bfb.yRO = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 27:
                    bfb.yVz = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 28:
                    bfb.yVA = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 29:
                    bfb.LOK = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 30:
                    bfb.yVJ = aVar3.UbS.zi();
                    AppMethodBeat.o(214294);
                    return 0;
                case 31:
                    bfb.yVC = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 32:
                    bfb.yVD = aVar3.UbS.readString();
                    AppMethodBeat.o(214294);
                    return 0;
                case 33:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bey bey = new bey();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bey.populateBuilderWithField(aVar8, bey, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bfb.LOL = bey;
                    }
                    AppMethodBeat.o(214294);
                    return 0;
                default:
                    AppMethodBeat.o(214294);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214294);
            return -1;
        }
    }
}
