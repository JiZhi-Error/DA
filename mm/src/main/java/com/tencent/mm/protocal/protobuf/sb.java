package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class sb extends a {
    public rt KZG;
    public rs KZH;
    public long KZI;
    public rz KZJ;
    public sd KZK;
    public ry KZL;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117850);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            if (this.KZG != null) {
                aVar.ni(2, this.KZG.computeSize());
                this.KZG.writeFields(aVar);
            }
            if (this.KZH != null) {
                aVar.ni(3, this.KZH.computeSize());
                this.KZH.writeFields(aVar);
            }
            aVar.bb(4, this.KZI);
            if (this.KZJ != null) {
                aVar.ni(5, this.KZJ.computeSize());
                this.KZJ.writeFields(aVar);
            }
            if (this.KZK != null) {
                aVar.ni(6, this.KZK.computeSize());
                this.KZK.writeFields(aVar);
            }
            if (this.KZL != null) {
                aVar.ni(7, this.KZL.computeSize());
                this.KZL.writeFields(aVar);
            }
            AppMethodBeat.o(117850);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0;
            if (this.KZG != null) {
                bu += g.a.a.a.nh(2, this.KZG.computeSize());
            }
            if (this.KZH != null) {
                bu += g.a.a.a.nh(3, this.KZH.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(4, this.KZI);
            if (this.KZJ != null) {
                r += g.a.a.a.nh(5, this.KZJ.computeSize());
            }
            if (this.KZK != null) {
                r += g.a.a.a.nh(6, this.KZK.computeSize());
            }
            if (this.KZL != null) {
                r += g.a.a.a.nh(7, this.KZL.computeSize());
            }
            AppMethodBeat.o(117850);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117850);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sb sbVar = (sb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    sbVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(117850);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        rt rtVar = new rt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = rtVar.populateBuilderWithField(aVar4, rtVar, a.getNextFieldNumber(aVar4))) {
                        }
                        sbVar.KZG = rtVar;
                    }
                    AppMethodBeat.o(117850);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        rs rsVar = new rs();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = rsVar.populateBuilderWithField(aVar5, rsVar, a.getNextFieldNumber(aVar5))) {
                        }
                        sbVar.KZH = rsVar;
                    }
                    AppMethodBeat.o(117850);
                    return 0;
                case 4:
                    sbVar.KZI = aVar3.UbS.zl();
                    AppMethodBeat.o(117850);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        rz rzVar = new rz();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = rzVar.populateBuilderWithField(aVar6, rzVar, a.getNextFieldNumber(aVar6))) {
                        }
                        sbVar.KZJ = rzVar;
                    }
                    AppMethodBeat.o(117850);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        sd sdVar = new sd();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sdVar.populateBuilderWithField(aVar7, sdVar, a.getNextFieldNumber(aVar7))) {
                        }
                        sbVar.KZK = sdVar;
                    }
                    AppMethodBeat.o(117850);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ry ryVar = new ry();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ryVar.populateBuilderWithField(aVar8, ryVar, a.getNextFieldNumber(aVar8))) {
                        }
                        sbVar.KZL = ryVar;
                    }
                    AppMethodBeat.o(117850);
                    return 0;
                default:
                    AppMethodBeat.o(117850);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117850);
            return -1;
        }
    }
}
