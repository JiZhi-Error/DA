package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cnu extends a {
    public LinkedList<ayj> Mub = new LinkedList<>();
    public int Muc;
    public int Mud;
    public int Mue;
    public LinkedList<FinderObject> Muf = new LinkedList<>();
    public long Mug;
    public String key;
    public b lastBuffer;

    public cnu() {
        AppMethodBeat.i(209749);
        AppMethodBeat.o(209749);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209750);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key != null) {
                aVar.e(1, this.key);
            }
            aVar.e(2, 8, this.Mub);
            aVar.aM(3, this.Muc);
            aVar.aM(4, this.Mud);
            if (this.lastBuffer != null) {
                aVar.c(5, this.lastBuffer);
            }
            aVar.aM(6, this.Mue);
            aVar.e(7, 8, this.Muf);
            aVar.bb(8, this.Mug);
            AppMethodBeat.o(209750);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.key != null ? g.a.a.b.b.a.f(1, this.key) + 0 : 0) + g.a.a.a.c(2, 8, this.Mub) + g.a.a.b.b.a.bu(3, this.Muc) + g.a.a.b.b.a.bu(4, this.Mud);
            if (this.lastBuffer != null) {
                f2 += g.a.a.b.b.a.b(5, this.lastBuffer);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.Mue) + g.a.a.a.c(7, 8, this.Muf) + g.a.a.b.b.a.r(8, this.Mug);
            AppMethodBeat.o(209750);
            return bu;
        } else if (i2 == 2) {
            this.Mub.clear();
            this.Muf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209750);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cnu cnu = (cnu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cnu.key = aVar3.UbS.readString();
                    AppMethodBeat.o(209750);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ayj ayj = new ayj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ayj.populateBuilderWithField(aVar4, ayj, a.getNextFieldNumber(aVar4))) {
                        }
                        cnu.Mub.add(ayj);
                    }
                    AppMethodBeat.o(209750);
                    return 0;
                case 3:
                    cnu.Muc = aVar3.UbS.zi();
                    AppMethodBeat.o(209750);
                    return 0;
                case 4:
                    cnu.Mud = aVar3.UbS.zi();
                    AppMethodBeat.o(209750);
                    return 0;
                case 5:
                    cnu.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209750);
                    return 0;
                case 6:
                    cnu.Mue = aVar3.UbS.zi();
                    AppMethodBeat.o(209750);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, a.getNextFieldNumber(aVar5))) {
                        }
                        cnu.Muf.add(finderObject);
                    }
                    AppMethodBeat.o(209750);
                    return 0;
                case 8:
                    cnu.Mug = aVar3.UbS.zl();
                    AppMethodBeat.o(209750);
                    return 0;
                default:
                    AppMethodBeat.o(209750);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209750);
            return -1;
        }
    }
}
