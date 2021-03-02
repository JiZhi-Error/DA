package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class EmotionDesigner extends a {
    public String BigImgUrl;
    public String Desc;
    public String Motto;
    public String SmallImgUrl;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104775);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.SmallImgUrl != null) {
                aVar.e(2, this.SmallImgUrl);
            }
            if (this.BigImgUrl != null) {
                aVar.e(3, this.BigImgUrl);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.Motto != null) {
                aVar.e(5, this.Motto);
            }
            AppMethodBeat.o(104775);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.SmallImgUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.SmallImgUrl);
            }
            if (this.BigImgUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.BigImgUrl);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.Motto != null) {
                f2 += g.a.a.b.b.a.f(5, this.Motto);
            }
            AppMethodBeat.o(104775);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104775);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            EmotionDesigner emotionDesigner = (EmotionDesigner) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionDesigner.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(104775);
                    return 0;
                case 2:
                    emotionDesigner.SmallImgUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104775);
                    return 0;
                case 3:
                    emotionDesigner.BigImgUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104775);
                    return 0;
                case 4:
                    emotionDesigner.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(104775);
                    return 0;
                case 5:
                    emotionDesigner.Motto = aVar3.UbS.readString();
                    AppMethodBeat.o(104775);
                    return 0;
                default:
                    AppMethodBeat.o(104775);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104775);
            return -1;
        }
    }
}
