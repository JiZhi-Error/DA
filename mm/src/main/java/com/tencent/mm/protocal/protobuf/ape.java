package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ape extends dpc {
    public int LBk;
    public int LBl;
    public int LBm;
    public int LBn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209348);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LBk);
            aVar.aM(3, this.LBl);
            aVar.aM(4, this.LBm);
            aVar.aM(5, this.LBn);
            AppMethodBeat.o(209348);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LBk) + g.a.a.b.b.a.bu(3, this.LBl) + g.a.a.b.b.a.bu(4, this.LBm) + g.a.a.b.b.a.bu(5, this.LBn);
            AppMethodBeat.o(209348);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209348);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ape ape = (ape) objArr[1];
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
                        ape.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209348);
                    return 0;
                case 2:
                    ape.LBk = aVar3.UbS.zi();
                    AppMethodBeat.o(209348);
                    return 0;
                case 3:
                    ape.LBl = aVar3.UbS.zi();
                    AppMethodBeat.o(209348);
                    return 0;
                case 4:
                    ape.LBm = aVar3.UbS.zi();
                    AppMethodBeat.o(209348);
                    return 0;
                case 5:
                    ape.LBn = aVar3.UbS.zi();
                    AppMethodBeat.o(209348);
                    return 0;
                default:
                    AppMethodBeat.o(209348);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209348);
            return -1;
        }
    }
}