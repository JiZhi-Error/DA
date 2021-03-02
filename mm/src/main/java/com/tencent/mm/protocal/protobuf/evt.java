package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class evt extends a {
    public LinkedList<evg> Ntp = new LinkedList<>();
    public euy Nty;
    public int Ntz;

    public evt() {
        AppMethodBeat.i(147806);
        AppMethodBeat.o(147806);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147807);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nty == null) {
                b bVar = new b("Not all required fields were included: base_request");
                AppMethodBeat.o(147807);
                throw bVar;
            }
            if (this.Nty != null) {
                aVar.ni(1, this.Nty.computeSize());
                this.Nty.writeFields(aVar);
            }
            aVar.e(2, 8, this.Ntp);
            aVar.aM(3, this.Ntz);
            AppMethodBeat.o(147807);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Nty != null ? g.a.a.a.nh(1, this.Nty.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Ntp) + g.a.a.b.b.a.bu(3, this.Ntz);
            AppMethodBeat.o(147807);
            return nh;
        } else if (i2 == 2) {
            this.Ntp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nty == null) {
                b bVar2 = new b("Not all required fields were included: base_request");
                AppMethodBeat.o(147807);
                throw bVar2;
            }
            AppMethodBeat.o(147807);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evt evt = (evt) objArr[1];
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
                        evt.Nty = euy;
                    }
                    AppMethodBeat.o(147807);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        evg evg = new evg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = evg.populateBuilderWithField(aVar5, evg, a.getNextFieldNumber(aVar5))) {
                        }
                        evt.Ntp.add(evg);
                    }
                    AppMethodBeat.o(147807);
                    return 0;
                case 3:
                    evt.Ntz = aVar3.UbS.zi();
                    AppMethodBeat.o(147807);
                    return 0;
                default:
                    AppMethodBeat.o(147807);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147807);
            return -1;
        }
    }
}
