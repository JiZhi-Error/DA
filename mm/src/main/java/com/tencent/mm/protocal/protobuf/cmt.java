package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cmt extends a {
    public long MqN;
    public LinkedList<b> Msh = new LinkedList<>();
    public ccw Msi;
    public long Msj;
    public long dDw;
    public long id;

    public cmt() {
        AppMethodBeat.i(110903);
        AppMethodBeat.o(110903);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110904);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.id);
            aVar.e(2, 6, this.Msh);
            if (this.Msi != null) {
                aVar.ni(3, this.Msi.computeSize());
                this.Msi.writeFields(aVar);
            }
            aVar.bb(4, this.dDw);
            aVar.bb(5, this.MqN);
            aVar.bb(6, this.Msj);
            AppMethodBeat.o(110904);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.id) + 0 + g.a.a.a.c(2, 6, this.Msh);
            if (this.Msi != null) {
                r += g.a.a.a.nh(3, this.Msi.computeSize());
            }
            int r2 = r + g.a.a.b.b.a.r(4, this.dDw) + g.a.a.b.b.a.r(5, this.MqN) + g.a.a.b.b.a.r(6, this.Msj);
            AppMethodBeat.o(110904);
            return r2;
        } else if (i2 == 2) {
            this.Msh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110904);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmt cmt = (cmt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cmt.id = aVar3.UbS.zl();
                    AppMethodBeat.o(110904);
                    return 0;
                case 2:
                    cmt.Msh.add(aVar3.UbS.hPo());
                    AppMethodBeat.o(110904);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccw ccw = new ccw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccw.populateBuilderWithField(aVar4, ccw, a.getNextFieldNumber(aVar4))) {
                        }
                        cmt.Msi = ccw;
                    }
                    AppMethodBeat.o(110904);
                    return 0;
                case 4:
                    cmt.dDw = aVar3.UbS.zl();
                    AppMethodBeat.o(110904);
                    return 0;
                case 5:
                    cmt.MqN = aVar3.UbS.zl();
                    AppMethodBeat.o(110904);
                    return 0;
                case 6:
                    cmt.Msj = aVar3.UbS.zl();
                    AppMethodBeat.o(110904);
                    return 0;
                default:
                    AppMethodBeat.o(110904);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110904);
            return -1;
        }
    }
}
