package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class h extends a {
    public String UbG;
    public String UbH;
    public String UbI;
    public String UbJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91746);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UbG != null) {
                aVar.e(1, this.UbG);
            }
            if (this.UbH != null) {
                aVar.e(2, this.UbH);
            }
            if (this.UbI != null) {
                aVar.e(3, this.UbI);
            }
            if (this.UbJ != null) {
                aVar.e(4, this.UbJ);
            }
            AppMethodBeat.o(91746);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UbG != null ? g.a.a.b.b.a.f(1, this.UbG) + 0 : 0;
            if (this.UbH != null) {
                f2 += g.a.a.b.b.a.f(2, this.UbH);
            }
            if (this.UbI != null) {
                f2 += g.a.a.b.b.a.f(3, this.UbI);
            }
            if (this.UbJ != null) {
                f2 += g.a.a.b.b.a.f(4, this.UbJ);
            }
            AppMethodBeat.o(91746);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91746);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.UbG = aVar3.UbS.readString();
                    AppMethodBeat.o(91746);
                    return 0;
                case 2:
                    hVar.UbH = aVar3.UbS.readString();
                    AppMethodBeat.o(91746);
                    return 0;
                case 3:
                    hVar.UbI = aVar3.UbS.readString();
                    AppMethodBeat.o(91746);
                    return 0;
                case 4:
                    hVar.UbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91746);
                    return 0;
                default:
                    AppMethodBeat.o(91746);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91746);
            return -1;
        }
    }
}
