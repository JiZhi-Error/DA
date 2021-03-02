package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.a.f;
import com.tencent.mm.plugin.story.ui.a.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

public final class StoryMsgListView extends RelativeLayout {
    private static final int FDt;
    private static final int FDu = 1;
    public static final a FDv = new a((byte) 0);
    private final RecyclerView FDq;
    private final TextView FDr;
    private ViewConfiguration FDs;
    private kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> Fyo;
    private kotlin.g.a.a<x> Fyp;
    private kotlin.g.a.b<? super Integer, x> Fyq;
    private kotlin.g.a.a<x> Fyr;
    private int mba;
    private int mode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryMsgListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120240);
        this.mode = -1;
        View.inflate(context, R.layout.c0m, this);
        View findViewById = findViewById(R.id.ic4);
        p.g(findViewById, "findViewById(R.id.story_msg_recycler_view)");
        this.FDq = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.ic1);
        p.g(findViewById2, "findViewById(R.id.story_msg_empty_tip_tv)");
        this.FDr = (TextView) findViewById2;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        p.g(viewConfiguration, "ViewConfiguration.get(context)");
        this.FDs = viewConfiguration;
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryMsgListView.AnonymousClass1 */
            final /* synthetic */ StoryMsgListView FDw;

            {
                this.FDw = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120229);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<x> onBlankClick = this.FDw.getOnBlankClick();
                if (onBlankClick != null) {
                    onBlankClick.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120229);
            }
        });
        AppMethodBeat.o(120240);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(120243);
        AppMethodBeat.o(120243);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, kotlin.x>, kotlin.g.a.b<com.tencent.mm.plugin.story.f.b.a, kotlin.x> */
    public final kotlin.g.a.b<com.tencent.mm.plugin.story.f.b.a, x> getOnCommentItemClick() {
        return this.Fyo;
    }

    public final void setOnCommentItemClick(kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> bVar) {
        this.Fyo = bVar;
    }

    public final kotlin.g.a.a<x> getOnBlankClick() {
        return this.Fyp;
    }

    public final void setOnBlankClick(kotlin.g.a.a<x> aVar) {
        this.Fyp = aVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final kotlin.g.a.b<Integer, x> getOnContentTopOverScroll() {
        return this.Fyq;
    }

    public final void setOnContentTopOverScroll(kotlin.g.a.b<? super Integer, x> bVar) {
        this.Fyq = bVar;
    }

    public final kotlin.g.a.a<x> getOnContentTopOverScrollStop() {
        return this.Fyr;
    }

    public final void setOnContentTopOverScrollStop(kotlin.g.a.a<x> aVar) {
        this.Fyr = aVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryMsgListView(Context context) {
        this(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(120241);
        AppMethodBeat.o(120241);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryMsgListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120242);
        AppMethodBeat.o(120242);
    }

    private static ArrayList<com.tencent.mm.plugin.story.f.b.a> hz(List<com.tencent.mm.plugin.story.f.b.a> list) {
        AppMethodBeat.i(120233);
        ArrayList<com.tencent.mm.plugin.story.f.b.a> arrayList = new ArrayList<>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.tencent.mm.plugin.story.f.b.a((com.tencent.mm.plugin.story.f.b.a) it.next()));
        }
        AppMethodBeat.o(120233);
        return arrayList;
    }

    public final void a(int i2, ArrayList<com.tencent.mm.plugin.story.f.b.a> arrayList, ArrayList<com.tencent.mm.plugin.story.f.b.a> arrayList2, j jVar) {
        AppMethodBeat.i(120234);
        p.h(arrayList, "comments");
        p.h(arrayList2, "bubbles");
        this.mode = i2;
        if (i2 == FDt) {
            l lVar = new l(hz(arrayList2));
            RecyclerView recyclerView = this.FDq;
            getContext();
            recyclerView.setLayoutManager(new GridLayoutManager(4));
            this.FDq.setAdapter(lVar);
            ViewGroup.LayoutParams layoutParams = this.FDq.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(120234);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(at.fromDPToPix(getContext(), 40));
            ViewGroup.LayoutParams layoutParams2 = this.FDq.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(120234);
                throw tVar2;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(at.fromDPToPix(getContext(), 40));
            TextView textView = this.FDr;
            Context context = getContext();
            p.g(context, "context");
            textView.setText(context.getResources().getString(R.string.hi6));
            if (arrayList2.isEmpty()) {
                this.FDr.setVisibility(0);
                this.FDq.setVisibility(8);
            } else {
                this.FDr.setVisibility(8);
                this.FDq.setVisibility(0);
            }
        } else if (i2 == FDu) {
            f fVar = new f(hz(arrayList));
            fVar.FxM = jVar;
            fVar.FxY = this.Fyo;
            RecyclerView recyclerView2 = this.FDq;
            getContext();
            recyclerView2.setLayoutManager(new LinearLayoutManager());
            this.FDq.setAdapter(fVar);
            TextView textView2 = this.FDr;
            Context context2 = getContext();
            p.g(context2, "context");
            textView2.setText(context2.getResources().getString(R.string.hi9));
            if (arrayList.isEmpty()) {
                this.FDr.setVisibility(0);
                this.FDq.setVisibility(8);
            } else {
                this.FDr.setVisibility(8);
                this.FDq.setVisibility(0);
            }
        }
        this.FDq.post(new b(this));
        AppMethodBeat.o(120234);
    }

    public static final class b implements Runnable {
        final /* synthetic */ StoryMsgListView FDw;

        b(StoryMsgListView storyMsgListView) {
            this.FDw = storyMsgListView;
        }

        public final void run() {
            AppMethodBeat.i(120230);
            RecyclerView.a adapter = this.FDw.FDq.getAdapter();
            if (adapter != null) {
                RecyclerView.LayoutManager layoutManager = this.FDw.FDq.getLayoutManager();
                if (layoutManager != null) {
                    p.g(adapter, LocaleUtil.ITALIAN);
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(adapter.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(layoutManager, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$setup$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    layoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(layoutManager, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$setup$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    AppMethodBeat.o(120230);
                    return;
                }
                AppMethodBeat.o(120230);
                return;
            }
            AppMethodBeat.o(120230);
        }
    }

    public final void hA(List<com.tencent.mm.plugin.story.f.b.a> list) {
        RecyclerView.a adapter;
        AppMethodBeat.i(120235);
        p.h(list, "datas");
        if (list.isEmpty()) {
            this.FDr.setVisibility(0);
            this.FDq.setVisibility(8);
            AppMethodBeat.o(120235);
            return;
        }
        this.FDr.setVisibility(8);
        this.FDq.setVisibility(0);
        if (this.mode == FDt) {
            RecyclerView.a adapter2 = this.FDq.getAdapter();
            if (adapter2 == null) {
                AppMethodBeat.o(120235);
            } else if (adapter2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryVisitorListAdapter");
                AppMethodBeat.o(120235);
                throw tVar;
            } else {
                ((l) adapter2).hx(hz(list));
                this.FDq.post(new c(this, list));
                AppMethodBeat.o(120235);
            }
        } else if (this.mode != FDu || (adapter = this.FDq.getAdapter()) == null) {
            AppMethodBeat.o(120235);
        } else if (adapter == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
            AppMethodBeat.o(120235);
            throw tVar2;
        } else {
            ((f) adapter).aj(hz(list));
            this.FDq.post(new d(this, list));
            AppMethodBeat.o(120235);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c implements Runnable {
        final /* synthetic */ StoryMsgListView FDw;
        final /* synthetic */ List FDx;

        c(StoryMsgListView storyMsgListView, List list) {
            this.FDw = storyMsgListView;
            this.FDx = list;
        }

        public final void run() {
            AppMethodBeat.i(120231);
            RecyclerView.LayoutManager layoutManager = this.FDw.FDq.getLayoutManager();
            if (layoutManager != null) {
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.FDx.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(layoutManager, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                layoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(layoutManager, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                AppMethodBeat.o(120231);
                return;
            }
            AppMethodBeat.o(120231);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d implements Runnable {
        final /* synthetic */ StoryMsgListView FDw;
        final /* synthetic */ List FDx;

        d(StoryMsgListView storyMsgListView, List list) {
            this.FDw = storyMsgListView;
            this.FDx = list;
        }

        public final void run() {
            AppMethodBeat.i(120232);
            RecyclerView.LayoutManager layoutManager = this.FDw.FDq.getLayoutManager();
            if (layoutManager != null) {
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.FDx.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(layoutManager, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                layoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(layoutManager, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                AppMethodBeat.o(120232);
                return;
            }
            AppMethodBeat.o(120232);
        }
    }

    public final void hB(List<com.tencent.mm.plugin.story.f.b.a> list) {
        RecyclerView.a adapter;
        AppMethodBeat.i(120236);
        p.h(list, "datas");
        if (this.mode != FDu || (adapter = this.FDq.getAdapter()) == null) {
            AppMethodBeat.o(120236);
        } else if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
            AppMethodBeat.o(120236);
            throw tVar;
        } else {
            ((f) adapter).aj(hz(list));
            AppMethodBeat.o(120236);
        }
    }

    public final void abe(int i2) {
        AppMethodBeat.i(120237);
        ViewGroup.LayoutParams layoutParams = this.FDq.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(120237);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i2;
        requestLayout();
        AppMethodBeat.o(120237);
    }

    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 2) != 0;
    }

    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        this.mba = 0;
    }

    public final void onStopNestedScroll(View view) {
        int i2;
        kotlin.g.a.a<x> aVar;
        AppMethodBeat.i(120238);
        RecyclerView.LayoutManager layoutManager = this.FDq.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            RecyclerView.LayoutManager layoutManager2 = this.FDq.getLayoutManager();
            if (layoutManager2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                AppMethodBeat.o(120238);
                throw tVar;
            }
            i2 = ((GridLayoutManager) layoutManager2).kt();
        } else if (layoutManager instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager3 = this.FDq.getLayoutManager();
            if (layoutManager3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(120238);
                throw tVar2;
            }
            i2 = ((LinearLayoutManager) layoutManager3).kt();
        } else {
            i2 = -1;
        }
        if (i2 != 0 || (aVar = this.Fyr) == null) {
            AppMethodBeat.o(120238);
            return;
        }
        aVar.invoke();
        AppMethodBeat.o(120238);
    }

    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int i4;
        AppMethodBeat.i(120239);
        RecyclerView.LayoutManager layoutManager = this.FDq.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            RecyclerView.LayoutManager layoutManager2 = this.FDq.getLayoutManager();
            if (layoutManager2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                AppMethodBeat.o(120239);
                throw tVar;
            }
            i4 = ((GridLayoutManager) layoutManager2).kt();
        } else if (layoutManager instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager3 = this.FDq.getLayoutManager();
            if (layoutManager3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(120239);
                throw tVar2;
            }
            i4 = ((LinearLayoutManager) layoutManager3).kt();
        } else {
            i4 = -1;
        }
        if (i3 > 0) {
            if (this.mba != 0) {
                this.mba += i3;
                kotlin.g.a.b<? super Integer, x> bVar = this.Fyq;
                if (bVar != null) {
                    bVar.invoke(Integer.valueOf(i3));
                }
                if (iArr != null) {
                    iArr[0] = i2;
                }
                if (iArr != null) {
                    iArr[1] = i3;
                    AppMethodBeat.o(120239);
                    return;
                }
                AppMethodBeat.o(120239);
                return;
            }
        } else if (i3 < 0 && i4 == 0) {
            this.mba += i3;
            kotlin.g.a.b<? super Integer, x> bVar2 = this.Fyq;
            if (bVar2 != null) {
                bVar2.invoke(Integer.valueOf(i3));
            }
            if (iArr != null) {
                iArr[0] = i2;
            }
            if (iArr != null) {
                iArr[1] = i3;
                AppMethodBeat.o(120239);
                return;
            }
        }
        AppMethodBeat.o(120239);
    }
}
