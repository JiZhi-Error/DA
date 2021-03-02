package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class d {

    public interface b {
        void csu();

        void cwc();
    }

    public static class a implements b {
        @Override // com.tencent.mm.plugin.card.d.d.b
        public void csu() {
        }

        @Override // com.tencent.mm.plugin.card.d.d.b
        public void cwc() {
        }
    }

    public static void a(MMActivity mMActivity, final String str, String str2, final b bVar) {
        String str3;
        AppMethodBeat.i(113763);
        if (TextUtils.isEmpty(str2)) {
            str3 = mMActivity.getString(R.string.th);
        } else {
            str3 = str2;
        }
        h.a((Context) mMActivity, true, str3, mMActivity.getString(R.string.zb), mMActivity.getString(R.string.x_), mMActivity.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.card.d.d.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(113754);
                dialogInterface.dismiss();
                bVar.csu();
                AppMethodBeat.o(113754);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.card.d.d.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(113756);
                dialogInterface.dismiss();
                AppMethodBeat.o(113756);
            }
        });
        AppMethodBeat.o(113763);
    }

    public static void a(MMActivity mMActivity, final b bVar) {
        AppMethodBeat.i(113764);
        h.a((Context) mMActivity, true, mMActivity.getString(R.string.anv), "", mMActivity.getString(R.string.x_), mMActivity.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.card.d.d.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(113757);
                dialogInterface.dismiss();
                bVar.cwc();
                AppMethodBeat.o(113757);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.card.d.d.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(113758);
                dialogInterface.dismiss();
                AppMethodBeat.o(113758);
            }
        });
        AppMethodBeat.o(113764);
    }

    public static void c(MMActivity mMActivity, String str) {
        AppMethodBeat.i(113765);
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(R.string.atv);
        }
        a(mMActivity, str, false);
        AppMethodBeat.o(113765);
    }

    public static void b(MMActivity mMActivity, String str, int i2) {
        AppMethodBeat.i(113766);
        if (TextUtils.isEmpty(str)) {
            str = "errcode = ".concat(String.valueOf(i2));
        }
        a(mMActivity, str, false);
        AppMethodBeat.o(113766);
    }

    public static void a(final MMActivity mMActivity, String str, final boolean z) {
        AppMethodBeat.i(113767);
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(R.string.atv);
        }
        h.a((Context) mMActivity, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.card.d.d.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(113759);
                dialogInterface.dismiss();
                if (z) {
                    mMActivity.finish();
                }
                AppMethodBeat.o(113759);
            }
        });
        AppMethodBeat.o(113767);
    }

    public static void c(final MMActivity mMActivity) {
        AppMethodBeat.i(113768);
        h.a(mMActivity, mMActivity.getString(R.string.arz, new Object[]{mMActivity.getString(R.string.anm)}), mMActivity.getString(R.string.zb), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.card.d.d.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(113760);
                Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                MMActivity mMActivity = mMActivity;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/card/util/CardDialogHelper$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                mMActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/card/util/CardDialogHelper$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(113760);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.card.d.d.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(113768);
    }

    public static void c(final Context context, int i2, int i3, String str) {
        com.tencent.mm.ui.widget.a.d a2;
        AppMethodBeat.i(113769);
        if (i2 == -1) {
            AppMethodBeat.o(113769);
            return;
        }
        if (i2 == R.layout.ow) {
            a2 = a(context, i2, context.getResources().getString(i3), str, context.getResources().getString(R.string.aq_), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.card.d.d.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(113761);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(113761);
                }
            });
        } else {
            a2 = a(context, i2, context.getResources().getString(i3), str, context.getResources().getString(R.string.aqp), context.getResources().getString(R.string.aq_), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.card.d.d.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(113762);
                    dialogInterface.dismiss();
                    kl klVar = new kl();
                    klVar.dPA.context = context;
                    EventCenter.instance.publish(klVar);
                    Log.i("MicroMsg.CardDialogHelper", "enter to cardhome");
                    AppMethodBeat.o(113762);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.card.d.d.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(113755);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(113755);
                }
            });
        }
        if (a2 != null) {
            a2.show();
        }
        AppMethodBeat.o(113769);
    }

    private static com.tencent.mm.ui.widget.a.d a(Context context, int i2, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(113770);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i2, (ViewGroup) null);
        if (i2 == R.layout.ov) {
            TextView textView = (TextView) inflate.findViewById(R.id.ap5);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(R.string.ao_);
            }
            textView.setText(context.getResources().getString(R.string.anj, str2));
        } else if (i2 == R.layout.ou) {
            TextView textView2 = (TextView) inflate.findViewById(R.id.ap5);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(R.string.ao_);
            }
            textView2.setText(context.getResources().getString(R.string.ani, str2));
        }
        com.tencent.mm.ui.widget.a.d a2 = h.a(context, str, str3, inflate, onClickListener);
        AppMethodBeat.o(113770);
        return a2;
    }

    private static com.tencent.mm.ui.widget.a.d a(Context context, int i2, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(113771);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i2, (ViewGroup) null);
        if (i2 == R.layout.ov) {
            TextView textView = (TextView) inflate.findViewById(R.id.ap5);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(R.string.ao_);
            }
            textView.setText(context.getResources().getString(R.string.anj, str2));
        } else if (i2 == R.layout.ou) {
            TextView textView2 = (TextView) inflate.findViewById(R.id.ap5);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(R.string.ao_);
            }
            textView2.setText(context.getResources().getString(R.string.ani, str2));
        }
        com.tencent.mm.ui.widget.a.d a2 = h.a(context, str, inflate, str3, str4, onClickListener, onClickListener2);
        AppMethodBeat.o(113771);
        return a2;
    }
}
