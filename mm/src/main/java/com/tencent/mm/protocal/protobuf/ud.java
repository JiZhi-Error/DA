package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ud extends a {
    public long LdA;
    public int Ldc;
    public String Ldd;
    public un Lde;
    public String Ldf;
    public String Ldn;
    public String Ldo;
    public String Ldp;
    public String Ldq;
    public LinkedList<ub> Ldr = new LinkedList<>();
    public LinkedList<ua> Lds = new LinkedList<>();
    public String Ldt;
    public String Ldu;
    public un Ldv;
    public ub Ldw;
    public int Ldx;
    public int Ldy;
    public int Ldz;

    public ud() {
        AppMethodBeat.i(113954);
        AppMethodBeat.o(113954);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113955);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ldn != null) {
                aVar.e(1, this.Ldn);
            }
            if (this.Ldo != null) {
                aVar.e(2, this.Ldo);
            }
            if (this.Ldp != null) {
                aVar.e(3, this.Ldp);
            }
            if (this.Ldq != null) {
                aVar.e(4, this.Ldq);
            }
            aVar.e(5, 8, this.Ldr);
            aVar.aM(6, this.Ldc);
            if (this.Ldd != null) {
                aVar.e(7, this.Ldd);
            }
            if (this.Lde != null) {
                aVar.ni(8, this.Lde.computeSize());
                this.Lde.writeFields(aVar);
            }
            if (this.Ldf != null) {
                aVar.e(9, this.Ldf);
            }
            aVar.e(10, 8, this.Lds);
            if (this.Ldt != null) {
                aVar.e(11, this.Ldt);
            }
            if (this.Ldu != null) {
                aVar.e(12, this.Ldu);
            }
            if (this.Ldv != null) {
                aVar.ni(13, this.Ldv.computeSize());
                this.Ldv.writeFields(aVar);
            }
            if (this.Ldw != null) {
                aVar.ni(14, this.Ldw.computeSize());
                this.Ldw.writeFields(aVar);
            }
            aVar.aM(15, this.Ldx);
            aVar.aM(16, this.Ldy);
            aVar.aM(17, this.Ldz);
            aVar.bb(18, this.LdA);
            AppMethodBeat.o(113955);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Ldn != null ? g.a.a.b.b.a.f(1, this.Ldn) + 0 : 0;
            if (this.Ldo != null) {
                f2 += g.a.a.b.b.a.f(2, this.Ldo);
            }
            if (this.Ldp != null) {
                f2 += g.a.a.b.b.a.f(3, this.Ldp);
            }
            if (this.Ldq != null) {
                f2 += g.a.a.b.b.a.f(4, this.Ldq);
            }
            int c2 = f2 + g.a.a.a.c(5, 8, this.Ldr) + g.a.a.b.b.a.bu(6, this.Ldc);
            if (this.Ldd != null) {
                c2 += g.a.a.b.b.a.f(7, this.Ldd);
            }
            if (this.Lde != null) {
                c2 += g.a.a.a.nh(8, this.Lde.computeSize());
            }
            if (this.Ldf != null) {
                c2 += g.a.a.b.b.a.f(9, this.Ldf);
            }
            int c3 = c2 + g.a.a.a.c(10, 8, this.Lds);
            if (this.Ldt != null) {
                c3 += g.a.a.b.b.a.f(11, this.Ldt);
            }
            if (this.Ldu != null) {
                c3 += g.a.a.b.b.a.f(12, this.Ldu);
            }
            if (this.Ldv != null) {
                c3 += g.a.a.a.nh(13, this.Ldv.computeSize());
            }
            if (this.Ldw != null) {
                c3 += g.a.a.a.nh(14, this.Ldw.computeSize());
            }
            int bu = c3 + g.a.a.b.b.a.bu(15, this.Ldx) + g.a.a.b.b.a.bu(16, this.Ldy) + g.a.a.b.b.a.bu(17, this.Ldz) + g.a.a.b.b.a.r(18, this.LdA);
            AppMethodBeat.o(113955);
            return bu;
        } else if (i2 == 2) {
            this.Ldr.clear();
            this.Lds.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113955);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ud udVar = (ud) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    udVar.Ldn = aVar3.UbS.readString();
                    AppMethodBeat.o(113955);
                    return 0;
                case 2:
                    udVar.Ldo = aVar3.UbS.readString();
                    AppMethodBeat.o(113955);
                    return 0;
                case 3:
                    udVar.Ldp = aVar3.UbS.readString();
                    AppMethodBeat.o(113955);
                    return 0;
                case 4:
                    udVar.Ldq = aVar3.UbS.readString();
                    AppMethodBeat.o(113955);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ub ubVar = new ub();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ubVar.populateBuilderWithField(aVar4, ubVar, a.getNextFieldNumber(aVar4))) {
                        }
                        udVar.Ldr.add(ubVar);
                    }
                    AppMethodBeat.o(113955);
                    return 0;
                case 6:
                    udVar.Ldc = aVar3.UbS.zi();
                    AppMethodBeat.o(113955);
                    return 0;
                case 7:
                    udVar.Ldd = aVar3.UbS.readString();
                    AppMethodBeat.o(113955);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        un unVar = new un();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = unVar.populateBuilderWithField(aVar5, unVar, a.getNextFieldNumber(aVar5))) {
                        }
                        udVar.Lde = unVar;
                    }
                    AppMethodBeat.o(113955);
                    return 0;
                case 9:
                    udVar.Ldf = aVar3.UbS.readString();
                    AppMethodBeat.o(113955);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ua uaVar = new ua();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = uaVar.populateBuilderWithField(aVar6, uaVar, a.getNextFieldNumber(aVar6))) {
                        }
                        udVar.Lds.add(uaVar);
                    }
                    AppMethodBeat.o(113955);
                    return 0;
                case 11:
                    udVar.Ldt = aVar3.UbS.readString();
                    AppMethodBeat.o(113955);
                    return 0;
                case 12:
                    udVar.Ldu = aVar3.UbS.readString();
                    AppMethodBeat.o(113955);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        un unVar2 = new un();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = unVar2.populateBuilderWithField(aVar7, unVar2, a.getNextFieldNumber(aVar7))) {
                        }
                        udVar.Ldv = unVar2;
                    }
                    AppMethodBeat.o(113955);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ub ubVar2 = new ub();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ubVar2.populateBuilderWithField(aVar8, ubVar2, a.getNextFieldNumber(aVar8))) {
                        }
                        udVar.Ldw = ubVar2;
                    }
                    AppMethodBeat.o(113955);
                    return 0;
                case 15:
                    udVar.Ldx = aVar3.UbS.zi();
                    AppMethodBeat.o(113955);
                    return 0;
                case 16:
                    udVar.Ldy = aVar3.UbS.zi();
                    AppMethodBeat.o(113955);
                    return 0;
                case 17:
                    udVar.Ldz = aVar3.UbS.zi();
                    AppMethodBeat.o(113955);
                    return 0;
                case 18:
                    udVar.LdA = aVar3.UbS.zl();
                    AppMethodBeat.o(113955);
                    return 0;
                default:
                    AppMethodBeat.o(113955);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113955);
            return -1;
        }
    }
}
