package com.tencent.mm.plugin.festival.finder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.ImageView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.model.a.e;
import com.tencent.mm.plugin.festival.model.ab;
import com.tencent.mm.plugin.festival.model.ag;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u001c\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFuBagPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/festival/model/IForbiddenCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "festivalFuBagIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getFestivalFuBagIv", "()Landroid/widget/ImageView;", "festivalFuBagIvTouchHitRect", "Landroid/graphics/Rect;", "canClearScreen", "", "checkShow", "", "getFlagBit", "", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onForbiddenChange", "isBitFlagSet", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-festival_release"})
public final class bk extends p implements ag {
    @Deprecated
    public static final a Uwr = new a((byte) 0);
    private final Rect Uwq = new Rect();
    private final com.tencent.mm.live.c.b hOp;

    static {
        AppMethodBeat.i(262812);
        AppMethodBeat.o(262812);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFuBagPlugin$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bk(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262811);
        this.hOp = bVar;
        ImageView gEZ = gEZ();
        p.g(gEZ, "festivalFuBagIv");
        ViewGroup.LayoutParams layoutParams = gEZ.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (!(layoutParams instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams);
        if (marginLayoutParams != null) {
            Context context = viewGroup.getContext();
            p.g(context, "root.context");
            marginLayoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.c9);
        }
        gEZ().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.bk.AnonymousClass1 */
            final /* synthetic */ bk Uws;

            {
                this.Uws = r1;
            }

            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                AppMethodBeat.i(262801);
                ImageView a2 = bk.a(this.Uws);
                p.g(a2, "festivalFuBagIv");
                ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams != null) {
                    p.g(windowInsets, "insets");
                    int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
                    Context context = viewGroup.getContext();
                    p.g(context, "root.context");
                    marginLayoutParams.bottomMargin = systemWindowInsetBottom + context.getResources().getDimensionPixelSize(R.dimen.ce);
                    bk.a(this.Uws).requestLayout();
                }
                AppMethodBeat.o(262801);
                return windowInsets;
            }
        });
        gEZ().addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.bk.AnonymousClass2 */
            final /* synthetic */ bk Uws;

            {
                this.Uws = r1;
            }

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(262802);
                Context context = viewGroup.getContext();
                p.g(context, "root.context");
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ct);
                this.Uws.Uwq.set(i2, i3, i4, i5);
                this.Uws.Uwq.left -= dimensionPixelSize;
                this.Uws.Uwq.right += dimensionPixelSize;
                this.Uws.Uwq.top -= dimensionPixelSize;
                Rect rect = this.Uws.Uwq;
                rect.bottom = dimensionPixelSize + rect.bottom;
                AppMethodBeat.o(262802);
            }
        });
        viewGroup.setTouchDelegate(new TouchDelegate(this.Uwq, gEZ()));
        AppMethodBeat.o(262811);
    }

    public static final /* synthetic */ ImageView a(bk bkVar) {
        AppMethodBeat.i(262813);
        ImageView gEZ = bkVar.gEZ();
        AppMethodBeat.o(262813);
        return gEZ;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final void Fe(boolean z) {
        AppMethodBeat.i(262806);
        Log.i("FestivalFuBagPlugin", "onForbiddenChange :".concat(String.valueOf(z)));
        if (z) {
            rg(8);
        }
        AppMethodBeat.o(262806);
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final int dCX() {
        return 16;
    }

    public final void fvk() {
        AppMethodBeat.i(262808);
        if (ab.UzG.hRN()) {
            ((ImageView) this.hwr.findViewById(R.id.juy)).setOnClickListener(new b(this));
            rg(0);
            AppMethodBeat.o(262808);
            return;
        }
        rg(8);
        AppMethodBeat.o(262808);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ bk Uws;

        b(bk bkVar) {
            this.Uws = bkVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262804);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFuBagPlugin$checkShow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Uws.getLiveData().uDS = false;
            ab abVar = ab.UzG;
            Context context = this.Uws.hwr.getContext();
            p.g(context, "root.context");
            p.h(context, "context");
            m.a aTe = new m.a().aSY("2021").aTb("wedraw@inner").aTc(abVar.hRJ()).aTd(abVar.hRH()).byo("").aTe(abVar.hRI());
            r rVar = new r();
            rVar.GaO = "4";
            rVar.GaQ = null;
            r rVar2 = new r();
            rVar2.GaO = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
            rVar2.GaQ = ab.UzF;
            ((i) g.af(i.class)).a((Activity) context, 546, aTe.hE(j.listOf((Object[]) new r[]{rVar, rVar2})).fvy().fvz());
            e eVar = e.UAo;
            e.hSf();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFuBagPlugin$checkShow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262804);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        Rect rect;
        int dimensionPixelSize;
        int i2;
        AppMethodBeat.i(262809);
        p.h(cVar, "status");
        switch (bl.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                fvk();
                AppMethodBeat.o(262809);
                return;
            case 2:
                if (bundle == null || (rect = (Rect) bundle.getParcelable("PARAM_FESTIVAL_FINDER_LIVE_WISH_BUTTON_LOCATION_RECT")) == null) {
                    AppMethodBeat.o(262809);
                    return;
                }
                p.g(rect, "param?.getParcelable<Rec…onLocationRect) ?: return");
                ImageView gEZ = gEZ();
                p.g(gEZ, "festivalFuBagIv");
                ViewGroup.LayoutParams layoutParams = gEZ.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams != null) {
                    bm bmVar = bm.Uwt;
                    Context context = this.hwr.getContext();
                    p.g(context, "root.context");
                    if (bm.hz(context)) {
                        Context context2 = this.hwr.getContext();
                        p.g(context2, "root.context");
                        dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.c5);
                    } else {
                        Context context3 = this.hwr.getContext();
                        p.g(context3, "root.context");
                        dimensionPixelSize = context3.getResources().getDimensionPixelSize(R.dimen.cb);
                    }
                    if (this.hwr.isLaidOut()) {
                        i2 = this.hwr.getWidth();
                    } else {
                        Context context4 = this.hwr.getContext();
                        p.g(context4, "root.context");
                        Resources resources = context4.getResources();
                        p.g(resources, "root.context.resources");
                        i2 = resources.getDisplayMetrics().widthPixels;
                    }
                    marginLayoutParams.rightMargin = i2 - (rect.left - dimensionPixelSize);
                    if (this.hwr.getVisibility() == 0) {
                        gEZ().requestLayout();
                    }
                    AppMethodBeat.o(262809);
                    return;
                }
                break;
        }
        AppMethodBeat.o(262809);
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(262810);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 546:
                getLiveData().uDS = true;
                if (i3 == -1) {
                    ab.UzG.hRO();
                }
                fvk();
                break;
        }
        AppMethodBeat.o(262810);
    }

    private final ImageView gEZ() {
        AppMethodBeat.i(262805);
        ImageView imageView = (ImageView) this.hwr.findViewById(R.id.juy);
        AppMethodBeat.o(262805);
        return imageView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025  */
    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void rg(int r7) {
        /*
            r6 = this;
            r5 = 262807(0x40297, float:3.68271E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            android.view.ViewGroup r0 = r6.hwr
            int r0 = r0.getVisibility()
            if (r7 != 0) goto L_0x0042
            com.tencent.mm.plugin.festival.model.t r1 = com.tencent.mm.plugin.festival.model.t.UyR
            r1 = 16
            boolean r1 = com.tencent.mm.plugin.festival.model.t.awC(r1)
            if (r1 == 0) goto L_0x0042
            r1 = 8
            super.rg(r1)
        L_0x001d:
            android.view.ViewGroup r1 = r6.hwr
            int r1 = r1.getVisibility()
            if (r1 == r0) goto L_0x003e
            com.tencent.mm.live.c.b r0 = r6.hOp
            com.tencent.mm.live.c.b$c r1 = com.tencent.mm.live.c.b.c.zgj
            android.os.Bundle r2 = new android.os.Bundle
            r3 = 1
            r2.<init>(r3)
            java.lang.String r3 = "PARAM_FESTIVAL_FINDER_LIVE_FU_BAG_VISIBILITY"
            android.view.ViewGroup r4 = r6.hwr
            int r4 = r4.getVisibility()
            r2.putInt(r3, r4)
            r0.statusChange(r1, r2)
        L_0x003e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return
        L_0x0042:
            super.rg(r7)
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.bk.rg(int):void");
    }
}
