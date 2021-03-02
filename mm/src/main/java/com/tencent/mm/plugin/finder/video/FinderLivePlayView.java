package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\nH\u0016J\b\u0010A\u001a\u00020\u0010H\u0016J\b\u0010B\u001a\u00020\u0010H\u0016J\n\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020\nH\u0016J\b\u0010F\u001a\u00020?H\u0016J\n\u0010G\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010H\u001a\u0004\u0018\u00010%H\u0016J\b\u0010I\u001a\u00020\u0000H\u0016J\b\u0010J\u001a\u00020\u0010H\u0016J\u0006\u0010K\u001a\u00020LJ\b\u0010M\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010N\u001a\u00020LH\u0016J\b\u0010O\u001a\u00020LH\u0016J\b\u0010P\u001a\u00020\u0010H\u0016J\b\u0010Q\u001a\u00020\nH\u0016J\b\u0010R\u001a\u00020\u0010H\u0016J\b\u0010S\u001a\u00020\u0010H\u0016J\u0010\u0010T\u001a\u00020L2\u0006\u0010U\u001a\u00020\rH\u0002J\b\u0010V\u001a\u00020LH\u0016J\u0018\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u0010H\u0016J\u0012\u0010[\u001a\u00020L2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\u0010\u0010^\u001a\u00020L2\u0006\u0010_\u001a\u000207H\u0016J\u0010\u0010`\u001a\u00020L2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020L2\u0006\u0010d\u001a\u00020\u0010H\u0016J\u0010\u0010e\u001a\u00020L2\u0006\u0010f\u001a\u00020\u0010H\u0016J\u0010\u0010g\u001a\u00020L2\u0006\u0010h\u001a\u00020\u0010H\u0016J\u0010\u0010i\u001a\u00020L2\u0006\u0010j\u001a\u00020\u0010H\u0016J\u0010\u0010k\u001a\u00020L2\u0006\u0010l\u001a\u00020\u0010H\u0016J\u0010\u0010m\u001a\u00020L2\u0006\u0010n\u001a\u00020\u0010H\u0016J\u0010\u0010o\u001a\u00020L2\u0006\u0010p\u001a\u00020qH\u0016J \u0010r\u001a\u00020L2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u00102\u0006\u0010v\u001a\u00020wH\u0016J\u0010\u0010x\u001a\u00020L2\u0006\u0010y\u001a\u00020zH\u0016J\u0010\u0010{\u001a\u00020L2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010|\u001a\u00020L2\u0006\u0010}\u001a\u00020\u0010H\u0016J\u0010\u0010~\u001a\u00020L2\u0006\u0010\u001a\u00020\rH\u0002J\t\u0010\u0001\u001a\u00020\u0010H\u0016J\t\u0010\u0001\u001a\u00020LH\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u001c\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderLivePlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "curPlayerStatus", "isAutoJustRenderMode", "", "()Z", "setAutoJustRenderMode", "(Z)V", "isNeverStart", "setNeverStart", "isPause", "isPreviewing", "isShouldPlayResume", "setShouldPlayResume", "isSupportPauseResume", "setSupportPauseResume", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "playListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "getPlayListener", "()Lcom/tencent/rtmp/ITXLivePlayListener;", "textureView", "Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;)V", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "getTxLivePlayer", "()Lcom/tencent/rtmp/TXLivePlayer;", "setTxLivePlayer", "(Lcom/tencent/rtmp/TXLivePlayer;)V", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "getVideoViewFocused", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "isPlaying", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", AssetExtension.SCENE_PLAY, "prepareToPlay", SharePatchInfo.FINGER_PRINT, "str", "removeVideoFooterView", "seekTo", AppMeasurement.Param.TIMESTAMP, "", "afterSeekPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "downloadUrl", "startOrPlay", "stop", "plugin-finder_release"})
public final class FinderLivePlayView extends FrameLayout implements r {
    private final String TAG = "Finder.FinderLivePlayView";
    private boolean dLD;
    private int hCl;
    public TXLivePlayer hwO;
    private boolean sZd;
    private boolean wcA;
    private boolean wcB;
    private volatile boolean wcC = true;
    private boolean wcD;
    public d wcu;
    private i.b wcv;
    private y wcw;
    boolean wcx;
    private s wcy;
    private final ITXLivePlayListener wcz = new a(this);

    public static final /* synthetic */ void a(FinderLivePlayView finderLivePlayView, String str) {
        AppMethodBeat.i(254048);
        finderLivePlayView.print(str);
        AppMethodBeat.o(254048);
    }

    public static final /* synthetic */ void b(FinderLivePlayView finderLivePlayView, String str) {
        AppMethodBeat.i(254049);
        finderLivePlayView.start(str);
        AppMethodBeat.o(254049);
    }

    public final TXLivePlayer getTxLivePlayer() {
        AppMethodBeat.i(254017);
        TXLivePlayer tXLivePlayer = this.hwO;
        if (tXLivePlayer == null) {
            p.btv("txLivePlayer");
        }
        AppMethodBeat.o(254017);
        return tXLivePlayer;
    }

    public final void setTxLivePlayer(TXLivePlayer tXLivePlayer) {
        AppMethodBeat.i(254018);
        p.h(tXLivePlayer, "<set-?>");
        this.hwO = tXLivePlayer;
        AppMethodBeat.o(254018);
    }

    public final d getTextureView() {
        AppMethodBeat.i(254019);
        d dVar = this.wcu;
        if (dVar == null) {
            p.btv("textureView");
        }
        AppMethodBeat.o(254019);
        return dVar;
    }

    public final void setTextureView(d dVar) {
        AppMethodBeat.i(254020);
        p.h(dVar, "<set-?>");
        this.wcu = dVar;
        AppMethodBeat.o(254020);
    }

    public final i.b getVideoViewCallback() {
        return this.wcv;
    }

    public final void setVideoViewCallback(i.b bVar) {
        this.wcv = bVar;
    }

    public final y getLifecycle() {
        return this.wcw;
    }

    public final void setLifecycle(y yVar) {
        this.wcw = yVar;
    }

    public final void setAutoJustRenderMode(boolean z) {
        this.wcx = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLivePlayView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(254045);
        init();
        AppMethodBeat.o(254045);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLivePlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254046);
        init();
        AppMethodBeat.o(254046);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLivePlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(254047);
        init();
        AppMethodBeat.o(254047);
    }

    private void init() {
        AppMethodBeat.i(254021);
        Context context = getContext();
        p.g(context, "context");
        this.wcu = new d(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        d dVar = this.wcu;
        if (dVar == null) {
            p.btv("textureView");
        }
        addView(dVar, layoutParams);
        this.hwO = new TXLivePlayer(getContext());
        TXLivePlayConfig tXLivePlayConfig = new TXLivePlayConfig();
        tXLivePlayConfig.setAutoAdjustCacheTime(true);
        tXLivePlayConfig.setMinAutoAdjustCacheTime(1.0f);
        tXLivePlayConfig.setMaxAutoAdjustCacheTime(1.0f);
        TXLivePlayer tXLivePlayer = this.hwO;
        if (tXLivePlayer == null) {
            p.btv("txLivePlayer");
        }
        d dVar2 = this.wcu;
        if (dVar2 == null) {
            p.btv("textureView");
        }
        tXLivePlayer.setPlayerView(dVar2);
        TXLivePlayer tXLivePlayer2 = this.hwO;
        if (tXLivePlayer2 == null) {
            p.btv("txLivePlayer");
        }
        tXLivePlayer2.setPlayListener(this.wcz);
        TXLivePlayer tXLivePlayer3 = this.hwO;
        if (tXLivePlayer3 == null) {
            p.btv("txLivePlayer");
        }
        tXLivePlayer3.setConfig(tXLivePlayConfig);
        TXLivePlayer tXLivePlayer4 = this.hwO;
        if (tXLivePlayer4 == null) {
            p.btv("txLivePlayer");
        }
        tXLivePlayer4.setRenderMode(0);
        AppMethodBeat.o(254021);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderLivePlayView$playListener$1", "Lcom/tencent/rtmp/ITXLivePlayListener;", "onNetStatus", "", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder_release"})
    public static final class a implements ITXLivePlayListener {
        final /* synthetic */ FinderLivePlayView wcE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderLivePlayView finderLivePlayView) {
            this.wcE = finderLivePlayView;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.rtmp.ITXLivePlayListener
        public final void onPlayEvent(int i2, Bundle bundle) {
            int i3;
            int i4;
            boolean z = true;
            AppMethodBeat.i(254015);
            String str = this.wcE.TAG;
            StringBuilder append = new StringBuilder("onPlayEvent:").append(i2).append(", isPlaying:");
            TXLivePlayer txLivePlayer = this.wcE.getTxLivePlayer();
            Log.i(str, append.append(txLivePlayer != null && txLivePlayer.isPlaying()).toString());
            if (this.wcE.getTxLivePlayer().isPlaying()) {
                this.wcE.hCl = i2;
                switch (i2) {
                    case -2301:
                        if (NetStatusUtil.getNetType(this.wcE.getContext()) != -1) {
                            z = false;
                        }
                        FinderLivePlayView.a(this.wcE, "onPlayEvent PLAY_ERR_NET_DISCONNECT, non_network:".concat(String.valueOf(z)));
                        this.wcE.getTxLivePlayer().stopPlay(false);
                        AppMethodBeat.o(254015);
                        return;
                    case 2001:
                    case 2004:
                        FinderLivePlayView.a(this.wcE, "onPlayEvent " + (i2 == 2004 ? "EVT_VIDEO_PLAY_BEGIN" : "PLAY_EVT_CONNECT_SUCC"));
                        y lifecycle = this.wcE.getLifecycle();
                        if (lifecycle != null) {
                            s unused = this.wcE.wcy;
                            lifecycle.dFN();
                        }
                        y lifecycle2 = this.wcE.getLifecycle();
                        if (lifecycle2 != null) {
                            s unused2 = this.wcE.wcy;
                            lifecycle2.Gr(0);
                            AppMethodBeat.o(254015);
                            return;
                        }
                        AppMethodBeat.o(254015);
                        return;
                    case 2009:
                        if (this.wcE.wcx) {
                            if (bundle != null) {
                                i3 = bundle.getInt("EVT_PARAM1");
                            } else {
                                i3 = 0;
                            }
                            if (bundle != null) {
                                i4 = bundle.getInt("EVT_PARAM2");
                            } else {
                                i4 = 0;
                            }
                            FinderLivePlayView.a(this.wcE, "onPlayEvent PLAY_EVT_CHANGE_RESOLUTION, w:h=" + i3 + ':' + i4);
                            if (i4 <= i3) {
                                this.wcE.getTxLivePlayer().setRenderMode(1);
                                break;
                            } else {
                                this.wcE.getTxLivePlayer().setRenderMode(0);
                                AppMethodBeat.o(254015);
                                return;
                            }
                        } else {
                            AppMethodBeat.o(254015);
                            return;
                        }
                    case 2103:
                        if (NetStatusUtil.getNetType(this.wcE.getContext()) != -1) {
                            z = false;
                        }
                        FinderLivePlayView.a(this.wcE, "onPlayEvent PLAY_WARNING_RECONNECT, non_network:".concat(String.valueOf(z)));
                        AppMethodBeat.o(254015);
                        return;
                }
            }
            AppMethodBeat.o(254015);
        }

        @Override // com.tencent.rtmp.ITXLivePlayListener
        public final void onNetStatus(Bundle bundle) {
            s sVar;
            AppMethodBeat.i(254016);
            int netType = NetStatusUtil.getNetType(this.wcE.getContext());
            String str = this.wcE.TAG;
            StringBuilder append = new StringBuilder("onNetStatus curPlayStatus:").append(this.wcE.hCl).append(", netQuality:").append(netType).append(", isPlaying:");
            TXLivePlayer txLivePlayer = this.wcE.getTxLivePlayer();
            Log.i(str, append.append(txLivePlayer != null && txLivePlayer.isPlaying()).toString());
            if (!this.wcE.getTxLivePlayer().isPlaying() || netType == -1 || this.wcE.hCl != -2301 || (sVar = this.wcE.wcy) == null) {
                AppMethodBeat.o(254016);
                return;
            }
            if (!Util.isNullOrNil(sVar.downloadUrl) && sVar.downloadUrl != null) {
                this.wcE.getTxLivePlayer().stopPlay(false);
                FinderLivePlayView.b(this.wcE, sVar.downloadUrl);
            }
            AppMethodBeat.o(254016);
        }
    }

    public final ITXLivePlayListener getPlayListener() {
        return this.wcz;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int getCurrentPlaySecond() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final long getCurrentPlayMs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int getVideoDuration() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final long getVideoDurationMs() {
        return 0;
    }

    public final void setViewFocused(boolean z) {
        this.wcA = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getVideoViewFocused() {
        return this.wcA;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final FinderLivePlayView getVideoView() {
        return this;
    }

    public final void setShouldPlayResume(boolean z) {
        this.wcB = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getIsShouldPlayResume() {
        return this.wcB;
    }

    public final void setNeverStart(boolean z) {
        this.wcC = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getIsNeverStart() {
        return this.wcC;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final ViewParent getParentView() {
        AppMethodBeat.i(254023);
        ViewParent parent = getParent();
        AppMethodBeat.o(254023);
        return parent;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIsShouldPlayResume(boolean z) {
        AppMethodBeat.i(254024);
        print("setIsShouldPlayResume: ".concat(String.valueOf(z)));
        this.wcB = z;
        AppMethodBeat.o(254024);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoViewFocused(boolean z) {
        AppMethodBeat.i(254025);
        Log.i(this.TAG, "setVideoViewFocused ".concat(String.valueOf(z)));
        this.wcA = z;
        AppMethodBeat.o(254025);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setPreview(boolean z) {
        AppMethodBeat.i(254026);
        print("setPreview: ".concat(String.valueOf(z)));
        this.sZd = z;
        AppMethodBeat.o(254026);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dEO() {
        return this.sZd;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setInterceptDetach(boolean z) {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean play() {
        AppMethodBeat.i(254027);
        print(AssetExtension.SCENE_PLAY);
        TXLivePlayer tXLivePlayer = this.hwO;
        if (tXLivePlayer == null) {
            p.btv("txLivePlayer");
        }
        tXLivePlayer.resume();
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.dFN();
        }
        AppMethodBeat.o(254027);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dFj() {
        String str;
        AppMethodBeat.i(254028);
        StringBuilder sb = new StringBuilder("startOrPlay, ");
        s sVar = this.wcy;
        if (sVar != null) {
            str = sVar.downloadUrl;
        } else {
            str = null;
        }
        print(sb.append(str).toString());
        if (!this.wcA) {
            Log.i(this.TAG, "startOrPlay, return, isViewFocused:" + this.wcA);
            AppMethodBeat.o(254028);
            return false;
        } else if (isPlaying()) {
            Log.i(this.TAG, "startOrPlay, return, isPlaying!");
            AppMethodBeat.o(254028);
            return false;
        } else {
            s sVar2 = this.wcy;
            if (sVar2 == null || Util.isNullOrNil(sVar2.downloadUrl) || sVar2.downloadUrl == null) {
                AppMethodBeat.o(254028);
                return false;
            }
            start(sVar2.downloadUrl);
            this.wcC = false;
            AppMethodBeat.o(254028);
            return true;
        }
    }

    private final void start(String str) {
        FeedData feedData;
        AppMethodBeat.i(254029);
        print("start, ".concat(String.valueOf(str)));
        if (!this.dLD || !this.wcD) {
            TXLivePlayer tXLivePlayer = this.hwO;
            if (tXLivePlayer == null) {
                p.btv("txLivePlayer");
            }
            tXLivePlayer.startPlay(str, 1);
        } else {
            TXLivePlayer tXLivePlayer2 = this.hwO;
            if (tXLivePlayer2 == null) {
                p.btv("txLivePlayer");
            }
            tXLivePlayer2.resume();
        }
        k kVar = k.vkd;
        s.p pVar = s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD;
        s sVar = this.wcy;
        if (sVar != null) {
            feedData = sVar.wgm;
        } else {
            feedData = null;
        }
        k.a(pVar, feedData);
        AppMethodBeat.o(254029);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dEN() {
        AppMethodBeat.i(254030);
        print("prepareToPlay");
        AppMethodBeat.o(254030);
        return true;
    }

    public final void setSupportPauseResume(boolean z) {
        this.wcD = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean pause() {
        AppMethodBeat.i(254031);
        print("pause");
        TXLivePlayer tXLivePlayer = this.hwO;
        if (tXLivePlayer == null) {
            p.btv("txLivePlayer");
        }
        tXLivePlayer.pause();
        this.dLD = true;
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.dFL();
        }
        AppMethodBeat.o(254031);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setFinderVideoCore(k kVar) {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int dFk() {
        AppMethodBeat.i(254032);
        print("pauseWithCancel");
        TXLivePlayer tXLivePlayer = this.hwO;
        if (tXLivePlayer == null) {
            p.btv("txLivePlayer");
        }
        tXLivePlayer.pause();
        this.dLD = true;
        AppMethodBeat.o(254032);
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean c(double d2, boolean z) {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void stop() {
        AppMethodBeat.i(254033);
        print("stop");
        TXLivePlayer tXLivePlayer = this.hwO;
        if (tXLivePlayer == null) {
            p.btv("txLivePlayer");
        }
        tXLivePlayer.stopPlay(true);
        this.dLD = false;
        this.wcC = true;
        y yVar = this.wcw;
        if (yVar != null) {
            yVar.b(this.wcy);
            AppMethodBeat.o(254033);
            return;
        }
        AppMethodBeat.o(254033);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean isPlaying() {
        AppMethodBeat.i(254034);
        TXLivePlayer tXLivePlayer = this.hwO;
        if (tXLivePlayer == null) {
            p.btv("txLivePlayer");
        }
        boolean isPlaying = tXLivePlayer.isPlaying();
        AppMethodBeat.o(254034);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setMute(boolean z) {
        AppMethodBeat.i(254035);
        print("setMute ".concat(String.valueOf(z)));
        TXLivePlayer tXLivePlayer = this.hwO;
        if (tXLivePlayer == null) {
            p.btv("txLivePlayer");
        }
        tXLivePlayer.setMute(z);
        AppMethodBeat.o(254035);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void onUIDestroy() {
        AppMethodBeat.i(254036);
        print("onUIDestroy");
        stop();
        AppMethodBeat.o(254036);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void onRelease() {
        AppMethodBeat.i(254037);
        print("onRelease");
        this.dLD = false;
        AppMethodBeat.o(254037);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final String getVideoMediaId() {
        String str;
        s sVar = this.wcy;
        return (sVar == null || (str = sVar.mediaId) == null) ? "" : str;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final s getVideoMediaInfo() {
        return this.wcy;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void a(com.tencent.mm.plugin.finder.loader.s sVar, boolean z, FeedData feedData) {
        AppMethodBeat.i(254038);
        p.h(sVar, "video");
        p.h(feedData, "feedData");
        print("setVideoMediaInfo " + sVar.getUrl());
        this.wcy = new s(sVar.getUrl(), sVar.getPath(), sVar.auA(), sVar.uIw, sVar, feedData);
        AppMethodBeat.o(254038);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIMMVideoViewCallback(i.b bVar) {
        AppMethodBeat.i(254039);
        p.h(bVar, "_callback");
        print("setIMMVideoViewCallback _callback:" + bVar.hashCode());
        this.wcv = bVar;
        AppMethodBeat.o(254039);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setScaleType(i.e eVar) {
        int i2;
        AppMethodBeat.i(254040);
        p.h(eVar, "scaleType");
        TXLivePlayer tXLivePlayer = this.hwO;
        if (tXLivePlayer == null) {
            p.btv("txLivePlayer");
        }
        if (eVar == i.e.CONTAIN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        tXLivePlayer.setRenderMode(i2);
        AppMethodBeat.o(254040);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIOnlineVideoProxy(b bVar) {
        AppMethodBeat.i(254041);
        p.h(bVar, "_proxy");
        AppMethodBeat.o(254041);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void dFl() {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIsShowBasicControls(boolean z) {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setLoop(boolean z) {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoPlayLifecycle(y yVar) {
        AppMethodBeat.i(254042);
        p.h(yVar, "lifecycle");
        print("setVideoPlayLifecycle _callback:" + yVar.hashCode());
        this.wcw = yVar;
        AppMethodBeat.o(254042);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoMuteListener(t tVar) {
        AppMethodBeat.i(254043);
        p.h(tVar, "muteListener");
        AppMethodBeat.o(254043);
    }

    private final void print(String str) {
        AppMethodBeat.i(254044);
        Log.i(this.TAG, hashCode() + " === " + str);
        AppMethodBeat.o(254044);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final Bitmap getBitmap() {
        return null;
    }
}
