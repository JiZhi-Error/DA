package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cfm extends a {
    public boolean Mlw;
    public dlx Mlx;
    public String dQx;
    public String lHA;
    public String lHB;
    public String title;
    public int uSc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91528);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.uSc);
            aVar.cc(2, this.Mlw);
            if (this.dQx != null) {
                aVar.e(3, this.dQx);
            }
            if (this.lHA != null) {
                aVar.e(4, this.lHA);
            }
            if (this.lHB != null) {
                aVar.e(5, this.lHB);
            }
            if (this.Mlx != null) {
                aVar.ni(6, this.Mlx.computeSize());
                this.Mlx.writeFields(aVar);
            }
            if (this.title != null) {
                aVar.e(7, this.title);
            }
            AppMethodBeat.o(91528);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.uSc) + 0 + g.a.a.b.b.a.fS(2) + 1;
            if (this.dQx != null) {
                bu += g.a.a.b.b.a.f(3, this.dQx);
            }
            if (this.lHA != null) {
                bu += g.a.a.b.b.a.f(4, this.lHA);
            }
            if (this.lHB != null) {
                bu += g.a.a.b.b.a.f(5, this.lHB);
            }
            if (this.Mlx != null) {
                bu += g.a.a.a.nh(6, this.Mlx.computeSize());
            }
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(7, this.title);
            }
            AppMethodBeat.o(91528);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91528);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cfm cfm = (cfm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cfm.uSc = aVar3.UbS.zi();
                    AppMethodBeat.o(91528);
                    return 0;
                case 2:
                    cfm.Mlw = aVar3.UbS.yZ();
                    AppMethodBeat.o(91528);
                    return 0;
                case 3:
                    cfm.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(91528);
                    return 0;
                case 4:
                    cfm.lHA = aVar3.UbS.readString();
                    AppMethodBeat.o(91528);
                    return 0;
                case 5:
                    cfm.lHB = aVar3.UbS.readString();
                    AppMethodBeat.o(91528);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dlx dlx = new dlx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dlx.populateBuilderWithField(aVar4, dlx, a.getNextFieldNumber(aVar4))) {
                        }
                        cfm.Mlx = dlx;
                    }
                    AppMethodBeat.o(91528);
                    return 0;
                case 7:
                    cfm.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91528);
                    return 0;
                default:
                    AppMethodBeat.o(91528);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91528);
            return -1;
        }
    }
}
