package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class arf extends dop {
    public String LCo;
    public String finderUsername;
    public int opType;
    public long refObjectId;
    public String refObjectNonceId;
    public String sessionBuffer;
    public aov uli;
    public int vkj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168964);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LCo != null) {
                aVar.e(2, this.LCo);
            }
            aVar.aM(3, this.opType);
            aVar.bb(4, this.refObjectId);
            if (this.finderUsername != null) {
                aVar.e(5, this.finderUsername);
            }
            if (this.refObjectNonceId != null) {
                aVar.e(6, this.refObjectNonceId);
            }
            if (this.uli != null) {
                aVar.ni(7, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.sessionBuffer != null) {
                aVar.e(8, this.sessionBuffer);
            }
            aVar.aM(9, this.vkj);
            AppMethodBeat.o(168964);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LCo != null) {
                nh += g.a.a.b.b.a.f(2, this.LCo);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.opType) + g.a.a.b.b.a.r(4, this.refObjectId);
            if (this.finderUsername != null) {
                bu += g.a.a.b.b.a.f(5, this.finderUsername);
            }
            if (this.refObjectNonceId != null) {
                bu += g.a.a.b.b.a.f(6, this.refObjectNonceId);
            }
            if (this.uli != null) {
                bu += g.a.a.a.nh(7, this.uli.computeSize());
            }
            if (this.sessionBuffer != null) {
                bu += g.a.a.b.b.a.f(8, this.sessionBuffer);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.vkj);
            AppMethodBeat.o(168964);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168964);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            arf arf = (arf) objArr[1];
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
                        arf.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168964);
                    return 0;
                case 2:
                    arf.LCo = aVar3.UbS.readString();
                    AppMethodBeat.o(168964);
                    return 0;
                case 3:
                    arf.opType = aVar3.UbS.zi();
                    AppMethodBeat.o(168964);
                    return 0;
                case 4:
                    arf.refObjectId = aVar3.UbS.zl();
                    AppMethodBeat.o(168964);
                    return 0;
                case 5:
                    arf.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(168964);
                    return 0;
                case 6:
                    arf.refObjectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(168964);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        arf.uli = aov;
                    }
                    AppMethodBeat.o(168964);
                    return 0;
                case 8:
                    arf.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(168964);
                    return 0;
                case 9:
                    arf.vkj = aVar3.UbS.zi();
                    AppMethodBeat.o(168964);
                    return 0;
                default:
                    AppMethodBeat.o(168964);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168964);
            return -1;
        }
    }
}
