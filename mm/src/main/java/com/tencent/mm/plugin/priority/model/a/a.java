package com.tencent.mm.plugin.priority.model.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a {
    private b AXQ;
    public SQLiteStatement AYr;
    public SQLiteStatement AYs;
    public SQLiteStatement AYt;
    private SQLiteStatement AYu;

    /* access modifiers changed from: protected */
    public abstract long eCV();

    /* access modifiers changed from: protected */
    public abstract String getTableName();

    public a(b bVar) {
        this.AXQ = bVar;
        if (this.AXQ.ag(eCV(), 0) != 1) {
            if (this.AXQ.ayi(getTableName())) {
                this.AXQ.aKd(getTableName());
            }
            this.AXQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", getTableName()));
            this.AXQ.ah(eCV(), 1);
        } else {
            Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "Exist Table %s %d", getTableName(), Integer.valueOf(this.AXQ.aKc(getTableName())));
        }
        this.AYr = this.AXQ.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", getTableName()));
        this.AYs = this.AXQ.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", getTableName()));
        this.AYt = this.AXQ.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", getTableName()));
        this.AYu = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE chat = ?;", getTableName()));
    }

    private dou k(String str, String str2, long j2) {
        String format = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", getTableName());
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str, str2, String.valueOf(j2)});
        try {
            if (rawQuery.moveToNext()) {
                return k(rawQuery);
            }
            rawQuery.close();
            return null;
        } finally {
            rawQuery.close();
        }
    }

    private static dou k(Cursor cursor) {
        dou dou = new dou();
        dou.LiG = cursor.getString(0);
        dou.MRZ = cursor.getString(1);
        dou.MSa = cursor.getLong(2);
        dou.MSb = cursor.getInt(3);
        dou.MSc = cursor.getInt(4);
        dou.MSd = cursor.getInt(5);
        dou.MSe = cursor.getInt(6);
        dou.MSf = cursor.getInt(7);
        dou.MSg = cursor.getInt(8);
        dou.MSh = cursor.getFloat(9);
        dou.MSi = cursor.getFloat(10);
        dou.MSj = cursor.getFloat(11);
        return dou;
    }

    public final void jp(String str, String str2) {
        long eCQ = com.tencent.mm.plugin.priority.a.a.a.eCQ();
        if (!a(str, str2, eCQ, false)) {
            b(str, str2, eCQ, false);
        }
    }

    private static float hM(int i2, int i3) {
        if (i3 == 0 && i2 > 0) {
            return 1.0f;
        }
        if (i3 == 0 && i2 == 0) {
            return 0.0f;
        }
        return Math.min(((float) i2) / ((float) i3), 1.0f);
    }

    public final void jq(String str, String str2) {
        long eCQ = com.tencent.mm.plugin.priority.a.a.a.eCQ();
        if (!a(str, str2, eCQ, true)) {
            b(str, str2, eCQ, true);
        }
    }

    private boolean a(String str, String str2, long j2, boolean z) {
        SQLiteStatement sQLiteStatement;
        dou k = k(str, str2, j2);
        if (k == null) {
            return false;
        }
        if (z) {
            k.MSc++;
            k.MSe++;
            k.MSg++;
        } else {
            k.MSb++;
            k.MSd++;
            k.MSf++;
        }
        k.MSh = hM(k.MSc, k.MSb);
        k.MSi = hM(k.MSe, k.MSd);
        k.MSj = hM(k.MSg, k.MSf);
        if (z) {
            sQLiteStatement = this.AYt;
            sQLiteStatement.bindLong(1, (long) k.MSc);
            sQLiteStatement.bindLong(2, (long) k.MSe);
            sQLiteStatement.bindLong(3, (long) k.MSg);
        } else {
            sQLiteStatement = this.AYs;
            sQLiteStatement.bindLong(1, (long) k.MSb);
            sQLiteStatement.bindLong(2, (long) k.MSd);
            sQLiteStatement.bindLong(3, (long) k.MSf);
        }
        sQLiteStatement.bindDouble(4, (double) k.MSh);
        sQLiteStatement.bindDouble(5, (double) k.MSi);
        sQLiteStatement.bindDouble(6, (double) k.MSj);
        sQLiteStatement.bindString(7, k.LiG);
        sQLiteStatement.bindString(8, k.MRZ);
        sQLiteStatement.bindLong(9, k.MSa);
        int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
        Object[] objArr = new Object[14];
        objArr[0] = getTableName();
        objArr[1] = z ? "Open" : "Receive";
        objArr[2] = str;
        objArr[3] = str2;
        objArr[4] = Integer.valueOf(executeUpdateDelete);
        objArr[5] = Integer.valueOf(k.MSc);
        objArr[6] = Integer.valueOf(k.MSe);
        objArr[7] = Integer.valueOf(k.MSg);
        objArr[8] = Integer.valueOf(k.MSb);
        objArr[9] = Integer.valueOf(k.MSd);
        objArr[10] = Integer.valueOf(k.MSf);
        objArr[11] = Float.valueOf(k.MSh);
        objArr[12] = Float.valueOf(k.MSi);
        objArr[13] = Float.valueOf(k.MSj);
        Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "%s Update %s Res %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f", objArr);
        return executeUpdateDelete > 0;
    }

    private void b(String str, String str2, long j2, boolean z) {
        dou dou = new dou();
        dou.LiG = str;
        dou.MRZ = str2;
        dou.MSa = j2;
        Cursor rawQuery = this.AXQ.rawQuery(String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", getTableName(), Long.valueOf(j2 - 2505600000L)), new String[]{str, str2});
        if (rawQuery.moveToNext()) {
            dou.MSf = rawQuery.getInt(0);
            dou.MSg = rawQuery.getInt(1);
        }
        rawQuery.close();
        Cursor rawQuery2 = this.AXQ.rawQuery(String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", getTableName(), Long.valueOf(j2 - 518400000)), new String[]{str, str2});
        if (rawQuery2.moveToNext()) {
            dou.MSd = rawQuery2.getInt(0);
            dou.MSe = rawQuery2.getInt(1);
        }
        rawQuery2.close();
        if (z) {
            dou.MSc++;
            dou.MSg++;
            dou.MSe++;
        } else {
            dou.MSb++;
            dou.MSf++;
            dou.MSd++;
        }
        dou.MSh = hM(dou.MSc, dou.MSb);
        dou.MSi = hM(dou.MSe, dou.MSd);
        dou.MSj = hM(dou.MSg, dou.MSf);
        this.AYr.bindString(1, dou.LiG);
        this.AYr.bindString(2, dou.MRZ);
        this.AYr.bindLong(3, dou.MSa);
        this.AYr.bindLong(4, (long) dou.MSb);
        this.AYr.bindLong(5, (long) dou.MSc);
        this.AYr.bindLong(6, (long) dou.MSd);
        this.AYr.bindLong(7, (long) dou.MSe);
        this.AYr.bindLong(8, (long) dou.MSf);
        this.AYr.bindLong(9, (long) dou.MSg);
        this.AYr.bindDouble(10, (double) dou.MSh);
        this.AYr.bindDouble(11, (double) dou.MSi);
        this.AYr.bindDouble(12, (double) dou.MSj);
        Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", Long.valueOf(this.AYr.executeInsert()), str, str2, f.formatTime("yyyy-MM-dd", j2 / 1000), Integer.valueOf(dou.MSd), Integer.valueOf(dou.MSe), Integer.valueOf(dou.MSf), Integer.valueOf(dou.MSg), Float.valueOf(dou.MSi), Float.valueOf(dou.MSj));
    }

    private float l(String str, String str2, long j2) {
        String format = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", getTableName(), Long.valueOf(j2 - 518400000));
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str, str2});
        try {
            if (rawQuery.moveToNext()) {
                return hM(rawQuery.getInt(1), rawQuery.getInt(0));
            }
            rawQuery.close();
            return 0.0f;
        } finally {
            rawQuery.close();
        }
    }

    private float m(String str, String str2, long j2) {
        String format = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", getTableName(), Long.valueOf(j2 - 2505600000L));
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str, str2});
        try {
            if (rawQuery.moveToNext()) {
                return hM(rawQuery.getInt(1), rawQuery.getInt(0));
            }
            rawQuery.close();
            return 0.0f;
        } finally {
            rawQuery.close();
        }
    }

    public final double[] jr(String str, String str2) {
        long eCQ = com.tencent.mm.plugin.priority.a.a.a.eCQ();
        String format = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", getTableName());
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str, str2, String.valueOf(eCQ)});
        double[] dArr = new double[3];
        if (rawQuery.moveToNext()) {
            dArr[0] = rawQuery.getDouble(0);
            dArr[1] = rawQuery.getDouble(1);
            dArr[2] = rawQuery.getDouble(2);
            rawQuery.close();
        } else {
            rawQuery.close();
            dArr[0] = 0.0d;
            dArr[1] = (double) l(str, str2, eCQ);
            dArr[2] = (double) m(str, str2, eCQ);
        }
        return dArr;
    }

    public final int js(String str, String str2) {
        int i2 = 0;
        long eCQ = com.tencent.mm.plugin.priority.a.a.a.eCQ();
        String format = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", getTableName());
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str, str2, String.valueOf(eCQ)});
        if (rawQuery.moveToNext()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i2;
    }

    public final int jt(String str, String str2) {
        int i2 = 0;
        String format = String.format("SELECT sum(dayreceivecount) FROM %s WHERE chat = ? AND talker = ? AND date >= ?", getTableName());
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str, str2, String.valueOf(com.tencent.mm.plugin.priority.a.a.a.eCQ() - 518400000)});
        if (rawQuery.moveToNext()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i2;
    }

    public final List<dou> aKe(String str) {
        String format = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", getTableName(), "@all");
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str});
        ArrayList arrayList = new ArrayList(10);
        while (rawQuery.moveToNext()) {
            arrayList.add(k(rawQuery));
        }
        rawQuery.close();
        Collections.sort(arrayList, new Comparator<dou>() {
            /* class com.tencent.mm.plugin.priority.model.a.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(dou dou, dou dou2) {
                AppMethodBeat.i(87816);
                int compare = Float.compare(dou2.MSj, dou.MSj);
                AppMethodBeat.o(87816);
                return compare;
            }
        });
        return arrayList;
    }

    public final void aKf(String str) {
        this.AYu.bindString(1, str);
        Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "delete %d img usage %s", Integer.valueOf(this.AYu.executeUpdateDelete()), str);
    }

    public final List<Pair<String, String>> HK(long j2) {
        HashMap hashMap = new HashMap();
        String format = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date = ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", getTableName());
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(j2)});
        while (rawQuery.moveToNext()) {
            hashMap.put(rawQuery.getString(0), Double.valueOf(rawQuery.getDouble(1)));
        }
        rawQuery.close();
        HashMap hashMap2 = new HashMap();
        String format2 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", getTableName());
        Cursor rawQuery2 = this.AXQ.rawQuery(format2, new String[]{String.valueOf(j2 - 518400000)});
        while (rawQuery2.moveToNext()) {
            hashMap2.put(rawQuery2.getString(0), Double.valueOf(rawQuery2.getDouble(1)));
        }
        rawQuery2.close();
        HashMap hashMap3 = new HashMap();
        String format3 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", getTableName());
        Cursor rawQuery3 = this.AXQ.rawQuery(format3, new String[]{String.valueOf(j2 - 2505600000L)});
        while (rawQuery3.moveToNext()) {
            hashMap3.put(rawQuery3.getString(0), Double.valueOf(rawQuery3.getDouble(1)));
        }
        rawQuery3.close();
        ArrayList<Map.Entry> arrayList = new ArrayList();
        arrayList.addAll(hashMap3.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Double>>() {
            /* class com.tencent.mm.plugin.priority.model.a.a.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Map.Entry<String, Double> entry, Map.Entry<String, Double> entry2) {
                AppMethodBeat.i(87817);
                int compareTo = entry2.getValue().compareTo(entry.getValue());
                AppMethodBeat.o(87817);
                return compareTo;
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : arrayList) {
            double d2 = 0.0d;
            if (hashMap.containsKey(entry.getKey())) {
                d2 = ((Double) hashMap.get(entry.getKey())).doubleValue();
            }
            double d3 = 0.0d;
            if (hashMap.containsKey(entry.getKey())) {
                d3 = ((Double) hashMap2.get(entry.getKey())).doubleValue();
            }
            arrayList2.add(new Pair(entry.getKey(), String.format("%.2f,%.2f,%.2f", Double.valueOf(d2), Double.valueOf(d3), entry.getValue())));
        }
        return arrayList2;
    }
}
