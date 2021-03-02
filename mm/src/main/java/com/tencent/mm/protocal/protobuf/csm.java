package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class csm extends a {
    public axy MwY;
    public csk Mxx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256727);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mxx != null) {
                aVar.ni(1, this.Mxx.computeSize());
                this.Mxx.writeFields(aVar);
            }
            if (this.MwY != null) {
                aVar.ni(2, this.MwY.computeSize());
                this.MwY.writeFields(aVar);
            }
            AppMethodBeat.o(256727);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Mxx != null ? g.a.a.a.nh(1, this.Mxx.computeSize()) + 0 : 0;
            if (this.MwY != null) {
                nh += g.a.a.a.nh(2, this.MwY.computeSize());
            }
            AppMethodBeat.o(256727);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256727);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csm csm = (csm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        csk csk = new csk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = csk.populateBuilderWithField(aVar4, csk, a.getNextFieldNumber(aVar4))) {
                        }
                        csm.Mxx = csk;
                    }
                    AppMethodBeat.o(256727);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        axy axy = new axy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = axy.populateBuilderWithField(aVar5, axy, a.getNextFieldNumber(aVar5))) {
                        }
                        csm.MwY = axy;
                    }
                    AppMethodBeat.o(256727);
                    return 0;
                default:
                    AppMethodBeat.o(256727);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256727);
            return -1;
        }
    }
}
