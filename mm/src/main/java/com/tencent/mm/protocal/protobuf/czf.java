package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class czf extends dpc {
    public LinkedList<sa> MEu = new LinkedList<>();
    public String MEv;
    public String MEw;
    public String MEx;
    public efl MEy;
    public String MEz;
    public String Mbb;
    public efl MlS;

    public czf() {
        AppMethodBeat.i(117890);
        AppMethodBeat.o(117890);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117891);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Mbb != null) {
                aVar.e(2, this.Mbb);
            }
            if (this.MlS != null) {
                aVar.ni(3, this.MlS.computeSize());
                this.MlS.writeFields(aVar);
            }
            aVar.e(4, 8, this.MEu);
            if (this.MEv != null) {
                aVar.e(5, this.MEv);
            }
            if (this.MEw != null) {
                aVar.e(6, this.MEw);
            }
            if (this.MEx != null) {
                aVar.e(7, this.MEx);
            }
            if (this.MEy != null) {
                aVar.ni(8, this.MEy.computeSize());
                this.MEy.writeFields(aVar);
            }
            if (this.MEz != null) {
                aVar.e(9, this.MEz);
            }
            AppMethodBeat.o(117891);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Mbb != null) {
                nh += g.a.a.b.b.a.f(2, this.Mbb);
            }
            if (this.MlS != null) {
                nh += g.a.a.a.nh(3, this.MlS.computeSize());
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.MEu);
            if (this.MEv != null) {
                c2 += g.a.a.b.b.a.f(5, this.MEv);
            }
            if (this.MEw != null) {
                c2 += g.a.a.b.b.a.f(6, this.MEw);
            }
            if (this.MEx != null) {
                c2 += g.a.a.b.b.a.f(7, this.MEx);
            }
            if (this.MEy != null) {
                c2 += g.a.a.a.nh(8, this.MEy.computeSize());
            }
            if (this.MEz != null) {
                c2 += g.a.a.b.b.a.f(9, this.MEz);
            }
            AppMethodBeat.o(117891);
            return c2;
        } else if (i2 == 2) {
            this.MEu.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117891);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czf czf = (czf) objArr[1];
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
                        czf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(117891);
                    return 0;
                case 2:
                    czf.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(117891);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        efl efl = new efl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = efl.populateBuilderWithField(aVar5, efl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        czf.MlS = efl;
                    }
                    AppMethodBeat.o(117891);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        sa saVar = new sa();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = saVar.populateBuilderWithField(aVar6, saVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        czf.MEu.add(saVar);
                    }
                    AppMethodBeat.o(117891);
                    return 0;
                case 5:
                    czf.MEv = aVar3.UbS.readString();
                    AppMethodBeat.o(117891);
                    return 0;
                case 6:
                    czf.MEw = aVar3.UbS.readString();
                    AppMethodBeat.o(117891);
                    return 0;
                case 7:
                    czf.MEx = aVar3.UbS.readString();
                    AppMethodBeat.o(117891);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        efl efl2 = new efl();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = efl2.populateBuilderWithField(aVar7, efl2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        czf.MEy = efl2;
                    }
                    AppMethodBeat.o(117891);
                    return 0;
                case 9:
                    czf.MEz = aVar3.UbS.readString();
                    AppMethodBeat.o(117891);
                    return 0;
                default:
                    AppMethodBeat.o(117891);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117891);
            return -1;
        }
    }
}
