package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bsp extends dpc {
    public String Desc;
    public LinkedList<EmotionSummary> EmotionList = new LinkedList<>();
    public String HeadUrl;
    public String KOR;
    public LinkedList<ait> KOp = new LinkedList<>();
    public String LZs;
    public String Name;
    public SKBuiltinBuffer_t ReqBuf;

    public bsp() {
        AppMethodBeat.i(104811);
        AppMethodBeat.o(104811);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104812);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104812);
                throw bVar;
            } else if (this.LZs == null) {
                b bVar2 = new b("Not all required fields were included: BannerUrl");
                AppMethodBeat.o(104812);
                throw bVar2;
            } else if (this.Name == null) {
                b bVar3 = new b("Not all required fields were included: Name");
                AppMethodBeat.o(104812);
                throw bVar3;
            } else if (this.Desc == null) {
                b bVar4 = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(104812);
                throw bVar4;
            } else if (this.HeadUrl == null) {
                b bVar5 = new b("Not all required fields were included: HeadUrl");
                AppMethodBeat.o(104812);
                throw bVar5;
            } else if (this.KOR == null) {
                b bVar6 = new b("Not all required fields were included: BizName");
                AppMethodBeat.o(104812);
                throw bVar6;
            } else if (this.ReqBuf == null) {
                b bVar7 = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104812);
                throw bVar7;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.LZs != null) {
                    aVar.e(2, this.LZs);
                }
                if (this.Name != null) {
                    aVar.e(3, this.Name);
                }
                if (this.Desc != null) {
                    aVar.e(4, this.Desc);
                }
                if (this.HeadUrl != null) {
                    aVar.e(5, this.HeadUrl);
                }
                if (this.KOR != null) {
                    aVar.e(6, this.KOR);
                }
                aVar.e(7, 8, this.EmotionList);
                if (this.ReqBuf != null) {
                    aVar.ni(8, this.ReqBuf.computeSize());
                    this.ReqBuf.writeFields(aVar);
                }
                aVar.e(9, 8, this.KOp);
                AppMethodBeat.o(104812);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LZs != null) {
                nh += g.a.a.b.b.a.f(2, this.LZs);
            }
            if (this.Name != null) {
                nh += g.a.a.b.b.a.f(3, this.Name);
            }
            if (this.Desc != null) {
                nh += g.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.HeadUrl != null) {
                nh += g.a.a.b.b.a.f(5, this.HeadUrl);
            }
            if (this.KOR != null) {
                nh += g.a.a.b.b.a.f(6, this.KOR);
            }
            int c2 = nh + g.a.a.a.c(7, 8, this.EmotionList);
            if (this.ReqBuf != null) {
                c2 += g.a.a.a.nh(8, this.ReqBuf.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(9, 8, this.KOp);
            AppMethodBeat.o(104812);
            return c3;
        } else if (i2 == 2) {
            this.EmotionList.clear();
            this.KOp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar8 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104812);
                throw bVar8;
            } else if (this.LZs == null) {
                b bVar9 = new b("Not all required fields were included: BannerUrl");
                AppMethodBeat.o(104812);
                throw bVar9;
            } else if (this.Name == null) {
                b bVar10 = new b("Not all required fields were included: Name");
                AppMethodBeat.o(104812);
                throw bVar10;
            } else if (this.Desc == null) {
                b bVar11 = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(104812);
                throw bVar11;
            } else if (this.HeadUrl == null) {
                b bVar12 = new b("Not all required fields were included: HeadUrl");
                AppMethodBeat.o(104812);
                throw bVar12;
            } else if (this.KOR == null) {
                b bVar13 = new b("Not all required fields were included: BizName");
                AppMethodBeat.o(104812);
                throw bVar13;
            } else if (this.ReqBuf == null) {
                b bVar14 = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104812);
                throw bVar14;
            } else {
                AppMethodBeat.o(104812);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bsp bsp = (bsp) objArr[1];
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
                        bsp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104812);
                    return 0;
                case 2:
                    bsp.LZs = aVar3.UbS.readString();
                    AppMethodBeat.o(104812);
                    return 0;
                case 3:
                    bsp.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(104812);
                    return 0;
                case 4:
                    bsp.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(104812);
                    return 0;
                case 5:
                    bsp.HeadUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104812);
                    return 0;
                case 6:
                    bsp.KOR = aVar3.UbS.readString();
                    AppMethodBeat.o(104812);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        EmotionSummary emotionSummary = new EmotionSummary();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = emotionSummary.populateBuilderWithField(aVar5, emotionSummary, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bsp.EmotionList.add(emotionSummary);
                    }
                    AppMethodBeat.o(104812);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bsp.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104812);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ait ait = new ait();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ait.populateBuilderWithField(aVar7, ait, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bsp.KOp.add(ait);
                    }
                    AppMethodBeat.o(104812);
                    return 0;
                default:
                    AppMethodBeat.o(104812);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104812);
            return -1;
        }
    }
}
