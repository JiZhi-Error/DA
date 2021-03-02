package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\"\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010(\u001a\u00020&J\u0006\u0010)\u001a\u00020&J\b\u0010*\u001a\u00020&H\u0002J\u0006\u0010+\u001a\u00020&J\u0006\u0010$\u001a\u00020&J\u000e\u0010,\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"})
public final class RadarStateView extends RelativeLayout {
    static final int BAs = 300;
    public static final a BAt = new a((byte) 0);
    static final String TAG = TAG;
    private final f BAi = g.ah(new c(this));
    private final f BAj = g.ah(new b(this));
    boolean BAp = true;
    final d BAq = new d(this);
    private ImageView BAr;
    c.e Bzc = c.e.Stranger;
    boolean ddZ;

    private final Animation getSlideInAnim() {
        AppMethodBeat.i(138694);
        Animation animation = (Animation) this.BAj.getValue();
        AppMethodBeat.o(138694);
        return animation;
    }

    private final Animation getSlideOutAnim() {
        AppMethodBeat.i(138693);
        Animation animation = (Animation) this.BAi.getValue();
        AppMethodBeat.o(138693);
        return animation;
    }

    public static final /* synthetic */ void a(RadarStateView radarStateView) {
        AppMethodBeat.i(138701);
        radarStateView.eHt();
        AppMethodBeat.o(138701);
    }

    public final c.e getState() {
        return this.Bzc;
    }

    public final void setState(c.e eVar) {
        AppMethodBeat.i(138692);
        p.h(eVar, "<set-?>");
        this.Bzc = eVar;
        AppMethodBeat.o(138692);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class d extends MMHandler {
        final /* synthetic */ RadarStateView BAu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(RadarStateView radarStateView) {
            this.BAu = radarStateView;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(138690);
            p.h(message, "msg");
            RadarStateView.a(this.BAu);
            this.BAu.eHu();
            AppMethodBeat.o(138690);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Animation> {
        final /* synthetic */ RadarStateView BAu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(RadarStateView radarStateView) {
            super(0);
            this.BAu = radarStateView;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarStateView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements Animation.AnimationListener {
            a() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(138686);
                p.h(animation, "animation");
                AppMethodBeat.o(138686);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(138687);
                p.h(animation, "animation");
                AppMethodBeat.o(138687);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(138688);
                p.h(animation, "animation");
                AppMethodBeat.o(138688);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Animation invoke() {
            AppMethodBeat.i(138689);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.BAu.getContext(), R.anim.dw);
            loadAnimation.setAnimationListener(new a());
            AppMethodBeat.o(138689);
            return loadAnimation;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Animation> {
        final /* synthetic */ RadarStateView BAu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(RadarStateView radarStateView) {
            super(0);
            this.BAu = radarStateView;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements Animation.AnimationListener {
            final /* synthetic */ b BAv;

            a(b bVar) {
                this.BAv = bVar;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(138682);
                p.h(animation, "animation");
                AppMethodBeat.o(138682);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(138683);
                p.h(animation, "animation");
                this.BAv.BAu.ddZ = false;
                this.BAv.BAu.setVisibility(8);
                AppMethodBeat.o(138683);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(138684);
                p.h(animation, "animation");
                AppMethodBeat.o(138684);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Animation invoke() {
            AppMethodBeat.i(138685);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.BAu.getContext(), R.anim.dv);
            loadAnimation.setAnimationListener(new a(this));
            AppMethodBeat.o(138685);
            return loadAnimation;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138699);
        AppMethodBeat.o(138699);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarStateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138700);
        AppMethodBeat.o(138700);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void eHt() {
        AppMethodBeat.i(138695);
        Log.d(TAG, " state : " + this.Bzc);
        if (!this.BAp) {
            setVisibility(8);
            AppMethodBeat.o(138695);
            return;
        }
        switch (f.$EnumSwitchMapping$0[this.Bzc.ordinal()]) {
            case 1:
                setVisibility(8);
                AppMethodBeat.o(138695);
                return;
            case 2:
                setBackgroundResource(R.raw.radar_search_blue_bg);
                ImageView imageView = this.BAr;
                if (imageView == null) {
                    p.hyc();
                }
                imageView.setImageResource(R.raw.radar_search_waiting);
                setVisibility(0);
                AppMethodBeat.o(138695);
                return;
            case 3:
                setBackgroundResource(R.raw.radar_search_green_bg);
                ImageView imageView2 = this.BAr;
                if (imageView2 == null) {
                    p.hyc();
                }
                imageView2.setImageResource(R.raw.radar_search_ok);
                setVisibility(0);
                AppMethodBeat.o(138695);
                return;
            case 4:
                setBackgroundResource(R.raw.radar_search_green_bg);
                ImageView imageView3 = this.BAr;
                if (imageView3 == null) {
                    p.hyc();
                }
                imageView3.setImageResource(R.raw.radar_search_hi);
                setVisibility(0);
                break;
        }
        AppMethodBeat.o(138695);
    }

    /* access modifiers changed from: package-private */
    public final void init() {
        AppMethodBeat.i(138696);
        if (this.BAr == null) {
            this.BAr = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMargins(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5), com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));
            ImageView imageView = this.BAr;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            addView(this.BAr);
        }
        AppMethodBeat.o(138696);
    }

    public final void eHu() {
        AppMethodBeat.i(138697);
        if (!this.BAp) {
            AppMethodBeat.o(138697);
            return;
        }
        init();
        eHt();
        this.ddZ = true;
        startAnimation(getSlideOutAnim());
        AppMethodBeat.o(138697);
    }

    public final void eHv() {
        AppMethodBeat.i(138698);
        if (!this.BAp) {
            AppMethodBeat.o(138698);
            return;
        }
        init();
        eHt();
        startAnimation(getSlideInAnim());
        AppMethodBeat.o(138698);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateView$Companion;", "", "()V", "SlideAnimationDuring", "", "getSlideAnimationDuring", "()I", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138691);
        AppMethodBeat.o(138691);
    }
}
