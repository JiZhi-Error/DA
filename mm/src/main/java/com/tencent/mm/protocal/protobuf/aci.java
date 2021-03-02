package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aci extends a {
    public String KXB;
    public String LmS;
    public long LmT;
    public int LmU;
    public int LmV;
    public LinkedList<ack> LmW = new LinkedList<>();

    public aci() {
        AppMethodBeat.i(219124);
        AppMethodBeat.o(219124);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(219125);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LmS != null) {
                aVar.e(1, this.LmS);
            }
            if (this.KXB != null) {
                aVar.e(2, this.KXB);
            }
            aVar.bb(3, this.LmT);
            aVar.aM(4, this.LmU);
            aVar.aM(5, this.LmV);
            aVar.e(6, 8, this.LmW);
            AppMethodBeat.o(219125);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LmS != null ? g.a.a.b.b.a.f(1, this.LmS) + 0 : 0;
            if (this.KXB != null) {
                f2 += g.a.a.b.b.a.f(2, this.KXB);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.LmT) + g.a.a.b.b.a.bu(4, this.LmU) + g.a.a.b.b.a.bu(5, this.LmV) + g.a.a.a.c(6, 8, this.LmW);
            AppMethodBeat.o(219125);
            return r;
        } else if (i2 == 2) {
            this.LmW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(219125);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aci aci = (aci) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aci.LmS = aVar3.UbS.readString();
                    AppMethodBeat.o(219125);
                    return 0;
                case 2:
                    aci.KXB = aVar3.UbS.readString();
                    AppMethodBeat.o(219125);
                    return 0;
                case 3:
                    aci.LmT = aVar3.UbS.zl();
                    AppMethodBeat.o(219125);
                    return 0;
                case 4:
                    aci.LmU = aVar3.UbS.zi();
                    AppMethodBeat.o(219125);
                    return 0;
                case 5:
                    aci.LmV = aVar3.UbS.zi();
                    AppMethodBeat.o(219125);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ack ack = new ack();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ack.populateBuilderWithField(aVar4, ack, a.getNextFieldNumber(aVar4))) {
                        }
                        aci.LmW.add(ack);
                    }
                    AppMethodBeat.o(219125);
                    return 0;
                default:
                    AppMethodBeat.o(219125);
                    return -1;
            }
        } else {
            AppMethodBeat.o(219125);
            return -1;
        }
    }
}
