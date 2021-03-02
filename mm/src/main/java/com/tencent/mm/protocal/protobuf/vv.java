package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class vv extends dpc {
    public int CpF;
    public String CpG;
    public String CpH;
    public String HTZ;
    public int LgF;
    public LinkedList<cor> LgM = new LinkedList<>();
    public cor LgN;
    public String LgO;
    public boolean LgP;
    public String LgQ;
    public int LgR;
    public coz LgS;
    public dju LgT;
    public String LgU;
    public String LgV;
    public String LgW;
    public dgo LgX;
    public dgo LgY;
    public dgo LgZ;
    public b Lha;
    public int dDN;
    public String jTx;
    public String jTy;
    public String url;

    public vv() {
        AppMethodBeat.i(91406);
        AppMethodBeat.o(91406);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91407);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91407);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            aVar.e(3, 8, this.LgM);
            if (this.LgN != null) {
                aVar.ni(4, this.LgN.computeSize());
                this.LgN.writeFields(aVar);
            }
            if (this.HTZ != null) {
                aVar.e(5, this.HTZ);
            }
            if (this.LgO != null) {
                aVar.e(6, this.LgO);
            }
            aVar.cc(7, this.LgP);
            aVar.aM(8, this.CpF);
            if (this.LgQ != null) {
                aVar.e(9, this.LgQ);
            }
            if (this.CpG != null) {
                aVar.e(10, this.CpG);
            }
            if (this.CpH != null) {
                aVar.e(11, this.CpH);
            }
            aVar.aM(12, this.LgR);
            if (this.LgS != null) {
                aVar.ni(13, this.LgS.computeSize());
                this.LgS.writeFields(aVar);
            }
            if (this.LgT != null) {
                aVar.ni(14, this.LgT.computeSize());
                this.LgT.writeFields(aVar);
            }
            aVar.aM(15, this.dDN);
            aVar.aM(16, this.LgF);
            if (this.jTx != null) {
                aVar.e(17, this.jTx);
            }
            if (this.jTy != null) {
                aVar.e(18, this.jTy);
            }
            if (this.LgU != null) {
                aVar.e(19, this.LgU);
            }
            if (this.LgV != null) {
                aVar.e(20, this.LgV);
            }
            if (this.LgW != null) {
                aVar.e(21, this.LgW);
            }
            if (this.LgX != null) {
                aVar.ni(22, this.LgX.computeSize());
                this.LgX.writeFields(aVar);
            }
            if (this.LgY != null) {
                aVar.ni(23, this.LgY.computeSize());
                this.LgY.writeFields(aVar);
            }
            if (this.LgZ != null) {
                aVar.ni(24, this.LgZ.computeSize());
                this.LgZ.writeFields(aVar);
            }
            if (this.Lha != null) {
                aVar.c(25, this.Lha);
            }
            AppMethodBeat.o(91407);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.LgM);
            if (this.LgN != null) {
                c2 += g.a.a.a.nh(4, this.LgN.computeSize());
            }
            if (this.HTZ != null) {
                c2 += g.a.a.b.b.a.f(5, this.HTZ);
            }
            if (this.LgO != null) {
                c2 += g.a.a.b.b.a.f(6, this.LgO);
            }
            int fS = c2 + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.bu(8, this.CpF);
            if (this.LgQ != null) {
                fS += g.a.a.b.b.a.f(9, this.LgQ);
            }
            if (this.CpG != null) {
                fS += g.a.a.b.b.a.f(10, this.CpG);
            }
            if (this.CpH != null) {
                fS += g.a.a.b.b.a.f(11, this.CpH);
            }
            int bu = fS + g.a.a.b.b.a.bu(12, this.LgR);
            if (this.LgS != null) {
                bu += g.a.a.a.nh(13, this.LgS.computeSize());
            }
            if (this.LgT != null) {
                bu += g.a.a.a.nh(14, this.LgT.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(15, this.dDN) + g.a.a.b.b.a.bu(16, this.LgF);
            if (this.jTx != null) {
                bu2 += g.a.a.b.b.a.f(17, this.jTx);
            }
            if (this.jTy != null) {
                bu2 += g.a.a.b.b.a.f(18, this.jTy);
            }
            if (this.LgU != null) {
                bu2 += g.a.a.b.b.a.f(19, this.LgU);
            }
            if (this.LgV != null) {
                bu2 += g.a.a.b.b.a.f(20, this.LgV);
            }
            if (this.LgW != null) {
                bu2 += g.a.a.b.b.a.f(21, this.LgW);
            }
            if (this.LgX != null) {
                bu2 += g.a.a.a.nh(22, this.LgX.computeSize());
            }
            if (this.LgY != null) {
                bu2 += g.a.a.a.nh(23, this.LgY.computeSize());
            }
            if (this.LgZ != null) {
                bu2 += g.a.a.a.nh(24, this.LgZ.computeSize());
            }
            if (this.Lha != null) {
                bu2 += g.a.a.b.b.a.b(25, this.Lha);
            }
            AppMethodBeat.o(91407);
            return bu2;
        } else if (i2 == 2) {
            this.LgM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91407);
                throw bVar2;
            }
            AppMethodBeat.o(91407);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            vv vvVar = (vv) objArr[1];
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
                        vvVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91407);
                    return 0;
                case 2:
                    vvVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cor cor = new cor();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cor.populateBuilderWithField(aVar5, cor, dpc.getNextFieldNumber(aVar5))) {
                        }
                        vvVar.LgM.add(cor);
                    }
                    AppMethodBeat.o(91407);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cor cor2 = new cor();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cor2.populateBuilderWithField(aVar6, cor2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        vvVar.LgN = cor2;
                    }
                    AppMethodBeat.o(91407);
                    return 0;
                case 5:
                    vvVar.HTZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 6:
                    vvVar.LgO = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 7:
                    vvVar.LgP = aVar3.UbS.yZ();
                    AppMethodBeat.o(91407);
                    return 0;
                case 8:
                    vvVar.CpF = aVar3.UbS.zi();
                    AppMethodBeat.o(91407);
                    return 0;
                case 9:
                    vvVar.LgQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 10:
                    vvVar.CpG = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 11:
                    vvVar.CpH = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 12:
                    vvVar.LgR = aVar3.UbS.zi();
                    AppMethodBeat.o(91407);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        coz coz = new coz();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = coz.populateBuilderWithField(aVar7, coz, dpc.getNextFieldNumber(aVar7))) {
                        }
                        vvVar.LgS = coz;
                    }
                    AppMethodBeat.o(91407);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dju dju = new dju();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dju.populateBuilderWithField(aVar8, dju, dpc.getNextFieldNumber(aVar8))) {
                        }
                        vvVar.LgT = dju;
                    }
                    AppMethodBeat.o(91407);
                    return 0;
                case 15:
                    vvVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91407);
                    return 0;
                case 16:
                    vvVar.LgF = aVar3.UbS.zi();
                    AppMethodBeat.o(91407);
                    return 0;
                case 17:
                    vvVar.jTx = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 18:
                    vvVar.jTy = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 19:
                    vvVar.LgU = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 20:
                    vvVar.LgV = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 21:
                    vvVar.LgW = aVar3.UbS.readString();
                    AppMethodBeat.o(91407);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dgo dgo = new dgo();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dgo.populateBuilderWithField(aVar9, dgo, dpc.getNextFieldNumber(aVar9))) {
                        }
                        vvVar.LgX = dgo;
                    }
                    AppMethodBeat.o(91407);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dgo dgo2 = new dgo();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dgo2.populateBuilderWithField(aVar10, dgo2, dpc.getNextFieldNumber(aVar10))) {
                        }
                        vvVar.LgY = dgo2;
                    }
                    AppMethodBeat.o(91407);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dgo dgo3 = new dgo();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dgo3.populateBuilderWithField(aVar11, dgo3, dpc.getNextFieldNumber(aVar11))) {
                        }
                        vvVar.LgZ = dgo3;
                    }
                    AppMethodBeat.o(91407);
                    return 0;
                case 25:
                    vvVar.Lha = aVar3.UbS.hPo();
                    AppMethodBeat.o(91407);
                    return 0;
                default:
                    AppMethodBeat.o(91407);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91407);
            return -1;
        }
    }
}
