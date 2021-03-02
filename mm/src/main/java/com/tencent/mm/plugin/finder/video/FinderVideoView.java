package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.AssetExtension;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J \u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u0014J\u0010\u0010D\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u0012H\u0016J\u0012\u0010E\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010F\u001a\u00020GH\u0014J\b\u0010H\u001a\u00020IH\u0014J\u0012\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010M\u001a\u0004\u0018\u00010NJ\b\u0010O\u001a\u00020\u0012H\u0016J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020QH\u0014J\b\u0010S\u001a\u00020\u0012H\u0016J\b\u0010T\u001a\u0004\u0018\u00010QJ\b\u0010U\u001a\u00020\tH\u0016J\b\u0010V\u001a\u00020\u0012H\u0014J\n\u0010W\u001a\u0004\u0018\u00010QH\u0014J\b\u0010X\u001a\u00020IH\u0016J\u001a\u0010Y\u001a\u00020I2\u0006\u0010Z\u001a\u00020Q2\b\u0010[\u001a\u0004\u0018\u00010QH\u0016J\b\u0010\\\u001a\u00020IH\u0016J(\u0010]\u001a\u00020I2\b\u0010Z\u001a\u0004\u0018\u00010Q2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020\tJ\u0010\u0010b\u001a\u00020\t2\u0006\u0010^\u001a\u00020_H\u0007J\"\u0010c\u001a\u00020I2\b\u0010Z\u001a\u0004\u0018\u00010Q2\u0006\u0010d\u001a\u00020_2\u0006\u0010e\u001a\u00020_H\u0016J\b\u0010f\u001a\u00020IH\u0016J\b\u0010g\u001a\u00020IH\u0016J\b\u0010h\u001a\u00020IH\u0016J\b\u0010i\u001a\u00020IH\u0016J\b\u0010j\u001a\u00020\tH\u0016J\u0006\u0010k\u001a\u00020\u0012J\b\u0010l\u001a\u00020\tH\u0016J\b\u0010m\u001a\u00020IH\u0002J\b\u0010n\u001a\u00020IH\u0016J\u0010\u0010o\u001a\u00020\t2\u0006\u0010p\u001a\u00020qH\u0016J\u0018\u0010o\u001a\u00020\t2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\tH\u0016J\u0018\u0010o\u001a\u00020\t2\u0006\u0010s\u001a\u00020\u00122\u0006\u0010t\u001a\u00020\tH\u0014J\u0010\u0010u\u001a\u00020I2\u0006\u0010v\u001a\u00020wH\u0016J\u000e\u0010x\u001a\u00020I2\u0006\u0010y\u001a\u00020\tJ5\u0010z\u001a\u00020I2\u0006\u0010{\u001a\u00020Q2\u0006\u0010Z\u001a\u00020Q2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010:2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00020I2\u0007\u0010\u0001\u001a\u00020\tH\u0016J\u0012\u0010\u0001\u001a\u00020I2\u0007\u0010\u0001\u001a\u00020\tH\u0016J\u0011\u0010\u0001\u001a\u00020I2\b\u00107\u001a\u0004\u0018\u000108J!\u0010\u0001\u001a\u00020I2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u001a\u00030\u0001JA\u0010\u0001\u001a\u00020I2\u0007\u0010\u0001\u001a\u00020Q2\u0006\u0010{\u001a\u00020Q2\u0006\u0010Z\u001a\u00020Q2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010}\u001a\u00020~2\u0007\u0010\u001a\u00030\u0001H\u0002J\u0011\u0010\u0001\u001a\u00020I2\u0006\u0010p\u001a\u00020\u0012H\u0014J\b\u0010A\u001a\u00020IH\u0016J\u0007\u0010\u0001\u001a\u00020\tJ\t\u0010\u0001\u001a\u00020IH\u0016J\u0011\u0010\u0001\u001a\u00020I2\u0006\u0010p\u001a\u00020\u0012H\u0014R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001a\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "firstCacheTimeStep", "", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lastDownloadStatus", "lastSeconds", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "limitSeconds", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "textureView", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "totalSeconds", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoMatrix", "Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "getVideoMatrix", "()Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "setVideoMatrix", "(Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;)V", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkCompleted", "createMp4Parser", "Lcom/tencent/mm/plugin/Atom/IMp4Parser;", "createVideoFilePath", "", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrPosSec", "getDefaultLog", "", "getMediaId", "getVideoDurationSec", "getVideoMediaId", "isPlaying", "layoutId", "logTips", "onCompletion", "onM3U8Ready", "mediaId", "m3u8", "onMediaInfoAndMatrixPrepared", "onMoovReady", "moovPos", "", "length", "isPreparedMoovReadyResult", "onPrepareMoovReady", "onProgress", "offset", "total", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "pauseWithCancel", AssetExtension.SCENE_PLAY, "requestAudioFocus", "reset", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setInterceptDetach", "isInterceptDetach", "setLocalVideoMedia", "path", "matrix", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setLoop", "loop", "setMute", "mute", "setVideoCore", "setVideoMedia", "isLocal", "downloadUrl", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setVideoTotalTime", "startOrPlay", "stop", ch.COL_UPDATETIME, "Companion", "plugin-finder_release"})
public class FinderVideoView extends MMVideoView {
    public static final a wgh = new a((byte) 0);
    private final com.tencent.mm.model.d hWh = com.tencent.mm.model.d.aTu();
    private k tCD;
    private final f uTP = g.ah(c.wgk);
    boolean wcA = true;
    boolean wcB;
    volatile boolean wcC = true;
    private y wcw;
    private s wcy;
    private boolean weo;
    private t wep;
    private bej wga;
    private SynchronizedVideoPlayTextureView wgb;
    private int wgc;
    private final int wgd;
    private int wge;
    private int wgf;
    private int wgg;

    static {
        AppMethodBeat.i(168206);
        AppMethodBeat.o(168206);
    }

    private final com.tencent.mm.plugin.finder.preload.model.a getPreloadModel() {
        AppMethodBeat.i(254384);
        com.tencent.mm.plugin.finder.preload.model.a aVar = (com.tencent.mm.plugin.finder.preload.model.a) this.uTP.getValue();
        AppMethodBeat.o(254384);
        return aVar;
    }

    public static final /* synthetic */ String a(FinderVideoView finderVideoView) {
        AppMethodBeat.i(168207);
        String defaultLog = finderVideoView.getDefaultLog();
        AppMethodBeat.o(168207);
        return defaultLog;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoView$Companion;", "", "()V", "FINDER_VIDEO_VIEW_IDKEY_STAT", "", "_TAG", "", "isDebug", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderVideoView(Context context) {
        super(context);
        AppMethodBeat.i(168204);
        setReporter(new i.c(this) {
            /* class com.tencent.mm.plugin.finder.video.FinderVideoView.AnonymousClass1 */
            final /* synthetic */ FinderVideoView wgi;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wgi = r1;
            }

            @Override // com.tencent.mm.pluginsdk.ui.i.c
            public final void yU(long j2) {
                cjl cjl;
                AppMethodBeat.i(168171);
                s mediaInfo = this.wgi.getMediaInfo();
                if (mediaInfo != null) {
                    cjl = mediaInfo.wgl;
                } else {
                    cjl = null;
                }
                if (cjl != null) {
                    if (j2 < 200) {
                        h.INSTANCE.idkeyStat(1302, j2, 1, false);
                    }
                    if (120 <= j2 && 139 >= j2) {
                        h.INSTANCE.idkeyStat(1302, 200, 1, false);
                        if (120 <= j2 && 124 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 201, 1, false);
                        }
                        if (125 <= j2 && 129 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 202, 1, false);
                        }
                        if (130 <= j2 && 134 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 203, 1, false);
                        }
                        if (135 <= j2 && 139 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 204, 1, false);
                        }
                    }
                    if (141 > j2) {
                        AppMethodBeat.o(168171);
                        return;
                    } else if (160 >= j2) {
                        h.INSTANCE.idkeyStat(1302, 210, 1, false);
                        if (141 <= j2 && 145 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 211, 1, false);
                        }
                        if (146 <= j2 && 150 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 212, 1, false);
                        }
                        if (151 <= j2 && 155 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 213, 1, false);
                        }
                        if (156 > j2) {
                            AppMethodBeat.o(168171);
                            return;
                        } else if (160 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 214, 1, false);
                        }
                    }
                }
                AppMethodBeat.o(168171);
            }

            @Override // com.tencent.mm.pluginsdk.ui.i.c
            public final void DX(String str) {
            }
        });
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wgd = com.tencent.mm.plugin.finder.storage.c.drG();
        this.wge = -1;
        this.wgg = 3;
        AppMethodBeat.o(168204);
    }

    public FinderVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168205);
        setReporter(new i.c(this) {
            /* class com.tencent.mm.plugin.finder.video.FinderVideoView.AnonymousClass1 */
            final /* synthetic */ FinderVideoView wgi;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wgi = r1;
            }

            @Override // com.tencent.mm.pluginsdk.ui.i.c
            public final void yU(long j2) {
                cjl cjl;
                AppMethodBeat.i(168171);
                s mediaInfo = this.wgi.getMediaInfo();
                if (mediaInfo != null) {
                    cjl = mediaInfo.wgl;
                } else {
                    cjl = null;
                }
                if (cjl != null) {
                    if (j2 < 200) {
                        h.INSTANCE.idkeyStat(1302, j2, 1, false);
                    }
                    if (120 <= j2 && 139 >= j2) {
                        h.INSTANCE.idkeyStat(1302, 200, 1, false);
                        if (120 <= j2 && 124 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 201, 1, false);
                        }
                        if (125 <= j2 && 129 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 202, 1, false);
                        }
                        if (130 <= j2 && 134 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 203, 1, false);
                        }
                        if (135 <= j2 && 139 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 204, 1, false);
                        }
                    }
                    if (141 > j2) {
                        AppMethodBeat.o(168171);
                        return;
                    } else if (160 >= j2) {
                        h.INSTANCE.idkeyStat(1302, 210, 1, false);
                        if (141 <= j2 && 145 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 211, 1, false);
                        }
                        if (146 <= j2 && 150 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 212, 1, false);
                        }
                        if (151 <= j2 && 155 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 213, 1, false);
                        }
                        if (156 > j2) {
                            AppMethodBeat.o(168171);
                            return;
                        } else if (160 >= j2) {
                            h.INSTANCE.idkeyStat(1302, 214, 1, false);
                        }
                    }
                }
                AppMethodBeat.o(168171);
            }

            @Override // com.tencent.mm.pluginsdk.ui.i.c
            public final void DX(String str) {
            }
        });
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wgd = com.tencent.mm.plugin.finder.storage.c.drG();
        this.wge = -1;
        this.wgg = 3;
        AppMethodBeat.o(168205);
    }

    public final s getMediaInfo() {
        return this.wcy;
    }

    public final void setMediaInfo(s sVar) {
        this.wcy = sVar;
    }

    public final bej getVideoMatrix() {
        return this.wga;
    }

    public final void setVideoMatrix(bej bej) {
        this.wga = bej;
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

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public int dEP() {
        return R.layout.a6v;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderVideoView$createVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "getBusinessType", "", "setVideoPath", "", "fullFile", "", "stop", "plugin-finder_release"})
    public static final class b extends SynchronizedVideoPlayTextureView {
        final /* synthetic */ FinderVideoView wgi;
        final /* synthetic */ Context wgj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderVideoView finderVideoView, Context context, Context context2) {
            super(context2);
            this.wgi = finderVideoView;
            this.wgj = context;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView, com.tencent.mm.pluginsdk.ui.tools.j
        public final void stop() {
            AppMethodBeat.i(168174);
            Log.i("Finder.VideoView", "[stop] " + FinderVideoView.a(this.wgi));
            super.stop();
            AppMethodBeat.o(168174);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView, com.tencent.mm.pluginsdk.ui.tools.j
        public final void setVideoPath(String str) {
            AppMethodBeat.i(168175);
            Log.i("Finder.VideoView", "[setVideoPath] " + FinderVideoView.a(this.wgi));
            super.setVideoPath(str);
            AppMethodBeat.o(168175);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView
        public final int getBusinessType() {
            return 1;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final j di(Context context) {
        AppMethodBeat.i(168180);
        this.mEJ = 1;
        b bVar = new b(this, context, context);
        bVar.setIsOnlineVideoType(true);
        bVar.setNeedResetExtractor(true);
        this.wgb = bVar;
        SynchronizedVideoPlayTextureView synchronizedVideoPlayTextureView = this.wgb;
        if (synchronizedVideoPlayTextureView == null) {
            p.hyc();
        }
        SynchronizedVideoPlayTextureView synchronizedVideoPlayTextureView2 = synchronizedVideoPlayTextureView;
        AppMethodBeat.o(168180);
        return synchronizedVideoPlayTextureView2;
    }

    public final Bitmap getBitmap() {
        AppMethodBeat.i(254385);
        SynchronizedVideoPlayTextureView synchronizedVideoPlayTextureView = this.wgb;
        if (synchronizedVideoPlayTextureView != null) {
            Bitmap bitmap = synchronizedVideoPlayTextureView.getBitmap();
            AppMethodBeat.o(254385);
            return bitmap;
        }
        AppMethodBeat.o(254385);
        return null;
    }

    public final void setInterceptDetach(boolean z) {
        AppMethodBeat.i(168181);
        SynchronizedVideoPlayTextureView synchronizedVideoPlayTextureView = this.wgb;
        if (synchronizedVideoPlayTextureView != null) {
            synchronizedVideoPlayTextureView.setInterceptDetach(z);
            AppMethodBeat.o(168181);
            return;
        }
        AppMethodBeat.o(168181);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public String getMediaId() {
        String str;
        s sVar = this.wcy;
        return (sVar == null || (str = sVar.mediaId) == null) ? "" : str;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void stop() {
        AppMethodBeat.i(168182);
        super.stop();
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.b(this.wcy);
        }
        this.wcC = true;
        this.wcy = null;
        this.wga = null;
        this.wcA = false;
        this.wgc = 0;
        Log.i("Finder.VideoView", "[stop] " + getDefaultLog() + "  " + ((Object) ""));
        AppMethodBeat.o(168182);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIDestroy() {
        AppMethodBeat.i(178468);
        super.onUIDestroy();
        this.wcA = false;
        this.wcy = null;
        this.wga = null;
        Log.i("Finder.VideoView", "[onUIDestroy] " + getDefaultLog() + "  " + ((Object) ""));
        AppMethodBeat.o(178468);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean pause() {
        AppMethodBeat.i(168183);
        this.hWh.apm();
        Log.i("Finder.VideoView", "[pause] " + getDefaultLog() + "  " + ((Object) ""));
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.dFL();
        }
        boolean pause = super.pause();
        AppMethodBeat.o(168183);
        return pause;
    }

    public final int dFk() {
        AppMethodBeat.i(254386);
        Log.i("Finder.VideoView", "[pauseWithCancel] " + getDefaultLog() + " downloadStatus=" + this.jpV + ", isPrepared=" + this.ZA);
        this.wgc = this.jpV;
        com.tencent.mm.modelvideo.b bVar = this.jpS;
        if (bVar != null) {
            bVar.he(getVideoMediaId());
        }
        pause();
        AppMethodBeat.o(254386);
        return 0;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean play() {
        String str;
        AppMethodBeat.i(168185);
        if (!this.wcA) {
            StringBuilder append = new StringBuilder("[play] unFocused. ").append(getDefaultLog()).append(" mediaId=");
            s sVar = this.wcy;
            if (sVar != null) {
                str = sVar.mediaId;
            } else {
                str = null;
            }
            Log.i("Finder.VideoView", append.append(str).toString());
            AppMethodBeat.o(168185);
            return false;
        }
        if (this.wgc == 1) {
            this.jpV = 1;
            this.wgc = 0;
            com.tencent.mm.modelvideo.b bVar = this.jpS;
            if (bVar != null) {
                bVar.p(getVideoMediaId(), this.jpU, this.url);
            }
            j jVar = this.qbJ;
            p.g(jVar, "videoView");
            int currentPosition = jVar.getCurrentPosition() / 1000;
            ub(currentPosition);
            Log.i("Finder.VideoView", "continue to download... mediaId=" + getVideoMediaId() + " playSec=" + currentPosition);
        }
        if (!this.wcA || !super.play()) {
            AppMethodBeat.o(168185);
            return false;
        }
        requestAudioFocus();
        SynchronizedVideoPlayTextureView synchronizedVideoPlayTextureView = this.wgb;
        if (synchronizedVideoPlayTextureView != null) {
            synchronizedVideoPlayTextureView.setOneTimeVideoTextureUpdateCallback(this);
        }
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.dFN();
        }
        AppMethodBeat.o(168185);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIPause() {
        AppMethodBeat.i(168186);
        super.onUIPause();
        AppMethodBeat.o(168186);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIResume() {
        AppMethodBeat.i(168187);
        super.onUIResume();
        AppMethodBeat.o(168187);
    }

    public final boolean dFj() {
        AppMethodBeat.i(254387);
        boolean z = this.wcC;
        start();
        AppMethodBeat.o(254387);
        return z;
    }

    public final void setVideoCore(k kVar) {
        this.tCD = kVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView
    public final void start() {
        boolean z;
        AppMethodBeat.i(168188);
        if (!this.wcA) {
            Log.w("Finder.VideoView", "isViewFocused=" + this.wcA);
            AppMethodBeat.o(168188);
        } else if (this.wcy == null) {
            Log.w("Finder.VideoView", "mediaInfo is null!");
            AppMethodBeat.o(168188);
        } else if (this.qbJ == null) {
            Log.w("Finder.VideoView", "videoView is null!");
            AppMethodBeat.o(168188);
        } else {
            if (this.jpW == 3) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(168188);
                return;
            }
            Log.i("Finder.VideoView", "[start#1] isNeverStart=" + this.wcC + " isViewFocused=" + this.wcA + " isPlaying=false " + getDefaultLog());
            if (!this.wcC) {
                play();
                AppMethodBeat.o(168188);
                return;
            }
            y yVar = this.wcw;
            if (yVar != null) {
                yVar.a(this.wcy, 0);
            }
            if (c(this.wcy)) {
                j jVar = this.qbJ;
                p.g(jVar, "videoView");
                String videoPath = jVar.getVideoPath();
                s sVar = this.wcy;
                if (sVar == null) {
                    p.hyc();
                }
                if (!p.j(videoPath, sVar.path)) {
                    j jVar2 = this.qbJ;
                    p.g(jVar2, "videoView");
                    s sVar2 = this.wcy;
                    if (sVar2 == null) {
                        p.hyc();
                    }
                    jVar2.setVideoPath(sVar2.path);
                }
                this.jpS = null;
                this.jpV = 3;
                this.wgc = 0;
                SynchronizedVideoPlayTextureView synchronizedVideoPlayTextureView = this.wgb;
                if (synchronizedVideoPlayTextureView != null) {
                    synchronizedVideoPlayTextureView.setIsOnlineVideoType(false);
                }
                boolean play = play();
                if (!play) {
                    j jVar3 = this.qbJ;
                    p.g(jVar3, "videoView");
                    String videoPath2 = jVar3.getVideoPath();
                    if (videoPath2 == null || videoPath2.length() == 0) {
                        StringBuilder sb = new StringBuilder("[start] ERROR! videoPath=");
                        j jVar4 = this.qbJ;
                        p.g(jVar4, "videoView");
                        StringBuilder append = sb.append(jVar4.getVideoPath()).append(" completedPath=");
                        s sVar3 = this.wcy;
                        if (sVar3 == null) {
                            p.hyc();
                        }
                        Log.e("Finder.VideoView", append.append(sVar3.path).toString());
                    }
                }
                StringBuilder append2 = new StringBuilder("[start] ret=").append(play).append(" has download! local path:");
                j jVar5 = this.qbJ;
                p.g(jVar5, "videoView");
                Log.i("Finder.VideoView", append2.append(jVar5.getVideoPath()).toString());
            } else {
                SynchronizedVideoPlayTextureView synchronizedVideoPlayTextureView2 = this.wgb;
                if (synchronizedVideoPlayTextureView2 != null) {
                    synchronizedVideoPlayTextureView2.setIsOnlineVideoType(true);
                }
                if (this.jpS == null || this.jpV == 1) {
                    showLoading();
                    if (this.jpS == null) {
                        Log.e("Finder.VideoView", "why proxy is null! " + getDefaultLog());
                    }
                    Log.i("Finder.VideoView", "[start] wait for download..." + getDefaultLog());
                } else {
                    Log.i("Finder.VideoView", "[start] need to download..." + getDefaultLog());
                    showLoading();
                    setDownloadStatus(1);
                    this.jpS.a(this);
                    this.jpS.p(this.jpT, this.jpU, this.url);
                    fgB();
                }
            }
            yU(1 + ((long) getReportIdkey()));
            this.wcC = false;
            AppMethodBeat.o(168188);
        }
    }

    private final boolean c(s sVar) {
        int i2;
        AppMethodBeat.i(254388);
        if (sVar == null) {
            Log.w("Finder.VideoView", "[checkCompleted] mediaInfo is null");
            AppMethodBeat.o(254388);
            return false;
        } else if (sVar.wgl == null) {
            Log.w("Finder.VideoView", "[checkCompleted] localFinderMedia is null");
            AppMethodBeat.o(254388);
            return true;
        } else {
            com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            at bv = com.tencent.mm.plugin.finder.storage.logic.d.bv(sVar.mediaId, true);
            int aui = bv.aui(sVar.path);
            Log.i("Finder.VideoView", "[checkCompleted] isDownloadFinishAndCheckFile=" + aui + " cache=" + bv + " path=" + sVar.path + ' ' + getDefaultLog());
            MediaPreloadCore.a aVar = MediaPreloadCore.uTV;
            if (MediaPreloadCore.uTU) {
                pw pwVar = new pw();
                pwVar.dVW.mediaId = sVar.wgl.mediaId;
                pwVar.dVW.dVY = bv.field_fileFormat;
                pwVar.dVW.dVX = bv.field_hasPlayed;
                pw.a aVar2 = pwVar.dVW;
                if (aui == 0) {
                    i2 = (int) ((100.0f * ((float) bv.field_cacheSize)) / ((float) bv.field_totalSize));
                } else {
                    i2 = 0;
                }
                aVar2.process = i2;
                EventCenter.instance.publish(pwVar);
            }
            if (aui == 0) {
                AppMethodBeat.o(254388);
                return true;
            }
            AppMethodBeat.o(254388);
            return false;
        }
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final boolean G(int i2, boolean z) {
        AppMethodBeat.i(168189);
        Log.i("Finder.VideoView", "[seekTo] time=" + i2 + " afterSeekPlay=" + z + ' ' + getDefaultLog());
        requestAudioFocus();
        boolean G = super.G(i2, z);
        AppMethodBeat.o(168189);
        return G;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.tools.j.a, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onCompletion() {
        y yVar;
        AppMethodBeat.i(254389);
        s sVar = this.wcy;
        if (sVar != null) {
            y yVar2 = this.wcw;
            if (yVar2 != null) {
                yVar2.a(sVar.wgl, getVideoDurationSec(), getVideoDurationSec());
            }
            if (this.jqj && (yVar = this.wcw) != null) {
                yVar.dFM();
            }
        }
        super.onCompletion();
        AppMethodBeat.o(254389);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void xv(int i2) {
        cjl cjl;
        AppMethodBeat.i(168190);
        super.xv(i2);
        if (this.wge != i2) {
            y yVar = this.wcw;
            if (yVar != null) {
                s sVar = this.wcy;
                if (sVar != null) {
                    cjl = sVar.wgl;
                } else {
                    cjl = null;
                }
                yVar.a(cjl, i2, this.wgf);
            }
            this.wge = i2;
        }
        AppMethodBeat.o(168190);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void setVideoTotalTime(int i2) {
        AppMethodBeat.i(168191);
        super.setVideoTotalTime(i2);
        this.wgf = i2;
        AppMethodBeat.o(168191);
    }

    public final void b(s sVar, boolean z, FeedData feedData) {
        AppMethodBeat.i(254390);
        p.h(sVar, "video");
        p.h(feedData, "feedData");
        if (z) {
            String str = sVar.uIw.url;
            if (str == null) {
                str = "";
            }
            String auA = sVar.auA();
            cjx cjx = sVar.uIw.uOR;
            a(str, auA, cjx != null ? cjx.Mpr : null, sVar, feedData);
            AppMethodBeat.o(254390);
            return;
        }
        a(sVar.getUrl(), sVar.getPath(), sVar.auA(), sVar.uIw, sVar, feedData);
        AppMethodBeat.o(254390);
    }

    private final void a(String str, String str2, bej bej, s sVar, FeedData feedData) {
        AppMethodBeat.i(254391);
        this.wga = bej;
        a("", str, str2, null, sVar, feedData);
        AppMethodBeat.o(254391);
    }

    private final void a(String str, String str2, String str3, cjl cjl, s sVar, FeedData feedData) {
        AppMethodBeat.i(254392);
        this.wcy = new s(str, str2, str3, cjl, sVar, feedData);
        s sVar2 = this.wcy;
        if (sVar2 != null) {
            if (cjl != null && cjl.MoO) {
                cjx cjx = cjl.uOR;
                this.wga = cjx != null ? cjx.Mpr : null;
                Log.i("Finder.VideoView", "[setVideoMedia] needCrop, " + this.wga);
            }
            dEQ();
            super.c(false, str, 0);
            this.jpU = sVar2.path;
            this.jpT = sVar2.mediaId;
            Log.i("Finder.VideoView", "[setVideoMedia] " + getDefaultLog());
            AppMethodBeat.o(254392);
            return;
        }
        AppMethodBeat.o(254392);
    }

    public void dEQ() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void setMute(boolean z) {
        AppMethodBeat.i(168194);
        super.setMute(z);
        AppMethodBeat.o(168194);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final void bgR() {
    }

    public final String getVideoMediaId() {
        s sVar = this.wcy;
        if (sVar != null) {
            return sVar.mediaId;
        }
        return null;
    }

    private final String getDefaultLog() {
        String str;
        AppMethodBeat.i(168195);
        StringBuilder append = new StringBuilder("videoView=").append(hashCode()).append("->textureView=").append(this.qbJ.hashCode()).append(" mediaId=");
        s sVar = this.wcy;
        if (sVar != null) {
            str = sVar.mediaId;
        } else {
            str = null;
        }
        String sb = append.append(str).toString();
        AppMethodBeat.o(168195);
        return sb;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.modelvideo.b.a
    public final void i(String str, long j2, long j3) {
        AppMethodBeat.i(168196);
        if (!Util.isEqual(this.jpT, str)) {
            AppMethodBeat.o(168196);
            return;
        }
        Log.i("Finder.VideoView", "%s download  onPlayProgress [%d, %d] pauseByLoadData=%s playStatus=%s", bgQ(), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(this.jqb), Integer.valueOf(this.jpW));
        if (this.jqb && this.jpW == 3) {
            ub(getCurrPosSec());
        }
        AppMethodBeat.o(168196);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final boolean uc(int i2) {
        boolean z;
        boolean z2;
        int i3;
        MediaPreloadCore mediaPreloadCore;
        AppMethodBeat.i(168197);
        if (this.jpV == 3) {
            AppMethodBeat.o(168197);
            return true;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            if (i2 != 0 || this.jpX == null) {
                z2 = false;
            } else {
                pInt4.value = 0;
                pInt3.value = pInt4.value;
                z2 = this.jpX.b(i2 + 1, pInt3, pInt4);
            }
            int i4 = i2 + 1;
            if (z2) {
                i3 = pInt4.value + 1;
            } else {
                i3 = i4;
            }
            if (this.jpS == null || this.jpX == null || !this.jpX.a(i2, i3, pInt, pInt2)) {
                z = false;
                AppMethodBeat.o(168197);
                return z;
            }
            z = this.jpS.isVideoDataAvailable(this.jpT, pInt.value, pInt2.value);
            if (z) {
                try {
                    this.jqc = Math.max(i3, this.jqc);
                } catch (Exception e2) {
                    e = e2;
                    Log.e(this.TAG, "%s check video data error %s ", bgQ(), e.toString());
                    AppMethodBeat.o(168197);
                    return z;
                }
            } else {
                this.jqc = i2;
            }
            k kVar = this.tCD;
            if (!(kVar == null || (mediaPreloadCore = kVar.weU) == null)) {
                String mediaId = getMediaId();
                int i5 = this.jqc;
                int i6 = this.jpY;
                p.h(mediaId, "mediaId");
                if (mediaPreloadCore.dlE()) {
                    com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    at bv = com.tencent.mm.plugin.finder.storage.logic.d.bv(mediaId, false);
                    if ((mediaPreloadCore.getPreloadModel().uUu <= i5 || mediaPreloadCore.getPreloadModel().uUt <= bv.dkP()) && mediaPreloadCore.uTS) {
                        mediaPreloadCore.aun("startPreloadSecs=" + mediaPreloadCore.getPreloadModel().uUu + ", startPreloadPercent=" + mediaPreloadCore.getPreloadModel().uUt + ' ' + "cachePercent=" + bv.dkP() + " cacheTime=" + i5 + ", timeDuration=" + i6 + ", [onOnlineCachePlaying#" + mediaId + ']');
                        mediaPreloadCore.uTS = false;
                    }
                }
            }
            Log.i("Finder.VideoView", "ret=%s %s checkCanPlay range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", Boolean.valueOf(z), bgQ(), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value), Integer.valueOf(i2), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd), this.jpT);
            AppMethodBeat.o(168197);
            return z;
        } catch (Exception e3) {
            e = e3;
            z = false;
            Log.e(this.TAG, "%s check video data error %s ", bgQ(), e.toString());
            AppMethodBeat.o(168197);
            return z;
        }
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final void reset() {
        AppMethodBeat.i(168198);
        super.reset();
        this.wgg = 3;
        AppMethodBeat.o(168198);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public boolean a(int i2, PInt pInt, PInt pInt2) {
        int i3 = 0;
        AppMethodBeat.i(168199);
        p.h(pInt, "start");
        p.h(pInt2, "end");
        pInt.value = Math.max(i2, this.jqc);
        if (this.jpW == 1) {
            pInt.value = i2;
            pInt2.value = pInt.value + this.wgg + 1;
        }
        this.wgg += this.jqh.jqm;
        if (this.jpW == 2) {
            pInt.value = i2 - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = pInt.value + this.jqd + 8;
        }
        if (this.jpW == 3 || this.jpW == 4) {
            pInt.value = this.jqc;
            pInt2.value = this.jqd + i2 + 1 + this.jqh.jqn;
            i3 = Math.min(kotlin.h.a.cR((((float) getPreloadModel().uUo) / 100.0f) * ((float) this.jpY)), getPreloadModel().uUu);
            if (i3 <= 0) {
                if (((float) pInt2.value) < ((float) this.jpY) / 2.0f) {
                    pInt2.value = (int) ((((float) this.jpY) / 2.0f) + 1.0f);
                }
            } else if (pInt2.value < i3) {
                pInt2.value = i3 + 1;
            }
        }
        if (pInt2.value >= this.jpY + 1) {
            pInt2.value = this.jpY + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.jqh.jqn;
            Log.i("Finder.VideoView", bgQ() + " [start:end]=[" + pInt.value + ':' + pInt2.value + "],playStatus=" + this.jpW + ",playTime=" + i2 + ",cachePlayTime=" + this.jqc + ",cacheTimeStep=" + this.jqd + ",timeDuration=" + this.jpY + ",targetSecond=" + i3 + ",cdnMediaId=" + this.jpT);
            AppMethodBeat.o(168199);
        } else {
            Log.i("Finder.VideoView", bgQ() + " [start:end]=[" + pInt.value + ':' + pInt2.value + "],playStatus=" + this.jpW + ",playTime=" + i2 + ",cachePlayTime=" + this.jqc + ",cacheTimeStep=" + this.jqd + ",timeDuration=" + this.jpY + ",targetSecond=" + i3 + ",cdnMediaId=" + this.jpT);
            AppMethodBeat.o(168199);
        }
        return true;
    }

    public final void B(long j2, boolean z) {
        AppMethodBeat.i(168200);
        Log.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s isPreparedMoovReadyResult:%s", bgQ(), Long.valueOf(j2), Integer.valueOf(this.jpY), this.jpT, Boolean.valueOf(z));
        if (this.jpY != 0) {
            Log.w(this.TAG, "moov had callback, do nothing.");
            AppMethodBeat.o(168200);
            return;
        }
        goq();
        try {
            if (this.jpX == null) {
                Log.w(this.TAG, "%s parser is null, thread is error.", bgQ());
                AppMethodBeat.o(168200);
            } else if (z || this.jpX.L(this.jpU, j2)) {
                com.tencent.mm.plugin.a.f fVar = this.jpX;
                p.g(fVar, "parser");
                this.jpY = fVar.blS();
                Log.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", bgQ(), Integer.valueOf(this.jpY), this.jpT);
                if (ub(0)) {
                    bgV();
                }
                this.jpW = this.jpZ == -1 ? 1 : 2;
                AppMethodBeat.o(168200);
            } else {
                Log.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", bgQ(), this.jpT);
                this.jpS.requestVideoData(this.jpT, 0, -1);
                AppMethodBeat.o(168200);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "%s deal moov ready error [%s]", bgQ(), this.jpT);
            AppMethodBeat.o(168200);
        }
    }

    public final boolean Gs(long j2) {
        AppMethodBeat.i(254393);
        if (this.jpX == null) {
            Log.w(this.TAG, "%s parser is null, thread is error.", bgQ());
            AppMethodBeat.o(254393);
            return false;
        }
        boolean L = this.jpX.L(this.jpU, j2);
        AppMethodBeat.o(254393);
        return L;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderVideoView$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
    public static final class d implements d.a {
        d() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTw() {
            AppMethodBeat.i(168176);
            Log.i("Finder.VideoView", "[audioHelperTool] gain");
            AppMethodBeat.o(168176);
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTy() {
            AppMethodBeat.i(168177);
            Log.i("Finder.VideoView", "[audioHelperTool] lossTransient");
            AppMethodBeat.o(168177);
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTx() {
            AppMethodBeat.i(168178);
            Log.i("Finder.VideoView", "[audioHelperTool] loss");
            AppMethodBeat.o(168178);
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTz() {
            AppMethodBeat.i(168179);
            Log.i("Finder.VideoView", "[audioHelperTool] lossTransientCanDuck");
            AppMethodBeat.o(168179);
        }
    }

    private final void requestAudioFocus() {
        AppMethodBeat.i(168202);
        this.hWh.a(new d());
        AppMethodBeat.o(168202);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView, com.tencent.mm.pluginsdk.ui.tools.j.e
    public final void bLh() {
        AppMethodBeat.i(168203);
        super.bLh();
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.Gr(0);
            AppMethodBeat.o(168203);
            return;
        }
        AppMethodBeat.o(168203);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public int getCurrPosSec() {
        AppMethodBeat.i(254394);
        int currPosSec = super.getCurrPosSec();
        AppMethodBeat.o(254394);
        return currPosSec;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public int getVideoDurationSec() {
        AppMethodBeat.i(254395);
        int videoDurationSec = super.getVideoDurationSec();
        AppMethodBeat.o(254395);
        return videoDurationSec;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void setIMMVideoViewCallback(i.b bVar) {
        AppMethodBeat.i(254396);
        p.h(bVar, "_callback");
        super.setIMMVideoViewCallback(bVar);
        AppMethodBeat.o(254396);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView
    public void setLoop(boolean z) {
        AppMethodBeat.i(254397);
        super.setLoop(z);
        AppMethodBeat.o(254397);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean isPlaying() {
        AppMethodBeat.i(254398);
        boolean isPlaying = super.isPlaying();
        AppMethodBeat.o(254398);
        return isPlaying;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean p(double d2) {
        AppMethodBeat.i(254399);
        boolean p = super.p(d2);
        AppMethodBeat.o(254399);
        return p;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(254400);
        boolean c2 = super.c(d2, z);
        AppMethodBeat.o(254400);
        return c2;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final com.tencent.mm.plugin.a.f bgT() {
        AppMethodBeat.i(254401);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsi() == 1) {
            com.tencent.mm.plugin.a.j jVar = new com.tencent.mm.plugin.a.j();
            AppMethodBeat.o(254401);
            return jVar;
        }
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsi() == 2) {
            k kVar = new k();
            AppMethodBeat.o(254401);
            return kVar;
        }
        com.tencent.mm.plugin.finder.video.parser.a aVar = new com.tencent.mm.plugin.finder.video.parser.a();
        AppMethodBeat.o(254401);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final String bgQ() {
        AppMethodBeat.i(254402);
        String str = "mediaId:" + getMediaId() + hashCode();
        AppMethodBeat.o(254402);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a> {
        public static final c wgk = new c();

        static {
            AppMethodBeat.i(254383);
            AppMethodBeat.o(254383);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.preload.model.a invoke() {
            AppMethodBeat.i(254382);
            com.tencent.mm.plugin.finder.preload.model.a mediaPreloadModel = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel();
            AppMethodBeat.o(254382);
            return mediaPreloadModel;
        }
    }
}
