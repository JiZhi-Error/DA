package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class eya extends a {
    public String Desc;
    public LinkedList<aod> Nvh = new LinkedList<>();
    public String Nvi;

    public eya() {
        AppMethodBeat.i(110852);
        AppMethodBeat.o(110852);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110853);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nvi == null) {
                b bVar = new b("Not all required fields were included: Charset");
                AppMethodBeat.o(110853);
                throw bVar;
            }
            aVar.e(1, 8, this.Nvh);
            if (this.Nvi != null) {
                aVar.e(2, this.Nvi);
            }
            if (this.Desc != null) {
                aVar.e(3, this.Desc);
            }
            AppMethodBeat.o(110853);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Nvh) + 0;
            if (this.Nvi != null) {
                c2 += g.a.a.b.b.a.f(2, this.Nvi);
            }
            if (this.Desc != null) {
                c2 += g.a.a.b.b.a.f(3, this.Desc);
            }
            AppMethodBeat.o(110853);
            return c2;
        } else if (i2 == 2) {
            this.Nvh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nvi == null) {
                b bVar2 = new b("Not all required fields were included: Charset");
                AppMethodBeat.o(110853);
                throw bVar2;
            }
            AppMethodBeat.o(110853);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eya eya = (eya) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aod aod = new aod();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aod.populateBuilderWithField(aVar4, aod, a.getNextFieldNumber(aVar4))) {
                        }
                        eya.Nvh.add(aod);
                    }
                    AppMethodBeat.o(110853);
                    return 0;
                case 2:
                    eya.Nvi = aVar3.UbS.readString();
                    AppMethodBeat.o(110853);
                    return 0;
                case 3:
                    eya.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(110853);
                    return 0;
                default:
                    AppMethodBeat.o(110853);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110853);
            return -1;
        }
    }
}
