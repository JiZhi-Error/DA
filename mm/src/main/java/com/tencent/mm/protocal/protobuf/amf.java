package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class amf extends dpc {
    public String Bri;
    public String KGO;
    public LinkedList<amg> KGQ = new LinkedList<>();
    public int gsq;

    public amf() {
        AppMethodBeat.i(32208);
        AppMethodBeat.o(32208);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32209);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32209);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Bri != null) {
                aVar.e(2, this.Bri);
            }
            aVar.aM(3, this.gsq);
            aVar.e(4, 8, this.KGQ);
            if (this.KGO != null) {
                aVar.e(5, this.KGO);
            }
            AppMethodBeat.o(32209);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Bri != null) {
                nh += g.a.a.b.b.a.f(2, this.Bri);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.gsq) + g.a.a.a.c(4, 8, this.KGQ);
            if (this.KGO != null) {
                bu += g.a.a.b.b.a.f(5, this.KGO);
            }
            AppMethodBeat.o(32209);
            return bu;
        } else if (i2 == 2) {
            this.KGQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32209);
                throw bVar2;
            }
            AppMethodBeat.o(32209);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amf amf = (amf) objArr[1];
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
                        amf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32209);
                    return 0;
                case 2:
                    amf.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(32209);
                    return 0;
                case 3:
                    amf.gsq = aVar3.UbS.zi();
                    AppMethodBeat.o(32209);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        amg amg = new amg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = amg.populateBuilderWithField(aVar5, amg, dpc.getNextFieldNumber(aVar5))) {
                        }
                        amf.KGQ.add(amg);
                    }
                    AppMethodBeat.o(32209);
                    return 0;
                case 5:
                    amf.KGO = aVar3.UbS.readString();
                    AppMethodBeat.o(32209);
                    return 0;
                default:
                    AppMethodBeat.o(32209);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32209);
            return -1;
        }
    }
}
