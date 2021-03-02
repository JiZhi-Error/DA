package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WelabAppInfoUI extends MMActivity {
    private TextView BfZ;
    private com.tencent.mm.plugin.welab.d.a.a JGe;
    private int JGf;
    private boolean JGg;
    private WelabRoundCornerImageView JGh;
    private RecyclerView JGi;
    private View JGj;
    private View JGk;
    private View JGl;
    private View JGm;
    private a JGn;
    private View.OnClickListener JGo = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(146274);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            String obj = view.getTag().toString();
            Intent intent = new Intent();
            intent.putExtra("nowUrl", obj);
            intent.putExtra("urlList", (String[]) ((a) WelabAppInfoUI.this.JGi.getAdapter()).qzs.toArray(new String[0]));
            WelabAppInfoUI welabAppInfoUI = WelabAppInfoUI.this;
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            c.b(welabAppInfoUI, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(146274);
        }
    };
    private String dNI;
    private TextView nZP;
    private MMSwitchBtn sLW;
    private Button thI;
    private TextView titleTv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WelabAppInfoUI() {
        AppMethodBeat.i(146278);
        AppMethodBeat.o(146278);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(146279);
        super.onCreate(bundle);
        setIsDarkActionbarBg(true);
        hideActionbarLine();
        Intent intent = getIntent();
        if (intent != null) {
            this.dNI = intent.getStringExtra("para_appid");
            this.JGe = com.tencent.mm.plugin.welab.a.gjg().bbz(this.dNI);
            this.JGf = this.JGe.field_Switch;
            if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
                z = false;
            }
            this.JGg = z;
        }
        initView();
        d.y(this.dNI, 2, this.JGg);
        AppMethodBeat.o(146279);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cc5;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(146280);
        super.initView();
        if (this.JGe == null) {
            Log.e("WelabAppInfoUI", "info is null");
            AppMethodBeat.o(146280);
            return;
        }
        setMMTitleVisibility(8);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.afy));
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.color.afy));
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(146270);
                WelabAppInfoUI.this.hideVKB();
                WelabAppInfoUI.this.finish();
                AppMethodBeat.o(146270);
                return true;
            }
        });
        this.JGh = (WelabRoundCornerImageView) findViewById(R.id.ry);
        this.titleTv = (TextView) findViewById(R.id.ipm);
        this.BfZ = (TextView) findViewById(R.id.ied);
        this.JGi = (RecyclerView) findViewById(R.id.dxh);
        this.JGj = findViewById(R.id.sk);
        this.thI = (Button) findViewById(R.id.g48);
        this.JGk = findViewById(R.id.cf_);
        this.sLW = (MMSwitchBtn) findViewById(R.id.b0m);
        this.nZP = (TextView) findViewById(R.id.ifb);
        this.JGl = findViewById(R.id.i6q);
        this.JGm = findViewById(R.id.g41);
        this.JGi.setLayoutManager(new LinearLayoutManager(0, false));
        this.JGi.setOverScrollMode(2);
        this.JGn = new a();
        this.JGi.setAdapter(this.JGn);
        AppMethodBeat.o(146280);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(146281);
        super.onPause();
        if (this.JGf != this.JGe.field_Switch) {
            Log.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", Boolean.valueOf(com.tencent.mm.plugin.welab.a.gjg().JFR.update(this.JGe, new String[0])), Integer.valueOf(this.JGf), Integer.valueOf(this.JGe.field_Switch));
            this.JGf = this.JGe.field_Switch;
            cgw cgw = new cgw();
            cgv cgv = new cgv();
            if (!this.JGe.gjp()) {
                i3 = Util.safeParseInt(this.JGe.field_expId);
            }
            cgv.Mmd = i3;
            cgv.Mme = this.JGe.field_LabsAppId;
            if (this.JGe.field_Switch == 2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            cgv.KWb = i2;
            cgw.gCs.add(cgv);
            ((l) g.af(l.class)).aSM().d(new k.a(207, cgw));
            d.y(this.dNI, this.JGe.field_Switch == 2 ? 4 : 5, this.JGg);
            if (this.JGe.field_Switch == 2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.JGe);
                com.tencent.mm.plugin.welab.a.gjg();
                com.tencent.mm.plugin.welab.a.io(arrayList);
            }
        }
        AppMethodBeat.o(146281);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x016c  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        // Method dump skipped, instructions count: 375
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.onResume():void");
    }

    private String gjr() {
        AppMethodBeat.i(146283);
        String str = "switch_" + this.JGe.field_LabsAppId;
        AppMethodBeat.o(146283);
        return str;
    }

    private void gjs() {
        AppMethodBeat.i(146284);
        String bbH = this.JGe.bbH("field_ImgUrl_android");
        if (TextUtils.isEmpty(bbH)) {
            bbH = this.JGe.bbH("field_ImgUrl");
        }
        List<String> bbC = e.bbC(bbH);
        Iterator<String> it = bbC.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next())) {
                it.remove();
            }
        }
        if (bbC.isEmpty()) {
            this.JGi.setVisibility(8);
            AppMethodBeat.o(146284);
            return;
        }
        this.JGi.setVisibility(0);
        this.JGn.qzs = bbC;
        this.JGn.atj.notifyChanged();
        AppMethodBeat.o(146284);
    }

    class b extends RecyclerView.v {
        public ImageView JGq;

        public b(View view) {
            super(view);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends RecyclerView.a<b> {
        public List<String> qzs;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            AppMethodBeat.i(146276);
            b bVar2 = bVar;
            bVar2.JGq.setTag(this.qzs.get(i2));
            com.tencent.mm.av.a.a.bdb().a(this.qzs.get(i2), bVar2.JGq, com.tencent.mm.plugin.welab.a.gjg().IIu);
            AppMethodBeat.o(146276);
        }

        public a() {
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(146275);
            int size = this.qzs.size();
            AppMethodBeat.o(146275);
            return size;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(146277);
            View inflate = WelabAppInfoUI.this.getLayoutInflater().inflate(R.layout.cc3, viewGroup, false);
            b bVar = new b(inflate);
            bVar.JGq = (ImageView) inflate.findViewById(R.id.dx2);
            bVar.JGq.setOnClickListener(WelabAppInfoUI.this.JGo);
            AppMethodBeat.o(146277);
            return bVar;
        }
    }
}
