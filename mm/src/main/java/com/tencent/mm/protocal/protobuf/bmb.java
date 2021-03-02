package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bmb extends dop {
    public czu LUV;
    public String LjH;
    public long LpD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72483);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LjH != null) {
                aVar.e(2, this.LjH);
            }
            aVar.bb(3, this.LpD);
            if (this.LUV != null) {
                aVar.ni(4, this.LUV.computeSize());
                this.LUV.writeFields(aVar);
            }
            AppMethodBeat.o(72483);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LjH != null) {
                nh += g.a.a.b.b.a.f(2, this.LjH);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.LpD);
            if (this.LUV != null) {
                r += g.a.a.a.nh(4, this.LUV.computeSize());
            }
            AppMethodBeat.o(72483);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72483);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmb bmb = (bmb) objArr[1];
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
                        bmb.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72483);
                    return 0;
                case 2:
                    bmb.LjH = aVar3.UbS.readString();
                    AppMethodBeat.o(72483);
                    return 0;
                case 3:
                    bmb.LpD = aVar3.UbS.zl();
                    AppMethodBeat.o(72483);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        czu czu = new czu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = czu.populateBuilderWithField(aVar5, czu, dop.getNextFieldNumber(aVar5))) {
                        }
                        bmb.LUV = czu;
                    }
                    AppMethodBeat.o(72483);
                    return 0;
                default:
                    AppMethodBeat.o(72483);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72483);
            return -1;
        }
    }
}
