package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bzk extends dop {
    public int Mfb;
    public int Mfc;
    public int Mfd;
    public int bDZ;
    public int condition;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123598);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.bDZ);
            aVar.aM(3, this.condition);
            aVar.aM(4, this.Mfb);
            aVar.aM(5, this.Mfc);
            aVar.aM(6, this.Mfd);
            AppMethodBeat.o(123598);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.bDZ) + g.a.a.b.b.a.bu(3, this.condition) + g.a.a.b.b.a.bu(4, this.Mfb) + g.a.a.b.b.a.bu(5, this.Mfc) + g.a.a.b.b.a.bu(6, this.Mfd);
            AppMethodBeat.o(123598);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123598);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bzk bzk = (bzk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        bzk.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123598);
                    return 0;
                case 2:
                    bzk.bDZ = aVar3.UbS.zi();
                    AppMethodBeat.o(123598);
                    return 0;
                case 3:
                    bzk.condition = aVar3.UbS.zi();
                    AppMethodBeat.o(123598);
                    return 0;
                case 4:
                    bzk.Mfb = aVar3.UbS.zi();
                    AppMethodBeat.o(123598);
                    return 0;
                case 5:
                    bzk.Mfc = aVar3.UbS.zi();
                    AppMethodBeat.o(123598);
                    return 0;
                case 6:
                    bzk.Mfd = aVar3.UbS.zi();
                    AppMethodBeat.o(123598);
                    return 0;
                default:
                    AppMethodBeat.o(123598);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123598);
            return -1;
        }
    }
}
