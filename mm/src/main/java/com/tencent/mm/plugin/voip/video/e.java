package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.x;

public final class e {
    public MediaPlayer Hje;
    public int Hjf = 65536;
    public long Hjg;
    public long Hjh;
    a Hji;
    MMHandler hAk = new MMHandler(Looper.getMainLooper());
    public boolean isStarted = false;
    private b jvG;
    private AudioManager mAudioManager;
    public Context mContext;
    private Vibrator ooM;

    public e(Context context) {
        AppMethodBeat.i(115686);
        this.mContext = context;
        if (this.mContext != null) {
            this.mAudioManager = com.tencent.mm.plugin.audio.c.a.cea().audioManager;
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            this.ooM = (Vibrator) this.mContext.getSystemService("vibrator");
        }
        this.jvG = new b(MMApplicationContext.getContext());
        AppMethodBeat.o(115686);
    }

    public final void xw(boolean z) {
        int i2 = 3;
        AppMethodBeat.i(115687);
        Log.printInfoStack("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b, isSpeakerphoneOn: %s, mode: %s", Boolean.valueOf(z), Boolean.valueOf(this.mAudioManager.isSpeakerphoneOn()), Integer.valueOf(this.mAudioManager.getMode()));
        if (z) {
            i2 = 0;
        } else if (!d.oD(21)) {
            i2 = 2;
        }
        if (z && ae.gKu.gEn >= 0) {
            i2 = ae.gKu.gEn;
        } else if (!z && ae.gKu.gEl >= 0) {
            i2 = ae.gKu.gEl;
        }
        if (i2 != this.mAudioManager.getMode()) {
            Log.i("MicroMsg.RingPlayer", "set AudioManager mode: %s", Integer.valueOf(i2));
            com.tencent.mm.plugin.audio.c.a.cea().b(i2, (kotlin.g.a.a<x>) null);
        }
        if (z != this.mAudioManager.isSpeakerphoneOn()) {
            Log.i("MicroMsg.RingPlayer", "set AudioManager speakerphoneOn: %s", Boolean.valueOf(z));
            com.tencent.mm.plugin.audio.c.a.cea().jr(z);
        }
        AppMethodBeat.o(115687);
    }

    public final void stop() {
        AppMethodBeat.i(115688);
        Log.d("MicroMsg.RingPlayer", "stop, isStarted: %b", Boolean.valueOf(this.isStarted));
        fKW();
        if (this.Hje == null || !this.isStarted) {
            AppMethodBeat.o(115688);
            return;
        }
        try {
            this.Hje.stop();
            this.Hje.release();
            if (this.Hji != null) {
                this.hAk.removeCallbacks(this.Hji);
            }
            this.isStarted = false;
            com.tencent.mm.plugin.audio.c.a.cdV();
            AppMethodBeat.o(115688);
        } catch (Exception e2) {
            Log.e("MicroMsg.RingPlayer", e2.toString());
            AppMethodBeat.o(115688);
        }
    }

    public final boolean YZ() {
        return !this.isStarted;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030 A[Catch:{ Exception -> 0x02c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F(int r13, int r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 720
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.e.F(int, int, boolean):void");
    }

    public final void a(final int i2, final long j2, final boolean z, final int i3) {
        AppMethodBeat.i(115690);
        this.Hjg = System.currentTimeMillis();
        this.Hje = new k();
        try {
            this.Hje.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + FilePathGenerator.ANDROID_DIR_SEP + i2));
            this.Hje.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                /* class com.tencent.mm.plugin.voip.video.e.AnonymousClass3 */

                public final void onCompletion(MediaPlayer mediaPlayer) {
                    AppMethodBeat.i(115679);
                    if (System.currentTimeMillis() - e.this.Hjg > 70000) {
                        e.this.Hjf = 4;
                    }
                    if (e.this.isStarted) {
                        e.this.Hji = new a(i2, j2, z, i3);
                        e.this.hAk.postDelayed(e.this.Hji, j2);
                    }
                    AppMethodBeat.o(115679);
                }
            });
            this.Hje.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                /* class com.tencent.mm.plugin.voip.video.e.AnonymousClass4 */

                public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                    AppMethodBeat.i(115680);
                    e.this.Hjf = 1;
                    Log.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i2 + ":extra:" + i3);
                    AppMethodBeat.o(115680);
                    return false;
                }
            });
            this.Hje.setAudioStreamType(i3);
            if (z) {
                this.Hje.setVolume(0.6f, 0.6f);
            } else {
                fKV();
            }
            this.Hje.setLooping(false);
            this.Hje.prepare();
            this.Hje.start();
            if (System.currentTimeMillis() - this.Hjg > 2000) {
                this.Hjf = 3;
            }
            AppMethodBeat.o(115690);
        } catch (Exception e2) {
            Log.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e2.toString());
            AppMethodBeat.o(115690);
        }
    }

    class a implements Runnable {
        private boolean Hjn;
        private long interval;
        private int resId;
        private int streamType;

        public a(int i2, long j2, boolean z, int i3) {
            this.resId = i2;
            this.interval = j2;
            this.Hjn = z;
            this.streamType = i3;
        }

        public final void run() {
            AppMethodBeat.i(115685);
            e.this.a(this.resId, this.interval, this.Hjn, this.streamType);
            AppMethodBeat.o(115685);
        }
    }

    private void fKV() {
        boolean z;
        AppMethodBeat.i(115691);
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        if (d.oD(26)) {
            z = sharedPreferences.getBoolean("settings_voip_scene_shake", true);
        } else {
            z = sharedPreferences.getBoolean("settings_shake", true);
        }
        if (z) {
            int ringerMode = this.mAudioManager.getRingerMode();
            Log.i("MicroMsg.RingPlayer", "system ringer mode: %s", Integer.valueOf(ringerMode));
            if (ringerMode == 1 || ringerMode == 2) {
                this.ooM = (Vibrator) this.mContext.getSystemService("vibrator");
                if (this.ooM == null) {
                    AppMethodBeat.o(115691);
                    return;
                } else if (d.oD(26)) {
                    this.ooM.vibrate(VibrationEffect.createWaveform(new long[]{1000, 1000, 1000, 1000}, 0), new AudioAttributes.Builder().setUsage(6).build());
                    AppMethodBeat.o(115691);
                    return;
                } else {
                    this.ooM.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
                    AppMethodBeat.o(115691);
                    return;
                }
            } else {
                Log.i("MicroMsg.RingPlayer", "system not open vibrate");
            }
        }
        AppMethodBeat.o(115691);
    }

    private void fKW() {
        AppMethodBeat.i(115692);
        if (this.ooM != null) {
            this.ooM.cancel();
            this.ooM = null;
        }
        AppMethodBeat.o(115692);
    }

    public final void bl(int i2, boolean z) {
        AppMethodBeat.i(115693);
        this.Hjf = 0;
        F(R.raw.phonering, i2, z);
        AppMethodBeat.o(115693);
    }

    public final void a(int i2, boolean z, int i3, boolean z2) {
        AppMethodBeat.i(235834);
        if ((i2 == R.raw.playend || i2 == R.raw.close_lower_volume) && !com.tencent.mm.plugin.audio.c.a.ceb() && !com.tencent.mm.plugin.audio.c.a.cdW() && (this.mAudioManager.getRingerMode() == 0 || this.mAudioManager.getRingerMode() == 1)) {
            AppMethodBeat.o(235834);
            return;
        }
        boolean z3 = this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_shake", true);
        if (z) {
            Util.shake(this.mContext, z3);
        }
        Log.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z));
        this.Hjh = System.currentTimeMillis();
        k kVar = new k();
        try {
            kVar.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + FilePathGenerator.ANDROID_DIR_SEP + i2));
            kVar.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                /* class com.tencent.mm.plugin.voip.video.e.AnonymousClass5 */

                public final void onCompletion(MediaPlayer mediaPlayer) {
                    AppMethodBeat.i(115681);
                    mediaPlayer.release();
                    if (System.currentTimeMillis() - e.this.Hjh > 5000) {
                        e.this.Hjf = 8;
                    }
                    AppMethodBeat.o(115681);
                }
            });
            kVar.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                /* class com.tencent.mm.plugin.voip.video.e.AnonymousClass6 */

                public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                    AppMethodBeat.i(115682);
                    if (mediaPlayer != null) {
                        mediaPlayer.release();
                        e.this.Hjf = 5;
                        Log.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
                    }
                    AppMethodBeat.o(115682);
                    return false;
                }
            });
            xw(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn());
            if (z2) {
                int cdX = com.tencent.mm.plugin.audio.c.a.ceb() ? com.tencent.mm.plugin.audio.c.a.cdX() : 0;
                kVar.setAudioStreamType(cdX);
                if (d.oF(28)) {
                    kVar.setAudioAttributes(new AudioAttributes.Builder().setUsage(6).setLegacyStreamType(cdX).setContentType(4).build());
                    Log.i("MicroMsg.RingPlayer", "use audio attribute to play ring");
                } else {
                    kVar.setAudioStreamType(cdX);
                }
            }
            if (i2 == R.raw.playend && (com.tencent.mm.plugin.audio.c.a.ceb() || com.tencent.mm.plugin.audio.c.a.cdW())) {
                kVar.setVolume(0.5f, 0.5f);
            }
            kVar.prepare();
            kVar.setLooping(false);
            kVar.start();
            if (System.currentTimeMillis() - this.Hjh > 2000) {
                this.Hjf = 7;
            }
            AppMethodBeat.o(235834);
        } catch (Throwable th) {
            Log.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", th);
            this.Hjf = 6;
            AppMethodBeat.o(235834);
        }
    }

    public final void g(int i2, boolean z, int i3) {
        AppMethodBeat.i(235835);
        a(i2, z, i3, true);
        AppMethodBeat.o(235835);
    }

    public final int fKX() {
        AppMethodBeat.i(115696);
        Log.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.Hjf);
        int i2 = this.Hjf;
        AppMethodBeat.o(115696);
        return i2;
    }
}
