package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class GetEmotionRewardResponse extends dpc {
    public int DonorNum;
    public LinkedList<EmotionDonor> Donors = new LinkedList<>();
    public LinkedList<EmotionPrice> Price = new LinkedList<>();
    public ajg Reward;

    public GetEmotionRewardResponse() {
        AppMethodBeat.i(104803);
        AppMethodBeat.o(104803);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104804);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104804);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.Price);
            aVar.aM(3, this.DonorNum);
            aVar.e(4, 8, this.Donors);
            if (this.Reward != null) {
                aVar.ni(5, this.Reward.computeSize());
                this.Reward.writeFields(aVar);
            }
            AppMethodBeat.o(104804);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Price) + g.a.a.b.b.a.bu(3, this.DonorNum) + g.a.a.a.c(4, 8, this.Donors);
            if (this.Reward != null) {
                nh += g.a.a.a.nh(5, this.Reward.computeSize());
            }
            AppMethodBeat.o(104804);
            return nh;
        } else if (i2 == 2) {
            this.Price.clear();
            this.Donors.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104804);
                throw bVar2;
            }
            AppMethodBeat.o(104804);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            GetEmotionRewardResponse getEmotionRewardResponse = (GetEmotionRewardResponse) objArr[1];
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
                        getEmotionRewardResponse.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104804);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        EmotionPrice emotionPrice = new EmotionPrice();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = emotionPrice.populateBuilderWithField(aVar5, emotionPrice, dpc.getNextFieldNumber(aVar5))) {
                        }
                        getEmotionRewardResponse.Price.add(emotionPrice);
                    }
                    AppMethodBeat.o(104804);
                    return 0;
                case 3:
                    getEmotionRewardResponse.DonorNum = aVar3.UbS.zi();
                    AppMethodBeat.o(104804);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        EmotionDonor emotionDonor = new EmotionDonor();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = emotionDonor.populateBuilderWithField(aVar6, emotionDonor, dpc.getNextFieldNumber(aVar6))) {
                        }
                        getEmotionRewardResponse.Donors.add(emotionDonor);
                    }
                    AppMethodBeat.o(104804);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ajg ajg = new ajg();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ajg.populateBuilderWithField(aVar7, ajg, dpc.getNextFieldNumber(aVar7))) {
                        }
                        getEmotionRewardResponse.Reward = ajg;
                    }
                    AppMethodBeat.o(104804);
                    return 0;
                default:
                    AppMethodBeat.o(104804);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104804);
            return -1;
        }
    }
}
