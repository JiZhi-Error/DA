package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public class l extends a {
    public int AZz;
    public String Bab;
    public int Bac;
    public LinkedList<e> Bad = new LinkedList<>();
    public String url;

    public l() {
        AppMethodBeat.i(91278);
        AppMethodBeat.o(91278);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91279);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Bab == null) {
                b bVar = new b("Not all required fields were included: id_info");
                AppMethodBeat.o(91279);
                throw bVar;
            }
            if (this.Bab != null) {
                aVar.e(1, this.Bab);
            }
            aVar.aM(2, this.Bac);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.e(4, 8, this.Bad);
            aVar.aM(5, this.AZz);
            AppMethodBeat.o(91279);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Bab != null ? g.a.a.b.b.a.f(1, this.Bab) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Bac);
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(3, this.url);
            }
            int c2 = f2 + g.a.a.a.c(4, 8, this.Bad) + g.a.a.b.b.a.bu(5, this.AZz);
            AppMethodBeat.o(91279);
            return c2;
        } else if (i2 == 2) {
            this.Bad.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Bab == null) {
                b bVar2 = new b("Not all required fields were included: id_info");
                AppMethodBeat.o(91279);
                throw bVar2;
            }
            AppMethodBeat.o(91279);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lVar.Bab = aVar3.UbS.readString();
                    AppMethodBeat.o(91279);
                    return 0;
                case 2:
                    lVar.Bac = aVar3.UbS.zi();
                    AppMethodBeat.o(91279);
                    return 0;
                case 3:
                    lVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91279);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        e eVar = new e();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        lVar.Bad.add(eVar);
                    }
                    AppMethodBeat.o(91279);
                    return 0;
                case 5:
                    lVar.AZz = aVar3.UbS.zi();
                    AppMethodBeat.o(91279);
                    return 0;
                default:
                    AppMethodBeat.o(91279);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91279);
            return -1;
        }
    }
}
