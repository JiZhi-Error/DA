package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recharge.a.a;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.model.f;
import com.tencent.mm.plugin.recharge.ui.b;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.c;
import com.tencent.mm.plugin.recharge.ui.form.d;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.h;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI extends MMActivity implements i, d.a {
    private int BDq;
    private ArrayList<q> BDr = null;
    private ArrayList<q> BDs = null;
    private e BDt = null;
    private e BDu = null;
    private e BDv = null;
    private e BDw = null;
    private e BDx = null;
    private boolean BEA;
    private View BEd = null;
    private ImageView BEe = null;
    private TextView BEf = null;
    private MallFormView BEg = null;
    private TextView BEh = null;
    private TextView BEi = null;
    private GridView BEj = null;
    private GridView BEk = null;
    private TextView BEl = null;
    private TextView BEm = null;
    private TextView BEn = null;
    private TextView BEo = null;
    private TextView BEp = null;
    private TextView BEq = null;
    private b BEr = null;
    private b BEs = null;
    private MallFunction BEt = null;
    private String BEu = "";
    private String BEv = "";
    private c.b BEw = null;
    private p BEx = null;
    private boolean BEy = false;
    private List<String[]> BEz;
    private boolean BaO = false;
    private IListener BaR = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass15 */

        {
            AppMethodBeat.i(160831);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160831);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(67177);
            aaa aaa2 = aaa;
            if (!(aaa2 instanceof aaa)) {
                Log.f("MicroMsg.PhoneRechargeUI", "hy: mismatched event");
                AppMethodBeat.o(67177);
                return false;
            } else if (aaa2.egJ.egL) {
                Log.f("MicroMsg.PhoneRechargeUI", "WalletPayResultEvent is from kinda, ScanQRCodePay");
                AppMethodBeat.o(67177);
                return false;
            } else {
                if (aaa2.egJ.result != -1) {
                    Log.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                } else if (!PhoneRechargeUI.this.BaO) {
                    Log.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                    a.eHL().a(new com.tencent.mm.plugin.recharge.model.a(PhoneRechargeUI.this.BEg.getText(), PhoneRechargeUI.this.BEw.BDH != null ? Util.nullAsNil(PhoneRechargeUI.this.BEw.BDH.name) : "", 0));
                    PhoneRechargeUI.this.finish();
                    PhoneRechargeUI.this.BaO = true;
                }
                AppMethodBeat.o(67177);
                return true;
            }
        }
    };
    private String desc = "";
    private int errCode = 0;
    private String errMsg = "";
    private String headUrl = "";
    private String mAppId = "";
    protected Dialog tipDialog = null;
    private int wnT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PhoneRechargeUI() {
        AppMethodBeat.i(67185);
        AppMethodBeat.o(67185);
    }

    static /* synthetic */ String b(PhoneRechargeUI phoneRechargeUI, String str) {
        AppMethodBeat.i(67210);
        String aKS = phoneRechargeUI.aKS(str);
        AppMethodBeat.o(67210);
        return aKS;
    }

    static /* synthetic */ void d(PhoneRechargeUI phoneRechargeUI) {
        AppMethodBeat.i(67207);
        phoneRechargeUI.eHS();
        AppMethodBeat.o(67207);
    }

    static /* synthetic */ void e(PhoneRechargeUI phoneRechargeUI) {
        AppMethodBeat.i(67208);
        phoneRechargeUI.ad(false, false);
        AppMethodBeat.o(67208);
    }

    static /* synthetic */ void n(PhoneRechargeUI phoneRechargeUI) {
        AppMethodBeat.i(67215);
        phoneRechargeUI.eHX();
        AppMethodBeat.o(67215);
    }

    private void eHS() {
        AppMethodBeat.i(67186);
        this.mAppId = "";
        eHW();
        this.errCode = 0;
        this.errMsg = "";
        this.desc = "";
        AppMethodBeat.o(67186);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67187);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getActionbarColor());
        g.azz().a(1571, this);
        g.azz().a(com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, this);
        this.BEt = (MallFunction) getIntent().getParcelableExtra("key_func_info");
        this.BEA = getIntent().getBooleanExtra("key_need_show_remind_dialog", true);
        eHW();
        if (this.BEt == null) {
            Log.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
            u.makeText(this, "function info is null", 1).show();
            finish();
            AppMethodBeat.o(67187);
            return;
        }
        setMMTitle(this.BEt.edq);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67161);
                PhoneRechargeUI.this.hideVKB();
                PhoneRechargeUI.this.finish();
                AppMethodBeat.o(67161);
                return true;
            }
        });
        this.BDx = new e();
        this.BDx.name = getString(R.string.iq_);
        this.BDx.url = getString(R.string.iqa);
        this.BEd = findViewById(R.id.gaz);
        this.BEe = (ImageView) findViewById(R.id.fyv);
        this.BEf = (TextView) findViewById(R.id.fyw);
        this.BEg = (MallFormView) findViewById(R.id.guj);
        c.b(this.BEg);
        this.BEw = new c.b(this.BEg);
        c.b bVar = this.BEw;
        Log.d(c.TAG, "hy: setMobileEditTv");
        MallFormView mallFormView = bVar.BFp;
        c.b.AnonymousClass1 r2 = new TextWatcher() {
            /* class com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass1 */
            private int BDK = 0;

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(67277);
                String charSequence2 = charSequence.toString();
                int selectionStart = b.this.BFp.getContentEditText().getSelectionStart();
                String str = "";
                if (charSequence2 != null) {
                    StringBuilder sb = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = sb.length();
                    if (length >= 4) {
                        sb.insert(3, ' ');
                    }
                    if (length >= 8) {
                        sb.insert(8, ' ');
                    }
                    str = sb.toString();
                    int length2 = str.length();
                    if (length2 > this.BDK) {
                        if ((selectionStart == 4 || selectionStart == 9) && i4 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i4 > 1) {
                            selectionStart += i4;
                        }
                    } else if (length2 < this.BDK && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    this.BDK = length2;
                }
                if (!charSequence2.equals(str)) {
                    b.this.BFp.getContentEditText().setText(str);
                    if (selectionStart < this.BDK) {
                        b.this.BFp.getContentEditText().setSelection(selectionStart);
                        AppMethodBeat.o(67277);
                        return;
                    }
                    b.this.BFp.getContentEditText().setSelection(this.BDK);
                }
                AppMethodBeat.o(67277);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        };
        if (mallFormView.BFv != null) {
            mallFormView.BFv.addTextChangedListener(r2);
        }
        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) bVar.BFp.getContentEditText();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(67278);
                b.this.BDG = com.tencent.mm.pluginsdk.b.dO(b.this.BFp.getContext());
                if (b.this.BFq != null) {
                    b.this.BFq.BDG = b.this.BDG;
                }
                AppMethodBeat.o(67278);
            }
        }, "fetch_phone_book");
        bVar.BFq = new d(bVar.BFp, bVar.BDG);
        bVar.BFq.BGd = new d.AbstractC1629d() {
            /* class com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass3 */
        };
        bVar.BFq.BGe = this;
        instantAutoCompleteTextView.setShowAlways(true);
        instantAutoCompleteTextView.setAdapter(bVar.BFq);
        instantAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(instantAutoCompleteTextView) {
            /* class com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass4 */
            final /* synthetic */ InstantAutoCompleteTextView BFt;

            {
                this.BFt = r2;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(67279);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MallCommonHintViewConfig$MobileConfigure$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                b.this.BDH = b.this.BFq.Vp(i2);
                if (b.this.BDH != null) {
                    Log.i(c.TAG, "onItemClick record.record " + b.this.BDH.BCX + ", record.name " + b.this.BDH.name);
                    b.this.BFr = true;
                    b.this.setInput(b.this.BDH);
                } else {
                    Log.w(c.TAG, "record is null");
                }
                this.BFt.dismissDropDown();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MallCommonHintViewConfig$MobileConfigure$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(67279);
            }
        });
        bVar.BFp.setOnFocusChangeListener(new View.OnFocusChangeListener(instantAutoCompleteTextView) {
            /* class com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass5 */
            final /* synthetic */ InstantAutoCompleteTextView BFt;

            {
                this.BFt = r2;
            }

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(67280);
                if (z) {
                    this.BFt.setHintTextColor(view.getContext().getResources().getColor(R.color.BW_0_Alpha_0_2));
                    if (b.this.BDH != null && b.this.BDH.sourceType == 2 && !b.this.BFr) {
                        Log.d(c.TAG, "clear input");
                        b.this.BFp.eIj();
                        b.this.BDH = null;
                    } else if (b.this.BFr) {
                        b.this.BFr = false;
                    }
                    if (Util.isNullOrNil(this.BFt.getText().toString())) {
                        this.BFt.showDropDown();
                    }
                }
                AppMethodBeat.o(67280);
            }
        });
        instantAutoCompleteTextView.setOnClickListener(new View.OnClickListener(instantAutoCompleteTextView) {
            /* class com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass6 */
            final /* synthetic */ InstantAutoCompleteTextView BFt;

            {
                this.BFt = r2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(67281);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MallCommonHintViewConfig$MobileConfigure$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.BFt.requestFocus();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MallCommonHintViewConfig$MobileConfigure$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67281);
            }
        });
        this.BEj = (GridView) findViewById(R.id.gv1);
        this.BEl = (TextView) findViewById(R.id.gv9);
        this.BEm = (TextView) findViewById(R.id.gv_);
        this.BEn = (TextView) findViewById(R.id.guh);
        this.BEo = (TextView) findViewById(R.id.gux);
        this.BEh = (TextView) findViewById(R.id.gv3);
        this.BEi = (TextView) findViewById(R.id.gv5);
        this.BEk = (GridView) findViewById(R.id.guk);
        this.BEp = (TextView) findViewById(R.id.gv2);
        this.BEq = (TextView) findViewById(R.id.gv4);
        this.BEg.setOnInputValidChangeListener(new MallFormView.a() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.recharge.ui.form.MallFormView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(67174);
                if (z) {
                    PhoneRechargeUI.this.hideVKB();
                    final String Ts = b.Ts(PhoneRechargeUI.this.BEg.getText());
                    if (Ts == null) {
                        Log.e("MicroMsg.PhoneRechargeUI", "null phone, return");
                        AppMethodBeat.o(67174);
                        return;
                    }
                    ThreadPool.postAtFront(new Runnable() {
                        /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass12.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(67173);
                            long currentTimeMillis = System.currentTimeMillis();
                            final com.tencent.mm.plugin.recharge.model.a a2 = PhoneRechargeUI.a(PhoneRechargeUI.this, Ts);
                            Log.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass12.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(67172);
                                    PhoneRechargeUI.this.BEw.setInput(a2);
                                    PhoneRechargeUI.aKV(Ts);
                                    AppMethodBeat.o(67172);
                                }
                            });
                            AppMethodBeat.o(67173);
                        }
                    }, "search_matched_mobile");
                    if (!PhoneRechargeUI.this.BEy) {
                        Log.d("MicroMsg.PhoneRechargeUI", "clear focus");
                        PhoneRechargeUI.this.BEy = true;
                        AppMethodBeat.o(67174);
                        return;
                    }
                    PhoneRechargeUI.this.BEy = false;
                    AppMethodBeat.o(67174);
                    return;
                }
                PhoneRechargeUI.this.BEg.getTipsTv().setText("");
                PhoneRechargeUI.this.BEg.getTipsTv().setTextColor(PhoneRechargeUI.this.getResources().getColor(R.color.a2x));
                PhoneRechargeUI.d(PhoneRechargeUI.this);
                PhoneRechargeUI.e(PhoneRechargeUI.this);
                if (Util.isNullOrNil(PhoneRechargeUI.this.BEg.getText())) {
                    ((AutoCompleteTextView) PhoneRechargeUI.this.BEg.getContentEditText()).showDropDown();
                }
                AppMethodBeat.o(67174);
            }
        });
        this.BEg.getInfoIv().setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(67178);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.pluginsdk.permission.b.a(PhoneRechargeUI.this.getContext(), "android.permission.READ_CONTACTS", 48, (String) null, (String) null)) {
                    Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
                    if (Util.isIntentAvailable(PhoneRechargeUI.this, intent)) {
                        PhoneRechargeUI.this.startActivityForResult(intent, 1);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67178);
            }
        });
        this.BEr = new b();
        this.BEr.BDW = new b.a() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass17 */

            @Override // com.tencent.mm.plugin.recharge.ui.b.a
            public final void a(q qVar) {
                AppMethodBeat.i(67179);
                if (qVar == null) {
                    Log.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
                    AppMethodBeat.o(67179);
                    return;
                }
                if (!PhoneRechargeUI.a(PhoneRechargeUI.this, qVar.HEm, qVar.weappPath, qVar.name, qVar.desc)) {
                    if (!Util.isNullOrNil(qVar.url)) {
                        PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.b(PhoneRechargeUI.this, qVar.url), qVar.name, qVar.desc);
                        AppMethodBeat.o(67179);
                        return;
                    } else if (PhoneRechargeUI.a(PhoneRechargeUI.this, qVar)) {
                        PhoneRechargeUI.b(PhoneRechargeUI.this, qVar);
                    }
                }
                AppMethodBeat.o(67179);
            }
        };
        this.BEs = new b();
        this.BEs.BDW = new b.a() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass18 */

            @Override // com.tencent.mm.plugin.recharge.ui.b.a
            public final void a(q qVar) {
                AppMethodBeat.i(67180);
                if (!PhoneRechargeUI.a(PhoneRechargeUI.this, qVar.HEm, qVar.weappPath, qVar.name, qVar.desc)) {
                    if (!Util.isNullOrNil(qVar.url)) {
                        PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.b(PhoneRechargeUI.this, qVar.url), qVar.name, qVar.desc);
                        AppMethodBeat.o(67180);
                        return;
                    } else if (PhoneRechargeUI.a(PhoneRechargeUI.this, qVar)) {
                        PhoneRechargeUI.b(PhoneRechargeUI.this, qVar);
                        AppMethodBeat.o(67180);
                        return;
                    } else {
                        Log.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
                    }
                }
                AppMethodBeat.o(67180);
            }
        };
        this.BEj.setAdapter((ListAdapter) this.BEr);
        this.BEk.setAdapter((ListAdapter) this.BEs);
        this.BEe.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass19 */

            public final void onClick(View view) {
                AppMethodBeat.i(67181);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (PhoneRechargeUI.this.BEx != null) {
                    PhoneRechargeUI.g(PhoneRechargeUI.this);
                } else {
                    Log.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
                }
                PhoneRechargeUI.this.BEd.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67181);
            }
        });
        this.BEf.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(67182);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (PhoneRechargeUI.this.BEx != null) {
                    com.tencent.mm.protocal.g.gH(6, 1);
                    if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.BEx.HEm, PhoneRechargeUI.this.BEx.weappPath, PhoneRechargeUI.this.BEx.name, "") && !Util.isNullOrNil(PhoneRechargeUI.this.BEx.url)) {
                        try {
                            PhoneRechargeUI.a(PhoneRechargeUI.this, URLDecoder.decode(PhoneRechargeUI.this.BEx.url, ProtocolPackage.ServerEncoding), PhoneRechargeUI.this.BEx.name, "");
                        } catch (UnsupportedEncodingException e2) {
                            Log.printErrStackTrace("MicroMsg.PhoneRechargeUI", e2, "", new Object[0]);
                        }
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67182);
            }
        });
        this.BEg.eIh();
        int jn = (com.tencent.mm.cb.a.jn(this) / 4) - 20;
        Log.i("MicroMsg.PhoneRechargeUI", "max width: %s", Integer.valueOf(jn));
        this.BEl.setMaxWidth(jn);
        this.BEm.setMaxWidth(jn);
        this.BEn.setMaxWidth(jn);
        this.BEo.setMaxWidth(jn);
        this.wnT = getResources().getColor(R.color.a2x);
        if (this.BEw.BDH != null && !Util.isNullOrNil(this.BEw.BDH.name)) {
            this.desc = this.BEw.BDH.name;
        }
        this.BEg.getContentEditText().setHintTextColor(getResources().getColor(R.color.a52));
        if (Util.isNullOrNil(this.BEg.getText())) {
            c(new f(""), false);
            AppMethodBeat.o(67187);
            return;
        }
        c(new f(this.BEg.getText()), false);
        AppMethodBeat.o(67187);
    }

    private String aKS(String str) {
        String replace;
        String replace2;
        AppMethodBeat.i(67188);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(67188);
            return "";
        }
        String str2 = "";
        try {
            if (!(this.BEw == null || this.BEw.BDH == null || Util.isNullOrNil(this.BEw.BDH.name))) {
                str2 = this.BEw.BDH.name;
            }
            if (str2.equals(getString(R.string.iqd))) {
                str2 = "WeChatAccountBindNumber";
            }
            String text = this.BEg.getText();
            String encode = URLEncoder.encode(URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
                Log.i("MicroMsg.PhoneRechargeUI", "new url");
                if (str.indexOf("%7Bphone%7D") > 0) {
                    replace = str.replace("%7Bphone%7D", text);
                } else {
                    replace = str.replace("{phone}", text);
                }
                if (replace.indexOf("%7Bremark%7D") > 0) {
                    replace2 = replace.replace("%7Bremark%7D", encode);
                } else {
                    replace2 = replace.replace("{remark}", encode);
                }
                AppMethodBeat.o(67188);
                return replace2;
            }
            Log.i("MicroMsg.PhoneRechargeUI", "old url");
            String str3 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding) + String.format("?phone=%s&remark=%s", text, encode);
            AppMethodBeat.o(67188);
            return str3;
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.PhoneRechargeUI", e2, "", new Object[0]);
            AppMethodBeat.o(67188);
            return str;
        }
    }

    private boolean eHT() {
        AppMethodBeat.i(67189);
        if (this.BEx != null) {
            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, "");
            if (!Util.isNullOrNil(str)) {
                String[] split = str.split(";");
                if (split != null) {
                    for (String str2 : split) {
                        if (str2 != null && str2.equals(String.valueOf(this.BEx.id))) {
                            Log.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
                            AppMethodBeat.o(67189);
                            return true;
                        }
                    }
                }
                Log.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
                AppMethodBeat.o(67189);
                return false;
            }
            Log.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
            AppMethodBeat.o(67189);
            return false;
        }
        Log.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
        AppMethodBeat.o(67189);
        return true;
    }

    private void m(com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(67190);
        if (!(this.tipDialog == null || !this.tipDialog.isShowing() || qVar.getType() == 497)) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(67190);
    }

    private void c(final com.tencent.mm.ak.q qVar, boolean z) {
        AppMethodBeat.i(67191);
        if (this.tipDialog == null || (this.tipDialog != null && !this.tipDialog.isShowing())) {
            if (z) {
                this.tipDialog = h.a((Context) getContext(), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass2 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(67162);
                        g.azz().a(qVar);
                        AppMethodBeat.o(67162);
                    }
                });
            } else {
                this.tipDialog = h.c(getContext(), true, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(67163);
                        g.azz().a(qVar);
                        AppMethodBeat.o(67163);
                    }
                });
            }
        }
        g.azz().a(qVar, 0);
        AppMethodBeat.o(67191);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(67192);
        super.onResume();
        ad(false, true);
        AppMethodBeat.o(67192);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(67193);
        super.onDestroy();
        g.azz().b(1571, this);
        g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, this);
        EventCenter.instance.removeListener(this.BaR);
        AppMethodBeat.o(67193);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ad(boolean r6, boolean r7) {
        /*
        // Method dump skipped, instructions count: 437
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.ad(boolean, boolean):void");
    }

    private boolean eHU() {
        AppMethodBeat.i(67195);
        Iterator<q> it = this.BDs.iterator();
        while (it.hasNext()) {
            if (it.next().status != 0) {
                AppMethodBeat.o(67195);
                return false;
            }
        }
        AppMethodBeat.o(67195);
        return true;
    }

    private boolean eHV() {
        AppMethodBeat.i(67196);
        Iterator<q> it = this.BDr.iterator();
        while (it.hasNext()) {
            if (it.next().status != 0) {
                AppMethodBeat.o(67196);
                return false;
            }
        }
        AppMethodBeat.o(67196);
        return true;
    }

    private void h(MallFunction mallFunction) {
        AppMethodBeat.i(67197);
        if (com.tencent.mm.plugin.recharge.model.b.g(mallFunction)) {
            com.tencent.mm.plugin.recharge.model.b.eHO();
            if (this.BEt.Icf == null) {
                AppMethodBeat.o(67197);
                return;
            } else {
                Log.d("MicroMsg.PhoneRechargeUI", this.BEt.Icf.toString());
                aKT(this.BEt.Icf.Ict);
            }
        }
        AppMethodBeat.o(67197);
    }

    private void aKT(final String str) {
        AppMethodBeat.i(67198);
        com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.iqm), aa.jQ(this).inflate(R.layout.bli, (ViewGroup) null), getString(R.string.iqn), getString(R.string.iql), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(67169);
                String b2 = PhoneRechargeUI.b(PhoneRechargeUI.this, str);
                Log.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", b2);
                PhoneRechargeUI.a(PhoneRechargeUI.this, b2, PhoneRechargeUI.this.getString(R.string.iqm), "");
                AppMethodBeat.o(67169);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(67170);
                dialogInterface.dismiss();
                AppMethodBeat.o(67170);
            }
        });
        AppMethodBeat.o(67198);
    }

    private void eHW() {
        AppMethodBeat.i(67199);
        this.BDr = new ArrayList<>();
        q qVar = new q();
        qVar.name = getString(R.string.ipw);
        qVar.status = 0;
        q qVar2 = new q();
        qVar2.name = getString(R.string.ipx);
        qVar2.status = 0;
        q qVar3 = new q();
        qVar3.name = getString(R.string.ipy);
        qVar3.status = 0;
        q qVar4 = new q();
        qVar4.name = getString(R.string.ipz);
        qVar4.status = 0;
        q qVar5 = new q();
        qVar5.name = getString(R.string.iq0);
        qVar5.status = 0;
        q qVar6 = new q();
        qVar6.name = getString(R.string.iq1);
        qVar6.status = 0;
        this.BDr.add(qVar);
        this.BDr.add(qVar2);
        this.BDr.add(qVar3);
        this.BDr.add(qVar4);
        this.BDr.add(qVar5);
        this.BDr.add(qVar6);
        this.BDs = new ArrayList<>();
        q qVar7 = new q();
        qVar7.name = getString(R.string.iq2);
        qVar7.status = 0;
        q qVar8 = new q();
        qVar8.name = getString(R.string.iq3);
        qVar8.status = 0;
        q qVar9 = new q();
        qVar9.name = getString(R.string.iq4);
        qVar9.status = 0;
        this.BDs.add(qVar7);
        this.BDs.add(qVar8);
        this.BDs.add(qVar9);
        AppMethodBeat.o(67199);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bhv;
    }

    private void aKU(String str) {
        AppMethodBeat.i(67200);
        com.tencent.mm.ui.base.h.a((Context) this, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass11 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(67171);
                dialogInterface.dismiss();
                AppMethodBeat.o(67171);
            }
        });
        AppMethodBeat.o(67200);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(67201);
        if (qVar instanceof f) {
            f fVar = (f) qVar;
            m(qVar);
            if (fVar.cmdId != 0) {
                Log.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
                AppMethodBeat.o(67201);
            } else if (!Util.isNullOrNil(fVar.knP) && !fVar.knP.equals(this.BEg.getText())) {
                Log.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", fVar.knP, this.BEg.getText());
                AppMethodBeat.o(67201);
            } else if (fVar.BDp) {
                Log.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
                aKU(fVar.errMsg);
                eHS();
                AppMethodBeat.o(67201);
            } else {
                this.mAppId = fVar.appId;
                this.BDq = fVar.BDq;
                this.BDr = fVar.BDr;
                this.BDt = fVar.BDt;
                this.BDu = fVar.BDu;
                this.BDv = fVar.BDv;
                this.BDw = fVar.BDw;
                this.errCode = fVar.errCode;
                this.errMsg = fVar.errMsg;
                this.BEu = fVar.desc;
                Log.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", this.BEu, this.BEg.getText());
                if (Util.isNullOrNil(this.BEu)) {
                    this.desc = "";
                    this.wnT = getResources().getColor(R.color.a2x);
                } else if (this.BEw.BDH != null && this.BEw.BDH.BCX.trim().equals(this.BEg.getText())) {
                    this.BEw.BDH.ljO = this.BEu;
                    this.BEw.setInput(this.BEw.BDH);
                }
                this.BEx = fVar.BDy;
                this.BDs = fVar.BDs;
                if (this.BDs != null) {
                    for (int size = this.BDs.size() - 1; size >= 0; size--) {
                        q qVar2 = this.BDs.get(size);
                        if (qVar2.name.isEmpty()) {
                            this.BDs.remove(qVar2);
                        }
                    }
                }
                if (fVar.BDx == null || (fVar.BDx.name.equals(this.BDx.name) && fVar.BDx.url.equals(this.BDx.url) && fVar.BDx.HEm.equals(this.BDx.HEm) && fVar.BDx.weappPath.equals(this.BDx.weappPath))) {
                    z = false;
                } else {
                    Log.i("MicroMsg.PhoneRechargeUI", "need to update head");
                    this.BDx = fVar.BDx;
                    z = true;
                }
                ad(!this.BEu.equals(""), z);
                List<com.tencent.mm.plugin.recharge.model.a> list = fVar.BDz;
                Log.d("MicroMsg.PhoneRechargeUI", "update record history");
                a.eHL().ga(list);
                if (this.BEw != null) {
                    if (Util.isNullOrNil(this.BEg.getText())) {
                        this.BEw.sY(true);
                    } else {
                        this.BEw.sY(false);
                    }
                }
                this.BEg.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(67175);
                        PhoneRechargeUI.this.BEg.eIi();
                        AppMethodBeat.o(67175);
                    }
                }, 300);
                AppMethodBeat.o(67201);
            }
        } else {
            if (qVar instanceof com.tencent.mm.plugin.recharge.model.g) {
                m(qVar);
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.wallet_core.b.hgC();
                    com.tencent.mm.plugin.recharge.model.g gVar = (com.tencent.mm.plugin.recharge.model.g) qVar;
                    if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true)) {
                        ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(gVar.BDB.dDL, 6);
                    } else {
                        PayInfo payInfo = gVar.BDB;
                        payInfo.dVv = 6;
                        payInfo.Kxr = 100;
                        payInfo.pSm = this.BEg.getText();
                        payInfo.remark = this.BEw.BDH != null ? this.BEw.BDH.name : "";
                        com.tencent.mm.pluginsdk.wallet.f.a(this, payInfo, 2);
                    }
                    EventCenter.instance.addListener(this.BaR);
                    AppMethodBeat.o(67201);
                    return;
                }
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.itf);
                }
                aKU(str);
            }
            AppMethodBeat.o(67201);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(67202);
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    this.BEy = true;
                    final String str = null;
                    final ArrayList arrayList = new ArrayList();
                    Uri data = intent.getData();
                    if (data != null) {
                        try {
                            Cursor query = getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    Cursor query2 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ".concat(String.valueOf(query.getString(query.getColumnIndex("_id")))), null, null);
                                    if (query2 != null && query2.moveToFirst()) {
                                        String str2 = null;
                                        while (!query2.isAfterLast()) {
                                            int columnIndex2 = query2.getColumnIndex("data1");
                                            int columnIndex3 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                            String string = query2.getString(columnIndex2);
                                            str2 = query2.getString(columnIndex3);
                                            Log.d("MicroMsg.PhoneRechargeUI", "hy: username : ".concat(String.valueOf(str2)));
                                            if (string != null) {
                                                Log.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(string)));
                                                String Ts = com.tencent.mm.plugin.recharge.model.b.Ts(string);
                                                Log.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(Ts)));
                                                if (PhoneNumberUtils.isGlobalPhoneNumber(Ts) && Ts.length() == 11) {
                                                    arrayList.add(Ts);
                                                }
                                                Log.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : ".concat(String.valueOf(Ts)));
                                            }
                                            query2.moveToNext();
                                        }
                                        str = str2;
                                    }
                                    if (query2 != null) {
                                        query2.close();
                                    }
                                }
                            }
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            if (arrayList.size() <= 1) {
                                if (arrayList.size() != 1) {
                                    com.tencent.mm.ui.base.h.c(this, getString(R.string.exu), "", true);
                                    break;
                                } else {
                                    this.BEw.setInput(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(0), str, 1));
                                    eHX();
                                    break;
                                }
                            } else {
                                com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.ui.base.h.a(this, getString(R.string.iqg), arrayList, -1, new h.a() {
                                    /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass14 */

                                    @Override // com.tencent.mm.ui.base.h.a
                                    public final void Vq(int i2) {
                                        AppMethodBeat.i(67176);
                                        Log.d("MicroMsg.PhoneRechargeUI", "choose: %d", Integer.valueOf(i2));
                                        PhoneRechargeUI.this.BEw.setInput(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(i2), str, 1));
                                        PhoneRechargeUI.n(PhoneRechargeUI.this);
                                        AppMethodBeat.o(67176);
                                    }
                                });
                                if (a2 != null) {
                                    a2.setCanceledOnTouchOutside(true);
                                    break;
                                }
                            }
                        } catch (SecurityException e2) {
                            Log.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", e2.toString());
                            com.tencent.mm.ui.base.h.c(this, getString(R.string.exw), "", true);
                            break;
                        }
                    } else {
                        Log.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
                        AppMethodBeat.o(67202);
                        return;
                    }
                }
                break;
            case 2:
                if (i3 == -1) {
                    if (!this.BaO) {
                        Log.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                        a.eHL().a(new com.tencent.mm.plugin.recharge.model.a(this.BEg.getText(), this.BEg.getTipsTv().getText().toString(), 0));
                        finish();
                        this.BaO = true;
                        break;
                    }
                } else {
                    Log.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                    break;
                }
                break;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(67202);
    }

    private void eHX() {
        AppMethodBeat.i(67203);
        g.azz().a(new f(this.BEg.getText()), 0);
        AppMethodBeat.o(67203);
    }

    @Override // com.tencent.mm.plugin.recharge.ui.form.d.a
    public final void eHY() {
        AppMethodBeat.i(67204);
        g.azz().a(new f("", 1), 0);
        AppMethodBeat.o(67204);
    }

    static /* synthetic */ com.tencent.mm.plugin.recharge.model.a a(PhoneRechargeUI phoneRechargeUI, String str) {
        AppMethodBeat.i(67205);
        Log.i("MicroMsg.PhoneRechargeUI", "handle phone number: %s", str);
        com.tencent.mm.plugin.recharge.model.a eHN = a.eHN();
        if (eHN == null || !str.equals(eHN.BCX)) {
            if (phoneRechargeUI.BEz == null || phoneRechargeUI.BEz.isEmpty()) {
                phoneRechargeUI.BEz = com.tencent.mm.pluginsdk.b.dO(phoneRechargeUI.getContext());
            }
            if (phoneRechargeUI.BEz == null || phoneRechargeUI.BEz.isEmpty()) {
                List<com.tencent.mm.plugin.recharge.model.a> eHM = a.eHL().eHM();
                if (eHM.isEmpty()) {
                    com.tencent.mm.plugin.recharge.model.a aVar = new com.tencent.mm.plugin.recharge.model.a(str, "", 0);
                    aVar.BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
                    Log.i("MicroMsg.PhoneRechargeUI", "empty history");
                    AppMethodBeat.o(67205);
                    return aVar;
                }
                for (com.tencent.mm.plugin.recharge.model.a aVar2 : eHM) {
                    if (aVar2.BCX.equals(str)) {
                        com.tencent.mm.plugin.recharge.model.a aVar3 = new com.tencent.mm.plugin.recharge.model.a(str, aVar2.name, aVar2.ljO, 2);
                        aVar3.BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
                        Log.i("MicroMsg.PhoneRechargeUI", "find in history");
                        AppMethodBeat.o(67205);
                        return aVar3;
                    }
                }
                com.tencent.mm.plugin.recharge.model.a aVar4 = new com.tencent.mm.plugin.recharge.model.a(str, phoneRechargeUI.getString(R.string.iqc), 0);
                aVar4.BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
                Log.i("MicroMsg.PhoneRechargeUI", "not find in history");
                AppMethodBeat.o(67205);
                return aVar4;
            }
            for (String[] strArr : phoneRechargeUI.BEz) {
                String Ts = com.tencent.mm.plugin.recharge.model.b.Ts(strArr[2]);
                if (str.equals(Ts)) {
                    com.tencent.mm.plugin.recharge.model.a aVar5 = new com.tencent.mm.plugin.recharge.model.a(Ts, strArr[1], 1);
                    aVar5.BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
                    Log.i("MicroMsg.PhoneRechargeUI", "find in address number");
                    AppMethodBeat.o(67205);
                    return aVar5;
                }
            }
            com.tencent.mm.plugin.recharge.model.a aVar6 = new com.tencent.mm.plugin.recharge.model.a(str, "", 1);
            aVar6.BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
            Log.i("MicroMsg.PhoneRechargeUI", "not in address");
            AppMethodBeat.o(67205);
            return aVar6;
        }
        Log.i("MicroMsg.PhoneRechargeUI", "find bind mobile");
        AppMethodBeat.o(67205);
        return eHN;
    }

    static /* synthetic */ void aKV(String str) {
        AppMethodBeat.i(67206);
        Log.i("MicroMsg.PhoneRechargeUI", "do scene: %s", str);
        g.azz().a(new f(str), 0);
        AppMethodBeat.o(67206);
    }

    static /* synthetic */ boolean a(PhoneRechargeUI phoneRechargeUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(67209);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(67209);
            return false;
        }
        String str5 = "";
        String str6 = "";
        String str7 = "";
        if (!(phoneRechargeUI.BEw == null || phoneRechargeUI.BEw.BDH == null)) {
            com.tencent.mm.plugin.recharge.model.a aVar = phoneRechargeUI.BEw.BDH;
            str5 = aVar.BCX;
            str6 = aVar.name;
            str7 = aVar.sourceType == 3 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        String replace = str2.replace("{phone}", str5).replace("{remark}", str6).replace("{isbind}", str7);
        Log.i("MicroMsg.PhoneRechargeUI", "weappID: %s, weappPath: %s", str, replace);
        wq wqVar = new wq();
        wqVar.ecI.userName = str;
        wqVar.ecI.ecK = Util.nullAs(replace, "");
        wqVar.ecI.scene = 1098;
        wqVar.ecI.ecL = 0;
        EventCenter.instance.publish(wqVar);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17620, str3, str4, 2, str);
        AppMethodBeat.o(67209);
        return true;
    }

    static /* synthetic */ void a(PhoneRechargeUI phoneRechargeUI, String str, String str2, String str3) {
        AppMethodBeat.i(67211);
        try {
            Log.d("MicroMsg.PhoneRechargeUI", "url: %s", str);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            com.tencent.mm.wallet_core.ui.f.aA(phoneRechargeUI.getContext(), intent);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(17620, str2, str3, 1, str);
            AppMethodBeat.o(67211);
        } catch (Exception e2) {
            Log.e("MicroMsg.PhoneRechargeUI", "hy: url decode failed: raw url: %s", str);
            AppMethodBeat.o(67211);
        }
    }

    static /* synthetic */ boolean a(PhoneRechargeUI phoneRechargeUI, final q qVar) {
        final int i2;
        String str;
        String string;
        AppMethodBeat.i(67212);
        if (phoneRechargeUI.BEw.BDH != null) {
            com.tencent.mm.plugin.recharge.model.a aVar = phoneRechargeUI.BEw.BDH;
            Object text = phoneRechargeUI.BEg.getText();
            String str2 = null;
            if (phoneRechargeUI.BDq == 1) {
                str2 = phoneRechargeUI.getString(R.string.iq5);
                i2 = 3;
            } else if (phoneRechargeUI.BDq == 2 && aVar.sourceType != 3) {
                str2 = phoneRechargeUI.getString(R.string.exo, new Object[]{text, phoneRechargeUI.getString(R.string.iqf), qVar.name});
                i2 = 2;
            } else if (aVar.sourceType == 1 && Util.isNullOrNil(aVar.name)) {
                str2 = phoneRechargeUI.getString(R.string.exn, new Object[]{phoneRechargeUI.BEg.getText(), phoneRechargeUI.getString(R.string.iqf)});
                i2 = 4;
            } else if (aVar.sourceType == 0) {
                if (!Util.isNullOrNil(aVar.ljO)) {
                    string = phoneRechargeUI.getString(R.string.exp, new Object[]{text});
                } else {
                    string = phoneRechargeUI.getString(R.string.exn, new Object[]{text, phoneRechargeUI.getString(R.string.iqc)});
                }
                i2 = 5;
                str2 = string;
            } else if (aVar.sourceType == 3 || qVar.HEV != 1) {
                i2 = 0;
            } else {
                String str3 = "";
                if (!Util.isNullOrNil(aVar.name)) {
                    str3 = aVar.name;
                } else if (!Util.isNullOrNil(aVar.ljO)) {
                    str3 = aVar.ljO;
                }
                if (!Util.isNullOrNil(str3)) {
                    str = phoneRechargeUI.getString(R.string.exo, new Object[]{text, str3, qVar.name});
                } else {
                    str = null;
                }
                i2 = 1;
                str2 = str;
            }
            if (!Util.isNullOrNil(str2)) {
                com.tencent.mm.ui.widget.a.d c2 = com.tencent.mm.ui.base.h.c(phoneRechargeUI, str2, "", phoneRechargeUI.getString(R.string.exq), phoneRechargeUI.getString(R.string.b96), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass21 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(67183);
                        PhoneRechargeUI.b(PhoneRechargeUI.this, qVar);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17623, Integer.valueOf(i2), 1);
                        AppMethodBeat.o(67183);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.AnonymousClass22 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(67184);
                        if (i2 == -2) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(17623, Integer.valueOf(i2), 2);
                        }
                        AppMethodBeat.o(67184);
                    }
                });
                if (c2 != null) {
                    c2.setCanceledOnTouchOutside(false);
                }
                AppMethodBeat.o(67212);
                return false;
            }
        }
        AppMethodBeat.o(67212);
        return true;
    }

    static /* synthetic */ void b(PhoneRechargeUI phoneRechargeUI, q qVar) {
        AppMethodBeat.i(67213);
        phoneRechargeUI.c(new com.tencent.mm.plugin.recharge.model.g(phoneRechargeUI.mAppId, phoneRechargeUI.BEt.kHR, qVar.id, "mobile=" + com.tencent.mm.plugin.recharge.model.b.Ts(phoneRechargeUI.BEg.getText()) + "&markup=" + (phoneRechargeUI.BEw.BDH != null ? phoneRechargeUI.BEw.BDH.name : "")), true);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17620, qVar.name, qVar.desc, 3);
        AppMethodBeat.o(67213);
    }

    static /* synthetic */ void g(PhoneRechargeUI phoneRechargeUI) {
        String str;
        AppMethodBeat.i(67214);
        if (phoneRechargeUI.BEx != null) {
            String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, "");
            if (Util.isNullOrNil(str2)) {
                str = String.valueOf(phoneRechargeUI.BEx.id);
            } else {
                str = str2 + ";" + phoneRechargeUI.BEx.id;
            }
            g.aAh().azQ().set(ar.a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, str);
            g.aAh().azQ().gBI();
        }
        AppMethodBeat.o(67214);
    }
}
