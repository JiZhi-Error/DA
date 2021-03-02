package com.tencent.mm.audio.b;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.SystemClock;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.f;
import com.tencent.mm.audio.e.b;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;

public final class c {
    public int dyZ = 0;
    public int dzA = 1;
    private int dzB = 0;
    public String dzC;
    private f.a dzD = new f.a() {
        /* class com.tencent.mm.audio.b.c.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.f.a
        public final void d(int i2, byte[] bArr) {
            int i3;
            int i4;
            AppMethodBeat.i(129979);
            c.this.dzr++;
            if (c.this.dzt && System.currentTimeMillis() - c.this.dzm <= 1000 && ((long) (c.this.dzr - 10)) > (System.currentTimeMillis() - c.this.dzm) / ((long) c.this.dzf)) {
                h.INSTANCE.idkeyStat(151, 0, 1, false);
                h.INSTANCE.idkeyStat(151, 4, 1, false);
                Log.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", Integer.valueOf(c.this.dzr), Long.valueOf((System.currentTimeMillis() - c.this.dzm) / ((long) c.this.dzf)));
                c.this.dzs = true;
            }
            if (c.this.dzy != null) {
                c.this.dzy.A(bArr, i2);
            }
            if (i2 > 0) {
                c cVar = c.this;
                if (!cVar.dzo || -2 != cVar.dzb) {
                    int i5 = i2 / cVar.dzn;
                    int i6 = 5;
                    while (true) {
                        if (i6 > cVar.dzp + i5) {
                            break;
                        }
                        i3 = ((i6 - cVar.dzp) - 1) * cVar.dzn;
                        i4 = cVar.dzn + i3;
                        if (i3 < 0 || i4 > i2) {
                            Log.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", Integer.valueOf(i3), Integer.valueOf(i4));
                        } else {
                            while (true) {
                                if (i3 >= i4) {
                                    break;
                                } else if (bArr[i3] != 0) {
                                    cVar.dzb = -1;
                                    cVar.dzo = true;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            cVar.dzb++;
                            i6 += 5;
                        }
                    }
                    Log.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", Integer.valueOf(i3), Integer.valueOf(i4));
                    cVar.dzp = (cVar.dzp + i5) % 5;
                    if (cVar.dzb == 20) {
                        cVar.dyZ = 6;
                        Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
                        if (cVar.dza == -1 && cVar.dzc == -1) {
                            cVar.dyZ = 11;
                            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar.dza == -1) {
                            cVar.dyZ = 8;
                            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                        } else if (cVar.dzc == -1) {
                            cVar.dyZ = 9;
                            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        }
                        if (com.tencent.mm.plugin.audio.c.a.cea().audioManager.isMicrophoneMute()) {
                            com.tencent.mm.audio.c.b.a.js(cVar.dzj);
                        }
                        if (com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn() || com.tencent.mm.plugin.audio.c.a.cea().cdW()) {
                            com.tencent.mm.audio.c.b.a.jt(cVar.dzj);
                        }
                        Log.e("MicroMsg.MMPcmRecorder", "record is mute %s", Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cea().audioManager.isMicrophoneMute()));
                        h.INSTANCE.idkeyStat(151, 0, 1, false);
                        h.INSTANCE.idkeyStat(151, 5, 1, false);
                        cVar.dzb = -2;
                        cVar.aak();
                    }
                }
            }
            if (c.this.dzh) {
                if (i2 > 0) {
                    c cVar2 = c.this;
                    if (cVar2.dza != -1) {
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            if (i8 >= i2 / 2) {
                                break;
                            }
                            short s = (short) ((bArr[(i8 * 2) + 1] << 8) | (bArr[(i8 * 2) + 0] & 255));
                            if (s >= 32760 || s == Short.MIN_VALUE) {
                                i7++;
                            }
                            if (i7 >= 5) {
                                cVar2.dza++;
                                break;
                            }
                            i8++;
                        }
                        if (cVar2.dza > 100) {
                            cVar2.dyZ = 7;
                            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                            if (cVar2.dzb == -2 && cVar2.dzc == -1) {
                                cVar2.dyZ = 11;
                                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                            } else if (cVar2.dzb == -2) {
                                cVar2.dyZ = 8;
                                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                            } else if (cVar2.dzc == -1) {
                                cVar2.dyZ = 10;
                                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                            }
                            h.INSTANCE.idkeyStat(151, 0, 1, false);
                            h.INSTANCE.idkeyStat(151, 6, 1, false);
                            cVar2.aak();
                            cVar2.dza = -1;
                        }
                    }
                    AppMethodBeat.o(129979);
                    return;
                }
                c cVar3 = c.this;
                if (cVar3.dzc != -1 && i2 < 0) {
                    cVar3.dzc++;
                    if (cVar3.dzc >= 50) {
                        cVar3.dyZ = 5;
                        Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
                        if (cVar3.dzb == -2 && cVar3.dza == -1) {
                            cVar3.dyZ = 11;
                            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar3.dzb == -2) {
                            cVar3.dyZ = 9;
                            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        } else if (cVar3.dza == -1) {
                            cVar3.dyZ = 10;
                            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                        }
                        h.INSTANCE.idkeyStat(151, 0, 1, false);
                        h.INSTANCE.idkeyStat(151, 7, 1, false);
                        cVar3.aak();
                        cVar3.dzc = -1;
                    }
                }
            }
            AppMethodBeat.o(129979);
        }
    };
    int dza = 0;
    int dzb = 0;
    int dzc = 0;
    public int dzd = 1;
    private int dze = 1;
    public int dzf = 120;
    private boolean dzg = false;
    boolean dzh = false;
    private int dzi = 10;
    int dzj = -1;
    public int dzk = -123456789;
    private boolean dzl = false;
    long dzm = -1;
    int dzn;
    boolean dzo = false;
    int dzp;
    private boolean dzq = false;
    int dzr = 0;
    boolean dzs = false;
    boolean dzt = false;
    private AudioRecord dzu;
    public a dzv;
    private f dzw;
    private com.tencent.mm.compatible.b.h dzx;
    b dzy;
    private int dzz = 16;
    private int mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;

    public interface a {
        void cj(int i2, int i3);

        void w(byte[] bArr, int i2);
    }

    public final void a(a aVar) {
        this.dzv = aVar;
    }

    public c(int i2, int i3, int i4) {
        AppMethodBeat.i(129980);
        this.dze = i3;
        this.mSampleRate = i2;
        this.dzj = i4;
        if (this.dze == 2) {
            this.dzz = 12;
        } else {
            this.dzz = 16;
        }
        if (this.dzj == 0 && ae.gKE.gGD > 0) {
            this.dzf = ae.gKE.gGD;
        }
        if (ae.gKE.gGO > 0) {
            this.dzz = ae.gKE.gGO;
        }
        if (ae.gKE.gGy > 0) {
            this.dzi = ae.gKE.gGy;
        }
        if (ae.gKu.gEj) {
            this.dzy = new b(g.dAa, this.dze, this.mSampleRate);
        }
        this.dzt = 1 == g.B("EnableRecorderCheckUnreasonableData", 1);
        Log.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", Integer.valueOf(this.mSampleRate), Integer.valueOf(this.dze), Integer.valueOf(this.dzf), Boolean.valueOf(this.dzg), Integer.valueOf(this.dzj));
        AppMethodBeat.o(129980);
    }

    public final void jk(int i2) {
        AppMethodBeat.i(129981);
        this.dzf = i2;
        Log.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.dzf);
        AppMethodBeat.o(129981);
    }

    public final void dc(boolean z) {
        AppMethodBeat.i(129982);
        this.dzg = z;
        Log.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.dzg);
        AppMethodBeat.o(129982);
    }

    public final void aag() {
        AppMethodBeat.i(129983);
        this.dzh = true;
        Log.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.dzh);
        AppMethodBeat.o(129983);
    }

    public final void x(int i2, boolean z) {
        AppMethodBeat.i(129984);
        if (10 == this.dzi || z) {
            this.dzi = i2;
            Log.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.dzi);
        }
        AppMethodBeat.o(129984);
    }

    public final int aah() {
        AppMethodBeat.i(129985);
        if (this.dzB > 0) {
            int i2 = this.dzB;
            AppMethodBeat.o(129985);
            return i2;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(this.mSampleRate, this.dzz, 2);
        Log.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", Integer.valueOf(minBufferSize));
        if (minBufferSize == -2 || minBufferSize == -1) {
            AppMethodBeat.o(129985);
            return 0;
        }
        this.dzB = this.dzi * minBufferSize;
        int i3 = this.dzB;
        AppMethodBeat.o(129985);
        return i3;
    }

    public final void dd(boolean z) {
        AppMethodBeat.i(129986);
        this.dzl = z;
        Log.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.dzl);
        AppMethodBeat.o(129986);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0241  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean init() {
        /*
        // Method dump skipped, instructions count: 924
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.b.c.init():boolean");
    }

    public final void de(boolean z) {
        AppMethodBeat.i(129988);
        Log.i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(z)));
        if (this.dzw != null) {
            this.dzw.de(z);
        }
        AppMethodBeat.o(129988);
    }

    public final boolean aai() {
        boolean z = false;
        AppMethodBeat.i(129989);
        Log.i("MicroMsg.MMPcmRecorder", JsApiStartRecordVoice.NAME);
        pk pkVar = new pk();
        pkVar.dVx.type = 1;
        pkVar.dVx.dVz = true;
        EventCenter.instance.publish(pkVar);
        this.dzm = System.currentTimeMillis();
        this.dzo = false;
        if (pkVar.dVy.dVB) {
            Log.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
            this.dyZ = 13;
            AppMethodBeat.o(129989);
        } else {
            AudioManager audioManager = (AudioManager) MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null || !audioManager.isMicrophoneMute()) {
                this.dzq = false;
                z = aaj();
                if (!z) {
                    ZZ();
                    pl plVar = new pl();
                    plVar.dVC.type = 1;
                    EventCenter.instance.publish(plVar);
                } else {
                    com.tencent.mm.audio.c.b.a.cl(this.dzj, this.dzu.getAudioSource());
                }
                AppMethodBeat.o(129989);
            } else {
                Log.e("MicroMsg.MMPcmRecorder", "microphone is mute");
                this.dyZ = 14;
                EventCenter.instance.publish(new mm());
                h.INSTANCE.idkeyStat(151, 0, 1, false);
                h.INSTANCE.idkeyStat(151, 8, 1, false);
                com.tencent.mm.audio.c.b.a.jx(this.dzj);
                AppMethodBeat.o(129989);
            }
        }
        return z;
    }

    private boolean aaj() {
        AppMethodBeat.i(129990);
        f.a aVar = new f.a();
        Log.i("MicroMsg.MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.dzu != null) {
            com.tencent.mm.audio.c.b.a.jw(this.dzj);
            Log.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
            AppMethodBeat.o(129990);
            return false;
        }
        aVar.gLm = SystemClock.elapsedRealtime();
        Log.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
        if (!init()) {
            Log.e("MicroMsg.MMPcmRecorder", "startRecord init error");
            AppMethodBeat.o(129990);
            return false;
        }
        Log.i("MicroMsg.MMPcmRecorder", "init cost: " + aVar.apr() + LocaleUtil.MALAY);
        aVar.gLm = SystemClock.elapsedRealtime();
        try {
            this.dzu.startRecording();
            Log.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + aVar.apr());
            if (this.dzu.getRecordingState() != 3) {
                h.INSTANCE.idkeyStat(151, 0, 1, false);
                h.INSTANCE.idkeyStat(151, 3, 1, false);
                this.dzA = 2;
                this.dyZ = 4;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
                aak();
                com.tencent.mm.audio.c.b.a.jq(this.dzj);
                AppMethodBeat.o(129990);
                return false;
            } else if (this.dzw != null) {
                boolean aai = this.dzw.aai();
                AppMethodBeat.o(129990);
                return aai;
            } else {
                Log.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
                com.tencent.mm.audio.c.b.a.jp(this.dzj);
                AppMethodBeat.o(129990);
                return false;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MMPcmRecorder", "start error cause permission deny");
            this.dzA = 2;
            this.dyZ = 4;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
            aak();
            com.tencent.mm.audio.c.b.a.jq(this.dzj);
            AppMethodBeat.o(129990);
            return false;
        }
    }

    public final synchronized boolean ZZ() {
        boolean z;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.i(129991);
            if (true == this.dzq) {
                Log.i("MicroMsg.MMPcmRecorder", "already have stopped");
                AppMethodBeat.o(129991);
                z = true;
            } else {
                this.dzq = true;
                f.a aVar = new f.a();
                if (this.dzy != null) {
                    this.dzy.closeFile();
                    this.dzy = null;
                }
                aVar.gLm = SystemClock.elapsedRealtime();
                if (this.dzw != null) {
                    this.dzw.stopRecord();
                    this.dzw = null;
                }
                Log.i("MicroMsg.MMPcmRecorder", "cost " + aVar.apr() + "ms to call stopRecord");
                Log.i("MicroMsg.MMPcmRecorder", "stopRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.dzu == null) {
                    Log.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
                    z = false;
                } else if (this.dzu.getState() != 1) {
                    Log.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.dzu.getState());
                    z = false;
                } else {
                    if (this.dzC != null) {
                        if (this.dzj == 0) {
                            com.tencent.mm.audio.c.b.a.a(0, this.dzC, this.dzd, this.mSampleRate, this.dzz, this.dyZ);
                            com.tencent.mm.audio.c.b.a.jz(this.dzj);
                            com.tencent.mm.audio.c.b.a.jy(this.dzj);
                        } else if (this.dzj == 1) {
                            com.tencent.mm.audio.c.b.a.a(1, this.dzC, this.dzd, this.mSampleRate, this.dzz, this.dyZ);
                            com.tencent.mm.audio.c.b.a.jz(this.dzj);
                            com.tencent.mm.audio.c.b.a.jy(this.dzj);
                        }
                    }
                    aVar.gLm = SystemClock.elapsedRealtime();
                    this.dzu.stop();
                    this.dzu.release();
                    this.dzu = null;
                    Log.i("MicroMsg.MMPcmRecorder", "cost " + aVar.apr() + "ms to call stop and release");
                    z = true;
                }
                if ((!this.dzo && -1 != this.dzm && System.currentTimeMillis() - this.dzm >= 2000) || this.dzs) {
                    Log.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
                    pl plVar = new pl();
                    plVar.dVC.type = 1;
                    EventCenter.instance.publish(plVar);
                    z2 = false;
                }
                pk pkVar = new pk();
                pkVar.dVx.type = 1;
                pkVar.dVx.dVz = false;
                pkVar.dVx.dVA = z2;
                EventCenter.instance.publish(pkVar);
                Log.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", Integer.valueOf(this.dyZ));
                ArrayList<IDKey> arrayList = new ArrayList<>();
                arrayList.add(new IDKey(357, 0, 1));
                if (this.dyZ != 0) {
                    arrayList.add(new IDKey(357, 1, 1));
                }
                switch (this.dyZ) {
                    case 1:
                        arrayList.add(new IDKey(357, 2, 1));
                        break;
                    case 2:
                        arrayList.add(new IDKey(357, 3, 1));
                        break;
                    case 3:
                        arrayList.add(new IDKey(357, 4, 1));
                        break;
                    case 4:
                        arrayList.add(new IDKey(357, 5, 1));
                        break;
                    case 5:
                        arrayList.add(new IDKey(357, 6, 1));
                        break;
                    case 6:
                        arrayList.add(new IDKey(357, 7, 1));
                        break;
                    case 7:
                        arrayList.add(new IDKey(357, 8, 1));
                        break;
                    case 8:
                        arrayList.add(new IDKey(357, 9, 1));
                        break;
                    case 9:
                        arrayList.add(new IDKey(357, 10, 1));
                        break;
                    case 10:
                        arrayList.add(new IDKey(357, 11, 1));
                        break;
                    case 11:
                        arrayList.add(new IDKey(357, 12, 1));
                        break;
                    case 12:
                        arrayList.add(new IDKey(357, 13, 1));
                        break;
                }
                Log.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", Integer.valueOf(arrayList.size()));
                h.INSTANCE.b(arrayList, false);
                AppMethodBeat.o(129991);
            }
        }
        return z;
    }

    public final void setAudioSource(int i2) {
        AppMethodBeat.i(200986);
        this.dzd = i2;
        Log.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(200986);
    }

    /* access modifiers changed from: package-private */
    public final void aak() {
        AppMethodBeat.i(129992);
        if (this.dzv != null) {
            this.dzv.cj(this.dzA, this.dyZ);
        }
        AppMethodBeat.o(129992);
    }

    public final int aal() {
        AppMethodBeat.i(129993);
        if (this.dzw != null) {
            int aal = this.dzw.aal();
            AppMethodBeat.o(129993);
            return aal;
        }
        AppMethodBeat.o(129993);
        return -1;
    }
}
