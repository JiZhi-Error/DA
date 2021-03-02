package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class az implements f.a {
    IListener DMM;
    IListener DMN;
    bg DOh;
    LinkedList<bg> DOi;
    Map<String, bg> DOj;
    public LinkedList<SnsInfo> DOk;
    LinkedList<f> DOl;
    int DOm;
    private int DOn;
    IListener DOo;
    public boolean jre;
    public boolean jrf;

    public az() {
        AppMethodBeat.i(95974);
        this.DOi = null;
        this.DOj = null;
        this.DOk = null;
        this.DOl = new LinkedList<>();
        this.DOm = 3;
        this.DOn = 6;
        this.jre = false;
        this.jrf = false;
        this.DOo = new IListener<oq>() {
            /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass11 */

            {
                AppMethodBeat.i(160680);
                this.__eventId = oq.class.getName().hashCode();
                AppMethodBeat.o(160680);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(oq oqVar) {
                AppMethodBeat.i(95973);
                oq oqVar2 = oqVar;
                if (az.this.DOh != null && Util.isEqual(az.this.DOh.jpT, oqVar2.dUF.mediaId)) {
                    if (oqVar2.dUF.retCode != 0) {
                        az.this.fbQ();
                    } else if (oqVar2.dUF.dKy == 4 || oqVar2.dUF.dKy == 6) {
                        az.a(az.this);
                    }
                }
                AppMethodBeat.o(95973);
                return false;
            }
        };
        this.DMM = new IListener<e>() {
            /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass2 */

            {
                AppMethodBeat.i(160678);
                this.__eventId = e.class.getName().hashCode();
                AppMethodBeat.o(160678);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(e eVar) {
                AppMethodBeat.i(95964);
                e eVar2 = eVar;
                if ("SnsTimeLineUI".equals(eVar2.dBR.className)) {
                    az.this.jrf = eVar2.dBR.active;
                    Log.d("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", Boolean.valueOf(az.this.jrf));
                    if ((az.this.jrf && !a.fce()) || az.this.jre) {
                        az.this.fbN();
                    }
                    o.bhl().fP(az.this.jrf);
                }
                AppMethodBeat.o(95964);
                return false;
            }
        };
        this.DMN = new IListener<bg>() {
            /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass3 */

            {
                AppMethodBeat.i(160679);
                this.__eventId = bg.class.getName().hashCode();
                AppMethodBeat.o(160679);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(bg bgVar) {
                AppMethodBeat.i(95965);
                az.this.jre = bgVar.dEu.dEv;
                Log.d("MicroMsg.SnsVideoService", "set isInChatting:%b", Boolean.valueOf(az.this.jre));
                if ((az.this.jrf && !a.fce()) || az.this.jre) {
                    az.this.fbN();
                }
                if (!az.this.jre && !az.this.jrf) {
                    az.this.fbO();
                }
                i bhl = o.bhl();
                bhl.jre = az.this.jre;
                if (bhl.jre) {
                    bhl.stopDownload();
                } else {
                    bhl.startDownload();
                }
                AppMethodBeat.o(95965);
                return false;
            }
        };
        this.DOh = null;
        this.DOi = new LinkedList<>();
        this.DOj = new HashMap();
        this.DOk = new LinkedList<>();
        EventCenter.instance.addListener(this.DOo);
        EventCenter.instance.addListener(this.DMM);
        EventCenter.instance.addListener(this.DMN);
        AppMethodBeat.o(95974);
    }

    public final boolean G(SnsInfo snsInfo) {
        AppMethodBeat.i(95976);
        if (snsInfo == null) {
            Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD null snsInfo . [fail in queue]");
            AppMethodBeat.o(95976);
            return false;
        }
        this.DOm = a.fcg();
        this.DOn = a.fcf();
        synchronized (this.DOk) {
            try {
                if (this.DOk.size() < this.DOn || snsInfo.isAd()) {
                    this.DOk.add(snsInfo);
                    Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD hash(%d) sns:[%s] add preload video  [success in queue]", Integer.valueOf(hashCode()), snsInfo.getLocalid());
                    AppMethodBeat.o(95976);
                    return true;
                }
                Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] full stack .[fail in queue], and the sns info is not ad.", snsInfo.getLocalid());
                return false;
            } finally {
                AppMethodBeat.o(95976);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008d, code lost:
        if (G(r8) == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008f, code lost:
        fbO();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(176274);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(com.tencent.mm.plugin.sns.storage.SnsInfo r8) {
        /*
        // Method dump skipped, instructions count: 157
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.az.H(com.tencent.mm.plugin.sns.storage.SnsInfo):void");
    }

    public final void fbN() {
        AppMethodBeat.i(95977);
        Log.d("MicroMsg.SnsVideoService", "%d stop preload %s", Integer.valueOf(hashCode()), Util.getStack());
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(95966);
                synchronized (az.this.DOl) {
                    while (az.this.DOl.size() > 0) {
                        try {
                            az.this.DOl.poll().stop();
                        } finally {
                            AppMethodBeat.o(95966);
                        }
                    }
                }
            }
        });
        AppMethodBeat.o(95977);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void fbO() {
        AppMethodBeat.i(95978);
        Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD preload size:%d  queue size:%d", Integer.valueOf(this.DOl.size()), Integer.valueOf(this.DOk.size()));
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass5 */

            /* JADX WARNING: Code restructure failed: missing block: B:100:0x02b7, code lost:
                r17.value = false;
                r2 = true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:102:0x02c7, code lost:
                if (com.tencent.mm.sdk.platformtools.NetStatusUtil.is4G(com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()) == false) goto L_0x02d0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:103:0x02c9, code lost:
                r2 = r4.PreDownloadInfo.MIX & 2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:105:0x02d8, code lost:
                if (com.tencent.mm.sdk.platformtools.NetStatusUtil.is3G(com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()) == false) goto L_0x02e1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:106:0x02da, code lost:
                r2 = r4.PreDownloadInfo.MIX & 4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:107:0x02e1, code lost:
                r17.value = false;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:108:0x02e9, code lost:
                r17.value = false;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:109:0x02f1, code lost:
                r0 = r14.getTimeLine().ContentObj.LoV.get(0);
                r5 = r14.getLocalid();
                r6 = com.tencent.mm.plugin.sns.model.ay.a(r5, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:110:0x030e, code lost:
                if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r6) != false) goto L_0x0356;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:111:0x0310, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD sns:[%s] , video[%s] already download finish, do nothing.", r14.getLocalid(), r6);
                r4 = r0.MsS;
                r6 = com.tencent.mm.vfs.s.boW(r6);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:112:0x032e, code lost:
                if (r3.jrf == false) goto L_0x0354;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:113:0x0330, code lost:
                r5 = 4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:114:0x0331, code lost:
                com.tencent.mm.modelvideo.o.bhl().a(r4, r5, r6, r14.getUserName(), "", 0, "", r0.Url, r13);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 147, 1, false);
                r3 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:115:0x0354, code lost:
                r5 = 3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:116:0x0356, code lost:
                r3 = com.tencent.mm.vfs.s.boN(com.tencent.mm.plugin.sns.model.ay.aPr(r0.Id));
                r4 = com.tencent.mm.plugin.sns.model.ay.E(r0);
                r7 = com.tencent.mm.plugin.sns.model.ay.aPs(r5);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:117:0x036c, code lost:
                if (r14.isAd() == false) goto L_0x03da;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:118:0x036e, code lost:
                r2 = 100;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:119:0x0370, code lost:
                r18.value = r2;
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD sns:[%s]  duration:%f checkTimelinePreloadPercent [%d].", r14.getLocalid(), java.lang.Float.valueOf(r0.MsT), java.lang.Integer.valueOf(r18.value));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:120:0x039b, code lost:
                if (r7 == null) goto L_0x03e3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:121:0x039d, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "video info : %s", r7.toString());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:122:0x03b2, code lost:
                if (r7.iKP <= 0) goto L_0x03e3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:124:0x03bf, code lost:
                if (((r7.dRQ * 100) / r7.iKP) < r18.value) goto L_0x03e3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:125:0x03c1, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD sns:[%s] , video[%s] already preload finish, do nothing.", r14.getLocalid(), r6);
                r3 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:126:0x03da, code lost:
                r2 = com.tencent.mm.plugin.sns.model.b.a.a(r0, r18.value);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:127:0x03e3, code lost:
                if (r7 != null) goto L_0x0440;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:128:0x03e5, code lost:
                com.tencent.mm.plugin.sns.model.ay.fE(r5, 30);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:129:0x03ea, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD sns:[%s] preload stream download sns video %s mkDir %b", r14.getLocalid(), r4, java.lang.Boolean.valueOf(r3));
                r3 = new com.tencent.mm.plugin.sns.model.a.a(r0.Id);
                r3.DIq = r0;
                r2 = com.tencent.mm.storage.bp.gCZ();
                r2.hXs = r14.getCreateTime();
                r3.DPp = r2;
                r3.DPn = true;
                r3.url = r0.Url;
                r3.DPm = false;
                com.tencent.mm.modelvideo.n.bhh();
                com.tencent.mm.modelvideo.o.bhk();
                r3 = com.tencent.mm.an.e.a(r3.DPp, r3.url, r4, com.tencent.mm.plugin.sns.model.ay.Qv(r5), 2, r0.isAd);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:130:0x043b, code lost:
                if (r3 != null) goto L_0x044f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:131:0x043d, code lost:
                r3 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:132:0x0440, code lost:
                com.tencent.mm.plugin.sns.model.ay.c(r7, 30);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:133:0x0446, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:135:0x0448, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(95967);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:136:0x044e, code lost:
                throw r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:137:0x044f, code lost:
                r3.djw = r0.MsS;
                r3.field_preloadRatio = r18.value;
                r3.dRS = r13;
                r2 = r14.getUserName();
                r3.gqV = r2;
                r3.dRL = r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:138:0x0465, code lost:
                r14 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:139:0x046a, code lost:
                r2 = r16;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:140:0x046c, code lost:
                monitor-exit(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:141:0x046d, code lost:
                if (r14 != null) goto L_0x0480;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:142:0x046f, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD current preload list null");
                com.tencent.matrix.trace.core.AppMethodBeat.o(95967);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:143:0x0480, code lost:
                if (r3 != null) goto L_0x0499;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:144:0x0482, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD sns:[%s] null task . [fail to preload]", r2);
                com.tencent.matrix.trace.core.AppMethodBeat.o(95967);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
                r2 = new com.tencent.mm.modelvideo.f(r3, r14.getLocalid());
                r2.jqK = r22.DOp.jrf;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:147:0x04b2, code lost:
                if (r2.a(r22.DOp) >= 0) goto L_0x0547;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:148:0x04b4, code lost:
                com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD curr preload task do scene error. hash:[%d ]", java.lang.Integer.valueOf(r22.DOp.hashCode()));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:149:0x04cf, code lost:
                r3 = r22.DOp.DOk;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:150:0x04d5, code lost:
                monitor-enter(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
                r4 = r22.DOp.DOk.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:155:0x04e4, code lost:
                if (r4.hasNext() == false) goto L_0x0586;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:156:0x04e6, code lost:
                r2 = r4.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:157:0x04ec, code lost:
                if (r2 == null) goto L_0x04e0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:159:0x04fa, code lost:
                if (com.tencent.mm.sdk.platformtools.Util.isEqual(r2.getLocalid(), r14.getLocalid()) == false) goto L_0x04e0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:160:0x04fc, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD find sns info[%s], remove now. hash:[%d ]", r14.getLocalid(), java.lang.Integer.valueOf(r22.DOp.hashCode()));
                r4.remove();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:161:0x0522, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:163:0x0524, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(95967);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:164:0x052a, code lost:
                throw r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:165:0x052b, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:166:0x052c, code lost:
                com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.SnsVideoService", r2, "", new java.lang.Object[0]);
                r22.DOp.fbO();
                com.tencent.matrix.trace.core.AppMethodBeat.o(95967);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:167:0x0547, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD sns:[%s] start to preload , pPreloadPercent:%d  [success to preload]", r2.dHp, java.lang.Integer.valueOf(r18.value));
                r2.jqJ = java.lang.System.currentTimeMillis();
                r3 = r22.DOp.DOl;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:168:0x056f, code lost:
                monitor-enter(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
                r22.DOp.DOl.add(0, r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:172:0x057a, code lost:
                monitor-exit(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:174:0x057d, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:176:0x057f, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(95967);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:177:0x0585, code lost:
                throw r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:178:0x0586, code lost:
                monitor-exit(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
                if (r22.DOp.jre != false) goto L_0x006a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:180:0x058f, code lost:
                r15 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:195:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:196:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:197:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:198:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
                if (r22.DOp.jrf == false) goto L_0x058f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
                if (com.tencent.mm.plugin.sns.model.b.a.fce() != false) goto L_0x058f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD isInChatting:%b, x-config enable preload:%b . [fail to preload]", java.lang.Boolean.valueOf(r22.DOp.jre), java.lang.Boolean.valueOf(com.tencent.mm.plugin.sns.model.b.a.fce()));
                r15 = true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
                r14 = null;
                r3 = null;
                r17 = new com.tencent.mm.pointers.PBool();
                r18 = new com.tencent.mm.pointers.PInt();
                r19 = new com.tencent.mm.pointers.PString();
                r16 = "";
                r0 = r22.DOp.DOk;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ac, code lost:
                monitor-enter(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
                r21 = r22.DOp.DOk.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b9, code lost:
                r2 = r16;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bd, code lost:
                if (r21.hasNext() == false) goto L_0x046c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bf, code lost:
                r14 = r21.next();
                r16 = r14.getLocalid();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cf, code lost:
                if (r14.isAd() != false) goto L_0x00e9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d1, code lost:
                if (r15 == false) goto L_0x00e9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d3, code lost:
                r14 = null;
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD: the sns info is not ad and preload is disable!");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ef, code lost:
                if (r22.DOp.jrf == false) goto L_0x01be;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f1, code lost:
                r2 = r22.DOp;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f5, code lost:
                if (r14 != null) goto L_0x0131;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f7, code lost:
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x0101, code lost:
                if (r17.value == false) goto L_0x0106;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x0103, code lost:
                r21.remove();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x0106, code lost:
                if (r2 == false) goto L_0x0465;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x0108, code lost:
                r3 = r22.DOp;
                r13 = r19.value;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x0110, code lost:
                if (r14 == null) goto L_0x0128;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x0118, code lost:
                if (r14.getTimeLine().ContentObj == null) goto L_0x0128;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x0126, code lost:
                if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r14.getTimeLine().ContentObj.LoV) == false) goto L_0x02f1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x0128, code lost:
                r3 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x0129, code lost:
                if (r3 != null) goto L_0x046a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x012b, code lost:
                r21.remove();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x0135, code lost:
                if (r14.isAd() != false) goto L_0x01b6;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x0140, code lost:
                if (com.tencent.mm.modelvideo.o.bhl().fR(false) == false) goto L_0x0149;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:0x0142, code lost:
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:62:0x0149, code lost:
                r4 = com.tencent.mm.plugin.sns.model.an.B(r14);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:63:0x014d, code lost:
                if (r4 == null) goto L_0x0153;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:0x0151, code lost:
                if (r4.PreDownloadInfo != null) goto L_0x0163;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:0x0153, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:67:0x0163, code lost:
                r5 = com.tencent.mm.plugin.sns.model.b.a.fch();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:68:0x0167, code lost:
                if (r5 > 0) goto L_0x0188;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", java.lang.Integer.valueOf(r2.hashCode()));
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:70:0x0188, code lost:
                r19.value = new java.lang.StringBuilder().append(r4.Id).toString();
                r18.value = r5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a3, code lost:
                if (com.tencent.mm.plugin.sns.model.b.a.fce() != false) goto L_0x01b6;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:72:0x01a5, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD enableTimelinePreload [false]");
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:73:0x01b6, code lost:
                r17.value = false;
                r2 = true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:74:0x01be, code lost:
                r2 = r22.DOp;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:75:0x01c2, code lost:
                if (r14 != null) goto L_0x01cc;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:76:0x01c4, code lost:
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:78:0x01d0, code lost:
                if (r14.isAd() == false) goto L_0x01da;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:79:0x01d2, code lost:
                r17.value = false;
                r2 = true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e8, code lost:
                if (com.tencent.mm.sdk.platformtools.Util.secondsToNow((long) r14.getCreateTime()) < 86400) goto L_0x01f2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:82:0x01ea, code lost:
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:84:0x01fb, code lost:
                if (com.tencent.mm.modelvideo.o.bhl().fR(false) == false) goto L_0x0205;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:85:0x01fd, code lost:
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:86:0x0205, code lost:
                r4 = com.tencent.mm.plugin.sns.model.an.B(r14);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:87:0x0209, code lost:
                if (r4 == null) goto L_0x020f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:89:0x020d, code lost:
                if (r4.PreDownloadInfo != null) goto L_0x0220;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:90:0x020f, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:91:0x0220, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "%d check sns video[%s] preload [%d %d %s]", java.lang.Integer.valueOf(r2.hashCode()), r14.getLocalid(), java.lang.Integer.valueOf(r4.PreDownloadInfo.MIW), java.lang.Integer.valueOf(r4.PreDownloadInfo.MIX), r4.PreDownloadInfo.MIY);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:92:0x025f, code lost:
                if (r4.PreDownloadInfo.MIW > 0) goto L_0x0280;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:93:0x0261, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", java.lang.Integer.valueOf(r2.hashCode()));
                r17.value = true;
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:94:0x0280, code lost:
                r19.value = new java.lang.StringBuilder().append(r4.Id).toString();
                r18.value = r4.PreDownloadInfo.MIW;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:95:0x02a3, code lost:
                if (com.tencent.mm.modelcontrol.b.Of(r4.PreDownloadInfo.MIY) != false) goto L_0x02e9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:97:0x02ad, code lost:
                if (com.tencent.mm.sdk.platformtools.NetStatusUtil.isWifi(com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()) == false) goto L_0x02bf;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:98:0x02af, code lost:
                r2 = r4.PreDownloadInfo.MIX & 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:99:0x02b5, code lost:
                if (r2 <= 0) goto L_0x02e9;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 1426
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.az.AnonymousClass5.run():void");
            }
        });
        AppMethodBeat.o(95978);
    }

    @Override // com.tencent.mm.modelvideo.f.a
    public final void a(f fVar, boolean z, int i2, int i3) {
        final f fVar2;
        AppMethodBeat.i(95979);
        if (fVar == null) {
            Log.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            AppMethodBeat.o(95979);
            return;
        }
        synchronized (this.DOl) {
            try {
                Iterator<f> it = this.DOl.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (fVar == it.next()) {
                            fVar2 = fVar;
                            break;
                        }
                    } else {
                        fVar2 = null;
                        break;
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(95979);
                throw th;
            }
        }
        if (fVar2 == null) {
            Log.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
            AppMethodBeat.o(95979);
            return;
        }
        s aPs = ay.aPs(fVar.dHp);
        if (aPs != null) {
            aPs.iKP = i3;
            u.f(aPs);
        }
        Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_DONE  preload video[%s] finish success[%b] range[%d, %d]  hash:[%d]", fVar.bha(), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(hashCode()));
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(95968);
                a.YO(1);
                o.bhl().fQ(false);
                fVar2.jqL = null;
                synchronized (az.this.DOl) {
                    try {
                        az.this.DOl.remove(fVar2);
                    } catch (Throwable th) {
                        AppMethodBeat.o(95968);
                        throw th;
                    }
                }
                az.this.fbP();
                az.this.fbO();
                AppMethodBeat.o(95968);
            }
        });
        AppMethodBeat.o(95979);
    }

    /* access modifiers changed from: package-private */
    public final boolean fbP() {
        int i2;
        int i3;
        AppMethodBeat.i(95980);
        long currentTicks = Util.currentTicks();
        long nowSecond = Util.nowSecond() - (((long) a.fck()) * 86400);
        Log.i("MicroMsg.SnsVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d]", Integer.valueOf(hashCode()), 1, 130, Long.valueOf(nowSecond));
        List<s> e2 = o.bhj().e(130, 1, nowSecond);
        if (e2.isEmpty()) {
            AppMethodBeat.o(95980);
            return false;
        }
        int i4 = 0;
        for (s sVar : e2) {
            if (sVar != null) {
                try {
                    SnsInfo aQm = aj.faO().aQm(ay.aPq(sVar.getFileName()));
                    if (!(aQm == null || aQm.getTimeLine().ContentObj == null || Util.isNullOrNil(aQm.getTimeLine().ContentObj.LoV))) {
                        String E = ay.E(aQm.getTimeLine().ContentObj.LoV.get(0));
                        if (!Util.isNullOrNil(E)) {
                            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(E);
                            if (oVar.exists()) {
                                long length = oVar.length();
                                Log.i("MicroMsg.SnsVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", sVar.getFileName(), Long.valueOf(length), Integer.valueOf(sVar.dRQ), Long.valueOf(sVar.jsm), E);
                                if (length > 0 && length <= ((long) sVar.dRQ)) {
                                    oVar.delete();
                                    i3 = i4 + 1;
                                    sVar.dRQ = 0;
                                    sVar.cSx = 1;
                                    u.f(sVar);
                                    i4 = i3;
                                }
                            }
                        }
                        i3 = i4;
                        try {
                            sVar.dRQ = 0;
                            sVar.cSx = 1;
                            u.f(sVar);
                            i4 = i3;
                        } catch (Exception e3) {
                            i2 = i3;
                            i4 = i2;
                        }
                    }
                } catch (Exception e4) {
                    i2 = i4;
                    i4 = i2;
                }
            }
        }
        h.INSTANCE.idkeyStat(354, 145, (long) i4, false);
        Log.i("MicroMsg.SnsVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(e2.size()), Integer.valueOf(i4), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(95980);
        return false;
    }

    public final boolean a(cnb cnb, int i2, String str, boolean z, final boolean z2, int i3) {
        AppMethodBeat.i(95981);
        if (cnb.Mcw == 2) {
            Log.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
            AppMethodBeat.o(95981);
            return false;
        } else if (!((b) g.af(b.class)).a(b.a.clicfg_timeline_jump_downloading_task, true) || this.DOh == null || TextUtils.isEmpty(this.DOh.dHp) || !this.DOh.dHp.equals(str)) {
            final bg bgVar = new bg();
            bgVar.jpT = ay.cs(i2, cnb.Url);
            bgVar.ebR = cnb;
            bgVar.iXu = i2;
            bgVar.dHp = str;
            bgVar.gqU = z ? 1 : 0;
            bgVar.gqW = i3;
            g.aAi();
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(95970);
                    SnsInfo aQm = aj.faO().aQm(bgVar.dHp);
                    bgVar.DPl = aQm != null ? aQm.getUserName() : "";
                    Log.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", Boolean.valueOf(z2), bgVar);
                    if (z2) {
                        az.this.DOi.offerFirst(bgVar);
                    } else {
                        az.this.DOi.offerLast(bgVar);
                    }
                    az.this.DOj.put(bgVar.jpT, bgVar);
                    AppMethodBeat.o(95970);
                }
            });
            if (z2) {
                fbQ();
            }
            AppMethodBeat.o(95981);
            return true;
        } else {
            Log.e("MicroMsg.SnsVideoService", "[%s]task is downloading now.", str);
            AppMethodBeat.o(95981);
            return true;
        }
    }

    public final boolean q(final String str, final Object[] objArr) {
        AppMethodBeat.i(95982);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(95982);
            return false;
        }
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(95969);
                o.bhk().m(str, objArr);
                if (az.this.DOh != null && Util.isEqual(az.this.DOh.jpT, str)) {
                    az.a(az.this);
                }
                az.this.DOi.remove(az.this.DOj.get(str));
                AppMethodBeat.o(95969);
            }
        });
        AppMethodBeat.o(95982);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void fbQ() {
        AppMethodBeat.i(95983);
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass9 */

            public final void run() {
                boolean z = false;
                AppMethodBeat.i(95971);
                if (az.this.DOi.isEmpty()) {
                    Log.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
                    az.b(az.this);
                    AppMethodBeat.o(95971);
                    return;
                }
                bg poll = az.this.DOi.poll();
                if (poll == null) {
                    Log.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", Integer.valueOf(az.this.DOi.size()));
                    az.b(az.this);
                    AppMethodBeat.o(95971);
                    return;
                }
                if (az.this.DOh != null && poll.jpT.equals(az.this.DOh.jpT)) {
                    z = true;
                }
                az azVar = az.this;
                synchronized (azVar.DOl) {
                    try {
                        Iterator<f> it = azVar.DOl.iterator();
                        while (it.hasNext()) {
                            f next = it.next();
                            Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_PAUSE pause preload sns:[%s]", next.dHp);
                            next.stop();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(95971);
                        throw th;
                    }
                }
                az.this.a(poll, z);
                AppMethodBeat.o(95971);
            }
        });
        AppMethodBeat.o(95983);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(bg bgVar, boolean z) {
        AppMethodBeat.i(95984);
        String a2 = ay.a(bgVar.dHp, bgVar.ebR);
        if (!Util.isNullOrNil(a2)) {
            Log.i("MicroMsg.SnsVideoService", "this sns:[%s] video[%s] already download finish, do nothing. [%s, %s]", bgVar.dHp, bgVar.jpT, bgVar.dHp, a2);
            AppMethodBeat.o(95984);
            return false;
        }
        boolean boN = com.tencent.mm.vfs.s.boN(ay.aPr(bgVar.ebR.Id));
        String E = ay.E(bgVar.ebR);
        s aPs = ay.aPs(bgVar.dHp);
        if (aPs == null) {
            ay.fE(bgVar.dHp, bgVar.gqW);
        } else {
            ay.c(aPs, bgVar.gqW);
        }
        Log.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", E, Boolean.valueOf(boN));
        com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(bgVar.ebR.Id);
        aVar.DIq = bgVar.ebR;
        bp gCZ = bp.gCZ();
        gCZ.hXs = bgVar.iXu;
        aVar.DPp = gCZ;
        aVar.DPn = true;
        aVar.url = bgVar.ebR.Url;
        aVar.DPm = false;
        n.bhh();
        o.bhk();
        com.tencent.mm.i.h a3 = com.tencent.mm.an.e.a(aVar.DPp, aVar.url, E, ay.Qv(bgVar.dHp), bgVar.gqU, bgVar.ebR.isAd);
        if (a3 == null) {
            AppMethodBeat.o(95984);
            return false;
        }
        String str = bgVar.DPl;
        a3.gqV = str;
        a3.dRL = str;
        try {
            SnsObject B = an.B(aj.faO().aQm(bgVar.dHp));
            if (B != null) {
                a3.dRS = new StringBuilder().append(B.Id).toString();
                a3.gqZ = B.PreDownloadInfo.MIW;
            }
        } catch (Exception e2) {
        }
        this.DOh = bgVar;
        this.DOh.jpT = a3.field_mediaId;
        Log.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", this.DOh.jpT, Boolean.valueOf(z));
        o.bhk().a(a3, z);
        AppMethodBeat.o(95984);
        return true;
    }

    static /* synthetic */ void a(az azVar) {
        AppMethodBeat.i(95985);
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.az.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(95972);
                if (az.this.DOh != null) {
                    Log.i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", az.this.DOh.jpT);
                    az.this.DOj.remove(az.this.DOh.jpT);
                }
                az.this.DOh = null;
                az.this.fbQ();
                AppMethodBeat.o(95972);
            }
        });
        AppMethodBeat.o(95985);
    }

    static /* synthetic */ void b(az azVar) {
        AppMethodBeat.i(95986);
        synchronized (azVar.DOl) {
            try {
                Iterator<f> it = azVar.DOl.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    SnsInfo aQm = aj.faO().aQm(next.dHp);
                    if (aQm != null) {
                        String a2 = ay.a(aQm.getLocalid(), aQm.getTimeLine().ContentObj.LoV.get(0));
                        if (!Util.isNullOrNil(a2)) {
                            Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_RESUME sns:[%s] , video[%s] already download finish, do nothing.", aQm.getLocalid(), a2);
                            it.remove();
                        } else {
                            Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_RESUME resume preload sns:[%s]", next.dHp);
                            if (next.a(azVar) < 0) {
                                Log.w("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD curr preload task do scene error. hash:[%d ]", Integer.valueOf(azVar.hashCode()));
                                it.remove();
                            }
                        }
                    }
                }
                for (int size = azVar.DOl.size(); size < azVar.DOm; size++) {
                    azVar.fbO();
                }
            } finally {
                AppMethodBeat.o(95986);
            }
        }
    }
}
