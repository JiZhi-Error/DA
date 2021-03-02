package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class epk extends dpc {
    public LinkedList<String> Nnj = new LinkedList<>();
    public int rBL;
    public String rBM;

    public epk() {
        AppMethodBeat.i(82484);
        AppMethodBeat.o(82484);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82485);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82485);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.rBL);
            if (this.rBM != null) {
                aVar.e(3, this.rBM);
            }
            aVar.e(4, 1, this.Nnj);
            AppMethodBeat.o(82485);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.rBL);
            if (this.rBM != null) {
                nh += g.a.a.b.b.a.f(3, this.rBM);
            }
            int c2 = nh + g.a.a.a.c(4, 1, this.Nnj);
            AppMethodBeat.o(82485);
            return c2;
        } else if (i2 == 2) {
            this.Nnj.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82485);
                throw bVar2;
            }
            AppMethodBeat.o(82485);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epk epk = (epk) objArr[1];
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
                        epk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(82485);
                    return 0;
                case 2:
                    epk.rBL = aVar3.UbS.zi();
                    AppMethodBeat.o(82485);
                    return 0;
                case 3:
                    epk.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(82485);
                    return 0;
                case 4:
                    epk.Nnj.add(aVar3.UbS.readString());
                    AppMethodBeat.o(82485);
                    return 0;
                default:
                    AppMethodBeat.o(82485);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82485);
            return -1;
        }
    }
}
