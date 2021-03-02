package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import org.json.JSONObject;

public class AppBrandLivePusherView extends TXCloudVideoView {
    public String cHp = "";
    public String cHq;
    public int cHv = 0;
    ad lPK;
    private a lXH = new a();
    m lXI;
    private ITXLivePushListener lXJ;
    private c lXK;
    private b lXL;
    private Handler mHandler = new Handler(getContext().getMainLooper());

    public interface b {
        void a(int i2, String str, HashMap<String, Object> hashMap);
    }

    public interface c {
        void bGN();
    }

    static /* synthetic */ boolean a(AppBrandLivePusherView appBrandLivePusherView, int i2) {
        AppMethodBeat.i(145843);
        boolean xe = appBrandLivePusherView.xe(i2);
        AppMethodBeat.o(145843);
        return xe;
    }

    static /* synthetic */ int c(AppBrandLivePusherView appBrandLivePusherView) {
        AppMethodBeat.i(145842);
        int rotationAngle = appBrandLivePusherView.getRotationAngle();
        AppMethodBeat.o(145842);
        return rotationAngle;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(145832);
        super.onConfigurationChanged(configuration);
        xe(getRotationAngle());
        AppMethodBeat.o(145832);
    }

    public AppBrandLivePusherView(Context context) {
        super(context);
        AppMethodBeat.i(145833);
        init(context);
        AppMethodBeat.o(145833);
    }

    public AppBrandLivePusherView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(145834);
        init(context);
        AppMethodBeat.o(145834);
    }

    private void init(Context context) {
        AppMethodBeat.i(145835);
        this.lXI = new m(context);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.lPK = new ad(getContext(), new ad.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.utils.ad.b
            public final void a(ad.a aVar, ad.a aVar2) {
                int i2;
                AppMethodBeat.i(145829);
                switch (AnonymousClass2.cHH[aVar2.ordinal()]) {
                    case 1:
                        i2 = 1;
                        break;
                    case 2:
                        i2 = 0;
                        break;
                    case 3:
                        i2 = 2;
                        break;
                    case 4:
                        i2 = 3;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                a aVar3 = AppBrandLivePusherView.this.lXH;
                aVar3.number = 0;
                AppBrandLivePusherView.this.mHandler.removeCallbacks(aVar3);
                AppBrandLivePusherView.this.lXH.cHJ = i2;
                a aVar4 = AppBrandLivePusherView.this.lXH;
                AppBrandLivePusherView.this.mHandler.postDelayed(aVar4, 250);
                AppMethodBeat.o(145829);
            }
        });
        this.lPK.enable();
        xe(getRotationAngle());
        AppMethodBeat.o(145835);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] cHH = new int[ad.a.values().length];

        static {
            AppMethodBeat.i(145830);
            try {
                cHH[ad.a.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cHH[ad.a.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                cHH[ad.a.REVERSE_PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                cHH[ad.a.REVERSE_LANDSCAPE.ordinal()] = 4;
                AppMethodBeat.o(145830);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(145830);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        int cHJ;
        int number = 0;

        a() {
        }

        public final void run() {
            AppMethodBeat.i(145831);
            this.number++;
            Log.i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.cHJ);
            int c2 = AppBrandLivePusherView.c(AppBrandLivePusherView.this);
            if (c2 == this.cHJ) {
                AppBrandLivePusherView.a(AppBrandLivePusherView.this, c2);
                AppMethodBeat.o(145831);
                return;
            }
            if (this.number < 8) {
                AppBrandLivePusherView.this.mHandler.postDelayed(this, 250);
            }
            AppMethodBeat.o(145831);
        }
    }

    private int getRotationAngle() {
        AppMethodBeat.i(145836);
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        AppMethodBeat.o(145836);
        return rotation;
    }

    private boolean xe(int i2) {
        AppMethodBeat.i(145837);
        if (i2 != this.cHv) {
            this.cHv = i2;
            Log.i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(i2)));
            this.lXI.ib(i2);
            AppMethodBeat.o(145837);
            return true;
        }
        AppMethodBeat.o(145837);
        return false;
    }

    public final void P(Bundle bundle) {
        i iVar;
        AppMethodBeat.i(145838);
        m mVar = this.lXI;
        if (bundle == null) {
            iVar = new i(-1, "invalid params");
        } else {
            m.l(h.NAME, bundle);
            if (!mVar.mInited) {
                iVar = new i(-3, "uninited livePusher");
            } else {
                mVar.a(bundle, false);
                String string = bundle.getString("pushUrl", mVar.cHX);
                if (string != null && !string.isEmpty() && mVar.cHX != null && !mVar.cHX.equalsIgnoreCase(string) && mVar.cHV.isPushing()) {
                    Log.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
                    mVar.stopPreview();
                    mVar.cHV.stopAudioRecord();
                    mVar.cHV.stopPusher();
                }
                mVar.cHX = string;
                mVar.cHV.setPusherUrl(mVar.cHX);
                mVar.cIh = bundle.getBoolean("autopush", mVar.cIh);
                if (mVar.cIh && mVar.cHX != null && !mVar.cHX.isEmpty() && !mVar.cHV.isPushing()) {
                    Log.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
                    mVar.ca(mVar.cIm);
                    mVar.cb(mVar.cIn);
                    mVar.cHV.startPusher(mVar.cHX);
                }
                iVar = new i();
            }
        }
        Log.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.errorInfo);
        AppMethodBeat.o(145838);
    }

    public final boolean j(String str, JSONObject jSONObject) {
        AppMethodBeat.i(145839);
        i l = this.lXI.l(str, jSONObject);
        Log.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", Integer.valueOf(l.errorCode), l.errorInfo);
        if (l.errorCode == 0) {
            AppMethodBeat.o(145839);
            return true;
        }
        AppMethodBeat.o(145839);
        return false;
    }

    public final void onExit() {
        i iVar;
        AppMethodBeat.i(145840);
        m mVar = this.lXI;
        if (!mVar.mInited) {
            iVar = new i(-3, "uninited livePusher");
        } else {
            mVar.cHV.stopBGM();
            mVar.stopPreview();
            mVar.cHV.stopAudioRecord();
            mVar.cHV.stopPusher();
            mVar.cHV.setPushListener(null);
            mVar.mInited = false;
            iVar = new i();
        }
        Log.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.errorInfo);
        if (this.lXK != null) {
            this.lXK.bGN();
        }
        AppMethodBeat.o(145840);
    }

    public final void a(int i2, String str, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(145841);
        Log.w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", Integer.valueOf(i2), str);
        if (this.lXL != null) {
            this.lXL.a(i2, str, hashMap);
        }
        AppMethodBeat.o(145841);
    }

    public void setOnPushEventListener(ITXLivePushListener iTXLivePushListener) {
        this.lXJ = iTXLivePushListener;
        this.lXI.cHW = this.lXJ;
    }

    public void setSnapshotListener(TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        this.lXI.cIc = iTXSnapshotListener;
    }

    public void setBGMNotifyListener(TXLivePusher.OnBGMNotify onBGMNotify) {
        this.lXI.cId = onBGMNotify;
    }

    public void setAudioVolumeNotifyListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.lXI.cIe = iTXAudioVolumeEvaluationListener;
    }

    public void setOnExitListener(c cVar) {
        this.lXK = cVar;
    }

    public void setOnErrorListener(b bVar) {
        this.lXL = bVar;
    }
}
