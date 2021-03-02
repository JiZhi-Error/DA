package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class o extends a {
    public String fileName;
    public int jhn;
    public int jhq;
    public int jhr;
    public int maxSize;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(150830);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.fileName != null) {
                aVar.e(1, this.fileName);
            }
            aVar.aM(2, this.jhn);
            aVar.aM(3, this.jhq);
            aVar.aM(4, this.jhr);
            aVar.aM(5, this.maxSize);
            AppMethodBeat.o(150830);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.fileName != null ? g.a.a.b.b.a.f(1, this.fileName) + 0 : 0) + g.a.a.b.b.a.bu(2, this.jhn) + g.a.a.b.b.a.bu(3, this.jhq) + g.a.a.b.b.a.bu(4, this.jhr) + g.a.a.b.b.a.bu(5, this.maxSize);
            AppMethodBeat.o(150830);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(150830);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.fileName = aVar3.UbS.readString();
                    AppMethodBeat.o(150830);
                    return 0;
                case 2:
                    oVar.jhn = aVar3.UbS.zi();
                    AppMethodBeat.o(150830);
                    return 0;
                case 3:
                    oVar.jhq = aVar3.UbS.zi();
                    AppMethodBeat.o(150830);
                    return 0;
                case 4:
                    oVar.jhr = aVar3.UbS.zi();
                    AppMethodBeat.o(150830);
                    return 0;
                case 5:
                    oVar.maxSize = aVar3.UbS.zi();
                    AppMethodBeat.o(150830);
                    return 0;
                default:
                    AppMethodBeat.o(150830);
                    return -1;
            }
        } else {
            AppMethodBeat.o(150830);
            return -1;
        }
    }
}
