package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    q zHj = null;
    MultiTalkGroup zHk = null;
    Map<String, Long> zHl = new ConcurrentHashMap();

    public d(q qVar) {
        AppMethodBeat.i(239006);
        this.zHj = qVar;
        AppMethodBeat.o(239006);
    }

    static MultiTalkGroup a(k kVar) {
        AppMethodBeat.i(239007);
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.RGY = new StringBuilder().append(kVar.zHB).toString();
        multiTalkGroup.zHE = kVar.zHD;
        multiTalkGroup.RGZ = kVar.zHG == null ? "" : kVar.zHG;
        multiTalkGroup.zHD = kVar.zHD;
        ArrayList<j> arrayList = kVar.zHF;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                j next = it.next();
                MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                multiTalkGroupMember.RHb = next.goe;
                multiTalkGroupMember.RHc = next.zHx;
                multiTalkGroupMember.bDZ = next.zHy;
                multiTalkGroupMember.status = 20;
                if (next.mStatus == 1) {
                    multiTalkGroupMember.status = 10;
                }
                if (next.mStatus == 2 || next.mStatus == 3) {
                    multiTalkGroupMember.status = 1;
                }
                multiTalkGroupMember.RGf = (int) next.zHz;
                multiTalkGroup.RHa.add(multiTalkGroupMember);
            }
        }
        AppMethodBeat.o(239007);
        return multiTalkGroup;
    }

    public final void b(final k kVar) {
        AppMethodBeat.i(239008);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.b.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(238996);
                if (d.this.zHj != null) {
                    d.this.zHj.d(d.a(kVar));
                }
                AppMethodBeat.o(238996);
            }
        });
        AppMethodBeat.o(239008);
    }

    public final void bH(final int i2, final String str) {
        AppMethodBeat.i(239009);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.b.d.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(239001);
                if (d.this.zHj != null) {
                    int i2 = i2;
                    switch (i2) {
                        case 2:
                            i2 = -200;
                            break;
                        case 3:
                            i2 = -400;
                            break;
                        case 4:
                            i2 = -500;
                            break;
                        case 5:
                            i2 = -300;
                            break;
                        case 8:
                            i2 = -600;
                            break;
                        case 9:
                            i2 = -1000;
                            break;
                        case 10:
                            i2 = -1100;
                            break;
                        case 11:
                            i2 = -1300;
                            break;
                        case 15:
                            i2 = -301;
                            break;
                        case 16:
                            i2 = -100;
                            break;
                    }
                    Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onErr errorcode:%d, errType:%d", Integer.valueOf(i2), Integer.valueOf(i2));
                    d.this.zHj.n(i2, str);
                }
                AppMethodBeat.o(239001);
            }
        });
        AppMethodBeat.o(239009);
    }

    public final void c(final k kVar) {
        AppMethodBeat.i(239010);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.b.d.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(239004);
                if (d.this.zHj != null) {
                    Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onEnterMultiTalk");
                    d.this.zHj.e(d.a(kVar));
                }
                AppMethodBeat.o(239004);
            }
        });
        AppMethodBeat.o(239010);
    }

    public final void d(final k kVar) {
        AppMethodBeat.i(239011);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.b.d.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(239005);
                if (d.this.zHj != null) {
                    Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onInviteOrAcceptTimeout");
                    d.this.zHj.c(d.a(kVar));
                }
                AppMethodBeat.o(239005);
            }
        });
        AppMethodBeat.o(239011);
    }

    public final void a(k kVar, LinkedList<acq> linkedList) {
        AppMethodBeat.i(239012);
        if (this.zHj != null) {
            final ArrayList arrayList = new ArrayList();
            if (linkedList != null && linkedList.size() > 0) {
                Iterator<acq> it = linkedList.iterator();
                while (it.hasNext()) {
                    acq next = it.next();
                    String QX = kVar.QX(next.Lnt);
                    if (QX == null) {
                        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange: mid:%d NOT exist!!!", Integer.valueOf(next.Lnt));
                    } else {
                        a.as asVar = new a.as();
                        asVar.qrD = next.Lnt;
                        asVar.KBb = next.Lnt;
                        asVar.videoStatus = 1;
                        if ((next.Lnu & 2) != 0) {
                            asVar.videoStatus = 3;
                        }
                        asVar.dLN = QX;
                        asVar.RFm = 100;
                        if ((next.Lnu & 4) == 0) {
                            asVar.RFm = 103;
                        } else if ((next.Lnu & 8) != 0) {
                            asVar.RFm = 102;
                        } else {
                            asVar.RFm = 101;
                        }
                        arrayList.add(asVar);
                        kVar.hf(next.Lnt, asVar.RFm);
                    }
                }
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.multitalk.b.d.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(238997);
                    if (d.this.zHj != null) {
                        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange:%s", arrayList);
                        d.this.zHj.fz(arrayList);
                    }
                    AppMethodBeat.o(238997);
                }
            });
        }
        AppMethodBeat.o(239012);
    }
}
