package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

/* access modifiers changed from: package-private */
public class MediaCodecWrapper {
    private static final int MAX_RETRY_COUNT = 10;
    private static final long WAIT_TRANSIENT_MS = 20;
    private final String TAG = ("MediaCodecWrapper@" + Integer.toHexString(hashCode()));
    private MediaCodec mediaCodec;
    private final VideoDecoder videoDecoder;

    MediaCodecWrapper(VideoDecoder videoDecoder2) {
        AppMethodBeat.i(218241);
        this.videoDecoder = videoDecoder2;
        AppMethodBeat.o(218241);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean decoderConfigure(MediaFormat mediaFormat, Surface surface) {
        boolean z;
        AppMethodBeat.i(218242);
        long currentTimeMillis = System.currentTimeMillis();
        this.mediaCodec = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
        if (Build.VERSION.SDK_INT < 21) {
            this.mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            Logger.d(this.TAG, "decoderConfigure cost:" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(218242);
            z = true;
        } else {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                try {
                    Logger.d(this.TAG, "createdDecoder---time---".concat(String.valueOf(i3)));
                    if (i3 > 10) {
                        AppMethodBeat.o(218242);
                        z = false;
                    } else {
                        this.mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
                        Logger.d(this.TAG, "decoderConfigure cost:" + (System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(218242);
                        z = true;
                    }
                } catch (Exception e2) {
                    Logger.e(this.TAG, "decoderConfigure", e2);
                    if (!(e2 instanceof MediaCodec.CodecException) || (!((MediaCodec.CodecException) e2).isTransient() && !((MediaCodec.CodecException) e2).isRecoverable())) {
                        this.mediaCodec.release();
                        AppMethodBeat.o(218242);
                        throw e2;
                    }
                    i2 = i3;
                }
            }
            this.mediaCodec.release();
            AppMethodBeat.o(218242);
            throw e2;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public synchronized void reset(Surface surface, MediaFormat mediaFormat) {
        AppMethodBeat.i(218243);
        if (this.videoDecoder.isReleased) {
            AppMethodBeat.o(218243);
        } else {
            Logger.d(this.TAG, "reset");
            try {
                resetMediaCodec(mediaFormat);
                decoderConfigure(mediaFormat, surface);
                startDecoder(surface, mediaFormat);
                AppMethodBeat.o(218243);
            } catch (Exception e2) {
                Logger.e(this.TAG, "reset", e2);
                AppMethodBeat.o(218243);
            }
        }
    }

    private void resetMediaCodec(MediaFormat mediaFormat) {
        AppMethodBeat.i(218244);
        if (isLollipop()) {
            this.mediaCodec.reset();
            AppMethodBeat.o(218244);
            return;
        }
        try {
            this.mediaCodec.stop();
        } catch (Exception e2) {
        }
        this.mediaCodec.release();
        this.mediaCodec = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
        AppMethodBeat.o(218244);
    }

    /* access modifiers changed from: package-private */
    public synchronized void startDecoder(Surface surface, MediaFormat mediaFormat) {
        AppMethodBeat.i(218245);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.mediaCodec.start();
            Logger.i(this.TAG, "startDecoder cost:" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(218245);
        } catch (Exception e2) {
            Logger.e(this.TAG, "startDecoder: start", e2);
            if (isLollipop() && (e2 instanceof MediaCodec.CodecException)) {
                tryLogMediaCodecError((MediaCodec.CodecException) e2);
                if (((MediaCodec.CodecException) e2).isTransient()) {
                    waitTime(WAIT_TRANSIENT_MS);
                    startDecoder(surface, mediaFormat);
                    AppMethodBeat.o(218245);
                } else if (((MediaCodec.CodecException) e2).isRecoverable()) {
                    reset(surface, mediaFormat);
                    AppMethodBeat.o(218245);
                }
            }
            this.videoDecoder.release(false);
            AppMethodBeat.o(218245);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        AppMethodBeat.i(218246);
        try {
            dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 1000);
            AppMethodBeat.o(218246);
        } catch (Exception e2) {
            Logger.e(this.TAG, "dequeueOutputBuffer", e2);
            if (isLollipop() && (e2 instanceof MediaCodec.CodecException)) {
                tryLogMediaCodecError((MediaCodec.CodecException) e2);
                if (((MediaCodec.CodecException) e2).isTransient()) {
                    waitTime(WAIT_TRANSIENT_MS);
                    dequeueOutputBuffer = dequeueOutputBuffer(bufferInfo);
                    AppMethodBeat.o(218246);
                }
            }
            AppMethodBeat.o(218246);
            throw e2;
        }
        return dequeueOutputBuffer;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void queueInputBuffer(int r11, int r12, int r13, long r14, int r16) {
        /*
            r10 = this;
            monitor-enter(r10)
            r2 = 218247(0x35487, float:3.05829E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)     // Catch:{ all -> 0x004e }
            android.media.MediaCodec r2 = r10.mediaCodec     // Catch:{ Exception -> 0x001a, Error -> 0x0051 }
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r8 = r16
            r2.queueInputBuffer(r3, r4, r5, r6, r8)     // Catch:{ Exception -> 0x001a, Error -> 0x0051 }
            r2 = 218247(0x35487, float:3.05829E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            monitor-exit(r10)
            return
        L_0x001a:
            r2 = move-exception
            r3 = r2
        L_0x001c:
            java.lang.String r2 = r10.TAG
            java.lang.String r4 = "queueInputBuffer"
            com.tencent.tav.decoder.logger.Logger.e(r2, r4, r3)
            boolean r2 = r10.isLollipop()
            if (r2 == 0) goto L_0x0047
            boolean r2 = r3 instanceof android.media.MediaCodec.CodecException
            if (r2 == 0) goto L_0x0047
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            r10.tryLogMediaCodecError(r2)
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            boolean r2 = r2.isTransient()
            if (r2 == 0) goto L_0x0047
            r4 = 20
            r10.waitTime(r4)
            r10.queueInputBuffer(r11, r12, r13, r14, r16)
        L_0x0047:
            r2 = 218247(0x35487, float:3.05829E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r3
        L_0x004e:
            r2 = move-exception
            monitor-exit(r10)
            throw r2
        L_0x0051:
            r2 = move-exception
            r3 = r2
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.MediaCodecWrapper.queueInputBuffer(int, int, int, long, int):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int dequeueInputBuffer() {
        /*
            r6 = this;
            monitor-enter(r6)
            r2 = 218248(0x35488, float:3.0583E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)     // Catch:{ all -> 0x004c }
            android.media.MediaCodec r2 = r6.mediaCodec     // Catch:{ Exception -> 0x0017, Error -> 0x0056 }
            r4 = 1000(0x3e8, double:4.94E-321)
            int r2 = r2.dequeueInputBuffer(r4)     // Catch:{ Exception -> 0x0017, Error -> 0x0056 }
            r3 = 218248(0x35488, float:3.0583E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0015:
            monitor-exit(r6)
            return r2
        L_0x0017:
            r2 = move-exception
            r3 = r2
        L_0x0019:
            java.lang.String r2 = r6.TAG
            java.lang.String r4 = "dequeueInputBuffer"
            com.tencent.tav.decoder.logger.Logger.e(r2, r4, r3)
            boolean r2 = r6.isLollipop()
            if (r2 == 0) goto L_0x004f
            boolean r2 = r3 instanceof android.media.MediaCodec.CodecException
            if (r2 == 0) goto L_0x004f
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            r6.tryLogMediaCodecError(r2)
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            boolean r2 = r2.isTransient()
            if (r2 == 0) goto L_0x004f
            r2 = 20
            r6.waitTime(r2)
            int r2 = r6.dequeueInputBuffer()
            r3 = 218248(0x35488, float:3.0583E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0015
        L_0x004c:
            r2 = move-exception
            monitor-exit(r6)
            throw r2
        L_0x004f:
            r2 = 218248(0x35488, float:3.0583E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r3
        L_0x0056:
            r2 = move-exception
            r3 = r2
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.MediaCodecWrapper.dequeueInputBuffer():int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.nio.ByteBuffer getInputBuffer(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r2 = 218249(0x35489, float:3.05832E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)     // Catch:{ all -> 0x004a }
            android.media.MediaCodec r2 = r5.mediaCodec     // Catch:{ Exception -> 0x0015, Error -> 0x0054 }
            java.nio.ByteBuffer r2 = com.tencent.tav.decoder.DecoderUtils.getInputBuffer(r2, r6)     // Catch:{ Exception -> 0x0015, Error -> 0x0054 }
            r3 = 218249(0x35489, float:3.05832E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0013:
            monitor-exit(r5)
            return r2
        L_0x0015:
            r2 = move-exception
            r3 = r2
        L_0x0017:
            java.lang.String r2 = r5.TAG
            java.lang.String r4 = "getInputBuffer"
            com.tencent.tav.decoder.logger.Logger.e(r2, r4, r3)
            boolean r2 = r5.isLollipop()
            if (r2 == 0) goto L_0x004d
            boolean r2 = r3 instanceof android.media.MediaCodec.CodecException
            if (r2 == 0) goto L_0x004d
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            r5.tryLogMediaCodecError(r2)
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            boolean r2 = r2.isTransient()
            if (r2 == 0) goto L_0x004d
            r2 = 20
            r5.waitTime(r2)
            java.nio.ByteBuffer r2 = r5.getInputBuffer(r6)
            r3 = 218249(0x35489, float:3.05832E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0013
        L_0x004a:
            r2 = move-exception
            monitor-exit(r5)
            throw r2
        L_0x004d:
            r2 = 218249(0x35489, float:3.05832E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r3
        L_0x0054:
            r2 = move-exception
            r3 = r2
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.MediaCodecWrapper.getInputBuffer(int):java.nio.ByteBuffer");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.nio.ByteBuffer getOnputBuffer(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r2 = 218250(0x3548a, float:3.05833E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)     // Catch:{ all -> 0x004a }
            android.media.MediaCodec r2 = r5.mediaCodec     // Catch:{ Exception -> 0x0015, Error -> 0x0054 }
            java.nio.ByteBuffer r2 = com.tencent.tav.decoder.DecoderUtils.getOutputBuffer(r2, r6)     // Catch:{ Exception -> 0x0015, Error -> 0x0054 }
            r3 = 218250(0x3548a, float:3.05833E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0013:
            monitor-exit(r5)
            return r2
        L_0x0015:
            r2 = move-exception
            r3 = r2
        L_0x0017:
            java.lang.String r2 = r5.TAG
            java.lang.String r4 = "getOutputBuffer"
            com.tencent.tav.decoder.logger.Logger.e(r2, r4, r3)
            boolean r2 = r5.isLollipop()
            if (r2 == 0) goto L_0x004d
            boolean r2 = r3 instanceof android.media.MediaCodec.CodecException
            if (r2 == 0) goto L_0x004d
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            r5.tryLogMediaCodecError(r2)
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            boolean r2 = r2.isTransient()
            if (r2 == 0) goto L_0x004d
            r2 = 20
            r5.waitTime(r2)
            java.nio.ByteBuffer r2 = r5.getOnputBuffer(r6)
            r3 = 218250(0x3548a, float:3.05833E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0013
        L_0x004a:
            r2 = move-exception
            monitor-exit(r5)
            throw r2
        L_0x004d:
            r2 = 218250(0x3548a, float:3.05833E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r3
        L_0x0054:
            r2 = move-exception
            r3 = r2
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.MediaCodecWrapper.getOnputBuffer(int):java.nio.ByteBuffer");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void releaseOutputBuffer(int r7, boolean r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            r2 = 218251(0x3548b, float:3.05835E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)     // Catch:{ all -> 0x004f }
            android.media.MediaCodec r2 = r6.mediaCodec     // Catch:{ Exception -> 0x001b, Error -> 0x0052 }
            r2.releaseOutputBuffer(r7, r8)     // Catch:{ Exception -> 0x001b, Error -> 0x0052 }
            if (r8 == 0) goto L_0x0013
            com.tencent.tav.decoder.VideoDecoder r2 = r6.videoDecoder     // Catch:{ Exception -> 0x001b, Error -> 0x0052 }
            r3 = 1
            r2.lastFrameValid = r3     // Catch:{ Exception -> 0x001b, Error -> 0x0052 }
        L_0x0013:
            r2 = 218251(0x3548b, float:3.05835E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            monitor-exit(r6)
            return
        L_0x001b:
            r2 = move-exception
            r3 = r2
        L_0x001d:
            java.lang.String r2 = r6.TAG
            java.lang.String r4 = "releaseOutputBuffer"
            com.tencent.tav.decoder.logger.Logger.e(r2, r4, r3)
            boolean r2 = r6.isLollipop()
            if (r2 == 0) goto L_0x0048
            boolean r2 = r3 instanceof android.media.MediaCodec.CodecException
            if (r2 == 0) goto L_0x0048
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            r6.tryLogMediaCodecError(r2)
            r0 = r3
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            r2 = r0
            boolean r2 = r2.isTransient()
            if (r2 == 0) goto L_0x0048
            r4 = 20
            r6.waitTime(r4)
            r6.releaseOutputBuffer(r7, r8)
        L_0x0048:
            r2 = 218251(0x3548b, float:3.05835E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r3
        L_0x004f:
            r2 = move-exception
            monitor-exit(r6)
            throw r2
        L_0x0052:
            r2 = move-exception
            r3 = r2
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.MediaCodecWrapper.releaseOutputBuffer(int, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void waitTime(long j2) {
        AppMethodBeat.i(218252);
        try {
            this.videoDecoder.wait(j2);
            AppMethodBeat.o(218252);
        } catch (InterruptedException e2) {
            AppMethodBeat.o(218252);
        }
    }

    private boolean isLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private void tryLogMediaCodecError(MediaCodec.CodecException codecException) {
        AppMethodBeat.i(218253);
        if (Build.VERSION.SDK_INT >= 23) {
            Logger.e(this.TAG, "CodecException - isTransient = " + codecException.isTransient() + " , isRecoverable = " + codecException.isRecoverable() + " , errorCode = " + codecException.getErrorCode());
        }
        AppMethodBeat.o(218253);
    }

    /* access modifiers changed from: package-private */
    public void flushDecoder() {
        AppMethodBeat.i(218254);
        this.mediaCodec.flush();
        AppMethodBeat.o(218254);
    }

    /* access modifiers changed from: package-private */
    public void release() {
        AppMethodBeat.i(218255);
        if (this.mediaCodec != null) {
            new Thread() {
                /* class com.tencent.tav.decoder.MediaCodecWrapper.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(218240);
                    try {
                        MediaCodecWrapper.this.videoDecoder.releaseOutputBuffer();
                        MediaCodecWrapper.this.mediaCodec.stop();
                    } catch (Exception e2) {
                        Logger.e(MediaCodecWrapper.this.TAG, "mediaCodec.stop", e2);
                    }
                    try {
                        MediaCodecWrapper.this.mediaCodec.release();
                        MediaCodecWrapper.this.mediaCodec = null;
                    } catch (Exception e3) {
                        Logger.e(MediaCodecWrapper.this.TAG, "mediaCodec.release", e3);
                        MediaCodecWrapper.this.mediaCodec = null;
                    } catch (Throwable th) {
                        MediaCodecWrapper.this.mediaCodec = null;
                        AppMethodBeat.o(218240);
                        throw th;
                    }
                    MediaCodecWrapper.this.mediaCodec = null;
                    AppMethodBeat.o(218240);
                }
            }.start();
        }
        AppMethodBeat.o(218255);
    }
}
