package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ch extends a {
    public cfx KGA;
    public LinkedList<cfy> KGB = new LinkedList<>();

    public ch() {
        AppMethodBeat.i(116325);
        AppMethodBeat.o(116325);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116326);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KGA == null) {
                b bVar = new b("Not all required fields were included: LogHead");
                AppMethodBeat.o(116326);
                throw bVar;
            }
            if (this.KGA != null) {
                aVar.ni(1, this.KGA.computeSize());
                this.KGA.writeFields(aVar);
            }
            aVar.e(2, 8, this.KGB);
            AppMethodBeat.o(116326);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.KGA != null ? g.a.a.a.nh(1, this.KGA.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KGB);
            AppMethodBeat.o(116326);
            return nh;
        } else if (i2 == 2) {
            this.KGB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KGA == null) {
                b bVar2 = new b("Not all required fields were included: LogHead");
                AppMethodBeat.o(116326);
                throw bVar2;
            }
            AppMethodBeat.o(116326);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ch chVar = (ch) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cfx cfx = new cfx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cfx.populateBuilderWithField(aVar4, cfx, a.getNextFieldNumber(aVar4))) {
                        }
                        chVar.KGA = cfx;
                    }
                    AppMethodBeat.o(116326);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cfy cfy = new cfy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cfy.populateBuilderWithField(aVar5, cfy, a.getNextFieldNumber(aVar5))) {
                        }
                        chVar.KGB.add(cfy);
                    }
                    AppMethodBeat.o(116326);
                    return 0;
                default:
                    AppMethodBeat.o(116326);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116326);
            return -1;
        }
    }
}
