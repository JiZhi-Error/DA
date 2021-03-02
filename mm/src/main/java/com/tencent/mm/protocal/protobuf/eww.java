package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eww extends a {
    public ewx Nup;
    public ewy Nuq;
    public int vjQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212319);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.vjQ);
            if (this.Nup != null) {
                aVar.ni(2, this.Nup.computeSize());
                this.Nup.writeFields(aVar);
            }
            if (this.Nuq != null) {
                aVar.ni(3, this.Nuq.computeSize());
                this.Nuq.writeFields(aVar);
            }
            AppMethodBeat.o(212319);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.vjQ) + 0;
            if (this.Nup != null) {
                bu += g.a.a.a.nh(2, this.Nup.computeSize());
            }
            if (this.Nuq != null) {
                bu += g.a.a.a.nh(3, this.Nuq.computeSize());
            }
            AppMethodBeat.o(212319);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212319);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eww eww = (eww) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eww.vjQ = aVar3.UbS.zi();
                    AppMethodBeat.o(212319);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ewx ewx = new ewx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ewx.populateBuilderWithField(aVar4, ewx, a.getNextFieldNumber(aVar4))) {
                        }
                        eww.Nup = ewx;
                    }
                    AppMethodBeat.o(212319);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ewy ewy = new ewy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ewy.populateBuilderWithField(aVar5, ewy, a.getNextFieldNumber(aVar5))) {
                        }
                        eww.Nuq = ewy;
                    }
                    AppMethodBeat.o(212319);
                    return 0;
                default:
                    AppMethodBeat.o(212319);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212319);
            return -1;
        }
    }
}
