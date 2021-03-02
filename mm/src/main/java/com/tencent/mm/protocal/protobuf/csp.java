package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class csp extends a {
    public LinkedList<FinderObject> LDi = new LinkedList<>();
    public FinderObject MxE;
    public String MxF;
    public axw MxG;
    public long localId;
    public int scene;

    public csp() {
        AppMethodBeat.i(209771);
        AppMethodBeat.o(209771);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209772);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MxE != null) {
                aVar.ni(1, this.MxE.computeSize());
                this.MxE.writeFields(aVar);
            }
            aVar.e(2, 8, this.LDi);
            if (this.MxF != null) {
                aVar.e(3, this.MxF);
            }
            aVar.aM(4, this.scene);
            aVar.bb(5, this.localId);
            if (this.MxG != null) {
                aVar.ni(6, this.MxG.computeSize());
                this.MxG.writeFields(aVar);
            }
            AppMethodBeat.o(209772);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.MxE != null ? g.a.a.a.nh(1, this.MxE.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LDi);
            if (this.MxF != null) {
                nh += g.a.a.b.b.a.f(3, this.MxF);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.scene) + g.a.a.b.b.a.r(5, this.localId);
            if (this.MxG != null) {
                bu += g.a.a.a.nh(6, this.MxG.computeSize());
            }
            AppMethodBeat.o(209772);
            return bu;
        } else if (i2 == 2) {
            this.LDi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209772);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csp csp = (csp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderObject.populateBuilderWithField(aVar4, finderObject, a.getNextFieldNumber(aVar4))) {
                        }
                        csp.MxE = finderObject;
                    }
                    AppMethodBeat.o(209772);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject2 = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject2.populateBuilderWithField(aVar5, finderObject2, a.getNextFieldNumber(aVar5))) {
                        }
                        csp.LDi.add(finderObject2);
                    }
                    AppMethodBeat.o(209772);
                    return 0;
                case 3:
                    csp.MxF = aVar3.UbS.readString();
                    AppMethodBeat.o(209772);
                    return 0;
                case 4:
                    csp.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209772);
                    return 0;
                case 5:
                    csp.localId = aVar3.UbS.zl();
                    AppMethodBeat.o(209772);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        axw axw = new axw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = axw.populateBuilderWithField(aVar6, axw, a.getNextFieldNumber(aVar6))) {
                        }
                        csp.MxG = axw;
                    }
                    AppMethodBeat.o(209772);
                    return 0;
                default:
                    AppMethodBeat.o(209772);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209772);
            return -1;
        }
    }
}
