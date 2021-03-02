package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SimpleObjectPool;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tav.core.AssetExtension;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements e {
    public h IBw;
    private AbstractC1953b IQD;
    com.tencent.mm.plugin.webview.fts.ui.b IQH;
    private SimpleObjectPool<FtsWebVideoView> IQI = new SimpleObjectPool<>(3);
    private Context context;

    public interface a {
        void Na();

        void gaM();

        void gaN();

        boolean onBackPressed();

        void onBackground();

        void onDestroy();

        void onForeground();
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.c.b$b  reason: collision with other inner class name */
    public interface AbstractC1953b {
        void a(a aVar);

        void gaO();

        void w(View view, boolean z);
    }

    public b(Context context2, MMWebView mMWebView, AbstractC1953b bVar) {
        AppMethodBeat.i(78154);
        this.context = context2;
        this.IQD = bVar;
        this.IQH = new com.tencent.mm.plugin.webview.fts.ui.b(mMWebView, bVar);
        AppMethodBeat.o(78154);
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.e
    public final void Q(final int i2, String str, String str2) {
        final FtsWebVideoView ftsWebVideoView;
        AppMethodBeat.i(78155);
        Log.i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", Integer.valueOf(i2), str, str2);
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                Log.e("FtsVideoPlayerMgr", "insert args invalid");
                AppMethodBeat.o(78155);
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            FtsWebVideoView acquire = this.IQI.acquire();
            if (acquire == null) {
                ftsWebVideoView = new FtsWebVideoView(this.context, jSONObject2.optBoolean("autoPlay"));
            } else {
                acquire.stop();
                ftsWebVideoView = acquire;
            }
            ftsWebVideoView.setIsShowBasicControls(true);
            ftsWebVideoView.setVideoSizeByte(jSONObject2.optInt("fileSize"));
            ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
            ftsWebVideoView.setCover$16da05f7(jSONObject2.optString("coverUrl"));
            ftsWebVideoView.setVideoPlayerId(i2);
            ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
            ftsWebVideoView.cN(c.bX(jSONObject2), jSONObject2.optInt("durationSec"));
            final AnonymousClass1 r0 = new a() {
                /* class com.tencent.mm.plugin.webview.fts.c.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.webview.fts.c.a
                public final void Na() {
                    AppMethodBeat.i(78143);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    Log.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
                    if (ftsWebVideoView.IPY.mDo) {
                        ftsWebVideoView.IPY.bGL();
                    }
                    ftsWebVideoView.hN(false);
                    AppMethodBeat.o(78143);
                }
            };
            ftsWebVideoView.setFullScreenDelegate(new FtsWebVideoView.a() {
                /* class com.tencent.mm.plugin.webview.fts.c.b.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a
                public final void yU(boolean z) {
                    AppMethodBeat.i(78144);
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.IQH;
                    b.AnonymousClass4 r0 = new SyncTask<Boolean>(Boolean.FALSE, i2, r0, z) {
                        /* class com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass4 */
                        final /* synthetic */ com.tencent.mm.plugin.webview.fts.c.a IQF;
                        final /* synthetic */ boolean IQG;
                        final /* synthetic */ int lJX;

                        {
                            this.lJX = r5;
                            this.IQF = r6;
                            this.IQG = r7;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // com.tencent.mm.sdk.platformtools.SyncTask
                        public final /* synthetic */ Boolean run() {
                            boolean z;
                            ViewGroup afQ;
                            AppMethodBeat.i(78129);
                            b bVar = b.this;
                            int i2 = this.lJX;
                            com.tencent.mm.plugin.webview.fts.c.a aVar = this.IQF;
                            boolean z2 = this.IQG;
                            if (i2 == bVar.nsw) {
                                z = false;
                            } else {
                                a afR = bVar.afR(i2);
                                if (afR == null || afR.nsR == null) {
                                    z = false;
                                } else {
                                    View view = afR.nsR.get();
                                    if (view == null) {
                                        z = false;
                                    } else {
                                        bVar.nsA = i2;
                                        ViewGroup afQ2 = bVar.afQ(afR.parent);
                                        a afR2 = bVar.afR(afR.parent);
                                        if (afR2 == null || (afQ = bVar.afQ(afR2.parent)) == null) {
                                            afR2 = afR;
                                        } else {
                                            View view2 = afR.nsR.get();
                                            if (view2 != null) {
                                                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                                                layoutParams.width = -1;
                                                layoutParams.height = -1;
                                                view2.setLayoutParams(layoutParams);
                                            }
                                            bVar.nsA = afR2.id;
                                            afQ2 = afQ;
                                        }
                                        if (afQ2 != null) {
                                            view = afR2.nsR.get();
                                            afQ2.addView(bVar.nsy, afQ2.indexOfChild(view));
                                            afQ2.removeView(view);
                                        }
                                        bVar.nsx = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) afR2.z};
                                        bVar.IQD.w(view, z2);
                                        bVar.nsw = i2;
                                        bVar.IQC = aVar;
                                        z = true;
                                    }
                                }
                            }
                            Boolean valueOf = Boolean.valueOf(z);
                            AppMethodBeat.o(78129);
                            return valueOf;
                        }
                    };
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) r0.exec(null)).booleanValue();
                        AppMethodBeat.o(78144);
                        return;
                    }
                    ((Boolean) r0.exec(bVar.mHandler)).booleanValue();
                    AppMethodBeat.o(78144);
                }

                @Override // com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a
                public final void bGL() {
                    AppMethodBeat.i(78145);
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.IQH;
                    b.AnonymousClass5 r2 = new SyncTask<Boolean>(Boolean.FALSE, i2) {
                        /* class com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass5 */
                        final /* synthetic */ int lJX;

                        {
                            this.lJX = r5;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // com.tencent.mm.sdk.platformtools.SyncTask
                        public final /* synthetic */ Boolean run() {
                            AppMethodBeat.i(78130);
                            Boolean valueOf = Boolean.valueOf(b.this.yQ(this.lJX));
                            AppMethodBeat.o(78130);
                            return valueOf;
                        }
                    };
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) r2.exec(null)).booleanValue();
                        AppMethodBeat.o(78145);
                        return;
                    }
                    ((Boolean) r2.exec(bVar.mHandler)).booleanValue();
                    AppMethodBeat.o(78145);
                }

                @Override // com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a
                public final boolean isFullScreen() {
                    AppMethodBeat.i(78146);
                    boolean wH = b.this.IQH.wH(i2);
                    AppMethodBeat.o(78146);
                    return wH;
                }
            });
            AnonymousClass3 r02 = new a() {
                /* class com.tencent.mm.plugin.webview.fts.c.b.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.webview.fts.c.b.a
                public final void onForeground() {
                    AppMethodBeat.i(78147);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    Log.i("MicroMsg.FtsWebVideoView", "onUIResume");
                    ftsWebVideoView.IPX.onUIResume();
                    AppMethodBeat.o(78147);
                }

                @Override // com.tencent.mm.plugin.webview.fts.c.b.a
                public final void onBackground() {
                    AppMethodBeat.i(78148);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    Log.i("MicroMsg.FtsWebVideoView", "onUIPause");
                    ftsWebVideoView.IPX.onUIPause();
                    AppMethodBeat.o(78148);
                }

                @Override // com.tencent.mm.plugin.webview.fts.c.b.a
                public final void onDestroy() {
                    AppMethodBeat.i(78149);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    Log.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
                    Log.i("MicroMsg.FtsWebVideoView", "clean");
                    ftsWebVideoView.stop();
                    ftsWebVideoView.IPX.onUIDestroy();
                    WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = ftsWebVideoView.IPY;
                    if (webSearchWebVideoViewControlBar.mww != null) {
                        webSearchWebVideoViewControlBar.mww.stopTimer();
                    }
                    if (webSearchWebVideoViewControlBar.mDn != null) {
                        webSearchWebVideoViewControlBar.mDn.stopTimer();
                    }
                    try {
                        ftsWebVideoView.getContext().unregisterReceiver(ftsWebVideoView.IQr);
                        AppMethodBeat.o(78149);
                    } catch (Exception e2) {
                        AppMethodBeat.o(78149);
                    }
                }

                @Override // com.tencent.mm.plugin.webview.fts.c.b.a
                public final void Na() {
                    b.a afR;
                    View view;
                    AppMethodBeat.i(78150);
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.IQH;
                    b.a afR2 = bVar.afR(bVar.nsA);
                    float[] fArr = bVar.nsx;
                    if (afR2 == null || afR2.nsR == null || fArr == null) {
                        AppMethodBeat.o(78150);
                        return;
                    }
                    View view2 = afR2.nsR.get();
                    if (view2 != null) {
                        if (!(bVar.nsA == bVar.nsw || (afR = bVar.afR(bVar.nsw)) == null || afR.nsR == null || (view = afR.nsR.get()) == null)) {
                            bVar.a(bVar.nsw, fArr, view.getVisibility());
                        }
                        int i2 = bVar.nsA;
                        bVar.nsw = -1;
                        bVar.nsA = -1;
                        if (bVar.IQC != null) {
                            bVar.IQC.Na();
                            bVar.IQC = null;
                        }
                        bVar.a(i2, fArr, view2.getVisibility());
                    }
                    AppMethodBeat.o(78150);
                }

                @Override // com.tencent.mm.plugin.webview.fts.c.b.a
                public final boolean onBackPressed() {
                    AppMethodBeat.i(78151);
                    if (ftsWebVideoView.bJb()) {
                        ftsWebVideoView.yT(false);
                        AppMethodBeat.o(78151);
                        return true;
                    }
                    AppMethodBeat.o(78151);
                    return false;
                }

                @Override // com.tencent.mm.plugin.webview.fts.c.b.a
                public final void gaM() {
                    AppMethodBeat.i(78152);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    if (!ftsWebVideoView.guh && ftsWebVideoView.getSystemVolume() == 0) {
                        ftsWebVideoView.setMute(true);
                    }
                    AppMethodBeat.o(78152);
                }

                @Override // com.tencent.mm.plugin.webview.fts.c.b.a
                public final void gaN() {
                    AppMethodBeat.i(78153);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    if (ftsWebVideoView.guh && ftsWebVideoView.getSystemVolume() > 0) {
                        ftsWebVideoView.setMute(false);
                    }
                    AppMethodBeat.o(78153);
                }
            };
            ftsWebVideoView.setUiLifecycleListener(r02);
            this.IQD.a(r02);
            ftsWebVideoView.setCallback(new d(ftsWebVideoView, this.IQD, this.IBw));
            com.tencent.mm.plugin.webview.fts.ui.b bVar = this.IQH;
            b.AnonymousClass1 r03 = new SyncTask<Boolean>(Boolean.FALSE, ftsWebVideoView, i2, c.a(jSONObject, this.context), c.M(jSONObject)) {
                /* class com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass1 */
                final /* synthetic */ int azx;
                final /* synthetic */ int lJX;
                final /* synthetic */ int nsG = 0;
                final /* synthetic */ float[] nsH;
                final /* synthetic */ View val$view;

                {
                    this.val$view = r5;
                    this.lJX = r6;
                    this.nsH = r7;
                    this.azx = r8;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.sdk.platformtools.SyncTask
                public final /* synthetic */ Boolean run() {
                    AppMethodBeat.i(78126);
                    Boolean valueOf = Boolean.valueOf(b.this.a(this.val$view, this.lJX, this.nsG, this.nsH, this.azx));
                    AppMethodBeat.o(78126);
                    return valueOf;
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ((Boolean) r03.exec(null)).booleanValue();
                AppMethodBeat.o(78155);
                return;
            }
            ((Boolean) r03.exec(bVar.mHandler)).booleanValue();
            AppMethodBeat.o(78155);
        } catch (JSONException e2) {
            Log.e("FtsVideoPlayerMgr", "", e2);
            AppMethodBeat.o(78155);
        }
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.e
    public final void R(int i2, String str, String str2) {
        AppMethodBeat.i(78156);
        Log.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", Integer.valueOf(i2), str, str2);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                com.tencent.mm.plugin.webview.fts.ui.b bVar = this.IQH;
                b.AnonymousClass3 r0 = new SyncTask<Boolean>(Boolean.FALSE, i2, c.a(jSONObject, this.context), c.M(jSONObject)) {
                    /* class com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass3 */
                    final /* synthetic */ int azx;
                    final /* synthetic */ int lJX;
                    final /* synthetic */ float[] nsH;

                    {
                        this.lJX = r5;
                        this.nsH = r6;
                        this.azx = r7;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.tencent.mm.sdk.platformtools.SyncTask
                    public final /* synthetic */ Boolean run() {
                        AppMethodBeat.i(78128);
                        Boolean valueOf = Boolean.valueOf(b.this.a(this.lJX, this.nsH, this.azx));
                        AppMethodBeat.o(78128);
                        return valueOf;
                    }
                };
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ((Boolean) r0.exec(null)).booleanValue();
                } else {
                    ((Boolean) r0.exec(bVar.mHandler)).booleanValue();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject(str2);
                FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.IQH.getViewById(i2);
                if (ftsWebVideoView == null) {
                    Log.i("FtsVideoPlayerMgr", "can not find video View by id %d", Integer.valueOf(i2));
                    AppMethodBeat.o(78156);
                    return;
                }
                if (jSONObject2.has("autoPlay")) {
                    ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
                }
                if (jSONObject2.has("coverUrl")) {
                    ftsWebVideoView.setCover$16da05f7(jSONObject2.optString("coverUrl"));
                }
                if (jSONObject2.has("durationSec")) {
                    ftsWebVideoView.setDuration(jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("playUrl")) {
                    ftsWebVideoView.cN(c.bX(jSONObject2), jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("isMute")) {
                    ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
                }
            }
            AppMethodBeat.o(78156);
        } catch (JSONException e2) {
            Log.e("FtsVideoPlayerMgr", "", e2);
            AppMethodBeat.o(78156);
        }
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.e
    public final void afS(int i2) {
        AppMethodBeat.i(78157);
        Log.i("FtsVideoPlayerMgr", "remove palyer id %d", Integer.valueOf(i2));
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.IQH.getViewById(i2);
        if (ftsWebVideoView != null) {
            ftsWebVideoView.getUiLifecycleListener();
        } else {
            Log.w("FtsVideoPlayerMgr", "can not find player by id %d", Integer.valueOf(i2));
        }
        com.tencent.mm.plugin.webview.fts.ui.b bVar = this.IQH;
        b.AnonymousClass2 r2 = new SyncTask<Boolean>(Boolean.FALSE, i2) {
            /* class com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass2 */
            final /* synthetic */ int lJX;

            {
                this.lJX = r5;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                boolean z;
                AppMethodBeat.i(78127);
                b bVar = b.this;
                int i2 = this.lJX;
                a afR = bVar.afR(i2);
                if (afR != null) {
                    bVar.yQ(i2);
                    bVar.a(afR);
                    ViewGroup afQ = bVar.afQ(afR.parent);
                    if (afQ != null) {
                        bVar.IQB.remove(afR);
                        afQ.removeView(afR.nsR.get());
                        z = true;
                        Boolean valueOf = Boolean.valueOf(z);
                        AppMethodBeat.o(78127);
                        return valueOf;
                    }
                }
                z = false;
                Boolean valueOf2 = Boolean.valueOf(z);
                AppMethodBeat.o(78127);
                return valueOf2;
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ((Boolean) r2.exec(null)).booleanValue();
        } else {
            ((Boolean) r2.exec(bVar.mHandler)).booleanValue();
        }
        if (ftsWebVideoView != null) {
            ftsWebVideoView.stop();
            ftsWebVideoView.getCallback().clean();
            ftsWebVideoView.setCallback(null);
            ftsWebVideoView.setVisibility(0);
            ftsWebVideoView.setAllowMobileNetPlay(false);
            this.IQI.release(ftsWebVideoView);
        }
        AppMethodBeat.o(78157);
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.e
    public final void cS(int i2, String str) {
        AppMethodBeat.i(78158);
        Log.i("FtsVideoPlayerMgr", "op player id %d,type %s", Integer.valueOf(i2), str);
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.IQH.getViewById(i2);
        if (ftsWebVideoView != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case 3443508:
                    if (str.equals(AssetExtension.SCENE_PLAY)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3540994:
                    if (str.equals("stop")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 640038740:
                    if (str.equals("setUnMute")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1984790939:
                    if (str.equals("setMute")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ftsWebVideoView.start(false);
                    AppMethodBeat.o(78158);
                    return;
                case 1:
                    ftsWebVideoView.pause();
                    AppMethodBeat.o(78158);
                    return;
                case 2:
                    ftsWebVideoView.stop();
                    AppMethodBeat.o(78158);
                    return;
                case 3:
                    ftsWebVideoView.setMute(true);
                    AppMethodBeat.o(78158);
                    return;
                case 4:
                    ftsWebVideoView.setMute(false);
                    AppMethodBeat.o(78158);
                    return;
                default:
                    Log.i("FtsVideoPlayerMgr", "unknown op type %s", str);
                    AppMethodBeat.o(78158);
                    return;
            }
        } else {
            Log.i("FtsVideoPlayerMgr", "can not find player by id %d", Integer.valueOf(i2));
            AppMethodBeat.o(78158);
        }
    }
}
