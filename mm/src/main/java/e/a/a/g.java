package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class g extends a {
    public String MFd;
    public String MFe;
    public int MFf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91745);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MFd != null) {
                aVar.e(1, this.MFd);
            }
            if (this.MFe != null) {
                aVar.e(2, this.MFe);
            }
            aVar.aM(3, this.MFf);
            AppMethodBeat.o(91745);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MFd != null ? g.a.a.b.b.a.f(1, this.MFd) + 0 : 0;
            if (this.MFe != null) {
                f2 += g.a.a.b.b.a.f(2, this.MFe);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MFf);
            AppMethodBeat.o(91745);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91745);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.MFd = aVar3.UbS.readString();
                    AppMethodBeat.o(91745);
                    return 0;
                case 2:
                    gVar.MFe = aVar3.UbS.readString();
                    AppMethodBeat.o(91745);
                    return 0;
                case 3:
                    gVar.MFf = aVar3.UbS.zi();
                    AppMethodBeat.o(91745);
                    return 0;
                default:
                    AppMethodBeat.o(91745);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91745);
            return -1;
        }
    }
}