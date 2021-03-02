package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fgo extends dop {
    public String LAt;
    public aov LBM;
    public b LFp;
    public LinkedList<String> ViY = new LinkedList<>();
    public long hyH;
    public long object_id;
    public String object_nonce_id;
    public int scene;

    public fgo() {
        AppMethodBeat.i(259347);
        AppMethodBeat.o(259347);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259348);
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
            aVar.bb(4, this.hyH);
            aVar.bb(5, this.object_id);
            if (this.object_nonce_id != null) {
                aVar.e(6, this.object_nonce_id);
            }
            aVar.aM(7, this.scene);
            if (this.LAt != null) {
                aVar.e(8, this.LAt);
            }
            aVar.e(9, 1, this.ViY);
            AppMethodBeat.o(259348);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            if (this.LFp != null) {
                nh += g.a.a.b.b.a.b(3, this.LFp);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.hyH) + g.a.a.b.b.a.r(5, this.object_id);
            if (this.object_nonce_id != null) {
                r += g.a.a.b.b.a.f(6, this.object_nonce_id);
            }
            int bu = r + g.a.a.b.b.a.bu(7, this.scene);
            if (this.LAt != null) {
                bu += g.a.a.b.b.a.f(8, this.LAt);
            }
            int c2 = bu + g.a.a.a.c(9, 1, this.ViY);
            AppMethodBeat.o(259348);
            return c2;
        } else if (i2 == 2) {
            this.ViY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259348);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgo fgo = (fgo) objArr[1];
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
                        fgo.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(259348);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        fgo.LBM = aov;
                    }
                    AppMethodBeat.o(259348);
                    return 0;
                case 3:
                    fgo.LFp = aVar3.UbS.hPo();
                    AppMethodBeat.o(259348);
                    return 0;
                case 4:
                    fgo.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(259348);
                    return 0;
                case 5:
                    fgo.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(259348);
                    return 0;
                case 6:
                    fgo.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(259348);
                    return 0;
                case 7:
                    fgo.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(259348);
                    return 0;
                case 8:
                    fgo.LAt = aVar3.UbS.readString();
                    AppMethodBeat.o(259348);
                    return 0;
                case 9:
                    fgo.ViY.add(aVar3.UbS.readString());
                    AppMethodBeat.o(259348);
                    return 0;
                default:
                    AppMethodBeat.o(259348);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259348);
            return -1;
        }
    }
}
