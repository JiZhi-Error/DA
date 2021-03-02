package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aag extends dpc {
    public int Llr;
    public String gzC;
    public String nickname;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82397);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82397);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.gzC != null) {
                aVar.e(3, this.gzC);
            }
            aVar.aM(4, this.Llr);
            AppMethodBeat.o(82397);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.nickname != null) {
                nh += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.gzC != null) {
                nh += g.a.a.b.b.a.f(3, this.gzC);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Llr);
            AppMethodBeat.o(82397);
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
                AppMethodBeat.o(82397);
                throw bVar2;
            }
            AppMethodBeat.o(82397);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aag aag = (aag) objArr[1];
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
                        aag.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(82397);
                    return 0;
                case 2:
                    aag.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(82397);
                    return 0;
                case 3:
                    aag.gzC = aVar3.UbS.readString();
                    AppMethodBeat.o(82397);
                    return 0;
                case 4:
                    aag.Llr = aVar3.UbS.zi();
                    AppMethodBeat.o(82397);
                    return 0;
                default:
                    AppMethodBeat.o(82397);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82397);
            return -1;
        }
    }
}
