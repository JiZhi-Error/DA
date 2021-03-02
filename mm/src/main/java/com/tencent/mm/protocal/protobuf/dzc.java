package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dzc extends a {
    public dqi MYD;
    public dqi MYF;
    public int MYG;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125764);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MYD != null) {
                aVar.ni(1, this.MYD.computeSize());
                this.MYD.writeFields(aVar);
            }
            aVar.aM(2, this.xub);
            if (this.MYF != null) {
                aVar.ni(3, this.MYF.computeSize());
                this.MYF.writeFields(aVar);
            }
            aVar.aM(4, this.MYG);
            AppMethodBeat.o(125764);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.MYD != null ? g.a.a.a.nh(1, this.MYD.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xub);
            if (this.MYF != null) {
                nh += g.a.a.a.nh(3, this.MYF.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MYG);
            AppMethodBeat.o(125764);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125764);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzc dzc = (dzc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        dzc.MYD = dqi;
                    }
                    AppMethodBeat.o(125764);
                    return 0;
                case 2:
                    dzc.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(125764);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        dzc.MYF = dqi2;
                    }
                    AppMethodBeat.o(125764);
                    return 0;
                case 4:
                    dzc.MYG = aVar3.UbS.zi();
                    AppMethodBeat.o(125764);
                    return 0;
                default:
                    AppMethodBeat.o(125764);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125764);
            return -1;
        }
    }
}
