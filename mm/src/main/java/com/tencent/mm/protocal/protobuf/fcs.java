package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fcs extends a {
    public int KSa;
    public LinkedList<vd> LpM = new LinkedList<>();
    public LinkedList<fbn> Mee = new LinkedList<>();
    public int NyD;
    public String NyE;
    public String NyF;
    public int NyG;
    public gi NyH;

    public fcs() {
        AppMethodBeat.i(123694);
        AppMethodBeat.o(123694);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123695);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KSa);
            aVar.aM(2, this.NyD);
            if (this.NyE != null) {
                aVar.e(3, this.NyE);
            }
            if (this.NyF != null) {
                aVar.e(4, this.NyF);
            }
            aVar.aM(5, this.NyG);
            aVar.e(6, 8, this.LpM);
            if (this.NyH != null) {
                aVar.ni(7, this.NyH.computeSize());
                this.NyH.writeFields(aVar);
            }
            aVar.e(36, 8, this.Mee);
            AppMethodBeat.o(123695);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KSa) + 0 + g.a.a.b.b.a.bu(2, this.NyD);
            if (this.NyE != null) {
                bu += g.a.a.b.b.a.f(3, this.NyE);
            }
            if (this.NyF != null) {
                bu += g.a.a.b.b.a.f(4, this.NyF);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.NyG) + g.a.a.a.c(6, 8, this.LpM);
            if (this.NyH != null) {
                bu2 += g.a.a.a.nh(7, this.NyH.computeSize());
            }
            int c2 = bu2 + g.a.a.a.c(36, 8, this.Mee);
            AppMethodBeat.o(123695);
            return c2;
        } else if (i2 == 2) {
            this.LpM.clear();
            this.Mee.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123695);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcs fcs = (fcs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fcs.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(123695);
                    return 0;
                case 2:
                    fcs.NyD = aVar3.UbS.zi();
                    AppMethodBeat.o(123695);
                    return 0;
                case 3:
                    fcs.NyE = aVar3.UbS.readString();
                    AppMethodBeat.o(123695);
                    return 0;
                case 4:
                    fcs.NyF = aVar3.UbS.readString();
                    AppMethodBeat.o(123695);
                    return 0;
                case 5:
                    fcs.NyG = aVar3.UbS.zi();
                    AppMethodBeat.o(123695);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        vd vdVar = new vd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = vdVar.populateBuilderWithField(aVar4, vdVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fcs.LpM.add(vdVar);
                    }
                    AppMethodBeat.o(123695);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        gi giVar = new gi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = giVar.populateBuilderWithField(aVar5, giVar, a.getNextFieldNumber(aVar5))) {
                        }
                        fcs.NyH = giVar;
                    }
                    AppMethodBeat.o(123695);
                    return 0;
                case 36:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fbn fbn = new fbn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fbn.populateBuilderWithField(aVar6, fbn, a.getNextFieldNumber(aVar6))) {
                        }
                        fcs.Mee.add(fbn);
                    }
                    AppMethodBeat.o(123695);
                    return 0;
                default:
                    AppMethodBeat.o(123695);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123695);
            return -1;
        }
    }
}
