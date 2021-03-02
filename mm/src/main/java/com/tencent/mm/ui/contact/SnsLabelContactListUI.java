package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.su;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SnsLabelContactListUI extends MMActivity {
    private SnsObject DqN;
    private String Fxk;
    private a PZL;
    private ArrayList<String> PZM = new ArrayList<>();
    private int PZN;
    private b PZO;
    private ListView yCT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsLabelContactListUI() {
        AppMethodBeat.i(38070);
        AppMethodBeat.o(38070);
    }

    static /* synthetic */ void c(SnsLabelContactListUI snsLabelContactListUI) {
        AppMethodBeat.i(38076);
        snsLabelContactListUI.gVl();
        AppMethodBeat.o(38076);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38071);
        super.onCreate(bundle);
        this.PZO = new b(this, (byte) 0);
        EventCenter.instance.addListener(this.PZO);
        this.PZN = getIntent().getIntExtra("sns_label_sns_info", -1);
        if (this.PZN == -1) {
            finish();
            AppMethodBeat.o(38071);
            return;
        }
        kc kcVar = new kc();
        kcVar.dPa.dJi = this.PZN;
        EventCenter.instance.publish(kcVar);
        this.DqN = kcVar.dPb.dPc;
        if (this.DqN != null && ((this.DqN.ExtFlag == 3 && this.DqN.BlackList != null && this.DqN.BlackList.size() > 0) || (this.DqN.ExtFlag == 5 && this.DqN.GroupUser != null && this.DqN.GroupUser.size() > 0))) {
            gVl();
            initView();
        }
        AppMethodBeat.o(38071);
    }

    private void gVl() {
        AppMethodBeat.i(38072);
        if (this.DqN.ExtFlag == 3) {
            this.Fxk = getString(R.string.h74);
            Iterator<dqi> it = this.DqN.BlackList.iterator();
            while (it.hasNext()) {
                this.PZM.add(it.next().MTo);
            }
            AppMethodBeat.o(38072);
            return;
        }
        if (this.DqN.ExtFlag == 5) {
            this.Fxk = getString(R.string.h75);
            Iterator<dqi> it2 = this.DqN.GroupUser.iterator();
            while (it2.hasNext()) {
                this.PZM.add(it2.next().MTo);
            }
        }
        AppMethodBeat.o(38072);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(38073);
        setMMTitle(this.Fxk);
        findViewById(R.id.epv).setVisibility(8);
        this.yCT = (ListView) findViewById(R.id.h4);
        ((TextView) findViewById(R.id.c2l)).setVisibility(8);
        findViewById(R.id.hl).setVisibility(8);
        this.yCT.setBackgroundColor(getResources().getColor(R.color.afz));
        ((View) this.yCT.getParent()).setBackgroundColor(getResources().getColor(R.color.afz));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.SnsLabelContactListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38062);
                SnsLabelContactListUI.this.finish();
                AppMethodBeat.o(38062);
                return true;
            }
        });
        showOptionMenu(false);
        if (!(this.PZM == null || this.PZM.size() == 0)) {
            this.PZL = new a(this, this.PZM);
            this.yCT.setAdapter((ListAdapter) this.PZL);
            this.yCT.setVisibility(0);
            this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.ui.contact.SnsLabelContactListUI.AnonymousClass2 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(38063);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    Intent intent = new Intent();
                    com.tencent.mm.contact.c cVar = (com.tencent.mm.contact.c) SnsLabelContactListUI.this.PZL.getItem(i2);
                    i iVar = o.DCR;
                    if (iVar == null) {
                        SnsLabelContactListUI.this.finish();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(38063);
                        return;
                    }
                    Intent g2 = iVar.g(intent, cVar.field_username);
                    if (g2 == null) {
                        SnsLabelContactListUI.this.finish();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(38063);
                        return;
                    }
                    g2.putExtra("Contact_User", cVar.field_username);
                    WorkerProfile.Xg().dnw.c(g2, SnsLabelContactListUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(38063);
                }
            });
        }
        AppMethodBeat.o(38073);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(38074);
        super.onResume();
        if (this.PZL != null) {
            this.PZL.notifyDataSetChanged();
        }
        AppMethodBeat.o(38074);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(38075);
        EventCenter.instance.removeListener(this.PZO);
        super.onDestroy();
        AppMethodBeat.o(38075);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cf;
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        private bv EBg = null;
        private ColorStateList Fxn;
        private ColorStateList Fxo;
        private Map<Integer, com.tencent.mm.contact.c> PZQ = new HashMap();
        private Context context = null;

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(android.content.Context r8, java.util.List<java.lang.String> r9) {
            /*
            // Method dump skipped, instructions count: 243
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.SnsLabelContactListUI.a.<init>(android.content.Context, java.util.List):void");
        }

        public final int getCount() {
            AppMethodBeat.i(38065);
            int size = this.PZQ.size();
            AppMethodBeat.o(38065);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(38066);
            if (i2 < 0) {
                AppMethodBeat.o(38066);
                return null;
            }
            com.tencent.mm.contact.c cVar = this.PZQ.get(Integer.valueOf(i2));
            AppMethodBeat.o(38066);
            return cVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(38067);
            if (view == null) {
                view = View.inflate(this.context, R.layout.xw, null);
                c cVar2 = new c((byte) 0);
                cVar2.yuS = (TextView) view.findViewById(R.id.bdr);
                cVar2.gAN = (MaskLayout) view.findViewById(R.id.bdo);
                cVar2.gwR = (TextView) view.findViewById(R.id.bdw);
                cVar2.Fxp = (TextView) view.findViewById(R.id.bdm);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            getItem(i2);
            com.tencent.mm.contact.c cVar3 = (com.tencent.mm.contact.c) getItem(i2);
            cVar.yuS.setVisibility(8);
            cVar.gwR.setTextColor(!ab.JE(cVar3.field_username) ? this.Fxn : this.Fxo);
            a.b.A((ImageView) cVar.gAN.getContentView(), cVar3.field_username);
            cVar.Fxp.setVisibility(8);
            cVar.gAN.setVisibility(0);
            cVar.gwR.setText(l.b(this.context, cVar3.arJ(), cVar.gwR.getTextSize()));
            cVar.gwR.setVisibility(0);
            AppMethodBeat.o(38067);
            return view;
        }
    }

    static class c {
        TextView Fxp;
        MaskLayout gAN;
        TextView gwR;
        TextView yuS;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    class b extends IListener<su> {
        private b() {
            AppMethodBeat.i(161549);
            this.__eventId = su.class.getName().hashCode();
            AppMethodBeat.o(161549);
        }

        /* synthetic */ b(SnsLabelContactListUI snsLabelContactListUI, byte b2) {
            this();
            AppMethodBeat.i(161550);
            this.__eventId = su.class.getName().hashCode();
            AppMethodBeat.o(161550);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(su suVar) {
            AppMethodBeat.i(38069);
            su suVar2 = suVar;
            if (suVar2 instanceof su) {
                SnsLabelContactListUI.this.DqN = suVar2.dZn.dPc;
                if (SnsLabelContactListUI.this.DqN != null) {
                    SnsLabelContactListUI.c(SnsLabelContactListUI.this);
                    SnsLabelContactListUI.this.initView();
                } else {
                    SnsLabelContactListUI.this.initView();
                    h.d(SnsLabelContactListUI.this, SnsLabelContactListUI.this.getString(R.string.h76), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.contact.SnsLabelContactListUI.b.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(38068);
                            SnsLabelContactListUI.this.finish();
                            AppMethodBeat.o(38068);
                        }
                    });
                }
                AppMethodBeat.o(38069);
                return true;
            }
            AppMethodBeat.o(38069);
            return false;
        }
    }
}
