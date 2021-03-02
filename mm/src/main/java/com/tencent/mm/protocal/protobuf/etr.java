package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class etr extends dpc {
    public int LsZ;
    public long Lta;
    public int MKr;
    public int MyU;
    public int NqR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115877);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(115877);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            aVar.aM(4, this.MKr);
            aVar.aM(5, this.MyU);
            aVar.aM(6, this.NqR);
            AppMethodBeat.o(115877);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.MKr) + g.a.a.b.b.a.bu(5, this.MyU) + g.a.a.b.b.a.bu(6, this.NqR);
            AppMethodBeat.o(115877);
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
                AppMethodBeat.o(115877);
                throw bVar2;
            }
            AppMethodBeat.o(115877);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etr etr = (etr) objArr[1];
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
                        etr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(115877);
                    return 0;
                case 2:
                    etr.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115877);
                    return 0;
                case 3:
                    etr.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115877);
                    return 0;
                case 4:
                    etr.MKr = aVar3.UbS.zi();
                    AppMethodBeat.o(115877);
                    return 0;
                case 5:
                    etr.MyU = aVar3.UbS.zi();
                    AppMethodBeat.o(115877);
                    return 0;
                case 6:
                    etr.NqR = aVar3.UbS.zi();
                    AppMethodBeat.o(115877);
                    return 0;
                default:
                    AppMethodBeat.o(115877);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115877);
            return -1;
        }
    }
}
