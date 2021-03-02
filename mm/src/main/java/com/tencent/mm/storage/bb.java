package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bb extends a {
    public int OoY;
    public LinkedList<Integer> OoZ = new LinkedList<>();
    public LinkedList<Integer> Opa = new LinkedList<>();
    public LinkedList<Integer> Opb = new LinkedList<>();
    public LinkedList<Long> Opc = new LinkedList<>();
    public LinkedList<Long> Opd = new LinkedList<>();
    public LinkedList<Long> Ope = new LinkedList<>();

    public bb() {
        AppMethodBeat.i(43195);
        AppMethodBeat.o(43195);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43196);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.OoY);
            aVar.e(2, 2, this.OoZ);
            aVar.e(3, 2, this.Opa);
            aVar.e(4, 2, this.Opb);
            aVar.e(5, 3, this.Opc);
            aVar.e(6, 3, this.Opd);
            aVar.e(7, 3, this.Ope);
            AppMethodBeat.o(43196);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.OoY) + 0 + g.a.a.a.c(2, 2, this.OoZ) + g.a.a.a.c(3, 2, this.Opa) + g.a.a.a.c(4, 2, this.Opb) + g.a.a.a.c(5, 3, this.Opc) + g.a.a.a.c(6, 3, this.Opd) + g.a.a.a.c(7, 3, this.Ope);
            AppMethodBeat.o(43196);
            return bu;
        } else if (i2 == 2) {
            this.OoZ.clear();
            this.Opa.clear();
            this.Opb.clear();
            this.Opc.clear();
            this.Opd.clear();
            this.Ope.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43196);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bb bbVar = (bb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbVar.OoY = aVar3.UbS.zi();
                    AppMethodBeat.o(43196);
                    return 0;
                case 2:
                    bbVar.OoZ.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(43196);
                    return 0;
                case 3:
                    bbVar.Opa.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(43196);
                    return 0;
                case 4:
                    bbVar.Opb.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(43196);
                    return 0;
                case 5:
                    bbVar.Opc.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(43196);
                    return 0;
                case 6:
                    bbVar.Opd.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(43196);
                    return 0;
                case 7:
                    bbVar.Ope.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(43196);
                    return 0;
                default:
                    AppMethodBeat.o(43196);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43196);
            return -1;
        }
    }
}
