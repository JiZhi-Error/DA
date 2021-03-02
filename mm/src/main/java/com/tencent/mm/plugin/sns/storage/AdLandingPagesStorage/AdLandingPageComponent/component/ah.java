package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener {
    private long AhP = 0;
    private int Aiv = 0;
    public int DvS = 0;
    public int DvT = 0;
    public int DvU = 0;
    private int Dzs;
    private VideoPlayerSeekBar EeP;
    ImageView EeQ;
    private boolean EeR;
    private TextView EeT;
    private Runnable EeU;
    boolean EeY = true;
    OfflineVideoView EfZ;
    private boolean Efa = false;
    private boolean Efb = true;
    private boolean Efc = false;
    boolean Efd = true;
    boolean Efe = true;
    private volatile int Eff = 0;
    private int Efg = 0;
    private int Efh = 0;
    private int Efi = 0;
    int Efj = 0;
    private ao Efk = null;
    private View.OnClickListener Efl = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(203024);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            try {
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "play btn onclick isPlaying[%b]", Boolean.valueOf(ah.this.EfZ.isPlaying()));
                ah.a(ah.this, ah.this.EeU);
                if (ah.this.EfZ.isPlaying()) {
                    ah.t(ah.this);
                    ah.this.Eff = 4;
                } else {
                    if (ah.this.EeY) {
                        ah.this.fcJ();
                    } else {
                        ah.this.fcL();
                        ah.this.fcK();
                    }
                    ah.u(ah.this);
                    ah.this.Eff = 3;
                }
                if (ah.this.DXw) {
                    ah.w(ah.this);
                }
            } catch (Throwable th) {
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203024);
        }
    };
    private int Ega = 0;
    int Egb = 0;
    int Egc = 0;
    private ImageView Egd;
    private View Ege;
    private volatile boolean Egf = false;
    private Runnable Egg;
    private int Egh = 0;
    private int Egi = 0;
    private c Egj;
    private long Egk = 0;
    private a Egl;
    public boolean Egm = false;
    private View Egn;
    private View Ego;
    private Context context;
    int gRE = 0;
    private MMHandler hAk;
    private boolean hki;
    private boolean isAutoPlay = false;
    private GestureDetector jKk;
    private String lPw;
    private int length;
    private View maskView;
    private com.tencent.mm.plugin.sight.decode.ui.b tni = new com.tencent.mm.plugin.sight.decode.ui.b() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void aJq() {
            AppMethodBeat.i(203025);
            try {
                ah.a(ah.this, ah.this.EeU);
                if (ah.this.EfZ != null) {
                    ah.this.EfZ.fgd();
                }
                AppMethodBeat.o(203025);
            } catch (Throwable th) {
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
                AppMethodBeat.o(203025);
            }
        }

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void rk(int i2) {
            AppMethodBeat.i(203026);
            try {
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSeek time ".concat(String.valueOf(i2)));
                if (ah.this.EeY) {
                    ah.this.fcJ();
                } else {
                    ah.this.fcK();
                }
                ah.this.EfZ.aU(i2 * 1000, true);
                ah.this.Eff = 3;
                ah.b(ah.this, true);
                ah.this.hAk.removeCallbacks(ah.this.Egg);
                ah.this.Ege.setVisibility(8);
                AppMethodBeat.o(203026);
            } catch (Throwable th) {
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
                AppMethodBeat.o(203026);
            }
        }
    };
    private boolean vbV;

    public static class b {
        public static v Egv;
    }

    static /* synthetic */ void a(ah ahVar, Runnable runnable) {
        AppMethodBeat.i(203067);
        ahVar.ay(runnable);
        AppMethodBeat.o(203067);
    }

    static /* synthetic */ void b(ah ahVar, int i2) {
        AppMethodBeat.i(203069);
        ahVar.YY(i2);
        AppMethodBeat.o(203069);
    }

    static /* synthetic */ void b(ah ahVar, boolean z) {
        AppMethodBeat.i(203071);
        ahVar.vh(z);
        AppMethodBeat.o(203071);
    }

    static /* synthetic */ int c(ah ahVar) {
        AppMethodBeat.i(203066);
        int fcM = ahVar.fcM();
        AppMethodBeat.o(203066);
        return fcM;
    }

    static /* synthetic */ boolean h(ah ahVar) {
        AppMethodBeat.i(96733);
        boolean z = ahVar.EeR;
        AppMethodBeat.o(96733);
        return z;
    }

    static /* synthetic */ int j(ah ahVar) {
        int i2 = ahVar.Efh;
        ahVar.Efh = i2 + 1;
        return i2;
    }

    static /* synthetic */ boolean s(ah ahVar) {
        AppMethodBeat.i(203070);
        boolean fdG = ahVar.fdG();
        AppMethodBeat.o(203070);
        return fdG;
    }

    static /* synthetic */ void t(ah ahVar) {
        AppMethodBeat.i(203072);
        ahVar.vi(true);
        AppMethodBeat.o(203072);
    }

    static /* synthetic */ void u(ah ahVar) {
        AppMethodBeat.i(203073);
        ahVar.czw();
        AppMethodBeat.o(203073);
    }

    static /* synthetic */ int w(ah ahVar) {
        int i2 = ahVar.Efi;
        ahVar.Efi = i2 + 1;
        return i2;
    }

    public ah(final Context context2, v vVar, ViewGroup viewGroup) {
        super(context2, vVar, viewGroup);
        AppMethodBeat.i(96717);
        this.context = context2;
        this.hAk = new MMHandler(Looper.getMainLooper());
        try {
            this.jKk = new GestureDetector(this);
            this.EeU = new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(203023);
                    ah.a(ah.this);
                    AppMethodBeat.o(203023);
                }
            };
            this.Egg = new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(203030);
                    ah.this.Ege.setVisibility(8);
                    AppMethodBeat.o(203030);
                }
            };
            this.Efk = new ao() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao
                public final void vg(boolean z) {
                    AppMethodBeat.i(203031);
                    try {
                        Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
                        intent.putExtra("show", z ? 1 : 0);
                        intent.putExtra("activity_code", ah.c(ah.this));
                        android.support.v4.content.d.W(context2).b(intent);
                        AppMethodBeat.o(203031);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", th.toString());
                        AppMethodBeat.o(203031);
                    }
                }
            };
            AppMethodBeat.o(96717);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
            AppMethodBeat.o(96717);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.buo;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXe() {
        int i2;
        int i3;
        boolean z;
        AppMethodBeat.i(96718);
        if (!s.YS(h.kz("adId", ((v) this.EcX).DYR))) {
            this.Efd = false;
        }
        if (!s.YS(com.tencent.mm.loader.j.b.aKJ() + "/sns_ad_landingpages/adId_stream_" + MD5Util.getMD5String(((v) this.EcX).DYQ))) {
            this.Efe = false;
        }
        View findViewById = this.contentView.findViewById(R.id.hw0);
        this.Egn = findViewById;
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(R.id.hvt);
        this.EfZ = new OfflineVideoView(this.context);
        this.Ego = viewGroup;
        viewGroup.addView(this.EfZ, new LinearLayout.LayoutParams(-1, -1));
        if (((v) this.EcX).DYW == 0) {
            if (((int) ((v) this.EcX).width) > 0) {
                int i4 = this.mEX;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, (int) ((((float) i4) * ((v) this.EcX).height) / ((v) this.EcX).width));
                viewGroup.setLayoutParams(layoutParams);
                findViewById.setLayoutParams(layoutParams);
            } else {
                viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
            }
            if (!((v) this.EcX).DYY) {
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "fixVideoBlackline, enable=false");
            } else {
                View innerVideoView = this.EfZ.getInnerVideoView();
                if (innerVideoView instanceof VideoPlayerTextureView) {
                    innerVideoView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass6 */

                        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                            AppMethodBeat.i(203029);
                            try {
                                int height = view.getHeight();
                                int width = view.getWidth();
                                int width2 = ah.this.Egn.getWidth();
                                int height2 = ah.this.Egn.getHeight();
                                if (width <= 1 || height <= 1 || width2 == 0 || height2 == 0) {
                                    AppMethodBeat.o(203029);
                                    return;
                                }
                                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, video.w=" + view.getWidth() + ", h=" + view.getHeight() + ", container.w=" + width2 + ", h=" + height2 + ", container.padding=" + k.fg(ah.this.Egn));
                                if (!(height == height2 && width == width2)) {
                                    ViewGroup.LayoutParams layoutParams = ah.this.Egn.getLayoutParams();
                                    layoutParams.height = height;
                                    layoutParams.width = width;
                                    ah.this.Egn.setLayoutParams(layoutParams);
                                    Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, reset VideoContainer.height and width");
                                }
                                AppMethodBeat.o(203029);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, exp=" + e2.toString());
                                AppMethodBeat.o(203029);
                            }
                        }
                    });
                } else {
                    Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, innerVideoView=" + innerVideoView + ", displayType=" + ((v) this.EcX).DYW);
                }
            }
        } else if (((v) this.EcX).DYW == 1) {
            if (((v) this.EcX).width / ((float) this.mEX) > ((v) this.EcX).height / ((float) this.mEY)) {
                int i5 = this.mEX;
                i3 = ((int) ((((float) i5) * ((v) this.EcX).height) / ((v) this.EcX).width)) + 1;
                i2 = i5;
            } else {
                int i6 = this.mEY;
                i2 = ((int) ((((float) i6) * ((v) this.EcX).width) / ((v) this.EcX).height)) + 1;
                i3 = i6;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i3);
            layoutParams2.leftMargin = (this.mEX - i2) / 2;
            layoutParams2.rightMargin = layoutParams2.leftMargin;
            layoutParams2.topMargin = (this.mEY - i3) / 2;
            layoutParams2.bottomMargin = layoutParams2.topMargin;
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
        } else if (((v) this.EcX).DYW == 2) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) ((v) this.EcX).width, (int) ((v) this.EcX).height);
            viewGroup.setLayoutParams(layoutParams3);
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams3));
        }
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "createView, displayType=" + ((v) this.EcX).DYW);
        String kz = h.kz("adId", ((v) this.EcX).DYR);
        if (s.YS(kz)) {
            this.EfZ.aQV(kz);
        } else {
            h.a("adId", ((v) this.EcX).DYR, false, 1000000001, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(203032);
                    ah.this.EfZ.aQV(str);
                    AppMethodBeat.o(203032);
                }
            });
        }
        this.EeT = (TextView) findViewById.findViewById(R.id.c4k);
        this.EeT.setText(this.context.getString(R.string.bnp));
        this.maskView = findViewById.findViewById(R.id.hw6);
        if (this.maskView != null) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            ViewParent parent = this.maskView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.maskView);
            }
            ((ViewGroup) findViewById).addView(this.maskView, layoutParams4);
        }
        this.EeQ = (ImageView) findViewById.findViewById(R.id.hw8);
        this.EeQ.setVisibility(0);
        this.EeQ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(96714);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ah.this.Efj++;
                ah.a(ah.this, ah.this.EeU);
                if (ah.this.EeY) {
                    ah.this.fcL();
                    ah.this.fcK();
                } else {
                    ah.this.fcJ();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(96714);
            }
        });
        try {
            ViewParent parent2 = this.EeQ.getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(this.EeQ);
            }
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.EeQ.getLayoutParams();
            layoutParams5.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
            layoutParams5.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
            ((ViewGroup) findViewById).addView(this.EeQ, layoutParams5);
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init voiceTypeBtn and visible");
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
        }
        this.EfZ.setVideoCallback(new OfflineVideoView.a() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
            public final boolean a(PString pString) {
                AppMethodBeat.i(203039);
                final long currentTimeMillis = System.currentTimeMillis();
                final String str = ah.f(ah.this).DYQ;
                final String kA = h.kA("adId", str);
                if (s.YS(kA)) {
                    pString.value = kA;
                    ah.this.vbV = true;
                    AppMethodBeat.o(203039);
                    return true;
                }
                if (!ah.f(ah.this).DYZ) {
                    h.b("adId", str, false, 62, new f.a() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass11.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWN() {
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWO() {
                            AppMethodBeat.i(203033);
                            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages fail:" + str);
                            ah.this.Efc = true;
                            ah.aPY(kA);
                            AppMethodBeat.o(203033);
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void aNH(String str) {
                            AppMethodBeat.i(203034);
                            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages succ, video view height " + ah.this.contentView.getHeight() + ", player height " + ah.this.EfZ.getHeight() + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                            ah.this.Efc = false;
                            ah.this.lPw = str;
                            ah.this.EfZ.asy(str);
                            ah.this.vbV = true;
                            AppMethodBeat.o(203034);
                        }
                    });
                } else {
                    h.b("adId", str, new f.a() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass11.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWN() {
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWO() {
                            AppMethodBeat.i(203035);
                            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn fail:" + str);
                            ah.this.Efc = true;
                            AppMethodBeat.o(203035);
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void aNH(String str) {
                            AppMethodBeat.i(203036);
                            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn succ, video view height " + ah.this.contentView.getHeight() + ", player height " + ah.this.EfZ.getHeight() + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                            ah.this.Efc = false;
                            ah.this.lPw = str;
                            ah.this.EfZ.asy(str);
                            ah.this.vbV = true;
                            AppMethodBeat.o(203036);
                        }
                    });
                }
                AppMethodBeat.o(203039);
                return false;
            }

            @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
            public final void onCompletion() {
                AppMethodBeat.i(203040);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass11.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(203037);
                        if (ah.f(ah.this).DYX != null && !ah.h(ah.this)) {
                            int durationMs = ah.this.EfZ.getDurationMs();
                            int i2 = ah.f(ah.this).DYX.Eab;
                            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, onCompletion totalMs=" + durationMs + ", floatStartTime=" + i2 + ", hasShowFloat=" + ah.h(ah.this));
                            if (durationMs < i2) {
                                ah.this.EeR = true;
                                pb pbVar = new pb();
                                pbVar.dVd.dVe = ah.f(ah.this).DYX.dVe;
                                EventCenter.instance.publish(pbVar);
                            }
                        }
                        AppMethodBeat.o(203037);
                    }
                });
                ah.j(ah.this);
                ah.this.DXu.Duo = true;
                ah.l(ah.this);
                AppMethodBeat.o(203040);
            }

            @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
            public final void onStart(int i2) {
                AppMethodBeat.i(203041);
                ah.this.hki = true;
                ah.this.Dzs = i2;
                ah.this.EeQ.setVisibility(0);
                try {
                    if (ah.this.EeP.getVideoTotalTime() != i2) {
                        ah.this.EeP.setVideoTotalTime(ah.this.Dzs);
                    }
                    Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onStart");
                    int i3 = (int) ah.this.fds().DZZ;
                    if (ah.this.context instanceof SnsAdNativeLandingPagesUI) {
                        SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) ah.this.context;
                        List<m> allComp = snsAdNativeLandingPagesUI.getAllComp();
                        if (allComp != null && allComp.size() > 0) {
                            m mVar = allComp.get(0);
                            if (mVar instanceof ah) {
                                ((ah) mVar).Egm = true;
                                Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "snsId = " + snsAdNativeLandingPagesUI.dRS + ", adSightVideoSeekTime = " + snsAdNativeLandingPagesUI.DZZ + ", isFirstSightVideoComp = true");
                            }
                        }
                        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "snsId = " + ah.this.fds().getSnsId() + ", adSightVideoSeekTime = " + i3 + ", isFirstSightVideoComp = " + ah.this.Egm);
                        if (ah.this.Egm && ah.iA(i3, i2 * 1000)) {
                            ah.this.EfZ.aU(i3, true);
                        }
                    }
                    AppMethodBeat.o(203041);
                } catch (Throwable th) {
                    Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
                    AppMethodBeat.o(203041);
                }
            }

            @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
            public final void xv(int i2) {
                AppMethodBeat.i(203042);
                ah.this.DXu.sendMessage();
                final int i3 = i2 / 1000;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass11.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(203038);
                        Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + i3 + " video time " + ah.this.Dzs);
                        ah.b(ah.this, i3);
                        if (ah.f(ah.this).DYX != null && !ah.h(ah.this)) {
                            int i2 = ah.f(ah.this).DYX.Eab / 1000;
                            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, updateTime seconds=" + i3 + ", floatSeconds=" + i2 + ", hasShowFloat=" + ah.h(ah.this));
                            if (i3 >= i2) {
                                ah.this.EeR = true;
                                pb pbVar = new pb();
                                pbVar.dVd.dVe = ah.f(ah.this).DYX.dVe;
                                EventCenter.instance.publish(pbVar);
                            }
                        }
                        AppMethodBeat.o(203038);
                    }
                });
                AppMethodBeat.o(203042);
            }
        });
        this.EfZ.setOnSeekCompleteCallback(new d());
        this.EeQ.setVisibility(8);
        this.EfZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(203043);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ah.this.hki) {
                    ah.this.Egb++;
                    if (ah.s(ah.this)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203043);
                        return;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203043);
            }
        });
        v vVar = (v) this.EcX;
        if (vVar.subType != 1 || vVar.DYT.length() <= 0 || vVar.DYS.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            View findViewById2 = this.contentView.findViewById(R.id.hvu);
            findViewById2.setVisibility(0);
            Button button = (Button) findViewById2.findViewById(R.id.hvv);
            button.setTextColor(((v) this.EcX).DYU);
            button.setText(((v) this.EcX).DYT);
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass13 */

                public final void onClick(View view) {
                    AppMethodBeat.i(203044);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ah.this.fdF();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203044);
                }
            });
            findViewById2.findViewById(R.id.hvw).setBackgroundColor(((v) this.EcX).DYV);
        }
        try {
            this.length = com.tencent.mm.cb.a.fromDPToPix(this.context, 32);
            this.EfZ.setOnTouchListener(this);
            this.Egd = (ImageView) findViewById.findViewById(R.id.hw7);
            ViewParent parent3 = this.Egd.getParent();
            if (parent3 instanceof ViewGroup) {
                ((ViewGroup) parent3).removeView(this.Egd);
            }
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.Egd.getLayoutParams();
            layoutParams6.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
            layoutParams6.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
            ((ViewGroup) findViewById).addView(this.Egd, layoutParams6);
            this.Egd.setOnClickListener(this);
            this.Egd.setVisibility(8);
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init fullScreenBtn and visible");
        } catch (Throwable th2) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th2.toString());
        }
        try {
            this.EeP = new VideoPlayerSeekBar(this.context);
            ViewParent parent4 = this.EeP.getParent();
            if (parent4 instanceof ViewGroup) {
                ((ViewGroup) parent4).removeView(this.EeP);
            }
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(this.Ego.getLayoutParams().width - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
            layoutParams7.addRule(12);
            layoutParams7.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 3);
            this.EeP.setLayoutParams(layoutParams7);
            ((ViewGroup) this.contentView.findViewById(R.id.bf6)).addView(this.EeP, layoutParams7);
            YY(0);
            this.EeP.setOnPlayButtonClickListener(this.Efl);
            this.EeP.setIplaySeekCallback(this.tni);
            this.EeP.setVisibility(4);
            if (this.Efk != null) {
                this.Efk.vg(this.EeP.getVisibility() == 0);
            }
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init progressBar and visible");
        } catch (Throwable th3) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th3.toString());
        }
        try {
            this.Ege = findViewById.findViewById(R.id.g9_);
            this.Ege.setVisibility(8);
            AppMethodBeat.o(96718);
        } catch (Throwable th4) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th4.toString());
            AppMethodBeat.o(96718);
        }
    }

    private void vh(boolean z) {
        AppMethodBeat.i(203048);
        try {
            this.EeP.setIsPlay(z);
            this.EeP.getPlayBtn().getLayoutParams().width = this.length;
            this.EeP.getPlayBtn().getLayoutParams().height = this.length;
            if (z) {
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "startPlay");
                this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.media_player_btn_cur_status_on));
                AppMethodBeat.o(203048);
                return;
            }
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "pausePlay");
            this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.media_player_btn_cur_status_off));
            AppMethodBeat.o(203048);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
            AppMethodBeat.o(203048);
        }
    }

    private void YY(final int i2) {
        AppMethodBeat.i(203049);
        try {
            this.hAk.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(203045);
                    ah.this.EeP.seek(i2);
                    ah.b(ah.this, ah.this.EfZ.isPlaying());
                    AppMethodBeat.o(203045);
                }
            });
            AppMethodBeat.o(203049);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
            AppMethodBeat.o(203049);
        }
    }

    private void czw() {
        AppMethodBeat.i(96721);
        if (this.Efc) {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
            this.EfZ.cWZ();
            AppMethodBeat.o(96721);
            return;
        }
        Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
        if (!this.vbV && !TextUtils.isEmpty(this.lPw)) {
            this.EfZ.asy(this.lPw);
            this.vbV = true;
        }
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(203027);
                ah.this.EfZ.fge();
                ah.z(ah.this);
                try {
                    ah.b(ah.this, true);
                    ah.this.hAk.removeCallbacks(ah.this.Egg);
                    ah.this.Ege.setVisibility(8);
                    AppMethodBeat.o(203027);
                } catch (Throwable th) {
                    Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", th.toString());
                    AppMethodBeat.o(203027);
                }
            }
        });
        this.AhP = System.currentTimeMillis();
        this.Aiv++;
        AppMethodBeat.o(96721);
    }

    private void vi(final boolean z) {
        AppMethodBeat.i(203050);
        Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(203028);
                ah.this.EfZ.fgd();
                try {
                    ah.b(ah.this, false);
                    if (ah.this.hki && z) {
                        ah.this.Ege.setVisibility(0);
                        ah.a(ah.this, ah.this.Egg);
                    }
                    AppMethodBeat.o(203028);
                } catch (Throwable th) {
                    Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", th.toString());
                    AppMethodBeat.o(203028);
                }
            }
        });
        if (this.AhP != 0) {
            this.Efg = (int) (((long) this.Efg) + (System.currentTimeMillis() - this.AhP));
            this.AhP = 0;
        }
        AppMethodBeat.o(203050);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final boolean isPlaying() {
        AppMethodBeat.i(203051);
        boolean isPlaying = this.EfZ.isPlaying();
        AppMethodBeat.o(203051);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void fcJ() {
        AppMethodBeat.i(96723);
        super.fcJ();
        this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.icon_volume_off));
        this.EfZ.setMute(true);
        this.EeY = true;
        AppMethodBeat.o(96723);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void fcK() {
        AppMethodBeat.i(96724);
        super.fcK();
        this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.icon_volume_on));
        this.EfZ.setMute(false);
        this.EeY = false;
        AppMethodBeat.o(96724);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eWZ() {
        AppMethodBeat.i(96725);
        super.eWZ();
        AppMethodBeat.o(96725);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXa() {
        AppMethodBeat.i(96726);
        super.eXa();
        abandonAudioFocus();
        vi(false);
        if (this.Efa || this.Efb) {
            this.Efb = false;
            this.Efa = false;
            if (this.Eff == 1) {
                this.Eff = 2;
            }
            int i2 = this.Eff;
            Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", Integer.valueOf(this.Eff));
            AppMethodBeat.o(96726);
            return;
        }
        AppMethodBeat.o(96726);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXd() {
        AppMethodBeat.i(96727);
        super.eXd();
        try {
            this.hAk.removeCallbacks(this.EeU);
            this.hAk.removeCallbacks(this.Egg);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
        }
        abandonAudioFocus();
        this.EfZ.onDestroy();
        AppMethodBeat.o(96727);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXb() {
        AppMethodBeat.i(96728);
        super.eXb();
        int fdl = fdl();
        int height = getView().getHeight();
        Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", Integer.valueOf(fdl), Integer.valueOf(height));
        if (fdl == 0 || height == 0) {
            AppMethodBeat.o(96728);
            return;
        }
        this.Egc = fdl;
        this.gRE = height;
        if (fdl < 0) {
            AppMethodBeat.o(96728);
            return;
        }
        Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", Integer.valueOf(this.Eff));
        if (((float) fdl) < ((float) height) * 0.5f) {
            this.Efb = false;
            this.Efa = false;
            vi(false);
            if (this.Eff == 1) {
                this.Eff = 2;
            }
            int i2 = this.Eff;
        } else if (!this.Efa || this.Efb) {
            this.Efb = false;
            this.Efa = true;
            if (this.Eff == 6) {
                if (this.Egf) {
                    this.Eff = 1;
                    AppMethodBeat.o(96728);
                    return;
                }
                this.Eff = 4;
                AppMethodBeat.o(96728);
                return;
            } else if (this.Eff == 0) {
                if (this.EeY) {
                    fcJ();
                } else {
                    fcK();
                }
                this.Eff = 1;
                czw();
                AppMethodBeat.o(96728);
                return;
            } else if (this.Eff == 2) {
                if (this.EeY) {
                    fcJ();
                } else {
                    fcK();
                }
                czw();
                this.Eff = 1;
                AppMethodBeat.o(96728);
                return;
            } else if (this.Eff == 3) {
                if (this.EeY) {
                    fcJ();
                } else {
                    fcK();
                }
                czw();
                AppMethodBeat.o(96728);
                return;
            }
        } else {
            AppMethodBeat.o(96728);
            return;
        }
        AppMethodBeat.o(96728);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        Object obj;
        AppMethodBeat.i(96729);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96729);
            return false;
        }
        try {
            jSONObject.put("sightDuration", this.Dzs * 1000);
            jSONObject.put("playTimeInterval", this.Efg);
            jSONObject.put("playCount", this.Aiv);
            jSONObject.put("playCompletedCount", this.Efh);
            jSONObject.put("clickPlayControlCount", this.Efi);
            jSONObject.put("doubleClickCount", this.Egh);
            jSONObject.put("clickFullscreenBtnCount", this.Egi);
            jSONObject.put("clickVoiceControlCount", this.Efj);
            if (this.isAutoPlay) {
                obj = "1";
            } else {
                obj = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            jSONObject.put("isAutoPlay", obj);
            if (((v) this.EcX).type == 61) {
                jSONObject.put("clickSightCount", this.Egb);
            }
            if (!this.Efe) {
                String mD5String = MD5Util.getMD5String(((v) this.EcX).DYQ);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", mD5String);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("sightUrlInfo", jSONObject2);
            }
            if (!this.Efd) {
                String mD5String2 = MD5Util.getMD5String(((v) this.EcX).DYR);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("urlMd5", mD5String2);
                jSONObject3.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject3);
            }
            jSONObject.put("streamVideoEnterCount", this.Ega);
            jSONObject.put("streamVideoPlayCount", this.DvS);
            jSONObject.put("streamVideoPlayCompleteCount", this.DvT);
            jSONObject.put("streamVideoTotalPlayTimeInMs", this.DvU);
            if (this.Egj != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("cid", this.Egj.Egw);
                jSONObject4.put(com.tencent.mm.g.c.f.COL_EXPOSURECOUNT, this.Egj.Egx);
                jSONObject4.put("stayTime", this.Egj.Egy);
                jSONObject4.put("clickCount", this.Egj.Egz);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(com.tencent.mm.g.c.f.COL_EXPOSURECOUNT, this.Egj.Dzo);
                jSONObject5.put("stayTime", this.Egj.dUy);
                jSONObject5.put("clickCount", this.Egj.clickCount);
                jSONObject5.put("btnInfo", jSONObject4);
                jSONObject.put("fullVideoFloatBarInfo", jSONObject5);
            }
            AppMethodBeat.o(96729);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", e2, "", new Object[0]);
            AppMethodBeat.o(96729);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96730);
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
        AppMethodBeat.o(96730);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void fdq() {
        AppMethodBeat.i(96731);
        super.fdq();
        String kz = h.kz("adId", ((v) this.EcX).DYR);
        vi(false);
        if (s.YS(kz)) {
            this.EfZ.aQV(kz);
            this.EfZ.d(false, 0.0f);
        }
        AppMethodBeat.o(96731);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (com.tencent.mm.vfs.s.deleteFile(r7) != false) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void aPY(java.lang.String r7) {
        /*
            r1 = 1
            r6 = 203052(0x3192c, float:2.84536E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            r2 = 0
            java.lang.String r0 = "0"
            boolean r3 = com.tencent.mm.vfs.s.YS(r7)     // Catch:{ Throwable -> 0x0037 }
            if (r3 == 0) goto L_0x0056
            java.lang.String r0 = "1"
            boolean r3 = com.tencent.mm.vfs.s.deleteFile(r7)     // Catch:{ Throwable -> 0x0037 }
            if (r3 == 0) goto L_0x0056
        L_0x001a:
            android.content.Context r2 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()     // Catch:{ Throwable -> 0x0037 }
            java.lang.String r2 = com.tencent.mm.sdk.platformtools.NetStatusUtil.getFormatedNetType(r2)     // Catch:{ Throwable -> 0x0037 }
            java.lang.String r3 = com.tencent.mm.plugin.sns.data.j.DEa     // Catch:{ Throwable -> 0x0037 }
            r4 = 1
            java.lang.String r5 = "http|"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x0037 }
            java.lang.String r2 = r5.concat(r2)     // Catch:{ Throwable -> 0x0037 }
            com.tencent.mm.plugin.sns.data.j.b(r3, r0, r4, r1, r2)     // Catch:{ Throwable -> 0x0037 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0036:
            return
        L_0x0037:
            r0 = move-exception
            java.lang.String r1 = "MicroMsg.Sns.AdLandingPageSightVideoComponent"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "delErrorFile exp="
            r2.<init>(r3)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            com.tencent.mm.sdk.platformtools.Log.e(r1, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            goto L_0x0036
        L_0x0056:
            r1 = r2
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.aPY(java.lang.String):void");
    }

    private void ay(Runnable runnable) {
        AppMethodBeat.i(203053);
        try {
            this.hAk.removeCallbacks(runnable);
            this.hAk.postDelayed(runnable, 4000);
            AppMethodBeat.o(203053);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
            AppMethodBeat.o(203053);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(203054);
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203054);
        return a2;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(203055);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.hw7) {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "click full screen btn");
            try {
                if (this.context instanceof SnsAdNativeLandingPagesUI) {
                    this.Egi++;
                    this.hAk.removeCallbacks(this.Egg);
                    this.Ege.setVisibility(8);
                    SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
                    b.Egv = (v) this.EcX;
                    ae.DJT = fds();
                    Intent intent = new Intent(snsAdNativeLandingPagesUI, VideoFullScreenActivity.class);
                    intent.putExtra("KComponentVideoType", 0);
                    intent.putExtra("KComponentCid", fdn());
                    intent.putExtra("KComponentCurrentTime", this.EfZ.getCurrentPositionMs());
                    intent.putExtra("KComponentTotalTime", this.EfZ.getDurationMs());
                    intent.putExtra("KComponentVoiceType", this.EeY);
                    intent.putExtra("KComponentProgressType", this.EfZ.isPlaying());
                    intent.putExtra("KComponentVideoSightThumbUrl", ((v) this.EcX).DYR);
                    intent.putExtra("KComponentStreamVideoUrlPath", ((v) this.EcX).DYQ);
                    snsAdNativeLandingPagesUI.startActivityForResult(intent, 2000);
                } else {
                    this.Egd.setVisibility(8);
                }
            } catch (Throwable th) {
                this.Egd.setVisibility(8);
                Log.e("VideoFullScreenActivity", th.toString());
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203055);
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(203056);
        try {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSingleTapConfirmed");
            if (((v) this.EcX).DZa) {
                AppMethodBeat.o(203056);
                return false;
            }
            if (this.hki) {
                boolean z2 = this.EeP.getVisibility() == 0;
                if (z2) {
                    this.EeP.setVisibility(4);
                    this.Egd.setVisibility(4);
                    this.hAk.removeCallbacks(this.EeU);
                } else {
                    this.EeP.setVisibility(0);
                    this.Egd.setVisibility(0);
                    ay(this.EeU);
                }
                if (this.Efk != null) {
                    ao aoVar = this.Efk;
                    if (!z2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aoVar.vg(z);
                }
            }
            AppMethodBeat.o(203056);
            return false;
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
        }
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(203057);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        try {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onDoubleTap");
            ay(this.EeU);
            if (this.hki) {
                this.Egh++;
            }
            if (this.EfZ.isPlaying()) {
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
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203057);
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
        AppMethodBeat.i(203058);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203058);
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(203059);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(203059);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final void a(int i2, boolean z, boolean z2, int i3, int i4, int i5, int i6, int i7, long j2, String str, long j3) {
        AppMethodBeat.i(203060);
        try {
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
            if (z2) {
                this.AhP = System.currentTimeMillis();
            }
            if (!Util.isNullOrNil(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (this.Egj == null) {
                        this.Egj = new c();
                    }
                    this.Egj.Dzo += jSONObject.optInt(com.tencent.mm.g.c.f.COL_EXPOSURECOUNT);
                    this.Egj.dUy += jSONObject.optLong("stayTime");
                    this.Egj.clickCount += jSONObject.optInt("clickCount");
                    JSONObject optJSONObject = jSONObject.optJSONObject("btnInfo");
                    this.Egj.Egw = optJSONObject.optString("cid");
                    this.Egj.Egx += optJSONObject.optInt(com.tencent.mm.g.c.f.COL_EXPOSURECOUNT);
                    this.Egj.Egy += optJSONObject.optLong("stayTime");
                    c cVar = this.Egj;
                    cVar.Egz = optJSONObject.optInt("clickCount") + cVar.Egz;
                } catch (Throwable th) {
                    this.Egj = null;
                    Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", th.toString());
                }
            }
            this.hAk.removeCallbacks(this.Egg);
            this.Ege.setVisibility(8);
            Log.i("VideoFullScreenActivity", "currPosSec = " + i2 + ", isPlaying = " + z2 + ", bNoVoice = " + z);
            int i8 = i2 / 1000;
            if (i8 >= this.Dzs || i2 < 0) {
                this.EeP.seek(0);
                this.EfZ.aU(0, z2);
            } else {
                this.EeP.seek(i8);
                this.EfZ.aU(i2, z2);
            }
            vh(z2);
            if (z) {
                fcJ();
                AppMethodBeat.o(203060);
                return;
            }
            fcK();
            AppMethodBeat.o(203060);
        } catch (Throwable th2) {
            Log.e("VideoFullScreenActivity", th2.toString());
            AppMethodBeat.o(203060);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void cWX() {
        AppMethodBeat.i(203061);
        vi(false);
        this.Eff = 4;
        AppMethodBeat.o(203061);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void cWY() {
        AppMethodBeat.i(203062);
        this.Eff = 3;
        czw();
        AppMethodBeat.o(203062);
    }

    private void abandonAudioFocus() {
        AudioManager audioManager;
        AppMethodBeat.i(203063);
        try {
            if (!(this.Egl == null || (audioManager = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) == null)) {
                audioManager.abandonAudioFocus(this.Egl);
                this.Egl = null;
            }
            AppMethodBeat.o(203063);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "abandonAudioFocus has something wrong!");
            AppMethodBeat.o(203063);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        a() {
        }

        public final void onAudioFocusChange(int i2) {
            AppMethodBeat.i(203046);
            try {
                ah.YZ(i2);
                AppMethodBeat.o(203046);
            } catch (Throwable th) {
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onAudioFocusChanged has something wrong!");
                AppMethodBeat.o(203046);
            }
        }
    }

    class d implements j.c {
        d() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.c
        public final void fN(boolean z) {
            AppMethodBeat.i(203047);
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeekComplete is called");
            ah.this.DXu.sendMessage();
            AppMethodBeat.o(203047);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final long fdo() {
        AppMethodBeat.i(203064);
        long fdo = super.fdo() + this.Egk;
        AppMethodBeat.o(203064);
        return fdo;
    }

    /* access modifiers changed from: package-private */
    public static class c {
        int Dzo;
        String Egw;
        int Egx;
        long Egy;
        int Egz;
        int clickCount;
        long dUy;

        c() {
        }
    }

    public final void fdF() {
        AppMethodBeat.i(96719);
        v vVar = (v) this.EcX;
        if (Util.isNullOrNil(vVar.DYS)) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
            AppMethodBeat.o(96719);
        } else if (!(this.context instanceof Activity)) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
            AppMethodBeat.o(96719);
        } else {
            Log.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", vVar.DYS);
            Intent intent = new Intent();
            if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0) {
                intent.setClass(this.context, SnsAdStreamVideoPlayUI.class);
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "use new stream video play UI");
            } else {
                intent.setClass(this.context, VideoAdPlayerUI.class);
            }
            intent.putExtra("KFromTimeLine", true);
            intent.putExtra("KMediaId", MD5Util.getMD5String(vVar.DYS));
            intent.putExtra("KThumUrl", vVar.DYR);
            intent.putExtra("KStremVideoUrl", vVar.DYS);
            intent.putExtra("ForceLandscape", true);
            intent.putExtra("ShareBtnHidden", 1);
            intent.putExtra("KComponentCid", fdn());
            ((Activity) this.context).startActivityForResult(intent, 2004);
            this.Ega++;
            AppMethodBeat.o(96719);
        }
    }

    private boolean fdG() {
        AppMethodBeat.i(96720);
        if (!Util.isNullOrNil(((v) this.EcX).DYd)) {
            Intent intent = new Intent();
            intent.putExtra("sns_landig_pages_from_source", 14);
            intent.putExtra("sns_landig_pages_origin_from_source", fds().DZU);
            intent.putExtra("sns_landing_pages_ux_info", fds().uxInfo);
            intent.putExtra("sns_landing_pages_xml", "");
            intent.putExtra("sns_landing_pages_canvasid", ((v) this.EcX).DYd);
            intent.putExtra("sns_landing_pages_canvas_ext", ((v) this.EcX).DYe);
            intent.putExtra("sns_landing_pages_no_store", ((v) this.EcX).DYf);
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            if ((this.context instanceof Activity) && fds().bizId == 2) {
                String stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                String stringExtra2 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                if (!Util.isNullOrNil(stringExtra)) {
                    String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", valueOf);
                        jSONObject.put("cid", ((v) this.EcX).DZi);
                        jSONObject.put("adBuffer", !Util.isNullOrNil(stringExtra2) ? stringExtra2 : "");
                        jSONObject.put("preSessionId", stringExtra);
                    } catch (Exception e2) {
                    }
                    intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
                    intent.putExtra("sns_landing_pages_sessionId", valueOf);
                    intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
                }
            }
            int[] iArr = new int[2];
            this.EfZ.getLocationOnScreen(iArr);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_width", this.EfZ.getWidth());
            intent.putExtra("img_gallery_height", this.EfZ.getHeight());
            com.tencent.mm.br.c.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
            AppMethodBeat.o(96720);
            return true;
        }
        AppMethodBeat.o(96720);
        return false;
    }

    static /* synthetic */ void a(ah ahVar) {
        boolean z = false;
        AppMethodBeat.i(203065);
        try {
            if (ahVar.hki) {
                if (ahVar.EeP.getVisibility() == 0) {
                    z = true;
                }
                if (z) {
                    ahVar.EeP.setVisibility(4);
                    ahVar.Egd.setVisibility(4);
                    if (ahVar.Efk != null) {
                        ahVar.Efk.vg(false);
                    }
                }
            }
            AppMethodBeat.o(203065);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", th.toString());
            AppMethodBeat.o(203065);
        }
    }

    static /* synthetic */ v f(ah ahVar) {
        return (v) ahVar.EcX;
    }

    static /* synthetic */ void l(ah ahVar) {
        AppMethodBeat.i(203068);
        ahVar.EfZ.aT(0, true);
        AppMethodBeat.o(203068);
    }

    static /* synthetic */ boolean iA(int i2, int i3) {
        return i2 > 0 && i2 < i3;
    }

    static /* synthetic */ void z(ah ahVar) {
        AppMethodBeat.i(203074);
        try {
            if (ahVar.Egl == null) {
                ahVar.Egl = new a();
                AudioManager audioManager = (AudioManager) ahVar.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (audioManager != null) {
                    int requestAudioFocus = audioManager.requestAudioFocus(ahVar.Egl, 3, 2);
                    if (requestAudioFocus == 1) {
                        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "requestAudioFocus successfully!");
                        AppMethodBeat.o(203074);
                        return;
                    }
                    Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "requestAudioFocus is not granted. value = ".concat(String.valueOf(requestAudioFocus)));
                }
            }
            AppMethodBeat.o(203074);
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "requestAudioFocus has something wrong!");
            AppMethodBeat.o(203074);
        }
    }

    static /* synthetic */ void YZ(int i2) {
        AppMethodBeat.i(203075);
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onAudioFocusChanged is called".concat(String.valueOf(i2)));
        AppMethodBeat.o(203075);
    }
}
