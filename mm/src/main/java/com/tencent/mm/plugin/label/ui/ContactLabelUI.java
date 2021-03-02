package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class ContactLabelUI extends ContactLabelBaseUI implements i {
    private String goe;
    private boolean yCB = true;
    private MMTagPanelScrollView yDa;
    private MMLabelPanel yDb;
    private TextView yDc;
    private View yDd;
    private View yDe;
    private TextView yDf;
    private MMLabelPanel yDg;
    private ListView yDh;
    private ScrollView yDi;
    private b yDj;
    private String yDk;
    private ArrayList<String> yDl;
    private HashSet<String> yDm = new HashSet<>();
    private HashSet<String> yDn = new HashSet<>();
    private ArrayList<String> yDo = new ArrayList<>();
    private a yDp = a.Normal;
    private boolean yDq = false;
    private ArrayList<String> yDr;

    @Override // com.tencent.mm.plugin.label.ui.ContactLabelBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactLabelUI() {
        AppMethodBeat.i(26302);
        AppMethodBeat.o(26302);
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, a aVar) {
        AppMethodBeat.i(26322);
        contactLabelUI.a(aVar);
        AppMethodBeat.o(26322);
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, String str, boolean z) {
        AppMethodBeat.i(26320);
        contactLabelUI.bL(str, z);
        AppMethodBeat.o(26320);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        Normal,
        Search,
        OverMaxCount,
        Invaildnput;

        public static a valueOf(String str) {
            AppMethodBeat.i(26300);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(26300);
            return aVar;
        }

        static {
            AppMethodBeat.i(26301);
            AppMethodBeat.o(26301);
        }
    }

    @Override // com.tencent.mm.plugin.label.ui.ContactLabelBaseUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.y3;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(26303);
        setMMTitle(getString(R.string.da));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26280);
                ContactLabelUI.this.onBackPressed();
                AppMethodBeat.o(26280);
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26284);
                ContactLabelUI.a(ContactLabelUI.this);
                AppMethodBeat.o(26284);
                return false;
            }
        }, null, t.b.GREEN);
        this.yDa = (MMTagPanelScrollView) findViewById(R.id.e7d);
        this.yDa.setMaxLine(3);
        this.yDb = (MMLabelPanel) findViewById(R.id.e7c);
        this.yDc = (TextView) findViewById(R.id.e7f);
        this.yDd = findViewById(R.id.e7b);
        this.yDe = findViewById(R.id.e7a);
        this.yDe.setBackgroundDrawable(null);
        this.yDf = (TextView) this.yDe.findViewById(16908310);
        this.yDf.setText(R.string.ebs);
        this.yDg = (MMLabelPanel) findViewById(R.id.e79);
        this.yDh = (ListView) findViewById(R.id.e7e);
        this.yDi = (ScrollView) findViewById(R.id.e7h);
        if (this.yDi != null) {
            this.yDi.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass6 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(26285);
                    if (motionEvent.getAction() == 2) {
                        ContactLabelUI.this.hideVKB();
                    }
                    AppMethodBeat.o(26285);
                    return false;
                }
            });
        }
        this.yDb.OTh = true;
        this.yDb.Bz(true);
        this.yDb.setTagEditTextBG(R.drawable.ay6);
        this.yDb.setCallBack(new MMTagPanel.a() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anb(String str) {
                AppMethodBeat.i(26286);
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", str);
                ContactLabelUI.this.yDb.removeTag(str);
                if (ContactLabelUI.this.yDg != null) {
                    ContactLabelUI.this.yDg.dn(str, false);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
                AppMethodBeat.o(26286);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anc(String str) {
                AppMethodBeat.i(26287);
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", str);
                AppMethodBeat.o(26287);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void and(String str) {
                AppMethodBeat.i(26288);
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", str);
                if (ContactLabelUI.this.yDg != null) {
                    ContactLabelUI.this.yDg.dn(str, false);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
                AppMethodBeat.o(26288);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void cIk() {
                AppMethodBeat.i(26289);
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
                AppMethodBeat.o(26289);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void ane(String str) {
                AppMethodBeat.i(26290);
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", str);
                ContactLabelUI.b(ContactLabelUI.this, str);
                AppMethodBeat.o(26290);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anf(String str) {
                AppMethodBeat.i(26291);
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", String.valueOf(str));
                if (Util.isNullOrNil(str)) {
                    Log.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
                    AppMethodBeat.o(26291);
                    return;
                }
                ContactLabelUI.this.yDb.dm(str, true);
                if (ContactLabelUI.this.yDg != null) {
                    ContactLabelUI.this.yDg.dn(str, true);
                }
                ContactLabelUI.a(ContactLabelUI.this, str, ContactLabelUI.this.yDq);
                AppMethodBeat.o(26291);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void E(boolean z, int i2) {
                AppMethodBeat.i(26292);
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", String.valueOf(z), Integer.valueOf(i2));
                if (z) {
                    ContactLabelUI.this.enableOptionMenu(false);
                    ContactLabelUI.this.yDc.setVisibility(0);
                    ContactLabelUI.this.yDc.setText(R.string.ebt);
                    ContactLabelUI.this.yDc.setText(String.format(ContactLabelUI.this.getString(R.string.ebt), Integer.valueOf(f.dp(36, "")), Integer.valueOf(i2)));
                    AppMethodBeat.o(26292);
                    return;
                }
                ContactLabelUI.this.enableOptionMenu(true);
                ContactLabelUI.this.yDc.setVisibility(8);
                AppMethodBeat.o(26292);
            }
        });
        this.yDg.Bz(false);
        this.yDg.setCallBack(new MMTagPanel.a() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anb(String str) {
                AppMethodBeat.i(26293);
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", String.valueOf(str));
                if (ContactLabelUI.this.yDb != null) {
                    ContactLabelUI.this.yDb.removeTag(str);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
                AppMethodBeat.o(26293);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anc(String str) {
                AppMethodBeat.i(26294);
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", String.valueOf(str));
                if (ContactLabelUI.this.yDb != null) {
                    ContactLabelUI.this.yDb.dm(str, true);
                }
                ContactLabelUI.a(ContactLabelUI.this, str, ContactLabelUI.this.yDq);
                AppMethodBeat.o(26294);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void and(String str) {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void E(boolean z, int i2) {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void cIk() {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void ane(String str) {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anf(String str) {
            }
        });
        this.yDh.setAdapter((ListAdapter) this.yDj);
        this.yDh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass9 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(26295);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (ContactLabelUI.this.yDj == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(26295);
                    return;
                }
                String item = ContactLabelUI.this.yDj.getItem(i2);
                if (!Util.isNullOrNil(item) && ContactLabelUI.this.yDb != null) {
                    ContactLabelUI.this.yDb.gLc();
                    ContactLabelUI.this.yDb.dm(item, true);
                    ContactLabelUI.this.yDg.dn(item, true);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(26295);
            }
        });
        enableOptionMenu(false);
        AppMethodBeat.o(26303);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26304);
        super.onCreate(bundle);
        this.yDk = getIntent().getStringExtra("label_id_list");
        this.yDl = getIntent().getStringArrayListExtra("label_str_list");
        this.goe = getIntent().getStringExtra("label_username");
        this.yDq = getIntent().getBooleanExtra("is_stranger", false);
        this.yDj = new b(this);
        initView();
        if (!Util.isNullOrNil(this.yDk) && this.yDl != null && this.yDl.size() > 0) {
            this.yDb.a(this.yDl, this.yDl);
        }
        if (this.yDq) {
            this.yDr = getIntent().getStringArrayListExtra("label_str_list");
            this.yDb.a(this.yDr, this.yDr);
        }
        h.INSTANCE.a(16097, 1, 0, 1);
        AppMethodBeat.o(26304);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(26305);
        bg.azz().a(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX, this);
        bg.azz().a(638, this);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(26298);
                ContactLabelUI.this.yDm.clear();
                ContactLabelUI.this.yDn.clear();
                ArrayList arrayList = null;
                if (ContactLabelUI.this.yDb != null) {
                    if (ContactLabelUI.this.yDq) {
                        String str = null;
                        bg.aVF();
                        cn aEZ = c.aSO().aEZ(ContactLabelUI.this.goe);
                        if (aEZ != null) {
                            str = aEZ.field_contactLabels;
                        }
                        if (Util.isNullOrNil(str)) {
                            bg.aVF();
                            as Kn = c.aSN().Kn(ContactLabelUI.this.goe);
                            String str2 = Kn.field_encryptUsername;
                            if (!Util.isNullOrNil(str2)) {
                                bg.aVF();
                                cn aEZ2 = c.aSO().aEZ(str2);
                                if (aEZ2 != null) {
                                    str = aEZ2.field_contactLabels;
                                }
                            }
                            if (Util.isNullOrNil(str)) {
                                String str3 = Kn.field_username;
                                bg.aVF();
                                cn aEZ3 = c.aSO().aEZ(str3);
                                if (aEZ3 != null) {
                                    str = aEZ3.field_contactLabels;
                                }
                            }
                        }
                        arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().aCI(str);
                    } else {
                        bg.aVF();
                        as Kn2 = c.aSN().Kn(ContactLabelUI.this.goe);
                        if (Kn2 != null) {
                            String str4 = Kn2.field_contactLabelIds;
                            if (!Util.isNullOrNil(str4)) {
                                arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().aCJ(str4);
                            }
                        }
                    }
                    ContactLabelUI.this.yDb.a(arrayList, arrayList);
                    ContactLabelUI.a(ContactLabelUI.this, arrayList);
                }
                if (ContactLabelUI.this.yDg != null) {
                    ContactLabelUI.this.yDo = e.ecf().gBU();
                    if (ContactLabelUI.this.yDo != null && ContactLabelUI.this.yDo.size() > 0) {
                        boolean unused = ContactLabelUI.this.yDq;
                        ContactLabelUI.this.yDg.a(arrayList, ContactLabelUI.this.yDo);
                        if (ContactLabelUI.this.yCB) {
                            h.INSTANCE.a(11346, 0, 1);
                            ContactLabelUI.this.yCB = false;
                        }
                    } else if (ContactLabelUI.this.yCB) {
                        h.INSTANCE.a(11346, 0, 0);
                        ContactLabelUI.this.yCB = false;
                    }
                }
                ContactLabelUI.a(ContactLabelUI.this, a.Normal);
                AppMethodBeat.o(26298);
            }
        });
        super.onResume();
        AppMethodBeat.o(26305);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(26306);
        bg.azz().b(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX, this);
        bg.azz().b(638, this);
        super.onPause();
        AppMethodBeat.o(26306);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26307);
        super.onDestroy();
        AppMethodBeat.o(26307);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(26308);
        Log.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        switch (qVar.getType()) {
            case com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX:
                if (i2 == 0 && i3 == 0) {
                    ecp();
                    AppMethodBeat.o(26308);
                    return;
                }
                eck();
                AppMethodBeat.o(26308);
                return;
            case 636:
            case 637:
            default:
                Log.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
                AppMethodBeat.o(26308);
                return;
            case 638:
                if (i2 == 0 && i3 == 0) {
                    Log.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
                    ecq();
                    AppMethodBeat.o(26308);
                    return;
                }
                eck();
                AppMethodBeat.o(26308);
                return;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(26309);
        if (ecr()) {
            com.tencent.mm.ui.base.h.c(this, getString(R.string.gar), "", getString(R.string.am8), getString(R.string.ama), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26281);
                    ContactLabelUI.a(ContactLabelUI.this);
                    AppMethodBeat.o(26281);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26282);
                    ContactLabelUI.this.finish();
                    AppMethodBeat.o(26282);
                }
            });
            AppMethodBeat.o(26309);
            return;
        }
        try {
            super.onBackPressed();
            AppMethodBeat.o(26309);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Label.ContactLabelUI", e2, "", new Object[0]);
            AppMethodBeat.o(26309);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(a aVar) {
        AppMethodBeat.i(26310);
        this.yDp = aVar;
        switch (this.yDp) {
            case Normal:
                this.yDh.setVisibility(8);
                if (this.yDo == null || this.yDo.size() <= 0) {
                    this.yDi.setVisibility(8);
                    this.yDd.setVisibility(8);
                } else {
                    this.yDd.setVisibility(0);
                    this.yDi.setVisibility(0);
                }
                this.yDc.setVisibility(8);
                AppMethodBeat.o(26310);
                return;
            case Search:
                this.yDi.setVisibility(8);
                this.yDh.setVisibility(0);
                this.yDd.setVisibility(8);
                this.yDc.setVisibility(8);
                AppMethodBeat.o(26310);
                return;
            case OverMaxCount:
                this.yDh.setVisibility(8);
                this.yDi.setVisibility(8);
                this.yDd.setVisibility(8);
                this.yDc.setVisibility(0);
                this.yDc.setText(R.string.ebt);
                AppMethodBeat.o(26310);
                return;
            case Invaildnput:
                this.yDh.setVisibility(8);
                this.yDi.setVisibility(8);
                this.yDd.setVisibility(8);
                this.yDc.setVisibility(0);
                this.yDc.setText(R.string.ebt);
                break;
        }
        AppMethodBeat.o(26310);
    }

    private void bL(String str, boolean z) {
        AppMethodBeat.i(26311);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
            AppMethodBeat.o(26311);
            return;
        }
        String trim = str.trim();
        if (Util.isNullOrNil(trim)) {
            Log.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
            AppMethodBeat.o(26311);
            return;
        }
        au bjB = e.ecf().bjB(trim);
        if (z) {
            if (this.yDo == null || !this.yDo.contains(trim) || bjB == null) {
                this.yDn.add(trim);
            }
        } else if (this.yDo == null || !this.yDo.contains(trim) || (bjB != null && bjB.field_isTemporary)) {
            this.yDn.add(trim);
        }
        if (this.yDm != null && this.yDm.contains(trim)) {
            this.yDm.remove(trim);
        }
        if (ecr()) {
            enableOptionMenu(true);
        }
        AppMethodBeat.o(26311);
    }

    private void ecp() {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(26312);
        Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
        if (this.yDb != null) {
            Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
            String str = "";
            ArrayList<String> tagList = this.yDb.getTagList();
            if (tagList != null && tagList.size() > 0) {
                str = com.tencent.mm.plugin.label.c.fj(e.ecf().bi(tagList));
            }
            LinkedList linkedList = new LinkedList();
            eov eov = new eov();
            eov.Lqm = str;
            eov.UserName = this.goe;
            linkedList.add(eov);
            bg.azz().a(new d(linkedList), 0);
            if (this.yDn != null) {
                i2 = this.yDn.size();
            } else {
                i2 = 0;
            }
            if (this.yDl != null) {
                i3 = this.yDl.size();
            } else {
                i3 = 0;
            }
            if (this.yDm != null) {
                i4 = this.yDm.size();
            } else {
                i4 = 0;
            }
            int size = ((i4 + this.yDb.getTagList().size()) - i3) - i2;
            if (i2 > 0 || size > 0) {
                Log.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", Integer.valueOf(i2), Integer.valueOf(size));
                h.INSTANCE.a(11220, z.aTY(), Integer.valueOf(i2), Integer.valueOf(size), 0, 0);
            }
            if (i2 > 0) {
                h.INSTANCE.a(16097, 2, 1, 1);
            }
        }
        AppMethodBeat.o(26312);
    }

    private void ecq() {
        AppMethodBeat.i(26313);
        hideLoading();
        this.yDn.clear();
        this.yDm.clear();
        finish();
        AppMethodBeat.o(26313);
    }

    private void eck() {
        AppMethodBeat.i(26314);
        hideLoading();
        amW(getString(R.string.d8));
        AppMethodBeat.o(26314);
    }

    private boolean ecr() {
        AppMethodBeat.i(26315);
        if (this.yDb != null) {
            if (this.yDl == null || this.yDl.size() <= 0) {
                if (this.yDb.getTagList() != null && this.yDb.getTagList().size() > 0) {
                    AppMethodBeat.o(26315);
                    return true;
                }
            } else if (this.yDb.getTagList() != null || this.yDb.getTagList().size() > 0) {
                ArrayList<String> tagList = this.yDb.getTagList();
                Collections.sort(this.yDl);
                Collections.sort(tagList);
                if (!this.yDl.equals(tagList)) {
                    AppMethodBeat.o(26315);
                    return true;
                }
                AppMethodBeat.o(26315);
                return false;
            } else {
                AppMethodBeat.o(26315);
                return true;
            }
        }
        AppMethodBeat.o(26315);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(26316);
        if (this.yDb != null) {
            this.yDb.gLe();
        }
        Intent intent = new Intent();
        if (ecr()) {
            intent.putExtra("hasLableChange", true);
        } else {
            intent.putExtra("hasLableChange", false);
        }
        setResult(-1, intent);
        super.finish();
        AppMethodBeat.o(26316);
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI) {
        AppMethodBeat.i(26317);
        Log.i("MicroMsg.Label.ContactLabelUI", "cpan[save]");
        if (contactLabelUI.yDb == null) {
            Log.w("MicroMsg.Label.ContactLabelUI", "save fail. input view is null.");
            AppMethodBeat.o(26317);
            return;
        }
        contactLabelUI.aCL(contactLabelUI.getString(R.string.ebv));
        if (contactLabelUI.yDq) {
            Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]");
            if (contactLabelUI.yDb != null) {
                String editText = contactLabelUI.yDb.getEditText();
                if (!Util.isNullOrNil(editText)) {
                    contactLabelUI.yDb.dm(editText, true);
                    contactLabelUI.yDb.gLc();
                    contactLabelUI.bL(editText, contactLabelUI.yDq);
                }
            }
            if (contactLabelUI.yDn != null && contactLabelUI.yDn.size() > 0) {
                Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger] save local");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(contactLabelUI.yDn);
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < size; i2++) {
                        au auVar = new au();
                        String str = (String) arrayList.get(i2);
                        auVar.field_isTemporary = true;
                        auVar.field_labelName = str;
                        auVar.field_labelPYFull = com.tencent.mm.platformtools.f.Sh(str);
                        auVar.field_labelPYShort = com.tencent.mm.platformtools.f.Si(str);
                        auVar.field_labelID = -((int) System.nanoTime());
                        Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]field_labelID:%s field_labelName:%s", Integer.valueOf(auVar.field_labelID), auVar.field_labelName);
                        arrayList2.add(auVar);
                    }
                    e.ecf().iG(arrayList2);
                }
            }
            Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveStranger]");
            bg.aVF();
            cn aEZ = c.aSO().aEZ(contactLabelUI.goe);
            if (contactLabelUI.yDb != null) {
                String fh = com.tencent.mm.plugin.label.a.a.ecg().fh(contactLabelUI.yDb.getTagList());
                if (!Util.isNullOrNil(fh)) {
                    aEZ.field_contactLabels = fh;
                    if (Util.isNullOrNil(aEZ.field_encryptUsername)) {
                        aEZ.field_encryptUsername = contactLabelUI.goe;
                    }
                    bg.aVF();
                    c.aSO().replace(aEZ);
                } else {
                    aEZ.field_contactLabels = "";
                    bg.aVF();
                    c.aSO().replace(aEZ);
                }
            }
            contactLabelUI.ecq();
            AppMethodBeat.o(26317);
            return;
        }
        Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabel]");
        if (contactLabelUI.yDb != null) {
            String editText2 = contactLabelUI.yDb.getEditText();
            if (!Util.isNullOrNil(editText2)) {
                String trim = editText2.trim();
                contactLabelUI.yDb.dm(trim, true);
                contactLabelUI.yDb.gLc();
                contactLabelUI.bL(trim, contactLabelUI.yDq);
            }
        }
        if (contactLabelUI.yDn == null || contactLabelUI.yDn.size() <= 0) {
            Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doSaveContact");
            contactLabelUI.ecp();
            AppMethodBeat.o(26317);
            return;
        }
        Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doScene");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(contactLabelUI.yDn);
        bg.azz().a(new com.tencent.mm.plugin.label.b.a(arrayList3), 0);
        if (contactLabelUI.yDo == null || contactLabelUI.yDn.isEmpty()) {
            h.INSTANCE.a(11347, 0, 0);
            AppMethodBeat.o(26317);
            return;
        }
        h.INSTANCE.a(11347, 0, 1);
        AppMethodBeat.o(26317);
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, String str) {
        AppMethodBeat.i(26318);
        if (contactLabelUI.yDl != null && contactLabelUI.yDl.contains(str)) {
            contactLabelUI.yDm.add(str);
        }
        if (contactLabelUI.yDn != null && contactLabelUI.yDn.contains(str)) {
            contactLabelUI.yDn.remove(str);
        }
        if (contactLabelUI.ecr()) {
            contactLabelUI.enableOptionMenu(true);
        }
        AppMethodBeat.o(26318);
    }

    static /* synthetic */ void b(ContactLabelUI contactLabelUI, String str) {
        AppMethodBeat.i(26319);
        if (!Util.isNullOrNil(str)) {
            contactLabelUI.a(a.Search);
            if (contactLabelUI.yDb != null) {
                b bVar = contactLabelUI.yDj;
                ArrayList<String> tagList = contactLabelUI.yDb.getTagList();
                if (bVar.yCY != null) {
                    bVar.yCY.clear();
                }
                if (bVar.yCZ != null) {
                    bVar.yCZ.clear();
                }
                bVar.kcy = Util.nullAs(str, "");
                bVar.yCY = e.ecf().J(str, tagList);
                bVar.notifyDataSetChanged();
                AppMethodBeat.o(26319);
                return;
            }
        } else {
            contactLabelUI.a(a.Normal);
        }
        AppMethodBeat.o(26319);
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, ArrayList arrayList) {
        AppMethodBeat.i(26321);
        if (arrayList == null || arrayList.size() <= 0) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(26296);
                    ContactLabelUI.this.yDb.gLd();
                    ContactLabelUI.this.showVKB();
                    AppMethodBeat.o(26296);
                }
            }, 50);
            AppMethodBeat.o(26321);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(26297);
                ContactLabelUI.this.yDb.gLe();
                ContactLabelUI.this.hideVKB();
                AppMethodBeat.o(26297);
            }
        }, 50);
        AppMethodBeat.o(26321);
    }
}
