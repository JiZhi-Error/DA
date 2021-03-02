package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fet extends a {
    public String NAg;
    public int NAh;
    public int NAi;
    public LinkedList<Integer> NnI = new LinkedList<>();
    public fem NzO;

    public fet() {
        AppMethodBeat.i(153345);
        AppMethodBeat.o(153345);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153346);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NzO != null) {
                aVar.ni(1, this.NzO.computeSize());
                this.NzO.writeFields(aVar);
            }
            if (this.NAg != null) {
                aVar.e(2, this.NAg);
            }
            aVar.e(3, 2, this.NnI);
            aVar.aM(4, this.NAh);
            aVar.aM(5, this.NAi);
            AppMethodBeat.o(153346);
            return 0;
        } else if (i2 == 1) {
            int nh = this.NzO != null ? g.a.a.a.nh(1, this.NzO.computeSize()) + 0 : 0;
            if (this.NAg != null) {
                nh += g.a.a.b.b.a.f(2, this.NAg);
            }
            int c2 = nh + g.a.a.a.c(3, 2, this.NnI) + g.a.a.b.b.a.bu(4, this.NAh) + g.a.a.b.b.a.bu(5, this.NAi);
            AppMethodBeat.o(153346);
            return c2;
        } else if (i2 == 2) {
            this.NnI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153346);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fet fet = (fet) objArr[1];
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
                        fet.NzO = fem;
                    }
                    AppMethodBeat.o(153346);
                    return 0;
                case 2:
                    fet.NAg = aVar3.UbS.readString();
                    AppMethodBeat.o(153346);
                    return 0;
                case 3:
                    fet.NnI.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(153346);
                    return 0;
                case 4:
                    fet.NAh = aVar3.UbS.zi();
                    AppMethodBeat.o(153346);
                    return 0;
                case 5:
                    fet.NAi = aVar3.UbS.zi();
                    AppMethodBeat.o(153346);
                    return 0;
                default:
                    AppMethodBeat.o(153346);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153346);
            return -1;
        }
    }
}
