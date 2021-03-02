package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class e extends dpc {
    public String Brh;
    public int Brk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198595);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(198595);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Brh != null) {
                aVar.e(2, this.Brh);
            }
            aVar.aM(3, this.Brk);
            AppMethodBeat.o(198595);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Brh != null) {
                nh += g.a.a.b.b.a.f(2, this.Brh);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.Brk);
            AppMethodBeat.o(198595);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(198595);
                throw bVar2;
            }
            AppMethodBeat.o(198595);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
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
                        eVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(198595);
                    return 0;
                case 2:
                    eVar.Brh = aVar3.UbS.readString();
                    AppMethodBeat.o(198595);
                    return 0;
                case 3:
                    eVar.Brk = aVar3.UbS.zi();
                    AppMethodBeat.o(198595);
                    return 0;
                default:
                    AppMethodBeat.o(198595);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198595);
            return -1;
        }
    }
}
