package com.tencent.mm.plugin.nearby.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.j;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;

public class NearbySayHiListUI extends MMActivity implements i {
    private by AAq = null;
    private a AAr;
    private int AAs = 0;
    private int AAt = 0;
    private boolean AAu;
    private long AAv;
    private c AzP;
    private ListView kde;
    private View kgo;
    private int limit = 0;
    private int maxCount = 0;
    private o.g plk = new o.g() {
        /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass3 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(89894);
            g.aAf().azk();
            ((l) g.af(l.class)).eiv().aEp(String.valueOf(NearbySayHiListUI.this.AAv));
            NearbySayHiListUI.this.AAr.onNotifyChange(null, null);
            if (NearbySayHiListUI.this.AAs > 0) {
                NearbySayHiListUI.i(NearbySayHiListUI.this);
            }
            NearbySayHiListUI.j(NearbySayHiListUI.this);
            AppMethodBeat.o(89894);
        }
    };
    private q tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NearbySayHiListUI() {
        AppMethodBeat.i(89912);
        AppMethodBeat.o(89912);
    }

    static /* synthetic */ int i(NearbySayHiListUI nearbySayHiListUI) {
        int i2 = nearbySayHiListUI.AAs;
        nearbySayHiListUI.AAs = i2 - 1;
        return i2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        int i2;
        NearbySayHiListUI nearbySayHiListUI;
        AppMethodBeat.i(89913);
        super.onCreate(bundle);
        this.maxCount = Util.safeParseInt(h.aqJ().getValue("ThresholdToCleanLocation"));
        this.AAu = getIntent().getBooleanExtra("show_clear_header", false);
        g.aAf().azk();
        this.AAq = (by) ((l) g.af(l.class)).eiv();
        setMMTitle(R.string.gb0);
        this.AAt = this.AAq.ctM();
        this.AAs = this.AAq.getCount();
        if (com.tencent.mm.bp.a.glC()) {
            i2 = this.AAs;
            nearbySayHiListUI = this;
        } else if (this.AAt == 0) {
            i2 = 8;
            nearbySayHiListUI = this;
        } else {
            i2 = this.AAt;
            nearbySayHiListUI = this;
        }
        nearbySayHiListUI.limit = i2;
        by byVar = this.AAq;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        if (byVar.db.update(byVar.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            byVar.doNotify();
        }
        initView();
        AppMethodBeat.o(89913);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(89914);
        super.onResume();
        if (this.AAs != this.AAq.getCount()) {
            this.AAs = this.AAq.getCount();
            if (this.AAs == 0) {
                TextView textView = (TextView) findViewById(R.id.c30);
                textView.setText(R.string.gb3);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.AAr.anp();
        }
        this.AAr.notifyDataSetChanged();
        g.azz().a(148, this);
        AppMethodBeat.o(89914);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(89915);
        this.AAr.ebf();
        super.onDestroy();
        AppMethodBeat.o(89915);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(89916);
        g.azz().b(148, this);
        super.onPause();
        AppMethodBeat.o(89916);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.azl;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(89917);
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(89917);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(89918);
        this.kde = (ListView) findViewById(R.id.h_l);
        if (!com.tencent.mm.bp.a.glC()) {
            final View inflate = getLayoutInflater().inflate(R.layout.bnk, (ViewGroup) null);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(89892);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    NearbySayHiListUI.this.limit += 8;
                    Log.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.this.limit);
                    a aVar = NearbySayHiListUI.this.AAr;
                    int i2 = NearbySayHiListUI.this.limit;
                    aVar.ebf();
                    aVar.limit = i2;
                    aVar.anp();
                    if (NearbySayHiListUI.this.AAs <= NearbySayHiListUI.this.limit) {
                        NearbySayHiListUI.this.kde.removeFooterView(inflate);
                        Log.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.this.limit);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(89892);
                }
            });
            if (this.AAs > 0 && this.limit < this.AAs) {
                this.kde.addFooterView(inflate);
            }
        }
        addTextOptionMenu(0, getString(R.string.t2), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(89897);
                com.tencent.mm.ui.base.h.a((Context) NearbySayHiListUI.this.getContext(), true, NearbySayHiListUI.this.getResources().getString(R.string.gay), "", NearbySayHiListUI.this.getResources().getString(R.string.gax), NearbySayHiListUI.this.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass5.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(89896);
                        NearbySayHiListUI.this.AAq.byC();
                        NearbySayHiListUI.this.AAr.anp();
                        TextView textView = (TextView) NearbySayHiListUI.this.findViewById(R.id.c30);
                        textView.setText(R.string.gb3);
                        textView.setVisibility(0);
                        NearbySayHiListUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(89896);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(89897);
                return true;
            }
        });
        if (this.AAs == 0) {
            TextView textView = (TextView) findViewById(R.id.c30);
            textView.setText(R.string.gb3);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.AAu && this.maxCount != 0 && this.AAt >= this.maxCount && Util.isOverseasUser(this)) {
            this.kgo = new CleanLocationHeaderView(this);
            this.kgo.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(89899);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    NearbySayHiListUI.this.AzP = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    g.azz().a(NearbySayHiListUI.this.AzP, 0);
                    NearbySayHiListUI nearbySayHiListUI = NearbySayHiListUI.this;
                    AppCompatActivity context = NearbySayHiListUI.this.getContext();
                    NearbySayHiListUI.this.getString(R.string.zb);
                    nearbySayHiListUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) context, NearbySayHiListUI.this.getString(R.string.f_s), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass6.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(89898);
                            g.azz().a(NearbySayHiListUI.this.AzP);
                            AppMethodBeat.o(89898);
                        }
                    });
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(11429, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(89899);
                }
            });
            this.kde.addHeaderView(this.kgo);
        }
        this.AAr = new a(this, this.AAq, this.limit);
        this.AAr.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(89900);
                int positionForView = NearbySayHiListUI.this.kde.getPositionForView(view);
                AppMethodBeat.o(89900);
                return positionForView;
            }
        });
        this.AAr.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(89901);
                NearbySayHiListUI.this.kde.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(89901);
            }
        });
        this.AAr.a(new MMSlideDelView.f() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.f
            public final void cZ(Object obj) {
                AppMethodBeat.i(89902);
                if (obj == null) {
                    Log.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    AppMethodBeat.o(89902);
                    return;
                }
                g.aAf().azk();
                ((l) g.af(l.class)).eiv().aEp(obj.toString());
                NearbySayHiListUI.this.AAr.onNotifyChange(null, null);
                AppMethodBeat.o(89902);
            }
        });
        this.kde.setAdapter((ListAdapter) this.AAr);
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.kde.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass10 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(89903);
                if (i2 < NearbySayHiListUI.this.kde.getHeaderViewsCount()) {
                    Log.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                    AppMethodBeat.o(89903);
                } else {
                    lVar.a(view, i2, j2, NearbySayHiListUI.this, NearbySayHiListUI.this.plk);
                    AppMethodBeat.o(89903);
                }
                return true;
            }
        });
        this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass11 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                String str;
                AppMethodBeat.i(89904);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (NearbySayHiListUI.this.kde.getHeaderViewsCount() > 0) {
                    i2 -= NearbySayHiListUI.this.kde.getHeaderViewsCount();
                }
                bx bxVar = (bx) NearbySayHiListUI.this.AAr.getItem(i2);
                if (bxVar == null || bxVar.field_content == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(89904);
                    return;
                }
                ca.d bkD = ca.d.bkD(bxVar.field_content);
                Intent intent = new Intent();
                if (com.tencent.mm.bp.a.glC()) {
                    intent.putExtra("Chat_User", bxVar.field_sayhiencryptuser);
                    intent.putExtra("lbs_mode", true);
                    intent.putExtra("add_scene", 18);
                    com.tencent.mm.plugin.nearby.a.jRt.d(intent, NearbySayHiListUI.this);
                } else {
                    Intent intent2 = new Intent();
                    if (Util.isNullOrNil(bkD.dkU)) {
                        str = bxVar.field_sayhiuser;
                    } else {
                        str = bkD.dkU;
                    }
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Contact_Alias", bkD.fMb);
                    intent2.putExtra("Contact_Nick", bkD.nickname);
                    intent2.putExtra("Contact_QuanPin", bkD.kfR);
                    intent2.putExtra("Contact_PyInitial", bkD.kfQ);
                    intent2.putExtra("Contact_Sex", bkD.fuA);
                    intent2.putExtra("Contact_Signature", bkD.signature);
                    intent2.putExtra("Contact_Scene", bkD.scene);
                    intent2.putExtra("Contact_FMessageCard", true);
                    intent2.putExtra("Contact_City", bkD.getCity());
                    intent2.putExtra("Contact_Province", bkD.getProvince());
                    intent2.putExtra("Contact_Content", Util.isNullOrNil(bxVar.field_sayhicontent) ? NearbySayHiListUI.this.getString(R.string.ays) : bxVar.field_sayhicontent);
                    intent2.putExtra("Contact_verify_Scene", bkD.scene);
                    intent2.putExtra("Contact_Uin", bkD.Bge);
                    intent2.putExtra("Contact_QQNick", bkD.kfS);
                    intent2.putExtra("Contact_Mobile_MD5", bkD.OqK);
                    intent2.putExtra("User_From_Fmessage", true);
                    intent2.putExtra("Contact_from_msgType", 37);
                    intent2.putExtra("Verify_ticket", bkD.wZz);
                    intent2.putExtra("Contact_Source_FMessage", bkD.scene);
                    intent2.putExtra("Contact_ShowFMessageList", true);
                    as Kn = ((l) g.af(l.class)).aSN().Kn(bkD.dkU);
                    if (Kn != null && ((int) Kn.gMZ) >= 0 && !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                        int i3 = bkD.dKy;
                        if (i3 == 0 || i3 == 2 || i3 == 5) {
                            intent2.putExtra("User_Verify", true);
                        }
                        intent2.putExtra("Contact_IsLBSFriend", true);
                        intent2.putExtra("Sns_from_Scene", 18);
                    }
                    com.tencent.mm.plugin.nearby.a.jRt.c(intent2, NearbySayHiListUI.this);
                }
                j jVar = new j();
                jVar.dCb.scene = bkD.scene;
                EventCenter.instance.publish(jVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(89904);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(89905);
                NearbySayHiListUI.this.hideVKB();
                NearbySayHiListUI.this.setResult(0);
                NearbySayHiListUI.this.finish();
                AppMethodBeat.o(89905);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(89893);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(NearbySayHiListUI.this.kde);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(89893);
            }
        });
        AppMethodBeat.o(89918);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(89919);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        bx bxVar = (bx) this.AAr.getItem(adapterContextMenuInfo.position);
        if (bxVar == null) {
            Log.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            AppMethodBeat.o(89919);
            return;
        }
        contextMenu.add(0, 0, 0, R.string.tf);
        this.AAv = bxVar.field_svrid;
        AppMethodBeat.o(89919);
    }

    /* access modifiers changed from: package-private */
    public class a extends s<bx> {
        protected MMSlideDelView.f AAA;
        private by AAq;
        private MMActivity gte;
        int limit = -1;
        protected MMSlideDelView.g pkY;
        protected MMSlideDelView.c pkZ;
        protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ bx a(bx bxVar, Cursor cursor) {
            AppMethodBeat.i(89911);
            bx bxVar2 = bxVar;
            if (bxVar2 == null) {
                bxVar2 = new bx();
            }
            bxVar2.convertFrom(cursor);
            AppMethodBeat.o(89911);
            return bxVar2;
        }

        public a(Context context, by byVar, int i2) {
            super(context, new bx());
            AppMethodBeat.i(89907);
            this.gte = (MMActivity) context;
            this.limit = i2;
            this.AAq = byVar;
            AppMethodBeat.o(89907);
        }

        public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
            this.pkY = gVar;
        }

        public final void a(MMSlideDelView.f fVar) {
            this.AAA = fVar;
        }

        public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
            this.pkZ = cVar;
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(89908);
            anp();
            AppMethodBeat.o(89908);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(89909);
            if (com.tencent.mm.bp.a.glC()) {
                setCursor(this.AAq.akl(this.limit));
            } else {
                setCursor(this.AAq.Pf(this.limit));
            }
            super.notifyDataSetChanged();
            AppMethodBeat.o(89909);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1563a aVar;
            String str;
            AppMethodBeat.i(89910);
            bx bxVar = (bx) getItem(i2);
            if (view == null) {
                C1563a aVar2 = new C1563a();
                MMSlideDelView mMSlideDelView = (MMSlideDelView) View.inflate(this.gte, R.layout.is, null);
                View inflate = View.inflate(this.gte, R.layout.bnj, null);
                aVar2.gyr = (ImageView) inflate.findViewById(R.id.bdp);
                aVar2.kcS = (TextView) inflate.findViewById(R.id.bro);
                aVar2.znW = (TextView) inflate.findViewById(R.id.h_o);
                aVar2.plg = mMSlideDelView.findViewById(R.id.hsk);
                aVar2.plh = (TextView) mMSlideDelView.findViewById(R.id.hsm);
                mMSlideDelView.setView(inflate);
                mMSlideDelView.setPerformItemClickListener(this.pkY);
                mMSlideDelView.setGetViewPositionCallback(this.pkZ);
                mMSlideDelView.setItemStatusCallBack(this.plb);
                mMSlideDelView.setEnable(false);
                mMSlideDelView.setTag(aVar2);
                aVar = aVar2;
                view = mMSlideDelView;
            } else {
                aVar = (C1563a) view.getTag();
            }
            if (bxVar.field_flag != 0) {
                str = ca.d.bkD(bxVar.field_content).nickname;
            } else {
                str = bxVar.field_talker;
            }
            aVar.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, str, aVar.kcS.getTextSize()));
            aVar.znW.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, bxVar.field_sayhicontent, aVar.znW.getTextSize()));
            aVar.plg.setTag(Long.valueOf(bxVar.field_svrid));
            aVar.plg.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(89906);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.v("MicroMsg.SayHiAdapter", "on delView clicked");
                    a.this.plb.ebp();
                    if (a.this.AAA != null) {
                        a.this.AAA.cZ(view.getTag());
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(89906);
                }
            });
            a.b.c(aVar.gyr, bxVar.field_sayhiuser);
            AppMethodBeat.o(89910);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$a$a  reason: collision with other inner class name */
        class C1563a {
            ImageView gyr;
            TextView kcS;
            View plg;
            TextView plh;
            TextView znW;

            C1563a() {
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(89920);
        setResult(0);
        super.onBackPressed();
        AppMethodBeat.o(89920);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(89921);
        Log.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i2 != 0 || i3 != 0) {
            Log.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
        } else if (((c) qVar).Vj() == 2) {
            com.tencent.mm.ui.base.h.d(getContext(), getString(R.string.f_r), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(89895);
                    NearbySayHiListUI.this.setResult(-1);
                    NearbySayHiListUI.this.finish();
                    AppMethodBeat.o(89895);
                }
            });
            this.AzP = null;
            AppMethodBeat.o(89921);
            return;
        }
        AppMethodBeat.o(89921);
    }

    static /* synthetic */ void j(NearbySayHiListUI nearbySayHiListUI) {
        AppMethodBeat.i(89922);
        if (nearbySayHiListUI.AAs == 0) {
            TextView textView = (TextView) nearbySayHiListUI.findViewById(R.id.c30);
            textView.setText(R.string.gb3);
            textView.setVisibility(0);
            nearbySayHiListUI.enableOptionMenu(false);
        }
        AppMethodBeat.o(89922);
    }
}
