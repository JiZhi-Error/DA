package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.brandservice.ui.widget.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.o;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class MPVideoViewControlBar extends VideoPlayerSeekBar implements e.a, h {
    private int add;
    private TextView ayz;
    private ImageView mDc;
    private LinearLayout mDe;
    private ImageView mDf;
    private FrameLayout mDg;
    private ImageView mDh;
    private ImageView mDi;
    private ImageView mDj;
    private LinearLayout mDk;
    private LinearLayout mDl;
    private e.i mDm;
    private MTimerHandler mDn;
    private boolean mDo;
    private boolean mDq;
    private boolean mDr;
    private boolean mDs;
    private boolean mDt;
    private boolean mDu;
    private e.AbstractC0717e mDw;
    private MTimerHandler mww;
    private View pOA;
    private LinearLayout pOB;
    private TextView pOC;
    private View pOD;
    private LinearLayout pOE;
    private a pOF;
    private b pOG;
    private Animation pOH;
    private Animation pOI;
    private Animation pOJ;
    private Animation pOK;
    private LinkedList<gh> pOL = new LinkedList<>();
    private gh pOM;
    private e.f pON;
    private RelativeLayout pOu;
    private LinkedList<c> pOv = null;
    private LinearLayout pOw;
    private ImageView pOx;
    private TextView pOy;
    private TextView pOz;

    public interface a {
        void a(gh ghVar, int i2, int i3);

        void cqH();

        void cqI();
    }

    public interface b {
        void a(gh ghVar, c.a aVar, c.a aVar2);

        void crF();

        void crG();
    }

    static /* synthetic */ void d(MPVideoViewControlBar mPVideoViewControlBar) {
        AppMethodBeat.i(6336);
        mPVideoViewControlBar.crL();
        AppMethodBeat.o(6336);
    }

    static /* synthetic */ void e(MPVideoViewControlBar mPVideoViewControlBar) {
        AppMethodBeat.i(179009);
        mPVideoViewControlBar.crN();
        AppMethodBeat.o(179009);
    }

    static /* synthetic */ boolean f(MPVideoViewControlBar mPVideoViewControlBar) {
        AppMethodBeat.i(179010);
        boolean bKX = mPVideoViewControlBar.bKX();
        AppMethodBeat.o(179010);
        return bKX;
    }

    public MPVideoViewControlBar(Context context) {
        super(context);
        AppMethodBeat.i(6285);
        AppMethodBeat.o(6285);
    }

    public MPVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(6286);
        AppMethodBeat.o(6286);
    }

    public MPVideoViewControlBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(6287);
        AppMethodBeat.o(6287);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setStatePorter(e.i iVar) {
        this.mDm = iVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void onDestroy() {
        AppMethodBeat.i(6288);
        if (this.mww != null) {
            this.mww.stopTimer();
        }
        if (this.mDn != null) {
            this.mDn.stopTimer();
        }
        AppMethodBeat.o(6288);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setIplaySeekCallback(final e.d dVar) {
        AppMethodBeat.i(6289);
        setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
                AppMethodBeat.i(6276);
                dVar.aJq();
                AppMethodBeat.o(6276);
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(6277);
                dVar.rk(i2);
                AppMethodBeat.o(6277);
            }
        });
        AppMethodBeat.o(6289);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public int getLayoutId() {
        return R.layout.bc0;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public final void init() {
        AppMethodBeat.i(6290);
        super.init();
        this.mDc = (ImageView) this.contentView.findViewById(R.id.dbs);
        this.mDf = (ImageView) this.contentView.findViewById(R.id.gcy);
        this.mDg = (FrameLayout) this.contentView.findViewById(R.id.gd1);
        this.mDe = (LinearLayout) findViewById(R.id.h8v);
        this.pOu = (RelativeLayout) findViewById(R.id.gcq);
        this.pOB = (LinearLayout) findViewById(R.id.h5f);
        this.pOz = (TextView) findViewById(R.id.h5h);
        this.pOA = findViewById(R.id.h5g);
        this.pOE = (LinearLayout) findViewById(R.id.i3g);
        this.pOC = (TextView) findViewById(R.id.i3i);
        this.pOD = findViewById(R.id.i3h);
        this.mDh = (ImageView) findViewById(R.id.fqr);
        this.mDi = (ImageView) findViewById(R.id.aqa);
        this.mDj = (ImageView) findViewById(R.id.c6j);
        this.ayz = (TextView) findViewById(R.id.ipm);
        this.mDk = (LinearLayout) findViewById(R.id.dcd);
        this.mDl = (LinearLayout) findViewById(R.id.gcv);
        this.pOw = (LinearLayout) findViewById(R.id.flv);
        this.pOx = (ImageView) findViewById(R.id.fll);
        this.pOy = (TextView) findViewById(R.id.flm);
        this.mDe.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(6278);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(6278);
            }
        });
        AppMethodBeat.o(6290);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setMuteBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(6291);
        this.mDh.setOnClickListener(onClickListener);
        AppMethodBeat.o(6291);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setExitFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(6292);
        this.mDj.setOnClickListener(onClickListener);
        AppMethodBeat.o(6292);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.sight.decode.ui.a, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setOnPlayButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(6293);
        super.setOnPlayButtonClickListener(onClickListener);
        this.mDi.setOnClickListener(onClickListener);
        AppMethodBeat.o(6293);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setTitle(String str) {
        AppMethodBeat.i(6294);
        if (!Util.isNullOrNil(str)) {
            this.ayz.setText(str);
        }
        AppMethodBeat.o(6294);
    }

    public final void T(String str, final String str2, String str3) {
        AppMethodBeat.i(195073);
        com.tencent.mm.av.a.a bdb = com.tencent.mm.av.a.a.bdb();
        ImageView imageView = this.pOx;
        c.a aVar = new c.a();
        aVar.iaT = true;
        aVar.jbq = R.drawable.bar;
        bdb.a(str3, imageView, aVar.bdv());
        this.pOy.setText(str);
        this.pOw.setOnClickListener(null);
        this.pOw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(195068);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str2);
                intent.putExtra("Contact_Scene", 179);
                intent.putExtra("force_get_contact", true);
                intent.putExtra("key_use_new_contact_profile", true);
                com.tencent.mm.br.c.b(MPVideoViewControlBar.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                m.DR(45);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195068);
            }
        });
        o.hq(this.pOw);
        AppMethodBeat.o(195073);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.i(6295);
        this.mDh.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(6295);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setMuteBtnState(boolean z) {
        AppMethodBeat.i(6296);
        if (z) {
            this.mDh.setImageResource(R.raw.mp_video_mute_btn_off);
            AppMethodBeat.o(6296);
            return;
        }
        this.mDh.setImageResource(R.raw.mp_video_mute_btn_on);
        AppMethodBeat.o(6296);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowControlProgress(boolean z) {
        AppMethodBeat.i(6297);
        this.mDs = z;
        bKY();
        AppMethodBeat.o(6297);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setPlayBtnInCenterPosition(boolean z) {
        AppMethodBeat.i(6299);
        this.mDu = z;
        bKQ();
        AppMethodBeat.o(6299);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bIZ() {
        AppMethodBeat.i(6300);
        if (this.mDt && this.mDu) {
            this.mDi.setVisibility(8);
        }
        AppMethodBeat.o(6300);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJC() {
        AppMethodBeat.i(6301);
        if (this.mDt && this.mDu) {
            this.mDi.setVisibility(0);
        }
        AppMethodBeat.o(6301);
    }

    private void bKQ() {
        AppMethodBeat.i(6302);
        if (!this.mDt) {
            this.mCP.setVisibility(8);
            this.mDi.setVisibility(8);
            AppMethodBeat.o(6302);
        } else if (this.mDu) {
            this.mCP.setVisibility(8);
            this.mDi.setVisibility(0);
            AppMethodBeat.o(6302);
        } else {
            this.mCP.setVisibility(0);
            this.mDi.setVisibility(8);
            AppMethodBeat.o(6302);
        }
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.sight.decode.ui.a, com.tencent.mm.plugin.appbrand.jsapi.video.e.a, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public void setIsPlay(boolean z) {
        AppMethodBeat.i(6303);
        this.dLB = z;
        if (this.dLB) {
            this.mCP.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_pause, -1));
            this.mDi.setImageResource(R.raw.mp_video_play_btn_pause);
            AppMethodBeat.o(6303);
            return;
        }
        this.mCP.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_play, -1));
        this.mDi.setImageResource(R.raw.mp_video_play_btn_play);
        AppMethodBeat.o(6303);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(6304);
        this.mDc.setOnClickListener(onClickListener);
        AppMethodBeat.o(6304);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setDanmakuBtnOnClickListener(e.g gVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJt() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setDanmakuBtnOpen(boolean z) {
    }

    private void bKS() {
        int dimensionPixelSize;
        AppMethodBeat.i(6305);
        if (this.mDq) {
            this.mDc.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.mDc.getLayoutParams();
            getResources().getDimensionPixelSize(R.dimen.adn);
            if (this.mDo) {
                this.mDc.setImageResource(R.drawable.asi);
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.adl);
            } else {
                this.mDc.setImageResource(R.raw.mp_video_fullscreen_btn);
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.adn);
            }
            layoutParams.height = dimensionPixelSize;
            layoutParams.width = dimensionPixelSize;
            this.mDc.setLayoutParams(layoutParams);
            AppMethodBeat.o(6305);
            return;
        }
        this.mDc.setVisibility(8);
        AppMethodBeat.o(6305);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowDanmakuBtn(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJv() {
        AppMethodBeat.i(6306);
        show();
        if (this.mDn == null) {
            this.mDn = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass7 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(195069);
                    if (MPVideoViewControlBar.this.mbo || MPVideoViewControlBar.this.pOB.getVisibility() == 0) {
                        AppMethodBeat.o(195069);
                        return true;
                    }
                    MPVideoViewControlBar.this.hide();
                    MPVideoViewControlBar.this.mDn.stopTimer();
                    AppMethodBeat.o(195069);
                    return false;
                }
            }, false);
        }
        this.mDn.stopTimer();
        this.mDn.startTimer(4000);
        AppMethodBeat.o(6306);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJB() {
        AppMethodBeat.i(6307);
        if (this.mDn != null) {
            this.mDn.stopTimer();
            this.mDn.startTimer(4000);
        }
        AppMethodBeat.o(6307);
    }

    public final void crH() {
        AppMethodBeat.i(6308);
        if (this.mDn != null) {
            this.mDn.stopTimer();
        }
        AppMethodBeat.o(6308);
    }

    public final void show() {
        AppMethodBeat.i(6310);
        if (getVisibility() == 0) {
            AppMethodBeat.o(6310);
            return;
        }
        if (this.pOH == null) {
            this.pOH = AnimationUtils.loadAnimation(getContext(), R.anim.dq);
            this.pOH.setDuration(300);
        }
        this.mDe.clearAnimation();
        this.mDe.startAnimation(this.pOH);
        if (this.mDo) {
            if (this.pOJ == null) {
                this.pOJ = AnimationUtils.loadAnimation(getContext(), R.anim.dn);
                this.pOJ.setDuration(300);
            }
            this.mDk.clearAnimation();
            this.mDk.startAnimation(this.pOJ);
            this.pOw.clearAnimation();
            this.pOw.startAnimation(this.pOJ);
        }
        setVisibility(0);
        AppMethodBeat.o(6310);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJw() {
        AppMethodBeat.i(6311);
        if (getVisibility() == 0) {
            AppMethodBeat.o(6311);
            return true;
        }
        AppMethodBeat.o(6311);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJu() {
        AppMethodBeat.i(6312);
        if (bJw()) {
            hide();
            AppMethodBeat.o(6312);
            return;
        }
        bJv();
        AppMethodBeat.o(6312);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void KD() {
        AppMethodBeat.i(6313);
        this.mDo = true;
        bKT();
        AppMethodBeat.o(6313);
    }

    public void setDirection(int i2) {
        this.add = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bGL() {
        AppMethodBeat.i(6314);
        this.mDo = false;
        bKT();
        AppMethodBeat.o(6314);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJx() {
        return this.mDo;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJy() {
        return true;
    }

    private void bKT() {
        AppMethodBeat.i(6315);
        bKW();
        bKS();
        bKP();
        bKV();
        bKU();
        N(this.pOv);
        crK();
        crM();
        crO();
        crP();
        AppMethodBeat.o(6315);
    }

    private void bKU() {
        int dimensionPixelSize;
        AppMethodBeat.i(6316);
        if (crI()) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.adh);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ad8);
        }
        if (this.mCP != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCP.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelSize);
            this.mCP.setLayoutParams(marginLayoutParams);
        }
        if (this.mDl != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mDl.getLayoutParams();
            marginLayoutParams2.setMarginStart(dimensionPixelSize);
            this.mDl.setLayoutParams(marginLayoutParams2);
        }
        if (this.mDh != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.mDh.getLayoutParams();
            marginLayoutParams3.setMarginStart(dimensionPixelSize);
            this.mDh.setLayoutParams(marginLayoutParams3);
        }
        if (this.mDc != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.mDc.getLayoutParams();
            marginLayoutParams4.setMarginStart(dimensionPixelSize);
            this.mDc.setLayoutParams(marginLayoutParams4);
        }
        if (this.pOA != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.pOA.getLayoutParams();
            marginLayoutParams5.setMarginStart(dimensionPixelSize);
            this.pOA.setLayoutParams(marginLayoutParams5);
        }
        if (this.pOD != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) this.pOA.getLayoutParams();
            marginLayoutParams6.setMarginStart(dimensionPixelSize);
            this.pOD.setLayoutParams(marginLayoutParams6);
        }
        AppMethodBeat.o(6316);
    }

    private void bKV() {
        float dimensionPixelSize;
        AppMethodBeat.i(6317);
        if (crI()) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.adk);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.add);
        }
        this.mCQ.setTextSize(0, dimensionPixelSize);
        this.mCR.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.o(6317);
    }

    private void bKW() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        AppMethodBeat.i(6318);
        ViewGroup.LayoutParams layoutParams = this.mDe.getLayoutParams();
        if (this.mDo) {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.adi);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.ad_);
        }
        this.mDe.setLayoutParams(layoutParams);
        if (crI()) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.adj);
            dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.adh);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ada);
            dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ada);
        }
        this.mDe.setPadding(0, 0, dimensionPixelSize2, 0);
        if (this.mDk != null) {
            this.mDk.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        if (this.pOw != null) {
            this.pOw.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        AppMethodBeat.o(6318);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJz() {
        AppMethodBeat.i(6319);
        if (this.mww == null) {
            this.mww = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass9 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(195071);
                    if (!MPVideoViewControlBar.f(MPVideoViewControlBar.this)) {
                        AppMethodBeat.o(195071);
                        return false;
                    }
                    AppMethodBeat.o(195071);
                    return true;
                }
            }, true);
        }
        bKX();
        this.mww.stopTimer();
        this.mww.startTimer(500);
        AppMethodBeat.o(6319);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJA() {
        AppMethodBeat.i(6320);
        if (this.mww != null) {
            this.mww.stopTimer();
        }
        AppMethodBeat.o(6320);
    }

    private boolean bKX() {
        int i2;
        AppMethodBeat.i(6321);
        if (this.mDm == null) {
            Log.i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.o(6321);
            return false;
        }
        int bJh = this.mDm.bJh();
        int bJi = this.mDm.bJi();
        if (bJh < 0 || bJi < 0) {
            AppMethodBeat.o(6321);
            return false;
        }
        if (bJh > bJi) {
            bJh = bJi;
        }
        int barLen = getBarLen();
        if (barLen <= 0) {
            AppMethodBeat.o(6321);
            return true;
        }
        if (bJi == 0) {
            i2 = 0;
        } else {
            i2 = (int) (((((double) bJh) * 1.0d) / ((double) bJi)) * ((double) barLen));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mDf.getLayoutParams();
        layoutParams.width = i2;
        this.mDf.setLayoutParams(layoutParams);
        AppMethodBeat.o(6321);
        return true;
    }

    private void crJ() {
        boolean z;
        AppMethodBeat.i(6322);
        if (Util.isNullOrNil(this.pOv)) {
            AppMethodBeat.o(6322);
            return;
        }
        Iterator<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> it = this.pOv.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c next = it.next();
            if (next.pKt <= ((double) this.mPosition)) {
                if (!next.pKr) {
                    z2 = true;
                }
                z = z2;
            } else {
                if (next.pKr) {
                    z = true;
                }
                z = z2;
            }
            z2 = z;
        }
        if (z2) {
            N(this.pOv);
        }
        AppMethodBeat.o(6322);
    }

    public final void N(final LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> linkedList) {
        AppMethodBeat.i(6323);
        this.pOv = linkedList;
        if (this.pOu == null || Util.isNullOrNil(this.pOv)) {
            this.pOu.removeAllViews();
            AppMethodBeat.o(6323);
            return;
        }
        Log.i("MicroMsg.MPVideoViewControlBar", "updateControlBarDotPos");
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(195072);
                MPVideoViewControlBar.this.pOu.removeAllViews();
                LinkedList linkedList = linkedList;
                if (!Util.isNullOrNil(linkedList)) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ImageView imageView = new ImageView(MPVideoViewControlBar.this.getContext());
                        MPVideoViewControlBar.this.pOu.addView(imageView);
                        if (!MPVideoViewControlBar.a(MPVideoViewControlBar.this, imageView, (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c) it.next())) {
                            MPVideoViewControlBar.this.pOu.removeView(imageView);
                        }
                    }
                }
                AppMethodBeat.o(195072);
            }
        }, 100);
        AppMethodBeat.o(6323);
    }

    public final void a(LinkedList<gh> linkedList, gh ghVar) {
        AppMethodBeat.i(6324);
        if (linkedList == null || ghVar == null) {
            AppMethodBeat.o(6324);
            return;
        }
        this.pOL.clear();
        HashSet hashSet = new HashSet();
        Iterator<gh> it = linkedList.iterator();
        while (it.hasNext()) {
            gh next = it.next();
            if (!Util.isNullOrNil(next.KKh) && !hashSet.contains(Integer.valueOf(next.KKg))) {
                this.pOL.add(next);
                hashSet.add(Integer.valueOf(next.KKg));
            }
        }
        Collections.sort(this.pOL, new Comparator<gh>() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass11 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(gh ghVar, gh ghVar2) {
                return ghVar.KKg - ghVar2.KKg;
            }
        });
        this.pOM = ghVar;
        AppMethodBeat.o(6324);
    }

    private void crK() {
        AppMethodBeat.i(6325);
        if (!crI() || Util.isNullOrNil(this.pOL) || this.pOM == null) {
            crL();
            this.pOA.setVisibility(8);
            AppMethodBeat.o(6325);
            return;
        }
        this.pOz.setText(this.pOM.KKh);
        this.pOA.setVisibility(0);
        this.pOA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(6284);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (MPVideoViewControlBar.this.pOB.getVisibility() == 0) {
                    MPVideoViewControlBar.d(MPVideoViewControlBar.this);
                    if (MPVideoViewControlBar.this.cEF()) {
                        MPVideoViewControlBar.this.bJB();
                    }
                } else {
                    if (MPVideoViewControlBar.this.pOF != null) {
                        MPVideoViewControlBar.this.pOF.cqH();
                    }
                    MPVideoViewControlBar.i(MPVideoViewControlBar.this);
                    MPVideoViewControlBar.j(MPVideoViewControlBar.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(6284);
            }
        });
        AppMethodBeat.o(6325);
    }

    public void setSwitchResolutionListener(a aVar) {
        this.pOF = aVar;
    }

    private void crL() {
        AppMethodBeat.i(6326);
        Log.d("MicroMsg.MPVideoViewControlBar", "hideResolutionContainer");
        if (this.pOB.getVisibility() != 8) {
            this.pOB.setVisibility(8);
            if (this.pOF != null) {
                this.pOF.cqI();
            }
        }
        AppMethodBeat.o(6326);
    }

    private void crM() {
        String str;
        AppMethodBeat.i(179005);
        boolean z = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_native_video_speed, 1) == 0;
        if (!crI() || Util.isNullOrNil(this.pOL) || this.pOM == null || z) {
            crN();
            this.pOD.setVisibility(8);
            AppMethodBeat.o(179005);
            return;
        }
        c cVar = c.pNP;
        if (c.cry().pNW == 1.0f) {
            str = getResources().getString(R.string.hx9);
        } else {
            c cVar2 = c.pNP;
            str = c.cry().desc;
        }
        this.pOC.setText(str);
        this.pOD.setVisibility(0);
        this.pOD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(179004);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m.DR(42);
                if (MPVideoViewControlBar.this.pOE.getVisibility() == 0) {
                    MPVideoViewControlBar.e(MPVideoViewControlBar.this);
                    if (MPVideoViewControlBar.this.cEF()) {
                        MPVideoViewControlBar.this.bJB();
                    }
                } else {
                    if (MPVideoViewControlBar.this.pOG != null) {
                        MPVideoViewControlBar.this.pOG.crF();
                    }
                    MPVideoViewControlBar.m(MPVideoViewControlBar.this);
                    MPVideoViewControlBar.n(MPVideoViewControlBar.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(179004);
            }
        });
        AppMethodBeat.o(179005);
    }

    public void setSwitchSpeedListener(b bVar) {
        this.pOG = bVar;
    }

    private void crN() {
        AppMethodBeat.i(179006);
        Log.d("MicroMsg.MPVideoViewControlBar", "hideSpeedContainer");
        if (this.pOE.getVisibility() != 8) {
            this.pOE.setVisibility(8);
            if (this.pOG != null) {
                this.pOG.crG();
            }
        }
        AppMethodBeat.o(179006);
    }

    private void crO() {
        AppMethodBeat.i(179007);
        this.mDh.setVisibility(this.mDo ? 8 : 0);
        AppMethodBeat.o(179007);
    }

    private void crP() {
        AppMethodBeat.i(179008);
        ViewGroup.LayoutParams layoutParams = this.mCP.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.adn);
        if (this.mDo) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.adm);
        }
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = dimensionPixelSize;
        this.mCP.setLayoutParams(layoutParams);
        AppMethodBeat.o(179008);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.sight.decode.ui.a, com.tencent.mm.plugin.appbrand.jsapi.video.e.a, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public final void seek(int i2) {
        AppMethodBeat.i(6327);
        super.seek(i2);
        em(this.mPosition, this.mCS);
        AppMethodBeat.o(6327);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public final void bKO() {
        AppMethodBeat.i(6328);
        if (this.mCS == 0) {
            AppMethodBeat.o(6328);
        } else if (this.mbo) {
            AppMethodBeat.o(6328);
        } else if (this.mCO == null) {
            AppMethodBeat.o(6328);
        } else {
            this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
            if (getBarLen() == 0) {
                AppMethodBeat.o(6328);
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCO.getLayoutParams();
            int barLen = getBarLen();
            layoutParams.leftMargin = en(this.mPosition, barLen);
            this.mCO.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCM.getLayoutParams();
            layoutParams2.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.mCS)) * ((double) barLen));
            this.mCM.setLayoutParams(layoutParams2);
            requestLayout();
            em(this.mPosition, this.mCS);
            AppMethodBeat.o(6328);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.i(6329);
        this.mDq = z;
        bKS();
        bKP();
        AppMethodBeat.o(6329);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.i(6330);
        this.mDt = z;
        bKQ();
        AppMethodBeat.o(6330);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowProgress(boolean z) {
        AppMethodBeat.i(6331);
        this.mDr = z;
        bKY();
        AppMethodBeat.o(6331);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJD() {
        AppMethodBeat.i(6332);
        if (this.mDg == null) {
            AppMethodBeat.o(6332);
            return false;
        } else if (getVisibility() == 0 && this.mDg.getVisibility() == 0) {
            AppMethodBeat.o(6332);
            return true;
        } else {
            AppMethodBeat.o(6332);
            return false;
        }
    }

    private void bKY() {
        boolean z;
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(6333);
        if (this.mDs) {
            z = this.mDr;
        } else {
            z = false;
        }
        FrameLayout frameLayout = this.mDg;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        TextView textView = this.mCQ;
        if (z) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        TextView textView2 = this.mCR;
        if (!z) {
            i4 = 8;
        }
        textView2.setVisibility(i4);
        AppMethodBeat.o(6333);
    }

    private void em(int i2, int i3) {
        AppMethodBeat.i(6334);
        if (this.mDw != null) {
            this.mDw.onProgressChanged(i2, i3);
        }
        crJ();
        AppMethodBeat.o(6334);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(6335);
        super.setVisibility(i2);
        if (i2 == 0) {
            if (this.pON != null) {
                this.pON.onVisibilityChanged(true);
                AppMethodBeat.o(6335);
                return;
            }
        } else if ((i2 == 8 || i2 == 4) && this.pON != null) {
            this.pON.onVisibilityChanged(false);
        }
        AppMethodBeat.o(6335);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setOnUpdateProgressLenListener(e.AbstractC0717e eVar) {
        this.mDw = eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void a(e.f fVar) {
        this.pON = fVar;
    }

    private void bKP() {
        AppMethodBeat.i(6298);
        if (this.mDo) {
            this.mDk.setVisibility(0);
            this.pOw.setVisibility(0);
            AppMethodBeat.o(6298);
            return;
        }
        this.mDk.setVisibility(8);
        this.pOw.setVisibility(8);
        AppMethodBeat.o(6298);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void hide() {
        AppMethodBeat.i(6309);
        if (this.pOI == null) {
            this.pOI = AnimationUtils.loadAnimation(getContext(), R.anim.f6do);
            this.pOI.setDuration(300);
        }
        this.mDe.clearAnimation();
        this.mDe.startAnimation(this.pOI);
        if (this.mDo) {
            if (this.pOK == null) {
                this.pOK = AnimationUtils.loadAnimation(getContext(), R.anim.dr);
                this.pOK.setDuration(300);
            }
            this.mDk.clearAnimation();
            this.mDk.startAnimation(this.pOK);
            this.pOw.clearAnimation();
            this.pOw.startAnimation(this.pOK);
        }
        if (this.pOB.getVisibility() == 0) {
            this.pOB.startAnimation(this.pOI);
        }
        if (this.pOE.getVisibility() == 0) {
            this.pOE.startAnimation(this.pOI);
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(195070);
                MPVideoViewControlBar.this.setVisibility(8);
                MPVideoViewControlBar.d(MPVideoViewControlBar.this);
                MPVideoViewControlBar.e(MPVideoViewControlBar.this);
                MPVideoViewControlBar.this.pOB.clearAnimation();
                AppMethodBeat.o(195070);
            }
        }, 200);
        AppMethodBeat.o(6309);
    }

    private boolean crI() {
        return this.mDo && (90 == this.add || -90 == this.add);
    }

    static /* synthetic */ boolean a(MPVideoViewControlBar mPVideoViewControlBar, ImageView imageView, com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar) {
        AppMethodBeat.i(179011);
        if (mPVideoViewControlBar.mDm == null || cVar == null) {
            Log.i("MicroMsg.MPVideoViewControlBar", "updateBarDotPos mStatePorter null");
            AppMethodBeat.o(179011);
            return false;
        }
        double d2 = cVar.pKt;
        double d3 = cVar.pKu;
        int bJi = mPVideoViewControlBar.mDm.bJi();
        if (d2 < 0.0d || bJi <= 0 || d2 > ((double) bJi) || d2 > d3) {
            AppMethodBeat.o(179011);
            return false;
        }
        int barLen = mPVideoViewControlBar.getBarLen();
        if (barLen <= 0) {
            AppMethodBeat.o(179011);
            return false;
        }
        Log.d("MicroMsg.MPVideoViewControlBar", "updateDotViewParams width = %d", Integer.valueOf(barLen));
        int i2 = (int) (((double) barLen) * ((1.0d * d2) / ((double) bJi)));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = com.tencent.mm.cb.a.fromDPToPix(mPVideoViewControlBar.getContext(), 3);
        layoutParams.height = -1;
        layoutParams.leftMargin = i2;
        imageView.setLayoutParams(layoutParams);
        if (d2 <= ((double) mPVideoViewControlBar.mPosition)) {
            cVar.pKr = true;
            imageView.setImageResource(R.drawable.b1i);
        } else {
            cVar.pKr = false;
            imageView.setImageResource(R.drawable.b1j);
        }
        AppMethodBeat.o(179011);
        return true;
    }

    static /* synthetic */ void i(MPVideoViewControlBar mPVideoViewControlBar) {
        AppMethodBeat.i(6340);
        Log.d("MicroMsg.MPVideoViewControlBar", "showResolutionContainer");
        if (mPVideoViewControlBar.pOB.getVisibility() != 0) {
            mPVideoViewControlBar.pOB.setVisibility(0);
        }
        mPVideoViewControlBar.pOE.setVisibility(8);
        AppMethodBeat.o(6340);
    }

    static /* synthetic */ void j(MPVideoViewControlBar mPVideoViewControlBar) {
        AppMethodBeat.i(179012);
        mPVideoViewControlBar.pOB.removeAllViews();
        Iterator<gh> it = mPVideoViewControlBar.pOL.iterator();
        while (it.hasNext()) {
            final gh next = it.next();
            TextView textView = new TextView(mPVideoViewControlBar.getContext());
            mPVideoViewControlBar.pOB.addView(textView);
            final boolean isEqual = Util.isEqual(next.url, mPVideoViewControlBar.pOM.url);
            textView.setText(next.KKh);
            textView.setTextSize(0, (float) mPVideoViewControlBar.getResources().getDimensionPixelSize(R.dimen.is));
            if (isEqual) {
                textView.setTextColor(com.tencent.mm.cb.a.m(mPVideoViewControlBar.getContext(), R.color.tv));
            } else {
                textView.setTextColor(com.tencent.mm.cb.a.m(mPVideoViewControlBar.getContext(), R.color.ag5));
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            textView.setWidth(com.tencent.mm.cb.a.fromDPToPix(mPVideoViewControlBar.getContext(), 108));
            textView.setHeight(com.tencent.mm.cb.a.fromDPToPix(mPVideoViewControlBar.getContext(), 52));
            textView.setGravity(17);
            layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(mPVideoViewControlBar.getContext(), 4);
            layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(mPVideoViewControlBar.getContext(), 4);
            textView.setLayoutParams(layoutParams);
            textView.setBackgroundResource(R.drawable.j_);
            textView.getPaint().setFakeBoldText(true);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(179003);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (isEqual) {
                        MPVideoViewControlBar.this.bJB();
                        MPVideoViewControlBar.d(MPVideoViewControlBar.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(179003);
                        return;
                    }
                    MPVideoViewControlBar.a(MPVideoViewControlBar.this, next);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(179003);
                }
            });
        }
        AppMethodBeat.o(179012);
    }

    static /* synthetic */ void a(MPVideoViewControlBar mPVideoViewControlBar, gh ghVar) {
        AppMethodBeat.i(179013);
        if (mPVideoViewControlBar.pOF != null) {
            mPVideoViewControlBar.pOF.a(ghVar, mPVideoViewControlBar.pOM.KKg, ghVar.KKg);
        }
        mPVideoViewControlBar.pOM = ghVar;
        mPVideoViewControlBar.bJB();
        mPVideoViewControlBar.crK();
        k.DP(ghVar.KKg);
        AppMethodBeat.o(179013);
    }

    static /* synthetic */ void m(MPVideoViewControlBar mPVideoViewControlBar) {
        AppMethodBeat.i(179014);
        Log.d("MicroMsg.MPVideoViewControlBar", "showSpeedContainer");
        if (mPVideoViewControlBar.pOE.getVisibility() != 0) {
            mPVideoViewControlBar.pOE.setVisibility(0);
        }
        mPVideoViewControlBar.pOB.setVisibility(8);
        AppMethodBeat.o(179014);
    }

    static /* synthetic */ void n(MPVideoViewControlBar mPVideoViewControlBar) {
        AppMethodBeat.i(179015);
        mPVideoViewControlBar.pOE.removeAllViews();
        for (final c.a aVar : c.a.pNX) {
            TextView textView = new TextView(mPVideoViewControlBar.getContext());
            mPVideoViewControlBar.pOE.addView(textView);
            Float valueOf = Float.valueOf(aVar.pNW);
            c cVar = c.pNP;
            final boolean isEqual = Util.isEqual(valueOf, Float.valueOf(c.cry().pNW));
            textView.setText(aVar.desc);
            textView.setTextSize(0, (float) mPVideoViewControlBar.getResources().getDimensionPixelSize(R.dimen.is));
            if (isEqual) {
                textView.setTextColor(com.tencent.mm.cb.a.m(mPVideoViewControlBar.getContext(), R.color.tv));
            } else {
                textView.setTextColor(com.tencent.mm.cb.a.m(mPVideoViewControlBar.getContext(), R.color.ag5));
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            textView.setWidth(com.tencent.mm.cb.a.fromDPToPix(mPVideoViewControlBar.getContext(), 108));
            textView.setHeight(com.tencent.mm.cb.a.fromDPToPix(mPVideoViewControlBar.getContext(), 52));
            textView.setGravity(17);
            layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(mPVideoViewControlBar.getContext(), 4);
            layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(mPVideoViewControlBar.getContext(), 4);
            textView.setLayoutParams(layoutParams);
            textView.setBackgroundResource(R.drawable.j_);
            textView.getPaint().setFakeBoldText(true);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(195067);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (isEqual) {
                        MPVideoViewControlBar.this.bJB();
                        MPVideoViewControlBar.e(MPVideoViewControlBar.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(195067);
                        return;
                    }
                    MPVideoViewControlBar.a(MPVideoViewControlBar.this, aVar);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(195067);
                }
            });
        }
        AppMethodBeat.o(179015);
    }

    static /* synthetic */ void a(MPVideoViewControlBar mPVideoViewControlBar, c.a aVar) {
        AppMethodBeat.i(179016);
        Log.i("MicroMsg.MPVideoViewControlBar", "[onSpeedChange] speed = %s", aVar.desc);
        c cVar = c.pNP;
        c.a cry = c.cry();
        c cVar2 = c.pNP;
        c.a(aVar);
        m.DR(43);
        if (mPVideoViewControlBar.pOG != null) {
            mPVideoViewControlBar.pOG.a(mPVideoViewControlBar.pOM, cry, aVar);
        }
        mPVideoViewControlBar.bJB();
        mPVideoViewControlBar.crM();
        AppMethodBeat.o(179016);
    }
}
