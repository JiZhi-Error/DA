package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.as;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.x;

public final class ag extends MAutoStorage<k> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(k.info, "FinderSessionInfo")};
    public static final a vFc = new a((byte) 0);
    private final ISQLiteDatabase db;
    public final ConcurrentHashMap<String, k> vFa = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, k> vFb = new ConcurrentHashMap<>();

    public enum b {
        RECEIVE,
        GET_SESSION_ID,
        SELF_REPLY,
        FOR_TEST;

        static {
            AppMethodBeat.i(251859);
            AppMethodBeat.o(251859);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(251861);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(251861);
            return bVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ag(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, k.info, "FinderSessionInfo", cp.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        k.a aVar = k.tyX;
        AppMethodBeat.i(251868);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(251868);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251869);
        k.a aVar = k.tyX;
        AppMethodBeat.o(251869);
    }

    private final k avy(String str) {
        boolean z;
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(251862);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            k kVar = new k();
            AppMethodBeat.o(251862);
            return kVar;
        }
        k kVar2 = this.vFa.get(str);
        if (kVar2 == null) {
            ag agVar = this;
            Cursor rawQuery = agVar.db.rawQuery("select * , rowid from FinderSessionInfo  where talker = '" + str + "' ", null);
            try {
                Cursor cursor = rawQuery;
                if (cursor.moveToFirst()) {
                    k kVar3 = new k();
                    kVar3.convertFrom(cursor);
                    String str3 = kVar3.field_sessionId;
                    p.g(str3, "cache.field_sessionId");
                    agVar.vFb.put(str3, kVar3);
                    agVar.vFa.put(str, kVar3);
                    kotlin.f.b.a(rawQuery, null);
                    AppMethodBeat.o(251862);
                    return kVar3;
                }
                x xVar = x.SXb;
                kotlin.f.b.a(rawQuery, null);
                AppMethodBeat.o(251862);
                return null;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                kotlin.f.b.a(rawQuery, th2);
                AppMethodBeat.o(251862);
                throw th;
            }
        } else {
            AppMethodBeat.o(251862);
            return kVar2;
        }
    }

    public final k avz(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(251863);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            k kVar = new k();
            AppMethodBeat.o(251863);
            return kVar;
        }
        k kVar2 = this.vFb.get(str);
        if (kVar2 == null) {
            ag agVar = this;
            k kVar3 = new k();
            Cursor rawQuery = agVar.db.rawQuery("select * , rowid from FinderSessionInfo where sessionId = '" + str + "' ", null);
            try {
                Cursor cursor = rawQuery;
                if (cursor.moveToFirst()) {
                    kVar3.convertFrom(cursor);
                }
                x xVar = x.SXb;
                kotlin.f.b.a(rawQuery, null);
                if (kVar3.systemRowid > 0) {
                    agVar.vFb.put(str, kVar3);
                    String str3 = kVar3.field_talker;
                    p.g(str3, "cache.field_talker");
                    agVar.vFa.put(str3, kVar3);
                }
                kVar2 = kVar3;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                kotlin.f.b.a(rawQuery, th2);
                AppMethodBeat.o(251863);
                throw th;
            }
        }
        AppMethodBeat.o(251863);
        return kVar2;
    }

    public final String avA(String str) {
        String str2;
        AppMethodBeat.i(251864);
        k avy = avy(str);
        if (avy == null || (str2 = avy.field_sessionId) == null) {
            str2 = "";
        }
        AppMethodBeat.o(251864);
        return str2;
    }

    public final String avB(String str) {
        AppMethodBeat.i(251865);
        String str2 = avz(str).field_talker;
        if (str2 == null) {
            str2 = "";
        }
        AppMethodBeat.o(251865);
        return str2;
    }

    public final void a(String str, String str2, int i2, int i3, b bVar, int i4, int i5) {
        AppMethodBeat.i(251866);
        p.h(str, "sessionId");
        p.h(str2, "talker");
        p.h(bVar, "source");
        k kVar = new k();
        kVar.field_sessionId = str;
        kVar.field_talker = str2;
        kVar.field_type = i2;
        kVar.field_updateTime = cl.aWA();
        kVar.field_selfUsername = z.aUg();
        kVar.field_actionPermission = i3;
        kVar.field_rejectMsg = i4;
        kVar.field_disableSendMsg = i5;
        if (as.avl(str2)) {
            RuntimeException runtimeException = new RuntimeException(str2 + " is invalid");
            AppMethodBeat.o(251866);
            throw runtimeException;
        }
        boolean replace = replace(kVar, false);
        if (replace) {
            this.vFa.remove(str2);
            this.vFb.remove(str);
            doNotify(kVar.field_sessionId);
        }
        if (bVar == b.FOR_TEST) {
            e conversationStorage = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage();
            c avq = conversationStorage.avq(str);
            avq.field_talker = str2;
            avq.field_actionPermission = i3;
            avq.field_type = i2;
            if (!conversationStorage.a(avq, false)) {
                Log.e("Finder.SessionStorage", "[replaceSessionInfo] fail! sessionId=".concat(String.valueOf(str)));
            }
        }
        Log.i("Finder.SessionStorage", "[replaceSessionInfo] source=" + bVar + ", ret=" + replace + ", sessionId=" + str + ", talker=" + str2 + ", actionPermission=" + i3 + ", type=" + i2);
        AppMethodBeat.o(251866);
    }

    public final void dD(String str, int i2) {
        AppMethodBeat.i(251867);
        p.h(str, "sessionId");
        k avz = avz(str);
        avz.field_rejectMsg = i2;
        if (updateNotify(avz, false, null)) {
            this.vFa.remove(avz.field_talker);
            this.vFb.remove(avz.field_sessionId);
            doNotify(avz.field_sessionId);
        }
        AppMethodBeat.o(251867);
    }
}
