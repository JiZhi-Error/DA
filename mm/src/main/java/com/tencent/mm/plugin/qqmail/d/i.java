package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class i extends a {
    public String BqZ;
    public int Brp;
    public LinkedList<l> Brq = new LinkedList<>();
    public LinkedList<l> Brr = new LinkedList<>();
    public LinkedList<l> Brs = new LinkedList<>();
    public LinkedList<aj> Brt = new LinkedList<>();
    public String Bru;
    public int Brv = 20;
    public String content;

    public i() {
        AppMethodBeat.i(122665);
        AppMethodBeat.o(122665);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122666);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.content == null) {
                b bVar = new b("Not all required fields were included: content");
                AppMethodBeat.o(122666);
                throw bVar;
            }
            aVar.aM(1, this.Brp);
            if (this.BqZ != null) {
                aVar.e(2, this.BqZ);
            }
            aVar.e(3, 8, this.Brq);
            aVar.e(4, 8, this.Brr);
            aVar.e(5, 8, this.Brs);
            aVar.e(6, 8, this.Brt);
            if (this.Bru != null) {
                aVar.e(7, this.Bru);
            }
            if (this.content != null) {
                aVar.e(8, this.content);
            }
            aVar.aM(9, this.Brv);
            AppMethodBeat.o(122666);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Brp) + 0;
            if (this.BqZ != null) {
                bu += g.a.a.b.b.a.f(2, this.BqZ);
            }
            int c2 = bu + g.a.a.a.c(3, 8, this.Brq) + g.a.a.a.c(4, 8, this.Brr) + g.a.a.a.c(5, 8, this.Brs) + g.a.a.a.c(6, 8, this.Brt);
            if (this.Bru != null) {
                c2 += g.a.a.b.b.a.f(7, this.Bru);
            }
            if (this.content != null) {
                c2 += g.a.a.b.b.a.f(8, this.content);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(9, this.Brv);
            AppMethodBeat.o(122666);
            return bu2;
        } else if (i2 == 2) {
            this.Brq.clear();
            this.Brr.clear();
            this.Brs.clear();
            this.Brt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.content == null) {
                b bVar2 = new b("Not all required fields were included: content");
                AppMethodBeat.o(122666);
                throw bVar2;
            }
            AppMethodBeat.o(122666);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.Brp = aVar3.UbS.zi();
                    AppMethodBeat.o(122666);
                    return 0;
                case 2:
                    iVar.BqZ = aVar3.UbS.readString();
                    AppMethodBeat.o(122666);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = new l();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.Brq.add(lVar);
                    }
                    AppMethodBeat.o(122666);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        l lVar2 = new l();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = lVar2.populateBuilderWithField(aVar5, lVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        iVar.Brr.add(lVar2);
                    }
                    AppMethodBeat.o(122666);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        l lVar3 = new l();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = lVar3.populateBuilderWithField(aVar6, lVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        iVar.Brs.add(lVar3);
                    }
                    AppMethodBeat.o(122666);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aj ajVar = new aj();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ajVar.populateBuilderWithField(aVar7, ajVar, a.getNextFieldNumber(aVar7))) {
                        }
                        iVar.Brt.add(ajVar);
                    }
                    AppMethodBeat.o(122666);
                    return 0;
                case 7:
                    iVar.Bru = aVar3.UbS.readString();
                    AppMethodBeat.o(122666);
                    return 0;
                case 8:
                    iVar.content = aVar3.UbS.readString();
                    AppMethodBeat.o(122666);
                    return 0;
                case 9:
                    iVar.Brv = aVar3.UbS.zi();
                    AppMethodBeat.o(122666);
                    return 0;
                default:
                    AppMethodBeat.o(122666);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122666);
            return -1;
        }
    }
}
