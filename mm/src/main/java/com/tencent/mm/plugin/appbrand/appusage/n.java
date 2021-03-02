package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;

@Deprecated
public final class n extends MAutoStorage<m> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(m.kLR, "AppBrandLocalUsageRecord")};
    private final ISQLiteDatabase kLX;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(m mVar, boolean z, String[] strArr) {
        AppMethodBeat.i(44510);
        boolean a2 = a(mVar, z, strArr);
        AppMethodBeat.o(44510);
        return a2;
    }

    static {
        AppMethodBeat.i(44511);
        AppMethodBeat.o(44511);
    }

    public enum a {
        CHATTING,
        USAGE_LIST;

        public static a valueOf(String str) {
            AppMethodBeat.i(44505);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(44505);
            return aVar;
        }

        static {
            AppMethodBeat.i(44506);
            AppMethodBeat.o(44506);
        }
    }

    public n(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, m.kLR, "AppBrandLocalUsageRecord", m.INDEX_CREATE);
        this.kLX = iSQLiteDatabase;
    }

    public final boolean a(String str, int i2, a aVar) {
        boolean z = false;
        AppMethodBeat.i(44507);
        Log.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", str, Integer.valueOf(i2), aVar);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44507);
        } else {
            m mVar = new m();
            mVar.field_username = str;
            mVar.field_versionType = i2;
            if (super.get(mVar, m.kJX)) {
                mVar.field_updateTime = Util.nowSecond();
                z = super.update(mVar.systemRowid, mVar, false);
                if (z) {
                    doNotify(MStorageEventData.EventType.SINGLE, 3, null);
                }
                AppMethodBeat.o(44507);
            } else {
                mVar.field_updateTime = Util.nowSecond();
                super.insertNotify(mVar, false);
                z = super.get(mVar, m.kJX);
                if (z) {
                    this.kLX.execSQL("AppBrandLocalUsageRecord", "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + AppBrandGlobalSystemConfig.bzP().lcV + " offset 0)");
                    doNotify(MStorageEventData.EventType.SINGLE, 2, null);
                }
                AppMethodBeat.o(44507);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(String str, int i2, a aVar) {
        boolean z = false;
        AppMethodBeat.i(44508);
        Log.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", str, Integer.valueOf(i2), aVar);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44508);
        } else {
            m mVar = new m();
            mVar.field_username = str;
            mVar.field_versionType = i2;
            z = a(mVar, false, m.kJX);
            if (z) {
                doNotify(MStorageEventData.EventType.SINGLE, 5, null);
            }
            if (z && a.CHATTING == aVar) {
                com.tencent.mm.plugin.appbrand.app.n.buJ().bp(str, i2);
            }
            if (z && a.CHATTING == aVar) {
                h.bWb().cl(y.Xw(str), i2);
            }
            AppMethodBeat.o(44508);
        }
        return z;
    }

    private boolean a(m mVar, boolean z, String... strArr) {
        AppMethodBeat.i(44509);
        if (z) {
            boolean delete = super.delete(mVar, z, strArr);
            AppMethodBeat.o(44509);
            return delete;
        } else if (!get(mVar, strArr)) {
            AppMethodBeat.o(44509);
            return false;
        } else {
            super.delete(mVar, z, strArr);
            if (!get(mVar, strArr)) {
                AppMethodBeat.o(44509);
                return true;
            }
            AppMethodBeat.o(44509);
            return false;
        }
    }
}
