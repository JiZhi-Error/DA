package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.bj.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;

public final class a extends LinearLayout implements i {
    private static C2029a KoZ;
    private Button Kpa;
    private Context context;
    private TextView hXC;
    private q tipDialog;

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.a$a  reason: collision with other inner class name */
    public static class C2029a {
        public String Kpf;
        public int scene;
        public String talker;
        public int type;
        public String wZz;
    }

    public static void setFMessageArgs(C2029a aVar) {
        KoZ = aVar;
    }

    public a(Context context2) {
        super(context2);
        AppMethodBeat.i(31814);
        this.context = context2;
        View inflate = View.inflate(this.context, R.layout.am8, this);
        this.hXC = (TextView) inflate.findViewById(R.id.d77);
        this.Kpa = (Button) inflate.findViewById(R.id.d78);
        this.Kpa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.preference.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(31812);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/FMessageItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                View inflate = View.inflate(a.this.context, R.layout.bqa, null);
                ((TextView) inflate.findViewById(R.id.hku)).setVisibility(8);
                final TextView textView = (TextView) inflate.findViewById(R.id.joi);
                textView.setVisibility(0);
                textView.setText("50");
                final EditText editText = (EditText) inflate.findViewById(R.id.hkt);
                editText.setSingleLine(false);
                c.f(editText).aoq(100).a((c.a) null);
                editText.addTextChangedListener(new TextWatcher() {
                    /* class com.tencent.mm.pluginsdk.ui.preference.a.AnonymousClass1.AnonymousClass1 */

                    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        AppMethodBeat.i(31809);
                        int dp = f.dp(100, editable.toString());
                        if (textView != null) {
                            textView.setText(String.valueOf(dp));
                        }
                        AppMethodBeat.o(31809);
                    }
                });
                h.a(a.this.context, a.this.context.getString(R.string.yf), inflate, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.preference.a.AnonymousClass1.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(31810);
                        String trim = editText.getText().toString().trim();
                        if (trim != null && trim.length() > 0) {
                            try {
                                a.a(a.this, trim);
                                AppMethodBeat.o(31810);
                                return;
                            } catch (ArrayIndexOutOfBoundsException e2) {
                                Log.printErrStackTrace("MicroMsg.FMessageItemView", e2, "", new Object[0]);
                                if (a.this.tipDialog != null && a.this.tipDialog.isShowing()) {
                                    a.this.tipDialog.dismiss();
                                }
                            }
                        }
                        AppMethodBeat.o(31810);
                    }
                }, (DialogInterface.OnClickListener) null);
                editText.post(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.ui.preference.a.AnonymousClass1.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(31811);
                        if (a.this.context instanceof MMActivity) {
                            ((MMActivity) a.this.context).showVKB();
                        }
                        AppMethodBeat.o(31811);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/FMessageItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31812);
            }
        });
        AppMethodBeat.o(31814);
    }

    public final void detach() {
        AppMethodBeat.i(31815);
        bg.azz().b(30, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(31815);
    }

    private static int bfb(String str) {
        AppMethodBeat.i(31816);
        if (str == null) {
            Log.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
            AppMethodBeat.o(31816);
            return 6;
        }
        switch (ca.d.bkD(str).dKy) {
            case 2:
            case 5:
                AppMethodBeat.o(31816);
                return 6;
            case 3:
            case 4:
            default:
                AppMethodBeat.o(31816);
                return 6;
            case 6:
                AppMethodBeat.o(31816);
                return 5;
        }
    }

    public final void setContentText(String str) {
        AppMethodBeat.i(31817);
        if (Util.isNullOrNil(str)) {
            this.hXC.setVisibility(8);
            AppMethodBeat.o(31817);
            return;
        }
        this.hXC.setVisibility(0);
        this.hXC.setText(l.b(this.context, Util.nullAsNil(str), this.hXC.getTextSize()));
        AppMethodBeat.o(31817);
    }

    public final void setBtnVisibility(int i2) {
        AppMethodBeat.i(31818);
        if (this.Kpa != null) {
            this.Kpa.setVisibility(i2);
        }
        AppMethodBeat.o(31818);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(31819);
        if (qVar.getType() != 30) {
            AppMethodBeat.o(31819);
            return;
        }
        Log.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            int i4 = ((p) qVar).dKy;
            String str2 = ((p) qVar).JVk;
            Log.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + i4 + ", verifyContent = " + str2);
            Log.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + KoZ.type);
            switch (KoZ.type) {
                case 1:
                    bx bxVar = new bx();
                    bxVar.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv().aEr(KoZ.talker);
                    bxVar.field_isSend = 1;
                    bxVar.field_content = str2;
                    bxVar.field_talker = "fmessage";
                    bxVar.field_sayhiuser = KoZ.talker;
                    bxVar.field_svrid = System.currentTimeMillis();
                    bxVar.field_status = 4;
                    d.bgO().a(bxVar);
                    break;
                case 2:
                    cl clVar = new cl();
                    clVar.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiu().aEr(KoZ.talker);
                    clVar.field_isSend = 1;
                    clVar.field_content = str2;
                    clVar.field_talker = "fmessage";
                    clVar.field_sayhiuser = KoZ.talker;
                    clVar.field_svrid = System.currentTimeMillis();
                    clVar.field_status = 4;
                    Log.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = ".concat(String.valueOf(d.bgP().a(clVar))));
                    break;
                default:
                    bn bnVar = new bn();
                    bnVar.field_createTime = com.tencent.mm.bj.c.C(KoZ.talker, 0);
                    bnVar.field_isSend = 1;
                    bnVar.field_msgContent = str2;
                    bnVar.field_talker = KoZ.talker;
                    bnVar.field_type = i4 == 5 ? 2 : 3;
                    Log.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = ".concat(String.valueOf(d.bgM().b(bnVar))));
                    break;
            }
        } else {
            if (i2 == 4 && i3 == -34) {
                str = this.context.getString(R.string.ddu);
            } else if (i2 == 4 && i3 == -94) {
                str = this.context.getString(R.string.ddx);
            } else if (!(i2 == 4 && i3 == -24 && !Util.isNullOrNil(str))) {
                str = this.context.getString(R.string.gkm);
            }
            Toast.makeText(this.context, str, 1).show();
        }
        bg.azz().b(30, this);
        AppMethodBeat.o(31819);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.pluginsdk.ui.preference.a r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 342
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.preference.a.a(com.tencent.mm.pluginsdk.ui.preference.a, java.lang.String):void");
    }
}
