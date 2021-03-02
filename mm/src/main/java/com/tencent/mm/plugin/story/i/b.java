package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gq;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.c;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

public final class b extends MAutoStorage<gq> {
    public static final String FvX = FvX;
    public static final a FvY = new a((byte) 0);
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "StoryCommentSync")};
    private static final String TAG = TAG;
    private final ArrayList<Integer> FvV;
    public String FvW;
    public final ISQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "StoryCommentSync", gq.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        c.a aVar = c.FvZ;
        AppMethodBeat.i(119477);
        this.db = iSQLiteDatabase;
        a.b bVar = a.b.FvF;
        List asList = Arrays.asList(Integer.valueOf(a.b.frk()));
        p.g(asList, "Arrays.asList(ConstantsS…COMMENT_SYNC_FLAG_UNREAD)");
        p.h(asList, "data");
        ArrayList arrayList = new ArrayList(asList);
        HashSet hashSet = new HashSet();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                int intValue = ((Integer) it2.next()).intValue();
                p.g(num, "i");
                arrayList3.add(Integer.valueOf(intValue | num.intValue()));
            }
            hashSet.addAll(new HashSet(arrayList3));
            hashSet.add(num);
        }
        hashSet.add(0);
        arrayList2.addAll(hashSet);
        this.FvV = arrayList2;
        this.FvW = "";
        ArrayList arrayList4 = new ArrayList();
        Iterator<Integer> it3 = this.FvV.iterator();
        while (it3.hasNext()) {
            Integer next = it3.next();
            int intValue2 = next.intValue();
            a.b bVar2 = a.b.FvF;
            if ((intValue2 & a.b.frk()) != 0) {
                arrayList4.add(next);
            }
        }
        k.a aVar2 = k.FwC;
        this.FvW = k.a.k(arrayList4, "commentFlag");
        AppMethodBeat.o(119477);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119478);
        c.a aVar = c.FvZ;
        AppMethodBeat.o(119478);
    }

    public final c Kw(long j2) {
        c cVar = null;
        AppMethodBeat.i(119475);
        Cursor rawQuery = this.db.rawQuery("select * from StoryCommentSync  where storyId = " + j2 + ' ', null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.convertFrom(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(119475);
        return cVar;
    }

    public final List<c> frv() {
        AppMethodBeat.i(119476);
        String str = FvX;
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery(str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                c cVar = new c();
                cVar.convertFrom(rawQuery);
                arrayList.add(cVar);
            }
            rawQuery.close();
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119476);
        return arrayList2;
    }
}
