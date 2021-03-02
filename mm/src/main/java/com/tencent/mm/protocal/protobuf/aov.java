package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aov extends a {
    public int LAQ;
    public b LAR;
    public int LAS;
    public aas LAT;
    public int Viq;
    public int scene;
    public long ulj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168937);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LAQ);
            aVar.aM(2, this.scene);
            if (this.LAR != null) {
                aVar.c(3, this.LAR);
            }
            aVar.aM(4, this.LAS);
            if (this.LAT != null) {
                aVar.ni(5, this.LAT.computeSize());
                this.LAT.writeFields(aVar);
            }
            aVar.bb(6, this.ulj);
            aVar.aM(7, this.Viq);
            AppMethodBeat.o(168937);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LAQ) + 0 + g.a.a.b.b.a.bu(2, this.scene);
            if (this.LAR != null) {
                bu += g.a.a.b.b.a.b(3, this.LAR);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.LAS);
            if (this.LAT != null) {
                bu2 += g.a.a.a.nh(5, this.LAT.computeSize());
            }
            int r = bu2 + g.a.a.b.b.a.r(6, this.ulj) + g.a.a.b.b.a.bu(7, this.Viq);
            AppMethodBeat.o(168937);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168937);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aov aov = (aov) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aov.LAQ = aVar3.UbS.zi();
                    AppMethodBeat.o(168937);
                    return 0;
                case 2:
                    aov.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(168937);
                    return 0;
                case 3:
                    aov.LAR = aVar3.UbS.hPo();
                    AppMethodBeat.o(168937);
                    return 0;
                case 4:
                    aov.LAS = aVar3.UbS.zi();
                    AppMethodBeat.o(168937);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aas aas = new aas();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aas.populateBuilderWithField(aVar4, aas, a.getNextFieldNumber(aVar4))) {
                        }
                        aov.LAT = aas;
                    }
                    AppMethodBeat.o(168937);
                    return 0;
                case 6:
                    aov.ulj = aVar3.UbS.zl();
                    AppMethodBeat.o(168937);
                    return 0;
                case 7:
                    aov.Viq = aVar3.UbS.zi();
                    AppMethodBeat.o(168937);
                    return 0;
                default:
                    AppMethodBeat.o(168937);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168937);
            return -1;
        }
    }
}
