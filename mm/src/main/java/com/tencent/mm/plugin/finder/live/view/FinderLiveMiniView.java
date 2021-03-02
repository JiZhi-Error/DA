package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.d.a;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.mini.d;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\tH\u0016J\u0006\u0010\u0015\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0018\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeBtn", "Landroid/widget/ImageView;", "closeGroup", "Landroid/widget/RelativeLayout;", "isAnchor", "", "stateIv", "stateTv", "Landroid/widget/TextView;", "floatScene", "inAnchorMode", "setupClickListener", "", "clickListener", "Landroid/view/View$OnClickListener;", "closeClickListener", "setupMiniView", "anchorUsername", "", "updateState", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "plugin-finder_release"})
public final class FinderLiveMiniView extends AbsLiveMiniView {
    public boolean dMz;
    private final ImageView hTd;
    private final TextView uzB;
    private final ImageView uzC;
    private final RelativeLayout uzD;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n¨\u0006\f"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/live/view/FinderLiveMiniView$setupMiniView$1$1$1", "com/tencent/mm/plugin/finder/live/view/FinderLiveMiniView$$special$$inlined$let$lambda$1"})
    public static final class a<T, R> implements e<o, Bitmap> {
        final /* synthetic */ FinderLiveMiniView uzE;

        a(FinderLiveMiniView finderLiveMiniView) {
            this.uzE = finderLiveMiniView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, g gVar, Bitmap bitmap) {
            AppMethodBeat.i(247527);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                a.C0373a aVar2 = com.tencent.mm.live.b.d.a.hLg;
                Context context = this.uzE.getContext();
                p.g(context, "context");
                a.C0373a.a(bitmap2, context.getResources().getColor(R.color.xg), new b<Bitmap, x>(this) {
                    /* class com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView.a.AnonymousClass1 */
                    final /* synthetic */ a uzF;

                    {
                        this.uzF = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(Bitmap bitmap) {
                        AppMethodBeat.i(247526);
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            ImageView imageView = this.uzF.uzE.uzC;
                            Context context = this.uzF.uzE.getContext();
                            p.g(context, "context");
                            imageView.setImageDrawable(new BitmapDrawable(context.getResources(), bitmap2));
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(247526);
                        return xVar;
                    }
                });
                AppMethodBeat.o(247527);
                return;
            }
            AppMethodBeat.o(247527);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveMiniView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(247531);
        View.inflate(context, R.layout.aey, this);
        View findViewById = findViewById(R.id.cvt);
        p.g(findViewById, "findViewById(R.id.finder_live_mini_view_close_btn)");
        this.hTd = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.cvw);
        p.g(findViewById2, "findViewById(R.id.finder_live_mini_view_state_tv)");
        this.uzB = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.cvv);
        p.g(findViewById3, "findViewById(R.id.finder_live_mini_view_state_iv)");
        this.uzC = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.cvu);
        p.g(findViewById4, "findViewById(R.id.finder…ve_mini_view_close_group)");
        this.uzD = (RelativeLayout) findViewById4;
        this.uzC.setClipToOutline(true);
        this.uzC.setOutlineProvider(new com.tencent.mm.live.core.mini.e((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
        this.uzC.setVisibility(8);
        this.uzB.setVisibility(8);
        AppMethodBeat.o(247531);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveMiniView(Context context) {
        this(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(247532);
        AppMethodBeat.o(247532);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveMiniView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(247533);
        AppMethodBeat.o(247533);
    }

    public final void bi(String str, boolean z) {
        com.tencent.mm.plugin.finder.api.g gVar;
        AppMethodBeat.i(247528);
        this.dMz = z;
        if (z) {
            this.uzD.setVisibility(8);
        }
        if (str != null) {
            c.a aVar = c.tsp;
            gVar = c.a.asG(str);
        } else {
            gVar = null;
        }
        if (gVar != null) {
            String str2 = gVar.field_avatarUrl;
            if (str2 != null) {
                m mVar = m.uJa;
                m.djY().bQ(new com.tencent.mm.plugin.finder.loader.a(str2)).a(new a(this)).vC();
                AppMethodBeat.o(247528);
                return;
            }
            AppMethodBeat.o(247528);
            return;
        }
        AppMethodBeat.o(247528);
    }

    public final void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        AppMethodBeat.i(247529);
        p.h(onClickListener, "clickListener");
        p.h(onClickListener2, "closeClickListener");
        setOnClickListener(onClickListener);
        this.hTd.setOnClickListener(onClickListener2);
        AppMethodBeat.o(247529);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.core.mini.AbsLiveMiniView
    public final void b(d dVar) {
        AppMethodBeat.i(247530);
        p.h(dVar, "state");
        switch (g.$EnumSwitchMapping$0[dVar.ordinal()]) {
            case 1:
                this.uzC.setVisibility(8);
                this.uzB.setVisibility(8);
                AppMethodBeat.o(247530);
                return;
            case 2:
                TextView textView = this.uzB;
                Context context = getContext();
                p.g(context, "context");
                textView.setText(context.getResources().getString(R.string.ehd));
                this.uzC.setVisibility(0);
                this.uzB.setVisibility(0);
                AppMethodBeat.o(247530);
                return;
            case 3:
                TextView textView2 = this.uzB;
                Context context2 = getContext();
                p.g(context2, "context");
                textView2.setText(context2.getResources().getString(R.string.ehe));
                this.uzC.setVisibility(0);
                this.uzB.setVisibility(0);
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    p.g(childAt, LocaleUtil.ITALIAN);
                    if (!(childAt.getId() != R.id.cvs)) {
                        childAt = null;
                    }
                    if (childAt != null) {
                        childAt.getVisibility();
                    }
                }
                break;
        }
        AppMethodBeat.o(247530);
    }

    @Override // com.tencent.mm.live.core.mini.AbsLiveMiniView
    public final int aEg() {
        return 15;
    }
}
