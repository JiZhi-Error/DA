package com.tencent.mm.plugin.textstatus.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusLike;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-textstatus_release"})
public final class b extends com.tencent.mm.plugin.textstatus.h.b {
    private static final IAutoDBItem.MAutoDBInfo FZC = com.tencent.mm.plugin.textstatus.h.b.ajs();
    private static final int FZE = 0;
    private static final int FZF = 1;
    public static final a FZG = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike$Companion;", "", "()V", "ACTION_TYPE_LIKE", "", "getACTION_TYPE_LIKE", "()I", "ACTION_TYPE_UNLIKE", "getACTION_TYPE_UNLIKE", "TAG", "", "_dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "get_dbInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(216252);
        AppMethodBeat.o(216252);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(216251);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = FZC;
        p.g(mAutoDBInfo, "_dbInfo");
        AppMethodBeat.o(216251);
        return mAutoDBInfo;
    }
}
