package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class m extends a {
    public String ANo;
    public String HEP;
    public int selected;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91298);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.HEP != null) {
                aVar.e(1, this.HEP);
            }
            aVar.aM(2, this.selected);
            if (this.ANo != null) {
                aVar.e(3, this.ANo);
            }
            AppMethodBeat.o(91298);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.HEP != null ? g.a.a.b.b.a.f(1, this.HEP) + 0 : 0) + g.a.a.b.b.a.bu(2, this.selected);
            if (this.ANo != null) {
                f2 += g.a.a.b.b.a.f(3, this.ANo);
            }
            AppMethodBeat.o(91298);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91298);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.HEP = aVar3.UbS.readString();
                    AppMethodBeat.o(91298);
                    return 0;
                case 2:
                    mVar.selected = aVar3.UbS.zi();
                    AppMethodBeat.o(91298);
                    return 0;
                case 3:
                    mVar.ANo = aVar3.UbS.readString();
                    AppMethodBeat.o(91298);
                    return 0;
                default:
                    AppMethodBeat.o(91298);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91298);
            return -1;
        }
    }
}
