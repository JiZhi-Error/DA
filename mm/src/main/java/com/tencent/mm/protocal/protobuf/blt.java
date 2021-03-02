package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class blt extends dop {
    public LinkedList<dqi> KGP = new LinkedList<>();
    public dqi LUA;
    public int LUu;
    public int LUv;
    public LinkedList<dqi> LUw = new LinkedList<>();
    public int LUx;
    public LinkedList<dqi> LUy = new LinkedList<>();
    public int LUz;

    public blt() {
        AppMethodBeat.i(32232);
        AppMethodBeat.o(32232);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32233);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LUu);
            aVar.e(3, 8, this.KGP);
            aVar.aM(4, this.LUv);
            aVar.e(5, 8, this.LUw);
            aVar.aM(6, this.LUx);
            aVar.e(7, 8, this.LUy);
            aVar.aM(8, this.LUz);
            if (this.LUA != null) {
                aVar.ni(9, this.LUA.computeSize());
                this.LUA.writeFields(aVar);
            }
            AppMethodBeat.o(32233);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LUu) + g.a.a.a.c(3, 8, this.KGP) + g.a.a.b.b.a.bu(4, this.LUv) + g.a.a.a.c(5, 8, this.LUw) + g.a.a.b.b.a.bu(6, this.LUx) + g.a.a.a.c(7, 8, this.LUy) + g.a.a.b.b.a.bu(8, this.LUz);
            if (this.LUA != null) {
                nh += g.a.a.a.nh(9, this.LUA.computeSize());
            }
            AppMethodBeat.o(32233);
            return nh;
        } else if (i2 == 2) {
            this.KGP.clear();
            this.LUw.clear();
            this.LUy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32233);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            blt blt = (blt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        blt.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32233);
                    return 0;
                case 2:
                    blt.LUu = aVar3.UbS.zi();
                    AppMethodBeat.o(32233);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        blt.KGP.add(dqi);
                    }
                    AppMethodBeat.o(32233);
                    return 0;
                case 4:
                    blt.LUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32233);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        blt.LUw.add(dqi2);
                    }
                    AppMethodBeat.o(32233);
                    return 0;
                case 6:
                    blt.LUx = aVar3.UbS.zi();
                    AppMethodBeat.o(32233);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi3.populateBuilderWithField(aVar7, dqi3, dop.getNextFieldNumber(aVar7))) {
                        }
                        blt.LUy.add(dqi3);
                    }
                    AppMethodBeat.o(32233);
                    return 0;
                case 8:
                    blt.LUz = aVar3.UbS.zi();
                    AppMethodBeat.o(32233);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dqi4.populateBuilderWithField(aVar8, dqi4, dop.getNextFieldNumber(aVar8))) {
                        }
                        blt.LUA = dqi4;
                    }
                    AppMethodBeat.o(32233);
                    return 0;
                default:
                    AppMethodBeat.o(32233);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32233);
            return -1;
        }
    }
}
