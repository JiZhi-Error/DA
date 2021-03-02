package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.b.a;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

public class BizTimeLineNewMsgUI extends MMActivity implements g {
    private int dEb = 0;
    private TextView emptyTipTv;
    private int fromScene = 1;
    private ListView krb;
    private int ppd = 0;
    private int ppe = 0;
    private a pqr;
    private long prZ = 0;
    View psf;
    private ProgressBar psg;
    private TextView psh;
    private View psi;
    View psj;
    View psk;
    private e psl;
    private z psm;
    private int psn = 0;
    private o.g pso = new o.g() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.AnonymousClass7 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(5922);
            switch (menuItem.getItemId()) {
                case 1:
                    if (BizTimeLineNewMsgUI.this.psm != null) {
                        ag.bap().MX(BizTimeLineNewMsgUI.this.psm.field_msgId);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(5922);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizTimeLineNewMsgUI() {
        AppMethodBeat.i(5923);
        AppMethodBeat.o(5923);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        List<z> o;
        AppMethodBeat.i(5924);
        super.onCreate(bundle);
        this.emptyTipTv = (TextView) $(R.id.c30);
        this.emptyTipTv.setText(R.string.ahu);
        setMMTitle(getString(R.string.aip));
        this.dEb = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
        this.prZ = System.currentTimeMillis() / 1000;
        this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
        if (this.fromScene == 1) {
            o = ae.o(ag.bap().iFy.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[]{"4"}, null, null, "createTime DESC "));
        } else {
            o = ae.o(ag.bap().iFy.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20"));
        }
        this.psl = new e(this, o, this.fromScene, this.dEb, this.prZ);
        this.krb = (ListView) $(R.id.a8l);
        ListView listView = this.krb;
        this.psf = getLayoutInflater().inflate(R.layout.jt, (ViewGroup) null);
        this.psg = (ProgressBar) this.psf.findViewById(R.id.a8i);
        this.psh = (TextView) this.psf.findViewById(R.id.a8j);
        this.psi = this.psf.findViewById(R.id.aar);
        this.psj = this.psf.findViewById(R.id.a8h);
        this.psk = this.psf.findViewById(R.id.a8q);
        listView.addFooterView(this.psf);
        this.krb.setAdapter((ListAdapter) this.psl);
        this.krb.setFooterDividersEnabled(false);
        this.krb.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.AnonymousClass2 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(5917);
                q.bcV().onScrollStateChanged(i2);
                AppMethodBeat.o(5917);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                Map<String, String> parseXml;
                AppMethodBeat.i(5918);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                z De = BizTimeLineNewMsgUI.this.psl.De(i2);
                if (De == null) {
                    Log.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(5918);
                    return;
                }
                String str = De.field_talker;
                int i3 = 0;
                if (De.gAw()) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", De.gAB().lDS);
                    intent.putExtra("geta8key_username", De.gAB().userName);
                    intent.putExtra("geta8key_scene", 56);
                    c.b(BizTimeLineNewMsgUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                } else if (com.tencent.mm.storage.ag.J(De)) {
                    AppCompatActivity context = BizTimeLineNewMsgUI.this.getContext();
                    p.h(context, "context");
                    if (De != null && !Util.isNullOrNil(De.field_content) && De.gAx() && (parseXml = XmlParser.parseXml(De.field_content, "msg", null)) != null) {
                        ag.d dVar = new ag.d(De, parseXml, context);
                        ag.e eVar = new ag.e(parseXml, De, context);
                        ag.f fVar = new ag.f(parseXml, De, context);
                        switch (Util.getInt(parseXml.get(".msg.appmsg.mmreader.notify_msg.act"), 0)) {
                            case 1:
                                dVar.invoke();
                                break;
                            case 2:
                                eVar.invoke();
                                break;
                            case 3:
                                fVar.invoke();
                                break;
                        }
                    }
                    str = com.tencent.mm.storage.ag.I(De);
                    i3 = com.tencent.mm.storage.ag.f(De);
                } else if (De.field_msgId > 0) {
                    if (((l) g.af(l.class)).eiy().Hb(De.field_msgId).field_msgId == 0) {
                        h.cD(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(R.string.ail));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(5918);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Chat_User", De.field_talker);
                    intent2.putExtra("finish_direct", true);
                    intent2.putExtra("from_global_search", true);
                    intent2.putExtra("msg_local_id", De.field_msgId);
                    intent2.putExtra("specific_chat_from_scene", 9);
                    intent2.putExtra("preChatTYPE", 13);
                    c.f(BizTimeLineNewMsgUI.this.getContext(), ".ui.chatting.ChattingUI", intent2);
                }
                com.tencent.mm.storage.ag.a(str, 1, i3, De.field_msgId, i2, BizTimeLineNewMsgUI.this.dEb, BizTimeLineNewMsgUI.this.fromScene - 1, (int) BizTimeLineNewMsgUI.this.prZ);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(5918);
            }
        });
        this.krb.setEmptyView(this.emptyTipTv);
        if (this.fromScene == 1 && this.psf != null) {
            this.psg.setVisibility(8);
            this.psh.setText(getString(R.string.aio));
            this.psf.setBackgroundResource(R.drawable.hs);
            this.psi.setVisibility(0);
            this.psf.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(5921);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    BizTimeLineNewMsgUI.this.psf.setOnClickListener(null);
                    BizTimeLineNewMsgUI.this.psl.psa = true;
                    BizTimeLineNewMsgUI.this.psl.Df(BizTimeLineNewMsgUI.this.psl.getCount() - 1);
                    BizTimeLineNewMsgUI.this.psg.setVisibility(0);
                    BizTimeLineNewMsgUI.this.psh.setText(BizTimeLineNewMsgUI.this.getString(R.string.aig));
                    BizTimeLineNewMsgUI.this.psf.setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(R.color.f8));
                    BizTimeLineNewMsgUI.this.psi.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(5921);
                }
            });
        }
        this.krb.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.AnonymousClass4 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(5919);
                switch (motionEvent.getAction()) {
                    case 0:
                        BizTimeLineNewMsgUI.this.ppd = (int) motionEvent.getRawX();
                        BizTimeLineNewMsgUI.this.ppe = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(5919);
                return false;
            }
        });
        this.pqr = new a(this);
        this.krb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(5920);
                BizTimeLineNewMsgUI.this.psm = BizTimeLineNewMsgUI.this.psl.De(i2);
                BizTimeLineNewMsgUI.this.psn = i2;
                BizTimeLineNewMsgUI.this.pqr.a(view, i2, j2, BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.pso, BizTimeLineNewMsgUI.this.ppd, BizTimeLineNewMsgUI.this.ppe);
                AppMethodBeat.o(5920);
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(5916);
                BizTimeLineNewMsgUI.this.finish();
                AppMethodBeat.o(5916);
                return true;
            }
        });
        AppMethodBeat.o(5924);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.k1;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.g
    public final void cmy() {
        AppMethodBeat.i(5925);
        if (this.psl != null) {
            this.psl.notifyDataSetChanged();
        }
        AppMethodBeat.o(5925);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(5926);
        super.onDestroy();
        com.tencent.mm.al.ag.bap().a(this.psl.pmx);
        ae bap = com.tencent.mm.al.ag.bap();
        bap.iFy.execSQL("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
        aa.a aVar = new aa.a();
        aVar.NQE = aa.b.UPDATE;
        bap.a(aVar);
        AppMethodBeat.o(5926);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(5927);
        super.onResume();
        AppMethodBeat.o(5927);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(5928);
        super.onPause();
        AppMethodBeat.o(5928);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(5929);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 1, 0, R.string.ahr);
        AppMethodBeat.o(5929);
    }
}
