package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class esw extends dop {
    public int KMd;
    public long Lta;
    public long MKf;
    public int MKg;
    public long NeG;
    public String Nqu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125494);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MKg);
            aVar.bb(3, this.NeG);
            aVar.bb(4, this.Lta);
            if (this.Nqu != null) {
                aVar.e(5, this.Nqu);
            }
            aVar.bb(6, this.MKf);
            aVar.aM(7, this.KMd);
            AppMethodBeat.o(125494);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MKg) + g.a.a.b.b.a.r(3, this.NeG) + g.a.a.b.b.a.r(4, this.Lta);
            if (this.Nqu != null) {
                nh += g.a.a.b.b.a.f(5, this.Nqu);
            }
            int r = nh + g.a.a.b.b.a.r(6, this.MKf) + g.a.a.b.b.a.bu(7, this.KMd);
            AppMethodBeat.o(125494);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125494);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            esw esw = (esw) objArr[1];
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
                        esw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125494);
                    return 0;
                case 2:
                    esw.MKg = aVar3.UbS.zi();
                    AppMethodBeat.o(125494);
                    return 0;
                case 3:
                    esw.NeG = aVar3.UbS.zl();
                    AppMethodBeat.o(125494);
                    return 0;
                case 4:
                    esw.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(125494);
                    return 0;
                case 5:
                    esw.Nqu = aVar3.UbS.readString();
                    AppMethodBeat.o(125494);
                    return 0;
                case 6:
                    esw.MKf = aVar3.UbS.zl();
                    AppMethodBeat.o(125494);
                    return 0;
                case 7:
                    esw.KMd = aVar3.UbS.zi();
                    AppMethodBeat.o(125494);
                    return 0;
                default:
                    AppMethodBeat.o(125494);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125494);
            return -1;
        }
    }
}
