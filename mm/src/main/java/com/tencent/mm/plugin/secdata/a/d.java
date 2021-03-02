package com.tencent.mm.plugin.secdata.a;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import kotlin.g.b.p;
import kotlin.x;

public final class d {
    private static final String[] CWl = {MAutoStorage.getCreateSQLs(b.info, "SecReportDataInfo"), "CREATE INDEX IF NOT EXISTS SecReportDataInfo_indexData ON SecReportDataInfo (indexData)"};
    public static final a CWm = new a((byte) 0);
    public final String TAG = "MicroMsg.SecData.SecReportDataInfoStorage";
    public final h iFy;

    public d(h hVar) {
        p.h(hVar, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(219181);
        this.iFy = hVar;
        AppMethodBeat.o(219181);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(219182);
        b.a aVar = b.CWj;
        AppMethodBeat.o(219182);
    }

    public final b aMZ(String str) {
        Throwable th;
        b bVar;
        Throwable th2 = null;
        AppMethodBeat.i(219177);
        p.h(str, "id");
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM SecReportDataInfo WHERE id = ?;", new String[]{str});
        Cursor cursor = rawQuery;
        try {
            if (rawQuery.moveToNext()) {
                b bVar2 = new b();
                bVar2.convertFrom(rawQuery);
                bVar = bVar2;
            } else {
                bVar = null;
            }
            x xVar = x.SXb;
            kotlin.f.b.a(cursor, null);
            Log.i(this.TAG, "getById id:" + str + " info:" + bVar);
            AppMethodBeat.o(219177);
            return bVar;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(cursor, th2);
            AppMethodBeat.o(219177);
            throw th;
        }
    }

    public final long a(b bVar) {
        AppMethodBeat.i(219178);
        p.h(bVar, "info");
        long insert = this.iFy.insert("SecReportDataInfo", "id", bVar.convertTo());
        Log.i(this.TAG, "insert id:" + bVar.field_id + " info:" + bVar + " result:" + insert);
        AppMethodBeat.o(219178);
        return insert;
    }

    public final long b(b bVar) {
        AppMethodBeat.i(219179);
        p.h(bVar, "info");
        long replace = this.iFy.replace("SecReportDataInfo", "id", bVar.convertTo());
        Log.i(this.TAG, "replace id:" + bVar.field_id + " info:" + bVar + " result:" + replace);
        AppMethodBeat.o(219179);
        return replace;
    }

    public final int aNa(String str) {
        AppMethodBeat.i(219180);
        p.h(str, "id");
        int delete = this.iFy.delete("SecReportDataInfo", "id = ?", new String[]{str});
        Log.i(this.TAG, "replace id:" + str + " result:" + delete);
        AppMethodBeat.o(219180);
        return delete;
    }
}
