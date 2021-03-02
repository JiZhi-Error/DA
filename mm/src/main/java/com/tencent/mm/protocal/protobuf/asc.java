package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class asc extends dpc {
    public int continueFlag;
    public int gAZ;
    public b lastBuffer;
    public LinkedList<aul> likeList = new LinkedList<>();

    public asc() {
        AppMethodBeat.i(209409);
        AppMethodBeat.o(209409);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209410);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.likeList);
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            aVar.aM(4, this.continueFlag);
            aVar.aM(5, this.gAZ);
            AppMethodBeat.o(209410);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.likeList);
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.continueFlag) + g.a.a.b.b.a.bu(5, this.gAZ);
            AppMethodBeat.o(209410);
            return bu;
        } else if (i2 == 2) {
            this.likeList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209410);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            asc asc = (asc) objArr[1];
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
                        asc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209410);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aul aul = new aul();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aul.populateBuilderWithField(aVar5, aul, dpc.getNextFieldNumber(aVar5))) {
                        }
                        asc.likeList.add(aul);
                    }
                    AppMethodBeat.o(209410);
                    return 0;
                case 3:
                    asc.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209410);
                    return 0;
                case 4:
                    asc.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209410);
                    return 0;
                case 5:
                    asc.gAZ = aVar3.UbS.zi();
                    AppMethodBeat.o(209410);
                    return 0;
                default:
                    AppMethodBeat.o(209410);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209410);
            return -1;
        }
    }
}
