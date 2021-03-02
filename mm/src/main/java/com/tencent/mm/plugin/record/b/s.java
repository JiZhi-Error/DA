package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.h;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.a.k;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class s implements i, com.tencent.mm.plugin.record.a.d, com.tencent.mm.plugin.record.a.i {
    boolean BGI = false;
    SparseArray<e> BGL = new SparseArray<>();
    LinkedList<k> BGM = new LinkedList<>();
    private int BHh = 7;

    /* access modifiers changed from: package-private */
    public static final class e {
        long BGP;
        int jNv;

        private e() {
            AppMethodBeat.i(9571);
            this.BGP = SystemClock.elapsedRealtime();
            this.jNv = 3;
            AppMethodBeat.o(9571);
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }

    public s() {
        AppMethodBeat.i(9572);
        g.aAg().hqi.a(632, this);
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
        try {
            this.BHh = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_recordmsg_send_waiting_time, 7);
            AppMethodBeat.o(9572);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.RecordMsgSendService", e2, "RecordMsgSendService init error.", new Object[0]);
            AppMethodBeat.o(9572);
        }
    }

    @Override // com.tencent.mm.plugin.record.a.i
    public final void a(k kVar) {
        AppMethodBeat.i(261903);
        a(kVar, false);
        AppMethodBeat.o(261903);
    }

    @Override // com.tencent.mm.plugin.record.a.i
    public final void a(final k kVar, final boolean z) {
        AppMethodBeat.i(9574);
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.record.b.s.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:40:0x0192  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x01f7  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 528
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.b.s.AnonymousClass1.run():void");
            }

            public final String toString() {
                AppMethodBeat.i(9552);
                String str = super.toString() + "|run";
                AppMethodBeat.o(9552);
                return str;
            }
        });
        AppMethodBeat.o(9574);
    }

    /* access modifiers changed from: package-private */
    public final void b(k kVar) {
        AppMethodBeat.i(9575);
        if (!this.BGM.contains(kVar)) {
            this.BGM.add(kVar);
        }
        AppMethodBeat.o(9575);
    }

    class a implements Runnable {
        private k BGF;

        public a(k kVar) {
            this.BGF = kVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00f3  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0285  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 875
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.b.s.a.run():void");
        }
    }

    class b implements i, t.a, Runnable {
        private k BGF;
        HashMap<Long, Boolean> BHb = new HashMap<>();
        HashMap<Long, String> BHl = new HashMap<>();
        private boolean dgZ = false;

        /* renamed from: i  reason: collision with root package name */
        private int f1509i = 0;

        static /* synthetic */ void a(b bVar, HashMap hashMap, boolean z, k kVar) {
            AppMethodBeat.i(9563);
            bVar.a(hashMap, z, kVar);
            AppMethodBeat.o(9563);
        }

        public b(k kVar) {
            AppMethodBeat.i(9556);
            this.BGF = kVar;
            o.bhj().a(this, Looper.getMainLooper());
            g.aAg().hqi.a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this);
            AppMethodBeat.o(9556);
        }

        public final void run() {
            boolean z;
            int i2;
            int i3;
            AppMethodBeat.i(9557);
            this.f1509i = 0;
            this.dgZ = false;
            Log.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", Long.valueOf(this.BGF.field_msgId));
            if (this.BGF.field_dataProto == null) {
                Log.w("MicroMsg.RecordMsgSendService", "ChatDataDownloadRunnable info.field_dataProto null");
                this.dgZ = true;
                s.this.BGI = false;
                a(null, this.dgZ, this.BGF);
                AppMethodBeat.o(9557);
                return;
            }
            Iterator<aml> it = this.BGF.field_dataProto.ppH.iterator();
            while (it.hasNext()) {
                aml next = it.next();
                final long j2 = next.Lwt;
                if (j2 > 0) {
                    final ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
                    String str = next.LvL;
                    if (System.currentTimeMillis() - Hb.field_createTime <= 259200000 || (!Util.isNullOrNil(str) && com.tencent.mm.vfs.s.YS(str))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        Log.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", Integer.valueOf(Hb.getType()));
                    } else if (next.dataType == 2) {
                        if (Hb.gAz()) {
                            final com.tencent.mm.av.g G = q.bcR().G(Hb.field_talker, Hb.field_msgSvrId);
                            if (Hb.field_isSend == 1) {
                                if (G.bcv()) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                i2 = i3;
                            } else if (!G.bcv()) {
                                i2 = 0;
                            } else {
                                if (!com.tencent.mm.vfs.s.YS(q.bcR().o(h.a(G).iXm, "", ""))) {
                                    i2 = 0;
                                } else {
                                    i2 = 1;
                                }
                            }
                            if (G.offset < G.iKP || G.iKP == 0) {
                                this.BHb.put(Long.valueOf(j2), Boolean.FALSE);
                                this.f1509i = this.BGF.field_dataProto.ppH.indexOf(next);
                                q.bcS().a(G.localId, Hb.field_msgId, i2, next, R.drawable.c3h, new e.a() {
                                    /* class com.tencent.mm.plugin.record.b.s.b.AnonymousClass1 */

                                    @Override // com.tencent.mm.av.e.a
                                    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, com.tencent.mm.ak.q qVar) {
                                    }

                                    @Override // com.tencent.mm.av.e.a
                                    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, com.tencent.mm.ak.q qVar) {
                                        AppMethodBeat.i(9554);
                                        Log.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", Boolean.valueOf(i4 == 0 && i5 == 0), Integer.valueOf(i4), Integer.valueOf(i5));
                                        if (obj instanceof aml) {
                                            aml aml = (aml) obj;
                                            aml.bgt(q.bcR().o(h.c(G), "", ""));
                                            aml.bgu(q.bcR().R(Hb.field_imgPath, true));
                                            Map<String, String> parseXml = XmlParser.parseXml(G.iXy, "msg", null);
                                            if (parseXml != null) {
                                                aml.bgj(parseXml.get(".msg.img.$cdnbigimgurl"));
                                                aml.Mu((long) Util.getInt(parseXml.get(".msg.img.$length"), 0));
                                                aml.bgk(parseXml.get(".msg.img.$aeskey"));
                                                b.this.BGF.field_dataProto.ppH.set(b.this.f1509i, aml);
                                            } else {
                                                Log.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", G.iXy);
                                            }
                                            b.this.BHb.put(Long.valueOf(aml.Lwt), Boolean.TRUE);
                                        } else {
                                            b.this.BHb.put(Long.valueOf(j2), Boolean.TRUE);
                                        }
                                        b.a(b.this, b.this.BHb, b.this.dgZ, b.this.BGF);
                                        AppMethodBeat.o(9554);
                                    }

                                    @Override // com.tencent.mm.av.e.a
                                    public final void a(long j2, long j3, int i2, int i3, Object obj) {
                                        AppMethodBeat.i(9555);
                                        b.this.BHb.put(Long.valueOf(j2), Boolean.TRUE);
                                        b.a(b.this, b.this.BHb, b.this.dgZ, b.this.BGF);
                                        AppMethodBeat.o(9555);
                                    }
                                });
                            }
                        } else if (Hb.gDr()) {
                            aK(Hb);
                        }
                    } else if (next.dataType == 4 || next.dataType == 15) {
                        com.tencent.mm.modelvideo.s QN = u.QN(Hb.field_imgPath);
                        if (!(QN == null || QN.status == 199)) {
                            this.BHb.put(Long.valueOf(j2), Boolean.FALSE);
                            if (QN.bhx()) {
                                Log.i("MicroMsg.RecordMsgSendService", "start complete online video");
                                u.QT(Hb.field_imgPath);
                            } else {
                                Log.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                                u.QI(Hb.field_imgPath);
                            }
                        }
                    } else if (next.dataType == 8 && !Util.isNullOrNil(next.LwF)) {
                        aK(Hb);
                    }
                }
            }
            this.dgZ = true;
            s.this.BGI = false;
            a(this.BHb, this.dgZ, this.BGF);
            AppMethodBeat.o(9557);
        }

        @Override // com.tencent.mm.modelvideo.t.a
        public final void a(t.a.C0460a aVar) {
            AppMethodBeat.i(9558);
            com.tencent.mm.modelvideo.s QN = u.QN(aVar.fileName);
            if (QN != null) {
                ca Hb = ((l) g.af(l.class)).eiy().Hb((long) QN.jso);
                if (QN.bhy()) {
                    this.BHb.put(Long.valueOf(Hb.field_msgId), Boolean.TRUE);
                    a(this.BHb, this.dgZ, this.BGF);
                }
                AppMethodBeat.o(9558);
                return;
            }
            a(null, this.dgZ, this.BGF);
            AppMethodBeat.o(9558);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(9559);
            if (qVar instanceof f) {
                g.aAg().hqi.b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this);
                if (this.BHl != null) {
                    for (Map.Entry<Long, String> entry : this.BHl.entrySet()) {
                        long longValue = entry.getKey().longValue();
                        String value = entry.getValue();
                        if (longValue > 0 && !this.BHb.get(Long.valueOf(longValue)).booleanValue()) {
                            ((l) g.af(l.class)).eiy().Hb(longValue);
                            com.tencent.mm.pluginsdk.model.app.c s = a.s(value, longValue);
                            String str2 = s != null ? s.field_fileFullPath : null;
                            if (str2 != null && str2.length() > 0) {
                                this.BHb.put(Long.valueOf(longValue), Boolean.TRUE);
                                Iterator<aml> it = this.BGF.field_dataProto.ppH.iterator();
                                while (it.hasNext()) {
                                    aml next = it.next();
                                    if (next.Lwt == longValue) {
                                        next.bgt(s.field_fileFullPath);
                                    }
                                }
                            }
                        }
                    }
                }
                a(this.BHb, this.dgZ, this.BGF);
                AppMethodBeat.o(9559);
                return;
            }
            a(null, this.dgZ, this.BGF);
            AppMethodBeat.o(9559);
        }

        private void a(HashMap<Long, Boolean> hashMap, boolean z, k kVar) {
            AppMethodBeat.i(9561);
            if (m(hashMap) && z) {
                o.bhj().a(this);
                kVar.field_type = 2;
                ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(kVar, ch.COL_LOCALID);
                ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(kVar);
            }
            AppMethodBeat.o(9561);
        }

        private static boolean m(HashMap<Long, Boolean> hashMap) {
            AppMethodBeat.i(9562);
            if (hashMap == null) {
                AppMethodBeat.o(9562);
                return true;
            }
            for (Map.Entry<Long, Boolean> entry : hashMap.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    AppMethodBeat.o(9562);
                    return false;
                }
            }
            AppMethodBeat.o(9562);
            return true;
        }

        private void aK(ca caVar) {
            AppMethodBeat.i(9560);
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null) {
                Log.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", caVar.field_content);
                AppMethodBeat.o(9560);
                return;
            }
            if (Util.isNullOrNil(HD.dCK) && !Util.isNullOrNil(HD.iwW)) {
                Log.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", caVar.field_content);
                HD.dCK = new StringBuilder().append(HD.iwW.hashCode()).toString();
            }
            String str = HD.dCK;
            if (!a.a(caVar, a.s(str, caVar.field_msgId))) {
                this.BHb.put(Long.valueOf(caVar.field_msgId), Boolean.FALSE);
                this.BHl.put(Long.valueOf(caVar.field_msgId), str);
                a.aK(caVar);
            }
            AppMethodBeat.o(9560);
        }
    }

    class d implements Runnable {
        private com.tencent.mm.plugin.record.a.k BGF;
        private boolean BHo;

        public d(com.tencent.mm.plugin.record.a.k kVar, boolean z) {
            this.BGF = kVar;
            this.BHo = z;
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(9567);
            if (this.BGF.field_dataProto == null) {
                Log.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
                s.this.BGI = false;
                AppMethodBeat.o(9567);
                return;
            }
            Iterator<aml> it = this.BGF.field_dataProto.ppH.iterator();
            boolean z2 = false;
            boolean z3 = false;
            while (it.hasNext()) {
                byte a2 = a(it.next(), 1, this.BHo);
                Log.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() state: %s ", Long.toBinaryString((long) a2));
                if ((a2 & 1) == 1) {
                    z3 = true;
                }
                if ((a2 & 2) == 2) {
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
            Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable startEmbedded:%s infochanged:%s, needRun:%s", Boolean.valueOf(this.BHo), Boolean.valueOf(z3), Boolean.valueOf(z2));
            if (z3) {
                Log.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", Integer.valueOf(this.BGF.field_localId), Long.valueOf(this.BGF.field_msgId), Integer.valueOf(this.BGF.field_type));
                ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(this.BGF, ch.COL_LOCALID);
            }
            if (!z2) {
                Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
                s.this.b(this.BGF, false);
                s.this.BGI = false;
                s.this.a((com.tencent.mm.plugin.record.a.k) null, false);
            }
            ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
            AppMethodBeat.o(9567);
        }

        private byte a(aml aml, int i2, boolean z) {
            byte b2;
            boolean z2;
            boolean z3;
            AppMethodBeat.i(9568);
            boolean z4 = false;
            boolean z5 = false;
            int i3 = aml.dataType;
            if (!z || i3 != 17) {
                if (!Util.isNullOrNil(aml.KuR) || !Util.isNullOrNil(aml.LwF)) {
                    String a2 = p.a(aml, this.BGF.field_oriMsgId, i2);
                    String a3 = p.a(aml, this.BGF.field_msgId, i2);
                    boolean z6 = com.tencent.mm.vfs.s.nw(a2, a3) > 0;
                    Log.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", a2, a3, Boolean.valueOf(z6));
                    if (z6) {
                        if (Util.isNullOrNil(aml.LvE)) {
                            Log.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
                            aml.bgq(com.tencent.mm.vfs.s.bhK(a3));
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (Util.isNullOrNil(aml.LvG)) {
                            Log.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
                            aml.bgr(com.tencent.mm.b.g.fb(a3));
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                    }
                    String fj = p.fj(aml.dLl, i2);
                    String g2 = p.g(fj, this.BGF.field_msgId, false);
                    j aKX = ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(g2);
                    if (aKX == null) {
                        j jVar = new j();
                        jVar.field_cdnKey = aml.Lvp;
                        jVar.field_cdnUrl = aml.KuR;
                        jVar.field_dataId = fj;
                        jVar.field_mediaId = g2;
                        jVar.field_totalLen = (int) aml.LvI;
                        jVar.field_localId = jVar.field_mediaId.hashCode();
                        jVar.field_path = p.a(aml, this.BGF.field_msgId, i2);
                        jVar.field_type = 2;
                        jVar.field_fileType = p.hR(aml.dataType, (int) aml.LvI);
                        jVar.field_recordLocalId = this.BGF.field_localId;
                        jVar.field_toUser = this.BGF.field_toUser;
                        jVar.field_isThumb = false;
                        String a4 = p.a(aml, this.BGF.field_msgId, i2);
                        if (!Util.isNullOrNil(aml.LwF) && !com.tencent.mm.vfs.s.YS(a4)) {
                            jVar.field_status = -1;
                            a(aml, a4, g2);
                        }
                        z5 = true;
                        Log.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", Integer.valueOf(jVar.field_localId), Boolean.valueOf(((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(jVar)), Integer.valueOf(jVar.field_recordLocalId), jVar.field_dataId, jVar.field_mediaId);
                    } else {
                        if (aKX.field_status == -1) {
                            a(aml, p.a(aml, this.BGF.field_msgId, i2), g2);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (aKX.field_status == 0) {
                            z2 = true;
                        }
                        Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", Integer.valueOf(aKX.field_status));
                        z5 = z2;
                    }
                }
                if (!Util.isNullOrNil(aml.iwX) || !Util.isNullOrNil(aml.iwO)) {
                    String b3 = p.b(aml, this.BGF.field_oriMsgId, i2);
                    String b4 = p.b(aml, this.BGF.field_msgId, i2);
                    Log.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", b3, b4, Boolean.valueOf(com.tencent.mm.vfs.s.nw(b3, b4) > 0));
                    String fj2 = p.fj(p.arI(aml.dLl), i2);
                    String g3 = p.g(fj2, this.BGF.field_msgId, false);
                    j aKX2 = ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(g3);
                    String b5 = p.b(aml, this.BGF.field_msgId, i2);
                    if (aKX2 == null) {
                        j jVar2 = new j();
                        jVar2.field_cdnKey = aml.Lvk;
                        jVar2.field_cdnUrl = aml.iwX;
                        jVar2.field_dataId = fj2;
                        jVar2.field_mediaId = g3;
                        jVar2.field_totalLen = (int) aml.LvT;
                        jVar2.field_localId = jVar2.field_mediaId.hashCode();
                        jVar2.field_path = p.b(aml, this.BGF.field_msgId, i2);
                        jVar2.field_type = 2;
                        jVar2.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
                        jVar2.field_recordLocalId = this.BGF.field_localId;
                        jVar2.field_toUser = this.BGF.field_toUser;
                        jVar2.field_isThumb = true;
                        if (!Util.isNullOrNil(aml.iwO) && !com.tencent.mm.vfs.s.YS(b5)) {
                            jVar2.field_status = -1;
                            b(aml, b5, g3);
                        }
                        z5 = true;
                        Log.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d, dataId:%s, mediaId:%s", Integer.valueOf(jVar2.field_localId), Boolean.valueOf(((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(jVar2)), Integer.valueOf(jVar2.field_recordLocalId), jVar2.field_dataId, jVar2.field_mediaId);
                    } else {
                        if (aKX2.field_status == -1) {
                            b(aml, p.b(aml, this.BGF.field_msgId, i2), g3);
                            z5 = true;
                        }
                        if (aKX2.field_status == 0) {
                            z5 = true;
                        }
                        Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", Integer.valueOf(aKX2.field_status));
                    }
                }
                if (z4) {
                    b2 = 1;
                } else {
                    b2 = 0;
                }
                if (z5) {
                    b2 = (byte) (b2 | 2);
                }
                AppMethodBeat.o(9568);
                return b2;
            }
            Log.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable run() inner record");
            com.tencent.mm.protocal.b.a.c aKY = p.aKY(aml.Lwx);
            if (aKY == null) {
                AppMethodBeat.o(9568);
                return 0;
            }
            byte b6 = 0;
            Iterator<aml> it = aKY.iAd.iterator();
            while (it.hasNext()) {
                byte a5 = a(it.next(), i2 + 1, z);
                Log.d("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable circleTraverseFavDataItem() %s result:%s ", Long.toBinaryString((long) a5), Long.toBinaryString((long) ((byte) (a5 | b6))));
                b6 = (byte) (a5 | b6);
            }
            AppMethodBeat.o(9568);
            return b6;
        }

        private void a(final aml aml, final String str, String str2) {
            AppMethodBeat.i(9569);
            Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", aml.dLl, str2, str);
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.taskName = "task_RecordMsgSendService_1";
            gVar.field_fileType = 19;
            gVar.field_authKey = aml.iwT;
            gVar.field_aesKey = aml.LwC;
            gVar.gqB = aml.LwF;
            gVar.field_fullpath = str;
            if (str2 != null) {
                str2 = str2 + "_tp";
            }
            gVar.field_mediaId = str2;
            gVar.gqy = new g.a() {
                /* class com.tencent.mm.plugin.record.b.s.d.AnonymousClass1 */

                @Override // com.tencent.mm.i.g.a
                public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                    boolean z2;
                    String str2;
                    AppMethodBeat.i(9565);
                    if (i2 == 0 && dVar != null && dVar.field_retCode == 0) {
                        Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", aml.dLl, str, str);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!(i2 == 0 && (dVar == null || dVar.field_retCode == 0))) {
                        Object[] objArr = new Object[5];
                        objArr[0] = aml.dLl;
                        objArr[1] = str;
                        objArr[2] = str;
                        objArr[3] = Integer.valueOf(i2);
                        objArr[4] = Integer.valueOf(dVar == null ? 0 : dVar.field_retCode);
                        Log.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, path:%s, err:(%d,%d)", objArr);
                        z2 = true;
                    }
                    if (z2) {
                        if (str == null || !str.endsWith("_tp")) {
                            str2 = str;
                        } else {
                            str2 = str.substring(0, str.length() - 3);
                        }
                        j aKX = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(str2);
                        if (aKX == null) {
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = aml.dLl;
                            objArr2[1] = str;
                            objArr2[2] = str2;
                            objArr2[3] = str;
                            objArr2[4] = Integer.valueOf(i2);
                            objArr2[5] = Integer.valueOf(dVar == null ? 0 : dVar.field_retCode);
                            Log.e("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl error id:%s, mediaId:%s, tempMediaId:%s, path:%s, err:(%d,%d), cdnInfo==null", objArr2);
                            AppMethodBeat.o(9565);
                            return 0;
                        }
                        aKX.field_status = 0;
                        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(aKX);
                        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
                    }
                    AppMethodBeat.o(9565);
                    return 0;
                }

                @Override // com.tencent.mm.i.g.a
                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                @Override // com.tencent.mm.i.g.a
                public final byte[] f(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (!f.baQ().b(gVar, -1)) {
                Log.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
            }
            AppMethodBeat.o(9569);
        }

        private void b(final aml aml, final String str, String str2) {
            AppMethodBeat.i(9570);
            Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", aml.dLl, str2, str);
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.taskName = "task_RecordMsgSendService_2";
            gVar.field_fileType = 19;
            gVar.field_authKey = aml.iwT;
            gVar.field_aesKey = aml.iwU;
            gVar.gqB = aml.iwO;
            gVar.field_fullpath = str;
            if (str2 != null) {
                str2 = str2 + "_tp";
            }
            gVar.field_mediaId = str2;
            gVar.gqy = new g.a() {
                /* class com.tencent.mm.plugin.record.b.s.d.AnonymousClass2 */

                @Override // com.tencent.mm.i.g.a
                public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                    boolean z2;
                    String str2;
                    AppMethodBeat.i(9566);
                    if (i2 == 0 && dVar != null && dVar.field_retCode == 0) {
                        Log.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", aml.dLl, str, str);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!(i2 == 0 && (dVar == null || dVar.field_retCode == 0))) {
                        Object[] objArr = new Object[5];
                        objArr[0] = aml.dLl;
                        objArr[1] = str;
                        objArr[2] = str;
                        objArr[3] = Integer.valueOf(i2);
                        objArr[4] = Integer.valueOf(dVar == null ? 0 : dVar.field_retCode);
                        Log.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)", objArr);
                        z2 = true;
                    }
                    if (z2) {
                        if (str == null || !str.endsWith("_tp")) {
                            str2 = str;
                        } else {
                            str2 = str.substring(0, str.length() - 3);
                        }
                        j aKX = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(str2);
                        if (aKX == null) {
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = aml.dLl;
                            objArr2[1] = str;
                            objArr2[2] = str2;
                            objArr2[3] = str;
                            objArr2[4] = Integer.valueOf(i2);
                            objArr2[5] = Integer.valueOf(dVar == null ? 0 : dVar.field_retCode);
                            Log.e("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl error id:%s, mediaId:%s, tempMediaId:%s, thumbPath:%s err:(%d,%d)", objArr2);
                            AppMethodBeat.o(9566);
                            return 0;
                        }
                        aKX.field_status = 0;
                        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(aKX);
                        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
                    }
                    AppMethodBeat.o(9566);
                    return 0;
                }

                @Override // com.tencent.mm.i.g.a
                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                @Override // com.tencent.mm.i.g.a
                public final byte[] f(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (!f.baQ().b(gVar, -1)) {
                Log.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
            }
            AppMethodBeat.o(9570);
        }
    }

    class c implements Runnable {
        private com.tencent.mm.plugin.record.a.k BGF;

        public c(com.tencent.mm.plugin.record.a.k kVar) {
            this.BGF = kVar;
        }

        public final void run() {
            AppMethodBeat.i(9564);
            Log.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", Long.valueOf(this.BGF.field_msgId));
            Iterator<aml> it = this.BGF.field_dataProto.ppH.iterator();
            boolean z = false;
            while (it.hasNext()) {
                aml next = it.next();
                hb hbVar = new hb();
                hbVar.dLm.type = 2;
                hbVar.dLm.dLo = next;
                EventCenter.instance.publish(hbVar);
                Log.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", next.dLl, Integer.valueOf(next.dataType));
                if (!Util.isNullOrNil(hbVar.dLn.path)) {
                    String c2 = p.c(next, this.BGF.field_msgId);
                    Log.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", hbVar.dLn.path, c2);
                    if (!hbVar.dLn.path.equals(c2)) {
                        com.tencent.mm.vfs.s.nw(hbVar.dLn.path, c2);
                    }
                }
                if (!Util.isNullOrNil(hbVar.dLn.thumbPath)) {
                    String f2 = p.f(next, this.BGF.field_msgId);
                    Log.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", hbVar.dLn.thumbPath, f2);
                    if (!hbVar.dLn.thumbPath.equals(f2)) {
                        com.tencent.mm.vfs.s.nw(hbVar.dLn.thumbPath, f2);
                    }
                }
                if (next.dataType == 3) {
                    Log.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
                    next.bgk("");
                    next.bgj("");
                    next.bgi("");
                    next.bgh("");
                }
                if (!Util.isNullOrNil(next.KuR) || !Util.isNullOrNil(next.iwX)) {
                    z = true;
                }
            }
            if (z) {
                com.tencent.mm.kernel.g.aAg().hqi.a(new g(this.BGF), 0);
                AppMethodBeat.o(9564);
                return;
            }
            s.this.f(this.BGF.field_msgId, this.BGF.field_localId, k.b.a(p.a(this.BGF.field_title, this.BGF.field_desc, this.BGF.field_dataProto), null, null));
            s.this.BGI = false;
            s.this.a((com.tencent.mm.plugin.record.a.k) null, false);
            AppMethodBeat.o(9564);
        }
    }

    public final void finish() {
        AppMethodBeat.i(9576);
        this.BGM.clear();
        this.BGL.clear();
        this.BGI = false;
        AppMethodBeat.o(9576);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0229 A[SYNTHETIC] */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
        /*
        // Method dump skipped, instructions count: 562
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.b.s.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    /* access modifiers changed from: package-private */
    public final void f(long j2, int i2, String str) {
        AppMethodBeat.i(9578);
        ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2);
        if (Hb.field_msgId == j2) {
            Hb.setContent(str);
            Hb.setStatus(1);
            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(j2, Hb);
        }
        com.tencent.mm.ag.k GL = com.tencent.mm.plugin.r.a.eAT().GL(j2);
        if (GL != null) {
            GL.field_xml = Hb.field_content;
            com.tencent.mm.plugin.r.a.eAT().update(GL, "msgId");
        }
        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Vu(i2);
        this.BGL.remove(i2);
        ((com.tencent.mm.plugin.record.a.g) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.g.class)).HR(j2);
        Log.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", Long.valueOf(j2), Integer.valueOf(i2));
        AppMethodBeat.o(9578);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0168 A[SYNTHETIC] */
    @Override // com.tencent.mm.plugin.record.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r14, com.tencent.mm.plugin.record.a.j r15) {
        /*
        // Method dump skipped, instructions count: 363
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.b.s.a(int, com.tencent.mm.plugin.record.a.j):void");
    }

    private boolean a(j jVar, List<aml> list, int i2) {
        AppMethodBeat.i(9580);
        Iterator<aml> it = list.iterator();
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            aml next = it.next();
            int i3 = next.dataType;
            Log.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfo() dataItem.getDataId:%s msgType:%s", next.dLl, Integer.valueOf(i3));
            if (i3 == 17) {
                z = a(jVar, next, i2);
            } else if (jVar.field_dataId.equals(p.fj(p.arI(next.dLl), i2))) {
                Log.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", next.Lvk, jVar.field_cdnKey, next.iwX, jVar.field_cdnUrl, Long.valueOf(next.LvT), Integer.valueOf(jVar.field_totalLen));
                next.bgi(jVar.field_cdnKey);
                next.bgh(jVar.field_cdnUrl);
                if (!Util.isEqual(i2, 1)) {
                    next.bgs(p.ds(next.toString(), next.dataType));
                }
                z = true;
            }
        }
        AppMethodBeat.o(9580);
        return z;
    }

    private boolean b(j jVar, List<aml> list, int i2) {
        AppMethodBeat.i(9582);
        Iterator<aml> it = list.iterator();
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            aml next = it.next();
            int i3 = next.dataType;
            Log.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfo() dataItem.getDataId:%s msgType:%s", next.dLl, Integer.valueOf(i3));
            if (i3 == 17) {
                z = b(jVar, next, i2);
            } else if (jVar.field_dataId.equals(p.fj(next.dLl, i2))) {
                Log.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", next.Lvp, jVar.field_cdnKey, next.KuR, jVar.field_cdnUrl, Long.valueOf(next.LvI), Integer.valueOf(jVar.field_totalLen));
                next.bgk(jVar.field_cdnKey);
                next.bgj(jVar.field_cdnUrl);
                if (!Util.isEqual(i2, 1)) {
                    next.bgs(p.ds(next.toString(), next.dataType));
                }
                z = true;
            }
        }
        AppMethodBeat.o(9582);
        return z;
    }

    /* access modifiers changed from: package-private */
    public final void b(com.tencent.mm.plugin.record.a.k kVar, boolean z) {
        AppMethodBeat.i(9584);
        ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(kVar.field_msgId);
        Log.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s, toUser:%s", Boolean.FALSE, Long.valueOf(Hb.field_msgId), Long.valueOf(kVar.field_msgId), Integer.valueOf(kVar.field_localId), Boolean.valueOf(z), kVar.field_toUser);
        if (Hb.field_msgId == kVar.field_msgId) {
            Hb.setContent(p.a(kVar.field_title, kVar.field_desc, kVar.field_dataProto, kVar.field_favFrom, kVar.field_msgId));
            Hb.setStatus(1);
            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(kVar.field_msgId, Hb);
        }
        com.tencent.mm.ag.k GL = com.tencent.mm.plugin.r.a.eAT().GL(kVar.field_msgId);
        if (GL != null) {
            GL.field_xml = Hb.field_content;
            com.tencent.mm.plugin.r.a.eAT().update(GL, "msgId");
        }
        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().Vu(kVar.field_localId);
        this.BGL.remove(kVar.field_localId);
        if (Hb.field_createTime + ((long) (this.BHh * 24 * LocalCache.TIME_HOUR * 1000)) < cl.aWz()) {
            Log.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + Hb.field_createTime);
            Hb.setStatus(5);
            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(kVar.field_msgId, Hb);
            AppMethodBeat.o(9584);
            return;
        }
        if (!p.a(kVar.field_toUser, kVar.field_msgId, true, "")) {
            ((com.tencent.mm.plugin.record.a.g) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.g.class)).HR(kVar.field_msgId);
        }
        AppMethodBeat.o(9584);
    }

    private boolean a(j jVar, aml aml, int i2) {
        AppMethodBeat.i(9581);
        com.tencent.mm.protocal.b.a.c aKY = p.aKY(aml.Lwx);
        if (aKY == null) {
            Log.i("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() msgData == null");
            AppMethodBeat.o(9581);
            return false;
        }
        boolean a2 = a(jVar, aKY.iAd, i2 + 1);
        Log.d("MicroMsg.RecordMsgSendService", "replaceThumbCdnInfomEbeddedRecord() ifReplace:%s", Boolean.valueOf(a2));
        if (a2) {
            aml.bgF(p.a(aKY, aml.Lwx));
        }
        AppMethodBeat.o(9581);
        return a2;
    }

    private boolean b(j jVar, aml aml, int i2) {
        AppMethodBeat.i(9583);
        com.tencent.mm.protocal.b.a.c aKY = p.aKY(aml.Lwx);
        if (aKY == null) {
            Log.i("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() msgData == null");
            AppMethodBeat.o(9583);
            return false;
        }
        boolean b2 = b(jVar, aKY.iAd, i2 + 1);
        Log.d("MicroMsg.RecordMsgSendService", "replaceOtherCdnInfoEmbeddedRecord() ifReplace:%s", Boolean.valueOf(b2));
        if (b2) {
            aml.bgF(p.a(aKY, aml.Lwx));
        }
        AppMethodBeat.o(9583);
        return b2;
    }
}
