package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.fs.f;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.a.f;

public class e extends f {
    protected f Gon;
    protected k Goo;
    protected View.OnClickListener Gop;
    protected View.OnClickListener Goq;
    protected View.OnClickListener Gor;
    protected View.OnClickListener Gos;
    protected View.OnClickListener Got;
    protected View.OnClickListener Gou;
    private View Gov;
    private TextView Gow;
    private TextView Gox;
    private ImageView Goy;
    private ImageView Goz;
    private boolean isLoading;
    private i.b wcv = new i.b() {
        /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass5 */

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void c(String str, String str2, String str3, int i2, int i3) {
            int i4;
            eiy eiy;
            int i5 = 0;
            AppMethodBeat.i(126257);
            Log.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i2), Integer.valueOf(i3));
            eiw acd = e.this.GlS.fyO().acd(e.this.GlS.fyH());
            if (acd != null && acd.Niw != null) {
                Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", Integer.valueOf(i2), Integer.valueOf(acd.Niw.size()), acd.videoUrl, Integer.valueOf(acd.NiF));
                int i6 = 0;
                while (true) {
                    if (i6 >= acd.Niw.size()) {
                        break;
                    } else if (!acd.videoUrl.equals(acd.Niw.get(i6).url)) {
                        i6++;
                    } else if (i6 + 1 < acd.Niw.size() && (eiy = acd.Niw.get((i4 = i6 + 1))) != null && !Util.isNullOrNil(eiy.url)) {
                        acd.NiF = eiy.NiF;
                        acd.videoUrl = eiy.url;
                        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", Integer.valueOf(i4), eiy.url, Integer.valueOf(eiy.NiF));
                        b.pl(b.IFT);
                        e.this.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(126256);
                                e.this.ay(true, true);
                                AppMethodBeat.o(126256);
                            }
                        }, 100);
                        AppMethodBeat.o(126257);
                        return;
                    }
                }
            }
            e.this.GlS.fyO().a(e.this.GlS.fyD(), e.this.GlS.fyH());
            e.this.lg(e.this.getContext().getString(R.string.hwj, i2 + ":" + i3), e.this.getContext().getString(R.string.hxp));
            e.this.getFSVideoUIComponent().fyF().onError(str);
            com.tencent.mm.plugin.topstory.a.i.abQ(i2);
            com.tencent.mm.plugin.topstory.a.b.b bVar = e.this.getFSVideoUIComponent().fyB().GnT;
            if (bVar != null && bVar.Gjm > 0) {
                i5 = ((int) (System.currentTimeMillis() - bVar.Gjm)) / 1000;
            }
            com.tencent.mm.plugin.topstory.a.i.a(acd, i2, str3, i5);
            AppMethodBeat.o(126257);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dH(String str, String str2) {
            AppMethodBeat.i(126258);
            Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
            e.this.Goo.bKZ();
            if (!e.this.isLoading) {
                e.this.fyX();
            }
            AppMethodBeat.o(126258);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dI(String str, String str2) {
            boolean abU;
            AppMethodBeat.i(126259);
            Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
            e.this.getFSVideoUIComponent().fyF().aTH(str);
            e.this.getFSVideoUIComponent().fyB().GnS = 1;
            int fyS = e.this.getFSVideoUIComponent().fyS();
            Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", Integer.valueOf(fyS));
            if (fyS != 1 || !e.this.getFSVideoUIComponent().fyL() || !(e.this.Gmk instanceof j)) {
                abU = e.this.getFSVideoUIComponent().abU(e.this.Gmk.fyz() + 1);
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e2) {
                }
                ((j) e.this.Gmk).wu(true);
                Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "VVideoAutoPlay replay succ");
                abU = true;
            }
            if (!abU && (e.this.Gmk instanceof h)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e3) {
                }
                ((h) e.this.Gmk).wu(true);
            }
            e.this.isLoading = false;
            AppMethodBeat.o(126259);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void d(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(126260);
            Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onGetVideoSize width=%d height=%d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(126260);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dJ(String str, String str2) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dK(String str, String str2) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dL(String str, String str2) {
            AppMethodBeat.i(126261);
            Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
            e.this.isLoading = true;
            AppMethodBeat.o(126261);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dM(String str, String str2) {
            AppMethodBeat.i(126262);
            Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
            e.this.isLoading = false;
            e.this.fyX();
            com.tencent.mm.plugin.topstory.a.b.b bVar = e.this.getFSVideoUIComponent().fyB().GnT;
            if (bVar != null && bVar.Gjx == 0) {
                bVar.Gjx = System.currentTimeMillis() - bVar.Gjm;
                Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", Long.valueOf(bVar.Gju), Long.valueOf(bVar.Gjx));
            }
            AppMethodBeat.o(126262);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void fo(String str, String str2) {
        }
    };

    static /* synthetic */ boolean ab(e eVar) {
        AppMethodBeat.i(236396);
        boolean bJf = eVar.bJf();
        AppMethodBeat.o(236396);
        return bJf;
    }

    public e(Context context, com.tencent.mm.plugin.topstory.ui.video.b bVar, com.tencent.mm.plugin.topstory.ui.video.a aVar) {
        super(context, bVar, aVar);
        AppMethodBeat.i(126286);
        if (this.GlS.fyL()) {
            this.puw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        AppMethodBeat.o(126286);
    }

    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public int getLayoutId() {
        return R.layout.c3u;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public void init() {
        AppMethodBeat.i(126287);
        super.init();
        if (!fzJ()) {
            this.Gov = findViewById(R.id.ged);
            this.Gow = (TextView) findViewById(R.id.gee);
            this.Gox = (TextView) findViewById(R.id.geb);
            this.Goy = (ImageView) findViewById(R.id.gec);
            this.Goz = (ImageView) findViewById(R.id.gea);
        }
        this.Gop = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(126251);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.this.getFSVideoUIComponent().KC();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126251);
            }
        };
        this.Goq = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(126270);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.this.getFSVideoUIComponent().ay(view, e.this.Gmk.fyz());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126270);
            }
        };
        this.Gor = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(126271);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.this.getFSItemUIComponent().acf(e.this.Gmk.fyz());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126271);
            }
        };
        this.Gos = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(126272);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.this.getFSVideoUIComponent().a(e.this.GjH, view);
                e.this.fzI();
                if (!e.this.fzJ()) {
                    e.this.Gov.setVisibility(8);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126272);
            }
        };
        this.Got = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(126273);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.topstory.ui.video.b fSVideoUIComponent = e.this.getFSVideoUIComponent();
                e.this.Gmk.fyz();
                fSVideoUIComponent.a((dyi) view.getTag());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126273);
            }
        };
        this.Gou = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(126274);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                n.a(e.this.GjH, e.this.getFSVideoUIComponent().eeF());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126274);
            }
        };
        this.GlZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(126275);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (e.this.Gmm == f.a.MOBILE_NET) {
                    e.this.getFSVideoUIComponent().fyA().Gnu = true;
                    e.this.GlS.abW(2);
                }
                if (e.this.getFSVideoUIComponent().fyA().isConnected()) {
                    e.this.Gmm = f.a.UNKNOWN;
                    if (e.this.getFSVideoUIComponent().fyF().GnZ) {
                        e.this.getFSVideoUIComponent().fyF().eYd();
                    } else {
                        e.this.ay(true, false);
                    }
                    com.tencent.mm.plugin.websearch.api.a.a.pl(19);
                } else {
                    com.tencent.mm.plugin.websearch.api.a.a.pl(20);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126275);
            }
        });
        this.GlX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(126276);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.this.getFSVideoUIComponent().fyB().GnS = 2;
                if (e.this.getFSItemUIComponent() == null || e.this.getFSItemUIComponent().fyz() != e.this.getFSVideoUIComponent().fyH()) {
                    e.this.getFSVideoUIComponent().abU(e.this.Gmk.fyz());
                    e.this.getFSVideoUIComponent().fyB().k(e.this.GjH);
                    ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().fyD(), e.this.GjH, e.this.Gmk.fyz(), 2, "");
                } else {
                    e.this.ay(!e.this.getFSVideoUIComponent().fyA().Gnu, false);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126276);
            }
        });
        this.GlY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(126277);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.this.fzd();
                e.this.Gon.bJB();
                e.this.getFSVideoUIComponent().fyB().GnS = 2;
                e.this.getFSVideoUIComponent().fyF().a(e.this.getFSVideoUIComponent(), e.this.GjH, e.this.sessionId, e.this.Gmk.fyz());
                e.this.fyX();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126277);
            }
        });
        this.Gmd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(126252);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(e.this.getFSItemUIComponent() == null || e.this.getFSItemUIComponent().fyz() == e.this.getFSVideoUIComponent().fyH())) {
                    e.this.getFSVideoUIComponent().fyB().GnS = 2;
                    e.this.getFSVideoUIComponent().abU(e.this.Gmk.fyz());
                    e.this.getFSVideoUIComponent().fyB().k(e.this.GjH);
                    ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().fyD(), e.this.GjH, e.this.Gmk.fyz(), 2, "");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126252);
            }
        });
        if (!fzJ()) {
            this.Gov.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(126254);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    f.a aVar = new f.a(MMApplicationContext.getContext());
                    aVar.bow(e.this.getContext().getString(R.string.hq6, e.this.GjH.NiI.NhN.NhK)).Dq(true);
                    aVar.apa(R.string.h4);
                    aVar.c(new f.c() {
                        /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.a.f.c
                        public final void e(boolean z, String str) {
                            AppMethodBeat.i(126253);
                            if (z) {
                                com.tencent.mm.plugin.topstory.a.i.a(e.this.GlS.fyD(), e.this.GjH, 2);
                                com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                                gVar.appId = e.this.GjH.NiI.NhN.appId;
                                gVar.kHw = e.this.GjH.NiI.NhN.ecK;
                                gVar.scene = 1152;
                                ((r) g.af(r.class)).a(e.this.getContext(), gVar);
                                e.this.Gov.setVisibility(8);
                            }
                            AppMethodBeat.o(126253);
                        }
                    }).show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126254);
                }
            });
            this.Goz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(126255);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    e.this.Gov.setVisibility(8);
                    com.tencent.mm.plugin.topstory.a.i.a(e.this.GlS.fyD(), e.this.GjH, 3);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126255);
                }
            });
        }
        bIY();
        if (getFSVideoUIComponent().fyL()) {
            this.Gon = new l(getContext());
        } else {
            this.Gon = new f(getContext());
            if (ao.aQ(getContext())) {
                f fVar = this.Gon;
                fVar.GoI.setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 24), 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 24), 0);
            }
        }
        this.Gon.setOnlyFS(fzJ());
        this.Gon.setVisibility(8);
        this.Gon.setShareBtnClickListener(this.Gor);
        this.Gon.setWowBtnClickListener(this.Gos);
        this.Gon.setTagBtnClickListener(this.Got);
        this.Gon.setSourceItemClickListener(this.Gou);
        if (com.tencent.mm.plugin.topstory.a.h.fxR()) {
            this.Gon.setTitleClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(126263);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    e.this.getFSVideoUIComponent().fyF().Gob = true;
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126263);
                }
            });
        }
        this.Gon.setOnUpdateProgressLenListener(new f.a() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.topstory.ui.video.fs.f.a
            public final void b(eiw eiw, int i2, int i3) {
                int i4;
                AppMethodBeat.i(126264);
                if (i3 > 0) {
                    i4 = (e.this.Gmj.getWidth() * i2) / i3;
                } else {
                    i4 = 0;
                }
                com.tencent.mm.plugin.topstory.a.b.b bVar = e.this.getFSVideoUIComponent().fyB().GnT;
                if (bVar != null && bVar.Gjp < ((long) e.this.getFSVideoUIComponent().fyF().getCurrPosMs())) {
                    bVar.Gjp = (long) e.this.getFSVideoUIComponent().fyF().getCurrPosMs();
                }
                if (e.this.GlS.fyF().dFG()) {
                    int currPosMs = e.this.GlS.fyF().getCurrPosMs() / 1000;
                    if (((PluginTopStoryUI) g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(eiw.psI)) {
                        ((PluginTopStoryUI) g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(eiw.psI, Integer.valueOf(currPosMs));
                    }
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) e.this.Gmi.getLayoutParams();
                layoutParams.width = i4;
                e.this.Gmi.setLayoutParams(layoutParams);
                e.this.Gmi.requestLayout();
                if (!e.this.Gon.bJw()) {
                    e.this.Gon.setVisibility(8);
                }
                if ((eiw.Nix & 256) <= 0) {
                    e.this.GlS.a(eiw, i2, i3);
                }
                e.this.GlS.a(eiw, e.this, i2);
                AppMethodBeat.o(126264);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.video.fs.f.a
            public final void fzK() {
                AppMethodBeat.i(126265);
                e.this.Gmh.setVisibility(8);
                AppMethodBeat.o(126265);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.video.fs.f.a
            public final void fzL() {
                AppMethodBeat.i(126266);
                if (!e.this.getFSVideoUIComponent().fyF().GnZ || (!e.this.getFSVideoUIComponent().fyF().dFG() && !e.this.getFSVideoUIComponent().fyF().Goa)) {
                    e.this.Gmh.setVisibility(8);
                    AppMethodBeat.o(126266);
                    return;
                }
                e.this.Gmh.setVisibility(0);
                AppMethodBeat.o(126266);
            }
        });
        this.Gon.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
                AppMethodBeat.i(126267);
                Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
                e.this.Gon.crH();
                AppMethodBeat.o(126267);
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(126268);
                Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", Integer.valueOf(i2));
                e.this.seekTo(i2);
                e.this.Gon.bJB();
                com.tencent.mm.plugin.websearch.api.a.a.pl(22);
                AppMethodBeat.o(126268);
            }
        });
        this.Gon.setOnPlayButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.e.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(126269);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!e.this.getFSVideoUIComponent().fyF().GnZ) {
                    Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
                } else if ((e.this.Gon instanceof l) || e.this.Gon.getVideoTotalTime() - e.this.Gon.getmPosition() >= 2) {
                    e.this.getFSVideoUIComponent().fyB().k(e.this.GjH);
                    if (e.this.getFSVideoUIComponent().fyF().dFG()) {
                        e.this.getFSVideoUIComponent().fyF().cXa();
                        e.this.Gon.crH();
                    } else {
                        e.this.getFSVideoUIComponent().fyF().eYd();
                        e.this.Gon.bJB();
                    }
                    e.this.fyX();
                } else {
                    Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126269);
                    return;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126269);
            }
        });
        AppMethodBeat.o(126287);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fyX() {
        AppMethodBeat.i(126288);
        super.fyX();
        AppMethodBeat.o(126288);
    }

    /* access modifiers changed from: protected */
    public void fzI() {
        AppMethodBeat.i(126289);
        this.Gon.m(this.GjH);
        AppMethodBeat.o(126289);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fyV() {
        AppMethodBeat.i(126290);
        Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
        this.Gmd.setVisibility(8);
        this.Gmc.setVisibility(8);
        this.puw.setVisibility(0);
        this.GlU.setVisibility(8);
        this.GlT.setVisibility(8);
        this.Gmh.setVisibility(8);
        AppMethodBeat.o(126290);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fyW() {
        AppMethodBeat.i(126291);
        Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
        this.Gmd.setVisibility(0);
        if (!getFSVideoUIComponent().fyA().fzw() || ai.isFreeSimCard()) {
            this.Gmc.setVisibility(8);
        } else {
            this.Gmc.setVisibility(0);
        }
        this.puw.setVisibility(0);
        this.GlU.setVisibility(8);
        this.GlT.setVisibility(8);
        this.Gmh.setVisibility(8);
        this.Gmf.setVisibility(0);
        this.Gme.setVisibility(8);
        this.GlX.setVisibility(0);
        this.GlY.setVisibility(8);
        this.Gmb.setVisibility(8);
        AppMethodBeat.o(126291);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fzb() {
        AppMethodBeat.i(126292);
        f fVar = this.Gon;
        if (fVar.GoU != null) {
            fVar.GoU.stopTimer();
        }
        AppMethodBeat.o(126292);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public void updateView() {
        AppMethodBeat.i(126293);
        super.updateView();
        if (this.Gon != null) {
            this.Gon.setVideoTotalTime(this.GjH.Eso);
            this.Gon.n(this.GjH);
        }
        if (!(getFSItemUIComponent() == null || getFSItemUIComponent().fyz() == getFSVideoUIComponent().fyH())) {
            if (getFSVideoUIComponent().fyA().isConnected()) {
                fyY();
            } else {
                lg(getNoNetTip(), getContext().getString(R.string.hxp));
            }
        }
        if (this.titleTv != null) {
            this.titleTv.setText(this.GjH.title);
            ao.a(this.titleTv.getPaint(), 0.8f);
        }
        AppMethodBeat.o(126293);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public i.e c(eiw eiw) {
        return i.e.CONTAIN;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fza() {
        AppMethodBeat.i(126294);
        if (this.Gon != null) {
            this.Gon.setVisibility(8);
        }
        AppMethodBeat.o(126294);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void crC() {
        AppMethodBeat.i(126295);
        if (this.Gon != null) {
            this.Gon.show();
        }
        AppMethodBeat.o(126295);
    }

    /* access modifiers changed from: protected */
    public void bIY() {
        AppMethodBeat.i(126296);
        this.Goo = new k(getContext(), this, new a());
        AppMethodBeat.o(126296);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public i.b getVideoViewCallback() {
        return this.wcv;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(126297);
        if (this.Goo != null) {
            this.Goo.A(motionEvent);
        }
        AppMethodBeat.o(126297);
        return true;
    }

    private boolean bJf() {
        AppMethodBeat.i(126298);
        if (this.Gmd.getVisibility() == 0) {
            AppMethodBeat.o(126298);
            return true;
        }
        AppMethodBeat.o(126298);
        return false;
    }

    public class a implements c {
        private float GoD;

        a() {
            AppMethodBeat.i(126278);
            this.GoD = (float) com.tencent.mm.cb.a.jo(e.this.getContext());
            AppMethodBeat.o(126278);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final void bJj() {
            AppMethodBeat.i(126279);
            Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
            if (e.X(e.this)) {
                if (e.this.Gon.bJw()) {
                    e.this.Gon.setVisibility(8);
                    AppMethodBeat.o(126279);
                    return;
                }
                e.this.Gon.show();
                if (e.this.getFSItemUIComponent() != null) {
                    e.this.getFSItemUIComponent().fyy();
                    e.this.getFSItemUIComponent().fyx();
                }
            }
            AppMethodBeat.o(126279);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final void bJk() {
            AppMethodBeat.i(126280);
            Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
            AppMethodBeat.o(126280);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public void bJl() {
            AppMethodBeat.i(126281);
            e.this.GlU.setVisibility(0);
            e.this.Gon.fzM();
            AppMethodBeat.o(126281);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public int ce(float f2) {
            AppMethodBeat.i(126282);
            int videoDurationSec = e.this.getFSVideoUIComponent().fyF().getVideoDurationSec();
            int currentPosition = ((int) ((f2 / this.GoD) * ((float) videoDurationSec))) + getCurrentPosition();
            if (currentPosition < 0) {
                currentPosition = 0;
            } else if (currentPosition > videoDurationSec) {
                currentPosition = videoDurationSec;
            }
            e.this.GlU.setText(com.tencent.mm.plugin.websearch.ui.a.AF(((long) currentPosition) * 1000) + FilePathGenerator.ANDROID_DIR_SEP + com.tencent.mm.plugin.websearch.ui.a.AF(((long) videoDurationSec) * 1000));
            AppMethodBeat.o(126282);
            return currentPosition;
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public void abX(int i2) {
            AppMethodBeat.i(126283);
            e.this.Gon.fzN();
            e.this.GlU.setVisibility(8);
            e.this.seekTo(i2);
            AppMethodBeat.o(126283);
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final boolean fyT() {
            AppMethodBeat.i(126284);
            if (e.ab(e.this)) {
                AppMethodBeat.o(126284);
                return false;
            }
            AppMethodBeat.o(126284);
            return true;
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.c
        public final int getCurrentPosition() {
            AppMethodBeat.i(126285);
            int currPosSec = e.this.getFSVideoUIComponent().fyF().getCurrPosSec();
            AppMethodBeat.o(126285);
            return currPosSec;
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public f getControlBar() {
        return this.Gon;
    }

    public eiw getVideoInfo() {
        return this.GjH;
    }

    public com.tencent.mm.plugin.topstory.ui.video.b getFSVideoUIComponent() {
        return this.GlS;
    }

    public a getFSItemUIComponent() {
        return (a) this.Gmk;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fzf() {
        AppMethodBeat.i(126299);
        super.fzf();
        if (fzJ()) {
            AppMethodBeat.o(126299);
        } else if (this.GjH.NiI == null || this.GjH.NiI.NhN == null) {
            this.Gov.setVisibility(8);
            AppMethodBeat.o(126299);
        } else {
            this.Gow.setText(this.GjH.NiI.NhN.title);
            this.Gox.setText(this.GjH.NiI.NhN.desc);
            q.bcV().a(this.GjH.NiI.NhN.uNR, this.Goy, Glu);
            this.Gov.setVisibility(0);
            com.tencent.mm.plugin.topstory.a.i.a(this.GlS.fyD(), this.GjH, 1);
            AppMethodBeat.o(126299);
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final void fzg() {
        AppMethodBeat.i(126300);
        super.fzg();
        if (fzJ()) {
            AppMethodBeat.o(126300);
            return;
        }
        this.Gov.setVisibility(8);
        AppMethodBeat.o(126300);
    }

    public boolean fzJ() {
        return false;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f
    public final boolean fzh() {
        AppMethodBeat.i(161624);
        if (this.Gov == null) {
            AppMethodBeat.o(161624);
            return false;
        } else if (this.Gov.getVisibility() == 0) {
            AppMethodBeat.o(161624);
            return true;
        } else {
            AppMethodBeat.o(161624);
            return false;
        }
    }

    static /* synthetic */ boolean X(e eVar) {
        AppMethodBeat.i(236395);
        if (!eVar.bJf()) {
            AppMethodBeat.o(236395);
            return true;
        }
        AppMethodBeat.o(236395);
        return false;
    }
}
