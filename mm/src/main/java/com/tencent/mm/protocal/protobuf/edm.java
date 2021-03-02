package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class edm extends dpc {
    public int KCC;
    public int KZh;
    public LinkedList<eea> NdM = new LinkedList<>();
    public long NdN;
    public int Ndu;

    public edm() {
        AppMethodBeat.i(118445);
        AppMethodBeat.o(118445);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118446);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(118446);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.Ndu);
            aVar.e(3, 8, this.NdM);
            aVar.bb(4, this.NdN);
            aVar.aM(5, this.KZh);
            aVar.aM(6, this.KCC);
            AppMethodBeat.o(118446);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Ndu) + g.a.a.a.c(3, 8, this.NdM) + g.a.a.b.b.a.r(4, this.NdN) + g.a.a.b.b.a.bu(5, this.KZh) + g.a.a.b.b.a.bu(6, this.KCC);
            AppMethodBeat.o(118446);
            return nh;
        } else if (i2 == 2) {
            this.NdM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(118446);
                throw bVar2;
            }
            AppMethodBeat.o(118446);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edm edm = (edm) objArr[1];
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
                        edm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(118446);
                    return 0;
                case 2:
                    edm.Ndu = aVar3.UbS.zi();
                    AppMethodBeat.o(118446);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eea eea = new eea();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eea.populateBuilderWithField(aVar5, eea, dpc.getNextFieldNumber(aVar5))) {
                        }
                        edm.NdM.add(eea);
                    }
                    AppMethodBeat.o(118446);
                    return 0;
                case 4:
                    edm.NdN = aVar3.UbS.zl();
                    AppMethodBeat.o(118446);
                    return 0;
                case 5:
                    edm.KZh = aVar3.UbS.zi();
                    AppMethodBeat.o(118446);
                    return 0;
                case 6:
                    edm.KCC = aVar3.UbS.zi();
                    AppMethodBeat.o(118446);
                    return 0;
                default:
                    AppMethodBeat.o(118446);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118446);
            return -1;
        }
    }
}
