package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Size;
import android.view.TextureView;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.core.AssetExtension;
import java.lang.reflect.Field;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\b\u0010=\u001a\u00020>H\u0014J\b\u0010?\u001a\u00020>H\u0016J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020\bH\u0016J\b\u0010C\u001a\u00020\u000fH\u0016J\b\u0010D\u001a\u00020\u000fH\u0016J\n\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020AH\u0002J\b\u0010H\u001a\u00020\bH\u0016J\b\u0010I\u001a\u00020AH\u0016J\n\u0010J\u001a\u0004\u0018\u00010,H\u0016J\n\u0010K\u001a\u0004\u0018\u00010.H\u0016J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020\u000fH\u0016J\u0006\u0010O\u001a\u00020>J\b\u0010P\u001a\u00020\u000fH\u0016J\b\u0010Q\u001a\u00020>H\u0014J\b\u0010R\u001a\u00020>H\u0014J\b\u0010S\u001a\u00020>H\u0016J\u0012\u0010T\u001a\u00020\u000f2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020>H\u0016J\b\u0010X\u001a\u00020\u000fH\u0016J\b\u0010Y\u001a\u00020\bH\u0016J\b\u0010Z\u001a\u00020\u000fH\u0016J\b\u0010[\u001a\u00020\u000fH\u0016J\b\u0010\\\u001a\u00020>H\u0016J\u000e\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020_J\u0018\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000fH\u0016J\u0016\u0010]\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\u000fJ\u0012\u0010c\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0010\u0010f\u001a\u00020>2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010g\u001a\u00020>2\u0006\u0010h\u001a\u00020iH\u0016J\u0010\u0010j\u001a\u00020>2\u0006\u0010k\u001a\u00020\u000fH\u0016J\u0010\u0010l\u001a\u00020>2\u0006\u0010m\u001a\u00020\u000fH\u0016J\u0010\u0010n\u001a\u00020>2\u0006\u0010o\u001a\u00020\u000fH\u0016J\u0010\u0010p\u001a\u00020>2\u0006\u0010q\u001a\u00020\u000fH\u0016J\u0010\u0010r\u001a\u00020>2\u0006\u0010s\u001a\u00020\u000fH\u0016J\u0010\u0010t\u001a\u00020>2\u0006\u0010u\u001a\u00020vH\u0016J \u0010w\u001a\u00020>2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u000f2\u0006\u0010{\u001a\u00020|H\u0016J\u0010\u0010}\u001a\u00020>2\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010~\u001a\u00020>2\u0006\u0010%\u001a\u00020&H\u0016J\u0011\u0010\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u0001\u001a\u00020>2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u0001\u001a\u00020>H\u0016J\u0007\u0010\u0001\u001a\u00020>R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001a\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001a\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001a\u0010#\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "finderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "isFirstTimeStarted", "isInterceptedDetach", "setInterceptedDetach", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isShowFullscreen", "setShowFullscreen", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "originLayer", "", "originSurface", "sessionId", "createPlayer", "", "destroyDrawingCache", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayStart", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "hookInnerDetach", "isPreviewing", "onAttachedToWindow", "onDetachedFromWindow", "onRelease", "onSurfaceTextureDestroyed", "surface", "Landroid/graphics/SurfaceTexture;", "onUIDestroy", "pause", "pauseWithCancel", AssetExtension.SCENE_PLAY, "prepareToPlay", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "startOrPlay", "stop", "unHookInnerDetach", "Companion", "plugin-finder_release"})
public final class FinderVLogCompositionPlayView extends VideoCompositionPlayView implements r {
    public static final a wex = new a((byte) 0);
    private String mediaId = String.valueOf(hashCode());
    private String sessionId = String.valueOf(hashCode());
    private boolean uOq;
    private c wbj;
    private boolean wcA = true;
    private boolean wcB;
    private volatile boolean wcC = true;
    private y wcw;
    private s wcy;
    private boolean weo;
    private t wep;
    private i.b weq;
    private cjl wer;
    private boolean wes = true;
    private EffectManager wet;
    private boolean weu;
    private Object wev;
    private Object wew;

    static {
        AppMethodBeat.i(254244);
        AppMethodBeat.o(254244);
    }

    public static final /* synthetic */ long g(FinderVLogCompositionPlayView finderVLogCompositionPlayView) {
        AppMethodBeat.i(254245);
        long playStart = finderVLogCompositionPlayView.getPlayStart();
        AppMethodBeat.o(254245);
        return playStart;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderVLogCompositionPlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(254241);
        setPlayerCallback(new a.C2159a.AbstractC2160a(this) {
            /* class com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView.AnonymousClass1 */
            private long wem = -1;
            final /* synthetic */ FinderVLogCompositionPlayView wey;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wey = r3;
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dER() {
                y lifecycle;
                AppMethodBeat.i(254208);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.dK(this.wey.sessionId, this.wey.mediaId);
                }
                if (this.wey.wes || !this.wey.loop) {
                    y lifecycle2 = this.wey.getLifecycle();
                    if (lifecycle2 != null) {
                        cjl unused = this.wey.wer;
                        lifecycle2.dFN();
                    }
                } else if (this.wey.loop && (lifecycle = this.wey.getLifecycle()) != null) {
                    cjl unused2 = this.wey.wer;
                    lifecycle.dFM();
                }
                this.wey.wes = false;
                AppMethodBeat.o(254208);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dES() {
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dET() {
                AppMethodBeat.i(254209);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.dI(this.wey.sessionId, this.wey.mediaId);
                    AppMethodBeat.o(254209);
                    return;
                }
                AppMethodBeat.o(254209);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void Go(long j2) {
                AppMethodBeat.i(254210);
                y lifecycle = this.wey.getLifecycle();
                if (lifecycle != null) {
                    cjl unused = this.wey.wer;
                    FinderVLogCompositionPlayView.g(this.wey);
                    this.wey.getVideoDurationMs();
                    lifecycle.dFO();
                }
                if (this.wem == -1 || j2 - this.wem > 1000) {
                    y lifecycle2 = this.wey.getLifecycle();
                    if (lifecycle2 != null) {
                        lifecycle2.a(this.wey.wer, (int) ((j2 - FinderVLogCompositionPlayView.g(this.wey)) / 1000), this.wey.getVideoDuration());
                    }
                    this.wem = j2;
                }
                AppMethodBeat.o(254210);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dEU() {
                AppMethodBeat.i(254211);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.fo(this.wey.sessionId, this.wey.mediaId);
                }
                y lifecycle = this.wey.getLifecycle();
                if (lifecycle != null) {
                    cjl unused = this.wey.wer;
                    lifecycle.Gr(0);
                    AppMethodBeat.o(254211);
                    return;
                }
                AppMethodBeat.o(254211);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dEV() {
                AppMethodBeat.i(254212);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.c(this.wey.sessionId, this.wey.mediaId, "", -1, -1);
                    AppMethodBeat.o(254212);
                    return;
                }
                AppMethodBeat.o(254212);
            }
        });
        AppMethodBeat.o(254241);
    }

    public FinderVLogCompositionPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(254242);
        setPlayerCallback(new a.C2159a.AbstractC2160a(this) {
            /* class com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView.AnonymousClass1 */
            private long wem = -1;
            final /* synthetic */ FinderVLogCompositionPlayView wey;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wey = r3;
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dER() {
                y lifecycle;
                AppMethodBeat.i(254208);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.dK(this.wey.sessionId, this.wey.mediaId);
                }
                if (this.wey.wes || !this.wey.loop) {
                    y lifecycle2 = this.wey.getLifecycle();
                    if (lifecycle2 != null) {
                        cjl unused = this.wey.wer;
                        lifecycle2.dFN();
                    }
                } else if (this.wey.loop && (lifecycle = this.wey.getLifecycle()) != null) {
                    cjl unused2 = this.wey.wer;
                    lifecycle.dFM();
                }
                this.wey.wes = false;
                AppMethodBeat.o(254208);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dES() {
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dET() {
                AppMethodBeat.i(254209);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.dI(this.wey.sessionId, this.wey.mediaId);
                    AppMethodBeat.o(254209);
                    return;
                }
                AppMethodBeat.o(254209);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void Go(long j2) {
                AppMethodBeat.i(254210);
                y lifecycle = this.wey.getLifecycle();
                if (lifecycle != null) {
                    cjl unused = this.wey.wer;
                    FinderVLogCompositionPlayView.g(this.wey);
                    this.wey.getVideoDurationMs();
                    lifecycle.dFO();
                }
                if (this.wem == -1 || j2 - this.wem > 1000) {
                    y lifecycle2 = this.wey.getLifecycle();
                    if (lifecycle2 != null) {
                        lifecycle2.a(this.wey.wer, (int) ((j2 - FinderVLogCompositionPlayView.g(this.wey)) / 1000), this.wey.getVideoDuration());
                    }
                    this.wem = j2;
                }
                AppMethodBeat.o(254210);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dEU() {
                AppMethodBeat.i(254211);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.fo(this.wey.sessionId, this.wey.mediaId);
                }
                y lifecycle = this.wey.getLifecycle();
                if (lifecycle != null) {
                    cjl unused = this.wey.wer;
                    lifecycle.Gr(0);
                    AppMethodBeat.o(254211);
                    return;
                }
                AppMethodBeat.o(254211);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dEV() {
                AppMethodBeat.i(254212);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.c(this.wey.sessionId, this.wey.mediaId, "", -1, -1);
                    AppMethodBeat.o(254212);
                    return;
                }
                AppMethodBeat.o(254212);
            }
        });
        AppMethodBeat.o(254242);
    }

    public FinderVLogCompositionPlayView(Context context) {
        super(context);
        AppMethodBeat.i(254243);
        setPlayerCallback(new a.C2159a.AbstractC2160a(this) {
            /* class com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView.AnonymousClass1 */
            private long wem = -1;
            final /* synthetic */ FinderVLogCompositionPlayView wey;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wey = r3;
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dER() {
                y lifecycle;
                AppMethodBeat.i(254208);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.dK(this.wey.sessionId, this.wey.mediaId);
                }
                if (this.wey.wes || !this.wey.loop) {
                    y lifecycle2 = this.wey.getLifecycle();
                    if (lifecycle2 != null) {
                        cjl unused = this.wey.wer;
                        lifecycle2.dFN();
                    }
                } else if (this.wey.loop && (lifecycle = this.wey.getLifecycle()) != null) {
                    cjl unused2 = this.wey.wer;
                    lifecycle.dFM();
                }
                this.wey.wes = false;
                AppMethodBeat.o(254208);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dES() {
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dET() {
                AppMethodBeat.i(254209);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.dI(this.wey.sessionId, this.wey.mediaId);
                    AppMethodBeat.o(254209);
                    return;
                }
                AppMethodBeat.o(254209);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void Go(long j2) {
                AppMethodBeat.i(254210);
                y lifecycle = this.wey.getLifecycle();
                if (lifecycle != null) {
                    cjl unused = this.wey.wer;
                    FinderVLogCompositionPlayView.g(this.wey);
                    this.wey.getVideoDurationMs();
                    lifecycle.dFO();
                }
                if (this.wem == -1 || j2 - this.wem > 1000) {
                    y lifecycle2 = this.wey.getLifecycle();
                    if (lifecycle2 != null) {
                        lifecycle2.a(this.wey.wer, (int) ((j2 - FinderVLogCompositionPlayView.g(this.wey)) / 1000), this.wey.getVideoDuration());
                    }
                    this.wem = j2;
                }
                AppMethodBeat.o(254210);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dEU() {
                AppMethodBeat.i(254211);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.fo(this.wey.sessionId, this.wey.mediaId);
                }
                y lifecycle = this.wey.getLifecycle();
                if (lifecycle != null) {
                    cjl unused = this.wey.wer;
                    lifecycle.Gr(0);
                    AppMethodBeat.o(254211);
                    return;
                }
                AppMethodBeat.o(254211);
            }

            @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
            public final void dEV() {
                AppMethodBeat.i(254212);
                i.b bVar = this.wey.weq;
                if (bVar != null) {
                    bVar.c(this.wey.sessionId, this.wey.mediaId, "", -1, -1);
                    AppMethodBeat.o(254212);
                    return;
                }
                AppMethodBeat.o(254212);
            }
        });
        AppMethodBeat.o(254243);
    }

    public final s getMediaInfo() {
        return this.wcy;
    }

    public final void setMediaInfo(s sVar) {
        this.wcy = sVar;
    }

    public final void setViewFocused(boolean z) {
        this.wcA = z;
    }

    public final void setShouldPlayResume(boolean z) {
        this.wcB = z;
    }

    public final boolean get_isPreviewing() {
        return this.weo;
    }

    public final void set_isPreviewing(boolean z) {
        this.weo = z;
    }

    public final void setNeverStart(boolean z) {
        this.wcC = z;
    }

    public final t getMuteListener() {
        return this.wep;
    }

    public final void setMuteListener(t tVar) {
        this.wep = tVar;
    }

    public final y getLifecycle() {
        return this.wcw;
    }

    public final void setLifecycle(y yVar) {
        this.wcw = yVar;
    }

    public final void setShowFullscreen(boolean z) {
        this.uOq = z;
    }

    @Override // com.tencent.mm.videocomposition.play.VideoCompositionPlayView
    public final void dFu() {
        AppMethodBeat.i(254213);
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " createPlayer");
        super.dFu();
        i.b bVar = this.weq;
        if (bVar != null) {
            bVar.dH(this.sessionId, this.mediaId);
        }
        n composition = getComposition();
        Size hfq = composition != null ? composition.hfq() : null;
        if (hfq != null) {
            i.b bVar2 = this.weq;
            if (bVar2 != null) {
                bVar2.d(this.sessionId, this.mediaId, hfq.getWidth(), hfq.getHeight());
                AppMethodBeat.o(254213);
                return;
            }
            AppMethodBeat.o(254213);
            return;
        }
        AppMethodBeat.o(254213);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dEN() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int dFk() {
        AppMethodBeat.i(254214);
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pauseWithCancel");
        this.wcy = null;
        super.pause();
        AppMethodBeat.o(254214);
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.r, com.tencent.mm.videocomposition.play.VideoCompositionPlayView
    public final boolean pause() {
        AppMethodBeat.i(254215);
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pause");
        boolean pause = super.pause();
        i.b bVar = this.weq;
        if (bVar != null) {
            bVar.dJ(this.sessionId, this.mediaId);
        }
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.dFL();
        }
        AppMethodBeat.o(254215);
        return pause;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setFinderVideoCore(k kVar) {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int getCurrentPlaySecond() {
        AppMethodBeat.i(254216);
        com.tencent.mm.videocomposition.play.a player = getPlayer();
        int hfu = ((int) ((player != null ? player.hfu() : 0) - getPlayStart())) / 1000;
        AppMethodBeat.o(254216);
        return hfu;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final long getCurrentPlayMs() {
        AppMethodBeat.i(254217);
        com.tencent.mm.videocomposition.play.a player = getPlayer();
        long hfu = (player != null ? player.hfu() : 0) - getPlayStart();
        AppMethodBeat.o(254217);
        return hfu;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int getVideoDuration() {
        AppMethodBeat.i(254218);
        n composition = getComposition();
        int durationMs = ((int) (composition != null ? composition.getDurationMs() : 0)) / 1000;
        AppMethodBeat.o(254218);
        return durationMs;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final long getVideoDurationMs() {
        AppMethodBeat.i(254219);
        n composition = getComposition();
        if (composition != null) {
            long durationMs = composition.getDurationMs();
            AppMethodBeat.o(254219);
            return durationMs;
        }
        AppMethodBeat.o(254219);
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getVideoViewFocused() {
        return this.wcA;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final View getVideoView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getIsShouldPlayResume() {
        return this.wcB;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getIsNeverStart() {
        return this.wcC;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final ViewParent getParentView() {
        AppMethodBeat.i(254220);
        ViewParent parent = getParent();
        AppMethodBeat.o(254220);
        return parent;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIsShouldPlayResume(boolean z) {
        this.wcB = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoViewFocused(boolean z) {
        this.wcA = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setPreview(boolean z) {
        this.weo = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dEO() {
        return this.weo;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setInterceptDetach(boolean z) {
        this.weu = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean play() {
        com.tencent.mm.videocomposition.play.a player;
        AppMethodBeat.i(254221);
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " play");
        if (!this.isStarted && (player = getPlayer()) != null) {
            player.start();
        }
        i.b bVar = this.weq;
        if (bVar != null) {
            bVar.dK(this.sessionId, this.mediaId);
        }
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.dFN();
        }
        AppMethodBeat.o(254221);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setMute(boolean z) {
        AppMethodBeat.i(254222);
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  setMute:" + z);
        super.DB(z);
        AppMethodBeat.o(254222);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void onUIDestroy() {
        AppMethodBeat.i(254223);
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " onUIDestroy");
        this.wcA = false;
        release();
        c cVar = this.wbj;
        if (cVar != null) {
            cVar.destroy();
        }
        EffectManager effectManager = this.wet;
        if (effectManager != null) {
            effectManager.destroy();
            AppMethodBeat.o(254223);
            return;
        }
        AppMethodBeat.o(254223);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void onRelease() {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dFj() {
        cjl cjl;
        aty aty = null;
        AppMethodBeat.i(254224);
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " startOrPlay, " + this.isStarted + ", " + isPlaying());
        boolean z = this.wcC;
        if (!this.isStarted) {
            setFirstFrame(true);
        }
        if (getComposition() == null) {
            c cVar = this.wbj;
            if (cVar != null) {
                cVar.destroy();
            }
            this.wbj = null;
            EffectManager effectManager = this.wet;
            if (effectManager != null) {
                effectManager.destroy();
            }
            this.wet = null;
            cjl cjl2 = this.wer;
            acn acn = cjl2 != null ? cjl2.MfU : null;
            if (acn != null) {
                this.wbj = com.tencent.mm.plugin.vlog.model.i.d(acn);
                c cVar2 = this.wbj;
                if (cVar2 != null) {
                    cVar2.start();
                }
                EffectManager effectManager2 = new EffectManager();
                this.wet = effectManager2;
                ac d2 = com.tencent.mm.plugin.vlog.model.i.d(acn, effectManager2);
                s sVar = this.wcy;
                if (!(sVar == null || (cjl = sVar.wgl) == null)) {
                    aty = cjl.MoU;
                }
                if (aty != null && aty.right > aty.left && aty.bottom > aty.top) {
                    if (this.uOq) {
                        Size hfq = d2.Gez.hfq();
                        d2.q(new Rect(0, 0, hfq.getWidth(), hfq.getHeight()));
                    } else if (aty.right > aty.left && aty.bottom > aty.top) {
                        d2.q(new Rect((int) aty.left, (int) aty.top, (int) aty.right, (int) aty.bottom));
                    }
                }
                c cVar3 = this.wbj;
                if (cVar3 == null) {
                    p.hyc();
                }
                d2.O(cVar3);
                d2.acz(acn.Gxw.fps);
                a(d2.getComposition());
            }
        } else if (!isPlaying()) {
            resume();
        }
        AppMethodBeat.o(254224);
        return z;
    }

    @Override // com.tencent.mm.videocomposition.play.VideoCompositionPlayView
    public final void a(n nVar) {
        y yVar;
        AppMethodBeat.i(254225);
        p.h(nVar, "composition");
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " start");
        if (!this.wcA) {
            Log.w("MicroMsg.FinderVLogCompositionPlayView", "isViewFocused=" + this.wcA);
            AppMethodBeat.o(254225);
            return;
        }
        if (this.wcC && (yVar = this.wcw) != null) {
            yVar.a(this.wcy, 0);
        }
        if (!this.isStarted) {
            super.a(nVar);
        } else if (!isPlaying()) {
            super.resume();
        }
        this.wcC = false;
        AppMethodBeat.o(254225);
    }

    @Override // com.tencent.mm.plugin.finder.video.r, com.tencent.mm.videocomposition.play.VideoCompositionPlayView
    public final void stop() {
        AppMethodBeat.i(254226);
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " stop");
        super.stop();
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.b(this.wcy);
        }
        this.wcC = true;
        this.wes = true;
        this.wcA = false;
        AppMethodBeat.o(254226);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void a(s sVar, boolean z, FeedData feedData) {
        AppMethodBeat.i(254227);
        p.h(sVar, "video");
        p.h(feedData, "feedData");
        Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " setVideoMedia video:" + sVar + ", isLocal:" + z);
        this.wer = sVar.uIw;
        this.mediaId = sVar.auA();
        this.wcy = new s("", "", this.mediaId, this.wer, sVar, feedData);
        AppMethodBeat.o(254227);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final String getVideoMediaId() {
        s sVar = this.wcy;
        if (sVar != null) {
            return sVar.mediaId;
        }
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final s getVideoMediaInfo() {
        return this.wcy;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIMMVideoViewCallback(i.b bVar) {
        AppMethodBeat.i(254228);
        p.h(bVar, "_callback");
        this.weq = bVar;
        AppMethodBeat.o(254228);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setScaleType(i.e eVar) {
        AppMethodBeat.i(254229);
        p.h(eVar, "scaleType");
        AppMethodBeat.o(254229);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIOnlineVideoProxy(b bVar) {
        AppMethodBeat.i(254230);
        p.h(bVar, "_proxy");
        AppMethodBeat.o(254230);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void dFl() {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIsShowBasicControls(boolean z) {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoPlayLifecycle(y yVar) {
        AppMethodBeat.i(254231);
        p.h(yVar, "lifecycle");
        this.wcw = yVar;
        AppMethodBeat.o(254231);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoMuteListener(t tVar) {
        AppMethodBeat.i(254232);
        p.h(tVar, "muteListener");
        this.wep = tVar;
        AppMethodBeat.o(254232);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(254233);
        super.seekTo(((long) (1000.0d * d2)) + getPlayStart());
        if (z) {
            dFj();
        }
        AppMethodBeat.o(254233);
        return true;
    }

    @Override // com.tencent.mm.videocomposition.play.VideoCompositionPlayView
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(254234);
        c cVar = this.wbj;
        if (cVar != null) {
            cVar.destroy();
        }
        this.wbj = null;
        EffectManager effectManager = this.wet;
        if (effectManager != null) {
            effectManager.destroy();
        }
        this.wet = null;
        setComposition(null);
        boolean onSurfaceTextureDestroyed = super.onSurfaceTextureDestroyed(surfaceTexture);
        setPlayer(null);
        AppMethodBeat.o(254234);
        return onSurfaceTextureDestroyed;
    }

    private final long getPlayStart() {
        AppMethodBeat.i(254235);
        n composition = getComposition();
        if (composition != null) {
            long playStart = composition.getPlayStart();
            AppMethodBeat.o(254235);
            return playStart;
        }
        AppMethodBeat.o(254235);
        return 0;
    }

    public final void setInterceptedDetach(boolean z) {
        this.weu = z;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(254236);
        if (this.weu) {
            dFv();
            AppMethodBeat.o(254236);
            return;
        }
        try {
            super.onDetachedFromWindow();
            AppMethodBeat.o(254236);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", e2, "unkown error", new Object[0]);
            AppMethodBeat.o(254236);
        }
    }

    private void dFv() {
        AppMethodBeat.i(254237);
        try {
            Log.i("MicroMsg.FinderVLogCompositionPlayView", "hookInnerDetach");
            Field declaredField = TextureView.class.getDeclaredField("mLayer");
            p.g(declaredField, "TextureView::class.java.getDeclaredField(\"mLayer\")");
            declaredField.setAccessible(true);
            this.wev = declaredField.get(this);
            declaredField.set(this, null);
            Field declaredField2 = TextureView.class.getDeclaredField("mSurface");
            p.g(declaredField2, "TextureView::class.java.…DeclaredField(\"mSurface\")");
            declaredField2.setAccessible(true);
            this.wew = declaredField2.get(this);
            declaredField2.set(this, null);
            AppMethodBeat.o(254237);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", e2, "", new Object[0]);
            AppMethodBeat.o(254237);
        }
    }

    private void dFw() {
        AppMethodBeat.i(254238);
        try {
            Log.i("MicroMsg.FinderVLogCompositionPlayView", "unHookInnerDetach");
            if (this.wev != null) {
                Field declaredField = TextureView.class.getDeclaredField("mLayer");
                p.g(declaredField, "TextureView::class.java.getDeclaredField(\"mLayer\")");
                declaredField.setAccessible(true);
                declaredField.set(this, this.wev);
                this.wev = null;
            }
            if (this.wew != null) {
                Field declaredField2 = TextureView.class.getDeclaredField("mSurface");
                p.g(declaredField2, "TextureView::class.java.…DeclaredField(\"mSurface\")");
                declaredField2.setAccessible(true);
                declaredField2.set(this, this.wew);
                this.wew = null;
                AppMethodBeat.o(254238);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", e2, "", new Object[0]);
        }
        AppMethodBeat.o(254238);
    }

    public final void destroyDrawingCache() {
        AppMethodBeat.i(254239);
        super.destroyDrawingCache();
        if (this.weu) {
            dFw();
        }
        AppMethodBeat.o(254239);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(254240);
        if (this.weu) {
            dFv();
        }
        super.onAttachedToWindow();
        if (this.weu) {
            dFw();
        }
        AppMethodBeat.o(254240);
    }
}
