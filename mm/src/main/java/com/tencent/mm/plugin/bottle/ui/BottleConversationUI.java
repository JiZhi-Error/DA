package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.e;
import com.tencent.mm.ba.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.bottle.a.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.l;

public class BottleConversationUI extends MMActivity {
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private ListView pli;
    private a plj;
    private o.g plk = new o.g() {
        /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass10 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(22676);
            BottleConversationUI.a(BottleConversationUI.this, BottleConversationUI.this.talker);
            AppMethodBeat.o(22676);
        }
    };
    private String talker;
    private q tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BottleConversationUI() {
        AppMethodBeat.i(22677);
        AppMethodBeat.o(22677);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22678);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(22678);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c3f;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(22679);
        this.plj.ebf();
        super.onDestroy();
        AppMethodBeat.o(22679);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(22680);
        super.onResume();
        bg.aVF();
        c.aSN().add(this.plj);
        bg.aVF();
        c.aST().add(this.plj);
        this.plj.onNotifyChange(null, null);
        AppMethodBeat.o(22680);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(22681);
        bg.aVF();
        c.aSN().remove(this.plj);
        bg.aVF();
        c.aST().remove(this.plj);
        bg.aVF();
        ca Qo = c.aSQ().Qo(8);
        if (Qo != null && Qo.field_msgId > 0) {
            Log.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + Qo.field_createTime);
            bg.aVF();
            c.azQ().set(12306, Long.valueOf(Qo.field_createTime));
        }
        bg.aVF();
        az bjY = c.aST().bjY("floatbottle");
        if (bjY == null || Util.nullAsNil(bjY.field_username).length() <= 0) {
            Log.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
        } else {
            bjY.nt(0);
            bg.aVF();
            if (c.aST().a(bjY, bjY.field_username) == -1) {
                Log.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
            }
        }
        this.plj.onPause();
        super.onPause();
        AppMethodBeat.o(22681);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(22682);
        int aUc = z.aUc();
        bg.aVF();
        c.azQ().set(7, Integer.valueOf(aUc | 4096));
        bg.aVF();
        c.azQ().set(34, Integer.valueOf(z.aUl() & -65));
        this.pli = (ListView) findViewById(R.id.ir8);
        this.emptyTipTv = (TextView) findViewById(R.id.c30);
        this.emptyTipTv.setText(R.string.aks);
        this.plj = new a(this, new s.a() {
            /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(22664);
                BottleConversationUI bottleConversationUI = BottleConversationUI.this;
                String string = BottleConversationUI.this.getString(R.string.aky);
                int aTQ = com.tencent.mm.model.s.aTQ();
                if (aTQ <= 0) {
                    bottleConversationUI.setMMTitle(string);
                } else {
                    bottleConversationUI.setMMTitle(string + "(" + aTQ + ")");
                }
                if (BottleConversationUI.this.plj.getCount() <= 0) {
                    BottleConversationUI.this.emptyTipTv.setVisibility(0);
                    BottleConversationUI.this.pli.setVisibility(8);
                    AppMethodBeat.o(22664);
                    return;
                }
                BottleConversationUI.this.emptyTipTv.setVisibility(8);
                BottleConversationUI.this.pli.setVisibility(0);
                AppMethodBeat.o(22664);
            }
        });
        this.plj.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(22669);
                int positionForView = BottleConversationUI.this.pli.getPositionForView(view);
                AppMethodBeat.o(22669);
                return positionForView;
            }
        });
        this.plj.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(22670);
                BottleConversationUI.this.pli.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(22670);
            }
        });
        this.plj.a(new MMSlideDelView.f() {
            /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.f
            public final void cZ(Object obj) {
                AppMethodBeat.i(22671);
                if (obj == null) {
                    Log.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
                    AppMethodBeat.o(22671);
                    return;
                }
                BottleConversationUI.a(BottleConversationUI.this, obj.toString());
                AppMethodBeat.o(22671);
            }
        });
        this.pli.setAdapter((ListAdapter) this.plj);
        final l lVar = new l(this);
        this.pli.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass6 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(22672);
                if (i2 < BottleConversationUI.this.pli.getHeaderViewsCount()) {
                    Log.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
                    AppMethodBeat.o(22672);
                } else {
                    lVar.a(view, i2, j2, BottleConversationUI.this, BottleConversationUI.this.plk);
                    AppMethodBeat.o(22672);
                }
                return true;
            }
        });
        this.pli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass7 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(22673);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/bottle/ui/BottleConversationUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", ((az) BottleConversationUI.this.plj.getItem(i2)).field_username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.bottle.a.jRt.d(intent, BottleConversationUI.this);
                a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(22673);
            }
        });
        com.tencent.mm.plugin.bottle.a.jRu.WZ();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22674);
                BottleConversationUI.this.finish();
                AppMethodBeat.o(22674);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(22675);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(BottleConversationUI.this.pli);
                Object obj = new Object();
                a.a(obj, bl.axQ(), "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                a.a(obj, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22675);
            }
        });
        AppMethodBeat.o(22682);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(22683);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        this.talker = ((az) this.plj.getItem(adapterContextMenuInfo.position)).field_username;
        a aVar = this.plj;
        bg.aVF();
        contextMenu.setHeaderTitle(getString(R.string.ako, new Object[]{aVar.S(c.aSN().Kn(this.talker))}));
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.akp);
        AppMethodBeat.o(22683);
    }

    static /* synthetic */ void a(BottleConversationUI bottleConversationUI, final String str) {
        AppMethodBeat.i(22684);
        h.a((Context) bottleConversationUI, true, bottleConversationUI.getString(R.string.akq), "", bottleConversationUI.getString(R.string.akr), bottleConversationUI.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(22668);
                bg.aVF();
                ca aEw = c.aSQ().aEw(str);
                bg.aVF();
                c.aSM().d(new e(str, aEw.field_msgSvrId));
                bg.aVF();
                c.aSM().d(new g(str));
                com.tencent.mm.plugin.bottle.a.jRu.WZ();
                BottleConversationUI.this.isDeleteCancel = false;
                BottleConversationUI bottleConversationUI = BottleConversationUI.this;
                BottleConversationUI bottleConversationUI2 = BottleConversationUI.this;
                BottleConversationUI.this.getString(R.string.zb);
                bottleConversationUI.tipDialog = h.a((Context) bottleConversationUI2, BottleConversationUI.this.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass2.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(22665);
                        BottleConversationUI.this.isDeleteCancel = true;
                        AppMethodBeat.o(22665);
                    }
                });
                bp.a(str, new bp.a() {
                    /* class com.tencent.mm.plugin.bottle.ui.BottleConversationUI.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.model.bp.a
                    public final boolean amG() {
                        AppMethodBeat.i(22666);
                        boolean z = BottleConversationUI.this.isDeleteCancel;
                        AppMethodBeat.o(22666);
                        return z;
                    }

                    @Override // com.tencent.mm.model.bp.a
                    public final void amH() {
                        AppMethodBeat.i(22667);
                        if (BottleConversationUI.this.tipDialog != null) {
                            BottleConversationUI.this.tipDialog.dismiss();
                            BottleConversationUI.this.tipDialog = null;
                        }
                        AppMethodBeat.o(22667);
                    }
                });
                bg.aVF();
                c.aST().bjW(str);
                com.tencent.mm.plugin.bottle.a.b ckU = d.ckU();
                String ahl = com.tencent.mm.plugin.bottle.a.c.ahl(str);
                ckU.iFy.delete("bottleinfo1", "bottleid= ?", new String[]{String.valueOf(ahl)});
                com.tencent.mm.plugin.bottle.a.jRu.WZ();
                AppMethodBeat.o(22668);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(22684);
    }
}
