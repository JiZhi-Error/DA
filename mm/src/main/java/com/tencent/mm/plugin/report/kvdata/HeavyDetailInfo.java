package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class HeavyDetailInfo extends a {
    public long chatroom_;
    public long contact_;
    public long conversation_;
    public long dbSize_;
    public long favDbSize_;
    public long flag_;
    public long message_;
    public long sdFileRatio_;
    public long sdFileSize_;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151534);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.flag_);
            aVar.bb(2, this.sdFileSize_);
            aVar.bb(3, this.sdFileRatio_);
            aVar.bb(4, this.dbSize_);
            aVar.bb(5, this.message_);
            aVar.bb(6, this.conversation_);
            aVar.bb(7, this.contact_);
            aVar.bb(8, this.chatroom_);
            aVar.bb(9, this.favDbSize_);
            AppMethodBeat.o(151534);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.flag_) + 0 + g.a.a.b.b.a.r(2, this.sdFileSize_) + g.a.a.b.b.a.r(3, this.sdFileRatio_) + g.a.a.b.b.a.r(4, this.dbSize_) + g.a.a.b.b.a.r(5, this.message_) + g.a.a.b.b.a.r(6, this.conversation_) + g.a.a.b.b.a.r(7, this.contact_) + g.a.a.b.b.a.r(8, this.chatroom_) + g.a.a.b.b.a.r(9, this.favDbSize_);
            AppMethodBeat.o(151534);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151534);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            HeavyDetailInfo heavyDetailInfo = (HeavyDetailInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    heavyDetailInfo.flag_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151534);
                    return 0;
                case 2:
                    heavyDetailInfo.sdFileSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151534);
                    return 0;
                case 3:
                    heavyDetailInfo.sdFileRatio_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151534);
                    return 0;
                case 4:
                    heavyDetailInfo.dbSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151534);
                    return 0;
                case 5:
                    heavyDetailInfo.message_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151534);
                    return 0;
                case 6:
                    heavyDetailInfo.conversation_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151534);
                    return 0;
                case 7:
                    heavyDetailInfo.contact_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151534);
                    return 0;
                case 8:
                    heavyDetailInfo.chatroom_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151534);
                    return 0;
                case 9:
                    heavyDetailInfo.favDbSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151534);
                    return 0;
                default:
                    AppMethodBeat.o(151534);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151534);
            return -1;
        }
    }
}
