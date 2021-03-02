package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dqd extends a {
    public String KNW;
    public ehf Lov;
    public cyf MTe;
    public float MTf;
    public long MTg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91675);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KNW != null) {
                aVar.e(1, this.KNW);
            }
            if (this.Lov != null) {
                aVar.ni(2, this.Lov.computeSize());
                this.Lov.writeFields(aVar);
            }
            if (this.MTe != null) {
                aVar.ni(3, this.MTe.computeSize());
                this.MTe.writeFields(aVar);
            }
            aVar.E(4, this.MTf);
            aVar.bb(5, this.MTg);
            AppMethodBeat.o(91675);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KNW != null ? g.a.a.b.b.a.f(1, this.KNW) + 0 : 0;
            if (this.Lov != null) {
                f2 += g.a.a.a.nh(2, this.Lov.computeSize());
            }
            if (this.MTe != null) {
                f2 += g.a.a.a.nh(3, this.MTe.computeSize());
            }
            int fS = f2 + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.r(5, this.MTg);
            AppMethodBeat.o(91675);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91675);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dqd dqd = (dqd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dqd.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91675);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehf.populateBuilderWithField(aVar4, ehf, a.getNextFieldNumber(aVar4))) {
                        }
                        dqd.Lov = ehf;
                    }
                    AppMethodBeat.o(91675);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cyf cyf = new cyf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cyf.populateBuilderWithField(aVar5, cyf, a.getNextFieldNumber(aVar5))) {
                        }
                        dqd.MTe = cyf;
                    }
                    AppMethodBeat.o(91675);
                    return 0;
                case 4:
                    dqd.MTf = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(91675);
                    return 0;
                case 5:
                    dqd.MTg = aVar3.UbS.zl();
                    AppMethodBeat.o(91675);
                    return 0;
                default:
                    AppMethodBeat.o(91675);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91675);
            return -1;
        }
    }
}
