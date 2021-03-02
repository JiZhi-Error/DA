package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessStatsStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessRecord;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "getDb$plugin_appbrand_integration_release", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "Companion", "plugin-appbrand-integration_release"})
public final class c extends com.tencent.mm.plugin.appbrand.ab.c<b> {
    @Deprecated
    public static final a nwc = new a((byte) 0);
    final ISQLiteDatabaseEx kOg;

    static {
        AppMethodBeat.i(50954);
        AppMethodBeat.o(50954);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ISQLiteDatabaseEx iSQLiteDatabaseEx) {
        super(iSQLiteDatabaseEx, b.iBg, "WxaAppWebRenderingCacheAccessStatsTable", null);
        p.h(iSQLiteDatabaseEx, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(50953);
        this.kOg = iSQLiteDatabaseEx;
        AppMethodBeat.o(50953);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessStatsStorage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
