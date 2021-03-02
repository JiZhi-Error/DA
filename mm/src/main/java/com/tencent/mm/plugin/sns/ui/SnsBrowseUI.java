package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.is;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.sns.ad.g.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.e;
import java.util.List;

@a(3)
public class SnsBrowseUI extends SnsBaseGalleryUI implements w.a {
    private Rect COM;
    private int EAA;
    private int EAB = 0;
    private float EAC = 1.0f;
    private int EAD = 0;
    private int EAE = 0;
    private int EAu = 0;
    private boolean EAv = false;
    private boolean EAw = false;
    private boolean EAx = false;
    private v EAy;
    private int EAz;
    private String dJX;
    private int dNo = 0;
    private boolean isAnimated = false;
    private ImageView jUG;
    private int mEX = 0;
    private int mEY = 0;
    private MMHandler mHandler = new MMHandler();
    Bundle qaD;
    e qaE;
    private int scene = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsBrowseUI() {
        AppMethodBeat.i(98508);
        AppMethodBeat.o(98508);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98509);
        super.onCreate(bundle);
        hideTitleView();
        ao.bm(this);
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(134218752, 134218752);
            getWindow().addFlags(67108864);
        }
        setLightNavigationbarIcon();
        initView();
        this.qaD = bundle;
        AppMethodBeat.o(98509);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98510);
        if (this.EAi != null) {
            int intExtra = getIntent().getIntExtra("K_ad_scene", -1);
            int intExtra2 = getIntent().getIntExtra("K_ad_source", 0);
            long longExtra = getIntent().getLongExtra("sns_ad_exposure_start_time", 0);
            SnsInfoFlip snsInfoFlip = this.EAi;
            String str = this.dJX;
            if (snsInfoFlip.isAd) {
                if (intExtra < 0) {
                    Log.i("MicroMsg.SnsInfoFlip", "pass by scene ".concat(String.valueOf(intExtra)));
                } else {
                    SnsInfo aQm = aj.faO().aQm(str);
                    if (aQm != null) {
                        if (snsInfoFlip.EAk >= 0) {
                            long longValue = snsInfoFlip.EEb.containsKey(Integer.valueOf(snsInfoFlip.EAk)) ? snsInfoFlip.EEb.get(Integer.valueOf(snsInfoFlip.EAk)).longValue() : 0;
                            if (longValue > 0) {
                                long longValue2 = snsInfoFlip.EEc.containsKey(Integer.valueOf(snsInfoFlip.EAk)) ? snsInfoFlip.EEc.get(Integer.valueOf(snsInfoFlip.EAk)).longValue() : 0;
                                long ticksToNow = Util.ticksToNow(longValue);
                                long j2 = longValue2 + ticksToNow;
                                snsInfoFlip.EEc.put(Integer.valueOf(snsInfoFlip.EAk), Long.valueOf(j2));
                                Log.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + snsInfoFlip.EAk + " curtime " + j2 + " passtime " + ticksToNow);
                            }
                        }
                        AdSnsInfo adSnsInfo = aQm.getAdSnsInfo();
                        if (intExtra2 == 2) {
                            aQm.getAtAdInfo();
                        } else {
                            aQm.getAdInfo();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer.append("<desc>");
                        for (Integer num : snsInfoFlip.EEa.keySet()) {
                            int intValue = snsInfoFlip.EEa.get(num).intValue();
                            int longValue3 = snsInfoFlip.EEc.containsKey(num) ? (int) (snsInfoFlip.EEc.get(num).longValue() * 1) : 0;
                            stringBuffer.append(String.format("<item><id>%d</id><duration>%d</duration><count>%d</count></item>", num, Integer.valueOf(longValue3), Integer.valueOf(intValue)));
                            stringBuffer2.append(String.format("%d|%d|%d", num, Integer.valueOf(longValue3), Integer.valueOf(intValue)) + "&");
                        }
                        stringBuffer.append("</desc>");
                        String stringBuffer3 = stringBuffer2.toString();
                        if (stringBuffer3.endsWith("&")) {
                            stringBuffer3 = stringBuffer3.substring(0, stringBuffer3.length() - 1);
                        }
                        if (aQm == null || !aQm.isRecExpAd()) {
                            aj.faI().a(12014, j.a(aQm.field_snsId, r.Jb(aQm.field_snsId), aQm.getUxinfo(), Integer.valueOf(intExtra), Long.valueOf(snsInfoFlip.EEo), Long.valueOf(System.currentTimeMillis()), stringBuffer3, Integer.valueOf(snsInfoFlip.getCount())));
                        }
                        if (!adSnsInfo.getAdXml().isCardAd()) {
                            SnsAdClick snsAdClick = new SnsAdClick(intExtra2, intExtra2 == 0 ? 1 : 2, aQm.field_snsId, 6, 0);
                            snsAdClick.jlb = longExtra;
                            r.a(snsAdClick);
                        }
                        k tO = k.tO(729);
                        tO.PH(r.Jb(aQm.field_snsId)).PH(aQm.getUxinfo()).tR(intExtra).PH(new StringBuilder().append(snsInfoFlip.EEo).toString()).PH(new StringBuilder().append(System.currentTimeMillis()).toString()).PH(stringBuffer3).tR(snsInfoFlip.getCount());
                        tO.bfK();
                    }
                }
            }
        }
        k w = k.w(getIntent());
        if (w != null) {
            this.EAi.getSelectCount();
            w.tR(this.EAi.getCount()).tR(this.EAi.getNumOfFileExist());
            w.update();
            w.bfK();
        }
        aj.faL().aI(this);
        if (this.EAv) {
            this.EAi.fii();
        }
        if (this.EAy != null) {
            this.EAy.stop();
        }
        super.onDestroy();
        AppMethodBeat.o(98510);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(98511);
        if (this.EAi != null) {
            this.EAi.onPause();
        }
        super.onPause();
        f.e(false, true, true);
        AppMethodBeat.o(98511);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(98512);
        super.onResume();
        if (this.EAi != null) {
            this.EAi.vu(false);
        }
        f.e(true, true, true);
        AppMethodBeat.o(98512);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public int getLayoutId() {
        return R.layout.bvc;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(98513);
        Bundle bundle = this.qaD;
        if (!this.isAnimated) {
            this.isAnimated = true;
            if (Build.VERSION.SDK_INT >= 12) {
                this.COM = (Rect) getIntent().getParcelableExtra("sns_gallery_thumb_location");
                if (this.COM == null) {
                    this.COM = new Rect();
                }
                this.qaE.Q(this.COM.left, this.COM.top, this.COM.width(), this.COM.height());
                if (bundle == null) {
                    this.EAi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsBrowseUI.AnonymousClass3 */

                        public final boolean onPreDraw() {
                            AppMethodBeat.i(98500);
                            SnsBrowseUI.this.EAi.getViewTreeObserver().removeOnPreDrawListener(this);
                            SnsBrowseUI.this.mEX = SnsBrowseUI.this.EAi.getWidth();
                            SnsBrowseUI.this.mEY = SnsBrowseUI.this.EAi.getHeight();
                            SnsBrowseUI.this.EAz = SnsBrowseUI.this.EAi.getWidth();
                            SnsBrowseUI.this.EAA = SnsBrowseUI.this.EAi.getHeight();
                            aj.faL();
                            String D = g.D(SnsBrowseUI.this.EAi.getCntMedia());
                            if (D != null) {
                                BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(D);
                                SnsBrowseUI.this.EAA = (int) (((float) imageOptions.outHeight) * (((float) SnsBrowseUI.this.EAz) / ((float) imageOptions.outWidth)));
                                if (SnsBrowseUI.this.EAA > SnsBrowseUI.this.EAi.getHeight()) {
                                    SnsBrowseUI.this.EAA = SnsBrowseUI.this.EAi.getHeight();
                                }
                            }
                            SnsBrowseUI.this.qaE.ls(SnsBrowseUI.this.EAz, SnsBrowseUI.this.EAA);
                            SnsBrowseUI.this.qaE.a(SnsBrowseUI.this.EAi, SnsBrowseUI.this.jUG, null);
                            SnsBrowseUI.this.fhM();
                            AppMethodBeat.o(98500);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        Log.d("MicroMsg.SnsPopMediasUI", "onStart ");
        AppMethodBeat.o(98513);
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void ffK() {
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(98514);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
            setResult(-1, new Intent());
            cvQ();
            AppMethodBeat.o(98514);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(98514);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(98515);
        this.qaE = new e(getContext());
        this.isAnimated = false;
        String nullAs = Util.nullAs(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.dJX = Util.nullAs(getIntent().getStringExtra("sns_gallery_localId"), "");
        this.EAu = getIntent().getIntExtra("sns_gallery_position", 0);
        this.dNo = getIntent().getIntExtra("sns_position", 0);
        this.EAv = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
        this.EAw = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
        this.EAx = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
        this.scene = getIntent().getIntExtra("K_source", 0);
        SnsInfo aQm = aj.faO().aQm(this.dJX);
        this.jUG = (ImageView) findViewById(R.id.dcj);
        this.EAi = new SnsInfoFlip(this);
        this.EAi.setIsFromMainTimeline(this.EAv);
        this.EAi.setNeedScanImage(true);
        List<b> aPm = an.aPm(this.dJX);
        this.EAi.setShowPageControl(true);
        this.EAi.setTouchFinish(true);
        this.EAi.setIsSoonEnterPhotoEditUI(this.EAx);
        this.EAi.a(aPm, nullAs, this.EAu, this.EAd, this);
        SnsInfoFlip snsInfoFlip = this.EAi;
        bp gCU = bp.gCU();
        gCU.hXs = aQm.field_createTime;
        snsInfoFlip.setFromScene(gCU);
        this.EAi.setUIFromScene(getFromScene());
        this.EAi.setOnPageSelectListener(this);
        addView(this.EAi);
        if (aQm != null && aQm.isAd()) {
            this.EAi.setIsAd(true);
        }
        this.EAj = (Button) findViewById(R.id.dhi);
        int aD = au.aD(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.EAj.getLayoutParams();
        marginLayoutParams.bottomMargin = aD + getResources().getDimensionPixelSize(R.dimen.ajy);
        this.EAj.setLayoutParams(marginLayoutParams);
        final TimeLineObject timeLine = aQm.getTimeLine();
        final be beVar = timeLine != null ? timeLine.actionInfo : null;
        bl blVar = new bl();
        ao.a(this, blVar, timeLine.actionInfo);
        if (blVar.EOf) {
            this.EAj.setVisibility(0);
            this.EAj.setText(blVar.EOg);
            this.EAj.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsBrowseUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(98499);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (beVar.KEw == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(98499);
                        return;
                    }
                    String go = com.tencent.mm.plugin.sns.c.a.jRu.go(beVar.KEw.jfi);
                    int i2 = 0;
                    if (timeLine.ContentObj.LoU == 1) {
                        i2 = 2;
                    } else if (timeLine.ContentObj.LoU == 3) {
                        i2 = 5;
                    } else if (timeLine.ContentObj.LoU == 15) {
                        i2 = 4;
                    }
                    if (i.a(timeLine, SnsBrowseUI.this)) {
                        com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 18, 9, beVar.KEw.KEq, timeLine.Id);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(98499);
                        return;
                    }
                    switch (beVar.oUv) {
                        case 4:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", beVar.Url);
                            com.tencent.mm.plugin.sns.c.a.jRt.i(intent, SnsBrowseUI.this);
                            com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 18, 1, beVar.KEw.KEq, timeLine.Id);
                            break;
                        case 5:
                            if (beVar.Scene == 1) {
                                is isVar = new is();
                                isVar.dNr.actionCode = 2;
                                isVar.dNr.scene = 3;
                                isVar.dNr.appId = beVar.KEw.jfi;
                                isVar.dNr.context = SnsBrowseUI.this;
                                EventCenter.instance.publish(isVar);
                                com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 18, 6, beVar.KEw.KEq, timeLine.Id);
                                break;
                            }
                            break;
                        case 6:
                            int b2 = ao.b(SnsBrowseUI.this, beVar);
                            if (b2 != 1) {
                                if (b2 == 2) {
                                    is isVar2 = new is();
                                    isVar2.dNr.context = SnsBrowseUI.this;
                                    isVar2.dNr.actionCode = 1;
                                    isVar2.dNr.appId = beVar.KEw.jfi;
                                    isVar2.dNr.messageAction = beVar.KEw.KEs;
                                    isVar2.dNr.messageExt = beVar.KEw.KEr;
                                    isVar2.dNr.scene = 3;
                                    EventCenter.instance.publish(isVar2);
                                    com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 18, 3, beVar.KEw.KEq, timeLine.Id);
                                    break;
                                }
                            } else {
                                is isVar3 = new is();
                                isVar3.dNr.context = SnsBrowseUI.this;
                                isVar3.dNr.actionCode = 2;
                                isVar3.dNr.appId = beVar.KEw.jfi;
                                isVar3.dNr.messageAction = beVar.KEw.KEs;
                                isVar3.dNr.messageExt = beVar.KEw.KEr;
                                isVar3.dNr.scene = 3;
                                EventCenter.instance.publish(isVar3);
                                com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 18, 6, beVar.KEw.KEq, timeLine.Id);
                                break;
                            }
                            break;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(98499);
                }
            });
        } else {
            this.EAj.setVisibility(8);
        }
        if (!m.w(aQm)) {
            Log.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + aQm.getUserName() + " " + aQm.field_snsId);
            finish();
            AppMethodBeat.o(98515);
            return;
        }
        if (aQm.getTypeFlag() == 21 && !aQm.getUserName().equals(z.aTY())) {
            this.EAy = new v(com.tencent.mm.loader.j.b.aKD() + "/Pictures/Screenshots/", new v.a() {
                /* class com.tencent.mm.plugin.sns.ui.SnsBrowseUI.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.model.v.a
                public final void eCy() {
                    AppMethodBeat.i(98498);
                    com.tencent.mm.plugin.sns.lucky.a.b.pl(44);
                    com.tencent.mm.plugin.sns.lucky.b.a.c(4, aj.faO().aQm(SnsBrowseUI.this.dJX));
                    AppMethodBeat.o(98498);
                }
            });
            this.EAy.start();
        }
        AppMethodBeat.o(98515);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final boolean fhC() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final int fhD() {
        return 3;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final int fhE() {
        return 3;
    }

    public final void cvQ() {
        AppMethodBeat.i(98516);
        if (this.COM == null) {
            this.COM = new Rect();
        }
        if (!this.EAw) {
            ir irVar = new ir();
            irVar.dNm.dNp = this.EAi.getGallery().getCurrentItem();
            irVar.dNm.dNo = this.dNo;
            EventCenter.instance.publish(irVar);
            this.COM.left = irVar.dNn.dEq;
            this.COM.top = irVar.dNn.dEr;
            this.COM.right = irVar.dNn.dEs + this.COM.left;
            this.COM.bottom = irVar.dNn.dEt + this.COM.top;
        }
        this.EAz = this.EAi.getWidth();
        this.EAA = this.EAi.getHeight();
        aj.faL();
        String D = g.D(this.EAi.getCntMedia());
        if (D != null) {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(D);
            this.EAA = (int) (((float) imageOptions.outHeight) * (((float) this.EAz) / ((float) imageOptions.outWidth)));
            if (this.EAA > this.EAi.getHeight()) {
                if (((double) this.EAA) < ((double) this.EAi.getHeight()) * 2.5d) {
                    this.EAB = this.EAA - this.EAi.getHeight();
                    if (this.EAi.getCount() == 1) {
                        int height = (this.EAi.getHeight() * this.COM.height()) / this.EAA;
                        this.COM.bottom = height + this.COM.top;
                        this.EAB = 0;
                    }
                }
                this.EAA = this.EAi.getHeight();
            }
        }
        this.qaE.ls(this.EAz, this.EAA);
        this.qaE.Q(this.COM.left, this.COM.top, this.COM.width(), this.COM.height());
        if (((double) this.EAC) != 1.0d) {
            this.qaE.QtG = 1.0f / this.EAC;
            if (!(this.EAD == 0 && this.EAE == 0)) {
                this.qaE.lu(((int) (((float) (this.EAi.getWidth() / 2)) * (1.0f - this.EAC))) + this.EAD, (int) (((float) ((this.EAi.getHeight() / 2) + this.EAE)) - (((float) (this.EAA / 2)) * this.EAC)));
            }
        }
        this.qaE.QtK = this.EAB;
        this.qaE.a(this.EAi, this.jUG, new e.c() {
            /* class com.tencent.mm.plugin.sns.ui.SnsBrowseUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationStart() {
                AppMethodBeat.i(98503);
                SnsInfoFlip snsInfoFlip = SnsBrowseUI.this.EAi;
                if (snsInfoFlip.EEk != null) {
                    snsInfoFlip.EEk.setVisibility(8);
                }
                SnsBrowseUI.this.mHandler.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsBrowseUI.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(98501);
                        SnsInfoFlip snsInfoFlip = SnsBrowseUI.this.EAi;
                        if (snsInfoFlip.xqs != null) {
                            View selectedView = snsInfoFlip.xqs.getSelectedView();
                            if (selectedView instanceof com.tencent.mm.ui.base.g) {
                                ((com.tencent.mm.ui.base.g) selectedView).gKy();
                            }
                        }
                        AppMethodBeat.o(98501);
                    }
                }, 20);
                AppMethodBeat.o(98503);
            }

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationEnd() {
                AppMethodBeat.i(98504);
                SnsBrowseUI.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsBrowseUI.AnonymousClass4.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(98502);
                        SnsBrowseUI.this.finish();
                        SnsBrowseUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(98502);
                    }
                });
                AppMethodBeat.o(98504);
            }
        }, new e.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsBrowseUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.tools.e.a
            public final void L(int i2, int i3, int i4, int i5) {
                AppMethodBeat.i(98505);
                if (SnsBrowseUI.this.EAi.getGallery() != null && Build.VERSION.SDK_INT >= 18) {
                    SnsBrowseUI.this.EAi.getGallery().setClipBounds(new Rect(i2, i3, i4, i5));
                }
                AppMethodBeat.o(98505);
            }
        });
        AppMethodBeat.o(98516);
    }

    public final void fhM() {
        AppMethodBeat.i(98517);
        final MMViewPager gallery = this.EAi.getGallery();
        gallery.setGalleryScaleListener(new MMViewPager.c() {
            /* class com.tencent.mm.plugin.sns.ui.SnsBrowseUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.MMViewPager.c
            public final void S(float f2, float f3) {
                float f4 = 1.0f;
                AppMethodBeat.i(98506);
                if ((SnsBrowseUI.this.mEY == 0 || SnsBrowseUI.this.mEX == 0) && SnsBrowseUI.this.EAi != null) {
                    SnsBrowseUI.this.mEY = SnsBrowseUI.this.EAi.getHeight();
                    SnsBrowseUI.this.mEX = SnsBrowseUI.this.EAi.getWidth();
                }
                if (SnsBrowseUI.this.mEY != 0) {
                    float f5 = 1.0f - (f3 / ((float) SnsBrowseUI.this.mEY));
                    if (f5 <= 1.0f) {
                        f4 = f5;
                    }
                    SnsBrowseUI.this.EAC = f4;
                    View selectedView = gallery.getSelectedView();
                    selectedView.setPivotX((float) (SnsBrowseUI.this.mEX / 2));
                    selectedView.setPivotY((float) (SnsBrowseUI.this.mEY / 2));
                    selectedView.setScaleX(f4);
                    selectedView.setScaleY(f4);
                    selectedView.setTranslationX(f2);
                    selectedView.setTranslationY(f3);
                    SnsBrowseUI.this.jUG.setAlpha(f4);
                }
                AppMethodBeat.o(98506);
            }

            @Override // com.tencent.mm.ui.base.MMViewPager.c
            public final void ao(float f2, float f3) {
                AppMethodBeat.i(98507);
                SnsBrowseUI.this.EAD = (int) f2;
                SnsBrowseUI.this.EAE = (int) f3;
                AppMethodBeat.o(98507);
            }
        });
        AppMethodBeat.o(98517);
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void fH(String str, int i2) {
        AppMethodBeat.i(98518);
        Log.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", Integer.valueOf(i2), Boolean.TRUE, str);
        if (this.EAi != null) {
            this.EAi.vu(true);
        }
        AppMethodBeat.o(98518);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(98519);
        Log.i("MicroMsg.SnsPopMediasUI", "onActivityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(98519);
        } else {
            AppMethodBeat.o(98519);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void fI(String str, int i2) {
        AppMethodBeat.i(98520);
        this.EAu = i2;
        if (this.scene == 2) {
            SnsInfo aQm = com.tencent.mm.plugin.sns.storage.f.aQm(str);
            com.tencent.mm.plugin.sns.k.e.DUQ.d(aQm, i2);
            com.tencent.mm.plugin.sns.k.e.DUQ.e(aQm, i2);
        }
        AppMethodBeat.o(98520);
    }
}
