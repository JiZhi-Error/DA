package com.tencent.mm.plugin.flash.b;

import android.content.Intent;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.service.FaceUploadVideoService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class d {
    protected String mAppId;
    long startTimeMs = 0;
    int type = -1;
    protected boolean wIl = false;
    Intent wIw;
    private boolean wIx = false;
    private Camera.Parameters wIy;

    public final void e(Intent intent, int i2) {
        AppMethodBeat.i(186642);
        this.wIl = intent.getBooleanExtra("needVideo", false);
        a.cTF().sUx = this.wIl;
        this.mAppId = intent.getStringExtra("appId");
        this.type = i2;
        if (i2 == 0) {
            this.wIx = true;
        }
        Log.i("MicroMsg.FaceFlashManagerRecorder", "needVideo %s,mAppId %s acceptVoiceFromOutSide:%s", Boolean.valueOf(this.wIl), this.mAppId, Boolean.valueOf(this.wIx));
        AppMethodBeat.o(186642);
    }

    public final void b(Camera.Parameters parameters) {
        AppMethodBeat.i(186643);
        if (this.wIl) {
            try {
                this.wIy = parameters;
                int i2 = parameters.getInt("rotation");
                String[] split = parameters.get("preview-size").split("x");
                a.cTF().a(i2, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[0]), Integer.parseInt(split[1]), this.wIx);
                AppMethodBeat.o(186643);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(186643);
    }

    public final boolean dLe() {
        return this.wIl;
    }

    public final void bFT() {
        AppMethodBeat.i(186644);
        if (this.wIl && !a.cTF().isStarted()) {
            a.cTF().aai();
            this.startTimeMs = Util.currentTicks();
        }
        AppMethodBeat.o(186644);
    }

    public final void GA(final long j2) {
        AppMethodBeat.i(186645);
        if (this.wIl && a.cTF().isStarted()) {
            a.cTF().a(new a.b() {
                /* class com.tencent.mm.plugin.flash.b.d.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.facedetect.e.a.b
                public final void arD(String str) {
                    AppMethodBeat.i(186641);
                    Log.i("MicroMsg.FaceFlashManagerRecorder", "hy: video release done. using: %d ms. file path: %s", Long.valueOf(Util.ticksToNow(d.this.startTimeMs)), str);
                    if (!Util.isNullOrNil(str) || !s.YS(str)) {
                        d.this.wIw = new Intent(MMApplicationContext.getContext(), FaceUploadVideoService.class);
                        d.this.wIw.putExtra("key_video_file_name", str);
                        d.this.wIw.putExtra("k_bio_id", j2);
                        d.this.wIw.putExtra("key_face_type", d.this.type);
                        d.this.wIw.putExtra("key_app_id", d.this.mAppId);
                        AppMethodBeat.o(186641);
                        return;
                    }
                    AppMethodBeat.o(186641);
                }
            });
        }
        AppMethodBeat.o(186645);
    }

    public final void aQf() {
        AppMethodBeat.i(186646);
        if (this.wIl && this.wIy != null) {
            Log.i("MicroMsg.FaceFlashManagerRecorder", "resetRecord");
            if (this.wIl && a.cTF().isStarted()) {
                a.cTF().cTH();
            }
            b(this.wIy);
        }
        AppMethodBeat.o(186646);
    }

    public final void dLf() {
        AppMethodBeat.i(186647);
        if (this.wIw != null) {
            Log.i("MicroMsg.FaceFlashManagerRecorder", "sendRequestUploadVideo");
            c.startService(this.wIw);
            this.wIw = null;
        }
        AppMethodBeat.o(186647);
    }
}
