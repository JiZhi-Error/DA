package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dnj extends dpc {
    public int LVH;
    public LinkedList<Integer> LVI = new LinkedList<>();
    public LinkedList<akh> LVJ = new LinkedList<>();
    public int MQC;

    public dnj() {
        AppMethodBeat.i(220724);
        AppMethodBeat.o(220724);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220725);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(220725);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LVH);
            aVar.aM(3, this.MQC);
            aVar.e(4, 8, this.LVJ);
            aVar.e(5, 2, this.LVI);
            AppMethodBeat.o(220725);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LVH) + g.a.a.b.b.a.bu(3, this.MQC) + g.a.a.a.c(4, 8, this.LVJ) + g.a.a.a.c(5, 2, this.LVI);
            AppMethodBeat.o(220725);
            return nh;
        } else if (i2 == 2) {
            this.LVJ.clear();
            this.LVI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(220725);
                throw bVar2;
            }
            AppMethodBeat.o(220725);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dnj dnj = (dnj) objArr[1];
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
                        dnj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(220725);
                    return 0;
                case 2:
                    dnj.LVH = aVar3.UbS.zi();
                    AppMethodBeat.o(220725);
                    return 0;
                case 3:
                    dnj.MQC = aVar3.UbS.zi();
                    AppMethodBeat.o(220725);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        akh akh = new akh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = akh.populateBuilderWithField(aVar5, akh, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dnj.LVJ.add(akh);
                    }
                    AppMethodBeat.o(220725);
                    return 0;
                case 5:
                    dnj.LVI.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(220725);
                    return 0;
                default:
                    AppMethodBeat.o(220725);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220725);
            return -1;
        }
    }
}
