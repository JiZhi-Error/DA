package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.f;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002J*\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanTranslateHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "destroy", "", "handleResult", "session", "", "result", "Landroid/os/Bundle;", "jumpResultUI", "originPath", "", "source", "", "originBitmap", "Landroid/graphics/Bitmap;", "captureTime", "processFrame", "bytes", "", "cameraResolution", "Landroid/graphics/Point;", "cameraRotation", "processImage", "filePath", "Companion", "scan-translation_release"})
public final class ah extends e {
    public static final a CHm = new a((byte) 0);

    static {
        AppMethodBeat.i(200123);
        AppMethodBeat.o(200123);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanTranslateHandler$Companion;", "", "()V", "KEY_TRANSLATE_CAMERA_RESOLUTION", "", "KEY_TRANSLATE_CAMERA_ROTATION", "KEY_TRANSLATE_CAPTURE_TIME", "KEY_TRANSLATE_FILE_PATH", "KEY_TRANSLATE_YUV_BYTE_ARRAY", "TAG", "scan-translation_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public ah(Context context) {
        p.h(context, "context");
        AppMethodBeat.i(200122);
        this.context = context;
        AppMethodBeat.o(200122);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e
    public final void c(long j2, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(200120);
        if (bundle == null) {
            AppMethodBeat.o(200120);
            return;
        }
        String string = bundle.getString("key_translate_file_path");
        if (string == null) {
            string = "";
        }
        p.g(string, "result.getString(KEY_TRANSLATE_FILE_PATH) ?: \"\"");
        if (string.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            h.RTc.aZ(new b(this, string));
            AppMethodBeat.o(200120);
            return;
        }
        byte[] byteArray = bundle.getByteArray("key_translate_yuv_byte_array");
        if (byteArray == null) {
            byteArray = new byte[0];
        }
        p.g(byteArray, "result.getByteArray(KEY_…E_ARRAY) ?: byteArrayOf()");
        if (!(byteArray.length == 0)) {
            h.RTc.aZ(new c(this, byteArray, (Point) bundle.getParcelable("key_translate_camera_resolution"), bundle.getInt("key_translate_camera_rotation", 0), bundle.getLong("key_translate_capture_time", 0)));
        }
        AppMethodBeat.o(200120);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ ah CHn;
        final /* synthetic */ String msC;

        b(ah ahVar, String str) {
            this.CHn = ahVar;
            this.msC = str;
        }

        public final void run() {
            AppMethodBeat.i(200118);
            ah.a(this.CHn, this.msC);
            AppMethodBeat.o(200118);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ ah CHn;
        final /* synthetic */ byte[] CHo;
        final /* synthetic */ Point CHp;
        final /* synthetic */ int CHq;
        final /* synthetic */ long CHr;

        c(ah ahVar, byte[] bArr, Point point, int i2, long j2) {
            this.CHn = ahVar;
            this.CHo = bArr;
            this.CHp = point;
            this.CHq = i2;
            this.CHr = j2;
        }

        public final void run() {
            AppMethodBeat.i(200119);
            ah.a(this.CHn, this.CHo, this.CHp, this.CHq, this.CHr);
            AppMethodBeat.o(200119);
        }
    }

    private final void a(String str, int i2, Bitmap bitmap, long j2) {
        AppMethodBeat.i(200121);
        Log.i("MicroMsg.ScanTranslateHandler", "alvinluo jumpResultUI originPath: %s, captureTime: %d", str, Long.valueOf(j2));
        ai.r(str, bitmap);
        Intent intent = new Intent();
        intent.putExtra("key_translation_origin_image_path", str);
        intent.putExtra("key_translation_source", i2);
        intent.putExtra("key_translation_capture_time", j2);
        intent.setClass(this.context, ScanTranslationResultUI.class);
        Context context = this.context;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/scanner/model/ScanTranslateHandler", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/scanner/model/ScanTranslateHandler", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(200121);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e
    public final void destroy() {
    }

    public static final /* synthetic */ void a(ah ahVar, String str) {
        AppMethodBeat.i(200124);
        if (!Util.isNullOrNil(str)) {
            Exif fromFile = Exif.fromFile(str);
            p.g(fromFile, "Exif.fromFile(filePath)");
            int orientationInDegree = fromFile.getOrientationInDegree();
            Log.i("MicroMsg.ScanTranslateHandler", "alvinluo processImage degree %s", Integer.valueOf(orientationInDegree));
            Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(str);
            if (decodeFileWithSample != null) {
                Bitmap rotate = BitmapUtil.rotate(decodeFileWithSample, (float) orientationInDegree);
                if (str == null) {
                    p.hyc();
                }
                p.g(rotate, "originalBitmap");
                ahVar.a(str, 1, rotate, 0);
            }
        }
        AppMethodBeat.o(200124);
    }

    public static final /* synthetic */ void a(ah ahVar, byte[] bArr, Point point, int i2, long j2) {
        boolean z;
        AppMethodBeat.i(200125);
        try {
            if (!(bArr.length == 0)) {
                z = true;
            } else {
                z = false;
            }
            if (z && point != null) {
                long currentTimeMillis = System.currentTimeMillis();
                YuvImage yuvImage = new YuvImage(bArr, 17, point.x, point.y, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, point.x, point.y), 100, byteArrayOutputStream);
                Bitmap decodeByteArray = BitmapUtil.decodeByteArray(byteArrayOutputStream.toByteArray());
                int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                if (decodeByteArray != null) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    Bitmap rotate = BitmapUtil.rotate(decodeByteArray, (float) i2);
                    Log.i("MicroMsg.ScanTranslateHandler", "alvinluo processFrame decode cost %d, rotate cost %d", Integer.valueOf(currentTimeMillis2), Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis3)));
                    if (rotate != null) {
                        String genScanCaptureImgPath = ((f) g.ah(f.class)).genScanCaptureImgPath("jpg");
                        p.g(genScanCaptureImgPath, "originalPath");
                        ahVar.a(genScanCaptureImgPath, 0, rotate, j2);
                        AppMethodBeat.o(200125);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanTranslateHandler", e2, "alvinluo scanTranslate processFrame exception", new Object[0]);
        }
        AppMethodBeat.o(200125);
    }
}
