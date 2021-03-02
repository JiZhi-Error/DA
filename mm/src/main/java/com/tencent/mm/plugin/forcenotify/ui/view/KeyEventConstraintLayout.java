package com.tencent.mm.plugin.forcenotify.ui.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/ui/view/KeyEventConstraintLayout;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "keyListener", "Landroid/view/View$OnKeyListener;", "scrollUpListener", "Lkotlin/Function0;", "", "startY", "", "touchSlop", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setOnKeyListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnScrollUpListener", "plugin-force-notify_release"})
public final class KeyEventConstraintLayout extends ConstraintLayout {
    private a<x> UWM;
    private float mf;
    private View.OnKeyListener oEy;
    private final int rZ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KeyEventConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(261868);
        this.rZ = ViewConfiguration.getTouchSlop();
        this.mf = -1.0f;
        AppMethodBeat.o(261868);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KeyEventConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(261869);
        AppMethodBeat.o(261869);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View.OnKeyListener onKeyListener;
        AppMethodBeat.i(261864);
        if (!(keyEvent == null || (onKeyListener = this.oEy) == null)) {
            onKeyListener.onKey(this, keyEvent.getKeyCode(), keyEvent);
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(261864);
        return dispatchKeyEvent;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a<x> aVar;
        AppMethodBeat.i(261865);
        if (motionEvent != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mf = motionEvent.getY();
                    break;
                case 1:
                    if (this.mf > 0.0f) {
                        float y = motionEvent.getY() - this.mf;
                        if (y < 0.0f && Math.abs(y) > ((float) this.rZ) && (aVar = this.UWM) != null) {
                            aVar.invoke();
                        }
                        this.mf = -1.0f;
                        break;
                    }
                    break;
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(261865);
        return dispatchTouchEvent;
    }

    public final void setOnKeyListener(View.OnKeyListener onKeyListener) {
        AppMethodBeat.i(261866);
        this.oEy = onKeyListener;
        super.setOnKeyListener(onKeyListener);
        AppMethodBeat.o(261866);
    }

    public final void setOnScrollUpListener(a<x> aVar) {
        AppMethodBeat.i(261867);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.UWM = aVar;
        AppMethodBeat.o(261867);
    }
}
