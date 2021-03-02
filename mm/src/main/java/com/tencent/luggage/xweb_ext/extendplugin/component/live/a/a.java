package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.f.h;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.g;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.j;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.tav.core.AssetExtension;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a extends com.tencent.luggage.xweb_ext.extendplugin.a.a implements i, o {
    private z cDL = new z() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass11 */
        private x cFl = new d();

        {
            AppMethodBeat.i(215573);
            AppMethodBeat.o(215573);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.z
        public final x PW() {
            return this.cFl;
        }
    };
    public c cEA;
    public b cEB;
    public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a cEC;
    public com.tencent.luggage.xweb_ext.extendplugin.a cED;
    a.AbstractC0188a cEE;
    public int cEF;
    public int cEG;
    public int cEH = 0;
    public int cEI = 0;
    private boolean cEJ;
    boolean cEK;
    boolean cEL;
    final com.tencent.mm.plugin.appbrand.jsapi.video.a.a cEM = new com.tencent.mm.plugin.appbrand.jsapi.video.a.a();
    com.tencent.mm.plugin.appbrand.jsapi.u.c cEN = null;
    String cEO = null;
    public Handler cEP;
    private HandlerThread cEQ = com.tencent.f.c.d.hA(String.format("LivePlayerThread_%s", Long.valueOf(System.currentTimeMillis())), 5);
    boolean cER = false;
    volatile boolean cES = false;
    AtomicBoolean cET = null;
    com.tencent.luggage.xweb_ext.extendplugin.component.a cEU = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.cDL) {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass13 */

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.a
        public final void a(String str, com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
            AppMethodBeat.i(215574);
            a(aVar);
            JSONObject Ps = aVar.Ps();
            if (str.contains("insert") || str.contains("update")) {
                if (Ps.has("autoplay")) {
                    this.cDM = Ps.optBoolean("autoplay");
                }
                Boolean K = ac.K(Ps);
                if (K != null) {
                    this.cDN = K.booleanValue();
                }
            } else if (str.contains("operate")) {
                String optString = Ps.optString("type");
                if (!Util.isNullOrNil(optString) && (optString.equalsIgnoreCase(AssetExtension.SCENE_PLAY) || optString.equalsIgnoreCase("resume"))) {
                    this.cDM = true;
                }
            } else if (str.contains("remove")) {
                this.cDM = false;
            }
            Log.d(a.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cDM + ", mIsAutoRotationEnabled: " + this.cDN);
            AppMethodBeat.o(215574);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.a
        public final boolean Pv() {
            return !a.this.cES;
        }
    };
    com.tencent.luggage.xweb_ext.extendplugin.component.b<d> cEV = new com.tencent.luggage.xweb_ext.extendplugin.component.b<d>() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass14 */
        private d cFm = null;

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.b
        public final String getLogTag() {
            AppMethodBeat.i(215575);
            String logTag = a.this.getLogTag();
            AppMethodBeat.o(215575);
            return logTag;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.b
        public final int getId() {
            AppMethodBeat.i(215576);
            int id = a.this.getId();
            AppMethodBeat.o(215576);
            return id;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.b
        public final String getKey() {
            AppMethodBeat.i(215577);
            String key = a.this.getKey();
            AppMethodBeat.o(215577);
            return key;
        }

        /* Return type fixed from 'com.tencent.luggage.xweb_ext.extendplugin.component.c' to match base method */
        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.b
        public final /* synthetic */ d Pw() {
            AppMethodBeat.i(215578);
            if (this.cFm == null) {
                this.cFm = new d(a.this);
            }
            d dVar = this.cFm;
            AppMethodBeat.o(215578);
            return dVar;
        }
    };
    String cEW = "";
    public s cEX = null;
    public int cEY = -1;
    volatile boolean cEZ = false;
    public b cEz;
    boolean cFa = false;
    boolean cFb = false;
    public boolean cFc = false;
    private i cFd = new r();
    public AtomicBoolean cFe = new AtomicBoolean(false);
    volatile String cFf = null;
    volatile g cFg = null;
    volatile Bitmap cFh = null;
    public Surface mSurface;
    public SurfaceTexture mSurfaceTexture;
    volatile String mTitle = null;

    public final String getLogTag() {
        AppMethodBeat.i(138826);
        String format = String.format("%s(%s)", "MicroMsg.SameLayer.LivePlayerPluginHandler", Lb());
        AppMethodBeat.o(138826);
        return format;
    }

    public a() {
        AppMethodBeat.i(138827);
        this.cEQ.start();
        this.cEP = new Handler(this.cEQ.getLooper());
        com.tencent.luggage.xweb_ext.extendplugin.component.live.b.PP();
        this.cEz = new b(MMApplicationContext.getContext());
        this.cEz.mHandler = this.cEP;
        this.cEz.cFv = new ITXLivePlayListener() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass1 */

            @Override // com.tencent.rtmp.ITXLivePlayListener
            public final void onPlayEvent(int i2, Bundle bundle) {
                int i3;
                AppMethodBeat.i(138813);
                if (a.this.PS()) {
                    a.this.cEB.a(a.this.getId(), i2, bundle);
                }
                if (a.this.cEC != null) {
                    a.this.cEC.hY(i2);
                }
                switch (i2) {
                    case -2301:
                        if (a.this.cEX != null) {
                            a.this.cEX.onStop();
                        } else {
                            a.this.cEY = 6;
                        }
                        h.RTc.aV(new Runnable() {
                            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass1.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(215568);
                                Log.i(a.this.getLogTag(), "onStop, abandonFocus");
                                a.this.cEM.bJJ();
                                AppMethodBeat.o(215568);
                            }
                        });
                        break;
                    case 2004:
                        if (a.this.cEX != null) {
                            a.this.cEX.PM();
                            a.this.cEX.bZ(a.this.cEZ);
                        } else {
                            a aVar = a.this;
                            if (a.this.cEZ) {
                                i3 = 2;
                            } else {
                                i3 = 3;
                            }
                            aVar.cEY = i3;
                        }
                        Log.d(a.this.getLogTag(), "onPlayEvent play, mIsWebViewInBackground: %b, isRuntimeInBackground: %b", Boolean.valueOf(a.this.cES), Boolean.valueOf(a.this.cER));
                        if (!a.this.cES && !a.this.cER && !a.this.isMuted()) {
                            h.RTc.aV(new Runnable() {
                                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(215566);
                                    Log.i(a.this.getLogTag(), "onPlayEvent play, requestFocus");
                                    a.this.cEM.bJI();
                                    AppMethodBeat.o(215566);
                                }
                            });
                            AppMethodBeat.o(138813);
                            return;
                        }
                    case 2006:
                        if (a.this.cEX != null) {
                            a.this.cEX.PN();
                        } else {
                            a.this.cEY = 7;
                        }
                        h.RTc.aV(new Runnable() {
                            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(215567);
                                Log.i(a.this.getLogTag(), "onPlayEnd, abandonFocus");
                                a.this.cEM.bJJ();
                                AppMethodBeat.o(215567);
                            }
                        });
                        AppMethodBeat.o(138813);
                        return;
                    case 2007:
                        if (a.this.cEX != null) {
                            a.this.cEX.PL();
                            AppMethodBeat.o(138813);
                            return;
                        }
                        a.this.cEY = 0;
                        AppMethodBeat.o(138813);
                        return;
                }
                AppMethodBeat.o(138813);
            }

            @Override // com.tencent.rtmp.ITXLivePlayListener
            public final void onNetStatus(Bundle bundle) {
                AppMethodBeat.i(138814);
                if (a.this.PS()) {
                    a.this.cEB.d(a.this.getId(), bundle);
                }
                AppMethodBeat.o(138814);
            }
        };
        this.cEz.mAudioVolumeListener = new TXLivePlayer.ITXAudioVolumeEvaluationListener() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass12 */

            @Override // com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener
            public final void onAudioVolumeEvaluationNotify(int i2) {
                AppMethodBeat.i(138816);
                if (a.this.cEB != null) {
                    a.this.cEB.bW(a.this.getId(), i2);
                }
                AppMethodBeat.o(138816);
            }
        };
        AppMethodBeat.o(138827);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        return true;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void e(final SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(138828);
        if (this.cEP != null) {
            this.cEP.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass23 */

                public final void run() {
                    AppMethodBeat.i(138817);
                    a.a(a.this, surfaceTexture);
                    AppMethodBeat.o(138817);
                }
            });
        }
        AppMethodBeat.o(138828);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void PQ() {
        AppMethodBeat.i(138829);
        if (this.cEP != null) {
            this.cEP.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass26 */

                public final void run() {
                    AppMethodBeat.i(138818);
                    a.a(a.this);
                    AppMethodBeat.o(138818);
                }
            });
        }
        AppMethodBeat.o(138829);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138830);
        if (this.cEP != null) {
            this.cEP.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass27 */

                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0084, code lost:
                    if (r0 == false) goto L_0x0086;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 2061
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass27.run():void");
                }
            });
        }
        AppMethodBeat.o(138830);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, JSONObject jSONObject) {
        AppMethodBeat.i(138831);
        if (jSONObject.has("needEvent")) {
            this.cEJ = jSONObject.optBoolean("needEvent", false);
            if (PS()) {
                this.cEB.m(aVar);
            }
        }
        AppMethodBeat.o(138831);
    }

    /* access modifiers changed from: package-private */
    public final void i(JSONObject jSONObject) {
        JSONObject optJSONObject;
        AppMethodBeat.i(138832);
        if (jSONObject.has("position") && (optJSONObject = jSONObject.optJSONObject("position")) != null) {
            this.cEF = com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONObject.optInt("width", 0));
            this.cEG = com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONObject.optInt("height", 0));
            Log.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", Integer.valueOf(this.cEF), Integer.valueOf(this.cEG));
            PR();
        }
        AppMethodBeat.o(138832);
    }

    private void PR() {
        AppMethodBeat.i(138833);
        if (!(this.cEF == 0 || this.cEG == 0 || this.mSurfaceTexture == null || this.cEz == null)) {
            Log.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", Integer.valueOf(this.cEF), Integer.valueOf(this.cEG));
            this.mSurfaceTexture.setDefaultBufferSize(this.cEF, this.cEG);
            if (!PT() || !this.cES) {
                this.cEz.bV(this.cEF, this.cEG);
            } else {
                Log.i(getLogTag(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
                AppMethodBeat.o(138833);
                return;
            }
        }
        AppMethodBeat.o(138833);
    }

    /* access modifiers changed from: package-private */
    public final void release() {
        AppMethodBeat.i(138834);
        if (this.cEC != null) {
            this.cEC.l(this.cED);
        }
        if (this.cEz != null) {
            b bVar = this.cEz;
            if (!bVar.mInited) {
                new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-3, "uninited livePlayer");
            } else {
                bVar.cFu.stopPlay(true);
                bVar.cFu.setPlayListener(null);
                bVar.mInited = false;
                new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
            }
            this.cEz = null;
        }
        if (this.mSurface != null) {
            this.mSurface.release();
            this.mSurface = null;
        }
        if (this.cED != null) {
            this.cED.Pu();
            this.cEE = null;
        }
        Log.i(getLogTag(), "LivePlayer release handler thread");
        if (this.cEP != null) {
            this.cEP.removeCallbacksAndMessages(null);
        }
        if (this.cEQ != null) {
            this.cEQ.quitSafely();
        }
        h.RTc.aV(new Runnable() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(215572);
                Log.i(a.this.getLogTag(), "release, abandonFocus");
                a.this.cEM.bJJ();
                AppMethodBeat.o(215572);
            }
        });
        AppMethodBeat.o(138834);
    }

    /* access modifiers changed from: package-private */
    public final void hV(int i2) {
        AppMethodBeat.i(138835);
        if (this.cEA != null) {
            this.cEA.aW((long) i2);
        }
        AppMethodBeat.o(138835);
    }

    /* access modifiers changed from: package-private */
    public final boolean PS() {
        return this.cEB != null;
    }

    /* access modifiers changed from: package-private */
    public final boolean PT() {
        AppMethodBeat.i(215598);
        boolean d2 = this.cEV.d(this.cED);
        AppMethodBeat.o(215598);
        return d2;
    }

    public final boolean e(Surface surface) {
        AppMethodBeat.i(215599);
        if (this.cEz != null) {
            if (!this.cFe.get()) {
                this.cEz.f(surface);
            } else {
                Log.i(getLogTag(), "setSurface, JustPlayAudio");
            }
            AppMethodBeat.o(215599);
            return true;
        }
        Log.w(getLogTag(), "setSurface, Adapter is null");
        AppMethodBeat.o(215599);
        return false;
    }

    public final boolean bU(int i2, int i3) {
        AppMethodBeat.i(215600);
        Log.d(getLogTag(), "setSurfaceSize, width: %d, height: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 || i3 == 0 || this.cEz == null) {
            Log.w(getLogTag(), "setSurfaceSize, Adapter is null");
            AppMethodBeat.o(215600);
            return false;
        }
        if (!this.cFe.get()) {
            this.cEz.bV(i2, i3);
        } else {
            Log.i(getLogTag(), "setSurfaceSize, JustPlayAudio");
        }
        AppMethodBeat.o(215600);
        return true;
    }

    public final String getKey() {
        AppMethodBeat.i(177133);
        String str = Lb() + "@" + hashCode();
        AppMethodBeat.o(177133);
        return str;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.o
    public final void PG() {
        AppMethodBeat.i(215601);
        if (this.cEP != null) {
            this.cEP.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(215579);
                    if (a.this.cEz != null) {
                        a.this.cEz.e("stop", null);
                        a.this.dS("stop");
                        b bVar = a.this.cEz;
                        if (bVar.cFv != null) {
                            bVar.cFv.onPlayEvent(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, new Bundle());
                        }
                    }
                    AppMethodBeat.o(215579);
                }
            });
        }
        AppMethodBeat.o(215601);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.o
    public final String PH() {
        AppMethodBeat.i(215602);
        String format = String.format("%s_%s", this.type, Integer.valueOf(getId()));
        AppMethodBeat.o(215602);
        return format;
    }

    public final void PU() {
        AppMethodBeat.i(215603);
        if (this.cEz != null && !this.cEz.cFu.isPlaying()) {
            dR(AssetExtension.SCENE_PLAY);
        }
        AppMethodBeat.o(215603);
    }

    public final void dR(final String str) {
        AppMethodBeat.i(177134);
        if (this.cEP != null) {
            this.cEP.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass17 */

                public final void run() {
                    AppMethodBeat.i(215581);
                    if (a.this.cEz == null) {
                        Log.w(a.this.getLogTag(), "run#operate, adapter is null");
                        AppMethodBeat.o(215581);
                        return;
                    }
                    a.this.cEz.e(str, null);
                    a.this.dS(str);
                    AppMethodBeat.o(215581);
                }
            });
        }
        AppMethodBeat.o(177134);
    }

    /* access modifiers changed from: package-private */
    public final void dS(final String str) {
        boolean z = true;
        AppMethodBeat.i(215604);
        if (str.equalsIgnoreCase("pause")) {
            if (this.cEX != null) {
                this.cEX.onPause();
            } else {
                this.cEY = 4;
            }
            if (this.cEC != null) {
                this.cEC.hY(2006);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            if (this.cEX != null) {
                this.cEX.onStop();
            } else {
                this.cEY = 6;
            }
            if (this.cEC != null) {
                this.cEC.hY(2006);
            }
        } else {
            z = false;
        }
        if (z) {
            h.RTc.aV(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.AnonymousClass18 */

                public final void run() {
                    AppMethodBeat.i(215582);
                    Log.i(a.this.getLogTag(), "operate " + str + ", abandonFocus");
                    a.this.cEM.bJJ();
                    AppMethodBeat.o(215582);
                }
            });
        }
        AppMethodBeat.o(215604);
    }

    /* access modifiers changed from: package-private */
    public final boolean isPlaying() {
        AppMethodBeat.i(215605);
        if (this.cEz == null || !this.cEz.cFu.isPlaying()) {
            AppMethodBeat.o(215605);
            return false;
        }
        AppMethodBeat.o(215605);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean isMuted() {
        return this.cEz != null && this.cEz.mMuteAudio;
    }

    /* access modifiers changed from: package-private */
    public final boolean PV() {
        AppMethodBeat.i(215606);
        if (this.cED == null) {
            Log.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
            AppMethodBeat.o(215606);
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.ag.a f2 = e.f(this.cED);
        if (f2 == null) {
            Log.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(215606);
            return false;
        }
        boolean a2 = f2.a(this);
        AppMethodBeat.o(215606);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void i(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(215607);
        Log.d(getLogTag(), "disableBackgroundPlayAudio");
        if (this.cFa) {
            Log.w(getLogTag(), "disableBackgroundPlayAudio, mIsRTCMode");
            aVar.dP("fail");
            AppMethodBeat.o(215607);
            return;
        }
        Log.d(getLogTag(), "disableBackgroundPlayAudioInternal");
        if (aVar == null) {
            Log.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
            z = false;
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.ag.a f2 = e.f(aVar);
            if (f2 == null) {
                Log.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
                z = false;
            } else {
                f2.c(this);
                z = true;
            }
        }
        if (z) {
            this.cFe.set(false);
            if (this.cEz != null) {
                this.cEz.f(this.mSurface);
            }
            this.cFc = false;
            if (this.cEB != null) {
                this.cEB.v(getId(), false);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i(getLogTag(), "disableBackgroundPlayAudio, result:%s", Boolean.valueOf(z2));
        aVar.dP(z2 ? "ok" : "fail");
        AppMethodBeat.o(215607);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.i
    public final String getName() {
        AppMethodBeat.i(215608);
        String key = getKey();
        AppMethodBeat.o(215608);
        return key;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.i
    public final <AddOn extends j> void a(Class<AddOn> cls, AddOn addon) {
        AppMethodBeat.i(215609);
        Log.i(getLogTag(), "setAddOn for " + cls.getSimpleName());
        this.cFd.a(cls, addon);
        AppMethodBeat.o(215609);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.i
    public final <AddOn extends j> AddOn X(Class<AddOn> cls) {
        AppMethodBeat.i(215610);
        Log.i(getLogTag(), "getAddOn for " + cls.getSimpleName());
        AddOn addon = (AddOn) this.cFd.X(cls);
        AppMethodBeat.o(215610);
        return addon;
    }

    static /* synthetic */ void a(a aVar, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(215611);
        super.e(surfaceTexture);
        Log.i(aVar.getLogTag(), "*** handler(%s) handlePluginReady", aVar.Lb());
        aVar.mSurfaceTexture = surfaceTexture;
        aVar.mSurface = new Surface(surfaceTexture);
        if (aVar.cEz != null) {
            if (!aVar.cFe.get()) {
                aVar.cEz.f(aVar.mSurface);
            } else {
                Log.i(aVar.getLogTag(), "setSurface, JustPlayAudio");
            }
            aVar.PR();
        }
        AppMethodBeat.o(215611);
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(215612);
        super.PQ();
        Log.i(aVar.getLogTag(), "*** handler(%s) handlePluginDestroy", aVar.Lb());
        AppMethodBeat.o(215612);
    }
}
