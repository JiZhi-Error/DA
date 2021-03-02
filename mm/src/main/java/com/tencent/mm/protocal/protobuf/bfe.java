package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bfe extends a {
    public String content;
    public int gGn = 0;
    public String iconUrl;
    public String name;
    public int type;
    public int yXT;
    public int yXU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214298);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.aM(2, this.type);
            if (this.content != null) {
                aVar.e(3, this.content);
            }
            aVar.aM(4, this.gGn);
            if (this.iconUrl != null) {
                aVar.e(5, this.iconUrl);
            }
            aVar.aM(6, this.yXT);
            aVar.aM(7, this.yXU);
            AppMethodBeat.o(214298);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type);
            if (this.content != null) {
                f2 += g.a.a.b.b.a.f(3, this.content);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.gGn);
            if (this.iconUrl != null) {
                bu += g.a.a.b.b.a.f(5, this.iconUrl);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.yXT) + g.a.a.b.b.a.bu(7, this.yXU);
            AppMethodBeat.o(214298);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214298);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfe bfe = (bfe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfe.name = aVar3.UbS.readString();
                    AppMethodBeat.o(214298);
                    return 0;
                case 2:
                    bfe.type = aVar3.UbS.zi();
                    AppMethodBeat.o(214298);
                    return 0;
                case 3:
                    bfe.content = aVar3.UbS.readString();
                    AppMethodBeat.o(214298);
                    return 0;
                case 4:
                    bfe.gGn = aVar3.UbS.zi();
                    AppMethodBeat.o(214298);
                    return 0;
                case 5:
                    bfe.iconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(214298);
                    return 0;
                case 6:
                    bfe.yXT = aVar3.UbS.zi();
                    AppMethodBeat.o(214298);
                    return 0;
                case 7:
                    bfe.yXU = aVar3.UbS.zi();
                    AppMethodBeat.o(214298);
                    return 0;
                default:
                    AppMethodBeat.o(214298);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214298);
            return -1;
        }
    }
}
