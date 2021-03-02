package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ccn extends a {
    public LinkedList<ccp> Miu = new LinkedList<>();
    public int major;
    public String uuid;

    public ccn() {
        AppMethodBeat.i(82427);
        AppMethodBeat.o(82427);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82428);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.uuid != null) {
                aVar.e(1, this.uuid);
            }
            aVar.aM(2, this.major);
            aVar.e(3, 8, this.Miu);
            AppMethodBeat.o(82428);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.uuid != null ? g.a.a.b.b.a.f(1, this.uuid) + 0 : 0) + g.a.a.b.b.a.bu(2, this.major) + g.a.a.a.c(3, 8, this.Miu);
            AppMethodBeat.o(82428);
            return f2;
        } else if (i2 == 2) {
            this.Miu.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82428);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ccn ccn = (ccn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ccn.uuid = aVar3.UbS.readString();
                    AppMethodBeat.o(82428);
                    return 0;
                case 2:
                    ccn.major = aVar3.UbS.zi();
                    AppMethodBeat.o(82428);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccp ccp = new ccp();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccp.populateBuilderWithField(aVar4, ccp, a.getNextFieldNumber(aVar4))) {
                        }
                        ccn.Miu.add(ccp);
                    }
                    AppMethodBeat.o(82428);
                    return 0;
                default:
                    AppMethodBeat.o(82428);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82428);
            return -1;
        }
    }
}
