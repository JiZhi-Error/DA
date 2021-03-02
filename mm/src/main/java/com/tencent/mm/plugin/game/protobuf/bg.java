package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bg extends a {
    public String IconUrl;
    public String Title;
    public String jfi;
    public String xIx;
    public g xIz;
    public LinkedList<String> xLh = new LinkedList<>();
    public String xLi;
    public String xLj;
    public String xLk;

    public bg() {
        AppMethodBeat.i(41757);
        AppMethodBeat.o(41757);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41758);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            aVar.e(3, 1, this.xLh);
            if (this.xLi != null) {
                aVar.e(4, this.xLi);
            }
            if (this.xIx != null) {
                aVar.e(5, this.xIx);
            }
            if (this.xLj != null) {
                aVar.e(6, this.xLj);
            }
            if (this.xLk != null) {
                aVar.e(8, this.xLk);
            }
            if (this.jfi != null) {
                aVar.e(9, this.jfi);
            }
            if (this.xIz != null) {
                aVar.ni(10, this.xIz.computeSize());
                this.xIz.writeFields(aVar);
            }
            AppMethodBeat.o(41758);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.IconUrl);
            }
            int c2 = f2 + g.a.a.a.c(3, 1, this.xLh);
            if (this.xLi != null) {
                c2 += g.a.a.b.b.a.f(4, this.xLi);
            }
            if (this.xIx != null) {
                c2 += g.a.a.b.b.a.f(5, this.xIx);
            }
            if (this.xLj != null) {
                c2 += g.a.a.b.b.a.f(6, this.xLj);
            }
            if (this.xLk != null) {
                c2 += g.a.a.b.b.a.f(8, this.xLk);
            }
            if (this.jfi != null) {
                c2 += g.a.a.b.b.a.f(9, this.jfi);
            }
            if (this.xIz != null) {
                c2 += g.a.a.a.nh(10, this.xIz.computeSize());
            }
            AppMethodBeat.o(41758);
            return c2;
        } else if (i2 == 2) {
            this.xLh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41758);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bg bgVar = (bg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bgVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41758);
                    return 0;
                case 2:
                    bgVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(41758);
                    return 0;
                case 3:
                    bgVar.xLh.add(aVar3.UbS.readString());
                    AppMethodBeat.o(41758);
                    return 0;
                case 4:
                    bgVar.xLi = aVar3.UbS.readString();
                    AppMethodBeat.o(41758);
                    return 0;
                case 5:
                    bgVar.xIx = aVar3.UbS.readString();
                    AppMethodBeat.o(41758);
                    return 0;
                case 6:
                    bgVar.xLj = aVar3.UbS.readString();
                    AppMethodBeat.o(41758);
                    return 0;
                case 7:
                default:
                    AppMethodBeat.o(41758);
                    return -1;
                case 8:
                    bgVar.xLk = aVar3.UbS.readString();
                    AppMethodBeat.o(41758);
                    return 0;
                case 9:
                    bgVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(41758);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bgVar.xIz = gVar;
                    }
                    AppMethodBeat.o(41758);
                    return 0;
            }
        } else {
            AppMethodBeat.o(41758);
            return -1;
        }
    }
}
