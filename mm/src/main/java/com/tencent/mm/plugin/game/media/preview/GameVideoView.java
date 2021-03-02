package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Set;

public class GameVideoView extends RelativeLayout implements i {
    private static Set<String> xDB = new HashSet();
    private boolean gPs;
    private Context mContext;
    private boolean mMute = false;
    private String mUrl;
    private d pNk;
    private a xDA;
    a xDC;
    i.a xDD = new i.a() {
        /* class com.tencent.mm.plugin.game.media.preview.GameVideoView.AnonymousClass2 */

        @Override // com.tencent.mm.pluginsdk.ui.i.a
        public final void aO(String str, boolean z) {
            AppMethodBeat.i(41282);
            Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", str, Boolean.valueOf(z));
            if (str != null && str.endsWith(".temp")) {
                String replace = str.replace(".temp", "");
                s.nw(str, replace);
                GameVideoView.this.xDx = true;
                GameVideoView.this.mUrl = replace;
                GameVideoView.xDB.add(str);
                Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", str, replace);
            }
            AppMethodBeat.o(41282);
        }
    };
    i.c xDE = new i.c() {
        /* class com.tencent.mm.plugin.game.media.preview.GameVideoView.AnonymousClass3 */

        @Override // com.tencent.mm.pluginsdk.ui.i.c
        public final void yU(long j2) {
            AppMethodBeat.i(41283);
            h.INSTANCE.idkeyStat(600, j2, 1, false);
            AppMethodBeat.o(41283);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.c
        public final void DX(String str) {
            AppMethodBeat.i(41284);
            h.INSTANCE.kvStat(14349, str);
            AppMethodBeat.o(41284);
        }
    };
    d.a xDF = new d.a() {
        /* class com.tencent.mm.plugin.game.media.preview.GameVideoView.AnonymousClass4 */

        @Override // com.tencent.mm.model.d.a
        public final void aTw() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTx() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTy() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTz() {
        }
    };
    i.b xDG = new i.b() {
        /* class com.tencent.mm.plugin.game.media.preview.GameVideoView.AnonymousClass5 */

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void c(String str, String str2, String str3, int i2, int i3) {
            AppMethodBeat.i(41285);
            Log.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(41285);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dH(String str, String str2) {
            AppMethodBeat.i(41286);
            Log.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", Integer.valueOf(hashCode()));
            if (GameVideoView.this.xDA != null) {
                GameVideoView.this.xDA.tf();
            }
            AppMethodBeat.o(41286);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dI(String str, String str2) {
            AppMethodBeat.i(41287);
            Log.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", Integer.valueOf(hashCode()));
            GameVideoView.this.c(0.0d, true);
            AppMethodBeat.o(41287);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void d(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(41288);
            Log.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(41288);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dJ(String str, String str2) {
            AppMethodBeat.i(41289);
            Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", Integer.valueOf(hashCode()));
            GameVideoView.this.setKeepScreenOn(false);
            GameVideoView.this.pNk.fp(false);
            AppMethodBeat.o(41289);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dK(String str, String str2) {
            AppMethodBeat.i(41290);
            Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", Integer.valueOf(hashCode()));
            GameVideoView.this.setKeepScreenOn(true);
            GameVideoView.this.pNk.a(GameVideoView.this.xDF);
            AppMethodBeat.o(41290);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dL(String str, String str2) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dM(String str, String str2) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void fo(String str, String str2) {
        }
    };
    private i xDt;
    private i.e xDu = i.e.CONTAIN;
    private float xDv = -1.0f;
    private int xDw;
    private boolean xDx;
    private int xDy = 0;
    private com.tencent.mm.pluginsdk.ui.h xDz;

    /* access modifiers changed from: package-private */
    public interface a {
        void tf();
    }

    static {
        AppMethodBeat.i(41327);
        AppMethodBeat.o(41327);
    }

    public GameVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41291);
        initView();
        AppMethodBeat.o(41291);
    }

    public GameVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(41292);
        initView();
        AppMethodBeat.o(41292);
    }

    private void initView() {
        AppMethodBeat.i(41293);
        this.mContext = getContext();
        this.pNk = new d();
        AppMethodBeat.o(41293);
    }

    public void setVideoPreparedListener(a aVar) {
        this.xDA = aVar;
    }

    public String getFilePath() {
        AppMethodBeat.i(41294);
        if (this.xDt instanceof GameMMVideoView) {
            String filePath = ((GameMMVideoView) this.xDt).getFilePath();
            AppMethodBeat.o(41294);
            return filePath;
        }
        String str = this.mUrl;
        AppMethodBeat.o(41294);
        return str;
    }

    public String getMediaId() {
        AppMethodBeat.i(41295);
        if (this.xDt instanceof GameMMVideoView) {
            String mediaId = ((GameMMVideoView) this.xDt).getMediaId();
            AppMethodBeat.o(41295);
            return mediaId;
        }
        AppMethodBeat.o(41295);
        return null;
    }

    public String getLocalPath() {
        AppMethodBeat.i(41296);
        if (this.xDx) {
            String str = this.mUrl;
            AppMethodBeat.o(41296);
            return str;
        }
        String aAg = aAg(this.mUrl);
        AppMethodBeat.o(41296);
        return aAg;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0036  */
    @Override // com.tencent.mm.pluginsdk.ui.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(boolean r7, java.lang.String r8, int r9) {
        /*
        // Method dump skipped, instructions count: 352
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.media.preview.GameVideoView.c(boolean, java.lang.String, int):void");
    }

    private i dUF() {
        AppMethodBeat.i(41298);
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.goG();
        commonVideoView.setReporter(this.xDE);
        commonVideoView.setIMMVideoViewCallback(this.xDG);
        AppMethodBeat.o(41298);
        return commonVideoView;
    }

    private i dUG() {
        AppMethodBeat.i(41299);
        GameMMVideoView gameMMVideoView = new GameMMVideoView(this.mContext);
        gameMMVideoView.setReporter(this.xDE);
        gameMMVideoView.setIMMVideoViewCallback(this.xDG);
        gameMMVideoView.setIMMDownloadFinish(this.xDD);
        String rootPath = getRootPath();
        FilePathGenerator.checkMkdir(rootPath);
        gameMMVideoView.setRootPath(rootPath);
        gameMMVideoView.setLoop(true);
        this.xDC = new a(gameMMVideoView);
        gameMMVideoView.setIOnlineVideoProxy(this.xDC);
        AppMethodBeat.o(41299);
        return gameMMVideoView;
    }

    private static String aAf(String str) {
        AppMethodBeat.i(41300);
        String str2 = getRootPath() + "MMVideo_" + str.hashCode() + ".mp4.temp";
        AppMethodBeat.o(41300);
        return str2;
    }

    private static String aAg(String str) {
        AppMethodBeat.i(41301);
        String str2 = getRootPath() + "MMVideo_" + str.hashCode() + ".mp4";
        AppMethodBeat.o(41301);
        return str2;
    }

    public static String getRootPath() {
        AppMethodBeat.i(41302);
        String str = b.c(b.a.ONE_WEEK) + "haowan/";
        AppMethodBeat.o(41302);
        return str;
    }

    public static void dUH() {
        AppMethodBeat.i(41303);
        for (String str : xDB) {
            Log.i("MicroMsg.Haowan.GameVideoView", "delete temp cache ret:%b, cachePath:%s", Boolean.valueOf(s.deleteFile(str)), str);
        }
        xDB.clear();
        AppMethodBeat.o(41303);
    }

    private boolean dUI() {
        if (this.gPs || this.xDx) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getPlayerType() {
        AppMethodBeat.i(41304);
        if (this.xDt != null) {
            int playerType = this.xDt.getPlayerType();
            AppMethodBeat.o(41304);
            return playerType;
        }
        AppMethodBeat.o(41304);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean p(double d2) {
        AppMethodBeat.i(41305);
        if (this.xDt != null) {
            boolean p = this.xDt.p(d2);
            AppMethodBeat.o(41305);
            return p;
        }
        AppMethodBeat.o(41305);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(41306);
        if (this.xDt != null) {
            boolean c2 = this.xDt.c(d2, z);
            AppMethodBeat.o(41306);
            return c2;
        }
        AppMethodBeat.o(41306);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(41307);
        if (this.xDt != null) {
            this.xDt.setIsShowBasicControls(z);
        }
        AppMethodBeat.o(41307);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setFullDirection(int i2) {
        AppMethodBeat.i(41308);
        if (this.xDt != null) {
            this.xDt.setFullDirection(i2);
        }
        AppMethodBeat.o(41308);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getVideoDurationSec() {
        AppMethodBeat.i(41309);
        if (this.xDt != null) {
            int videoDurationSec = this.xDt.getVideoDurationSec();
            AppMethodBeat.o(41309);
            return videoDurationSec;
        }
        int i2 = this.xDw;
        AppMethodBeat.o(41309);
        return i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosMs() {
        AppMethodBeat.i(41310);
        if (this.xDt != null) {
            int currPosMs = this.xDt.getCurrPosMs();
            AppMethodBeat.o(41310);
            return currPosMs;
        }
        AppMethodBeat.o(41310);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosSec() {
        AppMethodBeat.i(41311);
        if (this.xDt != null) {
            int currPosSec = this.xDt.getCurrPosSec();
            AppMethodBeat.o(41311);
            return currPosSec;
        }
        AppMethodBeat.o(41311);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCacheTimeSec() {
        AppMethodBeat.i(41312);
        if (this.xDt != null) {
            int cacheTimeSec = this.xDt.getCacheTimeSec();
            AppMethodBeat.o(41312);
            return cacheTimeSec;
        }
        AppMethodBeat.o(41312);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean isPlaying() {
        AppMethodBeat.i(41313);
        if (this.xDt != null) {
            boolean isPlaying = this.xDt.isPlaying();
            AppMethodBeat.o(41313);
            return isPlaying;
        }
        AppMethodBeat.o(41313);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean isLive() {
        AppMethodBeat.i(41314);
        if (this.xDt != null) {
            boolean isLive = this.xDt.isLive();
            AppMethodBeat.o(41314);
            return isLive;
        }
        AppMethodBeat.o(41314);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setCover(Bitmap bitmap) {
        AppMethodBeat.i(41315);
        if (this.xDt != null) {
            this.xDt.setCover(bitmap);
        }
        AppMethodBeat.o(41315);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h hVar) {
        AppMethodBeat.i(41316);
        this.xDz = hVar;
        if (this.xDt != null) {
            this.xDt.setVideoFooterView(hVar);
        }
        AppMethodBeat.o(41316);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void dFl() {
        AppMethodBeat.i(41317);
        if (this.xDt != null) {
            this.xDt.dFl();
        }
        AppMethodBeat.o(41317);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void start() {
        AppMethodBeat.i(41318);
        if (this.xDt != null) {
            this.xDt.start();
            setKeepScreenOn(true);
            this.pNk.a(this.xDF);
        }
        AppMethodBeat.o(41318);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void stop() {
        AppMethodBeat.i(41319);
        if (this.xDt != null) {
            this.xDt.stop();
            this.pNk.fp(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.o(41319);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean pause() {
        AppMethodBeat.i(41320);
        if (this.xDt != null) {
            setKeepScreenOn(false);
            this.pNk.fp(false);
            boolean pause = this.xDt.pause();
            AppMethodBeat.o(41320);
            return pause;
        }
        AppMethodBeat.o(41320);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setMute(boolean z) {
        AppMethodBeat.i(41321);
        this.mMute = z;
        if (this.xDt != null) {
            this.xDt.setMute(z);
        }
        AppMethodBeat.o(41321);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIPause() {
        AppMethodBeat.i(41323);
        if (this.xDt != null) {
            this.xDy = this.xDt.getCurrPosSec();
            this.xDt.onUIPause();
        }
        this.pNk.fp(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(41323);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIDestroy() {
        AppMethodBeat.i(41324);
        if (this.xDt != null) {
            this.xDt.onUIDestroy();
        }
        this.pNk.fp(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(41324);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setScaleType(i.e eVar) {
        AppMethodBeat.i(41325);
        this.xDu = eVar;
        if (this.xDt != null) {
            this.xDt.setScaleType(eVar);
        }
        AppMethodBeat.o(41325);
    }

    public void setIMMVideoViewCallback(i.b bVar) {
        if (bVar != null) {
            this.xDG = bVar;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean aO(float f2) {
        AppMethodBeat.i(41326);
        if (f2 <= 0.0f) {
            AppMethodBeat.o(41326);
            return false;
        }
        this.xDv = f2;
        if (this.xDt != null) {
            boolean aO = this.xDt.aO(f2);
            AppMethodBeat.o(41326);
            return aO;
        }
        AppMethodBeat.o(41326);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoop(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoopCompletionCallback(i.d dVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIResume() {
        boolean z;
        String aAg;
        AppMethodBeat.i(41322);
        if (this.xDt instanceof GameMMVideoView) {
            if (s.YS(this.mUrl)) {
                aAg = this.mUrl;
            } else if (s.YS(aAg(this.mUrl))) {
                aAg = aAg(this.mUrl);
            } else {
                z = false;
            }
            this.xDt.stop();
            c(this.gPs, aAg, this.xDw);
            this.xDt.c((double) this.xDy, true);
            Log.i("MicroMsg.Haowan.GameVideoView", "change to local video. currPosSec:%d", Integer.valueOf(this.xDy));
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.preview.GameVideoView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(41281);
                    if (GameVideoView.this.xDt instanceof CommonVideoView) {
                        ((CommonVideoView) GameVideoView.this.xDt).hideLoading();
                    }
                    AppMethodBeat.o(41281);
                }
            }, 1000);
            z = true;
        } else {
            z = false;
        }
        if (!z && this.xDt != null) {
            this.xDt.onUIResume();
        }
        AppMethodBeat.o(41322);
    }
}
