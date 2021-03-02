package com.tencent.mm.plugin.textstatus.f.f;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.textstatus.f.f.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class f extends MAutoStorage<com.tencent.mm.plugin.textstatus.h.c> {
    private static final String[] FZH = {MAutoStorage.getCreateSQLs(e.FZC, TABLE)};
    public static final a FZO = new a((byte) 0);
    private static final String TABLE = TABLE;
    private final h<String, e> FZN;
    private final kotlin.f VdJ = g.ah(new c(this));
    private final ISQLiteDatabase db;

    public final String hRD() {
        AppMethodBeat.i(258413);
        String str = (String) this.VdJ.getValue();
        AppMethodBeat.o(258413);
        return str;
    }

    public static final class b extends q implements kotlin.g.a.b<Character, String> {
        public static final b FZQ = new b();

        static {
            AppMethodBeat.i(216290);
            AppMethodBeat.o(216290);
        }

        b() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(Character ch) {
            AppMethodBeat.i(216289);
            String valueOf = String.valueOf(ch.charValue());
            AppMethodBeat.o(216289);
            return valueOf;
        }
    }

    public static final /* synthetic */ String b(f fVar) {
        AppMethodBeat.i(258414);
        String hRD = fVar.hRD();
        AppMethodBeat.o(258414);
        return hRD;
    }

    public static final /* synthetic */ String le(String str, String str2) {
        AppMethodBeat.i(216296);
        String fA = fA(str, str2);
        AppMethodBeat.o(216296);
        return fA;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, e.FZC, TABLE, null);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        e.a aVar = e.FZM;
        AppMethodBeat.i(216293);
        this.db = iSQLiteDatabase;
        d.b("TextStatusUserNameMapStorage_INIT", new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.textstatus.f.f.f.AnonymousClass1 */
            final /* synthetic */ f FZP;

            {
                this.FZP = r2;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(216288);
                Log.i("MicroMsg.TxtStatus.TextStatusUserNameMapStorage", "init start");
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                long a2 = aAh.azQ().a(ar.a.USERINFO_TEXT_STATUS_LAST_SYNC_USERNAMEMAP_LONG_SYNC, 0);
                if (System.currentTimeMillis() - a2 < 604800000) {
                    Log.w("MicroMsg.TxtStatus.TextStatusUserNameMapStorage", "lastSyncTime: " + a2 + ", not need to sync now~");
                } else {
                    com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_TEXT_STATUS_LAST_SYNC_USERNAMEMAP_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                    String b2 = f.b(this.FZP);
                    if (b2 == null || b2.length() == 0) {
                        Log.e("MicroMsg.TxtStatus.TextStatusUserNameMapStorage", "salt is empty");
                    } else {
                        LinkedHashSet<e> linkedHashSet = new LinkedHashSet();
                        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(l.class);
                        p.g(af, "service(IMessengerStorage::class.java)");
                        Cursor gCq = ((l) af).aSN().gCq();
                        if (gCq != null) {
                            as asVar = new as();
                            while (gCq.moveToNext()) {
                                asVar.convertFrom(gCq);
                                e eVar = new e();
                                eVar.field_UserName = asVar.getUsername();
                                linkedHashSet.add(eVar);
                            }
                            gCq.close();
                        }
                        Log.i("MicroMsg.TxtStatus.TextStatusUserNameMapStorage", "get contact done");
                        for (e eVar2 : linkedHashSet) {
                            String str = eVar2.field_UserName;
                            p.g(str, "it.field_UserName");
                            eVar2.field_HashUserName = f.le(str, f.b(this.FZP));
                        }
                        Log.i("MicroMsg.TxtStatus.TextStatusUserNameMapStorage", "compute salt done");
                        ISQLiteDatabase iSQLiteDatabase = this.FZP.db;
                        if (iSQLiteDatabase == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.storagebase.SqliteDB");
                            AppMethodBeat.o(216288);
                            throw tVar;
                        }
                        com.tencent.mm.storagebase.h hVar = (com.tencent.mm.storagebase.h) iSQLiteDatabase;
                        Thread currentThread = Thread.currentThread();
                        p.g(currentThread, "Thread.currentThread()");
                        long beginTransaction = hVar.beginTransaction(currentThread.getId());
                        for (e eVar3 : linkedHashSet) {
                            this.FZP.replace(eVar3);
                        }
                        hVar.endTransaction(beginTransaction);
                        Log.i("MicroMsg.TxtStatus.TextStatusUserNameMapStorage", "init end");
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(216288);
                return xVar;
            }
        });
        this.FZN = new h<>(20);
        AppMethodBeat.o(216293);
    }

    static {
        AppMethodBeat.i(216294);
        e.a aVar = e.FZM;
        AppMethodBeat.o(216294);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.as aTn(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 166
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.f.f.f.aTn(java.lang.String):com.tencent.mm.storage.as");
    }

    public static String fA(String str, String str2) {
        AppMethodBeat.i(216292);
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            Charset charset = kotlin.n.d.UTF_8;
            if (str2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(216292);
                throw tVar;
            }
            byte[] bytes = str2.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.init(new SecretKeySpec(bytes, "HmacSHA256"));
            Charset charset2 = kotlin.n.d.UTF_8;
            if (str == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(216292);
                throw tVar2;
            }
            byte[] bytes2 = str.getBytes(charset2);
            p.g(bytes2, "(this as java.lang.String).getBytes(charset)");
            String encodeHexString = Util.encodeHexString(instance.doFinal(bytes2));
            p.g(encodeHexString, "Util.encodeHexString(sha…inal(text.toByteArray()))");
            AppMethodBeat.o(216292);
            return encodeHexString;
        } catch (Exception e2) {
            AppMethodBeat.o(216292);
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ f FZP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar) {
            super(0);
            this.FZP = fVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(258412);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String a2 = aAh.azQ().a(ar.a.USERINFO_ACCOUNT_SALT_STRING_SYNC, (String) null);
            String str = a2;
            if (str == null || str.length() == 0) {
                Log.w("MicroMsg.TxtStatus.TextStatusUserNameMapStorage", "ACC_SALT is empty");
                AppMethodBeat.o(258412);
                return "";
            }
            String ld = f.ld(a2, "765272c5645917a2578092a523cd2a37ccf0b352d16d9744d5b5bd4668e71c4a");
            AppMethodBeat.o(258412);
            return ld;
        }
    }

    public static final /* synthetic */ String ld(String str, String str2) {
        AppMethodBeat.i(216295);
        String str3 = str;
        ArrayList arrayList = new ArrayList(str3.length());
        int i2 = 0;
        int i3 = 0;
        while (i2 < str3.length()) {
            arrayList.add(Character.valueOf((char) (str2.charAt(i3) ^ str3.charAt(i2))));
            i2++;
            i3++;
        }
        String a2 = j.a(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, b.FZQ, 30);
        AppMethodBeat.o(216295);
        return a2;
    }
}
