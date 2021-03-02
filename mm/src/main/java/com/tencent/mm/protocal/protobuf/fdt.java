package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fdt extends a {
    public String Meq;
    public String Mer;
    public String Nzo;
    public String dPS;
    public String url;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123707);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nzo != null) {
                aVar.e(1, this.Nzo);
            }
            aVar.aM(2, this.version);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.dPS != null) {
                aVar.e(4, this.dPS);
            }
            if (this.Meq != null) {
                aVar.e(5, this.Meq);
            }
            if (this.Mer != null) {
                aVar.e(6, this.Mer);
            }
            AppMethodBeat.o(123707);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Nzo != null ? g.a.a.b.b.a.f(1, this.Nzo) + 0 : 0) + g.a.a.b.b.a.bu(2, this.version);
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(3, this.url);
            }
            if (this.dPS != null) {
                f2 += g.a.a.b.b.a.f(4, this.dPS);
            }
            if (this.Meq != null) {
                f2 += g.a.a.b.b.a.f(5, this.Meq);
            }
            if (this.Mer != null) {
                f2 += g.a.a.b.b.a.f(6, this.Mer);
            }
            AppMethodBeat.o(123707);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123707);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdt fdt = (fdt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdt.Nzo = aVar3.UbS.readString();
                    AppMethodBeat.o(123707);
                    return 0;
                case 2:
                    fdt.version = aVar3.UbS.zi();
                    AppMethodBeat.o(123707);
                    return 0;
                case 3:
                    fdt.url = aVar3.UbS.readString();
                    AppMethodBeat.o(123707);
                    return 0;
                case 4:
                    fdt.dPS = aVar3.UbS.readString();
                    AppMethodBeat.o(123707);
                    return 0;
                case 5:
                    fdt.Meq = aVar3.UbS.readString();
                    AppMethodBeat.o(123707);
                    return 0;
                case 6:
                    fdt.Mer = aVar3.UbS.readString();
                    AppMethodBeat.o(123707);
                    return 0;
                default:
                    AppMethodBeat.o(123707);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123707);
            return -1;
        }
    }
}
