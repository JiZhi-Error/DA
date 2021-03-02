package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 )2\u00020\u0001:\u0001)B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0006\u0010\u001b\u001a\u00020\fJ\u0006\u0010\u001c\u001a\u00020\u0018J&\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tJ\b\u0010\"\u001a\u00020\fH\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\fH\u0002J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\fJ\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper;", "", "bottomNavigator", "Landroid/view/View;", "root", "webview", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Landroid/view/View;Landroid/view/View;Lcom/tencent/mm/ui/widget/MMWebView;)V", "MIN_TRIGGER_HEIGHT", "", "bottomBarHeight", "currentShow", "", "deviceShowBottomNav", "Ljava/lang/Boolean;", "isXWeb", "startScrollTime", "", "startScrollY", "getWebview", "()Lcom/tencent/mm/ui/widget/MMWebView;", "setWebview", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "hideBottomNavigator", "", "huaweiNeedShowBottomNavigator", "miuiNeedShowBottomNavigator", "needShowBottomNavigator", "onDestroy", "onWebViewScrollChanged", "l", "t", "oldl", "oldt", "oppoNeedShowBottomNavigator", "setBottomNavigatorPos", "show", "setBottomNavigatorVisibility", "showBottom", "showBottomNavigator", "vivoNeedShowBottomNavigator", "Companion", "plugin-webview_release"})
public final class h {
    private static final long CUo = CUo;
    public static final a JfI = new a((byte) 0);
    static final String TAG = TAG;
    int JfA;
    final int JfB = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    boolean JfC;
    Boolean JfD;
    private boolean JfE;
    private int JfF;
    final View JfG;
    private MMWebView JfH;
    long Jfz;
    private final View gvQ;

    public h(View view, View view2, MMWebView mMWebView) {
        p.h(view, "bottomNavigator");
        p.h(view2, "root");
        AppMethodBeat.i(82540);
        this.JfG = view;
        this.gvQ = view2;
        this.JfH = mMWebView;
        MMWebView mMWebView2 = this.JfH;
        if (mMWebView2 != null) {
            this.JfE = mMWebView2.isXWalkKernel();
            AppMethodBeat.o(82540);
            return;
        }
        AppMethodBeat.o(82540);
    }

    public final void zi(boolean z) {
        AppMethodBeat.i(82537);
        this.JfC = z;
        if (!z) {
            geC();
            AppMethodBeat.o(82537);
            return;
        }
        geB();
        AppMethodBeat.o(82537);
    }

    /* access modifiers changed from: package-private */
    public final void geB() {
        AppMethodBeat.i(82538);
        if (this.JfG.getVisibility() == 0) {
            AppMethodBeat.o(82538);
            return;
        }
        Log.i(TAG, "showBottomNavigator");
        this.JfG.clearAnimation();
        this.JfG.animate().setDuration(CUo).translationY(0.0f).setInterpolator(new AccelerateInterpolator(2.0f)).setListener(new c(this)).start();
        AppMethodBeat.o(82538);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$showBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ h JfJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(h hVar) {
            this.JfJ = hVar;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(82535);
            this.JfJ.JfG.setVisibility(0);
            AppMethodBeat.o(82535);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(82536);
            h.a(this.JfJ, true);
            AppMethodBeat.o(82536);
        }
    }

    /* access modifiers changed from: package-private */
    public final void geC() {
        AppMethodBeat.i(82539);
        if (this.JfG.getVisibility() == 8) {
            AppMethodBeat.o(82539);
            return;
        }
        Log.i(TAG, "hideBottomNavigator");
        this.JfG.clearAnimation();
        this.JfG.animate().setDuration(CUo).translationY((float) this.JfG.getHeight()).setInterpolator(new AccelerateInterpolator(2.0f)).setListener(new b(this)).start();
        AppMethodBeat.o(82539);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$hideBottomNavigator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ h JfJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(h hVar) {
            this.JfJ = hVar;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(82533);
            h.a(this.JfJ, false);
            AppMethodBeat.o(82533);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(82534);
            this.JfJ.JfG.setVisibility(8);
            AppMethodBeat.o(82534);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewBottomNavigatorHelper$Companion;", "", "()V", "TAG", "", "animationDuration", "", "checkDeviceHasNavigationBar", "", "context", "Landroid/content/Context;", "hasNavigationBar", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean eB(Context context) {
            AppMethodBeat.i(82531);
            p.h(context, "context");
            if (Build.VERSION.SDK_INT > 28) {
                try {
                    Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
                    p.g(cls, "Class.forName(\"android.view.WindowManagerGlobal\")");
                    Method method = cls.getMethod("getWindowManagerService", new Class[0]);
                    p.g(method, "clazz.getMethod(\"getWindowManagerService\")");
                    Object invoke = method.invoke(null, new Object[0]);
                    Class<?> cls2 = invoke.getClass();
                    Class<?>[] clsArr = new Class[1];
                    Class<?> cls3 = Integer.TYPE;
                    if (cls3 == null) {
                        p.hyc();
                    }
                    clsArr[0] = cls3;
                    Method method2 = cls2.getMethod("hasNavigationBar", clsArr);
                    p.g(method2, "windowManagerClazz.getMe…lass.javaPrimitiveType!!)");
                    Method method3 = context.getClass().getMethod("getDisplayId", new Class[0]);
                    p.g(method3, "contextClazz.getMethod(\"getDisplayId\")");
                    Object invoke2 = method2.invoke(invoke, method3.invoke(context, new Object[0]));
                    if (invoke2 == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
                        AppMethodBeat.o(82531);
                        throw tVar;
                    }
                    boolean booleanValue = ((Boolean) invoke2).booleanValue();
                    AppMethodBeat.o(82531);
                    return booleanValue;
                } catch (Throwable th) {
                    Log.w(h.TAG, "checkDeviceHasNavigationBar Q ex:%s", th.getMessage());
                    AppMethodBeat.o(82531);
                    return false;
                }
            } else {
                try {
                    Class<?> cls4 = Class.forName("android.view.WindowManagerGlobal");
                    p.g(cls4, "Class.forName(\"android.view.WindowManagerGlobal\")");
                    Method method4 = cls4.getMethod("getWindowManagerService", new Class[0]);
                    p.g(method4, "clazz.getMethod(\"getWindowManagerService\")");
                    Object invoke3 = method4.invoke(null, new Object[0]);
                    Method method5 = invoke3.getClass().getMethod("hasNavigationBar", new Class[0]);
                    p.g(method5, "windowManagerClazz.getMethod(\"hasNavigationBar\")");
                    Object invoke4 = method5.invoke(invoke3, new Object[0]);
                    if (invoke4 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type kotlin.Boolean");
                        AppMethodBeat.o(82531);
                        throw tVar2;
                    }
                    boolean booleanValue2 = ((Boolean) invoke4).booleanValue();
                    AppMethodBeat.o(82531);
                    return booleanValue2;
                } catch (Throwable th2) {
                    Log.w(h.TAG, "checkDeviceHasNavigationBar ex:%s", th2.getMessage());
                    AppMethodBeat.o(82531);
                    return false;
                }
            }
        }

        public static boolean hW(Context context) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(82532);
            p.h(context, "context");
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier > 0) {
                z = resources.getBoolean(identifier);
            } else {
                z = false;
            }
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                p.g(cls, "Class.forName(\"android.os.SystemProperties\")");
                Method method = cls.getMethod("get", String.class);
                p.g(method, "systemPropertiesClass.ge…get\", String::class.java)");
                Object invoke = method.invoke(cls, "qemu.hw.mainkeys");
                if (invoke == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(82532);
                    throw tVar;
                }
                String str = (String) invoke;
                if (p.j("1", str)) {
                    z2 = false;
                } else {
                    if (p.j(AppEventsConstants.EVENT_PARAM_VALUE_NO, str)) {
                        z2 = true;
                    }
                    z2 = z;
                }
                AppMethodBeat.o(82532);
                return z2;
            } catch (Throwable th) {
                Log.w(h.TAG, "hasNavigationBar ex:%s", th.getMessage());
            }
        }
    }

    static {
        AppMethodBeat.i(82541);
        AppMethodBeat.o(82541);
    }

    public static final /* synthetic */ void a(h hVar, boolean z) {
        AppMethodBeat.i(82542);
        if (hVar.JfE) {
            if (hVar.JfF <= 0) {
                hVar.JfF = hVar.JfG.getHeight();
            }
            if (z) {
                MMWebView mMWebView = hVar.JfH;
                if (mMWebView != null) {
                    mMWebView.setBottomHeight(hVar.JfF);
                    AppMethodBeat.o(82542);
                    return;
                }
                AppMethodBeat.o(82542);
                return;
            }
            MMWebView mMWebView2 = hVar.JfH;
            if (mMWebView2 != null) {
                mMWebView2.setBottomHeight(0);
                AppMethodBeat.o(82542);
                return;
            }
            AppMethodBeat.o(82542);
            return;
        }
        if (hVar.gvQ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            View view = hVar.gvQ;
            ViewGroup.LayoutParams layoutParams = hVar.gvQ.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(82542);
                throw tVar;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (z) {
                layoutParams2.addRule(2, R.id.jkb);
            } else {
                layoutParams2.removeRule(2);
            }
            view.setLayoutParams(layoutParams2);
        }
        AppMethodBeat.o(82542);
    }
}
