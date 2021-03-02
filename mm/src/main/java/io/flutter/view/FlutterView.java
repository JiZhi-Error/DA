package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.c.g;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.c.l;
import io.flutter.embedding.engine.c.m;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.c;
import io.flutter.plugin.d.a;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.a;
import io.flutter.view.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterView extends SurfaceView implements io.flutter.plugin.a.c, a.AbstractC2254a, c {
    private final io.flutter.embedding.engine.b.a SMT;
    public FlutterNativeView SMd;
    private final io.flutter.embedding.engine.c.b SMo;
    private final DartExecutor SNW;
    public final io.flutter.embedding.engine.c.c SNZ;
    private final io.flutter.embedding.android.a SNq;
    private final io.flutter.embedding.android.b SNr;
    private final a.e SNu;
    private final io.flutter.embedding.engine.c.d SOa;
    public final f SOc;
    private final g SOe;
    private final j SOg;
    private final l SOh;
    private final AtomicLong SPC;
    private final InputMethodManager SSy;
    private final io.flutter.plugin.b.c SWl;
    private final io.flutter.plugin.c.a SWm;
    private final io.flutter.plugin.d.a SWn;
    private a SWo;
    public final SurfaceHolder.Callback SWp;
    private final d SWq;
    private final List<io.flutter.plugin.a.a> SWr;
    public final List<a> SWs;
    private boolean SWt;
    private boolean SWu;

    public interface a {
        void onFirstFrame();
    }

    public interface b {
    }

    static /* synthetic */ void a(FlutterView flutterView, boolean z, boolean z2) {
        AppMethodBeat.i(9730);
        flutterView.bl(z, z2);
        AppMethodBeat.o(9730);
    }

    /* access modifiers changed from: package-private */
    public static final class d {
        float SPH = 1.0f;
        int SPM = 0;
        int SPN = 0;
        int SPO = 0;
        int SPP = 0;
        int SWA = 0;
        int SWB = 0;
        int SWC = 0;
        int SWD = 0;
        int SWE = 0;
        int SWF = 0;
        int SWG = 0;
        int SWH = 0;
        int SWy = 0;
        int SWz = 0;

        d() {
        }
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null);
    }

    public FlutterView(Context context, AttributeSet attributeSet, FlutterNativeView flutterNativeView) {
        super(context, attributeSet);
        AppMethodBeat.i(9698);
        this.SPC = new AtomicLong(0);
        this.SWt = false;
        this.SWu = false;
        this.SNu = new a.e() {
            /* class io.flutter.view.FlutterView.AnonymousClass1 */

            @Override // io.flutter.view.a.e
            public final void bm(boolean z, boolean z2) {
                AppMethodBeat.i(9829);
                FlutterView.a(FlutterView.this, z, z2);
                AppMethodBeat.o(9829);
            }
        };
        Activity lP = lP(getContext());
        if (lP == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Bad context");
            AppMethodBeat.o(9698);
            throw illegalArgumentException;
        }
        if (flutterNativeView == null) {
            this.SMd = new FlutterNativeView(lP.getApplicationContext());
        } else {
            this.SMd = flutterNativeView;
        }
        this.SNW = this.SMd.SNW;
        this.SMT = new io.flutter.embedding.engine.b.a(this.SMd.getFlutterJNI());
        this.SWt = this.SMd.getFlutterJNI().getIsSoftwareRenderingEnabled();
        this.SWq = new d();
        this.SWq.SPH = context.getResources().getDisplayMetrics().density;
        setFocusable(true);
        setFocusableInTouchMode(true);
        FlutterNativeView flutterNativeView2 = this.SMd;
        flutterNativeView2.SMe = this;
        io.flutter.app.c cVar = flutterNativeView2.SWe;
        cVar.SMe = this;
        cVar.mActivity = lP;
        cVar.SMf.a(lP, this, getDartExecutor());
        this.SWp = new SurfaceHolder.Callback() {
            /* class io.flutter.view.FlutterView.AnonymousClass2 */

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(9799);
                FlutterView.this.assertAttached();
                FlutterView.this.SMd.getFlutterJNI().onSurfaceCreated(surfaceHolder.getSurface());
                AppMethodBeat.o(9799);
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                AppMethodBeat.i(9800);
                FlutterView.this.assertAttached();
                FlutterView.this.SMd.getFlutterJNI().onSurfaceChanged(i3, i4);
                AppMethodBeat.o(9800);
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(9801);
                FlutterView.this.assertAttached();
                FlutterView.this.SMd.getFlutterJNI().onSurfaceDestroyed();
                AppMethodBeat.o(9801);
            }
        };
        getHolder().addCallback(this.SWp);
        this.SWr = new ArrayList();
        this.SWs = new ArrayList();
        this.SOc = new f(this.SNW);
        this.SMo = new io.flutter.embedding.engine.c.b(this.SNW);
        this.SNZ = new io.flutter.embedding.engine.c.c(this.SNW);
        this.SOa = new io.flutter.embedding.engine.c.d(this.SNW);
        this.SOe = new g(this.SNW);
        this.SOh = new l(this.SNW);
        this.SOg = new j(this.SNW);
        final io.flutter.plugin.platform.b bVar = new io.flutter.plugin.platform.b(lP, this.SOe);
        this.SWr.add(new io.flutter.plugin.a.a() {
            /* class io.flutter.view.FlutterView.AnonymousClass3 */

            @Override // io.flutter.plugin.a.a
            public final void onPostResume() {
                AppMethodBeat.i(9680);
                bVar.hxp();
                AppMethodBeat.o(9680);
            }
        });
        this.SSy = (InputMethodManager) getContext().getSystemService("input_method");
        PlatformViewsController platformViewsController = this.SMd.SWe.SMf;
        this.SWl = new io.flutter.plugin.b.c(this, new m(this.SNW), platformViewsController);
        if (Build.VERSION.SDK_INT >= 24) {
            this.SWn = new io.flutter.plugin.d.a(this, new io.flutter.embedding.engine.c.e(this.SNW));
        } else {
            this.SWn = null;
        }
        this.SWm = new io.flutter.plugin.c.a(context, this.SOa);
        this.SNq = new io.flutter.embedding.android.a(this.SMo, this.SWl);
        this.SNr = new io.flutter.embedding.android.b(this.SMT, false);
        platformViewsController.b(this.SMT);
        this.SMd.SWe.SMf.SMp = this.SWl;
        this.SMd.getFlutterJNI().setLocalizationPlugin(this.SWm);
        this.SWm.j(getResources().getConfiguration());
        hxA();
        AppMethodBeat.o(9698);
    }

    private static Activity lP(Context context) {
        AppMethodBeat.i(9699);
        for (Context context2 = context; context2 != null; context2 = ((ContextWrapper) context2).getBaseContext()) {
            if (context2 instanceof Activity) {
                Activity activity = (Activity) context2;
                AppMethodBeat.o(9699);
                return activity;
            } else if (!(context2 instanceof ContextWrapper)) {
                AppMethodBeat.o(9699);
                return null;
            }
        }
        AppMethodBeat.o(9699);
        return null;
    }

    public DartExecutor getDartExecutor() {
        return this.SNW;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(9700);
        if (!isAttached()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(9700);
            return onKeyUp;
        }
        this.SNq.j(keyEvent);
        boolean onKeyUp2 = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(9700);
        return onKeyUp2;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(9701);
        if (!isAttached()) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(9701);
            return onKeyDown;
        }
        this.SNq.k(keyEvent);
        boolean onKeyDown2 = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(9701);
        return onKeyDown2;
    }

    public FlutterNativeView getFlutterNativeView() {
        return this.SMd;
    }

    public io.flutter.app.c getPluginRegistry() {
        return this.SMd.SWe;
    }

    public void onPostResume() {
        AppMethodBeat.i(9702);
        for (io.flutter.plugin.a.a aVar : this.SWr) {
            aVar.onPostResume();
        }
        this.SNZ.hxd();
        AppMethodBeat.o(9702);
    }

    public final void hxz() {
        AppMethodBeat.i(214919);
        this.SMd.getFlutterJNI().notifyLowMemoryWarning();
        this.SOh.hxj();
        AppMethodBeat.o(214919);
    }

    public void setInitialRoute(String str) {
        AppMethodBeat.i(9703);
        this.SOc.setInitialRoute(str);
        AppMethodBeat.o(9703);
    }

    private void hxA() {
        AppMethodBeat.i(9704);
        if (!isAttached()) {
            AppMethodBeat.o(9704);
            return;
        }
        this.SOg.hxi().cQ(getResources().getConfiguration().fontScale).Ez(DateFormat.is24HourFormat(getContext())).a((getResources().getConfiguration().uiMode & 48) == 32 ? j.b.dark : j.b.light).send();
        AppMethodBeat.o(9704);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(9706);
        super.onConfigurationChanged(configuration);
        this.SWm.j(configuration);
        hxA();
        AppMethodBeat.o(9706);
    }

    /* access modifiers changed from: package-private */
    public float getDevicePixelRatio() {
        return this.SWq.SPH;
    }

    public final void destroy() {
        AppMethodBeat.i(9707);
        if (!isAttached()) {
            AppMethodBeat.o(9707);
            return;
        }
        getHolder().removeCallback(this.SWp);
        this.SMd.destroy();
        this.SMd = null;
        AppMethodBeat.o(9707);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.i(9708);
        InputConnection a2 = this.SWl.a(this, editorInfo);
        AppMethodBeat.o(9708);
        return a2;
    }

    public boolean checkInputConnectionProxy(View view) {
        AppMethodBeat.i(9709);
        boolean checkInputConnectionProxy = this.SMd.SWe.SMf.checkInputConnectionProxy(view);
        AppMethodBeat.o(9709);
        return checkInputConnectionProxy;
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i2) {
        AppMethodBeat.i(214920);
        super.onProvideAutofillVirtualStructure(viewStructure, i2);
        this.SWl.a(viewStructure);
        AppMethodBeat.o(214920);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        AppMethodBeat.i(214921);
        this.SWl.autofill(sparseArray);
        AppMethodBeat.o(214921);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(9710);
        if (!isAttached()) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(9710);
            return onTouchEvent;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        boolean onTouchEvent2 = this.SNr.onTouchEvent(motionEvent);
        AppMethodBeat.o(9710);
        return onTouchEvent2;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(9711);
        if (!isAttached()) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            AppMethodBeat.o(9711);
            return onHoverEvent;
        }
        boolean aE = this.SWo.aE(motionEvent);
        AppMethodBeat.o(9711);
        return aE;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(9712);
        if (isAttached() && this.SNr.onGenericMotionEvent(motionEvent)) {
            AppMethodBeat.o(9712);
            return true;
        }
        boolean onGenericMotionEvent = super.onGenericMotionEvent(motionEvent);
        AppMethodBeat.o(9712);
        return onGenericMotionEvent;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(9713);
        this.SWq.SWy = i2;
        this.SWq.SWz = i3;
        hxC();
        super.onSizeChanged(i2, i3, i4, i5);
        AppMethodBeat.o(9713);
    }

    enum e {
        NONE,
        LEFT,
        RIGHT,
        BOTH;

        public static e valueOf(String str) {
            AppMethodBeat.i(214910);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(214910);
            return eVar;
        }

        static {
            AppMethodBeat.i(214911);
            AppMethodBeat.o(214911);
        }
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        boolean z;
        int i2;
        int i3;
        int systemWindowInsetBottom;
        AppMethodBeat.i(214922);
        boolean z2 = (getWindowSystemUiVisibility() & 4) != 0;
        if ((getWindowSystemUiVisibility() & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        e eVar = e.NONE;
        if (z) {
            Context context = getContext();
            int i4 = context.getResources().getConfiguration().orientation;
            int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
            if (i4 == 2) {
                if (rotation == 1) {
                    eVar = e.RIGHT;
                } else if (rotation == 3) {
                    eVar = Build.VERSION.SDK_INT >= 23 ? e.LEFT : e.RIGHT;
                } else if (rotation == 0 || rotation == 2) {
                    eVar = e.BOTH;
                }
            }
            eVar = e.NONE;
        }
        this.SWq.SWA = z2 ? 0 : windowInsets.getSystemWindowInsetTop();
        d dVar = this.SWq;
        if (eVar == e.RIGHT || eVar == e.BOTH) {
            i2 = 0;
        } else {
            i2 = windowInsets.getSystemWindowInsetRight();
        }
        dVar.SWB = i2;
        this.SWq.SWC = 0;
        d dVar2 = this.SWq;
        if (eVar == e.LEFT || eVar == e.BOTH) {
            i3 = 0;
        } else {
            i3 = windowInsets.getSystemWindowInsetLeft();
        }
        dVar2.SWD = i3;
        this.SWq.SWE = 0;
        this.SWq.SWF = 0;
        d dVar3 = this.SWq;
        if (z) {
            systemWindowInsetBottom = ((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d ? 0 : windowInsets.getSystemWindowInsetBottom();
        } else {
            systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
        }
        dVar3.SWG = systemWindowInsetBottom;
        this.SWq.SWH = 0;
        if (Build.VERSION.SDK_INT >= 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.SWq.SPM = systemGestureInsets.top;
            this.SWq.SPN = systemGestureInsets.right;
            this.SWq.SPO = systemGestureInsets.bottom;
            this.SWq.SPP = systemGestureInsets.left;
        }
        hxC();
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        AppMethodBeat.o(214922);
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        AppMethodBeat.i(9714);
        if (Build.VERSION.SDK_INT <= 19) {
            this.SWq.SWA = rect.top;
            this.SWq.SWB = rect.right;
            this.SWq.SWC = 0;
            this.SWq.SWD = rect.left;
            this.SWq.SWE = 0;
            this.SWq.SWF = 0;
            this.SWq.SWG = rect.bottom;
            this.SWq.SWH = 0;
            hxC();
            AppMethodBeat.o(9714);
            return true;
        }
        boolean fitSystemWindows = super.fitSystemWindows(rect);
        AppMethodBeat.o(9714);
        return fitSystemWindows;
    }

    public final boolean isAttached() {
        AppMethodBeat.i(9715);
        if (this.SMd == null || !this.SMd.SWf.isAttached()) {
            AppMethodBeat.o(9715);
            return false;
        }
        AppMethodBeat.o(9715);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void assertAttached() {
        AppMethodBeat.i(9716);
        if (!isAttached()) {
            AssertionError assertionError = new AssertionError("Platform view is not attached");
            AppMethodBeat.o(9716);
            throw assertionError;
        }
        AppMethodBeat.o(9716);
    }

    /* access modifiers changed from: package-private */
    public final void hxB() {
        AppMethodBeat.i(9717);
        if (this.SWo != null) {
            this.SWo.reset();
        }
        AppMethodBeat.o(9717);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(9718);
        assertAttached();
        hxB();
        this.SMd.a(bVar);
        AppMethodBeat.o(9718);
    }

    public Bitmap getBitmap() {
        AppMethodBeat.i(9719);
        assertAttached();
        Bitmap bitmap = this.SMd.getFlutterJNI().getBitmap();
        AppMethodBeat.o(9719);
        return bitmap;
    }

    private void hxC() {
        AppMethodBeat.i(9720);
        if (!isAttached()) {
            AppMethodBeat.o(9720);
            return;
        }
        this.SMd.getFlutterJNI().setViewportMetrics(this.SWq.SPH, this.SWq.SWy, this.SWq.SWz, this.SWq.SWA, this.SWq.SWB, this.SWq.SWC, this.SWq.SWD, this.SWq.SWE, this.SWq.SWF, this.SWq.SWG, this.SWq.SWH, this.SWq.SPM, this.SWq.SPN, this.SWq.SPO, this.SWq.SPP);
        AppMethodBeat.o(9720);
    }

    public void onFirstFrame() {
        AppMethodBeat.i(9721);
        this.SWu = true;
        for (a aVar : new ArrayList(this.SWs)) {
            aVar.onFirstFrame();
        }
        AppMethodBeat.o(9721);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(9722);
        super.onAttachedToWindow();
        this.SWo = new a(this, new io.flutter.embedding.engine.c.a(this.SNW, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), getPluginRegistry().SMf);
        this.SWo.SNu = this.SNu;
        bl(this.SWo.nC.isEnabled(), this.SWo.nC.isTouchExplorationEnabled());
        AppMethodBeat.o(9722);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(9723);
        super.onDetachedFromWindow();
        this.SWo.release();
        this.SWo = null;
        AppMethodBeat.o(9723);
    }

    private void bl(boolean z, boolean z2) {
        boolean z3 = false;
        AppMethodBeat.i(9724);
        if (!this.SWt) {
            if (!z && !z2) {
                z3 = true;
            }
            setWillNotDraw(z3);
            AppMethodBeat.o(9724);
            return;
        }
        setWillNotDraw(false);
        AppMethodBeat.o(9724);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AppMethodBeat.i(9725);
        if (this.SWo == null || !this.SWo.nC.isEnabled()) {
            AppMethodBeat.o(9725);
            return null;
        }
        a aVar = this.SWo;
        AppMethodBeat.o(9725);
        return aVar;
    }

    @Override // io.flutter.plugin.d.a.AbstractC2254a
    @TargetApi(24)
    public final PointerIcon atp(int i2) {
        AppMethodBeat.i(214923);
        PointerIcon systemIcon = PointerIcon.getSystemIcon(getContext(), i2);
        AppMethodBeat.o(214923);
        return systemIcon;
    }

    @Override // io.flutter.plugin.a.c
    public final void a(String str, ByteBuffer byteBuffer) {
        AppMethodBeat.i(9726);
        a(str, byteBuffer, (c.b) null);
        AppMethodBeat.o(9726);
    }

    @Override // io.flutter.plugin.a.c
    public final void a(String str, ByteBuffer byteBuffer, c.b bVar) {
        AppMethodBeat.i(9727);
        if (!isAttached()) {
            AppMethodBeat.o(9727);
            return;
        }
        this.SMd.a(str, byteBuffer, bVar);
        AppMethodBeat.o(9727);
    }

    @Override // io.flutter.plugin.a.c
    public final void a(String str, c.a aVar) {
        AppMethodBeat.i(9728);
        this.SMd.a(str, aVar);
        AppMethodBeat.o(9728);
    }

    @Override // io.flutter.view.c
    public final c.a hwY() {
        AppMethodBeat.i(9729);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        c cVar = new c(this.SPC.getAndIncrement(), surfaceTexture);
        this.SMd.getFlutterJNI().registerTexture(cVar.id, surfaceTexture);
        AppMethodBeat.o(9729);
        return cVar;
    }

    final class c implements c.a {
        private SurfaceTexture.OnFrameAvailableListener SPF = new SurfaceTexture.OnFrameAvailableListener() {
            /* class io.flutter.view.FlutterView.c.AnonymousClass1 */

            public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(9682);
                if (c.this.released || FlutterView.this.SMd == null) {
                    AppMethodBeat.o(9682);
                    return;
                }
                FlutterView.this.SMd.getFlutterJNI().markTextureFrameAvailable(c.this.id);
                AppMethodBeat.o(9682);
            }
        };
        final long id;
        boolean released;
        private final SurfaceTexture surfaceTexture;

        c(long j2, SurfaceTexture surfaceTexture2) {
            AppMethodBeat.i(9779);
            this.id = j2;
            this.surfaceTexture = surfaceTexture2;
            if (Build.VERSION.SDK_INT >= 21) {
                this.surfaceTexture.setOnFrameAvailableListener(this.SPF, new Handler());
                AppMethodBeat.o(9779);
                return;
            }
            this.surfaceTexture.setOnFrameAvailableListener(this.SPF);
            AppMethodBeat.o(9779);
        }

        @Override // io.flutter.view.c.a
        public final SurfaceTexture surfaceTexture() {
            return this.surfaceTexture;
        }

        @Override // io.flutter.view.c.a
        public final long hxb() {
            return this.id;
        }

        @Override // io.flutter.view.c.a
        public final void release() {
            AppMethodBeat.i(9780);
            if (this.released) {
                AppMethodBeat.o(9780);
                return;
            }
            this.released = true;
            this.surfaceTexture.setOnFrameAvailableListener(null);
            this.surfaceTexture.release();
            FlutterView.this.SMd.getFlutterJNI().unregisterTexture(this.id);
            AppMethodBeat.o(9780);
        }
    }
}
