package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bbp extends a {
    public int LKV;
    public LinkedList<String> LKW = new LinkedList<>();
    public String path;

    public bbp() {
        AppMethodBeat.i(209657);
        AppMethodBeat.o(209657);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209658);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.path != null) {
                aVar.e(1, this.path);
            }
            aVar.aM(2, this.LKV);
            aVar.e(3, 1, this.LKW);
            AppMethodBeat.o(209658);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.path != null ? g.a.a.b.b.a.f(1, this.path) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LKV) + g.a.a.a.c(3, 1, this.LKW);
            AppMethodBeat.o(209658);
            return f2;
        } else if (i2 == 2) {
            this.LKW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209658);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bbp bbp = (bbp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbp.path = aVar3.UbS.readString();
                    AppMethodBeat.o(209658);
                    return 0;
                case 2:
                    bbp.LKV = aVar3.UbS.zi();
                    AppMethodBeat.o(209658);
                    return 0;
                case 3:
                    bbp.LKW.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209658);
                    return 0;
                default:
                    AppMethodBeat.o(209658);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209658);
            return -1;
        }
    }
}
