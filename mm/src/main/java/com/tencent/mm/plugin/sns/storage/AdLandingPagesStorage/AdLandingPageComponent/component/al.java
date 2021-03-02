package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.content.d;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import org.json.JSONException;
import org.json.JSONObject;

public final class al extends ak implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, com.tencent.mm.plugin.sight.decode.ui.b, i.b, i.d {
    private long AhP = 0;
    private int Aiv = 0;
    AdLandingVideoWrapper EeO;
    private VideoPlayerSeekBar EeP;
    private ImageView EeQ;
    private boolean EeR;
    private ImageView EeS;
    private TextView EeT;
    private Runnable EeU;
    private boolean EeV = false;
    private boolean EeW = false;
    private boolean EeX = false;
    private boolean EeY = true;
    private boolean EeZ = true;
    private boolean Efa = false;
    private boolean Efb = true;
    private boolean Efc = false;
    private boolean Efd = false;
    private boolean Efe = false;
    private int Eff = 0;
    private int Efg = 0;
    private int Efh = 0;
    private int Efi = 0;
    private int Efj = 0;
    private ao Efk = null;
    private View.OnClickListener Efl = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass10 */

        public final void onClick(View view) {
            AppMethodBeat.i(96769);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", Boolean.valueOf(al.this.EeO.isPlaying()));
            al.a(al.this, al.this.EeU);
            if (al.this.EeO.isPlaying()) {
                al.i(al.this);
                al.this.Eff = 4;
            } else {
                if (al.this.EeY) {
                    al.this.fcJ();
                } else {
                    al.this.fcL();
                    al.this.fcK();
                }
                al.k(al.this);
                al.this.Eff = 3;
            }
            if (al.this.DXw) {
                al.m(al.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96769);
        }
    };
    private View.OnClickListener Efm = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass11 */

        public final void onClick(View view) {
            AppMethodBeat.i(96771);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            al.n(al.this);
            al.a(al.this, al.this.EeU);
            if (al.this.EeY) {
                al.this.fcL();
                al.this.fcK();
            } else {
                al.this.fcJ();
            }
            al.this.EeV = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96771);
        }
    };
    private View.OnClickListener Efn = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass12 */

        public final void onClick(View view) {
            AppMethodBeat.i(96772);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            al.k(al.this);
            al.this.EeZ = false;
            al.this.EeW = true;
            al.this.Eff = 3;
            al.this.fcK();
            al.a(al.this, true);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass12.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(203083);
                    if (al.this.EeX) {
                        AppMethodBeat.o(203083);
                        return;
                    }
                    al.a(al.this, false);
                    AppMethodBeat.o(203083);
                }
            }, 10000);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96772);
        }
    };
    private View.OnClickListener Efo = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass13 */

        public final void onClick(View view) {
            AppMethodBeat.i(203084);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203084);
        }
    };
    private volatile int EgO = 0;
    private b EgP;
    private ImageView Egd;
    private View Ege;
    private volatile boolean Egf = false;
    private Runnable Egg;
    private int Egh = 0;
    private int Egi = 0;
    private long Egk = 0;
    private View Egn;
    private Context context;
    private MMHandler hAk;
    private ProgressBar hRO;
    private boolean isAutoPlay = false;
    private volatile boolean isWaiting = false;
    private GestureDetector jKk;
    private int length;
    private View maskView;
    private ImageView xdY;

    public static class a {
        public static am EgT;
    }

    static /* synthetic */ void a(al alVar, Runnable runnable) {
        AppMethodBeat.i(203105);
        alVar.ay(runnable);
        AppMethodBeat.o(203105);
    }

    static /* synthetic */ void a(al alVar, boolean z) {
        AppMethodBeat.i(203102);
        alVar.setFocus(z);
        AppMethodBeat.o(203102);
    }

    static /* synthetic */ int b(al alVar) {
        AppMethodBeat.i(203103);
        int fcM = alVar.fcM();
        AppMethodBeat.o(203103);
        return fcM;
    }

    static /* synthetic */ void b(al alVar, int i2) {
        AppMethodBeat.i(203108);
        alVar.YX(i2);
        AppMethodBeat.o(203108);
    }

    static /* synthetic */ void b(al alVar, boolean z) {
        AppMethodBeat.i(203104);
        alVar.vh(z);
        AppMethodBeat.o(203104);
    }

    static /* synthetic */ void i(al alVar) {
        AppMethodBeat.i(203106);
        alVar.vi(true);
        AppMethodBeat.o(203106);
    }

    static /* synthetic */ void k(al alVar) {
        AppMethodBeat.i(203107);
        alVar.czw();
        AppMethodBeat.o(203107);
    }

    static /* synthetic */ int m(al alVar) {
        int i2 = alVar.Efi;
        alVar.Efi = i2 + 1;
        return i2;
    }

    static /* synthetic */ int n(al alVar) {
        int i2 = alVar.Efj;
        alVar.Efj = i2 + 1;
        return i2;
    }

    public al(final Context context2, am amVar, ViewGroup viewGroup) {
        super(context2, amVar, viewGroup);
        AppMethodBeat.i(96774);
        this.context = context2;
        this.hAk = new MMHandler(Looper.getMainLooper());
        try {
            this.jKk = new GestureDetector(this);
            this.Egg = new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(96762);
                    al.this.Ege.setVisibility(8);
                    AppMethodBeat.o(96762);
                }
            };
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", th.toString());
        }
        this.EeU = new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(203078);
                al.a(al.this, false);
                AppMethodBeat.o(203078);
            }
        };
        this.Efk = new ao() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao
            public final void vg(boolean z) {
                AppMethodBeat.i(203079);
                Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
                intent.putExtra("show", z ? 1 : 0);
                intent.putExtra("activity_code", al.b(al.this));
                d.W(context2).b(intent);
                AppMethodBeat.o(203079);
            }
        };
        AppMethodBeat.o(96774);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.buk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01b9 A[Catch:{ Throwable -> 0x03b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0259 A[Catch:{ Throwable -> 0x03c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x02ad A[Catch:{ Throwable -> 0x03d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x02fc A[Catch:{ Throwable -> 0x03d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x00e3  */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eXe() {
        /*
        // Method dump skipped, instructions count: 1010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.eXe():void");
    }

    private void vh(boolean z) {
        AppMethodBeat.i(203085);
        try {
            this.EeP.setIsPlay(z);
            this.EeP.getPlayBtn().getLayoutParams().width = this.length;
            this.EeP.getPlayBtn().getLayoutParams().height = this.length;
            if (z) {
                Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "startPlay");
                this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.media_player_btn_cur_status_on));
                AppMethodBeat.o(203085);
                return;
            }
            Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "pausePlay");
            this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.media_player_btn_cur_status_off));
            AppMethodBeat.o(203085);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", th.toString());
            AppMethodBeat.o(203085);
        }
    }

    private void ay(Runnable runnable) {
        AppMethodBeat.i(203086);
        try {
            this.hAk.removeCallbacks(runnable);
            this.hAk.postDelayed(runnable, 4000);
            AppMethodBeat.o(203086);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", th.toString());
            AppMethodBeat.o(203086);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
    }

    private void czw() {
        AppMethodBeat.i(96776);
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play, downFailed=" + this.Efc);
        if (this.Efc) {
            Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
            if (!(this.EeP == null || this.EeP.getParent() == null)) {
                ((ViewGroup) this.EeP.getParent()).removeView(this.EeP);
            }
            this.EeO.setFullScreen(false);
            this.EeO.c(false, ((am) this.EcX).DYS, 0);
            try {
                int i2 = this.mEX;
                if (!(this.EeP == null || this.EeP.getParent() == null)) {
                    ((ViewGroup) this.EeP.getParent()).removeView(this.EeP);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2 - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 3);
                this.EeP.setLayoutParams(layoutParams);
                ((ViewGroup) this.contentView.findViewById(R.id.bf6)).addView(this.EeP, layoutParams);
            } catch (Exception e2) {
                Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "startPlay exp=" + Util.stackTraceToString(e2));
            }
            YX(0);
            this.EeO.fdQ();
            AppMethodBeat.o(96776);
            return;
        }
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(96763);
                if (!al.this.EeO.isPlaying()) {
                    if (al.this.EeO.getCurrPosSec() == al.this.EeO.getVideoDurationSec()) {
                        al.b(al.this, 0);
                    } else {
                        al.b(al.this, al.this.EeO.getCurrPosSec());
                    }
                    al.this.EeO.fdQ();
                }
                AppMethodBeat.o(96763);
            }
        });
        this.AhP = System.currentTimeMillis();
        this.Aiv++;
        AppMethodBeat.o(96776);
    }

    private void vi(final boolean z) {
        AppMethodBeat.i(203087);
        Log.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(96764);
                al.this.EeO.pause();
                try {
                    if (al.this.EeS.getVisibility() != 0 && z) {
                        al.this.Ege.setVisibility(0);
                        al.a(al.this, al.this.Egg);
                    }
                    al.b(al.this, false);
                    AppMethodBeat.o(96764);
                } catch (Throwable th) {
                    Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", th.toString());
                    AppMethodBeat.o(96764);
                }
            }
        });
        if (this.AhP != 0) {
            this.Efg = (int) (((long) this.Efg) + (System.currentTimeMillis() - this.AhP));
            this.AhP = 0;
        }
        AppMethodBeat.o(203087);
    }

    private void setFocus(boolean z) {
        AppMethodBeat.i(96778);
        if (z) {
            this.EeP.setVisibility(0);
            this.EeQ.setVisibility(0);
            this.maskView.setVisibility(0);
            this.Egd.setVisibility(0);
            if (this.Efk != null) {
                this.Efk.vg(true);
            }
            ay(this.EeU);
            AppMethodBeat.o(96778);
            return;
        }
        this.EeX = false;
        this.EeP.setVisibility(4);
        this.EeQ.setVisibility(8);
        this.maskView.setVisibility(4);
        this.Egd.setVisibility(8);
        if (this.Efk != null) {
            this.Efk.vg(false);
        }
        this.hAk.removeCallbacks(this.EeU);
        AppMethodBeat.o(96778);
    }

    private void YX(int i2) {
        AppMethodBeat.i(96779);
        if (this.EeO != null) {
            this.EeS.setVisibility(8);
            if (this.xdY.getVisibility() == 0) {
                this.hRO.setVisibility(0);
            }
            this.EeO.c((double) i2, true);
        }
        AppMethodBeat.o(96779);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void fcJ() {
        AppMethodBeat.i(96780);
        super.fcJ();
        this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.icon_volume_off));
        this.EeO.setMute(true);
        this.EeY = true;
        AppMethodBeat.o(96780);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void fcK() {
        AppMethodBeat.i(96781);
        super.fcK();
        this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.icon_volume_on));
        this.EeO.setMute(false);
        this.EeY = false;
        AppMethodBeat.o(96781);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final boolean isPlaying() {
        AppMethodBeat.i(203088);
        boolean isPlaying = this.EeO.isPlaying();
        AppMethodBeat.o(203088);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eWZ() {
        AppMethodBeat.i(96782);
        super.eWZ();
        AppMethodBeat.o(96782);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXa() {
        AppMethodBeat.i(96783);
        super.eXa();
        this.EeO.setNeedPause(true);
        vi(false);
        if (this.Efa || this.Efb) {
            this.Efb = false;
            this.Efa = false;
            if (this.Eff == 1) {
                this.Eff = 2;
            }
            AppMethodBeat.o(96783);
            return;
        }
        AppMethodBeat.o(96783);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXd() {
        AppMethodBeat.i(96784);
        super.eXd();
        try {
            this.hAk.removeCallbacks(this.EeU);
            this.hAk.removeCallbacks(this.Egg);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", th.toString());
        }
        this.EeO.onUIDestroy();
        AppMethodBeat.o(96784);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXb() {
        AppMethodBeat.i(96785);
        super.eXb();
        int fdl = fdl();
        int height = getView().getHeight();
        Log.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", Integer.valueOf(fdl), Integer.valueOf(height));
        if (fdl == 0 || height == 0) {
            this.EeO.setNeedPause(true);
            AppMethodBeat.o(96785);
        } else if (fdl < 0) {
            this.EeO.setNeedPause(true);
            AppMethodBeat.o(96785);
        } else {
            if (((float) fdl) < ((float) height) * 0.5f) {
                this.Efb = false;
                this.Efa = false;
                this.EeO.setNeedPause(true);
                vi(false);
                if (this.Eff == 1) {
                    this.Eff = 2;
                }
            } else if (!this.Efa || this.Efb) {
                this.EeO.setNeedPause(false);
                this.Efb = false;
                this.Efa = true;
                if (this.Eff == 6) {
                    if (this.Egf) {
                        this.Eff = 1;
                        if (this.EeS.getVisibility() == 0) {
                            this.EeS.setVisibility(8);
                            AppMethodBeat.o(96785);
                            return;
                        }
                    } else {
                        this.Eff = 4;
                    }
                    AppMethodBeat.o(96785);
                    return;
                }
                this.xdY.setVisibility(0);
                if (!this.EeZ || (this.EeZ && fdN())) {
                    setFocus(true);
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(203076);
                            if (al.this.EeX) {
                                AppMethodBeat.o(203076);
                                return;
                            }
                            al.a(al.this, false);
                            AppMethodBeat.o(203076);
                        }
                    }, 3000);
                }
                if (this.EeZ) {
                    if (!fdN()) {
                        this.EeS.setVisibility(0);
                        this.isAutoPlay = false;
                        this.EeZ = false;
                        AppMethodBeat.o(96785);
                        return;
                    }
                    this.isAutoPlay = true;
                    this.EeZ = false;
                }
                if (this.Eff == 0) {
                    if (fdN()) {
                        if (this.EeY) {
                            fcJ();
                        } else {
                            fcK();
                        }
                        this.Eff = 1;
                        czw();
                        AppMethodBeat.o(96785);
                        return;
                    }
                } else if (this.Eff == 2) {
                    if (this.EeY) {
                        fcJ();
                    } else {
                        fcK();
                    }
                    czw();
                    this.Eff = 1;
                    AppMethodBeat.o(96785);
                    return;
                } else if (this.Eff == 3) {
                    if (this.EeY) {
                        fcJ();
                    } else {
                        fcK();
                    }
                    czw();
                    AppMethodBeat.o(96785);
                    return;
                }
            } else {
                AppMethodBeat.o(96785);
                return;
            }
            AppMethodBeat.o(96785);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96786);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96786);
            return false;
        }
        try {
            jSONObject.put("streamVideoDuraion", this.EeO.getVideoDurationSec() * 1000);
            jSONObject.put("playTimeInterval", this.Efg);
            jSONObject.put("playCount", this.Aiv);
            jSONObject.put("playCompletedCount", this.Efh);
            jSONObject.put("clickFullscreenBtnCount", this.Egi);
            jSONObject.put("doubleClickCount", this.Egh);
            jSONObject.put("clickPlayControlCount", this.Efi);
            jSONObject.put("clickVoiceControlCount", this.Efj);
            jSONObject.put("isAutoPlay", this.isAutoPlay ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (!this.Efd) {
                String mD5String = MD5Util.getMD5String(((am) this.EcX).Ead);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", mD5String);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            if (!this.Efe) {
                String mD5String2 = MD5Util.getMD5String(((am) this.EcX).DYS);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("urlMd5", mD5String2);
                jSONObject3.put("needDownload", 1);
                jSONObject.put("streamVideoUrlInfo", jSONObject3);
            }
            if (this.EgP != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("cid", this.EgP.Egw);
                jSONObject4.put(f.COL_EXPOSURECOUNT, this.EgP.Egx);
                jSONObject4.put("stayTime", this.EgP.Egy);
                jSONObject4.put("clickCount", this.EgP.Egz);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(f.COL_EXPOSURECOUNT, this.EgP.Dzo);
                jSONObject5.put("stayTime", this.EgP.dUy);
                jSONObject5.put("clickCount", this.EgP.clickCount);
                jSONObject5.put("btnInfo", jSONObject4);
                jSONObject.put("fullVideoFloatBarInfo", jSONObject5);
            }
            AppMethodBeat.o(96786);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", e2, "", new Object[0]);
            AppMethodBeat.o(96786);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.b
    public final void aJq() {
        AppMethodBeat.i(203090);
        this.EeX = true;
        ay(this.EeU);
        AppMethodBeat.o(203090);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.b
    public final void rk(int i2) {
        AppMethodBeat.i(96787);
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(i2)));
        this.EgO = i2;
        if (this.EeY) {
            fcJ();
        } else {
            fcL();
            fcK();
        }
        this.hAk.removeCallbacks(this.Egg);
        this.Ege.setVisibility(8);
        YX(i2);
        this.Eff = 3;
        AppMethodBeat.o(96787);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dH(String str, String str2) {
        this.Efc = false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dI(String str, String str2) {
        AppMethodBeat.i(96788);
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onVideoEnded");
        this.Efh++;
        setFocus(true);
        this.EeO.Ehq.stopTimer();
        if (this.AhP != 0) {
            this.Efg = (int) (((long) this.Efg) + (System.currentTimeMillis() - this.AhP));
            this.AhP = 0;
        }
        this.Eff = 5;
        this.EeO.onUIPause();
        AppMethodBeat.o(96788);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.d
    public final void fdO() {
        AppMethodBeat.i(203091);
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLoopCompletion");
        this.Efh++;
        if (this.DXu != null) {
            this.DXu.Duo = true;
        }
        AppMethodBeat.o(203091);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dJ(String str, String str2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dK(String str, String str2) {
        AppMethodBeat.i(96789);
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "the onVideoPlay is called!");
        if (this.DXu != null) {
            this.DXu.sendMessage();
        }
        this.xdY.setVisibility(8);
        this.hRO.setVisibility(8);
        try {
            this.hAk.removeCallbacks(this.Egg);
            this.Ege.setVisibility(8);
            vh(true);
            AppMethodBeat.o(96789);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", th.toString());
            AppMethodBeat.o(96789);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void d(String str, String str2, int i2, int i3) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(96790);
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", str3);
        this.Efc = true;
        AppMethodBeat.o(96790);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dL(String str, String str2) {
        this.isWaiting = true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dM(String str, String str2) {
        this.isWaiting = false;
        this.EgO = 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void fo(String str, String str2) {
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void fdq() {
        AppMethodBeat.i(96791);
        super.fdq();
        vi(false);
        String kz = h.kz("adId", ((am) this.EcX).Ead);
        if (s.YS(kz)) {
            this.xdY.setImageBitmap(BitmapUtil.decodeFile(kz));
            this.xdY.setVisibility(0);
        }
        AppMethodBeat.o(96791);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(203092);
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203092);
        return a2;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(203093);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.hw7) {
            Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "click full screen btn");
            try {
                if (this.context instanceof SnsAdNativeLandingPagesUI) {
                    this.Egi++;
                    this.hAk.removeCallbacks(this.Egg);
                    this.Ege.setVisibility(8);
                    SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
                    a.EgT = (am) this.EcX;
                    ae.DJT = fds();
                    Intent intent = new Intent(snsAdNativeLandingPagesUI, VideoFullScreenActivity.class);
                    intent.putExtra("KComponentVideoType", 1);
                    intent.putExtra("KComponentCid", fdn());
                    intent.putExtra("KComponentCurrentTime", this.EeO.getCurrPosSec());
                    intent.putExtra("KComponentTotalTime", this.EeO.getVideoDurationSec());
                    intent.putExtra("KComponentVoiceType", this.EeY);
                    intent.putExtra("KComponentProgressType", this.EeO.isPlaying());
                    intent.putExtra("KComponentStreamVideoUrlPath", ((am) this.EcX).DYS);
                    intent.putExtra("KComponentIsWaiting", this.isWaiting);
                    intent.putExtra("KComponentSeekTimeDueWaiting", this.EgO);
                    intent.putExtra("KComponentKComponentCacheTime", this.EeO.getCacheTimeSec());
                    intent.putExtra("KComponentForceLandMode", ((am) this.EcX).Eag);
                    this.EeO.setNeedPause(true);
                    snsAdNativeLandingPagesUI.startActivityForResult(intent, 2000);
                } else {
                    this.Egd.setVisibility(8);
                }
            } catch (Throwable th) {
                this.Egd.setVisibility(8);
                Log.e("VideoFullScreenActivity", th.toString());
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203093);
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AppMethodBeat.i(203094);
        try {
            Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onSingleTapConfirmed");
            if (!this.EeX) {
                this.EeX = true;
                setFocus(true);
            } else {
                this.EeX = false;
                setFocus(false);
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", th.toString());
        }
        AppMethodBeat.o(203094);
        return false;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(203095);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        try {
            Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onDoubleTap");
            ay(this.EeU);
            if (!this.Efc) {
                this.Egh++;
            }
            if (this.EeO.isPlaying()) {
                vi(true);
                this.Eff = 4;
            } else {
                if (this.EeY) {
                    fcJ();
                } else {
                    fcL();
                    fcK();
                }
                czw();
                this.Eff = 3;
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", th.toString());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203095);
        return false;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(203096);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203096);
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(203097);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(203097);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final void a(int i2, boolean z, boolean z2, int i3, int i4, int i5, int i6, int i7, long j2, boolean z3, int i8, String str, long j3) {
        AppMethodBeat.i(203098);
        try {
            this.EeO.setNeedPause(false);
            this.Eff = 6;
            this.Egk += j3;
            this.Egf = z2;
            this.Egi++;
            this.Efi += i3;
            this.Egh += i4;
            this.Efj += i5;
            this.Efh += i6;
            this.Aiv += i7;
            this.Efg = (int) (((long) this.Efg) + j2);
            if (!Util.isNullOrNil(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (this.EgP == null) {
                        this.EgP = new b();
                    }
                    this.EgP.Dzo += jSONObject.optInt(f.COL_EXPOSURECOUNT);
                    this.EgP.dUy += jSONObject.optLong("stayTime");
                    this.EgP.clickCount += jSONObject.optInt("clickCount");
                    JSONObject optJSONObject = jSONObject.optJSONObject("btnInfo");
                    this.EgP.Egw = optJSONObject.optString("cid");
                    this.EgP.Egx += optJSONObject.optInt(f.COL_EXPOSURECOUNT);
                    this.EgP.Egy += optJSONObject.optLong("stayTime");
                    b bVar = this.EgP;
                    bVar.Egz = optJSONObject.optInt("clickCount") + bVar.Egz;
                } catch (Throwable th) {
                    this.EgP = null;
                    Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", th.toString());
                }
            }
            if (z2) {
                this.AhP = System.currentTimeMillis();
            }
            this.hAk.removeCallbacks(this.Egg);
            this.Ege.setVisibility(8);
            Log.i("VideoFullScreenActivity", "currPosSec = " + i2 + ", isPlaying = " + z2 + ", bNoVoice = " + z);
            if (z3) {
                if (i8 == this.EeO.getVideoDurationSec() || i8 < 0) {
                    this.EeP.seek(0);
                    this.EeO.c(0.0d, true);
                } else {
                    this.EeP.seek(this.EeO.getCacheTimeSec());
                    this.EeO.c((double) this.EeO.getCacheTimeSec(), true);
                }
                this.AhP = System.currentTimeMillis();
                vh(true);
            } else {
                if (i2 == this.EeO.getVideoDurationSec() || i2 < 0) {
                    this.EeP.seek(0);
                    this.EeO.c(0.0d, z2);
                } else {
                    this.EeP.seek(i2);
                    this.EeO.c((double) i2, z2);
                }
                vh(z2);
            }
            if (z) {
                fcJ();
                AppMethodBeat.o(203098);
                return;
            }
            fcK();
            AppMethodBeat.o(203098);
        } catch (Throwable th2) {
            Log.e("VideoFullScreenActivity", th2.toString());
            AppMethodBeat.o(203098);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void cWX() {
        AppMethodBeat.i(203099);
        vi(false);
        this.Eff = 4;
        AppMethodBeat.o(203099);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void cWY() {
        AppMethodBeat.i(203100);
        this.Eff = 3;
        czw();
        AppMethodBeat.o(203100);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final long fdo() {
        AppMethodBeat.i(203101);
        long fdo = super.fdo() + this.Egk;
        AppMethodBeat.o(203101);
        return fdo;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int Dzo;
        String Egw;
        int Egx;
        long Egy;
        int Egz;
        int clickCount;
        long dUy;

        b() {
        }
    }

    private boolean fdN() {
        AppMethodBeat.i(203089);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) || ((am) this.EcX).Eaf) {
            AppMethodBeat.o(203089);
            return true;
        }
        AppMethodBeat.o(203089);
        return false;
    }

    static /* synthetic */ am e(al alVar) {
        return (am) alVar.EcX;
    }
}
