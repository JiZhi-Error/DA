package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.e;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.api.x;
import com.tencent.mm.api.z;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.media.i.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.a.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c;
import com.tencent.mm.plugin.mmsight.segment.m;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.s;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;

public final class b {
    private static int gsi;
    private static final Object zCp = new Object();
    private MMActivity gte;
    private q gut;
    String md5;
    public int scene;
    public String videoOutputPath = null;
    private String videoPath;
    private RecyclerThumbSeekBar zCe;
    private boolean zCf = false;
    private int zCg = -1;
    public int zCh = -1;
    public int zCi = -1;
    private MTimerHandler zCj;
    private ViewGroup zCk;
    private ab zCl;
    private e zCm;
    private com.tencent.mm.plugin.mmsight.api.a zCn;
    private d zCo;
    public a zCq;
    private boolean zCr = false;
    public boolean zCs = false;
    private boolean zCt = false;
    private boolean zCu = false;
    public int zCv = -1;
    private a.b zCw;
    public boolean zCx = false;
    public boolean zCy = true;
    private VideoTransPara zua;
    private VideoPlayerTextureView zyd;
    private VideoSeekBarEditorView zye;

    public interface a {
        void eks();

        void ekt();

        void onError();
    }

    static /* synthetic */ void p(b bVar) {
        AppMethodBeat.i(94623);
        bVar.ekP();
        AppMethodBeat.o(94623);
    }

    static /* synthetic */ void r(b bVar) {
        AppMethodBeat.i(94624);
        bVar.ekQ();
        AppMethodBeat.o(94624);
    }

    static {
        AppMethodBeat.i(94627);
        AppMethodBeat.o(94627);
    }

    public final void a(MMActivity mMActivity, int i2, String str, VideoSeekBarEditorView videoSeekBarEditorView, VideoPlayerTextureView videoPlayerTextureView, ViewGroup viewGroup, VideoTransPara videoTransPara, boolean z) {
        AppMethodBeat.i(94613);
        this.zua = videoTransPara;
        if (this.zua == null) {
            Log.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
            this.zua = new VideoTransPara();
            this.zua.duration = 10000;
        } else if (this.zua.duration <= 0) {
            this.zua.duration = 10000;
        }
        this.scene = i2;
        this.videoPath = str;
        this.zye = videoSeekBarEditorView;
        this.zyd = videoPlayerTextureView;
        this.zCk = viewGroup;
        this.gte = mMActivity;
        this.zCt = z;
        this.zCw = new a.b(i2);
        this.zCe = videoSeekBarEditorView.zDX;
        this.zCe.setVideoTransPara(this.zua);
        ekO();
        AppMethodBeat.o(94613);
    }

    private void ekO() {
        AppMethodBeat.i(94614);
        this.zCl = ab.diQ.Uo();
        ab abVar = this.zCl;
        ab.a.C0260a aVar = new ab.a.C0260a();
        aVar.diS = false;
        aVar.diW = true;
        aVar.diR = ab.c.diY;
        aVar.diX = new Rect(this.zyd.getLeft(), this.zyd.getTop(), this.zyd.getRight(), this.zyd.getBottom());
        abVar.a(aVar.VJ());
        this.zCm = this.zCl.bB(this.zCk.getContext());
        this.zCm.setActionBarCallback(new j() {
            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass1 */

            @Override // com.tencent.mm.api.j
            public final void onFinish() {
                AppMethodBeat.i(94585);
                Log.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
                b.this.zCl.a(new u() {
                    /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.api.u
                    public final void onError(Exception exc) {
                        AppMethodBeat.i(94582);
                        Log.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", exc);
                        AppMethodBeat.o(94582);
                    }

                    @Override // com.tencent.mm.api.u
                    public final void a(final Bitmap bitmap, boolean z) {
                        AppMethodBeat.i(94583);
                        Log.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", bitmap, Boolean.valueOf(z));
                        if (z) {
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            if (b.this.zCq == null || b.this.zCs) {
                                if (b.this.zCs) {
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass1.AnonymousClass1.AnonymousClass3 */

                                        public final void run() {
                                            AppMethodBeat.i(94580);
                                            b.this.gut = h.a((Context) b.this.gte, b.this.gte.getString(R.string.f13), false, (DialogInterface.OnCancelListener) null);
                                            b.this.zyd.pause();
                                            b.a(b.this, (Bitmap) null);
                                            AppMethodBeat.o(94580);
                                        }
                                    });
                                    AppMethodBeat.o(94583);
                                    return;
                                }
                            } else if (b.this.zCi <= 0 || b.this.zCg <= 0 || b.this.zCi > b.this.zCg) {
                                b.this.md5 = s.bhK(b.this.videoPath);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                    public final void run() {
                                        AppMethodBeat.i(94579);
                                        b.this.zCq.eks();
                                        AppMethodBeat.o(94579);
                                    }
                                });
                                AppMethodBeat.o(94583);
                                return;
                            } else {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(94578);
                                        b.this.gut = h.a((Context) b.this.gte, b.this.gte.getString(R.string.f13), false, (DialogInterface.OnCancelListener) null);
                                        b.this.zyd.pause();
                                        b.a(b.this, (Bitmap) null);
                                        AppMethodBeat.o(94578);
                                    }
                                });
                                AppMethodBeat.o(94583);
                                return;
                            }
                        } else if (bitmap != null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass1.AnonymousClass1.AnonymousClass4 */

                                public final void run() {
                                    AppMethodBeat.i(94581);
                                    b.this.gut = h.a((Context) b.this.gte, b.this.gte.getString(R.string.f13), false, (DialogInterface.OnCancelListener) null);
                                    b.this.zyd.pause();
                                    b.a(b.this, bitmap);
                                    AppMethodBeat.o(94581);
                                }
                            });
                        }
                        AppMethodBeat.o(94583);
                    }
                });
                AppMethodBeat.o(94585);
            }

            @Override // com.tencent.mm.api.j
            public final void onExit() {
                AppMethodBeat.i(94586);
                Log.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
                b.this.release();
                if (b.this.zCq != null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(94584);
                            b.this.zCq.ekt();
                            AppMethodBeat.o(94584);
                        }
                    });
                }
                AppMethodBeat.o(94586);
            }
        });
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        if (au.aA(this.gte)) {
            marginLayoutParams.height = com.tencent.mm.plugin.mmsight.d.ejr().y - Math.max(au.aD(this.gte), au.aB(this.gte));
        }
        this.zCk.addView(this.zCm, marginLayoutParams);
        this.zCm.setSelectedFeatureListener(new z() {
            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass6 */

            @Override // com.tencent.mm.api.z
            public final void a(com.tencent.mm.api.h hVar) {
                AppMethodBeat.i(94598);
                Log.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", hVar.name());
                if (hVar == com.tencent.mm.api.h.CROP_VIDEO) {
                    b.i(b.this);
                }
                AppMethodBeat.o(94598);
            }

            @Override // com.tencent.mm.api.z
            public final void a(com.tencent.mm.api.h hVar, int i2, Object obj) {
                AppMethodBeat.i(169419);
                Log.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", hVar.name(), Integer.valueOf(i2));
                AppMethodBeat.o(169419);
            }

            @Override // com.tencent.mm.api.z
            public final void cH(boolean z) {
                AppMethodBeat.i(94600);
                if (z) {
                    b.this.gte.showVKB();
                    AppMethodBeat.o(94600);
                    return;
                }
                b.this.gte.hideVKB(b.this.zCk);
                AppMethodBeat.o(94600);
            }
        });
        this.zye.setCancelButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(94603);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!b.this.zCr && b.this.zCg <= b.this.zua.duration) {
                    b.this.zCh = b.this.zCi = -1;
                    b.this.zye.ele();
                    b.this.zCe = b.this.zye.zDX;
                    b.this.zCf = false;
                }
                if (b.this.zCy) {
                    b.p(b.this);
                    if (!b.this.zCr && b.this.zCx && b.this.zCq != null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass7.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(94602);
                                b.this.zCq.ekt();
                                AppMethodBeat.o(94602);
                            }
                        });
                    }
                } else if (b.this.zCq != null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(94601);
                            b.this.zCq.ekt();
                            AppMethodBeat.o(94601);
                        }
                    });
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(94603);
            }
        });
        this.zye.setFinishButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(94604);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!b.this.zCy) {
                    b.r(b.this);
                } else {
                    b.p(b.this);
                    if (b.this.zCh >= 0 && b.this.zCi > 0) {
                        b.this.zCr = true;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightVideoEditor$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(94604);
            }
        });
        if (this.zCt) {
            this.zye.setVisibility(0);
            this.zye.bringToFront();
            this.zye.post(new Runnable() {
                /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(94605);
                    b.this.zCm.setFooterVisible(false);
                    b.this.zCm.setActionBarVisible(false);
                    b.this.zCm.setActivated(false);
                    b.i(b.this);
                    AppMethodBeat.o(94605);
                }
            });
        }
        AppMethodBeat.o(94614);
    }

    private void ekP() {
        AppMethodBeat.i(94615);
        this.zyd.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.zye.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass3 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(94588);
                b.this.zye.setVisibility(8);
                b.this.zye.setAlpha(1.0f);
                AppMethodBeat.o(94588);
            }
        });
        this.zCm.setFooterVisible(true);
        this.zCm.setAutoShowFooterAndBar(true);
        this.zCm.setActionBarVisible(true);
        this.zCm.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.zCu = false;
        AppMethodBeat.o(94615);
    }

    private void ekQ() {
        AppMethodBeat.i(94616);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(94597);
                if (b.this.gut != null) {
                    b.this.gut.dismiss();
                }
                if (b.this.zCq != null) {
                    b.this.zCq.eks();
                }
                AppMethodBeat.o(94597);
            }
        });
        AppMethodBeat.o(94616);
    }

    public final void release() {
        AppMethodBeat.i(94617);
        try {
            if (this.zCj != null) {
                this.zCj.stopTimer();
                this.zCj = null;
            }
            if (this.zCe != null) {
                this.zCe.release();
            }
            if (this.zCl != null) {
                this.zCl.onDestroy();
            }
            if (this.zCk != null) {
                this.zCk.removeView(this.zCm);
            }
            if (this.zye != null) {
                this.zye.ele();
            }
            this.zCf = false;
            k.zwi.aRR();
            AppMethodBeat.o(94617);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMSightVideoEditor", e2, "release error: %s", e2.getMessage());
            AppMethodBeat.o(94617);
        }
    }

    public final void rm(boolean z) {
        AppMethodBeat.i(94618);
        y(z, "");
        AppMethodBeat.o(94618);
    }

    public final void y(boolean z, String str) {
        AppMethodBeat.i(94619);
        try {
            this.zCw.ifz = z;
            if (this.zCl == null) {
                Log.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
                AppMethodBeat.o(94619);
                return;
            }
            x Um = this.zCl.Um();
            this.zCw.zxk = Um.Vy();
            this.zCw.zxl = Um.Vx();
            this.zCw.zxn = Um.VA();
            this.zCw.gpA = Um.VB();
            this.zCw.zxo = Um.VD();
            this.zCw.textColor = Um.getTextColor();
            com.tencent.mm.plugin.mmsight.a.a.a(this.zCw, str);
            AppMethodBeat.o(94619);
        } catch (Exception e2) {
            AppMethodBeat.o(94619);
        }
    }

    public final boolean onBackPressed() {
        AppMethodBeat.i(94620);
        if (!this.zCy) {
            AppMethodBeat.o(94620);
            return false;
        } else if (this.zCu) {
            ekP();
            AppMethodBeat.o(94620);
            return true;
        } else if (this.zCl != null) {
            boolean Ul = this.zCl.Ul();
            AppMethodBeat.o(94620);
            return Ul;
        } else {
            AppMethodBeat.o(94620);
            return false;
        }
    }

    static /* synthetic */ void a(b bVar, final Bitmap bitmap) {
        AppMethodBeat.i(94621);
        if (bVar.zCy) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass4 */

                public final void run() {
                    int i2;
                    int i3;
                    int i4;
                    final String str;
                    int[] iArr;
                    int i5;
                    int i6;
                    int i7;
                    AppMethodBeat.i(94596);
                    final com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.bk.e.QW(b.this.videoPath) ? null : com.tencent.mm.plugin.sight.base.e.aNx(b.this.videoPath);
                    if (aNx != null) {
                        i2 = aNx.width;
                        i3 = aNx.height;
                        i4 = aNx.videoBitrate;
                    } else {
                        com.tencent.mm.compatible.i.d dVar = new com.tencent.mm.compatible.i.d();
                        dVar.setDataSource(b.this.videoPath);
                        i2 = Util.getInt(dVar.extractMetadata(18), -1);
                        i3 = Util.getInt(dVar.extractMetadata(19), -1);
                        i4 = Util.getInt(dVar.extractMetadata(20), -1);
                        dVar.release();
                    }
                    if (i2 <= 0 || i3 <= 0 || i4 <= 0) {
                        Log.e("MicroMsg.MMSightVideoEditor", "doRemuxVideo, retrieve video metadata error, width: %s, height: %s, bitrate: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                        AppMethodBeat.o(94596);
                        return;
                    }
                    if (i3 >= 2000 || i2 >= 2000) {
                        b.this.zCv = 1;
                        Log.i("MicroMsg.MMSightVideoEditor", "video size too large, change to mediacodec remuxer");
                    }
                    if (b.this.zCs && b.this.zua != null) {
                        if (i4 > b.this.zua.videoBitrate) {
                            i4 = b.this.zua.videoBitrate;
                        }
                        Point G = b.G(i2, i3, b.this.zua.width, b.this.zua.height);
                        if (G != null) {
                            i2 = G.x;
                            i3 = G.y;
                        }
                    }
                    String str2 = b.this.videoPath + "remuxOutput.mp4";
                    if (!Util.isNullOrNil(b.this.videoOutputPath)) {
                        str = b.this.videoOutputPath;
                    } else {
                        str = str2;
                    }
                    Log.i("MicroMsg.MMSightVideoEditor", "Previous data width, height: %d  %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    Log.i("MicroMsg.MMSightVideoEditor", "Hseasun Adaptive Bitrate Methods:%d %d  %d  %d  %d %d %d", Integer.valueOf(b.this.zua.iTg), Integer.valueOf(b.this.zua.iTi), Integer.valueOf(b.this.zua.iTj), Integer.valueOf(b.this.zua.iTk), Integer.valueOf(b.this.zua.iTl), Integer.valueOf(b.this.scene), 512);
                    int[] iArr2 = new int[34];
                    if (b.this.zua.iTg == 2 && (b.this.scene == 2 || b.this.scene == 512)) {
                        Log.i("MicroMsg.MMSightVideoEditor", "ABA: Videopath:%s Height: %d Width: %d fps: %d VideoBitrate: %d  Duration: %d StartTime: %d\n", b.this.videoPath, Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(b.this.zua.fps), Integer.valueOf(b.this.zua.videoBitrate), Integer.valueOf((b.this.zCi - b.this.zCh) / 1000), Integer.valueOf(b.this.zCh / 1000));
                        int[] a2 = AdaptiveAdjustBitrate.a(b.this.videoPath, i3, i2, b.this.zua.fps, b.this.zua.videoBitrate, ((float) (b.this.zCi - b.this.zCh)) / 1000.0f, ((float) b.this.zCh) / 1000.0f, 2, b.this.zua.iTi, b.this.zua.iTj, b.this.zua.iTk, b.this.zua.iTl, b.this.zua.iTm, b.this.zua.iTn, b.this.zua.iTo, false);
                        i5 = a2[0] * 1000;
                        int i8 = a2[1];
                        int i9 = a2[2];
                        Log.i("MicroMsg.MMSightVideoEditor", "ABA: Adaptive Bitrate Methods: [%d] [%d]  [%d]", Integer.valueOf(i5), Integer.valueOf(i8), Integer.valueOf(i9));
                        iArr = a2;
                        i6 = i9;
                        i7 = i8;
                    } else {
                        iArr = iArr2;
                        i5 = i4;
                        i6 = i3;
                        i7 = i2;
                    }
                    if (com.tencent.mm.bk.e.QW(b.this.videoPath) || b.this.zCv == 1) {
                        Log.i("MicroMsg.MMSightVideoEditor", "h265 format, try mediaCodec remuxer or is suggestRemuxerType is mediacodec");
                        final long currentTicks = Util.currentTicks();
                        AnonymousClass1 r3 = new d.b() {
                            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass4.AnonymousClass1 */

                            @Override // com.tencent.mm.media.i.d.b
                            public final void Hn(String str) {
                                AppMethodBeat.i(94591);
                                Log.i("MicroMsg.MMSightVideoEditor", "mediaCodecRemuxer remux onFinish");
                                synchronized (b.zCp) {
                                    try {
                                        b.zCp.notifyAll();
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("MicroMsg.MMSightVideoEditor", e2, "wait mediaCodecRemuxer error", new Object[0]);
                                    }
                                    try {
                                        if (Util.isNullOrNil(str)) {
                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(94589);
                                                    if (b.this.gut != null) {
                                                        b.this.gut.dismiss();
                                                    }
                                                    if (b.this.zCq != null) {
                                                        b.this.zCq.onError();
                                                    }
                                                    AppMethodBeat.o(94589);
                                                }
                                            });
                                            m.QQ(b.this.zCn.getType());
                                            return;
                                        }
                                        if (Util.isNullOrNil(b.this.videoOutputPath)) {
                                            s.nx(str, str);
                                        }
                                        long ticksToNow = Util.ticksToNow(currentTicks);
                                        Log.i("MicroMsg.MMSightVideoEditor", "doRemuxVideo used %sms", Long.valueOf(ticksToNow));
                                        m.at(1, ticksToNow);
                                        b.this.md5 = s.bhK(str);
                                        b.this.zCw.zxm = b.this.zCh >= 0 && b.this.zCi > 0;
                                        b.this.zCw.zxj = b.this.zCi - b.this.zCh;
                                        b.this.zCw.zxi = aNx == null ? 0 : aNx.videoDuration;
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass4.AnonymousClass1.AnonymousClass2 */

                                            public final void run() {
                                                AppMethodBeat.i(94590);
                                                if (b.this.gut != null) {
                                                    b.this.gut.dismiss();
                                                }
                                                if (b.this.zCq != null) {
                                                    b.this.zCq.eks();
                                                }
                                                AppMethodBeat.o(94590);
                                            }
                                        });
                                        AppMethodBeat.o(94591);
                                    } finally {
                                        AppMethodBeat.o(94591);
                                    }
                                }
                            }
                        };
                        int i10 = 0;
                        int i11 = 0;
                        if ((b.this.zua.iTh & 2) != 0) {
                            i10 = b.this.zua.idF;
                            i11 = b.this.zua.idG;
                        }
                        if (b.this.zCh < 0 || b.this.zCi <= 0) {
                            b.this.zCo = d.ihF.a(b.this.videoPath, str, i7, i6, i5, b.this.zua.fps, i10, i11, r3);
                        } else {
                            b.this.zCo = d.ihF.a(b.this.videoPath, str, i7, i6, i5, b.this.zua.fps, (long) b.this.zCh, (long) b.this.zCi, i10, i11, r3);
                        }
                        Log.i("MicroMsg.MMSightVideoEditor", "create mediaCodecVideoRemuxer: %s", b.this.zCo);
                        if (b.this.zCo == null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass4.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(94592);
                                    if (b.this.gut != null) {
                                        b.this.gut.dismiss();
                                    }
                                    if (b.this.zCq != null) {
                                        b.this.zCq.onError();
                                    }
                                    AppMethodBeat.o(94592);
                                }
                            });
                            AppMethodBeat.o(94596);
                            return;
                        }
                        if (bitmap != null) {
                            b.this.zCo.D(bitmap);
                        }
                        b.this.zCo.aMG();
                        synchronized (b.zCp) {
                            try {
                                b.zCp.wait();
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.MMSightVideoEditor", e2, "wait mediaCodecRemux error", new Object[0]);
                            }
                            try {
                            } catch (Throwable th) {
                                AppMethodBeat.o(94596);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(94596);
                        return;
                    }
                    if (b.this.zCh < 0 || b.this.zCi <= 0) {
                        if (b.this.zCv == -1 || !(b.this.zCv == 1 || b.this.zCv == 2)) {
                            b.this.zCn = com.tencent.mm.plugin.mmsight.api.a.zsW.a(b.this.videoPath, str, i7, i6, i5, b.this.zua.fps, b.this.zua.idF, b.this.zua.idG);
                        } else {
                            b.this.zCn = com.tencent.mm.plugin.mmsight.api.a.zsW.a(b.this.zCv, b.this.videoPath, str, i7, i6, i5, b.this.zua.fps, b.this.zua.idF, b.this.zua.idG);
                        }
                    } else if (b.this.zCv == -1 || !(b.this.zCv == 1 || b.this.zCv == 2)) {
                        b.this.zCn = com.tencent.mm.plugin.mmsight.api.a.zsW.a(b.this.videoPath, str, i7, i6, i5, b.this.zua.fps, (long) b.this.zCh, (long) b.this.zCi, b.this.zua.idF, b.this.zua.idG);
                    } else {
                        b.this.zCn = com.tencent.mm.plugin.mmsight.api.a.zsW.a(b.this.zCv, b.this.videoPath, str, i7, i6, i5, b.this.zua.fps, (long) b.this.zCh, (long) b.this.zCi, b.this.zua.idF, b.this.zua.idG);
                    }
                    Log.i("MicroMsg.MMSightVideoEditor", "created remuxer, type: %s, remuxer: %s", Integer.valueOf(b.this.zCv), b.this.zCn);
                    if (b.this.zCn == null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass4.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(94593);
                                if (b.this.gut != null) {
                                    b.this.gut.dismiss();
                                }
                                if (b.this.zCq != null) {
                                    b.this.zCq.onError();
                                }
                                AppMethodBeat.o(94593);
                            }
                        });
                        AppMethodBeat.o(94596);
                        return;
                    }
                    m.QP(b.this.zCn.getType());
                    long currentTicks2 = Util.currentTicks();
                    int unused = b.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, CommonUtils.MAX_TIMEOUT_MS, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.MMSightVideoEditor");
                    Log.i("MicroMsg.MMSightVideoEditor", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(b.gsi));
                    if (bitmap != null) {
                        b.this.zCn.D(bitmap);
                    }
                    int aMG = b.this.zCn.aMG();
                    if (aMG < 0) {
                        Log.e("MicroMsg.MMSightVideoEditor", "remux failed, ret: %s", Integer.valueOf(aMG));
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass4.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(94594);
                                if (b.this.gut != null) {
                                    b.this.gut.dismiss();
                                }
                                if (b.this.zCq != null) {
                                    b.this.zCq.onError();
                                }
                                AppMethodBeat.o(94594);
                            }
                        });
                        m.QQ(b.this.zCn.getType());
                        AppMethodBeat.o(94596);
                        return;
                    }
                    if (Util.isNullOrNil(b.this.videoOutputPath)) {
                        s.nx(str, b.this.videoPath);
                    }
                    if (b.gsi != 0) {
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, b.gsi);
                        Log.i("MicroMsg.MMSightVideoEditor", "hardcoder summerPerformance stopPerformace %s", Integer.valueOf(b.gsi));
                        int unused2 = b.gsi = 0;
                    }
                    if (b.this.zua.iTg == 2 && (b.this.scene == 2 || b.this.scene == 512)) {
                        SightVideoJNI.addReportMetadata(str, iArr, b.this.zua.iTg, 0);
                    } else if (b.this.zua.iTh > 0) {
                        Log.i("MicroMsg.MMSightVideoEditor", "steve: qp add report, switch:%s, scene:%s", Integer.valueOf(b.this.zua.iTh), Integer.valueOf(b.this.scene));
                        SightVideoJNI.addReportMetadata(str, iArr, 0, b.this.zua.iTh);
                    }
                    long ticksToNow = Util.ticksToNow(currentTicks2);
                    Log.i("MicroMsg.MMSightVideoEditor", "doRemuxVideo used %sms", Long.valueOf(ticksToNow));
                    m.at(b.this.zCn.getType(), ticksToNow);
                    b.this.md5 = s.bhK(b.this.videoPath);
                    b.this.zCw.zxm = b.this.zCh >= 0 && b.this.zCi > 0;
                    b.this.zCw.zxj = b.this.zCi - b.this.zCh;
                    b.this.zCw.zxi = aNx == null ? 0 : aNx.videoDuration;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass4.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(94595);
                            if (b.this.gut != null) {
                                b.this.gut.dismiss();
                            }
                            if (b.this.zCq != null) {
                                b.this.zCq.eks();
                            }
                            AppMethodBeat.o(94595);
                        }
                    });
                    AppMethodBeat.o(94596);
                }
            }, "MMSightVideoEditor_remux");
            AppMethodBeat.o(94621);
            return;
        }
        Log.i("MicroMsg.MMSightVideoEditor", "not need remux video!");
        bVar.ekQ();
        AppMethodBeat.o(94621);
    }

    static /* synthetic */ void i(b bVar) {
        AppMethodBeat.i(94622);
        int width = bVar.zyd.getWidth();
        int height = bVar.zyd.getHeight();
        int fromDPToPix = (bVar.zye.getHeight() <= 0 ? com.tencent.mm.cb.a.fromDPToPix((Context) bVar.gte, 95) : bVar.zye.getHeight()) + com.tencent.mm.cb.a.fromDPToPix((Context) bVar.gte, 20) + com.tencent.mm.cb.a.fromDPToPix((Context) bVar.gte, 12);
        if (au.aA(bVar.gte)) {
            fromDPToPix += au.aD(bVar.gte);
        }
        int i2 = height - fromDPToPix;
        if (bVar.zyd.getBottom() + fromDPToPix < com.tencent.mm.plugin.mmsight.d.gx(bVar.gte).y) {
            i2 = (int) (((float) (width - (com.tencent.mm.cb.a.fromDPToPix((Context) bVar.gte, 32) * 2))) / (((float) width) / ((float) height)));
        }
        float f2 = ((float) ((int) ((((float) width) / ((float) height)) * ((float) i2)))) / ((float) width);
        float f3 = ((float) i2) / ((float) height);
        bVar.zyd.animate().scaleX(f2).scaleY(f3).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300).setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(94587);
                if (b.this.zyd != null) {
                    b.this.zyd.requestLayout();
                }
                AppMethodBeat.o(94587);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        bVar.zCm.animate().scaleX(f2).scaleY(f3).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300);
        bVar.zCm.setAutoShowFooterAndBar(false);
        bVar.zCm.setFooterVisible(false);
        bVar.zCm.setActionBarVisible(false);
        if (!bVar.zCf) {
            bVar.zCe.setOnPreparedListener(new c.a() {
                /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass10 */

                @Override // com.tencent.mm.plugin.mmsight.segment.c.a
                public final void ri(boolean z) {
                    AppMethodBeat.i(94607);
                    if (z) {
                        Log.e("MicroMsg.MMSightVideoEditor", "Not Supported init SegmentSeekBar failed.");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass10.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(94606);
                                if (b.this.gut != null) {
                                    b.this.gut.dismiss();
                                }
                                if (b.this.zCq != null) {
                                    b.this.zCq.onError();
                                }
                                AppMethodBeat.o(94606);
                            }
                        });
                        AppMethodBeat.o(94607);
                        return;
                    }
                    if (b.this.zCe != null) {
                        b.this.zCg = b.this.zCe.getDurationMs();
                        Log.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared success %d", Integer.valueOf(b.this.zCg));
                        try {
                            if (b.this.zyd != null) {
                                b.this.zCh = Math.round(((float) b.this.zCg) * b.this.zCe.eko());
                                b.this.zCi = Math.round(((float) b.this.zCg) * b.this.zCe.ekp());
                                if (b.this.zCi <= 0) {
                                    if (b.this.zCg <= (b.this.zua.duration * 1000) + 500) {
                                        b.this.zCi = b.this.zCg;
                                    } else {
                                        b.this.zCi = b.this.zua.duration * 1000;
                                    }
                                }
                                Log.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared, start: %s, end: %s, duration: %s", Integer.valueOf(b.this.zCh), Integer.valueOf(b.this.zCi), Integer.valueOf(b.this.zCg));
                            }
                            b.x(b.this);
                            AppMethodBeat.o(94607);
                            return;
                        } catch (Exception e2) {
                        }
                    }
                    AppMethodBeat.o(94607);
                }
            });
            bVar.zCe.setThumbBarSeekListener(new c.b() {
                /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass11 */

                @Override // com.tencent.mm.plugin.mmsight.segment.c.b
                public final void W(float f2, float f3) {
                    AppMethodBeat.i(94608);
                    if (b.this.zyd == null) {
                        AppMethodBeat.o(94608);
                        return;
                    }
                    int i2 = b.this.zCg;
                    b.this.zCh = Math.round(((float) i2) * f2);
                    b.this.zCi = Math.round(((float) i2) * f3);
                    Log.i("MicroMsg.MMSightVideoEditor", "onRecyclerChanged, start: %s, end: %s %s %s", Integer.valueOf(b.this.zCh), Integer.valueOf(b.this.zCi), Float.valueOf(f2), Float.valueOf(f3));
                    b.this.zyd.d((double) b.this.zCh, true);
                    AppMethodBeat.o(94608);
                }

                @Override // com.tencent.mm.plugin.mmsight.segment.c.b
                public final void X(float f2, float f3) {
                    AppMethodBeat.i(94609);
                    if (b.this.zyd == null) {
                        AppMethodBeat.o(94609);
                        return;
                    }
                    b.this.zyd.pause();
                    AppMethodBeat.o(94609);
                }

                @Override // com.tencent.mm.plugin.mmsight.segment.c.b
                public final void Y(float f2, float f3) {
                    AppMethodBeat.i(94610);
                    if (b.this.zyd == null) {
                        AppMethodBeat.o(94610);
                        return;
                    }
                    int i2 = b.this.zCg;
                    b.this.zCh = Math.round(((float) i2) * f2);
                    b.this.zCi = Math.round(((float) i2) * f3);
                    if (b.this.zCi <= 0) {
                        b.this.zCi = 1000;
                    }
                    b.this.zyd.d((double) b.this.zCh, true);
                    Log.i("MicroMsg.MMSightVideoEditor", "onUp, start: %s, end: %s %s %s", Integer.valueOf(b.this.zCh), Integer.valueOf(b.this.zCi), Float.valueOf(f2), Float.valueOf(f3));
                    AppMethodBeat.o(94610);
                }

                @Override // com.tencent.mm.plugin.mmsight.segment.c.b
                public final void Z(float f2, float f3) {
                }
            });
            bVar.zCe.aFp(bVar.videoPath);
            bVar.zyd.setLoop(true);
            bVar.zyd.setVideoCallback(new j.a() {
                /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass12 */

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void tf() {
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onCompletion() {
                    AppMethodBeat.i(94611);
                    if (b.this.zCh > 0) {
                        b.this.zyd.d((double) b.this.zCh, true);
                        AppMethodBeat.o(94611);
                        return;
                    }
                    b.this.zyd.d(0.0d, true);
                    AppMethodBeat.o(94611);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final int fh(int i2, int i3) {
                    return 0;
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void eo(int i2, int i3) {
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onError(int i2, int i3) {
                }
            });
            bVar.zCf = true;
        }
        bVar.zye.setVisibility(0);
        bVar.zye.bringToFront();
        bVar.zCu = true;
        AppMethodBeat.o(94622);
    }

    static /* synthetic */ void x(b bVar) {
        AppMethodBeat.i(94625);
        bVar.zCj = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.mmsight.ui.b.AnonymousClass13 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(94612);
                if (b.this.zyd != null && b.this.zyd.isPlaying()) {
                    if (b.this.zCi <= 0 || b.this.zyd.getCurrentPosition() < b.this.zCi) {
                        b.this.zCe.setCurrentCursorPosition(((float) b.this.zyd.getCurrentPosition()) / ((float) b.this.zCg));
                    } else {
                        b.this.zyd.d((double) b.this.zCh, true);
                        b.this.zCe.setCurrentCursorPosition(((float) b.this.zCh) / ((float) b.this.zCg));
                    }
                }
                AppMethodBeat.o(94612);
                return true;
            }
        }, true);
        bVar.zCj.startTimer(20);
        AppMethodBeat.o(94625);
    }

    static /* synthetic */ Point G(int i2, int i3, int i4, int i5) {
        int min;
        int i6;
        AppMethodBeat.i(94626);
        Log.d("MicroMsg.MMSightVideoEditor", "scale() called with: decoderOutputWidth = [" + i2 + "], decoderOutputHeight = [" + i3 + "], specWidth = [" + i4 + "], specHeight = [" + i5 + "]");
        if (i2 > i4 || i3 > i5) {
            int max = Math.max(i2, i3);
            int min2 = Math.min(i2, i3);
            int max2 = Math.max(i4, i5);
            int min3 = Math.min(i4, i5);
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min2 % 16 == 0 && Math.abs(min2 - min3) < 16) {
                Log.i("MicroMsg.MMSightVideoEditor", "calc scale, same len divide by 16, no need scale");
                AppMethodBeat.o(94626);
                return null;
            } else if (max / 2 == max2 && min2 / 2 == min3) {
                Log.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio");
                int i7 = i2 / 2;
                int i8 = i3 / 2;
                if (i7 % 2 != 0) {
                    i7++;
                }
                if (i8 % 2 != 0) {
                    i8++;
                }
                Point point = new Point(i7, i8);
                AppMethodBeat.o(94626);
                return point;
            } else {
                int i9 = max / 2;
                int i10 = min2 / 2;
                if (i9 % 16 != 0 || Math.abs(i9 - max2) >= 16 || i10 % 16 != 0 || Math.abs(i10 - min3) >= 16) {
                    Point point2 = new Point();
                    if (i2 < i3) {
                        i6 = Math.min(i4, i5);
                        min = (int) (((double) i3) / ((((double) i2) * 1.0d) / ((double) i6)));
                    } else {
                        min = Math.min(i4, i5);
                        i6 = (int) (((double) i2) / ((((double) i3) * 1.0d) / ((double) min)));
                    }
                    if (min % 2 != 0) {
                        min++;
                    }
                    if (i6 % 2 != 0) {
                        i6++;
                    }
                    Log.i("MicroMsg.MMSightVideoEditor", "calc scale, outputsize: %s %s", Integer.valueOf(i6), Integer.valueOf(min));
                    point2.x = i6;
                    point2.y = min;
                    AppMethodBeat.o(94626);
                    return point2;
                }
                Log.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio divide by 16");
                int i11 = i2 / 2;
                int i12 = i3 / 2;
                if (i11 % 2 != 0) {
                    i11++;
                }
                if (i12 % 2 != 0) {
                    i12++;
                }
                Point point3 = new Point(i11, i12);
                AppMethodBeat.o(94626);
                return point3;
            }
        } else {
            Log.i("MicroMsg.MMSightVideoEditor", "calc scale, small or equal to spec size");
            AppMethodBeat.o(94626);
            return null;
        }
    }
}
