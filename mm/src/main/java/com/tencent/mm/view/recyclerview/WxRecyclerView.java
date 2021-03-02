package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0012\b\u0016\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0014J0\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\u0012\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0016J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0016J\u0018\u0010.\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\nH\u0016J\u0016\u00101\u001a\u00020\u001e2\f\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0015H\u0016J\"\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\nH\u0016J\b\u0010<\u001a\u00020\u001eH\u0016R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006>"}, hxF = {"Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mm/view/recyclerview/ISupportStrongConfig;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "flingSpeedFactor", "getFlingSpeedFactor", "()I", "setFlingSpeedFactor", "(I)V", "logObserver", "com/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1;", "canScrollHorizontally", "", TencentLocation.EXTRA_DIRECTION, "canScrollVertically", "fling", "velocityX", "velocityY", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "onAttachedToWindow", "", "onLayout", "changed", "l", "t", "r", "b", "onViewAdded", "child", "Landroid/view/View;", "onViewRemoved", "openRecyclerViewDebug", "requestLayout", "scrollBy", "x", "y", "scrollTo", "scrollToPosition", "position", "setAdapter", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "setLayoutFrozen", "frozen", "smoothScrollBy", "dx", "dy", "interpolator", "Landroid/view/animation/Interpolator;", "smoothScrollToPosition", "stopScroll", "Companion", "libmmui_release"})
public class WxRecyclerView extends RecyclerView {
    private static final f RrQ = g.ah(c.RrU);
    private static final f RrR = g.ah(b.RrT);
    public static final a RrS = new a((byte) 0);
    private int RrO = 100;
    private final d RrP = new d();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxRecyclerView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(205084);
        AppMethodBeat.o(205084);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164762);
        AppMethodBeat.o(164762);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164763);
        AppMethodBeat.o(164763);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\n\u0010\u0007R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/view/recyclerview/WxRecyclerView$Companion;", "", "()V", "TAG", "", "isEnableDumpStack", "", "()Z", "isEnableDumpStack$delegate", "Lkotlin/Lazy;", "isOpenRecyclerViewDebug", "isOpenRecyclerViewDebug$delegate", "isOpenRecyclerViewSystemDebug", "libmmui_release"})
    public static final class a {
        public static boolean hgA() {
            AppMethodBeat.i(164741);
            f fVar = WxRecyclerView.RrQ;
            a aVar = WxRecyclerView.RrS;
            boolean booleanValue = ((Boolean) fVar.getValue()).booleanValue();
            AppMethodBeat.o(164741);
            return booleanValue;
        }

        public static boolean hgB() {
            AppMethodBeat.i(164742);
            f fVar = WxRecyclerView.RrR;
            a aVar = WxRecyclerView.RrS;
            boolean booleanValue = ((Boolean) fVar.getValue()).booleanValue();
            AppMethodBeat.o(164742);
            return booleanValue;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(164764);
        AppMethodBeat.o(164764);
    }

    public final int getFlingSpeedFactor() {
        return this.RrO;
    }

    public final void setFlingSpeedFactor(int i2) {
        this.RrO = i2;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onAttachedToWindow() {
        AppMethodBeat.i(164749);
        super.onAttachedToWindow();
        AppMethodBeat.o(164749);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean ak(int i2, int i3) {
        AppMethodBeat.i(205081);
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
            if (layoutManager2 == null || !layoutManager2.canScrollVertically()) {
                boolean ak = super.ak(i2, i3);
                AppMethodBeat.o(205081);
                return ak;
            }
            boolean ak2 = super.ak(i2, kotlin.h.a.cR(((float) (this.RrO * i3)) / 100.0f));
            AppMethodBeat.o(205081);
            return ak2;
        }
        boolean ak3 = super.ak(kotlin.h.a.cR(((float) (this.RrO * i2)) / 100.0f), i3);
        AppMethodBeat.o(205081);
        return ak3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
    public static final class d extends RecyclerView.c {
        d() {
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            AppMethodBeat.i(164743);
            super.onChanged();
            a aVar = WxRecyclerView.RrS;
            if (a.hgA()) {
                StringBuilder sb = new StringBuilder("[notify onChanged] ");
                a aVar2 = WxRecyclerView.RrS;
                Log.d("MicroMsg.WxRecyclerView", sb.append(a.hgB() ? Util.getStack() : "").toString());
            }
            AppMethodBeat.o(164743);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            AppMethodBeat.i(164744);
            super.onItemRangeChanged(i2, i3);
            a aVar = WxRecyclerView.RrS;
            if (a.hgA()) {
                StringBuilder append = new StringBuilder("[notify onItemRangeChanged] positionStart=").append(i2).append(" itemCount=").append(i3).append(' ');
                a aVar2 = WxRecyclerView.RrS;
                Log.d("MicroMsg.WxRecyclerView", append.append(a.hgB() ? Util.getStack() : "").toString());
            }
            AppMethodBeat.o(164744);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(164745);
            super.onItemRangeChanged(i2, i3, obj);
            a aVar = WxRecyclerView.RrS;
            if (a.hgA()) {
                StringBuilder append = new StringBuilder("[notify onItemRangeChanged] positionStart=").append(i2).append(" itemCount=").append(i3).append(" payload=").append(obj).append(' ');
                a aVar2 = WxRecyclerView.RrS;
                Log.d("MicroMsg.WxRecyclerView", append.append(a.hgB() ? Util.getStack() : "").toString());
            }
            AppMethodBeat.o(164745);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(164746);
            super.onItemRangeInserted(i2, i3);
            a aVar = WxRecyclerView.RrS;
            if (a.hgA()) {
                StringBuilder append = new StringBuilder("[notify onItemRangeInserted] positionStart=").append(i2).append(" itemCount=").append(i3).append(' ');
                a aVar2 = WxRecyclerView.RrS;
                Log.d("MicroMsg.WxRecyclerView", append.append(a.hgB() ? Util.getStack() : "").toString());
            }
            AppMethodBeat.o(164746);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            AppMethodBeat.i(164747);
            super.onItemRangeMoved(i2, i3, i4);
            a aVar = WxRecyclerView.RrS;
            if (a.hgA()) {
                StringBuilder append = new StringBuilder("[notify onItemRangeMoved] fromPosition=").append(i2).append(" toPosition=").append(i3).append(" itemCount=").append(i4).append(' ');
                a aVar2 = WxRecyclerView.RrS;
                Log.d("MicroMsg.WxRecyclerView", append.append(a.hgB() ? Util.getStack() : "").toString());
            }
            AppMethodBeat.o(164747);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(164748);
            super.onItemRangeRemoved(i2, i3);
            a aVar = WxRecyclerView.RrS;
            if (a.hgA()) {
                StringBuilder append = new StringBuilder("[notify onItemRangeRemoved] positionStart=").append(i2).append(" itemCount=").append(i3).append(' ');
                a aVar2 = WxRecyclerView.RrS;
                Log.d("MicroMsg.WxRecyclerView", append.append(a.hgB() ? Util.getStack() : "").toString());
            }
            AppMethodBeat.o(164748);
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.a<?> aVar) {
        AppMethodBeat.i(164750);
        super.setAdapter(aVar);
        if (aVar instanceof g) {
            ((g) aVar).RqI = true;
        }
        if (aVar != null) {
            aVar.a((RecyclerView.c) this.RrP);
            AppMethodBeat.o(164750);
            return;
        }
        AppMethodBeat.o(164750);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(164751);
        super.onLayout(z, i2, i3, i4, i5);
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[onLayout] changed=" + z + " [" + i2 + ':' + i3 + ':' + i4 + ':' + i5 + "] " + (a.hgB() ? Util.getStack() : ""));
        }
        AppMethodBeat.o(164751);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void requestLayout() {
        AppMethodBeat.i(164752);
        super.requestLayout();
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[requestLayout] " + (a.hgB() ? Util.getStack() : ""));
        }
        AppMethodBeat.o(164752);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void scrollBy(int i2, int i3) {
        AppMethodBeat.i(164753);
        super.scrollBy(i2, i3);
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[scrollBy] x=" + i2 + " y=" + i2);
        }
        AppMethodBeat.o(164753);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void scrollTo(int i2, int i3) {
        AppMethodBeat.i(164754);
        super.scrollTo(i2, i3);
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[scrollTo] x=" + i2 + " y=" + i2);
        }
        AppMethodBeat.o(164754);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(164755);
        super.scrollToPosition(i2);
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[scrollToPosition] position=".concat(String.valueOf(i2)));
        }
        AppMethodBeat.o(164755);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final void kQ() {
        AppMethodBeat.i(164756);
        super.kQ();
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[stopScroll] " + (a.hgB() ? Util.getStack() : ""));
        }
        AppMethodBeat.o(164756);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final void smoothScrollToPosition(int i2) {
        AppMethodBeat.i(164757);
        super.smoothScrollToPosition(i2);
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[smoothScrollToPosition] position=" + i2 + ' ' + (a.hgB() ? Util.getStack() : ""));
        }
        AppMethodBeat.o(164757);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final void a(int i2, int i3, Interpolator interpolator) {
        AppMethodBeat.i(164758);
        super.a(i2, i3, interpolator);
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[smoothScrollBy] dx=" + i2 + " dy=" + i3 + " interpolator=" + interpolator + ' ' + (a.hgB() ? Util.getStack() : ""));
        }
        AppMethodBeat.o(164758);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setLayoutFrozen(boolean z) {
        AppMethodBeat.i(164759);
        super.setLayoutFrozen(z);
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[setLayoutFrozen] frozen=" + z + ' ' + (a.hgB() ? Util.getStack() : ""));
        }
        AppMethodBeat.o(164759);
    }

    public void onViewAdded(View view) {
        AppMethodBeat.i(164760);
        super.onViewAdded(view);
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[onViewAdded] child=" + view + ' ' + (a.hgB() ? Util.getStack() : ""));
        }
        AppMethodBeat.o(164760);
    }

    public void onViewRemoved(View view) {
        AppMethodBeat.i(164761);
        super.onViewRemoved(view);
        if (a.hgA()) {
            Log.d("MicroMsg.WxRecyclerView", "[onViewRemoved] child=" + view + ' ' + (a.hgB() ? Util.getStack() : ""));
        }
        AppMethodBeat.o(164761);
    }

    public boolean canScrollHorizontally(int i2) {
        AppMethodBeat.i(205082);
        boolean canScrollHorizontally = super.canScrollHorizontally(i2);
        if (a.hgA()) {
            Log.i("MicroMsg.WxRecyclerView", "[canScrollHorizontally] direction=" + i2 + " result=" + canScrollHorizontally);
        }
        AppMethodBeat.o(205082);
        return canScrollHorizontally;
    }

    public boolean canScrollVertically(int i2) {
        AppMethodBeat.i(205083);
        boolean canScrollVertically = super.canScrollVertically(i2);
        if (a.hgA()) {
            Log.i("MicroMsg.WxRecyclerView", "[canScrollVertically] direction=" + i2 + " result=" + canScrollVertically);
        }
        AppMethodBeat.o(205083);
        return canScrollVertically;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Boolean> {
        public static final c RrU = new c();

        static {
            AppMethodBeat.i(164739);
            AppMethodBeat.o(164739);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z = true;
            AppMethodBeat.i(164738);
            if (Log.getLogLevel() > 1 && !BuildInfo.DEBUG) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(164738);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        public static final b RrT = new b();

        static {
            AppMethodBeat.i(164737);
            AppMethodBeat.o(164737);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(164736);
            if (Log.getLogLevel() <= 0) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(164736);
            return valueOf;
        }
    }
}
