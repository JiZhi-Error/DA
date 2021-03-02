package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import java.util.LinkedList;

public class WalletRealNameVerifyUI extends WalletBaseUI implements View.OnClickListener, WalletFormView.a {
    private boolean HRA = false;
    private boolean HRB = false;
    private WalletFormView HRs;
    private WalletFormView HRt;
    private WalletFormView HRu;
    private WalletFormView HRv;
    private CheckBox HRw;
    private TextView HRx;
    private ElementQuery HRy;
    private Profession HRz;
    private String cityCode;
    private String countryCode;
    private Button krs;
    private Profession[] mProfessions;
    private String provinceCode;
    private TextView yyx;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletRealNameVerifyUI walletRealNameVerifyUI, q qVar) {
        AppMethodBeat.i(70066);
        walletRealNameVerifyUI.q(qVar);
        AppMethodBeat.o(70066);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70057);
        super.onCreate(bundle);
        this.mNetSceneMgr.addSceneEndListener(1616);
        this.HRy = (ElementQuery) getInput().getParcelable("elemt_query");
        initView();
        doSceneForceProgress(new l());
        AppMethodBeat.o(70057);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70058);
        this.mNetSceneMgr.removeSceneEndListener(1616);
        super.onDestroy();
        AppMethodBeat.o(70058);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70059);
        setMMTitle(R.string.ipp);
        this.krs = (Button) findViewById(R.id.fz0);
        this.HRs = (WalletFormView) findViewById(R.id.fte);
        this.HRt = (WalletFormView) findViewById(R.id.ao9);
        this.HRu = (WalletFormView) findViewById(R.id.ghg);
        this.HRv = (WalletFormView) findViewById(R.id.gh9);
        this.HRx = (TextView) findViewById(R.id.dyz);
        this.HRs.setOnInputValidChangeListener(this);
        this.HRt.setOnInputValidChangeListener(this);
        this.HRu.setOnInputValidChangeListener(this);
        this.HRv.setOnInputValidChangeListener(this);
        this.HRs.setFocusable(true);
        this.HRs.getInfoIv().setVisibility(8);
        a.d(this.HRt);
        b logicDelegate = this.HRt.getLogicDelegate();
        if (logicDelegate instanceof a.C2170a) {
            ((a.C2170a) logicDelegate).aqn(1);
        }
        this.HRu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(70048);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(WalletRealNameVerifyUI.this.getContext(), WalletSelectProfessionUI.class);
                intent.putExtra("key_profession_list", WalletRealNameVerifyUI.this.mProfessions);
                WalletRealNameVerifyUI.this.startActivityForResult(intent, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70048);
            }
        });
        this.HRv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70049);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("GetAddress", true);
                intent.putExtra("ShowSelectedLocation", false);
                intent.putExtra("IsRealNameVerifyScene", true);
                intent.putExtra("IsNeedShowSearchBar", true);
                c.c(WalletRealNameVerifyUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", intent, 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70049);
            }
        });
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(70050);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this, WalletRealNameVerifyUI.this.HRs.getText(), WalletRealNameVerifyUI.this.HRt.getText());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70050);
            }
        });
        setEditFocusListener(this.HRt, 1, false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(70051);
                a aVar = (a) WalletRealNameVerifyUI.this.getProcess();
                if (aVar != null) {
                    aVar.g(WalletRealNameVerifyUI.this, 0);
                }
                WalletRealNameVerifyUI.this.finish();
                AppMethodBeat.o(70051);
                return true;
            }
        });
        this.HRw = (CheckBox) findViewById(R.id.id);
        this.yyx = (TextView) findViewById(R.id.ib);
        this.HRw.setChecked(true);
        this.HRw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.AnonymousClass5 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(70052);
                if (z) {
                    WalletRealNameVerifyUI.this.krs.setEnabled(true);
                    WalletRealNameVerifyUI.this.krs.setClickable(true);
                    AppMethodBeat.o(70052);
                    return;
                }
                WalletRealNameVerifyUI.this.krs.setEnabled(false);
                WalletRealNameVerifyUI.this.krs.setClickable(false);
                AppMethodBeat.o(70052);
            }
        });
        this.yyx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(70054);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                linkedList.add(WalletRealNameVerifyUI.this.getString(R.string.i8v));
                linkedList2.add(0);
                if (WalletRealNameVerifyUI.this.HRy != null && WalletRealNameVerifyUI.this.HRy.HXD) {
                    linkedList.add(WalletRealNameVerifyUI.this.getString(R.string.i8t));
                    linkedList2.add(1);
                }
                h.a(WalletRealNameVerifyUI.this, "", linkedList, linkedList2, "", new h.e() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.AnonymousClass6.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.e
                    public final void cy(int i2, int i3) {
                        AppMethodBeat.i(70053);
                        Intent intent = new Intent();
                        switch (i2) {
                            case 0:
                                intent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(R.string.i5i, new Object[]{LocaleUtil.getApplicationLanguage()}));
                                break;
                            case 1:
                                if (WalletRealNameVerifyUI.this.HRy != null) {
                                    intent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(R.string.i5g, new Object[]{LocaleUtil.getApplicationLanguage(), WalletRealNameVerifyUI.this.HRy.dDj}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        intent.putExtra("allow_mix_content_mode", false);
                        f.aA(WalletRealNameVerifyUI.this.getContext(), intent);
                        AppMethodBeat.o(70053);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70054);
            }
        });
        AppMethodBeat.o(70059);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, final q qVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(70060);
        if (i2 != 0 || i3 != 0) {
            Log.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
        } else if (qVar instanceof g) {
            g gVar = (g) qVar;
            if (gVar.HPz == null) {
                q(qVar);
            } else {
                Log.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify show juveniles dialog");
                h.c(this, gVar.HPz.dQx, "", gVar.HPz.IaV, gVar.HPz.IaU, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(70055);
                        Log.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify dialog lOk");
                        WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this, qVar);
                        u.xV(1);
                        AppMethodBeat.o(70055);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(70056);
                        Log.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify dialog lCancel");
                        u.xV(0);
                        AppMethodBeat.o(70056);
                    }
                });
            }
            AppMethodBeat.o(70060);
            return true;
        } else if (qVar instanceof l) {
            l lVar = (l) qVar;
            if (lVar.HQh == 1) {
                z = true;
            } else {
                z = false;
            }
            this.HRA = z;
            if (lVar.HQi == 1) {
                z2 = true;
            }
            this.HRB = z2;
            if (!this.HRB) {
                this.HRu.setVisibility(8);
            }
            if (!this.HRA) {
                this.HRv.setVisibility(8);
            }
            if (this.HRA || this.HRB) {
                this.HRx.setText(R.string.ipk);
            }
            this.mProfessions = lVar.HTV;
            AppMethodBeat.o(70060);
            return true;
        }
        AppMethodBeat.o(70060);
        return false;
    }

    private void q(q qVar) {
        AppMethodBeat.i(70061);
        d process = getProcess();
        Bundle bundle = null;
        if (process != null) {
            bundle = process.dQL;
        }
        String str = ((g) qVar).token;
        Log.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
        if (process != null) {
            bundle.putString("key_real_name_token", str);
            bundle.putString("key_country_code", this.countryCode);
            bundle.putString("key_province_code", this.provinceCode);
            bundle.putString("key_city_code", this.cityCode);
            bundle.putParcelable("key_profession", this.HRz);
            process.a(this, 0, bundle);
        }
        AppMethodBeat.o(70061);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c_r;
    }

    public void onClick(View view) {
        AppMethodBeat.i(70062);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70062);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(70063);
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1) {
            if (i2 == 2) {
                if (i3 == -1) {
                    String stringExtra = intent.getStringExtra("CountryName");
                    String stringExtra2 = intent.getStringExtra("ProviceName");
                    String stringExtra3 = intent.getStringExtra("CityName");
                    this.countryCode = intent.getStringExtra("Country");
                    this.provinceCode = intent.getStringExtra("Contact_Province");
                    this.cityCode = intent.getStringExtra("Contact_City");
                    StringBuilder sb = new StringBuilder();
                    if (!Util.isNullOrNil(stringExtra)) {
                        sb.append(stringExtra);
                    }
                    if (!Util.isNullOrNil(stringExtra2)) {
                        sb.append(" ").append(stringExtra2);
                    }
                    if (!Util.isNullOrNil(stringExtra3)) {
                        sb.append(" ").append(stringExtra3);
                    }
                    this.HRv.setText(sb.toString());
                    AppMethodBeat.o(70063);
                    return;
                }
                Log.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
            }
            AppMethodBeat.o(70063);
        } else if (i3 == -1) {
            this.HRz = (Profession) intent.getParcelableExtra("key_select_profession");
            this.HRu.setText(this.HRz.HTX);
            AppMethodBeat.o(70063);
        } else {
            Log.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
            AppMethodBeat.o(70063);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(70064);
        Log.d("MicroMsg.WalletRealNameVerifyUI", "check info");
        String text = this.HRs.getText();
        String text2 = this.HRt.getText();
        if (Util.isNullOrNil(text)) {
            z2 = false;
        } else if (Util.isNullOrNil(text2)) {
            z2 = false;
        } else {
            if (this.HRA) {
                if (!Util.isNullOrNil(this.countryCode) || !Util.isNullOrNil(this.provinceCode) || !Util.isNullOrNil(this.cityCode)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    z2 = false;
                }
            }
            if (!this.HRB || this.HRz != null) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (!z2) {
            this.krs.setEnabled(false);
            this.krs.setClickable(false);
            AppMethodBeat.o(70064);
            return;
        }
        this.krs.setEnabled(true);
        this.krs.setClickable(true);
        AppMethodBeat.o(70064);
    }

    static /* synthetic */ void a(WalletRealNameVerifyUI walletRealNameVerifyUI, String str, String str2) {
        AppMethodBeat.i(70065);
        walletRealNameVerifyUI.doSceneProgress(new g(str, str2, walletRealNameVerifyUI.getInput().getInt("entry_scene", -1)), true);
        AppMethodBeat.o(70065);
    }
}
