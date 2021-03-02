package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ahd extends a {
    public String LqN;
    public String LqO;
    public String ljQ;
    public String model;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220686);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ljQ != null) {
                aVar.e(1, this.ljQ);
            }
            if (this.model != null) {
                aVar.e(2, this.model);
            }
            if (this.LqN != null) {
                aVar.e(3, this.LqN);
            }
            if (this.LqO != null) {
                aVar.e(4, this.LqO);
            }
            AppMethodBeat.o(220686);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ljQ != null ? g.a.a.b.b.a.f(1, this.ljQ) + 0 : 0;
            if (this.model != null) {
                f2 += g.a.a.b.b.a.f(2, this.model);
            }
            if (this.LqN != null) {
                f2 += g.a.a.b.b.a.f(3, this.LqN);
            }
            if (this.LqO != null) {
                f2 += g.a.a.b.b.a.f(4, this.LqO);
            }
            AppMethodBeat.o(220686);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220686);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahd ahd = (ahd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ahd.ljQ = aVar3.UbS.readString();
                    AppMethodBeat.o(220686);
                    return 0;
                case 2:
                    ahd.model = aVar3.UbS.readString();
                    AppMethodBeat.o(220686);
                    return 0;
                case 3:
                    ahd.LqN = aVar3.UbS.readString();
                    AppMethodBeat.o(220686);
                    return 0;
                case 4:
                    ahd.LqO = aVar3.UbS.readString();
                    AppMethodBeat.o(220686);
                    return 0;
                default:
                    AppMethodBeat.o(220686);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220686);
            return -1;
        }
    }
}
