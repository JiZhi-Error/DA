package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001f\u001a\u00020\bH\u0002J\u0012\u0010 \u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010!\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0019H\u0002J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190$2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010%\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0012\u0010&\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\bH\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "MENU_ID_SET_NO_FOLLOW_CONFIRM", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "followConfirmSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "isFollowed", "", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "topicHeader", "Landroid/view/View;", "addTopicHeader", "", "isShowTag", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "cloneTopicInfo", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$TopicInfo;", "topicStr", "", "confirmFollow", "createHotTopicLayout", "getTopicHeaderView", "getTopicMaxTextWidth", "getTopicTimelineHeaderView", "handleFollowAction", "onClickHotTopic", "optFakeTopics", "", "refreshHeader", "setFollowView", "setNewsText", "topicCount", "setViewFollowed", "Companion", "TopicInfo", "plugin-finder_release"})
public final class y {
    public static final a tOU = new a((byte) 0);
    final MMActivity gte;
    private final RefreshLoadMoreLayout tLS;
    private final int tOR = CommonUtils.MAX_TIMEOUT_MS;
    private boolean tOS;
    private View tOT;

    static {
        AppMethodBeat.i(244006);
        AppMethodBeat.o(244006);
    }

    public y(MMActivity mMActivity, RefreshLoadMoreLayout refreshLoadMoreLayout) {
        p.h(mMActivity, "context");
        p.h(refreshLoadMoreLayout, "rlLayout");
        AppMethodBeat.i(244005);
        this.gte = mMActivity;
        this.tLS = refreshLoadMoreLayout;
        AppMethodBeat.o(244005);
    }

    public static final /* synthetic */ void b(y yVar, boolean z) {
        AppMethodBeat.i(244008);
        yVar.mZ(z);
        AppMethodBeat.o(244008);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(bds bds) {
        AppMethodBeat.i(244001);
        Log.i("Finder.FinderNewsTopicHelper", "refreshHeader ".concat(String.valueOf(bds)));
        if (bds != null) {
            IH(bds.LzC);
            b(bds);
        }
        if (bds == null) {
            IH(5);
            b(bds);
        }
        AppMethodBeat.o(244001);
    }

    private final void IH(int i2) {
        AppMethodBeat.i(244002);
        View view = this.tOT;
        if (view == null) {
            AppMethodBeat.o(244002);
        } else if (i2 == 0) {
            View findViewById = view.findViewById(R.id.itp);
            p.g(findViewById, "findViewById<TextView>(R.id.topic_news_count_text)");
            ((TextView) findViewById).setText(view.getContext().getString(R.string.d33, k.gm(2, 5)));
            AppMethodBeat.o(244002);
        } else {
            View findViewById2 = view.findViewById(R.id.itp);
            p.g(findViewById2, "findViewById<TextView>(R.id.topic_news_count_text)");
            ((TextView) findViewById2).setText(view.getContext().getString(R.string.d33, k.gm(2, i2)));
            AppMethodBeat.o(244002);
        }
    }

    private final void b(bds bds) {
        boolean z = false;
        AppMethodBeat.i(244003);
        if ((bds != null ? bds.followFlag : 0) > 0) {
            z = true;
        }
        this.tOS = z;
        mZ(this.tOS);
        Log.i("Finder.FinderNewsTopicHelper", "setFollowView topicHeader " + this.tOT);
        View view = this.tOT;
        if (view != null) {
            view.findViewById(R.id.itq).setOnClickListener(new b(this, bds));
            AppMethodBeat.o(244003);
            return;
        }
        AppMethodBeat.o(244003);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$setFollowView$1$1"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ y tOV;
        final /* synthetic */ bds tOW;

        b(y yVar, bds bds) {
            this.tOV = yVar;
            this.tOW = bds;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(244000);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$setFollowView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            y.a(this.tOV, this.tOW);
            this.tOV.tOS = !this.tOV.tOS;
            y.b(this.tOV, this.tOV.tOS);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$setFollowView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(244000);
        }
    }

    private final void mZ(boolean z) {
        AppMethodBeat.i(244004);
        Log.i("Finder.FinderNewsTopicHelper", "setViewFollowed topicHeader " + this.tOT);
        View view = this.tOT;
        if (view == null) {
            AppMethodBeat.o(244004);
        } else if (z) {
            ((TextView) view.findViewById(R.id.itr)).setText(R.string.dzl);
            Context context = view.getContext();
            p.g(context, "context");
            ((TextView) view.findViewById(R.id.itr)).setTextColor(context.getResources().getColor(R.color.fm));
            view.findViewById(R.id.itq).setBackgroundResource(R.drawable.a2j);
            AppMethodBeat.o(244004);
        } else {
            ((TextView) view.findViewById(R.id.itr)).setText(R.string.hp0);
            Context context2 = view.getContext();
            p.g(context2, "context");
            ((TextView) view.findViewById(R.id.itr)).setTextColor(context2.getResources().getColor(R.color.afz));
            view.findViewById(R.id.itq).setBackgroundResource(R.drawable.a2i);
            AppMethodBeat.o(244004);
        }
    }

    public static final /* synthetic */ void a(y yVar, bds bds) {
        int i2;
        AppMethodBeat.i(244007);
        if (bds != null) {
            if (yVar.tOS) {
                ck.a aVar = ck.twr;
                i2 = ck.tvc;
            } else {
                ck.a aVar2 = ck.twr;
                i2 = ck.tvb;
            }
            long j2 = bds.twp;
            String str = bds.twq;
            if (str == null) {
                str = "";
            }
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            g.azz().b(new ck(j2, str, i2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(yVar.gte).get(FinderReporterUIC.class)).dIx()));
            AppMethodBeat.o(244007);
            return;
        }
        AppMethodBeat.o(244007);
    }
}
