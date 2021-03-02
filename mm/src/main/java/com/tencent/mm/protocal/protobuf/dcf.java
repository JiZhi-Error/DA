package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dcf extends a {
    public String MHa;
    public LinkedList<String> MHb = new LinkedList<>();

    public dcf() {
        AppMethodBeat.i(209780);
        AppMethodBeat.o(209780);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209781);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MHa != null) {
                aVar.e(1, this.MHa);
            }
            aVar.e(2, 1, this.MHb);
            AppMethodBeat.o(209781);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MHa != null ? g.a.a.b.b.a.f(1, this.MHa) + 0 : 0) + g.a.a.a.c(2, 1, this.MHb);
            AppMethodBeat.o(209781);
            return f2;
        } else if (i2 == 2) {
            this.MHb.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209781);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcf dcf = (dcf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcf.MHa = aVar3.UbS.readString();
                    AppMethodBeat.o(209781);
                    return 0;
                case 2:
                    dcf.MHb.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209781);
                    return 0;
                default:
                    AppMethodBeat.o(209781);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209781);
            return -1;
        }
    }
}
