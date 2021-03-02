package com.tencent.mm.plugin.game.commlib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class b {
    private static final String xvB = (com.tencent.mm.loader.j.b.aKB() + "game/");
    private static final String xvC = (com.tencent.mm.loader.j.b.aKJ() + "game/");

    static {
        AppMethodBeat.i(89976);
        AppMethodBeat.o(89976);
    }

    public static String dTg() {
        String str;
        AppMethodBeat.i(256620);
        String str2 = g.hYQ().hYU().get("account");
        if (!Util.isNullOrNil(str2)) {
            str = com.tencent.mm.loader.j.b.aKB() + str2 + "/game/";
        } else {
            str = xvB;
        }
        Log.i("MicroMsg.GameFileManager", "getGameDataRootPathByUin, validPath:%s", str);
        AppMethodBeat.o(256620);
        return str;
    }

    public enum a {
        ONE_DAY(Util.MILLSECONDS_OF_DAY),
        THREE_DAY(259200000),
        ONE_WEEK(604800000),
        ONE_MONTH(2592000000L),
        PERMANENT(MAlarmHandler.NEXT_FIRE_INTERVAL);
        
        long time;

        public static a valueOf(String str) {
            AppMethodBeat.i(89967);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(89967);
            return aVar;
        }

        static {
            AppMethodBeat.i(89968);
            AppMethodBeat.o(89968);
        }

        private a(long j2) {
            this.time = j2;
        }
    }

    public static String a(a aVar) {
        AppMethodBeat.i(256621);
        String str = xvB + aVar.name() + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(256621);
        return str;
    }

    public static String b(a aVar) {
        AppMethodBeat.i(89970);
        String str = dTg() + aVar.name() + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(89970);
        return str;
    }

    public static String c(a aVar) {
        AppMethodBeat.i(89971);
        String str = xvC + aVar.name() + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(89971);
        return str;
    }

    public static void clean() {
        AppMethodBeat.i(89972);
        if (Util.secondsToNow(Util.nullAsNil((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GAME_FILE_CLEAN_TIME_LONG, (Object) 0L))) > 86400) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GAME_FILE_CLEAN_TIME_LONG, Long.valueOf(Util.nowSecond()));
            com.tencent.mm.plugin.game.commlib.c.a.dTf().a("game_cache_clean", new a.AbstractC1395a() {
                /* class com.tencent.mm.plugin.game.commlib.util.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.game.commlib.c.a.AbstractC1395a
                public final void cBm() {
                    AppMethodBeat.i(256619);
                    a.getWorkerHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.game.commlib.util.b.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(256618);
                            b.access$000();
                            AppMethodBeat.o(256618);
                        }
                    }, 0);
                    AppMethodBeat.o(256619);
                }
            });
        }
        AppMethodBeat.o(89972);
    }

    public static void remove(String str) {
        AppMethodBeat.i(89973);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(89973);
            return;
        }
        Log.i("MicroMsg.GameFileManager", "delete file:%s, ret:%b", str, Boolean.valueOf(s.deleteFile(str)));
        AppMethodBeat.o(89973);
    }

    private static boolean b(o oVar, long j2) {
        o[] het;
        AppMethodBeat.i(89974);
        if (oVar == null || !oVar.exists()) {
            AppMethodBeat.o(89974);
            return false;
        }
        if (oVar.isFile()) {
            if (System.currentTimeMillis() - oVar.lastModified() > j2) {
                Log.i("MicroMsg.GameFileManager", "remove file:%s, lifetime:%d", aa.z(oVar.her()), Long.valueOf(j2));
                oVar.delete();
            }
        } else if (oVar.isDirectory() && (het = oVar.het()) != null) {
            for (o oVar2 : het) {
                b(oVar2, j2);
            }
        }
        AppMethodBeat.o(89974);
        return true;
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(256622);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a[] values = a.values();
            for (a aVar : values) {
                if (aVar != a.PERMANENT) {
                    b(new o(a(aVar)), aVar.time);
                    b(new o(b(aVar)), aVar.time);
                    b(new o(c(aVar)), aVar.time);
                    StringBuilder sb = new StringBuilder();
                    String str = g.hYQ().hYU().get("account");
                    String str2 = !Util.isNullOrNil(str) ? com.tencent.mm.loader.j.b.aKJ() + str + "/game/" : xvC;
                    Log.i("MicroMsg.GameFileManager", "getGameSdcardRootPathByUin, validPath:%s", str2);
                    b(new o(sb.append(str2).append(aVar.name()).append(FilePathGenerator.ANDROID_DIR_SEP).toString()), aVar.time);
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.GameFileManager", e2, "", new Object[0]);
        }
        Log.i("MicroMsg.GameFileManager", "remove expire files cost time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(256622);
    }
}
