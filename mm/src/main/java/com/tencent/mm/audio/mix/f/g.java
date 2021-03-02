package com.tencent.mm.audio.mix.f;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.a;
import com.tencent.mm.audio.mix.i.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class g {
    private static Object duI = new Object();
    private static g dwR;
    private String duF;
    private boolean dwS = true;
    private boolean isInit = false;
    private FileOutputStream outputStream;

    static {
        AppMethodBeat.i(136876);
        AppMethodBeat.o(136876);
    }

    private static g ZE() {
        AppMethodBeat.i(136872);
        if (dwR == null) {
            synchronized (duI) {
                try {
                    if (dwR == null) {
                        dwR = new g();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(136872);
                    throw th;
                }
            }
        }
        g gVar = dwR;
        AppMethodBeat.o(136872);
        return gVar;
    }

    private static String ZF() {
        AppMethodBeat.i(136873);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = file + File.separator + "mix_audio_pcm.pcm";
        AppMethodBeat.o(136873);
        return str;
    }

    public static void ZG() {
        AppMethodBeat.i(136874);
        new File(ZF()).delete();
        g ZE = ZE();
        if (ZE.isInit) {
            b.i("MicroMsg.Mix.ExportMixAudioPcmFile", "finishProcess");
            try {
                if (ZE.outputStream != null) {
                    ZE.outputStream.flush();
                    ZE.outputStream.close();
                    ZE.outputStream = null;
                }
            } catch (Exception e2) {
                b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", e2, "finishProcess", new Object[0]);
            }
            ZE.isInit = false;
        }
        AppMethodBeat.o(136874);
    }

    private g() {
        AppMethodBeat.i(136875);
        if (!this.isInit) {
            this.isInit = true;
            this.duF = ZF();
            b.i("MicroMsg.Mix.ExportMixAudioPcmFile", "outFile:%s", this.duF);
            new File(this.duF).delete();
            try {
                this.outputStream = new FileOutputStream(a.ht(this.duF));
                AppMethodBeat.o(136875);
                return;
            } catch (FileNotFoundException e2) {
                b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", e2, "new FileOutputStream", new Object[0]);
                AppMethodBeat.o(136875);
                return;
            } catch (Exception e3) {
                b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", e3, "new FileOutputStream", new Object[0]);
            }
        }
        AppMethodBeat.o(136875);
    }
}
