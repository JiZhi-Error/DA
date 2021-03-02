package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bnn extends dpc {
    public long KHg;
    public int LVZ;
    public int LWa;
    public int LWb;
    public long oTV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127496);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(127496);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.KHg);
            aVar.bb(3, this.oTV);
            aVar.aM(4, this.LVZ);
            aVar.aM(5, this.LWa);
            aVar.aM(6, this.LWb);
            AppMethodBeat.o(127496);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.KHg) + g.a.a.b.b.a.r(3, this.oTV) + g.a.a.b.b.a.bu(4, this.LVZ) + g.a.a.b.b.a.bu(5, this.LWa) + g.a.a.b.b.a.bu(6, this.LWb);
            AppMethodBeat.o(127496);
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
                AppMethodBeat.o(127496);
                throw bVar2;
            }
            AppMethodBeat.o(127496);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bnn bnn = (bnn) objArr[1];
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
                        bnn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(127496);
                    return 0;
                case 2:
                    bnn.KHg = aVar3.UbS.zl();
                    AppMethodBeat.o(127496);
                    return 0;
                case 3:
                    bnn.oTV = aVar3.UbS.zl();
                    AppMethodBeat.o(127496);
                    return 0;
                case 4:
                    bnn.LVZ = aVar3.UbS.zi();
                    AppMethodBeat.o(127496);
                    return 0;
                case 5:
                    bnn.LWa = aVar3.UbS.zi();
                    AppMethodBeat.o(127496);
                    return 0;
                case 6:
                    bnn.LWb = aVar3.UbS.zi();
                    AppMethodBeat.o(127496);
                    return 0;
                default:
                    AppMethodBeat.o(127496);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127496);
            return -1;
        }
    }
}
