package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.az;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bw extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS readerappweiboreaderapptime ON readerappweibo ( time )"};
    public h iFy;

    public static String KD(String str) {
        AppMethodBeat.i(102634);
        String str2 = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + str + "  ";
        AppMethodBeat.o(102634);
        return str2;
    }

    public static String se(int i2) {
        AppMethodBeat.i(102635);
        if (i2 == 20) {
            AppMethodBeat.o(102635);
            return "readerappnews1";
        } else if (i2 == 11) {
            AppMethodBeat.o(102635);
            return "readerappweibo";
        } else {
            Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
            AppMethodBeat.o(102635);
            return null;
        }
    }

    public bw(h hVar) {
        this.iFy = hVar;
    }

    public final Cursor sf(int i2) {
        AppMethodBeat.i(102636);
        Cursor rawQuery = this.iFy.rawQuery("SELECT reserved3 from " + se(20) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + i2 + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + se(20) + " GROUP BY reserved3)) -" + i2, null);
        AppMethodBeat.o(102636);
        return rawQuery;
    }

    public final int sg(int i2) {
        int i3 = 0;
        AppMethodBeat.i(102637);
        Cursor rawQuery = this.iFy.rawQuery("select count(*) from (SELECT count(*) FROM " + se(i2) + " group by reserved3)", null, 2);
        if (rawQuery.moveToFirst()) {
            i3 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(102637);
        return i3;
    }

    public final List<bv> Ae(long j2) {
        AppMethodBeat.i(102638);
        ArrayList arrayList = new ArrayList();
        String str = KD(se(20)) + " where reserved2 = " + j2;
        Log.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(str)));
        Cursor rawQuery = this.iFy.rawQuery(str, null, 2);
        while (rawQuery.moveToNext()) {
            bv bvVar = new bv();
            bvVar.convertFrom(rawQuery);
            arrayList.add(bvVar);
        }
        rawQuery.close();
        AppMethodBeat.o(102638);
        return arrayList;
    }

    public final List<bv> al(String str, int i2) {
        AppMethodBeat.i(102639);
        ArrayList arrayList = new ArrayList();
        String str2 = KD(se(i2)) + "where reserved3 = " + h.Fl(str) + " order by istop desc , tweetid asc ";
        Log.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        while (rawQuery.moveToNext()) {
            bv bvVar = new bv();
            bvVar.convertFrom(rawQuery);
            arrayList.add(bvVar);
        }
        rawQuery.close();
        AppMethodBeat.o(102639);
        return arrayList;
    }

    public final List<bv> KE(String str) {
        AppMethodBeat.i(102640);
        Cursor query = this.iFy.query(se(20), new String[]{"*"}, "reserved3=?", new String[]{str}, null, null, null, 2);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    ArrayList arrayList = new ArrayList();
                    do {
                        bv bvVar = new bv();
                        bvVar.convertFrom(query);
                        arrayList.add(bvVar);
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(102640);
                    return arrayList;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.ReaderAppInfoStorage", "getByFunctionMsgId, error: %s", e2.getMessage());
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(102640);
                throw th;
            }
        }
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(102640);
        return null;
    }

    public final void sh(int i2) {
        AppMethodBeat.i(102641);
        az bjY = ((l) g.af(l.class)).aST().bjY(bv.sd(i2));
        if (bjY == null || !bjY.field_username.equals(bv.sd(i2))) {
            AppMethodBeat.o(102641);
            return;
        }
        bjY.setUsername(bv.sd(i2));
        bjY.setContent("");
        bjY.nv(0);
        bjY.nt(0);
        ((l) g.af(l.class)).aST().a(bjY, bv.sd(i2));
        if (this.iFy.execSQL(se(i2), "delete from " + se(i2))) {
            doNotify();
        }
        AppMethodBeat.o(102641);
    }

    public final void si(int i2) {
        AppMethodBeat.i(102642);
        String str = KD(se(i2)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
        Log.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", str);
        Cursor rawQuery = this.iFy.rawQuery(str, null, 2);
        if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            az azVar = new az();
            azVar.setUsername(bv.sd(i2));
            azVar.setContent("");
            azVar.yA(0);
            azVar.nv(0);
            azVar.nt(0);
            ((l) g.af(l.class)).aST().a(azVar, bv.sd(i2));
            AppMethodBeat.o(102642);
            return;
        }
        bv bvVar = new bv();
        bvVar.convertFrom(rawQuery);
        rawQuery.close();
        az azVar2 = new az();
        azVar2.setUsername(bv.sd(i2));
        azVar2.setContent(bvVar.getTitle());
        azVar2.yA(bvVar.time);
        azVar2.nv(0);
        azVar2.nt(0);
        ((l) g.af(l.class)).aST().a(azVar2, bv.sd(i2));
        AppMethodBeat.o(102642);
    }
}
