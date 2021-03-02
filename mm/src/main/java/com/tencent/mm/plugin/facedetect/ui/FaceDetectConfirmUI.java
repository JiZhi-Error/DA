package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.facedetect.b.l;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.flash.FaceFlashUI;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.plugin.flash.d.b;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.qqmusic.mediaplayer.PlayerException;

@a(3)
public class FaceDetectConfirmUI extends MMActivity implements i {
    private String appId;
    private int businessType;
    private String nlH;
    private String sPR = null;
    private String sPS = null;
    private String sPT = null;
    private float sPU;
    private String sPW;
    private TextView sTb;
    private Button sTc;
    private CheckBox sTd;
    private TextView sTe;
    private TextView sTf;
    private dfb sTg = null;
    private String sTh;
    private int sTi;
    private int sTj;
    private ImageView sTk;
    private TextView sTl;
    private String sTm;
    private String sTn;
    private ViewGroup sTo;
    private long sTp = 0;
    private q tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FaceDetectConfirmUI faceDetectConfirmUI) {
        AppMethodBeat.i(103898);
        faceDetectConfirmUI.cTA();
        AppMethodBeat.o(103898);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a5q;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(103890);
        super.onCreate(bundle);
        b.dLi().erc = System.currentTimeMillis();
        this.appId = getIntent().getStringExtra("appId");
        this.sTh = getIntent().getStringExtra("request_verify_pre_info");
        this.nlH = getIntent().getStringExtra("key_function_name");
        this.businessType = getIntent().getIntExtra("key_business_type", -1);
        this.sTi = getIntent().getIntExtra("check_alive_type", 0);
        this.sTp = System.currentTimeMillis();
        Log.i("MicroMsg.FaceDetectConfirmUI", "appId:%s jsonData:%s functionName:%s businessType:%s check_alive_type_request:%s", this.appId, this.sTh, this.nlH, Integer.valueOf(this.businessType), Integer.valueOf(this.sTi));
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(103882);
                Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
                FaceDetectConfirmUI.a(FaceDetectConfirmUI.this);
                AppMethodBeat.o(103882);
                return false;
            }
        });
        this.sTb = (TextView) findViewById(R.id.c8x);
        this.sTc = (Button) findViewById(R.id.i4i);
        this.sTk = (ImageView) findViewById(R.id.to);
        this.sTl = (TextView) findViewById(R.id.tp);
        this.sTo = (ViewGroup) findViewById(R.id.c8z);
        this.sTo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(186379);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FaceDetectConfirmUI.this.sTd.setChecked(!FaceDetectConfirmUI.this.sTd.isChecked());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(186379);
            }
        });
        this.sTd = (CheckBox) findViewById(R.id.c8y);
        this.sTd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass7 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(186380);
                if (z) {
                    FaceDetectConfirmUI.this.sTc.setEnabled(true);
                    AppMethodBeat.o(186380);
                    return;
                }
                FaceDetectConfirmUI.this.sTc.setEnabled(false);
                AppMethodBeat.o(186380);
            }
        });
        this.sTd.setVisibility(8);
        this.sTe = (TextView) findViewById(R.id.c90);
        this.sTe.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(103885);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FaceDetectConfirmUI.this.sTd.setChecked(!FaceDetectConfirmUI.this.sTd.isChecked());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(103885);
            }
        });
        this.sTf = (TextView) findViewById(R.id.c8w);
        this.sTc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(186381);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", Integer.valueOf(FaceDetectConfirmUI.this.sTj));
                if (!p.ai(FaceDetectConfirmUI.this)) {
                    Log.e("MicroMsg.FaceDetectConfirmUI", "carson: no camera permission. request permission");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(186381);
                    return;
                }
                Bundle extras = FaceDetectConfirmUI.this.getIntent().getExtras();
                if (extras != null) {
                    extras.putInt("check_alive_type", FaceDetectConfirmUI.this.sTj);
                    extras.putString("appId", FaceDetectConfirmUI.this.appId);
                    extras.putString("feedbackUrl", FaceDetectConfirmUI.this.sPS);
                    extras.putString("business_tips", FaceDetectConfirmUI.this.sPW);
                    extras.putFloat("mLight_threshold", FaceDetectConfirmUI.this.sPU);
                    extras.putLong("confirm_page_timestamp", FaceDetectConfirmUI.this.sTp);
                    Log.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.this.sTj);
                    FaceFlashUI.a(FaceDetectConfirmUI.this, extras, 1);
                } else {
                    Log.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(186381);
            }
        });
        Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.tipDialog = h.a((Context) context, getString(R.string.a06), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass10 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        l lVar = new l(this.appId, this.sTh, this.sTi);
        g.azz().a(1147, this);
        g.azz().a(lVar, 0);
        b.C1358b.dLm().dLl();
        com.tencent.mm.plugin.flash.c.b.MY(1);
        AppMethodBeat.o(103890);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(103891);
        Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        com.tencent.mm.plugin.flash.c.b.s("confirmCode", Integer.valueOf(i2));
        com.tencent.mm.plugin.flash.c.b.s("confirmMsg", str);
        if (i2 == 0 && i3 == 0) {
            this.sTg = ((l) qVar).sPO;
            this.sPR = ((l) qVar).sPR;
            this.sPS = ((l) qVar).sPS;
            this.sPT = ((l) qVar).sPT;
            this.sPU = ((l) qVar).sPU;
            this.sTj = ((l) qVar).sPV;
            this.sPW = ((l) qVar).sPW;
            this.sTm = ((l) qVar).sPP;
            this.sTn = ((l) qVar).sPQ;
            Log.d("MicroMsg.FaceDetectConfirmUI", qVar.toString());
            if (Util.isNullOrNil(this.sPR)) {
                this.sPR = getString(R.string.c4q);
            }
            dismissDialog();
            this.sTc.setEnabled(true);
            this.sTb.setText(this.sPR);
            this.sTl.setText(String.format(getString(R.string.c4r), this.sTn));
            com.tencent.mm.av.q.bcV().loadImage(this.sTm, this.sTk);
            if (this.sTg != null) {
                Log.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", this.sTg.dQx, this.sTg.LGp, this.sTg.url);
                final dfb dfb = this.sTg;
                Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", dfb.dQx);
                String string = Util.isNullOrNil(dfb.dQx) ? getString(R.string.c4o) : dfb.dQx;
                String string2 = Util.isNullOrNil(dfb.LGp) ? getString(R.string.c4n) : dfb.LGp;
                Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(string + string2);
                newSpannable.setSpan(new ClickableSpan() {
                    /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass12 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(103889);
                        if (!Util.isNullOrNil(dfb.url)) {
                            FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, dfb.url);
                            AppMethodBeat.o(103889);
                            return;
                        }
                        Log.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
                        AppMethodBeat.o(103889);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.i(186383);
                        textPaint.setColor(FaceDetectConfirmUI.this.getResources().getColor(R.color.x0));
                        AppMethodBeat.o(186383);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.sTd.setVisibility(0);
                this.sTe.setVisibility(0);
                this.sTe.setText(newSpannable);
                this.sTe.setMovementMethod(LinkMovementMethod.getInstance());
                if (dfb.MKc == 0) {
                    this.sTd.setChecked(false);
                    this.sTc.setEnabled(false);
                } else if (dfb.MKc == 1) {
                    this.sTd.setChecked(true);
                    this.sTc.setEnabled(true);
                }
                this.sTf.setText(getString(R.string.c4l));
                this.sTf.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass13 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(186384);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        try {
                            Object[] objArr = new Object[1];
                            objArr[0] = FaceDetectConfirmUI.this.appId != null ? FaceDetectConfirmUI.this.appId : "";
                            String str = FaceDetectConfirmUI.this.sPT + "?customInfo=" + com.tencent.mm.compatible.util.q.encode(String.format("appid=%s", objArr), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                            Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", str);
                            FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, str);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", e2, "alvinluo jumpToWebView exception", new Object[0]);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(186384);
                    }
                });
                this.sTf.setVisibility(0);
            }
        } else {
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.c60);
            }
            dismissDialog();
            h.a((Context) this, str, getString(R.string.zb), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(186382);
                    Intent intent = new Intent();
                    intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.HL(90022));
                    intent.putExtra("err_msg", "get confirm info error");
                    FaceDetectReporter.cTe().ad(FaceDetectConfirmUI.this.businessType, 2, 90022);
                    com.tencent.mm.plugin.flash.c.b.MW(90022);
                    FaceDetectReporter.cTe().sRB = System.currentTimeMillis();
                    FaceDetectReporter.cTe().dr(FaceDetectConfirmUI.this.nlH, FaceDetectConfirmUI.this.businessType);
                    FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, intent);
                    FaceDetectConfirmUI.this.finish();
                    AppMethodBeat.o(186382);
                }
            });
        }
        g.azz().b(1147, this);
        AppMethodBeat.o(103891);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(103892);
        Log.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        FaceDetectReporter.cTe().sRB = System.currentTimeMillis();
        if (intent.hasExtra("err_code")) {
            intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.HL(intent.getIntExtra("err_code", -1)));
        }
        setResult(i3, intent);
        finish();
        AppMethodBeat.o(103892);
    }

    private void cTA() {
        AppMethodBeat.i(103893);
        Intent intent = new Intent();
        intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.HL(90024));
        intent.putExtra("err_msg", "user cancel in confirm ui");
        FaceDetectReporter.cTe().ad(this.businessType, 1, 90024);
        com.tencent.mm.plugin.flash.c.b.s("msgVerify", "user cancel in confirm ui");
        com.tencent.mm.plugin.flash.c.b.MW(90024);
        FaceDetectReporter.cTe().sRB = System.currentTimeMillis();
        FaceDetectReporter.cTe().dr(this.nlH, this.businessType);
        setResult(0, intent);
        finish();
        AppMethodBeat.o(103893);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(103894);
        cTA();
        super.onBackPressed();
        AppMethodBeat.o(103894);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(103895);
        dismissDialog();
        super.finish();
        AppMethodBeat.o(103895);
    }

    private void dismissDialog() {
        AppMethodBeat.i(103896);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(103896);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(103897);
        super.onDestroy();
        b.C1358b.dLm().stop();
        AppMethodBeat.o(103897);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(186385);
        Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(186385);
            return;
        }
        switch (i2) {
            case 16:
                if (iArr[0] == 0) {
                    this.sTc.performClick();
                    AppMethodBeat.o(186385);
                    return;
                }
                h.a((Context) this, getString(R.string.c6b), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(186375);
                        dialogInterface.dismiss();
                        FaceDetectConfirmUI faceDetectConfirmUI = FaceDetectConfirmUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(faceDetectConfirmUI, bl.axQ(), "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        faceDetectConfirmUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(faceDetectConfirmUI, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(186375);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(186376);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(186376);
                    }
                });
                AppMethodBeat.o(186385);
                return;
            case 18:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.c6c), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(186377);
                            dialogInterface.dismiss();
                            FaceDetectConfirmUI faceDetectConfirmUI = FaceDetectConfirmUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(faceDetectConfirmUI, bl.axQ(), "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            faceDetectConfirmUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(faceDetectConfirmUI, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(186377);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(186378);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(186378);
                        }
                    });
                    break;
                } else {
                    this.sTc.performClick();
                    AppMethodBeat.o(186385);
                    return;
                }
        }
        AppMethodBeat.o(186385);
    }

    static /* synthetic */ void a(FaceDetectConfirmUI faceDetectConfirmUI, Intent intent) {
        AppMethodBeat.i(186386);
        faceDetectConfirmUI.setResult(-1, intent);
        AppMethodBeat.o(186386);
    }

    static /* synthetic */ void a(FaceDetectConfirmUI faceDetectConfirmUI, String str) {
        AppMethodBeat.i(186387);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FaceDetectConfirmUI", "alvinluo jumpToWebView url is null");
            AppMethodBeat.o(186387);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("geta8key_username", z.aTY());
        c.b(faceDetectConfirmUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(186387);
    }
}
