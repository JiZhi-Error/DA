package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;

public class ContactMoreInfoUI extends MMActivity implements View.OnClickListener, l {
    private long BeA;
    private String BeB;
    String BeC = null;
    private ProfileNormalItemView Beo;
    private ProfileNormalItemView Bep;
    private ProfileNormalItemView Beq;
    private ProfileNormalItemView Ber;
    private ProfileNormalItemView Bes;
    private ProfileNormalItemView Bet;
    private ProfileNormalItemView Beu;
    private ProfileNormalItemView Bev;
    private String Bew;
    private String Bex;
    private String Bey;
    private String Bez;
    private String goe;
    ah gtd;
    private String gwx;
    boolean gxS = false;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private as rjX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactMoreInfoUI() {
        AppMethodBeat.i(27031);
        AppMethodBeat.o(27031);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.xr;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27032);
        super.onCreate(bundle);
        this.gxS = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.gwx = getIntent().getStringExtra("Contact_ChatRoomId");
        this.goe = getIntent().getStringExtra("Contact_User");
        bg.aVF();
        this.rjX = c.aSN().Kn(this.goe);
        this.Bew = getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.Bex = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        this.Bey = getIntent().getStringExtra("verify_gmail");
        this.Bez = getIntent().getStringExtra("profileName");
        if (!Util.isNullOrNil(this.gwx)) {
            bg.aVF();
            this.gtd = c.aSX().Kd(this.gwx);
        }
        initView();
        AppMethodBeat.o(27032);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        String string;
        String string2;
        AppMethodBeat.i(27033);
        super.initView();
        setMMTitle(R.string.wp);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27026);
                ContactMoreInfoUI.this.finish();
                AppMethodBeat.o(27026);
                return true;
            }
        });
        this.Beo = (ProfileNormalItemView) findViewById(R.id.ecg);
        this.Bep = (ProfileNormalItemView) findViewById(R.id.dkl);
        this.Beq = (ProfileNormalItemView) findViewById(R.id.gmh);
        this.Ber = (ProfileNormalItemView) findViewById(R.id.brq);
        this.Ber.setVisibility(8);
        this.Ber.mTitle = getString(R.string.bag);
        this.Beu = (ProfileNormalItemView) findViewById(R.id.hs3);
        this.Beu.UO(R.string.bfk);
        this.Beu.Bau.setSingleLine(false);
        this.Bev = (ProfileNormalItemView) findViewById(R.id.dav);
        this.Bev.UO(R.string.bgz);
        this.Bet = (ProfileNormalItemView) findViewById(R.id.jmt);
        this.Bes = (ProfileNormalItemView) findViewById(R.id.b9r);
        this.Bes.Bie.setVisibility(0);
        String value = h.aqJ().getValue("LinkedinPluginClose");
        if (!(Util.isNullOrNil(value) || Util.getInt(value, 0) == 0) || Util.isNullOrNil(this.rjX.fuT)) {
            this.Beo.setVisibility(8);
        } else {
            this.Beo.setVisibility(0);
            if (Util.isNullOrNil(this.Bew)) {
                this.Bew = this.rjX.fuU;
            }
            ProfileNormalItemView profileNormalItemView = this.Beo;
            profileNormalItemView.Bic = this.Bew;
            profileNormalItemView.Bid = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27028);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (Util.isNullOrNil(ContactMoreInfoUI.this.Bex)) {
                        ContactMoreInfoUI.this.Bex = ContactMoreInfoUI.this.rjX.fuV;
                    }
                    if (!Util.isNullOrNil(ContactMoreInfoUI.this.Bex)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", ContactMoreInfoUI.this.Bex);
                        intent.putExtra("geta8key_username", z.aTY());
                        com.tencent.mm.br.c.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                    a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27028);
                }
            };
            profileNormalItemView.UQ(getResources().getColor(R.color.a4e)).eEV();
        }
        this.Bep.setVisibility(0);
        ProfileNormalItemView profileNormalItemView2 = this.Bep;
        profileNormalItemView2.Bic = this.Bey;
        profileNormalItemView2.eEV();
        bg.aVF();
        int nullAsNil = Util.nullAsNil((Integer) c.azQ().get(9, (Object) null));
        this.BeA = getIntent().getLongExtra("Contact_Uin", 0);
        this.BeB = getIntent().getStringExtra("Contact_QQNick");
        if (this.BeA == 0 || nullAsNil == 0) {
            this.Beq.setVisibility(8);
        } else {
            if (this.BeB == null || this.BeB.length() == 0) {
                com.tencent.mm.plugin.account.friend.a.as AT = com.tencent.mm.plugin.account.a.getQQListStg().AT(this.BeA);
                if (AT == null) {
                    AT = null;
                }
                if (AT != null) {
                    this.BeB = AT.getDisplayName();
                }
            }
            this.Beq.setVisibility(0);
            ProfileNormalItemView profileNormalItemView3 = this.Beq;
            profileNormalItemView3.Bic = Util.nullAsNil(this.BeB) + " " + new p(this.BeA).longValue();
            profileNormalItemView3.Bid = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27029);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27029);
                }
            };
            profileNormalItemView3.eEV();
        }
        ProfileNormalItemView profileNormalItemView4 = this.Beu;
        profileNormalItemView4.Bic = com.tencent.mm.pluginsdk.ui.span.l.c(this, this.rjX.signature);
        profileNormalItemView4.eEV();
        Log.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", Integer.valueOf(this.rjX.getSource()));
        switch (this.rjX.getSource()) {
            case 1:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bgm);
                    break;
                } else {
                    this.Bev.UP(R.string.bgn);
                    break;
                }
            case 3:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bgp);
                    break;
                } else {
                    this.Bev.UP(R.string.bgq);
                    break;
                }
            case 4:
            case 12:
                this.Bev.UP(R.string.ddi);
                break;
            case 8:
            case 14:
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.rjX.field_sourceExtInfo);
                if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
                    str = null;
                } else if (Util.isNullOrNil(Kn.field_nickname)) {
                    str = v.HV(Kn.field_username);
                } else {
                    str = Kn.field_nickname;
                }
                if (this.rjX.arL() <= 1000000) {
                    if (!Util.isNullOrNil(str)) {
                        string = getString(R.string.bg9, new Object[]{str});
                    } else {
                        string = getString(R.string.bg7);
                    }
                    this.Bev.Bic = string;
                    break;
                } else {
                    if (!Util.isNullOrNil(str)) {
                        string2 = getString(R.string.bg_, new Object[]{str});
                    } else {
                        string2 = getString(R.string.bg8);
                    }
                    ProfileNormalItemView profileNormalItemView5 = this.Bev;
                    profileNormalItemView5.Bau.setMaxLines(5);
                    profileNormalItemView5.Bau.setEllipsize(TextUtils.TruncateAt.END);
                    this.Bev.Bic = string2;
                    break;
                }
                break;
            case 10:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bgv);
                    break;
                } else {
                    this.Bev.UP(R.string.bgw);
                    break;
                }
            case 13:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bgv);
                    break;
                } else {
                    this.Bev.UP(R.string.bgw);
                    break;
                }
            case 15:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bgj);
                    break;
                } else {
                    this.Bev.UP(R.string.bgk);
                    break;
                }
            case 17:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bg1);
                    break;
                } else {
                    this.Bev.UP(R.string.bg4);
                    break;
                }
            case 18:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bga);
                    break;
                } else {
                    this.Bev.UP(R.string.bgb);
                    break;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bgs);
                    break;
                } else {
                    this.Bev.UP(R.string.bgt);
                    break;
                }
            case 25:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bfy);
                    break;
                } else {
                    this.Bev.UP(R.string.bfz);
                    break;
                }
            case 30:
                if (this.rjX.arL() <= 1000000) {
                    this.Bev.UP(R.string.bgf);
                    break;
                } else {
                    this.Bev.UP(R.string.bgg);
                    break;
                }
            case 34:
                this.Bev.UP(R.string.bfw);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                this.Bev.UP(R.string.bgi);
                break;
            case 58:
            case bv.CTRL_INDEX:
            case 60:
                this.Bev.UP(R.string.du0);
                break;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                this.Bev.UP(R.string.bgd);
                break;
            default:
                this.Bev.Bic = null;
                break;
        }
        this.Bev.eEV();
        Z(this.rjX);
        if (!this.rjX.field_username.equals(z.aTY())) {
            as asVar = this.rjX;
            if (asVar.field_username.equals(z.aTY())) {
                this.Bes.setVisibility(8);
                AppMethodBeat.o(27033);
                return;
            }
            if (asVar.fuA == 1) {
                this.Bes.UO(R.string.ba7);
            } else if (asVar.fuA == 2) {
                this.Bes.UO(R.string.ba6);
            } else {
                this.Bes.UO(R.string.baa);
            }
            this.Bes.eEV();
            j jVar = new j();
            jVar.query = asVar.field_username;
            jVar.wWZ = this;
            jVar.handler = this.handler;
            jVar.kXb = 5;
            ((n) g.ah(n.class)).search(2, jVar);
        }
        AppMethodBeat.o(27033);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Z(com.tencent.mm.storage.as r8) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.Z(com.tencent.mm.storage.as):boolean");
    }

    @Override // com.tencent.mm.plugin.fts.a.l
    public final void b(k kVar) {
        AppMethodBeat.i(27035);
        if (kVar.resultCode == 0) {
            final int intValue = ((Integer) kVar.wXb.get(0).userData).intValue();
            this.Bes.Bic = getString(R.string.ba_, new Object[]{Integer.valueOf(intValue)});
            this.Bes.Bid = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27030);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    e.Nl(intValue);
                    if (intValue > 0) {
                        Intent intent = new Intent(ContactMoreInfoUI.this, CommonChatroomInfoUI.class);
                        intent.putExtra("Select_Talker_Name", ContactMoreInfoUI.this.rjX.field_username);
                        ContactMoreInfoUI contactMoreInfoUI = ContactMoreInfoUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        a.a(contactMoreInfoUI, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        contactMoreInfoUI.startActivity((Intent) bl.pG(0));
                        a.a(contactMoreInfoUI, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27030);
                }
            };
        } else {
            this.Bes.Bic = getString(R.string.ba_, new Object[]{0});
        }
        this.Bes.eEV();
        AppMethodBeat.o(27035);
    }

    public void onClick(View view) {
        AppMethodBeat.i(27036);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27036);
    }
}
