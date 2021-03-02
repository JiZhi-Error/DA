package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dck extends a {
    public LinkedList<dcx> MHA = new LinkedList<>();
    public dcd MHl;
    public dcn MHm;
    public dcr MHn;
    public LinkedList<dco> MHo = new LinkedList<>();
    public LinkedList<dcj> MHp = new LinkedList<>();
    public LinkedList<dch> MHq = new LinkedList<>();
    public dcu MHr;
    public dce MHs;
    public dct MHt;
    public dcy MHu;
    public dcc MHv;
    public LinkedList<dcw> MHw = new LinkedList<>();
    public dco MHx;
    public LinkedList<dcs> MHy = new LinkedList<>();
    public dcq MHz;

    public dck() {
        AppMethodBeat.i(209785);
        AppMethodBeat.o(209785);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209786);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MHl != null) {
                aVar.ni(1, this.MHl.computeSize());
                this.MHl.writeFields(aVar);
            }
            if (this.MHm != null) {
                aVar.ni(2, this.MHm.computeSize());
                this.MHm.writeFields(aVar);
            }
            if (this.MHn != null) {
                aVar.ni(3, this.MHn.computeSize());
                this.MHn.writeFields(aVar);
            }
            aVar.e(4, 8, this.MHo);
            aVar.e(5, 8, this.MHp);
            aVar.e(6, 8, this.MHq);
            if (this.MHr != null) {
                aVar.ni(7, this.MHr.computeSize());
                this.MHr.writeFields(aVar);
            }
            if (this.MHs != null) {
                aVar.ni(8, this.MHs.computeSize());
                this.MHs.writeFields(aVar);
            }
            if (this.MHt != null) {
                aVar.ni(9, this.MHt.computeSize());
                this.MHt.writeFields(aVar);
            }
            if (this.MHu != null) {
                aVar.ni(10, this.MHu.computeSize());
                this.MHu.writeFields(aVar);
            }
            if (this.MHv != null) {
                aVar.ni(11, this.MHv.computeSize());
                this.MHv.writeFields(aVar);
            }
            aVar.e(12, 8, this.MHw);
            if (this.MHx != null) {
                aVar.ni(13, this.MHx.computeSize());
                this.MHx.writeFields(aVar);
            }
            aVar.e(14, 8, this.MHy);
            if (this.MHz != null) {
                aVar.ni(15, this.MHz.computeSize());
                this.MHz.writeFields(aVar);
            }
            aVar.e(16, 8, this.MHA);
            AppMethodBeat.o(209786);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MHl != null ? g.a.a.a.nh(1, this.MHl.computeSize()) + 0 : 0;
            if (this.MHm != null) {
                nh += g.a.a.a.nh(2, this.MHm.computeSize());
            }
            if (this.MHn != null) {
                nh += g.a.a.a.nh(3, this.MHn.computeSize());
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.MHo) + g.a.a.a.c(5, 8, this.MHp) + g.a.a.a.c(6, 8, this.MHq);
            if (this.MHr != null) {
                c2 += g.a.a.a.nh(7, this.MHr.computeSize());
            }
            if (this.MHs != null) {
                c2 += g.a.a.a.nh(8, this.MHs.computeSize());
            }
            if (this.MHt != null) {
                c2 += g.a.a.a.nh(9, this.MHt.computeSize());
            }
            if (this.MHu != null) {
                c2 += g.a.a.a.nh(10, this.MHu.computeSize());
            }
            if (this.MHv != null) {
                c2 += g.a.a.a.nh(11, this.MHv.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(12, 8, this.MHw);
            if (this.MHx != null) {
                c3 += g.a.a.a.nh(13, this.MHx.computeSize());
            }
            int c4 = c3 + g.a.a.a.c(14, 8, this.MHy);
            if (this.MHz != null) {
                c4 += g.a.a.a.nh(15, this.MHz.computeSize());
            }
            int c5 = c4 + g.a.a.a.c(16, 8, this.MHA);
            AppMethodBeat.o(209786);
            return c5;
        } else if (i2 == 2) {
            this.MHo.clear();
            this.MHp.clear();
            this.MHq.clear();
            this.MHw.clear();
            this.MHy.clear();
            this.MHA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209786);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dck dck = (dck) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dcd dcd = new dcd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dcd.populateBuilderWithField(aVar4, dcd, a.getNextFieldNumber(aVar4))) {
                        }
                        dck.MHl = dcd;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dcn dcn = new dcn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dcn.populateBuilderWithField(aVar5, dcn, a.getNextFieldNumber(aVar5))) {
                        }
                        dck.MHm = dcn;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dcr dcr = new dcr();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dcr.populateBuilderWithField(aVar6, dcr, a.getNextFieldNumber(aVar6))) {
                        }
                        dck.MHn = dcr;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dco dco = new dco();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dco.populateBuilderWithField(aVar7, dco, a.getNextFieldNumber(aVar7))) {
                        }
                        dck.MHo.add(dco);
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dcj dcj = new dcj();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dcj.populateBuilderWithField(aVar8, dcj, a.getNextFieldNumber(aVar8))) {
                        }
                        dck.MHp.add(dcj);
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dch dch = new dch();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dch.populateBuilderWithField(aVar9, dch, a.getNextFieldNumber(aVar9))) {
                        }
                        dck.MHq.add(dch);
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dcu dcu = new dcu();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dcu.populateBuilderWithField(aVar10, dcu, a.getNextFieldNumber(aVar10))) {
                        }
                        dck.MHr = dcu;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dce dce = new dce();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dce.populateBuilderWithField(aVar11, dce, a.getNextFieldNumber(aVar11))) {
                        }
                        dck.MHs = dce;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        dct dct = new dct();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = dct.populateBuilderWithField(aVar12, dct, a.getNextFieldNumber(aVar12))) {
                        }
                        dck.MHt = dct;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        dcy dcy = new dcy();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = dcy.populateBuilderWithField(aVar13, dcy, a.getNextFieldNumber(aVar13))) {
                        }
                        dck.MHu = dcy;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        dcc dcc = new dcc();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = dcc.populateBuilderWithField(aVar14, dcc, a.getNextFieldNumber(aVar14))) {
                        }
                        dck.MHv = dcc;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        dcw dcw = new dcw();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = dcw.populateBuilderWithField(aVar15, dcw, a.getNextFieldNumber(aVar15))) {
                        }
                        dck.MHw.add(dcw);
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        dco dco2 = new dco();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = dco2.populateBuilderWithField(aVar16, dco2, a.getNextFieldNumber(aVar16))) {
                        }
                        dck.MHx = dco2;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        dcs dcs = new dcs();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = dcs.populateBuilderWithField(aVar17, dcs, a.getNextFieldNumber(aVar17))) {
                        }
                        dck.MHy.add(dcs);
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh15 = aVar3.awh(intValue);
                    int size15 = awh15.size();
                    for (int i17 = 0; i17 < size15; i17++) {
                        dcq dcq = new dcq();
                        g.a.a.a.a aVar18 = new g.a.a.a.a(awh15.get(i17), unknownTagHandler);
                        for (boolean z15 = true; z15; z15 = dcq.populateBuilderWithField(aVar18, dcq, a.getNextFieldNumber(aVar18))) {
                        }
                        dck.MHz = dcq;
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh16 = aVar3.awh(intValue);
                    int size16 = awh16.size();
                    for (int i18 = 0; i18 < size16; i18++) {
                        dcx dcx = new dcx();
                        g.a.a.a.a aVar19 = new g.a.a.a.a(awh16.get(i18), unknownTagHandler);
                        for (boolean z16 = true; z16; z16 = dcx.populateBuilderWithField(aVar19, dcx, a.getNextFieldNumber(aVar19))) {
                        }
                        dck.MHA.add(dcx);
                    }
                    AppMethodBeat.o(209786);
                    return 0;
                default:
                    AppMethodBeat.o(209786);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209786);
            return -1;
        }
    }
}
