package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.b.b;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.plugin.finder.live.model.i;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.trtc.TRTCCloudDef;
import kotlin.g.a.a;
import kotlin.g.a.u;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\n¢\u0006\u0002\b\u000f"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "invoke"})
public final class FinderLiveVisitorPluginLayout$joinLive$1 extends q implements u<Boolean, Integer, Integer, String, e, TRTCCloudDef.TRTCParams, auf, x> {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$joinLive$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        super(7);
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.g.a.u
    public final /* synthetic */ x invoke(Boolean bool, Integer num, Integer num2, String str, e eVar, TRTCCloudDef.TRTCParams tRTCParams, auf auf) {
        AppMethodBeat.i(247591);
        invoke(bool.booleanValue(), num.intValue(), num2.intValue(), str, eVar, tRTCParams, auf);
        x xVar = x.SXb;
        AppMethodBeat.o(247591);
        return xVar;
    }

    public final void invoke(boolean z, int i2, int i3, String str, e eVar, TRTCCloudDef.TRTCParams tRTCParams, auf auf) {
        int aCe;
        long j2;
        String str2;
        long ahy;
        e eVar2;
        TRTCCloudDef.TRTCParams tRTCParams2;
        AppMethodBeat.i(247592);
        p.h(str, "errMsg");
        p.h(eVar, "liveRoomInfo");
        p.h(tRTCParams, "trtcParams");
        p.h(auf, "resp");
        Log.i(this.this$0.TAG, "join live room success:" + z + " errCode:" + i2 + " errMsg:" + str + " isDestroyed:" + this.this$0.isDestroyed());
        if (this.this$0.isDestroyed()) {
            AppMethodBeat.o(247592);
            return;
        }
        m mVar = m.vVH;
        m.a(auf, this.this$0.confettiPlugin, this.this$0.getLiveData());
        this.this$0.getLiveData().UQm.Mpi.addAll(auf.Viw);
        this.this$0.getLiveData().UQm.UQM = auf.ViJ;
        g liveData = this.this$0.getLiveData();
        avn avn = auf.LDQ;
        liveData.RK((long) (avn != null ? avn.LGj : 0));
        af afVar = af.waa;
        StringBuilder sb = new StringBuilder();
        af afVar2 = af.waa;
        String sb2 = sb.append(af.dEm()).append(this.this$0.getData().uCr.getLiveId()).toString();
        ad.a aVar = ad.vZu;
        af.a(afVar, sb2, ad.vYO.name, null, false, false, 28);
        this.this$0.liveMessageCallback.invoke();
        if (z) {
            s finderLiveAssistant = this.this$0.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                Context context = this.this$0.getContext();
                p.g(context, "context");
                finderLiveAssistant.fn(context);
            }
            this.this$0.getLiveData().hIy = new f(tRTCParams, eVar, new b("com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorUI"));
            i iVar = i.uja;
            i.b(this.this$0.getLiveData());
            i iVar2 = i.uja;
            i.c(this.this$0.getLiveData());
            i iVar3 = i.uja;
            i.k(this.this$0.getLiveData());
            f fVar = this.this$0.getLiveData().hIy;
            if (!(fVar == null || (tRTCParams2 = fVar.hzu) == null)) {
                tRTCParams2.role = 21;
            }
            this.this$0.getLiveData().sessionId = SystemClock.elapsedRealtimeNanos();
            com.tencent.mm.live.core.c.b bVar = com.tencent.mm.live.core.c.b.hEJ;
            e.f fVar2 = e.f.hxS;
            int aCP = e.f.aCP();
            f fVar3 = this.this$0.getLiveData().hIy;
            if (fVar3 == null || (eVar2 = fVar3.hwP) == null) {
                e.a aVar2 = e.a.hxc;
                aCe = e.a.aCe();
            } else {
                aCe = eVar2.hzl;
            }
            com.tencent.mm.live.core.c.b.d(aCP, aCe, eVar.liveId);
            FinderLiveVisitorPluginLayout.access$checkLinkMicStateWhenJoin(this.this$0, auf.LES);
            FinderLiveVisitorPluginLayout.chooseAudienceMode$default(this.this$0, false, 1, null);
            b.C0376b.a(this.this$0, b.c.hNb);
            af afVar3 = af.waa;
            StringBuilder sb3 = new StringBuilder();
            af afVar4 = af.waa;
            String sb4 = sb3.append(af.dEm()).append(this.this$0.getData().uCr.getLiveId()).toString();
            ad.a aVar3 = ad.vZu;
            af.a(afVar3, sb4, ad.vYP.name, null, false, false, 28);
            com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.a(s.n.LIVE_LIVING);
            com.tencent.mm.plugin.finder.report.live.m mVar3 = com.tencent.mm.plugin.finder.report.live.m.vli;
            c data = this.this$0.getData();
            Context context2 = this.this$0.getContext();
            p.g(context2, "context");
            Resources resources = context2.getResources();
            p.g(resources, "context.resources");
            mVar3.a(data, resources.getConfiguration().orientation);
            k kVar = k.vkd;
            long j3 = this.this$0.getLiveData().hFK;
            if (eVar.liveId <= 0) {
                awe awe = auf.liveInfo;
                j2 = awe != null ? awe.liveId : 0;
            } else {
                j2 = eVar.liveId;
            }
            if (TextUtils.isEmpty(this.this$0.getData().uCs.hwd)) {
                str2 = this.this$0.getLiveData().hwd;
            } else {
                str2 = this.this$0.getData().uCs.hwd;
            }
            k kVar2 = k.vkd;
            long j4 = k.dpl().vlw;
            long size = (long) this.this$0.getLiveData().uDn.size();
            s.p pVar = s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL;
            k kVar3 = k.vkd;
            String str3 = k.dpl().vlv;
            long j5 = s.n.LIVE_LIVING.jii;
            com.tencent.mm.plugin.finder.report.live.m mVar4 = com.tencent.mm.plugin.finder.report.live.m.vli;
            if (com.tencent.mm.plugin.finder.report.live.m.ahy() <= 0) {
                ahy = System.currentTimeMillis();
            } else {
                com.tencent.mm.plugin.finder.report.live.m mVar5 = com.tencent.mm.plugin.finder.report.live.m.vli;
                ahy = com.tencent.mm.plugin.finder.report.live.m.ahy();
            }
            k kVar4 = k.vkd;
            kVar.a(j3, j2, str2, j4, size, pVar, str3, j5, ahy, k.dpl().vma);
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant2 = this.this$0.getFinderLiveAssistant();
            if (finderLiveAssistant2 != null) {
                this.this$0.getLiveData();
                this.this$0.getLiveData();
                this.this$0.getLiveData();
                finderLiveAssistant2.f(null);
            }
            d.a(200, new a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout$joinLive$1.AnonymousClass1 */
                final /* synthetic */ FinderLiveVisitorPluginLayout$joinLive$1 this$0;

                {
                    this.this$0 = r2;
                }

                @Override // kotlin.g.a.a
                public final void invoke() {
                    AppMethodBeat.i(260851);
                    FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.this$0.this$0;
                    Context context = this.this$0.this$0.getContext();
                    if (context == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(260851);
                        throw tVar;
                    }
                    finderLiveVisitorPluginLayout.goGetLuckMoney((MMActivity) context, this.this$0.this$0.getData().uCr.aFR());
                    AppMethodBeat.o(260851);
                }
            });
            AppMethodBeat.o(247592);
            return;
        }
        af afVar5 = af.waa;
        StringBuilder sb5 = new StringBuilder();
        af afVar6 = af.waa;
        String sb6 = sb5.append(af.dEm()).append(this.this$0.getData().uCr.getLiveId()).toString();
        ad.a aVar4 = ad.vZu;
        String str4 = ad.vYR.name;
        y yVar = y.vXH;
        cit cit = new cit();
        cit.errCode = i2;
        cit.errMsg = str;
        af.a(afVar5, sb6, str4, y.j(cit), false, true, 8);
        this.this$0.disableRatation();
        FinderLiveVisitorPluginLayout.access$handleJoinErr(this.this$0, i2, str);
        AppMethodBeat.o(247592);
    }
}
