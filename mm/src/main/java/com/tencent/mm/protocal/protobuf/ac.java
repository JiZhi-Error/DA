package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ac extends a {
    public String KCm;
    public String KCn;
    public String KCo;
    public String KCp;
    public LinkedList<String> KCq = new LinkedList<>();
    public String oTJ;
    public String oUj;

    public ac() {
        AppMethodBeat.i(145665);
        AppMethodBeat.o(145665);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(145666);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oUj != null) {
                aVar.e(1, this.oUj);
            }
            if (this.oTJ != null) {
                aVar.e(2, this.oTJ);
            }
            if (this.KCm != null) {
                aVar.e(3, this.KCm);
            }
            if (this.KCn != null) {
                aVar.e(4, this.KCn);
            }
            if (this.KCo != null) {
                aVar.e(5, this.KCo);
            }
            if (this.KCp != null) {
                aVar.e(6, this.KCp);
            }
            aVar.e(7, 1, this.KCq);
            AppMethodBeat.o(145666);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.oUj != null ? g.a.a.b.b.a.f(1, this.oUj) + 0 : 0;
            if (this.oTJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oTJ);
            }
            if (this.KCm != null) {
                f2 += g.a.a.b.b.a.f(3, this.KCm);
            }
            if (this.KCn != null) {
                f2 += g.a.a.b.b.a.f(4, this.KCn);
            }
            if (this.KCo != null) {
                f2 += g.a.a.b.b.a.f(5, this.KCo);
            }
            if (this.KCp != null) {
                f2 += g.a.a.b.b.a.f(6, this.KCp);
            }
            int c2 = f2 + g.a.a.a.c(7, 1, this.KCq);
            AppMethodBeat.o(145666);
            return c2;
        } else if (i2 == 2) {
            this.KCq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(145666);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ac acVar = (ac) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acVar.oUj = aVar3.UbS.readString();
                    AppMethodBeat.o(145666);
                    return 0;
                case 2:
                    acVar.oTJ = aVar3.UbS.readString();
                    AppMethodBeat.o(145666);
                    return 0;
                case 3:
                    acVar.KCm = aVar3.UbS.readString();
                    AppMethodBeat.o(145666);
                    return 0;
                case 4:
                    acVar.KCn = aVar3.UbS.readString();
                    AppMethodBeat.o(145666);
                    return 0;
                case 5:
                    acVar.KCo = aVar3.UbS.readString();
                    AppMethodBeat.o(145666);
                    return 0;
                case 6:
                    acVar.KCp = aVar3.UbS.readString();
                    AppMethodBeat.o(145666);
                    return 0;
                case 7:
                    acVar.KCq.add(aVar3.UbS.readString());
                    AppMethodBeat.o(145666);
                    return 0;
                default:
                    AppMethodBeat.o(145666);
                    return -1;
            }
        } else {
            AppMethodBeat.o(145666);
            return -1;
        }
    }
}
