package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class yj extends a {
    public LinkedList<amr> Ljx = new LinkedList<>();
    public ane Ljy;
    public int Scene;

    public yj() {
        AppMethodBeat.i(127449);
        AppMethodBeat.o(127449);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127450);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Ljx);
            aVar.aM(2, this.Scene);
            if (this.Ljy != null) {
                aVar.ni(3, this.Ljy.computeSize());
                this.Ljy.writeFields(aVar);
            }
            AppMethodBeat.o(127450);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Ljx) + 0 + g.a.a.b.b.a.bu(2, this.Scene);
            if (this.Ljy != null) {
                c2 += g.a.a.a.nh(3, this.Ljy.computeSize());
            }
            AppMethodBeat.o(127450);
            return c2;
        } else if (i2 == 2) {
            this.Ljx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127450);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            yj yjVar = (yj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        amr amr = new amr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = amr.populateBuilderWithField(aVar4, amr, a.getNextFieldNumber(aVar4))) {
                        }
                        yjVar.Ljx.add(amr);
                    }
                    AppMethodBeat.o(127450);
                    return 0;
                case 2:
                    yjVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(127450);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ane ane = new ane();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ane.populateBuilderWithField(aVar5, ane, a.getNextFieldNumber(aVar5))) {
                        }
                        yjVar.Ljy = ane;
                    }
                    AppMethodBeat.o(127450);
                    return 0;
                default:
                    AppMethodBeat.o(127450);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127450);
            return -1;
        }
    }
}
