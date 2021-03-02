package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dsm extends dpc {
    public dsk MUQ;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152687);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152687);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MUQ != null) {
                aVar.ni(2, this.MUQ.computeSize());
                this.MUQ.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            AppMethodBeat.o(152687);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MUQ != null) {
                nh += g.a.a.a.nh(2, this.MUQ.computeSize());
            }
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(3, this.url);
            }
            AppMethodBeat.o(152687);
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
                AppMethodBeat.o(152687);
                throw bVar2;
            }
            AppMethodBeat.o(152687);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsm dsm = (dsm) objArr[1];
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
                        dsm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152687);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dsk dsk = new dsk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dsk.populateBuilderWithField(aVar5, dsk, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dsm.MUQ = dsk;
                    }
                    AppMethodBeat.o(152687);
                    return 0;
                case 3:
                    dsm.url = aVar3.UbS.readString();
                    AppMethodBeat.o(152687);
                    return 0;
                default:
                    AppMethodBeat.o(152687);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152687);
            return -1;
        }
    }
}
