package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class akx extends a {
    public String LtA;
    public String LtL;
    public LinkedList<String> LtM = new LinkedList<>();
    public boolean LtN;

    public akx() {
        AppMethodBeat.i(32203);
        AppMethodBeat.o(32203);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32204);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LtA == null) {
                b bVar = new b("Not all required fields were included: LoginUrl");
                AppMethodBeat.o(32204);
                throw bVar;
            }
            if (this.LtA != null) {
                aVar.e(1, this.LtA);
            }
            if (this.LtL != null) {
                aVar.e(2, this.LtL);
            }
            aVar.e(3, 1, this.LtM);
            aVar.cc(4, this.LtN);
            AppMethodBeat.o(32204);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LtA != null ? g.a.a.b.b.a.f(1, this.LtA) + 0 : 0;
            if (this.LtL != null) {
                f2 += g.a.a.b.b.a.f(2, this.LtL);
            }
            int c2 = f2 + g.a.a.a.c(3, 1, this.LtM) + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(32204);
            return c2;
        } else if (i2 == 2) {
            this.LtM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LtA == null) {
                b bVar2 = new b("Not all required fields were included: LoginUrl");
                AppMethodBeat.o(32204);
                throw bVar2;
            }
            AppMethodBeat.o(32204);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            akx akx = (akx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akx.LtA = aVar3.UbS.readString();
                    AppMethodBeat.o(32204);
                    return 0;
                case 2:
                    akx.LtL = aVar3.UbS.readString();
                    AppMethodBeat.o(32204);
                    return 0;
                case 3:
                    akx.LtM.add(aVar3.UbS.readString());
                    AppMethodBeat.o(32204);
                    return 0;
                case 4:
                    akx.LtN = aVar3.UbS.yZ();
                    AppMethodBeat.o(32204);
                    return 0;
                default:
                    AppMethodBeat.o(32204);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32204);
            return -1;
        }
    }
}
