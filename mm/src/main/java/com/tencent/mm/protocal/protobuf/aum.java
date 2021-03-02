package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aum extends dop {
    public String LAt;
    public aov LBM;
    public b LFp;
    public int LFq;
    public String LFr;
    public long count;
    public int dYx;
    public long hyH;
    public long object_id;
    public String object_nonce_id;
    public int scene;
    public long seq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209479);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LBM != null) {
                aVar.ni(2, this.LBM.computeSize());
                this.LBM.writeFields(aVar);
            }
            aVar.bb(3, this.hyH);
            aVar.bb(4, this.count);
            if (this.LFp != null) {
                aVar.c(5, this.LFp);
            }
            aVar.bb(6, this.object_id);
            aVar.bb(7, this.seq);
            aVar.aM(8, this.LFq);
            if (this.LFr != null) {
                aVar.e(9, this.LFr);
            }
            aVar.aM(10, this.scene);
            aVar.aM(11, this.dYx);
            if (this.object_nonce_id != null) {
                aVar.e(12, this.object_nonce_id);
            }
            if (this.LAt != null) {
                aVar.e(13, this.LAt);
            }
            AppMethodBeat.o(209479);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(3, this.hyH) + g.a.a.b.b.a.r(4, this.count);
            if (this.LFp != null) {
                r += g.a.a.b.b.a.b(5, this.LFp);
            }
            int r2 = r + g.a.a.b.b.a.r(6, this.object_id) + g.a.a.b.b.a.r(7, this.seq) + g.a.a.b.b.a.bu(8, this.LFq);
            if (this.LFr != null) {
                r2 += g.a.a.b.b.a.f(9, this.LFr);
            }
            int bu = r2 + g.a.a.b.b.a.bu(10, this.scene) + g.a.a.b.b.a.bu(11, this.dYx);
            if (this.object_nonce_id != null) {
                bu += g.a.a.b.b.a.f(12, this.object_nonce_id);
            }
            if (this.LAt != null) {
                bu += g.a.a.b.b.a.f(13, this.LAt);
            }
            AppMethodBeat.o(209479);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209479);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aum aum = (aum) objArr[1];
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
                        aum.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209479);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        aum.LBM = aov;
                    }
                    AppMethodBeat.o(209479);
                    return 0;
                case 3:
                    aum.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(209479);
                    return 0;
                case 4:
                    aum.count = aVar3.UbS.zl();
                    AppMethodBeat.o(209479);
                    return 0;
                case 5:
                    aum.LFp = aVar3.UbS.hPo();
                    AppMethodBeat.o(209479);
                    return 0;
                case 6:
                    aum.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(209479);
                    return 0;
                case 7:
                    aum.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(209479);
                    return 0;
                case 8:
                    aum.LFq = aVar3.UbS.zi();
                    AppMethodBeat.o(209479);
                    return 0;
                case 9:
                    aum.LFr = aVar3.UbS.readString();
                    AppMethodBeat.o(209479);
                    return 0;
                case 10:
                    aum.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209479);
                    return 0;
                case 11:
                    aum.dYx = aVar3.UbS.zi();
                    AppMethodBeat.o(209479);
                    return 0;
                case 12:
                    aum.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209479);
                    return 0;
                case 13:
                    aum.LAt = aVar3.UbS.readString();
                    AppMethodBeat.o(209479);
                    return 0;
                default:
                    AppMethodBeat.o(209479);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209479);
            return -1;
        }
    }
}
