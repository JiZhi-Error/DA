package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.cnb;
import java.util.LinkedList;

public final class b extends a {
    public int DRJ;
    public cnb ebR;
    public int iXu;
    public String parentId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(96151);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ebR != null) {
                aVar.ni(1, this.ebR.computeSize());
                this.ebR.writeFields(aVar);
            }
            if (this.parentId != null) {
                aVar.e(2, this.parentId);
            }
            aVar.aM(3, this.iXu);
            aVar.aM(4, this.DRJ);
            AppMethodBeat.o(96151);
            return 0;
        } else if (i2 == 1) {
            int nh = this.ebR != null ? g.a.a.a.nh(1, this.ebR.computeSize()) + 0 : 0;
            if (this.parentId != null) {
                nh += g.a.a.b.b.a.f(2, this.parentId);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.iXu) + g.a.a.b.b.a.bu(4, this.DRJ);
            AppMethodBeat.o(96151);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(96151);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cnb cnb = new cnb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cnb.populateBuilderWithField(aVar4, cnb, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.ebR = cnb;
                    }
                    AppMethodBeat.o(96151);
                    return 0;
                case 2:
                    bVar.parentId = aVar3.UbS.readString();
                    AppMethodBeat.o(96151);
                    return 0;
                case 3:
                    bVar.iXu = aVar3.UbS.zi();
                    AppMethodBeat.o(96151);
                    return 0;
                case 4:
                    bVar.DRJ = aVar3.UbS.zi();
                    AppMethodBeat.o(96151);
                    return 0;
                default:
                    AppMethodBeat.o(96151);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96151);
            return -1;
        }
    }
}
