package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eri extends a {
    public long Lnw;
    public String NoW;
    public String NoX;
    public LinkedList<esd> NoY = new LinkedList<>();
    public long NoZ;
    public int Npa;
    public String Npb;

    public eri() {
        AppMethodBeat.i(239510);
        AppMethodBeat.o(239510);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(239511);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NoW != null) {
                aVar.e(1, this.NoW);
            }
            aVar.bb(2, this.Lnw);
            if (this.NoX != null) {
                aVar.e(3, this.NoX);
            }
            aVar.e(4, 8, this.NoY);
            aVar.bb(5, this.NoZ);
            aVar.aM(6, this.Npa);
            if (this.Npb != null) {
                aVar.e(7, this.Npb);
            }
            AppMethodBeat.o(239511);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.NoW != null ? g.a.a.b.b.a.f(1, this.NoW) + 0 : 0) + g.a.a.b.b.a.r(2, this.Lnw);
            if (this.NoX != null) {
                f2 += g.a.a.b.b.a.f(3, this.NoX);
            }
            int c2 = f2 + g.a.a.a.c(4, 8, this.NoY) + g.a.a.b.b.a.r(5, this.NoZ) + g.a.a.b.b.a.bu(6, this.Npa);
            if (this.Npb != null) {
                c2 += g.a.a.b.b.a.f(7, this.Npb);
            }
            AppMethodBeat.o(239511);
            return c2;
        } else if (i2 == 2) {
            this.NoY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(239511);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eri eri = (eri) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eri.NoW = aVar3.UbS.readString();
                    AppMethodBeat.o(239511);
                    return 0;
                case 2:
                    eri.Lnw = aVar3.UbS.zl();
                    AppMethodBeat.o(239511);
                    return 0;
                case 3:
                    eri.NoX = aVar3.UbS.readString();
                    AppMethodBeat.o(239511);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        esd esd = new esd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = esd.populateBuilderWithField(aVar4, esd, a.getNextFieldNumber(aVar4))) {
                        }
                        eri.NoY.add(esd);
                    }
                    AppMethodBeat.o(239511);
                    return 0;
                case 5:
                    eri.NoZ = aVar3.UbS.zl();
                    AppMethodBeat.o(239511);
                    return 0;
                case 6:
                    eri.Npa = aVar3.UbS.zi();
                    AppMethodBeat.o(239511);
                    return 0;
                case 7:
                    eri.Npb = aVar3.UbS.readString();
                    AppMethodBeat.o(239511);
                    return 0;
                default:
                    AppMethodBeat.o(239511);
                    return -1;
            }
        } else {
            AppMethodBeat.o(239511);
            return -1;
        }
    }
}
