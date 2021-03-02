package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class eoj extends a {
    public int Height;
    public b Nmh;
    public int Nmi;
    public long Nmj;
    public int Width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117938);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nmh != null) {
                aVar.c(1, this.Nmh);
            }
            aVar.aM(2, this.Nmi);
            aVar.bb(3, this.Nmj);
            aVar.aM(4, this.Width);
            aVar.aM(5, this.Height);
            AppMethodBeat.o(117938);
            return 0;
        } else if (i2 == 1) {
            int b2 = (this.Nmh != null ? g.a.a.b.b.a.b(1, this.Nmh) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Nmi) + g.a.a.b.b.a.r(3, this.Nmj) + g.a.a.b.b.a.bu(4, this.Width) + g.a.a.b.b.a.bu(5, this.Height);
            AppMethodBeat.o(117938);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117938);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eoj eoj = (eoj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eoj.Nmh = aVar3.UbS.hPo();
                    AppMethodBeat.o(117938);
                    return 0;
                case 2:
                    eoj.Nmi = aVar3.UbS.zi();
                    AppMethodBeat.o(117938);
                    return 0;
                case 3:
                    eoj.Nmj = aVar3.UbS.zl();
                    AppMethodBeat.o(117938);
                    return 0;
                case 4:
                    eoj.Width = aVar3.UbS.zi();
                    AppMethodBeat.o(117938);
                    return 0;
                case 5:
                    eoj.Height = aVar3.UbS.zi();
                    AppMethodBeat.o(117938);
                    return 0;
                default:
                    AppMethodBeat.o(117938);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117938);
            return -1;
        }
    }
}
