package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.plugin.ipcall.model.f.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.ewj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI extends MMActivity implements i {
    private String mDesc = null;
    private String mTitle = null;
    private String mWording = null;
    private ProgressDialog yuB;
    private IListener yus = new IListener<kw>() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161390);
            this.__eventId = kw.class.getName().hashCode();
            AppMethodBeat.o(161390);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kw kwVar) {
            AppMethodBeat.i(25936);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(25935);
                    bg.aVF();
                    if (((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                        IPCallShareCouponUI.this.yyl.setVisibility(0);
                    } else {
                        IPCallShareCouponUI.this.yyl.setVisibility(8);
                    }
                    bg.aVF();
                    IPCallShareCouponUI.this.yyk.setText((String) c.azQ().get(ar.a.USERFINO_IPCALL_RECHARGE_STRING, ""));
                    bg.aVF();
                    IPCallShareCouponUI.this.yyn.setText((String) c.azQ().get(ar.a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, ""));
                    AppMethodBeat.o(25935);
                }
            });
            AppMethodBeat.o(25936);
            return true;
        }
    };
    private String yxP = null;
    private String yxQ = null;
    private String yxR = null;
    private String yxS = null;
    private String yxT = null;
    private String yxU = null;
    private String yxV = null;
    private TextView yyA;
    private TextView yyB;
    private View yyC;
    private IPCallDynamicTextView yyD;
    private b yyE = new b();
    private LinkedList<ewj> yyF = null;
    private boolean yyG = false;
    private RelativeLayout yyj;
    private TextView yyk;
    private ImageView yyl;
    private RelativeLayout yym;
    private TextView yyn;
    private ImageView yyo;
    private LinearLayout yyp;
    private LinearLayout yyq;
    private LinearLayout yyr;
    private LinearLayout yys;
    private ImageView yyt;
    private LinearLayout yyu;
    private ImageView yyv;
    private TextView yyw;
    private TextView yyx;
    private TextView yyy;
    private ImageView yyz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallShareCouponUI() {
        AppMethodBeat.i(25953);
        AppMethodBeat.o(25953);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        AppMethodBeat.i(25954);
        super.onCreate(bundle);
        bg.azz().a(CdnLogic.kAppTypeFestivalImage, this);
        EventCenter.instance.addListener(this.yus);
        setMMTitle(R.string.e85);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25945);
                IPCallShareCouponUI.this.finish();
                AppMethodBeat.o(25945);
                return true;
            }
        });
        removeAllOptionMenu();
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass6 */

            /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x006a  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onMenuItemClick(android.view.MenuItem r9) {
                /*
                // Method dump skipped, instructions count: 133
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass6.onMenuItemClick(android.view.MenuItem):boolean");
            }
        });
        this.yyD = (IPCallDynamicTextView) findViewById(R.id.zm);
        this.yyj = (RelativeLayout) findViewById(R.id.guc);
        this.yyk = (TextView) findViewById(R.id.guz);
        this.yyl = (ImageView) findViewById(R.id.gum);
        bg.aVF();
        if (((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            this.yyl.setVisibility(0);
        }
        bg.aVF();
        this.yyk.setText((String) c.azQ().get(ar.a.USERFINO_IPCALL_RECHARGE_STRING, ""));
        this.yym = (RelativeLayout) findViewById(R.id.gm_);
        this.yyn = (TextView) findViewById(R.id.g84);
        this.yyo = (ImageView) findViewById(R.id.g81);
        bg.aVF();
        this.yyn.setText((String) c.azQ().get(ar.a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, ""));
        this.yyA = (TextView) findViewById(R.id.bgu);
        this.yyB = (TextView) findViewById(R.id.g7z);
        this.yyC = findViewById(R.id.hsv);
        this.yyp = (LinearLayout) findViewById(R.id.c5i);
        this.yyz = (ImageView) findViewById(R.id.fvx);
        bg.aVF();
        if (((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_EXCHANGE_RECORD_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            this.yyz.setVisibility(0);
        }
        this.yyw = (TextView) findViewById(R.id.g0k);
        this.yyx = (TextView) findViewById(R.id.ie);
        this.yyy = (TextView) findViewById(R.id.i6n);
        this.yyq = (LinearLayout) findViewById(R.id.hp_);
        this.yyr = (LinearLayout) findViewById(R.id.fsy);
        this.yyu = (LinearLayout) findViewById(R.id.hgg);
        this.yyv = (ImageView) findViewById(R.id.hgh);
        this.yys = (LinearLayout) findViewById(R.id.fm_);
        this.yyt = (ImageView) findViewById(R.id.fma);
        bg.aVF();
        if (((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            this.yyt.setVisibility(0);
        }
        if (com.tencent.mm.plugin.ipcall.a.c.ebQ()) {
            z2 = true;
        } else {
            if (h.aqJ().getInt("WCOPurchaseSwitch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this.yyj.setVisibility(8);
        }
        if (com.tencent.mm.plugin.ipcall.a.c.ebQ() || h.aqJ().getInt("WCOPackagePurchaseSwitch", 0) == 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            this.yym.setVisibility(0);
        }
        if (h.aqJ().getInt("WCOAccountDetailSwitch", 0) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            this.yyp.setVisibility(8);
        }
        if (com.tencent.mm.plugin.ipcall.a.c.ebQ()) {
            z6 = true;
        } else {
            if (h.aqJ().getInt("WCOInviteFriend", 0) == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                z6 = true;
            } else {
                z6 = false;
            }
        }
        if (z6) {
            this.yyq.setVisibility(8);
        }
        this.yyw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(25946);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                IPCallShareCouponUI.d(IPCallShareCouponUI.this);
                a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25946);
            }
        });
        this.yyx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(25947);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                IPCallShareCouponUI.e(IPCallShareCouponUI.this);
                a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25947);
            }
        });
        this.yyp.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(25948);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                IPCallShareCouponUI.f(IPCallShareCouponUI.this);
                a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25948);
            }
        });
        this.yyq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(25949);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13340, 1, -1, -1, -1, -1);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.getContext(), IPCallShareCouponCardUI.class);
                AppCompatActivity context = IPCallShareCouponUI.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25949);
            }
        });
        this.yys.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(25950);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bg.aVF();
                if (((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    bg.aVF();
                    com.tencent.mm.plugin.ipcall.model.f.i.am(4, -1, ((Integer) c.azQ().get(ar.a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, (Object) -1)).intValue());
                }
                bg.aVF();
                c.azQ().set(ar.a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, (Object) -1);
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                IPCallShareCouponUI.this.yyt.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.getContext(), IPCallMsgUI.class);
                AppCompatActivity context = IPCallShareCouponUI.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25950);
            }
        });
        this.yyr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(25951);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.getContext(), IPCallMyGiftCardUI.class);
                AppCompatActivity context = IPCallShareCouponUI.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25951);
            }
        });
        this.yyj.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(25952);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bg.aVF();
                if (((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    com.tencent.mm.plugin.ipcall.model.f.i.am(3, -1, -1);
                }
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                IPCallShareCouponUI.this.yyl.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.getContext(), IPCallRechargeUI.class);
                IPCallShareCouponUI iPCallShareCouponUI = IPCallShareCouponUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(iPCallShareCouponUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                iPCallShareCouponUI.startActivity((Intent) bl.pG(0));
                a.a(iPCallShareCouponUI, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25952);
            }
        });
        this.yym.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(25937);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.getContext(), IPCallPackageUI.class);
                IPCallShareCouponUI iPCallShareCouponUI = IPCallShareCouponUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(iPCallShareCouponUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                iPCallShareCouponUI.startActivity((Intent) bl.pG(0));
                a.a(iPCallShareCouponUI, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25937);
            }
        });
        this.yyu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass3 */

            public final void onClick(View view) {
                int i2;
                String str;
                AppMethodBeat.i(25938);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                String str2 = IPCallShareCouponUI.this.getString(R.string.e7d) + "&usedcc=";
                List<Integer> eag = com.tencent.mm.plugin.ipcall.model.c.ead().eag();
                if (eag == null || eag.size() <= 0) {
                    str2 = str2 + com.tencent.mm.plugin.ipcall.a.a.aCw(com.tencent.mm.plugin.ipcall.a.c.ebO());
                } else {
                    int size = eag.size();
                    if (size > 5) {
                        i2 = 5;
                    } else {
                        i2 = size;
                    }
                    int i3 = 0;
                    while (i3 < i2) {
                        String aCw = com.tencent.mm.plugin.ipcall.a.a.aCw(eag.get(i3).toString());
                        if (!Util.isNullOrNil(aCw)) {
                            str = str2 + aCw + "|";
                        } else {
                            str = str2;
                        }
                        i3++;
                        str2 = str;
                    }
                    if (str2.endsWith("|")) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                }
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                com.tencent.mm.br.c.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25938);
            }
        });
        byf ebR = com.tencent.mm.plugin.ipcall.a.c.ebR();
        if (ebR != null) {
            a(ebR);
            refreshView();
        } else {
            this.yyD.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.yuB = com.tencent.mm.ui.base.h.a((Context) context, getString(R.string.e6r), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(25939);
                    try {
                        IPCallShareCouponUI.this.finish();
                        AppMethodBeat.o(25939);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", e2.getMessage());
                        AppMethodBeat.o(25939);
                    }
                }
            });
        }
        if (com.tencent.mm.plugin.ipcall.a.c.ebQ()) {
            String string = getString(R.string.e9n);
            AnonymousClass5 r3 = new ClickableSpan() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(25940);
                    ((TextView) view).setHighlightColor(IPCallShareCouponUI.this.getResources().getColor(R.color.ac_));
                    String str = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
                    String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
                    if (!Util.isNullOrNil(currentLanguage)) {
                        str = str + "&wechat_real_lang=" + currentLanguage;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.br.c.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(25940);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(25941);
                    textPaint.setColor(IPCallShareCouponUI.this.getResources().getColor(R.color.x0));
                    textPaint.setUnderlineText(false);
                    AppMethodBeat.o(25941);
                }
            };
            Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(string + getString(R.string.e9m));
            int length = string.length();
            int length2 = newSpannable.length();
            if (length < 0 || length >= length2 || length2 < 0 || length2 > newSpannable.length()) {
                newSpannable.setSpan(r3, 0, newSpannable.length(), 33);
            } else {
                newSpannable.setSpan(r3, length, length2, 33);
            }
            this.yyy.setText(newSpannable);
            this.yyy.setMovementMethod(LinkMovementMethod.getInstance());
            this.yyy.setVisibility(0);
        } else {
            this.yyy.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.e9d);
        if (linearLayout != null && this.yyj.getVisibility() == 8 && this.yym.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.e9f);
        if (linearLayout2 != null && this.yyq.getVisibility() == 8 && this.yyr.getVisibility() == 8) {
            linearLayout2.setVisibility(8);
        }
        this.yyE.start();
        AppMethodBeat.o(25954);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(25955);
        super.onResume();
        com.tencent.mm.plugin.ipcall.model.g.b.eaU().qy(false);
        AppMethodBeat.o(25955);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25956);
        super.onDestroy();
        bg.azz().b(CdnLogic.kAppTypeFestivalImage, this);
        EventCenter.instance.removeListener(this.yus);
        this.yyE.yrT = Util.nowMilliSecond();
        this.yyE.finish();
        AppMethodBeat.o(25956);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awm;
    }

    private void refreshView() {
        AppMethodBeat.i(25957);
        if (!Util.isNullOrNil(this.yxT)) {
            if (this.yxS == null) {
                this.yyD.setValue(this.yxT, this.yxT);
            } else {
                this.yyD.setValue(this.yxS, this.yxT);
            }
            this.yxS = this.yxT;
        }
        this.yyA.getText();
        this.yyA.setText(this.yxU);
        if (Util.isNullOrNil(this.yxU)) {
            this.yyA.setVisibility(8);
        } else {
            this.yyA.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (this.yyF != null && this.yyF.size() > 0) {
            Iterator<ewj> it = this.yyF.iterator();
            while (it.hasNext()) {
                ewj next = it.next();
                if (next != null && !Util.isNullOrNil(next.MVg)) {
                    stringBuffer.append(next.MVg).append('\n');
                }
            }
        }
        if (!Util.isNullOrNil(stringBuffer.toString())) {
            if (stringBuffer.charAt(stringBuffer.length() - 1) == '\n') {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.yyB.setText(stringBuffer.toString());
            this.yyB.setVisibility(0);
        } else {
            this.yyB.setText("");
            this.yyB.setVisibility(8);
        }
        if (this.yyA.getVisibility() == 0 && this.yyB.getVisibility() == 0) {
            this.yyC.setVisibility(0);
            AppMethodBeat.o(25957);
            return;
        }
        this.yyC.setVisibility(8);
        AppMethodBeat.o(25957);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(25958);
        if (qVar instanceof g) {
            if (i2 == 0 && i3 == 0) {
                a(((g) qVar).yrB);
                refreshView();
                if (this.yuB != null && this.yuB.isShowing()) {
                    this.yuB.dismiss();
                }
                AppMethodBeat.o(25958);
                return;
            } else if (this.yuB != null && this.yuB.isShowing()) {
                this.yuB.dismiss();
                com.tencent.mm.ui.base.h.d(getContext(), getString(R.string.e6p), getString(R.string.e6i), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(25944);
                        IPCallShareCouponUI.this.finish();
                        AppMethodBeat.o(25944);
                    }
                });
            }
        }
        AppMethodBeat.o(25958);
    }

    private void a(byf byf) {
        this.yxP = byf.MdG;
        this.mDesc = byf.Desc;
        this.yxQ = byf.MdH;
        this.mTitle = byf.Title;
        this.mWording = byf.xJH;
        this.yxR = byf.MdI;
        this.yxT = byf.MdJ;
        this.yxU = byf.MdK;
        this.yxV = byf.MdL;
        this.yyF = byf.Mdr;
    }

    static /* synthetic */ void d(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.i(25959);
        iPCallShareCouponUI.yyE.yrV++;
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 2, 1, true);
        String string = MMApplicationContext.getContext().getString(R.string.e6v);
        try {
            com.tencent.mm.kernel.g.aAf();
            int uin = com.tencent.mm.kernel.a.getUin();
            String encode = URLEncoder.encode(d.DEVICE_NAME, ProtocolPackage.ServerEncoding);
            String encode2 = URLEncoder.encode(Util.getTimeZoneOffset(), ProtocolPackage.ServerEncoding);
            String encode3 = URLEncoder.encode(com.tencent.mm.compatible.deviceinfo.q.dr(true), ProtocolPackage.ServerEncoding);
            String encode4 = URLEncoder.encode(d.KyI, ProtocolPackage.ServerEncoding);
            String encode5 = URLEncoder.encode(d.KyJ, ProtocolPackage.ServerEncoding);
            String encode6 = URLEncoder.encode(d.KyK, ProtocolPackage.ServerEncoding);
            String encode7 = URLEncoder.encode(bg.azt(), ProtocolPackage.ServerEncoding);
            string = string + "&version=" + d.KyO + "&lang=" + LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()) + ("&uin=" + uin + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + encode7 + "&signature=" + URLEncoder.encode(Util.getSourceeMd5(MMApplicationContext.getContext()), ProtocolPackage.ServerEncoding) + "&scene=0");
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.IPCallShareCouponUI", "[royle]UnsupportedEncodingException:%s", e2.getMessage());
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        com.tencent.mm.br.c.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(25959);
    }

    static /* synthetic */ void e(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.i(25960);
        iPCallShareCouponUI.yyE.yrW++;
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.string.e61));
        intent.putExtra("showShare", false);
        com.tencent.mm.br.c.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(25960);
    }

    static /* synthetic */ void f(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.i(25961);
        iPCallShareCouponUI.yyE.yrU++;
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 1, 1, true);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_IPCALL_EXCHANGE_RECORD_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
        iPCallShareCouponUI.yyz.setVisibility(8);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.string.e6g));
        intent.putExtra("showShare", false);
        com.tencent.mm.br.c.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(25961);
    }

    static /* synthetic */ void i(IPCallShareCouponUI iPCallShareCouponUI) {
        AppMethodBeat.i(25962);
        byf ebR = com.tencent.mm.plugin.ipcall.a.c.ebR();
        if (ebR != null && !Util.isNullOrNil(ebR.MdQ)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", ebR.MdQ);
            intent.putExtra("showShare", false);
            com.tencent.mm.br.c.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(25962);
    }
}
