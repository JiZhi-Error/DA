package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u0003345B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ0\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002J\u0006\u0010$\u001a\u00020%J0\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0014J\u0012\u0010,\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0002J\u0014\u00102\u001a\u00020%2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R6\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001c0\u001bj\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001c`\u001dX\u0004¢\u0006\u0002\n\u0000¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView;", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "isDataChange", "", "isPrint", "itemViewWidth", "getItemViewWidth", "()I", "setItemViewWidth", "(I)V", "padding", "", "getPadding", "()F", "viewPool", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "createView", "width", "height", "offsetX", "offsetY", FirebaseAnalytics.b.INDEX, "notifyDataChange", "", "onLayout", "changed", "left", "top", "right", "bottom", "onViewRemoved", "child", "Landroid/view/View;", SharePatchInfo.FINGER_PRINT, "content", "", "setAdapter", "Adapter", "Companion", "Holder", "plugin-finder_release"})
public final class FinderFeedAlbumView extends RoundedCornerFrameLayout {
    public static final b wmc = new b((byte) 0);
    private final float ddU;
    private final HashMap<Integer, LinkedList<c>> wlX = new HashMap<>();
    private a<? extends c> wlY;
    private boolean wlZ;
    private int wma = -1;
    private final boolean wmb;

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H&J%\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "V", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "", "()V", "getItemType", "", "position", "getSize", "onBindView", "", "itemView", "Landroid/view/View;", "holder", "onCreateView", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/widget/FrameLayout;", "(Landroid/view/LayoutInflater;Landroid/widget/FrameLayout;I)Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "plugin-finder_release"})
    public static abstract class a<V extends c> {
        public abstract int Mm(int i2);

        public abstract V a(LayoutInflater layoutInflater, FrameLayout frameLayout, int i2);

        public abstract void a(View view, int i2, c cVar);

        public abstract int getSize();
    }

    static {
        AppMethodBeat.i(254792);
        AppMethodBeat.o(254792);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFeedAlbumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254790);
        Context context2 = getContext();
        p.g(context2, "context");
        this.ddU = context2.getResources().getDimension(R.dimen.bt) / 2.0f;
        AppMethodBeat.o(254790);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFeedAlbumView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(254791);
        Context context2 = getContext();
        p.g(context2, "context");
        this.ddU = context2.getResources().getDimension(R.dimen.bt) / 2.0f;
        AppMethodBeat.o(254791);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Companion;", "", "()V", "ITEM_COUNT", "", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final int getItemViewWidth() {
        return this.wma;
    }

    public final void setItemViewWidth(int i2) {
        this.wma = i2;
    }

    public final float getPadding() {
        return this.ddU;
    }

    public final void setAdapter(a<? extends c> aVar) {
        AppMethodBeat.i(254784);
        p.h(aVar, "adapter");
        this.wlY = aVar;
        dGH();
        AppMethodBeat.o(254784);
    }

    public final void dGH() {
        AppMethodBeat.i(254785);
        this.wlZ = true;
        print("[notifyDataChange] isInLayout=" + isInLayout());
        post(new d(this));
        AppMethodBeat.o(254785);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ FinderFeedAlbumView wmd;

        d(FinderFeedAlbumView finderFeedAlbumView) {
            this.wmd = finderFeedAlbumView;
        }

        public final void run() {
            AppMethodBeat.i(254783);
            this.wmd.requestLayout();
            AppMethodBeat.o(254783);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "plugin-finder_release"})
    public static abstract class c {
        final View aus;

        public c(View view) {
            p.h(view, "itemView");
            this.aus = view;
        }
    }

    @Override // com.tencent.mm.ui.widget.RoundedCornerFrameLayout
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c j2;
        AppMethodBeat.i(254786);
        super.onLayout(z, i2, i3, i4, i5);
        int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        int paddingStart = ((i4 - i2) - getPaddingStart()) - getPaddingEnd();
        a<? extends c> aVar = this.wlY;
        int na = j.na(4, aVar != null ? aVar.getSize() : 0);
        if (na <= 0) {
            AppMethodBeat.o(254786);
            return;
        }
        print("[onLayout] changed=" + z + " isDataChange=" + this.wlZ + " width=" + paddingStart + " height=" + paddingTop + " size=" + na);
        if (z || this.wlZ) {
            removeAllViews();
            float f2 = ((float) paddingTop) / 3.0f;
            float f3 = ((float) paddingStart) / 3.0f;
            for (int i6 = 0; i6 < na; i6++) {
                switch (i6) {
                    case 0:
                        j2 = j(kotlin.h.a.cR(2.0f * f3), kotlin.h.a.cR(2.0f * f2), 0, 0, i6);
                        break;
                    case 1:
                        j2 = j(kotlin.h.a.cR(f3), kotlin.h.a.cR(1.5f * f2), kotlin.h.a.cR((2.0f * f3) + this.ddU), 0, i6);
                        break;
                    case 2:
                        j2 = j(kotlin.h.a.cR(2.0f * f3), kotlin.h.a.cR(f2), 0, kotlin.h.a.cR((2.0f * f2) + this.ddU), i6);
                        break;
                    default:
                        j2 = j(kotlin.h.a.cR(f3), kotlin.h.a.cR(1.5f * f2), kotlin.h.a.cR((2.0f * f3) + this.ddU), kotlin.h.a.cR((1.5f * f2) + this.ddU), i6);
                        break;
                }
                View view = j2.aus;
                addViewInLayout(view, i6, view.getLayoutParams());
                a<? extends c> aVar2 = this.wlY;
                if (aVar2 != null) {
                    aVar2.a(j2.aus, i6, j2);
                }
            }
            this.wlZ = false;
        }
        AppMethodBeat.o(254786);
    }

    private final c j(int i2, int i3, int i4, int i5, int i6) {
        c cVar;
        c poll;
        AppMethodBeat.i(254787);
        a<? extends c> aVar = this.wlY;
        if (aVar == null) {
            p.hyc();
        }
        int Mm = aVar.Mm(i6);
        LinkedList<c> linkedList = this.wlX.get(Integer.valueOf(Mm));
        if (linkedList == null || (poll = linkedList.poll()) == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            p.g(from, "LayoutInflater.from(this.context)");
            cVar = aVar.a(from, this, i6);
        } else {
            cVar = poll;
        }
        cVar.aus.setLayoutParams(new FrameLayout.LayoutParams(i2, i3));
        cVar.aus.setTag(R.id.ck7, cVar);
        cVar.aus.setTag(R.id.ck8, Integer.valueOf(Mm));
        cVar.aus.setTranslationX((float) i4);
        cVar.aus.setTranslationY((float) i5);
        print("[createView] width=" + i2 + " height=" + i3 + " offsetX=" + i4 + " offsetY=" + i5 + " index=" + i6);
        AppMethodBeat.o(254787);
        return cVar;
    }

    public final void onViewRemoved(View view) {
        Object obj;
        LinkedList<c> linkedList;
        Integer num = null;
        AppMethodBeat.i(254788);
        super.onViewRemoved(view);
        Object tag = view != null ? view.getTag(R.id.ck7) : null;
        if (!(tag instanceof c)) {
            tag = null;
        }
        c cVar = (c) tag;
        if (view != null) {
            obj = view.getTag(R.id.ck8);
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = obj;
        }
        Integer num2 = num;
        int intValue = num2 != null ? num2.intValue() : 0;
        if (cVar != null) {
            if (!this.wlX.containsKey(Integer.valueOf(intValue))) {
                LinkedList<c> linkedList2 = new LinkedList<>();
                this.wlX.put(Integer.valueOf(intValue), linkedList2);
                linkedList = linkedList2;
            } else {
                LinkedList<c> linkedList3 = this.wlX.get(Integer.valueOf(intValue));
                if (linkedList3 == null) {
                    p.hyc();
                }
                p.g(linkedList3, "viewPool[type]!!");
                linkedList = linkedList3;
            }
            if (!linkedList.contains(cVar)) {
                linkedList.add(cVar);
            }
            AppMethodBeat.o(254788);
            return;
        }
        AppMethodBeat.o(254788);
    }

    private final void print(String str) {
        AppMethodBeat.i(254789);
        if (this.wmb) {
            Log.i("Finder.FinderFeedAlbumView", str);
        }
        AppMethodBeat.o(254789);
    }
}
