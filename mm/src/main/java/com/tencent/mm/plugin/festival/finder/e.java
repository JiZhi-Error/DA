package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.finder.k;
import com.tencent.mm.plugin.festival.model.ag;
import com.tencent.mm.plugin.festival.model.t;
import com.tencent.mm.plugin.festival.ui.StarryNight;
import com.tencent.mm.plugin.festival.ui.c;
import com.tencent.mm.plugin.festival.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u001a\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020!H\u0016R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasLayout;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$ViewCallback;", "Lcom/tencent/mm/plugin/festival/model/IForbiddenCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "canvas", "Lcom/tencent/mm/plugin/festival/ui/StarryNight;", "getCanvas", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "fairyWandDrawEndListener", "Lkotlin/Function0;", "", "isFairyWandForbidden", "isTouchHitRectPaddingRequired", "logic", "Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic;", "presenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;", "ps", "Lcom/tencent/mm/plugin/festival/ui/ParticleSystemLogic;", "canClearScreen", "getFlagBit", "", "mount", "", "onForbiddenChange", "isBitFlagSet", "pause", "resume", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-festival_release"})
public final class e extends p implements k.b, ag {
    @Deprecated
    public static final b UqB = new b((byte) 0);
    private kotlin.g.a.a<Boolean> UqA;
    final k.a Uqv;
    private final com.tencent.mm.plugin.festival.ui.c Uqw;
    private final com.tencent.mm.plugin.festival.ui.e Uqx;
    private boolean Uqy;
    private boolean Uqz;
    private final Context context;
    private final com.tencent.mm.live.c.b hOp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262071);
        this.hOp = bVar;
        Log.i("MicroMsg.FestivalCanvasLayout", "CanvasLayout init");
        this.context = viewGroup.getContext();
        this.Uqv = new g(this, viewGroup);
        Context context2 = this.context;
        p.g(context2, "context");
        com.tencent.mm.plugin.festival.ui.c cVar = new com.tencent.mm.plugin.festival.ui.c(context2);
        viewGroup.addView(cVar.UBq, new ViewGroup.LayoutParams(-1, -1));
        a aVar = new a(this, viewGroup);
        Log.i("MicroMsg.FestivalCanvas", "setting onCanvasDataReadyListener ".concat(String.valueOf(aVar)));
        cVar.UBp = aVar;
        this.Uqw = cVar;
        com.tencent.mm.plugin.festival.model.f fVar = com.tencent.mm.plugin.festival.model.f.UxT;
        com.tencent.mm.plugin.festival.model.f.s(viewGroup);
        StarryNight starryNight = this.Uqw.UBq;
        com.tencent.mm.plugin.festival.model.a aVar2 = com.tencent.mm.plugin.festival.model.a.Uxu;
        this.Uqx = new com.tencent.mm.plugin.festival.ui.e(viewGroup, starryNight, com.tencent.mm.plugin.festival.model.a.gFf(), "festival2021/particle1.png", "festival2021/particle2.png");
        this.Uqx.UBJ = new e.d() {
            /* class com.tencent.mm.plugin.festival.finder.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.festival.ui.e.d
            public final void i(String str, String str2) {
                AppMethodBeat.i(262032);
                p.h(str, "tag");
                p.h(str2, "log");
                Log.i(str, str2);
                AppMethodBeat.o(262032);
            }
        };
        AppMethodBeat.o(262071);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasLayout$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(262072);
        StarryNight.class.getClassLoader();
        j.Ed("festival2021");
        AppMethodBeat.o(262072);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000_\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020/H\u0016J\b\u00103\u001a\u00020/H\u0016J\b\u00104\u001a\u00020/H\u0016J\b\u00105\u001a\u00020/H\u0016J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u000eH\u0016J\u0018\u00108\u001a\u00020/2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010:H\u0016J\u0012\u0010;\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$H\u0016J\u0010\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$H\u0016J\u0018\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020$H\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010C\u001a\u00020$H\u0016J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010D\u001a\u00020$H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u0014\u0010\u001b\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R$\u0010)\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u000e¢\u0006\f\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\f¨\u0006G"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasLayout$presenter$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;", "clickRippleDuration", "", "getClickRippleDuration", "()J", "value", "", "drawEffect", "getDrawEffect", "()I", "setDrawEffect", "(I)V", "isClickRippleEnabled", "", "()Z", "setClickRippleEnabled", "(Z)V", "isDraggable", "setDraggable", "isLaidOut", "lastTouchUpPointRaw", "Landroid/graphics/PointF;", "getLastTouchUpPointRaw", "()Landroid/graphics/PointF;", "srcHeight", "getSrcHeight", "srcWidth", "getSrcWidth", "vRect", "Landroid/graphics/RectF;", "getVRect", "()Landroid/graphics/RectF;", "vRectDefault", "getVRectDefault", "vScale", "", "getVScale", "()F", "vScaleDefault", "getVScaleDefault", "visibility", "getVisibility", "setVisibility", "captureForShare", "Landroid/graphics/Bitmap;", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$ViewCallback;", "onDetach", "pauseSensor", "requestFairyWandEffectDisappear", "resumeSensor", "setEnableFairyWand", "enable", "setOnFairyWandDrawEndListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "setScaleAndTranslate", "sat", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$ScaleAndTranslate;", "sourceToViewX", "sx", "sourceToViewY", "sy", "startFlashStar", "vx", "vy", "viewToSourceX", "viewToSourceY", "plugin-festival_release"})
    public static final class g implements k.a {
        final /* synthetic */ e UqC;
        private boolean UqE;
        final /* synthetic */ ViewGroup hOA;

        g(e eVar, ViewGroup viewGroup) {
            this.UqC = eVar;
            this.hOA = viewGroup;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final PointF c(PointF pointF, PointF pointF2) {
            AppMethodBeat.i(262064);
            p.h(pointF, "sp");
            p.h(pointF2, "vp");
            p.h(pointF, "sp");
            p.h(pointF2, "vp");
            pointF2.x = Y(pointF.x);
            pointF2.y = Z(pointF.y);
            AppMethodBeat.o(262064);
            return pointF2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(k.b bVar) {
            AppMethodBeat.i(262058);
            p.h(bVar, "callback");
            AppMethodBeat.o(262058);
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final int getSrcWidth() {
            AppMethodBeat.i(262044);
            int srcWidth = e.e(this.UqC).getSrcWidth();
            AppMethodBeat.o(262044);
            return srcWidth;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final int getSrcHeight() {
            AppMethodBeat.i(262045);
            int srcHeight = e.e(this.UqC).getSrcHeight();
            AppMethodBeat.o(262045);
            return srcHeight;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final RectF getVRectDefault() {
            AppMethodBeat.i(262046);
            RectF rectF = new RectF(e.e(this.UqC).getVRectDefault());
            AppMethodBeat.o(262046);
            return rectF;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final float getVScaleDefault() {
            AppMethodBeat.i(262047);
            float vScaleDefault = e.e(this.UqC).getVScaleDefault();
            AppMethodBeat.o(262047);
            return vScaleDefault;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final void setDraggable(boolean z) {
            AppMethodBeat.i(262048);
            e.e(this.UqC).setDraggable(z);
            AppMethodBeat.o(262048);
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final void dRg() {
            AppMethodBeat.i(262049);
            e.e(this.UqC).setDrawEffect(0);
            AppMethodBeat.o(262049);
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final long getClickRippleDuration() {
            AppMethodBeat.i(262050);
            long clickRippleDuration = e.e(this.UqC).getClickRippleDuration();
            AppMethodBeat.o(262050);
            return clickRippleDuration;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final void Ff(boolean z) {
            this.UqE = z;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final boolean egf() {
            return this.UqE;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final PointF getLastTouchUpPointRaw() {
            AppMethodBeat.i(262051);
            PointF lastTouchUpPointRaw = e.e(this.UqC).getLastTouchUpPointRaw();
            AppMethodBeat.o(262051);
            return lastTouchUpPointRaw;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final void egv() {
            AppMethodBeat.i(262052);
            e.e(this.UqC).getSensor().pause();
            AppMethodBeat.o(262052);
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final void setScaleAndTranslate(StarryNight.m mVar) {
            AppMethodBeat.i(262053);
            e.e(this.UqC).setScaleAndTranslate(mVar);
            AppMethodBeat.o(262053);
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final float Y(float f2) {
            AppMethodBeat.i(262054);
            float Y = e.e(this.UqC).Y(f2);
            AppMethodBeat.o(262054);
            return Y;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final float Z(float f2) {
            AppMethodBeat.i(262055);
            float Z = e.e(this.UqC).Z(f2);
            AppMethodBeat.o(262055);
            return Z;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final int aZ(float f2) {
            AppMethodBeat.i(262056);
            int aZ = e.e(this.UqC).aZ(f2);
            AppMethodBeat.o(262056);
            return aZ;
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final int cV(float f2) {
            AppMethodBeat.i(262057);
            int cV = e.e(this.UqC).cV(f2);
            AppMethodBeat.o(262057);
            return cV;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final void aN(float f2, float f3) {
            AppMethodBeat.i(262059);
            StarryNight e2 = e.e(this.UqC);
            PointF pointF = new PointF(f2, f3);
            p.h(pointF, "position");
            StarryNight.b.hSl();
            StarryNight.d dVar = new StarryNight.d(e2, pointF, e2.UCr);
            dVar.ay(new StarryNight.z(dVar, e2));
            dVar.start();
            List<StarryNight.d> list = e2.UCZ;
            if (list != null) {
                list.add(dVar);
                AppMethodBeat.o(262059);
                return;
            }
            AppMethodBeat.o(262059);
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final void Fg(boolean z) {
            AppMethodBeat.i(262060);
            if (this.UqC.Uqy) {
                this.UqC.Uqx.setEnable(false);
                AppMethodBeat.o(262060);
                return;
            }
            this.UqC.Uqx.setEnable(z);
            AppMethodBeat.o(262060);
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final void ar(kotlin.g.a.a<Boolean> aVar) {
            AppMethodBeat.i(262061);
            this.UqC.UqA = aVar;
            AppMethodBeat.o(262061);
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final void egF() {
            AppMethodBeat.i(262062);
            this.UqC.Uqx.hSi();
            AppMethodBeat.o(262062);
        }

        @Override // com.tencent.mm.plugin.festival.finder.k.a
        public final Bitmap ewK() {
            AppMethodBeat.i(262063);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.hOA.getWidth(), this.hOA.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                com.tencent.mm.plugin.festival.model.f fVar = com.tencent.mm.plugin.festival.model.f.UxT;
                ViewGroup viewGroup = this.hOA;
                p.h(viewGroup, "root");
                p.h(canvas, "canvas");
                ((RelativeLayout) viewGroup.findViewById(R.id.jvk)).bringToFront();
                Context context = viewGroup.getContext();
                p.g(context, "root.context");
                ((ImageView) viewGroup.findViewById(R.id.jvm)).setImageDrawable(com.tencent.mm.plugin.festival.model.f.me(context));
                RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.jvk);
                p.g(relativeLayout, "root.festival_water_mask");
                relativeLayout.setVisibility(0);
                viewGroup.draw(canvas);
                RelativeLayout relativeLayout2 = (RelativeLayout) viewGroup.findViewById(R.id.jvk);
                p.g(relativeLayout2, "root.festival_water_mask");
                relativeLayout2.setVisibility(4);
                AppMethodBeat.o(262063);
                return createBitmap;
            } catch (Exception e2) {
                b unused = e.UqB;
                Log.e("MicroMsg.FestivalCanvasLayout", "captureForShare exception:".concat(String.valueOf(e2)));
                AppMethodBeat.o(262063);
                return null;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasLayout$logic$1$1", "Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$OnDataReady;", "onReady", "", "plugin-festival_release"})
    public static final class a implements c.d {
        final /* synthetic */ e UqC;
        final /* synthetic */ ViewGroup UqD;

        a(e eVar, ViewGroup viewGroup) {
            this.UqC = eVar;
            this.UqD = viewGroup;
        }

        @Override // com.tencent.mm.plugin.festival.ui.c.d
        public final void onReady() {
            AppMethodBeat.i(262031);
            b unused = e.UqB;
            Log.i("MicroMsg.FestivalCanvasLayout", "onCanvasDataReadyListener onReady");
            b.C0376b.a(this.UqC.hOp, b.c.wMa);
            AppMethodBeat.o(262031);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(262065);
        super.mount();
        Log.i("MicroMsg.FestivalCanvasLayout", "layout: mount");
        this.Uqw.UBq.setOnViewPortChangedListener(new c(this));
        this.Uqz = true;
        this.Uqw.UBq.setOnApplyWindowInsetsListener(new d(this));
        this.Uqv.onAttach(this);
        this.Uqw.UBq.setOnCanvasClickListener(new C1063e(this));
        this.Uqx.UBK = new f(this);
        t tVar = t.UyR;
        Fe(t.awC(32));
        AppMethodBeat.o(262065);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasLayout$mount$1", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnViewPortChangedListener;", "onViewPortChanged", "", "plugin-festival_release"})
    public static final class c implements StarryNight.k {
        final /* synthetic */ e UqC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(e eVar) {
            this.UqC = eVar;
        }

        @Override // com.tencent.mm.plugin.festival.ui.StarryNight.k
        public final void dDa() {
            AppMethodBeat.i(262034);
            b.C0376b.a(this.UqC.hOp, b.c.wLZ);
            AppMethodBeat.o(262034);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Landroid/view/WindowInsets;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Landroid/view/View;", "insets", "onApplyWindowInsets"})
    static final class d implements View.OnApplyWindowInsetsListener {
        final /* synthetic */ e UqC;

        d(e eVar) {
            this.UqC = eVar;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            AppMethodBeat.i(262035);
            if (this.UqC.Uqz) {
                com.tencent.mm.plugin.festival.ui.e eVar = this.UqC.Uqx;
                p.g(windowInsets, "insets");
                int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
                Context context = this.UqC.context;
                p.g(context, "context");
                eVar.UBN = (float) (systemWindowInsetTop + context.getResources().getDimensionPixelSize(R.dimen.cn));
                com.tencent.mm.plugin.festival.ui.e eVar2 = this.UqC.Uqx;
                int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
                Context context2 = this.UqC.context;
                p.g(context2, "context");
                eVar2.UBO = (float) (systemWindowInsetBottom + context2.getResources().getDimensionPixelSize(R.dimen.cs));
            }
            AppMethodBeat.o(262035);
            return windowInsets;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasLayout$mount$3", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnCanvasClickListener;", "onCanvasRegionClick", "", "sx", "", "sy", "onInvalidRegionClick", "", "vx", "", "vy", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "plugin-festival_release"})
    /* renamed from: com.tencent.mm.plugin.festival.finder.e$e  reason: collision with other inner class name */
    public static final class C1063e implements StarryNight.j {
        final /* synthetic */ e UqC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1063e(e eVar) {
            this.UqC = eVar;
        }

        @Override // com.tencent.mm.plugin.festival.ui.StarryNight.j
        public final boolean kM(int i2, int i3) {
            AppMethodBeat.i(262036);
            float Y = e.e(this.UqC).Y((float) i2);
            float Z = e.e(this.UqC).Z((float) i3);
            com.tencent.mm.live.c.b bVar = this.UqC.hOp;
            b.c cVar = b.c.wMx;
            Bundle bundle = new Bundle();
            bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_CANVAS_CLICK_POINT", new PointF(Y, Z));
            bVar.statusChange(cVar, bundle);
            boolean egf = this.UqC.Uqv.egf();
            AppMethodBeat.o(262036);
            return egf;
        }

        @Override // com.tencent.mm.plugin.festival.ui.StarryNight.j
        public final void aM(float f2, float f3) {
            AppMethodBeat.i(262037);
            com.tencent.mm.live.c.b bVar = this.UqC.hOp;
            b.c cVar = b.c.wMx;
            Bundle bundle = new Bundle();
            bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_CANVAS_CLICK_POINT", new PointF(f2, f3));
            bVar.statusChange(cVar, bundle);
            AppMethodBeat.o(262037);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.festival.ui.StarryNight.j
        public final void onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(262038);
            p.h(motionEvent, "ev");
            com.tencent.mm.plugin.festival.ui.e eVar = this.UqC.Uqx;
            p.h(motionEvent, "event");
            switch (motionEvent.getAction()) {
                case 0:
                    e.d dVar = eVar.UBJ;
                    if (dVar != null) {
                        dVar.i("ParticleSystemLogic", "startEmitting " + eVar.enable + ' ' + eVar.UBN + ' ' + eVar.UBO);
                    }
                    if (!eVar.enable) {
                        e.d dVar2 = eVar.UBJ;
                        if (dVar2 != null) {
                            dVar2.i("ParticleSystemLogic", "startEmitting disable because enable");
                            AppMethodBeat.o(262038);
                            return;
                        }
                        AppMethodBeat.o(262038);
                        return;
                    } else if (motionEvent.getY() <= eVar.UBN || motionEvent.getY() >= ((float) eVar.zQH.getHeight()) - eVar.UBO) {
                        e.d dVar3 = eVar.UBJ;
                        if (dVar3 != null) {
                            dVar3.i("ParticleSystemLogic", "startEmitting disable because padding, " + motionEvent.getY() + ", " + eVar.zQH.getHeight());
                            AppMethodBeat.o(262038);
                            return;
                        }
                        AppMethodBeat.o(262038);
                        return;
                    } else {
                        for (T t : eVar.UBT) {
                            t.eI((int) motionEvent.getX(), (int) motionEvent.getY());
                            t.acY();
                        }
                        eVar.zQH.removeCallbacks(eVar.UBU);
                        eVar.zQH.removeCallbacks(eVar.UBV);
                        com.tencent.mm.plugin.festival.ui.a aVar = eVar.UBK;
                        if (aVar != null) {
                            aVar.dGA();
                            AppMethodBeat.o(262038);
                            return;
                        }
                        AppMethodBeat.o(262038);
                        return;
                    }
                case 1:
                    e.d dVar4 = eVar.UBJ;
                    if (dVar4 != null) {
                        dVar4.i("ParticleSystemLogic", "stopEmitting " + eVar.enable);
                    }
                    for (T t2 : eVar.UBT) {
                        t2.eI((int) motionEvent.getX(), (int) motionEvent.getY());
                        t2.aff();
                    }
                    eVar.zQH.removeCallbacks(eVar.UBU);
                    eVar.zQH.postDelayed(eVar.UBU, 400);
                    com.tencent.mm.plugin.festival.ui.a aVar2 = eVar.UBK;
                    if (aVar2 != null) {
                        aVar2.dGB();
                        AppMethodBeat.o(262038);
                        return;
                    }
                    break;
                case 2:
                    for (T t3 : eVar.UBT) {
                        if (eVar.enable) {
                            t3.eI((int) motionEvent.getX(), (int) motionEvent.getY());
                        }
                    }
                    eVar.zQH.removeCallbacks(eVar.UBU);
                    AppMethodBeat.o(262038);
                    return;
            }
            AppMethodBeat.o(262038);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasLayout$mount$4", "Lcom/tencent/mm/plugin/festival/ui/FairyWandListener;", "onFairyWandDisappearEnd", "", "onFairyWandDisappearStart", "onFairyWandDrawEnd", "", "onFairyWandStart", "onFairyWandUp", "plugin-festival_release"})
    public static final class f implements com.tencent.mm.plugin.festival.ui.a {
        final /* synthetic */ e UqC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(e eVar) {
            this.UqC = eVar;
        }

        @Override // com.tencent.mm.plugin.festival.ui.a
        public final void dGA() {
            AppMethodBeat.i(262039);
            b.C0376b.a(this.UqC.hOp, b.c.yPp);
            com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
            com.tencent.mm.plugin.festival.model.a.b.hRX();
            AppMethodBeat.o(262039);
        }

        @Override // com.tencent.mm.plugin.festival.ui.a
        public final void dGB() {
            AppMethodBeat.i(262040);
            b.C0376b.a(this.UqC.hOp, b.c.yVW);
            AppMethodBeat.o(262040);
        }

        @Override // com.tencent.mm.plugin.festival.ui.a
        public final boolean dJf() {
            AppMethodBeat.i(262041);
            kotlin.g.a.a aVar = this.UqC.UqA;
            if (aVar == null || !((Boolean) aVar.invoke()).booleanValue()) {
                AppMethodBeat.o(262041);
                return false;
            }
            AppMethodBeat.o(262041);
            return true;
        }

        @Override // com.tencent.mm.plugin.festival.ui.a
        public final void dMl() {
            AppMethodBeat.i(262042);
            b.C0376b.a(this.UqC.hOp, b.c.zeg);
            AppMethodBeat.o(262042);
        }

        @Override // com.tencent.mm.plugin.festival.ui.a
        public final void dMs() {
            AppMethodBeat.i(262043);
            b.C0376b.a(this.UqC.hOp, b.c.zeh);
            AppMethodBeat.o(262043);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262066);
        super.unMount();
        Log.i("MicroMsg.FestivalCanvasLayout", "layout: unMount");
        this.Uqw.UBq.release();
        AppMethodBeat.o(262066);
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(262067);
        Log.i("MicroMsg.FestivalCanvasLayout", "layout: resume");
        super.resume();
        this.Uqw.resume();
        AppMethodBeat.o(262067);
    }

    @Override // com.tencent.mm.live.c.a
    public final void pause() {
        AppMethodBeat.i(262068);
        Log.i("MicroMsg.FestivalCanvasLayout", "layout: pause");
        super.pause();
        this.Uqw.pause();
        AppMethodBeat.o(262068);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(262069);
        p.h(cVar, "status");
        switch (f.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                this.Uqw.UBq.setDebug(false);
                k.a aVar = this.Uqv;
                StarryNight.m mVar = new StarryNight.m();
                mVar.UDM = Float.valueOf(this.Uqv.getVScaleDefault());
                RectF vRectDefault = this.Uqv.getVRectDefault();
                mVar.a(new Point(0, 0), new PointF(vRectDefault.left, vRectDefault.top));
                aVar.setScaleAndTranslate(mVar);
                Log.i("MicroMsg.FestivalCanvasLayout", "statusChange: resume effect");
                StarryNight.o sensor = this.Uqw.UBq.getSensor();
                sensor.UDR = true;
                sensor.hSp();
                this.Uqv.Fg(true);
                this.Uqw.UBq.setDrawEffect(1);
                break;
            case 2:
            case 3:
                Log.i("MicroMsg.FestivalCanvasLayout", "statusChange: pause effect");
                this.Uqw.UBq.getSensor().pause();
                this.Uqv.Fg(false);
                this.Uqw.UBq.setDebug(false);
                break;
            case 4:
                this.Uqw.UBq.setDrawEffect(1);
                this.Uqw.UBq.setDebug(false);
                break;
        }
        switch (f.haE[cVar.ordinal()]) {
            case 1:
                Log.i("MicroMsg.FestivalCanvasLayout", "restore_initial");
                this.Uqz = true;
                this.Uqw.UBq.requestApplyInsets();
                AppMethodBeat.o(262069);
                return;
            case 2:
            case 3:
                Log.i("MicroMsg.FestivalCanvasLayout", "FESTIVAL_FINDER_LIVE_ENTER_POST_WISH");
                this.Uqz = false;
                this.Uqx.UBN = 0.0f;
                this.Uqx.UBO = 0.0f;
                break;
        }
        AppMethodBeat.o(262069);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return false;
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final void Fe(boolean z) {
        boolean z2;
        AppMethodBeat.i(262070);
        Log.i("MicroMsg.FestivalCanvasLayout", "onForbiddenChange(" + z + ')');
        if (!z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.Uqy = z2;
        if (this.Uqy) {
            this.Uqv.Fg(false);
        }
        AppMethodBeat.o(262070);
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final int dCX() {
        return 32;
    }

    public static final /* synthetic */ StarryNight e(e eVar) {
        return eVar.Uqw.UBq;
    }
}
