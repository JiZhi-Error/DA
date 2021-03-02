package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.x;

public final class ab extends MAutoStorage<ce> {
    private static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FinderMsgContactStorage_username_index ON FinderMsgContactStorage(username)"};
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(g.info, "FinderMsgContactStorage")};
    public static final a vEP = new a((byte) 0);
    private final ISQLiteDatabase vDi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ab(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, g.info, "FinderMsgContactStorage", INDEX_CREATE);
        p.h(iSQLiteDatabase, "storage");
        g.a aVar = g.tsD;
        AppMethodBeat.i(251822);
        this.vDi = iSQLiteDatabase;
        AppMethodBeat.o(251822);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251823);
        g.a aVar = g.tsD;
        AppMethodBeat.o(251823);
    }

    public final g asG(String str) {
        Throwable th;
        g gVar;
        Throwable th2 = null;
        AppMethodBeat.i(251818);
        p.h(str, ch.COL_USERNAME);
        Cursor rawQuery = this.vDi.rawQuery("SELECT *, rowid FROM FinderContact WHERE username = " + h.Fl(str), null, 2);
        try {
            Cursor cursor = rawQuery;
            if (cursor == null) {
                gVar = null;
            } else if (cursor.moveToFirst()) {
                g gVar2 = new g();
                gVar2.convertFrom(cursor);
                gVar = gVar2;
            } else {
                gVar = null;
            }
            x xVar = x.SXb;
            b.a(rawQuery, null);
            AppMethodBeat.o(251818);
            return gVar;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(rawQuery, th2);
            AppMethodBeat.o(251818);
            throw th;
        }
    }

    public static /* synthetic */ boolean a(ab abVar, g gVar) {
        AppMethodBeat.i(251820);
        boolean a2 = abVar.a(gVar, true);
        AppMethodBeat.o(251820);
        return a2;
    }

    public final boolean a(g gVar, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(251819);
        p.h(gVar, UserDataStore.CITY);
        if (z) {
            gVar.field_updateTime = cl.aWA();
        }
        if (asG(gVar.getUsername()) == null) {
            p.h(gVar, "contact");
            long insert = this.vDi.insert("FinderContact", "", gVar.convertTo());
            Log.i("Finder.MsgContactStorage", "insert contact " + gVar + ' ' + insert);
            gVar.systemRowid = insert;
            if (insert <= 0) {
                z2 = false;
            }
        } else {
            p.h(gVar, "contact");
            ContentValues convertTo = gVar.convertTo();
            convertTo.remove("rowid");
            int update = this.vDi.update("FinderContact", convertTo, "username=?", new String[]{gVar.field_username});
            Log.i("Finder.MsgContactStorage", "updateContact " + gVar.cXL() + ' ' + update);
            if (update > 0) {
                g(gVar);
            }
            if (update <= 0) {
                z2 = false;
            }
        }
        if (z2) {
            g(gVar);
            doNotify("FinderContact", 4, gVar.getUsername());
        }
        AppMethodBeat.o(251819);
        return z2;
    }

    private static void g(g gVar) {
        AppMethodBeat.i(251821);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        bv aSN = ((l) af).aSN();
        String avA = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getSessionInfoStorage().avA(gVar.getUsername());
        aSN.ayf(gVar.getUsername());
        aSN.ayf(avA);
        AppMethodBeat.o(251821);
    }
}
