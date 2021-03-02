package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.br.c;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.co;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.chatting.m;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.ab;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.transmit.g;
import com.tencent.mm.ui.transmit.h;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@i
@a(23)
public class SelectConversationUI extends MMBaseSelectContactUI {
    private static final int Qzd = u.Q(1, 2);
    private int PMs = -1;
    private boolean PWC;
    private boolean PYG = false;
    private TextView PbU;
    private String Qyg = null;
    private int QzA;
    private String QzB;
    private int QzC = 0;
    private boolean QzD = false;
    protected boolean QzE = false;
    private MenuItem.OnMenuItemClickListener QzF = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass31 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(234498);
            SelectConversationUI.this.Qzu = !SelectConversationUI.this.Qzu;
            SelectConversationUI.this.gUP().Cp(SelectConversationUI.this.Qzu);
            SelectConversationUI.this.PWl.Cp(SelectConversationUI.this.Qzu);
            SelectConversationUI.n(SelectConversationUI.this);
            SelectConversationUI.this.PbU.setText(!SelectConversationUI.this.Qzu ? SelectConversationUI.this.Qze : R.string.gid);
            AppMethodBeat.o(234498);
            return true;
        }
    };
    private MenuItem.OnMenuItemClickListener QzG = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass32 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(234499);
            if (SelectConversationUI.q(SelectConversationUI.this)) {
                AppMethodBeat.o(234499);
                return false;
            }
            for (String str : SelectConversationUI.this.Qzv) {
                if (SelectConversationUI.this.bob(str)) {
                    AppMethodBeat.o(234499);
                    return false;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_User", Util.listToString(SelectConversationUI.this.Qzv, ","));
            Intent intent2 = (Intent) SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
            if (intent2 != null) {
                SelectConversationUI.a(SelectConversationUI.this, intent, intent2);
            } else if (SelectConversationUI.this.Qzj) {
                SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                SelectConversationUI.this.finish();
            } else {
                SelectConversationUI.a(SelectConversationUI.this, intent);
            }
            AppMethodBeat.o(234499);
            return true;
        }
    };
    private int Qze;
    private boolean Qzf = false;
    private boolean Qzg = false;
    private boolean Qzh = false;
    private boolean Qzi = false;
    private boolean Qzj = false;
    private boolean Qzk = false;
    boolean Qzl = false;
    private boolean Qzm = false;
    private int Qzn;
    private boolean Qzo = false;
    private boolean Qzp = false;
    private String Qzq;
    private String Qzr;
    private Boolean Qzs = Boolean.FALSE;
    private boolean Qzt = false;
    private boolean Qzu = false;
    private List<String> Qzv = null;
    private ReportUtil.ReportArgs Qzw;
    private String Qzx = null;
    private String Qzy;
    private String Qzz;
    private boolean Vmh = false;
    private long dFW;
    private String dLb;
    private ca dTX;
    private String dWG;
    private String emojiMD5;
    private int fromScene = 0;
    private List<String> gzY;
    private String imagePath = null;
    private int jVX;
    private long msgId;
    private int msgType;
    private String pSD = null;
    boolean tkE = false;
    private int[] tnn = {R.id.axp, R.id.axq, R.id.axr, R.id.axs, R.id.axt};

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectConversationUI() {
        AppMethodBeat.i(39354);
        AppMethodBeat.o(39354);
    }

    static /* synthetic */ void a(SelectConversationUI selectConversationUI, int i2, Intent intent) {
        AppMethodBeat.i(39404);
        selectConversationUI.s(i2, intent);
        AppMethodBeat.o(39404);
    }

    static /* synthetic */ void a(SelectConversationUI selectConversationUI, Intent intent, Intent intent2) {
        AppMethodBeat.i(185057);
        selectConversationUI.c(intent, intent2);
        AppMethodBeat.o(185057);
    }

    static /* synthetic */ void a(SelectConversationUI selectConversationUI, Intent intent, o.a aVar, HashMap hashMap, boolean z, String str, String str2, String str3) {
        AppMethodBeat.i(185054);
        selectConversationUI.a(intent, aVar, hashMap, z, str, str2, str3);
        AppMethodBeat.o(185054);
    }

    static /* synthetic */ void b(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(39398);
        selectConversationUI.gYm();
        AppMethodBeat.o(39398);
    }

    static /* synthetic */ void c(Intent intent, String str, String str2) {
        AppMethodBeat.i(39402);
        b(intent, str, str2);
        AppMethodBeat.o(39402);
    }

    static /* synthetic */ void d(Intent intent, String str, String str2) {
        AppMethodBeat.i(39403);
        a(intent, str, str2);
        AppMethodBeat.o(39403);
    }

    static /* synthetic */ void d(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(39399);
        selectConversationUI.gYn();
        AppMethodBeat.o(39399);
    }

    static /* synthetic */ void e(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(39400);
        selectConversationUI.gYo();
        AppMethodBeat.o(39400);
    }

    static /* synthetic */ void f(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(39401);
        super.egJ();
        AppMethodBeat.o(39401);
    }

    static /* synthetic */ void n(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(185055);
        selectConversationUI.ani();
        AppMethodBeat.o(185055);
    }

    static /* synthetic */ boolean q(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(185056);
        boolean CO = selectConversationUI.CO(false);
        AppMethodBeat.o(185056);
        return CO;
    }

    static {
        AppMethodBeat.i(39409);
        AppMethodBeat.o(39409);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39355);
        h.q(this);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Select_App_Id");
        String stringExtra2 = getIntent().getStringExtra("Select_Open_Id");
        Log.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + stringExtra + ", openId = " + stringExtra2);
        if (!Util.isNullOrNil(stringExtra) && !Util.isNullOrNil(stringExtra2)) {
            new d(this, stringExtra, stringExtra2, new d.a() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.base.stub.d.a
                public final void jZ(boolean z) {
                    AppMethodBeat.i(39323);
                    boolean isFinishing = SelectConversationUI.this.isFinishing();
                    Log.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                    if (!z && !isFinishing) {
                        ReportUtil.a(SelectConversationUI.this, (ReportUtil.ReportArgs) SelectConversationUI.this.getIntent().getParcelableExtra("Select_Report_Args"), false);
                        SelectConversationUI.this.finish();
                    }
                    AppMethodBeat.o(39323);
                }
            }).cjR();
        }
        h.r(this);
        AppMethodBeat.o(39355);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x02b0, code lost:
        if (r0 != false) goto L_0x02b2;
     */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void amZ() {
        /*
        // Method dump skipped, instructions count: 747
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.SelectConversationUI.amZ():void");
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(39357);
        ab abVar = new ab(this, this.gzY, this.PWC, this.Qzu, this.Qzm, this.jVX);
        AppMethodBeat.o(39357);
        return abVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final com.tencent.mm.ui.contact.o bmD() {
        AppMethodBeat.i(39358);
        s sVar = new s(this, this.gzY, this.Qzu, this.scene);
        AppMethodBeat.o(39358);
        return sVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void a(ListView listView, int i2) {
        AppMethodBeat.i(39359);
        super.a(listView, i2);
        if (this.fromScene == 11) {
            AppMethodBeat.o(39359);
            return;
        }
        if (this.PbU == null) {
            if (this.PYG) {
                this.Qze = R.string.gid;
            } else if (this.fromScene == 10) {
                this.Qze = R.string.fiu;
            } else {
                this.Qze = R.string.gi3;
            }
            AnonymousClass12 r0 = new View.OnClickListener() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass12 */

                public final void onClick(View view) {
                    AppMethodBeat.i(39335);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/transmit/SelectConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (SelectConversationUI.this.Qzu) {
                        SelectConversationUI.b(SelectConversationUI.this);
                    } else {
                        String stringExtra = SelectConversationUI.this.getIntent().getStringExtra("Select_App_Id");
                        if (!SelectConversationUI.this.PYG || !Util.isNullOrNil(stringExtra)) {
                            SelectConversationUI.e(SelectConversationUI.this);
                        } else {
                            SelectConversationUI.d(SelectConversationUI.this);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(39335);
                }
            };
            String string = getString(this.Qze);
            View inflate = aa.jQ(this).inflate(R.layout.ats, (ViewGroup) null);
            inflate.setOnClickListener(r0);
            TextView textView = (TextView) inflate.findViewById(R.id.bfe);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.PbU = textView;
        }
        this.PbU.setVisibility(i2);
        AppMethodBeat.o(39359);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void egJ() {
        AppMethodBeat.i(39360);
        if (this.fromScene == 5) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.err), (String) null, getString(R.string.gjr), getString(R.string.amn), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass23 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(39345);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(39345);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass34 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(39348);
                    SelectConversationUI.f(SelectConversationUI.this);
                    SelectConversationUI.this.hideVKB();
                    AppMethodBeat.o(39348);
                }
            });
        } else {
            super.egJ();
            hideVKB();
        }
        if (this.Qzw != null) {
            this.Qzw.errCode = 0;
            ReportUtil.a(this, this.Qzw, true);
        }
        AppMethodBeat.o(39360);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(39361);
        super.egJ();
        AppMethodBeat.o(39361);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(234500);
        if (this.Qzu) {
            int headerViewsCount = i2 - getContentLV().getHeaderViewsCount();
            if (headerViewsCount < 0) {
                Log.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i2));
                gYm();
                AppMethodBeat.o(234500);
                return;
            }
            p gUP = gUP();
            com.tencent.mm.ui.contact.a.a anH = gUP.getItem(headerViewsCount);
            if (anH == null) {
                AppMethodBeat.o(234500);
            } else if (anH.contact == null) {
                AppMethodBeat.o(234500);
            } else {
                String str = anH.contact.field_username;
                Log.i("MicroMsg.SelectConversationUI", "ClickUser=%s", str);
                if (this.Qzv.contains(str) || !CO(true)) {
                    gUW();
                    this.zoy.bev(str);
                    if (this.Qzv.contains(str)) {
                        this.Qzv.remove(str);
                    } else {
                        this.Qzv.add(str);
                    }
                    ani();
                    gUP.notifyDataSetChanged();
                    AppMethodBeat.o(234500);
                    return;
                }
                gUW();
                AppMethodBeat.o(234500);
            }
        } else if (i2 < getContentLV().getHeaderViewsCount()) {
            Log.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i2));
            if (this.PYG) {
                gYn();
                AppMethodBeat.o(234500);
                return;
            }
            gYo();
            AppMethodBeat.o(234500);
        } else {
            com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) getContentLV().getAdapter().getItem(i2);
            if (aVar == null) {
                AppMethodBeat.o(234500);
            } else if ((aVar instanceof com.tencent.mm.ui.contact.a.b) && ((com.tencent.mm.ui.contact.a.b) aVar).nickName == getResources().getString(R.string.fo)) {
                Log.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
                Intent intent = new Intent();
                intent.putExtra("list_attr", 16384);
                c.b(this, "brandservice", ".ui.BrandServiceIndexUI", intent, 4);
                this.Qzh = true;
                AppMethodBeat.o(234500);
            } else if (aVar instanceof g) {
                Intent intent2 = new Intent();
                intent2.putExtra("scene", this.scene);
                ArrayList arrayList = new ArrayList();
                String[] strArr = ((g) aVar).wWd.wWD;
                for (String str2 : strArr) {
                    arrayList.add(str2);
                }
                intent2.putExtra("query_phrase_list", arrayList);
                c.c(this, ".ui.transmit.MMCreateChatroomUI", intent2, 1);
                AppMethodBeat.o(234500);
            } else {
                as asVar = aVar.contact;
                if (asVar == null) {
                    AppMethodBeat.o(234500);
                    return;
                }
                aMp(asVar.field_username);
                AppMethodBeat.o(234500);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(39363);
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            Log.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i2 + ", resultCode = " + i3 + ", data = " + intent.toString());
        } else {
            Log.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i2 + ", resultCode = " + i3 + ", data = null");
        }
        if (i2 == 1) {
            if (i3 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                Log.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
                Intent intent2 = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                if (intent2 != null) {
                    if (bob(stringExtra)) {
                        AppMethodBeat.o(39363);
                        return;
                    }
                    c(intent, intent2);
                    AppMethodBeat.o(39363);
                    return;
                } else if (this.Qzf || this.PYG || this.Qzg || this.Qzh || this.Qzi || this.Vmh) {
                    u(intent, stringExtra);
                    AppMethodBeat.o(39363);
                    return;
                } else if (this.fromScene == 11) {
                    bod(stringExtra);
                    AppMethodBeat.o(39363);
                    return;
                } else {
                    s(-1, intent);
                    finish();
                }
            }
            AppMethodBeat.o(39363);
        } else if (i2 == 2) {
            switch (i3) {
                case -1:
                    com.tencent.f.h.RTc.o(new Runnable() {
                        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass35 */

                        public final void run() {
                            AppMethodBeat.i(39349);
                            SelectConversationUI.this.finish();
                            AppMethodBeat.o(39349);
                        }
                    }, 1000);
                    if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        Intent intent3 = new Intent(this, TaskRedirectUI.class);
                        intent3.addFlags(268435456);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        ReportUtil.ab(false, 0);
                        AppMethodBeat.o(39363);
                        return;
                    } else if (!(intent == null || intent.getExtras() == null || !intent.getBooleanExtra("Select_back_to_app", false))) {
                        ReportUtil.a(this, ReportUtil.d(intent.getExtras(), 0), false);
                        AppMethodBeat.o(39363);
                        return;
                    }
                    break;
                case 0:
                    if (intent != null) {
                        this.Qzw = (ReportUtil.ReportArgs) intent.getParcelableExtra("Select_Report_Args");
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(39363);
        } else if (i2 == 3) {
            switch (i3) {
                case -1:
                    if (intent != null) {
                        final String stringExtra2 = intent.getStringExtra("received_card_name");
                        if (!Util.isNullOrNil(stringExtra2) && !bob(stringExtra2)) {
                            o.a aVar = new o.a(getContext());
                            aVar.ea(stringExtra2);
                            a(aVar, this.Qzq);
                            o.a p = aVar.p(Boolean.TRUE);
                            p.Kfh = gYi();
                            p.a(new y.a() {
                                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass36 */

                                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                                public final void a(boolean z, String str, int i2) {
                                    AppMethodBeat.i(39350);
                                    SelectConversationUI.this.hideVKB();
                                    if (z) {
                                        Intent intent = new Intent();
                                        if (com.tencent.mm.model.ab.Eq(stringExtra2)) {
                                            SelectConversationUI.c(intent, SelectConversationUI.this.Qzq, stringExtra2);
                                        } else {
                                            SelectConversationUI.d(intent, SelectConversationUI.this.Qzq, stringExtra2);
                                        }
                                        intent.putExtra("custom_send_text", str);
                                        SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                                        SelectConversationUI.this.finish();
                                    }
                                    AppMethodBeat.o(39350);
                                }
                            }).kdo.show();
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(39363);
        } else if (i2 == 4) {
            if (i3 == -1 && intent != null) {
                u(intent, intent.getStringExtra("Select_Contact"));
            }
            AppMethodBeat.o(39363);
        } else if (i2 == 5) {
            if (i3 == -1 && intent != null) {
                String stringExtra3 = intent.getStringExtra("Select_Conv_User");
                for (String str : this.Qzv) {
                    this.zoy.bew(str);
                }
                if (!Util.isNullOrNil(stringExtra3)) {
                    this.Qzv = Util.stringsToList(stringExtra3.split(","));
                } else {
                    this.Qzv.clear();
                }
                for (String str2 : this.Qzv) {
                    this.zoy.bex(str2);
                }
                ani();
                gUP().notifyDataSetChanged();
            }
            AppMethodBeat.o(39363);
        } else {
            Log.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(39363);
        }
    }

    private static boolean boa(String str) {
        AppMethodBeat.i(39364);
        if (as.bjp(str)) {
            AppMethodBeat.o(39364);
            return true;
        } else if (com.tencent.mm.model.ab.Iy(str)) {
            AppMethodBeat.o(39364);
            return true;
        } else {
            AppMethodBeat.o(39364);
            return false;
        }
    }

    public final boolean bob(String str) {
        AppMethodBeat.i(39365);
        if (!boa(str)) {
            AppMethodBeat.o(39365);
            return false;
        } else if (Util.isNullOrNil(getIntent().getStringExtra("Select_App_Id")) || !this.PYG) {
            if (this.PYG) {
                bg.aVF();
                if (as.akh(com.tencent.mm.model.c.aSN().bjJ(this.Qzq).field_verifyFlag)) {
                    boc(str);
                    AppMethodBeat.o(39365);
                    return true;
                }
            }
            switch (this.msgType) {
                case 5:
                    AppMethodBeat.o(39365);
                    return false;
                case 6:
                case 7:
                default:
                    AppMethodBeat.o(39365);
                    return false;
                case 8:
                    bg.aVF();
                    String str2 = com.tencent.mm.model.c.aSQ().aEK(this.dWG).dkU;
                    bg.aVF();
                    if (com.tencent.mm.model.ab.rR(com.tencent.mm.model.c.aSN().bjJ(str2).field_verifyFlag)) {
                        boc(str);
                        AppMethodBeat.o(39365);
                        return true;
                    }
                    AppMethodBeat.o(39365);
                    return false;
            }
        } else {
            AppMethodBeat.o(39365);
            return false;
        }
    }

    private void boc(String str) {
        AppMethodBeat.i(39366);
        try {
            ArrayList<String> stringsToList = Util.stringsToList(str.split(","));
            StringBuffer stringBuffer = new StringBuffer();
            boolean z = false;
            for (String str2 : stringsToList) {
                if (!Util.isNullOrNil(str2)) {
                    if (z) {
                        stringBuffer.append(",");
                    }
                    stringBuffer.append(com.tencent.mm.model.aa.getDisplayName(str2));
                    z = true;
                }
            }
            com.tencent.mm.ui.base.h.d(this, getString(R.string.h0n, new Object[]{stringBuffer}), "", null);
            AppMethodBeat.o(39366);
        } catch (Throwable th) {
            AppMethodBeat.o(39366);
        }
    }

    /* access modifiers changed from: protected */
    public final void aMp(String str) {
        AppMethodBeat.i(169903);
        Log.i("MicroMsg.SelectConversationUI", "doClickUser=%s", str);
        if (bob(str)) {
            AppMethodBeat.o(169903);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_User", str);
        Intent intent2 = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (intent2 != null) {
            c(intent, intent2);
        } else if (this.Qzf || this.PYG || this.Qzg || this.Qzh || this.Qzi || this.tkE || this.Vmh) {
            u(intent, str);
        } else if (this.fromScene == 11) {
            bod(str);
        } else {
            s(-1, intent);
            finish();
        }
        hideVKB();
        AppMethodBeat.o(169903);
    }

    private void bod(String str) {
        AppMethodBeat.i(39367);
        Log.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", str, this.Qzz, Integer.valueOf(this.QzA));
        Log.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", this.QzB);
        ((com.tencent.mm.choosemsgfile.compat.a) com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, str, this.Qzz, this.QzA, this.QzB, new a.AbstractC0293a() {
            /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass37 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.choosemsgfile.compat.a.AbstractC0293a
            public final void a(int i2, String str, ArrayList<MsgFile> arrayList) {
                AppMethodBeat.i(39351);
                Log.i("MicroMsg.SelectConversationUI", "resultCode:%d filePaths:%s", Integer.valueOf(i2), arrayList);
                switch (i2) {
                    case -1:
                        Intent intent = new Intent();
                        intent.putParcelableArrayListExtra("FILEPATHS", arrayList);
                        SelectConversationUI.this.setResult(-1, intent);
                        SelectConversationUI.this.finish();
                        AppMethodBeat.o(39351);
                        return;
                    case 1:
                        Intent intent2 = new Intent();
                        intent2.putExtra("ERRMSG", str);
                        SelectConversationUI.this.setResult(1, intent2);
                        SelectConversationUI.this.finish();
                        break;
                }
                AppMethodBeat.o(39351);
            }
        });
        AppMethodBeat.o(39367);
    }

    private static void a(Intent intent, String str, String str2) {
        AppMethodBeat.i(39368);
        LinkedList linkedList = new LinkedList();
        linkedList.add(str2);
        a(intent, str, linkedList);
        AppMethodBeat.o(39368);
    }

    private static void a(Intent intent, String str, List<String> list) {
        AppMethodBeat.i(39369);
        if (list.size() > 0) {
            intent.putExtra("be_send_card_name", str);
            intent.putExtra("received_card_name", Util.listToString(list, ","));
            intent.putExtra("Is_Chatroom", false);
        }
        AppMethodBeat.o(39369);
    }

    private static void b(Intent intent, String str, String str2) {
        AppMethodBeat.i(39370);
        Assert.assertTrue("cardNameToSend is null", str != null);
        intent.putExtra("be_send_card_name", str);
        intent.putExtra("received_card_name", str2);
        intent.putExtra("Is_Chatroom", true);
        AppMethodBeat.o(39370);
    }

    private void a(o.a aVar, String str) {
        AppMethodBeat.i(39371);
        bg.aVF();
        com.tencent.mm.model.c.aSN().bjJ(str);
        String displayName = com.tencent.mm.model.aa.getDisplayName(str);
        if (!Util.isNullOrNil(this.Qzr)) {
            displayName = this.Qzr;
        }
        aVar.beQ(new StringBuffer(boe(str)).append(displayName).toString());
        AppMethodBeat.o(39371);
    }

    private String boe(String str) {
        String string;
        boolean z = false;
        AppMethodBeat.i(39372);
        bg.aVF();
        as bjJ = com.tencent.mm.model.c.aSN().bjJ(str);
        String string2 = getResources().getString(R.string.vr);
        if (bjJ == null) {
            AppMethodBeat.o(39372);
            return string2;
        }
        bg.aVF();
        ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(this.dWG);
        if (aEK != null && (com.tencent.mm.model.ab.rR(aEK.IOs) || bjJ.gBM())) {
            z = true;
        }
        if (z) {
            string = getResources().getString(R.string.vq);
        } else if (as.bjp(str)) {
            string = c(this, bjJ);
        } else {
            string = getResources().getString(R.string.vr);
        }
        AppMethodBeat.o(39372);
        return string;
    }

    public static String c(Context context, as asVar) {
        String format;
        AppMethodBeat.i(39373);
        String a2 = ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a(asVar.field_openImAppid, "openim_card_type_name", a.EnumC0497a.TYPE_WORDING);
        if (TextUtils.isEmpty(a2)) {
            format = context.getResources().getString(R.string.vr);
        } else {
            format = String.format("[%s]", a2);
        }
        AppMethodBeat.o(39373);
        return format;
    }

    private void c(Intent intent, Intent intent2) {
        AppMethodBeat.i(39374);
        Log.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=".concat(String.valueOf(intent2)));
        intent2.putExtras(intent.getExtras());
        startActivityForResult(intent2, 2);
        com.tencent.mm.ui.base.b.az(getContext(), intent2);
        AppMethodBeat.o(39374);
    }

    private String gYi() {
        AppMethodBeat.i(169904);
        String stringExtra = getIntent().getStringExtra("KSendWording");
        if (Util.isNullOrNil(stringExtra)) {
            stringExtra = getString(R.string.yq);
        }
        AppMethodBeat.o(169904);
        return stringExtra;
    }

    private void u(final Intent intent, final String str) {
        String stringBuffer;
        int i2;
        AppMethodBeat.i(39375);
        if (bob(str)) {
            AppMethodBeat.o(39375);
        } else if (u.hasAttr(this.jVX, 256)) {
            s(-1, intent);
            finish();
            AppMethodBeat.o(39375);
        } else if (Util.isNullOrNil(str)) {
            Log.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
            AppMethodBeat.o(39375);
        } else {
            if (com.tencent.mm.model.ab.Eq(str)) {
                int Ie = v.Ie(str);
                if (!this.Qzo || Ie <= (i2 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50))) {
                    getString(R.string.ghu, new Object[]{Integer.valueOf(Ie)});
                } else {
                    Log.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", Integer.valueOf(i2), Integer.valueOf(Ie));
                    com.tencent.mm.ui.base.h.c(this, getString(R.string.ghw, new Object[]{Integer.valueOf(i2)}), "", true);
                    AppMethodBeat.o(39375);
                    return;
                }
            }
            o.a aVar = new o.a(getContext());
            aVar.ea(str);
            if (this.PYG) {
                a(aVar, this.Qzq);
                if (com.tencent.mm.model.ab.Eq(str)) {
                    b(intent, this.Qzq, str);
                } else {
                    a(intent, this.Qzq, str);
                }
                aVar.p(Boolean.TRUE);
            } else if (this.Qzg) {
                if (!getIntent().hasExtra("appbrand_params") || !a(intent, aVar, (String) null)) {
                    if (this.dFW != -1) {
                        a(aVar);
                        gx gxVar = new gx();
                        gxVar.dLa.dFW = this.dFW;
                        gxVar.dLa.dLb = this.dLb;
                        gxVar.dLa.dLc = this.msgType;
                        gxVar.dLa.dLd = aVar;
                        gxVar.dLa.dLe = this.Qzy;
                        gxVar.dLa.dDg = getContext();
                        EventCenter.instance.publish(gxVar);
                    } else if (this.msgType == 17 && this.Qzn != 0) {
                        aVar.beQ(new StringBuffer(getResources().getString(R.string.ws)).append(getContext().getString(R.string.g5e, new Object[]{Integer.valueOf(this.Qzn)})).toString());
                    }
                    aVar.p(Boolean.TRUE);
                } else {
                    AppMethodBeat.o(39375);
                    return;
                }
            } else if (this.Qzh && !this.tkE) {
                HashMap hashMap = (HashMap) getIntent().getSerializableExtra("webview_params");
                String str2 = (String) hashMap.get("img_url");
                String str3 = (String) hashMap.get("title");
                final String str4 = (String) hashMap.get("url");
                if (!this.Qzl) {
                    stringBuffer = new StringBuffer(getResources().getString(R.string.zp)).append(str3).toString();
                } else {
                    stringBuffer = new StringBuffer(getResources().getString(R.string.vt)).append((String) hashMap.get("nickname")).toString();
                }
                aVar.beQ(stringBuffer);
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass38 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(39352);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str4);
                        intent.putExtra("showShare", false);
                        c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(39352);
                    }
                });
                aVar.beR(str2).gpy();
                aVar.p(Boolean.TRUE);
            } else if (this.Qzi && a(intent, aVar, str)) {
                AppMethodBeat.o(39375);
                return;
            } else if (this.Qzk) {
                String string = getResources().getString(R.string.vw);
                if (this.pSD != null) {
                    string = new StringBuffer(string).append(this.pSD).toString();
                }
                aVar.beQ(string);
                aVar.p(Boolean.FALSE);
            } else if (this.Vmh) {
                aVar.beQ(getResources().getString(R.string.j81));
                aVar.p(Boolean.FALSE);
            } else {
                b(aVar, str);
                a(aVar);
                aVar.p(Boolean.TRUE);
            }
            aVar.Kfh = gYi();
            aVar.a(new y.a() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass39 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                public final void a(boolean z, String str, int i2) {
                    int i3;
                    int i4 = 1;
                    AppMethodBeat.i(39353);
                    SelectConversationUI.this.hideVKB();
                    boolean booleanExtra = intent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
                    if (booleanExtra) {
                        if (z) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        Log.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", 13943, Integer.valueOf(i3));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13943, Integer.valueOf(i3));
                    }
                    if (z) {
                        intent.putExtra("custom_send_text", str);
                        intent.putExtra("KSendGroupToDo", SelectConversationUI.this.QzD);
                        intent.putExtra("KShowTodoIntroduceView", SelectConversationUI.this.QzC);
                        SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                        com.tencent.mm.pluginsdk.ui.tools.q.mG(SelectConversationUI.this.dWG, str);
                        SelectConversationUI.this.finish();
                    } else if (booleanExtra) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        bg.aVF();
                        com.tencent.mm.model.c.aST().bjW(stringExtra);
                    }
                    SelectConversationUI selectConversationUI = SelectConversationUI.this;
                    String str2 = str;
                    if (z) {
                        i4 = 2;
                    }
                    SelectConversationUI.a(selectConversationUI, str2, i4);
                    AppMethodBeat.o(39353);
                }
            }).kdo.show();
            AppMethodBeat.o(39375);
        }
    }

    private boolean a(final Intent intent, final o.a aVar, final String str) {
        AppMethodBeat.i(180097);
        final HashMap<String, Object> hashMap = (HashMap) getIntent().getSerializableExtra("appbrand_params");
        boolean cg = co.cg(hashMap.get("is_weishi_video"));
        final boolean cg2 = co.cg(hashMap.get("is_video"));
        if (cg) {
            boolean a2 = a(aVar, hashMap);
            AppMethodBeat.o(180097);
            return a2;
        }
        int i2 = co.getInt(hashMap.get("type"), 1);
        final String c2 = co.c(hashMap.get("title"), "");
        final String c3 = co.c(hashMap.get("img_url"), null);
        int i3 = co.getInt(hashMap.get("biz"), k.a.BUSINESS_MAX.ordinal());
        if (!k.a.isValid(i3) && (i2 == 2 || i2 == 3)) {
            if (str == null || !com.tencent.mm.chatroom.d.y.ama() || !com.tencent.mm.model.ab.IE(str) || !MultiProcessMMKV.getMMKV("group_to_do").getBoolean("introduce_dialog_first", true)) {
                a(intent, aVar, hashMap, cg2, c3, c2, str);
            } else {
                MultiProcessMMKV.getMMKV("group_to_do").edit().putBoolean("introduce_dialog_first", false);
                g.a(this, new g.a() {
                    /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.transmit.g.a
                    public final void gUb() {
                        AppMethodBeat.i(180080);
                        intent.putExtra("KShowTodoIntroduceView", 1);
                        SelectConversationUI.a(SelectConversationUI.this, intent, aVar, hashMap, cg2, c3, c2, str);
                        AppMethodBeat.o(180080);
                    }
                });
            }
            AppMethodBeat.o(180097);
            return true;
        } else if (k.a.isValid(i3)) {
            String string = getResources().getString(R.string.jz);
            String c4 = co.c(hashMap.get("nickname"), null);
            if (!Util.isNullOrNil(c4)) {
                string = Util.safeFormatString(getResources().getString(R.string.u8), c4);
            }
            aVar.beQ(string + c2);
            final h hVar = new h(this);
            hVar.QAE = new h.a() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass3 */

                @Override // com.tencent.mm.ui.transmit.h.a
                public final void e(boolean z, String str, boolean z2) {
                    AppMethodBeat.i(234479);
                    intent.putExtra("KSendGroupToDo", z2);
                    if (z) {
                        intent.putExtra("custom_send_text", str);
                        SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                        SelectConversationUI.this.finish();
                        AppMethodBeat.o(234479);
                        return;
                    }
                    SelectConversationUI.a(SelectConversationUI.this, 0, intent);
                    if (SelectConversationUI.this.QzE) {
                        SelectConversationUI.this.finish();
                    }
                    AppMethodBeat.o(234479);
                }
            };
            com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass4 */

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void aYg() {
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void I(Bitmap bitmap) {
                    AppMethodBeat.i(234480);
                    hVar.gYw();
                    AppMethodBeat.o(234480);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void oD() {
                    AppMethodBeat.i(234481);
                    hVar.gYw();
                    AppMethodBeat.o(234481);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                public final String Lb() {
                    AppMethodBeat.i(234482);
                    String cO = n.cO(this);
                    AppMethodBeat.o(234482);
                    return cO;
                }
            }, c3, com.tencent.mm.modelappbrand.a.g.iJB);
            aVar.p(Boolean.TRUE);
            aVar.Kfh = gYi();
            aVar.a(new y.a() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass5 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                public final void a(boolean z, String str, int i2) {
                    AppMethodBeat.i(39327);
                    SelectConversationUI.this.hideVKB();
                    hVar.a(z, str, i2, false);
                    AppMethodBeat.o(39327);
                }
            }).kdo.show();
            AppMethodBeat.o(180097);
            return true;
        } else {
            aVar.beQ(new StringBuffer(getResources().getString(R.string.jz)).append(c2).toString());
            aVar.beR(c3).gpy();
            aVar.p(Boolean.TRUE);
            AppMethodBeat.o(180097);
            return false;
        }
    }

    private void a(final Intent intent, o.a aVar, HashMap<String, Object> hashMap, boolean z, String str, String str2, String str3) {
        Bundle bundle;
        boolean IE;
        AppMethodBeat.i(180098);
        String c2 = co.c(hashMap.get("app_id"), null);
        int i2 = co.getInt(hashMap.get("pkg_type"), 0);
        int i3 = co.getInt(hashMap.get("pkg_version"), 0);
        String c3 = co.c(hashMap.get("cache_key"), null);
        String c4 = co.c(hashMap.get("path"), null);
        String c5 = co.c(hashMap.get("delay_load_img_path"), null);
        String c6 = co.c(hashMap.get("nickname"), "");
        boolean cg = co.cg(hashMap.get("is_dynamic"));
        int i4 = co.getInt(hashMap.get("subType"), 0);
        int i5 = co.getInt(hashMap.get("biz"), k.a.BUSINESS_MAX.ordinal());
        if (k.a.isValid(i5)) {
            String c7 = co.c(hashMap.get("tail_lang"), "");
            String c8 = co.c(hashMap.get("icon_url"), "");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("key_biz", i5);
            bundle2.putString("key_footer_text_default", c6);
            bundle2.putString("key_footer_text", k.a.b(i5, c7, getContext()));
            bundle2.putString("key_footer_icon", c8);
            Log.d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", c6, c7);
            bundle = bundle2;
        } else if (z) {
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("is_video", true);
            String c9 = co.c(hashMap.get("footer_icon"), "");
            String c10 = co.c(hashMap.get("footer_text"), "");
            bundle3.putString("key_footer_icon", c9);
            bundle3.putString("key_footer_text", c10);
            bundle = bundle3;
        } else {
            Log.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", Integer.valueOf(i5));
            bundle = null;
        }
        com.tencent.mm.modelappbrand.k kVar = (com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class);
        if (str3 == null) {
            IE = false;
        } else {
            IE = com.tencent.mm.model.ab.IE(str3);
        }
        final View a2 = kVar.a(this, bundle, IE, new k.c() {
            /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass6 */

            @Override // com.tencent.mm.modelappbrand.k.c
            public final void aXL() {
                AppMethodBeat.i(234483);
                intent.putExtra("KShowTodoIntroduceView", 1);
                g.a(SelectConversationUI.this, null);
                AppMethodBeat.o(234483);
            }

            @Override // com.tencent.mm.modelappbrand.k.c
            public final void ft(boolean z) {
            }
        });
        final String cO = n.cO(this);
        Bundle bundle4 = new Bundle();
        bundle4.putString("app_id", c2);
        bundle4.putString("msg_id", String.format("%d-%d", Integer.valueOf(i2), Integer.valueOf(i3)));
        bundle4.putInt("msg_pkg_type", i2);
        bundle4.putInt("pkg_version", i3);
        bundle4.putString(MessengerShareContentUtility.IMAGE_URL, str);
        bundle4.putBoolean("is_dynamic_page", cg);
        bundle4.putString("title", str2);
        bundle4.putString("cache_key", c3);
        bundle4.putString("msg_path", c4);
        bundle4.putString("delay_load_img_path", c5);
        bundle4.putInt("sub_type", i4);
        if (z) {
            String c11 = co.c(hashMap.get("video_path"), "");
            String c12 = co.c(hashMap.get("video_thumb_path"), "");
            bundle4.putBoolean("is_video", true);
            bundle4.putString("video_path", c11);
            bundle4.putString("video_thumb_path", c12);
        }
        final h hVar = new h(this);
        hVar.QAE = new h.a() {
            /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.transmit.h.a
            public final void e(boolean z, String str, boolean z2) {
                AppMethodBeat.i(234484);
                intent.putExtra("KSendGroupToDo", z2);
                if (z) {
                    intent.putExtra("custom_send_text", str);
                    SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                    SelectConversationUI.this.finish();
                } else {
                    SelectConversationUI.a(SelectConversationUI.this, 0, intent);
                    if (SelectConversationUI.this.QzE) {
                        SelectConversationUI.this.finish();
                    }
                }
                ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(cO, a2);
                AppMethodBeat.o(234484);
            }
        };
        ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(cO, a2, bundle4, new k.b() {
            /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass8 */

            @Override // com.tencent.mm.modelappbrand.k.b
            public final void sD(int i2) {
                AppMethodBeat.i(234485);
                Log.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", Integer.valueOf(i2));
                hVar.gYw();
                AppMethodBeat.o(234485);
            }
        });
        aVar.gl(a2);
        aVar.p(Boolean.TRUE);
        aVar.gpz();
        aVar.opQ = new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass9 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(234486);
                ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(cO, a2);
                AppMethodBeat.o(234486);
            }
        };
        aVar.Kfh = gYi();
        aVar.a(new y.a() {
            /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass10 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(234487);
                SelectConversationUI.this.hideVKB();
                Object tag = a2.getTag(R.id.rh);
                hVar.a(z, str, i2, tag == null ? false : ((Boolean) tag).booleanValue());
                AppMethodBeat.o(234487);
            }
        }).kdo.show();
        AppMethodBeat.o(180098);
    }

    private boolean a(o.a aVar, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(39377);
        final String c2 = co.c(hashMap.get("img_url"), null);
        if (!Util.isNullOrNil(c2)) {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            View inflate = LayoutInflater.from(this).inflate(R.layout.vy, (ViewGroup) null);
            relativeLayout.addView(inflate, new RelativeLayout.LayoutParams(-2, -2));
            ((RelativeLayout.LayoutParams) inflate.getLayoutParams()).addRule(14);
            final ImageView imageView = (ImageView) inflate.findViewById(R.id.ffl);
            ((ImageView) inflate.findViewById(R.id.dwm)).setImageResource(R.raw.video_icon_in_gird);
            aVar.gl(relativeLayout);
            aVar.gpz();
            com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass11 */

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void aYg() {
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void I(Bitmap bitmap) {
                    AppMethodBeat.i(234488);
                    if (!SelectConversationUI.this.isFinishing() && bitmap != null && !bitmap.isRecycled() && imageView != null) {
                        imageView.setImageBitmap(aq.a(SelectConversationUI.a(SelectConversationUI.this, bitmap, imageView, bitmap.getWidth(), bitmap.getHeight()), (float) at.fromDPToPix(SelectConversationUI.this, 3)));
                    }
                    AppMethodBeat.o(234488);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void oD() {
                    AppMethodBeat.i(234489);
                    Log.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", c2);
                    AppMethodBeat.o(234489);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                public final String Lb() {
                    return "SelectConversationUI#WEISHITHUMB";
                }
            }, c2, (b.h) null, (b.f) null);
        } else {
            String c3 = co.c(hashMap.get("msg_img_path"), null);
            if (!Util.isNullOrNil(c3)) {
                Log.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", c2, c3);
                aVar.l(bof(c3), 2);
            }
        }
        aVar.p(Boolean.TRUE);
        AppMethodBeat.o(39377);
        return false;
    }

    private void b(o.a aVar, String str) {
        int i2;
        k.b bVar;
        String string;
        String str2;
        Bundle bundle;
        boolean IE;
        String str3;
        String str4;
        AppMethodBeat.i(180099);
        switch (this.msgType) {
            case 0:
            case 16:
                Bitmap gYl = gYl();
                if (gYl == null && this.imagePath != null) {
                    Bitmap bitmapNative = BitmapUtil.getBitmapNative(this.imagePath, 140, 140, com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()));
                    int orientationInDegree = Exif.fromFile(this.imagePath).getOrientationInDegree();
                    if (orientationInDegree < 0) {
                        orientationInDegree = 0;
                    }
                    gYl = BitmapUtil.rotate(bitmapNative, (float) orientationInDegree);
                }
                aVar.l(gYl, 3);
                AppMethodBeat.o(180099);
                return;
            case 1:
                aVar.l(gYk(), 2);
                AppMethodBeat.o(180099);
                return;
            case 2:
            case 10:
                k.b HD = k.b.HD(Util.processXml(this.dWG));
                if (!this.dTX.gAt() || HD != null) {
                    bVar = HD;
                } else {
                    bVar = k.b.aD(Util.processXml(this.dWG), Util.processXml(this.dWG));
                }
                if (bVar == null) {
                    if (this.Qzx != null) {
                        aVar.beQ(new StringBuffer(getResources().getString(R.string.zv)).append(this.Qzx).toString());
                    }
                    AppMethodBeat.o(180099);
                    return;
                }
                String str5 = bVar.title;
                if (m.f(this.dTX, this.PMs)) {
                    string = getResources().getString(R.string.jz);
                    str2 = str5;
                } else if (bVar.type == 5) {
                    string = getResources().getString(R.string.zp);
                    str2 = str5;
                } else if (bVar.type == 6) {
                    string = getResources().getString(R.string.ve);
                    str2 = str5;
                } else if (bVar.type == 24) {
                    string = getResources().getString(R.string.x9);
                    str2 = t(bVar);
                } else if (bVar.type == 19) {
                    string = getResources().getString(R.string.yc);
                    str2 = str5;
                } else if (bVar.type == 3 || bVar.type == 76) {
                    com.tencent.mm.pluginsdk.ui.tools.b bVar2 = (com.tencent.mm.pluginsdk.ui.tools.b) bVar.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
                    if (bVar2 != null) {
                        String d2 = com.tencent.mm.av.q.bcR().d(this.dTX.field_imgPath, false, true);
                        if (Util.isNullOrNil(d2) || !com.tencent.mm.vfs.s.YS(d2)) {
                            d2 = this.Qyg;
                        }
                        aVar.gl(a(d2, bVar, bVar2));
                        aVar.gpz();
                        AppMethodBeat.o(180099);
                        return;
                    }
                    string = getResources().getString(R.string.wv);
                    str2 = str5;
                } else if (bVar.type == 4) {
                    string = getResources().getString(R.string.zv);
                    str2 = str5;
                } else if (bVar.type == 8) {
                    string = getResources().getString(R.string.tw);
                    str2 = str5;
                } else if (bVar.type == 44) {
                    if (Util.isNullOrNil(bVar.eah)) {
                        string = getResources().getString(R.string.z1);
                        str2 = str5;
                    } else {
                        string = Util.safeFormatString(getResources().getString(R.string.u8), bVar.eah);
                        str2 = str5;
                    }
                } else if (bVar.type == 33 || bVar.type == 36 || bVar.type == 48) {
                    if (bVar.izk == 2 || bVar.izk == 3 || bVar.type == 36 || bVar.type == 48) {
                        int i3 = bVar.izp;
                        if (bVar.fn(false)) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("key_biz", i3);
                            bundle2.putString("key_footer_text_default", bVar.eah);
                            bundle2.putString("key_footer_text", bVar.w(getContext(), false));
                            bundle2.putString("key_footer_icon", bVar.izB);
                            bundle = bundle2;
                        } else if (bVar.type == 48) {
                            Bundle bundle3 = new Bundle();
                            bundle3.putBoolean("is_video", true);
                            bundle3.putString("key_footer_icon", bVar.izB);
                            bundle3.putString("key_footer_text", bVar.eah);
                            bundle = bundle3;
                        } else {
                            Log.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", Integer.valueOf(i3));
                            bundle = null;
                        }
                        com.tencent.mm.modelappbrand.k kVar = (com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class);
                        if (str == null) {
                            IE = false;
                        } else {
                            IE = com.tencent.mm.model.ab.IE(str);
                        }
                        final View a2 = kVar.a(this, bundle, IE, new k.c() {
                            /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass13 */

                            @Override // com.tencent.mm.modelappbrand.k.c
                            public final void aXL() {
                                AppMethodBeat.i(234490);
                                SelectConversationUI.this.QzC = 1;
                                g.a(SelectConversationUI.this, null);
                                AppMethodBeat.o(234490);
                            }

                            @Override // com.tencent.mm.modelappbrand.k.c
                            public final void ft(boolean z) {
                                AppMethodBeat.i(234491);
                                SelectConversationUI.this.QzD = z;
                                AppMethodBeat.o(234491);
                            }
                        });
                        aVar.gl(a2);
                        aVar.p(Boolean.TRUE);
                        aVar.gpz();
                        String d3 = com.tencent.mm.av.q.bcR().d(this.dTX.field_imgPath, false, true);
                        final String cO = n.cO(this);
                        Bundle bundle4 = new Bundle();
                        bundle4.putString("app_id", bVar.izj);
                        bundle4.putString("msg_id", String.format("%d-%d", Integer.valueOf(bVar.izz), Integer.valueOf(bVar.izm)));
                        bundle4.putInt("msg_pkg_type", bVar.izz);
                        bundle4.putInt("pkg_version", bVar.izm);
                        if (!Util.isNullOrNil(d3)) {
                            bundle4.putString(MessengerShareContentUtility.IMAGE_URL, "file://".concat(String.valueOf(d3)));
                        }
                        com.tencent.mm.ag.a aVar2 = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
                        if (aVar2 != null) {
                            bundle4.putBoolean("is_dynamic_page", aVar2.iuQ);
                            bundle4.putString("cache_key", aVar2.iuR);
                            bundle4.putInt("sub_type", aVar2.ivf);
                        }
                        bundle4.putString("title", bVar.title);
                        bundle4.putString("msg_path", bVar.izh);
                        ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(cO, a2, bundle4);
                        aVar.opQ = new DialogInterface.OnDismissListener() {
                            /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass14 */

                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(234492);
                                ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(cO, a2);
                                AppMethodBeat.o(234492);
                            }
                        };
                        AppMethodBeat.o(180099);
                        return;
                    }
                    string = getResources().getString(R.string.jz);
                    str2 = str5;
                } else if (bVar.type == 53 || bVar.type == 57) {
                    string = "";
                    str2 = str5;
                } else {
                    string = getResources().getString(R.string.hb);
                    str2 = str5;
                }
                if (bVar.type == 48) {
                    string = getResources().getString(R.string.vu);
                }
                if (bVar.type == 46) {
                    aVar.l(gYl(), 2);
                    AppMethodBeat.o(180099);
                    return;
                } else if (bVar.type == 69) {
                    com.tencent.mm.plugin.game.luggage.f.a aVar3 = (com.tencent.mm.plugin.game.luggage.f.a) bVar.as(com.tencent.mm.plugin.game.luggage.f.a.class);
                    if (aVar3 != null) {
                        aVar.beQ(getResources().getString(R.string.vt) + aVar3.nickName);
                        if (!Util.isNullOrNil(aVar3.iconUrl)) {
                            aVar.beR(aVar3.iconUrl).gpy();
                        }
                    }
                    AppMethodBeat.o(180099);
                    return;
                } else {
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar.beQ(string + str2);
                    if (bVar.thumburl != null) {
                        aVar.beR(bVar.thumburl).gpy();
                        AppMethodBeat.o(180099);
                        return;
                    }
                }
                break;
            case 3:
                if (this.pSD != null) {
                    aVar.beQ(new StringBuffer(getResources().getString(R.string.ve)).append(this.pSD).toString());
                    break;
                }
                break;
            case 4:
                aVar.beQ(this.dWG);
                aVar.gpx();
                AppMethodBeat.o(180099);
                return;
            case 5:
                if (!Util.isNullOrNil(this.emojiMD5)) {
                    aVar.beS(this.emojiMD5);
                    AppMethodBeat.o(180099);
                    return;
                } else if (!Util.isNullOrNil(this.dTX.field_imgPath)) {
                    aVar.beS(this.dTX.field_imgPath);
                    AppMethodBeat.o(180099);
                    return;
                } else {
                    aVar.beS(this.imagePath);
                    AppMethodBeat.o(180099);
                    return;
                }
            case 8:
                bg.aVF();
                ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(this.dWG);
                this.Qzq = aEK.dkU;
                this.Qzr = aEK.nickname;
                this.Qzs = Boolean.valueOf(com.tencent.mm.model.ab.rR(aEK.IOs));
                a(aVar, this.Qzq);
                AppMethodBeat.o(180099);
                return;
            case 9:
                aVar.beQ(gYj());
                AppMethodBeat.o(180099);
                return;
            case 11:
                aVar.l(gYk(), 2);
                AppMethodBeat.o(180099);
                return;
            case 12:
                rc ki = l.ki(getContext());
                if (ki.dXF.dXK != null) {
                    i2 = ki.dXF.dXK.size();
                } else {
                    i2 = 0;
                }
                aVar.beQ(new StringBuffer(getResources().getString(R.string.ws)).append(getContext().getString(R.string.g5e, new Object[]{Integer.valueOf(i2)})).toString());
                AppMethodBeat.o(180099);
                return;
            case 13:
                aVar.beQ(new StringBuffer(getResources().getString(R.string.wt)).append(Util.nullAs(l.ki(getContext()).dXG.dXM.title, "")).toString());
                AppMethodBeat.o(180099);
                return;
            case 18:
                f fVar = (f) k.b.HD(Util.processXml(this.dWG)).as(f.class);
                if (fVar != null) {
                    aVar.gl(a(fVar));
                }
                aVar.gpz();
                AppMethodBeat.o(180099);
                return;
            case 19:
                com.tencent.mm.plugin.finder.api.d dVar = (com.tencent.mm.plugin.finder.api.d) k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.finder.api.d.class);
                if (dVar != null) {
                    aVar.beQ(getString(R.string.vh) + dVar.title);
                    AppMethodBeat.o(180099);
                    return;
                }
                break;
            case 20:
                e eVar = (e) k.b.HD(Util.processXml(this.dWG)).as(e.class);
                if (eVar != null) {
                    aVar.beQ(getString(R.string.vj) + eVar.nickname);
                    AppMethodBeat.o(180099);
                    return;
                }
                break;
            case 21:
            case 25:
                com.tencent.mm.plugin.i.a.h hVar = (com.tencent.mm.plugin.i.a.h) k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.h.class);
                if (!(hVar == null || hVar.jld == null)) {
                    String string2 = getString(R.string.vg);
                    if (hVar.jld.tvC == 1) {
                        str4 = string2 + getString(R.string.dag, new Object[]{hVar.jld.dST});
                    } else if (hVar.jld.tvC == 4) {
                        str4 = string2 + hVar.jld.desc;
                    } else {
                        str4 = string2 + hVar.jld.dST;
                    }
                    aVar.beQ(str4);
                    AppMethodBeat.o(180099);
                    return;
                }
            case 22:
                com.tencent.mm.plugin.i.a.d dVar2 = (com.tencent.mm.plugin.i.a.d) k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.d.class);
                if (dVar2 != null) {
                    aVar.gl(a(dVar2));
                }
                aVar.gpz();
                AppMethodBeat.o(180099);
                return;
            case 23:
            case 29:
                com.tencent.mm.plugin.i.a.b bVar3 = (com.tencent.mm.plugin.i.a.b) k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.b.class);
                if (bVar3 != null) {
                    aVar.gl(a(bVar3));
                }
                aVar.gpz();
                AppMethodBeat.o(180099);
                return;
            case 26:
                com.tencent.mm.plugin.i.a.i iVar = (com.tencent.mm.plugin.i.a.i) k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.i.class);
                if (iVar != null) {
                    aVar.gl(a(iVar));
                }
                aVar.gpz();
                AppMethodBeat.o(180099);
                return;
            case 27:
                com.tencent.mm.plugin.i.a.c cVar = (com.tencent.mm.plugin.i.a.c) k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.c.class);
                if (!(cVar == null || cVar.jld.LLD == null)) {
                    String string3 = getString(R.string.vg);
                    if (cVar.jld.tvC == 7) {
                        str3 = string3 + MMApplicationContext.getContext().getString(R.string.chi, cVar.jld.LLD.LAr, cVar.jld.LLD.LAq);
                    } else {
                        str3 = string3 + cVar.jld.dST;
                    }
                    aVar.beQ(str3);
                    AppMethodBeat.o(180099);
                    return;
                }
            case 28:
                com.tencent.mm.plugin.i.a.g gVar = (com.tencent.mm.plugin.i.a.g) k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.g.class);
                if (!(gVar == null || gVar.wDZ == null)) {
                    aVar.beQ(gVar.wDZ.kHV);
                    AppMethodBeat.o(180099);
                    return;
                }
        }
        AppMethodBeat.o(180099);
    }

    private void a(o.a aVar) {
        AppMethodBeat.i(39378);
        switch (this.msgType) {
            case 0:
            case 1:
            case 11:
            case 16:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass16 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(39339);
                        Log.i("MicroMsg.SelectConversationUI", "[ImageGalleryUI] showImgGallery");
                        Intent intent = new Intent(SelectConversationUI.this.getContext(), ImageGalleryUI.class);
                        intent.putExtra("img_gallery_msg_id", SelectConversationUI.this.msgId);
                        intent.putExtra("img_gallery_msg_svr_id", SelectConversationUI.this.dTX.field_msgSvrId);
                        intent.putExtra("img_gallery_talker", SelectConversationUI.this.dTX.field_talker);
                        intent.putExtra("img_gallery_chatroom_name", SelectConversationUI.this.dTX.field_talker);
                        intent.putExtra("img_preview_only", true);
                        SelectConversationUI selectConversationUI = SelectConversationUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, bl.axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        selectConversationUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.ui.base.b.kc(SelectConversationUI.this.getContext());
                        AppMethodBeat.o(39339);
                    }
                });
                AppMethodBeat.o(39378);
                return;
            case 2:
            case 10:
                final k.b HD = k.b.HD(Util.processXml(this.dWG));
                if (HD == null) {
                    AppMethodBeat.o(39378);
                    return;
                } else if ((HD.type == 5 && !m.f(this.dTX, this.PMs)) || HD.type == 69) {
                    final String str = HD.url;
                    aVar.a(new d.a.b() {
                        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass18 */

                        @Override // com.tencent.mm.ui.widget.a.d.a.b
                        public final void cXd() {
                            AppMethodBeat.i(39340);
                            if (Util.isNullOrNil(str)) {
                                AppMethodBeat.o(39340);
                                return;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", false);
                            c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.o(39340);
                        }
                    });
                    AppMethodBeat.o(39378);
                    return;
                } else if (HD.type == 6) {
                    aVar.a(new d.a.b() {
                        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass19 */

                        @Override // com.tencent.mm.ui.widget.a.d.a.b
                        public final void cXd() {
                            AppMethodBeat.i(39341);
                            Intent intent = new Intent();
                            intent.setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                            intent.putExtra("app_msg_id", SelectConversationUI.this.msgId);
                            intent.putExtra("app_show_share", false);
                            SelectConversationUI selectConversationUI = SelectConversationUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, bl.axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            selectConversationUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(39341);
                        }
                    });
                    AppMethodBeat.o(39378);
                    return;
                } else if (HD.type == 24) {
                    aVar.a(new d.a.b() {
                        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass20 */

                        @Override // com.tencent.mm.ui.widget.a.d.a.b
                        public final void cXd() {
                            AppMethodBeat.i(39342);
                            pa paVar = new pa();
                            paVar.dVb.context = SelectConversationUI.this.getContext();
                            paVar.dVb.msgId = SelectConversationUI.this.msgId;
                            paVar.dVb.dVc = HD.ixl;
                            paVar.dVb.dUo = false;
                            paVar.dVb.scene = 7;
                            EventCenter.instance.publish(paVar);
                            AppMethodBeat.o(39342);
                        }
                    });
                    AppMethodBeat.o(39378);
                    return;
                } else if (HD.type == 19) {
                    aVar.a(new d.a.b() {
                        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass21 */

                        @Override // com.tencent.mm.ui.widget.a.d.a.b
                        public final void cXd() {
                            AppMethodBeat.i(39343);
                            Intent intent = new Intent();
                            intent.putExtra("message_id", SelectConversationUI.this.msgId);
                            intent.putExtra("record_xml", HD.ixl);
                            intent.putExtra("record_show_share", false);
                            c.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", intent);
                            AppMethodBeat.o(39343);
                        }
                    });
                    AppMethodBeat.o(39378);
                    return;
                } else if (HD.type == 3 || HD.type == 76) {
                    aVar.a(new d.a.b() {
                        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass22 */

                        @Override // com.tencent.mm.ui.widget.a.d.a.b
                        public final void cXd() {
                            AppMethodBeat.i(180091);
                            String R = com.tencent.mm.pluginsdk.model.app.q.R(HD.url, "message");
                            String R2 = com.tencent.mm.pluginsdk.model.app.q.R(HD.iwH, "message");
                            if (!NetStatusUtil.isMobile(SelectConversationUI.this.getContext()) ? R == null || R.length() <= 0 : R2 != null && R2.length() > 0) {
                                R = R2;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", R);
                            intent.putExtra("showShare", false);
                            c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.o(180091);
                        }
                    });
                    AppMethodBeat.o(39378);
                    return;
                } else if (HD.type == 4) {
                    aVar.a(new d.a.b() {
                        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass24 */

                        @Override // com.tencent.mm.ui.widget.a.d.a.b
                        public final void cXd() {
                            AppMethodBeat.i(180092);
                            AppMethodBeat.o(180092);
                        }
                    });
                    AppMethodBeat.o(39378);
                    return;
                } else if (HD.type == 53 || HD.type == 57) {
                    aVar.a(new d.a.b() {
                        /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass25 */

                        @Override // com.tencent.mm.ui.widget.a.d.a.b
                        public final void cXd() {
                            AppMethodBeat.i(180093);
                            Intent intent = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
                            intent.putExtra("Retr_Msg_content", HD.title);
                            SelectConversationUI selectConversationUI = SelectConversationUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, bl.axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            selectConversationUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.ui.base.b.kc(SelectConversationUI.this.getContext());
                            AppMethodBeat.o(180093);
                        }
                    });
                    AppMethodBeat.o(39378);
                    return;
                }
                break;
            case 3:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass27 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(234494);
                        Intent intent = new Intent();
                        intent.setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent.putExtra("app_msg_id", SelectConversationUI.this.msgId);
                        intent.putExtra("app_show_share", false);
                        SelectConversationUI selectConversationUI = SelectConversationUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, bl.axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        selectConversationUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(234494);
                    }
                });
                break;
            case 4:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass15 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(39338);
                        Intent intent = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
                        intent.putExtra("Retr_Msg_content", SelectConversationUI.this.dWG);
                        SelectConversationUI selectConversationUI = SelectConversationUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, bl.axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        selectConversationUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(selectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.ui.base.b.kc(SelectConversationUI.this.getContext());
                        AppMethodBeat.o(39338);
                    }
                });
                AppMethodBeat.o(39378);
                return;
            case 9:
                bg.aVF();
                if (com.tencent.mm.model.c.aSQ() == null) {
                    AppMethodBeat.o(39378);
                    return;
                }
                bg.aVF();
                final ca.b aEL = com.tencent.mm.model.c.aSQ().aEL(this.dWG);
                final String str2 = aEL.label;
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass17 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(180090);
                        Intent intent = new Intent();
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", aEL.yFu);
                        intent.putExtra("kwebmap_lng", aEL.yFv);
                        intent.putExtra("Kwebmap_locaion", str2);
                        intent.putExtra("kShowshare", false);
                        c.b(SelectConversationUI.this.getContext(), FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
                        AppMethodBeat.o(180090);
                    }
                });
                AppMethodBeat.o(39378);
                return;
            case 12:
                l.ki(getContext());
                AppMethodBeat.o(39378);
                return;
            case 13:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass26 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(234493);
                        rc ki = l.ki(SelectConversationUI.this.getContext());
                        k.b HD = k.b.HD(Util.processXml(com.tencent.mm.plugin.record.b.p.a(ki.dXG.dXM.title, ki.dXG.dXM.desc, ki.dXG.dWX.dFZ.dGb, ki.dXF.from, SelectConversationUI.this.msgId)));
                        if (HD == null) {
                            AppMethodBeat.o(234493);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("message_id", SelectConversationUI.this.msgId);
                        intent.putExtra("record_xml", HD.ixl);
                        intent.putExtra("record_show_share", false);
                        c.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", intent);
                        AppMethodBeat.o(234493);
                    }
                });
                AppMethodBeat.o(39378);
                return;
        }
        AppMethodBeat.o(39378);
    }

    private String gYj() {
        AppMethodBeat.i(39380);
        bg.aVF();
        ca.b aEL = com.tencent.mm.model.c.aSQ().aEL(this.dWG);
        String str = "";
        if (aEL != null) {
            str = aEL.label;
        }
        String str2 = getContext().getString(R.string.we) + str;
        AppMethodBeat.o(39380);
        return str2;
    }

    private Bitmap gYk() {
        AppMethodBeat.i(39381);
        com.tencent.mm.modelvideo.o.bhj();
        String Qx = t.Qx(this.dTX.field_imgPath);
        if (Qx == null) {
            String str = this.imagePath;
            if (!com.tencent.mm.plugin.a.c.Sx(this.imagePath)) {
                Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(str);
                AppMethodBeat.o(39381);
                return PF;
            }
            Bitmap bitmapNative = BitmapUtil.getBitmapNative(str);
            AppMethodBeat.o(39381);
            return bitmapNative;
        }
        Bitmap bitmapNative2 = BitmapUtil.getBitmapNative(Qx);
        AppMethodBeat.o(39381);
        return bitmapNative2;
    }

    private Bitmap gYl() {
        AppMethodBeat.i(39382);
        if (this.dTX == null) {
            AppMethodBeat.o(39382);
            return null;
        }
        String str = this.dTX.field_imgPath;
        Bitmap OB = com.tencent.mm.av.q.bcR().OB(str);
        if (OB != null) {
            try {
                int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
                if (orientationInDegree < 0) {
                    orientationInDegree = 0;
                }
                OB = BitmapUtil.rotate(OB, (float) orientationInDegree);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.SelectConversationUI", th, "unexpected exception.", new Object[0]);
            }
        }
        AppMethodBeat.o(39382);
        return OB;
    }

    private static Bitmap bof(String str) {
        AppMethodBeat.i(39383);
        Bitmap OB = com.tencent.mm.av.q.bcR().OB(str);
        if (OB != null) {
            try {
                int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
                if (orientationInDegree < 0) {
                    orientationInDegree = 0;
                }
                OB = BitmapUtil.rotate(OB, (float) orientationInDegree);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.SelectConversationUI", th, "unexpected exception.", new Object[0]);
            }
        }
        AppMethodBeat.o(39383);
        return OB;
    }

    public static Bitmap a(Context context, Bitmap bitmap, ImageView imageView, int i2, int i3) {
        AppMethodBeat.i(39384);
        Bitmap bitmap2 = null;
        float f2 = ((float) i3) / ((float) i2);
        int i4 = 0;
        int i5 = 0;
        int aH = at.aH(context, R.dimen.bg);
        int aH2 = at.aH(context, R.dimen.bf);
        int i6 = 0;
        int i7 = 0;
        if (f2 > 0.0f && ((double) f2) < 0.5d) {
            i5 = (int) (((float) aH) / f2);
            i7 = aH;
            i6 = aH2;
            i4 = aH;
        } else if (((double) f2) >= 0.5d && f2 < 1.0f) {
            int i8 = (int) (((float) aH2) * f2);
            i7 = i8;
            i6 = aH2;
            i5 = aH2;
            i4 = i8;
        } else if (f2 >= 1.0f && f2 < 2.0f) {
            int i9 = (int) (((float) aH2) / f2);
            i7 = aH2;
            i6 = i9;
            i5 = i9;
            i4 = aH2;
        } else if (f2 >= 2.0f) {
            i4 = (int) (((float) aH) * f2);
            i7 = aH2;
            i6 = aH;
            i5 = aH;
        }
        if (i4 > 0 && i5 > 0 && bitmap != null) {
            bitmap2 = Bitmap.createScaledBitmap(bitmap, i5, i4, true);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(i6, i7));
        }
        AppMethodBeat.o(39384);
        return bitmap2;
    }

    private static String t(k.b bVar) {
        AppMethodBeat.i(39385);
        rc rcVar = new rc();
        rcVar.dXF.type = 0;
        rcVar.dXF.dXH = bVar.ixl;
        EventCenter.instance.publish(rcVar);
        com.tencent.mm.protocal.b.a.c cVar = rcVar.dXG.dXP;
        String str = null;
        if (!(cVar == null || bVar == null)) {
            str = Util.nullAs(cVar.desc, bVar.description);
        }
        if (!Util.isNullOrNil(str)) {
            str = str.replaceAll("\n", " ");
        }
        AppMethodBeat.o(39385);
        return str;
    }

    private View a(com.tencent.mm.plugin.i.a.d dVar) {
        AppMethodBeat.i(234501);
        View inflate = View.inflate(this, R.layout.bry, null);
        TextView textView = (TextView) inflate.findViewById(R.id.ipm);
        FinderFeedAlbumView finderFeedAlbumView = (FinderFeedAlbumView) inflate.findViewById(R.id.cef);
        finderFeedAlbumView.setItemViewWidth(com.tencent.mm.cb.a.fromDPToPix(inflate.getContext(), 70));
        LinkedList<String> linkedList = dVar.jle.LLt;
        List<String> subList = linkedList.subList(0, Math.min(4, linkedList.size()));
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < subList.size(); i2++) {
            cjl cjl = new cjl();
            cjl.url = dVar.jle.LLt.get(i2);
            cjl.url_token = dVar.jle.LLu.get(i2);
            cjl.thumb_url_token = cjl.url_token;
            cjl.thumbUrl = cjl.url;
            linkedList2.add(cjl);
        }
        finderFeedAlbumView.setAdapter(new com.tencent.mm.plugin.finder.view.adapter.b(linkedList2, false));
        textView.setText(dVar.jle.title);
        AppMethodBeat.o(234501);
        return inflate;
    }

    private View a(f fVar) {
        AppMethodBeat.i(163387);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        aVar.hZV = true;
        com.tencent.mm.loader.c.e aJT = aVar.aJT();
        View inflate = View.inflate(this, R.layout.brz, null);
        View findViewById = inflate.findViewById(R.id.clo);
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e.aJs().a(Util.nullAsNil(fVar.jlg.uNR), (ImageView) findViewById.findViewById(R.id.cka), aJT);
        TextView textView = (TextView) findViewById.findViewById(R.id.d0q);
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, fVar.jlg.nickname));
        ao.a(textView.getPaint(), 0.8f);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.d3w);
        ImageView imageView2 = (ImageView) findViewById.findViewById(R.id.d02);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.cl2);
        if (fVar.jlg.vXJ == 1) {
            imageView.setVisibility(8);
            TextView textView3 = (TextView) findViewById.findViewById(R.id.d3v);
            textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, fVar.jlg.desc));
            textView3.setVisibility(0);
        } else {
            if (fVar.jlg.mediaList.size() > 0) {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadImage(fVar.jlg.mediaList.get(0).thumbUrl, imageView);
            }
            if (!Util.isNullOrNil(fVar.jlg.desc)) {
                textView2.setVisibility(0);
                textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, fVar.jlg.desc));
                if (fVar.jlg.vXJ != 4 || fVar.jlg.vXJ == 6) {
                    imageView2.setImageResource(R.drawable.a4h);
                } else if (fVar.jlg.vXJ == 2 && fVar.jlg.mediaList.size() > 1) {
                    imageView2.setImageResource(R.drawable.a2n);
                }
                imageView2.setVisibility(8);
                findViewById.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                AppMethodBeat.o(163387);
                return inflate;
            }
        }
        textView2.setVisibility(8);
        if (fVar.jlg.vXJ != 4) {
        }
        imageView2.setImageResource(R.drawable.a4h);
        imageView2.setVisibility(8);
        findViewById.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        AppMethodBeat.o(163387);
        return inflate;
    }

    private static boolean bnh(String str) {
        boolean z = false;
        AppMethodBeat.i(234502);
        String d2 = com.tencent.mm.av.q.bcR().d(str, false, true);
        if (!com.tencent.mm.vfs.s.YS(d2)) {
            AppMethodBeat.o(234502);
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapUtil.decodeFile(d2, options);
            if (options.outWidth * options.outHeight > 1048576) {
                Log.i("MicroMsg.SelectConversationUI", "Bitmap to big:%d/%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                z = true;
            }
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            AppMethodBeat.o(234502);
        }
        return z;
    }

    private View a(String str, k.b bVar, com.tencent.mm.pluginsdk.ui.tools.b bVar2) {
        AppMethodBeat.i(234503);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        aVar.hZV = true;
        aVar.aJT();
        View inflate = View.inflate(this, R.layout.bs6, null);
        ((RoundCornerRelativeLayout) inflate.findViewById(R.id.h9d)).setRadius((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4));
        final View findViewById = inflate.findViewById(R.id.a_q);
        View findViewById2 = inflate.findViewById(R.id.fpx);
        if (ao.isDarkMode()) {
            findViewById2.setBackgroundResource(R.drawable.avn);
        } else {
            findViewById2.setBackgroundResource(R.drawable.avo);
        }
        MMRoundCornerImageView mMRoundCornerImageView = (MMRoundCornerImageView) findViewById2.findViewById(R.id.axd);
        TextView textView = (TextView) findViewById2.findViewById(R.id.axh);
        TextView textView2 = (TextView) findViewById2.findViewById(R.id.axi);
        TextView textView3 = (TextView) findViewById2.findViewById(R.id.axf);
        mMRoundCornerImageView.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.drawable.cvc));
        if (ao.isDarkMode()) {
            mMRoundCornerImageView.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.drawable.cvb));
        }
        textView2.setText(bVar.getTitle());
        if (!Util.isNullOrNil(bVar.getDescription())) {
            textView.setText(bVar.getDescription());
            textView.setVisibility(0);
        } else {
            textView.setText("");
            textView.setVisibility(8);
        }
        String str2 = bVar2.Ktp;
        String str3 = bVar2.Ktq;
        if (!Util.isNullOrNil(str3)) {
            ((ViewGroup.MarginLayoutParams) textView2.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
            ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
            findViewById2.findViewById(R.id.g8b).setVisibility(0);
            textView3.setText(str3 + getContext().getString(R.string.f8v));
            textView3.setVisibility(0);
        } else {
            textView3.setText("");
            textView3.setVisibility(8);
        }
        final boolean[] zArr = {false};
        if (!Util.isNullOrNil(str2)) {
            c.a aVar2 = new c.a();
            aVar2.fullPath = com.tencent.mm.plugin.music.h.b.aIf(str2);
            aVar2.jbf = true;
            aVar2.iaT = true;
            aVar2.jbd = true;
            aVar2.jbx = (float) com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 2);
            com.tencent.mm.av.q.bcV().a(str2, mMRoundCornerImageView, aVar2.bdv(), new com.tencent.mm.av.a.c.h() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass28 */

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view) {
                }

                @Override // com.tencent.mm.av.a.c.h
                public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                    return null;
                }

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                    AppMethodBeat.i(234495);
                    if (bVar.bitmap == null || bVar.bitmap.isRecycled()) {
                        zArr[0] = true;
                        AppMethodBeat.o(234495);
                        return;
                    }
                    String messageDigest = com.tencent.xweb.util.d.getMessageDigest(str.getBytes());
                    com.tencent.mm.plugin.comm.b bVar2 = com.tencent.mm.plugin.comm.b.qCp;
                    com.tencent.mm.plugin.comm.b.a(SelectConversationUI.this.getContext(), findViewById, bVar.bitmap, messageDigest);
                    AppMethodBeat.o(234495);
                }
            });
        } else {
            if (!bVar.aSy()) {
                bg.aVF();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    Bitmap bitmap = null;
                    if (!bnh(str)) {
                        bitmap = com.tencent.mm.av.q.bcR().b(str, com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()), false);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        zArr[0] = true;
                    } else {
                        mMRoundCornerImageView.setImageBitmap(bitmap);
                        String messageDigest = com.tencent.xweb.util.d.getMessageDigest(str.getBytes());
                        com.tencent.mm.plugin.comm.b bVar3 = com.tencent.mm.plugin.comm.b.qCp;
                        com.tencent.mm.plugin.comm.b.a(getContext(), findViewById, bitmap, messageDigest);
                    }
                }
            }
            mMRoundCornerImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bjm));
        }
        findViewById2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(234503);
        return inflate;
    }

    private View a(com.tencent.mm.plugin.i.a.i iVar) {
        AppMethodBeat.i(234504);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        aVar.hZV = true;
        com.tencent.mm.loader.c.e aJT = aVar.aJT();
        View inflate = View.inflate(this, R.layout.brz, null);
        View findViewById = inflate.findViewById(R.id.clo);
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e.aJs().a(Util.nullAsNil(iVar.jlh.uNR), (ImageView) findViewById.findViewById(R.id.cka), aJT);
        TextView textView = (TextView) findViewById.findViewById(R.id.d0q);
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, iVar.jlh.nickname));
        ao.a(textView.getPaint(), 0.8f);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.d3w);
        ImageView imageView2 = (ImageView) findViewById.findViewById(R.id.d02);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.cl2);
        if (iVar.jlh.mediaList.size() > 0) {
            if (!Util.isNullOrNil(iVar.jlh.mediaList.get(0).coverUrl)) {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadImage(iVar.jlh.mediaList.get(0).coverUrl, imageView);
            } else {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadImage(iVar.jlh.mediaList.get(0).thumbUrl, imageView);
            }
        }
        if (!Util.isNullOrNil(iVar.jlh.desc)) {
            textView2.setVisibility(0);
            textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, iVar.jlh.desc));
        } else {
            textView2.setVisibility(8);
        }
        imageView2.setImageResource(R.drawable.a4h);
        imageView2.setVisibility(8);
        findViewById.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        AppMethodBeat.o(234504);
        return inflate;
    }

    private View a(com.tencent.mm.plugin.i.a.b bVar) {
        AppMethodBeat.i(234505);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        aVar.hZV = true;
        com.tencent.mm.loader.c.e aJT = aVar.aJT();
        View inflate = View.inflate(this, R.layout.bs0, null);
        View findViewById = inflate.findViewById(R.id.clo);
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e.aJs().a(Util.nullAsNil(bVar.wDV.headUrl), (ImageView) findViewById.findViewById(R.id.cka), aJT);
        TextView textView = (TextView) findViewById.findViewById(R.id.d0q);
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, bVar.wDV.nickName));
        ao.a(textView.getPaint(), 0.8f);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.d3w);
        findViewById.findViewById(R.id.d02);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.cl2);
        if (TextUtils.isEmpty(bVar.wDV.desc)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(bVar.wDV.desc);
        }
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadImage(Util.nullAs(bVar.wDV.coverUrl, ""), imageView);
        findViewById.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        AppMethodBeat.o(234505);
        return inflate;
    }

    private void gYm() {
        AppMethodBeat.i(39386);
        Log.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 14);
        intent.putExtra("titile", getString(R.string.g4));
        intent.putExtra("list_attr", u.PWY);
        intent.putExtra("already_select_contact", Util.listToString(this.Qzv, ","));
        intent.putExtra("max_limit_num", 9);
        intent.putExtra("Forbid_SelectChatRoom", this.PYG && as.bjp(this.Qzq));
        getContext().startActivityForResult(intent, 5);
        AppMethodBeat.o(39386);
    }

    private void gYn() {
        boolean z = true;
        AppMethodBeat.i(39387);
        Log.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", u.PWV);
        intent.putExtra("list_type", 3);
        intent.putExtra("be_send_card_name", this.Qzq);
        intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", getString(R.string.g4));
        if (!this.PYG || !as.bjp(this.Qzq)) {
            z = false;
        }
        intent.putExtra("Forbid_SelectChatRoom", z);
        getContext().startActivityForResult(intent, 3);
        AppMethodBeat.o(39387);
    }

    private void gYo() {
        AppMethodBeat.i(39388);
        Log.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 5);
        intent.putExtra("titile", getString(R.string.g4));
        if (((this.fromScene == 4 || this.fromScene == 9) && getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || this.fromScene == 10) {
            intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
            intent.putExtra("list_attr", u.Q(32, 16, 1, 2, 4, 16384));
        } else if (this.Qzp && !this.Qzs.booleanValue()) {
            intent.putExtra("list_attr", u.Q(16, 1, 2, 4, 16384));
            intent.putExtra("without_openim", true);
            intent.putExtra("KBlockOpenImFav", true);
        } else if (this.Vmh) {
            intent.putExtra("list_attr", u.Q(u.PWR, 16384, 64, 4096));
            intent.putExtra("without_openim", true);
            intent.putExtra("KBlockOpenImFav", true);
        } else {
            intent.putExtra("list_attr", u.PWX);
        }
        getContext().startActivityForResult(intent, 1);
        AppMethodBeat.o(39388);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(39389);
        String stringExtra = getIntent().getStringExtra("Select_Conv_ui_title");
        if (stringExtra == null || stringExtra.length() <= 0) {
            String string = getString(R.string.gi6);
            AppMethodBeat.o(39389);
            return string;
        }
        AppMethodBeat.o(39389);
        return stringExtra;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        if (!this.Qzt || !this.Qzu) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public final void T(int i2, String str) {
        AppMethodBeat.i(39391);
        if (i2 == 1) {
            this.Qzv.remove(str);
            gUP().notifyDataSetChanged();
            ani();
        }
        AppMethodBeat.o(39391);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39392);
        super.onDestroy();
        removeAllOptionMenu();
        AppMethodBeat.o(39392);
    }

    private void ani() {
        AppMethodBeat.i(39393);
        if (!this.Qzt) {
            AppMethodBeat.o(39393);
        } else if (this.Qzv != null && this.Qzv.size() > 0) {
            updateOptionMenuText(1, gYi() + "(" + this.Qzv.size() + ")");
            updateOptionMenuListener(1, this.QzG, null);
            enableOptionMenu(1, true);
            AppMethodBeat.o(39393);
        } else if (!this.Qzu) {
            updateOptionMenuText(1, getString(R.string.wu));
            updateOptionMenuListener(1, this.QzF, null);
            enableOptionMenu(1, true);
            if (this.zoy != null) {
                this.zoy.setVisibility(8);
            }
            gUR();
            AppMethodBeat.o(39393);
        } else {
            updateOptionMenuText(1, getString(R.string.z3));
            updateOptionMenuListener(1, this.QzF, null);
            enableOptionMenu(1, true);
            if (this.zoy != null) {
                this.zoy.setVisibility(0);
            }
            gUS();
            AppMethodBeat.o(39393);
        }
    }

    private boolean CO(boolean z) {
        AppMethodBeat.i(39394);
        if (!z ? this.Qzv.size() > 9 : this.Qzv.size() >= 9) {
            com.tencent.mm.ui.base.h.d(getContext(), getString(R.string.ghx, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9))}), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass33 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(39394);
            return true;
        }
        AppMethodBeat.o(39394);
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        AppMethodBeat.i(39395);
        int[] intArrayExtra = getIntent().getIntArrayExtra("search_range");
        if (this.fromScene == 4 || this.fromScene == 10) {
            int[] iArr = {131072};
            AppMethodBeat.o(39395);
            return iArr;
        } else if (intArrayExtra != null) {
            AppMethodBeat.o(39395);
            return intArrayExtra;
        } else {
            int[] egI = super.egI();
            AppMethodBeat.o(39395);
            return egI;
        }
    }

    private void s(int i2, Intent intent) {
        AppMethodBeat.i(39396);
        if (this.msgType == 5) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("emoji_thumb_path", this.emojiMD5);
            intent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
        }
        super.setResult(i2, intent);
        AppMethodBeat.o(39396);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(39390);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(39390);
            return false;
        }
        boolean contains = this.Qzv.contains(aVar.contact.field_username);
        AppMethodBeat.o(39390);
        return contains;
    }

    static /* synthetic */ void a(SelectConversationUI selectConversationUI, String str, int i2) {
        k.b HD;
        int i3;
        AppMethodBeat.i(185053);
        if ((selectConversationUI.msgType == 10 || selectConversationUI.msgType == 2) && (HD = k.b.HD(Util.processXml(selectConversationUI.dWG))) != null && (HD.izk == 2 || HD.izk == 3 || HD.type == 36 || HD.type == 48)) {
            com.tencent.mm.plugin.messenger.foundation.a.t tVar = (com.tencent.mm.plugin.messenger.foundation.a.t) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.t.class);
            String nullAs = Util.nullAs(HD.izi, "");
            String nullAs2 = Util.nullAs(HD.eah, "");
            if (selectConversationUI.QzD) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            tVar.b(str, nullAs, nullAs2, i3, selectConversationUI.QzC, i2);
        }
        AppMethodBeat.o(185053);
    }

    static /* synthetic */ void a(SelectConversationUI selectConversationUI, final Intent intent) {
        String stringBuffer;
        AppMethodBeat.i(185058);
        if (u.hasAttr(selectConversationUI.jVX, 256)) {
            selectConversationUI.s(-1, intent);
            selectConversationUI.finish();
            AppMethodBeat.o(185058);
            return;
        }
        o.a aVar = new o.a(selectConversationUI.getContext());
        aVar.ea(selectConversationUI.Qzv);
        if (selectConversationUI.PYG) {
            Iterator<String> it = selectConversationUI.Qzv.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (selectConversationUI.bob(it.next())) {
                        break;
                    }
                } else {
                    selectConversationUI.a(aVar, selectConversationUI.Qzq);
                    a(intent, selectConversationUI.Qzq, selectConversationUI.Qzv);
                    break;
                }
            }
            o.a p = aVar.p(Boolean.TRUE);
            p.Kfh = selectConversationUI.gYi();
            p.a(new y.a() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass30 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                public final void a(boolean z, String str, int i2) {
                    AppMethodBeat.i(234497);
                    SelectConversationUI.this.hideVKB();
                    if (z) {
                        intent.putExtra("custom_send_text", str);
                        SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                        SelectConversationUI.this.finish();
                    }
                    AppMethodBeat.o(234497);
                }
            }).kdo.show();
        } else if (selectConversationUI.Qzg) {
            if (!selectConversationUI.getIntent().hasExtra("appbrand_params") || !selectConversationUI.a(intent, aVar, (String) null)) {
                if (selectConversationUI.dFW != -1) {
                    gx gxVar = new gx();
                    gxVar.dLa.dFW = selectConversationUI.dFW;
                    gxVar.dLa.dLd = aVar;
                    gxVar.dLa.dDg = selectConversationUI.getContext();
                    EventCenter.instance.publish(gxVar);
                } else if (selectConversationUI.msgType == 17 && selectConversationUI.Qzn != 0) {
                    aVar.beQ(new StringBuffer(selectConversationUI.getResources().getString(R.string.ws)).append(selectConversationUI.getContext().getString(R.string.g5e, new Object[]{Integer.valueOf(selectConversationUI.Qzn)})).toString());
                }
                o.a p2 = aVar.p(Boolean.TRUE);
                p2.Kfh = selectConversationUI.gYi();
                p2.a(new y.a() {
                    /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass30 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                    public final void a(boolean z, String str, int i2) {
                        AppMethodBeat.i(234497);
                        SelectConversationUI.this.hideVKB();
                        if (z) {
                            intent.putExtra("custom_send_text", str);
                            SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                            SelectConversationUI.this.finish();
                        }
                        AppMethodBeat.o(234497);
                    }
                }).kdo.show();
            }
        } else if (selectConversationUI.Qzh && !selectConversationUI.tkE) {
            HashMap hashMap = (HashMap) selectConversationUI.getIntent().getSerializableExtra("webview_params");
            aVar.beR((String) hashMap.get("img_url")).gpy();
            String str = (String) hashMap.get("title");
            final String str2 = (String) hashMap.get("url");
            if (!selectConversationUI.Qzl) {
                stringBuffer = new StringBuffer(selectConversationUI.getResources().getString(R.string.zp)).append(str).toString();
            } else {
                stringBuffer = new StringBuffer(selectConversationUI.getResources().getString(R.string.vt)).append((String) hashMap.get("nickname")).toString();
            }
            aVar.beQ(stringBuffer);
            aVar.a(new d.a.b() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass29 */

                @Override // com.tencent.mm.ui.widget.a.d.a.b
                public final void cXd() {
                    AppMethodBeat.i(234496);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(234496);
                }
            });
            o.a p22 = aVar.p(Boolean.TRUE);
            p22.Kfh = selectConversationUI.gYi();
            p22.a(new y.a() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass30 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                public final void a(boolean z, String str, int i2) {
                    AppMethodBeat.i(234497);
                    SelectConversationUI.this.hideVKB();
                    if (z) {
                        intent.putExtra("custom_send_text", str);
                        SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                        SelectConversationUI.this.finish();
                    }
                    AppMethodBeat.o(234497);
                }
            }).kdo.show();
        } else if (!selectConversationUI.Qzi || !selectConversationUI.a(intent, aVar, (String) null)) {
            selectConversationUI.b(aVar, (String) null);
            selectConversationUI.a(aVar);
            o.a p222 = aVar.p(Boolean.TRUE);
            p222.Kfh = selectConversationUI.gYi();
            p222.a(new y.a() {
                /* class com.tencent.mm.ui.transmit.SelectConversationUI.AnonymousClass30 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                public final void a(boolean z, String str, int i2) {
                    AppMethodBeat.i(234497);
                    SelectConversationUI.this.hideVKB();
                    if (z) {
                        intent.putExtra("custom_send_text", str);
                        SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                        SelectConversationUI.this.finish();
                    }
                    AppMethodBeat.o(234497);
                }
            }).kdo.show();
        }
        AppMethodBeat.o(185058);
    }
}
