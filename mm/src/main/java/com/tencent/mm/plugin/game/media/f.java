package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.b.b.i;
import com.tencent.mm.plugin.game.b.b.j;
import com.tencent.mm.plugin.game.b.b.k;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.media.n;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class f implements d {
    private HashMap<String, n> xAr = new HashMap<>();

    public f() {
        AppMethodBeat.i(40957);
        AppMethodBeat.o(40957);
    }

    static /* synthetic */ void a(f fVar, String str, int i2, LinkedList linkedList, String str2, int i3) {
        AppMethodBeat.i(204111);
        fVar.a(str, i2, linkedList, str2, i3);
        AppMethodBeat.o(204111);
    }

    @Override // com.tencent.mm.plugin.game.api.d
    public final String azm(String str) {
        e eVar;
        AppMethodBeat.i(40959);
        g dSN = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN();
        String format = String.format("select * from %s where %s=\"%s\" and %s<>%d", "GameHaowanPublishEdition", "taskId", str, "publishState", 2);
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryWhenPublishNotSuccess, sql : %s", format);
        Cursor rawQuery = dSN.rawQuery(format, new String[0]);
        if (rawQuery == null) {
            eVar = null;
        } else {
            if (rawQuery.moveToNext()) {
                eVar = new e();
                eVar.convertFrom(rawQuery);
            } else {
                eVar = null;
            }
            rawQuery.close();
        }
        if (eVar == null) {
            AppMethodBeat.o(40959);
            return null;
        }
        String a2 = a(eVar.field_mediaType, eVar, eVar.field_compressImg);
        AppMethodBeat.o(40959);
        return a2;
    }

    @Override // com.tencent.mm.plugin.game.api.d
    public final JSONArray b(JSONArray jSONArray, boolean z) {
        AppMethodBeat.i(40960);
        JSONArray jSONArray2 = new JSONArray();
        if (z) {
            LinkedList<e> dUk = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().dUk();
            if (Util.isNullOrNil(dUk)) {
                AppMethodBeat.o(40960);
                return null;
            }
            Iterator<e> it = dUk.iterator();
            while (it.hasNext()) {
                e next = it.next();
                jSONArray2.put(new b(next.field_taskId, next.field_publishState, next.field_localIdList, next.field_BusinessData, next.field_createTime, next.field_mixState).toJson());
            }
            AppMethodBeat.o(40960);
            return jSONArray2;
        }
        LinkedList<String> A = c.A(jSONArray);
        if (Util.isNullOrNil(A)) {
            AppMethodBeat.o(40960);
            return null;
        }
        LinkedList<e> aS = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().aS(A);
        if (Util.isNullOrNil(aS)) {
            AppMethodBeat.o(40960);
            return null;
        }
        Iterator<e> it2 = aS.iterator();
        while (it2.hasNext()) {
            e next2 = it2.next();
            jSONArray2.put(new b(next2.field_taskId, next2.field_publishState, next2.field_localIdList, next2.field_BusinessData, next2.field_createTime, next2.field_mixState).toJson());
        }
        AppMethodBeat.o(40960);
        return jSONArray2;
    }

    @Override // com.tencent.mm.plugin.game.api.d
    public final void c(JSONArray jSONArray, boolean z) {
        LinkedList linkedList;
        AppMethodBeat.i(40961);
        if (z) {
            for (String str : this.xAr.keySet()) {
                this.xAr.get(str).dUz();
            }
            g dSN = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN();
            String format = String.format("select * from %s", "GameHaowanPublishEdition");
            Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAll, sql : %s", format);
            Cursor rawQuery = dSN.rawQuery(format, new String[0]);
            if (rawQuery == null) {
                linkedList = null;
            } else {
                linkedList = new LinkedList();
                while (rawQuery.moveToNext()) {
                    e eVar = new e();
                    eVar.convertFrom(rawQuery);
                    linkedList.add(eVar);
                }
                rawQuery.close();
            }
            if (Util.isNullOrNil(linkedList)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO().aR(c.aAL(((e) it.next()).field_localIdList));
                }
            }
            String format2 = String.format("delete from %s", "GameHaowanPublishEdition");
            Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "deleteAll, sql : %s", format2);
            dSN.execSQL("GameHaowanPublishEdition", format2);
            this.xAr.clear();
            a.ea("", 1);
            AppMethodBeat.o(40961);
            return;
        }
        LinkedList<String> A = c.A(jSONArray);
        if (Util.isNullOrNil(A)) {
            AppMethodBeat.o(40961);
            return;
        }
        Iterator<String> it2 = A.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            n remove = this.xAr.remove(next);
            if (remove != null) {
                remove.dUz();
            }
            a.ea(next, 1);
        }
        ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().aR(A);
        AppMethodBeat.o(40961);
    }

    private String a(final int i2, final e eVar, final boolean z) {
        AppMethodBeat.i(40962);
        if (Util.isNullOrNil(eVar.field_localIdList)) {
            a(eVar.field_taskId, eVar.field_publishSource, null, eVar.field_BusinessData, eVar.field_sourceSceneId);
        } else {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.f.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(40953);
                    if (!f.a(f.this, i2, eVar)) {
                        AppMethodBeat.o(40953);
                        return;
                    }
                    ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().ef(eVar.field_taskId, 2);
                    final LinkedList<String> aAL = c.aAL(eVar.field_localIdList);
                    n nVar = new n(eVar.field_taskId, i2, aAL, z);
                    nVar.xBP = new n.a() {
                        /* class com.tencent.mm.plugin.game.media.f.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.game.media.n.a
                        public final void pM(boolean z) {
                            AppMethodBeat.i(40952);
                            n nVar = (n) f.this.xAr.remove(eVar.field_taskId);
                            if (nVar != null) {
                                nVar.reset();
                            }
                            if (z) {
                                ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().eg(eVar.field_taskId, 2);
                                f.a(f.this, eVar.field_taskId, eVar.field_publishSource, aAL, eVar.field_BusinessData, eVar.field_sourceSceneId);
                                AppMethodBeat.o(40952);
                                return;
                            }
                            ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().eg(eVar.field_taskId, 1);
                            ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().azY(eVar.field_taskId);
                            f.ee(eVar.field_taskId, -1);
                            AppMethodBeat.o(40952);
                        }
                    };
                    nVar.dUx();
                    f.this.xAr.put(eVar.field_taskId, nVar);
                    AppMethodBeat.o(40953);
                }
            });
        }
        String str = eVar.field_taskId;
        AppMethodBeat.o(40962);
        return str;
    }

    private void azW(final String str) {
        AppMethodBeat.i(40963);
        ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().ef(str, 1);
        ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().azY(str);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.game.media.f.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(40954);
                f.ee(str, -2);
                AppMethodBeat.o(40954);
            }
        }, 2000);
        AppMethodBeat.o(40963);
    }

    private void a(final String str, final int i2, LinkedList<String> linkedList, String str2, final int i3) {
        String str3;
        Map<String, c> aQ;
        AppMethodBeat.i(204110);
        final d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/mmgame-bin/publishugctogamecenter";
        aVar.funcId = 2989;
        j jVar = new j();
        jVar.xub = i2;
        int i4 = 0;
        String str4 = null;
        int i5 = 0;
        long j2 = 0;
        if (Util.isNullOrNil(linkedList) || (aQ = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO().aQ(linkedList)) == null) {
            str3 = null;
        } else {
            jVar.xuZ = new LinkedList<>();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (aQ.containsKey(next)) {
                    c cVar = aQ.get(next);
                    i iVar = new i();
                    if (cVar.field_mediaType == 1) {
                        iVar.xuT = 1;
                        i4 = 1;
                    } else if (cVar.field_mediaType == 4) {
                        iVar.xuT = 2;
                        i4 = 2;
                        str4 = cVar.field_filePath;
                        i5 = cVar.field_duration;
                        j2 = cVar.field_size;
                    }
                    iVar.xuU = cVar.field_mediaUrl;
                    iVar.xuV = cVar.field_thumbPicUrl;
                    iVar.xuX = cVar.field_duration;
                    iVar.Width = cVar.field_width;
                    iVar.Height = cVar.field_height;
                    iVar.xui = cVar.field_size;
                    iVar.xuW = cVar.field_isGif;
                    iVar.xuY = cVar.field_editFlag;
                    jVar.xuZ.add(iVar);
                }
            }
            str3 = str4;
        }
        jVar.xva = str2;
        jVar.xvb = str;
        aVar.iLN = jVar;
        aVar.iLO = new k();
        final HashMap hashMap = new HashMap();
        hashMap.put("pushid", str);
        hashMap.put("type", Integer.valueOf(i4));
        if (str3 != null) {
            hashMap.put("videoid", str3);
            hashMap.put("origtime", Integer.valueOf(i5));
            hashMap.put("origsize", Long.valueOf(j2));
        }
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.game.media.f.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(40956);
                if (hashMap.containsKey("videoid")) {
                    hashMap.put("videoid", s.bhK((String) hashMap.get("videoid")));
                }
                final long currentTimeMillis = System.currentTimeMillis();
                IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                    /* class com.tencent.mm.plugin.game.media.f.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                    public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                        AppMethodBeat.i(40955);
                        Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        hashMap.put("costtime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        hashMap.put("topicid", Integer.valueOf(((k) dVar.iLL.iLR).xvc));
                        if (i2 == 0 && i3 == 0) {
                            g dSN = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN();
                            String str2 = str;
                            LinkedList<String> linkedList = new LinkedList<>();
                            linkedList.add(str2);
                            dSN.aR(linkedList);
                            f.ee(str, 0);
                            com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8765, 0, 48, i3, com.tencent.mm.game.report.b.a.c(i2, hashMap));
                            AppMethodBeat.o(40955);
                            return;
                        }
                        ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().azY(str);
                        f.ee(str, i3 > 0 ? -i3 : i3);
                        hashMap.put("failid", Integer.valueOf(i3));
                        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8765, 0, 56, i3, com.tencent.mm.game.report.b.a.c(i2, hashMap));
                        AppMethodBeat.o(40955);
                    }
                });
                AppMethodBeat.o(40956);
            }
        });
        AppMethodBeat.o(204110);
    }

    @Override // com.tencent.mm.plugin.game.api.d
    public final String a(int i2, int i3, JSONArray jSONArray, String str, boolean z, int i4) {
        AppMethodBeat.i(204109);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        g.aAf();
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(sb.append(com.tencent.mm.kernel.a.getUin()).append("_").append(System.currentTimeMillis()).toString().getBytes());
        LinkedList<String> A = c.A(jSONArray);
        e eVar = new e();
        eVar.field_taskId = messageDigest;
        eVar.field_createTime = System.currentTimeMillis() / 1000;
        eVar.field_publishSource = i2;
        eVar.field_mediaType = i3;
        eVar.field_localIdList = !Util.isNullOrNil(A) ? A.toString() : "";
        eVar.field_BusinessData = str;
        eVar.field_compressImg = z;
        eVar.field_sourceSceneId = i4;
        Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "addToDB: ".concat(String.valueOf(((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().insert(eVar))));
        String a2 = a(i3, eVar, z);
        AppMethodBeat.o(204109);
        return a2;
    }

    static /* synthetic */ boolean a(f fVar, int i2, e eVar) {
        WebViewJSSDKVideoItem hI;
        AppMethodBeat.i(40965);
        if (i2 == 2) {
            LinkedList<String> aAL = c.aAL(eVar.field_localIdList);
            if (!Util.isNullOrNil(aAL)) {
                String trim = aAL.get(0).trim();
                if (trim.startsWith("weixin://bgmixid/")) {
                    String replace = trim.replace("weixin://bgmixid/", "");
                    Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "background mix task, bgMixTaskId=%s", replace);
                    g dSN = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN();
                    String format = String.format("update %s set %s=\"%s\" where %s=\"%s\"", "GameHaowanPublishEdition", "bgMixTaskId", replace, "taskId", eVar.field_taskId);
                    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateBgMixTaskId, sql : %s", format);
                    dSN.execSQL("GameHaowanPublishEdition", format);
                    e eVar2 = e.BKp;
                    com.tencent.mm.plugin.recordvideo.background.c aLf = e.aLf(replace);
                    if (aLf != null) {
                        int i3 = aLf.field_status;
                        c.b bVar = c.b.BKk;
                        if (i3 == c.b.bTk()) {
                            boolean z = false;
                            ald eIK = aLf.eIK();
                            if (!(eIK == null || (hI = com.tencent.mm.plugin.game.media.background.a.hI(eIK.BOA, eIK.Lue)) == null)) {
                                eVar.field_localIdList = eVar.field_localIdList.replace(trim, hI.dJX);
                                g dSN2 = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN();
                                String format2 = String.format("update %s set %s=\"%s\" where %s=\"%s\"", "GameHaowanPublishEdition", "localIdList", eVar.field_localIdList, "taskId", eVar.field_taskId);
                                Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateLocalIds, sql : %s", format2);
                                dSN2.execSQL("GameHaowanPublishEdition", format2);
                                RecordMediaReportInfo recordMediaReportInfo = new RecordMediaReportInfo();
                                recordMediaReportInfo.aLq(aLf.field_reportInfo);
                                hI.jkf.putInt("mark_edit_flag", com.tencent.mm.plugin.game.media.background.a.c(recordMediaReportInfo));
                                if (((Boolean) recordMediaReportInfo.y("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.TRUE)).booleanValue()) {
                                    com.tencent.mm.plugin.game.media.background.a.aAb(eIK.BOA);
                                }
                                Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "background mix task is finished, start publish");
                                z = true;
                            }
                            if (!z) {
                                Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "background mix task is invalid");
                                fVar.azW(eVar.field_taskId);
                                AppMethodBeat.o(40965);
                                return false;
                            }
                        } else {
                            int i4 = aLf.field_status;
                            c.b bVar2 = c.b.BKk;
                            if (i4 == c.b.eIP()) {
                                Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "background mix task is fail");
                                fVar.azW(eVar.field_taskId);
                                AppMethodBeat.o(40965);
                                return false;
                            }
                            Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "background mix task is not finished");
                            AppMethodBeat.o(40965);
                            return false;
                        }
                    } else {
                        Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "background mix task is expired");
                        fVar.azW(eVar.field_taskId);
                        AppMethodBeat.o(40965);
                        return false;
                    }
                } else if (Util.isNullOrNil(eVar.field_bgMixTaskId)) {
                    Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "foreground mix task");
                } else {
                    Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "background mix bgMixTaskId:%s, retry haowan publish", eVar.field_bgMixTaskId);
                }
            }
        }
        AppMethodBeat.o(40965);
        return true;
    }

    static /* synthetic */ void ee(String str, int i2) {
        AppMethodBeat.i(40967);
        a.ea(str, i2);
        AppMethodBeat.o(40967);
    }
}
