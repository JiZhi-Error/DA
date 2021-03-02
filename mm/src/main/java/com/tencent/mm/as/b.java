package com.tencent.mm.as;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.q;
import com.tencent.mm.k.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.notification.e;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class b implements aa.a {
    private static e iVZ = new e(true);
    private static b iWb;
    public a iVW;
    private q iVX;
    private ConcurrentLinkedDeque<d> iVY = new ConcurrentLinkedDeque<>();
    private AbstractC0268b iWa = new AbstractC0268b() {
        /* class com.tencent.mm.as.b.AnonymousClass1 */

        @Override // com.tencent.mm.as.b.AbstractC0268b
        public final void b(int i2, List<ca> list) {
            AppMethodBeat.i(231540);
            Log.w("MicroMsg.GetChatroomMsgFetcher", "[onFinish] ret:" + i2 + " addSize:" + list.size());
            AppMethodBeat.o(231540);
        }
    };
    private volatile boolean isRunning = false;

    public interface a {
        void a(String str, boolean z, LinkedList<ca> linkedList, c cVar, boolean z2);
    }

    /* renamed from: com.tencent.mm.as.b$b  reason: collision with other inner class name */
    public interface AbstractC0268b {
        void b(int i2, List<ca> list);
    }

    static {
        AppMethodBeat.i(AccountTransferStatusCodes.INVALID_REQUEST);
        AppMethodBeat.o(AccountTransferStatusCodes.INVALID_REQUEST);
    }

    private b() {
        AppMethodBeat.i(20492);
        AppMethodBeat.o(20492);
    }

    public static b bch() {
        AppMethodBeat.i(20493);
        if (iWb == null) {
            synchronized (b.class) {
                try {
                    if (iWb == null) {
                        iWb = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(20493);
                    throw th;
                }
            }
        }
        b bVar = iWb;
        AppMethodBeat.o(20493);
        return bVar;
    }

    public final void a(String str, long j2, long j3, int i2, AbstractC0268b bVar) {
        AppMethodBeat.i(20494);
        Log.i("MicroMsg.GetChatroomMsgFetcher", "[fetch] chatroomId:" + str + " msgSeq:" + j2 + " filterSeq:" + j3 + " upDownFlag:" + i2 + " isRunning=" + this.isRunning);
        this.iWa = bVar;
        bla bla = new bla();
        bla.LTV = z.Su(str);
        bla.KHs = (int) j2;
        bla.LTZ = (int) j3;
        bla.LTW = 18;
        bla.LTX = i2;
        d.a aVar = new d.a();
        aVar.iLN = bla;
        aVar.iLO = new blb();
        aVar.uri = "/cgi-bin/micromsg-bin/getcrmsg";
        aVar.funcId = TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_RETURN_CANNOT_OPEN;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        if (this.isRunning) {
            this.iVY.add(aVar.aXF());
            AppMethodBeat.o(20494);
            return;
        }
        this.isRunning = true;
        this.iVX = aa.a(aVar.aXF(), this, true);
        AppMethodBeat.o(20494);
    }

    public final void cancel() {
        AppMethodBeat.i(20495);
        Log.i("MicroMsg.GetChatroomMsgFetcher", "[cancel]...");
        this.isRunning = false;
        this.iVY.clear();
        if (this.iVX != null) {
            aa.a(this.iVX);
            a((d) null, -1, new LinkedList<>());
        }
        this.iWa = null;
        AppMethodBeat.o(20495);
    }

    @Override // com.tencent.mm.ak.aa.a
    public final int a(int i2, int i3, String str, d dVar, q qVar) {
        boolean z;
        boolean z2;
        int i4;
        ca caVar;
        AppMethodBeat.i(20496);
        Log.i("MicroMsg.GetChatroomMsgFetcher", "[callback] errType:%d errCode:%d errMsg:%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.iVX = null;
        try {
            LinkedList<ca> linkedList = new LinkedList<>();
            if (qVar.getType() != 805) {
                a(dVar, -1, linkedList);
                d poll = this.iVY.poll();
                if (poll != null) {
                    Log.i("MicroMsg.GetChatroomMsgFetcher", "do next next... %s", Integer.valueOf(this.iVY.size()));
                    this.isRunning = true;
                    this.iVX = aa.a(poll, this, true);
                } else {
                    this.isRunning = false;
                }
                AppMethodBeat.o(20496);
                return 0;
            } else if (i2 == 0 && i3 == 0 && dVar != null) {
                bla bla = (bla) dVar.iLK.iLR;
                blb blb = (blb) dVar.iLL.iLR;
                if (blb == null || blb.LUa == null) {
                    a(dVar, -1, linkedList);
                    Object[] objArr = new Object[2];
                    if (blb == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    if (blb.LUa == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[1] = Boolean.valueOf(z2);
                    Log.e("MicroMsg.GetChatroomMsgFetcher", "[callback] resp == null? %b resp.AddMsgList == null? %b", objArr);
                    d poll2 = this.iVY.poll();
                    if (poll2 != null) {
                        Log.i("MicroMsg.GetChatroomMsgFetcher", "do next next... %s", Integer.valueOf(this.iVY.size()));
                        this.isRunning = true;
                        this.iVX = aa.a(poll2, this, true);
                    } else {
                        this.isRunning = false;
                    }
                    AppMethodBeat.o(20496);
                    return 0;
                } else if (blb.LUa.size() <= 0) {
                    Log.w("MicroMsg.GetChatroomMsgFetcher", "[callback] fetch size is 0! [%s:%s] isUpFlag:%s ChatroomId:%s", Integer.valueOf(bla.KHs), Integer.valueOf(bla.LTZ), Integer.valueOf(bla.LTX), z.a(bla.LTV));
                    a(dVar, 0, linkedList);
                    d poll3 = this.iVY.poll();
                    if (poll3 != null) {
                        Log.i("MicroMsg.GetChatroomMsgFetcher", "do next next... %s", Integer.valueOf(this.iVY.size()));
                        this.isRunning = true;
                        this.iVX = aa.a(poll3, this, true);
                    } else {
                        this.isRunning = false;
                    }
                    AppMethodBeat.o(20496);
                    return 0;
                } else {
                    try {
                        k kVar = (k) g.af(k.class);
                        ((l) g.af(l.class)).eiy().aEs("MicroMsg.GetChatroomMsgFetcher" + hashCode());
                        Iterator<h.a> it = a(blb.LUa, bla.LTX == 1, z.a(bla.LTV)).iterator();
                        while (it.hasNext()) {
                            h.a next = it.next();
                            h.b processAddMsg = kVar.processAddMsg(next, iVZ);
                            if (processAddMsg == null) {
                                de deVar = next.heO;
                                ca caVar2 = new ca();
                                caVar2.yF(deVar.Brn);
                                caVar2.setCreateTime(next.iLY);
                                caVar2.yH((long) deVar.KHs);
                                String a2 = z.a(deVar.KHl);
                                String a3 = z.a(deVar.KHm);
                                if (((l) g.af(l.class)).aSW().has(a2) || ((String) g.aAh().azQ().get(2, "")).equals(a2)) {
                                    caVar2.nv(1);
                                    caVar2.Cy(a3);
                                    i4 = deVar.oTW;
                                    caVar = caVar2;
                                } else {
                                    caVar2.nv(0);
                                    caVar2.Cy(a2);
                                    if (deVar.oTW > 3) {
                                        i4 = deVar.oTW;
                                        caVar = caVar2;
                                    } else {
                                        i4 = 3;
                                        caVar = caVar2;
                                    }
                                }
                                caVar.setStatus(i4);
                                if (deVar.xKb == 10000) {
                                    caVar2.setStatus(4);
                                }
                                caVar2.setFlag(2);
                                linkedList.add(caVar2);
                                Log.i("MicroMsg.GetChatroomMsgFetcher", "addMsgReturn == null! addMsgInfo addMsg type:%s", Integer.valueOf(next.heO.xKb));
                            } else if (processAddMsg.dCM == null) {
                                Log.e("MicroMsg.GetChatroomMsgFetcher", "ddMsgReturn.msg == null！may be revoke msg");
                            } else {
                                linkedList.add(processAddMsg.dCM);
                            }
                        }
                        ((l) g.af(l.class)).eiy().aEt("MicroMsg.GetChatroomMsgFetcher" + hashCode());
                        Log.i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + z.a(bla.LTV) + " AddMsgList size:" + blb.LUa.size());
                        a(dVar, 0, linkedList);
                        d poll4 = this.iVY.poll();
                        if (poll4 != null) {
                            Log.i("MicroMsg.GetChatroomMsgFetcher", "do next next... %s", Integer.valueOf(this.iVY.size()));
                            this.isRunning = true;
                            this.iVX = aa.a(poll4, this, true);
                        } else {
                            this.isRunning = false;
                        }
                        AppMethodBeat.o(20496);
                        return 0;
                    } catch (Throwable th) {
                        ((l) g.af(l.class)).eiy().aEt("MicroMsg.GetChatroomMsgFetcher" + hashCode());
                        Log.i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + z.a(bla.LTV) + " AddMsgList size:" + blb.LUa.size());
                        a(dVar, 0, linkedList);
                        AppMethodBeat.o(20496);
                        throw th;
                    }
                }
            } else {
                a(dVar, -1, linkedList);
                d poll5 = this.iVY.poll();
                if (poll5 != null) {
                    Log.i("MicroMsg.GetChatroomMsgFetcher", "do next next... %s", Integer.valueOf(this.iVY.size()));
                    this.isRunning = true;
                    this.iVX = aa.a(poll5, this, true);
                } else {
                    this.isRunning = false;
                }
                AppMethodBeat.o(20496);
                return 0;
            }
        } catch (Throwable th2) {
            d poll6 = this.iVY.poll();
            if (poll6 != null) {
                Log.i("MicroMsg.GetChatroomMsgFetcher", "do next next... %s", Integer.valueOf(this.iVY.size()));
                this.isRunning = true;
                this.iVX = aa.a(poll6, this, true);
            } else {
                this.isRunning = false;
            }
            AppMethodBeat.o(20496);
            throw th2;
        }
    }

    private void a(d dVar, int i2, LinkedList<ca> linkedList) {
        AppMethodBeat.i(20497);
        Log.w("MicroMsg.GetChatroomMsgFetcher", "[requestCallback] ret:".concat(String.valueOf(i2)));
        if (dVar == null) {
            com.tencent.mm.ui.chatting.l.c cVar = com.tencent.mm.ui.chatting.l.c.PEZ;
            com.tencent.mm.ui.chatting.l.c.gTI();
            if (this.iWa != null) {
                this.iWa.b(i2, linkedList);
                this.iWa = null;
            }
            AppMethodBeat.o(20497);
            return;
        }
        bla bla = (bla) dVar.iLK.iLR;
        blb blb = (blb) dVar.iLL.iLR;
        if (this.iVW != null && i2 >= 0) {
            this.iVW.a(z.a(bla.LTV), bla.LTX == 1, linkedList, B((long) bla.LTZ, (long) bla.KHs), blb.KZh == 0);
        }
        if (this.iWa != null) {
            this.iWa.b(i2, linkedList);
            this.iWa = null;
        }
        com.tencent.mm.ui.chatting.l.c.PEZ.f(bla.LTX == 0, i2 >= 0, z.a(bla.LTV));
        if (i2 >= 0) {
            com.tencent.mm.ui.chatting.l.c.PEZ.anx(linkedList.size());
        }
        AppMethodBeat.o(20497);
    }

    private static LinkedList<h.a> a(List<de> list, boolean z, String str) {
        h.a aVar;
        AppMethodBeat.i(20498);
        long aEk = ((l) g.af(l.class)).aTq().aEk(str);
        LinkedList<h.a> linkedList = new LinkedList<>();
        long j2 = 0;
        for (de deVar : list) {
            long j3 = ((long) deVar.CreateTime) * 1000;
            if (j2 == 0) {
                ca aP = ((l) g.af(l.class)).eiy().aP(z.a(deVar.KHl), (long) deVar.KHs);
                if (aP.field_createTime / 1000 == ((long) deVar.CreateTime)) {
                    j3 = aP.field_createTime + 1;
                }
            }
            if (j2 / 1000 == j3 / 1000) {
                long j4 = 1 + j2;
                aVar = new h.a(deVar, z, j4);
                j2 = j4;
            } else {
                aVar = new h.a(deVar, z, j3);
                j2 = j3;
            }
            if (aEk < j2) {
                linkedList.add(aVar);
            } else {
                Log.w("MicroMsg.GetChatroomMsgFetcher", "this conversation[%s] has delete before! lastDeleteCreateTime:%s curTime:%s", str, Long.valueOf(aEk), Long.valueOf(j2));
            }
        }
        AppMethodBeat.o(20498);
        return linkedList;
    }

    private static c B(long j2, long j3) {
        long j4;
        long j5;
        AppMethodBeat.i(20499);
        if (j2 > j3) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        c cVar = new c();
        cVar.gCy = j5;
        cVar.gCz = j4;
        AppMethodBeat.o(20499);
        return cVar;
    }

    public static void Om(String str) {
        AppMethodBeat.i(AccountTransferStatusCodes.NOT_ALLOWED_SECURITY);
        if (((l) g.af(l.class)).eit().aEf(str)) {
            Log.i("MicroMsg.GetChatroomMsgFetcher", "[clearConversationDeliverCount] username:%s", str);
            bla bla = new bla();
            bla.LTV = z.Su(str);
            bla.KHs = 0;
            bla.LTZ = 0;
            bla.LTW = 0;
            bla.LTX = 0;
            d.a aVar = new d.a();
            aVar.iLN = bla;
            aVar.iLO = new blb();
            aVar.uri = "/cgi-bin/micromsg-bin/getcrmsg";
            aVar.funcId = TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_RETURN_CANNOT_OPEN;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            aa.d(aVar.aXF());
        }
        AppMethodBeat.o(AccountTransferStatusCodes.NOT_ALLOWED_SECURITY);
    }
}
