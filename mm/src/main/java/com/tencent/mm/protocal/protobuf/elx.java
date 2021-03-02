package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class elx extends dop {
    public String McL;
    public String rCp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32479);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.McL != null) {
                aVar.e(2, this.McL);
            }
            if (this.rCp != null) {
                aVar.e(3, this.rCp);
            }
            AppMethodBeat.o(32479);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.McL != null) {
                nh += g.a.a.b.b.a.f(2, this.McL);
            }
            if (this.rCp != null) {
                nh += g.a.a.b.b.a.f(3, this.rCp);
            }
            AppMethodBeat.o(32479);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32479);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            elx elx = (elx) objArr[1];
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
                        elx.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32479);
                    return 0;
                case 2:
                    elx.McL = aVar3.UbS.readString();
                    AppMethodBeat.o(32479);
                    return 0;
                case 3:
                    elx.rCp = aVar3.UbS.readString();
                    AppMethodBeat.o(32479);
                    return 0;
                default:
                    AppMethodBeat.o(32479);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32479);
            return -1;
        }
    }
}
