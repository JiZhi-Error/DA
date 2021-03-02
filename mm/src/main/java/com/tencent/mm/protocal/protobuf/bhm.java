package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bhm extends dpc {
    public LinkedList<b> LRZ = new LinkedList<>();
    public int LSa;
    public LinkedList<Integer> LSb = new LinkedList<>();
    public int Timestamp;

    public bhm() {
        AppMethodBeat.i(153147);
        AppMethodBeat.o(153147);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153148);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(153148);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 6, this.LRZ);
            aVar.aM(3, this.LSa);
            aVar.aM(4, this.Timestamp);
            aVar.e(5, 2, this.LSb);
            AppMethodBeat.o(153148);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 6, this.LRZ) + g.a.a.b.b.a.bu(3, this.LSa) + g.a.a.b.b.a.bu(4, this.Timestamp) + g.a.a.a.c(5, 2, this.LSb);
            AppMethodBeat.o(153148);
            return nh;
        } else if (i2 == 2) {
            this.LRZ.clear();
            this.LSb.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(153148);
                throw bVar2;
            }
            AppMethodBeat.o(153148);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhm bhm = (bhm) objArr[1];
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
                        bhm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(153148);
                    return 0;
                case 2:
                    bhm.LRZ.add(aVar3.UbS.hPo());
                    AppMethodBeat.o(153148);
                    return 0;
                case 3:
                    bhm.LSa = aVar3.UbS.zi();
                    AppMethodBeat.o(153148);
                    return 0;
                case 4:
                    bhm.Timestamp = aVar3.UbS.zi();
                    AppMethodBeat.o(153148);
                    return 0;
                case 5:
                    bhm.LSb.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(153148);
                    return 0;
                default:
                    AppMethodBeat.o(153148);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153148);
            return -1;
        }
    }
}
