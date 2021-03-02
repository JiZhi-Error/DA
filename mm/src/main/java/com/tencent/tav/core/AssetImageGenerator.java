package com.tencent.tav.core;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class AssetImageGenerator {
    private final String TAG;
    private ApertureMode apertureMode;
    private boolean appliesPreferredTrackTransform;
    protected Asset asset;
    protected AssetExtension assetExtension;
    private final ImageGeneratorThread generatorThread;
    private long generatorThreadId;
    private CGSize maximumSize;
    private ByteBuffer outBitmapReaderBuffer;
    private String outSavePath;
    private OutputBitmapFactory outputBitmapFactory;
    private RenderContext renderContext;
    private RenderContextParams renderContextParams;
    private VideoCompositing videoCompositing;
    private VideoComposition videoComposition;
    private VideoCompositionDecoderTrack videoCompositionDecoderTrack;

    public interface ImageGeneratorListener {
        void onCompletion(CMTime cMTime, Bitmap bitmap, CMTime cMTime2, AssetImageGeneratorResult assetImageGeneratorResult);
    }

    public interface OutputBitmapFactory {
        Bitmap getOutputBitmap(int i2, int i3);
    }

    static /* synthetic */ void access$500(AssetImageGenerator assetImageGenerator) {
        AppMethodBeat.i(217766);
        assetImageGenerator.doRelease();
        AppMethodBeat.o(217766);
    }

    public enum AssetImageGeneratorResult {
        AssetImageGeneratorSucceeded,
        AssetImageGeneratorFailed,
        AssetImageGeneratorCancelled;

        public static AssetImageGeneratorResult valueOf(String str) {
            AppMethodBeat.i(217740);
            AssetImageGeneratorResult assetImageGeneratorResult = (AssetImageGeneratorResult) Enum.valueOf(AssetImageGeneratorResult.class, str);
            AppMethodBeat.o(217740);
            return assetImageGeneratorResult;
        }

        static {
            AppMethodBeat.i(217741);
            AppMethodBeat.o(217741);
        }
    }

    public enum ApertureMode {
        aspectFit,
        aspectFill,
        scaleToFit;

        public static ApertureMode valueOf(String str) {
            AppMethodBeat.i(217737);
            ApertureMode apertureMode = (ApertureMode) Enum.valueOf(ApertureMode.class, str);
            AppMethodBeat.o(217737);
            return apertureMode;
        }

        static {
            AppMethodBeat.i(217738);
            AppMethodBeat.o(217738);
        }
    }

    public AssetImageGenerator(Asset asset2) {
        this(asset2, new AssetExtension(AssetExtension.SCENE_THUMBNAIL));
        AppMethodBeat.i(217751);
        AppMethodBeat.o(217751);
    }

    public AssetImageGenerator(Asset asset2, AssetExtension assetExtension2) {
        AppMethodBeat.i(217752);
        this.TAG = "AssetImageGenerator@" + Integer.toHexString(hashCode());
        this.generatorThreadId = -1;
        this.asset = asset2;
        this.assetExtension = assetExtension2;
        this.apertureMode = ApertureMode.aspectFit;
        this.generatorThread = new ImageGeneratorThread("image_generator");
        this.generatorThread.start();
        ImageGeneratorThread.access$000(this.generatorThread);
        AppMethodBeat.o(217752);
    }

    public void setAppliesPreferredTrackTransform(boolean z) {
        this.appliesPreferredTrackTransform = z;
    }

    public void setMaximumSize(CGSize cGSize) {
        this.maximumSize = cGSize;
    }

    public void setApertureMode(ApertureMode apertureMode2) {
        this.apertureMode = apertureMode2;
    }

    public void setVideoComposition(VideoComposition videoComposition2) {
        this.videoComposition = videoComposition2;
    }

    public AssetExtension getAssetExtension() {
        return this.assetExtension;
    }

    public void setOutSavePath(String str) {
        this.outSavePath = str;
    }

    public void setOutputBitmapFactory(OutputBitmapFactory outputBitmapFactory2) {
        this.outputBitmapFactory = outputBitmapFactory2;
    }

    public void setRenderContextParams(RenderContextParams renderContextParams2) {
        AppMethodBeat.i(217753);
        this.renderContextParams = renderContextParams2;
        if (this.renderContext != null) {
            this.renderContext.setParams(renderContextParams2);
        }
        AppMethodBeat.o(217753);
    }

    public RenderContextParams getRenderContextParams() {
        return this.renderContextParams;
    }

    public Bitmap copyCGImageAtTimeAndActualTime(CMTime cMTime, CMTime cMTime2) {
        AppMethodBeat.i(217754);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Exception exc = new Exception("cannot process in the main thread");
            AppMethodBeat.o(217754);
            throw exc;
        }
        Bitmap doGenerator = doGenerator(cMTime);
        AppMethodBeat.o(217754);
        return doGenerator;
    }

    public void generateCGImagesAsynchronouslyForTimes(List<CMTime> list, ImageGeneratorListener imageGeneratorListener) {
        AppMethodBeat.i(217755);
        this.generatorThread.setRequestedTimes(list);
        this.generatorThread.setGeneratorListener(imageGeneratorListener);
        ImageGeneratorThread.access$100(this.generatorThread);
        AppMethodBeat.o(217755);
    }

    public void release() {
        AppMethodBeat.i(217756);
        if (Thread.currentThread().getId() != this.generatorThreadId) {
            ImageGeneratorThread.access$200(this.generatorThread);
            this.videoComposition = null;
            AppMethodBeat.o(217756);
            return;
        }
        doRelease();
        this.generatorThread.quit();
        AppMethodBeat.o(217756);
    }

    private void doRelease() {
        AppMethodBeat.i(217757);
        Logger.d(this.TAG, "doRelease: start, thread = " + Thread.currentThread().getName());
        if (this.videoCompositionDecoderTrack != null) {
            this.videoCompositionDecoderTrack.release();
            this.videoCompositionDecoderTrack = null;
        }
        if (this.videoCompositing != null) {
            this.videoCompositing.release();
            this.videoCompositing = null;
        }
        if (this.renderContext != null) {
            this.renderContext.release();
            this.renderContext = null;
        }
        this.videoComposition = null;
        Logger.d(this.TAG, "doRelease: end, thread = " + Thread.currentThread().getName());
        AppMethodBeat.o(217757);
    }

    private Bitmap doGenerator(CMTime cMTime) {
        AppMethodBeat.i(217758);
        RenderContext initRenderContext = initRenderContext();
        CMSampleBuffer cmSampleBuffer = getCmSampleBuffer(cMTime, initRenderContext);
        if (!initRenderContext.isPBufferEnable()) {
            Bitmap bitmapFromFBO = bitmapFromFBO(initRenderContext, cmSampleBuffer);
            AppMethodBeat.o(217758);
            return bitmapFromFBO;
        }
        Bitmap readBitmap = readBitmap(renderToMaximumSizeBox(initRenderContext, cmSampleBuffer));
        AppMethodBeat.o(217758);
        return readBitmap;
    }

    private RenderContext initRenderContext() {
        AppMethodBeat.i(217759);
        this.generatorThreadId = Thread.currentThread().getId();
        if (this.renderContext == null) {
            CGSize naturalSize = this.maximumSize != null ? this.maximumSize : this.asset.getNaturalSize();
            this.renderContext = new RenderContext((int) naturalSize.width, (int) naturalSize.height);
            this.renderContext.setParams(this.renderContextParams);
        }
        this.renderContext.makeCurrent();
        RenderContext renderContext2 = this.renderContext;
        AppMethodBeat.o(217759);
        return renderContext2;
    }

    private CMSampleBuffer getCmSampleBuffer(CMTime cMTime, RenderContext renderContext2) {
        AppMethodBeat.i(217760);
        if (this.videoCompositionDecoderTrack == null) {
            this.videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.asset, this.assetExtension, 1);
            for (AssetTrack assetTrack : this.asset.getTracks()) {
                if (assetTrack.getMediaType() == 1) {
                    this.videoCompositionDecoderTrack.addTrack(assetTrack);
                }
            }
            this.videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
            this.videoCompositing = this.videoComposition == null ? null : this.videoComposition.getCustomVideoCompositor();
            this.videoCompositionDecoderTrack.setVideoCompositing(this.videoCompositing);
            this.videoCompositionDecoderTrack.start(renderContext2);
        }
        this.videoCompositionDecoderTrack.seekTo(cMTime, false, true);
        CMSampleBuffer readSample = this.videoCompositionDecoderTrack.readSample(cMTime);
        AppMethodBeat.o(217760);
        return readSample;
    }

    private CGSize renderToMaximumSizeBox(RenderContext renderContext2, CMSampleBuffer cMSampleBuffer) {
        CGSize cGSize;
        AppMethodBeat.i(217761);
        TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
        if (this.maximumSize != null) {
            cGSize = this.maximumSize;
        } else {
            cGSize = new CGSize((float) textureInfo.width, (float) textureInfo.height);
        }
        if (textureInfo != null) {
            Filter filter = new Filter();
            filter.setRendererWidth((int) cGSize.width);
            filter.setRendererHeight((int) cGSize.height);
            Matrix matrix = getMatrix(this.maximumSize, new CGSize((float) textureInfo.width, (float) textureInfo.height));
            renderContext2.makeCurrent();
            Matrix matrix2 = new Matrix();
            matrix2.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glViewport(0, 0, (int) cGSize.width, (int) cGSize.height);
            filter.applyFilter(textureInfo, matrix, matrix2);
            filter.release();
            renderContext2.setPresentationTime(cMSampleBuffer.getTime().getTimeUs());
            renderContext2.swapBuffers();
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        AppMethodBeat.o(217761);
        return cGSize;
    }

    private Matrix getMatrix(CGSize cGSize, CGSize cGSize2) {
        AppMethodBeat.i(217762);
        if (cGSize == null || cGSize2 == null || this.apertureMode == null) {
            AppMethodBeat.o(217762);
            return null;
        }
        CGRect cGRect = new CGRect(new PointF(), cGSize2);
        CGRect cGRect2 = new CGRect(new PointF(), cGSize);
        switch (this.apertureMode) {
            case aspectFit:
                Matrix transformBySourceRectFit = CGMathFunctions.transformBySourceRectFit(cGRect, cGRect2);
                AppMethodBeat.o(217762);
                return transformBySourceRectFit;
            case aspectFill:
                Matrix transformBySourceRectFill = CGMathFunctions.transformBySourceRectFill(cGRect, cGRect2);
                AppMethodBeat.o(217762);
                return transformBySourceRectFill;
            case scaleToFit:
                Matrix transformByScaleFitRect = CGMathFunctions.transformByScaleFitRect(cGRect, cGRect2);
                AppMethodBeat.o(217762);
                return transformByScaleFitRect;
            default:
                AppMethodBeat.o(217762);
                return null;
        }
    }

    private Bitmap readBitmap(CGSize cGSize) {
        AppMethodBeat.i(217763);
        if (this.outputBitmapFactory == null) {
            this.outputBitmapFactory = new DefaultBitmapFactory();
        }
        Bitmap outputBitmap = this.outputBitmapFactory.getOutputBitmap((int) cGSize.width, (int) cGSize.height);
        if (outputBitmap.getConfig() == Bitmap.Config.ARGB_8888 || outputBitmap.getConfig() == Bitmap.Config.ARGB_4444) {
            int width = outputBitmap.getWidth() * outputBitmap.getHeight() * 4;
            if (this.outBitmapReaderBuffer == null || this.outBitmapReaderBuffer.capacity() < width) {
                this.outBitmapReaderBuffer = ByteBuffer.allocateDirect(width);
                this.outBitmapReaderBuffer.order(ByteOrder.LITTLE_ENDIAN);
                this.outBitmapReaderBuffer.rewind();
                this.outBitmapReaderBuffer.clear();
            }
            GLES20.glReadPixels(0, 0, outputBitmap.getWidth(), outputBitmap.getHeight(), NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.outBitmapReaderBuffer);
            this.outBitmapReaderBuffer.rewind();
            outputBitmap.copyPixelsFromBuffer(this.outBitmapReaderBuffer);
            this.outBitmapReaderBuffer.clear();
            AppMethodBeat.o(217763);
            return outputBitmap;
        }
        Logger.e(this.TAG, "readBitmap: bitmap 格式错误：暂时只支持ARGB_8888、ARGB_4444格式");
        AppMethodBeat.o(217763);
        return outputBitmap;
    }

    private Bitmap bitmapFromFBO(RenderContext renderContext2, CMSampleBuffer cMSampleBuffer) {
        AppMethodBeat.i(217764);
        TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
        if (textureInfo == null) {
            AppMethodBeat.o(217764);
            return null;
        }
        Bitmap readBitmapFromTexture = readBitmapFromTexture(renderContext2, textureInfo);
        Matrix matrix = getMatrix(this.maximumSize, new CGSize((float) textureInfo.width, (float) textureInfo.height));
        Matrix matrix2 = new Matrix();
        matrix2.postScale(1.0f, -1.0f);
        matrix2.postTranslate(0.0f, (float) readBitmapFromTexture.getHeight());
        if (matrix != null) {
            matrix.postConcat(matrix2);
        } else {
            matrix = matrix2;
        }
        CGSize cGSize = this.maximumSize != null ? this.maximumSize : new CGSize((float) textureInfo.width, (float) textureInfo.height);
        Bitmap createBitmap = Bitmap.createBitmap(readBitmapFromTexture, 0, 0, (int) cGSize.width, (int) cGSize.height, matrix, true);
        AppMethodBeat.o(217764);
        return createBitmap;
    }

    private Bitmap readBitmapFromTexture(RenderContext renderContext2, TextureInfo textureInfo) {
        AppMethodBeat.i(217765);
        renderContext2.makeCurrent();
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, textureInfo.textureID, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(textureInfo.width * textureInfo.height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        GLES20.glReadPixels(0, 0, textureInfo.width, textureInfo.height, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        Bitmap createBitmap = Bitmap.createBitmap(textureInfo.width, textureInfo.height, Bitmap.Config.ARGB_8888);
        allocateDirect.rewind();
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        AppMethodBeat.o(217765);
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    public class ImageGeneratorThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_CREATE_RENDERCONTEXT = 3;
        private static final int MSG_GENERATOR_COVER = 1;
        private static final int MSG_RELEASE = 2;
        private ImageGeneratorListener generatorListener;
        private Handler handler;
        private List<CMTime> requestedTimes;

        static /* synthetic */ void access$000(ImageGeneratorThread imageGeneratorThread) {
            AppMethodBeat.i(217748);
            imageGeneratorThread.initHandler();
            AppMethodBeat.o(217748);
        }

        static /* synthetic */ void access$100(ImageGeneratorThread imageGeneratorThread) {
            AppMethodBeat.i(217749);
            imageGeneratorThread.generatorCover();
            AppMethodBeat.o(217749);
        }

        static /* synthetic */ void access$200(ImageGeneratorThread imageGeneratorThread) {
            AppMethodBeat.i(217750);
            imageGeneratorThread.release();
            AppMethodBeat.o(217750);
        }

        public ImageGeneratorThread(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public void onLooperPrepared() {
            AppMethodBeat.i(217743);
            super.onLooperPrepared();
            AppMethodBeat.o(217743);
        }

        private void initHandler() {
            AppMethodBeat.i(217744);
            this.handler = new Handler(getLooper(), this);
            AppMethodBeat.o(217744);
        }

        public void setGeneratorListener(ImageGeneratorListener imageGeneratorListener) {
            this.generatorListener = imageGeneratorListener;
        }

        public void setRequestedTimes(List<CMTime> list) {
            this.requestedTimes = list;
        }

        public boolean handleMessage(Message message) {
            Bitmap bitmap;
            AppMethodBeat.i(217745);
            switch (message.what) {
                case 1:
                    try {
                        bitmap = AssetImageGenerator.this.copyCGImageAtTimeAndActualTime((CMTime) message.obj, null);
                    } catch (Exception e2) {
                        Logger.e(AssetImageGenerator.this.TAG, "copyCGImage", e2);
                        bitmap = null;
                    }
                    if (this.generatorListener != null) {
                        this.generatorListener.onCompletion((CMTime) message.obj, bitmap, null, bitmap != null ? AssetImageGeneratorResult.AssetImageGeneratorSucceeded : AssetImageGeneratorResult.AssetImageGeneratorFailed);
                        break;
                    }
                    break;
                case 2:
                    this.handler.removeCallbacksAndMessages(null);
                    AssetImageGenerator.access$500(AssetImageGenerator.this);
                    quit();
                    break;
            }
            AppMethodBeat.o(217745);
            return false;
        }

        private void generatorCover() {
            AppMethodBeat.i(217746);
            for (CMTime cMTime : this.requestedTimes) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = cMTime;
                this.handler.sendMessage(obtain);
            }
            AppMethodBeat.o(217746);
        }

        private void release() {
            AppMethodBeat.i(217747);
            Message obtain = Message.obtain();
            obtain.what = 2;
            this.handler.sendMessage(obtain);
            AppMethodBeat.o(217747);
        }
    }

    /* access modifiers changed from: package-private */
    public static class DefaultBitmapFactory implements OutputBitmapFactory {
        private DefaultBitmapFactory() {
        }

        @Override // com.tencent.tav.core.AssetImageGenerator.OutputBitmapFactory
        public Bitmap getOutputBitmap(int i2, int i3) {
            AppMethodBeat.i(217742);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            AppMethodBeat.o(217742);
            return createBitmap;
        }
    }
}
