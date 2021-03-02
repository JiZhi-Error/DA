package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.ac;
import com.tencent.mm.plugin.finder.live.plugin.ae;
import com.tencent.mm.plugin.finder.live.plugin.aj;
import com.tencent.mm.plugin.finder.live.plugin.al;
import com.tencent.mm.plugin.finder.live.plugin.ap;
import com.tencent.mm.plugin.finder.live.plugin.as;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.ay;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.plugin.bh;
import com.tencent.mm.plugin.finder.live.plugin.bj;
import com.tencent.mm.plugin.finder.live.plugin.bl;
import com.tencent.mm.plugin.finder.live.plugin.cb;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.plugin.h;
import com.tencent.mm.plugin.finder.live.plugin.j;
import com.tencent.mm.plugin.finder.live.plugin.k;
import com.tencent.mm.plugin.finder.live.plugin.l;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.plugin.p;
import com.tencent.mm.plugin.finder.live.plugin.q;
import com.tencent.mm.plugin.finder.live.plugin.r;
import com.tencent.mm.plugin.finder.live.plugin.t;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.plugin.finder.live.plugin.y;
import com.tencent.mm.plugin.finder.live.viewmodel.m;
import com.tencent.mm.plugin.finder.live.widget.f;
import com.tencent.mm.plugin.finder.live.widget.t;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.u;
import kotlin.x;

public abstract class e extends FinderBaseLivePluginLayout {
    private String TAG = "FinderLiveBaseAnchorPluginLayout";
    private cc UNS;
    private HashMap _$_findViewCache;
    private v commentPlugin;
    private y commonInfoPlugin;
    private aj confettiPlugin;
    private ac giftPlayPlugin;
    private ae giftQueuePlugin;
    private com.tencent.mm.live.core.core.trtc.a hSS;
    private kotlin.g.a.a<x> liveMessageCallback;
    private al lotteryBubblePlugin;
    private as luckyMoneyPlugin;
    private ap memberListPlugin;
    private bl micAudioPreviewPlugin;
    private cb micDecoratePlugin;
    private at moreActionPlugin;
    private bd shoppingBubblePlugin;
    private bf shoppingListPlugin;
    private final kotlin.f tYU;
    MTimerHandler timerThread;
    private bh titleInfoPlugin;
    private bj topCommentPlugin;
    private n uxT;
    private t uxU;
    private r uxV;
    private com.tencent.mm.plugin.finder.live.plugin.e uxW;
    private com.tencent.mm.live.c.as uxX;
    private ay uxY;
    private l uxZ;
    private k uya;
    private j uyb;
    private q uyc;
    private p uyd;
    private o uye;
    private h uyf;

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract com.tencent.mm.live.core.core.trtc.a dip();

    public final bbn getContextObj() {
        return (bbn) this.tYU.getValue();
    }

    /* access modifiers changed from: package-private */
    public static final class a extends kotlin.g.b.q implements u<Boolean, Boolean, String, Integer, Integer, String, aqd, x> {
        final /* synthetic */ e uyg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar) {
            super(7);
            this.uyg = eVar;
        }

        @Override // kotlin.g.a.u
        public final /* synthetic */ x invoke(Boolean bool, Boolean bool2, String str, Integer num, Integer num2, String str2, aqd aqd) {
            AppMethodBeat.i(247429);
            final boolean booleanValue = bool.booleanValue();
            final boolean booleanValue2 = bool2.booleanValue();
            final String str3 = str;
            final int intValue = num.intValue();
            final int intValue2 = num2.intValue();
            final String str4 = str2;
            final aqd aqd2 = aqd;
            kotlin.g.b.p.h(str3, "verifyUrl");
            kotlin.g.b.p.h(str4, "errMsg");
            kotlin.g.b.p.h(aqd2, "resp");
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.e.a.AnonymousClass1 */
                final /* synthetic */ a uyh;

                {
                    this.uyh = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    String str;
                    AppMethodBeat.i(247428);
                    Log.i(this.uyh.uyg.getTAG(), "createLive success:" + booleanValue + ", errCode:" + intValue2);
                    if (booleanValue) {
                        b.C0376b.a(this.uyh.uyg, b.c.hLz);
                        com.tencent.mm.ac.d.i(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.live.view.e.a.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 UNT;

                            {
                                this.UNT = r2;
                            }

                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                s finderLiveAssistant;
                                LinkedList<String> linkedList;
                                m mVar;
                                AppMethodBeat.i(260835);
                                FinderObject finderObject = this.UNT.uyh.uyg.getLiveData().uDz;
                                if (!(finderObject == null || (finderLiveAssistant = this.UNT.uyh.uyg.getFinderLiveAssistant()) == null)) {
                                    com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.UNT.uyh.uyg.getLiveData();
                                    if (liveData == null || (mVar = liveData.UQm) == null) {
                                        linkedList = null;
                                    } else {
                                        linkedList = mVar.Mpi;
                                    }
                                    FinderItem.a aVar = FinderItem.Companion;
                                    finderLiveAssistant.a(linkedList, FinderItem.a.a(finderObject, 16384));
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(260835);
                                return xVar;
                            }
                        });
                    } else if (!booleanValue2 || Util.isNullOrNil(str3)) {
                        com.tencent.mm.plugin.finder.utils.ac acVar = com.tencent.mm.plugin.finder.utils.ac.vYp;
                        ad.a aVar = ad.vZu;
                        String str2 = ad.vYW.name;
                        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                        cit cit = new cit();
                        cit.errCode = intValue2;
                        cit.errMsg = str4;
                        com.tencent.mm.plugin.finder.utils.ac.a(acVar, str2, com.tencent.mm.plugin.finder.utils.y.j(cit), false, true, 4);
                        this.uyh.uyg.b(intValue, intValue2, str4, aqd2);
                    } else {
                        Bundle bundle = new Bundle();
                        if (TextUtils.isEmpty(this.uyh.uyg.getData().uCs.hwd)) {
                            str = this.uyh.uyg.getLiveData().hwd;
                        } else {
                            str = this.uyh.uyg.getData().uCs.hwd;
                        }
                        bundle.putString("PARAM_FINDER_LIVE_USERNAME", str);
                        bundle.putString("PARAM_FINDER_LIVE_FACE_VERIFY_URL", str3);
                        avr avr = aqd2.LCg;
                        if (avr != null) {
                            bundle.putByteArray("PARAM_FINDER_LIVE_ERROR_PAGE", avr.toByteArray());
                        }
                        this.uyh.uyg.statusChange(b.c.hNe, bundle);
                        com.tencent.mm.plugin.finder.utils.ac acVar2 = com.tencent.mm.plugin.finder.utils.ac.vYp;
                        ad.a aVar2 = ad.vZu;
                        com.tencent.mm.plugin.finder.utils.ac.a(acVar2, ad.vYX.name, null, false, false, 14);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(247428);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(247429);
            return xVar;
        }
    }

    public static final class c extends kotlin.g.b.q implements kotlin.g.a.s<Boolean, Integer, Integer, String, ape, x> {
        final /* synthetic */ e uyg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar) {
            super(5);
            this.uyg = eVar;
        }

        @Override // kotlin.g.a.s
        public final /* synthetic */ x a(Boolean bool, Integer num, Integer num2, String str, ape ape) {
            AppMethodBeat.i(247432);
            boolean booleanValue = bool.booleanValue();
            num.intValue();
            num2.intValue();
            kotlin.g.b.p.h(str, "errMsg");
            Log.i(this.uyg.getTAG(), "close live result:".concat(String.valueOf(booleanValue)));
            x xVar = x.SXb;
            AppMethodBeat.o(247432);
            return xVar;
        }
    }

    static final class g extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ e uyg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(e eVar) {
            super(1);
            this.uyg = eVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            Boolean bool2;
            bf shoppingListPlugin;
            awc awc = null;
            boolean z = false;
            AppMethodBeat.i(260836);
            boolean booleanValue = bool.booleanValue();
            String tag = this.uyg.getTAG();
            StringBuilder append = new StringBuilder("prepare shopping:").append(booleanValue).append(",list empty:");
            LinkedList<bo> linkedList = this.uyg.getLiveData().LGy;
            if (linkedList != null) {
                LinkedList<bo> linkedList2 = linkedList;
                bool2 = Boolean.valueOf(linkedList2 == null || linkedList2.isEmpty());
            } else {
                bool2 = null;
            }
            Log.i(tag, append.append(bool2).toString());
            if (booleanValue) {
                LinkedList<bo> linkedList3 = this.uyg.getLiveData().LGy;
                if (linkedList3 != null) {
                    LinkedList<bo> linkedList4 = linkedList3;
                    if (linkedList4 == null || linkedList4.isEmpty()) {
                        z = true;
                    }
                    if (!z && (shoppingListPlugin = this.uyg.getShoppingListPlugin()) != null) {
                        shoppingListPlugin.dhP();
                    }
                }
                com.tencent.mm.plugin.finder.live.h hVar = com.tencent.mm.plugin.finder.live.h.ufY;
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.uyg.getLiveData();
                if (liveData != null) {
                    awc = liveData.uEl;
                }
                com.tencent.mm.plugin.finder.live.h.d(com.tencent.mm.plugin.finder.utils.y.c(awc));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260836);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(MMActivity mMActivity) {
        super(mMActivity, null);
        kotlin.g.b.p.h(mMActivity, "context");
        this.tYU = kotlin.g.ah(new f(mMActivity));
        this.hSS = dip();
        this.liveMessageCallback = new b(this, mMActivity);
        this.timerThread = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack) new C1201e(this), true);
    }

    public String getTAG() {
        return this.TAG;
    }

    public void setTAG(String str) {
        kotlin.g.b.p.h(str, "<set-?>");
        this.TAG = str;
    }

    public n getExceptionPlugin() {
        return this.uxT;
    }

    public void setExceptionPlugin(n nVar) {
        this.uxT = nVar;
    }

    public t getFinderLiveBeforePlugin() {
        return this.uxU;
    }

    public void setFinderLiveBeforePlugin(t tVar) {
        this.uxU = tVar;
    }

    public final r getPreviewPlugin() {
        return this.uxV;
    }

    public final void setPreviewPlugin(r rVar) {
        this.uxV = rVar;
    }

    public final com.tencent.mm.plugin.finder.live.plugin.e getFinderLiveAfterPlugin() {
        return this.uxW;
    }

    public final void setFinderLiveAfterPlugin(com.tencent.mm.plugin.finder.live.plugin.e eVar) {
        this.uxW = eVar;
    }

    public final com.tencent.mm.live.c.as getShadowPlugin() {
        return this.uxX;
    }

    public final void setShadowPlugin(com.tencent.mm.live.c.as asVar) {
        this.uxX = asVar;
    }

    public final bh getTitleInfoPlugin() {
        return this.titleInfoPlugin;
    }

    public final void setTitleInfoPlugin(bh bhVar) {
        this.titleInfoPlugin = bhVar;
    }

    public final y getCommonInfoPlugin() {
        return this.commonInfoPlugin;
    }

    public final void setCommonInfoPlugin(y yVar) {
        this.commonInfoPlugin = yVar;
    }

    public final v getCommentPlugin() {
        return this.commentPlugin;
    }

    public final void setCommentPlugin(v vVar) {
        this.commentPlugin = vVar;
    }

    public final ay getReadyPlugin() {
        return this.uxY;
    }

    public final void setReadyPlugin(ay ayVar) {
        this.uxY = ayVar;
    }

    public final l getClosePlugin() {
        return this.uxZ;
    }

    public final void setClosePlugin(l lVar) {
        this.uxZ = lVar;
    }

    public final ap getMemberListPlugin() {
        return this.memberListPlugin;
    }

    public final void setMemberListPlugin(ap apVar) {
        this.memberListPlugin = apVar;
    }

    public final cc getProfilePlugin() {
        return this.UNS;
    }

    public final void setProfilePlugin(cc ccVar) {
        this.UNS = ccVar;
    }

    public final aj getConfettiPlugin() {
        return this.confettiPlugin;
    }

    public final void setConfettiPlugin(aj ajVar) {
        this.confettiPlugin = ajVar;
    }

    public final at getMoreActionPlugin() {
        return this.moreActionPlugin;
    }

    public final void setMoreActionPlugin(at atVar) {
        this.moreActionPlugin = atVar;
    }

    public final bd getShoppingBubblePlugin() {
        return this.shoppingBubblePlugin;
    }

    public final void setShoppingBubblePlugin(bd bdVar) {
        this.shoppingBubblePlugin = bdVar;
    }

    public final bf getShoppingListPlugin() {
        return this.shoppingListPlugin;
    }

    public final void setShoppingListPlugin(bf bfVar) {
        this.shoppingListPlugin = bfVar;
    }

    public final bj getTopCommentPlugin() {
        return this.topCommentPlugin;
    }

    public final void setTopCommentPlugin(bj bjVar) {
        this.topCommentPlugin = bjVar;
    }

    public final k getCameraOptPlugin() {
        return this.uya;
    }

    public final void setCameraOptPlugin(k kVar) {
        this.uya = kVar;
    }

    public final j getCameraOptPanelPlugin() {
        return this.uyb;
    }

    public final void setCameraOptPanelPlugin(j jVar) {
        this.uyb = jVar;
    }

    public final al getLotteryBubblePlugin() {
        return this.lotteryBubblePlugin;
    }

    public final void setLotteryBubblePlugin(al alVar) {
        this.lotteryBubblePlugin = alVar;
    }

    public final q getLotteryCardPlugin() {
        return this.uyc;
    }

    public final void setLotteryCardPlugin(q qVar) {
        this.uyc = qVar;
    }

    public final ac getGiftPlayPlugin() {
        return this.giftPlayPlugin;
    }

    public final void setGiftPlayPlugin(ac acVar) {
        this.giftPlayPlugin = acVar;
    }

    public final ae getGiftQueuePlugin() {
        return this.giftQueuePlugin;
    }

    public final void setGiftQueuePlugin(ae aeVar) {
        this.giftQueuePlugin = aeVar;
    }

    public final p getLinkStatePlugin() {
        return this.uyd;
    }

    public final void setLinkStatePlugin(p pVar) {
        this.uyd = pVar;
    }

    public final o getLinkApplyListPlugin() {
        return this.uye;
    }

    public final void setLinkApplyListPlugin(o oVar) {
        this.uye = oVar;
    }

    public final cb getMicDecoratePlugin() {
        return this.micDecoratePlugin;
    }

    public final void setMicDecoratePlugin(cb cbVar) {
        this.micDecoratePlugin = cbVar;
    }

    public final h getBottomOptionPlugin() {
        return this.uyf;
    }

    public final void setBottomOptionPlugin(h hVar) {
        this.uyf = hVar;
    }

    public final as getLuckyMoneyPlugin() {
        return this.luckyMoneyPlugin;
    }

    public final void setLuckyMoneyPlugin(as asVar) {
        this.luckyMoneyPlugin = asVar;
    }

    public final bl getMicAudioPreviewPlugin() {
        return this.micAudioPreviewPlugin;
    }

    public final void setMicAudioPreviewPlugin(bl blVar) {
        this.micAudioPreviewPlugin = blVar;
    }

    public final com.tencent.mm.live.core.core.trtc.a getLiveCore() {
        return this.hSS;
    }

    public final void setLiveCore(com.tencent.mm.live.core.core.trtc.a aVar) {
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.hSS = aVar;
    }

    public final kotlin.g.a.a<x> getLiveMessageCallback() {
        return this.liveMessageCallback;
    }

    public final void setLiveMessageCallback(kotlin.g.a.a<x> aVar) {
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.liveMessageCallback = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.finder.live.view.e$e */
    public static final class C1201e implements MTimerHandler.CallBack {
        final /* synthetic */ e uyg;

        C1201e(e eVar) {
            this.uyg = eVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            k cameraOptPlugin;
            int i2;
            long j2;
            AppMethodBeat.i(247433);
            y commonInfoPlugin = this.uyg.getCommonInfoPlugin();
            if (commonInfoPlugin != null && commonInfoPlugin.hwr.getVisibility() == 0) {
                y commonInfoPlugin2 = this.uyg.getCommonInfoPlugin();
                if (commonInfoPlugin2 != null) {
                    int i3 = this.uyg.getLiveData().liveInfo.dvv;
                    if (com.tencent.mm.kernel.g.aAf().azp()) {
                        int aWB = cl.aWB();
                        u.a aVar = com.tencent.mm.live.b.u.hIn;
                        commonInfoPlugin2.hPQ = u.a.a(aWB - i3, ":", false, false, false, 28);
                        int i4 = aWB - i3;
                        if (i4 > 0) {
                            j2 = (long) i4;
                        } else {
                            j2 = 0;
                        }
                        commonInfoPlugin2.duration = j2;
                    }
                }
                y commonInfoPlugin3 = this.uyg.getCommonInfoPlugin();
                if (commonInfoPlugin3 != null) {
                    if (commonInfoPlugin3.dMz) {
                        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                        if (com.tencent.mm.plugin.finder.utils.m.i(commonInfoPlugin3.getLiveData())) {
                            a.C0381a aVar2 = com.tencent.mm.live.core.core.c.a.hAj;
                            commonInfoPlugin3.hwr.getContext();
                            i2 = a.C0381a.aDw().hAz.hzL;
                        } else {
                            b.a aVar3 = com.tencent.mm.live.core.core.a.b.hyv;
                            commonInfoPlugin3.hwr.getContext();
                            i2 = b.a.aDo().hAz.hzL;
                        }
                    } else {
                        b.a aVar4 = com.tencent.mm.live.core.core.d.b.hCo;
                        commonInfoPlugin3.hwr.getContext();
                        i2 = b.a.aEf().hAz.hzL;
                    }
                    commonInfoPlugin3.hPP = i2;
                }
                y commonInfoPlugin4 = this.uyg.getCommonInfoPlugin();
                if (commonInfoPlugin4 != null) {
                    commonInfoPlugin4.e(this.uyg.getLiveData().liveInfo.uBn, this.uyg.getLiveData().UPT, this.uyg.getLiveData().uDV);
                }
            }
            k cameraOptPlugin2 = this.uyg.getCameraOptPlugin();
            if (!(cameraOptPlugin2 == null || cameraOptPlugin2.hwr.getVisibility() != 0 || (cameraOptPlugin = this.uyg.getCameraOptPlugin()) == null)) {
                com.tencent.mm.ac.d.h(new k.a(cameraOptPlugin, this.uyg.getLiveData().UPT));
            }
            AppMethodBeat.o(247433);
            return true;
        }
    }

    public final MTimerHandler getTimerThread() {
        return this.timerThread;
    }

    public final void setTimerThread(MTimerHandler mTimerHandler) {
        kotlin.g.b.p.h(mTimerHandler, "<set-?>");
        this.timerThread = mTimerHandler;
    }

    public final void dis() {
        s finderLiveAssistant = getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.a(new a(this));
        }
    }

    public final void b(int i2, int i3, String str, aqd aqd) {
        avr avr;
        avr avr2 = null;
        kotlin.g.b.p.h(str, "errMsg");
        Log.i(getTAG(), "handleLiveErr errCode:" + i3 + " errMsg:" + str);
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_BTN_CLICK.hlf, String.valueOf(s.ap.LIVE_START_NETWORK_ERROR.type));
        com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.setErrorCode(i3);
        com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(s.o.LIVE_EXIT_ERROR);
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.a(i2, i3, aqd != null ? aqd.LCg : null)) {
            b.C0376b.a(this, b.c.hLy);
            return;
        }
        com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (aqd != null) {
            avr2 = aqd.LCg;
        }
        if (!com.tencent.mm.plugin.finder.spam.a.b(i2, i3, avr2)) {
            switch (i3) {
                case -200018:
                case -200017:
                case -200013:
                    b.C0376b.a(this, b.c.hNg);
                    return;
                case -200012:
                case -200011:
                    Context context = getContext();
                    Context context2 = getContext();
                    kotlin.g.b.p.g(context2, "context");
                    com.tencent.mm.ui.base.u.makeText(context, context2.getResources().getString(R.string.cs1), 0).show();
                    b.C0376b.a(this, b.c.hLV);
                    return;
                case -200010:
                    Context context3 = getContext();
                    Context context4 = getContext();
                    kotlin.g.b.p.g(context4, "context");
                    com.tencent.mm.ui.base.u.makeText(context3, context4.getResources().getString(R.string.cqt), 0).show();
                    b.C0376b.a(this, b.c.hLy);
                    return;
                case -200009:
                    Context context5 = getContext();
                    Context context6 = getContext();
                    kotlin.g.b.p.g(context6, "context");
                    com.tencent.mm.ui.base.u.makeText(context5, context6.getResources().getString(R.string.chx), 0).show();
                    b.C0376b.a(this, b.c.hLy);
                    return;
                case -100038:
                    b.C0376b.a(this, b.c.hLV);
                    return;
                default:
                    Context context7 = getContext();
                    Context context8 = getContext();
                    kotlin.g.b.p.g(context8, "context");
                    com.tencent.mm.ui.base.u.makeText(context7, context8.getResources().getString(R.string.chw), 0).show();
                    b.C0376b.a(this, b.c.hLy);
                    return;
            }
        } else if (aqd != null && (avr = aqd.LCg) != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray("PARAM_FINDER_LIVE_ERROR_PAGE", avr.toByteArray());
            bundle.putInt("PARAM_FINDER_LIVE_ERROR_CODE", i3);
            statusChange(b.c.hNz, bundle);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.c.b
    public void statusChange(b.c cVar, Bundle bundle) {
        avr avr;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant;
        byte[] byteArray;
        String str = null;
        kotlin.g.b.p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        if (bundle == null || (byteArray = bundle.getByteArray("PARAM_FINDER_LIVE_ERROR_PAGE")) == null) {
            avr = null;
        } else {
            avr avr2 = new avr();
            try {
                avr2.parseFrom(byteArray);
            } catch (Throwable th) {
                Log.e(getTAG(), "statusChange:", th);
                avr2 = null;
            }
            avr = avr2;
        }
        switch (f.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                String string = bundle != null ? bundle.getString("PARAM_FINDER_LIVE_FACE_VERIFY_URL") : null;
                if (bundle != null) {
                    str = bundle.getString("PARAM_FINDER_LIVE_USERNAME");
                }
                n exceptionPlugin = getExceptionPlugin();
                if (exceptionPlugin != null) {
                    Log.i(exceptionPlugin.TAG, "showFaceVerify:".concat(String.valueOf(string)));
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.ad.LIVE_VERIFIED_PAGE_EXPOSURE, str);
                    exceptionPlugin.atI("");
                    com.tencent.mm.plugin.finder.live.widget.f fVar = exceptionPlugin.umS;
                    if (fVar != null) {
                        f.c cVar2 = com.tencent.mm.plugin.finder.live.widget.f.uGx;
                        com.tencent.mm.plugin.finder.live.widget.f.a(fVar, com.tencent.mm.plugin.finder.live.widget.f.uGs, avr, new n.d(exceptionPlugin, string, str), 4);
                    }
                }
                n exceptionPlugin2 = getExceptionPlugin();
                if (exceptionPlugin2 != null) {
                    exceptionPlugin2.rg(0);
                }
                t finderLiveBeforePlugin = getFinderLiveBeforePlugin();
                if (finderLiveBeforePlugin != null) {
                    finderLiveBeforePlugin.rg(8);
                    return;
                }
                return;
            case 2:
            case 3:
                t finderLiveBeforePlugin2 = getFinderLiveBeforePlugin();
                if (finderLiveBeforePlugin2 != null) {
                    finderLiveBeforePlugin2.rg(8);
                }
                hideLoadingLayer();
                com.tencent.mm.live.c.as asVar = this.uxX;
                if (asVar != null) {
                    asVar.rg(8);
                }
                r rVar = this.uxV;
                if (rVar != null) {
                    rVar.rg(8);
                }
                bh bhVar = this.titleInfoPlugin;
                if (bhVar != null) {
                    bhVar.rg(8);
                }
                y yVar = this.commonInfoPlugin;
                if (yVar != null) {
                    yVar.rg(8);
                }
                ay ayVar = this.uxY;
                if (ayVar != null) {
                    ayVar.rg(8);
                }
                v vVar = this.commentPlugin;
                if (vVar != null) {
                    vVar.rg(8);
                }
                l lVar = this.uxZ;
                if (lVar != null) {
                    lVar.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.e eVar = this.uxW;
                if (eVar != null) {
                    eVar.rg(8);
                }
                ap apVar = this.memberListPlugin;
                if (apVar != null) {
                    apVar.rg(8);
                }
                cc ccVar = this.UNS;
                if (ccVar != null) {
                    ccVar.rg(8);
                }
                aj ajVar = this.confettiPlugin;
                if (ajVar != null) {
                    ajVar.rg(8);
                }
                at atVar = this.moreActionPlugin;
                if (atVar != null) {
                    atVar.rg(8);
                }
                bj bjVar = this.topCommentPlugin;
                if (bjVar != null) {
                    bjVar.rg(8);
                }
                k kVar2 = this.uya;
                if (kVar2 != null) {
                    kVar2.rg(8);
                }
                bd bdVar = this.shoppingBubblePlugin;
                if (bdVar != null) {
                    bdVar.rg(8);
                }
                bf bfVar = this.shoppingListPlugin;
                if (bfVar != null) {
                    bfVar.rg(8);
                }
                p pVar = this.uyd;
                if (pVar != null) {
                    pVar.rg(8);
                }
                o oVar = this.uye;
                if (oVar != null) {
                    oVar.rg(8);
                }
                cb cbVar = this.micDecoratePlugin;
                if (cbVar != null) {
                    cbVar.rg(8);
                }
                j jVar = this.uyb;
                if (jVar != null) {
                    jVar.rg(8);
                }
                ac acVar = this.giftPlayPlugin;
                if (acVar != null) {
                    acVar.rg(8);
                }
                ae aeVar = this.giftQueuePlugin;
                if (aeVar != null) {
                    aeVar.rg(8);
                }
                h hVar = this.uyf;
                if (hVar != null) {
                    hVar.rg(8);
                }
                if (cVar == b.c.hNg) {
                    n exceptionPlugin3 = getExceptionPlugin();
                    if (exceptionPlugin3 != null) {
                        String str2 = getLiveData().hwd;
                        kotlin.g.b.p.h(str2, "anchorUserName");
                        Log.i(exceptionPlugin3.TAG, "showAnchorForceQuit anchorUserName:".concat(String.valueOf(str2)));
                        exceptionPlugin3.atI(str2);
                        com.tencent.mm.plugin.finder.live.widget.f fVar2 = exceptionPlugin3.umS;
                        if (fVar2 != null) {
                            f.c cVar3 = com.tencent.mm.plugin.finder.live.widget.f.uGx;
                            com.tencent.mm.plugin.finder.live.widget.f.a(fVar2, com.tencent.mm.plugin.finder.live.widget.f.uGt, null, new n.b(exceptionPlugin3), 6);
                        }
                    }
                } else {
                    int i2 = bundle != null ? bundle.getInt("PARAM_FINDER_LIVE_ERROR_CODE") : 0;
                    n exceptionPlugin4 = getExceptionPlugin();
                    if (exceptionPlugin4 != null) {
                        String str3 = getLiveData().hwd;
                        kotlin.g.b.p.h(str3, "anchorUserName");
                        Log.i(exceptionPlugin4.TAG, "showCreateLiveDynamicErrPage anchorUserName:".concat(String.valueOf(str3)));
                        exceptionPlugin4.atI(str3);
                        com.tencent.mm.plugin.finder.live.widget.f fVar3 = exceptionPlugin4.umS;
                        if (fVar3 != null) {
                            f.c cVar4 = com.tencent.mm.plugin.finder.live.widget.f.uGx;
                            fVar3.a(com.tencent.mm.plugin.finder.live.widget.f.uGw, avr, i2, new n.c(exceptionPlugin4));
                        }
                    }
                }
                n exceptionPlugin5 = getExceptionPlugin();
                if (exceptionPlugin5 != null) {
                    exceptionPlugin5.rg(0);
                }
                this.hSS.a(com.tencent.mm.live.core.mini.d.STATE_FINISH);
                if ((this.hSS instanceof com.tencent.mm.live.core.core.a.b) && (finderLiveAssistant = getFinderLiveAssistant()) != null) {
                    finderLiveAssistant.a(1, new c(this));
                }
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant2 = getFinderLiveAssistant();
                if (finderLiveAssistant2 != null) {
                    finderLiveAssistant2.dfk();
                }
                com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
                com.tencent.mm.plugin.finder.live.model.q.dgC();
                com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.o.aHh();
                aJm();
                return;
            default:
                return;
        }
    }

    public final void startTimer() {
        y yVar = this.commonInfoPlugin;
        if (yVar != null && yVar.hwr.getVisibility() == 0) {
            this.timerThread.stopTimer();
            this.timerThread.startTimer(1000);
        }
    }

    public static final class d implements com.tencent.mm.live.core.core.c {
        d() {
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
        }
    }

    public final void aJm() {
        this.hSS.b(new d());
    }

    public final void hTJ() {
        Log.i(getTAG(), "user:" + getLiveData().hwd + ",bind shop:" + getLiveData().uit);
        h hVar = this.uyf;
        if (hVar != null && getLiveData().uit) {
            ViewGroup viewGroup = hVar.ump.hwr;
            View findViewById = findViewById(R.id.cxs);
            kotlin.g.b.p.g(findViewById, "findViewById(R.id.finder…ive_shopping_widget_root)");
            this.shoppingBubblePlugin = new bd(viewGroup, (ViewGroup) findViewById, this);
            View findViewById2 = findViewById(R.id.cxo);
            kotlin.g.b.p.g(findViewById2, "findViewById(R.id.finder_live_shopping_list_root)");
            this.shoppingListPlugin = new bf((ViewGroup) findViewById2, this);
        }
    }

    public final void prepareShopping() {
        if (getLiveData().uit) {
            h hVar = this.uyf;
            if (hVar != null) {
                hVar.dgN();
            }
            bd bdVar = this.shoppingBubblePlugin;
            if (bdVar != null) {
                bdVar.rg(0);
            }
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                s.a.a(finderLiveAssistant, getLiveData().liveInfo.liveId, getLiveData().hFK, new g(this));
            }
        }
    }

    public final void a(auf auf) {
        String str = null;
        kotlin.g.b.p.h(auf, "response");
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            bel bel = auf.ViI;
            com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
            String str2 = bel != null ? bel.appId : null;
            if (bel != null) {
                str = bel.LOg;
            }
            boolean hl = com.tencent.mm.plugin.finder.utils.m.hl(str2, str);
            boolean z = getLiveData().uit;
            Log.i(getTAG(), "handleJoinLiveWxshopResponse haveBindShop:" + z + " canShowShopEntrance:" + hl);
            if (hl) {
                if (!z) {
                    getLiveData().FA(true);
                    com.tencent.mm.kernel.g.azz().b(new cd(14));
                }
                if (this.shoppingListPlugin == null) {
                    hTJ();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<bbn> {
        final /* synthetic */ MMActivity $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(MMActivity mMActivity) {
            super(0);
            this.$context = mMActivity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ bbn invoke() {
            AppMethodBeat.i(260834);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.$context).get(FinderReporterUIC.class)).dIx();
            dIx.tCE = 65;
            AppMethodBeat.o(260834);
            return dIx;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ MMActivity $context;
        final /* synthetic */ e uyg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar, MMActivity mMActivity) {
            super(0);
            this.uyg = eVar;
            this.$context = mMActivity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247431);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.e.b.AnonymousClass1 */
                final /* synthetic */ b uyk;

                {
                    this.uyk = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    boolean z = true;
                    AppMethodBeat.i(247430);
                    v commentPlugin = this.uyk.uyg.getCommentPlugin();
                    if (commentPlugin != null) {
                        List<com.tencent.mm.plugin.finder.live.model.t> list = this.uyk.uyg.getLiveData().uDs;
                        kotlin.g.b.p.g(list, "liveData.msgList");
                        commentPlugin.ea(list);
                    }
                    al lotteryBubblePlugin = this.uyk.uyg.getLotteryBubblePlugin();
                    if (lotteryBubblePlugin != null) {
                        lotteryBubblePlugin.dht();
                    }
                    this.uyk.uyg.showAlertInfo(this.uyk.$context);
                    aj confettiPlugin = this.uyk.uyg.getConfettiPlugin();
                    if (confettiPlugin != null) {
                        List<aut> list2 = this.uyk.uyg.getLiveData().uDv;
                        kotlin.g.b.p.g(list2, "liveData.highLightCheerList");
                        confettiPlugin.ed(list2);
                    }
                    h bottomOptionPlugin = this.uyk.uyg.getBottomOptionPlugin();
                    if (bottomOptionPlugin != null) {
                        bottomOptionPlugin.dgO();
                    }
                    o linkApplyListPlugin = this.uyk.uyg.getLinkApplyListPlugin();
                    if (linkApplyListPlugin != null) {
                        com.tencent.mm.plugin.finder.live.view.adapter.j jVar = linkApplyListPlugin.ULo;
                        com.tencent.mm.plugin.finder.live.viewmodel.g liveData = linkApplyListPlugin.getLiveData();
                        Iterator<T> it = jVar.jmY.iterator();
                        while (it.hasNext()) {
                            it.next().l(liveData);
                        }
                        com.tencent.mm.plugin.finder.live.widget.t tVar = linkApplyListPlugin.ULn;
                        com.tencent.mm.plugin.finder.live.viewmodel.g liveData2 = linkApplyListPlugin.getLiveData();
                        kotlin.g.b.p.h(liveData2, "liveData");
                        com.tencent.mm.ac.d.h(new t.i(tVar, liveData2));
                        linkApplyListPlugin.ULl.Fy(linkApplyListPlugin.getLiveData().hTU() > 0);
                        FinderLiveTextIndicator finderLiveTextIndicator = linkApplyListPlugin.ULl;
                        if (linkApplyListPlugin.getLiveData().hTV() <= 0) {
                            z = false;
                        }
                        finderLiveTextIndicator.Fz(z);
                    }
                    as luckyMoneyPlugin = this.uyk.uyg.getLuckyMoneyPlugin();
                    if (luckyMoneyPlugin != null) {
                        luckyMoneyPlugin.hTC();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(247430);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(247431);
            return xVar;
        }
    }
}
