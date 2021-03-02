package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cc extends a {
    public String desc;
    public LinkedList<cm> pWe = new LinkedList<>();
    public String summary;
    public String title;
    public String url;

    public cc() {
        AppMethodBeat.i(41787);
        AppMethodBeat.o(41787);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41788);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.summary != null) {
                aVar.e(1, this.summary);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.e(3, 8, this.pWe);
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            AppMethodBeat.o(41788);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.summary != null ? g.a.a.b.b.a.f(1, this.summary) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.pWe);
            if (this.url != null) {
                c2 += g.a.a.b.b.a.f(4, this.url);
            }
            if (this.title != null) {
                c2 += g.a.a.b.b.a.f(5, this.title);
            }
            AppMethodBeat.o(41788);
            return c2;
        } else if (i2 == 2) {
            this.pWe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41788);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cc ccVar = (cc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ccVar.summary = aVar3.UbS.readString();
                    AppMethodBeat.o(41788);
                    return 0;
                case 2:
                    ccVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(41788);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cm cmVar = new cm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cmVar.populateBuilderWithField(aVar4, cmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ccVar.pWe.add(cmVar);
                    }
                    AppMethodBeat.o(41788);
                    return 0;
                case 4:
                    ccVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(41788);
                    return 0;
                case 5:
                    ccVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(41788);
                    return 0;
                default:
                    AppMethodBeat.o(41788);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41788);
            return -1;
        }
    }
}
