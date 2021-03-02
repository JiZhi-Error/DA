package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cqe extends a {
    public String MvG;
    public dbl Mvx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32352);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MvG == null) {
                b bVar = new b("Not all required fields were included: ContactUsername");
                AppMethodBeat.o(32352);
                throw bVar;
            } else if (this.Mvx == null) {
                b bVar2 = new b("Not all required fields were included: PhoneNumListInfo");
                AppMethodBeat.o(32352);
                throw bVar2;
            } else {
                if (this.MvG != null) {
                    aVar.e(1, this.MvG);
                }
                if (this.Mvx != null) {
                    aVar.ni(2, this.Mvx.computeSize());
                    this.Mvx.writeFields(aVar);
                }
                AppMethodBeat.o(32352);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.MvG != null ? g.a.a.b.b.a.f(1, this.MvG) + 0 : 0;
            if (this.Mvx != null) {
                f2 += g.a.a.a.nh(2, this.Mvx.computeSize());
            }
            AppMethodBeat.o(32352);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MvG == null) {
                b bVar3 = new b("Not all required fields were included: ContactUsername");
                AppMethodBeat.o(32352);
                throw bVar3;
            } else if (this.Mvx == null) {
                b bVar4 = new b("Not all required fields were included: PhoneNumListInfo");
                AppMethodBeat.o(32352);
                throw bVar4;
            } else {
                AppMethodBeat.o(32352);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cqe cqe = (cqe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cqe.MvG = aVar3.UbS.readString();
                    AppMethodBeat.o(32352);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dbl dbl = new dbl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dbl.populateBuilderWithField(aVar4, dbl, a.getNextFieldNumber(aVar4))) {
                        }
                        cqe.Mvx = dbl;
                    }
                    AppMethodBeat.o(32352);
                    return 0;
                default:
                    AppMethodBeat.o(32352);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32352);
            return -1;
        }
    }
}
