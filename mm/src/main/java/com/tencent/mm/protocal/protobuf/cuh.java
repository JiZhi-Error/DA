package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cuh extends a {
    public int MzA;
    public String desc;
    public String nBo;
    public String scope;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82463);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.aM(3, this.MzA);
            if (this.nBo != null) {
                aVar.e(4, this.nBo);
            }
            AppMethodBeat.o(82463);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.scope != null ? g.a.a.b.b.a.f(1, this.scope) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MzA);
            if (this.nBo != null) {
                bu += g.a.a.b.b.a.f(4, this.nBo);
            }
            AppMethodBeat.o(82463);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82463);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cuh cuh = (cuh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuh.scope = aVar3.UbS.readString();
                    AppMethodBeat.o(82463);
                    return 0;
                case 2:
                    cuh.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(82463);
                    return 0;
                case 3:
                    cuh.MzA = aVar3.UbS.zi();
                    AppMethodBeat.o(82463);
                    return 0;
                case 4:
                    cuh.nBo = aVar3.UbS.readString();
                    AppMethodBeat.o(82463);
                    return 0;
                default:
                    AppMethodBeat.o(82463);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82463);
            return -1;
        }
    }
}
