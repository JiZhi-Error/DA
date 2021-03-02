package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class z extends a {
    public String oTx;
    public long oUG;
    public long oUH;
    public String oUI;
    public String oUJ;
    public LinkedList<String> oUn = new LinkedList<>();

    public z() {
        AppMethodBeat.i(22131);
        AppMethodBeat.o(22131);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22132);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oTx == null) {
                b bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(22132);
                throw bVar;
            } else if (this.oUI == null) {
                b bVar2 = new b("Not all required fields were included: MsgDataID");
                AppMethodBeat.o(22132);
                throw bVar2;
            } else if (this.oUJ == null) {
                b bVar3 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(22132);
                throw bVar3;
            } else {
                if (this.oTx != null) {
                    aVar.e(1, this.oTx);
                }
                aVar.bb(2, this.oUG);
                aVar.bb(3, this.oUH);
                if (this.oUI != null) {
                    aVar.e(4, this.oUI);
                }
                if (this.oUJ != null) {
                    aVar.e(5, this.oUJ);
                }
                aVar.e(6, 1, this.oUn);
                AppMethodBeat.o(22132);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = (this.oTx != null ? g.a.a.b.b.a.f(1, this.oTx) + 0 : 0) + g.a.a.b.b.a.r(2, this.oUG) + g.a.a.b.b.a.r(3, this.oUH);
            if (this.oUI != null) {
                f2 += g.a.a.b.b.a.f(4, this.oUI);
            }
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(5, this.oUJ);
            }
            int c2 = f2 + g.a.a.a.c(6, 1, this.oUn);
            AppMethodBeat.o(22132);
            return c2;
        } else if (i2 == 2) {
            this.oUn.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oTx == null) {
                b bVar4 = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(22132);
                throw bVar4;
            } else if (this.oUI == null) {
                b bVar5 = new b("Not all required fields were included: MsgDataID");
                AppMethodBeat.o(22132);
                throw bVar5;
            } else if (this.oUJ == null) {
                b bVar6 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(22132);
                throw bVar6;
            } else {
                AppMethodBeat.o(22132);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zVar.oTx = aVar3.UbS.readString();
                    AppMethodBeat.o(22132);
                    return 0;
                case 2:
                    zVar.oUG = aVar3.UbS.zl();
                    AppMethodBeat.o(22132);
                    return 0;
                case 3:
                    zVar.oUH = aVar3.UbS.zl();
                    AppMethodBeat.o(22132);
                    return 0;
                case 4:
                    zVar.oUI = aVar3.UbS.readString();
                    AppMethodBeat.o(22132);
                    return 0;
                case 5:
                    zVar.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(22132);
                    return 0;
                case 6:
                    zVar.oUn.add(aVar3.UbS.readString());
                    AppMethodBeat.o(22132);
                    return 0;
                default:
                    AppMethodBeat.o(22132);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22132);
            return -1;
        }
    }
}
