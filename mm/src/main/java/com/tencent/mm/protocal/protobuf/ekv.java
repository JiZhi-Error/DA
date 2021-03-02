package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ekv extends a {
    public String Nke;
    public String Nkf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125849);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nke != null) {
                aVar.e(1, this.Nke);
            }
            if (this.Nkf != null) {
                aVar.e(2, this.Nkf);
            }
            AppMethodBeat.o(125849);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Nke != null ? g.a.a.b.b.a.f(1, this.Nke) + 0 : 0;
            if (this.Nkf != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nkf);
            }
            AppMethodBeat.o(125849);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125849);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekv ekv = (ekv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ekv.Nke = aVar3.UbS.readString();
                    AppMethodBeat.o(125849);
                    return 0;
                case 2:
                    ekv.Nkf = aVar3.UbS.readString();
                    AppMethodBeat.o(125849);
                    return 0;
                default:
                    AppMethodBeat.o(125849);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125849);
            return -1;
        }
    }
}
