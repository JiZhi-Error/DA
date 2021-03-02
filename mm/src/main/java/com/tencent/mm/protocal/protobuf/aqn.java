package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aqn extends dop {
    public aov LAI;
    public int actionType;
    public String finderUsername;
    public LinkedList<alc> twP = new LinkedList<>();

    public aqn() {
        AppMethodBeat.i(209378);
        AppMethodBeat.o(209378);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209379);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.finderUsername != null) {
                aVar.e(2, this.finderUsername);
            }
            aVar.aM(3, this.actionType);
            aVar.e(4, 8, this.twP);
            if (this.LAI != null) {
                aVar.ni(5, this.LAI.computeSize());
                this.LAI.writeFields(aVar);
            }
            AppMethodBeat.o(209379);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.finderUsername != null) {
                nh += g.a.a.b.b.a.f(2, this.finderUsername);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.actionType) + g.a.a.a.c(4, 8, this.twP);
            if (this.LAI != null) {
                bu += g.a.a.a.nh(5, this.LAI.computeSize());
            }
            AppMethodBeat.o(209379);
            return bu;
        } else if (i2 == 2) {
            this.twP.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209379);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqn aqn = (aqn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        aqn.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209379);
                    return 0;
                case 2:
                    aqn.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(209379);
                    return 0;
                case 3:
                    aqn.actionType = aVar3.UbS.zi();
                    AppMethodBeat.o(209379);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        alc alc = new alc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = alc.populateBuilderWithField(aVar5, alc, dop.getNextFieldNumber(aVar5))) {
                        }
                        aqn.twP.add(alc);
                    }
                    AppMethodBeat.o(209379);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aov.populateBuilderWithField(aVar6, aov, dop.getNextFieldNumber(aVar6))) {
                        }
                        aqn.LAI = aov;
                    }
                    AppMethodBeat.o(209379);
                    return 0;
                default:
                    AppMethodBeat.o(209379);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209379);
            return -1;
        }
    }
}
