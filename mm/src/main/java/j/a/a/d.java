package j.a.a;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.ExportErrorStatus;
import java.io.IOException;

public final class d extends b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
    private String UpK;
    private boolean UpL;
    private boolean UpM;
    private c UpN = c.RELEASE;
    private String UpO = "speakers";
    private int UpP = -1;
    private a UpQ;
    private boolean bcY = false;
    private boolean bfW = false;
    private MediaPlayer goA;
    private double iJG = 1.0d;
    private float rate = 1.0f;
    private boolean released = true;
    private String url;

    d(a aVar, String str) {
        this.UpQ = aVar;
        this.UpK = str;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void a(String str, boolean z, Context context) {
        boolean z2 = false;
        AppMethodBeat.i(204512);
        if (!objectEquals(this.url, str)) {
            this.url = str;
            if (this.released) {
                this.goA = mc(context);
                this.released = false;
            } else if (this.bcY) {
                this.goA.reset();
                this.bcY = false;
            }
            setSource(str);
            this.goA.setVolume((float) this.iJG, (float) this.iJG);
            MediaPlayer mediaPlayer = this.goA;
            if (this.UpN == c.LOOP) {
                z2 = true;
            }
            mediaPlayer.setLooping(z2);
            this.goA.prepareAsync();
        }
        AppMethodBeat.o(204512);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void u(double d2) {
        AppMethodBeat.i(204513);
        if (this.iJG != d2) {
            this.iJG = d2;
            if (!this.released) {
                this.goA.setVolume((float) d2, (float) d2);
            }
        }
        AppMethodBeat.o(204513);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void p(String str, Context context) {
        int i2;
        AppMethodBeat.i(204514);
        if (!objectEquals(this.UpO, str)) {
            boolean z = this.bfW;
            if (z) {
                pause();
            }
            this.UpO = str;
            if (this.goA != null) {
                i2 = this.goA.getCurrentPosition();
            } else {
                i2 = 0;
            }
            this.released = false;
            this.goA = mc(context);
            setSource(this.url);
            try {
                this.goA.prepare();
                seek(i2);
                if (z) {
                    this.bfW = true;
                    this.goA.start();
                }
            } catch (IOException e2) {
                RuntimeException runtimeException = new RuntimeException("Unable to access resource", e2);
                AppMethodBeat.o(204514);
                throw runtimeException;
            }
        }
        AppMethodBeat.o(204514);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final int P(double d2) {
        AppMethodBeat.i(204515);
        if (Build.VERSION.SDK_INT < 23) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("The method 'setRate' is available only on Android SDK version 23 or higher!");
            AppMethodBeat.o(204515);
            throw unsupportedOperationException;
        } else if (this.goA != null) {
            this.rate = (float) d2;
            this.goA.setPlaybackParams(this.goA.getPlaybackParams().setSpeed(this.rate));
            AppMethodBeat.o(204515);
            return 1;
        } else {
            AppMethodBeat.o(204515);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void a(boolean z, boolean z2, Context context) {
        AppMethodBeat.i(204516);
        if (this.UpL != z) {
            this.UpL = z;
            if (!this.released) {
                a(this.goA, context);
            }
        }
        if (this.UpM != z2) {
            this.UpM = z2;
            if (!this.released && this.UpM) {
                this.goA.setWakeMode(context, 1);
            }
        }
        AppMethodBeat.o(204516);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void a(c cVar) {
        AppMethodBeat.i(204517);
        if (this.UpN != cVar) {
            this.UpN = cVar;
            if (!this.released) {
                this.goA.setLooping(cVar == c.LOOP);
            }
        }
        AppMethodBeat.o(204517);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final int getDuration() {
        AppMethodBeat.i(204518);
        int duration = this.goA.getDuration();
        AppMethodBeat.o(204518);
        return duration;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final int getCurrentPosition() {
        AppMethodBeat.i(204519);
        int currentPosition = this.goA.getCurrentPosition();
        AppMethodBeat.o(204519);
        return currentPosition;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final String esX() {
        return this.UpK;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final boolean hRs() {
        return this.bfW && this.bcY;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void mb(Context context) {
        AppMethodBeat.i(204520);
        if (!this.bfW) {
            this.bfW = true;
            if (this.released) {
                this.released = false;
                this.goA = mc(context);
                setSource(this.url);
                this.goA.prepareAsync();
                AppMethodBeat.o(204520);
                return;
            } else if (this.bcY) {
                this.goA.start();
                this.UpQ.hRr();
            }
        }
        AppMethodBeat.o(204520);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void stop() {
        AppMethodBeat.i(204521);
        if (this.released) {
            AppMethodBeat.o(204521);
            return;
        }
        if (this.UpN == c.RELEASE) {
            release();
        } else if (this.bfW) {
            this.bfW = false;
            this.goA.pause();
            this.goA.seekTo(0);
            AppMethodBeat.o(204521);
            return;
        }
        AppMethodBeat.o(204521);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void release() {
        AppMethodBeat.i(204522);
        if (this.released) {
            AppMethodBeat.o(204522);
            return;
        }
        if (this.bfW) {
            this.goA.stop();
        }
        this.goA.reset();
        this.goA.release();
        this.goA = null;
        this.bcY = false;
        this.released = true;
        this.bfW = false;
        AppMethodBeat.o(204522);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void pause() {
        AppMethodBeat.i(204523);
        if (this.bfW) {
            this.bfW = false;
            this.goA.pause();
        }
        AppMethodBeat.o(204523);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void seek(int i2) {
        AppMethodBeat.i(204524);
        if (this.bcY) {
            this.goA.seekTo(i2);
            AppMethodBeat.o(204524);
            return;
        }
        this.UpP = i2;
        AppMethodBeat.o(204524);
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        AppMethodBeat.i(204525);
        this.bcY = true;
        this.UpQ.bbv.a("audio.onDuration", a.J(esX(), Integer.valueOf(getDuration())), null);
        if (this.bfW) {
            this.goA.start();
            this.UpQ.hRr();
        }
        if (this.UpP >= 0) {
            this.goA.seekTo(this.UpP);
            this.UpP = -1;
        }
        AppMethodBeat.o(204525);
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        AppMethodBeat.i(204526);
        if (this.UpN != c.LOOP) {
            stop();
        }
        this.UpQ.bbv.a("audio.onComplete", a.J(esX(), Boolean.TRUE), null);
        AppMethodBeat.o(204526);
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(204527);
        if (i2 == 100) {
            str = "MEDIA_ERROR_SERVER_DIED";
        } else {
            str = "MEDIA_ERROR_UNKNOWN {what:" + i2 + "}";
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                str2 = "MEDIA_ERROR_SYSTEM";
                str3 = str;
                break;
            case -1010:
                str2 = "MEDIA_ERROR_UNSUPPORTED";
                str3 = str;
                break;
            case -1007:
                str2 = "MEDIA_ERROR_MALFORMED";
                str3 = str;
                break;
            case -1004:
                str2 = "MEDIA_ERROR_IO";
                str3 = str;
                break;
            case ExportErrorStatus.APPEND_BUFFER:
                str2 = "MEDIA_ERROR_TIMED_OUT";
                str3 = str;
                break;
            default:
                String str4 = "MEDIA_ERROR_UNKNOWN {extra:" + i3 + "}";
                str2 = str4;
                str3 = str4;
                break;
        }
        this.UpQ.bbv.a("audio.onError", a.J(esX(), "MediaPlayer error with what:" + str3 + " extra:" + str2), null);
        AppMethodBeat.o(204527);
        return false;
    }

    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        this.UpQ.UpB = true;
    }

    private MediaPlayer mc(Context context) {
        AppMethodBeat.i(204528);
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnSeekCompleteListener(this);
        mediaPlayer.setOnErrorListener(this);
        a(mediaPlayer, context);
        mediaPlayer.setVolume((float) this.iJG, (float) this.iJG);
        mediaPlayer.setLooping(this.UpN == c.LOOP);
        AppMethodBeat.o(204528);
        return mediaPlayer;
    }

    private void setSource(String str) {
        AppMethodBeat.i(204529);
        try {
            this.goA.setDataSource(str);
            AppMethodBeat.o(204529);
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException("Unable to access resource", e2);
            AppMethodBeat.o(204529);
            throw runtimeException;
        }
    }

    private void a(MediaPlayer mediaPlayer, Context context) {
        AppMethodBeat.i(204530);
        if (Build.VERSION.SDK_INT >= 21) {
            if (objectEquals(this.UpO, "speakers")) {
                mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(this.UpL ? 6 : 1).setContentType(2).build());
                AppMethodBeat.o(204530);
                return;
            }
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(2).setContentType(2).build());
            if (context != null) {
                ((AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setSpeakerphoneOn(false);
                AppMethodBeat.o(204530);
                return;
            }
        } else if (objectEquals(this.UpO, "speakers")) {
            mediaPlayer.setAudioStreamType(this.UpL ? 2 : 3);
            AppMethodBeat.o(204530);
            return;
        } else {
            mediaPlayer.setAudioStreamType(0);
        }
        AppMethodBeat.o(204530);
    }
}
