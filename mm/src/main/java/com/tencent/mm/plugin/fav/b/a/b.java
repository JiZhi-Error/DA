package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.recovery.log.RecoveryFileLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m hgI;
    private j tbO;
    a tbP;
    ISQLiteDatabase tbQ;
    private MStorage.IOnStorageChange tbR = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.fav.b.a.b.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(101561);
            if (mStorageEventData == null) {
                AppMethodBeat.o(101561);
                return;
            }
            int i2 = mStorageEventData.eventId;
            if (mStorageEventData.obj == null) {
                AppMethodBeat.o(101561);
                return;
            }
            long longValue = ((Long) mStorageEventData.obj).longValue();
            if (longValue < 0) {
                AppMethodBeat.o(101561);
                return;
            }
            Log.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "EventData: %s", mStorageEventData);
            switch (i2) {
                case 2:
                case 3:
                    b.this.hgI.a(65576, new d(b.this, longValue, (byte) 0));
                    AppMethodBeat.o(101561);
                    return;
                case 5:
                    b.this.hgI.a(65576, new C1043b(longValue));
                    break;
            }
            AppMethodBeat.o(101561);
        }
    };

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j jVar) {
        com.tencent.mm.plugin.fts.a.a.a eVar;
        AppMethodBeat.i(101571);
        if (jVar.kXb == 1) {
            eVar = new f(jVar);
        } else {
            eVar = new e(jVar);
        }
        com.tencent.mm.plugin.fts.a.a.a a2 = this.hgI.a(-65536, eVar);
        AppMethodBeat.o(101571);
        return a2;
    }

    public b() {
        AppMethodBeat.i(101572);
        AppMethodBeat.o(101572);
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean onCreate() {
        AppMethodBeat.i(101573);
        if (!((n) g.ah(n.class)).isFTSContextReady()) {
            Log.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Fail!");
            AppMethodBeat.o(101573);
            return false;
        }
        Log.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Success!");
        this.hgI = ((n) g.ah(n.class)).getFTSTaskDaemon();
        this.tbP = (a) ((n) g.ah(n.class)).getFTSIndexStorage(256);
        this.tbO = ((n) g.ah(n.class)).getFTSMainDB();
        this.tbQ = ((af) g.ah(af.class)).getFavItemInfoStorage().cUP();
        this.hgI.a(131122, new a(this, (byte) 0));
        ((af) g.ah(af.class)).getFavItemInfoStorage().add(this.tbR);
        AppMethodBeat.o(101573);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean axa() {
        AppMethodBeat.i(101574);
        ((af) g.ah(af.class)).getFavItemInfoStorage().remove(this.tbR);
        this.tbP = null;
        this.hgI = null;
        AppMethodBeat.o(101574);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final String getName() {
        return "FTS5SearchFavoriteLogic";
    }

    class f extends i {
        f(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchTopFavoriteTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 9;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(101570);
            kVar.wWd = h.bE(this.wWO.query, true);
            a aVar = b.this.tbP;
            String dOz = kVar.wWd.dOz();
            Cursor rawQuery = aVar.wUt.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (this.wWO.wWW + 1 + 1) + ";", aVar.dOt(), aVar.dOt(), aVar.dOu(), aVar.dOt(), aVar.dOu(), aVar.dOu(), dOz), null);
            kVar.wXb = new ArrayList();
            HashSet hashSet = new HashSet();
            while (rawQuery.moveToNext()) {
                if (hashSet.add(String.valueOf(rawQuery.getLong(3)))) {
                    kVar.wXb.add(new com.tencent.mm.plugin.fts.a.a.n().i(rawQuery));
                    if (kVar.wXb.size() > this.wWO.wWW) {
                        break;
                    } else if (Thread.interrupted()) {
                        rawQuery.close();
                        InterruptedException interruptedException = new InterruptedException();
                        AppMethodBeat.o(101570);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            if (Thread.interrupted()) {
                InterruptedException interruptedException2 = new InterruptedException();
                AppMethodBeat.o(101570);
                throw interruptedException2;
            }
            AppMethodBeat.o(101570);
        }
    }

    class e extends i {
        e(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchFavoriteTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(101569);
            kVar.wWd = h.bE(this.wWO.query, true);
            HashMap hashMap = new HashMap();
            Cursor a2 = b.this.tbP.a(kVar.wWd, com.tencent.mm.plugin.fts.a.c.wUD, null, false, false);
            while (a2.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n i2 = new com.tencent.mm.plugin.fts.a.a.n().i(a2);
                com.tencent.mm.plugin.fts.a.a.m mVar = (com.tencent.mm.plugin.fts.a.a.m) hashMap.get(Long.valueOf(i2.wXe));
                if (mVar == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.wUW, i2.wVW, mVar.wVW) < 0) {
                    hashMap.put(Long.valueOf(i2.wXe), i2);
                }
                if (Thread.interrupted()) {
                    a2.close();
                    InterruptedException interruptedException = new InterruptedException();
                    AppMethodBeat.o(101569);
                    throw interruptedException;
                }
            }
            a2.close();
            if (Thread.interrupted()) {
                InterruptedException interruptedException2 = new InterruptedException();
                AppMethodBeat.o(101569);
                throw interruptedException2;
            }
            kVar.wXb = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.n nVar : hashMap.values()) {
                kVar.wXb.add(nVar);
            }
            if (this.wWO.wWY != null) {
                Collections.sort(kVar.wXb, this.wWO.wWY);
            }
            AppMethodBeat.o(101569);
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int mFailedCount;
        private HashSet<Long> tbT;
        private int tbU;
        private int tbV;
        private int tbW;

        private a() {
            this.tbT = null;
            this.tbU = 0;
            this.tbV = 0;
            this.tbW = 0;
            this.mFailedCount = 0;
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
        @Override // com.tencent.mm.plugin.fts.a.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            /*
            // Method dump skipped, instructions count: 397
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.b.a.b.a.execute():boolean");
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(101563);
            String format = String.format("{new: %d exist: %d removed: %d failed: %d}", Integer.valueOf(this.tbV), Integer.valueOf(this.tbU), Integer.valueOf(this.tbW), Integer.valueOf(this.mFailedCount));
            AppMethodBeat.o(101563);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "BuildFavoriteIndexTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 6;
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private long tbX;
        private int tbZ;

        /* synthetic */ d(b bVar, long j2, byte b2) {
            this(j2);
        }

        private d(long j2) {
            this.tbX = j2;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(101567);
            if (b.this.tbQ == null) {
                Log.e("MicroMsg.FTS.FTS5SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
                AppMethodBeat.o(101567);
            } else {
                Log.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to insert favorite item");
                Cursor rawQuery = b.this.tbQ.rawQuery("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[]{String.valueOf(this.tbX)}, 2);
                try {
                    if (rawQuery.moveToFirst()) {
                        c cVar = new c(b.this, (byte) 0);
                        cVar.convertFrom(rawQuery);
                        rawQuery.close();
                        rawQuery = null;
                        if (b.a(cVar)) {
                            AppMethodBeat.o(101567);
                        } else {
                            b.this.tbP.beginTransaction();
                            b.this.tbP.c(com.tencent.mm.plugin.fts.a.c.wUD, this.tbX);
                            this.tbZ = b.a(b.this, cVar);
                            b.this.tbP.commit();
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.o(101567);
                } catch (Exception e2) {
                    AppMethodBeat.o(101567);
                    throw e2;
                } catch (Throwable th) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.o(101567);
                    throw th;
                }
            }
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(101568);
            String format = String.format("{favItemId: %d transactionCount: %d}", Long.valueOf(this.tbX), Integer.valueOf(this.tbZ));
            AppMethodBeat.o(101568);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "InsertFavItemTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.a.b$b  reason: collision with other inner class name */
    class C1043b extends com.tencent.mm.plugin.fts.a.a.a {
        private long tbX;

        public C1043b(long j2) {
            this.tbX = j2;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(101564);
            Log.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to delete favorite item");
            b.this.tbP.c(com.tencent.mm.plugin.fts.a.c.wUD, this.tbX);
            AppMethodBeat.o(101564);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(101565);
            String format = String.format("{favItemId: %d}", Long.valueOf(this.tbX));
            AppMethodBeat.o(101565);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "DeleteFavItemTask";
        }
    }

    private int a(String[] strArr, int[] iArr, long j2, int i2, long j3, String str) {
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(101575);
        int i3 = 0;
        String str5 = strArr[0];
        String str6 = strArr[1];
        String str7 = strArr[2];
        if (str5 != null && str5.length() > 0) {
            if (str5.equalsIgnoreCase(str6)) {
                str2 = null;
                str3 = null;
            } else {
                str2 = str6;
                str3 = str7;
            }
            if (str2 == null || !str2.equalsIgnoreCase(str3)) {
                str4 = str3;
            } else {
                str4 = null;
            }
            this.tbP.a(iArr[0], j2, str, j3, str5, i2);
            int i4 = 1;
            if (str2 != null && str2.length() > 0) {
                this.tbP.a(iArr[1], j2, str, j3, str2, i2);
                i4 = 2;
            }
            if (str4 == null || str4.length() <= 0) {
                i3 = i4;
            } else {
                this.tbP.a(iArr[2], j2, str, j3, str4, i2);
                i3 = i4 + 1;
            }
        }
        AppMethodBeat.o(101575);
        return i3;
    }

    /* access modifiers changed from: package-private */
    public class c {
        long crj;
        String dRL;
        anb dXI;
        long localId;
        ano tbY;
        int type;

        private c() {
        }

        /* synthetic */ c(b bVar, byte b2) {
            this();
        }

        public final void convertFrom(Cursor cursor) {
            AppMethodBeat.i(101566);
            this.localId = cursor.getLong(0);
            this.type = cursor.getInt(1);
            this.crj = cursor.getLong(2);
            this.dRL = cursor.getString(3);
            byte[] blob = cursor.getBlob(4);
            if (blob == null || blob.length == 0) {
                Log.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
                this.dXI = new anb();
            } else {
                this.dXI = (anb) new anb().parseFrom(blob);
            }
            byte[] blob2 = cursor.getBlob(5);
            if (blob2 == null || blob2.length == 0) {
                this.tbY = null;
                AppMethodBeat.o(101566);
                return;
            }
            this.tbY = (ano) new ano().parseFrom(blob2);
            AppMethodBeat.o(101566);
        }
    }

    static /* synthetic */ boolean a(c cVar) {
        AppMethodBeat.i(101576);
        if (cVar.dXI == null) {
            AppMethodBeat.o(101576);
            return false;
        }
        anb anb = cVar.dXI;
        switch (cVar.type) {
            case 4:
                if (anb.ppH != null && !anb.ppH.isEmpty()) {
                    aml aml = anb.ppH.get(0);
                    if (!(aml.Lwh == null || aml.Lwh.Lxi == null)) {
                        AppMethodBeat.o(101576);
                        return true;
                    }
                }
                AppMethodBeat.o(101576);
                return false;
            default:
                AppMethodBeat.o(101576);
                return false;
        }
    }

    static /* synthetic */ int a(b bVar, c cVar) {
        String str;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        as ayj;
        as ayj2;
        as ayj3;
        String str3;
        String str4;
        String str5;
        AppMethodBeat.i(101577);
        long j2 = cVar.localId;
        int i6 = cVar.type;
        long j3 = cVar.crj;
        String str6 = cVar.dRL;
        anb anb = cVar.dXI;
        amq a2 = com.tencent.mm.plugin.fav.a.b.a(i6, anb, cVar.tbY);
        if (a2 == null) {
            Log.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Fav info is null");
            AppMethodBeat.o(101577);
            return 0;
        }
        String str7 = a2.LxL;
        String str8 = a2.dRL;
        if (str7 == null || str7.length() == 0 || str7.equals(str8)) {
            str2 = null;
            str = a2.dRL;
        } else {
            str2 = str8;
            str = str7;
        }
        String str9 = a2.dCl;
        String[] strArr = new String[3];
        int[] iArr = new int[3];
        if (str == null || str.length() <= 0 || (ayj3 = bVar.tbO.ayj(str)) == null) {
            i2 = 0;
        } else {
            String str10 = ayj3.field_nickname;
            String bB = com.tencent.mm.plugin.fts.a.d.bB(str10, false);
            String bB2 = com.tencent.mm.plugin.fts.a.d.bB(str10, true);
            String str11 = ayj3.field_conRemark;
            String bB3 = com.tencent.mm.plugin.fts.a.d.bB(str11, false);
            String bB4 = com.tencent.mm.plugin.fts.a.d.bB(str11, true);
            if (str11 == null || str11.length() == 0) {
                str3 = null;
                str4 = null;
                str5 = null;
                bB3 = bB;
                str11 = str10;
                bB4 = bB2;
            } else {
                str5 = bB2;
                str4 = bB;
                str3 = str10;
            }
            strArr[0] = str11;
            strArr[1] = bB3;
            strArr[2] = bB4;
            iArr[0] = 9;
            iArr[1] = 10;
            iArr[2] = 11;
            strArr[0] = str3;
            strArr[1] = str4;
            strArr[2] = str5;
            iArr[0] = 12;
            iArr[1] = 13;
            iArr[2] = 14;
            i2 = bVar.a(strArr, iArr, j2, i6, j3, str6) + 0 + bVar.a(strArr, iArr, j2, i6, j3, str6);
        }
        if (str2 == null || str2.length() <= 0 || (ayj2 = bVar.tbO.ayj(str2)) == null) {
            i3 = i2;
        } else {
            String str12 = ayj2.field_conRemark;
            if (str12 == null || str12.length() == 0) {
                str12 = ayj2.field_nickname;
            }
            String bB5 = com.tencent.mm.plugin.fts.a.d.bB(str12, false);
            String bB6 = com.tencent.mm.plugin.fts.a.d.bB(str12, true);
            strArr[0] = str12;
            strArr[1] = bB5;
            strArr[2] = bB6;
            iArr[0] = 16;
            iArr[1] = 17;
            iArr[2] = 18;
            i3 = i2 + bVar.a(strArr, iArr, j2, i6, j3, str6);
        }
        if (str9 == null || str9.length() <= 0 || (ayj = bVar.tbO.ayj(str9)) == null) {
            i4 = i3;
        } else {
            String str13 = ayj.field_conRemark;
            if (str13 == null || str13.length() == 0) {
                str13 = ayj.field_nickname;
            }
            String bB7 = com.tencent.mm.plugin.fts.a.d.bB(str13, false);
            String bB8 = com.tencent.mm.plugin.fts.a.d.bB(str13, true);
            strArr[0] = str13;
            strArr[1] = bB7;
            strArr[2] = bB8;
            iArr[0] = 20;
            iArr[1] = 21;
            iArr[2] = 22;
            i4 = bVar.a(strArr, iArr, j2, i6, j3, str6) + i3;
        }
        LinkedList<String> linkedList = a2.LxM;
        StringBuilder sb = new StringBuilder(256);
        for (String str14 : linkedList) {
            if (str14 != null && str14.length() > 0) {
                sb.append(str14).append(RecoveryFileLog.SPLITTER);
            }
        }
        if (sb.length() > 0) {
            bVar.tbP.a(7, j2, str6, j3, sb.toString(), i6);
            i4++;
        }
        switch (i6) {
            case 2:
                String str15 = a2.title;
                if (!Util.isNullOrNil(str15)) {
                    bVar.tbP.a(23, j2, str6, j3, str15, i6);
                    i4++;
                    break;
                }
                break;
            case 5:
                String str16 = a2.title;
                if (!Util.isNullOrNil(str16)) {
                    bVar.tbP.a(1, j2, str6, j3, str16, i6);
                    i4++;
                    break;
                }
                break;
            case 6:
                String str17 = anb.remark;
                if (!Util.isNullOrNil(str17)) {
                    bVar.tbP.a(4, j2, str6, j3, str17, i6);
                    i5 = i4 + 1;
                } else {
                    i5 = i4;
                }
                String str18 = anb.LwQ.dWi;
                if (!Util.isNullOrNil(str18)) {
                    bVar.tbP.a(5, j2, str6, j3, str18, i6);
                    i5++;
                }
                String str19 = anb.LwQ.label;
                if (!Util.isNullOrNil(str19)) {
                    bVar.tbP.a(6, j2, str6, j3, str19, i6);
                    i4 = i5 + 1;
                    break;
                } else {
                    i4 = i5;
                    break;
                }
            case 7:
            case 21:
                String str20 = a2.title;
                if (!Util.isNullOrNil(str20)) {
                    bVar.tbP.a(1, j2, str6, j3, str20, i6);
                    i4++;
                }
                String str21 = a2.desc;
                if (!Util.isNullOrNil(str21)) {
                    bVar.tbP.a(3, j2, str6, j3, str21, i6);
                    i4++;
                    break;
                }
                break;
            case 14:
                if (anb.ppH != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator<aml> it = anb.ppH.iterator();
                    while (it.hasNext()) {
                        String c2 = com.tencent.mm.plugin.fav.a.b.c(it.next());
                        if (!Util.isNullOrNil(c2)) {
                            sb.append(c2);
                            sb.append(RecoveryFileLog.SPLITTER);
                        }
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (!Util.isNullOrNil(stringBuffer2)) {
                        bVar.tbP.a(1, j2, str6, j3, stringBuffer2, i6);
                        i4++;
                        break;
                    }
                }
                break;
            default:
                String str22 = a2.title;
                if (!Util.isNullOrNil(str22)) {
                    bVar.tbP.a(1, j2, str6, j3, str22, i6);
                    i4++;
                }
                String str23 = a2.desc;
                if (!Util.isNullOrNil(str23)) {
                    bVar.tbP.a(2, j2, str6, j3, str23, i6);
                    i4++;
                    break;
                }
                break;
        }
        AppMethodBeat.o(101577);
        return i4;
    }
}
