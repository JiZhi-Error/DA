package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.b;
import io.flutter.embedding.android.g;
import io.flutter.embedding.android.h;
import io.flutter.embedding.engine.c.h;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.a;
import io.flutter.plugin.b.c;
import io.flutter.plugin.platform.SingleViewPresentation;
import io.flutter.view.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PlatformViewsController implements g {
    public c SMp;
    private final h SMs = h.hwD();
    public b SNr;
    public final f STj = new f();
    public View STk;
    private io.flutter.embedding.engine.c.h STl;
    final HashMap<Integer, h> STm = new HashMap<>();
    private final HashMap<Context, View> STn = new HashMap<>();
    public final SparseArray<h.a> STo = new SparseArray<>();
    public final SparseArray<View> STp = new SparseArray<>();
    public final SparseArray<a> STq = new SparseArray<>();
    public final SparseArray<g> STr = new SparseArray<>();
    public int STs = 0;
    public boolean STt = false;
    public HashSet<Integer> STu = new HashSet<>();
    public HashSet<Integer> STv = new HashSet<>();
    private final h.d STw = new h.d() {
        /* class io.flutter.plugin.platform.PlatformViewsController.AnonymousClass1 */

        @Override // io.flutter.embedding.engine.c.h.d
        public final void a(h.a aVar) {
            AppMethodBeat.i(214860);
            atD(19);
            PlatformViewsController.this.STo.put(aVar.viewId, aVar);
            AppMethodBeat.o(214860);
        }

        @Override // io.flutter.embedding.engine.c.h.d
        public final void att(int i2) {
            AppMethodBeat.i(214861);
            if (PlatformViewsController.this.STo.get(i2) != null) {
                PlatformViewsController.this.STo.remove(i2);
            }
            View view = (View) PlatformViewsController.this.STp.get(i2);
            if (view != null) {
                a aVar = (a) PlatformViewsController.this.STq.get(i2);
                aVar.removeView(view);
                ((FlutterView) PlatformViewsController.this.STk).removeView(aVar);
                PlatformViewsController.this.STp.remove(i2);
                PlatformViewsController.this.STq.remove(i2);
            }
            AppMethodBeat.o(214861);
        }

        @Override // io.flutter.embedding.engine.c.h.d
        @TargetApi(17)
        public final long b(final h.a aVar) {
            h hVar;
            AppMethodBeat.i(214862);
            atD(20);
            if (!PlatformViewsController.atC(aVar.direction)) {
                IllegalStateException illegalStateException = new IllegalStateException("Trying to create a view with unknown direction value: " + aVar.direction + "(view id: " + aVar.viewId + ")");
                AppMethodBeat.o(214862);
                throw illegalStateException;
            } else if (PlatformViewsController.this.STm.containsKey(Integer.valueOf(aVar.viewId))) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Trying to create an already created platform view, view id: " + aVar.viewId);
                AppMethodBeat.o(214862);
                throw illegalStateException2;
            } else {
                d bts = PlatformViewsController.this.STj.bts(aVar.SQP);
                if (bts == null) {
                    IllegalStateException illegalStateException3 = new IllegalStateException("Trying to create a platform view of unregistered type: " + aVar.SQP);
                    AppMethodBeat.o(214862);
                    throw illegalStateException3;
                }
                Object obj = null;
                if (aVar.SQS != null) {
                    obj = bts.STh.J(aVar.SQS);
                }
                int a2 = PlatformViewsController.a(PlatformViewsController.this, aVar.SQQ);
                int a3 = PlatformViewsController.a(PlatformViewsController.this, aVar.SQR);
                PlatformViewsController.a(PlatformViewsController.this, a2, a3);
                c.a hwY = PlatformViewsController.this.StA.hwY();
                Context context = PlatformViewsController.this.context;
                a aVar2 = PlatformViewsController.this.accessibilityEventsDelegate;
                int i2 = aVar.viewId;
                AnonymousClass1 r7 = new View.OnFocusChangeListener() {
                    /* class io.flutter.plugin.platform.PlatformViewsController.AnonymousClass1.AnonymousClass1 */

                    public final void onFocusChange(View view, boolean z) {
                        AppMethodBeat.i(9886);
                        if (z) {
                            io.flutter.embedding.engine.c.h hVar = PlatformViewsController.this.STl;
                            int i2 = aVar.viewId;
                            if (hVar.bbv != null) {
                                hVar.bbv.a("viewFocused", Integer.valueOf(i2), null);
                            }
                        }
                        AppMethodBeat.o(9886);
                    }
                };
                hwY.surfaceTexture().setDefaultBufferSize(a2, a3);
                Surface surface = new Surface(hwY.surfaceTexture());
                VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY)).createVirtualDisplay("flutter-vd", a2, a3, context.getResources().getDisplayMetrics().densityDpi, surface, 0);
                if (createVirtualDisplay == null) {
                    hVar = null;
                } else {
                    hVar = new h(context, aVar2, createVirtualDisplay, bts, surface, hwY, r7, i2, obj);
                }
                if (hVar == null) {
                    IllegalStateException illegalStateException4 = new IllegalStateException("Failed creating virtual display for a " + aVar.SQP + " with id: " + aVar.viewId);
                    AppMethodBeat.o(214862);
                    throw illegalStateException4;
                }
                if (PlatformViewsController.this.STk != null) {
                    View unused = PlatformViewsController.this.STk;
                    hVar.hxu();
                }
                PlatformViewsController.this.STm.put(Integer.valueOf(aVar.viewId), hVar);
                View view = hVar.getView();
                view.setLayoutDirection(aVar.direction);
                PlatformViewsController.this.STn.put(view.getContext(), view);
                long hxb = hwY.hxb();
                AppMethodBeat.o(214862);
                return hxb;
            }
        }

        @Override // io.flutter.embedding.engine.c.h.d
        public final void atu(int i2) {
            AppMethodBeat.i(214863);
            atD(20);
            h hVar = PlatformViewsController.this.STm.get(Integer.valueOf(i2));
            if (hVar == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Trying to dispose a platform view with unknown id: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(214863);
                throw illegalStateException;
            }
            if (PlatformViewsController.this.SMp != null) {
                io.flutter.plugin.b.c cVar = PlatformViewsController.this.SMp;
                if (cVar.SSH.SST == c.a.EnumC2253a.PLATFORM_VIEW && cVar.SSH.id == i2) {
                    cVar.SSH = new c.a(c.a.EnumC2253a.NO_TARGET, 0);
                    cVar.hR(cVar.mView);
                    cVar.SSy.restartInput(cVar.mView);
                    cVar.SSK = false;
                }
            }
            PlatformViewsController.this.STn.remove(hVar.getView().getContext());
            hVar.dispose();
            PlatformViewsController.this.STm.remove(Integer.valueOf(i2));
            AppMethodBeat.o(214863);
        }

        @Override // io.flutter.embedding.engine.c.h.d
        public final void a(h.b bVar, final Runnable runnable) {
            AppMethodBeat.i(9900);
            atD(20);
            final h hVar = PlatformViewsController.this.STm.get(Integer.valueOf(bVar.viewId));
            if (hVar == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Trying to resize a platform view with unknown id: " + bVar.viewId);
                AppMethodBeat.o(9900);
                throw illegalStateException;
            }
            int a2 = PlatformViewsController.a(PlatformViewsController.this, bVar.SQT);
            int a3 = PlatformViewsController.a(PlatformViewsController.this, bVar.SQU);
            PlatformViewsController.a(PlatformViewsController.this, a2, a3);
            PlatformViewsController.a(PlatformViewsController.this, hVar);
            AnonymousClass2 r8 = new Runnable() {
                /* class io.flutter.plugin.platform.PlatformViewsController.AnonymousClass1.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(9931);
                    PlatformViewsController.b(PlatformViewsController.this, hVar);
                    runnable.run();
                    AppMethodBeat.o(9931);
                }
            };
            boolean isFocused = hVar.getView().isFocused();
            SingleViewPresentation.e detachState = hVar.STK.detachState();
            hVar.STJ.setSurface(null);
            hVar.STJ.release();
            hVar.hgp.surfaceTexture().setDefaultBufferSize(a2, a3);
            hVar.STJ = ((DisplayManager) hVar.context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY)).createVirtualDisplay("flutter-vd", a2, a3, hVar.densityDpi, hVar.surface, 0);
            View view = hVar.getView();
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(view, r8) {
                /* class io.flutter.plugin.platform.h.AnonymousClass1 */
                final /* synthetic */ View STL;
                final /* synthetic */ Runnable STM;

                {
                    this.STL = r2;
                    this.STM = r3;
                }

                public final void onViewAttachedToWindow(View view) {
                    AppMethodBeat.i(9892);
                    a.h(this.STL, new Runnable() {
                        /* class io.flutter.plugin.platform.h.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(9932);
                            AnonymousClass1.this.STL.postDelayed(AnonymousClass1.this.STM, 128);
                            AppMethodBeat.o(9932);
                        }
                    });
                    this.STL.removeOnAttachStateChangeListener(this);
                    AppMethodBeat.o(9892);
                }

                public final void onViewDetachedFromWindow(View view) {
                }
            });
            SingleViewPresentation singleViewPresentation = new SingleViewPresentation(hVar.context, hVar.STJ.getDisplay(), hVar.accessibilityEventsDelegate, detachState, hVar.focusChangeListener, isFocused);
            singleViewPresentation.show();
            hVar.STK.cancel();
            hVar.STK = singleViewPresentation;
            AppMethodBeat.o(9900);
        }

        @Override // io.flutter.embedding.engine.c.h.d
        public final void a(h.c cVar) {
            AppMethodBeat.i(9901);
            int i2 = cVar.viewId;
            float f2 = PlatformViewsController.this.context.getResources().getDisplayMetrics().density;
            atD(20);
            if (PlatformViewsController.this.STm.containsKey(Integer.valueOf(i2))) {
                MotionEvent a2 = PlatformViewsController.this.a(f2, cVar, true);
                h hVar = PlatformViewsController.this.STm.get(Integer.valueOf(cVar.viewId));
                if (hVar.STK != null) {
                    hVar.STK.dispatchTouchEvent(a2);
                }
                AppMethodBeat.o(9901);
            } else if (PlatformViewsController.this.STp.get(i2) != null) {
                ((View) PlatformViewsController.this.STp.get(cVar.viewId)).dispatchTouchEvent(PlatformViewsController.this.a(f2, cVar, false));
                AppMethodBeat.o(9901);
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("Sending touch to an unknown view with id: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(9901);
                throw illegalStateException;
            }
        }

        @Override // io.flutter.embedding.engine.c.h.d
        @TargetApi(17)
        public final void mT(int i2, int i3) {
            AppMethodBeat.i(9902);
            if (!PlatformViewsController.atC(i3)) {
                IllegalStateException illegalStateException = new IllegalStateException("Trying to set unknown direction value: " + i3 + "(view id: " + i2 + ")");
                AppMethodBeat.o(9902);
                throw illegalStateException;
            }
            atD(20);
            View view = PlatformViewsController.this.STm.get(Integer.valueOf(i2)).getView();
            if (view == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Sending touch to an unknown view with id: ".concat(String.valueOf(i3)));
                AppMethodBeat.o(9902);
                throw illegalStateException2;
            }
            view.setLayoutDirection(i3);
            AppMethodBeat.o(9902);
        }

        @Override // io.flutter.embedding.engine.c.h.d
        public final void atv(int i2) {
            AppMethodBeat.i(9903);
            atD(20);
            PlatformViewsController.this.STm.get(Integer.valueOf(i2)).getView().clearFocus();
            AppMethodBeat.o(9903);
        }

        private static void atD(int i2) {
            AppMethodBeat.i(214864);
            if (Build.VERSION.SDK_INT < i2) {
                IllegalStateException illegalStateException = new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + i2);
                AppMethodBeat.o(214864);
                throw illegalStateException;
            }
            AppMethodBeat.o(214864);
        }
    };
    private io.flutter.view.c StA;
    private final a accessibilityEventsDelegate = new a();
    public Context context;

    static /* synthetic */ boolean atC(int i2) {
        AppMethodBeat.i(214877);
        boolean atB = atB(i2);
        AppMethodBeat.o(214877);
        return atB;
    }

    static /* synthetic */ void l(PlatformViewsController platformViewsController) {
        AppMethodBeat.i(214882);
        platformViewsController.EA(false);
        AppMethodBeat.o(214882);
    }

    public final MotionEvent a(float f2, h.c cVar, boolean z) {
        AppMethodBeat.i(214868);
        h.a Pa = h.a.Pa(cVar.SRc);
        io.flutter.embedding.android.h hVar = this.SMs;
        while (!hVar.SNL.isEmpty() && hVar.SNL.peek().longValue() < h.a.a(Pa)) {
            hVar.SNK.remove(hVar.SNL.poll().longValue());
        }
        if (!hVar.SNL.isEmpty() && hVar.SNL.peek().longValue() == h.a.a(Pa)) {
            hVar.SNL.poll();
        }
        MotionEvent motionEvent = hVar.SNK.get(h.a.a(Pa));
        hVar.SNK.remove(h.a.a(Pa));
        ArrayList arrayList = new ArrayList();
        for (List list : (List) cVar.SQX) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = ((Integer) list.get(0)).intValue();
            pointerProperties.toolType = ((Integer) list.get(1)).intValue();
            arrayList.add(pointerProperties);
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) arrayList.toArray(new MotionEvent.PointerProperties[cVar.kyY]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) a(cVar.SQY, f2).toArray(new MotionEvent.PointerCoords[cVar.kyY]);
        if (z || motionEvent == null) {
            MotionEvent obtain = MotionEvent.obtain(cVar.SQV.longValue(), cVar.SQW.longValue(), cVar.action, cVar.kyY, pointerPropertiesArr, pointerCoordsArr, cVar.SPZ, cVar.SQZ, cVar.SRa, cVar.SRb, cVar.SPU, cVar.edgeFlags, cVar.source, cVar.flags);
            AppMethodBeat.o(214868);
            return obtain;
        }
        MotionEvent obtain2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), cVar.kyY, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        AppMethodBeat.o(214868);
        return obtain2;
    }

    public PlatformViewsController() {
        AppMethodBeat.i(9923);
        AppMethodBeat.o(9923);
    }

    public final void a(Context context2, io.flutter.view.c cVar, DartExecutor dartExecutor) {
        AppMethodBeat.i(9924);
        if (this.context != null) {
            AssertionError assertionError = new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
            AppMethodBeat.o(9924);
            throw assertionError;
        }
        this.context = context2;
        this.StA = cVar;
        this.STl = new io.flutter.embedding.engine.c.h(dartExecutor);
        this.STl.SQK = this.STw;
        AppMethodBeat.o(9924);
    }

    public final void detach() {
        this.STl.SQK = null;
        this.STl = null;
        this.context = null;
        this.StA = null;
    }

    public final void hS(View view) {
        AppMethodBeat.i(214869);
        this.STk = view;
        for (h hVar : this.STm.values()) {
            hVar.hxu();
        }
        AppMethodBeat.o(214869);
    }

    public final void hxr() {
        AppMethodBeat.i(214870);
        this.STk = null;
        for (h hVar : this.STm.values()) {
            if (!(hVar.STK == null || hVar.STK.getView() == null)) {
                hVar.STK.getView();
            }
        }
        AppMethodBeat.o(214870);
    }

    @Override // io.flutter.plugin.platform.g
    public final void a(io.flutter.view.a aVar) {
        this.accessibilityEventsDelegate.SNs = aVar;
    }

    @Override // io.flutter.plugin.platform.g
    public final void hxq() {
        this.accessibilityEventsDelegate.SNs = null;
    }

    public final boolean checkInputConnectionProxy(View view) {
        AppMethodBeat.i(9925);
        if (!this.STn.containsKey(view.getContext())) {
            AppMethodBeat.o(9925);
            return false;
        }
        View view2 = this.STn.get(view.getContext());
        if (view2 == view) {
            AppMethodBeat.o(9925);
            return true;
        }
        boolean checkInputConnectionProxy = view2.checkInputConnectionProxy(view);
        AppMethodBeat.o(9925);
        return checkInputConnectionProxy;
    }

    public void onAttachedToJNI() {
    }

    public void onDetachedFromJNI() {
        AppMethodBeat.i(214871);
        hxs();
        AppMethodBeat.o(214871);
    }

    @Override // io.flutter.plugin.platform.g
    public final View r(Integer num) {
        AppMethodBeat.i(9926);
        if (this.STp.get(num.intValue()) != null) {
            View view = this.STp.get(num.intValue());
            AppMethodBeat.o(9926);
            return view;
        }
        h hVar = this.STm.get(num);
        if (hVar == null) {
            AppMethodBeat.o(9926);
            return null;
        }
        View view2 = hVar.getView();
        AppMethodBeat.o(9926);
        return view2;
    }

    public static boolean atB(int i2) {
        return i2 == 0 || i2 == 1;
    }

    private static List<MotionEvent.PointerCoords> a(Object obj, float f2) {
        AppMethodBeat.i(214872);
        ArrayList arrayList = new ArrayList();
        for (List list : (List) obj) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
            pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
            pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
            pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f2;
            pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f2;
            pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f2;
            pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f2;
            pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f2;
            pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f2;
            arrayList.add(pointerCoords);
        }
        AppMethodBeat.o(214872);
        return arrayList;
    }

    public final void hxs() {
        AppMethodBeat.i(9927);
        for (h hVar : this.STm.values()) {
            hVar.dispose();
        }
        this.STm.clear();
        AppMethodBeat.o(9927);
    }

    public final void hxt() {
        AppMethodBeat.i(214873);
        if (!this.STt) {
            ((FlutterView) this.STk).hwz();
            this.STt = true;
        }
        AppMethodBeat.o(214873);
    }

    public final void b(io.flutter.embedding.engine.b.a aVar) {
        AppMethodBeat.i(214874);
        this.SNr = new b(aVar, true);
        AppMethodBeat.o(214874);
    }

    public final void EA(boolean z) {
        AppMethodBeat.i(214875);
        for (int i2 = 0; i2 < this.STr.size(); i2++) {
            int keyAt = this.STr.keyAt(i2);
            g valueAt = this.STr.valueAt(i2);
            if (this.STu.contains(Integer.valueOf(keyAt))) {
                FlutterView flutterView = (FlutterView) this.STk;
                if (flutterView.wJi != null) {
                    valueAt.a(flutterView.wJi.SMr);
                }
                z &= valueAt.hwv();
            } else {
                if (!this.STt) {
                    valueAt.hwu();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i3 = 0; i3 < this.STp.size(); i3++) {
            int keyAt2 = this.STp.keyAt(i3);
            View view = this.STp.get(keyAt2);
            a aVar = this.STq.get(keyAt2);
            if (!z || !this.STv.contains(Integer.valueOf(keyAt2))) {
                view.setVisibility(8);
                aVar.setVisibility(8);
            } else {
                view.setVisibility(0);
                aVar.setVisibility(0);
            }
        }
        AppMethodBeat.o(214875);
    }

    public final void destroyOverlaySurfaces() {
        AppMethodBeat.i(214876);
        for (int i2 = 0; i2 < this.STr.size(); i2++) {
            this.STr.keyAt(i2);
            g valueAt = this.STr.valueAt(i2);
            valueAt.hwu();
            ((FlutterView) this.STk).removeView(valueAt);
        }
        this.STr.clear();
        AppMethodBeat.o(214876);
    }

    static /* synthetic */ int a(PlatformViewsController platformViewsController, double d2) {
        AppMethodBeat.i(214878);
        int round = (int) Math.round(((double) platformViewsController.context.getResources().getDisplayMetrics().density) * d2);
        AppMethodBeat.o(214878);
        return round;
    }

    static /* synthetic */ void a(PlatformViewsController platformViewsController, int i2, int i3) {
        AppMethodBeat.i(214879);
        DisplayMetrics displayMetrics = platformViewsController.context.getResources().getDisplayMetrics();
        if (i3 > displayMetrics.heightPixels || i2 > displayMetrics.widthPixels) {
            new StringBuilder("Creating a virtual display of size: [").append(i2).append(", ").append(i3).append("] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [").append(displayMetrics.widthPixels).append(", ").append(displayMetrics.heightPixels).append("].");
        }
        AppMethodBeat.o(214879);
    }

    static /* synthetic */ void a(PlatformViewsController platformViewsController, h hVar) {
        AppMethodBeat.i(214880);
        if (platformViewsController.SMp != null) {
            io.flutter.plugin.b.c cVar = platformViewsController.SMp;
            if (cVar.SSH.SST == c.a.EnumC2253a.PLATFORM_VIEW) {
                cVar.SSO = true;
            }
            if (hVar.STK == null || hVar.STK.getView() == null) {
                AppMethodBeat.o(214880);
                return;
            }
            hVar.STK.getView();
        }
        AppMethodBeat.o(214880);
    }

    static /* synthetic */ void b(PlatformViewsController platformViewsController, h hVar) {
        AppMethodBeat.i(214881);
        if (platformViewsController.SMp != null) {
            platformViewsController.SMp.SSO = false;
            if (hVar.STK == null || hVar.STK.getView() == null) {
                AppMethodBeat.o(214881);
                return;
            }
            hVar.STK.getView();
        }
        AppMethodBeat.o(214881);
    }
}
