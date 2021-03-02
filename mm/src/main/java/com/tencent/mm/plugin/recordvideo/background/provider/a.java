package com.tencent.mm.plugin.recordvideo.background.provider;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hu;
import com.tencent.mm.plugin.recordvideo.background.provider.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "plugin-recordvideo_release"})
public final class a extends MAutoStorage<hu> {
    public static final C1645a BMs = new C1645a((byte) 0);
    private static final String[] SQL_CREATE;
    private static final String TABLE = b.eIM();
    private static final String TAG = TAG;
    private final ISQLiteDatabase db;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(com.tencent.mm.sdk.storage.ISQLiteDatabase r5) {
        /*
            r4 = this;
            r3 = 75327(0x1263f, float:1.05556E-40)
            java.lang.String r0 = "db"
            kotlin.g.b.p.h(r5, r0)
            com.tencent.mm.plugin.recordvideo.background.provider.b$a r0 = com.tencent.mm.plugin.recordvideo.background.provider.b.BMF
            com.tencent.mm.sdk.storage.IAutoDBItem$MAutoDBInfo r0 = com.tencent.mm.plugin.recordvideo.background.provider.b.eIL()
            com.tencent.mm.plugin.recordvideo.background.provider.b$a r1 = com.tencent.mm.plugin.recordvideo.background.provider.b.BMF
            java.lang.String r1 = com.tencent.mm.plugin.recordvideo.background.provider.b.eIM()
            com.tencent.mm.plugin.recordvideo.background.provider.b$a r2 = com.tencent.mm.plugin.recordvideo.background.provider.b.BMF
            java.lang.String[] r2 = com.tencent.mm.plugin.recordvideo.background.provider.b.eIN()
            r4.<init>(r5, r0, r1, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            r4.db = r5
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.background.provider.a.<init>(com.tencent.mm.sdk.storage.ISQLiteDatabase):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.background.provider.a$a  reason: collision with other inner class name */
    public static final class C1645a {
        private C1645a() {
        }

        public /* synthetic */ C1645a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(75328);
        b.a aVar = b.BMF;
        IAutoDBItem.MAutoDBInfo eIL = b.eIL();
        b.a aVar2 = b.BMF;
        SQL_CREATE = new String[]{MAutoStorage.getCreateSQLs(eIL, b.eIM())};
        b.a aVar3 = b.BMF;
        AppMethodBeat.o(75328);
    }
}
