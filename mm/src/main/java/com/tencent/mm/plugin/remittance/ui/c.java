package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.le;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f;

public final class c {
    private zd Cpw;
    public a CqB;
    public Context mContext;

    public interface a {
        void aMb(String str);

        void onCancel();
    }

    public c(Context context) {
        this.mContext = context;
    }

    public final void a(final w wVar, zd zdVar, a aVar) {
        AppMethodBeat.i(67940);
        this.CqB = aVar;
        this.Cpw = zdVar;
        View inflate = View.inflate(this.mContext, R.layout.bl5, null);
        final EditText editText = (EditText) inflate.findViewById(R.id.d5c);
        ((MMNeat7extView) inflate.findViewById(R.id.be9)).aw(this.Cpw.dQx);
        ((TextView) inflate.findViewById(R.id.e7v)).setText(zdVar.AOv);
        final f.a aVar2 = new f.a(this.mContext);
        aVar2.aC(this.Cpw.title).hu(inflate);
        aVar2.boA(this.mContext.getResources().getString(R.string.z9));
        com.tencent.mm.ui.tools.b.c.f(editText).a(f.a.MODE_CHINESE_AS_1).lv(1, 1).CN(false).a((c.a) null);
        editText.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.remittance.ui.c.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(213751);
                if (aVar2.kdo != null) {
                    if (editText.length() > 0) {
                        aVar2.kdo.ajL(c.this.mContext.getResources().getColor(R.color.Link_100));
                        aVar2.kdo.getButton(-1).setEnabled(true);
                        AppMethodBeat.o(213751);
                        return;
                    }
                    aVar2.kdo.ajL(-2141754475);
                    aVar2.kdo.getButton(-1).setEnabled(false);
                }
                AppMethodBeat.o(213751);
            }
        });
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.ui.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(213754);
                editText.requestFocus();
                ((InputMethodManager) c.this.mContext.getSystemService("input_method")).showSoftInput(editText, 0);
                AppMethodBeat.o(213754);
            }
        }, 200);
        le leVar = new le();
        leVar.eXN = (long) wVar.yRL;
        le yr = leVar.yr(wVar.username);
        yr.eXG = 1;
        yr.bfK();
        aVar2.c(new f.c() {
            /* class com.tencent.mm.plugin.remittance.ui.c.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(213755);
                if (z) {
                    le leVar = new le();
                    leVar.eXN = (long) wVar.yRL;
                    le yr = leVar.yr(wVar.username);
                    yr.eXG = 3;
                    yr.bfK();
                    c.this.CqB.aMb(editText.getText().toString());
                    AppMethodBeat.o(213755);
                    return;
                }
                le leVar2 = new le();
                leVar2.eXN = (long) wVar.yRL;
                le yr2 = leVar2.yr(wVar.username);
                yr2.eXG = 2;
                yr2.bfK();
                c.this.CqB.onCancel();
                AppMethodBeat.o(213755);
            }
        }).show();
        if (aVar2.kdo != null && Util.isNullOrNil(editText.getText())) {
            aVar2.kdo.getButton(-1).setEnabled(false);
            aVar2.kdo.ajL(-2141754475);
        }
        AppMethodBeat.o(67940);
    }
}
