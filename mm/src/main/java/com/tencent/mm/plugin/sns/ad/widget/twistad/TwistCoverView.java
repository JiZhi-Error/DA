package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.e.m;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONObject;

public class TwistCoverView extends FrameLayout implements LifecycleObserver {
    private Handler DAC = new Handler() {
        /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void handleMessage(Message message) {
            AppMethodBeat.i(202495);
            switch (message.what) {
                case 1:
                    TwistCoverView.a(TwistCoverView.this, (long) message.arg1);
                    AppMethodBeat.o(202495);
                    return;
                case 2:
                    TwistCoverView.a(TwistCoverView.this, ((float) message.arg1) / 1000.0f);
                    AppMethodBeat.o(202495);
                    return;
                case 3:
                    TwistCoverView.a(TwistCoverView.this);
                    AppMethodBeat.o(202495);
                    return;
                case 4:
                    if (TwistCoverView.this.xc != null && !TwistCoverView.this.xc.isRunning()) {
                        TwistCoverView.this.xc.start();
                        break;
                    }
            }
            AppMethodBeat.o(202495);
        }
    };
    private TwistDegreeView DBK;
    private ImageView DBL;
    private volatile ADXml.k DBM;
    private m DBN;
    private boolean DBO = false;
    private boolean DBP = false;
    private boolean DBQ = false;
    private boolean DBR = false;
    private boolean DBS = true;
    private boolean DBT = false;
    private boolean DBU = false;
    private boolean DBV = false;
    private boolean DBW = false;
    private float DBX = 0.0f;
    private m.a DBY = new m.a() {
        /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.sns.ad.e.m.a
        public final void bS(float f2) {
            AppMethodBeat.i(202497);
            ADXml.k kVar = TwistCoverView.this.DBM;
            if (kVar == null) {
                AppMethodBeat.o(202497);
                return;
            }
            if (kVar.DWV && f2 > 0.0f) {
                f2 = 0.0f;
            }
            if (!kVar.DWV && f2 < 0.0f) {
                f2 = 0.0f;
            }
            float abs = Math.abs(f2 / ((float) kVar.DWU));
            if (Math.abs(f2) > TwistCoverView.this.DBX) {
                TwistCoverView.this.DBX = Math.abs(f2);
            }
            Message obtain = Message.obtain(TwistCoverView.this.DAC, 2);
            obtain.arg1 = (int) (abs * 1000.0f);
            obtain.sendToTarget();
            AppMethodBeat.o(202497);
        }

        @Override // com.tencent.mm.plugin.sns.ad.e.m.a
        public final void eWR() {
            AppMethodBeat.i(202498);
            Message.obtain(TwistCoverView.this.DAC, 3).sendToTarget();
            AppMethodBeat.o(202498);
        }
    };
    private a DBZ;
    private SnsInfo DqO;
    private TextView Xy;
    private int mScene;
    private AnimatorSet xc;
    private TextView zpl;

    public interface a {
        void eYQ();
    }

    public TwistCoverView(Context context) {
        super(context);
        AppMethodBeat.i(202500);
        init(context);
        AppMethodBeat.o(202500);
    }

    public TwistCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(202501);
        init(context);
        AppMethodBeat.o(202501);
    }

    private void init(Context context) {
        AppMethodBeat.i(202502);
        bh(context);
        if (context instanceof LifecycleOwner) {
            ((LifecycleOwner) context).getLifecycle().addObserver(this);
        }
        AppMethodBeat.o(202502);
    }

    private void bh(Context context) {
        AppMethodBeat.i(202503);
        LayoutInflater.from(context).inflate(R.layout.bv2, (ViewGroup) this, true);
        this.DBK = (TwistDegreeView) findViewById(R.id.iza);
        this.DBL = (ImageView) findViewById(R.id.gab);
        this.Xy = (TextView) findViewById(R.id.ir5);
        this.zpl = (TextView) findViewById(R.id.bn8);
        setBackgroundColor(Color.parseColor("#CC000000"));
        AppMethodBeat.o(202503);
    }

    public final void a(SnsInfo snsInfo, ADXml.k kVar, int i2) {
        boolean z;
        AppMethodBeat.i(202504);
        this.DBM = kVar;
        this.DqO = snsInfo;
        this.mScene = i2;
        if (!(this.DBM == null || snsInfo == null)) {
            Log.i("TwistCoverView", "initData, id=" + r.Jb(snsInfo.field_snsId) + ", twistInfo=" + this.DBM + ", scene=" + i2);
            Context context = getContext();
            if (this.DBN == null) {
                this.DBN = new m(context);
                this.DBN.Dti = this.DBY;
                if (this.DBN.Dtc != null) {
                    z = true;
                } else {
                    z = false;
                }
                this.DBW = z;
                Log.i("TwistCoverView", "initSensor, isSensorOk=" + this.DBW);
            }
        }
        AppMethodBeat.o(202504);
    }

    public final void IW(long j2) {
        AppMethodBeat.i(202505);
        Message obtain = Message.obtain(this.DAC, 1);
        obtain.arg1 = (int) j2;
        obtain.sendToTarget();
        AppMethodBeat.o(202505);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onUIResume() {
        AppMethodBeat.i(202506);
        if (this.DBM == null) {
            AppMethodBeat.o(202506);
            return;
        }
        Log.i("TwistCoverView", "onUIResume, isTwistActionCalled=" + this.DBO);
        this.DBR = false;
        if (this.DBO && getVisibility() == 0) {
            eYO();
        }
        eYJ();
        AppMethodBeat.o(202506);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onUIPause() {
        AppMethodBeat.i(202507);
        if (this.DBM == null) {
            AppMethodBeat.o(202507);
            return;
        }
        Log.i("TwistCoverView", "onUIPause");
        this.DBR = true;
        setSensorEnabled(false);
        if (this.DBP) {
            eYN();
        }
        AppMethodBeat.o(202507);
    }

    public final void onPlayerPaused() {
        AppMethodBeat.i(202508);
        if (this.DBM == null) {
            AppMethodBeat.o(202508);
            return;
        }
        Log.i("TwistCoverView", "onPlayerPaused");
        this.DBQ = true;
        setSensorEnabled(false);
        eYN();
        this.DAC.removeMessages(1);
        AppMethodBeat.o(202508);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(202509);
        super.onDetachedFromWindow();
        Log.i("TwistCoverView", "onDetachedFromWindow");
        if (this.DBU && !this.DBV) {
            a(2, false, this.DBX);
        }
        clear();
        this.DBS = true;
        this.DBT = false;
        this.DBV = false;
        AppMethodBeat.o(202509);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(202510);
        super.onStartTemporaryDetach();
        if (Build.VERSION.SDK_INT < 24) {
            Log.i("TwistCoverView", "onStartTemporaryDetach");
            clear();
        }
        AppMethodBeat.o(202510);
    }

    public final void clear() {
        AppMethodBeat.i(202511);
        this.DBQ = false;
        this.DBM = null;
        this.DqO = null;
        this.DBX = 0.0f;
        this.mScene = -1;
        setSensorEnabled(false);
        hide();
        this.DAC.removeCallbacksAndMessages(null);
        AppMethodBeat.o(202511);
    }

    private void eYJ() {
        AppMethodBeat.i(202512);
        Log.i("TwistCoverView", "resetTwistAngle, sensorMgr==null?" + (this.DBN == null));
        if (this.DBN != null) {
            this.DBN.reset();
        }
        this.DBK.eYR();
        this.DBO = false;
        this.DBX = 0.0f;
        AppMethodBeat.o(202512);
    }

    public void setSensorEnabled(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(202513);
        if (this.DBM == null && z) {
            AppMethodBeat.o(202513);
        } else if ((this.DBQ || this.DBR) && z) {
            Log.e("TwistCoverView", "setSensorEnabled to true when isUIPaused=" + this.DBR + ", isPlayerPaused=" + this.DBQ);
            AppMethodBeat.o(202513);
        } else {
            StringBuilder append = new StringBuilder("setSensorEnabled, enabled=").append(z).append(", sensorMgr==null?");
            if (this.DBN != null) {
                z2 = false;
            }
            Log.i("TwistCoverView", append.append(z2).toString());
            if (this.DBN != null) {
                m mVar = this.DBN;
                if (mVar.Dtc != null) {
                    if (z) {
                        try {
                            if (!mVar.Dtd) {
                                mVar.Dtg = 0;
                                mVar.mSensorManager.registerListener(mVar.Dth, mVar.Dtc, 1);
                                mVar.Dtd = true;
                                AppMethodBeat.o(202513);
                                return;
                            }
                        } catch (Throwable th) {
                            new StringBuilder("setEnabled exp=").append(th.toString());
                        }
                    } else {
                        mVar.mSensorManager.unregisterListener(mVar.Dth);
                        mVar.Dtd = false;
                    }
                    AppMethodBeat.o(202513);
                    return;
                }
            }
            AppMethodBeat.o(202513);
        }
    }

    private boolean eYK() {
        AppMethodBeat.i(202514);
        if (this.DBN != null) {
            boolean z = this.DBN.Dtd;
            AppMethodBeat.o(202514);
            return z;
        }
        Log.i("TwistCoverView", "isSensorEnabled, sensorMgr==null");
        AppMethodBeat.o(202514);
        return false;
    }

    private void hide() {
        AppMethodBeat.i(202515);
        if (!this.DBP) {
            AppMethodBeat.o(202515);
            return;
        }
        this.DBP = false;
        Log.i("TwistCoverView", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
        eYP();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(250L);
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.AnonymousClass2 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(202496);
                TwistCoverView.this.setVisibility(8);
                AppMethodBeat.o(202496);
            }
        });
        ofFloat.start();
        AppMethodBeat.o(202515);
    }

    private void eYL() {
        AppMethodBeat.i(202516);
        if (this.DBZ != null && !this.DBO) {
            this.DBZ.eYQ();
            this.DBO = true;
        }
        this.DBV = true;
        AppMethodBeat.o(202516);
    }

    public void setTwistActionListener(a aVar) {
        this.DBZ = aVar;
    }

    private void eYM() {
        AppMethodBeat.i(202517);
        this.DAC.removeMessages(4);
        if (this.xc != null && !this.xc.isRunning()) {
            Log.d("TwistCoverView", "startIconAnim");
            this.xc.start();
        }
        AppMethodBeat.o(202517);
    }

    private void eYN() {
        AppMethodBeat.i(202518);
        this.DAC.removeMessages(4);
        if (this.xc != null && this.xc.isRunning()) {
            Log.d("TwistCoverView", "pauseIconAnim");
            this.xc.pause();
        }
        AppMethodBeat.o(202518);
    }

    private void eYO() {
        AppMethodBeat.i(202519);
        this.DAC.removeMessages(4);
        Log.d("TwistCoverView", "resumeIconAnim, isUIPaused=" + this.DBR + ", anim.isPaused=" + (this.xc == null ? false : this.xc.isPaused()));
        if (this.xc != null && !this.DBR) {
            if (this.xc.isPaused()) {
                this.xc.resume();
                AppMethodBeat.o(202519);
                return;
            }
            eYM();
        }
        AppMethodBeat.o(202519);
    }

    private void eYP() {
        AppMethodBeat.i(202520);
        if (this.xc != null) {
            Log.d("TwistCoverView", "stopIconAnim");
            this.DAC.removeMessages(4);
            this.xc.removeAllListeners();
            this.xc.end();
            this.xc = null;
        }
        AppMethodBeat.o(202520);
    }

    public static void a(ah ahVar, int i2) {
        AppMethodBeat.i(202521);
        if (ahVar == null) {
            Log.e("TwistCoverView_report", "reportGetTwistIdResult, landingPageData==null");
            AppMethodBeat.o(202521);
            return;
        }
        String snsId = ahVar.getSnsId();
        String str = ahVar.uxInfo;
        int i3 = ahVar.source;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("snsid", Util.nullAsNil(snsId));
            jSONObject.put("uxinfo", Util.nullAsNil(str));
            jSONObject.put("scene", i3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", i2);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
            String jSONObject3 = jSONObject.toString();
            k.jY("timeline_twistad_canvas_get_twist_cardId_result", jSONObject3);
            Log.i("TwistCoverView_report", "reportGetTwistIdResult, content=".concat(String.valueOf(jSONObject3)));
            AppMethodBeat.o(202521);
        } catch (Exception e2) {
            Log.e("TwistCoverView_report", "reportGetTwistIdResult exp:" + e2.toString());
            AppMethodBeat.o(202521);
        }
    }

    private void a(int i2, boolean z, float f2) {
        int i3 = 1;
        AppMethodBeat.i(202522);
        if (this.DqO == null) {
            Log.e("TwistCoverView_report", "reportTwistActionResult, snsInfo==null");
            AppMethodBeat.o(202522);
            return;
        }
        SnsInfo snsInfo = this.DqO;
        String Jb = r.Jb(snsInfo.field_snsId);
        String uxinfo = snsInfo.getUxinfo();
        int i4 = this.mScene;
        if (TextUtils.isEmpty(Jb)) {
            Log.e("TwistCoverView_report", "reportTwistActionResult, snsId==null, source=".concat(String.valueOf(i4)));
            AppMethodBeat.o(202522);
        } else if (TextUtils.isEmpty(Jb)) {
            Log.e("TwistCoverView_report", "reportTwistActionResult, snsId==null, source=".concat(String.valueOf(i4)));
            AppMethodBeat.o(202522);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("snsid", Jb);
                jSONObject.put("uxinfo", Util.nullAsNil(uxinfo));
                jSONObject.put("scene", i4);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", i2);
                if (!z) {
                    i3 = 0;
                }
                jSONObject2.put("triggerByAcceleration", i3);
                jSONObject2.put("failedMaxDegree", Math.round(f2));
                if (!this.DBW) {
                    jSONObject2.put("sensorDisable", 1);
                }
                jSONObject.put(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
                String jSONObject3 = jSONObject.toString();
                k.jY("timeline_twistad_twist_result", jSONObject3);
                Log.i("TwistCoverView_report", "reportTwistActionResult, content=".concat(String.valueOf(jSONObject3)));
                AppMethodBeat.o(202522);
            } catch (Exception e2) {
                Log.e("TwistCoverView_report", "reportTwistActionResult exp:" + e2.toString());
                AppMethodBeat.o(202522);
            }
        }
    }

    static /* synthetic */ void a(TwistCoverView twistCoverView, long j2) {
        int i2;
        AppMethodBeat.i(202523);
        if (twistCoverView.DBM == null) {
            Log.e("TwistCoverView", "checkShow， mAdTwistInfo==null");
            twistCoverView.clear();
            AppMethodBeat.o(202523);
            return;
        }
        Log.d("TwistCoverView", "checkShow:".concat(String.valueOf(j2)));
        if (j2 < ((long) twistCoverView.DBM.DWQ) || j2 > ((long) twistCoverView.DBM.DWR)) {
            if (twistCoverView.eYK()) {
                twistCoverView.setSensorEnabled(false);
            }
            twistCoverView.DBU = false;
            if (twistCoverView.DBT) {
                Log.d("TwistCoverView", "out twist zone");
                twistCoverView.DBT = false;
                if (!twistCoverView.DBV) {
                    twistCoverView.a(2, false, twistCoverView.DBX);
                }
            }
            twistCoverView.DBS = true;
        } else {
            if (!twistCoverView.eYK() && !twistCoverView.DBR) {
                twistCoverView.eYJ();
                twistCoverView.setSensorEnabled(true);
            }
            twistCoverView.DBU = true;
            if (twistCoverView.DBS) {
                Log.d("TwistCoverView", "in twist zone");
                twistCoverView.DBS = false;
                twistCoverView.DBV = false;
                twistCoverView.a(3, false, 0.0f);
                int i3 = 0;
                try {
                    if (twistCoverView.DBW) {
                        i3 = 1;
                    }
                    j.b(j.VaK, "", i3, m.VaH, new StringBuilder().append(m.VaI).toString());
                } catch (Throwable th) {
                    Log.e("TwistCoverView", "reportTwistSensor, exo=" + th.toString());
                }
            }
            twistCoverView.DBT = true;
        }
        if (j2 < ((long) twistCoverView.DBM.DWS) || j2 > ((long) twistCoverView.DBM.DWT)) {
            twistCoverView.hide();
        } else if (twistCoverView.DBQ && twistCoverView.getVisibility() == 0) {
            twistCoverView.eYO();
        } else if (!twistCoverView.DBP) {
            Log.i("TwistCoverView", "show");
            twistCoverView.DBP = true;
            if (twistCoverView.getVisibility() != 0) {
                twistCoverView.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(twistCoverView, "alpha", 0.0f, 1.0f);
                ofFloat.setDuration(250L);
                ofFloat.start();
                if (twistCoverView.DBM == null) {
                    Log.e("TwistCoverView", "initIconAnim err, info==null");
                } else {
                    Log.d("TwistCoverView", "initIconAnim");
                    float f2 = -45.0f;
                    float f3 = 5.0f;
                    if (twistCoverView.DBM.DWV) {
                        f2 = 45.0f;
                        f3 = -5.0f;
                    }
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(twistCoverView.DBL, "rotation", 0.0f, 0.0f);
                    ofFloat2.setDuration(100L);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(twistCoverView.DBL, "rotation", 0.0f, f2);
                    ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
                    ofFloat3.setDuration(700L);
                    ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(twistCoverView.DBL, "rotation", f2, f2);
                    ofFloat4.setDuration(200L);
                    ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(twistCoverView.DBL, "rotation", f2, f3);
                    ofFloat5.setDuration(200L);
                    ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(twistCoverView.DBL, "rotation", f3, -f3);
                    ofFloat6.setDuration(200L);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(twistCoverView.DBL, "rotation", -f3, 0.0f);
                    ofFloat7.setDuration(200L);
                    twistCoverView.xc = new AnimatorSet();
                    twistCoverView.xc.playSequentially(ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ofFloat7);
                    twistCoverView.xc.addListener(new AnimatorListenerAdapter() {
                        /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.AnonymousClass4 */

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(202499);
                            TwistCoverView.this.DAC.sendEmptyMessageDelayed(4, 500);
                            AppMethodBeat.o(202499);
                        }
                    });
                }
                twistCoverView.eYM();
            }
            if (twistCoverView.DBM != null) {
                twistCoverView.Xy.setText(twistCoverView.DBM.title);
                twistCoverView.zpl.setText(twistCoverView.DBM.desc);
                TwistDegreeView twistDegreeView = twistCoverView.DBK;
                if (twistCoverView.DBM.DWV) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                twistDegreeView.setShowMode(i2);
            }
        }
        twistCoverView.DBQ = false;
        AppMethodBeat.o(202523);
    }

    static /* synthetic */ void a(TwistCoverView twistCoverView, float f2) {
        AppMethodBeat.i(202524);
        twistCoverView.DBK.setProgress(f2);
        if (Math.abs(f2) >= 1.0f && !twistCoverView.DBO) {
            Log.i("TwistCoverView", "onTwistActionSucc by degree");
            twistCoverView.eYN();
            twistCoverView.setSensorEnabled(false);
            twistCoverView.DAC.removeMessages(2);
            twistCoverView.DAC.removeMessages(1);
            if (twistCoverView.DBM != null) {
                twistCoverView.a(1, false, (float) twistCoverView.DBM.DWU);
            } else {
                Log.e("TwistCoverView", "onTwistDegreeChange, mAdTwistInfo==null");
            }
            twistCoverView.eYL();
        }
        AppMethodBeat.o(202524);
    }

    static /* synthetic */ void a(TwistCoverView twistCoverView) {
        AppMethodBeat.i(202525);
        if (!twistCoverView.DBO) {
            Log.i("TwistCoverView", "onTwistActionSucc by acceleration");
            twistCoverView.eYN();
            twistCoverView.setSensorEnabled(false);
            twistCoverView.DAC.removeMessages(2);
            twistCoverView.DAC.removeMessages(1);
            twistCoverView.DBK.setProgress(1.0f);
            twistCoverView.a(1, true, 0.0f);
            twistCoverView.eYL();
        }
        AppMethodBeat.o(202525);
    }
}
