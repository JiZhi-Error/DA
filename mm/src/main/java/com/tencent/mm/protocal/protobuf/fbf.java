package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fbf extends a {
    public String Nxw;
    public boolean Nxx;
    public int Nxy;
    public int Nxz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110856);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nxw != null) {
                aVar.e(1, this.Nxw);
            }
            aVar.cc(2, this.Nxx);
            aVar.aM(3, this.Nxy);
            aVar.aM(4, this.Nxz);
            AppMethodBeat.o(110856);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Nxw != null ? g.a.a.b.b.a.f(1, this.Nxw) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.bu(3, this.Nxy) + g.a.a.b.b.a.bu(4, this.Nxz);
            AppMethodBeat.o(110856);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110856);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbf fbf = (fbf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbf.Nxw = aVar3.UbS.readString();
                    AppMethodBeat.o(110856);
                    return 0;
                case 2:
                    fbf.Nxx = aVar3.UbS.yZ();
                    AppMethodBeat.o(110856);
                    return 0;
                case 3:
                    fbf.Nxy = aVar3.UbS.zi();
                    AppMethodBeat.o(110856);
                    return 0;
                case 4:
                    fbf.Nxz = aVar3.UbS.zi();
                    AppMethodBeat.o(110856);
                    return 0;
                default:
                    AppMethodBeat.o(110856);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110856);
            return -1;
        }
    }
}
