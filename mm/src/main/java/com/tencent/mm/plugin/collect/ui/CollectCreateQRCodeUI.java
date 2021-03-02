package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.n;
import com.tencent.mm.plugin.collect.model.t;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class CollectCreateQRCodeUI extends WalletBaseUI {
    private String mDesc = "";
    private WalletFormView qAh;
    private TextView qAi;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64099);
        super.onCreate(bundle);
        addSceneEndListener(1335);
        initView();
        AppMethodBeat.o(64099);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64100);
        super.onDestroy();
        removeSceneEndListener(1335);
        AppMethodBeat.o(64100);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64101);
        setMMTitle(R.string.b6k);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(64091);
                CollectCreateQRCodeUI.this.setResult(0);
                CollectCreateQRCodeUI.this.finish();
                AppMethodBeat.o(64091);
                return true;
            }
        });
        this.qAh = (WalletFormView) findViewById(R.id.fjf);
        a.f(this.qAh);
        String stringExtra = getIntent().getStringExtra("key_currency_unit");
        if (!Util.isNullOrNil(stringExtra)) {
            this.qAh.getTitleTv().setText(stringExtra);
        } else {
            this.qAh.getTitleTv().setText(ah.hhz());
        }
        this.qAh.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(64092);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                AppMethodBeat.o(64092);
            }
        });
        setEditFocusListener(this.qAh, 2, false);
        ((Button) findViewById(R.id.fz0)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(64093);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                double d2 = Util.getDouble(CollectCreateQRCodeUI.this.qAh.getText(), 0.0d);
                g.aAi();
                int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                Log.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", Integer.valueOf(intValue));
                if (!CollectCreateQRCodeUI.this.qAh.bql()) {
                    u.makeText(CollectCreateQRCodeUI.this.getContext(), (int) R.string.i7f, 0).show();
                } else if (d2 < 0.01d) {
                    u.makeText(CollectCreateQRCodeUI.this.getContext(), (int) R.string.g1j, 0).show();
                } else if (intValue == 8) {
                    CollectCreateQRCodeUI.this.doSceneForceProgress(new n(Math.round(d2 * 100.0d), CollectCreateQRCodeUI.this.mDesc, z.aUf()));
                } else {
                    CollectCreateQRCodeUI.this.doSceneProgress(new t(d2, "1", CollectCreateQRCodeUI.this.mDesc));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64093);
            }
        });
        this.qAi = (TextView) findViewById(R.id.b6n);
        this.qAi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(64097);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CollectCreateQRCodeUI.this.hideTenpayKB();
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(CollectCreateQRCodeUI.this, CollectCreateQRCodeUI.this.getString(R.string.b6l), CollectCreateQRCodeUI.this.mDesc, "", true, 32, new h.b() {
                    /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.b
                    public final boolean onFinish(CharSequence charSequence) {
                        AppMethodBeat.i(64094);
                        if (!Util.isNullOrNil(charSequence.toString())) {
                            CollectCreateQRCodeUI.this.mDesc = charSequence.toString();
                            CollectCreateQRCodeUI.c(CollectCreateQRCodeUI.this);
                        } else {
                            CollectCreateQRCodeUI.this.mDesc = "";
                            CollectCreateQRCodeUI.c(CollectCreateQRCodeUI.this);
                        }
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(213195);
                                CollectCreateQRCodeUI.this.hideVKB();
                                AppMethodBeat.o(213195);
                            }
                        }, 200);
                        AppMethodBeat.o(64094);
                        return true;
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass4.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(64096);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass4.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(64095);
                                CollectCreateQRCodeUI.this.hideVKB();
                                AppMethodBeat.o(64095);
                            }
                        }, 500);
                        AppMethodBeat.o(64096);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64097);
            }
        });
        AppMethodBeat.o(64101);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.v4;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64102);
        if (qVar instanceof t) {
            if (i2 == 0 && i3 == 0) {
                t tVar = (t) qVar;
                Intent intent = new Intent();
                intent.putExtra("ftf_pay_url", tVar.qwI);
                intent.putExtra("key_error_level", tVar.qwK);
                intent.putExtra("ftf_fixed_fee", tVar.qwJ);
                intent.putExtra("ftf_fixed_fee_type", tVar.dFv);
                intent.putExtra("ftf_fixed_desc", tVar.desc);
                setResult(-1, intent);
                hideVKB();
                finish();
                AppMethodBeat.o(64102);
                return true;
            }
        } else if (qVar instanceof n) {
            final n nVar = (n) qVar;
            if (i2 != 0 || i3 != 0) {
                Log.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", nVar);
            } else if (nVar.dDN == 0) {
                Intent intent2 = new Intent();
                intent2.putExtra("ftf_pay_url", nVar.qwo);
                intent2.putExtra("ftf_fixed_fee", ((double) nVar.eht) / 100.0d);
                intent2.putExtra("ftf_fixed_desc", nVar.desc);
                intent2.putExtra("key_currency_unit", nVar.qwx);
                setResult(-1, intent2);
                hideVKB();
                finish();
                AppMethodBeat.o(64102);
                return true;
            } else if (nVar.qwp == 0) {
                h.c(getContext(), nVar.qwn, nVar.qwq, false);
                AppMethodBeat.o(64102);
                return true;
            } else if (nVar.qwp == 1) {
                if (!Util.isNullOrNil(nVar.qwr) && !Util.isNullOrNil(nVar.qws)) {
                    h.c(getContext(), nVar.qwn, nVar.qwq, nVar.qws, nVar.qwr, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(64098);
                            if (!Util.isNullOrNil(nVar.qwt)) {
                                Log.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", nVar.qwt);
                                f.p(CollectCreateQRCodeUI.this.getContext(), nVar.qwt, true);
                            }
                            AppMethodBeat.o(64098);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                }
                AppMethodBeat.o(64102);
                return true;
            }
        }
        AppMethodBeat.o(64102);
        return false;
    }

    static /* synthetic */ void c(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        AppMethodBeat.i(64103);
        if (!Util.isNullOrNil(collectCreateQRCodeUI.mDesc)) {
            l lVar = new l(collectCreateQRCodeUI.getContext());
            String string = collectCreateQRCodeUI.getString(R.string.b6n);
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(collectCreateQRCodeUI, collectCreateQRCodeUI.getString(R.string.b6m, new Object[]{collectCreateQRCodeUI.mDesc, string}));
            SpannableString spannableString = new SpannableString(c2);
            spannableString.setSpan(lVar, c2.length() - string.length(), c2.length(), 33);
            collectCreateQRCodeUI.qAi.setTextColor(collectCreateQRCodeUI.getResources().getColor(R.color.uj));
            collectCreateQRCodeUI.qAi.setText(spannableString);
            AppMethodBeat.o(64103);
            return;
        }
        collectCreateQRCodeUI.qAi.setTextColor(collectCreateQRCodeUI.getResources().getColor(R.color.x0));
        collectCreateQRCodeUI.qAi.setText(R.string.b6l);
        AppMethodBeat.o(64103);
    }
}
