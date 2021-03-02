package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fht extends a {
    public String KIt;
    public String Vkl;
    public String Vkm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259376);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Vkl != null) {
                aVar.e(1, this.Vkl);
            }
            if (this.Vkm != null) {
                aVar.e(2, this.Vkm);
            }
            if (this.KIt != null) {
                aVar.e(3, this.KIt);
            }
            AppMethodBeat.o(259376);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Vkl != null ? g.a.a.b.b.a.f(1, this.Vkl) + 0 : 0;
            if (this.Vkm != null) {
                f2 += g.a.a.b.b.a.f(2, this.Vkm);
            }
            if (this.KIt != null) {
                f2 += g.a.a.b.b.a.f(3, this.KIt);
            }
            AppMethodBeat.o(259376);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259376);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fht fht = (fht) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fht.Vkl = aVar3.UbS.readString();
                    AppMethodBeat.o(259376);
                    return 0;
                case 2:
                    fht.Vkm = aVar3.UbS.readString();
                    AppMethodBeat.o(259376);
                    return 0;
                case 3:
                    fht.KIt = aVar3.UbS.readString();
                    AppMethodBeat.o(259376);
                    return 0;
                default:
                    AppMethodBeat.o(259376);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259376);
            return -1;
        }
    }
}
