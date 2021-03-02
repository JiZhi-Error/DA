package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ddx extends a {
    public String path;
    public String query;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153293);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.path != null) {
                aVar.e(1, this.path);
            }
            if (this.query != null) {
                aVar.e(2, this.query);
            }
            aVar.aM(3, this.scene);
            AppMethodBeat.o(153293);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.path != null ? g.a.a.b.b.a.f(1, this.path) + 0 : 0;
            if (this.query != null) {
                f2 += g.a.a.b.b.a.f(2, this.query);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.scene);
            AppMethodBeat.o(153293);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153293);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddx ddx = (ddx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ddx.path = aVar3.UbS.readString();
                    AppMethodBeat.o(153293);
                    return 0;
                case 2:
                    ddx.query = aVar3.UbS.readString();
                    AppMethodBeat.o(153293);
                    return 0;
                case 3:
                    ddx.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(153293);
                    return 0;
                default:
                    AppMethodBeat.o(153293);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153293);
            return -1;
        }
    }
}
