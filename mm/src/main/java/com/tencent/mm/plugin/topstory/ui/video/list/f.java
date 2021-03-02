package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.list.g;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;
import java.util.Locale;
import java.util.UUID;

public final class f extends com.tencent.mm.plugin.topstory.ui.video.f {
    private k Goo;
    private View.OnClickListener Gop;
    private View Gov;
    private TextView Gow;
    private TextView Gox;
    private ImageView Goy;
    private ImageView Goz;
    private g GpG;
    private View GpH;
    private TextView GpI;
    private boolean isLoading;
    private i.b wcv = new i.b() {
        /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass12 */

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void c(String str, String str2, String str3, int i2, int i3) {
            eiw acd;
            int i4;
            eiy eiy;
            int i5 = 0;
            AppMethodBeat.i(126445);
            Log.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 != 0 && (acd = f.this.GlS.fyO().acd(f.this.GlS.fyH())) != null && acd.Niw != null) {
                Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", Integer.valueOf(i2), Integer.valueOf(acd.Niw.size()), acd.videoUrl, Integer.valueOf(acd.NiF));
                int i6 = 0;
                while (true) {
                    if (i6 >= acd.Niw.size()) {
                        break;
                    } else if (!acd.videoUrl.equals(acd.Niw.get(i6).url)) {
                        i6++;
                    } else if (i6 + 1 < acd.Niw.size() && (eiy = acd.Niw.get((i4 = i6 + 1))) != null && !Util.isNullOrNil(eiy.url)) {
                        acd.NiF = eiy.NiF;
                        acd.videoUrl = eiy.url;
                        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", Integer.valueOf(i4), eiy.url, Integer.valueOf(eiy.NiF));
                        b.pl(b.IFT);
                        f.this.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass12.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(126444);
                                f.this.ay(true, true);
                                AppMethodBeat.o(126444);
                            }
                        }, 100);
                        AppMethodBeat.o(126445);
                        return;
                    }
                }
            }
            f.this.GlS.fyO().a(f.this.GlS.fyD(), f.this.GlS.fyH());
            f.this.lg(f.this.getContext().getString(R.string.hwj, i2 + ":" + i3), f.this.getContext().getString(R.string.hxp));
            f.this.getListVideoUIComponent().fyF().onError(str);
            com.tencent.mm.plugin.topstory.a.i.abQ(i2);
            com.tencent.mm.plugin.topstory.a.b.b bVar = f.this.getListVideoUIComponent().fyB().GnT;
            if (bVar != null && bVar.Gjm > 0) {
                i5 = ((int) (System.currentTimeMillis() - bVar.Gjm)) / 1000;
            }
            com.tencent.mm.plugin.topstory.a.i.a(f.this.GjH, i2, str3, i5);
            AppMethodBeat.o(126445);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dH(String str, String str2) {
            AppMethodBeat.i(126446);
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
            f.this.Goo.bKZ();
            if (!f.this.isLoading) {
                f.this.fyX();
            }
            AppMethodBeat.o(126446);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dI(String str, String str2) {
            AppMethodBeat.i(126447);
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", Integer.valueOf(f.this.Gmk.fyz()), Integer.valueOf(f.this.Gmk.fyz()));
            f.this.getListVideoUIComponent().fyF().aTH(str);
            f.this.getListVideoUIComponent().fyB().GnS = 1;
            if (!f.this.getListVideoUIComponent().abU(f.this.Gmk.fyz() + 1) && (f.this.Gmk instanceof h)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e2) {
                }
                ((h) f.this.Gmk).wu(true);
            }
            f.this.GpG.setVisibility(8);
            f.this.isLoading = false;
            AppMethodBeat.o(126447);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void d(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(126448);
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(126448);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dJ(String str, String str2) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dK(String str, String str2) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dL(String str, String str2) {
            AppMethodBeat.i(126449);
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
            f.this.isLoading = true;
            AppMethodBeat.o(126449);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dM(String str, String str2) {
            AppMethodBeat.i(126450);
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
            f.this.isLoading = false;
            f.this.GpG.setVisibility(8);
            if (f.this.GjH.NiG != null) {
                Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onVideoWaitingEnd");
                f.this.GpH.setVisibility(0);
            }
            f.this.fyX();
            com.tencent.mm.plugin.topstory.a.b.b bVar = f.this.getListVideoUIComponent().fyB().GnT;
            if (bVar != null && bVar.Gjx == 0) {
                bVar.Gjx = System.currentTimeMillis() - bVar.Gjm;
                Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", Long.valueOf(bVar.Gju), Long.valueOf(bVar.Gjx));
            }
            AppMethodBeat.o(126450);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void fo(String str, String str2) {
        }
    };

    static /* synthetic */ boolean ap(f fVar) {
        AppMethodBeat.i(236401);
        boolean bJf = fVar.bJf();
        AppMethodBeat.o(236401);
        return bJf;
    }

    public f(Context context, com.tencent.mm.plugin.topstory.ui.video.b bVar, com.tencent.mm.plugin.topstory.ui.video.a aVar) {
        super(context, bVar, aVar);
        AppMethodBeat.i(126459);
        AppMethodBeat.o(126459);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final int getLayoutId() {
        return R.layout.c47;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void init() {
        AppMethodBeat.i(126460);
        super.init();
        this.GpH = findViewById(R.id.et1);
        this.GpI = (TextView) findViewById(R.id.et0);
        this.Gov = findViewById(R.id.ged);
        this.Gow = (TextView) findViewById(R.id.gee);
        this.Gox = (TextView) findViewById(R.id.geb);
        this.Goy = (ImageView) findViewById(R.id.gec);
        this.Goz = (ImageView) findViewById(R.id.gea);
        this.Gop = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(126429);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.this.getListVideoUIComponent().KD();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126429);
            }
        };
        this.GlZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(126436);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (f.this.Gmm == f.a.MOBILE_NET) {
                    f.this.getListVideoUIComponent().fyA().Gnu = true;
                    f.this.GlS.abW(2);
                }
                if (f.this.getListVideoUIComponent().fyA().isConnected()) {
                    f.this.Gmm = f.a.UNKNOWN;
                    if (f.this.getListVideoUIComponent().fyF().GnZ) {
                        f.this.getListVideoUIComponent().fyF().eYd();
                        f.this.fyX();
                    } else {
                        f.this.ay(true, false);
                    }
                    com.tencent.mm.plugin.websearch.api.a.a.pl(19);
                } else {
                    com.tencent.mm.plugin.websearch.api.a.a.pl(20);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126436);
            }
        });
        this.GlX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(126437);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.this.getListVideoUIComponent().fyB().GnS = 2;
                if (f.this.getListItemUIComponent() == null || f.this.getListItemUIComponent().fyz() != f.this.getListVideoUIComponent().fyH()) {
                    f.this.getListVideoUIComponent().abU(f.this.Gmk.fyz());
                    f.this.getListVideoUIComponent().fyB().k(f.this.GjH);
                    ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().fyD(), f.this.GjH, f.this.Gmk.fyz(), 2, "");
                } else {
                    f.this.ay(!f.this.getListVideoUIComponent().fyA().Gnu, false);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126437);
            }
        });
        this.GlY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(126438);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.this.fzd();
                f.this.GpG.bJB();
                f.this.getListVideoUIComponent().fyB().GnS = 2;
                f.this.getListVideoUIComponent().fyF().a(f.this.getListVideoUIComponent(), f.this.GjH, f.this.sessionId, f.this.Gmk.fyz());
                f.this.fyX();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126438);
            }
        });
        this.Gmd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(126439);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(f.this.getListItemUIComponent() == null || f.this.getListItemUIComponent().fyz() == f.this.getListVideoUIComponent().fyH())) {
                    f.this.getListVideoUIComponent().fyB().GnS = 2;
                    f.this.getListVideoUIComponent().abU(f.this.Gmk.fyz());
                    f.this.getListVideoUIComponent().fyB().k(f.this.GjH);
                    ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().fyD(), f.this.GjH, f.this.Gmk.fyz(), 2, "");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126439);
            }
        });
        this.GpH.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(126440);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                eit eit = new eit();
                eit.scene = f.this.getListVideoUIComponent().fyD().scene;
                eit.sGQ = UUID.randomUUID().toString();
                eit.NhZ = f.this.getListVideoUIComponent().fyD().hes;
                eit.Nia = f.this.getListVideoUIComponent().fyD().Nia;
                eit.NhX = f.this.GjH.NiG.psI;
                eit.NhY = f.this.getListVideoUIComponent().fyD().NhY;
                eit.Nic = f.this.GjH.NiG;
                eit.dDv = "topstory";
                eit.hes = f.this.getListVideoUIComponent().fyD().hes;
                eit.Nib = f.this.GjH.Nip;
                eit.Nic.Nix = f.this.GjH.Nix;
                eit.IDO.addAll(f.this.GjH.NiG.IDO);
                ai.a(f.this.getListVideoUIComponent().eeF(), eit);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126440);
            }
        });
        if (this.Gov != null) {
            this.Gov.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass10 */

                public final void onClick(View view) {
                    AppMethodBeat.i(126442);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    f.a aVar = new f.a(MMApplicationContext.getContext());
                    aVar.bow(f.this.getContext().getString(R.string.hq6, f.this.GjH.NiI.NhN.NhK)).Dq(true);
                    aVar.apa(R.string.h4);
                    aVar.c(new f.c() {
                        /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass10.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.a.f.c
                        public final void e(boolean z, String str) {
                            AppMethodBeat.i(126441);
                            if (!(!z || f.this.GjH == null || f.this.GjH.NiI == null || f.this.GjH.NiI.NhN == null)) {
                                com.tencent.mm.plugin.topstory.a.i.a(f.this.GlS.fyD(), f.this.GjH, 2);
                                com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                                gVar.appId = f.this.GjH.NiI.NhN.appId;
                                gVar.kHw = f.this.GjH.NiI.NhN.ecK;
                                gVar.scene = 1152;
                                ((r) g.af(r.class)).a(f.this.getContext(), gVar);
                                f.this.Gov.setVisibility(8);
                            }
                            AppMethodBeat.o(126441);
                        }
                    }).show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126442);
                }
            });
        }
        if (this.Goz != null) {
            this.Goz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(126443);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    f.this.Gov.setVisibility(8);
                    com.tencent.mm.plugin.topstory.a.i.a(f.this.GlS.fyD(), f.this.GjH, 3);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126443);
                }
            });
        }
        this.Goo = new k(getContext(), this, new a());
        this.GpG = new g(getContext());
        this.GpG.setVisibility(8);
        this.GpG.setFullScreenBtnClickListener(this.Gop);
        this.GpG.setOnUpdateProgressLenListener(new g.a() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.topstory.ui.video.list.g.a
            public final void update(int i2, int i3) {
                int i4;
                AppMethodBeat.i(126430);
                if (i3 > 0) {
                    i4 = (f.this.Gmj.getWidth() * i2) / i3;
                } else {
                    i4 = 0;
                }
                com.tencent.mm.plugin.topstory.a.b.b bVar = f.this.getListVideoUIComponent().fyB().GnT;
                if (bVar != null && bVar.Gjp < ((long) f.this.getListVideoUIComponent().fyF().getCurrPosMs())) {
                    bVar.Gjp = (long) f.this.getListVideoUIComponent().fyF().getCurrPosMs();
                }
                if (f.this.getListVideoUIComponent().fyF().dFG()) {
                    int currPosMs = f.this.getListVideoUIComponent().fyF().getCurrPosMs() / 1000;
                    if (((PluginTopStoryUI) com.tencent.mm.kernel.g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(f.this.GjH.psI)) {
                        ((PluginTopStoryUI) com.tencent.mm.kernel.g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(f.this.GjH.psI, Integer.valueOf(currPosMs));
                    }
                }
                if (!f.this.GpG.bJw()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) f.this.Gmi.getLayoutParams();
                    layoutParams.width = i4;
                    f.this.Gmi.setLayoutParams(layoutParams);
                    f.this.Gmi.requestLayout();
                    f.this.Gmh.setVisibility(0);
                }
                if ((f.this.GjH.Nix & 256) <= 0) {
                    f.this.GlS.a(f.this.GjH, i2, i3);
                }
                f.this.GlS.a(f.this.GjH, f.this, i2);
                AppMethodBeat.o(126430);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.video.list.g.a
            public final void fzK() {
                AppMethodBeat.i(126431);
                f.this.Gmh.setVisibility(8);
                if (f.this.GjH.NiG != null) {
                    f.this.GpH.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) f.this.GpH.getLayoutParams();
                    layoutParams.bottomMargin = com.tencent.mm.cb.a.aH(f.this.getContext(), R.dimen.cn);
                    f.this.GpH.setLayoutParams(layoutParams);
                }
                if (f.this.Gov.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) f.this.Gov.getLayoutParams();
                    layoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(f.this.getContext(), R.dimen.cn);
                    f.this.Gov.setLayoutParams(layoutParams2);
                }
                AppMethodBeat.o(126431);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.video.list.g.a
            public final void fzL() {
                AppMethodBeat.i(126432);
                if (f.this.GjH.NiG != null) {
                    Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onControlBarGone");
                    f.this.GpH.setVisibility(8);
                }
                if (!f.this.getListVideoUIComponent().fyF().GnZ || (!f.this.getListVideoUIComponent().fyF().dFG() && !f.this.getListVideoUIComponent().fyF().Goa)) {
                    f.this.Gmh.setVisibility(8);
                } else {
                    f.this.Gmh.setVisibility(0);
                }
                if (f.this.Gov.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) f.this.Gov.getLayoutParams();
                    layoutParams.bottomMargin = com.tencent.mm.cb.a.aH(f.this.getContext(), R.dimen.ct);
                    f.this.Gov.setLayoutParams(layoutParams);
                }
                AppMethodBeat.o(126432);
            }
        });
        this.GpG.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
                AppMethodBeat.i(126433);
                Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
                f.this.GpG.crH();
                AppMethodBeat.o(126433);
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(126434);
                Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", Integer.valueOf(i2));
                f.this.seekTo(i2);
                f.this.GpG.bJB();
                com.tencent.mm.plugin.websearch.api.a.a.pl(22);
                AppMethodBeat.o(126434);
            }
        });
        this.GpG.setOnPlayButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.f.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(126435);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!f.this.getListVideoUIComponent().fyF().GnZ) {
                    Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
                } else if (f.this.GpG.getVideoTotalTime() - f.this.GpG.getmPosition() < 2) {
                    Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126435);
                    return;
                } else {
                    f.this.getListVideoUIComponent().fyB().k(f.this.GjH);
                    if (f.this.getListVideoUIComponent().fyF().dFG()) {
                        f.this.getListVideoUIComponent().fyF().cXa();
                        f.this.GpG.crH();
                    } else {
                        f.this.getListVideoUIComponent().fyF().eYd();
                        f.this.GpG.bJB();
                    }
                    f.this.fyX();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126435);
            }
        });
        AppMethodBeat.o(126460);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fyX() {
        AppMethodBeat.i(126461);
        super.fyX();
        AppMethodBeat.o(126461);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fyV() {
        AppMethodBeat.i(126462);
        Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
        this.Gmd.setVisibility(8);
        this.puw.setVisibility(0);
        this.GlU.setVisibility(8);
        this.GlT.setVisibility(8);
        this.Gmh.setVisibility(8);
        AppMethodBeat.o(126462);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fyW() {
        AppMethodBeat.i(126463);
        Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
        this.Gmd.setVisibility(0);
        this.puw.setVisibility(0);
        this.GlU.setVisibility(8);
        this.GlT.setVisibility(8);
        this.Gmh.setVisibility(8);
        this.Gmf.setVisibility(0);
        this.Gme.setVisibility(8);
        this.GlX.setVisibility(0);
        this.GlY.setVisibility(8);
        this.Gmb.setVisibility(8);
        AppMethodBeat.o(126463);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final boolean ay(boolean z, boolean z2) {
        AppMethodBeat.i(126464);
        boolean ay = super.ay(z, z2);
        getListVideoUIComponent().fyF().setMute(getListVideoUIComponent().Zx());
        AppMethodBeat.o(126464);
        return ay;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fzb() {
        AppMethodBeat.i(126465);
        g gVar = this.GpG;
        if (gVar.GoU != null) {
            gVar.GoU.stopTimer();
        }
        AppMethodBeat.o(126465);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void updateView() {
        String format;
        AppMethodBeat.i(126466);
        super.updateView();
        if (this.GpG != null) {
            this.GpG.setVideoTotalTime(this.GjH.Eso);
        }
        if (!(getListItemUIComponent() == null || getListItemUIComponent().fyz() == getListVideoUIComponent().fyH())) {
            if (getListVideoUIComponent().fyA().isConnected()) {
                fyY();
            } else {
                lg(getNoNetTip(), getContext().getString(R.string.hxp));
            }
        }
        if (this.GjH.NiG != null) {
            this.GpH.setVisibility(0);
            TextView textView = this.GpI;
            long j2 = (long) this.GjH.NiG.Eso;
            if (j2 <= 0) {
                format = "00:00";
            } else if (j2 < 60) {
                format = String.format(Locale.getDefault(), "00:%02d", Long.valueOf(j2 % 60));
            } else if (j2 < 3600) {
                format = String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60));
            } else {
                format = String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf(j2 / 3600), Long.valueOf((j2 % 3600) / 60), Long.valueOf(j2 % 60));
            }
            textView.setText(format);
            AppMethodBeat.o(126466);
            return;
        }
        this.GpH.setVisibility(8);
        AppMethodBeat.o(126466);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final i.e c(eiw eiw) {
        return i.e.CONTAIN;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fza() {
        AppMethodBeat.i(126467);
        if (this.GpG != null) {
            this.GpG.setVisibility(8);
        }
        AppMethodBeat.o(126467);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final i.b getVideoViewCallback() {
        return this.wcv;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(126468);
        if (this.Goo != null) {
            this.Goo.A(motionEvent);
        }
        AppMethodBeat.o(126468);
        return true;
    }

    private boolean bJf() {
        AppMethodBeat.i(126469);
        if (this.Gmd.getVisibility() == 0) {
            AppMethodBeat.o(126469);
            return true;
        }
        AppMethodBeat.o(126469);
        return false;
    }

    class a implements c {
        private float GoD;

        a() {
            AppMethodBeat.i(126451);
            this.GoD = (float) com.tencent.mm.cb.a.jo(f.this.getContext());
            AppMethodBeat.o(126451);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final void bJj() {
            AppMethodBeat.i(126452);
            Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
            if (f.al(f.this)) {
                if (f.this.GpG.bJw()) {
                    f.this.GpG.setVisibility(8);
                    AppMethodBeat.o(126452);
                    return;
                }
                f.this.GpG.show();
                if (f.this.getListItemUIComponent() != null) {
                    f.this.getListItemUIComponent().fyy();
                    f.this.getListItemUIComponent().fyx();
                }
            }
            AppMethodBeat.o(126452);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final void bJk() {
            AppMethodBeat.i(126453);
            Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
            AppMethodBeat.o(126453);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final void bJl() {
            AppMethodBeat.i(126454);
            f.this.GlU.setVisibility(0);
            f.this.GpG.fzM();
            AppMethodBeat.o(126454);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final int ce(float f2) {
            AppMethodBeat.i(126455);
            int videoDurationSec = f.this.getListVideoUIComponent().fyF().getVideoDurationSec();
            int currentPosition = ((int) ((f2 / this.GoD) * ((float) videoDurationSec))) + getCurrentPosition();
            if (currentPosition < 0) {
                currentPosition = 0;
            } else if (currentPosition > videoDurationSec) {
                currentPosition = videoDurationSec;
            }
            f.this.GlU.setText(com.tencent.mm.plugin.websearch.ui.a.AF(((long) currentPosition) * 1000) + FilePathGenerator.ANDROID_DIR_SEP + com.tencent.mm.plugin.websearch.ui.a.AF(((long) videoDurationSec) * 1000));
            AppMethodBeat.o(126455);
            return currentPosition;
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final void abX(int i2) {
            AppMethodBeat.i(126456);
            f.this.GpG.fzN();
            f.this.GlU.setVisibility(8);
            f.this.seekTo(i2);
            AppMethodBeat.o(126456);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final boolean fyT() {
            AppMethodBeat.i(126457);
            if (f.ap(f.this)) {
                AppMethodBeat.o(126457);
                return false;
            }
            AppMethodBeat.o(126457);
            return true;
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final int getCurrentPosition() {
            AppMethodBeat.i(126458);
            int currPosSec = f.this.getListVideoUIComponent().fyF().getCurrPosSec();
            AppMethodBeat.o(126458);
            return currPosSec;
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final g getControlBar() {
        return this.GpG;
    }

    public final eiw getVideoInfo() {
        return this.GjH;
    }

    public final b getListVideoUIComponent() {
        return (b) this.GlS;
    }

    public final a getListItemUIComponent() {
        return (a) this.Gmk;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fzf() {
        AppMethodBeat.i(126470);
        super.fzf();
        if (this.GjH.NiI == null || this.GjH.NiI.NhN == null) {
            this.Gov.setVisibility(8);
            AppMethodBeat.o(126470);
            return;
        }
        this.Gow.setText(this.GjH.NiI.NhN.title);
        this.Gox.setText(this.GjH.NiI.NhN.desc);
        q.bcV().a(this.GjH.NiI.NhN.uNR, this.Goy, Glu);
        this.Gov.setVisibility(0);
        com.tencent.mm.plugin.topstory.a.i.a(this.GlS.fyD(), this.GjH, 1);
        if (getControlBar().bJw()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Gov.getLayoutParams();
            layoutParams.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.cn);
            this.Gov.setLayoutParams(layoutParams);
            AppMethodBeat.o(126470);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Gov.getLayoutParams();
        layoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.ct);
        this.Gov.setLayoutParams(layoutParams2);
        AppMethodBeat.o(126470);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fzg() {
        AppMethodBeat.i(126471);
        super.fzg();
        this.Gov.setVisibility(8);
        AppMethodBeat.o(126471);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final boolean fzh() {
        AppMethodBeat.i(161627);
        if (this.Gov.getVisibility() == 0) {
            AppMethodBeat.o(161627);
            return true;
        }
        AppMethodBeat.o(161627);
        return false;
    }

    static /* synthetic */ boolean al(f fVar) {
        AppMethodBeat.i(236400);
        if (!fVar.bJf()) {
            AppMethodBeat.o(236400);
            return true;
        }
        AppMethodBeat.o(236400);
        return false;
    }
}
