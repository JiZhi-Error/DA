package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class env extends dpc {
    public int Brl;
    public long Brn;
    public int BsF;
    public int BsG;
    public int BsH;
    public int CreateTime;
    public dqi KHl;
    public dqi KHm;
    public String KHq;
    public String KMl;
    public String LbJ;
    public int LbO;
    public dqi NlB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152720);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152720);
                throw bVar;
            } else if (this.NlB == null) {
                b bVar2 = new b("Not all required fields were included: ClientImgId");
                AppMethodBeat.o(152720);
                throw bVar2;
            } else if (this.KHl == null) {
                b bVar3 = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(152720);
                throw bVar3;
            } else if (this.KHm == null) {
                b bVar4 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(152720);
                throw bVar4;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.aM(2, this.Brl);
                if (this.NlB != null) {
                    aVar.ni(3, this.NlB.computeSize());
                    this.NlB.writeFields(aVar);
                }
                if (this.KHl != null) {
                    aVar.ni(4, this.KHl.computeSize());
                    this.KHl.writeFields(aVar);
                }
                if (this.KHm != null) {
                    aVar.ni(5, this.KHm.computeSize());
                    this.KHm.writeFields(aVar);
                }
                aVar.aM(6, this.BsF);
                aVar.aM(7, this.BsG);
                aVar.aM(8, this.BsH);
                aVar.aM(9, this.CreateTime);
                aVar.bb(10, this.Brn);
                if (this.LbJ != null) {
                    aVar.e(11, this.LbJ);
                }
                if (this.KMl != null) {
                    aVar.e(12, this.KMl);
                }
                if (this.KHq != null) {
                    aVar.e(13, this.KHq);
                }
                aVar.aM(14, this.LbO);
                AppMethodBeat.o(152720);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Brl);
            if (this.NlB != null) {
                nh += g.a.a.a.nh(3, this.NlB.computeSize());
            }
            if (this.KHl != null) {
                nh += g.a.a.a.nh(4, this.KHl.computeSize());
            }
            if (this.KHm != null) {
                nh += g.a.a.a.nh(5, this.KHm.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.BsF) + g.a.a.b.b.a.bu(7, this.BsG) + g.a.a.b.b.a.bu(8, this.BsH) + g.a.a.b.b.a.bu(9, this.CreateTime) + g.a.a.b.b.a.r(10, this.Brn);
            if (this.LbJ != null) {
                bu += g.a.a.b.b.a.f(11, this.LbJ);
            }
            if (this.KMl != null) {
                bu += g.a.a.b.b.a.f(12, this.KMl);
            }
            if (this.KHq != null) {
                bu += g.a.a.b.b.a.f(13, this.KHq);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.LbO);
            AppMethodBeat.o(152720);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar5 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152720);
                throw bVar5;
            } else if (this.NlB == null) {
                b bVar6 = new b("Not all required fields were included: ClientImgId");
                AppMethodBeat.o(152720);
                throw bVar6;
            } else if (this.KHl == null) {
                b bVar7 = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(152720);
                throw bVar7;
            } else if (this.KHm == null) {
                b bVar8 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(152720);
                throw bVar8;
            } else {
                AppMethodBeat.o(152720);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            env env = (env) objArr[1];
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
                        env.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152720);
                    return 0;
                case 2:
                    env.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(152720);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dpc.getNextFieldNumber(aVar5))) {
                        }
                        env.NlB = dqi;
                    }
                    AppMethodBeat.o(152720);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        env.KHl = dqi2;
                    }
                    AppMethodBeat.o(152720);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi3.populateBuilderWithField(aVar7, dqi3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        env.KHm = dqi3;
                    }
                    AppMethodBeat.o(152720);
                    return 0;
                case 6:
                    env.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(152720);
                    return 0;
                case 7:
                    env.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(152720);
                    return 0;
                case 8:
                    env.BsH = aVar3.UbS.zi();
                    AppMethodBeat.o(152720);
                    return 0;
                case 9:
                    env.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(152720);
                    return 0;
                case 10:
                    env.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(152720);
                    return 0;
                case 11:
                    env.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(152720);
                    return 0;
                case 12:
                    env.KMl = aVar3.UbS.readString();
                    AppMethodBeat.o(152720);
                    return 0;
                case 13:
                    env.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(152720);
                    return 0;
                case 14:
                    env.LbO = aVar3.UbS.zi();
                    AppMethodBeat.o(152720);
                    return 0;
                default:
                    AppMethodBeat.o(152720);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152720);
            return -1;
        }
    }
}
