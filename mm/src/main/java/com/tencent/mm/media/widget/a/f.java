package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.media.k.e;
import com.tencent.mm.media.widget.a.a;
import com.tencent.mm.media.widget.camerarecordview.d.b;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J$\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0014R\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J0\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020#H\u0016J\u0012\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0012\u0010/\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u00100\u001a\u00020 J\b\u00101\u001a\u00020#H\u0016J\b\u00102\u001a\u00020#H\u0016J$\u00103\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u0005H\u0014J\u000e\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tJ \u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020\u0005H\u0016J\u0018\u0010?\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u001c\u0010@\u001a\u00020#2\n\u0010A\u001a\u00060BR\u00020\u00152\u0006\u0010C\u001a\u00020\u0005H\u0014R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006D"}, hxF = {"Lcom/tencent/mm/media/widget/camera/VoipCommonCamera1;", "Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "TAG", "", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "supportPreviewSizes", "", "Landroid/hardware/Camera$Size;", "Landroid/hardware/Camera;", "screenResolution", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraResolution", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "w", "h", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "", "getPreviewWidth", "postFocusOnTouch", "", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "removeFocusOnTouch", "safeSetFocusMode", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "safeSetPreviewFormat", "selectPreviewSize", "setPreviewCallbackImplInGPUCrop", "setSafeConfig", "startPreviewWithGPU", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "resolutionLimit", "translateFocusMode", "focusMode", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "tryPreviewSize", "trySetPreviewFpsRangeParameters", "p", "Landroid/hardware/Camera$Parameters;", "mCameraFps", "plugin-mediaeditor_release"})
public final class f extends c {
    private final String TAG = "MicroMsg.VoipCommonCamera1";
    private int height;
    private int width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context, int i2, int i3) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(218839);
        this.width = i2;
        this.height = i3;
        AppMethodBeat.o(218839);
    }

    private final Point a(List<? extends Camera.Size> list, Point point) {
        int i2;
        int i3;
        AppMethodBeat.i(218825);
        int i4 = Integer.MAX_VALUE;
        Iterator<? extends Camera.Size> it = list.iterator();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = i5;
                i3 = i6;
                break;
            }
            Camera.Size size = (Camera.Size) it.next();
            try {
                i3 = size.width;
                i2 = size.height;
                int abs = Math.abs(i3 - point.x) + Math.abs(i2 - point.y);
                if (abs == 0) {
                    break;
                }
                if (abs >= i4 || i3 == i2) {
                    abs = i4;
                    i2 = i5;
                    i3 = i6;
                }
                i4 = abs;
                i5 = i2;
                i6 = i3;
            } catch (NumberFormatException e2) {
                Log.w(this.TAG, "Bad preview-size: ".concat(String.valueOf(size)));
            }
        }
        if (i3 <= 0 || i2 <= 0) {
            AppMethodBeat.o(218825);
            return null;
        }
        Point point2 = new Point(i3, i2);
        AppMethodBeat.o(218825);
        return point2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean aPy() {
        /*
        // Method dump skipped, instructions count: 475
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.a.f.aPy():boolean");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.widget.a.c
    public final void b(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i2) {
        AppMethodBeat.i(218828);
        long currentTicks = Util.currentTicks();
        Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + surfaceTexture + ", surface:" + surfaceHolder);
        if (aPc()) {
            Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
            AppMethodBeat.o(218828);
            return;
        }
        try {
            aPy();
            aPp();
            aPt();
            if (a(surfaceTexture, surfaceHolder)) {
                a(a.EnumC0424a.CAMERA_IS_PREVIEWING);
            }
        } catch (Exception e2) {
            Log.e(this.TAG, "start preview FAILED, %s, %s", Looper.myLooper(), e2.getMessage());
            e eVar = e.ilC;
            e.aNm();
        }
        Log.i(this.TAG, "start preview end, use %dms %s", Long.valueOf(Util.ticksToNow(currentTicks)), Looper.myLooper());
        AppMethodBeat.o(218828);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "ca", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/VoipCommonCamera1$setPreviewCallbackImplInGPUCrop$2$1"})
    public static final class a implements Camera.PreviewCallback {
        final /* synthetic */ f imJ;

        a(f fVar) {
            this.imJ = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
            if (r4.dYT == 90) goto L_0x0088;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPreviewFrame(byte[] r8, android.hardware.Camera r9) {
            /*
            // Method dump skipped, instructions count: 171
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.a.f.a.onPreviewFrame(byte[], android.hardware.Camera):void");
        }
    }

    @Override // com.tencent.mm.media.widget.a.d, com.tencent.mm.media.widget.a.c
    public final void b(float f2, float f3, int i2, int i3) {
    }

    @Override // com.tencent.mm.media.widget.a.d, com.tencent.mm.media.widget.a.c
    public final void aPq() {
    }

    @Override // com.tencent.mm.media.widget.a.d, com.tencent.mm.media.widget.a.c
    public final void i(boolean z, int i2) {
    }

    @Override // com.tencent.mm.media.widget.a.d, com.tencent.mm.media.widget.a.c
    public final b aPr() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(218831);
        Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
        if (this.gGr == null) {
            Log.i(this.TAG, "generateCameraConfig, camera is null!!");
            AppMethodBeat.o(218831);
            return null;
        } else if (!aPc()) {
            Log.i(this.TAG, "generateCameraConfig, camera not previewing");
            AppMethodBeat.o(218831);
            return null;
        } else {
            b.rs(getPreviewWidth());
            b.rr(getPreviewHeight());
            d.a.C0301a aVar = this.imk;
            if (aVar != null) {
                z = aVar.dYT == 90 || aVar.dYT == 270;
            } else {
                z = false;
            }
            b.ru(this.ilR.sUz);
            b.rv(this.ilR.sUA);
            if (z) {
                int aPl = b.aPl();
                b.ru(b.aPm());
                b.rv(aPl);
            }
            b.rt(getOrientation());
            if (this.ilM) {
                z2 = false;
            }
            b.setFrontCamera(z2);
            b.eZ(this.ilO);
            b bVar = this.hAu;
            AppMethodBeat.o(218831);
            return bVar;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c7  */
    @Override // com.tencent.mm.media.widget.a.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.hardware.Camera.Parameters r14, int r15) {
        /*
        // Method dump skipped, instructions count: 378
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.a.f.a(android.hardware.Camera$Parameters, int):void");
    }

    private static String Ht(String str) {
        AppMethodBeat.i(218836);
        p.h(str, "focusMode");
        b.C0437b bVar = b.iqZ;
        if (p.j(str, b.C0437b.aQC())) {
            AppMethodBeat.o(218836);
            return "auto";
        }
        b.C0437b bVar2 = b.iqZ;
        if (p.j(str, b.C0437b.aQA())) {
            AppMethodBeat.o(218836);
            return "continuous-video";
        }
        b.C0437b bVar3 = b.iqZ;
        if (p.j(str, b.C0437b.aQB())) {
            AppMethodBeat.o(218836);
            return "continuous-picture";
        }
        AppMethodBeat.o(218836);
        return "";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.widget.a.c
    public final boolean a(v vVar) {
        HashMap<Integer, b.a.C0436b> hashMap;
        b.a.C0436b bVar;
        ArrayList<String> arrayList;
        HashMap<Integer, b.a.C0436b> hashMap2;
        b.a.C0436b bVar2;
        ArrayList<String> arrayList2;
        AppMethodBeat.i(218837);
        if (vVar == null) {
            AppMethodBeat.o(218837);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            p.g(parameters, "p");
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            b.a aVar = this.ilS;
            if (!(aVar == null || (hashMap = aVar.irb) == null || (bVar = hashMap.get(Integer.valueOf(aPu()))) == null || (arrayList = bVar.irf) == null)) {
                for (T t : arrayList) {
                    if (supportedFocusModes == null || !supportedFocusModes.contains(Ht(t))) {
                        b.a aVar2 = this.ilS;
                        if (p.j((aVar2 == null || (hashMap2 = aVar2.irb) == null || (bVar2 = hashMap2.get(Integer.valueOf(aPu()))) == null || (arrayList2 = bVar2.irf) == null) ? null : (String) j.ku(arrayList2), t)) {
                            Log.e(this.TAG, "all of the focus-mode are not supported yet");
                            AppMethodBeat.o(218837);
                            return false;
                        }
                        Log.e(this.TAG, "not support ".concat(String.valueOf(t)));
                    } else {
                        Log.i(this.TAG, "support ".concat(String.valueOf(t)));
                        parameters.setFocusMode(Ht(t));
                        this.ilK.imR = parameters.getFocusMode();
                        vVar.setParameters(parameters);
                        AppMethodBeat.o(218837);
                        return true;
                    }
                }
            }
            this.ilK.imR = parameters.getFocusMode();
            vVar.setParameters(parameters);
            AppMethodBeat.o(218837);
            return true;
        } catch (Exception e2) {
            Log.i(this.TAG, "setFocusMode Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(218837);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.c
    public final boolean b(v vVar) {
        int i2;
        HashMap<Integer, b.a.d> hashMap;
        b.a.d dVar;
        Integer num;
        AppMethodBeat.i(218838);
        if (vVar == null) {
            AppMethodBeat.o(218838);
            return false;
        }
        b.a aVar = this.ilS;
        if (aVar == null || (hashMap = aVar.ird) == null || (dVar = hashMap.get(Integer.valueOf(aPu()))) == null || (num = dVar.irk) == null) {
            i2 = 17;
        } else {
            i2 = num.intValue();
        }
        try {
            Log.i(this.TAG, "safeSetPreviewFormat");
            Camera.Parameters parameters = vVar.getParameters();
            p.g(parameters, "p");
            List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(i2))) {
                Log.e(this.TAG, "not support ".concat(String.valueOf(i2)));
            }
            parameters.setPreviewFormat(i2);
            vVar.setParameters(parameters);
            AppMethodBeat.o(218838);
            return true;
        } catch (Exception e2) {
            Log.i(this.TAG, "setPreviewFormat Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(218838);
            return false;
        }
    }

    private final boolean dh(int i2, int i3) {
        AppMethodBeat.i(218826);
        if (this.gGr == null || i2 <= 0 || i3 <= 0) {
            AppMethodBeat.o(218826);
            return false;
        }
        try {
            v vVar = this.gGr;
            Camera.Parameters parameters = vVar != null ? vVar.getParameters() : null;
            if (i2 > 0 && i3 > 0 && parameters != null) {
                parameters.setPreviewSize(i2, i3);
            }
            v vVar2 = this.gGr;
            if (vVar2 != null) {
                vVar2.setParameters(parameters);
            }
            this.ilR.sUz = i2;
            this.ilR.sUA = i3;
            this.ilV = new Point(i2, i3);
            AppMethodBeat.o(218826);
            return true;
        } catch (Exception e2) {
            Log.e(this.TAG, "TryPreviewSize fail:".concat(String.valueOf(e2)));
            AppMethodBeat.o(218826);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.c
    public final void aPt() {
        Boolean bool;
        HashSet<String> hashSet;
        AppMethodBeat.i(218829);
        b.a aVar = this.ilS;
        if (aVar == null || (hashSet = aVar.ire) == null) {
            bool = null;
        } else {
            b.C0437b bVar = b.iqZ;
            bool = Boolean.valueOf(hashSet.contains(b.C0437b.aQD()));
        }
        if (!(bool == null || p.j(bool, Boolean.FALSE))) {
            bool = null;
        }
        if (bool != null) {
            bool.booleanValue();
            if (this.gGr != null) {
                try {
                    v vVar = this.gGr;
                    if (vVar == null) {
                        p.hyc();
                    }
                    Camera.Parameters parameters = vVar.getParameters();
                    Log.i(this.TAG, "setPreviewCallbackImpl");
                    int i2 = this.ilR.sUz * this.ilR.sUA;
                    if (parameters == null) {
                        p.hyc();
                    }
                    int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * i2) / 8;
                    for (int i3 = 0; i3 < 5; i3++) {
                        byte[] h2 = k.zwi.h(Integer.valueOf(bitsPerPixel));
                        v vVar2 = this.gGr;
                        if (vVar2 == null) {
                            p.hyc();
                        }
                        vVar2.addCallbackBuffer(h2);
                    }
                    this.imm.reset();
                    this.imn.reset();
                    this.imo.reset();
                    this.imp.reset();
                    this.imq.reset();
                    v vVar3 = this.gGr;
                    if (vVar3 == null) {
                        p.hyc();
                    }
                    vVar3.setPreviewCallbackWithBuffer(new a(this));
                    AppMethodBeat.o(218829);
                    return;
                } catch (Exception e2) {
                    Log.e(this.TAG, "setPreviewCallbackImpl error: %s", e2.getMessage());
                }
            }
            AppMethodBeat.o(218829);
            return;
        }
        AppMethodBeat.o(218829);
    }

    @Override // com.tencent.mm.media.widget.a.c
    public final void aPp() {
        HashMap<Integer, b.a.c> hashMap;
        int i2;
        boolean z;
        Boolean bool;
        Integer num;
        AppMethodBeat.i(218830);
        b.a aVar = this.ilS;
        if (!(aVar == null || (hashMap = aVar.irc) == null)) {
            b.a.c cVar = hashMap.get(Integer.valueOf(aPu()));
            if (cVar == null || (num = cVar.iri) == null) {
                i2 = 15;
            } else {
                i2 = num.intValue();
            }
            this.imx = i2;
            v vVar = this.gGr;
            b.a.c cVar2 = hashMap.get(Integer.valueOf(aPu()));
            if (cVar2 == null || (bool = cVar2.irj) == null) {
                z = false;
            } else {
                z = bool.booleanValue();
            }
            a(vVar, z);
        }
        b(this.gGr);
        c(this.gGr);
        a(this.gGr);
        AppMethodBeat.o(218830);
    }

    @Override // com.tencent.mm.media.widget.a.c
    public final int getPreviewHeight() {
        AppMethodBeat.i(218832);
        q qVar = this.ilR;
        int intValue = (qVar != null ? Integer.valueOf(qVar.sUA) : null).intValue();
        AppMethodBeat.o(218832);
        return intValue;
    }

    @Override // com.tencent.mm.media.widget.a.c
    public final int getPreviewWidth() {
        AppMethodBeat.i(218833);
        q qVar = this.ilR;
        int intValue = (qVar != null ? Integer.valueOf(qVar.sUz) : null).intValue();
        AppMethodBeat.o(218833);
        return intValue;
    }

    @Override // com.tencent.mm.media.widget.a.d, com.tencent.mm.media.widget.a.c
    public final Point fa(boolean z) {
        Camera.Parameters parameters;
        AppMethodBeat.i(218834);
        v vVar = this.gGr;
        Camera.Size previewSize = (vVar == null || (parameters = vVar.getParameters()) == null) ? null : parameters.getPreviewSize();
        if (previewSize != null) {
            Log.i(this.TAG, "size is " + previewSize.width + " and " + previewSize.height + " and " + this.ilR.sUz + " and " + this.ilR.sUA + ' ');
        }
        Point point = new Point(this.ilR.sUz, this.ilR.sUA);
        AppMethodBeat.o(218834);
        return point;
    }
}
