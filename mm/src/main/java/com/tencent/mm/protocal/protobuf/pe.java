package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class pe extends a {
    public int Height;
    public int Width;
    public String xIx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212249);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xIx != null) {
                aVar.e(1, this.xIx);
            }
            aVar.aM(2, this.Width);
            aVar.aM(3, this.Height);
            AppMethodBeat.o(212249);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xIx != null ? g.a.a.b.b.a.f(1, this.xIx) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Width) + g.a.a.b.b.a.bu(3, this.Height);
            AppMethodBeat.o(212249);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212249);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pe peVar = (pe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    peVar.xIx = aVar3.UbS.readString();
                    AppMethodBeat.o(212249);
                    return 0;
                case 2:
                    peVar.Width = aVar3.UbS.zi();
                    AppMethodBeat.o(212249);
                    return 0;
                case 3:
                    peVar.Height = aVar3.UbS.zi();
                    AppMethodBeat.o(212249);
                    return 0;
                default:
                    AppMethodBeat.o(212249);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212249);
            return -1;
        }
    }
}