package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class CardDetailPreference extends MMPreference {
    private final String TAG = "MicroMsg.CardDetailPreference";
    f nRm;
    private b pQV;
    private List<com.tencent.mm.plugin.card.model.b> pRa = new ArrayList();
    private TextView pYZ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardDetailPreference() {
        AppMethodBeat.i(113190);
        AppMethodBeat.o(113190);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113191);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(113191);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113192);
        this.pQV = (b) getIntent().getParcelableExtra("key_card_info_data");
        if (this.pQV == null || this.pQV.csQ() == null || this.pQV.csR() == null) {
            Log.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            AppMethodBeat.o(113192);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.pQV.csQ().pTn)) {
            sb.append(this.pQV.csQ().pTn);
        }
        sb.append(getString(R.string.aoe));
        setMMTitle(sb.toString());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardDetailPreference.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113189);
                CardDetailPreference.this.finish();
                AppMethodBeat.o(113189);
                return true;
            }
        });
        this.nRm = getPreferenceScreen();
        this.pRa.clear();
        if (this.pQV.csR().Lcn != null && this.pQV.csR().Lcn.size() > 0) {
            this.pRa.addAll(l.cX(this.pQV.csR().Lcn));
        }
        if (this.pQV.csR().Lco != null && this.pQV.csR().Lco.size() > 0) {
            List<com.tencent.mm.plugin.card.model.b> cX = l.cX(this.pQV.csR().Lco);
            cX.get(0).pSj = true;
            this.pRa.addAll(cX);
        }
        cvc();
        cvb();
        cva();
        if (!TextUtils.isEmpty(this.pQV.csQ().LeE)) {
            CardTextPreference cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(R.layout.b8j);
            cardTextPreference.setTitle(getString(R.string.arr));
            cardTextPreference.setKey("key_pic_detail");
            cardTextPreference.cxK();
            cvc();
            this.nRm.c(cardTextPreference);
        }
        if (!TextUtils.isEmpty(this.pQV.csQ().LeB)) {
            cvc();
            CardTextPreference cardTextPreference2 = new CardTextPreference(this);
            cardTextPreference2.setLayoutResource(R.layout.b8j);
            cardTextPreference2.setKey("card_phone");
            cardTextPreference2.setTitle(R.string.ar4);
            cardTextPreference2.setSummary(this.pQV.csQ().LeB);
            cardTextPreference2.qlp = getResources().getColor(R.color.x0);
            cardTextPreference2.cxJ();
            this.nRm.c(cardTextPreference2);
            ajE("");
        }
        if (!(this.pQV.csQ() == null || TextUtils.isEmpty(this.pQV.csQ().source) || this.pYZ == null)) {
            this.pYZ.setText(this.pQV.csQ().source);
            this.pYZ.setVisibility(0);
        }
        AppMethodBeat.o(113192);
    }

    private void cva() {
        AppMethodBeat.i(113193);
        for (int i2 = 0; i2 < this.pRa.size(); i2++) {
            com.tencent.mm.plugin.card.model.b bVar = this.pRa.get(i2);
            Preference preference = new Preference(this);
            preference.setLayoutResource(R.layout.b8j);
            preference.setKey(bVar.title);
            preference.setTitle(bVar.title);
            if (!TextUtils.isEmpty(bVar.pRY)) {
                preference.setSummary(bVar.pRY);
            }
            if (bVar.pSj) {
                cvc();
            }
            this.nRm.c(preference);
        }
        AppMethodBeat.o(113193);
    }

    private void cvb() {
        AppMethodBeat.i(113194);
        if (!(this.pQV.csQ().LeD == null || this.pQV.csQ().LeD == null)) {
            for (int i2 = 0; i2 < this.pQV.csQ().LeD.size(); i2++) {
                abz abz = this.pQV.csQ().LeD.get(i2);
                if (!TextUtils.isEmpty(abz.pRY)) {
                    CardTextPreference cardTextPreference = new CardTextPreference(this);
                    cardTextPreference.setLayoutResource(R.layout.b8j);
                    cardTextPreference.setTitle(abz.pRY);
                    cardTextPreference.cxK();
                    ajE(abz.title);
                    this.nRm.c(cardTextPreference);
                }
            }
            cvc();
        }
        AppMethodBeat.o(113194);
    }

    private void cvc() {
        AppMethodBeat.i(113195);
        this.nRm.c(new PreferenceSmallCategory(this));
        AppMethodBeat.o(113195);
    }

    private void ajE(String str) {
        AppMethodBeat.i(113196);
        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
        if (TextUtils.isEmpty(str)) {
            preferenceTitleCategory.setTitle(" ");
        } else {
            preferenceTitleCategory.setTitle(str);
        }
        this.nRm.c(preferenceTitleCategory);
        AppMethodBeat.o(113196);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.s;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public View getFooterView() {
        AppMethodBeat.i(113198);
        View inflate = getLayoutInflater().inflate(R.layout.byk, (ViewGroup) null);
        this.pYZ = (TextView) inflate.findViewById(R.id.i2x);
        this.pYZ.setVisibility(8);
        AppMethodBeat.o(113198);
        return inflate;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(113197);
        if (preference.mKey.equals("card_phone")) {
            String str = this.pQV.csQ().LeB;
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        if (!preference.mKey.equals("key_pic_detail")) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.pRa.size()) {
                    break;
                }
                com.tencent.mm.plugin.card.model.b bVar = this.pRa.get(i2);
                if (bVar.title != null && bVar.title.equals(preference.mKey) && !TextUtils.isEmpty(bVar.url)) {
                    if (com.tencent.mm.plugin.card.d.b.V(this.pQV.csU(), bVar.Leo, bVar.Lep)) {
                        AppMethodBeat.o(113197);
                        break;
                    }
                    com.tencent.mm.plugin.card.d.b.a(this, bVar.url, 1);
                }
                i2++;
            }
        } else {
            com.tencent.mm.plugin.card.d.b.a(this, this.pQV.csQ().LeE, 0);
        }
        AppMethodBeat.o(113197);
        return false;
    }
}
