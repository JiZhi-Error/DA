package com.tencent.mm.plugin.luckymoney.story;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.an.e;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class EnvelopeStoryVideoManager implements LifecycleObserver {
    private static Set<String> zaF = new HashSet();
    c UXL;
    boolean dtC = false;
    boolean guh = false;
    com.tencent.mm.compatible.util.b jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    MMActivity pRg;
    int zaD = -1;
    Map<Integer, c> zaE = new HashMap();

    static /* synthetic */ void a(EnvelopeStoryVideoManager envelopeStoryVideoManager, c cVar) {
        AppMethodBeat.i(182471);
        envelopeStoryVideoManager.b(cVar);
        AppMethodBeat.o(182471);
    }

    static /* synthetic */ void e(c cVar) {
        AppMethodBeat.i(174372);
        a(cVar);
        AppMethodBeat.o(174372);
    }

    static {
        AppMethodBeat.i(163670);
        AppMethodBeat.o(163670);
    }

    public EnvelopeStoryVideoManager() {
        AppMethodBeat.i(163655);
        AppMethodBeat.o(163655);
    }

    private void a(Context context, FrameLayout frameLayout, ImageView imageView, ProgressBar progressBar, String str, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(258610);
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "preapre video view: %s", Boolean.valueOf(z));
        final c cVar = this.zaE.get(Integer.valueOf(i4));
        if (cVar == null || cVar.zaV == null) {
            final c cVar2 = new c();
            cVar2.zaV = new EnvelopeStoryVideoView(context);
            cVar2.url = str;
            cVar2.sessionId = UUID.randomUUID().toString();
            cVar2.rIY = imageView;
            cVar2.zaY = progressBar;
            cVar2.UXM = z;
            cVar2.zaW = (ViewGroup) frameLayout.findViewById(R.id.f5f);
            cVar2.mCP = (ImageView) frameLayout.findViewById(R.id.f5g);
            cVar2.mDh = (ImageView) frameLayout.findViewById(R.id.ezy);
            cVar2.zaX = (ViewGroup) frameLayout.findViewById(R.id.ezw);
            cVar2.zaV.setIsShowBasicControls(false);
            this.UXL = cVar2;
            cVar2.zaV.zbb = new EnvelopeStoryVideoView.a() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoView.a
                public final void a(EnvelopeStoryVideoView envelopeStoryVideoView) {
                    AppMethodBeat.i(182457);
                    int addAndGet = cVar2.zaU.addAndGet(1);
                    cVar2.pLQ = (long) envelopeStoryVideoView.getVideoDurationSec();
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "sessionId: %s, current loop count: %s", cVar2.sessionId, Integer.valueOf(addAndGet));
                    AppMethodBeat.o(182457);
                }
            };
            cVar2.zaV.setIMMVideoViewCallback(new i.b() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass6 */

                @Override // com.tencent.mm.pluginsdk.ui.i.b
                public final void c(String str, String str2, String str3, int i2, int i3) {
                    AppMethodBeat.i(182459);
                    Log.e("MicroMsg.EnvelopeStoryVideoManager", "onError: %s, %s, %s", str, str2, str3);
                    h.INSTANCE.a(19228, cVar2.url, Integer.valueOf(cVar2.zaV.getVideoDurationSec()), 2, Integer.valueOf(cVar2.zaR), Integer.valueOf(cVar2.zaV.getRealPlayDurationSec()), Integer.valueOf(cVar2.xhl), 0, Integer.valueOf(i2));
                    AppMethodBeat.o(182459);
                }

                @Override // com.tencent.mm.pluginsdk.ui.i.b
                public final void dH(String str, String str2) {
                    AppMethodBeat.i(182460);
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "on prepared: %s, %s", str, str2);
                    cVar2.pLQ = (long) cVar2.zaV.getVideoDurationSec();
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(182458);
                            if (cVar2.zaY != null) {
                                cVar2.zaY.setVisibility(8);
                            }
                            if (cVar2.zaV.getParent() != null) {
                                ((ViewGroup) cVar2.zaV.getParent()).bringToFront();
                            }
                            cVar2.mDh.setVisibility(0);
                            AppMethodBeat.o(182458);
                        }
                    }, 10);
                    AppMethodBeat.o(182460);
                }

                @Override // com.tencent.mm.pluginsdk.ui.i.b
                public final void dI(String str, String str2) {
                    AppMethodBeat.i(182461);
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "on video end: %s, %s", str, str2);
                    AppMethodBeat.o(182461);
                }

                @Override // com.tencent.mm.pluginsdk.ui.i.b
                public final void d(String str, String str2, int i2, int i3) {
                }

                @Override // com.tencent.mm.pluginsdk.ui.i.b
                public final void dJ(String str, String str2) {
                    AppMethodBeat.i(182462);
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPause: %s, %s", str, str2);
                    AppMethodBeat.o(182462);
                }

                @Override // com.tencent.mm.pluginsdk.ui.i.b
                public final void dK(String str, String str2) {
                    AppMethodBeat.i(182463);
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPlay: %s, %s", str, str2);
                    AppMethodBeat.o(182463);
                }

                @Override // com.tencent.mm.pluginsdk.ui.i.b
                public final void dL(String str, String str2) {
                    AppMethodBeat.i(182464);
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaiting: %s, %s", str, str2);
                    cVar2.zaQ = ((int) SystemClock.elapsedRealtime()) / 1000;
                    if (cVar2.zaY != null) {
                        cVar2.zaY.bringToFront();
                        cVar2.zaY.setVisibility(0);
                    }
                    AppMethodBeat.o(182464);
                }

                @Override // com.tencent.mm.pluginsdk.ui.i.b
                public final void dM(String str, String str2) {
                    AppMethodBeat.i(182465);
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaitingEnd: %s, %s", str, str2);
                    if (cVar2.zaQ > 0) {
                        c cVar = cVar2;
                        cVar.xhl = (int) (((long) cVar.xhl) + ((SystemClock.elapsedRealtime() / 1000) - ((long) cVar2.zaQ)));
                        cVar2.zaQ = 0;
                    }
                    if (cVar2.zaY != null) {
                        cVar2.zaY.setVisibility(8);
                    }
                    AppMethodBeat.o(182465);
                }

                @Override // com.tencent.mm.pluginsdk.ui.i.b
                public final void fo(String str, String str2) {
                    AppMethodBeat.i(213347);
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoFirstFrameDraw: %s, %s", str, str2);
                    AppMethodBeat.o(213347);
                }
            });
            cVar2.mCP.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(174356);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "click play btn");
                    if (cVar2.zaV == null || !cVar2.zaV.isPlaying()) {
                        cVar2.mCP.setVisibility(4);
                        EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, cVar2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(174356);
                        return;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(174356);
                }
            });
            cVar2.zaV.setMute(false);
            a(cVar2);
            cVar2.zaW.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(182466);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!(EnvelopeStoryVideoManager.this.zaD == -1 || cVar2.zaV == null)) {
                        boolean z = cVar2.zaV.zaZ;
                        EnvelopeStoryVideoManager.this.guh = !z;
                        if (z) {
                            EnvelopeStoryVideoManager.this.jvG.requestFocus();
                            EnvelopeStoryVideoManager.this.dtC = true;
                            cVar2.zaV.setMute(false);
                        } else {
                            if (EnvelopeStoryVideoManager.this.dtC) {
                                EnvelopeStoryVideoManager.this.jvG.apm();
                                EnvelopeStoryVideoManager.this.dtC = false;
                            }
                            cVar2.zaV.setMute(true);
                        }
                        EnvelopeStoryVideoManager.e(cVar2);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(182466);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i3);
            layoutParams.gravity = 17;
            frameLayout.addView(cVar2.zaV, 0, layoutParams);
            cVar2.zaW.setLayoutParams(layoutParams);
            this.zaE.put(Integer.valueOf(i4), cVar2);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(174345);
                    EnvelopeStoryVideoManager.d(cVar2);
                    AppMethodBeat.o(174345);
                }
            });
            cVar2.zaV.setSessionId(cVar2.sessionId);
            cVar2.zaV.setIOnlineVideoProxy(new b(cVar2));
            cVar2.zaV.setLocalPreDownloadVideo(cVar2.UXM);
            cVar2.zaV.c(false, cVar2.url, 0);
            cVar2.jpT = cVar2.zaV.getMediaId();
            b(cVar2);
            AppMethodBeat.o(258610);
            return;
        }
        cVar.zaV.setMute(this.guh);
        a(cVar);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(174346);
                if (cVar.bfW && cVar.zaV.YY()) {
                    cVar.zaV.onUIResume();
                    cVar.zaS = (long) cVar.zaV.getCurrPosSec();
                    cVar.zaT = 0;
                } else if (cVar.zaV.isPlaying()) {
                    Log.w("MicroMsg.EnvelopeStoryVideoManager", "resume fail, restart play");
                    cVar.zaV.stop();
                    cVar.zaV.start();
                    cVar.zaS = 0;
                    cVar.zaT = 0;
                }
                cVar.zaU.set(1);
                AppMethodBeat.o(174346);
            }
        }, 200);
        AppMethodBeat.o(258610);
    }

    static void a(c cVar) {
        AppMethodBeat.i(174361);
        if (cVar.zaV.zaZ) {
            cVar.mDh.setImageResource(R.raw.lucky_money_mute_icon);
            AppMethodBeat.o(174361);
            return;
        }
        cVar.mDh.setImageResource(R.raw.lucky_money_unmute_icon);
        AppMethodBeat.o(174361);
    }

    private void b(c cVar) {
        AppMethodBeat.i(174362);
        if (!cVar.UXM && c(cVar)) {
            cVar.zaV.setLocal(true);
        }
        cVar.rIY.bringToFront();
        if (cVar.zaP > 0) {
            Log.d("MicroMsg.EnvelopeStoryVideoManager", "start play: %s", Integer.valueOf(cVar.zaP));
            cVar.zaV.c((double) cVar.zaP, true);
            cVar.zaS = (long) cVar.zaP;
            cVar.zaT = 0;
        } else {
            cVar.zaV.start();
            cVar.zaS = 0;
            cVar.zaT = 0;
        }
        cVar.zaU.set(1);
        if (!this.dtC) {
            this.jvG.requestFocus();
            this.dtC = true;
        }
        cVar.bfW = true;
        b.zbg++;
        b.zbf.add(cVar.url);
        AppMethodBeat.o(174362);
    }

    private static boolean c(c cVar) {
        AppMethodBeat.i(174363);
        boolean YS = s.YS(aDA(cVar.url));
        boolean z = MultiProcessMMKV.getMMKV(efR()).getInt(cVar.jpT, 0) == 1;
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "can play local: %s, %s", Boolean.valueOf(YS), Boolean.valueOf(z));
        if (!YS || !z) {
            if (YS) {
                cVar.zaR = 3;
            } else {
                cVar.zaR = 2;
            }
            MultiProcessMMKV.getMMKV(efR()).putInt(cVar.jpT, 0);
            AppMethodBeat.o(174363);
            return false;
        }
        cVar.zaR = 1;
        AppMethodBeat.o(174363);
        return true;
    }

    public final void a(Context context, FrameLayout frameLayout, ImageView imageView, ProgressBar progressBar, String str, int i2, int i3, int i4, boolean z, boolean z2) {
        AppMethodBeat.i(258611);
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "update position: %s, %s, %s", Integer.valueOf(this.zaD), Integer.valueOf(i4), str);
        if (i4 != this.zaD) {
            c cVar = this.zaE.get(Integer.valueOf(this.zaD));
            if (cVar != null) {
                Log.i("MicroMsg.EnvelopeStoryVideoManager", "pause previous video");
                if (cVar.bfW) {
                    cVar.zaT = (long) cVar.zaV.getCurrPosSec();
                    cVar.zaV.onUIPause();
                }
            }
            this.zaD = i4;
            if (z) {
                a(context, frameLayout, imageView, progressBar, str, i2, i3, i4, z2);
            }
            AppMethodBeat.o(258611);
            return;
        }
        Log.w("MicroMsg.EnvelopeStoryVideoManager", "skip same position");
        AppMethodBeat.o(258611);
    }

    public final void efP() {
        AppMethodBeat.i(174365);
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "release video view: %s", Integer.valueOf(this.zaE.size()));
        if (this.dtC) {
            this.jvG.apm();
            this.dtC = false;
        }
        for (Map.Entry<Integer, c> entry : this.zaE.entrySet()) {
            Log.d("MicroMsg.EnvelopeStoryVideoManager", "do stop");
            c value = entry.getValue();
            if (value.zaQ > 0) {
                value.xhl = (int) (((long) value.xhl) + ((SystemClock.elapsedRealtime() / 1000) - ((long) value.zaQ)));
            }
            h.INSTANCE.a(19228, value.url, Integer.valueOf(value.zaV.getVideoDurationSec()), 1, Integer.valueOf(value.zaR), Integer.valueOf(value.zaV.getRealPlayDurationSec()), Integer.valueOf(value.xhl), 0, 0);
            if (entry.getValue().zaV.getParent() != null) {
                ((ViewGroup) entry.getValue().zaV.getParent()).removeView(entry.getValue().zaV);
                value.zaV.stop();
            }
        }
        this.zaE.clear();
        this.zaD = -1;
        AppMethodBeat.o(174365);
    }

    private c efQ() {
        AppMethodBeat.i(174366);
        c cVar = this.zaE.get(Integer.valueOf(this.zaD));
        AppMethodBeat.o(174366);
        return cVar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onUIResume() {
        AppMethodBeat.i(163659);
        c efQ = efQ();
        if (efQ != null) {
            efQ.zaV.onUIResume();
            if (efQ.zaV.isPlaying()) {
                this.jvG.requestFocus();
                this.dtC = true;
            }
        }
        AppMethodBeat.o(163659);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onUIPause() {
        AppMethodBeat.i(163660);
        if (this.dtC) {
            this.jvG.apm();
            this.dtC = false;
        }
        c efQ = efQ();
        if (efQ != null) {
            efQ.zaV.onUIPause();
        }
        AppMethodBeat.o(163660);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onUIDestroy() {
        AppMethodBeat.i(163661);
        AppMethodBeat.o(163661);
    }

    public static void a(String str, final String str2, final String str3, String str4, boolean z, g.a aVar, h.a aVar2) {
        boolean z2;
        AppMethodBeat.i(174367);
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "trigger download video: %s, %s, %s", str, str2, str3);
        if (z) {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_close_redenv_story_video_preload_config, 1) == 0) {
                Log.i("MicroMsg.EnvelopeStoryVideoManager", "can not preload video");
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                AppMethodBeat.o(174367);
                return;
            }
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.mm.i.h hVar = new com.tencent.mm.i.h();
        hVar.taskName = "task_EnvelopeStoryVideoManager";
        hVar.field_mediaId = str;
        hVar.field_fileId = str;
        hVar.url = str3;
        hVar.gqU = z ? 2 : 1;
        hVar.field_preloadRatio = 20;
        hVar.gqQ = new g.b() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass10 */

            @Override // com.tencent.mm.i.g.b
            public final void b(String str, d dVar) {
                AppMethodBeat.i(182468);
                Log.i("MicroMsg.EnvelopeStoryVideoManager", "preload complete: %s %s", str, Integer.valueOf(dVar.field_retCode));
                EnvelopeStoryVideoManager.zaF.remove(str);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19228, str3, 0, 4, 0, 0, 0, Long.valueOf((SystemClock.elapsedRealtime() - elapsedRealtime) / 1000), 0);
                AppMethodBeat.o(182468);
            }
        };
        if (aVar != null) {
            hVar.gqy = aVar;
        } else {
            hVar.gqy = new g.a() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass2 */

                @Override // com.tencent.mm.i.g.a
                public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                    AppMethodBeat.i(182456);
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "task callback: %s", Integer.valueOf(i2));
                    if (i2 != 0) {
                        s.deleteFile(str2);
                    }
                    AppMethodBeat.o(182456);
                    return 0;
                }

                @Override // com.tencent.mm.i.g.a
                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                @Override // com.tencent.mm.i.g.a
                public final byte[] f(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
        }
        hVar.gqP = 3;
        hVar.field_fullpath = str2;
        hVar.field_filemd5 = str4;
        hVar.allow_mobile_net_download = true;
        hVar.gre = aVar2;
        hVar.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        hVar.field_requestVideoFormat = 1;
        hVar.gqO = hVar.gqU;
        if (!z) {
            if (zaF.contains(str)) {
                Log.i("MicroMsg.EnvelopeStoryVideoManager", "need cancel preload task");
                f.baQ().Oc(str);
            }
            o.bhk().e(hVar);
            AppMethodBeat.o(174367);
        } else if (zaF.contains(str)) {
            Log.w("MicroMsg.EnvelopeStoryVideoManager", "contains preload task: %s", str);
            AppMethodBeat.o(174367);
        } else {
            zaF.add(str);
            f.baQ().b(hVar, -1);
            AppMethodBeat.o(174367);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements com.tencent.mm.modelvideo.b {
        c zaL;

        public b(c cVar) {
            this.zaL = cVar;
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void p(String str, final String str2, final String str3) {
            AppMethodBeat.i(163651);
            EnvelopeStoryVideoManager.a(str, str2, str3, this.zaL.md5, false, new g.a() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.b.AnonymousClass1 */

                @Override // com.tencent.mm.i.g.a
                public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                    AppMethodBeat.i(163650);
                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "cdn callback: %s, %s", str, Integer.valueOf(i2));
                    if (i2 != 0) {
                        s.deleteFile(str2);
                        if (b.this.zaL.jpT.equals(str)) {
                            Log.w("MicroMsg.EnvelopeStoryVideoManager", "download video fail: %s", str3);
                            b.this.zaL.zaX.setVisibility(0);
                            b.this.zaL.zaX.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.b.AnonymousClass1.AnonymousClass1 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(163649);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.EnvelopeStoryVideoManager", "click retry btn");
                                    b.this.zaL.sessionId = UUID.randomUUID().toString();
                                    b.this.zaL.zaV.setSessionId(b.this.zaL.sessionId);
                                    b.this.zaL.zaV.setLocal(false);
                                    EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, b.this.zaL);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(163649);
                                }
                            });
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19228, b.this.zaL.url, Integer.valueOf(b.this.zaL.zaV.getVideoDurationSec()), 2, Integer.valueOf(b.this.zaL.zaR), Integer.valueOf(b.this.zaL.zaV.getRealPlayDurationSec()), Integer.valueOf(b.this.zaL.xhl), 0, -9999);
                        }
                    }
                    AppMethodBeat.o(163650);
                    return 0;
                }

                @Override // com.tencent.mm.i.g.a
                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                @Override // com.tencent.mm.i.g.a
                public final byte[] f(String str, byte[] bArr) {
                    return new byte[0];
                }
            }, new a(this.zaL));
            AppMethodBeat.o(163651);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void he(String str) {
            AppMethodBeat.i(163652);
            o.bhk().l(str, null);
            AppMethodBeat.o(163652);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void requestVideoData(String str, int i2, int i3) {
            AppMethodBeat.i(163653);
            Log.d("MicroMsg.EnvelopeStoryVideoManager", "request video data: %s", str);
            o.bhk();
            e.r(str, i2, i3);
            AppMethodBeat.o(163653);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final boolean isVideoDataAvailable(String str, int i2, int i3) {
            AppMethodBeat.i(163654);
            boolean isVideoDataAvailable = o.bhk().isVideoDataAvailable(str, i2, i3);
            AppMethodBeat.o(163654);
            return isVideoDataAvailable;
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void a(b.a aVar) {
        }
    }

    public class a implements h.a {
        c zaL;

        public a(c cVar) {
            this.zaL = cVar;
        }

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(final String str, final long j2, final long j3, final String str2) {
            AppMethodBeat.i(213348);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(163644);
                    a.this.zaL.zaV.AI(j2);
                    AppMethodBeat.o(163644);
                }
            });
            AppMethodBeat.o(213348);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(String str, long j2, long j3) {
            AppMethodBeat.i(163646);
            this.zaL.zaV.onDataAvailable(str, j2, j3);
            AppMethodBeat.o(163646);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(String str, long j2, long j3) {
            AppMethodBeat.i(163647);
            this.zaL.zaV.i(str, j2, j3);
            AppMethodBeat.o(163647);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, int i2, d dVar) {
            AppMethodBeat.i(163648);
            if (dVar != null && dVar.field_retCode == 0) {
                Log.i("MicroMsg.EnvelopeStoryVideoManager", "download finish: %s", str);
                EnvelopeStoryVideoManager.VQ().putInt(str, 1).commit();
            }
            this.zaL.zaV.ax(str, i2);
            AppMethodBeat.o(163648);
        }
    }

    public static String aDz(String str) {
        AppMethodBeat.i(163663);
        String str2 = "MMVideo_" + str.hashCode();
        AppMethodBeat.o(163663);
        return str2;
    }

    public static String aDA(String str) {
        AppMethodBeat.i(163664);
        String str2 = EnvelopeStoryVideoView.ROOT_PATH + "MMVideo_" + str.hashCode() + ".mp4";
        AppMethodBeat.o(163664);
        return str2;
    }

    public static MultiProcessMMKV VQ() {
        AppMethodBeat.i(258612);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(efR());
        AppMethodBeat.o(258612);
        return mmkv;
    }

    private static String efR() {
        AppMethodBeat.i(163666);
        String str = MMApplicationContext.getPackageName() + "_luckymoney_story_video";
        AppMethodBeat.o(163666);
        return str;
    }

    public static boolean dD(int i2, String str) {
        AppMethodBeat.i(258613);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_lucky_money_envelope_load_local_video_res_config, true);
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "[static luckymoney resource switch] canGetLuckyMoneyEnvelopeLocalVideoRes ：%s", Boolean.valueOf(a2));
        boolean z = i2 > 0 && !Util.isNullOrNil(str) && s.YS(str) && a2;
        if (z) {
            Log.i("MicroMsg.EnvelopeStoryVideoManager", "[static luckymoney resource] use local：LuckyMoneyEnvelopeLocalVideoRes：%s", Integer.valueOf(i2));
        } else {
            Log.i("MicroMsg.EnvelopeStoryVideoManager", "[static luckymoney resource] use net: LuckyMoneyEnvelopeLocalVideoRes:%s", Integer.valueOf(i2));
        }
        AppMethodBeat.o(258613);
        return z;
    }

    public static class c {
        boolean UXM;
        boolean bfW = false;
        boolean guh = true;
        String jpT;
        ImageView mCP;
        ImageView mDh;
        String md5;
        long pLQ;
        ImageView rIY;
        String sessionId;
        String url;
        int xhl = 0;
        int zaP;
        int zaQ = 0;
        int zaR;
        long zaS;
        long zaT;
        AtomicInteger zaU = new AtomicInteger(1);
        EnvelopeStoryVideoView zaV;
        ViewGroup zaW;
        ViewGroup zaX;
        ProgressBar zaY;

        public c() {
            AppMethodBeat.i(182469);
            AppMethodBeat.o(182469);
        }
    }

    static /* synthetic */ void a(EnvelopeStoryVideoManager envelopeStoryVideoManager) {
        AppMethodBeat.i(174369);
        if (envelopeStoryVideoManager.pRg != null) {
            envelopeStoryVideoManager.pRg.getSupportActionBar().getCustomView().setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.AnonymousClass9 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(182467);
                    c cVar = (c) EnvelopeStoryVideoManager.this.zaE.get(Integer.valueOf(EnvelopeStoryVideoManager.this.zaD));
                    if (motionEvent.getActionMasked() != 0 || cVar == null) {
                        AppMethodBeat.o(182467);
                        return false;
                    }
                    Rect rect = new Rect();
                    cVar.zaV.getGlobalVisibleRect(rect);
                    if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        Log.i("MicroMsg.EnvelopeStoryVideoManager", "the videoview are under actionbar ");
                        cVar.zaW.callOnClick();
                    }
                    AppMethodBeat.o(182467);
                    return true;
                }
            });
        }
        AppMethodBeat.o(174369);
    }

    static /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(174370);
        if (cVar.zaW.getTop() < 0 || cVar.zaW.getTop() > ao.getStatusBarHeight(MMApplicationContext.getContext())) {
            ((RelativeLayout.LayoutParams) cVar.mDh.getLayoutParams()).topMargin = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.bt);
            AppMethodBeat.o(174370);
            return;
        }
        ((RelativeLayout.LayoutParams) cVar.mDh.getLayoutParams()).topMargin = (ao.getStatusBarHeight(MMApplicationContext.getContext()) - cVar.zaW.getTop()) + com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
        AppMethodBeat.o(174370);
    }
}
