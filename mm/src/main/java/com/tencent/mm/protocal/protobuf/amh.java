package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class amh extends a {
    public ctg LuY;
    public int LuZ;
    public int Lva;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200198);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LuY != null) {
                aVar.ni(1, this.LuY.computeSize());
                this.LuY.writeFields(aVar);
            }
            aVar.aM(2, this.LuZ);
            aVar.aM(3, this.Lva);
            AppMethodBeat.o(200198);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.LuY != null ? g.a.a.a.nh(1, this.LuY.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LuZ) + g.a.a.b.b.a.bu(3, this.Lva);
            AppMethodBeat.o(200198);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200198);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amh amh = (amh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ctg ctg = new ctg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ctg.populateBuilderWithField(aVar4, ctg, a.getNextFieldNumber(aVar4))) {
                        }
                        amh.LuY = ctg;
                    }
                    AppMethodBeat.o(200198);
                    return 0;
                case 2:
                    amh.LuZ = aVar3.UbS.zi();
                    AppMethodBeat.o(200198);
                    return 0;
                case 3:
                    amh.Lva = aVar3.UbS.zi();
                    AppMethodBeat.o(200198);
                    return 0;
                default:
                    AppMethodBeat.o(200198);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200198);
            return -1;
        }
    }
}
