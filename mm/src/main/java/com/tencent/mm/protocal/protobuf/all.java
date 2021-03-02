package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class all extends dop {
    public String Lun;
    public String Luo;
    public long Lup;
    public double Luq;
    public double Lur;
    public String fuJ;
    public String fuK;
    public String rCq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91452);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.rCq != null) {
                aVar.e(2, this.rCq);
            }
            if (this.fuK != null) {
                aVar.e(3, this.fuK);
            }
            if (this.fuJ != null) {
                aVar.e(4, this.fuJ);
            }
            if (this.Lun != null) {
                aVar.e(5, this.Lun);
            }
            if (this.Luo != null) {
                aVar.e(6, this.Luo);
            }
            aVar.bb(7, this.Lup);
            aVar.e(8, this.Luq);
            aVar.e(9, this.Lur);
            AppMethodBeat.o(91452);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.rCq != null) {
                nh += g.a.a.b.b.a.f(2, this.rCq);
            }
            if (this.fuK != null) {
                nh += g.a.a.b.b.a.f(3, this.fuK);
            }
            if (this.fuJ != null) {
                nh += g.a.a.b.b.a.f(4, this.fuJ);
            }
            if (this.Lun != null) {
                nh += g.a.a.b.b.a.f(5, this.Lun);
            }
            if (this.Luo != null) {
                nh += g.a.a.b.b.a.f(6, this.Luo);
            }
            int r = nh + g.a.a.b.b.a.r(7, this.Lup) + g.a.a.b.b.a.fS(8) + 8 + g.a.a.b.b.a.fS(9) + 8;
            AppMethodBeat.o(91452);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91452);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            all all = (all) objArr[1];
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
                        all.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91452);
                    return 0;
                case 2:
                    all.rCq = aVar3.UbS.readString();
                    AppMethodBeat.o(91452);
                    return 0;
                case 3:
                    all.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(91452);
                    return 0;
                case 4:
                    all.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91452);
                    return 0;
                case 5:
                    all.Lun = aVar3.UbS.readString();
                    AppMethodBeat.o(91452);
                    return 0;
                case 6:
                    all.Luo = aVar3.UbS.readString();
                    AppMethodBeat.o(91452);
                    return 0;
                case 7:
                    all.Lup = aVar3.UbS.zl();
                    AppMethodBeat.o(91452);
                    return 0;
                case 8:
                    all.Luq = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91452);
                    return 0;
                case 9:
                    all.Lur = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91452);
                    return 0;
                default:
                    AppMethodBeat.o(91452);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91452);
            return -1;
        }
    }
}
