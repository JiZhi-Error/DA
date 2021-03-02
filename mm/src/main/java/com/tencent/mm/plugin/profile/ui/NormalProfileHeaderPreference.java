package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bj.d;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.a;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class NormalProfileHeaderPreference extends Preference implements View.OnClickListener, View.OnLongClickListener {
    private b Bcm;
    private String Bgu;
    private boolean Bgv;
    private boolean Bgw;
    private int Bgx;
    private boolean Bgy;
    String Vax;
    int kuv = 0;
    int kuw = 0;
    private Context mContext;
    private int mScene;
    public f nRm;
    private boolean readOnly = false;
    private as rjX;
    private boolean zRI = false;
    View zlc;

    public NormalProfileHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
    }

    public NormalProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public final void a(as asVar, int i2, boolean z, b bVar) {
        AppMethodBeat.i(27275);
        this.Bgu = ((Activity) this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
        this.rjX = asVar;
        this.mScene = i2;
        this.readOnly = z;
        this.zRI = true;
        this.Bcm = bVar;
        AppMethodBeat.o(27275);
    }

    public final void onDetach() {
        AppMethodBeat.i(27276);
        if (this.zlc != null) {
            a aVar = (a) this.zlc.getTag();
            if (aVar.BgR != null) {
                aVar.BgR.detach();
            }
        }
        AppMethodBeat.o(27276);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(27277);
        if (this.zlc == null) {
            this.zlc = super.onCreateView(viewGroup);
        }
        View view = this.zlc;
        AppMethodBeat.o(27277);
        return view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0433  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x050d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x051e  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0548  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0560  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x05c8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x05fc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0605  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x060c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x03cf  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x03f6  */
    @Override // com.tencent.mm.ui.base.preference.Preference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindView(android.view.View r12) {
        /*
        // Method dump skipped, instructions count: 1564
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.onBindView(android.view.View):void");
    }

    private boolean eDI() {
        AppMethodBeat.i(27279);
        boolean IG = as.IG(this.rjX.field_username);
        AppMethodBeat.o(27279);
        return IG;
    }

    private String aa(as asVar) {
        String arJ;
        AppMethodBeat.i(27280);
        if (eDI()) {
            Resources resources = this.mContext.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = Util.isNullOrNil(asVar.getCity()) ? aa.It(asVar.getProvince()) : asVar.getCity();
            arJ = resources.getString(R.string.ako, objArr).trim();
        } else {
            arJ = asVar.arJ();
        }
        String nullAs = Util.nullAs(arJ, "");
        AppMethodBeat.o(27280);
        return nullAs;
    }

    private static void a(a aVar, Context context, as asVar, int i2, com.tencent.mm.pluginsdk.ui.preference.b[] bVarArr) {
        AppMethodBeat.i(27281);
        if (bVarArr == null || c.oR(asVar.field_type)) {
            aVar.BgR.setVisibility(8);
            AppMethodBeat.o(27281);
            return;
        }
        aVar.BgR.setVisibility(0);
        String nullAsNil = Util.nullAsNil(((Activity) context).getIntent().getStringExtra("Verify_ticket"));
        a.C2029a aVar2 = new a.C2029a();
        aVar2.talker = asVar.field_username;
        aVar2.scene = i2;
        aVar2.wZz = nullAsNil;
        aVar2.Kpf = asVar.fuY;
        aVar2.type = 0;
        if (i2 == 18) {
            aVar2.type = 1;
        } else if (bp.sb(i2)) {
            aVar2.type = 2;
        }
        aVar.BgR.setFMessageArgs(aVar2);
        for (com.tencent.mm.pluginsdk.ui.preference.b bVar : bVarArr) {
            aVar.BgR.a(bVar);
        }
        AppMethodBeat.o(27281);
    }

    public static CharSequence a(Context context, as asVar, int i2, String str, boolean z) {
        String str2;
        String string;
        CharSequence c2;
        CharSequence c3;
        String str3 = null;
        AppMethodBeat.i(27283);
        if (i2 == 9) {
            i2 = asVar.getSource();
        }
        switch (i2) {
            case 1:
                if (z || asVar.arL() > 1000000) {
                    String string2 = context.getResources().getString(R.string.bgn);
                    AppMethodBeat.o(27283);
                    return string2;
                } else if (c.oR(asVar.field_type)) {
                    String string3 = context.getResources().getString(R.string.bgm);
                    AppMethodBeat.o(27283);
                    return string3;
                } else {
                    String string4 = context.getResources().getString(R.string.bgo);
                    AppMethodBeat.o(27283);
                    return string4;
                }
            case 3:
                if (z || asVar.arL() > 1000000) {
                    String string5 = context.getResources().getString(R.string.bgq);
                    AppMethodBeat.o(27283);
                    return string5;
                } else if (c.oR(asVar.field_type)) {
                    String string6 = context.getResources().getString(R.string.bgp);
                    AppMethodBeat.o(27283);
                    return string6;
                } else {
                    String string7 = context.getResources().getString(R.string.bgr);
                    AppMethodBeat.o(27283);
                    return string7;
                }
            case 4:
            case 12:
                String string8 = context.getResources().getString(R.string.ddi);
                AppMethodBeat.o(27283);
                return string8;
            case 6:
                String string9 = context.getResources().getString(R.string.ddj);
                AppMethodBeat.o(27283);
                return string9;
            case 8:
            case 14:
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                String str4 = d.bgM().aEm(str).field_chatroomName;
                if (Util.isNullOrNil(str4)) {
                    str2 = asVar.field_sourceExtInfo;
                } else {
                    str2 = str4;
                }
                as Kn = ((l) g.af(l.class)).aSN().Kn(str2);
                if (Kn != null && !Util.isNullOrNil(Kn.field_username)) {
                    str3 = Util.isNullOrNil(Kn.field_nickname) ? v.HV(Kn.field_username) : Kn.field_nickname;
                }
                if (z || asVar.arL() > 1000000) {
                    if (!Util.isNullOrNil(str3)) {
                        string = context.getString(R.string.bg_, str3);
                    } else {
                        string = context.getString(R.string.bg8);
                    }
                    AppMethodBeat.o(27283);
                    return string;
                } else if (c.oR(asVar.field_type)) {
                    String string10 = context.getResources().getString(R.string.bg9, str3);
                    AppMethodBeat.o(27283);
                    return string10;
                } else {
                    String string11 = context.getResources().getString(R.string.bg7);
                    AppMethodBeat.o(27283);
                    return string11;
                }
            case 10:
            case 13:
                if (z || asVar.arL() > 1000000) {
                    String string12 = context.getResources().getString(R.string.bgw);
                    AppMethodBeat.o(27283);
                    return string12;
                } else if (c.oR(asVar.field_type)) {
                    String string13 = context.getResources().getString(R.string.bgv);
                    AppMethodBeat.o(27283);
                    return string13;
                } else {
                    String string14 = context.getResources().getString(R.string.bgx);
                    AppMethodBeat.o(27283);
                    return string14;
                }
            case 15:
                if (z || asVar.arL() > 1000000) {
                    String string15 = context.getResources().getString(R.string.bgk);
                    AppMethodBeat.o(27283);
                    return string15;
                } else if (c.oR(asVar.field_type)) {
                    String string16 = context.getResources().getString(R.string.bgj);
                    AppMethodBeat.o(27283);
                    return string16;
                } else {
                    String string17 = context.getResources().getString(R.string.bgl);
                    AppMethodBeat.o(27283);
                    return string17;
                }
            case 17:
                String jw = jw(((Activity) context).getIntent().getStringExtra("share_card_username"), ((Activity) context).getIntent().getStringExtra("share_card_nickname"));
                if (Util.isNullOrNil(jw)) {
                    jw = jw(((Activity) context).getIntent().getStringExtra("source_from_user_name"), ((Activity) context).getIntent().getStringExtra("source_from_nick_name"));
                }
                if (z || asVar.arL() > 1000000) {
                    if (Util.isNullOrNil(jw)) {
                        c2 = context.getString(R.string.bg4);
                    } else {
                        c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.bg3, jw));
                    }
                    AppMethodBeat.o(27283);
                    return c2;
                } else if (c.oR(asVar.field_type)) {
                    if (Util.isNullOrNil(jw)) {
                        c3 = context.getString(R.string.bg1);
                    } else {
                        c3 = com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.bg2, jw));
                    }
                    AppMethodBeat.o(27283);
                    return c3;
                } else if (!Util.isNullOrNil(jw)) {
                    String string18 = context.getString(R.string.bg5, jw);
                    AppMethodBeat.o(27283);
                    return string18;
                } else {
                    SpannableString c4 = com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.bg6));
                    AppMethodBeat.o(27283);
                    return c4;
                }
            case 18:
                if (z || asVar.arL() > 1000000) {
                    String string19 = context.getResources().getString(R.string.bgb);
                    AppMethodBeat.o(27283);
                    return string19;
                } else if (c.oR(asVar.field_type)) {
                    String string20 = context.getResources().getString(R.string.bga);
                    AppMethodBeat.o(27283);
                    return string20;
                } else {
                    String string21 = context.getResources().getString(R.string.bgc);
                    AppMethodBeat.o(27283);
                    return string21;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                if (z || asVar.arL() > 1000000) {
                    String string22 = context.getResources().getString(R.string.bgt);
                    AppMethodBeat.o(27283);
                    return string22;
                } else if (c.oR(asVar.field_type)) {
                    String string23 = context.getResources().getString(R.string.bgs);
                    AppMethodBeat.o(27283);
                    return string23;
                } else {
                    String string24 = context.getResources().getString(R.string.bgu);
                    AppMethodBeat.o(27283);
                    return string24;
                }
            case 25:
                if (z || asVar.arL() > 1000000) {
                    String string25 = context.getResources().getString(R.string.bfz);
                    AppMethodBeat.o(27283);
                    return string25;
                } else if (c.oR(asVar.field_type)) {
                    String string26 = context.getResources().getString(R.string.bfy);
                    AppMethodBeat.o(27283);
                    return string26;
                } else {
                    String string27 = context.getResources().getString(R.string.bg0);
                    AppMethodBeat.o(27283);
                    return string27;
                }
            case 30:
                if (z || asVar.arL() > 1000000) {
                    String string28 = context.getResources().getString(R.string.bgg);
                    AppMethodBeat.o(27283);
                    return string28;
                } else if (c.oR(asVar.field_type)) {
                    String string29 = context.getResources().getString(R.string.bgf);
                    AppMethodBeat.o(27283);
                    return string29;
                } else {
                    String string30 = context.getResources().getString(R.string.bgh);
                    AppMethodBeat.o(27283);
                    return string30;
                }
            case 34:
                String string31 = context.getResources().getString(R.string.bfw);
                AppMethodBeat.o(27283);
                return string31;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                String string32 = context.getResources().getString(R.string.bgi);
                AppMethodBeat.o(27283);
                return string32;
            case 58:
            case bv.CTRL_INDEX:
            case 60:
                String string33 = context.getResources().getString(R.string.du0);
                AppMethodBeat.o(27283);
                return string33;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                String string34 = context.getResources().getString(R.string.bgd);
                AppMethodBeat.o(27283);
                return string34;
            default:
                AppMethodBeat.o(27283);
                return null;
        }
    }

    private static String jw(String str, String str2) {
        AppMethodBeat.i(27284);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(27284);
            return null;
        }
        String Is = aa.Is(str);
        if (!Util.isNullOrNil(Is)) {
            str2 = Is;
        } else if (Util.isNullOrNil(str2)) {
            str2 = aa.getDisplayName(str);
        }
        AppMethodBeat.o(27284);
        return str2;
    }

    public void onClick(View view) {
        AppMethodBeat.i(27285);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        int id = view.getId();
        if (id == R.id.h07) {
            as asVar = this.rjX;
            if (asVar == null) {
                Log.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
            } else if (c.oR(asVar.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_Scene", this.mScene);
                intent.putExtra("Contact_User", asVar.field_username);
                intent.putExtra("view_mode", true);
                intent.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference) this.nRm.bmg("contact_profile_phone")).KcI);
                intent.putExtra("contact_phone_number_list", asVar.fuX);
                com.tencent.mm.plugin.profile.b.jRt.l(intent, this.mContext);
            } else if (!Util.isNullOrNil(asVar.field_encryptUsername)) {
                a(asVar.field_encryptUsername, asVar);
            } else {
                a(asVar.field_username, asVar);
            }
        } else if (id == R.id.fiq) {
            if (this.Bcm != null) {
                this.Bcm.eDQ();
            }
        } else if (id == R.id.bcs) {
            String str = this.rjX.field_username;
            Intent intent2 = new Intent(this.mContext, ProfileHdHeadImg.class);
            intent2.putExtra(ch.COL_USERNAME, str);
            Context context = this.mContext;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(((Activity) this.mContext).getIntent())), 16, 1, this.rjX.field_username);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27285);
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.i(27286);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
        if (view.getId() == R.id.bd_) {
            final TextView textView = (TextView) view;
            final as asVar = this.rjX;
            if (textView.getText() != null) {
                final String charSequence = textView.getText().toString();
                int indexOf = charSequence.indexOf(58);
                if (indexOf >= 0 && indexOf < charSequence.length()) {
                    charSequence = charSequence.substring(indexOf + 1).trim();
                }
                SpannableString spannableString = new SpannableString(textView.getText());
                spannableString.setSpan(new BackgroundColorSpan(this.mContext.getResources().getColor(R.color.ws)), indexOf + 2, textView.getText().length(), 33);
                textView.setText(spannableString);
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(this.mContext, textView);
                aVar.QSs = new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.AnonymousClass3 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(231887);
                        contextMenu.add(NormalProfileHeaderPreference.this.mContext.getString(R.string.t_));
                        AppMethodBeat.o(231887);
                    }
                };
                aVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(231888);
                        if (i2 == 0) {
                            ClipboardHelper.setText(charSequence);
                            com.tencent.mm.ui.base.h.cC(NormalProfileHeaderPreference.this.mContext, NormalProfileHeaderPreference.this.mContext.getString(R.string.ta));
                        }
                        AppMethodBeat.o(231888);
                    }
                };
                aVar.QwU = new PopupWindow.OnDismissListener() {
                    /* class com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.AnonymousClass5 */

                    public final void onDismiss() {
                        AppMethodBeat.i(231889);
                        NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this, textView, asVar);
                        AppMethodBeat.o(231889);
                    }
                };
                if (textView.getTag(R.id.iu_) instanceof int[]) {
                    int[] iArr = (int[]) textView.getTag(R.id.iu_);
                    aVar.ez(iArr[0], iArr[1]);
                } else {
                    aVar.ez(this.kuv, this.kuw);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(27286);
            return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(27286);
        return false;
    }

    private void a(String str, as asVar) {
        AppMethodBeat.i(27287);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.NormalProfileHeaderPreference", "view stranger remark, username is null");
            AppMethodBeat.o(27287);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.mScene);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", asVar.field_username);
        intent.putExtra("Contact_Nick", asVar.field_nickname);
        intent.putExtra("Contact_RemarkName", asVar.field_conRemark);
        com.tencent.mm.plugin.profile.b.jRt.m(intent, this.mContext);
        AppMethodBeat.o(27287);
    }

    /* access modifiers changed from: package-private */
    public class a {
        private View BgC = null;
        private View BgD = null;
        private View BgE = null;
        private View BgF = null;
        private View BgG = null;
        private View BgH = null;
        ImageView BgI = null;
        TextView BgJ = null;
        MMNeat7extView BgK = null;
        TextView BgL = null;
        TextView BgM = null;
        TextView BgN = null;
        TextView BgO = null;
        TextView BgP = null;
        AvatarPatTipImageView BgQ = null;
        FMessageListView BgR;
        private View BgS;
        LinearLayout BgT = null;
        com.tencent.mm.plugin.textstatus.a.d BgU = null;
        ImageView BgV;
        private ImageView BgW;
        private ImageView BgX;
        View BgY;
        ImageView BgZ;
        View Bha;
        private View Bhb;
        TextView rMV = null;
        TextView ykC = null;

        a(View view) {
            AppMethodBeat.i(27274);
            this.BgY = view.findViewById(R.id.bf);
            this.BgR = (FMessageListView) view.findViewById(R.id.bcx);
            this.BgS = view.findViewById(R.id.bcy);
            this.BgC = view.findViewById(R.id.bcv);
            this.BgD = view.findViewById(R.id.bcq);
            this.BgE = view.findViewById(R.id.bd4);
            this.BgG = view.findViewById(R.id.bcr);
            this.BgH = view.findViewById(R.id.bd6);
            this.BgF = view.findViewById(R.id.bdb);
            this.BgQ = (AvatarPatTipImageView) view.findViewById(R.id.bcs);
            this.BgL = (TextView) view.findViewById(R.id.bcu);
            this.BgK = (MMNeat7extView) view.findViewById(R.id.bd2);
            this.rMV = (TextView) view.findViewById(R.id.bd1);
            this.BgJ = (TextView) view.findViewById(R.id.bcl);
            this.BgI = (ImageView) view.findViewById(R.id.bd7);
            this.ykC = (TextView) view.findViewById(R.id.bd_);
            this.BgM = (TextView) view.findViewById(R.id.bd8);
            this.BgN = (TextView) view.findViewById(R.id.bd0);
            this.BgO = (TextView) view.findViewById(R.id.bcw);
            this.BgP = (TextView) view.findViewById(R.id.bd9);
            this.BgV = (ImageView) view.findViewById(R.id.bcp);
            this.BgW = (ImageView) view.findViewById(R.id.bcn);
            this.BgX = (ImageView) view.findViewById(R.id.bco);
            this.BgZ = (ImageView) view.findViewById(R.id.ba4);
            this.Bha = view.findViewById(R.id.bd3);
            this.Bhb = view.findViewById(R.id.bct);
            this.BgT = (LinearLayout) view.findViewById(R.id.bcz);
            RelativeLayout relativeLayout = (RelativeLayout) this.Bha;
            LinearLayout linearLayout = this.BgT;
            if (p.fvC()) {
                com.tencent.mm.plugin.textstatus.a.d profileCardView = ((com.tencent.mm.plugin.textstatus.a.c) g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).getProfileCardView(((Preference) NormalProfileHeaderPreference.this).mContext, relativeLayout, linearLayout, ((Preference) NormalProfileHeaderPreference.this).mContext.getResources().getDimensionPixelSize(R.dimen.cb));
                relativeLayout.addView(profileCardView.getView());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) profileCardView.getView().getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -2;
                layoutParams.addRule(3, R.id.bcz);
                this.BgU = profileCardView;
            }
            this.BgY.findViewById(R.id.h07).setOnClickListener(NormalProfileHeaderPreference.this);
            this.BgY.findViewById(R.id.fiq).setOnClickListener(NormalProfileHeaderPreference.this);
            this.BgH.setOnClickListener(NormalProfileHeaderPreference.this);
            this.BgF.setOnClickListener(NormalProfileHeaderPreference.this);
            this.BgQ.setOnClickListener(NormalProfileHeaderPreference.this);
            this.BgC.setOnClickListener(NormalProfileHeaderPreference.this);
            this.BgD.setOnClickListener(NormalProfileHeaderPreference.this);
            this.BgE.setOnClickListener(NormalProfileHeaderPreference.this);
            this.BgG.setOnClickListener(NormalProfileHeaderPreference.this);
            this.ykC.setOnTouchListener(new View.OnTouchListener(NormalProfileHeaderPreference.this) {
                /* class com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.a.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(27273);
                    NormalProfileHeaderPreference.this.kuv = (int) motionEvent.getRawX();
                    NormalProfileHeaderPreference.this.kuw = (int) motionEvent.getRawY();
                    view.setTag(R.id.iu_, new int[]{NormalProfileHeaderPreference.this.kuv, NormalProfileHeaderPreference.this.kuw});
                    AppMethodBeat.o(27273);
                    return false;
                }
            });
            this.ykC.setOnLongClickListener(NormalProfileHeaderPreference.this);
            if (this.BgZ != null) {
                this.BgZ.setOnClickListener(NormalProfileHeaderPreference.this);
            }
            AppMethodBeat.o(27274);
        }
    }

    public final com.tencent.mm.plugin.textstatus.a.d eEI() {
        AppMethodBeat.i(231891);
        if (this.zlc != null) {
            com.tencent.mm.plugin.textstatus.a.d dVar = ((a) this.zlc.getTag()).BgU;
            AppMethodBeat.o(231891);
            return dVar;
        }
        AppMethodBeat.o(231891);
        return null;
    }

    public final void b(boolean z, int i2, boolean z2) {
        AppMethodBeat.i(231890);
        int eu = au.eu(super.mContext);
        this.Bgv = z;
        this.Bgw = z2;
        this.Bgx = i2;
        this.Bgy = p.fvC();
        if (i2 <= 0) {
            this.Bgx = eu;
        }
        if (this.nRm != null) {
            this.nRm.notifyDataSetChanged();
        }
        Log.i("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s weuiActionBarHeight=%s", Integer.valueOf(i2), Integer.valueOf(eu));
        AppMethodBeat.o(231890);
    }

    static /* synthetic */ void a(NormalProfileHeaderPreference normalProfileHeaderPreference, TextView textView, as asVar) {
        AppMethodBeat.i(231892);
        textView.setVisibility(0);
        if (!Util.isNullOrNil(asVar.ajx())) {
            textView.setText(com.tencent.mm.plugin.profile.c.br(((Preference) normalProfileHeaderPreference).mContext, asVar.field_username) + com.tencent.mm.plugin.profile.c.ju(asVar.field_username, asVar.ajx()));
            AppMethodBeat.o(231892);
        } else if (as.bjx(asVar.field_username) || ab.IR(asVar.field_username)) {
            textView.setVisibility(8);
            AppMethodBeat.o(231892);
        } else {
            textView.setText(com.tencent.mm.plugin.profile.c.br(((Preference) normalProfileHeaderPreference).mContext, asVar.field_username) + com.tencent.mm.plugin.profile.c.ju(asVar.field_username, Util.nullAsNil(asVar.arK())));
            AppMethodBeat.o(231892);
        }
    }
}
