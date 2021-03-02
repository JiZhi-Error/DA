package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0003%&'B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\nH\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u000fH\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator;", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "count", "", "currentIndex", "isShowOnlyOneIndicator", "", "onSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "sliderAdapter", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "getSliderAdapter", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "sliderLayoutManager", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "getSliderLayoutManager", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "setCount", "", "setCurrentIndex", FirebaseAnalytics.b.INDEX, "setOnSelectedPageListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setShowOnlyOneIndicator", "isShow", "SliderAdapter", "SliderItemViewHolder", "SliderLayoutManager", "plugin-finder_release"})
public final class FinderMediaGestureIndicator extends RecyclerView implements h {
    private int count;
    private int currentIndex;
    private h.a wso;
    private boolean wsp;
    private final a wsr = new a();
    private final SliderLayoutManager wss;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMediaGestureIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(255241);
        Context context2 = getContext();
        p.g(context2, "context");
        this.wss = new SliderLayoutManager(context2);
        setAdapter(this.wsr);
        setLayoutManager(this.wss);
        setHasFixedSize(true);
        setClipToPadding(false);
        this.wsp = true;
        AppMethodBeat.o(255241);
    }

    public final a getSliderAdapter() {
        return this.wsr;
    }

    public final SliderLayoutManager getSliderLayoutManager() {
        return this.wss;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u001e\u0010\u001c\u001a\u00020\u00152\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0011j\b\u0012\u0004\u0012\u00020\u000b`\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0011j\b\u0012\u0004\u0012\u00020\u000b`\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderItemViewHolder;", "()V", "callback", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;)V", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "Callback", "plugin-finder_release"})
    public static final class a extends RecyclerView.a<b> {
        int currentIndex;
        final ArrayList<Integer> data = new ArrayList<>();
        AbstractC1339a wst;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$Callback;", "", "onItemClicked", "", "view", "Landroid/view/View;", FirebaseAnalytics.b.INDEX, "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator$a$a  reason: collision with other inner class name */
        public interface AbstractC1339a {
        }

        public a() {
            AppMethodBeat.i(255228);
            AppMethodBeat.o(255228);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(255225);
            p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.avz, viewGroup, false);
            p.g(inflate, "LayoutInflater.from(pare…le_layout, parent, false)");
            b bVar = new b(inflate);
            AppMethodBeat.o(255225);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            AppMethodBeat.i(255227);
            b bVar2 = bVar;
            p.h(bVar2, "holder");
            bVar2.aus.setOnClickListener(new b(this, bVar2, i2));
            if (this.currentIndex == i2) {
                ImageView imageView = bVar2.wsw;
                if (imageView != null) {
                    imageView.setBackgroundResource(R.drawable.ash);
                    AppMethodBeat.o(255227);
                    return;
                }
                AppMethodBeat.o(255227);
                return;
            }
            ImageView imageView2 = bVar2.wsw;
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.a6z);
                AppMethodBeat.o(255227);
                return;
            }
            AppMethodBeat.o(255227);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(255226);
            int size = this.data.size();
            AppMethodBeat.o(255226);
            return size;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class b implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ a wsu;
            final /* synthetic */ b wsv;

            b(a aVar, b bVar, int i2) {
                this.wsu = aVar;
                this.wsv = bVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(255224);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.wsu.wst != null) {
                    p.g(this.wsv.aus, "holder.itemView");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255224);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "circleView", "Landroid/widget/ImageView;", "getCircleView", "()Landroid/widget/ImageView;", "plugin-finder_release"})
    public static final class b extends RecyclerView.v {
        final ImageView wsw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(255229);
            this.wsw = (ImageView) view.findViewById(R.id.b32);
            AppMethodBeat.o(255229);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0002J(\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010!\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\"\u001a\u00020\u0014H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;", "setCallback", "(Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "getRecyclerViewCenterX", "", "onAttachedToWindow", "", "view", "onLayoutChildren", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "scaleDownView", "scrollHorizontallyBy", "dx", "smoothScrollToPosition", "position", "OnItemSelectedListener", "plugin-finder_release"})
    public static final class SliderLayoutManager extends LinearLayoutManager {
        private RecyclerView hak;
        float wsx = 50.0f;

        public SliderLayoutManager(Context context) {
            p.h(context, "context");
            AppMethodBeat.i(255237);
            setOrientation(0);
            AppMethodBeat.o(255237);
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager
        public final void onAttachedToWindow(RecyclerView recyclerView) {
            AppMethodBeat.i(255231);
            super.onAttachedToWindow(recyclerView);
            if (recyclerView == null) {
                p.hyc();
            }
            this.hak = recyclerView;
            af afVar = new af();
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            afVar.f(recyclerView2);
            AppMethodBeat.o(255231);
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
        public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
            AppMethodBeat.i(255232);
            p.h(sVar, "state");
            super.onLayoutChildren(nVar, sVar);
            dHy();
            AppMethodBeat.o(255232);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
        public static final class a extends ae {
            final /* synthetic */ RecyclerView tDJ;
            final /* synthetic */ SliderLayoutManager wsy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(SliderLayoutManager sliderLayoutManager, RecyclerView recyclerView, Context context) {
                super(context);
                this.wsy = sliderLayoutManager;
                this.tDJ = recyclerView;
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                AppMethodBeat.i(255230);
                p.h(displayMetrics, "displayMetrics");
                float f2 = this.wsy.wsx / ((float) displayMetrics.densityDpi);
                AppMethodBeat.o(255230);
                return f2;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
        public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
            AppMethodBeat.i(255233);
            p.h(recyclerView, "recyclerView");
            a aVar = new a(this, recyclerView, recyclerView.getContext());
            aVar.ct(i2);
            startSmoothScroll(aVar);
            AppMethodBeat.o(255233);
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
        public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
            AppMethodBeat.i(255234);
            if (getOrientation() == 0) {
                int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
                dHy();
                AppMethodBeat.o(255234);
                return scrollHorizontallyBy;
            }
            AppMethodBeat.o(255234);
            return 0;
        }

        private final void dHy() {
            AppMethodBeat.i(255235);
            float width = ((float) getWidth()) / 2.0f;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt == null) {
                    p.hyc();
                }
                p.g(childAt, "getChildAt(i)!!");
                float sqrt = 1.0f - (((float) Math.sqrt((double) (Math.abs(width - (((float) (getDecoratedLeft(childAt) + getDecoratedRight(childAt))) / 2.0f)) / ((float) getWidth())))) * 0.66f);
                childAt.setScaleX(sqrt);
                childAt.setScaleY(sqrt);
            }
            AppMethodBeat.o(255235);
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager
        public final void onScrollStateChanged(int i2) {
            AppMethodBeat.i(255236);
            super.onScrollStateChanged(i2);
            if (i2 == 0) {
                RecyclerView recyclerView = this.hak;
                if (recyclerView == null) {
                    p.btv("recyclerView");
                }
                int right = recyclerView.getRight();
                RecyclerView recyclerView2 = this.hak;
                if (recyclerView2 == null) {
                    p.btv("recyclerView");
                }
                int left = (right - recyclerView2.getLeft()) / 2;
                RecyclerView recyclerView3 = this.hak;
                if (recyclerView3 == null) {
                    p.btv("recyclerView");
                }
                int left2 = left + recyclerView3.getLeft();
                int i3 = Integer.MAX_VALUE;
                RecyclerView recyclerView4 = this.hak;
                if (recyclerView4 == null) {
                    p.btv("recyclerView");
                }
                int childCount = recyclerView4.getChildCount();
                int i4 = 0;
                while (i4 < childCount) {
                    RecyclerView recyclerView5 = this.hak;
                    if (recyclerView5 == null) {
                        p.btv("recyclerView");
                    }
                    View childAt = recyclerView5.getChildAt(i4);
                    int abs = Math.abs((getDecoratedLeft(childAt) + ((getDecoratedRight(childAt) - getDecoratedLeft(childAt)) / 2)) - left2);
                    if (abs < i3) {
                        if (this.hak == null) {
                            p.btv("recyclerView");
                        }
                        RecyclerView.bx(childAt);
                    } else {
                        abs = i3;
                    }
                    i4++;
                    i3 = abs;
                }
            }
            AppMethodBeat.o(255236);
        }
    }

    @Override // com.tencent.mm.view.h
    public final void setShowOnlyOneIndicator(boolean z) {
        this.wsp = z;
    }

    @Override // com.tencent.mm.view.h
    public final void setCount(int i2) {
        AppMethodBeat.i(255238);
        this.count = i2;
        setCurrentIndex(0);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        a aVar = this.wsr;
        p.h(arrayList, "data");
        aVar.data.clear();
        aVar.data.addAll(arrayList);
        aVar.notifyDataSetChanged();
        AppMethodBeat.o(255238);
    }

    @Override // com.tencent.mm.view.h
    public final int getCount() {
        return this.count;
    }

    @Override // com.tencent.mm.view.h
    public final void setCurrentIndex(int i2) {
        AppMethodBeat.i(255239);
        int i3 = this.currentIndex;
        this.wsr.ci(i3);
        this.currentIndex = i2;
        this.wsr.currentIndex = i2;
        this.wsr.ci(i2);
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(i3 + (i2 - i3), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(this, a2.axQ(), "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator", "setCurrentIndex", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator", "setCurrentIndex", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        AppMethodBeat.o(255239);
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    @Override // com.tencent.mm.view.h
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.view.h
    public final void setOnSelectedPageListener(h.a aVar) {
        AppMethodBeat.i(255240);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.wso = aVar;
        AppMethodBeat.o(255240);
    }

    public final h.a getOnSelectedPageListener() {
        return this.wso;
    }
}
