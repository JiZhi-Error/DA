package org.libpag;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

public class GPUDecoder implements SurfaceTexture.OnFrameAvailableListener {
    private static final int END_OF_STREAM = -3;
    private static final int ERROR = -2;
    private static int HandlerThreadCount = 0;
    private static final int SUCCESS = 0;
    private static final int TIMEOUT_US = 1000;
    private static final int TRY_AGAIN_LATER = -1;
    private static final Object handlerLock = new Object();
    private static HandlerThread handlerThread;
    private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    private MediaCodec decoder;
    private boolean frameAvailable = false;
    private final Object frameSyncObject = new Object();
    private int lastOutputBufferIndex = -1;
    private MediaFormat outputFormat = null;
    private Surface outputSurface;
    private boolean released = false;
    private OutputFrame successFrame = new OutputFrame();
    private SurfaceTexture surfaceTexture;
    private int targetHeight = 0;
    private int targetWidth = 0;

    public GPUDecoder() {
        AppMethodBeat.i(236829);
        AppMethodBeat.o(236829);
    }

    static {
        AppMethodBeat.i(236851);
        AppMethodBeat.o(236851);
    }

    static class OutputFrame {
        public long[] data;
        public int[] lineSize;

        private OutputFrame() {
            AppMethodBeat.i(236828);
            this.data = new long[3];
            this.lineSize = new int[3];
            AppMethodBeat.o(236828);
        }
    }

    private static synchronized void StartHandlerThread() {
        synchronized (GPUDecoder.class) {
            AppMethodBeat.i(236830);
            HandlerThreadCount++;
            if (handlerThread == null) {
                HandlerThread handlerThread2 = new HandlerThread("libpag_GPUDecoder");
                handlerThread = handlerThread2;
                handlerThread2.start();
            }
            AppMethodBeat.o(236830);
        }
    }

    private static GPUDecoder Create(int i2) {
        AppMethodBeat.i(236831);
        if (forceSoftwareDecoder()) {
            AppMethodBeat.o(236831);
            return null;
        }
        GPUDecoder gPUDecoder = new GPUDecoder();
        synchronized (handlerLock) {
            try {
                StartHandlerThread();
                gPUDecoder.surfaceTexture = new SurfaceTexture(i2);
                if (Build.VERSION.SDK_INT >= 21) {
                    gPUDecoder.surfaceTexture.setOnFrameAvailableListener(gPUDecoder, new Handler(handlerThread.getLooper()));
                } else {
                    gPUDecoder.surfaceTexture.setOnFrameAvailableListener(gPUDecoder);
                    gPUDecoder.reflectLooper();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(236831);
                throw th;
            }
        }
        gPUDecoder.outputSurface = new Surface(gPUDecoder.surfaceTexture);
        AppMethodBeat.o(236831);
        return gPUDecoder;
    }

    private static boolean forceSoftwareDecoder() {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        return false;
    }

    private void reflectLooper() {
        Class<?> cls;
        AppMethodBeat.i(236832);
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
            AppMethodBeat.o(236832);
            return;
        }
        try {
            Object newInstance = cls.getConstructor(SurfaceTexture.class, Looper.class).newInstance(this.surfaceTexture, handlerThread.getLooper());
            Field declaredField = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
            declaredField.setAccessible(true);
            declaredField.set(this.surfaceTexture, newInstance);
            AppMethodBeat.o(236832);
        } catch (Exception e2) {
            AppMethodBeat.o(236832);
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
        AppMethodBeat.i(236833);
        synchronized (this.frameSyncObject) {
            try {
                if (this.frameAvailable) {
                    new RuntimeException("frameAvailable already set, frame could be dropped");
                    return;
                }
                this.frameAvailable = true;
                this.frameSyncObject.notifyAll();
                AppMethodBeat.o(236833);
            } finally {
                AppMethodBeat.o(236833);
            }
        }
    }

    private boolean awaitNewImage() {
        AppMethodBeat.i(236834);
        int i2 = 10;
        synchronized (this.frameSyncObject) {
            while (!this.frameAvailable && i2 > 0) {
                try {
                    i2--;
                    try {
                        this.frameSyncObject.wait(50);
                    } catch (InterruptedException e2) {
                    }
                } finally {
                    AppMethodBeat.o(236834);
                }
            }
            this.frameAvailable = false;
            if (i2 == 0) {
                return false;
            }
            try {
                this.surfaceTexture.updateTexImage();
                AppMethodBeat.o(236834);
                return true;
            } catch (Exception e3) {
                AppMethodBeat.o(236834);
                return false;
            }
        }
    }

    private float videoWidth() {
        AppMethodBeat.i(236835);
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        float abs = Math.abs(fArr[0]);
        if (abs > 0.0f) {
            float f2 = ((float) this.targetWidth) / ((fArr[12] * 2.0f) + abs);
            AppMethodBeat.o(236835);
            return f2;
        }
        float f3 = (float) this.targetWidth;
        AppMethodBeat.o(236835);
        return f3;
    }

    private float videoHeight() {
        AppMethodBeat.i(236836);
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        float abs = Math.abs(fArr[5]);
        if (abs > 0.0f) {
            float f2 = ((float) this.targetHeight) / (((fArr[13] - abs) * 2.0f) + abs);
            AppMethodBeat.o(236836);
            return f2;
        }
        float f3 = (float) this.targetHeight;
        AppMethodBeat.o(236836);
        return f3;
    }

    private boolean onConfigure(MediaFormat mediaFormat) {
        AppMethodBeat.i(236837);
        if (this.outputSurface == null) {
            AppMethodBeat.o(236837);
            return false;
        }
        this.targetWidth = mediaFormat.getInteger("width");
        this.targetHeight = mediaFormat.getInteger("height");
        this.outputFormat = mediaFormat;
        try {
            this.decoder = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
            this.decoder.configure(mediaFormat, this.outputSurface, (MediaCrypto) null, 0);
            this.decoder.start();
            AppMethodBeat.o(236837);
            return true;
        } catch (Exception e2) {
            if (this.decoder != null) {
                this.decoder.release();
                this.decoder = null;
            }
            AppMethodBeat.o(236837);
            return false;
        }
    }

    private int dequeueOutputBuffer() {
        AppMethodBeat.i(236838);
        try {
            int dequeueOutputBuffer = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000);
            AppMethodBeat.o(236838);
            return dequeueOutputBuffer;
        } catch (Exception e2) {
            AppMethodBeat.o(236838);
            return -1;
        }
    }

    private int dequeueInputBuffer() {
        AppMethodBeat.i(236839);
        try {
            int dequeueInputBuffer = this.decoder.dequeueInputBuffer(1000);
            AppMethodBeat.o(236839);
            return dequeueInputBuffer;
        } catch (Error | Exception e2) {
            AppMethodBeat.o(236839);
            return -1;
        }
    }

    private ByteBuffer getInputBuffer(int i2) {
        AppMethodBeat.i(236840);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                ByteBuffer inputBuffer = this.decoder.getInputBuffer(i2);
                AppMethodBeat.o(236840);
                return inputBuffer;
            }
            ByteBuffer byteBuffer = this.decoder.getInputBuffers()[i2];
            AppMethodBeat.o(236840);
            return byteBuffer;
        } catch (Error | Exception e2) {
            AppMethodBeat.o(236840);
            return null;
        }
    }

    private int queueInputBuffer(int i2, int i3, int i4, long j2, int i5) {
        AppMethodBeat.i(236841);
        try {
            this.decoder.queueInputBuffer(i2, i3, i4, j2, i5);
            AppMethodBeat.o(236841);
            return 0;
        } catch (Error | Exception e2) {
            AppMethodBeat.o(236841);
            return -2;
        }
    }

    private void releaseOutputBuffer() {
        AppMethodBeat.i(236842);
        if (this.lastOutputBufferIndex != -1) {
            releaseOutputBuffer(this.lastOutputBufferIndex, false);
            this.lastOutputBufferIndex = -1;
        }
        AppMethodBeat.o(236842);
    }

    private int releaseOutputBuffer(int i2, boolean z) {
        AppMethodBeat.i(236843);
        try {
            this.decoder.releaseOutputBuffer(i2, z);
            AppMethodBeat.o(236843);
            return 0;
        } catch (Error | Exception e2) {
            AppMethodBeat.o(236843);
            return -2;
        }
    }

    private int onSendBytes(ByteBuffer byteBuffer, long j2) {
        AppMethodBeat.i(236844);
        int dequeueInputBuffer = dequeueInputBuffer();
        if (dequeueInputBuffer >= 0) {
            ByteBuffer inputBuffer = getInputBuffer(dequeueInputBuffer);
            if (inputBuffer == null) {
                AppMethodBeat.o(236844);
                return -2;
            }
            inputBuffer.clear();
            byteBuffer.position(0);
            inputBuffer.put(byteBuffer);
            int queueInputBuffer = queueInputBuffer(dequeueInputBuffer, 0, byteBuffer.limit(), j2, 0);
            AppMethodBeat.o(236844);
            return queueInputBuffer;
        }
        AppMethodBeat.o(236844);
        return -1;
    }

    private int onEndOfStream() {
        AppMethodBeat.i(236845);
        int dequeueInputBuffer = dequeueInputBuffer();
        if (dequeueInputBuffer >= 0) {
            int queueInputBuffer = queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
            AppMethodBeat.o(236845);
            return queueInputBuffer;
        }
        AppMethodBeat.o(236845);
        return -1;
    }

    private int onDecodeFrame() {
        AppMethodBeat.i(236846);
        releaseOutputBuffer();
        try {
            int dequeueOutputBuffer = dequeueOutputBuffer();
            if ((this.bufferInfo.flags & 4) != 0) {
                if (dequeueOutputBuffer >= 0) {
                    this.lastOutputBufferIndex = dequeueOutputBuffer;
                }
                AppMethodBeat.o(236846);
                return -3;
            }
            if (dequeueOutputBuffer >= 0) {
                this.lastOutputBufferIndex = dequeueOutputBuffer;
            } else if (dequeueOutputBuffer == -2) {
                this.outputFormat = this.decoder.getOutputFormat();
            }
            if (this.lastOutputBufferIndex != -1) {
                AppMethodBeat.o(236846);
                return 0;
            }
            AppMethodBeat.o(236846);
            return -1;
        } catch (Exception e2) {
            AppMethodBeat.o(236846);
            return -2;
        }
    }

    private void onFlush() {
        AppMethodBeat.i(236847);
        try {
            this.decoder.flush();
            this.bufferInfo = new MediaCodec.BufferInfo();
            this.lastOutputBufferIndex = -1;
            AppMethodBeat.o(236847);
        } catch (Exception e2) {
            AppMethodBeat.o(236847);
        }
    }

    private long presentationTime() {
        return this.bufferInfo.presentationTimeUs;
    }

    private OutputFrame onRenderFrame() {
        AppMethodBeat.i(236848);
        if (this.lastOutputBufferIndex != -1) {
            int releaseOutputBuffer = releaseOutputBuffer(this.lastOutputBufferIndex, true);
            this.lastOutputBufferIndex = -1;
            if (releaseOutputBuffer == 0 && awaitNewImage()) {
                OutputFrame outputFrame = this.successFrame;
                AppMethodBeat.o(236848);
                return outputFrame;
            }
        }
        AppMethodBeat.o(236848);
        return null;
    }

    private void onRelease() {
        AppMethodBeat.i(236849);
        if (this.released) {
            AppMethodBeat.o(236849);
            return;
        }
        this.released = true;
        releaseOutputBuffer();
        synchronized (handlerLock) {
            try {
                int i2 = HandlerThreadCount - 1;
                HandlerThreadCount = i2;
                if (i2 == 0) {
                    handlerThread.quit();
                    handlerThread = null;
                }
            } finally {
                AppMethodBeat.o(236849);
            }
        }
        if (this.decoder != null) {
            try {
                this.decoder.stop();
            } catch (Exception e2) {
            }
            try {
                this.decoder.release();
            } catch (Exception e3) {
            }
            this.decoder = null;
        }
        if (this.outputSurface != null) {
            this.outputSurface.release();
            this.outputSurface = null;
        }
        if (this.surfaceTexture != null) {
            this.surfaceTexture.release();
            this.surfaceTexture = null;
        }
    }

    private boolean attachToGLContext(int i2) {
        AppMethodBeat.i(236850);
        if (this.surfaceTexture == null) {
            AppMethodBeat.o(236850);
            return false;
        }
        try {
            this.surfaceTexture.detachFromGLContext();
            this.surfaceTexture.attachToGLContext(i2);
            AppMethodBeat.o(236850);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(236850);
            return false;
        }
    }
}
