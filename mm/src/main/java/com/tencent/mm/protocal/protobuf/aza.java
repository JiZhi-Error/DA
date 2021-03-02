package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aza extends dop {
    public aov LBM;
    public LinkedList<Long> LIX = new LinkedList<>();
    public int dYx;
    public String finderUsername;

    public aza() {
        AppMethodBeat.i(209606);
        AppMethodBeat.o(209606);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209607);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.dYx);
            if (this.finderUsername != null) {
                aVar.e(3, this.finderUsername);
            }
            aVar.e(4, 3, this.LIX);
            if (this.LBM != null) {
                aVar.ni(5, this.LBM.computeSize());
                this.LBM.writeFields(aVar);
            }
            AppMethodBeat.o(209607);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dYx);
            if (this.finderUsername != null) {
                nh += g.a.a.b.b.a.f(3, this.finderUsername);
            }
            int c2 = nh + g.a.a.a.c(4, 3, this.LIX);
            if (this.LBM != null) {
                c2 += g.a.a.a.nh(5, this.LBM.computeSize());
            }
            AppMethodBeat.o(209607);
            return c2;
        } else if (i2 == 2) {
            this.LIX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209607);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aza aza = (aza) objArr[1];
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
                        aza.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209607);
                    return 0;
                case 2:
                    aza.dYx = aVar3.UbS.zi();
                    AppMethodBeat.o(209607);
                    return 0;
                case 3:
                    aza.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(209607);
                    return 0;
                case 4:
                    aza.LIX.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(209607);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        aza.LBM = aov;
                    }
                    AppMethodBeat.o(209607);
                    return 0;
                default:
                    AppMethodBeat.o(209607);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209607);
            return -1;
        }
    }
}
