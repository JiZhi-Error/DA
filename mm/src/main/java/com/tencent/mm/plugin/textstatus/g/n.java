package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class n extends dpc {
    public b GaF;
    public boolean GaH;
    public LinkedList<u> GaK = new LinkedList<>();

    public n() {
        AppMethodBeat.i(222833);
        AppMethodBeat.o(222833);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222834);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(222834);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.GaK);
            if (this.GaF != null) {
                aVar.c(3, this.GaF);
            }
            aVar.cc(4, this.GaH);
            AppMethodBeat.o(222834);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.GaK);
            if (this.GaF != null) {
                nh += g.a.a.b.b.a.b(3, this.GaF);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(222834);
            return fS;
        } else if (i2 == 2) {
            this.GaK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(222834);
                throw bVar2;
            }
            AppMethodBeat.o(222834);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
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
                        nVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(222834);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        u uVar = new u();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = uVar.populateBuilderWithField(aVar5, uVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        nVar.GaK.add(uVar);
                    }
                    AppMethodBeat.o(222834);
                    return 0;
                case 3:
                    nVar.GaF = aVar3.UbS.hPo();
                    AppMethodBeat.o(222834);
                    return 0;
                case 4:
                    nVar.GaH = aVar3.UbS.yZ();
                    AppMethodBeat.o(222834);
                    return 0;
                default:
                    AppMethodBeat.o(222834);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222834);
            return -1;
        }
    }
}
