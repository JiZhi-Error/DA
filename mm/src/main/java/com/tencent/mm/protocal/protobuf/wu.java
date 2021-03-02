package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wu extends dop {
    public boolean LhR;
    public boolean LhS;
    public LinkedList<Integer> Lhn = new LinkedList<>();
    public String desc;

    public wu() {
        AppMethodBeat.i(72444);
        AppMethodBeat.o(72444);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72445);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 2, this.Lhn);
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.cc(4, this.LhR);
            aVar.cc(5, this.LhS);
            AppMethodBeat.o(72445);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 2, this.Lhn);
            if (this.desc != null) {
                nh += g.a.a.b.b.a.f(3, this.desc);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(72445);
            return fS;
        } else if (i2 == 2) {
            this.Lhn.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72445);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wu wuVar = (wu) objArr[1];
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
                        wuVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72445);
                    return 0;
                case 2:
                    wuVar.Lhn.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(72445);
                    return 0;
                case 3:
                    wuVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(72445);
                    return 0;
                case 4:
                    wuVar.LhR = aVar3.UbS.yZ();
                    AppMethodBeat.o(72445);
                    return 0;
                case 5:
                    wuVar.LhS = aVar3.UbS.yZ();
                    AppMethodBeat.o(72445);
                    return 0;
                default:
                    AppMethodBeat.o(72445);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72445);
            return -1;
        }
    }
}
