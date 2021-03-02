package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.al.h;
import com.tencent.mm.al.i;
import com.tencent.mm.api.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMoreInofUI extends MMPreference implements i.b {
    private static final String Bff = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/infringement?username=%s&from=1#wechat_redirect");
    private c Bdk;
    private aeq BeX;
    private String Bfc;
    private boolean Bfd;
    private Bundle Bfg;
    private as contact;
    private boolean dhC = false;
    private List<c.a> dhu;
    private c.b dhv;
    private int kgm;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27549);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        setMMTitle(R.string.b_f);
        setTitleDividerVis(false);
        hideActionbarLine();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27545);
                NewBizInfoMoreInofUI.this.finish();
                AppMethodBeat.o(27545);
                return true;
            }
        });
        String nullAsNil = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
        String nullAsNil2 = Util.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
        int intExtra = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
        int intExtra2 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
        String stringExtra = getIntent().getStringExtra("Contact_KWeibo");
        String stringExtra2 = getIntent().getStringExtra("Contact_KWeiboNick");
        bg.aVF();
        this.contact = com.tencent.mm.model.c.aSN().Kn(nullAsNil);
        if (this.contact == null || ((int) this.contact.gMZ) == 0 || Util.nullAsNil(this.contact.field_username).length() <= 0) {
            this.contact = new as();
            this.contact.setUsername(nullAsNil);
            this.contact.BC(nullAsNil2);
            this.contact.nf(intExtra);
            this.contact.BZ(stringExtra);
            this.contact.ne(intExtra2);
            this.contact.BH(stringExtra2);
        } else if (intExtra != 0) {
            this.contact.nf(intExtra);
        }
        this.Bdk = g.fJ(this.contact.field_username);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("Contact_customInfo");
        try {
            this.BeX = byteArrayExtra == null ? null : (aeq) new aeq().parseFrom(byteArrayExtra);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", e2, "", new Object[0]);
        }
        this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
        this.Bfg = getIntent().getBundleExtra("Contact_Ext_Args");
        initView();
        AppMethodBeat.o(27549);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0434  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x046d  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0587  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x084b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0241  */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 2180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.initView():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.api.c.a eFg() {
        /*
            r6 = this;
            r1 = 0
            r5 = 27551(0x6b9f, float:3.8607E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            java.util.List<com.tencent.mm.api.c$a> r0 = r6.dhu
            if (r0 == 0) goto L_0x0012
            java.util.List<com.tencent.mm.api.c$a> r0 = r6.dhu
            int r0 = r0.size()
            if (r0 >= 0) goto L_0x0020
        L_0x0012:
            java.lang.String r0 = "MicroMsg.NewBizInfoMoreInofUI"
            java.lang.String r2 = "brandInfoList is null not show location"
            com.tencent.mm.sdk.platformtools.Log.w(r0, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            r0 = r1
        L_0x001f:
            return r0
        L_0x0020:
            java.util.List<com.tencent.mm.api.c$a> r0 = r6.dhu
            java.util.Iterator r2 = r0.iterator()
        L_0x0026:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0050
            java.lang.Object r0 = r2.next()
            com.tencent.mm.api.c$a r0 = (com.tencent.mm.api.c.a) r0
            java.lang.String r3 = r0.dhy
            java.lang.String r4 = "__mp_wording__brandinfo_location"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x004c
            r3 = 2131757849(0x7f100b19, float:1.9146645E38)
            java.lang.String r3 = r6.getString(r3)
            java.lang.String r4 = r0.title
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0026
        L_0x004c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x001f
        L_0x0050:
            java.lang.String r0 = "MicroMsg.NewBizInfoMoreInofUI"
            java.lang.String r2 = "brandInfoList is null not show location"
            com.tencent.mm.sdk.platformtools.Log.w(r0, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            r0 = r1
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.eFg():com.tencent.mm.api.c$a");
    }

    private static void c(h hVar) {
        AppMethodBeat.i(27552);
        long currentTimeMillis = System.currentTimeMillis();
        j aYB = p.aYB();
        if (aYB.Mx(hVar.field_openId) == null) {
            com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
            iVar.username = hVar.field_openId;
            iVar.iKW = hVar.field_headImgUrl;
            iVar.fv(false);
            iVar.fuz = 3;
            aYB.b(iVar);
        }
        p.aYD().Mh(hVar.field_openId);
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(27552);
    }

    private void aKr(final String str) {
        AppMethodBeat.i(27553);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.AnonymousClass3 */

            public final void run() {
                Bitmap a2;
                AppMethodBeat.i(27547);
                if (NewBizInfoMoreInofUI.this.screen == null) {
                    Log.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
                    AppMethodBeat.o(27547);
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) NewBizInfoMoreInofUI.this.screen.bmg("contact_info_kf_worker");
                if (!(iconWidgetPreference == null || NewBizInfoMoreInofUI.this.screen == null || (a2 = com.tencent.mm.aj.c.a(str, false, -1, null)) == null)) {
                    Log.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", str);
                    iconWidgetPreference.al(a2);
                    NewBizInfoMoreInofUI.this.screen.notifyDataSetChanged();
                }
                AppMethodBeat.o(27547);
            }
        }, 2000);
        AppMethodBeat.o(27553);
    }

    @Override // com.tencent.mm.al.i.b
    public final String aZT() {
        return "MicroMsg.NewBizInfoMoreInofUI";
    }

    @Override // com.tencent.mm.al.i.b
    public final void e(LinkedList<fbw> linkedList) {
        AppMethodBeat.i(27554);
        ag.bai().b(this);
        if (this.screen == null) {
            Log.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
            AppMethodBeat.o(27554);
        } else if (this.contact == null) {
            Log.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
            AppMethodBeat.o(27554);
        } else if (linkedList == null || linkedList.size() <= 0) {
            Log.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
            AppMethodBeat.o(27554);
        } else {
            if (!Util.isNullOrNil(this.Bfc)) {
                Iterator<fbw> it = linkedList.iterator();
                while (it.hasNext()) {
                    fbw next = it.next();
                    if (next.NxV != null && next.NxV.equals(this.Bfc)) {
                        this.screen.m38do("contact_info_kf_worker", false);
                        this.screen.bmg("contact_info_kf_worker").setSummary(next.Nickname);
                        AppMethodBeat.o(27554);
                        return;
                    }
                }
            }
            this.screen.m38do("contact_info_kf_worker", false);
            this.screen.bmg("contact_info_kf_worker").setSummary(linkedList.get(0).Nickname);
            AppMethodBeat.o(27554);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bp;
    }

    static {
        AppMethodBeat.i(231957);
        AppMethodBeat.o(231957);
    }

    private void bP(int i2, String str) {
        int i3;
        String str2;
        AppMethodBeat.i(27556);
        if (this.Bfg == null || !(this.kgm == 39 || this.kgm == 56 || this.kgm == 35 || this.kgm == 87 || this.kgm == 88 || this.kgm == 89 || this.kgm == 85)) {
            Log.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
            AppMethodBeat.o(27556);
        } else if (this.contact == null) {
            Log.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
            AppMethodBeat.o(27556);
        } else {
            String string = this.Bfg.getString("Contact_Ext_Args_Search_Id");
            String nullAsNil = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Args_Query_String"));
            int i4 = this.Bfg.getInt("Contact_Ext_Args_Index");
            switch (this.kgm) {
                case 35:
                    i3 = 1;
                    break;
                case s.CTRL_INDEX:
                    i3 = 5;
                    break;
                case 87:
                    i3 = 2;
                    break;
                case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                    i3 = 3;
                    break;
                case PlayerException.EXCEPTION_IN_CHECK_STATE /*{ENCODED_INT: 89}*/:
                    i3 = 4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            String nullAsNil2 = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Extra_Params"));
            String str3 = nullAsNil + "," + i2 + "," + Util.nullAsNil(this.contact.field_username) + "," + i4 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i3;
            if (!Util.isNullOrNil(str)) {
                str2 = str3 + "," + str + "," + nullAsNil2;
            } else {
                str2 = str3 + ",," + nullAsNil2;
            }
            Log.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", str2);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10866, str2);
            AppMethodBeat.o(27556);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        Preference bmg;
        int i3 = 6;
        AppMethodBeat.i(27555);
        String str = preference.mKey;
        Log.i("MicroMsg.NewBizInfoMoreInofUI", str + " item has been clicked!");
        if ("contact_info_see_locate".endsWith(str)) {
            c.a eFg = eFg();
            if (eFg == null) {
                Log.e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
                AppMethodBeat.o(27555);
                return false;
            }
            String str2 = eFg.url;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("geta8key_scene", 3);
            intent.putExtra("KPublisherId", "brand_profile");
            intent.putExtra("prePublishId", "brand_profile");
            if ((this.Bfg != null && (this.kgm == 39 || this.kgm == 56 || this.kgm == 35)) || this.kgm == 87 || this.kgm == 89 || this.kgm == 85 || this.kgm == 88) {
                Log.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
                Bundle bundle = new Bundle();
                bundle.putBoolean("KFromBizSearch", true);
                bundle.putBundle("KBizSearchExtArgs", this.Bfg);
                intent.putExtra("jsapiargs", bundle);
                int i4 = com.tencent.mm.contact.c.oR(this.contact.field_type) ? 7 : 6;
                int identifier = getResources().getIdentifier(eFg.dhy, "string", getPackageName());
                String str3 = eFg.title;
                if (identifier > 0) {
                    str3 = getString(identifier);
                }
                bP(i4, str3);
            }
            com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(27555);
            return true;
        } else if ("contact_info_verifyuser".endsWith(str)) {
            c cVar = this.Bdk;
            if (cVar == null) {
                AppMethodBeat.o(27555);
                return true;
            }
            c.b cG = cVar.cG(false);
            if (cG == null) {
                AppMethodBeat.o(27555);
                return true;
            }
            String str4 = null;
            if (cG.Va() != null && !Util.isNullOrNil(cG.Va().dit)) {
                str4 = cG.Va().dit;
            } else if (cG.Vb() != null && !Util.isNullOrNil(cG.Vb().diB)) {
                str4 = cG.Vb().diB;
            }
            if (!Util.isNullOrNil(str4)) {
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str4);
                intent2.putExtra("useJs", true);
                intent2.putExtra("vertical_scroll", true);
                intent2.putExtra("geta8key_scene", 3);
                com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent2);
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1200, this.kgm, 0);
            AppMethodBeat.o(27555);
            return true;
        } else if ("contact_info_trademark".endsWith(str)) {
            c cVar2 = this.Bdk;
            if (cVar2 == null) {
                AppMethodBeat.o(27555);
                return true;
            }
            if (cVar2.cG(false) != null && !Util.isNullOrNil(cVar2.cG(false).UT())) {
                Intent intent3 = new Intent();
                intent3.putExtra("rawUrl", cVar2.cG(false).UT());
                intent3.putExtra("useJs", true);
                intent3.putExtra("vertical_scroll", true);
                intent3.putExtra("geta8key_scene", 3);
                com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent3);
            }
            AppMethodBeat.o(27555);
            return true;
        } else {
            if ("contact_info_service_phone".equals(str) && (bmg = fVar.bmg("contact_info_service_phone")) != null && bmg.getSummary() != null && !Util.isNullOrNil(bmg.getSummary().toString())) {
                final String charSequence = bmg.getSummary().toString();
                com.tencent.mm.ui.base.h.a((Context) this, true, charSequence, "", getString(R.string.baf), getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27548);
                        Intent intent = new Intent("android.intent.action.DIAL");
                        intent.setFlags(268435456);
                        intent.setData(Uri.parse(WebView.SCHEME_TEL + charSequence));
                        if (Util.isIntentAvailable(NewBizInfoMoreInofUI.this, intent)) {
                            NewBizInfoMoreInofUI newBizInfoMoreInofUI = NewBizInfoMoreInofUI.this;
                            a bl = new a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(newBizInfoMoreInofUI, bl.axQ(), "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMoreInofUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            newBizInfoMoreInofUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(newBizInfoMoreInofUI, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMoreInofUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                        AppMethodBeat.o(27548);
                    }
                }, (DialogInterface.OnClickListener) null);
            }
            if (str.startsWith("contact_info_bizinfo_external#") && (i2 = Util.getInt(str.replace("contact_info_bizinfo_external#", ""), -1)) >= 0 && i2 < this.dhu.size()) {
                c.a aVar = this.dhu.get(i2);
                String str5 = aVar.url;
                Intent intent4 = new Intent();
                intent4.putExtra("rawUrl", str5);
                intent4.putExtra("useJs", true);
                intent4.putExtra("vertical_scroll", true);
                intent4.putExtra("geta8key_scene", 3);
                intent4.putExtra("KPublisherId", "brand_profile");
                intent4.putExtra("prePublishId", "brand_profile");
                if ((this.Bfg != null && (this.kgm == 39 || this.kgm == 56 || this.kgm == 35)) || this.kgm == 87 || this.kgm == 89 || this.kgm == 85 || this.kgm == 88) {
                    Log.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("KFromBizSearch", true);
                    bundle2.putBundle("KBizSearchExtArgs", this.Bfg);
                    intent4.putExtra("jsapiargs", bundle2);
                    if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
                        i3 = 7;
                    }
                    int identifier2 = getResources().getIdentifier(aVar.dhy, "string", getPackageName());
                    String str6 = aVar.title;
                    if (identifier2 > 0) {
                        str6 = getString(identifier2);
                    }
                    bP(i3, str6);
                }
                com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent4);
                AppMethodBeat.o(27555);
                return true;
            } else if (str.equals("contact_info_verifyuser_weibo")) {
                new com.tencent.mm.plugin.profile.ui.a.a(this).jx(this.contact.fuM, this.contact.field_username);
                AppMethodBeat.o(27555);
                return true;
            } else {
                if ("contact_info_guarantee_info".equals(str) && this.dhv.UY() != null && !Util.isNullOrNil(this.dhv.UY().diy)) {
                    Intent intent5 = new Intent();
                    intent5.putExtra("rawUrl", this.dhv.UY().diy);
                    intent5.putExtra("useJs", true);
                    intent5.putExtra("vertical_scroll", true);
                    intent5.putExtra("geta8key_scene", 3);
                    com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent5);
                }
                if ("contact_info_expose_btn".equals(str) && this.contact != null && !Util.isNullOrNil(this.contact.field_username)) {
                    Intent intent6 = new Intent();
                    intent6.putExtra("rawUrl", String.format(Bff, this.contact.field_username));
                    intent6.putExtra("showShare", false);
                    com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent6);
                }
                AppMethodBeat.o(27555);
                return false;
            }
        }
    }
}
