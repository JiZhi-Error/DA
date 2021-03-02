package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizContactListUI extends MMActivity {
    private boolean cxw = false;
    private long enterTime;
    private long jmU = 0;
    private e poP;
    public String poQ;
    private EnterpriseBizContactListView poR;
    private View poS;
    private MMHandler poT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(EnterpriseBizContactListUI enterpriseBizContactListUI, List list) {
        AppMethodBeat.i(194861);
        enterpriseBizContactListUI.cv(list);
        AppMethodBeat.o(194861);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a3x;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(5687);
        super.onCreate(bundle);
        this.poQ = getIntent().getStringExtra("enterprise_biz_name");
        this.poP = new e(this, this.poQ);
        this.enterTime = System.currentTimeMillis() / 1000;
        if (this.poT == null) {
            this.poT = new MMHandler() {
                /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.AnonymousClass3 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(5686);
                    if (message != null && message.what == 1 && EnterpriseBizContactListUI.this != null && !EnterpriseBizContactListUI.this.isFinishing()) {
                        ag.bau().MN(EnterpriseBizContactListUI.this.poQ);
                        ag.bah();
                        List<String> MW = f.MW(EnterpriseBizContactListUI.this.poQ);
                        for (int i2 = 0; i2 < MW.size(); i2++) {
                            String str = MW.get(i2);
                            if (ab.IS(str) && (g.Nh(str) || g.DQ(str))) {
                                ag.bau().MN(str);
                            }
                        }
                    }
                    AppMethodBeat.o(5686);
                }
            };
        } else {
            this.poT.removeMessages(1);
        }
        this.poT.sendEmptyMessageDelayed(1, 500);
        AppMethodBeat.o(5687);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(5688);
        super.onResume();
        if (!ab.IS(this.poQ)) {
            Log.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", this.poQ);
            finish();
            AppMethodBeat.o(5688);
            return;
        }
        initView();
        if (!this.cxw) {
            int intExtra = getIntent().getIntExtra("enterprise_from_scene", 5);
            int i2 = -1;
            if (this.poR != null) {
                i2 = this.poR.getContactCount();
            }
            d MO = ag.bar().MO(this.poQ);
            int i3 = MO != null ? MO.field_qyUin : 0;
            long j2 = MO != null ? MO.field_wwCorpId : 0;
            long j3 = MO != null ? MO.field_wwUserVid : 0;
            h.INSTANCE.a(12892, this.poQ, Integer.valueOf(intExtra), Integer.valueOf(i2), "", 0, 0, 0, 0, 0, 0, Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3));
            Log.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.poQ, Integer.valueOf(intExtra), Integer.valueOf(i2), "", 0, 0, 0, 0, 0, 0, Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3));
            this.cxw = true;
        }
        AppMethodBeat.o(5688);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(5689);
        super.onPause();
        AppMethodBeat.o(5689);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        int i2;
        int i3;
        AppMethodBeat.i(5690);
        if (this.poR != null) {
            EnterpriseBizContactListView.release();
        }
        if (this.enterTime > 0 && this.jmU > 0) {
            long j2 = this.jmU - this.enterTime;
            d MO = ag.bar().MO(this.poQ);
            if (MO != null) {
                i2 = MO.field_qyUin;
            } else {
                i2 = 0;
            }
            if (MO != null) {
                i3 = MO.field_userUin;
            } else {
                i3 = 0;
            }
            h.INSTANCE.a(13465, "", Integer.valueOf(i2), 0, Integer.valueOf(i3), 2, Long.valueOf(j2));
            Log.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i2), 0, Integer.valueOf(i3), 2, Long.valueOf(j2));
        }
        super.onDestroy();
        AppMethodBeat.o(5690);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        c fJ;
        AppMethodBeat.i(5692);
        setMMTitle(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.poQ).arI());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(5682);
                EnterpriseBizContactListUI.this.hideVKB();
                EnterpriseBizContactListUI.this.finish();
                AppMethodBeat.o(5682);
                return true;
            }
        });
        if (!Util.isNullOrNil(this.poQ) && (fJ = g.fJ(this.poQ)) != null && fJ.UF()) {
            addIconOptionMenu(1, R.string.cz, R.raw.actionbar_icon_dark_add, this.poP.cmc());
        }
        this.poS = findViewById(R.id.c4_);
        this.poR = (EnterpriseBizContactListView) findViewById(R.id.c48);
        this.poR.setFatherBizName(this.poQ);
        this.poR.setExcludeBizChat(true);
        this.poR.clZ();
        this.poR.setEmptyListener(new EnterpriseBizContactListView.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a
            public final void Da(int i2) {
                int i3;
                int i4 = 8;
                AppMethodBeat.i(194856);
                if (EnterpriseBizContactListUI.this.poS != null) {
                    EnterpriseBizContactListView enterpriseBizContactListView = EnterpriseBizContactListUI.this.poR;
                    if (i2 > 0) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    enterpriseBizContactListView.setVisibility(i3);
                    View view = EnterpriseBizContactListUI.this.poS;
                    if (i2 <= 0) {
                        i4 = 0;
                    }
                    view.setVisibility(i4);
                }
                AppMethodBeat.o(194856);
            }
        });
        cv(g.Nk(this.poQ));
        ag.bar();
        e.a(this.poQ, new a(this));
        AppMethodBeat.o(5692);
    }

    private void cv(List<ewv> list) {
        AppMethodBeat.i(194860);
        LinkedList linkedList = list;
        if (list == null) {
            LinkedList linkedList2 = new LinkedList();
            ewv ewv = new ewv();
            ewv.type = 1;
            ewv.AOv = getString(R.string.bx_);
            ewv.qGB = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2p) + "/node/wework/images/icon_im.48490d44c5.png";
            linkedList2.add(ewv);
            linkedList = linkedList2;
        }
        ArrayList arrayList = new ArrayList();
        for (ewv ewv2 : linkedList) {
            if (ewv2.type != 2) {
                EnterpriseBizContactListView.b cmb = EnterpriseBizContactListView.b.cmb();
                cmb.ppj = true;
                cmb.ppk = ewv2;
                arrayList.add(cmb);
            }
        }
        this.poR.setFixedBrandServiceItem(arrayList);
        this.poR.refresh();
        AppMethodBeat.o(194860);
    }

    /* access modifiers changed from: package-private */
    public static class a implements i {
        private final WeakReference<EnterpriseBizContactListUI> nsR;

        public a(EnterpriseBizContactListUI enterpriseBizContactListUI) {
            AppMethodBeat.i(194858);
            this.nsR = new WeakReference<>(enterpriseBizContactListUI);
            AppMethodBeat.o(194858);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(194859);
            try {
                if (this.nsR.get() != null) {
                    final EnterpriseBizContactListUI enterpriseBizContactListUI = this.nsR.get();
                    if (enterpriseBizContactListUI.isFinishing()) {
                        AppMethodBeat.o(194859);
                        return;
                    } else {
                        final bjs bjs = (bjs) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        com.tencent.f.h.RTc.aV(new Runnable() {
                            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(194857);
                                try {
                                    EnterpriseBizContactListUI.a(enterpriseBizContactListUI, bjs.LTl.KUa);
                                    AppMethodBeat.o(194857);
                                } catch (Throwable th) {
                                    AppMethodBeat.o(194857);
                                }
                            }
                        });
                    }
                }
                AppMethodBeat.o(194859);
            } catch (Throwable th) {
                AppMethodBeat.o(194859);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(5693);
        super.onActivityResult(i2, i3, intent);
        if (this.poP == null || !this.poP.e(i2, i3, intent)) {
            AppMethodBeat.o(5693);
        } else {
            AppMethodBeat.o(5693);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(5691);
        this.jmU = System.currentTimeMillis() / 1000;
        super.finish();
        AppMethodBeat.o(5691);
    }
}
