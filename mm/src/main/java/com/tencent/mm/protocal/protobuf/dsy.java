package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dsy extends dop {
    public String KXA;
    public long MRu;
    public long MRz;
    public int MUZ;
    public long MVa;
    public boolean MVb;
    public fdw MVc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117921);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KXA != null) {
                aVar.e(2, this.KXA);
            }
            aVar.bb(3, this.MRu);
            aVar.aM(4, this.MUZ);
            aVar.bb(5, this.MVa);
            aVar.cc(6, this.MVb);
            if (this.MVc != null) {
                aVar.ni(7, this.MVc.computeSize());
                this.MVc.writeFields(aVar);
            }
            aVar.bb(8, this.MRz);
            AppMethodBeat.o(117921);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KXA != null) {
                nh += g.a.a.b.b.a.f(2, this.KXA);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.MRu) + g.a.a.b.b.a.bu(4, this.MUZ) + g.a.a.b.b.a.r(5, this.MVa) + g.a.a.b.b.a.fS(6) + 1;
            if (this.MVc != null) {
                r += g.a.a.a.nh(7, this.MVc.computeSize());
            }
            int r2 = r + g.a.a.b.b.a.r(8, this.MRz);
            AppMethodBeat.o(117921);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117921);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsy dsy = (dsy) objArr[1];
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
                        dsy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(117921);
                    return 0;
                case 2:
                    dsy.KXA = aVar3.UbS.readString();
                    AppMethodBeat.o(117921);
                    return 0;
                case 3:
                    dsy.MRu = aVar3.UbS.zl();
                    AppMethodBeat.o(117921);
                    return 0;
                case 4:
                    dsy.MUZ = aVar3.UbS.zi();
                    AppMethodBeat.o(117921);
                    return 0;
                case 5:
                    dsy.MVa = aVar3.UbS.zl();
                    AppMethodBeat.o(117921);
                    return 0;
                case 6:
                    dsy.MVb = aVar3.UbS.yZ();
                    AppMethodBeat.o(117921);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fdw fdw = new fdw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fdw.populateBuilderWithField(aVar5, fdw, dop.getNextFieldNumber(aVar5))) {
                        }
                        dsy.MVc = fdw;
                    }
                    AppMethodBeat.o(117921);
                    return 0;
                case 8:
                    dsy.MRz = aVar3.UbS.zl();
                    AppMethodBeat.o(117921);
                    return 0;
                default:
                    AppMethodBeat.o(117921);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117921);
            return -1;
        }
    }
}
