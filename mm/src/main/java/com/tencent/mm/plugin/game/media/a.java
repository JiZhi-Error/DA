package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.b.p;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.plugin.game.b.b.g;
import com.tencent.mm.plugin.game.b.b.h;
import com.tencent.mm.plugin.game.b.b.m;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static long qVk = 0;
    private static a xAe;
    private static final String xzQ = (com.tencent.mm.plugin.game.commlib.util.b.b(b.a.PERMANENT) + "haowan/");
    private static final String xzR = (xzQ + "haowan_gallery_cache");
    private int gAZ;
    private Object lock = new Object();
    private int xAa;
    private boolean xAb;
    private d xAc = null;
    private int xAd = 0;
    private final HashMap<String, b> xzS = new HashMap<>();
    private h xzT;
    private LinkedList<e> xzU = new LinkedList<>();
    LinkedList<e> xzV = new LinkedList<>();
    LinkedList<e> xzW = new LinkedList<>();
    private boolean xzX = false;
    private String xzY = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getString("game_remote_ticket", null);
    private long xzZ = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getLong("game_local_ticket", 0);

    /* renamed from: com.tencent.mm.plugin.game.media.a$a  reason: collision with other inner class name */
    public interface AbstractC1400a {
        void c(LinkedList<e> linkedList, boolean z);
    }

    interface c {
        void aP(LinkedList<GalleryItem.MediaItem> linkedList);
    }

    static /* synthetic */ int e(a aVar) {
        AppMethodBeat.i(40934);
        int dUa = aVar.dUa();
        AppMethodBeat.o(40934);
        return dUa;
    }

    static {
        AppMethodBeat.i(40942);
        AppMethodBeat.o(40942);
    }

    public static void a(a aVar) {
        xAe = aVar;
    }

    public a() {
        AppMethodBeat.i(40913);
        dTY();
        AppMethodBeat.o(40913);
    }

    public final void y(JSONArray jSONArray) {
        AppMethodBeat.i(40914);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(40914);
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            b bVar = new b((byte) 0);
            bVar.appId = optJSONObject.optString("appId");
            bVar.appName = optJSONObject.optString("gameName");
            bVar.albumName = optJSONObject.optString("albumName");
            bVar.jXM = optJSONObject.optString("defaultTitle");
            this.xzS.put(bVar.albumName, bVar);
        }
        AppMethodBeat.o(40914);
    }

    private static void dTY() {
        AppMethodBeat.i(40915);
        o oVar = new o(xzQ);
        if (!oVar.exists() || !oVar.isDirectory()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(40915);
    }

    public final LinkedList<e> dTZ() {
        InputStream inputStream;
        AppMethodBeat.i(40917);
        try {
            o oVar = new o(xzR);
            inputStream = s.openRead(xzR);
            try {
                byte[] bArr = new byte[((int) oVar.length())];
                inputStream.read(bArr);
                f fVar = new f();
                fVar.parseFrom(bArr);
                safeClose(inputStream);
                this.xzU = fVar.xuQ;
                if (!Util.isNullOrNil(this.xzU)) {
                    Iterator<e> it = this.xzU.iterator();
                    while (it.hasNext()) {
                        e next = it.next();
                        if (!next.xuJ && !next.xuK) {
                            this.xzV.add(next);
                        }
                    }
                }
                LinkedList<e> linkedList = fVar.xuQ;
                AppMethodBeat.o(40917);
                return linkedList;
            } catch (Exception e2) {
                e = e2;
                Log.e("MicroMsg.GameHaowanDataCenter", "parseGlobalConfig: " + e.getMessage());
                safeClose(inputStream);
                AppMethodBeat.o(40917);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
            Log.e("MicroMsg.GameHaowanDataCenter", "parseGlobalConfig: " + e.getMessage());
            safeClose(inputStream);
            AppMethodBeat.o(40917);
            return null;
        }
    }

    private static void safeClose(Closeable closeable) {
        AppMethodBeat.i(40918);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                AppMethodBeat.o(40918);
                return;
            }
        }
        AppMethodBeat.o(40918);
    }

    private int dUa() {
        AppMethodBeat.i(40919);
        if (this.xzZ == 0) {
            AppMethodBeat.o(40919);
            return 0;
        }
        int b2 = j.dUp().b(dUb(), System.currentTimeMillis(), this.xzZ + 1);
        AppMethodBeat.o(40919);
        return b2;
    }

    private LinkedList<String> dUb() {
        AppMethodBeat.i(40920);
        LinkedList<String> linkedList = new LinkedList<>();
        for (b bVar : this.xzS.values()) {
            linkedList.add(bVar.albumName);
        }
        AppMethodBeat.o(40920);
        return linkedList;
    }

    public final void b(final AbstractC1400a aVar) {
        AppMethodBeat.i(40921);
        if (this.xzX) {
            Log.i("MicroMsg.GameHaowanDataCenter", "gettingDataFromNet, return");
            AppMethodBeat.o(40921);
            return;
        }
        Log.d("MicroMsg.GameHaowanDataCenter", "getDataFromNet");
        this.xzX = true;
        final g gVar = new g();
        gVar.offset = this.xzT != null ? this.xzT.xuR : 0;
        if (gVar.offset == 0) {
            gVar.xuD = this.xzY;
        }
        d.a aVar2 = new d.a();
        aVar2.uri = "/cgi-bin/mmgame-bin/getuservideolist";
        aVar2.funcId = 3549;
        aVar2.iLN = gVar;
        aVar2.iLO = new h();
        IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.game.media.a.AnonymousClass2 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                long currentTimeMillis;
                long j2;
                AppMethodBeat.i(40908);
                Log.i("MicroMsg.GameHaowanDataCenter", "errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (gVar.offset == 0) {
                    a.this.xzU.clear();
                    a.this.xzV.clear();
                }
                e eVar = !Util.isNullOrNil(a.this.xzU) ? (e) a.this.xzU.getLast() : null;
                if (eVar != null) {
                    currentTimeMillis = eVar.createTime - 1;
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                }
                if (i2 == 0 && i3 == 0) {
                    a.this.xzT = (h) dVar.iLL.iLR;
                    Log.d("MicroMsg.GameHaowanDataCenter", "new_count = %d", Integer.valueOf(a.this.xzT.pRQ));
                    LinkedList a2 = a.a(a.this.xzT);
                    if (gVar.offset == 0) {
                        a.this.xAa = a.this.xzT.pRQ + a.e(a.this);
                        a.this.gAZ = a.this.xzT.oKY + a.f(a.this);
                        a.azU(a.this.xzT.xuD);
                        a.GI(System.currentTimeMillis());
                    }
                    if (!a.this.xzT.qGh || Util.isNullOrNil(a.this.xzT.xuS)) {
                        j2 = 0;
                    } else {
                        j2 = a.this.xzT.xuS.getLast().xvg * 1000;
                    }
                    LinkedList a3 = a.a(a.this, currentTimeMillis, j2);
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(a2);
                    linkedList.addAll(a3);
                    a.a(a.this, linkedList);
                    a.this.xzW = linkedList;
                    a.this.xzV.addAll(linkedList);
                    a.c(a.this, linkedList);
                    a.g(a.this);
                    if (aVar != null) {
                        aVar.c(a.this.xzU, a.this.xzT.qGh);
                    }
                } else {
                    if (gVar.offset == 0) {
                        a.this.xAa = a.e(a.this);
                        a.this.gAZ = a.f(a.this);
                    }
                    LinkedList a4 = a.a(a.this, currentTimeMillis, 0);
                    a.this.xzW = a4;
                    a.this.xzV.addAll(a4);
                    a.c(a.this, a4);
                    a.g(a.this);
                    if (aVar != null) {
                        aVar.c(a.this.xzU, false);
                    }
                }
                a.this.xzX = false;
                AppMethodBeat.o(40908);
            }
        });
        AppMethodBeat.o(40921);
    }

    public final String dUc() {
        AppMethodBeat.i(40922);
        final IPCString iPCString = new IPCString();
        final int dUa = dUa();
        com.tencent.mm.plugin.game.b.b.a aVar = new com.tencent.mm.plugin.game.b.b.a();
        aVar.xuD = this.xzY;
        d.a aVar2 = new d.a();
        aVar2.uri = "/cgi-bin/mmgame-bin/checkuserifhasnewvideo";
        aVar2.funcId = 3911;
        aVar2.iLN = aVar;
        aVar2.iLO = new com.tencent.mm.plugin.game.b.b.b();
        IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.game.media.a.AnonymousClass3 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                AppMethodBeat.i(40909);
                Log.i("MicroMsg.GameHaowanDataCenter", "checkNewVideo errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.plugin.game.b.b.b bVar = (com.tencent.mm.plugin.game.b.b.b) dVar.iLL.iLR;
                    String nullAsNil = Util.nullAsNil(bVar.desc);
                    if (nullAsNil.contains("[count]")) {
                        int i4 = bVar.pRQ + dUa;
                        if (i4 > 0) {
                            iPCString.value = nullAsNil.replace("[count]", String.valueOf(i4));
                        }
                    } else {
                        iPCString.value = nullAsNil;
                    }
                }
                synchronized (a.this.lock) {
                    try {
                        a.this.lock.notifyAll();
                    } finally {
                        AppMethodBeat.o(40909);
                    }
                }
            }
        });
        synchronized (this.lock) {
            try {
                this.lock.wait();
            } catch (InterruptedException e2) {
                Log.printErrStackTrace("MicroMsg.GameHaowanDataCenter", e2, "", new Object[0]);
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(40922);
                throw th;
            }
        }
        String str = iPCString.value;
        AppMethodBeat.o(40922);
        return str;
    }

    public final boolean hasNext() {
        return this.xzT != null && this.xzT.qGh;
    }

    public static class d {
        public String type;

        public d(String str) {
            this.type = str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        String albumName;
        String appId;
        String appName;
        String jXM;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static void a(int i2, final c cVar) {
        AppMethodBeat.i(40924);
        com.tencent.mm.plugin.gallery.model.e.dQK().setQueryType(i2);
        com.tencent.mm.plugin.gallery.model.e.dQK().mcq = 15;
        com.tencent.mm.plugin.gallery.model.e.dQK().a(new i.c() {
            /* class com.tencent.mm.plugin.game.media.a.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.gallery.model.i.c
            public final void b(LinkedList<GalleryItem.MediaItem> linkedList, long j2, boolean z) {
                AppMethodBeat.i(40911);
                if (a.qVk == j2 && cVar != null) {
                    cVar.aP(linkedList);
                }
                AppMethodBeat.o(40911);
            }
        });
        qVk = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.e.dQK().ax("", qVk);
        AppMethodBeat.o(40924);
    }

    public static void Od(int i2) {
        AppMethodBeat.i(40925);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key"));
        mmkv.putInt("game_last_choose_gallery", i2);
        mmkv.apply();
        AppMethodBeat.o(40925);
    }

    public static int dUd() {
        AppMethodBeat.i(40926);
        int i2 = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getInt("game_last_choose_gallery", 0);
        AppMethodBeat.o(40926);
        return i2;
    }

    public static void dUe() {
        AppMethodBeat.i(40927);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key"));
        mmkv.putBoolean("game_tab_gallery_first_enter", false);
        mmkv.apply();
        AppMethodBeat.o(40927);
    }

    public static boolean dUf() {
        AppMethodBeat.i(40928);
        boolean z = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getBoolean("game_tab_gallery_first_enter", true);
        AppMethodBeat.o(40928);
        return z;
    }

    public static void dUg() {
        AppMethodBeat.i(40929);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key"));
        mmkv.putBoolean("game_publish_gallery_first_enter", false);
        mmkv.apply();
        AppMethodBeat.o(40929);
    }

    public static boolean dUh() {
        AppMethodBeat.i(40930);
        boolean z = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getBoolean("game_publish_gallery_first_enter", true);
        AppMethodBeat.o(40930);
        return z;
    }

    private static String UE(String str) {
        AppMethodBeat.i(40931);
        int azs = com.tencent.mm.kernel.a.azs();
        if (azs == 0) {
            AppMethodBeat.o(40931);
            return str;
        }
        String str2 = str + "_" + Oe(azs);
        AppMethodBeat.o(40931);
        return str2;
    }

    private static String Oe(int i2) {
        AppMethodBeat.i(40932);
        String pVar = new p(i2).toString();
        AppMethodBeat.o(40932);
        return pVar;
    }

    public static void a(final AbstractC1400a aVar) {
        AppMethodBeat.i(40912);
        if (xAe == null) {
            aVar.c(null, false);
            AppMethodBeat.o(40912);
            return;
        }
        xAe.b(new AbstractC1400a() {
            /* class com.tencent.mm.plugin.game.media.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.media.a.AbstractC1400a
            public final void c(LinkedList<e> linkedList, boolean z) {
                AppMethodBeat.i(40907);
                if (aVar != null) {
                    aVar.c(a.xAe.xzW, z);
                }
                AppMethodBeat.o(40907);
            }
        });
        AppMethodBeat.o(40912);
    }

    public final void destroy() {
        int i2;
        IOException e2;
        OutputStream outputStream;
        AppMethodBeat.i(40916);
        f fVar = new f();
        Iterator<e> it = this.xzU.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().xuK) {
                    i2 = this.xzU.indexOf(-1);
                    break;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        if (i2 > 0) {
            this.xzU.remove(i2);
        }
        fVar.xuQ = this.xzU;
        dTY();
        try {
            byte[] byteArray = fVar.toByteArray();
            outputStream = s.dw(xzR, false);
            try {
                outputStream.write(byteArray);
            } catch (IOException e3) {
                e2 = e3;
                Log.e("MicroMsg.GameHaowanDataCenter", "cacheData: " + e2.getMessage());
                safeClose(outputStream);
                xAe = null;
                AppMethodBeat.o(40916);
            }
        } catch (IOException e4) {
            e2 = e4;
            outputStream = null;
            Log.e("MicroMsg.GameHaowanDataCenter", "cacheData: " + e2.getMessage());
            safeClose(outputStream);
            xAe = null;
            AppMethodBeat.o(40916);
        }
        safeClose(outputStream);
        xAe = null;
        AppMethodBeat.o(40916);
    }

    static /* synthetic */ LinkedList a(h hVar) {
        AppMethodBeat.i(40933);
        LinkedList linkedList = new LinkedList();
        if (hVar == null || Util.isNullOrNil(hVar.xuS)) {
            AppMethodBeat.o(40933);
            return linkedList;
        }
        for (int i2 = 0; i2 < hVar.xuS.size(); i2++) {
            m mVar = hVar.xuS.get(i2);
            e eVar = new e();
            eVar.dLQ = false;
            eVar.videoUrl = mVar.xvi.iAz;
            eVar.xuM = mVar.xvi.jTB;
            eVar.title = mVar.xvi.title;
            eVar.createTime = mVar.xvg * 1000;
            if (mVar.xvk != null) {
                eVar.xuN = mVar.xvk.desc;
                eVar.xuP = mVar.xvk.xuG;
            }
            eVar.xuO = mVar.xvj;
            eVar.duration = (long) mVar.xvi.duration;
            eVar.psI = mVar.xvf;
            if (mVar.xvh != null) {
                eVar.appId = mVar.xvh.xuH;
                eVar.appName = mVar.xvh.xuI;
                eVar.appType = mVar.xvh.qGD;
            }
            linkedList.add(eVar);
        }
        AppMethodBeat.o(40933);
        return linkedList;
    }

    static /* synthetic */ int f(a aVar) {
        AppMethodBeat.i(40935);
        int b2 = j.dUp().b(aVar.dUb(), System.currentTimeMillis(), 0);
        AppMethodBeat.o(40935);
        return b2;
    }

    static /* synthetic */ void azU(String str) {
        AppMethodBeat.i(40936);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key"));
        mmkv.putString("game_remote_ticket", str);
        mmkv.apply();
        AppMethodBeat.o(40936);
    }

    static /* synthetic */ void GI(long j2) {
        AppMethodBeat.i(40937);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key"));
        mmkv.putLong("game_local_ticket", j2);
        mmkv.apply();
        AppMethodBeat.o(40937);
    }

    static /* synthetic */ LinkedList a(a aVar, long j2, long j3) {
        LinkedList linkedList;
        AppMethodBeat.i(40938);
        j dUp = j.dUp();
        LinkedList<String> dUb = aVar.dUb();
        LinkedList linkedList2 = new LinkedList();
        if (Util.isNullOrNil(dUb)) {
            linkedList = linkedList2;
        } else {
            Cursor query = dUp.hwt.query(j.dUq(), j.getProjection(), j.a(dUb, j2, j3), null, j.dUr());
            if (query == null) {
                linkedList = linkedList2;
            } else {
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    long j4 = Util.getLong(query.getString(1), 0);
                    long j5 = Util.getLong(query.getString(2), 0);
                    long j6 = Util.getLong(query.getString(3), 0);
                    String string2 = query.getString(4);
                    String string3 = query.getString(5);
                    String string4 = query.getString(6);
                    long j7 = Util.getLong(query.getString(7), 0);
                    String string5 = query.getString(8);
                    Log.i("MicroMsg.GameLocalVideoQuery", "mediaPath = %s, takenDate = %d, modifiedDate = %d, duration = %d, description = %s, mimeType = %s, title = %s, size = %d, bucketName = %s", string, Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), string2, string3, string4, Long.valueOf(j7), string5);
                    e eVar = new e();
                    eVar.dLQ = true;
                    eVar.createTime = j4;
                    eVar.videoUrl = string;
                    eVar.duration = j6;
                    eVar.size = j7;
                    eVar.albumName = string5;
                    linkedList2.add(eVar);
                }
                query.close();
                linkedList = linkedList2;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            e eVar2 = (e) it.next();
            eVar2.duration /= 1000;
            eVar2.xuN = String.format(Locale.CHINA, "%d:%02d", Long.valueOf(eVar2.duration / 60), Long.valueOf(eVar2.duration % 60));
            b bVar = aVar.xzS.get(eVar2.albumName);
            if (bVar != null) {
                eVar2.appId = bVar.appId;
                eVar2.appName = bVar.appName;
                eVar2.title = bVar.jXM;
            }
        }
        AppMethodBeat.o(40938);
        return linkedList;
    }

    static /* synthetic */ void a(a aVar, LinkedList linkedList) {
        AppMethodBeat.i(40939);
        Collections.sort(linkedList, new Comparator<e>() {
            /* class com.tencent.mm.plugin.game.media.a.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(e eVar, e eVar2) {
                AppMethodBeat.i(40910);
                int i2 = -Long.compare(eVar.createTime, eVar2.createTime);
                AppMethodBeat.o(40910);
                return i2;
            }
        });
        AppMethodBeat.o(40939);
    }

    static /* synthetic */ void c(a aVar, LinkedList linkedList) {
        d dVar;
        String str;
        AppMethodBeat.i(40940);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            long j2 = eVar.createTime;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(j2);
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
            int i2 = gregorianCalendar2.get(1);
            int i3 = gregorianCalendar2.get(2) + 1;
            int i4 = gregorianCalendar2.get(3);
            long timeInMillis = new GregorianCalendar(i2, gregorianCalendar2.get(2), gregorianCalendar2.get(5)).getTimeInMillis() - j2;
            if (timeInMillis <= 0) {
                dVar = new d("9");
            } else if (timeInMillis <= Util.MILLSECONDS_OF_DAY) {
                dVar = new d("8");
            } else {
                int i5 = gregorianCalendar.get(1);
                int i6 = gregorianCalendar.get(2) + 1;
                if (i5 == i2) {
                    if (gregorianCalendar.get(3) == i4) {
                        dVar = new d("7");
                    } else if (i6 == i3) {
                        dVar = new d("6");
                    }
                }
                if (i6 < 10) {
                    dVar = new d(String.valueOf(i5) + "_0" + String.valueOf(i6));
                } else {
                    dVar = new d(String.valueOf(i5) + "_" + String.valueOf(i6));
                }
            }
            if (aVar.xAc == null || !aVar.xAc.type.equals(dVar.type)) {
                e eVar2 = new e();
                eVar2.xuJ = true;
                String str2 = dVar.type;
                if (str2.equals("9")) {
                    str = MMApplicationContext.getResources().getString(R.string.dt_);
                } else if (str2.equals("8")) {
                    str = MMApplicationContext.getResources().getString(R.string.dtc);
                } else if (str2.equals("7")) {
                    str = MMApplicationContext.getResources().getString(R.string.dt8);
                } else if (str2.equals("6")) {
                    str = MMApplicationContext.getResources().getString(R.string.dt7);
                } else {
                    String[] split = str2.split("_");
                    if (split == null || split.length < 2) {
                        str = "";
                    } else {
                        String str3 = split[0];
                        String str4 = split[1];
                        if (str4.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            str4 = str4.substring(str4.indexOf(AppEventsConstants.EVENT_PARAM_VALUE_NO) + 1);
                        }
                        str = MMApplicationContext.getResources().getString(R.string.dt9, str3, str4);
                    }
                }
                eVar2.xuL = str;
                aVar.xzU.add(eVar2);
                aVar.xAd++;
            }
            aVar.xzU.add(eVar);
            aVar.xAc = dVar;
        }
        AppMethodBeat.o(40940);
    }

    static /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(40941);
        if (aVar.xAa > 0 && aVar.xAa < aVar.xzU.size() - aVar.xAd && !aVar.xAb) {
            e eVar = new e();
            eVar.xuK = true;
            int i2 = 0;
            int i3 = 0;
            while (i2 < aVar.xzU.size() && (aVar.xzU.get(i2).xuJ || (i3 = i3 + 1) < aVar.xAa)) {
                i2++;
            }
            aVar.xzU.add(i2 + 1, eVar);
            aVar.xAb = true;
        }
        AppMethodBeat.o(40941);
    }
}
