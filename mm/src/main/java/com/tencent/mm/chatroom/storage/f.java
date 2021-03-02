package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.util.ArrayList;
import java.util.List;

public final class f extends MAutoStorage<e> implements MStorageEx.IOnStorageChange {
    public static final String[] INDEX_CREATE = {"DROP INDEX IF EXISTS usernameIndex", "CREATE INDEX IF NOT EXISTS GroupTools_usernameIndex ON GroupTools ( chatroomname )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.info, "GroupTools")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(e eVar) {
        AppMethodBeat.i(182164);
        boolean a2 = a(eVar);
        AppMethodBeat.o(182164);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(e eVar, String[] strArr) {
        AppMethodBeat.i(182163);
        boolean a2 = a(eVar, strArr);
        AppMethodBeat.o(182163);
        return a2;
    }

    static {
        AppMethodBeat.i(182165);
        AppMethodBeat.o(182165);
    }

    public f(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, e.info, "GroupTools", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final List<e> amp() {
        ArrayList arrayList = null;
        AppMethodBeat.i(185974);
        Cursor query = this.db.query("GroupTools", e.info.columns, null, null, null, null, null);
        if (query == null) {
            AppMethodBeat.o(185974);
        } else {
            try {
                arrayList = new ArrayList();
                while (query.moveToNext()) {
                    e eVar = new e();
                    eVar.convertFrom(query);
                    arrayList.add(eVar);
                }
            } finally {
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(185974);
            }
        }
        return arrayList;
    }

    public final e DE(String str) {
        AppMethodBeat.i(182160);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(182160);
            return null;
        }
        Cursor query = this.db.query("GroupTools", e.info.columns, "chatroomname=?", new String[]{str}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(182160);
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                e eVar = new e();
                eVar.convertFrom(query);
                arrayList.add(eVar);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            e eVar2 = (e) arrayList.get(0);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(182160);
            return eVar2;
        } finally {
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(182160);
        }
    }

    public final boolean a(e eVar) {
        AppMethodBeat.i(182161);
        if (eVar == null) {
            AppMethodBeat.o(182161);
            return false;
        }
        boolean insert = super.insert(eVar);
        AppMethodBeat.o(182161);
        return insert;
    }

    public final boolean a(e eVar, String... strArr) {
        AppMethodBeat.i(182162);
        boolean updateNotify = super.updateNotify(eVar, true, strArr);
        if (updateNotify) {
            nu nuVar = new nu();
            nuVar.dTV.dOe = eVar.field_chatroomname;
            EventCenter.instance.asyncPublish(nuVar, Looper.getMainLooper());
        }
        AppMethodBeat.o(182162);
        return updateNotify;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(185975);
        if (!aa.ame()) {
            AppMethodBeat.o(185975);
        } else if (obj == null || !(obj instanceof String)) {
            AppMethodBeat.o(185975);
        } else {
            if (i2 == 2 && mStorageEx == ((l) g.af(l.class)).aSN()) {
                final String str = (String) obj;
                if (ab.Ix(str)) {
                    h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.chatroom.storage.f.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(194061);
                            e eVar = new e();
                            eVar.field_chatroomname = str;
                            eVar.field_queryState = 1;
                            Log.i("MicroMsg.roomtools.GroupToolsStorage", "onNotifyChange username:%s result:%s", str, Boolean.valueOf(((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(eVar)));
                            AppMethodBeat.o(194061);
                        }
                    });
                }
            }
            AppMethodBeat.o(185975);
        }
    }
}
