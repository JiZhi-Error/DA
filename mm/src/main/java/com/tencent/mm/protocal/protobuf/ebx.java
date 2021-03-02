package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ebx extends a {
    public String NbA;
    public String NbB;
    public String NbC;
    public String Nbx;
    public String Nby;
    public String Nbz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200227);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nbx != null) {
                aVar.e(1, this.Nbx);
            }
            if (this.Nby != null) {
                aVar.e(2, this.Nby);
            }
            if (this.Nbz != null) {
                aVar.e(3, this.Nbz);
            }
            if (this.NbA != null) {
                aVar.e(4, this.NbA);
            }
            if (this.NbB != null) {
                aVar.e(5, this.NbB);
            }
            if (this.NbC != null) {
                aVar.e(6, this.NbC);
            }
            AppMethodBeat.o(200227);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Nbx != null ? g.a.a.b.b.a.f(1, this.Nbx) + 0 : 0;
            if (this.Nby != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nby);
            }
            if (this.Nbz != null) {
                f2 += g.a.a.b.b.a.f(3, this.Nbz);
            }
            if (this.NbA != null) {
                f2 += g.a.a.b.b.a.f(4, this.NbA);
            }
            if (this.NbB != null) {
                f2 += g.a.a.b.b.a.f(5, this.NbB);
            }
            if (this.NbC != null) {
                f2 += g.a.a.b.b.a.f(6, this.NbC);
            }
            AppMethodBeat.o(200227);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200227);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebx ebx = (ebx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ebx.Nbx = aVar3.UbS.readString();
                    AppMethodBeat.o(200227);
                    return 0;
                case 2:
                    ebx.Nby = aVar3.UbS.readString();
                    AppMethodBeat.o(200227);
                    return 0;
                case 3:
                    ebx.Nbz = aVar3.UbS.readString();
                    AppMethodBeat.o(200227);
                    return 0;
                case 4:
                    ebx.NbA = aVar3.UbS.readString();
                    AppMethodBeat.o(200227);
                    return 0;
                case 5:
                    ebx.NbB = aVar3.UbS.readString();
                    AppMethodBeat.o(200227);
                    return 0;
                case 6:
                    ebx.NbC = aVar3.UbS.readString();
                    AppMethodBeat.o(200227);
                    return 0;
                default:
                    AppMethodBeat.o(200227);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200227);
            return -1;
        }
    }
}
