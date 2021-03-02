package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bu extends dpc {
    public bf xLQ;
    public au xLR;
    public m xLS;
    public cp xLT;
    public cx xLU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41776);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41776);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.xLR != null) {
                aVar.ni(2, this.xLR.computeSize());
                this.xLR.writeFields(aVar);
            }
            if (this.xLQ != null) {
                aVar.ni(3, this.xLQ.computeSize());
                this.xLQ.writeFields(aVar);
            }
            if (this.xLS != null) {
                aVar.ni(4, this.xLS.computeSize());
                this.xLS.writeFields(aVar);
            }
            if (this.xLT != null) {
                aVar.ni(5, this.xLT.computeSize());
                this.xLT.writeFields(aVar);
            }
            if (this.xLU != null) {
                aVar.ni(6, this.xLU.computeSize());
                this.xLU.writeFields(aVar);
            }
            AppMethodBeat.o(41776);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.xLR != null) {
                nh += g.a.a.a.nh(2, this.xLR.computeSize());
            }
            if (this.xLQ != null) {
                nh += g.a.a.a.nh(3, this.xLQ.computeSize());
            }
            if (this.xLS != null) {
                nh += g.a.a.a.nh(4, this.xLS.computeSize());
            }
            if (this.xLT != null) {
                nh += g.a.a.a.nh(5, this.xLT.computeSize());
            }
            if (this.xLU != null) {
                nh += g.a.a.a.nh(6, this.xLU.computeSize());
            }
            AppMethodBeat.o(41776);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41776);
                throw bVar2;
            }
            AppMethodBeat.o(41776);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bu buVar = (bu) objArr[1];
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
                        buVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(41776);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        au auVar = new au();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = auVar.populateBuilderWithField(aVar5, auVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        buVar.xLR = auVar;
                    }
                    AppMethodBeat.o(41776);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bf bfVar = new bf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bfVar.populateBuilderWithField(aVar6, bfVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        buVar.xLQ = bfVar;
                    }
                    AppMethodBeat.o(41776);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        m mVar = new m();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = mVar.populateBuilderWithField(aVar7, mVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        buVar.xLS = mVar;
                    }
                    AppMethodBeat.o(41776);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        cp cpVar = new cp();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = cpVar.populateBuilderWithField(aVar8, cpVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        buVar.xLT = cpVar;
                    }
                    AppMethodBeat.o(41776);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        cx cxVar = new cx();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cxVar.populateBuilderWithField(aVar9, cxVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        buVar.xLU = cxVar;
                    }
                    AppMethodBeat.o(41776);
                    return 0;
                default:
                    AppMethodBeat.o(41776);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41776);
            return -1;
        }
    }
}
