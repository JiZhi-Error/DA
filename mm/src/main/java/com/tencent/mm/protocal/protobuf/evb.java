package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class evb extends a {
    public String Nta;
    public String Ntb;
    public LinkedList<String> Ntc = new LinkedList<>();
    public int Ntd;

    public evb() {
        AppMethodBeat.i(147784);
        AppMethodBeat.o(147784);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147785);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nta != null) {
                aVar.e(1, this.Nta);
            }
            if (this.Ntb != null) {
                aVar.e(2, this.Ntb);
            }
            aVar.e(3, 1, this.Ntc);
            aVar.aM(4, this.Ntd);
            AppMethodBeat.o(147785);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Nta != null ? g.a.a.b.b.a.f(1, this.Nta) + 0 : 0;
            if (this.Ntb != null) {
                f2 += g.a.a.b.b.a.f(2, this.Ntb);
            }
            int c2 = f2 + g.a.a.a.c(3, 1, this.Ntc) + g.a.a.b.b.a.bu(4, this.Ntd);
            AppMethodBeat.o(147785);
            return c2;
        } else if (i2 == 2) {
            this.Ntc.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147785);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evb evb = (evb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    evb.Nta = aVar3.UbS.readString();
                    AppMethodBeat.o(147785);
                    return 0;
                case 2:
                    evb.Ntb = aVar3.UbS.readString();
                    AppMethodBeat.o(147785);
                    return 0;
                case 3:
                    evb.Ntc.add(aVar3.UbS.readString());
                    AppMethodBeat.o(147785);
                    return 0;
                case 4:
                    evb.Ntd = aVar3.UbS.zi();
                    AppMethodBeat.o(147785);
                    return 0;
                default:
                    AppMethodBeat.o(147785);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147785);
            return -1;
        }
    }
}
