package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dnq extends dop {
    public float MQJ;
    public b MQK;
    public boolean MQL;
    public boolean MQM;
    public float dTj;
    public String eaO;
    public float latitude;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114064);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.E(2, this.dTj);
            aVar.E(3, this.latitude);
            aVar.E(4, this.MQJ);
            if (this.MQK != null) {
                aVar.c(5, this.MQK);
            }
            if (this.eaO != null) {
                aVar.e(6, this.eaO);
            }
            aVar.cc(7, this.MQL);
            aVar.cc(8, this.MQM);
            AppMethodBeat.o(114064);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4;
            if (this.MQK != null) {
                nh += g.a.a.b.b.a.b(5, this.MQK);
            }
            if (this.eaO != null) {
                nh += g.a.a.b.b.a.f(6, this.eaO);
            }
            int fS = nh + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.fS(8) + 1;
            AppMethodBeat.o(114064);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114064);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dnq dnq = (dnq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        dnq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(114064);
                    return 0;
                case 2:
                    dnq.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(114064);
                    return 0;
                case 3:
                    dnq.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(114064);
                    return 0;
                case 4:
                    dnq.MQJ = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(114064);
                    return 0;
                case 5:
                    dnq.MQK = aVar3.UbS.hPo();
                    AppMethodBeat.o(114064);
                    return 0;
                case 6:
                    dnq.eaO = aVar3.UbS.readString();
                    AppMethodBeat.o(114064);
                    return 0;
                case 7:
                    dnq.MQL = aVar3.UbS.yZ();
                    AppMethodBeat.o(114064);
                    return 0;
                case 8:
                    dnq.MQM = aVar3.UbS.yZ();
                    AppMethodBeat.o(114064);
                    return 0;
                default:
                    AppMethodBeat.o(114064);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114064);
            return -1;
        }
    }
}
