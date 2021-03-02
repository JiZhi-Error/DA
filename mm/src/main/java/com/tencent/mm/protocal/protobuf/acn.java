package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class acn extends a {
    public aco Gxw;
    public acm Gxx;
    public boolean Gzo;
    public boolean Gzp;
    public LinkedList<ejf> Lnd = new LinkedList<>();
    public long Lne;
    public long Lnf;
    public boolean Lng;
    public LinkedList<clz> Lnh = new LinkedList<>();
    public eqy Lni;
    public LinkedList<acp> Lnj = new LinkedList<>();
    public boolean Lnk;
    public LinkedList<ecy> Lnl = new LinkedList<>();
    public String editId;
    public String iiv;

    public acn() {
        AppMethodBeat.i(201288);
        AppMethodBeat.o(201288);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201289);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Lnd);
            aVar.bb(2, this.Lne);
            aVar.bb(3, this.Lnf);
            aVar.cc(4, this.Gzo);
            if (this.iiv != null) {
                aVar.e(5, this.iiv);
            }
            if (this.Gxw != null) {
                aVar.ni(6, this.Gxw.computeSize());
                this.Gxw.writeFields(aVar);
            }
            aVar.cc(7, this.Lng);
            if (this.Gxx != null) {
                aVar.ni(8, this.Gxx.computeSize());
                this.Gxx.writeFields(aVar);
            }
            aVar.e(9, 8, this.Lnh);
            if (this.Lni != null) {
                aVar.ni(10, this.Lni.computeSize());
                this.Lni.writeFields(aVar);
            }
            aVar.cc(11, this.Gzp);
            aVar.e(12, 8, this.Lnj);
            if (this.editId != null) {
                aVar.e(13, this.editId);
            }
            aVar.cc(14, this.Lnk);
            aVar.e(15, 8, this.Lnl);
            AppMethodBeat.o(201289);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Lnd) + 0 + g.a.a.b.b.a.r(2, this.Lne) + g.a.a.b.b.a.r(3, this.Lnf) + g.a.a.b.b.a.fS(4) + 1;
            if (this.iiv != null) {
                c2 += g.a.a.b.b.a.f(5, this.iiv);
            }
            if (this.Gxw != null) {
                c2 += g.a.a.a.nh(6, this.Gxw.computeSize());
            }
            int fS = c2 + g.a.a.b.b.a.fS(7) + 1;
            if (this.Gxx != null) {
                fS += g.a.a.a.nh(8, this.Gxx.computeSize());
            }
            int c3 = fS + g.a.a.a.c(9, 8, this.Lnh);
            if (this.Lni != null) {
                c3 += g.a.a.a.nh(10, this.Lni.computeSize());
            }
            int fS2 = c3 + g.a.a.b.b.a.fS(11) + 1 + g.a.a.a.c(12, 8, this.Lnj);
            if (this.editId != null) {
                fS2 += g.a.a.b.b.a.f(13, this.editId);
            }
            int fS3 = fS2 + g.a.a.b.b.a.fS(14) + 1 + g.a.a.a.c(15, 8, this.Lnl);
            AppMethodBeat.o(201289);
            return fS3;
        } else if (i2 == 2) {
            this.Lnd.clear();
            this.Lnh.clear();
            this.Lnj.clear();
            this.Lnl.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(201289);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acn acn = (acn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ejf ejf = new ejf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ejf.populateBuilderWithField(aVar4, ejf, a.getNextFieldNumber(aVar4))) {
                        }
                        acn.Lnd.add(ejf);
                    }
                    AppMethodBeat.o(201289);
                    return 0;
                case 2:
                    acn.Lne = aVar3.UbS.zl();
                    AppMethodBeat.o(201289);
                    return 0;
                case 3:
                    acn.Lnf = aVar3.UbS.zl();
                    AppMethodBeat.o(201289);
                    return 0;
                case 4:
                    acn.Gzo = aVar3.UbS.yZ();
                    AppMethodBeat.o(201289);
                    return 0;
                case 5:
                    acn.iiv = aVar3.UbS.readString();
                    AppMethodBeat.o(201289);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aco aco = new aco();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aco.populateBuilderWithField(aVar5, aco, a.getNextFieldNumber(aVar5))) {
                        }
                        acn.Gxw = aco;
                    }
                    AppMethodBeat.o(201289);
                    return 0;
                case 7:
                    acn.Lng = aVar3.UbS.yZ();
                    AppMethodBeat.o(201289);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        acm acm = new acm();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = acm.populateBuilderWithField(aVar6, acm, a.getNextFieldNumber(aVar6))) {
                        }
                        acn.Gxx = acm;
                    }
                    AppMethodBeat.o(201289);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        clz clz = new clz();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = clz.populateBuilderWithField(aVar7, clz, a.getNextFieldNumber(aVar7))) {
                        }
                        acn.Lnh.add(clz);
                    }
                    AppMethodBeat.o(201289);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        eqy eqy = new eqy();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eqy.populateBuilderWithField(aVar8, eqy, a.getNextFieldNumber(aVar8))) {
                        }
                        acn.Lni = eqy;
                    }
                    AppMethodBeat.o(201289);
                    return 0;
                case 11:
                    acn.Gzp = aVar3.UbS.yZ();
                    AppMethodBeat.o(201289);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        acp acp = new acp();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = acp.populateBuilderWithField(aVar9, acp, a.getNextFieldNumber(aVar9))) {
                        }
                        acn.Lnj.add(acp);
                    }
                    AppMethodBeat.o(201289);
                    return 0;
                case 13:
                    acn.editId = aVar3.UbS.readString();
                    AppMethodBeat.o(201289);
                    return 0;
                case 14:
                    acn.Lnk = aVar3.UbS.yZ();
                    AppMethodBeat.o(201289);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        ecy ecy = new ecy();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = ecy.populateBuilderWithField(aVar10, ecy, a.getNextFieldNumber(aVar10))) {
                        }
                        acn.Lnl.add(ecy);
                    }
                    AppMethodBeat.o(201289);
                    return 0;
                default:
                    AppMethodBeat.o(201289);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201289);
            return -1;
        }
    }
}
