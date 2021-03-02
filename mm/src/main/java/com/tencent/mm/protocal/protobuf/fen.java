package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fen extends a {
    public LinkedList<Integer> NnI = new LinkedList<>();
    public fem NzO;
    public LinkedList<Integer> NzP = new LinkedList<>();
    public int NzQ;
    public int NzR;

    public fen() {
        AppMethodBeat.i(153338);
        AppMethodBeat.o(153338);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153339);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NzO != null) {
                aVar.ni(1, this.NzO.computeSize());
                this.NzO.writeFields(aVar);
            }
            aVar.e(2, 2, this.NzP);
            aVar.e(3, 2, this.NnI);
            aVar.aM(4, this.NzQ);
            aVar.aM(5, this.NzR);
            AppMethodBeat.o(153339);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.NzO != null ? g.a.a.a.nh(1, this.NzO.computeSize()) + 0 : 0) + g.a.a.a.c(2, 2, this.NzP) + g.a.a.a.c(3, 2, this.NnI) + g.a.a.b.b.a.bu(4, this.NzQ) + g.a.a.b.b.a.bu(5, this.NzR);
            AppMethodBeat.o(153339);
            return nh;
        } else if (i2 == 2) {
            this.NzP.clear();
            this.NnI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153339);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fen fen = (fen) objArr[1];
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
                        fen.NzO = fem;
                    }
                    AppMethodBeat.o(153339);
                    return 0;
                case 2:
                    fen.NzP.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(153339);
                    return 0;
                case 3:
                    fen.NnI.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(153339);
                    return 0;
                case 4:
                    fen.NzQ = aVar3.UbS.zi();
                    AppMethodBeat.o(153339);
                    return 0;
                case 5:
                    fen.NzR = aVar3.UbS.zi();
                    AppMethodBeat.o(153339);
                    return 0;
                default:
                    AppMethodBeat.o(153339);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153339);
            return -1;
        }
    }
}
