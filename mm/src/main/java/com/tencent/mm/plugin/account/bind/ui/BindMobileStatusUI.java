package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.HashMap;
import java.util.Map;

public class BindMobileStatusUI extends MMWizardActivity {
    private Button hPX;
    private TextView hQd;
    private ImageView kaB;
    private TextView kaU;
    private ImageView kbj;
    private ImageView kbk;
    private Boolean kbl = Boolean.TRUE;
    private Boolean kbm = Boolean.TRUE;
    private RelativeLayout kbn;
    private RelativeLayout kbo;
    private BindWordingContent kbp;
    private int kbq;
    private boolean kbr;
    private boolean kbs;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Integer> kbt = new HashMap<>();
    private SparseArray<String> kbu = new SparseArray<>(3);
    private SharedPreferences sp;
    private int status;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BindMobileStatusUI() {
        AppMethodBeat.i(109926);
        AppMethodBeat.o(109926);
    }

    static /* synthetic */ boolean a(BindMobileStatusUI bindMobileStatusUI, boolean z, int i2, int i3) {
        AppMethodBeat.i(109934);
        boolean d2 = bindMobileStatusUI.d(z, i2, i3);
        AppMethodBeat.o(109934);
        return d2;
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109927);
        super.onCreate(bundle);
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = z.aUc();
        this.kbu.put(8, "settings_find_me_by_mobile");
        this.kbu.put(7, "settings_recommend_mobilefriends_to_me");
        this.kbu.put(32, "settings_autoadd_mobilefriends");
        d(false, 512, 8);
        d(false, 256, 7);
        setMMTitle(R.string.aej);
        this.kbp = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.kbq = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.kbr = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.kbs = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        initView();
        AppMethodBeat.o(109927);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ix;
    }

    private boolean d(boolean z, int i2, int i3) {
        AppMethodBeat.i(109929);
        Log.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + z + " item value = " + i2 + " functionId = " + i3);
        if (z) {
            this.status |= i2;
        } else {
            this.status &= i2 ^ -1;
        }
        this.kbt.put(Integer.valueOf(i3), Integer.valueOf(z ? 1 : 2));
        String str = this.kbu.get(i3);
        if (!(this.sp == null || str == null || str.length() <= 0)) {
            Boolean valueOf = Boolean.valueOf(z);
            if (i3 == 8 || i3 == 7) {
                valueOf = Boolean.valueOf(!z);
            }
            this.sp.edit().putBoolean(str, valueOf.booleanValue()).commit();
        }
        AppMethodBeat.o(109929);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(109930);
        this.kaB = (ImageView) findViewById(R.id.a43);
        this.hQd = (TextView) findViewById(R.id.a41);
        this.kaU = (TextView) findViewById(R.id.a40);
        this.hPX = (Button) findViewById(R.id.a42);
        this.kbj = (ImageView) findViewById(R.id.a4t);
        this.kbk = (ImageView) findViewById(R.id.a4s);
        this.kbn = (RelativeLayout) findViewById(R.id.a3x);
        this.kbo = (RelativeLayout) findViewById(R.id.a3y);
        switch (this.kbq) {
            case 0:
                this.kbn.setVisibility(8);
                this.kbo.setVisibility(8);
                if (!this.kbr) {
                    z = true;
                } else {
                    z = false;
                }
                d(z, 512, 8);
                if (this.kbs) {
                    z2 = false;
                }
                d(z2, 256, 7);
                break;
            case 1:
                this.kbn.setVisibility(0);
                this.kbn.setBackgroundResource(R.drawable.go);
                this.kbo.setVisibility(8);
                break;
        }
        if (this.kbp != null) {
            switch (this.kbp.jiW.intValue()) {
                case 2:
                    this.kaU.setVisibility(8);
                    break;
            }
        }
        this.hPX.setVisibility(8);
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109922);
                BindMobileStatusUI.a(BindMobileStatusUI.this);
                AppMethodBeat.o(109922);
                return false;
            }
        });
        if (l.bnZ() == l.a.SUCC || l.bnZ() == l.a.SUCC_UNLOAD) {
            this.kaB.setImageResource(R.drawable.baj);
            String str = (String) g.aAh().azQ().get(6, (Object) null);
            if (str == null || str.equals("")) {
                g.aAh().azQ().get(4097, (Object) null);
            }
        } else {
            this.kaB.setImageResource(R.drawable.bag);
            this.kaU.setVisibility(8);
            this.hQd.setText(getString(R.string.adf));
        }
        this.kbj.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI.AnonymousClass2 */

            public final void onClick(View view) {
                boolean z = true;
                AppMethodBeat.i(109923);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindMobileStatusUI.this.kbl = Boolean.valueOf(!BindMobileStatusUI.this.kbl.booleanValue());
                if (BindMobileStatusUI.this.kbl.booleanValue()) {
                    BindMobileStatusUI.this.kbj.setImageResource(R.raw.checkbox_selected);
                } else {
                    BindMobileStatusUI.this.kbj.setImageResource(R.drawable.p5);
                }
                BindMobileStatusUI bindMobileStatusUI = BindMobileStatusUI.this;
                if (BindMobileStatusUI.this.kbl.booleanValue()) {
                    z = false;
                }
                BindMobileStatusUI.a(bindMobileStatusUI, z, 512, 8);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109923);
            }
        });
        this.kbk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI.AnonymousClass3 */

            public final void onClick(View view) {
                boolean z = true;
                AppMethodBeat.i(109924);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindMobileStatusUI.this.kbm = Boolean.valueOf(!BindMobileStatusUI.this.kbm.booleanValue());
                if (BindMobileStatusUI.this.kbm.booleanValue()) {
                    BindMobileStatusUI.this.kbk.setImageResource(R.raw.checkbox_selected);
                } else {
                    BindMobileStatusUI.this.kbk.setImageResource(R.drawable.p5);
                }
                BindMobileStatusUI bindMobileStatusUI = BindMobileStatusUI.this;
                if (BindMobileStatusUI.this.kbm.booleanValue()) {
                    z = false;
                }
                BindMobileStatusUI.a(bindMobileStatusUI, z, 256, 7);
                if (!BindMobileStatusUI.this.kbm.booleanValue()) {
                    BindMobileStatusUI.a(BindMobileStatusUI.this, false, TPMediaCodecProfileLevel.HEVCHighTierLevel6, 32);
                }
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109924);
            }
        });
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(109925);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindMobileStatusUI.f(BindMobileStatusUI.this);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109925);
            }
        });
        AppMethodBeat.o(109930);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(109931);
        if (i2 == 4) {
            ala(1);
            AppMethodBeat.o(109931);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(109931);
        return onKeyDown;
    }

    public static void c(Context context, boolean z, boolean z2) {
        int i2;
        boolean z3 = false;
        int i3 = 1;
        AppMethodBeat.i(109932);
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().putBoolean("settings_find_me_by_mobile", !z).commit();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (!z2) {
            z3 = true;
        }
        edit.putBoolean("settings_recommend_mobilefriends_to_me", z3).commit();
        int aUc = z.aUc();
        int i4 = z ? aUc | 512 : aUc & -513;
        g.aAh().azQ().set(7, Integer.valueOf(z2 ? i4 | 256 : i4 & -257));
        bfx bfx = new bfx();
        bfx.LPB = 8;
        if (z2) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        bfx.BsD = i2;
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, bfx));
        bfx bfx2 = new bfx();
        bfx2.LPB = 7;
        if (!z) {
            i3 = 2;
        }
        bfx.BsD = i3;
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, bfx2));
        com.tencent.mm.plugin.account.a.a.jRu.WZ();
        AppMethodBeat.o(109932);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(109928);
        g.aAh().azQ().set(7, Integer.valueOf(this.status));
        for (Map.Entry<Integer, Integer> entry : this.kbt.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            bfx bfx = new bfx();
            bfx.LPB = intValue;
            bfx.BsD = intValue2;
            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, bfx));
            Log.d("MicroMsg.BindMobileStatusUI", "switch  " + intValue + " " + intValue2);
        }
        this.kbt.clear();
        super.onPause();
        AppMethodBeat.o(109928);
    }

    static /* synthetic */ void a(BindMobileStatusUI bindMobileStatusUI) {
        AppMethodBeat.i(109933);
        bindMobileStatusUI.ala(1);
        AppMethodBeat.o(109933);
    }

    static /* synthetic */ void f(BindMobileStatusUI bindMobileStatusUI) {
        AppMethodBeat.i(109935);
        bindMobileStatusUI.ala(1);
        AppMethodBeat.o(109935);
    }
}
