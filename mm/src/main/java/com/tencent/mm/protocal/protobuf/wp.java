package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wp extends dpc {
    public String KHN;
    public String LhB;
    public String LhN;
    public String Lhy;
    public String Lhz;
    public int dDN;
    public String dNQ;
    public String qwn;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72438);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72438);
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
            if (this.dNQ != null) {
                aVar.e(4, this.dNQ);
            }
            if (this.LhB != null) {
                aVar.e(5, this.LhB);
            }
            if (this.KHN != null) {
                aVar.e(6, this.KHN);
            }
            aVar.aM(7, this.yRL);
            if (this.LhN != null) {
                aVar.e(8, this.LhN);
            }
            if (this.Lhz != null) {
                aVar.e(9, this.Lhz);
            }
            if (this.Lhy != null) {
                aVar.e(10, this.Lhy);
            }
            AppMethodBeat.o(72438);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.dNQ != null) {
                nh += g.a.a.b.b.a.f(4, this.dNQ);
            }
            if (this.LhB != null) {
                nh += g.a.a.b.b.a.f(5, this.LhB);
            }
            if (this.KHN != null) {
                nh += g.a.a.b.b.a.f(6, this.KHN);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.yRL);
            if (this.LhN != null) {
                bu += g.a.a.b.b.a.f(8, this.LhN);
            }
            if (this.Lhz != null) {
                bu += g.a.a.b.b.a.f(9, this.Lhz);
            }
            if (this.Lhy != null) {
                bu += g.a.a.b.b.a.f(10, this.Lhy);
            }
            AppMethodBeat.o(72438);
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
                AppMethodBeat.o(72438);
                throw bVar2;
            }
            AppMethodBeat.o(72438);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wp wpVar = (wp) objArr[1];
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
                        wpVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72438);
                    return 0;
                case 2:
                    wpVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(72438);
                    return 0;
                case 3:
                    wpVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(72438);
                    return 0;
                case 4:
                    wpVar.dNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(72438);
                    return 0;
                case 5:
                    wpVar.LhB = aVar3.UbS.readString();
                    AppMethodBeat.o(72438);
                    return 0;
                case 6:
                    wpVar.KHN = aVar3.UbS.readString();
                    AppMethodBeat.o(72438);
                    return 0;
                case 7:
                    wpVar.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(72438);
                    return 0;
                case 8:
                    wpVar.LhN = aVar3.UbS.readString();
                    AppMethodBeat.o(72438);
                    return 0;
                case 9:
                    wpVar.Lhz = aVar3.UbS.readString();
                    AppMethodBeat.o(72438);
                    return 0;
                case 10:
                    wpVar.Lhy = aVar3.UbS.readString();
                    AppMethodBeat.o(72438);
                    return 0;
                default:
                    AppMethodBeat.o(72438);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72438);
            return -1;
        }
    }
}
