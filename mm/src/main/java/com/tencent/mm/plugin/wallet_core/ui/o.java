package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.f;
import java.lang.ref.WeakReference;
import java.util.List;

public final class o {
    public static Dialog a(final Context context, String str, String str2, List<String> list, String str3, int i2, String str4, String str5, final String str6, final String str7) {
        AppMethodBeat.i(70965);
        View inflate = LayoutInflater.from(context).inflate(R.layout.c9c, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.b4d);
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 15.0f);
        Util.expandViewTouchArea(imageView, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        MMNeat7extView mMNeat7extView = (MMNeat7extView) inflate.findViewById(R.id.f6o);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f6n);
        Button button = (Button) inflate.findViewById(R.id.j0v);
        TextView textView = (TextView) inflate.findViewById(R.id.f6e);
        mMNeat7extView.getPaint().setFakeBoldText(true);
        mMNeat7extView.aw(str);
        ((TextView) inflate.findViewById(R.id.f6m)).setText(str2);
        linearLayout.removeAllViews();
        for (String str8 : list) {
            View inflate2 = LayoutInflater.from(context).inflate(R.layout.c9d, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R.id.jok)).setText(str8);
            linearLayout.addView(inflate2);
        }
        button.setText(str3);
        if (i2 > 0) {
            int length = str4.length();
            int length2 = (str4 + str5).length();
            SpannableString spannableString = new SpannableString(str4 + str5);
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ael)), length, length2, 33);
            textView.setText(spannableString);
        } else {
            textView.setText("");
        }
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(70955);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                String str = str6;
                Log.i("MicroMsg.WalletIdCardTip", "go to url %s", str);
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_username", z.aTY());
                intent.putExtra("pay_channel", 1);
                f.aA(context, intent);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70955);
            }
        });
        final com.tencent.mm.plugin.crashfix.b.a aVar = new com.tencent.mm.plugin.crashfix.b.a(context, R.style.a66);
        aVar.setContentView(inflate);
        aVar.setTitle((CharSequence) null);
        aVar.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(70957);
                Log.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                AppMethodBeat.o(70957);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(70958);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70958);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(70959);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                String str = str7;
                Log.i("MicroMsg.WalletIdCardTip", "go to url %s", str);
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_username", z.aTY());
                intent.putExtra("pay_channel", 1);
                f.aA(context, intent);
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70959);
            }
        });
        aVar.show();
        Window window = aVar.getWindow();
        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
        window.getDecorView().setPadding(fromDPToPix2, 0, fromDPToPix2, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        AppMethodBeat.o(70965);
        return aVar;
    }

    public static Dialog a(Context context, zv.b bVar) {
        AppMethodBeat.i(214239);
        Dialog a2 = a(context, bVar.title, bVar.subtitle, bVar.egp, bVar.egi, bVar.egj, bVar.egk, bVar.ego, bVar.egn, bVar.egm);
        AppMethodBeat.o(214239);
        return a2;
    }

    public static Dialog a(final Context context, final ECardInfo eCardInfo, final int i2) {
        AppMethodBeat.i(70966);
        View inflate = LayoutInflater.from(context).inflate(R.layout.c9e, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.b4d);
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 50.0f);
        Util.expandViewTouchArea(imageView, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        TextView textView = (TextView) inflate.findViewById(R.id.f6j);
        final Button button = (Button) inflate.findViewById(R.id.j0v);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f6e);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.b0m);
        TextView textView3 = (TextView) inflate.findViewById(R.id.b0s);
        ((TextView) inflate.findViewById(R.id.f6o)).setText(eCardInfo.title);
        if (!Util.isNullOrNil(eCardInfo.subtitle)) {
            textView.setText(eCardInfo.subtitle);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        int length = eCardInfo.HWZ.length();
        int length2 = (eCardInfo.HWZ + eCardInfo.HXa).length();
        SpannableString spannableString = new SpannableString(eCardInfo.HWZ + eCardInfo.HXa);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ael)), length, length2, 33);
        if (!Util.isNullOrNil(spannableString)) {
            textView2.setText(spannableString);
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(70960);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    String str = eCardInfo.HWY;
                    Log.i("MicroMsg.WalletIdCardTip", "go to url %s", str);
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", z.aTY());
                    intent.putExtra("pay_channel", 1);
                    f.aA(context, intent);
                    if (i2 == 0) {
                        h.INSTANCE.a(16500, 4);
                    } else {
                        h.INSTANCE.a(16500, 6);
                    }
                    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(70960);
                }
            });
        } else {
            textView2.setVisibility(8);
        }
        final com.tencent.mm.plugin.crashfix.b.a aVar = new com.tencent.mm.plugin.crashfix.b.a(context, R.style.a66);
        aVar.setContentView(inflate);
        aVar.setTitle((CharSequence) null);
        aVar.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(70961);
                Log.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                AppMethodBeat.o(70961);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(70962);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70962);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(70963);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WalletIdCardTip", "go to: %s", Integer.valueOf(eCardInfo.HWV));
                if (eCardInfo.HWV == 1) {
                    f.p(context, eCardInfo.egh, false);
                } else {
                    ou ouVar = new ou();
                    ouVar.dUO.aWF = new WeakReference(context);
                    EventCenter.instance.publish(ouVar);
                }
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70963);
            }
        });
        if (eCardInfo.HWQ == 1) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass10 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(70964);
                    if (!z) {
                        button.setEnabled(false);
                        button.setClickable(false);
                        AppMethodBeat.o(70964);
                        return;
                    }
                    button.setEnabled(true);
                    button.setClickable(true);
                    AppMethodBeat.o(70964);
                }
            });
            if (eCardInfo.HWR == 1) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
                button.setEnabled(false);
                button.setClickable(false);
            }
        } else {
            checkBox.setVisibility(8);
        }
        int length3 = eCardInfo.HWS.length();
        int length4 = (eCardInfo.HWS + eCardInfo.HWT).length();
        SpannableString spannableString2 = new SpannableString(eCardInfo.HWS + eCardInfo.HWT);
        spannableString2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ael)), length3, length4, 33);
        textView3.setText(spannableString2);
        textView3.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.o.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70956);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                String str = eCardInfo.HWU;
                Log.i("MicroMsg.WalletIdCardTip", "go to url %s", str);
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_username", z.aTY());
                intent.putExtra("pay_channel", 1);
                f.aA(context, intent);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70956);
            }
        });
        aVar.show();
        com.tencent.mm.ui.base.h.a(context, aVar);
        AppMethodBeat.o(70966);
        return aVar;
    }

    public static void hN(Context context) {
        AppMethodBeat.i(214240);
        d.a aVar = new d.a(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.ca9, (ViewGroup) null, false);
        ((ImageView) inflate.findViewById(R.id.jr6)).setImageResource(R.drawable.cs6);
        ((TextView) inflate.findViewById(R.id.jr7)).setText(R.string.ew1);
        aVar.Dl(true);
        aVar.Dk(false);
        aVar.hs(inflate);
        aVar.aoO(R.string.it7);
        aVar.aoV(R.string.j34);
        aVar.hbn().show();
        AppMethodBeat.o(214240);
    }
}
