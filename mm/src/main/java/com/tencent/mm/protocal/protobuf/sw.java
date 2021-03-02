package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class sw extends dpc {
    public LinkedList<Integer> LaO = new LinkedList<>();
    public st LaP;
    public LinkedList<ss> LaQ = new LinkedList<>();

    public sw() {
        AppMethodBeat.i(226019);
        AppMethodBeat.o(226019);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(226020);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(226020);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 2, this.LaO);
            if (this.LaP != null) {
                aVar.ni(3, this.LaP.computeSize());
                this.LaP.writeFields(aVar);
            }
            aVar.e(4, 8, this.LaQ);
            AppMethodBeat.o(226020);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 2, this.LaO);
            if (this.LaP != null) {
                nh += g.a.a.a.nh(3, this.LaP.computeSize());
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.LaQ);
            AppMethodBeat.o(226020);
            return c2;
        } else if (i2 == 2) {
            this.LaO.clear();
            this.LaQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(226020);
                throw bVar2;
            }
            AppMethodBeat.o(226020);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sw swVar = (sw) objArr[1];
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
                        swVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(226020);
                    return 0;
                case 2:
                    swVar.LaO.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(226020);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        st stVar = new st();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = stVar.populateBuilderWithField(aVar5, stVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        swVar.LaP = stVar;
                    }
                    AppMethodBeat.o(226020);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ss ssVar = new ss();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ssVar.populateBuilderWithField(aVar6, ssVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        swVar.LaQ.add(ssVar);
                    }
                    AppMethodBeat.o(226020);
                    return 0;
                default:
                    AppMethodBeat.o(226020);
                    return -1;
            }
        } else {
            AppMethodBeat.o(226020);
            return -1;
        }
    }
}
