package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class pr extends dpc {
    public int KHa;
    public int KSO;
    public String KWF;
    public long KWz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(224536);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(224536);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.KWz);
            aVar.aM(3, this.KHa);
            aVar.aM(4, this.KSO);
            if (this.KWF != null) {
                aVar.e(5, this.KWF);
            }
            AppMethodBeat.o(224536);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.KWz) + g.a.a.b.b.a.bu(3, this.KHa) + g.a.a.b.b.a.bu(4, this.KSO);
            if (this.KWF != null) {
                nh += g.a.a.b.b.a.f(5, this.KWF);
            }
            AppMethodBeat.o(224536);
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
                AppMethodBeat.o(224536);
                throw bVar2;
            }
            AppMethodBeat.o(224536);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pr prVar = (pr) objArr[1];
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
                        prVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(224536);
                    return 0;
                case 2:
                    prVar.KWz = aVar3.UbS.zl();
                    AppMethodBeat.o(224536);
                    return 0;
                case 3:
                    prVar.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(224536);
                    return 0;
                case 4:
                    prVar.KSO = aVar3.UbS.zi();
                    AppMethodBeat.o(224536);
                    return 0;
                case 5:
                    prVar.KWF = aVar3.UbS.readString();
                    AppMethodBeat.o(224536);
                    return 0;
                default:
                    AppMethodBeat.o(224536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(224536);
            return -1;
        }
    }
}