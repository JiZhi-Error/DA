package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

public class NearLifeCreatePoiUI extends MMActivity implements i {
    private chk ACd;
    private String ACe;
    private String ACf;
    private Addr ACg;
    private String ACh;
    private EditText ACi;
    private EditText ACj;
    private TextView ACk;
    private TextView ACl;
    private c ACm;
    private com.tencent.mm.plugin.nearlife.b.c ACn;
    private View.OnClickListener ACo = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(26597);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("ui_title", R.string.fdl);
            if (NearLifeCreatePoiUI.this.ACg != null) {
                intent.putExtra("extra_province", NearLifeCreatePoiUI.this.ACg.iUP);
                intent.putExtra("extra_city", NearLifeCreatePoiUI.this.ACg.iUQ);
            }
            com.tencent.mm.br.c.b(NearLifeCreatePoiUI.this.getContext(), "address", ".ui.WalletMultiRcptSelectUI", intent, 1);
            a.a(this, "com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26597);
        }
    };
    private View.OnClickListener ACp = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(26598);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.setClass(NearLifeCreatePoiUI.this.getContext(), SelectPoiCategoryUI.class);
            NearLifeCreatePoiUI.this.startActivityForResult(intent, 2);
            a.a(this, "com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26598);
        }
    };
    private View.OnClickListener ACq = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(26599);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            NearLifeCreatePoiUI.this.findViewById(R.id.iy0).setVisibility(8);
            NearLifeCreatePoiUI.this.findViewById(R.id.eo0).setVisibility(0);
            NearLifeCreatePoiUI.this.findViewById(R.id.eo2).setVisibility(0);
            a.a(this, "com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26599);
        }
    };
    private MenuItem.OnMenuItemClickListener ACr = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.AnonymousClass4 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(26601);
            h.INSTANCE.a(11138, "2", AppEventsConstants.EVENT_PARAM_VALUE_NO, NearLifeCreatePoiUI.this.hes);
            NearLifeCreatePoiUI nearLifeCreatePoiUI = NearLifeCreatePoiUI.this;
            AppCompatActivity context = NearLifeCreatePoiUI.this.getContext();
            NearLifeCreatePoiUI.this.getString(R.string.fdb);
            nearLifeCreatePoiUI.gxX = com.tencent.mm.ui.base.h.a((Context) context, NearLifeCreatePoiUI.this.getString(R.string.fdc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.AnonymousClass4.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(26600);
                    bg.azz().a(NearLifeCreatePoiUI.this.ACn);
                    AppMethodBeat.o(26600);
                }
            });
            NearLifeCreatePoiUI.this.ACe = NearLifeCreatePoiUI.this.ACi.getText().toString();
            NearLifeCreatePoiUI.this.ACf = NearLifeCreatePoiUI.this.ACk.getText().toString();
            NearLifeCreatePoiUI.this.ACh = NearLifeCreatePoiUI.this.ACj.getText().toString();
            String obj = ((EditText) NearLifeCreatePoiUI.this.findViewById(R.id.c50)).getText().toString();
            LinkedList g2 = NearLifeCreatePoiUI.g(NearLifeCreatePoiUI.this);
            NearLifeCreatePoiUI.this.ACn = new com.tencent.mm.plugin.nearlife.b.c(NearLifeCreatePoiUI.this.ACe, NearLifeCreatePoiUI.this.ACf, NearLifeCreatePoiUI.this.ACh, NearLifeCreatePoiUI.this.ACd, g2.size(), g2, obj);
            bg.azz().a(NearLifeCreatePoiUI.this.ACn, 0);
            Log.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
            AppMethodBeat.o(26601);
            return true;
        }
    };
    private c.a ACs = new c.a() {
        /* class com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.AnonymousClass5 */

        @Override // com.tencent.mm.modelgeo.c.a
        public final void b(Addr addr) {
            AppMethodBeat.i(26602);
            String str = Util.nullAsNil(addr.iUQ) + Util.nullAsNil(addr.iUS);
            String str2 = Util.nullAsNil(addr.iUT) + Util.nullAsNil(addr.iUU);
            Log.d("MicroMsg.NearLifeCreatePoiUI", "get address:".concat(String.valueOf(str)));
            if (Util.isNullOrNil(NearLifeCreatePoiUI.this.ACk.getText().toString())) {
                NearLifeCreatePoiUI.this.ACk.setText(str);
            }
            if (Util.isNullOrNil(NearLifeCreatePoiUI.this.ACj.getText().toString()) && !Util.isNullOrNil(str2)) {
                NearLifeCreatePoiUI.this.ACj.setText(str2);
            }
            NearLifeCreatePoiUI.this.ACg = addr;
            AppMethodBeat.o(26602);
        }
    };
    private MenuItem.OnMenuItemClickListener ACt = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.AnonymousClass6 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(26603);
            NearLifeCreatePoiUI.l(NearLifeCreatePoiUI.this);
            AppMethodBeat.o(26603);
            return true;
        }
    };
    private TextWatcher aws = new TextWatcher() {
        /* class com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.AnonymousClass7 */

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(26604);
            if (NearLifeCreatePoiUI.this.ACi.getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.this.ACj.getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.this.ACk.getText().toString().trim().length() == 0) {
                NearLifeCreatePoiUI.this.enableOptionMenu(0, false);
                AppMethodBeat.o(26604);
                return;
            }
            NearLifeCreatePoiUI.this.enableOptionMenu(0, true);
            AppMethodBeat.o(26604);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private q gxX;
    private String hes;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NearLifeCreatePoiUI() {
        AppMethodBeat.i(26606);
        AppMethodBeat.o(26606);
    }

    static /* synthetic */ void l(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        AppMethodBeat.i(26615);
        nearLifeCreatePoiUI.exg();
        AppMethodBeat.o(26615);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26607);
        super.onCreate(bundle);
        bg.azz().a(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.b.CTRL_INDEX, this);
        this.ACd = new chk();
        this.ACd.LbD = getIntent().getFloatExtra("get_lat", -85.0f);
        this.ACd.LbC = getIntent().getFloatExtra("get_lng", -1000.0f);
        this.ACd.LuT = getIntent().getIntExtra("get_preci", 0);
        this.ACd.LuV = "";
        this.ACd.LuW = 0;
        this.ACd.LuU = "";
        this.ACm = c.bbX();
        if (this.ACm != null) {
            this.ACm.a((double) this.ACd.LbD, (double) this.ACd.LbC, this.ACs);
        }
        this.hes = getIntent().getStringExtra("search_id");
        Log.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", this.hes);
        initView();
        AppMethodBeat.o(26607);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.beu;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(26608);
        setMMTitle(R.string.fdb);
        ((ViewGroup) findViewById(R.id.eo1)).setOnClickListener(this.ACo);
        ((ViewGroup) findViewById(R.id.eo0)).setOnClickListener(this.ACp);
        ((TextView) findViewById(R.id.iy0)).setOnClickListener(this.ACq);
        findViewById(R.id.iy0).setVisibility(8);
        findViewById(R.id.eo0).setVisibility(0);
        findViewById(R.id.eo2).setVisibility(0);
        this.ACi = (EditText) findViewById(R.id.c4z);
        this.ACj = (EditText) findViewById(R.id.c4y);
        this.ACk = (TextView) findViewById(R.id.iy9);
        this.ACl = (TextView) findViewById(R.id.iy8);
        this.ACi.addTextChangedListener(this.aws);
        this.ACj.addTextChangedListener(this.aws);
        this.ACk.addTextChangedListener(this.aws);
        String nullAs = Util.nullAs(getIntent().getStringExtra("get_poi_name"), "");
        if (nullAs.length() != 0) {
            this.ACi.setText(nullAs);
            this.ACi.setSelection(nullAs.length());
        }
        com.tencent.mm.ui.tools.b.c.f(this.ACi).aoq(100).a((c.a) null);
        com.tencent.mm.ui.tools.b.c.f(this.ACj).aoq(400).a((c.a) null);
        com.tencent.mm.ui.tools.b.c.f((EditText) findViewById(R.id.c50)).aoq(100).a((c.a) null);
        addTextOptionMenu(0, getString(R.string.vl), this.ACr, null, t.b.GREEN);
        enableOptionMenu(0, false);
        setBackBtn(this.ACt);
        AppMethodBeat.o(26608);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(26609);
        switch (i2) {
            case 1:
                String stringExtra = intent.getStringExtra("karea_result");
                if (!Util.isNullOrNil(stringExtra)) {
                    ((TextView) findViewById(R.id.iy9)).setText(stringExtra.replace(" ", ""));
                    AppMethodBeat.o(26609);
                    return;
                }
                break;
            case 2:
                if (-1 == i3 && intent != null) {
                    this.ACl.setText(Util.nullAsNil(intent.getStringExtra("poi_category")));
                    break;
                }
        }
        AppMethodBeat.o(26609);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26610);
        super.onDestroy();
        bg.azz().b(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.b.CTRL_INDEX, this);
        AppMethodBeat.o(26610);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(26611);
        if (4 == keyEvent.getKeyCode()) {
            exg();
            AppMethodBeat.o(26611);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(26611);
        return onKeyDown;
    }

    private void exg() {
        AppMethodBeat.i(26612);
        com.tencent.mm.ui.base.h.a(this, (int) R.string.fd6, (int) R.string.fdb, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(26605);
                h.INSTANCE.a(11138, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, AppEventsConstants.EVENT_PARAM_VALUE_NO, NearLifeCreatePoiUI.this.hes);
                NearLifeCreatePoiUI.this.setResult(0, new Intent());
                NearLifeCreatePoiUI.this.finish();
                AppMethodBeat.o(26605);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(26612);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(26613);
        Log.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.gxX.dismiss();
            com.tencent.mm.plugin.nearlife.b.c cVar = (com.tencent.mm.plugin.nearlife.b.c) qVar;
            Intent intent = new Intent();
            if (this.ACd != null) {
                intent.putExtra("get_lat", this.ACd.LbD);
                intent.putExtra("get_lng", this.ACd.LbC);
            }
            if (this.ACg != null) {
                intent.putExtra("get_city", this.ACg.iUQ);
            }
            intent.putExtra("get_poi_address", this.ACf);
            intent.putExtra("get_poi_classify_id", cVar.AAR);
            intent.putExtra("get_poi_name", this.ACe);
            intent.putExtra("get_poi_classify_type", 1);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(26613);
            return;
        }
        this.gxX.dismiss();
        Toast.makeText(getContext(), getString(R.string.fd_), 1).show();
        this.ACn = null;
        AppMethodBeat.o(26613);
    }

    static /* synthetic */ LinkedList g(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        AppMethodBeat.i(26614);
        String charSequence = ((TextView) nearLifeCreatePoiUI.findViewById(R.id.iy8)).getText().toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new dqi().bhy(charSequence));
        AppMethodBeat.o(26614);
        return linkedList;
    }
}
