package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bsc extends dop {
    public String LZf;
    public int LZg;
    public LinkedList<dqi> LZh = new LinkedList<>();
    public int LZi;
    public String xNU;

    public bsc() {
        AppMethodBeat.i(91494);
        AppMethodBeat.o(91494);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91495);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LZf != null) {
                aVar.e(2, this.LZf);
            }
            aVar.aM(3, this.LZg);
            aVar.e(4, 8, this.LZh);
            if (this.xNU != null) {
                aVar.e(5, this.xNU);
            }
            aVar.aM(6, this.LZi);
            AppMethodBeat.o(91495);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LZf != null) {
                nh += g.a.a.b.b.a.f(2, this.LZf);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LZg) + g.a.a.a.c(4, 8, this.LZh);
            if (this.xNU != null) {
                bu += g.a.a.b.b.a.f(5, this.xNU);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.LZi);
            AppMethodBeat.o(91495);
            return bu2;
        } else if (i2 == 2) {
            this.LZh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91495);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bsc bsc = (bsc) objArr[1];
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
                        bsc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91495);
                    return 0;
                case 2:
                    bsc.LZf = aVar3.UbS.readString();
                    AppMethodBeat.o(91495);
                    return 0;
                case 3:
                    bsc.LZg = aVar3.UbS.zi();
                    AppMethodBeat.o(91495);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        bsc.LZh.add(dqi);
                    }
                    AppMethodBeat.o(91495);
                    return 0;
                case 5:
                    bsc.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(91495);
                    return 0;
                case 6:
                    bsc.LZi = aVar3.UbS.zi();
                    AppMethodBeat.o(91495);
                    return 0;
                default:
                    AppMethodBeat.o(91495);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91495);
            return -1;
        }
    }
}
