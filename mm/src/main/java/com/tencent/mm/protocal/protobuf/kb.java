package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class kb extends dpc {
    public LinkedList<String> KMy = new LinkedList<>();
    public LinkedList<ait> KOp = new LinkedList<>();
    public int jeU;
    public int xuA;

    public kb() {
        AppMethodBeat.i(104757);
        AppMethodBeat.o(104757);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104758);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104758);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.xuA);
            aVar.e(3, 1, this.KMy);
            aVar.aM(4, this.jeU);
            aVar.e(5, 8, this.KOp);
            AppMethodBeat.o(104758);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xuA) + g.a.a.a.c(3, 1, this.KMy) + g.a.a.b.b.a.bu(4, this.jeU) + g.a.a.a.c(5, 8, this.KOp);
            AppMethodBeat.o(104758);
            return nh;
        } else if (i2 == 2) {
            this.KMy.clear();
            this.KOp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104758);
                throw bVar2;
            }
            AppMethodBeat.o(104758);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            kb kbVar = (kb) objArr[1];
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
                        kbVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104758);
                    return 0;
                case 2:
                    kbVar.xuA = aVar3.UbS.zi();
                    AppMethodBeat.o(104758);
                    return 0;
                case 3:
                    kbVar.KMy.add(aVar3.UbS.readString());
                    AppMethodBeat.o(104758);
                    return 0;
                case 4:
                    kbVar.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(104758);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ait ait = new ait();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ait.populateBuilderWithField(aVar5, ait, dpc.getNextFieldNumber(aVar5))) {
                        }
                        kbVar.KOp.add(ait);
                    }
                    AppMethodBeat.o(104758);
                    return 0;
                default:
                    AppMethodBeat.o(104758);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104758);
            return -1;
        }
    }
}
