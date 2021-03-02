package com.tencent.matrix.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.report.h;
import com.tencent.matrix.trace.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements h.c {
    private static long cUG;

    static {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.matrix.b.a.AnonymousClass1 */

            public final void run() {
                long unused = a.cUG = (long) Process.myTid();
            }
        });
    }

    @Override // com.tencent.matrix.report.h.c
    public final void a(h.d dVar) {
        JSONObject jSONObject;
        String str = dVar.tag;
        String str2 = dVar.key;
        final JSONObject jSONObject2 = dVar.cWe;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (str.equals("Trace")) {
            try {
                if (dVar.tag.equalsIgnoreCase("Trace_EvilMethod") && jSONObject2.getString("detail").equalsIgnoreCase(a.EnumC0233a.ANR.toString())) {
                    String string = jSONObject2.getString("cost");
                    long safeParseLong = Util.safeParseLong(str2);
                    long safeParseLong2 = Util.safeParseLong(string);
                    if (g.aAc()) {
                        com.tencent.mm.storagebase.h hVar = g.aAh().hqK;
                        if (hVar == null || hVar.gFG() == null) {
                            Log.w("MicroMsg.AnrReportListener", "sqliteDB is null!");
                        } else {
                            f.a gFz = f.gFz();
                            long j2 = gFz.time;
                            Log.i("MicroMsg.AnrReportListener", "[happen] threadStatus:%s sql:%s time:%s db:%s", Integer.valueOf(gFz.status), gFz.sql, Long.valueOf(j2), gFz.AYk);
                            if (gFz.AYk != null) {
                                long currentTimeMillis = (System.currentTimeMillis() - safeParseLong2) - (SystemClock.uptimeMillis() - (safeParseLong + safeParseLong2));
                                int i2 = 0;
                                long j3 = 0;
                                long j4 = 0;
                                JSONObject jSONObject3 = new JSONObject();
                                JSONObject dumpJSON = gFz.AYk.dumpJSON(false);
                                Log.i("MicroMsg.AnrReportListener", "[happen] db raw json:%s", dumpJSON);
                                JSONArray jSONArray = dumpJSON.getJSONArray("availableNonPrimary");
                                int i3 = 0;
                                while (i3 < jSONArray.length()) {
                                    JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                                    JSONArray jSONArray2 = jSONObject4.getJSONArray("operations");
                                    JSONArray jSONArray3 = new JSONArray();
                                    jSONObject4.put("operations", jSONArray3);
                                    if (i3 == 0 && gFz.status == 3) {
                                        JSONObject jSONObject5 = new JSONObject();
                                        jSONArray2.put(jSONObject5);
                                        jSONObject5.put("start", j2);
                                        jSONObject5.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Math.min(safeParseLong2, (currentTimeMillis + safeParseLong2) - j2));
                                        jSONObject5.put("tid", cUG);
                                        Log.i("MicroMsg.AnrReportListener", "[happen] add executing:%s", jSONObject5);
                                    }
                                    long j5 = j4;
                                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                                        JSONObject jSONObject6 = jSONArray2.getJSONObject(i4);
                                        long j6 = jSONObject6.getLong("start");
                                        long j7 = jSONObject6.getLong(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                                        long j8 = jSONObject6.getLong("tid");
                                        if (currentTimeMillis <= j6) {
                                            i2++;
                                            j5 += j7;
                                            if (((float) j7) >= ((float) safeParseLong2) * 0.1f) {
                                                jSONArray3.put(jSONObject6);
                                            }
                                            if (cUG == j8) {
                                                j3 += j7;
                                            }
                                        }
                                    }
                                    i3++;
                                    j4 = j5;
                                }
                                boolean z = ((float) j3) >= ((float) safeParseLong2) * 0.5f;
                                jSONObject3.put("isDbBusy", z);
                                jSONObject2.put("isDbBusy", z);
                                jSONObject3.put("execSqlCount", i2);
                                jSONObject3.put("mainThreadAllSqlCost", j3);
                                jSONObject3.put("allSqlCost", j4);
                                if (z) {
                                    jSONObject = dumpJSON;
                                } else {
                                    jSONObject = new JSONObject();
                                }
                                jSONObject3.put("detail", jSONObject);
                                jSONObject2.put("dbInfo", jSONObject3);
                            } else {
                                Log.i("MicroMsg.AnrReportListener", "has't any db operation in time!");
                            }
                        }
                        com.tencent.f.h.RTc.aX(new Runnable() {
                            /* class com.tencent.matrix.b.a.AnonymousClass2 */

                            public final void run() {
                                Log.i("MicroMsg.AnrReportListener", "[happen] %s", jSONObject2.toString());
                            }
                        });
                    }
                }
                Log.i("MicroMsg.AnrReportListener", "[report] cost:%sms", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AnrReportListener", e2, "", new Object[0]);
                Log.i("MicroMsg.AnrReportListener", "[report] cost:%sms", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            } catch (Throwable th) {
                Log.i("MicroMsg.AnrReportListener", "[report] cost:%sms", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                throw th;
            }
        }
    }
}
