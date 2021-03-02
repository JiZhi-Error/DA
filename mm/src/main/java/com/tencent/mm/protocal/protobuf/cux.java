package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cux extends dpc {
    public String HuS;
    public cki MAb;
    public String MAc;
    public amh MAd;
    public int MAf;
    public int MAg;
    public int MAh;
    public LinkedList<ahq> MAi = new LinkedList<>();
    public LinkedList<dlw> MAj = new LinkedList<>();
    public LinkedList<jf> MAk = new LinkedList<>();
    public dde MAl;
    public int MAm;
    public String MAn;
    public ddd MAo;
    public ddd MAp;
    public String MAq;
    public acl MAr;
    public ddd MAs;
    public boolean Mma;
    public ckj efB;
    public int pTZ;
    public String pUa;

    public cux() {
        AppMethodBeat.i(91561);
        AppMethodBeat.o(91561);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91562);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91562);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.aM(4, this.MAf);
            aVar.aM(5, this.MAg);
            aVar.aM(6, this.MAh);
            aVar.e(8, 8, this.MAi);
            if (this.MAb != null) {
                aVar.ni(9, this.MAb.computeSize());
                this.MAb.writeFields(aVar);
            }
            aVar.e(10, 8, this.MAj);
            aVar.e(11, 8, this.MAk);
            aVar.cc(12, this.Mma);
            if (this.MAl != null) {
                aVar.ni(13, this.MAl.computeSize());
                this.MAl.writeFields(aVar);
            }
            if (this.MAc != null) {
                aVar.e(14, this.MAc);
            }
            if (this.MAd != null) {
                aVar.ni(15, this.MAd.computeSize());
                this.MAd.writeFields(aVar);
            }
            aVar.aM(16, this.MAm);
            if (this.MAn != null) {
                aVar.e(17, this.MAn);
            }
            if (this.MAo != null) {
                aVar.ni(18, this.MAo.computeSize());
                this.MAo.writeFields(aVar);
            }
            if (this.MAp != null) {
                aVar.ni(19, this.MAp.computeSize());
                this.MAp.writeFields(aVar);
            }
            if (this.MAq != null) {
                aVar.e(20, this.MAq);
            }
            if (this.MAr != null) {
                aVar.ni(21, this.MAr.computeSize());
                this.MAr.writeFields(aVar);
            }
            if (this.MAs != null) {
                aVar.ni(22, this.MAs.computeSize());
                this.MAs.writeFields(aVar);
            }
            if (this.efB != null) {
                aVar.ni(99, this.efB.computeSize());
                this.efB.writeFields(aVar);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91562);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MAf) + g.a.a.b.b.a.bu(5, this.MAg) + g.a.a.b.b.a.bu(6, this.MAh) + g.a.a.a.c(8, 8, this.MAi);
            if (this.MAb != null) {
                bu += g.a.a.a.nh(9, this.MAb.computeSize());
            }
            int c2 = bu + g.a.a.a.c(10, 8, this.MAj) + g.a.a.a.c(11, 8, this.MAk) + g.a.a.b.b.a.fS(12) + 1;
            if (this.MAl != null) {
                c2 += g.a.a.a.nh(13, this.MAl.computeSize());
            }
            if (this.MAc != null) {
                c2 += g.a.a.b.b.a.f(14, this.MAc);
            }
            if (this.MAd != null) {
                c2 += g.a.a.a.nh(15, this.MAd.computeSize());
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(16, this.MAm);
            if (this.MAn != null) {
                bu2 += g.a.a.b.b.a.f(17, this.MAn);
            }
            if (this.MAo != null) {
                bu2 += g.a.a.a.nh(18, this.MAo.computeSize());
            }
            if (this.MAp != null) {
                bu2 += g.a.a.a.nh(19, this.MAp.computeSize());
            }
            if (this.MAq != null) {
                bu2 += g.a.a.b.b.a.f(20, this.MAq);
            }
            if (this.MAr != null) {
                bu2 += g.a.a.a.nh(21, this.MAr.computeSize());
            }
            if (this.MAs != null) {
                bu2 += g.a.a.a.nh(22, this.MAs.computeSize());
            }
            if (this.efB != null) {
                bu2 += g.a.a.a.nh(99, this.efB.computeSize());
            }
            if (this.HuS != null) {
                bu2 += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91562);
            return bu2;
        } else if (i2 == 2) {
            this.MAi.clear();
            this.MAj.clear();
            this.MAk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91562);
                throw bVar2;
            }
            AppMethodBeat.o(91562);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cux cux = (cux) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        cux.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 2:
                    cux.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91562);
                    return 0;
                case 3:
                    cux.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91562);
                    return 0;
                case 4:
                    cux.MAf = aVar3.UbS.zi();
                    AppMethodBeat.o(91562);
                    return 0;
                case 5:
                    cux.MAg = aVar3.UbS.zi();
                    AppMethodBeat.o(91562);
                    return 0;
                case 6:
                    cux.MAh = aVar3.UbS.zi();
                    AppMethodBeat.o(91562);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahq ahq = new ahq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahq.populateBuilderWithField(aVar5, ahq, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cux.MAi.add(ahq);
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cki cki = new cki();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cki.populateBuilderWithField(aVar6, cki, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cux.MAb = cki;
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dlw dlw = new dlw();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dlw.populateBuilderWithField(aVar7, dlw, dpc.getNextFieldNumber(aVar7))) {
                        }
                        cux.MAj.add(dlw);
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        jf jfVar = new jf();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = jfVar.populateBuilderWithField(aVar8, jfVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        cux.MAk.add(jfVar);
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 12:
                    cux.Mma = aVar3.UbS.yZ();
                    AppMethodBeat.o(91562);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dde dde = new dde();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dde.populateBuilderWithField(aVar9, dde, dpc.getNextFieldNumber(aVar9))) {
                        }
                        cux.MAl = dde;
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 14:
                    cux.MAc = aVar3.UbS.readString();
                    AppMethodBeat.o(91562);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        amh amh = new amh();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = amh.populateBuilderWithField(aVar10, amh, dpc.getNextFieldNumber(aVar10))) {
                        }
                        cux.MAd = amh;
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 16:
                    cux.MAm = aVar3.UbS.zi();
                    AppMethodBeat.o(91562);
                    return 0;
                case 17:
                    cux.MAn = aVar3.UbS.readString();
                    AppMethodBeat.o(91562);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        ddd ddd = new ddd();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = ddd.populateBuilderWithField(aVar11, ddd, dpc.getNextFieldNumber(aVar11))) {
                        }
                        cux.MAo = ddd;
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        ddd ddd2 = new ddd();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = ddd2.populateBuilderWithField(aVar12, ddd2, dpc.getNextFieldNumber(aVar12))) {
                        }
                        cux.MAp = ddd2;
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 20:
                    cux.MAq = aVar3.UbS.readString();
                    AppMethodBeat.o(91562);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        acl acl = new acl();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = acl.populateBuilderWithField(aVar13, acl, dpc.getNextFieldNumber(aVar13))) {
                        }
                        cux.MAr = acl;
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        ddd ddd3 = new ddd();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = ddd3.populateBuilderWithField(aVar14, ddd3, dpc.getNextFieldNumber(aVar14))) {
                        }
                        cux.MAs = ddd3;
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 99:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        ckj ckj = new ckj();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = ckj.populateBuilderWithField(aVar15, ckj, dpc.getNextFieldNumber(aVar15))) {
                        }
                        cux.efB = ckj;
                    }
                    AppMethodBeat.o(91562);
                    return 0;
                case 100:
                    cux.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91562);
                    return 0;
                default:
                    AppMethodBeat.o(91562);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91562);
            return -1;
        }
    }
}
