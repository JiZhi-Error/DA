package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.t;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI extends MMPreference implements i {
    private static final String[] EGO = {"sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other"};
    private static final int[] EGP = {1, 2, 4, 8, 16, 32, 64};
    private static final int[] EGT = {R.string.h63, R.string.h68, R.string.h69, R.string.h62, R.string.h61, R.string.h66, R.string.h64};
    private String Bqt = null;
    private HashMap<String, Boolean> EGQ = new HashMap<>(EGO.length);
    private HashMap<Integer, Boolean> EGR = new HashMap<>(EGP.length);
    private HashMap<String, Integer> EGS = new HashMap<>(EGP.length);
    private TextView EGU;
    private EditText EGV;
    private ListView EGW;
    private LinearLayout EGX;
    private int EGY;
    private int EGZ;
    private long EHa;
    private boolean EHb = false;
    private boolean EHc = false;
    s EHd = null;
    private q gxX = null;
    private f nRm;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsNotInterestUI() {
        AppMethodBeat.i(98923);
        AppMethodBeat.o(98923);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        String userName;
        AppMethodBeat.i(98924);
        super.onCreate(bundle);
        this.EGY = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
        this.EHa = getIntent().getLongExtra("sns_info_svr_id", 0);
        if (!(this.EHa == 0 || (userName = aj.faO().JJ(this.EHa).getUserName()) == null)) {
            g.aAi();
            as bjK = ((l) g.af(l.class)).aSN().bjK(userName);
            if (bjK.fuA == 2) {
                EGT[1] = R.string.h67;
            } else if (bjK.fuA == 1) {
                EGT[1] = R.string.h68;
            }
        }
        g.aAi();
        g.aAg().hqi.a(218, this);
        fiy();
        initView();
        AppMethodBeat.o(98924);
    }

    private void fiy() {
        AppMethodBeat.i(98925);
        for (String str : EGO) {
            this.EGQ.put(str, Boolean.FALSE);
        }
        for (int i2 : EGP) {
            this.EGR.put(Integer.valueOf(i2), Boolean.FALSE);
        }
        for (int i3 = 0; i3 < EGP.length; i3++) {
            this.EGS.put(EGO[i3], Integer.valueOf(EGP[i3]));
        }
        AppMethodBeat.o(98925);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98926);
        super.onDestroy();
        fiy();
        g.aAi();
        g.aAg().hqi.b(218, this);
        ij ijVar = new ij();
        ijVar.dMY.dMZ = this.EHb;
        ijVar.dMY.dNa = this.EHa;
        EventCenter.instance.publish(ijVar);
        AppMethodBeat.o(98926);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(98927);
        super.initView();
        setMMTitle(R.string.h6b);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98919);
                SnsNotInterestUI.this.finish();
                AppMethodBeat.o(98919);
                return true;
            }
        });
        this.EGU = (TextView) findViewById(R.id.hxt);
        this.EGV = (EditText) findViewById(R.id.hxu);
        this.EGW = (ListView) findViewById(16908298);
        this.EGX = (LinearLayout) findViewById(R.id.c6v);
        this.EGX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(98920);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsNotInterestUI.this.EGX.requestFocus();
                SnsNotInterestUI.this.hideVKB();
                a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98920);
            }
        });
        this.EGV.setVisibility(8);
        this.EGU.setVisibility(8);
        this.nRm = getPreferenceScreen();
        if (this.nRm == null) {
            Log.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
        } else {
            if (this.nRm.bmg("sns_expose_desc") == null) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle(R.string.h5z);
                preferenceTitleCategory.setKey("sns_expose_desc");
                this.nRm.c(preferenceTitleCategory);
            }
            for (int i2 = 0; i2 < EGO.length; i2++) {
                String str = EGO[i2];
                int i3 = EGT[i2];
                if (this.nRm.bmg(str) == null) {
                    Preference preference = new Preference(this);
                    preference.setTitle(i3);
                    preference.setKey(str);
                    preference.setLayoutResource(R.layout.b8j);
                    preference.setWidgetLayoutResource(R.layout.b8t);
                    this.nRm.c(preference);
                }
            }
        }
        addTextOptionMenu(0, getString(R.string.ahj), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98921);
                SnsNotInterestUI.b(SnsNotInterestUI.this);
                AppMethodBeat.o(98921);
                return true;
            }
        }, null, t.b.GREEN);
        enableOptionMenu(0, false);
        AppMethodBeat.o(98927);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.base.preference.MMPreference
    public int getLayoutId() {
        return R.layout.bvq;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(98928);
        if (preference == null) {
            AppMethodBeat.o(98928);
            return false;
        }
        String str = preference.mKey;
        if (this.EGQ.containsKey(str)) {
            boolean booleanValue = this.EGQ.get(str).booleanValue();
            if (booleanValue) {
                preference.setWidgetLayoutResource(R.layout.b8t);
            } else {
                preference.setWidgetLayoutResource(R.layout.b8s);
            }
            fVar.notifyDataSetChanged();
            if (!booleanValue) {
                z = true;
            } else {
                z = false;
            }
            this.EGQ.put(str, Boolean.valueOf(z));
            int intValue = this.EGS.get(str).intValue();
            this.EGR.put(Integer.valueOf(intValue), Boolean.valueOf(z));
            Log.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", str, Integer.valueOf(intValue), Boolean.valueOf(z));
            Iterator<Boolean> it = this.EGQ.values().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().booleanValue()) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                enableOptionMenu(0, true);
            } else {
                enableOptionMenu(0, false);
            }
            if (z && str.equals("sns_expose_reason_other")) {
                this.EGV.setVisibility(0);
                this.EGU.setVisibility(0);
                this.EGV.requestFocus();
                this.EHc = true;
                showVKB();
            } else if (!this.EGQ.get("sns_expose_reason_other").booleanValue()) {
                this.EGV.setVisibility(8);
                this.EGU.setVisibility(8);
                this.EGW.requestFocus();
                this.EHc = false;
                hideVKB();
            } else {
                this.EGW.requestFocus();
                hideVKB();
            }
            AppMethodBeat.o(98928);
            return true;
        }
        AppMethodBeat.o(98928);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(98929);
        Log.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (qVar.getType() == 218) {
            this.gxX.dismiss();
            this.gxX = null;
            if (((s) qVar).type == 9) {
                if (i2 == 0 && i3 == 0) {
                    this.EHb = true;
                    Toast.makeText(this, (int) R.string.h6a, 1).show();
                    finish();
                    AppMethodBeat.o(98929);
                    return;
                }
                this.EHb = false;
                Toast.makeText(this, (int) R.string.h60, 1).show();
            }
        }
        AppMethodBeat.o(98929);
    }

    static /* synthetic */ void b(SnsNotInterestUI snsNotInterestUI) {
        AppMethodBeat.i(98930);
        snsNotInterestUI.EGZ = 0;
        for (Integer num : snsNotInterestUI.EGR.keySet()) {
            int intValue = num.intValue();
            if (snsNotInterestUI.EGR.get(Integer.valueOf(intValue)).booleanValue()) {
                if (snsNotInterestUI.EGZ == 0) {
                    snsNotInterestUI.EGZ = intValue;
                } else {
                    snsNotInterestUI.EGZ |= intValue;
                }
            }
        }
        if (!(snsNotInterestUI.EHa == 0 || snsNotInterestUI.EGY == 0)) {
            AppCompatActivity context = snsNotInterestUI.getContext();
            snsNotInterestUI.getString(R.string.zb);
            snsNotInterestUI.gxX = h.a((Context) context, snsNotInterestUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(98922);
                    g.aAi();
                    g.aAg().hqi.a(SnsNotInterestUI.this.EHd);
                    AppMethodBeat.o(98922);
                }
            });
            Log.d("MicroMsg.SnsNotInterestUI", "start send not inteset, snsId:%d, scene:%d, type:%d, isNeedSupplement:%b", Long.valueOf(snsNotInterestUI.EHa), Integer.valueOf(snsNotInterestUI.EGY), Integer.valueOf(snsNotInterestUI.EGZ), Boolean.valueOf(snsNotInterestUI.EHc));
            snsNotInterestUI.EHd = new s(snsNotInterestUI.EHa, snsNotInterestUI.EGY, snsNotInterestUI.EGZ, snsNotInterestUI.EHc ? snsNotInterestUI.EGV.getText().toString() : null);
            g.aAi();
            g.aAg().hqi.a(snsNotInterestUI.EHd, 0);
        }
        AppMethodBeat.o(98930);
    }
}
