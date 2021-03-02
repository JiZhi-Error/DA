package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderFolderClearManager;", "", "()V", "MARK_DEL_FOLDERS", "", "TAG", "fileLock", "Ljava/lang/Object;", "finderUICount", "", "lastDumpTime", "", "checkClearWhenAppInBackground", "", "clearMarkFolder", "dumpAndMark", "enterFinderUI", "exitFinderUI", "mark", "curSize", "folder", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "plugin-finder_release"})
public final class j {
    static final String TAG = TAG;
    private static long hjF;
    static final Object vSw = new Object();
    public static final j vVA = new j();
    static int vVz;

    static {
        AppMethodBeat.i(167889);
        AppForegroundDelegate.INSTANCE.a(new o() {
            /* class com.tencent.mm.plugin.finder.utils.j.AnonymousClass1 */

            @Override // com.tencent.mm.app.o
            public final void onAppForeground(String str) {
            }

            @Override // com.tencent.mm.app.o
            public final void onAppBackground(String str) {
                AppMethodBeat.i(167887);
                j jVar = j.vVA;
                Log.i(j.TAG, "checkClearWhenAppInBackground");
                if (j.vVz <= 0) {
                    Log.i(j.TAG, "clearMarkFolder");
                    synchronized (j.vSw) {
                        try {
                            long currentTicks = Util.currentTicks();
                            MultiProcessMMKV singleDefault = MultiProcessMMKV.getSingleDefault();
                            Set<String> stringSet = singleDefault.getStringSet("FINDER_MARK_DEL_FOLDERS", new HashSet());
                            if (stringSet != null) {
                                for (T t : stringSet) {
                                    Log.i(j.TAG, "clearMarkFolders ".concat(String.valueOf(t)));
                                    s.dy(t, true);
                                    al alVar = al.waC;
                                    if (p.j(t, al.dEz())) {
                                        d dVar = d.vGR;
                                        d.bnU();
                                    }
                                }
                            }
                            singleDefault.putStringSet("FINDER_MARK_DEL_FOLDERS", new HashSet());
                            al alVar2 = al.waC;
                            for (i iVar : al.dEB()) {
                                iVar.dBE();
                            }
                            long ticksToNow = Util.ticksToNow(currentTicks);
                            if (stringSet != null && stringSet.size() > 0) {
                                r.a aVar = r.a.vgH;
                                r.a.Fj(ticksToNow);
                            }
                            Log.i(j.TAG, "clearMarkFolder cost:".concat(String.valueOf(ticksToNow)));
                            x xVar = x.SXb;
                        } finally {
                            AppMethodBeat.o(167887);
                        }
                    }
                    f fVar = f.vSz;
                    f.dAW();
                }
            }
        });
        AppMethodBeat.o(167889);
    }

    private j() {
    }

    public static void dBG() {
        vVz++;
    }

    public static void dBH() {
        int i2 = vVz - 1;
        vVz = i2;
        if (i2 < 0) {
            vVz = 0;
        }
    }

    public static void dBI() {
        AppMethodBeat.i(167888);
        Log.i(TAG, "dumpAndMark");
        long aWy = cl.aWy();
        c cVar = c.vCb;
        if (aWy - hjF < c.drh()) {
            AppMethodBeat.o(167888);
            return;
        }
        long currentTicks = Util.currentTicks();
        hjF = aWy;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        al alVar = al.waC;
        i[] dEB = al.dEB();
        for (i iVar : dEB) {
            long longValue = iVar.dBF().second.longValue();
            if (iVar.vVy && longValue > iVar.maxSize) {
                synchronized (vSw) {
                    try {
                        Log.i(TAG, "mark: size " + longValue + ", name " + iVar.name + ", path " + iVar.path);
                        MultiProcessMMKV singleDefault = MultiProcessMMKV.getSingleDefault();
                        Set<String> stringSet = singleDefault.getStringSet("FINDER_MARK_DEL_FOLDERS", new HashSet());
                        if (stringSet == null) {
                            p.hyc();
                        }
                        stringSet.add(iVar.path);
                        singleDefault.putStringSet("FINDER_MARK_DEL_FOLDERS", stringSet).commit();
                    } catch (Throwable th) {
                        AppMethodBeat.o(167888);
                        throw th;
                    }
                }
            }
            linkedHashMap.put(iVar.name, Long.valueOf(longValue));
        }
        long ticksToNow = Util.ticksToNow(currentTicks);
        r.a aVar = r.a.vgH;
        r.a.Fk(ticksToNow);
        r.a aVar2 = r.a.vgH;
        r.a.ai(linkedHashMap);
        AppMethodBeat.o(167888);
    }
}
