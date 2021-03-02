package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0014J\u0010\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R,\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "bgView", "contentView", "context", "Landroid/content/Context;", "mainIconLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "radius", "", "getRootView", "()Landroid/view/View;", "setRootView", "timeTv", "Landroid/widget/TextView;", "tipTv", "value", "", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "doAnimationHide", "", "doAnimationShow", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "", "refreshMiniView", "release", "setVoicePlayDevice", "device", "updateText", "text", "", ch.COL_UPDATETIME, "plugin-multitalk_release"})
public final class j {
    View cBH;
    View contentView = this.lJI.findViewById(R.id.fod);
    Context context;
    TextView jBS;
    View lJI;
    private final float radius = ((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12));
    TextView timeTv;
    WeImageView zTt;
    Integer zTu;

    public j(View view) {
        p.h(view, "rootView");
        AppMethodBeat.i(239805);
        this.lJI = view;
        View view2 = this.contentView;
        if (view2 != null) {
            view2.setClipToOutline(true);
        }
        View view3 = this.contentView;
        if (view3 != null) {
            view3.setOutlineProvider(new e(this.radius));
        }
        this.cBH = this.lJI.findViewById(R.id.jnt);
        View view4 = this.cBH;
        if (view4 != null) {
            view4.setClipToOutline(true);
        }
        View view5 = this.cBH;
        if (view5 != null) {
            view5.setOutlineProvider(new e(this.radius));
        }
        this.timeTv = (TextView) this.lJI.findViewById(R.id.fpi);
        this.jBS = (TextView) this.lJI.findViewById(R.id.fpj);
        this.context = this.lJI.getContext();
        this.zTt = (WeImageView) this.lJI.findViewById(R.id.fol);
        WeImageView weImageView = this.zTt;
        if (weImageView != null) {
            weImageView.setBackground(ar.m(this.context, R.raw.icons_filled_call, Color.parseColor("#07C160")));
        }
        WeImageView weImageView2 = this.zTt;
        if (weImageView2 != null) {
            weImageView2.setIconColor(Color.parseColor("#07C160"));
        }
        WeImageView weImageView3 = this.zTt;
        if (weImageView3 != null) {
            weImageView3.setVisibility(0);
            AppMethodBeat.o(239805);
            return;
        }
        AppMethodBeat.o(239805);
    }

    public final Integer eoH() {
        AppMethodBeat.i(239804);
        Integer valueOf = Integer.valueOf(this.lJI.getVisibility());
        AppMethodBeat.o(239804);
        return valueOf;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView$doAnimationShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ j zTv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(j jVar) {
            this.zTv = jVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(239803);
            this.zTv.lJI.setAlpha(1.0f);
            AppMethodBeat.o(239803);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView$doAnimationHide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
    public static final class a implements Animator.AnimatorListener {
        final /* synthetic */ j zTv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(j jVar) {
            this.zTv = jVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(239802);
            this.zTv.lJI.setVisibility(4);
            AppMethodBeat.o(239802);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }
}
