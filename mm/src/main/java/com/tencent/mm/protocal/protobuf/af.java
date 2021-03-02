package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class af extends dpc {
    public String KCB;
    public int KCC;
    public int KCD;
    public String KCE;
    public dyj KCF;
    public dmc KCG;
    public dyj KCH;
    public dho KCI;
    public bfr KCJ;
    public ih KCK;
    public String KCL;
    public String KCM;
    public int KCN;
    public int OpCode;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32097);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32097);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.KCB != null) {
                aVar.e(2, this.KCB);
            }
            aVar.aM(3, this.KCC);
            aVar.aM(4, this.KCD);
            if (this.KCE != null) {
                aVar.e(5, this.KCE);
            }
            if (this.KCF != null) {
                aVar.ni(6, this.KCF.computeSize());
                this.KCF.writeFields(aVar);
            }
            aVar.aM(7, this.OpCode);
            if (this.KCG != null) {
                aVar.ni(8, this.KCG.computeSize());
                this.KCG.writeFields(aVar);
            }
            if (this.KCH != null) {
                aVar.ni(9, this.KCH.computeSize());
                this.KCH.writeFields(aVar);
            }
            if (this.KCI != null) {
                aVar.ni(10, this.KCI.computeSize());
                this.KCI.writeFields(aVar);
            }
            if (this.KCJ != null) {
                aVar.ni(11, this.KCJ.computeSize());
                this.KCJ.writeFields(aVar);
            }
            if (this.KCK != null) {
                aVar.ni(12, this.KCK.computeSize());
                this.KCK.writeFields(aVar);
            }
            if (this.KCL != null) {
                aVar.e(13, this.KCL);
            }
            if (this.KCM != null) {
                aVar.e(14, this.KCM);
            }
            aVar.aM(15, this.KCN);
            AppMethodBeat.o(32097);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KCB != null) {
                nh += g.a.a.b.b.a.f(2, this.KCB);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KCC) + g.a.a.b.b.a.bu(4, this.KCD);
            if (this.KCE != null) {
                bu += g.a.a.b.b.a.f(5, this.KCE);
            }
            if (this.KCF != null) {
                bu += g.a.a.a.nh(6, this.KCF.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.OpCode);
            if (this.KCG != null) {
                bu2 += g.a.a.a.nh(8, this.KCG.computeSize());
            }
            if (this.KCH != null) {
                bu2 += g.a.a.a.nh(9, this.KCH.computeSize());
            }
            if (this.KCI != null) {
                bu2 += g.a.a.a.nh(10, this.KCI.computeSize());
            }
            if (this.KCJ != null) {
                bu2 += g.a.a.a.nh(11, this.KCJ.computeSize());
            }
            if (this.KCK != null) {
                bu2 += g.a.a.a.nh(12, this.KCK.computeSize());
            }
            if (this.KCL != null) {
                bu2 += g.a.a.b.b.a.f(13, this.KCL);
            }
            if (this.KCM != null) {
                bu2 += g.a.a.b.b.a.f(14, this.KCM);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(15, this.KCN);
            AppMethodBeat.o(32097);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32097);
                throw bVar2;
            }
            AppMethodBeat.o(32097);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            af afVar = (af) objArr[1];
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
                        afVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32097);
                    return 0;
                case 2:
                    afVar.KCB = aVar3.UbS.readString();
                    AppMethodBeat.o(32097);
                    return 0;
                case 3:
                    afVar.KCC = aVar3.UbS.zi();
                    AppMethodBeat.o(32097);
                    return 0;
                case 4:
                    afVar.KCD = aVar3.UbS.zi();
                    AppMethodBeat.o(32097);
                    return 0;
                case 5:
                    afVar.KCE = aVar3.UbS.readString();
                    AppMethodBeat.o(32097);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dyj dyj = new dyj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dyj.populateBuilderWithField(aVar5, dyj, dpc.getNextFieldNumber(aVar5))) {
                        }
                        afVar.KCF = dyj;
                    }
                    AppMethodBeat.o(32097);
                    return 0;
                case 7:
                    afVar.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(32097);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dmc dmc = new dmc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dmc.populateBuilderWithField(aVar6, dmc, dpc.getNextFieldNumber(aVar6))) {
                        }
                        afVar.KCG = dmc;
                    }
                    AppMethodBeat.o(32097);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dyj dyj2 = new dyj();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dyj2.populateBuilderWithField(aVar7, dyj2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        afVar.KCH = dyj2;
                    }
                    AppMethodBeat.o(32097);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dho dho = new dho();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dho.populateBuilderWithField(aVar8, dho, dpc.getNextFieldNumber(aVar8))) {
                        }
                        afVar.KCI = dho;
                    }
                    AppMethodBeat.o(32097);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bfr bfr = new bfr();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bfr.populateBuilderWithField(aVar9, bfr, dpc.getNextFieldNumber(aVar9))) {
                        }
                        afVar.KCJ = bfr;
                    }
                    AppMethodBeat.o(32097);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        ih ihVar = new ih();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = ihVar.populateBuilderWithField(aVar10, ihVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        afVar.KCK = ihVar;
                    }
                    AppMethodBeat.o(32097);
                    return 0;
                case 13:
                    afVar.KCL = aVar3.UbS.readString();
                    AppMethodBeat.o(32097);
                    return 0;
                case 14:
                    afVar.KCM = aVar3.UbS.readString();
                    AppMethodBeat.o(32097);
                    return 0;
                case 15:
                    afVar.KCN = aVar3.UbS.zi();
                    AppMethodBeat.o(32097);
                    return 0;
                default:
                    AppMethodBeat.o(32097);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32097);
            return -1;
        }
    }
}
