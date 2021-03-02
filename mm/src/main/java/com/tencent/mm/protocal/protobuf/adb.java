package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class adb extends a {
    public long Lnw;
    public int Lof;
    public String Loo;
    public LinkedList<String> Lop = new LinkedList<>();

    public adb() {
        AppMethodBeat.i(186801);
        AppMethodBeat.o(186801);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(186802);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Lnw);
            if (this.Loo != null) {
                aVar.e(2, this.Loo);
            }
            aVar.e(3, 1, this.Lop);
            aVar.aM(4, this.Lof);
            AppMethodBeat.o(186802);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Lnw) + 0;
            if (this.Loo != null) {
                r += g.a.a.b.b.a.f(2, this.Loo);
            }
            int c2 = r + g.a.a.a.c(3, 1, this.Lop) + g.a.a.b.b.a.bu(4, this.Lof);
            AppMethodBeat.o(186802);
            return c2;
        } else if (i2 == 2) {
            this.Lop.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(186802);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            adb adb = (adb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    adb.Lnw = aVar3.UbS.zl();
                    AppMethodBeat.o(186802);
                    return 0;
                case 2:
                    adb.Loo = aVar3.UbS.readString();
                    AppMethodBeat.o(186802);
                    return 0;
                case 3:
                    adb.Lop.add(aVar3.UbS.readString());
                    AppMethodBeat.o(186802);
                    return 0;
                case 4:
                    adb.Lof = aVar3.UbS.zi();
                    AppMethodBeat.o(186802);
                    return 0;
                default:
                    AppMethodBeat.o(186802);
                    return -1;
            }
        } else {
            AppMethodBeat.o(186802);
            return -1;
        }
    }
}
