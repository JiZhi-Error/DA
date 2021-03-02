package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class dlc extends a {
    public String KXA;
    public b LXB;
    public b LXC;
    public String MOZ;
    public b MPa;
    public int Scene;
    public String SessionId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104831);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KXA != null) {
                aVar.e(1, this.KXA);
            }
            if (this.MOZ != null) {
                aVar.e(2, this.MOZ);
            }
            if (this.SessionId != null) {
                aVar.e(3, this.SessionId);
            }
            if (this.LXC != null) {
                aVar.c(4, this.LXC);
            }
            if (this.LXB != null) {
                aVar.c(5, this.LXB);
            }
            aVar.aM(6, this.Scene);
            if (this.MPa != null) {
                aVar.c(7, this.MPa);
            }
            AppMethodBeat.o(104831);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KXA != null ? g.a.a.b.b.a.f(1, this.KXA) + 0 : 0;
            if (this.MOZ != null) {
                f2 += g.a.a.b.b.a.f(2, this.MOZ);
            }
            if (this.SessionId != null) {
                f2 += g.a.a.b.b.a.f(3, this.SessionId);
            }
            if (this.LXC != null) {
                f2 += g.a.a.b.b.a.b(4, this.LXC);
            }
            if (this.LXB != null) {
                f2 += g.a.a.b.b.a.b(5, this.LXB);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.Scene);
            if (this.MPa != null) {
                bu += g.a.a.b.b.a.b(7, this.MPa);
            }
            AppMethodBeat.o(104831);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104831);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlc dlc = (dlc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlc.KXA = aVar3.UbS.readString();
                    AppMethodBeat.o(104831);
                    return 0;
                case 2:
                    dlc.MOZ = aVar3.UbS.readString();
                    AppMethodBeat.o(104831);
                    return 0;
                case 3:
                    dlc.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(104831);
                    return 0;
                case 4:
                    dlc.LXC = aVar3.UbS.hPo();
                    AppMethodBeat.o(104831);
                    return 0;
                case 5:
                    dlc.LXB = aVar3.UbS.hPo();
                    AppMethodBeat.o(104831);
                    return 0;
                case 6:
                    dlc.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(104831);
                    return 0;
                case 7:
                    dlc.MPa = aVar3.UbS.hPo();
                    AppMethodBeat.o(104831);
                    return 0;
                default:
                    AppMethodBeat.o(104831);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104831);
            return -1;
        }
    }
}
