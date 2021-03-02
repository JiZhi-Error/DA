package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cey extends a {
    public String CYp;
    public int Mkv;
    public LinkedList<String> Mkw = new LinkedList<>();
    public String scope;

    public cey() {
        AppMethodBeat.i(82449);
        AppMethodBeat.o(82449);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82450);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            aVar.aM(2, this.Mkv);
            if (this.CYp != null) {
                aVar.e(3, this.CYp);
            }
            aVar.e(4, 1, this.Mkw);
            AppMethodBeat.o(82450);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.scope != null ? g.a.a.b.b.a.f(1, this.scope) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Mkv);
            if (this.CYp != null) {
                f2 += g.a.a.b.b.a.f(3, this.CYp);
            }
            int c2 = f2 + g.a.a.a.c(4, 1, this.Mkw);
            AppMethodBeat.o(82450);
            return c2;
        } else if (i2 == 2) {
            this.Mkw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82450);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cey cey = (cey) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cey.scope = aVar3.UbS.readString();
                    AppMethodBeat.o(82450);
                    return 0;
                case 2:
                    cey.Mkv = aVar3.UbS.zi();
                    AppMethodBeat.o(82450);
                    return 0;
                case 3:
                    cey.CYp = aVar3.UbS.readString();
                    AppMethodBeat.o(82450);
                    return 0;
                case 4:
                    cey.Mkw.add(aVar3.UbS.readString());
                    AppMethodBeat.o(82450);
                    return 0;
                default:
                    AppMethodBeat.o(82450);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82450);
            return -1;
        }
    }
}
