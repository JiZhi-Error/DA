package com.tencent.mm.media.widget.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import android.os.Looper;
import android.util.Size;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.a;
import com.tencent.mm.media.widget.a.b;
import com.tencent.mm.media.widget.camerarecordview.d.b;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J%\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0014J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0005H\u0014J0\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\"H\u0016J\u0012\u0010+\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0006\u0010.\u001a\u00020\u001fJ\b\u0010/\u001a\u00020\"H\u0014J$\u00100\u001a\u00020\"2\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u0005H\u0014J\u000e\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\tJ \u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u0005H\u0016J\u0018\u0010<\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u001a\u0010=\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010>\u001a\u00020\u0005H\u0014R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006?"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/VoipCommonCamera2;", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "TAG", "", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "supportPreviewSizes", "", "Landroid/util/Size;", "screenResolution", "([Landroid/util/Size;Landroid/graphics/Point;)Landroid/graphics/Point;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraResolution", "w", "h", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "", "getPreviewWidth", "postFocusOnTouch", "", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "removeFocusOnTouch", "safeSetFocusMode", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "selectPreviewSize", "setSafeConfig", "startPreviewWithGPU", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "resolutionLimit", "translateFocusMode", "focusMode", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "tryPreviewSize", "trySetPreviewFpsRangeParameters", "mCameraFps", "plugin-mediaeditor_release"})
public final class e extends c {
    private final String TAG = "MicroMsg.VoipCommonCamera2";
    private int height;
    private int width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context, int i2, int i3) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(218873);
        this.width = i2;
        this.height = i3;
        AppMethodBeat.o(218873);
    }

    private final Point a(Size[] sizeArr, Point point) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(218861);
        int i5 = Integer.MAX_VALUE;
        int length = sizeArr.length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i6 >= length) {
                i2 = i7;
                i3 = i8;
                break;
            }
            Size size = sizeArr[i6];
            try {
                i3 = size.getWidth();
                i2 = size.getHeight();
                i4 = Math.abs(i3 - point.x) + Math.abs(i2 - point.y);
                if (i4 == 0) {
                    break;
                } else if (i4 >= i5 || i3 == i2) {
                    i4 = i5;
                    i2 = i7;
                    i3 = i8;
                    i6++;
                    i5 = i4;
                    i7 = i2;
                    i8 = i3;
                } else {
                    i6++;
                    i5 = i4;
                    i7 = i2;
                    i8 = i3;
                }
            } catch (NumberFormatException e2) {
                Log.w(this.TAG, "Bad preview-size: ".concat(String.valueOf(size)));
                i4 = i5;
                i2 = i7;
                i3 = i8;
            }
        }
        if (i3 <= 0 || i2 <= 0) {
            AppMethodBeat.o(218861);
            return null;
        }
        Point point2 = new Point(i3, i2);
        AppMethodBeat.o(218861);
        return point2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean aPy() {
        /*
        // Method dump skipped, instructions count: 489
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.b.e.aPy():boolean");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.widget.b.c
    public final void b(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i2) {
        CaptureRequest.Builder builder = null;
        AppMethodBeat.i(218864);
        Util.currentTicks();
        Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + surfaceTexture + ", surface:" + surfaceHolder);
        if (aPc()) {
            Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
            AppMethodBeat.o(218864);
            return;
        }
        try {
            if (this.inN) {
                CameraDevice cameraDevice = this.inH;
                if (cameraDevice != null) {
                    builder = cameraDevice.createCaptureRequest(3);
                }
            } else {
                CameraDevice cameraDevice2 = this.inH;
                if (cameraDevice2 != null) {
                    builder = cameraDevice2.createCaptureRequest(1);
                }
            }
            this.inI = builder;
            aPy();
            aPp();
            if (a(surfaceTexture, surfaceHolder)) {
                a(a.EnumC0424a.CAMERA_IS_PREVIEWING);
                this.state = 0;
                AppMethodBeat.o(218864);
                return;
            }
        } catch (Exception e2) {
            Log.e(this.TAG, "start preview FAILED, %s, %s", Looper.myLooper(), e2.getMessage());
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNm();
        }
        AppMethodBeat.o(218864);
    }

    @Override // com.tencent.mm.media.widget.b.c, com.tencent.mm.media.widget.a.d
    public final void b(float f2, float f3, int i2, int i3) {
    }

    @Override // com.tencent.mm.media.widget.b.c, com.tencent.mm.media.widget.a.d
    public final void aPq() {
    }

    @Override // com.tencent.mm.media.widget.b.c, com.tencent.mm.media.widget.a.d
    public final void i(boolean z, int i2) {
    }

    @Override // com.tencent.mm.media.widget.b.c, com.tencent.mm.media.widget.a.d
    public final b aPr() {
        boolean z = true;
        AppMethodBeat.i(218866);
        Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
        if (this.inH == null) {
            Log.i(this.TAG, "generateCameraConfig, camera is null!!");
            AppMethodBeat.o(218866);
            return null;
        } else if (!aPc()) {
            Log.i(this.TAG, "generateCameraConfig, camera not previewing");
            AppMethodBeat.o(218866);
            return null;
        } else {
            b bVar = b.imh;
            b.rs(getPreviewWidth());
            b bVar2 = b.imh;
            b.rr(getPreviewHeight());
            int aPv = aPv();
            boolean z2 = aPv == 90 || aPv == 270;
            b bVar3 = b.imh;
            b.ru(this.ilR.sUz);
            b bVar4 = b.imh;
            b.rv(this.ilR.sUA);
            if (z2) {
                b bVar5 = b.imh;
                int aPl = b.aPl();
                b bVar6 = b.imh;
                b bVar7 = b.imh;
                b.ru(b.aPm());
                b bVar8 = b.imh;
                b.rv(aPl);
            }
            b bVar9 = b.imh;
            b.rt(getOrientation());
            b bVar10 = b.imh;
            if (this.ilM) {
                z = false;
            }
            b.setFrontCamera(z);
            b bVar11 = b.imh;
            b.eZ(this.ilO);
            b bVar12 = this.hAu;
            AppMethodBeat.o(218866);
            return bVar12;
        }
    }

    @Override // com.tencent.mm.media.widget.b.c, com.tencent.mm.media.widget.a.d
    public final Point fa(boolean z) {
        AppMethodBeat.i(218869);
        Point point = new Point(this.ilR.sUz, this.ilR.sUA);
        Log.i(this.TAG, "size is " + point.x + " and " + point.y + ' ');
        AppMethodBeat.o(218869);
        return point;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f2  */
    @Override // com.tencent.mm.media.widget.b.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.hardware.camera2.CameraCharacteristics r14, int r15) {
        /*
        // Method dump skipped, instructions count: 459
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.b.e.a(android.hardware.camera2.CameraCharacteristics, int):void");
    }

    private static int Hu(String str) {
        AppMethodBeat.i(218871);
        p.h(str, "focusMode");
        b.C0437b bVar = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
        if (!p.j(str, b.C0437b.aQC())) {
            b.C0437b bVar2 = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
            if (p.j(str, b.C0437b.aQA())) {
                AppMethodBeat.o(218871);
                return 3;
            }
            b.C0437b bVar3 = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
            if (p.j(str, b.C0437b.aQB())) {
                AppMethodBeat.o(218871);
                return 4;
            }
        }
        AppMethodBeat.o(218871);
        return 1;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.widget.b.c
    public final boolean a(CameraCharacteristics cameraCharacteristics) {
        HashMap<Integer, b.a.C0436b> hashMap;
        b.a.C0436b bVar;
        ArrayList<String> arrayList;
        HashMap<Integer, b.a.C0436b> hashMap2;
        b.a.C0436b bVar2;
        ArrayList<String> arrayList2;
        AppMethodBeat.i(218872);
        if (cameraCharacteristics == null) {
            AppMethodBeat.o(218872);
            return false;
        }
        try {
            int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
            b.a aVar = this.ilS;
            if (!(aVar == null || (hashMap = aVar.irb) == null || (bVar = hashMap.get(Integer.valueOf(aPu()))) == null || (arrayList = bVar.irf) == null)) {
                for (T t : arrayList) {
                    if (iArr == null || !kotlin.a.e.contains(iArr, Hu(t))) {
                        b.a aVar2 = this.ilS;
                        if (p.j((aVar2 == null || (hashMap2 = aVar2.irb) == null || (bVar2 = hashMap2.get(Integer.valueOf(aPu()))) == null || (arrayList2 = bVar2.irf) == null) ? null : (String) j.ku(arrayList2), t)) {
                            Log.e(this.TAG, "all of the focus-mode are not supported yet");
                            AppMethodBeat.o(218872);
                            return false;
                        }
                        Log.e(this.TAG, "not support ".concat(String.valueOf(t)));
                    } else {
                        Log.i(this.TAG, "support ".concat(String.valueOf(t)));
                        CaptureRequest.Builder builder = this.inI;
                        if (builder != null) {
                            builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(Hu(t)));
                        }
                        AppMethodBeat.o(218872);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(218872);
            return true;
        } catch (Exception e2) {
            Log.i(this.TAG, "setFocusMode Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(218872);
            return false;
        }
    }

    private final boolean dh(int i2, int i3) {
        AppMethodBeat.i(218862);
        if (this.surfaceTexture == null || i2 <= 0 || i3 <= 0) {
            AppMethodBeat.o(218862);
            return false;
        }
        try {
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.setDefaultBufferSize(i2, i3);
            }
            this.ilR.sUz = i2;
            this.ilR.sUA = i3;
            Size size = new Size(i2, i3);
            int width2 = size.getWidth();
            int height2 = size.getHeight();
            b bVar = b.inE;
            ImageReader newInstance = ImageReader.newInstance(width2, height2, b.aPC(), 1);
            newInstance.setOnImageAvailableListener(this.ilK.imS, this.ilK.imK);
            this.hiC = newInstance;
            AppMethodBeat.o(218862);
            return true;
        } catch (Exception e2) {
            Log.e(this.TAG, "TryPreviewSize fail:".concat(String.valueOf(e2)));
            AppMethodBeat.o(218862);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.widget.b.c
    public final void aPp() {
        HashMap<Integer, b.a.c> hashMap;
        int i2;
        boolean z;
        Boolean bool;
        Integer num;
        AppMethodBeat.i(218865);
        b.a aVar = this.ilS;
        if (!(aVar == null || (hashMap = aVar.irc) == null)) {
            b.a.c cVar = hashMap.get(Integer.valueOf(aPu()));
            if (cVar == null || (num = cVar.iri) == null) {
                i2 = 15;
            } else {
                i2 = num.intValue();
            }
            this.imx = i2;
            CameraCharacteristics cameraCharacteristics = this.inL;
            b.a.c cVar2 = hashMap.get(Integer.valueOf(aPu()));
            if (cVar2 == null || (bool = cVar2.irj) == null) {
                z = false;
            } else {
                z = bool.booleanValue();
            }
            a(cameraCharacteristics, z);
        }
        b(this.inL);
        a(this.inL);
        AppMethodBeat.o(218865);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.widget.b.c
    public final int getPreviewHeight() {
        AppMethodBeat.i(218867);
        q qVar = this.ilR;
        int intValue = (qVar != null ? Integer.valueOf(qVar.sUA) : null).intValue();
        AppMethodBeat.o(218867);
        return intValue;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.widget.b.c
    public final int getPreviewWidth() {
        AppMethodBeat.i(218868);
        q qVar = this.ilR;
        int intValue = (qVar != null ? Integer.valueOf(qVar.sUz) : null).intValue();
        AppMethodBeat.o(218868);
        return intValue;
    }
}
