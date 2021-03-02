package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dkt extends a {
    public ait MOJ;
    public String MOK;
    public String MOL;
    public int MOM;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104830);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MOJ != null) {
                aVar.ni(1, this.MOJ.computeSize());
                this.MOJ.writeFields(aVar);
            }
            if (this.MOK != null) {
                aVar.e(2, this.MOK);
            }
            aVar.aM(3, this.type);
            if (this.MOL != null) {
                aVar.e(4, this.MOL);
            }
            aVar.aM(5, this.MOM);
            AppMethodBeat.o(104830);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MOJ != null ? g.a.a.a.nh(1, this.MOJ.computeSize()) + 0 : 0;
            if (this.MOK != null) {
                nh += g.a.a.b.b.a.f(2, this.MOK);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.type);
            if (this.MOL != null) {
                bu += g.a.a.b.b.a.f(4, this.MOL);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MOM);
            AppMethodBeat.o(104830);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104830);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkt dkt = (dkt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ait ait = new ait();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ait.populateBuilderWithField(aVar4, ait, a.getNextFieldNumber(aVar4))) {
                        }
                        dkt.MOJ = ait;
                    }
                    AppMethodBeat.o(104830);
                    return 0;
                case 2:
                    dkt.MOK = aVar3.UbS.readString();
                    AppMethodBeat.o(104830);
                    return 0;
                case 3:
                    dkt.type = aVar3.UbS.zi();
                    AppMethodBeat.o(104830);
                    return 0;
                case 4:
                    dkt.MOL = aVar3.UbS.readString();
                    AppMethodBeat.o(104830);
                    return 0;
                case 5:
                    dkt.MOM = aVar3.UbS.zi();
                    AppMethodBeat.o(104830);
                    return 0;
                default:
                    AppMethodBeat.o(104830);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104830);
            return -1;
        }
    }
}
