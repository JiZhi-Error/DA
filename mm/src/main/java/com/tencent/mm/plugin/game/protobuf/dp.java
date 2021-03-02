package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dp extends a {
    public String Title;
    public LinkedList<ay> xJs = new LinkedList<>();
    public String xKE;
    public String xLg;

    public dp() {
        AppMethodBeat.i(41830);
        AppMethodBeat.o(41830);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41831);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.e(2, 8, this.xJs);
            if (this.xKE != null) {
                aVar.e(3, this.xKE);
            }
            if (this.xLg != null) {
                aVar.e(4, this.xLg);
            }
            AppMethodBeat.o(41831);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0) + g.a.a.a.c(2, 8, this.xJs);
            if (this.xKE != null) {
                f2 += g.a.a.b.b.a.f(3, this.xKE);
            }
            if (this.xLg != null) {
                f2 += g.a.a.b.b.a.f(4, this.xLg);
            }
            AppMethodBeat.o(41831);
            return f2;
        } else if (i2 == 2) {
            this.xJs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41831);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dp dpVar = (dp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dpVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41831);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ay ayVar = new ay();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ayVar.populateBuilderWithField(aVar4, ayVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dpVar.xJs.add(ayVar);
                    }
                    AppMethodBeat.o(41831);
                    return 0;
                case 3:
                    dpVar.xKE = aVar3.UbS.readString();
                    AppMethodBeat.o(41831);
                    return 0;
                case 4:
                    dpVar.xLg = aVar3.UbS.readString();
                    AppMethodBeat.o(41831);
                    return 0;
                default:
                    AppMethodBeat.o(41831);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41831);
            return -1;
        }
    }
}
