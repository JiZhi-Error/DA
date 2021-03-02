package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class avy extends dpc {
    public awk LGt;
    public int LGu;
    public int continueFlag;
    public b lastBuffer;
    public long liveId;
    public awi tWe;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209518);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.tWe != null) {
                aVar.ni(2, this.tWe.computeSize());
                this.tWe.writeFields(aVar);
            }
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            aVar.aM(4, this.continueFlag);
            if (this.LGt != null) {
                aVar.ni(5, this.LGt.computeSize());
                this.LGt.writeFields(aVar);
            }
            aVar.bb(6, this.liveId);
            aVar.aM(7, this.LGu);
            AppMethodBeat.o(209518);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.tWe != null) {
                nh += g.a.a.a.nh(2, this.tWe.computeSize());
            }
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.continueFlag);
            if (this.LGt != null) {
                bu += g.a.a.a.nh(5, this.LGt.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(6, this.liveId) + g.a.a.b.b.a.bu(7, this.LGu);
            AppMethodBeat.o(209518);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209518);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            avy avy = (avy) objArr[1];
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
                        avy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209518);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        awi awi = new awi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = awi.populateBuilderWithField(aVar5, awi, dpc.getNextFieldNumber(aVar5))) {
                        }
                        avy.tWe = awi;
                    }
                    AppMethodBeat.o(209518);
                    return 0;
                case 3:
                    avy.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209518);
                    return 0;
                case 4:
                    avy.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209518);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        awk awk = new awk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awk.populateBuilderWithField(aVar6, awk, dpc.getNextFieldNumber(aVar6))) {
                        }
                        avy.LGt = awk;
                    }
                    AppMethodBeat.o(209518);
                    return 0;
                case 6:
                    avy.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209518);
                    return 0;
                case 7:
                    avy.LGu = aVar3.UbS.zi();
                    AppMethodBeat.o(209518);
                    return 0;
                default:
                    AppMethodBeat.o(209518);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209518);
            return -1;
        }
    }
}
