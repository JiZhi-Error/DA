package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetectaction.a.c;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectaction.ui.a;
import com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.a.g;
import java.util.ArrayList;
import java.util.List;

public class FaceAgreementUI extends MMActivity implements i {
    private Dialog mProgressDialog = null;
    private g qAx;
    private TextView sYH;
    private Button sYI;
    private LinearLayout sYJ;
    private TextView sYK;
    private TextView sYL;
    private TextView sYM;
    private ImageView sYN;
    private String sYO = "";
    private boolean sYP = false;
    private boolean sYQ = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a5p;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(186406);
        super.onCreate(bundle);
        this.sYH = (TextView) findViewById(R.id.c8i);
        this.sYI = (Button) findViewById(R.id.c8p);
        this.sYJ = (LinearLayout) findViewById(R.id.c8m);
        this.sYK = (TextView) findViewById(R.id.c8n);
        this.sYL = (TextView) findViewById(R.id.c8o);
        ao.a(this.sYL.getPaint(), 0.8f);
        this.sYI.setEnabled(true);
        this.sYI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(186398);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.FaceAgreementUI", "needShowProtocal : %s", Boolean.valueOf(FaceAgreementUI.this.sYP));
                if (FaceAgreementUI.this.sYP) {
                    FaceAgreementUI.b(FaceAgreementUI.this);
                } else {
                    Intent intent = new Intent(FaceAgreementUI.this, FaceFlashPermissionUI.class);
                    Bundle extras = FaceAgreementUI.this.getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    FaceAgreementUI.this.startActivityForResult(intent, 1);
                    h.INSTANCE.idkeyStat(917, 67, 1, false);
                }
                a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(186398);
            }
        });
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        getSupportActionBar().hide();
        this.sYN = (ImageView) findViewById(R.id.c8h);
        this.sYN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(186399);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FaceAgreementUI.c(FaceAgreementUI.this);
                a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(186399);
            }
        });
        this.mProgressDialog = com.tencent.mm.ui.base.h.a((Context) getContext(), getContext().getString(R.string.ekd), false, (DialogInterface.OnCancelListener) null);
        com.tencent.mm.kernel.g.azz().a(1108, this);
        com.tencent.mm.kernel.g.azz().a(new c(getIntent().getIntExtra("scene", 0), getIntent().getStringExtra("package"), getIntent().getStringExtra("packageSign")), 0);
        AppMethodBeat.o(186406);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(final int i2, final int i3, final String str, final q qVar) {
        AppMethodBeat.i(186407);
        com.tencent.mm.kernel.g.azz().b(1108, this);
        com.tencent.mm.plugin.flash.c.b.dLj().eqS = i3;
        com.tencent.f.h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(186400);
                if (i2 == 0 && i3 == 0) {
                    FaceAgreementUI.d(FaceAgreementUI.this);
                    int i2 = ((c) qVar).sXj.LVW;
                    String str = ((c) qVar).sXj.LVX;
                    FaceAgreementUI.this.sYO = ((c) qVar).sXj.HZQ;
                    Log.i("MicroMsg.FaceAgreementUI", "[cgi-ret]contractRet:%s  tip:%s url:%s", Integer.valueOf(i2), str, FaceAgreementUI.this.sYO);
                    if (i2 == 1) {
                        FaceAgreementUI.this.sYP = false;
                        FaceAgreementUI.this.sYI.setEnabled(true);
                    } else if (TextUtils.isEmpty(FaceAgreementUI.this.sYO)) {
                        FaceAgreementUI.this.sYP = false;
                        FaceAgreementUI.this.sYJ.setVisibility(4);
                        FaceAgreementUI.this.sYI.setEnabled(true);
                    } else {
                        FaceAgreementUI.this.sYP = true;
                        d.sXz.sXI = true;
                    }
                    if (FaceAgreementUI.this.sYP) {
                        h.INSTANCE.idkeyStat(917, 62, 1, false);
                    } else {
                        h.INSTANCE.idkeyStat(917, 61, 1, false);
                    }
                    FaceAgreementUI.this.sYK.setText(str);
                    AppMethodBeat.o(186400);
                    return;
                }
                h.INSTANCE.idkeyStat(917, 72, 1, false);
                FaceAgreementUI.this.sYP = false;
                Log.e("MicroMsg.FaceAgreementUIError", "[cgi-ret]net ret error, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                FaceAgreementUI.d(FaceAgreementUI.this);
                Intent intent = new Intent();
                intent.putExtra("err_msg", "fail");
                intent.putExtra("err_code", 90110);
                com.tencent.mm.plugin.flash.c.b.MX(90110);
                FaceAgreementUI.this.setResult(1, intent);
                FaceAgreementUI.this.finish();
                AppMethodBeat.o(186400);
            }
        });
        AppMethodBeat.o(186407);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(186408);
        Log.i("MicroMsg.FaceAgreementUI", "onBackPressed()");
        Intent intent = new Intent();
        com.tencent.mm.plugin.flash.c.b.MX(l.HL(90024));
        intent.putExtra("err_code", l.HL(90024));
        intent.putExtra("err_msg", "cancel");
        setResult(0, intent);
        super.onBackPressed();
        AppMethodBeat.o(186408);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(186409);
        super.onActivityResult(i2, i3, intent);
        setResult(i3, intent);
        finish();
        AppMethodBeat.o(186409);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private void a(final Context context, List<String> list, String str, List<String> list2, final TextView textView) {
        AppMethodBeat.i(186410);
        final SpannableString spannableString = new SpannableString(str);
        for (int i2 = 0; i2 < list2.size(); i2++) {
            String str2 = list2.get(i2);
            int indexOf = str.indexOf(str2);
            int length = indexOf + str2.length();
            if (indexOf >= 0 && length <= str.length()) {
                spannableString.setSpan(new a(list.get(i2), MMApplicationContext.getContext().getResources().getColor(R.color.x0), MMApplicationContext.getContext().getResources().getColor(R.color.BW_0_Alpha_0_2), new a.AbstractC1041a() {
                    /* class com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.facedetectaction.ui.a.AbstractC1041a
                    public final void arG(String str) {
                        AppMethodBeat.i(186402);
                        Log.i("MicroMsg.FaceAgreementUI", "click %s", str);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str);
                        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(186402);
                    }
                }), indexOf, length, 17);
            }
        }
        if (textView != null) {
            textView.setText(spannableString);
            textView.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.AnonymousClass6 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z;
                    ClickableSpan[] clickableSpanArr;
                    AppMethodBeat.i(186403);
                    int action = motionEvent.getAction();
                    TextView textView = (TextView) view;
                    if ((action == 1 || action == 3) && (clickableSpanArr = (ClickableSpan[]) spannableString.getSpans(0, spannableString.length(), ClickableSpan.class)) != null && clickableSpanArr.length > 0) {
                        for (ClickableSpan clickableSpan : clickableSpanArr) {
                            if (clickableSpan instanceof p) {
                                ((p) clickableSpan).setIsPressed(false);
                                textView.invalidate();
                            }
                        }
                    }
                    if (action == 1 || action == 0) {
                        int x = ((int) motionEvent.getX()) - textView.getPaddingLeft();
                        int y = ((int) motionEvent.getY()) - textView.getPaddingTop();
                        int scrollX = x + textView.getScrollX();
                        int scrollY = y + textView.getScrollY();
                        Layout layout = textView.getLayout();
                        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
                        ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannableString.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                        if (clickableSpanArr2.length != 0) {
                            ClickableSpan clickableSpan2 = clickableSpanArr2[0];
                            if (action == 1) {
                                clickableSpan2.onClick(textView);
                            } else {
                                if (clickableSpan2 instanceof p) {
                                    ((p) clickableSpan2).setIsPressed(true);
                                    textView.invalidate();
                                }
                                Selection.setSelection(spannableString, spannableString.getSpanStart(clickableSpan2), spannableString.getSpanEnd(clickableSpan2));
                            }
                            z = true;
                            Log.i("MicroMsg.FaceAgreementUI", "touch ${event.x}, ${event.y}, ret:${ret}");
                            AppMethodBeat.o(186403);
                            return z;
                        }
                        Selection.removeSelection(spannableString);
                    }
                    z = false;
                    Log.i("MicroMsg.FaceAgreementUI", "touch ${event.x}, ${event.y}, ret:${ret}");
                    AppMethodBeat.o(186403);
                    return z;
                }
            });
        }
        AppMethodBeat.o(186410);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(186411);
        super.onDestroy();
        if (this.sYQ) {
            h.INSTANCE.idkeyStat(917, 63, 1, false);
        }
        AppMethodBeat.o(186411);
    }

    static /* synthetic */ void b(FaceAgreementUI faceAgreementUI) {
        AppMethodBeat.i(186412);
        faceAgreementUI.sYQ = true;
        faceAgreementUI.qAx = new g(faceAgreementUI.getContext(), 1, 3);
        faceAgreementUI.qAx.b(faceAgreementUI.getString(R.string.c48), faceAgreementUI.getString(R.string.c45));
        faceAgreementUI.qAx.a(new g.a() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(186404);
                Log.i("MicroMsg.FaceAgreementUI", "click disagree ");
                FaceAgreementUI.this.qAx.bMo();
                h.INSTANCE.idkeyStat(917, 66, 1, false);
                AppMethodBeat.o(186404);
            }
        }, new g.a() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(186405);
                Log.i("MicroMsg.FaceAgreementUI", "click agree ");
                Intent intent = new Intent(FaceAgreementUI.this, FaceFlashPermissionUI.class);
                Bundle extras = FaceAgreementUI.this.getIntent().getExtras();
                if (extras != null) {
                    intent.putExtras(extras);
                }
                FaceAgreementUI.this.startActivityForResult(intent, 1);
                h.INSTANCE.idkeyStat(917, 65, 1, false);
                FaceAgreementUI.this.qAx.bMo();
                AppMethodBeat.o(186405);
            }
        });
        View inflate = View.inflate(faceAgreementUI.getContext(), R.layout.a5o, null);
        ao.a(((TextView) inflate.findViewById(R.id.c8k)).getPaint(), 0.8f);
        faceAgreementUI.qAx.setHeaderView(inflate);
        View inflate2 = View.inflate(faceAgreementUI.getContext(), R.layout.a5n, null);
        faceAgreementUI.sYM = (TextView) inflate2.findViewById(R.id.c8j);
        ao.a(faceAgreementUI.sYM.getPaint(), 0.8f);
        String str = faceAgreementUI.sYO;
        TextView textView = faceAgreementUI.sYM;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format(str, LocaleUtil.getCurrentLanguage(faceAgreementUI)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(faceAgreementUI.getString(R.string.c4_));
        faceAgreementUI.a(faceAgreementUI, arrayList, faceAgreementUI.getString(R.string.c4_), arrayList2, textView);
        faceAgreementUI.qAx.setCustomView(inflate2);
        faceAgreementUI.qAx.dGm();
        AppMethodBeat.o(186412);
    }

    static /* synthetic */ void c(FaceAgreementUI faceAgreementUI) {
        AppMethodBeat.i(186413);
        Log.i("MicroMsg.FaceAgreementUI", "onUserCancel()");
        com.tencent.mm.plugin.flash.c.b.MX(l.HL(90024));
        Intent intent = new Intent();
        intent.putExtra("err_code", l.HL(90024));
        intent.putExtra("err_msg", "cancel");
        faceAgreementUI.setResult(0, intent);
        faceAgreementUI.finish();
        AppMethodBeat.o(186413);
    }

    static /* synthetic */ void d(FaceAgreementUI faceAgreementUI) {
        AppMethodBeat.i(186414);
        if (!faceAgreementUI.isDestroyed() && !faceAgreementUI.isFinishing() && faceAgreementUI.mProgressDialog != null && faceAgreementUI.mProgressDialog.isShowing()) {
            com.tencent.f.h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(186401);
                    FaceAgreementUI.this.mProgressDialog.dismiss();
                    FaceAgreementUI.this.mProgressDialog = null;
                    AppMethodBeat.o(186401);
                }
            });
        }
        AppMethodBeat.o(186414);
    }
}
