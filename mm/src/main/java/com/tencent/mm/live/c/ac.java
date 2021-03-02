package com.tencent.mm.live.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.d.f;
import com.tencent.mm.particles.c;
import com.tencent.mm.particles.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "emitLikeConfetti", "", "x", "", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ac extends a {
    private final String TAG = "MicroMsg.LiveLikeConfettiPlugin";
    private final b hOp;
    private final FrameLayout hRf;
    private c hRg;
    private final ArrayList<Bitmap> hRh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ac(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208080);
        this.hOp = bVar;
        this.hRf = (FrameLayout) viewGroup.findViewById(R.id.ehv);
        this.hRh = new ArrayList<>();
        AppMethodBeat.o(208080);
    }

    public final void a(LiveConfig liveConfig) {
        AppMethodBeat.i(208078);
        p.h(liveConfig, "config");
        b.a aVar = b.hyv;
        if (b.a.aDp()) {
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.bsu);
            o.b bVar = o.b.hGo;
            int aFl = o.b.aFl();
            o.b bVar2 = o.b.hGo;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, aFl, o.b.aFl(), true);
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            Bitmap decodeResource2 = BitmapFactory.decodeResource(context2.getResources(), R.drawable.bsv);
            o.b bVar3 = o.b.hGo;
            int aFl2 = o.b.aFl();
            o.b bVar4 = o.b.hGo;
            Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeResource2, aFl2, o.b.aFl(), true);
            Context context3 = this.hwr.getContext();
            p.g(context3, "root.context");
            Bitmap decodeResource3 = BitmapFactory.decodeResource(context3.getResources(), R.drawable.bsw);
            o.b bVar5 = o.b.hGo;
            int aFl3 = o.b.aFl();
            o.b bVar6 = o.b.hGo;
            Bitmap createScaledBitmap3 = Bitmap.createScaledBitmap(decodeResource3, aFl3, o.b.aFl(), true);
            Context context4 = this.hwr.getContext();
            p.g(context4, "root.context");
            Bitmap decodeResource4 = BitmapFactory.decodeResource(context4.getResources(), R.drawable.bsx);
            o.b bVar7 = o.b.hGo;
            int aFl4 = o.b.aFl();
            o.b bVar8 = o.b.hGo;
            Bitmap createScaledBitmap4 = Bitmap.createScaledBitmap(decodeResource4, aFl4, o.b.aFl(), true);
            Context context5 = this.hwr.getContext();
            p.g(context5, "root.context");
            Bitmap decodeResource5 = BitmapFactory.decodeResource(context5.getResources(), R.drawable.bsy);
            o.b bVar9 = o.b.hGo;
            int aFl5 = o.b.aFl();
            o.b bVar10 = o.b.hGo;
            Bitmap createScaledBitmap5 = Bitmap.createScaledBitmap(decodeResource5, aFl5, o.b.aFl(), true);
            Context context6 = this.hwr.getContext();
            p.g(context6, "root.context");
            Bitmap decodeResource6 = BitmapFactory.decodeResource(context6.getResources(), R.drawable.bsz);
            o.b bVar11 = o.b.hGo;
            int aFl6 = o.b.aFl();
            o.b bVar12 = o.b.hGo;
            Bitmap createScaledBitmap6 = Bitmap.createScaledBitmap(decodeResource6, aFl6, o.b.aFl(), true);
            this.hRh.add(createScaledBitmap);
            this.hRh.add(createScaledBitmap2);
            this.hRh.add(createScaledBitmap3);
            this.hRh.add(createScaledBitmap4);
            this.hRh.add(createScaledBitmap5);
            this.hRh.add(createScaledBitmap6);
            AppMethodBeat.o(208078);
            return;
        }
        b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
        if (b.a.aDp()) {
            Context context7 = this.hwr.getContext();
            p.g(context7, "root.context");
            Bitmap decodeResource7 = BitmapFactory.decodeResource(context7.getResources(), R.drawable.bsu);
            o.b bVar13 = o.b.hGo;
            int aFl7 = o.b.aFl();
            o.b bVar14 = o.b.hGo;
            Bitmap createScaledBitmap7 = Bitmap.createScaledBitmap(decodeResource7, aFl7, o.b.aFl(), true);
            Context context8 = this.hwr.getContext();
            p.g(context8, "root.context");
            Bitmap decodeResource8 = BitmapFactory.decodeResource(context8.getResources(), R.drawable.bsv);
            o.b bVar15 = o.b.hGo;
            int aFl8 = o.b.aFl();
            o.b bVar16 = o.b.hGo;
            Bitmap createScaledBitmap8 = Bitmap.createScaledBitmap(decodeResource8, aFl8, o.b.aFl(), true);
            Context context9 = this.hwr.getContext();
            p.g(context9, "root.context");
            Bitmap decodeResource9 = BitmapFactory.decodeResource(context9.getResources(), R.drawable.bsw);
            o.b bVar17 = o.b.hGo;
            int aFl9 = o.b.aFl();
            o.b bVar18 = o.b.hGo;
            Bitmap createScaledBitmap9 = Bitmap.createScaledBitmap(decodeResource9, aFl9, o.b.aFl(), true);
            Context context10 = this.hwr.getContext();
            p.g(context10, "root.context");
            Bitmap decodeResource10 = BitmapFactory.decodeResource(context10.getResources(), R.drawable.bsx);
            o.b bVar19 = o.b.hGo;
            int aFl10 = o.b.aFl();
            o.b bVar20 = o.b.hGo;
            Bitmap createScaledBitmap10 = Bitmap.createScaledBitmap(decodeResource10, aFl10, o.b.aFl(), true);
            Context context11 = this.hwr.getContext();
            p.g(context11, "root.context");
            Bitmap decodeResource11 = BitmapFactory.decodeResource(context11.getResources(), R.drawable.bsy);
            o.b bVar21 = o.b.hGo;
            int aFl11 = o.b.aFl();
            o.b bVar22 = o.b.hGo;
            Bitmap createScaledBitmap11 = Bitmap.createScaledBitmap(decodeResource11, aFl11, o.b.aFl(), true);
            Context context12 = this.hwr.getContext();
            p.g(context12, "root.context");
            Bitmap decodeResource12 = BitmapFactory.decodeResource(context12.getResources(), R.drawable.bsz);
            o.b bVar23 = o.b.hGo;
            int aFl12 = o.b.aFl();
            o.b bVar24 = o.b.hGo;
            Bitmap createScaledBitmap12 = Bitmap.createScaledBitmap(decodeResource12, aFl12, o.b.aFl(), true);
            this.hRh.add(createScaledBitmap7);
            this.hRh.add(createScaledBitmap8);
            this.hRh.add(createScaledBitmap9);
            this.hRh.add(createScaledBitmap10);
            this.hRh.add(createScaledBitmap11);
            this.hRh.add(createScaledBitmap12);
        }
        AppMethodBeat.o(208078);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        int i2;
        int i3 = 100;
        AppMethodBeat.i(208079);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (ad.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (bundle != null) {
                    i2 = bundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");
                } else {
                    i2 = 100;
                }
                if (bundle != null) {
                    i3 = bundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
                }
                Log.d(this.TAG, "emitLikeConfetti containerMiddleX=" + i2 + " containerMiddleY=" + i3);
                d dVar = new d(i2, i3);
                Bitmap bitmap = this.hRh.get(kotlin.j.c.SYP.nextInt(0, this.hRh.size()));
                p.g(bitmap, "confettiBitmaps[Random.n…0, confettiBitmaps.size)]");
                this.hRg = new c(this.hwr.getContext(), new a(bitmap), dVar, this.hRf).ax(1.0f).bkF().H(-360.0f, 50.0f).AQ(1000).bkD().bkJ();
                if (this.hOp.getLiveRole() == 0) {
                    f.aIS();
                    break;
                }
                break;
        }
        AppMethodBeat.o(208079);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", LocaleUtil.ITALIAN, "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
    static final class a implements com.tencent.mm.particles.b {
        final /* synthetic */ Bitmap cKG;

        a(Bitmap bitmap) {
            this.cKG = bitmap;
        }

        @Override // com.tencent.mm.particles.b
        public final /* synthetic */ com.tencent.mm.particles.a.b a(Random random) {
            AppMethodBeat.i(208077);
            com.tencent.mm.live.view.b.a aVar = new com.tencent.mm.live.view.b.a(this.cKG);
            AppMethodBeat.o(208077);
            return aVar;
        }
    }
}
