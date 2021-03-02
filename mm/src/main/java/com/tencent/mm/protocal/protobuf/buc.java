package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class buc extends dop {
    public int MaL;
    public int MaM;
    public vf MaN;
    public aat MaO;
    public int MaP;
    public long clK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50089);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MaL);
            aVar.aM(3, this.MaM);
            if (this.MaN != null) {
                aVar.ni(4, this.MaN.computeSize());
                this.MaN.writeFields(aVar);
            }
            aVar.bb(5, this.clK);
            if (this.MaO != null) {
                aVar.ni(6, this.MaO.computeSize());
                this.MaO.writeFields(aVar);
            }
            aVar.aM(7, this.MaP);
            AppMethodBeat.o(50089);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MaL) + g.a.a.b.b.a.bu(3, this.MaM);
            if (this.MaN != null) {
                nh += g.a.a.a.nh(4, this.MaN.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(5, this.clK);
            if (this.MaO != null) {
                r += g.a.a.a.nh(6, this.MaO.computeSize());
            }
            int bu = r + g.a.a.b.b.a.bu(7, this.MaP);
            AppMethodBeat.o(50089);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50089);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            buc buc = (buc) objArr[1];
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
                        buc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(50089);
                    return 0;
                case 2:
                    buc.MaL = aVar3.UbS.zi();
                    AppMethodBeat.o(50089);
                    return 0;
                case 3:
                    buc.MaM = aVar3.UbS.zi();
                    AppMethodBeat.o(50089);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        vf vfVar = new vf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = vfVar.populateBuilderWithField(aVar5, vfVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        buc.MaN = vfVar;
                    }
                    AppMethodBeat.o(50089);
                    return 0;
                case 5:
                    buc.clK = aVar3.UbS.zl();
                    AppMethodBeat.o(50089);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aat aat = new aat();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aat.populateBuilderWithField(aVar6, aat, dop.getNextFieldNumber(aVar6))) {
                        }
                        buc.MaO = aat;
                    }
                    AppMethodBeat.o(50089);
                    return 0;
                case 7:
                    buc.MaP = aVar3.UbS.zi();
                    AppMethodBeat.o(50089);
                    return 0;
                default:
                    AppMethodBeat.o(50089);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50089);
            return -1;
        }
    }
}
