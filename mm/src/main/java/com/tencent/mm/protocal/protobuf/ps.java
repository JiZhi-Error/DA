package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ps extends a {
    public dpe KWG;
    public String KWH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117836);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KWG != null) {
                aVar.ni(1, this.KWG.computeSize());
                this.KWG.writeFields(aVar);
            }
            if (this.KWH != null) {
                aVar.e(2, this.KWH);
            }
            AppMethodBeat.o(117836);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KWG != null ? g.a.a.a.nh(1, this.KWG.computeSize()) + 0 : 0;
            if (this.KWH != null) {
                nh += g.a.a.b.b.a.f(2, this.KWH);
            }
            AppMethodBeat.o(117836);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117836);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ps psVar = (ps) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dpe dpe = new dpe();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dpe.populateBuilderWithField(aVar4, dpe, a.getNextFieldNumber(aVar4))) {
                        }
                        psVar.KWG = dpe;
                    }
                    AppMethodBeat.o(117836);
                    return 0;
                case 2:
                    psVar.KWH = aVar3.UbS.readString();
                    AppMethodBeat.o(117836);
                    return 0;
                default:
                    AppMethodBeat.o(117836);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117836);
            return -1;
        }
    }
}
