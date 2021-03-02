package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class l extends b {
    protected bn Qil = null;
    private TextView Qim;
    private View oQL;
    private View oQM;

    public l(Context context, bn bnVar) {
        super(context);
        View.OnClickListener r0;
        AppMethodBeat.i(38811);
        this.Qil = bnVar;
        if (this.view != null) {
            this.oQL = this.view.findViewById(R.id.a24);
            this.oQM = this.view.findViewById(R.id.a29);
            WeImageView weImageView = (WeImageView) this.view.findViewById(R.id.f6u);
            weImageView.setIconColor(((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50));
            this.Qim = (TextView) this.view.findViewById(R.id.f6v);
            switch (this.Qil.type) {
                case 1:
                    weImageView.setImageResource(R.raw.icons_outlined_cellphone);
                    this.Qim.setText(R.string.aci);
                    break;
                case 2:
                    weImageView.setImageResource(R.raw.icons_outlined_contacts);
                    this.Qim.setText(R.string.cff);
                    break;
                case 3:
                    weImageView.setImageResource(R.raw.icons_outlined_avatar);
                    this.Qim.setText(R.string.act);
                    break;
                case 4:
                    weImageView.setImageResource(R.raw.userguide_nearfriends_icon);
                    this.Qim.setText(R.string.acl);
                    break;
                case 6:
                    weImageView.setImageResource(R.raw.userguide_emostore_icon);
                    this.Qim.setText(R.string.acp);
                    break;
                case 7:
                    weImageView.setImageResource(R.raw.userguide_gamecenter_icon);
                    this.Qim.setText(R.string.aco);
                    break;
                case 8:
                    weImageView.setImageResource(R.raw.userguide_grounpmessage_icon);
                    this.Qim.setText(R.string.acq);
                    break;
                case 9:
                    weImageView.setImageResource(R.raw.userguide_moments_icon);
                    this.Qim.setText(R.string.acm);
                    break;
                case 10:
                    weImageView.setImageResource(R.raw.userguide_autoadd_icon);
                    this.Qim.setText(R.string.acf);
                    break;
            }
            View view = this.view;
            final int i2 = this.Qil.type;
            final int i3 = this.Qil.dDG;
            switch (i2) {
                case 1:
                    r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.l.AnonymousClass3 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38804);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            bo.aVL().dn(i2, i3);
                            l.K((Context) l.this.Kgr.get(), false);
                            a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38804);
                        }
                    };
                    break;
                case 2:
                    r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.l.AnonymousClass4 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38805);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            bo.aVL().dn(i2, i3);
                            l.K((Context) l.this.Kgr.get(), true);
                            a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38805);
                        }
                    };
                    break;
                case 3:
                    r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.l.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38803);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            bo.aVL().dn(i2, i3);
                            Context context = (Context) l.this.Kgr.get();
                            if (context != null) {
                                bg.aVF();
                                if (!c.isSDCardAvailable()) {
                                    u.g(context, null);
                                } else {
                                    Intent intent = new Intent();
                                    intent.putExtra("intent_set_avatar", true);
                                    intent.putExtra("KEnterFromBanner", true);
                                    com.tencent.mm.br.c.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
                                    h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 4, 1);
                                }
                            }
                            a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38803);
                        }
                    };
                    break;
                case 4:
                    r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.l.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38802);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            bo.aVL().dn(i2, i3);
                            Context context = (Context) l.this.Kgr.get();
                            if (context != null) {
                                h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 5, 1);
                                bg.aVF();
                                boolean nullAsFalse = Util.nullAsFalse((Boolean) c.azQ().get(4103, (Object) null));
                                new Intent().putExtra("KEnterFromBanner", true);
                                if (!nullAsFalse) {
                                    com.tencent.mm.br.c.V(context, "nearby", ".ui.NearbyFriendsIntroUI");
                                } else {
                                    bz aWk = bz.aWk();
                                    if (aWk == null) {
                                        com.tencent.mm.br.c.V(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                    } else {
                                        String nullAsNil = Util.nullAsNil(aWk.getProvince());
                                        int nullAs = Util.nullAs(Integer.valueOf(aWk.fuA), 0);
                                        if (Util.isNullOrNil(nullAsNil) || nullAs == 0) {
                                            com.tencent.mm.br.c.V(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        } else {
                                            LauncherUI instance = LauncherUI.getInstance();
                                            if (instance != null) {
                                                instance.ODR.getMainTabUI().blU("tab_find_friend");
                                            }
                                            com.tencent.mm.bp.a.ih(context);
                                        }
                                    }
                                }
                            }
                            a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38802);
                        }
                    };
                    break;
                case 5:
                default:
                    r0 = null;
                    break;
                case 6:
                    r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.l.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38806);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            bo.aVL().dn(i2, i3);
                            Intent intent = new Intent();
                            intent.putExtra("preceding_scence", 17);
                            com.tencent.mm.br.c.b((Context) l.this.Kgr.get(), "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                            h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 10, 1);
                            h.INSTANCE.a(12065, 2);
                            a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38806);
                        }
                    };
                    break;
                case 7:
                    r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.l.AnonymousClass6 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38807);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            bo.aVL().dn(i2, i3);
                            com.tencent.mm.br.c.V((Context) l.this.Kgr.get(), "game", ".ui.GameCenterUI");
                            h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 9, 1);
                            a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38807);
                        }
                    };
                    break;
                case 8:
                    r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.l.AnonymousClass7 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38808);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            bo.aVL().dn(i2, i3);
                            Context context = (Context) l.this.Kgr.get();
                            if ((z.aUl() & 65536) == 0) {
                                com.tencent.mm.br.c.V(context, "masssend", ".ui.MassSendHistoryUI");
                            } else {
                                com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                            }
                            h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 11, 1);
                            a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38808);
                        }
                    };
                    break;
                case 9:
                    r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.l.AnonymousClass8 */

                        public final void onClick(View view) {
                            boolean z;
                            AppMethodBeat.i(38809);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            bo.aVL().dn(i2, i3);
                            Context context = (Context) l.this.Kgr.get();
                            bg.aVF();
                            bg.aVF();
                            c.azQ().set(68377, "");
                            Intent intent = new Intent();
                            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                            if (!Util.isNullOrNil((String) c.azQ().get(68377, (Object) null))) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (o.DCO != null && o.DCO.ctM() > 0) {
                                z = false;
                            }
                            intent.putExtra("sns_resume_state", z);
                            com.tencent.mm.br.c.b(context, "sns", ".ui.SnsTimeLineUI", intent);
                            h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 8, 1);
                            a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38809);
                        }
                    };
                    break;
                case 10:
                    r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.l.AnonymousClass9 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38810);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            bo.aVL().dn(i2, i3);
                            com.tencent.mm.br.c.b((Context) l.this.Kgr.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
                            a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38810);
                        }
                    };
                    break;
            }
            view.setOnClickListener(r0);
        }
        AppMethodBeat.o(38811);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.b55;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void setVisibility(int i2) {
        AppMethodBeat.i(38813);
        if (this.oQL != null) {
            this.oQL.setVisibility(i2);
        }
        AppMethodBeat.o(38813);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(38812);
        if (this.isFirst && this.ifo) {
            this.oQM.setBackgroundResource(R.drawable.azq);
            this.oQL.setBackground(null);
            this.Qim.setBackground(null);
        } else if (this.isFirst) {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackgroundResource(R.drawable.cao);
            this.Qim.setBackgroundResource(R.drawable.b9w);
        } else if (this.ifo) {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackgroundResource(R.drawable.b9w);
            this.Qim.setBackground(null);
        } else {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackground(null);
            this.Qim.setBackgroundResource(R.drawable.b9w);
        }
        boolean bYa = super.bYa();
        AppMethodBeat.o(38812);
        return bYa;
    }

    static /* synthetic */ void K(Context context, boolean z) {
        AppMethodBeat.i(38814);
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 8);
            if (z) {
                intent.putExtra("bind_scene", 2);
            }
            intent.putExtra("KEnterFromBanner", true);
            MMWizardActivity.ay(context, intent);
            e KR = g.aWT().KR("4");
            if (KR != null && !Util.isNullOrNil(KR.value) && (KR.value.equals("1") || KR.value.equals("2"))) {
                g.aWT().KR("4").result = "1";
                f.KW("4");
                if (KR.value.equals("1")) {
                    bg.aVF();
                    c.azQ().set(328195, Boolean.TRUE);
                    AppMethodBeat.o(38814);
                    return;
                }
                bg.aVF();
                c.azQ().set(328196, Boolean.TRUE);
                AppMethodBeat.o(38814);
                return;
            } else if (z) {
                h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 3, 1);
                AppMethodBeat.o(38814);
                return;
            } else {
                h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 1, 1);
            }
        }
        AppMethodBeat.o(38814);
    }
}
