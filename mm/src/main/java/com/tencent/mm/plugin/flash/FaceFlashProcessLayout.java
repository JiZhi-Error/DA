package com.tencent.mm.plugin.flash;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashProcessLayout extends RelativeLayout {
    static String TAG = "MicroMsg.FaceFlashManager";
    private static String wHv = "MicroMsg.FaceFlashManagerError";
    private FaceFlashUI wGP;
    private TextView wHA;
    Animation wHB;
    Animation wHC;
    Animation wHD;
    TextView wHw;
    WeImageView wHx;
    ImageView wHy;
    Button wHz;

    public FaceFlashProcessLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceFlashProcessLayout(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private FaceFlashProcessLayout(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        AppMethodBeat.i(186468);
        this.wGP = (FaceFlashUI) getContext();
        this.wHB = AnimationUtils.loadAnimation(getContext(), R.anim.b_);
        this.wHC = AnimationUtils.loadAnimation(getContext(), R.anim.bb);
        this.wHD = AnimationUtils.loadAnimation(getContext(), R.anim.ba);
        LayoutInflater.from(getContext()).inflate(R.layout.a5y, (ViewGroup) this, true);
        this.wHw = (TextView) findViewById(R.id.c9n);
        this.wHx = (WeImageView) findViewById(R.id.c9m);
        this.wHz = (Button) findViewById(R.id.c9j);
        this.wHA = (TextView) findViewById(R.id.c9i);
        this.wHy = (ImageView) findViewById(R.id.c9l);
        AppMethodBeat.o(186468);
    }

    public final void axe(String str) {
        String aI;
        AppMethodBeat.i(186469);
        Log.i(TAG, "showFailedAnimation");
        try {
            this.wHy.setImageResource(R.drawable.ue);
            this.wHy.startAnimation(this.wHB);
            this.wHx.setImageDrawable(a.l(getContext(), R.raw.icons_filled_error3));
            this.wHx.startAnimation(this.wHD);
            final JSONObject jSONObject = new JSONObject(str);
            TextView textView = this.wHw;
            String aI2 = a.aI(getContext(), R.string.c4i);
            String optString = jSONObject.optString("err_msg", jSONObject.optString("message", jSONObject.optString("errormsg", aI2)));
            if (TextUtils.isEmpty(optString)) {
                b.s("msgVerify", aI2);
            } else {
                b.s("msgVerify", optString);
                aI2 = optString;
            }
            textView.setText(aI2);
            final String optString2 = jSONObject.optString("err_feedback", "");
            this.wHA.setVisibility(TextUtils.isEmpty(optString2) ? 4 : 0);
            this.wHA.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.flash.FaceFlashProcessLayout.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(186465);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    try {
                        String optString = jSONObject.optString("key_app_id", "");
                        int optInt = jSONObject.optInt("err_code", 0);
                        String str = optString2 + "?customInfo=" + q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", optString, Integer.valueOf(optInt), jSONObject.optString("verify_result", "")), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str);
                        c.b(FaceFlashProcessLayout.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    } catch (Exception e2) {
                        Log.printErrStackTrace(FaceFlashProcessLayout.wHv, e2, "face start feedback webview exception", new Object[0]);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(186465);
                }
            });
            final boolean optBoolean = jSONObject.optBoolean("err_retry", true);
            this.wHz.setVisibility(0);
            Button button = this.wHz;
            if (optBoolean) {
                aI = a.aI(getContext(), R.string.c6q);
            } else {
                aI = a.aI(getContext(), R.string.c6o);
            }
            button.setText(aI);
            this.wHz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.flash.FaceFlashProcessLayout.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(186466);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (optBoolean) {
                        FaceFlashProcessLayout.this.wGP.reset();
                    } else {
                        FaceFlashProcessLayout.this.wGP.aO(jSONObject);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(186466);
                }
            });
            AppMethodBeat.o(186469);
        } catch (JSONException e2) {
            Log.printErrStackTrace(wHv, e2, "parse face failed result error.%s", str);
            this.wHw.setText(str);
            this.wHA.setVisibility(4);
            this.wHz.setVisibility(0);
            this.wHz.setText(a.aI(getContext(), R.string.c6q));
            this.wHz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.flash.FaceFlashProcessLayout.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(186467);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FaceFlashProcessLayout.this.wGP.reset();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(186467);
                }
            });
            AppMethodBeat.o(186469);
        }
    }
}
