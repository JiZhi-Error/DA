package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.preference.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference extends Preference implements e.a, n.a, MStorageEx.IOnStorageChange {
    private ImageView Bdg;
    private boolean BfG;
    private boolean BfM = false;
    private boolean Bhy = false;
    private ImageView DjI;
    int Dkc;
    private TextView IkU;
    private String KcI;
    private String KcJ;
    private Button KpA;
    private TextView KpB;
    private ImageView KpC;
    private CheckBox KpD;
    private ImageView KpE;
    private ImageView KpF;
    private LinearLayout KpG;
    private Button KpH;
    private FMessageListView KpI;
    private RelativeLayout KpJ;
    private ImageView KpK;
    private int KpL = 0;
    private boolean KpM = false;
    private boolean KpN = false;
    private boolean KpO = false;
    private boolean KpP = false;
    private boolean KpQ = false;
    private boolean KpR = false;
    private boolean KpS = false;
    private boolean KpT = false;
    private String KpU;
    private ProfileMobilePhoneView KpV;
    private ProfileDescribeView KpW;
    private ProfileLabelView KpX;
    private TextView KpY;
    public View.OnClickListener KpZ;
    private TextView Kpw;
    private TextView Kpx;
    private View Kpy;
    private Button Kpz;
    public String Kqa = null;
    as contact;
    MMActivity gte;
    private String gwx = "";
    private boolean rFe = false;
    private TextView rMV;
    private String wZz;
    private TextView ykC;

    static /* synthetic */ void e(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.i(232345);
        normalUserHeaderPreference.grN();
        AppMethodBeat.o(232345);
    }

    static /* synthetic */ void f(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.i(31893);
        normalUserHeaderPreference.grP();
        AppMethodBeat.o(31893);
    }

    static /* synthetic */ void g(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.i(31894);
        normalUserHeaderPreference.grL();
        AppMethodBeat.o(31894);
    }

    static /* synthetic */ boolean i(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.i(232346);
        boolean eEa = normalUserHeaderPreference.eEa();
        AppMethodBeat.o(232346);
        return eEa;
    }

    static /* synthetic */ boolean j(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.i(31896);
        boolean z = normalUserHeaderPreference.rFe;
        AppMethodBeat.o(31896);
        return z;
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(31868);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(31868);
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(31869);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(31869);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(31871);
        if (this.KpI != null) {
            this.KpI.detach();
        }
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(31871);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        b[] a2;
        AppMethodBeat.i(31872);
        Log.d("MicroMsg.ContactInfoHeader", "onBindView");
        this.rMV = (TextView) view.findViewById(R.id.bb8);
        this.ykC = (TextView) view.findViewById(R.id.bc2);
        this.KpB = (TextView) view.findViewById(R.id.ba9);
        this.Kpw = (TextView) view.findViewById(R.id.bak);
        this.Kpx = (TextView) view.findViewById(R.id.bb9);
        this.Kpz = (Button) view.findViewById(R.id.bbd);
        this.KpA = (Button) view.findViewById(R.id.bbl);
        this.KpV = (ProfileMobilePhoneView) view.findViewById(R.id.fh5);
        ProfileMobilePhoneView profileMobilePhoneView = this.KpV;
        bg.aVF();
        profileMobilePhoneView.KcU = ((Boolean) c.azQ().get(ar.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE)).booleanValue();
        this.KpW = (ProfileDescribeView) view.findViewById(R.id.bn1);
        this.KpX = (ProfileLabelView) view.findViewById(R.id.e70);
        this.KpY = (TextView) view.findViewById(R.id.hl_);
        this.KpW.setOnClickListener(this.KpZ);
        this.KpX.setOnClickListener(this.KpZ);
        this.KpY.setOnClickListener(this.KpZ);
        if (z.Im(this.contact.field_username) || (!Util.isNullOrNil(this.contact.field_username) && ab.Jv(this.contact.field_username))) {
            this.KpY.setVisibility(8);
            this.KpV.setVisibility(8);
            this.KpW.setVisibility(8);
            this.KpX.setVisibility(8);
        } else {
            this.KpV.rjX = this.contact;
            this.KpV.my(this.KcI, this.KcJ);
            if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
                this.KpV.setVisibility(8);
            } else {
                this.KpV.setVisibility(0);
            }
            boolean aj = this.KpW.aj(this.contact);
            boolean aj2 = this.KpX.aj(this.contact);
            if (aj || aj2) {
                this.KpY.setVisibility(8);
            } else {
                if (this.KpS || this.KpQ) {
                    this.KpY.setVisibility(8);
                } else {
                    this.KpY.setVisibility(0);
                }
                if (this.Kqa != null && (this.Kqa.equals("ContactWidgetBottleContact") || this.Kqa.equals("ContactWidgetQContact"))) {
                    this.KpY.setVisibility(8);
                }
            }
        }
        this.IkU = (TextView) view.findViewById(R.id.bav);
        this.KpH = (Button) view.findViewById(R.id.bap);
        this.KpI = (FMessageListView) view.findViewById(R.id.baq);
        a.C2029a aVar = new a.C2029a();
        aVar.talker = this.contact.field_username;
        aVar.scene = this.Dkc;
        aVar.wZz = this.wZz;
        aVar.Kpf = this.contact.fuY;
        aVar.type = 0;
        if (this.Dkc == 18) {
            aVar.type = 1;
        } else if (bp.sb(this.Dkc)) {
            aVar.type = 2;
        }
        this.KpI.setFMessageArgs(aVar);
        this.Kpy = view.findViewById(R.id.hss);
        this.KpG = (LinearLayout) view.findViewById(R.id.dns);
        this.Bdg = (ImageView) view.findViewById(R.id.baa);
        this.DjI = (ImageView) view.findViewById(R.id.bbi);
        this.KpC = (ImageView) view.findViewById(R.id.bc9);
        this.KpD = (CheckBox) view.findViewById(R.id.bbm);
        this.KpE = (ImageView) view.findViewById(R.id.bbk);
        this.KpF = (ImageView) view.findViewById(R.id.bbj);
        this.KpK = (ImageView) view.findViewById(R.id.bbz);
        this.KpJ = (RelativeLayout) view.findViewById(R.id.bc0);
        this.rFe = true;
        initView();
        if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            Log.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
            this.KpI.setVisibility(8);
            if (this.KpI.getVisibility() == 8 && this.KpY.getVisibility() == 8 && this.KpX.getVisibility() == 8 && this.KpW.getVisibility() == 8 && this.IkU.getVisibility() == 8) {
                this.Kpy.setVisibility(8);
            }
        } else if (this.wZz == null || this.wZz.length() == 0) {
            Log.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.Dkc + ", verifyTicket = " + this.wZz);
            this.KpI.setVisibility(8);
            if (this.KpI.getVisibility() == 8 && this.KpY.getVisibility() == 8 && this.KpX.getVisibility() == 8 && this.KpW.getVisibility() == 8 && this.IkU.getVisibility() == 8) {
                this.Kpy.setVisibility(8);
            }
        } else {
            Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.Dkc);
            if (this.Dkc == 18) {
                Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
                a2 = b.a(this.gte, d.bgO().bkx(this.contact.field_username));
            } else if (bp.sb(this.Dkc)) {
                Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
                a2 = b.a(this.gte, d.bgP().bkW(this.contact.field_username));
            } else {
                Log.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
                a2 = b.a(this.gte, d.bgM().bku(this.contact.field_username));
            }
            if (a2 == null || a2.length == 0) {
                Log.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
                this.KpI.setVisibility(8);
                if (this.KpI.getVisibility() == 8 && this.KpY.getVisibility() == 8 && this.KpX.getVisibility() == 8 && this.KpW.getVisibility() == 8 && this.IkU.getVisibility() == 8) {
                    this.Kpy.setVisibility(8);
                }
            } else {
                Log.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + a2.length);
                for (b bVar : a2) {
                    if (bVar != null) {
                        Log.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + bVar.username + ", nickname = " + bVar.nickname + ", digest = " + bVar.iAq + ", addScene = " + bVar.Dkc);
                    }
                }
                if (as.bjp(this.contact.field_username)) {
                    this.KpI.setVisibility(8);
                    this.KpI.setHide(true);
                } else {
                    this.KpI.setVisibility(0);
                    this.KpI.setHide(false);
                }
                if (this.KpI.getVisibility() == 0 || this.KpY.getVisibility() == 0 || this.KpX.getVisibility() == 0 || this.KpW.getVisibility() == 0 || this.IkU.getVisibility() == 0) {
                    this.Kpy.setVisibility(0);
                }
                for (b bVar2 : a2) {
                    this.KpI.a(bVar2);
                }
            }
        }
        super.onBindView(view);
        AppMethodBeat.o(31872);
    }

    private boolean eEa() {
        return this.rFe && this.contact != null;
    }

    private void eNP() {
        AppMethodBeat.i(31874);
        a.b.c(this.Bdg, this.contact.field_username);
        if (this.Bdg != null) {
            int aG = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.f3063h);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 88);
            if (aG <= fromDPToPix) {
                fromDPToPix = aG;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
            layoutParams.setMargins(0, 0, com.tencent.mm.cb.a.aH(this.mContext, R.dimen.hv), 0);
            this.Bdg.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(31874);
    }

    private void grI() {
        AppMethodBeat.i(31875);
        this.KpB.setVisibility(0);
        this.rMV.setText(l.b(this.gte, Util.nullAsNil(this.contact.arI()) + " ", this.rMV.getTextSize()));
        eNP();
        this.KpH.setVisibility(8);
        this.ykC.setVisibility(8);
        this.KpI.setVisibility(8);
        if (this.KpI.getVisibility() == 8 && this.KpY.getVisibility() == 8 && this.KpX.getVisibility() == 8 && this.KpW.getVisibility() == 8 && this.IkU.getVisibility() == 8) {
            this.Kpy.setVisibility(8);
        }
        this.Kpz.setVisibility(8);
        this.KpA.setVisibility(8);
        this.KpD.setVisibility(8);
        if (this.KpX != null) {
            this.KpX.setVisibility(8);
        }
        if (this.KpV != null) {
            this.KpV.setVisibility(8);
        }
        if (this.KpW != null) {
            this.KpW.setVisibility(8);
        }
        if (this.KpY != null) {
            this.KpY.setVisibility(8);
        }
        if (this.Kpx != null) {
            this.Kpx.setVisibility(8);
        }
        AppMethodBeat.o(31875);
    }

    private void initView() {
        Bitmap bitmap;
        AppMethodBeat.i(31876);
        if (!eEa()) {
            Log.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.rFe + "contact = " + this.contact);
            AppMethodBeat.o(31876);
        } else if (this.BfM) {
            grI();
            AppMethodBeat.o(31876);
        } else {
            boolean IG = as.IG(this.contact.field_username);
            if (IG) {
                this.rMV.setText("");
                if (as.bjz(z.aTY()).equals(this.contact.field_username)) {
                    this.KpH.setVisibility(8);
                }
            } else {
                this.rMV.setText(l.b(this.gte, Util.nullAsNil(this.contact.field_nickname) + " ", this.rMV.getTextSize()));
            }
            this.DjI.setVisibility(0);
            this.KpO = true;
            if (this.contact.fuA == 1) {
                this.DjI.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, R.raw.ic_sex_male));
                this.DjI.setContentDescription(this.mContext.getString(R.string.fqk));
            } else if (this.contact.fuA == 2) {
                this.DjI.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, R.raw.ic_sex_female));
                this.DjI.setContentDescription(this.mContext.getString(R.string.fqj));
            } else if (this.contact.fuA == 0) {
                this.DjI.setVisibility(8);
                this.KpO = false;
            }
            if (this.contact.field_verifyFlag != 0) {
                this.KpC.setVisibility(0);
                if (ay.a.iDs != null) {
                    bitmap = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(this.contact.field_verifyFlag), 2.0f);
                } else {
                    bitmap = null;
                }
                this.KpC.setImageBitmap(bitmap);
                this.KpL = bitmap == null ? 0 : bitmap.getWidth();
            }
            eNP();
            grQ();
            this.Bdg.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(31858);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    String str = NormalUserHeaderPreference.this.contact.field_username;
                    if (as.IG(str)) {
                        str = as.bjz(str);
                    }
                    Intent intent = new Intent(NormalUserHeaderPreference.this.gte, ProfileHdHeadImg.class);
                    intent.putExtra(ch.COL_USERNAME, str);
                    MMActivity mMActivity = NormalUserHeaderPreference.this.gte;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mMActivity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(31858);
                }
            });
            this.KpK.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(31859);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    o.bB(NormalUserHeaderPreference.this.gte, NormalUserHeaderPreference.this.contact.field_username);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(31859);
                }
            });
            if (as.bjo(this.contact.field_username)) {
                this.ykC.setText(this.mContext.getString(R.string.us) + this.contact.arK());
            } else if (as.bjm(this.contact.field_username)) {
                this.ykC.setText(this.mContext.getString(R.string.v8) + this.contact.arK());
            } else if (this.BfG) {
                if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
                    grJ();
                } else if (this.contact.fuL == null || this.contact.fuL.equals("")) {
                    this.ykC.setText(R.string.ty);
                } else {
                    this.ykC.setText(this.contact.fuL);
                }
            } else if (IG) {
                this.ykC.setText((Util.nullAsNil(aa.It(this.contact.getProvince())) + " " + Util.nullAsNil(this.contact.getCity())).trim());
            } else {
                if (!as.bjn(this.contact.field_username) && this.gte.getIntent().getBooleanExtra("Contact_ShowUserName", true)) {
                    if (Util.isNullOrNil(this.contact.ajx()) && (as.bjx(this.contact.field_username) || ab.IR(this.contact.field_username))) {
                        this.ykC.setVisibility(8);
                    } else if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
                        grJ();
                    }
                }
                this.ykC.setVisibility(8);
            }
            if (ab.Jv(this.contact.field_username)) {
                this.IkU.setVisibility(0);
            } else {
                this.IkU.setVisibility(8);
            }
            grN();
            grL();
            grP();
            grM();
            this.Kpz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(31860);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    NormalUserHeaderPreference.this.KpQ = false;
                    NormalUserHeaderPreference normalUserHeaderPreference = NormalUserHeaderPreference.this;
                    bg.aVF();
                    as Kn = c.aSN().Kn(normalUserHeaderPreference.contact.field_username);
                    if (!(Kn == null || ((int) Kn.gMZ) == 0 || !Kn.field_username.equals(normalUserHeaderPreference.contact.field_username))) {
                        normalUserHeaderPreference.contact = Kn;
                    }
                    if (!com.tencent.mm.contact.c.oR(normalUserHeaderPreference.contact.field_type)) {
                        Intent intent = new Intent();
                        intent.setClassName(normalUserHeaderPreference.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
                        intent.putExtra("Contact_Scene", normalUserHeaderPreference.Dkc);
                        intent.putExtra("Contact_mode_name_type", 0);
                        intent.putExtra("Contact_ModStrangerRemark", true);
                        intent.putExtra("Contact_User", normalUserHeaderPreference.contact.field_username);
                        intent.putExtra("Contact_Nick", normalUserHeaderPreference.contact.field_nickname);
                        intent.putExtra("Contact_RemarkName", normalUserHeaderPreference.contact.field_conRemark);
                        Activity activity = (Activity) normalUserHeaderPreference.mContext;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        activity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else {
                        Intent intent2 = new Intent();
                        intent2.setClassName(normalUserHeaderPreference.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
                        intent2.putExtra("Contact_Scene", normalUserHeaderPreference.Dkc);
                        intent2.putExtra("Contact_User", normalUserHeaderPreference.contact.field_username);
                        intent2.putExtra("Contact_RoomNickname", normalUserHeaderPreference.gte.getIntent().getStringExtra("Contact_RoomNickname"));
                        Activity activity2 = (Activity) normalUserHeaderPreference.mContext;
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(activity2, bl2.axQ(), "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        activity2.startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(activity2, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference", "dealModRemarkEvent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(31860);
                }
            });
            this.KpA.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(31861);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", NormalUserHeaderPreference.this.contact.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 3);
                    com.tencent.mm.br.c.b(NormalUserHeaderPreference.this.gte, "sns", ".ui.SnsPermissionUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(31861);
                }
            });
            grK();
            this.ykC.setLongClickable(true);
            this.ykC.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass5 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(31865);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (NormalUserHeaderPreference.this.ykC.getText() != null) {
                        final String charSequence = NormalUserHeaderPreference.this.ykC.getText().toString();
                        int indexOf = charSequence.indexOf(58);
                        if (indexOf >= 0 && indexOf < charSequence.length()) {
                            charSequence = charSequence.substring(indexOf + 1).trim();
                        }
                        SpannableString spannableString = new SpannableString(NormalUserHeaderPreference.this.ykC.getText());
                        spannableString.setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.this.gte.getResources().getColor(R.color.ws)), indexOf + 1, NormalUserHeaderPreference.this.ykC.getText().length(), 33);
                        NormalUserHeaderPreference.this.ykC.setText(spannableString);
                        com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(NormalUserHeaderPreference.this.gte, NormalUserHeaderPreference.this.ykC);
                        aVar.QSs = new View.OnCreateContextMenuListener() {
                            /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass5.AnonymousClass1 */

                            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                                AppMethodBeat.i(31862);
                                contextMenu.add(NormalUserHeaderPreference.this.gte.getString(R.string.t_));
                                AppMethodBeat.o(31862);
                            }
                        };
                        aVar.HLY = new o.g() {
                            /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass5.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(31863);
                                if (i2 == 0) {
                                    ClipboardHelper.setText(charSequence);
                                    h.cC(NormalUserHeaderPreference.this.gte, NormalUserHeaderPreference.this.gte.getString(R.string.ta));
                                }
                                AppMethodBeat.o(31863);
                            }
                        };
                        aVar.QwU = new PopupWindow.OnDismissListener() {
                            /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass5.AnonymousClass3 */

                            public final void onDismiss() {
                                AppMethodBeat.i(31864);
                                NormalUserHeaderPreference.this.grJ();
                                AppMethodBeat.o(31864);
                            }
                        };
                        aVar.ez(0, 0);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/pluginsdk/ui/preference/NormalUserHeaderPreference$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(31865);
                    return true;
                }
            });
            AppMethodBeat.o(31876);
        }
    }

    public final void grJ() {
        AppMethodBeat.i(31877);
        this.ykC.setVisibility(0);
        if (!Util.isNullOrNil(this.contact.ajx())) {
            this.ykC.setText(com.tencent.mm.plugin.profile.c.br(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.ju(this.contact.field_username, this.contact.ajx()));
            AppMethodBeat.o(31877);
        } else if (as.bjx(this.contact.field_username) || ab.IR(this.contact.field_username)) {
            this.ykC.setVisibility(8);
            AppMethodBeat.o(31877);
        } else {
            this.ykC.setText(com.tencent.mm.plugin.profile.c.br(this.mContext, this.contact.field_username) + com.tencent.mm.plugin.profile.c.ju(this.contact.field_username, Util.nullAsNil(this.contact.arK())));
            AppMethodBeat.o(31877);
        }
    }

    private void grK() {
        int fromDPToPix;
        AppMethodBeat.i(31878);
        int i2 = 0;
        if (this.KpO) {
            i2 = com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 17) + 0;
        }
        int i3 = i2 + this.KpL;
        if (this.KpM) {
            i3 += com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 27);
        }
        if (this.KpN) {
            i3 += com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 27);
        }
        if (this.KpP) {
            i3 += com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 30);
        }
        if (com.tencent.mm.cb.a.jk(this.mContext)) {
            fromDPToPix = i3 + com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 88);
        } else {
            fromDPToPix = i3 + com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 64);
        }
        this.rMV.setMaxWidth(this.gte.getResources().getDisplayMetrics().widthPixels - (fromDPToPix + com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 60)));
        AppMethodBeat.o(31878);
    }

    public final void dc(String str, boolean z) {
        AppMethodBeat.i(31879);
        if (str != null && str.equals(this.contact.field_username)) {
            this.KpQ = z;
        }
        AppMethodBeat.o(31879);
    }

    public final void dd(String str, boolean z) {
        AppMethodBeat.i(31880);
        if (str != null && str.equals(this.contact.field_username)) {
            this.KpR = z;
        }
        AppMethodBeat.o(31880);
    }

    public final void a(as asVar, int i2, String str, String str2, String str3) {
        AppMethodBeat.i(31881);
        this.KcI = str2;
        this.KcJ = str3;
        a(asVar, i2, str);
        AppMethodBeat.o(31881);
    }

    public final void a(as asVar, int i2, String str) {
        boolean z = true;
        AppMethodBeat.i(31882);
        onDetach();
        bg.aVF();
        c.aSN().add(this);
        bg.aVF();
        c.aSO().a(this);
        p.aYn().d(this);
        this.contact = asVar;
        this.Dkc = i2;
        this.wZz = str;
        this.BfG = this.gte.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.KpT = this.gte.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        this.KpQ = this.gte.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.KpR = this.gte.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.KpS = this.gte.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        this.Bhy = this.gte.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.KpU = this.gte.getIntent().getStringExtra("Contact_RoomNickname");
        this.BfM = asVar.field_deleteFlag == 1;
        this.gwx = this.gte.getIntent().getStringExtra("room_name");
        if (Util.nullAsNil(asVar.field_username).length() <= 0) {
            z = false;
        }
        Assert.assertTrue("initView: contact username is null", z);
        initView();
        AppMethodBeat.o(31882);
    }

    public final void onDetach() {
        AppMethodBeat.i(31883);
        if (this.KpI != null) {
            this.KpI.detach();
        }
        if (this.KpT) {
            d.bgN().bks(this.contact.field_username);
        }
        this.gte.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.KpQ);
        this.gte.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.KpR);
        bg.aVF();
        c.aSN().remove(this);
        p.aYn().e(this);
        bg.aVF();
        c.aSO().b(this);
        AppMethodBeat.o(31883);
    }

    private void grL() {
        int i2 = 0;
        AppMethodBeat.i(31884);
        if (this.KpE != null && ab.Iu(this.contact.field_username)) {
            this.KpN = this.contact.arB();
            this.KpE.setVisibility(this.KpN ? 0 : 8);
        }
        if (this.KpF != null && ab.Iu(this.contact.field_username)) {
            this.KpM = aKt(this.contact.field_username);
            ImageView imageView = this.KpF;
            if (!this.KpM) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
        AppMethodBeat.o(31884);
    }

    private void grM() {
        AppMethodBeat.i(31885);
        if (Util.isNullOrNil(this.KpU)) {
            this.Kpw.setVisibility(8);
            AppMethodBeat.o(31885);
            return;
        }
        if (!z.Im(this.contact.field_username) && Util.nullAsNil(this.contact.field_conRemark).length() > 0) {
            this.ykC.setVisibility(8);
        }
        this.Kpw.setVisibility(0);
        this.Kpw.setText(l.b(this.gte, this.gte.getString(R.string.ba2) + this.KpU, this.Kpw.getTextSize()));
        AppMethodBeat.o(31885);
    }

    private void grN() {
        AppMethodBeat.i(31886);
        if (z.Im(this.contact.field_username) || Util.nullAsNil(this.contact.field_conRemark).length() <= 0) {
            this.Kpx.setVisibility(8);
            this.rMV.setText(l.b(this.gte, Util.nullAsNil(this.contact.arI()) + " ", this.rMV.getTextSize()));
            if (this.KpS) {
                this.Kpz.setVisibility(0);
                this.KpY.setVisibility(8);
            } else if (this.KpQ) {
                this.Kpz.setVisibility(0);
                this.KpY.setVisibility(8);
            } else {
                if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
                    this.Kpz.setVisibility(8);
                }
                boolean aj = this.KpW.aj(this.contact);
                boolean aj2 = this.KpX.aj(this.contact);
                if (aj || aj2) {
                    this.KpY.setVisibility(8);
                }
            }
        } else {
            this.rMV.setText(l.b(this.gte, Util.nullAsNil(this.contact.field_conRemark) + " ", this.rMV.getTextSize()));
            this.Kpx.setVisibility(0);
            this.Kpx.setText(l.b(this.gte, this.mContext.getString(R.string.bdb) + this.contact.arI(), this.Kpx.getTextSize()));
            this.Kpz.setVisibility(8);
        }
        if (as.bjp(this.contact.field_username)) {
            this.KpY.setText(R.string.bid);
            grO();
        }
        if (this.Bhy && !com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            this.KpA.setVisibility(0);
        } else if (this.KpR) {
            this.KpA.setVisibility(0);
            if (com.tencent.mm.cb.a.jk(this.gte)) {
                this.KpA.setTextSize(0, (float) this.gte.getResources().getDimensionPixelSize(R.dimen.hc));
                this.Kpz.setTextSize(0, (float) this.gte.getResources().getDimensionPixelSize(R.dimen.hc));
            }
        } else {
            this.KpA.setVisibility(8);
        }
        if (as.IG(this.contact.field_username)) {
            this.rMV.setText("");
        }
        if (this.Dkc == 76 && this.contact.field_username != null && this.contact.field_username.endsWith("@stranger")) {
            this.rMV.setText(l.b(this.gte, Util.nullAsNil(this.contact.field_nickname) + " ", this.rMV.getTextSize()));
        }
        if (this.KpA.getVisibility() == 0 && this.Kpx.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Kpx.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.k5);
            this.Kpx.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(31886);
    }

    private void grO() {
        AppMethodBeat.i(31887);
        if (this.KpG == null) {
            AppMethodBeat.o(31887);
            return;
        }
        View findViewById = this.KpG.findViewById(R.id.ec3);
        if (findViewById == null) {
            AppMethodBeat.o(31887);
            return;
        }
        findViewById.setVisibility(8);
        AppMethodBeat.o(31887);
    }

    private void grP() {
        AppMethodBeat.i(31888);
        this.KpD.setClickable(false);
        if ((ab.Iu(this.contact.field_username) || as.bjp(this.contact.field_username)) && com.tencent.mm.contact.c.oR(this.contact.field_type) && !z.Im(this.contact.field_username)) {
            this.KpD.setVisibility(0);
            if (this.contact.arA()) {
                this.KpD.setChecked(true);
                this.KpP = true;
                AppMethodBeat.o(31888);
                return;
            }
            this.KpD.setChecked(false);
            this.KpD.setVisibility(8);
            this.KpP = false;
            AppMethodBeat.o(31888);
            return;
        }
        this.KpP = false;
        this.KpD.setVisibility(8);
        AppMethodBeat.o(31888);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(31889);
        if (!eEa()) {
            Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.rFe + "contact = " + this.contact);
            AppMethodBeat.o(31889);
        } else if (Util.nullAsNil(str).length() <= 0) {
            Log.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = ".concat(String.valueOf(str)));
            AppMethodBeat.o(31889);
        } else {
            if (str.equals(this.contact.field_username)) {
                initView();
            }
            AppMethodBeat.o(31889);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(31890);
        Log.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
        if (obj == null || !(obj instanceof String)) {
            Log.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(31890);
            return;
        }
        String str = (String) obj;
        Log.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + str + ", contact = " + this.contact);
        if (!eEa()) {
            Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.rFe + "contact = " + this.contact);
            AppMethodBeat.o(31890);
        } else if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(31890);
        } else {
            if (this.contact != null && this.contact.field_username.equals(str)) {
                bg.aVF();
                this.contact = c.aSN().Kn(str);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(31866);
                        NormalUserHeaderPreference.e(NormalUserHeaderPreference.this);
                        NormalUserHeaderPreference.f(NormalUserHeaderPreference.this);
                        NormalUserHeaderPreference.g(NormalUserHeaderPreference.this);
                        if (NormalUserHeaderPreference.this.KpI != null) {
                            NormalUserHeaderPreference.this.KpI.setReplyBtnVisible(!com.tencent.mm.contact.c.oR(NormalUserHeaderPreference.this.contact.field_type));
                        }
                        AppMethodBeat.o(31866);
                    }
                });
            }
            AppMethodBeat.o(31890);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.n.a
    public final void a(final cn cnVar) {
        AppMethodBeat.i(31891);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(31867);
                if (!(NormalUserHeaderPreference.this.contact == null || cnVar == null || !NormalUserHeaderPreference.this.contact.field_username.equals(cnVar.field_encryptUsername))) {
                    NormalUserHeaderPreference.this.contact.BD(cnVar.field_conRemark);
                    if (!NormalUserHeaderPreference.i(NormalUserHeaderPreference.this)) {
                        Log.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.j(NormalUserHeaderPreference.this) + "contact = " + NormalUserHeaderPreference.this.contact.field_username);
                        AppMethodBeat.o(31867);
                        return;
                    }
                    NormalUserHeaderPreference.e(NormalUserHeaderPreference.this);
                }
                AppMethodBeat.o(31867);
            }
        });
        AppMethodBeat.o(31891);
    }

    private void grQ() {
        AppMethodBeat.i(31892);
        if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck()) {
            this.KpJ.setVisibility(8);
            AppMethodBeat.o(31892);
            return;
        }
        com.tencent.mm.plugin.story.api.e eVar = (com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class);
        if (eVar.isStoryExist(this.contact.field_username)) {
            this.KpJ.setVisibility(0);
            this.KpK.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.KpG.getLayoutParams();
            layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 166);
            this.KpG.setLayoutParams(layoutParams);
        } else {
            this.KpJ.setVisibility(8);
            this.KpK.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.KpG.getLayoutParams();
            layoutParams2.topMargin = 0;
            this.KpG.setLayoutParams(layoutParams2);
        }
        eVar.loadStory(this.contact.field_username, this.gwx);
        AppMethodBeat.o(31892);
    }

    private static boolean aKt(String str) {
        AppMethodBeat.i(31873);
        if (com.tencent.mm.plugin.sns.b.o.DCP != null) {
            boolean aKt = com.tencent.mm.plugin.sns.b.o.DCP.aKt(str);
            AppMethodBeat.o(31873);
            return aKt;
        }
        AppMethodBeat.o(31873);
        return false;
    }
}
