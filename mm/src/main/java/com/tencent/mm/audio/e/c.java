package com.tencent.mm.audio.e;

import com.tencent.f.i.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.e.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class c implements a {
    private static a.C0273a dBy = new a.C0273a();
    public BlockingQueue<g.a> dBm = new ArrayBlockingQueue(1024);
    public boolean dBn = false;
    private String dBo;
    private int dBp = 0;
    private byte[] dBq = null;
    private int dBr = 16000;
    private Object dBs = new Object();
    public a dBt = null;
    private boolean dBu = false;
    private int dBv;
    private boolean dBw = false;
    private i dBx;
    private volatile OutputStream mFileOutputStream;
    private int mSampleRate = 16000;

    public c(int i2, int i3) {
        AppMethodBeat.i(130015);
        this.mSampleRate = i2;
        this.dBr = i3;
        AppMethodBeat.o(130015);
    }

    @Override // com.tencent.mm.audio.e.a
    public final boolean hz(String str) {
        AppMethodBeat.i(130016);
        Log.i("MicroMsg.SilkWriter", "initWriter path: ".concat(String.valueOf(str)));
        if (str == null) {
            Log.e("MicroMsg.SilkWriter", "path is null");
            AppMethodBeat.o(130016);
            return false;
        }
        try {
            o oVar = new o(str);
            o oVar2 = new o(str);
            String substring = str.substring(0, str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP) + 1);
            Log.e("MicroMsg.SilkWriter", "[carl] !!!! VFS parent! exists(ret %s). Parent dir(%s)", Boolean.valueOf(new o(substring).exists()), substring);
            if (!oVar.heq().exists()) {
                Log.e("MicroMsg.SilkWriter", "[carl] ???? Dir not created! Do mkdirs(ret %s). Parent dir(%s)", Boolean.valueOf(oVar.heq().mkdirs()), aa.z(oVar.heq().her()));
                h.INSTANCE.n(357, 58, 1);
            } else if (!oVar2.heq().exists()) {
                Log.e("MicroMsg.SilkWriter", "[carl] !!!! VFS not created dir! Do mkdirs(ret %s). Parent dir(%s)", Boolean.valueOf(oVar2.heq().mkdirs()), aa.z(oVar.heq().her()));
                h.INSTANCE.n(357, 57, 1);
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.SilkWriter", th, "Check out file dir error.", new Object[0]);
        }
        OutputStream outputStream = null;
        try {
            outputStream = s.dw(str, false);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SilkWriter", e2, "initWriter openWrite failed: %s", e2.getMessage());
            h.INSTANCE.n(357, 55, 1);
            if (d.KyR) {
                HashMap hashMap = new HashMap();
                hashMap.put(SharePluginInfo.ISSUE_KEY_STACK, e2.getMessage());
                h.INSTANCE.e("Record", "Write failed", hashMap);
            }
        }
        if (outputStream != null) {
            try {
                this.dBo = str;
                this.mFileOutputStream = outputStream;
                this.dBu = false;
                int aon = m.aon();
                if ((aon & 1024) != 0) {
                    this.dBv = 4;
                } else if ((aon & 512) != 0) {
                    this.dBv = 2;
                } else {
                    Log.e("MicroMsg.SilkWriter", "initWriter cpuType error! silk don't support arm_v5!!!!");
                    AppMethodBeat.o(130016);
                    return false;
                }
                this.dBx = new i(this.mSampleRate, this.dBr, this.dBv);
                if (0 == this.dBx.juy) {
                    Log.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error");
                    this.dBx = null;
                    AppMethodBeat.o(130016);
                    return false;
                }
                this.dBq = new byte[(((this.mSampleRate * 20) * 2) / 1000)];
                int i2 = -1;
                if (MMApplicationContext.isMainProcess()) {
                    com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100279");
                    if (Fu.isValid()) {
                        i2 = Util.getInt(Fu.gzz().get("isVoiceMsgOptOpen"), 0);
                    }
                }
                if (1 == i2) {
                    this.dBw = true;
                }
                if (i2 == 0) {
                    this.dBw = false;
                }
                if (this.dBw) {
                    if (this.dBx != null) {
                        this.dBx.dC(200, 1);
                    }
                    Log.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
                } else {
                    if (this.dBx != null) {
                        this.dBx.dC(200, 0);
                    }
                    Log.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
                }
                AppMethodBeat.o(130016);
                return true;
            } catch (Exception e3) {
                Log.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", e3.getMessage());
                AppMethodBeat.o(130016);
                return false;
            }
        } else {
            AppMethodBeat.o(130016);
            return false;
        }
    }

    @Override // com.tencent.mm.audio.e.a
    public final void abP() {
        AppMethodBeat.i(130017);
        Log.i("MicroMsg.SilkWriter", "waitStop");
        synchronized (this) {
            try {
                this.dBn = true;
            } catch (Throwable th) {
                AppMethodBeat.o(130017);
                throw th;
            }
        }
        if (this.dBt != null) {
            try {
                this.dBt.abT();
            } catch (InterruptedException e2) {
                Log.e("MicroMsg.SilkWriter", "exception:%s", Util.stackTraceToString(e2));
            } catch (ExecutionException e3) {
                Log.e("MicroMsg.SilkWriter", "exception:%s", Util.stackTraceToString(e3));
            }
        }
        abR();
        AppMethodBeat.o(130017);
    }

    private void abR() {
        AppMethodBeat.i(130018);
        synchronized (this.dBs) {
            try {
                if (this.dBx != null) {
                    MediaRecorder.SilkEncUnInit(this.dBx.juy);
                }
            } finally {
                AppMethodBeat.o(130018);
            }
        }
        Log.i("MicroMsg.SilkWriter", "finish Thread file:" + this.dBo);
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                Log.e("MicroMsg.SilkWriter", "close silk file:" + this.dBo + "msg:" + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    @Override // com.tencent.mm.audio.e.a
    public final boolean abQ() {
        AppMethodBeat.i(130019);
        Log.i("MicroMsg.SilkWriter", "resetWriter");
        synchronized (this.dBs) {
            try {
                if (this.dBx != null) {
                    MediaRecorder.SilkEncUnInit(this.dBx.juy);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(130019);
                throw th;
            }
        }
        this.dBx = new i(this.mSampleRate, this.dBr, this.dBv);
        if (0 == this.dBx.juy) {
            Log.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error");
            this.dBx = null;
            AppMethodBeat.o(130019);
            return false;
        }
        AppMethodBeat.o(130019);
        return true;
    }

    @Override // com.tencent.mm.audio.e.a
    public final int a(g.a aVar) {
        AppMethodBeat.i(130020);
        int a2 = a(aVar, 0, false);
        AppMethodBeat.o(130020);
        return a2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:121:0x006f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [short, int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    @Override // com.tencent.mm.audio.e.a
    public final int a(g.a aVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(130021);
        f.a aVar2 = new f.a();
        int i6 = (short) (((this.mSampleRate * 20) * 2) / 1000);
        int i7 = this.dBp + aVar.dAc;
        byte[] bArr = new byte[i6];
        byte[] bArr2 = new byte[((this.dBw ? 6 : 1) * i6)];
        boolean z2 = true;
        if (MMApplicationContext.isMainProcess()) {
            String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("VoiceNoiseSuppression");
            if (!Util.isNullOrNil(value)) {
                z2 = Util.getInt(value, 1) == 1;
            }
        }
        if (z) {
            z2 = false;
        }
        Log.d("MicroMsg.SilkWriter", "noise suppression: %b", Boolean.valueOf(z2));
        int i8 = 0;
        int i9 = 0;
        while (i7 >= i6) {
            if (this.dBp > 0) {
                try {
                    System.arraycopy(this.dBq, 0, bArr, 0, this.dBp);
                    byte[] bArr3 = aVar.buf;
                    int i10 = this.dBp;
                    System.arraycopy(bArr3, 0, bArr, i10, i6 - i10);
                    i3 = (i6 - this.dBp) + i9;
                    this.dBp = 0;
                } catch (Exception e2) {
                    Log.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, leftBufSize:%d copySize:%d error:%s", Integer.valueOf(this.dBp), Integer.valueOf(i6 - this.dBp), e2.getMessage());
                    AppMethodBeat.o(130021);
                    return -1;
                }
            } else {
                try {
                    System.arraycopy(aVar.buf, i9, bArr, 0, i6);
                    i3 = i9 + i6;
                } catch (Exception e3) {
                    Log.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d framelen:%d error:%s", Integer.valueOf(i9), Short.valueOf((short) i6), e3.getMessage());
                    AppMethodBeat.o(130021);
                    return -1;
                }
            }
            int i11 = i7 - i6;
            short[] sArr = new short[1];
            synchronized (this.dBs) {
                try {
                    if (this.dBw) {
                        if (i11 < i6 && aVar.dAd) {
                            if (this.dBx != null) {
                                this.dBx.dC(201, 1);
                            }
                            Log.i("MicroMsg.SilkWriter", "silk do encode mark last frame");
                        } else if (this.dBx != null) {
                            this.dBx.dC(201, 0);
                        }
                    }
                    if (this.dBx != null) {
                        i4 = MediaRecorder.SilkDoEnc(bArr, i6, bArr2, sArr, z2, this.dBx.juy);
                    } else {
                        i4 = 0;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(130021);
                    throw th;
                }
            }
            boolean z3 = false;
            if (z && sArr[0] >= 10 && bArr2[0] == 2 && bArr2[1] == 35 && bArr2[2] == 33 && bArr2[3] == 83 && bArr2[4] == 73 && bArr2[5] == 76 && bArr2[6] == 75 && bArr2[7] == 95 && bArr2[8] == 86 && bArr2[9] == 51) {
                Log.i("MicroMsg.SilkWriter", "writeSilkFile deleteHead & bDeleteHead true");
                z3 = true;
            }
            if (i4 != 0) {
                this.dBp = 0;
                Log.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode failed, ret:%d", Integer.valueOf(i4));
                if (!this.dBu) {
                    h.INSTANCE.n(357, 56, 1);
                    this.dBu = true;
                    if (d.KyR) {
                        h.INSTANCE.e("Record", "Encode failed", null);
                    }
                }
                AppMethodBeat.o(130021);
                return -1;
            }
            Log.v("MicroMsg.SilkWriter", "encoutdatalen: %s, framelen: %s, lastframe: %s, byteBuf.len: %s", Short.valueOf(sArr[0]), Short.valueOf((short) i6), Boolean.valueOf(aVar.dAd), Integer.valueOf(aVar.dAc));
            try {
                if (sArr[0] >= bArr2.length || sArr[0] <= 0 || this.mFileOutputStream == null) {
                    i5 = i8 == 1 ? 1 : 0;
                } else if (!z || !z3) {
                    this.mFileOutputStream.write(bArr2, 0, sArr[0]);
                    i5 = sArr[0] + i8;
                } else {
                    Log.i("MicroMsg.SilkWriter", "writeSilkFile bDeleteHead copyOfRange");
                    this.mFileOutputStream.write(Arrays.copyOfRange(bArr2, 1, bArr2.length), 0, sArr[0] - 1);
                    i8 += sArr[0] - 1;
                    i9 = i3;
                    i7 = i11;
                }
                i8 = i5;
                i9 = i3;
                i7 = i11;
            } catch (IOException e4) {
                Log.e("MicroMsg.SilkWriter", "writeSilkFile Write File Error file:%s", this.dBo);
                AppMethodBeat.o(130021);
                return -1;
            }
        }
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.flush();
            } catch (IOException e5) {
                Log.e("MicroMsg.SilkWriter", "writeSilkFile flush File Error file:%s", this.dBo);
                AppMethodBeat.o(130021);
                return -1;
            }
        }
        try {
            System.arraycopy(aVar.buf, i9, this.dBq, this.dBp, i7);
            this.dBp += i7;
            long apr = aVar2.apr();
            if (i2 == 1) {
                a.C0273a aVar3 = dBy;
                aVar3.dBj = ((aVar3.dBj * ((long) aVar3.count)) + apr) / ((long) (aVar3.count + 1));
                aVar3.count++;
            }
            Log.d("MicroMsg.SilkWriter", "writeSilkFile append2silkfile silkTime:" + apr + " useFloat:" + i2 + " avg:" + dBy.dBj + " cnt:" + dBy.count);
            AppMethodBeat.o(130021);
            return i8 == 1 ? 1 : 0;
        } catch (Exception e6) {
            Log.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d leftBufSize:%d leftSize:%d error:%s", Integer.valueOf(i9), Integer.valueOf(this.dBp), Integer.valueOf(i7), e6.getMessage());
            AppMethodBeat.o(130021);
            return -1;
        }
    }

    static {
        AppMethodBeat.i(130022);
        AppMethodBeat.o(130022);
    }

    public final class a implements e, com.tencent.f.i.h {
        private Future<?> dBz;

        private a() {
        }

        public /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final void run() {
            boolean z;
            int i2;
            AppMethodBeat.i(130014);
            Log.i("MicroMsg.SilkWriter", "Silk Thread start run");
            while (true) {
                synchronized (c.this) {
                    try {
                        z = c.this.dBn;
                    } finally {
                        AppMethodBeat.o(130014);
                    }
                }
                Log.d("MicroMsg.SilkWriter", "ThreadSilk in :" + z + " cnt :" + c.this.dBm.size());
                if (!z || !c.this.dBm.isEmpty()) {
                    try {
                        g.a aVar = (g.a) c.this.dBm.poll(200, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            Log.i("MicroMsg.SilkWriter", "poll byte null file:" + c.this.dBo);
                        } else {
                            int size = c.this.dBm.size();
                            if (size > 10 || z) {
                                Log.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + size + " stop:" + z);
                                i2 = 0;
                            } else if (size < 9) {
                                i2 = 1;
                            } else {
                                i2 = 1;
                            }
                            if (c.dBy.count >= 10 && c.dBy.dBj > 240) {
                                i2 = 0;
                            }
                            c.this.a(aVar, i2, false);
                        }
                    } catch (InterruptedException e2) {
                        Log.i("MicroMsg.SilkWriter", "ThreadAmr poll null");
                    }
                } else {
                    return;
                }
            }
        }

        @Override // com.tencent.f.i.e
        public final void a(Future<?> future) {
            this.dBz = future;
        }

        public final void abT() {
            AppMethodBeat.i(184404);
            if (this.dBz != null) {
                this.dBz.get();
            }
            AppMethodBeat.o(184404);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "SilkWriter_run";
        }
    }
}
