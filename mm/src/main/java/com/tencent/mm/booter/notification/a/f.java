package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ck;
import java.io.IOException;

public final class f {
    Context context;
    MediaPlayer goA;
    MMHandler goB;
    private MMHandler goC;
    boolean goz;

    /* synthetic */ f(byte b2) {
        this();
    }

    public static class a {
        private static final f goH = new f((byte) 0);

        static {
            AppMethodBeat.i(20064);
            AppMethodBeat.o(20064);
        }
    }

    private f() {
        AppMethodBeat.i(20065);
        this.goz = false;
        this.goA = null;
        this.goB = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.booter.notification.a.f.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(20056);
                Log.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", Boolean.valueOf(f.this.goz));
                try {
                    if (f.this.goA != null) {
                        if (f.this.goA.isPlaying()) {
                            f.this.goA.stop();
                        }
                        f.this.goA.release();
                        f.this.goz = false;
                        Log.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", Boolean.valueOf(f.this.goz));
                    }
                    AppMethodBeat.o(20056);
                } catch (IllegalStateException e2) {
                    Log.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", Boolean.valueOf(f.this.goz));
                    if (f.this.goA != null) {
                        f.this.goA.release();
                    }
                    AppMethodBeat.o(20056);
                }
            }
        };
        this.context = MMApplicationContext.getContext();
        ae.DV(ck.gEw());
        AppMethodBeat.o(20065);
    }

    public final synchronized void De(final String str) {
        AppMethodBeat.i(20066);
        if (this.goC == null) {
            Log.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
            HandlerThread hA = d.hA("playSoundThread", 0);
            hA.start();
            this.goC = new MMHandler(hA.getLooper());
        }
        this.goC.post(new Runnable() {
            /* class com.tencent.mm.booter.notification.a.f.AnonymousClass2 */
            final /* synthetic */ boolean goF = false;

            public final void run() {
                Uri parse;
                boolean z;
                boolean z2;
                AppMethodBeat.i(20057);
                f fVar = f.this;
                String str = str;
                boolean z3 = this.goF;
                if (fVar.context == null) {
                    fVar.context = MMApplicationContext.getContext();
                }
                if (fVar.context == null) {
                    Log.w("MicroMsg.Notification.Tool.Sound", "playSound:context is null!!");
                    AppMethodBeat.o(20057);
                    return;
                }
                try {
                    AudioManager audioManager = (AudioManager) fVar.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    if (audioManager.getStreamVolume(5) == 0) {
                        AppMethodBeat.o(20057);
                        return;
                    }
                    fVar.goB.removeMessages(305419896);
                    fVar.goB.sendEmptyMessageDelayed(305419896, 8000);
                    Log.i("MicroMsg.Notification.Tool.Sound", "doPlaySound playerIsInit: %s", Boolean.valueOf(fVar.goz));
                    if (fVar.goz) {
                        try {
                            if (fVar.goA != null) {
                                if (fVar.goA.isPlaying()) {
                                    fVar.goA.stop();
                                }
                                fVar.goA.release();
                                Log.i("MicroMsg.Notification.Tool.Sound", "try to release player before playSound playerIsInit: %s", Boolean.valueOf(fVar.goz));
                            }
                        } catch (IllegalStateException e2) {
                            Log.w("MicroMsg.Notification.Tool.Sound", "try to release player before playSound error");
                            if (fVar.goA != null) {
                                fVar.goA.release();
                            }
                        }
                        fVar.goz = false;
                    }
                    fVar.goA = new k();
                    Log.i("MicroMsg.Notification.Tool.Sound", "doPlaySound player: %s", fVar.goA);
                    MediaPlayer mediaPlayer = fVar.goA;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (Util.isNullOrNil(str)) {
                        parse = RingtoneManager.getDefaultUri(2);
                    } else if (z3) {
                        AssetFileDescriptor openFd = fVar.context.getAssets().openFd(str);
                        mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                        parse = null;
                    } else {
                        parse = Uri.parse(str);
                    }
                    if (parse != null) {
                        try {
                            mediaPlayer.setDataSource(fVar.context, parse);
                        } catch (IOException e3) {
                            if (!Util.isNullOrNil(str)) {
                                mediaPlayer.setDataSource(fVar.context, RingtoneManager.getDefaultUri(2));
                            } else {
                                Log.i("MicroMsg.Notification.Tool.Sound", "setPlayerDataSource IOException soundUri:%s, isAsset:%s", str, Boolean.valueOf(z3));
                            }
                        }
                    }
                    Log.i("MicroMsg.Notification.Tool.Sound", "summeranrt setPlayerDataSource tid[%d] [%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (audioManager.isWiredHeadsetOn()) {
                        int jv = com.tencent.mm.plugin.audio.c.a.jv(false);
                        Log.d("MicroMsg.Notification.Tool.Sound", "headset on, selected stream type: %s", Integer.valueOf(jv));
                        float streamVolume = (float) audioManager.getStreamVolume(jv);
                        float streamVolume2 = (float) audioManager.getStreamVolume(3);
                        float streamMaxVolume = (float) audioManager.getStreamMaxVolume(jv);
                        float streamMaxVolume2 = (float) audioManager.getStreamMaxVolume(3);
                        float f2 = streamVolume / streamMaxVolume;
                        float f3 = streamVolume2 / streamMaxVolume2;
                        Log.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s, maxVolume: %s, toneScale: %s", Float.valueOf(streamVolume), Float.valueOf(streamMaxVolume), Float.valueOf(f2));
                        Log.d("MicroMsg.Notification.Tool.Sound", "headset on, toneMUSICVolume: %s, maxMUSICVolume: %s, toneMusicScale: %s", Float.valueOf(streamVolume2), Float.valueOf(streamMaxVolume2), Float.valueOf(f3));
                        if (f2 > f3) {
                            streamVolume = streamMaxVolume * f3;
                            Log.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s", Float.valueOf(streamVolume));
                        }
                        Log.i("MicroMsg.Notification.Tool.Sound", "headset on, setSpeakerphoneOn to false");
                        audioManager.setSpeakerphoneOn(false);
                        Log.i("MicroMsg.Notification.Tool.Sound", "notificationSetMode: %s", Integer.valueOf(ae.gKE.gHJ));
                        if (ae.gKE.gHJ == 1) {
                            Log.i("MicroMsg.Notification.Tool.Sound", "notification set mode enable, set mode now");
                            if (audioManager.getMode() == 0) {
                                audioManager.setMode(3);
                            }
                            fVar.goA.setOnCompletionListener(new MediaPlayer.OnCompletionListener(audioManager) {
                                /* class com.tencent.mm.booter.notification.a.f.AnonymousClass3 */
                                final /* synthetic */ AudioManager goG;

                                {
                                    this.goG = r2;
                                }

                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    AppMethodBeat.i(20058);
                                    Log.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", f.this.goA);
                                    this.goG.setMode(0);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (f.this.goA != null) {
                                        f.this.goA.release();
                                    }
                                    AppMethodBeat.o(20058);
                                }
                            });
                            fVar.goA.setOnErrorListener(new MediaPlayer.OnErrorListener(audioManager) {
                                /* class com.tencent.mm.booter.notification.a.f.AnonymousClass4 */
                                final /* synthetic */ AudioManager goG;

                                {
                                    this.goG = r2;
                                }

                                public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                                    AppMethodBeat.i(20059);
                                    Log.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", f.this.goA);
                                    this.goG.setMode(0);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (f.this.goA != null) {
                                        f.this.goA.release();
                                    }
                                    AppMethodBeat.o(20059);
                                    return false;
                                }
                            });
                        } else {
                            fVar.goA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                /* class com.tencent.mm.booter.notification.a.f.AnonymousClass5 */

                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    AppMethodBeat.i(20060);
                                    Log.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", f.this.goA);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (f.this.goA != null) {
                                        f.this.goA.release();
                                    }
                                    AppMethodBeat.o(20060);
                                }
                            });
                            fVar.goA.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                                /* class com.tencent.mm.booter.notification.a.f.AnonymousClass6 */

                                public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                                    AppMethodBeat.i(20061);
                                    Log.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", f.this.goA);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (f.this.goA != null) {
                                        f.this.goA.release();
                                    }
                                    AppMethodBeat.o(20061);
                                    return false;
                                }
                            });
                        }
                        fVar.goA.setAudioStreamType(jv);
                        fVar.goA.setLooping(true);
                        fVar.goA.prepare();
                        fVar.goA.setVolume(streamVolume / streamMaxVolume, streamVolume / streamMaxVolume);
                        fVar.goA.setLooping(false);
                        fVar.goA.start();
                        fVar.goz = true;
                        AppMethodBeat.o(20057);
                        return;
                    }
                    Log.d("MicroMsg.Notification.Tool.Sound", "getStreamVolume =  %d, soundUri = %s", Integer.valueOf(audioManager.getStreamVolume(5)), str);
                    fVar.goA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        /* class com.tencent.mm.booter.notification.a.f.AnonymousClass7 */

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            AppMethodBeat.i(20062);
                            Log.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", f.this.goA);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (f.this.goA != null) {
                                f.this.goA.release();
                                Log.i("MicroMsg.Notification.Tool.Sound", "play sound real finish, player: %s,playerIsInit:%s", f.this.goA, Boolean.valueOf(f.this.goz));
                            }
                            AppMethodBeat.o(20062);
                        }
                    });
                    fVar.goA.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        /* class com.tencent.mm.booter.notification.a.f.AnonymousClass8 */

                        public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                            AppMethodBeat.i(20063);
                            Log.i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", f.this.goA);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (f.this.goA != null) {
                                f.this.goA.release();
                                Log.i("MicroMsg.Notification.Tool.Sound", "play sound real error, player: %s,playerIsInit:%s", f.this.goA, Boolean.valueOf(f.this.goz));
                            }
                            AppMethodBeat.o(20063);
                            return false;
                        }
                    });
                    fVar.goA.setAudioStreamType(5);
                    fVar.goA.setLooping(true);
                    fVar.goA.prepare();
                    fVar.goA.setLooping(false);
                    fVar.goA.start();
                    fVar.goz = true;
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(fVar.goz);
                    if (Looper.myLooper() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[1] = Boolean.valueOf(z);
                    if (Looper.getMainLooper() != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[2] = Boolean.valueOf(z2);
                    Log.i("MicroMsg.Notification.Tool.Sound", "doPlaySound start finish playerIsInit:%s, myLooper[%b] mainLooper[%b]", objArr);
                    AppMethodBeat.o(20057);
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e4, "PlaySound Exception:", new Object[0]);
                    try {
                        if (fVar.goA != null) {
                            fVar.goA.release();
                        }
                        AppMethodBeat.o(20057);
                    } catch (Exception e5) {
                        Log.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e5, "try to release player in Exception:", new Object[0]);
                        AppMethodBeat.o(20057);
                    }
                }
            }
        });
        AppMethodBeat.o(20066);
    }
}
