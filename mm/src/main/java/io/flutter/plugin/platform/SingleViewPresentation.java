package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* access modifiers changed from: package-private */
@Keep
@TargetApi(17)
public class SingleViewPresentation extends Presentation {
    private final a accessibilityEventsDelegate;
    private FrameLayout container;
    private Object createParams;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused = false;
    private e state;
    private final d viewFactory;
    private int viewId;

    /* access modifiers changed from: package-private */
    public static class e {
        f STD;
        c STF;
        b STG;

        e() {
        }
    }

    public SingleViewPresentation(Context context, Display display, d dVar, a aVar, int i2, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        super(new c(context), display);
        AppMethodBeat.i(9918);
        this.viewFactory = dVar;
        this.accessibilityEventsDelegate = aVar;
        this.viewId = i2;
        this.createParams = obj;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        this.state = new e();
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(TXLiteAVCode.EVT_AUDIO_DEVICE_ROUTE_CHANGED);
        }
        AppMethodBeat.o(9918);
    }

    public SingleViewPresentation(Context context, Display display, a aVar, e eVar, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new c(context), display);
        AppMethodBeat.i(9919);
        this.accessibilityEventsDelegate = aVar;
        this.viewFactory = null;
        this.state = eVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
        AppMethodBeat.o(9919);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(9920);
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.STG == null) {
            this.state.STG = new b(getContext());
        }
        if (this.state.STD == null) {
            this.state.STD = new f((WindowManager) getContext().getSystemService("window"), this.state.STG);
        }
        this.container = new FrameLayout(getContext());
        d dVar = new d(getContext(), this.state.STD, this.outerContext);
        if (this.state.STF == null) {
            this.state.STF = this.viewFactory.a(dVar, this.viewId, this.createParams);
        }
        View view = this.state.STF.getView();
        this.container.addView(view);
        this.rootView = new a(getContext(), this.accessibilityEventsDelegate, view);
        this.rootView.addView(this.container);
        this.rootView.addView(this.state.STG);
        view.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            view.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
        AppMethodBeat.o(9920);
    }

    public e detachState() {
        AppMethodBeat.i(9921);
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        e eVar = this.state;
        AppMethodBeat.o(9921);
        return eVar;
    }

    public c getView() {
        if (this.state.STF == null) {
            return null;
        }
        return this.state.STF;
    }

    static class b extends ViewGroup {
        private final Rect STC = new Rect();
        private final Rect cha = new Rect();

        public b(Context context) {
            super(context);
            AppMethodBeat.i(9894);
            AppMethodBeat.o(9894);
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(9895);
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.cha.set(i2, i3, i4, i5);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.cha, layoutParams.x, layoutParams.y, this.STC);
                childAt.layout(this.STC.left, this.STC.top, this.STC.right, this.STC.bottom);
            }
            AppMethodBeat.o(9895);
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            AppMethodBeat.i(9896);
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                getChildAt(i4).measure(atE(i2), atE(i3));
            }
            super.onMeasure(i2, i3);
            AppMethodBeat.o(9896);
        }

        private static int atE(int i2) {
            AppMethodBeat.i(9897);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE);
            AppMethodBeat.o(9897);
            return makeMeasureSpec;
        }
    }

    static class c extends ContextWrapper {
        private final InputMethodManager KiQ;

        c(Context context) {
            this(context, null);
        }

        private c(Context context, InputMethodManager inputMethodManager) {
            super(context);
            AppMethodBeat.i(214865);
            this.KiQ = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
            AppMethodBeat.o(214865);
        }

        @Override // android.content.Context, android.content.ContextWrapper
        public final Object getSystemService(String str) {
            AppMethodBeat.i(214866);
            if ("input_method".equals(str)) {
                InputMethodManager inputMethodManager = this.KiQ;
                AppMethodBeat.o(214866);
                return inputMethodManager;
            }
            Object systemService = super.getSystemService(str);
            AppMethodBeat.o(214866);
            return systemService;
        }

        public final Context createDisplayContext(Display display) {
            AppMethodBeat.i(214867);
            c cVar = new c(super.createDisplayContext(display), this.KiQ);
            AppMethodBeat.o(214867);
            return cVar;
        }
    }

    static class d extends ContextWrapper {
        private final f STD;
        private final Context STE;
        private WindowManager windowManager;

        d(Context context, f fVar, Context context2) {
            super(context);
            this.STD = fVar;
            this.STE = context2;
        }

        @Override // android.content.Context, android.content.ContextWrapper
        public final Object getSystemService(String str) {
            boolean z;
            AppMethodBeat.i(9933);
            if ("window".equals(str)) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int i2 = 0;
                while (true) {
                    if (i2 < stackTrace.length && i2 < 11) {
                        if (stackTrace[i2].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i2].getMethodName().equals("<init>")) {
                            z = true;
                            break;
                        }
                        i2++;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    Object systemService = this.STE.getSystemService(str);
                    AppMethodBeat.o(9933);
                    return systemService;
                }
                if (this.windowManager == null) {
                    this.windowManager = (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this.STD);
                }
                WindowManager windowManager2 = this.windowManager;
                AppMethodBeat.o(9933);
                return windowManager2;
            }
            Object systemService2 = super.getSystemService(str);
            AppMethodBeat.o(9933);
            return systemService2;
        }
    }

    static class f implements InvocationHandler {
        private final WindowManager STH;
        b STI;

        f(WindowManager windowManager, b bVar) {
            this.STH = windowManager;
            this.STI = bVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(9922);
            String name = method.getName();
            char c2 = 65535;
            switch (name.hashCode()) {
                case -1148522778:
                    if (name.equals("addView")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 542766184:
                    if (name.equals("removeViewImmediate")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 931413976:
                    if (name.equals("updateViewLayout")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1098630473:
                    if (name.equals("removeView")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (this.STI != null) {
                        this.STI.addView((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
                    }
                    AppMethodBeat.o(9922);
                    return null;
                case 1:
                    if (this.STI != null) {
                        this.STI.removeView((View) objArr[0]);
                    }
                    AppMethodBeat.o(9922);
                    return null;
                case 2:
                    if (this.STI != null) {
                        View view = (View) objArr[0];
                        view.clearAnimation();
                        this.STI.removeView(view);
                    }
                    AppMethodBeat.o(9922);
                    return null;
                case 3:
                    if (this.STI != null) {
                        this.STI.updateViewLayout((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
                    }
                    AppMethodBeat.o(9922);
                    return null;
                default:
                    try {
                        Object invoke = method.invoke(this.STH, objArr);
                        AppMethodBeat.o(9922);
                        return invoke;
                    } catch (InvocationTargetException e2) {
                        Throwable cause = e2.getCause();
                        AppMethodBeat.o(9922);
                        throw cause;
                    }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends FrameLayout {
        private final View STB;
        private final a accessibilityEventsDelegate;

        public a(Context context, a aVar, View view) {
            super(context);
            this.accessibilityEventsDelegate = aVar;
            this.STB = view;
        }

        public final boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.i(9888);
            a aVar = this.accessibilityEventsDelegate;
            View view2 = this.STB;
            if (aVar.SNs == null) {
                AppMethodBeat.o(9888);
                return false;
            }
            io.flutter.view.a aVar2 = aVar.SNs;
            if (!aVar2.STS.requestSendAccessibilityEvent(view2, view, accessibilityEvent)) {
                AppMethodBeat.o(9888);
                return false;
            }
            Integer recordFlutterId = aVar2.STS.getRecordFlutterId(view2, accessibilityEvent);
            if (recordFlutterId == null) {
                AppMethodBeat.o(9888);
                return false;
            }
            switch (accessibilityEvent.getEventType()) {
                case 8:
                    aVar2.STY = recordFlutterId;
                    aVar2.SUa = null;
                    break;
                case 128:
                    aVar2.SUc = null;
                    break;
                case 32768:
                    aVar2.STX = recordFlutterId;
                    aVar2.STW = null;
                    break;
                case 65536:
                    aVar2.STY = null;
                    aVar2.STX = null;
                    break;
            }
            AppMethodBeat.o(9888);
            return true;
        }
    }
}
