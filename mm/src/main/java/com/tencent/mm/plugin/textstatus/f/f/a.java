package com.tencent.mm.plugin.textstatus.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatus;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "isBlur", "", "isRead", "toString", "", "Companion", "plugin-textstatus_release"})
public final class a extends com.tencent.mm.plugin.textstatus.h.a {
    private static final IAutoDBItem.MAutoDBInfo FZC = com.tencent.mm.plugin.textstatus.h.a.ajs();
    public static final C1821a FZD = new C1821a((byte) 0);
    private static final int VdH = 1;
    private static final int VdI = 2;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem$Companion;", "", "()V", "STATE_READ", "", "getSTATE_READ", "()I", "STATE_UNKNOWN", "getSTATE_UNKNOWN", "STATE_UNREAD", "getSTATE_UNREAD", "TAG", "", "TEXT_STATUS_OPTION_BLUR", "", "_dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "get_dbInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.f.f.a$a  reason: collision with other inner class name */
    public static final class C1821a {
        private C1821a() {
        }

        public /* synthetic */ C1821a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(216250);
        AppMethodBeat.o(216250);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(216246);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = FZC;
        p.g(mAutoDBInfo, "_dbInfo");
        AppMethodBeat.o(216246);
        return mAutoDBInfo;
    }

    public final w fvU() {
        AppMethodBeat.i(216247);
        w wVar = new w();
        if (this.field_TopicInfo != null) {
            wVar.parseFrom(this.field_TopicInfo);
        }
        AppMethodBeat.o(216247);
        return wVar;
    }

    public final boolean hXp() {
        return this.field_state == VdI;
    }

    public final boolean fvV() {
        AppMethodBeat.i(216248);
        if ((this.field_option.longValue() & 1) != 0) {
            AppMethodBeat.o(216248);
            return true;
        }
        AppMethodBeat.o(216248);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(216249);
        String str = "TSItem() statusId:" + this.field_StatusID + " ,TopicId:" + this.field_TopicId + ",sourceId:" + this.field_SourceID + ",IconID:" + this.field_IconID + ",MediaType:" + this.field_MediaType + ",mediaUrl:" + this.field_MediaUrl + ",thumb:" + this.field_MediaThumbUrl + "state:" + this.field_state + ",bid:" + this.field_backgroundId + ",likeCont:" + this.field_LikeCount + ",mwidth" + this.field_mediaWidth + ",mheight" + this.field_mediaHeight + ",etime:" + this.field_ExpireTime;
        AppMethodBeat.o(216249);
        return str;
    }
}
