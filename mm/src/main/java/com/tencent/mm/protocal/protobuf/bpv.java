package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bpv extends dop {
    public int Height;
    public int LXN;
    public int LXO;
    public float LbC;
    public float LbD;
    public int Width;
    public String rBI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(56247);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.E(2, this.LbC);
            aVar.E(3, this.LbD);
            aVar.aM(4, this.Width);
            aVar.aM(5, this.Height);
            if (this.rBI != null) {
                aVar.e(6, this.rBI);
            }
            aVar.aM(7, this.LXN);
            aVar.aM(8, this.LXO);
            AppMethodBeat.o(56247);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.bu(4, this.Width) + g.a.a.b.b.a.bu(5, this.Height);
            if (this.rBI != null) {
                nh += g.a.a.b.b.a.f(6, this.rBI);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.LXN) + g.a.a.b.b.a.bu(8, this.LXO);
            AppMethodBeat.o(56247);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(56247);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bpv bpv = (bpv) objArr[1];
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
                        bpv.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(56247);
                    return 0;
                case 2:
                    bpv.LbC = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(56247);
                    return 0;
                case 3:
                    bpv.LbD = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(56247);
                    return 0;
                case 4:
                    bpv.Width = aVar3.UbS.zi();
                    AppMethodBeat.o(56247);
                    return 0;
                case 5:
                    bpv.Height = aVar3.UbS.zi();
                    AppMethodBeat.o(56247);
                    return 0;
                case 6:
                    bpv.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(56247);
                    return 0;
                case 7:
                    bpv.LXN = aVar3.UbS.zi();
                    AppMethodBeat.o(56247);
                    return 0;
                case 8:
                    bpv.LXO = aVar3.UbS.zi();
                    AppMethodBeat.o(56247);
                    return 0;
                default:
                    AppMethodBeat.o(56247);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56247);
            return -1;
        }
    }
}
