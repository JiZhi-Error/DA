package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.b;
import com.tencent.mm.an.c;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static int jrr = 0;
    private boolean dAE = false;
    int dAF = 0;
    private f.a dAI = new f.a();
    private MTimerHandler dAJ = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.modelvideo.m.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(126901);
            m.h(m.this);
            AppMethodBeat.o(126901);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(126902);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(126902);
            return str;
        }
    }, false);
    private LinkedList<Long> jrm = new LinkedList<>();
    private Map<Long, f.a> jrn = new HashMap();
    private Map<Long, String> jro = new HashMap();
    private Object jrp = new Object();
    String jrq;
    private boolean running = false;

    public m() {
        AppMethodBeat.i(126906);
        AppMethodBeat.o(126906);
    }

    static /* synthetic */ int bhf() {
        int i2 = jrr;
        jrr = i2 + 1;
        return i2;
    }

    static /* synthetic */ int bhg() {
        int i2 = jrr;
        jrr = i2 - 1;
        return i2;
    }

    static /* synthetic */ void i(m mVar) {
        AppMethodBeat.i(126913);
        mVar.aax();
        AppMethodBeat.o(126913);
    }

    static /* synthetic */ int j(m mVar) {
        int i2 = mVar.dAF;
        mVar.dAF = i2 - 1;
        return i2;
    }

    public static void aG(List<s> list) {
        AppMethodBeat.i(126907);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(126907);
            return;
        }
        for (s sVar : list) {
            u.QE(sVar.getFileName());
        }
        AppMethodBeat.o(126907);
    }

    public static void aH(List<s> list) {
        AppMethodBeat.i(126908);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(126908);
            return;
        }
        for (s sVar : list) {
            u.QF(sVar.getFileName());
        }
        AppMethodBeat.o(126908);
    }

    private String AJ(long j2) {
        s sVar;
        AppMethodBeat.i(126909);
        List<s> AK = o.bhj().AK(j2);
        if (AK.isEmpty()) {
            Log.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
            AppMethodBeat.o(126909);
            return null;
        }
        for (s sVar2 : AK) {
            if (ab.JF(sVar2.getUser())) {
                Log.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", sVar2.getUser(), sVar2.jsv, Long.valueOf(j2));
                AppMethodBeat.o(126909);
                return null;
            }
            com.tencent.mm.an.f.baQ();
            if (!(b.sS(2) || sVar2.jss == 1)) {
                com.tencent.mm.an.f.baQ();
                Log.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", Boolean.valueOf(b.sS(2)), Integer.valueOf(sVar2.jss), sVar2.jsv, Long.valueOf(j2));
                AppMethodBeat.o(126909);
                return null;
            }
        }
        if (AK == null || AK.isEmpty()) {
            sVar = null;
        } else {
            int i2 = 0;
            while (true) {
                if (i2 >= AK.size()) {
                    sVar = null;
                    break;
                }
                s sVar3 = AK.get(i2);
                s QN = u.QN(sVar3.getFileName());
                if (QN != null) {
                    Log.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", sVar3.getFileName(), Integer.valueOf(i2), Integer.valueOf(AK.size()), Long.valueOf(j2), sVar3.jsv);
                    AK.remove(i2);
                    AK.add(i2, QN);
                    sVar = QN;
                    break;
                }
                Log.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", sVar3.getFileName(), Integer.valueOf(i2), Integer.valueOf(AK.size()), Long.valueOf(j2), sVar3.jsv);
                i2++;
            }
        }
        if (sVar == null) {
            Log.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
            AppMethodBeat.o(126909);
            return null;
        }
        String a2 = c.a("upvideo", sVar.createTime, sVar.jsv, sVar.getFileName());
        if (Util.isNullOrNil(a2)) {
            Log.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", sVar.getFileName(), Long.valueOf(sVar.jqz), sVar.jsv);
            AppMethodBeat.o(126909);
            return null;
        }
        String fileName = sVar.getFileName();
        o.bhj();
        String Qx = t.Qx(fileName);
        o.bhj();
        String Qw = t.Qw(fileName);
        a aVar = new a(this, (byte) 0);
        aVar.iHg = AK;
        aVar.jqz = j2;
        aVar.jru = a2;
        aVar.startTime = Util.nowMilliSecond();
        aVar.jqA = sVar;
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.taskName = "task_NetSceneUploadVideo_2";
        gVar.gqy = aVar;
        gVar.field_mediaId = a2;
        gVar.field_fullpath = Qw;
        gVar.field_thumbpath = Qx;
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        gVar.field_smallVideoFlag = 1;
        gVar.field_talker = sVar.jsv;
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        Map<String, String> parseXml = XmlParser.parseXml(sVar.bhv(), "msg", null);
        if (parseXml != null) {
            gVar.field_fileId = parseXml.get(".msg.videomsg.$cdnvideourl");
            gVar.field_aesKey = parseXml.get(".msg.videomsg.$aeskey");
        } else {
            Log.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
        }
        if (!com.tencent.mm.an.f.baQ().f(gVar)) {
            Log.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
            AppMethodBeat.o(126909);
            return null;
        }
        for (s sVar4 : AK) {
            if (sVar4.jss != 1) {
                sVar4.jss = 1;
                sVar4.cSx = 524288;
                Log.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", sVar4.getFileName(), Boolean.valueOf(u.f(sVar4)));
            }
        }
        AppMethodBeat.o(126909);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final class a implements i, g.a {
        List<s> iHg;
        s jqA;
        long jqz;
        String jru;
        long startTime;

        private a() {
        }

        /* synthetic */ a(m mVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            AppMethodBeat.i(126904);
            Log.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.jru, Integer.valueOf(i2), cVar, dVar);
            if (i2 == -21005) {
                Log.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.jru);
                AppMethodBeat.o(126904);
                return 0;
            } else if (i2 != 0) {
                m.aG(this.iHg);
                Log.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", Long.valueOf(this.jqz), Integer.valueOf(i2));
                new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 1, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), 0, "")).bfK();
                m.this.d(this.jqz, 3, i2);
                AppMethodBeat.o(126904);
                return 0;
            } else if (cVar != null) {
                Log.v("MicroMsg.SightMassSendService", "progress length %d", Long.valueOf(cVar.field_finishedLength));
                for (s sVar : this.iHg) {
                    sVar.jsm = Util.nowSecond();
                    sVar.jqP = (int) cVar.field_finishedLength;
                    sVar.cSx = 1032;
                    u.f(sVar);
                }
                AppMethodBeat.o(126904);
                return 0;
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        Log.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo, Long.valueOf(this.jqz));
                        m.aG(this.iHg);
                        String t = com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 1, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                        new y(t).bfK();
                        new w(t).bfK();
                        m.this.d(this.jqz, 3, dVar.field_retCode);
                    } else {
                        Log.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", Integer.valueOf(dVar.field_UploadHitCacheType), Long.valueOf(this.jqz));
                        String str2 = ((("<msg><videomsg aeskey=\"" + dVar.field_aesKey + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnvideourl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" ") + "length=\"" + dVar.field_fileLength + "\" ") + "cdnthumblength=\"" + dVar.field_thumbimgLength + "\"/></msg>";
                        Log.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", str2);
                        for (s sVar2 : this.iHg) {
                            if (Util.isNullOrNil(sVar2.bhv())) {
                                sVar2.jst = str2;
                                sVar2.cSx = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
                                Log.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", Long.valueOf(this.jqz), sVar2.getFileName(), Boolean.valueOf(u.f(sVar2)));
                            }
                        }
                        synchronized (m.this.jrp) {
                            try {
                                String str3 = (String) m.this.jro.get(Long.valueOf(this.jqz));
                                if (Util.isNullOrNil(str3)) {
                                    Log.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.jqz), str3, this.jru);
                                } else {
                                    Log.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.jqz), str3, this.jru);
                                    m.this.jro.put(Long.valueOf(this.jqz), "done_upload_cdn_client_id");
                                    com.tencent.mm.kernel.g.azz().a(245, this);
                                    if (!com.tencent.mm.kernel.g.azz().a(new e(this.jqz, this.jqA, dVar, this.jru), 0)) {
                                        Log.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
                                        com.tencent.mm.kernel.g.azz().b(245, this);
                                        m.this.d(this.jqz, 3, 0);
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(126904);
                                throw th;
                            }
                        }
                    }
                }
                AppMethodBeat.o(126904);
                return 0;
            }
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(126905);
            com.tencent.mm.kernel.g.azz().b(245, this);
            if (i2 == 4 && i3 == -22) {
                Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + " massSendId:" + this.jqz);
                m.aH(this.iHg);
                m.this.d(this.jqz, i2, i3);
                AppMethodBeat.o(126905);
            } else if (i2 == 4 && i3 != 0) {
                Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  massSendId:" + this.jqz);
                m.aG(this.iHg);
                m.this.d(this.jqz, i2, i3);
                AppMethodBeat.o(126905);
            } else if (i2 == 0 && i3 == 0) {
                for (s sVar : this.iHg) {
                    sVar.jsm = Util.nowSecond();
                    sVar.status = 199;
                    sVar.cSx = TAVExporter.VIDEO_EXPORT_HEIGHT;
                    if (u.f(sVar)) {
                        if (sVar == null) {
                            Log.e("MicroMsg.VideoLogic", "video info is null");
                        } else if (sVar.jso > 0) {
                            ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb((long) sVar.jso);
                            int type = Hb.getType();
                            Log.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", Integer.valueOf(type));
                            if (43 == type || 62 == type) {
                                Hb.nv(1);
                                Hb.Cy(sVar.getUser());
                                Hb.yF(sVar.dTS);
                                Hb.setStatus(2);
                                Hb.setContent(q.b(sVar.bhs(), (long) sVar.iFw, false));
                                ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a((long) sVar.jso, Hb);
                                Log.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", Long.valueOf(Hb.field_msgId));
                            }
                        } else {
                            ca caVar = new ca();
                            caVar.Cy(sVar.getUser());
                            caVar.setType(62);
                            caVar.nv(1);
                            caVar.Cz(sVar.getFileName());
                            caVar.setStatus(2);
                            caVar.setCreateTime(bp.Kw(sVar.getUser()));
                            sVar.jso = (int) bp.x(caVar);
                            sVar.cSx = 8192;
                            u.f(sVar);
                            Log.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", Long.valueOf(caVar.field_msgId));
                        }
                    }
                    Log.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", Long.valueOf(this.jqz), sVar.getFileName(), 199);
                }
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable(this.jqz) {
                    /* class com.tencent.mm.modelvideo.m.AnonymousClass1 */
                    final /* synthetic */ long jrs;

                    {
                        this.jrs = r2;
                    }

                    public final void run() {
                        long j2 = 0;
                        AppMethodBeat.i(126895);
                        m.bhf();
                        m.this.dAE = false;
                        m.this.jrq = "";
                        if (this.jrs > 0 && m.this.jrn.get(Long.valueOf(this.jrs)) != null) {
                            j2 = ((f.a) m.this.jrn.get(Long.valueOf(this.jrs))).apr();
                        }
                        Log.d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.jrs + " time:" + j2 + " inCnt:" + m.jrr + " stop:" + m.this.dAF + " running:" + m.this.running + " sending:" + m.this.dAE);
                        if (m.this.dAF > 0) {
                            m.h(m.this);
                        } else if (!m.this.dAE) {
                            m.i(m.this);
                        }
                        m.bhg();
                        AppMethodBeat.o(126895);
                    }

                    public final String toString() {
                        AppMethodBeat.i(126896);
                        String str = super.toString() + "|onSceneEnd";
                        AppMethodBeat.o(126896);
                        return str;
                    }
                });
                AppMethodBeat.o(126905);
            } else {
                Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  massSendId:" + this.jqz);
                m.aG(this.iHg);
                m.this.d(this.jqz, i2, i3);
                AppMethodBeat.o(126905);
            }
        }
    }

    public final void d(final long j2, final int i2, final int i3) {
        AppMethodBeat.i(126910);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelvideo.m.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(126897);
                m.bhf();
                m.this.dAE = false;
                m.this.jrq = "";
                long j2 = 0;
                if (j2 > 0 && m.this.jrn.get(Long.valueOf(j2)) != null) {
                    j2 = ((f.a) m.this.jrn.get(Long.valueOf(j2))).apr();
                }
                Log.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", Long.valueOf(j2), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
                if (!(i2 == 0 && i3 == 0)) {
                    m.j(m.this);
                }
                Log.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", Integer.valueOf(m.jrr), Integer.valueOf(m.this.dAF), Boolean.valueOf(m.this.running), Boolean.valueOf(m.this.dAE));
                if (m.this.dAF > 0) {
                    m.h(m.this);
                } else if (!m.this.dAE) {
                    Log.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
                    t bhj = o.bhj();
                    LinkedList linkedList = m.this.jrm;
                    if (linkedList != null && !linkedList.isEmpty()) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        StringBuilder sb = new StringBuilder();
                        sb.append('(');
                        for (int i2 = 0; i2 < linkedList.size() - 1; i2++) {
                            sb.append((Long) linkedList.get(i2));
                            sb.append(',');
                        }
                        Long l = (Long) linkedList.get(linkedList.size() - 1);
                        if (l != null) {
                            sb.append(l);
                        }
                        sb.append(')');
                        String str = "UPDATE videoinfo2 SET status=198, lastmodifytime=" + currentTimeMillis + " WHERE masssendid IN " + sb.toString();
                        Log.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", str);
                        bhj.iFy.execSQL("videoinfo2", str);
                    }
                    m.i(m.this);
                }
                m.bhg();
                AppMethodBeat.o(126897);
            }

            public final String toString() {
                AppMethodBeat.i(126898);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(126898);
                return str;
            }
        });
        AppMethodBeat.o(126910);
    }

    private void aax() {
        AppMethodBeat.i(126911);
        this.jro.clear();
        this.jrn.clear();
        this.jrm.clear();
        this.dAE = false;
        this.running = false;
        Log.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.dAI.apr());
        AppMethodBeat.o(126911);
    }

    static /* synthetic */ void h(m mVar) {
        AppMethodBeat.i(126912);
        if (!mVar.dAE && mVar.jrm.isEmpty()) {
            List<s> bhA = o.bhj().bhA();
            if (bhA.isEmpty()) {
                Log.d("MicroMsg.SightMassSendService", "unfinish massinfo count 0");
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (s sVar : bhA) {
                    if (mVar.jrn.containsKey(Long.valueOf(sVar.jqz))) {
                        Log.d("MicroMsg.SightMassSendService", "Mass Send File is Already running %s, massSendId %d", sVar.getFileName(), Long.valueOf(sVar.jqz));
                    } else {
                        Log.d("MicroMsg.SightMassSendService", "Get file:" + sVar.getFileName() + " status:" + sVar.status + " user" + sVar.getUser() + " human:" + sVar.bhs() + " massSendId:" + sVar.jqz + " massSendList:" + sVar.jsv + " create:" + Util.formatUnixTime(sVar.createTime) + " last:" + Util.formatUnixTime(sVar.jsm) + " now:" + Util.formatUnixTime(currentTimeMillis) + " " + (currentTimeMillis - sVar.jsm));
                        if (sVar.status == 200) {
                            mVar.jrm.offer(Long.valueOf(sVar.jqz));
                            mVar.jrn.put(Long.valueOf(sVar.jqz), null);
                        }
                    }
                }
                Log.d("MicroMsg.SightMassSendService", "GetNeedRun procing:" + mVar.jrn.size() + " [send:" + mVar.jrm.size() + "]");
                mVar.jrm.size();
            }
        }
        if (mVar.dAE || !mVar.jrm.isEmpty()) {
            if (!mVar.dAE && mVar.jrm.size() > 0) {
                Long poll = mVar.jrm.poll();
                Log.d("MicroMsg.SightMassSendService", "Start Mass Send, ID: %s", poll);
                if (poll != null) {
                    mVar.jrn.put(poll, new f.a());
                    mVar.dAE = true;
                    mVar.jrq = mVar.AJ(poll.longValue());
                    if (mVar.jrq == null) {
                        mVar.dAE = false;
                        mVar.dAJ.startTimer(10);
                        AppMethodBeat.o(126912);
                        return;
                    }
                    mVar.jro.put(poll, mVar.jrq);
                }
            }
            AppMethodBeat.o(126912);
            return;
        }
        mVar.aax();
        Log.d("MicroMsg.SightMassSendService", "No Data Any More , Stop Service");
        AppMethodBeat.o(126912);
    }
}
