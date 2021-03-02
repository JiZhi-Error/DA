package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class nn extends dpc {
    public b KSW;
    public LinkedList<no> KSX = new LinkedList<>();

    public nn() {
        AppMethodBeat.i(124407);
        AppMethodBeat.o(124407);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124408);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124408);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.KSW != null) {
                aVar.c(2, this.KSW);
            }
            aVar.e(3, 8, this.KSX);
            AppMethodBeat.o(124408);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KSW != null) {
                nh += g.a.a.b.b.a.b(2, this.KSW);
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.KSX);
            AppMethodBeat.o(124408);
            return c2;
        } else if (i2 == 2) {
            this.KSX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124408);
                throw bVar2;
            }
            AppMethodBeat.o(124408);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nn nnVar = (nn) objArr[1];
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
                        nnVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124408);
                    return 0;
                case 2:
                    nnVar.KSW = aVar3.UbS.hPo();
                    AppMethodBeat.o(124408);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        no noVar = new no();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = noVar.populateBuilderWithField(aVar5, noVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        nnVar.KSX.add(noVar);
                    }
                    AppMethodBeat.o(124408);
                    return 0;
                default:
                    AppMethodBeat.o(124408);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124408);
            return -1;
        }
    }
}
