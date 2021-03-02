package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class GetEmotionListResponse extends dpc {
    public EmotionBanner Banner;
    public int BannerSetCount;
    public LinkedList<EmotionBannerSet> BannerSetList = new LinkedList<>();
    public int CellCount;
    public LinkedList<EmotionCell> CellList = new LinkedList<>();
    public int CellSetCount;
    public LinkedList<EmotionBannerSet> CellSetList = new LinkedList<>();
    public int EmotionCount;
    public String EmotionExptConfig;
    public LinkedList<EmotionSummary> EmotionList = new LinkedList<>();
    public int NewBannerCount;
    public LinkedList<EmotionBanner> NewBannerList = new LinkedList<>();
    public int RecentHotNum;
    public SKBuiltinBuffer_t ReqBuf;
    public int TopHotNum;

    public GetEmotionListResponse() {
        AppMethodBeat.i(104800);
        AppMethodBeat.o(104800);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104801);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104801);
                throw bVar;
            } else if (this.ReqBuf == null) {
                b bVar2 = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104801);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.ReqBuf != null) {
                    aVar.ni(2, this.ReqBuf.computeSize());
                    this.ReqBuf.writeFields(aVar);
                }
                aVar.aM(3, this.EmotionCount);
                aVar.e(4, 8, this.EmotionList);
                if (this.Banner != null) {
                    aVar.ni(5, this.Banner.computeSize());
                    this.Banner.writeFields(aVar);
                }
                aVar.aM(6, this.NewBannerCount);
                aVar.e(7, 8, this.NewBannerList);
                aVar.aM(8, this.CellCount);
                aVar.e(9, 8, this.CellList);
                aVar.aM(10, this.BannerSetCount);
                aVar.e(11, 8, this.BannerSetList);
                aVar.aM(12, this.TopHotNum);
                aVar.aM(13, this.RecentHotNum);
                aVar.aM(14, this.CellSetCount);
                aVar.e(15, 8, this.CellSetList);
                if (this.EmotionExptConfig != null) {
                    aVar.e(16, this.EmotionExptConfig);
                }
                AppMethodBeat.o(104801);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.ReqBuf != null) {
                nh += g.a.a.a.nh(2, this.ReqBuf.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.EmotionCount) + g.a.a.a.c(4, 8, this.EmotionList);
            if (this.Banner != null) {
                bu += g.a.a.a.nh(5, this.Banner.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.NewBannerCount) + g.a.a.a.c(7, 8, this.NewBannerList) + g.a.a.b.b.a.bu(8, this.CellCount) + g.a.a.a.c(9, 8, this.CellList) + g.a.a.b.b.a.bu(10, this.BannerSetCount) + g.a.a.a.c(11, 8, this.BannerSetList) + g.a.a.b.b.a.bu(12, this.TopHotNum) + g.a.a.b.b.a.bu(13, this.RecentHotNum) + g.a.a.b.b.a.bu(14, this.CellSetCount) + g.a.a.a.c(15, 8, this.CellSetList);
            if (this.EmotionExptConfig != null) {
                bu2 += g.a.a.b.b.a.f(16, this.EmotionExptConfig);
            }
            AppMethodBeat.o(104801);
            return bu2;
        } else if (i2 == 2) {
            this.EmotionList.clear();
            this.NewBannerList.clear();
            this.CellList.clear();
            this.BannerSetList.clear();
            this.CellSetList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104801);
                throw bVar3;
            } else if (this.ReqBuf == null) {
                b bVar4 = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104801);
                throw bVar4;
            } else {
                AppMethodBeat.o(104801);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            GetEmotionListResponse getEmotionListResponse = (GetEmotionListResponse) objArr[1];
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
                        getEmotionListResponse.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104801);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        getEmotionListResponse.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104801);
                    return 0;
                case 3:
                    getEmotionListResponse.EmotionCount = aVar3.UbS.zi();
                    AppMethodBeat.o(104801);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        EmotionSummary emotionSummary = new EmotionSummary();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = emotionSummary.populateBuilderWithField(aVar6, emotionSummary, dpc.getNextFieldNumber(aVar6))) {
                        }
                        getEmotionListResponse.EmotionList.add(emotionSummary);
                    }
                    AppMethodBeat.o(104801);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        EmotionBanner emotionBanner = new EmotionBanner();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = emotionBanner.populateBuilderWithField(aVar7, emotionBanner, dpc.getNextFieldNumber(aVar7))) {
                        }
                        getEmotionListResponse.Banner = emotionBanner;
                    }
                    AppMethodBeat.o(104801);
                    return 0;
                case 6:
                    getEmotionListResponse.NewBannerCount = aVar3.UbS.zi();
                    AppMethodBeat.o(104801);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        EmotionBanner emotionBanner2 = new EmotionBanner();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = emotionBanner2.populateBuilderWithField(aVar8, emotionBanner2, dpc.getNextFieldNumber(aVar8))) {
                        }
                        getEmotionListResponse.NewBannerList.add(emotionBanner2);
                    }
                    AppMethodBeat.o(104801);
                    return 0;
                case 8:
                    getEmotionListResponse.CellCount = aVar3.UbS.zi();
                    AppMethodBeat.o(104801);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        EmotionCell emotionCell = new EmotionCell();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = emotionCell.populateBuilderWithField(aVar9, emotionCell, dpc.getNextFieldNumber(aVar9))) {
                        }
                        getEmotionListResponse.CellList.add(emotionCell);
                    }
                    AppMethodBeat.o(104801);
                    return 0;
                case 10:
                    getEmotionListResponse.BannerSetCount = aVar3.UbS.zi();
                    AppMethodBeat.o(104801);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        EmotionBannerSet emotionBannerSet = new EmotionBannerSet();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = emotionBannerSet.populateBuilderWithField(aVar10, emotionBannerSet, dpc.getNextFieldNumber(aVar10))) {
                        }
                        getEmotionListResponse.BannerSetList.add(emotionBannerSet);
                    }
                    AppMethodBeat.o(104801);
                    return 0;
                case 12:
                    getEmotionListResponse.TopHotNum = aVar3.UbS.zi();
                    AppMethodBeat.o(104801);
                    return 0;
                case 13:
                    getEmotionListResponse.RecentHotNum = aVar3.UbS.zi();
                    AppMethodBeat.o(104801);
                    return 0;
                case 14:
                    getEmotionListResponse.CellSetCount = aVar3.UbS.zi();
                    AppMethodBeat.o(104801);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        EmotionBannerSet emotionBannerSet2 = new EmotionBannerSet();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = emotionBannerSet2.populateBuilderWithField(aVar11, emotionBannerSet2, dpc.getNextFieldNumber(aVar11))) {
                        }
                        getEmotionListResponse.CellSetList.add(emotionBannerSet2);
                    }
                    AppMethodBeat.o(104801);
                    return 0;
                case 16:
                    getEmotionListResponse.EmotionExptConfig = aVar3.UbS.readString();
                    AppMethodBeat.o(104801);
                    return 0;
                default:
                    AppMethodBeat.o(104801);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104801);
            return -1;
        }
    }
}
