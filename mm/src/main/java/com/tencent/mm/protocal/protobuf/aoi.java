package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aoi extends a {
    public String LAp;
    public String LAq;
    public String LAr;
    public int trl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196087);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LAp != null) {
                aVar.e(1, this.LAp);
            }
            if (this.LAq != null) {
                aVar.e(2, this.LAq);
            }
            if (this.LAr != null) {
                aVar.e(3, this.LAr);
            }
            aVar.aM(4, this.trl);
            AppMethodBeat.o(196087);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LAp != null ? g.a.a.b.b.a.f(1, this.LAp) + 0 : 0;
            if (this.LAq != null) {
                f2 += g.a.a.b.b.a.f(2, this.LAq);
            }
            if (this.LAr != null) {
                f2 += g.a.a.b.b.a.f(3, this.LAr);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.trl);
            AppMethodBeat.o(196087);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196087);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aoi aoi = (aoi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aoi.LAp = aVar3.UbS.readString();
                    AppMethodBeat.o(196087);
                    return 0;
                case 2:
                    aoi.LAq = aVar3.UbS.readString();
                    AppMethodBeat.o(196087);
                    return 0;
                case 3:
                    aoi.LAr = aVar3.UbS.readString();
                    AppMethodBeat.o(196087);
                    return 0;
                case 4:
                    aoi.trl = aVar3.UbS.zi();
                    AppMethodBeat.o(196087);
                    return 0;
                default:
                    AppMethodBeat.o(196087);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196087);
            return -1;
        }
    }
}
