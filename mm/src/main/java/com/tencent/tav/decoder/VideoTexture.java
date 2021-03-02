package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.lang.reflect.Field;

public class VideoTexture implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "VideoTexture";
    private Filter copyFilter;
    private boolean frameAvailable;
    private final Object frameSyncObject;
    private int preferRotation;
    private boolean quitFlag;
    private RenderContext renderContext;
    private SurfaceTexture surfaceTexture;
    private TextureInfo textureInfo;
    private Matrix textureMatrix;
    private int textureType;

    public TextureInfo getTextureInfo() {
        return this.textureInfo;
    }

    public SurfaceTexture surfaceTexture() {
        return this.surfaceTexture;
    }

    public void setRenderContext(RenderContext renderContext2) {
        this.renderContext = renderContext2;
    }

    public RenderContext getRenderContext() {
        return this.renderContext;
    }

    public Matrix surfaceTextureMatrix() {
        AppMethodBeat.i(218378);
        if (isIdentity() && isOES()) {
            this.textureMatrix = getTextureMatrix(this.surfaceTexture, this.preferRotation);
        }
        Matrix matrix = this.textureMatrix;
        AppMethodBeat.o(218378);
        return matrix;
    }

    private boolean isOES() {
        return this.textureType == 36197;
    }

    private boolean isIdentity() {
        AppMethodBeat.i(218379);
        if (this.textureMatrix == null || this.textureMatrix.isIdentity()) {
            AppMethodBeat.o(218379);
            return true;
        }
        AppMethodBeat.o(218379);
        return false;
    }

    public VideoTexture(TextureInfo textureInfo2) {
        AppMethodBeat.i(218380);
        this.frameSyncObject = new Object();
        this.quitFlag = false;
        this.preferRotation = 0;
        this.textureInfo = textureInfo2;
        this.surfaceTexture = new SurfaceTexture(textureInfo2.textureID);
        if (Build.VERSION.SDK_INT >= 21) {
            this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
        } else {
            this.surfaceTexture.setOnFrameAvailableListener(this);
            reflectLooper();
        }
        this.surfaceTexture.getTransformMatrix(new float[16]);
        this.preferRotation = 0;
        AppMethodBeat.o(218380);
    }

    public VideoTexture(int i2, int i3) {
        this(i2, i3, 36197, 0);
    }

    public VideoTexture(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, RenderContext.createTexture(i4));
        AppMethodBeat.i(218381);
        AppMethodBeat.o(218381);
    }

    public VideoTexture(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(218382);
        this.frameSyncObject = new Object();
        this.quitFlag = false;
        this.preferRotation = 0;
        this.textureType = i4;
        this.surfaceTexture = new SurfaceTexture(i6);
        if (Build.VERSION.SDK_INT >= 21) {
            this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
        } else {
            this.surfaceTexture.setOnFrameAvailableListener(this);
            reflectLooper();
        }
        this.textureInfo = new TextureInfo(i6, i4, i2, i3, null, i5);
        this.preferRotation = i5;
        AppMethodBeat.o(218382);
    }

    public int getPreferRotation() {
        return this.preferRotation;
    }

    private void reflectLooper() {
        Class<?> cls;
        AppMethodBeat.i(218383);
        Class<?>[] declaredClasses = SurfaceTexture.class.getDeclaredClasses();
        int length = declaredClasses.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                cls = null;
                break;
            }
            cls = declaredClasses[i2];
            if (cls.getName().toLowerCase().contains("handler")) {
                break;
            }
            i2++;
        }
        if (cls == null) {
            AppMethodBeat.o(218383);
            return;
        }
        try {
            Object newInstance = cls.getConstructor(SurfaceTexture.class, Looper.class).newInstance(this.surfaceTexture, Looper.getMainLooper());
            Field declaredField = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
            declaredField.setAccessible(true);
            declaredField.set(this.surfaceTexture, newInstance);
            AppMethodBeat.o(218383);
        } catch (Exception e2) {
            Logger.e(TAG, "reflectLooper", e2);
            AppMethodBeat.o(218383);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean awaitNewImage() {
        AppMethodBeat.i(218384);
        boolean awaitNewImage = awaitNewImage(3000);
        AppMethodBeat.o(218384);
        return awaitNewImage;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r11.quitFlag == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        r11.quitFlag = false;
        com.tencent.matrix.trace.core.AppMethodBeat.o(218385);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        com.tencent.tav.decoder.RenderContext.checkEglError("before updateTexImage");
        r11.surfaceTexture.updateTexImage();
        r2 = getTextureMatrix(r11.surfaceTexture, r11.preferRotation);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (r2 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        if ("HUAWEI_ARE-AL00".equals(com.tencent.tav.Utils.getPhoneName()) == false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        if (r11.preferRotation != 1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0071, code lost:
        r3 = new float[9];
        r2.getValues(r3);
        r2.setValues(new float[]{-r3[4], 0.0f, r3[4], 0.0f, r3[0], r3[2], r3[6], r3[7], r3[8]});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ac, code lost:
        r11.textureInfo.setTextureMatrix(r2);
        com.tencent.matrix.trace.core.AppMethodBeat.o(218385);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean awaitNewImage(long r12) {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.VideoTexture.awaitNewImage(long):boolean");
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
        AppMethodBeat.i(218386);
        synchronized (this.frameSyncObject) {
            try {
                if (this.frameAvailable) {
                    new RuntimeException("frameAvailable already set, frame could be dropped");
                    return;
                }
                this.frameAvailable = true;
                this.frameSyncObject.notifyAll();
                AppMethodBeat.o(218386);
            } finally {
                AppMethodBeat.o(218386);
            }
        }
    }

    public void quitIfWaiting() {
        AppMethodBeat.i(218387);
        synchronized (this.frameSyncObject) {
            try {
                this.quitFlag = true;
                this.frameSyncObject.notifyAll();
            } finally {
                AppMethodBeat.o(218387);
            }
        }
    }

    private Matrix getTextureMatrix(SurfaceTexture surfaceTexture2, int i2) {
        AppMethodBeat.i(218388);
        float[] fArr = new float[16];
        surfaceTexture2.getTransformMatrix(fArr);
        float f2 = fArr[0];
        float f3 = fArr[4];
        float f4 = fArr[12];
        float f5 = fArr[1];
        float f6 = fArr[5];
        float f7 = fArr[13];
        Matrix matrix = new Matrix();
        Matrix matrix2 = new Matrix();
        if (i2 != 0) {
            DecoderUtils.getRotationMatrix(matrix2, i2, 1.0f, 1.0f);
        }
        if (((float) ((int) f2)) == f2 && ((float) ((int) f5)) == f5 && ((float) ((int) f3)) == f3 && ((float) ((int) f6)) == f6) {
            matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
            if (i2 != 0) {
                matrix.preConcat(matrix2);
            }
        } else {
            matrix.setValues(new float[]{f2, f3, f4, f5, f6, f7, 0.0f, 0.0f, 1.0f});
        }
        if (i2 != 0) {
            Matrix matrix3 = new Matrix();
            matrix2.invert(matrix3);
            matrix.postConcat(matrix3);
        }
        AppMethodBeat.o(218388);
        return matrix;
    }

    public void release() {
        AppMethodBeat.i(218389);
        releaseTextureInfo();
        releaseSurfaceTexture();
        releaseFilter();
        AppMethodBeat.o(218389);
    }

    private void releaseFilter() {
        AppMethodBeat.i(218390);
        if (this.copyFilter != null) {
            this.copyFilter.release();
        }
        AppMethodBeat.o(218390);
    }

    private void releaseTextureInfo() {
        AppMethodBeat.i(218391);
        if (this.textureInfo != null) {
            this.textureInfo.release();
            this.textureInfo = null;
        }
        AppMethodBeat.o(218391);
    }

    public void releaseSurfaceTexture() {
        AppMethodBeat.i(218392);
        if (this.surfaceTexture != null) {
            this.surfaceTexture.release();
            this.surfaceTexture = null;
        }
        AppMethodBeat.o(218392);
    }

    public TextureInfo copyTexture() {
        AppMethodBeat.i(218393);
        if (this.copyFilter == null) {
            this.copyFilter = new Filter();
            this.copyFilter.setRendererWidth(this.renderContext.width());
            this.copyFilter.setRendererHeight(this.renderContext.height());
            this.copyFilter.setRenderForScreen(false);
        }
        TextureInfo applyFilter = this.copyFilter.applyFilter(this.textureInfo, null, this.textureInfo.getTextureMatrix());
        AppMethodBeat.o(218393);
        return applyFilter;
    }
}
