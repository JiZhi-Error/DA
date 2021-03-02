package com.tencent.mm.plugin.sns.ui.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.ui.jsapi.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsapiSnsLabelUI extends MMActivity implements i {
    public static int[] EEO = {R.string.h7n, R.string.h7l, R.string.h7h, R.string.h79};
    private AnimatedExpandableListView EEN;
    private ArrayList<String> EEP;
    private String EEQ;
    private String EER;
    private int EEU = this.EZU;
    private boolean EEW;
    private boolean EEX = false;
    private boolean EEY = false;
    private boolean EEZ = false;
    private int EFa;
    private q EFb;
    private String EFc;
    private int EFd;
    private ArrayList<String> EFe;
    private ArrayList<String> EFf;
    private ArrayList<Long> EFg;
    private ArrayList<String[]> EFh;
    public int EZU = 0;
    public int EZV = 1;
    public int EZW = 2;
    public int EZX = 3;
    private List<String> EZY = Arrays.asList("public,private,visible,invisible".split(","));
    a EZZ;
    List<String> Faa = new ArrayList();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public JsapiSnsLabelUI() {
        AppMethodBeat.i(100142);
        AppMethodBeat.o(100142);
    }

    static /* synthetic */ String a(JsapiSnsLabelUI jsapiSnsLabelUI, int i2) {
        AppMethodBeat.i(100168);
        String aae = jsapiSnsLabelUI.aae(i2);
        AppMethodBeat.o(100168);
        return aae;
    }

    static /* synthetic */ int fks() {
        AppMethodBeat.i(100169);
        int fin = fin();
        AppMethodBeat.o(100169);
        return fin;
    }

    static /* synthetic */ void h(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(100173);
        jsapiSnsLabelUI.goBack();
        AppMethodBeat.o(100173);
    }

    static /* synthetic */ void k(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(100174);
        jsapiSnsLabelUI.fiq();
        AppMethodBeat.o(100174);
    }

    static /* synthetic */ void n(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(100175);
        jsapiSnsLabelUI.fim();
        AppMethodBeat.o(100175);
    }

    static /* synthetic */ void o(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(100176);
        jsapiSnsLabelUI.fil();
        AppMethodBeat.o(100176);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bw3;
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(100143);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
            AppMethodBeat.o(100143);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(100143);
        return dispatchKeyEvent;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(100144);
        super.onCreate(bundle);
        setMMTitle(R.string.hax);
        g.aAi();
        g.aAg().hqi.a(l.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(b.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(638, this);
        g.aAi();
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, this);
        this.EZZ = new a(this);
        this.EZZ.Fag = false;
        this.EZZ.Faf = new a.b() {
            /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ui.jsapi.a.b
            public final void a(a.c cVar) {
                AppMethodBeat.i(100130);
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, cVar.EFE, cVar.EFF);
                AppMethodBeat.o(100130);
            }
        };
        Intent intent = getIntent();
        if (intent == null) {
            this.EEU = this.EZU;
            this.EZZ.style = 0;
            this.EEQ = null;
            this.EER = null;
        } else {
            if (intent.hasExtra("k_title")) {
                setMMTitle(intent.getStringExtra("k_title"));
            }
            this.EEU = intent.getIntExtra("KLabel_range_index", this.EZU);
            this.EZZ.style = intent.getIntExtra("k_sns_label_ui_style", 0);
            this.EEQ = intent.getStringExtra("Klabel_name_list");
            this.EER = intent.getStringExtra("Kother_user_name_list");
            if (!TextUtils.isEmpty(intent.getStringExtra("k_sns_label_ui_title"))) {
                setMMTitle(intent.getStringExtra("k_sns_label_ui_title"));
            }
        }
        this.EZZ.EFr = this.EEU;
        if (this.EZZ.style == 1) {
            findViewById(R.id.hyi).setBackgroundResource(R.color.fm);
        }
        if (this.EEU == this.EZW) {
            if (!TextUtils.isEmpty(this.EEQ)) {
                this.EZZ.EFt = Util.stringsToList(this.EEQ.split(","));
            }
            if (!TextUtils.isEmpty(this.EER)) {
                this.EZZ.EFv = Util.stringsToList(this.EER.split(","));
            }
        } else if (this.EEU == this.EZX) {
            if (!TextUtils.isEmpty(this.EEQ)) {
                this.EZZ.EFu = Util.stringsToList(this.EEQ.split(","));
            }
            if (!TextUtils.isEmpty(this.EER)) {
                this.EZZ.EFw = Util.stringsToList(this.EER.split(","));
            }
        }
        g.aAi();
        this.EEW = ((Boolean) g.aAh().azQ().get(335873, Boolean.TRUE)).booleanValue();
        if (this.EEW) {
            this.EEY = true;
            this.EEZ = true;
            if (fin() > 0) {
                this.EEX = true;
            }
            g.aAi();
            g.aAg().hqi.a(new w(1), 0);
        }
        initView();
        Intent intent2 = getIntent();
        if (intent2 != null) {
            String stringExtra = intent2.getStringExtra("k_select_group");
            boolean booleanExtra = intent2.getBooleanExtra("k_show_public", true);
            boolean booleanExtra2 = intent2.getBooleanExtra("k_show_private", true);
            boolean booleanExtra3 = intent2.getBooleanExtra("k_show_include", true);
            boolean booleanExtra4 = intent2.getBooleanExtra("k_show_exclude", true);
            int[] iArr = {R.string.h7n, R.string.h7l, R.string.h7h, R.string.h79};
            this.Faa.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (booleanExtra) {
                arrayList.add(Integer.valueOf(iArr[0]));
                arrayList2.add(Integer.valueOf(iArr[0]));
                this.Faa.add(this.EZY.get(0));
            }
            if (booleanExtra2) {
                arrayList.add(Integer.valueOf(iArr[1]));
                arrayList2.add(Integer.valueOf(iArr[1]));
                this.Faa.add(this.EZY.get(1));
            }
            if (booleanExtra3) {
                arrayList.add(Integer.valueOf(iArr[2]));
                arrayList2.add(Integer.valueOf(iArr[2]));
                this.Faa.add(this.EZY.get(2));
            }
            if (booleanExtra4) {
                arrayList.add(Integer.valueOf(iArr[3]));
                arrayList2.add(Integer.valueOf(iArr[3]));
                this.Faa.add(this.EZY.get(3));
            }
            if (this.Faa.size() == 0) {
                finish();
                AppMethodBeat.o(100144);
                return;
            }
            this.EZU = this.Faa.indexOf("public");
            this.EZV = this.Faa.indexOf("private");
            this.EZW = this.Faa.indexOf("visible");
            this.EZX = this.Faa.indexOf("invisible");
            if (this.EZZ != null) {
                a aVar = this.EZZ;
                List<String> list = this.Faa;
                aVar.Fae = list;
                aVar.EZU = list.indexOf("public");
                aVar.EZV = list.indexOf("private");
                aVar.EZW = list.indexOf("visible");
                aVar.EZX = list.indexOf("invisible");
                this.EZZ.Fad = arrayList.size();
                this.EZZ.EEO = hj(arrayList);
                this.EZZ.EFp = hj(arrayList2);
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.EZZ.EFr = this.Faa.indexOf(stringExtra);
                    if (stringExtra.equals("visible")) {
                        if (!TextUtils.isEmpty(this.EEQ)) {
                            this.EZZ.EFt = Util.stringsToList(this.EEQ.split(","));
                        }
                        if (!TextUtils.isEmpty(this.EER)) {
                            this.EZZ.EFv = Util.stringsToList(this.EER.split(","));
                        }
                        this.EEN.expandGroup(this.Faa.indexOf(stringExtra));
                        AppMethodBeat.o(100144);
                        return;
                    } else if (stringExtra.equals("invisible")) {
                        if (!TextUtils.isEmpty(this.EEQ)) {
                            this.EZZ.EFu = Util.stringsToList(this.EEQ.split(","));
                        }
                        if (!TextUtils.isEmpty(this.EER)) {
                            this.EZZ.EFw = Util.stringsToList(this.EER.split(","));
                        }
                        this.EEN.expandGroup(this.Faa.indexOf(stringExtra));
                    }
                }
            }
        }
        AppMethodBeat.o(100144);
    }

    private static int[] hj(List<Integer> list) {
        AppMethodBeat.i(100145);
        int[] iArr = new int[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            iArr[i2] = list.get(i2).intValue();
        }
        AppMethodBeat.o(100145);
        return iArr;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(100146);
        boolean booleanExtra = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
        this.EEN = (AnimatedExpandableListView) findViewById(R.id.hyh);
        this.EEP = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().ecb();
        this.EZZ.EFs = booleanExtra;
        this.EZZ.aR(this.EEP);
        fiq();
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(R.dimen.hv);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.EEN.addHeaderView(view);
        this.EEN.setAdapter(this.EZZ);
        this.EEN.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass5 */

            public final boolean onGroupClick(ExpandableListView expandableListView, View view, final int i2, long j2) {
                AppMethodBeat.i(100134);
                int i3 = JsapiSnsLabelUI.this.EZZ.EFr;
                Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", Integer.valueOf(i3), Integer.valueOf(i2));
                if (!JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i2).equals("visible") && !JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i2).equals("invisible")) {
                    if (i3 >= 0 && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i3).equals("visible") || JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i3).equals("invisible"))) {
                        JsapiSnsLabelUI.this.EEN.apj(i3);
                    }
                    JsapiSnsLabelUI.this.EZZ.EFr = i2;
                    AppMethodBeat.o(100134);
                    return false;
                } else if (JsapiSnsLabelUI.this.EFf != null && JsapiSnsLabelUI.this.EFf.size() != 0 && JsapiSnsLabelUI.fks() == 0) {
                    JsapiSnsLabelUI.this.EFa = i2;
                    JsapiSnsLabelUI.c(JsapiSnsLabelUI.this);
                    Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
                    AppMethodBeat.o(100134);
                    return true;
                } else if (JsapiSnsLabelUI.this.EEZ) {
                    JsapiSnsLabelUI.this.EEX = true;
                    JsapiSnsLabelUI.this.EFa = i2;
                    JsapiSnsLabelUI.this.EFb = h.a((Context) JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(R.string.h7j), false, (DialogInterface.OnCancelListener) null);
                    Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
                    AppMethodBeat.o(100134);
                    return true;
                } else if (JsapiSnsLabelUI.this.EZZ.EFq == null || JsapiSnsLabelUI.this.EZZ.EFq.size() == 0) {
                    JsapiSnsLabelUI.this.EFa = i2;
                    JsapiSnsLabelUI.f(JsapiSnsLabelUI.this);
                    Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
                    AppMethodBeat.o(100134);
                    return true;
                } else {
                    if (i3 != i2) {
                        if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i3).equals("visible")) {
                            JsapiSnsLabelUI.this.EEN.collapseGroup(i3);
                            JsapiSnsLabelUI.this.EZZ.EFt.clear();
                            JsapiSnsLabelUI.this.EZZ.EFv.clear();
                        } else if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i3).equals("invisible")) {
                            JsapiSnsLabelUI.this.EEN.collapseGroup(i3);
                            JsapiSnsLabelUI.this.EZZ.EFu.clear();
                            JsapiSnsLabelUI.this.EZZ.EFw.clear();
                        }
                        JsapiSnsLabelUI.this.EEN.post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(100133);
                                JsapiSnsLabelUI.this.EEN.api(i2);
                                AppMethodBeat.o(100133);
                            }
                        });
                    } else if (JsapiSnsLabelUI.this.EEN.isGroupExpanded(i2)) {
                        JsapiSnsLabelUI.this.EEN.apj(i2);
                    } else {
                        JsapiSnsLabelUI.this.EEN.api(i2);
                    }
                    JsapiSnsLabelUI.this.EZZ.EFr = i2;
                    AppMethodBeat.o(100134);
                    return true;
                }
            }
        });
        this.EEN.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass6 */

            public final boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
                AppMethodBeat.i(100135);
                if (i3 == JsapiSnsLabelUI.this.EZZ.getChildrenCount(i2) - 1) {
                    JsapiSnsLabelUI.this.EFa = i2;
                    JsapiSnsLabelUI.f(JsapiSnsLabelUI.this);
                } else {
                    String str = (String) JsapiSnsLabelUI.this.EZZ.getChild(i2, i3);
                    a unused = JsapiSnsLabelUI.this.EZZ;
                    a.aRb(str);
                    if (i2 == JsapiSnsLabelUI.this.EZW) {
                        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.this.EZZ.EFt, str, view);
                    } else if (i2 == JsapiSnsLabelUI.this.EZX) {
                        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.this.EZZ.EFu, str, view);
                    }
                }
                AppMethodBeat.o(100135);
                return false;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(100136);
                JsapiSnsLabelUI.h(JsapiSnsLabelUI.this);
                AppMethodBeat.o(100136);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.h7a), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(100137);
                JsapiSnsLabelUI jsapiSnsLabelUI = JsapiSnsLabelUI.this;
                String listToString = Util.listToString(jsapiSnsLabelUI.EZZ.EFt, ",");
                String listToString2 = Util.listToString(jsapiSnsLabelUI.EZZ.EFv, ",");
                String listToString3 = Util.listToString(jsapiSnsLabelUI.EZZ.EFu, ",");
                String listToString4 = Util.listToString(jsapiSnsLabelUI.EZZ.EFw, ",");
                if ((jsapiSnsLabelUI.EZZ.EFr == jsapiSnsLabelUI.EZW && jsapiSnsLabelUI.EZZ.EFt.size() == 0 && jsapiSnsLabelUI.EZZ.EFv.size() == 0) || (jsapiSnsLabelUI.EZZ.EFr == jsapiSnsLabelUI.EZX && jsapiSnsLabelUI.EZZ.EFu.size() == 0 && jsapiSnsLabelUI.EZZ.EFw.size() == 0)) {
                    h.a(jsapiSnsLabelUI, jsapiSnsLabelUI.getString(R.string.h7k), "", jsapiSnsLabelUI.getString(R.string.h7w), (DialogInterface.OnClickListener) null);
                } else if ((jsapiSnsLabelUI.EZZ.EFr != jsapiSnsLabelUI.EZW || !Util.isNullOrNil(listToString) || !Util.isNullOrNil(listToString2)) && (jsapiSnsLabelUI.EZZ.EFr != jsapiSnsLabelUI.EZX || !Util.isNullOrNil(listToString3) || !Util.isNullOrNil(listToString4))) {
                    jsapiSnsLabelUI.fim();
                } else {
                    h.a(jsapiSnsLabelUI, jsapiSnsLabelUI.getString(R.string.h7k), "", jsapiSnsLabelUI.getString(R.string.h7w), (DialogInterface.OnClickListener) null);
                }
                AppMethodBeat.o(100137);
                return true;
            }
        }, null, t.b.GREEN);
        AppMethodBeat.o(100146);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(100147);
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 4003) {
            Log.i("MicroMsg.SnsLabelUI", "the Activity completed");
            String stringExtra = intent.getStringExtra("Select_Contacts_To_Create_New_Label");
            if (!Util.isNullOrNil(stringExtra)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                c.b(getContext(), "label", ".ui.ContactLabelEditUI", intent2, 4002);
                AppMethodBeat.o(100147);
                return;
            }
            String stringExtra2 = intent.getStringExtra("Select_Contact");
            this.EER = new String(stringExtra2);
            Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra2));
            if (this.EFa == this.EZW) {
                this.EZZ.EFv.clear();
                if (!Util.isNullOrNil(stringExtra2)) {
                    this.EZZ.EFv.addAll(Util.stringsToList(stringExtra2.split(",")));
                    this.EZZ.EFr = this.EFa;
                }
            } else if (this.EFa == this.EZX) {
                this.EZZ.EFw.clear();
                if (!Util.isNullOrNil(stringExtra2)) {
                    this.EZZ.EFw.addAll(Util.stringsToList(stringExtra2.split(",")));
                    this.EZZ.EFr = this.EFa;
                }
            }
            this.EZZ.notifyDataSetChanged();
            this.EEN.expandGroup(this.EFa);
            AppMethodBeat.o(100147);
        } else if (i3 == -1 && i2 == 4001) {
            String stringExtra3 = intent.getStringExtra("Select_Contact");
            Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra3));
            if (!Util.isNullOrNil(stringExtra3)) {
                Intent intent3 = new Intent();
                intent3.putExtra("Select_Contact", stringExtra3);
                c.b(this, "label", ".ui.ContactLabelEditUI", intent3, 4002);
            }
            AppMethodBeat.o(100147);
        } else {
            if (i3 == 0 && i2 == 4002 && intent != null) {
                final String stringExtra4 = intent.getStringExtra("k_sns_label_add_label");
                this.EFc = intent.getStringExtra("k_sns_label_add_label");
                this.EEN.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass10 */

                    public final void run() {
                        int i2;
                        AppMethodBeat.i(100139);
                        JsapiSnsLabelUI.this.EEP = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().ecb();
                        if (JsapiSnsLabelUI.this.EEP == null) {
                            JsapiSnsLabelUI.this.EEP = new ArrayList();
                        }
                        if (!Util.isNullOrNil(stringExtra4)) {
                            if (!JsapiSnsLabelUI.this.EEP.contains(stringExtra4)) {
                                JsapiSnsLabelUI.this.EEP.add(stringExtra4);
                            }
                            i2 = JsapiSnsLabelUI.this.EEP.indexOf(stringExtra4);
                        } else {
                            i2 = -1;
                        }
                        JsapiSnsLabelUI.this.EZZ.aR(JsapiSnsLabelUI.this.EEP);
                        JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
                        JsapiSnsLabelUI.this.EZZ.EFr = JsapiSnsLabelUI.this.EFa;
                        if (!Util.isNullOrNil(stringExtra4) && i2 != -1) {
                            if (JsapiSnsLabelUI.this.EFa == JsapiSnsLabelUI.this.EZW) {
                                JsapiSnsLabelUI.this.EZZ.EFt.add(stringExtra4);
                                JsapiSnsLabelUI.this.EZZ.EFv.clear();
                            } else if (JsapiSnsLabelUI.this.EFa == JsapiSnsLabelUI.this.EZX) {
                                JsapiSnsLabelUI.this.EZZ.EFu.add(stringExtra4);
                                JsapiSnsLabelUI.this.EZZ.EFw.clear();
                            }
                        }
                        JsapiSnsLabelUI.this.EZZ.notifyDataSetChanged();
                        JsapiSnsLabelUI.this.EEN.expandGroup(JsapiSnsLabelUI.this.EFa);
                        JsapiSnsLabelUI.this.EFc = null;
                        AppMethodBeat.o(100139);
                    }
                }, 600);
            }
            AppMethodBeat.o(100147);
        }
    }

    private boolean fik() {
        AppMethodBeat.i(100148);
        boolean z = false;
        int i2 = this.EZZ.EFr;
        if (this.EZZ.EFr != this.EEU) {
            if ((i2 == this.EZW && (this.EZZ.EFt.size() != 0 || this.EZZ.EFv.size() != 0)) || (i2 == this.EZX && (this.EZZ.EFu.size() != 0 || this.EZZ.EFw.size() != 0))) {
                z = true;
            } else if (i2 == this.EZV || i2 == this.EZU) {
                z = true;
            }
        } else if ((i2 == this.EZW && this.EZZ.EFt.size() != 0 && (!Util.listToString(this.EZZ.EFt, ",").equals(this.EEQ) || !Util.listToString(this.EZZ.EFv, ",").equals(this.EER))) || (i2 == this.EZX && this.EZZ.EFu.size() != 0 && (!Util.listToString(this.EZZ.EFu, ",").equals(this.EEQ) || !Util.listToString(this.EZZ.EFw, ",").equals(this.EER)))) {
            z = true;
        }
        AppMethodBeat.o(100148);
        return z;
    }

    private void goBack() {
        AppMethodBeat.i(100149);
        if (fik()) {
            h.a((Context) this, true, getString(R.string.h7e), "", getString(R.string.h7d), getString(R.string.h7c), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(100140);
                    JsapiSnsLabelUI.n(JsapiSnsLabelUI.this);
                    AppMethodBeat.o(100140);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(100141);
                    JsapiSnsLabelUI.o(JsapiSnsLabelUI.this);
                    AppMethodBeat.o(100141);
                }
            });
            AppMethodBeat.o(100149);
            return;
        }
        fil();
        AppMethodBeat.o(100149);
    }

    private void fil() {
        AppMethodBeat.i(100150);
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.EEU);
        bc(intent);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(100150);
    }

    /* access modifiers changed from: package-private */
    public final void fim() {
        AppMethodBeat.i(100151);
        Intent intent = new Intent();
        if (this.EZZ.EFr == this.EZW) {
            this.EEQ = Util.listToString(this.EZZ.EFt, ",");
            this.EER = Util.listToString(this.EZZ.EFv, ",");
            bc(intent);
        } else if (this.EZZ.EFr == this.EZX) {
            this.EEQ = Util.listToString(this.EZZ.EFu, ",");
            this.EER = Util.listToString(this.EZZ.EFw, ",");
            bc(intent);
        }
        intent.putExtra("k_select_group", aae(this.EZZ.EFr));
        intent.putExtra("k_select_index", this.EZZ.EFr);
        intent.putExtra("Ktag_range_index", this.EZZ.EFr);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(100151);
    }

    private void bc(Intent intent) {
        AppMethodBeat.i(100152);
        fir();
        intent.putExtra("Klabel_name_list", aRp(this.EEQ));
        intent.putExtra("Kother_user_name_list", aRo(this.EER));
        intent.putExtra("k_select_group", aae(this.EZZ.EFr));
        AppMethodBeat.o(100152);
    }

    private String aae(int i2) {
        AppMethodBeat.i(100153);
        if (i2 >= this.Faa.size() || i2 < 0) {
            AppMethodBeat.o(100153);
            return "";
        }
        String str = this.Faa.get(i2);
        AppMethodBeat.o(100153);
        return str;
    }

    private static String aRo(String str) {
        AppMethodBeat.i(100154);
        List<String> stringToList = Util.stringToList(str, ",");
        JSONArray jSONArray = new JSONArray();
        if (stringToList != null) {
            for (String str2 : stringToList) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ch.COL_USERNAME, str2);
                    jSONObject.put("displayName", getDisplayName(str2));
                    jSONObject.put("avatar", aRq(str2));
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.SnsLabelUI", e2, "", new Object[0]);
                }
            }
        }
        String jSONArray2 = jSONArray.toString();
        AppMethodBeat.o(100154);
        return jSONArray2;
    }

    private static String aRp(String str) {
        AppMethodBeat.i(100155);
        List<String> stringToList = Util.stringToList(str, ",");
        JSONObject jSONObject = new JSONObject();
        com.tencent.mm.plugin.label.a.b ecg = com.tencent.mm.plugin.label.a.a.ecg();
        for (String str2 : stringToList) {
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put(str2, jSONArray);
                List<String> aCK = ecg.aCK(ecg.aCH(str2));
                if (aCK != null) {
                    for (String str3 : aCK) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ch.COL_USERNAME, str3);
                        jSONObject2.put("displayName", getDisplayName(str3));
                        jSONObject2.put("avatar", aRq(str3));
                        jSONArray.put(jSONObject2);
                    }
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.SnsLabelUI", e2, "", new Object[0]);
            }
        }
        String jSONObject3 = jSONObject.toString();
        AppMethodBeat.o(100155);
        return jSONObject3;
    }

    private static String getDisplayName(String str) {
        AppMethodBeat.i(100156);
        String displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str);
        AppMethodBeat.o(100156);
        return displayName;
    }

    private static String aRq(String str) {
        AppMethodBeat.i(100157);
        com.tencent.mm.aj.i Mx = p.aYB().Mx(str);
        if (Mx != null) {
            String aYu = Mx.aYu();
            AppMethodBeat.o(100157);
            return aYu;
        }
        AppMethodBeat.o(100157);
        return "";
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(100158);
        g.aAi();
        g.aAg().hqi.b(l.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(b.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(638, this);
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, this);
        super.onDestroy();
        AppMethodBeat.o(100158);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(100159);
        if (!(this.EZZ == null || this.EFc != null || this.EEN == null)) {
            this.EEN.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(100131);
                    com.tencent.mm.plugin.label.a.a.ecg().aHn();
                    JsapiSnsLabelUI.this.EEP = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().ecb();
                    JsapiSnsLabelUI.this.EZZ.aR(JsapiSnsLabelUI.this.EEP);
                    JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
                    if ((JsapiSnsLabelUI.this.EEP == null || JsapiSnsLabelUI.this.EEP.size() == 0) && !((JsapiSnsLabelUI.this.EER != null && JsapiSnsLabelUI.this.EER.length() != 0) || JsapiSnsLabelUI.this.EZZ.EFr == JsapiSnsLabelUI.this.EZU || JsapiSnsLabelUI.this.EZZ.EFr == JsapiSnsLabelUI.this.EZV)) {
                        JsapiSnsLabelUI.this.EZZ.EFr = JsapiSnsLabelUI.this.EZU;
                    }
                    JsapiSnsLabelUI.this.EZZ.notifyDataSetChanged();
                    JsapiSnsLabelUI.this.EFc = null;
                    AppMethodBeat.o(100131);
                }
            }, 600);
        }
        super.onResume();
        AppMethodBeat.o(100159);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f3, code lost:
        if (r0 == false) goto L_0x00f5;
     */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
        /*
        // Method dump skipped, instructions count: 606
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    private static int fin() {
        AppMethodBeat.i(100161);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(335874, (Object) 0)).intValue();
        AppMethodBeat.o(100161);
        return intValue;
    }

    private static void fio() {
        AppMethodBeat.i(100162);
        g.aAi();
        g.aAi();
        g.aAh().azQ().set(335874, Integer.valueOf(((Integer) g.aAh().azQ().get(335874, (Object) 0)).intValue() + 1));
        AppMethodBeat.o(100162);
    }

    private void fip() {
        AppMethodBeat.i(100163);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11455, "", "", Integer.valueOf(this.EFd), 0);
        fio();
        this.EFf = null;
        this.EEZ = false;
        this.EEY = false;
        if (this.EFb != null && this.EFb.isShowing()) {
            this.EFb.dismiss();
        }
        if (this.EEX) {
            this.EEX = false;
            AppMethodBeat.o(100163);
            return;
        }
        int i2 = R.string.h7v;
        if (fin() > 1) {
            i2 = R.string.h7u;
        }
        h.a(this, i2, (int) R.string.x_, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(100163);
    }

    private void hd(List<String[]> list) {
        AppMethodBeat.i(100164);
        if (this.EFf == null || this.EFf.size() == 0) {
            AppMethodBeat.o(100164);
            return;
        }
        Iterator<String> it = this.EFf.iterator();
        Iterator<String[]> it2 = list.iterator();
        ArrayList arrayList = new ArrayList(this.EFf.size());
        ArrayList arrayList2 = new ArrayList(this.EFf.size());
        while (it.hasNext()) {
            arrayList.add(com.tencent.mm.plugin.label.a.a.ecg().aCH(it.next()));
            arrayList2.add(Util.listToString(Arrays.asList(it2.next()), ","));
            this.EEY = true;
        }
        com.tencent.mm.plugin.label.a.a.ecg().p(arrayList, arrayList2);
        AppMethodBeat.o(100164);
    }

    private void fiq() {
        AppMethodBeat.i(100165);
        if (this.EEP == null || this.EEP.isEmpty()) {
            if (this.EZZ.EFt != null) {
                this.EZZ.EFt.clear();
            }
            if (this.EZZ.EFu != null) {
                this.EZZ.EFu.clear();
            }
            AppMethodBeat.o(100165);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.Faa.size() <= 0 || !"visible".equals(aae(this.EEU)) || this.EZZ.EFt == null) {
            if (this.Faa.size() > 0 && "invisible".equals(aae(this.EEU))) {
                Iterator<String> it = this.EZZ.EFu.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!this.EEP.contains(next)) {
                        arrayList.add(next);
                    }
                }
                this.EZZ.EFu.removeAll(arrayList);
            }
            AppMethodBeat.o(100165);
            return;
        }
        Iterator<String> it2 = this.EZZ.EFt.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!this.EEP.contains(next2)) {
                arrayList.add(next2);
            }
        }
        this.EZZ.EFt.removeAll(arrayList);
        AppMethodBeat.o(100165);
    }

    private void fir() {
        ArrayList<String> stringsToList;
        AppMethodBeat.i(100166);
        if (this.EEP == null || this.EEP.isEmpty()) {
            this.EEQ = "";
            AppMethodBeat.o(100166);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!(this.EEQ == null || (stringsToList = Util.stringsToList(this.EEQ.split(","))) == null)) {
            for (String str : stringsToList) {
                if (!this.EEP.contains(str)) {
                    arrayList.add(str);
                }
            }
            stringsToList.removeAll(arrayList);
            this.EEQ = Util.listToString(stringsToList, ",");
        }
        AppMethodBeat.o(100166);
    }

    static /* synthetic */ void a(JsapiSnsLabelUI jsapiSnsLabelUI, int i2, int i3) {
        Object child;
        AppMethodBeat.i(100167);
        if (!(jsapiSnsLabelUI.EZZ == null || (child = jsapiSnsLabelUI.EZZ.getChild(i2, i3)) == null || !(child instanceof String))) {
            String str = (String) child;
            String aCH = com.tencent.mm.plugin.label.a.a.ecg().aCH(str);
            Intent intent = new Intent();
            intent.putExtra("label_id", aCH);
            intent.putExtra("label_name", str);
            intent.putExtra("is_show_delete", false);
            c.b(jsapiSnsLabelUI.getContext(), "label", ".ui.ContactLabelEditUI", intent, 4002);
        }
        AppMethodBeat.o(100167);
    }

    static /* synthetic */ void c(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(100170);
        h.a(jsapiSnsLabelUI, jsapiSnsLabelUI.getString(R.string.h7x), (String) null, jsapiSnsLabelUI.getString(R.string.h7w), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(100138);
                JsapiSnsLabelUI.this.EEY = true;
                com.tencent.mm.plugin.label.a.a.ecg().fi(JsapiSnsLabelUI.this.EFf);
                JsapiSnsLabelUI.this.EFb = h.a((Context) JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(R.string.h7j), false, (DialogInterface.OnCancelListener) null);
                AppMethodBeat.o(100138);
            }
        });
        AppMethodBeat.o(100170);
    }

    static /* synthetic */ void f(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(100171);
        Intent intent = new Intent();
        intent.putExtra("titile", jsapiSnsLabelUI.getString(R.string.g4));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_attr", u.Q(u.PWS, 1024));
        if (jsapiSnsLabelUI.EFa == jsapiSnsLabelUI.EZW) {
            if (jsapiSnsLabelUI.EZZ.EFv.size() > 0) {
                intent.putExtra("already_select_contact", Util.listToString(jsapiSnsLabelUI.EZZ.EFv, ","));
            }
        } else if (jsapiSnsLabelUI.EFa == jsapiSnsLabelUI.EZX && jsapiSnsLabelUI.EZZ.EFw.size() > 0) {
            intent.putExtra("already_select_contact", Util.listToString(jsapiSnsLabelUI.EZZ.EFw, ","));
        }
        intent.putExtra("KBlockOpenImFav", true);
        c.c(jsapiSnsLabelUI, ".ui.contact.SelectContactUI", intent, (int) WearableStatusCodes.DATA_ITEM_TOO_LARGE);
        AppMethodBeat.o(100171);
    }

    static /* synthetic */ void a(JsapiSnsLabelUI jsapiSnsLabelUI, int i2, ArrayList arrayList, String str, View view) {
        AppMethodBeat.i(100172);
        if (jsapiSnsLabelUI.EZZ == null || jsapiSnsLabelUI.EZZ.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.drawable.p5);
                AppMethodBeat.o(100172);
                return;
            }
            arrayList.add(str);
            if (i2 == 1) {
                ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.checkbox_selected);
                AppMethodBeat.o(100172);
                return;
            }
            ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.checkbox_selected_red);
            AppMethodBeat.o(100172);
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i2 == 1) {
                ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.sight_list_checkbox_unselected);
                AppMethodBeat.o(100172);
                return;
            }
            ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.sight_list_checkbox_unselected_red);
            AppMethodBeat.o(100172);
        } else {
            arrayList.add(str);
            if (i2 == 1) {
                ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.sight_list_checkbox_selected);
                AppMethodBeat.o(100172);
                return;
            }
            ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.sight_list_checkbox_selected_red);
            AppMethodBeat.o(100172);
        }
    }
}
