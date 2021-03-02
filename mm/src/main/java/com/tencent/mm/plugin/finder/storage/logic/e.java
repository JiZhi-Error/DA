package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.model.ax;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.model.bb;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import java.util.List;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class e {
    private static final String TAG = TAG;
    public static final a vGT = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ.\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ \u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rJ\u001c\u0010\u0016\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\tJ\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020 J\u0016\u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getAfterTimeLimit", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "mentionId", "", "limit", "", "types", "", "scene", "getBeforeTimeLimit", "getByMentionIdCreateTime", "mentionCreateTime", "getDbSelect", "getLocalFlag", "insertMention", "", "mention", "mentionList", "removePrivateMention", "", "clientMsgId", "transformFinderMentionToCovertData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "transformMentionToLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMention;", "updateMentionExtFlag", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static List<ao> a(long j2, int i2, int[] iArr, int i3) {
            String str;
            LinkedList linkedList;
            Throwable th;
            Throwable th2;
            AppMethodBeat.i(167110);
            p.h(iArr, "types");
            MAutoStorage<cm> mentionStorage = ((PluginFinder) g.ah(PluginFinder.class)).getMentionStorage(Li(i3));
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            int i4 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_AUTO_INCREMENT_ID_INT_SYNC, 0);
            if (iArr.length == 0) {
                str = Lh(i3) + " WHERE id < " + j2 + ' ' + " AND flag = 0  AND userVersion = " + i4 + " ORDER BY createTime DESC,id DESC LIMIT " + i2;
            } else {
                String str2 = "(";
                int i5 = 0;
                int length = iArr.length;
                int i6 = 0;
                while (i6 < length) {
                    int i7 = iArr[i6];
                    int i8 = i5 + 1;
                    if (i5 > 0) {
                        str2 = str2 + ",";
                    }
                    str2 = str2 + String.valueOf(i7);
                    i6++;
                    i5 = i8;
                }
                str = Lh(i3) + " WHERE id < " + j2 + ' ' + " AND flag = 0  AND type IN " + (str2 + ")") + " AND userVersion = " + i4 + " ORDER BY createTime DESC,id DESC LIMIT " + i2;
            }
            Log.i(e.TAG, "get mention sql ".concat(String.valueOf(str)));
            Cursor rawQuery = mentionStorage.rawQuery(str, new String[0]);
            if (rawQuery != null) {
                try {
                    LinkedList linkedList2 = new LinkedList();
                    Cursor cursor = rawQuery;
                    try {
                        Cursor cursor2 = cursor;
                        while (cursor2.moveToNext()) {
                            Object newInstance = ao.class.newInstance();
                            p.g(newInstance, "T::class.java.newInstance()");
                            IAutoDBItem iAutoDBItem = (IAutoDBItem) newInstance;
                            iAutoDBItem.convertFrom(cursor2);
                            linkedList2.add(iAutoDBItem);
                        }
                        x xVar = x.SXb;
                        b.a(cursor, null);
                        linkedList = linkedList2;
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        b.a(cursor, th2);
                        AppMethodBeat.o(167110);
                        throw th;
                    }
                } catch (Throwable th4) {
                    rawQuery.close();
                    AppMethodBeat.o(167110);
                    throw th4;
                }
            } else {
                linkedList = new LinkedList();
            }
            rawQuery.close();
            AppMethodBeat.o(167110);
            return linkedList;
        }

        public static int t(List<ao> list, int i2) {
            Object valueOf;
            AppMethodBeat.i(252088);
            p.h(list, "mentionList");
            int i3 = 0;
            for (T t : list) {
                a aVar = e.vGT;
                p.h(t, "mention");
                MAutoStorage<cm> mentionStorage = ((PluginFinder) g.ah(PluginFinder.class)).getMentionStorage(Li(i2));
                ao k = k(((ao) t).field_id, ((ao) t).field_createTime, i2);
                if (k != null) {
                    mentionStorage.delete(k.systemRowid);
                }
                boolean insert = mentionStorage.insert(t);
                String str = e.TAG;
                StringBuilder append = new StringBuilder("replace mention success ").append(((ao) t).field_id).append(", ");
                if (k == null) {
                    valueOf = BuildConfig.COMMAND;
                } else {
                    valueOf = Long.valueOf(k.systemRowid);
                }
                Log.i(str, append.append(valueOf).append(", ").append(insert).toString());
                if (insert) {
                    i3++;
                } else {
                    i3 = i3;
                }
            }
            Log.i(e.TAG, "insert mention ".concat(String.valueOf(i3)));
            AppMethodBeat.o(252088);
            return i3;
        }

        public static boolean a(ao aoVar, int i2) {
            AppMethodBeat.i(252089);
            p.h(aoVar, "mention");
            MAutoStorage<cm> mentionStorage = ((PluginFinder) g.ah(PluginFinder.class)).getMentionStorage(Li(i2));
            String str = Li(i2) == 1 ? cm.fFi : cm.fFh;
            String str2 = "UPDATE " + str + " SET extFlag=" + aoVar.field_extFlag + " WHERE id=" + aoVar.field_id;
            boolean execSQL = mentionStorage.execSQL(str, str2);
            Log.i(e.TAG, "updateMentionExtFlag sql:" + str2 + ", flag:" + aoVar.field_extFlag);
            AppMethodBeat.o(252089);
            return execSQL;
        }

        public static com.tencent.mm.plugin.finder.model.a b(ao aoVar) {
            AppMethodBeat.i(252091);
            p.h(aoVar, "mention");
            switch (aoVar.field_type) {
                case 1:
                    av avVar = new av(aoVar);
                    AppMethodBeat.o(252091);
                    return avVar;
                case 2:
                    ba baVar = new ba(aoVar);
                    AppMethodBeat.o(252091);
                    return baVar;
                case 3:
                    au auVar = new au(aoVar);
                    AppMethodBeat.o(252091);
                    return auVar;
                case 4:
                    bd bdVar = new bd(aoVar);
                    AppMethodBeat.o(252091);
                    return bdVar;
                case 5:
                    bb bbVar = new bb(aoVar);
                    AppMethodBeat.o(252091);
                    return bbVar;
                case 6:
                case 9:
                default:
                    AppMethodBeat.o(252091);
                    return null;
                case 7:
                    az azVar = new az(aoVar);
                    AppMethodBeat.o(252091);
                    return azVar;
                case 8:
                    ay ayVar = new ay(aoVar);
                    AppMethodBeat.o(252091);
                    return ayVar;
                case 10:
                    aw awVar = new aw(aoVar);
                    AppMethodBeat.o(252091);
                    return awVar;
                case 11:
                    ax axVar = new ax(aoVar);
                    AppMethodBeat.o(252091);
                    return axVar;
            }
        }

        private static String Lh(int i2) {
            AppMethodBeat.i(252092);
            String str = "SELECT rowid, * FROM " + (Li(i2) == 1 ? cm.fFi : cm.fFh);
            AppMethodBeat.o(252092);
            return str;
        }

        public static int Li(int i2) {
            switch (i2) {
                case 1:
                    return 2;
                case 2:
                    return 1;
                default:
                    return 0;
            }
        }

        public static ao k(long j2, int i2, int i3) {
            Throwable th;
            Throwable th2 = null;
            AppMethodBeat.i(252090);
            Log.i(e.TAG, "getMention by id " + j2 + " mentionCreateTime " + i2);
            MAutoStorage<cm> mentionStorage = ((PluginFinder) g.ah(PluginFinder.class)).getMentionStorage(Li(i3));
            String str = Lh(i3) + " WHERE id = " + j2 + " AND createTime = " + i2;
            Log.d(e.TAG, "get mention sql ".concat(String.valueOf(str)));
            Cursor rawQuery = mentionStorage.rawQuery(str, new String[0]);
            if (rawQuery != null) {
                Cursor cursor = rawQuery;
                try {
                    if (rawQuery.moveToNext()) {
                        ao aoVar = new ao();
                        aoVar.convertFrom(rawQuery);
                        b.a(cursor, null);
                        AppMethodBeat.o(252090);
                        return aoVar;
                    }
                    x xVar = x.SXb;
                    b.a(cursor, null);
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    b.a(cursor, th2);
                    AppMethodBeat.o(252090);
                    throw th;
                }
            }
            AppMethodBeat.o(252090);
            return null;
        }
    }

    static {
        AppMethodBeat.i(167113);
        AppMethodBeat.o(167113);
    }
}
