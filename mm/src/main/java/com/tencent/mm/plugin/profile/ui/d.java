package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e;
import junit.framework.Assert;

public final class d implements a {
    b Bcm;
    private as contact;
    private final Context context;
    private f screen;

    public d(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27114);
        if (str.equals("contact_profile_say_hi")) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.contact.field_username);
            intent.putExtra("Contact_Scene", 25);
            intent.putExtra(e.d.OyT, this.contact.fuY);
            com.tencent.mm.plugin.profile.b.jRt.a(intent, this.context);
        }
        AppMethodBeat.o(27114);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(27115);
        if (asVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (Util.nullAsNil(asVar.field_username).length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.assertTrue(z3);
        if (fVar != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assert.assertTrue(z4);
        this.contact = asVar;
        ((MMActivity) this.context).getIntent().putExtra("Contact_Scene", 25);
        if (this.Bcm == null) {
            this.Bcm = new b((MMActivity) this.context, asVar);
        }
        cCs();
        this.screen = fVar;
        fVar.removeAll();
        fVar.addPreferencesFromResource(R.xml.w);
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) fVar.bmg("contact_info_header_normal");
        if (normalProfileHeaderPreference != null) {
            normalProfileHeaderPreference.nRm = fVar;
            normalProfileHeaderPreference.a(asVar, 25, z, null);
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar.bmg("contact_info_signature");
        if (asVar.signature == null || asVar.signature.trim().equals("")) {
            fVar.e(keyValuePreference);
        } else if (keyValuePreference != null) {
            keyValuePreference.OYB = false;
            keyValuePreference.setTitle(this.context.getString(R.string.bfk));
            keyValuePreference.setSummary(l.c(this.context, asVar.signature));
            keyValuePreference.BC(false);
            keyValuePreference.alO(8);
        }
        ((MultiButtonPreference) fVar.bmg("contact_profile_multi_button")).a(this.context.getString(R.string.ahk), new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.d.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(27113);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactWidgetBottleContact$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.this.Bcm.eDX();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactWidgetBottleContact$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27113);
            }
        });
        AppMethodBeat.o(27115);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27116);
        if (this.screen == null) {
            AppMethodBeat.o(27116);
        } else {
            NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.screen.bmg("contact_info_header_normal");
            if (normalProfileHeaderPreference != null) {
                normalProfileHeaderPreference.onDetach();
            }
            if (this.Bcm != null) {
                this.Bcm.destroy();
            }
            AppMethodBeat.o(27116);
        }
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }
}
