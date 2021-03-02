package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.live.model.cgi.ah;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.view.adapter.m;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.fgd;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001YB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>J\u0006\u0010@\u001a\u00020AJ\u0016\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0015J\u0006\u0010E\u001a\u00020>J\b\u0010F\u001a\u00020>H\u0002J\u0012\u0010G\u001a\u00020>2\b\u0010H\u001a\u0004\u0018\u00010\u0011H\u0016J,\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u00152\b\u0010L\u001a\u0004\u0018\u00010 2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0006\u0010O\u001a\u00020>J\b\u0010P\u001a\u00020>H\u0002J\b\u0010Q\u001a\u00020>H\u0002J\b\u0010R\u001a\u00020>H\u0002J\u000e\u0010S\u001a\u00020>2\u0006\u0010T\u001a\u00020UJ\u0010\u0010V\u001a\u00020>2\u0006\u0010W\u001a\u00020XH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00170\u001fj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0017`!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u0002040'j\b\u0012\u0004\u0012\u000204`)X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006Z"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;)V", "adapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter;", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "contentGroup", "Landroid/view/View;", "contentTip", "Landroid/widget/TextView;", "continueFlag", "", "curPkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "emptyTv", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "listView", "Landroid/support/v7/widget/RecyclerView;", "loadingView", "localMicMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "offset", SearchIntents.EXTRA_QUERY, "recommendAnchorList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/collections/ArrayList;", "requestId", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRoot", "()Landroid/view/ViewGroup;", "searchAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorSearchAdapter;", "searchCancelTv", "searchClearIcon", "searchContactList", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "searchEdit", "Landroid/widget/EditText;", "searchGroup", "searchIcon", "searchRoot", "showMode", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "dispatchHidePanel", "", "hideInviteAnchorLinkPanel", "isVisible", "", "keyboardChange", "show", "height", "loadRecommendInfo", "loadSearchData", "onClick", "v", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showInviteAnchorLinkPanel", "showKVB", "switchToNormalMode", "switchToSearchMode", "updateLiveRoomData", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "updateSearchData", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchResponse;", "Companion", "plugin-finder_release"})
public final class t implements View.OnClickListener, com.tencent.mm.ak.i {
    public static final String TAG = TAG;
    private static final int URd = 0;
    private static final int URe = 1;
    public static final a URf = new a((byte) 0);
    private int HiI = URd;
    private final WeImageView OxK;
    private final EditText UNF;
    private final View UNJ;
    private com.tencent.mm.plugin.finder.live.viewmodel.e UOC;
    private final View UQS;
    private final TextView UQT;
    private final WeImageView UQU;
    private final TextView UQV;
    private final RecyclerView UQW;
    private final com.tencent.mm.plugin.finder.live.view.adapter.l UQX = new com.tencent.mm.plugin.finder.live.view.adapter.l();
    private final m UQY = new m();
    private final HashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.e> UQZ = new HashMap<>();
    public final ArrayList<avn> URa = new ArrayList<>();
    private ArrayList<bbz> URb = new ArrayList<>();
    final o URc;
    private int continueFlag;
    private String dPI = "";
    final com.tencent.mm.live.c.b hOp;
    private final WeImageView hPV;
    private final View hSw;
    private final View hVz;
    public final ViewGroup hwr;
    private int offset;
    private final TextView qqJ;
    private String query = "";
    private final RefreshLoadMoreLayout tLS;
    private com.tencent.mm.bw.b tVM;
    private cf vtL;

    public t(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, o oVar) {
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(oVar, "basePlugin");
        AppMethodBeat.i(261143);
        this.hwr = viewGroup;
        this.hOp = bVar;
        this.URc = oVar;
        this.hwr.setTranslationX((float) au.az(this.hwr.getContext()).x);
        View findViewById = this.hwr.findViewById(R.id.jx7);
        p.g(findViewById, "root.findViewById(R.id.f…te_anchor_link_close_btn)");
        this.hPV = (WeImageView) findViewById;
        View findViewById2 = this.hwr.findViewById(R.id.jxf);
        p.g(findViewById2, "root.findViewById(R.id.f…r_link_search_group_root)");
        this.UQS = findViewById2;
        View findViewById3 = this.hwr.findViewById(R.id.jxe);
        p.g(findViewById3, "root.findViewById(R.id.f…anchor_link_search_group)");
        this.UNJ = findViewById3;
        View findViewById4 = this.hwr.findViewById(R.id.jxc);
        p.g(findViewById4, "root.findViewById(R.id.f…or_link_search_cancel_tv)");
        this.UQT = (TextView) findViewById4;
        View findViewById5 = this.hwr.findViewById(R.id.jx6);
        p.g(findViewById5, "root.findViewById(R.id.f…e_anchor_link_clear_icon)");
        this.UQU = (WeImageView) findViewById5;
        View findViewById6 = this.hwr.findViewById(R.id.jxg);
        p.g(findViewById6, "root.findViewById(R.id.f…_anchor_link_search_icon)");
        this.OxK = (WeImageView) findViewById6;
        View findViewById7 = this.hwr.findViewById(R.id.jxd);
        p.g(findViewById7, "root.findViewById(R.id.f…_anchor_link_search_edit)");
        this.UNF = (EditText) findViewById7;
        View findViewById8 = this.hwr.findViewById(R.id.jx_);
        p.g(findViewById8, "root.findViewById(R.id.f…chor_link_content_tip_tv)");
        this.UQV = (TextView) findViewById8;
        View findViewById9 = this.hwr.findViewById(R.id.jx8);
        p.g(findViewById9, "root.findViewById(R.id.f…or_link_content_empty_tv)");
        this.qqJ = (TextView) findViewById9;
        View findViewById10 = this.hwr.findViewById(R.id.jxb);
        p.g(findViewById10, "root.findViewById(R.id.f…vite_anchor_link_loading)");
        this.hSw = findViewById10;
        View findViewById11 = this.hwr.findViewById(R.id.jxa);
        p.g(findViewById11, "root.findViewById(R.id.f…te_anchor_link_list_view)");
        this.UQW = (RecyclerView) findViewById11;
        View findViewById12 = this.hwr.findViewById(R.id.jx9);
        p.g(findViewById12, "root.findViewById(R.id.f…nchor_link_content_group)");
        this.hVz = findViewById12;
        View findViewById13 = this.hwr.findViewById(R.id.h7t);
        p.g(findViewById13, "root.findViewById(R.id.rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById13;
        this.tLS.setEnablePullDownHeader(false);
        View inflate = aa.jQ(this.hwr.getContext()).inflate(R.layout.b21, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.ep1);
        if (textView != null) {
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            textView.setTextColor(context.getResources().getColor(R.color.ua));
        }
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        p.g(inflate, "footer");
        refreshLoadMoreLayout.setLoadMoreFooter(inflate);
        this.tLS.setActionCallback(new RefreshLoadMoreLayout.a(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.t.AnonymousClass1 */
            final /* synthetic */ t URg;

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void ED(int i2) {
                AppMethodBeat.i(261120);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
                super.ED(i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
                AppMethodBeat.o(261120);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void a(RefreshLoadMoreLayout.c cVar) {
                AppMethodBeat.i(261122);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                super.a(cVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(261122);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
                AppMethodBeat.i(261121);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                super.onRefreshEnd(cVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(261121);
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.URg = r1;
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void cxo() {
                View findViewById;
                TextView textView;
                TextView textView2;
                View findViewById2;
                TextView textView3;
                TextView textView4;
                AppMethodBeat.i(261119);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
                Log.i(t.TAG, "loadMoreSearchData query:" + this.URg.query);
                String str = this.URg.query;
                if (this.URg.continueFlag == 1) {
                    t tVar = this.URg;
                    y yVar = y.vXH;
                    tVar.dPI = y.dCV();
                    this.URg.vtL = new cf(str, this.URg.offset, this.URg.dPI, this.URg.tVM, 11, (bbn) null, 96);
                    com.tencent.mm.kernel.g.azz().b(this.URg.vtL);
                    com.tencent.mm.kernel.g.azz().a(3820, this.URg);
                    View loadMoreFooter = this.URg.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView4 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView4.setText(R.string.d0l);
                    }
                    View loadMoreFooter2 = this.URg.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView3.setVisibility(0);
                    }
                    View loadMoreFooter3 = this.URg.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (findViewById2 = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                        findViewById2.setVisibility(8);
                    }
                } else {
                    View loadMoreFooter4 = this.URg.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter4 == null || (textView2 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                        textView2.setText(R.string.d0m);
                    }
                    View loadMoreFooter5 = this.URg.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter5 == null || (textView = (TextView) loadMoreFooter5.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    View loadMoreFooter6 = this.URg.tLS.getLoadMoreFooter();
                    if (!(loadMoreFooter6 == null || (findViewById = loadMoreFooter6.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
                AppMethodBeat.o(261119);
            }
        });
        this.hwr.getLayoutParams().height = (au.az(this.hwr.getContext()).y * 2) / 3;
        ViewGroup.LayoutParams layoutParams = this.tLS.getLayoutParams();
        if (layoutParams == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(261143);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = au.aD(this.hwr.getContext());
        RecyclerView recyclerView = this.UQW;
        this.hwr.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.UQW.setAdapter(this.UQX);
        this.UQX.UOD = new kotlin.g.a.b<avn, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.t.AnonymousClass2 */
            final /* synthetic */ t URg;

            {
                this.URg = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(avn avn) {
                String str;
                String str2;
                String str3 = null;
                AppMethodBeat.i(261123);
                avn avn2 = avn;
                p.h(avn2, LocaleUtil.ITALIAN);
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = this.URg.URc.getLiveData().UPZ;
                p.g(list, "basePlugin.liveData.audienceLinkMicUserList");
                if (!list.isEmpty()) {
                    Context context = this.URg.hwr.getContext();
                    Context context2 = this.URg.hwr.getContext();
                    p.g(context2, "root.context");
                    u.makeText(context, context2.getResources().getString(R.string.ja1), 0).show();
                } else {
                    com.tencent.mm.plugin.finder.live.viewmodel.e eVar = this.URg.UOC;
                    if (eVar != null) {
                        str = eVar.username;
                    } else {
                        str = null;
                    }
                    FinderContact finderContact = avn2.contact;
                    if (Util.isEqual(str, finderContact != null ? finderContact.username : null)) {
                        b.C0376b.a(this.URg.hOp, b.c.hNP);
                    } else {
                        Bundle bundle = new Bundle();
                        this.URg.hUk();
                        this.URg.URc.hRy.hide();
                        HashMap hashMap = this.URg.UQZ;
                        FinderContact finderContact2 = avn2.contact;
                        com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = (com.tencent.mm.plugin.finder.live.viewmodel.e) hashMap.get(finderContact2 != null ? finderContact2.username : null);
                        if (eVar2 == null) {
                            String str4 = t.TAG;
                            StringBuilder sb = new StringBuilder("invite panel item click, apply pk. nickname:");
                            FinderContact finderContact3 = avn2.contact;
                            if (finderContact3 != null) {
                                str2 = finderContact3.nickname;
                            } else {
                                str2 = null;
                            }
                            Log.i(str4, sb.append(str2).toString());
                            bundle.putByteArray("PARAM_FINDER_LIVE_BYTES_DATA", avn2.toByteArray());
                            this.URg.hOp.statusChange(b.c.vCO, bundle);
                        } else {
                            this.URg.URc.getLiveData().uEB = eVar2;
                            b.C0376b.a(this.URg.hOp, b.c.vSe);
                            String str5 = t.TAG;
                            StringBuilder sb2 = new StringBuilder("invite panel item click, accept pk. nickname:");
                            FinderContact finderContact4 = avn2.contact;
                            Log.i(str5, sb2.append(finderContact4 != null ? finderContact4.nickname : null).toString());
                        }
                        k kVar = k.vkd;
                        s.x xVar = s.x.INVITE_ANCHOR_LINKMIC;
                        FinderContact finderContact5 = avn2.contact;
                        if (finderContact5 != null) {
                            str3 = finderContact5.username;
                        }
                        k.a(xVar, str3, -1, -1);
                    }
                }
                x xVar2 = x.SXb;
                AppMethodBeat.o(261123);
                return xVar2;
            }
        };
        this.UQY.UOD = new kotlin.g.a.b<bbz, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.t.AnonymousClass3 */
            final /* synthetic */ t URg;

            {
                this.URg = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(bbz bbz) {
                boolean z;
                String str = null;
                AppMethodBeat.i(261124);
                bbz bbz2 = bbz;
                p.h(bbz2, "searchInfo");
                String str2 = t.TAG;
                StringBuilder sb = new StringBuilder("invite search panel item click, nickname:");
                FinderContact finderContact = bbz2.contact;
                Log.i(str2, sb.append(finderContact != null ? finderContact.nickname : null).toString());
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = this.URg.URc.getLiveData().UPZ;
                p.g(list, "basePlugin.liveData.audienceLinkMicUserList");
                if (!list.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Context context = this.URg.hwr.getContext();
                    Context context2 = this.URg.hwr.getContext();
                    p.g(context2, "root.context");
                    u.makeText(context, context2.getResources().getString(R.string.ja1), 0).show();
                } else {
                    FinderContact finderContact2 = bbz2.contact;
                    if (finderContact2 != null) {
                        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = this.URg.UOC;
                        if (eVar != null) {
                            str = eVar.username;
                        }
                        if (Util.isEqual(str, finderContact2.username)) {
                            b.C0376b.a(this.URg.hOp, b.c.hNP);
                        } else {
                            Bundle bundle = new Bundle();
                            this.URg.hUk();
                            this.URg.URc.hRy.hide();
                            com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = (com.tencent.mm.plugin.finder.live.viewmodel.e) this.URg.UQZ.get(finderContact2.username);
                            if (eVar2 == null) {
                                avn avn = new avn();
                                avn.contact = finderContact2;
                                Log.i(t.TAG, "invite search panel item click, apply pk.");
                                bundle.putByteArray("PARAM_FINDER_LIVE_BYTES_DATA", avn.toByteArray());
                                this.URg.hOp.statusChange(b.c.vCO, bundle);
                            } else {
                                this.URg.URc.getLiveData().uEB = eVar2;
                                b.C0376b.a(this.URg.hOp, b.c.vSe);
                                Log.i(t.TAG, "invite search panel item click, accept pk.");
                            }
                            k kVar = k.vkd;
                            k.a(s.x.INVITE_ANCHOR_LINKMIC, finderContact2.username, -1, -1);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(261124);
                return xVar;
            }
        };
        this.UNF.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.t.AnonymousClass4 */
            final /* synthetic */ t URg;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.URg = r1;
            }

            public final void afterTextChanged(Editable editable) {
                boolean z;
                AppMethodBeat.i(261125);
                Editable text = this.URg.UNF.getText();
                String obj = text != null ? text.toString() : null;
                String str = obj;
                if (str == null || str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.URg.UQU.setVisibility(8);
                } else {
                    this.URg.UQU.setVisibility(0);
                }
                t tVar = this.URg;
                if (obj == null) {
                    obj = "";
                }
                tVar.query = obj;
                AppMethodBeat.o(261125);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.UNF.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.t.AnonymousClass5 */
            final /* synthetic */ t URg;

            {
                this.URg = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
                if (r6.getAction() == 66) goto L_0x0017;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onEditorAction(android.widget.TextView r4, int r5, android.view.KeyEvent r6) {
                /*
                    r3 = this;
                    r2 = 261126(0x3fc06, float:3.65915E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    r0 = 3
                    if (r0 == r5) goto L_0x0017
                    java.lang.String r0 = "keyEvent"
                    kotlin.g.b.p.g(r6, r0)
                    int r0 = r6.getAction()
                    r1 = 66
                    if (r0 != r1) goto L_0x0027
                L_0x0017:
                    com.tencent.mm.plugin.finder.live.widget.t r0 = r3.URg
                    com.tencent.mm.plugin.finder.live.widget.t.w(r0)
                    com.tencent.mm.plugin.finder.live.widget.t r0 = r3.URg
                    android.widget.EditText r0 = com.tencent.mm.plugin.finder.live.widget.t.e(r0)
                    android.view.View r0 = (android.view.View) r0
                    com.tencent.mm.sdk.platformtools.Util.hideVKB(r0)
                L_0x0027:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.widget.t.AnonymousClass5.onEditorAction(android.widget.TextView, int, android.view.KeyEvent):boolean");
            }
        });
        this.UQT.setOnClickListener(this);
        this.UQU.setOnClickListener(this);
        this.hPV.setOnClickListener(this);
        AppMethodBeat.o(261143);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$Companion;", "", "()V", "SHOW_MODE_NORMAL", "", "getSHOW_MODE_NORMAL", "()I", "SHOW_MODE_SEARCH", "getSHOW_MODE_SEARCH", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(261144);
        AppMethodBeat.o(261144);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$loadRecommendInfo$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMicCandidateListResponse;", "plugin-finder_release"})
    public static final class d implements ah.a {
        final /* synthetic */ t URg;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d(t tVar) {
            this.URg = tVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.ah.a
        public final void a(fgd fgd) {
            AppMethodBeat.i(261130);
            p.h(fgd, "resp");
            Log.i(t.TAG, "doGetMicCandidateList resp.contacts:" + fgd.LDz.size());
            this.URg.URa.clear();
            if (fgd.LDz != null) {
                this.URg.URa.addAll(fgd.LDz);
            }
            AppMethodBeat.o(261130);
        }
    }

    public final void hTI() {
        AppMethodBeat.i(261137);
        Log.i(TAG, "switchToNormalMode");
        this.HiI = URd;
        this.hSw.setVisibility(8);
        this.UQT.setVisibility(4);
        this.UQU.setVisibility(8);
        int[] iArr = new int[2];
        ViewGroup.LayoutParams layoutParams = this.UNJ.getLayoutParams();
        if (layoutParams == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(261137);
            throw tVar;
        }
        iArr[0] = ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        iArr[1] = 0;
        ValueAnimator ofInt = ObjectAnimator.ofInt(iArr);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new e(this));
        ofInt.start();
        this.UNF.setText((CharSequence) null);
        this.UQW.setAdapter(this.UQX);
        ArrayList<avn> arrayList = this.URa;
        if (arrayList == null || arrayList.isEmpty()) {
            this.UQV.setVisibility(8);
            this.UQW.setVisibility(8);
            this.qqJ.setVisibility(8);
            this.hSw.setVisibility(8);
        } else {
            this.UQV.setVisibility(0);
            this.UQW.setVisibility(0);
            this.qqJ.setVisibility(8);
            this.hSw.setVisibility(8);
            this.UQX.ad(this.URa);
            this.UQX.notifyDataSetChanged();
        }
        Util.hideVKB(this.UNF);
        AppMethodBeat.o(261137);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$switchToNormalMode$1$1"})
    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ t URg;

        e(t tVar) {
            this.URg = tVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(261131);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(261131);
                throw tVar;
            }
            int intValue = ((Integer) animatedValue).intValue();
            ViewGroup.LayoutParams layoutParams = this.URg.UNJ.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(261131);
                throw tVar2;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(intValue);
            this.URg.UNJ.requestLayout();
            AppMethodBeat.o(261131);
        }
    }

    public final void hUj() {
        AppMethodBeat.i(261138);
        Log.i(TAG, "switchToSearchMode");
        this.HiI = URe;
        this.UQV.setVisibility(8);
        this.UQW.setVisibility(8);
        int[] iArr = new int[2];
        ViewGroup.LayoutParams layoutParams = this.UNJ.getLayoutParams();
        if (layoutParams == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(261138);
            throw tVar;
        }
        iArr[0] = ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        int measuredWidth = this.UQT.getMeasuredWidth();
        ViewGroup.LayoutParams layoutParams2 = this.UQT.getLayoutParams();
        if (layoutParams2 == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(261138);
            throw tVar2;
        }
        iArr[1] = ((ViewGroup.MarginLayoutParams) layoutParams2).getMarginStart() + measuredWidth;
        ValueAnimator ofInt = ObjectAnimator.ofInt(iArr);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new f(this));
        ofInt.addListener(new g(this));
        ofInt.start();
        this.UNF.post(new h(this));
        this.UQW.setAdapter(this.UQY);
        AppMethodBeat.o(261138);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$switchToSearchMode$1$1"})
    static final class f implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ t URg;

        f(t tVar) {
            this.URg = tVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(261132);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(261132);
                throw tVar;
            }
            int intValue = ((Integer) animatedValue).intValue();
            ViewGroup.LayoutParams layoutParams = this.URg.UNJ.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(261132);
                throw tVar2;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(intValue);
            this.URg.UNJ.requestLayout();
            AppMethodBeat.o(261132);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$switchToSearchMode$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class g extends AnimatorListenerAdapter {
        final /* synthetic */ t URg;

        g(t tVar) {
            this.URg = tVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(261133);
            int i2 = this.URg.HiI;
            a aVar = t.URf;
            if (i2 == t.URe) {
                this.URg.UQT.setVisibility(0);
            }
            AppMethodBeat.o(261133);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ t URg;

        h(t tVar) {
            this.URg = tVar;
        }

        public final void run() {
            AppMethodBeat.i(261134);
            this.URg.UNF.requestFocus();
            t.f(this.URg);
            AppMethodBeat.o(261134);
        }
    }

    public final void hUk() {
        AppMethodBeat.i(261139);
        hTI();
        float f2 = (float) au.az(this.hwr.getContext()).x;
        this.hwr.animate().translationX(f2).setListener(new b(this, f2)).start();
        AppMethodBeat.o(261139);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$hideInviteAnchorLinkPanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ t URg;
        final /* synthetic */ float URh;

        b(t tVar, float f2) {
            this.URg = tVar;
            this.URh = f2;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(261127);
            this.URg.hwr.setTranslationX(this.URh);
            this.URg.hwr.setVisibility(8);
            AppMethodBeat.o(261127);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(261128);
            this.URg.hwr.setTranslationX(this.URh);
            this.URg.hwr.setVisibility(8);
            AppMethodBeat.o(261128);
        }
    }

    public final boolean isVisible() {
        AppMethodBeat.i(261140);
        if (this.hwr.getVisibility() == 0) {
            AppMethodBeat.o(261140);
            return true;
        }
        AppMethodBeat.o(261140);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ t URg;

        public c(t tVar) {
            this.URg = tVar;
        }

        public final void run() {
            AppMethodBeat.i(261129);
            this.URg.UNF.requestFocus();
            AppMethodBeat.o(261129);
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(261141);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.jx7) {
            hUk();
        } else if (valueOf != null && valueOf.intValue() == R.id.jx6) {
            this.UNF.setText("");
            this.UQY.ad(new ArrayList());
            this.UQY.notifyDataSetChanged();
        } else if (valueOf != null && valueOf.intValue() == R.id.jxc) {
            Util.hideVKB(this.UNF);
            hTI();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(261141);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(261142);
        if (qVar instanceof cf) {
            com.tencent.mm.kernel.g.azz().b(3820, this);
            Log.i(TAG, "onSceneEnd NetSceneFinderSearch errType:" + i2 + " errCode:" + i3 + " query:" + this.query);
            if (i2 == 0 && i3 == 0) {
                bcb bcb = ((cf) qVar).twl;
                Log.i(TAG, "updateSearchData showMode:" + this.HiI);
                if (this.HiI == URe) {
                    z.d dVar = new z.d();
                    dVar.SYE = this.URb.size();
                    z.d dVar2 = new z.d();
                    dVar2.SYE = this.URb.size();
                    this.URb.addAll(bcb.zns);
                    this.offset = bcb.offset;
                    this.continueFlag = bcb.continueFlag;
                    this.tVM = bcb.tVM;
                    dVar2.SYE = this.URb.size();
                    Log.i(TAG, "searchContactList size:" + this.URb.size() + " offset:" + bcb.offset + " continueFlag:" + bcb.continueFlag);
                    com.tencent.mm.ac.d.h(new j(this, dVar2, dVar));
                }
            }
        }
        AppMethodBeat.o(261142);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ t URg;
        final /* synthetic */ z.d URi;
        final /* synthetic */ z.d uWw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(t tVar, z.d dVar, z.d dVar2) {
            super(0);
            this.URg = tVar;
            this.URi = dVar;
            this.uWw = dVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261136);
            this.URg.tLS.apT(0);
            if (this.URg.URb.isEmpty()) {
                this.URg.qqJ.setVisibility(0);
                this.URg.UQW.setVisibility(8);
            } else {
                this.URg.qqJ.setVisibility(8);
                this.URg.UQW.setVisibility(0);
                this.URg.UQY.ad(this.URg.URb);
                this.URg.UQY.notifyDataSetChanged();
            }
            if (this.URi.SYE == 0) {
                this.URg.hSw.setVisibility(8);
                this.URg.qqJ.setVisibility(0);
                this.URg.tLS.setVisibility(8);
            } else {
                this.URg.hSw.setVisibility(8);
                this.URg.qqJ.setVisibility(8);
                this.URg.tLS.setVisibility(0);
            }
            if (this.uWw.SYE == 0) {
                this.URg.UQY.notifyDataSetChanged();
            } else if (this.uWw.SYE < this.URi.SYE) {
                this.URg.UQY.as(this.uWw.SYE, this.URi.SYE - this.uWw.SYE);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(261136);
            return xVar;
        }
    }

    public static final /* synthetic */ void f(t tVar) {
        AppMethodBeat.i(261145);
        InputMethodManager inputMethodManager = (InputMethodManager) tVar.hwr.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(tVar.UNF, 0);
            AppMethodBeat.o(261145);
            return;
        }
        AppMethodBeat.o(261145);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ t URg;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g uga;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(t tVar, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(0);
            this.URg = tVar;
            this.uga = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> arrayList;
            AppMethodBeat.i(261135);
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = this.uga.UPX;
            p.g(list, "liveData.linkMicUserList");
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = list;
            synchronized (list2) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    for (T t : list2) {
                        if (t.UPN) {
                            arrayList2.add(t);
                        }
                    }
                    arrayList = arrayList2;
                } catch (Throwable th) {
                    AppMethodBeat.o(261135);
                    throw th;
                }
            }
            this.URg.UQZ.clear();
            for (com.tencent.mm.plugin.finder.live.viewmodel.e eVar : arrayList) {
                if (eVar.username != null) {
                    String str = eVar.username;
                    p.g(eVar, LocaleUtil.ITALIAN);
                    this.URg.UQZ.put(str, eVar);
                }
            }
            this.URg.UOC = this.uga.uEB;
            com.tencent.mm.plugin.finder.live.view.adapter.l lVar = this.URg.UQX;
            HashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.e> hashMap = this.URg.UQZ;
            p.h(hashMap, "localApplyMicMap");
            lVar.UOB = hashMap;
            m mVar = this.URg.UQY;
            HashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.e> hashMap2 = this.URg.UQZ;
            p.h(hashMap2, "localApplyMicMap");
            mVar.UOB = hashMap2;
            this.URg.UQX.UOC = this.uga.uEB;
            this.URg.UQY.UOC = this.uga.uEB;
            x xVar = x.SXb;
            AppMethodBeat.o(261135);
            return xVar;
        }
    }

    public static final /* synthetic */ void w(t tVar) {
        AppMethodBeat.i(261146);
        Log.i(TAG, "loadSearchData query:" + tVar.query);
        tVar.qqJ.setVisibility(8);
        tVar.hSw.setVisibility(0);
        tVar.URb.clear();
        tVar.offset = 0;
        tVar.continueFlag = 0;
        tVar.tVM = null;
        y yVar = y.vXH;
        tVar.dPI = y.dCV();
        String str = tVar.query;
        if (!(str == null || str.length() == 0)) {
            tVar.vtL = new cf(tVar.query, tVar.offset, tVar.dPI, tVar.tVM, 11, (bbn) null, 96);
            com.tencent.mm.kernel.g.azz().b(tVar.vtL);
            com.tencent.mm.kernel.g.azz().a(3820, tVar);
        }
        AppMethodBeat.o(261146);
    }
}
