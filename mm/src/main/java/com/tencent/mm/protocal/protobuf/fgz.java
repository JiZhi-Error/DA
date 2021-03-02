package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fgz extends dop {
    public aov LBM;
    public b LFp;
    public String ViT;
    public long hyH;
    public long object_id;
    public String object_nonce_id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259359);
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
            if (this.ViT != null) {
                aVar.e(4, this.ViT);
            }
            aVar.bb(5, this.object_id);
            aVar.bb(6, this.hyH);
            if (this.object_nonce_id != null) {
                aVar.e(7, this.object_nonce_id);
            }
            AppMethodBeat.o(259359);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            if (this.LFp != null) {
                nh += g.a.a.b.b.a.b(3, this.LFp);
            }
            if (this.ViT != null) {
                nh += g.a.a.b.b.a.f(4, this.ViT);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.object_id) + g.a.a.b.b.a.r(6, this.hyH);
            if (this.object_nonce_id != null) {
                r += g.a.a.b.b.a.f(7, this.object_nonce_id);
            }
            AppMethodBeat.o(259359);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259359);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgz fgz = (fgz) objArr[1];
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
                        fgz.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(259359);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        fgz.LBM = aov;
                    }
                    AppMethodBeat.o(259359);
                    return 0;
                case 3:
                    fgz.LFp = aVar3.UbS.hPo();
                    AppMethodBeat.o(259359);
                    return 0;
                case 4:
                    fgz.ViT = aVar3.UbS.readString();
                    AppMethodBeat.o(259359);
                    return 0;
                case 5:
                    fgz.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(259359);
                    return 0;
                case 6:
                    fgz.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(259359);
                    return 0;
                case 7:
                    fgz.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(259359);
                    return 0;
                default:
                    AppMethodBeat.o(259359);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259359);
            return -1;
        }
    }
}
