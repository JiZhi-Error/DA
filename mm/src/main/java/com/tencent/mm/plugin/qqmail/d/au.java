package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class au extends dpc {
    public am Bth;
    public ay Bti;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198639);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Bth != null) {
                aVar.ni(2, this.Bth.computeSize());
                this.Bth.writeFields(aVar);
            }
            if (this.Bti != null) {
                aVar.ni(3, this.Bti.computeSize());
                this.Bti.writeFields(aVar);
            }
            AppMethodBeat.o(198639);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Bth != null) {
                nh += g.a.a.a.nh(2, this.Bth.computeSize());
            }
            if (this.Bti != null) {
                nh += g.a.a.a.nh(3, this.Bti.computeSize());
            }
            AppMethodBeat.o(198639);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198639);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            au auVar = (au) objArr[1];
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
                        auVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(198639);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        am amVar = new am();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = amVar.populateBuilderWithField(aVar5, amVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        auVar.Bth = amVar;
                    }
                    AppMethodBeat.o(198639);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ay ayVar = new ay();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ayVar.populateBuilderWithField(aVar6, ayVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        auVar.Bti = ayVar;
                    }
                    AppMethodBeat.o(198639);
                    return 0;
                default:
                    AppMethodBeat.o(198639);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198639);
            return -1;
        }
    }
}
