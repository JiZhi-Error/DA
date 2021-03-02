package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bzo extends a {
    public String CellTitle;
    public String Mfh;
    public String Mfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152609);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.CellTitle != null) {
                aVar.e(1, this.CellTitle);
            }
            if (this.Mfh != null) {
                aVar.e(2, this.Mfh);
            }
            if (this.Mfi != null) {
                aVar.e(3, this.Mfi);
            }
            AppMethodBeat.o(152609);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.CellTitle != null ? g.a.a.b.b.a.f(1, this.CellTitle) + 0 : 0;
            if (this.Mfh != null) {
                f2 += g.a.a.b.b.a.f(2, this.Mfh);
            }
            if (this.Mfi != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mfi);
            }
            AppMethodBeat.o(152609);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152609);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bzo bzo = (bzo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzo.CellTitle = aVar3.UbS.readString();
                    AppMethodBeat.o(152609);
                    return 0;
                case 2:
                    bzo.Mfh = aVar3.UbS.readString();
                    AppMethodBeat.o(152609);
                    return 0;
                case 3:
                    bzo.Mfi = aVar3.UbS.readString();
                    AppMethodBeat.o(152609);
                    return 0;
                default:
                    AppMethodBeat.o(152609);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152609);
            return -1;
        }
    }
}
