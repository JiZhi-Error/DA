package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ayt extends a {
    public String dMj;
    public int opType;
    public long refObjectId;
    public String refObjectNonceId;
    public String scene;
    public long tuj;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169012);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.opType);
            aVar.bb(2, this.refObjectId);
            aVar.bb(3, this.tuj);
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            if (this.dMj != null) {
                aVar.e(5, this.dMj);
            }
            if (this.refObjectNonceId != null) {
                aVar.e(6, this.refObjectNonceId);
            }
            if (this.scene != null) {
                aVar.e(7, this.scene);
            }
            AppMethodBeat.o(169012);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.opType) + 0 + g.a.a.b.b.a.r(2, this.refObjectId) + g.a.a.b.b.a.r(3, this.tuj);
            if (this.username != null) {
                bu += g.a.a.b.b.a.f(4, this.username);
            }
            if (this.dMj != null) {
                bu += g.a.a.b.b.a.f(5, this.dMj);
            }
            if (this.refObjectNonceId != null) {
                bu += g.a.a.b.b.a.f(6, this.refObjectNonceId);
            }
            if (this.scene != null) {
                bu += g.a.a.b.b.a.f(7, this.scene);
            }
            AppMethodBeat.o(169012);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169012);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ayt ayt = (ayt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayt.opType = aVar3.UbS.zi();
                    AppMethodBeat.o(169012);
                    return 0;
                case 2:
                    ayt.refObjectId = aVar3.UbS.zl();
                    AppMethodBeat.o(169012);
                    return 0;
                case 3:
                    ayt.tuj = aVar3.UbS.zl();
                    AppMethodBeat.o(169012);
                    return 0;
                case 4:
                    ayt.username = aVar3.UbS.readString();
                    AppMethodBeat.o(169012);
                    return 0;
                case 5:
                    ayt.dMj = aVar3.UbS.readString();
                    AppMethodBeat.o(169012);
                    return 0;
                case 6:
                    ayt.refObjectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(169012);
                    return 0;
                case 7:
                    ayt.scene = aVar3.UbS.readString();
                    AppMethodBeat.o(169012);
                    return 0;
                default:
                    AppMethodBeat.o(169012);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169012);
            return -1;
        }
    }
}
