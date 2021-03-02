package com.tencent.mm.plugin.downloader_app.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.c.a;
import com.tencent.mm.plugin.downloader_app.c.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;

public final class j {
    private static LinkedList<String> qLl = new LinkedList<>();
    private static LinkedList<String> qLm = new LinkedList<>();
    private static d.AbstractC0946d qLn;

    static {
        AppMethodBeat.i(8920);
        AppMethodBeat.o(8920);
    }

    public static void stop() {
        AppMethodBeat.i(8910);
        qLl.clear();
        qLm.clear();
        if (qLn != null) {
            d.b(qLn);
        }
        qLn = null;
        AppMethodBeat.o(8910);
    }

    public static LinkedList<String> cCg() {
        AppMethodBeat.i(8911);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(qLl);
        linkedList.addAll(qLm);
        AppMethodBeat.o(8911);
        return linkedList;
    }

    public static LinkedList<String> cCh() {
        AppMethodBeat.i(8912);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(qLl);
        AppMethodBeat.o(8912);
        return linkedList;
    }

    public static int alA(String str) {
        AppMethodBeat.i(8913);
        if (qLm.contains(str)) {
            int i2 = k.qLo;
            AppMethodBeat.o(8913);
            return i2;
        }
        int i3 = k.UN_INSTALLED;
        AppMethodBeat.o(8913);
        return i3;
    }

    public static boolean contains(String str) {
        AppMethodBeat.i(8914);
        if (qLm.contains(str) || qLl.contains(str)) {
            AppMethodBeat.o(8914);
            return true;
        }
        AppMethodBeat.o(8914);
        return false;
    }

    public static void alB(String str) {
        AppMethodBeat.i(8915);
        if (!contains(str)) {
            qLl.addFirst(str);
            if (b.cCi() != null) {
                a aVar = new a();
                aVar.field_appId = str;
                aVar.field_modifyTime = System.currentTimeMillis();
                b.cCi().insert(aVar);
            }
        }
        AppMethodBeat.o(8915);
    }

    public static void EN(String str) {
        AppMethodBeat.i(8916);
        qLm.remove(str);
        qLl.remove(str);
        if (b.cCi() != null) {
            b.cCi().execSQL("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", "DownloadTaskItem", "appId", str));
        }
        AppMethodBeat.o(8916);
    }

    public static boolean cBP() {
        AppMethodBeat.i(8917);
        if (qLl.size() > 0) {
            AppMethodBeat.o(8917);
            return true;
        }
        AppMethodBeat.o(8917);
        return false;
    }

    public static void cBS() {
        AppMethodBeat.i(175275);
        Iterator<String> it = qLl.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.downloader.g.a alb = com.tencent.mm.plugin.downloader.model.d.alb(it.next());
            if (alb != null && alb.field_status == 1) {
                f.cBv().Cp(alb.field_downloadId);
            }
        }
        AppMethodBeat.o(175275);
    }

    public static void cCf() {
        LinkedList linkedList = null;
        AppMethodBeat.i(8909);
        if (b.cCi() != null) {
            Cursor rawQuery = b.cCi().rawQuery(String.format("select * from %s order by %s desc", "DownloadTaskItem", "modifyTime"), new String[0]);
            if (rawQuery != null) {
                linkedList = new LinkedList();
                while (rawQuery.moveToNext()) {
                    a aVar = new a();
                    aVar.convertFrom(rawQuery);
                    linkedList.add(aVar);
                }
                rawQuery.close();
            }
        }
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                Log.d("MicroMsg.TaskManager", "initFromDB, appId:%s, status:%d", aVar2.field_appId, Integer.valueOf(aVar2.field_status));
                if (aVar2.field_status == k.qLo) {
                    if (!qLm.contains(aVar2.field_appId)) {
                        qLm.add(aVar2.field_appId);
                    }
                } else if (!qLl.contains(aVar2.field_appId)) {
                    qLl.add(aVar2.field_appId);
                }
            }
        }
        if (qLn == null) {
            qLn = new d.AbstractC0946d() {
                /* class com.tencent.mm.plugin.downloader_app.a.j.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.downloader_app.a.d.AbstractC0946d
                public final void O(int i2, long j2) {
                    AppMethodBeat.i(8908);
                    com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                    if (Cw == null) {
                        AppMethodBeat.o(8908);
                        return;
                    }
                    Log.i("MicroMsg.TaskManager", "onDownloadStatusChange, event = %d, appId = %s", Integer.valueOf(i2), Cw.field_appId);
                    if (!j.contains(Cw.field_appId)) {
                        AppMethodBeat.o(8908);
                    } else if (i2 == 9) {
                        j.CS(Cw.field_appId);
                        AppMethodBeat.o(8908);
                    } else {
                        if (i2 == 1 || i2 == 7) {
                            g o = h.o(Cw.field_appId, true, false);
                            if (o == null || !q.s(MMApplicationContext.getContext(), o.field_packageName)) {
                                j.Pn(Cw.field_appId);
                            } else {
                                Log.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
                                AppMethodBeat.o(8908);
                                return;
                            }
                        }
                        AppMethodBeat.o(8908);
                    }
                }
            };
        }
        d.a(qLn);
        AppMethodBeat.o(8909);
    }

    static /* synthetic */ void CS(String str) {
        AppMethodBeat.i(8918);
        if (!qLm.contains(str)) {
            qLl.remove(str);
            qLm.addFirst(str);
            b.cX(str, k.qLo);
        }
        AppMethodBeat.o(8918);
    }

    static /* synthetic */ void Pn(String str) {
        AppMethodBeat.i(8919);
        if (!qLl.contains(str)) {
            qLm.remove(str);
            qLl.addFirst(str);
            b.cX(str, k.UN_INSTALLED);
        }
        AppMethodBeat.o(8919);
    }
}
