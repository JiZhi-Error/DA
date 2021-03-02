package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class brp extends a implements dyp {
    public cvw LYS;
    public int ret;

    @Override // com.tencent.mm.protocal.protobuf.dyp
    public final int getRet() {
        return this.ret;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152581);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.ret);
            if (this.LYS != null) {
                aVar.ni(2, this.LYS.computeSize());
                this.LYS.writeFields(aVar);
            }
            AppMethodBeat.o(152581);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.ret) + 0;
            if (this.LYS != null) {
                bu += g.a.a.a.nh(2, this.LYS.computeSize());
            }
            AppMethodBeat.o(152581);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152581);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            brp brp = (brp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    brp.ret = aVar3.UbS.zi();
                    AppMethodBeat.o(152581);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cvw cvw = new cvw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cvw.populateBuilderWithField(aVar4, cvw, a.getNextFieldNumber(aVar4))) {
                        }
                        brp.LYS = cvw;
                    }
                    AppMethodBeat.o(152581);
                    return 0;
                default:
                    AppMethodBeat.o(152581);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152581);
            return -1;
        }
    }
}
