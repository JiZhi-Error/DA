package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.model.cgi.ag;
import com.tencent.mm.plugin.finder.live.view.adapter.s;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.fgp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 F2\u00020\u0001:\u0002FGB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0011062\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u000204\u0018\u000108H\u0002J\u0012\u00109\u001a\u0002042\b\u0010:\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010;\u001a\u0002042\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010<\u001a\u000204H\u0016J\u0018\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\tH\u0016J\b\u0010A\u001a\u000204H\u0016J\u0012\u0010B\u001a\u0002042\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010C\u001a\u000204H\u0002J\b\u0010D\u001a\u000204H\u0002J\b\u0010E\u001a\u000204H\u0002R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MODE_NORMAL", "MODE_SEARCH", "adapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter;", "applyLinkUserDescMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUserDesc;", "applyLinkUserList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "applyListView", "Landroid/support/v7/widget/RecyclerView;", "contentTipLine", "Landroid/view/View;", "contentTipTv", "Landroid/widget/TextView;", "emptyGroup", "emptyView", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "mode", "onVisitorApplyListListener", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$IOnVisitorApplyListListener;", "getOnVisitorApplyListListener", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$IOnVisitorApplyListListener;", "setOnVisitorApplyListListener", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$IOnVisitorApplyListListener;)V", "searchAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter;", "searchCancelBtn", "searchCleanBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "searchEdit", "Landroid/widget/EditText;", "searchEditRoot", "searchGroup", "loadApplyUserDescInfo", "", "usernameList", "Ljava/util/LinkedList;", "callback", "Lkotlin/Function0;", "loadSearchData", "keyword", "onBind", "onHideLinkMicPanel", "onKeyboardChange", "show", "", "height", "onNotifyDataChanged", "onTimerUpdateData", "showKVB", "switchToNormalMode", "switchToSearchMode", "Companion", "IOnVisitorApplyListListener", "plugin-finder_release"})
public final class FinderLiveApplyLinkVisitorView extends FinderLiveApplyLinkView {
    private static final String TAG = TAG;
    public static final a UNP = new a((byte) 0);
    private final int MODE_NORMAL;
    private final int UNE;
    private final EditText UNF;
    private final View UNG;
    private final WeImageView UNH;
    private final TextView UNI;
    private final View UNJ;
    private final ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> UNK;
    private final HashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.l> UNL;
    private final s UNM;
    private final com.tencent.mm.plugin.finder.live.view.adapter.b UNN;
    private b UNO;
    private final TextView UNw;
    private final RecyclerView UNx;
    private final View UNy;
    private final TextView hSx;
    private com.tencent.mm.plugin.finder.live.viewmodel.g liveData;
    private int mode;
    private com.tencent.mm.plugin.finder.live.model.s ujx;
    private final View ush;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$IOnVisitorApplyListListener;", "", "onAcceptItemClick", "", "linkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "onHungupItemClick", "plugin-finder_release"})
    public interface b {
        void a(com.tencent.mm.plugin.finder.live.viewmodel.e eVar);

        void b(com.tencent.mm.plugin.finder.live.viewmodel.e eVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveApplyLinkVisitorView(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(260827);
        this.UNE = 1;
        this.UNK = new ArrayList<>();
        this.UNL = new HashMap<>();
        this.UNM = new s(this.UNL);
        this.UNN = new com.tencent.mm.plugin.finder.live.view.adapter.b(this.UNL);
        this.mode = this.MODE_NORMAL;
        View.inflate(context, R.layout.ceu, this);
        View findViewById = findViewById(R.id.cnb);
        p.g(findViewById, "findViewById(R.id.finder…r_link_list_content_list)");
        this.UNx = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.cni);
        p.g(findViewById2, "findViewById(R.id.finder…nchor_link_list_empty_tv)");
        this.hSx = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.jwi);
        p.g(findViewById3, "findViewById(R.id.finder…link_list_content_tip_tv)");
        this.UNw = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.cnd);
        p.g(findViewById4, "findViewById(R.id.finder…list_content_search_edit)");
        this.UNF = (EditText) findViewById4;
        View findViewById5 = findViewById(R.id.cng);
        p.g(findViewById5, "findViewById(R.id.finder…ontent_search_group_root)");
        this.UNG = findViewById5;
        View findViewById6 = findViewById(R.id.cnf);
        p.g(findViewById6, "findViewById(R.id.finder…ist_content_search_group)");
        this.UNJ = findViewById6;
        View findViewById7 = findViewById(R.id.cn_);
        p.g(findViewById7, "findViewById(R.id.finder…_list_content_clear_icon)");
        this.UNH = (WeImageView) findViewById7;
        View findViewById8 = findViewById(R.id.cnc);
        p.g(findViewById8, "findViewById(R.id.finder…content_search_cancel_tv)");
        this.UNI = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.jwh);
        p.g(findViewById9, "findViewById(R.id.finder…nk_list_content_tip_line)");
        this.UNy = findViewById9;
        View findViewById10 = findViewById(R.id.jwj);
        p.g(findViewById10, "findViewById(R.id.finder…or_link_list_empty_group)");
        this.ush = findViewById10;
        this.UNx.setLayoutManager(new LinearLayoutManager());
        this.UNx.setAdapter(this.UNM);
        this.UNI.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.AnonymousClass1 */
            final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

            {
                this.UNQ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(260805);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Util.hideVKB(this.UNQ.UNF);
                FinderLiveApplyLinkVisitorView.q(this.UNQ);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(260805);
            }
        });
        this.UNH.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.AnonymousClass2 */
            final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

            {
                this.UNQ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(260806);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.UNQ.UNF.setText("");
                this.UNQ.UNN.j(new ArrayList(), "");
                this.UNQ.UNN.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(260806);
            }
        });
        this.UNF.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.AnonymousClass3 */
            final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.UNQ = r1;
            }

            public final void afterTextChanged(Editable editable) {
                boolean z;
                AppMethodBeat.i(260807);
                if (this.UNQ.UNx.getVisibility() != 0) {
                    a aVar = FinderLiveApplyLinkVisitorView.UNP;
                    Log.i(FinderLiveApplyLinkVisitorView.TAG, "skip search list, list is nil");
                    AppMethodBeat.o(260807);
                    return;
                }
                Editable text = this.UNQ.UNF.getText();
                String obj = text != null ? text.toString() : null;
                String str = obj;
                if (str == null || str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.UNQ.UNH.setVisibility(8);
                    AppMethodBeat.o(260807);
                    return;
                }
                this.UNQ.UNH.setVisibility(0);
                FinderLiveApplyLinkVisitorView.a(this.UNQ, obj);
                AppMethodBeat.o(260807);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.UNM.uzX = new kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.AnonymousClass4 */
            final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

            {
                this.UNQ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list;
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2;
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar2;
                AppMethodBeat.i(260808);
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar3 = eVar;
                p.h(eVar3, LocaleUtil.ITALIAN);
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.UNQ.liveData;
                if (gVar == null || !gVar.hTW()) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.UNQ.liveData;
                    if (gVar2 == null || (eVar2 = gVar2.uEB) == null || !eVar2.UPN) {
                        int d2 = this.UNQ.UNM.d(eVar3);
                        if (d2 != -1 && d2 < this.UNQ.UNM.getItemCount()) {
                            com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.UNQ.liveData;
                            if (!(gVar3 == null || (list = gVar3.UPZ) == null || list.contains(eVar3))) {
                                com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.UNQ.liveData;
                                if (!(gVar4 == null || (list2 = gVar4.UPZ) == null)) {
                                    list2.add(eVar3);
                                }
                                eVar3.hTQ();
                            }
                            b onVisitorApplyListListener = this.UNQ.getOnVisitorApplyListListener();
                            if (onVisitorApplyListListener != null) {
                                onVisitorApplyListListener.a(eVar3);
                            }
                            this.UNQ.UNM.ci(d2);
                        }
                    } else {
                        u.makeText(context, context.getResources().getString(R.string.j_v), 0).show();
                    }
                } else {
                    u.makeText(context, context.getResources().getString(R.string.j_t), 0).show();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260808);
                return xVar;
            }
        };
        this.UNM.UNY = new kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.AnonymousClass5 */
            final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

            {
                this.UNQ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
                AppMethodBeat.i(260809);
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = eVar;
                p.h(eVar2, LocaleUtil.ITALIAN);
                b onVisitorApplyListListener = this.UNQ.getOnVisitorApplyListListener();
                if (onVisitorApplyListListener != null) {
                    onVisitorApplyListListener.b(eVar2);
                }
                eVar2.UPO = 0;
                this.UNQ.UNM.e(eVar2);
                x xVar = x.SXb;
                AppMethodBeat.o(260809);
                return xVar;
            }
        };
        this.UNN.uzX = new kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.AnonymousClass6 */
            final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

            {
                this.UNQ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
                Object obj;
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list;
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2;
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar2;
                AppMethodBeat.i(260810);
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar3 = eVar;
                p.h(eVar3, "selectedUser");
                Iterator it = this.UNQ.UNK.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.e) obj).uCo, eVar3.uCo)) {
                        break;
                    }
                }
                if (obj != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.UNQ.liveData;
                    if (gVar == null || !gVar.hTW()) {
                        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.UNQ.liveData;
                        if (gVar2 == null || (eVar2 = gVar2.uEB) == null || !eVar2.UPN) {
                            com.tencent.mm.plugin.finder.live.view.adapter.b bVar = this.UNQ.UNN;
                            p.h(eVar3, "data");
                            Iterator<com.tencent.mm.plugin.finder.live.viewmodel.e> it2 = bVar.kgc.iterator();
                            int i2 = 0;
                            while (true) {
                                if (!it2.hasNext()) {
                                    i2 = -1;
                                    break;
                                } else if (Util.isEqual(it2.next().username, eVar3.username)) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            if (i2 != -1 && i2 < this.UNQ.UNM.getItemCount()) {
                                com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.UNQ.liveData;
                                if (!(gVar3 == null || (list = gVar3.UPZ) == null || list.contains(eVar3))) {
                                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.UNQ.liveData;
                                    if (!(gVar4 == null || (list2 = gVar4.UPZ) == null)) {
                                        list2.add(eVar3);
                                    }
                                    eVar3.hTQ();
                                }
                                b onVisitorApplyListListener = this.UNQ.getOnVisitorApplyListListener();
                                if (onVisitorApplyListListener != null) {
                                    onVisitorApplyListListener.a(eVar3);
                                }
                                this.UNQ.UNM.ci(i2);
                            }
                        } else {
                            u.makeText(context, context.getResources().getString(R.string.j_v), 0).show();
                        }
                    } else {
                        u.makeText(context, context.getResources().getString(R.string.j_t), 0).show();
                    }
                } else {
                    u.makeText(context, context.getResources().getString(R.string.cub), 0).show();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260810);
                return xVar;
            }
        };
        this.UNN.UNY = new kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.AnonymousClass7 */
            final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

            {
                this.UNQ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
                AppMethodBeat.i(260811);
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = eVar;
                p.h(eVar2, LocaleUtil.ITALIAN);
                b onVisitorApplyListListener = this.UNQ.getOnVisitorApplyListListener();
                if (onVisitorApplyListListener != null) {
                    onVisitorApplyListListener.b(eVar2);
                }
                eVar2.UPO = 0;
                this.UNQ.UNM.e(eVar2);
                x xVar = x.SXb;
                AppMethodBeat.o(260811);
                return xVar;
            }
        };
        AppMethodBeat.o(260827);
    }

    public static final /* synthetic */ void q(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView) {
        AppMethodBeat.i(260832);
        finderLiveApplyLinkVisitorView.hTI();
        AppMethodBeat.o(260832);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260830);
        AppMethodBeat.o(260830);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveApplyLinkVisitorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(260828);
        AppMethodBeat.o(260828);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveApplyLinkVisitorView(Context context) {
        this(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(260829);
        AppMethodBeat.o(260829);
    }

    public final b getOnVisitorApplyListListener() {
        return this.UNO;
    }

    public final void setOnVisitorApplyListListener(b bVar) {
        this.UNO = bVar;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void a(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, com.tencent.mm.plugin.finder.live.model.s sVar) {
        ArrayList arrayList;
        long j2;
        long j3;
        awe awe;
        byte[] bArr = null;
        AppMethodBeat.i(260821);
        Log.i(TAG, new StringBuilder("onBind linkMicUserList:").append(gVar != null ? gVar.UPX : null).append(" mode:").append(this.mode).toString());
        this.liveData = gVar;
        this.UNM.liveData = gVar;
        this.ujx = sVar;
        if (gVar != null) {
            this.UNK.clear();
            ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> arrayList2 = this.UNK;
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = gVar.UPX;
            p.g(list, "roomData.linkMicUserList");
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = list;
            synchronized (list2) {
                try {
                    ArrayList arrayList3 = new ArrayList();
                    for (T t : list2) {
                        if (!t.UPN) {
                            arrayList3.add(t);
                        }
                    }
                    arrayList = arrayList3;
                } catch (Throwable th) {
                    AppMethodBeat.o(260821);
                    throw th;
                }
            }
            arrayList2.addAll(arrayList);
            if (this.mode == this.MODE_NORMAL) {
                ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> arrayList4 = this.UNK;
                if (arrayList4 == null || arrayList4.isEmpty()) {
                    this.UNG.setVisibility(8);
                    this.ush.setVisibility(0);
                    this.UNx.setVisibility(8);
                    this.UNw.setVisibility(8);
                    this.UNy.setVisibility(8);
                    AppMethodBeat.o(260821);
                    return;
                }
                this.UNG.setVisibility(0);
                this.UNx.setVisibility(0);
                this.UNw.setVisibility(0);
                this.UNy.setVisibility(0);
                this.ush.setVisibility(8);
                TextView textView = this.UNw;
                Context context = getContext();
                p.g(context, "context");
                textView.setText(context.getResources().getString(R.string.ja8, Integer.valueOf(this.UNK.size())));
                this.UNM.ad(this.UNK);
                this.UNM.notifyDataSetChanged();
                LinkedList<String> linkedList = new LinkedList<>();
                ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> arrayList5 = this.UNK;
                ArrayList arrayList6 = new ArrayList(kotlin.a.j.a(arrayList5, 10));
                Iterator<T> it = arrayList5.iterator();
                while (it.hasNext()) {
                    String str = it.next().username;
                    if (str == null) {
                        str = "";
                    }
                    arrayList6.add(str);
                }
                linkedList.addAll(arrayList6);
                d dVar = new d(this);
                Log.i(TAG, "loadApplyUserDescInfo usernameSize:" + linkedList.size());
                com.tencent.mm.plugin.finder.live.model.s sVar2 = this.ujx;
                if (sVar2 != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
                    if (gVar2 == null || (awe = gVar2.liveInfo) == null) {
                        j2 = 0;
                    } else {
                        j2 = awe.liveId;
                    }
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
                    if (gVar3 != null) {
                        j3 = gVar3.hFK;
                    } else {
                        j3 = 0;
                    }
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.liveData;
                    String str2 = gVar4 != null ? gVar4.hwg : null;
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar5 = this.liveData;
                    if (gVar5 != null) {
                        bArr = gVar5.hIt;
                    }
                    sVar2.a(j2, j3, str2, bArr, linkedList, new c(this, dVar));
                    AppMethodBeat.o(260821);
                    return;
                }
            }
            AppMethodBeat.o(260821);
            return;
        }
        AppMethodBeat.o(260821);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void l(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        AppMethodBeat.i(260822);
        com.tencent.mm.ac.d.h(new f(this, gVar));
        AppMethodBeat.o(260822);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$loadApplyUserDescInfo$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactResponse;", "plugin-finder_release"})
    public static final class c implements ag.a {
        final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;
        final /* synthetic */ kotlin.g.a.a ihE;

        c(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView, kotlin.g.a.a aVar) {
            this.UNQ = finderLiveApplyLinkVisitorView;
            this.ihE = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.ag.a
        public final void a(int i2, int i3, fgp fgp) {
            LinkedList<avn> linkedList;
            int i4;
            AppMethodBeat.i(260812);
            p.h(fgp, "resp");
            if (i2 == 0 && i3 == 0 && (linkedList = fgp.ViZ) != null) {
                for (T t : linkedList) {
                    FinderContact finderContact = t.contact;
                    if (finderContact != null) {
                        String str = finderContact.username;
                        if (!(str == null || str.length() == 0)) {
                            if (t.LDK != null) {
                                i4 = 3;
                            } else if (com.tencent.mm.ac.d.cW(t.LGj, 4)) {
                                i4 = 1;
                            } else {
                                i4 = finderContact.followFlag == 1 ? 2 : 0;
                            }
                            HashMap hashMap = this.UNQ.UNL;
                            String str2 = finderContact.username;
                            if (str2 == null) {
                                str2 = "";
                            }
                            hashMap.put(str2, new com.tencent.mm.plugin.finder.live.viewmodel.l(i4, t.LDK));
                            kotlin.g.a.a aVar = this.ihE;
                            if (aVar != null) {
                                aVar.invoke();
                            }
                        }
                    }
                }
                AppMethodBeat.o(260812);
                return;
            }
            AppMethodBeat.o(260812);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$switchToSearchMode$1$1"})
    static final class h implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

        h(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView) {
            this.UNQ = finderLiveApplyLinkVisitorView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(260818);
            ViewGroup.LayoutParams layoutParams = this.UNQ.UNJ.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(260818);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(260818);
                throw tVar2;
            }
            marginLayoutParams.setMarginEnd(((Integer) animatedValue).intValue());
            this.UNQ.UNJ.requestLayout();
            AppMethodBeat.o(260818);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$switchToSearchMode$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class i extends AnimatorListenerAdapter {
        final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

        i(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView) {
            this.UNQ = finderLiveApplyLinkVisitorView;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(260819);
            this.UNQ.UNI.setVisibility(0);
            AppMethodBeat.o(260819);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class j implements Runnable {
        final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

        j(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView) {
            this.UNQ = finderLiveApplyLinkVisitorView;
        }

        public final void run() {
            AppMethodBeat.i(260820);
            this.UNQ.UNF.requestFocus();
            FinderLiveApplyLinkVisitorView.p(this.UNQ);
            AppMethodBeat.o(260820);
        }
    }

    private final void hTI() {
        AppMethodBeat.i(260823);
        this.mode = this.MODE_NORMAL;
        this.UNN.j(new ArrayList(), "");
        this.UNx.setAdapter(this.UNM);
        this.UNM.ad(this.UNK);
        this.UNM.notifyDataSetChanged();
        this.UNH.setVisibility(8);
        this.UNI.setVisibility(4);
        int[] iArr = new int[2];
        ViewGroup.LayoutParams layoutParams = this.UNJ.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(260823);
            throw tVar;
        }
        iArr[0] = ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        iArr[1] = 0;
        ValueAnimator ofInt = ObjectAnimator.ofInt(iArr);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new g(this));
        ofInt.start();
        this.UNF.setText("");
        this.UNF.clearFocus();
        Util.hideVKB(this.UNF);
        ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> arrayList = this.UNK;
        if (arrayList == null || arrayList.isEmpty()) {
            this.ush.setVisibility(0);
            this.UNx.setVisibility(8);
            this.UNG.setVisibility(8);
            this.UNw.setVisibility(8);
            this.UNy.setVisibility(8);
            AppMethodBeat.o(260823);
            return;
        }
        this.UNG.setVisibility(0);
        this.UNx.setVisibility(0);
        this.ush.setVisibility(8);
        this.UNw.setVisibility(0);
        TextView textView = this.UNw;
        Context context = getContext();
        p.g(context, "context");
        textView.setText(context.getResources().getString(R.string.ja8, Integer.valueOf(this.UNK.size())));
        this.UNy.setVisibility(0);
        AppMethodBeat.o(260823);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$switchToNormalMode$1$1"})
    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

        g(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView) {
            this.UNQ = finderLiveApplyLinkVisitorView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(260817);
            ViewGroup.LayoutParams layoutParams = this.UNQ.UNJ.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(260817);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(260817);
                throw tVar2;
            }
            marginLayoutParams.setMarginEnd(((Integer) animatedValue).intValue());
            this.UNQ.UNJ.requestLayout();
            AppMethodBeat.o(260817);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void aj(boolean z, int i2) {
        AppMethodBeat.i(260824);
        Log.i(TAG, "keyboardChange show:" + z + " height:" + i2);
        if (z) {
            this.mode = this.UNE;
            this.UNw.setVisibility(8);
            this.ush.setVisibility(8);
            int[] iArr = new int[2];
            ViewGroup.LayoutParams layoutParams = this.UNJ.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(260824);
                throw tVar;
            }
            iArr[0] = ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
            int measuredWidth = this.UNI.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams2 = this.UNI.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(260824);
                throw tVar2;
            }
            iArr[1] = ((ViewGroup.MarginLayoutParams) layoutParams2).getMarginStart() + measuredWidth;
            ValueAnimator ofInt = ObjectAnimator.ofInt(iArr);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new h(this));
            ofInt.addListener(new i(this));
            ofInt.start();
            this.UNx.setAdapter(this.UNN);
            this.UNN.notifyDataSetChanged();
            this.UNF.post(new j(this));
            postDelayed(new e(this), 100);
        }
        AppMethodBeat.o(260824);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

        e(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView) {
            this.UNQ = finderLiveApplyLinkVisitorView;
        }

        public final void run() {
            AppMethodBeat.i(260815);
            this.UNQ.UNF.requestFocus();
            AppMethodBeat.o(260815);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void cCu() {
        AppMethodBeat.i(260825);
        if (this.mode == this.MODE_NORMAL) {
            this.UNM.notifyDataSetChanged();
            AppMethodBeat.o(260825);
            return;
        }
        this.UNN.notifyDataSetChanged();
        AppMethodBeat.o(260825);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void hTH() {
        AppMethodBeat.i(260826);
        hTI();
        AppMethodBeat.o(260826);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$onBind$1$3"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView) {
            super(0);
            this.UNQ = finderLiveApplyLinkVisitorView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260814);
            a aVar = FinderLiveApplyLinkVisitorView.UNP;
            Log.i(FinderLiveApplyLinkVisitorView.TAG, "batchGetMicInfoCallback mode:" + this.UNQ.mode);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.d.AnonymousClass1 */
                final /* synthetic */ d UNR;

                {
                    this.UNR = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(260813);
                    if (this.UNR.UNQ.mode == this.UNR.UNQ.MODE_NORMAL) {
                        this.UNR.UNQ.UNM.notifyDataSetChanged();
                    } else if (this.UNR.UNQ.mode == this.UNR.UNQ.UNE) {
                        this.UNR.UNQ.UNN.notifyDataSetChanged();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(260813);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(260814);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLiveApplyLinkVisitorView UNQ;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g uga;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(0);
            this.UNQ = finderLiveApplyLinkVisitorView;
            this.uga = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list;
            ArrayList arrayList;
            AppMethodBeat.i(260816);
            a aVar = FinderLiveApplyLinkVisitorView.UNP;
            String str = FinderLiveApplyLinkVisitorView.TAG;
            StringBuilder sb = new StringBuilder("onTimerUpdateData linkMicVisitorUserList:");
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.uga;
            if (gVar != null) {
                list = gVar.UPX;
            } else {
                list = null;
            }
            Log.i(str, sb.append(list).toString());
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.uga;
            if (gVar2 != null) {
                this.UNQ.UNK.clear();
                ArrayList arrayList2 = this.UNQ.UNK;
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = gVar2.UPX;
                p.g(list2, "roomData.linkMicUserList");
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list3 = list2;
                synchronized (list3) {
                    try {
                        ArrayList arrayList3 = new ArrayList();
                        for (T t : list3) {
                            if (!t.UPN) {
                                arrayList3.add(t);
                            }
                        }
                        arrayList = arrayList3;
                    } catch (Throwable th) {
                        AppMethodBeat.o(260816);
                        throw th;
                    }
                }
                arrayList2.addAll(arrayList);
                if (this.UNQ.mode == this.UNQ.MODE_NORMAL) {
                    ArrayList arrayList4 = this.UNQ.UNK;
                    if (arrayList4 == null || arrayList4.isEmpty()) {
                        this.UNQ.UNG.setVisibility(8);
                        this.UNQ.ush.setVisibility(0);
                        this.UNQ.UNx.setVisibility(8);
                        this.UNQ.UNw.setVisibility(8);
                        this.UNQ.UNy.setVisibility(8);
                    } else {
                        this.UNQ.UNG.setVisibility(0);
                        this.UNQ.UNx.setVisibility(0);
                        this.UNQ.UNw.setVisibility(0);
                        this.UNQ.UNy.setVisibility(0);
                        this.UNQ.ush.setVisibility(8);
                        TextView textView = this.UNQ.UNw;
                        Context context = this.UNQ.getContext();
                        p.g(context, "context");
                        textView.setText(context.getResources().getString(R.string.ja8, Integer.valueOf(this.UNQ.UNK.size())));
                        this.UNQ.UNM.ad(this.UNQ.UNK);
                        this.UNQ.UNM.notifyDataSetChanged();
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260816);
            return xVar;
        }
    }

    public static final /* synthetic */ void p(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView) {
        AppMethodBeat.i(260831);
        InputMethodManager inputMethodManager = (InputMethodManager) finderLiveApplyLinkVisitorView.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(finderLiveApplyLinkVisitorView.UNF, 0);
            AppMethodBeat.o(260831);
            return;
        }
        AppMethodBeat.o(260831);
    }

    public static final /* synthetic */ void a(FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView, String str) {
        AppMethodBeat.i(260833);
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (T t : finderLiveApplyLinkVisitorView.UNK) {
                String str2 = t.nickname;
                if ((str2 != null ? n.a(str2, str, 0, false, 6) : -1) != -1) {
                    arrayList2.add(t);
                }
            }
            arrayList.addAll(arrayList2);
            Log.i(TAG, "loadSearchData keyword:" + str + " size:" + arrayList.size());
            finderLiveApplyLinkVisitorView.UNN.j(arrayList, str);
            finderLiveApplyLinkVisitorView.UNN.notifyDataSetChanged();
        }
        AppMethodBeat.o(260833);
    }
}
