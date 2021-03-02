package com.tencent.mm.plugin.music.ui.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.BottomSheetBehavior;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H\u0002J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\tJ\u0010\u0010)\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u0010\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010\u0019J\b\u0010,\u001a\u00020#H\u0003J\u0006\u0010-\u001a\u00020#J\u0006\u0010.\u001a\u00020#R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\t8CX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mContext", "Landroid/content/Context;", "notDestroy", "", "(Landroid/content/Context;Z)V", "curLandscape", "curRotation", "", "hideNavigationFullScreen", "isLandscape", "()Z", "isShowing", "lightStatusBar", "mAnchorView", "Landroid/view/View;", "mBehavior", "Landroid/support/design/widget/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "newLandscapeStyle", "onDismissListener", "Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog$OnDismissListener;", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "rotation", "getRotation", "()I", "initView", "", "context", "onGlobalLayout", "setBottomSheetParams", "setCustomView", "resId", "setLightStatusBar", "setOnDismissListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStatusBarTransparent", "tryHide", "tryShow", "Companion", "OnDismissListener", "plugin-music_release"})
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final C1541a Aoi = new C1541a((byte) 0);
    private b Aoh;
    private ViewTreeObserver afI;
    public View lJI;
    private final Context mContext;
    private Dialog mLH;
    private BottomSheetBehavior<?> mLK;
    private boolean mLL;
    private int mLM;
    private final boolean mLO;
    private final boolean mLP;
    private View qK;
    private boolean wjM;
    private final boolean wjN = true;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog$OnDismissListener;", "", "onDismiss", "", "plugin-music_release"})
    public interface b {
    }

    static {
        AppMethodBeat.i(220034);
        AppMethodBeat.o(220034);
    }

    public a(Context context) {
        android.support.design.widget.a aVar;
        AppMethodBeat.i(220033);
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            Window window = ((Activity) this.mContext).getWindow();
            p.g(window, "mContext.window");
            View decorView = window.getDecorView();
            if (decorView == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(220033);
                throw tVar;
            }
            this.qK = ((ViewGroup) decorView).findViewById(R.id.be9);
        }
        Context context2 = this.mContext;
        if (this.mLP) {
            if (context2 == null) {
                p.hyc();
            }
            aVar = new com.tencent.mm.ui.widget.a.b(context2);
        } else {
            if (context2 == null) {
                p.hyc();
            }
            aVar = new android.support.design.widget.a(context2, R.style.fq);
        }
        this.mLH = aVar;
        this.lJI = View.inflate(context2, R.layout.bdu, null);
        this.mLL = isLandscape();
        View view = this.lJI;
        if (view != null) {
            Dialog dialog = this.mLH;
            if (dialog == null) {
                p.hyc();
            }
            dialog.setContentView(view);
            ViewParent parent = view.getParent();
            if (parent == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(220033);
                throw tVar2;
            }
            this.mLK = BottomSheetBehavior.l((View) parent);
            BottomSheetBehavior<?> bottomSheetBehavior = this.mLK;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setState(3);
            }
            BottomSheetBehavior<?> bottomSheetBehavior2 = this.mLK;
            if (bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.a(new d());
            }
            Dialog dialog2 = this.mLH;
            if (dialog2 == null) {
                p.hyc();
            }
            dialog2.setOnDismissListener(new c(this));
            AppMethodBeat.o(220033);
            return;
        }
        AppMethodBeat.o(220033);
    }

    public final void onGlobalLayout() {
        AppMethodBeat.i(220027);
        if (isShowing()) {
            View view = this.qK;
            if (view == null || (!view.isShown() && view.getVisibility() != 0)) {
                bMo();
                AppMethodBeat.o(220027);
                return;
            } else if (isShowing() && !(this.mLL == isLandscape() && this.mLM == getRotation())) {
                bMo();
            }
        }
        AppMethodBeat.o(220027);
    }

    @SuppressLint({"WrongConstant"})
    private final int getRotation() {
        AppMethodBeat.i(220028);
        int i2 = 0;
        if (this.mContext instanceof Activity) {
            Window window = ((Activity) this.mContext).getWindow();
            p.g(window, "mContext.window");
            WindowManager windowManager = window.getWindowManager();
            p.g(windowManager, "mContext.window.windowManager");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            p.g(defaultDisplay, "mContext.window.windowManager.defaultDisplay");
            i2 = defaultDisplay.getRotation();
        }
        AppMethodBeat.o(220028);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/music/ui/view/MusicHalfDialog$initView$1$1", "Landroid/support/design/widget/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-music_release"})
    public static final class d extends BottomSheetBehavior.a {
        d() {
        }

        @Override // android.support.design.widget.BottomSheetBehavior.a
        public final void f(View view, int i2) {
            AppMethodBeat.i(220025);
            p.h(view, "bottomSheet");
            AppMethodBeat.o(220025);
        }

        @Override // android.support.design.widget.BottomSheetBehavior.a
        public final void m(View view) {
            AppMethodBeat.i(220026);
            p.h(view, "bottomSheet");
            AppMethodBeat.o(220026);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss", "com/tencent/mm/plugin/music/ui/view/MusicHalfDialog$initView$1$2"})
    static final class c implements DialogInterface.OnDismissListener {
        final /* synthetic */ a Aoj;

        c(a aVar) {
            this.Aoj = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(220024);
            if (this.Aoj.afI != null) {
                ViewTreeObserver viewTreeObserver = this.Aoj.afI;
                if (viewTreeObserver == null) {
                    p.hyc();
                }
                if (!viewTreeObserver.isAlive()) {
                    a aVar = this.Aoj;
                    View view = this.Aoj.qK;
                    if (view == null) {
                        p.hyc();
                    }
                    aVar.afI = view.getViewTreeObserver();
                }
                ViewTreeObserver viewTreeObserver2 = this.Aoj.afI;
                if (viewTreeObserver2 == null) {
                    p.hyc();
                }
                viewTreeObserver2.removeGlobalOnLayoutListener(this.Aoj);
                this.Aoj.afI = null;
            }
            if (!this.Aoj.wjN) {
                this.Aoj.mLH = null;
            }
            if (this.Aoj.Aoh != null && this.Aoj.Aoh == null) {
                p.hyc();
            }
            AppMethodBeat.o(220024);
        }
    }

    public final void dGm() {
        boolean z;
        AppMethodBeat.i(220029);
        this.mLL = isLandscape();
        this.mLM = getRotation();
        if (this.mLH != null) {
            View view = this.lJI;
            if (view == null) {
                p.hyc();
            }
            ViewParent parent = view.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(220029);
                throw tVar;
            }
            ((ViewGroup) parent).setVisibility(0);
            View view2 = this.lJI;
            if (view2 == null) {
                p.hyc();
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(220029);
                throw tVar2;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (this.mLL && this.qK != null) {
                Rect rect = new Rect();
                View view3 = this.qK;
                if (view3 == null) {
                    p.hyc();
                }
                view3.getWindowVisibleDisplayFrame(rect);
                layoutParams2.width = rect.right;
            }
            View view4 = this.lJI;
            if (view4 == null) {
                p.hyc();
            }
            view4.setLayoutParams(layoutParams2);
            if (Build.VERSION.SDK_INT >= 21) {
                Dialog dialog = this.mLH;
                if (dialog == null) {
                    p.hyc();
                }
                Window window = dialog.getWindow();
                if (window == null) {
                    p.hyc();
                }
                window.addFlags(Integer.MIN_VALUE);
            }
            if (this.wjM && Build.VERSION.SDK_INT >= 23 && this.mLH != null) {
                Dialog dialog2 = this.mLH;
                if (dialog2 == null) {
                    p.hyc();
                }
                Window window2 = dialog2.getWindow();
                if (window2 == null) {
                    p.hyc();
                }
                p.g(window2, "mBottomSheetDialog!!.window!!");
                View decorView = window2.getDecorView();
                p.g(decorView, "mBottomSheetDialog!!.window!!.decorView");
                decorView.setSystemUiVisibility(9216);
                Dialog dialog3 = this.mLH;
                if (dialog3 == null) {
                    p.hyc();
                }
                Window window3 = dialog3.getWindow();
                if (window3 == null) {
                    p.hyc();
                }
                p.g(window3, "mBottomSheetDialog!!.window!!");
                window3.setStatusBarColor(0);
            }
            if (this.mLO) {
                Dialog dialog4 = this.mLH;
                if (dialog4 == null) {
                    p.hyc();
                }
                Window window4 = dialog4.getWindow();
                if (window4 == null) {
                    p.hyc();
                }
                window4.setFlags(8, 8);
                Dialog dialog5 = this.mLH;
                if (dialog5 == null) {
                    p.hyc();
                }
                Window window5 = dialog5.getWindow();
                if (window5 == null) {
                    p.hyc();
                }
                window5.addFlags(131200);
                Dialog dialog6 = this.mLH;
                if (dialog6 == null) {
                    p.hyc();
                }
                Window window6 = dialog6.getWindow();
                if (window6 == null) {
                    p.hyc();
                }
                p.g(window6, "mBottomSheetDialog!!.window!!");
                View decorView2 = window6.getDecorView();
                p.g(decorView2, "mBottomSheetDialog!!.window!!.decorView");
                decorView2.setSystemUiVisibility(6);
            } else {
                Dialog dialog7 = this.mLH;
                if (dialog7 == null) {
                    p.hyc();
                }
                Window window7 = dialog7.getWindow();
                if (window7 == null) {
                    p.hyc();
                }
                window7.clearFlags(8);
                Dialog dialog8 = this.mLH;
                if (dialog8 == null) {
                    p.hyc();
                }
                Window window8 = dialog8.getWindow();
                if (window8 == null) {
                    p.hyc();
                }
                window8.clearFlags(131072);
                Dialog dialog9 = this.mLH;
                if (dialog9 == null) {
                    p.hyc();
                }
                Window window9 = dialog9.getWindow();
                if (window9 == null) {
                    p.hyc();
                }
                window9.clearFlags(128);
                Dialog dialog10 = this.mLH;
                if (dialog10 == null) {
                    p.hyc();
                }
                Window window10 = dialog10.getWindow();
                if (window10 == null) {
                    p.hyc();
                }
                p.g(window10, "mBottomSheetDialog!!.window!!");
                View decorView3 = window10.getDecorView();
                p.g(decorView3, "mBottomSheetDialog!!.window!!.decorView");
                decorView3.setSystemUiVisibility(0);
            }
            if (this.qK != null) {
                if (this.afI == null) {
                    z = true;
                } else {
                    z = false;
                }
                View view5 = this.qK;
                if (view5 == null) {
                    p.hyc();
                }
                this.afI = view5.getViewTreeObserver();
                if (z) {
                    ViewTreeObserver viewTreeObserver = this.afI;
                    if (viewTreeObserver == null) {
                        p.hyc();
                    }
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                }
            }
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing()) {
                Dialog dialog11 = this.mLH;
                if (dialog11 == null) {
                    p.hyc();
                }
                dialog11.show();
            }
            if (this.mLK != null) {
                BottomSheetBehavior<?> bottomSheetBehavior = this.mLK;
                if (bottomSheetBehavior == null) {
                    p.hyc();
                }
                bottomSheetBehavior.u(false);
            }
        }
        AppMethodBeat.o(220029);
    }

    public final void bMo() {
        AppMethodBeat.i(220030);
        if (this.mLH != null) {
            if (!(this.mContext instanceof Activity)) {
                Dialog dialog = this.mLH;
                if (dialog == null) {
                    p.hyc();
                }
                dialog.dismiss();
            } else if (this.mContext != null && !((Activity) this.mContext).isFinishing() && !((Activity) this.mContext).isDestroyed()) {
                Dialog dialog2 = this.mLH;
                if (dialog2 == null) {
                    p.hyc();
                }
                dialog2.dismiss();
            }
            if (this.mLK != null) {
                BottomSheetBehavior<?> bottomSheetBehavior = this.mLK;
                if (bottomSheetBehavior == null) {
                    p.hyc();
                }
                bottomSheetBehavior.u(true);
            }
        }
        AppMethodBeat.o(220030);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(220031);
        if (this.mLH != null) {
            Dialog dialog = this.mLH;
            if (dialog == null) {
                p.hyc();
            }
            if (dialog.isShowing()) {
                AppMethodBeat.o(220031);
                return true;
            }
        }
        AppMethodBeat.o(220031);
        return false;
    }

    private final boolean isLandscape() {
        AppMethodBeat.i(220032);
        Context context = this.mContext;
        if (context == null) {
            p.hyc();
        }
        Resources resources = context.getResources();
        p.g(resources, "mContext!!.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.o(220032);
            return true;
        }
        AppMethodBeat.o(220032);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog$Companion;", "", "()V", "TAG", "", "plugin-music_release"})
    /* renamed from: com.tencent.mm.plugin.music.ui.view.a$a  reason: collision with other inner class name */
    public static final class C1541a {
        private C1541a() {
        }

        public /* synthetic */ C1541a(byte b2) {
            this();
        }
    }
}
