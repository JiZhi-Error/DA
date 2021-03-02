package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class j extends a {
    public String title;
    public LinkedList<g> yUI = new LinkedList<>();

    public j() {
        AppMethodBeat.i(200182);
        AppMethodBeat.o(200182);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200183);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.e(2, 8, this.yUI);
            AppMethodBeat.o(200183);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0) + g.a.a.a.c(2, 8, this.yUI);
            AppMethodBeat.o(200183);
            return f2;
        } else if (i2 == 2) {
            this.yUI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200183);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(200183);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.yUI.add(gVar);
                    }
                    AppMethodBeat.o(200183);
                    return 0;
                default:
                    AppMethodBeat.o(200183);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200183);
            return -1;
        }
    }
}
