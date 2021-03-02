package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bld extends dpc {
    public int LUb;
    public int LUc;
    public int LUd;
    public int LUe;
    public String LUf;
    public int LUg;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101813);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(101813);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.oTW);
            aVar.aM(3, this.LUb);
            aVar.aM(4, this.LUc);
            aVar.aM(5, this.LUd);
            aVar.aM(6, this.LUe);
            if (this.LUf != null) {
                aVar.e(7, this.LUf);
            }
            aVar.aM(8, this.LUg);
            AppMethodBeat.o(101813);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTW) + g.a.a.b.b.a.bu(3, this.LUb) + g.a.a.b.b.a.bu(4, this.LUc) + g.a.a.b.b.a.bu(5, this.LUd) + g.a.a.b.b.a.bu(6, this.LUe);
            if (this.LUf != null) {
                nh += g.a.a.b.b.a.f(7, this.LUf);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.LUg);
            AppMethodBeat.o(101813);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(101813);
                throw bVar2;
            }
            AppMethodBeat.o(101813);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bld bld = (bld) objArr[1];
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
                        bld.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(101813);
                    return 0;
                case 2:
                    bld.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(101813);
                    return 0;
                case 3:
                    bld.LUb = aVar3.UbS.zi();
                    AppMethodBeat.o(101813);
                    return 0;
                case 4:
                    bld.LUc = aVar3.UbS.zi();
                    AppMethodBeat.o(101813);
                    return 0;
                case 5:
                    bld.LUd = aVar3.UbS.zi();
                    AppMethodBeat.o(101813);
                    return 0;
                case 6:
                    bld.LUe = aVar3.UbS.zi();
                    AppMethodBeat.o(101813);
                    return 0;
                case 7:
                    bld.LUf = aVar3.UbS.readString();
                    AppMethodBeat.o(101813);
                    return 0;
                case 8:
                    bld.LUg = aVar3.UbS.zi();
                    AppMethodBeat.o(101813);
                    return 0;
                default:
                    AppMethodBeat.o(101813);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101813);
            return -1;
        }
    }
}
