package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI extends MMActivity implements i {
    private LinkedList<bfo> gYE = new LinkedList<>();
    private ProgressDialog gtM = null;
    private boolean kgC;
    private b khu;
    private ListView khv;
    private TextView khw;
    private LinkedList<ctl> khx = new LinkedList<>();
    private boolean khy = false;
    private int recommendType = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RecommendFriendUI() {
        AppMethodBeat.i(131295);
        AppMethodBeat.o(131295);
    }

    static /* synthetic */ void a(RecommendFriendUI recommendFriendUI, int i2) {
        AppMethodBeat.i(131305);
        recommendFriendUI.vm(i2);
        AppMethodBeat.o(131305);
    }

    static /* synthetic */ void d(RecommendFriendUI recommendFriendUI) {
        AppMethodBeat.i(131307);
        recommendFriendUI.goBack();
        AppMethodBeat.o(131307);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aw8;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(131296);
        super.onCreate(bundle);
        this.recommendType = Util.getInt(getIntent().getStringExtra("recommend_type"), 0);
        this.kgC = false;
        g.azz().a(c.CTRL_INDEX, this);
        initView();
        AppMethodBeat.o(131296);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(131297);
        this.khw = (TextView) findViewById(R.id.c39);
        if (this.recommendType == 1) {
            setMMTitle(R.string.gt6);
            this.khw.setText(R.string.gt_);
        } else if (this.recommendType == 2) {
            setMMTitle(R.string.gt5);
            this.khw.setText(R.string.gt9);
        } else {
            setMMTitle(R.string.gpf);
            this.khw.setText(R.string.gta);
        }
        this.khu = new b(getLayoutInflater());
        this.khv = (ListView) findViewById(R.id.e08);
        this.khv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                int i3;
                AppMethodBeat.i(131288);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (!RecommendFriendUI.this.kgC) {
                    RecommendFriendUI.this.khu.vl(i2);
                    if (RecommendFriendUI.this.khu.boI().length > 0) {
                        RecommendFriendUI.this.showOptionMenu(true);
                    } else {
                        RecommendFriendUI.this.showOptionMenu(false);
                    }
                } else {
                    RecommendFriendUI recommendFriendUI = RecommendFriendUI.this;
                    b bVar2 = RecommendFriendUI.this.khu;
                    if (!bVar2.kgC) {
                        i3 = 0;
                    } else {
                        i3 = bVar2.gYE.get(i2).Ltr;
                    }
                    RecommendFriendUI.a(recommendFriendUI, i3);
                }
                a.a(this, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(131288);
            }
        });
        this.khv.setAdapter((ListAdapter) this.khu);
        addTextOptionMenu(0, getString(R.string.e4i), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(131290);
                int length = RecommendFriendUI.this.khu.boI().length;
                h.a(RecommendFriendUI.this.getContext(), RecommendFriendUI.this.getContext().getResources().getQuantityString(R.plurals.s, length, Integer.valueOf(length)), RecommendFriendUI.this.getString(R.string.zb), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.AnonymousClass2.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(131289);
                        RecommendFriendUI.c(RecommendFriendUI.this);
                        AppMethodBeat.o(131289);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.AnonymousClass2.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(131290);
                return true;
            }
        });
        showOptionMenu(false);
        this.khy = true;
        final ac acVar = new ac(this.recommendType);
        g.azz().a(acVar, 0);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.e4l), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(131293);
                g.azz().a(acVar);
                RecommendFriendUI.this.finish();
                AppMethodBeat.o(131293);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(131291);
                RecommendFriendUI.d(RecommendFriendUI.this);
                AppMethodBeat.o(131291);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(131292);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(RecommendFriendUI.this.khv);
                Object obj = new Object();
                a.a(obj, bl.axQ(), "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                a.a(obj, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                a.a(this, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(131292);
            }
        });
        AppMethodBeat.o(131297);
    }

    private void goBack() {
        AppMethodBeat.i(131298);
        if (this.recommendType != 0) {
            finish();
            AppMethodBeat.o(131298);
        } else if (this.kgC || this.khy) {
            finish();
            AppMethodBeat.o(131298);
        } else {
            boK();
            AppMethodBeat.o(131298);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(131299);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(131299);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(131299);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(131300);
        g.azz().b(c.CTRL_INDEX, this);
        super.onDestroy();
        AppMethodBeat.o(131300);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(131301);
        Log.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 0 && i3 == 0 && qVar.getType() == 135) {
            this.khx = ((cti) ((ac) qVar).rr.iLL.iLR).xMV;
            this.gYE = ((cti) ((ac) qVar).rr.iLL.iLR).GroupList;
            this.khy = false;
            if (this.khx.size() <= 0) {
                boJ();
                AppMethodBeat.o(131301);
            } else if (this.recommendType == 0 && this.gYE.size() <= 0) {
                boJ();
                AppMethodBeat.o(131301);
            } else if (this.recommendType != 0) {
                vm(-1);
                AppMethodBeat.o(131301);
            } else {
                boK();
                AppMethodBeat.o(131301);
            }
        } else {
            boJ();
            AppMethodBeat.o(131301);
        }
    }

    private void boJ() {
        AppMethodBeat.i(131302);
        this.khw.setVisibility(0);
        this.khv.setVisibility(8);
        AppMethodBeat.o(131302);
    }

    private void vm(int i2) {
        String str;
        AppMethodBeat.i(131303);
        Log.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.khx.size());
        this.khu.a(this.khx, i2);
        this.khv.setAdapter((ListAdapter) this.khu);
        this.kgC = false;
        if (this.recommendType == 0) {
            String str2 = "";
            int i3 = 0;
            while (i3 < this.gYE.size()) {
                if (i2 == this.gYE.get(i3).Ltr) {
                    str = this.gYE.get(i3).LPg;
                } else {
                    str = str2;
                }
                i3++;
                str2 = str;
            }
            setMMTitle(str2);
        }
        this.khu.kgC = this.kgC;
        this.khu.notifyDataSetChanged();
        AppMethodBeat.o(131303);
    }

    private void boK() {
        AppMethodBeat.i(131304);
        Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", this.recommendType == 0);
        Log.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.gYE.size());
        this.khu.gYE = this.gYE;
        this.khv.setAdapter((ListAdapter) this.khu);
        showOptionMenu(false);
        this.kgC = true;
        setMMTitle(R.string.gpf);
        this.khu.kgC = this.kgC;
        this.khu.notifyDataSetChanged();
        AppMethodBeat.o(131304);
    }

    static /* synthetic */ void c(RecommendFriendUI recommendFriendUI) {
        AppMethodBeat.i(131306);
        for (int i2 = 0; i2 < recommendFriendUI.khu.boI().length; i2++) {
            cdl cdl = new cdl();
            cdl.UserName = Util.nullAsNil(recommendFriendUI.khu.boI()[i2]);
            cdl.Mjk = recommendFriendUI.recommendType;
            ((l) g.af(l.class)).aSM().d(new k.a(22, cdl));
            p pVar = new p();
            pVar.username = recommendFriendUI.khu.boI()[i2];
            pVar.keQ = recommendFriendUI.recommendType;
            pVar.dii = (int) Util.nowSecond();
            ((com.tencent.mm.plugin.account.friend.a.q) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getInviteFriendOpenStg()).b(pVar);
        }
        h.a(recommendFriendUI.getContext(), (int) R.string.e4j, (int) R.string.zb, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(131294);
                RecommendFriendUI.this.finish();
                AppMethodBeat.o(131294);
            }
        });
        AppMethodBeat.o(131306);
    }
}
