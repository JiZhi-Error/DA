package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fhp extends a {
    public int Vkh;
    public fht Vki;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259374);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Vkh);
            if (this.Vki != null) {
                aVar.ni(2, this.Vki.computeSize());
                this.Vki.writeFields(aVar);
            }
            AppMethodBeat.o(259374);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Vkh) + 0;
            if (this.Vki != null) {
                bu += g.a.a.a.nh(2, this.Vki.computeSize());
            }
            AppMethodBeat.o(259374);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259374);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fhp fhp = (fhp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fhp.Vkh = aVar3.UbS.zi();
                    AppMethodBeat.o(259374);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fht fht = new fht();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fht.populateBuilderWithField(aVar4, fht, a.getNextFieldNumber(aVar4))) {
                        }
                        fhp.Vki = fht;
                    }
                    AppMethodBeat.o(259374);
                    return 0;
                default:
                    AppMethodBeat.o(259374);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259374);
            return -1;
        }
    }
}
