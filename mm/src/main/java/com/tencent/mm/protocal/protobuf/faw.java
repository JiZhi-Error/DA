package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class faw extends a {
    public String Nxh;
    public LinkedList<String> Nxi = new LinkedList<>();

    public faw() {
        AppMethodBeat.i(212146);
        AppMethodBeat.o(212146);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212147);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nxh != null) {
                aVar.e(1, this.Nxh);
            }
            aVar.e(2, 1, this.Nxi);
            AppMethodBeat.o(212147);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Nxh != null ? g.a.a.b.b.a.f(1, this.Nxh) + 0 : 0) + g.a.a.a.c(2, 1, this.Nxi);
            AppMethodBeat.o(212147);
            return f2;
        } else if (i2 == 2) {
            this.Nxi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212147);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            faw faw = (faw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    faw.Nxh = aVar3.UbS.readString();
                    AppMethodBeat.o(212147);
                    return 0;
                case 2:
                    faw.Nxi.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212147);
                    return 0;
                default:
                    AppMethodBeat.o(212147);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212147);
            return -1;
        }
    }
}