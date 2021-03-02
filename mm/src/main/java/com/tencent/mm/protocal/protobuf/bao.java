package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bao extends dop {
    public aov LAI;
    public String LAt;
    public b LDx;
    public String fQY;
    public long hFK;
    public long liveId;
    public String object_nonce_id;
    public awq uke;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209637);
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
            if (this.LDx != null) {
                aVar.c(3, this.LDx);
            }
            if (this.uke != null) {
                aVar.ni(4, this.uke.computeSize());
                this.uke.writeFields(aVar);
            }
            aVar.bb(5, this.liveId);
            if (this.fQY != null) {
                aVar.e(6, this.fQY);
            }
            aVar.bb(7, this.hFK);
            if (this.object_nonce_id != null) {
                aVar.e(8, this.object_nonce_id);
            }
            if (this.LAt != null) {
                aVar.e(9, this.LAt);
            }
            AppMethodBeat.o(209637);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LAI != null) {
                nh += g.a.a.a.nh(2, this.LAI.computeSize());
            }
            if (this.LDx != null) {
                nh += g.a.a.b.b.a.b(3, this.LDx);
            }
            if (this.uke != null) {
                nh += g.a.a.a.nh(4, this.uke.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(5, this.liveId);
            if (this.fQY != null) {
                r += g.a.a.b.b.a.f(6, this.fQY);
            }
            int r2 = r + g.a.a.b.b.a.r(7, this.hFK);
            if (this.object_nonce_id != null) {
                r2 += g.a.a.b.b.a.f(8, this.object_nonce_id);
            }
            if (this.LAt != null) {
                r2 += g.a.a.b.b.a.f(9, this.LAt);
            }
            AppMethodBeat.o(209637);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209637);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bao bao = (bao) objArr[1];
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
                        bao.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209637);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        bao.LAI = aov;
                    }
                    AppMethodBeat.o(209637);
                    return 0;
                case 3:
                    bao.LDx = aVar3.UbS.hPo();
                    AppMethodBeat.o(209637);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        awq awq = new awq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awq.populateBuilderWithField(aVar6, awq, dop.getNextFieldNumber(aVar6))) {
                        }
                        bao.uke = awq;
                    }
                    AppMethodBeat.o(209637);
                    return 0;
                case 5:
                    bao.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209637);
                    return 0;
                case 6:
                    bao.fQY = aVar3.UbS.readString();
                    AppMethodBeat.o(209637);
                    return 0;
                case 7:
                    bao.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209637);
                    return 0;
                case 8:
                    bao.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209637);
                    return 0;
                case 9:
                    bao.LAt = aVar3.UbS.readString();
                    AppMethodBeat.o(209637);
                    return 0;
                default:
                    AppMethodBeat.o(209637);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209637);
            return -1;
        }
    }
}
