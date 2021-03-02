package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bn extends a {
    public eih KFh;
    public String KFi = "";
    public String KFj = "";
    public String KFk = "";
    public long KFl = 0;
    public int KFm = 0;
    public int flags = -1;
    public int state = -1;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122482);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KFh != null) {
                aVar.ni(1, this.KFh.computeSize());
                this.KFh.writeFields(aVar);
            }
            aVar.aM(2, this.flags);
            aVar.aM(3, this.state);
            if (this.KFi != null) {
                aVar.e(4, this.KFi);
            }
            if (this.KFj != null) {
                aVar.e(5, this.KFj);
            }
            if (this.KFk != null) {
                aVar.e(6, this.KFk);
            }
            aVar.bb(7, this.KFl);
            aVar.aM(8, this.KFm);
            AppMethodBeat.o(122482);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.KFh != null ? g.a.a.a.nh(1, this.KFh.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.flags) + g.a.a.b.b.a.bu(3, this.state);
            if (this.KFi != null) {
                nh += g.a.a.b.b.a.f(4, this.KFi);
            }
            if (this.KFj != null) {
                nh += g.a.a.b.b.a.f(5, this.KFj);
            }
            if (this.KFk != null) {
                nh += g.a.a.b.b.a.f(6, this.KFk);
            }
            int r = nh + g.a.a.b.b.a.r(7, this.KFl) + g.a.a.b.b.a.bu(8, this.KFm);
            AppMethodBeat.o(122482);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122482);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bn bnVar = (bn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eih eih = new eih();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eih.populateBuilderWithField(aVar4, eih, a.getNextFieldNumber(aVar4))) {
                        }
                        bnVar.KFh = eih;
                    }
                    AppMethodBeat.o(122482);
                    return 0;
                case 2:
                    bnVar.flags = aVar3.UbS.zi();
                    AppMethodBeat.o(122482);
                    return 0;
                case 3:
                    bnVar.state = aVar3.UbS.zi();
                    AppMethodBeat.o(122482);
                    return 0;
                case 4:
                    bnVar.KFi = aVar3.UbS.readString();
                    AppMethodBeat.o(122482);
                    return 0;
                case 5:
                    bnVar.KFj = aVar3.UbS.readString();
                    AppMethodBeat.o(122482);
                    return 0;
                case 6:
                    bnVar.KFk = aVar3.UbS.readString();
                    AppMethodBeat.o(122482);
                    return 0;
                case 7:
                    bnVar.KFl = aVar3.UbS.zl();
                    AppMethodBeat.o(122482);
                    return 0;
                case 8:
                    bnVar.KFm = aVar3.UbS.zi();
                    AppMethodBeat.o(122482);
                    return 0;
                default:
                    AppMethodBeat.o(122482);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122482);
            return -1;
        }
    }
}
