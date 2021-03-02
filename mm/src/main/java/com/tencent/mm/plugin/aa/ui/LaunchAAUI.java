package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.a;
import com.tencent.mm.plugin.aa.model.b.e;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo;
import com.tencent.mm.plugin.aa.model.d;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.aa.model.l;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.smtt.sdk.TbsListener;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAUI extends BaseAAPresenterActivity {
    private String chatroomName = null;
    private String imagePath;
    private String imageUrl = "";
    private int jUB;
    private Dialog jUC = null;
    private TextView jUP;
    private Dialog jUV;
    private boolean jWF = false;
    private e jWX = ((e) aq(e.class));
    private int jWY = 4;
    private boolean jWZ = false;
    private String jWm;
    private ViewGroup jXA;
    private Map<String, Double> jXB = new HashMap();
    private Map<String, LaunchAAByPersonNameAmountRow> jXC = new HashMap();
    private Button jXD;
    private TextView jXE;
    private TextView jXF;
    private com.tencent.mm.plugin.aa.model.e jXG = new com.tencent.mm.plugin.aa.model.e();
    private int jXH = 0;
    private int jXI = 0;
    private boolean jXJ = false;
    private String jXK;
    private long jXL;
    private String jXM;
    private NetSceneNewAAQueryPFInfo.PfInfoParcel jXN = null;
    private boolean jXO = false;
    private IListener<lq> jXP = new IListener<lq>() {
        /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160787);
            this.__eventId = lq.class.getName().hashCode();
            AppMethodBeat.o(160787);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lq lqVar) {
            AppMethodBeat.i(63628);
            lq lqVar2 = lqVar;
            if (lqVar2 != null) {
                Log.i("MicroMsg.Aa.LaunchAAUI", "launchAAEventIListener %s", lqVar2.dQX.dRa);
                LaunchAAUI.a(LaunchAAUI.this, lqVar2.dQX.context, lqVar2.dQX.dRa, lqVar2.dQX.dQZ);
            }
            AppMethodBeat.o(63628);
            return true;
        }
    };
    private MMEditText jXa;
    private TextView jXb;
    private TextView jXc;
    private TextView jXd;
    private LinearLayout jXe;
    private ImageView jXf;
    private RelativeLayout jXg;
    private LinearLayout jXh;
    private ImageView jXi;
    private TextView jXj;
    private ImageView jXk;
    private TextView jXl;
    private TextView jXm;
    private WalletFormView jXn;
    private TextView jXo;
    private TextView jXp;
    private ViewGroup jXq;
    private ViewGroup jXr;
    private List<String> jXs = new ArrayList();
    private ViewGroup jXt;
    private ViewGroup jXu;
    private ViewGroup jXv;
    private ViewGroup jXw;
    private ViewGroup jXx;
    private TextView jXy;
    private TextView jXz;
    private int mode = a.jRJ;
    private int scene;
    private long timestamp = 0;
    private Dialog tipDialog;

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LaunchAAUI() {
        AppMethodBeat.i(63668);
        AppMethodBeat.o(63668);
    }

    static /* synthetic */ void F(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(213091);
        launchAAUI.bmR();
        AppMethodBeat.o(213091);
    }

    static /* synthetic */ void G(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(213092);
        launchAAUI.bmS();
        AppMethodBeat.o(213092);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, Context context, String str, int i2, String str2, double d2, List list, String str3, String str4) {
        AppMethodBeat.i(213095);
        launchAAUI.a(context, str, i2, str2, d2, list, str3, str4);
        AppMethodBeat.o(213095);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, Context context, String str, String str2, String str3) {
        AppMethodBeat.i(213096);
        launchAAUI.b(context, str, str2, str3);
        AppMethodBeat.o(213096);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, Context context, String str, String str2, String str3, boolean z, List list) {
        AppMethodBeat.i(213097);
        launchAAUI.a(context, str, str2, str3, z, list);
        AppMethodBeat.o(213097);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, Context context, String str, ArrayList arrayList) {
        AppMethodBeat.i(63695);
        launchAAUI.a(context, str, true, (ArrayList<String>) arrayList);
        AppMethodBeat.o(63695);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, View view, View view2) {
        AppMethodBeat.i(213082);
        launchAAUI.g(view, view2);
        AppMethodBeat.o(213082);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, String str, String str2) {
        AppMethodBeat.i(213089);
        launchAAUI.bY(str, str2);
        AppMethodBeat.o(213089);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, ArrayList arrayList) {
        AppMethodBeat.i(213084);
        launchAAUI.x(arrayList);
        AppMethodBeat.o(213084);
    }

    static /* synthetic */ void e(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(63698);
        launchAAUI.bmQ();
        AppMethodBeat.o(63698);
    }

    static /* synthetic */ boolean t(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(213085);
        boolean bmE = launchAAUI.bmE();
        AppMethodBeat.o(213085);
        return bmE;
    }

    static /* synthetic */ void u(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(63703);
        launchAAUI.bmW();
        AppMethodBeat.o(63703);
    }

    static /* synthetic */ void v(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(213086);
        launchAAUI.bmN();
        AppMethodBeat.o(213086);
    }

    static /* synthetic */ void w(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(213087);
        launchAAUI.bmM();
        AppMethodBeat.o(213087);
    }

    static /* synthetic */ void x(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(213088);
        launchAAUI.bmK();
        AppMethodBeat.o(213088);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0540  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
        // Method dump skipped, instructions count: 1386
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.aa.ui.LaunchAAUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needExecuteBackListener() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(63670);
        super.finish();
        try {
            hideVKB();
            AppMethodBeat.o(63670);
        } catch (Exception e2) {
            Log.e("MicroMsg.Aa.LaunchAAUI", "%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(63670);
        }
    }

    private boolean bmE() {
        return this.scene == 6;
    }

    private boolean bmJ() {
        return this.scene == 5;
    }

    private void bmK() {
        AppMethodBeat.i(213071);
        if (bmE()) {
            try {
                y(this.jXN.jTA);
                bmL();
                AppMethodBeat.o(213071);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.Aa.LaunchAAUI", "initPersonLaunchView error:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
        }
        AppMethodBeat.o(213071);
    }

    private void bmL() {
        AppMethodBeat.i(63671);
        bmT();
        bmR();
        bmQ();
        AppMethodBeat.o(63671);
    }

    private void x(ArrayList<String> arrayList) {
        AppMethodBeat.i(63672);
        Log.i("MicroMsg.Aa.LaunchAAUI", "go to contact");
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 3);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", false);
        intent.putExtra("mutil_select_is_ret", false);
        intent.putExtra("Select_block_List", z.aTY());
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(",");
            }
            if (sb.length() - 1 >= 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Log.i("MicroMsg.Aa.LaunchAAUI", "gotoSelectContactUI %s", sb.toString());
            intent.putExtra("recent_remittance_contact_list", sb.toString());
        }
        if (this.mode == a.jRJ) {
            StringBuilder sb2 = new StringBuilder();
            for (String str : this.jXs) {
                sb2.append(str).append(",");
            }
            if (sb2.length() - 1 >= 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            intent.putExtra("key_include_username_list", sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder();
            for (String str2 : this.jXB.keySet()) {
                sb3.append(str2).append(",");
            }
            if (sb3.length() - 1 >= 0) {
                sb3.deleteCharAt(sb3.length() - 1);
            }
            intent.putExtra("key_include_username_list", sb3.toString());
        }
        if (bmE()) {
            intent.putExtra("key_title", this.jXa.getText().toString());
        }
        c.b(getContext(), "remittance", ".ui.SelectRemittanceContactUI", intent, 320);
        uZ(10);
        AppMethodBeat.o(63672);
    }

    private void bY(String str, final String str2) {
        AppMethodBeat.i(63673);
        this.jXF.setVisibility(0);
        this.jXF.setText(str);
        this.jXF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(213038);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.bn(LaunchAAUI.this.getContext(), str2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213038);
            }
        });
        AppMethodBeat.o(63673);
    }

    private void bmM() {
        String string;
        AppMethodBeat.i(63674);
        if (this.mode != a.jRK) {
            string = getString(R.string.edd);
        } else if (this.jWY == 4) {
            string = getString(R.string.edf);
        } else {
            string = getString(R.string.ede);
        }
        ao.a(this.jXl.getPaint(), 0.8f);
        this.jXl.setText(string);
        this.jXe.setClickable(true);
        this.jXe.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(213039);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Aa.LaunchAAUI", "click switch button");
                LaunchAAUI.this.hideTenpayKB();
                LaunchAAUI.this.hideVKB();
                LaunchAAUI.z(LaunchAAUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213039);
            }
        });
        this.jXe.post(new Runnable() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass19 */

            public final void run() {
                AppMethodBeat.i(213040);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) LaunchAAUI.this.jXe.getLayoutParams();
                layoutParams.width = LaunchAAUI.this.jXl.getWidth() + LaunchAAUI.this.jXf.getWidth();
                layoutParams.height = LaunchAAUI.this.jXl.getHeight();
                LaunchAAUI.this.jXe.setLayoutParams(layoutParams);
                AppMethodBeat.o(213040);
            }
        });
        AppMethodBeat.o(63674);
    }

    private void bmN() {
        AppMethodBeat.i(213072);
        Log.i("MicroMsg.Aa.LaunchAAUI", "switchMode");
        this.jWZ = false;
        if (this.mode == a.jRK) {
            if (this.jWY == 4) {
                this.jXt.setVisibility(8);
                this.jXz.setVisibility(0);
                this.jXA.setVisibility(8);
                this.jXv.setVisibility(0);
                List<String> SA = i.SA(this.chatroomName);
                this.jXz.setText(getString(R.string.ecr, new Object[]{Integer.valueOf(SA.size())}));
            } else {
                this.jXt.setVisibility(0);
                this.jXz.setVisibility(8);
                this.jXA.setVisibility(0);
                this.jXv.setVisibility(8);
            }
            this.jXd.setText(R.string.ecl);
            this.jXq.setVisibility(8);
            this.jXr.setVisibility(8);
            this.jXb.setText(getString(R.string.ecv, new Object[]{0}));
            if (this.jXB != null && this.jXB.size() > com.tencent.mm.plugin.aa.model.e.bmf()) {
                h.INSTANCE.a(13722, 8);
                this.jWZ = true;
            }
            if (this.jWZ) {
                SE(getString(R.string.ecq, new Object[]{Integer.valueOf(com.tencent.mm.plugin.aa.model.e.bmf())}));
            } else {
                bmP();
            }
            uZ(5);
        } else {
            this.mode = a.jRJ;
            this.jXq.setVisibility(0);
            this.jXr.setVisibility(0);
            this.jXt.setVisibility(8);
            this.jXv.setVisibility(8);
            this.jXz.setVisibility(8);
            this.jXb.setText(R.string.ece);
            g(this.jXw, this.jXx);
            this.jWZ = false;
            if (this.jXs.size() > com.tencent.mm.plugin.aa.model.e.bmg()) {
                h.INSTANCE.a(13722, 8);
                this.jWZ = true;
            }
            bmS();
            uZ(4);
        }
        hideTenpayKB();
        hideVKB();
        bmM();
        bmR();
        bmQ();
        g(this.jXw, this.jXx);
        AppMethodBeat.o(213072);
    }

    private void bmO() {
        final ArrayList arrayList;
        AppMethodBeat.i(63675);
        this.jXn.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass20 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(213041);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    WalletFormView.a(LaunchAAUI.this.jXn.getContentEt(), obj, indexOf + 3, length);
                } else if (indexOf > 6) {
                    WalletFormView.a(LaunchAAUI.this.jXn.getContentEt(), obj, 6, indexOf);
                } else if (indexOf == -1 && length > 6) {
                    WalletFormView.a(LaunchAAUI.this.jXn.getContentEt(), obj, 6, length);
                }
                double d2 = Util.getDouble(editable.toString(), 0.0d);
                if (LaunchAAUI.this.jXs != null && LaunchAAUI.this.jXs.size() > 0) {
                    double size = (d2 * 100.0d) / ((double) LaunchAAUI.this.jXs.size());
                    com.tencent.mm.plugin.aa.model.e unused = LaunchAAUI.this.jXG;
                    if (size > ((double) com.tencent.mm.plugin.aa.model.e.bmh())) {
                        LaunchAAUI.this.jWF = true;
                        h.INSTANCE.a(13722, 2);
                        LaunchAAUI.e(LaunchAAUI.this);
                        LaunchAAUI.F(LaunchAAUI.this);
                        LaunchAAUI.G(LaunchAAUI.this);
                        LaunchAAUI.this.uZ(3);
                        AppMethodBeat.o(213041);
                    }
                }
                LaunchAAUI.this.jWF = false;
                LaunchAAUI.e(LaunchAAUI.this);
                LaunchAAUI.F(LaunchAAUI.this);
                LaunchAAUI.G(LaunchAAUI.this);
                LaunchAAUI.this.uZ(3);
                AppMethodBeat.o(213041);
            }
        });
        setEditFocusListener(this.jXn, 2, false, true);
        this.jXn.setmContentAbnormalMoneyCheck(true);
        if (bmE()) {
            ArrayList arrayList2 = new ArrayList();
            for (String str : this.jXB.keySet()) {
                arrayList2.add(str);
            }
            this.jXp.setText(getString(R.string.ecf, new Object[]{Integer.valueOf(arrayList2.size())}));
            this.jXs = arrayList2;
            arrayList = arrayList2;
        } else {
            if (!ab.Eq(this.chatroomName)) {
                Log.i("MicroMsg.Aa.LaunchAAUI", "is single chat: %s", this.chatroomName);
                arrayList = new ArrayList();
                arrayList.add(z.aTY());
                arrayList.add(this.chatroomName);
            } else if (!ab.Iz(this.chatroomName)) {
                arrayList = i.SA(this.chatroomName);
            } else {
                arrayList = bmU();
            }
            this.jXs = arrayList;
            if (this.jXs.size() > com.tencent.mm.plugin.aa.model.e.bmg()) {
                this.jXs.clear();
                this.jXp.setText(getString(R.string.fk7));
                bmQ();
            } else if (!ab.Eq(this.chatroomName)) {
                this.jXp.setText(getString(R.string.ecf, new Object[]{Integer.valueOf(arrayList.size())}));
            } else if (!ab.Iz(this.chatroomName)) {
                this.jXp.setText(getString(R.string.ec_, new Object[]{Integer.valueOf(arrayList.size())}));
            } else {
                this.jXp.setText(getString(R.string.ecf, new Object[]{Integer.valueOf(arrayList.size())}));
            }
        }
        this.jXq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass21 */

            public final void onClick(View view) {
                AppMethodBeat.i(213042);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LaunchAAUI.this.hideTenpayKB();
                LaunchAAUI.this.hideVKB();
                LaunchAAUI.a(LaunchAAUI.this, arrayList);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213042);
            }
        });
        this.jWZ = false;
        AppMethodBeat.o(63675);
    }

    private void SE(String str) {
        AppMethodBeat.i(63676);
        this.jXJ = true;
        this.jXE.setVisibility(0);
        this.jXE.startAnimation(AnimationUtils.loadAnimation(this, R.anim.cc));
        this.jXE.setText(str);
        AppMethodBeat.o(63676);
    }

    private void bmP() {
        AppMethodBeat.i(63677);
        this.jXJ = false;
        if (this.jXE.getVisibility() != 8) {
            this.jXE.startAnimation(AnimationUtils.loadAnimation(this, R.anim.d5));
            this.jXE.setVisibility(8);
        }
        AppMethodBeat.o(63677);
    }

    private void bmQ() {
        AppMethodBeat.i(63678);
        if (this.mode == a.jRJ) {
            if (Util.isNullOrNil(this.jXn.getText())) {
                gg(false);
                AppMethodBeat.o(63678);
                return;
            } else if (this.jWF) {
                gg(false);
                AppMethodBeat.o(63678);
                return;
            } else if (this.jXs == null || this.jXs.size() == 0) {
                gg(false);
                AppMethodBeat.o(63678);
                return;
            } else if (this.jXs.size() > com.tencent.mm.plugin.aa.model.e.bmg() || this.jWZ) {
                gg(false);
                AppMethodBeat.o(63678);
                return;
            } else {
                double a2 = i.a(this.jXn.getText(), new StringBuilder().append(this.jXs.size()).toString(), 5, 4);
                Log.d("MicroMsg.Aa.LaunchAAUI", "b1: %s, b2: %s, avg: %s", this.jXn.getText(), Integer.valueOf(this.jXs.size()), Double.valueOf(a2));
                if (a2 < 0.01d) {
                    Log.i("MicroMsg.Aa.LaunchAAUI", "less than 0.01");
                    gg(false);
                    AppMethodBeat.o(63678);
                    return;
                }
            }
        } else if (this.jWY == 4) {
            gg(true);
            AppMethodBeat.o(63678);
            return;
        } else if (this.jXB == null || this.jXB.size() == 0) {
            gg(false);
            AppMethodBeat.o(63678);
            return;
        } else if (this.jXB.size() > com.tencent.mm.plugin.aa.model.e.bmg() || this.jWZ) {
            gg(false);
            AppMethodBeat.o(63678);
            return;
        }
        gg(true);
        AppMethodBeat.o(63678);
    }

    private void gg(boolean z) {
        AppMethodBeat.i(63679);
        this.jXD.setEnabled(z);
        if (!z) {
            this.jXb.setTextColor(getResources().getColor(R.color.FG_1));
            this.jUP.setTextColor(getResources().getColor(R.color.ap));
            this.jXc.setTextColor(getResources().getColor(R.color.ap));
            AppMethodBeat.o(63679);
            return;
        }
        this.jXb.setTextColor(getResources().getColor(R.color.FG_1));
        this.jUP.setTextColor(getResources().getColor(R.color.a2x));
        this.jXc.setTextColor(getResources().getColor(R.color.a2x));
        AppMethodBeat.o(63679);
    }

    private void bmR() {
        AppMethodBeat.i(63680);
        if (this.mode == a.jRJ) {
            if (this.jXs == null || this.jXs.size() <= 0) {
                this.jUP.setText(getString(R.string.o));
            } else {
                double a2 = i.a(this.jXn.getText(), new StringBuilder().append(this.jXs.size()).toString(), 2, 2);
                this.jUP.setText(getString(R.string.f3153j, new Object[]{Double.valueOf(a2)}));
            }
            this.jXb.setText(R.string.ece);
            this.jUP.setVisibility(0);
            this.jXc.setVisibility(0);
            this.jXb.setVisibility(0);
            AppMethodBeat.o(63680);
        } else if (this.jWY == 4) {
            this.jUP.setVisibility(4);
            this.jXc.setVisibility(4);
            this.jXb.setVisibility(4);
            AppMethodBeat.o(63680);
        } else if (this.jXB == null || this.jXB.size() == 0) {
            this.jXb.setText(getString(R.string.ecv, new Object[]{0}));
            this.jUP.setText(getString(R.string.o));
            this.jUP.setVisibility(0);
            this.jXc.setVisibility(0);
            this.jXb.setVisibility(0);
            AppMethodBeat.o(63680);
        } else {
            double d2 = 0.0d;
            for (Double d3 : this.jXB.values()) {
                d2 = d3.doubleValue() + d2;
            }
            this.jUP.setText(getString(R.string.f3153j, new Object[]{Double.valueOf(d2)}));
            this.jXb.setText(getString(R.string.ecv, new Object[]{Integer.valueOf(this.jXB.size())}));
            this.jXw.setVisibility(0);
            this.jUP.setVisibility(0);
            this.jXc.setVisibility(0);
            this.jXb.setVisibility(0);
            AppMethodBeat.o(63680);
        }
    }

    private void SF(final String str) {
        String str2;
        AppMethodBeat.i(63681);
        Log.i("MicroMsg.Aa.LaunchAAUI", "showLaunchComfirmDialog() from scene:%s", Integer.valueOf(this.scene));
        String obj = this.jXa.getText().toString();
        if (Util.isNullOrNil(obj)) {
            str2 = getString(R.string.ed0);
        } else {
            str2 = obj;
        }
        ((j) g.af(j.class)).a(getController(), str, getString(R.string.x) + str2, getString(R.string.w), new y.a() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass22 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(213043);
                if (z) {
                    Log.i("MicroMsg.Aa.LaunchAAUI", "click launchDialog confirm，mode：%s，submode：%s", Integer.valueOf(LaunchAAUI.this.mode), Integer.valueOf(LaunchAAUI.this.jWY));
                    LaunchAAUI.b(LaunchAAUI.this, str);
                    LaunchAAUI.this.uZ(12);
                    h.INSTANCE.a(13721, 8, 4);
                    AppMethodBeat.o(213043);
                    return;
                }
                Log.i("MicroMsg.Aa.LaunchAAUI", "click launchDialog cancel，mode：%s，submode：%s", Integer.valueOf(LaunchAAUI.this.mode), Integer.valueOf(LaunchAAUI.this.jWY));
                LaunchAAUI.this.uZ(13);
                AppMethodBeat.o(213043);
            }
        });
        uZ(11);
        h.INSTANCE.a(13721, 8, 3);
        AppMethodBeat.o(63681);
    }

    private void a(final Context context, final String str, final boolean z, final ArrayList<String> arrayList) {
        final int size;
        final double d2;
        AppMethodBeat.i(63682);
        uZ(9);
        if (this.mode != a.jRJ) {
            bmP();
            if (this.jUV != null) {
                this.jUV.dismiss();
            }
            this.jUV = com.tencent.mm.wallet_core.ui.h.c(context, false, null);
            if (!Util.isNullOrNil(this.imagePath)) {
                if (this.jUB == 2 && SH(this.imagePath) && s.YS(bmV())) {
                    Log.i("MicroMsg.Aa.LaunchAAUI", "set local imagePath :%s", bmV());
                    this.imagePath = bmV();
                }
                new d(this.imagePath, new d.a() {
                    /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass25 */

                    @Override // com.tencent.mm.plugin.aa.model.d.a
                    public final void bU(final String str, final String str2) {
                        AppMethodBeat.i(213048);
                        Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass25.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(63648);
                                if (s.YS(LaunchAAUI.this.bmV())) {
                                    Log.i("MicroMsg.Aa.LaunchAAUI", " upload success , delete file");
                                    s.deleteFile(LaunchAAUI.this.bmV());
                                }
                                if (LaunchAAUI.this.jWY == 4) {
                                    LaunchAAUI.a(LaunchAAUI.this, context, str, str, str2);
                                    AppMethodBeat.o(63648);
                                    return;
                                }
                                LaunchAAUI.a(LaunchAAUI.this, context, str, str, str2, z, arrayList);
                                AppMethodBeat.o(63648);
                            }
                        });
                        AppMethodBeat.o(213048);
                    }

                    @Override // com.tencent.mm.plugin.aa.model.d.a
                    public final void bme() {
                        AppMethodBeat.i(213049);
                        Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass25.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(63649);
                                if (LaunchAAUI.this.jUV != null) {
                                    LaunchAAUI.this.jUV.dismiss();
                                }
                                Toast.makeText(context, (int) R.string.ed4, 1).show();
                                AppMethodBeat.o(63649);
                            }
                        });
                        AppMethodBeat.o(213049);
                    }
                }).bmd();
                AppMethodBeat.o(63682);
            } else if (this.jWY == 4) {
                b(context, str, "", "");
                AppMethodBeat.o(63682);
            } else {
                a(context, str, "", "", z, arrayList);
                AppMethodBeat.o(63682);
            }
        } else if (Util.isNullOrNil(this.jXn.getText())) {
            AppMethodBeat.o(63682);
        } else if (this.jXs == null || this.jXs.size() == 0) {
            AppMethodBeat.o(63682);
        } else {
            bmP();
            h.INSTANCE.a(13721, 2, 3);
            if (z) {
                if (arrayList != null) {
                    try {
                        size = arrayList.size();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByMoney mode: %s error: %s", Integer.valueOf(this.mode), e2.getMessage());
                        AppMethodBeat.o(63682);
                        return;
                    }
                } else {
                    size = 0;
                }
                d2 = Util.getDouble(this.jUP.getText().toString(), 0.0d) * ((double) size);
            } else {
                size = this.jXs != null ? this.jXs.size() : 0;
                d2 = Util.getDouble(this.jXn.getText(), 0.0d);
            }
            final String obj = this.jXa.getText().toString();
            if (Util.isNullOrNil(obj)) {
                obj = getString(R.string.ed0);
            }
            if (size > 0) {
                if (this.jUV != null) {
                    this.jUV.dismiss();
                }
                this.jUV = com.tencent.mm.wallet_core.ui.h.c(context, false, null);
                if (!Util.isNullOrNil(this.imagePath)) {
                    new d(this.imagePath, new d.a() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass24 */

                        @Override // com.tencent.mm.plugin.aa.model.d.a
                        public final void bU(final String str, final String str2) {
                            AppMethodBeat.i(213046);
                            Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass24.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(213044);
                                    if (z) {
                                        LaunchAAUI.a(LaunchAAUI.this, context, str, size, obj, d2, arrayList, str, str2);
                                        AppMethodBeat.o(213044);
                                        return;
                                    }
                                    LaunchAAUI.a(LaunchAAUI.this, context, str, size, obj, d2, LaunchAAUI.this.jXs, str, str2);
                                    AppMethodBeat.o(213044);
                                }
                            });
                            AppMethodBeat.o(213046);
                        }

                        @Override // com.tencent.mm.plugin.aa.model.d.a
                        public final void bme() {
                            AppMethodBeat.i(213047);
                            Log.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass24.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(213045);
                                    if (LaunchAAUI.this.jUV != null) {
                                        LaunchAAUI.this.jUV.dismiss();
                                    }
                                    Toast.makeText(context, (int) R.string.ed4, 1).show();
                                    AppMethodBeat.o(213045);
                                }
                            });
                            AppMethodBeat.o(213047);
                        }
                    }).bmd();
                } else if (z) {
                    a(context, str, size, obj, d2, arrayList);
                } else {
                    a(context, str, size, obj, d2, this.jXs);
                }
            }
            h.INSTANCE.a(13723, 1, i.SA(this.chatroomName), Integer.valueOf(size), Double.valueOf(100.0d * d2), obj);
            AppMethodBeat.o(63682);
        }
    }

    private void a(Context context, String str, int i2, String str2, double d2, List<String> list) {
        AppMethodBeat.i(63683);
        a(context, str, i2, str2, d2, list, "", "");
        AppMethodBeat.o(63683);
    }

    private void a(final Context context, final String str, int i2, String str2, double d2, List<String> list, String str3, String str4) {
        AppMethodBeat.i(63684);
        HashMap hashMap = new HashMap();
        hashMap.put(l.jSJ, str2);
        hashMap.put(l.jSK, Double.valueOf(100.0d * d2));
        hashMap.put(l.jSN, str);
        hashMap.put(l.jSQ, Long.valueOf(this.timestamp));
        long a2 = f.a(new StringBuilder().append(i.bX(new StringBuilder().append(d2).toString(), "100")).toString(), String.valueOf(i2), RoundingMode.CEILING);
        Log.d("MicroMsg.Aa.LaunchAAUI", "perAmount: %s", Long.valueOf(a2));
        if (a2 <= 0 || a2 > com.tencent.mm.plugin.aa.model.e.bmh()) {
            Log.i("MicroMsg.Aa.LaunchAAUI", "illegal avgAmount: %s", Long.valueOf(a2));
            AppMethodBeat.o(63684);
            return;
        }
        hashMap.put(l.jSM, Long.valueOf(a2));
        hashMap.put(l.jSR, str3);
        hashMap.put(l.jSS, str4);
        if (bmE()) {
            hashMap.put(l.jST, this.jWm);
        }
        hashMap.put(l.jSP, list);
        this.jWX.jUa.e(this.mode, hashMap).f(new com.tencent.mm.vending.c.a<Void, Boolean>() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass27 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Boolean bool) {
                AppMethodBeat.i(213053);
                Boolean bool2 = bool;
                Log.d("MicroMsg.Aa.LaunchAAUI", "finish launch aa, result: %s", bool2);
                if (LaunchAAUI.this.jUV != null) {
                    LaunchAAUI.this.jUV.dismiss();
                }
                if (bool2.booleanValue()) {
                    LaunchAAUI.c(LaunchAAUI.this, str);
                    Toast.makeText(context, (int) R.string.edk, 1).show();
                    h.INSTANCE.a(13722, 4);
                    ((u) g.af(u.class)).Dv(str);
                } else {
                    Toast.makeText(context, (int) R.string.ed4, 1).show();
                    h.INSTANCE.a(13722, 5);
                }
                Void r0 = QZL;
                AppMethodBeat.o(213053);
                return r0;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass26 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(213052);
                Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", obj);
                if (LaunchAAUI.this.jUV != null) {
                    LaunchAAUI.this.jUV.dismiss();
                }
                if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                    com.tencent.mm.ui.base.h.a(context, obj.toString(), "", LaunchAAUI.this.getString(R.string.ed6), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass26.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(213050);
                            Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                            AppMethodBeat.o(213050);
                        }
                    });
                } else if (obj != null && (obj instanceof com.tencent.mm.protocal.protobuf.ab)) {
                    i.a(LaunchAAUI.this.getContext(), (com.tencent.mm.protocal.protobuf.ab) obj);
                } else if (obj == null || !(obj instanceof com.tencent.mm.protocal.protobuf.a)) {
                    Toast.makeText(context, (int) R.string.ed4, 1).show();
                } else {
                    final com.tencent.mm.protocal.protobuf.a aVar = (com.tencent.mm.protocal.protobuf.a) obj;
                    String str = aVar.dQx;
                    String str2 = aVar.lHA;
                    String str3 = aVar.lHB;
                    d.a aVar2 = new d.a(context);
                    aVar2.boo(str);
                    aVar2.bou(str3).c(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass26.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(213051);
                            f.p(LaunchAAUI.this.getContext(), aVar.qwt, false);
                            AppMethodBeat.o(213051);
                        }
                    });
                    aVar2.bov(str2);
                    aVar2.hbn().show();
                }
                h.INSTANCE.a(13722, 5);
                AppMethodBeat.o(213052);
            }
        });
        AppMethodBeat.o(63684);
    }

    private void a(final Context context, final String str, String str2, String str3, boolean z, List<String> list) {
        String str4;
        AppMethodBeat.i(63685);
        ((com.tencent.mm.pluginsdk.wallet.b) g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(7, 5);
        h.INSTANCE.a(13721, 3, 3);
        HashMap hashMap = new HashMap();
        try {
            String obj = this.jXa.getText().toString();
            if (Util.isNullOrNil(obj)) {
                str4 = getString(R.string.ed0);
            } else {
                str4 = obj;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            long j2 = 0;
            for (String str5 : this.jXB.keySet()) {
                if (!z || list.contains(str5)) {
                    double doubleValue = this.jXB.get(str5).doubleValue();
                    com.tencent.mm.protocal.protobuf.l lVar = new com.tencent.mm.protocal.protobuf.l();
                    lVar.eht = f.nF(String.valueOf(doubleValue), "100");
                    lVar.username = str5;
                    arrayList.add(lVar);
                    long j3 = lVar.eht + j2;
                    arrayList2.add(new StringBuilder().append(lVar.eht).toString());
                    j2 = j3;
                }
            }
            com.tencent.mm.protocal.protobuf.l lVar2 = new com.tencent.mm.protocal.protobuf.l();
            lVar2.username = z.aTY();
            lVar2.eht = j2;
            hashMap.put(l.jSJ, str4);
            hashMap.put(l.jSK, Long.valueOf(j2));
            hashMap.put(l.jSP, arrayList);
            hashMap.put(l.jSN, str);
            hashMap.put(l.jSQ, Long.valueOf(this.timestamp));
            hashMap.put(l.jSR, str2);
            hashMap.put(l.jSS, str3);
            if (bmE()) {
                hashMap.put(l.jST, this.jWm);
            }
            this.jWX.jUb.H(hashMap).f(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.vending.j.d<Boolean, String, Long>>() {
                /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass29 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(com.tencent.mm.vending.j.d<Boolean, String, Long> dVar) {
                    AppMethodBeat.i(213057);
                    com.tencent.mm.vending.j.d<Boolean, String, Long> dVar2 = dVar;
                    Log.d("MicroMsg.Aa.LaunchAAUI", "finish launch aa, result: %s", dVar2.get(0));
                    if (LaunchAAUI.this.jUV != null) {
                        LaunchAAUI.this.jUV.dismiss();
                    }
                    if (((Boolean) dVar2.get(0)).booleanValue()) {
                        LaunchAAUI.c(LaunchAAUI.this, str);
                        Toast.makeText(context, (int) R.string.edk, 1).show();
                        h.INSTANCE.a(13722, 9);
                        ((u) g.af(u.class)).Dv(str);
                    } else {
                        Toast.makeText(context, (int) R.string.ed4, 1).show();
                        h.INSTANCE.a(13722, 10);
                    }
                    Void r0 = QZL;
                    AppMethodBeat.o(213057);
                    return r0;
                }
            }).a(new d.a() {
                /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass28 */

                @Override // com.tencent.mm.vending.g.d.a
                public final void cn(Object obj) {
                    AppMethodBeat.i(213056);
                    Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", obj);
                    if (LaunchAAUI.this.jUV != null) {
                        LaunchAAUI.this.jUV.dismiss();
                    }
                    if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                        com.tencent.mm.ui.base.h.a(context, obj.toString(), "", LaunchAAUI.this.getString(R.string.ed6), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass28.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(213054);
                                Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                                AppMethodBeat.o(213054);
                            }
                        });
                    } else if (obj != null && (obj instanceof com.tencent.mm.protocal.protobuf.ab)) {
                        i.a(LaunchAAUI.this.getContext(), (com.tencent.mm.protocal.protobuf.ab) obj);
                    } else if (obj == null || !(obj instanceof com.tencent.mm.protocal.protobuf.a)) {
                        Toast.makeText(context, (int) R.string.ed4, 1).show();
                    } else {
                        final com.tencent.mm.protocal.protobuf.a aVar = (com.tencent.mm.protocal.protobuf.a) obj;
                        String str = aVar.dQx;
                        String str2 = aVar.lHA;
                        String str3 = aVar.lHB;
                        d.a aVar2 = new d.a(context);
                        aVar2.boo(str);
                        aVar2.bou(str3).c(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass28.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(213055);
                                f.p(LaunchAAUI.this.getContext(), aVar.qwt, false);
                                AppMethodBeat.o(213055);
                            }
                        });
                        aVar2.bov(str2);
                        aVar2.hbn().show();
                    }
                    h.INSTANCE.a(13722, 10);
                    AppMethodBeat.o(213056);
                }
            });
            h.INSTANCE.a(13723, 2, Integer.valueOf(i.SA(this.chatroomName).size()), Integer.valueOf(arrayList.size() + 1), Long.valueOf(j2), str4, Util.listToString(arrayList2, ","));
            AppMethodBeat.o(63685);
        } catch (Exception e2) {
            Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByPerson error: %s", e2.getMessage());
            AppMethodBeat.o(63685);
        }
    }

    private void b(final Context context, final String str, String str2, String str3) {
        AppMethodBeat.i(213073);
        Log.i("MicroMsg.Aa.LaunchAAUI", "launchAAByPersonCustomize");
        ((com.tencent.mm.pluginsdk.wallet.b) g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(7, 5);
        h.INSTANCE.a(13721, 8, 2);
        HashMap hashMap = new HashMap();
        try {
            String obj = this.jXa.getText().toString();
            if (Util.isNullOrNil(obj)) {
                obj = getString(R.string.ed0);
            }
            hashMap.put(l.jSJ, obj);
            hashMap.put(l.jSN, str);
            hashMap.put(l.jSQ, Long.valueOf(this.timestamp));
            hashMap.put(l.jSR, str2);
            hashMap.put(l.jSS, str3);
            if (bmE()) {
                hashMap.put(l.jST, this.jWm);
            }
            this.jWX.jUc.H(hashMap).f(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.vending.j.d<Boolean, String, Long>>() {
                /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass31 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(com.tencent.mm.vending.j.d<Boolean, String, Long> dVar) {
                    AppMethodBeat.i(213061);
                    com.tencent.mm.vending.j.d<Boolean, String, Long> dVar2 = dVar;
                    Log.d("MicroMsg.Aa.LaunchAAUI", "finish launch aa, result: %s", dVar2.get(0));
                    if (LaunchAAUI.this.jUV != null) {
                        LaunchAAUI.this.jUV.dismiss();
                    }
                    if (((Boolean) dVar2.get(0)).booleanValue()) {
                        LaunchAAUI.c(LaunchAAUI.this, str);
                        Toast.makeText(context, (int) R.string.edk, 1).show();
                        h.INSTANCE.a(13722, 9);
                        ((u) g.af(u.class)).Dv(str);
                    } else {
                        Toast.makeText(context, (int) R.string.ed4, 1).show();
                        h.INSTANCE.a(13722, 10);
                    }
                    Void r0 = QZL;
                    AppMethodBeat.o(213061);
                    return r0;
                }
            }).a(new d.a() {
                /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass30 */

                @Override // com.tencent.mm.vending.g.d.a
                public final void cn(Object obj) {
                    AppMethodBeat.i(213060);
                    Log.i("MicroMsg.Aa.LaunchAAUI", "onInterrupt: %s", obj);
                    if (LaunchAAUI.this.jUV != null) {
                        LaunchAAUI.this.jUV.dismiss();
                    }
                    if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                        com.tencent.mm.ui.base.h.a(context, obj.toString(), "", LaunchAAUI.this.getString(R.string.ed6), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass30.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(213058);
                                Log.i("MicroMsg.Aa.LaunchAAUI", "onDialogClick()");
                                AppMethodBeat.o(213058);
                            }
                        });
                    } else if (obj != null && (obj instanceof com.tencent.mm.protocal.protobuf.ab)) {
                        i.a(LaunchAAUI.this.getContext(), (com.tencent.mm.protocal.protobuf.ab) obj);
                    } else if (obj == null || !(obj instanceof com.tencent.mm.protocal.protobuf.a)) {
                        Toast.makeText(context, (int) R.string.ed4, 1).show();
                    } else {
                        final com.tencent.mm.protocal.protobuf.a aVar = (com.tencent.mm.protocal.protobuf.a) obj;
                        String str = aVar.dQx;
                        String str2 = aVar.lHA;
                        String str3 = aVar.lHB;
                        d.a aVar2 = new d.a(context);
                        aVar2.boo(str);
                        aVar2.bou(str3).c(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass30.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(213059);
                                f.p(LaunchAAUI.this.getContext(), aVar.qwt, false);
                                AppMethodBeat.o(213059);
                            }
                        });
                        aVar2.bov(str2);
                        aVar2.hbn().show();
                    }
                    h.INSTANCE.a(13722, 10);
                    AppMethodBeat.o(213060);
                }
            });
            AppMethodBeat.o(213073);
        } catch (Exception e2) {
            Log.e("MicroMsg.Aa.LaunchAAUI", "launchAAByPersonCustomize error: %s", e2.getMessage());
            AppMethodBeat.o(213073);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ayc;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(63686);
        super.onStop();
        if (this.jXC != null) {
            this.jXC.clear();
        }
        AppMethodBeat.o(63686);
    }

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(63687);
        super.onDestroy();
        if (bmE() && this.jXP != null) {
            this.jXP.dead();
        }
        AppMethodBeat.o(63687);
    }

    private void bmS() {
        AppMethodBeat.i(63688);
        if (!this.jWZ || this.jXJ) {
            if (!this.jWF || this.jXJ) {
                if (!this.jWZ && !this.jWF) {
                    bmP();
                }
                AppMethodBeat.o(63688);
                return;
            }
            SE(getString(R.string.ed9, new Object[]{Float.valueOf(((float) com.tencent.mm.plugin.aa.model.e.bmh()) / 100.0f)}));
            AppMethodBeat.o(63688);
        } else if (this.mode == a.jRJ) {
            SE(getString(R.string.ecq, new Object[]{Integer.valueOf(com.tencent.mm.plugin.aa.model.e.bmg())}));
            AppMethodBeat.o(63688);
        } else {
            SE(getString(R.string.ecq, new Object[]{Integer.valueOf(com.tencent.mm.plugin.aa.model.e.bmf())}));
            AppMethodBeat.o(63688);
        }
    }

    private void bmT() {
        AppMethodBeat.i(63689);
        if (this.jXB == null || this.jXB.size() <= 0) {
            this.jXy.setText(R.string.ecw);
            this.jXy.setTextColor(getResources().getColor(R.color.ao));
            int dimension = (int) getResources().getDimension(R.dimen.la);
            this.jXA.setPadding(dimension, dimension, dimension, dimension);
            this.jXA.setBackgroundResource(R.drawable.a9u);
            this.jXu.setVisibility(8);
        } else {
            this.jXy.setText(getString(R.string.ecx, new Object[]{Integer.valueOf(this.jXB.size())}));
            this.jXy.setTextColor(getResources().getColor(R.color.a2x));
            int dimension2 = (int) getResources().getDimension(R.dimen.la);
            getResources().getDimension(R.dimen.l8);
            getResources().getDimension(R.dimen.l9);
            this.jXA.setPadding(dimension2, dimension2, dimension2, dimension2);
            this.jXA.setBackgroundResource(R.drawable.a9r);
            this.jXu.setVisibility(0);
        }
        this.jXu.removeAllViews();
        this.jXC.clear();
        if (this.jXB != null && this.jXB.size() > 0) {
            int i2 = 0;
            for (String str : this.jXB.keySet()) {
                double doubleValue = this.jXB.get(str).doubleValue();
                LaunchAAByPersonNameAmountRow launchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
                if (i2 >= this.jXB.size() - 1) {
                    launchAAByPersonNameAmountRow.setDividerVisible(false);
                }
                launchAAByPersonNameAmountRow.a(str, this.chatroomName, doubleValue);
                this.jXu.addView(launchAAByPersonNameAmountRow);
                this.jXC.put(str, launchAAByPersonNameAmountRow);
                i2++;
            }
        }
        if (this.jWj != null) {
            this.jWj.requestLayout();
            g(this.jXw, this.jXx);
        }
        this.jXI = 0;
        this.jXm.post(new Runnable() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass32 */

            public final void run() {
            }
        });
        AppMethodBeat.o(63689);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4;
        AppMethodBeat.i(63690);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.Aa.LaunchAAUI", "onActivityResult requestCode:%s", Integer.valueOf(i2));
        if (i2 == 233) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (this.mode == a.jRJ) {
                    if (!Util.isNullOrNil(stringExtra)) {
                        String[] split = stringExtra.split(",");
                        this.jXs.clear();
                        this.jXs.addAll(Arrays.asList(split));
                    }
                    List<String> SA = i.SA(this.chatroomName);
                    if (SA == null || this.jXs == null || this.jXs.size() != SA.size() || !ab.Eq(this.chatroomName)) {
                        TextView textView = this.jXp;
                        Object[] objArr = new Object[1];
                        if (this.jXs != null) {
                            i4 = this.jXs.size();
                        } else {
                            i4 = 0;
                        }
                        objArr[0] = Integer.valueOf(i4);
                        textView.setText(getString(R.string.ecf, objArr));
                    } else {
                        TextView textView2 = this.jXp;
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = Integer.valueOf(this.jXs != null ? this.jXs.size() : 0);
                        textView2.setText(getString(R.string.ec_, objArr2));
                    }
                }
                bmP();
                if (this.jXs == null || this.jXs.size() <= com.tencent.mm.plugin.aa.model.e.bmg()) {
                    this.jWZ = false;
                } else {
                    this.jWZ = true;
                }
                double d2 = Util.getDouble(this.jXn.getText(), 0.0d);
                if (this.jXs == null || (d2 * 100.0d) / ((double) this.jXs.size()) <= ((double) com.tencent.mm.plugin.aa.model.e.bmh())) {
                    this.jWF = false;
                } else {
                    this.jWF = true;
                    h.INSTANCE.a(13722, 2);
                }
                bmQ();
                bmR();
                bmS();
                AppMethodBeat.o(63690);
                return;
            }
        } else if (i2 == 236) {
            if (i3 == -1) {
                try {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("selectUI");
                    this.jXB.clear();
                    if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                        Iterator<String> it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            String[] split2 = it.next().split(",");
                            this.jXB.put(split2[0], Double.valueOf(Util.getDouble(split2[1], 0.0d)));
                        }
                    }
                    bmL();
                    AppMethodBeat.o(63690);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.Aa.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", e2.getMessage());
                    AppMethodBeat.o(63690);
                    return;
                }
            }
        } else if (i2 == 300) {
            if (i3 == -1 && intent != null) {
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_image_list");
                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                    String i5 = com.tencent.mm.ui.tools.a.i(this, intent, com.tencent.mm.plugin.image.d.aSY());
                    if (!Util.isNullOrNil(i5)) {
                        this.imagePath = i5;
                    }
                } else {
                    this.imagePath = stringArrayListExtra2.get(0);
                }
                if (!Util.isNullOrNil(this.imagePath)) {
                    this.jUB = 2;
                    this.jXk.setVisibility(0);
                    this.jXi.setVisibility(8);
                    this.jXj.setVisibility(8);
                    MMBitmapFactory.decodeFile(this.imagePath);
                    this.jXk.post(new Runnable() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass33 */

                        public final void run() {
                            AppMethodBeat.i(213062);
                            Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(LaunchAAUI.this.imagePath, LaunchAAUI.this.jXk.getWidth(), LaunchAAUI.this.jXk.getHeight());
                            int orientationInDegree = Exif.fromFile(LaunchAAUI.this.imagePath).getOrientationInDegree();
                            Bitmap rotate = BitmapUtil.rotate(decodeFileWithSample, (float) orientationInDegree);
                            Log.i("MicroMsg.Aa.LaunchAAUI", "exifPath : %s degree : %d", LaunchAAUI.this.imagePath, Integer.valueOf(orientationInDegree));
                            LaunchAAUI.this.jXk.setImageBitmap(rotate);
                            AppMethodBeat.o(213062);
                        }
                    });
                    uZ(8);
                }
                Log.i("MicroMsg.Aa.LaunchAAUI", "SELECT_IMAGE_REQUEST_CODE imagePath:%s", this.imagePath);
            }
            if (this.jXk.getVisibility() == 0) {
                this.jXh.setClickable(false);
                AppMethodBeat.o(63690);
                return;
            }
            this.jXh.setClickable(true);
            AppMethodBeat.o(63690);
            return;
        } else if (i2 == 310) {
            if (i3 == -1) {
                this.jUB = 2;
                this.imagePath = "";
                this.jXk.setVisibility(8);
                this.jXi.setVisibility(0);
                this.jXj.setVisibility(0);
                uZ(7);
            }
            if (this.jXk.getVisibility() == 0) {
                this.jXh.setClickable(false);
                AppMethodBeat.o(63690);
                return;
            }
            this.jXh.setClickable(true);
        }
        AppMethodBeat.o(63690);
    }

    private void y(ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> arrayList) {
        AppMethodBeat.i(213074);
        this.jXB.clear();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> it = arrayList.iterator();
            while (it.hasNext()) {
                NetSceneNewAAQueryPFInfo.AALaunchItemParcel next = it.next();
                this.jXB.put(next.username, Double.valueOf(((double) next.eht) / 100.0d));
            }
        }
        AppMethodBeat.o(213074);
    }

    public final void uZ(int i2) {
        AppMethodBeat.i(63691);
        if (bmE()) {
            i.uZ(i2);
        }
        AppMethodBeat.o(63691);
    }

    public static MultiProcessMMKV getKV() {
        AppMethodBeat.i(258560);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("aa_pay");
        AppMethodBeat.o(258560);
        return mmkv;
    }

    public static boolean SG(String str) {
        AppMethodBeat.i(63693);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(63693);
            return false;
        }
        boolean aS = aS(i.SA(str));
        AppMethodBeat.o(63693);
        return aS;
    }

    private static boolean aS(List<String> list) {
        boolean z;
        AppMethodBeat.i(63694);
        if (list == null) {
            AppMethodBeat.o(63694);
            return false;
        }
        Iterator<String> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (Util.isEqual(it.next(), z.aTY())) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        AppMethodBeat.o(63694);
        return z;
    }

    private List<String> bmU() {
        AppMethodBeat.i(213076);
        ArrayList arrayList = new ArrayList();
        List<String> SA = i.SA(this.chatroomName);
        if (SA != null && SA.size() > 0) {
            for (String str : SA) {
                if (!as.bjp(str)) {
                    arrayList.add(str);
                }
            }
        }
        AppMethodBeat.o(213076);
        return arrayList;
    }

    private boolean SH(String str) {
        AppMethodBeat.i(213077);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str, options);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            Log.i("MicroMsg.Aa.LaunchAAUI", "bitmap width： %s , height： %s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
            if (options.outWidth <= 4 || options.outHeight <= 4) {
                Log.i("MicroMsg.Aa.LaunchAAUI", "dont handle：sizeOption.outWidth <= MIN_IMAGE_SIZE || sizeOption.outHeight <= MIN_IMAGE_SIZE");
                AppMethodBeat.o(213077);
                return false;
            } else if (options.outWidth * options.outHeight < 5242880) {
                Log.i("MicroMsg.Aa.LaunchAAUI", "dont handle：sizeOption.outWidth * sizeOption.outHeight * 2 < MAX_BITMAP_SIZE");
                AppMethodBeat.o(213077);
                return false;
            } else {
                int i2 = (options.outWidth * options.outHeight) / 5242880;
                options2.inSampleSize = i2;
                Log.i("MicroMsg.Aa.LaunchAAUI", "need handle：bitmap too large sample:%s", Integer.valueOf(i2));
                Bitmap rotate = BitmapUtil.rotate(BitmapUtil.decodeFile(str, options2), (float) Exif.fromFile(str).getOrientationInDegree());
                if (s.YS(bmV())) {
                    s.deleteFile(bmV());
                }
                BitmapUtil.saveBitmapToImage(rotate, 80, Bitmap.CompressFormat.JPEG, bmV(), true);
                AppMethodBeat.o(213077);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.Aa.LaunchAAUI", "decode file to bitmap error! " + e2.getMessage());
        }
    }

    public final String bmV() {
        AppMethodBeat.i(213078);
        String z = aa.z(new o(getContext().getCacheDir() + "/aaTempPho", "aa_share_bitmap.jpg").her());
        AppMethodBeat.o(213078);
        return z;
    }

    private void bmW() {
        AppMethodBeat.i(213079);
        if (bmE()) {
            Log.i("MicroMsg.Aa.LaunchAAUI", "fromThirdParty(),user launch by person mode");
            this.mode = a.jRK;
            this.jWY = 5;
            AppMethodBeat.o(213079);
        } else if (bmJ()) {
            Log.i("MicroMsg.Aa.LaunchAAUI", "fromOrderDetail(),user launch by money mode");
            this.mode = a.jRJ;
            AppMethodBeat.o(213079);
        } else {
            int bmi = com.tencent.mm.plugin.aa.model.e.bmi();
            Log.i("MicroMsg.Aa.LaunchAAUI", "defaultMode is ：%s", Integer.valueOf(bmi));
            switch (bmi) {
                case 1:
                    this.mode = a.jRK;
                    this.jWY = 4;
                    break;
                case 2:
                default:
                    this.mode = a.jRJ;
                    break;
                case 3:
                    this.mode = a.jRK;
                    this.jWY = 5;
                    break;
            }
            if (!bmX() && this.mode == a.jRK) {
                Log.i("MicroMsg.Aa.LaunchAAUI", "!isOpenAAPayCustomize() && mode == AAConstants.MODE_LAUNCH_BY_PERSON");
                this.jWY = 5;
                AppMethodBeat.o(213079);
            } else if (this.mode != a.jRK || !bmE()) {
                AppMethodBeat.o(213079);
            } else {
                Log.i("MicroMsg.Aa.LaunchAAUI", "mode == AAConstants.MODE_LAUNCH_BY_PERSON && fromThirdParty()");
                this.jWY = 5;
                AppMethodBeat.o(213079);
            }
        }
    }

    private static boolean bmX() {
        AppMethodBeat.i(213080);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_aapay_customize_open_config, false);
        Log.i("MicroMsg.Aa.LaunchAAUI", "aaPayCustomizeOpen switch is ：%s", Boolean.valueOf(a2));
        AppMethodBeat.o(213080);
        return a2;
    }

    private void g(final View view, final View view2) {
        AppMethodBeat.i(213081);
        this.jXu.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass40 */

            public final void run() {
                AppMethodBeat.i(213068);
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) LaunchAAUI.this.getContext(), 48);
                int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) LaunchAAUI.this.getContext(), 64);
                int fromDPToPix3 = com.tencent.mm.cb.a.fromDPToPix((Context) LaunchAAUI.this.getContext(), 96);
                if (LaunchAAUI.a(LaunchAAUI.this, view2)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.removeRule(12);
                    layoutParams.addRule(3, R.id.it3);
                    layoutParams.topMargin = fromDPToPix;
                    view.setLayoutParams(layoutParams);
                    AppMethodBeat.o(213068);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams2.removeRule(3);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = fromDPToPix3;
                view.setLayoutParams(layoutParams2);
                if (LaunchAAUI.h(view, view2) >= fromDPToPix) {
                    AppMethodBeat.o(213068);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams2.removeRule(3);
                layoutParams3.addRule(12);
                layoutParams3.bottomMargin = fromDPToPix2;
                view.setLayoutParams(layoutParams3);
                if (LaunchAAUI.h(view, view2) >= fromDPToPix) {
                    AppMethodBeat.o(213068);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams4.removeRule(12);
                layoutParams4.addRule(3, R.id.it3);
                layoutParams4.topMargin = fromDPToPix;
                view.setLayoutParams(layoutParams4);
                AppMethodBeat.o(213068);
            }
        }, 100);
        AppMethodBeat.o(213081);
    }

    static /* synthetic */ void d(LaunchAAUI launchAAUI) {
        int size;
        String str;
        boolean z;
        AppMethodBeat.i(63697);
        if (launchAAUI.bmE()) {
            final ArrayList<String> arrayList = new ArrayList<>();
            if (launchAAUI.jXN.jTC != null) {
                int size2 = launchAAUI.jXN.jTC.jTF.size() + launchAAUI.jXN.jTC.jTG.size();
                if (size2 == 1) {
                    if (launchAAUI.jXN.jTC.jTF.size() == 1) {
                        g.aAi();
                        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(launchAAUI.jXN.jTC.jTF.get(0));
                        if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                            launchAAUI.x(arrayList);
                            AppMethodBeat.o(63697);
                            return;
                        }
                        launchAAUI.SF(launchAAUI.jXN.jTC.jTF.get(0));
                        AppMethodBeat.o(63697);
                        return;
                    } else if (launchAAUI.jXN.jTC.jTG.size() == 1) {
                        List<String> SA = i.SA(launchAAUI.jXN.jTC.jTG.get(0));
                        if (launchAAUI.mode == a.jRJ) {
                            Iterator<String> it = launchAAUI.jXs.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!SA.contains(it.next())) {
                                        z = false;
                                        break;
                                    }
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                        } else {
                            if (launchAAUI.mode == a.jRK) {
                                Iterator<String> it2 = launchAAUI.jXB.keySet().iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (!SA.contains(it2.next())) {
                                            z = false;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            z = true;
                        }
                        boolean aS = aS(SA);
                        if (!z || !aS) {
                            if (aS) {
                                arrayList.add(launchAAUI.jXN.jTC.jTG.get(0));
                            }
                            launchAAUI.x(arrayList);
                            AppMethodBeat.o(63697);
                            return;
                        }
                        launchAAUI.SF(launchAAUI.jXN.jTC.jTG.get(0));
                        AppMethodBeat.o(63697);
                        return;
                    } else {
                        Log.e("MicroMsg.Aa.LaunchAAUI", "num == 1 ?????");
                        AppMethodBeat.o(63697);
                        return;
                    }
                } else if (size2 > 1) {
                    arrayList.addAll(launchAAUI.jXN.jTC.jTG);
                    arrayList.addAll(launchAAUI.jXN.jTC.jTF);
                } else {
                    if (launchAAUI.mode == a.jRJ) {
                        size = launchAAUI.jXs.size();
                    } else {
                        size = launchAAUI.jXB.size();
                    }
                    if (size == 1) {
                        String str2 = "";
                        if (launchAAUI.jXB.size() == 1) {
                            Iterator<String> it3 = launchAAUI.jXB.keySet().iterator();
                            while (it3.hasNext()) {
                                str2 = it3.next();
                            }
                            str = str2;
                        } else {
                            str = launchAAUI.jXs.get(0);
                        }
                        g.aAi();
                        as Kn2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                        if (Kn2 != null && com.tencent.mm.contact.c.oR(Kn2.field_type)) {
                            arrayList.add(str);
                        }
                        launchAAUI.x(arrayList);
                        AppMethodBeat.o(63697);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (launchAAUI.mode == a.jRJ) {
                        for (String str3 : launchAAUI.jXs) {
                            g.aAi();
                            as Kn3 = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str3);
                            if (Kn3 != null) {
                                sb.append(Kn3.field_nickname).append(" ");
                            }
                        }
                    } else if (launchAAUI.mode == a.jRK) {
                        for (String str4 : launchAAUI.jXB.keySet()) {
                            g.aAi();
                            as Kn4 = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str4);
                            if (Kn4 != null) {
                                sb.append(Kn4.field_nickname).append(" ");
                            }
                        }
                    }
                    final String sb2 = sb.toString();
                    com.tencent.mm.plugin.fts.a.a.j a2 = com.tencent.mm.plugin.fts.a.a.j.a(sb2, new int[]{131075}, null, 5, new HashSet(), com.tencent.mm.plugin.fts.a.c.b.wXy, new com.tencent.mm.plugin.fts.a.l() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.fts.a.l
                        public final void b(k kVar) {
                            AppMethodBeat.i(213022);
                            if (LaunchAAUI.this.tipDialog != null && LaunchAAUI.this.tipDialog.isShowing()) {
                                LaunchAAUI.this.tipDialog.dismiss();
                            }
                            LaunchAAUI.this.jXO = false;
                            arrayList.clear();
                            switch (kVar.resultCode) {
                                case -3:
                                case -2:
                                case -1:
                                    Log.i("MicroMsg.Aa.LaunchAAUI", "onSearchError: errorCode=%d | originQuery=%s", Integer.valueOf(kVar.resultCode), kVar.wTn.query);
                                    if (!kVar.wTn.query.equals(sb2)) {
                                        Log.i("MicroMsg.Aa.LaunchAAUI", "Native Search: Not Same Query");
                                        AppMethodBeat.o(213022);
                                        return;
                                    }
                                    break;
                                case 0:
                                    Log.i("MicroMsg.Aa.LaunchAAUI", "search result %d", Integer.valueOf(kVar.wXb.size()));
                                    if (sb2 != null && sb2.equals(kVar.wTn.query)) {
                                        if (kVar.wXb != null && kVar.wXb.size() > 0) {
                                            for (m mVar : kVar.wXb) {
                                                if (LaunchAAUI.SG(mVar.wVX)) {
                                                    arrayList.add(mVar.wVX);
                                                }
                                            }
                                            break;
                                        }
                                    } else {
                                        Log.i("MicroMsg.Aa.LaunchAAUI", "Native Search: Not Same query origin:%s current:%s", kVar.wTn.query, sb2);
                                        AppMethodBeat.o(213022);
                                        return;
                                    }
                                    break;
                            }
                            LaunchAAUI.a(LaunchAAUI.this, arrayList);
                            AppMethodBeat.o(213022);
                        }
                    }, new MMHandler(Looper.getMainLooper()));
                    a2.kXb = 96;
                    a2.wWY = com.tencent.mm.plugin.fts.a.c.a.wXx;
                    final com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(2, a2);
                    launchAAUI.jXO = true;
                    if (launchAAUI.tipDialog == null) {
                        launchAAUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) launchAAUI, 3, (int) R.style.lj, launchAAUI.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass3 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(213023);
                                if (LaunchAAUI.this.tipDialog != null && LaunchAAUI.this.tipDialog.isShowing()) {
                                    LaunchAAUI.this.tipDialog.dismiss();
                                }
                                ((n) g.ah(n.class)).cancelSearchTask(search);
                                LaunchAAUI.this.jXO = false;
                                AppMethodBeat.o(213023);
                            }
                        });
                    } else {
                        launchAAUI.tipDialog.show();
                    }
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(213024);
                            if (LaunchAAUI.this.jXO) {
                                if (LaunchAAUI.this.tipDialog != null && LaunchAAUI.this.tipDialog.isShowing()) {
                                    LaunchAAUI.this.tipDialog.dismiss();
                                }
                                ((n) g.ah(n.class)).cancelSearchTask(search);
                                LaunchAAUI.this.jXO = false;
                                arrayList.clear();
                                LaunchAAUI.a(LaunchAAUI.this, arrayList);
                            }
                            AppMethodBeat.o(213024);
                        }
                    }, 3000);
                    AppMethodBeat.o(63697);
                    return;
                }
            }
            launchAAUI.x(arrayList);
            AppMethodBeat.o(63697);
            return;
        }
        launchAAUI.SF(launchAAUI.chatroomName);
        AppMethodBeat.o(63697);
    }

    static /* synthetic */ void h(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(213083);
        Intent intent = new Intent(launchAAUI, LaunchAAByPersonAmountSelectUI.class);
        intent.putExtra("chatroom", launchAAUI.chatroomName);
        intent.putExtra("maxPerAmount", com.tencent.mm.plugin.aa.model.e.bmh());
        intent.putExtra("enter_scene", launchAAUI.scene);
        if (launchAAUI.jXB != null && launchAAUI.jXB.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : launchAAUI.jXB.keySet()) {
                arrayList.add(str + "," + launchAAUI.jXB.get(str).doubleValue());
            }
            intent.putStringArrayListExtra("oldAmountData", arrayList);
        }
        if (launchAAUI.bmE() && launchAAUI.jXN.jTA != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> it = launchAAUI.jXN.jTA.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().username);
            }
            intent.putStringArrayListExtra("third_party_usernamelist", arrayList2);
        }
        intent.putExtra("maxUserNumber", com.tencent.mm.plugin.aa.model.e.bmf());
        launchAAUI.startActivityForResult(intent, 236);
        h.INSTANCE.a(13721, 3, 2);
        AppMethodBeat.o(213083);
    }

    static /* synthetic */ void z(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(213090);
        final com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) launchAAUI.getContext(), 1, false);
        final View inflate = launchAAUI.getLayoutInflater().inflate(R.layout.ayb, (ViewGroup) null);
        ao.a(((TextView) inflate.findViewById(R.id.e88)).getPaint(), 0.8f);
        ((ImageView) inflate.findViewById(R.id.xv)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass35 */

            public final void onClick(View view) {
                AppMethodBeat.i(213063);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                eVar.bMo();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213063);
            }
        });
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.e8_);
        ((ViewGroup) inflate.findViewById(R.id.e89)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass36 */

            public final void onClick(View view) {
                AppMethodBeat.i(213064);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Aa.LaunchAAUI", "choose aa mdoe");
                if (imageView.getVisibility() == 8) {
                    imageView.setVisibility(0);
                }
                LaunchAAUI.this.mode = a.jRJ;
                LaunchAAUI.v(LaunchAAUI.this);
                eVar.bMo();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213064);
            }
        });
        final ImageView imageView2 = (ImageView) inflate.findViewById(R.id.e8b);
        ((ViewGroup) inflate.findViewById(R.id.e8a)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass37 */

            public final void onClick(View view) {
                AppMethodBeat.i(213065);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Aa.LaunchAAUI", "choose aaByPerson mdoe");
                if (imageView2.getVisibility() == 8) {
                    imageView2.setVisibility(0);
                }
                LaunchAAUI.this.mode = a.jRK;
                LaunchAAUI.this.jWY = 5;
                LaunchAAUI.v(LaunchAAUI.this);
                eVar.bMo();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213065);
            }
        });
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.e8c);
        View findViewById = inflate.findViewById(R.id.e8d);
        final ImageView imageView3 = (ImageView) inflate.findViewById(R.id.e8e);
        if (!bmX() || launchAAUI.bmE()) {
            Log.i("MicroMsg.Aa.LaunchAAUI", "!isOpenAAPayCustomize() || fromThirdParty()，dont show cumstomize");
            viewGroup.setVisibility(8);
            findViewById.setVisibility(8);
        }
        viewGroup.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass38 */

            public final void onClick(View view) {
                AppMethodBeat.i(213066);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Aa.LaunchAAUI", "choose aaByPersonMember mdoe");
                if (imageView3.getVisibility() == 8) {
                    imageView3.setVisibility(0);
                }
                LaunchAAUI.this.mode = a.jRK;
                LaunchAAUI.this.jWY = 4;
                LaunchAAUI.v(LaunchAAUI.this);
                eVar.bMo();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213066);
            }
        });
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.aa.ui.LaunchAAUI.AnonymousClass39 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(213067);
                mVar.clear();
                eVar.setFooterView(null);
                eVar.setFooterView(inflate);
                AppMethodBeat.o(213067);
            }
        };
        if (launchAAUI.mode == a.jRJ) {
            h.INSTANCE.a(13721, 2, 1);
            imageView.setVisibility(0);
            imageView2.setVisibility(4);
            imageView3.setVisibility(4);
        } else if (launchAAUI.jWY == 4) {
            h.INSTANCE.a(13721, 8, 1);
            imageView.setVisibility(4);
            imageView2.setVisibility(4);
            imageView3.setVisibility(0);
        } else {
            h.INSTANCE.a(13721, 3, 1);
            imageView.setVisibility(4);
            imageView2.setVisibility(0);
            imageView3.setVisibility(4);
        }
        eVar.Dm(true);
        eVar.dGm();
        AppMethodBeat.o(213090);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, List list) {
        long min;
        AppMethodBeat.i(213093);
        Intent intent = new Intent(launchAAUI, AASelectContactUI.class);
        intent.putExtra("titile", launchAAUI.getString(R.string.edj));
        intent.putExtra("list_type", 12);
        intent.putExtra("chatroomName", launchAAUI.chatroomName);
        intent.putExtra("enter_scene", launchAAUI.scene);
        if (list != null) {
            intent.putExtra("already_select_contact", Util.listToString(list, ","));
        }
        if (launchAAUI.bmE() && launchAAUI.jXN.jTA != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> it = launchAAUI.jXN.jTA.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().username);
            }
            intent.putStringArrayListExtra("third_party_usernamelist", arrayList);
        }
        if (launchAAUI.bmE()) {
            min = (long) launchAAUI.jXN.jTA.size();
        } else if (ab.Eq(launchAAUI.chatroomName)) {
            min = (long) Math.min(com.tencent.mm.plugin.aa.model.e.bmg(), v.Ie(launchAAUI.chatroomName));
        } else {
            min = (long) Math.min(com.tencent.mm.plugin.aa.model.e.bmg(), 2);
        }
        intent.putExtra("max_select_num", min);
        intent.putExtra("select_type", 1);
        launchAAUI.startActivityForResult(intent, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
        h.INSTANCE.a(13721, 2, 2);
        AppMethodBeat.o(213093);
    }

    static /* synthetic */ void b(LaunchAAUI launchAAUI, String str) {
        AppMethodBeat.i(213094);
        launchAAUI.a((Context) launchAAUI, str, false, new ArrayList<>());
        AppMethodBeat.o(213094);
    }

    static /* synthetic */ void c(LaunchAAUI launchAAUI, String str) {
        AppMethodBeat.i(213098);
        if (!launchAAUI.bmE()) {
            str = launchAAUI.getIntent().getStringExtra("chatroom_name");
        }
        Log.i("MicroMsg.Aa.LaunchAAUI", "[goToChattingUI] username:%s", str);
        Intent putExtra = new Intent().putExtra("Main_User", str);
        putExtra.putExtra("From_fail_notify", true);
        putExtra.addFlags(67108864);
        putExtra.addFlags(536870912);
        c.f(launchAAUI, "com.tencent.mm.ui.LauncherUI", putExtra);
        AppMethodBeat.o(213098);
    }

    static /* synthetic */ boolean a(LaunchAAUI launchAAUI, View view) {
        AppMethodBeat.i(213099);
        int i2 = au.az(launchAAUI.getContext()).y;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height = iArr[1] + view.getHeight();
        Log.d("MicroMsg.Aa.LaunchAAUI", "viewY is ：%s ；ScreenHeight is ：%s", Integer.valueOf(height), Integer.valueOf(i2));
        if (height > (i2 * 2) / 3) {
            AppMethodBeat.o(213099);
            return true;
        }
        AppMethodBeat.o(213099);
        return false;
    }

    static /* synthetic */ int h(View view, View view2) {
        AppMethodBeat.i(213100);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        view2.getLocationOnScreen(iArr2);
        int height = iArr2[1] + view2.getHeight();
        int i3 = i2 - height;
        Log.d("MicroMsg.Aa.LaunchAAUI", "bottomViewY is ：%s ； aboveViewY is ：%s", Integer.valueOf(i2), Integer.valueOf(height));
        Log.d("MicroMsg.Aa.LaunchAAUI", "marginTop is ：%s", Integer.valueOf(i3));
        AppMethodBeat.o(213100);
        return i3;
    }
}
