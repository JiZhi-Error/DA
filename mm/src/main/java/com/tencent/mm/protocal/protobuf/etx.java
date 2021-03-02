package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class etx extends dpc {
    public int KMC;
    public LinkedList<esq> KMD = new LinkedList<>();
    public int LsZ;
    public long Lta;
    public int MKr;
    public eue NpS;
    public int NpT;
    public int NpU;
    public int NpV;
    public int NpW;
    public SKBuiltinBuffer_t NpX;
    public int NqY;
    public int NqZ;
    public int Nqc;
    public LinkedList<eug> Nqd = new LinkedList<>();
    public int Nqe;
    public int Nqf;
    public int Nqg;
    public int Nqh;
    public int Nqi;
    public int Nqj;
    public int Nqk;
    public int Nql;
    public int Nqm;
    public int Nqn;
    public int Nqo;
    public int Nqp;
    public int Nqq;
    public int Nqr;
    public int Nra;

    public etx() {
        AppMethodBeat.i(115885);
        AppMethodBeat.o(115885);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115886);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(115886);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.aM(3, this.KMC);
            aVar.e(4, 8, this.KMD);
            aVar.bb(5, this.Lta);
            aVar.aM(6, this.MKr);
            if (this.NpS != null) {
                aVar.ni(7, this.NpS.computeSize());
                this.NpS.writeFields(aVar);
            }
            aVar.aM(8, this.Nqc);
            aVar.e(9, 8, this.Nqd);
            aVar.aM(10, this.Nqe);
            aVar.aM(11, this.Nqf);
            aVar.aM(12, this.Nqg);
            aVar.aM(13, this.Nqh);
            aVar.aM(14, this.NqY);
            aVar.aM(15, this.Nqi);
            aVar.aM(16, this.Nqj);
            aVar.aM(17, this.NpT);
            aVar.aM(18, this.Nqk);
            aVar.aM(19, this.Nql);
            aVar.aM(20, this.NpU);
            aVar.aM(21, this.Nqm);
            aVar.aM(22, this.Nqn);
            aVar.aM(23, this.Nqo);
            aVar.aM(24, this.NqZ);
            aVar.aM(25, this.Nqp);
            aVar.aM(26, this.Nra);
            aVar.aM(27, this.NpV);
            aVar.aM(28, this.NpW);
            aVar.aM(29, this.Nqq);
            aVar.aM(30, this.Nqr);
            if (this.NpX != null) {
                aVar.ni(31, this.NpX.computeSize());
                this.NpX.writeFields(aVar);
            }
            AppMethodBeat.o(115886);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.bu(3, this.KMC) + g.a.a.a.c(4, 8, this.KMD) + g.a.a.b.b.a.r(5, this.Lta) + g.a.a.b.b.a.bu(6, this.MKr);
            if (this.NpS != null) {
                nh += g.a.a.a.nh(7, this.NpS.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.Nqc) + g.a.a.a.c(9, 8, this.Nqd) + g.a.a.b.b.a.bu(10, this.Nqe) + g.a.a.b.b.a.bu(11, this.Nqf) + g.a.a.b.b.a.bu(12, this.Nqg) + g.a.a.b.b.a.bu(13, this.Nqh) + g.a.a.b.b.a.bu(14, this.NqY) + g.a.a.b.b.a.bu(15, this.Nqi) + g.a.a.b.b.a.bu(16, this.Nqj) + g.a.a.b.b.a.bu(17, this.NpT) + g.a.a.b.b.a.bu(18, this.Nqk) + g.a.a.b.b.a.bu(19, this.Nql) + g.a.a.b.b.a.bu(20, this.NpU) + g.a.a.b.b.a.bu(21, this.Nqm) + g.a.a.b.b.a.bu(22, this.Nqn) + g.a.a.b.b.a.bu(23, this.Nqo) + g.a.a.b.b.a.bu(24, this.NqZ) + g.a.a.b.b.a.bu(25, this.Nqp) + g.a.a.b.b.a.bu(26, this.Nra) + g.a.a.b.b.a.bu(27, this.NpV) + g.a.a.b.b.a.bu(28, this.NpW) + g.a.a.b.b.a.bu(29, this.Nqq) + g.a.a.b.b.a.bu(30, this.Nqr);
            if (this.NpX != null) {
                bu += g.a.a.a.nh(31, this.NpX.computeSize());
            }
            AppMethodBeat.o(115886);
            return bu;
        } else if (i2 == 2) {
            this.KMD.clear();
            this.Nqd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(115886);
                throw bVar2;
            }
            AppMethodBeat.o(115886);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etx etx = (etx) objArr[1];
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
                        etx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(115886);
                    return 0;
                case 2:
                    etx.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 3:
                    etx.KMC = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esq esq = new esq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esq.populateBuilderWithField(aVar5, esq, dpc.getNextFieldNumber(aVar5))) {
                        }
                        etx.KMD.add(esq);
                    }
                    AppMethodBeat.o(115886);
                    return 0;
                case 5:
                    etx.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115886);
                    return 0;
                case 6:
                    etx.MKr = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eue eue = new eue();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eue.populateBuilderWithField(aVar6, eue, dpc.getNextFieldNumber(aVar6))) {
                        }
                        etx.NpS = eue;
                    }
                    AppMethodBeat.o(115886);
                    return 0;
                case 8:
                    etx.Nqc = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eug eug = new eug();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eug.populateBuilderWithField(aVar7, eug, dpc.getNextFieldNumber(aVar7))) {
                        }
                        etx.Nqd.add(eug);
                    }
                    AppMethodBeat.o(115886);
                    return 0;
                case 10:
                    etx.Nqe = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 11:
                    etx.Nqf = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 12:
                    etx.Nqg = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 13:
                    etx.Nqh = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 14:
                    etx.NqY = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 15:
                    etx.Nqi = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 16:
                    etx.Nqj = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 17:
                    etx.NpT = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 18:
                    etx.Nqk = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 19:
                    etx.Nql = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 20:
                    etx.NpU = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 21:
                    etx.Nqm = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 22:
                    etx.Nqn = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 23:
                    etx.Nqo = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 24:
                    etx.NqZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 25:
                    etx.Nqp = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 26:
                    etx.Nra = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 27:
                    etx.NpV = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 28:
                    etx.NpW = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 29:
                    etx.Nqq = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 30:
                    etx.Nqr = aVar3.UbS.zi();
                    AppMethodBeat.o(115886);
                    return 0;
                case 31:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t.populateBuilderWithField(aVar8, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar8))) {
                        }
                        etx.NpX = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(115886);
                    return 0;
                default:
                    AppMethodBeat.o(115886);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115886);
            return -1;
        }
    }
}
