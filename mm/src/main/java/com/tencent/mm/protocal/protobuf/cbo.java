package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cbo extends a {
    public long Mhp = 0;
    public long Mhq = 0;
    public LinkedList<cyl> Mhr = new LinkedList<>();
    public int Mhs = -1;
    public LinkedList<cyh> Mht = new LinkedList<>();
    public int Mhu = -1;
    public int Mhv = -1;
    public boolean Mhw = false;
    public long his = 0;

    public cbo() {
        AppMethodBeat.i(122515);
        AppMethodBeat.o(122515);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122516);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Mhp);
            aVar.bb(2, this.Mhq);
            aVar.e(3, 8, this.Mhr);
            aVar.aM(4, this.Mhs);
            aVar.e(5, 8, this.Mht);
            aVar.aM(6, this.Mhu);
            aVar.aM(7, this.Mhv);
            aVar.bb(8, this.his);
            aVar.cc(9, this.Mhw);
            AppMethodBeat.o(122516);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Mhp) + 0 + g.a.a.b.b.a.r(2, this.Mhq) + g.a.a.a.c(3, 8, this.Mhr) + g.a.a.b.b.a.bu(4, this.Mhs) + g.a.a.a.c(5, 8, this.Mht) + g.a.a.b.b.a.bu(6, this.Mhu) + g.a.a.b.b.a.bu(7, this.Mhv) + g.a.a.b.b.a.r(8, this.his) + g.a.a.b.b.a.fS(9) + 1;
            AppMethodBeat.o(122516);
            return r;
        } else if (i2 == 2) {
            this.Mhr.clear();
            this.Mht.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122516);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbo cbo = (cbo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbo.Mhp = aVar3.UbS.zl();
                    AppMethodBeat.o(122516);
                    return 0;
                case 2:
                    cbo.Mhq = aVar3.UbS.zl();
                    AppMethodBeat.o(122516);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cyl cyl = new cyl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cyl.populateBuilderWithField(aVar4, cyl, a.getNextFieldNumber(aVar4))) {
                        }
                        cbo.Mhr.add(cyl);
                    }
                    AppMethodBeat.o(122516);
                    return 0;
                case 4:
                    cbo.Mhs = aVar3.UbS.zi();
                    AppMethodBeat.o(122516);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cyh cyh = new cyh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cyh.populateBuilderWithField(aVar5, cyh, a.getNextFieldNumber(aVar5))) {
                        }
                        cbo.Mht.add(cyh);
                    }
                    AppMethodBeat.o(122516);
                    return 0;
                case 6:
                    cbo.Mhu = aVar3.UbS.zi();
                    AppMethodBeat.o(122516);
                    return 0;
                case 7:
                    cbo.Mhv = aVar3.UbS.zi();
                    AppMethodBeat.o(122516);
                    return 0;
                case 8:
                    cbo.his = aVar3.UbS.zl();
                    AppMethodBeat.o(122516);
                    return 0;
                case 9:
                    cbo.Mhw = aVar3.UbS.yZ();
                    AppMethodBeat.o(122516);
                    return 0;
                default:
                    AppMethodBeat.o(122516);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122516);
            return -1;
        }
    }
}
