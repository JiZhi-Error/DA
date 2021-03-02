package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dcw extends a {
    public String MEr;
    public String UID;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209802);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MEr != null) {
                aVar.e(1, this.MEr);
            }
            if (this.UID != null) {
                aVar.e(2, this.UID);
            }
            AppMethodBeat.o(209802);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MEr != null ? g.a.a.b.b.a.f(1, this.MEr) + 0 : 0;
            if (this.UID != null) {
                f2 += g.a.a.b.b.a.f(2, this.UID);
            }
            AppMethodBeat.o(209802);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209802);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcw dcw = (dcw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcw.MEr = aVar3.UbS.readString();
                    AppMethodBeat.o(209802);
                    return 0;
                case 2:
                    dcw.UID = aVar3.UbS.readString();
                    AppMethodBeat.o(209802);
                    return 0;
                default:
                    AppMethodBeat.o(209802);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209802);
            return -1;
        }
    }
}
