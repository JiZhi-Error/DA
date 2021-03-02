package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cs extends a {
    public String Title;
    public String xKd;
    public LinkedList<da> xuZ = new LinkedList<>();

    public cs() {
        AppMethodBeat.i(41806);
        AppMethodBeat.o(41806);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41807);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41807);
                throw bVar;
            } else if (this.xKd == null) {
                b bVar2 = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(41807);
                throw bVar2;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                aVar.e(2, 8, this.xuZ);
                if (this.xKd != null) {
                    aVar.e(3, this.xKd);
                }
                AppMethodBeat.o(41807);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = (this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0) + g.a.a.a.c(2, 8, this.xuZ);
            if (this.xKd != null) {
                f2 += g.a.a.b.b.a.f(3, this.xKd);
            }
            AppMethodBeat.o(41807);
            return f2;
        } else if (i2 == 2) {
            this.xuZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar3 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41807);
                throw bVar3;
            } else if (this.xKd == null) {
                b bVar4 = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(41807);
                throw bVar4;
            } else {
                AppMethodBeat.o(41807);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cs csVar = (cs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    csVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41807);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        da daVar = new da();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = daVar.populateBuilderWithField(aVar4, daVar, a.getNextFieldNumber(aVar4))) {
                        }
                        csVar.xuZ.add(daVar);
                    }
                    AppMethodBeat.o(41807);
                    return 0;
                case 3:
                    csVar.xKd = aVar3.UbS.readString();
                    AppMethodBeat.o(41807);
                    return 0;
                default:
                    AppMethodBeat.o(41807);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41807);
            return -1;
        }
    }
}
