package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class b extends dpc {
    public LinkedList<Integer> UAq = new LinkedList<>();
    public LinkedList<c> UAr = new LinkedList<>();

    public b() {
        AppMethodBeat.i(261966);
        AppMethodBeat.o(261966);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261967);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 2, this.UAq);
            aVar.e(3, 8, this.UAr);
            AppMethodBeat.o(261967);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 2, this.UAq) + g.a.a.a.c(3, 8, this.UAr);
            AppMethodBeat.o(261967);
            return nh;
        } else if (i2 == 2) {
            this.UAq.clear();
            this.UAr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(261967);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
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
                        bVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(261967);
                    return 0;
                case 2:
                    bVar.UAq.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(261967);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        c cVar = new c();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cVar.populateBuilderWithField(aVar5, cVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bVar.UAr.add(cVar);
                    }
                    AppMethodBeat.o(261967);
                    return 0;
                default:
                    AppMethodBeat.o(261967);
                    return -1;
            }
        } else {
            AppMethodBeat.o(261967);
            return -1;
        }
    }
}
