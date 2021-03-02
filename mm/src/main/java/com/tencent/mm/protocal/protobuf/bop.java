package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bop extends dpc {
    public long LWJ;
    public String LWK;
    public String LWL;
    public abq LWM;
    public djt LWN;
    public String LWO;
    public boolean LWP = true;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214302);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214302);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.LWJ);
            if (this.LWK != null) {
                aVar.e(3, this.LWK);
            }
            if (this.LWL != null) {
                aVar.e(4, this.LWL);
            }
            if (this.LWM != null) {
                aVar.ni(5, this.LWM.computeSize());
                this.LWM.writeFields(aVar);
            }
            if (this.LWN != null) {
                aVar.ni(6, this.LWN.computeSize());
                this.LWN.writeFields(aVar);
            }
            if (this.LWO != null) {
                aVar.e(7, this.LWO);
            }
            aVar.cc(8, this.LWP);
            AppMethodBeat.o(214302);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.LWJ);
            if (this.LWK != null) {
                nh += g.a.a.b.b.a.f(3, this.LWK);
            }
            if (this.LWL != null) {
                nh += g.a.a.b.b.a.f(4, this.LWL);
            }
            if (this.LWM != null) {
                nh += g.a.a.a.nh(5, this.LWM.computeSize());
            }
            if (this.LWN != null) {
                nh += g.a.a.a.nh(6, this.LWN.computeSize());
            }
            if (this.LWO != null) {
                nh += g.a.a.b.b.a.f(7, this.LWO);
            }
            int fS = nh + g.a.a.b.b.a.fS(8) + 1;
            AppMethodBeat.o(214302);
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
                AppMethodBeat.o(214302);
                throw bVar2;
            }
            AppMethodBeat.o(214302);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bop bop = (bop) objArr[1];
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
                        bop.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(214302);
                    return 0;
                case 2:
                    bop.LWJ = aVar3.UbS.zl();
                    AppMethodBeat.o(214302);
                    return 0;
                case 3:
                    bop.LWK = aVar3.UbS.readString();
                    AppMethodBeat.o(214302);
                    return 0;
                case 4:
                    bop.LWL = aVar3.UbS.readString();
                    AppMethodBeat.o(214302);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        abq abq = new abq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = abq.populateBuilderWithField(aVar5, abq, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bop.LWM = abq;
                    }
                    AppMethodBeat.o(214302);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        djt djt = new djt();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = djt.populateBuilderWithField(aVar6, djt, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bop.LWN = djt;
                    }
                    AppMethodBeat.o(214302);
                    return 0;
                case 7:
                    bop.LWO = aVar3.UbS.readString();
                    AppMethodBeat.o(214302);
                    return 0;
                case 8:
                    bop.LWP = aVar3.UbS.yZ();
                    AppMethodBeat.o(214302);
                    return 0;
                default:
                    AppMethodBeat.o(214302);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214302);
            return -1;
        }
    }
}
