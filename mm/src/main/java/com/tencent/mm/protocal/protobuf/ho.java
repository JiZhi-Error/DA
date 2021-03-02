package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ho extends a {
    public String KLy;
    public String KLz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123543);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KLy != null) {
                aVar.e(1, this.KLy);
            }
            if (this.KLz != null) {
                aVar.e(2, this.KLz);
            }
            AppMethodBeat.o(123543);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KLy != null ? g.a.a.b.b.a.f(1, this.KLy) + 0 : 0;
            if (this.KLz != null) {
                f2 += g.a.a.b.b.a.f(2, this.KLz);
            }
            AppMethodBeat.o(123543);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123543);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ho hoVar = (ho) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hoVar.KLy = aVar3.UbS.readString();
                    AppMethodBeat.o(123543);
                    return 0;
                case 2:
                    hoVar.KLz = aVar3.UbS.readString();
                    AppMethodBeat.o(123543);
                    return 0;
                default:
                    AppMethodBeat.o(123543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123543);
            return -1;
        }
    }
}
