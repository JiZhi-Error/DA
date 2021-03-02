package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eud extends a {
    public int GWf;
    public LinkedList<Integer> NrA = new LinkedList<>();
    public int NrB;
    public LinkedList<Integer> NrC = new LinkedList<>();
    public dmm NrD;
    public dmm Nrx;
    public ahk Nry;
    public int Nrz;

    public eud() {
        AppMethodBeat.i(115897);
        AppMethodBeat.o(115897);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115898);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nrx != null) {
                aVar.ni(1, this.Nrx.computeSize());
                this.Nrx.writeFields(aVar);
            }
            if (this.Nry != null) {
                aVar.ni(2, this.Nry.computeSize());
                this.Nry.writeFields(aVar);
            }
            aVar.aM(3, this.Nrz);
            aVar.f(4, 2, this.NrA);
            aVar.aM(5, this.NrB);
            aVar.f(6, 2, this.NrC);
            aVar.aM(7, this.GWf);
            if (this.NrD != null) {
                aVar.ni(8, this.NrD.computeSize());
                this.NrD.writeFields(aVar);
            }
            AppMethodBeat.o(115898);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Nrx != null ? g.a.a.a.nh(1, this.Nrx.computeSize()) + 0 : 0;
            if (this.Nry != null) {
                nh += g.a.a.a.nh(2, this.Nry.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.Nrz) + g.a.a.a.d(4, 2, this.NrA) + g.a.a.b.b.a.bu(5, this.NrB) + g.a.a.a.d(6, 2, this.NrC) + g.a.a.b.b.a.bu(7, this.GWf);
            if (this.NrD != null) {
                bu += g.a.a.a.nh(8, this.NrD.computeSize());
            }
            AppMethodBeat.o(115898);
            return bu;
        } else if (i2 == 2) {
            this.NrA.clear();
            this.NrC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115898);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eud eud = (eud) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dmm dmm = new dmm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dmm.populateBuilderWithField(aVar4, dmm, a.getNextFieldNumber(aVar4))) {
                        }
                        eud.Nrx = dmm;
                    }
                    AppMethodBeat.o(115898);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahk ahk = new ahk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahk.populateBuilderWithField(aVar5, ahk, a.getNextFieldNumber(aVar5))) {
                        }
                        eud.Nry = ahk;
                    }
                    AppMethodBeat.o(115898);
                    return 0;
                case 3:
                    eud.Nrz = aVar3.UbS.zi();
                    AppMethodBeat.o(115898);
                    return 0;
                case 4:
                    eud.NrA = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(115898);
                    return 0;
                case 5:
                    eud.NrB = aVar3.UbS.zi();
                    AppMethodBeat.o(115898);
                    return 0;
                case 6:
                    eud.NrC = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(115898);
                    return 0;
                case 7:
                    eud.GWf = aVar3.UbS.zi();
                    AppMethodBeat.o(115898);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dmm dmm2 = new dmm();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dmm2.populateBuilderWithField(aVar6, dmm2, a.getNextFieldNumber(aVar6))) {
                        }
                        eud.NrD = dmm2;
                    }
                    AppMethodBeat.o(115898);
                    return 0;
                default:
                    AppMethodBeat.o(115898);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115898);
            return -1;
        }
    }
}
