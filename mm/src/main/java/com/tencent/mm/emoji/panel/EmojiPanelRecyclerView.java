package com.tencent.mm.emoji.panel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emoji.panel.a.z;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010=\u001a\u00020>2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030@J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020CH\u0016J\u0006\u0010D\u001a\u00020>J\u0006\u0010E\u001a\u00020>J\b\u0010F\u001a\u00020>H\u0014J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010H\u001a\u00020>H\u0002J\u0018\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\tH\u0014J(\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0014J\b\u0010Q\u001a\u00020>H\u0002J\u000e\u0010R\u001a\u00020>2\u0006\u0010S\u001a\u00020\tJ\b\u0010T\u001a\u00020>H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u000e\u0010<\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, hxF = {"Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "dispatchCancel", "", "enableLongPress", "getEnableLongPress", "()Z", "setEnableLongPress", "(Z)V", "longPressDelay", "", "longPressRunnable", "Ljava/lang/Runnable;", "longPressed", "panelLifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPanelLifeCycle", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "setPanelLifeCycle", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "parentRecycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "popupHelper", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "scene", "getScene", "()I", "setScene", "(I)V", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "touchX", "getTouchX", "()F", "setTouchX", "(F)V", "touchY", "getTouchY", "setTouchY", "touched", "bind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "emojiSearchGifPerformanceMode", "gifPerformanceMode", "onAttachedToWindow", "onInterceptTouchEvent", e.a.NAME, "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", e.C0599e.NAME, "setEmojiPopupType", "type", "updatePopView", "plugin-emojisdk_release"})
public class EmojiPanelRecyclerView extends RecyclerView {
    private final String TAG;
    private boolean gZT;
    private boolean gZU;
    private boolean gZV;
    private boolean gZW;
    private float gZX;
    private float gZY;
    private float gZZ;
    private float haa;
    private final long hab;
    private boolean hac;
    private final Runnable had;
    private EmojiPanelGroupView hae;
    public com.tencent.mm.view.popview.a haf;
    private com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> hag;
    private o hah;
    private final int rZ;
    private int scene;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiPanelRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(105610);
        this.TAG = "MicroMsg.EmojiPanelRecyclerView";
        this.hac = true;
        this.had = new c(this);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.hab = (long) ViewConfiguration.getLongPressTimeout();
        p.g(viewConfiguration, "config");
        this.rZ = viewConfiguration.getScaledTouchSlop();
        AppMethodBeat.o(105610);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmojiPanelRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(105611);
        AppMethodBeat.o(105611);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmojiPanelRecyclerView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(105612);
        AppMethodBeat.o(105612);
    }

    public final float getTouchX() {
        return this.gZZ;
    }

    public final void setTouchX(float f2) {
        this.gZZ = f2;
    }

    public final float getTouchY() {
        return this.haa;
    }

    public final void setTouchY(float f2) {
        this.haa = f2;
    }

    /* access modifiers changed from: protected */
    public final boolean getEnableLongPress() {
        return this.hac;
    }

    /* access modifiers changed from: protected */
    public final void setEnableLongPress(boolean z) {
        this.hac = z;
    }

    public final int getScene() {
        return this.scene;
    }

    public final void setScene(int i2) {
        this.scene = i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ EmojiPanelRecyclerView hai;

        c(EmojiPanelRecyclerView emojiPanelRecyclerView) {
            this.hai = emojiPanelRecyclerView;
        }

        public final void run() {
            AppMethodBeat.i(105601);
            EmojiPanelRecyclerView.a(this.hai);
            AppMethodBeat.o(105601);
        }
    }

    public final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> getPanelLifeCycle() {
        return this.hag;
    }

    public final void setPanelLifeCycle(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> bVar) {
        this.hag = bVar;
    }

    public final o getSizeResolver() {
        return this.hah;
    }

    public final void setSizeResolver(o oVar) {
        this.hah = oVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
    public static final class b extends RecyclerView.l {
        final /* synthetic */ EmojiPanelRecyclerView hai;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(199964);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(199964);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(EmojiPanelRecyclerView emojiPanelRecyclerView) {
            this.hai = emojiPanelRecyclerView;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int i3;
            AppMethodBeat.i(105600);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            switch (i2) {
                case 0:
                    if (this.hai.getAdapter() instanceof com.tencent.mm.search.d.a) {
                        RecyclerView.a adapter = this.hai.getAdapter();
                        if (adapter == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
                            AppMethodBeat.o(105600);
                            throw tVar;
                        }
                        ((com.tencent.mm.search.d.a) adapter).hbx = true;
                    }
                    RecyclerView.LayoutManager layoutManager = this.hai.getLayoutManager();
                    if (layoutManager != null) {
                        int ks = ((GridLayoutManager) layoutManager).ks();
                        RecyclerView.LayoutManager layoutManager2 = this.hai.getLayoutManager();
                        if (layoutManager2 != null) {
                            int ku = ((GridLayoutManager) layoutManager2).ku();
                            int i4 = 0;
                            ArrayList arrayList = new ArrayList();
                            for (int i5 = ks; i5 <= ku; i5++) {
                                if (i5 > 0 && (this.hai.getAdapter() instanceof com.tencent.mm.search.d.a)) {
                                    RecyclerView.a adapter2 = this.hai.getAdapter();
                                    if (adapter2 == null) {
                                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
                                        AppMethodBeat.o(105600);
                                        throw tVar2;
                                    } else if (((com.tencent.mm.search.d.a) adapter2).pm(i5) instanceof h) {
                                        RecyclerView.a adapter3 = this.hai.getAdapter();
                                        if (adapter3 == null) {
                                            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
                                            AppMethodBeat.o(105600);
                                            throw tVar3;
                                        }
                                        ac pm = ((com.tencent.mm.search.d.a) adapter3).pm(i5);
                                        if (pm == null) {
                                            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
                                            AppMethodBeat.o(105600);
                                            throw tVar4;
                                        }
                                        arrayList.add(((h) pm).gWm);
                                    }
                                }
                                if (this.hai.ch(i5) instanceof z) {
                                    int i6 = i4 + 1;
                                    RecyclerView.v ch = this.hai.ch(i5);
                                    if (ch == null) {
                                        t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
                                        AppMethodBeat.o(105600);
                                        throw tVar5;
                                    }
                                    com.tencent.f.h.RTc.n(new a((z) ch), ((long) i6) / 2);
                                    i3 = i6;
                                } else {
                                    i3 = i4;
                                }
                                i4 = i3;
                            }
                            if (this.hai.getScene() == 1) {
                                int i7 = ks != 0 ? ks - 1 : ks;
                                com.tencent.mm.search.c.b bVar2 = com.tencent.mm.search.c.b.NJx;
                                com.tencent.mm.search.c.b.b(arrayList, (long) (i7 + arrayList.size()));
                                break;
                            }
                        } else {
                            t tVar6 = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                            AppMethodBeat.o(105600);
                            throw tVar6;
                        }
                    } else {
                        t tVar7 = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                        AppMethodBeat.o(105600);
                        throw tVar7;
                    }
                    break;
                case 1:
                case 2:
                    if (this.hai.getAdapter() instanceof com.tencent.mm.search.d.a) {
                        RecyclerView.a adapter4 = this.hai.getAdapter();
                        if (adapter4 == null) {
                            t tVar8 = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
                            AppMethodBeat.o(105600);
                            throw tVar8;
                        } else if (((com.tencent.mm.search.d.a) adapter4).hbx) {
                            RecyclerView.a adapter5 = this.hai.getAdapter();
                            if (adapter5 != null) {
                                ((com.tencent.mm.search.d.a) adapter5).hbx = false;
                                RecyclerView.LayoutManager layoutManager3 = this.hai.getLayoutManager();
                                if (layoutManager3 != null) {
                                    RecyclerView.LayoutManager layoutManager4 = this.hai.getLayoutManager();
                                    if (layoutManager4 != null) {
                                        int ku2 = ((GridLayoutManager) layoutManager4).ku();
                                        for (int ks2 = ((GridLayoutManager) layoutManager3).ks(); ks2 <= ku2; ks2++) {
                                            if (this.hai.ch(ks2) instanceof z) {
                                                RecyclerView.v ch2 = this.hai.ch(ks2);
                                                if (ch2 == null) {
                                                    t tVar9 = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
                                                    AppMethodBeat.o(105600);
                                                    throw tVar9;
                                                }
                                                ((z) ch2).hbu.pause();
                                            }
                                        }
                                        break;
                                    } else {
                                        t tVar10 = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                                        AppMethodBeat.o(105600);
                                        throw tVar10;
                                    }
                                } else {
                                    t tVar11 = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                                    AppMethodBeat.o(105600);
                                    throw tVar11;
                                }
                            } else {
                                t tVar12 = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
                                AppMethodBeat.o(105600);
                                throw tVar12;
                            }
                        }
                    }
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(105600);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ z haj;

            a(z zVar) {
                this.haj = zVar;
            }

            public final void run() {
                AppMethodBeat.i(105599);
                this.haj.avV();
                AppMethodBeat.o(105599);
            }
        }
    }

    public final void avQ() {
        AppMethodBeat.i(105602);
        a(new b(this));
        AppMethodBeat.o(105602);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
    public static final class a extends RecyclerView.l {
        final /* synthetic */ EmojiPanelRecyclerView hai;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(199963);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(199963);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(EmojiPanelRecyclerView emojiPanelRecyclerView) {
            this.hai = emojiPanelRecyclerView;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int i3;
            AppMethodBeat.i(199962);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            Util.hideVKB(recyclerView);
            switch (i2) {
                case 0:
                    if (this.hai.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a) {
                        RecyclerView.a adapter = this.hai.getAdapter();
                        if (adapter == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
                            AppMethodBeat.o(199962);
                            throw tVar;
                        }
                        ((com.tencent.mm.plugin.emoji.ui.a) adapter).hbx = true;
                    }
                    RecyclerView.LayoutManager layoutManager = this.hai.getLayoutManager();
                    if (layoutManager != null) {
                        int ks = ((GridLayoutManager) layoutManager).ks();
                        RecyclerView.LayoutManager layoutManager2 = this.hai.getLayoutManager();
                        if (layoutManager2 != null) {
                            int ku = ((GridLayoutManager) layoutManager2).ku();
                            ArrayList arrayList = new ArrayList();
                            int i4 = 0;
                            for (int i5 = ks; i5 <= ku; i5++) {
                                if (i5 > 0 && (this.hai.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a)) {
                                    RecyclerView.a adapter2 = this.hai.getAdapter();
                                    if (adapter2 == null) {
                                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
                                        AppMethodBeat.o(199962);
                                        throw tVar2;
                                    } else if (((com.tencent.mm.plugin.emoji.ui.a) adapter2).pm(i5) instanceof h) {
                                        RecyclerView.a adapter3 = this.hai.getAdapter();
                                        if (adapter3 == null) {
                                            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
                                            AppMethodBeat.o(199962);
                                            throw tVar3;
                                        }
                                        ac pm = ((com.tencent.mm.plugin.emoji.ui.a) adapter3).pm(i5);
                                        if (pm == null) {
                                            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
                                            AppMethodBeat.o(199962);
                                            throw tVar4;
                                        }
                                        arrayList.add(((h) pm).gWm);
                                    }
                                }
                                if (this.hai.ch(i5) instanceof z) {
                                    int i6 = i4 + 1;
                                    RecyclerView.v ch = this.hai.ch(i5);
                                    if (ch == null) {
                                        t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
                                        AppMethodBeat.o(199962);
                                        throw tVar5;
                                    }
                                    com.tencent.f.h.RTc.n(new RunnableC0330a((z) ch), ((long) i6) / 2);
                                    i3 = i6;
                                } else {
                                    i3 = i4;
                                }
                                i4 = i3;
                            }
                            if (this.hai.getScene() == 2) {
                                int i7 = ks != 0 ? ks - 1 : ks;
                                com.tencent.mm.emojisearch.d.a aVar = com.tencent.mm.emojisearch.d.a.hew;
                                com.tencent.mm.emojisearch.d.a.b(arrayList, arrayList.size(), i7 + arrayList.size());
                                break;
                            }
                        } else {
                            t tVar6 = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                            AppMethodBeat.o(199962);
                            throw tVar6;
                        }
                    } else {
                        t tVar7 = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                        AppMethodBeat.o(199962);
                        throw tVar7;
                    }
                    break;
                case 1:
                case 2:
                    if (this.hai.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a) {
                        RecyclerView.a adapter4 = this.hai.getAdapter();
                        if (adapter4 == null) {
                            t tVar8 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
                            AppMethodBeat.o(199962);
                            throw tVar8;
                        } else if (((com.tencent.mm.plugin.emoji.ui.a) adapter4).hbx) {
                            RecyclerView.a adapter5 = this.hai.getAdapter();
                            if (adapter5 != null) {
                                ((com.tencent.mm.plugin.emoji.ui.a) adapter5).hbx = false;
                                RecyclerView.LayoutManager layoutManager3 = this.hai.getLayoutManager();
                                if (layoutManager3 != null) {
                                    RecyclerView.LayoutManager layoutManager4 = this.hai.getLayoutManager();
                                    if (layoutManager4 != null) {
                                        int ku2 = ((GridLayoutManager) layoutManager4).ku();
                                        for (int ks2 = ((GridLayoutManager) layoutManager3).ks(); ks2 <= ku2; ks2++) {
                                            if (this.hai.ch(ks2) instanceof z) {
                                                RecyclerView.v ch2 = this.hai.ch(ks2);
                                                if (ch2 == null) {
                                                    t tVar9 = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
                                                    AppMethodBeat.o(199962);
                                                    throw tVar9;
                                                }
                                                ((z) ch2).hbu.pause();
                                            }
                                        }
                                        break;
                                    } else {
                                        t tVar10 = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                                        AppMethodBeat.o(199962);
                                        throw tVar10;
                                    }
                                } else {
                                    t tVar11 = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                                    AppMethodBeat.o(199962);
                                    throw tVar11;
                                }
                            } else {
                                t tVar12 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
                                AppMethodBeat.o(199962);
                                throw tVar12;
                            }
                        }
                    }
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(199962);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.emoji.panel.EmojiPanelRecyclerView$a$a  reason: collision with other inner class name */
        static final class RunnableC0330a implements Runnable {
            final /* synthetic */ z haj;

            RunnableC0330a(z zVar) {
                this.haj = zVar;
            }

            public final void run() {
                AppMethodBeat.i(199961);
                this.haj.avV();
                AppMethodBeat.o(199961);
            }
        }
    }

    public final void setEmojiPopupType(int i2) {
        AppMethodBeat.i(183958);
        Context context = getContext();
        p.g(context, "context");
        this.haf = new com.tencent.mm.view.popview.b(context, i2);
        AppMethodBeat.o(183958);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(105603);
        super.onSizeChanged(i2, i3, i4, i5);
        o oVar = this.hah;
        if (oVar != null) {
            oVar.pn(i2);
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (!(layoutManager instanceof GridLayoutManager)) {
                layoutManager = null;
            }
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            if (gridLayoutManager != null) {
                gridLayoutManager.bW(oVar.att);
            }
            setPadding(oVar.hbe, getPaddingTop(), oVar.hbe, getPaddingBottom());
            AppMethodBeat.o(105603);
            return;
        }
        AppMethodBeat.o(105603);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(105604);
        o oVar = this.hah;
        if (oVar != null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (!(layoutManager instanceof GridLayoutManager)) {
                layoutManager = null;
            }
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            if (gridLayoutManager != null) {
                gridLayoutManager.bW(oVar.att);
            }
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(105604);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View o;
        com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> bVar;
        AppMethodBeat.i(105605);
        p.h(motionEvent, "event");
        if (!this.hac) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(105605);
            return dispatchTouchEvent;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.gZT = true;
                this.gZV = false;
                this.gZU = false;
                this.gZW = false;
                this.gZX = motionEvent.getX();
                this.gZY = motionEvent.getY();
                this.gZZ = motionEvent.getX();
                this.haa = motionEvent.getY();
                if (this.hac) {
                    postDelayed(this.had, this.hab);
                    break;
                }
                break;
            case 1:
            case 3:
                this.gZT = false;
                this.gZU = false;
                break;
            case 2:
                this.gZZ = motionEvent.getX();
                this.haa = motionEvent.getY();
                if (this.gZT && !this.gZU && (Math.abs(this.gZX - motionEvent.getX()) > ((float) this.rZ) || Math.abs(this.gZY - motionEvent.getY()) > ((float) this.rZ))) {
                    this.gZU = true;
                    if (!this.gZV) {
                        removeCallbacks(this.had);
                        break;
                    }
                }
                break;
        }
        if (this.gZV && !this.gZW) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            p.g(obtain, "cancelEvent");
            obtain.setAction(3);
            super.dispatchTouchEvent(obtain);
            obtain.recycle();
            this.gZW = true;
        }
        if (motionEvent.getActionMasked() == 3 || motionEvent.getActionMasked() == 1) {
            removeCallbacks(this.had);
            this.gZV = false;
            EmojiPanelGroupView emojiPanelGroupView = this.hae;
            if (emojiPanelGroupView != null) {
                emojiPanelGroupView.setScrollEnable(true);
            }
            com.tencent.mm.view.popview.a aVar = this.haf;
            if (aVar != null) {
                aVar.fdM();
            }
            com.tencent.mm.view.popview.a aVar2 = this.haf;
            if (!(aVar2 instanceof com.tencent.mm.vending.e.a)) {
                aVar2 = null;
            }
            com.tencent.mm.vending.e.a aVar3 = (com.tencent.mm.vending.e.a) aVar2;
            if (!(aVar3 == null || (bVar = this.hag) == null)) {
                bVar.keep(aVar3);
            }
        }
        if (this.gZV) {
            Log.i(this.TAG, "updatePopView: " + this.gZZ + ", " + this.haa);
            EmojiPanelGroupView emojiPanelGroupView2 = this.hae;
            if (emojiPanelGroupView2 != null) {
                emojiPanelGroupView2.setScrollEnable(false);
            }
            RecyclerView.a adapter = getAdapter();
            if (!(adapter instanceof com.tencent.mm.emoji.panel.a.h)) {
                adapter = null;
            }
            com.tencent.mm.emoji.panel.a.h hVar = (com.tencent.mm.emoji.panel.a.h) adapter;
            if (!(hVar == null || (o = o(this.gZZ, this.haa)) == null)) {
                p.g(o, "findChildViewUnder(touchX, touchY) ?: return");
                int bw = bw(o);
                com.tencent.mm.emoji.c.e eVar = com.tencent.mm.emoji.c.e.hcl;
                com.tencent.mm.emoji.c.e.awe().jV(bw);
                ac pm = hVar.pm(bw);
                com.tencent.mm.view.popview.a aVar4 = this.haf;
                if (aVar4 != null) {
                    aVar4.d(o, pm);
                }
            }
            AppMethodBeat.o(105605);
            return true;
        }
        boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(105605);
        return dispatchTouchEvent2;
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(105606);
        p.h(motionEvent, "event");
        if (this.gZV) {
            AppMethodBeat.o(105606);
            return true;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(105606);
        return onInterceptTouchEvent;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onAttachedToWindow() {
        AppMethodBeat.i(105607);
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof EmojiPanelGroupView) {
                this.hae = (EmojiPanelGroupView) parent;
                AppMethodBeat.o(105607);
                return;
            }
        }
        AppMethodBeat.o(105607);
    }

    public static final /* synthetic */ void a(EmojiPanelRecyclerView emojiPanelRecyclerView) {
        EmojiPanelGroupView emojiPanelGroupView;
        AppMethodBeat.i(183959);
        if (!emojiPanelRecyclerView.gZU) {
            RecyclerView.a adapter = emojiPanelRecyclerView.getAdapter();
            if (!(adapter instanceof com.tencent.mm.emoji.panel.a.h)) {
                adapter = null;
            }
            com.tencent.mm.emoji.panel.a.h hVar = (com.tencent.mm.emoji.panel.a.h) adapter;
            if (hVar == null) {
                AppMethodBeat.o(183959);
                return;
            }
            View o = emojiPanelRecyclerView.o(emojiPanelRecyclerView.gZZ, emojiPanelRecyclerView.haa);
            if (o == null) {
                AppMethodBeat.o(183959);
                return;
            }
            p.g(o, "findChildViewUnder(touchX, touchY) ?: return");
            int bw = bw(o);
            com.tencent.mm.emoji.c.e eVar = com.tencent.mm.emoji.c.e.hcl;
            com.tencent.mm.emoji.c.e.awe().jV(bw);
            ac pm = hVar.pm(bw);
            com.tencent.mm.view.popview.a aVar = emojiPanelRecyclerView.haf;
            emojiPanelRecyclerView.gZV = aVar != null && aVar.c(o, pm);
            if (emojiPanelRecyclerView.gZV && (emojiPanelGroupView = emojiPanelRecyclerView.hae) != null) {
                emojiPanelGroupView.setScrollEnable(false);
            }
            Log.i(emojiPanelRecyclerView.TAG, "long press: " + emojiPanelRecyclerView.gZV);
        }
        AppMethodBeat.o(183959);
    }
}
