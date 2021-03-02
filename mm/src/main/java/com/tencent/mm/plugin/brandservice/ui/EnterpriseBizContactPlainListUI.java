package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.al.f;
import com.tencent.mm.contact.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.s;
import java.util.HashMap;

public class EnterpriseBizContactPlainListUI extends MMActivity {
    private String iNV;
    private ListView krb;
    private a ppu;
    private long ppv;
    private AdapterView.OnItemClickListener ppw;
    private int scene;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(5735);
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("enterprise_scene", 2);
        this.iNV = getIntent().getStringExtra("enterprise_biz_name");
        this.ppv = getIntent().getLongExtra("biz_chat_chat_id", -1);
        Log.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", this.iNV);
        initView();
        ag.bah().add(this.ppu);
        ((l) g.af(l.class)).aSN().add(this.ppu);
        AppMethodBeat.o(5735);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(5736);
        this.krb = (ListView) findViewById(R.id.c49);
        if (this.ppu == null) {
            this.ppu = new a(this);
            this.ppw = new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.AnonymousClass1 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(5719);
                    b bVar = new b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    Log.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", Integer.valueOf(i2));
                    EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this, i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(5719);
                }
            };
        }
        Log.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", Integer.valueOf(this.ppu.getCount()));
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.iNV);
        if (this.scene == 2) {
            setMMTitle(R.string.bxg);
        } else if (Kn != null) {
            setMMTitle(Kn.arI());
        }
        if (Kn == null || !c.oR(Kn.field_type) || this.ppu.getCount() <= 0) {
            this.krb.setVisibility(8);
            TextView textView = (TextView) findViewById(R.id.c4_);
            textView.setText(R.string.bxn);
            textView.setVisibility(0);
        } else {
            this.krb.setVisibility(0);
            this.krb.setAdapter((ListAdapter) this.ppu);
            this.krb.setOnItemClickListener(this.ppw);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(5720);
                EnterpriseBizContactPlainListUI.this.hideVKB();
                EnterpriseBizContactPlainListUI.this.finish();
                AppMethodBeat.o(5720);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(5721);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(EnterpriseBizContactPlainListUI.this.krb);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(5721);
            }
        });
        AppMethodBeat.o(5736);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(5737);
        super.onResume();
        if (!ab.IS(this.iNV)) {
            Log.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", this.iNV);
            finish();
            AppMethodBeat.o(5737);
            return;
        }
        AppMethodBeat.o(5737);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(5738);
        super.onPause();
        AppMethodBeat.o(5738);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(5739);
        ag.bah().remove(this.ppu);
        ((l) g.af(l.class)).aSN().remove(this.ppu);
        this.ppu.ebf();
        a aVar = this.ppu;
        if (aVar.kex != null) {
            aVar.kex.detach();
            aVar.kex = null;
        }
        super.onDestroy();
        AppMethodBeat.o(5739);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a3w;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(5740);
        super.onActivityResult(i2, i3, intent);
        if (this.scene == 4) {
            finish();
        }
        AppMethodBeat.o(5740);
    }

    /* access modifiers changed from: package-private */
    public class a extends s<qw> implements MStorageEx.IOnStorageChange {
        com.tencent.mm.ui.applet.b kex = new com.tencent.mm.ui.applet.b(new b.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.applet.b.a
            public final Bitmap Ta(String str) {
                AppMethodBeat.i(5724);
                Bitmap a2 = com.tencent.mm.aj.c.a(str, false, -1, null);
                AppMethodBeat.o(5724);
                return a2;
            }
        });
        private b.AbstractC2078b kez = null;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ qw a(qw qwVar, Cursor cursor) {
            AppMethodBeat.i(5734);
            qw qwVar2 = qwVar;
            if (qwVar2 == null) {
                Log.e("MicroMsg.EnterpriseBizListAdapter", "item == null");
                qwVar2 = new qw();
            }
            if (cursor != null) {
                as asVar = new as();
                asVar.convertFrom(cursor);
                com.tencent.mm.api.c cVar = new com.tencent.mm.api.c();
                cVar.convertFrom(cursor);
                qwVar2.userName = asVar.field_username;
                qwVar2.contact = asVar;
                qwVar2.Bdk = cVar;
                Log.d("MicroMsg.EnterpriseBizListAdapter", "convertFrom userName = %s", qwVar2.userName);
            }
            AppMethodBeat.o(5734);
            return qwVar2;
        }

        public a(Context context) {
            super(context, new qw());
            AppMethodBeat.i(5729);
            anp();
            AppMethodBeat.o(5729);
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.ui.s
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(5730);
            Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(5725);
                    a.this.anq();
                    TextView textView = (TextView) EnterpriseBizContactPlainListUI.this.findViewById(R.id.c4_);
                    if (!(EnterpriseBizContactPlainListUI.this.krb == null || textView == null)) {
                        as Kn = ((l) g.af(l.class)).aSN().Kn(EnterpriseBizContactPlainListUI.this.iNV);
                        if (Kn == null || !c.oR(Kn.field_type)) {
                            EnterpriseBizContactPlainListUI.this.krb.setVisibility(8);
                            textView.setVisibility(0);
                        } else if (EnterpriseBizContactPlainListUI.this.ppu.getCount() <= 0) {
                            EnterpriseBizContactPlainListUI.this.krb.setVisibility(8);
                            textView.setVisibility(0);
                        } else {
                            EnterpriseBizContactPlainListUI.this.krb.setVisibility(0);
                            textView.setVisibility(8);
                            EnterpriseBizContactPlainListUI.this.krb.setAdapter((ListAdapter) EnterpriseBizContactPlainListUI.this.ppu);
                            EnterpriseBizContactPlainListUI.this.krb.setOnItemClickListener(EnterpriseBizContactPlainListUI.this.ppw);
                        }
                    }
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(5725);
                }
            });
            AppMethodBeat.o(5730);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C0866a aVar;
            AppMethodBeat.i(5731);
            if (this.kez == null) {
                this.kez = new b.AbstractC2078b() {
                    /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                    public final String vg(int i2) {
                        AppMethodBeat.i(5726);
                        if (i2 < 0 || i2 >= a.this.getCount()) {
                            Log.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
                            AppMethodBeat.o(5726);
                            return null;
                        }
                        qw qwVar = (qw) a.this.getItem(i2);
                        if (qwVar == null) {
                            AppMethodBeat.o(5726);
                            return null;
                        }
                        String str = qwVar.userName;
                        AppMethodBeat.o(5726);
                        return str;
                    }

                    @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                    public final int bnW() {
                        AppMethodBeat.i(5727);
                        int count = a.this.getCount();
                        AppMethodBeat.o(5727);
                        return count;
                    }
                };
            }
            if (this.kex != null) {
                this.kex.a(i2, this.kez);
            }
            if (view == null) {
                aVar = new C0866a();
                view = View.inflate(this.context, R.layout.a3u, null);
                aVar.keC = (ImageView) view.findViewById(R.id.fu3);
                aVar.kcS = (TextView) view.findViewById(R.id.fu9);
                view.setTag(aVar);
            } else {
                aVar = (C0866a) view.getTag();
            }
            qw qwVar = (qw) getItem(i2);
            if (qwVar == null) {
                aVar.clear();
                AppMethodBeat.o(5731);
            } else {
                aVar.clear();
                int paddingBottom = view.getPaddingBottom();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingLeft = view.getPaddingLeft();
                view.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, R.drawable.qa));
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                aVar.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, Util.nullAsNil(qwVar.contact.arI()), aVar.kcS.getTextSize()));
                aVar.kcS.setVisibility(0);
                aVar.keC.setVisibility(0);
                if (!Util.isNullOrNil(qwVar.contact.field_username)) {
                    a.b.c(aVar.keC, qwVar.contact.field_username);
                } else {
                    aVar.keC.setImageDrawable(null);
                }
                AppMethodBeat.o(5731);
            }
            return view;
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(259583);
            anp();
            AppMethodBeat.o(259583);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(5733);
            if (!g.aAc()) {
                Log.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
                AppMethodBeat.o(5733);
                return;
            }
            ebf();
            Cursor cursor = null;
            switch (EnterpriseBizContactPlainListUI.this.scene) {
                case 1:
                    ag.bah();
                    cursor = f.aq(EnterpriseBizContactPlainListUI.this.iNV, 25);
                    break;
                case 2:
                    ag.bah();
                    cursor = f.MV(EnterpriseBizContactPlainListUI.this.iNV);
                    break;
                case 3:
                    ag.bah();
                    cursor = f.aq(EnterpriseBizContactPlainListUI.this.iNV, 128);
                    break;
                case 4:
                    com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(EnterpriseBizContactPlainListUI.this.iNV);
                    if (!(fJ == null || fJ.field_enterpriseFather == null)) {
                        cursor = ag.bah().MU(fJ.field_enterpriseFather);
                        break;
                    }
                default:
                    ag.bah();
                    cursor = f.O(EnterpriseBizContactPlainListUI.this.iNV, true);
                    break;
            }
            setCursor(cursor);
            AppMethodBeat.o(5733);
        }

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI$a$a  reason: collision with other inner class name */
        class C0866a {
            TextView kcS;
            ImageView keC;

            C0866a() {
            }

            public final void clear() {
                AppMethodBeat.i(5728);
                if (this.keC != null) {
                    this.keC.setImageDrawable(null);
                    this.keC.setVisibility(8);
                }
                if (this.kcS != null) {
                    this.kcS.setText("");
                    this.kcS.setVisibility(8);
                }
                AppMethodBeat.o(5728);
            }
        }
    }

    static /* synthetic */ void a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(5741);
        final qw qwVar = (qw) enterpriseBizContactPlainListUI.ppu.getItem(i2);
        if (qwVar == null || qwVar.userName == null) {
            Log.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "item is null.");
            AppMethodBeat.o(5741);
        } else if (enterpriseBizContactPlainListUI.scene == 1) {
            ((j) g.af(j.class)).a(enterpriseBizContactPlainListUI.mController, qwVar.userName, enterpriseBizContactPlainListUI.getString(R.string.g5i), aa.Ir(qwVar.userName), (String) null, enterpriseBizContactPlainListUI.getString(R.string.yq), new y.a() {
                /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.AnonymousClass4 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                public final void a(boolean z, String str, int i2) {
                    AppMethodBeat.i(5722);
                    if (z) {
                        Intent intent = EnterpriseBizContactPlainListUI.this.getIntent();
                        intent.putExtra("enterprise_biz_name", qwVar.userName);
                        EnterpriseBizContactPlainListUI.this.setResult(-1, intent);
                        EnterpriseBizContactPlainListUI.this.finish();
                    }
                    AppMethodBeat.o(5722);
                }
            });
            AppMethodBeat.o(5741);
        } else if (enterpriseBizContactPlainListUI.scene == 2) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", qwVar.userName);
            com.tencent.mm.plugin.brandservice.b.jRt.c(intent, enterpriseBizContactPlainListUI);
            AppMethodBeat.o(5741);
        } else if (enterpriseBizContactPlainListUI.scene == 3) {
            HashMap hashMap = (HashMap) enterpriseBizContactPlainListUI.getIntent().getSerializableExtra("enterprise_extra_params");
            String str = (String) hashMap.get("title");
            final String str2 = qwVar.userName;
            ab.a.Kgn.a(enterpriseBizContactPlainListUI.getController(), str, (String) hashMap.get("img_url"), (String) hashMap.get("desc"), false, enterpriseBizContactPlainListUI.getResources().getString(R.string.yq), new y.a() {
                /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.AnonymousClass5 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                public final void a(boolean z, String str, int i2) {
                    AppMethodBeat.i(5723);
                    if (!z) {
                        AppMethodBeat.o(5723);
                        return;
                    }
                    if (EnterpriseBizContactPlainListUI.this.scene == 3) {
                        Intent intent = EnterpriseBizContactPlainListUI.this.getIntent();
                        intent.putExtra("enterprise_biz_name", str2);
                        EnterpriseBizContactPlainListUI.this.setResult(-1, intent);
                        EnterpriseBizContactPlainListUI.this.finish();
                    }
                    AppMethodBeat.o(5723);
                }
            });
            AppMethodBeat.o(5741);
        } else {
            if (enterpriseBizContactPlainListUI.scene == 4) {
                com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(qwVar.userName);
                String UM = fJ == null ? null : fJ.UM();
                if (!Util.isNullOrNil(UM)) {
                    d MO = ag.bar().MO(fJ.UN());
                    if (MO != null) {
                        i3 = MO.field_qyUin;
                    } else {
                        i3 = 0;
                    }
                    if (MO != null) {
                        i4 = MO.field_userUin;
                    } else {
                        i4 = 0;
                    }
                    int MQ = ag.bar().MQ(fJ.field_username);
                    h.INSTANCE.a(13419, Integer.valueOf(i3), Integer.valueOf(MQ), Integer.valueOf(i4), 1);
                    Log.d("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizEnterpriseActive report fatherUin:%d,childUin:%d,userUin:%d,scene:%d", Integer.valueOf(i3), Integer.valueOf(MQ), Integer.valueOf(i4), 1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", UM);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", qwVar.userName);
                    intent2.putExtra("enterprise_biz_name", enterpriseBizContactPlainListUI.iNV);
                    intent2.putExtra("biz_chat_chat_id", enterpriseBizContactPlainListUI.ppv);
                    com.tencent.mm.br.c.b(enterpriseBizContactPlainListUI.getContext(), "webview", ".ui.tools.WebViewUI", intent2, 1);
                }
            }
            AppMethodBeat.o(5741);
        }
    }
}
