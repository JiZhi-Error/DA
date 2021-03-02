package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.scanner.api.d;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a;
import com.tencent.mm.plugin.scanner.word.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsInfoFlip;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.util.List;

public abstract class SnsBaseGalleryUI extends MMActivity implements a.AbstractC1683a<String, b>, c.b, SnsInfoFlip.b, w.a {
    private boolean CSQ = true;
    private LinearLayout EAc;
    v EAd;
    private LinearLayout EAe;
    w EAf;
    boolean EAg = true;
    private TextView EAh = null;
    protected SnsInfoFlip EAi;
    protected Button EAj;
    private int EAk = -1;
    private long EAl = 0;
    private com.tencent.mm.plugin.scanner.api.a.a EAm = null;
    private com.tencent.mm.plugin.scanner.api.a.b EAn = ((com.tencent.mm.plugin.scanner.api.b) g.af(com.tencent.mm.plugin.scanner.api.b.class)).eOT();
    private com.tencent.mm.plugin.scanner.api.a.c EAo = new com.tencent.mm.plugin.scanner.api.a.c() {
        /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.scanner.api.a.c
        public final void eOW() {
            AppMethodBeat.i(203488);
            SnsBaseGalleryUI.b(SnsBaseGalleryUI.this);
            AppMethodBeat.o(203488);
        }

        @Override // com.tencent.mm.plugin.scanner.api.a.c
        public final void eOZ() {
            AppMethodBeat.i(203489);
            SnsBaseGalleryUI.this.fhA();
            SnsBaseGalleryUI.this.cWj();
            AppMethodBeat.o(203489);
        }

        @Override // com.tencent.mm.plugin.scanner.api.a.c
        public final void eOY() {
            AppMethodBeat.i(203490);
            SnsBaseGalleryUI.this.fhA();
            AppMethodBeat.o(203490);
        }

        @Override // com.tencent.mm.plugin.scanner.api.a.c
        public final void eOX() {
            AppMethodBeat.i(203491);
            SnsBaseGalleryUI.b(SnsBaseGalleryUI.this);
            SnsBaseGalleryUI snsBaseGalleryUI = SnsBaseGalleryUI.this;
            snsBaseGalleryUI.EAg = false;
            snsBaseGalleryUI.setTitleVisibility(8);
            if (snsBaseGalleryUI.EAd != null) {
                snsBaseGalleryUI.EAd.setVisibility(8);
            }
            SnsBaseGalleryUI.this.cWj();
            AppMethodBeat.o(203491);
        }
    };
    private IListener<wj> EAp = new IListener<wj>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass10 */

        {
            AppMethodBeat.i(203499);
            this.__eventId = wj.class.getName().hashCode();
            AppMethodBeat.o(203499);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wj wjVar) {
            AppMethodBeat.i(203500);
            wj wjVar2 = wjVar;
            cnb cntMedia = SnsBaseGalleryUI.this.EAi.getCntMedia();
            if (cntMedia != null && wjVar2.ecv.mediaId.equals(cntMedia.Id)) {
                SnsBaseGalleryUI.a(SnsBaseGalleryUI.this, com.tencent.mm.plugin.sns.model.g.D(cntMedia));
            }
            AppMethodBeat.o(203500);
            return true;
        }
    };
    private IListener<vw> EAq = new IListener<vw>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass11 */

        {
            AppMethodBeat.i(203501);
            this.__eventId = vw.class.getName().hashCode();
            AppMethodBeat.o(203501);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vw vwVar) {
            AppMethodBeat.i(203502);
            vw vwVar2 = vwVar;
            cnb cntMedia = SnsBaseGalleryUI.this.EAi.getCntMedia();
            if (cntMedia != null && vwVar2.ebW.mediaId.equals(cntMedia.Id)) {
                SnsBaseGalleryUI.a(SnsBaseGalleryUI.this, com.tencent.mm.plugin.sns.model.g.D(cntMedia), vwVar2.ebW.dkU);
            }
            AppMethodBeat.o(203502);
            return true;
        }
    };
    private FlipView.b Eqw = new FlipView.b() {
        /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.sns.ui.FlipView.b
        public final void ha(List<Integer> list) {
            AppMethodBeat.i(203481);
            if (list != null && list.contains(9)) {
                SnsBaseGalleryUI.this.EAn.hY(2, SnsBaseGalleryUI.this.fhE());
            }
            AppMethodBeat.o(203481);
        }

        @Override // com.tencent.mm.plugin.sns.ui.FlipView.b
        public final void ffI() {
            AppMethodBeat.i(203482);
            SnsBaseGalleryUI.this.EAn.reset();
            AppMethodBeat.o(203482);
        }
    };
    private a tgL;
    int tgM = 0;
    private int tgN = 0;
    private ImageView tgP;
    private ImageView tgQ;
    private ImageView tgR;
    private ValueAnimator tgS;
    private IListener<tp> tgT = new IListener<tp>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass2 */

        {
            AppMethodBeat.i(203484);
            this.__eventId = tp.class.getName().hashCode();
            AppMethodBeat.o(203484);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tp tpVar) {
            AppMethodBeat.i(203485);
            final tp tpVar2 = tpVar;
            Log.i("MicroMsg.SnsBaseGalleryUI", "scanTranslationResult %d, %s", Integer.valueOf(tpVar2.dZZ.dEb), Boolean.valueOf(tpVar2.dZZ.dDz));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(203483);
                    if (SnsBaseGalleryUI.this.tgM == tpVar2.dZZ.dEb) {
                        SnsBaseGalleryUI.this.cWh();
                        if (tpVar2.dZZ.dDz) {
                            if (s.YS(tpVar2.dZZ.eaa)) {
                                String D = com.tencent.mm.plugin.sns.model.g.D(SnsBaseGalleryUI.this.EAi.getCntMedia());
                                Intent intent = new Intent();
                                intent.putExtra("original_file_path", D);
                                intent.putExtra("translate_source", tpVar2.dZZ.source);
                                if (SnsBaseGalleryUI.this.getIntent().hasExtra("sns_gallery_thumb_location")) {
                                    intent.putExtra("thumb_location", SnsBaseGalleryUI.this.getIntent().getParcelableExtra("sns_gallery_thumb_location"));
                                }
                                cnb cntMedia = SnsBaseGalleryUI.this.EAi.getCntMedia();
                                if (cntMedia != null) {
                                    intent.putExtra("fileid", cntMedia.Url);
                                }
                                SnsBaseGalleryUI.this.startActivity((SnsBaseGalleryUI) TranslationResultUI.class, (Class) intent);
                                if (SnsBaseGalleryUI.this.fhF()) {
                                    SnsBaseGalleryUI.this.finish();
                                }
                                SnsBaseGalleryUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                                AppMethodBeat.o(203483);
                                return;
                            }
                            Log.w("MicroMsg.SnsBaseGalleryUI", "trans result path %s not exist!", tpVar2.dZZ.eaa);
                        }
                        SnsBaseGalleryUI.this.tgM = 0;
                        h.a((Context) SnsBaseGalleryUI.this, SnsBaseGalleryUI.this.getString(R.string.ge4), "", false, (DialogInterface.OnClickListener) null);
                    }
                    AppMethodBeat.o(203483);
                }
            });
            AppMethodBeat.o(203485);
            return true;
        }
    };
    private p tgU = new p.a() {
        /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass3 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(203487);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass3.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(203486);
                    if (!(g.azz().aYS() == 6 || g.azz().aYS() == 4 || SnsBaseGalleryUI.this.tgN != 1)) {
                        h.c(SnsBaseGalleryUI.this, SnsBaseGalleryUI.this.getString(R.string.x3), "", true);
                        SnsBaseGalleryUI.this.cWh();
                    }
                    AppMethodBeat.o(203486);
                }
            });
            AppMethodBeat.o(203487);
        }
    };
    private MMViewPager xqs;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SnsBaseGalleryUI snsBaseGalleryUI, String str) {
        snsBaseGalleryUI.tgM = (int) (((long) z.aTY().hashCode()) + System.currentTimeMillis());
        fx translationResult = ((e) g.ah(e.class)).getTranslationResult(str);
        if (translationResult == null || !s.YS(translationResult.field_resultFile)) {
            if (g.azz().aYS() == 6 || g.azz().aYS() == 4) {
                snsBaseGalleryUI.EAi.setEnableSingleClickOver(true);
                snsBaseGalleryUI.tgN = 1;
                snsBaseGalleryUI.cWi();
            } else {
                h.c(snsBaseGalleryUI, snsBaseGalleryUI.getString(R.string.x3), "", true);
                snsBaseGalleryUI.cWh();
            }
            Log.i("MicroMsg.SnsBaseGalleryUI", "try to translate img %s, sessionId %d", str, Integer.valueOf(snsBaseGalleryUI.tgM));
            to toVar = new to();
            toVar.dZY.scene = snsBaseGalleryUI.fhD();
            toVar.dZY.filePath = str;
            toVar.dZY.dEb = snsBaseGalleryUI.tgM;
            EventCenter.instance.publish(toVar);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("original_file_path", str);
        intent.putExtra("translate_source", com.tencent.mm.plugin.scanner.a.Wo(snsBaseGalleryUI.fhD()));
        if (snsBaseGalleryUI.getIntent().hasExtra("sns_gallery_thumb_location")) {
            intent.putExtra("thumb_location", snsBaseGalleryUI.getIntent().getParcelableExtra("sns_gallery_thumb_location"));
        }
        cnb cntMedia = snsBaseGalleryUI.EAi.getCntMedia();
        if (cntMedia != null) {
            intent.putExtra("fileid", cntMedia.Url);
        }
        snsBaseGalleryUI.startActivity(TranslationResultUI.class, intent);
        if (snsBaseGalleryUI.fhF()) {
            snsBaseGalleryUI.finish();
        }
        snsBaseGalleryUI.overridePendingTransition(R.anim.s, R.anim.s);
    }

    static /* synthetic */ void a(SnsBaseGalleryUI snsBaseGalleryUI, String str, String str2) {
        if (snsBaseGalleryUI.xqs == null) {
            snsBaseGalleryUI.xqs = snsBaseGalleryUI.EAi.getGallery();
            if (snsBaseGalleryUI.xqs != null) {
                snsBaseGalleryUI.xqs.setDoubleClickListener(new MMViewPager.a() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass6 */

                    {
                        AppMethodBeat.i(160707);
                        AppMethodBeat.o(160707);
                    }

                    @Override // com.tencent.mm.ui.base.MMViewPager.a
                    public final boolean ab(MotionEvent motionEvent) {
                        AppMethodBeat.i(203493);
                        if (SnsBaseGalleryUI.this.EAm != null) {
                            boolean onDoubleTap = SnsBaseGalleryUI.this.EAm.onDoubleTap(motionEvent);
                            AppMethodBeat.o(203493);
                            return onDoubleTap;
                        }
                        AppMethodBeat.o(203493);
                        return false;
                    }
                });
            }
        }
        if (snsBaseGalleryUI.EAm == null) {
            snsBaseGalleryUI.EAm = ((com.tencent.mm.plugin.scanner.api.c) g.af(com.tencent.mm.plugin.scanner.api.c.class)).gT(snsBaseGalleryUI);
            snsBaseGalleryUI.EAm.eN(snsBaseGalleryUI.xqs);
        }
        com.tencent.mm.plugin.scanner.api.e eVar = new com.tencent.mm.plugin.scanner.api.e();
        eVar.imagePath = str;
        eVar.sessionId = System.currentTimeMillis();
        eVar.CAT = 3;
        eVar.CAX = false;
        eVar.efT = false;
        if (snsBaseGalleryUI instanceof SnsGalleryUI) {
            eVar.source = 203;
        } else {
            eVar.source = 202;
        }
        eVar.CAY.CAZ = str2;
        Log.d("MicroMsg.SnsBaseGalleryUI", "alvinluo doOCRImage imagePath: %s, sourceUsername: %s", eVar.imagePath, eVar.CAY.CAZ);
        snsBaseGalleryUI.cWi();
        snsBaseGalleryUI.EAm.eO(snsBaseGalleryUI.EAi.getCurrentImageView());
        d dVar = new d();
        dVar.CAK = snsBaseGalleryUI instanceof SnsBrowseUI;
        dVar.CAL = true;
        snsBaseGalleryUI.EAn.hY(1, snsBaseGalleryUI.fhE());
        snsBaseGalleryUI.EAl = snsBaseGalleryUI.EAm.a(eVar, dVar, snsBaseGalleryUI.EAo);
    }

    static /* synthetic */ void b(SnsBaseGalleryUI snsBaseGalleryUI) {
        if (snsBaseGalleryUI.EAi != null) {
            snsBaseGalleryUI.EAi.setEnableSingleClickOver(false);
            snsBaseGalleryUI.EAi.setShowLongClickMenu(false);
        }
        if (snsBaseGalleryUI.xqs != null) {
            snsBaseGalleryUI.xqs.setEnableGalleryScale(false);
            snsBaseGalleryUI.xqs.setSingleMode(true);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.tencent.mm.plugin.scanner.word.a.AbstractC1683a
    public final /* synthetic */ void M(String str, b bVar) {
        cnb cnb;
        boolean z;
        boolean z2;
        boolean z3;
        String str2 = null;
        boolean z4 = true;
        String str3 = str;
        b bVar2 = bVar;
        if (this.EAi == null || this.EAi.getSelectItem() == null) {
            cnb = null;
        } else {
            cnb = this.EAi.getSelectItem().ebR;
        }
        if (cnb != null) {
            str2 = com.tencent.mm.plugin.sns.model.g.D(cnb);
        }
        int gw = i.gw(bVar2.CVF);
        Log.i("MicroMsg.SnsBaseGalleryUI", "local translate, img %s, result %s, ratio %d", str2, bVar2.CVF, Integer.valueOf(gw));
        if (str3.equals(str2)) {
            if (gw > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.EAi.setNeedTranslationImg(true);
                z2 = true;
            } else {
                z2 = false;
            }
            if (((com.tencent.mm.plugin.scanner.api.c) g.af(com.tencent.mm.plugin.scanner.api.c.class)).gy(bVar2.CVF)) {
                this.EAi.setNeedOCRImg(true);
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 || z3) {
                SnsInfoFlip snsInfoFlip = this.EAi;
                if (snsInfoFlip.oXS == null || !snsInfoFlip.oXS.isShowing()) {
                    z4 = false;
                }
                if (z4) {
                    this.EAi.bEq();
                }
            }
            ap(z2, z3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fhA() {
        if (this.EAi != null) {
            this.EAi.setEnableSingleClickOver(true);
            this.EAi.setShowLongClickMenu(true);
        }
        if (this.xqs != null) {
            this.xqs.setEnableGalleryScale(true);
            this.xqs.setSingleMode(false);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aj.faJ().aO(3, true);
        this.EAc = (LinearLayout) findViewById(R.id.e9u);
        this.EAe = (LinearLayout) findViewById(R.id.be9);
        this.EAf = new w(this, this, getFromScene());
        w wVar = this.EAf;
        Log.i("MicroMsg.GalleryTitleManager", "onAttach");
        g.aAi();
        g.aAg().hqi.a(218, wVar);
        EventCenter.instance.addListener(wVar.teF);
        EventCenter.instance.addListener(wVar.Eqy);
        this.EAf.Eqw = new FlipView.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.sns.ui.FlipView.b
            public final void ha(List<Integer> list) {
                AppMethodBeat.i(203497);
                if (list != null && list.contains(11)) {
                    SnsBaseGalleryUI.this.EAn.hY(2, SnsBaseGalleryUI.this.fhE());
                }
                AppMethodBeat.o(203497);
            }

            @Override // com.tencent.mm.plugin.sns.ui.FlipView.b
            public final void ffI() {
                AppMethodBeat.i(203498);
                SnsBaseGalleryUI.this.EAn.reset();
                AppMethodBeat.o(203498);
            }
        };
        if (fhC()) {
            this.tgP = (ImageView) findViewById(R.id.hb2);
            this.tgQ = (ImageView) findViewById(R.id.hb1);
            this.tgR = (ImageView) findViewById(R.id.haz);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tgR.getLayoutParams();
            layoutParams.bottomMargin += ao.aD(this);
            this.tgR.setLayoutParams(layoutParams);
            this.tgR.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass5 */

                {
                    AppMethodBeat.i(160706);
                    AppMethodBeat.o(160706);
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(203492);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    SnsBaseGalleryUI.this.fhB();
                    ay ayVar = new ay();
                    ayVar.dEa.scene = 1;
                    ayVar.dEa.dEb = SnsBaseGalleryUI.this.tgM;
                    EventCenter.instance.publish(ayVar);
                    SnsBaseGalleryUI.this.cWh();
                    SnsBaseGalleryUI.this.tgM = 0;
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203492);
                }
            });
            this.tgP = (ImageView) findViewById(R.id.hb2);
            this.tgS = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.tgS.setDuration(5000L);
            this.tgS.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass7 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(203494);
                    SnsBaseGalleryUI.this.tgP.setAlpha(0.0f);
                    AppMethodBeat.o(203494);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(203495);
                    SnsBaseGalleryUI.this.tgP.setAlpha(0.0f);
                    AppMethodBeat.o(203495);
                }
            });
            final int height = getWindowManager().getDefaultDisplay().getHeight();
            this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.AnonymousClass8 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(203496);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue <= 0.1f) {
                        SnsBaseGalleryUI.this.tgP.setAlpha(floatValue * 10.0f);
                    } else if (floatValue >= 0.9f) {
                        SnsBaseGalleryUI.this.tgP.setAlpha((1.0f - floatValue) * 10.0f);
                    }
                    SnsBaseGalleryUI.this.tgP.setTranslationY(floatValue * ((float) (height - SnsBaseGalleryUI.this.tgP.getHeight())));
                    AppMethodBeat.o(203496);
                }
            });
        }
        aj.faJ().a(this);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (this.EAd != null) {
            this.EAd.refresh();
        }
        if (fhC()) {
            g.aAg().a(this.tgU);
            EventCenter.instance.addListener(this.EAp);
            EventCenter.instance.addListener(this.tgT);
            EventCenter.instance.addListener(this.EAq);
        }
        if (this.EAi != null) {
            this.EAi.setOnMenuShowListener(this.Eqw);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        Log.i("MicroMsg.SnsBaseGalleryUI", "onBackPressed");
        if (fhB()) {
            this.EAl = 0;
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.EAm != null) {
            this.EAm.onConfigurationChanged(configuration);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean fhB() {
        fhA();
        if (this.EAm == null || !this.EAm.It(this.EAl)) {
            return false;
        }
        return true;
    }

    public void addView(View view) {
        this.EAc.addView(view, new LinearLayout.LayoutParams(-1, -1));
    }

    @SuppressLint({"ResourceAsColor"})
    public final void X(boolean z, int i2) {
        this.EAd = new v(this, i2, z);
        this.EAd.setBackgroundColor(R.color.ac_);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.EAd.getBackground().setAlpha(50);
        this.EAe.addView(this.EAd, layoutParams);
        this.EAd.setSnsSource(getIntent().getIntExtra("sns_source", 0));
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.EAf != null) {
            w wVar = this.EAf;
            Log.i("MicroMsg.GalleryTitleManager", "onDetach");
            g.aAi();
            g.aAg().hqi.b(218, wVar);
            EventCenter.instance.removeListener(wVar.teF);
            EventCenter.instance.removeListener(wVar.Eqy);
        }
        if (this.EAi != null) {
            this.EAi.xqs.OTV.removeMessages(1);
            SnsInfoFlip snsInfoFlip = this.EAi;
            Log.i("MicroMsg.SnsInfoFlip", "sns info flip on detach.");
            if (snsInfoFlip.EDX != null) {
                snsInfoFlip.EDX.fij();
                snsInfoFlip.EDX.clear();
            }
            aj.faJ().b(snsInfoFlip);
            this.EAi.onDestroy();
        }
        if (fhC()) {
            cWh();
        }
        g.aAg().b(this.tgU);
        EventCenter.instance.removeListener(this.tgT);
        aj.faJ().b(this);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bvx;
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a
    public void fI(String str, int i2) {
        if (this.CSQ && !aj.isInValid()) {
            SnsInfo aQm = aj.faO().aQm(str);
            if (aQm == null || aQm.field_snsId == 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean fhC() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int fhD() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public int fhE() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public void ap(boolean z, boolean z2) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.SnsInfoFlip.b
    public void a(cnb cnb, int i2, String str) {
        if (cnb.oUv != 2 || !i.eOP() || !fhC()) {
            this.EAi.setNeedTranslationImg(false);
            this.EAi.setNeedOCRImg(false);
        } else {
            if (i2 != this.EAk) {
                this.EAi.setNeedTranslationImg(false);
                this.EAi.setNeedOCRImg(false);
                this.tgM = 0;
            }
            this.EAk = i2;
            if (this.tgL == null) {
                this.tgL = new ImageWordScanDetailEngine(this);
            }
            SnsInfo aQm = aj.faO().aQm(str);
            if (aQm != null && !aQm.isWaitPost()) {
                String D = com.tencent.mm.plugin.sns.model.g.D(cnb);
                if (!Util.isNullOrNil(D)) {
                    this.tgL.a(D, this);
                }
            }
        }
        if (this.EAf != null) {
            w wVar = this.EAf;
            wVar.Era = false;
            wVar.Erb = false;
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void aOG(String str) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void ci(String str, boolean z) {
        if (i.eOP() && fhC() && z && !Util.isNullOrNil(str) && str.equals(this.EAi.getSelectedMediaId())) {
            if (this.tgL == null) {
                this.tgL = new ImageWordScanDetailEngine(this);
            }
            String D = com.tencent.mm.plugin.sns.model.g.D(this.EAi.getCntMedia());
            if (!Util.isNullOrNil(D)) {
                this.tgL.a(D, this);
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void eZJ() {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void cj(String str, boolean z) {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean fhF() {
        if (fhD() == 3) {
            return true;
        }
        return false;
    }

    public final void cWh() {
        this.EAi.setEnableSingleClickOver(true);
        this.tgN = 0;
        cWj();
    }

    private void fhG() {
        this.tgP.setVisibility(8);
        this.tgQ.setVisibility(8);
        this.tgR.setVisibility(8);
    }

    private void cWi() {
        this.tgP.setVisibility(0);
        this.tgQ.setVisibility(0);
        this.tgR.setVisibility(0);
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(-1);
        this.tgS.start();
    }

    public final void cWj() {
        fhG();
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(0);
        this.tgS.end();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        if (this.EAi != null) {
            this.EAi.onPause();
        }
        if (this.EAf != null) {
            w wVar = this.EAf;
            if (wVar.Eqn != null) {
                aw awVar = new aw();
                awVar.dDW.activity = (Activity) wVar.context;
                awVar.dDW.dDX = wVar.Eqn;
                EventCenter.instance.publish(awVar);
                wVar.Eqn = null;
                wVar.dFM = 0;
                wVar.dFL = 0;
            }
        }
        super.onPause();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        EventCenter.instance.removeListener(this.EAp);
        EventCenter.instance.removeListener(this.EAq);
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a
    public final void kQ(String str, String str2) {
        if (this.CSQ) {
            setMMTitle(str);
            setMMSubTitle(str2);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a
    public void fH(String str, int i2) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a
    public void ffK() {
        int i2;
        int i3 = 8;
        boolean z = false;
        if (this.CSQ) {
            if (this.EAg) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            setTitleVisibility(i2);
            if (this.EAd != null) {
                v vVar = this.EAd;
                if (!this.EAg) {
                    i3 = 0;
                }
                vVar.setVisibility(i3);
            }
            if (!this.EAg) {
                z = true;
            }
            this.EAg = z;
        }
    }

    public final int getFromScene() {
        return getIntent().getIntExtra("key_from_scene", 0);
    }
}
