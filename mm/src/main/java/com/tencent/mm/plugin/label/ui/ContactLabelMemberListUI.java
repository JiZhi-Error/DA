package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI extends MMActivity {
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(26261);
            int i2 = message.what;
            Log.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", Integer.valueOf(i2));
            switch (i2) {
                case 5001:
                    ContactLabelMemberListUI.a(ContactLabelMemberListUI.this);
                    AppMethodBeat.o(26261);
                    return;
                default:
                    Log.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
                    AppMethodBeat.o(26261);
                    return;
            }
        }
    };
    private TextView oMM;
    private MStorageEx.IOnStorageChange yCE = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(26262);
            Log.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", Integer.valueOf(i2), obj);
            if (ContactLabelMemberListUI.this.mHandler != null) {
                ContactLabelMemberListUI.this.mHandler.removeMessages(5001);
                ContactLabelMemberListUI.this.mHandler.sendEmptyMessageDelayed(5001, 300);
            }
            AppMethodBeat.o(26262);
        }
    };
    private ListView yCT;
    private a yCU;
    private String yCV;
    private String yCW;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactLabelMemberListUI() {
        AppMethodBeat.i(26266);
        AppMethodBeat.o(26266);
    }

    static /* synthetic */ void a(ContactLabelMemberListUI contactLabelMemberListUI) {
        AppMethodBeat.i(26273);
        contactLabelMemberListUI.eco();
        AppMethodBeat.o(26273);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.y2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26267);
        super.onCreate(bundle);
        this.yCV = getIntent().getStringExtra("label_id");
        this.yCW = getIntent().getStringExtra("label_name");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26263);
                ContactLabelMemberListUI.this.finish();
                AppMethodBeat.o(26263);
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.string.ebl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26264);
                Intent intent = new Intent();
                intent.setClass(ContactLabelMemberListUI.this, ContactLabelEditUI.class);
                intent.putExtra("label_id", ContactLabelMemberListUI.this.yCV);
                intent.putExtra("label_name", ContactLabelMemberListUI.this.yCW);
                ContactLabelMemberListUI.this.startActivityForResult(intent, 10001);
                AppMethodBeat.o(26264);
                return false;
            }
        });
        setMMTitle(this.yCW);
        this.yCT = (ListView) findViewById(R.id.bca);
        this.oMM = (TextView) findViewById(R.id.c2g);
        if (Util.isNullOrNil(this.yCV)) {
            Log.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
            finish();
        }
        this.yCU = new a(getContext());
        this.yCT.setAdapter((ListAdapter) this.yCU);
        this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(26265);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/label/ui/ContactLabelMemberListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                ContactLabelMemberListUI.a(ContactLabelMemberListUI.this, i2);
                a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelMemberListUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(26265);
            }
        });
        this.yCT.setEmptyView(this.oMM);
        AppMethodBeat.o(26267);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(26268);
        bg.aVF();
        c.aSN().add(this.yCE);
        super.onResume();
        eco();
        AppMethodBeat.o(26268);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(26269);
        bg.aVF();
        c.aSN().remove(this.yCE);
        super.onPause();
        AppMethodBeat.o(26269);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26270);
        if (this.yCU != null) {
            this.yCU.ebf();
            this.yCU.gGV();
        }
        super.onDestroy();
        AppMethodBeat.o(26270);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(26271);
        Log.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case 10001:
                if (i3 == -1) {
                    finish();
                    AppMethodBeat.o(26271);
                    return;
                }
                eco();
                AppMethodBeat.o(26271);
                return;
            default:
                Log.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", Integer.valueOf(i2));
                AppMethodBeat.o(26271);
                return;
        }
    }

    private void eco() {
        AppMethodBeat.i(26272);
        if (this.yCU != null) {
            this.yCU.yCP = com.tencent.mm.plugin.label.a.a.ecg().aCK(this.yCV);
            this.yCU.onNotifyChange(null, null);
        }
        this.yCW = com.tencent.mm.plugin.label.a.a.ecg().aCG(this.yCV);
        if (!Util.isNullOrNil(this.yCW)) {
            setMMTitle(this.yCW);
        }
        AppMethodBeat.o(26272);
    }

    static /* synthetic */ void a(ContactLabelMemberListUI contactLabelMemberListUI, int i2) {
        AppMethodBeat.i(26274);
        if (contactLabelMemberListUI.yCU != null && i2 <= contactLabelMemberListUI.yCU.getCount()) {
            as asVar = contactLabelMemberListUI.yCU.Pu(i2).contact;
            if (asVar == null || Util.isNullOrNil(asVar.field_username) || asVar.field_deleteFlag == 1) {
                AppMethodBeat.o(26274);
                return;
            } else if (ab.Js(asVar.field_username)) {
                Log.e("MicroMsg.Label.ContactLabelMemberListUI", "error, 4.5 do not contain this contact %s", asVar.field_username);
                AppMethodBeat.o(26274);
                return;
            } else {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", asVar.field_username);
                intent.putExtra("Contact_Alias", asVar.ajx());
                intent.putExtra("Contact_Nick", asVar.arI());
                intent.putExtra("Contact_QuanPin", asVar.ajA());
                intent.putExtra("Contact_PyInitial", asVar.ajz());
                intent.putExtra("Contact_Sex", asVar.fuA);
                intent.putExtra("Contact_Province", asVar.getProvince());
                intent.putExtra("Contact_City", asVar.getCity());
                intent.putExtra("Contact_Signature", asVar.signature);
                com.tencent.mm.plugin.label.a.jRt.c(intent, contactLabelMemberListUI);
            }
        }
        AppMethodBeat.o(26274);
    }
}
