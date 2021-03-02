package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.d.a;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI extends MMActivity implements View.OnClickListener, i {
    private int ixX;
    private String ixY;
    private ProgressBar qaB;
    private MMHandler qaC = new MMHandler(Looper.getMainLooper());
    private ScrollView qaM;
    private LinearLayout qaN;
    private ImageView qaO;
    private TextView qaP;
    private TextView qaQ;
    private ImageView qaR;
    private ImageView qaS;
    private LinearLayout qaT;
    private RelativeLayout qaU;
    private RelativeLayout qaV;
    private TextView qaW;
    private ImageView qaX;
    private TextView qaY;
    private TextView qaZ;
    private CardGiftInfo qay;
    a.AbstractC0901a qbA = new a.AbstractC0901a() {
        /* class com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.card.d.a.AbstractC0901a
        public final void cP(String str, int i2) {
            AppMethodBeat.i(201315);
            if (CardGiftReceiveUI.this.qay == null) {
                Log.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
                AppMethodBeat.o(201315);
            } else if (Util.isNullOrNil(str) || Util.isNullOrNil(CardGiftReceiveUI.this.qay.pSq) || !str.equals(CardGiftReceiveUI.this.qay.pSq)) {
                CardGiftReceiveUI.this.qaC.post(new Runnable() {
                    /* class com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(201313);
                        if (CardGiftReceiveUI.this.qaB.getVisibility() != 0) {
                            CardGiftReceiveUI.this.qaB.setVisibility(0);
                        }
                        AppMethodBeat.o(201313);
                    }
                });
                AppMethodBeat.o(201315);
            } else {
                Log.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
                AppMethodBeat.o(201315);
            }
        }

        @Override // com.tencent.mm.plugin.card.d.a.AbstractC0901a
        public final void ajH(String str) {
            AppMethodBeat.i(201316);
            Log.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(str)));
            AppMethodBeat.o(201316);
        }

        @Override // com.tencent.mm.plugin.card.d.a.AbstractC0901a
        public final void fw(final String str, final String str2) {
            AppMethodBeat.i(201317);
            Log.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(str)));
            if (CardGiftReceiveUI.this.qay == null) {
                Log.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
                AppMethodBeat.o(201317);
            } else if (Util.isNullOrNil(str) || Util.isNullOrNil(CardGiftReceiveUI.this.qay.pSq) || !str.equals(CardGiftReceiveUI.this.qay.pSq)) {
                CardGiftReceiveUI.this.qaC.post(new Runnable() {
                    /* class com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.AnonymousClass5.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(201314);
                        if (CardGiftReceiveUI.this.qaB.getVisibility() != 8) {
                            CardGiftReceiveUI.this.qaB.setVisibility(8);
                        }
                        if (Util.isNullOrNil(str) || Util.isNullOrNil(CardGiftReceiveUI.this.qay.pSr) || !str.equals(CardGiftReceiveUI.this.qay.pSr)) {
                            CardGiftReceiveUI.this.qbo.setVisibility(8);
                        } else {
                            CardGiftReceiveUI.this.qbo.setVisibility(0);
                        }
                        Bitmap Sq = u.Sq(str2);
                        if (Sq == null) {
                            CardGiftReceiveUI.this.qbp.setImageResource(R.raw.download_image_icon);
                            AppMethodBeat.o(201314);
                            return;
                        }
                        CardGiftReceiveUI.this.qbp.setImageBitmap(Sq);
                        AppMethodBeat.o(201314);
                    }
                });
                AppMethodBeat.o(201317);
            } else {
                Log.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
                AppMethodBeat.o(201317);
            }
        }
    };
    private TextView qba;
    private ImageView qbb;
    private ImageView qbc;
    private View qbd;
    private TextView qbe;
    private LinearLayout qbf;
    private ListView qbg;
    private RelativeLayout qbh;
    private LinearLayout qbi;
    private ImageView qbj;
    private TextView qbk;
    private LinearLayout qbl;
    private TextView qbm;
    private RelativeLayout qbn;
    private RelativeLayout qbo;
    private ImageView qbp;
    private ImageView qbq;
    private TextView qbr;
    private Button qbs;
    private TextView qbt;
    private ListView qbu;
    private RelativeLayout qbv;
    private TextView qbw;
    private TextView qbx;
    private View qby;
    private RelativeLayout qbz;
    private q tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardGiftReceiveUI() {
        AppMethodBeat.i(113355);
        AppMethodBeat.o(113355);
    }

    static /* synthetic */ View d(CardGiftReceiveUI cardGiftReceiveUI) {
        AppMethodBeat.i(113373);
        View contentView = cardGiftReceiveUI.getContentView();
        AppMethodBeat.o(113373);
        return contentView;
    }

    static /* synthetic */ View e(CardGiftReceiveUI cardGiftReceiveUI) {
        AppMethodBeat.i(113374);
        View contentView = cardGiftReceiveUI.getContentView();
        AppMethodBeat.o(113374);
        return contentView;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.n0;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113356);
        super.onCreate(bundle);
        this.ixY = getIntent().getStringExtra("key_order_id");
        this.ixX = getIntent().getIntExtra("key_biz_uin", -1);
        this.qay = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        Log.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", this.ixY, Integer.valueOf(this.ixX));
        initView();
        g.aAg().hqi.a(1165, this);
        g.aAg().hqi.a(1099, this);
        com.tencent.mm.plugin.card.d.a.a(this.qbA);
        if (this.qay == null) {
            Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
            if (this.ixX == -1) {
                Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
                AppMethodBeat.o(113356);
                return;
            }
            if (this.ixY == null) {
                Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
            }
            Log.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
            g.aAg().hqi.a(new z(this.ixX, this.ixY), 0);
            this.tipDialog = h.a((Context) getContext(), getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(201312);
                    if (CardGiftReceiveUI.this.tipDialog != null && CardGiftReceiveUI.this.tipDialog.isShowing()) {
                        CardGiftReceiveUI.this.tipDialog.dismiss();
                    }
                    if (CardGiftReceiveUI.d(CardGiftReceiveUI.this).getVisibility() == 8 || CardGiftReceiveUI.e(CardGiftReceiveUI.this).getVisibility() == 4) {
                        Log.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
                        CardGiftReceiveUI.this.finish();
                    }
                    AppMethodBeat.o(201312);
                }
            });
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
            AppMethodBeat.o(113356);
            return;
        }
        cuE();
        AppMethodBeat.o(113356);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113357);
        super.onDestroy();
        g.aAg().hqi.b(1165, this);
        g.aAg().hqi.b(1099, this);
        com.tencent.mm.plugin.card.d.a.b(this.qbA);
        AppMethodBeat.o(113357);
    }

    private void cuE() {
        AppMethodBeat.i(113358);
        if (this.qay == null) {
            Log.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
            AppMethodBeat.o(113358);
            return;
        }
        Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", Integer.valueOf(this.qay.pSF));
        if (this.qay.pSF == 1 || this.qay.pSF != 2) {
            cvT();
        } else {
            cvS();
        }
        cvR();
        cuS();
        cvU();
        if (!Util.isNullOrNil(this.qay.pSX)) {
            this.qbs.setVisibility(0);
            this.qbs.setText(this.qay.pSX);
            this.qbs.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(201309);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!Util.isNullOrNil(CardGiftReceiveUI.this.qay.pTc)) {
                        d.a aVar = new d.a(CardGiftReceiveUI.this.getContext());
                        aVar.boo(CardGiftReceiveUI.this.qay.pTc);
                        aVar.aoW(R.string.sz);
                        aVar.aoV(R.string.h4);
                        aVar.a(true, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(201308);
                                if (CardGiftReceiveUI.this.qay.pSY == 1) {
                                    if ("cardhomepage".equals(CardGiftReceiveUI.this.qay.pSZ)) {
                                        kl klVar = new kl();
                                        klVar.dPA.context = CardGiftReceiveUI.this.getContext();
                                        EventCenter.instance.publish(klVar);
                                        AppMethodBeat.o(201308);
                                        return;
                                    } else if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.this.qay.pSZ)) {
                                        if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_CARD_ENTRANCE_SWITCH_V2_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                                            Intent intent = new Intent();
                                            intent.putExtra("scene", 1);
                                            com.tencent.mm.br.c.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", intent);
                                            AppMethodBeat.o(201308);
                                            return;
                                        }
                                        kl klVar2 = new kl();
                                        klVar2.dPA.context = CardGiftReceiveUI.this.getContext();
                                        EventCenter.instance.publish(klVar2);
                                        AppMethodBeat.o(201308);
                                        return;
                                    }
                                } else if (CardGiftReceiveUI.this.qay.pSY == 2) {
                                    com.tencent.mm.plugin.card.d.b.V(CardGiftReceiveUI.this.qay.pSK, CardGiftReceiveUI.this.qay.pTa, CardGiftReceiveUI.this.qay.pTb);
                                }
                                AppMethodBeat.o(201308);
                            }
                        });
                        aVar.hbn().show();
                    } else if (CardGiftReceiveUI.this.qay.pSY == 1) {
                        if ("cardhomepage".equals(CardGiftReceiveUI.this.qay.pSZ)) {
                            kl klVar = new kl();
                            klVar.dPA.context = CardGiftReceiveUI.this.getContext();
                            EventCenter.instance.publish(klVar);
                        } else if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.this.qay.pSZ)) {
                            if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_CARD_ENTRANCE_SWITCH_V2_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                                Intent intent = new Intent();
                                intent.putExtra("scene", 1);
                                com.tencent.mm.br.c.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", intent);
                            } else {
                                kl klVar2 = new kl();
                                klVar2.dPA.context = CardGiftReceiveUI.this.getContext();
                                EventCenter.instance.publish(klVar2);
                            }
                        }
                    } else if (CardGiftReceiveUI.this.qay.pSY == 2) {
                        com.tencent.mm.plugin.card.d.b.V(CardGiftReceiveUI.this.qay.pSK, CardGiftReceiveUI.this.qay.pTa, CardGiftReceiveUI.this.qay.pTb);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(201309);
                }
            });
        } else {
            this.qbs.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.qay.pSL) || !Util.isNullOrNil(this.qay.footerWording) || !Util.isNullOrNil(this.qay.pSU) || !Util.isNullOrNil(this.qay.pSV)) {
            this.qaM.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.AnonymousClass2 */

                public final void onGlobalLayout() {
                    AppMethodBeat.i(201310);
                    int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) CardGiftReceiveUI.this.getContext(), 67);
                    int height = CardGiftReceiveUI.this.qaM.getChildAt(0).getHeight() + fromDPToPix;
                    int height2 = CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight();
                    Log.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", Integer.valueOf(fromDPToPix), Integer.valueOf(height), Integer.valueOf(height2));
                    CardGiftReceiveUI.this.qaM.setFillViewport(true);
                    if (height > height2) {
                        CardGiftReceiveUI.a(CardGiftReceiveUI.this, true);
                    } else {
                        CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
                    }
                    CardGiftReceiveUI.this.qaM.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AppMethodBeat.o(201310);
                }
            });
            AppMethodBeat.o(113358);
            return;
        }
        this.qaM.setFillViewport(true);
        AppMethodBeat.o(113358);
    }

    private int ac(int i2) {
        AppMethodBeat.i(113359);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), i2);
        AppMethodBeat.o(113359);
        return fromDPToPix;
    }

    private void cvR() {
        AppMethodBeat.i(113360);
        if (this.qay.pSR == 1) {
            this.qbi.setVisibility(0);
            this.qbl.setVisibility(8);
            this.qbh.setVisibility(8);
            this.qbk.setText(l.b(this, this.qay.dYs, this.qbk.getTextSize()));
            g(this.qbj);
            AppMethodBeat.o(113360);
            return;
        }
        this.qbi.setVisibility(8);
        this.qbl.setVisibility(0);
        this.qbh.setVisibility(0);
        g(this.qbq);
        this.qbr.setText(l.b(this, this.qay.dYs, this.qbr.getTextSize()));
        if ((Util.isNullOrNil(this.qay.pSp) || "undefined".equals(this.qay.pSp)) && (Util.isNullOrNil(this.qay.pSq) || "undefined".equals(this.qay.pSq))) {
            this.qbn.setVisibility(8);
            Log.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
        } else {
            this.qbn.setVisibility(0);
        }
        cvV();
        if (!Util.isNullOrNil(this.qay.pSo)) {
            this.qbm.setText(l.b(this, this.qay.pSo, this.qbm.getTextSize()));
        }
        AppMethodBeat.o(113360);
    }

    private void g(ImageView imageView) {
        AppMethodBeat.i(113361);
        if (!Util.isNullOrNil(this.qay.pSn)) {
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this, 20);
            c.a aVar = new c.a();
            aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
            com.tencent.mm.av.q.bcW();
            aVar.jbw = null;
            aVar.fullPath = m.ajp(this.qay.pSn);
            aVar.jbf = true;
            aVar.iaT = true;
            aVar.jbx = 3.0f;
            aVar.jbd = true;
            aVar.hZA = fromDPToPix;
            aVar.hZz = fromDPToPix;
            aVar.hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
            com.tencent.mm.av.q.bcV().a(this.qay.pSn, imageView, aVar.bdv());
            AppMethodBeat.o(113361);
            return;
        }
        Log.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
        AppMethodBeat.o(113361);
    }

    private void cvS() {
        AppMethodBeat.i(113362);
        this.qaT.setVisibility(8);
        this.qaN.setVisibility(0);
        this.qaP.setText(this.qay.pSD);
        this.qaQ.setText(this.qay.pSx + "     " + this.qay.pSy + getContext().getString(R.string.ap5));
        if (!Util.isNullOrNil(this.qay.pSE)) {
            this.qaO.setVisibility(0);
            c.a aVar = new c.a();
            aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
            com.tencent.mm.av.q.bcW();
            aVar.jbw = null;
            aVar.fullPath = m.ajp(this.qay.pSE);
            aVar.jbf = true;
            aVar.jbd = true;
            com.tencent.mm.av.q.bcV().a(this.qay.pSE, this.qaO, aVar.bdv());
        } else {
            this.qaO.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.qay.pSH)) {
            this.qaP.setTextColor(Util.convertStringToRGB(this.qay.pSH, getResources().getColor(R.color.a2x)));
        } else {
            Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
        }
        if (!Util.isNullOrNil(this.qay.pSI)) {
            this.qaQ.setTextColor(Util.convertStringToRGB(this.qay.pSI, getResources().getColor(R.color.a2x)));
        } else {
            Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
        }
        if (!Util.isNullOrNil(this.qay.pSw)) {
            c.a aVar2 = new c.a();
            aVar2.prefixPath = com.tencent.mm.loader.j.b.aKJ();
            com.tencent.mm.av.q.bcW();
            aVar2.jbw = null;
            aVar2.fullPath = m.ajp(this.qay.pSw);
            aVar2.iaT = true;
            aVar2.jbf = true;
            aVar2.jbd = true;
            aVar2.hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
            com.tencent.mm.av.q.bcV().a(this.qay.pSw, this.qaS, aVar2.bdv());
        } else {
            Log.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
        }
        if (!Util.isNullOrNil(this.qay.pSv)) {
            c.a aVar3 = new c.a();
            aVar3.prefixPath = com.tencent.mm.loader.j.b.aKJ();
            com.tencent.mm.av.q.bcW();
            aVar3.jbw = null;
            aVar3.fullPath = m.ajp(this.qay.pSv);
            aVar3.jbf = true;
            aVar3.jbd = true;
            aVar3.hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
            aVar3.iaT = true;
            aVar3.jbx = (float) com.tencent.mm.cb.a.fromDPToPix((Context) this, 8);
            com.tencent.mm.av.q.bcV().a(this.qay.pSv, this.qaR, aVar3.bdv());
            AppMethodBeat.o(113362);
            return;
        }
        Log.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
        AppMethodBeat.o(113362);
    }

    private void cvT() {
        AppMethodBeat.i(113363);
        this.qaN.setVisibility(8);
        this.qaT.setVisibility(0);
        this.qaY.setText(this.qay.pSx);
        if (this.qay.pSR == 1) {
            this.qbb.setAlpha(0.5f);
            this.qaZ.setVisibility(8);
            this.qba.setVisibility(8);
            this.qaV.setVisibility(8);
            this.qaU.setVisibility(8);
        } else {
            this.qaZ.setVisibility(0);
            this.qba.setVisibility(0);
            this.qaV.setVisibility(0);
            this.qaU.setVisibility(0);
            this.qaZ.setText(this.qay.pSy);
            this.qba.setText(R.string.ap5);
            if (Util.isNullOrNil(this.qay.pSy)) {
                this.qaZ.setVisibility(8);
                this.qba.setVisibility(8);
            }
            if (!Util.isNullOrNil(this.qay.pSJ)) {
                this.qaZ.setTextColor(Util.convertStringToRGB(this.qay.pSJ, getResources().getColor(R.color.a2x)));
            } else {
                Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
            }
        }
        if (!Util.isNullOrNil(this.qay.pSE)) {
            this.qaX.setVisibility(0);
            c.a aVar = new c.a();
            aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
            com.tencent.mm.av.q.bcW();
            aVar.jbw = null;
            aVar.fullPath = m.ajp(this.qay.pSE);
            aVar.jbf = true;
            aVar.jbd = true;
            com.tencent.mm.av.q.bcV().a(this.qay.pSE, this.qaX, aVar.bdv());
        } else {
            this.qaX.setVisibility(8);
            Log.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        }
        if (!Util.isNullOrNil(this.qay.pSD)) {
            this.qaW.setVisibility(0);
            this.qaW.setText(this.qay.pSD);
            if (!Util.isNullOrNil(this.qay.pSH)) {
                this.qaW.setTextColor(Util.convertStringToRGB(this.qay.pSH, getResources().getColor(R.color.a2x)));
            } else {
                Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
            }
        } else {
            this.qaW.setVisibility(8);
            Log.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        }
        if (!Util.isNullOrNil(this.qay.pSI)) {
            this.qaY.setTextColor(Util.convertStringToRGB(this.qay.pSI, getResources().getColor(R.color.a2x)));
        } else {
            Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
        }
        if (!Util.isNullOrNil(this.qay.pSw)) {
            c.a aVar2 = new c.a();
            aVar2.prefixPath = com.tencent.mm.loader.j.b.aKJ();
            com.tencent.mm.av.q.bcW();
            aVar2.jbw = null;
            aVar2.fullPath = m.ajp(this.qay.pSw);
            aVar2.iaT = true;
            aVar2.jbf = true;
            aVar2.jbd = true;
            aVar2.hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
            com.tencent.mm.av.q.bcV().a(this.qay.pSw, this.qbc, aVar2.bdv());
        } else {
            Log.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
        }
        if (!Util.isNullOrNil(this.qay.pSv)) {
            c.a aVar3 = new c.a();
            aVar3.prefixPath = com.tencent.mm.loader.j.b.aKJ();
            com.tencent.mm.av.q.bcW();
            aVar3.jbw = null;
            aVar3.fullPath = m.ajp(this.qay.pSv);
            aVar3.jbf = true;
            aVar3.jbd = true;
            aVar3.hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
            aVar3.iaT = true;
            aVar3.jbx = (float) com.tencent.mm.cb.a.fromDPToPix((Context) this, 8);
            com.tencent.mm.av.q.bcV().a(this.qay.pSv, this.qbb, aVar3.bdv());
            AppMethodBeat.o(113363);
            return;
        }
        Log.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
        AppMethodBeat.o(113363);
    }

    private void cuS() {
        AppMethodBeat.i(113364);
        if (this.qay.pSO.size() > 0) {
            this.qbd.setVisibility(0);
            this.qbg.setVisibility(8);
            if (this.qay.pSO.size() <= 2) {
                this.qbe.setVisibility(8);
                T(this.qay.pSO);
                AppMethodBeat.o(113364);
                return;
            }
            LinkedList<CardGiftInfo.AcceptedCardItem> linkedList = new LinkedList<>();
            linkedList.add(this.qay.pSO.get(0));
            linkedList.add(this.qay.pSO.get(1));
            T(linkedList);
            this.qbe.setVisibility(0);
            this.qbe.setOnClickListener(this);
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < this.qay.pSO.size(); i2++) {
                if (!(i2 == 0 || i2 == 1)) {
                    linkedList2.add(this.qay.pSO.get(i2));
                }
            }
            this.qbg.setAdapter((ListAdapter) new c(linkedList2));
            a(this.qbg);
            AppMethodBeat.o(113364);
            return;
        }
        this.qbd.setVisibility(8);
        this.qbe.setVisibility(8);
        this.qbg.setVisibility(8);
        AppMethodBeat.o(113364);
    }

    private void T(LinkedList<CardGiftInfo.AcceptedCardItem> linkedList) {
        AppMethodBeat.i(113365);
        Iterator<CardGiftInfo.AcceptedCardItem> it = linkedList.iterator();
        while (it.hasNext()) {
            CardGiftInfo.AcceptedCardItem next = it.next();
            View inflate = View.inflate(this, R.layout.mv, null);
            ((TextView) inflate.findViewById(R.id.iww)).setText(next.pTd);
            ((TextView) inflate.findViewById(R.id.iwv)).setText(next.pTe + getContext().getString(R.string.ap5));
            this.qbf.addView(inflate);
        }
        AppMethodBeat.o(113365);
    }

    private void cvU() {
        AppMethodBeat.i(113366);
        if (this.qay.pSP.size() > 0) {
            this.qbv.setVisibility(0);
            this.qbu.setVisibility(0);
            this.qbu.setAdapter((ListAdapter) new a());
            a(this.qbu);
            if (!Util.isNullOrNil(this.qay.pSQ)) {
                this.qbt.setVisibility(0);
                this.qbt.setText(this.qay.pSQ);
            }
            AppMethodBeat.o(113366);
        } else if (!Util.isNullOrNil(this.qay.pSQ)) {
            this.qbv.setVisibility(0);
            this.qbt.setVisibility(0);
            this.qbt.setText(this.qay.pSQ);
            this.qbu.setVisibility(8);
            AppMethodBeat.o(113366);
        } else {
            this.qbv.setVisibility(8);
            this.qbt.setVisibility(8);
            this.qbu.setVisibility(8);
            AppMethodBeat.o(113366);
        }
    }

    private static void a(ListView listView) {
        AppMethodBeat.i(113367);
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            AppMethodBeat.o(113367);
            return;
        }
        int count = adapter.getCount();
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            View view = adapter.getView(i3, null, listView);
            view.measure(0, 0);
            i2 += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i2;
        listView.setLayoutParams(layoutParams);
        AppMethodBeat.o(113367);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113368);
        this.qaM = (ScrollView) findViewById(R.id.amq);
        this.qaN = (LinearLayout) findViewById(R.id.apk);
        this.qaO = (ImageView) findViewById(R.id.e54);
        this.qaP = (TextView) findViewById(R.id.iyj);
        this.qaQ = (TextView) findViewById(R.id.iyi);
        this.qaR = (ImageView) findViewById(R.id.e52);
        this.qaS = (ImageView) findViewById(R.id.e53);
        this.qaR.setOnClickListener(this);
        this.qaT = (LinearLayout) findViewById(R.id.apj);
        this.qaU = (RelativeLayout) findViewById(R.id.a33);
        this.qaV = (RelativeLayout) findViewById(R.id.a36);
        this.qaW = (TextView) findViewById(R.id.ix6);
        this.qaY = (TextView) findViewById(R.id.iye);
        this.qaX = (ImageView) findViewById(R.id.e4y);
        this.qaZ = (TextView) findViewById(R.id.iyt);
        this.qba = (TextView) findViewById(R.id.iyu);
        this.qbb = (ImageView) findViewById(R.id.e4k);
        this.qbc = (ImageView) findViewById(R.id.e4l);
        this.qbb.setOnClickListener(this);
        this.qbd = findViewById(R.id.anw);
        this.qbe = (TextView) findViewById(R.id.iyl);
        this.qbf = (LinearLayout) findViewById(R.id.anv);
        this.qbg = (ListView) findViewById(R.id.anx);
        this.qbh = (RelativeLayout) findViewById(R.id.amf);
        this.qbi = (LinearLayout) findViewById(R.id.dk_);
        this.qbj = (ImageView) findViewById(R.id.e4n);
        this.qbk = (TextView) findViewById(R.id.ixl);
        this.qbl = (LinearLayout) findViewById(R.id.dk9);
        this.qbq = (ImageView) findViewById(R.id.e4m);
        this.qbr = (TextView) findViewById(R.id.ixk);
        this.qbm = (TextView) findViewById(R.id.ixj);
        this.qbn = (RelativeLayout) findViewById(R.id.an9);
        this.qbo = (RelativeLayout) findViewById(R.id.dxm);
        this.qbp = (ImageView) findViewById(R.id.ixp);
        this.qbn.setOnClickListener(this);
        this.qbo.setOnClickListener(this);
        this.qbt = (TextView) findViewById(R.id.iwf);
        this.qbu = (ListView) findViewById(R.id.bh);
        this.qbv = (RelativeLayout) findViewById(R.id.amd);
        this.qbs = (Button) findViewById(R.id.ani);
        this.qaB = (ProgressBar) findViewById(R.id.dw9);
        n.d(this);
        setMMTitle("");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(201311);
                CardGiftReceiveUI.this.finish();
                AppMethodBeat.o(201311);
                return true;
            }
        });
        AppMethodBeat.o(113368);
    }

    /* access modifiers changed from: package-private */
    public class c extends BaseAdapter {
        private LinkedList<CardGiftInfo.AcceptedCardItem> qbH;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(113354);
            CardGiftInfo.AcceptedCardItem Et = Et(i2);
            AppMethodBeat.o(113354);
            return Et;
        }

        c(LinkedList<CardGiftInfo.AcceptedCardItem> linkedList) {
            this.qbH = linkedList;
        }

        public final int getCount() {
            AppMethodBeat.i(113351);
            int size = this.qbH.size();
            AppMethodBeat.o(113351);
            return size;
        }

        private CardGiftInfo.AcceptedCardItem Et(int i2) {
            AppMethodBeat.i(113352);
            CardGiftInfo.AcceptedCardItem acceptedCardItem = this.qbH.get(i2);
            AppMethodBeat.o(113352);
            return acceptedCardItem;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            d dVar;
            AppMethodBeat.i(113353);
            CardGiftInfo.AcceptedCardItem Et = Et(i2);
            if (view == null) {
                view = View.inflate(CardGiftReceiveUI.this, R.layout.mv, null);
                d dVar2 = new d();
                dVar2.hbb = (TextView) view.findViewById(R.id.iww);
                dVar2.qbG = (TextView) view.findViewById(R.id.iwv);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.hbb.setText(Et.pTd);
            dVar.qbG.setText(Et.pTe + CardGiftReceiveUI.this.getContext().getString(R.string.ap5));
            AppMethodBeat.o(113353);
            return view;
        }
    }

    class d {
        public TextView hbb;
        public TextView qbG;

        d() {
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(113348);
            int size = CardGiftReceiveUI.this.qay.pSP.size();
            AppMethodBeat.o(113348);
            return size;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(113349);
            CardGiftInfo.AccepterItem accepterItem = CardGiftReceiveUI.this.qay.pSP.get(i2);
            if (view == null) {
                view = View.inflate(CardGiftReceiveUI.this, R.layout.mw, null);
                b bVar2 = new b();
                bVar2.qbE = (ImageView) view.findViewById(R.id.dx_);
                bVar2.qbF = (TextView) view.findViewById(R.id.iwg);
                bVar2.hbb = (TextView) view.findViewById(R.id.iwi);
                bVar2.qbG = (TextView) view.findViewById(R.id.iwh);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (accepterItem != null) {
                if (accepterItem.pTg != null) {
                    ImageView imageView = bVar.qbE;
                    String str = accepterItem.pTg;
                    if (imageView != null && !TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str)) {
                            c.a aVar = new c.a();
                            aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                            com.tencent.mm.av.q.bcW();
                            aVar.jbw = null;
                            aVar.fullPath = m.ajp(str);
                            aVar.jbf = true;
                            aVar.iaT = true;
                            aVar.jbx = 3.0f;
                            aVar.jbd = true;
                            aVar.hZA = 34;
                            aVar.hZz = 34;
                            aVar.jbq = R.drawable.ci4;
                            com.tencent.mm.av.q.bcV().a(str, imageView, aVar.bdv());
                        } else {
                            imageView.setImageResource(R.drawable.ci4);
                        }
                    }
                }
                bVar.qbF.setText(accepterItem.pTf);
                bVar.hbb.setText(accepterItem.pTd);
                bVar.qbG.setText(accepterItem.pTe + CardGiftReceiveUI.this.getContext().getString(R.string.ap5));
            }
            AppMethodBeat.o(113349);
            return view;
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(113350);
            CardGiftInfo.AccepterItem accepterItem = CardGiftReceiveUI.this.qay.pSP.get(i2);
            AppMethodBeat.o(113350);
            return accepterItem;
        }
    }

    class b {
        public TextView hbb;
        public ImageView qbE;
        public TextView qbF;
        public TextView qbG;

        b() {
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(113369);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof z) {
                Log.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
                this.qay = ((z) qVar).pUb;
                cuE();
                AppMethodBeat.o(113369);
                return;
            } else if (qVar instanceof t) {
                Intent intent = new Intent(this, CardDetailUI.class);
                LinkedList<CardInfo> linkedList = ((t) qVar).pUe;
                if (linkedList == null || linkedList.size() == 0) {
                    Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
                    AppMethodBeat.o(113369);
                    return;
                }
                CardInfo cardInfo = linkedList.get(0);
                if (cardInfo == null || !(cardInfo instanceof CardInfo)) {
                    Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
                    AppMethodBeat.o(113369);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<CardInfo> it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                intent.putExtra("key_card_info", cardInfo);
                intent.putExtra("key_previous_scene", 27);
                intent.putExtra("key_from_scene", 27);
                intent.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
                intent.putExtra("key_card_git_info", this.qay);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(113369);
                return;
            }
        } else if (qVar instanceof z) {
            Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            com.tencent.mm.plugin.card.d.d.a(this, str, true);
            AppMethodBeat.o(113369);
            return;
        } else if (qVar instanceof t) {
            Log.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            AppMethodBeat.o(113369);
            return;
        }
        AppMethodBeat.o(113369);
    }

    private void cvV() {
        AppMethodBeat.i(113370);
        if (this.qay == null || Util.isNullOrNil(this.qay.pSp)) {
            Log.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
        } else {
            com.tencent.mm.plugin.card.d.a.g(this.qay.pSp, this.qay.pSs, this.qay.pSA, 2);
        }
        if (this.qay == null || Util.isNullOrNil(this.qay.pSr)) {
            Log.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
            AppMethodBeat.o(113370);
            return;
        }
        com.tencent.mm.plugin.card.d.a.g(this.qay.pSr, this.qay.pSu, this.qay.pSC, 2);
        AppMethodBeat.o(113370);
    }

    public void onClick(View view) {
        AppMethodBeat.i(113371);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.dxm) {
            if (!Util.isNullOrNil(this.qay.pSq)) {
                Intent intent = new Intent(this, CardGiftVideoUI.class);
                intent.putExtra("key_gift_into", this.qay);
                intent.putExtra("key_is_mute", false);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                overridePendingTransition(0, 0);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13866, 3, this.ixY, p.getString(this.ixX));
            }
        } else if (view.getId() == R.id.an9) {
            if (this.qaB.getVisibility() == 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113371);
                return;
            } else if (!Util.isNullOrNil(this.qay.pSp)) {
                Intent intent2 = new Intent(this, CardGiftImageUI.class);
                intent2.putExtra("key_gift_into", this.qay);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                overridePendingTransition(0, 0);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13866, 4, this.ixY, p.getString(this.ixX));
            }
        } else if (view.getId() == R.id.ixh) {
            if (this.qay != null && this.qay.pSz) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13866, 7, this.ixY, p.getString(this.ixX));
                if (!"cardhomepage/couponandgiftcard".equals(this.qay.pSW)) {
                    kl klVar = new kl();
                    klVar.dPA.context = getContext();
                    klVar.dPA.scene = 2;
                    EventCenter.instance.publish(klVar);
                    Log.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
                } else if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_CARD_ENTRANCE_SWITCH_V2_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("scene", 1);
                    com.tencent.mm.br.c.b(getContext(), "card", ".ui.v3.CouponCardListUI", intent3);
                } else {
                    kl klVar2 = new kl();
                    klVar2.dPA.context = getContext();
                    EventCenter.instance.publish(klVar2);
                }
                finish();
                overridePendingTransition(0, 0);
            }
        } else if (view.getId() == R.id.ixi) {
            if (!TextUtils.isEmpty(this.qay.pSS) && !TextUtils.isEmpty(this.qay.pST)) {
                com.tencent.mm.plugin.card.d.b.d(this.qay.pSK, this.qay.pSS, this.qay.pST, 1062, getIntent().getIntExtra("key_from_appbrand_type", 0));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13866, 8, this.ixY, p.getString(this.ixX));
            } else if (!Util.isNullOrNil(this.qay.pSM)) {
                com.tencent.mm.plugin.card.d.b.a(this, this.qay.pSM, 0);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13866, 8, this.ixY, p.getString(this.ixX));
            }
        } else if (view.getId() == R.id.e4k || view.getId() == R.id.e52) {
            if (Util.isNullOrNil(this.qay.cardTpId) || Util.isNullOrNil(this.qay.pSN)) {
                Log.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
            } else {
                LinkedList linkedList = new LinkedList();
                va vaVar = new va();
                vaVar.pRX = this.qay.cardTpId;
                vaVar.code = this.qay.pSN;
                linkedList.add(vaVar);
                String stringExtra = getIntent().getStringExtra("key_template_id");
                eck eck = new eck();
                eck.NcB = stringExtra;
                Log.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", stringExtra);
                g.aAg().hqi.a(new t(linkedList, eck, 27), 0);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13866, 9, this.ixY, p.getString(this.ixX));
            }
        } else if (view.getId() == R.id.iyl) {
            if (this.qbg.getVisibility() == 0) {
                this.qbg.setVisibility(8);
                this.qbe.setText("查看全部");
            } else {
                this.qbg.setVisibility(0);
                this.qbe.setText("收起");
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113371);
    }

    static /* synthetic */ void a(CardGiftReceiveUI cardGiftReceiveUI, boolean z) {
        AppMethodBeat.i(201318);
        if (cardGiftReceiveUI.qbz == null) {
            cardGiftReceiveUI.qbz = (RelativeLayout) View.inflate(cardGiftReceiveUI, R.layout.mx, null);
            cardGiftReceiveUI.qby = cardGiftReceiveUI.qbz.findViewById(R.id.ab0);
            cardGiftReceiveUI.qbw = (TextView) cardGiftReceiveUI.qbz.findViewById(R.id.ixi);
            cardGiftReceiveUI.qbx = (TextView) cardGiftReceiveUI.qbz.findViewById(R.id.ixh);
            cardGiftReceiveUI.qbw.setOnClickListener(cardGiftReceiveUI);
            cardGiftReceiveUI.qbx.setOnClickListener(cardGiftReceiveUI);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (z) {
                if (cardGiftReceiveUI.qbv.getVisibility() == 0) {
                    layoutParams.addRule(3, R.id.bh);
                } else {
                    layoutParams.addRule(3, R.id.amg);
                }
                layoutParams.bottomMargin = cardGiftReceiveUI.ac(30);
                layoutParams.topMargin = cardGiftReceiveUI.ac(40);
            } else {
                layoutParams.addRule(12, -1);
                layoutParams.bottomMargin = cardGiftReceiveUI.ac(30);
                layoutParams.topMargin = cardGiftReceiveUI.ac(40);
            }
            if (cardGiftReceiveUI.qbv.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                if (cardGiftReceiveUI.qbn.getVisibility() == 0) {
                    layoutParams2.topMargin = cardGiftReceiveUI.ac(0);
                    cardGiftReceiveUI.qbv.setLayoutParams(layoutParams2);
                } else {
                    layoutParams2.topMargin = cardGiftReceiveUI.ac(60);
                }
                cardGiftReceiveUI.qbv.setLayoutParams(layoutParams2);
                cardGiftReceiveUI.qbv.addView(cardGiftReceiveUI.qbz, layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams3.topMargin = cardGiftReceiveUI.ac(60);
                cardGiftReceiveUI.qbh.setLayoutParams(layoutParams3);
                cardGiftReceiveUI.qbh.addView(cardGiftReceiveUI.qbz, layoutParams);
            }
            if (!Util.isNullOrNil(cardGiftReceiveUI.qay.pSU)) {
                cardGiftReceiveUI.qbw.setVisibility(0);
                cardGiftReceiveUI.qbw.setText(cardGiftReceiveUI.qay.pSU);
            } else {
                cardGiftReceiveUI.qbw.setVisibility(8);
            }
            if (!Util.isNullOrNil(cardGiftReceiveUI.qay.pSV)) {
                cardGiftReceiveUI.qby.setVisibility(0);
                cardGiftReceiveUI.qbx.setVisibility(0);
                cardGiftReceiveUI.qbx.setText(cardGiftReceiveUI.qay.pSV);
            } else {
                cardGiftReceiveUI.qby.setVisibility(8);
                cardGiftReceiveUI.qbx.setVisibility(8);
            }
            if (Util.isNullOrNil(cardGiftReceiveUI.qay.pSo)) {
                cardGiftReceiveUI.qbh.setVisibility(8);
            }
        }
        AppMethodBeat.o(201318);
    }
}
