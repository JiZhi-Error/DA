package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bae extends dpc {
    public int continueFlag;
    public b lastBuffer;
    public LinkedList<FinderObject> object = new LinkedList<>();

    public bae() {
        AppMethodBeat.i(169033);
        AppMethodBeat.o(169033);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169034);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(169034);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.object);
            aVar.aM(3, this.continueFlag);
            if (this.lastBuffer != null) {
                aVar.c(4, this.lastBuffer);
            }
            AppMethodBeat.o(169034);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.object) + g.a.a.b.b.a.bu(3, this.continueFlag);
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(4, this.lastBuffer);
            }
            AppMethodBeat.o(169034);
            return nh;
        } else if (i2 == 2) {
            this.object.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(169034);
                throw bVar2;
            }
            AppMethodBeat.o(169034);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bae bae = (bae) objArr[1];
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
                        bae.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(169034);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bae.object.add(finderObject);
                    }
                    AppMethodBeat.o(169034);
                    return 0;
                case 3:
                    bae.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169034);
                    return 0;
                case 4:
                    bae.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(169034);
                    return 0;
                default:
                    AppMethodBeat.o(169034);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169034);
            return -1;
        }
    }
}
