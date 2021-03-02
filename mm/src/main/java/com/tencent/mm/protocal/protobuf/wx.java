package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wx extends dpc {
    public int CpN;
    public String Cxg;
    public String Cxh;
    public String LhU;
    public boolean LhV;
    public int dDN;
    public String qwn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72449);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72449);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dDN);
            if (this.qwn != null) {
                aVar.e(3, this.qwn);
            }
            if (this.LhU != null) {
                aVar.e(4, this.LhU);
            }
            if (this.Cxg != null) {
                aVar.e(5, this.Cxg);
            }
            aVar.cc(6, this.LhV);
            if (this.Cxh != null) {
                aVar.e(7, this.Cxh);
            }
            aVar.aM(8, this.CpN);
            AppMethodBeat.o(72449);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.LhU != null) {
                nh += g.a.a.b.b.a.f(4, this.LhU);
            }
            if (this.Cxg != null) {
                nh += g.a.a.b.b.a.f(5, this.Cxg);
            }
            int fS = nh + g.a.a.b.b.a.fS(6) + 1;
            if (this.Cxh != null) {
                fS += g.a.a.b.b.a.f(7, this.Cxh);
            }
            int bu = fS + g.a.a.b.b.a.bu(8, this.CpN);
            AppMethodBeat.o(72449);
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
                AppMethodBeat.o(72449);
                throw bVar2;
            }
            AppMethodBeat.o(72449);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wx wxVar = (wx) objArr[1];
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
                        wxVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72449);
                    return 0;
                case 2:
                    wxVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(72449);
                    return 0;
                case 3:
                    wxVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(72449);
                    return 0;
                case 4:
                    wxVar.LhU = aVar3.UbS.readString();
                    AppMethodBeat.o(72449);
                    return 0;
                case 5:
                    wxVar.Cxg = aVar3.UbS.readString();
                    AppMethodBeat.o(72449);
                    return 0;
                case 6:
                    wxVar.LhV = aVar3.UbS.yZ();
                    AppMethodBeat.o(72449);
                    return 0;
                case 7:
                    wxVar.Cxh = aVar3.UbS.readString();
                    AppMethodBeat.o(72449);
                    return 0;
                case 8:
                    wxVar.CpN = aVar3.UbS.zi();
                    AppMethodBeat.o(72449);
                    return 0;
                default:
                    AppMethodBeat.o(72449);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72449);
            return -1;
        }
    }
}
