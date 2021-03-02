package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

public final class a extends MAutoStorage<am> {
    private static final String[] INDEX_CREATE;
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(am.info, "FinderAction")};
    public static final String TAG = TAG;
    private static final int vwn = 1;
    private static final int vwo = 2;
    private static final int vwp = 3;
    public static final C1279a vwq = new C1279a((byte) 0);
    public final ISQLiteDatabase db;
    private final String vwm = "SELECT * FROM FinderAction";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, am.info, "FinderAction", INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        am.a aVar = am.vFs;
        AppMethodBeat.i(166895);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(166895);
    }

    /* renamed from: com.tencent.mm.plugin.finder.storage.a$a */
    public static final class C1279a {
        private C1279a() {
        }

        public /* synthetic */ C1279a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(166896);
        am.a aVar = am.vFs;
        String[] strArr = cd.INDEX_CREATE;
        p.g(strArr, "BaseFinderAction.INDEX_CREATE");
        List X = e.X(strArr);
        StringBuilder sb = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        am.a aVar2 = am.vFs;
        X.add(sb.append(am.vFq).append(" ON FinderAction ( actionType,state,postTime )").toString());
        StringBuilder sb2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        am.a aVar3 = am.vFs;
        X.add(sb2.append(am.vFr).append(" ON FinderAction (actionType,feedId, postTime)").toString());
        Object[] array = X.toArray(new String[0]);
        if (array == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(166896);
            throw tVar;
        }
        INDEX_CREATE = (String[]) array;
        AppMethodBeat.o(166896);
    }

    public final an dqh() {
        Throwable th;
        an anVar;
        an anVar2;
        Throwable th2 = null;
        AppMethodBeat.i(166885);
        c cVar = new c("getRecentAction");
        String str = this.vwm + " WHERE actionType = 1 and state == 1 ORDER BY postTime DESC limit 1";
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        Log.i(TAG, "getRecentAction " + cVar + ' ' + str);
        Cursor cursor = rawQuery;
        try {
            if (rawQuery.moveToFirst()) {
                do {
                    anVar2 = new an();
                    anVar2.convertFrom(rawQuery);
                } while (rawQuery.moveToNext());
                anVar = anVar2;
            } else {
                anVar = null;
            }
            x xVar = x.SXb;
            kotlin.f.b.a(cursor, null);
            Log.i(TAG, "getRecentAction ".concat(String.valueOf(anVar)));
            AppMethodBeat.o(166885);
            return anVar;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(cursor, th2);
            AppMethodBeat.o(166885);
            throw th;
        }
    }

    public final long a(an anVar) {
        AppMethodBeat.i(166886);
        p.h(anVar, NativeProtocol.WEB_DIALOG_ACTION);
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_FINDACTION_MAXID_LONG_SYNC, 1);
        com.tencent.mm.kernel.e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_FINDER_FINDACTION_MAXID_LONG_SYNC, Long.valueOf(1 + a2));
        anVar.field_localCommentId = a2;
        Log.i(TAG, "new feed action rowId " + this.db.insert("FinderAction", "localCommentId", anVar.convertTo()) + ' ' + com.tencent.mm.ac.g.bN(anVar) + " localID: " + a2);
        a(anVar.field_feedId, anVar.dyb().commentId, anVar.field_localCommentId, vwp, anVar);
        AppMethodBeat.o(166886);
        return a2;
    }

    public final List<an> Ft(long j2) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(166887);
        String str = this.vwm + " WHERE actionType = 1 and feedId = " + j2 + " ORDER BY postTime DESC";
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        Log.i(TAG, "getAllUnsentCommentsByFeedId " + j2 + ' ' + str);
        LinkedList linkedList = new LinkedList();
        Cursor cursor = rawQuery;
        try {
            if (rawQuery.moveToFirst()) {
                do {
                    an anVar = new an();
                    anVar.convertFrom(rawQuery);
                    linkedList.add(anVar);
                } while (rawQuery.moveToNext());
            }
            x xVar = x.SXb;
            kotlin.f.b.a(cursor, null);
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(166887);
            return linkedList2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(cursor, th2);
            AppMethodBeat.o(166887);
            throw th;
        }
    }

    public final List<an> Fu(long j2) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(166888);
        String str = this.vwm + " WHERE actionType = 1 and feedId = " + j2 + " and state = -1 ORDER BY postTime DESC";
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        LinkedList linkedList = new LinkedList();
        Cursor cursor = rawQuery;
        try {
            if (rawQuery.moveToFirst()) {
                do {
                    an anVar = new an();
                    anVar.convertFrom(rawQuery);
                    linkedList.add(anVar);
                } while (rawQuery.moveToNext());
            }
            x xVar = x.SXb;
            kotlin.f.b.a(cursor, null);
            Log.i(TAG, "getAllFailedCommentsByFeedId " + j2 + ' ' + str + " listsize:" + linkedList);
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(166888);
            return linkedList2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(cursor, th2);
            AppMethodBeat.o(166888);
            throw th;
        }
    }

    public static final class b {
        public final long feedId;
        public final String objectNonceId;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
            if (kotlin.g.b.p.j(r5.objectNonceId, r6.objectNonceId) != false) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 166884(0x28be4, float:2.33854E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0020
                boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.storage.a.b
                if (r0 == 0) goto L_0x0025
                com.tencent.mm.plugin.finder.storage.a$b r6 = (com.tencent.mm.plugin.finder.storage.a.b) r6
                long r0 = r5.feedId
                long r2 = r6.feedId
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0025
                java.lang.String r0 = r5.objectNonceId
                java.lang.String r1 = r6.objectNonceId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0025
            L_0x0020:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0024:
                return r0
            L_0x0025:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0024
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.a.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(166883);
            long j2 = this.feedId;
            int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            String str = this.objectNonceId;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(166883);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(166882);
            String str = "FeedAndNonceId(feedId=" + this.feedId + ", objectNonceId=" + this.objectNonceId + ")";
            AppMethodBeat.o(166882);
            return str;
        }

        public b(long j2, String str) {
            p.h(str, "objectNonceId");
            AppMethodBeat.i(166881);
            this.feedId = j2;
            this.objectNonceId = str;
            AppMethodBeat.o(166881);
        }
    }

    public final List<b> dqi() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(166889);
        String str = this.vwm + " WHERE actionType = 1 and state = -1 and  canRemove = 0 group By feedId";
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        LinkedList linkedList = new LinkedList();
        Cursor cursor = rawQuery;
        try {
            if (rawQuery.moveToFirst()) {
                do {
                    an anVar = new an();
                    anVar.convertFrom(rawQuery);
                    linkedList.add(new b(anVar.field_feedId, anVar.getObjectNonceId()));
                } while (rawQuery.moveToNext());
            }
            x xVar = x.SXb;
            kotlin.f.b.a(cursor, null);
            Log.i(TAG, "getAllFailedCommentFeedIds " + str + " listSize:" + linkedList.size());
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(166889);
            return linkedList2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(cursor, th2);
            AppMethodBeat.o(166889);
            throw th;
        }
    }

    public final an Fv(long j2) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(166890);
        String str = this.vwm + "  WHERE actionType = 1 and localCommentId = " + j2;
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        Log.i(TAG, "getByLocalCommentId " + str + ' ' + j2);
        Cursor cursor = rawQuery;
        try {
            if (rawQuery.moveToFirst()) {
                do {
                    new an().convertFrom(rawQuery);
                } while (rawQuery.moveToNext());
            }
            x xVar = x.SXb;
            kotlin.f.b.a(cursor, null);
            AppMethodBeat.o(166890);
            return null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(cursor, th2);
            AppMethodBeat.o(166890);
            throw th;
        }
    }

    public final boolean Fw(long j2) {
        boolean z = true;
        AppMethodBeat.i(166891);
        if (this.db.delete("FinderAction", "localCommentId=?", new String[]{String.valueOf(j2)}) <= 0) {
            z = false;
        }
        Log.i(TAG, "removeUnsentComment " + j2 + " ret:" + z);
        AppMethodBeat.o(166891);
        return z;
    }

    public static /* synthetic */ boolean a(a aVar, long j2, an anVar) {
        AppMethodBeat.i(166893);
        boolean a2 = aVar.a(j2, anVar, true);
        AppMethodBeat.o(166893);
        return a2;
    }

    public final boolean a(long j2, an anVar, boolean z) {
        AppMethodBeat.i(166892);
        p.h(anVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        ContentValues convertTo = anVar.convertTo();
        convertTo.remove("rowid");
        boolean z2 = this.db.update("FinderAction", convertTo, "localCommentId=?", new String[]{String.valueOf(j2)}) > 0;
        int i2 = vwp;
        if (z) {
            a(anVar.field_feedId, anVar.dyb().commentId, anVar.field_localCommentId, i2, anVar);
        }
        AppMethodBeat.o(166892);
        return z2;
    }

    public static void a(long j2, long j3, long j4, int i2, an anVar) {
        AppMethodBeat.i(166894);
        hs hsVar = new hs();
        hsVar.dMm.feedId = j2;
        hsVar.dMm.commentId = j3;
        hsVar.dMm.dMn = j4;
        hsVar.dMm.opType = i2;
        hsVar.dMm.dMo = anVar;
        Log.i(TAG, "postEvent, feedId:" + j2 + ", commentId:" + j3 + ", localId:" + j4 + ", opType:" + i2);
        EventCenter.instance.publish(hsVar);
        AppMethodBeat.o(166894);
    }
}
