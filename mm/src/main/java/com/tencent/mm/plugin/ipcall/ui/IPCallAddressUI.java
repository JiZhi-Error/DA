package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.b;
import com.tencent.mm.plugin.ipcall.model.a;
import com.tencent.mm.plugin.ipcall.model.d;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;

public class IPCallAddressUI extends MMActivity implements i {
    private View yua;
    private ListView yum;
    private e yun = null;
    private int yuo = 0;
    private boolean yup = false;
    private boolean yuq = true;
    private boolean yur = false;
    private IListener yus = new IListener<kw>() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161387);
            this.__eventId = kw.class.getName().hashCode();
            AppMethodBeat.o(161387);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kw kwVar) {
            AppMethodBeat.i(25666);
            if (IPCallAddressUI.this.yun != null) {
                IPCallAddressUI.this.yun.ebh();
            }
            AppMethodBeat.o(25666);
            return true;
        }
    };
    private Runnable yut = new Runnable() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(25668);
            a.eab().a((a.AbstractC1439a) null, true);
            AppMethodBeat.o(25668);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallAddressUI() {
        AppMethodBeat.i(25671);
        AppMethodBeat.o(25671);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25672);
        super.onCreate(bundle);
        bg.aVF();
        if (((Boolean) c.azQ().get(ar.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            bg.aVF();
            c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.FALSE);
            Intent intent = new Intent();
            intent.setClass(getContext(), IPCallAcitivityUI.class);
            AppCompatActivity context = getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            overridePendingTransition(R.anim.eq, R.anim.en);
            this.yuq = false;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25667);
                if (IPCallAddressUI.this.yuo == 1) {
                    b.jRt.o(new Intent(), IPCallAddressUI.this);
                } else {
                    IPCallAddressUI.this.finish();
                }
                AppMethodBeat.o(25667);
                return true;
            }
        });
        if (this.yuq) {
            this.yur = true;
            ebj();
        }
        bg.aVF();
        this.yup = ((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.TRUE)).booleanValue();
        setMMTitle(R.string.e6i);
        this.yum = (ListView) findViewById(R.id.h1);
        this.yua = findViewById(R.id.hs);
        this.yun = new e(this, this.yum, this.yua);
        e eVar = this.yun;
        eVar.ytZ = new h(eVar.yub);
        ViewGroup viewGroup = (ViewGroup) View.inflate(eVar.yub, R.layout.aws, null);
        eVar.ytY.addHeaderView(viewGroup, null, false);
        eVar.ytY.setAdapter((ListAdapter) eVar.ytZ);
        eVar.yud = (TextView) viewGroup.findViewById(R.id.bo);
        eVar.yue = (TextView) viewGroup.findViewById(R.id.bw);
        eVar.yuf = (LinearLayout) viewGroup.findViewById(R.id.bk);
        eVar.yug = (TextView) viewGroup.findViewById(R.id.bl);
        eVar.yuh = (ImageView) viewGroup.findViewById(R.id.j09);
        viewGroup.findViewById(R.id.bx).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.e.AnonymousClass1 */

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(25649);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bg.aVF();
                boolean booleanValue = ((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue();
                if (booleanValue) {
                    bg.aVF();
                    int intValue = ((Integer) c.azQ().get(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, (Object) -1)).intValue();
                    com.tencent.mm.plugin.ipcall.model.f.i.am(2, intValue, -1);
                    bg.aVF();
                    c.azQ().set(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, (Object) -1);
                    Log.i("MicroMsg.IPCallAddressController", "set red dot type from %d to -1", Integer.valueOf(intValue));
                }
                String str = booleanValue ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                bg.aVF();
                Log.i("MicroMsg.IPCallAddressController", "set show red dot from %s to false, set account string from %s to null", str, (String) c.azQ().get(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, ""));
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                bg.aVF();
                c.azQ().set(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, "");
                bg.aVF();
                if (((Integer) c.azQ().get(ar.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT, (Object) 0)).intValue() == 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    bg.aVF();
                    Log.i("MicroMsg.IPCallAddressController", "set account activity string from %s to null", (String) c.azQ().get(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, ""));
                    bg.aVF();
                    c.azQ().set(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, "");
                }
                h.INSTANCE.a(12061, 0, 0, 1, 0, 0, 0);
                e.this.ebh();
                Intent intent = new Intent();
                intent.setClass(e.this.yub, IPCallShareCouponUI.class);
                IPCallAddressUI iPCallAddressUI = e.this.yub;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(iPCallAddressUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                iPCallAddressUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(iPCallAddressUI, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25649);
            }
        });
        viewGroup.findViewById(R.id.bde).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.e.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(25650);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.setClass(e.this.yub, IPCallContactUI.class);
                IPCallAddressUI iPCallAddressUI = e.this.yub;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(iPCallAddressUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                iPCallAddressUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(iPCallAddressUI, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25650);
            }
        });
        viewGroup.findViewById(R.id.bqk).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.e.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(25651);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(e.this.yub, IPCallDialUI.class);
                intent.putExtra("IPCallTalkUI_dialScene", 1);
                e.this.yub.startActivityForResult(intent, 1001);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25651);
            }
        });
        eVar.ytY.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.e.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(25652);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (e.this.ytZ.Ox(i2)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(25652);
                    return;
                }
                if (adapterView instanceof ListView) {
                    k Pm = e.this.ytZ.Pm(i2 - ((ListView) adapterView).getHeaderViewsCount());
                    if (Pm == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(25652);
                        return;
                    }
                    com.tencent.mm.plugin.ipcall.model.h.c cVar = null;
                    if (Pm.field_addressId > 0) {
                        cVar = com.tencent.mm.plugin.ipcall.model.i.eay().GR(Pm.field_addressId);
                    }
                    Intent intent = new Intent(e.this.yub, IPCallUserProfileUI.class);
                    if (cVar != null) {
                        intent.putExtra("IPCallProfileUI_contactid", cVar.field_contactId);
                        intent.putExtra("IPCallProfileUI_systemUsername", cVar.field_systemAddressBookUsername);
                        intent.putExtra("IPCallProfileUI_wechatUsername", cVar.field_wechatUsername);
                    } else {
                        intent.putExtra("IPCallProfileUI_phonenumber", Pm.field_phonenumber);
                    }
                    intent.putExtra("IPCallProfileUI_isNeedShowRecord", true);
                    IPCallAddressUI iPCallAddressUI = e.this.yub;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallAddressUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    iPCallAddressUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallAddressUI, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(25652);
            }
        });
        eVar.ytY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.e.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(25653);
                h hVar = e.this.ytZ;
                if (hVar.yxa == null) {
                    hVar.yxa = m.ebb();
                }
                k Pm = e.this.ytZ.Pm(i2 - ((ListView) adapterView).getHeaderViewsCount());
                e eVar = e.this;
                int headerViewsCount = i2 - ((ListView) adapterView).getHeaderViewsCount();
                if (Pm != null) {
                    l lVar = new l(eVar.yub);
                    lVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.ipcall.ui.e.AnonymousClass8 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                            AppMethodBeat.i(25656);
                            mVar.add(R.string.tf);
                            AppMethodBeat.o(25656);
                        }
                    };
                    lVar.HLY = new o.g(Pm, headerViewsCount) {
                        /* class com.tencent.mm.plugin.ipcall.ui.e.AnonymousClass9 */
                        final /* synthetic */ k yuj;
                        final /* synthetic */ int yuk;

                        {
                            this.yuj = r2;
                            this.yuk = r3;
                        }

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            int delete;
                            int delete2;
                            AppMethodBeat.i(25657);
                            if (i2 == 0) {
                                e eVar = e.this;
                                k kVar = this.yuj;
                                int i3 = this.yuk;
                                if (kVar.field_addressId > 0) {
                                    com.tencent.mm.plugin.ipcall.model.h.l eaz = com.tencent.mm.plugin.ipcall.model.i.eaz();
                                    long j2 = kVar.field_addressId;
                                    if (j2 > 0 && (delete2 = eaz.db.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(j2)})) < 0) {
                                        Log.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", Integer.valueOf(delete2), Long.valueOf(j2));
                                    }
                                } else {
                                    com.tencent.mm.plugin.ipcall.model.h.l eaz2 = com.tencent.mm.plugin.ipcall.model.i.eaz();
                                    String str = kVar.field_phonenumber;
                                    if (!Util.isNullOrNil(str) && (delete = eaz2.db.delete("IPCallRecord", "phonenumber=?", new String[]{str})) < 0) {
                                        Log.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", Integer.valueOf(delete), str);
                                    }
                                }
                                h hVar = eVar.ytZ;
                                hVar.yxa.remove(i3);
                                hVar.notifyDataSetChanged();
                                if (eVar.ytZ.getCount() > 0) {
                                    eVar.yua.setVisibility(8);
                                    AppMethodBeat.o(25657);
                                    return;
                                }
                                eVar.yua.setVisibility(0);
                            }
                            AppMethodBeat.o(25657);
                        }
                    };
                    lVar.gXI();
                }
                AppMethodBeat.o(25653);
                return true;
            }
        });
        bg.aVF();
        if (((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            d.eah().qo(true);
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.FALSE);
        } else {
            d.eah().qo(false);
        }
        if (eVar.ytZ.getCount() > 0) {
            eVar.yua.setVisibility(8);
        } else {
            eVar.yua.setVisibility(0);
        }
        eVar.ebi();
        eVar.ebh();
        eVar.yuc = true;
        bg.azz().a(CdnLogic.kAppTypeFestivalImage, this);
        EventCenter.instance.addListener(this.yus);
        this.yuo = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
        h.INSTANCE.idkeyStat(257, 0, 1, true);
        AppMethodBeat.o(25672);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awg;
    }

    private void ebj() {
        AppMethodBeat.i(25673);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
        Log.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
        if (a2) {
            ThreadPool.post(this.yut, "IPCallAddressUI_LoadSystemAddressBook");
        }
        AppMethodBeat.o(25673);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25674);
        super.onDestroy();
        if (this.yun != null) {
            e eVar = this.yun;
            eVar.ytY.setOnItemClickListener(null);
            eVar.ytY.setOnItemLongClickListener(null);
            p.aYn().b(eVar.ytZ);
        }
        bg.azz().b(CdnLogic.kAppTypeFestivalImage, this);
        EventCenter.instance.removeListener(this.yus);
        AppMethodBeat.o(25674);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(25675);
        super.onResume();
        if (this.yun != null) {
            e eVar = this.yun;
            if (eVar.ytZ != null && !eVar.yuc) {
                eVar.ytZ.notifyDataSetChanged();
                if (eVar.ytZ.getCount() > 0) {
                    eVar.yua.setVisibility(8);
                } else {
                    eVar.yua.setVisibility(0);
                }
            }
            eVar.yuc = false;
        }
        supportInvalidateOptionsMenu();
        com.tencent.mm.plugin.ipcall.model.g.b.eaU().qy(true);
        if (!this.yur) {
            this.yur = true;
            ebj();
        }
        AppMethodBeat.o(25675);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(25676);
        if ((qVar instanceof g) && i2 == 0 && i3 == 0 && this.yun != null) {
            this.yun.ebi();
        }
        AppMethodBeat.o(25676);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(25677);
        Log.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(25677);
        return onCreateOptionsMenu;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(25678);
        if (this.yuo == 1) {
            b.jRt.o(new Intent(), this);
            AppMethodBeat.o(25678);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(25678);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(25679);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(25679);
            return;
        }
        Log.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] != 0 && this.yup) {
                    this.yup = false;
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25669);
                            dialogInterface.dismiss();
                            IPCallAddressUI iPCallAddressUI = IPCallAddressUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(iPCallAddressUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            iPCallAddressUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(iPCallAddressUI, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(25669);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25670);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(25670);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(25679);
    }
}
