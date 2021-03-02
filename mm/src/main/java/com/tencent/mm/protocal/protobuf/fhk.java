package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fhk extends a {
    public int MQX;
    public int VjA;
    public fhn VjB;
    public LinkedList<fhp> VjC = new LinkedList<>();
    public int Vjz;
    public int pSb;
    public int priority;
    public int ybm;

    public fhk() {
        AppMethodBeat.i(259370);
        AppMethodBeat.o(259370);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259371);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.priority);
            aVar.aM(2, this.Vjz);
            aVar.aM(3, this.MQX);
            aVar.aM(4, this.pSb);
            aVar.aM(5, this.ybm);
            aVar.aM(6, this.VjA);
            if (this.VjB != null) {
                aVar.ni(7, this.VjB.computeSize());
                this.VjB.writeFields(aVar);
            }
            aVar.e(8, 8, this.VjC);
            AppMethodBeat.o(259371);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.priority) + 0 + g.a.a.b.b.a.bu(2, this.Vjz) + g.a.a.b.b.a.bu(3, this.MQX) + g.a.a.b.b.a.bu(4, this.pSb) + g.a.a.b.b.a.bu(5, this.ybm) + g.a.a.b.b.a.bu(6, this.VjA);
            if (this.VjB != null) {
                bu += g.a.a.a.nh(7, this.VjB.computeSize());
            }
            int c2 = bu + g.a.a.a.c(8, 8, this.VjC);
            AppMethodBeat.o(259371);
            return c2;
        } else if (i2 == 2) {
            this.VjC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259371);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fhk fhk = (fhk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fhk.priority = aVar3.UbS.zi();
                    AppMethodBeat.o(259371);
                    return 0;
                case 2:
                    fhk.Vjz = aVar3.UbS.zi();
                    AppMethodBeat.o(259371);
                    return 0;
                case 3:
                    fhk.MQX = aVar3.UbS.zi();
                    AppMethodBeat.o(259371);
                    return 0;
                case 4:
                    fhk.pSb = aVar3.UbS.zi();
                    AppMethodBeat.o(259371);
                    return 0;
                case 5:
                    fhk.ybm = aVar3.UbS.zi();
                    AppMethodBeat.o(259371);
                    return 0;
                case 6:
                    fhk.VjA = aVar3.UbS.zi();
                    AppMethodBeat.o(259371);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fhn fhn = new fhn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fhn.populateBuilderWithField(aVar4, fhn, a.getNextFieldNumber(aVar4))) {
                        }
                        fhk.VjB = fhn;
                    }
                    AppMethodBeat.o(259371);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fhp fhp = new fhp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fhp.populateBuilderWithField(aVar5, fhp, a.getNextFieldNumber(aVar5))) {
                        }
                        fhk.VjC.add(fhp);
                    }
                    AppMethodBeat.o(259371);
                    return 0;
                default:
                    AppMethodBeat.o(259371);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259371);
            return -1;
        }
    }
}
