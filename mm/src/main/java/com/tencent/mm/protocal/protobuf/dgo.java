package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dgo extends a {
    public cas MLg;
    public adw MLh;
    public qs MLi;
    public int pTI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200222);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.pTI);
            if (this.MLg != null) {
                aVar.ni(2, this.MLg.computeSize());
                this.MLg.writeFields(aVar);
            }
            if (this.MLh != null) {
                aVar.ni(3, this.MLh.computeSize());
                this.MLh.writeFields(aVar);
            }
            if (this.MLi != null) {
                aVar.ni(4, this.MLi.computeSize());
                this.MLi.writeFields(aVar);
            }
            AppMethodBeat.o(200222);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.pTI) + 0;
            if (this.MLg != null) {
                bu += g.a.a.a.nh(2, this.MLg.computeSize());
            }
            if (this.MLh != null) {
                bu += g.a.a.a.nh(3, this.MLh.computeSize());
            }
            if (this.MLi != null) {
                bu += g.a.a.a.nh(4, this.MLi.computeSize());
            }
            AppMethodBeat.o(200222);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200222);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgo dgo = (dgo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dgo.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(200222);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cas cas = new cas();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cas.populateBuilderWithField(aVar4, cas, a.getNextFieldNumber(aVar4))) {
                        }
                        dgo.MLg = cas;
                    }
                    AppMethodBeat.o(200222);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        adw adw = new adw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = adw.populateBuilderWithField(aVar5, adw, a.getNextFieldNumber(aVar5))) {
                        }
                        dgo.MLh = adw;
                    }
                    AppMethodBeat.o(200222);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        qs qsVar = new qs();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = qsVar.populateBuilderWithField(aVar6, qsVar, a.getNextFieldNumber(aVar6))) {
                        }
                        dgo.MLi = qsVar;
                    }
                    AppMethodBeat.o(200222);
                    return 0;
                default:
                    AppMethodBeat.o(200222);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200222);
            return -1;
        }
    }
}
