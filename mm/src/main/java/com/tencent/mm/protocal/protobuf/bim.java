package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bim extends dpc {
    public int LSD;
    public String pTY;
    public b pUz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114001);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114001);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.pTY != null) {
                aVar.e(2, this.pTY);
            }
            aVar.aM(3, this.LSD);
            if (this.pUz != null) {
                aVar.c(4, this.pUz);
            }
            AppMethodBeat.o(114001);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.pTY != null) {
                nh += g.a.a.b.b.a.f(2, this.pTY);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LSD);
            if (this.pUz != null) {
                bu += g.a.a.b.b.a.b(4, this.pUz);
            }
            AppMethodBeat.o(114001);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114001);
                throw bVar2;
            }
            AppMethodBeat.o(114001);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bim bim = (bim) objArr[1];
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
                        bim.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114001);
                    return 0;
                case 2:
                    bim.pTY = aVar3.UbS.readString();
                    AppMethodBeat.o(114001);
                    return 0;
                case 3:
                    bim.LSD = aVar3.UbS.zi();
                    AppMethodBeat.o(114001);
                    return 0;
                case 4:
                    bim.pUz = aVar3.UbS.hPo();
                    AppMethodBeat.o(114001);
                    return 0;
                default:
                    AppMethodBeat.o(114001);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114001);
            return -1;
        }
    }
}
