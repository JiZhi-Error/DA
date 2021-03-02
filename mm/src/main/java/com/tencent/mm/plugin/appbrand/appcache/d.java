package com.tencent.mm.plugin.appbrand.appcache;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearVersion", "", "appId", "", "versionType", "", "getVersion", "insertOrUpdate", "", "record", "block", "Lkotlin/Function1;", "setVersion", "versionMd5", "Companion", "plugin-appbrand-integration_release"})
public final class d extends com.tencent.mm.plugin.appbrand.ab.c<c> {
    @Deprecated
    public static final a kKd = new a((byte) 0);
    private final ISQLiteDatabase db;

    static {
        AppMethodBeat.i(185635);
        AppMethodBeat.o(185635);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<c, x> {
        final /* synthetic */ c kKf;
        final /* synthetic */ String kKg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(c cVar, String str) {
            super(1);
            this.kKf = cVar;
            this.kKg = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c cVar) {
            AppMethodBeat.i(180426);
            p.h(cVar, LocaleUtil.ITALIAN);
            this.kKf.field_versionMd5 = this.kKg;
            x xVar = x.SXb;
            AppMethodBeat.o(180426);
            return xVar;
        }
    }

    public static final /* synthetic */ boolean a(d dVar, IAutoDBItem iAutoDBItem) {
        AppMethodBeat.i(180430);
        boolean insert = super.insert(iAutoDBItem);
        AppMethodBeat.o(180430);
        return insert;
    }

    public static final /* synthetic */ boolean a(d dVar, IAutoDBItem iAutoDBItem, String... strArr) {
        AppMethodBeat.i(180428);
        boolean z = super.get(iAutoDBItem, strArr);
        AppMethodBeat.o(180428);
        return z;
    }

    public static final /* synthetic */ boolean b(d dVar, IAutoDBItem iAutoDBItem, String... strArr) {
        AppMethodBeat.i(180429);
        boolean update = super.update(iAutoDBItem, strArr);
        AppMethodBeat.o(180429);
        return update;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.iBg, "AppBrandTestCodeVersionMarkTable", c.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(180427);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(180427);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void aN(String str, int i2) {
        AppMethodBeat.i(185634);
        p.h(str, "appId");
        Log.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "clearVersion appId:" + str + " versionType:" + i2);
        c cVar = new c();
        cVar.field_appId = str;
        cVar.field_versionType = i2;
        super.delete(cVar, new String[0]);
        AppMethodBeat.o(185634);
    }

    public final void n(String str, int i2, String str2) {
        AppMethodBeat.i(227974);
        p.h(str, "appId");
        p.h(str2, "versionMd5");
        Log.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "setVersion appId:" + str + " versionType:" + i2 + " versionMd5:" + str2);
        c cVar = new c();
        cVar.field_appId = str;
        cVar.field_versionType = i2;
        com.tencent.mm.plugin.appbrand.ab.d dVar = com.tencent.mm.plugin.appbrand.ab.d.nOm;
        ((Boolean) com.tencent.mm.plugin.appbrand.ab.d.a(this.db, new b(this, cVar, new c(cVar, str2)))).booleanValue();
        AppMethodBeat.o(227974);
    }

    public final String aO(String str, int i2) {
        AppMethodBeat.i(227975);
        p.h(str, "appId");
        c cVar = new c();
        cVar.field_appId = str;
        cVar.field_versionType = i2;
        if (get(cVar, new String[0])) {
            String str2 = cVar.field_versionMd5;
            AppMethodBeat.o(227975);
            return str2;
        }
        AppMethodBeat.o(227975);
        return null;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ kotlin.g.a.b cPt;
        final /* synthetic */ d kKe;
        final /* synthetic */ c kKf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, c cVar, kotlin.g.a.b bVar) {
            super(0);
            this.kKe = dVar;
            this.kKf = cVar;
            this.cPt = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean a2;
            AppMethodBeat.i(180425);
            if (d.a(this.kKe, this.kKf, new String[0])) {
                this.cPt.invoke(this.kKf);
                a2 = d.b(this.kKe, this.kKf, new String[0]);
            } else {
                this.cPt.invoke(this.kKf);
                a2 = d.a(this.kKe, this.kKf);
            }
            Boolean valueOf = Boolean.valueOf(a2);
            AppMethodBeat.o(180425);
            return valueOf;
        }
    }
}
