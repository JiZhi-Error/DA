package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bj.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;

public class ShakeSayHiListUI extends MMActivity {
    private int AAs = 0;
    private int AAt = 0;
    private cm Djk = null;
    private int Dlr = 0;
    private b Dls;
    private ListView kde;
    private int limit = 0;
    private long oNJ;
    private o.g plk = new o.g() {
        /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass2 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(28543);
            d.bgP().aEp(String.valueOf(ShakeSayHiListUI.this.oNJ));
            ShakeSayHiListUI.this.Dls.onNotifyChange(null, null);
            AppMethodBeat.o(28543);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeSayHiListUI() {
        AppMethodBeat.i(28553);
        AppMethodBeat.o(28553);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28554);
        super.onCreate(bundle);
        this.Dlr = getIntent().getIntExtra("IntentSayHiType", 1);
        if (this.Dlr == 1) {
            this.Djk = d.bgP();
            setMMTitle(R.string.gb2);
        } else {
            setMMTitle(R.string.gb0);
        }
        this.AAt = this.Djk.ctM();
        this.limit = this.AAt == 0 ? 8 : this.AAt;
        this.AAs = this.Djk.getCount();
        cm cmVar = this.Djk;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        if (cmVar.db.update(cmVar.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            cmVar.doNotify();
        }
        initView();
        AppMethodBeat.o(28554);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(28555);
        super.onResume();
        if (this.AAs != this.Djk.getCount()) {
            this.AAs = this.Djk.getCount();
            if (this.AAs == 0) {
                TextView textView = (TextView) findViewById(R.id.c30);
                textView.setText(R.string.gb3);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.Dls.anp();
        }
        this.Dls.notifyDataSetChanged();
        AppMethodBeat.o(28555);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(28556);
        this.Dls.ebf();
        super.onDestroy();
        AppMethodBeat.o(28556);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(28557);
        super.onPause();
        if (this.Dls.plb != null) {
            this.Dls.plb.ebo();
        }
        AppMethodBeat.o(28557);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.azl;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(28558);
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(28558);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(28559);
        final View inflate = getLayoutInflater().inflate(R.layout.bnk, (ViewGroup) null);
        this.kde = (ListView) findViewById(R.id.h_l);
        inflate.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(28542);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ShakeSayHiListUI.this.limit += 8;
                Log.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.this.limit);
                ShakeSayHiListUI.this.Dls.XB(ShakeSayHiListUI.this.limit);
                if (ShakeSayHiListUI.this.AAs <= ShakeSayHiListUI.this.limit) {
                    ShakeSayHiListUI.this.kde.removeFooterView(inflate);
                    Log.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.this.limit);
                }
                a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28542);
            }
        });
        addTextOptionMenu(0, getString(R.string.t2), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28545);
                h.a((Context) ShakeSayHiListUI.this.getContext(), true, ShakeSayHiListUI.this.getString(R.string.gay), "", ShakeSayHiListUI.this.getString(R.string.gax), ShakeSayHiListUI.this.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass3.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(28544);
                        ShakeSayHiListUI.this.Djk.byC();
                        ShakeSayHiListUI.this.Dls.anp();
                        TextView textView = (TextView) ShakeSayHiListUI.this.findViewById(R.id.c30);
                        textView.setText(R.string.gb3);
                        textView.setVisibility(0);
                        ShakeSayHiListUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(28544);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass3.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(28545);
                return true;
            }
        });
        if (this.AAs == 0) {
            TextView textView = (TextView) findViewById(R.id.c30);
            textView.setText(R.string.gb3);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.AAs > 0 && this.limit < this.AAs) {
            this.kde.addFooterView(inflate);
        }
        this.Dls = new b(this, this.Djk, this.limit);
        this.Dls.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(28546);
                int positionForView = ShakeSayHiListUI.this.kde.getPositionForView(view);
                AppMethodBeat.o(28546);
                return positionForView;
            }
        });
        this.Dls.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(28547);
                ShakeSayHiListUI.this.kde.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(28547);
            }
        });
        this.Dls.a(new MMSlideDelView.f() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.f
            public final void cZ(Object obj) {
                AppMethodBeat.i(28548);
                if (obj == null) {
                    Log.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    AppMethodBeat.o(28548);
                    return;
                }
                d.bgP().aEp(obj.toString());
                ShakeSayHiListUI.this.Dls.onNotifyChange(null, null);
                AppMethodBeat.o(28548);
            }
        });
        this.kde.setAdapter((ListAdapter) this.Dls);
        this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass7 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(28549);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                cl clVar = (cl) ShakeSayHiListUI.this.Dls.getItem(i2);
                if (clVar == null || clVar.field_content == null) {
                    a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(28549);
                    return;
                }
                ca.d bkD = ca.d.bkD(clVar.field_content);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", bkD.dkU);
                intent.putExtra("Contact_Encryptusername", bkD.OqZ);
                intent.putExtra("Contact_Alias", bkD.fMb);
                intent.putExtra("Contact_Nick", bkD.nickname);
                intent.putExtra("Contact_QuanPin", bkD.kfR);
                intent.putExtra("Contact_PyInitial", bkD.kfQ);
                intent.putExtra("Contact_Sex", bkD.fuA);
                intent.putExtra("Contact_Signature", bkD.signature);
                intent.putExtra("Contact_Scene", bkD.scene);
                intent.putExtra("Contact_FMessageCard", true);
                intent.putExtra("Contact_City", bkD.getCity());
                intent.putExtra("Contact_Province", bkD.getProvince());
                intent.putExtra("Contact_Content", Util.isNullOrNil(clVar.field_sayhicontent) ? ShakeSayHiListUI.this.getString(R.string.ays) : clVar.field_sayhicontent);
                intent.putExtra("Contact_verify_Scene", bkD.scene);
                intent.putExtra("Contact_Uin", bkD.Bge);
                intent.putExtra("Contact_QQNick", bkD.kfS);
                intent.putExtra("Contact_Mobile_MD5", bkD.OqK);
                intent.putExtra("User_From_Fmessage", true);
                intent.putExtra("Contact_from_msgType", 37);
                intent.putExtra("Verify_ticket", bkD.wZz);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("Contact_Source_FMessage", bkD.scene);
                bg.aVF();
                as Kn = c.aSN().Kn(bkD.dkU);
                if (Kn != null && ((int) Kn.gMZ) >= 0 && !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    int i3 = bkD.dKy;
                    if (i3 == 0 || i3 == 2 || i3 == 5) {
                        intent.putExtra("User_Verify", true);
                    }
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Sns_from_Scene", 18);
                }
                com.tencent.mm.plugin.shake.a.jRt.c(intent, ShakeSayHiListUI.this);
                a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(28549);
            }
        });
        final l lVar = new l(this);
        this.kde.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass8 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(28550);
                if (i2 < ShakeSayHiListUI.this.kde.getHeaderViewsCount()) {
                    Log.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                    AppMethodBeat.o(28550);
                } else {
                    lVar.a(view, i2, j2, ShakeSayHiListUI.this, ShakeSayHiListUI.this.plk);
                    AppMethodBeat.o(28550);
                }
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass9 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28551);
                ShakeSayHiListUI.this.hideVKB();
                ShakeSayHiListUI.this.finish();
                AppMethodBeat.o(28551);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(28552);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(ShakeSayHiListUI.this.kde);
                Object obj = new Object();
                a.a(obj, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                a.a(obj, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28552);
            }
        });
        AppMethodBeat.o(28559);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(28560);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        this.oNJ = ((cl) this.Dls.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.tf);
        AppMethodBeat.o(28560);
    }
}
