package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.b.f;
import com.tencent.mm.plugin.aa.model.b.g;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaylistAAUI extends BaseAAPresenterActivity {
    private static int jYE = 1;
    private static int jYF = 2;
    private static int jYG = 3;
    private static int jYH = 4;
    private String dFw;
    private String dXh;
    private Dialog jUC = null;
    private int jUH;
    private Dialog jUV = null;
    private String jVs;
    private String jVt;
    private String jVv;
    private g jVw = ((g) aq(g.class));
    private View jWj;
    private String jYA;
    private String jYB;
    private int jYC;
    private long jYD;
    private f jYk = ((f) au(f.class));
    private LinearLayout jYl;
    private LinearLayout jYm;
    private LinearLayout jYn;
    private LinearLayout jYo;
    private LinearLayout jYp;
    private RelativeLayout jYq;
    private WalletTextView jYr;
    private Button jYs;
    private TextView jYt;
    private TextView jYu;
    private String jYv;
    private TextView jYw;
    private TextView jYx;
    private TextView jYy;
    private TextView jYz;
    private String title;

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PaylistAAUI() {
        AppMethodBeat.i(63734);
        AppMethodBeat.o(63734);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, TextView textView, SpannableString spannableString, String str, y yVar) {
        AppMethodBeat.i(213136);
        paylistAAUI.a(textView, spannableString, str, yVar);
        AppMethodBeat.o(213136);
    }

    static /* synthetic */ void k(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(213139);
        paylistAAUI.bmY();
        AppMethodBeat.o(213139);
    }

    static /* synthetic */ void m(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(213142);
        paylistAAUI.bmw();
        AppMethodBeat.o(213142);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(63735);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(63709);
                PaylistAAUI.this.finish();
                AppMethodBeat.o(63709);
                return false;
            }
        });
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.jVv = getIntent().getStringExtra("chatroom");
        this.jYl = (LinearLayout) findViewById(R.id.g_d);
        this.jYm = (LinearLayout) findViewById(R.id.g_3);
        this.jYn = (LinearLayout) findViewById(R.id.g9t);
        this.jYo = (LinearLayout) findViewById(R.id.g_f);
        this.jYq = (RelativeLayout) findViewById(R.id.g9y);
        this.jYw = (TextView) findViewById(R.id.g_e);
        ao.a(this.jYw.getPaint(), 0.8f);
        this.jYx = (TextView) findViewById(R.id.g9x);
        this.jWj = findViewById(R.id.h8y);
        this.jYy = (TextView) findViewById(R.id.g_g);
        ao.a(this.jYy.getPaint(), 0.8f);
        this.jYy.setClickable(true);
        this.jYy.setOnTouchListener(new o(this));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.fky));
        spannableStringBuilder.setSpan(new e(new e.a() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass12 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(63718);
                Log.i("MicroMsg.Aa.PaylistAAUI", "click AlertMsgTips");
                int i2 = !ab.Eq(PaylistAAUI.this.jVv) ? R.string.htl : R.string.htj;
                f.a aVar = new f.a(PaylistAAUI.this);
                aVar.aC(PaylistAAUI.this.getString(R.string.htm));
                View inflate = aa.jQ(PaylistAAUI.this).inflate(R.layout.c51, (ViewGroup) null);
                ((ImageView) inflate.findViewById(R.id.dup)).setImageResource(R.drawable.ck0);
                ((TextView) inflate.findViewById(R.id.ijq)).setText(i2);
                aVar.hu(inflate);
                aVar.apa(R.string.yq);
                aVar.boB(PaylistAAUI.this.getString(R.string.sz));
                aVar.JnN = false;
                aVar.a(new f.c() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass12.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                    }
                }, new f.c() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass12.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(63717);
                        PaylistAAUI.b(PaylistAAUI.this);
                        AppMethodBeat.o(63717);
                    }
                });
                aVar.show();
                h.INSTANCE.a(13721, 4, 7, Integer.valueOf(PaylistAAUI.this.jUH));
                AppMethodBeat.o(63718);
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.jYy.setText(spannableStringBuilder);
        this.jYz = (TextView) findViewById(R.id.g9w);
        ao.a(this.jYz.getPaint(), 0.8f);
        bmY();
        AppMethodBeat.o(63735);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean shouldEnsureSoterConnection() {
        return true;
    }

    private void bmY() {
        AppMethodBeat.i(63736);
        this.jUV = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
        this.jWj.setVisibility(4);
        this.jVw.jUk.bmq().f(new a<Void, y>() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass22 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(y yVar) {
                AppMethodBeat.i(63720);
                y yVar2 = yVar;
                if (yVar2 == null) {
                    Log.e("MicroMsg.Aa.PaylistAAUI", "queryDetailRes is null!!!");
                    PaylistAAUI.a(PaylistAAUI.this, (String) null);
                    Void r0 = QZL;
                    AppMethodBeat.o(63720);
                    return r0;
                }
                Log.i("MicroMsg.Aa.PaylistAAUI", "get queryDetailRes: %s, billNo: %s, type: %s, state: %s, is_launcher: %s, role: %s, role_state: %s, payer_list.size: %s", yVar2, yVar2.KBs, Integer.valueOf(yVar2.type), Integer.valueOf(yVar2.state), Integer.valueOf(yVar2.KBW), Integer.valueOf(yVar2.role), Integer.valueOf(yVar2.KBX), Integer.valueOf(yVar2.KBx.size()));
                Log.i("MicroMsg.Aa.PaylistAAUI", "paid_num: %s, plan_num: %s, activity_amount: %s", Integer.valueOf(yVar2.KBU), Integer.valueOf(yVar2.KBS), Long.valueOf(yVar2.KCe));
                PaylistAAUI.this.jWj.setVisibility(0);
                PaylistAAUI.this.jYA = yVar2.KBQ;
                PaylistAAUI.this.jYB = yVar2.KCf;
                PaylistAAUI.this.jYC = yVar2.KBx.size() + 1;
                PaylistAAUI.this.title = yVar2.title;
                PaylistAAUI.this.jUH = yVar2.type;
                PaylistAAUI.a(PaylistAAUI.this, yVar2);
                PaylistAAUI.b(PaylistAAUI.this, yVar2);
                PaylistAAUI.c(PaylistAAUI.this, yVar2);
                PaylistAAUI.d(PaylistAAUI.this, yVar2);
                PaylistAAUI.e(PaylistAAUI.this, yVar2);
                PaylistAAUI.f(PaylistAAUI.this, yVar2);
                PaylistAAUI.this.hideLoading();
                Void r02 = QZL;
                AppMethodBeat.o(63720);
                return r02;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass21 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(63719);
                Log.i("MicroMsg.Aa.PaylistAAUI", "onInterrupt: %s", obj);
                PaylistAAUI.this.hideLoading();
                if (obj == null || !(obj instanceof com.tencent.mm.protocal.protobuf.a)) {
                    PaylistAAUI.a(PaylistAAUI.this, obj == null ? "" : obj.toString());
                    AppMethodBeat.o(63719);
                    return;
                }
                final com.tencent.mm.protocal.protobuf.a aVar = (com.tencent.mm.protocal.protobuf.a) obj;
                String str = aVar.dQx;
                String str2 = aVar.lHA;
                String str3 = aVar.lHB;
                d.a aVar2 = new d.a(PaylistAAUI.this.getContext());
                aVar2.boo(str);
                aVar2.bou(str3).c(new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass21.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(213122);
                        Log.i("MicroMsg.Aa.PaylistAAUI", "click getPayListDetail onInterrupt Item");
                        com.tencent.mm.wallet_core.ui.f.p(PaylistAAUI.this.getContext(), aVar.qwt, false);
                        AppMethodBeat.o(213122);
                    }
                });
                aVar2.bov(str2);
                aVar2.hbn().show();
                AppMethodBeat.o(63719);
            }
        });
        AppMethodBeat.o(63736);
    }

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(63737);
        super.onDestroy();
        AppMethodBeat.o(63737);
    }

    private void a(final TextView textView, SpannableString spannableString, String str, final y yVar) {
        AppMethodBeat.i(213128);
        Drawable drawable = getResources().getDrawable(R.raw.icons_outlined_album);
        drawable.setColorFilter(getResources().getColor(R.color.Link), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds(0, 0, at.fromDPToPix(getContext(), 20), at.fromDPToPix(getContext(), 20));
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
        e eVar = new e(new e.a() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass27 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(213127);
                Log.i("MicroMsg.Aa.PaylistAAUI", "launcherTipTv img click");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass27.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213126);
                        h.INSTANCE.a(13721, 4, 12, Integer.valueOf(PaylistAAUI.this.jUH));
                        if (PaylistAAUI.this.jUC == null) {
                            PaylistAAUI.this.jUC = com.tencent.mm.ui.base.h.a((Context) PaylistAAUI.this, 3, (int) R.style.lj, PaylistAAUI.this.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass27.AnonymousClass1.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(213124);
                                    if (PaylistAAUI.this.jUC != null && PaylistAAUI.this.jUC.isShowing()) {
                                        PaylistAAUI.this.jUC.dismiss();
                                    }
                                    AppMethodBeat.o(213124);
                                }
                            });
                        }
                        q.bcU().a(yVar.KBA, new r.a() {
                            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass27.AnonymousClass1.AnonymousClass2 */

                            @Override // com.tencent.mm.av.r.a
                            public final void a(String str, Bitmap bitmap, String str2) {
                                AppMethodBeat.i(213125);
                                Log.i("MicroMsg.Aa.PaylistAAUI", "onLoadImageEnd() url:%s path:%s", str, str2);
                                if (PaylistAAUI.this.jUC != null && PaylistAAUI.this.jUC.isShowing()) {
                                    PaylistAAUI.this.jUC.dismiss();
                                }
                                if (bitmap != null) {
                                    Intent intent = new Intent();
                                    intent.putExtra("use_scene", 2);
                                    intent.putExtra("scene", 1);
                                    intent.putExtra("url", yVar.KBA);
                                    intent.putExtra("path", str2);
                                    ViewAnimHelper.ViewInfo q = ViewAnimHelper.q(textView, PaylistAAUI.this.getContext().getWindow().getDecorView());
                                    Rect rect = q.QMg;
                                    rect.right = rect.left + com.tencent.mm.cb.a.fromDPToPix((Context) PaylistAAUI.this.getContext(), 30);
                                    q.QMg.set(rect);
                                    intent.putExtra("view_info", q);
                                    intent.putExtra("aa_type", PaylistAAUI.this.jUH);
                                    c.b(PaylistAAUI.this, "aa", ".ui.AAImagPreviewUI", intent, 100);
                                    AppMethodBeat.o(213125);
                                    return;
                                }
                                Toast.makeText(PaylistAAUI.this, (int) R.string.a3, 1).show();
                                AppMethodBeat.o(213125);
                            }
                        });
                        AppMethodBeat.o(213126);
                    }
                });
                AppMethodBeat.o(213127);
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
        if (!Util.isNullOrNil(yVar.KBA)) {
            spannableStringBuilder.setSpan(aVar, 0, 1, 17);
            spannableStringBuilder.setSpan(eVar, 0, spannableStringBuilder2.length(), 18);
        }
        TextPaint paint = textView.getPaint();
        int measuredWidth = textView.getMeasuredWidth();
        float measureText = ((float) measuredWidth) - (paint.measureText(" ...  ") + ((float) at.fromDPToPix(getContext(), 19)));
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, paint, measuredWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int lineCount = staticLayout.getLineCount();
        Log.d("MicroMsg.Aa.PaylistAAUI", "lineCount ： %s", Integer.valueOf(lineCount));
        if (lineCount <= 0) {
            Log.i("MicroMsg.Aa.PaylistAAUI", "lineCount <= 0");
            AppMethodBeat.o(213128);
        } else if (lineCount <= 2) {
            textView.setText(spannableStringBuilder);
            AppMethodBeat.o(213128);
        } else {
            int lineEnd = staticLayout.getLineEnd(0);
            final SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(spannableString.subSequence(0, lineEnd + new StaticLayout(spannableString.subSequence(lineEnd, spannableString.length()), paint, (int) measureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0)));
            spannableStringBuilder3.append((CharSequence) " ...  ");
            if (!Util.isNullOrNil(yVar.KBA)) {
                spannableStringBuilder3.setSpan(aVar, 0, 1, 17);
                spannableStringBuilder3.setSpan(eVar, 0, spannableStringBuilder2.length(), 18);
            }
            Drawable drawable2 = getResources().getDrawable(R.raw.aa_paylist_unfold);
            drawable2.setColorFilter(getResources().getColor(R.color.FG_2), PorterDuff.Mode.SRC_ATOP);
            drawable2.setBounds(0, 0, at.fromDPToPix(getContext(), 19), at.fromDPToPix(getContext(), 19));
            spannableStringBuilder3.setSpan(new com.tencent.mm.ui.widget.a(drawable2, 1), spannableStringBuilder3.length() - 1, spannableStringBuilder3.length(), 33);
            final SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(spannableString);
            spannableStringBuilder4.append((CharSequence) " ");
            if (!Util.isNullOrNil(yVar.KBA)) {
                spannableStringBuilder4.setSpan(aVar, 0, 1, 17);
                spannableStringBuilder4.setSpan(eVar, 0, spannableStringBuilder2.length(), 18);
            }
            Drawable drawable3 = getResources().getDrawable(R.raw.aa_paylist_collapse);
            drawable3.setColorFilter(getResources().getColor(R.color.FG_2), PorterDuff.Mode.SRC_ATOP);
            drawable3.setBounds(0, 0, at.fromDPToPix(getContext(), 19), at.fromDPToPix(getContext(), 19));
            spannableStringBuilder4.setSpan(new com.tencent.mm.ui.widget.a(drawable3, 1), spannableStringBuilder4.length() - 1, spannableStringBuilder4.length(), 33);
            if (staticLayout.getLineCount() > 2) {
                textView.setText(spannableStringBuilder3);
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213101);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/PaylistAAUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (view.isSelected()) {
                            textView.setText(spannableStringBuilder3);
                            textView.setSelected(false);
                        } else {
                            textView.setText(spannableStringBuilder4);
                            textView.setSelected(true);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213101);
                    }
                });
                textView.setSelected(true);
                AppMethodBeat.o(213128);
                return;
            }
            textView.setText(spannableString);
            textView.setOnClickListener(null);
            AppMethodBeat.o(213128);
        }
    }

    private void a(y yVar) {
        AppMethodBeat.i(213129);
        if (i.aQ(yVar.KBx) != null) {
            this.jYm.setVisibility(8);
            this.jYl.setVisibility(0);
            String string = getString(R.string.b9, new Object[]{Double.valueOf(i.o((double) yVar.KBY))});
            String str = getString(R.string.fkr) + string;
            SpannableString spannableString = new SpannableString(str);
            WcPayTextApppearanceSpan wcPayTextApppearanceSpan = new WcPayTextApppearanceSpan((int) this.jYw.getTextSize(), ColorStateList.valueOf(getResources().getColor(R.color.a3g)));
            wcPayTextApppearanceSpan.IoX = com.tencent.mm.wallet_core.ui.f.gA(getContext());
            spannableString.setSpan(wcPayTextApppearanceSpan, str.lastIndexOf(string), string.length() + str.lastIndexOf(string), 17);
            this.jYw.setText(spannableString);
            this.jYw.setTextColor(getResources().getColor(R.color.a3g));
            AppMethodBeat.o(213129);
            return;
        }
        this.jYm.setVisibility(0);
        this.jYl.setVisibility(8);
        this.jYr = (WalletTextView) findViewById(R.id.fus);
        this.jYr.setVisibility(8);
        ((TextView) this.jYm.findViewById(R.id.g_4)).setVisibility(8);
        this.jYs = (Button) this.jYm.findViewById(R.id.g_2);
        if (yVar.state == com.tencent.mm.plugin.aa.model.a.jRP || yVar.state == com.tencent.mm.plugin.aa.model.a.jRQ) {
            this.jYs.setVisibility(8);
            AppMethodBeat.o(213129);
            return;
        }
        this.jYs.setText(getString(R.string.fkh));
        this.jYs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(213102);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/PaylistAAUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Aa.PaylistAAUI", "click mInstantPayBtn ForCustomize");
                Intent intent = PaylistAAUI.this.getIntent();
                intent.putExtra("user_name", PaylistAAUI.this.jYA);
                intent.putExtra("user_real_name", PaylistAAUI.this.jYB);
                c.b(PaylistAAUI.this, "aa", ".ui.AARemittanceUI", intent, (int) TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213102);
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jYs.getLayoutParams();
        layoutParams.topMargin = 0;
        this.jYs.setLayoutParams(layoutParams);
        AppMethodBeat.o(213129);
    }

    private static boolean P(int i2, int i3, int i4) {
        return i2 == com.tencent.mm.plugin.aa.model.a.jRS && i3 != com.tencent.mm.plugin.aa.model.a.jRW && i4 == com.tencent.mm.plugin.aa.model.a.jRO;
    }

    private void a(List<w> list, String str, boolean z) {
        String displayName;
        AppMethodBeat.i(63738);
        ((TextView) findViewById(R.id.g_i)).setText(str);
        this.jYy.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.g_j);
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            w wVar = list.get(i2);
            boolean z2 = i2 >= list.size() - 1;
            LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(R.layout.bhc, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) linearLayout2.findViewById(R.id.g_a);
            TextView textView2 = (TextView) linearLayout2.findViewById(R.id.g_b);
            TextView textView3 = (TextView) linearLayout2.findViewById(R.id.g_9);
            LinearLayout linearLayout3 = (LinearLayout) linearLayout2.findViewById(R.id.g__);
            a.b.c((ImageView) linearLayout2.findViewById(R.id.g_8), wVar.KBN);
            AppCompatActivity context = getContext();
            com.tencent.mm.plugin.aa.model.b.f fVar = this.jYk;
            String str2 = wVar.KBN;
            if (Util.isNullOrNil(str2)) {
                displayName = "";
            } else {
                displayName = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str2, fVar.QYU.getStringExtra("chatroom"));
            }
            textView.setText(l.b(context, displayName, textView.getTextSize()));
            if (wVar.KBP == com.tencent.mm.plugin.aa.model.a.jRZ) {
                String string = getString(R.string.b9, new Object[]{Double.valueOf(i.o((double) wVar.KBF))});
                String str3 = getString(R.string.fkr) + string;
                SpannableString spannableString = new SpannableString(str3);
                WcPayTextApppearanceSpan wcPayTextApppearanceSpan = new WcPayTextApppearanceSpan((int) textView2.getTextSize(), ColorStateList.valueOf(getResources().getColor(R.color.a3g)));
                wcPayTextApppearanceSpan.IoX = com.tencent.mm.wallet_core.ui.f.aS(getContext(), 7);
                spannableString.setSpan(wcPayTextApppearanceSpan, str3.lastIndexOf(string), string.length() + str3.lastIndexOf(string), 17);
                textView2.setText(spannableString);
                textView2.setTextColor(getResources().getColor(R.color.a3g));
                textView2.setVisibility(0);
                if (!Util.isNullOrNil(wVar.KBL)) {
                    textView3.setText(wVar.KBL);
                    textView3.setVisibility(0);
                    linearLayout3.setGravity(48);
                } else {
                    linearLayout3.setGravity(16);
                    textView3.setVisibility(8);
                }
                linearLayout.addView(linearLayout2);
            } else if (wVar.KBP == com.tencent.mm.plugin.aa.model.a.jRY) {
                String string2 = getString(R.string.b9, new Object[]{Double.valueOf(i.o((double) wVar.KBF))});
                String str4 = getString(R.string.fk9) + string2;
                SpannableString spannableString2 = new SpannableString(str4);
                WcPayTextApppearanceSpan wcPayTextApppearanceSpan2 = new WcPayTextApppearanceSpan((int) textView2.getTextSize(), ColorStateList.valueOf(getResources().getColor(R.color.a3i)));
                wcPayTextApppearanceSpan2.IoX = com.tencent.mm.wallet_core.ui.f.aS(getContext(), 7);
                spannableString2.setSpan(wcPayTextApppearanceSpan2, str4.lastIndexOf(string2), string2.length() + str4.lastIndexOf(string2), 17);
                textView2.setText(spannableString2);
                textView2.setTextColor(getResources().getColor(R.color.a3i));
                textView2.setVisibility(0);
                textView3.setVisibility(8);
                linearLayout3.setGravity(16);
                linearLayout.addView(linearLayout2);
            } else {
                textView2.setVisibility(8);
                textView3.setVisibility(8);
                linearLayout3.setGravity(16);
                linearLayout.addView(linearLayout2);
            }
            View findViewById = linearLayout2.findViewById(R.id.brt);
            if (z2) {
                findViewById.setBackgroundColor(getContext().getResources().getColor(R.color.f3043a));
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = 0;
                findViewById.setLayoutParams(layoutParams);
            } else {
                findViewById.setBackgroundColor(getContext().getResources().getColor(R.color.a7t));
            }
        }
        AppMethodBeat.o(63738);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bhd;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(63741);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 233) {
            b(i3, intent);
            AppMethodBeat.o(63741);
            return;
        }
        if (i2 == 222) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                Log.i("MicroMsg.Aa.PaylistAAUI", "select chatroom：%s", stringExtra);
                if (!Util.isNullOrNil(stringExtra)) {
                    Intent intent2 = new Intent(getContext(), LaunchAAUI.class);
                    intent2.putExtra("enter_scene", 3);
                    intent2.putExtra("chatroom_name", stringExtra);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                AppMethodBeat.o(63741);
                return;
            }
        } else if (i2 == 234 && i3 == -1) {
            Log.i("MicroMsg.Aa.PaylistAAUI", "PAY_AA_TYPE_BY_PERSON_CUSTOMIZE_CODE resultCode == RESULT_OK");
            finish();
        }
        AppMethodBeat.o(63741);
    }

    public final void b(int i2, Intent intent) {
        AppMethodBeat.i(63742);
        if (i2 == -1) {
            Log.i("MicroMsg.Aa.PaylistAAUI", "pay success, payMsgId: %s", this.dXh);
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Log.i("MicroMsg.Aa.PaylistAAUI", "do realname guide");
                Intent intent2 = new Intent();
                intent2.putExtra("key_realname_guide_helper", realnameGuideHelper);
                c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent2);
            }
            i.SB(this.jVv);
            finish();
            this.jVw.jUm.w(this.dXh, this.jYA, this.jVt).f(new com.tencent.mm.vending.c.a<Void, Void>() {
                /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass13 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(Void r4) {
                    AppMethodBeat.i(213111);
                    Log.i("MicroMsg.Aa.PaylistAAUI", "insert msg finish");
                    Void r0 = QZL;
                    AppMethodBeat.o(213111);
                    return r0;
                }
            });
            h.INSTANCE.idkeyStat(407, 12, 1, false);
            this.jVw.jUn.b(this.jYD, this.dFw, intent.getStringExtra("key_trans_id"));
        }
        AppMethodBeat.o(63742);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void hideLoading() {
        AppMethodBeat.i(63743);
        if (this.jUV != null && this.jUV.isShowing()) {
            this.jUV.dismiss();
            this.jUV = null;
        }
        AppMethodBeat.o(63743);
    }

    private void bmw() {
        AppMethodBeat.i(213130);
        if (Util.isNullOrNil(this.jYv)) {
            String string = getString(R.string.fke);
            com.tencent.mm.wallet_core.ui.f.a(this.jYt, string, 0, string.length(), new e(new e.a() {
                /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass17 */

                @Override // com.tencent.mm.wallet_core.ui.e.a
                public final void bmr() {
                    AppMethodBeat.i(213117);
                    PaylistAAUI.n(PaylistAAUI.this);
                    h.INSTANCE.a(13721, 4, 10, Integer.valueOf(PaylistAAUI.this.jUH));
                    AppMethodBeat.o(213117);
                }
            }), getContext());
            this.jYt.setVisibility(0);
            this.jYu.setVisibility(8);
            AppMethodBeat.o(213130);
            return;
        }
        String string2 = getString(R.string.fkf);
        String string3 = getString(R.string.b6m, new Object[]{this.jYv, string2});
        SpannableString c2 = l.c(this, string3);
        com.tencent.mm.wallet_core.ui.f.a(this.jYu, string3, c2.length() - string2.length(), c2.length(), new e(new e.a() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass18 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(213118);
                PaylistAAUI.n(PaylistAAUI.this);
                h.INSTANCE.a(13721, 4, 10, Integer.valueOf(PaylistAAUI.this.jUH));
                AppMethodBeat.o(213118);
            }
        }), getContext());
        this.jYt.setVisibility(8);
        this.jYu.setVisibility(0);
        AppMethodBeat.o(213130);
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(63744);
        Log.i("MicroMsg.Aa.PaylistAAUI", "click urgeAAPay");
        paylistAAUI.hideLoading();
        paylistAAUI.jUV = com.tencent.mm.wallet_core.ui.h.a((Context) paylistAAUI, false, (DialogInterface.OnCancelListener) null);
        com.tencent.mm.vending.g.g.hdG().c(paylistAAUI.jVw.jUp).f(new com.tencent.mm.vending.c.a<Void, Boolean>() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass11 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Boolean bool) {
                AppMethodBeat.i(213110);
                PaylistAAUI.this.hideLoading();
                if (bool.booleanValue()) {
                    Log.i("MicroMsg.Aa.PaylistAAUI", "urgeAAPay success");
                    PaylistAAUI.e(PaylistAAUI.this, PaylistAAUI.this.getContext().getString(R.string.hto));
                } else {
                    Log.i("MicroMsg.Aa.PaylistAAUI", "urgeAAPay fail");
                    PaylistAAUI.e(PaylistAAUI.this, PaylistAAUI.this.getContext().getString(R.string.htn));
                }
                Void r0 = QZL;
                AppMethodBeat.o(213110);
                return r0;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass10 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(213109);
                PaylistAAUI.this.hideLoading();
                if (!(obj instanceof String) || obj.toString().equalsIgnoreCase("ok")) {
                    PaylistAAUI.e(PaylistAAUI.this, PaylistAAUI.this.getContext().getString(R.string.htn));
                } else {
                    PaylistAAUI.e(PaylistAAUI.this, obj.toString());
                }
                Log.e("MicroMsg.Aa.PaylistAAUI", "urgeAAPay fail");
                AppMethodBeat.o(213109);
            }
        });
        h.INSTANCE.a(13721, 4, 8, Integer.valueOf(paylistAAUI.jUH));
        AppMethodBeat.o(63744);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, String str) {
        AppMethodBeat.i(213131);
        paylistAAUI.hideLoading();
        if (!Util.isNullOrNil(str)) {
            Toast.makeText(paylistAAUI, str, 1).show();
            AppMethodBeat.o(213131);
            return;
        }
        Toast.makeText(paylistAAUI, (int) R.string.a0, 1).show();
        AppMethodBeat.o(213131);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, final y yVar) {
        SpannableString spannableString;
        AppMethodBeat.i(63748);
        String str = yVar.KBQ;
        final String str2 = yVar.title;
        double o = i.o((double) yVar.KBR);
        final TextView textView = (TextView) paylistAAUI.findViewById(R.id.g_c);
        ao.a(textView.getPaint(), 0.8f);
        textView.setText(((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(yVar.KBQ) + paylistAAUI.getString(R.string.fko));
        a.b.c((ImageView) paylistAAUI.findViewById(R.id.g9s), str);
        final TextView textView2 = (TextView) paylistAAUI.findViewById(R.id.g_5);
        final TextView textView3 = (TextView) paylistAAUI.findViewById(R.id.g_6);
        ao.a(textView3.getPaint(), 0.8f);
        if (yVar.type == 4) {
            textView3.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) paylistAAUI.getContext(), 8);
            textView.setLayoutParams(layoutParams);
        } else {
            if (yVar.type != 2 || yVar.KCe <= yVar.KBR) {
                String string = paylistAAUI.getString(R.string.b9, new Object[]{Double.valueOf(o)});
                String str3 = paylistAAUI.getString(R.string.fkn) + string;
                spannableString = new SpannableString(str3);
                WcPayTextApppearanceSpan wcPayTextApppearanceSpan = new WcPayTextApppearanceSpan((int) textView3.getTextSize(), ColorStateList.valueOf(paylistAAUI.getResources().getColor(R.color.FG_1)));
                wcPayTextApppearanceSpan.IoX = com.tencent.mm.wallet_core.ui.f.aS(paylistAAUI.getContext(), 7);
                spannableString.setSpan(wcPayTextApppearanceSpan, str3.lastIndexOf(string), string.length() + str3.lastIndexOf(string), 17);
            } else {
                String string2 = paylistAAUI.getString(R.string.b9, new Object[]{Double.valueOf(i.o((double) yVar.KCe))});
                String string3 = paylistAAUI.getString(R.string.b9, new Object[]{Double.valueOf(i.o((double) yVar.KBR))});
                String str4 = paylistAAUI.getString(R.string.fkn) + string2 + paylistAAUI.getString(R.string.fkk) + string3;
                spannableString = new SpannableString(str4);
                WcPayTextApppearanceSpan wcPayTextApppearanceSpan2 = new WcPayTextApppearanceSpan((int) textView3.getTextSize(), ColorStateList.valueOf(paylistAAUI.getResources().getColor(R.color.FG_1)));
                wcPayTextApppearanceSpan2.IoX = com.tencent.mm.wallet_core.ui.f.aS(paylistAAUI.getContext(), 7);
                WcPayTextApppearanceSpan wcPayTextApppearanceSpan3 = new WcPayTextApppearanceSpan((int) textView3.getTextSize(), ColorStateList.valueOf(paylistAAUI.getResources().getColor(R.color.FG_1)));
                wcPayTextApppearanceSpan3.IoX = com.tencent.mm.wallet_core.ui.f.aS(paylistAAUI.getContext(), 7);
                spannableString.setSpan(wcPayTextApppearanceSpan2, str4.indexOf(string2), string2.length() + str4.indexOf(string2), 17);
                spannableString.setSpan(wcPayTextApppearanceSpan3, str4.lastIndexOf(string3), string3.length() + str4.lastIndexOf(string3), 17);
            }
            textView3.setText(spannableString);
            Log.i("MicroMsg.Aa.PaylistAAUI", "top title : %s", spannableString.toString());
        }
        textView3.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass25 */

            public final void run() {
                AppMethodBeat.i(63730);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView3.getLayoutParams();
                layoutParams.topMargin = textView.getHeight() + com.tencent.mm.cb.a.fromDPToPix((Context) PaylistAAUI.this.getContext(), 10);
                textView3.setLayoutParams(layoutParams);
                AppMethodBeat.o(63730);
            }
        }, 100);
        try {
            if (Util.isNullOrNil(yVar.KBA)) {
                paylistAAUI.a(textView2, l.c(paylistAAUI.getContext(), str2), "", yVar);
                AppMethodBeat.o(63748);
                return;
            }
            textView2.setClickable(true);
            textView2.setOnTouchListener(new o(paylistAAUI));
            textView2.post(new Runnable() {
                /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass26 */

                public final void run() {
                    AppMethodBeat.i(213123);
                    if (textView2.getMeasuredWidth() != 0) {
                        String str = "  " + PaylistAAUI.this.getString(R.string.fkl);
                        PaylistAAUI.a(PaylistAAUI.this, textView2, l.c(PaylistAAUI.this.getContext(), str + (" " + str2 + " ")), str, yVar);
                    }
                    AppMethodBeat.o(213123);
                }
            });
            AppMethodBeat.o(63748);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Aa.PaylistAAUI", e2, "", new Object[0]);
            AppMethodBeat.o(63748);
        }
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI, y yVar) {
        AppMethodBeat.i(63749);
        if (yVar.state == com.tencent.mm.plugin.aa.model.a.jRP) {
            paylistAAUI.jYw.setText(R.string.fkd);
            paylistAAUI.jYw.setTextColor(paylistAAUI.getResources().getColor(R.color.FG_1));
        } else if (yVar.state == com.tencent.mm.plugin.aa.model.a.jRQ) {
            paylistAAUI.jYw.setText(R.string.fkb);
            paylistAAUI.jYw.setTextColor(paylistAAUI.getResources().getColor(R.color.FG_1));
        } else if (yVar.role == com.tencent.mm.plugin.aa.model.a.jRT) {
            if (yVar.type == 4) {
                paylistAAUI.a(yVar);
            } else {
                paylistAAUI.jYm.setVisibility(8);
                paylistAAUI.jYl.setVisibility(0);
                paylistAAUI.jYw.setText(paylistAAUI.getString(R.string.fkp));
                paylistAAUI.jYw.setTextColor(paylistAAUI.getResources().getColor(R.color.FG_1));
                com.tencent.mm.plugin.aa.model.a.c SD = com.tencent.mm.plugin.aa.b.blZ().SD(yVar.KBs);
                if (SD != null) {
                    SD.field_status = jYH;
                    com.tencent.mm.plugin.aa.b.blZ().b(SD);
                }
            }
        } else if (yVar.role == com.tencent.mm.plugin.aa.model.a.jRS) {
            paylistAAUI.jYm.setVisibility(8);
            paylistAAUI.jYl.setVisibility(0);
            if (yVar.KBX == com.tencent.mm.plugin.aa.model.a.jRW) {
                paylistAAUI.jYw.setText(paylistAAUI.getString(R.string.fkc));
                paylistAAUI.jYw.setTextColor(paylistAAUI.getResources().getColor(R.color.a3g));
            } else if (yVar.KBX == com.tencent.mm.plugin.aa.model.a.jRV) {
                String string = paylistAAUI.getString(R.string.b9, new Object[]{Double.valueOf(i.o((double) yVar.KBT))});
                String str = paylistAAUI.getString(R.string.fkv) + string;
                SpannableString spannableString = new SpannableString(str);
                WcPayTextApppearanceSpan wcPayTextApppearanceSpan = new WcPayTextApppearanceSpan((int) paylistAAUI.jYw.getTextSize(), ColorStateList.valueOf(paylistAAUI.getResources().getColor(R.color.a3g)));
                wcPayTextApppearanceSpan.IoX = com.tencent.mm.wallet_core.ui.f.gA(paylistAAUI.getContext());
                spannableString.setSpan(wcPayTextApppearanceSpan, str.lastIndexOf(string), string.length() + str.lastIndexOf(string), 17);
                paylistAAUI.jYw.setText(spannableString);
                paylistAAUI.jYw.setTextColor(paylistAAUI.getResources().getColor(R.color.a3g));
            } else if (yVar.KBX == com.tencent.mm.plugin.aa.model.a.jRU) {
                String string2 = paylistAAUI.getString(R.string.fkx);
                String str2 = paylistAAUI.getString(R.string.fkv) + string2;
                SpannableString spannableString2 = new SpannableString(str2);
                WcPayTextApppearanceSpan wcPayTextApppearanceSpan2 = new WcPayTextApppearanceSpan((int) paylistAAUI.jYw.getTextSize(), ColorStateList.valueOf(paylistAAUI.getResources().getColor(R.color.a3g)));
                wcPayTextApppearanceSpan2.IoX = com.tencent.mm.wallet_core.ui.f.gA(paylistAAUI.getContext());
                spannableString2.setSpan(wcPayTextApppearanceSpan2, str2.lastIndexOf(string2), string2.length() + str2.lastIndexOf(string2), 17);
                paylistAAUI.jYw.setText(spannableString2);
            } else {
                Log.e("MicroMsg.Aa.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", Integer.valueOf(yVar.state), Integer.valueOf(yVar.type), Integer.valueOf(yVar.role));
                paylistAAUI.jYw.setVisibility(8);
            }
        } else if (yVar.role == com.tencent.mm.plugin.aa.model.a.jRR) {
            if (yVar.type == 4) {
                paylistAAUI.a(yVar);
            } else {
                w aQ = i.aQ(yVar.KBx);
                if (yVar.KBX == com.tencent.mm.plugin.aa.model.a.jRY || (aQ != null && aQ.KBP == com.tencent.mm.plugin.aa.model.a.jRY)) {
                    String format = String.format("%.2f", Double.valueOf(i.o((double) yVar.KBY)));
                    String string3 = paylistAAUI.getString(R.string.fk_);
                    paylistAAUI.jYD = yVar.KBY;
                    int i2 = yVar.state;
                    paylistAAUI.jYm.setVisibility(0);
                    paylistAAUI.jYl.setVisibility(8);
                    paylistAAUI.jYs = (Button) paylistAAUI.jYm.findViewById(R.id.g_2);
                    paylistAAUI.jYt = (TextView) paylistAAUI.jYm.findViewById(R.id.g9r);
                    paylistAAUI.jYu = (TextView) paylistAAUI.jYm.findViewById(R.id.g_0);
                    paylistAAUI.jYp = (LinearLayout) paylistAAUI.findViewById(R.id.g_1);
                    paylistAAUI.bmw();
                    if (i2 == com.tencent.mm.plugin.aa.model.a.jRP || i2 == com.tencent.mm.plugin.aa.model.a.jRQ) {
                        paylistAAUI.jYs.setVisibility(8);
                        paylistAAUI.jYu.setVisibility(8);
                    } else {
                        paylistAAUI.jYu.setVisibility(0);
                    }
                    paylistAAUI.jYs.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass4 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(213103);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/PaylistAAUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.Aa.PaylistAAUI", "click mInstantPayBtn");
                            PaylistAAUI.a(PaylistAAUI.this, PaylistAAUI.this.jYD);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(213103);
                        }
                    });
                    paylistAAUI.jYp.setVisibility(0);
                    paylistAAUI.jYr = (WalletTextView) paylistAAUI.findViewById(R.id.fus);
                    paylistAAUI.jYr.setPrefix(ah.hhz());
                    paylistAAUI.jYr.setText(format);
                    ((TextView) paylistAAUI.jYm.findViewById(R.id.g_4)).setText(string3);
                } else if (yVar.KBX == com.tencent.mm.plugin.aa.model.a.jRZ || (aQ != null && aQ.KBP == com.tencent.mm.plugin.aa.model.a.jRZ)) {
                    paylistAAUI.jYm.setVisibility(8);
                    paylistAAUI.jYl.setVisibility(0);
                    String string4 = paylistAAUI.getString(R.string.b9, new Object[]{Double.valueOf(i.o((double) yVar.KBY))});
                    String str3 = paylistAAUI.getString(R.string.fkr) + string4;
                    SpannableString spannableString3 = new SpannableString(str3);
                    WcPayTextApppearanceSpan wcPayTextApppearanceSpan3 = new WcPayTextApppearanceSpan((int) paylistAAUI.jYw.getTextSize(), ColorStateList.valueOf(paylistAAUI.getResources().getColor(R.color.a3g)));
                    wcPayTextApppearanceSpan3.IoX = com.tencent.mm.wallet_core.ui.f.gA(paylistAAUI.getContext());
                    spannableString3.setSpan(wcPayTextApppearanceSpan3, str3.lastIndexOf(string4), string4.length() + str3.lastIndexOf(string4), 17);
                    paylistAAUI.jYw.setText(spannableString3);
                    paylistAAUI.jYw.setTextColor(paylistAAUI.getResources().getColor(R.color.a3g));
                } else {
                    Log.e("MicroMsg.Aa.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", Integer.valueOf(yVar.state), Integer.valueOf(yVar.type), Integer.valueOf(yVar.role));
                    paylistAAUI.jYm.setVisibility(8);
                    paylistAAUI.jYw.setVisibility(8);
                }
            }
        }
        if (yVar.role == com.tencent.mm.plugin.aa.model.a.jRS && (yVar.state == com.tencent.mm.plugin.aa.model.a.jRP || yVar.state == com.tencent.mm.plugin.aa.model.a.jRQ || yVar.KBX == com.tencent.mm.plugin.aa.model.a.jRW)) {
            paylistAAUI.jYx.setText(paylistAAUI.getString(R.string.fkt, new Object[]{Double.valueOf(i.o((double) yVar.KBT))}));
            paylistAAUI.jYx.setVisibility(0);
            AppMethodBeat.o(63749);
            return;
        }
        paylistAAUI.jYx.setVisibility(8);
        AppMethodBeat.o(63749);
    }

    static /* synthetic */ void c(PaylistAAUI paylistAAUI, y yVar) {
        AppMethodBeat.i(63750);
        List<w> arrayList = new ArrayList<>();
        List<w> arrayList2 = new ArrayList<>();
        Iterator<w> it = yVar.KBx.iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (next.KBP == com.tencent.mm.plugin.aa.model.a.jRY) {
                arrayList2.add(next);
            } else {
                arrayList.add(next);
            }
        }
        if (yVar.type == 4) {
            if (arrayList.isEmpty()) {
                paylistAAUI.jYn.setVisibility(8);
                paylistAAUI.jYo.setVisibility(8);
                paylistAAUI.jYy.setVisibility(P(yVar.role, yVar.KBX, yVar.state) ? 0 : 8);
                AppMethodBeat.o(63750);
                return;
            }
            paylistAAUI.jYn.setVisibility(8);
            paylistAAUI.a(arrayList, paylistAAUI.getString(R.string.fk5, new Object[]{Integer.valueOf(arrayList.size())}), P(yVar.role, yVar.KBX, yVar.state));
            AppMethodBeat.o(63750);
        } else if (arrayList2.isEmpty()) {
            paylistAAUI.a(arrayList, paylistAAUI.getString(R.string.fk5, new Object[]{Integer.valueOf(arrayList.size())}), P(yVar.role, yVar.KBX, yVar.state));
            paylistAAUI.jYn.setVisibility(8);
            AppMethodBeat.o(63750);
        } else if (arrayList.isEmpty()) {
            paylistAAUI.jYn.setVisibility(8);
            paylistAAUI.a(arrayList2, paylistAAUI.getString(R.string.fk4, new Object[]{Integer.valueOf(arrayList2.size())}), P(yVar.role, yVar.KBX, yVar.state));
            AppMethodBeat.o(63750);
        } else {
            paylistAAUI.jYn.setVisibility(8);
            String string = paylistAAUI.getString(R.string.fk6, new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size())});
            arrayList2.addAll(arrayList);
            paylistAAUI.a(arrayList2, string, P(yVar.role, yVar.KBX, yVar.state));
            AppMethodBeat.o(63750);
        }
    }

    static /* synthetic */ void d(PaylistAAUI paylistAAUI, final y yVar) {
        AppMethodBeat.i(213132);
        paylistAAUI.addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass24 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(63725);
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) PaylistAAUI.this, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass24.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(63722);
                        mVar.add(0, 1, 1, R.string.fkz);
                        if (!Util.isNullOrNil(PaylistAAUI.this.jYA) && PaylistAAUI.this.jYA.equals(z.aTY()) && yVar.state == com.tencent.mm.plugin.aa.model.a.jRO && yVar.KBT < yVar.KBR) {
                            mVar.a(2, PaylistAAUI.this.getContext().getResources().getColor(R.color.Red), PaylistAAUI.this.getString(R.string.r));
                        }
                        if (!Util.isNullOrNil(PaylistAAUI.this.jYA) && PaylistAAUI.this.jYA.equals(z.aTY()) && yVar.state == com.tencent.mm.plugin.aa.model.a.jRO && yVar.type == 4) {
                            mVar.a(2, PaylistAAUI.this.getContext().getResources().getColor(R.color.Red), PaylistAAUI.this.getString(R.string.r));
                        }
                        AppMethodBeat.o(63722);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass24.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        int i3;
                        AppMethodBeat.i(63724);
                        switch (menuItem.getItemId()) {
                            case 1:
                                if (!Util.isNullOrNil(PaylistAAUI.this.jVv)) {
                                    if (as.bjq(PaylistAAUI.this.jVv)) {
                                        com.tencent.mm.ui.base.h.a((Context) PaylistAAUI.this.getContext(), PaylistAAUI.this.getString(R.string.is_), "", PaylistAAUI.this.getString(R.string.j34), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass24.AnonymousClass2.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(63723);
                                                Log.i("MicroMsg.Aa.PaylistAAUI", "onDialogClick() ");
                                                AppMethodBeat.o(63723);
                                            }
                                        });
                                    } else {
                                        Log.i("MicroMsg.Aa.PaylistAAUI", "click OptionsMenu launchAAUI");
                                        Intent intent = new Intent(PaylistAAUI.this.getContext(), LaunchAAUI.class);
                                        intent.putExtra("enter_scene", 3);
                                        intent.putExtra("chatroom_name", PaylistAAUI.this.jVv);
                                        PaylistAAUI paylistAAUI = PaylistAAUI.this;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(paylistAAUI, bl.axQ(), "com/tencent/mm/plugin/aa/ui/PaylistAAUI$6$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        paylistAAUI.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(paylistAAUI, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$6$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    }
                                }
                                if (yVar.role == com.tencent.mm.plugin.aa.model.a.jRS) {
                                    i3 = 1;
                                } else if (yVar.role == com.tencent.mm.plugin.aa.model.a.jRR) {
                                    i3 = 2;
                                } else {
                                    i3 = 3;
                                }
                                h.INSTANCE.a(13721, 7, Integer.valueOf(i3));
                                AppMethodBeat.o(63724);
                                return;
                            case 2:
                                Log.i("MicroMsg.Aa.PaylistAAUI", "click OptionsMenu stop AA");
                                h.INSTANCE.a(13721, 4, 5, Integer.valueOf(PaylistAAUI.this.jUH));
                                com.tencent.mm.ui.base.h.a(PaylistAAUI.this, (int) R.string.q, -1, (int) R.string.u, (int) R.string.sz, new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass24.AnonymousClass2.AnonymousClass2 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(182449);
                                        PaylistAAUI.f(PaylistAAUI.this);
                                        AppMethodBeat.o(182449);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                break;
                        }
                        AppMethodBeat.o(63724);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(63725);
                return true;
            }
        });
        AppMethodBeat.o(213132);
    }

    static /* synthetic */ void e(PaylistAAUI paylistAAUI, y yVar) {
        AppMethodBeat.i(213133);
        if (yVar.role != com.tencent.mm.plugin.aa.model.a.jRS || Util.isNullOrNil(yVar.KBQ) || !yVar.KBQ.equals(z.aTY())) {
            paylistAAUI.jYz.setVisibility(8);
            paylistAAUI.jYq.setPadding(0, 0, 0, at.fromDPToPix(paylistAAUI.getContext(), 32));
        } else {
            paylistAAUI.jYz.setVisibility(0);
            paylistAAUI.jYq.setPadding(0, 0, 0, at.fromDPToPix(paylistAAUI.getContext(), 24));
        }
        if (paylistAAUI.jYz.getVisibility() != 0) {
            Log.i("MicroMsg.Aa.PaylistAAUI", "no need to show bottom tv");
            AppMethodBeat.o(213133);
        } else if (Util.isNullOrNil(yVar.KCc)) {
            Log.i("MicroMsg.Aa.PaylistAAUI", "wording is null");
            AppMethodBeat.o(213133);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(yVar.KCc);
            if (yVar.KCd == 1) {
                paylistAAUI.jYz.setClickable(true);
                String str = yVar.KCc;
                com.tencent.mm.wallet_core.ui.f.a(paylistAAUI.jYz, str, 0, str.length(), new e(new e.a() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass23 */

                    @Override // com.tencent.mm.wallet_core.ui.e.a
                    public final void bmr() {
                        AppMethodBeat.i(63721);
                        Log.i("MicroMsg.Aa.PaylistAAUI", "onClick() mBottomTipTv");
                        Intent intent = new Intent();
                        intent.putExtra("key_scene_balance_manager", 0);
                        c.b(PaylistAAUI.this, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
                        h.INSTANCE.a(13721, 4, 4, Integer.valueOf(PaylistAAUI.this.jUH));
                        AppMethodBeat.o(63721);
                    }
                }), paylistAAUI.getContext());
                AppMethodBeat.o(213133);
                return;
            }
            paylistAAUI.jYz.setText(spannableStringBuilder);
            AppMethodBeat.o(213133);
        }
    }

    static /* synthetic */ void f(PaylistAAUI paylistAAUI, final y yVar) {
        AppMethodBeat.i(213134);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(paylistAAUI.getString(R.string.fky));
        spannableStringBuilder.setSpan(new e(new e.a() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass19 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                int i2;
                AppMethodBeat.i(213120);
                Log.i("MicroMsg.Aa.PaylistAAUI", "click AlertMsgTips");
                f.a aVar = new f.a(PaylistAAUI.this);
                aVar.aC(PaylistAAUI.this.getString(R.string.htm));
                View inflate = aa.jQ(PaylistAAUI.this).inflate(R.layout.c51, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.dup);
                TextView textView = (TextView) inflate.findViewById(R.id.ijq);
                if (yVar.type == 4) {
                    imageView.setImageResource(R.drawable.ck1);
                    i2 = R.string.htk;
                } else {
                    imageView.setImageResource(R.drawable.ck0);
                    i2 = R.string.htj;
                }
                if (!ab.Eq(PaylistAAUI.this.jVv)) {
                    i2 = R.string.htl;
                }
                textView.setText(i2);
                aVar.hu(inflate);
                aVar.apa(R.string.yq);
                aVar.boB(PaylistAAUI.this.getString(R.string.ay));
                aVar.JnN = false;
                aVar.a(new f.c() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass19.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                    }
                }, new f.c() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass19.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(213119);
                        PaylistAAUI.b(PaylistAAUI.this);
                        AppMethodBeat.o(213119);
                    }
                });
                aVar.show();
                h.INSTANCE.a(13721, 4, 7, Integer.valueOf(PaylistAAUI.this.jUH));
                AppMethodBeat.o(213120);
            }
        }), 0, spannableStringBuilder.length(), 18);
        paylistAAUI.jYy.setText(spannableStringBuilder);
        AppMethodBeat.o(213134);
    }

    static /* synthetic */ void f(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(213135);
        paylistAAUI.hideLoading();
        if (paylistAAUI.jUC != null && paylistAAUI.jUC.isShowing()) {
            paylistAAUI.jUC.dismiss();
        }
        if (paylistAAUI.jUC == null) {
            paylistAAUI.jUC = com.tencent.mm.ui.base.h.a((Context) paylistAAUI, 3, (int) R.style.lj, paylistAAUI.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(213106);
                    if (PaylistAAUI.this.jUC != null && PaylistAAUI.this.jUC.isShowing()) {
                        PaylistAAUI.this.jUC.dismiss();
                    }
                    AppMethodBeat.o(213106);
                }
            });
        }
        com.tencent.mm.vending.g.g.hdG().c(paylistAAUI.jVw.jUo).f(new com.tencent.mm.vending.c.a<Void, Boolean>() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass9 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Boolean bool) {
                AppMethodBeat.i(213108);
                Log.i("MicroMsg.Aa.PaylistAAUI", "close pay list success: %s", bool);
                PaylistAAUI.this.hideLoading();
                if (PaylistAAUI.this.jUC != null && PaylistAAUI.this.jUC.isShowing()) {
                    PaylistAAUI.this.jUC.dismiss();
                }
                PaylistAAUI.this.jYA = null;
                PaylistAAUI.k(PaylistAAUI.this);
                PaylistAAUI.this.removeAllOptionMenu();
                PaylistAAUI.l(PaylistAAUI.this);
                Void r0 = QZL;
                AppMethodBeat.o(213108);
                return r0;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass8 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(213107);
                Log.i("MicroMsg.Aa.PaylistAAUI", "close pay list failed: %s", obj);
                PaylistAAUI.this.hideLoading();
                if (PaylistAAUI.this.jUC != null && PaylistAAUI.this.jUC.isShowing()) {
                    PaylistAAUI.this.jUC.dismiss();
                }
                if (obj instanceof String) {
                    Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
                    AppMethodBeat.o(213107);
                    return;
                }
                Toast.makeText(PaylistAAUI.this, (int) R.string.b5y, 1).show();
                AppMethodBeat.o(213107);
            }
        });
        h.INSTANCE.a(13721, 4, 6, Integer.valueOf(paylistAAUI.jUH));
        AppMethodBeat.o(213135);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, long j2) {
        AppMethodBeat.i(213137);
        paylistAAUI.jUV = com.tencent.mm.wallet_core.ui.h.a((Context) paylistAAUI, false, (DialogInterface.OnCancelListener) null);
        double d2 = Util.getDouble(paylistAAUI.jYr.getText().toString(), 0.0d);
        paylistAAUI.jVw.jUl.j(j2, paylistAAUI.jYv).f(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.protocal.protobuf.r>() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(com.tencent.mm.protocal.protobuf.r rVar) {
                AppMethodBeat.i(63715);
                final com.tencent.mm.protocal.protobuf.r rVar2 = rVar;
                if (!PaylistAAUI.this.mKindaEnable) {
                    PaylistAAUI.this.hideLoading();
                }
                if (rVar2 != null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = rVar2.KBE;
                    objArr[1] = Integer.valueOf(rVar2.KBE != null ? rVar2.KBE.cSx : 0);
                    Log.i("MicroMsg.Aa.PaylistAAUI", "aapay return, alertItem: %s, alertItem.flag: %s", objArr);
                    if (rVar2.KBE == null || rVar2.KBE.cSx != 1) {
                        Log.d("MicroMsg.Aa.PaylistAAUI", "aapay return, reqKey: %s", rVar2.wFL);
                        PaylistAAUI.a(PaylistAAUI.this, rVar2);
                    } else {
                        String str = rVar2.KBE.dQx;
                        String str2 = rVar2.KBE.lHA;
                        String str3 = rVar2.KBE.lHB;
                        d.a aVar = new d.a(PaylistAAUI.this);
                        aVar.boo(str);
                        aVar.bou(str3).c(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass6.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(213105);
                                PaylistAAUI.a(PaylistAAUI.this, rVar2);
                                PaylistAAUI.this.jUV = com.tencent.mm.wallet_core.ui.h.b(PaylistAAUI.this, false, null);
                                AppMethodBeat.o(213105);
                            }
                        });
                        aVar.bov(str2);
                        aVar.hbn().show();
                        PaylistAAUI.this.hideLoading();
                    }
                }
                Void r0 = QZL;
                AppMethodBeat.o(63715);
                return r0;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass5 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(63714);
                Log.i("MicroMsg.Aa.PaylistAAUI", "aapay failed: %s", obj);
                PaylistAAUI.this.hideLoading();
                if (obj == null) {
                    Toast.makeText(PaylistAAUI.this, PaylistAAUI.this.getString(R.string.ap), 1).show();
                } else if (obj instanceof com.tencent.mm.protocal.protobuf.a) {
                    final com.tencent.mm.protocal.protobuf.a aVar = (com.tencent.mm.protocal.protobuf.a) obj;
                    String str = aVar.dQx;
                    String str2 = aVar.lHA;
                    String str3 = aVar.lHB;
                    d.a aVar2 = new d.a(PaylistAAUI.this);
                    aVar2.boo(str);
                    aVar2.bou(str3).c(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(213104);
                            Log.i("MicroMsg.Aa.PaylistAAUI", "click aaPay onInterrupt AAAlertItem");
                            com.tencent.mm.wallet_core.ui.f.p(PaylistAAUI.this.getContext(), aVar.qwt, false);
                            AppMethodBeat.o(213104);
                        }
                    });
                    aVar2.bov(str2);
                    aVar2.hbn().show();
                    AppMethodBeat.o(63714);
                    return;
                } else if ((obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                    Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
                    AppMethodBeat.o(63714);
                    return;
                }
                AppMethodBeat.o(63714);
            }
        });
        h.INSTANCE.a(13721, 4, 9, Integer.valueOf(paylistAAUI.jUH));
        h.INSTANCE.a(13723, 3, Integer.valueOf(i.SA(paylistAAUI.jVv).size()), Integer.valueOf(paylistAAUI.jYC), Double.valueOf(d2 * 100.0d), paylistAAUI.title);
        AppMethodBeat.o(213137);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, com.tencent.mm.protocal.protobuf.r rVar) {
        boolean z = true;
        AppMethodBeat.i(213138);
        Log.i("MicroMsg.Aa.PaylistAAUI", "click doPay");
        if (paylistAAUI.getIntent().getIntExtra("enter_scene", 0) != 1) {
            z = false;
        }
        paylistAAUI.jVs = rVar.wFL;
        paylistAAUI.dXh = rVar.dXf;
        paylistAAUI.jVt = rVar.KBu;
        paylistAAUI.dFw = rVar.KBM;
        i.a(paylistAAUI, paylistAAUI.jVs, z, rVar.Cpg, paylistAAUI.jYA);
        AppMethodBeat.o(213138);
    }

    static /* synthetic */ void l(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(213140);
        Intent intent = new Intent();
        intent.putExtra("close_aa", true);
        intent.putExtra("item_position", paylistAAUI.getIntent().getIntExtra("item_position", 0));
        intent.putExtra("item_offset", paylistAAUI.getIntent().getIntExtra("item_offset", 0));
        paylistAAUI.setResult(-1, intent);
        AppMethodBeat.o(213140);
    }

    static /* synthetic */ void e(PaylistAAUI paylistAAUI, String str) {
        AppMethodBeat.i(213141);
        com.tencent.mm.ui.base.h.a(paylistAAUI.getContext(), str, "", paylistAAUI.getContext().getString(R.string.ed6), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass20 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(213121);
                Log.i("MicroMsg.Aa.PaylistAAUI", "click AlertDialog");
                AppMethodBeat.o(213121);
            }
        });
        AppMethodBeat.o(213141);
    }

    static /* synthetic */ void n(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(213143);
        paylistAAUI.showCircleStWcKb();
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(paylistAAUI, paylistAAUI.getString(R.string.ax), paylistAAUI.jYv, paylistAAUI.getString(R.string.g1o), true, 20, new h.b() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass14 */

            @Override // com.tencent.mm.ui.base.h.b
            public final boolean onFinish(CharSequence charSequence) {
                AppMethodBeat.i(213113);
                if (!Util.isNullOrNil(charSequence.toString())) {
                    PaylistAAUI.this.jYv = charSequence.toString();
                    PaylistAAUI.m(PaylistAAUI.this);
                } else {
                    PaylistAAUI.this.jYv = null;
                    PaylistAAUI.m(PaylistAAUI.this);
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass14.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213112);
                        PaylistAAUI.this.hideVKB();
                        AppMethodBeat.o(213112);
                    }
                }, 500);
                AppMethodBeat.o(213113);
                return true;
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass15 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(213115);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass15.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213114);
                        PaylistAAUI.this.hideVKB();
                        AppMethodBeat.o(213114);
                    }
                }, 500);
                AppMethodBeat.o(213115);
            }
        });
        paylistAAUI.jYp.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.aa.ui.PaylistAAUI.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(213116);
                InputMethodManager inputMethodManager = (InputMethodManager) PaylistAAUI.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.toggleSoftInput(0, 2);
                }
                AppMethodBeat.o(213116);
            }
        }, 300);
        AppMethodBeat.o(213143);
    }
}
