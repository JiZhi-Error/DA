package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001>B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u00103\u001a\u00020\u001c2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\u0006\u00105\u001a\u00020\u001cJ\b\u00106\u001a\u00020\u001cH\u0002J\u0006\u00107\u001a\u00020\u001cJ\b\u00108\u001a\u00020\u001cH\u0002J\u000e\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020=R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R9\u0010\u0016\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020.X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "createPlayer", "", "(Landroid/content/Context;Z)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "effector", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "getEffector", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "setEffector", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;)V", "enableEffect", "onFrameAvailable", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surface", "", "getOnFrameAvailable", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailable", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "playerSurface", "Landroid/view/Surface;", "playerSurfaceTexture", "surfaceHeight", "surfaceTexture", "surfaceWidth", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;)V", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initEffector", "initTextureView", "onVideoContentUpdate", "recreatePlayer", "recreatePlayerSurface", "setEnableEffect", "enable", "setMediaInfo", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "SurfaceTextureListener", "plugin-thumbplayer_release"})
public final class MMTPRecyclerVideoLayout extends FrameLayout {
    private com.tencent.mm.plugin.thumbplayer.e.b Asn;
    private com.tencent.mm.plugin.thumbplayer.c.a Gig;
    private SurfaceTexture Gii;
    private Surface Gij;
    private kotlin.g.a.b<? super SurfaceTexture, x> Giq;
    private final String TAG;
    private boolean rwI;
    private int surfaceHeight;
    private SurfaceTexture surfaceTexture;
    private int surfaceWidth;
    public MMThumbPlayerTextureView wdE;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ MMTPRecyclerVideoLayout Gir;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout) {
            super(1);
            this.Gir = mMTPRecyclerVideoLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(238789);
            l.longValue();
            MMTPRecyclerVideoLayout.c(this.Gir);
            kotlin.g.a.b<SurfaceTexture, x> onFrameAvailable = this.Gir.getOnFrameAvailable();
            if (onFrameAvailable != null) {
                onFrameAvailable.invoke(this.Gir.surfaceTexture);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(238789);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<SurfaceTexture, x> {
        final /* synthetic */ MMTPRecyclerVideoLayout Gir;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout) {
            super(1);
            this.Gir = mMTPRecyclerVideoLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
            int i2;
            int i3;
            com.tencent.mm.plugin.thumbplayer.d.a aVar;
            com.tencent.mm.plugin.thumbplayer.d.a aVar2;
            int i4 = 0;
            AppMethodBeat.i(258228);
            SurfaceTexture surfaceTexture2 = surfaceTexture;
            Log.i(this.Gir.TAG, "recreatePlayerSurface createVideoTexture finished surface:" + (surfaceTexture2 != null ? surfaceTexture2.hashCode() : 0));
            this.Gir.Gii = surfaceTexture2;
            this.Gir.Gij = new Surface(this.Gir.Gii);
            String str = this.Gir.TAG;
            StringBuilder sb = new StringBuilder("recreatePlayerSurface create playerSurface finished surface:");
            Surface surface = this.Gir.Gij;
            if (surface != null) {
                i2 = surface.hashCode();
            } else {
                i2 = 0;
            }
            Log.i(str, sb.append(i2).toString());
            com.tencent.mm.plugin.thumbplayer.e.b player = this.Gir.getPlayer();
            if (player == null || (aVar2 = player.Ghy) == null) {
                i3 = 0;
            } else {
                i3 = aVar2.width;
            }
            com.tencent.mm.plugin.thumbplayer.e.b player2 = this.Gir.getPlayer();
            if (!(player2 == null || (aVar = player2.Ghy) == null)) {
                i4 = aVar.height;
            }
            SurfaceTexture surfaceTexture3 = this.Gir.Gii;
            if (surfaceTexture3 != null) {
                surfaceTexture3.setDefaultBufferSize(i3, i4);
            }
            Log.i(this.Gir.TAG, "recreatePlayerSurface defaultBufferSize:[" + i3 + ',' + i4 + ']');
            com.tencent.mm.plugin.thumbplayer.e.b player3 = this.Gir.getPlayer();
            if (player3 != null) {
                com.tencent.mm.plugin.thumbplayer.e.b.a(player3, this.Gir.Gij);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(258228);
            return xVar;
        }
    }

    public final com.tencent.mm.plugin.thumbplayer.e.b getPlayer() {
        return this.Asn;
    }

    public final void setPlayer(com.tencent.mm.plugin.thumbplayer.e.b bVar) {
        this.Asn = bVar;
    }

    public final MMThumbPlayerTextureView getTextureView() {
        AppMethodBeat.i(238790);
        MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        AppMethodBeat.o(238790);
        return mMThumbPlayerTextureView;
    }

    public final void setTextureView(MMThumbPlayerTextureView mMThumbPlayerTextureView) {
        AppMethodBeat.i(238791);
        p.h(mMThumbPlayerTextureView, "<set-?>");
        this.wdE = mMThumbPlayerTextureView;
        AppMethodBeat.o(238791);
    }

    public final com.tencent.mm.plugin.thumbplayer.c.a getEffector() {
        return this.Gig;
    }

    public final void setEffector(com.tencent.mm.plugin.thumbplayer.c.a aVar) {
        AppMethodBeat.i(238792);
        p.h(aVar, "<set-?>");
        this.Gig = aVar;
        AppMethodBeat.o(238792);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super android.graphics.SurfaceTexture, kotlin.x>, kotlin.g.a.b<android.graphics.SurfaceTexture, kotlin.x> */
    public final kotlin.g.a.b<SurfaceTexture, x> getOnFrameAvailable() {
        return this.Giq;
    }

    public final void setOnFrameAvailable(kotlin.g.a.b<? super SurfaceTexture, x> bVar) {
        this.Giq = bVar;
    }

    public /* synthetic */ MMTPRecyclerVideoLayout(Context context) {
        this(context, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMTPRecyclerVideoLayout(Context context, boolean z) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(238799);
        this.TAG = "MicroMsg.TP.MMTPRecyclerVideoLayout@" + hashCode();
        this.Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
        this.rwI = true;
        init(z);
        AppMethodBeat.o(238799);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMTPRecyclerVideoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(238800);
        this.TAG = "MicroMsg.TP.MMTPRecyclerVideoLayout@" + hashCode();
        this.Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
        this.rwI = true;
        init(true);
        AppMethodBeat.o(238800);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMTPRecyclerVideoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(238801);
        this.TAG = "MicroMsg.TP.MMTPRecyclerVideoLayout@" + hashCode();
        this.Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
        this.rwI = true;
        init(true);
        AppMethodBeat.o(238801);
    }

    private final void init(boolean z) {
        AppMethodBeat.i(238793);
        if (z) {
            d.a aVar = com.tencent.mm.plugin.thumbplayer.e.d.GhZ;
            Context context = getContext();
            p.g(context, "context");
            com.tencent.mm.plugin.thumbplayer.e.b hu = d.a.hu(context);
            this.Gig.j(hu);
            this.Asn = hu;
        }
        this.wdE = new MMThumbPlayerTextureView(getContext());
        MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        mMThumbPlayerTextureView.setAlpha(1.0f);
        if (this.rwI) {
            fxc();
        }
        AppMethodBeat.o(238793);
    }

    public final void fxd() {
        int i2;
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        int i3 = 0;
        AppMethodBeat.i(238794);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("recreatePlayer, this.player:");
        com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Asn;
        if (bVar != null) {
            i2 = bVar.hashCode();
        } else {
            i2 = 0;
        }
        StringBuilder append = sb.append(i2).append(", mediaInfo:");
        com.tencent.mm.plugin.thumbplayer.e.b bVar2 = this.Asn;
        if (bVar2 != null) {
            aVar = bVar2.Ghy;
        } else {
            aVar = null;
        }
        Log.i(str, append.append(aVar).toString());
        com.tencent.mm.plugin.thumbplayer.e.b bVar3 = this.Asn;
        if (bVar3 != null) {
            bVar3.dFs();
        }
        com.tencent.mm.plugin.thumbplayer.e.b bVar4 = this.Asn;
        if (bVar4 != null) {
            bVar4.dFp();
        }
        com.tencent.mm.plugin.thumbplayer.e.b bVar5 = this.Asn;
        if (bVar5 != null) {
            bVar5.stopAsync();
        }
        com.tencent.mm.plugin.thumbplayer.e.b bVar6 = this.Asn;
        if (bVar6 != null) {
            bVar6.recycle();
        }
        this.Asn = null;
        Surface surface = this.Gij;
        if (surface != null) {
            surface.release();
        }
        this.Gij = null;
        this.Gii = null;
        d.a aVar2 = com.tencent.mm.plugin.thumbplayer.e.d.GhZ;
        Context context = getContext();
        p.g(context, "context");
        com.tencent.mm.plugin.thumbplayer.e.b hu = d.a.hu(context);
        this.Gig.j(hu);
        this.Asn = hu;
        String str2 = this.TAG;
        StringBuilder sb2 = new StringBuilder("recreatePlayer finished, this.player:");
        com.tencent.mm.plugin.thumbplayer.e.b bVar7 = this.Asn;
        if (bVar7 != null) {
            i3 = bVar7.hashCode();
        }
        Log.i(str2, sb2.append(i3).append(", playerSurface:").append(this.Gij).toString());
        AppMethodBeat.o(238794);
    }

    public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.d.a aVar) {
        AppMethodBeat.i(238795);
        p.h(aVar, "mediaInfo");
        com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Asn;
        if (bVar != null) {
            bVar.setMediaInfo(aVar);
        }
        Log.i(this.TAG, "setMediaInfo:".concat(String.valueOf(aVar)));
        com.tencent.mm.plugin.thumbplayer.c.a aVar2 = this.Gig;
        p.h(aVar, "mediaInfo");
        aVar2.videoWidth = aVar.width;
        aVar2.videoHeight = aVar.height;
        aVar2.GgZ = aVar;
        aVar2.Ghb = aVar.pLQ;
        Log.i(aVar2.TAG, "setMediaInfo, size:[" + aVar2.videoWidth + ',' + aVar2.videoHeight + "], totalDurationMs:" + aVar2.Ghb);
        MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        mMThumbPlayerTextureView.jk(aVar.width, aVar.height);
        Surface surface = this.Gij;
        if (surface != null) {
            surface.release();
        }
        this.Gij = null;
        this.Gii = null;
        this.Gig.L(new d(this));
        AppMethodBeat.o(238795);
    }

    public final void setEnableEffect(boolean z) {
        AppMethodBeat.i(238796);
        Log.i(this.TAG, "setEnableEffect:" + z + ", surfaceTexture:" + this.surfaceTexture);
        if (this.rwI != z) {
            this.rwI = z;
            if (this.rwI) {
                MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
                if (mMThumbPlayerTextureView == null) {
                    p.btv("textureView");
                }
                MMThumbPlayerTextureView.a aVar = MMThumbPlayerTextureView.GiC;
                mMThumbPlayerTextureView.setScaleType(MMThumbPlayerTextureView.GiA);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                MMThumbPlayerTextureView mMThumbPlayerTextureView2 = this.wdE;
                if (mMThumbPlayerTextureView2 == null) {
                    p.btv("textureView");
                }
                if (mMThumbPlayerTextureView2.getParent() == null) {
                    MMThumbPlayerTextureView mMThumbPlayerTextureView3 = this.wdE;
                    if (mMThumbPlayerTextureView3 == null) {
                        p.btv("textureView");
                    }
                    addView(mMThumbPlayerTextureView3, layoutParams);
                } else {
                    MMThumbPlayerTextureView mMThumbPlayerTextureView4 = this.wdE;
                    if (mMThumbPlayerTextureView4 == null) {
                        p.btv("textureView");
                    }
                    mMThumbPlayerTextureView4.setLayoutParams(layoutParams);
                    MMThumbPlayerTextureView mMThumbPlayerTextureView5 = this.wdE;
                    if (mMThumbPlayerTextureView5 == null) {
                        p.btv("textureView");
                    }
                    mMThumbPlayerTextureView5.requestLayout();
                }
                fxc();
            }
        }
        AppMethodBeat.o(238796);
    }

    private final void fxc() {
        AppMethodBeat.i(238797);
        this.Gig.aq(new b(this));
        this.Gig.M(new c(this));
        AppMethodBeat.o(238797);
    }

    public final void fxf() {
        int i2;
        int i3;
        int i4;
        int i5;
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        com.tencent.mm.plugin.thumbplayer.d.a aVar2;
        AppMethodBeat.i(238798);
        MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        if (mMThumbPlayerTextureView.getParent() != null) {
            MMThumbPlayerTextureView mMThumbPlayerTextureView2 = this.wdE;
            if (mMThumbPlayerTextureView2 == null) {
                p.btv("textureView");
            }
            removeView(mMThumbPlayerTextureView2);
        }
        MMThumbPlayerTextureView mMThumbPlayerTextureView3 = this.wdE;
        if (mMThumbPlayerTextureView3 == null) {
            p.btv("textureView");
        }
        mMThumbPlayerTextureView3.setTextureListenerCallback(new a());
        if (this.rwI) {
            MMThumbPlayerTextureView mMThumbPlayerTextureView4 = this.wdE;
            if (mMThumbPlayerTextureView4 == null) {
                p.btv("textureView");
            }
            MMThumbPlayerTextureView.a aVar3 = MMThumbPlayerTextureView.GiC;
            mMThumbPlayerTextureView4.setScaleType(MMThumbPlayerTextureView.GiA);
            i4 = -1;
            i5 = -1;
        } else {
            com.tencent.mm.plugin.thumbplayer.a aVar4 = com.tencent.mm.plugin.thumbplayer.a.Ggt;
            Context context = getContext();
            p.g(context, "context");
            com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Asn;
            if (bVar == null || (aVar2 = bVar.Ghy) == null) {
                i2 = 0;
            } else {
                i2 = aVar2.width;
            }
            com.tencent.mm.plugin.thumbplayer.e.b bVar2 = this.Asn;
            if (bVar2 == null || (aVar = bVar2.Ghy) == null) {
                i3 = 0;
            } else {
                i3 = aVar.height;
            }
            Bundle k = com.tencent.mm.plugin.thumbplayer.a.k(context, i2, i3);
            int i6 = k.getInt("width", 0);
            i4 = k.getInt("height", 0);
            MMThumbPlayerTextureView mMThumbPlayerTextureView5 = this.wdE;
            if (mMThumbPlayerTextureView5 == null) {
                p.btv("textureView");
            }
            mMThumbPlayerTextureView5.jk(i6, i4);
            i5 = i6;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i4);
        MMThumbPlayerTextureView mMThumbPlayerTextureView6 = this.wdE;
        if (mMThumbPlayerTextureView6 == null) {
            p.btv("textureView");
        }
        addView(mMThumbPlayerTextureView6, layoutParams);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("initTextureView() ");
        com.tencent.mm.plugin.thumbplayer.e.b bVar3 = this.Asn;
        Log.i(str, sb.append(bVar3 != null ? bVar3.dFm() : null).append(", layout size:[").append(getWidth()).append(',').append(getHeight()).append(']').toString());
        AppMethodBeat.o(238798);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;)V", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
    public final class a implements TextureView.SurfaceTextureListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(238784);
            Log.i(MMTPRecyclerVideoLayout.this.TAG, "onSurfaceTextureSizeChanged, surface:" + (surfaceTexture != null ? surfaceTexture.hashCode() : 0) + ", width:" + i2 + ", height:" + i3 + ", layout size:[" + MMTPRecyclerVideoLayout.this.getWidth() + ',' + MMTPRecyclerVideoLayout.this.getHeight() + ']');
            MMTPRecyclerVideoLayout.this.surfaceTexture = surfaceTexture;
            MMTPRecyclerVideoLayout.this.surfaceWidth = i2;
            MMTPRecyclerVideoLayout.this.surfaceHeight = i3;
            MMTPRecyclerVideoLayout.this.getEffector().jj(i2, i3);
            AppMethodBeat.o(238784);
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(238785);
            MMTPRecyclerVideoLayout.c(MMTPRecyclerVideoLayout.this);
            MMTPRecyclerVideoLayout.this.surfaceTexture = surfaceTexture;
            AppMethodBeat.o(238785);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Surface surface;
            AppMethodBeat.i(238786);
            Log.i(MMTPRecyclerVideoLayout.this.TAG, "onSurfaceTextureDestroyed, surface:" + (surfaceTexture != null ? surfaceTexture.hashCode() : 0) + ", enableEffect:" + MMTPRecyclerVideoLayout.this.rwI);
            MMTPRecyclerVideoLayout.this.surfaceTexture = null;
            if (!MMTPRecyclerVideoLayout.this.rwI && (surface = MMTPRecyclerVideoLayout.this.Gij) != null) {
                surface.release();
            }
            com.tencent.mm.plugin.thumbplayer.e.b player = MMTPRecyclerVideoLayout.this.getPlayer();
            if (player != null) {
                com.tencent.mm.plugin.thumbplayer.e.b.a(player, (Surface) null);
            }
            AppMethodBeat.o(238786);
            return true;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Surface surface;
            AppMethodBeat.i(238787);
            Log.i(MMTPRecyclerVideoLayout.this.TAG, "onSurfaceTextureAvailable, surface:" + (surfaceTexture != null ? surfaceTexture.hashCode() : 0) + ", width:" + i2 + ", height:" + i3 + ", enableEffect:" + MMTPRecyclerVideoLayout.this.rwI);
            MMTPRecyclerVideoLayout.this.surfaceTexture = surfaceTexture;
            MMTPRecyclerVideoLayout.this.surfaceWidth = i2;
            MMTPRecyclerVideoLayout.this.surfaceHeight = i3;
            MMTPRecyclerVideoLayout.this.getEffector().jj(i2, i3);
            if (!MMTPRecyclerVideoLayout.this.rwI) {
                MMTPRecyclerVideoLayout.this.Gii = surfaceTexture;
                if (!(MMTPRecyclerVideoLayout.this.Gij == null || (surface = MMTPRecyclerVideoLayout.this.Gij) == null)) {
                    surface.release();
                }
                MMTPRecyclerVideoLayout.this.Gij = new Surface(MMTPRecyclerVideoLayout.this.Gii);
                com.tencent.mm.plugin.thumbplayer.e.b player = MMTPRecyclerVideoLayout.this.getPlayer();
                if (player != null) {
                    player.b(MMTPRecyclerVideoLayout.this.Gij, true);
                    AppMethodBeat.o(238787);
                    return;
                }
            } else if (surfaceTexture != null) {
                MMTPRecyclerVideoLayout.this.getEffector().m(surfaceTexture);
                AppMethodBeat.o(238787);
                return;
            }
            AppMethodBeat.o(238787);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MMTPRecyclerVideoLayout Gir;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout) {
            super(0);
            this.Gir = mMTPRecyclerVideoLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(258227);
            String str = this.Gir.TAG;
            StringBuilder sb = new StringBuilder("init effector finished, player:");
            com.tencent.mm.plugin.thumbplayer.e.b player = this.Gir.getPlayer();
            if (player != null) {
                i2 = player.hashCode();
            } else {
                i2 = 0;
            }
            Log.i(str, sb.append(i2).toString());
            x xVar = x.SXb;
            AppMethodBeat.o(258227);
            return xVar;
        }
    }

    public static final /* synthetic */ void c(MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout) {
        AppMethodBeat.i(238802);
        MMThumbPlayerTextureView mMThumbPlayerTextureView = mMTPRecyclerVideoLayout.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        if (mMThumbPlayerTextureView != null) {
            mMThumbPlayerTextureView.setAlpha(1.0f);
            AppMethodBeat.o(238802);
            return;
        }
        AppMethodBeat.o(238802);
    }
}
