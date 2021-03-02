package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.plugin.voip.widget.a;
import com.tencent.mm.plugin.voip.widget.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eJ\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u0011J\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\tJ\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010%\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010'R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/voip/ui/VoipViewFragment;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioView", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "mIsVideoTalking", "", "videoView", "doAnimator", "", "isSwitchToVideo", "getCurrentView", "getSmallView", "isVideo", "isSwitch", "initAudioView", "initVideoView", "onBadNetTipShow", "show", "onHangupHappened", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onStartRecordFailed", "refreshMiniView", "setVoicePlayDevice", "device", "switchToVideo", "switchToVoice", "updateText", "text", "", ch.COL_UPDATETIME, "plugin-voip_release"})
public final class VoipViewFragment extends FrameLayout {
    public BaseSmallView HfB;
    public BaseSmallView HfC;
    private boolean HfD;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VoipViewFragment(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(235987);
        AppMethodBeat.o(235987);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VoipViewFragment(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(235988);
        AppMethodBeat.o(235988);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoipViewFragment(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c cVar;
        p.h(context, "context");
        AppMethodBeat.i(235989);
        if (g.fKe()) {
            cVar = new a(MMApplicationContext.getContext());
        } else {
            cVar = new c(MMApplicationContext.getContext());
        }
        this.HfC = cVar;
        this.HfB = new f(MMApplicationContext.getContext());
        BaseSmallView baseSmallView = this.HfB;
        if (baseSmallView != null) {
            baseSmallView.setVisibility(8);
        }
        BaseSmallView baseSmallView2 = this.HfC;
        if (baseSmallView2 != null) {
            baseSmallView2.setVisibility(8);
        }
        addView(this.HfB);
        addView(this.HfC);
        AppMethodBeat.o(235989);
    }

    private final void xn(boolean z) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator alpha2;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator animate3;
        ViewPropertyAnimator alpha3;
        ViewPropertyAnimator duration3;
        AppMethodBeat.i(235982);
        if (z) {
            this.HfD = true;
            BaseSmallView baseSmallView = this.HfB;
            if (baseSmallView != null) {
                baseSmallView.setVisibility(0);
            }
            BaseSmallView baseSmallView2 = this.HfC;
            if (baseSmallView2 != null) {
                baseSmallView2.setVisibility(0);
            }
            BaseSmallView baseSmallView3 = this.HfC;
            if (baseSmallView3 != null) {
                baseSmallView3.setAlpha(0.0f);
            }
            BaseSmallView baseSmallView4 = this.HfB;
            if (!(baseSmallView4 == null || (animate3 = baseSmallView4.animate()) == null || (alpha3 = animate3.alpha(0.0f)) == null || (duration3 = alpha3.setDuration(300)) == null)) {
                duration3.start();
            }
            BaseSmallView baseSmallView5 = this.HfC;
            if (baseSmallView5 == null || (animate2 = baseSmallView5.animate()) == null || (alpha2 = animate2.alpha(1.0f)) == null || (duration2 = alpha2.setDuration(300)) == null) {
                AppMethodBeat.o(235982);
                return;
            }
            duration2.start();
            AppMethodBeat.o(235982);
            return;
        }
        this.HfD = false;
        BaseSmallView baseSmallView6 = this.HfC;
        if (baseSmallView6 != null) {
            baseSmallView6.setVisibility(8);
        }
        if (this.HfC != null) {
            removeView(this.HfC);
        }
        BaseSmallView baseSmallView7 = this.HfB;
        if (baseSmallView7 != null) {
            baseSmallView7.setVisibility(0);
        }
        BaseSmallView baseSmallView8 = this.HfB;
        if (baseSmallView8 != null) {
            baseSmallView8.setAlpha(0.0f);
        }
        BaseSmallView baseSmallView9 = this.HfB;
        if (baseSmallView9 == null || (animate = baseSmallView9.animate()) == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(300)) == null) {
            AppMethodBeat.o(235982);
            return;
        }
        duration.start();
        AppMethodBeat.o(235982);
    }

    public final BaseSmallView aJ(boolean z, boolean z2) {
        AppMethodBeat.i(235983);
        if (z2) {
            xn(z);
        }
        this.HfD = z;
        if (z) {
            BaseSmallView baseSmallView = this.HfC;
            if (baseSmallView != null) {
                baseSmallView.setVisibility(0);
            }
            BaseSmallView baseSmallView2 = this.HfC;
            AppMethodBeat.o(235983);
            return baseSmallView2;
        }
        BaseSmallView baseSmallView3 = this.HfB;
        if (baseSmallView3 != null) {
            baseSmallView3.setVisibility(0);
        }
        BaseSmallView baseSmallView4 = this.HfB;
        AppMethodBeat.o(235983);
        return baseSmallView4;
    }

    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(235984);
        BaseSmallView currentView = getCurrentView();
        if (currentView != null) {
            currentView.setVoicePlayDevice(i2);
            AppMethodBeat.o(235984);
            return;
        }
        AppMethodBeat.o(235984);
    }

    public final void aGx(String str) {
        AppMethodBeat.i(235985);
        BaseSmallView currentView = getCurrentView();
        if (currentView != null) {
            currentView.aGx(str);
            AppMethodBeat.o(235985);
            return;
        }
        AppMethodBeat.o(235985);
    }

    public final void aGy(String str) {
        AppMethodBeat.i(235986);
        BaseSmallView currentView = getCurrentView();
        if (currentView != null) {
            currentView.aGy(str);
            AppMethodBeat.o(235986);
            return;
        }
        AppMethodBeat.o(235986);
    }

    /* access modifiers changed from: package-private */
    public final BaseSmallView getCurrentView() {
        return this.HfD ? this.HfC : this.HfB;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
