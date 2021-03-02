package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dje extends a {
    public String KFq;
    public String KFr;
    public String KFs;
    public String KFt;
    public String KFu;
    public String KFv;
    public ffi KFw;
    public String KRY;
    public String LRb;
    public String MNg;
    public int MNh;
    public LinkedList<dqi> MNi = new LinkedList<>();
    public String MNj;
    public String MNk;
    public String MNl;
    public String MNm;
    public String MNn;
    public String MNo;
    public String MNp;
    public int MNq;
    public int Myh;
    public String hik;
    public int xIN;
    public String xJM;
    public String xMq;

    public dje() {
        AppMethodBeat.i(152664);
        AppMethodBeat.o(152664);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152665);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hik != null) {
                aVar.e(1, this.hik);
            }
            if (this.xMq != null) {
                aVar.e(2, this.xMq);
            }
            if (this.KFs != null) {
                aVar.e(3, this.KFs);
            }
            if (this.LRb != null) {
                aVar.e(4, this.LRb);
            }
            if (this.KFr != null) {
                aVar.e(5, this.KFr);
            }
            if (this.KFq != null) {
                aVar.e(6, this.KFq);
            }
            if (this.MNg != null) {
                aVar.e(7, this.MNg);
            }
            aVar.aM(8, this.MNh);
            aVar.e(9, 8, this.MNi);
            if (this.KFt != null) {
                aVar.e(10, this.KFt);
            }
            if (this.MNj != null) {
                aVar.e(11, this.MNj);
            }
            if (this.MNk != null) {
                aVar.e(12, this.MNk);
            }
            aVar.aM(13, this.Myh);
            if (this.KRY != null) {
                aVar.e(14, this.KRY);
            }
            if (this.xJM != null) {
                aVar.e(15, this.xJM);
            }
            if (this.KFu != null) {
                aVar.e(16, this.KFu);
            }
            if (this.MNl != null) {
                aVar.e(17, this.MNl);
            }
            if (this.MNm != null) {
                aVar.e(18, this.MNm);
            }
            if (this.KFv != null) {
                aVar.e(19, this.KFv);
            }
            if (this.MNn != null) {
                aVar.e(20, this.MNn);
            }
            if (this.MNo != null) {
                aVar.e(21, this.MNo);
            }
            if (this.KFw != null) {
                aVar.ni(22, this.KFw.computeSize());
                this.KFw.writeFields(aVar);
            }
            if (this.MNp != null) {
                aVar.e(23, this.MNp);
            }
            aVar.aM(24, this.MNq);
            aVar.aM(25, this.xIN);
            AppMethodBeat.o(152665);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.hik != null ? g.a.a.b.b.a.f(1, this.hik) + 0 : 0;
            if (this.xMq != null) {
                f2 += g.a.a.b.b.a.f(2, this.xMq);
            }
            if (this.KFs != null) {
                f2 += g.a.a.b.b.a.f(3, this.KFs);
            }
            if (this.LRb != null) {
                f2 += g.a.a.b.b.a.f(4, this.LRb);
            }
            if (this.KFr != null) {
                f2 += g.a.a.b.b.a.f(5, this.KFr);
            }
            if (this.KFq != null) {
                f2 += g.a.a.b.b.a.f(6, this.KFq);
            }
            if (this.MNg != null) {
                f2 += g.a.a.b.b.a.f(7, this.MNg);
            }
            int bu = f2 + g.a.a.b.b.a.bu(8, this.MNh) + g.a.a.a.c(9, 8, this.MNi);
            if (this.KFt != null) {
                bu += g.a.a.b.b.a.f(10, this.KFt);
            }
            if (this.MNj != null) {
                bu += g.a.a.b.b.a.f(11, this.MNj);
            }
            if (this.MNk != null) {
                bu += g.a.a.b.b.a.f(12, this.MNk);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(13, this.Myh);
            if (this.KRY != null) {
                bu2 += g.a.a.b.b.a.f(14, this.KRY);
            }
            if (this.xJM != null) {
                bu2 += g.a.a.b.b.a.f(15, this.xJM);
            }
            if (this.KFu != null) {
                bu2 += g.a.a.b.b.a.f(16, this.KFu);
            }
            if (this.MNl != null) {
                bu2 += g.a.a.b.b.a.f(17, this.MNl);
            }
            if (this.MNm != null) {
                bu2 += g.a.a.b.b.a.f(18, this.MNm);
            }
            if (this.KFv != null) {
                bu2 += g.a.a.b.b.a.f(19, this.KFv);
            }
            if (this.MNn != null) {
                bu2 += g.a.a.b.b.a.f(20, this.MNn);
            }
            if (this.MNo != null) {
                bu2 += g.a.a.b.b.a.f(21, this.MNo);
            }
            if (this.KFw != null) {
                bu2 += g.a.a.a.nh(22, this.KFw.computeSize());
            }
            if (this.MNp != null) {
                bu2 += g.a.a.b.b.a.f(23, this.MNp);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(24, this.MNq) + g.a.a.b.b.a.bu(25, this.xIN);
            AppMethodBeat.o(152665);
            return bu3;
        } else if (i2 == 2) {
            this.MNi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152665);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dje dje = (dje) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dje.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 2:
                    dje.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 3:
                    dje.KFs = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 4:
                    dje.LRb = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 5:
                    dje.KFr = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 6:
                    dje.KFq = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 7:
                    dje.MNg = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 8:
                    dje.MNh = aVar3.UbS.zi();
                    AppMethodBeat.o(152665);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        dje.MNi.add(dqi);
                    }
                    AppMethodBeat.o(152665);
                    return 0;
                case 10:
                    dje.KFt = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 11:
                    dje.MNj = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 12:
                    dje.MNk = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 13:
                    dje.Myh = aVar3.UbS.zi();
                    AppMethodBeat.o(152665);
                    return 0;
                case 14:
                    dje.KRY = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 15:
                    dje.xJM = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 16:
                    dje.KFu = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 17:
                    dje.MNl = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 18:
                    dje.MNm = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 19:
                    dje.KFv = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 20:
                    dje.MNn = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 21:
                    dje.MNo = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ffi ffi = new ffi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ffi.populateBuilderWithField(aVar5, ffi, a.getNextFieldNumber(aVar5))) {
                        }
                        dje.KFw = ffi;
                    }
                    AppMethodBeat.o(152665);
                    return 0;
                case 23:
                    dje.MNp = aVar3.UbS.readString();
                    AppMethodBeat.o(152665);
                    return 0;
                case 24:
                    dje.MNq = aVar3.UbS.zi();
                    AppMethodBeat.o(152665);
                    return 0;
                case 25:
                    dje.xIN = aVar3.UbS.zi();
                    AppMethodBeat.o(152665);
                    return 0;
                default:
                    AppMethodBeat.o(152665);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152665);
            return -1;
        }
    }
}
