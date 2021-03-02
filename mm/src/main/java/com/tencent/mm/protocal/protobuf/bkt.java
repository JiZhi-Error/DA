package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bkt extends dop {
    public String LTF;
    public double latitude;
    public double longitude;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114022);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, this.latitude);
            aVar.e(3, this.longitude);
            aVar.aM(4, this.scene);
            if (this.LTF != null) {
                aVar.e(5, this.LTF);
            }
            AppMethodBeat.o(114022);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 8 + g.a.a.b.b.a.fS(3) + 8 + g.a.a.b.b.a.bu(4, this.scene);
            if (this.LTF != null) {
                nh += g.a.a.b.b.a.f(5, this.LTF);
            }
            AppMethodBeat.o(114022);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114022);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bkt bkt = (bkt) objArr[1];
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
                        bkt.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(114022);
                    return 0;
                case 2:
                    bkt.latitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(114022);
                    return 0;
                case 3:
                    bkt.longitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(114022);
                    return 0;
                case 4:
                    bkt.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(114022);
                    return 0;
                case 5:
                    bkt.LTF = aVar3.UbS.readString();
                    AppMethodBeat.o(114022);
                    return 0;
                default:
                    AppMethodBeat.o(114022);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114022);
            return -1;
        }
    }
}
