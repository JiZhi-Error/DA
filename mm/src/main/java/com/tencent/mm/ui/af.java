package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.v;
import java.io.IOException;

public final class af extends t implements i {
    private static final int[] OKj = {2, 1, 10, 20, Integer.MAX_VALUE};
    private static final int[] OKk = {2, 1, 10, Integer.MAX_VALUE};
    private static final int[] OKl = {2, 1, 10};
    private boolean IqH;
    private SparseArray<c> OKf;
    private a OKh;
    ae OKi = null;
    private Context mContext;
    private LayoutInflater mInflater;

    public af(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        AppMethodBeat.i(33697);
        this.mContext = appCompatActivity;
        this.mInflater = LayoutInflater.from(appCompatActivity);
        CL(false);
        this.OKi = ae.gJy();
        AppMethodBeat.o(33697);
    }

    @Override // com.tencent.mm.ui.tools.t, android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        boolean z;
        AppMethodBeat.i(33699);
        if (this.mContext instanceof AppCompatActivity) {
            ((AppCompatActivity) this.mContext).supportInvalidateOptionsMenu();
        }
        int i3 = this.OKf.get(i2).OKp.OKs;
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.pH(i3);
        bVar.pH(i2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", this, bVar.axR());
        h.INSTANCE.a(11104, Integer.valueOf(i3));
        if (g.af(l.class) != null) {
            ((l) g.af(l.class)).ccV();
        }
        switch (i3) {
            case 1:
                new Intent().putExtra("invite_friend_scene", 2);
                com.tencent.mm.br.c.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
                break;
            case 2:
                Intent intent = new Intent(this.mContext, SelectContactUI.class);
                intent.putExtra("titile", this.mContext.getString(R.string.g2));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", u.Q(u.PWU, 256, 512));
                intent.putExtra("scene", 7);
                intent.putExtra("menu_mode", 2);
                intent.putExtra("create_group_recommend", true);
                Context context = this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
            case 3:
                Intent intent2 = new Intent();
                intent2.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
                Context context2 = this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
            case 4:
                xq xqVar = new xq();
                xqVar.edR.edT = true;
                EventCenter.instance.publish(xqVar);
                String str = xqVar.edS.edV;
                if (Util.isNullOrNil(str)) {
                    VoipAddressUI.kp(this.mContext);
                    break;
                } else {
                    Log.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(str)));
                    com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(R.string.hke), "", this.mContext.getString(R.string.x_), this.mContext.getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.af.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(33686);
                            xq xqVar = new xq();
                            xqVar.edR.edU = true;
                            EventCenter.instance.publish(xqVar);
                            fo foVar = new fo();
                            foVar.dIN.username = com.tencent.mm.bi.d.jpB.bgL();
                            EventCenter.instance.publish(foVar);
                            VoipAddressUI.kp(af.this.mContext);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(33686);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.af.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(33687);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(33687);
                        }
                    });
                    break;
                }
            case 5:
                bg.aVF();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    bg.aVF();
                    Intent intent3 = new Intent();
                    intent3.putExtra("sns_userName", (String) com.tencent.mm.model.c.azQ().get(2, (Object) null));
                    intent3.setFlags(536870912);
                    intent3.addFlags(67108864);
                    bg.aVF();
                    int nullAs = Util.nullAs((Integer) com.tencent.mm.model.c.azQ().get(68389, (Object) null), 0);
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(68389, Integer.valueOf(nullAs + 1));
                    intent3.putExtra("sns_adapter_type", 1);
                    com.tencent.mm.br.c.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", intent3);
                    break;
                } else {
                    com.tencent.mm.ui.base.u.g(this.mContext, null);
                    break;
                }
            case 6:
                com.tencent.mm.plugin.fav.a.b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
                break;
            case 7:
                boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
                Log.i("MicroMsg.PlusSubMenuHelper", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
                if (!a2) {
                    com.tencent.mm.br.c.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
                    break;
                } else {
                    com.tencent.mm.br.c.b(this.mContext, "mall", ".ui.MallIndexUIv2", new Intent());
                    break;
                }
            case 8:
                Intent intent4 = new Intent();
                intent4.putExtra("preceding_scence", 2);
                com.tencent.mm.br.c.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", intent4);
                break;
            case 9:
                com.tencent.mm.br.c.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
                break;
            case 10:
                h.INSTANCE.a(11265, 3);
                if (!com.tencent.mm.q.a.o(this.mContext, true) && !com.tencent.mm.bh.e.bgF() && !com.tencent.mm.q.a.r(this.mContext, true)) {
                    Intent intent5 = new Intent();
                    intent5.putExtra("key_scan_entry_scene", 1);
                    intent5.putExtra("key_config_black_interval", true);
                    intent5.putExtra("key_enable_multi_code", true);
                    intent5.putExtra("key_scan_goods_enable_dynamic_wording", true);
                    com.tencent.mm.br.c.b(this.mContext, "scanner", ".ui.BaseScanUI", intent5);
                    break;
                }
            case 11:
                bg.aVF();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    com.tencent.mm.plugin.report.service.g.Wl(10);
                    bg.aVF();
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(68377, "");
                    Intent intent6 = new Intent();
                    intent6.putExtra("sns_timeline_NeedFirstLoadint", true);
                    if (!Util.isNullOrNil((String) com.tencent.mm.model.c.azQ().get(68377, (Object) null))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (o.DCO != null && o.DCO.ctM() > 0) {
                        z = false;
                    }
                    intent6.putExtra("sns_resume_state", z);
                    com.tencent.mm.br.c.b(this.mContext, "sns", ".ui.SnsTimeLineUI", intent6);
                    break;
                } else {
                    com.tencent.mm.ui.base.u.g(this.mContext, null);
                    break;
                }
            case 12:
                bg.aVF();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    com.tencent.mm.br.c.V(this.mContext, "game", ".ui.GameCenterUI");
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.ui.af.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(33688);
                            com.tencent.mm.cr.d.hiy();
                            AppMethodBeat.o(33688);
                        }
                    }, 100);
                    break;
                } else {
                    com.tencent.mm.ui.base.u.g(this.mContext, null);
                    break;
                }
            case 13:
                EventCenter.instance.publish(new rv());
                com.tencent.mm.br.c.V(this.mContext, "shake", ".ui.ShakeReportUI");
                break;
            case 14:
                bg.aVF();
                if (Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(4103, (Object) null))) {
                    bz aWk = bz.aWk();
                    if (aWk != null) {
                        String nullAsNil = Util.nullAsNil(aWk.getProvince());
                        int nullAs2 = Util.nullAs(Integer.valueOf(aWk.fuA), 0);
                        if (!Util.isNullOrNil(nullAsNil) && nullAs2 != 0) {
                            bg.aVF();
                            Boolean bool = (Boolean) com.tencent.mm.model.c.azQ().get(4104, (Object) null);
                            if (bool != null && bool.booleanValue()) {
                                View inflate = View.inflate(this.mContext, R.layout.azk, null);
                                final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.e_r);
                                checkBox.setChecked(false);
                                com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.string.zb), inflate, new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.ui.af.AnonymousClass4 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(33689);
                                        if (checkBox != null) {
                                            bg.aVF();
                                            com.tencent.mm.model.c.azQ().set(4104, Boolean.valueOf(!checkBox.isChecked()));
                                        }
                                        LauncherUI instance = LauncherUI.getInstance();
                                        if (instance != null) {
                                            instance.ODR.getMainTabUI().blU("tab_find_friend");
                                        }
                                        com.tencent.mm.bp.a.ih(af.this.mContext);
                                        AppMethodBeat.o(33689);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                break;
                            } else {
                                LauncherUI instance = LauncherUI.getInstance();
                                if (instance != null) {
                                    instance.ODR.getMainTabUI().blU("tab_find_friend");
                                }
                                com.tencent.mm.bp.a.ih(this.mContext);
                                break;
                            }
                        } else {
                            com.tencent.mm.br.c.V(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                            break;
                        }
                    } else {
                        com.tencent.mm.br.c.V(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                        break;
                    }
                } else {
                    com.tencent.mm.br.c.V(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
                    break;
                }
                break;
            case 16:
                bg.aVF();
                if (!com.tencent.mm.model.c.azn()) {
                    com.tencent.mm.br.c.V(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
                    break;
                } else {
                    com.tencent.mm.br.c.V(this.mContext, "webwx", ".ui.WebWXLogoutUI");
                    break;
                }
            case 17:
                if (!((z.aUl() & 65536) == 0)) {
                    com.tencent.mm.br.c.b(this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                    break;
                } else {
                    com.tencent.mm.br.c.V(this.mContext, "masssend", ".ui.MassSendHistoryUI");
                    break;
                }
            case 18:
                com.tencent.mm.br.c.V(this.mContext, "radar", ".ui.RadarSearchUI");
                break;
            case 19:
                com.tencent.mm.br.c.V(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                break;
            case 20:
                if (WeChatBrands.Business.Entries.HomeMorePayment.checkAvailable(this.mContext)) {
                    com.tencent.mm.plugin.newtips.a.exl().TC(4);
                    Context context3 = this.mContext;
                    Intent intent7 = new Intent();
                    intent7.putExtra("key_from_scene", 2);
                    com.tencent.mm.br.c.b(context3, "offline", ".ui.WalletOfflineEntranceUI", intent7);
                    if (com.tencent.mm.y.c.axV().cP(262159, 266248)) {
                        com.tencent.mm.y.c.axV().cQ(262159, 266248);
                        h.INSTANCE.a(14396, 2);
                        break;
                    }
                }
                break;
            case 22:
                f.aD(this.mContext, 1);
                break;
            case 24:
                g.azz().a(2540, this);
                daj fUn = fUn();
                if (!Util.isNullOrNil(fUn.MFD)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = currentTimeMillis - fUn.MFF;
                    Log.i("MicroMsg.PlusSubMenuHelper", "currentTime ：%s ,lastTime：%s,internalTime ：%s", Long.valueOf(currentTimeMillis), Long.valueOf(fUn.MFF), Long.valueOf(j3));
                    if (j3 >= ((long) fUn.MFE)) {
                        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 is expired");
                        yz(false);
                        break;
                    } else {
                        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 dont expired，url：%s", fUn.MFD);
                        com.tencent.mm.wallet_core.ui.f.o(this.mContext, fUn.MFD, false);
                        yz(true);
                        break;
                    }
                } else {
                    Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 has no cache");
                    yz(false);
                    break;
                }
            case 2147483645:
                Intent intent8 = new Intent();
                bg.aVF();
                String str2 = (String) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_CROWDTEST_FEEDBACK_LINK_STRING, "");
                if (Util.isNullOrNil(str2)) {
                    com.tencent.mm.pluginsdk.g.il(this.mContext);
                    break;
                } else {
                    intent8.putExtra("rawUrl", str2);
                    intent8.putExtra("showShare", true);
                    intent8.putExtra("show_bottom", false);
                    com.tencent.mm.br.c.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent8);
                    break;
                }
            case 2147483646:
                Intent intent9 = new Intent();
                intent9.putExtra("key_from_scene", 2);
                com.tencent.mm.br.c.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", intent9);
                break;
            case Integer.MAX_VALUE:
                h.INSTANCE.kvStat(10919, "1-6");
                com.tencent.mm.pluginsdk.g.il(this.mContext);
                break;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/PlusSubMenuHelper", "com/tencent/mm/ui/PlusSubMenuHelper", "processOnItemClick", "(II)V");
        this.OKi.alk(i3);
        dismiss();
        AppMethodBeat.o(33699);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(af afVar, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(33690);
            int size = af.this.OKf.size();
            AppMethodBeat.o(33690);
            return size;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(33691);
            e eVar = new e(af.this.mContext, (c) af.this.OKf.get(i2));
            LayoutInflater layoutInflater = af.this.mInflater;
            if (i2 == getCount() - 1) {
                z = true;
            } else {
                z = false;
            }
            eVar.gvQ = layoutInflater.inflate(R.layout.bad, viewGroup, false);
            eVar.hbb = (TextView) eVar.gvQ.findViewById(R.id.ipm);
            eVar.kc = (ImageView) eVar.gvQ.findViewById(R.id.dt5);
            eVar.OKu = (TextView) eVar.gvQ.findViewById(R.id.fxj);
            eVar.OKv = (TextView) eVar.gvQ.findViewById(R.id.j08);
            eVar.OKw = eVar.gvQ.findViewById(R.id.fvx);
            if (!Util.isNullOrNil(eVar.OKt.OKp.OKq)) {
                eVar.hbb.setText(eVar.OKt.OKp.OKq);
            }
            if (eVar.OKt.OKp.textColor > 0) {
                eVar.hbb.setTextColor(com.tencent.mm.cb.a.n(MMApplicationContext.getContext(), eVar.OKt.OKp.textColor));
            }
            if (eVar.OKt.OKp.icon > 0) {
                eVar.kc.setVisibility(0);
                eVar.kc.setImageResource(eVar.OKt.OKp.icon);
            } else {
                eVar.kc.setVisibility(8);
            }
            if (!Util.isNullOrNil(eVar.OKt.OKp.OKr)) {
                eVar.kc.setContentDescription(eVar.OKt.OKp.OKr);
            }
            eVar.OKv.setBackgroundResource(v.kH(eVar.context));
            if (z) {
                eVar.gvQ.setBackgroundResource(R.drawable.axz);
            } else {
                eVar.gvQ.setBackgroundResource(R.drawable.axy);
            }
            eVar.OKu.setTextSize(0, (float) com.tencent.mm.cb.a.aH(eVar.context, R.dimen.anf));
            if (eVar.OKt.gYN || eVar.OKt.dCm > 0 || eVar.OKt.OKo) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!com.tencent.mm.plugin.newtips.a.g.a(z2, eVar)) {
                if (eVar.OKt.gYN) {
                    eVar.OKu.setVisibility(0);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) eVar, k.MMNEWTIPS_SHOWTYPE_NEW, true);
                } else if (eVar.OKt.dCm > 0) {
                    eVar.OKv.setVisibility(0);
                    if (eVar.OKt.dCm > 99) {
                        eVar.OKv.setText("");
                        eVar.OKv.setBackgroundResource(R.raw.badge_count_more);
                    } else {
                        eVar.OKv.setText(new StringBuilder().append(eVar.OKt.dCm).toString());
                        eVar.OKv.setBackgroundResource(v.aQ(eVar.context, eVar.OKt.dCm));
                    }
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) eVar, k.MMNEWTIPS_SHOWTYPE_COUNTER, true);
                } else if (eVar.OKt.OKo) {
                    eVar.OKw.setVisibility(0);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) eVar, k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
                } else {
                    eVar.OKu.setVisibility(8);
                    eVar.OKv.setVisibility(8);
                    eVar.OKw.setVisibility(8);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) eVar, k.MMNEWTIPS_SHOWTYPE_NEW, false);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) eVar, k.MMNEWTIPS_SHOWTYPE_COUNTER, false);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) eVar, k.MMNEWTIPS_SHOWTYPE_REDPOINT, false);
                }
            }
            com.tencent.mm.plugin.newtips.a.exl().h(eVar);
            View view2 = eVar.gvQ;
            AppMethodBeat.o(33691);
            return view2;
        }
    }

    public static class e implements com.tencent.mm.plugin.newtips.a.a {
        c OKt;
        TextView OKu;
        TextView OKv;
        View OKw;
        Context context;
        View gvQ;
        TextView hbb;
        ImageView kc;

        public e(Context context2, c cVar) {
            this.context = context2;
            this.OKt = cVar;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final String getPath() {
            return this.OKt.OKp.path;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean ehp() {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final View getRoot() {
            return this.gvQ;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final void a(k kVar, boolean z) {
            AppMethodBeat.i(258912);
            com.tencent.mm.plugin.newtips.a.g.a(this, kVar, z);
            AppMethodBeat.o(258912);
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qV(boolean z) {
            AppMethodBeat.i(258913);
            boolean a2 = com.tencent.mm.plugin.newtips.a.g.a(z, this);
            AppMethodBeat.o(258913);
            return a2;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qW(boolean z) {
            AppMethodBeat.i(33694);
            if (z) {
                this.OKw.setVisibility(0);
            } else {
                this.OKw.setVisibility(8);
            }
            AppMethodBeat.o(33694);
            return true;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qX(boolean z) {
            AppMethodBeat.i(33695);
            if (z) {
                this.OKu.setVisibility(0);
            } else {
                this.OKu.setVisibility(8);
            }
            AppMethodBeat.o(33695);
            return true;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean a(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean b(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean c(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean d(boolean z, ehv ehv) {
            AppMethodBeat.i(33696);
            if (z) {
                this.OKv.setVisibility(0);
                if (ehv.ibS > 99) {
                    this.OKv.setText("");
                    this.OKv.setBackgroundResource(R.raw.badge_count_more);
                } else {
                    this.OKv.setText(new StringBuilder().append(ehv.ibS).toString());
                    this.OKv.setBackgroundResource(v.aQ(this.context, ehv.ibS));
                }
            } else {
                this.OKv.setVisibility(8);
            }
            AppMethodBeat.o(33696);
            return true;
        }
    }

    public static class c {
        boolean OKo = false;
        d OKp;
        int dCm = 0;
        boolean gYN = false;

        public c(d dVar) {
            this.OKp = dVar;
        }
    }

    public static class d {
        String OKq;
        String OKr;
        int OKs;
        int icon;
        String path;
        int textColor;

        public d(int i2, String str, String str2, int i3, int i4) {
            this(i2, str, str2, i3, i4, "");
        }

        public d(int i2, String str, String str2, int i3, int i4, String str3) {
            this.OKq = str;
            this.OKr = str2;
            this.icon = i3;
            this.OKs = i2;
            this.textColor = i4;
            this.path = str3;
        }
    }

    public static class b {
        int OKn;
        int id;
        int jlm;
        int order;

        public b(int i2, int i3, int i4) {
            this(i2, i3, i4, 0);
        }

        public b(int i2, int i3, int i4, int i5) {
            this.id = i2;
            this.OKn = i3;
            this.jlm = i4;
            this.order = i5;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static d all(int i2) {
        d dVar;
        AppMethodBeat.i(33700);
        Context context = MMApplicationContext.getContext();
        switch (i2) {
            case 1:
                if (!HomeUI.OCE.booleanValue()) {
                    dVar = new d(1, context.getString(R.string.ezw), "", R.raw.ofm_add_icon, 0);
                    break;
                } else {
                    dVar = new d(1, context.getString(R.string.ezw), "", R.raw.ofm_add_green_icon, R.color.afp);
                    break;
                }
            case 2:
                if (!HomeUI.OCF.booleanValue()) {
                    dVar = new d(2, context.getString(R.string.ezz), "", R.raw.ofm_group_chat_icon, 0);
                    break;
                } else {
                    dVar = new d(2, context.getString(R.string.ezz), "", R.raw.ofm_group_chat_green_icon, R.color.afp);
                    break;
                }
            case 3:
                dVar = new d(3, context.getString(R.string.f00), "", R.raw.camera, 0);
                break;
            case 4:
                if (1 != Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VOIPCallType"), 0)) {
                    dVar = new d(4, context.getString(R.string.ezx), "", R.raw.ofm_audio_icon, 0);
                    break;
                } else {
                    dVar = new d(4, context.getString(R.string.f01), "", R.raw.ofm_video_icon, 0);
                    break;
                }
            case 5:
                dVar = new d(5, context.getString(R.string.gr8), "", R.raw.ofm_pic_icon, 0);
                break;
            case 6:
                dVar = new d(6, context.getString(R.string.gqa), "", R.raw.ofm_favourite_icon, 0);
                break;
            case 7:
                dVar = new d(7, context.getString(R.string.gqc), "", R.raw.ofm_card_icon, 0);
                break;
            case 8:
                dVar = new d(8, context.getString(R.string.btv), "", R.raw.ofm_emostore_icon, 0);
                break;
            case 9:
                dVar = new d(9, context.getString(R.string.grd), "", R.raw.ofm_myqrcode_icon, 0);
                break;
            case 10:
                dVar = new d(10, context.getString(R.string.cey), "", R.raw.ofm_qrcode_icon, 0);
                break;
            case 11:
                dVar = new d(11, context.getString(R.string.h5v), "", R.raw.ofm_moment_icon, 0);
                break;
            case 12:
                dVar = new d(12, context.getString(R.string.ds3), "", R.raw.ofm_gamecenter_icon, 0);
                break;
            case 13:
                dVar = new d(13, context.getString(R.string.gzg), "", R.raw.ofm_shake_icon, 0);
                break;
            case 14:
                dVar = new d(14, context.getString(R.string.fad), "", R.raw.ofm_nearby_icon, 0);
                break;
            case 16:
                dVar = new d(16, context.getString(R.string.gmv), "", R.raw.ofm_webwechat_icon, 0);
                break;
            case 17:
                dVar = new d(17, context.getString(R.string.ey9), "", R.raw.ofm_groupmessage_icon, 0);
                break;
            case 18:
                dVar = new d(18, context.getString(R.string.cf0), "", R.raw.ofm_radar_icon, 0);
                break;
            case 19:
                dVar = new d(19, context.getString(R.string.cf3), "", R.raw.actionbar_facefriend_icon, 0);
                break;
            case 20:
                bg.aVF();
                if (((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue() <= 1) {
                    dVar = new d(20, context.getString(R.string.g1), "", R.raw.receipt_payment_icon, 0, "plus_receiveorpay");
                    break;
                }
                dVar = null;
                break;
            case 22:
                bg.aVF();
                int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wcpay_hk_righttop_receive_orderpay_entry_switch, 0);
                if (intValue == 8 && a2 == 0) {
                    dVar = new d(22, context.getString(R.string.fox), "", R.raw.offline_entrance_f2f_collect_hk, 0);
                    break;
                }
                dVar = null;
                break;
            case 24:
                bg.aVF();
                int intValue2 = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wcpay_hk_righttop_receive_orderpay_entry_switch, 0);
                if (intValue2 == 8 && a3 == 1) {
                    dVar = new d(24, context.getString(R.string.foy), "", R.raw.receipt_payment_icon, 0);
                    break;
                }
                dVar = null;
                break;
            case 2147483645:
                dVar = new d(2147483645, context.getString(R.string.go8), "", R.raw.ofm_feedback_icon, 0);
                break;
            case 2147483646:
                dVar = new d(2147483646, "TIT", "", R.raw.ofm_card_icon, 0);
                break;
            case Integer.MAX_VALUE:
                dVar = new d(Integer.MAX_VALUE, context.getString(R.string.gou), "", R.raw.ofm_feedback_icon, 0);
                break;
            default:
                dVar = null;
                break;
        }
        AppMethodBeat.o(33700);
        return dVar;
    }

    @Override // com.tencent.mm.ui.tools.t
    public final BaseAdapter anl() {
        AppMethodBeat.i(33701);
        if (this.OKh == null) {
            this.OKh = new a(this, (byte) 0);
        }
        a aVar = this.OKh;
        AppMethodBeat.o(33701);
        return aVar;
    }

    private void yz(boolean z) {
        AppMethodBeat.i(232707);
        g.aAi();
        bg.azz().a(new com.tencent.mm.plugin.wallet_index.c.a.b(((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue()), 0);
        this.IqH = z;
        AppMethodBeat.o(232707);
    }

    private static daj fUn() {
        AppMethodBeat.i(232708);
        Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig");
        daj daj = new daj();
        String str = (String) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_WX_PAY_HK_WALLET_ADD_CONFIG_STRING_SYNC, (Object) null);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
        } else {
            try {
                daj.parseFrom(str.getBytes(KindaConfigCacheStg.SAVE_CHARSET));
                Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 getConfig success");
            } catch (Exception e2) {
                Log.e("MicroMsg.PlusSubMenuHelper", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + e2.getLocalizedMessage());
            }
        }
        AppMethodBeat.o(232708);
        return daj;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        IOException e2;
        String str2;
        AppMethodBeat.i(232709);
        Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End：errType %s , errCode：%s，errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof com.tencent.mm.plugin.wallet_index.c.a.b) {
            if (i2 == 0 && i3 == 0) {
                daj fUq = ((com.tencent.mm.plugin.wallet_index.c.a.b) qVar).fUq();
                if (fUq.dOK == 0) {
                    Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", fUq.MFD, Integer.valueOf(fUq.MFE));
                    if (!this.IqH && fUo()) {
                        Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End jump h5 ");
                        com.tencent.mm.wallet_core.ui.f.o(this.mContext, fUq.MFD, false);
                    }
                    fUq.MFF = System.currentTimeMillis();
                    Log.i("MicroMsg.PlusSubMenuHelper", "on Scene End currentTime ：%s ", Long.valueOf(fUq.MFF));
                    Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig");
                    String str3 = " ";
                    if (fUq != null) {
                        try {
                            str2 = new String(fUq.toByteArray(), KindaConfigCacheStg.SAVE_CHARSET);
                            try {
                                Log.i("MicroMsg.PlusSubMenuHelper", "OfflineH5 setConfig success");
                                str3 = str2;
                            } catch (IOException e3) {
                                e2 = e3;
                                Log.e("MicroMsg.PlusSubMenuHelper", "save config exp, " + e2.getLocalizedMessage());
                                str3 = str2;
                                ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_WX_PAY_HK_WALLET_ADD_CONFIG_STRING_SYNC, str3);
                                ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().gBI();
                                g.azz().b(2540, this);
                                AppMethodBeat.o(232709);
                            }
                        } catch (IOException e4) {
                            e2 = e4;
                            str2 = str3;
                            Log.e("MicroMsg.PlusSubMenuHelper", "save config exp, " + e2.getLocalizedMessage());
                            str3 = str2;
                            ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_WX_PAY_HK_WALLET_ADD_CONFIG_STRING_SYNC, str3);
                            ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().gBI();
                            g.azz().b(2540, this);
                            AppMethodBeat.o(232709);
                        }
                    }
                    ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_WX_PAY_HK_WALLET_ADD_CONFIG_STRING_SYNC, str3);
                    ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().gBI();
                } else {
                    Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
                    if (!this.IqH && fUo()) {
                        com.tencent.mm.ui.base.h.a(this.mContext, fUq.dOL, "", this.mContext.getString(R.string.j34), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.af.AnonymousClass5 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(232703);
                                Log.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
                                AppMethodBeat.o(232703);
                            }
                        });
                    }
                }
            } else {
                Log.i("MicroMsg.PlusSubMenuHelper", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
                if (!this.IqH && fUo()) {
                    com.tencent.mm.ui.base.h.a(this.mContext, str, "", this.mContext.getString(R.string.j34), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.af.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(232704);
                            Log.i("MicroMsg.PlusSubMenuHelper", "onDialogClick() ");
                            AppMethodBeat.o(232704);
                        }
                    });
                }
            }
            g.azz().b(2540, this);
        }
        AppMethodBeat.o(232709);
    }

    private boolean fUo() {
        AppMethodBeat.i(232710);
        String topActivityName2 = Util.getTopActivityName2(this.mContext);
        if (Util.isNullOrNil(topActivityName2) || !topActivityName2.equals("LauncherUI")) {
            Log.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is not on ActivityTask Top：%s", topActivityName2);
            AppMethodBeat.o(232710);
            return false;
        }
        Log.i("MicroMsg.PlusSubMenuHelper", "LauncherUI is on ActivityTask Top ");
        AppMethodBeat.o(232710);
        return true;
    }

    @Override // com.tencent.mm.ui.tools.t
    public final boolean iv() {
        int[] iArr;
        int i2 = 0;
        AppMethodBeat.i(33698);
        this.OKi.Bs(false);
        if (this.OKi.OKf.size() != 0) {
            this.OKf = this.OKi.OKf;
        } else {
            Log.i("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.OKf != null) {
                this.OKf.clear();
            } else {
                this.OKf = new SparseArray<>();
            }
            if (WeChatBrands.Business.Entries.HomeMoreFeedback.banned()) {
                iArr = OKl;
            } else {
                iArr = Util.isOverseasUser(this.mContext) ? OKk : OKj;
            }
            int i3 = 0;
            for (int i4 : iArr) {
                c cVar = new c(all(i4));
                if (cVar.OKp != null) {
                    this.OKf.put(i3, cVar);
                }
                i3++;
            }
        }
        try {
            bg.aVF();
            if (((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                while (i2 < this.OKf.size() && this.OKf.get(i2).OKp.OKs != 2147483646) {
                    i2++;
                }
                if (i2 == this.OKf.size()) {
                    this.OKf.put(this.OKf.size(), new c(all(2147483646)));
                }
            }
        } catch (Exception e2) {
        }
        if (this.OKh != null) {
            this.OKh.notifyDataSetChanged();
        }
        boolean iv = super.iv();
        AppMethodBeat.o(33698);
        return iv;
    }
}
