package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static Dialog f(Context context, final View view) {
        String str;
        AppMethodBeat.i(95200);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b3d, (ViewGroup) null);
        if (LocaleUtil.isSimplifiedChineseAppLang()) {
            str = "font_1.otf";
        } else {
            str = LocaleUtil.isTraditionalChineseAppLang() ? "font_2.otf" : null;
        }
        TextView textView = (TextView) inflate.findViewById(R.id.f55);
        if (!Util.isNullOrNil(str)) {
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), str));
        }
        if (!LocaleUtil.isChineseAppLang()) {
            textView.setTextSize(1, 10.0f);
        }
        final com.tencent.mm.plugin.crashfix.b.a aVar = new com.tencent.mm.plugin.crashfix.b.a(context, R.style.a66);
        aVar.setContentView(inflate);
        aVar.setTitle((CharSequence) null);
        aVar.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.sns.lucky.ui.a.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(95197);
                Log.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                AppMethodBeat.o(95197);
            }
        });
        ((TextView) inflate.findViewById(R.id.dkf)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.lucky.ui.a.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(95198);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                View view2 = view;
                if (view2 != null) {
                    view2.performClick();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(95198);
            }
        });
        View findViewById = inflate.findViewById(R.id.ip6);
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 10.0f);
        Util.expandViewTouchArea(findViewById, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.lucky.ui.a.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(95199);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(95199);
            }
        });
        aVar.show();
        AppMethodBeat.o(95200);
        return aVar;
    }
}
