package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
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
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b {
    private static HashMap<String, WeakReference<Bitmap>> DmQ = new HashMap<>();
    private static Map<String, Integer> DmU = new ConcurrentHashMap();
    public WeakReference<View> DmA;
    private Animation DmB;
    private Animation DmC;
    private volatile h DmD;
    private volatile RunnableC1696b DmE;
    public volatile i DmF;
    private volatile c DmG;
    private k DmH;
    private j DmI;
    private d DmJ;
    private f DmK = new f() {
        /* class com.tencent.mm.plugin.sight.decode.a.b.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.sight.decode.a.b.f
        public final void b(b bVar, long j2) {
        }
    };
    public boolean DmL = true;
    public boolean DmM = true;
    public boolean DmN = false;
    public boolean DmO = false;
    public boolean DmP = false;
    public boolean DmR = false;
    public double DmS = -1.0d;
    boolean DmT = false;
    public double DmV = -1.0d;
    private boolean DmW = false;
    public boolean DmX = false;
    private a DmY;
    public volatile e DmZ;
    private int Dmo = 0;
    private int Dmp = 0;
    private String Dmq = "";
    private int Dmr = -1;
    private Queue<Integer> Dms = new ConcurrentLinkedQueue();
    protected int Dmt = 41;
    private Bitmap Dmu;
    public Bitmap Dmv;
    private Bitmap Dmw;
    private WeakReference<View> Dmx;
    private WeakReference<TextView> Dmy;
    private long Dmz;
    private volatile f Dna;
    public volatile g Dnb;
    public String cJp = "";
    private MMHandler czp;
    private boolean jiQ = false;
    public boolean jqj = true;
    private Surface mSurface;
    public int position;

    public interface e {
        void c(b bVar, int i2);
    }

    public interface f {
        void b(b bVar, long j2);
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

    static /* synthetic */ int y(b bVar) {
        int i2 = bVar.Dmo;
        bVar.Dmo = i2 + 1;
        return i2;
    }

    public static Bitmap a(Context context, int i2, int i3, int i4, int i5) {
        String format = String.format("%s-%s-%s-%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        WeakReference<Bitmap> weakReference = DmQ.get(format);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        if (context == null) {
            Log.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
            return null;
        } else if (i2 <= 0) {
            Log.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
            return null;
        } else if (i3 <= 0 || i5 <= 0 || i4 <= 0) {
            Log.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
            return null;
        } else {
            long currentTicks = Util.currentTicks();
            int i6 = (i3 * i5) / i4;
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) context.getResources().getDrawable(i2);
            ninePatchDrawable.setBounds(0, 0, i3, i6);
            Bitmap createBitmap = Bitmap.createBitmap(i3, i6, Bitmap.Config.ARGB_8888);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            DmQ.put(format, new WeakReference<>(createBitmap));
            Log.d("MicroMsg.SightPlayController", "create mask bmp use %dms", Long.valueOf(Util.ticksToNow(currentTicks)));
            return createBitmap;
        }
    }

    public static void aRR() {
        com.tencent.mm.modelvideo.o.g(new Runnable() {
            /* class com.tencent.mm.plugin.sight.decode.a.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(116073);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    SightVideoJNI.freeAll();
                } catch (Exception e2) {
                    Log.e("MicroMsg.SightPlayController", "free all sight error");
                    Log.printErrStackTrace("MicroMsg.SightPlayController", e2, "", new Object[0]);
                }
                Log.i("MicroMsg.SightPlayController", "free all, use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(116073);
            }
        }, 0);
    }

    public b(int i2, View view) {
        this.Dmp = i2;
        this.czp = new MMHandler(Looper.getMainLooper());
        this.DmA = new WeakReference<>(view);
        Log.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(i2));
    }

    /* access modifiers changed from: protected */
    public int eVx() {
        return -1;
    }

    public final void uD(boolean z) {
        if (this.DmD != null) {
            com.tencent.mm.modelvideo.o.I(this.DmD);
            this.DmD.stop = true;
        }
        if (this.DmG != null) {
            this.czp.removeCallbacks(this.DmG);
            this.DmG.stop = true;
        }
        if (this.DmE != null) {
            com.tencent.mm.modelvideo.o.I(this.DmE);
            this.DmE.stop = true;
        }
        if (this.DmF != null) {
            this.DmF.type = z ? 0 : 2;
            com.tencent.mm.modelvideo.o.g(this.DmF, 0);
        }
    }

    public final boolean eVy() {
        return 1 == this.Dmp ? this.DmE != null && !this.DmE.stop : this.DmG != null && !this.DmG.stop && this.DmE != null && !this.DmE.stop;
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
                this.DmD = new h(this, (byte) 0);
                com.tencent.mm.modelvideo.o.g(this.DmD, 0);
            } else if (1 == this.Dmp) {
                this.DmE = new RunnableC1696b(this, (byte) 0);
                this.DmG = null;
                com.tencent.mm.modelvideo.o.g(this.DmE, 0);
            } else {
                this.DmE = new RunnableC1696b(this, (byte) 0);
                this.DmG = new c();
                this.DmE.Dng = this.DmG;
                this.DmG.Dnj = this.DmE;
                com.tencent.mm.modelvideo.o.g(this.DmE, 0);
            }
        }
    }

    public final void clear() {
        Log.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.Dmr), Boolean.valueOf(eVy()));
        uD(true);
        this.Dmz = 0;
        d(this.Dms);
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
    private void d(Queue<Integer> queue) {
        while (true) {
            Integer poll = queue.poll();
            if (poll != null) {
                XF(poll.intValue());
            } else {
                return;
            }
        }
    }

    private void XF(final int i2) {
        com.tencent.mm.modelvideo.o.g(new Runnable() {
            /* class com.tencent.mm.plugin.sight.decode.a.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(116074);
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i2);
                Log.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(b.this.hashCode()), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(116074);
            }
        }, 0);
    }

    public final void cd(String str, boolean z) {
        Log.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(hashCode()), str, this.cJp, Boolean.valueOf(z), Integer.valueOf(this.Dmr), Boolean.valueOf(this.DmX), Boolean.valueOf(this.DmM));
        if (this.DmX) {
            uD(false);
        } else if (eVz()) {
            Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            clear();
        } else if (!this.DmM) {
            clear();
        } else if (z) {
            this.Dmq = str;
            uD(false);
        } else if (this.cJp.equals(str)) {
            this.Dmq = "ERROR#PATH";
            uD(false);
            restart();
        } else {
            clear();
            if (str == null) {
                str = "";
            }
            this.cJp = str;
            if (Util.isNullOrNil(this.cJp)) {
                Log.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                as(null);
            } else if (!aNy(this.cJp)) {
                Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                clear();
            } else {
                this.DmD = new h(this, (byte) 0);
                com.tencent.mm.modelvideo.o.g(this.DmD, 0);
            }
        }
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

    public class i implements Runnable {
        double DmV;
        MediaPlayer Dnk;
        public int type;

        private i() {
            this.DmV = -1.0d;
        }

        public /* synthetic */ i(b bVar, byte b2) {
            this();
        }

        private void euh() {
            AppMethodBeat.i(116089);
            Log.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.Dnk != null) {
                    this.Dnk.stop();
                    this.Dnk.release();
                    this.Dnk = null;
                }
                AppMethodBeat.o(116089);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SightPlayController", e2, "stop play sound error: %s", e2.getMessage());
                this.Dnk = null;
                AppMethodBeat.o(116089);
            }
        }

        public final double eVI() {
            AppMethodBeat.i(116090);
            if (this.Dnk == null) {
                AppMethodBeat.o(116090);
                return 0.0d;
            }
            double currentPosition = (double) this.Dnk.getCurrentPosition();
            AppMethodBeat.o(116090);
            return currentPosition;
        }

        public final void run() {
            String str;
            AppMethodBeat.i(116091);
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
                    AppMethodBeat.o(116091);
                    return;
                case 1:
                    euh();
                    if (!Util.isNullOrNil(b.this.cJp)) {
                        try {
                            this.Dnk = new com.tencent.mm.compatible.b.k();
                            this.Dnk.setDisplay(null);
                            this.Dnk.reset();
                            this.Dnk.setDataSource(s.k(b.this.cJp, false));
                            this.Dnk.setAudioStreamType(3);
                            this.Dnk.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                                /* class com.tencent.mm.plugin.sight.decode.a.b.i.AnonymousClass1 */

                                public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                                    AppMethodBeat.i(116088);
                                    Log.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", b.this.cJp, Integer.valueOf(i2), Integer.valueOf(i3));
                                    b.this.clear();
                                    if (b.this.DmZ != null) {
                                        b.this.DmZ.c(b.this, -1);
                                    }
                                    AppMethodBeat.o(116088);
                                    return true;
                                }
                            });
                            this.Dnk.prepare();
                            this.Dnk.start();
                            AppMethodBeat.o(116091);
                            return;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.SightPlayController", e2, "play sound error: %s", e2.getMessage());
                            Log.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", b.this.cJp);
                            b.this.clear();
                            if (b.this.DmZ != null) {
                                b.this.DmZ.c(b.this, -1);
                            }
                            AppMethodBeat.o(116091);
                            return;
                        }
                    }
                    break;
                case 2:
                    try {
                        if (this.Dnk != null && this.Dnk.isPlaying()) {
                            this.Dnk.pause();
                        }
                        AppMethodBeat.o(116091);
                        return;
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.SightPlayController", e3, "pause sound error: %s", e3.getMessage());
                        euh();
                        AppMethodBeat.o(116091);
                        return;
                    }
                case 3:
                    try {
                        if (this.Dnk != null) {
                            this.Dnk.start();
                        }
                        AppMethodBeat.o(116091);
                        return;
                    } catch (Exception e4) {
                        Log.printErrStackTrace("MicroMsg.SightPlayController", e4, "pause sound error: %s", e4.getMessage());
                        euh();
                        AppMethodBeat.o(116091);
                        return;
                    }
                case 4:
                    try {
                        Log.i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.DmV));
                        this.Dnk.seekTo((int) (this.DmV * 1000.0d));
                        AppMethodBeat.o(116091);
                        return;
                    } catch (Exception e5) {
                        Log.printErrStackTrace("MicroMsg.SightPlayController", e5, "seek sound error: %s", e5.getMessage());
                        break;
                    }
            }
            AppMethodBeat.o(116091);
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
            AppMethodBeat.i(116087);
            if (b.this.eVz()) {
                Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                AppMethodBeat.o(116087);
                return;
            }
            b.this.Dmr = SightVideoJNI.openFileVFS(b.this.cJp, 1 == b.this.Dmp ? 0 : 1, 1, false);
            Log.i("MicroMsg.SightPlayController", "SightVideoJNI.openFile mVideoPath:%s mVideoId:%s", b.this.cJp, Integer.valueOf(b.this.Dmr));
            b.this.Dms.offer(Integer.valueOf(b.this.Dmr));
            if (b.this.Dmr < 0) {
                Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.Dmr), b.this.cJp);
                b.this.as(null);
                if (b.this.DmZ != null) {
                    b.this.DmZ.c(b.this, -1);
                }
                AppMethodBeat.o(116087);
                return;
            }
            if (((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(344065, Boolean.FALSE)).booleanValue()) {
                if (b.this.DmI == null) {
                    b.this.DmI = new j(b.this, (byte) 0);
                }
                b.this.czp.removeCallbacks(b.this.DmI);
                b.this.czp.post(b.this.DmI);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(b.this.Dmr));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(b.this.Dmr));
            if (b.this.Dmp == 0) {
                if (b.this.DmO) {
                    if (max * max2 > 1152000 || max <= 0 || max2 <= 0) {
                        Log.e("MicroMsg.SightPlayController", "get error info for ad,  videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                        AppMethodBeat.o(116087);
                        return;
                    }
                } else if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    Log.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    AppMethodBeat.o(116087);
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
                b.this.d((b) b.this.Dms);
                b.this.Dmr = -1;
                b.this.cJp = "";
                b.this.Dmq = "ERROR#PATH";
                b.this.Dmw = null;
                this.stop = true;
                if (b.this.DmZ != null) {
                    b.this.DmZ.c(b.this, -1);
                }
                AppMethodBeat.o(116087);
                return;
            }
            b.this.eo(max, max2);
            if (1 == b.this.Dmp) {
                b.this.DmE = new RunnableC1696b(b.this, (byte) 0);
                b.this.DmG = null;
                if (!this.stop) {
                    com.tencent.mm.modelvideo.o.g(b.this.DmE, 0);
                }
            } else {
                b.this.DmE = new RunnableC1696b(b.this, (byte) 0);
                b.this.DmG = new c();
                b.this.DmE.Dng = b.this.DmG;
                b.this.DmG.Dnj = b.this.DmE;
                if (!this.stop) {
                    com.tencent.mm.modelvideo.o.g(b.this.DmE, 0);
                }
            }
            if (this.stop) {
                Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop));
            }
            AppMethodBeat.o(116087);
        }
    }

    public final void j(Surface surface) {
        Log.v("MicroMsg.SightPlayController", "set play surface %s", surface);
        this.mSurface = surface;
        com.tencent.mm.modelvideo.o.g(this.DmH, 0);
    }

    public final void setThumbBgView(View view) {
        this.Dmx = new WeakReference<>(view);
    }

    public final void setSightInfoView(TextView textView) {
        this.Dmy = new WeakReference<>(textView);
    }

    public final void as(Bitmap bitmap) {
        boolean z = true;
        Object[] objArr = new Object[1];
        if (bitmap != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", objArr);
        com.tencent.mm.modelvideo.o.I(this.DmH);
        if (this.DmH == null) {
            this.DmH = new k(this, (byte) 0);
        }
        this.DmH.Dnm = new WeakReference<>(bitmap);
        com.tencent.mm.modelvideo.o.g(this.DmH, 0);
    }

    /* access modifiers changed from: package-private */
    public class j implements Runnable {
        private j() {
        }

        /* synthetic */ j(b bVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(116092);
            if (b.this.Dmr < 0 || b.this.Dmy == null || b.this.Dmy.get() == null) {
                AppMethodBeat.o(116092);
                return;
            }
            ((TextView) b.this.Dmy.get()).setText(SightVideoJNI.getVideoInfo(b.this.Dmr));
            AppMethodBeat.o(116092);
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
            AppMethodBeat.i(116086);
            if (b.this.DmA.get() == null) {
                AppMethodBeat.o(116086);
                return;
            }
            ((View) b.this.DmA.get()).startAnimation(b.this.DmB);
            AppMethodBeat.o(116086);
        }
    }

    /* access modifiers changed from: package-private */
    public class k implements Runnable {
        WeakReference<Bitmap> Dnm;

        private k() {
            AppMethodBeat.i(116096);
            this.Dnm = new WeakReference<>(null);
            AppMethodBeat.o(116096);
        }

        /* synthetic */ k(b bVar, byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0263, code lost:
            r0 = (android.view.View) r11.Dnc.Dmx.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 689
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.decode.a.b.k.run():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$b  reason: collision with other inner class name */
    public class RunnableC1696b implements Runnable {
        c Dng;
        volatile boolean stop;

        private RunnableC1696b() {
            this.stop = false;
        }

        /* synthetic */ RunnableC1696b(b bVar, byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:140:0x060f  */
        /* JADX WARNING: Removed duplicated region for block: B:160:0x06cd  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x030d  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0337  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0349  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 1747
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.decode.a.b.RunnableC1696b.run():void");
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {
        int Dni;
        RunnableC1696b Dnj;
        volatile boolean stop = false;

        public c() {
            AppMethodBeat.i(116084);
            Log.i("MicroMsg.SightPlayController", "make sure drawJob alive");
            AppMethodBeat.o(116084);
        }

        public final void run() {
            AppMethodBeat.i(116085);
            if (this.stop) {
                Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.o(116085);
                return;
            }
            b.this.at(b.this.Dmu);
            if (b.this.Dmz == 0) {
                com.tencent.mm.modelvideo.o.g(this.Dnj, 0);
                AppMethodBeat.o(116085);
                return;
            }
            long currentTimeMillis = ((long) b.this.Dmt) - (System.currentTimeMillis() - b.this.Dmz);
            if (currentTimeMillis > 0) {
                com.tencent.mm.modelvideo.o.g(this.Dnj, currentTimeMillis);
                AppMethodBeat.o(116085);
                return;
            }
            com.tencent.mm.modelvideo.o.g(this.Dnj, 0);
            AppMethodBeat.o(116085);
        }
    }

    public final IListener eVB() {
        if (this.DmY == null) {
            this.DmY = new a(this);
        }
        return this.DmY;
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
            AppMethodBeat.i(116077);
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
            AppMethodBeat.o(116077);
            return false;
        }

        public a(b bVar) {
            super(0);
            AppMethodBeat.i(116075);
            this.Dnf = new WeakReference<>(bVar);
            this.__eventId = yh.class.getName().hashCode();
            AppMethodBeat.o(116075);
        }

        private void a(yh yhVar) {
            this.wqJ = yhVar.eeC.eeF;
            this.Dne = yhVar.eeC.eeD;
            this.tex = yhVar.eeC.eeE;
        }

        private boolean eVE() {
            AppMethodBeat.i(116076);
            if (this.Dnf.get() == null) {
                AppMethodBeat.o(116076);
                return false;
            }
            int i2 = this.Dnf.get().position + this.wqJ;
            if (i2 < this.Dne || i2 > this.tex) {
                AppMethodBeat.o(116076);
                return false;
            }
            AppMethodBeat.o(116076);
            return true;
        }
    }

    public final double eVC() {
        if (this.Dmr == -1) {
            return 0.0d;
        }
        return SightVideoJNI.getVideoDuration(this.Dmr);
    }

    public final void setOnDecodeDurationListener(f fVar) {
        if (fVar == null) {
            this.Dna = this.DmK;
        }
        this.Dna = fVar;
    }

    static /* synthetic */ void D(b bVar) {
        if (bVar.DmA != null && -1 != bVar.eVx() && bVar.DmL && !bVar.DmP) {
            if (bVar.DmB == null && bVar.DmA.get() != null) {
                bVar.DmB = AnimationUtils.loadAnimation(bVar.DmA.get().getContext(), bVar.eVx());
            }
            if (bVar.DmJ == null) {
                bVar.DmJ = new d(bVar, (byte) 0);
            }
            bVar.czp.post(bVar.DmJ);
        }
    }
}
