package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dfa extends a {
    public LinkedList<cft> MKb = new LinkedList<>();
    public String id;

    public dfa() {
        AppMethodBeat.i(220720);
        AppMethodBeat.o(220720);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220721);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id == null) {
                b bVar = new b("Not all required fields were included: id");
                AppMethodBeat.o(220721);
                throw bVar;
            }
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            aVar.e(2, 8, this.MKb);
            AppMethodBeat.o(220721);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0) + g.a.a.a.c(2, 8, this.MKb);
            AppMethodBeat.o(220721);
            return f2;
        } else if (i2 == 2) {
            this.MKb.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.id == null) {
                b bVar2 = new b("Not all required fields were included: id");
                AppMethodBeat.o(220721);
                throw bVar2;
            }
            AppMethodBeat.o(220721);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfa dfa = (dfa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dfa.id = aVar3.UbS.readString();
                    AppMethodBeat.o(220721);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cft cft = new cft();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cft.populateBuilderWithField(aVar4, cft, a.getNextFieldNumber(aVar4))) {
                        }
                        dfa.MKb.add(cft);
                    }
                    AppMethodBeat.o(220721);
                    return 0;
                default:
                    AppMethodBeat.o(220721);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220721);
            return -1;
        }
    }
}
