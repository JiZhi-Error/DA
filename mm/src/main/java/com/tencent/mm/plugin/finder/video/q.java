package com.tencent.mm.plugin.finder.video;

import android.view.MotionEvent;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000bH&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH&J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH&¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "", "dismissProgressBar", "", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "", "isSeekingMode", "", "isShownSeekBar", "setProgress", "progress", "setSeekBarCallback", "callback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "setVisibility", "visibility", "showProgressBar", "isShowThumb", "updateProgressMs", "percent", "", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "SeekBarCallback", "plugin-finder_release"})
public interface q {

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\nH&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "", "getCurrentPosMs", "", "getCurrentPosSec", "", "getVideoDurationSec", "isEnableSeek", "", "onEnterSeekMode", "", "isEnter", "showPauseTips", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onStartSeek", "onStopSeek", "percent", "", "plugin-finder_release"})
    public interface a {
        void Q(boolean z, boolean z2);

        boolean W(MotionEvent motionEvent);

        void bn(float f2);

        void dFH();

        boolean dFI();

        int getCurrentPosSec();

        int getVideoDurationSec();
    }

    void awG(String str);

    void bm(float f2);

    void dEX();

    boolean dEY();

    boolean dEZ();

    void dFa();

    int getCurrentProgress();

    void gs(int i2, int i3);

    void oI(boolean z);

    void setProgress(int i2);

    void setSeekBarCallback(a aVar);

    void setVisibility(int i2);
}
