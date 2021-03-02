package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.app.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "insertOrUpdate", "", "record", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "CREATOR", "Constants", "plugin-appbrand-integration_release"})
public final class v extends x {
    public static final String[] iBh = {x.getCreateSQLs(WxaAttributes.kLR, "WxaAttrAvailableBackupTable")};
    public static final b lfN = new b((byte) 0);
    private final ISQLiteDatabaseEx kOg;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage$Constants;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "plugin-appbrand-integration_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(ISQLiteDatabaseEx iSQLiteDatabaseEx) {
        super(iSQLiteDatabaseEx, "WxaAttrAvailableBackupTable", null);
        p.h(iSQLiteDatabaseEx, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(228169);
        this.kOg = iSQLiteDatabaseEx;
        AppMethodBeat.o(228169);
    }

    static {
        AppMethodBeat.i(228170);
        AppMethodBeat.o(228170);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage$CREATOR;", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandDBStorageRegistry$IStorageCreator;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "()V", "create", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
    public static final class a implements b.a<v> {
        public static final a lfO = new a();

        static {
            AppMethodBeat.i(228167);
            AppMethodBeat.o(228167);
        }

        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.plugin.appbrand.app.b.a
        public final /* synthetic */ v b(ISQLiteDatabase iSQLiteDatabase) {
            AppMethodBeat.i(228166);
            p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            v vVar = new v((ISQLiteDatabaseEx) iSQLiteDatabase);
            AppMethodBeat.o(228166);
            return vVar;
        }
    }

    public final boolean d(WxaAttributes wxaAttributes) {
        int i2;
        boolean insert;
        AppMethodBeat.i(228168);
        if (wxaAttributes == null) {
            AppMethodBeat.o(228168);
            return false;
        }
        StringBuilder append = new StringBuilder("WxaAttrAvailableBackupStorage.insertOrUpdate(").append(wxaAttributes.field_username).append('|').append(wxaAttributes.field_appId).append('|');
        WxaAttributes.WxaVersionInfo bAp = wxaAttributes.bAp();
        if (bAp != null) {
            i2 = bAp.appVersion;
        } else {
            i2 = -1;
        }
        String sb = append.append(i2).append(')').toString();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (super.a(wxaAttributes, ch.COL_USERNAME)) {
            insert = super.update(wxaAttributes, ch.COL_USERNAME);
        } else {
            insert = super.insert(wxaAttributes);
        }
        Boolean valueOf = Boolean.valueOf(insert);
        String obj = valueOf.toString();
        if (obj == null) {
            obj = "";
        }
        boolean LB = ag.LB();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 <= 32 || !LB) {
            Log.i("Luggage.Utils.Profile", "runProfiled:log:" + sb + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + LB + ' ');
        } else {
            Log.w("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + sb + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + LB + ' ');
        }
        boolean booleanValue = valueOf.booleanValue();
        AppMethodBeat.o(228168);
        return booleanValue;
    }
}
