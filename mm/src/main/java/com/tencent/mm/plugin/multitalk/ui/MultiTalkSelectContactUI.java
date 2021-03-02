package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.bh.e;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.multitalk.b.m;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.plugin.multitalk.ui.widget.l;
import com.tencent.mm.plugin.multitalk.ui.widget.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

@a(3)
public class MultiTalkSelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private IListener hXn = new IListener<mu>() {
        /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI.AnonymousClass3 */

        {
            AppMethodBeat.i(178898);
            this.__eventId = mu.class.getName().hashCode();
            AppMethodBeat.o(178898);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mu muVar) {
            AppMethodBeat.i(178899);
            mu muVar2 = muVar;
            if ((muVar2 instanceof mu) && muVar2.dSs.action == 0) {
                MultiTalkSelectContactUI.this.finish();
            }
            AppMethodBeat.o(178899);
            return false;
        }
    };
    private HashSet<String> jVU;
    private HashSet<String> jVV;
    boolean zQc = true;
    private ArrayList<String> zQd;
    private Activity zQe = this;
    private boolean zQf;
    private l zQg;
    private RecyclerView zQh;
    private boolean zQi = false;
    private d zQj;
    private View.OnClickListener zQk = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI.AnonymousClass2 */

        {
            AppMethodBeat.i(161205);
            AppMethodBeat.o(161205);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178897);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view instanceof ImageView) {
                String str = (String) view.getTag();
                p gUP = MultiTalkSelectContactUI.this.gUP();
                if (z.aTY().equals(str)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(178897);
                    return;
                }
                MultiTalkSelectContactUI.f(MultiTalkSelectContactUI.this);
                if (MultiTalkSelectContactUI.this.jVV.contains(str)) {
                    if (MultiTalkSelectContactUI.this.zQf) {
                        MultiTalkSelectContactUI.this.zQg.KK(str);
                    }
                    MultiTalkSelectContactUI.this.jVV.remove(str);
                    MultiTalkSelectContactUI.this.zQd.remove(str);
                }
                ((q) MultiTalkSelectContactUI.this.zQh.getAdapter()).b(MultiTalkSelectContactUI.this.zQd, MultiTalkSelectContactUI.this.zQk);
                RecyclerView recyclerView = MultiTalkSelectContactUI.this.zQh;
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(MultiTalkSelectContactUI.this.zQh.getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
                gUP.notifyDataSetChanged();
                MultiTalkSelectContactUI.j(MultiTalkSelectContactUI.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178897);
        }
    };

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void f(MultiTalkSelectContactUI multiTalkSelectContactUI) {
        AppMethodBeat.i(178903);
        multiTalkSelectContactUI.gUW();
        AppMethodBeat.o(178903);
    }

    static /* synthetic */ void j(MultiTalkSelectContactUI multiTalkSelectContactUI) {
        AppMethodBeat.i(178904);
        multiTalkSelectContactUI.ani();
        AppMethodBeat.o(178904);
    }

    public MultiTalkSelectContactUI() {
        AppMethodBeat.i(114694);
        AppMethodBeat.o(114694);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(114695);
        super.amZ();
        this.zQf = getIntent().getBooleanExtra("key_need_gallery", false);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!ab.Eq(this.chatroomName)) {
            finish();
        }
        this.jVV = new HashSet<>();
        this.jVU = new HashSet<>();
        this.zQd = new ArrayList<>();
        AppMethodBeat.o(114695);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        boolean z;
        AppMethodBeat.i(114696);
        super.initView();
        this.zQj = new d(this);
        if (!this.zQj.zRI && com.tencent.mm.plugin.multitalk.d.b.epM()) {
            d dVar = this.zQj;
            ListView listView = this.Bvb;
            dVar.jBN = ListView.inflate(dVar.mContext, R.layout.bco, null);
            dVar.jBN.getViewTreeObserver().addOnDrawListener(dVar.zRO);
            dVar.jBN.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.d.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(164059);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MeetingLinkFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.MeetingLinkFooter", "meeting footer has been click and run it");
                    com.tencent.mm.plugin.multitalk.d.b.bi(d.this.mContext, "list");
                    com.tencent.mm.plugin.multitalk.d.c.a(com.tencent.mm.plugin.multitalk.d.b.epW(), 1, 0, 0, 0, 0, 0, 0, 0, "", 0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MeetingLinkFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(164059);
                }
            });
            dVar.zRJ = (WxImageView) dVar.jBN.findViewById(R.id.fdy);
            dVar.zRL = (TextView) dVar.jBN.findViewById(R.id.fc4);
            dVar.zRK = (TextView) dVar.jBN.findViewById(R.id.fc5);
            dVar.zRM = (WxImageView) dVar.jBN.findViewById(R.id.fjt);
            dVar.zRM.setBackground(ar.m(MMApplicationContext.getContext(), R.raw.icons_filled_arrow, -1));
            if (!Util.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.epT()) && !Util.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.epU())) {
                dVar.zRK.setText(com.tencent.mm.plugin.multitalk.d.b.epT());
                dVar.zRL.setText(com.tencent.mm.plugin.multitalk.d.b.epU());
                z = true;
            } else if (com.tencent.mm.plugin.multitalk.d.b.epN()) {
                dVar.zRK.setText(R.string.f7j);
                dVar.zRL.setText(R.string.ez_);
                z = true;
            } else if (com.tencent.mm.plugin.multitalk.d.b.epO()) {
                dVar.zRK.setText(R.string.f7k);
                dVar.zRL.setText(R.string.j3u);
                z = true;
            } else {
                z = false;
            }
            if (!Util.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.getIconUrl())) {
                com.tencent.mm.av.q.bcV().a(com.tencent.mm.plugin.multitalk.d.b.getIconUrl(), (ImageView) null, new h() {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.d.AnonymousClass3 */

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view) {
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                        return null;
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view, final com.tencent.mm.av.a.d.b bVar) {
                        AppMethodBeat.i(164061);
                        if (bVar.status == 0 && bVar.bitmap != null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.multitalk.ui.widget.d.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(164060);
                                    d.this.zRJ.setBackgroundDrawable(new BitmapDrawable(bVar.bitmap));
                                    AppMethodBeat.o(164060);
                                }
                            });
                        }
                        AppMethodBeat.o(164061);
                    }
                });
            } else if (com.tencent.mm.plugin.multitalk.d.b.epN()) {
                dVar.zRJ.setBackground(ar.m(MMApplicationContext.getContext(), R.raw.icons_outlined_tencentmeeting_logo, -1));
            } else if (com.tencent.mm.plugin.multitalk.d.b.epO()) {
                dVar.zRJ.setBackground(ar.m(MMApplicationContext.getContext(), R.raw.icons_outlined_wxwork_logo, -1));
            }
            listView.removeFooterView(dVar.jBN);
            if (z) {
                dVar.zRI = true;
                listView.addFooterView(dVar.jBN);
            } else {
                dVar.zRI = true;
                Log.e("MicroMsg.MeetingLinkFooter", "not get wording, not show footer");
            }
        }
        setActionbarColor(getResources().getColor(R.color.ko));
        hideActionbarLine();
        getController().setNavigationbarColor(Color.parseColor("#232323"));
        this.zQg = new l(this);
        String string = getString(R.string.f6q, new Object[]{Integer.valueOf(this.jVU.size() + this.jVV.size())});
        if (this.zQf) {
            str = getString(R.string.f75, new Object[]{Integer.valueOf(this.jVU.size() + this.jVV.size())});
        } else {
            str = string;
        }
        addTextOptionMenu(1, str, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(114692);
                if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
                    e.a(MultiTalkSelectContactUI.this, R.string.i3o, null);
                } else {
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(MultiTalkSelectContactUI.this.jVV);
                    linkedList.add(z.aTY());
                    String listToString = Util.listToString(linkedList, ",");
                    if (MultiTalkSelectContactUI.this.zQf) {
                        com.tencent.mm.plugin.multitalk.model.p.a(MultiTalkSelectContactUI.this.jVV.size(), MultiTalkSelectContactUI.this.zQi, 1, "", MultiTalkSelectContactUI.this.zQg.zTH);
                        ac.eom().c(MultiTalkSelectContactUI.this, listToString, MultiTalkSelectContactUI.this.chatroomName);
                    } else {
                        com.tencent.mm.plugin.multitalk.model.p.a(MultiTalkSelectContactUI.this.jVV.size(), MultiTalkSelectContactUI.this.zQi, 2, v.enW(), 0);
                        MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", listToString));
                        MultiTalkSelectContactUI.this.zQc = false;
                        MultiTalkSelectContactUI.this.finish();
                    }
                }
                MultiTalkSelectContactUI.this.hideVKB();
                AppMethodBeat.o(114692);
                return true;
            }
        }, null, t.b.GREEN);
        ani();
        this.zoy.setBackgroundResource(R.color.l0);
        this.zoy.getInputText().setTextColor(-1);
        hYJ();
        m.czc();
        AppMethodBeat.o(114696);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(114697);
        super.onCreate(bundle);
        AppMethodBeat.o(114697);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(178900);
        super.onStart();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!Util.isNullOrNil(stringExtra)) {
            this.jVU.addAll(Util.stringsToList(stringExtra.split(",")));
        }
        this.jVU.add(z.aTY());
        this.zQd.addAll(this.jVU);
        if (this.zQf) {
            this.zQg.aGw(z.aTY());
        }
        this.zQh = (RecyclerView) findViewById(R.id.hsr);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        this.zQh.setLayoutManager(linearLayoutManager);
        this.zQh.setAdapter(new q(this));
        ((q) this.zQh.getAdapter()).b(this.zQd, this.zQk);
        EventCenter.instance.addListener(this.hXn);
        AppMethodBeat.o(178900);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(114698);
        d dVar = this.zQj;
        if (!(dVar.jBN == null || dVar.zRO == null)) {
            dVar.jBN.getViewTreeObserver().removeOnDrawListener(dVar.zRO);
            dVar.mContext = null;
        }
        EventCenter.instance.removeListener(this.hXn);
        super.onDestroy();
        AppMethodBeat.o(114698);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bdd;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(114699);
        String stringExtra = getIntent().getStringExtra("titile");
        AppMethodBeat.o(114699);
        return stringExtra;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final com.tencent.mm.ui.contact.q bmC() {
        AppMethodBeat.i(114700);
        a aVar = new a(this, this.chatroomName);
        AppMethodBeat.o(114700);
        return aVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(114701);
        b bVar = new b(this, this.chatroomName);
        AppMethodBeat.o(114701);
        return bVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(239454);
        p gUP = gUP();
        com.tencent.mm.ui.contact.a.a anH = gUP.getItem(i2 - getContentLV().getHeaderViewsCount());
        if (anH == null) {
            AppMethodBeat.o(239454);
        } else if (anH.contact == null) {
            AppMethodBeat.o(239454);
        } else {
            Log.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", anH.contact.field_username);
            String str = anH.contact.field_username;
            if (z.aTY().equals(str)) {
                AppMethodBeat.o(239454);
                return;
            }
            gUW();
            if (this.jVU.contains(str)) {
                AppMethodBeat.o(239454);
                return;
            }
            if (this.jVV.contains(str)) {
                if (this.zQf) {
                    this.zQg.KK(str);
                }
                this.jVV.remove(str);
                int indexOf = this.zQd.indexOf(str);
                this.zQd.remove(str);
                q qVar = (q) this.zQh.getAdapter();
                ArrayList<String> arrayList = this.zQd;
                View.OnClickListener onClickListener = this.zQk;
                kotlin.g.b.p.h(arrayList, "userNameList");
                kotlin.g.b.p.h(onClickListener, "onClickListener");
                qVar.uae.clear();
                qVar.uae.add(z.aTY());
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    String str2 = arrayList.get(i3);
                    kotlin.g.b.p.g(str2, "userNameList[i]");
                    if (!qVar.aGC(str2) && (!kotlin.g.b.p.j(arrayList.get(i3), z.aTY()))) {
                        qVar.uae.add(arrayList.get(i3));
                    }
                }
                qVar.zVf = onClickListener;
                if (qVar.uae.size() < 5) {
                    for (int i4 = 0; i4 < 5; i4++) {
                        qVar.ci(qVar.wqJ + i4);
                    }
                }
                qVar.ck(qVar.wqJ + indexOf);
            } else if (this.jVU.size() + this.jVV.size() == com.tencent.mm.plugin.multitalk.d.e.epZ()) {
                this.zQi = true;
                com.tencent.mm.plugin.multitalk.d.b.gG(this);
                AppMethodBeat.o(239454);
                return;
            } else {
                if (this.zQf) {
                    this.zQg.aGw(str);
                }
                this.jVV.add(str);
                this.zQd.add(str);
                q qVar2 = (q) this.zQh.getAdapter();
                ArrayList<String> arrayList2 = this.zQd;
                View.OnClickListener onClickListener2 = this.zQk;
                kotlin.g.b.p.h(arrayList2, "userNameList");
                kotlin.g.b.p.h(onClickListener2, "onClickListener");
                qVar2.uae.clear();
                qVar2.uae.add(z.aTY());
                int size2 = arrayList2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    String str3 = arrayList2.get(i5);
                    kotlin.g.b.p.g(str3, "userNameList[i]");
                    if (!qVar2.aGC(str3) && (!kotlin.g.b.p.j(arrayList2.get(i5), z.aTY()))) {
                        qVar2.uae.add(arrayList2.get(i5));
                    }
                }
                qVar2.zVf = onClickListener2;
                if (qVar2.uae.size() < 5) {
                    for (int i6 = 0; i6 < 5; i6++) {
                        qVar2.ci(qVar2.wqJ + i6);
                    }
                }
                qVar2.cj(qVar2.getItemCount());
            }
            RecyclerView recyclerView = this.zQh;
            com.tencent.mm.hellhoundlib.b.a a2 = c.a(this.zQh.getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
            gUP.notifyDataSetChanged();
            ani();
            AppMethodBeat.o(239454);
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public void egJ() {
        AppMethodBeat.i(114703);
        super.egJ();
        hideVKB();
        if (this.zQc) {
            f.e(false, true, true);
        }
        AppMethodBeat.o(114703);
    }

    private void ani() {
        AppMethodBeat.i(114706);
        if (this.jVV.size() > 0) {
            updateOptionMenuText(1, getString(R.string.f6q, new Object[]{Integer.valueOf(this.jVU.size() + this.jVV.size())}));
            enableOptionMenu(1, true);
            AppMethodBeat.o(114706);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(114706);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(178901);
        super.onPause();
        AppMethodBeat.o(178901);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(178902);
        super.onResume();
        f.e(true, false, true);
        AppMethodBeat.o(178902);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(114704);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(114704);
            return false;
        }
        boolean contains = this.jVV.contains(aVar.contact.field_username);
        AppMethodBeat.o(114704);
        return contains;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(114705);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(114705);
            return false;
        }
        boolean contains = this.jVU.contains(aVar.contact.field_username);
        AppMethodBeat.o(114705);
        return contains;
    }
}
