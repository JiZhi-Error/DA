package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class SnsTimelineVideoView extends OnlineVideoView {
    a FcX = a.AVAILABLE;
    public c FcY;
    public String FcZ;
    private View Fda;
    public volatile boolean Fdb = false;
    public boolean Fdc = false;
    public volatile boolean Fdd = false;
    private b Fde = null;
    long vgi = 0;

    public interface b {
        void Zl(String str);
    }

    public SnsTimelineVideoView(Context context) {
        super(context);
        AppMethodBeat.i(100388);
        init();
        AppMethodBeat.o(100388);
    }

    public SnsTimelineVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(100389);
        init();
        AppMethodBeat.o(100389);
    }

    public SnsTimelineVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(100390);
        init();
        AppMethodBeat.o(100390);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        AVAILABLE,
        ATTACHING,
        PLAYING;

        public static a valueOf(String str) {
            AppMethodBeat.i(100386);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(100386);
            return aVar;
        }

        static {
            AppMethodBeat.i(100387);
            AppMethodBeat.o(100387);
        }
    }

    private void init() {
        AppMethodBeat.i(100391);
        this.Fda = findViewById(R.id.j7_);
        AppMethodBeat.o(100391);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(100392);
        super.onDetachedFromWindow();
        Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s onDetachedFromWindow, setState AVAILABLE, %s", Integer.valueOf(hashCode()), Boolean.valueOf(this.Fdc));
        this.FcX = a.AVAILABLE;
        if (!this.Fdc) {
            fkP();
            AppMethodBeat.o(100392);
            return;
        }
        this.Fdc = false;
        AppMethodBeat.o(100392);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OnlineVideoView
    public final void onResume() {
        AppMethodBeat.i(100393);
        eYc();
        super.onResume();
        AppMethodBeat.o(100393);
    }

    public final void vi(boolean z) {
        AppMethodBeat.i(100394);
        super.cXa();
        Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlay, setState ATTACHING", Integer.valueOf(hashCode()));
        this.FcX = a.ATTACHING;
        if (z && this.Fda != null) {
            this.Fda.setAlpha(1.0f);
            Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn visible", Integer.valueOf(hashCode()));
        }
        fgc();
        AppMethodBeat.o(100394);
    }

    public final void fkN() {
        AppMethodBeat.i(100395);
        if (this.EtL != null) {
            this.EtL.fgE();
        }
        AppMethodBeat.o(100395);
    }

    public final void fkO() {
        AppMethodBeat.i(100396);
        vi(false);
        Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlayWithoutChangePlayBtn, setState ATTACHING", Integer.valueOf(hashCode()));
        AppMethodBeat.o(100396);
    }

    public final boolean YY() {
        AppMethodBeat.i(100397);
        if (this.qbJ instanceof VideoPlayerTextureView) {
            boolean YY = ((VideoPlayerTextureView) this.qbJ).YY();
            AppMethodBeat.o(100397);
            return YY;
        }
        Log.e("MicroMsg.Sns.SnsOnlineVideoView", "videoview not VideoPlayerTextureView");
        AppMethodBeat.o(100397);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.OnlineVideoView
    public final void eYd() {
        AppMethodBeat.i(100398);
        super.eYd();
        Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s resumePlay, setState PLAYING", Integer.valueOf(hashCode()));
        this.FcX = a.PLAYING;
        this.vgi = System.currentTimeMillis();
        eYc();
        fO(true);
        AppMethodBeat.o(100398);
    }

    private void eYc() {
        AppMethodBeat.i(100399);
        if (this.Fda != null) {
            this.Fda.setAlpha(0.0f);
            Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn gone", Integer.valueOf(hashCode()));
        }
        AppMethodBeat.o(100399);
    }

    public final void fkP() {
        AppMethodBeat.i(100400);
        Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyAsync", Integer.valueOf(hashCode()));
        aRt(this.FcZ);
        this.FcZ = "";
        this.Fdb = true;
        if (this.EtL != null) {
            this.EtL.fgw();
            this.EtL.clear();
            this.EtL = null;
        }
        fgc();
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(100383);
                SnsTimelineVideoView.this.onDestroy();
                AppMethodBeat.o(100383);
            }
        });
        AppMethodBeat.o(100400);
    }

    private void aRt(final String str) {
        AppMethodBeat.i(100401);
        if (this.Fde != null && !Util.isNullOrNil(str)) {
            post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(100384);
                    try {
                        SnsTimelineVideoView.this.Fde.Zl(str);
                        SnsTimelineVideoView.this.Fde = null;
                        AppMethodBeat.o(100384);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", e2, "doUICallback", new Object[0]);
                        AppMethodBeat.o(100384);
                    }
                }
            });
        }
        AppMethodBeat.o(100401);
    }

    public final void fkQ() {
        AppMethodBeat.i(100402);
        try {
            if (this.Fde != null) {
                this.Fde.Zl(this.FcZ);
                this.Fde = null;
            }
            AppMethodBeat.o(100402);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", e2, "doUICallback", new Object[0]);
            AppMethodBeat.o(100402);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.OnlineVideoView
    public final void onDestroy() {
        AppMethodBeat.i(100403);
        aRt(this.FcZ);
        this.FcZ = "";
        super.onDestroy();
        this.Fdb = false;
        this.Fdd = true;
        Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d on destroy succ", Integer.valueOf(hashCode()));
        AppMethodBeat.o(100403);
    }

    public final void fkR() {
        AppMethodBeat.i(100404);
        this.FcZ = "";
        super.onDestroy();
        this.Fdb = false;
        Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyWithoutCallback succ", Integer.valueOf(hashCode()));
        AppMethodBeat.o(100404);
    }

    public void setUICallback(b bVar) {
        AppMethodBeat.i(100405);
        Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s videoview setUICallback", Integer.valueOf(hashCode()));
        this.Fde = bVar;
        AppMethodBeat.o(100405);
    }
}
