package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.contact.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;

public class PhoneNumPreference extends Preference implements View.OnClickListener {
    public String KcI;
    public String KcJ;
    ProfileMobilePhoneView Kqe;
    public Intent intent;
    public f nRm;
    public as rjX;
    private View zlc;

    public PhoneNumPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public PhoneNumPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(31897);
        if (this.zlc == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            ProfileMobilePhoneView profileMobilePhoneView = new ProfileMobilePhoneView(onCreateView.getContext(), this);
            this.Kqe = profileMobilePhoneView;
            viewGroup2.addView(profileMobilePhoneView, new AbsListView.LayoutParams(-1, -2));
            this.Kqe.rjX = this.rjX;
            this.Kqe.my(this.KcI, this.KcJ);
            this.zlc = onCreateView;
        }
        View view = this.zlc;
        AppMethodBeat.o(31897);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(31898);
        super.onBindView(view);
        this.Kqe.eEV();
        AppMethodBeat.o(31898);
    }

    public static String b(String str, as asVar) {
        AppMethodBeat.i(31899);
        if (asVar.fuX == null) {
            AppMethodBeat.o(31899);
            return null;
        }
        HashSet hashSet = new HashSet();
        if (str != null) {
            hashSet.add(str);
        }
        StringBuilder sb = new StringBuilder();
        String[] e2 = a.e(asVar);
        if (e2 != null) {
            for (String str2 : e2) {
                String trim = str2.trim();
                if (!hashSet.contains(trim) && !Util.isNullOrNil(trim)) {
                    sb.append(trim).append(a.d(asVar));
                }
                hashSet.add(trim);
            }
        }
        if (sb.length() > 1) {
            sb.subSequence(0, sb.length() - 1);
        }
        Log.i("MicroMsg.PhoneNumPreference", "[filterPhoneList] phoneNumberByMD5:%s phoneList:%s", str, asVar.fuX);
        String sb2 = sb.toString();
        AppMethodBeat.o(31899);
        return sb2;
    }

    public final void grR() {
        AppMethodBeat.i(31900);
        if (this.rjX == null || !c.oR(this.rjX.field_type) || as.bjp(this.rjX.field_username) || (Util.isNullOrNil(this.KcI) && Util.isNullOrNil(this.KcJ))) {
            this.nRm.m38do("contact_profile_phone", true);
            AppMethodBeat.o(31900);
            return;
        }
        this.nRm.m38do("contact_profile_phone", false);
        AppMethodBeat.o(31900);
    }

    public void onClick(View view) {
        AppMethodBeat.i(31901);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/PhoneNumPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.intent)), 17, 1, this.rjX.field_username);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/PhoneNumPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31901);
    }
}
