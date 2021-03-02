package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.api.c;
import com.tencent.mm.api.d;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI extends MMActivity {
    private static MMHandler iuH = new MMHandler(Looper.getMainLooper());
    private ListView FMX;
    private a FMY;
    private LinkedList<dsk> FMZ = new LinkedList<>();
    private Map<String, b> FNa;
    private LinkedList<drr> iAd = new LinkedList<>();

    static class c {
        public ImageView gvv;
        public TextView gwR;
        public View pnQ;
        public TextView pnR;
        View pnU;
        public String username;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactSearchResultUI() {
        AppMethodBeat.i(29209);
        AppMethodBeat.o(29209);
    }

    static {
        AppMethodBeat.i(29214);
        AppMethodBeat.o(29214);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29210);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(29210);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29211);
        setMMTitle(R.string.bi_);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29205);
                ContactSearchResultUI.this.finish();
                AppMethodBeat.o(29205);
                return true;
            }
        });
        this.FNa = new HashMap();
        this.FMX = (ListView) findViewById(R.id.h5l);
        this.FMX.setEmptyView((TextView) findViewById(R.id.c2g));
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("result");
        final int intExtra = getIntent().getIntExtra("add_more_friend_search_scene", 0);
        if (byteArrayExtra != null) {
            try {
                drt drt = (drt) new drt().parseFrom(byteArrayExtra);
                if (drt != null) {
                    this.iAd = drt.LUC;
                    this.FMZ = drt.MUq;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", e2, "SearchContactResponse", new Object[0]);
                try {
                    this.FMZ.add((dsk) new dsk().parseFrom(byteArrayExtra));
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", e3, "SearchOpenIMContactItem", new Object[0]);
                }
            }
        }
        if (this.iAd.size() != 0 || !this.FMZ.isEmpty()) {
            this.FMY = new a(this);
            this.FMX.setAdapter((ListAdapter) this.FMY);
            this.FMX.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.AnonymousClass2 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(29206);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    int headerViewsCount = i2 - ContactSearchResultUI.this.FMX.getHeaderViewsCount();
                    if (headerViewsCount < 0 || headerViewsCount >= ContactSearchResultUI.this.FMX.getCount()) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(29206);
                    } else if (headerViewsCount >= ContactSearchResultUI.this.iAd.size()) {
                        ContactSearchResultUI.a(ContactSearchResultUI.this, (dsk) ContactSearchResultUI.this.FMZ.get(i2 - ContactSearchResultUI.this.iAd.size()));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(29206);
                    } else {
                        drr drr = (drr) ContactSearchResultUI.this.iAd.get(headerViewsCount);
                        String str = drr.Lqk.MTo;
                        bg.aVF();
                        as Kn = com.tencent.mm.model.c.aSN().Kn(str);
                        if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                            Intent intent = new Intent();
                            intent.putExtra("Contact_User", str);
                            intent.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                if (Kn.gBM()) {
                                    h.INSTANCE.kvStat(10298, str + ",35");
                                    intent.putExtra("Contact_Scene", 35);
                                }
                                com.tencent.mm.br.c.b(ContactSearchResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                            }
                        } else {
                            if ((drr.MmK & 8) > 0) {
                                h.INSTANCE.kvStat(10298, drr.Lqk.MTo + ",35");
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Contact_User", drr.Lqk.MTo);
                            intent2.putExtra("Contact_Alias", drr.ked);
                            intent2.putExtra("Contact_Nick", drr.Mjj.MTo);
                            intent2.putExtra("Contact_Signature", drr.keb);
                            intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(drr.keh, drr.kdZ, drr.kea));
                            intent2.putExtra("Contact_Sex", drr.kdY);
                            intent2.putExtra("Contact_VUser_Info", drr.MmL);
                            intent2.putExtra("Contact_VUser_Info_Flag", drr.MmK);
                            intent2.putExtra("Contact_KWeibo_flag", drr.MmO);
                            intent2.putExtra("Contact_KWeibo", drr.MmM);
                            intent2.putExtra("Contact_KWeiboNick", drr.MmN);
                            intent2.putExtra("Contact_KSnsIFlag", drr.MmQ.kej);
                            intent2.putExtra("Contact_KSnsBgId", drr.MmQ.kel);
                            intent2.putExtra("Contact_KSnsBgUrl", drr.MmQ.kek);
                            intent2.putExtra("Contact_Scene", 35);
                            if (intExtra != 0) {
                                intent2.putExtra("add_more_friend_search_scene", intExtra);
                            }
                            if (drr.MmR != null) {
                                try {
                                    intent2.putExtra("Contact_customInfo", drr.MmR.toByteArray());
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", e2, "", new Object[0]);
                                }
                            }
                            if ((drr.MmK & 8) > 0) {
                                h.INSTANCE.kvStat(10298, drr.Lqk.MTo + ",35");
                            }
                            com.tencent.mm.br.c.b(ContactSearchResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(29206);
                    }
                }
            });
            this.FMX.setOnScrollListener(new com.tencent.mm.ui.applet.a());
            AppMethodBeat.o(29211);
            return;
        }
        AppMethodBeat.o(29211);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.yb;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29212);
        p.aYD().cancel();
        if (this.FNa != null) {
            this.FNa.clear();
        }
        super.onDestroy();
        AppMethodBeat.o(29212);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            AppMethodBeat.i(29207);
            int size = ContactSearchResultUI.this.iAd.size() + ContactSearchResultUI.this.FMZ.size();
            AppMethodBeat.o(29207);
            return size;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            int i3;
            String nullAsNil;
            c.b.e eVar;
            boolean z;
            int i4 = 8;
            AppMethodBeat.i(29208);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.bp2, null);
                c cVar2 = new c();
                cVar2.gvv = (ImageView) view.findViewById(R.id.wn);
                cVar2.gwR = (TextView) view.findViewById(R.id.fzd);
                cVar2.pnQ = view.findViewById(R.id.j2u);
                cVar2.pnR = (TextView) view.findViewById(R.id.dzc);
                cVar2.pnU = view.findViewById(R.id.a53);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            if (i2 >= ContactSearchResultUI.this.iAd.size()) {
                dsk dsk = (dsk) ContactSearchResultUI.this.FMZ.get(i2 - ContactSearchResultUI.this.iAd.size());
                cVar.username = dsk.UserName;
                a.b.d(cVar.gvv, cVar.username);
                cVar.gvv.setTag(cVar.username);
                a.b.c(cVar.gvv, cVar.username);
                cVar.pnQ.setVisibility(8);
                cVar.pnU.setVisibility(8);
                cVar.pnR.setText("");
                try {
                    cVar.gwR.setText(l.b(this.mContext, dsk.oUJ, cVar.gwR.getTextSize()));
                } catch (Exception e2) {
                    cVar.gwR.setText("");
                }
                AppMethodBeat.o(29208);
            } else {
                drr drr = (drr) ContactSearchResultUI.this.iAd.get(i2);
                if (drr == null) {
                    Log.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
                    AppMethodBeat.o(29208);
                } else {
                    cVar.username = drr.Lqk.MTo;
                    a.b.d(cVar.gvv, cVar.username);
                    cVar.gvv.setTag(cVar.username);
                    a.b.c(cVar.gvv, cVar.username);
                    String str = drr.Lqk.MTo;
                    b bVar = (b) ContactSearchResultUI.this.FNa.get(str);
                    if (bVar == null) {
                        b bVar2 = new b((byte) 0);
                        ContactSearchResultUI.this.FNa.put(str, bVar2);
                        aeq aeq = drr.MmR;
                        if (aeq != null) {
                            com.tencent.mm.api.c cVar3 = new com.tencent.mm.api.c();
                            cVar3.field_username = str;
                            cVar3.field_brandFlag = aeq.kem;
                            cVar3.field_brandIconURL = aeq.kep;
                            cVar3.field_brandInfo = aeq.keo;
                            cVar3.field_extInfo = aeq.ken;
                            if (cVar3.cG(false) != null) {
                                eVar = cVar3.cG(false).Va();
                            } else {
                                eVar = null;
                            }
                            if (eVar != null) {
                                bVar2.pnO = cVar3.cG(false).Vc() && !Util.isNullOrNil(eVar.diq);
                                if (drr.MmK != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                bVar2.pnN = z;
                            }
                        }
                        bVar = bVar2;
                    }
                    View view2 = cVar.pnQ;
                    if (bVar.pnN) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    view2.setVisibility(i3);
                    View view3 = cVar.pnU;
                    if (bVar.pnO) {
                        i4 = 0;
                    }
                    view3.setVisibility(i4);
                    Log.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", Integer.valueOf(drr.MmK));
                    try {
                        cVar.pnR.setText(l.b(this.mContext, Util.nullAsNil(drr.keb), cVar.pnR.getTextSize()));
                    } catch (Exception e3) {
                        cVar.pnR.setText("");
                    }
                    try {
                        TextView textView = cVar.gwR;
                        Context context = this.mContext;
                        if (!Util.isNullOrNil(drr.Mjj.MTo)) {
                            nullAsNil = drr.Mjj.MTo;
                        } else if (!Util.isNullOrNil(drr.ked)) {
                            nullAsNil = drr.ked;
                        } else {
                            nullAsNil = Util.nullAsNil(drr.Lqk.MTo);
                        }
                        textView.setText(l.b(context, nullAsNil, cVar.gwR.getTextSize()));
                    } catch (Exception e4) {
                        cVar.gwR.setText("");
                    }
                    AppMethodBeat.o(29208);
                }
            }
            return view;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        protected boolean pnN;
        protected boolean pnO;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(ContactSearchResultUI contactSearchResultUI, dsk dsk) {
        int i2 = 1;
        AppMethodBeat.i(29213);
        Intent intent = new Intent();
        if (2 == dsk.MUk) {
            i2 = 15;
        } else if (1 != dsk.MUk) {
            i2 = 0;
        }
        d.a(intent, dsk, i2);
        com.tencent.mm.br.c.b(contactSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(29213);
    }
}
