package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cpk extends a {
    public dqi KGR;
    public dqi Mvg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101828);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KGR == null) {
                b bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(101828);
                throw bVar;
            } else if (this.Mvg == null) {
                b bVar2 = new b("Not all required fields were included: ChatRoomTopic");
                AppMethodBeat.o(101828);
                throw bVar2;
            } else {
                if (this.KGR != null) {
                    aVar.ni(1, this.KGR.computeSize());
                    this.KGR.writeFields(aVar);
                }
                if (this.Mvg != null) {
                    aVar.ni(2, this.Mvg.computeSize());
                    this.Mvg.writeFields(aVar);
                }
                AppMethodBeat.o(101828);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.KGR != null ? g.a.a.a.nh(1, this.KGR.computeSize()) + 0 : 0;
            if (this.Mvg != null) {
                nh += g.a.a.a.nh(2, this.Mvg.computeSize());
            }
            AppMethodBeat.o(101828);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KGR == null) {
                b bVar3 = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(101828);
                throw bVar3;
            } else if (this.Mvg == null) {
                b bVar4 = new b("Not all required fields were included: ChatRoomTopic");
                AppMethodBeat.o(101828);
                throw bVar4;
            } else {
                AppMethodBeat.o(101828);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpk cpk = (cpk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        cpk.KGR = dqi;
                    }
                    AppMethodBeat.o(101828);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        cpk.Mvg = dqi2;
                    }
                    AppMethodBeat.o(101828);
                    return 0;
                default:
                    AppMethodBeat.o(101828);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101828);
            return -1;
        }
    }
}
