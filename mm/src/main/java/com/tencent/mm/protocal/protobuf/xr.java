package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class xr extends dop {
    public String LiP;
    public String LiQ;
    public String dDj;
    public String ynT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72452);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LiP != null) {
                aVar.e(2, this.LiP);
            }
            if (this.LiQ != null) {
                aVar.e(3, this.LiQ);
            }
            if (this.ynT != null) {
                aVar.e(4, this.ynT);
            }
            if (this.dDj != null) {
                aVar.e(5, this.dDj);
            }
            AppMethodBeat.o(72452);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LiP != null) {
                nh += g.a.a.b.b.a.f(2, this.LiP);
            }
            if (this.LiQ != null) {
                nh += g.a.a.b.b.a.f(3, this.LiQ);
            }
            if (this.ynT != null) {
                nh += g.a.a.b.b.a.f(4, this.ynT);
            }
            if (this.dDj != null) {
                nh += g.a.a.b.b.a.f(5, this.dDj);
            }
            AppMethodBeat.o(72452);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72452);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            xr xrVar = (xr) objArr[1];
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
                        xrVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72452);
                    return 0;
                case 2:
                    xrVar.LiP = aVar3.UbS.readString();
                    AppMethodBeat.o(72452);
                    return 0;
                case 3:
                    xrVar.LiQ = aVar3.UbS.readString();
                    AppMethodBeat.o(72452);
                    return 0;
                case 4:
                    xrVar.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(72452);
                    return 0;
                case 5:
                    xrVar.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(72452);
                    return 0;
                default:
                    AppMethodBeat.o(72452);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72452);
            return -1;
        }
    }
}
