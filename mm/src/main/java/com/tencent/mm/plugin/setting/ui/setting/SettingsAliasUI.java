package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.setting.d;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.List;

public class SettingsAliasUI extends MMWizardActivity implements i {
    public static String Dbv;
    private TextView Dbq;
    private Button Dbr;
    private List<ye> Dbs = null;
    private boolean Dbt;
    private boolean Dbu;
    private gc Dbw = new gc();
    private String hJl;
    private int kqW;
    private ProgressDialog vIA;
    private String wZz;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsAliasUI() {
        AppMethodBeat.i(256516);
        AppMethodBeat.o(256516);
    }

    static /* synthetic */ void d(SettingsAliasUI settingsAliasUI) {
        AppMethodBeat.i(256521);
        settingsAliasUI.bpv();
        AppMethodBeat.o(256521);
    }

    static /* synthetic */ void g(SettingsAliasUI settingsAliasUI) {
        AppMethodBeat.i(256522);
        settingsAliasUI.us(true);
        AppMethodBeat.o(256522);
    }

    static /* synthetic */ void h(SettingsAliasUI settingsAliasUI) {
        AppMethodBeat.i(256523);
        settingsAliasUI.eTd();
        AppMethodBeat.o(256523);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74121);
        super.onCreate(bundle);
        d.gF(null);
        Dbv = "set_alias_" + System.currentTimeMillis();
        this.Dbw.tm(Dbv);
        initView();
        Log.i("MicroMsg.SettingsAliasUI", "root class %s", getIntent().getStringExtra("WizardRootClass"));
        g.azz().a(926, this);
        us(false);
        if (h.aqJ().getInt("EnableModAlias", 0) == 0) {
            finish();
        }
        AppMethodBeat.o(74121);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqn;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74123);
        super.onDestroy();
        g.azz().b(926, this);
        AppMethodBeat.o(74123);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74124);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.Dbq = (TextView) findViewById(R.id.hm8);
        String aTZ = z.aTZ();
        if (Util.isNullOrNil(aTZ)) {
            aTZ = z.aTY();
        }
        Log.i("MicroMsg.SettingsAliasUI", "curAlias %s", aTZ);
        this.Dbq.setText(getString(R.string.v1) + aTZ);
        this.Dbq.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.AnonymousClass1 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(256514);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (SettingsAliasUI.this.Dbq.getText() != null) {
                    final String charSequence = SettingsAliasUI.this.Dbq.getText().toString();
                    int indexOf = charSequence.indexOf(58);
                    if (indexOf >= 0 && indexOf < charSequence.length()) {
                        charSequence = charSequence.substring(indexOf + 1).trim();
                    }
                    SpannableString spannableString = new SpannableString(SettingsAliasUI.this.Dbq.getText());
                    spannableString.setSpan(new BackgroundColorSpan(SettingsAliasUI.this.getResources().getColor(R.color.ws)), indexOf + 1, SettingsAliasUI.this.Dbq.getText().length(), 33);
                    SettingsAliasUI.this.Dbq.setText(spannableString);
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(SettingsAliasUI.this, SettingsAliasUI.this.Dbq);
                    aVar.QSs = new View.OnCreateContextMenuListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.AnonymousClass1.AnonymousClass1 */

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(256511);
                            contextMenu.add(SettingsAliasUI.this.getString(R.string.t_));
                            AppMethodBeat.o(256511);
                        }
                    };
                    aVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(256512);
                            if (i2 == 0) {
                                ClipboardHelper.setText(charSequence);
                                com.tencent.mm.ui.base.h.cC(SettingsAliasUI.this, SettingsAliasUI.this.getString(R.string.ta));
                            }
                            AppMethodBeat.o(256512);
                        }
                    };
                    aVar.QwU = new PopupWindow.OnDismissListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.AnonymousClass1.AnonymousClass3 */

                        public final void onDismiss() {
                            AppMethodBeat.i(256513);
                            String aTZ = z.aTZ();
                            if (Util.isNullOrNil(aTZ)) {
                                aTZ = z.aTY();
                            }
                            SettingsAliasUI.this.Dbq.setText(SettingsAliasUI.this.getString(R.string.v1) + aTZ);
                            AppMethodBeat.o(256513);
                        }
                    };
                    aVar.ez(0, 0);
                }
                a.a(true, (Object) this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(256514);
                return true;
            }
        });
        this.Dbr = (Button) findViewById(R.id.hms);
        this.Dbr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.AnonymousClass2 */

            public final void onClick(View view) {
                int i2 = 0;
                AppMethodBeat.i(256515);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SettingsAliasUI", "click next, allPass %s", Boolean.valueOf(SettingsAliasUI.this.Dbt));
                SettingsAliasUI.this.Dbw.ejW = 1;
                if (SettingsAliasUI.this.Dbt) {
                    SettingsAliasUI.this.Dbw.bfK();
                    SettingsAliasUI.d(SettingsAliasUI.this);
                } else if (SettingsAliasUI.this.Dbs == null || SettingsAliasUI.this.Dbs.isEmpty()) {
                    SettingsAliasUI.this.Dbu = true;
                    SettingsAliasUI.g(SettingsAliasUI.this);
                } else {
                    for (int i3 = 0; i3 < SettingsAliasUI.this.Dbs.size(); i3++) {
                        if (((ye) SettingsAliasUI.this.Dbs.get(i3)).Lje) {
                            i2 = i2;
                        } else if (i3 == 0) {
                            i2 |= 1;
                        } else {
                            i2 |= 2;
                        }
                    }
                    SettingsAliasUI.this.Dbw.eIu = (long) i2;
                    SettingsAliasUI.this.Dbw.bfK();
                    SettingsAliasUI.h(SettingsAliasUI.this);
                }
                a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(256515);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74117);
                SettingsAliasUI.this.Dbw.ejW = 7;
                SettingsAliasUI.this.Dbw.bfK();
                SettingsAliasUI.this.onBackPressed();
                AppMethodBeat.o(74117);
                return true;
            }
        });
        AppMethodBeat.o(74124);
    }

    private void us(boolean z) {
        AppMethodBeat.i(256517);
        g.azz().a(new com.tencent.mm.plugin.account.model.g(), 0);
        if (z) {
            this.vIA = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.wc), false, (DialogInterface.OnCancelListener) null);
        }
        AppMethodBeat.o(256517);
    }

    private void bpv() {
        AppMethodBeat.i(256518);
        switch (this.kqW) {
            case 1:
                Intent intent = new Intent(this, VerifyPwdUI.class);
                intent.putExtra("key_scenen", 2);
                startActivityForResult(intent, 10001);
                AppMethodBeat.o(256518);
                return;
            case 2:
                if (!Util.isNullOrNil(this.hJl)) {
                    com.tencent.mm.plugin.account.a.b.a.b(this, this.hJl, 10002, true);
                    AppMethodBeat.o(256518);
                    return;
                }
                break;
            default:
                if (!Util.isNullOrNil(this.hJl)) {
                    com.tencent.mm.plugin.account.a.b.a.b(this, this.hJl, 0, true);
                    break;
                }
                break;
        }
        AppMethodBeat.o(256518);
    }

    private void eTd() {
        AppMethodBeat.i(256519);
        MMWizardActivity.ay(this, new Intent(this, SettingsModifyAliasCheckUI.class));
        AppMethodBeat.o(256519);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String string;
        AppMethodBeat.i(256520);
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Boolean.valueOf(i3 == -1);
        objArr[2] = Boolean.valueOf(intent == null);
        Log.i("MicroMsg.SettingsAliasUI", "requestCode %d, resultCode OK %s, data == null %s", objArr);
        if (intent == null) {
            AppMethodBeat.o(256520);
            return;
        }
        if (i2 == 10001) {
            if (i3 == -1) {
                Intent intent2 = new Intent(this, SettingsModifyAliasUI.class);
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(1);
                arrayList.add(2);
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add(this.wZz);
                arrayList2.add(intent.getStringExtra("key_ticket"));
                intent2.putIntegerArrayListExtra("key_ticket_type", arrayList);
                intent2.putStringArrayListExtra("key_ticket", arrayList2);
                MMWizardActivity.ay(this, intent2);
                AppMethodBeat.o(256520);
                return;
            }
        } else if (i2 == 10002 && i3 == -1) {
            Bundle bundleExtra = intent.getBundleExtra("result_data");
            if (bundleExtra == null) {
                string = "";
            } else {
                string = bundleExtra.getString("result_json");
            }
            Log.i("MicroMsg.SettingsAliasUI", "face recog, result: %s", string);
            if (!Util.isNullOrNil(string)) {
                try {
                    String string2 = new com.tencent.mm.ab.i(string).getString("ticket");
                    Intent intent3 = new Intent(this, SettingsModifyAliasUI.class);
                    ArrayList<Integer> arrayList3 = new ArrayList<>();
                    arrayList3.add(1);
                    arrayList3.add(3);
                    ArrayList<String> arrayList4 = new ArrayList<>();
                    arrayList4.add(this.wZz);
                    arrayList4.add(string2);
                    intent3.putIntegerArrayListExtra("key_ticket_type", arrayList3);
                    intent3.putStringArrayListExtra("key_ticket", arrayList4);
                    MMWizardActivity.ay(this, intent3);
                    AppMethodBeat.o(256520);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.SettingsAliasUI", "jump face recog error, %s", e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(256520);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(74125);
        Log.i("MicroMsg.SettingsAliasUI", "errType %d, errCode %d, errMsg %s, doubleCheck %s", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.Dbu));
        if (this.vIA != null) {
            this.vIA.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            this.Dbs = ((yd) ((com.tencent.mm.plugin.account.model.g) qVar).iUB.iLL.iLR).Ljd;
            Log.i("MicroMsg.SettingsAliasUI", "conditions %d", Integer.valueOf(this.Dbs.size()));
            this.kqW = ((yd) ((com.tencent.mm.plugin.account.model.g) qVar).iUB.iLL.iLR).kqW;
            this.hJl = ((yd) ((com.tencent.mm.plugin.account.model.g) qVar).iUB.iLL.iLR).hJl;
            this.wZz = ((yd) ((com.tencent.mm.plugin.account.model.g) qVar).iUB.iLL.iLR).dHx;
            if (this.Dbs == null || this.Dbs.isEmpty()) {
                Toast.makeText(this, getString(R.string.u4), 0).show();
                AppMethodBeat.o(74125);
                return;
            }
            this.Dbt = true;
            d.gF(this.Dbs);
            for (ye yeVar : this.Dbs) {
                this.Dbt = this.Dbt && yeVar.Lje;
            }
            Log.i("MicroMsg.SettingsAliasUI", "onSceneEnd, allPass %s", Boolean.valueOf(this.Dbt));
            if (this.Dbu) {
                if (!this.Dbt) {
                    eTd();
                    AppMethodBeat.o(74125);
                    return;
                }
                bpv();
                AppMethodBeat.o(74125);
                return;
            }
        } else {
            Toast.makeText(this, getString(R.string.u5), 0).show();
        }
        AppMethodBeat.o(74125);
    }
}
