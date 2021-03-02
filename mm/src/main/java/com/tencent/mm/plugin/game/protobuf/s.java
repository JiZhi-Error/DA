package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class s extends a {
    public String Desc;
    public String Name;
    public String xIy;
    public String xJE;
    public int xJF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41718);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJE != null) {
                aVar.e(1, this.xJE);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            if (this.Desc != null) {
                aVar.e(3, this.Desc);
            }
            if (this.xIy != null) {
                aVar.e(4, this.xIy);
            }
            aVar.aM(5, this.xJF);
            AppMethodBeat.o(41718);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xJE != null ? g.a.a.b.b.a.f(1, this.xJE) + 0 : 0;
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(2, this.Name);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.Desc);
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(4, this.xIy);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.xJF);
            AppMethodBeat.o(41718);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41718);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            s sVar = (s) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sVar.xJE = aVar3.UbS.readString();
                    AppMethodBeat.o(41718);
                    return 0;
                case 2:
                    sVar.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(41718);
                    return 0;
                case 3:
                    sVar.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(41718);
                    return 0;
                case 4:
                    sVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41718);
                    return 0;
                case 5:
                    sVar.xJF = aVar3.UbS.zi();
                    AppMethodBeat.o(41718);
                    return 0;
                default:
                    AppMethodBeat.o(41718);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41718);
            return -1;
        }
    }
}
