package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ewq extends a {
    public LinkedList<Long> KOJ = new LinkedList<>();
    public long Nuj;
    public int Nuk;
    public SnsObject Nul;

    public ewq() {
        AppMethodBeat.i(192793);
        AppMethodBeat.o(192793);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(192794);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Nuj);
            aVar.aM(2, this.Nuk);
            if (this.Nul != null) {
                aVar.ni(3, this.Nul.computeSize());
                this.Nul.writeFields(aVar);
            }
            aVar.e(4, 3, this.KOJ);
            AppMethodBeat.o(192794);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Nuj) + 0 + g.a.a.b.b.a.bu(2, this.Nuk);
            if (this.Nul != null) {
                r += g.a.a.a.nh(3, this.Nul.computeSize());
            }
            int c2 = r + g.a.a.a.c(4, 3, this.KOJ);
            AppMethodBeat.o(192794);
            return c2;
        } else if (i2 == 2) {
            this.KOJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(192794);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewq ewq = (ewq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ewq.Nuj = aVar3.UbS.zl();
                    AppMethodBeat.o(192794);
                    return 0;
                case 2:
                    ewq.Nuk = aVar3.UbS.zi();
                    AppMethodBeat.o(192794);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SnsObject snsObject = new SnsObject();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = snsObject.populateBuilderWithField(aVar4, snsObject, a.getNextFieldNumber(aVar4))) {
                        }
                        ewq.Nul = snsObject;
                    }
                    AppMethodBeat.o(192794);
                    return 0;
                case 4:
                    ewq.KOJ.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(192794);
                    return 0;
                default:
                    AppMethodBeat.o(192794);
                    return -1;
            }
        } else {
            AppMethodBeat.o(192794);
            return -1;
        }
    }
}
