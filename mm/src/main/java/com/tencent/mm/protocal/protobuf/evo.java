package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class evo extends a {
    public String Ntq;
    public String dCo;
    public String dCp;
    public long timestamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147800);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dCo != null) {
                aVar.e(1, this.dCo);
            }
            if (this.dCp != null) {
                aVar.e(2, this.dCp);
            }
            if (this.Ntq != null) {
                aVar.e(3, this.Ntq);
            }
            aVar.bb(4, this.timestamp);
            AppMethodBeat.o(147800);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dCo != null ? g.a.a.b.b.a.f(1, this.dCo) + 0 : 0;
            if (this.dCp != null) {
                f2 += g.a.a.b.b.a.f(2, this.dCp);
            }
            if (this.Ntq != null) {
                f2 += g.a.a.b.b.a.f(3, this.Ntq);
            }
            int r = f2 + g.a.a.b.b.a.r(4, this.timestamp);
            AppMethodBeat.o(147800);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147800);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evo evo = (evo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    evo.dCo = aVar3.UbS.readString();
                    AppMethodBeat.o(147800);
                    return 0;
                case 2:
                    evo.dCp = aVar3.UbS.readString();
                    AppMethodBeat.o(147800);
                    return 0;
                case 3:
                    evo.Ntq = aVar3.UbS.readString();
                    AppMethodBeat.o(147800);
                    return 0;
                case 4:
                    evo.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(147800);
                    return 0;
                default:
                    AppMethodBeat.o(147800);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147800);
            return -1;
        }
    }
}