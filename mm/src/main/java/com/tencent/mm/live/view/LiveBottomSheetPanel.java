package com.tencent.mm.live.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.RelativeLayout;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b;
import com.tencent.mm.plugin.appbrand.jsapi.p.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 92\u00020\u0001:\u00019B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ*\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000fH\u0016J,\u0010&\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010)H\u0016J2\u0010*\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0016J$\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u00101\u001a\u00020\tH\u0016J\u0012\u00102\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u00010!H\u0016J\u0010\u00103\u001a\u00020\u00152\b\u00104\u001a\u0004\u0018\u000105J\u000e\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020!J\b\u00108\u001a\u00020\u0015H\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", TencentLocation.EXTRA_DIRECTION, "fling", "", "onVisibilityListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShow", "", "getOnVisibilityListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityListener", "(Lkotlin/jvm/functions/Function1;)V", "totalConsumed", MessengerShareContentUtility.SHARE_BUTTON_HIDE, e.NAME, "window", "Landroid/view/Window;", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "child", "nestedScrollAxes", "onStopNestedScroll", "setContentBg", "background", "Landroid/graphics/drawable/Drawable;", "setContentView", "contentView", "show", "Companion", "plugin-logic_release"})
public class LiveBottomSheetPanel extends RelativeLayout {
    public static final a hWz = new a((byte) 0);
    private final String TAG;
    private int direction;
    private int hWw;
    private boolean hWx;
    private kotlin.g.a.b<? super Boolean, x> hWy;

    static {
        AppMethodBeat.i(208562);
        AppMethodBeat.o(208562);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveBottomSheetPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(208560);
        this.TAG = "MicroMsg.LiveBottomSheetPanel";
        this.direction = 1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.LiveBottomSheetPanel);
            p.g(obtainStyledAttributes, "context.obtainStyledAttr…ble.LiveBottomSheetPanel)");
            this.direction = obtainStyledAttributes.getInt(0, 1);
            obtainStyledAttributes.recycle();
        }
        View.inflate(context, R.layout.b0k, this);
        AppMethodBeat.o(208560);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/live/view/LiveBottomSheetPanel$Companion;", "", "()V", "DIRECTION_HORIZONTAL", "", "DIRECTION_VERTICAL", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LiveBottomSheetPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(208561);
        AppMethodBeat.o(208561);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x>, kotlin.g.a.b<java.lang.Boolean, kotlin.x> */
    public final kotlin.g.a.b<Boolean, x> getOnVisibilityListener() {
        return this.hWy;
    }

    public final void setOnVisibilityListener(kotlin.g.a.b<? super Boolean, x> bVar) {
        this.hWy = bVar;
    }

    public final void setContentView(View view) {
        AppMethodBeat.i(208550);
        p.h(view, "contentView");
        addView(view);
        AppMethodBeat.o(208550);
    }

    public final void setContentBg(Drawable drawable) {
        AppMethodBeat.i(208551);
        setBackground(drawable);
        AppMethodBeat.o(208551);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ LiveBottomSheetPanel hWA;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(LiveBottomSheetPanel liveBottomSheetPanel) {
            this.hWA = liveBottomSheetPanel;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(208548);
            kotlin.g.a.b<Boolean, x> onVisibilityListener = this.hWA.getOnVisibilityListener();
            if (onVisibilityListener != null) {
                onVisibilityListener.invoke(Boolean.FALSE);
                AppMethodBeat.o(208548);
                return;
            }
            AppMethodBeat.o(208548);
        }
    }

    public void hide() {
        AppMethodBeat.i(208552);
        if (this.direction == 0) {
            animate().translationX((float) au.az(getContext()).x).setListener(new b(this)).start();
            AppMethodBeat.o(208552);
            return;
        }
        animate().translationY((float) au.az(getContext()).y).setListener(new c(this)).start();
        AppMethodBeat.o(208552);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ LiveBottomSheetPanel hWA;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(LiveBottomSheetPanel liveBottomSheetPanel) {
            this.hWA = liveBottomSheetPanel;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(208549);
            kotlin.g.a.b<Boolean, x> onVisibilityListener = this.hWA.getOnVisibilityListener();
            if (onVisibilityListener != null) {
                onVisibilityListener.invoke(Boolean.FALSE);
                AppMethodBeat.o(208549);
                return;
            }
            AppMethodBeat.o(208549);
        }
    }

    public void show() {
        Window window = null;
        AppMethodBeat.i(208553);
        kotlin.g.a.b<? super Boolean, x> bVar = this.hWy;
        if (bVar != null) {
            bVar.invoke(Boolean.TRUE);
        }
        if (this.direction == 0) {
            animate().setListener(null).translationX(0.0f).start();
            Context context = getContext();
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null) {
                window = activity.getWindow();
            }
            b(window);
            AppMethodBeat.o(208553);
            return;
        }
        animate().setListener(null).translationY(0.0f).start();
        AppMethodBeat.o(208553);
    }

    public static void b(Window window) {
        AppMethodBeat.i(208554);
        if (window != null) {
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            decorView.setSystemUiVisibility(7942);
        }
        AppMethodBeat.o(208554);
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        AppMethodBeat.i(208555);
        Log.d(this.TAG, "onStartNestedScroll");
        this.hWw = 0;
        this.hWx = false;
        if ((i2 & 2) != 0) {
            AppMethodBeat.o(208555);
            return true;
        }
        AppMethodBeat.o(208555);
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        AppMethodBeat.i(208556);
        Log.d(this.TAG, "onNestedPreScroll target:" + view + " dx:" + i2 + " dy:" + i3);
        AppMethodBeat.o(208556);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(208557);
        Log.d(this.TAG, "onNestedScroll target:" + view + " dxConsumed:" + i2 + " dyConsumed:" + i3 + " dxUnconsumed:" + i4 + " dyUnconsumed:" + i5);
        if (this.direction == 0) {
            this.hWw += i4;
            setTranslationX(j.aJ((float) au.az(getContext()).x, j.aI(0.0f, getTranslationX() - ((float) i4))));
            AppMethodBeat.o(208557);
            return;
        }
        this.hWw += i5;
        setTranslationY(j.aJ((float) au.az(getContext()).y, j.aI(0.0f, getTranslationY() - ((float) i5))));
        AppMethodBeat.o(208557);
    }

    public void onStopNestedScroll(View view) {
        AppMethodBeat.i(208558);
        if (!this.hWx) {
            if (this.hWw > 0) {
                show();
            } else if (this.hWw < 0) {
                hide();
            }
        }
        Log.d(this.TAG, "onStopNestedScroll child:" + view + ", totalConsumed:" + this.hWw);
        this.hWw = 0;
        this.hWx = false;
        AppMethodBeat.o(208558);
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        AppMethodBeat.i(208559);
        Log.d(this.TAG, "onNestedFling velocityX:" + f2 + " velocityY:" + f3 + " ViewConfiguration.getMinimumFlingVelocity():" + ViewConfiguration.getMinimumFlingVelocity());
        if (f3 > 0.0f) {
            this.hWx = true;
            show();
        } else if (f3 > 0.0f) {
            this.hWx = true;
            hide();
        }
        boolean onNestedFling = super.onNestedFling(view, f2, f3, z);
        AppMethodBeat.o(208559);
        return onNestedFling;
    }
}
