package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class evn extends a {
    public String Ntb;
    public LinkedList<String> Ntc = new LinkedList<>();

    public evn() {
        AppMethodBeat.i(147798);
        AppMethodBeat.o(147798);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147799);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ntb != null) {
                aVar.e(1, this.Ntb);
            }
            aVar.e(2, 1, this.Ntc);
            AppMethodBeat.o(147799);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Ntb != null ? g.a.a.b.b.a.f(1, this.Ntb) + 0 : 0) + g.a.a.a.c(2, 1, this.Ntc);
            AppMethodBeat.o(147799);
            return f2;
        } else if (i2 == 2) {
            this.Ntc.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147799);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evn evn = (evn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    evn.Ntb = aVar3.UbS.readString();
                    AppMethodBeat.o(147799);
                    return 0;
                case 2:
                    evn.Ntc.add(aVar3.UbS.readString());
                    AppMethodBeat.o(147799);
                    return 0;
                default:
                    AppMethodBeat.o(147799);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147799);
            return -1;
        }
    }
}
