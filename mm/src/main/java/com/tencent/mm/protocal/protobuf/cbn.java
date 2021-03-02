package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cbn extends a {
    public String businessId = "";
    public String dataPath;
    public String value;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122514);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.value != null) {
                aVar.e(1, this.value);
            }
            if (this.dataPath != null) {
                aVar.e(2, this.dataPath);
            }
            if (this.businessId != null) {
                aVar.e(3, this.businessId);
            }
            AppMethodBeat.o(122514);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.value != null ? g.a.a.b.b.a.f(1, this.value) + 0 : 0;
            if (this.dataPath != null) {
                f2 += g.a.a.b.b.a.f(2, this.dataPath);
            }
            if (this.businessId != null) {
                f2 += g.a.a.b.b.a.f(3, this.businessId);
            }
            AppMethodBeat.o(122514);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122514);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbn cbn = (cbn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbn.value = aVar3.UbS.readString();
                    AppMethodBeat.o(122514);
                    return 0;
                case 2:
                    cbn.dataPath = aVar3.UbS.readString();
                    AppMethodBeat.o(122514);
                    return 0;
                case 3:
                    cbn.businessId = aVar3.UbS.readString();
                    AppMethodBeat.o(122514);
                    return 0;
                default:
                    AppMethodBeat.o(122514);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122514);
            return -1;
        }
    }
}
