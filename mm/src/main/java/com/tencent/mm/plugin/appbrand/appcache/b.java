package com.tencent.mm.plugin.appbrand.appcache;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkRecord;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearMark", "", "appId", "", "getMark", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "appVersion", "", "insertOrUpdate", "record", "block", "Lkotlin/Function1;", "", "setMark", "mark", "MARK", "plugin-appbrand-integration_release"})
public final class b extends c<a> {
    private final ISQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.iBg, "AppBrandSeparatedPluginsCompatMarkTable", a.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(180424);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(180424);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "", "intValue", "", "(Ljava/lang/String;II)V", "toInt", "NONE", "NOT_USED", "USED", "Companion", "plugin-appbrand-integration_release"})
    public enum a {
        NONE(-1),
        NOT_USED(0),
        USED(1);
        
        public static final C0546a kKc = new C0546a((byte) 0);
        final int intValue;

        public static a valueOf(String str) {
            AppMethodBeat.i(180419);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(180419);
            return aVar;
        }

        private a(int i2) {
            this.intValue = i2;
        }

        static {
            AppMethodBeat.i(180417);
            AppMethodBeat.o(180417);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK$Companion;", "", "()V", "valueOfInt", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "intValue", "", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b$a$a  reason: collision with other inner class name */
        public static final class C0546a {
            private C0546a() {
            }

            public /* synthetic */ C0546a(byte b2) {
                this();
            }
        }
    }

    public final boolean UO(String str) {
        boolean z;
        AppMethodBeat.i(180421);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(180421);
            return false;
        }
        if (this.db.delete(getTableName(), "appId=?", new String[]{str}) > 0) {
            AppMethodBeat.o(180421);
            return true;
        }
        AppMethodBeat.o(180421);
        return false;
    }

    public final a aM(String str, int i2) {
        a aVar;
        AppMethodBeat.i(180423);
        p.h(str, "appId");
        a aVar2 = new a();
        aVar2.field_appId = str;
        aVar2.field_appVersion = i2;
        if (!super.get(aVar2, new String[0])) {
            aVar2.field_isSeparatedPluginsUsed = a.NONE.intValue;
        }
        a.C0546a aVar3 = a.kKc;
        int i3 = aVar2.field_isSeparatedPluginsUsed;
        a[] values = a.values();
        int length = values.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                aVar = null;
                break;
            }
            aVar = values[i4];
            if (aVar.intValue == i3) {
                break;
            }
            i4++;
        }
        if (aVar == null) {
            aVar = a.NONE;
        }
        AppMethodBeat.o(180423);
        return aVar;
    }
}
