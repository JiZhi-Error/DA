package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

public class AppAttachFileListUI extends MMActivity implements i.a {
    private ArrayList<c> PdD;
    private HashSet<Long> PdE;
    private ListView PdF;
    private b PdG;
    private boolean PdH = true;
    private boolean PdI = false;
    private View PdJ;
    private AdapterView.OnItemClickListener ppw = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.ui.chatting.AppAttachFileListUI.AnonymousClass2 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(34182);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", ((c) AppAttachFileListUI.this.PdD.get(i2)).dTX.field_msgId);
            intent.setFlags(67108864);
            AppAttachFileListUI appAttachFileListUI = AppAttachFileListUI.this;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(appAttachFileListUI, bl.axQ(), "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            appAttachFileListUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(appAttachFileListUI, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34182);
        }
    };
    private AbsListView.OnScrollListener qqo = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.ui.chatting.AppAttachFileListUI.AnonymousClass3 */

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(34183);
            if (i2 == 0 && !AppAttachFileListUI.this.PdI && AppAttachFileListUI.this.PdH && absListView.getLastVisiblePosition() == AppAttachFileListUI.this.PdG.getCount()) {
                Log.d("MicroMsg.AppAttachFileListUI", "need to add item");
                int i3 = AppAttachFileListUI.this.startIndex;
                new a(AppAttachFileListUI.this, (byte) 0).execute(Integer.valueOf(i3), 20);
                AppAttachFileListUI.f(AppAttachFileListUI.this);
            }
            AppMethodBeat.o(34183);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }
    };
    private int startIndex;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppAttachFileListUI() {
        AppMethodBeat.i(34189);
        AppMethodBeat.o(34189);
    }

    static /* synthetic */ void a(AppAttachFileListUI appAttachFileListUI, List list) {
        AppMethodBeat.i(34198);
        appAttachFileListUI.iw(list);
        AppMethodBeat.o(34198);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cv;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34190);
        super.onCreate(bundle);
        setMMTitle(R.string.ce7);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.AppAttachFileListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34181);
                AppAttachFileListUI.this.finish();
                AppMethodBeat.o(34181);
                return true;
            }
        });
        this.PdF = (ListView) findViewById(R.id.cgc);
        this.PdJ = getLayoutInflater().inflate(R.layout.ct, (ViewGroup) null);
        this.PdF.addFooterView(this.PdJ);
        this.PdJ.setVisibility(8);
        this.PdD = new ArrayList<>();
        this.PdE = new HashSet<>();
        String aTY = z.aTY();
        bg.aVF();
        List<ca> as = com.tencent.mm.model.c.aSQ().as(aTY, 0, 20);
        this.startIndex += 20;
        iw(as);
        this.PdG = new b(this, (byte) 0);
        this.PdF.setAdapter((ListAdapter) this.PdG);
        this.PdF.setOnItemClickListener(this.ppw);
        this.PdF.setOnScrollListener(this.qqo);
        bg.aVF();
        com.tencent.mm.model.c.aSQ().a(this, getMainLooper());
        AppMethodBeat.o(34190);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(34191);
        super.onResume();
        AppMethodBeat.o(34191);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(34192);
        bg.aVF();
        com.tencent.mm.model.c.aSQ().a(this);
        super.onDestroy();
        AppMethodBeat.o(34192);
    }

    private void iw(List<ca> list) {
        AppMethodBeat.i(34193);
        if (list.size() < 20) {
            this.PdH = false;
            this.PdF.removeFooterView(this.PdJ);
        }
        for (ca caVar : list) {
            c be = be(caVar);
            if (be != null && be.PdL.type == 6 && this.PdE.add(Long.valueOf(caVar.field_msgId))) {
                this.PdD.add(be);
            }
        }
        Log.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", Integer.valueOf(list.size()), Integer.valueOf(this.PdD.size()));
        AppMethodBeat.o(34193);
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        private b() {
        }

        /* synthetic */ b(AppAttachFileListUI appAttachFileListUI, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(34186);
            int size = AppAttachFileListUI.this.PdD.size();
            AppMethodBeat.o(34186);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(34187);
            Object obj = AppAttachFileListUI.this.PdD.get(i2);
            AppMethodBeat.o(34187);
            return obj;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            d dVar;
            String displayName;
            AppMethodBeat.i(34188);
            if (view == null) {
                view = AppAttachFileListUI.this.getLayoutInflater().inflate(R.layout.cu, viewGroup, false);
                Assert.assertNotNull(view);
                dVar = new d(AppAttachFileListUI.this, (byte) 0);
                dVar.PdM = (MMImageView) view.findViewById(R.id.cg_);
                dVar.PdN = (TextView) view.findViewById(R.id.cgb);
                dVar.PdO = (TextView) view.findViewById(R.id.cg9);
                dVar.PdP = (TextView) view.findViewById(R.id.cga);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            Assert.assertNotNull(dVar);
            c cVar = (c) AppAttachFileListUI.this.PdD.get(i2);
            dVar.PdN.setText(cVar.PdL.title);
            if (cVar.dTX.field_isSend == 1) {
                displayName = "自己";
            } else {
                displayName = aa.getDisplayName(cVar.PdL.dRL);
            }
            dVar.PdO.setText(String.format("大小：%s，来自：%s", Util.getSizeKB((long) cVar.PdL.iwI), displayName));
            dVar.PdP.setText(f.c(AppAttachFileListUI.this, cVar.dTX.field_createTime, true));
            dVar.PdM.setImageResource(r.bdt(cVar.PdL.iwJ));
            AppMethodBeat.o(34188);
            return view;
        }
    }

    class d {
        public MMImageView PdM;
        public TextView PdN;
        public TextView PdO;
        public TextView PdP;

        private d() {
        }

        /* synthetic */ d(AppAttachFileListUI appAttachFileListUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public class c {
        public k.b PdL;
        public ca dTX;

        private c() {
        }

        /* synthetic */ c(AppAttachFileListUI appAttachFileListUI, byte b2) {
            this();
        }
    }

    class a extends AsyncTask<Integer, Integer, List<ca>> {
        private a() {
        }

        /* synthetic */ a(AppAttachFileListUI appAttachFileListUI, byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ List<ca> doInBackground(Integer[] numArr) {
            AppMethodBeat.i(34185);
            Integer[] numArr2 = numArr;
            int intValue = numArr2[0].intValue();
            int intValue2 = numArr2[1].intValue();
            String aTY = z.aTY();
            bg.aVF();
            List<ca> as = com.tencent.mm.model.c.aSQ().as(aTY, intValue, intValue2);
            AppAttachFileListUI.this.startIndex = intValue2 + AppAttachFileListUI.this.startIndex;
            AppMethodBeat.o(34185);
            return as;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(List<ca> list) {
            AppMethodBeat.i(34184);
            List<ca> list2 = list;
            super.onPostExecute(list2);
            AppAttachFileListUI.g(AppAttachFileListUI.this);
            AppAttachFileListUI.a(AppAttachFileListUI.this, list2);
            AppAttachFileListUI.this.PdG.notifyDataSetChanged();
            AppMethodBeat.o(34184);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
    public final void a(i iVar, i.c cVar) {
        c be;
        AppMethodBeat.i(34195);
        if ("insert".equals(cVar.zqn)) {
            Log.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
            for (int size = cVar.hIs.size() - 1; size >= 0; size--) {
                ca caVar = cVar.hIs.get(size);
                if (caVar.dOQ() && (be = be(caVar)) != null && be.PdL.type == 6) {
                    this.PdD.add(0, be);
                }
            }
            if (this.PdG != null) {
                this.PdG.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(34195);
    }

    private c be(ca caVar) {
        AppMethodBeat.i(34194);
        k.b HD = k.b.HD(caVar.field_content);
        if (HD == null) {
            AppMethodBeat.o(34194);
            return null;
        }
        c cVar = new c(this, (byte) 0);
        cVar.dTX = caVar;
        cVar.PdL = HD;
        AppMethodBeat.o(34194);
        return cVar;
    }

    static /* synthetic */ void f(AppAttachFileListUI appAttachFileListUI) {
        AppMethodBeat.i(34196);
        Log.d("MicroMsg.AppAttachFileListUI", "start to load");
        appAttachFileListUI.PdI = true;
        appAttachFileListUI.PdJ.setVisibility(0);
        AppMethodBeat.o(34196);
    }

    static /* synthetic */ void g(AppAttachFileListUI appAttachFileListUI) {
        AppMethodBeat.i(34197);
        appAttachFileListUI.PdI = false;
        appAttachFileListUI.PdJ.setVisibility(8);
        Log.d("MicroMsg.AppAttachFileListUI", "stop to load");
        AppMethodBeat.o(34197);
    }
}
