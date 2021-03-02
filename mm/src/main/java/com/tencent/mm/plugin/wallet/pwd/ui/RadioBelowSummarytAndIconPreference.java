package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class RadioBelowSummarytAndIconPreference extends Preference {
    private LinearLayout HID;
    private ImageView HIE;
    private View HIF;
    View.OnClickListener HIG;
    int aeN = 0;
    private View mView;

    public RadioBelowSummarytAndIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadioBelowSummarytAndIconPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(69580);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(69580);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(69581);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            this.HID = (LinearLayout) onCreateView.findViewById(16908312);
            View.inflate(this.mContext, R.layout.b_z, viewGroup2);
            this.HIE = (ImageView) viewGroup2.findViewById(R.id.iei);
            this.HIF = viewGroup2.findViewById(R.id.ieg);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.o(69581);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(final View view) {
        AppMethodBeat.i(69582);
        super.onBindView(view);
        alO(8);
        if (this.HIE != null && this.HIG != null && !Util.isEqual(0, this.aeN)) {
            this.HIE.setImageResource(this.aeN);
            this.HIE.post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.RadioBelowSummarytAndIconPreference.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(69578);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RadioBelowSummarytAndIconPreference.this.HIF.getLayoutParams();
                    layoutParams.leftMargin = view.findViewById(16908304).getWidth();
                    RadioBelowSummarytAndIconPreference.this.HIF.setLayoutParams(layoutParams);
                    AppMethodBeat.o(69578);
                }
            });
            this.HIF.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.RadioBelowSummarytAndIconPreference.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(69579);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet/pwd/ui/RadioBelowSummarytAndIconPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    RadioBelowSummarytAndIconPreference.this.HIG.onClick(view);
                    a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/RadioBelowSummarytAndIconPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69579);
                }
            });
        } else if (this.HIE != null) {
            this.HIE.setVisibility(8);
        }
        if (this.HID != null) {
            if (this.OZG != 0) {
                this.HID.removeAllViews();
                View.inflate(this.mContext, this.OZG, this.HID);
                AppMethodBeat.o(69582);
                return;
            }
            this.HID.setVisibility(8);
        }
        AppMethodBeat.o(69582);
    }
}
