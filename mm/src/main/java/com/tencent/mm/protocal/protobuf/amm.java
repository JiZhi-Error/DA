package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class amm extends a {
    public amt IXu;
    public amv KBr;
    public boolean Lvh = false;
    public boolean Lvi = false;
    public amn LwO;
    public boolean LwP = false;
    public ams LwQ;
    public boolean LwR = false;
    public anq LwS;
    public boolean LwT = false;
    public ana LwU;
    public boolean LwV = false;
    public ank LwW;
    public boolean LwX = false;
    public boolean LwY = false;
    public long LwZ;
    public boolean Lxa = false;
    public int Lxb = -1;
    public boolean Lxc = false;
    public boolean Lxd = false;
    public boolean Lxe = false;
    public amj Lxf;
    public boolean Lxg = false;
    public boolean Lxh = false;
    public amt Lxi;
    public boolean Lxj = false;
    public bcj Lxk;
    public boolean Lxl = false;
    public axf Lxm;
    public boolean Lxn = false;
    public bci Lxo;
    public boolean Lxp = false;
    public bcf Lxq;
    public boolean Lxr = false;
    public css Lxs;
    public boolean Lxt = false;
    public bcl Lxu;
    public boolean Lxv = false;
    public String desc;
    public String remark;
    public long rnM;
    public String title;

    public final amm c(amn amn) {
        this.LwO = amn;
        this.LwP = true;
        return this;
    }

    public final amn guh() {
        return this.LwO;
    }

    public final amm c(ams ams) {
        this.LwQ = ams;
        this.LwR = true;
        return this;
    }

    public final amm a(anq anq) {
        this.LwS = anq;
        this.LwT = true;
        return this;
    }

    public final amm a(ana ana) {
        this.LwU = ana;
        this.LwV = true;
        return this;
    }

    public final amm a(ank ank) {
        this.LwW = ank;
        this.LwX = true;
        return this;
    }

    public final amm b(amj amj) {
        this.Lxf = amj;
        this.Lxg = true;
        return this;
    }

    public final amm d(amt amt) {
        this.IXu = amt;
        this.Lxh = true;
        return this;
    }

    public final amm e(amt amt) {
        this.Lxi = amt;
        this.Lxj = true;
        return this;
    }

    public final amm c(bcj bcj) {
        this.Lxk = bcj;
        this.Lxl = true;
        return this;
    }

    public final amm e(axf axf) {
        this.Lxm = axf;
        this.Lxn = true;
        return this;
    }

    public final amm a(bci bci) {
        this.Lxo = bci;
        this.Lxp = true;
        return this;
    }

    public final amm c(bcf bcf) {
        this.Lxq = bcf;
        this.Lxr = true;
        return this;
    }

    public final amm e(css css) {
        this.Lxs = css;
        this.Lxt = true;
        return this;
    }

    public final amm c(bcl bcl) {
        this.Lxu = bcl;
        this.Lxv = true;
        return this;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127458);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LwO != null) {
                aVar.ni(1, this.LwO.computeSize());
                this.LwO.writeFields(aVar);
            }
            if (this.LwQ != null) {
                aVar.ni(2, this.LwQ.computeSize());
                this.LwQ.writeFields(aVar);
            }
            if (this.LwS != null) {
                aVar.ni(3, this.LwS.computeSize());
                this.LwS.writeFields(aVar);
            }
            if (this.LwU != null) {
                aVar.ni(4, this.LwU.computeSize());
                this.LwU.writeFields(aVar);
            }
            if (this.LwW != null) {
                aVar.ni(5, this.LwW.computeSize());
                this.LwW.writeFields(aVar);
            }
            if (this.remark != null) {
                aVar.e(6, this.remark);
            }
            if (this.title != null) {
                aVar.e(7, this.title);
            }
            if (this.desc != null) {
                aVar.e(8, this.desc);
            }
            if (this.Lxa) {
                aVar.bb(9, this.LwZ);
            }
            if (this.Lxc) {
                aVar.aM(101, this.Lxb);
            }
            if (this.Lxd) {
                aVar.bb(11, this.rnM);
            }
            if (this.KBr != null) {
                aVar.ni(12, this.KBr.computeSize());
                this.KBr.writeFields(aVar);
            }
            if (this.Lxf != null) {
                aVar.ni(13, this.Lxf.computeSize());
                this.Lxf.writeFields(aVar);
            }
            if (this.IXu != null) {
                aVar.ni(14, this.IXu.computeSize());
                this.IXu.writeFields(aVar);
            }
            if (this.Lxi != null) {
                aVar.ni(15, this.Lxi.computeSize());
                this.Lxi.writeFields(aVar);
            }
            if (this.Lxk != null) {
                aVar.ni(16, this.Lxk.computeSize());
                this.Lxk.writeFields(aVar);
            }
            if (this.Lxm != null) {
                aVar.ni(17, this.Lxm.computeSize());
                this.Lxm.writeFields(aVar);
            }
            if (this.Lxo != null) {
                aVar.ni(18, this.Lxo.computeSize());
                this.Lxo.writeFields(aVar);
            }
            if (this.Lxq != null) {
                aVar.ni(19, this.Lxq.computeSize());
                this.Lxq.writeFields(aVar);
            }
            if (this.Lxs != null) {
                aVar.ni(20, this.Lxs.computeSize());
                this.Lxs.writeFields(aVar);
            }
            if (this.Lxu != null) {
                aVar.ni(21, this.Lxu.computeSize());
                this.Lxu.writeFields(aVar);
            }
            AppMethodBeat.o(127458);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LwO != null ? g.a.a.a.nh(1, this.LwO.computeSize()) + 0 : 0;
            if (this.LwQ != null) {
                nh += g.a.a.a.nh(2, this.LwQ.computeSize());
            }
            if (this.LwS != null) {
                nh += g.a.a.a.nh(3, this.LwS.computeSize());
            }
            if (this.LwU != null) {
                nh += g.a.a.a.nh(4, this.LwU.computeSize());
            }
            if (this.LwW != null) {
                nh += g.a.a.a.nh(5, this.LwW.computeSize());
            }
            if (this.remark != null) {
                nh += g.a.a.b.b.a.f(6, this.remark);
            }
            if (this.title != null) {
                nh += g.a.a.b.b.a.f(7, this.title);
            }
            if (this.desc != null) {
                nh += g.a.a.b.b.a.f(8, this.desc);
            }
            if (this.Lxa) {
                nh += g.a.a.b.b.a.r(9, this.LwZ);
            }
            if (this.Lxc) {
                nh += g.a.a.b.b.a.bu(101, this.Lxb);
            }
            if (this.Lxd) {
                nh += g.a.a.b.b.a.r(11, this.rnM);
            }
            if (this.KBr != null) {
                nh += g.a.a.a.nh(12, this.KBr.computeSize());
            }
            if (this.Lxf != null) {
                nh += g.a.a.a.nh(13, this.Lxf.computeSize());
            }
            if (this.IXu != null) {
                nh += g.a.a.a.nh(14, this.IXu.computeSize());
            }
            if (this.Lxi != null) {
                nh += g.a.a.a.nh(15, this.Lxi.computeSize());
            }
            if (this.Lxk != null) {
                nh += g.a.a.a.nh(16, this.Lxk.computeSize());
            }
            if (this.Lxm != null) {
                nh += g.a.a.a.nh(17, this.Lxm.computeSize());
            }
            if (this.Lxo != null) {
                nh += g.a.a.a.nh(18, this.Lxo.computeSize());
            }
            if (this.Lxq != null) {
                nh += g.a.a.a.nh(19, this.Lxq.computeSize());
            }
            if (this.Lxs != null) {
                nh += g.a.a.a.nh(20, this.Lxs.computeSize());
            }
            if (this.Lxu != null) {
                nh += g.a.a.a.nh(21, this.Lxu.computeSize());
            }
            AppMethodBeat.o(127458);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127458);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amm amm = (amm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        amn amn = new amn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = amn.populateBuilderWithField(aVar4, amn, a.getNextFieldNumber(aVar4))) {
                        }
                        amm.LwO = amn;
                    }
                    amm.LwP = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ams ams = new ams();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ams.populateBuilderWithField(aVar5, ams, a.getNextFieldNumber(aVar5))) {
                        }
                        amm.LwQ = ams;
                    }
                    amm.LwR = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        anq anq = new anq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = anq.populateBuilderWithField(aVar6, anq, a.getNextFieldNumber(aVar6))) {
                        }
                        amm.LwS = anq;
                    }
                    amm.LwT = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ana ana = new ana();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ana.populateBuilderWithField(aVar7, ana, a.getNextFieldNumber(aVar7))) {
                        }
                        amm.LwU = ana;
                    }
                    amm.LwV = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ank ank = new ank();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ank.populateBuilderWithField(aVar8, ank, a.getNextFieldNumber(aVar8))) {
                        }
                        amm.LwW = ank;
                    }
                    amm.LwX = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 6:
                    amm.remark = aVar3.UbS.readString();
                    amm.LwY = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 7:
                    amm.title = aVar3.UbS.readString();
                    amm.Lvh = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 8:
                    amm.desc = aVar3.UbS.readString();
                    amm.Lvi = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 9:
                    amm.LwZ = aVar3.UbS.zl();
                    amm.Lxa = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 11:
                    amm.rnM = aVar3.UbS.zl();
                    amm.Lxd = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        amv amv = new amv();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = amv.populateBuilderWithField(aVar9, amv, a.getNextFieldNumber(aVar9))) {
                        }
                        amm.KBr = amv;
                    }
                    amm.Lxe = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        amj amj = new amj();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = amj.populateBuilderWithField(aVar10, amj, a.getNextFieldNumber(aVar10))) {
                        }
                        amm.Lxf = amj;
                    }
                    amm.Lxg = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        amt amt = new amt();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = amt.populateBuilderWithField(aVar11, amt, a.getNextFieldNumber(aVar11))) {
                        }
                        amm.IXu = amt;
                    }
                    amm.Lxh = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        amt amt2 = new amt();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = amt2.populateBuilderWithField(aVar12, amt2, a.getNextFieldNumber(aVar12))) {
                        }
                        amm.Lxi = amt2;
                    }
                    amm.Lxj = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        bcj bcj = new bcj();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = bcj.populateBuilderWithField(aVar13, bcj, a.getNextFieldNumber(aVar13))) {
                        }
                        amm.Lxk = bcj;
                    }
                    amm.Lxl = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        axf axf = new axf();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = axf.populateBuilderWithField(aVar14, axf, a.getNextFieldNumber(aVar14))) {
                        }
                        amm.Lxm = axf;
                    }
                    amm.Lxn = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        bci bci = new bci();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = bci.populateBuilderWithField(aVar15, bci, a.getNextFieldNumber(aVar15))) {
                        }
                        amm.Lxo = bci;
                    }
                    amm.Lxp = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        bcf bcf = new bcf();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = bcf.populateBuilderWithField(aVar16, bcf, a.getNextFieldNumber(aVar16))) {
                        }
                        amm.Lxq = bcf;
                    }
                    amm.Lxr = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        css css = new css();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = css.populateBuilderWithField(aVar17, css, a.getNextFieldNumber(aVar17))) {
                        }
                        amm.Lxs = css;
                    }
                    amm.Lxt = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh15 = aVar3.awh(intValue);
                    int size15 = awh15.size();
                    for (int i17 = 0; i17 < size15; i17++) {
                        bcl bcl = new bcl();
                        g.a.a.a.a aVar18 = new g.a.a.a.a(awh15.get(i17), unknownTagHandler);
                        for (boolean z15 = true; z15; z15 = bcl.populateBuilderWithField(aVar18, bcl, a.getNextFieldNumber(aVar18))) {
                        }
                        amm.Lxu = bcl;
                    }
                    amm.Lxv = true;
                    AppMethodBeat.o(127458);
                    return 0;
                case 101:
                    amm.Lxb = aVar3.UbS.zi();
                    amm.Lxc = true;
                    AppMethodBeat.o(127458);
                    return 0;
                default:
                    AppMethodBeat.o(127458);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127458);
            return -1;
        }
    }
}
