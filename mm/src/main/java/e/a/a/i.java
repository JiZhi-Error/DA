package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class i extends a {
    public String Bah;
    public String UbK;
    public String UbL;
    public String UbM;
    public String UbN;
    public String UbO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91747);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Bah != null) {
                aVar.e(1, this.Bah);
            }
            if (this.UbK != null) {
                aVar.e(2, this.UbK);
            }
            if (this.UbL != null) {
                aVar.e(3, this.UbL);
            }
            if (this.UbM != null) {
                aVar.e(4, this.UbM);
            }
            if (this.UbN != null) {
                aVar.e(5, this.UbN);
            }
            if (this.UbO != null) {
                aVar.e(6, this.UbO);
            }
            AppMethodBeat.o(91747);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Bah != null ? g.a.a.b.b.a.f(1, this.Bah) + 0 : 0;
            if (this.UbK != null) {
                f2 += g.a.a.b.b.a.f(2, this.UbK);
            }
            if (this.UbL != null) {
                f2 += g.a.a.b.b.a.f(3, this.UbL);
            }
            if (this.UbM != null) {
                f2 += g.a.a.b.b.a.f(4, this.UbM);
            }
            if (this.UbN != null) {
                f2 += g.a.a.b.b.a.f(5, this.UbN);
            }
            if (this.UbO != null) {
                f2 += g.a.a.b.b.a.f(6, this.UbO);
            }
            AppMethodBeat.o(91747);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91747);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.Bah = aVar3.UbS.readString();
                    AppMethodBeat.o(91747);
                    return 0;
                case 2:
                    iVar.UbK = aVar3.UbS.readString();
                    AppMethodBeat.o(91747);
                    return 0;
                case 3:
                    iVar.UbL = aVar3.UbS.readString();
                    AppMethodBeat.o(91747);
                    return 0;
                case 4:
                    iVar.UbM = aVar3.UbS.readString();
                    AppMethodBeat.o(91747);
                    return 0;
                case 5:
                    iVar.UbN = aVar3.UbS.readString();
                    AppMethodBeat.o(91747);
                    return 0;
                case 6:
                    iVar.UbO = aVar3.UbS.readString();
                    AppMethodBeat.o(91747);
                    return 0;
                default:
                    AppMethodBeat.o(91747);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91747);
            return -1;
        }
    }
}
