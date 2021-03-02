package com.tencent.mm.plugin.finder.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.i.g;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.tav.core.AssetExtension;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmediacodec.e.b;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.r;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 Ò\u00012\u00020\u00012\u00020\u0002:\u0006Ò\u0001Ó\u0001Ô\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010h\u001a\u0004\u0018\u00010iH\u0016J\b\u0010j\u001a\u00020kH\u0016J\b\u0010l\u001a\u00020\nH\u0016J\b\u0010m\u001a\u00020nH\u0002J\b\u0010o\u001a\u00020\u0015H\u0016J\b\u0010p\u001a\u00020\u0015H\u0016J\n\u0010q\u001a\u0004\u0018\u00010rH\u0016J\b\u0010s\u001a\u00020\nH\u0016J\b\u0010t\u001a\u00020kH\u0016J\n\u0010u\u001a\u0004\u0018\u00010vH\u0016J\n\u0010w\u001a\u0004\u0018\u00010BH\u0016J\b\u0010x\u001a\u00020yH\u0016J\b\u0010z\u001a\u00020\u0015H\u0016J\b\u0010{\u001a\u00020nH\u0002J\u0012\u0010|\u001a\u00020n2\b\u0010}\u001a\u0004\u0018\u00010vH\u0002J\b\u0010~\u001a\u00020nH\u0002J\u001a\u0010\u001a\u00020n2\u0006\u0010}\u001a\u00020v2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00020n2\u0007\u0010\u0001\u001a\u00020BH\u0002J\t\u0010\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0001\u001a\u00020\u0015H\u0016J\t\u0010\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0001\u001a\u00020\u0015H\u0002J\b\u0010*\u001a\u00020\u0015H\u0016J\t\u0010\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\nH\u0002J\t\u0010\u0001\u001a\u00020nH\u0016J\t\u0010\u0001\u001a\u00020nH\u0016J\t\u0010\u0001\u001a\u00020\u0015H\u0016J\t\u0010\u0001\u001a\u00020\nH\u0016J\t\u0010\u0001\u001a\u00020\u0015H\u0016J\t\u0010\u0001\u001a\u00020vH\u0002J\u0012\u0010\u0001\u001a\u00020\u00152\t\b\u0002\u0010\u0001\u001a\u00020\nJ%\u0010\u0001\u001a\u00020n2\u0006\u0010}\u001a\u00020v2\t\u0010\u0001\u001a\u0004\u0018\u00010v2\u0007\u0010\u0001\u001a\u00020\nH\u0002J%\u0010\u0001\u001a\u00020\u00152\u0006\u0010}\u001a\u00020v2\t\u0010\u0001\u001a\u0004\u0018\u00010v2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\t\u0010\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\nH\u0002J\t\u0010\u0001\u001a\u00020nH\u0002J\u0014\u0010\u0001\u001a\u00020n2\t\b\u0002\u0010\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0001\u001a\u00020nH\u0016J\u0019\u0010\u0001\u001a\u00020n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nJ\u001c\u0010 \u0001\u001a\u00020\u00152\b\u0010¡\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010¤\u0001\u001a\u00020n2\u0007\u0010¥\u0001\u001a\u00020\nH\u0002J\u0015\u0010¦\u0001\u001a\u00020n2\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0016J\u0012\u0010©\u0001\u001a\u00020n2\u0007\u0010ª\u0001\u001a\u00020cH\u0016J\u0013\u0010«\u0001\u001a\u00020n2\b\u0010¬\u0001\u001a\u00030­\u0001H\u0016J\u0012\u0010®\u0001\u001a\u00020n2\u0007\u0010¯\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010°\u0001\u001a\u00020n2\u0007\u0010±\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010²\u0001\u001a\u00020n2\u0007\u0010³\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010´\u0001\u001a\u00020n2\u0007\u0010µ\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010¶\u0001\u001a\u00020n2\u0007\u0010·\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010¸\u0001\u001a\u00020n2\u0007\u0010¹\u0001\u001a\u00020\u0015H\u0016J\u0013\u0010º\u0001\u001a\u00020n2\b\u0010»\u0001\u001a\u00030¼\u0001H\u0016J&\u0010½\u0001\u001a\u00020n2\b\u0010¾\u0001\u001a\u00030¿\u00012\u0007\u0010À\u0001\u001a\u00020\u00152\b\u0010Á\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010Â\u0001\u001a\u00020n2\u0007\u0010Ã\u0001\u001a\u00020HH\u0016J\u0011\u0010Ä\u0001\u001a\u00020n2\u0006\u00105\u001a\u000206H\u0016J\u0012\u0010Å\u0001\u001a\u00020n2\u0007\u0010Æ\u0001\u001a\u00020\u0015H\u0016J\t\u0010Ç\u0001\u001a\u00020nH\u0002J\t\u0010È\u0001\u001a\u00020nH\u0002J\t\u0010É\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010Ê\u0001\u001a\u00020n2\u0007\u0010Ë\u0001\u001a\u00020BH\u0002J\t\u0010Ì\u0001\u001a\u00020nH\u0016J\t\u0010Í\u0001\u001a\u00020nH\u0002J\t\u0010Î\u0001\u001a\u00020nH\u0002J\t\u0010Ï\u0001\u001a\u00020nH\u0002J\u0012\u0010Ð\u0001\u001a\u00020n2\u0007\u0010Ñ\u0001\u001a\u00020\u0015H\u0002R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010%\"\u0004\b.\u0010'R\u001a\u0010/\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\u001a\u00101\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010%\"\u0004\b2\u0010'R\u001a\u00103\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010%\"\u0004\b4\u0010'R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u000e\u0010S\u001a\u00020TX.¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010W\u001a\u00060XR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\b\u0018\u00010ZR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X.¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010b\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g¨\u0006Õ\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPrepareStatus", "currentPlayState", "downloadCallback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "getDownloadCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "setDownloadCallback", "(Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "enableMediaCodecReuse", "", "fTPPKVReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "getFTPPKVReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "fTPPKVReporter$delegate", "Lkotlin/Lazy;", "fTPPLog", "Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "getFTPPLog", "()Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "fTPPLog$delegate", "isBuffering", "isFirstFrameRendered", "isFirstStart", "isFullScreen", "()Z", "setFullScreen", "(Z)V", "isLongVideo", "isOpenFlowControl", "isPreviewing", "isRealStartDownloader", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isShouldPlayResume", "setShouldPlayResume", "isStartCdn", "setStartCdn", "isStartCdnPreload", "setStartCdnPreload", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaPreloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getMediaPreloadCore$plugin_finder_release", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setMediaPreloadCore$plugin_finder_release", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "notifyProgressTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBufferingStartRunnable", "Ljava/lang/Runnable;", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getOnMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setOnMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "playerListener", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$TPPlayerListener;", "resourceLoaderProxy", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "surface", "Landroid/view/Surface;", "textureUpdateTimes", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getFTPPTag", "", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "handleOnBufferingEnd", "handleOnBufferingStart", "mediaId", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initFTPPTag", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "initTextureView", "mediaInfo", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "currentState", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", AssetExtension.SCENE_PLAY, "playInfo", "playWithSource", "source", "prepareCacheFile", "filePath", "invokeSource", "prepareOnlineUrl", "url", "prepareToPlay", "prepareVideo", "realPlay", "releaseSurface", "detach", "removeVideoFooterView", "resizeTextureView", "width", "height", "seekTo", AppMeasurement.Param.TIMESTAMP, "", "afterSeekPlay", "setBgPrepareStatus", "status", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "setVideoMuteListener", "muteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "startCdnDownload", "startCdnPreload", "startOrPlay", "startProgressTimer", "info", "stop", "stopCdnDownload", "stopCdnPreload", "stopProgressTimer", "updateIsRealStartDownloader", "isRealStart", "Companion", "ResourceLoaderProxy", "TPPlayerListener", "plugin-finder_release"})
public final class FinderThumbPlayerProxy extends FrameLayout implements r {
    private static String TAG = "Finder.FinderThumbPlayerProxy";
    private static final HashSet<Integer> wdW = new HashSet<>();
    public static final a wdX = new a((byte) 0);
    private boolean bbU;
    private volatile int currentPlayState;
    private MMHandler hAk;
    private boolean isLongVideo;
    private boolean onr;
    private boolean sZd;
    private Surface surface;
    private s tHL;
    private com.tencent.mm.plugin.finder.video.reporter.c tHS;
    boolean wcA;
    private boolean wcB;
    private i.b wcv;
    private y wcw;
    private boolean wdB;
    private com.tencent.mm.plugin.thumbplayer.e.a wdC;
    private c wdD;
    public MMThumbPlayerTextureView wdE;
    private volatile boolean wdF;
    private MediaPreloadCore wdG;
    private b wdH;
    private boolean wdI;
    private int wdJ;
    private final kotlin.f wdK;
    private final kotlin.f wdL;
    private MTimerHandler wdM;
    private Runnable wdN;
    private int wdO;
    private u wdP;
    private AtomicBoolean wdQ;
    private boolean wdR;
    private t wdS;
    private x wdT;
    private boolean wdU;
    private boolean wdV;

    private final com.tencent.mm.plugin.finder.video.reporter.a getFTPPKVReporter() {
        AppMethodBeat.i(254146);
        com.tencent.mm.plugin.finder.video.reporter.a aVar = (com.tencent.mm.plugin.finder.video.reporter.a) this.wdK.getValue();
        AppMethodBeat.o(254146);
        return aVar;
    }

    private final com.tencent.mm.plugin.finder.video.log.a getFTPPLog() {
        AppMethodBeat.i(254147);
        com.tencent.mm.plugin.finder.video.log.a aVar = (com.tencent.mm.plugin.finder.video.log.a) this.wdL.getValue();
        AppMethodBeat.o(254147);
        return aVar;
    }

    public static final /* synthetic */ String a(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254194);
        String dFm = finderThumbPlayerProxy.dFm();
        AppMethodBeat.o(254194);
        return dFm;
    }

    public static final /* synthetic */ void b(FinderThumbPlayerProxy finderThumbPlayerProxy, int i2) {
        AppMethodBeat.i(254197);
        finderThumbPlayerProxy.setBgPrepareStatus(i2);
        AppMethodBeat.o(254197);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.thumbplayer.e.a c(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254195);
        com.tencent.mm.plugin.thumbplayer.e.a aVar = finderThumbPlayerProxy.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        AppMethodBeat.o(254195);
        return aVar;
    }

    public static final /* synthetic */ void d(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254196);
        finderThumbPlayerProxy.oM(false);
        AppMethodBeat.o(254196);
    }

    public static final /* synthetic */ MMThumbPlayerTextureView h(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254198);
        MMThumbPlayerTextureView mMThumbPlayerTextureView = finderThumbPlayerProxy.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        AppMethodBeat.o(254198);
        return mMThumbPlayerTextureView;
    }

    public static final /* synthetic */ boolean m(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254201);
        boolean dFr = finderThumbPlayerProxy.dFr();
        AppMethodBeat.o(254201);
        return dFr;
    }

    public static final /* synthetic */ boolean n(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254202);
        boolean asa = finderThumbPlayerProxy.asa();
        AppMethodBeat.o(254202);
        return asa;
    }

    public static final /* synthetic */ boolean o(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254203);
        boolean Md = finderThumbPlayerProxy.Md(6);
        AppMethodBeat.o(254203);
        return Md;
    }

    public static final /* synthetic */ void p(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254204);
        finderThumbPlayerProxy.dFq();
        AppMethodBeat.o(254204);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.finder.video.reporter.a r(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254205);
        com.tencent.mm.plugin.finder.video.reporter.a fTPPKVReporter = finderThumbPlayerProxy.getFTPPKVReporter();
        AppMethodBeat.o(254205);
        return fTPPKVReporter;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.finder.video.log.a t(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254206);
        com.tencent.mm.plugin.finder.video.log.a fTPPLog = finderThumbPlayerProxy.getFTPPLog();
        AppMethodBeat.o(254206);
        return fTPPLog;
    }

    public static final /* synthetic */ void u(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        AppMethodBeat.i(254207);
        finderThumbPlayerProxy.oN(true);
        AppMethodBeat.o(254207);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$Companion;", "", "()V", "NOTIFY_BUFFERING_START_DELAY_MS", "", "NOTIFY_PROGRESS_INTERVAL_MS", "NOTIFY_PROGRESS_TIMER_TAG", "", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "currentKeepProxySet", "Ljava/util/HashSet;", "", "getCurrentKeepProxySet", "()Ljava/util/HashSet;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(254193);
        AppMethodBeat.o(254193);
    }

    public final MediaPreloadCore getMediaPreloadCore$plugin_finder_release() {
        return this.wdG;
    }

    public final void setMediaPreloadCore$plugin_finder_release(MediaPreloadCore mediaPreloadCore) {
        this.wdG = mediaPreloadCore;
    }

    public final void setFullScreen(boolean z) {
        this.onr = z;
    }

    public final u getOnPlayerStopListener() {
        return this.wdP;
    }

    public final void setOnPlayerStopListener(u uVar) {
        this.wdP = uVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderThumbPlayerProxy(Context context) {
        super(context);
        boolean z;
        p.h(context, "context");
        AppMethodBeat.i(254190);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvT().value().intValue() == 1) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drB()) {
                z = true;
                this.wdB = z;
                this.wdI = true;
                this.wdK = kotlin.g.ah(d.wei);
                this.wdL = kotlin.g.ah(e.wej);
                this.hAk = new MMHandler(Looper.getMainLooper());
                this.wdQ = new AtomicBoolean(true);
                init();
                AppMethodBeat.o(254190);
            }
        }
        z = false;
        this.wdB = z;
        this.wdI = true;
        this.wdK = kotlin.g.ah(d.wei);
        this.wdL = kotlin.g.ah(e.wej);
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.wdQ = new AtomicBoolean(true);
        init();
        AppMethodBeat.o(254190);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderThumbPlayerProxy(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        p.h(context, "context");
        AppMethodBeat.i(254191);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvT().value().intValue() == 1) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drB()) {
                z = true;
                this.wdB = z;
                this.wdI = true;
                this.wdK = kotlin.g.ah(d.wei);
                this.wdL = kotlin.g.ah(e.wej);
                this.hAk = new MMHandler(Looper.getMainLooper());
                this.wdQ = new AtomicBoolean(true);
                init();
                AppMethodBeat.o(254191);
            }
        }
        z = false;
        this.wdB = z;
        this.wdI = true;
        this.wdK = kotlin.g.ah(d.wei);
        this.wdL = kotlin.g.ah(e.wej);
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.wdQ = new AtomicBoolean(true);
        init();
        AppMethodBeat.o(254191);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderThumbPlayerProxy(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z;
        p.h(context, "context");
        AppMethodBeat.i(254192);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvT().value().intValue() == 1) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drB()) {
                z = true;
                this.wdB = z;
                this.wdI = true;
                this.wdK = kotlin.g.ah(d.wei);
                this.wdL = kotlin.g.ah(e.wej);
                this.hAk = new MMHandler(Looper.getMainLooper());
                this.wdQ = new AtomicBoolean(true);
                init();
                AppMethodBeat.o(254192);
            }
        }
        z = false;
        this.wdB = z;
        this.wdI = true;
        this.wdK = kotlin.g.ah(d.wei);
        this.wdL = kotlin.g.ah(e.wej);
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.wdQ = new AtomicBoolean(true);
        init();
        AppMethodBeat.o(254192);
    }

    private final void init() {
        AppMethodBeat.i(254148);
        wdW.add(Integer.valueOf(hashCode()));
        Log.i(TAG, "create FinderThumbPlayerProxy " + hashCode() + ' ' + wdW);
        com.tencent.tmediacodec.e.b bVar = com.tencent.tmediacodec.e.b.SmK;
        bVar.SmJ = b.a.SAME;
        com.tencent.tmediacodec.a hpn = com.tencent.tmediacodec.a.hpn();
        p.g(hpn, "TCodecManager.getInstance()");
        hpn.a(bVar);
        com.tencent.tmediacodec.a hpn2 = com.tencent.tmediacodec.a.hpn();
        p.g(hpn2, "TCodecManager.getInstance()");
        hpn2.hpo();
        d.a aVar = com.tencent.mm.plugin.thumbplayer.e.d.GhZ;
        Context context = getContext();
        p.g(context, "context");
        Context applicationContext = context.getApplicationContext();
        p.g(applicationContext, "context.applicationContext");
        this.wdC = d.a.ht(applicationContext);
        this.wdD = new c();
        this.tHS = new com.tencent.mm.plugin.finder.video.reporter.c(this.wdB ? 1 : 0);
        Context context2 = getContext();
        p.g(context2, "context");
        this.wdE = new MMThumbPlayerTextureView(context2.getApplicationContext());
        MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        mMThumbPlayerTextureView.setOpaqueInfo(true);
        MMThumbPlayerTextureView mMThumbPlayerTextureView2 = this.wdE;
        if (mMThumbPlayerTextureView2 == null) {
            p.btv("textureView");
        }
        c cVar = this.wdD;
        if (cVar == null) {
            p.btv("playerListener");
        }
        mMThumbPlayerTextureView2.setTextureListenerCallback(cVar);
        com.tencent.mm.plugin.thumbplayer.e.a aVar2 = this.wdC;
        if (aVar2 == null) {
            p.btv("player");
        }
        c cVar2 = this.wdD;
        if (cVar2 == null) {
            p.btv("playerListener");
        }
        aVar2.setOnErrorListener(cVar2);
        com.tencent.mm.plugin.thumbplayer.e.a aVar3 = this.wdC;
        if (aVar3 == null) {
            p.btv("player");
        }
        c cVar3 = this.wdD;
        if (cVar3 == null) {
            p.btv("playerListener");
        }
        aVar3.setOnPreparedListener(cVar3);
        com.tencent.mm.plugin.thumbplayer.e.a aVar4 = this.wdC;
        if (aVar4 == null) {
            p.btv("player");
        }
        c cVar4 = this.wdD;
        if (cVar4 == null) {
            p.btv("playerListener");
        }
        aVar4.setOnVideoSizeChangedListener(cVar4);
        com.tencent.mm.plugin.thumbplayer.e.a aVar5 = this.wdC;
        if (aVar5 == null) {
            p.btv("player");
        }
        c cVar5 = this.wdD;
        if (cVar5 == null) {
            p.btv("playerListener");
        }
        aVar5.setOnPlayerStateChangeListener(cVar5);
        com.tencent.mm.plugin.thumbplayer.e.a aVar6 = this.wdC;
        if (aVar6 == null) {
            p.btv("player");
        }
        c cVar6 = this.wdD;
        if (cVar6 == null) {
            p.btv("playerListener");
        }
        aVar6.setOnInfoListener(cVar6);
        AppMethodBeat.o(254148);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void a(s sVar, boolean z, FeedData feedData) {
        com.tencent.mm.plugin.finder.video.source.b bVar;
        String str;
        r<Integer, Integer, Integer> g2;
        aty aty;
        AppMethodBeat.i(254149);
        p.h(sVar, "video");
        p.h(feedData, "feedData");
        if (z) {
            String str2 = sVar.uIw.url;
            if (str2 == null) {
                str2 = "";
            }
            bVar = new com.tencent.mm.plugin.finder.video.source.a("", str2, sVar.auA(), sVar.uIw, sVar, feedData);
        } else {
            bVar = new com.tencent.mm.plugin.finder.video.source.b(sVar.getUrl(), sVar.getPath(), sVar.auA(), sVar.uIw, sVar, feedData);
        }
        this.tHL = bVar;
        b bVar2 = this.wdH;
        if (bVar2 != null) {
            str = bVar2.mediaId;
        } else {
            str = null;
        }
        s sVar2 = this.tHL;
        if (sVar2 == null) {
            p.hyc();
        }
        if (!p.j(str, sVar2.mediaId)) {
            s sVar3 = this.tHL;
            if (sVar3 == null) {
                p.hyc();
            }
            String str3 = sVar3.mediaId;
            s sVar4 = this.tHL;
            if (sVar4 == null) {
                p.hyc();
            }
            this.wdH = new b(this, str3, sVar4);
            Log.i(TAG, "setVideoMediaInfo(), init proxy " + this.wdH);
        } else {
            Log.w(TAG, "setVideoMediaInfo(), duplicated mediaId " + this.wdH);
        }
        s sVar5 = this.tHL;
        if (sVar5 == null) {
            p.hyc();
        }
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
        if (this.isLongVideo) {
            y yVar = y.vXH;
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(254149);
                throw tVar;
            }
            g2 = y.a((Activity) context, sVar5.tHN.uIw.width, sVar5.tHN.uIw.height);
        } else {
            Size a2 = com.tencent.mm.plugin.finder.storage.data.j.a(sVar5.tHN.uIw, this.onr);
            y yVar2 = y.vXH;
            Context context2 = getContext();
            if (context2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(254149);
                throw tVar2;
            }
            g2 = y.g((Activity) context2, a2.getWidth(), a2.getHeight());
        }
        int intValue = g2.second.intValue();
        int intValue2 = g2.SWY.intValue();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        MMThumbPlayerTextureView mMThumbPlayerTextureView3 = this.wdE;
        if (mMThumbPlayerTextureView3 == null) {
            p.btv("textureView");
        }
        addView(mMThumbPlayerTextureView3, layoutParams);
        MMThumbPlayerTextureView mMThumbPlayerTextureView4 = this.wdE;
        if (mMThumbPlayerTextureView4 == null) {
            p.btv("textureView");
        }
        mMThumbPlayerTextureView4.jk(intValue, intValue2);
        cjl cjl = sVar5.wgl;
        if (!(cjl == null || (aty = cjl.MoU) == null)) {
            MMThumbPlayerTextureView mMThumbPlayerTextureView5 = this.wdE;
            if (mMThumbPlayerTextureView5 == null) {
                p.btv("textureView");
            }
            mMThumbPlayerTextureView5.setCropRect(new Rect((int) aty.left, (int) aty.top, (int) aty.right, (int) aty.bottom));
            MMThumbPlayerTextureView mMThumbPlayerTextureView6 = this.wdE;
            if (mMThumbPlayerTextureView6 == null) {
                p.btv("textureView");
            }
            float f2 = sVar5.wgl.width;
            float f3 = sVar5.wgl.height;
            mMThumbPlayerTextureView6.Giu = f2;
            mMThumbPlayerTextureView6.Giv = f3;
        }
        Log.i(TAG, "initTextureView(), isLongVideo:" + this.isLongVideo + " containerWidth:" + intValue + " containerHeight:" + intValue2 + ' ' + dFm());
        AppMethodBeat.o(254149);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final s getVideoMediaInfo() {
        return this.tHL;
    }

    private final String dFm() {
        int i2;
        String str;
        AppMethodBeat.i(254150);
        StringBuilder sb = new StringBuilder("loader:");
        b bVar = this.wdH;
        if (bVar != null) {
            i2 = bVar.hashCode();
        } else {
            i2 = 0;
        }
        StringBuilder append = sb.append(i2).append(" proxy:").append(hashCode()).append(" mediaId: ");
        s sVar = this.tHL;
        if (sVar == null || (str = sVar.mediaId) == null) {
            str = "";
        }
        StringBuilder append2 = append.append(str).append(" player:");
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        StringBuilder append3 = append2.append(aVar.hashCode()).append(" viewFocus:").append(this.wcA).append(" alpha:").append(getAlpha()).append(" surface:");
        Surface surface2 = this.surface;
        String sb2 = append3.append(surface2 != null ? Boolean.valueOf(surface2.isValid()) : null).append(" currentPlayState:").append(this.currentPlayState).toString();
        AppMethodBeat.o(254150);
        return sb2;
    }

    private final void oM(boolean z) {
        AppMethodBeat.i(254151);
        Log.i(TAG, "releaseSurface " + dFm());
        if (this.surface != null) {
            com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
            if (aVar == null) {
                p.btv("player");
            }
            aVar.setSurface(null);
            Surface surface2 = this.surface;
            if (surface2 != null) {
                surface2.release();
            }
            if (z) {
                MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
                if (mMThumbPlayerTextureView == null) {
                    p.btv("textureView");
                }
                mMThumbPlayerTextureView.fxg();
            }
            this.surface = null;
        }
        AppMethodBeat.o(254151);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final Bitmap getBitmap() {
        AppMethodBeat.i(254152);
        MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        Bitmap bitmap = mMThumbPlayerTextureView.getBitmap();
        AppMethodBeat.o(254152);
        return bitmap;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final String getVideoMediaId() {
        String str;
        s sVar = this.tHL;
        return (sVar == null || (str = sVar.mediaId) == null) ? "" : str;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int getCurrentPlaySecond() {
        AppMethodBeat.i(254153);
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        int currentPositionMs = (int) (aVar.getCurrentPositionMs() / 1000);
        AppMethodBeat.o(254153);
        return currentPositionMs;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final long getCurrentPlayMs() {
        AppMethodBeat.i(254154);
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        long currentPositionMs = aVar.getCurrentPositionMs();
        AppMethodBeat.o(254154);
        return currentPositionMs;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int getVideoDuration() {
        AppMethodBeat.i(254155);
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        int durationMs = (int) (aVar.getDurationMs() / 1000);
        AppMethodBeat.o(254155);
        return durationMs;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final long getVideoDurationMs() {
        AppMethodBeat.i(254156);
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        long durationMs = aVar.getDurationMs();
        AppMethodBeat.o(254156);
        return durationMs;
    }

    public final void setViewFocused(boolean z) {
        this.wcA = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getVideoViewFocused() {
        return this.wcA;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final View getVideoView() {
        return this;
    }

    public final void setShouldPlayResume(boolean z) {
        this.wcB = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getIsShouldPlayResume() {
        return this.wcB;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final ViewParent getParentView() {
        AppMethodBeat.i(254158);
        ViewParent parent = getParent();
        AppMethodBeat.o(254158);
        return parent;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIsShouldPlayResume(boolean z) {
        AppMethodBeat.i(254159);
        Log.i(TAG, "setIsShouldPlayResume() " + z + ' ' + dFm());
        this.wcB = z;
        AppMethodBeat.o(254159);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoViewFocused(boolean z) {
        AppMethodBeat.i(254160);
        Log.i(TAG, "setVideoViewFocused " + z + ' ' + dFm());
        this.wcA = z;
        AppMethodBeat.o(254160);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setPreview(boolean z) {
        this.sZd = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dEO() {
        return this.sZd;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setInterceptDetach(boolean z) {
        AppMethodBeat.i(254161);
        MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        mMThumbPlayerTextureView.setInterceptDetach(z);
        AppMethodBeat.o(254161);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean play() {
        AppMethodBeat.i(254162);
        Log.i(TAG, "play()");
        boolean Mc = Mc(0);
        AppMethodBeat.o(254162);
        return Mc;
    }

    public final boolean Mc(int i2) {
        AppMethodBeat.i(254163);
        Log.i(TAG, "playWithSource() source=" + i2 + ' ' + dFm() + ' ');
        if (!this.wcA) {
            Log.i(TAG, "playWithSource() return for isViewFocused:" + this.wcA);
            AppMethodBeat.o(254163);
            return false;
        } else if (!Me(this.currentPlayState)) {
            Log.i(TAG, "playWithSource() return for currentState:" + this.currentPlayState);
            AppMethodBeat.o(254163);
            return false;
        } else {
            boolean isPlaying = isPlaying();
            if (isPlaying) {
                Log.i(TAG, "playWithSource() return for isPlaying:".concat(String.valueOf(isPlaying)));
                AppMethodBeat.o(254163);
                return false;
            }
            if (asa()) {
                Surface surface2 = this.surface;
                if (surface2 != null) {
                    if (!surface2.isValid()) {
                        surface2 = null;
                    }
                    if (surface2 != null) {
                        dFn();
                    }
                }
            } else if (!dFr()) {
                Md(0);
            }
            dFo();
            com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
            if (aVar == null) {
                p.btv("player");
            }
            aVar.resumeDownload();
            AppMethodBeat.o(254163);
            return true;
        }
    }

    private final void dFn() {
        AppMethodBeat.i(254164);
        Log.i(TAG, "realPlay() " + dFm());
        setBgPrepareStatus(0);
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        aVar.start();
        s sVar = this.tHL;
        if (sVar != null) {
            a(sVar);
            AppMethodBeat.o(254164);
            return;
        }
        AppMethodBeat.o(254164);
    }

    private final boolean Md(int i2) {
        Boolean bool;
        String str;
        at atVar;
        at atVar2;
        at atVar3;
        Surface surface2 = null;
        AppMethodBeat.i(254165);
        String str2 = TAG;
        StringBuilder append = new StringBuilder("prepareVideo() source:").append(i2).append(" isMoovReady:");
        b bVar = this.wdH;
        StringBuilder append2 = append.append((bVar == null || (atVar3 = bVar.uJG) == null) ? null : Boolean.valueOf(atVar3.field_moovReady)).append(' ').append("isAllCompleted:");
        b bVar2 = this.wdH;
        if (bVar2 == null || (atVar2 = bVar2.uJG) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(atVar2.dkN());
        }
        StringBuilder append3 = append2.append(bool).append(' ').append("downloadUrl:");
        s sVar = this.tHL;
        if (sVar != null) {
            str = sVar.downloadUrl;
        } else {
            str = null;
        }
        Log.i(str2, append3.append(str).append(' ').append(dFm()).toString());
        b bVar3 = this.wdH;
        if (bVar3 != null) {
            bVar3.dFt();
        }
        b bVar4 = this.wdH;
        if (bVar4 == null || (atVar = bVar4.uJG) == null || (!atVar.field_moovReady && !atVar.dkN() && !(this.tHL instanceof com.tencent.mm.plugin.finder.video.source.a))) {
            AppMethodBeat.o(254165);
            return false;
        }
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        aVar.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(123, this.wdB));
        com.tencent.mm.plugin.thumbplayer.e.a aVar2 = this.wdC;
        if (aVar2 == null) {
            p.btv("player");
        }
        aVar2.enableTPAssetResourceLoader(this.wdH);
        Surface surface3 = this.surface;
        if (surface3 != null) {
            if (surface3.isValid()) {
                surface2 = surface3;
            }
            if (surface2 != null) {
                com.tencent.mm.plugin.thumbplayer.e.a aVar3 = this.wdC;
                if (aVar3 == null) {
                    p.btv("player");
                }
                aVar3.setSurface(surface2);
            }
        }
        com.tencent.mm.plugin.thumbplayer.e.a aVar4 = this.wdC;
        if (aVar4 == null) {
            p.btv("player");
        }
        aVar4.prepareAsync();
        AppMethodBeat.o(254165);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dFj() {
        at atVar;
        AppMethodBeat.i(254166);
        Log.i(TAG, "startOrPlay() " + dFm());
        if (!this.wcA) {
            Log.i(TAG, "startOrPlay() return for isViewFocused:" + this.wcA);
            AppMethodBeat.o(254166);
            return false;
        }
        if (this.wdI) {
            Log.i(TAG, "startOrPlay() first time to play");
            y yVar = this.wcw;
            if (yVar != null) {
                yVar.a(this.tHS);
            }
            y yVar2 = this.wcw;
            if (yVar2 != null) {
                yVar2.a(this.tHL, this.wdJ);
            }
            this.wdI = false;
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1505, 252, 1);
        }
        if (Me(this.currentPlayState)) {
            Log.i(TAG, "startOrPlay() return for currentPlayState:" + this.currentPlayState);
            if (Mc(3)) {
                this.wdO = 0;
            }
            AppMethodBeat.o(254166);
            return false;
        }
        b bVar = this.wdH;
        if (bVar != null) {
            bVar.dFt();
        }
        y yVar3 = y.vXH;
        s sVar = this.tHL;
        b bVar2 = this.wdH;
        b bVar3 = this.wdH;
        if (bVar3 != null) {
            atVar = bVar3.uJG;
        } else {
            atVar = null;
        }
        if (sVar == null || bVar2 == null || atVar == null) {
            AppMethodBeat.o(254166);
            return false;
        }
        boolean dkN = atVar.dkN();
        boolean YS = com.tencent.mm.vfs.s.YS(sVar.path);
        Log.i(TAG, "startOrPlay() isAllCompleted:" + dkN + " isExist:" + YS + ' ' + dFm());
        this.wdO = 0;
        if (sVar instanceof com.tencent.mm.plugin.finder.video.source.a) {
            O(sVar.mediaId, sVar.path, 41);
        } else if (!(sVar instanceof com.tencent.mm.plugin.finder.video.source.b) || !dkN || !YS) {
            dFo();
            hj(sVar.mediaId, sVar.downloadUrl);
        } else {
            O(sVar.mediaId, sVar.path, 42);
        }
        AppMethodBeat.o(254166);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dEN() {
        at atVar;
        AppMethodBeat.i(254167);
        if (this.wcA) {
            Log.i(TAG, "prepareToPlay() return for isViewFocused:" + this.wcA);
            AppMethodBeat.o(254167);
            return false;
        }
        Log.i(TAG, "prepareToPlay()  " + dFm());
        if (!Me(this.currentPlayState)) {
            b bVar = this.wdH;
            if (bVar != null) {
                bVar.dFt();
            }
            y yVar = y.vXH;
            s sVar = this.tHL;
            b bVar2 = this.wdH;
            b bVar3 = this.wdH;
            if (bVar3 != null) {
                atVar = bVar3.uJG;
            } else {
                atVar = null;
            }
            if (sVar == null || bVar2 == null || atVar == null) {
                AppMethodBeat.o(254167);
                return false;
            }
            boolean dkN = atVar.dkN();
            boolean YS = com.tencent.mm.vfs.s.YS(sVar.path);
            Log.i(TAG, "prepareToPlay() isAllCompleted:" + dkN + " isExist:" + YS + ' ' + dFm());
            if (sVar instanceof com.tencent.mm.plugin.finder.video.source.a) {
                O(sVar.mediaId, sVar.path, 21);
            } else if (!(sVar instanceof com.tencent.mm.plugin.finder.video.source.b) || !dkN || !YS) {
                boolean hj = hj(sVar.mediaId, sVar.downloadUrl);
                AppMethodBeat.o(254167);
                return hj;
            } else {
                O(sVar.mediaId, sVar.path, 22);
            }
            AppMethodBeat.o(254167);
            return true;
        } else if (this.currentPlayState == 2) {
            boolean Md = Md(1);
            AppMethodBeat.o(254167);
            return Md;
        } else {
            AppMethodBeat.o(254167);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setFinderVideoCore(k kVar) {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int dFk() {
        AppMethodBeat.i(254169);
        Log.i(TAG, "pauseWithCancel " + dFm());
        pause();
        AppMethodBeat.o(254169);
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void stop() {
        AppMethodBeat.i(254170);
        Log.i(TAG, "stop() " + dFm());
        if (!Me(this.currentPlayState)) {
            Log.i(TAG, "stop() return for isStartPlay.");
            u uVar = this.wdP;
            if (uVar != null) {
                uVar.dFR();
                AppMethodBeat.o(254170);
                return;
            }
            AppMethodBeat.o(254170);
            return;
        }
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.b(this.tHL);
        }
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        aVar.stop();
        com.tencent.mm.plugin.thumbplayer.e.a aVar2 = this.wdC;
        if (aVar2 == null) {
            p.btv("player");
        }
        aVar2.reset();
        getFTPPLog().reset();
        MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
        if (mMThumbPlayerTextureView == null) {
            p.btv("textureView");
        }
        mMThumbPlayerTextureView.reset();
        dFs();
        dFp();
        dFq();
        this.wdI = true;
        this.wdF = false;
        this.tHS = null;
        setBgPrepareStatus(0);
        Log.i(TAG, "stop() end");
        AppMethodBeat.o(254170);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void onUIDestroy() {
        AppMethodBeat.i(254171);
        Log.i(TAG, "onUIDestroy " + dFm());
        stop();
        AppMethodBeat.o(254171);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setMute(boolean z) {
        AppMethodBeat.i(254173);
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        aVar.setOutputMute(z);
        AppMethodBeat.o(254173);
    }

    public final i.b getVideoViewCallback() {
        return this.wcv;
    }

    public final void setVideoViewCallback(i.b bVar) {
        this.wcv = bVar;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIMMVideoViewCallback(i.b bVar) {
        AppMethodBeat.i(254174);
        p.h(bVar, "_callback");
        this.wcv = bVar;
        AppMethodBeat.o(254174);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setScaleType(i.e eVar) {
        AppMethodBeat.i(254175);
        p.h(eVar, "scaleType");
        switch (i.$EnumSwitchMapping$0[eVar.ordinal()]) {
            case 1:
                MMThumbPlayerTextureView mMThumbPlayerTextureView = this.wdE;
                if (mMThumbPlayerTextureView == null) {
                    p.btv("textureView");
                }
                MMThumbPlayerTextureView.a aVar = MMThumbPlayerTextureView.GiC;
                mMThumbPlayerTextureView.setScaleType(MMThumbPlayerTextureView.fxh());
                AppMethodBeat.o(254175);
                return;
            case 2:
                MMThumbPlayerTextureView mMThumbPlayerTextureView2 = this.wdE;
                if (mMThumbPlayerTextureView2 == null) {
                    p.btv("textureView");
                }
                MMThumbPlayerTextureView.a aVar2 = MMThumbPlayerTextureView.GiC;
                mMThumbPlayerTextureView2.setScaleType(MMThumbPlayerTextureView.fxi());
                AppMethodBeat.o(254175);
                return;
            case 3:
                MMThumbPlayerTextureView mMThumbPlayerTextureView3 = this.wdE;
                if (mMThumbPlayerTextureView3 == null) {
                    p.btv("textureView");
                }
                MMThumbPlayerTextureView.a aVar3 = MMThumbPlayerTextureView.GiC;
                mMThumbPlayerTextureView3.setScaleType(MMThumbPlayerTextureView.fxk());
                break;
        }
        AppMethodBeat.o(254175);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b bVar) {
        AppMethodBeat.i(254176);
        p.h(bVar, "_proxy");
        AppMethodBeat.o(254176);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void dFl() {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIsShowBasicControls(boolean z) {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setLoop(boolean z) {
        AppMethodBeat.i(254177);
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        aVar.setLoopback(z);
        AppMethodBeat.o(254177);
    }

    public final y getLifecycle() {
        return this.wcw;
    }

    public final void setLifecycle(y yVar) {
        this.wcw = yVar;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoPlayLifecycle(y yVar) {
        AppMethodBeat.i(254178);
        p.h(yVar, "lifecycle");
        this.wcw = yVar;
        AppMethodBeat.o(254178);
    }

    public final t getOnMuteListener() {
        return this.wdS;
    }

    public final void setOnMuteListener(t tVar) {
        this.wdS = tVar;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoMuteListener(t tVar) {
        AppMethodBeat.i(254179);
        p.h(tVar, "muteListener");
        this.wdS = tVar;
        AppMethodBeat.o(254179);
    }

    private final void oN(boolean z) {
        AppMethodBeat.i(254180);
        Log.i(TAG, "updateIsReaStartDownloader() isReaStartDownloader:".concat(String.valueOf(z)));
        this.wdQ.set(z);
        AppMethodBeat.o(254180);
    }

    public final x getDownloadCallback() {
        return this.wdT;
    }

    public final void setDownloadCallback(x xVar) {
        this.wdT = xVar;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void onRelease() {
        AppMethodBeat.i(254181);
        Log.i(TAG, "release FinderThumbPlayerProxy " + dFm());
        oM(true);
        this.wdT = null;
        this.wdH = null;
        com.tencent.mm.ac.d.c(TAG, new g(this));
        wdW.remove(Integer.valueOf(hashCode()));
        AppMethodBeat.o(254181);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean isPlaying() {
        return this.currentPlayState == 5;
    }

    private final void getFTPPTag() {
    }

    private final void O(String str, String str2, int i2) {
        AppMethodBeat.i(254182);
        if (TextUtils.isEmpty(str2)) {
            Log.w(TAG, "prepareCacheFile(), return for online url:".concat(String.valueOf(str2)));
            AppMethodBeat.o(254182);
            return;
        }
        String k2 = com.tencent.mm.vfs.s.k(str2, false);
        Log.i(TAG, "prepareCacheFile(), cache file:" + k2 + ", isExists:" + com.tencent.mm.vfs.s.YS(k2) + ' ' + dFm());
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        aVar.setMediaId(str);
        com.tencent.mm.plugin.thumbplayer.e.a aVar2 = this.wdC;
        if (aVar2 == null) {
            p.btv("player");
        }
        aVar2.setDataSource(k2);
        Md(i2);
        AppMethodBeat.o(254182);
    }

    private final boolean hj(String str, String str2) {
        AppMethodBeat.i(254183);
        if (TextUtils.isEmpty(str2)) {
            Log.w(TAG, "prepareOnlineUrl(), return for online url:" + str2 + "  " + dFm());
            AppMethodBeat.o(254183);
            return false;
        }
        Log.i(TAG, "prepareOnlineUrl(), online url:" + str2 + "  " + dFm());
        TPVideoInfo.Builder builder = new TPVideoInfo.Builder();
        builder.fileId(str);
        builder.downloadParam(new TPDownloadParamData(11));
        com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
        if (aVar == null) {
            p.btv("player");
        }
        aVar.setMediaId(str);
        com.tencent.mm.plugin.thumbplayer.e.a aVar2 = this.wdC;
        if (aVar2 == null) {
            p.btv("player");
        }
        aVar2.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000));
        com.tencent.mm.plugin.thumbplayer.e.a aVar3 = this.wdC;
        if (aVar3 == null) {
            p.btv("player");
        }
        aVar3.setVideoInfo(builder.build());
        com.tencent.mm.plugin.thumbplayer.e.a aVar4 = this.wdC;
        if (aVar4 == null) {
            p.btv("player");
        }
        aVar4.setDataSource(str2);
        boolean Md = Md(5);
        AppMethodBeat.o(254183);
        return Md;
    }

    public final void setStartCdn(boolean z) {
        this.wdU = z;
    }

    private final void dFo() {
        at atVar;
        MediaPreloadCore mediaPreloadCore;
        AppMethodBeat.i(254184);
        Log.i(TAG, "startCdnDownload()");
        if (this.wdU) {
            Log.i(TAG, "startCdnDownload() already start cdn " + dFm());
            AppMethodBeat.o(254184);
            return;
        }
        dFq();
        y yVar = y.vXH;
        b bVar = this.wdH;
        b bVar2 = this.wdH;
        if (bVar2 != null) {
            atVar = bVar2.uJG;
        } else {
            atVar = null;
        }
        if (!(bVar == null || atVar == null)) {
            Log.i(TAG, "startCdnDownload() " + dFm());
            MediaPreloadCore mediaPreloadCore2 = this.wdG;
            if (mediaPreloadCore2 != null) {
                mediaPreloadCore2.bm(bVar.mediaId, true);
            }
            if (!atVar.dkN()) {
                if (this.wdR && (mediaPreloadCore = this.wdG) != null) {
                    mediaPreloadCore.aup(bVar.mediaId);
                }
                oN(false);
                ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(bVar.mediaId, new i(bVar), new h(this));
                this.wdU = true;
                s sVar = this.tHL;
                if (sVar != null) {
                    x xVar = this.wdT;
                    if (xVar != null) {
                        xVar.b(sVar.tHN);
                        AppMethodBeat.o(254184);
                        return;
                    }
                    AppMethodBeat.o(254184);
                    return;
                }
                AppMethodBeat.o(254184);
                return;
            }
            Log.i(TAG, "startCdnDownload() downloadFinish " + dFm());
        }
        AppMethodBeat.o(254184);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
    public static final class i implements com.tencent.mm.plugin.thumbplayer.b.b {
        final /* synthetic */ b wek;

        i(b bVar) {
            this.wek = bVar;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.b
        public final com.tencent.mm.i.h awH(String str) {
            String str2;
            boolean z = true;
            AppMethodBeat.i(254140);
            p.h(str, "id");
            b bVar = this.wek;
            y yVar = y.vXH;
            String str3 = bVar.mediaId;
            String str4 = bVar.wcy.downloadUrl;
            if (str4 == null) {
                str4 = "";
            }
            String str5 = bVar.wcy.path;
            s sVar = bVar.wcy;
            if (sVar != null) {
                str2 = sVar.path;
            } else {
                str2 = null;
            }
            int L = com.tencent.mm.modelcontrol.e.L(1, str2);
            String str6 = bVar.uJG.field_fileFormat;
            if (str6 == null) {
                str6 = "";
            }
            String djW = bVar.wcy.tHN.djW();
            String str7 = bVar.wcy.tHN.uIw.decodeKey;
            if (str7 == null) {
                str7 = "";
            }
            if (bVar.wcy.tHN.uIw.hot_flag != 1) {
                z = false;
            }
            a aVar = FinderThumbPlayerProxy.wdX;
            com.tencent.mm.i.h a2 = y.a(str3, str4, str5, L, str6, djW, str7, z, bVar, FinderThumbPlayerProxy.TAG);
            AppMethodBeat.o(254140);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
    public static final class h implements com.tencent.mm.plugin.thumbplayer.b.e {
        final /* synthetic */ FinderThumbPlayerProxy weg;

        h(FinderThumbPlayerProxy finderThumbPlayerProxy) {
            this.weg = finderThumbPlayerProxy;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.e
        public final void JS(int i2) {
            AppMethodBeat.i(254139);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "startCdnDownload()#onStart " + FinderThumbPlayerProxy.a(this.weg) + ' ' + i2);
            FinderThumbPlayerProxy.u(this.weg);
            AppMethodBeat.o(254139);
        }
    }

    private final void dFp() {
        AppMethodBeat.i(254185);
        Log.i(TAG, "stopCdnDownload()");
        if (!this.wdU) {
            Log.i(TAG, "stopCdnDownload() not start cdn " + dFm());
            AppMethodBeat.o(254185);
            return;
        }
        b bVar = this.wdH;
        if (bVar != null) {
            Log.i(TAG, "stopCdnDownload() " + dFm());
            MediaPreloadCore mediaPreloadCore = this.wdG;
            if (mediaPreloadCore != null) {
                mediaPreloadCore.bm(bVar.mediaId, false);
            }
            bVar.oO(false);
            ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(bVar.mediaId, new m(this));
            this.wdU = false;
            AppMethodBeat.o(254185);
            return;
        }
        AppMethodBeat.o(254185);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
    public static final class m implements com.tencent.mm.plugin.thumbplayer.b.g {
        final /* synthetic */ FinderThumbPlayerProxy weg;

        m(FinderThumbPlayerProxy finderThumbPlayerProxy) {
            this.weg = finderThumbPlayerProxy;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.g
        public final void a(int i2, com.tencent.mm.i.h hVar, com.tencent.mm.i.d dVar) {
            x downloadCallback;
            AppMethodBeat.i(254144);
            s sVar = this.weg.tHL;
            if (!(sVar == null || (downloadCallback = this.weg.getDownloadCallback()) == null)) {
                downloadCallback.a(sVar.tHN, hVar, dVar);
            }
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "stopCdnDownload()#onStop(), real cancel download task " + FinderThumbPlayerProxy.a(this.weg) + ' ' + i2);
            AppMethodBeat.o(254144);
        }
    }

    public final void setStartCdnPreload(boolean z) {
        this.wdV = z;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
    public static final class k implements com.tencent.mm.plugin.thumbplayer.b.b {
        final /* synthetic */ b wel;

        k(b bVar) {
            this.wel = bVar;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.b
        public final com.tencent.mm.i.h awH(String str) {
            String str2;
            AppMethodBeat.i(254142);
            p.h(str, "id");
            b bVar = this.wel;
            long j2 = bVar.uJG.field_totalSize;
            if (j2 == 0) {
                AppMethodBeat.o(254142);
                return null;
            }
            y yVar = y.vXH;
            String str3 = bVar.mediaId;
            String str4 = bVar.wcy.downloadUrl;
            if (str4 == null) {
                str4 = "";
            }
            String str5 = bVar.wcy.path;
            s sVar = bVar.wcy;
            if (sVar != null) {
                str2 = sVar.path;
            } else {
                str2 = null;
            }
            int L = com.tencent.mm.modelcontrol.e.L(1, str2);
            String str6 = bVar.uJG.field_fileFormat;
            if (str6 == null) {
                str6 = "";
            }
            String djW = bVar.wcy.tHN.djW();
            String str7 = bVar.wcy.tHN.uIw.decodeKey;
            if (str7 == null) {
                str7 = "";
            }
            boolean z = bVar.wcy.tHN.uIw.hot_flag == 1;
            b bVar2 = bVar;
            b bVar3 = bVar;
            int i2 = (int) ((bVar.wef * 100) / j2);
            long j3 = bVar.wef;
            a aVar = FinderThumbPlayerProxy.wdX;
            com.tencent.mm.i.h a2 = y.a(str3, str4, str5, L, str6, djW, str7, z, bVar2, bVar3, i2, j3, FinderThumbPlayerProxy.TAG);
            AppMethodBeat.o(254142);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
    public static final class j implements com.tencent.mm.plugin.thumbplayer.b.d {
        final /* synthetic */ FinderThumbPlayerProxy weg;

        j(FinderThumbPlayerProxy finderThumbPlayerProxy) {
            this.weg = finderThumbPlayerProxy;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.d
        public final void JS(int i2) {
            AppMethodBeat.i(254141);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "startCdnPreload()#onStart(), real start download preload task " + FinderThumbPlayerProxy.a(this.weg) + ' ' + i2);
            if (i2 == -1) {
                FinderThumbPlayerProxy.p(this.weg);
            }
            AppMethodBeat.o(254141);
        }
    }

    private final void dFq() {
        AppMethodBeat.i(254186);
        Log.i(TAG, "stopCdnPreload()");
        if (!this.wdV) {
            Log.i(TAG, "stopCdnPreload(), not start preload cdn " + dFm());
            AppMethodBeat.o(254186);
            return;
        }
        b bVar = this.wdH;
        if (bVar != null) {
            ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(bVar.mediaId, new n(this));
            this.wdV = false;
            AppMethodBeat.o(254186);
            return;
        }
        AppMethodBeat.o(254186);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
    public static final class n implements com.tencent.mm.plugin.thumbplayer.b.f {
        final /* synthetic */ FinderThumbPlayerProxy weg;

        n(FinderThumbPlayerProxy finderThumbPlayerProxy) {
            this.weg = finderThumbPlayerProxy;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.f
        public final void JR(int i2) {
            AppMethodBeat.i(254145);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "stopCdnPreload()#onStop " + FinderThumbPlayerProxy.a(this.weg) + ' ' + i2);
            AppMethodBeat.o(254145);
        }
    }

    private static boolean Me(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    private final boolean dFr() {
        return this.currentPlayState == 3;
    }

    private final boolean asa() {
        switch (this.currentPlayState) {
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    private final void setBgPrepareStatus(int i2) {
        AppMethodBeat.i(254187);
        Log.i(TAG, "setBgPrepareStatus " + i2 + ' ' + dFm());
        this.wdJ = i2;
        AppMethodBeat.o(254187);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ String qWs;
        final /* synthetic */ FinderThumbPlayerProxy weg;

        f(FinderThumbPlayerProxy finderThumbPlayerProxy, String str) {
            this.weg = finderThumbPlayerProxy;
            this.qWs = str;
        }

        public final void run() {
            AppMethodBeat.i(254137);
            if (this.weg.wcA) {
                this.weg.bbU = true;
                i.b videoViewCallback = this.weg.getVideoViewCallback();
                if (videoViewCallback != null) {
                    videoViewCallback.dL("", this.qWs);
                    AppMethodBeat.o(254137);
                    return;
                }
            }
            AppMethodBeat.o(254137);
        }
    }

    private final void a(s sVar) {
        AppMethodBeat.i(254188);
        Log.i(TAG, "startProgressTimer " + dFm());
        if (this.wdM != null) {
            Log.w(TAG, "startProgressTimer return for :" + this.wdM);
            AppMethodBeat.o(254188);
            return;
        }
        this.wdM = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new l(this, sVar), true);
        MTimerHandler mTimerHandler = this.wdM;
        if (mTimerHandler != null) {
            mTimerHandler.setLogging(false);
        }
        MTimerHandler mTimerHandler2 = this.wdM;
        if (mTimerHandler2 != null) {
            mTimerHandler2.startTimer(0, 16);
            AppMethodBeat.o(254188);
            return;
        }
        AppMethodBeat.o(254188);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startProgressTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "lastNotifyMs", "", "getLastNotifyMs", "()J", "setLastNotifyMs", "(J)V", "onTimerExpired", "", "plugin-finder_release"})
    public static final class l implements MTimerHandler.CallBack {
        final /* synthetic */ FinderThumbPlayerProxy weg;
        private long wem = -1;
        final /* synthetic */ s wen;

        l(FinderThumbPlayerProxy finderThumbPlayerProxy, s sVar) {
            this.weg = finderThumbPlayerProxy;
            this.wen = sVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(254143);
            long currentPlayMs = this.weg.getCurrentPlayMs();
            long videoDurationMs = this.weg.getVideoDurationMs();
            y lifecycle = this.weg.getLifecycle();
            if (lifecycle != null) {
                lifecycle.dFO();
            }
            if (this.wem == -1 || currentPlayMs - this.wem > 1000) {
                y lifecycle2 = this.weg.getLifecycle();
                if (lifecycle2 != null) {
                    lifecycle2.a(this.wen.wgl, ((int) currentPlayMs) / 1000, ((int) videoDurationMs) / 1000);
                }
                this.wem = currentPlayMs;
            }
            AppMethodBeat.o(254143);
            return true;
        }
    }

    private final void dFs() {
        AppMethodBeat.i(254189);
        Log.i(TAG, "stopProgressTimer :" + this.wdM + ' ' + dFm());
        MTimerHandler mTimerHandler = this.wdM;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
        }
        this.wdM = null;
        AppMethodBeat.o(254189);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0005¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J0\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J4\u0010\u0014\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J \u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0017J\u0012\u0010!\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\"\u0010#\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0012\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u001eH\u0016J\"\u0010&\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0016¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$TPPlayerListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onStateChange", "preState", "curState", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "onVideoSizeChanged", "plugin-finder_release"})
    public final class c implements TextureView.SurfaceTextureListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Boolean bool = null;
            AppMethodBeat.i(254122);
            p.h(surfaceTexture, "surfaceTexture");
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onSurfaceTextureAvailable() width:" + i2 + " height:" + i3 + " surfaceTexture:" + surfaceTexture.hashCode() + ' ' + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
            if (FinderThumbPlayerProxy.this.surface != null) {
                a aVar2 = FinderThumbPlayerProxy.wdX;
                String str = FinderThumbPlayerProxy.TAG;
                StringBuilder sb = new StringBuilder("FTPP.onSurfaceTextureAvailable() return for surface:");
                Surface surface = FinderThumbPlayerProxy.this.surface;
                StringBuilder append = sb.append(surface != null ? Integer.valueOf(surface.hashCode()) : null).append(" valid:");
                Surface surface2 = FinderThumbPlayerProxy.this.surface;
                if (surface2 != null) {
                    bool = Boolean.valueOf(surface2.isValid());
                }
                Log.i(str, append.append(bool).toString());
                AppMethodBeat.o(254122);
                return;
            }
            FinderThumbPlayerProxy.this.surface = new Surface(surfaceTexture);
            FinderThumbPlayerProxy.c(FinderThumbPlayerProxy.this).setSurface(FinderThumbPlayerProxy.this.surface);
            FinderThumbPlayerProxy.this.Mc(1);
            AppMethodBeat.o(254122);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(254123);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onSurfaceTextureSizeChanged  surfaceTexture:" + (surfaceTexture != null ? surfaceTexture.hashCode() : 0) + ' ' + i2 + ' ' + i3 + ' ' + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
            AppMethodBeat.o(254123);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            int i2;
            AppMethodBeat.i(254124);
            a aVar = FinderThumbPlayerProxy.wdX;
            String str = FinderThumbPlayerProxy.TAG;
            StringBuilder sb = new StringBuilder("FTPP.onSurfaceTextureDestroyed() surfaceTexture:");
            if (surfaceTexture != null) {
                i2 = surfaceTexture.hashCode();
            } else {
                i2 = 0;
            }
            Log.i(str, sb.append(i2).append(' ').append(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this)).toString());
            FinderThumbPlayerProxy.d(FinderThumbPlayerProxy.this);
            AppMethodBeat.o(254124);
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            cjl cjl;
            AppMethodBeat.i(254125);
            FinderThumbPlayerProxy.this.wdO++;
            if (FinderThumbPlayerProxy.this.tHL == null) {
                a aVar = FinderThumbPlayerProxy.wdX;
                Log.w(FinderThumbPlayerProxy.TAG, "FTPP.onSurfaceTextureUpdated() return for  null.");
                AppMethodBeat.o(254125);
                return;
            }
            if (FinderThumbPlayerProxy.this.wdO == 1 && FinderThumbPlayerProxy.this.wdJ == 1) {
                a aVar2 = FinderThumbPlayerProxy.wdX;
                Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onSurfaceTextureUpdated() background prepared first frame " + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
                FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this, 2);
                y lifecycle = FinderThumbPlayerProxy.this.getLifecycle();
                if (lifecycle != null) {
                    s sVar = FinderThumbPlayerProxy.this.tHL;
                    if (sVar != null) {
                        cjl = sVar.wgl;
                    } else {
                        cjl = null;
                    }
                    lifecycle.l(cjl);
                }
            }
            if (FinderThumbPlayerProxy.this.wdO == 1 && FinderThumbPlayerProxy.this.wdJ == 0) {
                a aVar3 = FinderThumbPlayerProxy.wdX;
                Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onSurfaceTextureUpdated() onFirstFrameRendered " + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
                y lifecycle2 = FinderThumbPlayerProxy.this.getLifecycle();
                if (lifecycle2 != null) {
                    s unused = FinderThumbPlayerProxy.this.tHL;
                    lifecycle2.Gr(FinderThumbPlayerProxy.c(FinderThumbPlayerProxy.this).fwS());
                }
                FinderThumbPlayerProxy.this.wdF = true;
            }
            AppMethodBeat.o(254125);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener
        public final void onPrepared(ITPPlayer iTPPlayer) {
            at atVar;
            String str;
            AppMethodBeat.i(254126);
            p.h(iTPPlayer, "player");
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "FTPP.OnPrepared() " + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
            i.b videoViewCallback = FinderThumbPlayerProxy.this.getVideoViewCallback();
            if (videoViewCallback != null) {
                s sVar = FinderThumbPlayerProxy.this.tHL;
                if (sVar != null) {
                    str = sVar.mediaId;
                } else {
                    str = null;
                }
                videoViewCallback.dH("", str);
            }
            if (FinderThumbPlayerProxy.this.wcA) {
                FinderThumbPlayerProxy.this.Mc(2);
            } else {
                FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this, 1);
                iTPPlayer.pauseDownload();
            }
            b bVar = FinderThumbPlayerProxy.this.wdH;
            if (bVar == null || (atVar = bVar.uJG) == null) {
                AppMethodBeat.o(254126);
                return;
            }
            atVar.field_audioBitrate = (int) iTPPlayer.getPropertyLong(101);
            atVar.field_videoBitrate = (int) iTPPlayer.getPropertyLong(202);
            atVar.field_frameRate = (int) iTPPlayer.getPropertyLong(206);
            AppMethodBeat.o(254126);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener
        public final void onVideoSizeChanged(ITPPlayer iTPPlayer, long j2, long j3) {
            AppMethodBeat.i(254127);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "FTPP.OnVideoSizeChanged() width:" + j2 + " height:" + j3 + ' ' + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
            FinderThumbPlayerProxy.h(FinderThumbPlayerProxy.this).jk((int) j2, (int) j3);
            AppMethodBeat.o(254127);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener
        public final void onInfo(ITPPlayer iTPPlayer, int i2, long j2, long j3, Object obj) {
            int i3;
            String str;
            cjl cjl;
            FinderMediaReportObject finderMediaReportObject;
            s sVar;
            cjl cjl2;
            cjl cjl3;
            String str2 = null;
            String str3 = null;
            r2 = null;
            FinderMediaReportObject finderMediaReportObject2 = null;
            AppMethodBeat.i(254128);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onInfo() what:" + i2 + " arg1:" + j2 + " arg2:" + j3 + " extraObject:" + obj + ' ' + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
            switch (i2) {
                case 105:
                    a aVar2 = FinderThumbPlayerProxy.wdX;
                    Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onInfo#firstAudioFrameRendered " + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
                    AppMethodBeat.o(254128);
                    return;
                case 106:
                    a aVar3 = FinderThumbPlayerProxy.wdX;
                    Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onInfo#firstVideoFrameRendered " + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
                    y lifecycle = FinderThumbPlayerProxy.this.getLifecycle();
                    if (lifecycle != null) {
                        s unused = FinderThumbPlayerProxy.this.tHL;
                        lifecycle.dFK();
                        AppMethodBeat.o(254128);
                        return;
                    }
                    AppMethodBeat.o(254128);
                    return;
                case 150:
                    a aVar4 = FinderThumbPlayerProxy.wdX;
                    Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onInfo#onReplay() " + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
                    y lifecycle2 = FinderThumbPlayerProxy.this.getLifecycle();
                    if (lifecycle2 != null) {
                        s unused2 = FinderThumbPlayerProxy.this.tHL;
                        lifecycle2.dFM();
                        AppMethodBeat.o(254128);
                        return;
                    }
                    AppMethodBeat.o(254128);
                    return;
                case 200:
                    a aVar5 = FinderThumbPlayerProxy.wdX;
                    Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onInfo#onBufferingStart() pos:" + FinderThumbPlayerProxy.this.getCurrentPlayMs() + ' ' + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
                    FinderThumbPlayerProxy finderThumbPlayerProxy = FinderThumbPlayerProxy.this;
                    s sVar2 = FinderThumbPlayerProxy.this.tHL;
                    if (sVar2 != null) {
                        str3 = sVar2.mediaId;
                    }
                    FinderThumbPlayerProxy.a(finderThumbPlayerProxy, str3);
                    AppMethodBeat.o(254128);
                    return;
                case 201:
                    a aVar6 = FinderThumbPlayerProxy.wdX;
                    Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onInfo#onBufferingEnd() pos:" + FinderThumbPlayerProxy.this.getCurrentPlayMs() + ' ' + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
                    FinderThumbPlayerProxy.k(FinderThumbPlayerProxy.this);
                    AppMethodBeat.o(254128);
                    return;
                case 204:
                    a aVar7 = FinderThumbPlayerProxy.wdX;
                    String str4 = FinderThumbPlayerProxy.TAG;
                    StringBuilder append = new StringBuilder("FTPP.onInfo#videoDecodeType:").append(j2).append(' ');
                    s sVar3 = FinderThumbPlayerProxy.this.tHL;
                    if (sVar3 != null) {
                        str = sVar3.mediaId;
                    } else {
                        str = null;
                    }
                    Log.i(str4, append.append(str).toString());
                    s sVar4 = FinderThumbPlayerProxy.this.tHL;
                    if (!(sVar4 == null || (cjl3 = sVar4.wgl) == null)) {
                        finderMediaReportObject2 = cjl3.MoZ;
                    }
                    if (!(finderMediaReportObject2 != null || (sVar = FinderThumbPlayerProxy.this.tHL) == null || (cjl2 = sVar.wgl) == null)) {
                        cjl2.MoZ = new FinderMediaReportObject();
                    }
                    s sVar5 = FinderThumbPlayerProxy.this.tHL;
                    if (sVar5 == null || (cjl = sVar5.wgl) == null || (finderMediaReportObject = cjl.MoZ) == null) {
                        AppMethodBeat.o(254128);
                        return;
                    }
                    finderMediaReportObject.playDecoderType = (int) j2;
                    AppMethodBeat.o(254128);
                    return;
                case 502:
                    a aVar8 = FinderThumbPlayerProxy.wdX;
                    String str5 = FinderThumbPlayerProxy.TAG;
                    StringBuilder append2 = new StringBuilder("FTPP.onInfo#mediaCodecInfo:").append(j2).append(' ');
                    s sVar6 = FinderThumbPlayerProxy.this.tHL;
                    if (sVar6 != null) {
                        str2 = sVar6.mediaId;
                    }
                    Log.i(str5, append2.append(str2).toString());
                    if (!(obj instanceof TPPlayerMsg.TPMediaCodecInfo)) {
                        a aVar9 = FinderThumbPlayerProxy.wdX;
                        Log.w(FinderThumbPlayerProxy.TAG, "FTPP.onInfo#mediaCodecInfo return for not codecInfo");
                        AppMethodBeat.o(254128);
                        return;
                    } else if (((TPPlayerMsg.TPMediaCodecInfo) obj).mediaType != TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO) {
                        a aVar10 = FinderThumbPlayerProxy.wdX;
                        Log.w(FinderThumbPlayerProxy.TAG, "FTPP.onInfo#mediaCodecInfo return for not video type");
                        AppMethodBeat.o(254128);
                        return;
                    } else {
                        if (((TPPlayerMsg.TPMediaCodecInfo) obj).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY) {
                            try {
                                com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i(((TPPlayerMsg.TPMediaCodecInfo) obj).msg);
                                com.tencent.mm.plugin.finder.video.reporter.c cVar = FinderThumbPlayerProxy.this.tHS;
                                if (cVar != null) {
                                    cVar.Mi(iVar.optBoolean("reuseEnable") ? 1 : -1);
                                }
                                com.tencent.mm.plugin.finder.video.reporter.c cVar2 = FinderThumbPlayerProxy.this.tHS;
                                if (cVar2 != null) {
                                    if (iVar.optBoolean("isReuse")) {
                                        i3 = 1;
                                    } else {
                                        i3 = -1;
                                    }
                                    cVar2.Mj(i3);
                                }
                                com.tencent.mm.plugin.finder.video.reporter.c cVar3 = FinderThumbPlayerProxy.this.tHS;
                                if (cVar3 != null) {
                                    cVar3.Mk(iVar.optInt("totalCodec"));
                                }
                            } catch (Throwable th) {
                            }
                        } else if (((TPPlayerMsg.TPMediaCodecInfo) obj).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION) {
                            try {
                                com.tencent.mm.ab.i iVar2 = new com.tencent.mm.ab.i(((TPPlayerMsg.TPMediaCodecInfo) obj).msg);
                                com.tencent.mm.plugin.finder.video.reporter.c cVar4 = FinderThumbPlayerProxy.this.tHS;
                                if (cVar4 != null) {
                                    cVar4.awO(iVar2.optString("errorCodec"));
                                }
                            } catch (Throwable th2) {
                            }
                        }
                        y lifecycle3 = FinderThumbPlayerProxy.this.getLifecycle();
                        if (lifecycle3 != null) {
                            s unused3 = FinderThumbPlayerProxy.this.tHL;
                            lifecycle3.a(FinderThumbPlayerProxy.this.tHS);
                            AppMethodBeat.o(254128);
                            return;
                        }
                    }
                    break;
                case 1006:
                    if (obj instanceof TPPlayerMsg.TPDownLoadProgressInfo) {
                        a aVar11 = FinderThumbPlayerProxy.wdX;
                        Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onInfo#downloadProgressUpdate: " + ((TPPlayerMsg.TPDownLoadProgressInfo) obj).playableDurationMS);
                        AppMethodBeat.o(254128);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(254128);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener
        public final void onStateChange(int i2, int i3) {
            String str = null;
            AppMethodBeat.i(254129);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onStateChange() preState:" + i2 + " curState:" + i3 + ' ' + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
            FinderThumbPlayerProxy.this.currentPlayState = i3;
            if (FinderThumbPlayerProxy.this.tHL == null) {
                a aVar2 = FinderThumbPlayerProxy.wdX;
                Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onStateChange() return for null");
                AppMethodBeat.o(254129);
                return;
            }
            switch (i3) {
                case 5:
                    i.b videoViewCallback = FinderThumbPlayerProxy.this.getVideoViewCallback();
                    if (videoViewCallback != null) {
                        s sVar = FinderThumbPlayerProxy.this.tHL;
                        if (sVar != null) {
                            str = sVar.mediaId;
                        }
                        videoViewCallback.dK("", str);
                    }
                    y lifecycle = FinderThumbPlayerProxy.this.getLifecycle();
                    if (lifecycle != null) {
                        s unused = FinderThumbPlayerProxy.this.tHL;
                        lifecycle.dFN();
                        break;
                    }
                    break;
                case 6:
                    i.b videoViewCallback2 = FinderThumbPlayerProxy.this.getVideoViewCallback();
                    if (videoViewCallback2 != null) {
                        s sVar2 = FinderThumbPlayerProxy.this.tHL;
                        if (sVar2 != null) {
                            str = sVar2.mediaId;
                        }
                        videoViewCallback2.dJ("", str);
                    }
                    y lifecycle2 = FinderThumbPlayerProxy.this.getLifecycle();
                    if (lifecycle2 != null) {
                        s unused2 = FinderThumbPlayerProxy.this.tHL;
                        lifecycle2.dFL();
                        break;
                    }
                    break;
                case 7:
                    i.b videoViewCallback3 = FinderThumbPlayerProxy.this.getVideoViewCallback();
                    if (videoViewCallback3 != null) {
                        s sVar3 = FinderThumbPlayerProxy.this.tHL;
                        if (sVar3 != null) {
                            str = sVar3.mediaId;
                        }
                        videoViewCallback3.dI("", str);
                        break;
                    }
                    break;
            }
            if (i3 == 9 || i3 == 1) {
                a aVar3 = FinderThumbPlayerProxy.wdX;
                Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onStateChange() player stop or idle " + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
                u onPlayerStopListener = FinderThumbPlayerProxy.this.getOnPlayerStopListener();
                if (onPlayerStopListener != null) {
                    onPlayerStopListener.dFR();
                    AppMethodBeat.o(254129);
                    return;
                }
            }
            AppMethodBeat.o(254129);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener
        public final void onCompletion(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(254130);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onCompletion() " + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
            AppMethodBeat.o(254130);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener
        public final void onError(ITPPlayer iTPPlayer, int i2, int i3, long j2, long j3) {
            s sVar;
            AppMethodBeat.i(254131);
            p.h(iTPPlayer, "player");
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "FTPP.onError() " + i2 + ' ' + i3 + " bgPrepareStatus:" + FinderThumbPlayerProxy.this.wdJ + ' ' + FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this));
            if (i3 == 11030406 && (sVar = FinderThumbPlayerProxy.this.tHL) != null) {
                com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                String str = sVar.mediaId;
                String str2 = sVar.tHN.uIw.mediaId;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = sVar.downloadUrl;
                if (str3 == null) {
                    str3 = "";
                }
                com.tencent.mm.plugin.finder.storage.logic.d.a(str, str2, str3, sVar.tHN.uJN, sVar.tHN.uIx.detail, 0, 0, 1, sVar.tHN.uIw.videoDuration, "", "");
                b bVar = FinderThumbPlayerProxy.this.wdH;
                if (bVar != null) {
                    bVar.dFt();
                }
            }
            if (FinderThumbPlayerProxy.this.wdJ != 0) {
                iTPPlayer.reset();
                FinderThumbPlayerProxy.this.dEN();
                AppMethodBeat.o(254131);
                return;
            }
            s sVar2 = FinderThumbPlayerProxy.this.tHL;
            if (sVar2 != null) {
                i.b videoViewCallback = FinderThumbPlayerProxy.this.getVideoViewCallback();
                if (videoViewCallback != null) {
                    videoViewCallback.c("", sVar2.mediaId, "", i3, i2);
                    AppMethodBeat.o(254131);
                    return;
                }
                AppMethodBeat.o(254131);
                return;
            }
            AppMethodBeat.o(254131);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ4\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u0004\u0018\u00010,J\u001e\u0010.\u001a\u0004\u0018\u00010/2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00101\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001c\u00105\u001a\u0004\u0018\u00010\u00062\u0006\u00106\u001a\u00020\"2\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u00108\u001a\u0004\u0018\u00010\u00062\u0006\u00106\u001a\u00020\"2\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u00109\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\"2\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002J \u0010=\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0016J \u0010@\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010B\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010D\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010F\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J \u0010G\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000bH\u0016J*\u0010I\u001a\u00020\"2\u0006\u00106\u001a\u00020\"2\b\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0016J*\u0010J\u001a\u00020\"2\u0006\u00106\u001a\u00020\"2\b\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u000bH\u0016J\"\u0010M\u001a\u00020\"2\u0006\u00106\u001a\u00020\"2\b\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u0010N\u001a\u00020\"H\u0016J\b\u0010O\u001a\u00020\u0006H\u0016J\u0006\u0010P\u001a\u000202J\u000e\u0010Q\u001a\u0002022\u0006\u0010R\u001a\u00020*R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "MAX_REQUEST_BUFFER", "", "MIN_CHECK_BUFFER", "REQUEST_INTERVAL", "REQUEST_PERIOD_MAX_MS", "REQUEST_PERIOD_MIN_MS", "isRequestingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastOnReadDataEnd", "getLastOnReadDataEnd", "()J", "setLastOnReadDataEnd", "(J)V", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getMediaCache", "()Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "setMediaCache", "(Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;)V", "getMediaId", "()Ljava/lang/String;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "requestNumber", "", "callback", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "createVideoPreloadCDNTask", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "getContentType", "fileId", "fileKey", "getDataFilePath", "getDataTotalSize", "notifyDataReady", "requestOffset", "requestLength", "onDataAvailable", "offset", "length", "onFinish", "ret", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onPreloadCompleted", "onProgress", "total", "onReadData", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "toString", "updateMediaCache", "updateRequestingData", "value", "plugin-finder_release"})
    public final class b extends h.a.a.a.a.a.a.a.a.a.a.a implements g.a, g.b, h.a {
        final String mediaId;
        at uJG;
        final s wcy;
        private final long wdY = 30;
        private final long wdZ = 1048576;
        private final long wea = 131072;
        private final long web = 10;
        private final long wec = 50;
        private int wed;
        private AtomicBoolean wee = new AtomicBoolean(false);
        long wef;
        final /* synthetic */ FinderThumbPlayerProxy weg;

        public b(FinderThumbPlayerProxy finderThumbPlayerProxy, String str, s sVar) {
            p.h(str, "mediaId");
            p.h(sVar, "mediaInfo");
            this.weg = finderThumbPlayerProxy;
            AppMethodBeat.i(254121);
            this.mediaId = str;
            this.wcy = sVar;
            com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            this.uJG = com.tencent.mm.plugin.finder.storage.logic.d.bv(this.mediaId, true);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "create ResourceLoaderProxy, state:" + this.uJG.field_state + ' ' + "path:" + this.uJG.getFilePath() + ", mediaInfo path:" + this.wcy.path);
            switch (this.uJG.field_state) {
                case -2:
                case -1:
                case 0:
                    com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    String str2 = this.mediaId;
                    String str3 = this.wcy.tHN.uIw.mediaId;
                    str3 = str3 == null ? "" : str3;
                    String str4 = this.wcy.downloadUrl;
                    com.tencent.mm.plugin.finder.storage.logic.d.a(str2, str3, str4 == null ? "" : str4, this.wcy.tHN.uJN, this.wcy.tHN.uIx.detail, 0, 0, 1, this.wcy.tHN.uIw.videoDuration, "", "");
                    dFt();
                    break;
            }
            AppMethodBeat.o(254121);
        }

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
            AppMethodBeat.i(254104);
            p.h(str, "mediaId");
            AppMethodBeat.o(254104);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, long j2, long j3, String str2) {
            AppMethodBeat.i(254105);
            p.h(str, "mediaId");
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "onMoovReady() offset=" + j2 + " length=" + j3 + " svrflag=" + str2 + ' ' + this);
            boolean z = !this.uJG.field_moovReady;
            com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            if (str2 == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.finder.storage.logic.d.gU(str, str2);
            dFt();
            if (!FinderThumbPlayerProxy.m(this.weg) && !FinderThumbPlayerProxy.n(this.weg)) {
                a aVar2 = FinderThumbPlayerProxy.wdX;
                Log.i(FinderThumbPlayerProxy.TAG, "onMoovReady() try to prepared");
                FinderThumbPlayerProxy.o(this.weg);
            }
            x downloadCallback = this.weg.getDownloadCallback();
            if (downloadCallback != null) {
                downloadCallback.a((int) j2, (int) j3, this.wcy.tHN, z);
            }
            com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            com.tencent.mm.plugin.finder.storage.logic.d.avG(str);
            AppMethodBeat.o(254105);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(String str, long j2, long j3) {
            AppMethodBeat.i(254106);
            p.h(str, "mediaId");
            oO(false);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "onDataAvailable() offset=" + j2 + " length=" + j3 + ' ' + this + '}');
            AppMethodBeat.o(254106);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(String str, long j2, long j3) {
            AppMethodBeat.i(254107);
            p.h(str, "mediaId");
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "onProgress() offset=" + j2 + " total=" + j3 + ' ' + this);
            com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            com.tencent.mm.plugin.finder.storage.logic.d.a(str, j2, j3, 1);
            dFt();
            x downloadCallback = this.weg.getDownloadCallback();
            if (downloadCallback != null) {
                downloadCallback.a((int) j2, (int) j3, this.wcy.tHN);
            }
            com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            com.tencent.mm.plugin.finder.storage.logic.d.avG(str);
            AppMethodBeat.o(254107);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, int i2, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(254108);
            p.h(str, "mediaId");
            p.h(dVar, "sceneResult");
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "onFinish() mediaId=" + str + " ret=" + i2 + " recvedBytes=" + dVar.field_recvedBytes + " fileLength=" + dVar.field_fileLength + "  finderformat:" + dVar.field_videoFormat);
            com.tencent.mm.ac.d.h(new C1319b(this, i2, dVar));
            if (i2 != 0) {
                com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                String str2 = this.wcy.tHN.uIw.mediaId;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = this.wcy.downloadUrl;
                if (str3 == null) {
                    str3 = "";
                }
                com.tencent.mm.plugin.finder.storage.logic.d.a(str, str2, str3, this.wcy.tHN.uJN, this.wcy.tHN.uIx.detail, 0, 0, -1, this.wcy.tHN.uIw.videoDuration, "", "");
            } else {
                com.tencent.mm.plugin.finder.storage.logic.d dVar3 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                com.tencent.mm.plugin.finder.storage.logic.d.a(str, dVar.field_fileLength, dVar.field_fileLength, 3);
                com.tencent.mm.plugin.finder.storage.logic.d dVar4 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                com.tencent.mm.plugin.finder.storage.logic.d.avG(str);
            }
            dFt();
            oO(false);
            AppMethodBeat.o(254108);
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            boolean z2;
            int i3 = 1;
            AppMethodBeat.i(254109);
            p.h(str, "mediaId");
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "callback() mediaId=" + str + " startRet=" + i2 + " finishedLength=" + (cVar != null ? Long.valueOf(cVar.field_finishedLength) : null) + " fileFormat=" + (dVar != null ? dVar.field_videoFlag : null) + ' ' + this);
            if (cVar != null) {
                if (i2 != 0 || cVar.field_finishedLength <= 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    cVar = null;
                }
                if (cVar != null) {
                    if (cVar.field_finishedLength >= cVar.field_toltalLength) {
                        i3 = 3;
                    }
                    com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    com.tencent.mm.plugin.finder.storage.logic.d.a(str, cVar.field_finishedLength, cVar.field_toltalLength, i3);
                    dFt();
                    com.tencent.mm.plugin.finder.storage.logic.d dVar3 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    com.tencent.mm.plugin.finder.storage.logic.d.avG(str);
                }
            }
            AppMethodBeat.o(254109);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(254110);
            p.h(str, "mediaId");
            AppMethodBeat.o(254110);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }

        @Override // com.tencent.mm.i.g.b
        public final void b(String str, com.tencent.mm.i.d dVar) {
            Integer num;
            Long l = null;
            AppMethodBeat.i(254111);
            p.h(str, "mediaId");
            a aVar = FinderThumbPlayerProxy.wdX;
            String str2 = FinderThumbPlayerProxy.TAG;
            StringBuilder append = new StringBuilder("[onPreloadCompleted] mediaId=").append(str).append(" Ret=");
            if (dVar != null) {
                num = Integer.valueOf(dVar.field_retCode);
            } else {
                num = null;
            }
            StringBuilder append2 = append.append(num).append(" finishedLength=");
            if (dVar != null) {
                l = Long.valueOf(dVar.field_recvedBytes);
            }
            Log.i(str2, append2.append(l).append(' ').append(this).toString());
            FinderThumbPlayerProxy.p(this.weg);
            AppMethodBeat.o(254111);
        }

        public final void dFt() {
            AppMethodBeat.i(254112);
            com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            this.uJG = com.tencent.mm.plugin.finder.storage.logic.d.avH(this.mediaId);
            AppMethodBeat.o(254112);
        }

        public final void oO(boolean z) {
            AppMethodBeat.i(254113);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "updateRequestingData " + z + ' ' + this);
            this.wee.set(z);
            AppMethodBeat.o(254113);
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final int onStartReadData(int i2, String str, long j2, long j3) {
            AppMethodBeat.i(254114);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "onStartReadData() fileId:" + i2 + ", fileKey:" + str + ", requestStart:" + j2 + ", requestEnd:" + j3);
            int i3 = this.wed;
            this.wed = i3 + 1;
            AppMethodBeat.o(254114);
            return i3;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final int onStopReadData(int i2, String str, int i3) {
            AppMethodBeat.i(254116);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "onStartReadData() fileId:" + i2 + ", fileKey:" + str + ", requestId:" + i3);
            int i4 = this.wed;
            AppMethodBeat.o(254116);
            return i4;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final long getDataTotalSize(int i2, String str) {
            AppMethodBeat.i(254117);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "getDataTotalSize() fileId:" + i2 + ", fileKey:" + str + " dataTotalSize:" + this.uJG.field_totalSize + ' ');
            long j2 = this.uJG.field_totalSize;
            AppMethodBeat.o(254117);
            return j2;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final String Mf(int i2) {
            AppMethodBeat.i(254118);
            String k = com.tencent.mm.vfs.s.k(this.wcy.path, false);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "getDataFilePath(), dataFilePath:" + k + " isExists:" + com.tencent.mm.vfs.s.YS(k) + ' ' + "mediaInfoPath:" + this.wcy.path);
            AppMethodBeat.o(254118);
            return k;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final String getContentType(int i2, String str) {
            AppMethodBeat.i(254119);
            a aVar = FinderThumbPlayerProxy.wdX;
            Log.i(FinderThumbPlayerProxy.TAG, "getContentType() fileId:" + i2 + ", fileKey:" + str + " contentType:" + "video/mp4");
            AppMethodBeat.o(254119);
            return "video/mp4";
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy$notifyDataReady$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-finder_release"})
        public static final class a implements com.tencent.mm.plugin.thumbplayer.b.c {
            final /* synthetic */ b weh;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(b bVar) {
                this.weh = bVar;
            }

            @Override // com.tencent.mm.plugin.thumbplayer.b.c
            public final void Mg(int i2) {
                AppMethodBeat.i(254102);
                if (i2 != 0) {
                    a aVar = FinderThumbPlayerProxy.wdX;
                    Log.w(FinderThumbPlayerProxy.TAG, "requestedResource() requestVideoData fail, ret:" + i2 + ' ' + this);
                    this.weh.oO(false);
                }
                AppMethodBeat.o(254102);
            }
        }

        public final String toString() {
            AppMethodBeat.i(254120);
            String str = FinderThumbPlayerProxy.a(this.weg) + " isMoovReady:" + this.uJG.field_moovReady + " isRequestingData:" + this.wee.get() + " isFinish:" + this.uJG.dkN() + " total:" + this.uJG.field_totalSize;
            AppMethodBeat.o(254120);
            return str;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy$b$b  reason: collision with other inner class name */
        static final class C1319b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int qWv;
            final /* synthetic */ com.tencent.mm.i.d uJL;
            final /* synthetic */ b weh;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1319b(b bVar, int i2, com.tencent.mm.i.d dVar) {
                super(0);
                this.weh = bVar;
                this.qWv = i2;
                this.uJL = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(254103);
                x downloadCallback = this.weh.weg.getDownloadCallback();
                if (downloadCallback != null) {
                    downloadCallback.a(this.qWv, this.weh.wcy.tHN, this.uJL);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(254103);
                return xVar;
            }
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final int k(int i2, long j2, long j3) {
            long j4;
            AppMethodBeat.i(254115);
            if (!this.weg.wdQ.get()) {
                a aVar = FinderThumbPlayerProxy.wdX;
                Log.w(FinderThumbPlayerProxy.TAG, "notifyDataReady, return for downloader never start. requestOffset:" + j2 + " requestLength:" + j3 + ' ' + this);
                FinderThumbPlayerProxy.r(this.weg).dFX();
                j4 = 0;
            } else if (!FinderThumbPlayerProxy.s(this.weg) || j2 <= this.uJG.field_cacheSize) {
                long j5 = 0;
                if (this.uJG.dkN()) {
                    j5 = j3;
                } else {
                    long[] jArr = new long[2];
                    int queryContinuousSize = CdnLogic.queryContinuousSize(this.mediaId, j2, jArr);
                    if (queryContinuousSize != 0 || jArr[0] == -1) {
                        com.tencent.mm.plugin.finder.video.log.a t = FinderThumbPlayerProxy.t(this.weg);
                        a aVar2 = FinderThumbPlayerProxy.wdX;
                        String str = FinderThumbPlayerProxy.TAG;
                        String str2 = "notifyDataReady() queryContinuousSize error, ret:" + queryContinuousSize + " requestOffset:" + j2 + " continuousSize:" + jArr[0] + " totalSize:" + jArr[1] + ' ' + this;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - t.wgC > 500) {
                            Log.w(str, str2);
                            t.wgC = currentTimeMillis;
                        }
                    } else {
                        j5 = jArr[0] > j3 ? j3 : jArr[0];
                    }
                }
                if (j5 != 0) {
                    a aVar3 = FinderThumbPlayerProxy.wdX;
                    Log.i(FinderThumbPlayerProxy.TAG, "notifyDataReady() returnLength:" + j5 + " fixRequest[offset:" + j2 + " length:" + j3 + "], originRequest[offset:" + j2 + " length:" + j3 + "] " + this);
                } else if (!this.uJG.field_moovReady || this.wee.get()) {
                    com.tencent.mm.plugin.finder.video.log.a t2 = FinderThumbPlayerProxy.t(this.weg);
                    a aVar4 = FinderThumbPlayerProxy.wdX;
                    String str3 = FinderThumbPlayerProxy.TAG;
                    String str4 = "notifyDataReady() returnLength:" + j5 + " fixRequest[offset:" + j2 + " length:" + j3 + "],  originRequest[offset:" + j2 + " length:" + j3 + "] " + this;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - t2.wgE > 200) {
                        Log.w(str3, str4);
                        t2.wgE = currentTimeMillis2;
                    }
                } else {
                    if (j3 >= this.wdZ) {
                        j3 = this.wdZ;
                    }
                    if (j2 + j3 > this.uJG.field_totalSize) {
                        j3 = this.uJG.field_totalSize - j2;
                        a aVar5 = FinderThumbPlayerProxy.wdX;
                        Log.w(FinderThumbPlayerProxy.TAG, "notifyDataReady() requestLength is valid, requestOffset:" + j2 + ", requestLength:" + j3 + ", totalSize:" + this.uJG.field_totalSize + ' ' + this);
                    }
                    com.tencent.mm.plugin.thumbplayer.b.a cdnTaskController = ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
                    String str5 = this.mediaId;
                    p.h(str5, "mediaId");
                    if (!cdnTaskController.Ggu.containsKey(str5)) {
                        j4 = j5;
                    } else {
                        int a2 = ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int) j2, (int) j3, new a(this));
                        if (a2 > 0) {
                            oO(true);
                        }
                        a aVar6 = FinderThumbPlayerProxy.wdX;
                        Log.i(FinderThumbPlayerProxy.TAG, "notifyDataReady() requestVideoData requestOffset:" + j2 + " requestLengthFix:" + j3 + " requestDataRet:" + a2 + "  cacheSize:" + this.uJG.field_cacheSize + ' ' + this);
                    }
                }
                this.wef = j2 + j5;
                j4 = j5;
            } else {
                com.tencent.mm.plugin.finder.video.log.a t3 = FinderThumbPlayerProxy.t(this.weg);
                a aVar7 = FinderThumbPlayerProxy.wdX;
                String str6 = FinderThumbPlayerProxy.TAG;
                String str7 = "notifyDataReady() return for pause state. request[offset:" + j2 + " length:" + j3 + "] cacheSize:" + this.uJG.field_cacheSize + ' ' + this;
                long currentTimeMillis3 = System.currentTimeMillis();
                if (currentTimeMillis3 - t3.wgD > 5000) {
                    Log.w(str6, str7);
                    t3.wgD = currentTimeMillis3;
                }
                j4 = 0;
            }
            int i3 = (int) j4;
            AppMethodBeat.o(254115);
            return i3;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.video.reporter.a> {
        public static final d wei = new d();

        static {
            AppMethodBeat.i(254134);
            AppMethodBeat.o(254134);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.video.reporter.a invoke() {
            AppMethodBeat.i(254133);
            com.tencent.mm.plugin.finder.video.reporter.a aVar = new com.tencent.mm.plugin.finder.video.reporter.a();
            AppMethodBeat.o(254133);
            return aVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.video.log.a> {
        public static final e wej = new e();

        static {
            AppMethodBeat.i(254136);
            AppMethodBeat.o(254136);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.video.log.a invoke() {
            AppMethodBeat.i(254135);
            com.tencent.mm.plugin.finder.video.log.a aVar = new com.tencent.mm.plugin.finder.video.log.a();
            AppMethodBeat.o(254135);
            return aVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderThumbPlayerProxy weg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderThumbPlayerProxy finderThumbPlayerProxy) {
            super(0);
            this.weg = finderThumbPlayerProxy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254138);
            FinderThumbPlayerProxy.c(this.weg).release();
            x xVar = x.SXb;
            AppMethodBeat.o(254138);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getIsNeverStart() {
        AppMethodBeat.i(254157);
        if (!Me(this.currentPlayState)) {
            AppMethodBeat.o(254157);
            return true;
        }
        AppMethodBeat.o(254157);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean pause() {
        y yVar;
        boolean z = false;
        AppMethodBeat.i(254168);
        if (!Me(this.currentPlayState)) {
            Log.i(TAG, "pause() return for state:" + this.currentPlayState);
            dFp();
            AppMethodBeat.o(254168);
            return false;
        }
        Log.i(TAG, "pause()  " + dFm());
        if (isPlaying()) {
            com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
            if (aVar == null) {
                p.btv("player");
            }
            aVar.pause();
            com.tencent.mm.plugin.thumbplayer.e.a aVar2 = this.wdC;
            if (aVar2 == null) {
                p.btv("player");
            }
            aVar2.pauseDownload();
        } else if (dFr() && !this.wcA) {
            long currentTimeMillis = System.currentTimeMillis();
            stop();
            Log.i(TAG, "pause() preparing stop cost=" + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
        }
        dFp();
        if (this.wcB) {
            Log.i(TAG, "startCdnPreload() " + dFm());
            if (this.wdV) {
                Log.i(TAG, "startCdnPreload(), already start preload cdn " + dFm());
            } else {
                b bVar = this.wdH;
                if (bVar != null && bVar.uJG.field_cacheSize < bVar.wef && bVar.uJG.field_totalSize > 0) {
                    com.tencent.mm.plugin.thumbplayer.b.a cdnTaskController = ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
                    String str = bVar.mediaId;
                    k kVar = new k(bVar);
                    j jVar = new j(this);
                    p.h(str, "mediaId");
                    p.h(kVar, "createCallback");
                    if (str.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new a.e(cdnTaskController, kVar, str, jVar));
                    }
                    this.wdV = true;
                }
            }
        }
        dFs();
        if (!(this.tHL == null || (yVar = this.wcw) == null)) {
            yVar.dFL();
        }
        AppMethodBeat.o(254168);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(254172);
        if (!Me(this.currentPlayState)) {
            AppMethodBeat.o(254172);
            return false;
        } else if (!asa()) {
            AppMethodBeat.o(254172);
            return false;
        } else {
            Log.i(TAG, "seekTo " + d2 + ' ' + z);
            com.tencent.mm.plugin.thumbplayer.e.a aVar = this.wdC;
            if (aVar == null) {
                p.btv("player");
            }
            aVar.seekTo(kotlin.h.a.K(1000.0d * d2), 1);
            if (z) {
                play();
            }
            AppMethodBeat.o(254172);
            return true;
        }
    }

    public static final /* synthetic */ void a(FinderThumbPlayerProxy finderThumbPlayerProxy, String str) {
        AppMethodBeat.i(254199);
        if (finderThumbPlayerProxy.wdN != null) {
            finderThumbPlayerProxy.hAk.removeCallbacks(finderThumbPlayerProxy.wdN);
            finderThumbPlayerProxy.wdN = null;
        }
        finderThumbPlayerProxy.wdN = new f(finderThumbPlayerProxy, str);
        finderThumbPlayerProxy.hAk.postDelayed(finderThumbPlayerProxy.wdN, 500);
        AppMethodBeat.o(254199);
    }

    public static final /* synthetic */ void k(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        String str = null;
        AppMethodBeat.i(254200);
        if (finderThumbPlayerProxy.wdN != null) {
            finderThumbPlayerProxy.hAk.removeCallbacks(finderThumbPlayerProxy.wdN);
            finderThumbPlayerProxy.wdN = null;
        }
        if (finderThumbPlayerProxy.bbU) {
            finderThumbPlayerProxy.bbU = false;
            i.b bVar = finderThumbPlayerProxy.wcv;
            if (bVar != null) {
                s sVar = finderThumbPlayerProxy.tHL;
                if (sVar != null) {
                    str = sVar.mediaId;
                }
                bVar.dM("", str);
                AppMethodBeat.o(254200);
                return;
            }
        }
        AppMethodBeat.o(254200);
    }

    public static final /* synthetic */ boolean s(FinderThumbPlayerProxy finderThumbPlayerProxy) {
        return finderThumbPlayerProxy.currentPlayState == 6;
    }
}
