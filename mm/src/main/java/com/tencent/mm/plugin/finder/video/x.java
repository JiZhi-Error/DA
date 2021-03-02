package com.tencent.mm.plugin.finder.video;

import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H&J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J$\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "", "checkVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "onFinishDownload", "ret", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReadyDownload", "total", "moovFirstDownloaded", "", "onProgressDownload", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "plugin-finder_release"})
public interface x {
    void a(int i2, int i3, s sVar);

    void a(int i2, int i3, s sVar, boolean z);

    void a(int i2, s sVar, d dVar);

    void a(s sVar, h hVar, d dVar);

    void ac(String str, int i2, int i3);

    void b(s sVar);
}
