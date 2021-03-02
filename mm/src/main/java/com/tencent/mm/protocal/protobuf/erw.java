package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class erw extends a {
    public b Loi;
    public esc Npo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(239532);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Npo != null) {
                aVar.ni(1, this.Npo.computeSize());
                this.Npo.writeFields(aVar);
            }
            if (this.Loi != null) {
                aVar.c(2, this.Loi);
            }
            AppMethodBeat.o(239532);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Npo != null ? g.a.a.a.nh(1, this.Npo.computeSize()) + 0 : 0;
            if (this.Loi != null) {
                nh += g.a.a.b.b.a.b(2, this.Loi);
            }
            AppMethodBeat.o(239532);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(239532);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            erw erw = (erw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        esc esc = new esc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = esc.populateBuilderWithField(aVar4, esc, a.getNextFieldNumber(aVar4))) {
                        }
                        erw.Npo = esc;
                    }
                    AppMethodBeat.o(239532);
                    return 0;
                case 2:
                    erw.Loi = aVar3.UbS.hPo();
                    AppMethodBeat.o(239532);
                    return 0;
                default:
                    AppMethodBeat.o(239532);
                    return -1;
            }
        } else {
            AppMethodBeat.o(239532);
            return -1;
        }
    }
}
