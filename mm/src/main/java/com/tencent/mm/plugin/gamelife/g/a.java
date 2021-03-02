package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage;", "Lcom/tencent/mm/autogen/table/BaseGameLifeAppMessage;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toWxAppMessage", "Lcom/tencent/mm/message/AppMessage;", "Companion", "plugin-gamelife_release"})
public final class a extends cy {
    private static final IAutoDBItem.MAutoDBInfo info = cy.ajs();
    public static final C1420a ych = new C1420a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage$Companion;", "", "()V", "TABLE_NAME", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
    /* renamed from: com.tencent.mm.plugin.gamelife.g.a$a  reason: collision with other inner class name */
    public static final class C1420a {
        private C1420a() {
        }

        public /* synthetic */ C1420a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241391);
        AppMethodBeat.o(241391);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(241390);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = info;
        p.g(mAutoDBInfo, "info");
        AppMethodBeat.o(241390);
        return mAutoDBInfo;
    }
}
