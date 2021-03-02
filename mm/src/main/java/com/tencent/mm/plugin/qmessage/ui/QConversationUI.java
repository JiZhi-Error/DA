package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.e;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.plugin.qmessage.a.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import junit.framework.Assert;

@Deprecated
public class QConversationUI extends MMActivity implements i {
    private c BqA;
    private boolean BqB = false;
    private String BqC;
    private String BqD;
    private boolean BqE = false;
    private String BqF;
    private ListView Bqy;
    private c Bqz;
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private o.g plk = new o.g() {
        /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass5 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(27771);
            QConversationUI.a(QConversationUI.this, QConversationUI.this.BqF);
            AppMethodBeat.o(27771);
        }
    };
    private as rjX;
    private boolean yMq = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QConversationUI() {
        AppMethodBeat.i(27780);
        AppMethodBeat.o(27780);
    }

    static /* synthetic */ void e(QConversationUI qConversationUI) {
        AppMethodBeat.i(27796);
        qConversationUI.goBack();
        AppMethodBeat.o(27796);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27781);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(27781);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c3f;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27782);
        this.Bqz.ebf();
        if (this.BqA != null) {
            bg.azz().a(this.BqA);
            bg.azz().b(this.BqA.getType(), this);
            this.BqA = null;
        }
        super.onDestroy();
        AppMethodBeat.o(27782);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(27783);
        super.onResume();
        eGg();
        bg.aVF();
        com.tencent.mm.model.c.aST().add(this.Bqz);
        this.Bqz.onNotifyChange(null, null);
        AppMethodBeat.o(27783);
    }

    private static void eGg() {
        AppMethodBeat.i(27784);
        bg.aVF();
        ca Qo = com.tencent.mm.model.c.aSQ().Qo(2);
        if (Qo != null && Qo.field_msgId > 0) {
            Log.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + Qo.field_createTime);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(12295, Long.valueOf(Qo.field_createTime));
        }
        bg.aVF();
        az bjY = com.tencent.mm.model.c.aST().bjY("qmessage");
        if (bjY == null || Util.nullAsNil(bjY.field_username).length() <= 0) {
            Log.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
            AppMethodBeat.o(27784);
            return;
        }
        bjY.nt(0);
        bg.aVF();
        if (com.tencent.mm.model.c.aST().a(bjY, bjY.field_username) == -1) {
            Log.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
        }
        AppMethodBeat.o(27784);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(27785);
        Log.v("MicroMsg.QConversationUI", "on pause");
        bg.aVF();
        com.tencent.mm.model.c.aST().remove(this.Bqz);
        eGg();
        this.Bqz.onPause();
        super.onPause();
        AppMethodBeat.o(27785);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(27786);
        this.yMq = getIntent().getBooleanExtra("finish_direct", false);
        Log.d("MicroMsg.QConversationUI", "isFromSearch  " + this.yMq);
        bg.aVF();
        this.rjX = com.tencent.mm.model.c.aSN().Kn("qmessage");
        Assert.assertTrue("can not find qmessage", this.rjX != null && ((int) this.rjX.gMZ) > 0);
        this.Bqy = (ListView) findViewById(R.id.ir8);
        this.emptyTipTv = (TextView) findViewById(R.id.c30);
        this.emptyTipTv.setText(R.string.bwx);
        this.Bqz = new c(this, new s.a() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(27766);
                QConversationUI qConversationUI = QConversationUI.this;
                String arI = QConversationUI.this.rjX.arI();
                int JP = ac.JP(ab.iCI);
                if (JP <= 0) {
                    qConversationUI.setMMTitle(arI);
                } else {
                    qConversationUI.setMMTitle(arI + "(" + JP + ")");
                }
                QConversationUI.a(QConversationUI.this, QConversationUI.this.Bqz.getCount());
                AppMethodBeat.o(27766);
            }
        });
        this.Bqz.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(27772);
                int positionForView = QConversationUI.this.Bqy.getPositionForView(view);
                AppMethodBeat.o(27772);
                return positionForView;
            }
        });
        this.Bqz.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(27773);
                QConversationUI.this.Bqy.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(27773);
            }
        });
        this.Bqz.a(new MMSlideDelView.f() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.f
            public final void cZ(Object obj) {
                AppMethodBeat.i(27774);
                if (obj == null) {
                    Log.e("MicroMsg.QConversationUI", "onItemDel object null");
                    AppMethodBeat.o(27774);
                    return;
                }
                QConversationUI.a(QConversationUI.this, obj.toString());
                AppMethodBeat.o(27774);
            }
        });
        this.Bqy.setAdapter((ListAdapter) this.Bqz);
        this.Bqy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass9 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(27775);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", ((az) QConversationUI.this.Bqz.getItem(i2)).field_username);
                intent.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.qmessage.a.jRt.d(intent, QConversationUI.this.getContext());
                a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(27775);
            }
        });
        final com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(this);
        this.Bqy.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass10 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(27776);
                if (i2 < QConversationUI.this.Bqy.getHeaderViewsCount()) {
                    Log.w("MicroMsg.QConversationUI", "on header view long click, ignore");
                    AppMethodBeat.o(27776);
                    return true;
                }
                aVar.a(view, i2, j2, QConversationUI.this, QConversationUI.this.plk, 0, 0);
                AppMethodBeat.o(27776);
                return true;
            }
        });
        com.tencent.mm.plugin.qmessage.a.Bqd.iO(1010);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass11 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27777);
                QConversationUI.e(QConversationUI.this);
                AppMethodBeat.o(27777);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(27778);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(QConversationUI.this.Bqy);
                Object obj = new Object();
                a.a(obj, bl.axQ(), "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                a.a(obj, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                a.a(this, "com/tencent/mm/plugin/qmessage/ui/QConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27778);
            }
        });
        bg.aVF();
        this.BqC = (String) com.tencent.mm.model.c.azQ().get(77, "");
        bg.aVF();
        this.BqD = (String) com.tencent.mm.model.c.azQ().get(78, "");
        if (this.BqA == null) {
            this.BqA = new c();
            bg.azz().a(this.BqA.getType(), this);
        }
        bg.azz().a(this.BqA, 0);
        eGi();
        com.tencent.mm.plugin.qmessage.a.Bqd.iO(1010);
        AppMethodBeat.o(27786);
    }

    private static String bs(Context context, String str) {
        String str2;
        AppMethodBeat.i(27787);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo next = packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (next != null) {
                str2 = next.activityInfo.name;
                AppMethodBeat.o(27787);
                return str2;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.QConversationUI", e2, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.o(27787);
        return str2;
    }

    private void eGh() {
        AppMethodBeat.i(27788);
        if (Util.isNullOrNil(this.BqC)) {
            AppMethodBeat.o(27788);
            return;
        }
        this.BqB = true;
        addIconOptionMenu(0, R.string.cu, R.raw.qq, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass13 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27779);
                if (!Util.isNullOrNil(QConversationUI.this.BqC)) {
                    QConversationUI.a(QConversationUI.this, QConversationUI.this.BqC, QConversationUI.this.BqD);
                }
                AppMethodBeat.o(27779);
                return true;
            }
        });
        AppMethodBeat.o(27788);
    }

    private void eGi() {
        AppMethodBeat.i(27789);
        removeAllOptionMenu();
        eGh();
        addIconOptionMenu(2, R.string.cx, R.raw.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27767);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", QConversationUI.this.rjX.field_username);
                intent.putExtra("Chat_Readonly", true);
                com.tencent.mm.plugin.qmessage.a.jRt.c(intent, QConversationUI.this.getContext());
                AppMethodBeat.o(27767);
                return true;
            }
        });
        AppMethodBeat.o(27789);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(27790);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(27790);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(27790);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(27791);
        if (this.yMq) {
            finish();
            AppMethodBeat.o(27791);
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.qmessage.a.jRt.o(intent, this);
        overridePendingTransition(R.anim.s, R.anim.di);
        AppMethodBeat.o(27791);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(27792);
        az azVar = (az) this.Bqz.getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        bg.aVF();
        contextMenu.setHeaderTitle(com.tencent.mm.model.c.aSN().Kn(azVar.field_username).arJ());
        contextMenu.add(0, 0, 0, R.string.euz);
        this.BqF = azVar.field_username;
        AppMethodBeat.o(27792);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        String str3;
        bon bon;
        bon bon2;
        bon bon3;
        String str4 = null;
        AppMethodBeat.i(27793);
        Log.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        switch (qVar.getType()) {
            case 630:
                if (i2 == 0 && i3 == 0) {
                    c cVar = (c) qVar;
                    if (cVar.jof == null || (bon3 = (bon) cVar.jof.iLL.iLR) == null) {
                        str2 = null;
                    } else {
                        str2 = bon3.LWH;
                    }
                    if (cVar.jof == null || (bon2 = (bon) cVar.jof.iLL.iLR) == null) {
                        str3 = null;
                    } else {
                        str3 = bon2.xuc;
                    }
                    if (!(cVar.jof == null || (bon = (bon) cVar.jof.iLL.iLR) == null)) {
                        str4 = bon.LWI;
                    }
                    if (!Util.isNullOrNil(str4)) {
                        this.BqC = str4;
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(77, str4);
                    }
                    this.BqD = str3;
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(78, str3);
                    if (!this.BqB) {
                        eGi();
                    }
                    Log.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", str2, str3, str4);
                    break;
                }
                break;
        }
        AppMethodBeat.o(27793);
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, int i2) {
        AppMethodBeat.i(27794);
        if (i2 <= 0) {
            qConversationUI.emptyTipTv.setVisibility(0);
            qConversationUI.Bqy.setVisibility(8);
            AppMethodBeat.o(27794);
            return;
        }
        qConversationUI.emptyTipTv.setVisibility(8);
        qConversationUI.Bqy.setVisibility(0);
        AppMethodBeat.o(27794);
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, final String str) {
        AppMethodBeat.i(27795);
        bg.aVF();
        ca aEw = com.tencent.mm.model.c.aSQ().aEw(str);
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new e(str, aEw.field_msgSvrId));
        qConversationUI.isDeleteCancel = false;
        qConversationUI.getString(R.string.zb);
        final com.tencent.mm.ui.base.q a2 = h.a((Context) qConversationUI, qConversationUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(27768);
                QConversationUI.this.isDeleteCancel = true;
                AppMethodBeat.o(27768);
            }
        });
        bp.a(str, new bp.a() {
            /* class com.tencent.mm.plugin.qmessage.ui.QConversationUI.AnonymousClass4 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(27769);
                boolean z = QConversationUI.this.isDeleteCancel;
                AppMethodBeat.o(27769);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(27770);
                bg.aVF();
                com.tencent.mm.model.c.aST().bjW(str);
                if (a2 != null) {
                    a2.dismiss();
                }
                AppMethodBeat.o(27770);
            }
        });
        AppMethodBeat.o(27795);
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, String str, String str2) {
        int i2;
        AppMethodBeat.i(27797);
        if (str == null) {
            Log.d("MicroMsg.QConversationUI", "jacks open QQ appId == null");
            AppMethodBeat.o(27797);
            return;
        }
        g o = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
        if (o == null || !com.tencent.mm.pluginsdk.model.app.q.s(qConversationUI.getContext(), o.field_packageName)) {
            if (Util.isNullOrNil(str2)) {
                str2 = com.tencent.mm.pluginsdk.model.app.q.R(qConversationUI.getContext(), str, "message");
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.br.c.b(qConversationUI.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(27797);
        } else if (o.field_status == 3) {
            Log.e("MicroMsg.QConversationUI", "requestAppShow fail, app is in blacklist, packageName = " + o.field_packageName);
            AppMethodBeat.o(27797);
        } else if (!com.tencent.mm.pluginsdk.model.app.q.b(qConversationUI.getContext(), o)) {
            Log.e("MicroMsg.QConversationUI", "The app %s signature is incorrect.", o.field_appName);
            Toast.makeText(qConversationUI.getContext(), qConversationUI.getString(R.string.dpi, new Object[]{com.tencent.mm.pluginsdk.model.app.h.a(qConversationUI.getContext(), o, (String) null)}), 1).show();
            AppMethodBeat.o(27797);
        } else {
            Log.d("MicroMsg.QConversationUI", "jacks open QQ");
            Intent intent2 = new Intent("android.intent.action.MAIN", (Uri) null);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.addFlags(268435456);
            intent2.setClassName(o.field_packageName, bs(qConversationUI.getContext(), o.field_packageName));
            intent2.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "wechat");
            bg.aVF();
            Object obj = com.tencent.mm.model.c.azQ().get(9, (Object) null);
            if (obj == null || !(obj instanceof Integer)) {
                i2 = 0;
            } else {
                i2 = ((Integer) obj).intValue();
            }
            if (i2 != 0) {
                try {
                    byte[] bytes = String.valueOf(i2).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < length) {
                        byte b2 = bytes2[i3];
                        if (i4 >= bytes.length) {
                            break;
                        }
                        bytes[i4] = (byte) (b2 ^ bytes[i4]);
                        i3++;
                        i4++;
                    }
                    intent2.putExtra("tencent_gif", bytes);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.QConversationUI", e2, "", new Object[0]);
                }
            }
            try {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                a.a(qConversationUI, bl.axQ(), "com/tencent/mm/plugin/qmessage/ui/QConversationUI", "dealClickOpenQQ", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                qConversationUI.startActivity((Intent) bl.pG(0));
                a.a(qConversationUI, "com/tencent/mm/plugin/qmessage/ui/QConversationUI", "dealClickOpenQQ", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(27797);
            } catch (Exception e3) {
                AppMethodBeat.o(27797);
            }
        }
    }
}
