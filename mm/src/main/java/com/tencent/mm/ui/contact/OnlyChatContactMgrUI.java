package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.g.b.a.u;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class OnlyChatContactMgrUI extends MMActivity implements i, MStorageEx.IOnStorageChange, n {
    private EditText FNd;
    private ContactCountView PTa;
    private final String PXH = "intent_status_mgr";
    private a PXI;
    private SelectMemberScrollBar PXJ;
    private Button PXK;
    private final int PXL = h.aqJ().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    private final int PXM = h.aqJ().getInt("MMBatchModContactTypeMaxNumForClient", 30);
    private u PXN;
    private final int PXO = 0;
    private final int PXP = 1;
    private final int PXQ = 2;
    private final int PXR = 3;
    private TextView hSx;
    private Button kid;
    private Button kjo;
    private ListView krb;
    private int ppd;
    private int ppe;
    private q tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public OnlyChatContactMgrUI() {
        AppMethodBeat.i(234013);
        AppMethodBeat.o(234013);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bgx;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        int i2;
        int i3 = 8;
        boolean z = false;
        AppMethodBeat.i(180069);
        super.onCreate(bundle);
        setMMTitle(R.string.ea);
        this.krb = (ListView) findViewById(R.id.fcl);
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(180044);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(OnlyChatContactMgrUI.this.krb);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(180044);
            }
        });
        this.hSx = (TextView) findViewById(R.id.c39);
        this.PXI = new a(this);
        boolean booleanExtra = getIntent().getBooleanExtra("intent_status_mgr", false);
        if (booleanExtra) {
            this.PXI.PWh = true;
        }
        this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass8 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(180048);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                com.tencent.mm.ui.contact.a.a anH = OnlyChatContactMgrUI.this.PXI.getItem(i2);
                if (anH == null || !(anH instanceof e)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(180048);
                    return;
                }
                String str = ((e) anH).username;
                if (OnlyChatContactMgrUI.this.PXI.eWh()) {
                    a aVar = OnlyChatContactMgrUI.this.PXI;
                    if (aVar.PXY.contains(str)) {
                        aVar.PXY.remove(str);
                    } else {
                        aVar.PXY.add(str);
                    }
                    aVar.notifyDataSetChanged();
                    if (OnlyChatContactMgrUI.this.PXI.PXY.size() > 0) {
                        OnlyChatContactMgrUI.this.kjo.setText(OnlyChatContactMgrUI.this.getString(R.string.ei) + "(" + OnlyChatContactMgrUI.this.PXI.PXY.size() + ")");
                        OnlyChatContactMgrUI.this.kjo.setEnabled(true);
                    } else {
                        OnlyChatContactMgrUI.this.kjo.setText(OnlyChatContactMgrUI.this.getString(R.string.ei));
                        OnlyChatContactMgrUI.this.kjo.setEnabled(false);
                    }
                } else if (ab.Js(str)) {
                    Intent intent = new Intent(OnlyChatContactMgrUI.this.getContext(), AddressUI.class);
                    intent.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                    OnlyChatContactMgrUI onlyChatContactMgrUI = OnlyChatContactMgrUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(onlyChatContactMgrUI, bl.axQ(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    onlyChatContactMgrUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(onlyChatContactMgrUI, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(180048);
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Contact_Scene", 3);
                    intent2.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                    if (str != null && str.length() > 0) {
                        c.b(OnlyChatContactMgrUI.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(180048);
            }
        });
        this.krb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass9 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i2, long j2) {
                AppMethodBeat.i(180051);
                com.tencent.mm.ui.contact.a.a anH = OnlyChatContactMgrUI.this.PXI.getItem(i2);
                if (anH == null || !(anH instanceof e)) {
                    AppMethodBeat.o(180051);
                    return true;
                }
                final String str = ((e) anH).username;
                if (!OnlyChatContactMgrUI.this.PXI.eWh()) {
                    new com.tencent.mm.ui.widget.b.a(OnlyChatContactMgrUI.this.getContext()).a(view, i2, j2, new View.OnCreateContextMenuListener() {
                        /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass9.AnonymousClass1 */

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(180049);
                            contextMenu.add(i2, 0, 0, R.string.bd1);
                            AppMethodBeat.o(180049);
                        }
                    }, new o.g() {
                        /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass9.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(180050);
                            Intent intent = new Intent();
                            intent.setClass(OnlyChatContactMgrUI.this.getContext(), ContactRemarkInfoModUI.class);
                            intent.putExtra("Contact_User", str);
                            intent.putExtra("view_mode", true);
                            AppCompatActivity context = OnlyChatContactMgrUI.this.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(180050);
                        }
                    }, OnlyChatContactMgrUI.this.ppd, OnlyChatContactMgrUI.this.ppe);
                }
                AppMethodBeat.o(180051);
                return true;
            }
        });
        this.krb.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass10 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(180052);
                switch (motionEvent.getAction()) {
                    case 0:
                        OnlyChatContactMgrUI.this.hideVKB();
                        OnlyChatContactMgrUI.this.ppd = (int) motionEvent.getRawX();
                        OnlyChatContactMgrUI.this.ppe = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(180052);
                return false;
            }
        });
        this.krb.setAdapter((ListAdapter) this.PXI);
        ListView listView = this.krb;
        ContactCountView contactCountView = new ContactCountView(this);
        this.PTa = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        this.PTa.setFixedContactCount(this.PXI.getContactCount());
        this.hSx.setVisibility(this.PXI.getContactCount() == 0 ? 0 : 8);
        this.PXJ = (SelectMemberScrollBar) findViewById(R.id.fco);
        this.PXJ.setOnScrollBarTouchListener(new VerticalScrollBar.a() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.VerticalScrollBar.a
            public final void DP(String str) {
                int intValue;
                AppMethodBeat.i(180053);
                if ("↑".equals(str)) {
                    OnlyChatContactMgrUI.this.krb.setSelection(0);
                    AppMethodBeat.o(180053);
                    return;
                }
                a aVar = OnlyChatContactMgrUI.this.PXI;
                if (aVar.PTD.get(str) == null) {
                    intValue = -1;
                } else {
                    intValue = aVar.PTD.get(str).intValue();
                }
                if (intValue != -1) {
                    OnlyChatContactMgrUI.this.krb.setSelection(intValue);
                }
                AppMethodBeat.o(180053);
            }
        });
        this.FNd = (MMEditText) findViewById(R.id.hi6);
        this.FNd.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass12 */
            private MTimerHandler gAF = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass12.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    boolean z;
                    AppMethodBeat.i(180054);
                    Log.d("MicroMsg.OnlyChatContactMgrUI", "searchEvent onTimerExpired");
                    String obj = OnlyChatContactMgrUI.this.FNd.getText().toString();
                    if (!Util.isNullOrNil(obj)) {
                        ContactCountView contactCountView = OnlyChatContactMgrUI.this.PTa;
                        if (Util.isNullOrNil(obj)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        contactCountView.setVisible(z);
                    }
                    a aVar = OnlyChatContactMgrUI.this.PXI;
                    if (!aVar.query.equalsIgnoreCase(obj)) {
                        aVar.query = obj;
                    }
                    aVar.and();
                    AppMethodBeat.o(180054);
                    return false;
                }
            }, false);

            {
                AppMethodBeat.i(180055);
                AppMethodBeat.o(180055);
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(180056);
                this.gAF.stopTimer();
                this.gAF.startTimer(500);
                AppMethodBeat.o(180056);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.kid = (Button) findViewById(R.id.gn);
        this.PXK = (Button) findViewById(R.id.e5s);
        this.kjo = (Button) findViewById(R.id.blh);
        this.kjo.setEnabled(false);
        this.kid.setVisibility(booleanExtra ? 8 : 0);
        Button button = this.PXK;
        if (booleanExtra) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        button.setVisibility(i2);
        Button button2 = this.kjo;
        if (booleanExtra) {
            i3 = 0;
        }
        button2.setVisibility(i3);
        Button button3 = this.PXK;
        if (this.PXI.getContactCount() > 0) {
            z = true;
        }
        button3.setEnabled(z);
        this.kid.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(180057);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                OnlyChatContactMgrUI.h(OnlyChatContactMgrUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(180057);
            }
        });
        this.PXK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(180058);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                OnlyChatContactMgrUI.this.PXN = new u();
                Intent intent = new Intent(OnlyChatContactMgrUI.this, SelectContactsFromRangeUI.class);
                intent.putExtra("intent_status_mgr", true);
                intent.putExtra("list_type", 16);
                intent.putExtra("filter_type", "@social.black.android");
                OnlyChatContactMgrUI.this.startActivityForResult(intent, 2);
                OnlyChatContactMgrUI.this.PXN.eli = 5;
                OnlyChatContactMgrUI.this.PXN.elr = System.currentTimeMillis();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(180058);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass15 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(234012);
                OnlyChatContactMgrUI.this.hideVKB();
                OnlyChatContactMgrUI.this.finish();
                AppMethodBeat.o(234012);
                return false;
            }
        });
        g.aAi();
        ((l) g.af(l.class)).aSN().add(this);
        g.aAi();
        g.aAg().hqi.a(3990, this);
        AppMethodBeat.o(180069);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(180070);
        g.aAi();
        ((l) g.af(l.class)).aSN().remove(this);
        g.aAi();
        g.aAg().hqi.b(3990, this);
        this.PXI.finish();
        super.onDestroy();
        AppMethodBeat.o(180070);
    }

    @Override // com.tencent.mm.ui.contact.n
    public Activity getActivity() {
        return this;
    }

    @Override // com.tencent.mm.ui.contact.n
    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(180071);
        if (aVar instanceof e) {
            boolean contains = this.PXI.PXY.contains(((e) aVar).username);
            AppMethodBeat.o(180071);
            return contains;
        }
        AppMethodBeat.o(180071);
        return false;
    }

    @Override // com.tencent.mm.ui.contact.n
    public ListView getContentLV() {
        return this.krb;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        boolean z = false;
        AppMethodBeat.i(180072);
        this.PXI.and();
        int contactCount = this.PXI.getContactCount();
        this.PTa.setFixedContactCount(contactCount);
        this.hSx.setVisibility(contactCount == 0 ? 0 : 8);
        Button button = this.PXK;
        if (contactCount > 0) {
            z = true;
        }
        button.setEnabled(z);
        AppMethodBeat.o(180072);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String[] strArr;
        AppMethodBeat.i(180073);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || intent == null) {
            AppMethodBeat.o(180073);
        } else if (i2 == 3) {
            int intExtra = intent.getIntExtra("label_id", 0);
            ArrayList<String> bjA = com.tencent.mm.plugin.label.e.ecf().bjA(String.valueOf(intExtra));
            Intent intent2 = new Intent(this, SelectContactsFromRangeUI.class);
            intent2.putExtra("list_type", 1);
            intent2.putExtra("filter_type", "@all.contact.android");
            if (bjA == null) {
                strArr = new String[0];
            } else {
                strArr = (String[]) bjA.toArray(new String[0]);
            }
            intent2.putExtra("already_select_contact", strArr);
            intent2.putExtra("max_limit_num", this.PXM);
            startActivityForResult(intent2, 1);
            u uVar = this.PXN;
            uVar.elq = uVar.x("selecttagid", String.valueOf(intExtra), true);
            u uVar2 = this.PXN;
            uVar2.elp = uVar2.x("selecttagname", com.tencent.mm.plugin.label.e.ecf().aCG(String.valueOf(intExtra)), true);
            AppMethodBeat.o(180073);
        } else if (i2 == 2) {
            final ArrayList<String> stringsToList = Util.stringsToList(intent.getStringExtra("Select_Contact").split(","));
            if (stringsToList == null || stringsToList.isEmpty()) {
                AppMethodBeat.o(180073);
                return;
            }
            com.tencent.mm.ui.base.h.a(this, getString(R.string.eh), "", getString(R.string.ei), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(234009);
                    final com.tencent.mm.modelmulti.c cVar = new com.tencent.mm.modelmulti.c(stringsToList, TPMediaCodecProfileLevel.HEVCHighTierLevel61, 2, OnlyChatContactMgrUI.this.PXL);
                    g.aAg().hqi.a(cVar, 0);
                    OnlyChatContactMgrUI.this.PXN.elj = (long) stringsToList.size();
                    OnlyChatContactMgrUI.this.PXN.elm = (long) OnlyChatContactMgrUI.this.PXI.getContactCount();
                    OnlyChatContactMgrUI.this.PXN.elr = System.currentTimeMillis() - OnlyChatContactMgrUI.this.PXN.elr;
                    OnlyChatContactMgrUI onlyChatContactMgrUI = OnlyChatContactMgrUI.this;
                    AppCompatActivity context = OnlyChatContactMgrUI.this.getContext();
                    OnlyChatContactMgrUI.this.getString(R.string.zb);
                    onlyChatContactMgrUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) context, OnlyChatContactMgrUI.this.getString(R.string.ej), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass4.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(234008);
                            g.aAg().hqi.a(cVar);
                            AppMethodBeat.o(234008);
                        }
                    });
                    AppMethodBeat.o(234009);
                }
            }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
            AppMethodBeat.o(180073);
        } else {
            if (i2 == 1) {
                ArrayList<String> stringsToList2 = Util.stringsToList(intent.getStringExtra("Select_Contact").split(","));
                if (stringsToList2 == null || stringsToList2.isEmpty()) {
                    AppMethodBeat.o(180073);
                    return;
                }
                final com.tencent.mm.modelmulti.c cVar = new com.tencent.mm.modelmulti.c(stringsToList2, TPMediaCodecProfileLevel.HEVCHighTierLevel61, 1, this.PXL);
                g.aAg().hqi.a(cVar, 0);
                this.PXN.elj = (long) stringsToList2.size();
                this.PXN.elm = (long) this.PXI.getContactCount();
                this.PXN.elr = System.currentTimeMillis() - this.PXN.elr;
                AppCompatActivity context = getContext();
                getString(R.string.zb);
                this.tipDialog = com.tencent.mm.ui.base.h.a((Context) context, getString(R.string.ef), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass5 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(234010);
                        g.aAg().hqi.a(cVar);
                        AppMethodBeat.o(234010);
                    }
                });
            }
            AppMethodBeat.o(180073);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2;
        int i4;
        AppMethodBeat.i(180074);
        Log.i("MicroMsg.OnlyChatContactMgrUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " " + qVar.getType());
        if (!(qVar instanceof com.tencent.mm.modelmulti.c)) {
            AppMethodBeat.o(180074);
            return;
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        com.tencent.mm.modelmulti.c cVar = (com.tencent.mm.modelmulti.c) qVar;
        if (i2 == 0 && i3 == 0) {
            Toast.makeText(this, getString(cVar.op == 1 ? R.string.ep : R.string.es), 0).show();
            this.PXN.elk = this.PXN.elj;
            u uVar = this.PXN;
            uVar.ell = uVar.x("modifiedsucfriendlist", Util.listToString(cVar.jcs, "#"), true);
            if (cVar.op == 1) {
                this.PXN.eln = this.PXN.elm + ((long) cVar.jcs.size());
            } else {
                this.PXN.eln = this.PXN.elm - ((long) cVar.jcs.size());
            }
            this.PXN.elo = 1;
            u uVar2 = this.PXN;
            uVar2.els = uVar2.x("sessionid", new StringBuilder().append(hashCode()).toString(), true);
            this.PXN.bfK();
            AppMethodBeat.o(180074);
        } else if (i3 == -3503) {
            f.a aVar = new f.a(this);
            aVar.bow(Util.nullAs(qVar.getReqResp().getRespObj().getErrMsg(), getString(R.string.en))).Dq(true).boB(getString(R.string.fpo)).apa(R.string.fpp);
            aVar.c(new f.c() {
                /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass6 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(234011);
                    OnlyChatContactMgrUI.this.hideVKB();
                    if (!z) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(OnlyChatContactMgrUI.this.getContext()));
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        c.b(OnlyChatContactMgrUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    AppMethodBeat.o(234011);
                }
            }).show();
            AppMethodBeat.o(180074);
        } else {
            f.a aVar2 = new f.a(this);
            if (i3 == -3500) {
                if (cVar.op == 1) {
                    i4 = R.string.eo;
                } else {
                    i4 = R.string.er;
                }
                str2 = getString(i4, new Object[]{Integer.valueOf(cVar.jcu - cVar.jcs.size())});
            } else {
                String errMsg = qVar.getReqResp().getRespObj().getErrMsg();
                if (Util.isNullOrNil(errMsg)) {
                    str2 = getString(cVar.op == 1 ? R.string.en : R.string.eq);
                } else {
                    str2 = errMsg;
                }
            }
            f.a bow = aVar2.bow(str2);
            bow.JnN = true;
            bow.apa(R.string.x_);
            aVar2.b(new f.c() {
                /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass7 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                }
            }).show();
            AppMethodBeat.o(180074);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends q {
        HashMap<String, Integer> PTD = new HashMap<>();
        private SparseArray<String> PTE = new SparseArray<>();
        List<String> PXY = new LinkedList();
        private Cursor jWh;
        String query = "";

        public a(n nVar) {
            super(nVar, null, true, false);
            AppMethodBeat.i(180061);
            and();
            AppMethodBeat.o(180061);
        }

        @Override // com.tencent.mm.ui.contact.q
        public final void and() {
            AppMethodBeat.i(180062);
            super.and();
            if (this.jWh != null) {
                this.jWh.close();
                this.jWh = null;
            }
            this.PTD.clear();
            this.PTE.clear();
            g.aAi();
            this.jWh = ((l) g.af(l.class)).aSN().d(null, this.query, "@social.black.android", "", this.gzY);
            String[] a2 = ab.a((String[]) null, "@social.black.android", "", this.query, this.gzY);
            int[] a3 = ab.a((String[]) null, "@social.black.android", "", this.gzY, this.query);
            if (!(a2 == null || a3 == null)) {
                int i2 = 1;
                for (int i3 = 0; i3 < a2.length; i3++) {
                    if (i3 < a3.length) {
                        this.PTD.put(a2[i3], Integer.valueOf(a3[i3] + i2));
                        this.PTE.put(a3[i3] + i2, a2[i3]);
                        i2++;
                    }
                }
            }
            Log.i("MicroMsg.OnlyChatContactMgrUI", "datacount:%d headerPosMap=%s", Integer.valueOf(this.jWh.getCount()), this.PTD.toString());
            clearCache();
            notifyDataSetChanged();
            AppMethodBeat.o(180062);
        }

        @Override // com.tencent.mm.ui.contact.q
        public final int bnr(String str) {
            AppMethodBeat.i(180063);
            if (this.PTD == null) {
                AppMethodBeat.o(180063);
                return -1;
            } else if (this.PTD.containsKey(str)) {
                int intValue = this.PTD.get(str).intValue() + this.PWg.getContentLV().getHeaderViewsCount();
                AppMethodBeat.o(180063);
                return intValue;
            } else {
                AppMethodBeat.o(180063);
                return -1;
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.contact.p
        public final com.tencent.mm.ui.contact.a.a va(int i2) {
            AppMethodBeat.i(180064);
            if (i2 == 0) {
                com.tencent.mm.ui.contact.a.a dn = dn(i2, OnlyChatContactMgrUI.this.getString(R.string.ek));
                AppMethodBeat.o(180064);
                return dn;
            } else if (this.PTE.indexOfKey(i2) >= 0) {
                com.tencent.mm.ui.contact.a.a dn2 = dn(i2, this.PTE.get(i2));
                AppMethodBeat.o(180064);
                return dn2;
            } else {
                int i3 = i2;
                int i4 = 1;
                while (i4 <= this.PTE.size()) {
                    if (this.PTE.indexOfKey(i3) >= 0) {
                        i4++;
                    }
                    i3--;
                    if (i3 < 0) {
                        break;
                    }
                }
                int i5 = i2 - i4;
                if (this.jWh.moveToPosition(i5)) {
                    Log.d("MicroMsg.OnlyChatContactMgrUI", "create contact item position=%d | index=%d", Integer.valueOf(i2), Integer.valueOf(i5));
                    as asVar = new as();
                    asVar.convertFrom(this.jWh);
                    e eVar = new e(i2);
                    eVar.contact = asVar;
                    if (ab.Eq(asVar.field_username)) {
                        eVar.PWh = false;
                        eVar.PWi = false;
                        eVar.Qaa = false;
                        eVar.Qap = true;
                    } else {
                        eVar.PWh = eWh();
                        eVar.PWi = this.PWi;
                        eVar.Qap = false;
                    }
                    AppMethodBeat.o(180064);
                    return eVar;
                }
                Log.i("MicroMsg.OnlyChatContactMgrUI", "create contact item error: position=%d | index=%d", Integer.valueOf(i2), Integer.valueOf(i5));
                AppMethodBeat.o(180064);
                return null;
            }
        }

        private static com.tencent.mm.ui.contact.a.a dn(int i2, String str) {
            AppMethodBeat.i(180065);
            com.tencent.mm.ui.contact.a.h hVar = new com.tencent.mm.ui.contact.a.h(i2);
            hVar.header = str;
            AppMethodBeat.o(180065);
            return hVar;
        }

        public final int getCount() {
            AppMethodBeat.i(180066);
            int size = (this.PTE == null ? 0 : this.PTE.size()) + this.jWh.getCount() + 1;
            AppMethodBeat.o(180066);
            return size;
        }

        @Override // com.tencent.mm.ui.contact.p
        public final void finish() {
            AppMethodBeat.i(180067);
            super.finish();
            Log.i("MicroMsg.OnlyChatContactMgrUI", "finish!");
            if (this.jWh != null) {
                this.jWh.close();
                this.jWh = null;
            }
            AppMethodBeat.o(180067);
        }

        public final int getContactCount() {
            AppMethodBeat.i(180068);
            if (this.jWh != null) {
                int count = this.jWh.getCount();
                AppMethodBeat.o(180068);
                return count;
            }
            AppMethodBeat.o(180068);
            return 0;
        }
    }

    static /* synthetic */ void h(OnlyChatContactMgrUI onlyChatContactMgrUI) {
        AppMethodBeat.i(180075);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) onlyChatContactMgrUI, 1, true);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(234006);
                mVar.b(0, OnlyChatContactMgrUI.this.getString(R.string.ee), R.drawable.c5a);
                mVar.b(1, OnlyChatContactMgrUI.this.getString(R.string.ed), R.drawable.c5a);
                mVar.b(2, OnlyChatContactMgrUI.this.getString(R.string.ec), R.drawable.c5a);
                mVar.b(3, OnlyChatContactMgrUI.this.getString(R.string.eb), R.drawable.c5a);
                AppMethodBeat.o(234006);
            }
        };
        eVar.j(onlyChatContactMgrUI.getString(R.string.em), 17, com.tencent.mm.cb.a.fromDPToPix((Context) onlyChatContactMgrUI, 14));
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.ui.contact.OnlyChatContactMgrUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(234007);
                OnlyChatContactMgrUI.this.PXN = new u();
                switch (i2) {
                    case 0:
                        List<String> IZ = com.tencent.mm.plugin.sns.b.o.DCP.IZ(5);
                        Intent intent = new Intent(OnlyChatContactMgrUI.this, SelectContactsFromRangeUI.class);
                        intent.putExtra("list_type", 1);
                        intent.putExtra("filter_type", "@all.contact.without.chatroom.without.openim");
                        intent.putExtra("already_select_contact", (String[]) IZ.toArray(new String[0]));
                        intent.putExtra("max_limit_num", OnlyChatContactMgrUI.this.PXM);
                        OnlyChatContactMgrUI.this.startActivityForResult(intent, 1);
                        OnlyChatContactMgrUI.this.PXN.eli = 1;
                        OnlyChatContactMgrUI.this.PXN.elr = System.currentTimeMillis();
                        AppMethodBeat.o(234007);
                        return;
                    case 1:
                        Intent intent2 = new Intent(OnlyChatContactMgrUI.this, SelectContactsFromRangeUI.class);
                        intent2.putExtra("list_type", 1);
                        intent2.putExtra("filter_type", "@all.contact.android");
                        intent2.putExtra("already_select_contact", (String[]) com.tencent.mm.pluginsdk.i.a.gnq().toArray(new String[0]));
                        intent2.putExtra("max_limit_num", OnlyChatContactMgrUI.this.PXM);
                        OnlyChatContactMgrUI.this.startActivityForResult(intent2, 1);
                        OnlyChatContactMgrUI.this.PXN.eli = 2;
                        OnlyChatContactMgrUI.this.PXN.elr = System.currentTimeMillis();
                        AppMethodBeat.o(234007);
                        return;
                    case 2:
                        Intent intent3 = new Intent(OnlyChatContactMgrUI.this, ContactLabelManagerUI.class);
                        intent3.putExtra("select_label", true);
                        OnlyChatContactMgrUI.this.startActivityForResult(intent3, 3);
                        OnlyChatContactMgrUI.this.PXN.eli = 3;
                        OnlyChatContactMgrUI.this.PXN.elr = System.currentTimeMillis();
                        AppMethodBeat.o(234007);
                        return;
                    default:
                        Intent intent4 = new Intent();
                        intent4.putExtra("titile", OnlyChatContactMgrUI.this.getString(R.string.g4));
                        intent4.putExtra("list_type", 1);
                        intent4.putExtra("KBlockOpenImFav", true);
                        intent4.putExtra("without_openim", true);
                        intent4.putExtra("show_too_many_member", false);
                        int Q = u.Q(u.Q(u.PWS, 536870912), 131072);
                        intent4.putExtra("max_limit_num", OnlyChatContactMgrUI.this.PXM);
                        intent4.putExtra("list_attr", Q);
                        intent4.putExtra("always_select_contact", "");
                        c.c(OnlyChatContactMgrUI.this, ".ui.contact.SelectContactUI", intent4, 1);
                        OnlyChatContactMgrUI.this.PXN.eli = 4;
                        OnlyChatContactMgrUI.this.PXN.elr = System.currentTimeMillis();
                        AppMethodBeat.o(234007);
                        return;
                }
            }
        };
        eVar.dGm();
        AppMethodBeat.o(180075);
    }
}
