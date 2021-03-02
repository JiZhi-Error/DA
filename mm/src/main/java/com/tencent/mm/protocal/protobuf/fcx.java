package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class fcx extends a {
    public b KSW;
    public LinkedList<fcu> KSX = new LinkedList<>();
    public String Mmv;

    public fcx() {
        AppMethodBeat.i(123701);
        AppMethodBeat.o(123701);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123702);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mmv == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: WxaUserName");
                AppMethodBeat.o(123702);
                throw bVar;
            }
            if (this.Mmv != null) {
                aVar.e(1, this.Mmv);
            }
            if (this.KSW != null) {
                aVar.c(2, this.KSW);
            }
            aVar.e(3, 8, this.KSX);
            AppMethodBeat.o(123702);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Mmv != null ? g.a.a.b.b.a.f(1, this.Mmv) + 0 : 0;
            if (this.KSW != null) {
                f2 += g.a.a.b.b.a.b(2, this.KSW);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.KSX);
            AppMethodBeat.o(123702);
            return c2;
        } else if (i2 == 2) {
            this.KSX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Mmv == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: WxaUserName");
                AppMethodBeat.o(123702);
                throw bVar2;
            }
            AppMethodBeat.o(123702);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcx fcx = (fcx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fcx.Mmv = aVar3.UbS.readString();
                    AppMethodBeat.o(123702);
                    return 0;
                case 2:
                    fcx.KSW = aVar3.UbS.hPo();
                    AppMethodBeat.o(123702);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fcu fcu = new fcu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fcu.populateBuilderWithField(aVar4, fcu, a.getNextFieldNumber(aVar4))) {
                        }
                        fcx.KSX.add(fcu);
                    }
                    AppMethodBeat.o(123702);
                    return 0;
                default:
                    AppMethodBeat.o(123702);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123702);
            return -1;
        }
    }
}
