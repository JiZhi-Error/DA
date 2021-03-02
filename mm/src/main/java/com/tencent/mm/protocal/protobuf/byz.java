package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class byz extends dpc {
    public int KSa;
    public int LUr;
    public cyd Mei;
    public LinkedList<crb> Meo = new LinkedList<>();
    public String Mep;
    public String Meq;
    public String Mer;
    public String Mes;
    public String Met;
    public LinkedList<fdt> Meu = new LinkedList<>();
    public String dNI;
    public String dPS;
    public String qGr;
    public int ret;
    public String url;

    public byz() {
        AppMethodBeat.i(123588);
        AppMethodBeat.o(123588);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123589);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123589);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.ret);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.aM(4, this.LUr);
            if (this.dPS != null) {
                aVar.e(5, this.dPS);
            }
            if (this.Mei != null) {
                aVar.ni(6, this.Mei.computeSize());
                this.Mei.writeFields(aVar);
            }
            aVar.e(7, 8, this.Meo);
            if (this.Mep != null) {
                aVar.e(8, this.Mep);
            }
            if (this.qGr != null) {
                aVar.e(9, this.qGr);
            }
            aVar.aM(10, this.KSa);
            if (this.dNI != null) {
                aVar.e(11, this.dNI);
            }
            if (this.Meq != null) {
                aVar.e(12, this.Meq);
            }
            if (this.Mer != null) {
                aVar.e(13, this.Mer);
            }
            if (this.Mes != null) {
                aVar.e(14, this.Mes);
            }
            if (this.Met != null) {
                aVar.e(15, this.Met);
            }
            aVar.e(16, 8, this.Meu);
            AppMethodBeat.o(123589);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.ret);
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(3, this.url);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.LUr);
            if (this.dPS != null) {
                bu += g.a.a.b.b.a.f(5, this.dPS);
            }
            if (this.Mei != null) {
                bu += g.a.a.a.nh(6, this.Mei.computeSize());
            }
            int c2 = bu + g.a.a.a.c(7, 8, this.Meo);
            if (this.Mep != null) {
                c2 += g.a.a.b.b.a.f(8, this.Mep);
            }
            if (this.qGr != null) {
                c2 += g.a.a.b.b.a.f(9, this.qGr);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(10, this.KSa);
            if (this.dNI != null) {
                bu2 += g.a.a.b.b.a.f(11, this.dNI);
            }
            if (this.Meq != null) {
                bu2 += g.a.a.b.b.a.f(12, this.Meq);
            }
            if (this.Mer != null) {
                bu2 += g.a.a.b.b.a.f(13, this.Mer);
            }
            if (this.Mes != null) {
                bu2 += g.a.a.b.b.a.f(14, this.Mes);
            }
            if (this.Met != null) {
                bu2 += g.a.a.b.b.a.f(15, this.Met);
            }
            int c3 = bu2 + g.a.a.a.c(16, 8, this.Meu);
            AppMethodBeat.o(123589);
            return c3;
        } else if (i2 == 2) {
            this.Meo.clear();
            this.Meu.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123589);
                throw bVar2;
            }
            AppMethodBeat.o(123589);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            byz byz = (byz) objArr[1];
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
                        byz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123589);
                    return 0;
                case 2:
                    byz.ret = aVar3.UbS.zi();
                    AppMethodBeat.o(123589);
                    return 0;
                case 3:
                    byz.url = aVar3.UbS.readString();
                    AppMethodBeat.o(123589);
                    return 0;
                case 4:
                    byz.LUr = aVar3.UbS.zi();
                    AppMethodBeat.o(123589);
                    return 0;
                case 5:
                    byz.dPS = aVar3.UbS.readString();
                    AppMethodBeat.o(123589);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cyd cyd = new cyd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cyd.populateBuilderWithField(aVar5, cyd, dpc.getNextFieldNumber(aVar5))) {
                        }
                        byz.Mei = cyd;
                    }
                    AppMethodBeat.o(123589);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        crb crb = new crb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = crb.populateBuilderWithField(aVar6, crb, dpc.getNextFieldNumber(aVar6))) {
                        }
                        byz.Meo.add(crb);
                    }
                    AppMethodBeat.o(123589);
                    return 0;
                case 8:
                    byz.Mep = aVar3.UbS.readString();
                    AppMethodBeat.o(123589);
                    return 0;
                case 9:
                    byz.qGr = aVar3.UbS.readString();
                    AppMethodBeat.o(123589);
                    return 0;
                case 10:
                    byz.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(123589);
                    return 0;
                case 11:
                    byz.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123589);
                    return 0;
                case 12:
                    byz.Meq = aVar3.UbS.readString();
                    AppMethodBeat.o(123589);
                    return 0;
                case 13:
                    byz.Mer = aVar3.UbS.readString();
                    AppMethodBeat.o(123589);
                    return 0;
                case 14:
                    byz.Mes = aVar3.UbS.readString();
                    AppMethodBeat.o(123589);
                    return 0;
                case 15:
                    byz.Met = aVar3.UbS.readString();
                    AppMethodBeat.o(123589);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fdt fdt = new fdt();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fdt.populateBuilderWithField(aVar7, fdt, dpc.getNextFieldNumber(aVar7))) {
                        }
                        byz.Meu.add(fdt);
                    }
                    AppMethodBeat.o(123589);
                    return 0;
                default:
                    AppMethodBeat.o(123589);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123589);
            return -1;
        }
    }
}
