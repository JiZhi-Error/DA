package com.tencent.mm.w;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m hgI;
    a hgJ;
    private MStorageEx.IOnStorageChange hgK = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.w.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(127632);
            if (!b.axb()) {
                AppMethodBeat.o(127632);
                return;
            }
            String str = (obj == null || !(obj instanceof String)) ? null : (String) obj;
            switch (i2) {
                case 2:
                    if (str != null) {
                        b.this.hgI.a(65636, new f(str));
                        AppMethodBeat.o(127632);
                        return;
                    }
                    break;
                case 5:
                    if (str != null) {
                        b.this.hgI.a(65636, new d(str));
                        break;
                    } else {
                        b.this.hgI.a(65636, new c());
                        AppMethodBeat.o(127632);
                        return;
                    }
            }
            AppMethodBeat.o(127632);
        }
    };

    public b() {
        AppMethodBeat.i(127644);
        AppMethodBeat.o(127644);
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final String getName() {
        return "FTS5SearchFriendLogic";
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean onCreate() {
        AppMethodBeat.i(127645);
        if (!((n) com.tencent.mm.kernel.g.ah(n.class)).isFTSContextReady()) {
            Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
            AppMethodBeat.o(127645);
            return false;
        }
        Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
        this.hgJ = (a) ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexStorage(TAVExporter.VIDEO_EXPORT_HEIGHT);
        this.hgI = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSTaskDaemon();
        this.hgI.a(131172, new C2167b(this, (byte) 0));
        ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().add(this.hgK);
        AppMethodBeat.o(127645);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean axa() {
        AppMethodBeat.i(127646);
        ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().remove(this.hgK);
        AppMethodBeat.o(127646);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final com.tencent.mm.plugin.fts.a.a.a a(j jVar) {
        AppMethodBeat.i(127647);
        com.tencent.mm.plugin.fts.a.a.a a2 = this.hgI.a(-65536, new g(jVar));
        AppMethodBeat.o(127647);
        return a2;
    }

    class g extends i {
        private int[] hha;
        private int[] hhb;

        public g(j jVar) {
            super(jVar);
            this.hha = jVar.wWU;
            this.hhb = jVar.wWV;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            com.tencent.mm.plugin.fts.a.a.m mVar;
            AppMethodBeat.i(127643);
            super.a(kVar);
            a aVar = b.this.hgJ;
            String[] strArr = kVar.wWd.wWD;
            int[] iArr = this.hha;
            int[] iArr2 = this.hhb;
            String I = com.tencent.mm.plugin.fts.a.d.I(strArr);
            Cursor ayh = aVar.wUt.ayh(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + String.format(", MMHighlight(%s, %d, type, subtype)", aVar.dOu(), Integer.valueOf(strArr.length)) + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + ((iArr == null || iArr.length <= 0) ? "" : " AND type IN " + com.tencent.mm.plugin.fts.a.d.C(iArr)) + "" + " AND status >= 0" + ((iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + com.tencent.mm.plugin.fts.a.d.C(iArr2)) + ";", aVar.dOt(), aVar.dOt(), aVar.dOu(), aVar.dOt(), aVar.dOu(), aVar.dOu(), I));
            HashMap hashMap = new HashMap();
            while (ayh.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n i2 = new com.tencent.mm.plugin.fts.a.a.n().i(ayh);
                if (!this.wWO.wWX.contains(i2.wVX) && ((mVar = (com.tencent.mm.plugin.fts.a.a.m) hashMap.get(Long.valueOf(i2.wXe))) == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.wUV, i2.wVW, mVar.wVW) < 0)) {
                    i2.dOC();
                    hashMap.put(Long.valueOf(i2.wXe), i2);
                }
            }
            ayh.close();
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(127643);
                throw interruptedException;
            }
            kVar.wXb = new ArrayList();
            kVar.wXb.addAll(hashMap.values());
            if (this.wWO.wWY != null) {
                Collections.sort(kVar.wXb, this.wWO.wWY);
            }
            AppMethodBeat.o(127643);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "FTS5SearchFriendLogic.NormalSearchTask";
        }
    }

    /* renamed from: com.tencent.mm.w.b$b  reason: collision with other inner class name */
    class C2167b extends com.tencent.mm.plugin.fts.a.a.a {
        public boolean hgQ;
        private HashSet<Long> hgR;
        private long hgS;
        private int hgT;
        private HashMap<int[], e> hgU;

        private C2167b() {
            AppMethodBeat.i(127634);
            this.hgQ = false;
            this.hgR = null;
            this.hgS = Long.MIN_VALUE;
            this.hgT = -1;
            this.hgU = new HashMap<>();
            AppMethodBeat.o(127634);
        }

        /* synthetic */ C2167b(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            int i2;
            int i3;
            AppMethodBeat.i(127635);
            Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
            this.hgQ = b.axb();
            if (this.hgT < 0) {
                this.hgT = 0;
            }
            Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", Boolean.valueOf(this.hgQ), Integer.valueOf(this.hgT));
            if (this.hgT == 0) {
                if (this.hgQ) {
                    if (!this.hgU.containsKey(com.tencent.mm.plugin.fts.a.c.wUM)) {
                        this.hgU.put(com.tencent.mm.plugin.fts.a.c.wUM, new e((byte) 0));
                    }
                    if (this.hgR == null) {
                        this.hgR = new HashSet<>();
                        Cursor a2 = b.this.hgJ.a(com.tencent.mm.plugin.fts.a.c.wUM, false, true, false, false, false);
                        while (a2.moveToNext()) {
                            this.hgR.add(Long.valueOf(a2.getLong(0)));
                        }
                        a2.close();
                    }
                    if (Thread.interrupted()) {
                        InterruptedException interruptedException = new InterruptedException();
                        AppMethodBeat.o(127635);
                        throw interruptedException;
                    }
                    Cursor i4 = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSMainDB().i("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[]{Long.toString(this.hgS)});
                    int i5 = 50;
                    while (i4.moveToNext()) {
                        if (Thread.interrupted()) {
                            i4.close();
                            b.this.hgJ.commit();
                            InterruptedException interruptedException2 = new InterruptedException();
                            AppMethodBeat.o(127635);
                            throw interruptedException2;
                        }
                        long j2 = i4.getLong(0);
                        this.hgS = j2;
                        a aVar = new a();
                        aVar.id = j2;
                        aVar.realName = i4.getString(1);
                        aVar.hgM = i4.getString(2);
                        aVar.hgN = i4.getString(3);
                        aVar.nickName = i4.getString(4);
                        aVar.hgO = i4.getString(5);
                        aVar.hgP = i4.getString(6);
                        aVar.userName = i4.getString(7);
                        aVar.status = i4.getInt(8);
                        aVar.dSf = i4.getString(9);
                        aVar.type = 0;
                        if (aVar.status == 65536) {
                            aVar.status = 0;
                        }
                        if (b.a(aVar) && !this.hgR.remove(Long.valueOf(aVar.id))) {
                            if (i5 >= 50) {
                                b.this.hgJ.commit();
                                b.this.hgJ.beginTransaction();
                                i3 = 0;
                            } else {
                                i3 = i5;
                            }
                            try {
                                i3 += b.a(b.this, aVar);
                                this.hgU.get(com.tencent.mm.plugin.fts.a.c.wUM).hgX++;
                                i5 = i3;
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", e2, "Build mobile friend index failed with exception.", new Object[0]);
                                this.hgU.get(com.tencent.mm.plugin.fts.a.c.wUM).mFailedCount++;
                                i5 = i3;
                            }
                        }
                    }
                    i4.close();
                    b.this.hgJ.commit();
                    Iterator<Long> it = this.hgR.iterator();
                    int i6 = 50;
                    while (it.hasNext()) {
                        if (i6 >= 50) {
                            b.this.hgJ.commit();
                            b.this.hgJ.beginTransaction();
                            i2 = 0;
                        } else {
                            i2 = i6;
                        }
                        b.this.hgJ.c(com.tencent.mm.plugin.fts.a.c.wUM, it.next().longValue());
                        this.hgU.get(com.tencent.mm.plugin.fts.a.c.wUM).hgY++;
                        it.remove();
                        i6 = i2 + 1;
                    }
                    b.this.hgJ.commit();
                    this.hgR = null;
                    this.hgS = Long.MIN_VALUE;
                }
                this.hgT = -1;
            }
            AppMethodBeat.o(127635);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(127636);
            if (this.hgU.containsKey(com.tencent.mm.plugin.fts.a.c.wUM)) {
                String str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + this.hgU.get(com.tencent.mm.plugin.fts.a.c.wUM).hgX + ", removed: " + this.hgU.get(com.tencent.mm.plugin.fts.a.c.wUM).hgY + ", failed: " + this.hgU.get(com.tencent.mm.plugin.fts.a.c.wUM).mFailedCount + "]";
                AppMethodBeat.o(127636);
                return str;
            }
            AppMethodBeat.o(127636);
            return "";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 2;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "BuildFriendIndexTask";
        }
    }

    class f extends com.tencent.mm.plugin.fts.a.a.a {
        private int hgV;
        private String hgW;
        private boolean hgZ = false;

        public f(String str) {
            this.hgW = str;
            this.hgV = 0;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(127641);
            Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", this.hgW, Integer.valueOf(this.hgV));
            if (this.hgV == 0) {
                com.tencent.mm.plugin.account.friend.a.a SU = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SU(this.hgW);
                if (SU == null) {
                    this.hgZ = true;
                    AppMethodBeat.o(127641);
                    return true;
                }
                a aVar = new a(SU);
                if (b.a(aVar)) {
                    b.a(b.this, aVar);
                } else {
                    this.hgZ = true;
                }
            }
            AppMethodBeat.o(127641);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(127642);
            String str = "InsertFriend(\"" + this.hgW + "\", " + this.hgV + ")" + (this.hgZ ? " [skipped]" : "");
            AppMethodBeat.o(127642);
            return str;
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private int hgV = 0;
        private String hgW;

        public d(String str) {
            this.hgW = str;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(127639);
            Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", this.hgW, Integer.valueOf(this.hgV));
            if (this.hgV == 0) {
                b.this.hgJ.c(com.tencent.mm.plugin.fts.a.c.wUM, (long) com.tencent.mm.plugin.account.friend.a.a.SQ(this.hgW));
            }
            AppMethodBeat.o(127639);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(127640);
            String str = "DeleteFriend(\"" + this.hgW + "\", " + this.hgV + ")";
            AppMethodBeat.o(127640);
            return str;
        }
    }

    class c extends com.tencent.mm.plugin.fts.a.a.a {
        private int hgV = 0;
        private int mCount = 0;

        public c() {
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(127637);
            Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", Integer.valueOf(this.hgV));
            if (this.hgV == 0) {
                this.mCount = b.this.hgJ.j(com.tencent.mm.plugin.fts.a.c.wUM, -1).size();
            }
            AppMethodBeat.o(127637);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(127638);
            String str = "DeleteAllFriends [" + this.mCount + ", " + this.hgV + "]";
            AppMethodBeat.o(127638);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String dSf;
        String hgM;
        String hgN;
        String hgO;
        String hgP;
        long id;
        String nickName;
        String realName;
        int status;
        int type;
        String userName;

        a() {
        }

        a(com.tencent.mm.plugin.account.friend.a.a aVar) {
            AppMethodBeat.i(127633);
            this.id = (long) com.tencent.mm.plugin.account.friend.a.a.SQ(aVar.getMd5());
            this.realName = aVar.bnK();
            this.hgM = aVar.bnM();
            this.hgN = aVar.bnL();
            this.nickName = aVar.getNickName();
            this.hgO = aVar.bnO();
            this.hgP = aVar.bnN();
            this.userName = aVar.getUsername();
            this.dSf = aVar.bnP();
            this.type = aVar.type;
            this.status = aVar.status;
            AppMethodBeat.o(127633);
        }
    }

    static class e {
        public int hgX;
        public int hgY;
        public int mFailedCount;

        private e() {
            this.hgX = 0;
            this.hgY = 0;
            this.mFailedCount = 0;
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }

    static /* synthetic */ boolean axb() {
        AppMethodBeat.i(127648);
        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(6, (Object) null);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(127648);
            return false;
        }
        AppMethodBeat.o(127648);
        return true;
    }

    static /* synthetic */ boolean a(a aVar) {
        return aVar.type == 0 && aVar.status != 2;
    }

    static /* synthetic */ int a(b bVar, a aVar) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(127649);
        long currentTimeMillis = System.currentTimeMillis();
        String nullAsNil = Util.nullAsNil(aVar.userName);
        int i3 = aVar.status != 0 ? 131073 : 131074;
        if (aVar.dSf == null || aVar.dSf.length() <= 0) {
            i2 = 0;
        } else {
            bVar.hgJ.a(i3, 16, aVar.id, aVar.userName, currentTimeMillis, aVar.dSf);
            i2 = 1;
        }
        String str5 = aVar.realName;
        String str6 = aVar.hgM;
        String str7 = aVar.hgN;
        if (str5 != null && str5.length() > 0) {
            if (str5.equalsIgnoreCase(str6)) {
                str3 = null;
            } else {
                str3 = str6;
            }
            if (str3 == null || str3.equalsIgnoreCase(str7)) {
                str4 = null;
            } else {
                str4 = str7;
            }
            bVar.hgJ.a(i3, 12, aVar.id, nullAsNil, currentTimeMillis, str5);
            i2++;
            if (str3 != null) {
                bVar.hgJ.a(i3, 13, aVar.id, nullAsNil, currentTimeMillis, str3);
                i2++;
            }
            if (str4 != null) {
                bVar.hgJ.a(i3, 14, aVar.id, nullAsNil, currentTimeMillis, str4);
                i2++;
            }
        }
        String str8 = aVar.nickName;
        String str9 = aVar.hgO;
        String str10 = aVar.hgP;
        if (str8 != null && str8.length() > 0) {
            if (str8.equalsIgnoreCase(str9)) {
                str = null;
            } else {
                str = str9;
            }
            if (str == null || str.equalsIgnoreCase(str10)) {
                str2 = null;
            } else {
                str2 = str10;
            }
            bVar.hgJ.a(i3, 5, aVar.id, nullAsNil, currentTimeMillis, str8);
            i2++;
            if (str != null) {
                bVar.hgJ.a(i3, 6, aVar.id, nullAsNil, currentTimeMillis, str);
                i2++;
            }
            if (str2 != null) {
                bVar.hgJ.a(i3, 7, aVar.id, nullAsNil, currentTimeMillis, str2);
                i2++;
            }
        }
        AppMethodBeat.o(127649);
        return i2;
    }
}
