package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dq extends a {
    public cih KHD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43082);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHD != null) {
                aVar.ni(1, this.KHD.computeSize());
                this.KHD.writeFields(aVar);
            }
            AppMethodBeat.o(43082);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KHD != null ? g.a.a.a.nh(1, this.KHD.computeSize()) + 0 : 0;
            AppMethodBeat.o(43082);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43082);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dq dqVar = (dq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cih cih = new cih();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cih.populateBuilderWithField(aVar4, cih, a.getNextFieldNumber(aVar4))) {
                        }
                        dqVar.KHD = cih;
                    }
                    AppMethodBeat.o(43082);
                    return 0;
                default:
                    AppMethodBeat.o(43082);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43082);
            return -1;
        }
    }
}
