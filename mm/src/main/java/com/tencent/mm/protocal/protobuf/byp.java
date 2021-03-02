package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class byp extends dpc {
    public long LWJ;
    public String LWK;
    public String LWL;
    public abq LWM;
    public long LoC;
    public String MdW;
    public boolean MdX = false;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214310);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214310);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.LoC);
            aVar.bb(3, this.LWJ);
            if (this.MdW != null) {
                aVar.e(4, this.MdW);
            }
            if (this.LWK != null) {
                aVar.e(5, this.LWK);
            }
            aVar.cc(6, this.MdX);
            if (this.LWL != null) {
                aVar.e(7, this.LWL);
            }
            if (this.LWM != null) {
                aVar.ni(8, this.LWM.computeSize());
                this.LWM.writeFields(aVar);
            }
            AppMethodBeat.o(214310);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.LoC) + g.a.a.b.b.a.r(3, this.LWJ);
            if (this.MdW != null) {
                nh += g.a.a.b.b.a.f(4, this.MdW);
            }
            if (this.LWK != null) {
                nh += g.a.a.b.b.a.f(5, this.LWK);
            }
            int fS = nh + g.a.a.b.b.a.fS(6) + 1;
            if (this.LWL != null) {
                fS += g.a.a.b.b.a.f(7, this.LWL);
            }
            if (this.LWM != null) {
                fS += g.a.a.a.nh(8, this.LWM.computeSize());
            }
            AppMethodBeat.o(214310);
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
                AppMethodBeat.o(214310);
                throw bVar2;
            }
            AppMethodBeat.o(214310);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            byp byp = (byp) objArr[1];
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
                        byp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(214310);
                    return 0;
                case 2:
                    byp.LoC = aVar3.UbS.zl();
                    AppMethodBeat.o(214310);
                    return 0;
                case 3:
                    byp.LWJ = aVar3.UbS.zl();
                    AppMethodBeat.o(214310);
                    return 0;
                case 4:
                    byp.MdW = aVar3.UbS.readString();
                    AppMethodBeat.o(214310);
                    return 0;
                case 5:
                    byp.LWK = aVar3.UbS.readString();
                    AppMethodBeat.o(214310);
                    return 0;
                case 6:
                    byp.MdX = aVar3.UbS.yZ();
                    AppMethodBeat.o(214310);
                    return 0;
                case 7:
                    byp.LWL = aVar3.UbS.readString();
                    AppMethodBeat.o(214310);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        abq abq = new abq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = abq.populateBuilderWithField(aVar5, abq, dpc.getNextFieldNumber(aVar5))) {
                        }
                        byp.LWM = abq;
                    }
                    AppMethodBeat.o(214310);
                    return 0;
                default:
                    AppMethodBeat.o(214310);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214310);
            return -1;
        }
    }
}
