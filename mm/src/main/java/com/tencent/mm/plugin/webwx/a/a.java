package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cd;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class a implements i, t.a {
    private static int JEZ = 1048576;
    private static int JFa = 26214400;
    private cc JFb = new cc();
    private HashMap<String, ca> JFc = new HashMap<>();

    public a() {
        AppMethodBeat.i(30159);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        byte[] aW = s.aW(sb.append(g.aAh().cachePath).append("syncmsgid.ini").toString(), 0, -1);
        if (!Util.isNullOrNil(aW)) {
            try {
                this.JFb.parseFrom(aW);
            } catch (Exception e2) {
                Log.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
            }
        }
        o.bhj().a(this, Looper.getMainLooper());
        g.azz().a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this);
        AppMethodBeat.o(30159);
    }

    public final void Mh(final long j2) {
        AppMethodBeat.i(30160);
        bg.aVF();
        if (!((Boolean) c.azQ().get(ar.a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            Log.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
            AppMethodBeat.o(30160);
            return;
        }
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.plugin.webwx.a.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(30155);
                a.a(a.this, j2);
                AppMethodBeat.o(30155);
            }
        });
        AppMethodBeat.o(30160);
    }

    public final void Mi(final long j2) {
        AppMethodBeat.i(30161);
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.plugin.webwx.a.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(30156);
                a.b(a.this, j2);
                AppMethodBeat.o(30156);
            }
        });
        AppMethodBeat.o(30161);
    }

    public final void gja() {
        AppMethodBeat.i(30162);
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.plugin.webwx.a.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(30157);
                a.a(a.this);
                AppMethodBeat.o(30157);
            }
        });
        AppMethodBeat.o(30162);
    }

    private void dpX() {
        AppMethodBeat.i(30163);
        try {
            byte[] byteArray = this.JFb.toByteArray();
            StringBuilder sb = new StringBuilder();
            g.aAi();
            s.f(sb.append(g.aAh().cachePath).append("syncmsgid.ini").toString(), byteArray, byteArray.length);
            AppMethodBeat.o(30163);
        } catch (IOException e2) {
            Log.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
            AppMethodBeat.o(30163);
        }
    }

    @Override // com.tencent.mm.modelvideo.t.a
    public final void a(t.a.C0460a aVar) {
        AppMethodBeat.i(30164);
        ca caVar = this.JFc.get(aVar.fileName);
        if (caVar == null) {
            AppMethodBeat.o(30164);
            return;
        }
        com.tencent.mm.modelvideo.s QN = u.QN(caVar.field_imgPath);
        if (QN == null) {
            AppMethodBeat.o(30164);
        } else if (caVar.gDB() || QN.status == 199) {
            Log.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", Long.valueOf(caVar.field_msgId), Integer.valueOf(QN.status));
            Mi(caVar.field_msgId);
            this.JFc.remove(caVar.field_imgPath);
            AppMethodBeat.o(30164);
        } else {
            if (caVar.field_status == 198) {
                this.JFc.remove(caVar.field_imgPath);
            }
            AppMethodBeat.o(30164);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(30165);
        if (i2 == 0 && i3 == 0 && (qVar instanceof f)) {
            long j2 = ((f) qVar).msgId;
            Mi(j2);
            Log.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", Long.valueOf(j2));
        }
        AppMethodBeat.o(30165);
    }

    static /* synthetic */ void a(a aVar, long j2) {
        AppMethodBeat.i(30166);
        cd cdVar = new cd();
        cdVar.msgId = j2;
        cdVar.addTime = Util.nowSecond();
        aVar.JFb.Oru.add(cdVar);
        aVar.dpX();
        aVar.gja();
        AppMethodBeat.o(30166);
    }

    static /* synthetic */ void b(a aVar, long j2) {
        AppMethodBeat.i(30167);
        for (int i2 = 0; i2 < aVar.JFb.Oru.size(); i2++) {
            cd cdVar = aVar.JFb.Oru.get(i2);
            if (cdVar.msgId == j2) {
                aVar.JFb.Oru.remove(cdVar);
                aVar.dpX();
                AppMethodBeat.o(30167);
                return;
            }
        }
        AppMethodBeat.o(30167);
    }

    static /* synthetic */ void a(a aVar) {
        boolean z;
        com.tencent.mm.pluginsdk.model.app.c s;
        AppMethodBeat.i(30168);
        for (int i2 = 0; i2 < aVar.JFb.Oru.size(); i2++) {
            cd cdVar = aVar.JFb.Oru.get(i2);
            if (Util.secondsToNow(cdVar.addTime) > 259200) {
                aVar.JFb.Oru.remove(cdVar);
                aVar.dpX();
                aVar.gja();
                AppMethodBeat.o(30168);
                return;
            } else if (cdVar.lDC == 0 || Util.secondsToNow(cdVar.lDC) >= 900) {
                bg.aVF();
                ca Hb = c.aSQ().Hb(cdVar.msgId);
                if (Hb.field_msgSvrId == 0 || Hb.gDB()) {
                    Log.i("MicroMsg.MultiTerminalSyncMgr", "msg not exit or cleaned, msgLocalId:%d", Long.valueOf(cdVar.msgId));
                    aVar.JFb.Oru.remove(cdVar);
                    aVar.dpX();
                    aVar.gja();
                    AppMethodBeat.o(30168);
                    return;
                }
                Log.i("MicroMsg.MultiTerminalSyncMgr", "statusNotify sendCommand DownloadFile user:%s, msgSvrId:%d, msgLocalId:%d, path:%s", Hb.field_talker, Long.valueOf(Hb.field_msgSvrId), Long.valueOf(Hb.field_msgId), Hb.field_imgPath);
                if (Hb.gAz()) {
                    com.tencent.mm.av.g G = com.tencent.mm.av.q.bcR().G(Hb.field_talker, Hb.field_msgSvrId);
                    Map<String, String> parseXml = XmlParser.parseXml(Hb.field_content, "msg", null);
                    int i3 = parseXml == null ? 0 : Util.getInt(parseXml.get(".msg.img.$length"), 0);
                    if (G.bcu() || i3 == 0 || i3 > JFa) {
                        z = true;
                    } else if (i3 <= JEZ || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                        Log.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload image, totalLen:%d", Integer.valueOf(i3));
                        com.tencent.mm.an.f.baQ().iRE.add("image_" + Hb.field_msgId);
                        com.tencent.mm.av.q.bcS().a(G.localId, Hb.field_msgId, 0, Long.valueOf(Hb.field_msgSvrId), R.drawable.bb1, new e.a() {
                            /* class com.tencent.mm.plugin.webwx.a.a.AnonymousClass4 */

                            @Override // com.tencent.mm.av.e.a
                            public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, q qVar) {
                            }

                            @Override // com.tencent.mm.av.e.a
                            public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, q qVar) {
                                AppMethodBeat.i(30158);
                                Log.i("MicroMsg.MultiTerminalSyncMgr", "download image msgid:%d, [%d,%d]", Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(i5));
                                if (i4 == 0 && i5 == 0) {
                                    a.this.Mi(j3);
                                }
                                AppMethodBeat.o(30158);
                            }

                            @Override // com.tencent.mm.av.e.a
                            public final void a(long j2, long j3, int i2, int i3, Object obj) {
                            }
                        });
                        z = true;
                    } else {
                        Log.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload image too big, totalLen:%d", Integer.valueOf(i3));
                        z = true;
                    }
                } else if (Hb.getType() == 43 || Hb.getType() == 44 || Hb.getType() == 62) {
                    com.tencent.mm.modelvideo.s QN = u.QN(Hb.field_imgPath);
                    if (QN == null) {
                        Log.e("MicroMsg.MultiTerminalSyncMgr", "autoDownload failed cause video info not found! The path is " + Hb.field_imgPath);
                        z = true;
                    } else {
                        int i4 = QN.iKP;
                        if (QN.status == 199 || i4 == 0 || i4 > JFa) {
                            z = true;
                        } else if (i4 <= JEZ || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                            Log.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload video, totalLen:%d", Integer.valueOf(i4));
                            aVar.JFc.put(Hb.field_imgPath, Hb);
                            u.QI(Hb.field_imgPath);
                            com.tencent.mm.an.f.baQ().iRE.add("video_" + Hb.field_msgId);
                            z = true;
                        } else {
                            Log.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload video too big, totalLen:%d", Integer.valueOf(i4));
                            z = true;
                        }
                    }
                } else if (Hb.dOQ()) {
                    k.b HD = k.b.HD(Hb.field_content);
                    if (HD == null || HD.type != 6) {
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(HD == null ? 0 : HD.type);
                        Log.i("MicroMsg.MultiTerminalSyncMgr", "appMsg not support, subType:%d", objArr);
                        z = true;
                    } else {
                        long j2 = (long) HD.iwI;
                        if (j2 > ((long) JFa)) {
                            z = true;
                        } else if (j2 <= ((long) JEZ) || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                            k.b HD2 = k.b.HD(Hb.field_content);
                            if (HD2 == null) {
                                Log.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", Hb.field_content);
                                s = null;
                            } else {
                                if (Util.isNullOrNil(HD2.dCK) && !Util.isNullOrNil(HD2.iwW)) {
                                    Log.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", Hb.field_content);
                                    HD2.dCK = new StringBuilder().append(HD2.iwW.hashCode()).toString();
                                }
                                String str = HD2.dCK;
                                s = m.s(str, Hb.field_msgId);
                                if (s == null) {
                                    m.e(str, Hb);
                                    s = m.s(str, Hb.field_msgId);
                                }
                            }
                            if (s == null) {
                                Log.i("MicroMsg.MultiTerminalSyncMgr", "attachInfo is null");
                                z = true;
                            } else if (s.deQ() || j2 == 0) {
                                z = true;
                            } else {
                                Log.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload attach, totalLen:%d", Long.valueOf(j2));
                                m.a(Hb, (m.a) null);
                                z = true;
                            }
                        } else {
                            Log.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload attach too big, totalLen:%d", Long.valueOf(j2));
                            z = true;
                        }
                    }
                } else {
                    Log.i("MicroMsg.MultiTerminalSyncMgr", "msgType not support:%d", Integer.valueOf(Hb.getType()));
                    z = true;
                }
                if (z) {
                    aVar.JFb.Oru.remove(cdVar);
                    aVar.dpX();
                } else {
                    cdVar.lDC = Util.nowSecond();
                    aVar.dpX();
                }
                aVar.gja();
                AppMethodBeat.o(30168);
                return;
            }
        }
        AppMethodBeat.o(30168);
    }
}
