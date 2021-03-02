package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.ui.bd;
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

public class SnsLabelUI extends MMActivity implements i {
    public static int[] EEO = {R.string.h7n, R.string.h7l, R.string.h7h, R.string.h79};
    private AnimatedExpandableListView EEN;
    private ArrayList<String> EEP;
    private String EEQ;
    private String EER;
    private String EES;
    bd EET;
    private int EEU = 0;
    private boolean EEV = false;
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

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ int fis() {
        AppMethodBeat.i(98814);
        int fin = fin();
        AppMethodBeat.o(98814);
        return fin;
    }

    static /* synthetic */ void i(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(98819);
        snsLabelUI.goBack();
        AppMethodBeat.o(98819);
    }

    static /* synthetic */ void l(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(98820);
        snsLabelUI.fiq();
        AppMethodBeat.o(98820);
    }

    static /* synthetic */ void o(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(98821);
        snsLabelUI.fim();
        AppMethodBeat.o(98821);
    }

    static /* synthetic */ void p(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(98822);
        snsLabelUI.fil();
        AppMethodBeat.o(98822);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bw3;
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(98796);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
            AppMethodBeat.o(98796);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(98796);
        return dispatchKeyEvent;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98797);
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
        this.EET = new bd(this);
        this.EET.EFz = new bd.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ui.bd.b
            public final void a(bd.c cVar) {
                AppMethodBeat.i(98784);
                SnsLabelUI.a(SnsLabelUI.this, cVar.EFE, cVar.EFF);
                AppMethodBeat.o(98784);
            }
        };
        Intent intent = getIntent();
        if (intent == null) {
            this.EEU = 0;
            this.EET.style = 0;
            this.EEQ = null;
            this.EER = null;
            this.EES = null;
        } else {
            this.EEV = intent.getBooleanExtra("Kis_from_text_status", false);
            this.EEU = intent.getIntExtra("KLabel_range_index", 0);
            this.EET.style = intent.getIntExtra("k_sns_label_ui_style", 0);
            this.EEQ = intent.getStringExtra("Klabel_name_list");
            this.EER = intent.getStringExtra("Kother_user_name_list");
            this.EES = intent.getStringExtra("Kchat_room_name_list");
            if (!TextUtils.isEmpty(intent.getStringExtra("k_sns_label_ui_title"))) {
                setMMTitle(intent.getStringExtra("k_sns_label_ui_title"));
            }
        }
        this.EET.EFr = this.EEU;
        this.EET.EEV = this.EEV;
        if (this.EET.style == 1) {
            findViewById(R.id.hyi).setBackgroundResource(R.color.fm);
        }
        if (this.EEU == 2) {
            if (!TextUtils.isEmpty(this.EEQ)) {
                this.EET.EFt = Util.stringsToList(this.EEQ.split(","));
            }
            if (!TextUtils.isEmpty(this.EER)) {
                this.EET.EFv = Util.stringsToList(this.EER.split(","));
            }
            if (this.EES != null && !this.EES.isEmpty()) {
                this.EET.EFx = Util.stringsToList(this.EES.split(","));
            }
        } else if (this.EEU == 3) {
            if (!TextUtils.isEmpty(this.EEQ)) {
                this.EET.EFu = Util.stringsToList(this.EEQ.split(","));
            }
            if (!TextUtils.isEmpty(this.EER)) {
                this.EET.EFw = Util.stringsToList(this.EER.split(","));
            }
            if (this.EES != null && !this.EES.isEmpty()) {
                this.EET.EFy = Util.stringsToList(this.EES.split(","));
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
        AppMethodBeat.o(98797);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(98798);
        boolean booleanExtra = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
        this.EEN = (AnimatedExpandableListView) findViewById(R.id.hyh);
        this.EEP = (ArrayList) a.ecg().ecb();
        this.EET.EFs = booleanExtra;
        this.EET.aR(this.EEP);
        fiq();
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(R.dimen.hv);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.EEN.addHeaderView(view);
        this.EEN.setAdapter(this.EET);
        if (this.EET.EFr == 2) {
            this.EEN.expandGroup(2);
        } else if (this.EET.EFr == 3) {
            this.EEN.expandGroup(3);
        }
        this.EEN.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass5 */

            public final boolean onGroupClick(ExpandableListView expandableListView, View view, final int i2, long j2) {
                AppMethodBeat.i(98788);
                int i3 = SnsLabelUI.this.EET.EFr;
                e.DUQ.YP(i2);
                Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", Integer.valueOf(i3), Integer.valueOf(i2));
                if (i2 <= 1) {
                    if (i3 > 1) {
                        SnsLabelUI.this.EEN.apj(i3);
                    }
                    SnsLabelUI.this.EET.EFr = i2;
                    AppMethodBeat.o(98788);
                    return false;
                } else if (SnsLabelUI.this.EFf != null && SnsLabelUI.this.EFf.size() != 0 && SnsLabelUI.fis() == 0) {
                    SnsLabelUI.this.EFa = i2;
                    SnsLabelUI.c(SnsLabelUI.this);
                    Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
                    AppMethodBeat.o(98788);
                    return true;
                } else if (SnsLabelUI.this.EEZ) {
                    SnsLabelUI.this.EEX = true;
                    SnsLabelUI.this.EFa = i2;
                    SnsLabelUI.this.EFb = h.a((Context) SnsLabelUI.this, SnsLabelUI.this.getString(R.string.h7j), false, (DialogInterface.OnCancelListener) null);
                    Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
                    AppMethodBeat.o(98788);
                    return true;
                } else if (SnsLabelUI.this.EET.EFq == null || SnsLabelUI.this.EET.EFq.size() == 0) {
                    SnsLabelUI.this.EFa = i2;
                    SnsLabelUI.f(SnsLabelUI.this);
                    Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
                    AppMethodBeat.o(98788);
                    return true;
                } else {
                    if (i3 != i2) {
                        if (i3 == 2) {
                            SnsLabelUI.this.EEN.collapseGroup(2);
                            SnsLabelUI.this.EET.EFt.clear();
                            SnsLabelUI.this.EET.EFv.clear();
                        } else if (i3 == 3) {
                            SnsLabelUI.this.EEN.collapseGroup(3);
                            SnsLabelUI.this.EET.EFu.clear();
                            SnsLabelUI.this.EET.EFw.clear();
                        }
                        SnsLabelUI.this.EEN.post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(98787);
                                SnsLabelUI.this.EEN.api(i2);
                                AppMethodBeat.o(98787);
                            }
                        });
                    } else if (SnsLabelUI.this.EEN.isGroupExpanded(i2)) {
                        SnsLabelUI.this.EEN.apj(i2);
                    } else {
                        SnsLabelUI.this.EEN.api(i2);
                    }
                    SnsLabelUI.this.EET.EFr = i2;
                    AppMethodBeat.o(98788);
                    return true;
                }
            }
        });
        this.EEN.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass6 */

            public final boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
                AppMethodBeat.i(98789);
                if (i3 == bd.EFn) {
                    SnsLabelUI.this.EFa = i2;
                    SnsLabelUI.f(SnsLabelUI.this);
                } else if (i3 == bd.EFm) {
                    SnsLabelUI.this.EFa = i2;
                    SnsLabelUI.h(SnsLabelUI.this);
                } else {
                    String str = (String) SnsLabelUI.this.EET.getChild(i2, i3 - bd.EFo);
                    bd unused = SnsLabelUI.this.EET;
                    bd.aRb(str);
                    if (i2 == 2) {
                        SnsLabelUI.a(SnsLabelUI.this, 1, SnsLabelUI.this.EET.EFt, str, view);
                    } else if (i2 == 3) {
                        SnsLabelUI.a(SnsLabelUI.this, 2, SnsLabelUI.this.EET.EFu, str, view);
                    }
                }
                if (i3 == bd.EFn) {
                    e eVar = e.DUQ;
                    if (eVar.DVa != null) {
                        if (eVar.DVa.eTt <= 0) {
                            eVar.DVa.eTt = 1;
                        } else {
                            eVar.DVa.eTt++;
                        }
                    }
                } else if (i3 == bd.EFm) {
                    e eVar2 = e.DUQ;
                    if (eVar2.DVa != null) {
                        if (eVar2.DVa.eTo <= 0) {
                            eVar2.DVa.eTo = 1;
                        } else {
                            eVar2.DVa.eTo++;
                        }
                    }
                }
                AppMethodBeat.o(98789);
                return false;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98790);
                SnsLabelUI.i(SnsLabelUI.this);
                AppMethodBeat.o(98790);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.h7a), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98791);
                SnsLabelUI snsLabelUI = SnsLabelUI.this;
                String listToString = Util.listToString(snsLabelUI.EET.EFt, ",");
                String listToString2 = Util.listToString(snsLabelUI.EET.EFv, ",");
                String listToString3 = Util.listToString(snsLabelUI.EET.EFx, ",");
                String listToString4 = Util.listToString(snsLabelUI.EET.EFu, ",");
                String listToString5 = Util.listToString(snsLabelUI.EET.EFw, ",");
                String listToString6 = Util.listToString(snsLabelUI.EET.EFy, ",");
                if ((snsLabelUI.EET.EFr == 2 && snsLabelUI.EET.EFt.size() == 0 && snsLabelUI.EET.EFv.size() == 0 && snsLabelUI.EET.EFx.size() == 0) || (snsLabelUI.EET.EFr == 3 && snsLabelUI.EET.EFu.size() == 0 && snsLabelUI.EET.EFw.size() == 0 && snsLabelUI.EET.EFy.size() == 0)) {
                    h.a(snsLabelUI, snsLabelUI.getString(R.string.h7k), "", snsLabelUI.getString(R.string.h7w), (DialogInterface.OnClickListener) null);
                } else if ((snsLabelUI.EET.EFr != 2 || !Util.isNullOrNil(listToString) || !Util.isNullOrNil(listToString2) || !Util.isNullOrNil(listToString3)) && (snsLabelUI.EET.EFr != 3 || !Util.isNullOrNil(listToString4) || !Util.isNullOrNil(listToString5) || !Util.isNullOrNil(listToString6))) {
                    snsLabelUI.fim();
                } else {
                    h.a(snsLabelUI, snsLabelUI.getString(R.string.h7k), "", snsLabelUI.getString(R.string.h7w), (DialogInterface.OnClickListener) null);
                }
                AppMethodBeat.o(98791);
                return true;
            }
        }, null, t.b.GREEN);
        AppMethodBeat.o(98798);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(98799);
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 4003) {
            Log.i("MicroMsg.SnsLabelUI", "the Activity completed");
            String stringExtra = intent.getStringExtra("Select_Contacts_To_Create_New_Label");
            if (!Util.isNullOrNil(stringExtra)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                c.b(getContext(), "label", ".ui.ContactLabelEditUI", intent2, 4002);
                AppMethodBeat.o(98799);
                return;
            }
            String stringExtra2 = intent.getStringExtra("Select_Contact");
            this.EER = new String(stringExtra2);
            Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra2));
            if (this.EFa == 2) {
                this.EET.EFv.clear();
                if (!Util.isNullOrNil(stringExtra2)) {
                    this.EET.EFv.addAll(Util.stringsToList(stringExtra2.split(",")));
                    this.EET.EFr = this.EFa;
                }
            } else if (this.EFa == 3) {
                this.EET.EFw.clear();
                if (!Util.isNullOrNil(stringExtra2)) {
                    this.EET.EFw.addAll(Util.stringsToList(stringExtra2.split(",")));
                    this.EET.EFr = this.EFa;
                }
            }
            this.EET.notifyDataSetChanged();
            this.EEN.expandGroup(this.EFa);
            AppMethodBeat.o(98799);
        } else if (i3 == -1 && i2 == 4001) {
            String stringExtra3 = intent.getStringExtra("Select_Contact");
            Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra3));
            if (!Util.isNullOrNil(stringExtra3)) {
                Intent intent3 = new Intent();
                intent3.putExtra("Select_Contact", stringExtra3);
                c.b(this, "label", ".ui.ContactLabelEditUI", intent3, 4002);
            }
            AppMethodBeat.o(98799);
        } else if (i3 == 0 && i2 == 4002 && intent != null) {
            final String stringExtra4 = intent.getStringExtra("k_sns_label_add_label");
            this.EFc = intent.getStringExtra("k_sns_label_add_label");
            this.EEN.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass10 */

                public final void run() {
                    int i2;
                    AppMethodBeat.i(98793);
                    SnsLabelUI.this.EEP = (ArrayList) a.ecg().ecb();
                    if (SnsLabelUI.this.EEP == null) {
                        SnsLabelUI.this.EEP = new ArrayList();
                    }
                    if (!Util.isNullOrNil(stringExtra4)) {
                        if (!SnsLabelUI.this.EEP.contains(stringExtra4)) {
                            SnsLabelUI.this.EEP.add(stringExtra4);
                        }
                        i2 = SnsLabelUI.this.EEP.indexOf(stringExtra4);
                    } else {
                        i2 = -1;
                    }
                    SnsLabelUI.this.EET.aR(SnsLabelUI.this.EEP);
                    SnsLabelUI.l(SnsLabelUI.this);
                    SnsLabelUI.this.EET.EFr = SnsLabelUI.this.EFa;
                    if (!Util.isNullOrNil(stringExtra4) && i2 != -1) {
                        if (SnsLabelUI.this.EFa == 2) {
                            SnsLabelUI.this.EET.EFt.add(stringExtra4);
                            SnsLabelUI.this.EET.EFv.clear();
                        } else if (SnsLabelUI.this.EFa == 3) {
                            SnsLabelUI.this.EET.EFu.add(stringExtra4);
                            SnsLabelUI.this.EET.EFw.clear();
                        }
                    }
                    SnsLabelUI.this.EET.notifyDataSetChanged();
                    SnsLabelUI.this.EEN.expandGroup(SnsLabelUI.this.EFa);
                    SnsLabelUI.this.EFc = null;
                    AppMethodBeat.o(98793);
                }
            }, 600);
            AppMethodBeat.o(98799);
        } else {
            if (i3 == -1 && i2 == 4004) {
                Log.i("MicroMsg.SnsLabelUI", "the Activity completed");
                String stringExtra5 = intent.getStringExtra("select_chatrooms");
                this.EES = stringExtra5;
                Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra5));
                if (this.EFa == 2) {
                    this.EET.EFx.clear();
                    if (!Util.isNullOrNil(stringExtra5)) {
                        this.EET.EFx.addAll(Util.stringsToList(stringExtra5.split(",")));
                        this.EET.EFr = this.EFa;
                    }
                } else if (this.EFa == 3) {
                    this.EET.EFy.clear();
                    if (!Util.isNullOrNil(stringExtra5)) {
                        this.EET.EFy.addAll(Util.stringsToList(stringExtra5.split(",")));
                        this.EET.EFr = this.EFa;
                    }
                }
                this.EET.notifyDataSetChanged();
                this.EEN.expandGroup(this.EFa);
            }
            AppMethodBeat.o(98799);
        }
    }

    private boolean fik() {
        boolean z = true;
        AppMethodBeat.i(98800);
        int i2 = this.EET.EFr;
        if (this.EET.EFr == this.EEU ? (i2 != 2 || this.EET.EFt.size() == 0 || (Util.listToString(this.EET.EFt, ",").equals(this.EEQ) && Util.listToString(this.EET.EFv, ",").equals(this.EER) && Util.listToString(this.EET.EFx, ",").equals(this.EES))) && (i2 != 3 || this.EET.EFu.size() == 0 || (Util.listToString(this.EET.EFu, ",").equals(this.EEQ) && Util.listToString(this.EET.EFw, ",").equals(this.EER) && Util.listToString(this.EET.EFy, ",").equals(this.EES))) : (i2 != 2 || (this.EET.EFt.size() == 0 && this.EET.EFv.size() == 0)) && !((i2 == 3 && (this.EET.EFu.size() != 0 || this.EET.EFw.size() != 0)) || i2 == 1 || i2 == 0)) {
            z = false;
        }
        AppMethodBeat.o(98800);
        return z;
    }

    private void goBack() {
        AppMethodBeat.i(98801);
        if (fik()) {
            h.a((Context) this, true, getString(R.string.h7e), "", getString(R.string.h7d), getString(R.string.h7c), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(98794);
                    SnsLabelUI.o(SnsLabelUI.this);
                    AppMethodBeat.o(98794);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(98795);
                    SnsLabelUI.p(SnsLabelUI.this);
                    AppMethodBeat.o(98795);
                }
            });
            AppMethodBeat.o(98801);
            return;
        }
        fil();
        AppMethodBeat.o(98801);
    }

    private void fil() {
        AppMethodBeat.i(98802);
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.EEU);
        if (this.EEU == 2 || this.EEU == 3) {
            fir();
            intent.putExtra("Klabel_name_list", this.EEQ);
            intent.putExtra("Kother_user_name_list", this.EER);
            intent.putExtra("Kchat_room_name_list", this.EES);
        }
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(98802);
    }

    /* access modifiers changed from: package-private */
    public final void fim() {
        AppMethodBeat.i(98803);
        Intent intent = new Intent();
        if (this.EET.EFr == 2) {
            this.EEQ = Util.listToString(this.EET.EFt, ",");
            this.EER = Util.listToString(this.EET.EFv, ",");
            this.EES = Util.listToString(this.EET.EFx, ",");
            fir();
            intent.putExtra("Klabel_name_list", this.EEQ);
            intent.putExtra("Kother_user_name_list", this.EER);
            intent.putExtra("Kchat_room_name_list", this.EES);
        } else if (this.EET.EFr == 3) {
            this.EEQ = Util.listToString(this.EET.EFu, ",");
            this.EER = Util.listToString(this.EET.EFw, ",");
            this.EES = Util.listToString(this.EET.EFy, ",");
            fir();
            intent.putExtra("Klabel_name_list", this.EEQ);
            intent.putExtra("Kother_user_name_list", this.EER);
            intent.putExtra("Kchat_room_name_list", this.EES);
        }
        intent.putExtra("Ktag_range_index", this.EET.EFr);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(98803);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98804);
        g.aAi();
        g.aAg().hqi.b(l.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(b.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(638, this);
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, this);
        super.onDestroy();
        AppMethodBeat.o(98804);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(98805);
        if (!(this.EET == null || this.EFc != null || this.EEN == null)) {
            this.EEN.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(98785);
                    a.ecg().aHn();
                    SnsLabelUI.this.EEP = (ArrayList) a.ecg().ecb();
                    SnsLabelUI.this.EET.aR(SnsLabelUI.this.EEP);
                    SnsLabelUI.l(SnsLabelUI.this);
                    if ((SnsLabelUI.this.EEP == null || SnsLabelUI.this.EEP.size() == 0) && ((SnsLabelUI.this.EER == null || SnsLabelUI.this.EER.length() == 0) && SnsLabelUI.this.EET.EFr != 0 && SnsLabelUI.this.EET.EFr != 1 && (SnsLabelUI.this.EES == null || SnsLabelUI.this.EES.length() == 0))) {
                        SnsLabelUI.this.EET.EFr = 0;
                    }
                    SnsLabelUI.this.EET.notifyDataSetChanged();
                    SnsLabelUI.this.EFc = null;
                    AppMethodBeat.o(98785);
                }
            }, 600);
        }
        super.onResume();
        AppMethodBeat.o(98805);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f3, code lost:
        if (r0 == false) goto L_0x00f5;
     */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
        /*
        // Method dump skipped, instructions count: 618
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsLabelUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    private static int fin() {
        AppMethodBeat.i(98807);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(335874, (Object) 0)).intValue();
        AppMethodBeat.o(98807);
        return intValue;
    }

    private static void fio() {
        AppMethodBeat.i(98808);
        g.aAi();
        g.aAi();
        g.aAh().azQ().set(335874, Integer.valueOf(((Integer) g.aAh().azQ().get(335874, (Object) 0)).intValue() + 1));
        AppMethodBeat.o(98808);
    }

    private void fip() {
        AppMethodBeat.i(98809);
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
            AppMethodBeat.o(98809);
            return;
        }
        int i2 = R.string.h7v;
        if (fin() > 1) {
            i2 = R.string.h7u;
        }
        h.a(this, i2, (int) R.string.x_, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(98809);
    }

    private void hd(List<String[]> list) {
        AppMethodBeat.i(98810);
        if (this.EFf == null || this.EFf.size() == 0) {
            AppMethodBeat.o(98810);
            return;
        }
        Iterator<String> it = this.EFf.iterator();
        Iterator<String[]> it2 = list.iterator();
        ArrayList arrayList = new ArrayList(this.EFf.size());
        ArrayList arrayList2 = new ArrayList(this.EFf.size());
        while (it.hasNext()) {
            arrayList.add(a.ecg().aCH(it.next()));
            arrayList2.add(Util.listToString(Arrays.asList(it2.next()), ","));
            this.EEY = true;
        }
        a.ecg().p(arrayList, arrayList2);
        AppMethodBeat.o(98810);
    }

    private void fiq() {
        AppMethodBeat.i(98811);
        if (this.EEP == null || this.EEP.isEmpty()) {
            if (this.EET.EFt != null) {
                this.EET.EFt.clear();
            }
            if (this.EET.EFu != null) {
                this.EET.EFu.clear();
            }
            AppMethodBeat.o(98811);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.EEU != 2 || this.EET.EFt == null) {
            if (this.EEU == 3) {
                Iterator<String> it = this.EET.EFu.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!this.EEP.contains(next)) {
                        arrayList.add(next);
                    }
                }
                this.EET.EFu.removeAll(arrayList);
            }
            AppMethodBeat.o(98811);
            return;
        }
        Iterator<String> it2 = this.EET.EFt.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!this.EEP.contains(next2)) {
                arrayList.add(next2);
            }
        }
        this.EET.EFt.removeAll(arrayList);
        AppMethodBeat.o(98811);
    }

    private void fir() {
        ArrayList<String> stringsToList;
        AppMethodBeat.i(98812);
        if (this.EEP == null || this.EEP.isEmpty()) {
            this.EEQ = "";
            AppMethodBeat.o(98812);
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
        AppMethodBeat.o(98812);
    }

    static /* synthetic */ void a(SnsLabelUI snsLabelUI, int i2, int i3) {
        Object child;
        AppMethodBeat.i(98813);
        if (!(snsLabelUI.EET == null || (child = snsLabelUI.EET.getChild(i2, i3)) == null || !(child instanceof String))) {
            String str = (String) child;
            String aCH = a.ecg().aCH(str);
            Intent intent = new Intent();
            intent.putExtra("label_id", aCH);
            intent.putExtra("label_name", str);
            intent.putExtra("is_show_delete", false);
            c.b(snsLabelUI.getContext(), "label", ".ui.ContactLabelEditUI", intent, 4002);
        }
        AppMethodBeat.o(98813);
    }

    static /* synthetic */ void c(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(98815);
        h.a(snsLabelUI, snsLabelUI.getString(R.string.h7x), (String) null, snsLabelUI.getString(R.string.h7w), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsLabelUI.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(98792);
                SnsLabelUI.this.EEY = true;
                a.ecg().fi(SnsLabelUI.this.EFf);
                SnsLabelUI.this.EFb = h.a((Context) SnsLabelUI.this, SnsLabelUI.this.getString(R.string.h7j), false, (DialogInterface.OnCancelListener) null);
                AppMethodBeat.o(98792);
            }
        });
        AppMethodBeat.o(98815);
    }

    static /* synthetic */ void f(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(98816);
        Intent intent = new Intent();
        intent.putExtra("titile", snsLabelUI.getString(R.string.g4));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_attr", u.Q(u.PWS));
        if (snsLabelUI.EFa == 2) {
            if (snsLabelUI.EET.EFv.size() > 0) {
                intent.putExtra("already_select_contact", Util.listToString(snsLabelUI.EET.EFv, ","));
            }
        } else if (snsLabelUI.EFa == 3 && snsLabelUI.EET.EFw.size() > 0) {
            intent.putExtra("already_select_contact", Util.listToString(snsLabelUI.EET.EFw, ","));
        }
        intent.putExtra("KBlockOpenImFav", true);
        c.c(snsLabelUI, ".ui.contact.SelectContactUI", intent, (int) WearableStatusCodes.DATA_ITEM_TOO_LARGE);
        AppMethodBeat.o(98816);
    }

    static /* synthetic */ void h(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(98817);
        Intent intent = new Intent(snsLabelUI, SnsSelectChatRoomUI.class);
        intent.putExtra("titile", snsLabelUI.getString(R.string.h7g));
        if (snsLabelUI.EFa == 2) {
            if (snsLabelUI.EET.EFx.size() > 0) {
                intent.putExtra("already_select_contact", Util.listToString(snsLabelUI.EET.EFx, ","));
            }
        } else if (snsLabelUI.EFa == 3 && snsLabelUI.EET.EFy.size() > 0) {
            intent.putExtra("already_select_contact", Util.listToString(snsLabelUI.EET.EFy, ","));
        }
        intent.putExtra("KBlockOpenImFav", true);
        snsLabelUI.startActivityForResult(intent, WearableStatusCodes.INVALID_TARGET_NODE);
        AppMethodBeat.o(98817);
    }

    static /* synthetic */ void a(SnsLabelUI snsLabelUI, int i2, ArrayList arrayList, String str, View view) {
        AppMethodBeat.i(98818);
        if (snsLabelUI.EET == null || snsLabelUI.EET.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.drawable.p5);
                AppMethodBeat.o(98818);
                return;
            }
            arrayList.add(str);
            if (i2 == 1) {
                ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.checkbox_selected);
                AppMethodBeat.o(98818);
                return;
            }
            ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.checkbox_selected_red);
            AppMethodBeat.o(98818);
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i2 == 1) {
                ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.sight_list_checkbox_unselected);
                AppMethodBeat.o(98818);
                return;
            }
            ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.sight_list_checkbox_unselected_red);
            AppMethodBeat.o(98818);
        } else {
            arrayList.add(str);
            if (i2 == 1) {
                ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.sight_list_checkbox_selected);
                AppMethodBeat.o(98818);
                return;
            }
            ((ImageView) view.findViewById(R.id.hyg)).setImageResource(R.raw.sight_list_checkbox_selected_red);
            AppMethodBeat.o(98818);
        }
    }
}
