package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class brl extends dpc {
    public int LYP;
    public cvs LYQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152577);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LYP);
            if (this.LYQ != null) {
                aVar.ni(3, this.LYQ.computeSize());
                this.LYQ.writeFields(aVar);
            }
            AppMethodBeat.o(152577);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LYP);
            if (this.LYQ != null) {
                nh += g.a.a.a.nh(3, this.LYQ.computeSize());
            }
            AppMethodBeat.o(152577);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152577);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            brl brl = (brl) objArr[1];
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
                        brl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152577);
                    return 0;
                case 2:
                    brl.LYP = aVar3.UbS.zi();
                    AppMethodBeat.o(152577);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cvs cvs = new cvs();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cvs.populateBuilderWithField(aVar5, cvs, dpc.getNextFieldNumber(aVar5))) {
                        }
                        brl.LYQ = cvs;
                    }
                    AppMethodBeat.o(152577);
                    return 0;
                default:
                    AppMethodBeat.o(152577);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152577);
            return -1;
        }
    }
}
