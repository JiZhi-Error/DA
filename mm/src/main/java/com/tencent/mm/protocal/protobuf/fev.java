package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fev extends a {
    public int NAj;
    public fem NzO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153348);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NzO != null) {
                aVar.ni(1, this.NzO.computeSize());
                this.NzO.writeFields(aVar);
            }
            aVar.aM(2, this.NAj);
            AppMethodBeat.o(153348);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.NzO != null ? g.a.a.a.nh(1, this.NzO.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.NAj);
            AppMethodBeat.o(153348);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153348);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fev fev = (fev) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fem fem = new fem();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fem.populateBuilderWithField(aVar4, fem, a.getNextFieldNumber(aVar4))) {
                        }
                        fev.NzO = fem;
                    }
                    AppMethodBeat.o(153348);
                    return 0;
                case 2:
                    fev.NAj = aVar3.UbS.zi();
                    AppMethodBeat.o(153348);
                    return 0;
                default:
                    AppMethodBeat.o(153348);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153348);
            return -1;
        }
    }
}
