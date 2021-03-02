package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ewe extends a {
    public euz NtA;
    public int NtN;
    public LinkedList<evg> Ntp = new LinkedList<>();

    public ewe() {
        AppMethodBeat.i(147818);
        AppMethodBeat.o(147818);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147819);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NtA == null) {
                b bVar = new b("Not all required fields were included: base_response");
                AppMethodBeat.o(147819);
                throw bVar;
            }
            if (this.NtA != null) {
                aVar.ni(1, this.NtA.computeSize());
                this.NtA.writeFields(aVar);
            }
            aVar.e(2, 8, this.Ntp);
            aVar.aM(3, this.NtN);
            AppMethodBeat.o(147819);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.NtA != null ? g.a.a.a.nh(1, this.NtA.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Ntp) + g.a.a.b.b.a.bu(3, this.NtN);
            AppMethodBeat.o(147819);
            return nh;
        } else if (i2 == 2) {
            this.Ntp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NtA == null) {
                b bVar2 = new b("Not all required fields were included: base_response");
                AppMethodBeat.o(147819);
                throw bVar2;
            }
            AppMethodBeat.o(147819);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewe ewe = (ewe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        euz euz = new euz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = euz.populateBuilderWithField(aVar4, euz, a.getNextFieldNumber(aVar4))) {
                        }
                        ewe.NtA = euz;
                    }
                    AppMethodBeat.o(147819);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        evg evg = new evg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = evg.populateBuilderWithField(aVar5, evg, a.getNextFieldNumber(aVar5))) {
                        }
                        ewe.Ntp.add(evg);
                    }
                    AppMethodBeat.o(147819);
                    return 0;
                case 3:
                    ewe.NtN = aVar3.UbS.zi();
                    AppMethodBeat.o(147819);
                    return 0;
                default:
                    AppMethodBeat.o(147819);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147819);
            return -1;
        }
    }
}
