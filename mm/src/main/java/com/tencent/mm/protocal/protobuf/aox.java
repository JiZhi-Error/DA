package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aox extends dpc {
    public LinkedList<azq> LAV = new LinkedList<>();
    public LinkedList<apn> LAW = new LinkedList<>();
    public int LAY;

    public aox() {
        AppMethodBeat.i(209339);
        AppMethodBeat.o(209339);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209340);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LAV);
            aVar.e(3, 8, this.LAW);
            aVar.aM(4, this.LAY);
            AppMethodBeat.o(209340);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LAV) + g.a.a.a.c(3, 8, this.LAW) + g.a.a.b.b.a.bu(4, this.LAY);
            AppMethodBeat.o(209340);
            return nh;
        } else if (i2 == 2) {
            this.LAV.clear();
            this.LAW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209340);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aox aox = (aox) objArr[1];
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
                        aox.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209340);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        azq azq = new azq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = azq.populateBuilderWithField(aVar5, azq, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aox.LAV.add(azq);
                    }
                    AppMethodBeat.o(209340);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        apn apn = new apn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = apn.populateBuilderWithField(aVar6, apn, dpc.getNextFieldNumber(aVar6))) {
                        }
                        aox.LAW.add(apn);
                    }
                    AppMethodBeat.o(209340);
                    return 0;
                case 4:
                    aox.LAY = aVar3.UbS.zi();
                    AppMethodBeat.o(209340);
                    return 0;
                default:
                    AppMethodBeat.o(209340);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209340);
            return -1;
        }
    }
}
