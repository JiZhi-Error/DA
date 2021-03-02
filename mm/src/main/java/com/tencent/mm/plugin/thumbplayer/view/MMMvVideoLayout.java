package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.c.a;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class MMMvVideoLayout extends FrameLayout {
    private d Atz;
    private final int COMPLETE;
    public com.tencent.mm.plugin.thumbplayer.e.b Gic;
    public int Gid;
    public List<com.tencent.mm.plugin.thumbplayer.d.a> Gie;
    private MMHandler Gif;
    private com.tencent.mm.plugin.thumbplayer.c.a Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
    public c Gih;
    private SurfaceTexture Gii;
    private Surface Gij;
    private long Gik = 200;
    private m<? super Long, ? super Long, x> Gil;
    private volatile boolean Gim;
    private long Gin = -1;
    public final String TAG = ("MicroMsg.TP.MMMvVideoLayout@" + hashCode());
    private g VfP;
    private volatile boolean VfR;
    private com.tencent.mm.plugin.thumbplayer.d.d VfS = new com.tencent.mm.plugin.thumbplayer.d.d();
    private long VfT = -1;
    private long kNt;
    private boolean rwI = true;
    private SurfaceTexture surfaceTexture;
    private MMThumbPlayerTextureView wdE;

    public static final class d extends q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ MMMvVideoLayout Gio;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MMMvVideoLayout mMMvVideoLayout) {
            super(1);
            this.Gio = mMMvVideoLayout;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(238757);
            long longValue = l.longValue();
            MMMvVideoLayout.b(this.Gio);
            if (this.Gio.getPauseVideoOnPlay()) {
                Log.i(this.Gio.TAG, "pauseVideoOnPlay, timestamp:".concat(String.valueOf(longValue)));
                this.Gio.pause();
                this.Gio.setPauseVideoOnPlay(false);
            }
            if (!this.Gio.getLogFrameRender()) {
                Log.i(this.Gio.TAG, "first frame render");
                this.Gio.setLogFrameRender(true);
            }
            if (this.Gio.VfT > 0) {
                Log.i(this.Gio.TAG, "first frame render cost:" + Util.ticksToNow(this.Gio.VfT));
                this.Gio.VfT = -1;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(238757);
            return xVar;
        }
    }

    public static final class i extends q implements kotlin.g.a.b<SurfaceTexture, x> {
        final /* synthetic */ MMMvVideoLayout Gio;
        final /* synthetic */ com.tencent.mm.plugin.thumbplayer.e.b Gip;
        final /* synthetic */ long iiX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(MMMvVideoLayout mMMvVideoLayout, com.tencent.mm.plugin.thumbplayer.e.b bVar, long j2) {
            super(1);
            this.Gio = mMMvVideoLayout;
            this.Gip = bVar;
            this.iiX = j2;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
            int i2;
            int i3;
            com.tencent.mm.plugin.thumbplayer.d.a aVar;
            com.tencent.mm.plugin.thumbplayer.d.a aVar2;
            int i4 = 0;
            AppMethodBeat.i(258225);
            SurfaceTexture surfaceTexture2 = surfaceTexture;
            Log.i(this.Gio.TAG, "recreatePlayerSurface create surface finished:" + (surfaceTexture2 != null ? surfaceTexture2.hashCode() : 0));
            this.Gio.Gii = surfaceTexture2;
            com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gip;
            if (bVar == null || (aVar2 = bVar.Ghy) == null) {
                i2 = 0;
            } else {
                i2 = aVar2.width;
            }
            com.tencent.mm.plugin.thumbplayer.e.b bVar2 = this.Gip;
            if (bVar2 == null || (aVar = bVar2.Ghy) == null) {
                i3 = 0;
            } else {
                i3 = aVar.height;
            }
            Log.i(this.Gio.TAG, "recreatePlayerSurface defaultBufferSize:[" + i2 + ',' + i3 + ']');
            SurfaceTexture surfaceTexture3 = this.Gio.Gii;
            if (surfaceTexture3 != null) {
                surfaceTexture3.setDefaultBufferSize(i2, i3);
            }
            this.Gio.Gij = new Surface(this.Gio.Gii);
            String str = this.Gio.TAG;
            StringBuilder sb = new StringBuilder("recreatePlayerSurface create playerSurface:");
            Surface surface = this.Gio.Gij;
            if (surface != null) {
                i4 = surface.hashCode();
            }
            Log.i(str, sb.append(i4).append(", cost:").append(Util.ticksToNow(this.iiX)).toString());
            com.tencent.mm.plugin.thumbplayer.e.b bVar3 = this.Gip;
            if (bVar3 != null) {
                com.tencent.mm.plugin.thumbplayer.e.b.a(bVar3, this.Gio.Gij);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(258225);
            return xVar;
        }
    }

    public static final /* synthetic */ String c(MMMvVideoLayout mMMvVideoLayout) {
        AppMethodBeat.i(238783);
        String dFm = mMMvVideoLayout.dFm();
        AppMethodBeat.o(238783);
        return dFm;
    }

    public final int getCOMPLETE() {
        return this.COMPLETE;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMMvVideoLayout(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(238779);
        init();
        AppMethodBeat.o(238779);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMMvVideoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(238780);
        init();
        AppMethodBeat.o(238780);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMMvVideoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(238781);
        init();
        AppMethodBeat.o(238781);
    }

    public final com.tencent.mm.plugin.thumbplayer.e.b getCurrentPlayer() {
        return this.Gic;
    }

    public final void setCurrentPlayer(com.tencent.mm.plugin.thumbplayer.e.b bVar) {
        this.Gic = bVar;
    }

    public final MMThumbPlayerTextureView getTextureView() {
        return this.wdE;
    }

    public final void setTextureView(MMThumbPlayerTextureView mMThumbPlayerTextureView) {
        this.wdE = mMThumbPlayerTextureView;
    }

    public final int getCurrentPlayIndex() {
        return this.Gid;
    }

    public final void setCurrentPlayIndex(int i2) {
        this.Gid = i2;
    }

    public final List<com.tencent.mm.plugin.thumbplayer.d.a> getMediaInfoList() {
        return this.Gie;
    }

    public final void setMediaInfoList(List<com.tencent.mm.plugin.thumbplayer.d.a> list) {
        this.Gie = list;
    }

    public final long getTotalLength() {
        return this.kNt;
    }

    public final void setTotalLength(long j2) {
        this.kNt = j2;
    }

    public final MMHandler getPlayTimer() {
        return this.Gif;
    }

    public final void setPlayTimer(MMHandler mMHandler) {
        this.Gif = mMHandler;
    }

    public final com.tencent.mm.plugin.thumbplayer.c.a getEffector() {
        return this.Gig;
    }

    public final void setEffector(com.tencent.mm.plugin.thumbplayer.c.a aVar) {
        AppMethodBeat.i(238762);
        p.h(aVar, "<set-?>");
        this.Gig = aVar;
        AppMethodBeat.o(238762);
    }

    public final d getMediaChangeListener() {
        return this.Atz;
    }

    public final void setMediaChangeListener(d dVar) {
        this.Atz = dVar;
    }

    public final c getMvMusicProxy() {
        return this.Gih;
    }

    public final void setMvMusicProxy(c cVar) {
        this.Gih = cVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Long, ? super java.lang.Long, kotlin.x>, kotlin.g.a.m<java.lang.Long, java.lang.Long, kotlin.x> */
    public final m<Long, Long, x> getOnProgressUpdate() {
        return this.Gil;
    }

    public final void setOnProgressUpdate(m<? super Long, ? super Long, x> mVar) {
        this.Gil = mVar;
    }

    public final boolean getPauseVideoOnPlay() {
        return this.Gim;
    }

    public final void setPauseVideoOnPlay(boolean z) {
        this.Gim = z;
    }

    public final boolean getLogFrameRender() {
        return this.VfR;
    }

    public final void setLogFrameRender(boolean z) {
        this.VfR = z;
    }

    public final g getPlayerActionListener() {
        return this.VfP;
    }

    public final void setPlayerActionListener(g gVar) {
        this.VfP = gVar;
    }

    public final com.tencent.mm.plugin.thumbplayer.d.d getReportInfo() {
        return this.VfS;
    }

    public final void setReportInfo(com.tencent.mm.plugin.thumbplayer.d.d dVar) {
        AppMethodBeat.i(260011);
        p.h(dVar, "<set-?>");
        this.VfS = dVar;
        AppMethodBeat.o(260011);
    }

    private void init() {
        AppMethodBeat.i(238763);
        this.VfS.VfJ = this.Gig.Vfv;
        this.wdE = new MMThumbPlayerTextureView(getContext());
        MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
        if (mMThumbPlayerTextureView != null) {
            mMThumbPlayerTextureView.setTextureListenerCallback(new a());
        }
        MMThumbPlayerTextureView mMThumbPlayerTextureView2 = this.wdE;
        if (mMThumbPlayerTextureView2 != null) {
            mMThumbPlayerTextureView2.setAlpha(1.0f);
        }
        this.Gif = new MMHandler(Looper.getMainLooper(), new b(this));
        if (this.rwI) {
            fxc();
        }
        AppMethodBeat.o(238763);
    }

    public static final class b implements MMHandler.Callback {
        final /* synthetic */ MMMvVideoLayout Gio;

        b(MMMvVideoLayout mMMvVideoLayout) {
            this.Gio = mMMvVideoLayout;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(238755);
            if (message.what == this.Gio.getCOMPLETE()) {
                MMMvVideoLayout.a(this.Gio, this.Gio.getCurrentPlayer());
            }
            AppMethodBeat.o(238755);
            return false;
        }
    }

    public static /* synthetic */ void a(MMMvVideoLayout mMMvVideoLayout, List list) {
        AppMethodBeat.i(238765);
        mMMvVideoLayout.q(list, true);
        AppMethodBeat.o(238765);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r0 == null) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(java.util.List<com.tencent.mm.plugin.thumbplayer.d.a> r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout.q(java.util.List, boolean):void");
    }

    public final void setEnableEffect(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        AppMethodBeat.i(238766);
        Log.i(this.TAG, "setEnableEffect:" + z + ", enableEffect:" + this.rwI + ", surfaceTexture:" + this.surfaceTexture);
        if (this.rwI != z) {
            this.rwI = z;
            if (this.rwI) {
                MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
                if (mMThumbPlayerTextureView != null) {
                    MMThumbPlayerTextureView.a aVar = MMThumbPlayerTextureView.GiC;
                    mMThumbPlayerTextureView.setScaleType(MMThumbPlayerTextureView.GiA);
                }
                MMThumbPlayerTextureView mMThumbPlayerTextureView2 = this.wdE;
                if (!(mMThumbPlayerTextureView2 == null || (layoutParams2 = mMThumbPlayerTextureView2.getLayoutParams()) == null)) {
                    layoutParams2.width = -1;
                }
                MMThumbPlayerTextureView mMThumbPlayerTextureView3 = this.wdE;
                if (!(mMThumbPlayerTextureView3 == null || (layoutParams = mMThumbPlayerTextureView3.getLayoutParams()) == null)) {
                    layoutParams.height = -1;
                }
                MMThumbPlayerTextureView mMThumbPlayerTextureView4 = this.wdE;
                if (mMThumbPlayerTextureView4 != null) {
                    mMThumbPlayerTextureView4.requestLayout();
                }
                fxc();
            }
        }
        AppMethodBeat.o(238766);
    }

    private final void fxc() {
        AppMethodBeat.i(238767);
        this.Gig.aq(new c(this));
        this.Gig.M(new d(this));
        this.Gig.GgO = new e(this);
        AppMethodBeat.o(238767);
    }

    public static final class e implements a.b {
        final /* synthetic */ MMMvVideoLayout Gio;

        e(MMMvVideoLayout mMMvVideoLayout) {
            this.Gio = mMMvVideoLayout;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.c.a.b
        public final long fwR() {
            AppMethodBeat.i(238758);
            com.tencent.mm.plugin.thumbplayer.e.b currentPlayer = this.Gio.getCurrentPlayer();
            if (currentPlayer != null) {
                long currentPositionMs = currentPlayer.getCurrentPositionMs();
                AppMethodBeat.o(238758);
                return currentPositionMs;
            }
            AppMethodBeat.o(238758);
            return -1;
        }
    }

    public final void start() {
        AppMethodBeat.i(238768);
        h(this.Gic);
        com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gic;
        if (bVar != null) {
            bVar.fwU();
        }
        a(this, false, 2);
        Log.i(this.TAG, "start play " + dFm());
        this.VfS.gXF = Util.currentTicks();
        AppMethodBeat.o(238768);
    }

    public final long getLastPauseMvPosition() {
        return this.Gin;
    }

    public final void setLastPauseMvPosition(long j2) {
        this.Gin = j2;
    }

    public final void pause() {
        AppMethodBeat.i(238769);
        c cVar = this.Gih;
        if (cVar != null) {
            this.Gin = cVar.getCurrentPosition();
            com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gic;
            if (bVar != null) {
                bVar.pause();
            }
            fxe();
        }
        Log.i(this.TAG, "pause lastPauseMvPosition:" + this.Gin);
        AppMethodBeat.o(238769);
    }

    public final void resume() {
        AppMethodBeat.i(238770);
        c cVar = this.Gih;
        if (cVar != null) {
            long currentPosition = cVar.getCurrentPosition();
            if (this.Gin == currentPosition) {
                com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gic;
                if (bVar != null) {
                    bVar.fwU();
                }
                a(this, false, 3);
            } else {
                KG(currentPosition);
            }
        }
        Log.i(this.TAG, "resume lastPauseMvPosition:" + this.Gin);
        this.Gin = -1;
        AppMethodBeat.o(238770);
    }

    public final void fxd() {
        AppMethodBeat.i(238771);
        long currentTicks = Util.currentTicks();
        String str = this.TAG;
        StringBuilder append = new StringBuilder("recreatePlayer currentPlayer:").append(this.Gic).append(", playerSurface:");
        Surface surface = this.Gij;
        Log.i(str, append.append(surface != null ? surface.hashCode() : 0).toString());
        com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gic;
        if (bVar != null) {
            bVar.VfN = null;
            bVar.dFs();
            bVar.dFp();
            bVar.stopAsync();
            bVar.recycle();
            this.VfS.a(this.Gid, bVar.VfQ);
        }
        fxe();
        d.a aVar = com.tencent.mm.plugin.thumbplayer.e.d.GhZ;
        Context context = getContext();
        p.g(context, "context");
        com.tencent.mm.plugin.thumbplayer.e.b hu = d.a.hu(context);
        this.Gig.j(hu);
        this.Gic = hu;
        Log.i(this.TAG, "recreatePlayer finished, cost:" + Util.ticksToNow(currentTicks));
        AppMethodBeat.o(238771);
    }

    public final void KG(long j2) {
        int i2;
        long j3;
        String str;
        Long l;
        Long l2;
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        String str2;
        String str3;
        com.tencent.mm.plugin.thumbplayer.d.a aVar2;
        com.tencent.mm.plugin.thumbplayer.d.a aVar3;
        com.tencent.mm.plugin.thumbplayer.d.a aVar4;
        AppMethodBeat.i(238772);
        Log.d(this.TAG, "seekToTime:".concat(String.valueOf(j2)));
        com.tencent.mm.plugin.thumbplayer.d.a aVar5 = null;
        List<com.tencent.mm.plugin.thumbplayer.d.a> list = this.Gie;
        if (list != null) {
            int i3 = 0;
            i2 = 0;
            for (T t : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                T t2 = t;
                if (t2.Ghu > j2 || t2.Ghu + t2.Ghv < j2) {
                    i3 = i4;
                } else {
                    List<com.tencent.mm.plugin.thumbplayer.d.a> list2 = this.Gie;
                    i2 = i3;
                    aVar5 = list2 != null ? list2.get(i3) : null;
                    i3 = i4;
                }
            }
        } else {
            i2 = 0;
        }
        List<com.tencent.mm.plugin.thumbplayer.d.a> list3 = this.Gie;
        long j4 = (list3 == null || (aVar4 = (com.tencent.mm.plugin.thumbplayer.d.a) j.ku(list3)) == null) ? 0 : aVar4.Ghu;
        List<com.tencent.mm.plugin.thumbplayer.d.a> list4 = this.Gie;
        if (list4 == null || (aVar3 = (com.tencent.mm.plugin.thumbplayer.d.a) j.ku(list4)) == null) {
            j3 = 0;
        } else {
            j3 = aVar3.Ghv;
        }
        long j5 = j3 + j4;
        if (aVar5 == null && j2 >= j5) {
            Log.i(this.TAG, "cannot found targetInfo, maybe seek exceed to end");
            List<com.tencent.mm.plugin.thumbplayer.d.a> list5 = this.Gie;
            j2 = 0;
            aVar5 = list5 != null ? (com.tencent.mm.plugin.thumbplayer.d.a) j.ks(list5) : null;
        }
        String str4 = this.TAG;
        StringBuilder sb = new StringBuilder("seekToTime targetInfo:");
        if (aVar5 != null) {
            str = aVar5.mediaId;
        } else {
            str = null;
        }
        StringBuilder append = sb.append(str).append(" targetPlayIndex:").append(i2).append(" targetSeekTimeMs:").append(j2).append(", offsetInMv:").append(aVar5 != null ? Long.valueOf(aVar5.Ghu) : null).append(", offsetInClips:");
        if (aVar5 != null) {
            l = Long.valueOf(aVar5.Ghw);
        } else {
            l = null;
        }
        StringBuilder append2 = append.append(l).append(", duration:");
        if (aVar5 != null) {
            l2 = Long.valueOf(aVar5.pLQ);
        } else {
            l2 = null;
        }
        StringBuilder append3 = append2.append(l2).append(", currentPlayer.media:");
        com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gic;
        if (bVar != null) {
            aVar = bVar.Ghy;
        } else {
            aVar = null;
        }
        Log.i(str4, append3.append(aVar).toString());
        if (aVar5 != null) {
            long j6 = aVar5.Ghw + (j2 - aVar5.Ghu);
            boolean z = true;
            if (j6 > aVar5.pLQ) {
                Log.i(this.TAG, "seekToTime larger than duration realSeekTimeMs " + aVar5.pLQ + ", timeOffset:" + aVar5.Ghw);
                if (aVar5.Ght) {
                    Log.i(this.TAG, "defaultVideo no need to updateTimer");
                    z = false;
                }
                if (aVar5.Ghw < aVar5.pLQ) {
                    j6 = aVar5.Ghw;
                } else {
                    j6 = 0;
                }
            }
            long j7 = aVar5.Ghv - (j2 - aVar5.Ghu);
            this.Gid = i2;
            com.tencent.mm.plugin.thumbplayer.e.b bVar2 = this.Gic;
            if (bVar2 == null || (aVar2 = bVar2.Ghy) == null) {
                str2 = null;
            } else {
                str2 = aVar2.mediaId;
            }
            if (!p.j(str2, aVar5.mediaId)) {
                fxd();
                com.tencent.mm.plugin.thumbplayer.e.b bVar3 = this.Gic;
                if (bVar3 != null) {
                    bVar3.setMediaInfo(aVar5);
                }
                h(this.Gic);
                com.tencent.mm.plugin.thumbplayer.e.b bVar4 = this.Gic;
                if (bVar4 != null) {
                    bVar4.GhK = j6;
                }
                com.tencent.mm.plugin.thumbplayer.e.b bVar5 = this.Gic;
                if (bVar5 != null) {
                    bVar5.fwU();
                }
                str3 = "switch to " + i2 + " media";
            } else {
                com.tencent.mm.plugin.thumbplayer.e.b bVar6 = this.Gic;
                if (bVar6 == null || !bVar6.YY()) {
                    com.tencent.mm.plugin.thumbplayer.e.b bVar7 = this.Gic;
                    if (bVar7 == null || bVar7.asa()) {
                        com.tencent.mm.plugin.thumbplayer.e.b bVar8 = this.Gic;
                        if (bVar8 != null) {
                            bVar8.YX((int) j6);
                        }
                        str3 = "current media play direct seek";
                    } else {
                        com.tencent.mm.plugin.thumbplayer.e.b bVar9 = this.Gic;
                        if (bVar9 != null) {
                            bVar9.GhK = j6;
                        }
                        str3 = "current media prepare seek when play";
                    }
                } else {
                    com.tencent.mm.plugin.thumbplayer.e.b bVar10 = this.Gic;
                    if (bVar10 != null) {
                        bVar10.YX((int) j6);
                    }
                    com.tencent.mm.plugin.thumbplayer.e.b bVar11 = this.Gic;
                    if (bVar11 != null) {
                        bVar11.fwU();
                    }
                    str3 = "current media play";
                }
            }
            if (z) {
                a(this, false, 3);
            }
            Log.i(this.TAG, "seekToTime realSeekTimeMs:" + j6 + " playTimeMs:" + j7 + " source:" + str3 + ' ' + dFm());
            AppMethodBeat.o(238772);
            return;
        }
        AppMethodBeat.o(238772);
    }

    public static /* synthetic */ void a(MMMvVideoLayout mMMvVideoLayout, boolean z, int i2) {
        AppMethodBeat.i(238774);
        if ((i2 & 1) != 0) {
            z = true;
        }
        mMMvVideoLayout.ws(z);
        AppMethodBeat.o(238774);
    }

    private void ws(boolean z) {
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        AppMethodBeat.i(238773);
        c cVar = this.Gih;
        if (cVar != null) {
            com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gic;
            if (bVar == null || (aVar = bVar.Ghy) == null) {
                AppMethodBeat.o(238773);
                return;
            }
            long currentPosition = cVar.getCurrentPosition();
            long j2 = aVar.Ghu + aVar.Ghv;
            if (!z) {
                long j3 = aVar.Ghv;
                MMHandler mMHandler = this.Gif;
                if (mMHandler != null) {
                    mMHandler.removeCallbacksAndMessages(null);
                }
                MMHandler mMHandler2 = this.Gif;
                if (mMHandler2 != null) {
                    mMHandler2.sendEmptyMessageAtTime(this.COMPLETE, j3 + SystemClock.uptimeMillis());
                    AppMethodBeat.o(238773);
                    return;
                }
            } else if (j2 > currentPosition) {
                long j4 = j2 - currentPosition;
                MMHandler mMHandler3 = this.Gif;
                if (mMHandler3 != null) {
                    mMHandler3.removeCallbacksAndMessages(null);
                }
                MMHandler mMHandler4 = this.Gif;
                if (mMHandler4 != null) {
                    mMHandler4.sendEmptyMessageAtTime(this.COMPLETE, j4 + SystemClock.uptimeMillis());
                    AppMethodBeat.o(238773);
                    return;
                }
                AppMethodBeat.o(238773);
                return;
            }
            AppMethodBeat.o(238773);
            return;
        }
        AppMethodBeat.o(238773);
    }

    private void fxe() {
        AppMethodBeat.i(238775);
        Log.i(this.TAG, "removeCompleteTimer");
        com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gic;
        if (bVar != null) {
            com.tencent.mm.plugin.thumbplayer.e.b.a(bVar);
        }
        MMHandler mMHandler = this.Gif;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
            AppMethodBeat.o(238775);
            return;
        }
        AppMethodBeat.o(238775);
    }

    public final void recycle() {
        AppMethodBeat.i(238776);
        Log.i(this.TAG, "recycle");
        com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gic;
        if (bVar != null) {
            bVar.stopAsync();
        }
        com.tencent.mm.plugin.thumbplayer.e.b bVar2 = this.Gic;
        if (bVar2 != null) {
            bVar2.recycle();
        }
        com.tencent.mm.plugin.thumbplayer.e.b bVar3 = this.Gic;
        if (bVar3 != null) {
            this.VfS.a(this.Gid, bVar3.VfQ);
        }
        MMHandler mMHandler = this.Gif;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        MMHandler mMHandler2 = this.Gif;
        if (mMHandler2 != null) {
            mMHandler2.quit();
        }
        this.Gig.release();
        this.Gij = null;
        AppMethodBeat.o(238776);
    }

    public final class a implements TextureView.SurfaceTextureListener {
        public a() {
            MMMvVideoLayout.this = r1;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(238751);
            Log.i(MMMvVideoLayout.this.TAG, "onSurfaceTextureSizeChanged " + surfaceTexture + ", size:[" + i2 + ',' + i3 + ']');
            MMMvVideoLayout.this.surfaceTexture = surfaceTexture;
            MMMvVideoLayout.this.getEffector().jj(i2, i3);
            AppMethodBeat.o(238751);
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(238752);
            MMMvVideoLayout.b(MMMvVideoLayout.this);
            MMMvVideoLayout.this.surfaceTexture = surfaceTexture;
            AppMethodBeat.o(238752);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Surface surface;
            AppMethodBeat.i(238753);
            Log.i(MMMvVideoLayout.this.TAG, "onSurfaceTextureDestroyed, surface:" + (surfaceTexture != null ? surfaceTexture.hashCode() : 0) + ' ' + MMMvVideoLayout.c(MMMvVideoLayout.this));
            MMMvVideoLayout.this.surfaceTexture = null;
            if (!MMMvVideoLayout.this.rwI && (surface = MMMvVideoLayout.this.Gij) != null) {
                surface.release();
            }
            com.tencent.mm.plugin.thumbplayer.e.b currentPlayer = MMMvVideoLayout.this.getCurrentPlayer();
            if (currentPlayer != null) {
                com.tencent.mm.plugin.thumbplayer.e.b.a(currentPlayer, (Surface) null);
            }
            AppMethodBeat.o(238753);
            return true;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Surface surface;
            AppMethodBeat.i(238754);
            Log.i(MMMvVideoLayout.this.TAG, "onSurfaceTextureAvailable, surface:" + (surfaceTexture != null ? surfaceTexture.hashCode() : 0) + ", width:" + i2 + ", height:" + i3 + ", enableEffect:" + MMMvVideoLayout.this.rwI);
            MMMvVideoLayout.this.surfaceTexture = surfaceTexture;
            MMMvVideoLayout.this.getEffector().jj(i2, i3);
            if (!MMMvVideoLayout.this.rwI) {
                MMMvVideoLayout.this.Gii = surfaceTexture;
                if (!(MMMvVideoLayout.this.Gij == null || (surface = MMMvVideoLayout.this.Gij) == null)) {
                    surface.release();
                }
                MMMvVideoLayout.this.Gij = new Surface(MMMvVideoLayout.this.Gii);
                com.tencent.mm.plugin.thumbplayer.e.b currentPlayer = MMMvVideoLayout.this.getCurrentPlayer();
                if (currentPlayer != null) {
                    currentPlayer.b(MMMvVideoLayout.this.Gij, true);
                    AppMethodBeat.o(238754);
                    return;
                }
            } else if (surfaceTexture != null) {
                MMMvVideoLayout.this.getEffector().m(surfaceTexture);
                AppMethodBeat.o(238754);
                return;
            }
            AppMethodBeat.o(238754);
        }
    }

    public final void setProgressUpdateInterval(long j2) {
        if (j2 > 0) {
            this.Gik = j2;
        }
    }

    private final void h(com.tencent.mm.plugin.thumbplayer.e.b bVar) {
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        boolean z;
        AppMethodBeat.i(238777);
        long currentTicks = Util.currentTicks();
        String str = this.TAG;
        StringBuilder append = new StringBuilder("initPlayer ").append(dFm()).append(", playerSurface:");
        Surface surface = this.Gij;
        Log.i(str, append.append(surface != null ? surface.hashCode() : 0).append(", player:").append(bVar != null ? bVar.hashCode() : 0).toString());
        if (bVar != null) {
            bVar.wcA = true;
        }
        if (bVar != null) {
            bVar.fwW();
        }
        if (bVar != null) {
            com.tencent.mm.plugin.thumbplayer.d.a aVar2 = bVar.Ghy;
            if (aVar2 != null) {
                z = aVar2.loop;
            } else {
                z = false;
            }
            bVar.setLoop(z);
        }
        if (!(bVar == null || (aVar = bVar.Ghy) == null)) {
            bVar.GhK = aVar.Ghw;
            d dVar = this.Atz;
            if (dVar != null) {
                dVar.a(this.Gid, aVar);
            }
        }
        if (bVar != null) {
            bVar.a(new f(this, bVar), this.Gik);
        }
        i(bVar);
        this.VfR = false;
        if (bVar != null) {
            bVar.VfP = this.VfP;
        }
        Log.i(this.TAG, "initPlayer " + (bVar != null ? bVar.dFm() : null) + ", currentPlayIndex:" + this.Gid + ", cost:" + Util.ticksToNow(currentTicks));
        this.VfT = Util.currentTicks();
        AppMethodBeat.o(238777);
    }

    public static final class f implements e {
        final /* synthetic */ MMMvVideoLayout Gio;
        final /* synthetic */ com.tencent.mm.plugin.thumbplayer.e.b Gip;

        f(MMMvVideoLayout mMMvVideoLayout, com.tencent.mm.plugin.thumbplayer.e.b bVar) {
            this.Gio = mMMvVideoLayout;
            this.Gip = bVar;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.view.e
        public final void Hv(long j2) {
            long j3;
            long j4 = 0;
            AppMethodBeat.i(238759);
            MMMvVideoLayout.a(this.Gio, false, 3);
            com.tencent.mm.plugin.thumbplayer.d.a aVar = this.Gip.Ghy;
            if (aVar != null) {
                j3 = aVar.Ghv;
            } else {
                j3 = 0;
            }
            com.tencent.mm.plugin.thumbplayer.d.a aVar2 = this.Gip.Ghy;
            if (aVar2 != null) {
                j4 = aVar2.Ghw;
            }
            m<Long, Long, x> onProgressUpdate = this.Gio.getOnProgressUpdate();
            if (onProgressUpdate != null) {
                onProgressUpdate.invoke(Long.valueOf(j2 - j4), Long.valueOf(j3));
                AppMethodBeat.o(238759);
                return;
            }
            AppMethodBeat.o(238759);
        }
    }

    private final void i(com.tencent.mm.plugin.thumbplayer.e.b bVar) {
        AppMethodBeat.i(258226);
        Log.i(this.TAG, "start recreatePlayerSurface");
        long currentTicks = Util.currentTicks();
        Surface surface = this.Gij;
        if (surface != null) {
            surface.release();
        }
        this.Gij = null;
        this.Gii = null;
        this.Gig.L(new i(this, bVar, currentTicks));
        AppMethodBeat.o(258226);
    }

    public final String dFm() {
        AppMethodBeat.i(238778);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Gic;
        String sb2 = sb.append(bVar != null ? bVar.dFm() : null).append(" layout:").append(hashCode()).append(" currentPlayIndex:").append(this.Gid).toString();
        AppMethodBeat.o(238778);
        return sb2;
    }

    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MMMvVideoLayout Gio;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MMMvVideoLayout mMMvVideoLayout) {
            super(0);
            this.Gio = mMMvVideoLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(258224);
            String str = this.Gio.TAG;
            StringBuilder sb = new StringBuilder("initEffector finished, currentPlayer:");
            com.tencent.mm.plugin.thumbplayer.e.b currentPlayer = this.Gio.getCurrentPlayer();
            if (currentPlayer != null) {
                i2 = currentPlayer.hashCode();
            } else {
                i2 = 0;
            }
            Log.i(str, sb.append(i2).toString());
            x xVar = x.SXb;
            AppMethodBeat.o(258224);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(MMMvVideoLayout mMMvVideoLayout) {
        AppMethodBeat.i(238782);
        MMThumbPlayerTextureView mMThumbPlayerTextureView = mMMvVideoLayout.wdE;
        if (mMThumbPlayerTextureView != null) {
            mMThumbPlayerTextureView.setAlpha(1.0f);
            AppMethodBeat.o(238782);
            return;
        }
        AppMethodBeat.o(238782);
    }

    public static final /* synthetic */ void a(MMMvVideoLayout mMMvVideoLayout, com.tencent.mm.plugin.thumbplayer.e.b bVar) {
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        AppMethodBeat.i(260012);
        Log.i(mMMvVideoLayout.TAG, "onCompletion " + bVar + ' ' + mMMvVideoLayout.dFm());
        Log.i(mMMvVideoLayout.TAG, "seekToNext " + mMMvVideoLayout.dFm());
        mMMvVideoLayout.fxd();
        mMMvVideoLayout.Gid++;
        List<com.tencent.mm.plugin.thumbplayer.d.a> list = mMMvVideoLayout.Gie;
        if ((list != null ? list.size() : 0) <= mMMvVideoLayout.Gid) {
            mMMvVideoLayout.Gid = 0;
        }
        List<com.tencent.mm.plugin.thumbplayer.d.a> list2 = mMMvVideoLayout.Gie;
        if (list2 == null || (aVar = list2.get(mMMvVideoLayout.Gid)) == null) {
            AppMethodBeat.o(260012);
            return;
        }
        com.tencent.mm.plugin.thumbplayer.e.b bVar2 = mMMvVideoLayout.Gic;
        if (bVar2 != null) {
            bVar2.setMediaInfo(aVar);
        }
        mMMvVideoLayout.start();
        AppMethodBeat.o(260012);
    }
}
