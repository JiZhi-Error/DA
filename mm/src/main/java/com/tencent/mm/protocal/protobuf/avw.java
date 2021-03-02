package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class avw extends dpc {
    public axv LGr;
    public int continueFlag;
    public b lastBuffer;
    public long liveId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209516);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LGr != null) {
                aVar.ni(2, this.LGr.computeSize());
                this.LGr.writeFields(aVar);
            }
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            aVar.aM(4, this.continueFlag);
            aVar.bb(5, this.liveId);
            AppMethodBeat.o(209516);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LGr != null) {
                nh += g.a.a.a.nh(2, this.LGr.computeSize());
            }
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.continueFlag) + g.a.a.b.b.a.r(5, this.liveId);
            AppMethodBeat.o(209516);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209516);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            avw avw = (avw) objArr[1];
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
                        avw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209516);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        axv axv = new axv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = axv.populateBuilderWithField(aVar5, axv, dpc.getNextFieldNumber(aVar5))) {
                        }
                        avw.LGr = axv;
                    }
                    AppMethodBeat.o(209516);
                    return 0;
                case 3:
                    avw.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209516);
                    return 0;
                case 4:
                    avw.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209516);
                    return 0;
                case 5:
                    avw.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209516);
                    return 0;
                default:
                    AppMethodBeat.o(209516);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209516);
            return -1;
        }
    }
}
