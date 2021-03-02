package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.utils.MathUtils;
import com.tencent.tavkit.utils.TAVBitmapUtils;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CIImage implements Cloneable {
    private static Bitmap.Config[] SUPPORT_CONFIGS = {Bitmap.Config.ALPHA_8, Bitmap.Config.RGB_565, Bitmap.Config.ARGB_4444, Bitmap.Config.ARGB_8888};
    private final String TAG;
    private float alpha;
    private Bitmap bitmap;
    private CGRect frame;
    private boolean isHardMode;
    private final List<CIImage> overlayImages;
    private int preferRotation;
    private int rotation;
    private final CGSize size;
    private String textureCacheKey;
    private TextureInfo textureInfo;
    private Matrix transform;

    public CIImage(CGSize cGSize) {
        AppMethodBeat.i(197285);
        this.TAG = "CIImage@" + Integer.toHexString(hashCode());
        this.overlayImages = new ArrayList();
        this.isHardMode = false;
        this.alpha = 1.0f;
        Logger.v(this.TAG, "CIImage() called with: renderSize = [" + cGSize + "]");
        this.size = cGSize;
        AppMethodBeat.o(197285);
    }

    public CIImage(TextureInfo textureInfo2) {
        AppMethodBeat.i(197286);
        this.TAG = "CIImage@" + Integer.toHexString(hashCode());
        this.overlayImages = new ArrayList();
        this.isHardMode = false;
        this.alpha = 1.0f;
        Logger.v(this.TAG, "CIImage() called with: textureInfo = [" + textureInfo2 + "]");
        this.textureInfo = textureInfo2;
        this.size = new CGSize((float) textureInfo2.width, (float) textureInfo2.height);
        AppMethodBeat.o(197286);
    }

    public CIImage(Bitmap bitmap2) {
        AppMethodBeat.i(197287);
        this.TAG = "CIImage@" + Integer.toHexString(hashCode());
        this.overlayImages = new ArrayList();
        this.isHardMode = false;
        this.alpha = 1.0f;
        Logger.v(this.TAG, "CIImage() called with: bitmap = [" + bitmap2 + "]");
        this.bitmap = checkBitmapConfig(bitmap2);
        this.size = new CGSize((float) bitmap2.getWidth(), (float) bitmap2.getHeight());
        AppMethodBeat.o(197287);
    }

    public CIImage(String str) {
        this(str, null);
    }

    public CIImage(String str, CGSize cGSize) {
        AppMethodBeat.i(197288);
        this.TAG = "CIImage@" + Integer.toHexString(hashCode());
        this.overlayImages = new ArrayList();
        this.isHardMode = false;
        this.alpha = 1.0f;
        long currentTimeMillis = System.currentTimeMillis();
        this.preferRotation = TAVBitmapUtils.readImagePreferRotation(str);
        this.bitmap = decodeBitmap(str, cGSize);
        this.bitmap = checkBitmapConfig(this.bitmap);
        if (this.bitmap != null) {
            this.size = new CGSize((float) this.bitmap.getWidth(), (float) this.bitmap.getHeight());
            Logger.v(this.TAG, "CIImage() called with: imagePath = [" + str + "], sampleSize = " + cGSize + ", BitmapFactory.decodeFile cons ms = " + (System.currentTimeMillis() - currentTimeMillis) + ", outBitmapSize = " + this.size);
            AppMethodBeat.o(197288);
            return;
        }
        Logger.e(this.TAG, "CIImage: 图片解码失败！imagePath = ".concat(String.valueOf(str)));
        this.size = new CGSize();
        AppMethodBeat.o(197288);
    }

    private Bitmap decodeBitmap(String str, CGSize cGSize) {
        int i2 = 1;
        AppMethodBeat.i(197289);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        if (cGSize != null) {
            i2 = (int) (((float) options.outWidth) / cGSize.width);
        }
        options2.inSampleSize = i2;
        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
        AppMethodBeat.o(197289);
        return decodeFile;
    }

    private Bitmap checkBitmapConfig(Bitmap bitmap2) {
        AppMethodBeat.i(197290);
        if (Arrays.binarySearch(SUPPORT_CONFIGS, bitmap2.getConfig()) < 0) {
            Bitmap transcodeBitmap = transcodeBitmap(bitmap2);
            AppMethodBeat.o(197290);
            return transcodeBitmap;
        }
        AppMethodBeat.o(197290);
        return bitmap2;
    }

    private Bitmap transcodeBitmap(Bitmap bitmap2) {
        AppMethodBeat.i(197291);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        AppMethodBeat.o(197291);
        return createBitmap;
    }

    public CGSize getSize() {
        return this.size;
    }

    public boolean isCanvasImage() {
        return this.bitmap == null && this.textureInfo == null;
    }

    public CGRect getExtent() {
        AppMethodBeat.i(197292);
        CGRect cGRect = new CGRect(new PointF(0.0f, 0.0f), this.size);
        AppMethodBeat.o(197292);
        return cGRect;
    }

    public Matrix getTransform() {
        return this.transform;
    }

    public void setHardMode(boolean z) {
        this.isHardMode = z;
    }

    public void setAlpha(float f2) {
        this.alpha = f2;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void reset() {
        AppMethodBeat.i(197293);
        Logger.v(this.TAG, "reset() called, before transform = " + this.transform);
        if (this.transform != null) {
            this.transform = null;
        }
        AppMethodBeat.o(197293);
    }

    public CIImage imageByCompositingOverImage(CIImage cIImage) {
        AppMethodBeat.i(197294);
        Logger.v(this.TAG, "imageByCompositingOverImage() called with: destImage = [" + cIImage + "]");
        cIImage.addOverlayImage(this);
        AppMethodBeat.o(197294);
        return cIImage;
    }

    public CIImage imageByApplyingTransform(Matrix matrix) {
        AppMethodBeat.i(197295);
        if (this.transform == null) {
            this.transform = new Matrix();
        }
        this.transform.postConcat(matrix);
        Logger.v(this.TAG, "imageByApplyingTransform() called with: in transform = [" + matrix + "], result transform = " + this.transform);
        AppMethodBeat.o(197295);
        return this;
    }

    private void addOverlayImage(CIImage cIImage) {
        AppMethodBeat.i(197296);
        synchronized (this) {
            try {
                this.overlayImages.add(cIImage);
            } finally {
                AppMethodBeat.o(197296);
            }
        }
    }

    public void applyFlip(boolean z, boolean z2) {
        float f2;
        float f3 = 0.0f;
        float f4 = -1.0f;
        AppMethodBeat.i(197297);
        if (z || z2) {
            float f5 = z ? -1.0f : 1.0f;
            if (z) {
                f2 = this.size.width;
            } else {
                f2 = 0.0f;
            }
            if (!z2) {
                f4 = 1.0f;
            }
            if (z2) {
                f3 = this.size.height;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f5, f4);
            matrix.postTranslate(f2, f3);
            imageByApplyingTransform(matrix);
            AppMethodBeat.o(197297);
            return;
        }
        AppMethodBeat.o(197297);
    }

    public void applyPreferRotation() {
        AppMethodBeat.i(197298);
        applyPreferRotation(0);
        AppMethodBeat.o(197298);
    }

    public void applyPreferRotation(int i2) {
        AppMethodBeat.i(197299);
        TextureInfo drawTextureInfo = getDrawTextureInfo();
        if (drawTextureInfo == null) {
            AppMethodBeat.o(197299);
            return;
        }
        this.rotation = drawTextureInfo.preferRotation + i2;
        if (this.rotation == 0) {
            AppMethodBeat.o(197299);
            return;
        }
        Logger.v(this.TAG, "applyPreferRotation: textureInfo.preferRotation = " + this.rotation);
        Matrix matrix = new Matrix();
        DecoderUtils.getRotationMatrix(matrix, this.rotation, (float) drawTextureInfo.width, (float) drawTextureInfo.height);
        imageByApplyingTransform(matrix);
        if (this.rotation % 2 == 1) {
            this.size.width = (float) drawTextureInfo.height;
            this.size.height = (float) drawTextureInfo.width;
        }
        AppMethodBeat.o(197299);
    }

    public CIImage imageByCroppingToRect(CGRect cGRect) {
        AppMethodBeat.i(197300);
        if (!Utils.isRectValid(cGRect)) {
            AppMethodBeat.o(197300);
        } else {
            Logger.v(this.TAG, "imageByCroppingToRect: frame = [" + cGRect + "]");
            this.size.width = cGRect.size.width;
            this.size.height = cGRect.size.height;
            if (this.rotation % 2 != 0) {
                this.frame = new CGRect(cGRect.origin.y, cGRect.origin.x, cGRect.size.height, cGRect.size.width);
            } else {
                this.frame = cGRect.clone();
            }
            PointF pointF = cGRect.origin;
            if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
                Matrix matrix = new Matrix();
                matrix.postTranslate(-pointF.x, -pointF.y);
                imageByApplyingTransform(matrix);
            }
            AppMethodBeat.o(197300);
        }
        return this;
    }

    public CIImage safeApplyTransform(Matrix matrix) {
        AppMethodBeat.i(197301);
        if (matrix == null || matrix.isIdentity()) {
            AppMethodBeat.o(197301);
            return this;
        }
        Logger.v(this.TAG, "safeApplyTransform: transform = [" + matrix + "]");
        float f2 = getExtent().origin.x + (getExtent().size.width / 2.0f);
        float f3 = getExtent().origin.y + (getExtent().size.height / 2.0f);
        Matrix matrix2 = new Matrix();
        matrix2.postTranslate(-f2, -f3);
        matrix2.postConcat(matrix);
        Matrix matrix3 = new Matrix();
        matrix3.postTranslate(f2, f3);
        matrix2.postConcat(matrix3);
        CIImage imageByApplyingTransform = imageByApplyingTransform(matrix2);
        AppMethodBeat.o(197301);
        return imageByApplyingTransform;
    }

    public void applyFixInSize(CGSize cGSize, TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        CGSize sizeScale;
        AppMethodBeat.i(197302);
        if (!Utils.isSizeValid(cGSize)) {
            AppMethodBeat.o(197302);
            return;
        }
        switch (tAVVideoConfigurationContentMode) {
            case aspectFit:
                sizeScale = MathUtils.sizeFit(this.size, cGSize);
                break;
            case aspectFill:
                sizeScale = MathUtils.sizeFill(this.size, cGSize);
                break;
            case scaleToFit:
                sizeScale = MathUtils.sizeScale(this.size, cGSize);
                break;
            default:
                sizeScale = MathUtils.sizeFit(this.size, cGSize);
                break;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(sizeScale.width / this.size.width, sizeScale.height / this.size.height);
        imageByApplyingTransform(matrix);
        this.size.height = sizeScale.height;
        this.size.width = sizeScale.width;
        AppMethodBeat.o(197302);
    }

    public CIImage imageApplyFillInFrame(CGRect cGRect, TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        AppMethodBeat.i(197303);
        TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode2 = TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill;
        applyFillInFrame(cGRect, tAVVideoConfigurationContentMode);
        AppMethodBeat.o(197303);
        return this;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void applyFillInFrame(CGRect cGRect, TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        AppMethodBeat.i(197304);
        Matrix matrix = new Matrix();
        switch (tAVVideoConfigurationContentMode) {
            case aspectFit:
                matrix.postConcat(MathUtils.transformBySourceRectFit(getExtent(), cGRect));
                imageByApplyingTransform(matrix);
                AppMethodBeat.o(197304);
                return;
            case aspectFill:
                matrix.postConcat(MathUtils.transformBySourceRectFill(getExtent(), cGRect));
                imageByApplyingTransform(matrix);
                AppMethodBeat.o(197304);
                return;
            case scaleToFit:
                Matrix matrix2 = new Matrix();
                matrix2.postScale(cGRect.size.width / getExtent().size.width, cGRect.size.height / getExtent().size.height);
                matrix.postConcat(matrix2);
                Matrix matrix3 = new Matrix();
                matrix3.postTranslate(cGRect.origin.x, cGRect.origin.y);
                matrix.postConcat(matrix3);
                imageByApplyingTransform(matrix);
                break;
        }
        AppMethodBeat.o(197304);
    }

    public void draw(TextureFilter textureFilter) {
        AppMethodBeat.i(197305);
        TextureInfo drawTextureInfo = getDrawTextureInfo();
        if (drawTextureInfo != null) {
            Logger.v(this.TAG, "draw: with drawTexture = " + drawTextureInfo + ", filter = " + textureFilter);
            textureFilter.applyFilter(drawTextureInfo, this.transform, drawTextureInfo.getTextureMatrix(), this.alpha, this.frame);
        }
        if (this.overlayImages.isEmpty()) {
            AppMethodBeat.o(197305);
            return;
        }
        Logger.v(this.TAG, "draw: with: draw overlayImages = " + this.overlayImages + ", filter = " + textureFilter);
        for (CIImage cIImage : this.overlayImages) {
            cIImage.draw(textureFilter);
        }
        AppMethodBeat.o(197305);
    }

    public TextureInfo getDrawTextureInfo() {
        AppMethodBeat.i(197306);
        if (this.textureInfo != null) {
            TextureInfo textureInfo2 = this.textureInfo;
            AppMethodBeat.o(197306);
            return textureInfo2;
        }
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        if (this.textureCacheKey == null) {
            this.textureCacheKey = String.valueOf(hashCode());
        }
        TextureInfo textureInfo3 = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
        if (eglGetCurrentContext != null && textureInfo3 != null && !textureInfo3.isReleased()) {
            AppMethodBeat.o(197306);
            return textureInfo3;
        } else if (this.bitmap != null) {
            TextureInfo textureInfo4 = new TextureInfo(RenderContext.createTexture(3553), 3553, this.bitmap.getWidth(), this.bitmap.getHeight(), getImageTextureMatrix(), this.preferRotation);
            GLES20.glBindTexture(3553, textureInfo4.textureID);
            GLUtils.texImage2D(3553, 0, this.bitmap, 0);
            GLES20.glBindTexture(3553, 0);
            ThreadLocalTextureCache.getInstance().putTextureInfo(this.textureCacheKey, textureInfo4);
            Logger.v(this.TAG, "getDrawTextureInfo: bind bitmap texture, texture = " + textureInfo4 + ", eglContext = " + eglGetCurrentContext);
            if (this.isHardMode) {
                this.bitmap.recycle();
                this.bitmap = null;
                Logger.v(this.TAG, "getDrawTextureInfo: isHardMode, bitmap.recycle()");
            }
            AppMethodBeat.o(197306);
            return textureInfo4;
        } else {
            AppMethodBeat.o(197306);
            return null;
        }
    }

    @Deprecated
    public Bitmap convertToBitmap() {
        AppMethodBeat.i(197307);
        Bitmap saveBitmap = TAVGLUtils.saveBitmap(this);
        AppMethodBeat.o(197307);
        return saveBitmap;
    }

    private Matrix getImageTextureMatrix() {
        AppMethodBeat.i(197308);
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
        AppMethodBeat.o(197308);
        return matrix;
    }

    public synchronized void release() {
        AppMethodBeat.i(197309);
        Logger.d(this.TAG, "release() start");
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
        TextureInfo textureInfo2 = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
        if (textureInfo2 != null) {
            textureInfo2.release();
            ThreadLocalTextureCache.getInstance().remove(this.textureCacheKey);
        }
        for (CIImage cIImage : this.overlayImages) {
            if (cIImage != null) {
                cIImage.release();
            }
        }
        this.overlayImages.clear();
        Logger.d(this.TAG, "release() end");
        AppMethodBeat.o(197309);
    }

    @Override // java.lang.Object
    public CIImage clone() {
        AppMethodBeat.i(197310);
        CIImage cIImage = new CIImage(this.size.clone());
        cIImage.textureInfo = this.textureInfo;
        cIImage.textureCacheKey = this.textureCacheKey;
        cIImage.bitmap = this.bitmap;
        cIImage.preferRotation = this.preferRotation;
        cIImage.transform = new Matrix(this.transform);
        cIImage.frame = this.frame != null ? new CGRect(this.frame.origin, this.frame.size) : null;
        cIImage.overlayImages.clear();
        cIImage.overlayImages.addAll(this.overlayImages);
        cIImage.alpha = this.alpha;
        AppMethodBeat.o(197310);
        return cIImage;
    }

    public CIImage simpleClone() {
        AppMethodBeat.i(197311);
        CIImage cIImage = new CIImage(this.size.clone());
        cIImage.textureInfo = this.textureInfo;
        cIImage.preferRotation = this.preferRotation;
        cIImage.bitmap = this.bitmap;
        cIImage.alpha = this.alpha;
        AppMethodBeat.o(197311);
        return cIImage;
    }

    public String toString() {
        AppMethodBeat.i(197312);
        String str = "CIImage{hash=" + Integer.toHexString(hashCode()) + ", size=" + this.size + ", textureInfo=" + this.textureInfo + ", bitmap=" + this.bitmap + ", transform=" + this.transform + ", frame=" + this.frame + ", overlayImages=" + this.overlayImages + '}';
        AppMethodBeat.o(197312);
        return str;
    }
}
