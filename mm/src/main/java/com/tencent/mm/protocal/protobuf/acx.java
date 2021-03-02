package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class acx extends a {
    public String KBt;
    public long Lnw;
    public int Loj;
    public LinkedList<acw> Lok = new LinkedList<>();

    public acx() {
        AppMethodBeat.i(186798);
        AppMethodBeat.o(186798);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(186799);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Lnw);
            if (this.KBt != null) {
                aVar.e(2, this.KBt);
            }
            aVar.aM(3, this.Loj);
            aVar.e(4, 8, this.Lok);
            AppMethodBeat.o(186799);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Lnw) + 0;
            if (this.KBt != null) {
                r += g.a.a.b.b.a.f(2, this.KBt);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.Loj) + g.a.a.a.c(4, 8, this.Lok);
            AppMethodBeat.o(186799);
            return bu;
        } else if (i2 == 2) {
            this.Lok.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(186799);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acx acx = (acx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    acx.Lnw = aVar3.UbS.zl();
                    AppMethodBeat.o(186799);
                    return 0;
                case 2:
                    acx.KBt = aVar3.UbS.readString();
                    AppMethodBeat.o(186799);
                    return 0;
                case 3:
                    acx.Loj = aVar3.UbS.zi();
                    AppMethodBeat.o(186799);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        acw acw = new acw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = acw.populateBuilderWithField(aVar4, acw, a.getNextFieldNumber(aVar4))) {
                        }
                        acx.Lok.add(acw);
                    }
                    AppMethodBeat.o(186799);
                    return 0;
                default:
                    AppMethodBeat.o(186799);
                    return -1;
            }
        } else {
            AppMethodBeat.o(186799);
            return -1;
        }
    }
}
