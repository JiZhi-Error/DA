package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class c extends a {
    public String LrG;
    public String Ltl;
    public LinkedList<i> Ltm = new LinkedList<>();
    public int Ltn;
    public a Lto;
    public int Ubh;
    public int Ubi;
    public int Ubj;
    public f Ubk;
    public String Ubl;
    public b Ubm;
    public d Ubn;

    public c() {
        AppMethodBeat.i(91740);
        AppMethodBeat.o(91740);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91741);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Ltm);
            aVar.aM(2, this.Ubh);
            if (this.LrG != null) {
                aVar.e(3, this.LrG);
            }
            aVar.aM(4, this.Ltn);
            if (this.Lto != null) {
                aVar.ni(5, this.Lto.computeSize());
                this.Lto.writeFields(aVar);
            }
            if (this.Ltl != null) {
                aVar.e(6, this.Ltl);
            }
            aVar.aM(7, this.Ubi);
            aVar.aM(8, this.Ubj);
            if (this.Ubk != null) {
                aVar.ni(9, this.Ubk.computeSize());
                this.Ubk.writeFields(aVar);
            }
            if (this.Ubl != null) {
                aVar.e(10, this.Ubl);
            }
            if (this.Ubm != null) {
                aVar.ni(11, this.Ubm.computeSize());
                this.Ubm.writeFields(aVar);
            }
            if (this.Ubn != null) {
                aVar.ni(12, this.Ubn.computeSize());
                this.Ubn.writeFields(aVar);
            }
            AppMethodBeat.o(91741);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Ltm) + 0 + g.a.a.b.b.a.bu(2, this.Ubh);
            if (this.LrG != null) {
                c2 += g.a.a.b.b.a.f(3, this.LrG);
            }
            int bu = c2 + g.a.a.b.b.a.bu(4, this.Ltn);
            if (this.Lto != null) {
                bu += g.a.a.a.nh(5, this.Lto.computeSize());
            }
            if (this.Ltl != null) {
                bu += g.a.a.b.b.a.f(6, this.Ltl);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Ubi) + g.a.a.b.b.a.bu(8, this.Ubj);
            if (this.Ubk != null) {
                bu2 += g.a.a.a.nh(9, this.Ubk.computeSize());
            }
            if (this.Ubl != null) {
                bu2 += g.a.a.b.b.a.f(10, this.Ubl);
            }
            if (this.Ubm != null) {
                bu2 += g.a.a.a.nh(11, this.Ubm.computeSize());
            }
            if (this.Ubn != null) {
                bu2 += g.a.a.a.nh(12, this.Ubn.computeSize());
            }
            AppMethodBeat.o(91741);
            return bu2;
        } else if (i2 == 2) {
            this.Ltm.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91741);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        i iVar = new i();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = iVar.populateBuilderWithField(aVar4, iVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.Ltm.add(iVar);
                    }
                    AppMethodBeat.o(91741);
                    return 0;
                case 2:
                    cVar.Ubh = aVar3.UbS.zi();
                    AppMethodBeat.o(91741);
                    return 0;
                case 3:
                    cVar.LrG = aVar3.UbS.readString();
                    AppMethodBeat.o(91741);
                    return 0;
                case 4:
                    cVar.Ltn = aVar3.UbS.zi();
                    AppMethodBeat.o(91741);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar5 = new a();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aVar5.populateBuilderWithField(aVar6, aVar5, a.getNextFieldNumber(aVar6))) {
                        }
                        cVar.Lto = aVar5;
                    }
                    AppMethodBeat.o(91741);
                    return 0;
                case 6:
                    cVar.Ltl = aVar3.UbS.readString();
                    AppMethodBeat.o(91741);
                    return 0;
                case 7:
                    cVar.Ubi = aVar3.UbS.zi();
                    AppMethodBeat.o(91741);
                    return 0;
                case 8:
                    cVar.Ubj = aVar3.UbS.zi();
                    AppMethodBeat.o(91741);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        f fVar = new f();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fVar.populateBuilderWithField(aVar7, fVar, a.getNextFieldNumber(aVar7))) {
                        }
                        cVar.Ubk = fVar;
                    }
                    AppMethodBeat.o(91741);
                    return 0;
                case 10:
                    cVar.Ubl = aVar3.UbS.readString();
                    AppMethodBeat.o(91741);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        b bVar = new b();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bVar.populateBuilderWithField(aVar8, bVar, a.getNextFieldNumber(aVar8))) {
                        }
                        cVar.Ubm = bVar;
                    }
                    AppMethodBeat.o(91741);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        d dVar = new d();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dVar.populateBuilderWithField(aVar9, dVar, a.getNextFieldNumber(aVar9))) {
                        }
                        cVar.Ubn = dVar;
                    }
                    AppMethodBeat.o(91741);
                    return 0;
                default:
                    AppMethodBeat.o(91741);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91741);
            return -1;
        }
    }
}
