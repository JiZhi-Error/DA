package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aqm extends dpc {
    public LinkedList<aqk> LCC = new LinkedList<>();
    public int continueFlag;
    public b lastBuffer;

    public aqm() {
        AppMethodBeat.i(209376);
        AppMethodBeat.o(209376);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209377);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LCC);
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            aVar.aM(4, this.continueFlag);
            AppMethodBeat.o(209377);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LCC);
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.continueFlag);
            AppMethodBeat.o(209377);
            return bu;
        } else if (i2 == 2) {
            this.LCC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209377);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqm aqm = (aqm) objArr[1];
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
                        aqm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209377);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aqk aqk = new aqk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aqk.populateBuilderWithField(aVar5, aqk, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aqm.LCC.add(aqk);
                    }
                    AppMethodBeat.o(209377);
                    return 0;
                case 3:
                    aqm.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209377);
                    return 0;
                case 4:
                    aqm.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209377);
                    return 0;
                default:
                    AppMethodBeat.o(209377);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209377);
            return -1;
        }
    }
}
