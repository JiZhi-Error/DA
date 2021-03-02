package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class csq extends a {
    public long KTS;
    public long LQL;
    public long LQM;
    public String MqU;
    public String MqW;
    public LinkedList<String> MqX = new LinkedList<>();
    public LinkedList<clq> MqY = new LinkedList<>();
    public String MxH;

    public csq() {
        AppMethodBeat.i(110907);
        AppMethodBeat.o(110907);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110908);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.LQM);
            aVar.bb(2, this.LQL);
            if (this.MqU != null) {
                aVar.e(3, this.MqU);
            }
            aVar.bb(4, this.KTS);
            if (this.MqW != null) {
                aVar.e(5, this.MqW);
            }
            aVar.e(6, 1, this.MqX);
            aVar.e(7, 8, this.MqY);
            if (this.MxH != null) {
                aVar.e(8, this.MxH);
            }
            AppMethodBeat.o(110908);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.LQM) + 0 + g.a.a.b.b.a.r(2, this.LQL);
            if (this.MqU != null) {
                r += g.a.a.b.b.a.f(3, this.MqU);
            }
            int r2 = r + g.a.a.b.b.a.r(4, this.KTS);
            if (this.MqW != null) {
                r2 += g.a.a.b.b.a.f(5, this.MqW);
            }
            int c2 = r2 + g.a.a.a.c(6, 1, this.MqX) + g.a.a.a.c(7, 8, this.MqY);
            if (this.MxH != null) {
                c2 += g.a.a.b.b.a.f(8, this.MxH);
            }
            AppMethodBeat.o(110908);
            return c2;
        } else if (i2 == 2) {
            this.MqX.clear();
            this.MqY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110908);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csq csq = (csq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    csq.LQM = aVar3.UbS.zl();
                    AppMethodBeat.o(110908);
                    return 0;
                case 2:
                    csq.LQL = aVar3.UbS.zl();
                    AppMethodBeat.o(110908);
                    return 0;
                case 3:
                    csq.MqU = aVar3.UbS.readString();
                    AppMethodBeat.o(110908);
                    return 0;
                case 4:
                    csq.KTS = aVar3.UbS.zl();
                    AppMethodBeat.o(110908);
                    return 0;
                case 5:
                    csq.MqW = aVar3.UbS.readString();
                    AppMethodBeat.o(110908);
                    return 0;
                case 6:
                    csq.MqX.add(aVar3.UbS.readString());
                    AppMethodBeat.o(110908);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        clq clq = new clq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = clq.populateBuilderWithField(aVar4, clq, a.getNextFieldNumber(aVar4))) {
                        }
                        csq.MqY.add(clq);
                    }
                    AppMethodBeat.o(110908);
                    return 0;
                case 8:
                    csq.MxH = aVar3.UbS.readString();
                    AppMethodBeat.o(110908);
                    return 0;
                default:
                    AppMethodBeat.o(110908);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110908);
            return -1;
        }
    }
}
