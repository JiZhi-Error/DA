package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cab extends a {
    public String Lqy;
    public int Lqz;
    public String ynY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147769);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lqy != null) {
                aVar.e(1, this.Lqy);
            }
            aVar.aM(2, this.Lqz);
            if (this.ynY != null) {
                aVar.e(3, this.ynY);
            }
            AppMethodBeat.o(147769);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Lqy != null ? g.a.a.b.b.a.f(1, this.Lqy) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Lqz);
            if (this.ynY != null) {
                f2 += g.a.a.b.b.a.f(3, this.ynY);
            }
            AppMethodBeat.o(147769);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147769);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cab cab = (cab) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cab.Lqy = aVar3.UbS.readString();
                    AppMethodBeat.o(147769);
                    return 0;
                case 2:
                    cab.Lqz = aVar3.UbS.zi();
                    AppMethodBeat.o(147769);
                    return 0;
                case 3:
                    cab.ynY = aVar3.UbS.readString();
                    AppMethodBeat.o(147769);
                    return 0;
                default:
                    AppMethodBeat.o(147769);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147769);
            return -1;
        }
    }
}
