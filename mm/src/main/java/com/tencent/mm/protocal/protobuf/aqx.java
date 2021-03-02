package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aqx extends dop {
    public int LCJ;
    public int LCK;
    public long id;
    public String objectNonceId;
    public String sessionBuffer;
    public aov uli;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168960);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.id);
            aVar.aM(3, this.LCJ);
            aVar.aM(4, this.LCK);
            if (this.objectNonceId != null) {
                aVar.e(5, this.objectNonceId);
            }
            if (this.uli != null) {
                aVar.ni(6, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.sessionBuffer != null) {
                aVar.e(7, this.sessionBuffer);
            }
            AppMethodBeat.o(168960);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.id) + g.a.a.b.b.a.bu(3, this.LCJ) + g.a.a.b.b.a.bu(4, this.LCK);
            if (this.objectNonceId != null) {
                nh += g.a.a.b.b.a.f(5, this.objectNonceId);
            }
            if (this.uli != null) {
                nh += g.a.a.a.nh(6, this.uli.computeSize());
            }
            if (this.sessionBuffer != null) {
                nh += g.a.a.b.b.a.f(7, this.sessionBuffer);
            }
            AppMethodBeat.o(168960);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168960);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqx aqx = (aqx) objArr[1];
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
                        aqx.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168960);
                    return 0;
                case 2:
                    aqx.id = aVar3.UbS.zl();
                    AppMethodBeat.o(168960);
                    return 0;
                case 3:
                    aqx.LCJ = aVar3.UbS.zi();
                    AppMethodBeat.o(168960);
                    return 0;
                case 4:
                    aqx.LCK = aVar3.UbS.zi();
                    AppMethodBeat.o(168960);
                    return 0;
                case 5:
                    aqx.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(168960);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        aqx.uli = aov;
                    }
                    AppMethodBeat.o(168960);
                    return 0;
                case 7:
                    aqx.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(168960);
                    return 0;
                default:
                    AppMethodBeat.o(168960);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168960);
            return -1;
        }
    }
}
