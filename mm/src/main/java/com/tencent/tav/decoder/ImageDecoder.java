package com.tencent.tav.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.e.a;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ImageDecoder implements IVideoDecoder {
    public static final CGSize IMAGE_DECODE_SIZE = new CGSize(720.0f, 1280.0f);
    private static final String TAG = "ImageDecoder";
    private Bitmap bitmap;
    private CMTime currentDecoderTime = CMTime.CMTimeInvalid;
    private CGSize displaySize;
    private CMTime frameDuration = new CMTime(1, 30);
    private int preferRotation = 0;
    private String sourceImagePath;
    private TextureInfo textureInfo;
    private long threadId = -1;
    private CMTimeRange timeRange;

    public ImageDecoder() {
        AppMethodBeat.i(218214);
        AppMethodBeat.o(218214);
    }

    static {
        AppMethodBeat.i(218227);
        AppMethodBeat.o(218227);
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public void init(String str, CGSize cGSize, IDecoderTrack.SurfaceCreator surfaceCreator) {
        this.sourceImagePath = str;
        this.displaySize = cGSize;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public void start(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218215);
        start(cMTimeRange, CMTime.CMTimeZero);
        AppMethodBeat.o(218215);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public void start(CMTimeRange cMTimeRange, CMTime cMTime) {
        AppMethodBeat.i(218216);
        if (cMTimeRange == null) {
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.frameDuration);
            AppMethodBeat.o(218216);
            return;
        }
        this.timeRange = new CMTimeRange(cMTimeRange.getStart(), cMTimeRange.getDuration());
        AppMethodBeat.o(218216);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public ByteBuffer outputBuffer() {
        return null;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public String getSourcePath() {
        return this.sourceImagePath;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public boolean hasTrack() {
        return this.sourceImagePath != null;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public void seekTo(CMTime cMTime) {
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public void seekTo(CMTime cMTime, boolean z) {
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public CMSampleState readSample() {
        AppMethodBeat.i(218217);
        CMSampleState readSample = readSample(this.currentDecoderTime.add(this.frameDuration));
        AppMethodBeat.o(218217);
        return readSample;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public CMTime nextFrameTime(CMTime cMTime) {
        AppMethodBeat.i(218218);
        CMTime add = cMTime.add(this.frameDuration);
        AppMethodBeat.o(218218);
        return add;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public boolean isLastFrameValid() {
        return true;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public void switchFrame() {
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized CMSampleState readSample(CMTime cMTime) {
        CMSampleState cMSampleState;
        AppMethodBeat.i(218219);
        if (cMTime.bigThan(this.timeRange.getDuration())) {
            cMSampleState = CMSampleState.fromError(-1);
            AppMethodBeat.o(218219);
        } else {
            createTexture();
            cMSampleState = new CMSampleState(cMTime);
            AppMethodBeat.o(218219);
        }
        return cMSampleState;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public void release() {
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public TextureInfo getTextureInfo() {
        return this.textureInfo;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public long getPreReadCost() {
        return 0;
    }

    private void checkThread() {
        AppMethodBeat.i(218220);
        if (!(this.threadId == -1 || this.threadId == Thread.currentThread().getId())) {
            Logger.e(TAG, "线程不对，注意EGL相关的泄露问题！threadId = " + this.threadId + ", Thread.currentThread() name = " + Thread.currentThread().getName(), new RuntimeException());
        }
        AppMethodBeat.o(218220);
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public synchronized void release(boolean z) {
        AppMethodBeat.i(218221);
        checkThread();
        if (this.textureInfo != null) {
            this.textureInfo.release();
            this.textureInfo = null;
        }
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
        AppMethodBeat.o(218221);
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public Surface outputSurface() {
        return null;
    }

    private Bitmap decodeBitmap(String str, CGSize cGSize) {
        int i2 = 1;
        AppMethodBeat.i(218222);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        if (cGSize != null) {
            i2 = (int) (((float) options.outWidth) / cGSize.width);
        }
        options2.inSampleSize = i2;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
        AppMethodBeat.o(218222);
        return decodeFile;
    }

    public static CGSize getDefaultOutputImageSize(String str) {
        AppMethodBeat.i(218223);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = (int) (((float) options.outWidth) / IMAGE_DECODE_SIZE.width);
        options2.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options2);
        int i2 = options2.outWidth;
        int i3 = options2.outHeight;
        if (readImagePreferRotation(str) % 2 == 1) {
            CGSize cGSize = new CGSize((float) i3, (float) i2);
            AppMethodBeat.o(218223);
            return cGSize;
        }
        CGSize cGSize2 = new CGSize((float) i2, (float) i3);
        AppMethodBeat.o(218223);
        return cGSize2;
    }

    private synchronized TextureInfo createTexture() {
        TextureInfo textureInfo2;
        AppMethodBeat.i(218224);
        if (this.textureInfo == null || this.textureInfo.isReleased()) {
            if (this.bitmap == null) {
                this.bitmap = decodeBitmap(this.sourceImagePath, this.displaySize);
                this.preferRotation = readImagePreferRotation(this.sourceImagePath);
            }
            if (this.bitmap != null) {
                this.threadId = Thread.currentThread().getId();
                this.textureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, this.bitmap.getWidth(), this.bitmap.getHeight(), getImageTextureMatrix(), this.preferRotation);
                GLES20.glBindTexture(3553, this.textureInfo.textureID);
                GLUtils.texImage2D(3553, 0, this.bitmap, 0);
                GLES20.glBindTexture(3553, 0);
                textureInfo2 = this.textureInfo;
                AppMethodBeat.o(218224);
            } else {
                textureInfo2 = null;
                AppMethodBeat.o(218224);
            }
        } else {
            textureInfo2 = this.textureInfo;
            AppMethodBeat.o(218224);
        }
        return textureInfo2;
    }

    private Matrix getImageTextureMatrix() {
        AppMethodBeat.i(218225);
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
        AppMethodBeat.o(218225);
        return matrix;
    }

    private static int readImagePreferRotation(String str) {
        int i2 = 1;
        AppMethodBeat.i(218226);
        try {
            switch (new ExifInterface(str).getAttributeInt(a.TAG_ORIENTATION, 1)) {
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 7:
                default:
                    i2 = 0;
                    break;
                case 6:
                    i2 = 3;
                    break;
                case 8:
                    break;
            }
            AppMethodBeat.o(218226);
            return i2;
        } catch (IOException e2) {
            Logger.e(TAG, "readImagePreferRotation", e2);
            AppMethodBeat.o(218226);
            return 0;
        }
    }
}
