package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bag extends dop {
    public apc LAv;
    public aov LBM;
    public long LCz;
    public b LDs;
    public int LJW;
    public String dRy;
    public float dTj;
    public float latitude;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209628);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LBM != null) {
                aVar.ni(2, this.LBM.computeSize());
                this.LBM.writeFields(aVar);
            }
            if (this.LDs != null) {
                aVar.c(3, this.LDs);
            }
            aVar.E(4, this.dTj);
            aVar.E(5, this.latitude);
            if (this.LAv != null) {
                aVar.ni(6, this.LAv.computeSize());
                this.LAv.writeFields(aVar);
            }
            if (this.dRy != null) {
                aVar.e(7, this.dRy);
            }
            aVar.bb(8, this.LCz);
            aVar.aM(9, this.LJW);
            AppMethodBeat.o(209628);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(3, this.LDs);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.fS(5) + 4;
            if (this.LAv != null) {
                fS += g.a.a.a.nh(6, this.LAv.computeSize());
            }
            if (this.dRy != null) {
                fS += g.a.a.b.b.a.f(7, this.dRy);
            }
            int r = fS + g.a.a.b.b.a.r(8, this.LCz) + g.a.a.b.b.a.bu(9, this.LJW);
            AppMethodBeat.o(209628);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209628);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bag bag = (bag) objArr[1];
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
                        bag.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209628);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        bag.LBM = aov;
                    }
                    AppMethodBeat.o(209628);
                    return 0;
                case 3:
                    bag.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(209628);
                    return 0;
                case 4:
                    bag.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209628);
                    return 0;
                case 5:
                    bag.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209628);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        apc apc = new apc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = apc.populateBuilderWithField(aVar6, apc, dop.getNextFieldNumber(aVar6))) {
                        }
                        bag.LAv = apc;
                    }
                    AppMethodBeat.o(209628);
                    return 0;
                case 7:
                    bag.dRy = aVar3.UbS.readString();
                    AppMethodBeat.o(209628);
                    return 0;
                case 8:
                    bag.LCz = aVar3.UbS.zl();
                    AppMethodBeat.o(209628);
                    return 0;
                case 9:
                    bag.LJW = aVar3.UbS.zi();
                    AppMethodBeat.o(209628);
                    return 0;
                default:
                    AppMethodBeat.o(209628);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209628);
            return -1;
        }
    }
}
