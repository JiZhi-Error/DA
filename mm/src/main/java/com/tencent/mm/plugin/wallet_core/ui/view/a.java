package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;

public final class a {

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.a$a  reason: collision with other inner class name */
    public interface AbstractC1922a {
        boolean a(boolean z, String str, String str2, String str3, String str4);
    }

    public static d a(Context context, String str, String str2, String str3, int i2, h.b bVar, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(71462);
        d a2 = a(context, str, str2, str3, false, i2, bVar, onClickListener);
        AppMethodBeat.o(71462);
        return a2;
    }

    public static d a(final Context context, String str, String str2, String str3, final boolean z, int i2, final h.b bVar, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(71463);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.Dk(false);
            aVar.Dl(true);
            aVar.aoW(R.string.sz).d(onClickListener);
            aVar.bon(str);
            View inflate = View.inflate(context, R.layout.c7g, null);
            final EditText editText = (EditText) inflate.findViewById(R.id.bxz);
            if (!Util.isNullOrNil(str2)) {
                editText.append(l.b(context, str2, editText.getTextSize()));
            }
            ((TextView) inflate.findViewById(R.id.ipe)).setVisibility(8);
            if (!Util.isNullOrNil(str3)) {
                editText.setHint(str3);
            }
            aVar.aoV(R.string.x_).a(false, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71453);
                    boolean z = true;
                    if (bVar != null) {
                        z = bVar.onFinish(editText.getText().toString().trim());
                    }
                    if (z) {
                        dialogInterface.dismiss();
                        if (context instanceof MMActivity) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(71452);
                                    ((MMActivity) context).hideVKB();
                                    AppMethodBeat.o(71452);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(71453);
                }
            });
            if (i2 > 0) {
                c.f(editText).aoq(i2).a((c.a) null);
            }
            aVar.hs(inflate);
            d hbn = aVar.hbn();
            hbn.show();
            a(context, (Dialog) hbn);
            if (context instanceof MMActivity) {
                inflate.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(71454);
                        if (z && editText != null && com.tencent.mm.compatible.util.d.oD(28)) {
                            editText.requestFocus();
                        }
                        ((MMActivity) context).showVKB();
                        AppMethodBeat.o(71454);
                    }
                });
            }
            AppMethodBeat.o(71463);
            return hbn;
        }
        AppMethodBeat.o(71463);
        return null;
    }

    public static d a(Context context, String str, String str2, String str3, boolean z, String str4, String str5, String str6, AbstractC1922a aVar, f.c cVar) {
        AppMethodBeat.i(71464);
        d a2 = a(context, str, str2, str3, z, str4, str5, str6, false, aVar, cVar);
        AppMethodBeat.o(71464);
        return a2;
    }

    public static d a(final Context context, String str, String str2, String str3, boolean z, final String str4, final String str5, String str6, final boolean z2, final AbstractC1922a aVar, f.c cVar) {
        AppMethodBeat.i(71465);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            final f.a aVar2 = new f.a(context);
            aVar2.Dq(true);
            aVar2.a(cVar);
            aVar2.aC(str);
            View inflate = View.inflate(context, R.layout.c7h, null);
            final EditText editText = (EditText) inflate.findViewById(R.id.bxz);
            if (!Util.isNullOrNil(str2)) {
                editText.append(l.b(context, str2, editText.getTextSize()));
            }
            if (!Util.isNullOrNil(str3)) {
                editText.setHint(str3);
            }
            final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.gj);
            final LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.hc);
            final TextView textView = (TextView) inflate.findViewById(R.id.fth);
            final TextView textView2 = (TextView) inflate.findViewById(R.id.ha);
            ((ImageView) inflate.findViewById(R.id.gi)).getDrawable().setColorFilter(-15970418, PorterDuff.Mode.SRC_ATOP);
            ((TextView) inflate.findViewById(R.id.hd)).setText(MMApplicationContext.getContext().getString(R.string.g1g));
            linearLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(71455);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (aVar != null) {
                        aVar.a(true, editText.getText().toString().trim(), null, null, null);
                    }
                    a.a(context, aVar2.kdo);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71455);
                }
            });
            if (z) {
                linearLayout.setVisibility(0);
                linearLayout2.setVisibility(8);
            } else {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView.setText(str4 + "  " + str5);
                textView2.setText(str6);
                inflate.findViewById(R.id.c5h).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(71456);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (aVar != null) {
                            aVar.a(false, editText.getText().toString().trim(), str4, str5, textView2.getText().toString().trim());
                        }
                        a.a(context, aVar2.kdo);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(71456);
                    }
                });
                inflate.findViewById(R.id.bmb).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(71457);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        linearLayout.setVisibility(0);
                        linearLayout2.setVisibility(8);
                        textView.setText("");
                        textView2.setText("");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(71457);
                    }
                });
            }
            aVar2.apa(R.string.x_).b(new f.c() {
                /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass6 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    boolean z2;
                    AppMethodBeat.i(71459);
                    if (context instanceof MMActivity) {
                        if (aVar != null) {
                            if (Util.isNullOrNil(textView.getText().toString().trim())) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            aVar.a(z2, editText.getText().toString().trim(), str4, str5, textView2.getText().toString().trim());
                        }
                        if (context instanceof MMActivity) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass6.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(71458);
                                    ((MMActivity) context).hideVKB();
                                    AppMethodBeat.o(71458);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(71459);
                }
            });
            c.f(editText).aoq(20).a((c.a) null);
            aVar2.hu(inflate);
            aVar2.show();
            if (context instanceof MMActivity) {
                aVar2.kdo.getContentView().post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(71460);
                        if (z2 && textView2 != null && com.tencent.mm.compatible.util.d.oD(28)) {
                            textView2.requestFocus();
                        }
                        ((MMActivity) context).showVKB();
                        AppMethodBeat.o(71460);
                    }
                });
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.wallet_core.ui.view.a.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(71461);
                    ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(editText, 2);
                    AppMethodBeat.o(71461);
                }
            });
            AppMethodBeat.o(71465);
            return null;
        }
        AppMethodBeat.o(71465);
        return null;
    }

    private static void a(Context context, Dialog dialog) {
        AppMethodBeat.i(71466);
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(dialog);
        }
        AppMethodBeat.o(71466);
    }

    static /* synthetic */ void a(Context context, d dVar) {
        AppMethodBeat.i(71467);
        Intent intent = new Intent();
        intent.putExtra("launch_from_remittance", true);
        com.tencent.mm.br.c.a(context, "address", ".ui.WalletSelectAddrUI", intent, 6, false);
        if (dVar != null) {
            dVar.dismiss();
        }
        AppMethodBeat.o(71467);
    }
}
