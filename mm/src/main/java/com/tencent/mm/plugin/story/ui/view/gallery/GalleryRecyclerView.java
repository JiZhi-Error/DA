package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.ui.a.g;
import com.tencent.mm.plugin.story.ui.a.i;
import com.tencent.mm.plugin.story.ui.layout.GalleryLayoutManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u000223B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u000fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017Re\u0010\u0018\u001aM\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RL\u0010$\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001f\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "childControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "childRecyclerView", "value", "", "isActive", "()Z", "setActive", "(Z)V", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "onRowSelected", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "row", "rowView", "pageControl", "", "getOnRowSelected", "()Lkotlin/jvm/functions/Function3;", "setOnRowSelected", "(Lkotlin/jvm/functions/Function3;)V", "onScrollCallback", "Lkotlin/Function2;", "position", "", "offset", "getOnScrollCallback", "()Lkotlin/jvm/functions/Function2;", "setOnScrollCallback", "(Lkotlin/jvm/functions/Function2;)V", "selectedRow", "child", "Landroid/view/View;", "setScrollEnable", "enabled", "Companion", "VerticalAdapter", "plugin-story_release"})
public final class GalleryRecyclerView extends RecyclerView {
    public static final a FFe = new a((byte) 0);
    private static final String TAG = TAG;
    private final GalleryLayoutManager FFa;
    RecyclerView FFb;
    q<? super Integer, ? super RecyclerView, ? super GalleryHorizontalControlView, x> FFc;
    private m<? super Integer, ? super Float, x> FFd;
    int Fre;
    boolean isActive;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120362);
        this.FFa = new GalleryLayoutManager(context);
        setLayoutManager(this.FFa);
        this.FFa.uyJ = new m<Integer, View, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView.AnonymousClass1 */
            final /* synthetic */ GalleryRecyclerView FFf;

            {
                this.FFf = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, View view) {
                RecyclerView recyclerView;
                RecyclerView.LayoutManager layoutManager;
                int i2;
                GalleryHorizontalControlView galleryHorizontalControlView;
                AppMethodBeat.i(120352);
                int intValue = num.intValue();
                View view2 = view;
                p.h(view2, "child");
                GalleryRecyclerView galleryRecyclerView = this.FFf;
                p.h(view2, "child");
                int i3 = galleryRecyclerView.Fre;
                galleryRecyclerView.Fre = intValue;
                RecyclerView recyclerView2 = galleryRecyclerView.FFb;
                p pVar = (p) galleryRecyclerView.bi(view2);
                if (pVar != null) {
                    recyclerView = pVar.hak;
                } else {
                    recyclerView = null;
                }
                galleryRecyclerView.FFb = recyclerView;
                q<? super Integer, ? super RecyclerView, ? super GalleryHorizontalControlView, x> qVar = galleryRecyclerView.FFc;
                if (qVar != null) {
                    Integer valueOf = Integer.valueOf(intValue);
                    RecyclerView recyclerView3 = galleryRecyclerView.FFb;
                    if (pVar != null) {
                        galleryHorizontalControlView = pVar.FIs;
                    } else {
                        galleryHorizontalControlView = null;
                    }
                    qVar.d(valueOf, recyclerView3, galleryHorizontalControlView);
                }
                if (recyclerView2 != null) {
                    layoutManager = recyclerView2.getLayoutManager();
                } else {
                    layoutManager = null;
                }
                GalleryLayoutManager galleryLayoutManager = (GalleryLayoutManager) layoutManager;
                if (galleryRecyclerView.getAdapter() instanceof b) {
                    RecyclerView.a adapter = galleryRecyclerView.getAdapter();
                    if (adapter == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView.VerticalAdapter");
                        AppMethodBeat.o(120352);
                        throw tVar;
                    }
                    b bVar = (b) adapter;
                    if (galleryLayoutManager != null) {
                        i2 = galleryLayoutManager.va;
                    } else {
                        i2 = 0;
                    }
                    bVar.FFh = i3;
                    bVar.FFi = i2;
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120352);
                return xVar;
            }
        };
        this.FFa.FzM = new m<Integer, Float, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView.AnonymousClass2 */
            final /* synthetic */ GalleryRecyclerView FFf;

            {
                this.FFf = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, Float f2) {
                AppMethodBeat.i(120353);
                int intValue = num.intValue();
                float floatValue = f2.floatValue();
                m<Integer, Float, x> onScrollCallback = this.FFf.getOnScrollCallback();
                if (onScrollCallback != null) {
                    onScrollCallback.invoke(Integer.valueOf(intValue), Float.valueOf(floatValue));
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120353);
                return xVar;
            }
        };
        b(new b(1));
        setItemAnimator(null);
        setItemViewCacheSize(0);
        AppMethodBeat.o(120362);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GalleryRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120363);
        AppMethodBeat.o(120363);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(120364);
        AppMethodBeat.o(120364);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final GalleryLayoutManager getLayoutManager() {
        return this.FFa;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.q<? super java.lang.Integer, ? super android.support.v7.widget.RecyclerView, ? super com.tencent.mm.plugin.story.ui.view.gallery.GalleryHorizontalControlView, kotlin.x>, kotlin.g.a.q<java.lang.Integer, android.support.v7.widget.RecyclerView, com.tencent.mm.plugin.story.ui.view.gallery.GalleryHorizontalControlView, kotlin.x> */
    public final q<Integer, RecyclerView, GalleryHorizontalControlView, x> getOnRowSelected() {
        return this.FFc;
    }

    public final void setOnRowSelected(q<? super Integer, ? super RecyclerView, ? super GalleryHorizontalControlView, x> qVar) {
        this.FFc = qVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.Float, kotlin.x>, kotlin.g.a.m<java.lang.Integer, java.lang.Float, kotlin.x> */
    public final m<Integer, Float, x> getOnScrollCallback() {
        return this.FFd;
    }

    public final void setOnScrollCallback(m<? super Integer, ? super Float, x> mVar) {
        this.FFd = mVar;
    }

    public final void setActive(boolean z) {
        RecyclerView.a aVar;
        RecyclerView.a aVar2;
        AppMethodBeat.i(120360);
        this.isActive = z;
        RecyclerView recyclerView = this.FFb;
        if (recyclerView != null) {
            aVar = recyclerView.getAdapter();
        } else {
            aVar = null;
        }
        if (aVar instanceof g) {
            RecyclerView recyclerView2 = this.FFb;
            if (recyclerView2 != null) {
                aVar2 = recyclerView2.getAdapter();
            } else {
                aVar2 = null;
            }
            if (aVar2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryGalleryAdapter");
                AppMethodBeat.o(120360);
                throw tVar;
            }
            ((g) aVar2).isActive = z;
        }
        AppMethodBeat.o(120360);
    }

    public final void setScrollEnable(boolean z) {
        AppMethodBeat.i(120361);
        this.FFa.hbX = z;
        RecyclerView recyclerView = this.FFb;
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager instanceof GalleryLayoutManager) {
            ((GalleryLayoutManager) layoutManager).hbX = z;
        }
        AppMethodBeat.o(120361);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J$\u0010\u001f\u001a\u00020\n2\u001c\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120!J\u0016\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006R7\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR>\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120\u0010j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012`\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$VerticalAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;)V", "bindCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getBindCallback", "()Lkotlin/jvm/functions/Function1;", "setBindCallback", "(Lkotlin/jvm/functions/Function1;)V", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "prePosition", "preRow", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "update", "items", "", "updateChildRecyclerPosition", "row", "plugin-story_release"})
    public final class b extends RecyclerView.a<p> {
        kotlin.g.a.b<? super Integer, x> FFg;
        int FFh = -1;
        int FFi;
        private final ArrayList<ArrayList<h>> Fsh = new ArrayList<>();
        private final RecyclerView.m haJ = new RecyclerView.m();

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(120359);
            this.haJ.aw(0, 2);
            AppMethodBeat.o(120359);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ p a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(120355);
            p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c09, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            layoutParams.width = viewGroup.getWidth();
            layoutParams.height = viewGroup.getHeight();
            p.g(inflate, "itemView");
            inflate.setLayoutParams(layoutParams);
            p pVar = new p(inflate, viewGroup.getWidth(), viewGroup.getHeight());
            pVar.hak.setRecycledViewPool(this.haJ);
            p pVar2 = pVar;
            AppMethodBeat.o(120355);
            return pVar2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(p pVar, int i2) {
            int i3;
            AppMethodBeat.i(120357);
            p pVar2 = pVar;
            p.h(pVar2, "holder");
            g gVar = pVar2.FIr;
            ArrayList<h> arrayList = this.Fsh.get(i2);
            p.g(arrayList, "galleryItems[position]");
            gVar.hw(arrayList);
            pVar2.FIr.isActive = GalleryRecyclerView.this.isActive;
            pVar2.FIr.notifyDataSetChanged();
            GalleryHorizontalControlView galleryHorizontalControlView = pVar2.FIs;
            ArrayList<h> arrayList2 = this.Fsh.get(i2);
            p.g(arrayList2, "galleryItems[position]");
            galleryHorizontalControlView.hw(arrayList2);
            kotlin.g.a.b<? super Integer, x> bVar = this.FFg;
            if (bVar != null) {
                bVar.invoke(Integer.valueOf(i2));
            }
            if (i2 == this.FFh) {
                i3 = this.FFi;
            } else {
                i3 = 0;
            }
            RecyclerView recyclerView = pVar2.hak;
            com.tencent.mm.hellhoundlib.b.a a2 = c.a(i3, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$VerticalAdapter", "onBindViewHolder", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;I)V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$VerticalAdapter", "onBindViewHolder", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;I)V", "Undefined", "scrollToPosition", "(I)V");
            pVar2.FIs.setSelection(i3);
            AppMethodBeat.o(120357);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void k(p pVar) {
            AppMethodBeat.i(120358);
            p pVar2 = pVar;
            p.h(pVar2, "holder");
            super.k(pVar2);
            if (pVar2.hak.getChildCount() > 0) {
                RecyclerView.v bi = pVar2.hak.bi(pVar2.hak.getChildAt(0));
                if (bi instanceof i) {
                    ((i) bi).frU();
                }
            }
            AppMethodBeat.o(120358);
        }

        public final void hw(List<? extends ArrayList<h>> list) {
            AppMethodBeat.i(120354);
            p.h(list, "items");
            this.Fsh.clear();
            this.Fsh.addAll(list);
            AppMethodBeat.o(120354);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(120356);
            int size = this.Fsh.size();
            AppMethodBeat.o(120356);
            return size;
        }
    }
}
