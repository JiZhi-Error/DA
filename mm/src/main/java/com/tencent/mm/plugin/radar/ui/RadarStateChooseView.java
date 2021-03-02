package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.radar.b.e;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u000eR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isShowing", "", "mStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;)V", "mTrunOn", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "show", "stateAlignment", "trunOff", "trunOn", "trunToStatus", "status", "Companion", "plugin-radar_release"})
public final class RadarStateChooseView extends RelativeLayout {
    public static final a BAm = new a((byte) 0);
    private static final String TAG = TAG;
    private final f BAi = g.ah(new c(this));
    private final f BAj = g.ah(new b(this));
    boolean BAk = true;
    e.a BAl = e.a.UnSelected;
    boolean ddZ;

    /* access modifiers changed from: package-private */
    public final Animation getSlideInAnim() {
        AppMethodBeat.i(138675);
        Animation animation = (Animation) this.BAj.getValue();
        AppMethodBeat.o(138675);
        return animation;
    }

    /* access modifiers changed from: package-private */
    public final Animation getSlideOutAnim() {
        AppMethodBeat.i(138674);
        Animation animation = (Animation) this.BAi.getValue();
        AppMethodBeat.o(138674);
        return animation;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Animation> {
        final /* synthetic */ RadarStateChooseView BAn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(RadarStateChooseView radarStateChooseView) {
            super(0);
            this.BAn = radarStateChooseView;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements Animation.AnimationListener {
            a() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(138669);
                p.h(animation, "animation");
                AppMethodBeat.o(138669);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(138670);
                p.h(animation, "animation");
                AppMethodBeat.o(138670);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(138671);
                p.h(animation, "animation");
                AppMethodBeat.o(138671);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Animation invoke() {
            AppMethodBeat.i(138672);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.BAn.getContext(), R.anim.du);
            loadAnimation.setAnimationListener(new a());
            p.g(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
            AppMethodBeat.o(138672);
            return loadAnimation;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Animation> {
        final /* synthetic */ RadarStateChooseView BAn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(RadarStateChooseView radarStateChooseView) {
            super(0);
            this.BAn = radarStateChooseView;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements Animation.AnimationListener {
            final /* synthetic */ b BAo;

            a(b bVar) {
                this.BAo = bVar;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(138665);
                p.h(animation, "animation");
                AppMethodBeat.o(138665);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(138666);
                p.h(animation, "animation");
                this.BAo.BAn.ddZ = false;
                this.BAo.BAn.setVisibility(8);
                AppMethodBeat.o(138666);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(138667);
                p.h(animation, "animation");
                AppMethodBeat.o(138667);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Animation invoke() {
            AppMethodBeat.i(138668);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.BAn.getContext(), R.anim.dt);
            loadAnimation.setAnimationListener(new a(this));
            p.g(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
            AppMethodBeat.o(138668);
            return loadAnimation;
        }
    }

    public final e.a getMStatus() {
        return this.BAl;
    }

    public final void setMStatus(e.a aVar) {
        AppMethodBeat.i(138676);
        p.h(aVar, "<set-?>");
        this.BAl = aVar;
        AppMethodBeat.o(138676);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarStateChooseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138678);
        AppMethodBeat.o(138678);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarStateChooseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138679);
        AppMethodBeat.o(138679);
    }

    /* access modifiers changed from: package-private */
    public final void eHt() {
        AppMethodBeat.i(138677);
        switch (e.$EnumSwitchMapping$0[this.BAl.ordinal()]) {
            case 1:
                setVisibility(4);
                AppMethodBeat.o(138677);
                return;
            case 2:
                setBackgroundResource(R.raw.radar_select);
                setVisibility(0);
                AppMethodBeat.o(138677);
                return;
            default:
                setVisibility(4);
                AppMethodBeat.o(138677);
                return;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138673);
        AppMethodBeat.o(138673);
    }
}
