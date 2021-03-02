package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.i.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.g.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class an {

    public static class a implements i {
        private static int jrr = 0;
        private HashMap<Long, String> JWW = new HashMap<>();
        Queue<Long> dAA = new LinkedList();
        Queue<Long> dAB = new LinkedList();
        Map<Long, f.a> dAC = new HashMap();
        private boolean dAD = false;
        private boolean dAE = false;
        int dAF = 0;
        private long dAG = 0;
        f.a dAI = new f.a();
        private MTimerHandler dAJ = new MTimerHandler(bg.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.pluginsdk.model.app.an.a.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(31099);
                a.j(a.this);
                AppMethodBeat.o(31099);
                return false;
            }

            public final String toString() {
                AppMethodBeat.i(31100);
                String str = super.toString() + "|scenePusher";
                AppMethodBeat.o(31100);
                return str;
            }
        }, false);
        private boolean running = false;

        static /* synthetic */ int aYz() {
            int i2 = jrr;
            jrr = i2 + 1;
            return i2;
        }

        static /* synthetic */ int bhI() {
            int i2 = jrr;
            jrr = i2 - 1;
            return i2;
        }

        static /* synthetic */ int e(a aVar) {
            int i2 = aVar.dAF;
            aVar.dAF = i2 - 1;
            return i2;
        }

        static /* synthetic */ void k(a aVar) {
            AppMethodBeat.i(232170);
            aVar.aax();
            AppMethodBeat.o(232170);
        }

        public a() {
            AppMethodBeat.i(31101);
            bg.azz().a(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, this);
            bg.azz().a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this);
            bg.azz().a(TbsListener.ErrorCode.UNLZMA_FAIURE, this);
            AppMethodBeat.o(31101);
        }

        /* access modifiers changed from: protected */
        public final void finalize() {
            AppMethodBeat.i(31102);
            bg.azz().b(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, this);
            bg.azz().b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this);
            bg.azz().b(TbsListener.ErrorCode.UNLZMA_FAIURE, this);
            this.JWW.clear();
            super.finalize();
            AppMethodBeat.o(31102);
        }

        public final void P(long j2, String str) {
            AppMethodBeat.i(31103);
            this.JWW.put(Long.valueOf(j2), str);
            AppMethodBeat.o(31103);
        }

        public static void HR(long j2) {
            AppMethodBeat.i(31104);
            bg.azz().a(new ag(j2, null, null), 0);
            AppMethodBeat.o(31104);
        }

        public static void Q(long j2, String str) {
            AppMethodBeat.i(31105);
            bg.azz().a(new ag(j2, str, null), 0);
            AppMethodBeat.o(31105);
        }

        public static void f(long j2, String str, String str2) {
            AppMethodBeat.i(31106);
            bg.azz().a(new ag(j2, str, str2), 0);
            AppMethodBeat.o(31106);
        }

        public static void a(long j2, String str, int i2, a aVar) {
            AppMethodBeat.i(31107);
            bg.azz().a(new ag(j2, str, i2, aVar), 0);
            AppMethodBeat.o(31107);
        }

        private boolean bhF() {
            ArrayList<c> arrayList;
            AppMethodBeat.i(31108);
            try {
                Cursor rawQuery = ao.cgO().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
                if (rawQuery == null) {
                    arrayList = null;
                } else {
                    int count = rawQuery.getCount();
                    Log.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:".concat(String.valueOf(count)));
                    if (count == 0) {
                        rawQuery.close();
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (int i2 = 0; i2 < count; i2++) {
                            rawQuery.moveToPosition(i2);
                            c cVar = new c();
                            cVar.convertFrom(rawQuery);
                            arrayList.add(cVar);
                        }
                        rawQuery.close();
                    }
                }
            } catch (IllegalStateException e2) {
                Log.printErrStackTrace("MicroMsg.SceneAppMsg", e2, "", new Object[0]);
                d cgO = ao.cgO();
                cgO.db.execSQL("appattach", " update appattach set status = 198 , lastModifyTime = " + Util.nowSecond() + " where status = 101");
                cgO.doNotify();
                arrayList = null;
            }
            if (arrayList == null || arrayList.size() == 0) {
                AppMethodBeat.o(31108);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String formatUnixTime = Util.formatUnixTime(currentTimeMillis);
            for (c cVar2 : arrayList) {
                if (this.dAC.containsKey(Long.valueOf(cVar2.systemRowid))) {
                    Log.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + cVar2.systemRowid);
                } else {
                    Log.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + cVar2.field_fileFullPath + " status:" + cVar2.field_status + " create:(" + Util.formatUnixTime(cVar2.field_createTime) + "," + Util.formatUnixTime(cVar2.field_createTime / 1000) + ", last:" + Util.formatUnixTime(cVar2.field_lastModifyTime) + " now:" + Util.formatUnixTime(currentTimeMillis) + " " + (currentTimeMillis - cVar2.field_lastModifyTime));
                    if (cVar2.field_isUpload) {
                        if (currentTimeMillis - cVar2.field_lastModifyTime <= 600 || cVar2.field_status != 101) {
                            this.dAA.offer(Long.valueOf(cVar2.systemRowid));
                            this.dAC.put(Long.valueOf(cVar2.systemRowid), null);
                        } else {
                            Log.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + cVar2.field_fileFullPath + " last:" + Util.formatUnixTime(cVar2.field_lastModifyTime) + " now:" + formatUnixTime);
                            m.HS(cVar2.systemRowid);
                        }
                    }
                }
            }
            Log.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.dAC.size() + " [recv:" + this.dAB.size() + ",send:" + this.dAA.size() + "]");
            if (this.dAB.size() + this.dAA.size() == 0) {
                AppMethodBeat.o(31108);
                return false;
            }
            AppMethodBeat.o(31108);
            return true;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
            AppMethodBeat.i(31109);
            Log.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.pluginsdk.model.app.an.a.AnonymousClass2 */

                public final void run() {
                    long j2;
                    String str;
                    int i2;
                    boolean z = false;
                    AppMethodBeat.i(31095);
                    a.aYz();
                    if (qVar.getType() == 222) {
                        Log.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + i2 + " errCode:" + i3);
                        i2 = 0;
                        j2 = -1;
                    } else if (qVar.getType() == 221) {
                        a.this.dAD = false;
                        long j3 = ((com.tencent.mm.plugin.record.b.f) qVar).BGw;
                        i2 = ((com.tencent.mm.plugin.record.b.f) qVar).retCode;
                        j2 = j3;
                    } else if (qVar.getType() == 220) {
                        a.this.dAE = false;
                        j2 = ((aj) qVar).BGw;
                        int i3 = ((aj) qVar).retCode;
                        aj ajVar = (aj) qVar;
                        if (ajVar.BGu == null) {
                            str = null;
                        } else {
                            str = ajVar.BGu.field_mediaSvrId;
                        }
                        String str2 = (String) a.this.JWW.remove(Long.valueOf(((aj) qVar).gnc()));
                        if (!Util.isNullOrNil(((aj) qVar).iYT)) {
                            z = true;
                        }
                        if (!z && !((aj) qVar).JWN && !Util.isNullOrNil(str)) {
                            c cVar = new c();
                            ao.cgO().get(j2, cVar);
                            if (cVar.systemRowid == j2) {
                                m.a(cVar.field_msgInfoId, str, (d) null, true);
                                Log.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                                a.Q(cVar.field_msgInfoId, str2);
                            }
                        }
                        i2 = i3;
                    } else {
                        Log.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + qVar.getType());
                        a.bhI();
                        AppMethodBeat.o(31095);
                        return;
                    }
                    long j4 = 0;
                    if (!(j2 == -1 || a.this.dAC.get(Long.valueOf(j2)) == null)) {
                        j4 = a.this.dAC.get(Long.valueOf(j2)).apr();
                        a.this.dAC.remove(Long.valueOf(j2));
                    }
                    Log.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + qVar.getType() + " errtype:" + i2 + " errCode:" + i3 + " retCode:" + i2 + " rowid:" + j2 + " time:" + j4);
                    if (i2 != 0) {
                        a.e(a.this);
                    }
                    Log.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + a.jrr + " stop:" + a.this.dAF + " running:" + a.this.running + " recving:" + a.this.dAD + " sending:" + a.this.dAE);
                    if (a.this.dAF > 0) {
                        a.j(a.this);
                    } else if (!a.this.dAE && !a.this.dAD) {
                        a.k(a.this);
                    }
                    a.bhI();
                    AppMethodBeat.o(31095);
                }

                public final String toString() {
                    AppMethodBeat.i(31096);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.o(31096);
                    return str;
                }
            });
            AppMethodBeat.o(31109);
        }

        private void aax() {
            AppMethodBeat.i(31110);
            this.dAC.clear();
            this.dAA.clear();
            this.dAB.clear();
            this.dAE = false;
            this.dAD = false;
            this.running = false;
            Log.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.dAI.apr());
            AppMethodBeat.o(31110);
        }

        public final void run() {
            AppMethodBeat.i(31111);
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.pluginsdk.model.app.an.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(31097);
                    long currentTimeMillis = System.currentTimeMillis() - a.this.dAG;
                    Log.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + " sending:" + a.this.dAE + " recving:" + a.this.dAD);
                    if (a.this.running) {
                        if (currentTimeMillis < 180000) {
                            AppMethodBeat.o(31097);
                            return;
                        }
                        Log.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.this.dAE + " recving:" + a.this.dAD);
                    }
                    a.this.running = true;
                    a.this.dAE = false;
                    a.this.dAF = 4;
                    a.this.dAD = false;
                    a.this.dAI.gLm = SystemClock.elapsedRealtime();
                    a.this.dAJ.startTimer(10);
                    AppMethodBeat.o(31097);
                }

                public final String toString() {
                    AppMethodBeat.i(31098);
                    String str = super.toString() + "|run";
                    AppMethodBeat.o(31098);
                    return str;
                }
            });
            AppMethodBeat.o(31111);
        }

        static /* synthetic */ void j(a aVar) {
            String str;
            AppMethodBeat.i(31113);
            Log.d("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene recving[%b][%d], sending[%b][%d]", Boolean.valueOf(aVar.dAD), Integer.valueOf(aVar.dAB.size()), Boolean.valueOf(aVar.dAE), Integer.valueOf(aVar.dAA.size()));
            aVar.dAG = System.currentTimeMillis();
            if ((!aVar.dAD && aVar.dAB.size() == 0) || (!aVar.dAE && aVar.dAA.size() == 0)) {
                aVar.bhF();
            }
            if (aVar.dAD || aVar.dAB.size() != 0 || aVar.dAE || aVar.dAA.size() != 0) {
                if (!aVar.dAE && aVar.dAA.size() > 0) {
                    final long nullAs = Util.nullAs(aVar.dAA.poll(), -1);
                    Log.i("MicroMsg.SceneAppMsg", "summerbig Start Send :".concat(String.valueOf(nullAs)));
                    if (nullAs != -1) {
                        aVar.dAC.put(Long.valueOf(nullAs), new f.a());
                        aVar.dAE = true;
                        final c cVar = new c();
                        if (!ao.cgO().get(nullAs, cVar)) {
                            Log.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, getAttachInfo fail, infoId = ".concat(String.valueOf(nullAs)));
                            bg.aVF();
                            ca Hb = c.aSQ().Hb(cVar.field_msgInfoId);
                            Hb.setStatus(5);
                            bg.aVF();
                            c.aSQ().a(Hb.field_msgId, Hb);
                            aVar.dAE = false;
                            AppMethodBeat.o(31113);
                            return;
                        }
                        if (cVar.field_type == 8) {
                            bg.aVF();
                            ca Hb2 = c.aSQ().Hb(cVar.field_msgInfoId);
                            if (Hb2.field_msgId == 0) {
                                Log.e("MicroMsg.SceneAppMsg", "getEmoticonMd5 fail, msg is null :" + cVar.field_msgInfoId);
                                str = null;
                            } else {
                                k.b HD = k.b.HD(Hb2.field_content);
                                if (HD != null) {
                                    str = HD.iwK;
                                } else {
                                    str = be.bkr(Hb2.field_content).md5;
                                }
                            }
                            if (str == null) {
                                Log.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, send emoji, emoticonMd5 can not be null");
                                bg.aVF();
                                ca Hb3 = c.aSQ().Hb(cVar.field_msgInfoId);
                                Hb3.setStatus(5);
                                bg.aVF();
                                c.aSQ().a(Hb3.field_msgId, Hb3);
                                aVar.dAE = false;
                                AppMethodBeat.o(31113);
                                return;
                            }
                        } else {
                            str = null;
                        }
                        final String str2 = aVar.JWW.get(Long.valueOf(cVar.field_msgInfoId));
                        if (cVar.field_totalLen > 26214400) {
                            bg.aVF();
                            final ca Hb4 = c.aSQ().Hb(cVar.field_msgInfoId);
                            bg.azz().a(new com.tencent.mm.pluginsdk.g.c(k.b.HD(Util.processXml(Hb4.field_content)), cVar.field_fileFullPath, Hb4.field_talker, new c.a() {
                                /* class com.tencent.mm.pluginsdk.model.app.an.a.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.g.c.a
                                public final void a(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
                                    int Kp;
                                    AppMethodBeat.i(232169);
                                    if (Util.isNullOrNil(str4)) {
                                        Hb4.setStatus(5);
                                        bg.aVF();
                                        com.tencent.mm.model.c.aSQ().a(Hb4.field_msgId, Hb4);
                                        ca caVar = new ca();
                                        caVar.setCreateTime(bp.Kw(Hb4.field_talker));
                                        caVar.Cy(Hb4.field_talker);
                                        caVar.setContent(str);
                                        caVar.setType(10000);
                                        caVar.setStatus(6);
                                        caVar.nv(0);
                                        bg.aVF();
                                        com.tencent.mm.model.c.aSQ().aC(caVar);
                                        a.this.running = false;
                                        AppMethodBeat.o(232169);
                                        return;
                                    }
                                    cVar.field_signature = str4;
                                    cVar.field_fakeAeskey = str5;
                                    cVar.field_fakeSignature = str6;
                                    cVar.field_lastModifyTime = Util.nowMilliSecond();
                                    String str7 = Hb4.field_content;
                                    if (ab.Eq(Hb4.field_talker) && (Kp = bp.Kp(Hb4.field_content)) != -1) {
                                        str7 = (Hb4.field_content + " ").substring(Kp + 2).trim();
                                    }
                                    k.b HD = k.b.HD(Util.processXml(str7));
                                    if (HD != null) {
                                        HD.filemd5 = str2;
                                        HD.aesKey = str3;
                                        HD.iwI = (int) j2;
                                        bg.aVF();
                                        ca Hb = com.tencent.mm.model.c.aSQ().Hb(cVar.field_msgInfoId);
                                        Hb.setContent(k.b.a(HD, null, null));
                                        bg.aVF();
                                        com.tencent.mm.model.c.aSQ().a(Hb.field_msgId, Hb);
                                    }
                                    ao.cgO().a(cVar, new String[0]);
                                    bg.azz().a(new aj(nullAs, null, str2), 0);
                                    AppMethodBeat.o(232169);
                                }
                            }), 0);
                            AppMethodBeat.o(31113);
                            return;
                        }
                        bg.azz().a(new aj(nullAs, str, str2), 0);
                    }
                }
                AppMethodBeat.o(31113);
                return;
            }
            aVar.aax();
            Log.d("MicroMsg.SceneAppMsg", "summerbig No Data Any More , Stop Service");
            AppMethodBeat.o(31113);
        }
    }
}
