package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;

public final class e {
    final Map<String, OnlineVideoView> DzX = new ArrayMap();
    String DzY;

    public e() {
        AppMethodBeat.i(202327);
        AppMethodBeat.o(202327);
    }

    public final void a(OnlineVideoView onlineVideoView, c cVar, String str, String str2) {
        OnlineVideoView value;
        AppMethodBeat.i(202328);
        if (onlineVideoView == null || cVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(202328);
            return;
        }
        try {
            onlineVideoView.setVisibility(0);
            Map<String, OnlineVideoView> map = this.DzX;
            if (map != null) {
                for (Map.Entry<String, OnlineVideoView> entry : map.entrySet()) {
                    if (!(entry == null || entry.getValue() == null || (value = entry.getValue()) == onlineVideoView)) {
                        value.cXa();
                    }
                }
            }
            Map<String, OnlineVideoView> map2 = this.DzX;
            if (map2 != null) {
                Iterator<Map.Entry<String, OnlineVideoView>> it = map2.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, OnlineVideoView> next = it.next();
                    if (next != null && b(next.getValue())) {
                        it.remove();
                    }
                }
            }
            onlineVideoView.a(cVar.ebR, cVar.dHp, cVar.iXu);
            onlineVideoView.fgg();
            onlineVideoView.setMute(true);
            onlineVideoView.onResume();
            Map<String, OnlineVideoView> map3 = this.DzX;
            if (map3 != null) {
                map3.put(str2, onlineVideoView);
            }
            Log.d("VideoViewManager", "the view map size is " + map3.size());
            this.DzY = str2;
            AppMethodBeat.o(202328);
        } catch (Throwable th) {
            Log.e("VideoViewManager", "startPlay has something wrong!");
            AppMethodBeat.o(202328);
        }
    }

    public final void a(OnlineVideoView onlineVideoView, String str) {
        AppMethodBeat.i(202329);
        if (!(onlineVideoView == null || str == null)) {
            try {
                if (str.equals(this.DzY)) {
                    if (a(onlineVideoView)) {
                        if (onlineVideoView.getDuration() - onlineVideoView.getCurrentPosition() < 500) {
                            Log.i("VideoViewManager", "the current position is too near to end of the video!!");
                            onlineVideoView.aT(0, true);
                            AppMethodBeat.o(202329);
                            return;
                        }
                        onlineVideoView.eYd();
                        AppMethodBeat.o(202329);
                        return;
                    }
                    AppMethodBeat.o(202329);
                }
            } catch (Throwable th) {
                Log.e("VideoViewManager", "resumePlay has something wrong!");
                AppMethodBeat.o(202329);
                return;
            }
        }
        Log.i("VideoViewManager", "the media is is not same as the current one!!!");
        AppMethodBeat.o(202329);
    }

    public final void b(OnlineVideoView onlineVideoView, String str) {
        AppMethodBeat.i(202330);
        try {
            Map<String, OnlineVideoView> map = this.DzX;
            if (map == null || str == null || map.get(str) != onlineVideoView || onlineVideoView == null || b(onlineVideoView)) {
                onlineVideoView = null;
            }
            if (onlineVideoView != null) {
                onlineVideoView.aT(0, true);
                onlineVideoView.setTag(R.id.huv, 1);
                AppMethodBeat.o(202330);
                return;
            }
            Log.i("VideoViewManager", "the media is is not same as the current one, or the view is destroyed!!!");
            AppMethodBeat.o(202330);
        } catch (Throwable th) {
            Log.w("VideoViewManager", "seekPlay has something wrong!");
            AppMethodBeat.o(202330);
        }
    }

    public final void cXa() {
        OnlineVideoView onlineVideoView;
        AppMethodBeat.i(202331);
        Map<String, OnlineVideoView> map = this.DzX;
        String str = this.DzY;
        try {
            if (!(TextUtils.isEmpty(str) || map == null || (onlineVideoView = map.get(str)) == null)) {
                onlineVideoView.cXa();
            }
            AppMethodBeat.o(202331);
        } catch (Throwable th) {
            Log.e("VideoViewManager", "pausePlay has something wrong!");
            AppMethodBeat.o(202331);
        }
    }

    public final OnlineVideoView bx(Context context, String str) {
        boolean z;
        AppMethodBeat.i(202332);
        Map<String, OnlineVideoView> map = this.DzX;
        if (map == null) {
            Log.w("VideoViewManager", "are you sure? the map is null? I don't think the statement can reach!!");
            AppMethodBeat.o(202332);
            return null;
        }
        try {
            OnlineVideoView onlineVideoView = map.get(str);
            if (onlineVideoView == null || b(onlineVideoView)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.d("VideoViewManager", "to new one video view!");
                onlineVideoView = new SnsTimelineVideoView(context);
                onlineVideoView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(202332);
            return onlineVideoView;
        } catch (Throwable th) {
            Log.e("VideoViewManager", "getVideoViewWithMediaId has something wrong!");
            AppMethodBeat.o(202332);
            return null;
        }
    }

    private static boolean a(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(202333);
        if (onlineVideoView instanceof SnsTimelineVideoView) {
            boolean YY = ((SnsTimelineVideoView) onlineVideoView).YY();
            AppMethodBeat.o(202333);
            return YY;
        }
        AppMethodBeat.o(202333);
        return false;
    }

    private static boolean b(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(202334);
        if (onlineVideoView instanceof SnsTimelineVideoView) {
            SnsTimelineVideoView snsTimelineVideoView = (SnsTimelineVideoView) onlineVideoView;
            if (snsTimelineVideoView.Fdd || snsTimelineVideoView.Fdb || snsTimelineVideoView.EtU) {
                Log.i("VideoViewManager", "the video view is destroyed");
                AppMethodBeat.o(202334);
                return true;
            }
            AppMethodBeat.o(202334);
            return false;
        }
        Log.w("VideoViewManager", "the video view is not SnsTimelineVideoView");
        AppMethodBeat.o(202334);
        return true;
    }

    public final void stopAll() {
        AppMethodBeat.i(202335);
        try {
            Map<String, OnlineVideoView> map = this.DzX;
            if (map == null) {
                AppMethodBeat.o(202335);
                return;
            }
            for (Map.Entry<String, OnlineVideoView> entry : map.entrySet()) {
                if (!(entry == null || entry.getValue() == null)) {
                    OnlineVideoView value = entry.getValue();
                    if (value instanceof SnsTimelineVideoView) {
                        ((SnsTimelineVideoView) value).fkP();
                    }
                }
            }
            AppMethodBeat.o(202335);
        } catch (Throwable th) {
            Log.e("VideoViewManager", "stopAll has something wrong!");
            AppMethodBeat.o(202335);
        }
    }
}
