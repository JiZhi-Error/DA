package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j {
    public static int dAR = 100;
    private b dAO = new b(MMApplicationContext.getContext());
    public b dAP = new b(c.a.AMR);
    public a dAQ = null;
    String fileName = "";
    public int status = 0;

    public interface a {
        void onError();
    }

    public j() {
        AppMethodBeat.i(148365);
        AppMethodBeat.o(148365);
    }

    public final boolean hy(String str) {
        AppMethodBeat.i(148366);
        f.a aVar = new f.a();
        if (this.fileName.length() > 0) {
            Log.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            AppMethodBeat.o(148366);
            return false;
        }
        this.fileName = str;
        try {
            this.dAO.requestFocus();
            this.dAP.a(new b.a() {
                /* class com.tencent.mm.audio.b.j.AnonymousClass1 */

                @Override // com.tencent.mm.audio.b.b.a
                public final void onError() {
                    AppMethodBeat.i(148364);
                    j.this.dAO.apm();
                    if (j.this.dAQ != null) {
                        j.this.dAQ.onError();
                    }
                    try {
                        j.this.dAP.release();
                        j.this.status = -1;
                        AppMethodBeat.o(148364);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + j.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                        AppMethodBeat.o(148364);
                    }
                }
            });
            this.dAP.aac();
            this.dAP.aad();
            this.dAP.aab();
            this.dAP.setOutputFile(this.fileName);
            this.dAP.setMaxDuration(3600010);
            this.dAP.prepare();
            this.dAP.start();
            Log.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + aVar.apr());
            this.status = 1;
            AppMethodBeat.o(148366);
            return true;
        } catch (Exception e2) {
            this.dAO.apm();
            Log.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e2.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.o(148366);
            return false;
        }
    }

    public final boolean ZZ() {
        AppMethodBeat.i(148367);
        this.dAO.apm();
        if (this.dAP == null) {
            AppMethodBeat.o(148367);
            return true;
        }
        try {
            this.dAP.Qt();
            this.dAP.release();
            this.fileName = "";
            this.status = 0;
            AppMethodBeat.o(148367);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e2.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.o(148367);
            return false;
        }
    }
}
