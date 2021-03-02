package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import io.flutter.embedding.android.g;
import io.flutter.embedding.engine.b.a;
import io.flutter.embedding.engine.c.j;
import io.flutter.plugin.d.a;
import io.flutter.view.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlutterView extends FrameLayout implements a.AbstractC2254a {
    private final io.flutter.embedding.engine.b.b SMD;
    private io.flutter.plugin.b.c SMp;
    private FlutterSurfaceView SNi;
    private FlutterTextureView SNj;
    public g SNk;
    public io.flutter.embedding.engine.b.c SNl;
    public io.flutter.embedding.engine.b.c SNm;
    public boolean SNn;
    private final Set<a> SNo;
    private io.flutter.plugin.d.a SNp;
    private a SNq;
    private b SNr;
    private io.flutter.view.a SNs;
    private final a.b SNt;
    private final a.e SNu;
    private final Set<io.flutter.embedding.engine.b.b> flutterUiDisplayListeners;
    private io.flutter.plugin.c.a localizationPlugin;
    public io.flutter.embedding.engine.a wJi;

    public interface a {
        void hrW();
    }

    static /* synthetic */ void a(FlutterView flutterView, boolean z, boolean z2) {
        AppMethodBeat.i(10008);
        flutterView.bl(z, z2);
        AppMethodBeat.o(10008);
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
        AppMethodBeat.i(215077);
        AppMethodBeat.o(215077);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(Context context, c cVar) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, cVar == c.transparent));
        AppMethodBeat.i(215078);
        AppMethodBeat.o(215078);
    }

    public FlutterView(Context context, FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
    }

    public FlutterView(Context context, FlutterTextureView flutterTextureView) {
        this(context, flutterTextureView, (byte) 0);
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
        AppMethodBeat.i(215079);
        AppMethodBeat.o(215079);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(Context context, b bVar, c cVar) {
        super(context, null);
        boolean z = true;
        AppMethodBeat.i(215080);
        this.flutterUiDisplayListeners = new HashSet();
        this.SNo = new HashSet();
        this.SNt = new a.b();
        this.SNu = new a.e() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass1 */

            @Override // io.flutter.view.a.e
            public final void bm(boolean z, boolean z2) {
                AppMethodBeat.i(10114);
                FlutterView.a(FlutterView.this, z, z2);
                AppMethodBeat.o(10114);
            }
        };
        this.SMD = new io.flutter.embedding.engine.b.b() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.b.b
            public final void dLt() {
                AppMethodBeat.i(215092);
                FlutterView.this.SNn = true;
                for (io.flutter.embedding.engine.b.b bVar : FlutterView.this.flutterUiDisplayListeners) {
                    bVar.dLt();
                }
                AppMethodBeat.o(215092);
            }

            @Override // io.flutter.embedding.engine.b.b
            public final void dLu() {
                AppMethodBeat.i(215093);
                FlutterView.this.SNn = false;
                for (io.flutter.embedding.engine.b.b bVar : FlutterView.this.flutterUiDisplayListeners) {
                    bVar.dLu();
                }
                AppMethodBeat.o(215093);
            }
        };
        if (bVar == b.surface) {
            this.SNi = new FlutterSurfaceView(context, cVar != c.transparent ? false : z);
            this.SNl = this.SNi;
        } else if (bVar == b.texture) {
            this.SNj = new FlutterTextureView(context);
            this.SNl = this.SNj;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", bVar));
            AppMethodBeat.o(215080);
            throw illegalArgumentException;
        }
        init();
        AppMethodBeat.o(215080);
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        AppMethodBeat.i(215081);
        this.flutterUiDisplayListeners = new HashSet();
        this.SNo = new HashSet();
        this.SNt = new a.b();
        this.SNu = new a.e() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass1 */

            @Override // io.flutter.view.a.e
            public final void bm(boolean z, boolean z2) {
                AppMethodBeat.i(10114);
                FlutterView.a(FlutterView.this, z, z2);
                AppMethodBeat.o(10114);
            }
        };
        this.SMD = new io.flutter.embedding.engine.b.b() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.b.b
            public final void dLt() {
                AppMethodBeat.i(215092);
                FlutterView.this.SNn = true;
                for (io.flutter.embedding.engine.b.b bVar : FlutterView.this.flutterUiDisplayListeners) {
                    bVar.dLt();
                }
                AppMethodBeat.o(215092);
            }

            @Override // io.flutter.embedding.engine.b.b
            public final void dLu() {
                AppMethodBeat.i(215093);
                FlutterView.this.SNn = false;
                for (io.flutter.embedding.engine.b.b bVar : FlutterView.this.flutterUiDisplayListeners) {
                    bVar.dLu();
                }
                AppMethodBeat.o(215093);
            }
        };
        this.SNi = flutterSurfaceView;
        this.SNl = flutterSurfaceView;
        init();
        AppMethodBeat.o(215081);
    }

    private FlutterView(Context context, FlutterTextureView flutterTextureView, byte b2) {
        super(context, null);
        AppMethodBeat.i(215082);
        this.flutterUiDisplayListeners = new HashSet();
        this.SNo = new HashSet();
        this.SNt = new a.b();
        this.SNu = new a.e() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass1 */

            @Override // io.flutter.view.a.e
            public final void bm(boolean z, boolean z2) {
                AppMethodBeat.i(10114);
                FlutterView.a(FlutterView.this, z, z2);
                AppMethodBeat.o(10114);
            }
        };
        this.SMD = new io.flutter.embedding.engine.b.b() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.b.b
            public final void dLt() {
                AppMethodBeat.i(215092);
                FlutterView.this.SNn = true;
                for (io.flutter.embedding.engine.b.b bVar : FlutterView.this.flutterUiDisplayListeners) {
                    bVar.dLt();
                }
                AppMethodBeat.o(215092);
            }

            @Override // io.flutter.embedding.engine.b.b
            public final void dLu() {
                AppMethodBeat.i(215093);
                FlutterView.this.SNn = false;
                for (io.flutter.embedding.engine.b.b bVar : FlutterView.this.flutterUiDisplayListeners) {
                    bVar.dLu();
                }
                AppMethodBeat.o(215093);
            }
        };
        this.SNj = flutterTextureView;
        this.SNl = flutterTextureView;
        init();
        AppMethodBeat.o(215082);
    }

    private void init() {
        AppMethodBeat.i(215083);
        io.flutter.a.hwd();
        if (this.SNi != null) {
            io.flutter.a.hwd();
            addView(this.SNi);
        } else if (this.SNj != null) {
            io.flutter.a.hwd();
            addView(this.SNj);
        } else {
            io.flutter.a.hwd();
            addView(this.SNk);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
        AppMethodBeat.o(215083);
    }

    public final void a(io.flutter.embedding.engine.b.b bVar) {
        AppMethodBeat.i(215084);
        this.flutterUiDisplayListeners.add(bVar);
        AppMethodBeat.o(215084);
    }

    public final void b(io.flutter.embedding.engine.b.b bVar) {
        AppMethodBeat.i(215085);
        this.flutterUiDisplayListeners.remove(bVar);
        AppMethodBeat.o(215085);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(9989);
        super.onConfigurationChanged(configuration);
        if (this.wJi != null) {
            io.flutter.a.hwd();
            this.localizationPlugin.j(configuration);
            hwB();
        }
        AppMethodBeat.o(9989);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(9990);
        super.onSizeChanged(i2, i3, i4, i5);
        new StringBuilder("Size changed. Sending Flutter new viewport metrics. FlutterView was ").append(i4).append(" x ").append(i5).append(", it is now ").append(i2).append(" x ").append(i3);
        io.flutter.a.hwd();
        this.SNt.width = i2;
        this.SNt.height = i3;
        hwC();
        AppMethodBeat.o(9990);
    }

    enum d {
        NONE,
        LEFT,
        RIGHT,
        BOTH;

        public static d valueOf(String str) {
            AppMethodBeat.i(215031);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(215031);
            return dVar;
        }

        static {
            AppMethodBeat.i(215032);
            AppMethodBeat.o(215032);
        }
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        boolean z;
        int i2;
        int i3;
        int systemWindowInsetBottom;
        AppMethodBeat.i(215086);
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        boolean z2 = (getWindowSystemUiVisibility() & 4) != 0;
        if ((getWindowSystemUiVisibility() & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        d dVar = d.NONE;
        if (z) {
            Context context = getContext();
            int i4 = context.getResources().getConfiguration().orientation;
            int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
            if (i4 == 2) {
                if (rotation == 1) {
                    dVar = d.RIGHT;
                } else if (rotation == 3) {
                    dVar = Build.VERSION.SDK_INT >= 23 ? d.LEFT : d.RIGHT;
                } else if (rotation == 0 || rotation == 2) {
                    dVar = d.BOTH;
                }
            }
            dVar = d.NONE;
        }
        this.SNt.paddingTop = z2 ? 0 : windowInsets.getSystemWindowInsetTop();
        a.b bVar = this.SNt;
        if (dVar == d.RIGHT || dVar == d.BOTH) {
            i2 = 0;
        } else {
            i2 = windowInsets.getSystemWindowInsetRight();
        }
        bVar.paddingRight = i2;
        this.SNt.paddingBottom = 0;
        a.b bVar2 = this.SNt;
        if (dVar == d.LEFT || dVar == d.BOTH) {
            i3 = 0;
        } else {
            i3 = windowInsets.getSystemWindowInsetLeft();
        }
        bVar2.paddingLeft = i3;
        this.SNt.SPI = 0;
        this.SNt.SPJ = 0;
        a.b bVar3 = this.SNt;
        if (z) {
            systemWindowInsetBottom = ((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d ? 0 : windowInsets.getSystemWindowInsetBottom();
        } else {
            systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
        }
        bVar3.SPK = systemWindowInsetBottom;
        this.SNt.SPL = 0;
        if (Build.VERSION.SDK_INT >= 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.SNt.SPM = systemGestureInsets.top;
            this.SNt.SPN = systemGestureInsets.right;
            this.SNt.SPO = systemGestureInsets.bottom;
            this.SNt.SPP = systemGestureInsets.left;
        }
        new StringBuilder("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ").append(this.SNt.paddingTop).append(", Left: ").append(this.SNt.paddingLeft).append(", Right: ").append(this.SNt.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.SNt.SPK).append(", Left: ").append(this.SNt.SPL).append(", Right: ").append(this.SNt.SPJ).append("System Gesture Insets - Left: ").append(this.SNt.SPP).append(", Top: ").append(this.SNt.SPM).append(", Right: ").append(this.SNt.SPN).append(", Bottom: ").append(this.SNt.SPK);
        io.flutter.a.hwd();
        hwC();
        AppMethodBeat.o(215086);
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        AppMethodBeat.i(9991);
        if (Build.VERSION.SDK_INT <= 19) {
            this.SNt.paddingTop = rect.top;
            this.SNt.paddingRight = rect.right;
            this.SNt.paddingBottom = 0;
            this.SNt.paddingLeft = rect.left;
            this.SNt.SPI = 0;
            this.SNt.SPJ = 0;
            this.SNt.SPK = rect.bottom;
            this.SNt.SPL = 0;
            new StringBuilder("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ").append(this.SNt.paddingTop).append(", Left: ").append(this.SNt.paddingLeft).append(", Right: ").append(this.SNt.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.SNt.SPK).append(", Left: ").append(this.SNt.SPL).append(", Right: ").append(this.SNt.SPJ);
            io.flutter.a.hwd();
            hwC();
            AppMethodBeat.o(9991);
            return true;
        }
        boolean fitSystemWindows = super.fitSystemWindows(rect);
        AppMethodBeat.o(9991);
        return fitSystemWindows;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.i(9992);
        if (!hwA()) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            AppMethodBeat.o(9992);
            return onCreateInputConnection;
        }
        InputConnection a2 = this.SMp.a(this, editorInfo);
        AppMethodBeat.o(9992);
        return a2;
    }

    public boolean checkInputConnectionProxy(View view) {
        AppMethodBeat.i(9993);
        if (this.wJi != null) {
            boolean checkInputConnectionProxy = this.wJi.platformViewsController.checkInputConnectionProxy(view);
            AppMethodBeat.o(9993);
            return checkInputConnectionProxy;
        }
        boolean checkInputConnectionProxy2 = super.checkInputConnectionProxy(view);
        AppMethodBeat.o(9993);
        return checkInputConnectionProxy2;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(9994);
        if (!hwA()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(9994);
            return onKeyUp;
        }
        this.SNq.j(keyEvent);
        boolean onKeyUp2 = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(9994);
        return onKeyUp2;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(9995);
        if (!hwA()) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(9995);
            return onKeyDown;
        }
        this.SNq.k(keyEvent);
        boolean onKeyDown2 = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(9995);
        return onKeyDown2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(9996);
        if (!hwA()) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(9996);
            return onTouchEvent;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        boolean onTouchEvent2 = this.SNr.onTouchEvent(motionEvent);
        AppMethodBeat.o(9996);
        return onTouchEvent2;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(9997);
        if (hwA() && this.SNr.onGenericMotionEvent(motionEvent)) {
            AppMethodBeat.o(9997);
            return true;
        }
        boolean onGenericMotionEvent = super.onGenericMotionEvent(motionEvent);
        AppMethodBeat.o(9997);
        return onGenericMotionEvent;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(9998);
        if (!hwA()) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            AppMethodBeat.o(9998);
            return onHoverEvent;
        }
        boolean aE = this.SNs.aE(motionEvent);
        AppMethodBeat.o(9998);
        return aE;
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AppMethodBeat.i(9999);
        if (this.SNs == null || !this.SNs.nC.isEnabled()) {
            AppMethodBeat.o(9999);
            return null;
        }
        io.flutter.view.a aVar = this.SNs;
        AppMethodBeat.o(9999);
        return aVar;
    }

    private void bl(boolean z, boolean z2) {
        boolean z3 = false;
        AppMethodBeat.i(10000);
        if (!this.wJi.SMr.SNV.getIsSoftwareRenderingEnabled()) {
            if (!z && !z2) {
                z3 = true;
            }
            setWillNotDraw(z3);
            AppMethodBeat.o(10000);
            return;
        }
        setWillNotDraw(false);
        AppMethodBeat.o(10000);
    }

    @Override // io.flutter.plugin.d.a.AbstractC2254a
    @TargetApi(24)
    public final PointerIcon atp(int i2) {
        AppMethodBeat.i(215087);
        PointerIcon systemIcon = PointerIcon.getSystemIcon(getContext(), i2);
        AppMethodBeat.o(215087);
        return systemIcon;
    }

    public final void d(io.flutter.embedding.engine.a aVar) {
        AppMethodBeat.i(10001);
        new StringBuilder("Attaching to a FlutterEngine: ").append(aVar);
        io.flutter.a.hwd();
        if (hwA()) {
            if (aVar == this.wJi) {
                io.flutter.a.hwd();
                AppMethodBeat.o(10001);
                return;
            }
            io.flutter.a.hwd();
            hwy();
        }
        this.wJi = aVar;
        io.flutter.embedding.engine.b.a aVar2 = this.wJi.SMr;
        this.SNn = aVar2.SPD;
        this.SNl.a(aVar2);
        aVar2.addIsDisplayingFlutterUiListener(this.SMD);
        if (Build.VERSION.SDK_INT >= 24) {
            this.SNp = new io.flutter.plugin.d.a(this, this.wJi.SOb);
        }
        this.SMp = new io.flutter.plugin.b.c(this, this.wJi.SOi, this.wJi.platformViewsController);
        this.localizationPlugin = this.wJi.localizationPlugin;
        this.SNq = new a(this.wJi.SMo, this.SMp);
        this.SNr = new b(this.wJi.SMr, false);
        this.SNs = new io.flutter.view.a(this, aVar.SNY, (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.wJi.platformViewsController);
        this.SNs.SNu = this.SNu;
        bl(this.SNs.nC.isEnabled(), this.SNs.nC.isTouchExplorationEnabled());
        this.wJi.platformViewsController.a(this.SNs);
        this.wJi.platformViewsController.b(this.wJi.SMr);
        this.SMp.SSy.restartInput(this);
        hwB();
        this.localizationPlugin.j(getResources().getConfiguration());
        hwC();
        aVar.platformViewsController.hS(this);
        for (a aVar3 : this.SNo) {
            aVar3.hrW();
        }
        if (this.SNn) {
            this.SMD.dLt();
        }
        AppMethodBeat.o(10001);
    }

    public final void hwy() {
        AppMethodBeat.i(10002);
        new StringBuilder("Detaching from a FlutterEngine: ").append(this.wJi);
        io.flutter.a.hwd();
        if (!hwA()) {
            io.flutter.a.hwd();
            AppMethodBeat.o(10002);
            return;
        }
        Iterator<a> it = this.SNo.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.wJi.platformViewsController.hxr();
        this.wJi.platformViewsController.hxq();
        this.SNs.release();
        this.SNs = null;
        this.SMp.SSy.restartInput(this);
        this.SMp.destroy();
        io.flutter.embedding.engine.b.a aVar = this.wJi.SMr;
        this.SNn = false;
        aVar.removeIsDisplayingFlutterUiListener(this.SMD);
        aVar.hwZ();
        aVar.hxa();
        this.SNl.hwu();
        this.SNk = null;
        this.SNm = null;
        this.wJi = null;
        AppMethodBeat.o(10002);
    }

    public final void hwz() {
        AppMethodBeat.i(215088);
        this.SNl.pause();
        if (this.SNk == null) {
            this.SNk = new g(getContext(), getWidth(), getHeight(), g.a.background);
            addView(this.SNk);
        } else {
            this.SNk.mS(getWidth(), getHeight());
        }
        this.SNm = this.SNl;
        this.SNl = this.SNk;
        if (this.wJi != null) {
            this.SNl.a(this.wJi.SMr);
        }
        AppMethodBeat.o(215088);
    }

    public final boolean hwA() {
        AppMethodBeat.i(ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL);
        if (this.wJi == null || this.wJi.SMr != this.SNl.getAttachedRenderer()) {
            AppMethodBeat.o(ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL);
            return false;
        }
        AppMethodBeat.o(ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL);
        return true;
    }

    public io.flutter.embedding.engine.a getAttachedFlutterEngine() {
        return this.wJi;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL);
        this.SNo.add(aVar);
        AppMethodBeat.o(ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(215089);
        this.SNo.remove(aVar);
        AppMethodBeat.o(215089);
    }

    private void hwB() {
        AppMethodBeat.i(10006);
        this.wJi.SOg.hxi().cQ(getResources().getConfiguration().fontScale).Ez(DateFormat.is24HourFormat(getContext())).a((getResources().getConfiguration().uiMode & 48) == 32 ? j.b.dark : j.b.light).send();
        AppMethodBeat.o(10006);
    }

    private void hwC() {
        AppMethodBeat.i(CdnLogic.kMediaTypeFavoriteBigFile);
        if (!hwA()) {
            io.flutter.a.hwf();
            AppMethodBeat.o(CdnLogic.kMediaTypeFavoriteBigFile);
            return;
        }
        this.SNt.SPH = getResources().getDisplayMetrics().density;
        this.wJi.SMr.a(this.SNt);
        AppMethodBeat.o(CdnLogic.kMediaTypeFavoriteBigFile);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i2) {
        AppMethodBeat.i(215090);
        super.onProvideAutofillVirtualStructure(viewStructure, i2);
        this.SMp.a(viewStructure);
        AppMethodBeat.o(215090);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        AppMethodBeat.i(215091);
        this.SMp.autofill(sparseArray);
        AppMethodBeat.o(215091);
    }

    @Deprecated
    public enum b {
        surface,
        texture,
        image;

        public static b valueOf(String str) {
            AppMethodBeat.i(10023);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(10023);
            return bVar;
        }

        static {
            AppMethodBeat.i(10024);
            AppMethodBeat.o(10024);
        }
    }

    @Deprecated
    public enum c {
        opaque,
        transparent;

        public static c valueOf(String str) {
            AppMethodBeat.i(9961);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(9961);
            return cVar;
        }

        static {
            AppMethodBeat.i(9962);
            AppMethodBeat.o(9962);
        }
    }
}
