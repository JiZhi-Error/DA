package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class sa extends a {
    public LinkedList<eye> KZA = new LinkedList<>();
    public LinkedList<ahp> KZB = new LinkedList<>();
    public LinkedList<fbp> KZC = new LinkedList<>();
    public dnn KZD;
    public b KZE;
    public LinkedList<czb> KZF = new LinkedList<>();
    public LinkedList<ps> KZz = new LinkedList<>();
    public int oUv;

    public sa() {
        AppMethodBeat.i(117848);
        AppMethodBeat.o(117848);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117849);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            aVar.e(2, 8, this.KZz);
            aVar.e(3, 8, this.KZA);
            aVar.e(4, 8, this.KZB);
            aVar.e(5, 8, this.KZC);
            if (this.KZD != null) {
                aVar.ni(6, this.KZD.computeSize());
                this.KZD.writeFields(aVar);
            }
            if (this.KZE != null) {
                aVar.c(7, this.KZE);
            }
            aVar.e(8, 8, this.KZF);
            AppMethodBeat.o(117849);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0 + g.a.a.a.c(2, 8, this.KZz) + g.a.a.a.c(3, 8, this.KZA) + g.a.a.a.c(4, 8, this.KZB) + g.a.a.a.c(5, 8, this.KZC);
            if (this.KZD != null) {
                bu += g.a.a.a.nh(6, this.KZD.computeSize());
            }
            if (this.KZE != null) {
                bu += g.a.a.b.b.a.b(7, this.KZE);
            }
            int c2 = bu + g.a.a.a.c(8, 8, this.KZF);
            AppMethodBeat.o(117849);
            return c2;
        } else if (i2 == 2) {
            this.KZz.clear();
            this.KZA.clear();
            this.KZB.clear();
            this.KZC.clear();
            this.KZF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117849);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sa saVar = (sa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    saVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(117849);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ps psVar = new ps();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = psVar.populateBuilderWithField(aVar4, psVar, a.getNextFieldNumber(aVar4))) {
                        }
                        saVar.KZz.add(psVar);
                    }
                    AppMethodBeat.o(117849);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eye eye = new eye();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eye.populateBuilderWithField(aVar5, eye, a.getNextFieldNumber(aVar5))) {
                        }
                        saVar.KZA.add(eye);
                    }
                    AppMethodBeat.o(117849);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ahp ahp = new ahp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ahp.populateBuilderWithField(aVar6, ahp, a.getNextFieldNumber(aVar6))) {
                        }
                        saVar.KZB.add(ahp);
                    }
                    AppMethodBeat.o(117849);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fbp fbp = new fbp();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fbp.populateBuilderWithField(aVar7, fbp, a.getNextFieldNumber(aVar7))) {
                        }
                        saVar.KZC.add(fbp);
                    }
                    AppMethodBeat.o(117849);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dnn dnn = new dnn();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dnn.populateBuilderWithField(aVar8, dnn, a.getNextFieldNumber(aVar8))) {
                        }
                        saVar.KZD = dnn;
                    }
                    AppMethodBeat.o(117849);
                    return 0;
                case 7:
                    saVar.KZE = aVar3.UbS.hPo();
                    AppMethodBeat.o(117849);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        czb czb = new czb();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = czb.populateBuilderWithField(aVar9, czb, a.getNextFieldNumber(aVar9))) {
                        }
                        saVar.KZF.add(czb);
                    }
                    AppMethodBeat.o(117849);
                    return 0;
                default:
                    AppMethodBeat.o(117849);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117849);
            return -1;
        }
    }
}
