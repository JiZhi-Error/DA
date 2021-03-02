package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.d;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.av.u;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.ca;
import java.net.URLEncoder;

public final class b implements u.a {
    @Override // com.tencent.mm.av.u.a
    public final void a(long j2, ca caVar, d dVar, int i2, boolean z, com.tencent.mm.i.d dVar2, String str) {
        String str2;
        int i3;
        AppMethodBeat.i(231533);
        a aVar = new a(j2, caVar, dVar, z, i2, str);
        c Fu = com.tencent.mm.model.c.d.aXu().Fu("100131");
        if (Fu.isValid()) {
            aVar.hmp = af.getInt(Fu.gzz().get("needUploadData"), 1);
        }
        if (aVar.hmn || (!aVar.hmr && aVar.hmp == 0)) {
            AppMethodBeat.o(231533);
            return;
        }
        aVar.hmq = dVar2;
        aVar.hmn = true;
        enu enu = (enu) aVar.rr.iLK.iLR;
        if (enu.KHm != null) {
            str2 = enu.KHm.MTo;
        } else {
            str2 = "";
        }
        boolean z2 = !Util.isNullOrNil(str2) && ab.Eq(str2);
        StringBuilder sb = new StringBuilder("2,");
        if (z2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        aVar.hmm = sb.append(i3).append(",,").toString();
        if (aVar.hml == null) {
            aVar.hml = q.bcR().c(Long.valueOf(aVar.hmj));
        }
        g gVar = aVar.hml;
        if (gVar != null) {
            qx qxVar = new qx();
            EventCenter.instance.addListener(aVar.hms);
            EventCenter.instance.addListener(aVar.hmt);
            aVar.hmo = q.bcR().o(gVar.iXm, "", "");
            qxVar.dXu.dDZ = System.nanoTime();
            qxVar.dXu.filePath = aVar.hmo;
            EventCenter.instance.publish(qxVar);
        }
        AppMethodBeat.o(231533);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        ca dCM = null;
        long hmj;
        int hmk;
        g hml;
        String hmm;
        boolean hmn = false;
        String hmo;
        int hmp = 0;
        com.tencent.mm.i.d hmq;
        boolean hmr = false;
        IListener hms = new IListener<qz>() {
            /* class com.tencent.mm.insane_statistic.b.a.AnonymousClass1 */

            {
                AppMethodBeat.i(161276);
                this.__eventId = qz.class.getName().hashCode();
                AppMethodBeat.o(161276);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(qz qzVar) {
                AppMethodBeat.i(20221);
                boolean a2 = a(qzVar);
                AppMethodBeat.o(20221);
                return a2;
            }

            private boolean a(qz qzVar) {
                String str;
                k.b HD;
                AppMethodBeat.i(20220);
                if (Util.isNullOrNil(a.this.hmo, qzVar.dXz.filePath) || !qzVar.dXz.filePath.equals(a.this.hmo)) {
                    AppMethodBeat.o(20220);
                } else {
                    try {
                        str = URLEncoder.encode(qzVar.dXz.result, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", e2, "", new Object[0]);
                        str = "";
                    }
                    if (a.this.hmr) {
                        String str2 = a.this.hmm + str;
                        Log.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", Long.valueOf(a.this.hmj), Integer.valueOf(a.this.hashCode()), str2, qzVar.dXz.filePath);
                        h.INSTANCE.kvStat(13717, str2);
                    }
                    if (a.this.hmp == 1) {
                        m mVar = new m();
                        enu enu = (enu) a.this.rr.iLK.iLR;
                        mVar.n("20toUser", enu.KHm.MTo + ",");
                        mVar.n("21source", a.this.hmk + ",");
                        mVar.n("22qrUrl", str + ",");
                        mVar.n("23md5", (a.this.hmq == null ? "" : a.this.hmq.field_filemd5) + ",");
                        mVar.n("24cdnFileId", (a.this.hmq == null ? "" : a.this.hmq.field_fileId) + ",");
                        mVar.n("25cdnAesKey", (a.this.hmq == null ? "" : a.this.hmq.field_aesKey) + ",");
                        String str3 = "";
                        if (a.this.dCM.dOQ() && (HD = k.b.HD(a.this.dCM.field_content)) != null) {
                            str3 = HD.appId;
                        }
                        mVar.n("26appip", str3 + ",");
                        mVar.n("27toUsersCount", v.Ie(enu.KHm.MTo) + ",");
                        mVar.n("28codeType", Integer.valueOf(qzVar.dXz.dFL));
                        Log.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + mVar.abW());
                        o.O(13628, mVar.toString());
                    }
                    a.a(a.this);
                    a.a(a.this, qzVar.dXz.result);
                    AppMethodBeat.o(20220);
                }
                return false;
            }
        };
        IListener hmt = new IListener<qy>() {
            /* class com.tencent.mm.insane_statistic.b.a.AnonymousClass2 */

            {
                AppMethodBeat.i(161277);
                this.__eventId = qy.class.getName().hashCode();
                AppMethodBeat.o(161277);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(qy qyVar) {
                AppMethodBeat.i(20222);
                qy qyVar2 = qyVar;
                if (Util.isNullOrNil(a.this.hmo, qyVar2.dXy.filePath) || !qyVar2.dXy.filePath.equals(a.this.hmo)) {
                    AppMethodBeat.o(20222);
                } else {
                    if (a.this.hmr) {
                        Log.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717), imgLocalId:%d, scene.hash:%d, %s", Long.valueOf(a.this.hmj), Integer.valueOf(a.this.hashCode()), a.this.hmm);
                        h.INSTANCE.kvStat(13717, a.this.hmm);
                    }
                    a.a(a.this);
                    a.a(a.this, null);
                    AppMethodBeat.o(20222);
                }
                return false;
            }
        };
        final d rr;
        private String uuid;

        a(long j2, ca caVar, d dVar, boolean z, int i2, String str) {
            AppMethodBeat.i(231531);
            this.hmj = j2;
            this.dCM = caVar;
            this.rr = dVar;
            this.hmk = i2;
            this.hmr = z;
            this.uuid = str;
            AppMethodBeat.o(231531);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(20224);
            EventCenter.instance.removeListener(aVar.hms);
            EventCenter.instance.removeListener(aVar.hmt);
            AppMethodBeat.o(20224);
        }

        static /* synthetic */ void a(a aVar, String str) {
            int i2;
            AppMethodBeat.i(231532);
            com.tencent.mm.plugin.multimediareport.d dVar = new com.tencent.mm.plugin.multimediareport.d();
            dVar.zGI = aVar.dCM.field_msgSvrId;
            dVar.zGJ = 1;
            switch (aVar.hmk) {
                case 1:
                case 2:
                    dVar.source = 3;
                    break;
                case 3:
                default:
                    dVar.source = 2;
                    break;
                case 4:
                    dVar.source = 1;
                    break;
            }
            dVar.pPz = aVar.dCM.field_talker;
            dVar.fileid = aVar.hmq == null ? "" : aVar.hmq.field_fileId;
            dVar.zGM = aVar.hmq == null ? "" : aVar.hmq.field_aesKey;
            dVar.md5 = aVar.hmq == null ? "" : aVar.hmq.field_filemd5;
            dVar.createtime = aVar.dCM.field_createTime;
            dVar.zGN = 0;
            dVar.zGO = 0;
            dVar.qwo = str;
            dVar.uuid = aVar.uuid;
            if (ab.Eq(aVar.dCM.field_talker)) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            com.tencent.mm.plugin.multimediareport.g.a(dVar, i2, aVar.dCM.field_createTime, aVar.hmo);
            AppMethodBeat.o(231532);
        }
    }
}
