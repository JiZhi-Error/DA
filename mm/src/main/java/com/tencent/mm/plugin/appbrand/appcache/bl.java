package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J!\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0002¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoRecord;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "getPluginStringVersion", "", "id", "version", "", "hasRecord", "", "record", "insertOrUpdate", "runInDataBaseTransaction", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "setPluginStringVersion", "", "stringVersion", "Companion", "data-storage_release"})
public final class bl extends c<bk> {
    @Deprecated
    public static final a kOh = new a((byte) 0);
    private final ISQLiteDatabaseEx kOg;

    static {
        AppMethodBeat.i(229805);
        AppMethodBeat.o(229805);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bl(ISQLiteDatabaseEx iSQLiteDatabaseEx) {
        super(iSQLiteDatabaseEx, bk.iBg, "WxaPluginCodeVersionInfo", bk.INDEX_CREATE);
        p.h(iSQLiteDatabaseEx, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(229804);
        this.kOg = iSQLiteDatabaseEx;
        AppMethodBeat.o(229804);
    }

    public static final /* synthetic */ boolean a(bl blVar, bk bkVar) {
        AppMethodBeat.i(229806);
        boolean a2 = blVar.a(bkVar);
        AppMethodBeat.o(229806);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage$Companion;", "", "()V", "TAG", "", "data-storage_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String ba(String str, int i2) {
        String str2;
        AppMethodBeat.i(182794);
        p.h(str, "id");
        bk bkVar = new bk();
        bkVar.field_pluginAppID = str;
        bkVar.field_pluginAppVersion = i2;
        if (get(bkVar, new String[0])) {
            str2 = bkVar.field_pluginStringVersion;
        } else {
            str2 = null;
        }
        Log.i("Luggage.WxaPluginCodeVersionInfoStorage", "getPluginStringVersion with id:" + str + " version:" + i2 + ", returns:" + str2);
        AppMethodBeat.o(182794);
        return str2;
    }

    public final <R> R s(kotlin.g.a.a<? extends R> aVar) {
        AppMethodBeat.i(229802);
        ISQLiteDatabaseEx iSQLiteDatabaseEx = this.kOg;
        Thread currentThread = Thread.currentThread();
        p.g(currentThread, "Thread.currentThread()");
        long beginTransaction = iSQLiteDatabaseEx.beginTransaction(currentThread.getId());
        try {
            return (R) aVar.invoke();
        } finally {
            this.kOg.endTransaction(beginTransaction);
            AppMethodBeat.o(229802);
        }
    }

    private final boolean a(bk bkVar) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(229803);
        Cursor rawQuery = this.kOg.rawQuery("select count(*) from " + getTableName() + " where pluginAppID=? and pluginAppVersion=?", new String[]{bkVar.field_pluginAppID, String.valueOf(bkVar.field_pluginAppVersion)});
        if (rawQuery != null) {
            Cursor cursor = rawQuery;
            try {
                Cursor cursor2 = cursor;
                boolean z = cursor2.moveToFirst() ? cursor2.getInt(0) > 0 : false;
                kotlin.f.b.a(cursor, null);
                AppMethodBeat.o(229803);
                return z;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                kotlin.f.b.a(cursor, th2);
                AppMethodBeat.o(229803);
                throw th;
            }
        } else {
            AppMethodBeat.o(229803);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ bl kOi;
        final /* synthetic */ bk kOj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(bl blVar, bk bkVar) {
            super(0);
            this.kOi = blVar;
            this.kOj = bkVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean insert;
            AppMethodBeat.i(229801);
            if (bl.a(this.kOi, this.kOj)) {
                insert = this.kOi.update(this.kOj, new String[0]);
            } else {
                insert = this.kOi.insert(this.kOj);
            }
            Boolean valueOf = Boolean.valueOf(insert);
            AppMethodBeat.o(229801);
            return valueOf;
        }
    }
}
