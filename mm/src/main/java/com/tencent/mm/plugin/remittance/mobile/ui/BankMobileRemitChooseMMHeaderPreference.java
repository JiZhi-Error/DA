package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class BankMobileRemitChooseMMHeaderPreference extends Preference {
    private Map<String, r.a> Cmg = new HashMap();
    private String icon;
    private int noe;
    private String title;

    public BankMobileRemitChooseMMHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(67661);
        AppMethodBeat.o(67661);
    }

    public BankMobileRemitChooseMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(67662);
        AppMethodBeat.o(67662);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void gr() {
        this.noe = R.raw.addfriend_icon_invite;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(67663);
        super.onBindView(view);
        final ImageView imageView = (ImageView) view.findViewById(R.id.a03);
        TextView textView = (TextView) view.findViewById(R.id.a04);
        if (!Util.isNullOrNil(this.icon)) {
            q.bcQ();
            Bitmap EP = d.EP(this.icon);
            if (EP != null) {
                imageView.setImageBitmap(EP);
            } else if (!Util.isNullOrNil(this.icon)) {
                AnonymousClass1 r2 = new r.a() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemitChooseMMHeaderPreference.AnonymousClass1 */

                    @Override // com.tencent.mm.av.r.a
                    public final void a(String str, Bitmap bitmap, String str2) {
                        AppMethodBeat.i(67660);
                        Log.i("MicroMsg.mobileRemit.BankMobileRemitChooseMMHeaderPreference", "icon url: %s", str);
                        imageView.setImageBitmap(bitmap);
                        AppMethodBeat.o(67660);
                    }
                };
                this.Cmg.put(this.icon, r2);
                q.bcU().a(this.icon, r2);
            }
        } else if (!Util.isEqual(this.noe, 0)) {
            imageView.setImageResource(this.noe);
        }
        if (!Util.isNullOrNil(this.title)) {
            textView.setText(this.title);
        }
        AppMethodBeat.o(67663);
    }
}
