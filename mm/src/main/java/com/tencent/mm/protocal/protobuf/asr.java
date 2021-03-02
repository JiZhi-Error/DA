package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class asr extends dop {
    public boolean AqQ;
    public aov LAI;
    public b LDx;
    public avk LDy;
    public String finderUsername;
    public long hFK;
    public long liveId;
    public String object_nonce_id;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209421);
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
            aVar.bb(4, this.liveId);
            if (this.finderUsername != null) {
                aVar.e(5, this.finderUsername);
            }
            aVar.aM(6, this.scene);
            aVar.bb(7, this.hFK);
            aVar.cc(8, this.AqQ);
            if (this.object_nonce_id != null) {
                aVar.e(9, this.object_nonce_id);
            }
            if (this.LDy != null) {
                aVar.ni(10, this.LDy.computeSize());
                this.LDy.writeFields(aVar);
            }
            AppMethodBeat.o(209421);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LAI != null) {
                nh += g.a.a.a.nh(2, this.LAI.computeSize());
            }
            if (this.LDx != null) {
                nh += g.a.a.b.b.a.b(3, this.LDx);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.liveId);
            if (this.finderUsername != null) {
                r += g.a.a.b.b.a.f(5, this.finderUsername);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.scene) + g.a.a.b.b.a.r(7, this.hFK) + g.a.a.b.b.a.fS(8) + 1;
            if (this.object_nonce_id != null) {
                bu += g.a.a.b.b.a.f(9, this.object_nonce_id);
            }
            if (this.LDy != null) {
                bu += g.a.a.a.nh(10, this.LDy.computeSize());
            }
            AppMethodBeat.o(209421);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209421);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            asr asr = (asr) objArr[1];
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
                        asr.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209421);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        asr.LAI = aov;
                    }
                    AppMethodBeat.o(209421);
                    return 0;
                case 3:
                    asr.LDx = aVar3.UbS.hPo();
                    AppMethodBeat.o(209421);
                    return 0;
                case 4:
                    asr.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209421);
                    return 0;
                case 5:
                    asr.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(209421);
                    return 0;
                case 6:
                    asr.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209421);
                    return 0;
                case 7:
                    asr.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209421);
                    return 0;
                case 8:
                    asr.AqQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(209421);
                    return 0;
                case 9:
                    asr.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209421);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        avk avk = new avk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = avk.populateBuilderWithField(aVar6, avk, dop.getNextFieldNumber(aVar6))) {
                        }
                        asr.LDy = avk;
                    }
                    AppMethodBeat.o(209421);
                    return 0;
                default:
                    AppMethodBeat.o(209421);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209421);
            return -1;
        }
    }
}
