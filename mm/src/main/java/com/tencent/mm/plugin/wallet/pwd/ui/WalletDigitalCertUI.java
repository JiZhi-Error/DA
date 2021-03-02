package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.c.ac;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.d;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI extends WalletBaseUI {
    private ScrollView HJk;
    private Button HJl;
    private LinearLayout HJm;
    private TextView HJn;
    private ImageView HJo;
    private ImageView HJp;
    private TextView HJq;
    private TextView HJr;
    private ImageView gBZ;
    private Button kjo;
    private TextView uzB;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69635);
        super.onCreate(bundle);
        addSceneEndListener(1654);
        addSceneEndListener(1568);
        addSceneEndListener(1669);
        initView();
        h.INSTANCE.a(13731, 1);
        AppMethodBeat.o(69635);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69636);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.f3048f));
        this.gBZ = (ImageView) findViewById(R.id.aqd);
        this.uzB = (TextView) findViewById(R.id.aqf);
        ao.a(this.uzB.getPaint(), 0.8f);
        this.HJl = (Button) findViewById(R.id.dz4);
        this.kjo = (Button) findViewById(R.id.bli);
        this.HJm = (LinearLayout) findViewById(R.id.dz7);
        this.HJn = (TextView) findViewById(R.id.dz8);
        this.HJl.setOnClickListener(new d() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.d
            public final void onClick(View view) {
                AppMethodBeat.i(69630);
                Intent intent = new Intent();
                intent.setClass(WalletDigitalCertUI.this, WalletIdCardCheckUI.class);
                WalletDigitalCertUI.this.startActivityForResult(intent, 1);
                AppMethodBeat.o(69630);
            }
        });
        this.kjo.setOnClickListener(new d() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass2 */

            @Override // com.tencent.mm.wallet_core.ui.d
            public final void onClick(View view) {
                AppMethodBeat.i(69631);
                e eVar = new e((Context) WalletDigitalCertUI.this.getContext(), 1, true);
                TextView textView = new TextView(WalletDigitalCertUI.this.getContext());
                textView.setGravity(17);
                textView.setHeight(a.fromDPToPix((Context) WalletDigitalCertUI.this.getContext(), 56));
                textView.setTextSize(12.0f);
                textView.setTextColor(WalletDigitalCertUI.this.getResources().getColor(R.color.FG_1));
                textView.setText(WalletDigitalCertUI.this.getString(R.string.ild, new Object[]{WalletDigitalCertUI.this.getString(R.string.ile)}));
                eVar.V(textView, false);
                eVar.QOp = true;
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(214076);
                        mVar.a(1, WalletDigitalCertUI.this.getContext().getResources().getColor(R.color.Red), WalletDigitalCertUI.this.getString(R.string.ilf));
                        AppMethodBeat.o(214076);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(214077);
                        ad.hhv();
                        WalletDigitalCertUI.this.doSceneProgress(new com.tencent.mm.wallet_core.c.o(ad.getCrtNo()));
                        h.INSTANCE.a(13731, 10);
                        AppMethodBeat.o(214077);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(69631);
            }
        });
        this.HJk = (ScrollView) findViewById(R.id.aqp);
        setBackBtn(new y() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.y
            public final void ane() {
                AppMethodBeat.i(69632);
                WalletDigitalCertUI.this.finish();
                AppMethodBeat.o(69632);
            }
        });
        fPd();
        this.HJo = (ImageView) findViewById(R.id.aqk);
        this.HJp = (ImageView) findViewById(R.id.aqm);
        this.HJq = (TextView) findViewById(R.id.aqh);
        this.HJr = (TextView) findViewById(R.id.aqi);
        this.HJq.post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(214078);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WalletDigitalCertUI.this.HJo.getLayoutParams();
                layoutParams.topMargin = WalletDigitalCertUI.this.HJq.getLineHeight() / 2;
                WalletDigitalCertUI.this.HJo.setLayoutParams(layoutParams);
                AppMethodBeat.o(214078);
            }
        });
        this.HJr.post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(214079);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WalletDigitalCertUI.this.HJp.getLayoutParams();
                layoutParams.topMargin = WalletDigitalCertUI.this.HJr.getLineHeight() / 2;
                WalletDigitalCertUI.this.HJp.setLayoutParams(layoutParams);
                AppMethodBeat.o(214079);
            }
        });
        AppMethodBeat.o(69636);
    }

    private void fPd() {
        AppMethodBeat.i(69637);
        Log.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
        this.HJm.removeAllViews();
        Vector<ac> vector = ad.hhv().Rus;
        if (ad.hhv().hhw()) {
            this.HJl.setVisibility(8);
            this.kjo.setVisibility(0);
            this.uzB.setText(R.string.ily);
            if (vector.size() == 0 || vector.size() == 1) {
                this.HJk.setFillViewport(true);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kjo.getLayoutParams();
                layoutParams.removeRule(3);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = a.fromDPToPix((Context) getContext(), 96);
                this.kjo.setLayoutParams(layoutParams);
            } else {
                this.HJk.setFillViewport(false);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kjo.getLayoutParams();
                layoutParams2.removeRule(12);
                layoutParams2.addRule(3, R.id.aql);
                layoutParams2.topMargin = a.fromDPToPix((Context) getContext(), 48);
                layoutParams2.bottomMargin = a.fromDPToPix((Context) getContext(), 64);
                this.kjo.setLayoutParams(layoutParams2);
            }
        } else {
            this.HJl.setVisibility(0);
            this.kjo.setVisibility(8);
            this.uzB.setText(R.string.ilh);
            if (vector.size() == 0) {
                this.HJk.setFillViewport(true);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.HJl.getLayoutParams();
                layoutParams3.removeRule(3);
                layoutParams3.addRule(12);
                layoutParams3.bottomMargin = a.fromDPToPix((Context) getContext(), 96);
                this.HJl.setLayoutParams(layoutParams3);
            } else {
                this.HJk.setFillViewport(false);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.HJl.getLayoutParams();
                layoutParams4.removeRule(12);
                layoutParams4.addRule(3, R.id.aql);
                layoutParams4.topMargin = a.fromDPToPix((Context) getContext(), 48);
                layoutParams4.bottomMargin = a.fromDPToPix((Context) getContext(), 64);
                this.HJl.setLayoutParams(layoutParams4);
            }
        }
        if (vector.size() == 0) {
            this.HJm.setVisibility(8);
            this.HJn.setVisibility(8);
            AppMethodBeat.o(69637);
            return;
        }
        this.HJm.setVisibility(0);
        this.HJn.setVisibility(0);
        Iterator<ac> it = vector.iterator();
        while (it.hasNext()) {
            ac next = it.next();
            if (next.Rum <= 0) {
                View inflate = View.inflate(this, R.layout.c8g, null);
                TextView textView = (TextView) inflate.findViewById(R.id.bll);
                ((TextView) inflate.findViewById(R.id.aqn)).setText(next.Ntg);
                ((TextView) inflate.findViewById(R.id.aqe)).setText(next.Rul);
                textView.setTag(next);
                textView.setOnClickListener(new d() {
                    /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass6 */

                    @Override // com.tencent.mm.wallet_core.ui.d
                    public final void onClick(View view) {
                        AppMethodBeat.i(214082);
                        if (view.getTag() instanceof ac) {
                            final ac acVar = (ac) view.getTag();
                            e eVar = new e((Context) WalletDigitalCertUI.this.getContext(), 1, true);
                            TextView textView = new TextView(WalletDigitalCertUI.this.getContext());
                            textView.setGravity(17);
                            textView.setHeight(a.fromDPToPix((Context) WalletDigitalCertUI.this.getContext(), 56));
                            textView.setTextSize(12.0f);
                            textView.setTextColor(WalletDigitalCertUI.this.getResources().getColor(R.color.FG_1));
                            textView.setText(WalletDigitalCertUI.this.getString(R.string.ild, new Object[]{acVar.Ntg}));
                            eVar.V(textView, false);
                            eVar.QOp = true;
                            eVar.HLX = new o.f() {
                                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass6.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.base.o.f
                                public final void onCreateMMMenu(m mVar) {
                                    AppMethodBeat.i(214080);
                                    mVar.a(1, WalletDigitalCertUI.this.getContext().getResources().getColor(R.color.Red), WalletDigitalCertUI.this.getString(R.string.ilf));
                                    AppMethodBeat.o(214080);
                                }
                            };
                            eVar.HLY = new o.g() {
                                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.AnonymousClass6.AnonymousClass2 */

                                @Override // com.tencent.mm.ui.base.o.g
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                    AppMethodBeat.i(214081);
                                    Log.i("MicroMsg.WalletDigitalCertUI", "del crt %s", acVar.NgK);
                                    WalletDigitalCertUI.this.doSceneProgress(new com.tencent.mm.wallet_core.c.o(acVar.NgK));
                                    kz kzVar = new kz();
                                    kzVar.eEH = 2;
                                    kzVar.eXI = 1;
                                    kzVar.bfK();
                                    AppMethodBeat.o(214081);
                                }
                            };
                            eVar.dGm();
                        }
                        AppMethodBeat.o(214082);
                    }
                });
                this.HJm.addView(inflate);
            }
        }
        if (this.HJm.getChildCount() == 0) {
            this.HJn.setVisibility(8);
            AppMethodBeat.o(69637);
            return;
        }
        this.HJn.setVisibility(0);
        AppMethodBeat.o(69637);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69638);
        super.onResume();
        AppMethodBeat.o(69638);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(69639);
        super.onPause();
        AppMethodBeat.o(69639);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69640);
        super.onDestroy();
        removeSceneEndListener(1654);
        removeSceneEndListener(1568);
        removeSceneEndListener(1669);
        AppMethodBeat.o(69640);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69641);
        if (!(qVar instanceof n)) {
            if (qVar instanceof com.tencent.mm.wallet_core.c.o) {
                if (i3 == 0) {
                    kz kzVar = new kz();
                    kzVar.eEH = 2;
                    kzVar.eXI = 2;
                    kzVar.bfK();
                    h.INSTANCE.a(13731, 11);
                    ad.hhv().bpo(((com.tencent.mm.wallet_core.c.o) qVar).RtT);
                    Toast makeText = Toast.makeText(getContext(), "", 0);
                    View inflate = View.inflate(getContext(), R.layout.pd, null);
                    ((WeImageView) inflate.findViewById(R.id.irc)).setImageResource(R.raw.icons_filled_done);
                    ((TextView) inflate.findViewById(R.id.ird)).setText(getString(R.string.ilg));
                    makeText.setGravity(17, 0, 0);
                    makeText.setView(inflate);
                    makeText.show();
                } else {
                    h.INSTANCE.a(13731, 12);
                }
            }
            AppMethodBeat.o(69641);
            return false;
        }
        fPd();
        AppMethodBeat.o(69641);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69642);
        super.onActivityResult(i2, i3, intent);
        if (1 == i2 && i3 == -1) {
            boolean dJO = ((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).dJO();
            com.tencent.mm.plugin.soter.d.e flM = com.tencent.mm.plugin.soter.d.d.flM();
            String str = flM.FhU;
            String str2 = flM.hFF;
            Log.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", Boolean.valueOf(dJO));
            doSceneProgress(new n(dJO, str, str2), false);
        }
        AppMethodBeat.o(69642);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8u;
    }
}
