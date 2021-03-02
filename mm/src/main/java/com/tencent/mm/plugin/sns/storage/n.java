package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vs;
import com.tencent.mm.g.c.gk;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class n extends MAutoStorage<SnsInfo> implements h {
    public static String EmA;
    public static String EmB;
    protected static String EmC;
    protected static String EmD = " (sourceType & 2 != 0 ) and type < 21";
    private static String EmE;
    private static String EmF;
    private static String EmG;
    private static String EmH;
    protected static String EmI;
    private static String EmJ;
    private static ArrayList<Integer> EmK = eu(Arrays.asList(2, 4, 8, 16, 64, 128));
    private static String[] Ems = {"snsId", "userName", "localFlag", "createTime", "head", "localPrivate", "type", "sourceType", "likeFlag", "pravited", "stringSeq", "content", "attrBuf", "postBuf", "rowid"};
    private static String Emt;
    public static String Emu = " order by SnsInfo.createTime desc ,snsId desc";
    public static String Emv = " order by SnsInfo.createTime asc ,snsId asc";
    private static String Emw = " order by SnsInfo.createTime asc ,snsId asc";
    public static String Emx = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
    public static String Emy = " order by SnsInfo.head desc ,snsId desc";
    public static String Emz;
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS serverSnsNameIndex ON SnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverSnsTimeHeadIndex ON SnsInfo ( head )", "DROP INDEX IF EXISTS serverSnsTimeIndex", "DROP INDEX IF EXISTS serverSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS snsMultiIndex1 ON SnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS snsMultiIndex2 ON SnsInfo ( sourceType,type,userName)", "CREATE INDEX IF NOT EXISTS snsMultiIndex3 ON SnsInfo ( userName,sourceType)", "CREATE INDEX IF NOT EXISTS snsLocalflagIndex ON SnsInfo ( localFlag )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(SnsInfo.info, gk.TABLE_NAME)};
    private static ArrayList<Integer> vDL = eu(Arrays.asList(16, 32, 2, 8, 64, 128, 256, 512));
    public boolean Emq;
    private int Emr;
    public com.tencent.mm.storagebase.h iFy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(SnsInfo snsInfo) {
        AppMethodBeat.i(97586);
        boolean S = S(snsInfo);
        AppMethodBeat.o(97586);
        return S;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(long j2, SnsInfo snsInfo) {
        AppMethodBeat.i(97587);
        boolean b2 = b(j2, snsInfo);
        AppMethodBeat.o(97587);
        return b2;
    }

    static {
        AppMethodBeat.i(97588);
        Emt = "";
        Emz = null;
        EmA = null;
        EmB = null;
        EmC = " (sourceType & 2 != 0 ) ";
        EmE = null;
        EmF = null;
        EmG = null;
        EmH = null;
        EmI = null;
        EmJ = null;
        Emt = "select ";
        for (int i2 = 0; i2 < Ems.length; i2++) {
            if (i2 < Ems.length - 1) {
                Emt += " " + Ems[i2] + ",";
            } else {
                Emt += " " + Ems[i2] + " ";
            }
        }
        Log.i("MicroMsg.SnsInfoStorage", "TIMELINE_SELECT_BEGIN " + Emt);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = vDL.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if ((intValue & 16) != 0 && (intValue & 32) == 0 && (intValue & 512) == 0) {
                arrayList.add(Integer.valueOf(intValue));
            }
        }
        Emz = k(arrayList, "localFlag");
        Log.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", Emz);
        arrayList.clear();
        Iterator<Integer> it2 = vDL.iterator();
        while (it2.hasNext()) {
            int intValue2 = it2.next().intValue();
            if ((intValue2 & 32) != 0) {
                arrayList.add(Integer.valueOf(intValue2));
            }
        }
        EmB = k(arrayList, "localFlag");
        Log.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", EmB);
        arrayList.clear();
        Iterator<Integer> it3 = vDL.iterator();
        while (it3.hasNext()) {
            int intValue3 = it3.next().intValue();
            if ((intValue3 & 64) == 0 && (intValue3 & 32) != 0) {
                arrayList.add(Integer.valueOf(intValue3));
            }
        }
        EmH = k(arrayList, "localFlag");
        arrayList.clear();
        Iterator<Integer> it4 = EmK.iterator();
        while (it4.hasNext()) {
            int intValue4 = it4.next().intValue();
            if ((intValue4 & 8) != 0) {
                arrayList.add(Integer.valueOf(intValue4));
            }
        }
        EmG = k(arrayList, "sourceType");
        Log.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", EmG);
        arrayList.clear();
        Iterator<Integer> it5 = EmK.iterator();
        while (it5.hasNext()) {
            int intValue5 = it5.next().intValue();
            if ((intValue5 & 2) != 0) {
                arrayList.add(Integer.valueOf(intValue5));
            }
        }
        EmC = k(arrayList, "sourceType");
        Log.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", EmC);
        arrayList.clear();
        Iterator<Integer> it6 = EmK.iterator();
        while (it6.hasNext()) {
            int intValue6 = it6.next().intValue();
            if ((intValue6 & 4) != 0) {
                arrayList.add(Integer.valueOf(intValue6));
            }
        }
        EmE = k(arrayList, "sourceType");
        Log.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", EmE);
        arrayList.clear();
        Iterator<Integer> it7 = vDL.iterator();
        while (it7.hasNext()) {
            int intValue7 = it7.next().intValue();
            if ((intValue7 & 256) != 0) {
                arrayList.add(Integer.valueOf(intValue7));
            }
        }
        EmI = b(arrayList, "localFlag", true);
        arrayList.clear();
        Iterator<Integer> it8 = EmK.iterator();
        while (it8.hasNext()) {
            int intValue8 = it8.next().intValue();
            if ((intValue8 & 16) != 0) {
                arrayList.add(Integer.valueOf(intValue8));
            }
        }
        EmJ = k(arrayList, "sourceType");
        arrayList.clear();
        Iterator<Integer> it9 = EmK.iterator();
        while (it9.hasNext()) {
            int intValue9 = it9.next().intValue();
            if ((intValue9 & 64) != 0) {
                arrayList.add(Integer.valueOf(intValue9));
            }
        }
        EmF = k(arrayList, "sourceType");
        arrayList.clear();
        Iterator<Integer> it10 = vDL.iterator();
        while (it10.hasNext()) {
            int intValue10 = it10.next().intValue();
            if ((intValue10 & 512) != 0) {
                arrayList.add(Integer.valueOf(intValue10));
            }
        }
        EmA = k(arrayList, "localFlag");
        AppMethodBeat.o(97588);
    }

    private static boolean feN() {
        AppMethodBeat.i(97533);
        vs vsVar = new vs();
        EventCenter.instance.publish(vsVar);
        boolean z = vsVar.ebS.ebT;
        AppMethodBeat.o(97533);
        return z;
    }

    public static String feO() {
        AppMethodBeat.i(97534);
        if (feN()) {
            AppMethodBeat.o(97534);
            return " (sourceType & 2 != 0 ) and type < 21";
        }
        AppMethodBeat.o(97534);
        return " (sourceType & 2 != 0 ) ";
    }

    private static String k(List<Integer> list, String str) {
        AppMethodBeat.i(97535);
        String b2 = b(list, str, false);
        AppMethodBeat.o(97535);
        return b2;
    }

    private static String b(List<Integer> list, String str, boolean z) {
        AppMethodBeat.i(97536);
        StringBuilder sb = new StringBuilder("(");
        if (z) {
            sb.append(str + " not in (");
        } else {
            sb.append(str + " in (");
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        sb.append(")");
        sb.append(")");
        String sb2 = sb.toString();
        AppMethodBeat.o(97536);
        return sb2;
    }

    private static ArrayList<Integer> eu(List<Integer> list) {
        AppMethodBeat.i(97537);
        ArrayList arrayList = new ArrayList(list);
        HashSet hashSet = new HashSet();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(((Integer) it2.next()).intValue() | num.intValue()));
            }
            hashSet.addAll(new HashSet(arrayList3));
            hashSet.add(num);
        }
        hashSet.add(0);
        arrayList2.addAll(hashSet);
        AppMethodBeat.o(97537);
        return arrayList2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(com.tencent.mm.storagebase.h hVar) {
        super(hVar, SnsInfo.info, gk.TABLE_NAME, INDEX_CREATE);
        boolean z;
        int i2;
        boolean z2 = true;
        AppMethodBeat.i(203203);
        this.iFy = hVar;
        Cursor rawQuery = this.iFy.rawQuery("select count(*) from SnsInfo where snsId > 0;", null, 2);
        if (!rawQuery.moveToFirst() || (i2 = rawQuery.getInt(0)) <= 0) {
            rawQuery.close();
            z = false;
        } else {
            Log.i("MicroMsg.SnsInfoStorage", "exsits snsId > 0  ,count is %d", Integer.valueOf(i2));
            rawQuery.close();
            z = true;
        }
        this.Emq = z ? false : z2;
        this.Emr = 0;
        if (this.Emq) {
            Log.i("MicroMsg.SnsInfoStorage", "all sndId < 0 ,so optimalizeForSnsId");
            AppMethodBeat.o(203203);
            return;
        }
        Emu = " order by SnsInfo.createTime desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        Emv = " order by SnsInfo.createTime asc ,case when snsId < 0 then 0 else 1 end ,  snsId asc";
        Emx = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
        Emy = " order by SnsInfo.head desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        AppMethodBeat.o(203203);
    }

    public final int R(SnsInfo snsInfo) {
        AppMethodBeat.i(97539);
        Log.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert");
        if (snsInfo == null) {
            AppMethodBeat.o(97539);
            return -1;
        }
        int insert = (int) this.iFy.insert(gk.TABLE_NAME, "", snsInfo.convertTo());
        Log.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert result ".concat(String.valueOf(insert)));
        AppMethodBeat.o(97539);
        return insert;
    }

    public final void f(String str, boolean z, String str2) {
        AppMethodBeat.i(97540);
        String str3 = cn(str, z) + " AND  (snsId != 0  ) ";
        if (aQw(str2)) {
            str3 = str3 + " AND " + aQA(str2);
        }
        F(z, str3);
        AppMethodBeat.o(97540);
    }

    public final void F(boolean z, String str) {
        AppMethodBeat.i(97541);
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & " + ((z ? 4 : 8) ^ -1) + str;
        Log.d("MicroMsg.SnsInfoStorage", "updateFilterUserName sql ".concat(String.valueOf(str2)));
        this.iFy.execSQL(gk.TABLE_NAME, str2);
        AppMethodBeat.o(97541);
    }

    public final void feP() {
        AppMethodBeat.i(97542);
        aQv(" where " + feO() + " AND  (snsId != 0  ) ");
        AppMethodBeat.o(97542);
    }

    public final void aQt(String str) {
        AppMethodBeat.i(97543);
        if (!aQw(str)) {
            AppMethodBeat.o(97543);
            return;
        }
        aQv(" where " + aQA(str) + " and " + feO() + " and  (snsId != 0  ) ");
        AppMethodBeat.o(97543);
    }

    public final void aQu(String str) {
        AppMethodBeat.i(97544);
        if (!aQw(str)) {
            AppMethodBeat.o(97544);
            return;
        }
        aQv(" where " + aQz(str) + " and " + feO() + " and  (snsId != 0  ) ");
        AppMethodBeat.o(97544);
    }

    private void aQv(String str) {
        AppMethodBeat.i(97545);
        String concat = "UPDATE SnsInfo SET sourceType = sourceType & -3".concat(String.valueOf(str));
        Log.d("MicroMsg.SnsInfoStorage", "updateFilterTimeLine sql ".concat(String.valueOf(concat)));
        this.iFy.execSQL(gk.TABLE_NAME, concat);
        AppMethodBeat.o(97545);
    }

    public final boolean JF(long j2) {
        AppMethodBeat.i(97546);
        Cursor rawQuery = this.iFy.rawQuery("select *,rowid from SnsInfo  where SnsInfo.snsId=".concat(String.valueOf(j2)), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.o(97546);
            return true;
        }
        AppMethodBeat.o(97546);
        return false;
    }

    public final boolean a(long j2, SnsInfo snsInfo) {
        AppMethodBeat.i(97547);
        if (JF(j2)) {
            boolean b2 = b(j2, snsInfo);
            AppMethodBeat.o(97547);
            return b2;
        } else if (R(snsInfo) != -1) {
            AppMethodBeat.o(97547);
            return true;
        } else {
            AppMethodBeat.o(97547);
            return false;
        }
    }

    public static boolean aQw(String str) {
        AppMethodBeat.i(97548);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(97548);
            return false;
        }
        AppMethodBeat.o(97548);
        return true;
    }

    public final String aQx(String str) {
        AppMethodBeat.i(97549);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(97549);
            return " ";
        } else if (this.Emq) {
            String str2 = " (snsId >= " + aQy(Util.escapeSqlValue(str)) + " ) ";
            AppMethodBeat.o(97549);
            return str2;
        } else {
            String str3 = " (stringSeq >=\"" + Util.escapeSqlValue(str) + "\"  ) ";
            AppMethodBeat.o(97549);
            return str3;
        }
    }

    public static long aQy(String str) {
        AppMethodBeat.i(97550);
        long longValue = new BigInteger(str).longValue();
        Log.i("MicroMsg.SnsInfoStorage", "seq %s to snsId %d ", str, Long.valueOf(longValue));
        AppMethodBeat.o(97550);
        return longValue;
    }

    public final String aQz(String str) {
        AppMethodBeat.i(97551);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(97551);
            return " ";
        } else if (this.Emq) {
            String str2 = " (snsId > " + aQy(Util.escapeSqlValue(str)) + " ) ";
            AppMethodBeat.o(97551);
            return str2;
        } else {
            String str3 = " (stringSeq >\"" + Util.escapeSqlValue(str) + "\"  ) ";
            AppMethodBeat.o(97551);
            return str3;
        }
    }

    public final String aQA(String str) {
        AppMethodBeat.i(97552);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(97552);
            return " ";
        } else if (this.Emq) {
            String str2 = " (snsId < " + aQy(Util.escapeSqlValue(str)) + " ) ";
            AppMethodBeat.o(97552);
            return str2;
        } else {
            String str3 = " (stringSeq <\"" + Util.escapeSqlValue(str) + "\"  ) ";
            AppMethodBeat.o(97552);
            return str3;
        }
    }

    public final String aQB(String str) {
        AppMethodBeat.i(97553);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(97553);
            return " ";
        } else if (this.Emq) {
            String str2 = " (snsId <= " + aQy(Util.escapeSqlValue(str)) + " ) ";
            AppMethodBeat.o(97553);
            return str2;
        } else {
            String str3 = " (stringSeq <=\"" + Util.escapeSqlValue(str) + "\"  ) ";
            AppMethodBeat.o(97553);
            return str3;
        }
    }

    public static String cn(String str, boolean z) {
        String str2;
        AppMethodBeat.i(97554);
        if (z) {
            str2 = "" + " WHERE " + EmE;
        } else {
            str2 = ("" + " WHERE SnsInfo.userName=\"" + Util.escapeSqlValue(str) + "\"") + " AND " + EmG;
        }
        AppMethodBeat.o(97554);
        return str2;
    }

    private static String feQ() {
        AppMethodBeat.i(160687);
        String str = " WHERE " + EmF;
        AppMethodBeat.o(160687);
        return str;
    }

    public static String co(String str, boolean z) {
        AppMethodBeat.i(97555);
        String str2 = ("select *,rowid from SnsInfo " + cn(str, z)) + " AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26,28,29,30 , 34,43,38,33,37,36,39,41,42)";
        AppMethodBeat.o(97555);
        return str2;
    }

    public final long g(long j2, int i2, boolean z) {
        AppMethodBeat.i(97556);
        long c2 = c(feT(), j2, i2, z);
        AppMethodBeat.o(97556);
        return c2;
    }

    public final long b(long j2, int i2, String str, boolean z) {
        AppMethodBeat.i(97557);
        long c2 = c(co(str, z), j2, i2, false);
        AppMethodBeat.o(97557);
        return c2;
    }

    private long c(String str, long j2, int i2, boolean z) {
        String str2;
        AppMethodBeat.i(97558);
        if (j2 != 0) {
            str2 = str + " AND SnsInfo.stringSeq < '" + r.aOr(r.Jb(j2)) + "'";
        } else {
            str2 = str;
        }
        if (z) {
            str2 = str2 + " AND  (snsId != 0 ) ";
        }
        String str3 = (str2 + Emu) + " limit " + i2;
        Log.d("MicroMsg.SnsInfoStorage", "getMinSeqByLimit %s \n maxId=%s", str3, Long.valueOf(j2));
        Cursor rawQuery = this.iFy.rawQuery(str3, null);
        if (rawQuery.moveToLast()) {
            SnsInfo snsInfo = new SnsInfo();
            snsInfo.convertFrom(rawQuery);
            rawQuery.close();
            long j3 = snsInfo.field_snsId;
            AppMethodBeat.o(97558);
            return j3;
        }
        rawQuery.close();
        AppMethodBeat.o(97558);
        return 0;
    }

    public final long h(long j2, int i2, boolean z) {
        AppMethodBeat.i(179138);
        long d2 = d(feT(), j2, i2, z);
        AppMethodBeat.o(179138);
        return d2;
    }

    private long d(String str, long j2, int i2, boolean z) {
        String str2;
        AppMethodBeat.i(179139);
        if (j2 != 0) {
            str2 = str + " AND SnsInfo.stringSeq > '" + r.aOr(r.Jb(j2)) + "'";
        } else {
            str2 = str;
        }
        if (z) {
            str2 = str2 + " AND  (snsId != 0 ) ";
        }
        String str3 = (str2 + Emu) + " limit " + i2;
        Log.d("MicroMsg.SnsInfoStorage", "getMaxSeqByLimit %s \n minId=%s", str3, Long.valueOf(j2));
        Cursor rawQuery = this.iFy.rawQuery(str3, null);
        if (rawQuery.moveToFirst()) {
            SnsInfo snsInfo = new SnsInfo();
            snsInfo.convertFrom(rawQuery);
            rawQuery.close();
            long j3 = snsInfo.field_snsId;
            AppMethodBeat.o(179139);
            return j3;
        }
        rawQuery.close();
        AppMethodBeat.o(179139);
        return 0;
    }

    public static String feR() {
        AppMethodBeat.i(97559);
        String str = "select *,rowid from SnsInfo  where " + " (sourceType & 2 != 0 ) ";
        AppMethodBeat.o(97559);
        return str;
    }

    private static String feS() {
        AppMethodBeat.i(203204);
        String str = "select *,rowid from SnsInfo  where " + " (sourceType & 128 != 0 ) ";
        AppMethodBeat.o(203204);
        return str;
    }

    public static String feT() {
        AppMethodBeat.i(97560);
        String str = "select *,rowid from SnsInfo  where " + feO();
        AppMethodBeat.o(97560);
        return str;
    }

    public static String feU() {
        String str;
        AppMethodBeat.i(97561);
        StringBuilder append = new StringBuilder().append("select *,rowid from SnsInfo  where ");
        if (feN()) {
            str = EmD;
        } else {
            str = EmC;
        }
        String sb = append.append(str).toString();
        AppMethodBeat.o(97561);
        return sb;
    }

    public final long feV() {
        int i2;
        AppMethodBeat.i(203205);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.iFy.rawQuery("select count(*) from SnsInfo", null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        } else {
            i2 = 0;
        }
        rawQuery.close();
        Log.i("MicroMsg.SnsInfoStorage", "sns table count %d passed %d", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        long j2 = (long) i2;
        AppMethodBeat.o(203205);
        return j2;
    }

    public static String feW() {
        AppMethodBeat.i(97562);
        StringBuilder sb = new StringBuilder();
        sb.append("select snsId from SnsInfo  where ").append(feO()).append(" limit 3");
        String sb2 = sb.toString();
        AppMethodBeat.o(97562);
        return sb2;
    }

    public final Cursor aQ(String str, String str2, String str3) {
        AppMethodBeat.i(203206);
        String feS = feS();
        if (!Util.isNullOrNil(str)) {
            feS = feS + " AND SnsInfo.userName=\"" + Util.escapeSqlValue(str) + "\"";
        }
        if (str2 == null || !str2.equals("")) {
            feS = feS + " AND " + aQB(str2);
        }
        if (aQw(str3)) {
            feS = feS + " AND " + aQx(str3);
        }
        String str4 = feS + " " + Emu;
        Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(str4)));
        Cursor rawQuery = this.iFy.rawQuery(str4, null);
        AppMethodBeat.o(203206);
        return rawQuery;
    }

    public final Cursor g(String str, boolean z, String str2) {
        AppMethodBeat.i(97563);
        Cursor a2 = a(false, str, 0, z, str2);
        AppMethodBeat.o(97563);
        return a2;
    }

    public final Cursor a(boolean z, String str, int i2, boolean z2, String str2) {
        String str3;
        AppMethodBeat.i(203207);
        String co = co(str, z2);
        if (aQw(str2)) {
            co = co + " AND " + aQx(str2);
        }
        if (z2) {
            str3 = co + Emx;
        } else {
            str3 = co + Emy;
        }
        if (i2 > 0) {
            str3 = str3 + " LIMIT " + i2;
        }
        Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(str3)));
        Cursor rawQuery = this.iFy.rawQuery(str3, null);
        AppMethodBeat.o(203207);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.sns.b.h
    public final Cursor aNW(String str) {
        AppMethodBeat.i(97565);
        String feT = feT();
        if (aQw(str)) {
            feT = feT + " AND " + aQx(str);
        }
        String str2 = feT + Emu;
        Log.d("MicroMsg.SnsInfoStorage", "getCursorForTimeLine ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        AppMethodBeat.o(97565);
        return rawQuery;
    }

    public final List<SnsInfo> cp(String str, boolean z) {
        AppMethodBeat.i(97566);
        Cursor rawQuery = this.iFy.rawQuery("select *,rowid from SnsInfo " + cn(str, z) + " AND (type = 4 OR type = 42" + ")", null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            SnsInfo snsInfo = new SnsInfo();
            snsInfo.convertFrom(rawQuery);
            arrayList.add(snsInfo);
        }
        rawQuery.close();
        AppMethodBeat.o(97566);
        return arrayList;
    }

    public final int aQC(String str) {
        AppMethodBeat.i(97567);
        String feT = feT();
        if (aQw(str)) {
            feT = feT + " AND " + aQx(str);
        }
        String str2 = (feT + " AND  (snsId != 0 ) ") + Emv + " limit 1";
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        int i2 = 0;
        if (rawQuery.moveToFirst()) {
            SnsInfo snsInfo = new SnsInfo();
            snsInfo.convertFrom(rawQuery);
            i2 = snsInfo.field_createTime;
        }
        rawQuery.close();
        Log.i("MicroMsg.SnsInfoStorage", "getLastTime " + str2 + " createtime " + i2);
        AppMethodBeat.o(97567);
        return i2;
    }

    public final Cursor q(String str, String str2, int i2, int i3) {
        String str3;
        AppMethodBeat.i(179140);
        String str4 = (Emt + " from SnsInfo where ") + feO();
        if (aQw(str)) {
            str4 = str4 + " AND " + aQx(str);
        }
        if (aQw(str2)) {
            str4 = str4 + " AND " + aQB(str2);
        }
        String str5 = (str4 + " AND createTime >= " + i2) + " UNION ";
        if (i3 <= 0 || i3 <= i2) {
            str3 = str5 + Emt + " from AdSnsInfo where createTime > " + i2 + " and " + EmI;
        } else {
            str3 = str5 + Emt + " from AdSnsInfo where createTime > " + i2 + " and createTime < " + i3 + " and " + EmI;
        }
        String str6 = str3 + Emu;
        Log.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine:%s, downLimtiSeq:%s, upLimitSeq:%s", str6, str, str2);
        Cursor rawQuery = this.iFy.rawQuery(str6, null);
        AppMethodBeat.o(179140);
        return rawQuery;
    }

    public final Cursor aA(String str, int i2, int i3) {
        AppMethodBeat.i(97569);
        String str2 = (Emt + " from SnsInfo where ") + feO();
        if (aQw(str)) {
            str2 = str2 + " AND " + aQx(str);
        }
        String str3 = ((((str2 + " AND createTime >= " + i2) + " UNION ") + Emt + " from AdSnsInfo where createTime > " + i2 + " and " + EmI) + Emu) + " limit " + i3;
        Log.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str3 + " limtiSeq: " + str);
        Cursor rawQuery = this.iFy.rawQuery(str3, null);
        AppMethodBeat.o(97569);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.sns.b.h
    public final void IX(long j2) {
        AppMethodBeat.i(97570);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("check_trim_time", 0).commit();
        com.tencent.mm.storagebase.h dataDB = aj.getDataDB();
        long beginTransaction = dataDB.beginTransaction(Thread.currentThread().getId());
        for (int i2 = 0; ((long) i2) < j2; i2++) {
            dataDB.execSQL(gk.TABLE_NAME, "INSERT INTO SnsInfo VALUES(-69999999991777434909,'miaochanchan',2,1402026897,20140606,0,2,2,0,0,'0',X'0A143131373631303534303431393332313136373037120C6D69616F6368616E6368616E18002091F7C49C052A36E8A681E6849FE8B0A2E8BF99E4BBBDE5B7A5EFBC8CE8AEA9E68891E4B88DE4BC9AE69C89E5A29EE882A5E79A84E8BFB9E8B1A1E3808232180D0000000015000000001A0022002A0032003800480050003A0A0A0012001A0022002A0042080A0010021A0022004A0052005A006000680272007A2408001200180022002A0032003A080A0012001A00220042004A040800100052040A001200',X'08E3E5A48CEA8AEA9BA301120C6D69616F6368616E6368616E1A09E88B97E7B1B3E7B1B32091F7C49C052A04080012003000380040005000580068007000800101880100900100A00101B00100B80100',NULL);");
        }
        for (int i3 = 0; ((long) i3) < 20000; i3++) {
            dataDB.execSQL("snsExtInfo3", String.format("INSERT INTO snsExtInfo3 VALUES('zeustest%d','afd',2,1402026897,'d', 0,1, 1, 1, 1, 'a', 'a', NULL);", Integer.valueOf(i3)));
        }
        for (int i4 = 0; ((long) i4) < 20000; i4++) {
            dataDB.execSQL("snsComment", String.format("INSERT INTO snsComment VALUES(-69999999991777434909,0,2,1402026897,'d', 2,1, 'a', 'b', 1, NULL);", new Object[0]));
        }
        dataDB.endTransaction(beginTransaction);
        AppMethodBeat.o(97570);
    }

    @Override // com.tencent.mm.plugin.sns.b.h
    public final ArrayList<Long> eZl() {
        AppMethodBeat.i(97571);
        ArrayList<Long> arrayList = new ArrayList<>();
        Cursor query = this.iFy.query(gk.TABLE_NAME, new String[]{"*", "rowid"}, "createTime >=? AND " + EmH, new String[]{String.valueOf(((int) (System.currentTimeMillis() / 1000)) - 172800)}, null, null, "createTime ASC", 2);
        while (query.moveToNext()) {
            try {
                SnsInfo snsInfo = new SnsInfo();
                snsInfo.convertFrom(query);
                if (snsInfo.localid != -1 && snsInfo.getUserName().equals(z.aTY())) {
                    arrayList.add(Long.valueOf((long) snsInfo.localid));
                    Log.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, add snsInfo: " + snsInfo.getLocalid());
                }
            } catch (Throwable th) {
                query.close();
                AppMethodBeat.o(97571);
                throw th;
            }
        }
        query.close();
        Log.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, resendList.size:%d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(97571);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.sns.b.h
    public final boolean Yh(int i2) {
        AppMethodBeat.i(97572);
        if (Zr(i2) != null) {
            AppMethodBeat.o(97572);
            return true;
        }
        AppMethodBeat.o(97572);
        return false;
    }

    public final boolean S(SnsInfo snsInfo) {
        AppMethodBeat.i(97573);
        if (snsInfo.isAd()) {
            boolean replace = aj.faR().replace(snsInfo.getAdSnsInfo());
            AppMethodBeat.o(97573);
            return replace;
        }
        boolean z = this.iFy.replace(gk.TABLE_NAME, "", snsInfo.convertTo()) > 0;
        Log.d("MicroMsg.SnsInfoStorage", "SnsInfo replace result ".concat(String.valueOf(z)));
        AppMethodBeat.o(97573);
        return z;
    }

    public final SnsInfo JJ(long j2) {
        AppMethodBeat.i(97574);
        SnsInfo snsInfo = new SnsInfo();
        Cursor rawQuery = this.iFy.rawQuery("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j2 + " limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            snsInfo.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(97574);
            return snsInfo;
        }
        rawQuery.close();
        AppMethodBeat.o(97574);
        return null;
    }

    public final SnsInfo aQl(String str) {
        AppMethodBeat.i(97575);
        if (y.aNz(str)) {
            SnsInfo JJ = JJ(y.aOa(str));
            AppMethodBeat.o(97575);
            return JJ;
        }
        AdSnsInfo JE = aj.faR().JE(y.aOa(str));
        if (JE != null) {
            SnsInfo convertToSnsInfo = JE.convertToSnsInfo();
            AppMethodBeat.o(97575);
            return convertToSnsInfo;
        }
        AppMethodBeat.o(97575);
        return null;
    }

    public final SnsInfo Zr(int i2) {
        AppMethodBeat.i(97576);
        SnsInfo snsInfo = new SnsInfo();
        Cursor rawQuery = this.iFy.rawQuery("select *,rowid from SnsInfo  where SnsInfo.rowid=".concat(String.valueOf(i2)), null, 2);
        if (rawQuery.moveToFirst()) {
            snsInfo.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(97576);
            return snsInfo;
        }
        rawQuery.close();
        AppMethodBeat.o(97576);
        return null;
    }

    public final SnsInfo aQm(String str) {
        AppMethodBeat.i(97577);
        if (y.aNz(str)) {
            SnsInfo Zr = Zr(y.aQI(str));
            AppMethodBeat.o(97577);
            return Zr;
        }
        AdSnsInfo Zp = aj.faR().Zp(y.aQI(str));
        if (Zp != null) {
            SnsInfo convertToSnsInfo = Zp.convertToSnsInfo();
            AppMethodBeat.o(97577);
            return convertToSnsInfo;
        }
        AppMethodBeat.o(97577);
        return null;
    }

    public final boolean b(long j2, SnsInfo snsInfo) {
        AppMethodBeat.i(97578);
        ContentValues convertTo = snsInfo.convertTo();
        convertTo.remove("rowid");
        if (this.iFy.update(gk.TABLE_NAME, convertTo, "snsId=?", new String[]{String.valueOf(j2)}) > 0) {
            AppMethodBeat.o(97578);
            return true;
        }
        AppMethodBeat.o(97578);
        return false;
    }

    public final int d(int i2, SnsInfo snsInfo) {
        AppMethodBeat.i(97579);
        ContentValues convertTo = snsInfo.convertTo();
        convertTo.remove("rowid");
        int update = this.iFy.update(gk.TABLE_NAME, convertTo, "rowid=?", new String[]{String.valueOf(i2)});
        AppMethodBeat.o(97579);
        return update;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final boolean delete(long j2) {
        AppMethodBeat.i(97580);
        Log.printInfoStack("MicroMsg.SnsInfoStorage", "delete pcId:%s", Long.valueOf(j2));
        int delete = this.iFy.delete(gk.TABLE_NAME, "snsId=?", new String[]{String.valueOf(j2)});
        Log.d("MicroMsg.SnsInfoStorage", "del msg " + j2 + " res " + delete);
        if (delete > 0) {
            AppMethodBeat.o(97580);
            return true;
        }
        AppMethodBeat.o(97580);
        return false;
    }

    public final boolean Zs(int i2) {
        AppMethodBeat.i(97581);
        Log.printInfoStack("MicroMsg.SnsInfoStorage", "deleteByLocalId localId:%s", Integer.valueOf(i2));
        if (this.iFy.delete(gk.TABLE_NAME, "rowid=?", new String[]{String.valueOf(i2)}) > 0) {
            AppMethodBeat.o(97581);
            return true;
        }
        AppMethodBeat.o(97581);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.b.h
    public final int IY(long j2) {
        AppMethodBeat.i(97582);
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ == null) {
            AppMethodBeat.o(97582);
            return 0;
        }
        int adRecSrc = JJ.getAdRecSrc();
        AppMethodBeat.o(97582);
        return adRecSrc;
    }

    public final long Y(long j2, int i2) {
        AppMethodBeat.i(160688);
        long c2 = c(feX(), j2, i2, false);
        AppMethodBeat.o(160688);
        return c2;
    }

    public static String feX() {
        AppMethodBeat.i(160689);
        String str = ("select *,rowid from SnsInfo " + feQ()) + " AND type in ( 1 , 15)";
        AppMethodBeat.o(160689);
        return str;
    }

    public final Cursor kL(String str, String str2) {
        AppMethodBeat.i(97585);
        String str3 = "select *,rowid from SnsInfo  WHERE " + EmJ;
        if (aQw(str)) {
            str3 = str3 + " AND " + aQB(str);
        }
        if (aQw(str2)) {
            str3 = str3 + " AND " + aQx(str2);
        }
        String str4 = str3 + Emx;
        Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(str4)));
        Cursor rawQuery = this.iFy.rawQuery(str4, null);
        AppMethodBeat.o(97585);
        return rawQuery;
    }
}
