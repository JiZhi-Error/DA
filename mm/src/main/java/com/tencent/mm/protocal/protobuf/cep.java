package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class cep extends dpc {
    public String KFs;
    public LinkedList<drb> LRN = new LinkedList<>();
    public cdz Mkb;
    public String Mke;
    public String Mkf;
    public String Mkg;
    public dy Mkh;
    public b Mki;
    public String Mkj;
    public String xMq;

    public cep() {
        AppMethodBeat.i(123609);
        AppMethodBeat.o(123609);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123610);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123610);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Mkb != null) {
                aVar.ni(2, this.Mkb.computeSize());
                this.Mkb.writeFields(aVar);
            }
            aVar.e(3, 8, this.LRN);
            if (this.xMq != null) {
                aVar.e(4, this.xMq);
            }
            if (this.KFs != null) {
                aVar.e(5, this.KFs);
            }
            if (this.Mke != null) {
                aVar.e(6, this.Mke);
            }
            if (this.Mkf != null) {
                aVar.e(7, this.Mkf);
            }
            if (this.Mkg != null) {
                aVar.e(8, this.Mkg);
            }
            if (this.Mkh != null) {
                aVar.ni(9, this.Mkh.computeSize());
                this.Mkh.writeFields(aVar);
            }
            if (this.Mki != null) {
                aVar.c(10, this.Mki);
            }
            if (this.Mkj != null) {
                aVar.e(11, this.Mkj);
            }
            AppMethodBeat.o(123610);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Mkb != null) {
                nh += g.a.a.a.nh(2, this.Mkb.computeSize());
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.LRN);
            if (this.xMq != null) {
                c2 += g.a.a.b.b.a.f(4, this.xMq);
            }
            if (this.KFs != null) {
                c2 += g.a.a.b.b.a.f(5, this.KFs);
            }
            if (this.Mke != null) {
                c2 += g.a.a.b.b.a.f(6, this.Mke);
            }
            if (this.Mkf != null) {
                c2 += g.a.a.b.b.a.f(7, this.Mkf);
            }
            if (this.Mkg != null) {
                c2 += g.a.a.b.b.a.f(8, this.Mkg);
            }
            if (this.Mkh != null) {
                c2 += g.a.a.a.nh(9, this.Mkh.computeSize());
            }
            if (this.Mki != null) {
                c2 += g.a.a.b.b.a.b(10, this.Mki);
            }
            if (this.Mkj != null) {
                c2 += g.a.a.b.b.a.f(11, this.Mkj);
            }
            AppMethodBeat.o(123610);
            return c2;
        } else if (i2 == 2) {
            this.LRN.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123610);
                throw bVar2;
            }
            AppMethodBeat.o(123610);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cep cep = (cep) objArr[1];
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
                        cep.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123610);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cdz cdz = new cdz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cdz.populateBuilderWithField(aVar5, cdz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cep.Mkb = cdz;
                    }
                    AppMethodBeat.o(123610);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        drb drb = new drb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = drb.populateBuilderWithField(aVar6, drb, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cep.LRN.add(drb);
                    }
                    AppMethodBeat.o(123610);
                    return 0;
                case 4:
                    cep.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(123610);
                    return 0;
                case 5:
                    cep.KFs = aVar3.UbS.readString();
                    AppMethodBeat.o(123610);
                    return 0;
                case 6:
                    cep.Mke = aVar3.UbS.readString();
                    AppMethodBeat.o(123610);
                    return 0;
                case 7:
                    cep.Mkf = aVar3.UbS.readString();
                    AppMethodBeat.o(123610);
                    return 0;
                case 8:
                    cep.Mkg = aVar3.UbS.readString();
                    AppMethodBeat.o(123610);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dy dyVar = new dy();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dyVar.populateBuilderWithField(aVar7, dyVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        cep.Mkh = dyVar;
                    }
                    AppMethodBeat.o(123610);
                    return 0;
                case 10:
                    cep.Mki = aVar3.UbS.hPo();
                    AppMethodBeat.o(123610);
                    return 0;
                case 11:
                    cep.Mkj = aVar3.UbS.readString();
                    AppMethodBeat.o(123610);
                    return 0;
                default:
                    AppMethodBeat.o(123610);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123610);
            return -1;
        }
    }
}
