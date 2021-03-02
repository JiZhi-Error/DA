package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class drv extends dpc {
    public int KZk;
    public ru MUt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117910);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MUt != null) {
                aVar.ni(2, this.MUt.computeSize());
                this.MUt.writeFields(aVar);
            }
            aVar.aM(3, this.KZk);
            AppMethodBeat.o(117910);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MUt != null) {
                nh += g.a.a.a.nh(2, this.MUt.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KZk);
            AppMethodBeat.o(117910);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117910);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drv drv = (drv) objArr[1];
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
                        drv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(117910);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ru ruVar = new ru();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ruVar.populateBuilderWithField(aVar5, ruVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        drv.MUt = ruVar;
                    }
                    AppMethodBeat.o(117910);
                    return 0;
                case 3:
                    drv.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(117910);
                    return 0;
                default:
                    AppMethodBeat.o(117910);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117910);
            return -1;
        }
    }
}
