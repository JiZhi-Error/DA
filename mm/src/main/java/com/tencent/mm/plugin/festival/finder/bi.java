package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.c.j;
import com.tencent.mm.plugin.festival.model.ab;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0019H\u0016J\u001a\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderWishBtnPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "button", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "enabled", "", "isEnabled", "()Z", "setEnabled", "(Z)V", "canClearScreen", "keyboardChange", "", "show", "height", "", "mount", "pause", "resetButtonPosition", "isFuBagVisible", "resume", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "WishButtonBackgroundDrawable", "plugin-festival_release"})
public final class bi extends p {
    public static final a Uwj = new a((byte) 0);
    private final TextView QVH;
    private boolean Uwi = true;
    private final com.tencent.mm.live.c.b hOp;

    static {
        AppMethodBeat.i(262794);
        AppMethodBeat.o(262794);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bi(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262793);
        this.hOp = bVar;
        this.QVH = (TextView) viewGroup.findViewById(R.id.jvg);
        AppMethodBeat.o(262793);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderWishBtnPlugin$Companion;", "", "()V", "WISH_IMAGE_SPAN_SIZE_FACTOR", "", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void setEnabled(boolean z) {
        AppMethodBeat.i(262784);
        this.Uwi = z;
        if (z) {
            this.hwr.setEnabled(true);
            this.QVH.setShadowLayer((float) com.tencent.mm.cb.a.fromDPToPix(this.hwr.getContext(), 6), 0.0f, 0.0f, android.support.v4.content.b.n(this.hwr.getContext(), R.color.agk));
            TextView textView = this.QVH;
            p.g(textView, "button");
            textView.setAlpha(1.0f);
            AppMethodBeat.o(262784);
            return;
        }
        this.hwr.setEnabled(false);
        this.QVH.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        TextView textView2 = this.QVH;
        p.g(textView2, "button");
        textView2.setAlpha(0.3f);
        AppMethodBeat.o(262784);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(262785);
        super.mount();
        TextView textView = this.QVH;
        Context context = textView.getContext();
        p.g(context, "context");
        Drawable mutate = com.tencent.mm.svg.a.a.h(context.getResources(), R.raw.icons_filled_star2021).mutate();
        TextView textView2 = this.QVH;
        p.g(textView2, "button");
        int cR = kotlin.h.a.cR(textView2.getTextSize() * 1.1f);
        mutate.setBounds(0, 0, cR, cR);
        p.g(mutate, "SVGCompat.getSVGDrawable…anSize)\n                }");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("i " + textView.getContext().getString(R.string.j8r));
        spannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.a(mutate, 1), 0, 1, 18);
        TextView textView3 = this.QVH;
        p.g(textView3, "button");
        textView3.setText(spannableStringBuilder);
        TextView textView4 = this.QVH;
        p.g(textView4, "button");
        Context context2 = textView.getContext();
        p.g(context2, "context");
        textView4.setBackground(new b(context2));
        this.QVH.setOnClickListener(new c(textView, this));
        TextView textView5 = this.QVH;
        Paint paint = new Paint(1);
        paint.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
        textView5.setLayerType(1, paint);
        textView.setOnApplyWindowInsetsListener(new e(textView));
        Fk(false);
        textView.addOnLayoutChangeListener(new d(this));
        setEnabled(ab.UzG.hRL());
        AppMethodBeat.o(262785);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/festival/finder/FestivalFinderWishBtnPlugin$mount$1$1"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ TextView Uwk;
        final /* synthetic */ bi Uwl;

        c(TextView textView, bi biVar) {
            this.Uwk = textView;
            this.Uwl = biVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262781);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderWishBtnPlugin$mount$$inlined$with$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!ab.UzG.hRL()) {
                u.cH(this.Uwk.getContext(), this.Uwk.getContext().getString(R.string.j8n));
            } else {
                b.C0376b.a(this.Uwl.hOp, b.c.wlN);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderWishBtnPlugin$mount$$inlined$with$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262781);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Landroid/view/WindowInsets;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Landroid/view/View;", "insets", "onApplyWindowInsets"})
    static final class e implements View.OnApplyWindowInsetsListener {
        final /* synthetic */ TextView Uwk;

        e(TextView textView) {
            this.Uwk = textView;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            AppMethodBeat.i(262783);
            ViewGroup.LayoutParams layoutParams = this.Uwk.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                p.g(windowInsets, "insets");
                int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
                Context context = this.Uwk.getContext();
                p.g(context, "context");
                marginLayoutParams.bottomMargin = systemWindowInsetBottom + context.getResources().getDimensionPixelSize(R.dimen.ce);
                this.Uwk.requestLayout();
            }
            AppMethodBeat.o(262783);
            return windowInsets;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\t\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e¨\u0006\u000f"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange", "com/tencent/mm/plugin/festival/finder/FestivalFinderWishBtnPlugin$mount$1$4"})
    static final class d implements View.OnLayoutChangeListener {
        final /* synthetic */ bi Uwl;

        d(bi biVar) {
            this.Uwl = biVar;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(262782);
            com.tencent.mm.live.c.b bVar = this.Uwl.hOp;
            b.c cVar = b.c.zgk;
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_WISH_BUTTON_LOCATION_RECT", new Rect(i2, i3, i4, i5));
            bVar.statusChange(cVar, bundle);
            AppMethodBeat.o(262782);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void Fk(boolean r7) {
        /*
        // Method dump skipped, instructions count: 176
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.bi.Fk(boolean):void");
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262787);
        super.unMount();
        ViewGroup viewGroup = this.hwr;
        if (viewGroup == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.finder.FestivalWishButtonContainerLayout");
            AppMethodBeat.o(262787);
            throw tVar;
        }
        FestivalWishButtonContainerLayout festivalWishButtonContainerLayout = (FestivalWishButtonContainerLayout) viewGroup;
        if (festivalWishButtonContainerLayout.Uxh != null) {
            List<Bitmap> list = festivalWishButtonContainerLayout.Uxh;
            if (list == null) {
                p.btv("frameBitmapList");
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                j jVar = j.UGJ;
                j.aQ(it.next());
            }
            List<Bitmap> list2 = festivalWishButtonContainerLayout.Uxh;
            if (list2 == null) {
                p.btv("frameBitmapList");
            }
            if (list2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.util.ArrayList<android.graphics.Bitmap>");
                AppMethodBeat.o(262787);
                throw tVar2;
            }
            ((ArrayList) list2).clear();
        }
        if (festivalWishButtonContainerLayout.Uxk != null) {
            j jVar2 = j.UGJ;
            Bitmap bitmap = festivalWishButtonContainerLayout.Uxk;
            if (bitmap == null) {
                p.btv("rotateBitmap");
            }
            j.aQ(bitmap);
        }
        AppMethodBeat.o(262787);
    }

    @Override // com.tencent.mm.live.c.a
    public final void keyboardChange(boolean z, int i2) {
        AppMethodBeat.i(262788);
        if (z) {
            rg(8);
        }
        AppMethodBeat.o(262788);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(262789);
        super.rg(i2);
        ViewGroup viewGroup = this.hwr;
        if (viewGroup == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.finder.FestivalWishButtonContainerLayout");
            AppMethodBeat.o(262789);
            throw tVar;
        }
        ((FestivalWishButtonContainerLayout) viewGroup).setEffectPaused(((FestivalWishButtonContainerLayout) this.hwr).getVisibility() != 0);
        AppMethodBeat.o(262789);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(262790);
        p.h(cVar, "status");
        switch (bj.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                rg(0);
                setEnabled(ab.UzG.hRL());
                if (this.Uwi) {
                    ViewGroup viewGroup = this.hwr;
                    if (viewGroup == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.finder.FestivalWishButtonContainerLayout");
                        AppMethodBeat.o(262790);
                        throw tVar;
                    }
                    ((FestivalWishButtonContainerLayout) viewGroup).setEffectPaused(false);
                    AppMethodBeat.o(262790);
                    return;
                }
                break;
            case 2:
                ViewGroup viewGroup2 = this.hwr;
                if (viewGroup2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.finder.FestivalWishButtonContainerLayout");
                    AppMethodBeat.o(262790);
                    throw tVar2;
                }
                ((FestivalWishButtonContainerLayout) viewGroup2).setEffectPaused(true);
                AppMethodBeat.o(262790);
                return;
            case 3:
                if (bundle != null) {
                    z2 = bundle.getBoolean("PARAM_IS_ENTERING_COMMENT");
                } else {
                    z2 = false;
                }
                if (z2) {
                    rg(8);
                    AppMethodBeat.o(262790);
                    return;
                }
                rg(0);
                AppMethodBeat.o(262790);
                return;
            case 4:
                if (bundle != null) {
                    if (bundle.containsKey("PARAM_FESTIVAL_FINDER_LIVE_FU_BAG_VISIBILITY")) {
                        if (bundle.getInt("PARAM_FESTIVAL_FINDER_LIVE_FU_BAG_VISIBILITY") == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Fk(z);
                        break;
                    }
                } else {
                    AppMethodBeat.o(262790);
                    return;
                }
                break;
        }
        AppMethodBeat.o(262790);
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(262791);
        super.resume();
        if (this.hwr.getVisibility() == 0) {
            ViewGroup viewGroup = this.hwr;
            if (viewGroup == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.finder.FestivalWishButtonContainerLayout");
                AppMethodBeat.o(262791);
                throw tVar;
            }
            ((FestivalWishButtonContainerLayout) viewGroup).setEffectPaused(false);
        }
        AppMethodBeat.o(262791);
    }

    @Override // com.tencent.mm.live.c.a
    public final void pause() {
        AppMethodBeat.i(262792);
        super.pause();
        ViewGroup viewGroup = this.hwr;
        if (viewGroup == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.finder.FestivalWishButtonContainerLayout");
            AppMethodBeat.o(262792);
            throw tVar;
        }
        ((FestivalWishButtonContainerLayout) viewGroup).setEffectPaused(true);
        AppMethodBeat.o(262792);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderWishBtnPlugin$WishButtonBackgroundDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "paint", "Landroid/graphics/Paint;", "radius", "", "rectF", "Landroid/graphics/RectF;", "strokeWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-festival_release"})
    static final class b extends Drawable {
        private final RectF hO = new RectF();
        private final Paint paint;
        private float radius;
        private final float strokeWidth;

        public b(Context context) {
            p.h(context, "context");
            AppMethodBeat.i(262780);
            this.strokeWidth = (float) com.tencent.mm.cb.a.fromDPToPix(context, 1.5f);
            Paint paint2 = new Paint(1);
            paint2.setColor(-1);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(this.strokeWidth);
            this.paint = paint2;
            AppMethodBeat.o(262780);
        }

        /* access modifiers changed from: protected */
        public final void onBoundsChange(Rect rect) {
            AppMethodBeat.i(262778);
            p.h(rect, "bounds");
            this.radius = ((float) rect.height()) / 2.0f;
            if (this.radius > 0.0f) {
                this.hO.set(rect);
                float f2 = this.strokeWidth / 2.0f;
                this.hO.left += f2;
                this.hO.top += f2;
                this.hO.right -= f2;
                this.hO.bottom -= f2;
            }
            AppMethodBeat.o(262778);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(262779);
            p.h(canvas, "canvas");
            if (this.radius > 0.0f && this.hO.height() > 0.0f && this.hO.width() > 0.0f) {
                canvas.drawRoundRect(this.hO, this.radius, this.radius, this.paint);
            }
            AppMethodBeat.o(262779);
        }

        public final void setAlpha(int i2) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -3;
        }
    }
}
