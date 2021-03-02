package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.memory.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b {
    private static HashMap<String, WeakReference<Bitmap>> DmQ = new HashMap<>();
    private static Map<String, Integer> DmU = new ConcurrentHashMap();
    private WeakReference<View> DmA;
    private Animation DmB;
    private Animation DmC;
    boolean DmM;
    public boolean DmN;
    public boolean DmR;
    double DmS;
    boolean DmT;
    double DmV;
    private boolean DmW;
    boolean DmX;
    private int Dmo;
    private int Dmp;
    String Dmq;
    int Dmr;
    protected int Dmt;
    private Bitmap Dmu;
    private Bitmap Dmv;
    private Bitmap Dmw;
    WeakReference<View> Dmx;
    WeakReference<TextView> Dmy;
    private long Dmz;
    e EhA;
    f EhB;
    g EhC;
    volatile h Ehs;
    private volatile RunnableC1723b Eht;
    volatile i Ehu;
    private volatile c Ehv;
    private k Ehw;
    private j Ehx;
    private d Ehy;
    private a Ehz;
    String cJp;
    private MMHandler czp;
    private boolean jiQ;
    boolean jqj;
    private Surface mSurface;
    int position;

    public interface e {
        void Zb(int i2);
    }

    public interface f {
        void JB(long j2);
    }

    public interface g {
        int eVF();

        View eVG();

        int eVH();
    }

    public abstract void at(Bitmap bitmap);

    public abstract void eo(int i2, int i3);

    static /* synthetic */ void a(b bVar, int i2, int i3) {
        boolean z;
        Log.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(bVar.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
        if (bVar.Dmu == null) {
            bVar.Dmu = o.itM.a(new o.b(i2, i3));
            Log.printDebugStack("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", bVar.cJp);
        } else if (bVar.Dmu.getWidth() != i2 || bVar.Dmu.getHeight() != i3) {
            Log.w("MicroMsg.SightPlayController", "reset bmp, old value " + bVar.Dmu.getWidth() + "*" + bVar.Dmu.getHeight());
            if (!com.tencent.mm.compatible.util.d.oD(19) || bVar.Dmu.getAllocationByteCount() < i3 * i2 * 4) {
                z = false;
            } else {
                try {
                    Log.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    bVar.Dmu.reconfigure(i2, i3, Bitmap.Config.ARGB_8888);
                    z = true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e2.getMessage());
                    z = false;
                }
            }
            if (!z) {
                o.itM.f(bVar.Dmu);
                bVar.Dmu = o.itM.a(new o.b(i2, i3));
            }
            Log.printDebugStack("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", bVar.cJp);
        }
    }

    static /* synthetic */ int w(b bVar) {
        int i2 = bVar.Dmo;
        bVar.Dmo = i2 + 1;
        return i2;
    }

    public b(View view) {
        this.jiQ = false;
        this.Dmo = 0;
        this.Dmp = 0;
        this.cJp = "";
        this.Dmq = "";
        this.Dmr = -1;
        this.Dmt = 41;
        this.DmM = true;
        this.DmN = false;
        this.DmR = false;
        this.jqj = true;
        this.DmS = -1.0d;
        this.DmT = false;
        this.DmV = -1.0d;
        this.DmW = false;
        this.DmX = false;
        this.Dmp = 0;
        this.czp = new MMHandler(Looper.getMainLooper());
        this.DmA = new WeakReference<>(view);
        Log.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", 0);
    }

    /* access modifiers changed from: protected */
    public int eVx() {
        return -1;
    }

    public final void uD(boolean z) {
        if (this.Ehs != null) {
            com.tencent.mm.modelvideo.o.I(this.Ehs);
            this.Ehs.stop = true;
        }
        if (this.Ehv != null) {
            this.czp.removeCallbacks(this.Ehv);
            this.Ehv.stop = true;
        }
        if (this.Eht != null) {
            com.tencent.mm.modelvideo.o.I(this.Eht);
            this.Eht.stop = true;
        }
        if (this.Ehu != null) {
            this.Ehu.type = z ? 0 : 2;
            com.tencent.mm.modelvideo.o.g(this.Ehu, 0);
        }
    }

    public final boolean eVy() {
        return 1 == this.Dmp ? this.Eht != null && !this.Eht.stop : this.Ehv != null && !this.Ehv.stop && this.Eht != null && !this.Eht.stop;
    }

    public final void restart() {
        boolean z;
        Log.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.DmM), this.cJp, Integer.valueOf(this.Dmr));
        if (!this.DmM) {
            clear();
        } else if (eVy()) {
            Log.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", Integer.valueOf(hashCode()), this.cJp);
        } else {
            if (this.Dmr < 0) {
                z = true;
            } else {
                z = false;
            }
            uD(z);
            this.Dmz = 0;
            if (eVz()) {
                Log.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.Dmr < 0) {
                Log.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.cJp);
                if (Util.isNullOrNil(this.cJp)) {
                    return;
                }
                if (!aNy(this.cJp)) {
                    Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                    return;
                }
                this.Ehs = new h(this, (byte) 0);
                com.tencent.mm.modelvideo.o.g(this.Ehs, 0);
            } else if (1 == this.Dmp) {
                this.Eht = new RunnableC1723b(this, (byte) 0);
                this.Ehv = null;
                com.tencent.mm.modelvideo.o.g(this.Eht, 0);
            } else {
                this.Eht = new RunnableC1723b(this, (byte) 0);
                this.Ehv = new c();
                this.Eht.EhE = this.Ehv;
                this.Ehv.EhG = this.Eht;
                com.tencent.mm.modelvideo.o.g(this.Eht, 0);
            }
        }
    }

    public final void clear() {
        Log.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.Dmr), Boolean.valueOf(eVy()));
        uD(true);
        this.Dmz = 0;
        XF(this.Dmr);
        this.Dmr = -1;
        this.cJp = "";
        this.Dmq = "ERROR#PATH";
        this.Dmw = null;
        this.DmS = 0.0d;
        this.DmT = false;
        o.itM.f(this.Dmu);
        this.Dmu = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void XF(final int i2) {
        com.tencent.mm.modelvideo.o.g(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(96872);
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i2);
                Log.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(b.this.hashCode()), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(96872);
            }
        }, 0);
    }

    public static boolean aNy(String str) {
        if (Util.isNullOrNil(str)) {
            return false;
        }
        Integer num = DmU.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean eVz() {
        if (this.DmR) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.Dmo < 3) {
                return false;
            }
            Log.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
            this.Dmo = 0;
            return false;
        } else if (this.Dmo >= 3) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void eVA() {
        int max = Math.max(1, (int) SightVideoJNI.getVideoRate(this.Dmr));
        this.Dmt = 1000 / max;
        Log.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", Integer.valueOf(hashCode()), Integer.valueOf(max), Integer.valueOf(this.Dmt));
    }

    /* access modifiers changed from: package-private */
    public class i implements Runnable {
        double DmV;
        MediaPlayer Dnk;
        int type;

        private i() {
            this.DmV = -1.0d;
        }

        /* synthetic */ i(b bVar, byte b2) {
            this();
        }

        private void euh() {
            AppMethodBeat.i(96888);
            Log.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.Dnk != null) {
                    this.Dnk.stop();
                    this.Dnk.release();
                    this.Dnk = null;
                }
                AppMethodBeat.o(96888);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SightPlayController", e2, "stop play sound error: %s", e2.getMessage());
                this.Dnk = null;
                AppMethodBeat.o(96888);
            }
        }

        public final double eVI() {
            AppMethodBeat.i(96889);
            if (this.Dnk == null) {
                AppMethodBeat.o(96889);
                return 0.0d;
            }
            double currentPosition = (double) this.Dnk.getCurrentPosition();
            AppMethodBeat.o(96889);
            return currentPosition;
        }

        public final void run() {
            String str;
            AppMethodBeat.i(96890);
            Object[] objArr = new Object[1];
            switch (this.type) {
                case 0:
                    str = "stop";
                    break;
                case 1:
                    str = "start";
                    break;
                case 2:
                    str = "pause";
                    break;
                case 3:
                    str = "resume";
                    break;
                case 4:
                    str = "seek";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objArr[0] = str;
            Log.i("MicroMsg.SightPlayController", "do play sound, operation %s", objArr);
            switch (this.type) {
                case 0:
                    euh();
                    AppMethodBeat.o(96890);
                    return;
                case 1:
                    euh();
                    if (!Util.isNullOrNil(b.this.cJp)) {
                        try {
                            this.Dnk = new com.tencent.mm.compatible.b.k();
                            this.Dnk.setDisplay(null);
                            this.Dnk.reset();
                            this.Dnk.setDataSource(b.this.cJp);
                            this.Dnk.setAudioStreamType(3);
                            this.Dnk.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.i.AnonymousClass1 */

                                public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                                    AppMethodBeat.i(96887);
                                    Log.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", b.this.cJp, Integer.valueOf(i2), Integer.valueOf(i3));
                                    b.this.clear();
                                    if (b.this.EhA != null) {
                                        b.this.EhA.Zb(-1);
                                    }
                                    AppMethodBeat.o(96887);
                                    return true;
                                }
                            });
                            this.Dnk.prepare();
                            this.Dnk.start();
                            AppMethodBeat.o(96890);
                            return;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.SightPlayController", e2, "play sound error: %s", e2.getMessage());
                            Log.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", b.this.cJp);
                            b.this.clear();
                            if (b.this.EhA != null) {
                                b.this.EhA.Zb(-1);
                            }
                            AppMethodBeat.o(96890);
                            return;
                        }
                    }
                    break;
                case 2:
                    try {
                        if (this.Dnk != null && this.Dnk.isPlaying()) {
                            this.Dnk.pause();
                        }
                        AppMethodBeat.o(96890);
                        return;
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.SightPlayController", e3, "pause sound error: %s", e3.getMessage());
                        euh();
                        AppMethodBeat.o(96890);
                        return;
                    }
                case 3:
                    try {
                        if (this.Dnk != null) {
                            this.Dnk.start();
                        }
                        AppMethodBeat.o(96890);
                        return;
                    } catch (Exception e4) {
                        Log.printErrStackTrace("MicroMsg.SightPlayController", e4, "pause sound error: %s", e4.getMessage());
                        euh();
                        AppMethodBeat.o(96890);
                        return;
                    }
                case 4:
                    try {
                        Log.i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.DmV));
                        this.Dnk.seekTo((int) (this.DmV * 1000.0d));
                        AppMethodBeat.o(96890);
                        return;
                    } catch (Exception e5) {
                        Log.printErrStackTrace("MicroMsg.SightPlayController", e5, "seek sound error: %s", e5.getMessage());
                        break;
                    }
            }
            AppMethodBeat.o(96890);
        }
    }

    /* access modifiers changed from: package-private */
    public class h implements Runnable {
        volatile boolean stop;

        private h() {
            this.stop = false;
        }

        /* synthetic */ h(b bVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(96886);
            if (b.this.eVz()) {
                Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                AppMethodBeat.o(96886);
                return;
            }
            b.this.Dmr = SightVideoJNI.openFileVFS(b.this.cJp, 1 == b.this.Dmp ? 0 : 1, 1, false);
            if (b.this.Dmr < 0) {
                Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.Dmr), b.this.cJp);
                b.this.fdR();
                if (b.this.EhA != null) {
                    b.this.EhA.Zb(-1);
                }
                AppMethodBeat.o(96886);
                return;
            }
            if (((Boolean) AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.FALSE)).booleanValue()) {
                if (b.this.Ehx == null) {
                    b.this.Ehx = new j(b.this, (byte) 0);
                }
                b.this.czp.removeCallbacks(b.this.Ehx);
                b.this.czp.post(b.this.Ehx);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(b.this.Dmr));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(b.this.Dmr));
            if (b.this.Dmp == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    Log.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    AppMethodBeat.o(96886);
                    return;
                }
                b.a(b.this, max, max2);
            }
            b.this.eVA();
            if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
                Log.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", Integer.valueOf(max), Integer.valueOf(max2));
                if (!Util.isNullOrNil(b.this.cJp)) {
                    b.DmU.put(b.this.cJp, 2);
                }
                b.this.Dmz = 0;
                b.this.XF(b.this.Dmr);
                b.this.Dmr = -1;
                b.this.cJp = "";
                b.this.Dmq = "ERROR#PATH";
                b.this.Dmw = null;
                this.stop = true;
                if (b.this.EhA != null) {
                    b.this.EhA.Zb(-1);
                }
                AppMethodBeat.o(96886);
                return;
            }
            b.this.eo(max, max2);
            if (1 == b.this.Dmp) {
                b.this.Eht = new RunnableC1723b(b.this, (byte) 0);
                b.this.Ehv = null;
                if (!this.stop) {
                    com.tencent.mm.modelvideo.o.g(b.this.Eht, 0);
                }
            } else {
                b.this.Eht = new RunnableC1723b(b.this, (byte) 0);
                b.this.Ehv = new c();
                b.this.Eht.EhE = b.this.Ehv;
                b.this.Ehv.EhG = b.this.Eht;
                if (!this.stop) {
                    com.tencent.mm.modelvideo.o.g(b.this.Eht, 0);
                }
            }
            if (this.stop) {
                Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop));
            }
            AppMethodBeat.o(96886);
        }
    }

    public final void fdR() {
        Log.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", Boolean.TRUE);
        com.tencent.mm.modelvideo.o.I(this.Ehw);
        if (this.Ehw == null) {
            this.Ehw = new k(this, (byte) 0);
        }
        this.Ehw.Dnm = new WeakReference<>(null);
        com.tencent.mm.modelvideo.o.g(this.Ehw, 0);
    }

    /* access modifiers changed from: package-private */
    public class j implements Runnable {
        private j() {
        }

        /* synthetic */ j(b bVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(96891);
            if (b.this.Dmr < 0 || b.this.Dmy == null || b.this.Dmy.get() == null) {
                AppMethodBeat.o(96891);
                return;
            }
            ((TextView) b.this.Dmy.get()).setText(SightVideoJNI.getVideoInfo(b.this.Dmr));
            AppMethodBeat.o(96891);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(b bVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(96885);
            if (b.this.DmA.get() == null) {
                AppMethodBeat.o(96885);
                return;
            }
            ((View) b.this.DmA.get()).startAnimation(b.this.DmB);
            AppMethodBeat.o(96885);
        }
    }

    /* access modifiers changed from: package-private */
    public class k implements Runnable {
        WeakReference<Bitmap> Dnm;

        private k() {
            AppMethodBeat.i(96895);
            this.Dnm = new WeakReference<>(null);
            AppMethodBeat.o(96895);
        }

        /* synthetic */ k(b bVar, byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0263, code lost:
            r0 = (android.view.View) r11.EhD.Dmx.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 689
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.k.run():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$b  reason: collision with other inner class name */
    public class RunnableC1723b implements Runnable {
        c EhE;
        volatile boolean stop;

        private RunnableC1723b() {
            this.stop = false;
        }

        /* synthetic */ RunnableC1723b(b bVar, byte b2) {
            this();
        }

        public final void run() {
            float f2;
            boolean z;
            AppMethodBeat.i(96882);
            if (!(b.this.EhC == null || b.this.EhC.eVG() == null || b.this.EhC.eVG().getVisibility() != 0)) {
                b.this.czp.post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.RunnableC1723b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96877);
                        b.this.EhC.eVG().setVisibility(8);
                        AppMethodBeat.o(96877);
                    }
                });
            }
            if (b.this.Dmr < 0) {
                Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.this.cJp);
                AppMethodBeat.o(96882);
            } else if (this.stop) {
                Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.o(96882);
            } else {
                if (b.this.Dmz == 0) {
                    if (b.this.Ehu != null) {
                        b.this.Ehu.type = 1;
                        b.this.Ehu.run();
                    }
                    b.this.Dmz = System.currentTimeMillis();
                }
                boolean z2 = false;
                if (b.this.DmV != -1.0d) {
                    if (!b.this.DmN) {
                        if (SightVideoJNI.seekStream(b.this.DmV, b.this.Dmr) > 0) {
                            if (b.this.Ehu == null) {
                                b.this.Ehu = new i(b.this, (byte) 0);
                            }
                            b.this.Ehu.type = 4;
                            b.this.Ehu.DmV = b.this.DmV;
                            b.this.Ehu.run();
                            z2 = true;
                        }
                    } else if (b.this.Ehu != null) {
                        b.this.Ehu.type = 4;
                        b.this.Ehu.DmV = b.this.DmV;
                        b.this.Ehu.run();
                        b.this.czp.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.RunnableC1723b.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(96878);
                                b.this.DmW = true;
                                AppMethodBeat.o(96878);
                            }
                        }, 100);
                    } else if (SightVideoJNI.seekStream(b.this.DmV, b.this.Dmr) > 0) {
                        if (b.this.Ehu == null) {
                            b.this.Ehu = new i(b.this, (byte) 0);
                        }
                        b.this.Ehu.type = 4;
                        b.this.Ehu.DmV = b.this.DmV;
                        b.this.Ehu.run();
                        z2 = true;
                    }
                }
                float currentTimeMillis = (float) (System.currentTimeMillis() - b.this.Dmz);
                if (z2) {
                    f2 = 0.0f;
                } else {
                    f2 = (currentTimeMillis / ((float) b.this.Dmt)) + 0.5f;
                }
                if (b.this.DmN && b.this.DmW) {
                    b.this.DmW = false;
                    if (b.this.Ehu != null) {
                        double eVI = b.this.Ehu.eVI() / 1000.0d;
                        if (SightVideoJNI.seekStream(eVI, b.this.Dmr) > 0) {
                            f2 = 0.0f;
                            Log.i("MicroMsg.SightPlayController", "seek to " + eVI + " modify time : 0.0");
                        }
                    }
                }
                if (b.this.jiQ) {
                    Log.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.Dmr), Float.valueOf(currentTimeMillis), Float.valueOf(f2));
                }
                b.this.Dmz = System.currentTimeMillis();
                if (f2 >= 2.0f) {
                    b.w(b.this);
                } else {
                    b.this.Dmo = Math.max(0, b.this.Dmo - 1);
                }
                if (b.this.eVz()) {
                    Log.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", Integer.valueOf(b.this.Dmo));
                    b.this.clear();
                    AppMethodBeat.o(96882);
                    return;
                }
                boolean z3 = false;
                int i2 = 0;
                if (1 == b.this.Dmp) {
                    if (b.this.mSurface == null || b.this.mSurface.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(b.this.Dmr, b.this.mSurface, (int) f2, b.this.Dmv, b.this.jqj);
                        if (b.this.EhB != null) {
                            double videoPlayTime = SightVideoJNI.getVideoPlayTime(b.this.Dmr);
                            int i3 = (int) videoPlayTime;
                            if (i3 != ((int) b.this.DmS)) {
                                b.this.EhB.JB((long) i3);
                            }
                            b.this.DmS = videoPlayTime;
                        }
                        if (i2 == 0) {
                            b.this.DmV = -1.0d;
                            z = false;
                        } else if (1 == i2) {
                            b.this.DmV = -1.0d;
                            z = true;
                            b.this.Dmz = 0;
                            b.A(b.this);
                        } else if (-7 == i2) {
                            Log.w("MicroMsg.SightPlayController", "surface is null, continue");
                            z = false;
                        } else {
                            Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                            this.stop = true;
                            if (this.EhE != null) {
                                this.EhE.stop = true;
                            }
                            b.this.fdR();
                            if (b.this.EhA != null) {
                                b.this.EhA.Zb(-1);
                            }
                            z = false;
                        }
                    } else {
                        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                        this.stop = true;
                        if (this.EhE != null) {
                            this.EhE.stop = true;
                            z = false;
                        }
                        z = false;
                    }
                    if (b.this.Ehu != null) {
                        Log.d("MicroMsg.SightPlayController", "voice time is" + (b.this.Ehu.eVI() / 1000.0d));
                        z3 = z;
                    } else {
                        z3 = z;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(b.this.Dmr, b.this.Dmu, (int) f2, null, false, b.this.jqj);
                    if (b.this.EhB != null) {
                        double videoPlayTime2 = SightVideoJNI.getVideoPlayTime(b.this.Dmr);
                        int i4 = (int) videoPlayTime2;
                        if (i4 != ((int) b.this.DmS)) {
                            b.this.EhB.JB((long) i4);
                        }
                        b.this.DmS = videoPlayTime2;
                        if (b.this.jiQ) {
                            Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(videoPlayTime2));
                        }
                    } else if (b.this.jiQ) {
                        double videoPlayTime3 = SightVideoJNI.getVideoPlayTime(b.this.Dmr);
                        if (b.this.jiQ) {
                            Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(videoPlayTime3));
                        }
                    } else if (b.this.jiQ) {
                        Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                    }
                    if (i2 == 0) {
                        b.this.DmV = -1.0d;
                    } else if (1 == i2) {
                        b.this.DmV = -1.0d;
                        z3 = true;
                        b.this.Dmz = 0;
                        b.A(b.this);
                    } else {
                        b.this.DmV = -1.0d;
                        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                        this.stop = true;
                        if (this.EhE != null) {
                            this.EhE.stop = true;
                        }
                        b.this.czp.post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.RunnableC1723b.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(96879);
                                b.this.at(null);
                                AppMethodBeat.o(96879);
                            }
                        });
                        if (b.this.EhA != null) {
                            b.this.EhA.Zb(-1);
                        }
                    }
                }
                if (1 == i2) {
                    b.this.czp.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.RunnableC1723b.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(96880);
                            if (b.this.EhA != null) {
                                b.this.EhA.Zb(0);
                            }
                            AppMethodBeat.o(96880);
                        }
                    });
                }
                if (this.stop) {
                    Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                    if (b.this.Ehu != null) {
                        b.this.Ehu.type = 0;
                        b.this.Ehu.run();
                    }
                    AppMethodBeat.o(96882);
                    return;
                }
                if (1 == b.this.Dmp) {
                    long currentTimeMillis2 = ((long) b.this.Dmt) - (System.currentTimeMillis() - b.this.Dmz);
                    if (b.this.Dmz == 0) {
                        com.tencent.mm.modelvideo.o.g(this, (long) (b.this.Dmt * 5));
                    } else if (currentTimeMillis2 > 0) {
                        com.tencent.mm.modelvideo.o.g(this, currentTimeMillis2);
                    } else {
                        com.tencent.mm.modelvideo.o.g(this, 0);
                    }
                } else if (!z3 || b.this.EhC == null) {
                    this.EhE.Dni = i2;
                    b.this.czp.post(this.EhE);
                } else {
                    int eVF = b.this.EhC.eVF();
                    b.this.czp.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.RunnableC1723b.AnonymousClass5 */

                        public final void run() {
                            View eVG;
                            AppMethodBeat.i(96881);
                            if (!(b.this.EhC == null || (eVG = b.this.EhC.eVG()) == null)) {
                                if (!(b.this.DmC != null || b.this.EhC.eVH() == -1 || b.this.DmA.get() == null)) {
                                    b.this.DmC = AnimationUtils.loadAnimation(((View) b.this.DmA.get()).getContext(), b.this.EhC.eVH());
                                }
                                if (b.this.DmC != null) {
                                    eVG.startAnimation(b.this.DmC);
                                }
                                eVG.setVisibility(0);
                            }
                            AppMethodBeat.o(96881);
                        }
                    });
                    this.EhE.Dni = i2;
                    b.this.czp.postDelayed(this.EhE, (long) eVF);
                }
                if (b.this.Ehu != null) {
                    Log.d("MicroMsg.SightPlayController", "voice time is" + (b.this.Ehu.eVI() / 1000.0d));
                }
                AppMethodBeat.o(96882);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {
        int Dni;
        RunnableC1723b EhG;
        volatile boolean stop = false;

        public c() {
            AppMethodBeat.i(96883);
            Log.i("MicroMsg.SightPlayController", "make sure drawJob alive");
            AppMethodBeat.o(96883);
        }

        public final void run() {
            AppMethodBeat.i(96884);
            if (this.stop) {
                Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.o(96884);
                return;
            }
            b.this.at(b.this.Dmu);
            if (b.this.Dmz == 0) {
                com.tencent.mm.modelvideo.o.g(this.EhG, 0);
                AppMethodBeat.o(96884);
                return;
            }
            long currentTimeMillis = ((long) b.this.Dmt) - (System.currentTimeMillis() - b.this.Dmz);
            if (currentTimeMillis > 0) {
                com.tencent.mm.modelvideo.o.g(this.EhG, currentTimeMillis);
                AppMethodBeat.o(96884);
                return;
            }
            com.tencent.mm.modelvideo.o.g(this.EhG, 0);
            AppMethodBeat.o(96884);
        }
    }

    public final IListener eVB() {
        if (this.Ehz == null) {
            this.Ehz = new a(this);
        }
        return this.Ehz;
    }

    static class a extends IListener<yh> {
        int Dne = 0;
        WeakReference<b> Dnf;
        int tex = 0;
        int wqJ = 0;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yh yhVar) {
            AppMethodBeat.i(96876);
            yh yhVar2 = yhVar;
            if (this.Dnf.get() != null) {
                Log.d("MicroMsg.SightPlayController", "#0x%x on chatting status callback, type %d, selfPos %d, visiblePos[%d, %d], headerCount %d recording %B", Integer.valueOf(this.Dnf.get().hashCode()), Integer.valueOf(yhVar2.eeC.type), Integer.valueOf(this.Dnf.get().position), Integer.valueOf(yhVar2.eeC.eeD), Integer.valueOf(yhVar2.eeC.eeE), Integer.valueOf(yhVar2.eeC.eeF), Boolean.valueOf(this.Dnf.get().DmX));
                switch (yhVar2.eeC.type) {
                    case 0:
                        a(yhVar2);
                        if (eVE() && !this.Dnf.get().DmX) {
                            this.Dnf.get().restart();
                            break;
                        }
                    case 1:
                        this.Dnf.get().uD(false);
                        break;
                    case 3:
                        this.Dnf.get().clear();
                        break;
                    case 5:
                        a(yhVar2);
                        if (eVE() && !this.Dnf.get().DmX) {
                            if (!"ERROR#PATH".equals(this.Dnf.get().Dmq) && !this.Dnf.get().cJp.equals(this.Dnf.get().Dmq)) {
                                Log.d("MicroMsg.SightPlayController", "match diff path, change %s to %s", this.Dnf.get().cJp, this.Dnf.get().Dmq);
                                String str = this.Dnf.get().Dmq == null ? "" : this.Dnf.get().Dmq;
                                this.Dnf.get().clear();
                                this.Dnf.get().cJp = str;
                                this.Dnf.get().Dmq = "ERROR#PATH";
                            }
                            this.Dnf.get().restart();
                            break;
                        } else {
                            this.Dnf.get().clear();
                            break;
                        }
                        break;
                    case 6:
                        this.Dnf.get().DmX = true;
                        this.Dnf.get().uD(false);
                        break;
                    case 7:
                        if (this.Dnf.get().DmX) {
                            this.Dnf.get().DmX = false;
                            a(yhVar2);
                            this.Dnf.get().restart();
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(96876);
            return false;
        }

        public a(b bVar) {
            super(0);
            AppMethodBeat.i(96874);
            this.Dnf = new WeakReference<>(bVar);
            this.__eventId = yh.class.getName().hashCode();
            AppMethodBeat.o(96874);
        }

        private void a(yh yhVar) {
            this.wqJ = yhVar.eeC.eeF;
            this.Dne = yhVar.eeC.eeD;
            this.tex = yhVar.eeC.eeE;
        }

        private boolean eVE() {
            AppMethodBeat.i(96875);
            if (this.Dnf.get() == null) {
                AppMethodBeat.o(96875);
                return false;
            }
            int i2 = this.Dnf.get().position + this.wqJ;
            if (i2 < this.Dne || i2 > this.tex) {
                AppMethodBeat.o(96875);
                return false;
            }
            AppMethodBeat.o(96875);
            return true;
        }
    }

    static /* synthetic */ void A(b bVar) {
        if (bVar.DmA != null && -1 != bVar.eVx()) {
            if (bVar.DmB == null && bVar.DmA.get() != null) {
                bVar.DmB = AnimationUtils.loadAnimation(bVar.DmA.get().getContext(), bVar.eVx());
            }
            if (bVar.Ehy == null) {
                bVar.Ehy = new d(bVar, (byte) 0);
            }
            bVar.czp.post(bVar.Ehy);
        }
    }
}
