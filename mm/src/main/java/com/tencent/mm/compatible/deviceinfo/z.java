package com.tencent.mm.compatible.deviceinfo;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.view.Surface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class z {
    public volatile boolean dbi = false;
    public MediaCodec gJE;
    public MediaCodecProxyUtils.a gJF;
    public AtomicInteger gJG = new AtomicInteger();
    private AtomicInteger gJH = new AtomicInteger();
    private AtomicInteger gJI = new AtomicInteger();
    private AtomicInteger gJJ = new AtomicInteger();
    private AtomicInteger gJK = new AtomicInteger();
    private final int gJL = 10;
    private long gJM = 0;
    private long gJN = 5000;

    public static z DZ(String str) {
        AppMethodBeat.i(155768);
        Log.i("MicroMsg.MediaCodecProxy", "into createDecoderByType, type = [%s]", str);
        MediaCodecProxyUtils.a aVar = new MediaCodecProxyUtils.a();
        try {
            MediaCodecProxyUtils.b.oA(7);
            MediaCodecProxyUtils.b.oA(60);
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(str);
            MediaCodecProxyUtils.b.oA(61);
            aVar = MediaCodecProxyUtils.a(createDecoderByType.hashCode(), false, str);
            MediaCodecProxyUtils.a(str, aVar);
            MediaCodecProxyUtils.aoY();
            z zVar = new z(createDecoderByType, aVar);
            AppMethodBeat.o(155768);
            return zVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "createDecoderByType error ".concat(String.valueOf(str)), new Object[0]);
            a(0, e2, aVar);
            MediaCodecProxyUtils.a(false, str, aVar);
            AppMethodBeat.o(155768);
            throw e2;
        }
    }

    public static z Ea(String str) {
        AppMethodBeat.i(155769);
        z q = q(str, false);
        AppMethodBeat.o(155769);
        return q;
    }

    public static z q(String str, boolean z) {
        AppMethodBeat.i(155770);
        Log.i("MicroMsg.MediaCodecProxy", "into createEncoderByType, type = [%s]", str);
        MediaCodecProxyUtils.a aVar = new MediaCodecProxyUtils.a();
        try {
            MediaCodecProxyUtils.b.oA(7);
            MediaCodecProxyUtils.b.oA(63);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
            MediaCodecProxyUtils.b.oA(64);
            aVar = MediaCodecProxyUtils.a(createEncoderByType.hashCode(), true, str);
            MediaCodecProxyUtils.a(str, aVar);
            MediaCodecProxyUtils.aoY();
            z zVar = new z(createEncoderByType, aVar);
            AppMethodBeat.o(155770);
            return zVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "createByCodecName error ".concat(String.valueOf(str)), new Object[0]);
            if (!z) {
                a(1, e2, aVar);
                MediaCodecProxyUtils.a(true, str, aVar);
            }
            AppMethodBeat.o(155770);
            throw e2;
        }
    }

    public static z Eb(String str) {
        AppMethodBeat.i(155771);
        Log.i("MicroMsg.MediaCodecProxy", "into createByCodecName, name = [%s]", str);
        MediaCodecProxyUtils.a aVar = new MediaCodecProxyUtils.a();
        try {
            MediaCodecProxyUtils.b.oA(7);
            MediaCodecProxyUtils.b.oA(66);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            MediaCodecProxyUtils.b.oA(67);
            aVar = MediaCodecProxyUtils.v(createByCodecName.hashCode(), str);
            MediaCodecProxyUtils.b(str, aVar);
            MediaCodecProxyUtils.aoY();
            z zVar = new z(createByCodecName, aVar);
            AppMethodBeat.o(155771);
            return zVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "createByCodecName func error ".concat(String.valueOf(str)), new Object[0]);
            a(2, e2, aVar);
            MediaCodecProxyUtils.c(str, aVar);
            AppMethodBeat.o(155771);
            throw e2;
        }
    }

    private z(MediaCodec mediaCodec, MediaCodecProxyUtils.a aVar) {
        AppMethodBeat.i(155772);
        this.gJE = mediaCodec;
        this.gJF = aVar;
        this.dbi = true;
        AppMethodBeat.o(155772);
    }

    public final void release() {
        AppMethodBeat.i(155773);
        try {
            MediaCodecProxyUtils.b.oA(11);
            Log.i("MicroMsg.MediaCodecProxy", "into release function, thread:[%s], stack:[%s]", Integer.valueOf(Process.myTid()), Util.getStack().toString());
            if (!this.dbi) {
                Log.e("MicroMsg.MediaCodecProxy", "release error, multi release, stack:[%s]", Util.getStack().toString());
                a(10, (Exception) null, this.gJF);
            }
            MediaCodecProxyUtils.oz(this.gJE.hashCode());
            MediaCodecProxyUtils.aoY();
            MediaCodecProxyUtils.b.oA(69);
            this.gJE.release();
            MediaCodecProxyUtils.b.oA(70);
            aoX();
            this.dbi = false;
            AppMethodBeat.o(155773);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy release", new Object[0]);
            a(30, e2, this.gJF);
            AppMethodBeat.o(155773);
            throw e2;
        }
    }

    private void aoX() {
        AppMethodBeat.i(155774);
        int i2 = this.gJG.get() + this.gJJ.get() + this.gJK.get() + this.gJH.get() + this.gJI.get();
        if (i2 > 10) {
            Log.d("MicroMsg.MediaCodecProxy", "reportCount count:[%d]", Integer.valueOf(i2));
            StringBuilder sb = new StringBuilder();
            sb.append("countFlush:").append(this.gJG).append(";countDequeueInputBuffer:").append(this.gJJ).append(";countDequeueOutputBuffer:").append(this.gJK).append(";countQueueInputBuffer:").append(this.gJH).append(";countQueueSecureInputBuffer:").append(this.gJI).append(";");
            if (this.gJF != null) {
                String str = "";
                if (this.gJF.gJX != null) {
                    str = this.gJF.gJX.replace(",", ";");
                }
                sb.append(this.gJF.gJV).append(";").append(this.gJF.mimeType).append(";").append(this.gJF.gJW).append(";").append(MMApplicationContext.getProcessName()).append(";").append(str).append(";stack:").append(this.gJF.stack);
            }
            MediaCodecProxyUtils.b.oA(16);
            MediaCodecProxyUtils.b.w(16, sb.toString());
            this.gJG.set(0);
            this.gJJ.set(0);
            this.gJK.set(0);
            this.gJH.set(0);
            this.gJI.set(0);
        }
        AppMethodBeat.o(155774);
    }

    public final void a(MediaFormat mediaFormat, Surface surface, int i2) {
        AppMethodBeat.i(155775);
        try {
            Log.i("MicroMsg.MediaCodecProxy", "configure 1 function, thread:[%s], threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
            Log.i("MicroMsg.MediaCodecProxy", "configure 1 format = " + (mediaFormat != null ? mediaFormat.toString() : BuildConfig.COMMAND) + " surface = " + (surface != null ? surface.toString() : BuildConfig.COMMAND) + " crypto = null flags = " + i2);
            if (!this.dbi) {
                Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy configure not alive");
            }
            if (mediaFormat != null) {
                this.gJF.gJX = mediaFormat.toString();
            }
            MediaCodecProxyUtils.b.oA(75);
            this.gJE.configure(mediaFormat, surface, (MediaCrypto) null, i2);
            MediaCodecProxyUtils.b.oA(76);
            AppMethodBeat.o(155775);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy configure 1", new Object[0]);
            a(32, e2, this.gJF);
            AppMethodBeat.o(155775);
            throw e2;
        }
    }

    public final Surface createInputSurface() {
        AppMethodBeat.i(155776);
        try {
            MediaCodecProxyUtils.b.oA(87);
            Surface createInputSurface = this.gJE.createInputSurface();
            MediaCodecProxyUtils.b.oA(88);
            AppMethodBeat.o(155776);
            return createInputSurface;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy createInputSurface", new Object[0]);
            a(36, e2, this.gJF);
            AppMethodBeat.o(155776);
            throw e2;
        }
    }

    public final void start() {
        AppMethodBeat.i(155777);
        try {
            Log.i("MicroMsg.MediaCodecProxy", "start function, thread:[%s]", Integer.valueOf(Process.myTid()));
            if (!this.dbi) {
                Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy start not alive");
            }
            MediaCodecProxyUtils.b.oA(90);
            this.gJE.start();
            MediaCodecProxyUtils.b.oA(91);
            AppMethodBeat.o(155777);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy start", new Object[0]);
            a(37, e2, this.gJF);
            AppMethodBeat.o(155777);
            throw e2;
        }
    }

    public final void stop() {
        AppMethodBeat.i(155778);
        try {
            Log.i("MicroMsg.MediaCodecProxy", "stop function, thread:[%s]", Integer.valueOf(Process.myTid()));
            if (!this.dbi) {
                Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy stop not alive");
            }
            MediaCodecProxyUtils.b.oA(93);
            this.gJE.stop();
            MediaCodecProxyUtils.b.oA(94);
            AppMethodBeat.o(155778);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy stop", new Object[0]);
            a(38, e2, this.gJF);
            AppMethodBeat.o(155778);
            throw e2;
        }
    }

    public final void a(int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(155779);
        try {
            if (!this.dbi) {
                Log.e("MicroMsg.MediaCodecProxy", "queueInputBuffer function, threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
                Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy queueInputBuffer not alive");
            }
            this.gJE.queueInputBuffer(i2, 0, i3, j2, i4);
            AppMethodBeat.o(155779);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy queueInputBuffer, thread:[%s]", Integer.valueOf(Process.myTid()));
            MediaCodecProxyUtils.b.oA(40);
            this.gJH.getAndIncrement();
            if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) && System.currentTimeMillis() - this.gJM > this.gJN) {
                this.gJM = System.currentTimeMillis();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.compatible.deviceinfo.z.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(201269);
                        Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy queueInputBuffer, thread:[%s]", Integer.valueOf(Process.myTid())), 1).show();
                        AppMethodBeat.o(201269);
                    }
                });
            }
            AppMethodBeat.o(155779);
            throw e2;
        }
    }

    public final int dequeueInputBuffer(long j2) {
        AppMethodBeat.i(155780);
        try {
            if (!this.dbi) {
                Log.e("MicroMsg.MediaCodecProxy", "dequeueInputBuffer function, threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
                Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueInputBuffer not alive");
            }
            int dequeueInputBuffer = this.gJE.dequeueInputBuffer(j2);
            AppMethodBeat.o(155780);
            return dequeueInputBuffer;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy dequeueInputBuffer, thread:[%s]", Integer.valueOf(Process.myTid()));
            MediaCodecProxyUtils.b.oA(42);
            this.gJJ.getAndIncrement();
            if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) && System.currentTimeMillis() - this.gJM > this.gJN) {
                this.gJM = System.currentTimeMillis();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.compatible.deviceinfo.z.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(201270);
                        Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy dequeueInputBuffer, thread:[%s]", Integer.valueOf(Process.myTid())), 1).show();
                        AppMethodBeat.o(201270);
                    }
                });
            }
            AppMethodBeat.o(155780);
            throw e2;
        }
    }

    public final int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j2) {
        AppMethodBeat.i(155781);
        try {
            if (!this.dbi) {
                Log.e("MicroMsg.MediaCodecProxy", "dequeueOutputBuffer function, threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
                Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueOutputBuffer not alive");
            }
            int dequeueOutputBuffer = this.gJE.dequeueOutputBuffer(bufferInfo, j2);
            AppMethodBeat.o(155781);
            return dequeueOutputBuffer;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy dequeueOutputBuffer, thread:[%s]", Integer.valueOf(Process.myTid()));
            MediaCodecProxyUtils.b.oA(43);
            if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) && System.currentTimeMillis() - this.gJM > this.gJN) {
                this.gJM = System.currentTimeMillis();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.compatible.deviceinfo.z.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(201271);
                        Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy dequeueOutputBuffer, thread:[%s]", Integer.valueOf(Process.myTid())), 1).show();
                        AppMethodBeat.o(201271);
                    }
                });
            }
            this.gJK.getAndIncrement();
            AppMethodBeat.o(155781);
            throw e2;
        }
    }

    public final void releaseOutputBuffer(int i2, boolean z) {
        AppMethodBeat.i(155782);
        try {
            if (!this.dbi) {
                Log.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
                Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
            }
            this.gJE.releaseOutputBuffer(i2, z);
            AppMethodBeat.o(155782);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy releaseOutputBuffer 1, thread:[%s]", Integer.valueOf(Process.myTid()));
            a(44, e2, this.gJF);
            AppMethodBeat.o(155782);
            throw e2;
        }
    }

    public final void releaseOutputBuffer(int i2, long j2) {
        AppMethodBeat.i(155783);
        try {
            if (!this.dbi) {
                Log.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
                Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
            }
            MediaCodecProxyUtils.b.oA(114);
            this.gJE.releaseOutputBuffer(i2, j2);
            MediaCodecProxyUtils.b.oA(115);
            AppMethodBeat.o(155783);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy releaseOutputBuffer 2, thread:[%s]", Integer.valueOf(Process.myTid()));
            a(45, e2, this.gJF);
            AppMethodBeat.o(155783);
            throw e2;
        }
    }

    public final void signalEndOfInputStream() {
        AppMethodBeat.i(155784);
        try {
            Log.i("MicroMsg.MediaCodecProxy", "signalEndOfInputStream function, thread:[%s]", Integer.valueOf(Process.myTid()));
            MediaCodecProxyUtils.b.oA(117);
            this.gJE.signalEndOfInputStream();
            MediaCodecProxyUtils.b.oA(118);
            AppMethodBeat.o(155784);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy signalEndOfInputStream, thread:[%s]", Integer.valueOf(Process.myTid()));
            a(46, e2, this.gJF);
            AppMethodBeat.o(155784);
            throw e2;
        }
    }

    public final MediaFormat getOutputFormat() {
        AppMethodBeat.i(155785);
        try {
            MediaCodecProxyUtils.b.oA(120);
            MediaFormat outputFormat = this.gJE.getOutputFormat();
            MediaCodecProxyUtils.b.oA(121);
            AppMethodBeat.o(155785);
            return outputFormat;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy getOutputFormat, thread:[%s]", Integer.valueOf(Process.myTid()));
            a(47, e2, this.gJF);
            AppMethodBeat.o(155785);
            throw e2;
        }
    }

    public final ByteBuffer[] getInputBuffers() {
        AppMethodBeat.i(155786);
        try {
            MediaCodecProxyUtils.b.oA(126);
            ByteBuffer[] inputBuffers = this.gJE.getInputBuffers();
            MediaCodecProxyUtils.b.oA(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
            AppMethodBeat.o(155786);
            return inputBuffers;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy getInputBuffers", new Object[0]);
            a(49, e2, this.gJF);
            AppMethodBeat.o(155786);
            throw e2;
        }
    }

    public final ByteBuffer[] getOutputBuffers() {
        AppMethodBeat.i(155787);
        try {
            MediaCodecProxyUtils.b.oA(129);
            ByteBuffer[] outputBuffers = this.gJE.getOutputBuffers();
            MediaCodecProxyUtils.b.oA(130);
            AppMethodBeat.o(155787);
            return outputBuffers;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy getOutputBuffers", new Object[0]);
            a(50, e2, this.gJF);
            AppMethodBeat.o(155787);
            throw e2;
        }
    }

    public final ByteBuffer getInputBuffer(int i2) {
        AppMethodBeat.i(155788);
        try {
            MediaCodecProxyUtils.b.oA(132);
            ByteBuffer inputBuffer = this.gJE.getInputBuffer(i2);
            MediaCodecProxyUtils.b.oA(133);
            AppMethodBeat.o(155788);
            return inputBuffer;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy getInputBuffer", new Object[0]);
            a(51, e2, this.gJF);
            AppMethodBeat.o(155788);
            throw e2;
        }
    }

    public final ByteBuffer getOutputBuffer(int i2) {
        AppMethodBeat.i(155789);
        try {
            MediaCodecProxyUtils.b.oA(c.CTRL_INDEX);
            ByteBuffer outputBuffer = this.gJE.getOutputBuffer(i2);
            MediaCodecProxyUtils.b.oA(r.CTRL_INDEX);
            AppMethodBeat.o(155789);
            return outputBuffer;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy getOutputBuffer", new Object[0]);
            a(53, e2, this.gJF);
            AppMethodBeat.o(155789);
            throw e2;
        }
    }

    public final Image getOutputImage(int i2) {
        AppMethodBeat.i(155790);
        try {
            MediaCodecProxyUtils.b.oA(141);
            Image outputImage = this.gJE.getOutputImage(i2);
            MediaCodecProxyUtils.b.oA(TbsListener.ErrorCode.NEEDDOWNLOAD_3);
            AppMethodBeat.o(155790);
            return outputImage;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy getOutputImage", new Object[0]);
            a(54, e2, this.gJF);
            AppMethodBeat.o(155790);
            throw e2;
        }
    }

    public final String getName() {
        AppMethodBeat.i(155791);
        try {
            MediaCodecProxyUtils.b.oA(TbsListener.ErrorCode.NEEDDOWNLOAD_8);
            String name = this.gJE.getName();
            MediaCodecProxyUtils.b.oA(148);
            AppMethodBeat.o(155791);
            return name;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy getName", new Object[0]);
            a(56, e2, this.gJF);
            AppMethodBeat.o(155791);
            throw e2;
        }
    }

    public final void setParameters(Bundle bundle) {
        AppMethodBeat.i(155792);
        try {
            MediaCodecProxyUtils.b.oA(150);
            this.gJE.setParameters(bundle);
            MediaCodecProxyUtils.b.oA(151);
            AppMethodBeat.o(155792);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy setParameters, thread:[%s]", Integer.valueOf(Process.myTid()));
            a(57, e2, this.gJF);
            AppMethodBeat.o(155792);
            throw e2;
        }
    }

    @TargetApi(23)
    public final void setCallback(MediaCodec.Callback callback, Handler handler) {
        AppMethodBeat.i(155793);
        this.gJE.setCallback(callback, handler);
        AppMethodBeat.o(155793);
    }

    public final void setCallback(MediaCodec.Callback callback) {
        AppMethodBeat.i(155794);
        this.gJE.setCallback(callback);
        AppMethodBeat.o(155794);
    }

    private static String h(Exception exc) {
        AppMethodBeat.i(155795);
        if (exc != null) {
            String str = exc.toString() + "----" + Util.getStack().toString();
            AppMethodBeat.o(155795);
            return str;
        }
        String mMStack = Util.getStack().toString();
        AppMethodBeat.o(155795);
        return mMStack;
    }

    public static void a(int i2, Exception exc, MediaCodecProxyUtils.a aVar) {
        AppMethodBeat.i(155796);
        if (aVar != null) {
            aVar.stack = h(exc);
        }
        MediaCodecProxyUtils.b.oA(i2);
        MediaCodecProxyUtils.b.a(i2, aVar);
        AppMethodBeat.o(155796);
    }
}
