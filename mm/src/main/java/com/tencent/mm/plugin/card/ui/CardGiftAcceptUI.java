package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;

@a(7)
public class CardGiftAcceptUI extends MMActivity implements View.OnClickListener, i {
    private final String TAG = "MicroMsg.CardGiftAcceptUI";
    private String dSW;
    private String dYs;
    private TextView hFg;
    private int ixX;
    private String ixY;
    private RelativeLayout qai;
    private RelativeLayout qaj;
    private ImageView qak;
    private TextView qal;
    private ImageView qam;
    private Button qan;
    private LinearLayout qao;
    private TextView qap;
    private LinearLayout qaq;
    private TextView qar;
    private ImageView qas;
    private ImageView qat;
    private RelativeLayout qau;
    private ag qav;
    private q qaw;
    private com.tencent.mm.ui.base.q tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.mu;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113309);
        super.onCreate(bundle);
        this.ixY = getIntent().getStringExtra("key_order_id");
        this.ixX = getIntent().getIntExtra("key_biz_uin", -1);
        this.dYs = getIntent().getStringExtra("key_from_user_name");
        this.dSW = getIntent().getStringExtra("key_chatroom_name");
        Log.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", this.ixY, Integer.valueOf(this.ixX), this.dYs);
        if (this.ixX == -1) {
            Log.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
            d.a(this, "", true);
            AppMethodBeat.o(113309);
        } else if (this.ixY == null) {
            Log.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
            d.a(this, "", true);
            AppMethodBeat.o(113309);
        } else {
            if (!Util.isNullOrNil(this.dYs)) {
                h.INSTANCE.a(13866, 1, this.ixY, p.getString(this.ixX), this.dYs);
            }
            initView();
            g.aAg().hqi.a(1171, this);
            g.aAg().hqi.a(1136, this);
            AppMethodBeat.o(113309);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113310);
        super.onDestroy();
        g.aAg().hqi.b(1171, this);
        g.aAg().hqi.b(1136, this);
        AppMethodBeat.o(113310);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113311);
        this.qai = (RelativeLayout) findViewById(R.id.amb);
        this.qaj = (RelativeLayout) findViewById(R.id.amk);
        this.qak = (ImageView) findViewById(R.id.amm);
        this.qal = (TextView) findViewById(R.id.amn);
        this.hFg = (TextView) findViewById(R.id.ami);
        this.qam = (ImageView) findViewById(R.id.e4v);
        this.qan = (Button) findViewById(R.id.amp);
        this.qap = (TextView) findViewById(R.id.amj);
        this.qar = (TextView) findViewById(R.id.aml);
        this.qau = (RelativeLayout) findViewById(R.id.amo);
        this.qas = (ImageView) findViewById(R.id.amh);
        this.qat = (ImageView) findViewById(R.id.hge);
        this.qao = (LinearLayout) findViewById(R.id.g7m);
        this.qaq = (LinearLayout) findViewById(R.id.hgf);
        this.qau.setOnClickListener(this);
        this.qai.setOnClickListener(this);
        this.qaj.setOnClickListener(this);
        this.qao.setOnClickListener(this);
        this.qaq.setOnClickListener(this);
        getContentView().setVisibility(8);
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftAcceptUI.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(113308);
                if (CardGiftAcceptUI.this.tipDialog != null && CardGiftAcceptUI.this.tipDialog.isShowing()) {
                    CardGiftAcceptUI.this.tipDialog.dismiss();
                }
                Log.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
                CardGiftAcceptUI.this.finish();
                AppMethodBeat.o(113308);
            }
        });
        g.aAg().hqi.a(new ag(this.ixX, this.ixY, this.dSW), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
        AppMethodBeat.o(113311);
    }

    private static Drawable b(Drawable drawable, ColorStateList colorStateList) {
        AppMethodBeat.i(113312);
        Drawable i2 = android.support.v4.graphics.drawable.a.i(drawable);
        android.support.v4.graphics.drawable.a.a(i2, colorStateList);
        AppMethodBeat.o(113312);
        return i2;
    }

    private void fg(int i2, int i3) {
        AppMethodBeat.i(113313);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setStroke(2, i2);
        gradientDrawable.setCornerRadius(6.0f);
        this.qan.setBackground(gradientDrawable);
        AppMethodBeat.o(113313);
    }

    public void onClick(View view) {
        AppMethodBeat.i(113314);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.amp || view.getId() == R.id.g7m) {
            if (this.qan.getVisibility() == 0) {
                int hT = ao.hT(Util.convertStringToRGB(this.qav.pUw, getResources().getColor(R.color.hy)));
                fg(hT, hT);
                this.qan.setTextColor(getResources().getColor(R.color.ag2));
            }
            cvP();
            if (!Util.isNullOrNil(this.dYs)) {
                h.INSTANCE.a(13866, 2, this.ixY, p.getString(this.ixX), this.dYs);
            }
        } else if (view.getId() == R.id.amo) {
            finish();
        } else if (view.getId() == R.id.amb) {
            finish();
        } else if (view.getId() == R.id.hgf) {
            g.aAg().hqi.a(new q(this.ixX, this.ixY, this.dSW, Boolean.TRUE), 0);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113314);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(113315);
        if (i2 != 0 || i3 != 0) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (qVar instanceof ag) {
                Log.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                d.a(this, str, true);
                AppMethodBeat.o(113315);
                return;
            } else if (qVar instanceof q) {
                Log.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                d.a(this, str, true);
            }
        } else if (qVar instanceof ag) {
            this.qav = (ag) qVar;
            Log.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", Boolean.valueOf(this.qav.pUu));
            if (!this.qav.pUu) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (this.qav == null) {
                    Log.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
                } else {
                    this.hFg.setText(this.qav.content);
                    this.qal.setText(l.b(this, this.qav.dYs, this.qal.getTextSize()));
                    if (this.qav.status == 0) {
                        if (!Util.isNullOrNil(this.qav.pUt)) {
                            this.qan.setVisibility(0);
                            this.qan.setText(this.qav.pUt);
                            this.qan.setOnClickListener(this);
                        } else {
                            this.qan.setVisibility(0);
                            this.qan.setText(getResources().getString(R.string.aow));
                            this.qan.setOnClickListener(this);
                        }
                    } else if (this.qav.status == 1 || this.qav.status != 2) {
                        this.qan.setVisibility(8);
                        this.qan.setOnClickListener(null);
                    } else if (!Util.isNullOrNil(this.qav.pUt)) {
                        this.qan.setVisibility(0);
                        this.qan.setBackgroundDrawable(null);
                        this.qan.setText(this.qav.pUt);
                        this.qan.setTextColor(getResources().getColor(R.color.a2x));
                        this.qan.setTextSize(1, 17.0f);
                        this.qan.setOnClickListener(null);
                    } else {
                        this.qan.setVisibility(8);
                        this.qan.setOnClickListener(null);
                    }
                    if (!Util.isNullOrNil(this.qav.pUx)) {
                        this.qan.setVisibility(8);
                        this.qaq.setVisibility(8);
                        this.qao.setVisibility(0);
                        this.qap.setText(this.qav.pUx);
                    }
                    if (!Util.isNullOrNil(this.qav.pUy)) {
                        this.qao.setVisibility(8);
                        this.qaq.setVisibility(0);
                        this.qar.setText(this.qav.pUy);
                    }
                    if (!Util.isNullOrNil(this.qav.pUs)) {
                        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this, 15);
                        c.a aVar = new c.a();
                        aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                        com.tencent.mm.av.q.bcW();
                        aVar.jbw = null;
                        aVar.fullPath = m.ajp(this.qav.pUs);
                        aVar.jbf = true;
                        aVar.iaT = true;
                        aVar.jbx = (float) fromDPToPix;
                        aVar.jbd = true;
                        aVar.jbq = R.drawable.ci4;
                        com.tencent.mm.av.q.bcV().a(this.qav.pUs, this.qak, aVar.bdv());
                    }
                    if (!Util.isNullOrNil(this.qav.pUv)) {
                        com.tencent.mm.av.q.bcV().loadImage(this.qav.pUv, this.qam);
                    }
                    if (!Util.isNullOrNil(this.qav.pUw) && this.qan.getVisibility() == 0) {
                        int hT = ao.hT(Util.convertStringToRGB(this.qav.pUw, getResources().getColor(R.color.hy)));
                        fg(hT, getResources().getColor(R.color.f3048f));
                        this.qan.setTextColor(hT);
                    }
                    if (!Util.isNullOrNil(this.qav.pUw) && this.qap.getVisibility() == 0) {
                        this.qap.setTextColor(ao.hT(Util.convertStringToRGB(this.qav.pUw, getResources().getColor(R.color.hy))));
                        int color = getResources().getColor(R.color.hy);
                        if (!Util.isNullOrNil(this.qav.pUw)) {
                            color = Util.convertStringToRGB(this.qav.pUw, color);
                        }
                        this.qas.setImageDrawable(b(this.qas.getDrawable(), ColorStateList.valueOf(ao.hT(color))));
                    }
                    if (!Util.isNullOrNil(this.qav.pUw) && this.qar.getVisibility() == 0) {
                        this.qar.setTextColor(ao.hT(Util.convertStringToRGB(this.qav.pUw, getResources().getColor(R.color.hy))));
                        int color2 = getResources().getColor(R.color.hy);
                        if (!Util.isNullOrNil(this.qav.pUw)) {
                            color2 = Util.convertStringToRGB(this.qav.pUw, color2);
                        }
                        this.qat.setImageDrawable(b(this.qat.getDrawable(), ColorStateList.valueOf(ao.hT(color2))));
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.qan.getLayoutParams();
                        marginLayoutParams.topMargin -= com.tencent.mm.cb.a.fromDPToPix((Context) this, 20);
                        this.qan.setLayoutParams(marginLayoutParams);
                    }
                    if (this.qan.getVisibility() == 0 && this.qaq.getVisibility() == 8) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.qan.getLayoutParams();
                        marginLayoutParams2.bottomMargin += com.tencent.mm.cb.a.fromDPToPix((Context) this, 28);
                        this.qan.setLayoutParams(marginLayoutParams2);
                    }
                }
                RelativeLayout relativeLayout = this.qaj;
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(300);
                scaleAnimation.setInterpolator(new OvershootInterpolator());
                scaleAnimation.setFillAfter(true);
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(100);
                scaleAnimation2.setFillAfter(true);
                scaleAnimation.setAnimationListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0096: INVOKE  
                      (r0v150 'scaleAnimation' android.view.animation.ScaleAnimation)
                      (wrap: com.tencent.mm.plugin.card.d.n$3 : 0x0093: CONSTRUCTOR  (r2v45 com.tencent.mm.plugin.card.d.n$3) = (r10v0 'relativeLayout' android.widget.RelativeLayout), (r1v81 'scaleAnimation2' android.view.animation.ScaleAnimation) call: com.tencent.mm.plugin.card.d.n.3.<init>(android.view.View, android.view.animation.ScaleAnimation):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.animation.ScaleAnimation.setAnimationListener(android.view.animation.Animation$AnimationListener):void in method: com.tencent.mm.plugin.card.ui.CardGiftAcceptUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void, file: classes6.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0093: CONSTRUCTOR  (r2v45 com.tencent.mm.plugin.card.d.n$3) = (r10v0 'relativeLayout' android.widget.RelativeLayout), (r1v81 'scaleAnimation2' android.view.animation.ScaleAnimation) call: com.tencent.mm.plugin.card.d.n.3.<init>(android.view.View, android.view.animation.ScaleAnimation):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.card.ui.CardGiftAcceptUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void, file: classes6.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.card.d.n, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    */
                /*
                // Method dump skipped, instructions count: 1171
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.CardGiftAcceptUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
            }

            private void cvP() {
                AppMethodBeat.i(113316);
                g.aAg().hqi.a(new q(this.ixX, this.ixY, this.dSW, Boolean.FALSE), 0);
                if (this.tipDialog != null) {
                    this.tipDialog.show();
                }
                AppMethodBeat.o(113316);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
            public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(113317);
                if (i2 == 4) {
                    Log.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    finish();
                }
                boolean onKeyDown = super.onKeyDown(i2, keyEvent);
                AppMethodBeat.o(113317);
                return onKeyDown;
            }
        }
