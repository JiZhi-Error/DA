package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bvw extends dpc {
    public int MbO;
    public LinkedList<dje> MbP = new LinkedList<>();
    public int MbQ;
    public int MbR;
    public int MbS;
    public bzo MbT;
    public LinkedList<br> xME = new LinkedList<>();
    public LinkedList<bzp> xMi = new LinkedList<>();

    public bvw() {
        AppMethodBeat.i(152598);
        AppMethodBeat.o(152598);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152599);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152599);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.MbO);
            aVar.e(3, 8, this.MbP);
            aVar.aM(4, this.MbQ);
            aVar.aM(5, this.MbR);
            aVar.e(6, 8, this.xME);
            aVar.aM(7, this.MbS);
            aVar.e(8, 8, this.xMi);
            if (this.MbT != null) {
                aVar.ni(9, this.MbT.computeSize());
                this.MbT.writeFields(aVar);
            }
            AppMethodBeat.o(152599);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MbO) + g.a.a.a.c(3, 8, this.MbP) + g.a.a.b.b.a.bu(4, this.MbQ) + g.a.a.b.b.a.bu(5, this.MbR) + g.a.a.a.c(6, 8, this.xME) + g.a.a.b.b.a.bu(7, this.MbS) + g.a.a.a.c(8, 8, this.xMi);
            if (this.MbT != null) {
                nh += g.a.a.a.nh(9, this.MbT.computeSize());
            }
            AppMethodBeat.o(152599);
            return nh;
        } else if (i2 == 2) {
            this.MbP.clear();
            this.xME.clear();
            this.xMi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152599);
                throw bVar2;
            }
            AppMethodBeat.o(152599);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bvw bvw = (bvw) objArr[1];
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
                        bvw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152599);
                    return 0;
                case 2:
                    bvw.MbO = aVar3.UbS.zi();
                    AppMethodBeat.o(152599);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dje dje = new dje();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dje.populateBuilderWithField(aVar5, dje, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bvw.MbP.add(dje);
                    }
                    AppMethodBeat.o(152599);
                    return 0;
                case 4:
                    bvw.MbQ = aVar3.UbS.zi();
                    AppMethodBeat.o(152599);
                    return 0;
                case 5:
                    bvw.MbR = aVar3.UbS.zi();
                    AppMethodBeat.o(152599);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        br brVar = new br();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = brVar.populateBuilderWithField(aVar6, brVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bvw.xME.add(brVar);
                    }
                    AppMethodBeat.o(152599);
                    return 0;
                case 7:
                    bvw.MbS = aVar3.UbS.zi();
                    AppMethodBeat.o(152599);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bzp bzp = new bzp();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bzp.populateBuilderWithField(aVar7, bzp, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bvw.xMi.add(bzp);
                    }
                    AppMethodBeat.o(152599);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bzo bzo = new bzo();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bzo.populateBuilderWithField(aVar8, bzo, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bvw.MbT = bzo;
                    }
                    AppMethodBeat.o(152599);
                    return 0;
                default:
                    AppMethodBeat.o(152599);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152599);
            return -1;
        }
    }
}
