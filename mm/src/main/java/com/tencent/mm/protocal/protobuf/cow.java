package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cow extends a {
    public LinkedList<String> Mva = new LinkedList<>();
    public String mime;

    public cow() {
        AppMethodBeat.i(116473);
        AppMethodBeat.o(116473);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116474);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.mime != null) {
                aVar.e(1, this.mime);
            }
            aVar.e(2, 1, this.Mva);
            AppMethodBeat.o(116474);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.mime != null ? g.a.a.b.b.a.f(1, this.mime) + 0 : 0) + g.a.a.a.c(2, 1, this.Mva);
            AppMethodBeat.o(116474);
            return f2;
        } else if (i2 == 2) {
            this.Mva.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116474);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cow cow = (cow) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cow.mime = aVar3.UbS.readString();
                    AppMethodBeat.o(116474);
                    return 0;
                case 2:
                    cow.Mva.add(aVar3.UbS.readString());
                    AppMethodBeat.o(116474);
                    return 0;
                default:
                    AppMethodBeat.o(116474);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116474);
            return -1;
        }
    }
}
