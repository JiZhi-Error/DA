package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.model.h.c;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class IPCallAllRecordUI extends MMActivity {
    private String ebd;
    private String edf;
    private ListView yuv;
    private boolean yuw = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25686);
        super.onCreate(bundle);
        this.ebd = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
        this.edf = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
        this.yuw = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
        setMMTitle(R.string.e7g);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25680);
                IPCallAllRecordUI.this.finish();
                AppMethodBeat.o(25680);
                return true;
            }
        });
        this.yuv = (ListView) findViewById(R.id.lw);
        this.yuv.setAdapter((ListAdapter) new a(this));
        AppMethodBeat.o(25686);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awh;
    }

    class a extends s<k> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ k a(k kVar, Cursor cursor) {
            AppMethodBeat.i(25685);
            k kVar2 = kVar;
            if (kVar2 == null) {
                kVar2 = new k();
            }
            kVar2.convertFrom(cursor);
            AppMethodBeat.o(25685);
            return kVar2;
        }

        public a(Context context) {
            super(context, null);
            AppMethodBeat.i(25681);
            Bh(true);
            AppMethodBeat.o(25681);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            c aBV;
            Cursor cursor = null;
            AppMethodBeat.i(25682);
            if (!Util.isNullOrNil(IPCallAllRecordUI.this.edf)) {
                String str = IPCallAllRecordUI.this.edf;
                if (!(Util.isNullOrNil(str) || (aBV = i.eay().aBV(str)) == null || aBV.systemRowid == -1)) {
                    cursor = i.eaz().GT(aBV.systemRowid);
                }
            } else if (!Util.isNullOrNil(IPCallAllRecordUI.this.ebd)) {
                cursor = i.eaz().aCa(IPCallAllRecordUI.this.ebd);
            }
            setCursor(cursor);
            AppMethodBeat.o(25682);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(25683);
            ebf();
            anp();
            AppMethodBeat.o(25683);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(25684);
            if (view == null) {
                view = IPCallAllRecordUI.this.getLayoutInflater().inflate(R.layout.awu, viewGroup, false);
                C1444a aVar = new C1444a();
                aVar.yuy = (TextView) view.findViewById(R.id.gk7);
                aVar.yuz = (TextView) view.findViewById(R.id.gk9);
                aVar.gCd = (TextView) view.findViewById(R.id.gk_);
                view.setTag(aVar);
            }
            k kVar = (k) getItem(i2);
            C1444a aVar2 = (C1444a) view.getTag();
            aVar2.yuz.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(kVar.field_phonenumber));
            if (kVar.field_duration > 0) {
                aVar2.gCd.setText(com.tencent.mm.plugin.ipcall.a.c.GY(kVar.field_duration));
            } else {
                aVar2.gCd.setText(com.tencent.mm.plugin.ipcall.a.c.Pr(kVar.field_status));
            }
            aVar2.yuy.setText(com.tencent.mm.plugin.ipcall.a.c.GU(kVar.field_calltime));
            AppMethodBeat.o(25684);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI$a$a  reason: collision with other inner class name */
        class C1444a {
            TextView gCd;
            TextView yuy;
            TextView yuz;

            C1444a() {
            }
        }
    }
}
