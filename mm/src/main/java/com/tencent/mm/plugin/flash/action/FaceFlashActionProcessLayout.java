package com.tencent.mm.plugin.flash.action;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.facedetectaction.ui.a;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashActionProcessLayout extends RelativeLayout {
    static String TAG = "MicroMsg.FaceFlashManager.FaceFlashActionProcessLayout";
    private static String wHv = "MicroMsg.FaceFlashManagerError";
    TextView wHA;
    Animation wHB;
    Animation wHC;
    private Animation wHD;
    private FaceFlashActionUI wHY;
    TextView wHw;
    WeImageView wHx;
    ImageView wHy;
    Button wHz;
    private Button wIe;

    public FaceFlashActionProcessLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceFlashActionProcessLayout(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private FaceFlashActionProcessLayout(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        AppMethodBeat.i(186577);
        this.wHY = (FaceFlashActionUI) getContext();
        this.wHB = AnimationUtils.loadAnimation(getContext(), R.anim.b_);
        this.wHC = AnimationUtils.loadAnimation(getContext(), R.anim.bb);
        this.wHD = AnimationUtils.loadAnimation(getContext(), R.anim.ba);
        LayoutInflater.from(getContext()).inflate(R.layout.a5u, (ViewGroup) this, true);
        this.wHw = (TextView) findViewById(R.id.c9n);
        this.wHx = (WeImageView) findViewById(R.id.c9m);
        this.wHz = (Button) findViewById(R.id.c9j);
        this.wHA = (TextView) findViewById(R.id.c9i);
        this.wHy = (ImageView) findViewById(R.id.c9l);
        this.wIe = (Button) findViewById(R.id.c9h);
        AppMethodBeat.o(186577);
    }

    public final void axe(String str) {
        AppMethodBeat.i(186578);
        Log.i(TAG, "showFailedAnimation");
        try {
            this.wHy.setImageResource(R.drawable.ue);
            this.wHy.startAnimation(this.wHB);
            this.wHx.setImageDrawable(a.l(getContext(), R.raw.icons_filled_error3));
            this.wHx.startAnimation(this.wHD);
            final JSONObject jSONObject = new JSONObject(str);
            TextView textView = this.wHw;
            String aI = a.aI(getContext(), R.string.c4i);
            String optString = jSONObject.optString("err_tip", jSONObject.optString("message", jSONObject.optString("errormsg", aI)));
            if (TextUtils.isEmpty(optString)) {
                b.s("msgVerify", aI);
            } else {
                b.s("msgVerify", optString);
                aI = optString;
            }
            textView.setText(aI);
            String optString2 = jSONObject.optString("otherVerifyTitle");
            if (TextUtils.isEmpty(optString2)) {
                this.wIe.setVisibility(4);
            } else {
                this.wIe.setVisibility(0);
                this.wIe.setText(optString2);
                this.wIe.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(186573);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i(FaceFlashActionProcessLayout.TAG, "click customBtn");
                        try {
                            jSONObject.put("click_other_verify_btn", "yes");
                            FaceFlashActionProcessLayout.this.wHY.aO(jSONObject);
                        } catch (Exception e2) {
                            Log.printErrStackTrace(FaceFlashActionProcessLayout.wHv, e2, "face start feedback webview exception", new Object[0]);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(186573);
                    }
                });
            }
            final String optString3 = jSONObject.optString("err_feedback", "");
            this.wHA.setVisibility(TextUtils.isEmpty(optString3) ? 4 : 0);
            ao.a(this.wHA.getPaint(), 0.8f);
            String string = getContext().getResources().getString(R.string.c5c);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new com.tencent.mm.plugin.facedetectaction.ui.a(string, getContext().getResources().getColor(R.color.x0), getContext().getResources().getColor(R.color.BW_0_Alpha_0_2), new a.AbstractC1041a() {
                /* class com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.facedetectaction.ui.a.AbstractC1041a
                public final void arG(String str) {
                    AppMethodBeat.i(186574);
                    Log.i(FaceFlashActionProcessLayout.TAG, "click feedback url ");
                    try {
                        String optString = jSONObject.optString("key_app_id", "");
                        int optInt = jSONObject.optInt("err_code", 0);
                        String str2 = optString3 + "?customInfo=" + q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", optString, Integer.valueOf(optInt), jSONObject.optString("verify_result", "")), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        c.b(FaceFlashActionProcessLayout.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(186574);
                    } catch (Exception e2) {
                        Log.printErrStackTrace(FaceFlashActionProcessLayout.wHv, e2, "face start feedback webview exception", new Object[0]);
                        AppMethodBeat.o(186574);
                    }
                }
            }), 0, spannableString.length(), 17);
            this.wHA.setClickable(true);
            this.wHA.setOnTouchListener(new o(getContext()));
            this.wHA.setText(spannableString);
            final boolean optBoolean = jSONObject.optBoolean("err_retry", true);
            this.wHz.setVisibility(0);
            this.wHz.setText(optBoolean ? com.tencent.mm.cb.a.aI(getContext(), R.string.c6q) : com.tencent.mm.cb.a.aI(getContext(), R.string.c6o));
            this.wHz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(186575);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i(FaceFlashActionProcessLayout.TAG, "click retry btn, canRetry：%s", Boolean.valueOf(optBoolean));
                    if (optBoolean) {
                        FaceFlashActionProcessLayout.this.wHY.reset();
                    } else {
                        FaceFlashActionProcessLayout.this.wHY.aO(jSONObject);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(186575);
                }
            });
            if (this.wIe.getVisibility() == 0 && this.wHA.getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.wIe.getLayoutParams();
                layoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 108);
                this.wIe.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.wHz.getLayoutParams();
                layoutParams2.removeRule(12);
                layoutParams2.addRule(2, R.id.c9h);
                layoutParams2.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
                this.wHz.setLayoutParams(layoutParams2);
            }
            if (!(this.wIe.getVisibility() == 0 || this.wHA.getVisibility() == 0)) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.wHz.getLayoutParams();
                layoutParams3.addRule(12);
                layoutParams3.removeRule(2);
                layoutParams3.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 96);
                this.wHz.setLayoutParams(layoutParams3);
            }
            if (this.wIe.getVisibility() == 0 && this.wHA.getVisibility() != 0) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.wIe.getLayoutParams();
                layoutParams4.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 96);
                this.wIe.setLayoutParams(layoutParams4);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.wHz.getLayoutParams();
                layoutParams5.removeRule(12);
                layoutParams5.addRule(2, R.id.c9h);
                layoutParams5.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
                this.wHz.setLayoutParams(layoutParams5);
            }
            if (this.wIe.getVisibility() != 0 && this.wHA.getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.wHz.getLayoutParams();
                layoutParams6.addRule(12);
                layoutParams6.removeRule(2);
                layoutParams6.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 108);
                this.wHz.setLayoutParams(layoutParams6);
            }
            AppMethodBeat.o(186578);
        } catch (JSONException e2) {
            Log.printErrStackTrace(wHv, e2, "parse face failed result error.%s", str);
            this.wHw.setText(str);
            this.wHA.setVisibility(4);
            this.wHz.setVisibility(0);
            this.wHz.setText(com.tencent.mm.cb.a.aI(getContext(), R.string.c6q));
            this.wHz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(186576);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FaceFlashActionProcessLayout.this.wHY.reset();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(186576);
                }
            });
            AppMethodBeat.o(186578);
        }
    }

    public final void release() {
        AppMethodBeat.i(186579);
        this.wHB.cancel();
        this.wHC.cancel();
        this.wHD.cancel();
        AppMethodBeat.o(186579);
    }
}
