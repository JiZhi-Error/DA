package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ami extends a {
    public long Lvb;
    public long Lvc;
    public LinkedList<ehm> Lvd = new LinkedList<>();

    public ami() {
        AppMethodBeat.i(125722);
        AppMethodBeat.o(125722);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125723);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Lvb);
            aVar.bb(2, this.Lvc);
            aVar.e(3, 8, this.Lvd);
            AppMethodBeat.o(125723);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Lvb) + 0 + g.a.a.b.b.a.r(2, this.Lvc) + g.a.a.a.c(3, 8, this.Lvd);
            AppMethodBeat.o(125723);
            return r;
        } else if (i2 == 2) {
            this.Lvd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125723);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ami ami = (ami) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ami.Lvb = aVar3.UbS.zl();
                    AppMethodBeat.o(125723);
                    return 0;
                case 2:
                    ami.Lvc = aVar3.UbS.zl();
                    AppMethodBeat.o(125723);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehm ehm = new ehm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehm.populateBuilderWithField(aVar4, ehm, a.getNextFieldNumber(aVar4))) {
                        }
                        ami.Lvd.add(ehm);
                    }
                    AppMethodBeat.o(125723);
                    return 0;
                default:
                    AppMethodBeat.o(125723);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125723);
            return -1;
        }
    }
}
