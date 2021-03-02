package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.h;
import com.tencent.mm.bb.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class h {
    public static void run() {
        AppMethodBeat.i(19885);
        Context context = MMApplicationContext.getContext();
        AnonymousClass1 r2 = new h.a() {
            /* class com.tencent.mm.booter.h.AnonymousClass1 */

            @Override // com.tencent.mm.app.h.a
            public final void iN(int i2) {
                AppMethodBeat.i(19884);
                Log.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", Integer.valueOf(i2));
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(25, (long) i2, 1, false);
                AppMethodBeat.o(19884);
            }
        };
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                String[] split = sharedPreferences.getString("crashlist", "").split(";");
                if (split != null && split.length > 0) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("crashlist", "");
                    edit.commit();
                    for (int i2 = 0; i2 < split.length; i2++) {
                        String[] split2 = split[i2] == null ? null : split[i2].split(",");
                        if (split2 != null && split2.length >= 2) {
                            if (split2[1].equals("anr")) {
                                r2.iN(10);
                            } else {
                                r2.iN(11);
                                if (MMApplicationContext.getApplicationId().equals(split2[0])) {
                                    r2.iN(14);
                                }
                                if ((MMApplicationContext.getApplicationId() + ":push").equals(split2[0])) {
                                    r2.iN(17);
                                }
                                if ((MMApplicationContext.getApplicationId() + ":tools").equals(split2[0])) {
                                    r2.iN(20);
                                }
                                if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(split2[0])) {
                                    r2.iN(20);
                                }
                                if (split2[1].equals("java")) {
                                    r2.iN(12);
                                    if (MMApplicationContext.getApplicationId().equals(split2[0])) {
                                        r2.iN(15);
                                    }
                                    if ((MMApplicationContext.getApplicationId() + ":push").equals(split2[0])) {
                                        r2.iN(18);
                                    }
                                    if ((MMApplicationContext.getApplicationId() + ":tools").equals(split2[0])) {
                                        r2.iN(21);
                                    }
                                    if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(split2[0])) {
                                        r2.iN(21);
                                    }
                                }
                                if (split2[1].equals("jni")) {
                                    r2.iN(13);
                                    if (MMApplicationContext.getApplicationId().equals(split2[0])) {
                                        r2.iN(16);
                                    }
                                    if ((MMApplicationContext.getApplicationId() + ":push").equals(split2[0])) {
                                        r2.iN(19);
                                    }
                                    if ((MMApplicationContext.getApplicationId() + ":tools").equals(split2[0])) {
                                        r2.iN(22);
                                    }
                                    if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(split2[0])) {
                                        r2.iN(22);
                                    }
                                }
                                if (split2[1].equals("first")) {
                                    if (MMApplicationContext.getApplicationId().equals(split2[0])) {
                                        r2.iN(23);
                                    }
                                    if ((MMApplicationContext.getApplicationId() + ":push").equals(split2[0])) {
                                        r2.iN(24);
                                    }
                                    if ((MMApplicationContext.getApplicationId() + ":tools").equals(split2[0])) {
                                        r2.iN(25);
                                    }
                                    if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(split2[0])) {
                                        r2.iN(25);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        Context context2 = MMApplicationContext.getContext();
        int i3 = com.tencent.mm.n.h.aqJ().getInt("AndroidGooglePlayCrashUploadSizeLimit", 8192);
        if (context2 != null && i3 > 0) {
            try {
                SharedPreferences sharedPreferences2 = context2.getSharedPreferences("crash_status_file", 4);
                if (sharedPreferences2.getInt("googleplaysizelimit", 8192) != i3) {
                    SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                    edit2.putInt("googleplaysizelimit", i3);
                    edit2.commit();
                }
            } catch (Throwable th2) {
            }
        }
        bg.aVF();
        if (Util.milliSecondsToNow(Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, (Object) null), 0)) > 21600000) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(279, (long) (com.tencent.mm.n.h.aqJ().getInt("AndroidDynamicConfigVer", 0) % 16), 1, false);
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, Long.valueOf(Util.nowMilliSecond()));
        }
        bg.aVF();
        if (Util.milliSecondsToNow(Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, (Object) null), 0)) > 21600000) {
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, Long.valueOf(Util.nowMilliSecond()));
            o.bhj().bhE();
        }
        if (Util.nowMilliSecond() - Util.nullAs((Long) g.aAh().azQ().get(81939, (Object) null), 0) > Util.MILLSECONDS_OF_DAY) {
            new j();
        }
        long currentTimeMillis = System.currentTimeMillis();
        bg.aVF();
        boolean booleanValue = ((Boolean) c.azQ().get(233475, Boolean.FALSE)).booleanValue();
        bg.aVF();
        if (c.aSN().gCe() <= 0) {
            if (!booleanValue) {
                bg.aVF();
                c.aST().bjW("officialaccounts");
                bg.aVF();
                c.azQ().set(233475, Boolean.TRUE);
            }
        } else if (booleanValue) {
            bg.aVF();
            c.azQ().set(233475, Boolean.FALSE);
        }
        com.tencent.mm.plugin.webwx.a.g.gjb().gjd().gja();
        Log.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(19885);
    }
}
