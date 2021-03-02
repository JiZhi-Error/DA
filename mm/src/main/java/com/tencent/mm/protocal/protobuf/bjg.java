package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bjg extends dpc {
    public ccr LSV;
    public String LSW;
    public ccm LSX;
    public int result;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82408);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82408);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LSV != null) {
                aVar.ni(2, this.LSV.computeSize());
                this.LSV.writeFields(aVar);
            }
            if (this.LSW != null) {
                aVar.e(3, this.LSW);
            }
            if (this.LSX != null) {
                aVar.ni(4, this.LSX.computeSize());
                this.LSX.writeFields(aVar);
            }
            aVar.aM(5, this.result);
            AppMethodBeat.o(82408);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LSV != null) {
                nh += g.a.a.a.nh(2, this.LSV.computeSize());
            }
            if (this.LSW != null) {
                nh += g.a.a.b.b.a.f(3, this.LSW);
            }
            if (this.LSX != null) {
                nh += g.a.a.a.nh(4, this.LSX.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.result);
            AppMethodBeat.o(82408);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82408);
                throw bVar2;
            }
            AppMethodBeat.o(82408);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bjg bjg = (bjg) objArr[1];
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
                        bjg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(82408);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ccr ccr = new ccr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ccr.populateBuilderWithField(aVar5, ccr, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bjg.LSV = ccr;
                    }
                    AppMethodBeat.o(82408);
                    return 0;
                case 3:
                    bjg.LSW = aVar3.UbS.readString();
                    AppMethodBeat.o(82408);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ccm ccm = new ccm();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ccm.populateBuilderWithField(aVar6, ccm, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bjg.LSX = ccm;
                    }
                    AppMethodBeat.o(82408);
                    return 0;
                case 5:
                    bjg.result = aVar3.UbS.zi();
                    AppMethodBeat.o(82408);
                    return 0;
                default:
                    AppMethodBeat.o(82408);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82408);
            return -1;
        }
    }
}
