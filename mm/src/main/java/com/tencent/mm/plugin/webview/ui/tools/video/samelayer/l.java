package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.ui.tools.video.samelayer.m;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tav.core.AssetExtension;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.g.b.ae;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020QH\u0002J\b\u0010S\u001a\u00020\nH\u0002J\u0010\u0010T\u001a\u00020Q2\u0006\u0010U\u001a\u00020#H\u0002J\b\u0010V\u001a\u00020QH\u0002J\b\u0010W\u001a\u00020QH\u0002J\u0010\u0010X\u001a\u00020Q2\u0006\u0010Y\u001a\u000207H\u0002J\u0012\u0010Z\u001a\u00020Q2\b\u0010U\u001a\u0004\u0018\u00010#H\u0002J\u001e\u0010Z\u001a\u0004\u0018\u00010(2\b\u0010U\u001a\u0004\u0018\u00010#2\b\u0010[\u001a\u0004\u0018\u00010EH\u0002J\u0010\u0010\\\u001a\u00020Q2\u0006\u0010U\u001a\u00020#H\u0002J\u0006\u0010]\u001a\u00020 J\b\u0010^\u001a\u00020 H\u0002J\b\u0010_\u001a\u00020\nH\u0002J\b\u0010`\u001a\u00020 H\u0002J\b\u0010a\u001a\u00020 H\u0002J\u0012\u0010b\u001a\u0004\u0018\u00010\u00042\u0006\u0010U\u001a\u00020#H\u0016J\b\u0010c\u001a\u00020QH\u0002J\b\u0010d\u001a\u00020QH\u0002J\b\u0010e\u001a\u00020QH\u0016J\u0010\u0010f\u001a\u00020Q2\u0006\u0010g\u001a\u000207H\u0016J\u0012\u0010h\u001a\u00020Q2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u0006\u0010k\u001a\u00020QJ\u0010\u0010l\u001a\u00020Q2\u0006\u0010U\u001a\u00020#H\u0002J\u0006\u0010m\u001a\u00020\nJ\u0010\u0010n\u001a\u00020\n2\u0006\u0010U\u001a\u00020#H\u0016J\u0010\u0010o\u001a\u00020Q2\u0006\u0010p\u001a\u00020 H\u0002J\u0010\u0010q\u001a\u00020Q2\u0006\u0010p\u001a\u00020 H\u0002J\b\u0010r\u001a\u00020QH\u0002J\b\u0010s\u001a\u00020QH\u0002J\u0018\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020 2\u0006\u0010v\u001a\u00020 H\u0002J\u0018\u0010w\u001a\u00020\n2\u0006\u0010u\u001a\u00020 2\u0006\u0010v\u001a\u00020 H\u0002J\u0018\u0010x\u001a\u00020\n2\u0006\u0010u\u001a\u00020 2\u0006\u0010v\u001a\u00020 H\u0002J\u0018\u0010y\u001a\u00020\n2\u0006\u0010u\u001a\u00020 2\u0006\u0010v\u001a\u00020 H\u0002J\b\u0010z\u001a\u00020QH\u0002J\b\u0010{\u001a\u00020QH\u0002J\b\u0010|\u001a\u00020QH\u0002J\b\u0010}\u001a\u00020QH\u0002J\b\u0010~\u001a\u00020QH\u0002J\u001a\u0010\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020 H\u0002J\u001b\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020 H\u0002J\t\u0010\u0001\u001a\u00020QH\u0002J\u0011\u0010\u0001\u001a\u00020Q2\u0006\u0010U\u001a\u00020#H\u0002J\t\u0010\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u001b\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\t\u0010\u0001\u001a\u00020QH\u0002J\u0011\u0010\u0001\u001a\u00020Q2\u0006\u0010U\u001a\u00020#H\u0002J\t\u0010\u0001\u001a\u00020QH\u0002J\t\u0010\u0001\u001a\u00020QH\u0002J\t\u0010\u0001\u001a\u00020QH\u0002J\t\u0010\u0001\u001a\u00020QH\u0002J\t\u0010\u0001\u001a\u00020QH\u0002J\u0011\u0010\u0001\u001a\u00020Q2\u0006\u0010U\u001a\u00020#H\u0002J\t\u0010\u0001\u001a\u00020QH\u0002J\u0013\u0010\u0001\u001a\u00020Q2\b\u0010U\u001a\u0004\u0018\u00010#H\u0002J\t\u0010\u0001\u001a\u00020QH\u0002J\u0013\u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020Q2\b\u0010i\u001a\u0004\u0018\u00010jH\u0002J\u0012\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u000201H\u0002J\u0015\u0010\u0001\u001a\u00020\n2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0014\u0010\u0001\u001a\u00020Q2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\u0011\u0010\u0001\u001a\u00020Q2\u0006\u0010U\u001a\u00020#H\u0002J\u0013\u0010\u0001\u001a\u00020Q2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\t\u0010 \u0001\u001a\u00020\nH\u0002J\u0015\u0010¡\u0001\u001a\u00020\n2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010¢\u0001\u001a\u00020\nH\u0002J\u0015\u0010£\u0001\u001a\u00020\n2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010¤\u0001\u001a\u00020QH\u0002J\u0011\u0010¥\u0001\u001a\u00020Q2\u0006\u0010U\u001a\u00020#H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\n ;*\u0004\u0018\u00010:0:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0004¢\u0006\u0002\n\u0000¨\u0006¦\u0001"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "abTestVideoPreload", "", "getAbTestVideoPreload", "()Z", "abTestVideoPreload$delegate", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "audioRespond", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "getAudioRespond", "()Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "bandwidthFraction", "", "hasExoParam", "isPlayingWhenEnterBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mAutoPauseOnBackground", "mControlStartWhenPrepared", "mErrorHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoErrorHandler;", "mEventHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "mHtmlHeight", "", "mHtmlWidth", "mInsertInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mLastUpdateBuffer", "mLifecycleListener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mScaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "mShouldNotifyEvent", "mSnapshotInvokeContext", "mStartSeekPosition", "", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mVideoDuration", "mVideoHandlerThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoHeightScale", "mVideoLooping", "mVideoMuted", "mVideoObjectFit", "mVideoPath", "mVideoThreadHandler", "Landroid/os/Handler;", "mVideoWidth", "mVideoWidthScale", "mWebViewInBackground", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "webViewVideoProfileReport", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkPause", "invokeContext", "clearSurface", "clearSurfaceTexture", "clearSurfaceTextureInternal", "texture", "createMediaPlayer", "handler", "doCheckPause", "getCurrentPosition", "getDuration", "getIsPlayingWhenEnterBackground", "getVideoHeight", "getVideoWidth", "handleJsApi", "handleOnBackGround", "handleOnForeGround", "handlePluginDestroy", "handlePluginReady", "surfaceTexture", "handlePluginScreenshotTaken", "bitmap", "Landroid/graphics/Bitmap;", "initPlugin", "insert", "isPlaying", "isPluginReady", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerBufferingUpdateInternal", "onMediaPlayerCompletion", "onMediaPlayerCompletionInternal", "onMediaPlayerError", "what", "extra", "onMediaPlayerErrorInternal", "onMediaPlayerInfo", "onMediaPlayerInfoInternal", "onMediaPlayerPrepared", "onMediaPlayerPreparedInternal", "onMediaPlayerSeekComplete", "onMediaPlayerSeekCompleteInternal", "onMediaPlayerVideoFirstFrameInternal", "onMediaPlayerVideoSizeChanged", "width", "height", "onMediaPlayerVideoSizeChangedInternal", "onWebViewDestroy", "operate", "pause", AssetExtension.SCENE_PLAY, "isAutoPlay", "restartPlayIfNeed", "prepareAsync", "registerLifecycleListener", "release", "releaseErrorHandler", "releaseEventHandler", "releaseMediaPlayer", "releaseThreadHandler", "remove", "removeFullScreenListener", "resetMediaPlayer", "resetPluginHandler", "runOnVideoThread", "runnable", "Ljava/lang/Runnable;", "safeRecycleBitmap", "seek", "msc", "data", "Lorg/json/JSONObject;", "setDataSourceWithCustomKey", "url", "setExoPlayerParam", "setPlayingWhenEnterBackground", "shouldNotifyEvent", "speed", "stop", "takeVideoSnapshot", "unregisterLifecycleListener", "update", "plugin-webview_release"})
public final class l extends com.tencent.luggage.xweb_ext.extendplugin.a.a {
    final d.a Goc;
    boolean Jyf;
    j Jyg;
    private com.tencent.mm.plugin.appbrand.jsapi.ag.e.g Jyh = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.g();
    final m Jyi = new m();
    private int bDU;
    private float bDY;
    com.tencent.luggage.xweb_ext.extendplugin.a cED;
    a.AbstractC0188a cEE;
    int cEF;
    int cEG;
    boolean cEJ;
    AtomicBoolean cET;
    com.tencent.mm.plugin.appbrand.jsapi.video.e.c cIV;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cIY;
    private float cJD = 1.0f;
    private float cJE = 1.0f;
    boolean cJd;
    boolean cJe;
    boolean cJf;
    boolean cJg;
    long cJh;
    boolean cJi;
    boolean cJj;
    volatile boolean cJk;
    boolean cJl;
    boolean cJm;
    int cJn;
    int cJo;
    String cJp;
    String cJq;
    boolean cJr;
    volatile boolean cJs;
    private Handler cJv;
    private HandlerThread cJw = com.tencent.f.c.d.hA("WebViewVideoThread_" + System.currentTimeMillis(), 5);
    volatile com.tencent.luggage.xweb_ext.extendplugin.a cJx;
    final com.tencent.mm.model.d hWh;
    private int mCn;
    private int mCo;
    private int mCp;
    private int mCq;
    Surface mSurface;
    SurfaceTexture mSurfaceTexture;
    int mVideoHeight;
    int mVideoWidth;
    private final kotlin.f pFA = kotlin.g.ah(new a(this));
    private boolean pNt;
    private final kotlin.f pNy;

    private final boolean getAbTestVideoPreload() {
        AppMethodBeat.i(210783);
        boolean booleanValue = ((Boolean) this.pNy.getValue()).booleanValue();
        AppMethodBeat.o(210783);
        return booleanValue;
    }

    /* access modifiers changed from: package-private */
    public final String getTAG() {
        AppMethodBeat.i(210756);
        String str = (String) this.pFA.getValue();
        AppMethodBeat.o(210756);
        return str;
    }

    public l() {
        AppMethodBeat.i(210785);
        com.tencent.mm.model.d aTu = com.tencent.mm.model.d.aTu();
        kotlin.g.b.p.g(aTu, "AudioHelperTool.createTool()");
        this.hWh = aTu;
        this.cJw.start();
        HandlerThread handlerThread = this.cJw;
        kotlin.g.b.p.g(handlerThread, "mVideoHandlerThread");
        this.cJv = new Handler(handlerThread.getLooper());
        this.bDU = 800000;
        this.bDY = 0.75f;
        this.mCn = 10000;
        this.mCo = 25000;
        this.mCp = 15000;
        this.mCq = CommonUtils.MAX_TIMEOUT_MS;
        this.Goc = new c();
        this.pNy = kotlin.g.ah(b.Jyk);
        AppMethodBeat.o(210785);
    }

    public static final /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(210786);
        super.PQ();
        AppMethodBeat.o(210786);
    }

    /* access modifiers changed from: package-private */
    public final boolean Qo() {
        AppMethodBeat.i(210757);
        AtomicBoolean atomicBoolean = this.cET;
        if (atomicBoolean != null) {
            boolean z2 = atomicBoolean.get();
            AppMethodBeat.o(210757);
            return z2;
        }
        AppMethodBeat.o(210757);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "msg", "", "kotlin.jvm.PlatformType", "what", "", "extra", "onVideoError"})
    static final class r implements c.a {
        final /* synthetic */ l Jyj;

        r(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a
        public final void h(String str, int i2, int i3) {
            j jVar;
            AppMethodBeat.i(210741);
            Log.w(this.Jyj.getTAG(), "send video error event, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (this.Jyj.PS() && (jVar = this.Jyj.Jyg) != null) {
                jVar.bKw();
                jVar.bMk();
                try {
                    JSONObject bKv = jVar.bKv();
                    ae aeVar = ae.SYK;
                    Locale locale = Locale.US;
                    kotlin.g.b.p.g(locale, "Locale.US");
                    String format = String.format(locale, "%s(%d,%d)", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3)}, 3));
                    kotlin.g.b.p.g(format, "java.lang.String.format(locale, format, *args)");
                    bKv.put("errMsg", format);
                    jVar.dispatchEvent("onVideoError", bKv);
                } catch (JSONException e2) {
                    Log.e(jVar.TAG, "OnXWebVideoError fail", e2);
                }
            }
            m mVar = this.Jyj.Jyi;
            kotlin.g.b.p.g(str, "msg");
            kotlin.g.b.p.h(str, "msg");
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 40, 1, false);
            Log.e("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (!Util.isNullOrNil(str)) {
                if (kotlin.n.n.I(str, "MEDIA_ERR_NETWORK", true)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 41, 1, false);
                } else if (kotlin.n.n.I(str, "MEDIA_ERR_DECODE", true)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 42, 1, false);
                } else if (kotlin.n.n.I(str, "MEDIA_ERR_SRC_NOT_SUPPORTED", true)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 43, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 44, 1, false);
                }
            }
            mVar.Jym.mNz = i2;
            mVar.Jym.mNA = i3;
            m.b bVar = mVar.Jym;
            kotlin.g.b.p.h(str, "<set-?>");
            bVar.errorMsg = str;
            this.Jyj.Qt();
            AppMethodBeat.o(210741);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(210758);
        kotlin.g.b.p.h(aVar, "invokeContext");
        AppMethodBeat.o(210758);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class q implements Runnable {
        final /* synthetic */ l Jyj;
        final /* synthetic */ SurfaceTexture ihD;

        q(l lVar, SurfaceTexture surfaceTexture) {
            this.Jyj = lVar;
            this.ihD = surfaceTexture;
        }

        public final void run() {
            AppMethodBeat.i(210740);
            Log.i(this.Jyj.getTAG(), "handler(%s) handlePluginReady", this.Jyj.Lb());
            l lVar = this.Jyj;
            lVar.cJd = false;
            lVar.cJe = false;
            lVar.cJf = false;
            lVar.cJg = false;
            this.Jyj.mSurfaceTexture = this.ihD;
            this.Jyj.mSurface = new Surface(this.ihD);
            if (this.Jyj.cIV != null) {
                Log.i(this.Jyj.getTAG(), "handlePluginReady, setSurface:%s", this.ihD);
                try {
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.Jyj.cIV;
                    if (cVar != null) {
                        cVar.setSurface(this.Jyj.mSurface);
                        AppMethodBeat.o(210740);
                        return;
                    }
                    AppMethodBeat.o(210740);
                    return;
                } catch (Exception e2) {
                    Log.e(this.Jyj.getTAG(), "handlePluginReady, setSurface:ex " + e2.getMessage());
                }
            }
            AppMethodBeat.o(210740);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void e(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(210759);
        kotlin.g.b.p.h(surfaceTexture, "surfaceTexture");
        k(new q(this, surfaceTexture));
        AppMethodBeat.o(210759);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class p implements Runnable {
        final /* synthetic */ l Jyj;

        p(l lVar) {
            this.Jyj = lVar;
        }

        public final void run() {
            AppMethodBeat.i(210739);
            l.a(this.Jyj);
            Log.i(this.Jyj.getTAG(), "handler(%s) handlePluginDestroy", this.Jyj.Lb());
            this.Jyj.Qt();
            this.Jyj.Qx();
            AppMethodBeat.o(210739);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void PQ() {
        AppMethodBeat.i(210760);
        k(new p(this));
        AppMethodBeat.o(210760);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class m implements Runnable {
        final /* synthetic */ l Jyj;
        final /* synthetic */ com.tencent.luggage.xweb_ext.extendplugin.a lRn;

        m(l lVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
            this.Jyj = lVar;
            this.lRn = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0314  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x0320  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x0335  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x0351  */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x0365  */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x0379  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x03a7  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x03be  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x03e4  */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x0431  */
        /* JADX WARNING: Removed duplicated region for block: B:155:0x044b  */
        /* JADX WARNING: Removed duplicated region for block: B:157:0x0450  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x0489  */
        /* JADX WARNING: Removed duplicated region for block: B:164:0x0497  */
        /* JADX WARNING: Removed duplicated region for block: B:220:0x05f0  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x024b  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x028c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 1544
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.video.samelayer.l.m.run():void");
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final String h(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(210761);
        kotlin.g.b.p.h(aVar, "invokeContext");
        k(new m(this, aVar));
        AppMethodBeat.o(210761);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void gih() {
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar;
        AppMethodBeat.i(210762);
        Log.i(getTAG(), "createMediaPlayer");
        Handler handler = this.cJv;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.pNt) {
            fVar = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f(handler, this.bDU, this.bDY, this.mCn, this.mCo, this.mCp, this.mCq);
        } else {
            fVar = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f(handler);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Log.d(getTAG(), "createMediaPlayer cost %s", Long.valueOf(currentTimeMillis2));
        m mVar = this.Jyi;
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 10, 1, false);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 11, currentTimeMillis2, false);
        mVar.Jym.mNo = currentTimeMillis2;
        this.cIV = fVar;
        this.cJk = this.cIV != null;
        if (!this.cJk) {
            Log.e(getTAG(), "createMediaPlayer, create media player fail");
            AppMethodBeat.o(210762);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
        if (cVar != null) {
            cVar.a(new e(this));
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = this.cIV;
        if (cVar2 != null) {
            cVar2.a(new f(this));
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar3 = this.cIV;
        if (cVar3 != null) {
            cVar3.a(new g(this));
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar4 = this.cIV;
        if (cVar4 != null) {
            cVar4.a(new h(this));
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar5 = this.cIV;
        if (cVar5 != null) {
            cVar5.a(new i(this));
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar6 = this.cIV;
        if (cVar6 != null) {
            cVar6.a(new j(this));
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar7 = this.cIV;
        if (cVar7 != null) {
            cVar7.a(new k(this));
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar8 = this.cIV;
        if (cVar8 != null) {
            cVar8.a(new C2002l(this));
        }
        j jVar = this.Jyg;
        if (jVar != null) {
            jVar.bbk("StartPlayer");
            AppMethodBeat.o(210762);
            return;
        }
        AppMethodBeat.o(210762);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", WeChatBrands.Business.GROUP_MP, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
    public static final class e implements c.f {
        final /* synthetic */ l Jyj;

        e(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.f
        public final boolean cb(int i2, int i3) {
            AppMethodBeat.i(210728);
            l lVar = this.Jyj;
            boolean k = lVar.k(new v(lVar, i2, i3));
            AppMethodBeat.o(210728);
            return k;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", WeChatBrands.Business.GROUP_MP, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
    public static final class f implements c.e {
        final /* synthetic */ l Jyj;

        f(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e
        public final boolean cc(int i2, int i3) {
            AppMethodBeat.i(210729);
            l lVar = this.Jyj;
            boolean k = lVar.k(new u(lVar, i2, i3));
            AppMethodBeat.o(210729);
            return k;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
    public static final class g implements c.g {
        final /* synthetic */ l Jyj;

        g(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
            AppMethodBeat.i(210730);
            l lVar = this.Jyj;
            lVar.k(new w(lVar));
            AppMethodBeat.o(210730);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
    public static final class h implements c.b {
        final /* synthetic */ l Jyj;

        h(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b
        public final void QA() {
            AppMethodBeat.i(210731);
            l lVar = this.Jyj;
            lVar.k(new t(lVar));
            AppMethodBeat.o(210731);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
    public static final class i implements c.h {
        final /* synthetic */ l Jyj;

        i(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h
        public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
            AppMethodBeat.i(210732);
            l lVar = this.Jyj;
            lVar.k(new x(lVar));
            AppMethodBeat.o(210732);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", WeChatBrands.Business.GROUP_MP, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
    public static final class j implements c.i {
        final /* synthetic */ l Jyj;

        j(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.i
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar, int i2, int i3) {
            AppMethodBeat.i(210733);
            l lVar = this.Jyj;
            lVar.k(new y(lVar, i2, i3));
            AppMethodBeat.o(210733);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", WeChatBrands.Business.GROUP_MP, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
    public static final class k implements c.a {
        final /* synthetic */ l Jyj;

        k(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a
        public final void id(int i2) {
            AppMethodBeat.i(210734);
            l lVar = this.Jyj;
            lVar.k(new s(lVar, i2));
            AppMethodBeat.o(210734);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "selectIndex", "", "kotlin.jvm.PlatformType", "onDownstreamChanged"})
    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.video.samelayer.l$l  reason: collision with other inner class name */
    public static final class C2002l implements c.d {
        final /* synthetic */ l Jyj;

        C2002l(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.d
        public final void abu(String str) {
            String str2;
            AppMethodBeat.i(210735);
            j jVar = this.Jyj.Jyg;
            if (jVar != null) {
                try {
                    String str3 = jVar.TAG;
                    StringBuilder sb = new StringBuilder("[TRACE_ADAPTIVE] onVideoDownStreamChange selectIndex = ");
                    if (str == null) {
                        str2 = BuildConfig.COMMAND;
                    } else {
                        str2 = str;
                    }
                    Log.i(str3, sb.append(str2).toString());
                    JSONObject bKv = jVar.bKv();
                    if (str == null) {
                        str = "";
                    }
                    bKv.put("selectIndex", str);
                    jVar.dispatchEvent("onVideoDownStreamChange", bKv);
                    AppMethodBeat.o(210735);
                } catch (JSONException e2) {
                    Log.e(jVar.TAG, "onVideoDownStreamChange fail", e2);
                    AppMethodBeat.o(210735);
                }
            } else {
                AppMethodBeat.o(210735);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class s implements Runnable {
        final /* synthetic */ l Jyj;
        final /* synthetic */ int Jyl;

        s(l lVar, int i2) {
            this.Jyj = lVar;
            this.Jyl = i2;
        }

        public final void run() {
            j jVar;
            AppMethodBeat.i(210742);
            l lVar = this.Jyj;
            int i2 = this.Jyl;
            if (!lVar.cJk) {
                Log.i(lVar.getTAG(), "onMediaPlayerBufferingUpdate, mp released");
                AppMethodBeat.o(210742);
                return;
            }
            if (i2 != lVar.cJo) {
                lVar.cJo = i2;
                Log.i(lVar.getTAG(), "onBufferingUpdate, percent:%s", Integer.valueOf(i2));
            }
            if (!lVar.PS() || !lVar.cJj || (jVar = lVar.Jyg) == null) {
                AppMethodBeat.o(210742);
                return;
            }
            try {
                JSONObject bKv = jVar.bKv();
                bKv.put("buffered", i2);
                jVar.dispatchEvent("onVideoBufferUpdate", bKv);
                AppMethodBeat.o(210742);
            } catch (JSONException e2) {
                Log.e(jVar.TAG, "OnXWebVideoProgress fail", e2);
                AppMethodBeat.o(210742);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class y implements Runnable {
        final /* synthetic */ l Jyj;
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;

        y(l lVar, int i2, int i3) {
            this.Jyj = lVar;
            this.cKE = i2;
            this.cKF = i3;
        }

        public final void run() {
            j jVar;
            AppMethodBeat.i(210748);
            l lVar = this.Jyj;
            int i2 = this.cKE;
            int i3 = this.cKF;
            if (!lVar.cJk) {
                Log.i(lVar.getTAG(), "onMediaPlayerVideoSizeChanged, mp released");
                AppMethodBeat.o(210748);
                return;
            }
            int duration = lVar.getDuration();
            Log.i(lVar.getTAG(), "onVideoSizeChanged, width:%d, height:%d, duration:%d, mVideoHasPrepared:%b", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(duration), Boolean.valueOf(lVar.cJj));
            if (!(!lVar.cJj || lVar.cIV == null || ((i2 == lVar.mVideoWidth && i3 == lVar.mVideoHeight && duration == lVar.cJn) || !lVar.PS() || (jVar = lVar.Jyg) == null))) {
                Log.i(jVar.TAG, "onVideoSizeChange width=" + i2 + ", height=" + i3 + ", duration=" + duration);
                try {
                    JSONObject bKv = jVar.bKv();
                    bKv.put("width", i2);
                    bKv.put("height", i3);
                    jVar.mLe = (((double) duration) * 1.0d) / 1000.0d;
                    bKv.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, jVar.mLe);
                    jVar.dispatchEvent("onVideoSizeChange", bKv);
                } catch (JSONException e2) {
                    Log.e(jVar.TAG, "onVideoSizeChange fail", e2);
                }
            }
            lVar.mVideoWidth = i2;
            lVar.mVideoHeight = i3;
            lVar.cJn = duration;
            lVar.crw();
            AppMethodBeat.o(210748);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class x implements Runnable {
        final /* synthetic */ l Jyj;

        x(l lVar) {
            this.Jyj = lVar;
        }

        public final void run() {
            j jVar;
            AppMethodBeat.i(210747);
            l lVar = this.Jyj;
            if (!lVar.cJk) {
                Log.i(lVar.getTAG(), "onMediaPlayerSeekComplete, mp released");
                AppMethodBeat.o(210747);
                return;
            }
            j jVar2 = lVar.Jyg;
            if (jVar2 != null) {
                try {
                    jVar2.dispatchEvent("onVideoSeekEnd", jVar2.bKv());
                } catch (JSONException e2) {
                    Log.e(jVar2.TAG, "onVideoSeedEnd fail", e2);
                }
            }
            Log.i(lVar.getTAG(), "onSeekComplete");
            if (!lVar.cJd) {
                com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = lVar.cIV;
                if (cVar == null) {
                    kotlin.g.b.p.hyc();
                }
                boolean isPlaying = cVar.isPlaying();
                if (!lVar.cJe || (lVar.cJs && lVar.Jyf)) {
                    Log.i(lVar.getTAG(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", Boolean.valueOf(isPlaying));
                    if (!isPlaying && lVar.PS()) {
                        Log.i(lVar.getTAG(), "onSeekComplete, dispatch pause again");
                        j jVar3 = lVar.Jyg;
                        if (jVar3 != null) {
                            jVar3.gig();
                        }
                    }
                    if (isPlaying && lVar.cJs && lVar.Jyf) {
                        lVar.cET = new AtomicBoolean(true);
                        lVar.pause();
                    }
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = lVar.cIV;
                    if (cVar2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    long duration = (long) cVar2.getDuration();
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar3 = lVar.cIV;
                    if (cVar3 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    long currentPosition = (long) cVar3.getCurrentPosition();
                    Log.i(lVar.getTAG(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", Boolean.valueOf(isPlaying), Long.valueOf(currentPosition), Long.valueOf(duration));
                    lVar.cJe = false;
                    if (currentPosition / 1000 < duration / 1000) {
                        Log.i(lVar.getTAG(), "onSeekComplete, video not end");
                        if (isPlaying && lVar.PS()) {
                            Log.i(lVar.getTAG(), "onSeekComplete, dispatch play again");
                            j jVar4 = lVar.Jyg;
                            if (jVar4 != null) {
                                jVar4.gif();
                                AppMethodBeat.o(210747);
                                return;
                            }
                            AppMethodBeat.o(210747);
                            return;
                        }
                    } else {
                        Log.i(lVar.getTAG(), "onSeekComplete, video ends");
                        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar4 = lVar.cIV;
                        if (cVar4 != null) {
                            cVar4.pause();
                        }
                        if (lVar.PS() && (jVar = lVar.Jyg) != null) {
                            jVar.gif();
                        }
                        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar5 = lVar.cIV;
                        if (cVar5 != null) {
                            cVar5.start();
                            AppMethodBeat.o(210747);
                            return;
                        }
                        AppMethodBeat.o(210747);
                        return;
                    }
                }
                AppMethodBeat.o(210747);
            } else if (!lVar.cJs || !lVar.Jyf) {
                Log.i(lVar.getTAG(), "onSeekComplete, start when seek complete");
                lVar.cJd = false;
                lVar.zt(true);
                AppMethodBeat.o(210747);
            } else {
                Log.e(lVar.getTAG(), "onSeekComplete, background not allow play");
                AppMethodBeat.o(210747);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class t implements Runnable {
        final /* synthetic */ l Jyj;

        t(l lVar) {
            this.Jyj = lVar;
        }

        public final void run() {
            j jVar;
            AppMethodBeat.i(210743);
            l lVar = this.Jyj;
            if (!lVar.cJk) {
                Log.i(lVar.getTAG(), "onMediaPlayerCompletion, mp released");
                AppMethodBeat.o(210743);
                return;
            }
            Log.i(lVar.getTAG(), "onCompletion");
            if (lVar.PS() && (jVar = lVar.Jyg) != null) {
                try {
                    jVar.dispatchEvent("onVideoEnded", jVar.bKv());
                } catch (JSONException e2) {
                    Log.e(jVar.TAG, "OnXWebVideoEnded fail", e2);
                }
                jVar.bKw();
                jVar.bMk();
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = lVar.cIV;
            if (cVar != null) {
                m mVar = lVar.Jyi;
                com.tencent.luggage.xweb_ext.extendplugin.a aVar = lVar.cED;
                kotlin.g.b.p.h(cVar, "mediaPlayer");
                if (!Util.isNullOrNil(mVar.Jym.videoPath) && mVar.Jym.mNq > 0) {
                    mVar.Jym.mNy = Util.nowMilliSecond();
                    mVar.a(aVar, cVar, "onMediaPlayerVideoEnd");
                }
            }
            if (lVar.cJl) {
                Log.i(lVar.getTAG(), "onCompletion, video loop playing");
                lVar.cJd = true;
                lVar.seek(0);
                AppMethodBeat.o(210743);
                return;
            }
            Log.i(lVar.getTAG(), "onCompletion, video end playing");
            lVar.cJr = true;
            AppMethodBeat.o(210743);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class w implements Runnable {
        final /* synthetic */ l Jyj;

        w(l lVar) {
            this.Jyj = lVar;
        }

        public final void run() {
            boolean z;
            int i2;
            AppMethodBeat.i(210746);
            l lVar = this.Jyj;
            if (!lVar.cJk) {
                Log.i(lVar.getTAG(), "onMediaPlayerPrepared, mp released");
                AppMethodBeat.o(210746);
                return;
            }
            Log.i(lVar.getTAG(), "onPrepared");
            lVar.cJj = true;
            lVar.crw();
            m mVar = lVar.Jyi;
            int duration = lVar.getDuration();
            if (mVar.Jym.mNr <= 0) {
                mVar.Jym.mNr = Util.nowMilliSecond();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 21, 1, false);
                long j2 = mVar.Jym.mNr - mVar.Jym.mNq;
                mVar.Jym.mNs = j2;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 22, j2, false);
                Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", Long.valueOf(j2));
            }
            if (mVar.Jym.duration <= 0 && duration > 0) {
                long j3 = (long) ((1.0d * ((double) duration)) / 1000.0d);
                mVar.Jym.duration = j3;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 26, 1, false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 24, j3, false);
                Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", Long.valueOf(j3));
            }
            if (lVar.PS()) {
                j jVar = lVar.Jyg;
                if (jVar != null) {
                    jVar.bbk("WaitingPlay");
                }
                j jVar2 = lVar.Jyg;
                if (jVar2 != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = lVar.cIV;
                    int videoWidth = cVar != null ? cVar.getVideoWidth() : 0;
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = lVar.cIV;
                    if (cVar2 != null) {
                        i2 = cVar2.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    int duration2 = lVar.getDuration();
                    Log.i(jVar2.TAG, "onVideoLoadedMetaData width=" + videoWidth + ", height=" + i2 + ", duration=" + duration2);
                    try {
                        JSONObject bKv = jVar2.bKv();
                        bKv.put("width", videoWidth);
                        bKv.put("height", i2);
                        jVar2.mLe = (((double) duration2) * 1.0d) / 1000.0d;
                        bKv.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, jVar2.mLe);
                        jVar2.dispatchEvent("onVideoLoadedMetaData", bKv);
                    } catch (JSONException e2) {
                        Log.e(jVar2.TAG, "onVideoLoadedMetaData fail", e2);
                    }
                }
            }
            long j4 = lVar.cJh;
            if (j4 > 0) {
                lVar.seek(j4);
                lVar.cJh = 0;
            }
            Log.d(lVar.getTAG(), "onPrepared, webViewInBackgroun = " + lVar.cJs);
            if (lVar.cJs) {
                Log.i(lVar.getTAG(), "onPrepared, stop video auto play when webview in background");
                if (lVar.cJi || lVar.cJg) {
                    z = true;
                } else {
                    z = false;
                }
                lVar.cET = new AtomicBoolean(z);
                AppMethodBeat.o(210746);
            } else if (lVar.cJi || lVar.cJg) {
                Log.i(lVar.getTAG(), "onPrepared, start play when prepared, mStartWhenPrepared:%s, mControlStartWhenPrepared:%s", Boolean.valueOf(lVar.cJi), Boolean.valueOf(lVar.cJg));
                lVar.zt(true);
                AppMethodBeat.o(210746);
            } else {
                Log.i(lVar.getTAG(), "onPrepared, not set start play when prepared");
                AppMethodBeat.o(210746);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class u implements Runnable {
        final /* synthetic */ l Jyj;
        final /* synthetic */ int pNG;
        final /* synthetic */ int pNH;

        u(l lVar, int i2, int i3) {
            this.Jyj = lVar;
            this.pNG = i2;
            this.pNH = i3;
        }

        public final void run() {
            AppMethodBeat.i(210744);
            l lVar = this.Jyj;
            int i2 = this.pNG;
            int i3 = this.pNH;
            if (!lVar.cJk) {
                Log.i(lVar.getTAG(), "onMediaPlayerError, mp released");
                AppMethodBeat.o(210744);
                return;
            }
            Log.i(lVar.getTAG(), "onError, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cVar = lVar.cIY;
            if (cVar != null) {
                cVar.cd(i2, i3);
                AppMethodBeat.o(210744);
                return;
            }
            AppMethodBeat.o(210744);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class v implements Runnable {
        final /* synthetic */ l Jyj;
        final /* synthetic */ int pNG;
        final /* synthetic */ int pNH;

        v(l lVar, int i2, int i3) {
            this.Jyj = lVar;
            this.pNG = i2;
            this.pNH = i3;
        }

        public final void run() {
            AppMethodBeat.i(210745);
            this.Jyj.ks(this.pNG, this.pNH);
            AppMethodBeat.o(210745);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean ks(int i2, int i3) {
        j jVar;
        AppMethodBeat.i(210763);
        if (!this.cJk) {
            Log.i(getTAG(), "onMediaPlayerInfo, mp released");
            AppMethodBeat.o(210763);
        } else {
            Log.i(getTAG(), "onInfo, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 701) {
                com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
                this.cJf = cVar != null && cVar.isPlaying();
                Log.i(getTAG(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", Boolean.valueOf(this.cJf));
                if (PS() && (jVar = this.Jyg) != null) {
                    jVar.onVideoWaiting();
                }
                m mVar = this.Jyi;
                if (mVar.Jym.mNv <= 0) {
                    mVar.Jym.mNt++;
                    mVar.Jym.mNv = Util.nowMilliSecond();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 30, 1, false);
                }
            } else if (i2 == 702) {
                com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = this.cIV;
                boolean z2 = cVar2 != null && cVar2.isPlaying();
                Log.i(getTAG(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", Boolean.valueOf(this.cJf), Boolean.valueOf(z2));
                if (this.cJf) {
                    this.cJf = false;
                    if (z2 && PS()) {
                        Log.i(getTAG(), "onInfo, buffering end, notify video play");
                        j jVar2 = this.Jyg;
                        if (jVar2 != null) {
                            jVar2.gif();
                        }
                    }
                } else if (!z2 && PS()) {
                    Log.i(getTAG(), "onInfo, buffering end, notify video pause");
                    j jVar3 = this.Jyg;
                    if (jVar3 != null) {
                        jVar3.gig();
                    }
                }
                m mVar2 = this.Jyi;
                if (mVar2.Jym.mNw <= 0 && mVar2.Jym.mNv > 0) {
                    mVar2.Jym.mNw = Util.nowMilliSecond();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 31, 1, false);
                    long j2 = mVar2.Jym.mNw - mVar2.Jym.mNv;
                    mVar2.Jym.mNu += j2;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 32, j2, false);
                    Log.i("MicroMsg.WebViewVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", Long.valueOf(j2));
                }
                m.b bVar = mVar2.Jym;
                bVar.mNv = 0;
                bVar.mNw = 0;
            } else if (i3 == -1004) {
                Log.i(getTAG(), "onInfo, special error, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cVar3 = this.cIY;
                if (cVar3 != null) {
                    cVar3.cd(i2, i3);
                }
            } else if (i2 == 3) {
                if (!this.cJk) {
                    Log.i(getTAG(), "onMediaPlayerVideoFirstFrame, mp released");
                } else {
                    Log.i(getTAG(), "onMediaPlayerVideoFirstFrame");
                }
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar4 = this.cIV;
            if (cVar4 != null && cVar4.isPlaying() && this.cJs && this.Jyf) {
                this.cET = new AtomicBoolean(true);
                pause();
            }
            AppMethodBeat.o(210763);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void crw() {
        AppMethodBeat.i(210764);
        if (Util.isNullOrNil(this.cJq)) {
            Log.i(getTAG(), "adjust objectFit, no video objectFit");
        } else if (!this.cJj || QJ() == null || this.Jyh == null) {
            Log.i(getTAG(), "adjust objectFit, video not prepared");
            AppMethodBeat.o(210764);
            return;
        } else if (this.Jyh.a(this.cJq, this.cEF, this.cEG, this.mVideoWidth, this.mVideoHeight)) {
            this.cJD = this.Jyh.QH();
            this.cJE = this.Jyh.QI();
            Log.i(getTAG(), "adjust objectFit:%s, scale:[%s, %s]", this.cJq, Float.valueOf(this.cJD), Float.valueOf(this.cJE));
            com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), getType(), getId(), this.cJD, this.cJE);
            AppMethodBeat.o(210764);
            return;
        }
        AppMethodBeat.o(210764);
    }

    /* access modifiers changed from: package-private */
    public final void prepareAsync() {
        AppMethodBeat.i(210765);
        if (this.cIV != null) {
            Log.i(getTAG(), "video prepare async");
            if (PS()) {
                j jVar = this.Jyg;
                if (jVar != null) {
                    jVar.onVideoWaiting();
                }
                j jVar2 = this.Jyg;
                if (jVar2 != null) {
                    jVar2.bbk("StartDownload");
                }
            }
            this.cJj = false;
            this.cJg = false;
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
            if (cVar != null) {
                cVar.prepareAsync();
            }
            m mVar = this.Jyi;
            if (mVar.Jym.mNq <= 0) {
                mVar.Jym.mNq = Util.nowMilliSecond();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 20, 1, false);
            }
        }
        AppMethodBeat.o(210765);
    }

    /* access modifiers changed from: package-private */
    public final void gii() {
        AppMethodBeat.i(210766);
        this.cJs = true;
        Log.d(getTAG(), "handleWebViewBackground");
        com.tencent.mm.ac.d.h(new n(this));
        k(new o(this));
        AppMethodBeat.o(210766);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class o implements Runnable {
        final /* synthetic */ l Jyj;

        o(l lVar) {
            this.Jyj = lVar;
        }

        public final void run() {
            AppMethodBeat.i(210738);
            if (this.Jyj.Jyf) {
                if (this.Jyj.cIV != null && this.Jyj.cJj && this.Jyj.cET == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.Jyj.cIV;
                    boolean z = cVar != null && cVar.isPlaying();
                    this.Jyj.cET = new AtomicBoolean(z);
                    Log.i(this.Jyj.getTAG(), "handleWebViewBackground runnable, video playing state when enter background:%s", Boolean.valueOf(z));
                    this.Jyj.pause();
                    AppMethodBeat.o(210738);
                    return;
                }
            } else if (this.Jyj.Qo()) {
                Log.i(this.Jyj.getTAG(), "handleWebViewBackground, video not auto pause, try resume, type:%s", this.Jyj.type);
                this.Jyj.zt(true);
                AppMethodBeat.o(210738);
                return;
            } else {
                Log.i(this.Jyj.getTAG(), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", this.Jyj.type);
            }
            AppMethodBeat.o(210738);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$registerLifecycleListener$1", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "onBackground", "", "type", "", "onDestroy", "onForeground", "plugin-webview_release"})
    public static final class ab implements a.AbstractC0188a {
        final /* synthetic */ l Jyj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        ab(l lVar) {
            this.Jyj = lVar;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
        public final void onForeground() {
            AppMethodBeat.i(210751);
            l lVar = this.Jyj;
            lVar.cJs = false;
            Log.d(lVar.getTAG(), "handleWebViewForeground");
            boolean Qo = lVar.Qo();
            lVar.cET = null;
            if (lVar.cIV != null && lVar.cJj && Qo) {
                Log.i(lVar.getTAG(), "handleWebViewForeground runnable, video playing when enter background");
                lVar.zt(false);
            }
            AppMethodBeat.o(210751);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
        public final void hU(int i2) {
            AppMethodBeat.i(210752);
            this.Jyj.gii();
            AppMethodBeat.o(210752);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
        public final void onDestroy() {
            AppMethodBeat.i(210753);
            this.Jyj.release();
            AppMethodBeat.o(210753);
        }
    }

    /* access modifiers changed from: package-private */
    public final void release() {
        Context context;
        com.tencent.mm.plugin.webview.d.f fVar;
        AppMethodBeat.i(210767);
        Log.i(getTAG(), "video release");
        com.tencent.mm.ac.d.h(new ac(this));
        if (this.Jyg instanceof j) {
            j jVar = this.Jyg;
            if (jVar == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler");
                AppMethodBeat.o(210767);
                throw tVar;
            }
            f fVar2 = jVar.JxW;
            if (fVar2 == null || (fVar = fVar2.JxI) == null) {
                context = null;
            } else {
                context = fVar.context;
            }
            if (!(context instanceof c)) {
                context = null;
            }
            c cVar = (c) context;
            if (cVar != null) {
                cVar.b(jVar.JxZ);
            }
            com.tencent.mm.bo.a aVar = jVar.Jii;
            if (aVar != null) {
                aVar.disable();
            }
            if (jVar.Jyb != null) {
                try {
                    Context context2 = MMApplicationContext.getContext();
                    kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
                    ContentResolver contentResolver = context2.getContentResolver();
                    ContentObserver contentObserver = jVar.Jyb;
                    if (contentObserver == null) {
                        kotlin.g.b.p.hyc();
                    }
                    contentResolver.unregisterContentObserver(contentObserver);
                } catch (Throwable th) {
                    Log.printErrStackTrace(jVar.TAG, th, "unregisterContentObserver", new Object[0]);
                }
            }
            if (jVar.Jyc != null) {
                try {
                    MMApplicationContext.getContext().unregisterReceiver(jVar.Jyc);
                } catch (Throwable th2) {
                    Log.printErrStackTrace(jVar.TAG, th2, "unregisterContentObserver", new Object[0]);
                }
            }
        }
        Qt();
        Qu();
        j jVar2 = this.Jyg;
        if (jVar2 != null) {
            jVar2.bKw();
        }
        this.Jyg = null;
        if (this.cIY != null) {
            this.cIY = null;
        }
        Qx();
        Log.i(getTAG(), "video release handler thread");
        this.cJv.removeCallbacksAndMessages(null);
        this.cJw.quitSafely();
        AppMethodBeat.o(210767);
    }

    /* access modifiers changed from: package-private */
    public final void gij() {
        AppMethodBeat.i(210768);
        this.cJr = false;
        Qu();
        gih();
        if (this.cIV != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
            if (cVar != null) {
                cVar.setMute(this.cJm);
            }
            if (this.mSurface != null) {
                if (!this.cJs) {
                    Log.i(getTAG(), "applyMediaPlayerParams, setSurface");
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = this.cIV;
                    if (cVar2 != null) {
                        cVar2.setSurface(this.mSurface);
                        AppMethodBeat.o(210768);
                        return;
                    }
                    AppMethodBeat.o(210768);
                    return;
                }
                Log.i(getTAG(), "applyMediaPlayerParams, setSurface, WebViewInBackground");
            }
        }
        AppMethodBeat.o(210768);
    }

    private final synchronized void Qu() {
        AppMethodBeat.i(210769);
        if (this.cIV != null) {
            Log.i(getTAG(), "releaseMediaPlayer");
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
            if (cVar != null) {
                cVar.a((c.f) null);
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = this.cIV;
            if (cVar2 != null) {
                cVar2.a((c.e) null);
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar3 = this.cIV;
            if (cVar3 != null) {
                cVar3.a((c.g) null);
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar4 = this.cIV;
            if (cVar4 != null) {
                cVar4.a((c.b) null);
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar5 = this.cIV;
            if (cVar5 != null) {
                cVar5.a((c.h) null);
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar6 = this.cIV;
            if (cVar6 != null) {
                cVar6.a((c.i) null);
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar7 = this.cIV;
            if (cVar7 != null) {
                cVar7.stop();
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar8 = this.cIV;
            if (cVar8 != null) {
                cVar8.reset();
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar9 = this.cIV;
            if (cVar9 != null) {
                cVar9.release();
            }
        }
        this.cIV = null;
        this.cJk = false;
        AppMethodBeat.o(210769);
    }

    /* access modifiers changed from: package-private */
    public final void Qx() {
        AppMethodBeat.i(210770);
        if (this.mSurface != null) {
            Surface surface = this.mSurface;
            if (surface == null) {
                kotlin.g.b.p.hyc();
            }
            surface.release();
            this.mSurface = null;
        }
        AppMethodBeat.o(210770);
    }

    /* access modifiers changed from: package-private */
    public final boolean k(Runnable runnable) {
        AppMethodBeat.i(210771);
        if (kotlin.g.b.p.j(this.cJv.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            this.cJv.post(runnable);
        }
        AppMethodBeat.o(210771);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean PS() {
        return this.cEJ && this.Jyg != null;
    }

    public final int getCurrentPosition() {
        AppMethodBeat.i(210772);
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
        if (cVar != null) {
            int currentPosition = cVar.getCurrentPosition();
            AppMethodBeat.o(210772);
            return currentPosition;
        }
        AppMethodBeat.o(210772);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int getDuration() {
        AppMethodBeat.i(210773);
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
        if (cVar != null) {
            int duration = cVar.getDuration();
            AppMethodBeat.o(210773);
            return duration;
        }
        AppMethodBeat.o(210773);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zt(boolean z2) {
        j jVar;
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar;
        j jVar2;
        AppMethodBeat.i(210774);
        if (this.cJs && this.Jyf) {
            Log.e(getTAG(), "play, background not allow play");
            AppMethodBeat.o(210774);
            return true;
        } else if (this.cIV != null) {
            com.tencent.mm.ac.d.h(new aa(this));
            if (this.cJj && (cVar = this.cIV) != null && cVar.isPlaying()) {
                Log.i(getTAG(), "video play, video is playing");
                if (PS() && (jVar2 = this.Jyg) != null) {
                    jVar2.gif();
                }
                AppMethodBeat.o(210774);
                return true;
            } else if (!this.cJj) {
                Log.i(getTAG(), "video play, video not prepared yet, start until prepared");
                this.cJg = true;
                AppMethodBeat.o(210774);
                return true;
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = this.cIV;
                if (cVar2 == null || cVar2.getState() != 5) {
                    if (!this.cJr) {
                        Log.i(getTAG(), "video play");
                        if (this.cIV != null) {
                            if (PS() && (jVar = this.Jyg) != null) {
                                jVar.gif();
                            }
                            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar3 = this.cIV;
                            if (cVar3 != null) {
                                cVar3.start();
                            }
                        }
                        AppMethodBeat.o(210774);
                        return true;
                    } else if (!z2) {
                        Log.i(getTAG(), "video has ended playing, do not restart");
                        AppMethodBeat.o(210774);
                        return false;
                    } else {
                        Log.i(getTAG(), "video play, video has ended playing, clear surface and start again");
                        this.cJr = false;
                        try {
                            if (this.mSurfaceTexture != null && this.cJj) {
                                Log.i(getTAG(), "clearSurfaceTexture");
                                SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                                if (surfaceTexture == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                EGL egl = EGLContext.getEGL();
                                if (egl == null) {
                                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
                                    AppMethodBeat.o(210774);
                                    throw tVar;
                                }
                                EGL10 egl10 = (EGL10) egl;
                                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                                egl10.eglInitialize(eglGetDisplay, null);
                                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                                egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
                                EGLConfig eGLConfig = eGLConfigArr[0];
                                EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                                EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
                                egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                                GLES20.glClear(16384);
                                egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                                egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                                egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                                egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                                egl10.eglTerminate(eglGetDisplay);
                            }
                        } catch (Exception e2) {
                            Log.printErrStackTrace(getTAG(), e2, "clearSurfaceTexture error", new Object[0]);
                        }
                        gij();
                        if (this.cIV != null) {
                            this.cJi = true;
                            setDataSourceWithCustomKey(this.cJp);
                            String tag = getTAG();
                            Object[] objArr = new Object[1];
                            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar4 = this.cIV;
                            if (cVar4 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            objArr[0] = Integer.valueOf(cVar4.getState());
                            Log.i(tag, "video play, media player state:%s", objArr);
                            prepareAsync();
                            this.cJg = true;
                        }
                        AppMethodBeat.o(210774);
                        return true;
                    }
                } else if (!z2) {
                    Log.i(getTAG(), "video has ended playing, do not restart");
                    AppMethodBeat.o(210774);
                    return false;
                } else {
                    Log.i(getTAG(), "video play, video has stopped now, try prepare and start when prepared");
                    prepareAsync();
                    this.cJg = true;
                    AppMethodBeat.o(210774);
                    return true;
                }
            }
        } else {
            AppMethodBeat.o(210774);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean pause() {
        j jVar;
        AppMethodBeat.i(210775);
        com.tencent.mm.ac.d.h(new z(this));
        if (this.cIV == null) {
            AppMethodBeat.o(210775);
            return false;
        } else if (!this.cJj) {
            Log.i(getTAG(), "video pause, video not prepared yet, pause video when prepared");
            this.cJg = false;
            AppMethodBeat.o(210775);
            return true;
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
            if (cVar == null || !cVar.isPlaying()) {
                Log.i(getTAG(), "video pause, video is not playing");
                AppMethodBeat.o(210775);
                return true;
            }
            Log.i(getTAG(), "video pause");
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = this.cIV;
            if (cVar2 != null) {
                cVar2.pause();
            }
            if (PS() && (jVar = this.Jyg) != null) {
                jVar.gig();
            }
            AppMethodBeat.o(210775);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ l Jyj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(l lVar) {
            super(0);
            this.Jyj = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(210724);
            String str = "MicroMsg.WebViewVideoPluginHandler" + this.Jyj.Lb() + '-' + this.Jyj.hashCode();
            AppMethodBeat.o(210724);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean Qt() {
        j jVar;
        AppMethodBeat.i(210776);
        com.tencent.mm.ac.d.h(new ad(this));
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
        if (cVar != null) {
            this.Jyi.a(this.cED, cVar);
            if (!this.cJj) {
                Log.i(getTAG(), "video stop, video not prepared yet, stop video when prepared");
                this.cJg = false;
                AppMethodBeat.o(210776);
                return true;
            }
            Log.i(getTAG(), "video stop");
            cVar.stop();
            if (PS() && (jVar = this.Jyg) != null) {
                jVar.gig();
            }
            AppMethodBeat.o(210776);
            return true;
        }
        AppMethodBeat.o(210776);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void seek(long j2) {
        boolean z2;
        j jVar;
        AppMethodBeat.i(210777);
        if (!this.cJj || this.cIV == null) {
            this.cJh = j2;
        } else {
            if (PS() && (jVar = this.Jyg) != null) {
                jVar.onVideoWaiting();
            }
            if (this.cIV != null) {
                com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
                if (cVar != null) {
                    z2 = cVar.isPlaying();
                } else {
                    z2 = false;
                }
                this.cJe = z2;
                long min = Math.min((long) getDuration(), Math.max(0L, j2));
                Log.i(getTAG(), "seek, position:%s, isPlaying:%s", Long.valueOf(min), Boolean.valueOf(this.cJe));
                com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = this.cIV;
                if (cVar2 != null) {
                    cVar2.seekTo(min);
                    AppMethodBeat.o(210777);
                    return;
                }
                AppMethodBeat.o(210777);
                return;
            }
        }
        AppMethodBeat.o(210777);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void s(Bitmap bitmap) {
        Bitmap bitmap2;
        AppMethodBeat.i(210778);
        super.s(bitmap);
        com.tencent.luggage.xweb_ext.extendplugin.a aVar = this.cJx;
        if (aVar == null) {
            Log.w(getTAG(), "handlePluginScreenshotTaken, invokeContext is null");
            AppMethodBeat.o(210778);
        } else if (bitmap == null) {
            Log.w(getTAG(), "handlePluginScreenshotTaken, bitmap is null");
            aVar.dP("fail");
            AppMethodBeat.o(210778);
        } else {
            if (this.cEF == 0 || this.cEG == 0) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (this.cJD * ((float) this.cEF)), (int) (this.cJE * ((float) this.cEG)), false);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            byte[] encode = Base64.encode(byteArrayOutputStream.toByteArray(), 2);
            kotlin.g.b.p.g(encode, "Base64.encode(b, Base64.NO_WRAP)");
            Charset charset = StandardCharsets.UTF_8;
            kotlin.g.b.p.g(charset, "StandardCharsets.UTF_8");
            String str = new String(encode, charset);
            Log.i(getTAG(), "handlePluginScreenshotTaken size=" + str.length());
            HashMap hashMap = new HashMap();
            hashMap.put("image", str);
            aVar.f("ok", hashMap);
            aI(bitmap);
            aI(bitmap2);
            this.cJx = null;
            AppMethodBeat.o(210778);
        }
    }

    private final void aI(Bitmap bitmap) {
        AppMethodBeat.i(210779);
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i(getTAG(), "bitmap recycle ".concat(String.valueOf(bitmap)));
            bitmap.recycle();
        }
        AppMethodBeat.o(210779);
    }

    /* access modifiers changed from: package-private */
    public final void B(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        JSONObject optJSONObject;
        boolean z2 = false;
        AppMethodBeat.i(210780);
        JSONObject Ps = aVar.Ps();
        if (Ps == null || (optJSONObject = Ps.optJSONObject("playerConfig")) == null) {
            AppMethodBeat.o(210780);
            return;
        }
        this.bDU = optJSONObject.optInt("maxInitialBitrate", 0);
        this.bDY = (float) optJSONObject.optDouble("bandwidthFraction", 0.0d);
        this.mCn = optJSONObject.optInt("minDurForQualityMs", 0);
        this.mCo = optJSONObject.optInt("maxDurForQualityMs", 0);
        this.mCp = optJSONObject.optInt("minBufferMs", 0);
        this.mCq = optJSONObject.optInt("maxBufferMs", 0);
        if (!(this.bDU == 0 || this.bDY == 0.0f || this.mCn == 0 || this.mCo == 0 || this.mCp == 0 || this.mCq == 0)) {
            z2 = true;
        }
        this.pNt = z2;
        Log.i(getTAG(), "setExoPlayerParam checkExoPlayerParam result = " + this.pNt);
        AppMethodBeat.o(210780);
    }

    /* access modifiers changed from: package-private */
    public final void C(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(210781);
        D(aVar);
        com.tencent.f.h.RTc.n(new d(this, aVar), 2000);
        AppMethodBeat.o(210781);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ l Jyj;
        final /* synthetic */ com.tencent.luggage.xweb_ext.extendplugin.a lRn;

        d(l lVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
            this.Jyj = lVar;
            this.lRn = aVar;
        }

        public final void run() {
            AppMethodBeat.i(210727);
            this.Jyj.D(this.lRn);
            AppMethodBeat.o(210727);
        }
    }

    /* access modifiers changed from: package-private */
    public final void D(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(210782);
        if (!this.cJs && (aVar.getContext() instanceof MMActivity)) {
            Context context = aVar.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(210782);
                throw tVar;
            } else if (((MMActivity) context).isPaused()) {
                Log.w(getTAG(), "checkPause, onBackGround");
                gii();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1379, 0, 1, false);
            }
        }
        AppMethodBeat.o(210782);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler$audioRespond$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-webview_release"})
    public static final class c implements d.a {
        c() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTw() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTy() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTx() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTz() {
        }
    }

    /* access modifiers changed from: package-private */
    public final void setDataSourceWithCustomKey(String str) {
        AppMethodBeat.i(210784);
        if (getAbTestVideoPreload()) {
            String aaV = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().aaV(str);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cIV;
            if (!(cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
                cVar = null;
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = (com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) cVar;
            if (fVar != null) {
                fVar.dV(str, aaV);
            }
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar2 = this.cIV;
            if (cVar2 != null) {
                cVar2.setDataSource(str);
            }
        }
        j jVar = this.Jyg;
        if (jVar != null) {
            jVar.aX(com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().f(str, 0, MAlarmHandler.NEXT_FIRE_INTERVAL));
            AppMethodBeat.o(210784);
            return;
        }
        AppMethodBeat.o(210784);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ l Jyj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(l lVar) {
            super(0);
            this.Jyj = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(210737);
            this.Jyj.hWh.apm();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(210737);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ l Jyj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(l lVar) {
            super(0);
            this.Jyj = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(210754);
            this.Jyj.hWh.apm();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(210754);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ l Jyj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(l lVar) {
            super(0);
            this.Jyj = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(210750);
            this.Jyj.hWh.a(this.Jyj.Goc);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(210750);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class z extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ l Jyj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(l lVar) {
            super(0);
            this.Jyj = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(210749);
            this.Jyj.hWh.apm();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(210749);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class ad extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ l Jyj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ad(l lVar) {
            super(0);
            this.Jyj = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(210755);
            this.Jyj.hWh.apm();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(210755);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final b Jyk = new b();

        static {
            AppMethodBeat.i(210726);
            AppMethodBeat.o(210726);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(210725);
            com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
            if ((bVar == null || bVar.a(b.a.clicfg_open_timeline_video_preload, 0) != 1) && !BuildInfo.IS_FLAVOR_RED && !BuildInfo.DEBUG && !WeChatEnvironment.hasDebugger()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(210725);
            return valueOf;
        }
    }
}
