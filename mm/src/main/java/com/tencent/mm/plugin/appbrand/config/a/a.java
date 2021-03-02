package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "Lcom/tencent/mm/autogen/table/BaseAppBrandPrefetchWxaAttrsMarkTable;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-appbrand-integration_release"})
public final class a extends r {
    public static final IAutoDBItem.MAutoDBInfo iBg = r.ajs();
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(iBg, "AppBrandPrefetchWxaAttrsMarkTable")};
    public static final C0562a lhs = new C0562a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00040\u00040\t8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo$Companion;", "", "()V", "COL_PREFETCHUPDATETIME", "", "COL_USERNAME", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE_CREATE", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.a$a  reason: collision with other inner class name */
    public static final class C0562a {
        private C0562a() {
        }

        public /* synthetic */ C0562a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(228171);
        AppMethodBeat.o(228171);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }
}
