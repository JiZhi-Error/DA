package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bof extends a {
    public String Bri;
    public cat KOZ;
    public int LWr;
    public int Ret;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82415);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ret);
            if (this.KOZ != null) {
                aVar.ni(2, this.KOZ.computeSize());
                this.KOZ.writeFields(aVar);
            }
            if (this.Bri != null) {
                aVar.e(3, this.Bri);
            }
            aVar.aM(4, this.LWr);
            AppMethodBeat.o(82415);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.KOZ != null) {
                bu += g.a.a.a.nh(2, this.KOZ.computeSize());
            }
            if (this.Bri != null) {
                bu += g.a.a.b.b.a.f(3, this.Bri);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.LWr);
            AppMethodBeat.o(82415);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82415);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bof bof = (bof) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bof.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(82415);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cat cat = new cat();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cat.populateBuilderWithField(aVar4, cat, a.getNextFieldNumber(aVar4))) {
                        }
                        bof.KOZ = cat;
                    }
                    AppMethodBeat.o(82415);
                    return 0;
                case 3:
                    bof.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(82415);
                    return 0;
                case 4:
                    bof.LWr = aVar3.UbS.zi();
                    AppMethodBeat.o(82415);
                    return 0;
                default:
                    AppMethodBeat.o(82415);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82415);
            return -1;
        }
    }
}
