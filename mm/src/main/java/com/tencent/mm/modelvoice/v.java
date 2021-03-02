package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v implements a {
    private static int dAR = 100;
    private b dAP;
    String fileName = "";
    private m.a jvI = null;
    private int status = 0;

    @Override // com.tencent.mm.audio.b.a
    public final int getStatus() {
        return this.status;
    }

    @Override // com.tencent.mm.audio.b.a
    public final int aaa() {
        b bVar = this.dAP;
        if ((bVar.dyJ == c.a.PCM || bVar.dyJ == c.a.SILK) && bVar.dyI != null) {
            return bVar.dyI.dzA;
        }
        return 1;
    }

    @Override // com.tencent.mm.audio.b.a
    public final void a(m.a aVar) {
        this.jvI = aVar;
    }

    public v(c.a aVar) {
        AppMethodBeat.i(148500);
        this.dAP = new b(aVar);
        AppMethodBeat.o(148500);
    }

    @Override // com.tencent.mm.audio.b.a
    public final boolean hw(String str) {
        AppMethodBeat.i(148501);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(Util.isNullOrNil(str) ? 0 : str.length());
        Log.i("VoiceRecorder", "[startRecord] fileName:%s size:%s", objArr);
        f.a aVar = new f.a();
        if (Util.isNullOrNil(this.fileName) || this.fileName.length() <= 0) {
            this.fileName = str;
            try {
                this.dAP.a(new b.a() {
                    /* class com.tencent.mm.modelvoice.v.AnonymousClass1 */

                    @Override // com.tencent.mm.audio.b.b.a
                    public final void onError() {
                        AppMethodBeat.i(148499);
                        if (v.this.jvI != null) {
                            v.this.jvI.onError();
                        }
                        try {
                            v.this.dAP.release();
                            v.this.status = -1;
                            AppMethodBeat.o(148499);
                        } catch (Exception e2) {
                            Log.e("VoiceRecorder", "setErrorListener File[" + v.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                            AppMethodBeat.o(148499);
                        }
                    }
                });
                this.dAP.aac();
                this.dAP.aad();
                this.dAP.aab();
                this.dAP.setOutputFile(this.fileName);
                this.dAP.setMaxDuration(70000);
                this.dAP.prepare();
                this.dAP.start();
                Log.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + aVar.apr());
                this.status = 1;
                AppMethodBeat.o(148501);
                return true;
            } catch (Exception e2) {
                Log.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e2.getMessage() + "]");
                this.status = -1;
                AppMethodBeat.o(148501);
                return false;
            }
        } else {
            Log.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            AppMethodBeat.o(148501);
            return false;
        }
    }

    @Override // com.tencent.mm.audio.b.a
    public final boolean ZZ() {
        AppMethodBeat.i(148502);
        if (this.dAP == null) {
            AppMethodBeat.o(148502);
            return true;
        }
        try {
            this.dAP.Qt();
            this.dAP.release();
            this.fileName = "";
            this.status = 0;
            AppMethodBeat.o(148502);
            return true;
        } catch (Exception e2) {
            Log.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e2.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.o(148502);
            return false;
        }
    }

    @Override // com.tencent.mm.audio.b.a
    public final int getMaxAmplitude() {
        AppMethodBeat.i(148503);
        if (this.status == 1) {
            int maxAmplitude = this.dAP.getMaxAmplitude();
            if (maxAmplitude > dAR) {
                dAR = maxAmplitude;
            }
            int i2 = (maxAmplitude * 100) / dAR;
            AppMethodBeat.o(148503);
            return i2;
        }
        AppMethodBeat.o(148503);
        return 0;
    }
}
