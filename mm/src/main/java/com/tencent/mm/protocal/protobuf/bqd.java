package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bqd extends dop {
    public int LXV;
    public LinkedList<cpb> LXW = new LinkedList<>();
    public int LXX;
    public LinkedList<cko> LXY = new LinkedList<>();
    public String MD5;
    public int Scene;
    public int him;

    public bqd() {
        AppMethodBeat.i(155408);
        AppMethodBeat.o(155408);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155409);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.him);
            if (this.MD5 != null) {
                aVar.e(3, this.MD5);
            }
            aVar.aM(4, this.LXV);
            aVar.e(5, 8, this.LXW);
            aVar.aM(6, this.LXX);
            aVar.e(7, 8, this.LXY);
            aVar.aM(8, this.Scene);
            AppMethodBeat.o(155409);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.him);
            if (this.MD5 != null) {
                nh += g.a.a.b.b.a.f(3, this.MD5);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.LXV) + g.a.a.a.c(5, 8, this.LXW) + g.a.a.b.b.a.bu(6, this.LXX) + g.a.a.a.c(7, 8, this.LXY) + g.a.a.b.b.a.bu(8, this.Scene);
            AppMethodBeat.o(155409);
            return bu;
        } else if (i2 == 2) {
            this.LXW.clear();
            this.LXY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155409);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqd bqd = (bqd) objArr[1];
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
                        bqd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155409);
                    return 0;
                case 2:
                    bqd.him = aVar3.UbS.zi();
                    AppMethodBeat.o(155409);
                    return 0;
                case 3:
                    bqd.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(155409);
                    return 0;
                case 4:
                    bqd.LXV = aVar3.UbS.zi();
                    AppMethodBeat.o(155409);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cpb cpb = new cpb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cpb.populateBuilderWithField(aVar5, cpb, dop.getNextFieldNumber(aVar5))) {
                        }
                        bqd.LXW.add(cpb);
                    }
                    AppMethodBeat.o(155409);
                    return 0;
                case 6:
                    bqd.LXX = aVar3.UbS.zi();
                    AppMethodBeat.o(155409);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cko cko = new cko();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cko.populateBuilderWithField(aVar6, cko, dop.getNextFieldNumber(aVar6))) {
                        }
                        bqd.LXY.add(cko);
                    }
                    AppMethodBeat.o(155409);
                    return 0;
                case 8:
                    bqd.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(155409);
                    return 0;
                default:
                    AppMethodBeat.o(155409);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155409);
            return -1;
        }
    }
}
