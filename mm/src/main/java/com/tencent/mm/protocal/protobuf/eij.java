package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eij extends a {
    public int Category;
    public int MOb;
    public LinkedList<String> MOd = new LinkedList<>();
    public long NhD;
    public int NhE;
    public String iAc;

    public eij() {
        AppMethodBeat.i(152998);
        AppMethodBeat.o(152998);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152999);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.iAc != null) {
                aVar.e(1, this.iAc);
            }
            aVar.bb(2, this.NhD);
            aVar.aM(3, this.MOb);
            aVar.aM(4, this.NhE);
            aVar.aM(5, this.Category);
            aVar.e(6, 1, this.MOd);
            AppMethodBeat.o(152999);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.iAc != null ? g.a.a.b.b.a.f(1, this.iAc) + 0 : 0) + g.a.a.b.b.a.r(2, this.NhD) + g.a.a.b.b.a.bu(3, this.MOb) + g.a.a.b.b.a.bu(4, this.NhE) + g.a.a.b.b.a.bu(5, this.Category) + g.a.a.a.c(6, 1, this.MOd);
            AppMethodBeat.o(152999);
            return f2;
        } else if (i2 == 2) {
            this.MOd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152999);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eij eij = (eij) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eij.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(152999);
                    return 0;
                case 2:
                    eij.NhD = aVar3.UbS.zl();
                    AppMethodBeat.o(152999);
                    return 0;
                case 3:
                    eij.MOb = aVar3.UbS.zi();
                    AppMethodBeat.o(152999);
                    return 0;
                case 4:
                    eij.NhE = aVar3.UbS.zi();
                    AppMethodBeat.o(152999);
                    return 0;
                case 5:
                    eij.Category = aVar3.UbS.zi();
                    AppMethodBeat.o(152999);
                    return 0;
                case 6:
                    eij.MOd.add(aVar3.UbS.readString());
                    AppMethodBeat.o(152999);
                    return 0;
                default:
                    AppMethodBeat.o(152999);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152999);
            return -1;
        }
    }
}
