package com.tencent.mm.plugin.ext.a;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.id;
import com.tencent.mm.plugin.ext.a.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B5\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u000b¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/ext/db/ManufacturerWxaTokenInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/ext/db/WxaTokenInfo;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", SharePluginInfo.ISSUE_KEY_TABLE, "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "addToken", "", "token", "userName", OpenSDKTool4Assistant.EXTRA_UIN, "", "appid", "getAllInfo", "", "getInfo", "Companion", "app_release"})
public final class a extends MAutoStorage<b> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(id.ajs(), "WxaTokenInfo")};
    public static final C1030a sMv = new C1030a((byte) 0);

    private a(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(h hVar) {
        this(hVar, b.access$getInfo$cp(), "WxaTokenInfo");
        p.h(hVar, "dataDB");
        b.a aVar = b.sMw;
        AppMethodBeat.i(39596);
        AppMethodBeat.o(39596);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/ext/db/ManufacturerWxaTokenInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "app_release"})
    /* renamed from: com.tencent.mm.plugin.ext.a.a$a  reason: collision with other inner class name */
    public static final class C1030a {
        private C1030a() {
        }

        public /* synthetic */ C1030a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(39597);
        AppMethodBeat.o(39597);
    }

    public final b arm(String str) {
        AppMethodBeat.i(39595);
        p.h(str, "token");
        b bVar = new b();
        bVar.field_token = str;
        if (!get(bVar, new String[0])) {
            AppMethodBeat.o(39595);
            return null;
        }
        AppMethodBeat.o(39595);
        return bVar;
    }
}
