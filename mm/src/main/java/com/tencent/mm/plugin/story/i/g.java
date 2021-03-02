package com.tencent.mm.plugin.story.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.gs;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.f.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

public final class g extends MAutoStorage<f> implements MStorage.IOnStorageChange {
    private static final String Fwk = ("select *, rowid from " + TABLE + ' ');
    private static final String Fwl = ("select * from " + TABLE);
    public static final a Fwm = new a((byte) 0);
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(f.info, TABLE)};
    private static final String TABLE = TABLE;
    private static final String TAG = TAG;
    public final ArrayList<m> Fwg = new ArrayList<>();
    private final c<String, f> Fwh = new c<>(1000);
    private c<String, f> Fwi = new c<>(1000);
    private final ISQLiteDatabase Fwj;
    private final ISQLiteDatabase db = this.Fwj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, f.info, TABLE, gs.INDEX_CREATE);
        p.h(iSQLiteDatabase, "vdb");
        f.a aVar = f.Fwe;
        AppMethodBeat.i(119517);
        this.Fwj = iSQLiteDatabase;
        AppMethodBeat.o(119517);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(f fVar) {
        AppMethodBeat.i(119508);
        f fVar2 = fVar;
        p.h(fVar2, "item");
        boolean replace = super.replace(fVar2);
        c(fVar2);
        AppMethodBeat.o(119508);
        return replace;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119518);
        f.a aVar = f.Fwe;
        AppMethodBeat.o(119518);
    }

    public final f aSt(String str) {
        AppMethodBeat.i(119501);
        f fVar = new f();
        fVar.field_userName = str;
        super.get(fVar, getPrimaryKey());
        AppMethodBeat.o(119501);
        return fVar;
    }

    public final f aRS(String str) {
        AppMethodBeat.i(119502);
        p.h(str, "userName");
        f aSv = aSv(str);
        if (aSv != null) {
            AppMethodBeat.o(119502);
            return aSv;
        }
        f aSt = aSt(str);
        AppMethodBeat.o(119502);
        return aSt;
    }

    public final boolean b(f fVar) {
        AppMethodBeat.i(119503);
        p.h(fVar, "info");
        c(fVar);
        boolean replace = super.replace(fVar);
        AppMethodBeat.o(119503);
        return replace;
    }

    public final boolean a(long j2, f fVar) {
        AppMethodBeat.i(119504);
        p.h(fVar, Constants.EXTINFO);
        if (b(j2, fVar) >= 0) {
            doNotify("notify_story_preload", 3, fVar);
        }
        AppMethodBeat.o(119504);
        return true;
    }

    public final String aSu(String str) {
        AppMethodBeat.i(119505);
        p.h(str, "userName");
        String str2 = aSt(str).field_md5;
        AppMethodBeat.o(119505);
        return str2;
    }

    public final int kJ(String str, String str2) {
        AppMethodBeat.i(119506);
        p.h(str, "userName");
        p.h(str2, "md5");
        f aSt = aSt(str);
        aSt.field_md5 = str2;
        super.replace(aSt);
        AppMethodBeat.o(119506);
        return 0;
    }

    public final int lb(String str, String str2) {
        AppMethodBeat.i(119507);
        p.h(str, "userName");
        p.h(str2, "md5");
        f aSt = aSt(str);
        aSt.field_favoriteMd5 = str2;
        super.replace(aSt);
        AppMethodBeat.o(119507);
        return 0;
    }

    private final void c(f fVar) {
        AppMethodBeat.i(119509);
        if (fVar != null) {
            String userName = fVar.getUserName();
            if (!(userName == null || userName.length() == 0)) {
                com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                if (((l) af).aSN().bjG(fVar.getUserName())) {
                    this.Fwh.put(fVar.getUserName(), fVar);
                    this.Fwi.remove(fVar.getUserName());
                    AppMethodBeat.o(119509);
                    return;
                }
                this.Fwh.remove(fVar.getUserName());
                this.Fwi.put(fVar.getUserName(), fVar);
                AppMethodBeat.o(119509);
                return;
            }
        }
        AppMethodBeat.o(119509);
    }

    public final List<f> frC() {
        AppMethodBeat.i(119510);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery(Fwk, null, 2);
        rawQuery.moveToFirst();
        do {
            f fVar = new f();
            p.g(rawQuery, "cu");
            fVar.convertFrom(rawQuery);
            arrayList.add(fVar);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119510);
        return arrayList2;
    }

    public final List<f> frv() {
        AppMethodBeat.i(119511);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery(Fwl, null, 2);
        rawQuery.moveToFirst();
        do {
            f fVar = new f();
            p.g(rawQuery, "cu");
            fVar.convertFrom(rawQuery);
            arrayList.add(fVar);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119511);
        return arrayList2;
    }

    public final f aSv(String str) {
        AppMethodBeat.i(119512);
        p.h(str, ch.COL_USERNAME);
        if (str.length() == 0) {
            AppMethodBeat.o(119512);
            return null;
        }
        f fVar = this.Fwh.get(str);
        if (fVar == null && (fVar = this.Fwi.get(str)) == null) {
            fVar = aSt(str);
            c(fVar);
        }
        AppMethodBeat.o(119512);
        return fVar;
    }

    public final f aSw(String str) {
        AppMethodBeat.i(119513);
        p.h(str, ch.COL_USERNAME);
        f fVar = this.Fwi.get(str);
        if (fVar == null) {
            fVar = aSt(str);
            c(fVar);
        }
        AppMethodBeat.o(119513);
        return fVar;
    }

    public final int b(long j2, f fVar) {
        AppMethodBeat.i(119514);
        p.h(fVar, Constants.EXTINFO);
        ContentValues convertTo = fVar.convertTo();
        convertTo.remove("rowid");
        c(fVar);
        int update = this.db.update(TABLE, convertTo, "rowid=?", new String[]{String.valueOf(j2)});
        AppMethodBeat.o(119514);
        return update;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(119515);
        if (!(str == null || mStorageEventData == null)) {
            if (p.j(str, "notify_story_read") && (mStorageEventData.obj instanceof f)) {
                Object obj = mStorageEventData.obj;
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.o(119515);
                    throw tVar;
                }
                String userName = ((f) obj).getUserName();
                Iterator<T> it = this.Fwg.iterator();
                while (it.hasNext()) {
                    it.next().cr(userName, true);
                }
                b bVar = b.FlH;
                b.fnD();
                AppMethodBeat.o(119515);
                return;
            } else if (p.j(str, "notify_story_unread") && (mStorageEventData.obj instanceof f)) {
                Object obj2 = mStorageEventData.obj;
                if (obj2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.o(119515);
                    throw tVar2;
                }
                String userName2 = ((f) obj2).getUserName();
                Iterator<T> it2 = this.Fwg.iterator();
                while (it2.hasNext()) {
                    it2.next().cr(userName2, false);
                }
                b bVar2 = b.FlH;
                b.fnD();
                AppMethodBeat.o(119515);
                return;
            } else if (p.j(str, "notify_story_invalid") && (mStorageEventData.obj instanceof f)) {
                Object obj3 = mStorageEventData.obj;
                if (obj3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.o(119515);
                    throw tVar3;
                }
                String userName3 = ((f) obj3).getUserName();
                Iterator<T> it3 = this.Fwg.iterator();
                while (it3.hasNext()) {
                    it3.next().cr(userName3, true);
                }
                b bVar3 = b.FlH;
                b.fnD();
                AppMethodBeat.o(119515);
                return;
            } else if (!p.j(str, "notify_story_valid") || !(mStorageEventData.obj instanceof f)) {
                Log.d(TAG, "unknown event ".concat(String.valueOf(str)));
            } else {
                Object obj4 = mStorageEventData.obj;
                if (obj4 == null) {
                    t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                    AppMethodBeat.o(119515);
                    throw tVar4;
                }
                String userName4 = ((f) obj4).getUserName();
                Iterator<T> it4 = this.Fwg.iterator();
                while (it4.hasNext()) {
                    it4.next().cr(userName4, true);
                }
                b bVar4 = b.FlH;
                b.fnD();
                AppMethodBeat.o(119515);
                return;
            }
        }
        AppMethodBeat.o(119515);
    }

    public final void eIQ() {
        AppMethodBeat.i(119516);
        Log.i(TAG, "dropTable ".concat(String.valueOf(this.db.delete(TABLE, null, null))));
        AppMethodBeat.o(119516);
    }
}
