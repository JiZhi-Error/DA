package com.tencent.mm.plugin.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.de;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/game/download/GameResourceDownload;", "Lcom/tencent/mm/autogen/table/BaseGameResourceDownload;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-game_release"})
public final class a extends de {
    private static final IAutoDBItem.MAutoDBInfo info;
    public static final C1393a xvK = new C1393a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/game/download/GameResourceDownload$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-game_release"})
    /* renamed from: com.tencent.mm.plugin.game.c.a$a  reason: collision with other inner class name */
    public static final class C1393a {
        private C1393a() {
        }

        public /* synthetic */ C1393a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(204329);
        IAutoDBItem.MAutoDBInfo ajs = de.ajs();
        p.g(ajs, "initAutoDBInfo(BaseGameR…urceDownload::class.java)");
        info = ajs;
        AppMethodBeat.o(204329);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}
