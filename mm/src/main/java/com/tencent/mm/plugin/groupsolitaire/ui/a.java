package com.tencent.mm.plugin.groupsolitaire.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class a {
    private Button hPX;
    private Button hSq;
    String kik;
    private View lJI = View.inflate(this.mContext, R.layout.atv, null);
    Context mContext;
    private int mLJ;
    private BottomSheetBehavior mLK;
    android.support.design.widget.a yfL = new android.support.design.widget.a(this.mContext);
    private TextView yfM;
    AbstractC1428a yfN;

    /* renamed from: com.tencent.mm.plugin.groupsolitaire.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC1428a {
        void aBp(String str);

        void onCancel();
    }

    public a(Context context) {
        AppMethodBeat.i(110416);
        this.mContext = context;
        this.yfL.setContentView(this.lJI);
        this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.a.AnonymousClass3 */

            public final void onDismiss(DialogInterface dialogInterface) {
                a.this.yfL = null;
            }
        });
        this.yfM = (TextView) this.lJI.findViewById(R.id.gag);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lJI.getLayoutParams();
        layoutParams.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 250);
        this.lJI.setLayoutParams(layoutParams);
        this.mLJ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 350);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        if (this.mLK != null) {
            this.mLK.J(this.mLJ);
            this.mLK.ob = false;
        }
        this.hPX = (Button) this.lJI.findViewById(R.id.g3k);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.a.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(110414);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.yfN != null) {
                    AbstractC1428a aVar = a.this.yfN;
                    a aVar2 = a.this;
                    Log.i("MicroMsg.TiemDatePicker", "[getPhoneNum] :%s", aVar2.kik);
                    aVar.aBp(aVar2.kik);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110414);
            }
        });
        this.hSq = (Button) this.lJI.findViewById(R.id.aib);
        this.hSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.a.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(110415);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.yfN != null) {
                    a.this.yfN.onCancel();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireContactsPhoneNumPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110415);
            }
        });
        AppMethodBeat.o(110416);
    }

    public final void show() {
        AppMethodBeat.i(110417);
        String str = (String) g.aAh().azQ().get(6, (Object) null);
        Log.d("MicroMsg.TiemDatePicker", "mobile :".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0) {
            h.a(this.mContext, false, this.mContext.getString(R.string.dvo), this.mContext.getString(R.string.dvo), this.mContext.getString(R.string.dvq), this.mContext.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    String str;
                    String str2;
                    b.a bs;
                    AppMethodBeat.i(110412);
                    Intent intent = new Intent(a.this.mContext, BindMContactUI.class);
                    intent.putExtra("bind_scene", 0);
                    String simCountryIso = ((TelephonyManager) a.this.mContext.getSystemService("phone")).getSimCountryIso();
                    if (!Util.isNullOrNil(simCountryIso) && (bs = com.tencent.mm.aw.b.bs(simCountryIso, a.this.mContext.getString(R.string.bj8))) != null) {
                        intent.putExtra("country_name", bs.jbZ);
                        intent.putExtra("couttry_code", bs.jbY);
                    }
                    Context context = a.this.mContext;
                    Log.i("MicroMsg.TiemDatePicker", "startWizardActivity()");
                    Assert.assertTrue("startWizardActivity: Param context should be a Activity :" + context.toString(), context instanceof Activity);
                    Intent intent2 = ((Activity) context).getIntent();
                    if (intent2 != null) {
                        String stringExtra = intent2.getStringExtra("WizardRootClass");
                        str = intent2.getStringExtra("WizardTransactionId");
                        str2 = stringExtra;
                    } else {
                        str = null;
                        str2 = null;
                    }
                    intent.putExtra("WizardRootClass", str2);
                    if (str != null) {
                        intent.putExtra("WizardTransactionId", str);
                    }
                    ((Activity) context).startActivityForResult(intent, 4098);
                    AppMethodBeat.o(110412);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.a.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(110413);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(110413);
                }
            }, R.color.ts, R.color.ts);
            AppMethodBeat.o(110417);
            return;
        }
        this.kik = str;
        this.yfM.setText(this.kik);
        if (this.yfL != null) {
            this.yfL.show();
        }
        AppMethodBeat.o(110417);
    }

    public final void hide() {
        AppMethodBeat.i(110418);
        if (this.yfL != null) {
            this.yfL.dismiss();
        }
        AppMethodBeat.o(110418);
    }
}
