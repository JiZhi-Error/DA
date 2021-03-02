package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.i;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020\fJ\u0006\u00107\u001a\u00020\u000eJ\b\u00108\u001a\u00020\u001aH\u0002J\u0006\u00109\u001a\u00020\u001aJ\u000e\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020<J\u0016\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020<2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010=\u001a\u00020\u001a2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019J\u000e\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u000205J\u000e\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u000eJ\u000e\u0010B\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u000eJ\u0010\u0010C\u001a\u00020\u001a2\b\u0010D\u001a\u0004\u0018\u00010-J\u000e\u0010E\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010F\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010G\u001a\u00020\u000eJ\u0006\u0010H\u001a\u00020\u001aR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "TAG", "", "afterSeekPlay", "", "callback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "isMute", "isOnlineVideo", "isPrepared", "isRemoveBg", "lastSurfaceUpdatedTime", "", "needReset", "onDrawCallback", "Lkotlin/Function0;", "", "onSurfaceCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "openWithNoneSurface", "path", "pauseByDestroyed", "pauseWhenUpdated", "player", "Lcom/tencent/mm/plugin/mmplayer/VideoPlayer;", "playerCallback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "removeBgEnable", "renderSurface", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureRenderSurface;", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "seekCompleteCallback", "Lkotlin/Function1;", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "surface", "Landroid/view/Surface;", "useMp4Extrator", "videoHeight", "videoWidth", "getDuration", "getPlayRate", "", "getVideoPath", "isPlaying", "openVideo", "pause", "seekTo", "time", "", "setOnDrawCallback", "setPlayRate", "rate", "setRemoveBackground", "remove", "setRemoveBgEnable", "setSticker", "pack", "setVideoCallback", "setVideoPath", "start", "stop", "plugin-emojicapture_release"})
public final class EmojiVideoPlayTextureView extends MMTextureView {
    private final String TAG = "MicroMsg.EmojiVideoPlayTextureView";
    private boolean ZA;
    private long mEm;
    private boolean mEn;
    private boolean mEo;
    private String path = "";
    private boolean rpL;
    private com.tencent.mm.sticker.f rpM;
    private kotlin.g.a.a<x> rrO;
    private final com.tencent.mm.plugin.emojicapture.ui.b.e rsj = new com.tencent.mm.plugin.emojicapture.ui.b.e();
    private final a rsk = new a(this.rsj);
    public j rsl;
    public boolean rsm = true;
    private boolean rsn;
    private j.a rso;
    private kotlin.g.a.b<? super Boolean, x> rsp;
    private j.d rsq;
    private boolean rsr;
    private boolean rss;
    private boolean rst;
    private boolean rsu = true;
    private com.tencent.mm.plugin.n.d rsv;
    private Surface surface;
    private int videoHeight;
    private int videoWidth;

    public static final /* synthetic */ void g(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
        AppMethodBeat.i(508);
        emojiVideoPlayTextureView.bLd();
        AppMethodBeat.o(508);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(505);
        setSurfaceTextureListener(this.rsk);
        setOpaque(false);
        this.rsk.iqw = new kotlin.g.a.b<SurfaceTexture, x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView.AnonymousClass1 */
            final /* synthetic */ EmojiVideoPlayTextureView rsw;

            {
                this.rsw = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(n.CTRL_INDEX);
                SurfaceTexture surfaceTexture2 = surfaceTexture;
                Log.i(this.rsw.TAG, "previewCallback: ".concat(String.valueOf(surfaceTexture2)));
                this.rsw.surface = new Surface(surfaceTexture2);
                if (this.rsw.rsl == null || !this.rsw.ZA) {
                    EmojiVideoPlayTextureView.g(this.rsw);
                } else {
                    com.tencent.mm.plugin.n.j jVar = this.rsw.rsl;
                    if (jVar != null) {
                        jVar.i(this.rsw.surface);
                    }
                    if (this.rsw.mEn) {
                        com.tencent.mm.plugin.n.j jVar2 = this.rsw.rsl;
                        if (jVar2 != null) {
                            jVar2.start();
                        }
                    } else {
                        this.rsw.mEo = true;
                        this.rsw.mEm = 0;
                        com.tencent.mm.plugin.n.j jVar3 = this.rsw.rsl;
                        if (jVar3 != null) {
                            jVar3.setMute(true);
                        }
                        com.tencent.mm.plugin.n.j jVar4 = this.rsw.rsl;
                        if (jVar4 != null) {
                            jVar4.start();
                        }
                    }
                    this.rsw.mEn = false;
                }
                j.d dVar = this.rsw.rsq;
                if (dVar != null) {
                    dVar.bgX();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(n.CTRL_INDEX);
                return xVar;
            }
        };
        this.rsk.rrO = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView.AnonymousClass2 */
            final /* synthetic */ EmojiVideoPlayTextureView rsw;

            {
                this.rsw = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.video.d.b.CTRL_INDEX);
                kotlin.g.a.a aVar = this.rsw.rrO;
                if (aVar != null) {
                    aVar.invoke();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.video.d.b.CTRL_INDEX);
                return xVar;
            }
        };
        this.rsv = new b(this);
        AppMethodBeat.o(505);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiVideoPlayTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(506);
        setSurfaceTextureListener(this.rsk);
        setOpaque(false);
        this.rsk.iqw = new kotlin.g.a.b<SurfaceTexture, x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView.AnonymousClass1 */
            final /* synthetic */ EmojiVideoPlayTextureView rsw;

            {
                this.rsw = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(n.CTRL_INDEX);
                SurfaceTexture surfaceTexture2 = surfaceTexture;
                Log.i(this.rsw.TAG, "previewCallback: ".concat(String.valueOf(surfaceTexture2)));
                this.rsw.surface = new Surface(surfaceTexture2);
                if (this.rsw.rsl == null || !this.rsw.ZA) {
                    EmojiVideoPlayTextureView.g(this.rsw);
                } else {
                    com.tencent.mm.plugin.n.j jVar = this.rsw.rsl;
                    if (jVar != null) {
                        jVar.i(this.rsw.surface);
                    }
                    if (this.rsw.mEn) {
                        com.tencent.mm.plugin.n.j jVar2 = this.rsw.rsl;
                        if (jVar2 != null) {
                            jVar2.start();
                        }
                    } else {
                        this.rsw.mEo = true;
                        this.rsw.mEm = 0;
                        com.tencent.mm.plugin.n.j jVar3 = this.rsw.rsl;
                        if (jVar3 != null) {
                            jVar3.setMute(true);
                        }
                        com.tencent.mm.plugin.n.j jVar4 = this.rsw.rsl;
                        if (jVar4 != null) {
                            jVar4.start();
                        }
                    }
                    this.rsw.mEn = false;
                }
                j.d dVar = this.rsw.rsq;
                if (dVar != null) {
                    dVar.bgX();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(n.CTRL_INDEX);
                return xVar;
            }
        };
        this.rsk.rrO = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView.AnonymousClass2 */
            final /* synthetic */ EmojiVideoPlayTextureView rsw;

            {
                this.rsw = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.video.d.b.CTRL_INDEX);
                kotlin.g.a.a aVar = this.rsw.rrO;
                if (aVar != null) {
                    aVar.invoke();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.video.d.b.CTRL_INDEX);
                return xVar;
            }
        };
        this.rsv = new b(this);
        AppMethodBeat.o(506);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiVideoPlayTextureView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(507);
        setSurfaceTextureListener(this.rsk);
        setOpaque(false);
        this.rsk.iqw = new kotlin.g.a.b<SurfaceTexture, x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView.AnonymousClass1 */
            final /* synthetic */ EmojiVideoPlayTextureView rsw;

            {
                this.rsw = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(n.CTRL_INDEX);
                SurfaceTexture surfaceTexture2 = surfaceTexture;
                Log.i(this.rsw.TAG, "previewCallback: ".concat(String.valueOf(surfaceTexture2)));
                this.rsw.surface = new Surface(surfaceTexture2);
                if (this.rsw.rsl == null || !this.rsw.ZA) {
                    EmojiVideoPlayTextureView.g(this.rsw);
                } else {
                    com.tencent.mm.plugin.n.j jVar = this.rsw.rsl;
                    if (jVar != null) {
                        jVar.i(this.rsw.surface);
                    }
                    if (this.rsw.mEn) {
                        com.tencent.mm.plugin.n.j jVar2 = this.rsw.rsl;
                        if (jVar2 != null) {
                            jVar2.start();
                        }
                    } else {
                        this.rsw.mEo = true;
                        this.rsw.mEm = 0;
                        com.tencent.mm.plugin.n.j jVar3 = this.rsw.rsl;
                        if (jVar3 != null) {
                            jVar3.setMute(true);
                        }
                        com.tencent.mm.plugin.n.j jVar4 = this.rsw.rsl;
                        if (jVar4 != null) {
                            jVar4.start();
                        }
                    }
                    this.rsw.mEn = false;
                }
                j.d dVar = this.rsw.rsq;
                if (dVar != null) {
                    dVar.bgX();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(n.CTRL_INDEX);
                return xVar;
            }
        };
        this.rsk.rrO = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView.AnonymousClass2 */
            final /* synthetic */ EmojiVideoPlayTextureView rsw;

            {
                this.rsw = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.video.d.b.CTRL_INDEX);
                kotlin.g.a.a aVar = this.rsw.rrO;
                if (aVar != null) {
                    aVar.invoke();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.video.d.b.CTRL_INDEX);
                return xVar;
            }
        };
        this.rsv = new b(this);
        AppMethodBeat.o(507);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(FacebookRequestErrorClassification.ESC_APP_INACTIVE);
        if (!(this.rsl instanceof com.tencent.mm.plugin.n.j) || this.rsl == null) {
            AppMethodBeat.o(FacebookRequestErrorClassification.ESC_APP_INACTIVE);
            return false;
        }
        com.tencent.mm.plugin.n.j jVar = this.rsl;
        if (jVar == null) {
            p.hyc();
        }
        boolean isPlaying = jVar.isPlaying();
        AppMethodBeat.o(FacebookRequestErrorClassification.ESC_APP_INACTIVE);
        return isPlaying;
    }

    public final void setVideoPath(String str) {
        AppMethodBeat.i(494);
        p.h(str, "path");
        Log.i(this.TAG, "%d set video path [%s]", Integer.valueOf(hashCode()), str);
        this.path = str;
        bLd();
        requestLayout();
        AppMethodBeat.o(494);
    }

    public final String getVideoPath() {
        return this.path;
    }

    public final void setVideoCallback(j.a aVar) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.CTRL_INDEX);
        p.h(aVar, "callback");
        this.rso = aVar;
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.CTRL_INDEX);
    }

    public final void setOnDrawCallback(kotlin.g.a.a<x> aVar) {
        this.rrO = aVar;
    }

    public final void setPlayRate(float f2) {
        AppMethodBeat.i(m.CTRL_INDEX);
        com.tencent.mm.plugin.n.j jVar = this.rsl;
        if (jVar != null) {
            jVar.setPlayRate(f2);
            AppMethodBeat.o(m.CTRL_INDEX);
            return;
        }
        AppMethodBeat.o(m.CTRL_INDEX);
    }

    public final void setRemoveBgEnable(boolean z) {
        this.rsu = z;
    }

    public final void setRemoveBackground(boolean z) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX);
        this.rpL = z;
        this.rsk.j(new c(this, z));
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX);
    }

    public final void setSticker(com.tencent.mm.sticker.f fVar) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX);
        this.rpM = fVar;
        this.rsk.j(new d(this, fVar));
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX);
    }

    public final float getPlayRate() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.storage.j.CTRL_INDEX);
        if (this.rsl != null) {
            com.tencent.mm.plugin.n.j jVar = this.rsl;
            if (jVar == null) {
                p.hyc();
            }
            float playRate = jVar.getPlayRate();
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.storage.j.CTRL_INDEX);
            return playRate;
        }
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.storage.j.CTRL_INDEX);
        return 1.0f;
    }

    private final void bLd() {
        com.tencent.mm.plugin.n.j jVar;
        AppMethodBeat.i(500);
        Log.i(this.TAG, "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        if (this.rsl != null) {
            com.tencent.mm.plugin.n.j jVar2 = this.rsl;
            if (jVar2 != null) {
                jVar2.a(null);
            }
            com.tencent.mm.plugin.n.j jVar3 = this.rsl;
            if (jVar3 != null) {
                jVar3.stop();
            }
            com.tencent.mm.plugin.n.j jVar4 = this.rsl;
            if (jVar4 != null) {
                jVar4.release();
            }
            this.rsl = null;
        }
        if (Util.isNullOrNil(this.path) || this.surface == null) {
            Log.w(this.TAG, "%d open video but path is null or mSurface is null", Integer.valueOf(hashCode()));
            AppMethodBeat.o(500);
            return;
        }
        try {
            this.ZA = false;
            this.rsl = new com.tencent.mm.plugin.n.j(Looper.getMainLooper());
            com.tencent.mm.plugin.n.j jVar5 = this.rsl;
            if (jVar5 != null) {
                jVar5.setPath(this.path);
            }
            com.tencent.mm.plugin.n.j jVar6 = this.rsl;
            if (jVar6 != null) {
                jVar6.setNeedResetExtractor(this.rsr);
            }
            com.tencent.mm.plugin.n.j jVar7 = this.rsl;
            if (jVar7 != null) {
                jVar7.setIsOnlineVideoType(this.rss);
            }
            com.tencent.mm.plugin.n.j jVar8 = this.rsl;
            if (jVar8 != null) {
                jVar8.a(this.rsv);
            }
            com.tencent.mm.plugin.n.j jVar9 = this.rsl;
            if (jVar9 != null) {
                jVar9.setSurface(this.surface);
            }
            com.tencent.mm.plugin.n.j jVar10 = this.rsl;
            if (jVar10 != null) {
                jVar10.ra(this.rst);
            }
            com.tencent.mm.plugin.n.j jVar11 = this.rsl;
            if (jVar11 != null) {
                jVar11.setMute(true);
            }
            if (this.surface != null) {
                com.tencent.mm.plugin.n.j jVar12 = this.rsl;
                if (jVar12 != null) {
                    jVar12.prepare();
                    AppMethodBeat.o(500);
                    return;
                }
                AppMethodBeat.o(500);
            } else if (!this.rsn || (jVar = this.rsl) == null) {
                AppMethodBeat.o(500);
            } else {
                jVar.prepare();
                AppMethodBeat.o(500);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "prepare async error %s", e2.getMessage());
            j.a aVar = this.rso;
            if (aVar != null) {
                aVar.onError(-1, -1);
                AppMethodBeat.o(500);
                return;
            }
            AppMethodBeat.o(500);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView$playerCallback$1", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "onCompletion", "", "onError", "what", "", "error", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "width", "height", "degrees", "plugin-emojicapture_release"})
    public static final class b implements com.tencent.mm.plugin.n.d {
        final /* synthetic */ EmojiVideoPlayTextureView rsw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
            this.rsw = emojiVideoPlayTextureView;
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void tf() {
            AppMethodBeat.i(484);
            Log.i(this.rsw.TAG, "onPrepared: ");
            this.rsw.ZA = true;
            j.a aVar = this.rsw.rso;
            if (aVar != null) {
                aVar.tf();
            }
            this.rsw.requestLayout();
            AppMethodBeat.o(484);
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void onCompletion() {
            AppMethodBeat.i(485);
            j.a aVar = this.rsw.rso;
            if (aVar != null) {
                aVar.onCompletion();
                AppMethodBeat.o(485);
                return;
            }
            AppMethodBeat.o(485);
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void onError(int i2, int i3) {
            AppMethodBeat.i(486);
            j.a aVar = this.rsw.rso;
            if (aVar != null) {
                aVar.onError(i2, i3);
                AppMethodBeat.o(486);
                return;
            }
            AppMethodBeat.o(486);
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void cJH() {
            AppMethodBeat.i(487);
            kotlin.g.a.b bVar = this.rsw.rsp;
            if (bVar != null) {
                bVar.invoke(Boolean.valueOf(this.rsw.rsm));
            }
            if (!this.rsw.rsm) {
                Log.d(this.rsw.TAG, "player seek done, but don't play now.");
                this.rsw.rsm = true;
                AppMethodBeat.o(487);
                return;
            }
            String str = this.rsw.TAG;
            Object[] objArr = new Object[1];
            com.tencent.mm.plugin.n.j jVar = this.rsw.rsl;
            objArr[0] = jVar != null ? jVar.info() : null;
            Log.d(str, "%s player seek done", objArr);
            com.tencent.mm.plugin.n.j jVar2 = this.rsw.rsl;
            if (jVar2 != null) {
                jVar2.start();
                AppMethodBeat.o(487);
                return;
            }
            AppMethodBeat.o(487);
        }

        @Override // com.tencent.mm.plugin.n.d
        public final void aa(int i2, int i3, int i4) {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.y.f.CTRL_INDEX);
            Log.i(this.rsw.TAG, "video size changed size[%d, %d] degrees[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            this.rsw.videoWidth = i2;
            this.rsw.videoHeight = i3;
            this.rsw.rsk.rrP.cZ(i2, i3);
            j.a aVar = this.rsw.rso;
            if (aVar != null) {
                aVar.eo(this.rsw.videoWidth, this.rsw.videoHeight);
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.y.f.CTRL_INDEX);
                return;
            }
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.y.f.CTRL_INDEX);
        }
    }

    public final boolean start() {
        boolean z;
        AppMethodBeat.i(501);
        if (this.rsl == null || !this.ZA) {
            String str = this.TAG;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            if (this.rsl == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(this.ZA);
            Log.w(str, "%d player is null[%b] or it prepared [%b]", objArr);
            AppMethodBeat.o(501);
            return false;
        }
        String str2 = this.TAG;
        Object[] objArr2 = new Object[4];
        objArr2[0] = Integer.valueOf(hashCode());
        objArr2[1] = Boolean.valueOf(this.mEo);
        objArr2[2] = Boolean.valueOf(this.mEn);
        objArr2[3] = Boolean.valueOf(this.surface != null);
        Log.i(str2, "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", objArr2);
        if (this.surface == null) {
            this.mEn = true;
            AppMethodBeat.o(501);
            return true;
        } else if (this.mEo) {
            this.mEn = true;
            this.mEo = false;
            AppMethodBeat.o(501);
            return true;
        } else {
            com.tencent.mm.plugin.n.j jVar = this.rsl;
            if (jVar != null) {
                jVar.start();
            }
            this.rsk.j(new e(this));
            AppMethodBeat.o(501);
            return true;
        }
    }

    public final void stop() {
        AppMethodBeat.i(502);
        Log.i(this.TAG, "%d player stop [%s]", Integer.valueOf(hashCode()), Util.getStack());
        com.tencent.mm.plugin.n.j jVar = this.rsl;
        if (jVar != null) {
            jVar.a(null);
        }
        com.tencent.mm.plugin.n.j jVar2 = this.rsl;
        if (jVar2 != null) {
            jVar2.stop();
        }
        com.tencent.mm.plugin.n.j jVar3 = this.rsl;
        if (jVar3 != null) {
            jVar3.release();
        }
        this.rsk.j(new f(this));
        this.rsl = null;
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.ZA = false;
        this.path = "";
        this.mEm = 0;
        setSurfaceTextureListener(null);
        AppMethodBeat.o(502);
    }

    public final void pause() {
        AppMethodBeat.i(503);
        if (this.rsl != null) {
            com.tencent.mm.plugin.n.j jVar = this.rsl;
            if (jVar == null) {
                p.hyc();
            }
            if (jVar.isPlaying()) {
                com.tencent.mm.plugin.n.j jVar2 = this.rsl;
                if (jVar2 != null) {
                    jVar2.pause();
                }
                this.rsk.j(new a(this));
            }
        }
        this.mEn = false;
        AppMethodBeat.o(503);
    }

    public final int getDuration() {
        AppMethodBeat.i(504);
        if (this.rsl != null) {
            com.tencent.mm.plugin.n.j jVar = this.rsl;
            if (jVar == null) {
                p.hyc();
            }
            int durationMs = (int) jVar.getDurationMs();
            AppMethodBeat.o(504);
            return durationMs;
        }
        AppMethodBeat.o(504);
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiVideoPlayTextureView rsw;
        final /* synthetic */ boolean rsx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(EmojiVideoPlayTextureView emojiVideoPlayTextureView, boolean z) {
            super(0);
            this.rsw = emojiVideoPlayTextureView;
            this.rsx = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(489);
            this.rsw.rsj.lF(this.rsx);
            x xVar = x.SXb;
            AppMethodBeat.o(489);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiVideoPlayTextureView rsw;
        final /* synthetic */ com.tencent.mm.sticker.f rsy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(EmojiVideoPlayTextureView emojiVideoPlayTextureView, com.tencent.mm.sticker.f fVar) {
            super(0);
            this.rsw = emojiVideoPlayTextureView;
            this.rsy = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(490);
            this.rsw.rsj.a(this.rsy);
            x xVar = x.SXb;
            AppMethodBeat.o(490);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiVideoPlayTextureView rsw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
            super(0);
            this.rsw = emojiVideoPlayTextureView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.y.d.CTRL_INDEX);
            this.rsw.rsj.aEb();
            x xVar = x.SXb;
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.y.d.CTRL_INDEX);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiVideoPlayTextureView rsw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
            super(0);
            this.rsw = emojiVideoPlayTextureView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(i.CTRL_INDEX);
            this.rsw.rsj.aEa();
            x xVar = x.SXb;
            AppMethodBeat.o(i.CTRL_INDEX);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiVideoPlayTextureView rsw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(EmojiVideoPlayTextureView emojiVideoPlayTextureView) {
            super(0);
            this.rsw = emojiVideoPlayTextureView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(483);
            this.rsw.rsj.aEa();
            x xVar = x.SXb;
            AppMethodBeat.o(483);
            return xVar;
        }
    }
}
