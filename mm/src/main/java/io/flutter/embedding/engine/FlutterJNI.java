package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.Keep;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.g;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.c.h;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.plugin.a.n;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugin.platform.d;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Keep
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
    private static String observatoryUri;
    private static float refreshRateFPS = 0.0f;
    private AccessibilityDelegate accessibilityDelegate;
    private final Set<a.AbstractC2243a> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<b> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private io.flutter.plugin.c.a localizationPlugin;
    private final Looper mainLooper = Looper.getMainLooper();
    private Long nativePlatformViewId;
    private io.flutter.embedding.engine.dart.b platformMessageHandler;
    private PlatformViewsController platformViewsController;

    public interface AccessibilityDelegate {
        void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr);

        void updateSemantics(ByteBuffer byteBuffer, String[] strArr);
    }

    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long j2);
    }

    private native long nativeAttach(FlutterJNI flutterJNI, boolean z);

    private native void nativeDestroy(long j2);

    private native void nativeDispatchEmptyPlatformMessage(long j2, String str, int i2);

    private native void nativeDispatchPlatformMessage(long j2, String str, ByteBuffer byteBuffer, int i2, int i3);

    private native void nativeDispatchPointerDataPacket(long j2, ByteBuffer byteBuffer, int i2);

    private native void nativeDispatchSemanticsAction(long j2, int i2, int i3, ByteBuffer byteBuffer, int i4);

    private native Bitmap nativeGetBitmap(long j2);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j2);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j2, int i2);

    private native void nativeInvokePlatformMessageResponseCallback(long j2, int i2, ByteBuffer byteBuffer, int i3);

    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j2);

    private native void nativeMarkTextureFrameAvailable(long j2, long j3);

    private native void nativeMemoryWarning(long j2);

    private native void nativeNotifyLowMemoryWarning(long j2);

    public static native void nativeOnVsync(long j2, long j3, long j4);

    public static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterTexture(long j2, long j3, SurfaceTexture surfaceTexture);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j2, String str, String str2, String str3, AssetManager assetManager);

    private native void nativeSetAccessibilityFeatures(long j2, int i2);

    private native void nativeSetSemanticsEnabled(long j2, boolean z);

    private native void nativeSetViewportMetrics(long j2, float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15);

    private native void nativeSurfaceChanged(long j2, int i2, int i3);

    private native void nativeSurfaceCreated(long j2, Surface surface);

    private native void nativeSurfaceDestroyed(long j2);

    private native void nativeSurfaceWindowChanged(long j2, Surface surface);

    private native void nativeUnregisterTexture(long j2, long j3);

    public native boolean nativeFlutterTextUtilsIsEmoji(int i2);

    public native boolean nativeFlutterTextUtilsIsEmojiModifier(int i2);

    public native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i2);

    public native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i2);

    public native boolean nativeFlutterTextUtilsIsVariationSelector(int i2);

    public boolean getIsSoftwareRenderingEnabled() {
        AppMethodBeat.i(214946);
        boolean nativeGetIsSoftwareRenderingEnabled = nativeGetIsSoftwareRenderingEnabled();
        AppMethodBeat.o(214946);
        return nativeGetIsSoftwareRenderingEnabled;
    }

    public static String getObservatoryUri() {
        return observatoryUri;
    }

    public static void setRefreshRateFPS(float f2) {
        refreshRateFPS = f2;
    }

    public static void setAsyncWaitForVsyncDelegate(AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2) {
        asyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate2;
    }

    private static void asyncWaitForVsync(long j2) {
        AppMethodBeat.i(10126);
        if (asyncWaitForVsyncDelegate != null) {
            asyncWaitForVsyncDelegate.asyncWaitForVsync(j2);
            AppMethodBeat.o(10126);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
        AppMethodBeat.o(10126);
        throw illegalStateException;
    }

    public FlutterJNI() {
        AppMethodBeat.i(10127);
        AppMethodBeat.o(10127);
    }

    public boolean isAttached() {
        return this.nativePlatformViewId != null;
    }

    public void attachToNative(boolean z) {
        AppMethodBeat.i(10128);
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.nativePlatformViewId = Long.valueOf(performNativeAttach(this, z));
        AppMethodBeat.o(10128);
    }

    public long performNativeAttach(FlutterJNI flutterJNI, boolean z) {
        AppMethodBeat.i(214947);
        long nativeAttach = nativeAttach(flutterJNI, z);
        AppMethodBeat.o(214947);
        return nativeAttach;
    }

    public void detachFromNativeAndReleaseResources() {
        AppMethodBeat.i(10129);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDestroy(this.nativePlatformViewId.longValue());
        this.nativePlatformViewId = null;
        AppMethodBeat.o(10129);
    }

    private void ensureNotAttachedToNative() {
        AppMethodBeat.i(10130);
        if (this.nativePlatformViewId != null) {
            RuntimeException runtimeException = new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
            AppMethodBeat.o(10130);
            throw runtimeException;
        }
        AppMethodBeat.o(10130);
    }

    private void ensureAttachedToNative() {
        AppMethodBeat.i(10131);
        if (this.nativePlatformViewId == null) {
            RuntimeException runtimeException = new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
            AppMethodBeat.o(10131);
            throw runtimeException;
        }
        AppMethodBeat.o(10131);
    }

    public void addIsDisplayingFlutterUiListener(b bVar) {
        AppMethodBeat.i(214948);
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(bVar);
        AppMethodBeat.o(214948);
    }

    public void removeIsDisplayingFlutterUiListener(b bVar) {
        AppMethodBeat.i(214949);
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(bVar);
        AppMethodBeat.o(214949);
    }

    public void onFirstFrame() {
        AppMethodBeat.i(10135);
        ensureRunningOnMainThread();
        for (b bVar : this.flutterUiDisplayListeners) {
            bVar.dLt();
        }
        AppMethodBeat.o(10135);
    }

    /* access modifiers changed from: package-private */
    public void onRenderingStopped() {
        AppMethodBeat.i(214950);
        ensureRunningOnMainThread();
        for (b bVar : this.flutterUiDisplayListeners) {
            bVar.dLu();
        }
        AppMethodBeat.o(214950);
    }

    public void onSurfaceCreated(Surface surface) {
        AppMethodBeat.i(10136);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativePlatformViewId.longValue(), surface);
        AppMethodBeat.o(10136);
    }

    public void onSurfaceWindowChanged(Surface surface) {
        AppMethodBeat.i(214951);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativePlatformViewId.longValue(), surface);
        AppMethodBeat.o(214951);
    }

    public void onSurfaceChanged(int i2, int i3) {
        AppMethodBeat.i(10137);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativePlatformViewId.longValue(), i2, i3);
        AppMethodBeat.o(10137);
    }

    public void onSurfaceDestroyed() {
        AppMethodBeat.i(10138);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativePlatformViewId.longValue());
        AppMethodBeat.o(10138);
    }

    public void setViewportMetrics(float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        AppMethodBeat.i(10139);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativePlatformViewId.longValue(), f2, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15);
        AppMethodBeat.o(10139);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(10140);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativePlatformViewId.longValue(), byteBuffer, i2);
        AppMethodBeat.o(10140);
    }

    public void setPlatformViewsController(PlatformViewsController platformViewsController2) {
        AppMethodBeat.i(214952);
        ensureRunningOnMainThread();
        this.platformViewsController = platformViewsController2;
        AppMethodBeat.o(214952);
    }

    public void setAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate2) {
        AppMethodBeat.i(10141);
        ensureRunningOnMainThread();
        this.accessibilityDelegate = accessibilityDelegate2;
        AppMethodBeat.o(10141);
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr) {
        AppMethodBeat.i(10142);
        ensureRunningOnMainThread();
        if (this.accessibilityDelegate != null) {
            this.accessibilityDelegate.updateSemantics(byteBuffer, strArr);
        }
        AppMethodBeat.o(10142);
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        AppMethodBeat.i(10143);
        ensureRunningOnMainThread();
        if (this.accessibilityDelegate != null) {
            this.accessibilityDelegate.updateCustomAccessibilityActions(byteBuffer, strArr);
        }
        AppMethodBeat.o(10143);
    }

    public void dispatchSemanticsAction(int i2, a.b bVar) {
        AppMethodBeat.i(10144);
        dispatchSemanticsAction(i2, bVar, null);
        AppMethodBeat.o(10144);
    }

    public void dispatchSemanticsAction(int i2, a.b bVar, Object obj) {
        AppMethodBeat.i(10145);
        ensureAttachedToNative();
        ByteBuffer byteBuffer = null;
        int i3 = 0;
        if (obj != null) {
            byteBuffer = n.SSp.eP(obj);
            i3 = byteBuffer.position();
        }
        dispatchSemanticsAction(i2, bVar.value, byteBuffer, i3);
        AppMethodBeat.o(10145);
    }

    public void dispatchSemanticsAction(int i2, int i3, ByteBuffer byteBuffer, int i4) {
        AppMethodBeat.i(10146);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativePlatformViewId.longValue(), i2, i3, byteBuffer, i4);
        AppMethodBeat.o(10146);
    }

    public void setSemanticsEnabled(boolean z) {
        AppMethodBeat.i(10147);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetSemanticsEnabled(this.nativePlatformViewId.longValue(), z);
        AppMethodBeat.o(10147);
    }

    public void setAccessibilityFeatures(int i2) {
        AppMethodBeat.i(10148);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetAccessibilityFeatures(this.nativePlatformViewId.longValue(), i2);
        AppMethodBeat.o(10148);
    }

    public void registerTexture(long j2, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(10149);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativePlatformViewId.longValue(), j2, surfaceTexture);
        AppMethodBeat.o(10149);
    }

    public void markTextureFrameAvailable(long j2) {
        AppMethodBeat.i(10150);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativePlatformViewId.longValue(), j2);
        AppMethodBeat.o(10150);
    }

    public void unregisterTexture(long j2) {
        AppMethodBeat.i(10151);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativePlatformViewId.longValue(), j2);
        AppMethodBeat.o(10151);
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager) {
        AppMethodBeat.i(10152);
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativePlatformViewId.longValue(), str, str2, str3, assetManager);
        AppMethodBeat.o(10152);
    }

    public void setPlatformMessageHandler(io.flutter.embedding.engine.dart.b bVar) {
        AppMethodBeat.i(10153);
        ensureRunningOnMainThread();
        this.platformMessageHandler = bVar;
        AppMethodBeat.o(10153);
    }

    public void handlePlatformMessage(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(10154);
        if (this.platformMessageHandler != null) {
            this.platformMessageHandler.g(str, bArr, i2);
        }
        AppMethodBeat.o(10154);
    }

    private void handlePlatformMessageResponse(int i2, byte[] bArr) {
        AppMethodBeat.i(10155);
        if (this.platformMessageHandler != null) {
            this.platformMessageHandler.handlePlatformMessageResponse(i2, bArr);
        }
        AppMethodBeat.o(10155);
    }

    public void dispatchEmptyPlatformMessage(String str, int i2) {
        AppMethodBeat.i(10156);
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativePlatformViewId.longValue(), str, i2);
            AppMethodBeat.o(10156);
            return;
        }
        new StringBuilder("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ").append(str).append(". Response ID: ").append(i2);
        io.flutter.a.hwf();
        AppMethodBeat.o(10156);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i2, int i3) {
        AppMethodBeat.i(10157);
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativePlatformViewId.longValue(), str, byteBuffer, i2, i3);
            AppMethodBeat.o(10157);
            return;
        }
        new StringBuilder("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ").append(str).append(". Response ID: ").append(i3);
        io.flutter.a.hwf();
        AppMethodBeat.o(10157);
    }

    public void invokePlatformMessageEmptyResponseCallback(int i2) {
        AppMethodBeat.i(10158);
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeInvokePlatformMessageEmptyResponseCallback(this.nativePlatformViewId.longValue(), i2);
            AppMethodBeat.o(10158);
            return;
        }
        "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ".concat(String.valueOf(i2));
        io.flutter.a.hwf();
        AppMethodBeat.o(10158);
    }

    public void invokePlatformMessageResponseCallback(int i2, ByteBuffer byteBuffer, int i3) {
        AppMethodBeat.i(10159);
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeInvokePlatformMessageResponseCallback(this.nativePlatformViewId.longValue(), i2, byteBuffer, i3);
            AppMethodBeat.o(10159);
            return;
        }
        "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ".concat(String.valueOf(i2));
        io.flutter.a.hwf();
        AppMethodBeat.o(10159);
    }

    public void addEngineLifecycleListener(a.AbstractC2243a aVar) {
        AppMethodBeat.i(10160);
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(aVar);
        AppMethodBeat.o(10160);
    }

    public void removeEngineLifecycleListener(a.AbstractC2243a aVar) {
        AppMethodBeat.i(10161);
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(aVar);
        AppMethodBeat.o(10161);
    }

    private void onPreEngineRestart() {
        AppMethodBeat.i(10162);
        for (a.AbstractC2243a aVar : this.engineLifecycleListeners) {
            aVar.onPreEngineRestart();
        }
        AppMethodBeat.o(10162);
    }

    public void onDisplayOverlaySurface(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(214953);
        ensureRunningOnMainThread();
        if (this.platformViewsController == null) {
            RuntimeException runtimeException = new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
            AppMethodBeat.o(214953);
            throw runtimeException;
        }
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        platformViewsController2.hxt();
        g gVar = platformViewsController2.STr.get(i2);
        if (gVar.getParent() == null) {
            ((FlutterView) platformViewsController2.STk).addView(gVar);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i4;
        gVar.setLayoutParams(layoutParams);
        gVar.setVisibility(0);
        gVar.bringToFront();
        platformViewsController2.STu.add(Integer.valueOf(i2));
        AppMethodBeat.o(214953);
    }

    public void onBeginFrame() {
        AppMethodBeat.i(214954);
        ensureRunningOnMainThread();
        if (this.platformViewsController == null) {
            RuntimeException runtimeException = new RuntimeException("platformViewsController must be set before attempting to begin the frame");
            AppMethodBeat.o(214954);
            throw runtimeException;
        }
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        platformViewsController2.STu.clear();
        platformViewsController2.STv.clear();
        AppMethodBeat.o(214954);
    }

    public void onEndFrame() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(214955);
        ensureRunningOnMainThread();
        if (this.platformViewsController == null) {
            RuntimeException runtimeException = new RuntimeException("platformViewsController must be set before attempting to end the frame");
            AppMethodBeat.o(214955);
            throw runtimeException;
        }
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        FlutterView flutterView = (FlutterView) platformViewsController2.STk;
        if (!platformViewsController2.STt || !platformViewsController2.STv.isEmpty()) {
            if (platformViewsController2.STt) {
                if (flutterView.SNk != null) {
                    z2 = flutterView.SNk.hwv();
                } else {
                    z2 = false;
                }
                if (z2) {
                    z = true;
                    platformViewsController2.EA(z);
                    AppMethodBeat.o(214955);
                    return;
                }
            }
            z = false;
            platformViewsController2.EA(z);
            AppMethodBeat.o(214955);
            return;
        }
        platformViewsController2.STt = false;
        PlatformViewsController.AnonymousClass2 r1 = new Runnable() {
            /* class io.flutter.plugin.platform.PlatformViewsController.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(214885);
                PlatformViewsController.l(PlatformViewsController.this);
                AppMethodBeat.o(214885);
            }
        };
        if (flutterView.SNk == null) {
            io.flutter.a.hwd();
            AppMethodBeat.o(214955);
        } else if (flutterView.SNm == null) {
            io.flutter.a.hwd();
            AppMethodBeat.o(214955);
        } else {
            flutterView.SNl = flutterView.SNm;
            flutterView.SNm = null;
            if (flutterView.wJi == null) {
                flutterView.SNk.hwu();
                r1.run();
                AppMethodBeat.o(214955);
                return;
            }
            io.flutter.embedding.engine.b.a aVar = flutterView.wJi.SMr;
            if (aVar == null) {
                flutterView.SNk.hwu();
                r1.run();
                AppMethodBeat.o(214955);
                return;
            }
            flutterView.SNl.a(aVar);
            aVar.addIsDisplayingFlutterUiListener(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007c: INVOKE  
                  (r2v7 'aVar' io.flutter.embedding.engine.b.a)
                  (wrap: io.flutter.embedding.android.FlutterView$3 : 0x0079: CONSTRUCTOR  (r3v6 io.flutter.embedding.android.FlutterView$3) = 
                  (r0v2 'flutterView' io.flutter.embedding.android.FlutterView)
                  (r2v7 'aVar' io.flutter.embedding.engine.b.a)
                  (r1v1 'r1' io.flutter.plugin.platform.PlatformViewsController$2)
                 call: io.flutter.embedding.android.FlutterView.3.<init>(io.flutter.embedding.android.FlutterView, io.flutter.embedding.engine.b.a, java.lang.Runnable):void type: CONSTRUCTOR)
                 type: VIRTUAL call: io.flutter.embedding.engine.b.a.addIsDisplayingFlutterUiListener(io.flutter.embedding.engine.b.b):void in method: io.flutter.embedding.engine.FlutterJNI.onEndFrame():void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0079: CONSTRUCTOR  (r3v6 io.flutter.embedding.android.FlutterView$3) = 
                  (r0v2 'flutterView' io.flutter.embedding.android.FlutterView)
                  (r2v7 'aVar' io.flutter.embedding.engine.b.a)
                  (r1v1 'r1' io.flutter.plugin.platform.PlatformViewsController$2)
                 call: io.flutter.embedding.android.FlutterView.3.<init>(io.flutter.embedding.android.FlutterView, io.flutter.embedding.engine.b.a, java.lang.Runnable):void type: CONSTRUCTOR in method: io.flutter.embedding.engine.FlutterJNI.onEndFrame():void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 37 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.flutter.embedding.android.FlutterView, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 43 more
                */
            /*
            // Method dump skipped, instructions count: 159
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterJNI.onEndFrame():void");
        }

        public FlutterOverlaySurface createOverlaySurface() {
            AppMethodBeat.i(214956);
            ensureRunningOnMainThread();
            if (this.platformViewsController == null) {
                RuntimeException runtimeException = new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
                AppMethodBeat.o(214956);
                throw runtimeException;
            }
            PlatformViewsController platformViewsController2 = this.platformViewsController;
            g gVar = new g(platformViewsController2.STk.getContext(), platformViewsController2.STk.getWidth(), platformViewsController2.STk.getHeight(), g.a.overlay);
            int i2 = platformViewsController2.STs;
            platformViewsController2.STs = i2 + 1;
            platformViewsController2.STr.put(i2, gVar);
            FlutterOverlaySurface flutterOverlaySurface = new FlutterOverlaySurface(i2, gVar.getSurface());
            AppMethodBeat.o(214956);
            return flutterOverlaySurface;
        }

        public void destroyOverlaySurfaces() {
            AppMethodBeat.i(214957);
            ensureRunningOnMainThread();
            if (this.platformViewsController == null) {
                RuntimeException runtimeException = new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
                AppMethodBeat.o(214957);
                throw runtimeException;
            }
            this.platformViewsController.destroyOverlaySurfaces();
            AppMethodBeat.o(214957);
        }

        public void setLocalizationPlugin(io.flutter.plugin.c.a aVar) {
            AppMethodBeat.i(214958);
            ensureRunningOnMainThread();
            this.localizationPlugin = aVar;
            AppMethodBeat.o(214958);
        }

        /* access modifiers changed from: package-private */
        public String[] computePlatformResolvedLocale(String[] strArr) {
            AppMethodBeat.i(214959);
            if (this.localizationPlugin == null) {
                String[] strArr2 = new String[0];
                AppMethodBeat.o(214959);
                return strArr2;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2 += 3) {
                String str = strArr[i2 + 0];
                String str2 = strArr[i2 + 1];
                String str3 = strArr[i2 + 2];
                if (Build.VERSION.SDK_INT >= 21) {
                    Locale.Builder builder = new Locale.Builder();
                    if (!str.isEmpty()) {
                        builder.setLanguage(str);
                    }
                    if (!str2.isEmpty()) {
                        builder.setRegion(str2);
                    }
                    if (!str3.isEmpty()) {
                        builder.setScript(str3);
                    }
                    arrayList.add(builder.build());
                } else {
                    arrayList.add(new Locale(str, str2));
                }
            }
            Locale ko = this.localizationPlugin.ko(arrayList);
            if (ko == null) {
                String[] strArr3 = new String[0];
                AppMethodBeat.o(214959);
                return strArr3;
            }
            String[] strArr4 = new String[3];
            strArr4[0] = ko.getLanguage();
            strArr4[1] = ko.getCountry();
            if (Build.VERSION.SDK_INT >= 21) {
                strArr4[2] = ko.getScript();
            } else {
                strArr4[2] = "";
            }
            AppMethodBeat.o(214959);
            return strArr4;
        }

        public void onDisplayPlatformView(int i2, int i3, int i4, int i5, int i6, int i7, int i8, FlutterMutatorsStack flutterMutatorsStack) {
            Object obj;
            AppMethodBeat.i(214960);
            ensureRunningOnMainThread();
            if (this.platformViewsController == null) {
                RuntimeException runtimeException = new RuntimeException("platformViewsController must be set before attempting to position a platform view");
                AppMethodBeat.o(214960);
                throw runtimeException;
            }
            PlatformViewsController platformViewsController2 = this.platformViewsController;
            platformViewsController2.hxt();
            if (platformViewsController2.STp.get(i2) == null) {
                h.a aVar = platformViewsController2.STo.get(i2);
                if (aVar == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
                    AppMethodBeat.o(214960);
                    throw illegalStateException;
                } else if (!PlatformViewsController.atB(aVar.direction)) {
                    IllegalStateException illegalStateException2 = new IllegalStateException("Trying to create a view with unknown direction value: " + aVar.direction + "(view id: " + i2 + ")");
                    AppMethodBeat.o(214960);
                    throw illegalStateException2;
                } else {
                    d bts = platformViewsController2.STj.bts(aVar.SQP);
                    if (bts == null) {
                        IllegalStateException illegalStateException3 = new IllegalStateException("Trying to create a platform view of unregistered type: " + aVar.SQP);
                        AppMethodBeat.o(214960);
                        throw illegalStateException3;
                    }
                    if (aVar.SQS != null) {
                        obj = bts.STh.J(aVar.SQS);
                    } else {
                        obj = null;
                    }
                    View view = bts.a(platformViewsController2.context, i2, obj).getView();
                    if (view == null) {
                        IllegalStateException illegalStateException4 = new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
                        AppMethodBeat.o(214960);
                        throw illegalStateException4;
                    } else if (view.getParent() != null) {
                        IllegalStateException illegalStateException5 = new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
                        AppMethodBeat.o(214960);
                        throw illegalStateException5;
                    } else {
                        platformViewsController2.STp.put(i2, view);
                        io.flutter.embedding.engine.mutatorsstack.a aVar2 = new io.flutter.embedding.engine.mutatorsstack.a(platformViewsController2.context, platformViewsController2.context.getResources().getDisplayMetrics().density, platformViewsController2.SNr);
                        platformViewsController2.STq.put(i2, aVar2);
                        aVar2.addView(view);
                        ((FlutterView) platformViewsController2.STk).addView(aVar2);
                    }
                }
            }
            io.flutter.embedding.engine.mutatorsstack.a aVar3 = platformViewsController2.STq.get(i2);
            aVar3.SPq = flutterMutatorsStack;
            aVar3.left = i3;
            aVar3.top = i4;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
            layoutParams.leftMargin = i3;
            layoutParams.topMargin = i4;
            aVar3.setLayoutParams(layoutParams);
            aVar3.setWillNotDraw(false);
            aVar3.setVisibility(0);
            aVar3.bringToFront();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i7, i8);
            View view2 = platformViewsController2.STp.get(i2);
            view2.setLayoutParams(layoutParams2);
            view2.bringToFront();
            platformViewsController2.STv.add(Integer.valueOf(i2));
            AppMethodBeat.o(214960);
        }

        public Bitmap getBitmap() {
            AppMethodBeat.i(10163);
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            Bitmap nativeGetBitmap = nativeGetBitmap(this.nativePlatformViewId.longValue());
            AppMethodBeat.o(10163);
            return nativeGetBitmap;
        }

        public void notifyLowMemoryWarning() {
            AppMethodBeat.i(214961);
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeNotifyLowMemoryWarning(this.nativePlatformViewId.longValue());
            AppMethodBeat.o(214961);
        }

        private void ensureRunningOnMainThread() {
            AppMethodBeat.i(10164);
            if (Looper.myLooper() != this.mainLooper) {
                RuntimeException runtimeException = new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
                AppMethodBeat.o(10164);
                throw runtimeException;
            }
            AppMethodBeat.o(10164);
        }

        public void onMemoryWarning() {
            AppMethodBeat.i(214962);
            if (isAttached()) {
                nativeMemoryWarning(this.nativePlatformViewId.longValue());
                AppMethodBeat.o(214962);
                return;
            }
            io.flutter.a.hwf();
            AppMethodBeat.o(214962);
        }
    }
