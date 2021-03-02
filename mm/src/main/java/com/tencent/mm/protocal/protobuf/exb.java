package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class exb extends a {
    public String Nuw;
    public String Nux;
    public exn Nuy;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200235);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nuw != null) {
                aVar.e(1, this.Nuw);
            }
            if (this.Nux != null) {
                aVar.e(2, this.Nux);
            }
            if (this.Nuy != null) {
                aVar.ni(3, this.Nuy.computeSize());
                this.Nuy.writeFields(aVar);
            }
            aVar.aM(4, this.type);
            AppMethodBeat.o(200235);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Nuw != null ? g.a.a.b.b.a.f(1, this.Nuw) + 0 : 0;
            if (this.Nux != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nux);
            }
            if (this.Nuy != null) {
                f2 += g.a.a.a.nh(3, this.Nuy.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.type);
            AppMethodBeat.o(200235);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200235);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            exb exb = (exb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    exb.Nuw = aVar3.UbS.readString();
                    AppMethodBeat.o(200235);
                    return 0;
                case 2:
                    exb.Nux = aVar3.UbS.readString();
                    AppMethodBeat.o(200235);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        exn exn = new exn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = exn.populateBuilderWithField(aVar4, exn, a.getNextFieldNumber(aVar4))) {
                        }
                        exb.Nuy = exn;
                    }
                    AppMethodBeat.o(200235);
                    return 0;
                case 4:
                    exb.type = aVar3.UbS.zi();
                    AppMethodBeat.o(200235);
                    return 0;
                default:
                    AppMethodBeat.o(200235);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200235);
            return -1;
        }
    }
}
