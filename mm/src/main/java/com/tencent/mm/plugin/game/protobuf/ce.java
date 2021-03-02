package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ce extends a {
    public String Title;
    public LinkedList<cf> xMi = new LinkedList<>();
    public String xMj;
    public String xMk;

    public ce() {
        AppMethodBeat.i(41789);
        AppMethodBeat.o(41789);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41790);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41790);
                throw bVar;
            }
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.e(2, 8, this.xMi);
            if (this.xMj != null) {
                aVar.e(3, this.xMj);
            }
            if (this.xMk != null) {
                aVar.e(4, this.xMk);
            }
            AppMethodBeat.o(41790);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0) + g.a.a.a.c(2, 8, this.xMi);
            if (this.xMj != null) {
                f2 += g.a.a.b.b.a.f(3, this.xMj);
            }
            if (this.xMk != null) {
                f2 += g.a.a.b.b.a.f(4, this.xMk);
            }
            AppMethodBeat.o(41790);
            return f2;
        } else if (i2 == 2) {
            this.xMi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar2 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41790);
                throw bVar2;
            }
            AppMethodBeat.o(41790);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ce ceVar = (ce) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ceVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41790);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cf cfVar = new cf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cfVar.populateBuilderWithField(aVar4, cfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ceVar.xMi.add(cfVar);
                    }
                    AppMethodBeat.o(41790);
                    return 0;
                case 3:
                    ceVar.xMj = aVar3.UbS.readString();
                    AppMethodBeat.o(41790);
                    return 0;
                case 4:
                    ceVar.xMk = aVar3.UbS.readString();
                    AppMethodBeat.o(41790);
                    return 0;
                default:
                    AppMethodBeat.o(41790);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41790);
            return -1;
        }
    }
}
