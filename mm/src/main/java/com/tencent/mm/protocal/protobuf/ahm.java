package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ahm extends a {
    public int Lrk;
    public ahn Lrl;
    public int Lrm;
    public ahn Lrn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43094);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lrl == null) {
                b bVar = new b("Not all required fields were included: NightTime");
                AppMethodBeat.o(43094);
                throw bVar;
            } else if (this.Lrn == null) {
                b bVar2 = new b("Not all required fields were included: AllDayTime");
                AppMethodBeat.o(43094);
                throw bVar2;
            } else {
                aVar.aM(1, this.Lrk);
                if (this.Lrl != null) {
                    aVar.ni(2, this.Lrl.computeSize());
                    this.Lrl.writeFields(aVar);
                }
                aVar.aM(3, this.Lrm);
                if (this.Lrn != null) {
                    aVar.ni(4, this.Lrn.computeSize());
                    this.Lrn.writeFields(aVar);
                }
                AppMethodBeat.o(43094);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lrk) + 0;
            if (this.Lrl != null) {
                bu += g.a.a.a.nh(2, this.Lrl.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Lrm);
            if (this.Lrn != null) {
                bu2 += g.a.a.a.nh(4, this.Lrn.computeSize());
            }
            AppMethodBeat.o(43094);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lrl == null) {
                b bVar3 = new b("Not all required fields were included: NightTime");
                AppMethodBeat.o(43094);
                throw bVar3;
            } else if (this.Lrn == null) {
                b bVar4 = new b("Not all required fields were included: AllDayTime");
                AppMethodBeat.o(43094);
                throw bVar4;
            } else {
                AppMethodBeat.o(43094);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahm ahm = (ahm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ahm.Lrk = aVar3.UbS.zi();
                    AppMethodBeat.o(43094);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ahn ahn = new ahn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ahn.populateBuilderWithField(aVar4, ahn, a.getNextFieldNumber(aVar4))) {
                        }
                        ahm.Lrl = ahn;
                    }
                    AppMethodBeat.o(43094);
                    return 0;
                case 3:
                    ahm.Lrm = aVar3.UbS.zi();
                    AppMethodBeat.o(43094);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahn ahn2 = new ahn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahn2.populateBuilderWithField(aVar5, ahn2, a.getNextFieldNumber(aVar5))) {
                        }
                        ahm.Lrn = ahn2;
                    }
                    AppMethodBeat.o(43094);
                    return 0;
                default:
                    AppMethodBeat.o(43094);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43094);
            return -1;
        }
    }
}
