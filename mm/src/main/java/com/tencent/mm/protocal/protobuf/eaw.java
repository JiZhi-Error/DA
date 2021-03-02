package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eaw extends a {
    public long Nar;
    public LinkedList<dqi> oTA = new LinkedList<>();
    public int oTz;
    public String xMo;

    public eaw() {
        AppMethodBeat.i(125816);
        AppMethodBeat.o(125816);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125817);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Nar);
            if (this.xMo != null) {
                aVar.e(2, this.xMo);
            }
            aVar.aM(3, this.oTz);
            aVar.e(4, 8, this.oTA);
            AppMethodBeat.o(125817);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Nar) + 0;
            if (this.xMo != null) {
                r += g.a.a.b.b.a.f(2, this.xMo);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.oTz) + g.a.a.a.c(4, 8, this.oTA);
            AppMethodBeat.o(125817);
            return bu;
        } else if (i2 == 2) {
            this.oTA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125817);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eaw eaw = (eaw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eaw.Nar = aVar3.UbS.zl();
                    AppMethodBeat.o(125817);
                    return 0;
                case 2:
                    eaw.xMo = aVar3.UbS.readString();
                    AppMethodBeat.o(125817);
                    return 0;
                case 3:
                    eaw.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(125817);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        eaw.oTA.add(dqi);
                    }
                    AppMethodBeat.o(125817);
                    return 0;
                default:
                    AppMethodBeat.o(125817);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125817);
            return -1;
        }
    }
}
