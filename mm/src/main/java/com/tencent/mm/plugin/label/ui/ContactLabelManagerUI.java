package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.label.b.c;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI extends ContactLabelBaseUI implements View.OnCreateContextMenuListener, AdapterView.OnItemClickListener, i, o.g {
    private int apU;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(26206);
            int i2 = message.what;
            Log.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", Integer.valueOf(i2));
            switch (i2) {
                case 5001:
                    ContactLabelManagerUI.a(ContactLabelManagerUI.this);
                    AppMethodBeat.o(26206);
                    return;
                case 5002:
                    ContactLabelManagerUI.this.aCL(ContactLabelManagerUI.this.getString(R.string.a06));
                    AppMethodBeat.o(26206);
                    return;
                case 5003:
                    ContactLabelManagerUI.this.hideLoading();
                    break;
            }
            AppMethodBeat.o(26206);
        }
    };
    private ListView mListView;
    private int ppd = 0;
    private int ppe = 0;
    private com.tencent.mm.ui.widget.b.a pqr;
    private View rhx;
    private HashMap<Integer, Integer> yCA = new HashMap<>();
    private boolean yCB = true;
    private View.OnClickListener yCC = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass6 */

        public final void onClick(View view) {
            AppMethodBeat.i(26213);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ContactLabelManagerUI.b(ContactLabelManagerUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26213);
        }
    };
    private MStorage.IOnStorageChange yCD = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(26214);
            if (!Util.isNullOrNil(str)) {
                ContactLabelManagerUI.a(ContactLabelManagerUI.this);
            }
            AppMethodBeat.o(26214);
        }
    };
    private MStorageEx.IOnStorageChange yCE = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass8 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(26215);
            Log.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", Integer.valueOf(i2), obj);
            if (ContactLabelManagerUI.this.mHandler != null) {
                ContactLabelManagerUI.this.mHandler.removeMessages(5001);
                ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(5001, 400);
            }
            AppMethodBeat.o(26215);
        }
    };
    private b yCu = b.Normal;
    private View yCv;
    private View yCw;
    private boolean yCx = false;
    private a yCy;
    private ArrayList<au> yCz = new ArrayList<>();

    @Override // com.tencent.mm.plugin.label.ui.ContactLabelBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactLabelManagerUI() {
        AppMethodBeat.i(26228);
        AppMethodBeat.o(26228);
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI) {
        AppMethodBeat.i(26243);
        contactLabelManagerUI.qE(false);
        AppMethodBeat.o(26243);
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, String str) {
        AppMethodBeat.i(26245);
        contactLabelManagerUI.aCO(str);
        AppMethodBeat.o(26245);
    }

    public enum b {
        Normal,
        Empty;

        public static b valueOf(String str) {
            AppMethodBeat.i(26226);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(26226);
            return bVar;
        }

        static {
            AppMethodBeat.i(26227);
            AppMethodBeat.o(26227);
        }
    }

    @Override // com.tencent.mm.plugin.label.ui.ContactLabelBaseUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.y0;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(26229);
        this.yCx = getIntent().getBooleanExtra("select_label", false);
        this.apU = com.tencent.mm.cb.a.aG(getContext(), R.dimen.is);
        setMMTitle(getString(R.string.ebg));
        if (!this.yCx) {
            addTextOptionMenu(0, getString(R.string.ebp), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass9 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(26216);
                    ContactLabelManagerUI.b(ContactLabelManagerUI.this);
                    AppMethodBeat.o(26216);
                    return false;
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26217);
                ContactLabelManagerUI.this.finish();
                AppMethodBeat.o(26217);
                return false;
            }
        });
        this.yCy = new a();
        this.rhx = findViewById(R.id.e76);
        this.yCv = findViewById(R.id.e6z);
        this.yCw = findViewById(R.id.e77);
        this.yCw.setOnClickListener(this.yCC);
        this.mListView = (ListView) findViewById(R.id.e75);
        if (!this.yCx) {
            this.pqr = new com.tencent.mm.ui.widget.b.a(this);
            this.mListView.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass11 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(26218);
                    if (motionEvent.getAction() == 0) {
                        ContactLabelManagerUI.this.ppd = (int) motionEvent.getRawX();
                        ContactLabelManagerUI.this.ppe = (int) motionEvent.getRawY();
                    }
                    AppMethodBeat.o(26218);
                    return false;
                }
            });
            this.mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass12 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(26219);
                    ContactLabelManagerUI.this.pqr.a(view, i2, j2, ContactLabelManagerUI.this, ContactLabelManagerUI.this, ContactLabelManagerUI.this.ppd, ContactLabelManagerUI.this.ppe);
                    AppMethodBeat.o(26219);
                    return true;
                }
            });
        }
        this.mListView.setAdapter((ListAdapter) this.yCy);
        this.mListView.setOnItemClickListener(this);
        AppMethodBeat.o(26229);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26230);
        super.onCreate(bundle);
        initView();
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(26220);
                bg.azz().a(new c(), 0);
                AppMethodBeat.o(26220);
            }
        });
        e.ecf().add(this.yCD);
        h.INSTANCE.a(16097, 2, 0, 2);
        AppMethodBeat.o(26230);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(26231);
        bg.azz().a(636, this);
        bg.aVF();
        com.tencent.mm.model.c.aSN().add(this.yCE);
        qE(true);
        super.onResume();
        AppMethodBeat.o(26231);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(26232);
        bg.azz().b(636, this);
        bg.aVF();
        com.tencent.mm.model.c.aSN().remove(this.yCE);
        super.onPause();
        AppMethodBeat.o(26232);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26233);
        e.ecf().remove(this.yCD);
        super.onDestroy();
        AppMethodBeat.o(26233);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        au Pt;
        AppMethodBeat.i(26234);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        if (!(this.yCy == null || i2 < 0 || (Pt = this.yCy.Pt(i2)) == null)) {
            if (this.yCx) {
                Intent intent = new Intent();
                intent.putExtra("label_id", Pt.field_labelID);
                setResult(-1, intent);
                finish();
            } else {
                String sb = new StringBuilder().append(Pt.field_labelID).toString();
                String str = Pt.field_labelName;
                Intent intent2 = new Intent();
                intent2.putExtra("label_id", sb);
                intent2.putExtra("label_name", str);
                intent2.putExtra("label_source", "label_source_Address");
                intent2.setClass(this, ContactLabelEditUI.class);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (Util.isNullOrNil(sb)) {
                    if (this.yCz == null || this.yCz.isEmpty()) {
                        h.INSTANCE.a(11347, 1, 0);
                    } else {
                        h.INSTANCE.a(11347, 1, 1);
                    }
                }
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(26234);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        au Pt;
        AppMethodBeat.i(26235);
        int i2 = ((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position;
        if (!(this.yCy == null || i2 < 0 || (Pt = this.yCy.Pt(i2)) == null)) {
            contextMenu.setHeaderTitle(l.c(view.getContext(), Pt.field_labelName));
            contextMenu.add(0, 0, 0, getString(R.string.tf));
            contextMenu.add(0, 1, 1, getString(R.string.tt));
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AppMethodBeat.o(26235);
    }

    @Override // com.tencent.mm.ui.base.o.g
    public void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        AppMethodBeat.i(26236);
        int i3 = ((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (this.yCy != null && i3 >= 0) {
            final au Pt = this.yCy.Pt(i3);
            switch (i2) {
                case 0:
                    com.tencent.mm.ui.base.h.c(this, getString(R.string.ebi), "", getString(R.string.tf), getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(26207);
                            if (Pt != null) {
                                if (Pt.field_isTemporary) {
                                    ContactLabelManagerUI.a(ContactLabelManagerUI.this, new StringBuilder().append(Pt.field_labelID).toString());
                                } else {
                                    ContactLabelManagerUI.a(ContactLabelManagerUI.this, Pt);
                                }
                                h.INSTANCE.a(16097, 2, 2, 2);
                            }
                            AppMethodBeat.o(26207);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(26236);
                    return;
                case 1:
                    Intent intent = new Intent();
                    intent.setClass(this, ContactLabelEditUI.class);
                    intent.putExtra("label_id", new StringBuilder().append(Pt.field_labelID).toString());
                    intent.putExtra("label_name", Pt.field_labelName);
                    intent.putExtra("label_source", "label_source_Address");
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
            }
        }
        AppMethodBeat.o(26236);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(26237);
        Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        switch (qVar.getType()) {
            case 636:
                if (i2 == 0 && i3 == 0) {
                    aCO(((com.tencent.mm.plugin.label.b.b) qVar).yBU);
                    AppMethodBeat.o(26237);
                    return;
                }
                Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
                ecm();
                AppMethodBeat.o(26237);
                return;
            default:
                Log.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
                AppMethodBeat.o(26237);
                return;
        }
    }

    private synchronized void qE(final boolean z) {
        AppMethodBeat.i(26238);
        Log.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", String.valueOf(z));
        if (z && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(5002, 400);
        }
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(26210);
                ContactLabelManagerUI.this.yCz = e.ecf().gBV();
                if (ContactLabelManagerUI.this.yCz == null || ContactLabelManagerUI.this.yCz.size() <= 0) {
                    Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
                    if (ContactLabelManagerUI.this.yCB) {
                        h.INSTANCE.a(11346, 1, 0);
                        ContactLabelManagerUI.this.yCB = false;
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(26208);
                            ContactLabelManagerUI.a(ContactLabelManagerUI.this, b.Empty);
                            if (z && ContactLabelManagerUI.this.mHandler != null) {
                                ContactLabelManagerUI.this.mHandler.removeMessages(5002);
                                ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(5003, 0);
                            }
                            AppMethodBeat.o(26208);
                        }
                    });
                    AppMethodBeat.o(26210);
                    return;
                }
                Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
                if (ContactLabelManagerUI.this.yCB) {
                    h.INSTANCE.a(11346, 1, 1);
                    ContactLabelManagerUI.this.yCB = false;
                }
                if (ContactLabelManagerUI.this.yCz != null && ContactLabelManagerUI.this.yCz.size() > 0) {
                    int size = ContactLabelManagerUI.this.yCz.size();
                    e.ecf().aHn();
                    for (int i2 = 0; i2 < size; i2++) {
                        int i3 = ((au) ContactLabelManagerUI.this.yCz.get(i2)).field_labelID;
                        ArrayList<String> bjA = e.ecf().bjA(String.valueOf(i3));
                        if (bjA == null || bjA.size() <= 0) {
                            ContactLabelManagerUI.this.yCA.put(Integer.valueOf(i3), 0);
                        } else {
                            ContactLabelManagerUI.this.yCA.put(Integer.valueOf(i3), Integer.valueOf(bjA.size()));
                        }
                    }
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.AnonymousClass4.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(26209);
                        ContactLabelManagerUI.a(ContactLabelManagerUI.this, b.Normal);
                        a aVar = ContactLabelManagerUI.this.yCy;
                        aVar.mData = ContactLabelManagerUI.this.yCz;
                        aVar.notifyDataSetChanged();
                        ContactLabelManagerUI.this.yCy.notifyDataSetInvalidated();
                        if (z && ContactLabelManagerUI.this.mHandler != null) {
                            ContactLabelManagerUI.this.mHandler.removeMessages(5002);
                            ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(5003, 400);
                        }
                        AppMethodBeat.o(26209);
                    }
                });
                AppMethodBeat.o(26210);
            }

            public final String toString() {
                AppMethodBeat.i(26211);
                String str = super.toString() + "|updateData";
                AppMethodBeat.o(26211);
                return str;
            }
        });
        AppMethodBeat.o(26238);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(26239);
        Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            AppMethodBeat.o(26239);
            return;
        }
        switch (i2) {
            case TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL:
                String stringExtra = intent.getStringExtra("Select_Contact");
                Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", String.valueOf(stringExtra));
                if (!Util.isNullOrNil(stringExtra)) {
                    Intent intent2 = new Intent(intent);
                    intent2.putExtra("label_source", "label_source_Address");
                    intent2.setClass(this, ContactLabelEditUI.class);
                    intent2.putExtra("Select_Contact", stringExtra);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                }
                break;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(26239);
    }

    private void aCO(String str) {
        AppMethodBeat.i(26240);
        if (!e.ecf().gC(str)) {
            Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
            ecm();
            AppMethodBeat.o(26240);
            return;
        }
        ecn();
        AppMethodBeat.o(26240);
    }

    private void ecm() {
        AppMethodBeat.i(26241);
        hideLoading();
        amW(getString(R.string.bl5));
        AppMethodBeat.o(26241);
    }

    private void ecn() {
        AppMethodBeat.i(26242);
        hideLoading();
        qE(false);
        AppMethodBeat.o(26242);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        ArrayList<au> mData;

        a() {
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(26224);
            au Pt = Pt(i2);
            AppMethodBeat.o(26224);
            return Pt;
        }

        public final int getCount() {
            AppMethodBeat.i(26221);
            if (this.mData == null) {
                AppMethodBeat.o(26221);
                return 0;
            }
            int size = this.mData.size();
            AppMethodBeat.o(26221);
            return size;
        }

        public final au Pt(int i2) {
            AppMethodBeat.i(26222);
            if (this.mData == null || i2 > this.mData.size()) {
                AppMethodBeat.o(26222);
                return null;
            }
            au auVar = this.mData.get(i2);
            AppMethodBeat.o(26222);
            return auVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(26223);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(ContactLabelManagerUI.this).inflate(R.layout.xy, viewGroup, false);
                cVar = new c(view);
                ViewGroup.LayoutParams layoutParams = cVar.yDB.getLayoutParams();
                layoutParams.height = (int) (((float) com.tencent.mm.cb.a.aH(ContactLabelManagerUI.this, R.dimen.k4)) * com.tencent.mm.cb.a.jj(ContactLabelManagerUI.this));
                cVar.yDB.setLayoutParams(layoutParams);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            au Pt = Pt(i2);
            cVar.yDz.setText(l.e((Context) ContactLabelManagerUI.this.getContext(), (CharSequence) Pt.field_labelName, ContactLabelManagerUI.this.apU));
            if (ContactLabelManagerUI.this.yCA == null || !ContactLabelManagerUI.this.yCA.containsKey(Integer.valueOf(Pt.field_labelID))) {
                cVar.yDA.setVisibility(0);
                cVar.yDA.setText("(0)");
            } else {
                cVar.yDA.setVisibility(0);
                cVar.yDA.setText("(" + ContactLabelManagerUI.this.yCA.get(Integer.valueOf(Pt.field_labelID)) + ")");
            }
            AppMethodBeat.o(26223);
            return view;
        }
    }

    static /* synthetic */ void b(ContactLabelManagerUI contactLabelManagerUI) {
        AppMethodBeat.i(26244);
        if (contactLabelManagerUI.yCz == null || contactLabelManagerUI.yCz.isEmpty()) {
            h.INSTANCE.a(11347, 1, 0);
        } else {
            h.INSTANCE.a(11347, 1, 1);
        }
        Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[dealAddLabel]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", u.Q(u.PWS, 1024));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelManagerUI.getString(R.string.ebf));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 5);
        intent.putExtra("label_source", "label_source_Address");
        com.tencent.mm.br.c.c(contactLabelManagerUI, ".ui.contact.SelectContactUI", intent, (int) TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL);
        AppMethodBeat.o(26244);
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, au auVar) {
        AppMethodBeat.i(26246);
        if (auVar == null) {
            Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteScene] can not do scene. lable is null");
            AppMethodBeat.o(26246);
            return;
        }
        contactLabelManagerUI.aCL(contactLabelManagerUI.getString(R.string.ebj));
        bg.azz().a(new com.tencent.mm.plugin.label.b.b(new StringBuilder().append(auVar.field_labelID).toString()), 0);
        AppMethodBeat.o(26246);
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, b bVar) {
        AppMethodBeat.i(26247);
        contactLabelManagerUI.yCu = bVar;
        switch (contactLabelManagerUI.yCu) {
            case Normal:
                contactLabelManagerUI.rhx.setVisibility(0);
                contactLabelManagerUI.yCv.setVisibility(8);
                AppMethodBeat.o(26247);
                return;
            case Empty:
                contactLabelManagerUI.rhx.setVisibility(8);
                contactLabelManagerUI.yCv.setVisibility(0);
                AppMethodBeat.o(26247);
                return;
            default:
                Log.w("MicroMsg.Label.ContactLabelManagerUI", "unkonw mode:%s", new StringBuilder().append(contactLabelManagerUI.yCu).toString());
                AppMethodBeat.o(26247);
                return;
        }
    }
}
