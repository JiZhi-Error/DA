package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ii;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalLikeMsgDao;", "Lcom/tencent/mm/autogen/table/BaseFestivalLikeMsg;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-festival_release"})
public final class j extends ii {
    public static final String[] INDEX_CREATE = ii.INDEX_CREATE;
    public static final String TABLE_NAME = TABLE_NAME;
    public static final a Uym = new a((byte) 0);
    public static final IAutoDBItem.MAutoDBInfo kLR = ii.ajs();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R8\u0010\u0006\u001a(\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\b0\b \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u00078\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\b8\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalLikeMsgDao$Companion;", "", "()V", "DB_INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "INDEX_CREATE", "", "", "[Ljava/lang/String;", "TABLE_NAME", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(262992);
        AppMethodBeat.o(262992);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(262991);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = kLR;
        p.g(mAutoDBInfo, "DB_INFO");
        AppMethodBeat.o(262991);
        return mAutoDBInfo;
    }
}
