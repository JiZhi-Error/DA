package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.i;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042'\u0010\u000f\u001a#\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00140\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/logic/FinderNoInterestedLogic;", "", "()V", "TAG", "", "TYPE_NO_INTERESTED_OF_AUTHOR", "", "TYPE_NO_INTERESTED_OF_FEED", "handleNoInterestedAuthor", "", "context", "Landroid/content/Context;", "feedId", "", "objectNonceId", "onSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "", "plugin-finder_release"})
public final class c {
    public static final c tUx = new c();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ List tUy;

        a(List list) {
            this.tUy = list;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(244539);
            c.a aVar = (c.a) obj;
            Log.i("Finder.NoInterestedLogic", "[CgiFinderFeedBack] errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errCode == 0 && aVar.errType == 0) {
                for (Number number : this.tUy) {
                    long longValue = number.longValue();
                    c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    c.a.FT(longValue);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244539);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(166015);
        AppMethodBeat.o(166015);
    }

    private c() {
    }

    public static void a(Context context, long j2, String str, b<? super Integer, ? extends List<Long>> bVar) {
        com.tencent.mm.plugin.finder.event.a b2;
        AppMethodBeat.i(244540);
        p.h(context, "context");
        p.h(str, "objectNonceId");
        p.h(bVar, "onSelectedCallback");
        List list = (List) bVar.invoke(2);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        new i(j2, str, fH != null ? fH.dIx() : null).aYI().j(new a(list));
        e.INSTANCE.idkeyStat(1278, 9, 1, false);
        k kVar = k.vfA;
        String simpleName = context.getClass().getSimpleName();
        p.g(simpleName, "context.javaClass.simpleName");
        p.h(simpleName, "page");
        FinderItem Fc = k.Fc(j2);
        if (Fc != null) {
            FinderObject feedObject = Fc.getFeedObject();
            String str2 = ((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD() + ',' + simpleName + ',' + k.Fg(feedObject.id) + ',' + feedObject.username + ',' + Fc.getMediaType() + ',' + feedObject.recommendType + ',' + feedObject.likeCount + ',' + feedObject.commentCount + ',' + feedObject.friendLikeCount + ",0,0,0,2";
            Log.i(k.TAG, "18946 ".concat(String.valueOf(str2)));
            e.INSTANCE.kvStat(18946, str2);
        }
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context);
        if (fH2 == null || (b2 = FinderReporterUIC.b(fH2)) == null) {
            AppMethodBeat.o(244540);
            return;
        }
        b2.cZR().Et(j2);
        AppMethodBeat.o(244540);
    }
}
