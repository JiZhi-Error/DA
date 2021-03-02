package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.f.h;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c {
    private static float volume = 0.0f;
    private b EgU;
    public boolean GSW = false;
    boolean GSX = false;
    boolean GSY = true;
    l GSZ = null;
    private long GTA = 0;
    private int GTB = 1;
    private int GTC = 0;
    private final Object GTD = new Object();
    private int GTE = 0;
    int GTF = 0;
    private int GTG = 0;
    private int GTH = 0;
    private int GTI = 0;
    private int GTa = 0;
    private byte[] GTb = null;
    private byte[] GTc = null;
    private byte[] GTd = null;
    private byte[] GTe = null;
    private byte[] GTf = null;
    public int GTg = 0;
    AtomicBoolean GTh = new AtomicBoolean(false);
    public b GTi = null;
    private int GTj = 1;
    private int GTk = 1;
    private int GTl = 0;
    String GTm = null;
    private int GTn = 0;
    private int GTo = 0;
    private int GTp = 0;
    private int GTq = 0;
    private int GTr = 0;
    private int GTs = 1;
    private int GTt = 0;
    private long GTu = 0;
    private long GTv = 0;
    private int GTw = 1;
    private int GTx = 0;
    private int GTy = -1;
    private int GTz = 0;
    AudioTrack bfn = null;
    Context context;
    private Timer dzR = null;
    private boolean dzS = false;
    private int gEe = 3;
    private com.tencent.mm.audio.c.a.a juN;
    int juY = 2;
    private int juZ = 0;
    int jvb = 0;
    int jvc = 20;
    private boolean jvd = false;
    private int nSamplerate = 0;
    private int omD = 0;

    public c() {
        AppMethodBeat.i(114815);
        AppMethodBeat.o(114815);
    }

    static /* synthetic */ void k(c cVar, int i2) {
        if (cVar.GTG != -1 && i2 < 0) {
            cVar.GTG++;
            if (cVar.GTG >= 50) {
                cVar.GTE = 5;
                cVar.GTG = -1;
            }
        }
    }

    public final int fFn() {
        return (this.GTC / this.jvc) * this.juZ;
    }

    public final int F(Context context2, boolean z) {
        boolean z2;
        AppMethodBeat.i(114816);
        Log.d("MicroMsg.Voip.AudioPlayer", "enter to Init...");
        this.context = context2;
        if (this.GTg == 2) {
            this.juY = 3;
        } else {
            this.juY = 2;
        }
        this.jvb = AudioTrack.getMinBufferSize(this.nSamplerate, this.juY, 2);
        if (this.jvb == -2 || this.jvb == -1) {
            this.GTE = 1;
            AppMethodBeat.o(114816);
            return -1;
        }
        this.GTr = this.jvb;
        this.GTx = this.GTr * this.GTw;
        this.jvb *= this.GTB;
        float f2 = ((float) (this.GTr >> 1)) / ((float) this.nSamplerate);
        int aon = m.aon();
        int i2 = ae.gKu.gEM;
        if ((aon & 1024) != 0) {
            if (i2 <= 0) {
                i2 = 0;
            }
            Log.i("MicroMsg.Voip.AudioPlayer", "CPU ARMv7, ablePlayTimer: ".concat(String.valueOf(i2)));
        } else {
            i2 = 0;
        }
        if (1000.0f * f2 < 60.0f || this.omD != 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.GSY = z2;
        this.GSY = false;
        Log.i("MicroMsg.Voip.AudioPlayer", "playBufSize:" + this.jvb + "  MinBufSizeInMs:" + f2 + ",bPlayTimer:" + this.GSY);
        int wT = wT(z);
        try {
            if (this.bfn != null) {
                try {
                    this.GTh.compareAndSet(false, true);
                    this.bfn.release();
                } catch (Exception e2) {
                }
            }
            this.bfn = new e(wT, this.nSamplerate, this.juY, this.jvb);
            this.GTh.compareAndSet(true, false);
        } catch (Exception e3) {
            Log.w("MicroMsg.Voip.AudioPlayer", "new AudioTrack:", e3);
            this.GTE = 6;
        }
        if (this.bfn == null || this.bfn.getState() == 0) {
            this.GTE = 2;
            Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer audioTrack.getState() == AudioTrack.STATE_UNINITIALIZED");
            if (this.bfn != null) {
                this.GTh.compareAndSet(false, true);
                this.bfn.release();
            }
            if (wT == 0) {
                this.bfn = new e(3, this.nSamplerate, this.juY, this.jvb);
            } else {
                this.bfn = new e(0, this.nSamplerate, this.juY, this.jvb);
            }
            this.GTh.compareAndSet(true, false);
        }
        if (this.bfn == null) {
            this.GTE = 3;
            Log.e("MicroMsg.Voip.AudioPlayer", "null == audioTrack return");
            AppMethodBeat.o(114816);
            return -1;
        } else if (this.bfn.getState() == 0) {
            this.GTE = 3;
            Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.GTh.compareAndSet(false, true);
            this.bfn.release();
            this.bfn = null;
            AppMethodBeat.o(114816);
            return -1;
        } else {
            this.GTb = new byte[this.jvb];
            if (this.GTb == null) {
                Log.e("MicroMsg.Voip.AudioPlayer", "null == playBuffer return");
                AppMethodBeat.o(114816);
                return -1;
            }
            this.GTe = new byte[this.jvc];
            if (this.GTe == null) {
                Log.e("MicroMsg.Voip.AudioPlayer", "null == frmBuffer return");
                AppMethodBeat.o(114816);
                return -1;
            }
            if (this.GSY) {
                this.GTa = this.jvb;
                this.GTc = new byte[this.GTa];
                if (this.GTc == null) {
                    Log.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBuffer return");
                    AppMethodBeat.o(114816);
                    return -1;
                }
                this.GTd = new byte[this.GTa];
                if (this.GTd == null) {
                    Log.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBufferTmp return");
                    AppMethodBeat.o(114816);
                    return -1;
                }
                this.GTf = new byte[this.jvc];
                if (this.GTf == null) {
                    Log.e("MicroMsg.Voip.AudioPlayer", "null == frmTaskBuffer return");
                    AppMethodBeat.o(114816);
                    return -1;
                }
            }
            this.GSW = false;
            this.GSX = false;
            Log.i("MicroMsg.Voip.AudioPlayer", "dkbt AudioTrack init ok, mode:%d issp:%b m:%d size %d,nSamplerate:%d", Integer.valueOf(com.tencent.mm.plugin.audio.c.a.getMode()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Integer.valueOf(wT), Integer.valueOf(this.jvb), Integer.valueOf(this.nSamplerate));
            int i3 = (this.jvb * 1000) / (this.nSamplerate * 2);
            AppMethodBeat.o(114816);
            return i3;
        }
    }

    public final boolean wS(boolean z) {
        AppMethodBeat.i(114817);
        Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
        int wT = wT(z);
        if (com.tencent.mm.plugin.audio.c.a.ceb()) {
            wT = 0;
        }
        Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + z + ":streamtype:" + wT);
        if (this.bfn == null || wT != this.bfn.getStreamType()) {
            fFr();
            this.jvd = true;
            if (this.GTg == 2) {
                this.juY = 3;
            } else {
                this.juY = 2;
            }
            this.jvb = AudioTrack.getMinBufferSize(this.nSamplerate, this.juY, 2);
            if (this.jvb == -2 || this.jvb == -1) {
                this.jvd = false;
                AppMethodBeat.o(114817);
                return false;
            }
            this.GTn = 0;
            this.GTq = 0;
            this.GTs = 1;
            this.GTt = 0;
            this.GTu = 0;
            this.GTv = 0;
            this.GTw = 1;
            this.GTy = -1;
            this.GTz = 0;
            this.GTr = this.jvb;
            this.GTx = this.GTr * this.GTw;
            this.jvb *= this.GTB;
            Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.jvb + "  MinBufSizeInMs:" + (((float) this.GTr) / 16.0f));
            if (this.bfn != null) {
                try {
                    this.GTh.compareAndSet(false, true);
                    this.EgU.cancel();
                    h.RTc.bqo("AudioPlayer_play");
                    this.bfn.stop();
                } catch (Exception e2) {
                    Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", e2.getMessage());
                }
                this.bfn.release();
                this.bfn = null;
            }
            Log.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", Integer.valueOf(com.tencent.mm.plugin.audio.c.a.getMode()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Integer.valueOf(wT), Integer.valueOf(this.jvb), Integer.valueOf(this.nSamplerate));
            this.bfn = new e(wT, this.nSamplerate, this.juY, this.jvb);
            if (this.bfn == null || this.bfn.getState() != 0) {
                Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
                if (this.bfn != null) {
                    this.jvd = false;
                    fFp();
                    AppMethodBeat.o(114817);
                    return true;
                }
                this.jvd = false;
                AppMethodBeat.o(114817);
                return false;
            }
            Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.GTh.compareAndSet(false, true);
            this.bfn.release();
            this.bfn = null;
            AppMethodBeat.o(114817);
            return false;
        }
        Log.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
        AppMethodBeat.o(114817);
        return false;
    }

    private int wT(boolean z) {
        AppMethodBeat.i(114818);
        int i2 = 0;
        if (ae.gKu.gDB > 0) {
            i2 = com.tencent.mm.plugin.audio.c.a.jv(z);
        } else if (ae.gKu.gEg >= 0) {
            i2 = ae.gKu.gEg;
        }
        if (z && ae.gKu.gEh >= 0) {
            i2 = ae.gKu.gEh;
        } else if (!z && ae.gKu.gEi >= 0) {
            i2 = ae.gKu.gEi;
        }
        if (1 == this.omD) {
            if (ae.gKu.gEW >= 0) {
                i2 = ae.gKu.gEW;
            }
            if (z && ae.gKu.gEX >= 0) {
                i2 = ae.gKu.gEX;
            } else if (!z && ae.gKu.gEY >= 0) {
                i2 = ae.gKu.gEY;
            }
        }
        AppMethodBeat.o(114818);
        return i2;
    }

    public final void a(b bVar) {
        this.GTi = bVar;
    }

    public final int fFo() {
        AppMethodBeat.i(114819);
        Log.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit");
        if (this.bfn != null) {
            this.GTh.compareAndSet(false, true);
            this.bfn.release();
            this.bfn = null;
        } else {
            Log.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit failed cause audio track is null");
        }
        this.GSW = false;
        this.GSX = false;
        AppMethodBeat.o(114819);
        return 1;
    }

    public final int N(int i2, int i3, int i4, int i5) {
        if (true == this.GSW) {
            return 0;
        }
        this.nSamplerate = i2;
        this.GTg = i3;
        this.juZ = i4;
        this.omD = i5;
        this.jvc = (this.nSamplerate / 1000) * i3 * this.juZ * 2;
        this.GTz = (this.nSamplerate * 60) / 1000;
        return 1;
    }

    public final int fFp() {
        boolean z;
        AppMethodBeat.i(114820);
        if (true == this.GSW) {
            AppMethodBeat.o(114820);
            return 1;
        } else if (this.bfn == null) {
            Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
            AppMethodBeat.o(114820);
            return 0;
        } else {
            this.GSW = true;
            try {
                this.bfn.play();
            } catch (Exception e2) {
                Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", e2.getMessage());
            }
            if (this.bfn != null && this.bfn.getPlayState() != 3) {
                this.GTE = 4;
                Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
                AppMethodBeat.o(114820);
                return 0;
            } else if (this.bfn == null || this.bfn.getState() != 0) {
                if (this.GSY) {
                    if (this.dzS || this.dzR != null) {
                        Log.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.dzS);
                        z = true;
                    } else {
                        this.dzR = new Timer();
                        if (this.dzR == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        Log.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
                        AppMethodBeat.o(114820);
                        return 0;
                    }
                    this.dzR.scheduleAtFixedRate(new a(), 0, 20);
                    this.dzS = true;
                }
                this.juN = new com.tencent.mm.audio.c.a.a();
                this.EgU = new b() {
                    /* class com.tencent.mm.plugin.voip.model.c.AnonymousClass1 */

                    @Override // com.tencent.f.i.h, com.tencent.f.i.g
                    public final String getKey() {
                        return "AudioPlayer_play";
                    }

                    public final void run() {
                        int i2;
                        int Q;
                        AppMethodBeat.i(114813);
                        Process.setThreadPriority(-19);
                        Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
                        int i3 = 0;
                        while (c.this.GSW && c.this.bfn != null && c.this.bfn.getPlayState() != 1 && !c.this.GTh.get()) {
                            try {
                                i2 = c.this.bfn.getPlaybackHeadPosition();
                            } catch (Exception e2) {
                                Log.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", e2);
                                c.this.GTE = 7;
                                i2 = 0;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            c.this.GTq = c.this.GTn - i2;
                            Log.i("MicroMsg.Voip.AudioPlayer", "m_iLefSamples value is %s and iPos value is %s", Integer.valueOf(c.this.GTq), Integer.valueOf(i2));
                            if (c.this.GTs == 1) {
                                c.this.GTt = i2;
                                c.this.GTu = currentTimeMillis;
                                c.this.GTv = currentTimeMillis;
                                c.this.GTs = 0;
                                c.this.GTA = currentTimeMillis;
                            } else {
                                int i4 = i2 - c.this.GTt;
                                if (i4 > c.this.GTy) {
                                    c.this.GTy = i4;
                                } else {
                                    c.this.GTy = (int) (((((float) c.this.GTy) * 49999.0f) / 50000.0f) + (((float) i4) / 50000.0f));
                                }
                                c.this.GTA = currentTimeMillis;
                                if (c.this.GTq == 0) {
                                    c.this.GTx += c.this.GTr;
                                } else if (currentTimeMillis > c.this.GTv + 5000) {
                                    c.this.GTv = currentTimeMillis;
                                    if (c.this.GTy < (c.this.GTx >> 1)) {
                                        c.this.GTx -= c.this.GTr >> 2;
                                    }
                                    if (c.this.GTy > c.this.GTx) {
                                        c.this.GTx = c.this.GTy;
                                    }
                                }
                                if (c.this.GTx < c.this.GTz) {
                                    c.this.GTx = c.this.GTz;
                                }
                                if (c.this.GTx < c.this.GTr) {
                                    c.this.GTx = c.this.GTr;
                                }
                                if (i4 > 0) {
                                    c.this.GTt = i2;
                                }
                            }
                            if (i2 != 0 && c.this.GSY) {
                                c.this.GTl = 1;
                            }
                            if (c.this.GTi != null) {
                                c.this.GTC += c.this.jvc;
                                if (c.this.GTl == 0) {
                                    if (c.this.omD == 0 && c.this.juN != null) {
                                        c.this.juN.e(c.this.jvc, c.this.GTe);
                                        c.this.juN.ck(1, (com.tencent.mm.plugin.audio.c.a.cea().getStreamVolume(c.this.bhV()) * 100) / com.tencent.mm.plugin.audio.c.a.cea().audioManager.getStreamMaxVolume(c.this.bhV()));
                                    }
                                    Q = c.this.GTi.Q(c.this.GTe, c.this.jvc);
                                } else {
                                    System.currentTimeMillis();
                                    if (c.this.GTp >= c.this.jvc) {
                                        Log.i("MicroMsg.Voip.AudioPlayer", "m_iTaskLeftByte value is %s and nFrameLen value is %s", Integer.valueOf(c.this.GTp), Integer.valueOf(c.this.jvc));
                                        synchronized (c.this.GTD) {
                                            try {
                                                System.arraycopy(c.this.GTc, 0, c.this.GTe, 0, c.this.jvc);
                                                int i5 = c.this.GTp - c.this.jvc;
                                                System.arraycopy(c.this.GTc, c.this.jvc, c.this.GTd, 0, i5);
                                                System.arraycopy(c.this.GTd, 0, c.this.GTc, 0, i5);
                                                c.this.GTp -= c.this.jvc;
                                                Log.i("MicroMsg.Voip.AudioPlayer", "audio player has copy playTaskBuffer and left %s", Integer.valueOf(c.this.GTp));
                                            } catch (Throwable th) {
                                                AppMethodBeat.o(114813);
                                                throw th;
                                            }
                                        }
                                        Q = 0;
                                    } else if (c.this.GTq >= (c.this.nSamplerate * 5) / 1000 || c.this.GTH != 0) {
                                        Log.i("MicroMsg.Voip.AudioPlayer", "play run too fast !,m_iLefSamples: " + c.this.GTq + " ,m_iTaskLeftByte: " + c.this.GTp);
                                        com.tencent.mm.plugin.voip.b.e.adF(2);
                                    } else {
                                        c.this.GTI = 1;
                                        if (c.this.omD == 0 && c.this.juN != null) {
                                            c.this.juN.e(c.this.jvc, c.this.GTe);
                                            c.this.juN.ck(1, (com.tencent.mm.plugin.audio.c.a.cea().audioManager.getStreamVolume(c.this.bhV()) * 100) / com.tencent.mm.plugin.audio.c.a.cea().audioManager.getStreamMaxVolume(c.this.bhV()));
                                        }
                                        Q = c.this.GTi.Q(c.this.GTe, c.this.jvc);
                                        c.this.GTI = 0;
                                    }
                                }
                                if (Q < 0) {
                                    com.tencent.mm.plugin.voip.b.e.adF(5);
                                    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(Q)));
                                } else if (c.this.jvd) {
                                    Log.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + c.this.jvd);
                                    com.tencent.mm.plugin.voip.b.e.adF(10);
                                } else {
                                    c.this.GTu = currentTimeMillis;
                                    if (c.this.jvb < c.this.jvc) {
                                        System.arraycopy(c.this.GTe, 0, c.this.GTb, i3, c.this.jvb - i3);
                                        if (c.this.bfn != null) {
                                            c.this.GTF++;
                                            int write = c.this.bfn.write(c.this.GTb, 0, c.this.GTb.length);
                                            if (write < 0) {
                                                c.k(c.this, write);
                                                Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(write)));
                                            }
                                            c.this.GTn += c.this.GTb.length >> 1;
                                            int i6 = c.this.jvb - i3;
                                            int i7 = c.this.jvc - i6;
                                            while (i7 >= c.this.jvb && c.this.bfn != null) {
                                                c.this.GTF++;
                                                c.this.bfn.write(c.this.GTe, i6, c.this.jvb);
                                                i6 += c.this.jvb;
                                                i7 -= c.this.jvb;
                                                c.this.GTn += c.this.jvb >> 1;
                                            }
                                            System.arraycopy(c.this.GTe, i6, c.this.GTb, 0, i7);
                                            i3 = i7;
                                        } else {
                                            AppMethodBeat.o(114813);
                                            return;
                                        }
                                    } else if (!c.this.jvd) {
                                        c.this.GTF++;
                                        int write2 = c.this.bfn.write(c.this.GTe, 0, c.this.jvc);
                                        if (write2 < 0) {
                                            c.k(c.this, write2);
                                            Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(write2)));
                                        }
                                        c.this.GTn += c.this.jvc >> 1;
                                    }
                                }
                            } else {
                                com.tencent.mm.plugin.voip.b.e.adF(10);
                            }
                        }
                        if (!(c.this.omD != 0 || c.this.GTm == null || c.this.juN == null)) {
                            c.this.juN.b(1, c.this.GTm, c.this.bhV());
                            c.this.juN.jm(1);
                            c.this.juN.jn(1);
                            c.this.juN.jo(1);
                        }
                        AppMethodBeat.o(114813);
                    }
                };
                h.RTc.bqo("AudioPlayer_play");
                h.RTc.b(this.EgU, "AudioPlayer_play");
                AppMethodBeat.o(114820);
                return 1;
            } else {
                Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
                AppMethodBeat.o(114820);
                return 0;
            }
        }
    }

    public final int fFq() {
        AppMethodBeat.i(114821);
        if (this.nSamplerate == 0) {
            Log.e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
            AppMethodBeat.o(114821);
            return 0;
        } else if (this.bfn == null) {
            Log.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.GTr + ",nSamplerate:" + this.nSamplerate);
            int i2 = (this.GTr * 1000) / this.nSamplerate;
            AppMethodBeat.o(114821);
            return i2;
        } else if (!this.GSW || this.bfn.getState() == 0) {
            int i3 = (this.GTr * 1000) / this.nSamplerate;
            AppMethodBeat.o(114821);
            return i3;
        } else {
            try {
                int playbackHeadPosition = ((this.GTn - this.bfn.getPlaybackHeadPosition()) * 1000) / this.nSamplerate;
                AppMethodBeat.o(114821);
                return playbackHeadPosition;
            } catch (Exception e2) {
                Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", e2.getMessage());
                int i4 = (this.GTr * 1000) / this.nSamplerate;
                AppMethodBeat.o(114821);
                return i4;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends TimerTask {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(114814);
            System.currentTimeMillis();
            if (c.this.GTl == 1 && c.this.GSW) {
                System.currentTimeMillis();
                if (c.this.GTp + c.this.jvc < c.this.GTa && c.this.GTI == 0 && c.this.GTi != null) {
                    c.this.GTH = 1;
                    int Q = c.this.GTi.Q(c.this.GTf, c.this.jvc);
                    c.this.GTH = 0;
                    if (Q < 0) {
                        Log.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(Q)));
                        AppMethodBeat.o(114814);
                        return;
                    }
                    synchronized (c.this.GTD) {
                        try {
                            System.arraycopy(c.this.GTf, 0, c.this.GTc, c.this.GTp, c.this.jvc);
                            c.this.GTp += c.this.jvc;
                            c.this.GTo += c.this.jvc >> 1;
                        } finally {
                            AppMethodBeat.o(114814);
                        }
                    }
                    return;
                }
            }
            AppMethodBeat.o(114814);
        }
    }

    public final int fFr() {
        AppMethodBeat.i(114822);
        if (this.dzS && this.dzR != null) {
            this.dzR.cancel();
            this.dzS = false;
        }
        Log.i("MicroMsg.Voip.AudioPlayer", "audio player call stop play");
        if (!this.GSW) {
            Log.i("MicroMsg.Voip.AudioPlayer", "audio player call stop play failed cause current is not playing ");
            AppMethodBeat.o(114822);
        } else {
            this.GSW = false;
            this.GTC = 0;
            try {
                if (this.EgU != null) {
                    try {
                        this.EgU.hmy();
                    } catch (ExecutionException e2) {
                        Log.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e2, "", new Object[0]);
                    }
                }
            } catch (InterruptedException | CancellationException e3) {
                Log.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e3, "", new Object[0]);
            }
            try {
                if (this.bfn != null) {
                    this.GTh.compareAndSet(false, true);
                    this.EgU.cancel();
                    h.RTc.bqo("AudioPlayer_play");
                    this.bfn.stop();
                    this.bfn.release();
                    Log.i("MicroMsg.Voip.AudioPlayer", "StopPlay stop audioTrack");
                }
            } catch (Exception e4) {
                Log.e("MicroMsg.Voip.AudioPlayer", "StopPlay audioTrack.stop Exception:%s", e4.getMessage());
            }
            AppMethodBeat.o(114822);
        }
        return 1;
    }

    public final int getVolume() {
        AppMethodBeat.i(235480);
        AudioManager audioManager = (AudioManager) MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (audioManager == null || this.bfn == null) {
            AppMethodBeat.o(235480);
            return 0;
        }
        int streamVolume = audioManager.getStreamVolume(this.bfn.getStreamType());
        AppMethodBeat.o(235480);
        return streamVolume;
    }

    public final int fFs() {
        AppMethodBeat.i(114823);
        Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.GTE);
        int i2 = this.GTE;
        AppMethodBeat.o(114823);
        return i2;
    }

    public final int bhV() {
        AppMethodBeat.i(114824);
        if (this.bfn != null) {
            int streamType = this.bfn.getStreamType();
            AppMethodBeat.o(114824);
            return streamType;
        }
        int wT = wT(true);
        AppMethodBeat.o(114824);
        return wT;
    }

    public final boolean isPlaying() {
        return this.GSW;
    }
}
