package com.tencent.mm.plugin.appbrand.widget.sms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class EditVerifyCodeView extends RelativeLayout {
    private StringBuilder mBuilder;
    private Context mContext;
    private ImageView[] oEv;
    private TextView[] oEw;
    private VerifyCodeEditText oEx;
    View.OnKeyListener oEy;
    public a oEz;

    public interface a {
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(131588);
        this.mBuilder = new StringBuilder();
        this.oEv = new ImageView[6];
        this.oEw = new TextView[6];
        this.oEy = new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView.AnonymousClass3 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(131587);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (i2 == 67 && keyEvent.getAction() == 1) {
                    EditVerifyCodeView.c(EditVerifyCodeView.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(131587);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(131587);
                return false;
            }
        };
        eC(context);
        AppMethodBeat.o(131588);
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(131589);
        this.mBuilder = new StringBuilder();
        this.oEv = new ImageView[6];
        this.oEw = new TextView[6];
        this.oEy = new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView.AnonymousClass3 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(131587);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (i2 == 67 && keyEvent.getAction() == 1) {
                    EditVerifyCodeView.c(EditVerifyCodeView.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(131587);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(131587);
                return false;
            }
        };
        eC(context);
        AppMethodBeat.o(131589);
    }

    public String getText() {
        AppMethodBeat.i(131590);
        String sb = this.mBuilder.toString();
        AppMethodBeat.o(131590);
        return sb;
    }

    public void setText(String str) {
        AppMethodBeat.i(131591);
        this.mBuilder.delete(0, this.mBuilder.length());
        this.mBuilder.append(str);
        String sb = this.mBuilder.toString();
        int length = sb.length();
        Log.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + ((Object) this.mBuilder));
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                this.oEw[i2].setVisibility(0);
                this.oEw[i2].setText(String.valueOf(sb.charAt(i2)));
                this.oEv[i2].setVisibility(4);
            }
            AppMethodBeat.o(131591);
            return;
        }
        for (int i3 = 0; i3 < 6; i3++) {
            this.oEw[i3].setVisibility(4);
            this.oEw[i3].setText("");
            this.oEv[i3].setVisibility(0);
        }
        AppMethodBeat.o(131591);
    }

    @SuppressLint({"InflateParams"})
    private void eC(Context context) {
        AppMethodBeat.i(131592);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.a0o, (ViewGroup) null);
        this.oEw[0] = (TextView) inflate.findViewById(R.id.b5g);
        this.oEw[1] = (TextView) inflate.findViewById(R.id.b5h);
        this.oEw[2] = (TextView) inflate.findViewById(R.id.b5i);
        this.oEw[3] = (TextView) inflate.findViewById(R.id.b5j);
        this.oEw[4] = (TextView) inflate.findViewById(R.id.b5k);
        this.oEw[5] = (TextView) inflate.findViewById(R.id.b5l);
        this.oEv[0] = (ImageView) inflate.findViewById(R.id.b4x);
        this.oEv[1] = (ImageView) inflate.findViewById(R.id.b4y);
        this.oEv[2] = (ImageView) inflate.findViewById(R.id.b4z);
        this.oEv[3] = (ImageView) inflate.findViewById(R.id.b50);
        this.oEv[4] = (ImageView) inflate.findViewById(R.id.b51);
        this.oEv[5] = (ImageView) inflate.findViewById(R.id.b52);
        this.oEx = (VerifyCodeEditText) inflate.findViewById(R.id.j30);
        this.oEx.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(131586);
                if (editable == null || editable.length() == 0) {
                    AppMethodBeat.o(131586);
                    return;
                }
                Log.i("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", editable.toString());
                if (EditVerifyCodeView.this.mBuilder.length() < 6) {
                    EditVerifyCodeView.this.mBuilder.append(editable.toString());
                    EditVerifyCodeView.b(EditVerifyCodeView.this);
                }
                editable.delete(0, editable.length());
                AppMethodBeat.o(131586);
            }
        });
        this.oEx.setKeyListener(new NumberKeyListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public final char[] getAcceptedChars() {
                return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            }

            public final int getInputType() {
                return 3;
            }
        });
        this.oEx.setOnKeyListener(this.oEy);
        addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(131592);
    }

    public VerifyCodeEditText getEditText() {
        return this.oEx;
    }

    public void setCodeEditCompleListener(a aVar) {
        this.oEz = aVar;
    }

    static /* synthetic */ void b(EditVerifyCodeView editVerifyCodeView) {
        AppMethodBeat.i(131593);
        String sb = editVerifyCodeView.mBuilder.toString();
        Log.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + ((Object) editVerifyCodeView.mBuilder));
        int length = sb.length();
        if (length > 0 && length <= 6) {
            editVerifyCodeView.oEw[length - 1].setVisibility(0);
            editVerifyCodeView.oEw[length - 1].setText(String.valueOf(sb.charAt(length - 1)));
            editVerifyCodeView.oEv[length - 1].setVisibility(4);
        }
        AppMethodBeat.o(131593);
    }

    static /* synthetic */ void c(EditVerifyCodeView editVerifyCodeView) {
        AppMethodBeat.i(131594);
        String sb = editVerifyCodeView.mBuilder.toString();
        Log.i("MicroMsg.EditVerifyCodeView", "del before str:" + ((Object) editVerifyCodeView.mBuilder));
        int length = sb.length();
        if (length != 0) {
            if (length > 0 && length <= 6) {
                editVerifyCodeView.mBuilder.delete(length - 1, length);
                editVerifyCodeView.oEw[length - 1].setVisibility(4);
                editVerifyCodeView.oEw[length - 1].setText("");
                editVerifyCodeView.oEv[length - 1].setVisibility(0);
            }
            Log.i("MicroMsg.EditVerifyCodeView", "del after str:" + ((Object) editVerifyCodeView.mBuilder));
        }
        AppMethodBeat.o(131594);
    }
}
