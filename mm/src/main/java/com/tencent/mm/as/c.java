package com.tencent.mm.as;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.h;
import com.tencent.mm.as.b;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c extends IListener<ux> implements b.a, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange {
    public final IListener iWd = new IListener<jk>() {
        /* class com.tencent.mm.as.c.AnonymousClass2 */

        {
            AppMethodBeat.i(231542);
            this.__eventId = jk.class.getName().hashCode();
            AppMethodBeat.o(231542);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jk jkVar) {
            AppMethodBeat.i(231544);
            boolean a2 = a(jkVar);
            AppMethodBeat.o(231544);
            return a2;
        }

        private static boolean a(jk jkVar) {
            long j2;
            long j3;
            AppMethodBeat.i(231543);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.tencent.mm.plugin.messenger.foundation.a.a.b eit = ((l) g.af(l.class)).eit();
                if (!eit.aEf(jkVar.dOf.username)) {
                    aj ajVar = new aj();
                    ajVar.field_username = jkVar.dOf.username;
                    if (jkVar.dOf.dOg <= jkVar.dOf.dOi) {
                        j3 = jkVar.dOf.dOi;
                    } else {
                        j3 = jkVar.dOf.dOg;
                    }
                    ajVar.field_lastPushSeq = j3;
                    ajVar.field_lastLocalSeq = jkVar.dOf.dOi;
                    ajVar.field_lastPushCreateTime = jkVar.dOf.dOh;
                    ajVar.field_lastLocalCreateTime = jkVar.dOf.dOj;
                    long a2 = eit.a(ajVar, true);
                    com.tencent.mm.ui.chatting.l.c cVar = com.tencent.mm.ui.chatting.l.c.PEZ;
                    com.tencent.mm.ui.chatting.l.c.gTH();
                    Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", Long.valueOf(a2), jkVar.dOf.username, Long.valueOf(jkVar.dOf.dOg), Long.valueOf(jkVar.dOf.dOh), Long.valueOf(jkVar.dOf.dOi), Long.valueOf(jkVar.dOf.dOj));
                    Log.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(231543);
                    return true;
                }
                String str = jkVar.dOf.username;
                ca aEz = ((l) g.af(l.class)).eiy().aEz(str);
                long j4 = jkVar.dOf.dOg;
                long j5 = jkVar.dOf.dOh;
                aj aEh = eit.aEh(str);
                long j6 = aEh.field_lastLocalSeq;
                long j7 = aEh.field_lastLocalCreateTime;
                long j8 = aEh.field_lastPushSeq;
                long j9 = aEh.field_lastPushCreateTime;
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", str, Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9));
                if (aEz == null || aEz.field_msgId == 0) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(aEz == null);
                    if (aEz == null) {
                        j2 = -1;
                    } else {
                        j2 = aEz.field_msgId;
                    }
                    objArr[1] = Long.valueOf(j2);
                    Log.w("MicroMsg.GetChatroomMsgReceiver", "lastMsgInfo is null? %s lastMsgInfo id:%s", objArr);
                } else {
                    long j10 = aEz.field_msgSeq;
                    if (j10 > j6) {
                        aEh.field_lastLocalSeq = j10;
                        aEh.field_lastLocalCreateTime = aEz.field_createTime;
                        com.tencent.mm.k.a.a.c cVar2 = new com.tencent.mm.k.a.a.c();
                        cVar2.gCy = 1 + j6;
                        cVar2.gCA = j7 + 1;
                        cVar2.gCz = j10 - 1;
                        cVar2.gCB = j9 - 1;
                        if (aEh.field_seqBlockInfo == null) {
                            aEh.field_seqBlockInfo = new d();
                        }
                        aEh.field_seqBlockInfo.gCC.addLast(cVar2);
                        Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", Long.valueOf(eit.b(aEh)));
                    }
                    if (j8 < j4) {
                        Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", Boolean.valueOf(eit.aB(str, j4)), Boolean.valueOf(eit.aD(str, j5)), Long.valueOf(aEz.field_msgSeq), Long.valueOf(j6));
                    }
                }
                Log.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(231543);
                return true;
            } catch (Throwable th) {
                Log.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(231543);
                throw th;
            }
        }
    };
    private Map<Long, bt> iWe = new HashMap();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ux uxVar) {
        AppMethodBeat.i(20512);
        g.aAk().postToWorker(new a(uxVar, (byte) 0));
        AppMethodBeat.o(20512);
        return true;
    }

    public c() {
        AppMethodBeat.i(20506);
        EventCenter.instance.addListener(this.iWd);
        b.bch().iVW = this;
        ((l) g.af(l.class)).aST().add(this, g.aAk().getLooper());
        p.bdT();
        p.bdR().add(this, bg.aAk().getLooper());
        this.__eventId = ux.class.getName().hashCode();
        AppMethodBeat.o(20506);
    }

    @Override // com.tencent.mm.as.b.a
    public final void a(String str, boolean z, LinkedList<ca> linkedList, com.tencent.mm.k.a.a.c cVar, boolean z2) {
        AppMethodBeat.i(20507);
        if (linkedList.size() <= 0 || z2) {
            Log.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(z2)));
            long j2 = cVar.gCy;
            long j3 = cVar.gCz;
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + j2 + " lastMsgSeq:" + j3 + " chatroomId:" + str);
            com.tencent.mm.plugin.messenger.foundation.a.a.b eit = ((l) g.af(l.class)).eit();
            aj aEh = eit.aEh(str);
            if (aEh.field_seqBlockInfo != null) {
                LinkedList linkedList2 = new LinkedList();
                Iterator<com.tencent.mm.k.a.a.c> it = aEh.field_seqBlockInfo.gCC.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mm.k.a.a.c next = it.next();
                    if (next.gCy == j2 && next.gCz == j3) {
                        linkedList2.add(next);
                        break;
                    }
                }
                aEh.field_seqBlockInfo.gCC.removeAll(linkedList2);
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + j2 + " lastMsgSeq:" + j3 + " chatroomId:" + str + " ret:" + eit.b(aEh) + " remove list:" + linkedList2.size());
                if (linkedList2.size() > 0) {
                    com.tencent.mm.ui.chatting.l.c cVar2 = com.tencent.mm.ui.chatting.l.c.PEZ;
                    com.tencent.mm.ui.chatting.l.c.gTJ();
                }
            }
            aEh.field_lastLocalSeq = aEh.field_lastPushSeq;
            aEh.field_lastLocalCreateTime = aEh.field_lastPushCreateTime;
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + j2 + " lastMsgSeq:" + j3 + " chatroomId:" + str + " ret:" + eit.b(aEh) + " lastPushSeq:" + aEh.field_lastPushSeq + " field_lastPushCreateTime:" + aEh.field_lastPushCreateTime);
            AppMethodBeat.o(20507);
            return;
        }
        Log.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", Integer.valueOf(linkedList.size()), Boolean.valueOf(z));
        com.tencent.mm.plugin.messenger.foundation.a.a.b eit2 = ((l) g.af(l.class)).eit();
        List<com.tencent.mm.k.a.a.c> a2 = a(str, linkedList);
        d aEe = eit2.aEe(str);
        aEe.gCC.clear();
        aEe.gCC.addAll(a2);
        boolean a3 = eit2.a(str, aEe);
        long j4 = linkedList.getLast().field_msgSeq;
        long j5 = linkedList.getLast().field_createTime;
        long aEb = eit2.aEb(str);
        Log.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", Integer.valueOf(aEe.gCC.size()), Boolean.valueOf(a3), Long.valueOf(j4), Long.valueOf(aEb), Long.valueOf(j5), Long.valueOf(eit2.aEd(str)));
        if (aEb < j4) {
            eit2.aE(str, j4);
            eit2.aC(str, j5);
        } else {
            Log.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", Long.valueOf(aEb), Long.valueOf(j4));
        }
        d(new HashMap(this.iWe), str);
        AppMethodBeat.o(20507);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, final Object obj) {
        AppMethodBeat.i(20508);
        if (mStorageEx == ((l) g.af(l.class)).aST() && (obj instanceof String) && 5 == i2) {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.as.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(231541);
                    com.tencent.mm.plugin.messenger.foundation.a.a.b eit = ((l) g.af(l.class)).eit();
                    String str = (String) obj;
                    if (eit.aEf(str)) {
                        aj aEh = eit.aEh(str);
                        if (aEh.field_seqBlockInfo != null) {
                            aEh.field_seqBlockInfo.gCC.clear();
                        }
                        aEh.field_lastLocalSeq = aEh.field_lastPushSeq;
                        aEh.field_lastLocalCreateTime = aEh.field_lastPushCreateTime;
                        Log.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + str + " ret:" + eit.b(aEh) + " chatroomMsgSeq:" + aEh.toString());
                    }
                    AppMethodBeat.o(231541);
                }
            });
        }
        AppMethodBeat.o(20508);
    }

    private static List<com.tencent.mm.k.a.a.c> a(String str, LinkedList<ca> linkedList) {
        AppMethodBeat.i(20509);
        com.tencent.mm.plugin.messenger.foundation.a.a.b eit = ((l) g.af(l.class)).eit();
        d aEe = eit.aEe(str);
        StringBuilder sb = new StringBuilder();
        sb.append("\nchatroomId:").append(str);
        long j2 = linkedList.getFirst().field_msgSeq;
        long j3 = linkedList.getLast().field_msgSeq;
        long j4 = linkedList.getFirst().field_createTime;
        long j5 = linkedList.getLast().field_createTime;
        sb.append("\ngetFirst:").append(j2);
        sb.append(" getLast:").append(j3);
        sb.append(" getFirstCreateTime:").append(j4);
        sb.append(" getLastCreateTime:").append(j5);
        sb.append("\nblock ");
        com.tencent.mm.k.a.a.c cVar = new com.tencent.mm.k.a.a.c();
        cVar.gCy = eit.aEb(str) + 1;
        cVar.gCA = eit.aEd(str) + 1;
        cVar.gCz = eit.aEa(str);
        cVar.gCB = eit.aEc(str);
        if (cVar.gCz - cVar.gCy >= 0) {
            aEe.gCC.add(cVar);
        } else {
            Log.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", Long.valueOf(cVar.gCz), Long.valueOf(cVar.gCy));
        }
        LinkedList<com.tencent.mm.k.a.a.c> linkedList2 = new LinkedList();
        Iterator<com.tencent.mm.k.a.a.c> it = aEe.gCC.iterator();
        while (it.hasNext()) {
            com.tencent.mm.k.a.a.c next = it.next();
            boolean z = false;
            long j6 = next.gCy;
            long j7 = next.gCz;
            long j8 = next.gCA;
            long j9 = next.gCB;
            sb.append("[").append(j6).append(":").append(j7).append("][").append(j8).append(":").append(j9).append("] | ");
            if (j6 <= j2 && j2 <= j7) {
                com.tencent.mm.k.a.a.c cVar2 = new com.tencent.mm.k.a.a.c();
                cVar2.gCy = next.gCy;
                cVar2.gCz = j2 - 1;
                cVar2.gCA = j8;
                cVar2.gCB = j4 - 1;
                if (cVar2.gCz - cVar2.gCy >= 0) {
                    linkedList2.add(cVar2);
                    z = true;
                }
            }
            if (j6 <= j3 && j3 <= j7) {
                com.tencent.mm.k.a.a.c cVar3 = new com.tencent.mm.k.a.a.c();
                cVar3.gCy = 1 + j3;
                cVar3.gCz = j7;
                cVar3.gCA = 1 + j5;
                cVar3.gCB = j9;
                if (cVar3.gCz - cVar3.gCy >= 0) {
                    linkedList2.add(cVar3);
                    z = true;
                }
            }
            if (!z && (j2 > j7 || j3 < j6)) {
                linkedList2.add(next);
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (com.tencent.mm.k.a.a.c cVar4 : linkedList2) {
            sb2.append("[").append(cVar4.gCy).append(":").append(cVar4.gCz).append("][").append(cVar4.gCA).append(":").append(cVar4.gCB).append("] | ");
        }
        Log.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + sb.toString() + "\nnew blockList:" + sb2.toString());
        AppMethodBeat.o(20509);
        return linkedList2;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(20510);
        if (!af.isNullOrNil(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                bt btVar = new bt();
                btVar.field_originSvrId = longValue;
                p.bdT();
                if (p.bdR().get(btVar, new String[0])) {
                    this.iWe.put(Long.valueOf(longValue), btVar);
                    Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", Long.valueOf(btVar.systemRowid), Long.valueOf(longValue));
                    AppMethodBeat.o(20510);
                    return;
                }
                this.iWe.remove(Long.valueOf(longValue));
                Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", Long.valueOf(longValue));
                AppMethodBeat.o(20510);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", e2, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
            }
        }
        AppMethodBeat.o(20510);
    }

    private static void d(Map<Long, bt> map, String str) {
        AppMethodBeat.i(20511);
        if (map.size() == 0 || af.isNullOrNil(str)) {
            AppMethodBeat.o(20511);
            return;
        }
        Iterator<bt> it = map.values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                bt next = it.next();
                if (next != null && str.equals(next.field_fromUserName)) {
                    bg.aVF();
                    ca aJ = com.tencent.mm.model.c.aSQ().aJ(str, next.field_originSvrId);
                    if (aJ.field_msgId != 0) {
                        Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", Long.valueOf(aJ.field_msgId), Long.valueOf(aJ.field_msgSvrId));
                        de deVar = new de();
                        deVar.Brn = next.field_newMsgId;
                        deVar.KHl = z.Su(next.field_fromUserName);
                        deVar.KHm = z.Su(next.field_toUserName);
                        deVar.CreateTime = (int) next.field_createTime;
                        deVar.KHn = z.Su(next.field_content);
                        deVar.KHq = next.field_msgSource;
                        deVar.KHs = next.field_msgSeq;
                        int i2 = next.field_flag;
                        deVar.xKb = 10002;
                        bg.getSysCmdMsgExtension().b(new h.a(deVar, (i2 & 2) != 0, (i2 & 1) != 0, (i2 & 4) != 0));
                    }
                }
            }
        }
        AppMethodBeat.o(20511);
    }

    static class a implements Runnable {
        ux iWg;

        /* synthetic */ a(ux uxVar, byte b2) {
            this(uxVar);
        }

        private a(ux uxVar) {
            this.iWg = uxVar;
        }

        public final void run() {
            ca caVar;
            long j2;
            long j3;
            long j4;
            long j5;
            boolean z;
            az azVar;
            int i2;
            Map<String, String> parseXml;
            String str;
            String str2;
            AppMethodBeat.i(20505);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (!g.aAc()) {
                    Log.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
                } else {
                    byte[] bArr = this.iWg.ebm.data;
                    if (bArr != null) {
                        df dfVar = new df();
                        try {
                            dfVar.parseFrom(bArr);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", e2, "", new Object[0]);
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String a2 = z.a(dfVar.KHt);
                        int i3 = dfVar.KHs;
                        long j6 = 1000 * ((long) dfVar.CreateTime);
                        com.tencent.mm.plugin.messenger.foundation.a.a.b eit = ((l) g.af(l.class)).eit();
                        if (eit.aEf(a2)) {
                            Log.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", a2, Integer.valueOf(i3), Boolean.valueOf(eit.aB(a2, (long) i3)), Long.valueOf(j6), Boolean.valueOf(eit.aD(a2, j6)));
                        } else {
                            ca aEz = ((l) g.af(l.class)).eiy().aEz(a2);
                            if (aEz == null || aEz.field_msgId != 0) {
                                caVar = aEz;
                            } else {
                                Log.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
                                caVar = null;
                            }
                            if (caVar != null) {
                                Log.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", Util.secPrint(caVar.field_content), f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, caVar.field_createTime / 1000));
                            }
                            aj ajVar = new aj();
                            ajVar.field_username = a2;
                            ajVar.field_lastPushSeq = (long) i3;
                            if (caVar != null) {
                                j2 = caVar.field_msgSeq;
                            } else {
                                j2 = (long) (i3 - 1);
                            }
                            ajVar.field_lastLocalSeq = j2;
                            ajVar.field_lastPushCreateTime = j6;
                            if (caVar != null) {
                                j3 = caVar.field_createTime;
                            } else {
                                j3 = j6 - 1;
                            }
                            ajVar.field_lastLocalCreateTime = j3;
                            Object[] objArr = new Object[6];
                            objArr[0] = Long.valueOf(eit.a(ajVar));
                            objArr[1] = a2;
                            objArr[2] = Integer.valueOf(i3);
                            objArr[3] = Long.valueOf(j6);
                            if (caVar != null) {
                                j4 = caVar.field_msgSeq;
                            } else {
                                j4 = (long) (i3 - 1);
                            }
                            objArr[4] = Long.valueOf(j4);
                            if (caVar != null) {
                                j5 = caVar.field_createTime;
                            } else {
                                j5 = j6 - 1;
                            }
                            objArr[5] = Long.valueOf(j5);
                            Log.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", objArr);
                            com.tencent.mm.ui.chatting.l.c cVar = com.tencent.mm.ui.chatting.l.c.PEZ;
                            com.tencent.mm.ui.chatting.l.c.gTH();
                        }
                        Log.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - currentTimeMillis2));
                        long currentTimeMillis3 = System.currentTimeMillis();
                        String a3 = z.a(dfVar.KHt);
                        int i4 = dfVar.KHs;
                        long j7 = dfVar.Brn;
                        int i5 = dfVar.CreateTime;
                        int i6 = dfVar.KHw;
                        int i7 = dfVar.xKb;
                        int i8 = dfVar.KHu;
                        String a4 = z.a(dfVar.KHv);
                        Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", a3, Long.valueOf(j7), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Integer.valueOf(i7), Integer.valueOf(i8), Util.secPrint(a4));
                        az bjY = ((l) g.af(l.class)).aST().bjY(a3);
                        if (bjY == null) {
                            az azVar2 = new az(a3);
                            azVar2.yA(((long) i5) * 1000);
                            azVar2.yC((long) i4);
                            azVar2.nt(1);
                            azVar2.nA(1);
                            b.bch();
                            b.Om(a3);
                            long aEj = ((l) g.af(l.class)).aTq().aEj(a3);
                            Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", Long.valueOf(aEj), Integer.valueOf(i4));
                            if (aEj <= 0) {
                                aEj = (long) i4;
                            }
                            azVar2.yD(aEj);
                            z = true;
                            azVar = azVar2;
                        } else {
                            int i9 = (int) bjY.field_lastSeq;
                            if (i4 > i9) {
                                bjY.yC((long) i4);
                                int i10 = bjY.field_UnDeliverCount;
                                bjY.nA(i8);
                                bjY.yA(((long) i5) * 1000);
                                if (i8 > bjY.field_unReadCount) {
                                    i2 = i8;
                                } else {
                                    i2 = (i8 - i10) + bjY.field_unReadCount;
                                }
                                if (i2 < 0) {
                                    Log.e("MicroMsg.GetChatroomMsgReceiver", "why???, unreadCount %d", Integer.valueOf(i2));
                                    i2 = 0;
                                }
                                bjY.nt(i2);
                                long j8 = bjY.field_firstUnDeliverSeq;
                                Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", Integer.valueOf(i4), Long.valueOf(j8), Integer.valueOf(i9));
                                if (j8 > 0) {
                                    ca aK = ((l) g.af(l.class)).eiy().aK(a3, (long) i9);
                                    if (aK.field_msgId > 0) {
                                        bjY.yD(aK.field_msgSeq);
                                    }
                                    z = false;
                                    azVar = bjY;
                                } else {
                                    long aEj2 = ((l) g.af(l.class)).aTq().aEj(a3);
                                    if (aEj2 > 0) {
                                        bjY.yD(aEj2);
                                        z = false;
                                        azVar = bjY;
                                    } else {
                                        long aER = ((l) g.af(l.class)).eiy().aER(a3);
                                        Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", Long.valueOf(aER));
                                        if (aER > 0) {
                                            bjY.yD(aER);
                                        }
                                        z = false;
                                        azVar = bjY;
                                    }
                                }
                            } else {
                                if (i4 == i9 && i8 == 0 && bjY.field_unReadCount > 0) {
                                    bjY.nt(0);
                                }
                                z = false;
                                azVar = bjY;
                            }
                        }
                        if (i6 > 0) {
                            azVar.ny(azVar.field_atCount + i6);
                        }
                        ca caVar2 = new ca();
                        caVar2.nv(0);
                        caVar2.Cy(a3);
                        caVar2.setType(i7);
                        caVar2.setContent(a4);
                        if (i7 == 49) {
                            k.b HD = k.b.HD(com.tencent.mm.pluginsdk.model.app.k.mx(a3, a4));
                            caVar2.setType(m.g(HD));
                            caVar2.setContent(caVar2.gAt() ? HD.content : a4);
                        } else if (i7 == 10002) {
                            ((s) g.ah(s.class)).getSysCmdMsgExtension();
                            if (caVar2.getType() == 10002 && !Util.isNullOrNil(a4)) {
                                if (Util.isNullOrNil(a4)) {
                                    Log.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                                } else {
                                    if (a4.startsWith(SemiXml.MAGIC_HEAD)) {
                                        Map<String, String> decode = SemiXml.decode(a4);
                                        if (decode == null) {
                                            Log.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a4);
                                        } else {
                                            str = "brand_service";
                                            parseXml = decode;
                                        }
                                    } else {
                                        int indexOf = a4.indexOf("<sysmsg");
                                        if (indexOf == -1) {
                                            Log.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                                        } else {
                                            parseXml = XmlParser.parseXml(a4.substring(indexOf), "sysmsg", null);
                                            if (parseXml == null) {
                                                Log.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a4);
                                            } else {
                                                str = parseXml.get(".sysmsg.$type");
                                            }
                                        }
                                    }
                                    if (str != null && str.equals("revokemsg")) {
                                        Log.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                                        parseXml.get(".sysmsg.revokemsg.session");
                                        String str3 = parseXml.get(".sysmsg.revokemsg.replacemsg");
                                        Log.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", parseXml.get(".sysmsg.revokemsg.newmsgid"), str3);
                                        caVar2.setContent(str3);
                                        caVar2.setType(10000);
                                    }
                                }
                            }
                        }
                        azVar.nv(0);
                        azVar.setContent(caVar2.field_content);
                        azVar.Cl(Integer.toString(caVar2.getType()));
                        bw.b Xh = ((l) g.af(l.class)).aST().Xh();
                        if (Xh != null) {
                            PString pString = new PString();
                            PString pString2 = new PString();
                            PInt pInt = new PInt();
                            Xh.a(caVar2, pString, pString2, pInt, false);
                            azVar.Cm(pString.value);
                            azVar.Cn(pString2.value);
                            azVar.nw(pInt.value);
                            if (caVar2.getType() == 49) {
                                String str4 = XmlParser.parseXml(azVar.field_content, "msg", null).get(".msg.appmsg.title");
                                String nullAsNil = Util.nullAsNil(azVar.field_digest);
                                if (Util.isNullOrNil(str4)) {
                                    str2 = "";
                                } else {
                                    str2 = " " + Util.nullAsNil(str4);
                                }
                                azVar.Cm(nullAsNil.concat(str2));
                            }
                        } else {
                            azVar.Cm(azVar.field_content);
                        }
                        if (z) {
                            Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", a3, Long.valueOf(((l) g.af(l.class)).aST().e(azVar)), Long.valueOf(azVar.field_firstUnDeliverSeq), Long.valueOf(azVar.field_lastSeq), Integer.valueOf(azVar.field_UnDeliverCount));
                        } else {
                            azVar.nx(azVar.field_attrflag & -1048577);
                            Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", a3, Long.valueOf((long) ((l) g.af(l.class)).aST().a(azVar, a3, true)), Long.valueOf(azVar.field_firstUnDeliverSeq), Long.valueOf(azVar.field_lastSeq), Integer.valueOf(azVar.field_UnDeliverCount));
                        }
                        Log.d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - currentTimeMillis3));
                    } else {
                        Log.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
                    }
                }
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", e3, "", new Object[0]);
            }
            Log.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(20505);
        }
    }
}
