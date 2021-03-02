package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizEntranceListUI extends MMActivity {
    private String iNV;
    private ListView krb;
    private e poP;
    private b ppE;
    private a ppf = new a(new a.AbstractC0867a() {
        /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.a.AbstractC0867a
        public final Context getContext() {
            return EnterpriseBizEntranceListUI.this;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.a.AbstractC0867a
        public final String cma() {
            AppMethodBeat.i(194882);
            String str = EnterpriseBizEntranceListUI.this.iNV;
            AppMethodBeat.o(194882);
            return str;
        }
    });
    private AdapterView.OnItemClickListener ppw;
    private int scene;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EnterpriseBizEntranceListUI() {
        AppMethodBeat.i(194903);
        AppMethodBeat.o(194903);
    }

    static /* synthetic */ void a(EnterpriseBizEntranceListUI enterpriseBizEntranceListUI, List list) {
        AppMethodBeat.i(194911);
        enterpriseBizEntranceListUI.cv(list);
        AppMethodBeat.o(194911);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(194904);
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("enterprise_scene", 2);
        this.iNV = getIntent().getStringExtra("enterprise_biz_name");
        this.poP = new e(this, this.iNV);
        Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "bizName = %s", this.iNV);
        initView();
        ag.bah().add(this.ppE);
        ((l) g.af(l.class)).aSN().add(this.ppE);
        AppMethodBeat.o(194904);
    }

    /* access modifiers changed from: package-private */
    public static class c implements i {
        private final WeakReference<EnterpriseBizEntranceListUI> nsR;

        public c(EnterpriseBizEntranceListUI enterpriseBizEntranceListUI) {
            AppMethodBeat.i(194898);
            this.nsR = new WeakReference<>(enterpriseBizEntranceListUI);
            AppMethodBeat.o(194898);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(194899);
            try {
                if (this.nsR.get() != null) {
                    final EnterpriseBizEntranceListUI enterpriseBizEntranceListUI = this.nsR.get();
                    if (enterpriseBizEntranceListUI.isFinishing()) {
                        AppMethodBeat.o(194899);
                        return;
                    } else {
                        final bjs bjs = (bjs) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        EnterpriseBizEntranceListUI.access$200(new Runnable() {
                            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.c.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(194897);
                                try {
                                    EnterpriseBizEntranceListUI.a(enterpriseBizEntranceListUI, bjs.LTl.KUa);
                                    enterpriseBizEntranceListUI.ppE.notifyDataSetChanged();
                                    AppMethodBeat.o(194897);
                                } catch (Throwable th) {
                                    AppMethodBeat.o(194897);
                                }
                            }
                        });
                    }
                }
                AppMethodBeat.o(194899);
            } catch (Throwable th) {
                AppMethodBeat.o(194899);
            }
        }
    }

    private void cv(List<ewv> list) {
        AppMethodBeat.i(194905);
        if (this.ppE == null) {
            AppMethodBeat.o(194905);
        } else if (list == null || list.isEmpty()) {
            b bVar = this.ppE;
            LinkedList<d> linkedList = new LinkedList<>();
            d dVar = new d();
            dVar.ppM = R.raw.enterprise_chat_entry_avatar;
            dVar.ppL.type = 1;
            dVar.ppL.AOv = bVar.context.getString(R.string.bx_);
            dVar.ppL.qGB = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2p) + "/node/wework/images/icon_im.48490d44c5.png";
            linkedList.add(dVar);
            d dVar2 = new d();
            dVar2.ppL.AOv = bVar.context.getString(R.string.bxs);
            dVar2.ppL.qGB = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2p) + "/node/wework/images/icon_workspace.cb133ed72e.png";
            dVar2.ppL.type = 2;
            linkedList.add(dVar2);
            bVar.ppH = linkedList;
            AppMethodBeat.o(194905);
        } else {
            this.ppE.cx(list);
            AppMethodBeat.o(194905);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(194906);
        this.krb = (ListView) findViewById(R.id.c49);
        if (this.ppE == null) {
            this.ppE = new b(this);
            cv(com.tencent.mm.al.g.Nk(this.iNV));
            ag.bar();
            e.a(this.iNV, new c(this));
            this.ppw = new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.AnonymousClass1 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(194879);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "onItemClick position = %s", Integer.valueOf(i2));
                    EnterpriseBizEntranceListUI.a(EnterpriseBizEntranceListUI.this, i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(194879);
                }
            };
        }
        Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "count = %s", Integer.valueOf(this.ppE.getCount()));
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.iNV);
        setMMTitle(Kn.arI());
        if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type) || this.ppE.getCount() <= 0) {
            this.krb.setVisibility(8);
            TextView textView = (TextView) findViewById(R.id.c4_);
            textView.setText(R.string.bxn);
            textView.setVisibility(0);
        } else {
            this.krb.setVisibility(0);
            this.krb.setAdapter((ListAdapter) this.ppE);
            this.krb.setOnItemClickListener(this.ppw);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(194880);
                EnterpriseBizEntranceListUI.this.hideVKB();
                EnterpriseBizEntranceListUI.this.finish();
                AppMethodBeat.o(194880);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(194881);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(EnterpriseBizEntranceListUI.this.krb);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(194881);
            }
        });
        addIconOptionMenu(1, R.string.cz, R.raw.actionbar_icon_dark_add, this.poP.cmc());
        AppMethodBeat.o(194906);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(194907);
        super.onActivityResult(i2, i3, intent);
        if (this.poP.e(i2, i3, intent)) {
            AppMethodBeat.o(194907);
        } else {
            AppMethodBeat.o(194907);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(194908);
        super.onResume();
        if (!ab.IS(this.iNV)) {
            Log.e("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "%s !isContact", this.iNV);
            finish();
            AppMethodBeat.o(194908);
            return;
        }
        AppMethodBeat.o(194908);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(194909);
        super.onPause();
        AppMethodBeat.o(194909);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(194910);
        ag.bah().remove(this.ppE);
        ((l) g.af(l.class)).aSN().remove(this.ppE);
        super.onDestroy();
        AppMethodBeat.o(194910);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a3w;
    }

    public static class a {
        private AbstractC0867a ppG;

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI$a$a  reason: collision with other inner class name */
        public interface AbstractC0867a {
            String cma();

            Context getContext();
        }

        public a(AbstractC0867a aVar) {
            this.ppG = aVar;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void a(ewv ewv) {
            AppMethodBeat.i(194883);
            switch (ewv.type) {
                case 1:
                    cmd();
                    AppMethodBeat.o(194883);
                    return;
                case 2:
                    cme();
                    AppMethodBeat.o(194883);
                    return;
                case 3:
                    ahM(ewv.pTL);
                    break;
            }
            AppMethodBeat.o(194883);
        }

        private void cmd() {
            AppMethodBeat.i(194884);
            try {
                Intent intent = new Intent();
                intent.setClassName(this.ppG.getContext(), "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
                intent.putExtra("enterprise_biz_name", this.ppG.cma());
                intent.putExtra("enterprise_biz_display_name", aa.getDisplayName(this.ppG.cma()));
                Context context = this.ppG.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(194884);
            } catch (Throwable th) {
                Log.w("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "jumpToMsgListUI fail, father=%s, error msg: %s", this.ppG.cma(), th.getMessage());
                AppMethodBeat.o(194884);
            }
        }

        private void cme() {
            AppMethodBeat.i(194885);
            Intent intent = new Intent();
            intent.putExtra("enterprise_from_scene", 1);
            intent.putExtra("enterprise_biz_name", this.ppG.cma());
            com.tencent.mm.br.c.b(this.ppG.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", intent);
            AppMethodBeat.o(194885);
        }

        private void ahM(String str) {
            AppMethodBeat.i(194886);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent.addFlags(67108864);
            com.tencent.mm.br.c.b(this.ppG.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(194886);
        }
    }

    public static class d {
        private static float ppN = 0.1f;
        final ewv ppL;
        int ppM;

        d() {
            AppMethodBeat.i(194900);
            this.ppM = 0;
            this.ppL = new ewv();
            AppMethodBeat.o(194900);
        }

        d(ewv ewv) {
            this.ppM = 0;
            this.ppL = ewv;
        }

        public static com.tencent.mm.av.a.a.c S(Context context, int i2) {
            AppMethodBeat.i(194901);
            c.a aVar = new c.a();
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.jbq = i2;
            aVar.iaT = true;
            if (com.tencent.mm.cb.a.jk(context)) {
                aVar.jbx = ppN * ((float) com.tencent.mm.cb.a.aH(context, R.dimen.f3065j));
            } else {
                aVar.jbx = ppN * ((float) com.tencent.mm.cb.a.aH(context, R.dimen.ij));
            }
            com.tencent.mm.av.a.a.c bdv = aVar.bdv();
            AppMethodBeat.o(194901);
            return bdv;
        }

        static /* synthetic */ com.tencent.mm.av.a.a.c a(d dVar, Context context) {
            int i2;
            AppMethodBeat.i(194902);
            if (dVar.ppM == 0) {
                i2 = R.raw.default_avatar;
            } else {
                i2 = dVar.ppM;
            }
            com.tencent.mm.av.a.a.c S = S(context, i2);
            AppMethodBeat.o(194902);
            return S;
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange {
        final Context context;
        LinkedList<d> ppH;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(194896);
            d Db = Db(i2);
            AppMethodBeat.o(194896);
            return Db;
        }

        public b(Context context2) {
            this.context = context2;
        }

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(194889);
            Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange1 %d", Integer.valueOf(i2));
            cmf();
            AppMethodBeat.o(194889);
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(194890);
            Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange2 %s", str);
            cmf();
            AppMethodBeat.o(194890);
        }

        private void cmf() {
            AppMethodBeat.i(194891);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(194887);
                    TextView textView = (TextView) EnterpriseBizEntranceListUI.this.findViewById(R.id.c4_);
                    if (!(EnterpriseBizEntranceListUI.this.krb == null || textView == null)) {
                        as Kn = ((l) g.af(l.class)).aSN().Kn(EnterpriseBizEntranceListUI.this.iNV);
                        if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                            EnterpriseBizEntranceListUI.this.krb.setVisibility(8);
                            textView.setVisibility(0);
                        } else if (EnterpriseBizEntranceListUI.this.ppE.getCount() <= 0) {
                            EnterpriseBizEntranceListUI.this.krb.setVisibility(8);
                            textView.setVisibility(0);
                        } else {
                            EnterpriseBizEntranceListUI.this.krb.setVisibility(0);
                            textView.setVisibility(8);
                            EnterpriseBizEntranceListUI.this.krb.setAdapter((ListAdapter) EnterpriseBizEntranceListUI.this.ppE);
                            EnterpriseBizEntranceListUI.this.krb.setOnItemClickListener(EnterpriseBizEntranceListUI.this.ppw);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    AppMethodBeat.o(194887);
                }
            });
            AppMethodBeat.o(194891);
        }

        public final void cx(List<ewv> list) {
            AppMethodBeat.i(194892);
            LinkedList<d> linkedList = new LinkedList<>();
            for (ewv ewv : list) {
                linkedList.add(new d(ewv));
            }
            this.ppH = linkedList;
            AppMethodBeat.o(194892);
        }

        public final int getCount() {
            AppMethodBeat.i(194893);
            int size = this.ppH.size();
            AppMethodBeat.o(194893);
            return size;
        }

        public final d Db(int i2) {
            AppMethodBeat.i(194894);
            d dVar = this.ppH.get(i2);
            AppMethodBeat.o(194894);
            return dVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(194895);
            Context context2 = viewGroup.getContext();
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(context2, R.layout.a3u, null);
                aVar2.keC = (ImageView) view.findViewById(R.id.fu3);
                aVar2.kcS = (TextView) view.findViewById(R.id.fu9);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            d Db = Db(i2);
            if (Db == null) {
                aVar.clear();
                AppMethodBeat.o(194895);
            } else {
                aVar.clear();
                int paddingBottom = view.getPaddingBottom();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingLeft = view.getPaddingLeft();
                view.setBackgroundDrawable(com.tencent.mm.cb.a.l(context2, R.drawable.qa));
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                aVar.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context2, Util.nullAsNil(Db.ppL.AOv), aVar.kcS.getTextSize()));
                aVar.kcS.setVisibility(0);
                aVar.keC.setVisibility(0);
                com.tencent.mm.av.q.bcV().a(Db.ppL.qGB, aVar.keC, d.a(Db, context2));
                AppMethodBeat.o(194895);
            }
            return view;
        }

        class a {
            TextView kcS;
            ImageView keC;

            a() {
            }

            public final void clear() {
                AppMethodBeat.i(194888);
                if (this.keC != null) {
                    this.keC.setImageDrawable(null);
                    this.keC.setVisibility(8);
                }
                if (this.kcS != null) {
                    this.kcS.setText("");
                    this.kcS.setVisibility(8);
                }
                AppMethodBeat.o(194888);
            }
        }
    }

    static /* synthetic */ void access$200(Runnable runnable) {
        AppMethodBeat.i(194912);
        try {
            h.RTc.aV(runnable);
            AppMethodBeat.o(194912);
        } catch (NullPointerException e2) {
            AppMethodBeat.o(194912);
        }
    }

    static /* synthetic */ void a(EnterpriseBizEntranceListUI enterpriseBizEntranceListUI, int i2) {
        AppMethodBeat.i(194913);
        d Db = enterpriseBizEntranceListUI.ppE.Db(i2);
        if (Db == null) {
            Log.e("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "item is null.");
            AppMethodBeat.o(194913);
            return;
        }
        enterpriseBizEntranceListUI.ppf.a(Db.ppL);
        AppMethodBeat.o(194913);
    }
}
