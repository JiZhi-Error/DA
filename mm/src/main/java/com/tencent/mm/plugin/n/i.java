package com.tencent.mm.plugin.n;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Process;
import android.util.Pair;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public abstract class i {
    private static boolean zrL = (((b) g.af(b.class)).a(b.a.clicfg_mediacodec_double_release_switch, 1) == 1);
    private static long zrM = 0;
    private ByteBuffer[] bfQ;
    private MediaCodec.BufferInfo bth = new MediaCodec.BufferInfo();
    private ByteBuffer[] btv;
    private int btx;
    private int bty;
    protected long buq;
    long durationMs;
    protected FileDescriptor fd;
    protected z iec;
    private c jto;
    protected long length;
    private volatile Object lock = new Object();
    private String mime;
    protected String path;
    protected volatile int state;
    private int trackIndex;
    protected h zrC;
    protected MMHandler zrD;
    private volatile boolean zrE = false;
    b zrF = null;
    protected long zrG = 0;
    MediaFormat zrH;
    private g zrI;
    private boolean zrJ = false;
    private boolean zrK = false;

    /* access modifiers changed from: package-private */
    public abstract boolean a(long j2, long j3, z zVar, ByteBuffer byteBuffer, int i2, MediaCodec.BufferInfo bufferInfo);

    /* access modifiers changed from: package-private */
    public abstract boolean a(z zVar);

    /* access modifiers changed from: package-private */
    public abstract String type();

    public i(h hVar, MMHandler mMHandler) {
        this.zrC = hVar;
        this.zrD = mMHandler;
        this.state = 0;
        this.btx = -1;
        this.bty = -1;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void a(FileDescriptor fileDescriptor, long j2, long j3) {
        this.fd = fileDescriptor;
        this.buq = j2;
        this.length = j3;
    }

    private void eji() {
        if (this.zrF != null) {
            this.zrG = this.zrF.eja() * 1000;
        }
    }

    public final void ejj() {
        Log.i("MicroMsg.TrackDataSource", "%s flush codec", info());
        this.bty = -1;
        this.btx = -1;
        try {
            if (this.iec != null) {
                z zVar = this.iec;
                try {
                    if (!zVar.dbi) {
                        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy flush not alive");
                    }
                    MediaCodecProxyUtils.b.oA(96);
                    zVar.gJE.flush();
                    MediaCodecProxyUtils.b.oA(97);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy flush, thread:[%s]", Integer.valueOf(Process.myTid()));
                    MediaCodecProxyUtils.b.oA(39);
                    zVar.gJG.getAndIncrement();
                    throw e2;
                }
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.TrackDataSource", e3, "flushCodec exception", new Object[0]);
        }
    }

    public void release() {
        Log.i("MicroMsg.TrackDataSource", "%s release doubleReleaseSwitch:[%b]", info(), Boolean.valueOf(zrL));
        if (zrL) {
            Log.i("MicroMsg.TrackDataSource", "%s into release fun", info());
            if (this.jto != null) {
                Log.i("MicroMsg.TrackDataSource", "%s release,  extractor != null", info());
                this.jto.gLF.release();
                this.jto = null;
            }
            releaseDecoder();
            if (this.zrI != null) {
                Log.i("MicroMsg.TrackDataSource", "%s release,  mp4Extractor != null", info());
                this.zrI.release();
            }
            Log.i("MicroMsg.TrackDataSource", "%s finish release", info());
            return;
        }
        Log.i("MicroMsg.TrackDataSource", "%s release", info());
        if (this.jto != null) {
            this.jto.gLF.release();
            this.jto = null;
        }
        if (this.iec != null) {
            this.iec.release();
            this.iec = null;
        }
        if (this.zrI != null) {
            this.zrI.release();
        }
        Log.i("MicroMsg.TrackDataSource", "%s finish release", info());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void releaseDecoder() {
        /*
        // Method dump skipped, instructions count: 350
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.n.i.releaseDecoder():void");
    }

    /* access modifiers changed from: protected */
    public final boolean ejk() {
        try {
            Log.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", info(), this.mime);
            this.iec = z.DZ(this.mime);
            a(this.iec);
            this.iec.start();
            this.btv = this.iec.getInputBuffers();
            this.bfQ = this.iec.getOutputBuffers();
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s prepare decoder init decoder error ", info());
            this.zrC.aFi(type());
            return false;
        }
    }

    public final void start() {
        Log.i("MicroMsg.TrackDataSource", "%s start to play", info());
        this.zrE = false;
        setState(3);
        onStart();
    }

    public final void pause() {
        Log.i("MicroMsg.TrackDataSource", "%s start to pause", info());
        setState(4);
        onPause();
    }

    public final long QB(int i2) {
        Log.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", info(), Integer.valueOf(i2), Boolean.valueOf(this.zrE));
        this.zrE = false;
        if (this.zrI != null) {
            try {
                g gVar = this.zrI;
                long j2 = (long) (i2 * 1000);
                int i3 = 0;
                while (true) {
                    if (i3 >= gVar.jQy.size()) {
                        break;
                    }
                    Pair pair = gVar.jQy.get(i3);
                    if (j2 < ((Long) pair.second).longValue()) {
                        break;
                    } else if (j2 == ((Long) pair.second).longValue()) {
                        gVar.zrp = ((Integer) pair.first).intValue();
                        gVar.zro = gVar.jQx.get(gVar.zrp);
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 == 0 || i3 == gVar.jQy.size() - 1) {
                    gVar.zrp = ((Integer) gVar.jQy.get(i3).first).intValue();
                    gVar.zro = gVar.jQx.get(gVar.zrp);
                } else {
                    gVar.zrp = ((Integer) gVar.jQy.get(i3 - 1).first).intValue();
                    gVar.zro = gVar.jQx.get(gVar.zrp);
                }
                if (this.zrI.zro.igk < 0) {
                    aa(((long) i2) * 1000, -1);
                }
                if (this.zrI.zro.igk < 0) {
                    aa(0, -1);
                    this.zrC.ejf();
                }
                long j3 = this.zrI.zro.igk;
                Log.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", info(), Long.valueOf(j3));
                return j3 / 1000;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s extractor seek exception %s", info(), e2.toString());
                return 0;
            }
        } else {
            try {
                this.jto.seekTo((long) (i2 * 1000), 0);
                if (this.jto.gLF.getSampleTime() < 0) {
                    aa(((long) i2) * 1000, -1);
                }
                if (this.jto.gLF.getSampleTime() < 0) {
                    aa(0, -1);
                    this.zrC.ejf();
                }
                long sampleTime = this.jto.gLF.getSampleTime();
                int sampleFlags = this.jto.gLF.getSampleFlags();
                Log.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d], sampleFlag:%s", info(), Long.valueOf(sampleTime), Long.valueOf(this.jto.gLF.getCachedDuration()), Integer.valueOf(sampleFlags));
                if ((sampleFlags & 1) == 0) {
                    Log.e("MicroMsg.TrackDataSource", "%s seek error, not in keyframe!!", info());
                }
                if (sampleTime == 0 && i2 > 0) {
                    Log.e("MicroMsg.TrackDataSource", "%s seek error, not seek to %s", Integer.valueOf(i2 * 1000), info());
                }
                return sampleTime / 1000;
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.TrackDataSource", e3, "%s extractor seek exception %s", info(), e3.toString());
                return 0;
            }
        }
    }

    public final boolean prepare() {
        int i2;
        long j2;
        Log.i("MicroMsg.TrackDataSource", "%s start to prepare path %s", info(), this.path);
        long currentTicks = Util.currentTicks();
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("TrackDataSource");
        this.zrE = false;
        try {
            Log.i("MicroMsg.TrackDataSource", "%s start to init extractor", info());
            this.jto = new c();
            if (this instanceof l) {
                mmkv.putString("path", this.path == null ? "" : this.path);
                mmkv.putInt("type", 1);
                mmkv.putLong("ts", System.currentTimeMillis());
                mmkv.commit();
            }
            if (!Util.isNullOrNil(this.path)) {
                RandomAccessFile dB = s.dB(this.path, false);
                this.fd = dB.getFD();
                if (ae.gKv.gKi == 1) {
                    this.jto.setDataSource(this.fd, 0, s.boW(this.path));
                } else {
                    this.jto.setDataSource(this.fd);
                }
                dB.close();
            } else if (this.fd != null && this.fd.valid()) {
                this.jto.setDataSource(this.fd, this.buq, this.length);
            }
            int trackCount = this.jto.gLF.getTrackCount();
            if (trackCount <= 0) {
                Log.e("MicroMsg.TrackDataSource", "extractor get track count 0.");
                this.jto.gLF.release();
                this.jto = new c();
                this.jto.setDataSource(this.path);
                i2 = this.jto.gLF.getTrackCount();
            } else {
                i2 = trackCount;
            }
            this.trackIndex = -1;
            int i3 = 0;
            while (true) {
                if (i3 < i2) {
                    MediaFormat trackFormat = this.jto.getTrackFormat(i3);
                    String string = trackFormat.getString("mime");
                    if (string != null && string.contains(type())) {
                        b(trackFormat, string, i3);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (this.trackIndex < 0) {
                Log.w("MicroMsg.TrackDataSource", "%s prepare track but can not find track index.[%d, %d]", info(), Integer.valueOf(i2), Integer.valueOf(this.trackIndex));
                this.zrC.aFh("can not find ");
                if (mmkv.getString("path", "").equals(this.path) && (this instanceof l)) {
                    mmkv.putInt("type", 0);
                    mmkv.putString("path", "");
                    mmkv.putLong("ts", 0);
                    mmkv.commit();
                }
                return false;
            }
            this.jto.selectTrack(this.trackIndex);
            if (!Util.isNullOrNil(this.path)) {
                this.zrI = null;
            }
            long currentTicks2 = Util.currentTicks();
            if (mmkv.getString("path", "").equals(this.path) && (this instanceof l)) {
                mmkv.putInt("type", 0);
                mmkv.putString("path", "");
                mmkv.putLong("ts", 0);
                mmkv.commit();
            }
            try {
                Log.i("MicroMsg.TrackDataSource", "%s start to init decoder mime[%s] state[%d]", info(), this.mime, Integer.valueOf(this.state));
                if (!e.Qx(this.state)) {
                    synchronized (this.lock) {
                        Log.d("MicroMsg.TrackDataSource", "%s before prepare init decoder, format info: %s", info(), this.zrH);
                        this.iec = z.DZ(this.mime);
                        a(this.iec);
                        this.iec.start();
                        this.btv = this.iec.getInputBuffers();
                        this.bfQ = this.iec.getOutputBuffers();
                    }
                    j2 = Util.currentTicks();
                } else {
                    j2 = 0;
                }
                setState(1);
                Log.i("MicroMsg.TrackDataSource", "%s finish to prepare cost[%d %d %d]", info(), Long.valueOf(Util.ticksToNow(currentTicks)), Long.valueOf(currentTicks2 - currentTicks), Long.valueOf(j2 - currentTicks));
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s prepare init decoder error %s", info(), e2.toString());
                Log.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s prepare init decoder error, format info: %s", info(), this.zrH);
                this.zrC.aFi(type());
                return false;
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.TrackDataSource", e3, "%s prepare init extractor error", info());
            this.zrC.aFh(e3.toString());
            if (mmkv.getString("path", "").equals(this.path) && (this instanceof l)) {
                mmkv.putInt("type", 0);
                mmkv.putString("path", "");
                mmkv.putLong("ts", 0);
                mmkv.commit();
            }
            return false;
        } catch (Throwable th) {
            if (mmkv.getString("path", "").equals(this.path) && (this instanceof l)) {
                mmkv.putInt("type", 0);
                mmkv.putString("path", "");
                mmkv.putLong("ts", 0);
                mmkv.commit();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final int Z(long j2, long j3) {
        Log.d("MicroMsg.TrackDataSource", "%s start to do some work time[%d %d] state %d", info(), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.state));
        if (this.iec != null) {
            do {
                try {
                    if (g(j2, j3)) {
                    }
                } catch (Exception e2) {
                    if (this.zrJ) {
                        Log.e("MicroMsg.TrackDataSource", "%s do some work drain output buffer error %s", info(), e2.toString());
                    } else {
                        this.zrJ = true;
                        Log.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s do some work drain output buffer error", info());
                    }
                    if (!e.Qx(this.state)) {
                        ejj();
                    }
                    h hVar = this.zrC;
                    String type = type();
                    if (!hVar.zrA && hVar.zrx) {
                        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                            MMHandlerThread.postToMainThread(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a7: INVOKE  
                                  (wrap: com.tencent.mm.plugin.n.h$2 : 0x00a4: CONSTRUCTOR  (r1v11 com.tencent.mm.plugin.n.h$2) = (r0v7 'hVar' com.tencent.mm.plugin.n.h) call: com.tencent.mm.plugin.n.h.2.<init>(com.tencent.mm.plugin.n.h):void type: CONSTRUCTOR)
                                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.n.i.Z(long, long):int, file: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:362)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:317)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:229)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a4: CONSTRUCTOR  (r1v11 com.tencent.mm.plugin.n.h$2) = (r0v7 'hVar' com.tencent.mm.plugin.n.h) call: com.tencent.mm.plugin.n.h.2.<init>(com.tencent.mm.plugin.n.h):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.n.i.Z(long, long):int, file: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 40 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.n.h, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 46 more
                                */
                            /*
                            // Method dump skipped, instructions count: 402
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.n.i.Z(long, long):int");
                        }

                        private boolean g(long j2, long j3) {
                            boolean z;
                            Log.d("MicroMsg.TrackDataSource", "%s drain output buffer state:%s time[%d %d %s] index %d", info(), Integer.valueOf(this.state), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.jto.gLF.getSampleTime()), Integer.valueOf(this.bty));
                            long currentTicks = Util.currentTicks();
                            if (this.bty < 0) {
                                synchronized (this.lock) {
                                    this.bty = this.iec.dequeueOutputBuffer(this.bth, zrM);
                                }
                                if (this.bty >= 0) {
                                    if ((this.bth.flags & 4) != 0) {
                                        Log.i("MicroMsg.TrackDataSource", "%s process end of stream", info());
                                        setState(9);
                                        this.bty = -1;
                                        return false;
                                    }
                                    ByteBuffer byteBuffer = this.bfQ[this.bty];
                                    if (byteBuffer != null) {
                                        byteBuffer.position(this.bth.offset);
                                        byteBuffer.limit(this.bth.offset + this.bth.size);
                                    }
                                } else if (this.bty == -2) {
                                    MediaFormat outputFormat = this.iec.getOutputFormat();
                                    this.zrH = outputFormat;
                                    a(this.iec, outputFormat);
                                    return true;
                                } else if (this.bty == -3) {
                                    this.bfQ = this.iec.getOutputBuffers();
                                    return true;
                                } else {
                                    Log.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d] state:%s", info(), Integer.valueOf(this.bty), Integer.valueOf(this.state));
                                    return false;
                                }
                            }
                            if (this.state == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                this.iec.releaseOutputBuffer(this.bty, true);
                                this.bty = -1;
                                setState(2);
                                return true;
                            }
                            Log.d("MicroMsg.TrackDataSource", "%s process output buffer state:%s: index %d, cost:%s", info(), Integer.valueOf(this.state), Integer.valueOf(this.bty), Long.valueOf(Util.ticksToNow(currentTicks)));
                            synchronized (this.lock) {
                                if (!a(j2, j3, this.iec, this.bfQ[this.bty], this.bty, this.bth)) {
                                    return false;
                                }
                                this.bty = -1;
                                return true;
                            }
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:100:0x02b2  */
                        /* JADX WARNING: Removed duplicated region for block: B:83:0x0254  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        private boolean vc() {
                            /*
                            // Method dump skipped, instructions count: 1152
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.n.i.vc():boolean");
                        }

                        /* access modifiers changed from: protected */
                        public final boolean aa(long j2, long j3) {
                            long currentTicks = Util.currentTicks();
                            try {
                                if ((j2 / 1000) + 1000 < this.durationMs && j3 == -1) {
                                    Log.i("MicroMsg.TrackDataSource", "checkExtractor");
                                    MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("TrackDataSource");
                                    if (this instanceof l) {
                                        mmkv.putString("path", this.path == null ? "" : this.path);
                                        mmkv.putInt("type", 1);
                                        mmkv.putLong("ts", System.currentTimeMillis());
                                        mmkv.commit();
                                    }
                                    try {
                                        this.zrC.rsr = true;
                                        this.zrE = false;
                                        this.jto.gLF.release();
                                        this.jto = new c();
                                        if (!Util.isNullOrNil(this.path)) {
                                            RandomAccessFile dB = s.dB(this.path, false);
                                            FileDescriptor fd2 = dB.getFD();
                                            if (ae.gKv.gKi == 1) {
                                                this.jto.setDataSource(fd2, 0, s.boW(this.path));
                                            } else {
                                                this.jto.setDataSource(fd2);
                                            }
                                            dB.close();
                                        } else if (this.fd != null && this.fd.valid()) {
                                            this.jto.setDataSource(this.fd, this.buq, this.length);
                                        }
                                        if (mmkv.getString("path", "").equals(this.path) && (this instanceof l)) {
                                            mmkv.putInt("type", 0);
                                            mmkv.putString("path", "");
                                            mmkv.putLong("ts", 0);
                                            mmkv.commit();
                                        }
                                    } catch (Throwable th) {
                                        if (mmkv.getString("path", "").equals(this.path) && (this instanceof l)) {
                                            mmkv.putInt("type", 0);
                                            mmkv.putString("path", "");
                                            mmkv.putLong("ts", 0);
                                            mmkv.commit();
                                        }
                                        throw th;
                                    }
                                    this.jto.selectTrack(this.trackIndex);
                                    this.jto.seekTo(j2, 2);
                                    long sampleTime = this.jto.gLF.getSampleTime();
                                    try {
                                        if (Math.abs(sampleTime - j2) > 3000000 && this.path != null && this.path.contains("sns")) {
                                            h.INSTANCE.dN(150, 75);
                                            h.INSTANCE.a(17844, 1, new StringBuilder().append(sampleTime - j2).toString());
                                        }
                                    } catch (Throwable th2) {
                                    }
                                    Log.w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", info(), Long.valueOf(j2), Long.valueOf(sampleTime), Long.valueOf(j3), Long.valueOf(this.zrG), Long.valueOf(Util.ticksToNow(currentTicks)));
                                    return true;
                                }
                            } catch (Exception e2) {
                                Log.e("MicroMsg.TrackDataSource", "%s reset extractor error %s", info(), e2.toString());
                            }
                            return false;
                        }

                        /* access modifiers changed from: protected */
                        public boolean as(int i2, long j2) {
                            return false;
                        }

                        /* access modifiers changed from: protected */
                        public void b(MediaFormat mediaFormat, String str, int i2) {
                            Log.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d] format[%s]", info(), str, Integer.valueOf(i2), mediaFormat);
                            this.trackIndex = i2;
                            this.mime = str;
                            this.durationMs = mediaFormat.getLong("durationUs") / 1000;
                            this.zrH = mediaFormat;
                        }

                        /* access modifiers changed from: protected */
                        public final MediaFormat ejl() {
                            if (this.jto == null || this.trackIndex < 0) {
                                return this.zrH;
                            }
                            return this.jto.getTrackFormat(this.trackIndex);
                        }

                        /* access modifiers changed from: protected */
                        public void a(z zVar, MediaFormat mediaFormat) {
                        }

                        /* access modifiers changed from: protected */
                        public void onStart() {
                        }

                        /* access modifiers changed from: protected */
                        public void onPause() {
                        }

                        /* access modifiers changed from: protected */
                        public final void setState(int i2) {
                            Log.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", info(), Integer.valueOf(this.state), Integer.valueOf(i2));
                            this.state = i2;
                        }

                        public final String info() {
                            if (this.zrC != null) {
                                return type() + "_" + this.zrC.info() + "_" + Process.myTid();
                            }
                            return type() + "_" + Process.myTid();
                        }
                    }
