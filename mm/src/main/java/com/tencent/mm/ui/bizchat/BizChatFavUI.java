package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.a.t;
import com.tencent.mm.al.a.x;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.p;
import com.tencent.mm.contact.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s;

public class BizChatFavUI extends MMActivity implements p {
    private b.a PaP;
    private d.a PaQ;
    private c PaV;
    private TextView emptyTipTv;
    private boolean isCurrentActivity;
    private q nUq;
    private ListView pli;
    private o.g plk;
    private String ppO;
    private long ppv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33978);
        super.onCreate(bundle);
        this.ppO = getIntent().getStringExtra("Contact_User");
        Log.i("MicroMsg.BizChatFavUI", "[registerListener]");
        this.PaP = new b.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass1 */

            @Override // com.tencent.mm.al.a.b.a
            public final void a(b.a.C0248b bVar) {
                AppMethodBeat.i(33965);
                if (!(bVar == null || bVar.iPF == null || !BizChatFavUI.this.ppO.equals(bVar.iPF.field_brandUserName))) {
                    Log.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
                    if (BizChatFavUI.this.isCurrentActivity) {
                        BizChatFavUI.this.PaV.anp();
                    }
                }
                AppMethodBeat.o(33965);
            }
        };
        this.PaQ = new d.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass6 */

            @Override // com.tencent.mm.al.a.d.a
            public final void a(d.a.b bVar) {
                AppMethodBeat.i(33970);
                if (!(bVar == null || bVar.iPP == null)) {
                    Log.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
                    Log.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", Boolean.valueOf(ag.baj().bs(bVar.iPE).field_needToUpdate));
                    if (BizChatFavUI.this.isCurrentActivity) {
                        BizChatFavUI.this.PaV.anp();
                    }
                }
                AppMethodBeat.o(33970);
            }
        };
        ag.bak().a(this.PaP, getMainLooper());
        ag.baj().a(this.PaQ, getMainLooper());
        initView();
        ag.baq();
        g.aAg().hqi.a(new t(this.ppO), 0);
        AppMethodBeat.o(33978);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a40;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(33980);
        super.onResume();
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.ppO);
        if (Kn == null || !c.oR(Kn.field_type)) {
            finish();
            AppMethodBeat.o(33980);
            return;
        }
        setTitleMuteIconVisibility(8);
        this.isCurrentActivity = true;
        this.PaV.onNotifyChange(null, null);
        bg.getNotification().CY(this.ppO);
        AppMethodBeat.o(33980);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(33981);
        this.PaV.onPause();
        this.isCurrentActivity = false;
        bg.getNotification().CY("");
        super.onPause();
        AppMethodBeat.o(33981);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(33982);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        this.ppv = ((com.tencent.mm.al.a.c) this.PaV.getItem(adapterContextMenuInfo.position)).field_bizChatLocalId;
        contextMenu.add(adapterContextMenuInfo.position, 0, 1, R.string.ak2);
        AppMethodBeat.o(33982);
    }

    @Override // com.tencent.mm.al.p
    public final void a(int i2, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(33983);
        if (this.nUq != null) {
            this.nUq.dismiss();
        }
        AppMethodBeat.o(33983);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(33979);
        Log.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
        ag.bak().a(this.PaP);
        ag.baj().a(this.PaQ);
        this.PaV.ebf();
        super.onDestroy();
        AppMethodBeat.o(33979);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(33984);
        this.pli = (ListView) findViewById(R.id.ir8);
        this.emptyTipTv = (TextView) findViewById(R.id.c30);
        this.emptyTipTv.setText(R.string.ak1);
        this.pli.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass8 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(33972);
                com.tencent.mm.av.q.bcV().onScrollStateChanged(i2);
                AppMethodBeat.o(33972);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        this.PaV = new c(this, new s.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(33973);
                BizChatFavUI.this.setMMTitle(aa.getDisplayName(BizChatFavUI.this.ppO));
                if (BizChatFavUI.this.PaV.getCount() <= 0) {
                    BizChatFavUI.this.emptyTipTv.setVisibility(0);
                    BizChatFavUI.this.pli.setVisibility(8);
                    AppMethodBeat.o(33973);
                    return;
                }
                BizChatFavUI.this.emptyTipTv.setVisibility(8);
                BizChatFavUI.this.pli.setVisibility(0);
                AppMethodBeat.o(33973);
            }
        }, this.ppO);
        this.PaV.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(33974);
                int positionForView = BizChatFavUI.this.pli.getPositionForView(view);
                AppMethodBeat.o(33974);
                return positionForView;
            }
        });
        this.PaV.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(33975);
                BizChatFavUI.this.pli.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(33975);
            }
        });
        this.PaV.a(new MMSlideDelView.f() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.f
            public final void cZ(Object obj) {
                AppMethodBeat.i(33976);
                if (obj == null) {
                    Log.e("MicroMsg.BizChatFavUI", "onItemDel object null");
                    AppMethodBeat.o(33976);
                    return;
                }
                AppMethodBeat.o(33976);
            }
        });
        this.pli.setAdapter((ListAdapter) this.PaV);
        this.plk = new o.g() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass13 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(33977);
                switch (menuItem.getItemId()) {
                    case 0:
                        BizChatFavUI.a(BizChatFavUI.this, BizChatFavUI.this.ppv);
                        break;
                }
                AppMethodBeat.o(33977);
            }
        };
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.pli.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(33966);
                if (i2 < BizChatFavUI.this.pli.getHeaderViewsCount()) {
                    Log.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
                    AppMethodBeat.o(33966);
                } else {
                    lVar.a(view, i2, j2, BizChatFavUI.this, BizChatFavUI.this.plk);
                    AppMethodBeat.o(33966);
                }
                return true;
            }
        });
        this.pli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(33967);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/ui/bizchat/BizChatFavUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                BizChatFavUI.b(BizChatFavUI.this, ((com.tencent.mm.al.a.c) BizChatFavUI.this.PaV.getItem(i2)).field_bizChatLocalId);
                a.a(this, "com/tencent/mm/ui/bizchat/BizChatFavUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(33967);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33971);
                BizChatFavUI.this.finish();
                AppMethodBeat.o(33971);
                return true;
            }
        });
        AppMethodBeat.o(33984);
    }

    static /* synthetic */ void a(BizChatFavUI bizChatFavUI, long j2) {
        AppMethodBeat.i(33985);
        Log.i("MicroMsg.BizChatFavUI", "deleteFromFav");
        com.tencent.mm.al.a.c bs = ag.baj().bs(j2);
        bs.field_bitFlag &= -9;
        Log.i("MicroMsg.BizChatFavUI", "deleteFromFav:bitFlag %s", Integer.valueOf(bs.field_bitFlag));
        nt ntVar = new nt();
        ntVar.KTl = bs.field_bizChatServId;
        ntVar.KTn = bs.field_bitFlag;
        ag.baq();
        final x a2 = h.a(bs.field_brandUserName, ntVar, bizChatFavUI);
        bizChatFavUI.nUq = com.tencent.mm.ui.base.h.a((Context) bizChatFavUI, "", false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(33968);
                ag.baq();
                h.d(a2);
                AppMethodBeat.o(33968);
            }
        });
        AppMethodBeat.o(33985);
    }

    static /* synthetic */ void b(BizChatFavUI bizChatFavUI, long j2) {
        AppMethodBeat.i(33986);
        Intent intent = new Intent(bizChatFavUI, ChattingUI.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", bizChatFavUI.ppO);
        intent.putExtra("key_biz_chat_id", j2);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(bizChatFavUI, bl.axQ(), "com/tencent/mm/ui/bizchat/BizChatFavUI", "goToChattingUI", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        bizChatFavUI.startActivity((Intent) bl.pG(0));
        a.a(bizChatFavUI, "com/tencent/mm/ui/bizchat/BizChatFavUI", "goToChattingUI", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.bizchat.BizChatFavUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(33969);
                BizChatFavUI.this.finish();
                AppMethodBeat.o(33969);
            }
        }, 500);
        AppMethodBeat.o(33986);
    }
}
