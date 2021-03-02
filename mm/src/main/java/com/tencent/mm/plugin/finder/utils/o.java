package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.r;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002Je\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e23\u0010\u001f\u001a/\u0012%\u0012#\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00110 R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "objectStatusReqMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "getObjectStatusReqMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "canReqObjectStatus", "", "feedId", "clearObjectStatusStates", "", "createTriple", "Lkotlin/Triple;", "tips", "refreshInterval", "lastReqTime", "waitTime", "refreshObjectStatus", "context", "Landroid/content/Context;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "scene", "", "cgiBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "ObjectStatusReqState", "plugin-finder_release"})
public final class o {
    private static final String TAG = TAG;
    private static final ConcurrentHashMap<Long, a> vVS = new ConcurrentHashMap<>();
    public static final o vVT = new o();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ long txv;
        final /* synthetic */ long vVV;

        b(BaseFinderFeed baseFinderFeed, long j2, long j3) {
            this.tEM = baseFinderFeed;
            this.txv = j2;
            this.vVV = j3;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(167891);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                FinderObject finderObject = ((ars) aVar.iLC).feedObject;
                if (finderObject != null) {
                    o oVar = o.vVT;
                    Log.i(o.getTAG(), "lxl CgiGetFinderFeedComment change objectStatus, from:" + this.tEM.feedObject.getFeedObject().objectStatus + ", to:" + finderObject.objectStatus + ", waitTime:" + ((ars) aVar.iLC).LDg);
                    this.tEM.feedObject.getFeedObject().objectStatus = finderObject.objectStatus;
                }
                if (this.tEM.feedObject.isOnlySelfSee()) {
                    o oVar2 = o.vVT;
                    o.l(this.txv, this.vVV, (long) ((ars) aVar.iLC).LDg);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167891);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(167895);
        AppMethodBeat.o(167895);
    }

    private o() {
    }

    public static final /* synthetic */ r awi(String str) {
        AppMethodBeat.i(167897);
        r<String, String, String> awh = awh(str);
        AppMethodBeat.o(167897);
        return awh;
    }

    public static String getTAG() {
        return TAG;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "", "lastReqTime", "", "waitTime", "(JJ)V", "getLastReqTime", "()J", "getWaitTime", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a {
        final long vVU;
        final long waitTime;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.vVU == aVar.vVU && this.waitTime == aVar.waitTime)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.vVU;
            long j3 = this.waitTime;
            return (((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(167890);
            String str = "ObjectStatusReqState(lastReqTime=" + this.vVU + ", waitTime=" + this.waitTime + ")";
            AppMethodBeat.o(167890);
            return str;
        }

        public a(long j2, long j3) {
            this.vVU = j2;
            this.waitTime = j3;
        }
    }

    private static r<String, String, String> awh(String str) {
        AppMethodBeat.i(167894);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        List<String> a2 = n.a(str, new String[]{"#"});
        if (a2.size() >= 3) {
            String str5 = (String) j.L(a2, 0);
            if (str5 == null) {
                str2 = "";
            } else {
                str2 = str5;
            }
            String str6 = (String) j.L(a2, 1);
            if (str6 == null) {
                str3 = "";
            } else {
                str3 = str6;
            }
            str4 = (String) j.L(a2, 2);
            if (str4 == null) {
                str4 = "";
            }
        }
        if (Util.isNullOrNil(str2)) {
            y yVar = y.vXH;
            str2 = y.dP("FinderSafeSelfSeeForward", R.string.d8u);
        }
        if (Util.isNullOrNil(str3)) {
            y yVar2 = y.vXH;
            str3 = y.dP("FinderSafeSelfSeeShare", R.string.d8v);
        }
        if (Util.isNullOrNil(str4)) {
            y yVar3 = y.vXH;
            str4 = y.dP("FinderSafeSelfSeeCollect", R.string.d8t);
        }
        r<String, String, String> rVar = new r<>(str2, str3, str4);
        AppMethodBeat.o(167894);
        return rVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ kotlin.g.a.b vVW;

        c(BaseFinderFeed baseFinderFeed, kotlin.g.a.b bVar) {
            this.tEM = baseFinderFeed;
            this.vVW = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(167892);
            String notShareMsg = this.tEM.feedObject.getNotShareMsg();
            if (notShareMsg == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(167892);
                throw tVar;
            }
            String obj2 = n.trim(notShareMsg).toString();
            o oVar = o.vVT;
            Log.i(o.getTAG(), "[refreshObjectStatus] tips=".concat(String.valueOf(obj2)));
            kotlin.g.a.b bVar = this.vVW;
            o oVar2 = o.vVT;
            bVar.invoke(o.awi(obj2));
            x xVar = x.SXb;
            AppMethodBeat.o(167892);
            return xVar;
        }
    }

    public static r<String, String, String> a(Context context, BaseFinderFeed baseFinderFeed, int i2, kotlin.g.a.b<? super r<String, String, String>, x> bVar) {
        boolean z;
        AppMethodBeat.i(253456);
        p.h(context, "context");
        p.h(baseFinderFeed, "feed");
        p.h(bVar, "cgiBack");
        long id = baseFinderFeed.feedObject.getId();
        long aWy = cl.aWy() / 1000;
        a aVar = vVS.get(Long.valueOf(id));
        if (aVar == null) {
            z = true;
        } else if ((cl.aWy() / 1000) - aVar.vVU >= aVar.waitTime) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String objectNonceId = baseFinderFeed.feedObject.getObjectNonceId();
            String userName = baseFinderFeed.feedObject.getUserName();
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            new af(id, objectNonceId, 3, i2, userName, false, null, null, 0, null, false, true, null, fH != null ? fH.dIx() : null, 0, 22496).aYI().h(new b(baseFinderFeed, id, aWy)).b(new c(baseFinderFeed, bVar));
        } else {
            a aVar3 = vVS.get(Long.valueOf(id));
            if (aVar3 != null) {
                Log.w(TAG, "can't request. lastReqTime=" + aWy + " lastReqTime=" + aVar3.vVU + " waitTime=" + aVar3.waitTime);
            }
        }
        String notShareMsg = baseFinderFeed.feedObject.getNotShareMsg();
        if (notShareMsg == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(253456);
            throw tVar;
        }
        r<String, String, String> awh = awh(n.trim(notShareMsg).toString());
        AppMethodBeat.o(253456);
        return awh;
    }

    public static final /* synthetic */ void l(long j2, long j3, long j4) {
        AppMethodBeat.i(167896);
        Log.i(TAG, "[refreshInterval] feedId=" + j2 + " lastReqTime=" + j3 + " waitTime=" + j4);
        vVS.put(Long.valueOf(j2), new a(j3, j4));
        AppMethodBeat.o(167896);
    }
}
