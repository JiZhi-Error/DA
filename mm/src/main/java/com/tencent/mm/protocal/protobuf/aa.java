package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aa extends dpc {
    public String KCg;
    public int KCh;
    public int KCi;
    public String KCj;
    public String KCk;
    public int dDN = 268513600;
    public LinkedList<m> dkr = new LinkedList<>();
    public String qwn = "请求不成功，请稍候再试";

    public aa() {
        AppMethodBeat.i(91337);
        AppMethodBeat.o(91337);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91338);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91338);
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
            aVar.e(4, 8, this.dkr);
            if (this.KCk != null) {
                aVar.e(5, this.KCk);
            }
            if (this.KCg != null) {
                aVar.e(6, this.KCg);
            }
            aVar.aM(7, this.KCh);
            aVar.aM(8, this.KCi);
            if (this.KCj != null) {
                aVar.e(9, this.KCj);
            }
            AppMethodBeat.o(91338);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.dkr);
            if (this.KCk != null) {
                c2 += g.a.a.b.b.a.f(5, this.KCk);
            }
            if (this.KCg != null) {
                c2 += g.a.a.b.b.a.f(6, this.KCg);
            }
            int bu = c2 + g.a.a.b.b.a.bu(7, this.KCh) + g.a.a.b.b.a.bu(8, this.KCi);
            if (this.KCj != null) {
                bu += g.a.a.b.b.a.f(9, this.KCj);
            }
            AppMethodBeat.o(91338);
            return bu;
        } else if (i2 == 2) {
            this.dkr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91338);
                throw bVar2;
            }
            AppMethodBeat.o(91338);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
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
                        aaVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91338);
                    return 0;
                case 2:
                    aaVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91338);
                    return 0;
                case 3:
                    aaVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91338);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        m mVar = new m();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = mVar.populateBuilderWithField(aVar5, mVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aaVar.dkr.add(mVar);
                    }
                    AppMethodBeat.o(91338);
                    return 0;
                case 5:
                    aaVar.KCk = aVar3.UbS.readString();
                    AppMethodBeat.o(91338);
                    return 0;
                case 6:
                    aaVar.KCg = aVar3.UbS.readString();
                    AppMethodBeat.o(91338);
                    return 0;
                case 7:
                    aaVar.KCh = aVar3.UbS.zi();
                    AppMethodBeat.o(91338);
                    return 0;
                case 8:
                    aaVar.KCi = aVar3.UbS.zi();
                    AppMethodBeat.o(91338);
                    return 0;
                case 9:
                    aaVar.KCj = aVar3.UbS.readString();
                    AppMethodBeat.o(91338);
                    return 0;
                default:
                    AppMethodBeat.o(91338);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91338);
            return -1;
        }
    }
}
