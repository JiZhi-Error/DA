package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class awy extends dop {
    public String LAt;
    public aov LBM;
    public b LFp;
    public String Lmn;
    public long hyH;
    public long object_id;
    public String object_nonce_id;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209551);
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
            if (this.LFp != null) {
                aVar.c(3, this.LFp);
            }
            aVar.bb(5, this.hyH);
            aVar.bb(6, this.object_id);
            if (this.object_nonce_id != null) {
                aVar.e(7, this.object_nonce_id);
            }
            aVar.aM(8, this.scene);
            if (this.LAt != null) {
                aVar.e(9, this.LAt);
            }
            if (this.Lmn != null) {
                aVar.e(10, this.Lmn);
            }
            AppMethodBeat.o(209551);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            if (this.LFp != null) {
                nh += g.a.a.b.b.a.b(3, this.LFp);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.hyH) + g.a.a.b.b.a.r(6, this.object_id);
            if (this.object_nonce_id != null) {
                r += g.a.a.b.b.a.f(7, this.object_nonce_id);
            }
            int bu = r + g.a.a.b.b.a.bu(8, this.scene);
            if (this.LAt != null) {
                bu += g.a.a.b.b.a.f(9, this.LAt);
            }
            if (this.Lmn != null) {
                bu += g.a.a.b.b.a.f(10, this.Lmn);
            }
            AppMethodBeat.o(209551);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209551);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awy awy = (awy) objArr[1];
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
                        awy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209551);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        awy.LBM = aov;
                    }
                    AppMethodBeat.o(209551);
                    return 0;
                case 3:
                    awy.LFp = aVar3.UbS.hPo();
                    AppMethodBeat.o(209551);
                    return 0;
                case 4:
                default:
                    AppMethodBeat.o(209551);
                    return -1;
                case 5:
                    awy.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(209551);
                    return 0;
                case 6:
                    awy.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(209551);
                    return 0;
                case 7:
                    awy.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209551);
                    return 0;
                case 8:
                    awy.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209551);
                    return 0;
                case 9:
                    awy.LAt = aVar3.UbS.readString();
                    AppMethodBeat.o(209551);
                    return 0;
                case 10:
                    awy.Lmn = aVar3.UbS.readString();
                    AppMethodBeat.o(209551);
                    return 0;
            }
        } else {
            AppMethodBeat.o(209551);
            return -1;
        }
    }
}
