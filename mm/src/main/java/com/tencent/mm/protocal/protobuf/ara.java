package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ara extends dpc {
    public int LCN;
    public String thumbUrl;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209387);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(209387);
                throw bVar;
            }
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.thumbUrl != null) {
                aVar.e(2, this.thumbUrl);
            }
            aVar.aM(3, this.LCN);
            if (this.BaseResponse != null) {
                aVar.ni(4, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            AppMethodBeat.o(209387);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0;
            if (this.thumbUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.thumbUrl);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.LCN);
            if (this.BaseResponse != null) {
                bu += g.a.a.a.nh(4, this.BaseResponse.computeSize());
            }
            AppMethodBeat.o(209387);
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
                AppMethodBeat.o(209387);
                throw bVar2;
            }
            AppMethodBeat.o(209387);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ara ara = (ara) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ara.url = aVar3.UbS.readString();
                    AppMethodBeat.o(209387);
                    return 0;
                case 2:
                    ara.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209387);
                    return 0;
                case 3:
                    ara.LCN = aVar3.UbS.zi();
                    AppMethodBeat.o(209387);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        ara.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209387);
                    return 0;
                default:
                    AppMethodBeat.o(209387);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209387);
            return -1;
        }
    }
}
