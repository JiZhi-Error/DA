package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bas extends dop {
    public aov LCA;
    public String LKn;
    public String LKo;
    public String LKp;
    public long Vjy;
    public int scene;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209639);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LCA != null) {
                aVar.ni(2, this.LCA.computeSize());
                this.LCA.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(3, this.username);
            }
            if (this.LKn != null) {
                aVar.e(4, this.LKn);
            }
            if (this.LKo != null) {
                aVar.e(5, this.LKo);
            }
            if (this.LKp != null) {
                aVar.e(6, this.LKp);
            }
            aVar.bb(7, this.Vjy);
            aVar.aM(8, this.scene);
            AppMethodBeat.o(209639);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LCA != null) {
                nh += g.a.a.a.nh(2, this.LCA.computeSize());
            }
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(3, this.username);
            }
            if (this.LKn != null) {
                nh += g.a.a.b.b.a.f(4, this.LKn);
            }
            if (this.LKo != null) {
                nh += g.a.a.b.b.a.f(5, this.LKo);
            }
            if (this.LKp != null) {
                nh += g.a.a.b.b.a.f(6, this.LKp);
            }
            int r = nh + g.a.a.b.b.a.r(7, this.Vjy) + g.a.a.b.b.a.bu(8, this.scene);
            AppMethodBeat.o(209639);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209639);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bas bas = (bas) objArr[1];
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
                        bas.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209639);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        bas.LCA = aov;
                    }
                    AppMethodBeat.o(209639);
                    return 0;
                case 3:
                    bas.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209639);
                    return 0;
                case 4:
                    bas.LKn = aVar3.UbS.readString();
                    AppMethodBeat.o(209639);
                    return 0;
                case 5:
                    bas.LKo = aVar3.UbS.readString();
                    AppMethodBeat.o(209639);
                    return 0;
                case 6:
                    bas.LKp = aVar3.UbS.readString();
                    AppMethodBeat.o(209639);
                    return 0;
                case 7:
                    bas.Vjy = aVar3.UbS.zl();
                    AppMethodBeat.o(209639);
                    return 0;
                case 8:
                    bas.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209639);
                    return 0;
                default:
                    AppMethodBeat.o(209639);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209639);
            return -1;
        }
    }
}
