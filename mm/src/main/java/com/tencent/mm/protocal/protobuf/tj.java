package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class tj extends dop {
    public String KKR;
    public int LbX;
    public int LbY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91387);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KKR == null) {
                b bVar = new b("Not all required fields were included: ReqKey");
                AppMethodBeat.o(91387);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LbX);
            aVar.aM(3, this.LbY);
            if (this.KKR != null) {
                aVar.e(4, this.KKR);
            }
            AppMethodBeat.o(91387);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LbX) + g.a.a.b.b.a.bu(3, this.LbY);
            if (this.KKR != null) {
                nh += g.a.a.b.b.a.f(4, this.KKR);
            }
            AppMethodBeat.o(91387);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KKR == null) {
                b bVar2 = new b("Not all required fields were included: ReqKey");
                AppMethodBeat.o(91387);
                throw bVar2;
            }
            AppMethodBeat.o(91387);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            tj tjVar = (tj) objArr[1];
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
                        tjVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91387);
                    return 0;
                case 2:
                    tjVar.LbX = aVar3.UbS.zi();
                    AppMethodBeat.o(91387);
                    return 0;
                case 3:
                    tjVar.LbY = aVar3.UbS.zi();
                    AppMethodBeat.o(91387);
                    return 0;
                case 4:
                    tjVar.KKR = aVar3.UbS.readString();
                    AppMethodBeat.o(91387);
                    return 0;
                default:
                    AppMethodBeat.o(91387);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91387);
            return -1;
        }
    }
}
