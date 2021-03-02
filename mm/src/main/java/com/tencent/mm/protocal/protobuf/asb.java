package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class asb extends dop {
    public aov LAI;
    public String finderUsername;
    public long hFK;
    public b lastBuffer;
    public b likeBuffer;
    public String objectNonceId;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209408);
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
            if (this.finderUsername != null) {
                aVar.e(3, this.finderUsername);
            }
            aVar.aM(4, this.scene);
            if (this.lastBuffer != null) {
                aVar.c(5, this.lastBuffer);
            }
            aVar.bb(6, this.hFK);
            if (this.objectNonceId != null) {
                aVar.e(7, this.objectNonceId);
            }
            if (this.likeBuffer != null) {
                aVar.c(8, this.likeBuffer);
            }
            AppMethodBeat.o(209408);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LAI != null) {
                nh += g.a.a.a.nh(2, this.LAI.computeSize());
            }
            if (this.finderUsername != null) {
                nh += g.a.a.b.b.a.f(3, this.finderUsername);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.scene);
            if (this.lastBuffer != null) {
                bu += g.a.a.b.b.a.b(5, this.lastBuffer);
            }
            int r = bu + g.a.a.b.b.a.r(6, this.hFK);
            if (this.objectNonceId != null) {
                r += g.a.a.b.b.a.f(7, this.objectNonceId);
            }
            if (this.likeBuffer != null) {
                r += g.a.a.b.b.a.b(8, this.likeBuffer);
            }
            AppMethodBeat.o(209408);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209408);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            asb asb = (asb) objArr[1];
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
                        asb.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209408);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        asb.LAI = aov;
                    }
                    AppMethodBeat.o(209408);
                    return 0;
                case 3:
                    asb.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(209408);
                    return 0;
                case 4:
                    asb.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209408);
                    return 0;
                case 5:
                    asb.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209408);
                    return 0;
                case 6:
                    asb.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209408);
                    return 0;
                case 7:
                    asb.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(209408);
                    return 0;
                case 8:
                    asb.likeBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209408);
                    return 0;
                default:
                    AppMethodBeat.o(209408);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209408);
            return -1;
        }
    }
}
