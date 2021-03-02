package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dlx extends a {
    public String MPC;
    public String dNI;
    public String gTt;
    public String path;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91668);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            if (this.MPC != null) {
                aVar.e(3, this.MPC);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            if (this.gTt != null) {
                aVar.e(5, this.gTt);
            }
            AppMethodBeat.o(91668);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.dNI != null) {
                bu += g.a.a.b.b.a.f(2, this.dNI);
            }
            if (this.MPC != null) {
                bu += g.a.a.b.b.a.f(3, this.MPC);
            }
            if (this.path != null) {
                bu += g.a.a.b.b.a.f(4, this.path);
            }
            if (this.gTt != null) {
                bu += g.a.a.b.b.a.f(5, this.gTt);
            }
            AppMethodBeat.o(91668);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91668);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlx dlx = (dlx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlx.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91668);
                    return 0;
                case 2:
                    dlx.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(91668);
                    return 0;
                case 3:
                    dlx.MPC = aVar3.UbS.readString();
                    AppMethodBeat.o(91668);
                    return 0;
                case 4:
                    dlx.path = aVar3.UbS.readString();
                    AppMethodBeat.o(91668);
                    return 0;
                case 5:
                    dlx.gTt = aVar3.UbS.readString();
                    AppMethodBeat.o(91668);
                    return 0;
                default:
                    AppMethodBeat.o(91668);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91668);
            return -1;
        }
    }
}
