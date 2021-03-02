package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;

public final class f {
    public static boolean eXW() {
        AppMethodBeat.i(202227);
        try {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_ad_normal_video_new_player, 0);
            Log.i("NormalVideoAdHelper", "the sns ad new player is ".concat(String.valueOf(a2)));
            if (a2 > 0) {
                AppMethodBeat.o(202227);
                return true;
            }
            AppMethodBeat.o(202227);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.o(202227);
            return false;
        }
    }

    public static void a(SnsAdTimelineVideoView snsAdTimelineVideoView) {
        AppMethodBeat.i(202228);
        if (snsAdTimelineVideoView != null) {
            snsAdTimelineVideoView.setThumpViewScaleType(ImageView.ScaleType.CENTER_CROP);
            snsAdTimelineVideoView.setMute(true);
        }
        AppMethodBeat.o(202228);
    }

    public static void a(SnsAdTimelineVideoView snsAdTimelineVideoView, int i2, int i3) {
        AppMethodBeat.i(202229);
        if (snsAdTimelineVideoView != null) {
            ViewGroup.LayoutParams layoutParams = snsAdTimelineVideoView.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
        AppMethodBeat.o(202229);
    }

    public static void a(SnsAdTimelineVideoView snsAdTimelineVideoView, boolean z) {
        AppMethodBeat.i(202230);
        Log.d("NormalVideoAdHelper", "setPlayerVisibility is called, the  isNewPlayerVisible is ".concat(String.valueOf(z)));
        if (snsAdTimelineVideoView != null) {
            snsAdTimelineVideoView.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.o(202230);
    }

    public static void b(SnsAdTimelineVideoView snsAdTimelineVideoView) {
        AppMethodBeat.i(202231);
        Log.d("NormalVideoAdHelper", "play is called");
        if (snsAdTimelineVideoView != null) {
            snsAdTimelineVideoView.setShouldPlayWhenPrepared(true);
            long durationMs = (long) snsAdTimelineVideoView.getDurationMs();
            long currentPositionMs = (long) snsAdTimelineVideoView.getCurrentPositionMs();
            Log.d("NormalVideoAdHelper", "the duration is " + durationMs + ", the current is " + currentPositionMs);
            if (currentPositionMs < durationMs || currentPositionMs <= 0) {
                snsAdTimelineVideoView.start();
            } else {
                Log.e("NormalVideoAdHelper", "the current is more than duration, do restart!");
                if (snsAdTimelineVideoView.vbV) {
                    snsAdTimelineVideoView.restart();
                    AppMethodBeat.o(202231);
                    return;
                }
            }
        }
        AppMethodBeat.o(202231);
    }

    public static void c(SnsAdTimelineVideoView snsAdTimelineVideoView) {
        AppMethodBeat.i(202232);
        Log.d("NormalVideoAdHelper", "pause is called");
        if (snsAdTimelineVideoView != null) {
            snsAdTimelineVideoView.pause();
            snsAdTimelineVideoView.setShouldPlayWhenPrepared(false);
        }
        AppMethodBeat.o(202232);
    }

    public static void a(SnsAdTimelineVideoView snsAdTimelineVideoView, com.tencent.mm.plugin.sns.model.g gVar, Activity activity, int i2) {
        AppMethodBeat.i(202233);
        Log.d("NormalVideoAdHelper", "cleanPlayerSnsSight is called, the position is ".concat(String.valueOf(i2)));
        if (!(snsAdTimelineVideoView == null || gVar == null || activity == null)) {
            gVar.a(snsAdTimelineVideoView, activity.hashCode());
        }
        AppMethodBeat.o(202233);
    }

    public static void a(SnsAdTimelineVideoView snsAdTimelineVideoView, com.tencent.mm.plugin.sns.model.g gVar, SnsInfo snsInfo, Activity activity, cnb cnb, int i2, bp bpVar) {
        AppMethodBeat.i(202234);
        Log.d("NormalVideoAdHelper", "setPlayerSnsSight is called, the position is ".concat(String.valueOf(i2)));
        if (!(snsAdTimelineVideoView == null || gVar == null || snsInfo == null || activity == null || cnb == null)) {
            gVar.a(snsInfo, cnb, snsAdTimelineVideoView, activity.hashCode(), bpVar, snsInfo.isAd());
        }
        AppMethodBeat.o(202234);
    }
}
