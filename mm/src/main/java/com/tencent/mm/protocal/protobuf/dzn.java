package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dzn extends dpc {
    public String KHk;
    public LinkedList<SnsObject> KOH = new LinkedList<>();
    public String MZg;
    public int MZk;
    public eat MZl;
    public int MvM;
    public int xuw;

    public dzn() {
        AppMethodBeat.i(125776);
        AppMethodBeat.o(125776);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125777);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125777);
                throw bVar;
            } else if (this.MZl == null) {
                b bVar2 = new b("Not all required fields were included: ServerConfig");
                AppMethodBeat.o(125777);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.MZg != null) {
                    aVar.e(2, this.MZg);
                }
                aVar.aM(3, this.MvM);
                aVar.e(4, 8, this.KOH);
                aVar.aM(5, this.MZk);
                if (this.KHk != null) {
                    aVar.e(6, this.KHk);
                }
                aVar.aM(7, this.xuw);
                if (this.MZl != null) {
                    aVar.ni(8, this.MZl.computeSize());
                    this.MZl.writeFields(aVar);
                }
                AppMethodBeat.o(125777);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MZg != null) {
                nh += g.a.a.b.b.a.f(2, this.MZg);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MvM) + g.a.a.a.c(4, 8, this.KOH) + g.a.a.b.b.a.bu(5, this.MZk);
            if (this.KHk != null) {
                bu += g.a.a.b.b.a.f(6, this.KHk);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.xuw);
            if (this.MZl != null) {
                bu2 += g.a.a.a.nh(8, this.MZl.computeSize());
            }
            AppMethodBeat.o(125777);
            return bu2;
        } else if (i2 == 2) {
            this.KOH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125777);
                throw bVar3;
            } else if (this.MZl == null) {
                b bVar4 = new b("Not all required fields were included: ServerConfig");
                AppMethodBeat.o(125777);
                throw bVar4;
            } else {
                AppMethodBeat.o(125777);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzn dzn = (dzn) objArr[1];
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
                        dzn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125777);
                    return 0;
                case 2:
                    dzn.MZg = aVar3.UbS.readString();
                    AppMethodBeat.o(125777);
                    return 0;
                case 3:
                    dzn.MvM = aVar3.UbS.zi();
                    AppMethodBeat.o(125777);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SnsObject snsObject = new SnsObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = snsObject.populateBuilderWithField(aVar5, snsObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dzn.KOH.add(snsObject);
                    }
                    AppMethodBeat.o(125777);
                    return 0;
                case 5:
                    dzn.MZk = aVar3.UbS.zi();
                    AppMethodBeat.o(125777);
                    return 0;
                case 6:
                    dzn.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(125777);
                    return 0;
                case 7:
                    dzn.xuw = aVar3.UbS.zi();
                    AppMethodBeat.o(125777);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eat eat = new eat();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eat.populateBuilderWithField(aVar6, eat, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dzn.MZl = eat;
                    }
                    AppMethodBeat.o(125777);
                    return 0;
                default:
                    AppMethodBeat.o(125777);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125777);
            return -1;
        }
    }
}
