package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aiv extends a {
    public fbr Lsr;
    public String Lss;
    public long begin_time;
    public long duration;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110893);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lsr != null) {
                aVar.ni(1, this.Lsr.computeSize());
                this.Lsr.writeFields(aVar);
            }
            aVar.bb(2, this.begin_time);
            aVar.bb(3, this.duration);
            if (this.Lss != null) {
                aVar.e(4, this.Lss);
            }
            AppMethodBeat.o(110893);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Lsr != null ? g.a.a.a.nh(1, this.Lsr.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.begin_time) + g.a.a.b.b.a.r(3, this.duration);
            if (this.Lss != null) {
                nh += g.a.a.b.b.a.f(4, this.Lss);
            }
            AppMethodBeat.o(110893);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110893);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aiv aiv = (aiv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbr fbr = new fbr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbr.populateBuilderWithField(aVar4, fbr, a.getNextFieldNumber(aVar4))) {
                        }
                        aiv.Lsr = fbr;
                    }
                    AppMethodBeat.o(110893);
                    return 0;
                case 2:
                    aiv.begin_time = aVar3.UbS.zl();
                    AppMethodBeat.o(110893);
                    return 0;
                case 3:
                    aiv.duration = aVar3.UbS.zl();
                    AppMethodBeat.o(110893);
                    return 0;
                case 4:
                    aiv.Lss = aVar3.UbS.readString();
                    AppMethodBeat.o(110893);
                    return 0;
                default:
                    AppMethodBeat.o(110893);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110893);
            return -1;
        }
    }
}
