package com.tencent.mm.plugin.priority.model.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;

public final class c extends a {
    @Override // com.tencent.mm.plugin.priority.model.b.a
    public final String getName() {
        return "Priority.CalC2CChatPriorityTask";
    }

    public final void run() {
        AppMethodBeat.i(87868);
        if (!eDa()) {
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            if (!com.tencent.mm.util.c.hde()) {
                Log.i("MicroMsg.Priority.CalC2CChatPriorityTask", "no need to cal usage result");
                AppMethodBeat.o(87868);
                return;
            }
        }
        b priorityDB = ((PluginPriority) g.ah(PluginPriority.class)).getPriorityDB();
        if (priorityDB.aKc("C2CChatUsage") == 0) {
            AppMethodBeat.o(87868);
            return;
        }
        e.INSTANCE.idkeyStat(1252, 1, 1, false);
        long eCQ = a.eCQ();
        long currentTimeMillis = System.currentTimeMillis();
        priorityDB.execSQL(String.format("INSERT OR REPLACE INTO %s(chat) SELECT distinct(chat) AS chat FROM %s WHERE date >= ?;", "C2CChatUsageResult", "C2CChatUsage"), new String[]{String.valueOf(eCQ - 2505600000L)});
        a(priorityDB, WeChatBrands.Business.GROUP_OPEN, currentTimeMillis, 0.4f, 0.4f, 0.2f);
        a(priorityDB, "sendmsg", currentTimeMillis, 0.7f, 0.2f, 0.1f);
        a(priorityDB, "consumemsg", currentTimeMillis, 0.3f, 0.3f, 0.4f);
        long eCQ2 = a.eCQ();
        long j2 = eCQ2 - 2505600000L;
        String str = "staytime" + "total";
        String str2 = "staytime" + "peropen";
        String str3 = "staytime" + "temp";
        if (priorityDB.ayi(str3)) {
            priorityDB.aKd(str3);
        }
        priorityDB.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(MMDecaySum(%d, date, %s, %d, %d) AS DOUBLE) AS %s, cast(MMSumDivision(%s, %s, 0) AS DOUBLE) AS %s FROM %s WHERE date >= ? GROUP BY chat;", str3, Long.valueOf(eCQ2), "staytime", 7, 2, str, "opencount", "staytime", str2, "C2CChatUsage"), new String[]{String.valueOf(j2)});
        double[] dArr = new double[2];
        Cursor rawQuery = priorityDB.rawQuery(String.format("SELECT avg(%s), avg(%s) FROM %s", str, str2, str3), null);
        if (rawQuery.moveToNext()) {
            dArr[0] = rawQuery.getDouble(0);
            dArr[1] = rawQuery.getDouble(1);
        }
        rawQuery.close();
        double[] dArr2 = new double[2];
        Cursor rawQuery2 = priorityDB.rawQuery(String.format("SELECT MMStdev(%s, %f), MMStdev(%s, %f) FROM %s", str, Double.valueOf(dArr[0]), str2, Double.valueOf(dArr[1]), str3), null);
        if (rawQuery2.moveToNext()) {
            dArr2[0] = rawQuery2.getDouble(0);
            dArr2[1] = rawQuery2.getDouble(1);
        }
        rawQuery2.close();
        Log.i("MicroMsg.Priority.CalC2CChatPriorityTask", "calculateStayTime %.2f %.2f %.2f %.2f", Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(dArr2[0]), Double.valueOf(dArr2[1]));
        String str4 = "staytime" + "temp2";
        if (priorityDB.ayi(str4)) {
            priorityDB.aKd(str4);
        }
        String str5 = str + APMidasPayAPI.ENV_DEV;
        String str6 = str2 + APMidasPayAPI.ENV_DEV;
        priorityDB.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s FROM %s", str4, str, Double.valueOf(dArr[0]), Double.valueOf(dArr2[0]), str5, str2, Double.valueOf(dArr[1]), Double.valueOf(dArr2[1]), str6, str3));
        priorityDB.execSQL(String.format("UPDATE %s SET staytimedev = (SELECT MMDWeightAverage(%s, %f, %s, %f) FROM %s E WHERE %s.chat = E.chat);", "C2CChatUsageResult", str5, Double.valueOf(0.5d), str6, Double.valueOf(0.5d), str4, "C2CChatUsageResult"));
        double pow = (((2.2847d - (4.729d * Math.pow(0.9d, 2.0d))) + (3.937d * Math.pow(0.9d, 3.0d))) / 0.9d) * 0.09999999999999998d;
        Log.i("MicroMsg.Priority.CalC2CChatPriorityTask", "d: %.2f r: %.4f", Double.valueOf(0.9d), Double.valueOf(pow));
        priorityDB.execSQL(String.format("UPDATE %s SET totallsp = MMLSP(%f, %d, %s, %f, %s, %f, %s, %f, %s, %f)", "C2CChatUsageResult", Double.valueOf(pow), 4, "openrmf", Double.valueOf(0.1d), "sendmsgrmf", Double.valueOf(0.3d), "staytimedev", Double.valueOf(0.3d), "consumemsgrmf", Double.valueOf(0.3d)));
        if (priorityDB.ayi("lsptemp")) {
            priorityDB.aKd("lsptemp");
        }
        priorityDB.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(RANK() OVER (ORDER BY totallsp DESC) AS INTEGER) as rank FROM %s", "lsptemp", "C2CChatUsageResult"));
        priorityDB.execSQL(String.format("UPDATE %s SET rank=(SELECT E.rank FROM %s E WHERE %s.chat=E.chat);", "C2CChatUsageResult", "lsptemp", "C2CChatUsageResult"));
        ((PluginPriority) g.ah(PluginPriority.class)).getPriorityDB().ah(16777219, eCQ);
        e.INSTANCE.idkeyStat(1252, 0, 1, false);
        AppMethodBeat.o(87868);
    }

    private static void a(b bVar, String str, long j2, float f2, float f3, float f4) {
        AppMethodBeat.i(87869);
        long eCQ = a.eCQ();
        long j3 = eCQ - 2505600000L;
        String str2 = str + "temp";
        if (bVar.ayi(str2)) {
            bVar.aKd(str2);
        }
        String str3 = str + "count";
        String str4 = str + "totalcount";
        String str5 = str + "frequency";
        String str6 = str + "recent";
        bVar.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(MMDecaySum(%d, date, %s, %d, %d) AS DOUBLE) AS %s, cast(MMFrequency(%s) AS DOUBLE) AS %s, cast(MMRecent(%d, %s, %s, 30) AS DOUBLE) AS %s FROM %s WHERE date >= ? GROUP BY chat;", str2, Long.valueOf(eCQ), str3, 7, 2, str4, str3, str5, Long.valueOf(j2), FFmpegMetadataRetriever.METADATA_KEY_DATE, str3, str6, "C2CChatUsage"), new String[]{String.valueOf(j3)});
        if (bVar.aKc(str2) == 0) {
            AppMethodBeat.o(87869);
            return;
        }
        double[] dArr = new double[3];
        Cursor rawQuery = bVar.rawQuery(String.format("SELECT avg(%s), avg(%s), avg(%s) FROM %s", str4, str5, str6, str2), null);
        if (rawQuery.moveToNext()) {
            dArr[0] = rawQuery.getDouble(0);
            dArr[1] = rawQuery.getDouble(1);
            dArr[2] = rawQuery.getDouble(2);
        }
        rawQuery.close();
        double[] dArr2 = new double[3];
        Cursor rawQuery2 = bVar.rawQuery(String.format("SELECT MMStdev(%s, %f), MMStdev(%s, %f), MMStdev(%s, %f) FROM %s", str4, Double.valueOf(dArr[0]), str5, Double.valueOf(dArr[1]), str6, Double.valueOf(dArr[2]), str2), null);
        if (rawQuery2.moveToNext()) {
            dArr2[0] = rawQuery2.getDouble(0);
            dArr2[1] = rawQuery2.getDouble(1);
            dArr2[2] = rawQuery2.getDouble(2);
        }
        rawQuery2.close();
        Log.i("MicroMsg.Priority.CalC2CChatPriorityTask", "calculateStdev %s %.2f %.2f %.2f %.2f %.2f %.2f", str, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(dArr[2]), Double.valueOf(dArr2[0]), Double.valueOf(dArr2[1]), Double.valueOf(dArr2[2]));
        String str7 = str + "temp2";
        if (bVar.ayi(str7)) {
            bVar.aKd(str7);
        }
        String str8 = str + "totalcountdev";
        String str9 = str + "frequencydev";
        String str10 = str + "recentdev";
        bVar.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s FROM %s", str7, str4, Double.valueOf(dArr[0]), Double.valueOf(dArr2[0]), str8, str5, Double.valueOf(dArr[1]), Double.valueOf(dArr2[1]), str9, str6, Double.valueOf(dArr[2]), Double.valueOf(dArr2[2]), str10, str2));
        if (bVar.aKc(str7) == 0) {
            AppMethodBeat.o(87869);
            return;
        }
        bVar.execSQL(String.format("UPDATE %s SET %s = (SELECT MMDWeightAverage(%s, %f, %s, %f, %s, %f) FROM %s B WHERE %s.chat = B.chat);", "C2CChatUsageResult", str + "rmf", str8, Float.valueOf(f2), str9, Float.valueOf(f3), str10, Float.valueOf(f4), str7, "C2CChatUsageResult"));
        AppMethodBeat.o(87869);
    }

    public static boolean eDa() {
        AppMethodBeat.i(87870);
        try {
            if (((PluginPriority) g.ah(PluginPriority.class)).getPriorityDB().ag(16777219, 0) < a.eCQ()) {
                AppMethodBeat.o(87870);
                return true;
            }
            AppMethodBeat.o(87870);
            return false;
        } catch (Exception e2) {
            AppMethodBeat.o(87870);
            return false;
        }
    }
}
