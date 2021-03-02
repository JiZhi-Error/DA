package com.tencent.mm.plugin.secdata.a;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0002J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/secdata/model/SecDataDB;", "", "dbFilePath", "", "(Ljava/lang/String;)V", "TAG", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/storagebase/SqliteDB;", "close", "", "collectFinderDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "execSQL", "tableName", SharePluginInfo.ISSUE_KEY_SQL, "getDB", "getTableCount", "isTableExist", "", "plugin-sec-data_release"})
public final class a {
    public final String TAG = "MicroMsg.SecData.SecDataDB";
    public h iFy;

    public a(String str) {
        p.h(str, "dbFilePath");
        AppMethodBeat.i(219172);
        long currentTimeMillis = System.currentTimeMillis();
        this.iFy = new h();
        h hVar = this.iFy;
        if (hVar != null) {
            HashMap<Integer, h.b> hashMap = new HashMap<>();
            hashMap.put(Integer.valueOf("SecReportDataInfo".hashCode()), C1685a.CWi);
            if (!hVar.a(str, hashMap, true)) {
                RuntimeException runtimeException = new RuntimeException("Create SecDataDB Fail!");
                AppMethodBeat.o(219172);
                throw runtimeException;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Log.i(this.TAG, "initDB index params %d %s %s", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Util.getSizeMB(s.boW(str), 100.0d), str);
        AppMethodBeat.o(219172);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    /* renamed from: com.tencent.mm.plugin.secdata.a.a$a  reason: collision with other inner class name */
    static final class C1685a implements h.b {
        public static final C1685a CWi = new C1685a();

        static {
            AppMethodBeat.i(219171);
            AppMethodBeat.o(219171);
        }

        C1685a() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(219170);
            d.a aVar = d.CWm;
            String[] eSq = d.eSq();
            AppMethodBeat.o(219170);
            return eSq;
        }
    }
}
