package com.tencent.mm.pluginsdk.j.a.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;

final class p {
    static boolean gnZ() {
        AppMethodBeat.i(152054);
        if (g.aAf().azp()) {
            g.aAf();
            if (!a.azj()) {
                AppMethodBeat.o(152054);
                return true;
            }
        }
        AppMethodBeat.o(152054);
        return false;
    }

    public static void awI() {
        AppMethodBeat.i(152055);
        if (!gnZ()) {
            AppMethodBeat.o(152055);
        } else if (getNetworkType() == 0) {
            AppMethodBeat.o(152055);
        } else {
            long nowSecond = Util.nowSecond();
            if (Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, (Object) null), 0) < nowSecond) {
                g.aAh().azQ().set(ar.a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, Long.valueOf(7200 + nowSecond));
                Log.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
                q.a.Kan.cyh().postToWorker(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.j.a.c.p.AnonymousClass1 */

                    public final void run() {
                        LinkedList<s> linkedList = null;
                        AppMethodBeat.i(152053);
                        if (!p.gnZ()) {
                            Log.e("MicroMsg.PostTaskCheckResume", "try resumeAllAndEvictExpired but account not ready");
                            AppMethodBeat.o(152053);
                            return;
                        }
                        try {
                            q qVar = q.a.Kan;
                            int networkType = p.getNetworkType();
                            Log.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", Integer.valueOf(networkType));
                            if (networkType == 0) {
                                Log.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
                                AppMethodBeat.o(152053);
                            } else if (!qVar.lsb) {
                                Log.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
                                AppMethodBeat.o(152053);
                            } else {
                                if (qVar.lsb) {
                                    long nowMilliSecond = Util.nowMilliSecond();
                                    Cursor all = qVar.Kak.getAll();
                                    if (all != null) {
                                        if (all.getCount() <= 0) {
                                            all.close();
                                        } else {
                                            linkedList = new LinkedList();
                                            all.moveToFirst();
                                            do {
                                                s sVar = new s();
                                                sVar.convertFrom(all);
                                                linkedList.add(sVar);
                                            } while (all.moveToNext());
                                            all.close();
                                        }
                                    }
                                    Log.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
                                }
                                if (Util.isNullOrNil(linkedList)) {
                                    Log.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
                                    AppMethodBeat.o(152053);
                                    return;
                                }
                                for (s sVar2 : linkedList) {
                                    if (!Util.isNullOrNil(sVar2.field_groupId1)) {
                                        int hashCode = sVar2.field_groupId1.hashCode();
                                        for (g gVar : r.gob()) {
                                            if (hashCode == Util.nullAsNil(gVar.avy()).hashCode()) {
                                                gVar.gnF().a(sVar2, networkType);
                                            }
                                        }
                                    }
                                }
                                AppMethodBeat.o(152053);
                            }
                        } catch (SQLiteDatabaseCorruptException | com.tencent.wcdb.database.SQLiteDatabaseCorruptException e2) {
                            Log.printErrStackTrace("MicroMsg.PostTaskCheckResume", e2, "resumeAllAndEvictExpired", new Object[0]);
                            AppMethodBeat.o(152053);
                        }
                    }
                });
            }
            AppMethodBeat.o(152055);
        }
    }

    static int getNetworkType() {
        AppMethodBeat.i(152056);
        switch (ab.ape()) {
            case 0:
                AppMethodBeat.o(152056);
                return 0;
            case 1:
                AppMethodBeat.o(152056);
                return 1;
            default:
                AppMethodBeat.o(152056);
                return 2;
        }
    }
}
