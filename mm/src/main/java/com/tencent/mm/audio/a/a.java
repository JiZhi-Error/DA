package com.tencent.mm.audio.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.k;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import junit.framework.Assert;
import kotlin.g.a.b;
import kotlin.x;

public final class a implements k {
    private static String dyh = null;
    private Context context;
    private boolean dtA;
    private boolean dtB;
    private boolean dtC;
    private d dtF;
    private boolean dya;
    private boolean dyb;
    private int dyc;
    private boolean dyd;
    private k.c dye;
    private k.d dyf;
    private String dyg;
    private com.tencent.mm.audio.a dyi;
    private boolean dyj;
    private HandlerThread dyk;
    private MMHandler dyl;
    public k.b dym;
    public k.a dyn;

    public a(Context context2) {
        this(context2, 0);
    }

    public a(Context context2, int i2) {
        AppMethodBeat.i(148290);
        this.dtF = null;
        this.context = null;
        this.dya = false;
        this.dyb = false;
        this.dyc = 0;
        this.dyd = true;
        this.dyg = null;
        this.dtA = true;
        this.dtB = true;
        this.dtC = false;
        this.dyk = null;
        this.dyl = null;
        this.dym = null;
        this.context = context2 instanceof Activity ? MMApplicationContext.getContext() : context2;
        this.dyc = i2;
        this.dyi = new com.tencent.mm.audio.a(context2, new b<Integer, x>() {
            /* class com.tencent.mm.audio.a.a.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(187312);
                Integer num2 = num;
                Log.i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", num2);
                if (num2.intValue() == -2 || num2.intValue() == -3) {
                    if (a.this.isPlaying() && (a.this.dyg == null || a.dyh == null || a.this.dyg.equals(a.dyh))) {
                        if (!Util.isEqual(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_target26_voice_focus_shield_sw, 0), 0)) {
                            Log.i("MicroMsg.SceneVoicePlayer", "no shield");
                        } else if (num2.intValue() == -3 && com.tencent.mm.compatible.util.d.oD(26)) {
                            Log.i("MicroMsg.SceneVoicePlayer", "focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK %s", Integer.valueOf(Build.VERSION.SDK_INT));
                        }
                        a.this.da(false);
                    }
                } else if (num2.intValue() == 1 || num2.intValue() == 2 || num2.intValue() == 3) {
                    a.this.resume();
                } else if (num2.intValue() == -1) {
                    a.this.stop(false);
                }
                AppMethodBeat.o(187312);
                return null;
            }
        });
        new g.b();
        this.dyj = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scene_voice_player_async, 0) == 1;
        Log.i("MicroMsg.SceneVoicePlayer", "asyncDoVoiceCompleteAction:%s", Boolean.valueOf(this.dyj));
        AppMethodBeat.o(148290);
    }

    @Override // com.tencent.mm.ak.k
    public final void unInit() {
        AppMethodBeat.i(187319);
        this.dyi.context = null;
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.agt("music");
        AppMethodBeat.o(187319);
    }

    @Override // com.tencent.mm.ak.k
    public final boolean isPlaying() {
        AppMethodBeat.i(148291);
        if (this.dtF == null) {
            AppMethodBeat.o(148291);
            return false;
        }
        boolean isPlaying = this.dtF.isPlaying();
        AppMethodBeat.o(148291);
        return isPlaying;
    }

    @Override // com.tencent.mm.ak.k
    public final boolean a(String str, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(148292);
        Log.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(this.dyc));
        Assert.assertTrue(str.length() > 0);
        dyh = this.dyg;
        this.dyg = str;
        if (!s.YS(z2 ? str : com.tencent.mm.modelvoice.s.getFullPath(str))) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (!z2) {
                str = com.tencent.mm.modelvoice.s.getFullPath(str);
            }
            objArr[1] = str;
            Log.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", objArr);
            AppMethodBeat.o(148292);
            return false;
        }
        if (i2 == -1) {
            i2 = q.g(str, this.dyc, z2);
        }
        if (i2 == 0) {
            if (this.context != null) {
                this.dtF = new u(this.context);
            } else {
                this.dtF = new u();
            }
        } else if (i2 == 1) {
            if (this.context != null) {
                this.dtF = new l(this.context);
            } else {
                this.dtF = new l();
            }
        } else if (i2 == 2) {
            if (this.context != null) {
                this.dtF = new com.tencent.mm.modelvoice.k(this.context);
            } else {
                this.dtF = new com.tencent.mm.modelvoice.k();
            }
        }
        if (this.dtF != null) {
            Log.i("MicroMsg.SceneVoicePlayer", "init player success %s", Integer.valueOf(hashCode()));
            this.dyi.dtF = this.dtF;
        } else {
            Log.e("MicroMsg.SceneVoicePlayer", "init player failed %s", Integer.valueOf(hashCode()));
        }
        this.dyi.Yl();
        this.dyi.cU(z);
        if (com.tencent.mm.plugin.audio.c.a.cdW() || com.tencent.mm.plugin.audio.c.a.ceb()) {
            Log.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cdW()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.ceb()));
            this.dyi.cU(false);
        }
        this.dyi.jp(this.dyi.dtE);
        ZX();
        setError();
        if (!z2) {
            str = this.dyc == 0 ? com.tencent.mm.modelvoice.s.getFullPath(str) : null;
        }
        this.dyi.x(str, 0);
        Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", Boolean.valueOf(this.dtA));
        AppMethodBeat.o(148292);
        return true;
    }

    @Override // com.tencent.mm.ak.k
    public final boolean a(String str, boolean z, int i2, int i3) {
        AppMethodBeat.i(148293);
        Log.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.TRUE, Integer.valueOf(i2), Integer.valueOf(this.dyc));
        Assert.assertTrue(str.length() > 0);
        if (!s.YS(str)) {
            Log.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", str, str);
            AppMethodBeat.o(148293);
            return false;
        }
        if (i2 == -1) {
            i2 = q.g(str, this.dyc, true);
        }
        if (i2 == 0) {
            if (this.context != null) {
                this.dtF = new u(this.context);
            } else {
                this.dtF = new u();
            }
        } else if (i2 == 1) {
            if (this.context != null) {
                this.dtF = new l(this.context);
            } else {
                this.dtF = new l();
            }
        } else if (i2 == 2) {
            if (this.context != null) {
                this.dtF = new com.tencent.mm.modelvoice.k(this.context);
            } else {
                this.dtF = new com.tencent.mm.modelvoice.k();
            }
        }
        if (this.dtF != null) {
            Log.i("MicroMsg.SceneVoicePlayer", "init player success %s", Integer.valueOf(hashCode()));
            this.dyi.dtF = this.dtF;
        } else {
            Log.e("MicroMsg.SceneVoicePlayer", "init player failed %s", Integer.valueOf(hashCode()));
        }
        this.dyi.Yl();
        this.dyi.cU(z);
        this.dyi.jp(this.dyi.dtE);
        ZX();
        setError();
        this.dyi.x(str, i3);
        Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", Boolean.valueOf(this.dtA));
        AppMethodBeat.o(148293);
        return true;
    }

    @Override // com.tencent.mm.ak.k
    public final void cY(boolean z) {
        this.dtA = z;
    }

    @Override // com.tencent.mm.ak.k
    public final void cZ(boolean z) {
        this.dtB = z;
    }

    @Override // com.tencent.mm.ak.k
    public final boolean pause() {
        AppMethodBeat.i(261898);
        boolean da = da(true);
        AppMethodBeat.o(261898);
        return da;
    }

    public final boolean da(boolean z) {
        AppMethodBeat.i(148295);
        if (this.dtF == null) {
            AppMethodBeat.o(148295);
            return false;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "pause");
        boolean cX = this.dyi.cX(z);
        if (cX && this.dye != null) {
            this.dye.fw(z);
        }
        Log.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(this.dtA), Boolean.valueOf(this.dtC));
        AppMethodBeat.o(148295);
        return cX;
    }

    @Override // com.tencent.mm.ak.k
    public final boolean resume() {
        AppMethodBeat.i(148296);
        if (this.dtF == null) {
            AppMethodBeat.o(148296);
            return false;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "resume");
        boolean Ym = this.dyi.Ym();
        Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(this.dtA), Boolean.valueOf(this.dtC));
        AppMethodBeat.o(148296);
        return Ym;
    }

    public final boolean n(String str, boolean z) {
        AppMethodBeat.i(148297);
        boolean a2 = a(str, z, false, -1);
        AppMethodBeat.o(148297);
        return a2;
    }

    @Override // com.tencent.mm.ak.k
    public final boolean isCalling() {
        return this.dya;
    }

    @Override // com.tencent.mm.ak.k
    public final void stop() {
        AppMethodBeat.i(261899);
        stop(false);
        AppMethodBeat.o(261899);
    }

    @Override // com.tencent.mm.ak.k
    public final void stop(boolean z) {
        AppMethodBeat.i(148299);
        if (this.dtF == null) {
            Log.e("MicroMsg.SceneVoicePlayer", "stop player failed cause player is null %s", Integer.valueOf(hashCode()));
            AppMethodBeat.o(148299);
            return;
        }
        this.dtF.Qt();
        this.dtF.a((d.a) null);
        Log.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", Boolean.valueOf(this.dtA), Boolean.valueOf(this.dtC), Boolean.valueOf(this.dtB));
        this.dyi.Yn();
        if (!z && this.dyf != null) {
            this.dyf.onStop();
        }
        AppMethodBeat.o(148299);
    }

    @Override // com.tencent.mm.ak.k
    public final void cU(boolean z) {
        AppMethodBeat.i(148300);
        this.dyi.cV(z);
        AppMethodBeat.o(148300);
    }

    @Override // com.tencent.mm.ak.k
    public final void a(k.b bVar) {
        this.dym = bVar;
    }

    @Override // com.tencent.mm.ak.k
    public final void a(k.c cVar) {
        this.dye = cVar;
    }

    @Override // com.tencent.mm.ak.k
    public final void a(k.d dVar) {
        this.dyf = dVar;
    }

    private void setError() {
        AppMethodBeat.i(148301);
        AnonymousClass2 r0 = new d.b() {
            /* class com.tencent.mm.audio.a.a.AnonymousClass2 */

            @Override // com.tencent.mm.modelvoice.d.b
            public final void onError() {
                AppMethodBeat.i(187314);
                com.tencent.mm.audio.a aVar = a.this.dyi;
                aVar.cdV();
                if (aVar.dtC) {
                    com.tencent.mm.compatible.util.b bVar = aVar.dtz;
                    if (bVar != null) {
                        bVar.apm();
                    }
                    aVar.dtC = false;
                }
                Log.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(a.this.dtA), Boolean.valueOf(a.this.dtC));
                if (a.this.dym != null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.audio.a.a.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(187313);
                            a.this.dym.onError();
                            AppMethodBeat.o(187313);
                        }
                    });
                }
                AppMethodBeat.o(187314);
            }
        };
        if (this.dtF != null) {
            this.dtF.a(r0);
        }
        AppMethodBeat.o(148301);
    }

    @Override // com.tencent.mm.ak.k
    public final void a(k.a aVar) {
        this.dyn = aVar;
    }

    private void ZX() {
        AppMethodBeat.i(148302);
        AnonymousClass3 r0 = new d.a() {
            /* class com.tencent.mm.audio.a.a.AnonymousClass3 */

            @Override // com.tencent.mm.modelvoice.d.a
            public final void onCompletion() {
                AppMethodBeat.i(187318);
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.audio.a.a.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(148284);
                        try {
                            if (ae.gKu.gDJ == 1) {
                                Thread.sleep(300);
                            }
                            Log.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", a.this.dyn, Boolean.valueOf(a.this.dyd));
                            AnonymousClass1 r0 = new Runnable() {
                                /* class com.tencent.mm.audio.a.a.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(187317);
                                    a.this.dyi.cV(a.this.dyi.dtE);
                                    if (a.this.dyd) {
                                        PlaySound.play(a.this.context, R.string.fn6, a.this.dyi.dtE, false, new PlaySound.OnPlayCompletionListener() {
                                            /* class com.tencent.mm.audio.a.a.AnonymousClass3.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            @Override // com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener
                                            public final void onCompletion() {
                                                AppMethodBeat.i(187315);
                                                Log.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                                                if (!a.this.isPlaying()) {
                                                    Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(a.this.dyb));
                                                    a.this.dyi.cW(a.this.dyb);
                                                    a.this.dyb = false;
                                                    Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(a.this.dtA), Boolean.valueOf(a.this.dtC));
                                                    Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                                                }
                                                a.k(a.this);
                                                AppMethodBeat.o(187315);
                                            }
                                        });
                                    } else {
                                        Log.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                                        if (!a.this.isPlaying()) {
                                            Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(a.this.dtA), Boolean.valueOf(a.this.dtC));
                                            Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(a.this.dyb));
                                            a.this.dyi.cW(a.this.dyb);
                                            a.this.dyb = false;
                                            Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                                        }
                                        a.k(a.this);
                                    }
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.audio.a.a.AnonymousClass3.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                        public final void run() {
                                            AppMethodBeat.i(187316);
                                            if (a.this.dyn != null) {
                                                Log.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                                                a.this.dyn.onCompletion();
                                                AppMethodBeat.o(187316);
                                                return;
                                            }
                                            Log.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                                            AppMethodBeat.o(187316);
                                        }
                                    });
                                    AppMethodBeat.o(187317);
                                }
                            };
                            if (!a.this.dyj) {
                                Log.i("MicroMsg.SceneVoicePlayer", "sync do voice complete action");
                                MMHandlerThread.postToMainThread(r0);
                                AppMethodBeat.o(148284);
                                return;
                            }
                            Log.i("MicroMsg.SceneVoicePlayer", "async do voice complete action");
                            a.m(a.this);
                            a.this.dyl.post(r0);
                            AppMethodBeat.o(148284);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.SceneVoicePlayer", "exception:%s", Util.stackTraceToString(e2));
                            AppMethodBeat.o(148284);
                        }
                    }
                }, "SceneVoice_onCompletion");
                AppMethodBeat.o(187318);
            }
        };
        if (this.dtF != null) {
            this.dtF.a(r0);
        }
        AppMethodBeat.o(148302);
    }

    @Override // com.tencent.mm.ak.k
    public final double ZY() {
        AppMethodBeat.i(148303);
        if (this.dtF == null) {
            AppMethodBeat.o(148303);
            return 0.0d;
        }
        double ZY = this.dtF.ZY();
        AppMethodBeat.o(148303);
        return ZY;
    }

    @Override // com.tencent.mm.ak.k
    public final void db(boolean z) {
        AppMethodBeat.i(148304);
        Log.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", Boolean.valueOf(z));
        this.dyb = z;
        AppMethodBeat.o(148304);
    }

    @Override // com.tencent.mm.ak.k
    public final boolean YY() {
        AppMethodBeat.i(148305);
        if (this.dtF == null) {
            AppMethodBeat.o(148305);
            return false;
        } else if (this.dtF.getStatus() == 2) {
            AppMethodBeat.o(148305);
            return true;
        } else {
            AppMethodBeat.o(148305);
            return false;
        }
    }

    static /* synthetic */ void k(a aVar) {
        AppMethodBeat.i(187322);
        if (!(aVar.dyk == null || !aVar.dyk.isAlive() || aVar.dyl == null)) {
            aVar.dyk.quitSafely();
            aVar.dyk = null;
            Log.i("MicroMsg.SceneVoicePlayer", "stop voice complete thread");
        }
        AppMethodBeat.o(187322);
    }

    static /* synthetic */ void m(a aVar) {
        AppMethodBeat.i(187323);
        if (aVar.dyk == null) {
            aVar.dyk = new HandlerThread("SceneVoicePlayer_VoiceCompleteAction");
            aVar.dyk.start();
            aVar.dyl = new MMHandler(aVar.dyk.getLooper());
            Log.i("MicroMsg.SceneVoicePlayer", "start voice complete thread");
        }
        AppMethodBeat.o(187323);
    }
}
