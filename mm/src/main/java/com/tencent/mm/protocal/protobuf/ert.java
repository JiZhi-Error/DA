package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ert extends a {
    public String LmK;
    public long Lnw;
    public String NoW;
    public String NoX;
    public String Npj;
    public b Npk;
    public LinkedList<esc> Npl = new LinkedList<>();

    public ert() {
        AppMethodBeat.i(239527);
        AppMethodBeat.o(239527);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(239528);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NoW != null) {
                aVar.e(1, this.NoW);
            }
            aVar.bb(2, this.Lnw);
            if (this.NoX != null) {
                aVar.e(3, this.NoX);
            }
            if (this.Npj != null) {
                aVar.e(4, this.Npj);
            }
            if (this.LmK != null) {
                aVar.e(5, this.LmK);
            }
            if (this.Npk != null) {
                aVar.c(6, this.Npk);
            }
            aVar.e(7, 8, this.Npl);
            AppMethodBeat.o(239528);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.NoW != null ? g.a.a.b.b.a.f(1, this.NoW) + 0 : 0) + g.a.a.b.b.a.r(2, this.Lnw);
            if (this.NoX != null) {
                f2 += g.a.a.b.b.a.f(3, this.NoX);
            }
            if (this.Npj != null) {
                f2 += g.a.a.b.b.a.f(4, this.Npj);
            }
            if (this.LmK != null) {
                f2 += g.a.a.b.b.a.f(5, this.LmK);
            }
            if (this.Npk != null) {
                f2 += g.a.a.b.b.a.b(6, this.Npk);
            }
            int c2 = f2 + g.a.a.a.c(7, 8, this.Npl);
            AppMethodBeat.o(239528);
            return c2;
        } else if (i2 == 2) {
            this.Npl.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(239528);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ert ert = (ert) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ert.NoW = aVar3.UbS.readString();
                    AppMethodBeat.o(239528);
                    return 0;
                case 2:
                    ert.Lnw = aVar3.UbS.zl();
                    AppMethodBeat.o(239528);
                    return 0;
                case 3:
                    ert.NoX = aVar3.UbS.readString();
                    AppMethodBeat.o(239528);
                    return 0;
                case 4:
                    ert.Npj = aVar3.UbS.readString();
                    AppMethodBeat.o(239528);
                    return 0;
                case 5:
                    ert.LmK = aVar3.UbS.readString();
                    AppMethodBeat.o(239528);
                    return 0;
                case 6:
                    ert.Npk = aVar3.UbS.hPo();
                    AppMethodBeat.o(239528);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        esc esc = new esc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = esc.populateBuilderWithField(aVar4, esc, a.getNextFieldNumber(aVar4))) {
                        }
                        ert.Npl.add(esc);
                    }
                    AppMethodBeat.o(239528);
                    return 0;
                default:
                    AppMethodBeat.o(239528);
                    return -1;
            }
        } else {
            AppMethodBeat.o(239528);
            return -1;
        }
    }
}
