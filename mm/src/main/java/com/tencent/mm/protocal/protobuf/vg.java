package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class vg extends a {
    public b LfA;
    public LinkedList<eoj> Lfy = new LinkedList<>();
    public b Lfz;

    public vg() {
        AppMethodBeat.i(117854);
        AppMethodBeat.o(117854);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117855);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Lfy);
            if (this.Lfz != null) {
                aVar.c(2, this.Lfz);
            }
            if (this.LfA != null) {
                aVar.c(3, this.LfA);
            }
            AppMethodBeat.o(117855);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Lfy) + 0;
            if (this.Lfz != null) {
                c2 += g.a.a.b.b.a.b(2, this.Lfz);
            }
            if (this.LfA != null) {
                c2 += g.a.a.b.b.a.b(3, this.LfA);
            }
            AppMethodBeat.o(117855);
            return c2;
        } else if (i2 == 2) {
            this.Lfy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117855);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            vg vgVar = (vg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eoj eoj = new eoj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eoj.populateBuilderWithField(aVar4, eoj, a.getNextFieldNumber(aVar4))) {
                        }
                        vgVar.Lfy.add(eoj);
                    }
                    AppMethodBeat.o(117855);
                    return 0;
                case 2:
                    vgVar.Lfz = aVar3.UbS.hPo();
                    AppMethodBeat.o(117855);
                    return 0;
                case 3:
                    vgVar.LfA = aVar3.UbS.hPo();
                    AppMethodBeat.o(117855);
                    return 0;
                default:
                    AppMethodBeat.o(117855);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117855);
            return -1;
        }
    }
}
