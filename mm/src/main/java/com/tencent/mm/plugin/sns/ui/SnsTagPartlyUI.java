package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.s;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class SnsTagPartlyUI extends MMActivity implements i {
    private a EKb;
    private View.OnClickListener EKc = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(99203);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (SnsTagPartlyUI.this.EKb == null) {
                Log.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99203);
                return;
            }
            Object tag = view.getTag();
            if (tag == null) {
                Log.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99203);
            } else if (!(tag instanceof Integer)) {
                Log.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99203);
            } else {
                s sVar = (s) SnsTagPartlyUI.this.EKb.getItem(((Integer) tag).intValue());
                SnsTagPartlyUI.this.tipDialog = h.a((Context) SnsTagPartlyUI.this, (String) null, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.AnonymousClass5.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                g.aAi();
                g.aAg().hqi.a(new y(sVar.field_tagId, sVar.field_tagName), 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99203);
            }
        }
    };
    private ListView krb;
    protected q tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsTagPartlyUI() {
        AppMethodBeat.i(99209);
        AppMethodBeat.o(99209);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(99210);
        super.onCreate(bundle);
        g.aAi();
        g.aAg().hqi.a(l.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, this);
        initView();
        AppMethodBeat.o(99210);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(99211);
        g.aAi();
        g.aAg().hqi.b(l.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, this);
        if (this.EKb != null) {
            this.EKb.ebf();
        }
        super.onDestroy();
        AppMethodBeat.o(99211);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(99212);
        super.onResume();
        if (this.EKb != null) {
            this.EKb.onNotifyChange("", null);
        }
        AppMethodBeat.o(99212);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(99213);
        setMMTitle(R.string.gt1);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(99199);
                SnsTagPartlyUI.this.finish();
                AppMethodBeat.o(99199);
                return true;
            }
        });
        this.krb = (ListView) findViewById(R.id.i12);
        this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(99200);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 < SnsTagPartlyUI.this.EKb.getCount() - 1) {
                    Intent intent = new Intent();
                    s sVar = (s) SnsTagPartlyUI.this.EKb.getItem(i2);
                    if (sVar == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(99200);
                        return;
                    }
                    intent.putExtra("k_sns_tag_id", sVar.field_tagId);
                    intent.setClass(SnsTagPartlyUI.this, SnsTagDetailUI.class);
                    SnsTagPartlyUI snsTagPartlyUI = SnsTagPartlyUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(snsTagPartlyUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    snsTagPartlyUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(snsTagPartlyUI, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else {
                    Intent intent2 = new Intent();
                    String aTY = z.aTY();
                    intent2.putExtra("titile", SnsTagPartlyUI.this.getString(R.string.fz));
                    intent2.putExtra("list_type", 1);
                    intent2.putExtra("KBlockOpenImFav", true);
                    intent2.putExtra("list_attr", u.ll(u.Q(u.PWT, 1024), TPMediaCodecProfileLevel.HEVCMainTierLevel62));
                    intent2.putExtra("block_contact", aTY);
                    c.c(SnsTagPartlyUI.this, ".ui.contact.SelectContactUI", intent2, 1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(99200);
            }
        });
        this.EKb = new a(this);
        this.krb.addFooterView(View.inflate(this, R.layout.bxg, null));
        this.krb.setAdapter((ListAdapter) this.EKb);
        addTextOptionMenu(0, getString(R.string.ham), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                AppMethodBeat.i(99201);
                a aVar = SnsTagPartlyUI.this.EKb;
                if (!SnsTagPartlyUI.this.EKb.EKf) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.EKf = z;
                SnsTagPartlyUI.this.updateOptionMenuText(0, SnsTagPartlyUI.this.EKb.EKf ? SnsTagPartlyUI.this.getString(R.string.vl) : SnsTagPartlyUI.this.getString(R.string.ham));
                SnsTagPartlyUI.this.EKb.notifyDataSetChanged();
                AppMethodBeat.o(99201);
                return true;
            }
        });
        this.EKb.a(new s.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                boolean z = true;
                AppMethodBeat.i(99202);
                SnsTagPartlyUI snsTagPartlyUI = SnsTagPartlyUI.this;
                if (SnsTagPartlyUI.this.EKb.getCount() <= 1) {
                    z = false;
                }
                snsTagPartlyUI.enableOptionMenu(z);
                AppMethodBeat.o(99202);
            }
        });
        AppMethodBeat.o(99213);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bxh;
    }

    /* access modifiers changed from: package-private */
    public class a extends com.tencent.mm.ui.s<com.tencent.mm.plugin.sns.storage.s> {
        public boolean EKf = false;
        private Context context;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ com.tencent.mm.plugin.sns.storage.s a(com.tencent.mm.plugin.sns.storage.s sVar, Cursor cursor) {
            AppMethodBeat.i(99208);
            com.tencent.mm.plugin.sns.storage.s sVar2 = sVar;
            if (sVar2 == null) {
                sVar2 = new com.tencent.mm.plugin.sns.storage.s();
                Log.d("MicroMsg.SnsTagPartlyUI", "new SnsInfo");
            }
            sVar2.convertFrom(cursor);
            AppMethodBeat.o(99208);
            return sVar2;
        }

        public a(Context context2) {
            super(context2, new com.tencent.mm.plugin.sns.storage.s());
            AppMethodBeat.i(99204);
            this.context = context2;
            AppMethodBeat.o(99204);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1733a aVar;
            int i3;
            AppMethodBeat.i(99205);
            if (view == null) {
                aVar = new C1733a();
                view = View.inflate(this.context, R.layout.bh9, null);
                aVar.EKg = (TextView) view.findViewById(R.id.ih8);
                aVar.EKh = (TextView) view.findViewById(R.id.i0w);
                aVar.kjo = (Button) view.findViewById(R.id.blh);
                view.setTag(aVar);
            } else {
                aVar = (C1733a) view.getTag();
            }
            if (!Ox(i2)) {
                com.tencent.mm.plugin.sns.storage.s sVar = (com.tencent.mm.plugin.sns.storage.s) getItem(i2);
                aVar.EKg.setText(sVar.field_tagName);
                aVar.EKh.setVisibility(0);
                aVar.EKh.setText(" (" + sVar.field_count + ") ");
                Button button = aVar.kjo;
                if (this.EKf) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                button.setVisibility(i3);
                aVar.kjo.setOnClickListener(SnsTagPartlyUI.this.EKc);
                aVar.kjo.setTag(Integer.valueOf(i2));
            } else {
                aVar.EKg.setText(R.string.hk7);
                aVar.EKh.setVisibility(8);
                aVar.kjo.setVisibility(8);
            }
            AppMethodBeat.o(99205);
            return view;
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(99206);
            setCursor(aj.faU().getCursor());
            notifyDataSetChanged();
            AppMethodBeat.o(99206);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(99207);
            ebf();
            anp();
            AppMethodBeat.o(99207);
        }

        @Override // com.tencent.mm.ui.s
        public final int dWu() {
            return 1;
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI$a$a  reason: collision with other inner class name */
        class C1733a {
            TextView EKg;
            TextView EKh;
            Button kjo;

            C1733a() {
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(99214);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(99214);
            return;
        }
        switch (i2) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    String stringExtra2 = intent.getStringExtra("Select_room_name");
                    if (stringExtra != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("k_sns_tag_id", 0);
                        intent2.putExtra("k_sns_tag_name", Util.nullAs(stringExtra2, ""));
                        intent2.putExtra("k_sns_tag_list", stringExtra);
                        intent2.setClass(this, SnsTagDetailUI.class);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    } else {
                        AppMethodBeat.o(99214);
                        return;
                    }
                } else {
                    AppMethodBeat.o(99214);
                    return;
                }
        }
        AppMethodBeat.o(99214);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(99215);
        Log.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.EKb != null) {
            this.EKb.onNotifyChange("", null);
        }
        AppMethodBeat.o(99215);
    }
}
