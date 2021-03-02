package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.a.c;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class u {
    private static final AtomicInteger QH = new AtomicInteger(1);
    private static Field QI;
    private static boolean QJ;
    private static Field QK;
    private static boolean QL;
    private static WeakHashMap<View, String> QM;
    private static WeakHashMap<View, y> QN = null;
    private static Field QO;
    private static boolean QP = false;
    private static ThreadLocal<Rect> QQ;

    public interface a {
        boolean fE();
    }

    private static Rect fD() {
        if (QQ == null) {
            QQ = new ThreadLocal<>();
        }
        Rect rect = QQ.get();
        if (rect == null) {
            rect = new Rect();
            QQ.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    @Deprecated
    public static boolean n(View view, int i2) {
        return view.canScrollHorizontally(i2);
    }

    @Deprecated
    public static boolean o(View view, int i2) {
        return view.canScrollVertically(i2);
    }

    @Deprecated
    public static int S(View view) {
        return view.getOverScrollMode();
    }

    public static void a(View view, a aVar) {
        view.setAccessibilityDelegate(aVar == null ? null : aVar.getBridge());
    }

    @SuppressLint({"InlinedApi"})
    public static int T(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void U(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(8);
        }
    }

    public static boolean V(View view) {
        if (QP) {
            return false;
        }
        if (QO == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                QO = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                QP = true;
                return false;
            }
        }
        try {
            return QO.get(view) != null;
        } catch (Throwable th2) {
            QP = true;
            return false;
        }
    }

    public static boolean W(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void d(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void X(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void c(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    public static void b(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static int Y(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void p(View view, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            if (i2 == 4) {
                i2 = 2;
            }
        }
        view.setImportantForAccessibility(i2);
    }

    public static boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    @Deprecated
    public static void q(View view, int i2) {
        view.setLayerType(i2, null);
    }

    public static void a(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public static int Z(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static ViewParent aa(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getParentForAccessibility();
        }
        return view.getParent();
    }

    public static int ab(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void r(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static int ac(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static int ad(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static void d(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    @Deprecated
    public static float ae(View view) {
        return view.getTranslationY();
    }

    public static int af(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!QJ) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                QI = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            QJ = true;
        }
        if (QI != null) {
            try {
                return ((Integer) QI.get(view)).intValue();
            } catch (Exception e3) {
            }
        }
        return 0;
    }

    public static int ag(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!QL) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                QK = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            QL = true;
        }
        if (QK != null) {
            try {
                return ((Integer) QK.get(view)).intValue();
            } catch (Exception e3) {
            }
        }
        return 0;
    }

    public static y ah(View view) {
        if (QN == null) {
            QN = new WeakHashMap<>();
        }
        y yVar = QN.get(view);
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y(view);
        QN.put(view, yVar2);
        return yVar2;
    }

    @Deprecated
    public static void e(View view, float f2) {
        view.setTranslationX(f2);
    }

    @Deprecated
    public static void f(View view, float f2) {
        view.setTranslationY(f2);
    }

    @Deprecated
    public static void g(View view, float f2) {
        view.setAlpha(f2);
    }

    @Deprecated
    public static void ai(View view) {
        view.setRotation(0.0f);
    }

    @Deprecated
    public static void aj(View view) {
        view.setRotationX(0.0f);
    }

    @Deprecated
    public static void ak(View view) {
        view.setRotationY(0.0f);
    }

    @Deprecated
    public static void h(View view, float f2) {
        view.setScaleX(f2);
    }

    @Deprecated
    public static void i(View view, float f2) {
        view.setScaleY(f2);
    }

    @Deprecated
    public static void j(View view, float f2) {
        view.setPivotX(f2);
    }

    @Deprecated
    public static void k(View view, float f2) {
        view.setPivotY(f2);
    }

    public static void l(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static float al(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void m(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static float am(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (QM == null) {
            QM = new WeakHashMap<>();
        }
        QM.put(view, str);
    }

    public static String an(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        if (QM == null) {
            return null;
        }
        return QM.get(view);
    }

    public static int ao(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void ap(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean aq(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    public static void e(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, final p pVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (pVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                /* class android.support.v4.view.u.AnonymousClass1 */

                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return (WindowInsets) ac.c(pVar.a(view, ac.G(windowInsets)));
                }
            });
        }
    }

    public static ac a(View view, ac acVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return acVar;
        }
        WindowInsets windowInsets = (WindowInsets) ac.c(acVar);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(onApplyWindowInsets);
        }
        return ac.G(windowInsets);
    }

    public static ac b(View view, ac acVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return acVar;
        }
        WindowInsets windowInsets = (WindowInsets) ac.c(acVar);
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(dispatchApplyWindowInsets);
        }
        return ac.G(windowInsets);
    }

    public static boolean ar(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean as(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static ColorStateList at(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof s) {
            return ((s) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof s) {
            ((s) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode au(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof s) {
            return ((s) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof s) {
            ((s) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void av(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(true);
        } else if (view instanceof j) {
            ((j) view).setNestedScrollingEnabled(true);
        }
    }

    public static boolean aw(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof j) {
            return ((j) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static void ax(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof j) {
            ((j) view).stopNestedScroll();
        }
    }

    public static void ay(View view) {
        if (view instanceof k) {
            ((k) view).aM(1);
        }
    }

    public static boolean az(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float aA(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void n(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(f2);
        }
    }

    public static void s(View view, int i2) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect fD = fD();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                fD.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !fD.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            t(view, i2);
            if (z && fD.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(fD);
            }
        } else {
            t(view, i2);
        }
    }

    private static void t(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            aB(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                aB((View) parent);
            }
        }
    }

    public static void u(View view, int i2) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect fD = fD();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                fD.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !fD.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            v(view, i2);
            if (z && fD.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(fD);
            }
        } else {
            v(view, i2);
        }
    }

    private static void v(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            aB(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                aB((View) parent);
            }
        }
    }

    private static void aB(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void b(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static Rect aC(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean aD(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean aE(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static void w(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, 3);
        }
    }

    public static void a(View view, r rVar) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (rVar != null) {
                obj = rVar.QG;
            } else {
                obj = null;
            }
            view.setPointerIcon((PointerIcon) obj);
        }
    }

    public static Display aF(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (aD(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    static boolean b(View view, KeyEvent keyEvent) {
        int indexOfKey;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        b aG = b.aG(view);
        if (aG.QV == null || aG.QV.get() != keyEvent) {
            aG.QV = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference = null;
            SparseArray<WeakReference<View>> fF = aG.fF();
            if (keyEvent.getAction() == 1 && (indexOfKey = fF.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = fF.valueAt(indexOfKey);
                fF.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = fF.get(keyEvent.getKeyCode());
            }
            if (weakReference != null) {
                View view2 = weakReference.get();
                if (view2 != null && aD(view2)) {
                    b.aH(view2);
                }
                return true;
            }
        }
        return false;
    }

    static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        b aG = b.aG(view);
        if (keyEvent.getAction() == 0) {
            if (aG.QT != null) {
                aG.QT.clear();
            }
            if (!b.QS.isEmpty()) {
                synchronized (b.QS) {
                    if (aG.QT == null) {
                        aG.QT = new WeakHashMap<>();
                    }
                    for (int size = b.QS.size() - 1; size >= 0; size--) {
                        View view2 = b.QS.get(size).get();
                        if (view2 == null) {
                            b.QS.remove(size);
                        } else {
                            aG.QT.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                aG.QT.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View d2 = aG.d(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (d2 != null && !KeyEvent.isModifierKey(keyCode)) {
                aG.fF().put(keyCode, new WeakReference<>(d2));
            }
        }
        if (d2 != null) {
            return true;
        }
        return false;
    }

    static class b {
        static final ArrayList<WeakReference<View>> QS = new ArrayList<>();
        WeakHashMap<View, Boolean> QT = null;
        private SparseArray<WeakReference<View>> QU = null;
        WeakReference<KeyEvent> QV = null;

        b() {
        }

        /* access modifiers changed from: package-private */
        public final SparseArray<WeakReference<View>> fF() {
            if (this.QU == null) {
                this.QU = new SparseArray<>();
            }
            return this.QU;
        }

        static b aG(View view) {
            b bVar = (b) view.getTag(R.id.ihf);
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            view.setTag(R.id.ihf, bVar2);
            return bVar2;
        }

        /* access modifiers changed from: package-private */
        public final View d(View view, KeyEvent keyEvent) {
            if (this.QT == null || !this.QT.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View d2 = d(viewGroup.getChildAt(childCount), keyEvent);
                    if (d2 != null) {
                        return d2;
                    }
                }
            }
            if (!aH(view)) {
                return null;
            }
            return view;
        }

        static boolean aH(View view) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.ihg);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((a) arrayList.get(size)).fE()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void onInitializeAccessibilityNodeInfo(View view, c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.Ro);
    }
}
