package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class aa extends a {
    public String oTx;
    public long oUG;
    public long oUH;
    public String oUI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22133);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oTx == null) {
                b bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(22133);
                throw bVar;
            } else if (this.oUI == null) {
                b bVar2 = new b("Not all required fields were included: MsgDataID");
                AppMethodBeat.o(22133);
                throw bVar2;
            } else {
                if (this.oTx != null) {
                    aVar.e(1, this.oTx);
                }
                aVar.bb(2, this.oUG);
                aVar.bb(3, this.oUH);
                if (this.oUI != null) {
                    aVar.e(4, this.oUI);
                }
                AppMethodBeat.o(22133);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = (this.oTx != null ? g.a.a.b.b.a.f(1, this.oTx) + 0 : 0) + g.a.a.b.b.a.r(2, this.oUG) + g.a.a.b.b.a.r(3, this.oUH);
            if (this.oUI != null) {
                f2 += g.a.a.b.b.a.f(4, this.oUI);
            }
            AppMethodBeat.o(22133);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oTx == null) {
                b bVar3 = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(22133);
                throw bVar3;
            } else if (this.oUI == null) {
                b bVar4 = new b("Not all required fields were included: MsgDataID");
                AppMethodBeat.o(22133);
                throw bVar4;
            } else {
                AppMethodBeat.o(22133);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aaVar.oTx = aVar3.UbS.readString();
                    AppMethodBeat.o(22133);
                    return 0;
                case 2:
                    aaVar.oUG = aVar3.UbS.zl();
                    AppMethodBeat.o(22133);
                    return 0;
                case 3:
                    aaVar.oUH = aVar3.UbS.zl();
                    AppMethodBeat.o(22133);
                    return 0;
                case 4:
                    aaVar.oUI = aVar3.UbS.readString();
                    AppMethodBeat.o(22133);
                    return 0;
                default:
                    AppMethodBeat.o(22133);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22133);
            return -1;
        }
    }
}
