package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ad;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.edittext.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

public class SnsCommentFooter extends InputPanelLinearLayout {
    public static String iIm;
    dzo DIu = null;
    com.tencent.mm.ui.widget.cedit.api.c ECK;
    private ImageView ECL;
    private ImageView ECM;
    private Button ECN;
    int ECO = 0;
    private int ECP = -1;
    private int ECQ = -1;
    private String ECR;
    private b ECS = null;
    boolean ECT = false;
    private boolean ECU = false;
    private boolean ECV = KeyBoardUtil.isPortOrientation(getContext());
    public boolean ECW;
    private String ECX = "";
    private boolean ECY = false;
    private a ECZ;
    private c EDa;
    private bt EDb;
    MMActivity gte;
    private Button han;
    private String mSessionId = d.Nj(79);
    private int moe = 0;
    ChatFooterPanel rum;
    int state = 0;
    private ImageButton ziQ;
    private boolean ziS = false;
    public boolean ziT = false;
    private boolean ziU = true;
    boolean ziV = true;
    private TextWatcher ziW = new TextWatcher() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass7 */
        private int EDi = 0;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(98637);
            this.EDi = charSequence == null ? 0 : charSequence.length();
            AppMethodBeat.o(98637);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(98638);
            if (charSequence == null || charSequence.length() < com.tencent.mm.plugin.sns.c.a.DCT) {
                SnsCommentFooter.this.ZI(16);
                Log.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.o(98638);
                return;
            }
            if (charSequence.length() - this.EDi > com.tencent.mm.plugin.sns.c.a.DCT) {
                SnsCommentFooter.this.setCommentFlag(16);
                Log.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
            }
            AppMethodBeat.o(98638);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(98639);
            if (SnsCommentFooter.this.ECK.getText() == null) {
                AppMethodBeat.o(98639);
                return;
            }
            if (e.iY(SnsCommentFooter.this.ECO, 8) && !Util.isNullOrNil(SnsCommentFooter.this.ECR) && SnsCommentFooter.this.ECK.getText() != null && !SnsCommentFooter.this.ECK.getText().toString().startsWith(SnsCommentFooter.this.ECR)) {
                Log.i("MicroMsg.SnsCommentFooter", "cur text %s", SnsCommentFooter.this.ECK.getText());
                SnsCommentFooter.this.ECR = "";
                SnsCommentFooter.this.DIu = null;
                SnsCommentFooter.this.ZI(8);
                SnsCommentFooter.this.state = 0;
            }
            SnsCommentFooter.this.ECK.gYJ();
            boolean z = SnsCommentFooter.this.ECK.getText().toString().trim().length() > 0;
            if (z && SnsCommentFooter.this.ziV) {
                SnsCommentFooter.a(SnsCommentFooter.this, true);
                SnsCommentFooter.this.ziV = false;
            }
            if (!z) {
                SnsCommentFooter.a(SnsCommentFooter.this, false);
                SnsCommentFooter.this.ziV = true;
            }
            AppMethodBeat.o(98639);
        }
    };

    /* access modifiers changed from: package-private */
    public interface a {
        void fhU();
    }

    /* access modifiers changed from: package-private */
    public interface b {
        void kP(String str, String str2);
    }

    /* access modifiers changed from: package-private */
    public interface c {
        void onShow();
    }

    static /* synthetic */ void a(SnsCommentFooter snsCommentFooter, boolean z) {
        AppMethodBeat.i(98671);
        snsCommentFooter.qT(z);
        AppMethodBeat.o(98671);
    }

    static /* synthetic */ void j(SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.i(98672);
        snsCommentFooter.cbL();
        AppMethodBeat.o(98672);
    }

    public void setModeClick(boolean z) {
        this.ziS = z;
    }

    public final boolean fhV() {
        AppMethodBeat.i(98649);
        if (this.ECK.getText() == null || Util.isNullOrNil(this.ECK.getText().toString())) {
            AppMethodBeat.o(98649);
            return true;
        }
        AppMethodBeat.o(98649);
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnsCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(98650);
        this.gte = (MMActivity) context;
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_comment_emoji_enable, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.ECT = z;
            AppMethodBeat.o(98650);
            return;
        }
        this.ECT = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_comment_emoji_enable, 0) != 1 ? false : z2;
        AppMethodBeat.o(98650);
    }

    public void setVisibility(int i2) {
        boolean z = false;
        AppMethodBeat.i(98652);
        this.state = 0;
        if (i2 == 0) {
            z = true;
        }
        vt(z);
        super.setVisibility(i2);
        AppMethodBeat.o(98652);
    }

    public final void vt(boolean z) {
        AppMethodBeat.i(98653);
        if (this.rum == null) {
            AppMethodBeat.o(98653);
            return;
        }
        this.ECW = z;
        Log.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(z)));
        if (!z) {
            this.rum.setVisibility(8);
            this.ziQ.setImageResource(R.raw.icons_outlined_emoji);
            this.gte.hideVKB();
            requestLayout();
            AppMethodBeat.o(98653);
            return;
        }
        iIm = d.Nj(79);
        if (this.state == 0) {
            this.ECK.gYJ();
            this.gte.showVKB();
            this.rum.setVisibility(8);
        } else {
            this.ECK.gYJ();
            this.gte.hideVKB();
            cbL();
        }
        this.ziU = false;
        AppMethodBeat.o(98653);
    }

    private void cbL() {
        AppMethodBeat.i(98654);
        this.rum.onResume();
        if (!KeyBoardUtil.isPortOrientation(getContext()) || !fia()) {
            this.rum.setVisibility(0);
        } else {
            getInputPanelHelper().aQ(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(98635);
                    SnsCommentFooter.this.rum.setVisibility(0);
                    AppMethodBeat.o(98635);
                }
            });
        }
        if (this.EDa != null) {
            this.EDa.onShow();
        }
        AppMethodBeat.o(98654);
    }

    public final boolean fhW() {
        return this.state == 1;
    }

    public final void fhX() {
        AppMethodBeat.i(98655);
        if (this.ECK == null) {
            Log.e("MicroMsg.SnsCommentFooter", "send edittext is null");
            AppMethodBeat.o(98655);
            return;
        }
        this.ECK.removeTextChangedListener(this.ziW);
        this.ECK.addTextChangedListener(this.ziW);
        AppMethodBeat.o(98655);
    }

    public int getCommentFlag() {
        return this.ECO;
    }

    public void setCommentFlag(int i2) {
        this.ECO |= i2;
    }

    public final void ZI(int i2) {
        this.ECO &= i2 ^ -1;
    }

    public final void o(final List<k> list, String str) {
        String str2;
        AppMethodBeat.i(98656);
        this.ECX = str;
        if (this.ECK != null) {
            if (!Util.isNullOrNil(str)) {
                Iterator<k> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    k next = it.next();
                    if (str.equals(next.key)) {
                        list.remove(next);
                        str2 = Util.nullAs(next.text, "");
                        break;
                    }
                }
            }
            str2 = "";
            if (!Util.isNullOrNil(str2)) {
                this.ECN.setVisibility(0);
                this.han.setVisibility(8);
                this.ECK.setText("");
                this.ECK.bol(str2);
            } else {
                this.ECK.setText("");
            }
            if (!this.ECY) {
                this.ECK.addTextChangedListener(new TextWatcher() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass8 */
                    int EDi = 0;

                    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        AppMethodBeat.i(98640);
                        if (charSequence == null || charSequence.length() < com.tencent.mm.plugin.sns.c.a.DCT) {
                            SnsCommentFooter.this.ZI(16);
                            Log.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                            AppMethodBeat.o(98640);
                            return;
                        }
                        if (charSequence.length() - this.EDi > com.tencent.mm.plugin.sns.c.a.DCT) {
                            SnsCommentFooter.this.setCommentFlag(16);
                            Log.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
                        }
                        AppMethodBeat.o(98640);
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        AppMethodBeat.i(98641);
                        this.EDi = charSequence == null ? 0 : charSequence.length();
                        AppMethodBeat.o(98641);
                    }

                    public final void afterTextChanged(Editable editable) {
                        boolean z;
                        AppMethodBeat.i(98642);
                        if (SnsCommentFooter.this.ECK.getText() == null) {
                            AppMethodBeat.o(98642);
                            return;
                        }
                        if (e.iY(SnsCommentFooter.this.ECO, 8) && !Util.isNullOrNil(SnsCommentFooter.this.ECR) && !Util.isNullOrNil(SnsCommentFooter.this.ECK.getText().toString()) && !SnsCommentFooter.this.ECK.getText().toString().startsWith(SnsCommentFooter.this.ECR)) {
                            Log.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", SnsCommentFooter.this.ECR, SnsCommentFooter.this.ECK.getText());
                            SnsCommentFooter.this.ECR = "";
                            SnsCommentFooter.this.DIu = null;
                            SnsCommentFooter.this.ZI(8);
                            SnsCommentFooter.this.state = 0;
                        }
                        Log.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.this.ECX);
                        if (!Util.isNullOrNil(SnsCommentFooter.this.ECX)) {
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                k kVar = (k) it.next();
                                if (SnsCommentFooter.this.ECX.equals(kVar.key)) {
                                    Log.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                                    kVar.text = SnsCommentFooter.this.ECK.getText().toString();
                                    kVar.cSx = SnsCommentFooter.this.ECO;
                                    z = true;
                                    break;
                                }
                            }
                            if (!z) {
                                Log.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                                k kVar2 = new k();
                                kVar2.key = SnsCommentFooter.this.ECX;
                                kVar2.text = SnsCommentFooter.this.ECK.getText().toString();
                                kVar2.cSx = SnsCommentFooter.this.ECO;
                                if (kVar2.text != null && kVar2.text.length() > 0) {
                                    list.add(kVar2);
                                }
                            }
                        }
                        if (list.size() > 5) {
                            Log.d("MicroMsg.SnsCommentFooter", "comments remove");
                            list.remove(0);
                        }
                        SnsCommentFooter.this.ECK.gYJ();
                        boolean z2 = SnsCommentFooter.this.ECK.getText().toString().trim().length() > 0;
                        if (z2 && SnsCommentFooter.this.ziV) {
                            SnsCommentFooter.a(SnsCommentFooter.this, z2);
                            SnsCommentFooter.this.ziV = false;
                        }
                        if (!z2) {
                            SnsCommentFooter.a(SnsCommentFooter.this, z2);
                            SnsCommentFooter.this.ziV = true;
                        }
                        AppMethodBeat.o(98642);
                    }
                });
            }
            this.ECY = true;
        }
        AppMethodBeat.o(98656);
    }

    public void setText(String str) {
        AppMethodBeat.i(98657);
        if (this.ECK != null) {
            this.ECK.setText("");
            this.ECK.bol(str);
        }
        AppMethodBeat.o(98657);
    }

    public void setCommentHint(String str) {
        AppMethodBeat.i(98658);
        if (Util.isNullOrNil(str)) {
            this.ECK.setHint("");
            AppMethodBeat.o(98658);
        } else if (e.iY(this.ECO, 1)) {
            this.ECK.setHint(l.b(getContext(), this.gte.getString(R.string.h3a) + str + this.gte.getString(R.string.h4y, new Object[]{Float.valueOf(this.ECK.getTextSize())}), this.ECK.getTextSize()));
            AppMethodBeat.o(98658);
        } else {
            this.ECK.setHint(l.b(getContext(), str, this.ECK.getTextSize()));
            AppMethodBeat.o(98658);
        }
    }

    public void setCommentInfo(dzo dzo) {
        this.DIu = dzo;
    }

    public void setCommentAtPrefix(String str) {
        this.ECR = str;
    }

    public String getCommentAtPrefix() {
        return this.ECR;
    }

    public final void oY(boolean z) {
        AppMethodBeat.i(98659);
        if (this.ECL != null) {
            if (z) {
                this.ECL.setVisibility(0);
                if (h.aqJ().getInt("SnsAdAtFriendRedDot", 0) != 1 || !g.aAh().azQ().getBoolean(ar.a.NEW_BANDAGE_SNS_AD_COMMENT_AT_RED_DOT_BOOLEAN_SYNC, true)) {
                    this.ECM.setVisibility(8);
                    AppMethodBeat.o(98659);
                    return;
                }
                this.ECM.setVisibility(0);
                AppMethodBeat.o(98659);
                return;
            }
            this.ECL.setVisibility(8);
            this.ECM.setVisibility(8);
        }
        AppMethodBeat.o(98659);
    }

    public final void fhY() {
        AppMethodBeat.i(98660);
        this.ECK.setText("");
        this.ECK.setHint("");
        this.DIu = null;
        this.ECO = 0;
        this.state = 0;
        AppMethodBeat.o(98660);
    }

    public void setFeedEmojiCommentEnable(boolean z) {
        AppMethodBeat.i(176296);
        this.ECU = z;
        Log.i("MicroMsg.SnsCommentFooter", "setFeedEmojiCommentEnable:%s", Boolean.valueOf(z));
        AppMethodBeat.o(176296);
    }

    public dzo getCommentInfo() {
        AppMethodBeat.i(98661);
        if (this.DIu == null) {
            dzo dzo = new dzo();
            AppMethodBeat.o(98661);
            return dzo;
        }
        dzo dzo2 = this.DIu;
        AppMethodBeat.o(98661);
        return dzo2;
    }

    public void setOnEditTouchListener(a aVar) {
        this.ECZ = aVar;
    }

    public void setOnSmileyShowListener(c cVar) {
        this.EDa = cVar;
    }

    public static void a(Context context, Object obj, boolean z, String str, int i2, String str2, long j2) {
        int i3;
        AppMethodBeat.i(203561);
        if (!(obj instanceof SnsInfo)) {
            AppMethodBeat.o(203561);
            return;
        }
        SnsInfo snsInfo = (SnsInfo) obj;
        int i4 = z ? 3 : 2;
        int i5 = 1;
        if (context instanceof SnsTimeLineUI) {
            i5 = 1;
        } else if (context instanceof SnsCommentDetailUI) {
            i5 = 3;
        } else if (context instanceof SnsCommentUI) {
            i5 = 2;
        }
        String str3 = snsInfo.field_userName;
        String Jb = r.Jb(snsInfo.field_snsId);
        if (snsInfo.isAd()) {
            i3 = 2;
        } else if (snsInfo.isWxWork()) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        com.tencent.mm.plugin.websearch.a.b.a(i4, i5, str3, Jb, i3, String.valueOf(str), iIm, i2, str2, j2);
        AppMethodBeat.o(203561);
    }

    public void setToSendTextColor(boolean z) {
        AppMethodBeat.i(98662);
        if (this.ECK == null) {
            AppMethodBeat.o(98662);
        } else if (z) {
            this.ECK.setTextColor(getResources().getColor(R.color.a0_));
            AppMethodBeat.o(98662);
        } else {
            this.ECK.setTextColor(getResources().getColor(R.color.u_));
            Log.i("MicroMsg.SnsCommentFooter", "focusEdt: %s, %s", Boolean.FALSE, this.ECK);
            if (this.ECK != null) {
                this.ECK.clearFocus();
            }
            AppMethodBeat.o(98662);
        }
    }

    public void setOnCommentSendImp(final b bVar) {
        AppMethodBeat.i(98663);
        this.ECS = bVar;
        this.ECN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(203560);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ui.widget.cedit.api.d.a(SnsCommentFooter.this.ECK).aoq(com.tencent.mm.n.c.aqk()).CN(true).a(new c.a() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tw(String str) {
                        AppMethodBeat.i(203558);
                        SnsCommentFooter.this.ECK.getText();
                        bVar.kP(SnsCommentFooter.this.ECK.getText().toString(), "");
                        SnsCommentFooter.this.ECK.setText("");
                        AppMethodBeat.o(203558);
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tx(String str) {
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void dv(String str) {
                        AppMethodBeat.i(203559);
                        com.tencent.mm.ui.base.h.n(SnsCommentFooter.this.gte, R.string.hc2, R.string.hc3);
                        AppMethodBeat.o(203559);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203560);
            }
        });
        AppMethodBeat.o(98663);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(98664);
        super.onConfigurationChanged(configuration);
        if (this.rum != null) {
            fhZ();
        }
        AppMethodBeat.o(98664);
    }

    @Override // com.tencent.mm.ui.widget.b.a, com.tencent.mm.ui.widget.InputPanelLinearLayout
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(98665);
        super.f(z, i2);
        this.ziT = z;
        if (z && getVisibility() == 0 && this.EDb != null) {
            Log.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
            this.EDb.fjX();
        }
        this.ECK.CS(z);
        if (!(this.moe == i2 || i2 == 0)) {
            this.moe = i2;
            i.C(getContext(), i2);
            fhZ();
        }
        AppMethodBeat.o(98665);
    }

    private void fhZ() {
        AppMethodBeat.i(98666);
        int validPanelHeight = KeyBoardUtil.getValidPanelHeight(getContext());
        if (this.rum != null) {
            this.rum.setPortHeightPx(validPanelHeight);
            ViewGroup.LayoutParams layoutParams = this.rum.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = validPanelHeight;
            }
        }
        AppMethodBeat.o(98666);
    }

    private boolean fia() {
        AppMethodBeat.i(98667);
        int aD = ao.aD(getContext());
        Log.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", Integer.valueOf(this.ECQ), Integer.valueOf(this.ECP), Integer.valueOf(aD));
        if (this.ECQ <= 0 || this.ECQ >= this.ECP - aD) {
            AppMethodBeat.o(98667);
            return false;
        }
        AppMethodBeat.o(98667);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(98668);
        super.onLayout(z, i2, i3, i4, i5);
        this.ECP = this.ECP < i5 ? i5 : this.ECP;
        this.ECQ = i5;
        AppMethodBeat.o(98668);
    }

    public final void fib() {
        AppMethodBeat.i(98669);
        this.EDb = null;
        if (this.rum != null) {
            Log.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.rum.goC();
            this.rum.destroy();
        }
        if (this.ECK != null) {
            this.ECK.destroy();
        }
        AppMethodBeat.o(98669);
    }

    public void setAnitiomAdjust(bt btVar) {
        this.EDb = btVar;
    }

    private void qT(boolean z) {
        AppMethodBeat.i(98670);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dd);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.di);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.han == null || this.ECN == null) {
            AppMethodBeat.o(98670);
            return;
        }
        if (z) {
            if (this.han.getVisibility() == 8 || this.han.getVisibility() == 4) {
                AppMethodBeat.o(98670);
                return;
            }
            this.ECN.startAnimation(loadAnimation);
            this.ECN.setVisibility(0);
            this.han.startAnimation(loadAnimation2);
            this.han.setVisibility(8);
        } else if (this.han.getVisibility() == 0 || this.han.getVisibility() == 0) {
            AppMethodBeat.o(98670);
            return;
        } else {
            this.han.startAnimation(loadAnimation);
            this.han.setVisibility(0);
            this.ECN.startAnimation(loadAnimation2);
            this.ECN.setVisibility(8);
        }
        this.ECN.getParent().requestLayout();
        AppMethodBeat.o(98670);
    }

    public void setAfterEditAction(Runnable runnable) {
        AppMethodBeat.i(98651);
        ViewGroup viewGroup = (ViewGroup) inflate(this.gte, R.layout.bvm, this);
        this.ECL = (ImageView) viewGroup.findViewById(R.id.j7);
        this.ECM = (ImageView) viewGroup.findViewById(R.id.j8);
        this.han = (Button) viewGroup.findViewById(R.id.jl);
        this.ECN = (Button) viewGroup.findViewById(R.id.je);
        this.ECK = (com.tencent.mm.ui.widget.cedit.api.c) viewGroup.findViewById(R.id.ja);
        this.ECK.refresh(((PluginWebSearch) g.ah(PluginWebSearch.class)).isUseSysEditText());
        this.ECK.a(((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(this.gte), new a.e() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.edittext.a.e
            public final void A(List<a.c> list, int i2) {
                AppMethodBeat.i(203554);
                long aWB = (long) cl.aWB();
                if (!(!((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag() || i2 == 8 || i2 == 1)) {
                    list.add(new a.c(SnsCommentFooter.this.gte.getString(R.string.hk_), 2));
                    SnsCommentFooter.a(SnsCommentFooter.this.getContext(), SnsCommentFooter.this.getTag(), SnsCommentFooter.r(SnsCommentFooter.this), "", 1, "", aWB);
                }
                AppMethodBeat.o(203554);
            }

            @Override // com.tencent.mm.ui.widget.edittext.a.e
            public final void a(View view, a.c cVar, String str) {
                AppMethodBeat.i(203555);
                long aWB = (long) cl.aWB();
                if (cVar.id == 2) {
                    SnsCommentFooter.this.ECK.getText().insert(SnsCommentFooter.this.ECK.getSelectionStart(), SnsCommentFooter.this.gte.getString(R.string.hk_));
                    SnsCommentFooter.a(SnsCommentFooter.this.getContext(), SnsCommentFooter.this.getTag(), SnsCommentFooter.r(SnsCommentFooter.this), "", 2, "", aWB);
                }
                AppMethodBeat.o(203555);
            }
        });
        this.ECK.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass3 */
            private List<ForegroundColorSpan> EDf = new LinkedList();

            {
                AppMethodBeat.i(203556);
                AppMethodBeat.o(203556);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(203557);
                Editable text = SnsCommentFooter.this.ECK.getText();
                for (ForegroundColorSpan foregroundColorSpan : this.EDf) {
                    text.removeSpan(foregroundColorSpan);
                }
                this.EDf.clear();
                String obj = SnsCommentFooter.this.ECK.getText().toString();
                if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) {
                    Matcher matcher = k.a.Krb.matcher(obj);
                    while (matcher.find()) {
                        matcher.group();
                        int start = matcher.start();
                        int end = matcher.end();
                        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SnsCommentFooter.this.getResources().getColor(R.color.Link_100));
                        this.EDf.add(foregroundColorSpan2);
                        text.setSpan(foregroundColorSpan2, start, end, 33);
                    }
                }
                AppMethodBeat.o(203557);
            }
        });
        qT(false);
        this.ECL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(98643);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (h.aqJ().getInt("SnsAdAtFriendRedDot", 0) == 1) {
                    g.aAh().azQ().set(ar.a.NEW_BANDAGE_SNS_AD_COMMENT_AT_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                }
                SnsCommentFooter.this.ECM.setVisibility(8);
                Intent intent = new Intent();
                intent.putExtra("list_attr", 16391);
                intent.putExtra("block_contact", z.aTY());
                intent.putExtra("max_limit_num", 1);
                intent.putExtra("titile", SnsCommentFooter.this.gte.getString(R.string.h3e));
                com.tencent.mm.br.c.c(SnsCommentFooter.this.gte, ".ui.contact.SelectContactUI", intent, 2333);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98643);
            }
        });
        this.ziQ = (ImageButton) viewGroup.findViewById(R.id.jj);
        this.ziQ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(98644);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsCommentFooter.this.setModeClick(true);
                Log.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.this.state);
                if (SnsCommentFooter.this.state == 0) {
                    SnsCommentFooter.this.ECK.gYJ();
                    SnsCommentFooter.this.gte.hideVKB();
                    SnsCommentFooter.this.state = 1;
                    SnsCommentFooter.j(SnsCommentFooter.this);
                    SnsCommentFooter.this.setToSendTextColor(false);
                    SnsCommentFooter.this.ziQ.setImageResource(R.drawable.oh);
                    SnsCommentFooter.this.ziU = false;
                } else {
                    SnsCommentFooter.m(SnsCommentFooter.this);
                    SnsCommentFooter.this.ziU = false;
                    SnsCommentFooter.this.ECK.gYJ();
                    SnsCommentFooter.this.gte.showVKB();
                    SnsCommentFooter.this.setToSendTextColor(true);
                    SnsCommentFooter.this.ziQ.setImageResource(R.raw.icons_outlined_emoji);
                    SnsCommentFooter.this.state = 0;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98644);
            }
        });
        this.ECK.setHint(this.gte.getString(R.string.hbp));
        this.ECK.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass11 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(98645);
                SnsCommentFooter.this.setToSendTextColor(true);
                SnsCommentFooter.this.ziU = false;
                SnsCommentFooter.m(SnsCommentFooter.this);
                SnsCommentFooter.this.ziQ.setImageResource(R.raw.icons_outlined_emoji);
                if (SnsCommentFooter.this.ECZ != null) {
                    SnsCommentFooter.this.ECZ.fhU();
                }
                SnsCommentFooter.this.state = 0;
                AppMethodBeat.o(98645);
                return false;
            }
        });
        if (com.tencent.mm.pluginsdk.ui.chat.e.Knc == null) {
            this.rum = new com.tencent.mm.pluginsdk.ui.chat.d(this.gte);
            AppMethodBeat.o(98651);
            return;
        }
        this.rum = com.tencent.mm.pluginsdk.ui.chat.e.Knc.eZ(getContext());
        this.rum.setEntranceScene(ChatFooterPanel.KbG);
        this.rum.setVisibility(8);
        this.moe = KeyBoardUtil.getValidPanelHeight(getContext());
        ((LinearLayout) findViewById(R.id.h8v)).addView(this.rum, -1, this.moe);
        if (!this.ECT) {
            this.rum.goD();
        }
        this.rum.onResume();
        this.rum.setOnTextOperationListener(new ChatFooterPanel.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass12 */

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHD() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void eP(boolean z) {
                AppMethodBeat.i(98646);
                SnsCommentFooter.this.setToSendTextColor(z);
                AppMethodBeat.o(98646);
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHC() {
                AppMethodBeat.i(98647);
                if (SnsCommentFooter.this.ECK != null) {
                    if (SnsCommentFooter.this.ECK.getInputConnection() == null) {
                        AppMethodBeat.o(98647);
                        return;
                    } else {
                        SnsCommentFooter.this.ECK.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                        SnsCommentFooter.this.ECK.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                    }
                }
                AppMethodBeat.o(98647);
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void append(String str) {
                AppMethodBeat.i(98648);
                try {
                    SnsCommentFooter.this.ECK.bol(str);
                    AppMethodBeat.o(98648);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SnsCommentFooter", e2, "", new Object[0]);
                    AppMethodBeat.o(98648);
                }
            }
        });
        ac VL = ad.djd.VL();
        VL.djc = new ac.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass1 */

            @Override // com.tencent.mm.api.ac.a
            public final void a(final com.tencent.mm.api.r rVar) {
                String userName;
                AppMethodBeat.i(98631);
                if (rVar instanceof EmojiInfo) {
                    boolean z = false;
                    if (SnsCommentFooter.this.DIu != null && !Util.isNullOrNil(SnsCommentFooter.this.DIu.Username)) {
                        userName = SnsCommentFooter.this.DIu.Username;
                        z = true;
                    } else if (SnsCommentFooter.this.getTag() == null || !(SnsCommentFooter.this.getTag() instanceof SnsInfo)) {
                        AppMethodBeat.o(98631);
                        return;
                    } else {
                        userName = ((SnsInfo) SnsCommentFooter.this.getTag()).getUserName();
                    }
                    if (!SnsCommentFooter.this.ECU) {
                        AppMethodBeat.o(98631);
                        return;
                    }
                    com.tencent.mm.plugin.sns.c.a.jRt.a(SnsCommentFooter.this.gte, userName, ((EmojiInfo) rVar).field_md5, z, new y.a() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                        public final void a(boolean z, String str, int i2) {
                            String str2;
                            AppMethodBeat.i(98630);
                            if (SnsCommentFooter.this.ECS != null && z) {
                                if (e.iY(SnsCommentFooter.this.ECO, 8)) {
                                    str2 = SnsCommentFooter.this.getCommentAtPrefix();
                                } else {
                                    str2 = "";
                                }
                                SnsCommentFooter.this.ECS.kP(str2, ((EmojiInfo) rVar).field_md5);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(150, 81);
                            }
                            AppMethodBeat.o(98630);
                        }
                    });
                }
                AppMethodBeat.o(98631);
            }

            @Override // com.tencent.mm.api.ac.a
            public final void onHide() {
            }
        };
        this.rum.setCallback(VL);
        AppMethodBeat.o(98651);
    }

    static /* synthetic */ void m(SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.i(98673);
        snsCommentFooter.rum.onPause();
        if (KeyBoardUtil.isPortOrientation(snsCommentFooter.getContext())) {
            snsCommentFooter.getInputPanelHelper().aP(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(98636);
                    SnsCommentFooter.this.rum.setVisibility(8);
                    AppMethodBeat.o(98636);
                }
            });
            AppMethodBeat.o(98673);
            return;
        }
        snsCommentFooter.rum.setVisibility(8);
        AppMethodBeat.o(98673);
    }

    static /* synthetic */ boolean r(SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.i(203562);
        if (snsCommentFooter.DIu == null || Util.isNullOrNil(snsCommentFooter.DIu.Username)) {
            AppMethodBeat.o(203562);
            return false;
        }
        AppMethodBeat.o(203562);
        return true;
    }
}
