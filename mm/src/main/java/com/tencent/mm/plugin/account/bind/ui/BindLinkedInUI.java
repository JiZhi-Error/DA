package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.contact.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class BindLinkedInUI extends MMActivity implements i {
    private String fuT;
    private String fuU;
    private ProgressDialog iLh;
    private boolean kac = false;
    private String kad;
    private boolean kae = false;
    private boolean kaf = false;
    private boolean kag = false;
    private Bundle kah;
    private boolean kai = false;
    private boolean kaj = false;
    private TextView kak;
    private TextView kal;
    private View kam;
    private MMSwitchBtn kan;
    private TextView kao;
    private TextView kap;
    private TextView kaq;
    private String kar;
    private String kas;
    private String kat;
    private String kau;
    private String name;
    private int status;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(BindLinkedInUI bindLinkedInUI) {
        AppMethodBeat.i(109846);
        bindLinkedInUI.goBack();
        AppMethodBeat.o(109846);
    }

    static /* synthetic */ void a(BindLinkedInUI bindLinkedInUI, boolean z, boolean z2) {
        AppMethodBeat.i(109849);
        bindLinkedInUI.o(z, z2);
        AppMethodBeat.o(109849);
    }

    static /* synthetic */ void e(BindLinkedInUI bindLinkedInUI) {
        AppMethodBeat.i(109848);
        bindLinkedInUI.gh(false);
        AppMethodBeat.o(109848);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109829);
        super.onCreate(bundle);
        g.azz().a(JsApiChooseMultiMedia.CTRL_INDEX, this);
        g.azz().a(f.CTRL_INDEX, this);
        this.kah = getIntent().getBundleExtra("qrcode_bundle");
        this.kaf = this.kah != null;
        if (this.kah != null) {
            this.fuT = this.kah.getString("i");
            this.fuU = this.kah.getString("n");
            this.kar = this.kah.getString("t");
            this.kas = this.kah.getString("o");
            this.kat = this.kah.getString("s");
            this.kau = this.kah.getString("r");
            if (this.fuT == null || this.fuU == null || this.kar == null || this.kat == null || this.kau == null) {
                h.a((Context) this, getString(R.string.bc5), (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(109815);
                        BindLinkedInUI.a(BindLinkedInUI.this);
                        AppMethodBeat.o(109815);
                    }
                });
            }
        }
        this.kag = getIntent().getBooleanExtra("oversea_entry", false);
        amZ();
        if (this.kaf) {
            this.kae = true;
        }
        initView();
        if (this.kah != null && this.kac && this.kad.equals(this.fuT)) {
            this.kai = true;
            gh(true);
        }
        AppMethodBeat.o(109829);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109830);
        g.azz().b(f.CTRL_INDEX, this);
        g.azz().b(JsApiChooseMultiMedia.CTRL_INDEX, this);
        super.onDestroy();
        AppMethodBeat.o(109830);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109831);
        super.onResume();
        AppMethodBeat.o(109831);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(109832);
        super.onPause();
        AppMethodBeat.o(109832);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j1;
    }

    private void amZ() {
        boolean z = true;
        AppMethodBeat.i(109833);
        this.kad = (String) g.aAh().azQ().get(286721, (Object) null);
        this.kac = !Util.isNullOrNil(this.kad);
        this.name = (String) g.aAh().azQ().get(286722, (Object) null);
        this.status = z.aUc();
        if ((this.status & 4194304) == 0) {
            z = false;
        }
        this.kae = z;
        AppMethodBeat.o(109833);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109834);
        if (this.kaf) {
            setMMTitle(R.string.bce);
        } else if (this.kag) {
            setMMTitle(R.string.bch);
        } else {
            setMMTitle(R.string.bc8);
        }
        this.kak = (TextView) findViewById(R.id.hlr);
        this.kal = (TextView) findViewById(R.id.hls);
        this.kam = findViewById(R.id.hr5);
        this.kan = (MMSwitchBtn) findViewById(R.id.hr4);
        this.kao = (TextView) findViewById(R.id.a3u);
        this.kap = (TextView) findViewById(R.id.izq);
        this.kaq = (TextView) findViewById(R.id.aia);
        this.kak.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(109818);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = (String) g.aAh().azQ().get(286723, (Object) null);
                if (!Util.isNullOrNil(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", z.aTY());
                    c.b(BindLinkedInUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109818);
            }
        });
        this.kao.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(109820);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!BindLinkedInUI.this.kaf) {
                    BindLinkedInUI.c(BindLinkedInUI.this);
                } else if (!BindLinkedInUI.this.kac) {
                    BindLinkedInUI.e(BindLinkedInUI.this);
                } else {
                    h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(R.string.bc4), (String) null, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass7.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(109819);
                            BindLinkedInUI.e(BindLinkedInUI.this);
                            AppMethodBeat.o(109819);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass7.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                }
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109820);
            }
        });
        this.kap.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(109823);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(R.string.bc6), (String) null, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass8.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(109822);
                        final com.tencent.mm.plugin.account.bind.a.c cVar = new com.tencent.mm.plugin.account.bind.a.c();
                        BindLinkedInUI.this.iLh = h.a((Context) BindLinkedInUI.this, BindLinkedInUI.this.getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(109821);
                                g.azz().a(cVar);
                                AppMethodBeat.o(109821);
                            }
                        });
                        g.azz().a(cVar, 0);
                        AppMethodBeat.o(109822);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass8.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109823);
            }
        });
        this.kaq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(109824);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindLinkedInUI.a(BindLinkedInUI.this);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109824);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109825);
                BindLinkedInUI.a(BindLinkedInUI.this);
                AppMethodBeat.o(109825);
                return true;
            }
        });
        updateView();
        AppMethodBeat.o(109834);
    }

    private void goBack() {
        AppMethodBeat.i(109835);
        if (!this.kaf) {
            setResult(-1);
            finish();
            AppMethodBeat.o(109835);
        } else if (this.kaj) {
            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
            bZ.addFlags(603979776);
            bZ.putExtra("preferred_tab", 2);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
            a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(109835);
        } else {
            setResult(-1);
            finish();
            AppMethodBeat.o(109835);
        }
    }

    private void gh(boolean z) {
        AppMethodBeat.i(109836);
        if (this.kah == null) {
            Log.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
            AppMethodBeat.o(109836);
            return;
        }
        final com.tencent.mm.plugin.account.bind.a.a aVar = new com.tencent.mm.plugin.account.bind.a.a(this.kan.QDw ? 1 : 2, this.fuT, this.fuU, "", this.kar, this.kas, this.kat, this.kau);
        if (!z) {
            this.iLh = h.a((Context) this, getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass11 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(109826);
                    g.azz().a(aVar);
                    AppMethodBeat.o(109826);
                }
            });
        }
        g.azz().a(aVar, 0);
        AppMethodBeat.o(109836);
    }

    private void SK(String str) {
        AppMethodBeat.i(109837);
        int indexOf = getString(R.string.bc2).indexOf("%s");
        Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(getString(R.string.bc2, new Object[]{str}));
        newSpannable.setSpan(new ClickableSpan() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass12 */

            public final void onClick(View view) {
            }

            public final void updateDrawState(TextPaint textPaint) {
                AppMethodBeat.i(109827);
                textPaint.setColor(BindLinkedInUI.this.getResources().getColor(R.color.x0));
                textPaint.setUnderlineText(false);
                AppMethodBeat.o(109827);
            }
        }, indexOf, str.length() + indexOf, 33);
        this.kak.setText(newSpannable);
        AppMethodBeat.o(109837);
    }

    private void d(boolean z, String str, boolean z2) {
        AppMethodBeat.i(109838);
        this.kak.setVisibility(0);
        SK(str);
        this.kam.setVisibility(0);
        this.kap.setVisibility(8);
        if (z) {
            this.kal.setVisibility(8);
            this.kao.setVisibility(8);
            this.kaq.setVisibility(8);
            this.kan.setCheck(z2);
            this.kan.setSwitchListener(new MMSwitchBtn.a() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass13 */

                @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
                public final void onStatusChange(boolean z) {
                    AppMethodBeat.i(109828);
                    BindLinkedInUI.a(BindLinkedInUI.this, z, true);
                    AppMethodBeat.o(109828);
                }
            });
            AppMethodBeat.o(109838);
            return;
        }
        this.kal.setVisibility(0);
        this.kao.setVisibility(0);
        this.kaq.setVisibility(0);
        this.kan.setCheck(z2);
        this.kan.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(109816);
                BindLinkedInUI.a(BindLinkedInUI.this, z, false);
                AppMethodBeat.o(109816);
            }
        });
        AppMethodBeat.o(109838);
    }

    private void a(boolean z, boolean z2, String str, boolean z3) {
        AppMethodBeat.i(109839);
        this.kaq.setVisibility(8);
        if (z) {
            this.kal.setVisibility(8);
            this.kak.setVisibility(0);
            SK(str);
            this.kam.setVisibility(0);
            this.kao.setVisibility(8);
            if (z2) {
                this.kap.setVisibility(0);
            }
            this.kan.setCheck(z3);
            this.kan.setSwitchListener(new MMSwitchBtn.a() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass3 */

                @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
                public final void onStatusChange(boolean z) {
                    AppMethodBeat.i(109817);
                    BindLinkedInUI.a(BindLinkedInUI.this, z, true);
                    AppMethodBeat.o(109817);
                }
            });
            AppMethodBeat.o(109839);
            return;
        }
        this.kak.setVisibility(8);
        this.kak.setText(getString(R.string.bc3));
        this.kal.setVisibility(0);
        this.kam.setVisibility(8);
        this.kao.setVisibility(0);
        this.kap.setVisibility(8);
        AppMethodBeat.o(109839);
    }

    private void updateView() {
        boolean z = true;
        AppMethodBeat.i(109840);
        if (this.kaf && this.kah == null) {
            Log.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
            AppMethodBeat.o(109840);
        } else if (this.kag) {
            a(this.kac, false, this.name, this.kae);
            AppMethodBeat.o(109840);
        } else if (this.kaf) {
            if (!this.kac || !this.kad.equals(this.fuT)) {
                z = false;
            }
            d(z, this.fuU, this.kae);
            AppMethodBeat.o(109840);
        } else {
            a(this.kac, true, this.name, this.kae);
            AppMethodBeat.o(109840);
        }
    }

    private void o(boolean z, boolean z2) {
        AppMethodBeat.i(109841);
        if (z) {
            this.status |= 4194304;
        } else {
            this.status &= -4194305;
        }
        int i2 = z ? 1 : 2;
        g.aAh().azQ().set(7, Integer.valueOf(this.status));
        if (z2) {
            bfx bfx = new bfx();
            bfx.LPB = 33;
            bfx.BsD = i2;
            ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
            com.tencent.mm.plugin.account.a.a.jRu.WZ();
        }
        AppMethodBeat.o(109841);
    }

    private boolean x(Intent intent) {
        int i2;
        AppMethodBeat.i(109842);
        Bundle bundleExtra = intent.getBundleExtra("result_data");
        String string = bundleExtra.getString("ret");
        String string2 = bundleExtra.getString("limid");
        String string3 = bundleExtra.getString("liname");
        String string4 = bundleExtra.getString("liurl");
        String string5 = bundleExtra.getString("liswitch");
        if (Util.isNullOrNil(string)) {
            Log.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
            AppMethodBeat.o(109842);
            return false;
        }
        int safeParseInt = Util.safeParseInt(string);
        if (safeParseInt != 0) {
            Log.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", Integer.valueOf(safeParseInt));
            if (safeParseInt == 1) {
                i2 = R.string.bcc;
            } else {
                i2 = R.string.bcb;
            }
            h.c(this, getString(i2), null, true);
            AppMethodBeat.o(109842);
            return false;
        } else if (Util.isNullOrNil(string2)) {
            Log.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
            AppMethodBeat.o(109842);
            return false;
        } else {
            Log.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", string2, string3, string4, string5);
            g.aAh().azQ().set(286722, string3);
            g.aAh().azQ().set(286721, string2);
            g.aAh().azQ().set(286723, string4);
            if (!Util.isNullOrNil(string5)) {
                o(Util.safeParseInt(string5) == 1, false);
            }
            amZ();
            updateView();
            String string6 = getString(R.string.bc9);
            new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass4 */

                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            h.cD(this, string6);
            AppMethodBeat.o(109842);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109843);
        Log.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + i2 + "  resultCode:" + i3);
        if (intent == null) {
            AppMethodBeat.o(109843);
            return;
        }
        switch (i2) {
            case 100:
                x(intent);
                AppMethodBeat.o(109843);
                return;
            default:
                Log.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
                AppMethodBeat.o(109843);
                return;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        int i5;
        AppMethodBeat.i(109844);
        if (this.iLh != null) {
            this.iLh.dismiss();
            this.iLh = null;
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 549) {
                this.kaj = true;
                if (!this.kai) {
                    i5 = R.string.bc9;
                } else {
                    i5 = R.string.bc_;
                }
            } else if (qVar.getType() == 550) {
                i5 = R.string.bcj;
            } else {
                AppMethodBeat.o(109844);
                return;
            }
            String string = getString(i5);
            new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.AnonymousClass5 */

                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            h.cD(this, string);
            amZ();
            this.kae = this.kan.QDw;
            updateView();
            AppMethodBeat.o(109844);
            return;
        }
        if (qVar.getType() == 549) {
            if (i3 == 1) {
                i4 = R.string.bcc;
            } else {
                i4 = R.string.bcb;
            }
        } else if (qVar.getType() == 550) {
            i4 = R.string.bcd;
        } else {
            AppMethodBeat.o(109844);
            return;
        }
        h.c(this, getString(i4), null, true);
        AppMethodBeat.o(109844);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(109845);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(109845);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(109845);
        return onKeyDown;
    }

    static /* synthetic */ void c(BindLinkedInUI bindLinkedInUI) {
        AppMethodBeat.i(109847);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
        intent.putExtra("geta8key_username", z.aTY());
        if (bindLinkedInUI.kag) {
            intent.putExtra("geta8key_scene", 3);
        } else {
            intent.putExtra("geta8key_scene", 8);
        }
        c.b(bindLinkedInUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
        AppMethodBeat.o(109847);
    }
}
