package com.tencent.mm.audio.e;

import com.tencent.f.i.e;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class d implements a {
    private com.tencent.qqpinyin.voicerecoapi.a dBB;
    private a dBC;
    BlockingQueue<g.a> dBm = new ArrayBlockingQueue(1024);
    boolean dBn = false;
    String dBo;
    private OutputStream mFileOutputStream;

    public d() {
        AppMethodBeat.i(130024);
        AppMethodBeat.o(130024);
    }

    @Override // com.tencent.mm.audio.e.a
    public final boolean hz(String str) {
        AppMethodBeat.i(130025);
        Log.i("MicroMsg.SpeexWriter", "initWriter, path: ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(130025);
            return false;
        }
        this.dBo = str;
        try {
            this.mFileOutputStream = s.dw(str, false);
            this.dBB = new com.tencent.qqpinyin.voicerecoapi.a();
            int hkr = this.dBB.hkr();
            if (hkr != 0) {
                Log.e("MicroMsg.SpeexWriter", "speexInit failed: ".concat(String.valueOf(hkr)));
                AppMethodBeat.o(130025);
                return false;
            }
            AppMethodBeat.o(130025);
            return true;
        } catch (Exception e2) {
            if (this.mFileOutputStream != null) {
                try {
                    this.mFileOutputStream.close();
                } catch (IOException e3) {
                }
            }
            Log.e("MicroMsg.SpeexWriter", "Error on init file: ", e2);
            AppMethodBeat.o(130025);
            return false;
        }
    }

    @Override // com.tencent.mm.audio.e.a
    public final int a(g.a aVar) {
        AppMethodBeat.i(130026);
        int a2 = a(aVar, 0, false);
        AppMethodBeat.o(130026);
        return a2;
    }

    @Override // com.tencent.mm.audio.e.a
    public final int a(g.a aVar, int i2, boolean z) {
        int i3 = -1;
        AppMethodBeat.i(130027);
        if (this.dBB == null || aVar.buf == null || aVar.dAc == 0) {
            Log.e("MicroMsg.SpeexWriter", "try write invalid data to file");
            AppMethodBeat.o(130027);
        } else {
            try {
                byte[] ah = this.dBB.ah(aVar.buf, aVar.dAc);
                if (ah == null || ah.length <= 0) {
                    Log.e("MicroMsg.SpeexWriter", "convert failed: " + (ah == null ? "outBuffer is null" : "size is zero"));
                    AppMethodBeat.o(130027);
                } else {
                    Log.d("MicroMsg.SpeexWriter", "write to file, len: %d", Integer.valueOf(ah.length));
                    this.mFileOutputStream.write(ah);
                    this.mFileOutputStream.flush();
                    i3 = ah.length;
                    AppMethodBeat.o(130027);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SpeexWriter", "write to file failed", e2);
                AppMethodBeat.o(130027);
            }
        }
        return i3;
    }

    @Override // com.tencent.mm.audio.e.a
    public final void abP() {
        AppMethodBeat.i(130028);
        Log.i("MicroMsg.SpeexWriter", "wait Stop");
        synchronized (this) {
            try {
                this.dBn = true;
            } finally {
                AppMethodBeat.o(130028);
            }
        }
        if (this.dBC != null) {
            try {
                a aVar = this.dBC;
                if (aVar.dBz != null) {
                    aVar.dBz.get();
                }
                this.dBC = null;
            } catch (InterruptedException e2) {
                Log.e("MicroMsg.SpeexWriter", "thread speex interrupted");
            } catch (ExecutionException e3) {
                Log.e("MicroMsg.SpeexWriter", "ExecutionException:%s", e3.toString());
            }
        }
        if (this.dBB != null) {
            this.dBB.hks();
            this.dBB = null;
        }
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e4) {
                Log.e("MicroMsg.SpeexWriter", "close silk file: " + this.dBo + "msg: " + e4.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    @Override // com.tencent.mm.audio.e.a
    public final boolean abQ() {
        AppMethodBeat.i(130029);
        if (this.dBB != null) {
            this.dBB.hks();
            this.dBB = null;
        }
        this.dBB = new com.tencent.qqpinyin.voicerecoapi.a();
        int hkr = this.dBB.hkr();
        if (hkr != 0) {
            Log.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: ".concat(String.valueOf(hkr)));
            AppMethodBeat.o(130029);
            return false;
        }
        AppMethodBeat.o(130029);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final class a implements e, h {
        final /* synthetic */ d dBD;
        Future<?> dBz;

        public final void run() {
            boolean z;
            AppMethodBeat.i(130023);
            while (true) {
                synchronized (this.dBD) {
                    try {
                        z = this.dBD.dBn;
                    } finally {
                        AppMethodBeat.o(130023);
                    }
                }
                Log.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + z + " queueLen: " + this.dBD.dBm.size());
                if (!z || !this.dBD.dBm.isEmpty()) {
                    try {
                        g.a poll = this.dBD.dBm.poll(200, TimeUnit.MILLISECONDS);
                        if (poll == null) {
                            Log.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.dBD.dBo);
                        } else {
                            this.dBD.a(poll, 0, false);
                        }
                    } catch (InterruptedException e2) {
                        Log.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
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

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "SpeexWriter_run";
        }
    }

    public static boolean U(String str, String str2) {
        AppMethodBeat.i(130030);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
            AppMethodBeat.o(130030);
            return false;
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            Log.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
            AppMethodBeat.o(130030);
            return false;
        }
        Log.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + oVar.length());
        try {
            com.tencent.qqpinyin.voicerecoapi.a aVar = new com.tencent.qqpinyin.voicerecoapi.a();
            if (aVar.hkr() != 0) {
                Log.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
                aVar.hks();
                AppMethodBeat.o(130030);
                return false;
            }
            s.deleteFile(str2);
            new o(str2).createNewFile();
            InputStream inputStream = null;
            try {
                byte[] bArr = new byte[4096];
                InputStream openRead = s.openRead(str);
                while (true) {
                    int read = openRead.read(bArr);
                    if (read > 0) {
                        byte[] ah = aVar.ah(bArr, read);
                        if (ah == null) {
                            openRead.close();
                            AppMethodBeat.o(130030);
                            return false;
                        }
                        Log.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + s.e(str2, ah, ah.length) + ", readLen = " + read);
                    } else {
                        openRead.close();
                        aVar.hks();
                        Log.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(130030);
                        return true;
                    }
                }
            } catch (Exception e2) {
                if (0 != 0) {
                    inputStream.close();
                }
                aVar.hks();
                AppMethodBeat.o(130030);
                return false;
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + e3.getMessage());
            AppMethodBeat.o(130030);
            return false;
        }
    }
}
