package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bkl extends dop {
    public String KDf;
    public String KDg;
    public int KDh;
    public LinkedList<um> KDk = new LinkedList<>();
    public String LTz;
    public int eaQ;
    public String qGX;
    public String qGp;
    public String sign;

    public bkl() {
        AppMethodBeat.i(114012);
        AppMethodBeat.o(114012);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114013);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.KDk);
            aVar.aM(3, this.eaQ);
            if (this.qGX != null) {
                aVar.e(4, this.qGX);
            }
            if (this.qGp != null) {
                aVar.e(5, this.qGp);
            }
            if (this.sign != null) {
                aVar.e(6, this.sign);
            }
            if (this.KDf != null) {
                aVar.e(7, this.KDf);
            }
            if (this.KDg != null) {
                aVar.e(8, this.KDg);
            }
            if (this.LTz != null) {
                aVar.e(9, this.LTz);
            }
            aVar.aM(10, this.KDh);
            AppMethodBeat.o(114013);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KDk) + g.a.a.b.b.a.bu(3, this.eaQ);
            if (this.qGX != null) {
                nh += g.a.a.b.b.a.f(4, this.qGX);
            }
            if (this.qGp != null) {
                nh += g.a.a.b.b.a.f(5, this.qGp);
            }
            if (this.sign != null) {
                nh += g.a.a.b.b.a.f(6, this.sign);
            }
            if (this.KDf != null) {
                nh += g.a.a.b.b.a.f(7, this.KDf);
            }
            if (this.KDg != null) {
                nh += g.a.a.b.b.a.f(8, this.KDg);
            }
            if (this.LTz != null) {
                nh += g.a.a.b.b.a.f(9, this.LTz);
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.KDh);
            AppMethodBeat.o(114013);
            return bu;
        } else if (i2 == 2) {
            this.KDk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114013);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bkl bkl = (bkl) objArr[1];
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
                        bkl.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(114013);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        um umVar = new um();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = umVar.populateBuilderWithField(aVar5, umVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        bkl.KDk.add(umVar);
                    }
                    AppMethodBeat.o(114013);
                    return 0;
                case 3:
                    bkl.eaQ = aVar3.UbS.zi();
                    AppMethodBeat.o(114013);
                    return 0;
                case 4:
                    bkl.qGX = aVar3.UbS.readString();
                    AppMethodBeat.o(114013);
                    return 0;
                case 5:
                    bkl.qGp = aVar3.UbS.readString();
                    AppMethodBeat.o(114013);
                    return 0;
                case 6:
                    bkl.sign = aVar3.UbS.readString();
                    AppMethodBeat.o(114013);
                    return 0;
                case 7:
                    bkl.KDf = aVar3.UbS.readString();
                    AppMethodBeat.o(114013);
                    return 0;
                case 8:
                    bkl.KDg = aVar3.UbS.readString();
                    AppMethodBeat.o(114013);
                    return 0;
                case 9:
                    bkl.LTz = aVar3.UbS.readString();
                    AppMethodBeat.o(114013);
                    return 0;
                case 10:
                    bkl.KDh = aVar3.UbS.zi();
                    AppMethodBeat.o(114013);
                    return 0;
                default:
                    AppMethodBeat.o(114013);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114013);
            return -1;
        }
    }
}
