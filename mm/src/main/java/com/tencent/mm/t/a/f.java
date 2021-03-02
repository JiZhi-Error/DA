package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class f extends dpc {
    public String gTl;
    public j gTo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194678);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(194678);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.gTl != null) {
                aVar.e(2, this.gTl);
            }
            if (this.gTo != null) {
                aVar.ni(3, this.gTo.computeSize());
                this.gTo.writeFields(aVar);
            }
            AppMethodBeat.o(194678);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.gTl != null) {
                nh += g.a.a.b.b.a.f(2, this.gTl);
            }
            if (this.gTo != null) {
                nh += g.a.a.a.nh(3, this.gTo.computeSize());
            }
            AppMethodBeat.o(194678);
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
                AppMethodBeat.o(194678);
                throw bVar2;
            }
            AppMethodBeat.o(194678);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
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
                        fVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(194678);
                    return 0;
                case 2:
                    fVar.gTl = aVar3.UbS.readString();
                    AppMethodBeat.o(194678);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        j jVar = new j();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jVar.populateBuilderWithField(aVar5, jVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        fVar.gTo = jVar;
                    }
                    AppMethodBeat.o(194678);
                    return 0;
                default:
                    AppMethodBeat.o(194678);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194678);
            return -1;
        }
    }
}
