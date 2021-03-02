package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.plugin.appbrand.jsapi.z.p;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.tav.core.AssetExtension;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0001H&J\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\tH&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u000eH&J\b\u0010\u001d\u001a\u00020\u000bH&J\b\u0010\u001e\u001a\u00020\u000eH&J\b\u0010\u001f\u001a\u00020\u000eH&J\b\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020!H&J\b\u0010#\u001a\u00020\u000eH&J\b\u0010$\u001a\u00020\u000bH&J\b\u0010%\u001a\u00020\u000eH&J\b\u0010&\u001a\u00020\u000eH&J\b\u0010'\u001a\u00020!H&J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000eH&J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0005H&J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u000100H&J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u000203H&J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H&J\u0010\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u000eH&J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\u000eH&J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\u000eH&J\u0010\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\u000eH&J\u0010\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\u000eH&J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\u000eH&J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u000eH&J\u0010\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020GH&J\u0010\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\u0001H&J\u0018\u0010H\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u0001H&J \u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020OH&J\u0010\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u00020RH&J\u0010\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020UH&J\u0010\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020\u000eH&J\b\u0010X\u001a\u00020\u000eH&J\b\u0010Y\u001a\u00020!H&¨\u0006Z"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "", "animate", "Landroid/view/ViewPropertyAnimator;", "getAlpha", "", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlayMs", "", "getCurrentPlaySecond", "", "getHeight", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getTag", "id", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "getWidth", "isPlaying", "isPreviewing", "onRelease", "", "onUIDestroy", "pause", "pauseWithCancel", AssetExtension.SCENE_PLAY, "prepareToPlay", "removeVideoFooterView", "seekTo", AppMeasurement.Param.TIMESTAMP, "", "afterSeekPlay", "setAlpha", "alpha", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", p.NAME, "keepScreenOn", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setTag", "tag", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "startOrPlay", "stop", "plugin-finder_release"})
public interface r {
    void a(s sVar, boolean z, FeedData feedData);

    ViewPropertyAnimator animate();

    boolean c(double d2, boolean z);

    boolean dEN();

    boolean dEO();

    boolean dFj();

    int dFk();

    void dFl();

    float getAlpha();

    Bitmap getBitmap();

    long getCurrentPlayMs();

    int getCurrentPlaySecond();

    int getHeight();

    boolean getIsNeverStart();

    boolean getIsShouldPlayResume();

    ViewParent getParentView();

    Object getTag(int i2);

    int getVideoDuration();

    long getVideoDurationMs();

    String getVideoMediaId();

    s getVideoMediaInfo();

    View getVideoView();

    boolean getVideoViewFocused();

    int getWidth();

    boolean isPlaying();

    void onRelease();

    void onUIDestroy();

    boolean pause();

    boolean play();

    void setAlpha(float f2);

    void setFinderVideoCore(k kVar);

    void setIMMVideoViewCallback(i.b bVar);

    void setIOnlineVideoProxy(b bVar);

    void setInterceptDetach(boolean z);

    void setIsShouldPlayResume(boolean z);

    void setIsShowBasicControls(boolean z);

    void setKeepScreenOn(boolean z);

    void setLoop(boolean z);

    void setMute(boolean z);

    void setPreview(boolean z);

    void setScaleType(i.e eVar);

    void setTag(int i2, Object obj);

    void setTag(Object obj);

    void setVideoMuteListener(t tVar);

    void setVideoPlayLifecycle(y yVar);

    void setVideoViewFocused(boolean z);

    void stop();
}
