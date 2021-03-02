package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import junit.framework.Assert;

public final class h implements a {
    private boolean Bdx;
    private boolean Bdy;
    private int Bft;
    ContactListExpandPreference Bfu;
    private as contact;
    Context context;
    ah gtd;
    private int kgm;
    private String roomId;
    private f screen;

    public h(Context context2) {
        AppMethodBeat.i(27148);
        this.context = context2;
        this.Bfu = new ContactListExpandPreference(context2, 0);
        AppMethodBeat.o(27148);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27149);
        Log.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(str)));
        bg.aVF();
        as Kn = c.aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) <= 0) {
            AppMethodBeat.o(27149);
        } else {
            Intent intent = new Intent();
            intent.setClass(this.context, ContactInfoUI.class);
            intent.putExtra("Contact_User", Kn.field_username);
            Context context2 = this.context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(27149);
        }
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        AppMethodBeat.i(27150);
        if (asVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(Util.nullAsNil(asVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.screen = fVar;
        this.contact = asVar;
        this.Bdx = z;
        this.kgm = i2;
        this.Bdy = ((Activity) this.context).getIntent().getBooleanExtra("User_Verify", false);
        this.Bft = ((Activity) this.context).getIntent().getIntExtra("Kdel_from", -1);
        this.roomId = asVar.field_username;
        bg.aVF();
        this.gtd = c.aSX().Ke(this.roomId);
        this.screen.removeAll();
        this.screen.c(new PreferenceSmallCategory(this.context));
        this.Bfu.setKey("roominfo_contact_anchor");
        this.screen.c(this.Bfu);
        this.screen.c(new PreferenceCategory(this.context));
        NormalUserFooterPreference normalUserFooterPreference = new NormalUserFooterPreference(this.context);
        normalUserFooterPreference.setLayoutResource(R.layout.xa);
        normalUserFooterPreference.setKey("contact_info_footer_normal");
        if (normalUserFooterPreference.a(this.contact, "", this.Bdx, this.Bdy, false, this.kgm, this.Bft, false, false, 0, "")) {
            this.screen.c(normalUserFooterPreference);
        }
        this.Bfu.a(this.screen, this.Bfu.mKey);
        List<String> Ic = v.Ic(this.roomId);
        this.Bfu.zU(false).zV(false);
        this.Bfu.H(this.roomId, Ic);
        this.Bfu.a(new ContactListExpandPreference.a() {
            /* class com.tencent.mm.plugin.profile.ui.h.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
            public final void og(int i2) {
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
            public final void e(ViewGroup viewGroup, int i2) {
                AppMethodBeat.i(231865);
                if (h.this.Bfu.ain(i2)) {
                    String aio = h.this.Bfu.aio(i2);
                    if (Util.isNullOrNil(aio)) {
                        AppMethodBeat.o(231865);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClass(h.this.context, ContactInfoUI.class);
                    intent.putExtra("Contact_User", aio);
                    intent.putExtra("Contact_RoomNickname", h.this.gtd.getDisplayName(aio));
                    Context context = h.this.context;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/profile/ui/ContactWidgetGroupCard$1", "onItemNormalClick", "(Landroid/view/ViewGroup;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                AppMethodBeat.o(231865);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
            public final void amF() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
            public final void oh(int i2) {
            }
        });
        AppMethodBeat.o(27150);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27151);
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.screen.bmg("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.cCs();
        }
        AppMethodBeat.o(27151);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }
}
