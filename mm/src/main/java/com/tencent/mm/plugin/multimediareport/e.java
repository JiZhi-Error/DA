package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class e extends dop {
    public int scene;
    public long timestamp;
    public LinkedList<a> zGV = new LinkedList<>();
    public long zGW;
    public d zGX;

    public e() {
        AppMethodBeat.i(194276);
        AppMethodBeat.o(194276);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194277);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.zGW);
            aVar.bb(3, this.timestamp);
            aVar.aM(4, this.scene);
            if (this.zGX != null) {
                aVar.ni(5, this.zGX.computeSize());
                this.zGX.writeFields(aVar);
            }
            aVar.e(6, 8, this.zGV);
            AppMethodBeat.o(194277);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.zGW) + g.a.a.b.b.a.r(3, this.timestamp) + g.a.a.b.b.a.bu(4, this.scene);
            if (this.zGX != null) {
                nh += g.a.a.a.nh(5, this.zGX.computeSize());
            }
            int c2 = nh + g.a.a.a.c(6, 8, this.zGV);
            AppMethodBeat.o(194277);
            return c2;
        } else if (i2 == 2) {
            this.zGV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194277);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
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
                        eVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(194277);
                    return 0;
                case 2:
                    eVar.zGW = aVar3.UbS.zl();
                    AppMethodBeat.o(194277);
                    return 0;
                case 3:
                    eVar.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(194277);
                    return 0;
                case 4:
                    eVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(194277);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        d dVar = new d();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dVar.populateBuilderWithField(aVar5, dVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        eVar.zGX = dVar;
                    }
                    AppMethodBeat.o(194277);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        a aVar6 = new a();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aVar6.populateBuilderWithField(aVar7, aVar6, dop.getNextFieldNumber(aVar7))) {
                        }
                        eVar.zGV.add(aVar6);
                    }
                    AppMethodBeat.o(194277);
                    return 0;
                default:
                    AppMethodBeat.o(194277);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194277);
            return -1;
        }
    }
}
