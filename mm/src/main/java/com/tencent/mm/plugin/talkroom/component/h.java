package com.tencent.mm.plugin.talkroom.component;

import android.media.AudioTrack;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.talkroom.component.e;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends e.a implements Runnable {
    private static final int FPn = a.FPn;
    private v2engine FOY;
    private short FOZ;
    private short FPa;
    private final c FPo;
    private boolean FPp = false;
    private long FPq = 0;
    private int FPr;
    private long FPs = 0;
    private AudioTrack bfn;
    private int bufferSize = (((FPn / 1000) * 20) * 2);
    private boolean dLD = true;
    private boolean doG = false;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private boolean jvd = false;
    private boolean jxb = true;
    private final Object lock = new Object();
    private int sampleRateInHz = FPn;
    private int yGE = 0;

    public h(v2engine v2engine, c cVar) {
        AppMethodBeat.i(29419);
        this.FOY = v2engine;
        this.FPo = cVar;
        this.jvd = true;
        if (this.bfn != null && this.bfn.getState() == 1) {
            this.bfn.stop();
        }
        if (this.bfn != null) {
            try {
                this.bfn.release();
            } catch (Exception e2) {
            }
        }
        com.tencent.mm.plugin.audio.c.a.agr("music").jp(true);
        int jv = com.tencent.mm.plugin.audio.c.a.jv(true);
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRateInHz, 2, 2);
        if (minBufferSize == -2 || minBufferSize == -1) {
            AppMethodBeat.o(29419);
            return;
        }
        this.bfn = new com.tencent.mm.compatible.b.e(jv, this.sampleRateInHz, 2, minBufferSize * 8);
        this.jvd = false;
        AppMethodBeat.o(29419);
    }

    @Override // com.tencent.mm.plugin.talkroom.component.e
    public final void cXa() {
        AppMethodBeat.i(29420);
        this.dLD = true;
        if (this.bfn != null && this.bfn.getState() == 1) {
            this.bfn.pause();
        }
        AppMethodBeat.o(29420);
    }

    @Override // com.tencent.mm.plugin.talkroom.component.e
    public final void eYd() {
        AppMethodBeat.i(29421);
        if (this.bfn != null && this.bfn.getState() == 1) {
            this.bfn.play();
        }
        synchronized (this.lock) {
            try {
                this.dLD = false;
                this.lock.notify();
            } catch (Throwable th) {
                AppMethodBeat.o(29421);
                throw th;
            }
        }
        this.FPa = 0;
        this.FOZ = 0;
        AppMethodBeat.o(29421);
    }

    @Override // com.tencent.mm.plugin.talkroom.component.e
    public final void release() {
        AppMethodBeat.i(29422);
        Log.i("MicroMsg.TalkRoomPlayer", "release");
        this.doG = true;
        if (this.bfn != null && this.bfn.getState() == 1) {
            this.bfn.stop();
        }
        if (this.bfn != null) {
            this.bfn.release();
        }
        synchronized (this.lock) {
            try {
                this.dLD = false;
                this.lock.notify();
            } finally {
                AppMethodBeat.o(29422);
            }
        }
    }

    public final void run() {
        final boolean z;
        AppMethodBeat.i(29423);
        while (!this.doG) {
            if (this.jvd) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e2) {
                    Log.printErrStackTrace("MicroMsg.TalkRoomPlayer", e2, "", new Object[0]);
                }
            } else {
                synchronized (this.lock) {
                    try {
                        if (this.dLD) {
                            try {
                                this.lock.wait();
                            } catch (InterruptedException e3) {
                                Log.printErrStackTrace("MicroMsg.TalkRoomPlayer", e3, "", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(29423);
                        throw th;
                    }
                }
                long j2 = this.FPs;
                this.FPs = Util.currentTicks();
                long j3 = this.FPs - j2;
                if (j3 < 20 && j3 > 0) {
                    try {
                        synchronized (this.lock) {
                            try {
                                this.lock.wait(j3);
                            } catch (Throwable th2) {
                                AppMethodBeat.o(29423);
                                throw th2;
                            }
                        }
                    } catch (InterruptedException e4) {
                        Log.printErrStackTrace("MicroMsg.TalkRoomPlayer", e4, "", new Object[0]);
                    }
                }
                try {
                    PByteArray pByteArray = new PByteArray();
                    final PInt pInt = new PInt();
                    final PInt pInt2 = new PInt();
                    int IsSilenceFrame = this.FOY.IsSilenceFrame();
                    int GetAudioData = IsSilenceFrame == 0 ? this.FOY.GetAudioData(pByteArray, this.bufferSize, pInt, pInt2) : 0;
                    if (GetAudioData < 0) {
                        this.yGE++;
                        Log.e("MicroMsg.TalkRoomPlayer", "GetAudioData err %d,  errcount %d", Integer.valueOf(GetAudioData), Integer.valueOf(this.yGE));
                        if (this.yGE >= 100) {
                            this.yGE = 0;
                            this.dLD = true;
                        }
                    } else {
                        if (IsSilenceFrame == 0) {
                            if (this.bfn.getPlayState() != 3) {
                                this.bfn.play();
                            }
                            byte[] bArr = pByteArray.value;
                            int length = pByteArray.value.length;
                            for (int i2 = 0; i2 < length / 2; i2++) {
                                short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                                if (s > this.FOZ) {
                                    this.FOZ = s;
                                }
                            }
                            this.bfn.write(pByteArray.value, 0, pByteArray.value.length);
                        } else if (this.jxb) {
                            this.bfn.pause();
                        }
                        if (IsSilenceFrame == 0) {
                            this.FPq = Util.currentTicks();
                            z = false;
                        } else if (Util.ticksToNow(this.FPq) < 1000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if ((((this.jxb || this.FPr != pInt2.value) && !z && pInt.value != 0) || (!this.jxb && z)) && !this.FPp) {
                            if (!z && pInt2.value != 0) {
                                this.FPr = pInt2.value;
                            }
                            this.handler.postAtFrontOfQueue(new Runnable() {
                                /* class com.tencent.mm.plugin.talkroom.component.h.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(29418);
                                    h.this.FPp = true;
                                    try {
                                        h.this.FPo.E(pInt.value, pInt2.value, z);
                                    } catch (RemoteException e2) {
                                        Log.printErrStackTrace("MicroMsg.TalkRoomPlayer", e2, "", new Object[0]);
                                    }
                                    h.this.FPp = false;
                                    AppMethodBeat.o(29418);
                                }
                            });
                            this.jxb = z;
                        }
                    }
                } catch (Exception e5) {
                    Log.printErrStackTrace("MicroMsg.TalkRoomPlayer", e5, "", new Object[0]);
                    Log.e("MicroMsg.TalkRoomPlayer", e5.toString());
                }
            }
        }
        AppMethodBeat.o(29423);
    }

    @Override // com.tencent.mm.plugin.talkroom.component.e
    public final int ftJ() {
        if (this.FPa < this.FOZ) {
            this.FPa = this.FOZ;
        }
        if (this.FPa == 0) {
            return 0;
        }
        short s = (short) ((this.FOZ * 100) / this.FPa);
        this.FOZ = 0;
        return s;
    }

    @Override // com.tencent.mm.plugin.talkroom.component.e
    public final void start() {
        AppMethodBeat.i(29424);
        com.tencent.f.h.RTc.ba(this);
        AppMethodBeat.o(29424);
    }
}
