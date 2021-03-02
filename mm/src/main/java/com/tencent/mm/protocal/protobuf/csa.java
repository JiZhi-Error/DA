package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class csa extends dop {
    public apc LAv;
    public aov LBM;
    public b LBu;
    public avk LDR;
    public b LDs;
    public atn LEs;
    public b LEu;
    public efo LEv;
    public LinkedList<ecq> LEw = new LinkedList<>();
    public buj LEx;
    public int Mxd;
    public String Mxe;
    public bcc Mxf;
    public aoz Mxg;
    public String Mxh;
    public float dTj;
    public float latitude;
    public long object_id;
    public String object_nonce_id;
    public String pPy;
    public String pPz;
    public int scene;
    public String source;
    public blo tVd;

    public csa() {
        AppMethodBeat.i(256712);
        AppMethodBeat.o(256712);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256713);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LBM != null) {
                aVar.ni(2, this.LBM.computeSize());
                this.LBM.writeFields(aVar);
            }
            if (this.LDs != null) {
                aVar.c(3, this.LDs);
            }
            aVar.bb(4, this.object_id);
            aVar.E(6, this.dTj);
            aVar.E(7, this.latitude);
            aVar.aM(5, this.Mxd);
            if (this.object_nonce_id != null) {
                aVar.e(8, this.object_nonce_id);
            }
            if (this.Mxe != null) {
                aVar.e(9, this.Mxe);
            }
            aVar.aM(10, this.scene);
            if (this.source != null) {
                aVar.e(11, this.source);
            }
            if (this.Mxf != null) {
                aVar.ni(12, this.Mxf.computeSize());
                this.Mxf.writeFields(aVar);
            }
            if (this.Mxg != null) {
                aVar.ni(13, this.Mxg.computeSize());
                this.Mxg.writeFields(aVar);
            }
            if (this.LBu != null) {
                aVar.c(14, this.LBu);
            }
            if (this.LAv != null) {
                aVar.ni(15, this.LAv.computeSize());
                this.LAv.writeFields(aVar);
            }
            if (this.pPy != null) {
                aVar.e(16, this.pPy);
            }
            if (this.pPz != null) {
                aVar.e(17, this.pPz);
            }
            if (this.LEs != null) {
                aVar.ni(18, this.LEs.computeSize());
                this.LEs.writeFields(aVar);
            }
            if (this.Mxh != null) {
                aVar.e(19, this.Mxh);
            }
            if (this.LEu != null) {
                aVar.c(20, this.LEu);
            }
            if (this.LEv != null) {
                aVar.ni(21, this.LEv.computeSize());
                this.LEv.writeFields(aVar);
            }
            if (this.tVd != null) {
                aVar.ni(22, this.tVd.computeSize());
                this.tVd.writeFields(aVar);
            }
            aVar.e(23, 8, this.LEw);
            if (this.LEx != null) {
                aVar.ni(24, this.LEx.computeSize());
                this.LEx.writeFields(aVar);
            }
            if (this.LDR != null) {
                aVar.ni(25, this.LDR.computeSize());
                this.LDR.writeFields(aVar);
            }
            AppMethodBeat.o(256713);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(3, this.LDs);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.object_id) + g.a.a.b.b.a.fS(6) + 4 + g.a.a.b.b.a.fS(7) + 4 + g.a.a.b.b.a.bu(5, this.Mxd);
            if (this.object_nonce_id != null) {
                r += g.a.a.b.b.a.f(8, this.object_nonce_id);
            }
            if (this.Mxe != null) {
                r += g.a.a.b.b.a.f(9, this.Mxe);
            }
            int bu = r + g.a.a.b.b.a.bu(10, this.scene);
            if (this.source != null) {
                bu += g.a.a.b.b.a.f(11, this.source);
            }
            if (this.Mxf != null) {
                bu += g.a.a.a.nh(12, this.Mxf.computeSize());
            }
            if (this.Mxg != null) {
                bu += g.a.a.a.nh(13, this.Mxg.computeSize());
            }
            if (this.LBu != null) {
                bu += g.a.a.b.b.a.b(14, this.LBu);
            }
            if (this.LAv != null) {
                bu += g.a.a.a.nh(15, this.LAv.computeSize());
            }
            if (this.pPy != null) {
                bu += g.a.a.b.b.a.f(16, this.pPy);
            }
            if (this.pPz != null) {
                bu += g.a.a.b.b.a.f(17, this.pPz);
            }
            if (this.LEs != null) {
                bu += g.a.a.a.nh(18, this.LEs.computeSize());
            }
            if (this.Mxh != null) {
                bu += g.a.a.b.b.a.f(19, this.Mxh);
            }
            if (this.LEu != null) {
                bu += g.a.a.b.b.a.b(20, this.LEu);
            }
            if (this.LEv != null) {
                bu += g.a.a.a.nh(21, this.LEv.computeSize());
            }
            if (this.tVd != null) {
                bu += g.a.a.a.nh(22, this.tVd.computeSize());
            }
            int c2 = bu + g.a.a.a.c(23, 8, this.LEw);
            if (this.LEx != null) {
                c2 += g.a.a.a.nh(24, this.LEx.computeSize());
            }
            if (this.LDR != null) {
                c2 += g.a.a.a.nh(25, this.LDR.computeSize());
            }
            AppMethodBeat.o(256713);
            return c2;
        } else if (i2 == 2) {
            this.LEw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256713);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csa csa = (csa) objArr[1];
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
                        csa.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        csa.LBM = aov;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 3:
                    csa.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(256713);
                    return 0;
                case 4:
                    csa.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(256713);
                    return 0;
                case 5:
                    csa.Mxd = aVar3.UbS.zi();
                    AppMethodBeat.o(256713);
                    return 0;
                case 6:
                    csa.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(256713);
                    return 0;
                case 7:
                    csa.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(256713);
                    return 0;
                case 8:
                    csa.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(256713);
                    return 0;
                case 9:
                    csa.Mxe = aVar3.UbS.readString();
                    AppMethodBeat.o(256713);
                    return 0;
                case 10:
                    csa.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(256713);
                    return 0;
                case 11:
                    csa.source = aVar3.UbS.readString();
                    AppMethodBeat.o(256713);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bcc bcc = new bcc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bcc.populateBuilderWithField(aVar6, bcc, dop.getNextFieldNumber(aVar6))) {
                        }
                        csa.Mxf = bcc;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aoz aoz = new aoz();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aoz.populateBuilderWithField(aVar7, aoz, dop.getNextFieldNumber(aVar7))) {
                        }
                        csa.Mxg = aoz;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 14:
                    csa.LBu = aVar3.UbS.hPo();
                    AppMethodBeat.o(256713);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        apc apc = new apc();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = apc.populateBuilderWithField(aVar8, apc, dop.getNextFieldNumber(aVar8))) {
                        }
                        csa.LAv = apc;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 16:
                    csa.pPy = aVar3.UbS.readString();
                    AppMethodBeat.o(256713);
                    return 0;
                case 17:
                    csa.pPz = aVar3.UbS.readString();
                    AppMethodBeat.o(256713);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        atn atn = new atn();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = atn.populateBuilderWithField(aVar9, atn, dop.getNextFieldNumber(aVar9))) {
                        }
                        csa.LEs = atn;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 19:
                    csa.Mxh = aVar3.UbS.readString();
                    AppMethodBeat.o(256713);
                    return 0;
                case 20:
                    csa.LEu = aVar3.UbS.hPo();
                    AppMethodBeat.o(256713);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        efo efo = new efo();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = efo.populateBuilderWithField(aVar10, efo, dop.getNextFieldNumber(aVar10))) {
                        }
                        csa.LEv = efo;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        blo blo = new blo();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = blo.populateBuilderWithField(aVar11, blo, dop.getNextFieldNumber(aVar11))) {
                        }
                        csa.tVd = blo;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        ecq ecq = new ecq();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = ecq.populateBuilderWithField(aVar12, ecq, dop.getNextFieldNumber(aVar12))) {
                        }
                        csa.LEw.add(ecq);
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        buj buj = new buj();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = buj.populateBuilderWithField(aVar13, buj, dop.getNextFieldNumber(aVar13))) {
                        }
                        csa.LEx = buj;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        avk avk = new avk();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = avk.populateBuilderWithField(aVar14, avk, dop.getNextFieldNumber(aVar14))) {
                        }
                        csa.LDR = avk;
                    }
                    AppMethodBeat.o(256713);
                    return 0;
                default:
                    AppMethodBeat.o(256713);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256713);
            return -1;
        }
    }
}
