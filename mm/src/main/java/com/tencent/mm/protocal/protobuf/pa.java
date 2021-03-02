package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class pa extends dpc {
    public int KND;
    public String KRB;
    public long KRi;
    public boolean KVU;
    public String dNQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212248);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(212248);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.KRB != null) {
                aVar.e(2, this.KRB);
            }
            if (this.dNQ != null) {
                aVar.e(3, this.dNQ);
            }
            aVar.cc(4, this.KVU);
            aVar.bb(11, this.KRi);
            aVar.aM(15, this.KND);
            AppMethodBeat.o(212248);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KRB != null) {
                nh += g.a.a.b.b.a.f(2, this.KRB);
            }
            if (this.dNQ != null) {
                nh += g.a.a.b.b.a.f(3, this.dNQ);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.r(11, this.KRi) + g.a.a.b.b.a.bu(15, this.KND);
            AppMethodBeat.o(212248);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(212248);
                throw bVar2;
            }
            AppMethodBeat.o(212248);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pa paVar = (pa) objArr[1];
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
                        paVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(212248);
                    return 0;
                case 2:
                    paVar.KRB = aVar3.UbS.readString();
                    AppMethodBeat.o(212248);
                    return 0;
                case 3:
                    paVar.dNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(212248);
                    return 0;
                case 4:
                    paVar.KVU = aVar3.UbS.yZ();
                    AppMethodBeat.o(212248);
                    return 0;
                case 11:
                    paVar.KRi = aVar3.UbS.zl();
                    AppMethodBeat.o(212248);
                    return 0;
                case 15:
                    paVar.KND = aVar3.UbS.zi();
                    AppMethodBeat.o(212248);
                    return 0;
                default:
                    AppMethodBeat.o(212248);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212248);
            return -1;
        }
    }
}
