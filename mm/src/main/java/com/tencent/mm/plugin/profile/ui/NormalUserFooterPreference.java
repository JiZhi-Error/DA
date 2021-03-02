package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.network.ag;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class NormalUserFooterPreference extends Preference implements MStorage.IOnStorageChange {
    private boolean BcL = false;
    private boolean Bdx;
    private String BfH = "";
    private boolean BfM = false;
    private int Bfb = 0;
    private int Bft;
    private long Bge = 0;
    private boolean Bhe;
    private boolean Bhf;
    private boolean Bhg = false;
    private boolean Bhh = false;
    private a Bhi;
    private View Bhj;
    private Button Bhk;
    private Button Bhl;
    private Button Bhm;
    private View Bhn;
    private Button Bho;
    private TextView Bhp;
    private View Bhq;
    private Button Bhr;
    private Button Bhs;
    private Button Bht;
    private Button Bhu;
    private Button Bhv;
    private Button Bhw;
    private TextView Bhx;
    private boolean Bhy = false;
    public boolean Bhz = false;
    private as contact;
    public ProgressDialog gtM = null;
    private MMActivity gte;
    private Button han;
    protected MStorageEvent<e, String> iKx = new MStorageEvent<e, String>() {
        /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.os.Looper] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void add(e eVar, Looper looper) {
            AppMethodBeat.i(27290);
            e eVar2 = eVar;
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            super.add(eVar2, looper);
            AppMethodBeat.o(27290);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(e eVar, String str) {
            AppMethodBeat.i(27289);
            String str2 = str;
            if (str2.equals("show_btn")) {
                as unused = NormalUserFooterPreference.this.contact;
                AppMethodBeat.o(27289);
                return;
            }
            if (str2.equals("hide_btn")) {
                as unused2 = NormalUserFooterPreference.this.contact;
            }
            AppMethodBeat.o(27289);
        }
    };
    private int kgm;
    private String pfa = null;
    private boolean rFe;
    private String wZz = "";

    public interface e {
    }

    public NormalUserFooterPreference(Context context) {
        super(context);
        AppMethodBeat.i(27352);
        this.gte = (MMActivity) context;
        init();
        AppMethodBeat.o(27352);
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27353);
        this.gte = (MMActivity) context;
        init();
        AppMethodBeat.o(27353);
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27354);
        this.gte = (MMActivity) context;
        init();
        AppMethodBeat.o(27354);
    }

    private void init() {
        this.rFe = false;
        this.Bhi = null;
    }

    private void initView() {
        AppMethodBeat.i(27355);
        if (!this.rFe || this.contact == null) {
            Log.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.rFe + " contact = " + this.contact);
            if (this.Bhi != null) {
                try {
                    this.Bhi.eEO();
                    AppMethodBeat.o(27355);
                    return;
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.o(27355);
            return;
        }
        if (this.Bhi != null) {
            this.Bhi.aSs();
        }
        eEJ();
        AppMethodBeat.o(27355);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27356);
        Log.d("MicroMsg.NormalUserFooterPreference", "on bindView " + view.toString());
        this.Bhj = view.findViewById(R.id.bb_);
        this.Bhk = (Button) view.findViewById(R.id.bc4);
        this.Bhl = (Button) view.findViewById(R.id.bal);
        this.Bho = (Button) view.findViewById(R.id.bc6);
        this.Bhp = (TextView) view.findViewById(R.id.bc_);
        this.Bhn = view.findViewById(R.id.bc7);
        this.Bhm = (Button) view.findViewById(R.id.bc5);
        this.Bht = (Button) view.findViewById(R.id.ba_);
        this.Bhq = view.findViewById(R.id.bbf);
        this.Bhr = (Button) view.findViewById(R.id.bbe);
        this.Bhs = (Button) view.findViewById(R.id.bbg);
        this.han = (Button) view.findViewById(R.id.bbh);
        this.Bhw = (Button) view.findViewById(R.id.bb6);
        this.Bhu = (Button) view.findViewById(R.id.bc8);
        this.Bhv = (Button) view.findViewById(R.id.bai);
        this.Bhx = (TextView) view.findViewById(R.id.bb7);
        this.rFe = true;
        initView();
        super.onBindView(view);
        if (this.gte.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) && this.Bhk != null) {
            this.Bhk.performClick();
        }
        AppMethodBeat.o(27356);
    }

    public final boolean a(as asVar, String str, boolean z, boolean z2, boolean z3, int i2, int i3, boolean z4, boolean z5, long j2, String str2) {
        boolean z6;
        AppMethodBeat.i(27357);
        cCs();
        if (asVar != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        Assert.assertTrue(z6);
        Assert.assertTrue(Util.nullAsNil(asVar.field_username).length() > 0);
        if (as.bjz(z.aTY()).equals(asVar.field_username)) {
            AppMethodBeat.o(27357);
            return false;
        }
        this.contact = asVar;
        this.wZz = str;
        this.Bdx = z;
        this.kgm = i2;
        this.Bft = i3;
        this.Bhf = Util.nullAs(Boolean.valueOf(ab.IQ(asVar.field_username)), false);
        this.BcL = z4;
        this.Bhe = z5;
        this.Bge = j2;
        this.BfH = str2;
        this.Bhz = false;
        this.BfM = asVar.field_deleteFlag == 1;
        this.Bhy = this.gte.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.Bfb = this.gte.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.Bhg = this.gte.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
        this.Bhh = this.gte.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
        this.pfa = this.gte.getIntent().getStringExtra("lbs_ticket");
        if (!z.Im(asVar.field_username)) {
            bg.aVF();
            if (!com.tencent.mm.model.c.aSW().has(asVar.field_username)) {
                if (as.bjm(asVar.field_username)) {
                    this.Bhi = new h();
                } else if (ab.Jf(asVar.field_username)) {
                    this.Bhi = new d();
                } else if (ab.IQ(asVar.field_username)) {
                    this.Bhi = new g();
                } else if (as.bjn(asVar.field_username)) {
                    this.Bhi = new f();
                } else if (com.tencent.mm.contact.c.oR(asVar.field_type) && !as.IG(asVar.field_username)) {
                    this.Bhi = new c();
                    this.Bhz = true;
                } else if (z2) {
                    this.Bhi = new j();
                    this.Bhz = true;
                } else if (z3 || as.IG(asVar.field_username)) {
                    this.Bhi = new b();
                } else {
                    this.Bhi = new c();
                    this.Bhz = true;
                }
                initView();
                AppMethodBeat.o(27357);
                return true;
            }
        }
        this.Bhi = new c();
        this.Bhz = true;
        initView();
        AppMethodBeat.o(27357);
        return true;
    }

    public final boolean eEJ() {
        AppMethodBeat.i(27358);
        if (!this.Bhy || !com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            this.Bhw.setVisibility(8);
            AppMethodBeat.o(27358);
            return false;
        }
        this.Bhw.setVisibility(0);
        AppMethodBeat.o(27358);
        return true;
    }

    public final boolean cCs() {
        AppMethodBeat.i(27359);
        if (this.Bhi != null) {
            this.Bhi.onDetach();
        }
        this.iKx.removeAll();
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        AppMethodBeat.o(27359);
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract class a implements com.tencent.mm.ak.i, a.AbstractC2017a {
        private com.tencent.mm.ui.widget.a.e Bcp = null;
        boolean isDeleteCancel = false;

        /* access modifiers changed from: protected */
        public abstract void eEM();

        public a() {
        }

        /* access modifiers changed from: protected */
        public void aSs() {
            eEM();
            eEO();
            NormalUserFooterPreference.this.han.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27308);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", NormalUserFooterPreference.this.contact.field_username);
                    if (NormalUserFooterPreference.this.Bhf) {
                        a aVar = a.this;
                        String str = NormalUserFooterPreference.this.contact.field_username;
                        Intent intent = new Intent();
                        intent.addFlags(67108864);
                        if (NormalUserFooterPreference.this.Bdx) {
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("Chat_Mode", 1);
                            ((Activity) NormalUserFooterPreference.this.mContext).setResult(-1, intent);
                        } else {
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("Chat_Mode", 1);
                            com.tencent.mm.plugin.profile.b.jRt.d(intent, NormalUserFooterPreference.this.mContext);
                        }
                    } else {
                        a aVar2 = a.this;
                        Intent intent2 = new Intent();
                        intent2.addFlags(67108864);
                        if (NormalUserFooterPreference.this.Bdx) {
                            intent2.putExtra("Chat_User", NormalUserFooterPreference.this.contact.field_username);
                            intent2.putExtra("Chat_Mode", 1);
                            ((Activity) NormalUserFooterPreference.this.mContext).setResult(-1, intent2);
                        } else {
                            intent2.putExtra("Chat_User", NormalUserFooterPreference.this.contact.field_username);
                            intent2.putExtra("Chat_Mode", 1);
                            com.tencent.mm.plugin.profile.b.jRt.d(intent2, NormalUserFooterPreference.this.mContext);
                        }
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(NormalUserFooterPreference.this.gte.getIntent())), 4, 1, NormalUserFooterPreference.this.contact.field_username);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27308);
                }
            });
            NormalUserFooterPreference.this.Bhw.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass12 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27309);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", NormalUserFooterPreference.this.contact.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 4);
                    com.tencent.mm.br.c.b(NormalUserFooterPreference.this.gte, "sns", ".ui.SnsPermissionUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27309);
                }
            });
            NormalUserFooterPreference.this.Bhu.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass13 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27310);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a aVar = a.this;
                    zi ziVar = new zi();
                    EventCenter.instance.publish(ziVar);
                    if (!NormalUserFooterPreference.this.contact.field_username.equals(ziVar.efv.talker) && (ziVar.efv.dCH || ziVar.efv.dCI)) {
                        Toast.makeText(NormalUserFooterPreference.this.gte.getContext(), ziVar.efv.efw ? R.string.an0 : R.string.an1, 0).show();
                        Log.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
                    } else if (!com.tencent.mm.q.a.cA(NormalUserFooterPreference.this.gte) && !com.tencent.mm.q.a.cE(NormalUserFooterPreference.this.gte)) {
                        xq xqVar = new xq();
                        xqVar.edR.edT = true;
                        EventCenter.instance.publish(xqVar);
                        String str = xqVar.edS.edV;
                        if (!Util.isNullOrNil(str)) {
                            Log.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: ".concat(String.valueOf(str)));
                            com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.this.gte, NormalUserFooterPreference.this.gte.getString(R.string.hke), "", NormalUserFooterPreference.this.gte.getString(R.string.x_), NormalUserFooterPreference.this.gte.getString(R.string.sz), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(27297);
                                    xq xqVar = new xq();
                                    xqVar.edR.edU = true;
                                    EventCenter.instance.publish(xqVar);
                                    fo foVar = new fo();
                                    foVar.dIN.username = com.tencent.mm.bi.d.jpB.bgL();
                                    EventCenter.instance.publish(foVar);
                                    a.this.eEP();
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(27297);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass3 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(27298);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(27298);
                                }
                            });
                        } else {
                            aVar.eEP();
                        }
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(NormalUserFooterPreference.this.gte.getIntent())), 5, 1, NormalUserFooterPreference.this.contact.field_username);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27310);
                }
            });
            NormalUserFooterPreference.this.Bho.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass14 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27311);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a.c(a.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27311);
                }
            });
            NormalUserFooterPreference.this.Bhr.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass15 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27312);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a.c(a.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27312);
                }
            });
            NormalUserFooterPreference.this.Bhv.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass16 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27313);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a.c(a.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27313);
                }
            });
            ((com.tencent.mm.pluginsdk.h.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.h.a.class)).a(this);
        }

        /* access modifiers changed from: protected */
        public void onDetach() {
            ((com.tencent.mm.pluginsdk.h.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.h.a.class)).b(this);
        }

        @Override // com.tencent.mm.ak.i
        public void onSceneEnd(int i2, int i3, String str, q qVar) {
            Log.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " " + qVar.getType());
        }

        /* access modifiers changed from: protected */
        public final void eEN() {
            NormalUserFooterPreference.this.gte.addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(27296);
                    com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) NormalUserFooterPreference.this.gte, 1, false);
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass1.AnonymousClass1 */

                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            com.tencent.mm.plugin.account.friend.a.a aVar = null;
                            AppMethodBeat.i(27294);
                            switch (menuItem.getItemId()) {
                                case 1:
                                    NormalUserFooterPreference.this.iKx.event("hide_btn");
                                    NormalUserFooterPreference.this.iKx.doNotify();
                                    a aVar2 = a.this;
                                    NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
                                    bg.aVF();
                                    normalUserFooterPreference.contact = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.this.contact.field_username);
                                    if (!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type)) {
                                        aVar2.aKk(NormalUserFooterPreference.this.contact.field_username);
                                        AppMethodBeat.o(27294);
                                        return;
                                    }
                                    Intent intent = new Intent();
                                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.kgm);
                                    intent.putExtra("Contact_User", NormalUserFooterPreference.this.contact.field_username);
                                    intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.gte.getIntent().getStringExtra("Contact_RoomNickname"));
                                    intent.putExtra("contact_phone_number_list", NormalUserFooterPreference.this.contact.fuX);
                                    String str = "";
                                    if (!NormalUserFooterPreference.this.contact.arF()) {
                                        String stringExtra = NormalUserFooterPreference.this.gte.getIntent().getStringExtra("Contact_Mobile_MD5");
                                        String stringExtra2 = NormalUserFooterPreference.this.gte.getIntent().getStringExtra("Contact_full_Mobile_MD5");
                                        if (!Util.isNullOrNil(stringExtra) || !Util.isNullOrNil(stringExtra2)) {
                                            if ((!Util.isNullOrNil(stringExtra) || !Util.isNullOrNil(stringExtra2)) && ((aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra)) == null || Util.isNullOrNil(aVar.getMd5()))) {
                                                aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra2);
                                            }
                                        } else if (!Util.isNullOrNil(NormalUserFooterPreference.this.contact.field_username)) {
                                            aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(NormalUserFooterPreference.this.contact.field_username);
                                        }
                                        if (aVar != null && !Util.isNullOrNil(aVar.getMd5())) {
                                            str = Util.nullAsNil(aVar.bnP()).replace(" ", "");
                                        }
                                    }
                                    intent.putExtra("contact_phone_number_by_md5", str);
                                    com.tencent.mm.plugin.profile.b.jRt.l(intent, NormalUserFooterPreference.this.mContext);
                                    AppMethodBeat.o(27294);
                                    return;
                                case 2:
                                    if (NormalUserFooterPreference.this.contact.arA()) {
                                        ab.y(NormalUserFooterPreference.this.contact);
                                        com.tencent.mm.ui.base.h.cD(NormalUserFooterPreference.this.gte, NormalUserFooterPreference.this.gte.getString(R.string.bhf));
                                    } else {
                                        ab.x(NormalUserFooterPreference.this.contact);
                                        com.tencent.mm.ui.base.h.cD(NormalUserFooterPreference.this.gte, NormalUserFooterPreference.this.gte.getString(R.string.bb0));
                                    }
                                    NormalUserFooterPreference normalUserFooterPreference2 = NormalUserFooterPreference.this;
                                    bg.aVF();
                                    normalUserFooterPreference2.contact = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.this.contact.field_username);
                                    AppMethodBeat.o(27294);
                                    return;
                                case 3:
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("sns_permission_userName", NormalUserFooterPreference.this.contact.field_username);
                                    intent2.putExtra("sns_permission_anim", true);
                                    intent2.putExtra("sns_permission_block_scene", 1);
                                    com.tencent.mm.br.c.b(NormalUserFooterPreference.this.gte, "sns", ".ui.SnsPermissionUI", intent2);
                                    AppMethodBeat.o(27294);
                                    return;
                                case 4:
                                    a aVar3 = a.this;
                                    Intent intent3 = new Intent();
                                    intent3.putExtra("Select_Talker_Name", NormalUserFooterPreference.this.contact.field_username);
                                    intent3.putExtra("Select_block_List", NormalUserFooterPreference.this.contact.field_username);
                                    intent3.putExtra("Select_Conv_Type", 3);
                                    intent3.putExtra("Select_Send_Card", true);
                                    intent3.putExtra("mutil_select_is_ret", true);
                                    com.tencent.mm.plugin.profile.b.jRt.a(intent3, 1, NormalUserFooterPreference.this.gte);
                                    AppMethodBeat.o(27294);
                                    return;
                                case 5:
                                    if (NormalUserFooterPreference.this.contact.ary()) {
                                        a.a(a.this);
                                        AppMethodBeat.o(27294);
                                        return;
                                    }
                                    View inflate = View.inflate(NormalUserFooterPreference.this.mContext, R.layout.b7f, null);
                                    inflate.setPadding(0, 0, 0, 0);
                                    TextView textView = (TextView) inflate.findViewById(R.id.ffg);
                                    textView.setPadding(0, 0, 0, 0);
                                    textView.setText(as.bjp(NormalUserFooterPreference.this.contact.field_username) ? R.string.bd8 : R.string.bd7);
                                    final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ffe);
                                    checkBox.setChecked(false);
                                    TextView textView2 = (TextView) inflate.findViewById(R.id.fff);
                                    textView2.setText(R.string.bd9);
                                    if (NormalUserFooterPreference.this.contact.getSource() == 18) {
                                        checkBox.setVisibility(0);
                                        textView2.setVisibility(0);
                                    } else {
                                        checkBox.setVisibility(8);
                                        textView2.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.string.bd6), inflate, NormalUserFooterPreference.this.mContext.getString(R.string.x_), NormalUserFooterPreference.this.mContext.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(27292);
                                            a.b(a.this);
                                            if (NormalUserFooterPreference.this.contact.getSource() == 18) {
                                                NormalUserFooterPreference.this.kgm = 9;
                                                if (checkBox.isChecked()) {
                                                    a.c(a.this);
                                                }
                                            }
                                            AppMethodBeat.o(27292);
                                        }
                                    }, (DialogInterface.OnClickListener) null);
                                    AppMethodBeat.o(27294);
                                    return;
                                case 6:
                                    View inflate2 = View.inflate(NormalUserFooterPreference.this.mContext, R.layout.b7f, null);
                                    inflate2.setPadding(0, 0, 0, 0);
                                    TextView textView3 = (TextView) inflate2.findViewById(R.id.ffg);
                                    textView3.setPadding(0, 0, 0, 0);
                                    textView3.setText(ab.IQ(NormalUserFooterPreference.this.contact.field_username) ? NormalUserFooterPreference.this.mContext.getString(R.string.bl4, NormalUserFooterPreference.this.contact.arJ()) : NormalUserFooterPreference.this.mContext.getString(R.string.bl2, NormalUserFooterPreference.this.contact.arJ()));
                                    final CheckBox checkBox2 = (CheckBox) inflate2.findViewById(R.id.ffe);
                                    checkBox2.setChecked(false);
                                    TextView textView4 = (TextView) inflate2.findViewById(R.id.fff);
                                    textView4.setText(R.string.bd9);
                                    if (NormalUserFooterPreference.this.contact.getSource() == 18) {
                                        checkBox2.setVisibility(0);
                                        textView4.setVisibility(0);
                                    } else {
                                        checkBox2.setVisibility(8);
                                        textView4.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.string.bad), inflate2, NormalUserFooterPreference.this.mContext.getString(R.string.tf), NormalUserFooterPreference.this.mContext.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(27293);
                                            a.this.eEQ();
                                            if (NormalUserFooterPreference.this.contact.getSource() == 18) {
                                                NormalUserFooterPreference.this.kgm = 9;
                                                if (checkBox2.isChecked()) {
                                                    a.c(a.this);
                                                }
                                            }
                                            AppMethodBeat.o(27293);
                                        }
                                    }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
                                    AppMethodBeat.o(27294);
                                    return;
                                case 7:
                                    a aVar4 = a.this;
                                    Log.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.this.contact.field_username);
                                    com.tencent.mm.plugin.base.model.b.ai(NormalUserFooterPreference.this.gte, NormalUserFooterPreference.this.contact.field_username);
                                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                        /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass9 */

                                        public final void run() {
                                            AppMethodBeat.i(27303);
                                            if (NormalUserFooterPreference.this.gte.isFinishing()) {
                                                AppMethodBeat.o(27303);
                                                return;
                                            }
                                            com.tencent.mm.plugin.base.model.b.ah(NormalUserFooterPreference.this.gte, NormalUserFooterPreference.this.contact.field_username);
                                            com.tencent.mm.plugin.base.model.b.K(NormalUserFooterPreference.this.gte);
                                            AppMethodBeat.o(27303);
                                        }
                                    }, 1000);
                                    AppMethodBeat.o(27294);
                                    return;
                                case 9:
                                    a.c(a.this);
                                    break;
                            }
                            AppMethodBeat.o(27294);
                        }
                    };
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            String string;
                            String string2;
                            AppMethodBeat.i(27295);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(NormalUserFooterPreference.this.gte.getIntent())), 7, 1, NormalUserFooterPreference.this.contact.field_username);
                            if (as.bjp(NormalUserFooterPreference.this.contact.field_username)) {
                                mVar.aS(1, R.string.bid, R.raw.bottomsheet_icon_remarks);
                            } else {
                                mVar.aS(1, R.string.bd1, R.raw.bottomsheet_icon_remarks);
                            }
                            if (NormalUserFooterPreference.this.contact.arA()) {
                                string = NormalUserFooterPreference.this.gte.getResources().getString(R.string.bhe);
                            } else {
                                string = NormalUserFooterPreference.this.gte.getResources().getString(R.string.baz);
                            }
                            mVar.b(2, string, R.raw.bottomsheet_icon_star);
                            if (!as.bjp(NormalUserFooterPreference.this.contact.field_username)) {
                                mVar.aS(3, R.string.bdg, R.raw.bottomsheet_icon_moment);
                            }
                            mVar.aS(4, R.string.bf7, R.raw.bottomsheet_icon_transmit);
                            mVar.aS(9, R.string.ahk, R.raw.bottomsheet_icon_complain);
                            if (NormalUserFooterPreference.this.contact.ary()) {
                                string2 = NormalUserFooterPreference.this.gte.getString(R.string.bda);
                            } else {
                                string2 = NormalUserFooterPreference.this.gte.getString(R.string.bd6);
                            }
                            mVar.b(5, string2, R.raw.bottomsheet_icon_blacklist);
                            if (!NormalUserFooterPreference.this.Bhh) {
                                mVar.aS(6, R.string.adp, R.raw.bottomsheet_icon_del);
                            }
                            mVar.aS(7, R.string.b9p, R.raw.bottomsheet_icon_desktop);
                            AppMethodBeat.o(27295);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(27296);
                    return true;
                }
            });
        }

        /* access modifiers changed from: protected */
        public final void ac(final boolean z, final boolean z2) {
            if (!z || !z2) {
                NormalUserFooterPreference.this.gte.addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass10 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(27307);
                        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) NormalUserFooterPreference.this.gte, 1, false);
                        eVar.HLY = new o.g() {
                            /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass10.AnonymousClass1 */

                            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                int i3;
                                AppMethodBeat.i(27305);
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        a.this.aKk(NormalUserFooterPreference.this.contact.field_username);
                                        AppMethodBeat.o(27305);
                                        return;
                                    case 5:
                                        Context context = NormalUserFooterPreference.this.mContext;
                                        Context context2 = NormalUserFooterPreference.this.mContext;
                                        if (as.bjp(NormalUserFooterPreference.this.contact.field_username)) {
                                            i3 = R.string.bd8;
                                        } else {
                                            i3 = R.string.bd7;
                                        }
                                        com.tencent.mm.ui.base.h.a(context, context2.getString(i3), NormalUserFooterPreference.this.mContext.getString(R.string.bd6), new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass10.AnonymousClass1.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(27304);
                                                a.b(a.this);
                                                AppMethodBeat.o(27304);
                                            }
                                        }, (DialogInterface.OnClickListener) null);
                                        break;
                                    case 8:
                                        a.a(a.this);
                                        AppMethodBeat.o(27305);
                                        return;
                                }
                                AppMethodBeat.o(27305);
                            }
                        };
                        eVar.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass10.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(27306);
                                if (!z) {
                                    if (as.bjp(NormalUserFooterPreference.this.contact.field_username)) {
                                        mVar.aS(1, R.string.bid, R.raw.bottomsheet_icon_remarks);
                                    } else {
                                        mVar.aS(1, R.string.bd1, R.raw.bottomsheet_icon_remarks);
                                    }
                                }
                                if (!z2) {
                                    if (NormalUserFooterPreference.this.contact.ary()) {
                                        mVar.aS(8, R.string.bda, R.raw.bottomsheet_icon_blacklist);
                                        AppMethodBeat.o(27306);
                                        return;
                                    } else if (!ab.IR(NormalUserFooterPreference.this.contact.field_username)) {
                                        mVar.aS(5, R.string.bd6, R.raw.bottomsheet_icon_blacklist);
                                    }
                                }
                                AppMethodBeat.o(27306);
                            }
                        };
                        eVar.dGm();
                        AppMethodBeat.o(27307);
                        return true;
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public void eEO() {
            if (NormalUserFooterPreference.this.BfM) {
                NormalUserFooterPreference.this.gte.showOptionMenu(false);
            } else if (z.aTY().equals(NormalUserFooterPreference.this.contact.field_username)) {
            } else {
                if (!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type)) {
                    ac(false, false);
                } else if (!ab.Jv(NormalUserFooterPreference.this.contact.field_username)) {
                    eEN();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void eEP() {
            this.Bcp = new com.tencent.mm.ui.widget.a.e((Context) NormalUserFooterPreference.this.gte, 1, false);
            this.Bcp.HLX = new o.f() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(27299);
                    mVar.aS(2, R.string.v4, R.raw.sharemore_videovoip);
                    mVar.aS(1, R.string.v6, R.raw.sharemore_voipvoice);
                    AppMethodBeat.o(27299);
                }
            };
            this.Bcp.HLY = new o.g() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(27300);
                    switch (menuItem.getItemId()) {
                        case 1:
                            NormalUserFooterPreference.this.eEK();
                            AppMethodBeat.o(27300);
                            return;
                        case 2:
                            NormalUserFooterPreference.this.eEL();
                            break;
                    }
                    AppMethodBeat.o(27300);
                }
            };
            this.Bcp.dGm();
        }

        /* access modifiers changed from: package-private */
        public final void aKk(String str) {
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.kgm);
            intent.putExtra("Contact_mode_name_type", 0);
            intent.putExtra("Contact_ModStrangerRemark", true);
            intent.putExtra("Contact_User", NormalUserFooterPreference.this.contact.field_username);
            intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.contact.field_nickname);
            intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.contact.field_conRemark);
            com.tencent.mm.plugin.profile.b.jRt.m(intent, NormalUserFooterPreference.this.mContext);
        }

        /* access modifiers changed from: protected */
        public final void eEQ() {
            String str;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 2, 2, NormalUserFooterPreference.this.contact.field_username);
            final String str2 = NormalUserFooterPreference.this.contact.field_username;
            if (ab.IQ(str2)) {
                NormalUserFooterPreference.this.contact.aqR();
                bg.aVF();
                com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.d(str2));
                bg.aVF();
                com.tencent.mm.model.c.aSN().aNa(str2);
                bg.aVF();
                com.tencent.mm.model.c.aSX().Kj(str2);
                return;
            }
            this.isDeleteCancel = false;
            Context context = NormalUserFooterPreference.this.mContext;
            NormalUserFooterPreference.this.mContext.getString(R.string.zb);
            final com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.h.a(context, NormalUserFooterPreference.this.mContext.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.isDeleteCancel = true;
                }
            });
            if (!this.isDeleteCancel) {
                str = com.tencent.mm.pluginsdk.wallet.d.bfO(NormalUserFooterPreference.this.contact.field_username);
            } else {
                str = null;
            }
            if (!Util.isNullOrNil(str)) {
                a2.dismiss();
                com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(R.string.ibz, str), null, NormalUserFooterPreference.this.mContext.getString(R.string.dvh), NormalUserFooterPreference.this.mContext.getString(R.string.blh), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27301);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 2, 4, NormalUserFooterPreference.this.contact.field_username);
                        a.this.isDeleteCancel = true;
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", NormalUserFooterPreference.this.contact.field_username);
                        intent.addFlags(67108864);
                        com.tencent.mm.br.c.f(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", intent);
                        AppMethodBeat.o(27301);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27302);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 2, 3, NormalUserFooterPreference.this.contact.field_username);
                        a2.show();
                        a.this.isDeleteCancel = false;
                        a.this.XA(str2);
                        AppMethodBeat.o(27302);
                    }
                }, -1, R.color.cd);
                return;
            }
            XA(str2);
        }

        @Override // com.tencent.mm.pluginsdk.h.a.AbstractC2017a
        public final void a(String str, int i2, cxl cxl) {
            com.tencent.mm.plugin.account.friend.a.g gVar = null;
            if (i2 == 0) {
                if (!str.equals(NormalUserFooterPreference.this.contact.field_username)) {
                    Log.w("MicroMsg.NormalUserFooterPreference", "not current contact %s,%s", NormalUserFooterPreference.this.contact.field_username, str);
                    return;
                }
                switch (NormalUserFooterPreference.this.kgm) {
                    case 10:
                        t.R(NormalUserFooterPreference.this.mContext, str);
                        break;
                    case 12:
                        com.tencent.mm.plugin.account.friend.a.as Tg = com.tencent.mm.plugin.account.a.getQQListStg().Tg(str);
                        if (Tg != null) {
                            Tg.kfO = 1;
                            com.tencent.mm.plugin.account.a.getQQListStg().a(Tg.kfN, Tg);
                            break;
                        }
                        break;
                    case 13:
                        com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(str);
                        if (SR != null && !Util.isNullOrNil(SR.kdX)) {
                            SR.status = 1;
                            com.tencent.mm.plugin.account.a.getAddrUploadStg().a(SR.getMd5(), SR);
                        }
                        t.R(NormalUserFooterPreference.this.mContext, str);
                        break;
                    case 31:
                        com.tencent.mm.plugin.account.friend.a.h facebookFrdStg = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
                        Cursor rawQuery = facebookFrdStg.iFy.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + str + "\"", null, 2);
                        if (rawQuery != null) {
                            if (rawQuery.moveToFirst()) {
                                gVar = new com.tencent.mm.plugin.account.friend.a.g();
                                gVar.convertFrom(rawQuery);
                            }
                            rawQuery.close();
                        }
                        if (gVar != null) {
                            gVar.status = 100;
                            com.tencent.mm.plugin.account.a.getFacebookFrdStg().a(gVar);
                            break;
                        }
                        break;
                    case 58:
                    case bv.CTRL_INDEX:
                    case 60:
                        com.tencent.mm.plugin.account.a.getGoogleFriendStorage().aG(str, 2);
                        break;
                }
                if (NormalUserFooterPreference.this.kgm == 9) {
                    Log.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.this.contact.getSource());
                    switch (NormalUserFooterPreference.this.contact.getSource()) {
                        case 10:
                        case 13:
                            Log.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
                            t.R(NormalUserFooterPreference.this.mContext, str);
                            break;
                    }
                }
                if (NormalUserFooterPreference.this.Bft == 0) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.jRt.o(intent, NormalUserFooterPreference.this.mContext);
                    return;
                }
                NormalUserFooterPreference.this.gte.setResult(-1, NormalUserFooterPreference.this.gte.getIntent().putExtra("_delete_ok_", true));
                ((Activity) NormalUserFooterPreference.this.mContext).finish();
            } else if (!Util.isNullOrNil(cxl.iAc)) {
                com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.this.gte, cxl.iAc, cxl.Title, true);
            } else {
                com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.this.gte, NormalUserFooterPreference.this.gte.getString(R.string.tg), "", true);
            }
        }

        /* access modifiers changed from: package-private */
        public final void XA(String str) {
            NormalUserFooterPreference.this.contact.aqR();
            if (as.bjp(str)) {
                ((r) com.tencent.mm.kernel.g.af(r.class)).EG(str);
                ay.a.iDq.Ka(str);
                return;
            }
            ((com.tencent.mm.pluginsdk.h.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.h.a.class)).XA(str);
        }

        static /* synthetic */ void a(a aVar) {
            ab.u(NormalUserFooterPreference.this.contact);
            NormalUserFooterPreference.this.contact.aqT();
            if (NormalUserFooterPreference.this.rFe) {
                NormalUserFooterPreference.this.Bhx.setVisibility(8);
                aVar.eEM();
            }
        }

        static /* synthetic */ void b(a aVar) {
            ab.t(NormalUserFooterPreference.this.contact);
            NormalUserFooterPreference.this.contact.aqS();
            if (NormalUserFooterPreference.this.rFe) {
                NormalUserFooterPreference.this.Bhx.setVisibility(0);
                aVar.eEM();
            }
        }

        static /* synthetic */ void c(a aVar) {
            String str;
            int i2 = 7;
            int i3 = 45;
            Intent intent = new Intent();
            switch (NormalUserFooterPreference.this.kgm) {
                case 1:
                case 2:
                case 3:
                case 12:
                case 13:
                case 58:
                case bv.CTRL_INDEX:
                case 60:
                    intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.P(45, NormalUserFooterPreference.this.contact.field_username));
                    i2 = 45;
                    break;
                case 9:
                case 14:
                    i2 = 35;
                    break;
                case 18:
                    if (NormalUserFooterPreference.this.BcL) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Qb(NormalUserFooterPreference.this.contact.field_username));
                    break;
                case 22:
                case 23:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                    i2 = NormalUserFooterPreference.this.BcL ? 4 : 3;
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Qc(NormalUserFooterPreference.this.contact.field_username));
                    break;
                case 25:
                    i2 = NormalUserFooterPreference.this.BcL ? 6 : 5;
                    if (!NormalUserFooterPreference.this.BcL) {
                        if (!Util.isNullOrNil(NormalUserFooterPreference.this.contact.Ooy)) {
                            str = NormalUserFooterPreference.this.contact.Ooy;
                        } else {
                            str = NormalUserFooterPreference.this.contact.field_username;
                        }
                        intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Qd(str));
                        break;
                    } else {
                        intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.P(i2, NormalUserFooterPreference.this.contact.field_username));
                        break;
                    }
                case 30:
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.P(7, NormalUserFooterPreference.this.contact.field_username));
                    break;
                default:
                    i2 = 35;
                    break;
            }
            if (com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type)) {
                i3 = i2;
            }
            intent.putExtra("k_username", NormalUserFooterPreference.this.contact.field_username);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format(e.C2115e.OyU, Integer.valueOf(i3)));
            com.tencent.mm.br.c.b(NormalUserFooterPreference.this.gte, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    /* access modifiers changed from: package-private */
    public class i extends c implements com.tencent.mm.ak.i {
        private ProgressDialog gtM;

        public i() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a, com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c
        public void eEM() {
            AppMethodBeat.i(27338);
            onDetach();
            onStop();
            bg.azz().a(30, this);
            bg.azz().a(com.tencent.mm.plugin.appbrand.game.e.a.a.CTRL_INDEX, this);
            bg.azz().a(JsApiGetRecentUsageList.CTRL_INDEX, this);
            super.eEM();
            AppMethodBeat.o(27338);
        }

        /* access modifiers changed from: package-private */
        public final void onStop() {
            AppMethodBeat.i(27339);
            bg.azz().b(30, this);
            bg.azz().b(com.tencent.mm.plugin.appbrand.game.e.a.a.CTRL_INDEX, this);
            bg.azz().b(JsApiGetRecentUsageList.CTRL_INDEX, this);
            AppMethodBeat.o(27339);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a, com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c
        public void onDetach() {
            AppMethodBeat.i(27340);
            if (this.gtM != null) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            if (NormalUserFooterPreference.this.Bhj != null) {
                NormalUserFooterPreference.this.Bhj.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.Bhq != null) {
                NormalUserFooterPreference.this.Bhq.setVisibility(0);
            }
            if (NormalUserFooterPreference.this.han != null) {
                NormalUserFooterPreference.this.han.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.Bhw != null) {
                NormalUserFooterPreference.this.Bhw.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.Bhu != null) {
                NormalUserFooterPreference.this.Bhu.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.Bht != null) {
                NormalUserFooterPreference.this.Bht.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.Bhx != null) {
                NormalUserFooterPreference.this.Bhx.setVisibility(8);
            }
            onStop();
            AppMethodBeat.o(27340);
        }

        private void aqQ() {
            AppMethodBeat.i(27341);
            NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.this.contact.field_username);
            if (Kn == null || ((int) Kn.gMZ) == 0) {
                as asVar = NormalUserFooterPreference.this.contact;
                bg.aVF();
                if (!com.tencent.mm.model.c.aSN().ao(asVar)) {
                    Log.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + asVar.field_username);
                    Kn = null;
                } else {
                    bg.aVF();
                    Kn = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.this.contact.field_username);
                }
            }
            normalUserFooterPreference.contact = Kn;
            if (NormalUserFooterPreference.this.contact != null) {
                ab.B(NormalUserFooterPreference.this.contact);
            }
            AppMethodBeat.o(27341);
        }

        /* access modifiers changed from: protected */
        public void eET() {
            AppMethodBeat.i(27342);
            if (NormalUserFooterPreference.this.Bhi != null) {
                NormalUserFooterPreference.this.Bhi.onDetach();
            }
            NormalUserFooterPreference.this.Bhi = new c();
            NormalUserFooterPreference.this.Bhi.aSs();
            AppMethodBeat.o(27342);
        }

        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a, com.tencent.mm.ak.i
        public void onSceneEnd(int i2, int i3, String str, q qVar) {
            List<String> list;
            boolean z = false;
            AppMethodBeat.i(27343);
            Log.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
            if (qVar.getType() == 30 || qVar.getType() == 667 || qVar.getType() == 853) {
                onStop();
                if (this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                if (!Util.isTopActivity(NormalUserFooterPreference.this.mContext)) {
                    AppMethodBeat.o(27343);
                    return;
                }
                if (i2 == 0 && i3 == 0) {
                    if (qVar.getType() == 30) {
                        int i4 = ((p) qVar).dKy;
                        Log.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(i4)));
                        if ((i4 == 1 || i4 == 3) && (list = ((p) qVar).JVj) != null && list.contains(NormalUserFooterPreference.this.contact.field_username)) {
                            NormalUserFooterPreference.this.Bhy = true;
                            aqQ();
                            eET();
                            for (String str2 : list) {
                                com.tencent.mm.pluginsdk.ui.preference.b.cC(str2, NormalUserFooterPreference.this.kgm);
                            }
                            bg.getNotification().alb();
                        }
                        AppMethodBeat.o(27343);
                        return;
                    } else if (qVar.getType() == 667 || qVar.getType() == 853) {
                        NormalUserFooterPreference.this.Bhy = true;
                        aqQ();
                        eET();
                        com.tencent.mm.pluginsdk.ui.preference.b.cC(NormalUserFooterPreference.this.contact.field_username, NormalUserFooterPreference.this.kgm);
                        bg.getNotification().alb();
                        AppMethodBeat.o(27343);
                        return;
                    }
                }
                if (i2 == 4 && i3 == -302) {
                    int i5 = qVar.getType() == 30 ? ((p) qVar).dKy : 0;
                    Log.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(i5));
                    if (i5 == 3 || qVar.getType() == 853) {
                        com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.this.gte, NormalUserFooterPreference.this.gte.getString(R.string.bhi), NormalUserFooterPreference.this.gte.getString(R.string.zb), NormalUserFooterPreference.this.gte.getString(R.string.h6), NormalUserFooterPreference.this.gte.getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(27337);
                                i.this.eER();
                                AppMethodBeat.o(27337);
                            }
                        }, null);
                    }
                    AppMethodBeat.o(27343);
                } else if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                    Toast.makeText(NormalUserFooterPreference.this.gte, str, 1).show();
                    AppMethodBeat.o(27343);
                } else {
                    switch (i2) {
                        case 1:
                            if (!bg.azz().aYT()) {
                                if (ag.dm(NormalUserFooterPreference.this.mContext)) {
                                    com.tencent.mm.pluginsdk.ui.tools.m.iC(NormalUserFooterPreference.this.mContext);
                                    z = true;
                                    break;
                                }
                            } else {
                                bg.azz().getNetworkServerIp();
                                new StringBuilder().append(i3);
                                z = true;
                                break;
                            }
                            break;
                        case 2:
                            Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(R.string.dep, 2, Integer.valueOf(i3)), 3000).show();
                            z = true;
                            break;
                        case 4:
                            if (i3 != -100 && i3 != -2023) {
                                if (i2 == 4 && i3 == -34) {
                                    str = NormalUserFooterPreference.this.gte.getString(R.string.ddu);
                                } else if (i2 == 4 && i3 == -94) {
                                    str = NormalUserFooterPreference.this.gte.getString(R.string.ddx);
                                } else if (i2 != 4 || Util.isNullOrNil(str)) {
                                    str = NormalUserFooterPreference.this.gte.getString(R.string.gkm);
                                }
                                Toast.makeText(NormalUserFooterPreference.this.gte, str, 1).show();
                                break;
                            } else {
                                com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, bg.ayX(), com.tencent.mm.cb.a.aI(NormalUserFooterPreference.this.mContext, R.string.zb), new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(27335);
                                        i.this.onStop();
                                        Intent intent = new Intent();
                                        intent.putExtra("Intro_Switch", true).addFlags(67108864);
                                        com.tencent.mm.plugin.profile.b.jRt.o(intent, NormalUserFooterPreference.this.mContext);
                                        AppMethodBeat.o(27335);
                                    }
                                }, new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i.AnonymousClass2 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(27336);
                                        i.this.onStop();
                                        Intent intent = new Intent();
                                        intent.putExtra("Intro_Switch", true).addFlags(67108864);
                                        com.tencent.mm.plugin.profile.b.jRt.o(intent, NormalUserFooterPreference.this.mContext);
                                        AppMethodBeat.o(27336);
                                    }
                                });
                                z = true;
                                break;
                            }
                            break;
                    }
                    if (z) {
                        AppMethodBeat.o(27343);
                    } else {
                        AppMethodBeat.o(27343);
                    }
                }
            } else {
                AppMethodBeat.o(27343);
            }
        }
    }

    class j extends i implements com.tencent.mm.ak.i {
        public j() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEO() {
            AppMethodBeat.i(27347);
            if (NormalUserFooterPreference.this.contact == null || !com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type)) {
                ac(false, true);
                AppMethodBeat.o(27347);
                return;
            }
            eEN();
            AppMethodBeat.o(27347);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a, com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c, com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i
        public final void eEM() {
            AppMethodBeat.i(27348);
            super.eEM();
            NormalUserFooterPreference.this.Bhj.setVisibility(0);
            NormalUserFooterPreference.this.Bht.setVisibility(8);
            NormalUserFooterPreference.this.han.setVisibility(8);
            NormalUserFooterPreference.this.Bhw.setVisibility(8);
            NormalUserFooterPreference.this.Bhu.setVisibility(8);
            NormalUserFooterPreference.this.Bhv.setVisibility(8);
            NormalUserFooterPreference.this.Bhq.setVisibility(8);
            NormalUserFooterPreference.this.Bhx.setVisibility(8);
            NormalUserFooterPreference.this.Bho.setVisibility(0);
            NormalUserFooterPreference.this.Bhn.setVisibility(0);
            if (NormalUserFooterPreference.this.contact.ary()) {
                NormalUserFooterPreference.this.Bhm.setText(NormalUserFooterPreference.this.gte.getString(R.string.bda));
                NormalUserFooterPreference.this.Bhx.setVisibility(0);
            } else {
                NormalUserFooterPreference.this.Bhm.setText(NormalUserFooterPreference.this.gte.getString(R.string.bd6));
            }
            NormalUserFooterPreference.this.Bhk.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27344);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    NormalUserFooterPreference.this.gte.getIntent().removeExtra("Accept_NewFriend_FromOutside");
                    int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 2);
                    int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_add_friends_without_choose_permission_threshold, 1000);
                    Class cls = SayHiWithSnsPermissionUI.class;
                    if (!as.bjp(NormalUserFooterPreference.this.contact.field_username) && a2 == 1) {
                        cls = SayHiWithSnsPermissionUI2.class;
                    } else if (!as.bjp(NormalUserFooterPreference.this.contact.field_username) && a2 == 2 && ab.aVc() >= a3) {
                        cls = SayHiWithSnsPermissionUI3.class;
                    }
                    Intent intent = new Intent(NormalUserFooterPreference.this.gte, cls);
                    intent.putExtra("Contact_User", NormalUserFooterPreference.this.contact.field_username);
                    intent.putExtra("room_name", NormalUserFooterPreference.this.gte.getIntent().getStringExtra("room_name"));
                    intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.contact.field_nickname);
                    intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.contact.field_conRemark);
                    if (NormalUserFooterPreference.this.kgm == 14 || NormalUserFooterPreference.this.kgm == 8) {
                        intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.gte.getIntent().getStringExtra("Contact_RoomNickname"));
                    }
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.kgm);
                    intent.putExtra("Verify_ticket", NormalUserFooterPreference.this.wZz);
                    intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    intent.putExtra("sayhi_with_sns_perm_set_label", true);
                    NormalUserFooterPreference.this.gte.startActivityForResult(intent, 0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27344);
                }
            });
            NormalUserFooterPreference.this.Bhm.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j.AnonymousClass2 */

                public final void onClick(View view) {
                    int i2;
                    AppMethodBeat.i(27346);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (NormalUserFooterPreference.this.contact.ary()) {
                        ab.u(NormalUserFooterPreference.this.contact);
                        NormalUserFooterPreference.this.contact.aqT();
                        j.this.eEM();
                    } else {
                        Context context = NormalUserFooterPreference.this.mContext;
                        Context context2 = NormalUserFooterPreference.this.mContext;
                        if (as.bjp(NormalUserFooterPreference.this.contact.field_username)) {
                            i2 = R.string.bd8;
                        } else {
                            i2 = R.string.bd7;
                        }
                        com.tencent.mm.ui.base.h.a(context, context2.getString(i2), NormalUserFooterPreference.this.mContext.getString(R.string.bd6), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(27345);
                                ab.t(NormalUserFooterPreference.this.contact);
                                NormalUserFooterPreference.this.contact.aqS();
                                j.this.eEM();
                                AppMethodBeat.o(27345);
                            }
                        }, (DialogInterface.OnClickListener) null);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27346);
                }
            });
            AppMethodBeat.o(27348);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a, com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c, com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i
        public final void onDetach() {
            AppMethodBeat.i(27349);
            super.onDetach();
            AppMethodBeat.o(27349);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i
        public final void eET() {
            AppMethodBeat.i(27350);
            super.eET();
            AppMethodBeat.o(27350);
        }

        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a, com.tencent.mm.ak.i, com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(27351);
            super.onSceneEnd(i2, i3, str, qVar);
            AppMethodBeat.o(27351);
        }
    }

    class h extends a {
        public h() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEO() {
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEM() {
            AppMethodBeat.i(27334);
            NormalUserFooterPreference.this.Bhj.setVisibility(8);
            NormalUserFooterPreference.this.han.setVisibility(0);
            if (NormalUserFooterPreference.this.eEJ() || NormalUserFooterPreference.this.contact.field_username.equals(z.aTY()) || ab.JE(NormalUserFooterPreference.this.contact.field_username) || ab.Jv(NormalUserFooterPreference.this.contact.field_username)) {
                NormalUserFooterPreference.this.Bhu.setVisibility(8);
            } else {
                NormalUserFooterPreference.this.Bhu.setVisibility(0);
            }
            NormalUserFooterPreference.this.han.setText(R.string.bf8);
            NormalUserFooterPreference.this.Bht.setVisibility(8);
            NormalUserFooterPreference.this.Bhq.setVisibility(8);
            NormalUserFooterPreference.this.Bhx.setVisibility(8);
            AppMethodBeat.o(27334);
        }
    }

    class d extends a {
        public d() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEO() {
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEM() {
            AppMethodBeat.i(27329);
            Assert.assertTrue(ab.Jf(NormalUserFooterPreference.this.contact.field_username));
            NormalUserFooterPreference.this.Bhj.setVisibility(8);
            NormalUserFooterPreference.this.Bhq.setVisibility(8);
            NormalUserFooterPreference.this.Bht.setVisibility(8);
            NormalUserFooterPreference.this.han.setVisibility(0);
            NormalUserFooterPreference.this.Bhw.setVisibility(8);
            NormalUserFooterPreference.this.Bhu.setVisibility(8);
            NormalUserFooterPreference.this.Bhv.setVisibility(8);
            NormalUserFooterPreference.this.Bhx.setVisibility(8);
            AppMethodBeat.o(27329);
        }
    }

    class f extends a {
        public f() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEO() {
            AppMethodBeat.i(27331);
            if (NormalUserFooterPreference.this.contact == null || !com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type)) {
                ac(false, true);
                AppMethodBeat.o(27331);
                return;
            }
            eEN();
            AppMethodBeat.o(27331);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEM() {
            AppMethodBeat.i(27332);
            NormalUserFooterPreference.this.Bhj.setVisibility(8);
            NormalUserFooterPreference.this.Bhq.setVisibility(0);
            NormalUserFooterPreference.this.Bht.setVisibility(8);
            NormalUserFooterPreference.this.han.setVisibility(8);
            NormalUserFooterPreference.this.Bhw.setVisibility(8);
            NormalUserFooterPreference.this.Bhu.setVisibility(8);
            NormalUserFooterPreference.this.Bhv.setVisibility(8);
            NormalUserFooterPreference.this.Bhx.setVisibility(8);
            NormalUserFooterPreference.this.Bhs.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.f.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27330);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.au(1, 1, 5);
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", NormalUserFooterPreference.this.contact.field_username);
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.kgm);
                    intent.putExtra(e.d.OyT, NormalUserFooterPreference.this.contact.fuY);
                    com.tencent.mm.plugin.profile.b.jRt.a(intent, NormalUserFooterPreference.this.mContext);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27330);
                }
            });
            AppMethodBeat.o(27332);
        }
    }

    class b extends c {
        public b() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEO() {
            AppMethodBeat.i(27316);
            if (NormalUserFooterPreference.this.contact == null) {
                Log.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
                AppMethodBeat.o(27316);
            } else if (com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type) && (!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type) || !as.IG(NormalUserFooterPreference.this.contact.field_username))) {
                eEN();
                AppMethodBeat.o(27316);
            } else if (as.IG(NormalUserFooterPreference.this.contact.field_username)) {
                ac(true, true);
                AppMethodBeat.o(27316);
            } else {
                ac(false, true);
                AppMethodBeat.o(27316);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0082  */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a, com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void eEM() {
            /*
            // Method dump skipped, instructions count: 235
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.b.eEM():void");
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends a {
        public c() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void aSs() {
            AppMethodBeat.i(27323);
            super.aSs();
            AppMethodBeat.o(27323);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public void onDetach() {
            AppMethodBeat.i(27324);
            super.onDetach();
            AppMethodBeat.o(27324);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public void eEM() {
            AppMethodBeat.i(27325);
            Assert.assertTrue(!ab.JE(NormalUserFooterPreference.this.contact.field_username));
            NormalUserFooterPreference.this.Bhj.setVisibility(8);
            NormalUserFooterPreference.this.Bhq.setVisibility(8);
            if (NormalUserFooterPreference.this.BfM) {
                NormalUserFooterPreference.this.Bhl.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(27318);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        c.this.eEQ();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(27318);
                    }
                });
                if (com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type)) {
                    NormalUserFooterPreference.this.Bhl.setVisibility(0);
                } else {
                    NormalUserFooterPreference.this.Bhl.setVisibility(8);
                }
                NormalUserFooterPreference.this.Bht.setVisibility(8);
                NormalUserFooterPreference.this.han.setVisibility(8);
                NormalUserFooterPreference.this.Bhw.setVisibility(8);
                NormalUserFooterPreference.this.Bhu.setVisibility(8);
                NormalUserFooterPreference.this.Bhx.setVisibility(8);
                AppMethodBeat.o(27325);
                return;
            }
            NormalUserFooterPreference.this.Bht.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27319);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (NormalUserFooterPreference.this.gte.getIntent() != null) {
                        String stringExtra = NormalUserFooterPreference.this.gte.getIntent().getStringExtra("key_ww_add_session_id");
                        if (!Util.isNullOrNil(stringExtra)) {
                            gr grVar = new gr();
                            grVar.ut(stringExtra);
                            grVar.eCt = 0;
                            grVar.eKM = 1;
                            grVar.bfK();
                        }
                    }
                    c.this.eER();
                    if (NormalUserFooterPreference.this.Bfb != 0) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11263, Integer.valueOf(NormalUserFooterPreference.this.Bfb), NormalUserFooterPreference.this.contact.field_username);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27319);
                }
            });
            if (!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type)) {
                NormalUserFooterPreference.this.Bht.setVisibility(0);
                NormalUserFooterPreference.this.han.setVisibility(8);
                NormalUserFooterPreference.this.Bhw.setVisibility(8);
                NormalUserFooterPreference.this.Bhu.setVisibility(8);
            } else {
                NormalUserFooterPreference.this.Bht.setVisibility(8);
                NormalUserFooterPreference.this.han.setVisibility(0);
                if (NormalUserFooterPreference.this.eEJ() || NormalUserFooterPreference.this.contact.field_username.equals(z.aTY()) || ab.JE(NormalUserFooterPreference.this.contact.field_username) || ab.Jv(NormalUserFooterPreference.this.contact.field_username) || as.bjp(NormalUserFooterPreference.this.contact.field_username) || ab.IR(NormalUserFooterPreference.this.contact.field_username)) {
                    NormalUserFooterPreference.this.Bhu.setVisibility(8);
                } else {
                    NormalUserFooterPreference.this.Bhu.setVisibility(0);
                }
                bg.aVF();
                if (com.tencent.mm.model.c.aSN().bjO(NormalUserFooterPreference.this.contact.field_username)) {
                    NormalUserFooterPreference.this.Bhv.setVisibility(0);
                    NormalUserFooterPreference.this.kgm = NormalUserFooterPreference.this.contact.getSource();
                }
            }
            if (NormalUserFooterPreference.this.contact.ary()) {
                NormalUserFooterPreference.this.Bhx.setVisibility(0);
                AppMethodBeat.o(27325);
                return;
            }
            NormalUserFooterPreference.this.Bhx.setVisibility(8);
            AppMethodBeat.o(27325);
        }

        /* access modifiers changed from: protected */
        public final void eER() {
            AppMethodBeat.i(27326);
            if (((int) NormalUserFooterPreference.this.contact.gMZ) == 0) {
                bg.aVF();
                if (com.tencent.mm.model.c.aSN().aq(NormalUserFooterPreference.this.contact) != -1) {
                    NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
                    bg.aVF();
                    normalUserFooterPreference.contact = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.this.contact.field_username);
                }
            }
            if (NormalUserFooterPreference.this.Bhe || NormalUserFooterPreference.this.kgm == 12) {
                Log.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.this.Bge + " qqReamrk " + NormalUserFooterPreference.this.BfH);
                if (!(NormalUserFooterPreference.this.Bge == 0 || NormalUserFooterPreference.this.BfH == null || NormalUserFooterPreference.this.BfH.equals(""))) {
                    com.tencent.mm.plugin.account.friend.a.as AT = com.tencent.mm.plugin.account.a.getQQListStg().AT(NormalUserFooterPreference.this.Bge);
                    if (AT == null) {
                        com.tencent.mm.plugin.account.friend.a.as asVar = new com.tencent.mm.plugin.account.friend.a.as();
                        asVar.nickname = "";
                        asVar.kfN = NormalUserFooterPreference.this.Bge;
                        asVar.kfV = NormalUserFooterPreference.this.BfH;
                        asVar.username = NormalUserFooterPreference.this.contact.field_username;
                        asVar.boC();
                        com.tencent.mm.plugin.account.a.getQQListStg().a(asVar);
                    } else {
                        AT.kfN = NormalUserFooterPreference.this.Bge;
                        AT.kfV = NormalUserFooterPreference.this.BfH;
                        AT.username = NormalUserFooterPreference.this.contact.field_username;
                        AT.boC();
                        com.tencent.mm.plugin.account.a.getQQListStg().a(NormalUserFooterPreference.this.Bge, AT);
                    }
                }
            } else if (NormalUserFooterPreference.this.kgm == 58 || NormalUserFooterPreference.this.kgm == 59 || NormalUserFooterPreference.this.kgm == 60) {
                com.tencent.mm.plugin.account.a.getGoogleFriendStorage().aG(NormalUserFooterPreference.this.contact.field_username, 1);
            }
            eES();
            final com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(NormalUserFooterPreference.this.mContext, new a.AbstractC2025a() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.AnonymousClass3 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                public final void a(boolean z, boolean z2, String str, String str2) {
                    AppMethodBeat.i(27320);
                    if (z) {
                        NormalUserFooterPreference.this.iKx.event("hide_btn");
                        NormalUserFooterPreference.this.iKx.doNotify();
                        NormalUserFooterPreference.this.Bhy = true;
                        c.a(c.this, str);
                    } else if (z2) {
                        com.tencent.mm.bj.d.bgN().gP(str, 2);
                        au.aI(NormalUserFooterPreference.this.contact.field_encryptUsername, 1);
                        re reVar = new re();
                        reVar.dXU.username = NormalUserFooterPreference.this.contact.field_encryptUsername;
                        reVar.dXU.type = 1;
                        EventCenter.instance.publish(reVar);
                    } else {
                        Log.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(str)));
                    }
                    if (z || z2) {
                        Intent intent = NormalUserFooterPreference.this.gte.getIntent();
                        int intExtra = intent.getIntExtra("search_kvstat_scene", 0);
                        int intExtra2 = intent.getIntExtra("search_kvstat_position", 0);
                        if (intExtra > 0 && intExtra2 > 0) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10991, Integer.valueOf(intExtra), 6, Integer.valueOf(intExtra2));
                        }
                    }
                    AppMethodBeat.o(27320);
                }
            });
            final LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.add(Integer.valueOf(NormalUserFooterPreference.this.kgm));
            final String stringExtra = NormalUserFooterPreference.this.gte.getIntent().getStringExtra("source_from_user_name");
            final String stringExtra2 = NormalUserFooterPreference.this.gte.getIntent().getStringExtra("source_from_nick_name");
            aVar.mz(stringExtra, stringExtra2);
            aVar.Kea = new a.b() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.AnonymousClass4 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.a.b
                public final boolean aE(String str, int i2) {
                    AppMethodBeat.i(27321);
                    String stringExtra = NormalUserFooterPreference.this.gte.getIntent().getStringExtra("room_name");
                    int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 2);
                    int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_add_friends_without_choose_permission_threshold, 1000);
                    Class cls = SayHiWithSnsPermissionUI.class;
                    if (!as.bjp(NormalUserFooterPreference.this.contact.field_username) && a2 == 1) {
                        cls = SayHiWithSnsPermissionUI2.class;
                    } else if (!as.bjp(NormalUserFooterPreference.this.contact.field_username) && a2 == 2 && ab.aVc() >= a3) {
                        cls = SayHiWithSnsPermissionUI3.class;
                    }
                    Intent intent = new Intent(NormalUserFooterPreference.this.gte, cls);
                    intent.putExtra("Contact_User", NormalUserFooterPreference.this.contact.field_username);
                    intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.contact.field_nickname);
                    intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.contact.field_conRemark);
                    if (NormalUserFooterPreference.this.kgm == 14 || NormalUserFooterPreference.this.kgm == 8) {
                        intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.gte.getIntent().getStringExtra("Contact_RoomNickname"));
                    }
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.kgm);
                    intent.putExtra("room_name", stringExtra);
                    intent.putExtra("source_from_user_name", stringExtra);
                    intent.putExtra("source_from_nick_name", stringExtra2);
                    intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    intent.putExtra("sayhi_with_sns_perm_set_label", false);
                    intent.putExtra(e.d.OyT, str);
                    intent.putExtra("sayhi_verify_add_errcode", i2);
                    NormalUserFooterPreference.this.gte.startActivityForResult(intent, 0);
                    AppMethodBeat.o(27321);
                    return true;
                }
            };
            final String stringExtra3 = NormalUserFooterPreference.this.gte.getIntent().getStringExtra("room_name");
            String stringExtra4 = NormalUserFooterPreference.this.gte.getIntent().getStringExtra(e.d.OyT);
            if (!TextUtils.isEmpty(stringExtra4)) {
                Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", stringExtra4);
                aVar.beC(stringExtra4);
                aVar.d(NormalUserFooterPreference.this.contact.field_username, "", linkedList);
                AppMethodBeat.o(27326);
            } else if (TextUtils.isEmpty(stringExtra3)) {
                Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", NormalUserFooterPreference.this.contact.fuY);
                aVar.beC(NormalUserFooterPreference.this.contact.fuY);
                aVar.h(NormalUserFooterPreference.this.contact.field_username, linkedList);
                AppMethodBeat.o(27326);
            } else if (!TextUtils.isEmpty(aVar.wZz)) {
                Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", NormalUserFooterPreference.this.contact.fuY);
                aVar.beC(NormalUserFooterPreference.this.contact.fuY);
                aVar.d(NormalUserFooterPreference.this.contact.field_username, stringExtra3, linkedList);
                AppMethodBeat.o(27326);
            } else {
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.this.contact.field_username);
                String nullAs = Kn != null ? Util.nullAs(Kn.fuY, "") : "";
                Log.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", NormalUserFooterPreference.this.contact.field_username, stringExtra3, nullAs);
                if (!TextUtils.isEmpty(nullAs)) {
                    aVar.beC(nullAs);
                    aVar.d(NormalUserFooterPreference.this.contact.field_username, stringExtra3, linkedList);
                    AppMethodBeat.o(27326);
                    return;
                }
                ay.a.iDq.a(NormalUserFooterPreference.this.contact.field_username, stringExtra3, new ay.b.a() {
                    /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.AnonymousClass5 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(String str, boolean z) {
                        AppMethodBeat.i(27322);
                        bg.aVF();
                        as Kn = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.this.contact.field_username);
                        aVar.beC(Kn != null ? Util.nullAs(Kn.fuY, "") : "");
                        aVar.d(NormalUserFooterPreference.this.contact.field_username, stringExtra3, linkedList);
                        AppMethodBeat.o(27322);
                    }
                });
                AppMethodBeat.o(27326);
            }
        }

        private void eES() {
            AppMethodBeat.i(27327);
            String stringExtra = NormalUserFooterPreference.this.gte.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = NormalUserFooterPreference.this.gte.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String nullAsNil = Util.nullAsNil(stringExtra);
            String nullAsNil2 = Util.nullAsNil(stringExtra2);
            if (!nullAsNil.equals("") || !nullAsNil2.equals("")) {
                com.tencent.mm.plugin.account.friend.a.a SU = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(nullAsNil);
                if (SU == null) {
                    SU = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(nullAsNil2);
                } else {
                    nullAsNil2 = nullAsNil;
                }
                if (SU == null) {
                    AppMethodBeat.o(27327);
                    return;
                }
                com.tencent.mm.plugin.account.a.getAddrUploadStg().a(nullAsNil2, SU);
            }
            AppMethodBeat.o(27327);
        }

        static /* synthetic */ void a(c cVar, String str) {
            com.tencent.mm.plugin.account.friend.a.a SR;
            AppMethodBeat.i(179653);
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.NormalUserFooterPreference", "addContact respUsername is empty");
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(931, 21);
            }
            if (((int) NormalUserFooterPreference.this.contact.gMZ) == 0) {
                if (!Util.isNullOrNil(str)) {
                    NormalUserFooterPreference.this.contact.setUsername(str);
                }
                bg.aVF();
                com.tencent.mm.model.c.aSN().aq(NormalUserFooterPreference.this.contact);
                bg.aVF();
                com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.this.contact.field_username);
            }
            if (((int) NormalUserFooterPreference.this.contact.gMZ) <= 0) {
                Log.e("MicroMsg.NormalUserFooterPreference", "addContact : insert contact failed");
                AppMethodBeat.o(179653);
                return;
            }
            if (!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.this.contact.field_type) && NormalUserFooterPreference.this.kgm == 15 && (SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(NormalUserFooterPreference.this.contact.field_username)) != null) {
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[4];
                objArr[0] = NormalUserFooterPreference.this.contact.field_username;
                objArr[1] = 3;
                objArr[2] = Integer.valueOf(Util.isNullOrNil(SR.getMd5()) ? 0 : 1);
                objArr[3] = Integer.valueOf(com.tencent.mm.contact.a.f(NormalUserFooterPreference.this.contact));
                hVar.a(12040, objArr);
            }
            ab.B(NormalUserFooterPreference.this.contact);
            NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
            bg.aVF();
            normalUserFooterPreference.contact = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.this.contact.field_username);
            cVar.eEM();
            au.aI(NormalUserFooterPreference.this.contact.field_encryptUsername, 0);
            re reVar = new re();
            reVar.dXU.username = NormalUserFooterPreference.this.contact.field_encryptUsername;
            reVar.dXU.type = 1;
            EventCenter.instance.publish(reVar);
            AppMethodBeat.o(179653);
        }
    }

    class g extends a {
        public g() {
            super();
        }

        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEO() {
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a
        public final void eEM() {
            boolean z = true;
            AppMethodBeat.i(27333);
            Assert.assertTrue(!z.Im(NormalUserFooterPreference.this.contact.field_username));
            if (ab.JE(NormalUserFooterPreference.this.contact.field_username)) {
                z = false;
            }
            Assert.assertTrue(z);
            NormalUserFooterPreference.this.Bhj.setVisibility(8);
            NormalUserFooterPreference.this.Bhq.setVisibility(8);
            NormalUserFooterPreference.this.han.setText(R.string.bfb);
            NormalUserFooterPreference.this.han.setVisibility(0);
            NormalUserFooterPreference.this.Bhu.setVisibility(8);
            NormalUserFooterPreference.this.Bht.setVisibility(8);
            NormalUserFooterPreference.this.Bhx.setVisibility(8);
            AppMethodBeat.o(27333);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(27360);
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(27360);
            return;
        }
        if (this.contact != null && (str.equals(this.contact.field_username) || str.equals(this.contact.field_encryptUsername))) {
            bg.aVF();
            this.contact = com.tencent.mm.model.c.aSN().Kn(this.contact.field_username);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(27291);
                    NormalUserFooterPreference.this.eEJ();
                    AppMethodBeat.o(27291);
                }
            });
        }
        AppMethodBeat.o(27360);
    }

    public final void eEK() {
        AppMethodBeat.i(27361);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.gte, "android.permission.RECORD_AUDIO", 82, "", "");
        Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this.gte);
        if (!a2) {
            AppMethodBeat.o(27361);
            return;
        }
        zj zjVar = new zj();
        zjVar.efx.dKy = 5;
        zjVar.efx.talker = this.contact.field_username;
        zjVar.efx.context = this.gte;
        zjVar.efx.eft = 4;
        EventCenter.instance.publish(zjVar);
        AppMethodBeat.o(27361);
    }

    public final void eEL() {
        AppMethodBeat.i(27362);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.gte, "android.permission.CAMERA", 19, "", "");
        Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this.gte);
        if (!a2) {
            AppMethodBeat.o(27362);
            return;
        }
        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(this.gte, "android.permission.RECORD_AUDIO", 19, "", "");
        Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a3), Util.getStack(), this.gte);
        if (!a3) {
            AppMethodBeat.o(27362);
            return;
        }
        zj zjVar = new zj();
        zjVar.efx.dKy = 5;
        zjVar.efx.talker = this.contact.field_username;
        zjVar.efx.context = this.gte;
        zjVar.efx.eft = 2;
        EventCenter.instance.publish(zjVar);
        AppMethodBeat.o(27362);
    }
}
