package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.c;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI extends MMActivity {
    private String BqZ = null;
    private String BtN;
    private String BtO = null;
    private long BuY = 0;
    private List<a> BuZ = new ArrayList();
    private c Bul = new c(this);
    private String Bva;
    private ListView Bvb;
    private b Bvc;
    private c.a Bvd = new c.a() {
        /* class com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.qqmail.c.a
        public final void onSuccess(String str, Map<String, String> map) {
            String str2;
            AppMethodBeat.i(122968);
            CompressPreviewUI.this.Bva = map.get(".Response.result.compressfilepath");
            int i2 = Util.getInt(map.get(".Response.result.filelist.count"), 0);
            int i3 = 0;
            while (i3 < i2) {
                try {
                    String str3 = ".Response.result.filelist.list.item" + (i3 > 0 ? Integer.valueOf(i3) : "");
                    String str4 = map.get(str3 + ".path");
                    if (str4 != null) {
                        String decode = URLDecoder.decode(str4, ProtocolPackage.ServerEncoding);
                        String str5 = map.get(str3 + ".parentpath");
                        int i4 = Util.getInt(map.get(str3 + ".size"), 0);
                        int i5 = Util.getInt(map.get(str3 + ".type"), 0);
                        boolean equals = map.get(str3 + ".preview").equals("1");
                        String str6 = map.get(str3 + ".name");
                        List list = CompressPreviewUI.this.BuZ;
                        CompressPreviewUI compressPreviewUI = CompressPreviewUI.this;
                        if (i4 == 0) {
                            str2 = "";
                        } else {
                            str2 = "(" + Util.getSizeKB((long) i4) + ")";
                        }
                        list.add(new a(decode, str6, str5, i5, str2, equals));
                    }
                    i3++;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.CompressPreviewUI", e2, "", new Object[0]);
                }
            }
            CompressPreviewUI.a(CompressPreviewUI.this, "");
            AppMethodBeat.o(122968);
        }

        @Override // com.tencent.mm.plugin.qqmail.c.a
        public final void onError(int i2, String str) {
            AppMethodBeat.i(122969);
            if (i2 == -5) {
                CompressPreviewUI.this.Bul.a(new c.a() {
                    /* class com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.qqmail.ui.c.a
                    public final void eGt() {
                        AppMethodBeat.i(122967);
                        CompressPreviewUI.i(CompressPreviewUI.this);
                        AppMethodBeat.o(122967);
                    }

                    @Override // com.tencent.mm.plugin.qqmail.ui.c.a
                    public final void eGu() {
                    }
                });
                AppMethodBeat.o(122969);
                return;
            }
            CompressPreviewUI.this.oMO.setVisibility(8);
            CompressPreviewUI.this.xcX.setVisibility(0);
            CompressPreviewUI.this.Bvb.setVisibility(8);
            AppMethodBeat.o(122969);
        }
    };
    private ProgressBar oMO;
    private TextView xcX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CompressPreviewUI() {
        AppMethodBeat.i(122976);
        AppMethodBeat.o(122976);
    }

    static /* synthetic */ void a(CompressPreviewUI compressPreviewUI, String str) {
        AppMethodBeat.i(122984);
        compressPreviewUI.aKH(str);
        AppMethodBeat.o(122984);
    }

    static /* synthetic */ void i(CompressPreviewUI compressPreviewUI) {
        AppMethodBeat.i(122985);
        compressPreviewUI.eGI();
        AppMethodBeat.o(122985);
    }

    /* access modifiers changed from: package-private */
    public class a {
        String Bvg;
        boolean aWI;
        String id;
        String kSm;
        String name;
        int type;

        public a(String str, String str2, String str3, int i2, String str4, boolean z) {
            AppMethodBeat.i(122970);
            this.id = str;
            this.name = str2;
            this.Bvg = str3 == null ? "" : str3;
            this.type = i2;
            this.kSm = str4;
            this.aWI = z;
            AppMethodBeat.o(122970);
        }

        public final boolean eGJ() {
            return this.type == 1;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b4v;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(122977);
        super.onCreate(bundle);
        this.BqZ = getIntent().getStringExtra("mail_id");
        this.BtO = getIntent().getStringExtra("attach_id");
        this.BuY = getIntent().getLongExtra("attach_size", 0);
        this.BtN = getIntent().getStringExtra("attach_name");
        initView();
        setMMTitle(this.BtN);
        AppMethodBeat.o(122977);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(122978);
        this.Bvb = (ListView) findViewById(R.id.b_0);
        this.xcX = (TextView) findViewById(R.id.b9y);
        this.oMO = (ProgressBar) findViewById(R.id.b9z);
        if (this.BqZ == null || this.BtO == null) {
            this.oMO.setVisibility(8);
            this.xcX.setText(R.string.eu8);
            AppMethodBeat.o(122978);
            return;
        }
        this.Bvc = new b(this, (byte) 0);
        this.Bvb.setAdapter((ListAdapter) this.Bvc);
        this.Bvb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                String str;
                AppMethodBeat.i(122963);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                a Vh = CompressPreviewUI.this.Bvc.Vh(i2);
                String str2 = Vh.id;
                b bVar2 = CompressPreviewUI.this.Bvc;
                if (bVar2.Bvh == null) {
                    str = null;
                } else {
                    str = bVar2.Bvh.id;
                }
                if (str2.equals(str)) {
                    CompressPreviewUI.a(CompressPreviewUI.this, CompressPreviewUI.this.Bvc.eGK());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(122963);
                } else if (Vh.eGJ()) {
                    CompressPreviewUI.a(CompressPreviewUI.this, Vh.id);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(122963);
                } else {
                    if (Vh.aWI) {
                        String[] strArr = {"mailid=" + CompressPreviewUI.this.BqZ, "attachid=" + Vh.id, "compressfilepath=" + CompressPreviewUI.this.Bva, "texttype=html"};
                        Intent intent = new Intent(CompressPreviewUI.this, MailWebViewUI.class);
                        intent.putExtra(ShareConstants.MEDIA_URI, "/cgi-bin/viewdocument");
                        intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, strArr);
                        intent.putExtra("baseurl", v.eGq());
                        intent.putExtra(FirebaseAnalytics.b.METHOD, "get");
                        intent.putExtra("singleColumn", FileExplorerUI.bfr(Vh.name));
                        intent.putExtra("title", CompressPreviewUI.this.getString(R.string.fu8));
                        CompressPreviewUI compressPreviewUI = CompressPreviewUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(compressPreviewUI, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        compressPreviewUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(compressPreviewUI, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(122963);
                }
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(122964);
                CompressPreviewUI.this.onKeyDown(4, null);
                AppMethodBeat.o(122964);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(122965);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(CompressPreviewUI.this.Bvb);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122965);
            }
        });
        addTextOptionMenu(0, getString(R.string.tm), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(122966);
                Intent intent = new Intent(CompressPreviewUI.this, AttachDownloadPage.class);
                intent.putExtra("attach_name", CompressPreviewUI.this.BtN);
                intent.putExtra("mail_id", CompressPreviewUI.this.BqZ);
                intent.putExtra("attach_id", CompressPreviewUI.this.BtO);
                intent.putExtra("total_size", CompressPreviewUI.this.BuY);
                intent.putExtra("is_preview", 0);
                intent.putExtra("is_compress", true);
                CompressPreviewUI compressPreviewUI = CompressPreviewUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(compressPreviewUI, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                compressPreviewUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(compressPreviewUI, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(122966);
                return true;
            }
        });
        eGI();
        AppMethodBeat.o(122978);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(122979);
        super.onDestroy();
        this.Bul.release();
        AppMethodBeat.o(122979);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(122980);
        if (i2 == 4 && this.Bvc.eGK() != null) {
            aKH(this.Bvc.eGK());
            AppMethodBeat.o(122980);
            return true;
        } else if (keyEvent == null) {
            finish();
            AppMethodBeat.o(122980);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(122980);
            return onKeyDown;
        }
    }

    private void aKH(String str) {
        AppMethodBeat.i(122981);
        Log.i("MicroMsg.CompressPreviewUI", "curPath=".concat(String.valueOf(str)));
        this.oMO.setVisibility(8);
        this.xcX.setVisibility(8);
        this.Bvb.setVisibility(0);
        a aKI = aKI(str);
        ArrayList arrayList = new ArrayList();
        if (aKI != null) {
            arrayList.add(aKI);
        }
        for (int i2 = 0; i2 < this.BuZ.size(); i2++) {
            a aVar = this.BuZ.get(i2);
            if ((str.endsWith(aVar.Bvg) && aVar.Bvg.length() > 0) || aVar.Bvg.equals(str)) {
                arrayList.add(aVar);
            }
        }
        this.Bvc.a(aKI, arrayList);
        this.Bvc.notifyDataSetChanged();
        this.Bvb.setSelection(0);
        AppMethodBeat.o(122981);
    }

    private a aKI(String str) {
        AppMethodBeat.i(122982);
        for (a aVar : this.BuZ) {
            if (aVar.id.equals(str)) {
                AppMethodBeat.o(122982);
                return aVar;
            }
        }
        AppMethodBeat.o(122982);
        return null;
    }

    private void eGI() {
        AppMethodBeat.i(122983);
        HashMap hashMap = new HashMap();
        hashMap.put("mailid", this.BqZ);
        hashMap.put("attachid", this.BtO);
        hashMap.put("fun", "list");
        ((k) g.ah(k.class)).getNormalMailAppService().a("/cgi-bin/viewcompress", hashMap, this.Bvd);
        AppMethodBeat.o(122983);
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        a Bvh;
        private List<a> mbK;

        private b() {
            this.mbK = null;
        }

        /* synthetic */ b(CompressPreviewUI compressPreviewUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(122975);
            a Vh = Vh(i2);
            AppMethodBeat.o(122975);
            return Vh;
        }

        public final void a(a aVar, List<a> list) {
            this.Bvh = aVar;
            this.mbK = list;
        }

        public final String eGK() {
            AppMethodBeat.i(122971);
            if (this.Bvh == null || this.Bvh.Bvg == null) {
                AppMethodBeat.o(122971);
                return null;
            } else if (this.Bvh.Bvg.length() == 0) {
                AppMethodBeat.o(122971);
                return "";
            } else {
                int indexOf = this.Bvh.id.indexOf(this.Bvh.Bvg);
                if (indexOf >= 0) {
                    String str = this.Bvh.id.substring(0, indexOf) + this.Bvh.Bvg;
                    AppMethodBeat.o(122971);
                    return str;
                }
                AppMethodBeat.o(122971);
                return null;
            }
        }

        public final int getCount() {
            AppMethodBeat.i(122972);
            if (this.mbK != null) {
                int size = this.mbK.size();
                AppMethodBeat.o(122972);
                return size;
            }
            AppMethodBeat.o(122972);
            return 0;
        }

        public final a Vh(int i2) {
            AppMethodBeat.i(122973);
            if (this.mbK == null || this.mbK.size() <= i2) {
                AppMethodBeat.o(122973);
                return null;
            }
            a aVar = this.mbK.get(i2);
            AppMethodBeat.o(122973);
            return aVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            ImageView imageView;
            int bfq;
            AppMethodBeat.i(122974);
            if (view == null) {
                view = View.inflate(CompressPreviewUI.this.getContext(), R.layout.b4u, null);
                a aVar = new a(this, (byte) 0);
                aVar.nnL = (ImageView) view.findViewById(R.id.cg8);
                aVar.kgE = (TextView) view.findViewById(R.id.cgd);
                aVar.Bvi = (TextView) view.findViewById(R.id.cgi);
                aVar.Bvj = (ImageView) view.findViewById(R.id.cgj);
                view.setTag(aVar);
            }
            a aVar2 = (a) view.getTag();
            a Vh = Vh(i2);
            if (i2 != 0 || eGK() == null) {
                imageView = aVar2.nnL;
                if (Vh.eGJ()) {
                    bfq = R.drawable.bl4;
                } else {
                    bfq = FileExplorerUI.bfq(Vh.name);
                }
            } else {
                imageView = aVar2.nnL;
                bfq = R.drawable.bl3;
            }
            imageView.setImageResource(bfq);
            aVar2.Bvj.setVisibility(Vh.aWI ? 0 : 4);
            aVar2.kgE.setText(Vh.name);
            aVar2.Bvi.setText(Vh.kSm);
            AppMethodBeat.o(122974);
            return view;
        }

        class a {
            TextView Bvi;
            ImageView Bvj;
            TextView kgE;
            ImageView nnL;

            private a() {
            }

            /* synthetic */ a(b bVar, byte b2) {
                this();
            }
        }
    }
}
