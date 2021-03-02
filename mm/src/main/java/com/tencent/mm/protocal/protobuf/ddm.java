package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ddm extends a {
    public int LWR;
    public String LWS;
    public String LWT;
    public ekv MID;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32369);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LWR);
            if (this.LWS != null) {
                aVar.e(2, this.LWS);
            }
            if (this.LWT != null) {
                aVar.e(3, this.LWT);
            }
            if (this.MID != null) {
                aVar.ni(4, this.MID.computeSize());
                this.MID.writeFields(aVar);
            }
            AppMethodBeat.o(32369);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LWR) + 0;
            if (this.LWS != null) {
                bu += g.a.a.b.b.a.f(2, this.LWS);
            }
            if (this.LWT != null) {
                bu += g.a.a.b.b.a.f(3, this.LWT);
            }
            if (this.MID != null) {
                bu += g.a.a.a.nh(4, this.MID.computeSize());
            }
            AppMethodBeat.o(32369);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32369);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddm ddm = (ddm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ddm.LWR = aVar3.UbS.zi();
                    AppMethodBeat.o(32369);
                    return 0;
                case 2:
                    ddm.LWS = aVar3.UbS.readString();
                    AppMethodBeat.o(32369);
                    return 0;
                case 3:
                    ddm.LWT = aVar3.UbS.readString();
                    AppMethodBeat.o(32369);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ekv ekv = new ekv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ekv.populateBuilderWithField(aVar4, ekv, a.getNextFieldNumber(aVar4))) {
                        }
                        ddm.MID = ekv;
                    }
                    AppMethodBeat.o(32369);
                    return 0;
                default:
                    AppMethodBeat.o(32369);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32369);
            return -1;
        }
    }
}
