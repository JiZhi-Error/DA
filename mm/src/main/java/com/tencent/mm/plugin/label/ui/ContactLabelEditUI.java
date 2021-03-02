package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.eov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class ContactLabelEditUI extends MMPreference implements i {
    private ProgressDialog jZH;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(26162);
            int i2 = message.what;
            switch (i2) {
                case TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE:
                    ContactLabelEditUI.a(ContactLabelEditUI.this);
                    AppMethodBeat.o(26162);
                    return;
                case 6002:
                    a.jRu.WZ();
                    AppMethodBeat.o(26162);
                    return;
                default:
                    Log.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", Integer.valueOf(i2));
                    AppMethodBeat.o(26162);
                    return;
            }
        }
    };
    private String yBY;
    private String yBZ;
    private String yCa;
    private au yCb;
    private boolean yCc;
    private boolean yCd = false;
    private String yCe;
    private f yCf;
    private ContactListExpandPreference yCg;
    private InputClearablePreference yCh;
    private Preference yCi;
    private PreferenceTitleCategory yCj;
    private boolean yCk = true;
    private ArrayList<String> yCl = new ArrayList<>();
    private ArrayList<String> yCm = new ArrayList<>();
    private HashSet<String> yCn = new HashSet<>();
    private HashSet<String> yCo = new HashSet<>();
    private HashSet<String> yCp = new HashSet<>();
    private String yCq;
    private String yCr;
    private boolean yCs;
    private boolean yup = true;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactLabelEditUI() {
        AppMethodBeat.i(26178);
        AppMethodBeat.o(26178);
    }

    static /* synthetic */ void a(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.i(26200);
        contactLabelEditUI.eci();
        AppMethodBeat.o(26200);
    }

    static /* synthetic */ void c(ContactLabelEditUI contactLabelEditUI, String str) {
        AppMethodBeat.i(26204);
        contactLabelEditUI.aCM(str);
        AppMethodBeat.o(26204);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.be;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26179);
        super.onCreate(bundle);
        this.yCq = z.aTY();
        this.yCa = getIntent().getStringExtra("label_id");
        this.yBY = getIntent().getStringExtra("label_name");
        this.yBZ = getIntent().getStringExtra("label_name");
        this.yCc = getIntent().getBooleanExtra("Is_Chatroom", false);
        this.yCr = getIntent().getStringExtra("label_source");
        this.yCs = this.yCr != null && this.yCr.equals("label_source_Address");
        this.yCd = getIntent().getBooleanExtra("is_show_delete", true);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (!Util.isNullOrNil(stringExtra)) {
            ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
            this.yCl = new ArrayList<>();
            if (stringsToList != null && stringsToList.size() > 0) {
                int size = stringsToList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = stringsToList.get(i2);
                    if (!Util.isNullOrNil(str)) {
                        if (!ab.IS(str) || this.yCl.contains(str) || str.equals(this.yCq)) {
                            Log.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", str);
                        } else {
                            this.yCl.add(str);
                            this.yCn.add(str);
                            if (this.yCc) {
                                this.yCo.add(str);
                            }
                        }
                    }
                }
            }
        }
        bg.azz().a(b.CTRL_INDEX, this);
        bg.azz().a(637, this);
        bg.azz().a(638, this);
        initView();
        AppMethodBeat.o(26179);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(26180);
        d.d(3, "ContactLabelEditUI" + getIdentString(), hashCode());
        bg.azz().a(636, this);
        aCM(this.yBZ);
        eci();
        super.onResume();
        AppMethodBeat.o(26180);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(26181);
        d.d(4, "ContactLabelEditUI" + getIdentString(), hashCode());
        bg.azz().b(636, this);
        super.onPause();
        AppMethodBeat.o(26181);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26182);
        bg.azz().b(b.CTRL_INDEX, this);
        bg.azz().b(637, this);
        bg.azz().b(638, this);
        super.onDestroy();
        AppMethodBeat.o(26182);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(26183);
        if (this.yCs) {
            h.INSTANCE.a(16097, 1, 0, 2);
        } else {
            h.INSTANCE.a(16097, 1, 0, 3);
        }
        if (Util.isNullOrNil(this.yCa)) {
            this.yCk = true;
            this.yCe = getString(R.string.fp2);
        } else {
            this.yCk = false;
            this.yCb = e.ecf().bjC(this.yCa);
            this.yCe = getString(R.string.fp1);
        }
        setMMTitle(this.yCe);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26166);
                ContactLabelEditUI.this.onBackPressed();
                AppMethodBeat.o(26166);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26167);
                ContactLabelEditUI.b(ContactLabelEditUI.this);
                AppMethodBeat.o(26167);
                return true;
            }
        }, null, t.b.GREEN);
        this.yCf = getPreferenceScreen();
        this.yCg = (ContactListExpandPreference) this.yCf.bmg("contact_label_contact_list");
        this.yCg.a(this.yCf, this.yCg.mKey);
        this.yCg.zU(true);
        this.yCg.zV(true);
        this.yCg.gpG();
        this.yCg.gpA();
        this.yCg.a(new s.b() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass9 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.s.b
            public final boolean oi(int i2) {
                return false;
            }
        });
        this.yCg.a(new ContactListExpandPreference.a() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass10 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
            public final void e(ViewGroup viewGroup, int i2) {
                AppMethodBeat.i(231724);
                if (ContactLabelEditUI.this.yCg.ain(i2)) {
                    String aio = ContactLabelEditUI.this.yCg.aio(i2);
                    String aip = ContactLabelEditUI.this.yCg.aip(i2);
                    if (Util.isNullOrNil(aio)) {
                        AppMethodBeat.o(231724);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", aio);
                    intent.putExtra("Contact_RoomNickname", aip);
                    intent.putExtra("CONTACT_INFO_UI_SOURCE", ContactLabelEditUI.this.yCs ? 17 : 15);
                    a.jRt.c(intent, ContactLabelEditUI.this);
                }
                AppMethodBeat.o(231724);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
            public final void amF() {
                AppMethodBeat.i(26169);
                if (ContactLabelEditUI.this.yCg != null) {
                    ContactLabelEditUI.this.yCg.gpE();
                }
                AppMethodBeat.o(26169);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
            public final void oh(int i2) {
                AppMethodBeat.i(26170);
                ContactLabelEditUI.e(ContactLabelEditUI.this);
                AppMethodBeat.o(26170);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
            public final void og(int i2) {
                AppMethodBeat.i(26171);
                String aio = ContactLabelEditUI.this.yCg.aio(i2);
                Log.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", Integer.valueOf(i2), aio);
                ContactLabelEditUI.a(ContactLabelEditUI.this, aio);
                AppMethodBeat.o(26171);
            }
        });
        this.yCh = (InputClearablePreference) this.yCf.bmg("contact_label_name");
        InputClearablePreference inputClearablePreference = this.yCh;
        inputClearablePreference.yDC = getString(R.string.ebk);
        if (inputClearablePreference.yDH != null) {
            inputClearablePreference.yDH.setHint(inputClearablePreference.yDC);
        }
        this.yCh.jFn = getString(R.string.ebt);
        InputClearablePreference inputClearablePreference2 = this.yCh;
        inputClearablePreference2.yDD = getString(R.string.d9);
        if (inputClearablePreference2.yDJ != null) {
            inputClearablePreference2.yDJ.setText(inputClearablePreference2.yDD);
        }
        this.yCh.yDE = 36;
        this.yCh.yDG = this.yCk;
        this.yCh.yDL = new InputClearablePreference.a() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a
            public final void auW(String str) {
                AppMethodBeat.i(26172);
                ContactLabelEditUI.this.yBZ = str;
                ContactLabelEditUI.c(ContactLabelEditUI.this, str);
                ContactLabelEditUI.this.yCh.qF(false);
                AppMethodBeat.o(26172);
            }

            @Override // com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a
            public final void qD(boolean z) {
                AppMethodBeat.i(26173);
                if (ContactLabelEditUI.this.yCk || !ContactLabelEditUI.this.yup) {
                    ContactLabelEditUI.this.enableOptionMenu(z);
                    AppMethodBeat.o(26173);
                    return;
                }
                ContactLabelEditUI.this.enableOptionMenu(false);
                ContactLabelEditUI.this.yup = false;
                AppMethodBeat.o(26173);
            }
        };
        this.yCh.setText(this.yBZ);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
        }
        if (!this.yCk) {
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(26174);
                    ArrayList<String> bjA = e.ecf().bjA(ContactLabelEditUI.this.yCa);
                    if (bjA == null) {
                        Log.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
                        AppMethodBeat.o(26174);
                        return;
                    }
                    if (bjA != null) {
                        ContactLabelEditUI.this.yCl = bjA;
                        if (ContactLabelEditUI.this.yCm == null) {
                            ContactLabelEditUI.this.yCm = new ArrayList();
                        } else {
                            ContactLabelEditUI.this.yCm.clear();
                        }
                        ContactLabelEditUI.this.yCm.addAll(bjA);
                    }
                    if (ContactLabelEditUI.this.mHandler != null) {
                        ContactLabelEditUI.this.mHandler.sendEmptyMessage(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
                    }
                    AppMethodBeat.o(26174);
                }

                public final String toString() {
                    AppMethodBeat.i(26175);
                    String str = super.toString() + "|initView";
                    AppMethodBeat.o(26175);
                    return str;
                }
            });
        } else if (this.yCl == null || this.yCl.size() <= 0) {
            this.yCg.bg(new ArrayList<>());
        } else {
            this.yCg.H(null, this.yCl);
        }
        if (getListView() != null) {
            getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
                /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass13 */

                public final void onScrollStateChanged(AbsListView absListView, int i2) {
                    AppMethodBeat.i(26176);
                    if (i2 == 2 || i2 == 1) {
                        ContactLabelEditUI.this.hideVKB();
                    }
                    AppMethodBeat.o(26176);
                }

                public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                }
            });
        }
        this.yCi = this.yCf.bmg("contact_label_delete");
        this.yCj = (PreferenceTitleCategory) this.yCf.bmg("contact_label_empty_category");
        if (this.yCk) {
            this.yCf.e(this.yCi);
            this.yCf.e(this.yCj);
            AppMethodBeat.o(26183);
            return;
        }
        if (!this.yCd) {
            this.yCf.e(this.yCi);
        }
        AppMethodBeat.o(26183);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(26184);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            AppMethodBeat.o(26184);
            return;
        }
        switch (i2) {
            case TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL:
                String stringExtra = intent.getStringExtra("Select_Contact");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", String.valueOf(stringExtra));
                if (!Util.isNullOrNil(stringExtra)) {
                    ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
                    if (stringsToList != null && stringsToList.size() > 0) {
                        int size = stringsToList.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            String str = stringsToList.get(i4);
                            if (!Util.isNullOrNil(str)) {
                                if (!ab.IS(str) || this.yCl.contains(str) || str.equals(this.yCq)) {
                                    Log.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", str);
                                } else {
                                    this.yCl.add(str);
                                    if (this.yCm != null && !this.yCm.contains(stringsToList.get(i4))) {
                                        this.yCn.add(str);
                                    }
                                    if (booleanExtra) {
                                        this.yCo.add(str);
                                    }
                                    if (this.yCp != null && this.yCp.contains(str)) {
                                        this.yCp.remove(str);
                                    }
                                }
                            }
                        }
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(26184);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        AppMethodBeat.i(26186);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        switch (qVar.getType()) {
            case b.CTRL_INDEX:
                if (i2 == 0 && i3 == 0) {
                    LinkedList<cgu> linkedList = ((com.tencent.mm.plugin.label.b.a) qVar).ech().KGW;
                    if (linkedList == null || linkedList.size() <= 0) {
                        eck();
                        AppMethodBeat.o(26186);
                        return;
                    }
                    cgu cgu = linkedList.get(0);
                    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new StringBuilder().append(cgu.Mmc).toString(), cgu.Mmb);
                    this.yCa = new StringBuilder().append(cgu.Mmc).toString();
                    ecl();
                    AppMethodBeat.o(26186);
                    return;
                }
                eck();
                AppMethodBeat.o(26186);
                return;
            case 636:
                if (i2 != 0 || i3 != 0) {
                    Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
                    ecm();
                    break;
                } else {
                    a(this.yCb);
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        AppMethodBeat.o(26186);
                        return;
                    }
                }
                break;
            case 637:
                if (i2 == 0 && i3 == 0) {
                    String str2 = this.yCa;
                    String str3 = this.yBZ;
                    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
                    try {
                        i4 = Integer.valueOf(str2).intValue();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", String.valueOf(str2));
                        i4 = -1;
                    }
                    if (i4 != -1) {
                        au bjC = e.ecf().bjC(str2);
                        if (bjC == null) {
                            bjC = new au();
                        }
                        bjC.field_labelID = i4;
                        bjC.field_labelName = str3;
                        bjC.field_labelPYFull = com.tencent.mm.platformtools.f.Sh(str3);
                        bjC.field_labelPYShort = com.tencent.mm.platformtools.f.Si(str3);
                        e.ecf().b(true, bjC, "labelID");
                    } else {
                        eck();
                    }
                    ecl();
                    AppMethodBeat.o(26186);
                    return;
                }
                eck();
                AppMethodBeat.o(26186);
                return;
            case 638:
                if (i2 == 0 && i3 == 0) {
                    ecj();
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        AppMethodBeat.o(26186);
                        return;
                    }
                } else {
                    eck();
                    AppMethodBeat.o(26186);
                    return;
                }
                break;
        }
        AppMethodBeat.o(26186);
    }

    private void eci() {
        AppMethodBeat.i(26187);
        if (this.yCg != null) {
            this.yCg.H(null, this.yCl);
            if (this.yCl == null || this.yCl.size() <= 0) {
                this.yCg.gpE();
            }
        }
        if (this.yCh != null) {
            this.yCh.setText(this.yBZ);
        }
        AppMethodBeat.o(26187);
    }

    private void aCM(String str) {
        AppMethodBeat.i(26188);
        enableOptionMenu(!Util.isNullOrNil(str));
        AppMethodBeat.o(26188);
    }

    private void ecj() {
        int i2;
        int i3;
        AppMethodBeat.i(26189);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
        hideLoading();
        if (this.yCn != null) {
            i2 = this.yCn.size();
        } else {
            i2 = 0;
        }
        if (this.yCp != null) {
            i3 = this.yCp.size();
        } else {
            i3 = 0;
        }
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", Integer.valueOf(i2));
        if (i2 > 0) {
            int size = this.yCo.size();
            int max = Math.max(0, i2 - size);
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[7];
            objArr[0] = z.aTY();
            objArr[1] = 0;
            objArr[2] = 0;
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(this.yCc ? 1 : 2);
            objArr[5] = Integer.valueOf(size);
            objArr[6] = Integer.valueOf(max);
            hVar.a(11220, objArr);
        }
        if (this.yCk) {
            Intent intent = getIntent();
            intent.putExtra("k_sns_label_add_label", this.yBZ);
            setResult(0, intent);
            if (this.yCs) {
                h.INSTANCE.a(16097, 1, 1, 2);
            } else {
                h.INSTANCE.a(16097, 1, 1, 3);
            }
        } else {
            if (i2 > 0) {
                if (this.yCs) {
                    h.INSTANCE.a(16097, 1, 3, 2);
                } else {
                    h.INSTANCE.a(16097, 1, 3, 3);
                }
            }
            if (i3 > 0) {
                if (this.yCs) {
                    h.INSTANCE.a(16097, 1, 4, 2);
                } else {
                    h.INSTANCE.a(16097, 1, 4, 3);
                }
            }
            setResult(0);
        }
        finish();
        AppMethodBeat.o(26189);
    }

    private void eck() {
        AppMethodBeat.i(26190);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
        hideLoading();
        amW(getString(R.string.d8));
        AppMethodBeat.o(26190);
    }

    private static boolean aCN(String str) {
        AppMethodBeat.i(26191);
        if (!Util.isNullOrNil(e.ecf().aCH(str))) {
            AppMethodBeat.o(26191);
            return true;
        }
        AppMethodBeat.o(26191);
        return false;
    }

    private void ecl() {
        int size;
        int size2;
        AppMethodBeat.i(26192);
        Object[] objArr = new Object[2];
        if (this.yCn == null) {
            size = 0;
        } else {
            size = this.yCn.size();
        }
        objArr[0] = Integer.valueOf(size);
        if (this.yCp == null) {
            size2 = 0;
        } else {
            size2 = this.yCp.size();
        }
        objArr[1] = Integer.valueOf(size2);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", objArr);
        LinkedList linkedList = new LinkedList();
        if (this.yCn != null && this.yCn.size() > 0) {
            this.yCn.size();
            Iterator<String> it = this.yCn.iterator();
            while (it.hasNext()) {
                bg.aVF();
                as Kn = c.aSN().Kn(it.next());
                String str = Kn.field_contactLabelIds;
                String it2 = com.tencent.mm.plugin.label.c.it(str, this.yCa);
                Log.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", str, it2);
                if (!it2.equalsIgnoreCase(str)) {
                    eov eov = new eov();
                    eov.UserName = Kn.field_username;
                    eov.Lqm = it2;
                    linkedList.add(eov);
                }
            }
        }
        if (this.yCp != null && this.yCp.size() > 0) {
            this.yCp.size();
            Iterator<String> it3 = this.yCp.iterator();
            while (it3.hasNext()) {
                String next = it3.next();
                bg.aVF();
                String str2 = c.aSN().Kn(next).field_contactLabelIds;
                String iu = com.tencent.mm.plugin.label.c.iu(str2, this.yCa);
                Log.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", next, str2, iu);
                if (!iu.equalsIgnoreCase(str2)) {
                    eov eov2 = new eov();
                    eov2.UserName = next;
                    eov2.Lqm = iu;
                    linkedList.add(eov2);
                }
            }
        }
        if (linkedList.size() > 0) {
            bg.azz().a(new com.tencent.mm.plugin.label.b.d(linkedList), 0);
            AppMethodBeat.o(26192);
            return;
        }
        ecj();
        AppMethodBeat.o(26192);
    }

    private void aCL(String str) {
        AppMethodBeat.i(26193);
        getString(R.string.zb);
        this.jZH = com.tencent.mm.ui.base.h.a((Context) this, str, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(26163);
                bg.azz().cancel(b.CTRL_INDEX);
                bg.azz().cancel(637);
                AppMethodBeat.o(26163);
            }
        });
        AppMethodBeat.o(26193);
    }

    private void hideLoading() {
        AppMethodBeat.i(26194);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        AppMethodBeat.o(26194);
    }

    private void amW(String str) {
        AppMethodBeat.i(26195);
        com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(26195);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(26196);
        if ((Util.isNullOrNil(this.yBZ) || this.yBZ.equals(this.yBY)) && ((this.yCn == null || this.yCn.size() <= 0) && (this.yCp == null || this.yCp.size() <= 0))) {
            setResult(0);
            finish();
            AppMethodBeat.o(26196);
            return;
        }
        com.tencent.mm.ui.base.h.c(this, getString(R.string.gar), "", getString(R.string.am8), getString(R.string.ama), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(26164);
                ContactLabelEditUI.b(ContactLabelEditUI.this);
                AppMethodBeat.o(26164);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(26165);
                ContactLabelEditUI.this.setResult(0);
                ContactLabelEditUI.this.finish();
                AppMethodBeat.o(26165);
            }
        });
        AppMethodBeat.o(26196);
    }

    private void a(au auVar) {
        AppMethodBeat.i(26197);
        if (!e.ecf().a(auVar, "labelID")) {
            Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
            ecm();
            AppMethodBeat.o(26197);
            return;
        }
        ecn();
        AppMethodBeat.o(26197);
    }

    private void ecm() {
        AppMethodBeat.i(26198);
        amW(getString(R.string.bl5));
        AppMethodBeat.o(26198);
    }

    private void ecn() {
        AppMethodBeat.i(26199);
        setResult(-1);
        finish();
        AppMethodBeat.o(26199);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public String getIdentString() {
        if (this.yCk) {
            return "_New";
        }
        return "_Edit";
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(26185);
        String str = preference.mKey;
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
            AppMethodBeat.o(26185);
        } else {
            if (str.equals("contact_label_delete")) {
                com.tencent.mm.ui.base.h.c(this, getString(R.string.ebi), "", getString(R.string.tf), getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass14 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(26177);
                        ContactLabelEditUI.m(ContactLabelEditUI.this);
                        AppMethodBeat.o(26177);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.label.ui.ContactLabelEditUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
            Log.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", str);
            AppMethodBeat.o(26185);
        }
        return false;
    }

    static /* synthetic */ void b(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.i(26201);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveLabelChange]");
        contactLabelEditUI.aCL(contactLabelEditUI.getString(R.string.ebv));
        contactLabelEditUI.yBZ = Util.nullAs(contactLabelEditUI.yBZ, "");
        contactLabelEditUI.yBZ = contactLabelEditUI.yBZ.trim();
        if (Util.isNullOrNil(contactLabelEditUI.yBZ)) {
            contactLabelEditUI.hideLoading();
            contactLabelEditUI.amW(contactLabelEditUI.getString(R.string.ebn));
            AppMethodBeat.o(26201);
        } else if (com.tencent.mm.ui.tools.f.bnP(contactLabelEditUI.yBZ) > 36) {
            contactLabelEditUI.hideLoading();
            contactLabelEditUI.amW(String.format(contactLabelEditUI.getString(R.string.d_), Integer.valueOf(com.tencent.mm.ui.tools.f.dp(36, ""))));
            AppMethodBeat.o(26201);
        } else if ((!aCN(contactLabelEditUI.yBZ) || !contactLabelEditUI.yCk) && (!aCN(contactLabelEditUI.yBZ) || Util.isNullOrNil(contactLabelEditUI.yBY) || contactLabelEditUI.yBY.equals(contactLabelEditUI.yBZ))) {
            au bjC = e.ecf().bjC(contactLabelEditUI.yCa);
            if (contactLabelEditUI.yCk || bjC.field_isTemporary) {
                bg.azz().a(new com.tencent.mm.plugin.label.b.a(contactLabelEditUI.yBZ), 0);
                AppMethodBeat.o(26201);
                return;
            }
            bg.azz().a(new com.tencent.mm.plugin.label.b.e(Util.getInt(contactLabelEditUI.yCa, 0), contactLabelEditUI.yBZ), 0);
            AppMethodBeat.o(26201);
        } else {
            contactLabelEditUI.hideLoading();
            contactLabelEditUI.amW(contactLabelEditUI.getString(R.string.d7));
            AppMethodBeat.o(26201);
        }
    }

    static /* synthetic */ void e(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.i(26202);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealAddContact]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", u.Q(u.PWS, 1024));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelEditUI.getString(R.string.ebf));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 6);
        if (contactLabelEditUI.yCl != null) {
            intent.putExtra("always_select_contact", Util.listToString(contactLabelEditUI.yCl, ","));
        }
        com.tencent.mm.br.c.c(contactLabelEditUI, ".ui.contact.SelectContactUI", intent, (int) TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL);
        AppMethodBeat.o(26202);
    }

    static /* synthetic */ void a(ContactLabelEditUI contactLabelEditUI, String str) {
        AppMethodBeat.i(26203);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealRemoveContact]");
        if (contactLabelEditUI.yCl != null && contactLabelEditUI.yCl.contains(str)) {
            contactLabelEditUI.yCl.remove(str);
        }
        if (contactLabelEditUI.yCm != null && contactLabelEditUI.yCm.contains(str)) {
            contactLabelEditUI.yCp.add(str);
        }
        if (contactLabelEditUI.yCn != null && contactLabelEditUI.yCn.contains(str)) {
            contactLabelEditUI.yCn.remove(str);
            contactLabelEditUI.yCo.remove(str);
        }
        if (contactLabelEditUI.mHandler != null) {
            contactLabelEditUI.mHandler.sendEmptyMessage(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
        }
        AppMethodBeat.o(26203);
    }

    static /* synthetic */ void m(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.i(26205);
        if (contactLabelEditUI.yCb.field_isTemporary) {
            contactLabelEditUI.a(contactLabelEditUI.yCb);
        } else {
            au auVar = contactLabelEditUI.yCb;
            if (auVar == null) {
                Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteScene] can not do scene. lable is null");
            } else {
                contactLabelEditUI.aCL(contactLabelEditUI.getString(R.string.ebj));
                bg.azz().a(new com.tencent.mm.plugin.label.b.b(new StringBuilder().append(auVar.field_labelID).toString()), 0);
            }
        }
        if (contactLabelEditUI.yCs) {
            h.INSTANCE.a(16097, 1, 2, 2);
            AppMethodBeat.o(26205);
            return;
        }
        h.INSTANCE.a(16097, 1, 2, 3);
        AppMethodBeat.o(26205);
    }
}
