package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public class SDStatusInfo extends a {
    public long eAvailableBlockCount_;
    public int eAvailablePer_;
    public long eAvailableSize_;
    public long eBlockCount_;
    public long eBlockSize_;
    public String ePath_;
    public long eTotalSize_;
    public String fSystem_;
    public int hasUnRemovable_;
    public int ratioHeavy_;
    public String root_;
    public long sAvailableBlockCount_;
    public int sAvailablePer_;
    public long sAvailableSize_;
    public long sBlockCount_;
    public long sBlockSize_;
    public long sTotalSize_;
    public int sizeHeavy_;
    public int useExternal_;
    public int weChatPer_;
    public WeChatSDInfo weChatSDInfo_;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151538);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.weChatSDInfo_ == null) {
                b bVar = new b("Not all required fields were included: weChatSDInfo_");
                AppMethodBeat.o(151538);
                throw bVar;
            }
            if (this.weChatSDInfo_ != null) {
                aVar.ni(1, this.weChatSDInfo_.computeSize());
                this.weChatSDInfo_.writeFields(aVar);
            }
            aVar.aM(2, this.weChatPer_);
            aVar.aM(3, this.sizeHeavy_);
            aVar.aM(4, this.ratioHeavy_);
            aVar.aM(5, this.useExternal_);
            aVar.aM(6, this.hasUnRemovable_);
            aVar.bb(7, this.sBlockSize_);
            aVar.bb(8, this.sBlockCount_);
            aVar.bb(9, this.sTotalSize_);
            aVar.bb(10, this.sAvailableBlockCount_);
            aVar.bb(11, this.sAvailableSize_);
            aVar.aM(12, this.sAvailablePer_);
            aVar.bb(13, this.eBlockSize_);
            aVar.bb(14, this.eBlockCount_);
            aVar.bb(15, this.eTotalSize_);
            aVar.bb(16, this.eAvailableBlockCount_);
            aVar.bb(17, this.eAvailableSize_);
            aVar.aM(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                aVar.e(19, this.ePath_);
            }
            if (this.root_ != null) {
                aVar.e(20, this.root_);
            }
            if (this.fSystem_ != null) {
                aVar.e(21, this.fSystem_);
            }
            AppMethodBeat.o(151538);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.weChatSDInfo_ != null ? g.a.a.a.nh(1, this.weChatSDInfo_.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.weChatPer_) + g.a.a.b.b.a.bu(3, this.sizeHeavy_) + g.a.a.b.b.a.bu(4, this.ratioHeavy_) + g.a.a.b.b.a.bu(5, this.useExternal_) + g.a.a.b.b.a.bu(6, this.hasUnRemovable_) + g.a.a.b.b.a.r(7, this.sBlockSize_) + g.a.a.b.b.a.r(8, this.sBlockCount_) + g.a.a.b.b.a.r(9, this.sTotalSize_) + g.a.a.b.b.a.r(10, this.sAvailableBlockCount_) + g.a.a.b.b.a.r(11, this.sAvailableSize_) + g.a.a.b.b.a.bu(12, this.sAvailablePer_) + g.a.a.b.b.a.r(13, this.eBlockSize_) + g.a.a.b.b.a.r(14, this.eBlockCount_) + g.a.a.b.b.a.r(15, this.eTotalSize_) + g.a.a.b.b.a.r(16, this.eAvailableBlockCount_) + g.a.a.b.b.a.r(17, this.eAvailableSize_) + g.a.a.b.b.a.bu(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                nh += g.a.a.b.b.a.f(19, this.ePath_);
            }
            if (this.root_ != null) {
                nh += g.a.a.b.b.a.f(20, this.root_);
            }
            if (this.fSystem_ != null) {
                nh += g.a.a.b.b.a.f(21, this.fSystem_);
            }
            AppMethodBeat.o(151538);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.weChatSDInfo_ == null) {
                b bVar2 = new b("Not all required fields were included: weChatSDInfo_");
                AppMethodBeat.o(151538);
                throw bVar2;
            }
            AppMethodBeat.o(151538);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            SDStatusInfo sDStatusInfo = (SDStatusInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        WeChatSDInfo weChatSDInfo = new WeChatSDInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = weChatSDInfo.populateBuilderWithField(aVar4, weChatSDInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
                    }
                    AppMethodBeat.o(151538);
                    return 0;
                case 2:
                    sDStatusInfo.weChatPer_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151538);
                    return 0;
                case 3:
                    sDStatusInfo.sizeHeavy_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151538);
                    return 0;
                case 4:
                    sDStatusInfo.ratioHeavy_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151538);
                    return 0;
                case 5:
                    sDStatusInfo.useExternal_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151538);
                    return 0;
                case 6:
                    sDStatusInfo.hasUnRemovable_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151538);
                    return 0;
                case 7:
                    sDStatusInfo.sBlockSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 8:
                    sDStatusInfo.sBlockCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 9:
                    sDStatusInfo.sTotalSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 10:
                    sDStatusInfo.sAvailableBlockCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 11:
                    sDStatusInfo.sAvailableSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 12:
                    sDStatusInfo.sAvailablePer_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151538);
                    return 0;
                case 13:
                    sDStatusInfo.eBlockSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 14:
                    sDStatusInfo.eBlockCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 15:
                    sDStatusInfo.eTotalSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 16:
                    sDStatusInfo.eAvailableBlockCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 17:
                    sDStatusInfo.eAvailableSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151538);
                    return 0;
                case 18:
                    sDStatusInfo.eAvailablePer_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151538);
                    return 0;
                case 19:
                    sDStatusInfo.ePath_ = aVar3.UbS.readString();
                    AppMethodBeat.o(151538);
                    return 0;
                case 20:
                    sDStatusInfo.root_ = aVar3.UbS.readString();
                    AppMethodBeat.o(151538);
                    return 0;
                case 21:
                    sDStatusInfo.fSystem_ = aVar3.UbS.readString();
                    AppMethodBeat.o(151538);
                    return 0;
                default:
                    AppMethodBeat.o(151538);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151538);
            return -1;
        }
    }
}
