package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ayb extends dpc {
    public int continueFlag;
    public b lastBuffer;
    public LinkedList<FinderObject> object = new LinkedList<>();
    public baw preloadInfo;

    public ayb() {
        AppMethodBeat.i(209582);
        AppMethodBeat.o(209582);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209583);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.object);
            if (this.preloadInfo != null) {
                aVar.ni(3, this.preloadInfo.computeSize());
                this.preloadInfo.writeFields(aVar);
            }
            if (this.lastBuffer != null) {
                aVar.c(4, this.lastBuffer);
            }
            aVar.aM(5, this.continueFlag);
            AppMethodBeat.o(209583);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.object);
            if (this.preloadInfo != null) {
                nh += g.a.a.a.nh(3, this.preloadInfo.computeSize());
            }
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(4, this.lastBuffer);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.continueFlag);
            AppMethodBeat.o(209583);
            return bu;
        } else if (i2 == 2) {
            this.object.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209583);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ayb ayb = (ayb) objArr[1];
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
                        ayb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209583);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ayb.object.add(finderObject);
                    }
                    AppMethodBeat.o(209583);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        baw baw = new baw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = baw.populateBuilderWithField(aVar6, baw, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ayb.preloadInfo = baw;
                    }
                    AppMethodBeat.o(209583);
                    return 0;
                case 4:
                    ayb.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209583);
                    return 0;
                case 5:
                    ayb.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209583);
                    return 0;
                default:
                    AppMethodBeat.o(209583);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209583);
            return -1;
        }
    }
}
