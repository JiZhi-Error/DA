package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SightUploadUI extends MMActivity {
    private int Etj = 0;
    private int Etq = 0;
    private int Etr = 0;
    private String EvA = "";
    private SnsEditText EvZ;
    private String Evz = "";
    private ad Ewa = null;
    private LinearLayout Ewb;
    private SnsSightUploadSayFooter Ewc;
    private ArrayList<String> Ewd;
    private boolean Ewe = false;
    private boolean Ewf = false;
    private long Ewg = 0;
    DisplayMetrics Ewh;
    private String desc = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98280);
        h.q(this);
        super.onCreate(bundle);
        this.Ewh = getResources().getDisplayMetrics();
        this.Ewa = new au(this);
        this.Ewa.aC(bundle);
        this.Ewb = (LinearLayout) findViewById(R.id.jnw);
        this.Ewb.addView(this.Ewa.ffB());
        setMMTitle(R.string.hbf);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.fm));
        this.Ewf = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.Ewg = getIntent().getLongExtra("KTouchCameraTime", 0);
        initView();
        h.r(this);
        AppMethodBeat.o(98280);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bx8;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(98281);
        this.EvZ = (SnsEditText) findViewById(R.id.hxn);
        final int paddingLeft = this.Ewh.widthPixels - (this.EvZ.getPaddingLeft() + this.Ewb.getPaddingRight());
        this.EvZ.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SightUploadUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(98272);
                SightUploadUI.this.EvZ.setWidth((int) (((double) paddingLeft) * 0.7d));
                SightUploadUI.this.Ewb.setLayoutParams(new LinearLayout.LayoutParams((int) (((double) paddingLeft) * 0.3d), SightUploadUI.this.Ewb.getHeight()));
                AppMethodBeat.o(98272);
            }
        }, 100);
        if (!Util.isNullOrNil(getIntent().getStringExtra("Kdescription"))) {
            this.EvZ.setText(getIntent().getStringExtra("Kdescription"));
        }
        this.EvZ.setBackListener(new MMEditText.a() {
            /* class com.tencent.mm.plugin.sns.ui.SightUploadUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.MMEditText.a
            public final void onBack() {
                AppMethodBeat.i(98273);
                SightUploadUI.this.hideVKB();
                uw uwVar = new uw();
                uwVar.ebg.type = 0;
                uwVar.ebg.ebi = false;
                EventCenter.instance.publish(uwVar);
                SightUploadUI.this.finish();
                AppMethodBeat.o(98273);
            }
        });
        this.Ewc = (SnsSightUploadSayFooter) findViewById(R.id.h_i);
        this.Ewc.setMMEditText(this.EvZ);
        this.Ewc.setVisibility(0);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SightUploadUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98274);
                uw uwVar = new uw();
                uwVar.ebg.type = 0;
                uwVar.ebg.ebi = false;
                EventCenter.instance.publish(uwVar);
                SightUploadUI.this.hideVKB();
                SightUploadUI.this.finish();
                AppMethodBeat.o(98274);
                return true;
            }
        });
        if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
            addIconOptionMenu(1, R.raw.sight_draft_menu, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SightUploadUI.AnonymousClass4 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(98276);
                    com.tencent.mm.ui.base.h.a(SightUploadUI.this.getContext(), (String) null, new String[]{SightUploadUI.this.getString(R.string.h2c)}, (String) null, new h.d() {
                        /* class com.tencent.mm.plugin.sns.ui.SightUploadUI.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.h.d
                        public final void oj(int i2) {
                            AppMethodBeat.i(98275);
                            switch (i2) {
                                case 0:
                                    uw uwVar = new uw();
                                    uwVar.ebg.type = 0;
                                    uwVar.ebg.ebk = true;
                                    uwVar.ebg.ebi = true;
                                    EventCenter.instance.publish(uwVar);
                                    SightUploadUI.this.hideVKB();
                                    SightUploadUI.this.finish();
                                    break;
                            }
                            AppMethodBeat.o(98275);
                        }
                    });
                    AppMethodBeat.o(98276);
                    return false;
                }
            });
        }
        addTextOptionMenu(0, getString(R.string.yq), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SightUploadUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98279);
                if (SightUploadUI.this.isFinishing()) {
                    AppMethodBeat.o(98279);
                } else {
                    SightUploadUI.this.desc = SightUploadUI.this.EvZ.getText().toString();
                    final int pasterLen = SightUploadUI.this.EvZ.getPasterLen();
                    c.f(SightUploadUI.this.EvZ).aoq(com.tencent.mm.n.c.aqj()).CN(true).a(new c.a() {
                        /* class com.tencent.mm.plugin.sns.ui.SightUploadUI.AnonymousClass5.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.tools.b.c.a
                        public final void Tw(String str) {
                            AppMethodBeat.i(98277);
                            PInt pInt = new PInt();
                            SightUploadUI.this.Ewa.a(SightUploadUI.this.Etj, 0, null, SightUploadUI.this.desc, null, SightUploadUI.this.Ewc.getLocation(), null, pasterLen, SightUploadUI.this.Ewe, SightUploadUI.this.Ewd, pInt, "", SightUploadUI.this.Etq, SightUploadUI.this.Etr);
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            Object[] objArr = new Object[5];
                            objArr[0] = Long.valueOf(SightUploadUI.this.Ewg);
                            objArr[1] = Long.valueOf(Util.nowSecond());
                            objArr[2] = Integer.valueOf(SightUploadUI.this.Ewf ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            objArr[4] = "";
                            hVar.a(13303, objArr);
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Long.valueOf(SightUploadUI.this.Ewg);
                            objArr2[1] = Long.valueOf(Util.nowSecond());
                            objArr2[2] = Integer.valueOf(SightUploadUI.this.Ewf ? 0 : 1);
                            objArr2[3] = Integer.valueOf(pInt.value);
                            Log.d("MicroMsg.SightUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", objArr2);
                            AppMethodBeat.o(98277);
                        }

                        @Override // com.tencent.mm.ui.tools.b.c.a
                        public final void Tx(String str) {
                        }

                        @Override // com.tencent.mm.ui.tools.b.c.a
                        public final void dv(String str) {
                            AppMethodBeat.i(163078);
                            com.tencent.mm.ui.base.h.n(SightUploadUI.this, R.string.hc2, R.string.hc3);
                            AppMethodBeat.o(163078);
                        }
                    });
                    AppMethodBeat.o(98279);
                }
                return false;
            }
        }, null, t.b.BLACK);
        enableOptionMenu(true);
        AppMethodBeat.o(98281);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(98282);
        super.onResume();
        Log.d("MicroMsg.SightUploadUI", "onResume");
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.Ewc;
        if (snsSightUploadSayFooter.rum.getVisibility() == 8) {
            snsSightUploadSayFooter.gte.showVKB();
        }
        AppMethodBeat.o(98282);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98283);
        super.onDestroy();
        this.Ewa.ffE();
        this.Ewc.EJv.stop();
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.Ewc;
        if (snsSightUploadSayFooter.rum != null) {
            snsSightUploadSayFooter.rum.goC();
            snsSightUploadSayFooter.rum.destroy();
        }
        AppMethodBeat.o(98283);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(98284);
        super.onPause();
        hideVKB();
        AppMethodBeat.o(98284);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(98285);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(98285);
            return;
        }
        if (i2 == 6 || i2 == 5 || i2 == 10) {
            SnsSightUploadSayFooter snsSightUploadSayFooter = this.Ewc;
            if (intent != null) {
                if (i2 == 10) {
                    snsSightUploadSayFooter.EJv.aY(intent);
                } else if (i2 == 5) {
                    snsSightUploadSayFooter.EJu.a(i2, i3, intent, null);
                }
            }
        }
        if (i2 == 5) {
            if (intent == null) {
                AppMethodBeat.o(98285);
                return;
            }
            int intExtra = intent.getIntExtra("Ktag_range_index", 0);
            if (intExtra >= 2) {
                this.Evz = intent.getStringExtra("Klabel_name_list");
                this.EvA = intent.getStringExtra("Kother_user_name_list");
                List<String> asList = Arrays.asList(this.Evz.split(","));
                List<String> asList2 = !Util.isNullOrNil(this.EvA) ? Arrays.asList(this.EvA.split(",")) : null;
                this.Ewd = new ArrayList<>();
                if (asList != null && asList.size() > 0) {
                    Iterator it = asList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        List<String> aCK = a.ecg().aCK(a.ecg().aCH((String) it.next()));
                        if (aCK == null || aCK.size() == 0) {
                            Log.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
                        } else {
                            for (String str : aCK) {
                                if (!this.Ewd.contains(str)) {
                                    this.Ewd.add(str);
                                    Log.d("MicroMsg.SightUploadUI", "dz:name : %s", str);
                                }
                            }
                        }
                    }
                }
                if (asList != null) {
                    int i4 = 0;
                    for (String str2 : asList) {
                        if (!Util.isNullOrNil(str2)) {
                            i4++;
                        } else {
                            i4 = i4;
                        }
                    }
                    this.Etq = i4;
                }
                this.Etr = 0;
                if (asList2 != null && asList2.size() > 0) {
                    for (String str3 : asList2) {
                        if (!this.Ewd.contains(str3)) {
                            this.Ewd.add(str3);
                            this.Etr++;
                        }
                    }
                }
                if (intExtra == 2) {
                    this.Ewe = false;
                } else {
                    this.Ewe = true;
                }
            }
            if (1 == intExtra) {
                this.Etj = 1;
                AppMethodBeat.o(98285);
                return;
            }
            this.Etj = 0;
        }
        AppMethodBeat.o(98285);
    }
}
