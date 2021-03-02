package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.profile.ui.b.a;
import com.tencent.mm.plugin.profile.ui.b.b;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class BizInfoHeaderPreference extends Preference implements e.a, MStorageEx.IOnStorageChange {
    private ImageView Bdg;
    private ImageView Bdh;
    private View Bdi;
    private String Bdj;
    private c Bdk;
    private a Bdl = new a(this);
    private b Bdm = new b(this);
    private as contact;
    private MMActivity gte;
    private boolean rFe = false;
    private TextView rMV;
    private TextView ykC;

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(26927);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(26927);
    }

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(26928);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(26928);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(26929);
        Log.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
        this.rMV = (TextView) view.findViewById(R.id.bb8);
        this.ykC = (TextView) view.findViewById(R.id.bc2);
        this.Bdh = (ImageView) view.findViewById(R.id.a5d);
        this.Bdg = (ImageView) view.findViewById(R.id.baa);
        this.Bdi = view.findViewById(R.id.bab);
        this.rFe = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.o(26929);
    }

    private boolean eEa() {
        return this.rFe && this.contact != null;
    }

    private void initView() {
        AppMethodBeat.i(26930);
        if (!eEa()) {
            Log.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.rFe + "contact = " + this.contact);
            AppMethodBeat.o(26930);
            return;
        }
        this.rMV.setText(l.b(this.gte, Util.nullAsNil(this.contact.arI()) + " ", this.rMV.getTextSize()));
        if (this.Bdk == null) {
            this.Bdk = g.fJ(this.contact.field_username);
        }
        if (this.Bdk != null) {
            this.Bdj = this.Bdk.field_brandIconURL;
        }
        d.a(this.Bdg, this.contact, this.Bdj, false);
        this.Bdg.setTag(this.contact.field_username);
        this.Bdi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(26926);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = BizInfoHeaderPreference.this.contact.field_username;
                Intent intent = new Intent(BizInfoHeaderPreference.this.gte, ProfileHdHeadImg.class);
                intent.putExtra(ch.COL_USERNAME, str);
                intent.putExtra("brand_icon_url", BizInfoHeaderPreference.this.Bdj);
                MMActivity mMActivity = BizInfoHeaderPreference.this.gte;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                mMActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26926);
            }
        });
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type) || !UL()) {
            this.ykC.setVisibility(8);
        } else if (!Util.isNullOrNil(this.contact.ajx())) {
            this.ykC.setVisibility(0);
            this.ykC.setText(com.tencent.mm.plugin.profile.c.br(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.ju(this.contact.field_username, this.contact.ajx()));
        } else if (as.bjx(this.contact.field_username) || ab.IR(this.contact.field_username)) {
            this.ykC.setVisibility(8);
        } else {
            this.ykC.setText(com.tencent.mm.plugin.profile.c.br(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.ju(this.contact.field_username, Util.nullAsNil(this.contact.arK())));
            this.ykC.setVisibility(0);
        }
        if (this.contact.arA()) {
            this.Bdh.setVisibility(0);
            AppMethodBeat.o(26930);
            return;
        }
        this.Bdh.setVisibility(8);
        AppMethodBeat.o(26930);
    }

    public final void a(as asVar, String str, c cVar) {
        AppMethodBeat.i(26931);
        this.Bdj = str;
        this.Bdk = cVar;
        onDetach();
        bg.aVF();
        com.tencent.mm.model.c.aSN().add(this.Bdm);
        p.aYn().d(this.Bdl);
        this.contact = asVar;
        Assert.assertTrue("initView: contact username is null", Util.nullAsNil(asVar.field_username).length() > 0);
        initView();
        AppMethodBeat.o(26931);
    }

    public final void onDetach() {
        AppMethodBeat.i(26932);
        bg.aVF();
        com.tencent.mm.model.c.aSN().remove(this.Bdm);
        p.aYn().e(this.Bdl);
        AppMethodBeat.o(26932);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(26933);
        if (!eEa()) {
            Log.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.rFe + "contact = " + this.contact);
            AppMethodBeat.o(26933);
        } else if (Util.nullAsNil(str).length() <= 0) {
            Log.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = ".concat(String.valueOf(str)));
            AppMethodBeat.o(26933);
        } else {
            if (str.equals(this.contact.field_username)) {
                initView();
            }
            AppMethodBeat.o(26933);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(26934);
        if (obj == null || !(obj instanceof String)) {
            Log.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(26934);
        } else if (!eEa()) {
            Log.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.rFe + "contact = " + this.contact);
            AppMethodBeat.o(26934);
        } else {
            String str = (String) obj;
            if (Util.nullAsNil(str).length() <= 0) {
                AppMethodBeat.o(26934);
                return;
            }
            if (this.contact != null && this.contact.field_username.equals(str)) {
                bg.aVF();
                this.contact = com.tencent.mm.model.c.aSN().Kn(str);
            }
            AppMethodBeat.o(26934);
        }
    }

    private boolean UL() {
        AppMethodBeat.i(26935);
        if (this.Bdk == null) {
            AppMethodBeat.o(26935);
            return true;
        }
        boolean UL = this.Bdk.UL();
        AppMethodBeat.o(26935);
        return UL;
    }
}
