package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dcg extends a {
    public String ID;
    public String Name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209782);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            AppMethodBeat.o(209782);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ID != null ? g.a.a.b.b.a.f(1, this.ID) + 0 : 0;
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(2, this.Name);
            }
            AppMethodBeat.o(209782);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209782);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcg dcg = (dcg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcg.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(209782);
                    return 0;
                case 2:
                    dcg.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(209782);
                    return 0;
                default:
                    AppMethodBeat.o(209782);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209782);
            return -1;
        }
    }
}