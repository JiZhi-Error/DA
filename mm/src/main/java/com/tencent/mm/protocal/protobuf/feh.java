package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class feh extends a {
    public String Nzx;
    public LinkedList<feg> Nzy = new LinkedList<>();

    public feh() {
        AppMethodBeat.i(153335);
        AppMethodBeat.o(153335);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153336);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nzx != null) {
                aVar.e(1, this.Nzx);
            }
            aVar.e(2, 8, this.Nzy);
            AppMethodBeat.o(153336);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Nzx != null ? g.a.a.b.b.a.f(1, this.Nzx) + 0 : 0) + g.a.a.a.c(2, 8, this.Nzy);
            AppMethodBeat.o(153336);
            return f2;
        } else if (i2 == 2) {
            this.Nzy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153336);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            feh feh = (feh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    feh.Nzx = aVar3.UbS.readString();
                    AppMethodBeat.o(153336);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        feg feg = new feg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = feg.populateBuilderWithField(aVar4, feg, a.getNextFieldNumber(aVar4))) {
                        }
                        feh.Nzy.add(feg);
                    }
                    AppMethodBeat.o(153336);
                    return 0;
                default:
                    AppMethodBeat.o(153336);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153336);
            return -1;
        }
    }
}
