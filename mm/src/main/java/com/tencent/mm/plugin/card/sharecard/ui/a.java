package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.rtmp.TXLiveConstants;

public final class a {
    private final String TAG = "MicroMsg.CardConsumeCodeController";
    View jBN;
    Bitmap kuJ;
    View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.card.sharecard.ui.a.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(113028);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.g2h) {
                if (a.this.pWx.isChecked()) {
                    if (a.this.pWB != null) {
                        a.this.pWB.Em(1);
                    }
                } else if (a.this.pWB != null) {
                    a.this.pWB.Em(0);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113028);
        }
    };
    com.tencent.mm.plugin.card.base.b pQV;
    MMActivity pQZ;
    boolean pWA = false;
    AbstractC0907a pWB;
    float pWC = 0.0f;
    private View.OnLongClickListener pWD = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.card.sharecard.ui.a.AnonymousClass2 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(113029);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (view.getId() == R.id.b5f) {
                q.TF(a.this.pQV.csR().code);
                h.cD(a.this.pQZ, a.this.pQZ.getString(R.string.ta));
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(113029);
            return false;
        }
    };
    private View pWr;
    private View pWs;
    private View pWt;
    Bitmap pWu;
    TextView pWv;
    TextView pWw;
    CheckBox pWx;
    String pWy;
    int pWz = 1;

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC0907a {
        void Em(int i2);
    }

    public a(MMActivity mMActivity, View view) {
        AppMethodBeat.i(113030);
        this.pQZ = mMActivity;
        this.jBN = view;
        AppMethodBeat.o(113030);
    }

    /* access modifiers changed from: package-private */
    public final void bc(float f2) {
        AppMethodBeat.i(113031);
        WindowManager.LayoutParams attributes = this.pQZ.getWindow().getAttributes();
        attributes.screenBrightness = f2;
        this.pQZ.getWindow().setAttributes(attributes);
        AppMethodBeat.o(113031);
    }

    public final void cuE() {
        String str;
        AppMethodBeat.i(113032);
        Log.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
        if (!this.pWA) {
            Log.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
            AppMethodBeat.o(113032);
            return;
        }
        if (!Util.isNullOrNil(this.pQV.csR().LcE)) {
            String str2 = this.pQV.csR().LcE;
            Log.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", str2);
            str = str2;
        } else if (this.pQV.csK()) {
            String code = am.cud().getCode();
            Log.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", code);
            str = code;
        } else {
            String str3 = this.pQV.csR().code;
            Log.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", str3);
            str = str3;
        }
        switch (this.pQV.csR().Lcr) {
            case 0:
                if (this.pWt == null) {
                    this.pWt = ((ViewStub) this.jBN.findViewById(R.id.ali)).inflate();
                }
                TextView textView = (TextView) this.pWt.findViewById(R.id.b5f);
                textView.setText(n.akl(str));
                textView.setOnLongClickListener(this.pWD);
                if (!this.pQV.csx()) {
                    textView.setTextColor(l.ake(this.pQV.csQ().ixw));
                }
                if (str.length() <= 12) {
                    textView.setTextSize(1, 33.0f);
                } else if (str.length() > 12 && str.length() <= 16) {
                    textView.setTextSize(1, 30.0f);
                } else if (str.length() > 16 && str.length() <= 20) {
                    textView.setTextSize(1, 24.0f);
                } else if (str.length() > 20 && str.length() <= 40) {
                    textView.setTextSize(1, 18.0f);
                } else if (str.length() > 40) {
                    textView.setVisibility(8);
                }
                dz(this.pWt);
                break;
            case 1:
                if (this.pWs == null) {
                    this.pWs = ((ViewStub) this.jBN.findViewById(R.id.ala)).inflate();
                }
                View view = this.pWs;
                ImageView imageView = (ImageView) view.findViewById(R.id.b4s);
                TextView textView2 = (TextView) view.findViewById(R.id.b5f);
                if (!this.pQV.csx()) {
                    textView2.setTextColor(l.ake(this.pQV.csQ().ixw));
                }
                if (TextUtils.isEmpty(str) || str.length() > 40) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(n.akl(str));
                    if (this.pQV.csG()) {
                        textView2.setVisibility(0);
                        textView2.setOnLongClickListener(this.pWD);
                    } else {
                        textView2.setVisibility(8);
                    }
                }
                if (this.pWz != 1) {
                    textView2.setVisibility(4);
                }
                try {
                    l.Z(this.pWu);
                    if (!TextUtils.isEmpty(str)) {
                        this.pWu = com.tencent.mm.by.a.a.b(this.pQZ, str, 5, 0);
                        a(imageView, this.pWu);
                    } else {
                        this.pWu = null;
                        imageView.setImageBitmap(this.pWu);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.CardConsumeCodeController", e2, "", new Object[0]);
                }
                dz(this.pWs);
                break;
            case 2:
                if (this.pWr == null) {
                    this.pWr = ((ViewStub) this.jBN.findViewById(R.id.alf)).inflate();
                }
                View view2 = this.pWr;
                ImageView imageView2 = (ImageView) view2.findViewById(R.id.b58);
                TextView textView3 = (TextView) view2.findViewById(R.id.b5f);
                if (!this.pQV.csx()) {
                    textView3.setTextColor(l.ake(this.pQV.csQ().ixw));
                }
                if (str.length() <= 40) {
                    textView3.setText(n.akl(str));
                    if (this.pQV.csG()) {
                        textView3.setVisibility(0);
                        textView3.setOnLongClickListener(this.pWD);
                    } else {
                        textView3.setVisibility(8);
                    }
                } else {
                    textView3.setVisibility(8);
                }
                if (this.pWz != 1) {
                    textView3.setVisibility(4);
                }
                try {
                    l.Z(this.kuJ);
                    if (!TextUtils.isEmpty(str)) {
                        this.kuJ = com.tencent.mm.by.a.a.b(this.pQZ, str, 12, 3);
                        a(imageView2, this.kuJ);
                    } else {
                        this.kuJ = null;
                        imageView2.setImageBitmap(this.kuJ);
                    }
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.CardConsumeCodeController", e3, "", new Object[0]);
                }
                dz(this.pWr);
                break;
        }
        if (Util.isNullOrNil(this.pQV.csQ().jTx)) {
            this.pWv.setVisibility(8);
            this.pWw.setVisibility(8);
        } else if (this.pQV.csQ().Lfe != null) {
            this.pWw.setText(this.pQV.csQ().jTx);
            this.pWw.setVisibility(0);
            this.pWv.setVisibility(8);
            if (this.pWr != null) {
                ImageView imageView3 = (ImageView) this.pWr.findViewById(R.id.b58);
                ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
                layoutParams.height = com.tencent.mm.cb.a.fromDPToPix((Context) this.pQZ, (int) TXLiveConstants.RENDER_ROTATION_180);
                layoutParams.width = com.tencent.mm.cb.a.fromDPToPix((Context) this.pQZ, (int) TXLiveConstants.RENDER_ROTATION_180);
                imageView3.setLayoutParams(layoutParams);
            }
        } else {
            this.pWv.setText(this.pQV.csQ().jTx);
            this.pWv.setVisibility(0);
        }
        if (!this.pQV.csw() || TextUtils.isEmpty(this.pQV.csW()) || this.pQV.csW().equals(z.aTY())) {
            this.pWx.setChecked(false);
            this.pWx.setVisibility(8);
            AppMethodBeat.o(113032);
            return;
        }
        this.pWx.setVisibility(0);
        this.pWx.setText(com.tencent.mm.pluginsdk.ui.span.l.i(this.pQZ, " " + this.pQZ.getString(R.string.ao2, new Object[]{l.akg(this.pQV.csW())}), this.pQZ.getResources().getDimensionPixelOffset(R.dimen.ka)));
        AppMethodBeat.o(113032);
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        AppMethodBeat.i(113033);
        if (imageView == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(113033);
            return;
        }
        imageView.setImageBitmap(bitmap);
        if (this.pWz != 1) {
            imageView.setAlpha(10);
            AppMethodBeat.o(113033);
            return;
        }
        imageView.setAlpha(255);
        AppMethodBeat.o(113033);
    }

    private void dz(View view) {
        AppMethodBeat.i(113034);
        Button button = (Button) view.findViewById(R.id.b57);
        if (this.pWz == 1) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
        }
        if (this.pWz == -1) {
            button.setText(R.string.ar5);
        }
        AppMethodBeat.o(113034);
    }
}
