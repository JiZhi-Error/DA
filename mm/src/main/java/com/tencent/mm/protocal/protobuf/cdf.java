package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cdf extends a {
    public String MiW;
    public String MiX;
    public agx MiY;
    public agx MiZ;
    public String Mja;
    public String Mjb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72509);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MiW != null) {
                aVar.e(1, this.MiW);
            }
            if (this.MiX != null) {
                aVar.e(2, this.MiX);
            }
            if (this.MiY != null) {
                aVar.ni(3, this.MiY.computeSize());
                this.MiY.writeFields(aVar);
            }
            if (this.MiZ != null) {
                aVar.ni(4, this.MiZ.computeSize());
                this.MiZ.writeFields(aVar);
            }
            if (this.Mja != null) {
                aVar.e(5, this.Mja);
            }
            if (this.Mjb != null) {
                aVar.e(6, this.Mjb);
            }
            AppMethodBeat.o(72509);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MiW != null ? g.a.a.b.b.a.f(1, this.MiW) + 0 : 0;
            if (this.MiX != null) {
                f2 += g.a.a.b.b.a.f(2, this.MiX);
            }
            if (this.MiY != null) {
                f2 += g.a.a.a.nh(3, this.MiY.computeSize());
            }
            if (this.MiZ != null) {
                f2 += g.a.a.a.nh(4, this.MiZ.computeSize());
            }
            if (this.Mja != null) {
                f2 += g.a.a.b.b.a.f(5, this.Mja);
            }
            if (this.Mjb != null) {
                f2 += g.a.a.b.b.a.f(6, this.Mjb);
            }
            AppMethodBeat.o(72509);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72509);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cdf cdf = (cdf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cdf.MiW = aVar3.UbS.readString();
                    AppMethodBeat.o(72509);
                    return 0;
                case 2:
                    cdf.MiX = aVar3.UbS.readString();
                    AppMethodBeat.o(72509);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        agx agx = new agx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = agx.populateBuilderWithField(aVar4, agx, a.getNextFieldNumber(aVar4))) {
                        }
                        cdf.MiY = agx;
                    }
                    AppMethodBeat.o(72509);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        agx agx2 = new agx();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = agx2.populateBuilderWithField(aVar5, agx2, a.getNextFieldNumber(aVar5))) {
                        }
                        cdf.MiZ = agx2;
                    }
                    AppMethodBeat.o(72509);
                    return 0;
                case 5:
                    cdf.Mja = aVar3.UbS.readString();
                    AppMethodBeat.o(72509);
                    return 0;
                case 6:
                    cdf.Mjb = aVar3.UbS.readString();
                    AppMethodBeat.o(72509);
                    return 0;
                default:
                    AppMethodBeat.o(72509);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72509);
            return -1;
        }
    }
}
