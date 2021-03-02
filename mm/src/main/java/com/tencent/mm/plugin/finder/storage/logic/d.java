package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.model.a;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class d {
    public static final w toc = ((PluginFinder) g.ah(PluginFinder.class)).getMediaCacheStorage();
    private static final f uTP = kotlin.g.ah(b.vGS);
    private static final boolean uUD = com.tencent.mm.plugin.finder.storage.c.dsh();
    private static final HashMap<String, at> vGP = new HashMap<>(100);
    private static final boolean vGQ;
    public static final d vGR = new d();

    private static com.tencent.mm.plugin.finder.preload.model.a getPreloadModel() {
        AppMethodBeat.i(252086);
        com.tencent.mm.plugin.finder.preload.model.a aVar = (com.tencent.mm.plugin.finder.preload.model.a) uTP.getValue();
        AppMethodBeat.o(252086);
        return aVar;
    }

    static {
        boolean z;
        AppMethodBeat.i(167109);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvP().value().intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        vGQ = z;
        AppMethodBeat.o(167109);
    }

    private d() {
    }

    public static boolean d(at atVar) {
        boolean z;
        boolean b2;
        AppMethodBeat.i(252074);
        p.h(atVar, "cache");
        atVar.field_updateTime = cl.aWA();
        w wVar = toc;
        String str = atVar.field_mediaId;
        p.g(str, "cache.field_mediaId");
        p.h(str, "mediaId");
        Cursor rawQuery = wVar.db.rawQuery("select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + str + "' ", null);
        p.g(rawQuery, "cursor");
        if (rawQuery.getCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        rawQuery.close();
        if (z) {
            boolean c2 = toc.c(atVar);
            w wVar2 = toc;
            String str2 = atVar.field_mediaId;
            p.g(str2, "cache.field_mediaId");
            at avt = wVar2.avt(str2);
            synchronized (vGP) {
                try {
                    String str3 = atVar.field_mediaId;
                    p.g(str3, "cache.field_mediaId");
                    vGP.put(str3, avt);
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(252074);
                    throw th;
                }
            }
            b2 = c2;
        } else {
            synchronized (vGP) {
                try {
                    String str4 = atVar.field_mediaId;
                    p.g(str4, "cache.field_mediaId");
                    vGP.put(str4, atVar);
                    x xVar2 = x.SXb;
                } catch (Throwable th2) {
                    AppMethodBeat.o(252074);
                    throw th2;
                }
            }
            b2 = toc.b(atVar);
        }
        Log.i("Finder.MediaCacheLogic", "replaced[" + b2 + "] isExist=" + z + ' ' + atVar);
        AppMethodBeat.o(252074);
        return b2;
    }

    public static void avG(String str) {
        AppMethodBeat.i(252077);
        p.h(str, "mediaId");
        com.tencent.mm.ac.d.c("FinderMediaCacheUpdateThread", new C1287d(str));
        AppMethodBeat.o(252077);
    }

    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(252069);
            int a2 = kotlin.b.a.a(Integer.valueOf(((at) t).field_fileFormat.hashCode()), Integer.valueOf(((at) t2).field_fileFormat.hashCode()));
            AppMethodBeat.o(252069);
            return a2;
        }
    }

    public static final class c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(252072);
            int a2 = kotlin.b.a.a(Integer.valueOf(((at) t).field_fileFormat.hashCode()), Integer.valueOf(((at) t2).field_fileFormat.hashCode()));
            AppMethodBeat.o(252072);
            return a2;
        }
    }

    public static boolean dH(String str, int i2) {
        AppMethodBeat.i(252078);
        p.h(str, "mediaId");
        w wVar = toc;
        at bv = bv(str, false);
        if (!bv.field_moovReady) {
            MediaPreloadCore.a aVar = MediaPreloadCore.uTV;
            if (MediaPreloadCore.a.a(bv).uTW) {
                bv.field_moovReady = true;
            }
            Log.i("Finder.MediaCacheLogic", "update moov ready " + bv.field_mediaId + " moovReady:" + bv.field_moovReady + " audio:" + bv.field_audioBitrate + " video:" + bv.field_videoBitrate + " frameRate:" + bv.field_frameRate);
        }
        bv.field_cacheSize = 0;
        bv.field_totalSize = 0;
        bv.field_state = i2;
        if (i2 >= 2) {
            String str2 = bv.field_fileFormat;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = bv.field_originMediaId;
                if (!(str3 == null || str3.length() == 0)) {
                    String str4 = bv.field_originMediaId;
                    p.g(str4, "this.field_originMediaId");
                    String str5 = bv.field_fileFormat;
                    p.g(str5, "this.field_fileFormat");
                    gV(str4, str5);
                }
            }
        }
        if (Log.getLogLevel() <= 1) {
            Log.d("Finder.MediaCacheLogic", "[updateProgress] mediaId=" + str + " cacheSize=0 totalSize=0 state=" + i2 + " moovReady=" + bv.field_moovReady);
        }
        boolean c2 = wVar.c(bv);
        AppMethodBeat.o(252078);
        return c2;
    }

    public static /* synthetic */ at avH(String str) {
        AppMethodBeat.i(252080);
        at bv = bv(str, false);
        AppMethodBeat.o(252080);
        return bv;
    }

    public static at bv(String str, boolean z) {
        boolean z2;
        at atVar;
        at atVar2;
        boolean z3;
        AppMethodBeat.i(252079);
        p.h(str, "mediaId");
        if (str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            at atVar3 = new at();
            atVar3.field_mediaId = str;
            AppMethodBeat.o(252079);
            return atVar3;
        }
        synchronized (vGP) {
            try {
                atVar = vGP.get(str);
            } finally {
                AppMethodBeat.o(252079);
            }
        }
        if (atVar == null) {
            atVar2 = toc.avt(str);
            synchronized (vGP) {
                try {
                    vGP.put(str, atVar2);
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(252079);
                    throw th;
                }
            }
        } else {
            atVar2 = atVar;
        }
        p.g(atVar2, "synchronized(memoryCache…        dbCache\n        }");
        if (z) {
            if (atVar2.getFilePath().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 && !s.YS(atVar2.getFilePath())) {
                atVar2.reset();
                atVar2.field_state = -2;
                d(atVar2);
                Log.i("Finder.MediaCacheLogic", "[query] mediaId=" + str + " not found file. state=" + atVar2.field_state + " filePath=" + atVar2.getFilePath());
            }
        }
        return atVar2;
    }

    public static List<at> avI(String str) {
        AppMethodBeat.i(252081);
        p.h(str, "originalMediaId");
        w wVar = toc;
        p.h(str, "originMediaId");
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = wVar.db.rawQuery("select *, rowid from FinderMediaCacheInfoV2  where originMediaId = '" + str + "' ", null);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            while (!rawQuery.isAfterLast()) {
                at atVar = new at();
                atVar.convertFrom(rawQuery);
                linkedList.add(atVar);
                rawQuery.moveToNext();
            }
            rawQuery.close();
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(252081);
        return linkedList2;
    }

    public static boolean a(String str, String str2, String str3, int i2, String str4, long j2, long j3, int i3, int i4, String str5, String str6) {
        AppMethodBeat.i(252082);
        p.h(str, "mediaId");
        p.h(str2, "originalMediaId");
        p.h(str3, "url");
        p.h(str4, "fileFormat");
        at atVar = new at();
        atVar.field_mediaId = str;
        atVar.field_originMediaId = str2;
        atVar.field_url = str3;
        atVar.field_reqFormat = i2;
        atVar.field_cacheSize = j2;
        atVar.field_totalSize = j3;
        atVar.field_fileFormat = str4;
        atVar.field_state = i3;
        atVar.field_duration = i4;
        atVar.field_urlToken = str5;
        atVar.field_decodeKey = str6;
        boolean d2 = d(atVar);
        AppMethodBeat.o(252082);
        return d2;
    }

    public static boolean bnU() {
        AppMethodBeat.i(252083);
        int delete = toc.db.delete(toc.getTableName(), "rowid >= ?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO});
        Log.i("Finder.MediaCacheLogic", "[deleteAll] ret=".concat(String.valueOf(delete)));
        synchronized (vGP) {
            try {
                vGP.clear();
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(252083);
                throw th;
            }
        }
        if (delete >= 0) {
            AppMethodBeat.o(252083);
            return true;
        }
        AppMethodBeat.o(252083);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0034 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void gV(java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 197
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.logic.d.gV(java.lang.String, java.lang.String):void");
    }

    public final com.tencent.mm.plugin.finder.loader.s b(long j2, cjl cjl) {
        Object obj;
        AppMethodBeat.i(252085);
        p.h(cjl, "media");
        if (vGQ) {
            com.tencent.mm.plugin.finder.loader.s c2 = c(j2, cjl);
            AppMethodBeat.o(252085);
            return c2;
        }
        String str = cjl.mediaId;
        if (str == null) {
            str = "";
        }
        Iterator it = j.a((Iterable) avI(str), (Comparator) new a()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object next = it.next();
            if (((at) next).dkO()) {
                obj = next;
                break;
            }
        }
        at atVar = (at) obj;
        if (atVar != null) {
            a.C1253a aVar = com.tencent.mm.plugin.finder.preload.model.a.uUH;
            com.tencent.mm.plugin.finder.loader.s sVar = new com.tencent.mm.plugin.finder.loader.s(cjl, a.C1253a.aus(atVar.field_fileFormat), atVar.field_reqFormat, null, 8);
            AppMethodBeat.o(252085);
            return sVar;
        }
        com.tencent.mm.plugin.finder.loader.s a2 = getPreloadModel().a(j2, cjl);
        AppMethodBeat.o(252085);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.plugin.finder.loader.s c(long r14, com.tencent.mm.protocal.protobuf.cjl r16) {
        /*
        // Method dump skipped, instructions count: 431
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.logic.d.c(long, com.tencent.mm.protocal.protobuf.cjl):com.tencent.mm.plugin.finder.loader.s");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.finder.storage.logic.d$d */
    public static final class C1287d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String qWs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1287d(String str) {
            super(0);
            this.qWs = str;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            at atVar;
            AppMethodBeat.i(252073);
            d dVar = d.vGR;
            synchronized (d.vGP) {
                try {
                    d dVar2 = d.vGR;
                    atVar = (at) d.vGP.get(this.qWs);
                } catch (Throwable th) {
                    AppMethodBeat.o(252073);
                    throw th;
                }
            }
            if (atVar != null) {
                Log.i("Finder.MediaCacheLogic", "syncMemoryCacheToDB doing " + this.qWs);
                d dVar3 = d.vGR;
                d.toc.c(atVar);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252073);
            return xVar;
        }
    }

    public static at a(String str, long j2, long j3, int i2) {
        AppMethodBeat.i(252075);
        p.h(str, "mediaId");
        at bv = bv(str, false);
        bv.field_cacheSize = j2;
        bv.field_totalSize = j3;
        bv.field_state = i2;
        if (!bv.field_moovReady) {
            MediaPreloadCore.a aVar = MediaPreloadCore.uTV;
            if (MediaPreloadCore.a.a(bv).uTW) {
                bv.field_moovReady = true;
            }
        }
        AppMethodBeat.o(252075);
        return bv;
    }

    static final class b extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a> {
        public static final b vGS = new b();

        static {
            AppMethodBeat.i(252071);
            AppMethodBeat.o(252071);
        }

        b() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.preload.model.a invoke() {
            AppMethodBeat.i(252070);
            com.tencent.mm.plugin.finder.preload.model.a mediaPreloadModel = ((PluginFinder) g.ah(PluginFinder.class)).getMediaPreloadModel();
            AppMethodBeat.o(252070);
            return mediaPreloadModel;
        }
    }

    public static at gU(String str, String str2) {
        AppMethodBeat.i(252076);
        p.h(str, "mediaId");
        p.h(str2, "fileFormat");
        at bv = bv(str, false);
        bv.field_moovReady = true;
        if (!p.j(bv.field_fileFormat, str2)) {
            bv.field_fileFormat = str2;
            if (TextUtils.isEmpty(str2)) {
                h.INSTANCE.n(1505, 251, 1);
            }
        }
        AppMethodBeat.o(252076);
        return bv;
    }
}
