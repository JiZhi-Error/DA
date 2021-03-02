package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aqt extends dop {
    public aov LAI;
    public int dYx;
    public String finderUsername;
    public long hFK;
    public String objectNonceId;
    public String sessionBuffer;
    public long tal;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209381);
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
            aVar.aM(4, this.dYx);
            if (this.objectNonceId != null) {
                aVar.e(5, this.objectNonceId);
            }
            aVar.bb(6, this.tal);
            if (this.finderUsername != null) {
                aVar.e(7, this.finderUsername);
            }
            if (this.sessionBuffer != null) {
                aVar.e(8, this.sessionBuffer);
            }
            AppMethodBeat.o(209381);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LAI != null) {
                nh += g.a.a.a.nh(2, this.LAI.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(3, this.hFK) + g.a.a.b.b.a.bu(4, this.dYx);
            if (this.objectNonceId != null) {
                r += g.a.a.b.b.a.f(5, this.objectNonceId);
            }
            int r2 = r + g.a.a.b.b.a.r(6, this.tal);
            if (this.finderUsername != null) {
                r2 += g.a.a.b.b.a.f(7, this.finderUsername);
            }
            if (this.sessionBuffer != null) {
                r2 += g.a.a.b.b.a.f(8, this.sessionBuffer);
            }
            AppMethodBeat.o(209381);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209381);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqt aqt = (aqt) objArr[1];
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
                        aqt.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209381);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        aqt.LAI = aov;
                    }
                    AppMethodBeat.o(209381);
                    return 0;
                case 3:
                    aqt.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209381);
                    return 0;
                case 4:
                    aqt.dYx = aVar3.UbS.zi();
                    AppMethodBeat.o(209381);
                    return 0;
                case 5:
                    aqt.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(209381);
                    return 0;
                case 6:
                    aqt.tal = aVar3.UbS.zl();
                    AppMethodBeat.o(209381);
                    return 0;
                case 7:
                    aqt.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(209381);
                    return 0;
                case 8:
                    aqt.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(209381);
                    return 0;
                default:
                    AppMethodBeat.o(209381);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209381);
            return -1;
        }
    }
}
