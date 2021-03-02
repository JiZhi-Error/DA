package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ah extends dpc {
    public int KCD;
    public String KCE;
    public dyj KCF;
    public dmc KCG;
    public int KCN;
    public add KCR;
    public boolean KCS;
    public int KCT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32100);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32100);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.KCD);
            if (this.KCE != null) {
                aVar.e(3, this.KCE);
            }
            if (this.KCF != null) {
                aVar.ni(4, this.KCF.computeSize());
                this.KCF.writeFields(aVar);
            }
            if (this.KCG != null) {
                aVar.ni(5, this.KCG.computeSize());
                this.KCG.writeFields(aVar);
            }
            aVar.aM(6, this.KCN);
            if (this.KCR != null) {
                aVar.ni(7, this.KCR.computeSize());
                this.KCR.writeFields(aVar);
            }
            aVar.cc(8, this.KCS);
            aVar.aM(9, this.KCT);
            AppMethodBeat.o(32100);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KCD);
            if (this.KCE != null) {
                nh += g.a.a.b.b.a.f(3, this.KCE);
            }
            if (this.KCF != null) {
                nh += g.a.a.a.nh(4, this.KCF.computeSize());
            }
            if (this.KCG != null) {
                nh += g.a.a.a.nh(5, this.KCG.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.KCN);
            if (this.KCR != null) {
                bu += g.a.a.a.nh(7, this.KCR.computeSize());
            }
            int fS = bu + g.a.a.b.b.a.fS(8) + 1 + g.a.a.b.b.a.bu(9, this.KCT);
            AppMethodBeat.o(32100);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32100);
                throw bVar2;
            }
            AppMethodBeat.o(32100);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ah ahVar = (ah) objArr[1];
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
                        ahVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32100);
                    return 0;
                case 2:
                    ahVar.KCD = aVar3.UbS.zi();
                    AppMethodBeat.o(32100);
                    return 0;
                case 3:
                    ahVar.KCE = aVar3.UbS.readString();
                    AppMethodBeat.o(32100);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dyj dyj = new dyj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dyj.populateBuilderWithField(aVar5, dyj, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ahVar.KCF = dyj;
                    }
                    AppMethodBeat.o(32100);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dmc dmc = new dmc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dmc.populateBuilderWithField(aVar6, dmc, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ahVar.KCG = dmc;
                    }
                    AppMethodBeat.o(32100);
                    return 0;
                case 6:
                    ahVar.KCN = aVar3.UbS.zi();
                    AppMethodBeat.o(32100);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        add add = new add();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = add.populateBuilderWithField(aVar7, add, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ahVar.KCR = add;
                    }
                    AppMethodBeat.o(32100);
                    return 0;
                case 8:
                    ahVar.KCS = aVar3.UbS.yZ();
                    AppMethodBeat.o(32100);
                    return 0;
                case 9:
                    ahVar.KCT = aVar3.UbS.zi();
                    AppMethodBeat.o(32100);
                    return 0;
                default:
                    AppMethodBeat.o(32100);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32100);
            return -1;
        }
    }
}
