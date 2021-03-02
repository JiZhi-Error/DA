package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class axm extends dop {
    public aov LAI;
    public b LDx;
    public long LGk;
    public String LGs;
    public int dYx;
    public String fQY;
    public String finderUsername;
    public long hFK;
    public long liveId;
    public long seq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209566);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LAI != null) {
                aVar.ni(2, this.LAI.computeSize());
                this.LAI.writeFields(aVar);
            }
            aVar.bb(3, this.hFK);
            aVar.bb(4, this.liveId);
            aVar.bb(5, this.seq);
            aVar.aM(6, this.dYx);
            if (this.LDx != null) {
                aVar.c(7, this.LDx);
            }
            if (this.fQY != null) {
                aVar.e(8, this.fQY);
            }
            aVar.bb(9, this.LGk);
            if (this.finderUsername != null) {
                aVar.e(10, this.finderUsername);
            }
            if (this.LGs != null) {
                aVar.e(11, this.LGs);
            }
            AppMethodBeat.o(209566);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LAI != null) {
                nh += g.a.a.a.nh(2, this.LAI.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(3, this.hFK) + g.a.a.b.b.a.r(4, this.liveId) + g.a.a.b.b.a.r(5, this.seq) + g.a.a.b.b.a.bu(6, this.dYx);
            if (this.LDx != null) {
                r += g.a.a.b.b.a.b(7, this.LDx);
            }
            if (this.fQY != null) {
                r += g.a.a.b.b.a.f(8, this.fQY);
            }
            int r2 = r + g.a.a.b.b.a.r(9, this.LGk);
            if (this.finderUsername != null) {
                r2 += g.a.a.b.b.a.f(10, this.finderUsername);
            }
            if (this.LGs != null) {
                r2 += g.a.a.b.b.a.f(11, this.LGs);
            }
            AppMethodBeat.o(209566);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209566);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axm axm = (axm) objArr[1];
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
                        axm.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209566);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        axm.LAI = aov;
                    }
                    AppMethodBeat.o(209566);
                    return 0;
                case 3:
                    axm.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209566);
                    return 0;
                case 4:
                    axm.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209566);
                    return 0;
                case 5:
                    axm.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(209566);
                    return 0;
                case 6:
                    axm.dYx = aVar3.UbS.zi();
                    AppMethodBeat.o(209566);
                    return 0;
                case 7:
                    axm.LDx = aVar3.UbS.hPo();
                    AppMethodBeat.o(209566);
                    return 0;
                case 8:
                    axm.fQY = aVar3.UbS.readString();
                    AppMethodBeat.o(209566);
                    return 0;
                case 9:
                    axm.LGk = aVar3.UbS.zl();
                    AppMethodBeat.o(209566);
                    return 0;
                case 10:
                    axm.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(209566);
                    return 0;
                case 11:
                    axm.LGs = aVar3.UbS.readString();
                    AppMethodBeat.o(209566);
                    return 0;
                default:
                    AppMethodBeat.o(209566);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209566);
            return -1;
        }
    }
}
