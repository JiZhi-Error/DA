package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI extends MMActivity implements i {
    private ah gtd;
    private String gwF;
    private b gzb;
    private String gzc;
    private String gzd;
    private String gze;
    private String gzf;
    private String gzg;
    private String gzh;
    private String gzi;
    private String gzj;
    private String gzk;
    private long gzl;
    private long gzm;
    private String gzn;
    private String gzo;
    private TextView gzp;
    private TextView gzq;
    private ImageView gzr;
    private TextView gzs;
    private TextView gzt;
    private TextView gzu;
    private GridView gzv;
    private boolean gzw = false;
    private boolean gzx = false;
    private boolean gzy = false;
    private q tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12816);
        super.onCreate(bundle);
        Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
        setMMTitle(getString(R.string.cj));
        this.gzl = getIntent().getLongExtra("msgLocalId", 0);
        this.gzm = getIntent().getLongExtra("msgSvrId", 0);
        this.gzh = getIntent().getStringExtra("invitertitle");
        this.gzi = getIntent().getStringExtra("inviterusername");
        this.gzj = getIntent().getStringExtra("inviterappid");
        this.gzk = getIntent().getStringExtra("inviterdescid");
        this.gzn = getIntent().getStringExtra("chatroom");
        this.gzo = getIntent().getStringExtra("invitationreason");
        this.gwF = getIntent().getStringExtra("ticket");
        this.gzd = getIntent().getStringExtra(ch.COL_USERNAME);
        this.gzc = getIntent().getStringExtra("nickname");
        this.gze = getIntent().getStringExtra("descid");
        this.gzf = getIntent().getStringExtra("appid");
        this.gzg = getIntent().getStringExtra("headimgurl");
        this.gtd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(Util.nullAsNil(this.gzn));
        this.gzb = new b(this);
        String[] split = this.gzd.split(",");
        if (split != null && split.length > 0) {
            String str = split[0];
            Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", str, this.gzn);
            if (this.gtd.bax() != null && this.gtd.bax().contains(str)) {
                ca Hb = ((l) g.af(l.class)).eiy().Hb(this.gzl);
                if (!Hb.gDO()) {
                    Hb.gDM();
                    ((l) g.af(l.class)).eiy().a(this.gzl, Hb);
                }
            }
        }
        initView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12804);
                SeeAccessVerifyInfoUI.this.finish();
                AppMethodBeat.o(12804);
                return true;
            }
        });
        AppMethodBeat.o(12816);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(12817);
        Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
        g.aAg().hqi.a(u.CTRL_INDEX, this);
        super.onResume();
        AppMethodBeat.o(12817);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12818);
        super.onDestroy();
        g.aAg().hqi.b(u.CTRL_INDEX, this);
        AppMethodBeat.o(12818);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bpa;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        SpannableString spannableString = null;
        AppMethodBeat.i(12819);
        this.gzp = (TextView) findViewById(R.id.e04);
        this.gzq = (TextView) findViewById(R.id.e03);
        this.gzs = (TextView) findViewById(R.id.h8q);
        this.gzt = (TextView) findViewById(R.id.h8s);
        this.gzr = (ImageView) findViewById(R.id.h8t);
        this.gzu = (TextView) findViewById(R.id.bi);
        this.gzv = (GridView) findViewById(R.id.a2l);
        this.gzv.setAdapter((ListAdapter) this.gzb);
        if (this.gzr != null) {
            this.gzr.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(12805);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    as Kn = ((l) g.af(l.class)).aSN().Kn(Util.nullAsNil(SeeAccessVerifyInfoUI.this.gzi));
                    String str = Kn.field_nickname;
                    String str2 = null;
                    if (SeeAccessVerifyInfoUI.this.gtd != null) {
                        str2 = SeeAccessVerifyInfoUI.this.gtd.getDisplayName(SeeAccessVerifyInfoUI.this.gzi);
                    }
                    if (Util.isNullOrNil(str2)) {
                        str2 = Kn.arJ();
                    }
                    SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.this.gzi, str2, str, false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(12805);
                }
            });
        }
        this.gzv.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.gzv.postDelayed(new Runnable() {
            /* class com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(12806);
                int i2 = 0;
                if (SeeAccessVerifyInfoUI.this.gzs != null) {
                    if (SeeAccessVerifyInfoUI.this.gzw) {
                        i2 = (int) (((float) (SeeAccessVerifyInfoUI.this.gzs.getHeight() * 2)) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.dimen.k) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.dimen.ij));
                    } else {
                        i2 = (int) (((float) SeeAccessVerifyInfoUI.this.gzs.getHeight()) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.dimen.k) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.dimen.ij));
                    }
                }
                if (SeeAccessVerifyInfoUI.this.gzb.getCount() / 4 > 0) {
                    i2 *= (SeeAccessVerifyInfoUI.this.gzb.getCount() / 4) + 1;
                }
                SeeAccessVerifyInfoUI.this.gzv.setLayoutParams(new LinearLayout.LayoutParams(SeeAccessVerifyInfoUI.this.gzv.getWidth(), i2));
                AppMethodBeat.o(12806);
            }
        }, 100);
        if (this.gzr != null) {
            a.b.c(this.gzr, Util.nullAsNil(this.gzi));
        }
        if (this.gzs != null) {
            TextView textView = this.gzs;
            String nullAsNil = Util.nullAsNil(this.gzi);
            TextView textView2 = this.gzs;
            if (textView2 != null) {
                as Kn = ((l) g.af(l.class)).aSN().Kn(Util.nullAsNil(nullAsNil));
                if (Kn == null) {
                    Log.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
                } else {
                    if (!Util.isNullOrNil(Kn.field_conRemark)) {
                        str = Kn.field_conRemark;
                    } else if (this.gtd != null) {
                        str = this.gtd.getDisplayName(nullAsNil);
                    } else {
                        str = null;
                    }
                    if (Util.isNullOrNil(str)) {
                        str = Kn.field_conRemark;
                    }
                    if (Util.isNullOrNil(str)) {
                        str = Kn.arI();
                    }
                    spannableString = com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(str), textView2.getTextSize());
                }
            }
            textView.setText(spannableString);
        }
        if (this.gzt != null) {
            if (!ab.Iy(this.gzn) || !as.bjp(this.gzi)) {
                this.gzt.setVisibility(8);
            } else {
                e eVar = new e();
                eVar.field_appid = this.gzj;
                eVar.field_wordingId = this.gzk;
                eVar.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
                g.aAi();
                ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().get(eVar, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                if (!TextUtils.isEmpty(eVar.field_wording)) {
                    this.gzt.setVisibility(0);
                    this.gzt.setText("＠" + eVar.field_wording);
                } else {
                    if (!Util.isNullOrNil(this.gzk) && !Util.isNullOrNil(this.gzj)) {
                        this.gzy = true;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(this.gzk);
                        g.aAg().hqi.a(new com.tencent.mm.openim.b.i(this.gzj, eVar.field_language, linkedList), 0);
                    }
                    this.gzt.setVisibility(4);
                }
            }
        }
        if (this.gzp != null) {
            this.gzp.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, Util.nullAsNil(this.gzh)));
        }
        if (this.gzq != null && !Util.isNullOrNil(this.gzo)) {
            this.gzq.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, "\"" + Util.nullAsNil(this.gzo) + "\""));
        }
        if (this.gzu != null) {
            this.gzu.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(12809);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
                    AppCompatActivity context = SeeAccessVerifyInfoUI.this.getContext();
                    SeeAccessVerifyInfoUI.this.getString(R.string.zb);
                    seeAccessVerifyInfoUI.tipDialog = h.a((Context) context, SeeAccessVerifyInfoUI.this.getString(R.string.ck), false, (DialogInterface.OnCancelListener) null);
                    if (ab.Iy(SeeAccessVerifyInfoUI.this.gzn)) {
                        com.tencent.mm.openim.c.a.a aVar = new com.tencent.mm.openim.c.a.a(SeeAccessVerifyInfoUI.this.gzi, SeeAccessVerifyInfoUI.this.gzn, SeeAccessVerifyInfoUI.this.gwF, new LinkedList(Util.stringToList(SeeAccessVerifyInfoUI.this.gzd, ",")));
                        aVar.iLA = true;
                        aVar.aYI().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a<Void, c.a<hd>>() {
                            /* class com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.AnonymousClass5.AnonymousClass1 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ Void call(c.a<hd> aVar) {
                                AppMethodBeat.i(12807);
                                c.a<hd> aVar2 = aVar;
                                if (SeeAccessVerifyInfoUI.this.tipDialog != null && SeeAccessVerifyInfoUI.this.tipDialog.isShowing()) {
                                    SeeAccessVerifyInfoUI.this.tipDialog.dismiss();
                                }
                                com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(aVar2.errMsg);
                                if (Dk != null) {
                                    Dk.a(SeeAccessVerifyInfoUI.this, null, null);
                                } else if (aVar2.errType == 0 && aVar2.errCode == 0) {
                                    if (aVar2.dGJ.getType() == 941) {
                                        ca Hb = ((l) g.af(l.class)).eiy().Hb(SeeAccessVerifyInfoUI.this.gzl);
                                        Hb.gDM();
                                        ((l) g.af(l.class)).eiy().b(Hb.field_msgSvrId, Hb);
                                        SeeAccessVerifyInfoUI.this.gzu.setBackgroundResource(R.drawable.k9);
                                        SeeAccessVerifyInfoUI.this.gzu.setTextColor(SeeAccessVerifyInfoUI.this.getResources().getColor(R.color.u4));
                                        SeeAccessVerifyInfoUI.this.gzu.setText(SeeAccessVerifyInfoUI.this.getString(R.string.dzk));
                                        SeeAccessVerifyInfoUI.this.gzu.setEnabled(false);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 23, 1, true);
                                    }
                                } else if (aVar2.dGJ.getType() == 941) {
                                    Log.i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", 941, Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Util.nullAsNil(aVar2.errMsg));
                                    h.c(SeeAccessVerifyInfoUI.this.getContext(), SeeAccessVerifyInfoUI.this.getString(R.string.ci), SeeAccessVerifyInfoUI.this.getString(R.string.zb), true);
                                }
                                Void r0 = QZL;
                                AppMethodBeat.o(12807);
                                return r0;
                            }
                        });
                    } else {
                        com.tencent.mm.chatroom.d.c cVar = new com.tencent.mm.chatroom.d.c(SeeAccessVerifyInfoUI.this.gzm, SeeAccessVerifyInfoUI.this.gzi, SeeAccessVerifyInfoUI.this.gzn, SeeAccessVerifyInfoUI.this.gwF, new LinkedList(Util.stringsToList(SeeAccessVerifyInfoUI.this.gzd.split(","))));
                        cVar.iLA = true;
                        cVar.aYI().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a<Void, c.a<hb>>() {
                            /* class com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.AnonymousClass5.AnonymousClass2 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ Void call(c.a<hb> aVar) {
                                AppMethodBeat.i(12808);
                                c.a<hb> aVar2 = aVar;
                                if (SeeAccessVerifyInfoUI.this.tipDialog != null && SeeAccessVerifyInfoUI.this.tipDialog.isShowing()) {
                                    SeeAccessVerifyInfoUI.this.tipDialog.dismiss();
                                }
                                com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(aVar2.errMsg);
                                if (Dk != null) {
                                    Dk.a(SeeAccessVerifyInfoUI.this, null, null);
                                } else if (aVar2.errType == 0 && aVar2.errCode == 0) {
                                    if (aVar2.dGJ.getType() == 774) {
                                        ca Hb = ((l) g.af(l.class)).eiy().Hb(SeeAccessVerifyInfoUI.this.gzl);
                                        Hb.gDM();
                                        ((l) g.af(l.class)).eiy().b(Hb.field_msgSvrId, Hb);
                                        SeeAccessVerifyInfoUI.this.gzu.setBackgroundResource(R.drawable.k9);
                                        SeeAccessVerifyInfoUI.this.gzu.setTextColor(SeeAccessVerifyInfoUI.this.getResources().getColor(R.color.u4));
                                        SeeAccessVerifyInfoUI.this.gzu.setText(SeeAccessVerifyInfoUI.this.getString(R.string.dzk));
                                        SeeAccessVerifyInfoUI.this.gzu.setEnabled(false);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 23, 1, true);
                                    }
                                } else if (aVar2.dGJ.getType() == 774) {
                                    Log.i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", 774, Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Util.nullAsNil(aVar2.errMsg));
                                    h.c(SeeAccessVerifyInfoUI.this.getContext(), SeeAccessVerifyInfoUI.this.getString(R.string.ci), SeeAccessVerifyInfoUI.this.getString(R.string.zb), true);
                                }
                                Void r0 = QZL;
                                AppMethodBeat.o(12808);
                                return r0;
                            }
                        });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(12809);
                }
            });
        }
        if (this.gzu != null && ((l) g.af(l.class)).eiy().Hb(this.gzl).gDO()) {
            this.gzu.setBackgroundResource(R.drawable.k9);
            this.gzu.setTextColor(getResources().getColor(R.color.u4));
            this.gzu.setText(getString(R.string.dzk));
            this.gzu.setEnabled(false);
        }
        AppMethodBeat.o(12819);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(12820);
        if ((qVar instanceof com.tencent.mm.openim.b.i) && i2 == 0 && i3 == 0) {
            if (this.gzy && Util.isNullOrNil(this.gzt.getText())) {
                this.gzy = false;
                e eVar = new e();
                eVar.field_appid = this.gzj;
                eVar.field_wordingId = this.gzk;
                eVar.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
                g.aAi();
                ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().get(eVar, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                if (!TextUtils.isEmpty(eVar.field_wording)) {
                    this.gzt.setVisibility(0);
                    this.gzt.setText("＠" + eVar.field_wording);
                } else {
                    if (!Util.isNullOrNil(this.gzk) && !Util.isNullOrNil(this.gzj)) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(this.gzk);
                        g.aAg().hqi.a(new com.tencent.mm.openim.b.i(this.gzj, eVar.field_language, linkedList), 0);
                    }
                    this.gzt.setVisibility(4);
                }
            }
            if (this.gzx) {
                this.gzb.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(12820);
    }

    public class a {
        String dNI;
        String gzB;
        String gzC;
        String nickname;
        String username;

        a(String str, String str2, String str3, String str4, String str5) {
            this.username = str;
            this.nickname = str2;
            this.dNI = str3;
            this.gzB = str4;
            this.gzC = str5;
        }
    }

    public class b extends BaseAdapter {
        List<a> gzD = new ArrayList();
        private com.tencent.mm.av.a.a.c gzE = null;
        Context mContext;

        public b(Context context) {
            AppMethodBeat.i(12811);
            this.mContext = context;
            anb();
            c.a aVar = new c.a();
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.jbq = R.raw.default_avatar;
            this.gzE = aVar.bdv();
            AppMethodBeat.o(12811);
        }

        private void anb() {
            String[] strArr;
            String[] strArr2;
            String[] strArr3;
            AppMethodBeat.i(12812);
            if (!Util.isNullOrNil(SeeAccessVerifyInfoUI.this.gzd)) {
                String[] split = SeeAccessVerifyInfoUI.this.gzd.split(",");
                if (!Util.isNullOrNil(SeeAccessVerifyInfoUI.this.gzc)) {
                    String[] split2 = SeeAccessVerifyInfoUI.this.gzc.split(",");
                    if (!Util.isNullOrNil(SeeAccessVerifyInfoUI.this.gzf)) {
                        strArr = SeeAccessVerifyInfoUI.this.gzf.split(",");
                    } else {
                        Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesAppids null");
                        strArr = null;
                    }
                    if (!Util.isNullOrNil(SeeAccessVerifyInfoUI.this.gze)) {
                        strArr2 = SeeAccessVerifyInfoUI.this.gze.split(",");
                    } else {
                        Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesDescids null");
                        strArr2 = null;
                    }
                    if (!Util.isNullOrNil(SeeAccessVerifyInfoUI.this.gzg)) {
                        strArr3 = SeeAccessVerifyInfoUI.this.gzg.split(",");
                    } else {
                        Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
                        strArr3 = null;
                    }
                    this.gzD.clear();
                    int i2 = 0;
                    while (i2 < split.length) {
                        this.gzD.add(new a(split[i2], (split2.length <= i2 || Util.isNullOrNil(split2[i2])) ? split[i2] : split2[i2], (strArr == null || strArr.length <= i2 || Util.isNullOrNil(strArr[i2])) ? "" : strArr[i2], (strArr2 == null || strArr2.length <= i2 || Util.isNullOrNil(strArr2[i2])) ? "" : strArr2[i2], (strArr3 == null || strArr3.length <= i2 || Util.isNullOrNil(strArr3[i2])) ? "" : strArr3[i2]));
                        i2++;
                    }
                    AppMethodBeat.o(12812);
                    return;
                }
                Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
                AppMethodBeat.o(12812);
                return;
            }
            Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
            AppMethodBeat.o(12812);
        }

        public final int getCount() {
            AppMethodBeat.i(12813);
            int size = this.gzD.size();
            AppMethodBeat.o(12813);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(12814);
            a aVar = this.gzD.get(i2);
            AppMethodBeat.o(12814);
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(final int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(12815);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.bnf, null);
                cVar = SeeAccessVerifyInfoUI.this.ci(view);
            } else {
                c cVar2 = (c) view.getTag();
                if (cVar2 == null) {
                    cVar = SeeAccessVerifyInfoUI.this.ci(view);
                } else {
                    cVar = cVar2;
                }
            }
            cVar.gvv.setVisibility(0);
            cVar.gzG.setVisibility(0);
            com.tencent.mm.av.q.bcV().a(this.gzD.get(i2).gzC, cVar.gvv, this.gzE);
            cVar.gzG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, Util.nullAsNil(this.gzD.get(i2).nickname), cVar.gzG.getTextSize()));
            if (as.bjp(this.gzD.get(i2).username)) {
                SeeAccessVerifyInfoUI.this.gzw = true;
                e eVar = new e();
                eVar.field_appid = Util.nullAsNil(this.gzD.get(i2).dNI);
                eVar.field_wordingId = Util.nullAsNil(this.gzD.get(i2).gzB);
                eVar.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
                g.aAi();
                ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().get(eVar, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                if (!TextUtils.isEmpty(eVar.field_wording)) {
                    cVar.gzH.setVisibility(0);
                    cVar.gzH.setText("＠" + eVar.field_wording);
                } else {
                    if (!Util.isNullOrNil(eVar.field_appid) && !Util.isNullOrNil(eVar.field_wordingId)) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(eVar.field_wordingId);
                        if (!Util.isEqual(cVar.gzH.getTag(), "first")) {
                            SeeAccessVerifyInfoUI.this.gzx = true;
                            g.aAg().hqi.a(new com.tencent.mm.openim.b.i(eVar.field_appid, eVar.field_language, linkedList), 0);
                        }
                    }
                    cVar.gzH.setVisibility(4);
                    cVar.gzH.setTag("first");
                }
            } else {
                cVar.gzH.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.b.AnonymousClass1 */

                public final void onClick(View view) {
                    String str;
                    AppMethodBeat.i(12810);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$InviteesAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    String str2 = b.this.gzD.get(i2).nickname;
                    String str3 = null;
                    if (SeeAccessVerifyInfoUI.this.gtd != null) {
                        str3 = SeeAccessVerifyInfoUI.this.gtd.getDisplayName(b.this.gzD.get(i2).username);
                    }
                    if (Util.isNullOrNil(str3)) {
                        str = ((l) g.af(l.class)).aSN().Kn(Util.nullAsNil(b.this.gzD.get(i2).username)).arJ();
                    } else {
                        str = str3;
                    }
                    SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, b.this.gzD.get(i2).username, str, str2, true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$InviteesAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(12810);
                }
            });
            AppMethodBeat.o(12815);
            return view;
        }
    }

    /* access modifiers changed from: protected */
    public final c ci(View view) {
        AppMethodBeat.i(12821);
        c cVar = new c();
        cVar.gvv = (ImageView) view.findViewById(R.id.h8t);
        cVar.gzG = (TextView) view.findViewById(R.id.h8q);
        cVar.gzH = (TextView) view.findViewById(R.id.h8s);
        AppMethodBeat.o(12821);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public class c {
        public ImageView gvv;
        public TextView gzG;
        public TextView gzH;

        c() {
        }
    }

    static /* synthetic */ void a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3, boolean z) {
        cn aEZ;
        AppMethodBeat.i(12822);
        if (Util.isNullOrNil(str2) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(str)) != null && !Util.isNullOrNil(aEZ.field_encryptUsername)) {
            str2 = aEZ.field_conRemark;
        }
        if (!Util.isNullOrNil(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            Log.i("MicroMsg.SeeAccessVerifyInfoUI", "mTicket:%s", seeAccessVerifyInfoUI.gwF);
            intent.putExtra("key_add_contact_verify_ticket", seeAccessVerifyInfoUI.gwF);
            if (seeAccessVerifyInfoUI.gtd != null) {
                intent.putExtra("Contact_RoomNickname", seeAccessVerifyInfoUI.gtd.getDisplayName(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeAccessVerifyInfoUI.gzn);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 16);
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                uj ujVar = new uj();
                ujVar.eaI.intent = intent;
                ujVar.eaI.username = str;
                EventCenter.instance.publish(ujVar);
            }
            if (Kn != null && Kn.gBM()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, Kn.field_username + ",14");
            }
            if (z) {
                intent.putExtra("Contact_Scene", 96);
            } else {
                intent.putExtra("Contact_Scene", 14);
            }
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeAccessVerifyInfoUI.gzn);
            com.tencent.mm.br.c.b(seeAccessVerifyInfoUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(12822);
    }
}
