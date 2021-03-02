package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ml extends dop {
    public String KQF;
    public String KQG;
    public long KQH;
    public String mac;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82394);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KQF != null) {
                aVar.e(2, this.KQF);
            }
            if (this.KQG != null) {
                aVar.e(3, this.KQG);
            }
            if (this.mac != null) {
                aVar.e(4, this.mac);
            }
            aVar.bb(5, this.KQH);
            AppMethodBeat.o(82394);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KQF != null) {
                nh += g.a.a.b.b.a.f(2, this.KQF);
            }
            if (this.KQG != null) {
                nh += g.a.a.b.b.a.f(3, this.KQG);
            }
            if (this.mac != null) {
                nh += g.a.a.b.b.a.f(4, this.mac);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.KQH);
            AppMethodBeat.o(82394);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82394);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ml mlVar = (ml) objArr[1];
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
                        mlVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82394);
                    return 0;
                case 2:
                    mlVar.KQF = aVar3.UbS.readString();
                    AppMethodBeat.o(82394);
                    return 0;
                case 3:
                    mlVar.KQG = aVar3.UbS.readString();
                    AppMethodBeat.o(82394);
                    return 0;
                case 4:
                    mlVar.mac = aVar3.UbS.readString();
                    AppMethodBeat.o(82394);
                    return 0;
                case 5:
                    mlVar.KQH = aVar3.UbS.zl();
                    AppMethodBeat.o(82394);
                    return 0;
                default:
                    AppMethodBeat.o(82394);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82394);
            return -1;
        }
    }
}
