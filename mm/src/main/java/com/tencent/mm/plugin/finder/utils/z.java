package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.e;
import com.tencent.mm.plugin.finder.view.j;
import com.tencent.mm.plugin.i.a.ab;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.eoy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J4\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0013\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u001cH\u0016J<\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010!H\u0016J:\u0010#\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020%2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010!H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016JB\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010!H\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\b\u00101\u001a\u00020\u0010H\u0016J^\u00102\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u00010\u00042\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010!2\b\u00104\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020%2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u000205\u0018\u00010!2\u0006\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u0004JD\u00108\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020\u00102\u000e\u0010 \u001a\n\u0012\u0004\u0012\u000205\u0018\u00010!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010!H\u0016J\u0012\u0010:\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010;\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u0010?\u001a\u00020\u0012H\u0016Jn\u0010@\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+\u0018\u00010A2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u000205\u0018\u00010!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010!H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderUtilApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi;", "()V", "TAG", "", "enterActivityProfileUI", "", "context", "Landroid/content/Context;", "encryptedTopicId", "eventName", "extra", "enterFeedForWxPay", "exportId", "nonceId", "getRelatedList", "", "enterCommentScene", "", "enterFriendLikeTimelineUI", "targetUsername", "targetNickname", "commentScene", "enterProfileForWxPay", "finderUserName", "get3TabTargetTabCommentScene", "getFinderSnsHeader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader;", "Landroid/app/Activity;", "getLiveNoticeStateWithAnchorUserName", ch.COL_USERNAME, "noticeId", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "getLiveStatusWithUserName", "liveId", "", "getLongVideoMaxDuration", "getLongVideoMaxRatio", "", "getLongVideoMinRatio", "getWxProfileInfo", "", "wxUsername", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "isEnableNearbyLiveFriends", "isEnableNearbyLivePullSimilar", "jumpLiveUIByFeedId", "feedExportId", "feedNonceId", "Ljava/lang/Void;", "contextId", "reportExtraInfo", "reserveLiveNoticeWithAnchorUsername", "reserveOperation", "resetRequestTime", "setBlurBitmap", "imageView", "Landroid/widget/ImageView;", "url", "radius", "showLiveRoomWithUserName", "", "plugin-finder_release"})
public final class z implements af {
    final String TAG = "Finder.FinderUtilApi";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String hLl;
        final /* synthetic */ af.a tpa;
        final /* synthetic */ af.a vXm;
        final /* synthetic */ String vYe;

        a(String str, String str2, af.a aVar, af.a aVar2) {
            this.hLl = str;
            this.vYe = str2;
            this.tpa = aVar;
            this.vXm = aVar2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(253708);
            c.a aVar = (c.a) obj;
            awt awt = ((aok) aVar.iLC).liveNoticeInfo;
            if (aVar.errType == 0 && aVar.errCode == 0 && awt != null) {
                com.tencent.mm.plugin.finder.live.a aVar2 = com.tencent.mm.plugin.finder.live.a.ufi;
                com.tencent.mm.plugin.finder.live.a.a(this.hLl, this.vYe, awt);
                af.a aVar3 = this.tpa;
                if (aVar3 != null) {
                    aVar3.bn(Boolean.valueOf(awt.status == 0));
                    x xVar = x.SXb;
                    AppMethodBeat.o(253708);
                    return xVar;
                }
                AppMethodBeat.o(253708);
                return null;
            }
            af.a aVar4 = this.vXm;
            if (aVar4 != null) {
                aVar4.bn(Integer.valueOf(aVar.errCode));
                x xVar2 = x.SXb;
                AppMethodBeat.o(253708);
                return xVar2;
            }
            AppMethodBeat.o(253708);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String hLl;
        final /* synthetic */ long hvK;
        final /* synthetic */ String tpB;
        final /* synthetic */ af.a tpa;
        final /* synthetic */ af.a vXm;
        final /* synthetic */ z vYf;
        final /* synthetic */ String vYg;

        c(z zVar, long j2, String str, String str2, String str3, af.a aVar, af.a aVar2) {
            this.vYf = zVar;
            this.hvK = j2;
            this.hLl = str;
            this.tpB = str2;
            this.vYg = str3;
            this.tpa = aVar;
            this.vXm = aVar2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(253710);
            c.a aVar = (c.a) obj;
            FinderObject finderObject = ((ars) aVar.iLC).feedObject;
            if (aVar.errType == 0 && aVar.errCode == 0 && finderObject != null) {
                String str = this.vYf.TAG;
                StringBuilder sb = new StringBuilder("jumpLiveUI liveId: ");
                awe awe = finderObject.liveInfo;
                StringBuilder append = sb.append(awe != null ? awe.liveId : this.hvK).append(", username:");
                String str2 = finderObject.username;
                if (str2 == null && (str2 = this.hLl) == null) {
                    str2 = "";
                }
                Log.i(str, append.append(str2).toString());
                aj ajVar = (aj) g.ah(aj.class);
                Context context = MMApplicationContext.getContext();
                long j2 = finderObject.id;
                awe awe2 = finderObject.liveInfo;
                Long valueOf = awe2 != null ? Long.valueOf(awe2.liveId) : Long.valueOf(this.hvK);
                String str3 = finderObject.username;
                if (str3 == null && (str3 = this.hLl) == null) {
                    str3 = "";
                }
                String str4 = finderObject.objectNonceId;
                if (str4 == null) {
                    str4 = "";
                }
                ajVar.enterFinderLiveVisitorUI(context, j2, valueOf, str3, str4, "", this.tpB, finderObject.sessionBuffer, "", 0);
                if (!Util.isNullOrNil(this.vYg)) {
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[4];
                    String str5 = this.tpB;
                    if (str5 == null) {
                        str5 = "";
                    }
                    objArr[0] = str5;
                    objArr[1] = this.vYg;
                    objArr[2] = Long.valueOf(finderObject.id);
                    objArr[3] = "";
                    hVar.a(21140, objArr);
                }
                af.a aVar2 = this.tpa;
                if (aVar2 != null) {
                    aVar2.bn(null);
                    x xVar = x.SXb;
                    AppMethodBeat.o(253710);
                    return xVar;
                }
                AppMethodBeat.o(253710);
                return null;
            }
            af.a aVar3 = this.vXm;
            if (aVar3 != null) {
                aVar3.bn(Integer.valueOf(aVar.errCode));
                x xVar2 = x.SXb;
                AppMethodBeat.o(253710);
                return xVar2;
            }
            AppMethodBeat.o(253710);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ af.a tpa;
        final /* synthetic */ af.a vXm;

        d(af.a aVar, af.a aVar2) {
            this.tpa = aVar;
            this.vXm = aVar2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(253711);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                af.a aVar2 = this.tpa;
                if (aVar2 != null) {
                    aVar2.bn(null);
                    x xVar = x.SXb;
                    AppMethodBeat.o(253711);
                    return xVar;
                }
                AppMethodBeat.o(253711);
                return null;
            }
            af.a aVar3 = this.vXm;
            if (aVar3 != null) {
                aVar3.bn(Integer.valueOf(aVar.errCode));
                x xVar2 = x.SXb;
                AppMethodBeat.o(253711);
                return xVar2;
            }
            AppMethodBeat.o(253711);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final int dDc() {
        AppMethodBeat.i(253712);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvD().value().intValue() != 1) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            int dqA = com.tencent.mm.plugin.finder.storage.c.dqA();
            AppMethodBeat.o(253712);
            return dqA;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_album_long_video_max_duration_android, 1801);
        String a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_long_video_models_config_android, "");
        if (Util.isNullOrNil(a3)) {
            AppMethodBeat.o(253712);
            return a2;
        }
        try {
            JSONObject jSONObject = new JSONObject(a3);
            int i2 = jSONObject.getInt("apiLevel");
            double d2 = jSONObject.getDouble("durationMultiplier");
            int i3 = Build.VERSION.SDK_INT;
            if (d2 >= 0.0d && i3 <= i2) {
                int i4 = (int) (d2 * ((double) a2));
                AppMethodBeat.o(253712);
                return i4;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(253712);
        return a2;
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final float dDd() {
        AppMethodBeat.i(253713);
        float a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_long_video_max_wh_rate, 3.0f);
        Log.i(this.TAG, "getLongVideoMaxRatio ".concat(String.valueOf(a2)));
        AppMethodBeat.o(253713);
        return a2;
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final float dDe() {
        float f2;
        AppMethodBeat.i(253714);
        float a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_long_video_max_wh_rate, 3.0f);
        if (a2 >= 1.0f) {
            f2 = 1.0f / a2;
        } else {
            f2 = 0.33333334f;
        }
        Log.i(this.TAG, "getLongVideoMinRatio ".concat(String.valueOf(f2)));
        AppMethodBeat.o(253714);
        return f2;
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final ab ao(Activity activity) {
        AppMethodBeat.i(253715);
        p.h(activity, "context");
        j jVar = new j(activity);
        AppMethodBeat.o(253715);
        return jVar;
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final Object a(String str, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> bVar, af.a<Object> aVar, af.a<Integer> aVar2) {
        AppMethodBeat.i(253716);
        p.h(bVar, "lifeCycle");
        aa aaVar = aa.vYi;
        eoy b2 = aa.b(str, bVar, aVar, aVar2);
        AppMethodBeat.o(253716);
        return b2;
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void awv(String str) {
        AppMethodBeat.i(253717);
        aa aaVar = aa.vYi;
        aa.awv(str);
        AppMethodBeat.o(253717);
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void g(ImageView imageView, String str) {
        AppMethodBeat.i(253718);
        y yVar = y.vXH;
        if (!(imageView == null || str == null)) {
            m mVar = m.vVH;
            m.g(imageView, str);
        }
        AppMethodBeat.o(253718);
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void b(Context context, String str, String str2, int i2) {
        AppMethodBeat.i(253719);
        if (context != null) {
            String str3 = str;
            if (!(str3 == null || str3.length() == 0)) {
                Intent intent = new Intent();
                intent.putExtra("KEY_USERNAME", str);
                intent.putExtra("KEY_NICKNAME", str2);
                intent.putExtra("KEY_COMMENT_SCENE", i2);
                ((aj) g.ah(aj.class)).fillContextIdToIntent(14, 2, i2, intent);
                a aVar = a.vUU;
                a.T(context, intent);
                AppMethodBeat.o(253719);
                return;
            }
        }
        AppMethodBeat.o(253719);
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void a(String str, String str2, af.a<Boolean> aVar, af.a<Integer> aVar2) {
        AppMethodBeat.i(253720);
        if (str == null || str2 == null) {
            aVar2.bn(-1000);
            AppMethodBeat.o(253720);
            return;
        }
        com.tencent.mm.plugin.finder.live.a aVar3 = com.tencent.mm.plugin.finder.live.a.ufi;
        Boolean gK = com.tencent.mm.plugin.finder.live.a.gK(str, str2);
        if (gK != null) {
            aVar.bn(gK);
            AppMethodBeat.o(253720);
            return;
        }
        new com.tencent.mm.plugin.finder.cgi.d(str, str2).aYI().g(new a(str, str2, aVar, aVar2));
        AppMethodBeat.o(253720);
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void b(String str, String str2, af.a<Void> aVar, af.a<Integer> aVar2) {
        AppMethodBeat.i(253721);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || str == null || str2 == null) {
            aVar2.bn(-1000);
            AppMethodBeat.o(253721);
            return;
        }
        new e(str, str2).aYI().g(new d(aVar, aVar2));
        AppMethodBeat.o(253721);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "espLiveId", "", "liveStatus", "", "resp", "", "kotlin.jvm.PlatformType", "onLiveStatusCallback"})
    static final class b implements aj.b {
        final /* synthetic */ af.a tpa;

        b(af.a aVar) {
            this.tpa = aVar;
        }

        @Override // com.tencent.mm.plugin.i.a.aj.b
        public final void a(long j2, int i2, Object obj) {
            AppMethodBeat.i(253709);
            af.a aVar = this.tpa;
            if (aVar != null) {
                aVar.bn(Boolean.valueOf(i2 != 2));
                AppMethodBeat.o(253709);
                return;
            }
            AppMethodBeat.o(253709);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void a(long j2, af.a<Boolean> aVar) {
        AppMethodBeat.i(253722);
        ((aj) g.ah(aj.class)).getLiveInfo(Long.valueOf(j2), new b(aVar));
        AppMethodBeat.o(253722);
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void a(String str, long j2, String str2, String str3, af.a<Void> aVar, af.a<Integer> aVar2) {
        AppMethodBeat.i(253723);
        a(str, str2, aVar2, str3, j2, aVar, ((PluginFinder) g.ah(PluginFinder.class)).genContextId(4, 4, 65), "");
        AppMethodBeat.o(253723);
    }

    public final void a(String str, String str2, af.a<Integer> aVar, String str3, long j2, af.a<Void> aVar2, String str4, String str5) {
        AppMethodBeat.i(253724);
        p.h(str4, "contextId");
        p.h(str5, "reportExtraInfo");
        if (str2 != null) {
            new com.tencent.mm.plugin.finder.cgi.af(0, str3, 65, 2, "", true, null, null, 0, null, false, false, str2, null, 0, 20416).aYI().g(new c(this, j2, str, str4, str5, aVar2, aVar));
            AppMethodBeat.o(253724);
        } else if (aVar != null) {
            aVar.bn(-1000);
            AppMethodBeat.o(253724);
        } else {
            AppMethodBeat.o(253724);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void B(Context context, String str, String str2) {
        String str3;
        String str4;
        AppMethodBeat.i(253725);
        p.h(context, "context");
        Intent intent = new Intent();
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        intent.putExtra("key_encrypted_topic_id", str3);
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        intent.putExtra("key_activity_name", str4);
        Log.i(this.TAG, "enterActivityProfileUI :" + str + " eventName:" + str2);
        ((aj) g.ah(aj.class)).fillContextIdToIntent(4, 4, 59, intent);
        a aVar = a.vUU;
        a.aa(context, intent);
        AppMethodBeat.o(253725);
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final boolean dDf() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(253726);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean z3 = com.tencent.mm.plugin.finder.storage.c.dwJ().value().intValue() == 1;
        if (com.tencent.mm.n.h.aqJ().getInt("FinderNearbyLiveSwitch", 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        boolean showFinderEntry = ((aj) g.ah(aj.class)).showFinderEntry();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dwI().value().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i(this.TAG, "isEnableNearbyLiveFriends isValidUser:" + z + " hasFinder:" + showFinderEntry + " isEnableNearbyLiveFriends:" + z2);
        if (z3 || (z && showFinderEntry && z2)) {
            AppMethodBeat.o(253726);
            return true;
        }
        AppMethodBeat.o(253726);
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final boolean dDg() {
        AppMethodBeat.i(253727);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dwK().value().intValue() == 1) {
            AppMethodBeat.o(253727);
            return true;
        }
        AppMethodBeat.o(253727);
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final int dli() {
        AppMethodBeat.i(253728);
        com.tencent.mm.plugin.finder.nearby.a aVar = com.tencent.mm.plugin.finder.nearby.a.uQd;
        int dli = com.tencent.mm.plugin.finder.nearby.a.dli();
        AppMethodBeat.o(253728);
        return dli;
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void dl(Context context, String str) {
        AppMethodBeat.i(261488);
        p.h(context, "context");
        if (Util.isNullOrNil(str)) {
            Log.i(this.TAG, "enterProfileForWxPay finderUserName empty");
            AppMethodBeat.o(261488);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("finder_username", str);
        ((aj) g.ah(aj.class)).fillContextIdToIntent(16, 2, 32, intent);
        a aVar = a.vUU;
        a.enterFinderProfileUI(context, intent);
        AppMethodBeat.o(261488);
    }

    @Override // com.tencent.mm.plugin.i.a.af
    public final void d(Context context, String str, String str2, boolean z) {
        AppMethodBeat.i(261489);
        p.h(context, "context");
        if (Util.isNullOrNil(str)) {
            Log.i(this.TAG, "enterProfileForWxPay exportId empty");
            AppMethodBeat.o(261489);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("from_user", com.tencent.mm.model.z.aTY());
        intent.putExtra("feed_encrypted_object_id", str);
        if (str2 == null) {
            str2 = "";
        }
        intent.putExtra("feed_object_nonceId", str2);
        intent.putExtra("key_need_related_list", z);
        intent.putExtra("key_comment_scene", 16);
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.avn("entrance") != 0) {
            a aVar2 = a.vUU;
            a.fw(context);
            AppMethodBeat.o(261489);
            return;
        }
        ((aj) g.ah(aj.class)).fillContextIdToIntent(16, 2, 25, intent);
        a aVar3 = a.vUU;
        a.F(context, intent);
        AppMethodBeat.o(261489);
    }
}
