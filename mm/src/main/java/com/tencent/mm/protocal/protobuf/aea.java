package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aea extends a {
    public String HTZ;
    public String HUd;
    public String IaZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91429);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.HTZ != null) {
                aVar.e(1, this.HTZ);
            }
            if (this.IaZ != null) {
                aVar.e(2, this.IaZ);
            }
            if (this.HUd != null) {
                aVar.e(3, this.HUd);
            }
            AppMethodBeat.o(91429);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.HTZ != null ? g.a.a.b.b.a.f(1, this.HTZ) + 0 : 0;
            if (this.IaZ != null) {
                f2 += g.a.a.b.b.a.f(2, this.IaZ);
            }
            if (this.HUd != null) {
                f2 += g.a.a.b.b.a.f(3, this.HUd);
            }
            AppMethodBeat.o(91429);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91429);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aea aea = (aea) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aea.HTZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91429);
                    return 0;
                case 2:
                    aea.IaZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91429);
                    return 0;
                case 3:
                    aea.HUd = aVar3.UbS.readString();
                    AppMethodBeat.o(91429);
                    return 0;
                default:
                    AppMethodBeat.o(91429);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91429);
            return -1;
        }
    }
}
