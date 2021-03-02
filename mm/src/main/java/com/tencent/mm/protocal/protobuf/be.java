package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class be extends a {
    public fb KEA;
    public fb KEB;
    public String KEt;
    public String KEu;
    public String KEv;
    public bc KEw;
    public String KEx;
    public ek KEy;
    public fc KEz;
    public int Scene;
    public String Url;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125689);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            if (this.Url != null) {
                aVar.e(2, this.Url);
            }
            aVar.aM(3, this.Scene);
            if (this.KEt != null) {
                aVar.e(4, this.KEt);
            }
            if (this.KEu != null) {
                aVar.e(5, this.KEu);
            }
            if (this.KEv != null) {
                aVar.e(6, this.KEv);
            }
            if (this.KEw != null) {
                aVar.ni(7, this.KEw.computeSize());
                this.KEw.writeFields(aVar);
            }
            if (this.KEx != null) {
                aVar.e(8, this.KEx);
            }
            if (this.KEy != null) {
                aVar.ni(9, this.KEy.computeSize());
                this.KEy.writeFields(aVar);
            }
            if (this.KEz != null) {
                aVar.ni(10, this.KEz.computeSize());
                this.KEz.writeFields(aVar);
            }
            if (this.KEA != null) {
                aVar.ni(11, this.KEA.computeSize());
                this.KEA.writeFields(aVar);
            }
            if (this.KEB != null) {
                aVar.ni(12, this.KEB.computeSize());
                this.KEB.writeFields(aVar);
            }
            AppMethodBeat.o(125689);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0;
            if (this.Url != null) {
                bu += g.a.a.b.b.a.f(2, this.Url);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Scene);
            if (this.KEt != null) {
                bu2 += g.a.a.b.b.a.f(4, this.KEt);
            }
            if (this.KEu != null) {
                bu2 += g.a.a.b.b.a.f(5, this.KEu);
            }
            if (this.KEv != null) {
                bu2 += g.a.a.b.b.a.f(6, this.KEv);
            }
            if (this.KEw != null) {
                bu2 += g.a.a.a.nh(7, this.KEw.computeSize());
            }
            if (this.KEx != null) {
                bu2 += g.a.a.b.b.a.f(8, this.KEx);
            }
            if (this.KEy != null) {
                bu2 += g.a.a.a.nh(9, this.KEy.computeSize());
            }
            if (this.KEz != null) {
                bu2 += g.a.a.a.nh(10, this.KEz.computeSize());
            }
            if (this.KEA != null) {
                bu2 += g.a.a.a.nh(11, this.KEA.computeSize());
            }
            if (this.KEB != null) {
                bu2 += g.a.a.a.nh(12, this.KEB.computeSize());
            }
            AppMethodBeat.o(125689);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125689);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            be beVar = (be) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    beVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(125689);
                    return 0;
                case 2:
                    beVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(125689);
                    return 0;
                case 3:
                    beVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(125689);
                    return 0;
                case 4:
                    beVar.KEt = aVar3.UbS.readString();
                    AppMethodBeat.o(125689);
                    return 0;
                case 5:
                    beVar.KEu = aVar3.UbS.readString();
                    AppMethodBeat.o(125689);
                    return 0;
                case 6:
                    beVar.KEv = aVar3.UbS.readString();
                    AppMethodBeat.o(125689);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bc bcVar = new bc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bcVar.populateBuilderWithField(aVar4, bcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        beVar.KEw = bcVar;
                    }
                    AppMethodBeat.o(125689);
                    return 0;
                case 8:
                    beVar.KEx = aVar3.UbS.readString();
                    AppMethodBeat.o(125689);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ek ekVar = new ek();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ekVar.populateBuilderWithField(aVar5, ekVar, a.getNextFieldNumber(aVar5))) {
                        }
                        beVar.KEy = ekVar;
                    }
                    AppMethodBeat.o(125689);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fc fcVar = new fc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fcVar.populateBuilderWithField(aVar6, fcVar, a.getNextFieldNumber(aVar6))) {
                        }
                        beVar.KEz = fcVar;
                    }
                    AppMethodBeat.o(125689);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fb fbVar = new fb();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fbVar.populateBuilderWithField(aVar7, fbVar, a.getNextFieldNumber(aVar7))) {
                        }
                        beVar.KEA = fbVar;
                    }
                    AppMethodBeat.o(125689);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        fb fbVar2 = new fb();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = fbVar2.populateBuilderWithField(aVar8, fbVar2, a.getNextFieldNumber(aVar8))) {
                        }
                        beVar.KEB = fbVar2;
                    }
                    AppMethodBeat.o(125689);
                    return 0;
                default:
                    AppMethodBeat.o(125689);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125689);
            return -1;
        }
    }
}
