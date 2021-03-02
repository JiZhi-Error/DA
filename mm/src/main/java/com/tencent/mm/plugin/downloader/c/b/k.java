package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class k extends a {
    public d qGY;
    public e qGZ;
    public g qHa;
    public l qHb;
    public b qHc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153071);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.qGY == null) {
                b bVar = new b("Not all required fields were included: base_info");
                AppMethodBeat.o(153071);
                throw bVar;
            }
            if (this.qGY != null) {
                aVar.ni(1, this.qGY.computeSize());
                this.qGY.writeFields(aVar);
            }
            if (this.qGZ != null) {
                aVar.ni(2, this.qGZ.computeSize());
                this.qGZ.writeFields(aVar);
            }
            if (this.qHa != null) {
                aVar.ni(3, this.qHa.computeSize());
                this.qHa.writeFields(aVar);
            }
            if (this.qHb != null) {
                aVar.ni(4, this.qHb.computeSize());
                this.qHb.writeFields(aVar);
            }
            if (this.qHc != null) {
                aVar.ni(5, this.qHc.computeSize());
                this.qHc.writeFields(aVar);
            }
            AppMethodBeat.o(153071);
            return 0;
        } else if (i2 == 1) {
            int nh = this.qGY != null ? g.a.a.a.nh(1, this.qGY.computeSize()) + 0 : 0;
            if (this.qGZ != null) {
                nh += g.a.a.a.nh(2, this.qGZ.computeSize());
            }
            if (this.qHa != null) {
                nh += g.a.a.a.nh(3, this.qHa.computeSize());
            }
            if (this.qHb != null) {
                nh += g.a.a.a.nh(4, this.qHb.computeSize());
            }
            if (this.qHc != null) {
                nh += g.a.a.a.nh(5, this.qHc.computeSize());
            }
            AppMethodBeat.o(153071);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.qGY == null) {
                b bVar2 = new b("Not all required fields were included: base_info");
                AppMethodBeat.o(153071);
                throw bVar2;
            }
            AppMethodBeat.o(153071);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.qGY = dVar;
                    }
                    AppMethodBeat.o(153071);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        e eVar = new e();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eVar.populateBuilderWithField(aVar5, eVar, a.getNextFieldNumber(aVar5))) {
                        }
                        kVar.qGZ = eVar;
                    }
                    AppMethodBeat.o(153071);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        g gVar = new g();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = gVar.populateBuilderWithField(aVar6, gVar, a.getNextFieldNumber(aVar6))) {
                        }
                        kVar.qHa = gVar;
                    }
                    AppMethodBeat.o(153071);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        l lVar = new l();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = lVar.populateBuilderWithField(aVar7, lVar, a.getNextFieldNumber(aVar7))) {
                        }
                        kVar.qHb = lVar;
                    }
                    AppMethodBeat.o(153071);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        b bVar3 = new b();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bVar3.populateBuilderWithField(aVar8, bVar3, a.getNextFieldNumber(aVar8))) {
                        }
                        kVar.qHc = bVar3;
                    }
                    AppMethodBeat.o(153071);
                    return 0;
                default:
                    AppMethodBeat.o(153071);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153071);
            return -1;
        }
    }
}
