package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bmy extends dpc {
    public b LVA;
    public b LVy;
    public int LVz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152569);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152569);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(3, this.LVz);
            if (this.LVA != null) {
                aVar.c(4, this.LVA);
            }
            if (this.LVy != null) {
                aVar.c(5, this.LVy);
            }
            AppMethodBeat.o(152569);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(3, this.LVz);
            if (this.LVA != null) {
                nh += g.a.a.b.b.a.b(4, this.LVA);
            }
            if (this.LVy != null) {
                nh += g.a.a.b.b.a.b(5, this.LVy);
            }
            AppMethodBeat.o(152569);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152569);
                throw bVar2;
            }
            AppMethodBeat.o(152569);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmy bmy = (bmy) objArr[1];
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
                        bmy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152569);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(152569);
                    return -1;
                case 3:
                    bmy.LVz = aVar3.UbS.zi();
                    AppMethodBeat.o(152569);
                    return 0;
                case 4:
                    bmy.LVA = aVar3.UbS.hPo();
                    AppMethodBeat.o(152569);
                    return 0;
                case 5:
                    bmy.LVy = aVar3.UbS.hPo();
                    AppMethodBeat.o(152569);
                    return 0;
            }
        } else {
            AppMethodBeat.o(152569);
            return -1;
        }
    }
}
