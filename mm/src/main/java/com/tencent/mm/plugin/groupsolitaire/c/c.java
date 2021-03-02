package com.tencent.mm.plugin.groupsolitaire.c;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.a;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class c extends MAutoStorage<a> {
    public static final String[] INDEX_CREATE = {"DROP INDEX IF EXISTS usernameIndex", "CREATE INDEX IF NOT EXISTS GroupSolitatire_usernameIndex ON GroupSolitatire ( username )", "CREATE INDEX IF NOT EXISTS usernameKeyIndex ON GroupSolitatire ( username,key )", "CREATE INDEX IF NOT EXISTS usernameKeyActiveIndex ON GroupSolitatire ( username,key,active )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "GroupSolitatire")};
    public static final Long yfJ = 86400L;
    public static final Long yfK = 3600L;
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(a aVar) {
        AppMethodBeat.i(110410);
        boolean i2 = i(aVar);
        AppMethodBeat.o(110410);
        return i2;
    }

    static {
        AppMethodBeat.i(110411);
        AppMethodBeat.o(110411);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "GroupSolitatire", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final a r(String str, String str2, boolean z) {
        AppMethodBeat.i(194436);
        a ie = ie(str, str2);
        if (!z) {
            AppMethodBeat.o(194436);
            return ie;
        }
        a aBm = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().aBm(str);
        if (ie == null || aBm == null) {
            AppMethodBeat.o(194436);
            return ie;
        }
        if (ie.field_active == 1) {
            if (ie.field_lastActiveTime < aBm.yfa) {
                if (aBm.yeZ) {
                    ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                    d.a(ie, 2);
                } else {
                    ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                    d.a(ie, 1);
                }
                if (delete(ie.systemRowid)) {
                    AppMethodBeat.o(194436);
                    return null;
                }
            }
        } else if (ie.field_active == 0 && ie.field_lastActiveTime < aBm.yfc) {
            if (aBm.yfb) {
                ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                d.a(ie, 2);
            } else {
                ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                d.a(ie, 1);
            }
            if (delete(ie.systemRowid)) {
                AppMethodBeat.o(194436);
                return null;
            }
        }
        AppMethodBeat.o(194436);
        return ie;
    }

    public final a ie(String str, String str2) {
        AppMethodBeat.i(110404);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(110404);
            return null;
        }
        Cursor query = this.db.query("GroupSolitatire", a.info.columns, "username=? and key=?", new String[]{str, str2}, null, null, "lastActiveTime");
        if (query == null) {
            AppMethodBeat.o(110404);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(query);
            b.f(aVar);
            arrayList.add(aVar);
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(110404);
            return null;
        }
        a aVar2 = (a) arrayList.get(0);
        a aBm = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().aBm(str);
        if (aBm != null) {
            if (aVar2.field_active == 0 && aVar2.field_lastActiveTime >= aBm.yfc) {
                AppMethodBeat.o(110404);
                return aVar2;
            } else if (aVar2.field_active == 1 && aVar2.field_lastActiveTime >= aBm.yfa) {
                AppMethodBeat.o(110404);
                return aVar2;
            }
        }
        AppMethodBeat.o(110404);
        return null;
    }

    public final boolean a(a aVar, boolean z) {
        AppMethodBeat.i(110405);
        if (aVar == null) {
            AppMethodBeat.o(110405);
            return false;
        } else if (b.h(aVar)) {
            AppMethodBeat.o(110405);
            return false;
        } else {
            if (!z) {
                aVar.field_content = b.e(aVar);
                if (aVar.yfE.size() > 1) {
                    aVar.field_active = 1;
                } else if (aVar.field_active == -1) {
                    aVar.field_active = 0;
                }
            }
            boolean update = update(aVar.systemRowid, aVar);
            if (update) {
                ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ic(aVar.field_username, aVar.field_key);
            }
            AppMethodBeat.o(110405);
            return update;
        }
    }

    public final List<a> eo(String str, int i2) {
        AppMethodBeat.i(110406);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110406);
            return arrayList;
        }
        Cursor cursor = null;
        long aWB = (long) cl.aWB();
        if (i2 == 1) {
            cursor = this.db.query("GroupSolitatire", a.info.columns, "username=? and active=? and lastActiveTime>=?", new String[]{str, "1", new StringBuilder().append(aWB - (((long) b.dXJ()) * yfJ.longValue())).toString()}, null, null, "lastActiveTime DESC ");
        } else if (i2 == 0) {
            cursor = this.db.query("GroupSolitatire", a.info.columns, "username=? and active=? and lastActiveTime>=?", new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO, new StringBuilder().append(aWB - (((long) b.dXL()) * yfK.longValue())).toString()}, null, null, "lastActiveTime DESC ");
        }
        if (cursor == null) {
            AppMethodBeat.o(110406);
            return arrayList;
        }
        while (cursor.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(cursor);
            b.f(aVar);
            arrayList.add(aVar);
        }
        AppMethodBeat.o(110406);
        return arrayList;
    }

    public final List<a> E(String str, int i2, long j2) {
        AppMethodBeat.i(110407);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110407);
            return arrayList;
        }
        Cursor query = this.db.query("GroupSolitatire", a.info.columns, "username=? and active=? and lastActiveTime<?", new String[]{str, String.valueOf(i2), String.valueOf(j2)}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(110407);
            return arrayList;
        }
        while (query.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(query);
            arrayList.add(aVar);
        }
        AppMethodBeat.o(110407);
        return arrayList;
    }

    public final boolean F(String str, int i2, long j2) {
        int i3;
        AppMethodBeat.i(110408);
        try {
            i3 = this.db.delete("GroupSolitatire", "username=? and lastActiveTime<? and active=?", new String[]{str, String.valueOf(j2), String.valueOf(i2)});
        } catch (Exception e2) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireStorage", "deleteExpireData username:%s lastTime:%s Exception:%s", str, Long.valueOf(j2), e2.getMessage());
            i3 = 0;
        }
        if (i3 > 0) {
            AppMethodBeat.o(110408);
            return true;
        }
        AppMethodBeat.o(110408);
        return false;
    }

    public final boolean i(a aVar) {
        AppMethodBeat.i(110409);
        if (aVar == null) {
            AppMethodBeat.o(110409);
            return false;
        } else if (b.h(aVar)) {
            AppMethodBeat.o(110409);
            return false;
        } else {
            aVar.field_content = b.e(aVar);
            if (aVar.yfE.size() > 1) {
                aVar.field_active = 1;
            } else if (aVar.field_active == -1) {
                aVar.field_active = 0;
            }
            boolean insert = super.insert(aVar);
            AppMethodBeat.o(110409);
            return insert;
        }
    }
}
