package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dxd extends dpc {
    public String MbV;
    public int jeU;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32449);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32449);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.jeU);
            aVar.aM(3, this.oUv);
            if (this.MbV != null) {
                aVar.e(4, this.MbV);
            }
            AppMethodBeat.o(32449);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.jeU) + g.a.a.b.b.a.bu(3, this.oUv);
            if (this.MbV != null) {
                nh += g.a.a.b.b.a.f(4, this.MbV);
            }
            AppMethodBeat.o(32449);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32449);
                throw bVar2;
            }
            AppMethodBeat.o(32449);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dxd dxd = (dxd) objArr[1];
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
                        dxd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32449);
                    return 0;
                case 2:
                    dxd.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(32449);
                    return 0;
                case 3:
                    dxd.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32449);
                    return 0;
                case 4:
                    dxd.MbV = aVar3.UbS.readString();
                    AppMethodBeat.o(32449);
                    return 0;
                default:
                    AppMethodBeat.o(32449);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32449);
            return -1;
        }
    }
}
