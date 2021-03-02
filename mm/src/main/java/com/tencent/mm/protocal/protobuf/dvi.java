package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dvi extends a {
    public String LPM = "";
    public long LPN = -1;
    public boolean MWo = false;
    public LinkedList<cbm> MWp = new LinkedList<>();
    public String dRM = "";
    public int index = -1;
    public boolean vtY = false;

    public dvi() {
        AppMethodBeat.i(177411);
        AppMethodBeat.o(177411);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(177412);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.index);
            aVar.cc(2, this.MWo);
            if (this.dRM != null) {
                aVar.e(3, this.dRM);
            }
            aVar.bb(4, this.LPN);
            if (this.LPM != null) {
                aVar.e(5, this.LPM);
            }
            aVar.e(6, 8, this.MWp);
            aVar.cc(7, this.vtY);
            AppMethodBeat.o(177412);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.index) + 0 + g.a.a.b.b.a.fS(2) + 1;
            if (this.dRM != null) {
                bu += g.a.a.b.b.a.f(3, this.dRM);
            }
            int r = bu + g.a.a.b.b.a.r(4, this.LPN);
            if (this.LPM != null) {
                r += g.a.a.b.b.a.f(5, this.LPM);
            }
            int c2 = r + g.a.a.a.c(6, 8, this.MWp) + g.a.a.b.b.a.fS(7) + 1;
            AppMethodBeat.o(177412);
            return c2;
        } else if (i2 == 2) {
            this.MWp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(177412);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dvi dvi = (dvi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dvi.index = aVar3.UbS.zi();
                    AppMethodBeat.o(177412);
                    return 0;
                case 2:
                    dvi.MWo = aVar3.UbS.yZ();
                    AppMethodBeat.o(177412);
                    return 0;
                case 3:
                    dvi.dRM = aVar3.UbS.readString();
                    AppMethodBeat.o(177412);
                    return 0;
                case 4:
                    dvi.LPN = aVar3.UbS.zl();
                    AppMethodBeat.o(177412);
                    return 0;
                case 5:
                    dvi.LPM = aVar3.UbS.readString();
                    AppMethodBeat.o(177412);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cbm cbm = new cbm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cbm.populateBuilderWithField(aVar4, cbm, a.getNextFieldNumber(aVar4))) {
                        }
                        dvi.MWp.add(cbm);
                    }
                    AppMethodBeat.o(177412);
                    return 0;
                case 7:
                    dvi.vtY = aVar3.UbS.yZ();
                    AppMethodBeat.o(177412);
                    return 0;
                default:
                    AppMethodBeat.o(177412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(177412);
            return -1;
        }
    }
}
