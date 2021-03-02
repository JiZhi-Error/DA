package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bad extends dop {
    public String finderUsername;
    public b lastBuffer;
    public long refObjectId;
    public String refObjectNonceId;
    public aov uli;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169032);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.bb(3, this.refObjectId);
            if (this.finderUsername != null) {
                aVar.e(4, this.finderUsername);
            }
            if (this.lastBuffer != null) {
                aVar.c(5, this.lastBuffer);
            }
            if (this.refObjectNonceId != null) {
                aVar.e(6, this.refObjectNonceId);
            }
            if (this.uli != null) {
                aVar.ni(7, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            AppMethodBeat.o(169032);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(2, this.username);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.refObjectId);
            if (this.finderUsername != null) {
                r += g.a.a.b.b.a.f(4, this.finderUsername);
            }
            if (this.lastBuffer != null) {
                r += g.a.a.b.b.a.b(5, this.lastBuffer);
            }
            if (this.refObjectNonceId != null) {
                r += g.a.a.b.b.a.f(6, this.refObjectNonceId);
            }
            if (this.uli != null) {
                r += g.a.a.a.nh(7, this.uli.computeSize());
            }
            AppMethodBeat.o(169032);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169032);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bad bad = (bad) objArr[1];
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
                        bad.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169032);
                    return 0;
                case 2:
                    bad.username = aVar3.UbS.readString();
                    AppMethodBeat.o(169032);
                    return 0;
                case 3:
                    bad.refObjectId = aVar3.UbS.zl();
                    AppMethodBeat.o(169032);
                    return 0;
                case 4:
                    bad.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(169032);
                    return 0;
                case 5:
                    bad.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(169032);
                    return 0;
                case 6:
                    bad.refObjectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(169032);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        bad.uli = aov;
                    }
                    AppMethodBeat.o(169032);
                    return 0;
                default:
                    AppMethodBeat.o(169032);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169032);
            return -1;
        }
    }
}
