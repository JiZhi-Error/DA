package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.LinkedList;

public final class anb extends a {
    public amt IXu;
    public amv KBr;
    public boolean Lvh = false;
    public boolean Lvi = false;
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
    public bcj Lxk;
    public boolean Lxl = false;
    public anh Lya;
    public boolean Lyb = false;
    public boolean Lyc = false;
    public boolean Lyd = false;
    public String desc;
    public LinkedList<aml> ppH = new LinkedList<>();
    public String remark;
    public long rnM;
    public String title;
    public int version;

    public anb() {
        AppMethodBeat.i(127473);
        AppMethodBeat.o(127473);
    }

    public final anb a(anh anh) {
        this.Lya = anh;
        this.Lyb = true;
        return this;
    }

    public final anh gui() {
        return this.Lya;
    }

    public final anb bH(LinkedList<aml> linkedList) {
        this.ppH = linkedList;
        this.Lyc = true;
        return this;
    }

    public final LinkedList<aml> byK() {
        return this.ppH;
    }

    public final anb d(ams ams) {
        this.LwQ = ams;
        this.LwR = true;
        return this;
    }

    public final anb b(anq anq) {
        this.LwS = anq;
        this.LwT = true;
        return this;
    }

    public final anb bhc(String str) {
        this.remark = str;
        this.LwY = true;
        return this;
    }

    public final anb bhd(String str) {
        this.title = str;
        this.Lvh = true;
        return this;
    }

    public final String getTitle() {
        return this.title;
    }

    public final anb bhe(String str) {
        this.desc = str;
        this.Lvi = true;
        return this;
    }

    public final anb My(long j2) {
        this.LwZ = j2;
        this.Lxa = true;
        return this;
    }

    public final anb ajk(int i2) {
        this.Lxb = i2;
        this.Lxc = true;
        return this;
    }

    public final anb b(ana ana) {
        this.LwU = ana;
        this.LwV = true;
        return this;
    }

    public final anb Mz(long j2) {
        this.rnM = j2;
        this.Lxd = true;
        return this;
    }

    public final anb b(ank ank) {
        this.LwW = ank;
        this.LwX = true;
        return this;
    }

    public final anb ajl(int i2) {
        this.version = i2;
        this.Lyd = true;
        return this;
    }

    public final anb a(amv amv) {
        this.KBr = amv;
        this.Lxe = true;
        return this;
    }

    public final amv guj() {
        return this.KBr;
    }

    public final anb c(amj amj) {
        this.Lxf = amj;
        this.Lxg = true;
        return this;
    }

    public final anb f(amt amt) {
        this.IXu = amt;
        this.Lxh = true;
        return this;
    }

    public final anb d(bcj bcj) {
        this.Lxk = bcj;
        this.Lxl = true;
        return this;
    }

    public final bcj guk() {
        return this.Lxk;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127474);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lya != null) {
                aVar.ni(1, this.Lya.computeSize());
                this.Lya.writeFields(aVar);
            }
            aVar.e(2, 8, this.ppH);
            if (this.LwQ != null) {
                aVar.ni(3, this.LwQ.computeSize());
                this.LwQ.writeFields(aVar);
            }
            if (this.LwS != null) {
                aVar.ni(4, this.LwS.computeSize());
                this.LwS.writeFields(aVar);
            }
            if (this.remark != null) {
                aVar.e(5, this.remark);
            }
            if (this.title != null) {
                aVar.e(6, this.title);
            }
            if (this.desc != null) {
                aVar.e(7, this.desc);
            }
            if (this.Lxa) {
                aVar.bb(8, this.LwZ);
            }
            if (this.Lxc) {
                aVar.aM(91, this.Lxb);
            }
            if (this.LwU != null) {
                aVar.ni(10, this.LwU.computeSize());
                this.LwU.writeFields(aVar);
            }
            if (this.Lxd) {
                aVar.bb(11, this.rnM);
            }
            if (this.LwW != null) {
                aVar.ni(12, this.LwW.computeSize());
                this.LwW.writeFields(aVar);
            }
            if (this.Lyd) {
                aVar.aM(13, this.version);
            }
            if (this.KBr != null) {
                aVar.ni(14, this.KBr.computeSize());
                this.KBr.writeFields(aVar);
            }
            if (this.Lxf != null) {
                aVar.ni(15, this.Lxf.computeSize());
                this.Lxf.writeFields(aVar);
            }
            if (this.IXu != null) {
                aVar.ni(16, this.IXu.computeSize());
                this.IXu.writeFields(aVar);
            }
            if (this.Lxk != null) {
                aVar.ni(17, this.Lxk.computeSize());
                this.Lxk.writeFields(aVar);
            }
            AppMethodBeat.o(127474);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Lya != null ? g.a.a.a.nh(1, this.Lya.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.ppH);
            if (this.LwQ != null) {
                nh += g.a.a.a.nh(3, this.LwQ.computeSize());
            }
            if (this.LwS != null) {
                nh += g.a.a.a.nh(4, this.LwS.computeSize());
            }
            if (this.remark != null) {
                nh += g.a.a.b.b.a.f(5, this.remark);
            }
            if (this.title != null) {
                nh += g.a.a.b.b.a.f(6, this.title);
            }
            if (this.desc != null) {
                nh += g.a.a.b.b.a.f(7, this.desc);
            }
            if (this.Lxa) {
                nh += g.a.a.b.b.a.r(8, this.LwZ);
            }
            if (this.Lxc) {
                nh += g.a.a.b.b.a.bu(91, this.Lxb);
            }
            if (this.LwU != null) {
                nh += g.a.a.a.nh(10, this.LwU.computeSize());
            }
            if (this.Lxd) {
                nh += g.a.a.b.b.a.r(11, this.rnM);
            }
            if (this.LwW != null) {
                nh += g.a.a.a.nh(12, this.LwW.computeSize());
            }
            if (this.Lyd) {
                nh += g.a.a.b.b.a.bu(13, this.version);
            }
            if (this.KBr != null) {
                nh += g.a.a.a.nh(14, this.KBr.computeSize());
            }
            if (this.Lxf != null) {
                nh += g.a.a.a.nh(15, this.Lxf.computeSize());
            }
            if (this.IXu != null) {
                nh += g.a.a.a.nh(16, this.IXu.computeSize());
            }
            if (this.Lxk != null) {
                nh += g.a.a.a.nh(17, this.Lxk.computeSize());
            }
            AppMethodBeat.o(127474);
            return nh;
        } else if (i2 == 2) {
            this.ppH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127474);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anb anb = (anb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        anh anh = new anh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = anh.populateBuilderWithField(aVar4, anh, a.getNextFieldNumber(aVar4))) {
                        }
                        anb.Lya = anh;
                    }
                    anb.Lyb = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aml aml = new aml();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aml.populateBuilderWithField(aVar5, aml, a.getNextFieldNumber(aVar5))) {
                        }
                        anb.ppH.add(aml);
                    }
                    anb.Lyc = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ams ams = new ams();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ams.populateBuilderWithField(aVar6, ams, a.getNextFieldNumber(aVar6))) {
                        }
                        anb.LwQ = ams;
                    }
                    anb.LwR = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        anq anq = new anq();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = anq.populateBuilderWithField(aVar7, anq, a.getNextFieldNumber(aVar7))) {
                        }
                        anb.LwS = anq;
                    }
                    anb.LwT = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 5:
                    anb.remark = aVar3.UbS.readString();
                    anb.LwY = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 6:
                    anb.title = aVar3.UbS.readString();
                    anb.Lvh = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 7:
                    anb.desc = aVar3.UbS.readString();
                    anb.Lvi = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 8:
                    anb.LwZ = aVar3.UbS.zl();
                    anb.Lxa = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ana ana = new ana();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ana.populateBuilderWithField(aVar8, ana, a.getNextFieldNumber(aVar8))) {
                        }
                        anb.LwU = ana;
                    }
                    anb.LwV = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 11:
                    anb.rnM = aVar3.UbS.zl();
                    anb.Lxd = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ank ank = new ank();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = ank.populateBuilderWithField(aVar9, ank, a.getNextFieldNumber(aVar9))) {
                        }
                        anb.LwW = ank;
                    }
                    anb.LwX = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 13:
                    anb.version = aVar3.UbS.zi();
                    anb.Lyd = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        amv amv = new amv();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = amv.populateBuilderWithField(aVar10, amv, a.getNextFieldNumber(aVar10))) {
                        }
                        anb.KBr = amv;
                    }
                    anb.Lxe = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        amj amj = new amj();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = amj.populateBuilderWithField(aVar11, amj, a.getNextFieldNumber(aVar11))) {
                        }
                        anb.Lxf = amj;
                    }
                    anb.Lxg = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        amt amt = new amt();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = amt.populateBuilderWithField(aVar12, amt, a.getNextFieldNumber(aVar12))) {
                        }
                        anb.IXu = amt;
                    }
                    anb.Lxh = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        bcj bcj = new bcj();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = bcj.populateBuilderWithField(aVar13, bcj, a.getNextFieldNumber(aVar13))) {
                        }
                        anb.Lxk = bcj;
                    }
                    anb.Lxl = true;
                    AppMethodBeat.o(127474);
                    return 0;
                case PlayerException.EXCEPTION_IN_PREPARE /*{ENCODED_INT: 91}*/:
                    anb.Lxb = aVar3.UbS.zi();
                    anb.Lxc = true;
                    AppMethodBeat.o(127474);
                    return 0;
                default:
                    AppMethodBeat.o(127474);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127474);
            return -1;
        }
    }
}
