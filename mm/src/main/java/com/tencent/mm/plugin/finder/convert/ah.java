package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.plugin.finder.view.FinderTagFlowLayout;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\r\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0018J\b\u0010!\u001a\u00020\"H\u0016J\u001c\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001f2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0016J@\u0010'\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u00072\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-H\u0016J \u0010/\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\"H\u0016J\u0010\u00100\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001fH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "viewCallBackTag", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "(Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;)V", "floatState", "", "getFloatState", "()Z", "setFloatState", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1;", "tagViewRef", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "getTagViewRef", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "setTagViewRef", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getViewCallBackTag", "()Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "changeToDecorView", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "changeToItemView", "recylerView", "Landroid/support/v7/widget/RecyclerView;", "chekToAddFLoatTagViewWhenFling", "getLayoutId", "", "onAttachedToRecyclerView", "recyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class ah extends e<j> {
    static String TAG = "Finder.FinderFeedTagsConvert";
    private static int tDR = -2;
    static int tDS = R.id.ih6;
    public static final a tDT = new a((byte) 0);
    boolean tDN;
    FinderTagView tDO;
    private final c tDP = new c(this);
    final com.tencent.mm.plugin.finder.presenter.base.b tDQ;

    public ah(com.tencent.mm.plugin.finder.presenter.base.b bVar) {
        p.h(bVar, "viewCallBackTag");
        AppMethodBeat.i(243106);
        this.tDQ = bVar;
        AppMethodBeat.o(243106);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, j jVar, int i2, int i3, boolean z, List list) {
        LinkedList<bds> linkedList;
        AppMethodBeat.i(243102);
        j jVar2 = jVar;
        p.h(hVar, "holder");
        p.h(jVar2, "item");
        Log.d(TAG, "onBindViewHolder");
        tDR = i2;
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).aC(true);
        }
        if (!jVar2.uNS.MPW.isEmpty()) {
            View Mn = hVar.Mn(tDS);
            p.g(Mn, "holder.getView(ITEM_CONTAINER_ID)");
            FrameLayout frameLayout = (FrameLayout) Mn;
            View rootView = this.tDQ.getRootView();
            FinderTagView.a aVar = FinderTagView.wpv;
            View findViewById = rootView.findViewById(FinderTagView.wpt);
            if (findViewById != null) {
                Log.d(TAG, "exits float view,put in auto");
                frameLayout.getLayoutParams().height = findViewById.getLayoutParams().height;
            } else if (frameLayout.getChildCount() != 0) {
                Log.d(TAG, "container has content already");
                AppMethodBeat.o(243102);
                return;
            } else {
                Log.d(TAG, "no float view,create now");
                FinderTagView finderTagView = new FinderTagView(hVar.getContext());
                FinderTagView finderTagView2 = finderTagView;
                dmk dmk = jVar2.uNS;
                if (dmk != null) {
                    if (!(dmk == null || (linkedList = dmk.MPW) == null)) {
                        bds bds = new bds();
                        Context context = finderTagView2.getContext();
                        p.g(context, "context");
                        bds.dST = context.getResources().getString(R.string.d_x);
                        bds.twp = FinderTagView.wpu;
                        finderTagView2.wph.put(Long.valueOf(bds.twp), 1);
                        linkedList.addFirst(bds);
                    }
                    if (dmk == null) {
                        p.hyc();
                    }
                    finderTagView2.wpi = dmk;
                    FinderTagFlowLayout finderTagFlowLayout = finderTagView2.wpd;
                    if (finderTagFlowLayout == null) {
                        p.btv("tagLayout");
                    }
                    finderTagFlowLayout.removeAllViews();
                    FinderTagFlowLayout finderTagFlowLayout2 = finderTagView2.wpd;
                    if (finderTagFlowLayout2 == null) {
                        p.btv("tagLayout");
                    }
                    finderTagFlowLayout2.woZ.clear();
                    dmk dmk2 = finderTagView2.wpi;
                    if (dmk2 == null) {
                        p.btv("tagData");
                    }
                    int size = dmk2.MPW.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        dmk dmk3 = finderTagView2.wpi;
                        if (dmk3 == null) {
                            p.btv("tagData");
                        }
                        bds bds2 = dmk3.MPW.get(i4);
                        p.g(bds2, "tagData.topic_list[i]");
                        bds bds3 = bds2;
                        View view2 = finderTagView2.gvQ;
                        if (view2 == null) {
                            p.btv("root");
                        }
                        View inflate = aa.jQ(view2.getContext()).inflate(R.layout.agd, (ViewGroup) null);
                        View findViewById2 = inflate.findViewById(R.id.czv);
                        p.g(findViewById2, "view.findViewById<TextVi…d.finder_machine_item_tv)");
                        ((TextView) findViewById2).setText(bds3.dST);
                        if (bds3.twp == -1) {
                            p.g(inflate, "view");
                            finderTagView2.a(true, inflate, i4);
                        } else {
                            p.g(inflate, "view");
                            finderTagView2.a(false, inflate, i4);
                        }
                        inflate.setOnClickListener(new FinderTagView.f(finderTagView2));
                        finderTagView2.wpg.add(inflate);
                        FinderTagFlowLayout finderTagFlowLayout3 = finderTagView2.wpd;
                        if (finderTagFlowLayout3 == null) {
                            p.btv("tagLayout");
                        }
                        finderTagFlowLayout3.addView(inflate);
                    }
                    finderTagView2.dHg();
                }
                finderTagView.dHh();
                FinderTagView.a aVar2 = FinderTagView.wpv;
                finderTagView.setId(FinderTagView.wpt);
                finderTagView.setVisibility(4);
                Log.d(TAG, "put dummy item");
                frameLayout.addView(finderTagView);
                this.tDO = finderTagView;
                finderTagView.setVisibility(0);
                AppMethodBeat.o(243102);
                return;
            }
        }
        AppMethodBeat.o(243102);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$Companion;", "", "()V", "ITEM_CONTAINER_ID", "", "getITEM_CONTAINER_ID", "()I", "setITEM_CONTAINER_ID", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "positionInListView", "getPositionInListView", "setPositionInListView", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(243107);
        AppMethodBeat.o(243107);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.ake;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243101);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243101);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0012"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
    public static final class c extends RecyclerView.l {
        private final int[] tDW = new int[2];
        final /* synthetic */ ah tDX;
        private final int[] value = new int[2];

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(ah ahVar) {
            this.tDX = ahVar;
            AppMethodBeat.i(243100);
            AppMethodBeat.o(243100);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(243098);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            a aVar = ah.tDT;
            if (ah.tDR > -2) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
                    AppMethodBeat.o(243098);
                    throw tVar;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.ki()];
                staggeredGridLayoutManager.n(iArr);
                a aVar2 = ah.tDT;
                String str = ah.TAG;
                StringBuilder append = new StringBuilder("visiablePosition:").append(iArr[0]).append(",positionInListView:");
                a aVar3 = ah.tDT;
                Log.d(str, append.append(ah.tDR).toString());
                int i4 = iArr[0];
                a aVar4 = ah.tDT;
                if (i4 == ah.tDR) {
                    a aVar5 = ah.tDT;
                    RecyclerView.v ch = recyclerView.ch(ah.tDR);
                    if (ch == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
                        AppMethodBeat.o(243098);
                        throw tVar2;
                    }
                    h hVar = (h) ch;
                    hVar.aus.getLocationInWindow(this.value);
                    recyclerView.getLocationInWindow(this.tDW);
                    if (this.tDW[1] - this.value[1] > 0) {
                        a aVar6 = ah.tDT;
                        Log.d(ah.TAG, "changeToDecorView:entrace 1");
                        ah ahVar = this.tDX;
                        View rootView = this.tDX.tDQ.getRootView();
                        if (rootView == null) {
                            t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(243098);
                            throw tVar3;
                        }
                        ViewGroup viewGroup = (ViewGroup) rootView;
                        p.h(viewGroup, "parent");
                        p.h(hVar, "holder");
                        if (ahVar.tDN) {
                            Log.d(ah.TAG, "changeToDecorView:return");
                        } else {
                            ahVar.tDN = true;
                            Log.d(ah.TAG, "changeToDecorView,in");
                            FrameLayout frameLayout = (FrameLayout) hVar.Mn(ah.tDS);
                            FinderTagView.a aVar7 = FinderTagView.wpv;
                            View Mn = hVar.Mn(FinderTagView.wpt);
                            p.g(Mn, "tagView");
                            Mn.setVisibility(4);
                            p.g(frameLayout, "tagViewContainer");
                            frameLayout.getLayoutParams().height = Mn.getHeight();
                            frameLayout.removeView(Mn);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            layoutParams.gravity = 48;
                            viewGroup.addView(Mn, layoutParams);
                            Mn.setVisibility(0);
                        }
                    } else if (this.tDW[1] - this.value[1] <= 0) {
                        a aVar8 = ah.tDT;
                        Log.d(ah.TAG, "changeToItemView:entrace 1");
                        ah ahVar2 = this.tDX;
                        View rootView2 = this.tDX.tDQ.getRootView();
                        if (rootView2 == null) {
                            t tVar4 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(243098);
                            throw tVar4;
                        }
                        ahVar2.a((ViewGroup) rootView2, hVar, recyclerView);
                    }
                } else {
                    a aVar9 = ah.tDT;
                    RecyclerView.v ch2 = recyclerView.ch(ah.tDR);
                    if (ch2 != null) {
                        if (ch2 == null) {
                            t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
                            AppMethodBeat.o(243098);
                            throw tVar5;
                        }
                        h hVar2 = (h) ch2;
                        a aVar10 = ah.tDT;
                        Log.d(ah.TAG, "changeToItemView:entrace 2");
                        ah ahVar3 = this.tDX;
                        View rootView3 = this.tDX.tDQ.getRootView();
                        if (rootView3 == null) {
                            t tVar6 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(243098);
                            throw tVar6;
                        }
                        ahVar3.a((ViewGroup) rootView3, hVar2, recyclerView);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(243098);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int i3;
            AppMethodBeat.i(243099);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            a aVar = ah.tDT;
            Log.d(ah.TAG, "newState:".concat(String.valueOf(i2)));
            if (i2 == 2) {
                ah ahVar = this.tDX;
                if (!ahVar.tDN) {
                    View rootView = ahVar.tDQ.getRootView();
                    FinderTagView.a aVar2 = FinderTagView.wpv;
                    if (rootView.findViewById(FinderTagView.wpt) == null) {
                        Log.d(ah.TAG, "chekToAddFLoatTagViewWhenFling: ");
                        ahVar.tDN = true;
                        FinderTagView finderTagView = ahVar.tDO;
                        ViewParent parent = finderTagView != null ? finderTagView.getParent() : null;
                        if (!(parent instanceof ViewGroup)) {
                            parent = null;
                        }
                        ViewGroup viewGroup = (ViewGroup) parent;
                        if (viewGroup != null) {
                            viewGroup.removeView(ahVar.tDO);
                            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                            FinderTagView finderTagView2 = ahVar.tDO;
                            if (finderTagView2 != null) {
                                i3 = finderTagView2.getHeight();
                            } else {
                                i3 = -2;
                            }
                            layoutParams.height = i3;
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams2.gravity = 48;
                        View rootView2 = ahVar.tDQ.getRootView();
                        if (rootView2 == null) {
                            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(243099);
                            throw tVar;
                        }
                        ((ViewGroup) rootView2).addView(ahVar.tDO, layoutParams2);
                    }
                }
                Log.d(ah.TAG, "chekToAddFLoatTagViewWhenFling:return");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTagsConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(243099);
        }
    }

    public final void a(ViewGroup viewGroup, h hVar, RecyclerView recyclerView) {
        AppMethodBeat.i(243103);
        p.h(viewGroup, "parent");
        p.h(hVar, "holder");
        p.h(recyclerView, "recylerView");
        if (!this.tDN) {
            Log.d(TAG, "changeToItemView:return");
            AppMethodBeat.o(243103);
            return;
        }
        this.tDN = false;
        Log.d(TAG, "changeToItemView,in");
        z.f fVar = new z.f();
        fVar.SYG = (T) ((FrameLayout) hVar.Mn(tDS));
        z.f fVar2 = new z.f();
        FinderTagView.a aVar = FinderTagView.wpv;
        fVar2.SYG = (T) viewGroup.findViewById(FinderTagView.wpt);
        if (fVar2.SYG == null || fVar.SYG == null || fVar.SYG.getChildCount() != 0) {
            Log.d(TAG, "changeToItemView:item has been add,return ");
            AppMethodBeat.o(243103);
            return;
        }
        recyclerView.post(new b(viewGroup, fVar2, fVar));
        AppMethodBeat.o(243103);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ ViewGroup hVi;
        final /* synthetic */ z.f tDU;
        final /* synthetic */ z.f tDV;

        b(ViewGroup viewGroup, z.f fVar, z.f fVar2) {
            this.hVi = viewGroup;
            this.tDU = fVar;
            this.tDV = fVar2;
        }

        public final void run() {
            AppMethodBeat.i(243097);
            this.hVi.removeView(this.tDU.SYG);
            this.tDV.SYG.getLayoutParams().height = -2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            this.tDV.SYG.addView(this.tDU.SYG, layoutParams);
            AppMethodBeat.o(243097);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(243104);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        recyclerView.b(this.tDP);
        recyclerView.a(this.tDP);
        AppMethodBeat.o(243104);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void c(RecyclerView recyclerView) {
        AppMethodBeat.i(243105);
        p.h(recyclerView, "recyclerView");
        super.c(recyclerView);
        AppMethodBeat.o(243105);
    }
}
