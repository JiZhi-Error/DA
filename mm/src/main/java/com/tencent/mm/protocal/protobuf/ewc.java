package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ewc extends a {
    public euy Nty;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147816);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nty == null) {
                b bVar = new b("Not all required fields were included: base_request");
                AppMethodBeat.o(147816);
                throw bVar;
            }
            if (this.Nty != null) {
                aVar.ni(1, this.Nty.computeSize());
                this.Nty.writeFields(aVar);
            }
            AppMethodBeat.o(147816);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Nty != null ? g.a.a.a.nh(1, this.Nty.computeSize()) + 0 : 0;
            AppMethodBeat.o(147816);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nty == null) {
                b bVar2 = new b("Not all required fields were included: base_request");
                AppMethodBeat.o(147816);
                throw bVar2;
            }
            AppMethodBeat.o(147816);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewc ewc = (ewc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        euy euy = new euy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = euy.populateBuilderWithField(aVar4, euy, a.getNextFieldNumber(aVar4))) {
                        }
                        ewc.Nty = euy;
                    }
                    AppMethodBeat.o(147816);
                    return 0;
                default:
                    AppMethodBeat.o(147816);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147816);
            return -1;
        }
    }
}
