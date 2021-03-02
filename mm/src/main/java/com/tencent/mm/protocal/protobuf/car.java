package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class car extends a {
    public acn MfU;
    public float height;
    public String thumbUrl;
    public float width;
    public String xve;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209722);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.thumbUrl != null) {
                aVar.e(1, this.thumbUrl);
            }
            aVar.E(2, this.width);
            aVar.E(3, this.height);
            if (this.MfU != null) {
                aVar.ni(4, this.MfU.computeSize());
                this.MfU.writeFields(aVar);
            }
            if (this.xve != null) {
                aVar.e(5, this.xve);
            }
            AppMethodBeat.o(209722);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.thumbUrl != null ? g.a.a.b.b.a.f(1, this.thumbUrl) + 0 : 0) + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4;
            if (this.MfU != null) {
                f2 += g.a.a.a.nh(4, this.MfU.computeSize());
            }
            if (this.xve != null) {
                f2 += g.a.a.b.b.a.f(5, this.xve);
            }
            AppMethodBeat.o(209722);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209722);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            car car = (car) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    car.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209722);
                    return 0;
                case 2:
                    car.width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209722);
                    return 0;
                case 3:
                    car.height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209722);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        acn acn = new acn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = acn.populateBuilderWithField(aVar4, acn, a.getNextFieldNumber(aVar4))) {
                        }
                        car.MfU = acn;
                    }
                    AppMethodBeat.o(209722);
                    return 0;
                case 5:
                    car.xve = aVar3.UbS.readString();
                    AppMethodBeat.o(209722);
                    return 0;
                default:
                    AppMethodBeat.o(209722);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209722);
            return -1;
        }
    }
}
