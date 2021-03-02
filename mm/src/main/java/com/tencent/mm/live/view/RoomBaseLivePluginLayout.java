package com.tencent.mm.live.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.b.a;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.b.q;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.s;
import com.tencent.mm.live.b.v;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020%H\u0017J\b\u0010&\u001a\u00020\fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mVoipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "multiTalkActionListener", "mount", "", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAnchorConnectionChange", "", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLive", "Lcom/tencent/mm/live/model/CloseLiveInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onFinderLiveAcceptLiveMic", "Lcom/tencent/mm/live/model/FinderLiveAcceptLiveMicInfo;", "onFinderLiveApplyLiveMic", "Lcom/tencent/mm/live/model/FinderLiveApplyLiveMicInfo;", "onFinderLiveCloseLiveMic", "Lcom/tencent/mm/live/model/FinderLiveCloseLiveMicInfo;", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "unMount", "plugin-logic_release"})
public abstract class RoomBaseLivePluginLayout extends BaseLivePluginLayout {
    private final IListener<zj> hXm = new a(this);
    private final IListener<?> hXn = new b(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomBaseLivePluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/view/RoomBaseLivePluginLayout$mVoipCallEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-logic_release"})
    public static final class a extends IListener<zj> {
        final /* synthetic */ RoomBaseLivePluginLayout hXo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(RoomBaseLivePluginLayout roomBaseLivePluginLayout) {
            this.hXo = roomBaseLivePluginLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(208642);
            zj zjVar2 = zjVar;
            p.h(zjVar2, "event");
            if (!g.aAc()) {
                AppMethodBeat.o(208642);
                return false;
            }
            if (zjVar2.efx.dKy == 3 && !com.tencent.mm.q.a.atu()) {
                Bundle bundle = new Bundle();
                bundle.putInt("voipEvent", 3);
                this.hXo.statusChange(b.c.hMB, bundle);
            }
            AppMethodBeat.o(208642);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/view/RoomBaseLivePluginLayout$multiTalkActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MultiTalkActionEvent;", "callback", "", "event", "plugin-logic_release"})
    public static final class b extends IListener<mu> {
        final /* synthetic */ RoomBaseLivePluginLayout hXo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(RoomBaseLivePluginLayout roomBaseLivePluginLayout) {
            this.hXo = roomBaseLivePluginLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mu muVar) {
            AppMethodBeat.i(208643);
            mu muVar2 = muVar;
            p.h(muVar2, "event");
            if (muVar2.dSs.action == 3 && !com.tencent.mm.q.a.atu()) {
                Bundle bundle = new Bundle();
                bundle.putInt("voipEvent", 3);
                this.hXo.statusChange(b.c.hMB, bundle);
            }
            AppMethodBeat.o(208643);
            return false;
        }
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public void mount() {
        super.mount();
        s sVar = s.hIl;
        s.a(this);
        this.hXm.alive();
        this.hXn.alive();
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public void unMount() {
        super.unMount();
        s sVar = s.hIl;
        s.release();
        this.hXm.dead();
        this.hXn.dead();
    }

    @Override // com.tencent.mm.live.b.j
    public void onAnchorConnectionChange(boolean z) {
    }

    @Override // com.tencent.mm.live.b.j
    public void onFinderLiveApplyLiveMic(h hVar) {
        p.h(hVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onFinderLiveAcceptLiveMic(com.tencent.mm.live.b.g gVar) {
        p.h(gVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onFinderLiveCloseLiveMic(i iVar) {
        p.h(iVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onApplyLiveMic(com.tencent.mm.live.b.b bVar) {
        p.h(bVar, "info");
        long j2 = bVar.liveId;
        String str = bVar.hFz;
        if (str == null) {
            str = "";
        }
        String str2 = bVar.hFF;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = bVar.roomId;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = bVar.hFG;
        if (str4 == null) {
            str4 = "";
        }
        x xVar = x.hJf;
        com.tencent.mm.live.b.b.a aHa = x.aHa();
        a.C0371a aVar = new a.C0371a(j2, str, str2, str3, str4);
        p.h(aVar, "liveMicUser");
        com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sysmsg]anchor receive mic ".concat(String.valueOf(aVar)));
        x xVar2 = x.hJf;
        if (x.aGr().hyH == aVar.liveId) {
            for (T t : aHa.hKT) {
                if (p.j(t.hFG, aVar.hFG)) {
                    String str5 = aVar.hFz;
                    p.h(str5, "<set-?>");
                    t.hFz = str5;
                    String str6 = aVar.roomId;
                    p.h(str6, "<set-?>");
                    t.roomId = str6;
                    return;
                }
            }
            aHa.hKT.add(0, aVar);
            MMHandlerThread.postToMainThread(new a.g(aHa));
            return;
        }
        StringBuilder sb = new StringBuilder("anchor receive mic ,but error live_id for ");
        x xVar3 = x.hJf;
        Log.e("MicroMsg.LiveCoreMic", sb.append(x.aGr().hyH).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
    @Override // com.tencent.mm.live.b.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAcceptLiveMic(com.tencent.mm.live.b.a r31) {
        /*
        // Method dump skipped, instructions count: 278
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.RoomBaseLivePluginLayout.onAcceptLiveMic(com.tencent.mm.live.b.a):void");
    }

    @Override // com.tencent.mm.live.b.j
    public void onCloseLive(e eVar) {
        p.h(eVar, "info");
        long j2 = eVar.liveId;
        x xVar = x.hJf;
        com.tencent.mm.live.b.b.a aHa = x.aHa();
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("[sysmsg]anchor close live ".concat(String.valueOf(j2)));
        MMHandlerThread.postToMainThread(new a.c(aHa, j2));
        x xVar2 = x.hJf;
        x.zB(0);
    }

    @Override // com.tencent.mm.live.b.j
    public void onCloseLiveMic(f fVar) {
        p.h(fVar, "info");
        long j2 = fVar.liveId;
        String str = fVar.hFJ;
        if (str == null) {
            str = "";
        }
        String str2 = fVar.hFz;
        if (str2 == null) {
            str2 = "";
        }
        x xVar = x.hJf;
        x.aHa().a(j2, str, str2);
        r rVar = r.hIg;
        d.C(r.hIf);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(760, rVar);
    }

    @Override // com.tencent.mm.live.b.j
    public void onCloseApplyLiveMic(com.tencent.mm.live.b.d dVar) {
        p.h(dVar, "info");
        long j2 = dVar.liveId;
        boolean z = dVar.enable;
        x xVar = x.hJf;
        com.tencent.mm.live.b.b.a aHa = x.aHa();
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sysmsg]anchor set mic permission:" + z + " liveId:" + j2);
        x xVar2 = x.hJf;
        if (j2 == x.aGr().hyH) {
            MMHandlerThread.postToMainThread(new a.d(aHa, z));
        }
    }

    @Override // com.tencent.mm.live.b.j
    public void onBanLiveComment(c cVar) {
        boolean z = true;
        int i2 = 0;
        p.h(cVar, "info");
        long j2 = cVar.hFH;
        int i3 = cVar.hFI;
        String str = cVar.dQx;
        if (str == null) {
            str = "";
        }
        x xVar = x.hJf;
        if (x.aGr().hyH == j2) {
            x xVar2 = x.hJf;
            civ aGr = x.aGr();
            if (i3 != 1) {
                z = false;
            }
            aGr.KNv = z;
            x xVar3 = x.hJf;
            x xVar4 = x.hJf;
            if (!x.aGr().KNv) {
                i2 = cl.aWB();
            }
            x.qT(i2);
            m mVar = m.hGg;
            m.GL(str);
        }
    }

    @Override // com.tencent.mm.live.b.j
    public void onLiveMicSucc(q qVar) {
        p.h(qVar, "info");
        long j2 = qVar.liveId;
        String str = qVar.hFJ;
        if (str == null) {
            str = "";
        }
        String str2 = qVar.hIc;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = qVar.nickName;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = qVar.hFG;
        if (str4 == null) {
            str4 = "";
        }
        String str5 = qVar.hFz;
        if (str5 == null) {
            str5 = "";
        }
        x xVar = x.hJf;
        x.aHa().a(j2, str5, str, str2, str3, str4);
    }

    @Override // com.tencent.mm.live.b.j
    public void onOnlineLiveList(v vVar) {
        String str;
        String str2;
        p.h(vVar, "info");
        String str3 = vVar.hIo;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = vVar.content;
        if (str4 == null) {
            str4 = "";
        }
        String str5 = vVar.dkV;
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        com.tencent.mm.bw.a parseFrom = new ciw().parseFrom(Base64.decode(str3, 0));
        if (parseFrom == null) {
            throw new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveInfoList");
        }
        ciw ciw = (ciw) parseFrom;
        if (ciw != null && ciw.gCs != null && ciw.gCs.size() > 0) {
            int a2 = n.a((CharSequence) str4, ":", 0, false, 6);
            if (a2 == -1) {
                str2 = "";
            } else if (str4 == null) {
                throw new t("null cannot be cast to non-null type java.lang.String");
            } else {
                str2 = str4.substring(0, a2);
                p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            LinkedList<com.tencent.mm.live.b.c.b> linkedList = new LinkedList<>();
            Iterator<civ> it = ciw.gCs.iterator();
            while (it.hasNext()) {
                civ next = it.next();
                if (!str.equals(next.MnN)) {
                    com.tencent.mm.live.b.c.b bVar = new com.tencent.mm.live.b.c.b();
                    bVar.field_liveId = next.hyH;
                    bVar.field_hostRoomId = str2;
                    bVar.field_liveName = next.MnO;
                    bVar.field_anchorUsername = next.MnN;
                    bVar.field_isSender = false;
                    bVar.field_timeStamp = (long) next.Gaz;
                    linkedList.add(bVar);
                }
            }
            com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().a(linkedList, str2);
        }
    }
}
