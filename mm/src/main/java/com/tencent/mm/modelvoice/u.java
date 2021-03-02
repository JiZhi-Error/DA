package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.Util;

public final class u implements d {
    String fileName;
    boolean juP;
    d.a juW;
    d.b juX;
    MediaPlayer jvF;
    b jvG;
    int status;

    @Override // com.tencent.mm.modelvoice.d
    public final int getStatus() {
        return this.status;
    }

    public u() {
        AppMethodBeat.i(130095);
        this.fileName = "";
        this.juW = null;
        this.juX = null;
        this.status = 0;
        this.juP = true;
        this.jvF = new k();
        bik();
        bil();
        Log.d("MicroMsg.VoicePlayer", "VoicePlayer");
        AppMethodBeat.o(130095);
    }

    public u(Context context) {
        this();
        AppMethodBeat.i(130096);
        this.jvG = new b(context);
        Log.d("MicroMsg.VoicePlayer", "VoicePlayer context");
        AppMethodBeat.o(130096);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void a(d.a aVar) {
        this.juW = aVar;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void a(d.b bVar) {
        this.juX = bVar;
    }

    private void bik() {
        AppMethodBeat.i(130097);
        this.jvF.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.modelvoice.u.AnonymousClass1 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(130093);
                Log.d("MicroMsg.VoicePlayer", "OnCompletionListener");
                if (u.this.jvG != null && u.this.juP) {
                    Log.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
                    u.this.jvG.apm();
                }
                if (u.this.juW != null) {
                    Log.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
                    u.this.juW.onCompletion();
                }
                try {
                    Log.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
                    u.this.jvF.reset();
                    u.this.jvF.release();
                    u.this.status = 0;
                    AppMethodBeat.o(130093);
                } catch (Exception e2) {
                    Log.e("MicroMsg.VoicePlayer", "setCompletion File[" + u.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                    AppMethodBeat.o(130093);
                }
            }
        });
        AppMethodBeat.o(130097);
    }

    private void bil() {
        AppMethodBeat.i(130098);
        this.jvF.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.modelvoice.u.AnonymousClass2 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(130094);
                Log.d("MicroMsg.VoicePlayer", "OnErrorListener");
                if (u.this.jvG != null && u.this.juP) {
                    Log.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
                    u.this.jvG.apm();
                }
                if (u.this.juX != null) {
                    Log.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
                    u.this.juX.onError();
                }
                try {
                    Log.d("MicroMsg.VoicePlayer", "OnErrorListener release");
                    u.this.jvF.reset();
                    u.this.jvF.release();
                    u.this.status = -1;
                } catch (Exception e2) {
                    Log.e("MicroMsg.VoicePlayer", "setErrorListener File[" + u.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                }
                AppMethodBeat.o(130094);
                return false;
            }
        });
        AppMethodBeat.o(130098);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void cU(boolean z) {
        AppMethodBeat.i(130099);
        Log.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(z)));
        if (this.jvF == null) {
            AppMethodBeat.o(130099);
        } else if (PhoneStatusWatcher.isCalling()) {
            Log.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
            AppMethodBeat.o(130099);
        } else {
            int currentPosition = this.jvF.getCurrentPosition();
            Qt();
            this.jvF = new k();
            bik();
            bil();
            d(this.fileName, z, currentPosition);
            AppMethodBeat.o(130099);
        }
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean c(String str, boolean z, int i2) {
        AppMethodBeat.i(130101);
        boolean d2 = d(str, z, i2);
        AppMethodBeat.o(130101);
        return d2;
    }

    private boolean d(String str, boolean z, int i2) {
        AppMethodBeat.i(130102);
        if (this.status != 0) {
            Log.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
            AppMethodBeat.o(130102);
            return false;
        }
        Log.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", Boolean.valueOf(z), Integer.valueOf(i2));
        this.fileName = str;
        try {
            k(z, i2);
        } catch (Exception e2) {
            try {
                k(true, i2);
            } catch (Exception e3) {
                Log.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
                Log.e("MicroMsg.VoicePlayer", "exception:%s", Util.stackTraceToString(e2));
                this.status = -1;
                AppMethodBeat.o(130102);
                return false;
            }
        }
        this.status = 1;
        AppMethodBeat.o(130102);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        if (com.tencent.mm.compatible.deviceinfo.ae.gKu.gDH == 1) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(boolean r11, int r12) {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.u.k(boolean, int):void");
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean da(boolean z) {
        AppMethodBeat.i(130104);
        if (this.status != 1) {
            Log.e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
            AppMethodBeat.o(130104);
            return false;
        }
        try {
            Log.d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
            this.jvF.pause();
            if (this.jvG != null && z && this.juP) {
                Log.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
                this.jvG.apm();
            }
            this.status = 2;
            AppMethodBeat.o(130104);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.VoicePlayer", "pause File[" + this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
            this.status = -1;
            if (this.jvG != null && z && this.juP) {
                Log.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
                this.jvG.apm();
            }
            AppMethodBeat.o(130104);
            return false;
        } catch (Throwable th) {
            if (this.jvG != null && z && this.juP) {
                Log.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
                this.jvG.apm();
            }
            AppMethodBeat.o(130104);
            throw th;
        }
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean resume() {
        AppMethodBeat.i(130105);
        if (this.status != 2) {
            Log.e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
            AppMethodBeat.o(130105);
            return false;
        }
        try {
            Log.d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
            this.jvF.start();
            if (this.jvG != null && this.juP) {
                Log.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
                this.jvG.requestFocus();
            }
            this.status = 1;
            AppMethodBeat.o(130105);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.VoicePlayer", "resume File[" + this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
            this.status = -1;
            if (this.jvG != null && this.juP) {
                Log.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
                this.jvG.requestFocus();
            }
            AppMethodBeat.o(130105);
            return false;
        } catch (Throwable th) {
            if (this.jvG != null && this.juP) {
                Log.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
                this.jvG.requestFocus();
            }
            AppMethodBeat.o(130105);
            throw th;
        }
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean isPlaying() {
        return this.status == 1;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean Qt() {
        AppMethodBeat.i(130106);
        if (this.status == 1 || this.status == 2) {
            try {
                Log.d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
                this.jvF.stop();
                this.jvF.release();
                if (this.jvG != null && this.juP) {
                    Log.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
                    this.jvG.apm();
                }
                this.status = 0;
                AppMethodBeat.o(130106);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.VoicePlayer", "stop File[" + this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                this.status = -1;
                if (this.jvG != null && this.juP) {
                    Log.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
                    this.jvG.apm();
                }
                AppMethodBeat.o(130106);
                return false;
            } catch (Throwable th) {
                if (this.jvG != null && this.juP) {
                    Log.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
                    this.jvG.apm();
                }
                AppMethodBeat.o(130106);
                throw th;
            }
        } else {
            Log.e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
            AppMethodBeat.o(130106);
            return false;
        }
    }

    @Override // com.tencent.mm.modelvoice.d
    public final double ZY() {
        AppMethodBeat.i(130107);
        if (this.status == 1 || this.status == 2) {
            try {
                int currentPosition = this.jvF.getCurrentPosition();
                int duration = this.jvF.getDuration();
                if (duration == 0) {
                    Log.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
                    AppMethodBeat.o(130107);
                    return 0.0d;
                }
                double d2 = ((double) currentPosition) / ((double) duration);
                AppMethodBeat.o(130107);
                return d2;
            } catch (Exception e2) {
                Log.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                Qt();
                AppMethodBeat.o(130107);
                return 0.0d;
            }
        } else {
            AppMethodBeat.o(130107);
            return 0.0d;
        }
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void c(b.a aVar) {
        AppMethodBeat.i(130108);
        if (!(this.jvG == null || aVar == null)) {
            this.jvG.a(aVar);
        }
        AppMethodBeat.o(130108);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void bhQ() {
        this.juP = false;
    }
}
