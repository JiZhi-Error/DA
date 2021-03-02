package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ad;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.cj.a;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.g.b.a.gy;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.ui.d;
import com.tencent.mm.plugin.patmsg.ui.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.plugin.transvoice.b;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout;
import com.tencent.mm.plugin.transvoice.ui.SoundWaveView;
import com.tencent.mm.plugin.transvoice.ui.a.a;
import com.tencent.mm.pluginsdk.model.app.af;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout;
import com.tencent.mm.pluginsdk.ui.chat.a;
import com.tencent.mm.pluginsdk.ui.chat.h;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.chatting.d.ab;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.r;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.MaxHeightScrollView;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.n.n;
import kotlin.t;

public class ChatFooter extends FrameLayout implements com.tencent.mm.plugin.websearch.a.a.a, h.a, com.tencent.mm.ui.tools.g {
    private static com.tencent.mm.plugin.websearch.a.a.c KiM;
    private static int KjB;
    public static final String KlG = (MMApplicationContext.getPackageName() + "chat_footer_sp");
    private static final int[] Klv = {0, 15, 30, 45, 60, 75, 90, 95, 100};
    private static final int[] Klw = {R.raw.amp1, R.raw.amp2, R.raw.amp3, R.raw.amp4, R.raw.amp5, R.raw.amp6, R.raw.amp7, R.raw.amp8};
    private static int count = 0;
    private final long ANIMATION_DURATION;
    public com.tencent.mm.ui.widget.cedit.api.c ECK;
    public p FQS;
    private TextView FQT;
    private ImageView FQU;
    public View FQV;
    private int GtE;
    com.tencent.mm.plugin.transvoice.a.b GvE;
    private String GvJ;
    private int GvK;
    private MTimerHandler GvL;
    private boolean GvM;
    private MMHandler GvO;
    private com.tencent.mm.modelvoiceaddr.b.b GvX;
    private List<String> GvY;
    private int GyD;
    private int IFI;
    f KbA;
    public n Kdp;
    public boolean Kds;
    private i KiA;
    public m KiB;
    private com.tencent.mm.plugin.groupsolitaire.ui.d KiC;
    private b KiD;
    private g KiE;
    private f KiF;
    public final a KiG;
    public boolean KiH;
    private boolean KiI;
    public boolean KiJ;
    private boolean KiK;
    private ImageView KiL;
    public ViewGroup KiN;
    private TextView KiO;
    private View KiP;
    private InputMethodManager KiQ;
    private int KiR;
    private boolean KiS;
    private boolean KiT;
    private boolean KiU;
    public boolean KiV;
    public boolean KiW;
    private boolean KiX;
    public int KiY;
    private int KiZ;
    public String Kij;
    public AppPanel Kik;
    public TextView Kil;
    private Button Kim;
    public ImageButton Kin;
    private View Kio;
    public ChatFooterBottom Kip;
    private TextView Kiq;
    public ImageButton Kir;
    public ImageView Kis;
    public ImageButton Kit;
    public MaxHeightScrollView Kiu;
    private com.tencent.mm.ui.widget.a.d Kiv;
    public LinearLayout Kiw;
    public RelativeLayout Kix;
    private TextView Kiy;
    private WeImageView Kiz;
    private Animation KjA;
    public ViewGroup KjC;
    private View KjD;
    private BlurView KjE;
    private View KjF;
    private View KjG;
    private ImageView KjH;
    private ImageView KjI;
    private View KjJ;
    private TextView KjK;
    private ImageView KjL;
    private View KjM;
    private View KjN;
    private WeImageView KjO;
    private TextView KjP;
    private View KjQ;
    private WeImageView KjR;
    private TextView KjS;
    private View KjT;
    private BlurView KjU;
    private com.tencent.mm.plugin.transvoice.ui.b KjV;
    private com.tencent.mm.plugin.transvoice.a.a KjW;
    private com.tencent.mm.modelvoiceaddr.h KjX;
    public p KjY;
    private com.tencent.mm.plugin.transvoice.a.c KjZ;
    private ChattingScrollLayout Kja;
    private boolean Kjb;
    private int Kjc;
    private int Kjd;
    private boolean Kje;
    public boolean Kjf;
    private boolean Kjg;
    private int Kjh;
    private boolean Kji;
    private int Kjj;
    private int Kjk;
    private int Kjl;
    private int Kjm;
    private boolean Kjn;
    private String Kjo;
    private ab.c Kjp;
    private ab.a Kjq;
    private d.c Kjr;
    com.tencent.mm.g.b.a.j Kjs;
    public c Kjt;
    public d Kju;
    private m.a Kjv;
    private boolean Kjw;
    public MMFragment Kjx;
    public b Kjy;
    private Animation Kjz;
    private WeImageView KkA;
    private View KkB;
    private View KkC;
    private ViewGroup KkD;
    private View KkE;
    private View KkF;
    private WeImageView KkG;
    private WeImageView KkH;
    private View KkI;
    private View KkJ;
    private WeImageView KkK;
    private ViewGroup KkL;
    private View KkM;
    private View KkN;
    private View KkO;
    private WeImageView KkP;
    private View KkQ;
    private int KkR;
    private int KkS;
    private boolean KkT;
    private ChatFooterPanel.a KkU;
    private AppPanel.b KkV;
    private b KkW;
    public i KkX;
    private int KkY;
    private boolean KkZ;
    private l Kka;
    private j Kkb;
    private k Kkc;
    private boolean Kkd;
    private boolean Kke;
    public boolean Kkf;
    private float Kkg;
    private p Kkh;
    private View Kki;
    private View Kkj;
    private ViewGroup Kkk;
    private EditText Kkl;
    private SoundWaveView Kkm;
    private ImageView Kkn;
    private ViewGroup Kko;
    private TextView Kkp;
    private WeImageView Kkq;
    public LanguageChoiceLayout Kkr;
    private TextView Kks;
    private ViewGroup Kkt;
    private TextView Kku;
    private ViewGroup Kkv;
    private ViewGroup Kkw;
    private View Kkx;
    private View Kky;
    private WeImageView Kkz;
    private final int KlA;
    private volatile boolean KlB;
    private MMHandler KlC;
    private boolean KlD;
    private int KlE;
    private boolean KlF;
    private int KlH;
    private View KlI;
    private int KlJ;
    private int KlK;
    private int KlL;
    private int KlM;
    private int KlN;
    private int KlO;
    private Runnable KlP;
    private Runnable KlQ;
    private int KlR;
    private int KlS;
    e KlT;
    e KlU;
    private Map<Integer, String> KlV;
    private boolean KlW;
    private int Kla;
    private TextWatcher Klb;
    ValueAnimator Klc;
    ValueAnimator Kld;
    ValueAnimator Kle;
    ValueAnimator Klf;
    ValueAnimator Klg;
    ValueAnimator.AnimatorUpdateListener Klh;
    private int[] Kli;
    private final int Klj;
    private final int Klk;
    private final int Kll;
    private final int Klm;
    private final int Kln;
    private final int Klo;
    private final float Klp;
    private int Klq;
    private int Klr;
    private int Kls;
    private int Klt;
    private int Klu;
    private int Klx;
    private boolean Kly;
    private final int Klz;
    private Activity activity;
    private String dRL;
    private boolean gYo;
    private com.tencent.mm.ui.tools.h gyh;
    public Button han;
    private ViewGroup jLy;
    private View jxm;
    public final MMHandler mHandler;
    private String mSessionId;
    private int maxHeight;
    private int oXi;
    private boolean qPk;
    private final MMHandler qPx;
    public ChatFooterPanel rum;
    public View teZ;
    private ImageView tfa;
    public View tfb;
    public View tfc;
    private String toUser;
    private boolean wxq;
    public boolean xfU;

    public interface b {
        String getTalkerUserName();

        com.tencent.mm.ui.chatting.i.b grp();

        com.tencent.mm.ui.chatting.e.a grq();
    }

    public interface c {
        void a(Boolean bool, Boolean bool2);

        void b(Boolean bool, Boolean bool2);
    }

    public interface d {
        void q(Boolean bool);
    }

    public interface f {
        void kE(int i2, int i3);
    }

    public interface g {
        boolean An(boolean z);
    }

    static /* synthetic */ boolean a(ChatFooter chatFooter, String str, boolean z) {
        AppMethodBeat.i(185832);
        boolean db = chatFooter.db(str, z);
        AppMethodBeat.o(185832);
        return db;
    }

    static /* synthetic */ void af(ChatFooter chatFooter) {
        AppMethodBeat.i(31710);
        chatFooter.gqX();
        AppMethodBeat.o(31710);
    }

    static /* synthetic */ void av(ChatFooter chatFooter) {
        AppMethodBeat.i(232313);
        chatFooter.aiw(R.drawable.oi);
        AppMethodBeat.o(232313);
    }

    static /* synthetic */ void aw(ChatFooter chatFooter) {
        AppMethodBeat.i(232314);
        chatFooter.Ai(true);
        AppMethodBeat.o(232314);
    }

    static /* synthetic */ void ay(ChatFooter chatFooter) {
        AppMethodBeat.i(232316);
        chatFooter.gpb();
        AppMethodBeat.o(232316);
    }

    static /* synthetic */ void b(ChatFooter chatFooter, boolean z) {
        AppMethodBeat.i(185827);
        chatFooter.qT(z);
        AppMethodBeat.o(185827);
    }

    static /* synthetic */ int ba(ChatFooter chatFooter) {
        int i2 = chatFooter.GvK;
        chatFooter.GvK = i2 + 1;
        return i2;
    }

    static /* synthetic */ void bc(ChatFooter chatFooter) {
        AppMethodBeat.i(232323);
        chatFooter.gqM();
        AppMethodBeat.o(232323);
    }

    static /* synthetic */ int bq(ChatFooter chatFooter) {
        int i2 = chatFooter.Kjh;
        chatFooter.Kjh = i2 + 1;
        return i2;
    }

    static /* synthetic */ void bs(ChatFooter chatFooter) {
        AppMethodBeat.i(232325);
        chatFooter.a(true, (Runnable) null);
        AppMethodBeat.o(232325);
    }

    static /* synthetic */ int gro() {
        int i2 = count + 1;
        count = i2;
        return i2;
    }

    static /* synthetic */ void h(ChatFooter chatFooter, int i2) {
        AppMethodBeat.i(232326);
        chatFooter.a(true, (Runnable) null, i2);
        AppMethodBeat.o(232326);
    }

    static /* synthetic */ void h(ChatFooter chatFooter, boolean z) {
        AppMethodBeat.i(232327);
        chatFooter.Al(z);
        AppMethodBeat.o(232327);
    }

    static /* synthetic */ void i(ChatFooter chatFooter, int i2) {
        AppMethodBeat.i(232328);
        chatFooter.aiC(i2);
        AppMethodBeat.o(232328);
    }

    static /* synthetic */ void j(ChatFooter chatFooter, boolean z) {
        AppMethodBeat.i(232330);
        chatFooter.Am(z);
        AppMethodBeat.o(232330);
    }

    static /* synthetic */ void p(ChatFooter chatFooter) {
        AppMethodBeat.i(185833);
        chatFooter.aW(false, true);
        AppMethodBeat.o(185833);
    }

    static /* synthetic */ boolean v(ChatFooter chatFooter) {
        AppMethodBeat.i(31701);
        boolean z = chatFooter.KiI;
        AppMethodBeat.o(31701);
        return z;
    }

    public static class a {
        public String Kml;
        String Kmm;
        int Kmn;
        HashMap<String, LinkedList<HashMap<String, String>>> Kmo;

        private a() {
            AppMethodBeat.i(31558);
            this.Kmo = new HashMap<>();
            AppMethodBeat.o(31558);
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    private void gqh() {
        AppMethodBeat.i(31572);
        if (this.Kjs != null) {
            com.tencent.mm.g.b.a.j jVar = this.Kjs;
            jVar.ekg = 0;
            jVar.eke = 0;
            jVar.ekf = 0;
            jVar.ekh = 0;
            jVar.bK(0).bL(0);
        }
        AppMethodBeat.o(31572);
    }

    public ChatFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x04fe  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x05bc  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x05d5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0667  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChatFooter(final android.content.Context r12, android.util.AttributeSet r13, int r14) {
        /*
        // Method dump skipped, instructions count: 1760
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.chat.ChatFooter.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public final void a(b bVar) {
        AppMethodBeat.i(31574);
        this.Kjy = bVar;
        this.KiC = new com.tencent.mm.plugin.groupsolitaire.ui.d(getContext(), this.Kjy.grp(), new d.AbstractC1429d() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass15 */

            @Override // com.tencent.mm.plugin.groupsolitaire.ui.d.AbstractC1429d
            public final void dYi() {
                AppMethodBeat.i(232229);
                ChatFooter.this.dYi();
                ChatFooter.this.gqj();
                AppMethodBeat.o(232229);
            }

            @Override // com.tencent.mm.plugin.groupsolitaire.ui.d.AbstractC1429d
            public final void aBt(String str) {
                AppMethodBeat.i(232230);
                if (ChatFooter.this.KiD != null && !Util.isNullOrNil(str)) {
                    ChatFooter.this.KiD.aBt(str);
                }
                AppMethodBeat.o(232230);
            }
        });
        this.KiC.ygR = this.Kjr;
        AppMethodBeat.o(31574);
    }

    public final void a(Context context, Activity activity2) {
        boolean z = true;
        AppMethodBeat.i(31575);
        Log.i("MicroMsg.ChatFooter", "onResume: %s, %s", Boolean.valueOf(KeyBoardUtil.isPortOrientation(context)), Integer.valueOf(getContext().getResources().getConfiguration().orientation));
        this.wxq = true;
        this.activity = activity2;
        if (this.Kjc == 48 && this.KiY == 1 && !this.Kjn) {
            this.xfU = false;
            j(0, false, -1);
        }
        if (getContext().getResources().getConfiguration().orientation != 1 && !KeyBoardUtil.isPortOrientation(context)) {
            z = false;
        }
        this.KiX = z;
        if (com.tencent.mm.compatible.util.d.oD(24)) {
            this.Kje = ((Activity) getContext()).isInMultiWindowMode();
        }
        gqN();
        gqS();
        if (ap.gni().JXr) {
            ap.gni().iu(MMApplicationContext.getContext());
        }
        if (!this.Kip.grr() && this.rum != null) {
            this.rum.onResume();
        }
        if (!this.Kjw && this.KiU) {
            gqH();
        } else if (this.Kjw && !this.KiU) {
            gqF();
        }
        aiC(getKeyBordHeightPX());
        if (this.Kik != null) {
            this.Kik.context = context;
        }
        this.KiA.Knj = false;
        if (!this.Kds) {
            gqG();
        }
        gql();
        post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass44 */

            public final void run() {
                AppMethodBeat.i(184931);
                com.tencent.mm.compatible.util.i.v(ChatFooter.this.activity);
                AppMethodBeat.o(184931);
            }
        });
        if (!(this.Kja == null || this.Kjy == null)) {
            this.Kja.a((ChattingScrollLayout.a) this.Kjy.grq().bh(r.class));
        }
        AppMethodBeat.o(31575);
    }

    public void setFooterType(int i2) {
        AppMethodBeat.i(31576);
        this.IFI = i2;
        if (this.rum != null) {
            this.rum.setFooterType(i2);
        }
        AppMethodBeat.o(31576);
    }

    public final void onPause() {
        AppMethodBeat.i(31577);
        Log.i("MicroMsg.ChatFooter", "onPause");
        this.wxq = false;
        if (this.Kjc == 48 && this.KiY == 1 && !this.Kjn) {
            this.xfU = false;
            j(0, true, -1);
        }
        this.gyh.close();
        if (this.rum != null) {
            this.rum.onPause();
        }
        if (this.Kds && this.Kdp != null) {
            this.Kdp.pause();
        }
        if (this.KiD != null) {
            this.KiD.onPause();
        }
        if (this.KiB != null) {
            this.KiB.hide();
        }
        if (this.FQS != null && this.FQS.isShowing()) {
            this.FQS.dismiss();
        }
        gqP();
        this.ECK.onPause();
        AppMethodBeat.o(31577);
    }

    public void setTipsShowCallback(c cVar) {
        this.Kjt = cVar;
    }

    public void setVoiceInputShowCallback(d dVar) {
        this.Kju = dVar;
    }

    public final void destroy() {
        AppMethodBeat.i(31578);
        if (this.rum != null) {
            Log.i("MicroMsg.ChatFooter", "jacks chat footer destroy smiley panel");
            this.rum.goC();
            this.rum.destroy();
            this.rum.animate().cancel();
            this.rum = null;
        }
        if (this.Kdp != null) {
            this.Kdp.destroy();
            this.Kdp = null;
            this.Kds = false;
        }
        if (this.KiD != null) {
            this.KiD.release();
        }
        if (this.KiB != null) {
            this.KiB.Kjv = null;
            this.KiB.Knu = null;
            this.KiB.hide();
        }
        if (this.FQS != null) {
            if (this.KjE != null) {
                this.KjE.getBlurController().destroy();
            }
            if (this.KjU != null) {
                this.KjU.getBlurController().destroy();
            }
        }
        Log.i("MicroMsg.ChatFooter", "jacks destroy chat footer.");
        this.ECK.destroy();
        AppMethodBeat.o(31578);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(31579);
        super.onAttachedToWindow();
        gqN();
        gqM();
        aiC(getKeyBordHeightPX());
        AppMethodBeat.o(31579);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(31580);
        super.onDetachedFromWindow();
        this.gyh.close();
        this.Kja = null;
        this.Kjb = false;
        AppMethodBeat.o(31580);
    }

    public final void gqi() {
        AppMethodBeat.i(232295);
        if (!Util.isNullOrNil(this.ECK.getText())) {
            this.ECK.setText("");
            if (this.rum != null) {
                this.rum.setToSendText("");
            }
        }
        Ah(false);
        gqh();
        AppMethodBeat.o(232295);
    }

    public final void gqj() {
        AppMethodBeat.i(31581);
        if (!Util.isNullOrNil(this.Kiy.getText())) {
            this.Kiy.setText("");
        }
        if (this.Kix.getTag() != null) {
            this.Kix.setTag(null);
        }
        this.Kix.setVisibility(8);
        AppMethodBeat.o(31581);
    }

    public final void l(final boolean z, long j2) {
        AppMethodBeat.i(31582);
        if (this.Kix.getTag() != null && (this.Kix.getTag() instanceof ca) && Util.isEqual(j2, ((ca) this.Kix.getTag()).field_msgId)) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass55 */

                public final void run() {
                    AppMethodBeat.i(185798);
                    if (!z) {
                        com.tencent.mm.ui.base.h.c(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(R.string.f47), "", true);
                    }
                    ChatFooter.this.gqj();
                    AppMethodBeat.o(185798);
                }
            });
        }
        AppMethodBeat.o(31582);
    }

    public final void gqk() {
        AppMethodBeat.i(31583);
        if (this.Kik == null) {
            AppMethodBeat.o(31583);
            return;
        }
        this.Kik.gpK();
        AppMethodBeat.o(31583);
    }

    private void qT(boolean z) {
        AppMethodBeat.i(31584);
        this.gYo = z;
        if (this.Kjz == null) {
            this.Kjz = AnimationUtils.loadAnimation(getContext(), R.anim.dd);
            this.Kjz.setDuration(150);
        }
        if (this.KjA == null) {
            this.KjA = AnimationUtils.loadAnimation(getContext(), R.anim.di);
            this.KjA.setDuration(150);
        }
        if (this.han == null || this.Kir == null) {
            Log.i("MicroMsg.ChatFooter", "canSend:%B, return sendBtn == null || mAttachButton == null", Boolean.valueOf(z));
            AppMethodBeat.o(31584);
        } else if (this.Kjw) {
            if (this.Kir.getVisibility() != 0) {
                this.Kir.setVisibility(0);
            }
            AppMethodBeat.o(31584);
        } else if (this.han.getVisibility() == 0 && z) {
            Log.i("MicroMsg.ChatFooter", "canSend true ! sendBtn is visible");
            AppMethodBeat.o(31584);
        } else if (this.Kir.getVisibility() != 0 || z) {
            if (z) {
                gqV();
                this.Kir.startAnimation(this.KjA);
                this.Kir.setVisibility(8);
                Am(false);
            } else {
                this.Kir.startAnimation(this.Kjz);
                if (!this.KiI && !this.KiW) {
                    this.Kir.setVisibility(0);
                    Am(true);
                }
                gqU();
            }
            Log.i("MicroMsg.ChatFooter", "jacks canSend:%B", Boolean.valueOf(z));
            this.han.getParent().requestLayout();
            AppMethodBeat.o(31584);
        } else {
            Log.i("MicroMsg.ChatFooter", "canSend false ! AttachButton is visible");
            AppMethodBeat.o(31584);
        }
    }

    public final void mC(String str, String str2) {
        this.dRL = str;
        this.toUser = str2;
    }

    public int getBarGroupHeight() {
        AppMethodBeat.i(31585);
        if (this.KiP == null) {
            this.KiP = findViewById(R.id.av3);
        }
        if (this.KiP != null) {
            int height = this.KiP.getHeight();
            AppMethodBeat.o(31585);
            return height;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cp);
        AppMethodBeat.o(31585);
        return dimensionPixelSize;
    }

    public final void go(View view) {
        int i2;
        int i3 = -1;
        AppMethodBeat.i(163212);
        if (this.KiD != null) {
            this.KiD.ehP();
        }
        Log.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", Integer.valueOf(this.Kik.getVisibility()), Boolean.valueOf(this.Kip.grr()));
        if (this.KiY != 3) {
            if (!(view == null || view.getTag() == null)) {
                i3 = ((Integer) view.getTag()).intValue();
            }
            i(3, true, i3);
            if (this.Kdp != null && this.Kdp.getVisibility() == 0 && this.Kds) {
                Log.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
                this.Kdp.setVisibility(8);
                this.Kds = false;
                this.Kdp.reset();
            }
            ap gni = ap.gni();
            Context context = MMApplicationContext.getContext();
            if (com.tencent.mm.kernel.g.aAc() && context != null) {
                try {
                    String value = com.tencent.mm.n.h.aqJ().getValue("ShowAPPSuggestion");
                    if (Util.isNullOrNil(value) || Integer.valueOf(value).intValue() != 1) {
                        Log.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", value);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", e2.getMessage());
                }
                if (gni.JXl) {
                    Log.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
                } else {
                    Log.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
                    gni.JXl = true;
                    if (System.currentTimeMillis() - gni.JXo < 43200000) {
                        Log.d("MicroMsg.SuggestionAppListLogic", "not now");
                        gni.JXl = false;
                    } else {
                        com.tencent.mm.kernel.g.aAi();
                        gni.JXo = com.tencent.mm.kernel.g.aAh().azQ().akg(352275);
                        if (System.currentTimeMillis() - gni.JXo < 43200000) {
                            Log.w("MicroMsg.SuggestionAppListLogic", "not now sp");
                            gni.JXl = false;
                        } else {
                            if (gni.lang == null) {
                                gni.lang = LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
                            }
                            af afVar = new af(gni.lang, new LinkedList());
                            com.tencent.mm.plugin.r.a.eAV();
                            com.tencent.mm.pluginsdk.model.app.e.a(4, afVar);
                        }
                    }
                }
            }
            ap.gni().iu(MMApplicationContext.getContext());
            if (com.tencent.mm.model.ab.Ix(this.toUser) && aa.ame()) {
                String str = this.toUser;
                if (com.tencent.mm.model.ab.JO(str)) {
                    i2 = 2;
                } else if (com.tencent.mm.model.ab.JN(str)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                com.tencent.mm.g.b.a.af afVar2 = new com.tencent.mm.g.b.a.af();
                afVar2.ik(str);
                afVar2.ejW = 1;
                afVar2.enM = (long) i2;
                afVar2.bfK();
            }
            AppMethodBeat.o(163212);
        } else if (this.KiR == 1) {
            showVKB();
            AppMethodBeat.o(163212);
        } else {
            i(0, true, -1);
            AppMethodBeat.o(163212);
        }
    }

    public final void gql() {
        AppMethodBeat.i(31587);
        this.Kit = (ImageButton) this.jxm.findViewById(R.id.ay9);
        this.Kit.setVisibility(0);
        if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, true)) {
            this.jxm.findViewById(R.id.ay_).setVisibility(0);
        } else {
            this.jxm.findViewById(R.id.ay_).setVisibility(8);
        }
        this.jxm.findViewById(R.id.ay_).setVisibility(8);
        this.Kit.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(232232);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.emoji.c.b bVar2 = com.tencent.mm.emoji.c.b.hcd;
                com.tencent.mm.emoji.c.b.avZ();
                if (ChatFooter.this.KiD != null) {
                    ChatFooter.this.KiD.ehO();
                }
                if (ChatFooter.this.KiY == 2) {
                    ChatFooter.this.showVKB();
                } else {
                    if (ChatFooter.v(ChatFooter.this)) {
                        ChatFooter.this.goD();
                    }
                    ChatFooter.this.gqo();
                    if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, false)) {
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, Boolean.TRUE);
                        ChatFooter.this.jxm.findViewById(R.id.ay_).setVisibility(8);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232232);
            }
        });
        if (this.KiB != null) {
            this.KiB.Knt = this.Kit;
        }
        if (this.KiC != null) {
            this.KiC.ygE = this.jxm;
        }
        AppMethodBeat.o(31587);
    }

    public class i implements TextWatcher {
        TextWatcher KmA;
        private boolean KmB = false;
        private boolean KmC = com.tencent.mm.compatible.util.d.oE(11);

        public i(TextWatcher textWatcher) {
            AppMethodBeat.i(31559);
            this.KmA = textWatcher;
            AppMethodBeat.o(31559);
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = true;
            AppMethodBeat.i(31560);
            if (!ChatFooter.this.KiU || !this.KmB || editable.length() <= 0) {
                this.KmA.afterTextChanged(editable);
                if (ChatFooter.this.Kil != null) {
                    if (ChatFooter.this.ECK.getLineCount() > 1) {
                        ChatFooter.this.Kil.setVisibility(0);
                        ChatFooter.this.Kil.setText(editable.length() + "/140");
                    } else {
                        ChatFooter.this.Kil.setVisibility(8);
                    }
                }
                if (editable.length() <= 0 || editable.toString().trim().length() <= 0) {
                    z = false;
                }
                ChatFooter.b(ChatFooter.this, z);
                if (ChatFooter.this.rum != null) {
                    ChatFooter.this.rum.setSendButtonEnable(z);
                }
                Log.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
                AppMethodBeat.o(31560);
                return;
            }
            this.KmB = false;
            ChatFooter.this.ECK.setText(editable.subSequence(0, editable.length() - 1));
            if (ChatFooter.this.ECK.length() > 0) {
                ChatFooter.this.han.performClick();
                Log.i("MicroMsg.ChatFooter", "enter button, do send");
            }
            Log.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
            AppMethodBeat.o(31560);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(31561);
            this.KmA.beforeTextChanged(charSequence, i2, i3, i4);
            Log.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
            AppMethodBeat.o(31561);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(31562);
            if (ChatFooter.this.KiU && i3 == 0 && i2 == charSequence.length() - 1 && i4 == 1 && charSequence.charAt(charSequence.length() - 1) == '\n') {
                Log.i("MicroMsg.ChatFooter", "text changed, enter button");
                this.KmB = true;
                AppMethodBeat.o(31562);
                return;
            }
            this.KmA.onTextChanged(charSequence, i2, i3, i4);
            ChatFooter.this.Kjs.ekf++;
            ChatFooter.this.Kjs.abY();
            if (ChatFooter.this.Kjs.ekc == 0) {
                ChatFooter.this.Kjs.abX();
            }
            if (ChatFooter.this.rum != null) {
                ChatFooter.this.rum.setToSendText(ChatFooter.this.ECK.getText().toString());
            }
            AppMethodBeat.o(31562);
        }
    }

    private void appendText(String str) {
        AppMethodBeat.i(232296);
        if (this.ECK == null) {
            AppMethodBeat.o(232296);
            return;
        }
        this.ECK.append(str);
        this.ECK.setSelection(this.ECK.getText().length());
        this.ECK.gYJ();
        AppMethodBeat.o(232296);
    }

    public final void Ah(boolean z) {
        AppMethodBeat.i(31588);
        Log.i("MicroMsg.ChatFooter", "pureForcusEdtChange: %s, %s", Boolean.valueOf(z), this.ECK);
        if (this.ECK == null) {
            AppMethodBeat.o(31588);
        } else if (z) {
            this.ECK.gYJ();
            AppMethodBeat.o(31588);
        } else {
            this.ECK.clearFocus();
            AppMethodBeat.o(31588);
        }
    }

    static {
        AppMethodBeat.i(31717);
        AppMethodBeat.o(31717);
    }

    /* access modifiers changed from: package-private */
    public enum l {
        MODE_HINT_INVALID,
        MODE_HINT_1,
        MODE_HINT_2;

        public static l valueOf(String str) {
            AppMethodBeat.i(31570);
            l lVar = (l) Enum.valueOf(l.class, str);
            AppMethodBeat.o(31570);
            return lVar;
        }

        static {
            AppMethodBeat.i(31571);
            AppMethodBeat.o(31571);
        }
    }

    /* access modifiers changed from: package-private */
    public enum j {
        MODE_INVALID,
        MODE_BLUR,
        MODE_NORMAL;

        public static j valueOf(String str) {
            AppMethodBeat.i(31564);
            j jVar = (j) Enum.valueOf(j.class, str);
            AppMethodBeat.o(31564);
            return jVar;
        }

        static {
            AppMethodBeat.i(31565);
            AppMethodBeat.o(31565);
        }
    }

    /* access modifiers changed from: package-private */
    public enum k {
        MODE_INVALID,
        MODE_TRANS,
        MODE_CANCEL;

        public static k valueOf(String str) {
            AppMethodBeat.i(31567);
            k kVar = (k) Enum.valueOf(k.class, str);
            AppMethodBeat.o(31567);
            return kVar;
        }

        static {
            AppMethodBeat.i(31568);
            AppMethodBeat.o(31568);
        }
    }

    public final void goD() {
        AppMethodBeat.i(31591);
        this.KiV = true;
        if (this.rum != null) {
            this.rum.goD();
        }
        AppMethodBeat.o(31591);
    }

    public void setFooterEventListener(b bVar) {
        this.KiD = bVar;
    }

    public void setSmileyPanelCallback(f fVar) {
        AppMethodBeat.i(31592);
        this.KbA = fVar;
        if (this.rum != null) {
            this.rum.setCallback(fVar);
        }
        AppMethodBeat.o(31592);
    }

    public f getCallback() {
        return this.KbA;
    }

    public void setSmileyPanelCallback2(j jVar) {
        this.KiB.Knu = jVar;
    }

    private void aiw(int i2) {
        boolean z;
        AppMethodBeat.i(31593);
        if (this.Kin == null) {
            AppMethodBeat.o(31593);
            return;
        }
        if (i2 == R.drawable.oi) {
            z = true;
        } else {
            z = false;
        }
        if (this.Kin != null) {
            if (z) {
                this.Kin.setContentDescription(getContext().getString(R.string.aui));
            } else {
                this.Kin.setContentDescription(getContext().getString(R.string.auh));
            }
        }
        this.Kin.setImageResource(i2);
        this.Kin.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(31593);
    }

    private void gqn() {
        AppMethodBeat.i(31594);
        String talkerUserName = this.Kjy == null ? this.Kij : this.Kjy.getTalkerUserName();
        this.Kik = (AppPanel) findViewById(R.id.arx);
        this.Kik.setOnSwitchPanelListener(this.KkV);
        this.Kik.setChattingContext(this.KkW);
        this.Kik.setPortHeighPx(KeyBoardUtil.getValidPanelHeight(getContext()));
        if (com.tencent.mm.model.ab.JE(talkerUserName) || com.tencent.mm.model.ab.Jv(talkerUserName)) {
            this.Kik.init(0);
        } else if (com.tencent.mm.model.ab.IT(talkerUserName)) {
            this.Kik.init(4);
        } else if (com.tencent.mm.model.ab.Eq(talkerUserName)) {
            this.Kik.init(2);
        } else {
            this.Kik.init(1);
        }
        this.Kiq = (TextView) findViewById(R.id.ary);
        AppMethodBeat.o(31594);
    }

    public void setAppPanelTip(CharSequence charSequence) {
        AppMethodBeat.i(31595);
        if (this.Kiq == null || this.Kik == null) {
            AppMethodBeat.o(31595);
            return;
        }
        this.Kiq.setText(charSequence);
        if (!Util.isNullOrNil(charSequence)) {
            setAppPanelTipVisible(this.Kik.getVisibility() == 0);
        }
        AppMethodBeat.o(31595);
    }

    public void setAppPanelTipVisible(boolean z) {
        int i2;
        AppMethodBeat.i(31596);
        if (this.Kiq == null) {
            AppMethodBeat.o(31596);
        } else if (TextUtils.isEmpty(this.Kiq.getText())) {
            this.Kiq.setVisibility(8);
            AppMethodBeat.o(31596);
        } else {
            if (z) {
                int height = (this.Kip.getHeight() - getKeyBordHeightPX()) + com.tencent.mm.cb.a.fromDPToPix(this.Kiq.getContext(), 32);
                ViewGroup.LayoutParams layoutParams = this.Kiq.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.bottomMargin = height;
                    this.Kiq.setLayoutParams(marginLayoutParams);
                }
            }
            TextView textView = this.Kiq;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            AppMethodBeat.o(31596);
        }
    }

    public final void gqo() {
        AppMethodBeat.i(31597);
        this.KiR = 1;
        Ai(true);
        qT(this.ECK.length() > 0);
        this.Kim.setVisibility(8);
        aiw(R.drawable.oi);
        if (this.Kdp != null) {
            this.Kdp.setVisibility(8);
            this.Kds = false;
            this.Kdp.reset();
        }
        i(2, true, -1);
        AppMethodBeat.o(31597);
    }

    private void Ai(boolean z) {
        AppMethodBeat.i(31598);
        if (z) {
            this.Kiw.setVisibility(0);
            this.Kiu.setVisibility(0);
            aW(true, false);
            AppMethodBeat.o(31598);
            return;
        }
        this.Kiw.setVisibility(8);
        this.Kiu.setVisibility(8);
        aW(false, false);
        AppMethodBeat.o(31598);
    }

    private void aW(boolean z, boolean z2) {
        AppMethodBeat.i(31599);
        if (!z) {
            if (z2) {
                this.Kix.setTag(null);
                this.Kiy.setText("");
            }
            this.Kix.setVisibility(8);
            AppMethodBeat.o(31599);
        } else if (this.Kix.getTag() == null || !(this.Kix.getTag() instanceof ca)) {
            this.Kix.setVisibility(8);
            AppMethodBeat.o(31599);
        } else {
            this.Kix.setVisibility(0);
            this.Kiy.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), com.tencent.mm.plugin.msgquote.model.a.a(getContext(), this.Kiy.getTextSize(), (ca) this.Kix.getTag())));
            AppMethodBeat.o(31599);
        }
    }

    public ab.a getIOnToDoBarCallback() {
        return this.Kjq;
    }

    public void setIOnTodoViewCallback(ab.c cVar) {
        this.Kjp = cVar;
    }

    public void setDefaultSmileyByDetail(String str) {
        AppMethodBeat.i(31600);
        if (!Util.isNullOrNil(str)) {
            if (this.rum == null) {
                gqm();
            }
            this.rum.setDefaultEmojiByDetail(str);
        }
        AppMethodBeat.o(31600);
    }

    public final void gpb() {
        AppMethodBeat.i(31601);
        if (!this.Kds) {
            AppMethodBeat.o(31601);
            return;
        }
        this.Kds = false;
        if (this.Kdp != null) {
            int keyBordHeightPX = getKeyBordHeightPX() + this.Kio.getHeight();
            this.Kdp.animate().cancel();
            this.Kdp.animate().translationY((float) keyBordHeightPX).withEndAction(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass28 */

                public final void run() {
                    AppMethodBeat.i(31529);
                    if (ChatFooter.this.Kdp != null) {
                        ChatFooter.this.Kdp.destroy();
                        ChatFooter.this.Kdp.setVisibility(8);
                    }
                    AppMethodBeat.o(31529);
                }
            }).start();
        }
        this.ECK.setText("");
        AppMethodBeat.o(31601);
    }

    public void setAtSomebody(String str) {
        this.KiG.Kmm = str;
    }

    public void setLastContent(String str) {
        this.KiG.Kml = str;
    }

    public final void bj(String str, String str2, String str3) {
        LinkedList<HashMap<String, String>> linkedList;
        AppMethodBeat.i(31602);
        if (this.KiG.Kmo.containsKey(str)) {
            linkedList = this.KiG.Kmo.get(str);
        } else {
            linkedList = new LinkedList<>();
            this.KiG.Kmo.put(str, linkedList);
        }
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put(str3, str2);
        linkedList.add(hashMap);
        AppMethodBeat.o(31602);
    }

    public void setInsertPos(int i2) {
        this.KiG.Kmn = i2;
    }

    public String getAtSomebody() {
        return this.KiG.Kmm;
    }

    public final HashMap<String, String> mD(String str, String str2) {
        int indexOf;
        int indexOf2;
        AppMethodBeat.i(31603);
        long currentTimeMillis = System.currentTimeMillis();
        if (Util.isNullOrNil(str2)) {
            if (this.KiG.Kmo.containsKey(str)) {
                this.KiG.Kmo.remove(str);
            }
            AppMethodBeat.o(31603);
            return null;
        } else if (!this.KiG.Kmo.containsKey(str) || this.KiG.Kmo.get(str).size() <= 0) {
            AppMethodBeat.o(31603);
            return null;
        } else {
            LinkedList<String> linkedList = new LinkedList();
            int i2 = 0;
            while (i2 < str2.length() && (indexOf = str2.indexOf("@", i2)) != -1 && (indexOf2 = str2.indexOf(8197, indexOf)) != -1 && indexOf2 - indexOf <= 40) {
                linkedList.add(str2.substring(indexOf + 1, indexOf2));
                i2 = indexOf2 + 1;
            }
            Log.i("MicroMsg.ChatFooter", "after split @ :%s", linkedList);
            if (linkedList.size() <= 0) {
                this.KiG.Kmo.get(str).clear();
                AppMethodBeat.o(31603);
                return null;
            }
            LinkedList<HashMap<String, String>> linkedList2 = this.KiG.Kmo.get(str);
            if (linkedList2 == null || linkedList2.size() <= 0) {
                Log.w("MicroMsg.ChatFooter", "list is null or size 0");
                AppMethodBeat.o(31603);
                return null;
            }
            Log.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", Integer.valueOf(linkedList2.size()));
            LinkedList linkedList3 = new LinkedList();
            for (String str3 : linkedList) {
                Iterator<HashMap<String, String>> it = linkedList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HashMap<String, String> next = it.next();
                    if (next.containsKey(str3)) {
                        linkedList3.add(next.get(str3));
                        break;
                    }
                }
            }
            HashMap<String, String> hashMap = new HashMap<>(1);
            Log.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", Integer.valueOf(linkedList3.size()));
            hashMap.put("atuserlist", "<![CDATA[" + Util.listToString(linkedList3, ",") + "]]>");
            linkedList2.clear();
            Log.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(31603);
            return hashMap;
        }
    }

    public final int gK(String str, int i2) {
        AppMethodBeat.i(163213);
        if (this.KiG.Kmo.containsKey(str) && this.KiG.Kmo.get(str).size() > 0) {
            i2 |= 1;
        }
        if (this.KiJ) {
            i2 |= this.KiK ? 4 : 8;
        }
        AppMethodBeat.o(163213);
        return i2;
    }

    public String getLastContent() {
        return this.KiG.Kml;
    }

    public int getInsertPos() {
        return this.KiG.Kmn;
    }

    public void setLastQuoteMsgId(long j2) {
        AppMethodBeat.i(31605);
        if (j2 != 0) {
            ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(j2);
            if ((Hb.fqJ & 4) == 4 || Hb.getType() == 10000) {
                Log.e("MicroMsg.ChatFooter", "msg(%s) is revoked!", Hb.getType() + "," + (Hb.fqJ & 4));
                com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(R.string.f47), "", true);
                AppMethodBeat.o(31605);
                return;
            }
            this.Kix.setTag(Hb);
            AppMethodBeat.o(31605);
            return;
        }
        this.Kix.setTag(null);
        AppMethodBeat.o(31605);
    }

    public final void z(String str, int i2, boolean z) {
        AppMethodBeat.i(31607);
        if (dYe()) {
            Log.i("MicroMsg.ChatFooter", "setLastText() isBackFromGroupSolitatire");
            AppMethodBeat.o(31607);
        } else if (!z || !(str == null || str.length() == 0 || this.ECK == null)) {
            this.KiH = true;
            this.ECK.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), str, this.ECK.getTextSize()));
            this.KiH = false;
            if (i2 < 0 || i2 > this.ECK.getText().length()) {
                this.ECK.setSelection(this.ECK.getText().length());
                AppMethodBeat.o(31607);
                return;
            }
            this.ECK.setSelection(i2);
            AppMethodBeat.o(31607);
        } else {
            this.ECK.setText("");
            gqh();
            AppMethodBeat.o(31607);
        }
    }

    private boolean dYe() {
        AppMethodBeat.i(31608);
        if (this.KiC != null) {
            boolean dYe = this.KiC.dYe();
            AppMethodBeat.o(31608);
            return dYe;
        }
        AppMethodBeat.o(31608);
        return false;
    }

    public void setHint(CharSequence charSequence) {
        AppMethodBeat.i(232297);
        if (this.ECK != null) {
            this.ECK.setHint(charSequence);
        }
        AppMethodBeat.o(232297);
    }

    public final void cDd() {
        AppMethodBeat.i(31610);
        this.KjZ.setExitType(1);
        this.Kim.setEnabled(false);
        this.Kim.setBackgroundResource(R.drawable.aqq);
        if (this.Kkf) {
            this.Kkh.update();
            this.qPx.sendEmptyMessageDelayed(0, 500);
            AppMethodBeat.o(31610);
            return;
        }
        if (this.FQS != null) {
            this.teZ.setVisibility(0);
            this.KiN.setVisibility(8);
            this.FQV.setVisibility(8);
            this.FQS.update();
            this.KjY.dismiss();
        }
        this.qPx.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.o(31610);
    }

    public String getLastText() {
        AppMethodBeat.i(31611);
        if (this.ECK == null) {
            AppMethodBeat.o(31611);
            return "";
        }
        String obj = this.ECK.getText().toString();
        AppMethodBeat.o(31611);
        return obj;
    }

    public long getLastQuoteMsgId() {
        AppMethodBeat.i(31612);
        if (this.Kix.getTag() == null || !(this.Kix.getTag() instanceof ca)) {
            AppMethodBeat.o(31612);
            return 0;
        }
        long j2 = ((ca) this.Kix.getTag()).field_msgId;
        AppMethodBeat.o(31612);
        return j2;
    }

    public int getSelectionStart() {
        AppMethodBeat.i(31613);
        int selectionStart = this.ECK.getSelectionStart();
        AppMethodBeat.o(31613);
        return selectionStart;
    }

    public char getCharAtCursor() {
        AppMethodBeat.i(31614);
        int selectionStart = getSelectionStart();
        if (selectionStart <= 0) {
            AppMethodBeat.o(31614);
            return 'x';
        }
        char charAt = getLastText().charAt(selectionStart - 1);
        AppMethodBeat.o(31614);
        return charAt;
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(31615);
        this.KkX = new i(textWatcher);
        this.ECK.addTextChangedListener(this.KkX);
        AppMethodBeat.o(31615);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void aix(int i2) {
        int fromDPToPix;
        AppMethodBeat.i(31616);
        if (this.Kkf) {
            if (this.Kkh == null) {
                this.Kkh = new p(View.inflate(getContext(), R.layout.bg1, null), -1, -1, true);
                this.Kkh.setSoftInputMode(16);
                this.Kkh.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass31 */

                    public final void onDismiss() {
                        AppMethodBeat.i(179765);
                        if (ChatFooter.this.KlT == e.MODE_TRANS && ChatFooter.this.KkT) {
                            Log.i("MicroMsg.ChatFooter", "dismiss from keyback, need cancelRecording");
                            ChatFooter.this.KjZ.setExitType(6);
                            ChatFooter.this.KiD.ehM();
                        }
                        ChatFooter.aK(ChatFooter.this);
                        ChatFooter.e(ChatFooter.this, 0);
                        AppMethodBeat.o(179765);
                    }
                });
                this.Kki = this.Kkh.getContentView().findViewById(R.id.fxz);
                this.Kkj = this.Kkh.getContentView().findViewById(R.id.fyk);
                this.Kkk = (ViewGroup) this.Kkh.getContentView().findViewById(R.id.fxv);
                this.Kkm = (SoundWaveView) this.Kkh.getContentView().findViewById(R.id.fy1);
                this.Kkl = (EditText) this.Kkh.getContentView().findViewById(R.id.fxt);
                this.Kkn = (ImageView) this.Kkh.getContentView().findViewById(R.id.fxs);
                this.Kko = (ViewGroup) this.Kkh.getContentView().findViewById(R.id.fy0);
                this.Kkp = (TextView) this.Kkh.getContentView().findViewById(R.id.fxr);
                this.Kkq = (WeImageView) this.Kkh.getContentView().findViewById(R.id.fxw);
                this.Kkr = (LanguageChoiceLayout) this.Kkh.getContentView().findViewById(R.id.fyc);
                this.Kks = (TextView) this.Kkh.getContentView().findViewById(R.id.fxx);
                this.Kkt = (ViewGroup) this.Kkh.getContentView().findViewById(R.id.fy2);
                this.Kku = (TextView) this.Kkh.getContentView().findViewById(R.id.fxu);
                this.Kkr.setSelectLanguageListener(new LanguageChoiceLayout.a() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass32 */

                    @Override // com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.a
                    public final void acq(int i2) {
                        AppMethodBeat.i(232252);
                        ChatFooter.this.GtE = i2;
                        if (Util.isNullOrNil((String) ChatFooter.this.KlV.get(Integer.valueOf(ChatFooter.this.GtE)))) {
                            long nanoTime = System.nanoTime() | Util.MAX_32BIT_VALUE;
                            if (nanoTime < 0) {
                                nanoTime = Math.abs(nanoTime);
                            }
                            com.tencent.mm.modelvoiceaddr.h hVar = new com.tencent.mm.modelvoiceaddr.h(String.valueOf(nanoTime));
                            ChatFooter.this.KjX.a(hVar);
                            ChatFooter.this.getContext().getSharedPreferences("voice2txt_sp", 0).edit().putInt(ChatFooter.this.Kij, ChatFooter.this.GtE).apply();
                            ChatFooter.this.a(ChatFooter.this.GtE, false, hVar, true);
                        } else {
                            ChatFooter.aN(ChatFooter.this);
                        }
                        ChatFooter.this.KjZ.GtQ = System.currentTimeMillis();
                        ChatFooter.this.KjZ.GtT = 0;
                        ChatFooter.this.KjZ.GtU = 0;
                        ChatFooter.this.KjZ.GtV = 0;
                        ChatFooter.this.KjZ.GtY = 0;
                        ChatFooter.this.KjZ.GtZ = 0;
                        ChatFooter.this.KjZ.Gua = 0;
                        AppMethodBeat.o(232252);
                    }
                });
                this.Kkq.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass34 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(185353);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (ChatFooter.this.xfU) {
                            ChatFooter.this.KiQ.hideSoftInputFromWindow(ChatFooter.this.Kkl.getWindowToken(), 0);
                        }
                        LanguageChoiceLayout languageChoiceLayout = ChatFooter.this.Kkr;
                        int i2 = ChatFooter.this.GtE;
                        languageChoiceLayout.setVisibility(0);
                        languageChoiceLayout.hSz.post(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: INVOKE  
                              (wrap: android.view.ViewGroup : 0x004d: IGET  (r2v1 android.view.ViewGroup) = (r0v4 'languageChoiceLayout' com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout) com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.hSz android.view.ViewGroup)
                              (wrap: com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout$4 : 0x0051: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout$4) = (r0v4 'languageChoiceLayout' com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout), (r1v2 'i2' int) call: com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.4.<init>(com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout, int):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.view.ViewGroup.post(java.lang.Runnable):boolean in method: com.tencent.mm.pluginsdk.ui.chat.ChatFooter.34.onClick(android.view.View):void, file: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0051: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout$4) = (r0v4 'languageChoiceLayout' com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout), (r1v2 'i2' int) call: com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.4.<init>(com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout, int):void type: CONSTRUCTOR in method: com.tencent.mm.pluginsdk.ui.chat.ChatFooter.34.onClick(android.view.View):void, file: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 14 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 20 more
                            */
                        /*
                        // Method dump skipped, instructions count: 106
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass34.onClick(android.view.View):void");
                    }
                });
                this.Kkl.setMaxLines(Integer.MAX_VALUE);
                this.Kkl.setHorizontallyScrolling(false);
                this.Kkl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass35 */

                    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                        AppMethodBeat.i(232253);
                        if (4 == i2 || 66 == keyEvent.getAction()) {
                            String obj = ChatFooter.this.Kkl.getText().toString();
                            if (ChatFooter.this.KiD != null) {
                                if (!Util.isNullOrNil(obj)) {
                                    ChatFooter.this.KiD.aDN(obj);
                                }
                                ChatFooter.this.KiD.ehM();
                            }
                            AppMethodBeat.o(232253);
                            return true;
                        }
                        AppMethodBeat.o(232253);
                        return false;
                    }
                });
                post(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass36 */

                    public final void run() {
                        AppMethodBeat.i(31531);
                        ChatFooter.aR(ChatFooter.this);
                        AppMethodBeat.o(31531);
                    }
                });
                this.Kkl.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass37 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(232254);
                        if (ChatFooter.this.GvM) {
                            ChatFooter.this.GvM = false;
                            if (ChatFooter.this.GvE != null) {
                                ChatFooter.this.GvE.az(false, true);
                            }
                            ChatFooter.this.GvL.stopTimer();
                            ChatFooter.this.Kkl.setText((CharSequence) ChatFooter.this.KlV.get(Integer.valueOf(ChatFooter.this.GtE)));
                            ChatFooter.this.KjZ.GtY = 0;
                            ChatFooter.this.KjZ.GtU = System.currentTimeMillis();
                            ChatFooter.this.KlW = false;
                        }
                        ChatFooter.this.KjZ.Gua = 1;
                        AppMethodBeat.o(232254);
                        return false;
                    }
                });
                this.Kkv = (ViewGroup) this.Kkh.getContentView().findViewById(R.id.fxy);
                this.Kkw = (ViewGroup) this.Kkh.getContentView().findViewById(R.id.fyn);
                this.Kkx = this.Kkh.getContentView().findViewById(R.id.fxo);
                this.Kky = this.Kkh.getContentView().findViewById(R.id.fyl);
                this.Kkz = (WeImageView) this.Kkh.getContentView().findViewById(R.id.fxp);
                this.KkA = (WeImageView) this.Kkh.getContentView().findViewById(R.id.fym);
                this.KkB = this.Kkh.getContentView().findViewById(R.id.fxq);
                this.KkC = this.Kkh.getContentView().findViewById(R.id.fyp);
                this.KkD = (ViewGroup) this.Kkh.getContentView().findViewById(R.id.fyo);
                this.KkE = this.Kkh.getContentView().findViewById(R.id.fy4);
                this.KkE.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass38 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(232255);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        ChatFooter.this.KkT = false;
                        ChatFooter.this.KjZ.setExitType(6);
                        ChatFooter.this.KiD.ehM();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(232255);
                    }
                });
                this.KkF = this.Kkh.getContentView().findViewById(R.id.fyi);
                this.KkF.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass39 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(232256);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (ChatFooter.this.KiD != null) {
                            ChatFooter.this.KkT = false;
                            ChatFooter.this.KjZ.setExitType(7);
                            ChatFooter.this.KiD.eu(ChatFooter.this.KiD.getFileName(), ChatFooter.this.KlE);
                            ChatFooter.K(ChatFooter.this);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(232256);
                    }
                });
                this.KkI = this.Kkh.getContentView().findViewById(R.id.fyf);
                this.KkI.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass40 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(232257);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (ChatFooter.this.KkK.getVisibility() == 0 && 8 == ChatFooter.this.KkJ.getVisibility()) {
                            String obj = ChatFooter.this.Kkl.getText().toString();
                            if (ChatFooter.this.KiD != null && !Util.isNullOrNil(obj)) {
                                ChatFooter.this.KkT = false;
                                ChatFooter.this.KjZ.GtS = ChatFooter.this.GtE;
                                ChatFooter.this.KjZ.GtW = obj.length();
                                if (1 == ChatFooter.this.KjZ.GtZ) {
                                    ChatFooter.this.KjZ.setExitType(8);
                                } else {
                                    ChatFooter.this.KjZ.setExitType(5);
                                }
                                ChatFooter.this.KiD.aDN(obj);
                                ChatFooter.this.KiD.ehM();
                                ChatFooter.d(ChatFooter.this, obj);
                            }
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(232257);
                    }
                });
                this.KkG = (WeImageView) this.Kkh.getContentView().findViewById(R.id.fy5);
                this.KkH = (WeImageView) this.Kkh.getContentView().findViewById(R.id.fyj);
                this.KkJ = this.Kkh.getContentView().findViewById(R.id.fyh);
                this.KkK = (WeImageView) this.Kkh.getContentView().findViewById(R.id.fyg);
                this.KkL = (ViewGroup) this.Kkh.getContentView().findViewById(R.id.fyq);
                this.KkM = this.Kkh.getContentView().findViewById(R.id.fys);
                this.KkN = this.Kkh.getContentView().findViewById(R.id.fyu);
                this.KkO = this.Kkh.getContentView().findViewById(R.id.fyt);
                this.KkP = (WeImageView) this.Kkh.getContentView().findViewById(R.id.fyr);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.KkL.getLayoutParams();
                layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.ao5) + av.aD(getContext());
                this.KkL.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.KkP.getLayoutParams();
                layoutParams2.bottomMargin = av.aD(getContext()) + at.fromDPToPix(getContext(), 14);
                this.KkP.setLayoutParams(layoutParams2);
                this.GvL = new MTimerHandler(new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass41 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(232258);
                        int i2 = ChatFooter.this.GvK % 3;
                        ChatFooter.ba(ChatFooter.this);
                        switch (i2) {
                            case 0:
                                ChatFooter.this.GvJ = "·";
                                break;
                            case 1:
                                ChatFooter.this.GvJ = "··";
                                break;
                            case 2:
                                ChatFooter.this.GvJ = "···";
                                break;
                        }
                        ChatFooter.bb(ChatFooter.this);
                        AppMethodBeat.o(232258);
                        return true;
                    }
                }, true);
                this.GvO = new MMHandler(new MMHandler.Callback() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass42 */

                    public final boolean handleMessage(Message message) {
                        AppMethodBeat.i(232259);
                        switch (message.what) {
                            case 5000:
                                ChatFooter.this.KjZ.GtT = 1;
                                ChatFooter.this.KjZ.GtU = System.currentTimeMillis();
                                ChatFooter.this.KjZ.GtY = 0;
                                ChatFooter.this.GvL.stopTimer();
                                if (ChatFooter.this.GvE != null) {
                                    ChatFooter.this.GvE.az(false, false);
                                }
                                if (!Util.isNullOrNil((String) ChatFooter.this.KlV.get(Integer.valueOf(ChatFooter.this.GtE)))) {
                                    ChatFooter.this.Kkl.setFocusable(true);
                                    ChatFooter.this.Kkl.setFocusableInTouchMode(true);
                                    ChatFooter.this.Kkl.requestFocus();
                                }
                                ChatFooter.aN(ChatFooter.this);
                                ChatFooter.this.KlW = false;
                                break;
                        }
                        AppMethodBeat.o(232259);
                        return true;
                    }
                });
                this.KkQ = this.Kkh.getContentView().findViewById(R.id.fy3);
                this.Kkh.setClippingEnabled(false);
            }
            int transLangTypeByTalker = getTransLangTypeByTalker();
            if (com.tencent.mm.modelvoiceaddr.g.jwp == transLangTypeByTalker) {
                this.GtE = com.tencent.mm.modelvoiceaddr.g.jwq;
            } else {
                this.GtE = transLangTypeByTalker;
            }
            if (this.Kkr != null) {
                this.Kkr.setSelectedLang(this.GtE);
            }
            Log.d("MicroMsg.ChatFooter", "curTxt:%s", Integer.valueOf(this.KlV.size()));
            if (com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_NEW_VOICE2TXT_NEED_GUIDE_VOICE_BOOLEAN_SYNC, true) || !com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_NEW_VOICE2TXT_NEED_GUIDE_OPERATION_BOOLEAN_SYNC, true)) {
                this.Kku.setTranslationY((float) at.fromDPToPix(getContext(), 30));
                this.Kku.setVisibility(0);
                this.Kku.setAlpha(0.0f);
                this.Kku.setText(getContext().getResources().getString(R.string.fck));
                this.Kku.animate().alpha(1.0f).translationY(0.0f).setDuration(200).setStartDelay(0).start();
            } else {
                this.Kku.setTranslationY((float) at.fromDPToPix(getContext(), 12));
                this.Kku.setVisibility(0);
                this.Kku.setAlpha(0.0f);
                this.Kku.setText(getContext().getResources().getString(R.string.fcg));
                this.Kku.animate().alpha(1.0f).translationY(0.0f).setDuration(1000).setStartDelay(500).start();
            }
            this.Kkk.setTranslationY(0.0f);
            this.Kkn.setTranslationY(0.0f);
            this.Kkq.setTranslationY(0.0f);
            this.Kkv.setTranslationY(0.0f);
            int fromDPToPix2 = at.fromDPToPix(getContext(), 20);
            this.Kkl.setPadding(fromDPToPix2, fromDPToPix2, fromDPToPix2, 0);
            this.Kkl.addTextChangedListener(this.Klb);
            this.Kkl.setVisibility(8);
            this.Kkl.setCursorVisible(false);
            this.Kkm.setVisibility(0);
            this.Kks.setVisibility(8);
            this.KkI.setEnabled(true);
            this.Kkk.setActivated(true);
            this.KkK.setImageDrawable(com.tencent.mm.ui.ar.m(getContext(), R.raw.icons_filled_done, getContext().getResources().getColor(R.color.Brand)));
            this.Kkn.setImageDrawable(com.tencent.mm.ui.ar.m(getContext(), R.raw.icons_filled_voice2txt_cursor, getContext().getResources().getColor(R.color.LightGreen)));
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.KkM.getLayoutParams();
            layoutParams3.width = at.fromDPToPix(getContext(), 250);
            layoutParams3.height = at.fromDPToPix(getContext(), 40);
            layoutParams3.topMargin = at.fromDPToPix(getContext(), 72);
            layoutParams3.rightMargin = at.fromDPToPix(getContext(), 22);
            layoutParams3.bottomMargin = at.fromDPToPix(getContext(), 8);
            this.KkM.setLayoutParams(layoutParams3);
            this.KkM.setAlpha(0.0f);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.KkN.getLayoutParams();
            layoutParams4.width = at.fromDPToPix(getContext(), 250);
            layoutParams4.height = at.fromDPToPix(getContext(), 40);
            layoutParams4.topMargin = at.fromDPToPix(getContext(), 72);
            layoutParams4.rightMargin = at.fromDPToPix(getContext(), 22);
            layoutParams4.bottomMargin = at.fromDPToPix(getContext(), 8);
            this.KkN.setLayoutParams(layoutParams4);
            this.KkN.setAlpha(0.0f);
            this.Kkw.setTranslationY((float) this.KlS);
            this.Kkw.setAlpha(0.0f);
            this.Kkm.setVisibility(8);
            this.KkQ.setVisibility(0);
            if (ao.isDarkMode()) {
                this.Kkj.setBackground(getContext().getResources().getDrawable(R.drawable.ci8));
            } else {
                this.Kkj.setBackground(getContext().getResources().getDrawable(R.drawable.ci9));
            }
            this.KlF = false;
            this.Kkh.showAtLocation(this, 49, 0, 0);
            gqp();
            this.Kkq.setVisibility(8);
            post(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass43 */

                /* JADX WARNING: Code restructure failed: missing block: B:13:0x00b1, code lost:
                    if ((r4.getHeight() + r5[1]) > (com.tencent.mm.ui.au.az(r2.getContext()).y - r3)) goto L_0x00b3;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 241
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass43.run():void");
                }
            });
            AppMethodBeat.o(31616);
            return;
        }
        this.KkY = 0;
        if (this.KiS) {
            fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 280);
        } else {
            fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), (int) TXLiveConstants.RENDER_ROTATION_180);
        }
        int fromDPToPix3 = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 50.0f);
        if (i2 + fromDPToPix3 < fromDPToPix) {
            this.KkY = -1;
        } else {
            this.KkY = ((i2 - fromDPToPix) / 2) + fromDPToPix3;
        }
        if (this.FQS == null) {
            this.FQS = new p(View.inflate(getContext(), R.layout.c6s, null), -1, -2);
            this.KiN = (ViewGroup) this.FQS.getContentView().findViewById(R.id.j_u);
            this.tfb = this.FQS.getContentView().findViewById(R.id.j_o);
            this.tfa = (ImageView) this.FQS.getContentView().findViewById(R.id.jcp);
            this.KiO = (TextView) this.FQS.getContentView().findViewById(R.id.j_x);
            this.KiO.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ah8)) * com.tencent.mm.cb.a.ji(getContext()));
            this.tfc = this.FQS.getContentView().findViewById(R.id.j_q);
            this.FQT = (TextView) this.FQS.getContentView().findViewById(R.id.j_s);
            this.FQT.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ah8)) * com.tencent.mm.cb.a.ji(getContext()));
            this.FQU = (ImageView) this.FQS.getContentView().findViewById(R.id.j_r);
            this.FQV = this.FQS.getContentView().findViewById(R.id.j_t);
            this.teZ = this.FQS.getContentView().findViewById(R.id.j_v);
            this.KjC = (ViewGroup) this.FQS.getContentView().findViewById(R.id.j9f);
            this.KjD = this.FQS.getContentView().findViewById(R.id.j99);
            this.KjG = this.FQS.getContentView().findViewById(R.id.j9j);
            this.KjH = (ImageView) this.FQS.getContentView().findViewById(R.id.j9k);
            this.KjI = (ImageView) this.FQS.getContentView().findViewById(R.id.j98);
            this.KjJ = this.FQS.getContentView().findViewById(R.id.j9_);
            this.KjK = (TextView) this.FQS.getContentView().findViewById(R.id.j9c);
            this.KjL = (ImageView) this.FQS.getContentView().findViewById(R.id.j9a);
            this.KjM = this.FQS.getContentView().findViewById(R.id.j9e);
            this.KjN = this.FQS.getContentView().findViewById(R.id.j95);
            this.KjO = (WeImageView) this.FQS.getContentView().findViewById(R.id.j96);
            this.KjP = (TextView) this.FQS.getContentView().findViewById(R.id.j97);
            this.KjQ = this.FQS.getContentView().findViewById(R.id.j9g);
            this.KjR = (WeImageView) this.FQS.getContentView().findViewById(R.id.j9h);
            this.KjS = (TextView) this.FQS.getContentView().findViewById(R.id.j9i);
            this.KjT = View.inflate(getContext(), R.layout.ato, null);
            try {
                if (j.MODE_BLUR == this.Kkb) {
                    View decorView = this.activity.getWindow().getDecorView();
                    Drawable background = decorView.getBackground();
                    this.KjE = new BlurView(getContext());
                    int fromDPToPix4 = com.tencent.mm.cb.a.fromDPToPix(getContext(), 14);
                    BlurView gMs = this.KjE.L((ViewGroup) decorView).alW(getResources().getColor(R.color.acy)).F(background).b(new com.tencent.mm.ui.blur.f(getContext())).cw(15.0f).gMs();
                    gMs.Kx = ((float) fromDPToPix4) * 1.0f;
                    gMs.PcA = true;
                    gMs.alX(this.KkY).gMt();
                    this.KjU = new BlurView(getContext());
                    this.KjU.alW(getResources().getColor(R.color.acy));
                    this.KjU.L((ViewGroup) decorView).F(background).b(new com.tencent.mm.ui.blur.f(getContext())).cw(15.0f).gMs().gMt();
                }
            } catch (Throwable th) {
                this.Kkb = j.MODE_NORMAL;
                this.KkZ = true;
            }
            Log.i("MicroMsg.ChatFooter", "transVoiceBlurMode: %s.", this.Kkb);
            switch (this.Kkb) {
                case MODE_BLUR:
                    this.KjC.removeView(this.KjD);
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ant), getResources().getDimensionPixelSize(R.dimen.ant));
                    layoutParams5.addRule(14);
                    layoutParams5.addRule(10);
                    this.KjE.addView(this.KjD, layoutParams5);
                    this.KjC.addView(this.KjE, layoutParams5);
                    this.KjF = this.KjE;
                    this.KjU.addView(this.KjT, new FrameLayout.LayoutParams(-1, -1));
                    this.KjY = new p(this.KjU, -1, -1);
                    break;
                case MODE_INVALID:
                case MODE_NORMAL:
                    this.KjF = this.KjD;
                    this.KjF.setBackgroundResource(R.drawable.b26);
                    this.KjT.setBackgroundColor(getResources().getColor(R.color.ad0));
                    this.KjY = new p(this.KjT, -1, -1);
                    break;
            }
            this.KjY.setClippingEnabled(false);
            this.KjY.getContentView().setAlpha(0.0f);
            this.KjY.setOnDismissListener(new PopupWindow.OnDismissListener() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass45 */

                public final void onDismiss() {
                    AppMethodBeat.i(232260);
                    ChatFooter.this.KjY.getContentView().setAlpha(0.0f);
                    AppMethodBeat.o(232260);
                }
            });
            ((TextView) this.FQS.getContentView().findViewById(R.id.j9b)).setTextSize(0, ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.anx)) * com.tencent.mm.cb.a.ji(getContext()));
        }
        gqq();
        if (this.KkY != -1) {
            this.teZ.setVisibility(8);
            this.KiN.setVisibility(8);
            this.FQV.setVisibility(0);
            new MMHandler().post(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass46 */

                public final void run() {
                    AppMethodBeat.i(31552);
                    if (ChatFooter.this.KiS) {
                        ChatFooter.this.tfb.setVisibility(8);
                        ChatFooter.this.KjF.setVisibility(0);
                        AppMethodBeat.o(31552);
                        return;
                    }
                    ChatFooter.this.tfb.setVisibility(0);
                    ChatFooter.this.KjF.setVisibility(8);
                    AppMethodBeat.o(31552);
                }
            });
            if (this.KiS) {
                gra();
                this.Kke = false;
                gqX();
                this.KjY.showAtLocation(this, 49, 0, 0);
                this.Kkd = false;
                if (this.KlD) {
                    this.KlD = false;
                    if (j.MODE_BLUR == this.Kkb) {
                        this.KjE.alW(getResources().getColor(R.color.acy)).F(this.activity.getWindow().getDecorView().getBackground()).BJ(true);
                    } else {
                        this.KjF.setBackgroundResource(R.drawable.b26);
                    }
                }
            }
            this.FQS.showAtLocation(this, 49, 0, this.KkY);
        }
        AppMethodBeat.o(31616);
    }

    private void gqp() {
        AppMethodBeat.i(185399);
        this.Klc.start();
        this.Kld.start();
        this.Kle.start();
        this.Klf.start();
        this.Klg.start();
        this.KkM.animate().alpha(1.0f).setDuration(200).start();
        this.KkN.animate().alpha(1.0f).setDuration(200).start();
        this.Kkw.animate().alpha(1.0f).translationY(0.0f).setDuration(300).start();
        grd();
        AppMethodBeat.o(185399);
    }

    private void gqq() {
        AppMethodBeat.i(31617);
        if (this.KiS) {
            this.tfb.setVisibility(8);
            this.tfc.setVisibility(8);
            this.FQV.setVisibility(8);
            this.teZ.setVisibility(8);
            this.KjC.setVisibility(0);
            this.KjF.setVisibility(0);
            this.KjG.setVisibility(0);
            this.KjI.setVisibility(8);
            this.KjJ.setVisibility(0);
            this.KjK.setVisibility(8);
            this.KjM.setVisibility(8);
            this.KjN.setVisibility(8);
            this.KjQ.setVisibility(8);
            this.Kkc = k.MODE_INVALID;
            this.Kka = l.MODE_HINT_INVALID;
            AppMethodBeat.o(31617);
            return;
        }
        this.tfb.setVisibility(0);
        this.tfc.setVisibility(8);
        this.FQV.setVisibility(8);
        this.teZ.setVisibility(8);
        this.KjC.setVisibility(8);
        AppMethodBeat.o(31617);
    }

    private void setNewVoice2TxtCountDown(int i2) {
        AppMethodBeat.i(185400);
        if (i2 > 60 || i2 < 0) {
            Log.w("MicroMsg.ChatFooter", "skip by invalid quantity:%s", Integer.valueOf(i2));
            AppMethodBeat.o(185400);
            return;
        }
        switch (this.KlT) {
            case MODE_VOICE:
                int i3 = 60 - i2;
                int i4 = (int) (this.Klp * ((float) i3));
                this.Klt = Math.min(this.Klo + i4, this.Kln);
                Log.d("MicroMsg.ChatFooter", "voiceWidth:%s, duration:%s, offset:%s", Integer.valueOf(this.Klt), Integer.valueOf(i3), Integer.valueOf(i4));
                ValueAnimator duration = ValueAnimator.ofInt(this.Kkk.getWidth(), this.Klt).setDuration(200L);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass74 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(232282);
                        ((ViewGroup.MarginLayoutParams) ChatFooter.this.Kkk.getLayoutParams()).width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ChatFooter.this.Kkk.requestLayout();
                        AppMethodBeat.o(232282);
                    }
                });
                duration.start();
                if (i2 < 10) {
                    gre();
                    break;
                }
                break;
            case MODE_TRANS:
                if (i2 < 10) {
                    grf();
                    break;
                }
                break;
        }
        this.Klu = i2;
        AppMethodBeat.o(185400);
    }

    public void setVoiceReactArea(int i2) {
        AppMethodBeat.i(185401);
        if (this.Kkf) {
            setNewVoice2TxtCountDown(i2);
            AppMethodBeat.o(185401);
            return;
        }
        if (i2 < 10) {
            if (this.KiS) {
                setVoice2txtCountDown(i2);
                AppMethodBeat.o(185401);
                return;
            } else if (-1 == i2) {
                setRecordNormalWording(getResources().getString(R.string.aw1));
                AppMethodBeat.o(185401);
                return;
            } else {
                setRecordNormalWording(getResources().getQuantityString(R.plurals.f3136c, i2, Integer.valueOf(i2)));
            }
        }
        AppMethodBeat.o(185401);
    }

    public void setRecordNormalWording(String str) {
        AppMethodBeat.i(31618);
        if (str == null || this.KiO == null) {
            AppMethodBeat.o(31618);
            return;
        }
        this.KiO.setText(str);
        AppMethodBeat.o(31618);
    }

    public void setVoice2txtCountDown(int i2) {
        AppMethodBeat.i(31619);
        if (-1 == i2) {
            this.KjG.setVisibility(0);
            this.KjI.setVisibility(8);
            AppMethodBeat.o(31619);
            return;
        }
        if (i2 >= 0 && i2 < 10) {
            if (8 == this.KjI.getVisibility()) {
                this.KjG.setVisibility(8);
                this.KjI.setVisibility(0);
            }
            if (this.KjI != null) {
                this.KjI.setImageResource(this.Kli[i2]);
            }
        }
        AppMethodBeat.o(31619);
    }

    public final void gqr() {
        AppMethodBeat.i(31620);
        if (this.Kkf) {
            this.Kkm.setVisibility(0);
            this.KkQ.setVisibility(8);
            AppMethodBeat.o(31620);
            return;
        }
        this.FQV.setVisibility(8);
        this.KiN.setVisibility(0);
        AppMethodBeat.o(31620);
    }

    public enum h {
        SendVoice,
        StopRecord,
        Reset,
        Cancel,
        Pause,
        Error;

        public static h valueOf(String str) {
            AppMethodBeat.i(185820);
            h hVar = (h) Enum.valueOf(h.class, str);
            AppMethodBeat.o(185820);
            return hVar;
        }

        static {
            AppMethodBeat.i(185821);
            AppMethodBeat.o(185821);
        }
    }

    public final void a(final h hVar) {
        AppMethodBeat.i(185822);
        post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass48 */

            public final void run() {
                AppMethodBeat.i(185363);
                ChatFooter.this.Kim.setBackgroundResource(R.drawable.a8o);
                ChatFooter.this.Kim.setText(R.string.awg);
                if (ChatFooter.this.Kkf) {
                    switch (AnonymousClass83.Kmi[hVar.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            if (ChatFooter.this.Kkh != null) {
                                ChatFooter.K(ChatFooter.this);
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(185363);
                    return;
                }
                if (ChatFooter.this.FQS != null) {
                    ChatFooter.this.FQS.dismiss();
                    if (ChatFooter.this.KjY != null) {
                        ChatFooter.this.KjY.getContentView().animate().alpha(0.0f).setDuration(300).withEndAction(ChatFooter.this.KlQ).start();
                    }
                    ChatFooter.this.KiN.setVisibility(0);
                    ChatFooter.this.FQV.setVisibility(8);
                    ChatFooter.this.teZ.setVisibility(8);
                    ChatFooter.this.tfc.setVisibility(8);
                    ChatFooter.this.KjM.setVisibility(8);
                    ChatFooter.this.tfb.setVisibility(0);
                }
                ChatFooter.this.KiT = false;
                ChatFooter.this.qPk = false;
                AppMethodBeat.o(185363);
            }
        });
        AppMethodBeat.o(185822);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$83  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass83 {
        static final /* synthetic */ int[] Kmi = new int[h.values().length];

        static {
            AppMethodBeat.i(232294);
            try {
                Kmi[h.SendVoice.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Kmi[h.Cancel.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Kmi[h.Error.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Kmi[h.Reset.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Kmi[h.StopRecord.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                Kmi[h.Pause.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            Kmh = new int[e.values().length];
            try {
                Kmh[e.MODE_VOICE.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                Kmh[e.MODE_TRANS.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                Kmh[e.MODE_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            Kmg = new int[j.values().length];
            try {
                Kmg[j.MODE_BLUR.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                Kmg[j.MODE_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                Kmg[j.MODE_NORMAL.ordinal()] = 3;
                AppMethodBeat.o(232294);
            } catch (NoSuchFieldError e13) {
                AppMethodBeat.o(232294);
            }
        }
    }

    public final void aiy(int i2) {
        AppMethodBeat.i(31622);
        if (this.Kkf) {
            if (this.Kkm != null && this.Kkm.getVisibility() == 0) {
                this.Kkm.acr(i2);
            }
            AppMethodBeat.o(31622);
            return;
        }
        if (this.KiS) {
            int i3 = 0;
            while (true) {
                if (i3 < Klw.length) {
                    if (i2 >= Klv[i3] && i2 < Klv[i3 + 1]) {
                        this.KjH.setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), Klw[i3]));
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (i2 == -1 && this.FQS != null) {
                this.FQS.dismiss();
                this.FQV.setVisibility(0);
                this.KiN.setVisibility(8);
                this.teZ.setVisibility(8);
                AppMethodBeat.o(31622);
                return;
            }
        } else {
            int i4 = 0;
            while (true) {
                if (i4 < Klw.length) {
                    if (i2 >= Klv[i4] && i2 < Klv[i4 + 1]) {
                        this.tfa.setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), Klw[i4]));
                        break;
                    }
                    i4++;
                } else {
                    break;
                }
            }
            if (i2 == -1 && this.FQS != null) {
                this.FQS.dismiss();
                this.FQV.setVisibility(0);
                this.KiN.setVisibility(8);
                this.teZ.setVisibility(8);
            }
        }
        AppMethodBeat.o(31622);
    }

    public void setMode(int i2) {
        AppMethodBeat.i(31623);
        bA(i2, true);
        AppMethodBeat.o(31623);
    }

    public final void aiz(int i2) {
        AppMethodBeat.i(31624);
        this.KiR = i2;
        switch (i2) {
            case 1:
                Ai(true);
                this.Kim.setVisibility(8);
                aiw(R.drawable.oi);
                AppMethodBeat.o(31624);
                return;
            case 2:
                Ai(false);
                this.Kim.setVisibility(0);
                gqP();
                aiw(R.drawable.oh);
                if (z.aUQ().booleanValue() && this.Kjt != null) {
                    c cVar = this.Kjt;
                    Boolean bool = Boolean.TRUE;
                    cVar.b(bool, bool);
                    break;
                }
        }
        AppMethodBeat.o(31624);
    }

    public final void bA(int i2, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(31625);
        aiz(i2);
        switch (i2) {
            case 1:
                if (z) {
                    Ah(true);
                    showVKB();
                    if (this.ECK.length() <= 0) {
                        z2 = false;
                    }
                    qT(z2);
                    AppMethodBeat.o(31625);
                    return;
                }
                if (this.ECK.length() <= 0) {
                    z2 = false;
                }
                qT(z2);
                AppMethodBeat.o(31625);
                return;
            case 2:
                i(0, true, -1);
                qT(false);
                AppMethodBeat.o(31625);
                return;
            default:
                setVisibility(0);
                AppMethodBeat.o(31625);
                return;
        }
    }

    public final void gqs() {
        AppMethodBeat.i(31626);
        Ai(true);
        this.Kin.setVisibility(8);
        this.Kim.setVisibility(8);
        AppMethodBeat.o(31626);
    }

    public final void gqt() {
        AppMethodBeat.i(31627);
        if (this.Kin != null) {
            this.Kin.setVisibility(0);
        }
        AppMethodBeat.o(31627);
    }

    public final void gqu() {
        AppMethodBeat.i(31628);
        AppPanel appPanel = this.Kik;
        appPanel.KgQ.Khn.value = false;
        appPanel.gpV();
        AppMethodBeat.o(31628);
    }

    public final void gqv() {
        AppMethodBeat.i(31629);
        AppPanel appPanel = this.Kik;
        appPanel.KgQ.KhF.value = false;
        appPanel.gpV();
        AppMethodBeat.o(31629);
    }

    public final void gqw() {
        AppMethodBeat.i(31630);
        AppPanel appPanel = this.Kik;
        appPanel.KgQ.Kho.value = false;
        appPanel.gpV();
        AppMethodBeat.o(31630);
    }

    public final void gqx() {
        AppMethodBeat.i(31631);
        AppPanel appPanel = this.Kik;
        appPanel.KgQ.Khr.value = false;
        appPanel.gpV();
        AppMethodBeat.o(31631);
    }

    public final void aX(boolean z, boolean z2) {
        AppMethodBeat.i(31632);
        this.Kik.zW(z);
        this.Kik.zX(z2);
        AppMethodBeat.o(31632);
    }

    public final void zY(boolean z) {
        AppMethodBeat.i(31633);
        this.Kik.zY(z);
        AppMethodBeat.o(31633);
    }

    public final void zZ(boolean z) {
        AppMethodBeat.i(31634);
        this.Kik.zZ(z);
        AppMethodBeat.o(31634);
    }

    public final void gqy() {
        AppMethodBeat.i(31635);
        AppPanel appPanel = this.Kik;
        appPanel.KgY = true;
        appPanel.KgQ.Ae(false);
        appPanel.gpV();
        Log.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", Util.getStack().toString());
        AppMethodBeat.o(31635);
    }

    public final void gqz() {
        this.Kik.Khb = true;
    }

    public final void gqA() {
        AppMethodBeat.i(31636);
        AppPanel appPanel = this.Kik;
        appPanel.KgZ = true;
        appPanel.KgQ.Ab(false);
        appPanel.gpV();
        Log.i("MicroMsg.AppPanel", "disableServiceRemittance %s", Util.getStack().toString());
        AppMethodBeat.o(31636);
    }

    public final void gqB() {
        AppMethodBeat.i(232298);
        this.Kik.gpN();
        AppMethodBeat.o(232298);
    }

    public final void gqC() {
        AppMethodBeat.i(232299);
        AppPanel appPanel = this.Kik;
        appPanel.KgQ.Khp.value = false;
        appPanel.gpV();
        AppMethodBeat.o(232299);
    }

    public final void gqD() {
        AppMethodBeat.i(31637);
        if (this.Kit != null) {
            this.Kit.setVisibility(8);
        }
        AppMethodBeat.o(31637);
    }

    public final void gqE() {
        AppMethodBeat.i(31638);
        AppPanel appPanel = this.Kik;
        appPanel.Kha = true;
        appPanel.KgQ.Af(false);
        appPanel.gpV();
        AppMethodBeat.o(31638);
    }

    public void setAppPanelUnCertainEnterArrayList(ArrayList<a.C2027a> arrayList) {
        AppMethodBeat.i(163214);
        this.Kik.setAppPanelUnCertainEnterArrayList(arrayList);
        AppMethodBeat.o(163214);
    }

    public ArrayList<a.C2027a> getAppPanelUnCertainEnterArrayList() {
        AppMethodBeat.i(163215);
        ArrayList<a.C2027a> appPanelUnCertainEnterArrayList = this.Kik.getAppPanelUnCertainEnterArrayList();
        AppMethodBeat.o(163215);
        return appPanelUnCertainEnterArrayList;
    }

    public final void gqF() {
        AppMethodBeat.i(31639);
        Log.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
        this.KiU = true;
        this.ECK.setImeOptions(4);
        this.ECK.setInputType(this.ECK.getInputType() & -65);
        AppMethodBeat.o(31639);
    }

    private void gqG() {
        AppMethodBeat.i(31640);
        this.jxm.findViewById(R.id.ay7).setVisibility(0);
        AppMethodBeat.o(31640);
    }

    private void gqH() {
        AppMethodBeat.i(31641);
        Log.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
        this.KiU = false;
        this.ECK.setImeOptions(0);
        this.ECK.setInputType(this.ECK.getInputType() | 64);
        AppMethodBeat.o(31641);
    }

    public int getMode() {
        return this.KiR;
    }

    public void setAppPanelVisible(int i2) {
        AppMethodBeat.i(31642);
        if (this.Kik != null) {
            this.Kik.setVisibility(i2);
        }
        setAppPanelTipVisible(i2 == 0);
        AppMethodBeat.o(31642);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        AppMethodBeat.i(31643);
        super.onConfigurationChanged(configuration);
        if (com.tencent.mm.compatible.util.d.oD(24)) {
            this.Kje = ((Activity) getContext()).isInMultiWindowMode();
        }
        if (configuration.orientation == 1) {
            z = true;
        } else {
            z = false;
        }
        this.KiX = z;
        i(0, false, -1);
        gqN();
        Log.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s, %s, %s", configuration, Boolean.valueOf(this.KiX), Boolean.valueOf(this.Kje));
        aiC(getKeyBordHeightPX());
        b.a aVar = com.tencent.mm.plugin.patmsg.ui.b.ARN;
        com.tencent.mm.plugin.patmsg.ui.b bVar = com.tencent.mm.plugin.patmsg.ui.b.ARM;
        if (bVar != null) {
            bVar.dismiss();
        }
        AppMethodBeat.o(31643);
    }

    public void setBottomPanelVisibility(int i2) {
        AppMethodBeat.i(31644);
        if (i2 == 0) {
            this.Kip.setVisibility(i2);
            AppMethodBeat.o(31644);
            return;
        }
        i(0, true, -1);
        AppMethodBeat.o(31644);
    }

    public final boolean gqI() {
        int i2;
        DisplayCutout displayCutout;
        AppMethodBeat.i(31645);
        if (this.Kjx == null || this.Kjx.getView() == null) {
            AppMethodBeat.o(31645);
            return false;
        }
        View findViewById = this.Kjx.getView().findViewById(R.id.ffv);
        if (findViewById == null) {
            AppMethodBeat.o(31645);
            return false;
        }
        Rect rect = new Rect();
        findViewById.getGlobalVisibleRect(rect);
        if (!com.tencent.mm.compatible.util.d.oD(28) || (displayCutout = findViewById.getRootWindowInsets().getDisplayCutout()) == null) {
            i2 = 0;
        } else {
            i2 = displayCutout.getSafeInsetLeft();
        }
        if (rect.left > i2) {
            AppMethodBeat.o(31645);
            return true;
        }
        AppMethodBeat.o(31645);
        return false;
    }

    public final boolean gqJ() {
        return this.KiY != 0;
    }

    public void setWordCountLimit(int i2) {
        AppMethodBeat.i(31646);
        this.Kil = (TextView) this.jxm.findViewById(R.id.aze);
        this.ECK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        AppMethodBeat.o(31646);
    }

    @TargetApi(11)
    public void setEditTextOnDragListener(View.OnDragListener onDragListener) {
        AppMethodBeat.i(31647);
        this.ECK.setOnDragListener(onDragListener);
        AppMethodBeat.o(31647);
    }

    public void setOnEditFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(31648);
        this.ECK.setOnFocusChangeListener(onFocusChangeListener);
        AppMethodBeat.o(31648);
    }

    public void setAppPanelListener(AppPanel.a aVar) {
        AppMethodBeat.i(31649);
        this.Kik.setAppPanelListener(aVar);
        AppMethodBeat.o(31649);
    }

    public void setSetTolastCustomPage(boolean z) {
    }

    public void setOnFooterSwitchListener(g gVar) {
        AppMethodBeat.i(31650);
        this.KiE = gVar;
        if (gVar == null) {
            AppMethodBeat.o(31650);
            return;
        }
        View findViewById = findViewById(R.id.ax8);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass49 */

            public final void onClick(View view) {
                AppMethodBeat.i(232262);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ChatFooter.this.KiE != null) {
                    ChatFooter.this.KiE.An(false);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232262);
            }
        });
        AppMethodBeat.o(31650);
    }

    public void setOnFooterPanelSwitchListener(f fVar) {
        this.KiF = fVar;
    }

    public void setSwitchButtonMode(int i2) {
        AppMethodBeat.i(31651);
        if (i2 == this.Klx) {
            AppMethodBeat.o(31651);
            return;
        }
        this.Klx = i2;
        ImageView imageView = (ImageView) findViewById(R.id.if8);
        ImageView imageView2 = (ImageView) findViewById(R.id.g4j);
        if (this.Klx == 1) {
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            AppMethodBeat.o(31651);
            return;
        }
        imageView.setVisibility(0);
        imageView2.setVisibility(8);
        AppMethodBeat.o(31651);
    }

    public int getSmieyType() {
        return 0;
    }

    @TargetApi(11)
    public void setToSendTextColor(final boolean z) {
        AppMethodBeat.i(31652);
        if (com.tencent.mm.compatible.util.d.oD(11)) {
            com.tencent.mm.compatible.a.a.a(11, new a.AbstractC0298a() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass50 */

                @Override // com.tencent.mm.compatible.a.a.AbstractC0298a
                public final void run() {
                    AppMethodBeat.i(185794);
                    Message message = new Message();
                    message.what = 1002;
                    message.obj = Boolean.valueOf(z);
                    ChatFooter.this.mHandler.sendMessage(message);
                    AppMethodBeat.o(185794);
                }
            });
            AppMethodBeat.o(31652);
        } else if (z) {
            this.ECK.setTextColor(getResources().getColor(R.color.a0_));
            AppMethodBeat.o(31652);
        } else {
            this.ECK.setTextColor(getResources().getColor(R.color.u_));
            Ah(false);
            AppMethodBeat.o(31652);
        }
    }

    public final void gqK() {
        AppMethodBeat.i(31653);
        postDelayed(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass51 */

            public final void run() {
                AppMethodBeat.i(232263);
                Log.i("MicroMsg.ChatFooter", "withLastText: ");
                ChatFooter.this.showVKB();
                ChatFooter.a(ChatFooter.this, true);
                AppMethodBeat.o(232263);
            }
        }, 500);
        AppMethodBeat.o(31653);
    }

    public final void Aj(boolean z) {
        AppMethodBeat.i(31654);
        Log.i("MicroMsg.ChatFooter", "withoutLastText: ");
        hideVKB();
        Ah(z);
        AppMethodBeat.o(31654);
    }

    public final void gqL() {
        AppMethodBeat.i(31655);
        if (this.Kdp != null && this.Kdp.isShown()) {
            this.Kdp.grA();
        }
        AppMethodBeat.o(31655);
    }

    public final void showVKB() {
        AppMethodBeat.i(31656);
        if (!(this.Kjx == null || !this.Kjx.isSupportNavigationSwipeBack() || this.Kjx.getSwipeBackLayout() == null)) {
            this.Kjx.getSwipeBackLayout().setOnceDisEnableGesture(true);
        }
        if (!gqI()) {
            i(1, true, -1);
            AppMethodBeat.o(31656);
            return;
        }
        Log.i("MicroMsg.ChatFooter", "isScrolling!! pass this event!");
        AppMethodBeat.o(31656);
    }

    private void a(boolean z, final Runnable runnable, int i2) {
        AppMethodBeat.i(163216);
        if (z) {
            if (this.Kik == null) {
                gqn();
            }
            this.Kik.animate().cancel();
            if (this.Kik.getVisibility() != 0 || this.Kik.getAlpha() != 1.0f) {
                setAppPanelVisible(0);
                this.Kik.setAlpha(0.0f);
                this.Kik.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).setListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass52 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(232264);
                        ChatFooter.bo(ChatFooter.this);
                        ChatFooter.this.Kik.animate().setListener(null);
                        AppMethodBeat.o(232264);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                }).start();
                this.Kik.setUncertainEnterLocation(i2);
                this.Kik.refresh();
            } else if (runnable != null) {
                runnable.run();
            }
        } else {
            this.Kik.animate().cancel();
            if (this.Kik.getVisibility() != 4 && this.Kik.getAlpha() != 0.0f) {
                this.Kik.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass53 */

                    public final void run() {
                        AppMethodBeat.i(185796);
                        ChatFooter.this.setAppPanelVisible(4);
                        if (runnable != null) {
                            runnable.run();
                        }
                        AppMethodBeat.o(185796);
                    }
                });
            } else if (runnable != null) {
                runnable.run();
            }
        }
        this.ECK.gYF();
        AppMethodBeat.o(163216);
    }

    private void a(boolean z, final Runnable runnable) {
        AppMethodBeat.i(31658);
        if (z) {
            if (this.rum == null) {
                gqm();
            }
            this.rum.animate().cancel();
            if (this.rum.getVisibility() != 0 || this.rum.getAlpha() != 1.0f) {
                this.rum.setVisibility(0);
                this.rum.setAlpha(0.0f);
                this.rum.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
                this.rum.setToSendText(this.ECK.getText().toString());
                AppMethodBeat.o(31658);
                return;
            } else if (runnable != null) {
                runnable.run();
                AppMethodBeat.o(31658);
                return;
            }
        } else if (this.rum != null && this.rum.getVisibility() != 4 && this.rum.getAlpha() != 0.0f) {
            this.rum.animate().cancel();
            this.rum.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass54 */

                public final void run() {
                    AppMethodBeat.i(232265);
                    ChatFooter.this.rum.setVisibility(4);
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.o(232265);
                }
            }).start();
        } else if (runnable != null) {
            runnable.run();
            AppMethodBeat.o(31658);
            return;
        }
        AppMethodBeat.o(31658);
    }

    public final boolean hideVKB() {
        AppMethodBeat.i(31659);
        if (getKeyBordHeightPX() / 2 <= getBottom()) {
            boolean hideVKB = Util.hideVKB(this);
            AppMethodBeat.o(31659);
            return hideVKB;
        }
        AppMethodBeat.o(31659);
        return false;
    }

    private void gqM() {
        AppMethodBeat.i(31660);
        if (this.Kja == null) {
            ViewParent parent = getParent();
            if (parent instanceof ChattingScrollLayout) {
                this.Kja = (ChattingScrollLayout) parent;
                this.Kjb = true;
            }
        }
        AppMethodBeat.o(31660);
    }

    public int getCurrentScrollHeight() {
        return this.Kjd;
    }

    public void setIgnoreScroll(Boolean bool) {
        AppMethodBeat.i(31661);
        this.Kjn = bool.booleanValue();
        AppMethodBeat.o(31661);
    }

    public void setKeyboardShow(Boolean bool) {
        AppMethodBeat.i(31662);
        this.xfU = bool.booleanValue();
        AppMethodBeat.o(31662);
    }

    public final void aiA(int i2) {
        AppMethodBeat.i(185823);
        b(i2, true, 0, 0);
        AppMethodBeat.o(185823);
    }

    private void b(int i2, boolean z, int i3, int i4) {
        AppMethodBeat.i(185824);
        gqM();
        if (this.Kja == null) {
            if (this.KiY == 0 || this.KiY == 1) {
                this.Kip.setVisibility(8);
            }
            Log.e("MicroMsg.ChatFooter", "scrollParent: scrollParent is not ChattingScrollLayout");
            AppMethodBeat.o(185824);
        } else if (!this.Kji || this.KiY != 1) {
            this.Kja.c(i2, z, i3, i4);
            AppMethodBeat.o(185824);
        } else {
            this.Kja.c(0, false, i3, i4);
            AppMethodBeat.o(185824);
        }
    }

    public final void i(int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        AppMethodBeat.i(163217);
        Log.i("MicroMsg.ChatFooter", "configPanel: %s, %s, %s, %s, %s", Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(this.xfU), Boolean.valueOf(this.Kje), Boolean.valueOf(this.KiX));
        boolean z5 = this.Kje || !this.KiX;
        if (i2 != 1 || this.xfU) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (i2 == 1 || !this.xfU) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z5 || (!z2 && !z3)) {
            j(i2, z, i3);
        } else {
            this.KiZ = i2;
        }
        if (z2) {
            this.Kjh = 0;
            post(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass56 */

                public final void run() {
                    AppMethodBeat.i(232266);
                    ChatFooter.a(ChatFooter.this, true);
                    ChatFooter.this.setToSendTextColor(true);
                    boolean showSoftInput = ChatFooter.this.KiQ.showSoftInput(ChatFooter.this.ECK.gYG(), 0);
                    ChatFooter.bq(ChatFooter.this);
                    Log.i("MicroMsg.ChatFooter", "showSoftInput %b, %s", Boolean.valueOf(showSoftInput), Integer.valueOf(ChatFooter.this.Kjh));
                    if (!showSoftInput && ChatFooter.this.Kjh < 10) {
                        ChatFooter.this.postDelayed(this, 100);
                    }
                    AppMethodBeat.o(232266);
                }
            });
        }
        if (z3) {
            hideVKB();
        }
        if (z5) {
            if (i2 != 1) {
                z4 = false;
            }
            this.xfU = z4;
        }
        AppMethodBeat.o(163217);
    }

    private void j(int i2, boolean z, final int i3) {
        int i4;
        int i5 = 0;
        AppMethodBeat.i(163218);
        Log.i("MicroMsg.ChatFooter", "switchPanel: %s, %s", Integer.valueOf(i2), Boolean.valueOf(z));
        if (this.Kjn) {
            AppMethodBeat.o(163218);
            return;
        }
        if (!(i2 == 0 || !z.aUQ().booleanValue() || this.Kjt == null)) {
            this.Kjt.a(Boolean.TRUE, Boolean.FALSE);
            this.Kjt.b(Boolean.TRUE, Boolean.FALSE);
        }
        aiB(i2);
        if (this.Kio != null) {
            this.Kio.setVisibility(0);
        }
        switch (i2) {
            case 0:
                this.Kjd = 0;
                a(false, (Runnable) null);
                a(false, (Runnable) null, -1);
                gpb();
                gqO();
                break;
            case 1:
                if (!this.KiX || this.Kje) {
                    this.Kjd = 0;
                } else {
                    this.Kjd = this.oXi;
                }
                a(false, (Runnable) null);
                a(false, (Runnable) null, -1);
                break;
            case 2:
                this.Kjd = this.Kjl;
                this.Kip.setVisibility(0);
                a(false, (Runnable) new Runnable() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass57 */

                    public final void run() {
                        AppMethodBeat.i(232267);
                        ChatFooter.bs(ChatFooter.this);
                        AppMethodBeat.o(232267);
                    }
                }, -1);
                break;
            case 3:
                this.Kjd = this.Kjk;
                this.Kip.setVisibility(0);
                a(false, (Runnable) new Runnable() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass58 */

                    public final void run() {
                        AppMethodBeat.i(232268);
                        ChatFooter.h(ChatFooter.this, i3);
                        AppMethodBeat.o(232268);
                    }
                });
                this.KiA.grx();
                Ah(false);
                if (this.KiR == 2) {
                    aiz(1);
                    break;
                }
                break;
            case 4:
                if (this.Kio != null) {
                    this.Kio.setVisibility(4);
                }
                this.Kjd = this.Kjm;
                a(false, (Runnable) null);
                a(false, (Runnable) null, -1);
                break;
        }
        if ((this.KiY == 0 && i2 == 1) || (this.KiY == 1 && i2 == 0)) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        aR(this.KiY, i2, i4);
        boolean z2 = this.KiY != i2;
        this.KiY = i2;
        if (this.KiY == 2) {
            Al(true);
            com.tencent.mm.emoji.c.b bVar = com.tencent.mm.emoji.c.b.hcd;
            com.tencent.mm.emoji.c.b.awa();
        } else {
            Al(false);
            com.tencent.mm.emoji.c.b bVar2 = com.tencent.mm.emoji.c.b.hcd;
            com.tencent.mm.emoji.c.b.awb();
        }
        int i6 = this.Kjd;
        if (this.Kjp != null) {
            i5 = this.Kjp.dYg();
        }
        b(i6, z, i4, i5);
        if (z2) {
            com.tencent.f.h.RTc.o(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass59 */

                public final void run() {
                    aw awVar;
                    AppMethodBeat.i(232269);
                    if (!(ChatFooter.this.Kjy == null || ChatFooter.this.Kjy.grq() == null || (awVar = (aw) ChatFooter.this.Kjy.grq().bh(aw.class)) == null)) {
                        awVar.gRB();
                    }
                    AppMethodBeat.o(232269);
                }
            }, 300);
        }
        if (this.KiF != null) {
            this.KiF.kE(this.KiY, this.Kjd);
        }
        AppMethodBeat.o(163218);
    }

    private void aR(int i2, int i3, int i4) {
        AppMethodBeat.i(185825);
        boolean z = 1 == i4;
        if ((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) && i3 == 0) {
            if (this.Kjp != null) {
                this.Kjp.BP(z);
                AppMethodBeat.o(185825);
                return;
            }
        } else if (i2 == 0 && ((i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) && this.Kjp != null)) {
            this.Kjp.BQ(z);
        }
        AppMethodBeat.o(185825);
    }

    private void aiB(int i2) {
        AppMethodBeat.i(31666);
        if (i2 == this.KiY) {
            AppMethodBeat.o(31666);
            return;
        }
        if (this.han.getVisibility() == 8) {
            gqP();
        }
        if ((i2 == 0 && this.Kiu.getVisibility() == 8) || i2 == 3 || (i2 == 0 && this.Kiu.getVisibility() == 8)) {
            gqP();
        }
        AppMethodBeat.o(31666);
    }

    public void setIsMultiWindow(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(31667);
        Log.i("MicroMsg.ChatFooter", "setIsMultiWindow: %s", Boolean.valueOf(z));
        if (this.Kje == z) {
            z2 = false;
        }
        this.Kje = z;
        gqN();
        if (z2) {
            aiC(getKeyBordHeightPX());
            i(0, false, -1);
        }
        AppMethodBeat.o(31667);
    }

    private void gqN() {
        AppMethodBeat.i(31668);
        if (!this.wxq) {
            Log.i("MicroMsg.ChatFooter", "updateKeyboardProvider: not resumed %s", Util.getStack());
            AppMethodBeat.o(31668);
        } else if (this.Kje || !this.KiX) {
            this.gyh.close();
            ((Activity) getContext()).getWindow().setSoftInputMode(18);
            AppMethodBeat.o(31668);
        } else {
            ((Activity) getContext()).getWindow().setSoftInputMode(this.Kjc | 2);
            this.gyh.start();
            AppMethodBeat.o(31668);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(31669);
        Log.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", Integer.valueOf(View.MeasureSpec.getSize(i3)), Integer.valueOf(getMeasuredHeight()));
        super.onMeasure(i2, i3);
        Log.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", Integer.valueOf(getMeasuredHeight()));
        AppMethodBeat.o(31669);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        boolean z2;
        boolean z3;
        int i3 = 0;
        AppMethodBeat.i(31670);
        Log.i("MicroMsg.ChatFooter", "onKeyboardHeightChanged: %s, %s, %s", Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(this.Kjc));
        if (!this.Kjf) {
            AppMethodBeat.o(31670);
            return;
        }
        com.tencent.mm.ui.widget.cedit.api.c cVar = this.ECK;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        cVar.CS(z2);
        if (!this.Kjg) {
            SecDataUIC.a aVar = SecDataUIC.CWq;
            if (((czj) SecDataUIC.a.c(getContext(), 4, czj.class)).MEF != 1) {
                if (!this.Kkf || this.Kkh == null || !this.Kkh.isShowing()) {
                    if (!this.Kje && this.KiX) {
                        boolean z4 = this.Kji != z;
                        this.Kji = z;
                        if (i2 > 0) {
                            if (this.oXi != i2) {
                                this.oXi = i2;
                                com.tencent.mm.compatible.util.i.C(getContext(), i2);
                                aiC(i2);
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!this.xfU) {
                                j(1, true, -1);
                                this.KiZ = -1;
                            } else if (z3 || z4) {
                                this.Kjd = this.oXi;
                                int i4 = this.Kjd;
                                if (this.Kjp != null) {
                                    i3 = this.Kjp.dYg();
                                }
                                b(i4, true, 1, i3);
                            }
                            this.xfU = true;
                        } else {
                            if (this.xfU) {
                                if (this.KiZ != -1) {
                                    j(this.KiZ, true, -1);
                                    this.KiZ = -1;
                                } else {
                                    j(0, true, -1);
                                }
                            }
                            if (this.KiY == 1) {
                                Log.i("MicroMsg.ChatFooter", "keyboard not open");
                                j(0, true, -1);
                            }
                            this.xfU = false;
                        }
                    }
                    if (this.KiD != null) {
                        this.KiD.qY(this.xfU);
                    }
                    AppMethodBeat.o(31670);
                    return;
                }
                if (i2 <= 0) {
                    this.xfU = false;
                    this.Kkl.setCursorVisible(false);
                    this.Kkv.animate().translationY(0.0f).setDuration(200).start();
                    this.Kkk.animate().translationY(0.0f).setDuration(200).start();
                    this.Kkn.animate().translationY(0.0f).setDuration(200).start();
                    this.Kkq.animate().translationY(0.0f).setDuration(200).start();
                    if (this.Kkk.getHeight() < this.Kls) {
                        ValueAnimator duration = ValueAnimator.ofInt(this.Kkk.getHeight(), this.Kls).setDuration(200L);
                        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass60 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(185376);
                                ((ViewGroup.MarginLayoutParams) ChatFooter.this.Kkk.getLayoutParams()).height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                ChatFooter.this.Kkk.requestLayout();
                                AppMethodBeat.o(185376);
                            }
                        });
                        duration.start();
                        AppMethodBeat.o(31670);
                        return;
                    }
                } else {
                    this.xfU = true;
                    this.Kkl.setCursorVisible(true);
                    Log.d("MicroMsg.ChatFooter", "height:%s, WeUIToolHelper.getDisplayRealSize(getContext()).y - newVoice2txtOpeArea.getBottom():%s", Integer.valueOf(i2), Integer.valueOf(au.az(getContext()).y - this.Kkv.getBottom()));
                    int i5 = au.az(getContext()).y;
                    int[] iArr = new int[2];
                    this.Kkv.getLocationOnScreen(iArr);
                    this.Kkv.animate().translationY((float) (-((i2 - (i5 - (iArr[1] + this.Kkv.getHeight()))) + au.aD(getContext())))).setDuration(200).start();
                    int height = (i5 - (this.Kkv.getHeight() + i2)) - at.fromDPToPix(getContext(), 24);
                    int height2 = this.Kkk.getHeight() + this.Kkn.getHeight() + at.fromDPToPix(getContext(), 48);
                    Log.d("MicroMsg.ChatFooter", "leftSpcaeDown:%s, editDown:%s", Integer.valueOf(height), Integer.valueOf(height2));
                    this.Klr = height - at.fromDPToPix(getContext(), 52);
                    if (this.Klr < this.Klk) {
                        Log.i("MicroMsg.ChatFooter", "invalid maxHeightWhenKeyboard, value:%s", Integer.valueOf(this.Klr));
                        this.Klr = this.Klk;
                    }
                    this.Kls = this.Kkk.getHeight();
                    int[] iArr2 = new int[2];
                    this.Kkn.getLocationOnScreen(iArr2);
                    int height3 = iArr2[1] + this.Kkn.getHeight();
                    if (height3 > height) {
                        int i6 = height3 - height;
                        if (height2 > height) {
                            int i7 = height2 - height;
                            int i8 = this.Kkk.getLayoutParams().height;
                            ValueAnimator duration2 = ValueAnimator.ofInt(i8, i8 - i7).setDuration(200L);
                            duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass61 */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    AppMethodBeat.i(185804);
                                    ChatFooter.this.Kkk.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    ChatFooter.this.Kkk.requestLayout();
                                    AppMethodBeat.o(185804);
                                }
                            });
                            duration2.start();
                        }
                        this.Kkk.animate().translationY((float) (-i6)).setDuration(200).start();
                        this.Kkn.animate().translationY((float) (-i6)).setDuration(200).start();
                        this.Kkq.animate().translationY((float) (-i6)).setDuration(200).start();
                    }
                }
                AppMethodBeat.o(31670);
                return;
            }
        }
        if (i2 <= 0) {
            this.xfU = false;
            AppMethodBeat.o(31670);
            return;
        }
        this.xfU = true;
        AppMethodBeat.o(31670);
    }

    public int getKeyBordHeightPX() {
        AppMethodBeat.i(31671);
        int validPanelHeight = KeyBoardUtil.getValidPanelHeight(getContext());
        AppMethodBeat.o(31671);
        return validPanelHeight;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(31672);
        super.onSizeChanged(i2, i3, i4, i5);
        Log.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        AppMethodBeat.o(31672);
    }

    private void Al(boolean z) {
        AppMethodBeat.i(31673);
        if (this.Kit == null) {
            AppMethodBeat.o(31673);
        } else if (this.Kly && z) {
            AppMethodBeat.o(31673);
        } else if (this.Kly || z) {
            this.Kly = z;
            if (z) {
                this.Kit.setImageDrawable(getContext().getResources().getDrawable(R.drawable.oh));
                AppMethodBeat.o(31673);
                return;
            }
            this.Kit.setImageDrawable(getContext().getResources().getDrawable(R.raw.icons_outlined_emoji));
            AppMethodBeat.o(31673);
        } else {
            AppMethodBeat.o(31673);
        }
    }

    public final void gqO() {
        AppMethodBeat.i(232301);
        if (this.KiB != null) {
            this.KiB.Knv = false;
            this.KiB.hide();
        }
        AppMethodBeat.o(232301);
    }

    public final void gqP() {
        AppMethodBeat.i(31674);
        if (this.KiC != null) {
            this.KiC.dYf();
        }
        AppMethodBeat.o(31674);
    }

    public final void beX(String str) {
        AppMethodBeat.i(31675);
        if (!(this.KiC == null || this.han == null || this.Kjy == null)) {
            com.tencent.mm.plugin.groupsolitaire.ui.d dVar = this.KiC;
            String talkerUserName = this.Kjy.getTalkerUserName();
            Button button = this.han;
            Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow supportAnalyze:%s supportShow:%s", Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).aBf(talkerUserName)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).aBg(talkerUserName)));
            dVar.ygS = button;
            dVar.content = str;
            if (((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).aBf(talkerUserName)) {
                if (!Util.isNullOrNil(str) && !str.equals(dVar.ygH)) {
                    com.tencent.f.h.RTc.bqo("GroupSolitaireCheck");
                    try {
                        str = ((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.a.class)).alW(str);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow() emojiSoftBank2Unicode %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                    }
                    dVar.ygP.setContent(str);
                    dVar.ygP.aBs(dVar.ygk);
                    com.tencent.f.h.RTc.a(dVar.ygP, 500, "GroupSolitaireCheck");
                    if (Util.isNullOrNil(dVar.ygH)) {
                        dVar.ygQ.setContent(str);
                        dVar.ygQ.aBs(dVar.ygk);
                        com.tencent.f.h.RTc.a(dVar.ygQ, 500, "GroupSolitaireCopyCheck");
                    }
                } else if (Util.isNullOrNil(str)) {
                    dVar.dYf();
                }
                dVar.ygH = str;
                dVar.ygk = talkerUserName;
            }
        }
        AppMethodBeat.o(31675);
    }

    private boolean db(String str, boolean z) {
        String str2;
        boolean z2;
        AppMethodBeat.i(179783);
        if (gqQ()) {
            AppMethodBeat.o(179783);
            return false;
        } else if (this.Kjy == null || Util.isNullOrNil(this.Kjy.getTalkerUserName())) {
            Log.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg username == null");
            AppMethodBeat.o(179783);
            return false;
        } else {
            try {
                String talkerUserName = this.Kjy.getTalkerUserName();
                if (((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).aBg(talkerUserName) && z) {
                    this.KiC.dYf();
                    try {
                        str2 = ((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.a.class)).alW(str);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() emojiSoftBank2Unicode %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                        str2 = str;
                    }
                    Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> ia = ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ia(str2, talkerUserName);
                    if (((Integer) ia.first).intValue() > 0 && ia.second != null) {
                        com.tencent.mm.plugin.groupsolitaire.c.a aVar = (com.tencent.mm.plugin.groupsolitaire.c.a) ia.second;
                        com.tencent.mm.plugin.groupsolitaire.b.b.a(talkerUserName, z.aTY(), aVar);
                        com.tencent.mm.plugin.groupsolitaire.c.a a2 = com.tencent.mm.plugin.groupsolitaire.b.b.a(aVar, ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(talkerUserName, aVar.field_key, true), z.aTY(), 1);
                        if (a2 == null) {
                            Log.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg storageGroupSolitatire == null");
                            AppMethodBeat.o(179783);
                            return false;
                        }
                        com.tencent.mm.plugin.groupsolitaire.b.b.b(a2);
                        com.tencent.mm.plugin.groupsolitaire.c.a a3 = com.tencent.mm.plugin.groupsolitaire.b.b.a(aVar, this.KiC.ygN, a2);
                        if (a3.yfF) {
                            com.tencent.mm.plugin.groupsolitaire.b.b.c(a3);
                        }
                        a3.field_lastActiveTime = (long) cl.aWB();
                        com.tencent.mm.plugin.groupsolitaire.b.b.a(a3, a2 != null, true);
                        PluginGroupSolitaire pluginGroupSolitaire = (PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class);
                        if (a2.field_active == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        pluginGroupSolitaire.sendGroupSolitatire(str2, talkerUserName, aVar, a3, a2, z2);
                        if (this.KiD != null) {
                            this.KiD.aBt(str2);
                        }
                        this.KiC.reset();
                        gqj();
                        AppMethodBeat.o(179783);
                        return true;
                    }
                }
                AppMethodBeat.o(179783);
                return false;
            } catch (Exception e3) {
                Log.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() Exception:%s %s", e3.getClass().getSimpleName(), e3.getMessage());
                AppMethodBeat.o(179783);
                return false;
            }
        }
    }

    public final boolean gqQ() {
        AppMethodBeat.i(31677);
        if (this.Kix.getTag() == null || !(this.Kix.getTag() instanceof ca) || !this.Kiw.isShown() || !this.Kix.isShown()) {
            AppMethodBeat.o(31677);
            return false;
        }
        AppMethodBeat.o(31677);
        return true;
    }

    public final boolean aT(ca caVar) {
        AppMethodBeat.i(31678);
        if (this.KiD != null) {
            this.KiD.ehQ();
        }
        this.Kix.setTag(caVar);
        this.KiR = 1;
        Ai(true);
        this.Kim.setVisibility(8);
        aiw(R.drawable.oi);
        if (this.Kdp != null) {
            this.Kdp.setVisibility(8);
            this.Kds = false;
            this.Kdp.reset();
        }
        showVKB();
        Ah(true);
        beX("");
        AppMethodBeat.o(31678);
        return true;
    }

    public final void dYi() {
        AppMethodBeat.i(31679);
        if (this.ECK != null) {
            this.ECK.setText("");
            gqh();
            if (this.rum != null) {
                this.rum.setToSendText("");
            }
        }
        AppMethodBeat.o(31679);
    }

    private void aiC(int i2) {
        int i3;
        AppMethodBeat.i(31680);
        Log.i("MicroMsg.ChatFooter", "[refreshBottomHeight] keyborPx:%d", Integer.valueOf(i2));
        com.tencent.mm.compatible.util.i.setFixedHeight(false);
        if (as.bjp(this.Kij) || as.bjq(this.Kij)) {
            i3 = com.tencent.mm.compatible.util.i.getValidPanelHeight(getContext(), i2, 43);
        } else {
            i3 = com.tencent.mm.compatible.util.i.getValidPanelHeight(getContext(), i2);
        }
        int bD = ad.bD(getContext());
        if (!this.KiX || this.Kje) {
            this.Kjk = KeyBoardUtil.getValidPanelHeight(getContext());
        } else {
            this.Kjk = i3;
        }
        int max = Math.max(bD, this.Kjk);
        this.Kjl = max;
        if (max != this.Kjj) {
            this.Kjj = max;
        }
        Log.i("MicroMsg.ChatFooter", "refreshBottomHeight: %s, %s, %s, %s, %s", Boolean.valueOf(this.KiX), Boolean.valueOf(this.Kje), Integer.valueOf(this.Kjk), Integer.valueOf(this.Kjj), Boolean.valueOf(KeyBoardUtil.isPortOrientation(getContext())));
        ViewGroup.LayoutParams layoutParams = this.Kip.getLayoutParams();
        if (!(layoutParams == null || layoutParams.height == this.Kjj)) {
            layoutParams.height = this.Kjj;
            this.Kip.setLayoutParams(layoutParams);
            this.Kip.requestLayout();
        }
        if (this.Kjb) {
            int i4 = -this.Kjj;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            if (!(marginLayoutParams == null || marginLayoutParams.bottomMargin == i4)) {
                marginLayoutParams.bottomMargin = i4;
                setLayoutParams(marginLayoutParams);
            }
        }
        if (this.Kik != null) {
            this.Kik.setPortHeighPx(this.Kjk);
            this.Kik.gpZ();
        }
        if (this.Kdp != null) {
            int height = this.Kjk + this.Kio.getHeight();
            ViewGroup.LayoutParams layoutParams2 = this.Kdp.getLayoutParams();
            if (!(layoutParams2 == null || layoutParams2.height == height)) {
                layoutParams2.height = height;
                this.Kdp.setLayoutParams(layoutParams2);
            }
        }
        AppMethodBeat.o(31680);
    }

    public final void gqR() {
        AppMethodBeat.i(31681);
        this.Kim.setBackgroundResource(R.drawable.a8o);
        this.Kim.setText(R.string.awg);
        if (!this.Kkf) {
            this.qPk = false;
            if (this.KiD != null) {
                this.KjZ.GtP = this.KiD.aas();
                if (this.KiS) {
                    if (k.MODE_INVALID != this.Kkc) {
                        this.KlD = true;
                        if (this.FQS != null && this.FQS.isShowing()) {
                            if (k.MODE_CANCEL == this.Kkc) {
                                Log.i("MicroMsg.ChatFooter", "do not send voice.");
                                this.KjZ.setExitType(2);
                                this.KiD.ehL();
                                AppMethodBeat.o(31681);
                                return;
                            }
                            Log.i("MicroMsg.ChatFooter", "trans voice to txt.");
                            this.KiD.ehJ();
                            final String fileName = this.KiD.getFileName();
                            final long aas = this.KiD.aas();
                            Log.i("transvoice", "fileName: %s, voiceLen: %d.", fileName, Long.valueOf(aas));
                            if (!NetStatusUtil.isConnected(getContext())) {
                                this.KjZ.setExitType(4);
                                d.a aVar = new d.a(getContext());
                                aVar.boo(getResources().getString(R.string.fbp));
                                aVar.bou(getResources().getString(R.string.fbr));
                                aVar.aoX(getResources().getColor(R.color.Link_100));
                                aVar.bov(getResources().getString(R.string.fbq));
                                aVar.c(new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass65 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(232272);
                                        ChatFooter.this.KiD.eu(fileName, (int) aas);
                                        AppMethodBeat.o(232272);
                                    }
                                });
                                aVar.d(new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass66 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(232273);
                                        ChatFooter.this.KiD.aDO(fileName);
                                        AppMethodBeat.o(232273);
                                    }
                                });
                                aVar.hbn().show();
                                AppMethodBeat.o(31681);
                                return;
                            } else if (this.KjX.isValid()) {
                                this.KjV.aTN(fileName);
                                this.KjV.GvG = aas;
                                this.KjV.talker = this.Kij;
                                this.KjV.show();
                                this.KjV.c(this.KjX);
                                this.Kjf = false;
                                AppMethodBeat.o(31681);
                                return;
                            } else {
                                this.KjZ.setExitType(3);
                                d.a aVar2 = new d.a(getContext());
                                aVar2.boo(getResources().getString(R.string.hz_));
                                aVar2.bou(getResources().getString(R.string.hza));
                                aVar2.aoX(getResources().getColor(R.color.Link_100));
                                aVar2.c(new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass64 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(232271);
                                        ChatFooter.this.KiD.aDO(fileName);
                                        AppMethodBeat.o(232271);
                                    }
                                });
                                aVar2.Dk(false);
                                aVar2.hbn().show();
                                AppMethodBeat.o(31681);
                                return;
                            }
                        }
                    } else {
                        this.KiD.ehI();
                        AppMethodBeat.o(31681);
                        return;
                    }
                } else if (this.tfc == null || this.tfc.getVisibility() != 0) {
                    this.KiD.ehI();
                } else {
                    this.KjZ.setExitType(2);
                    this.KiD.ehL();
                    AppMethodBeat.o(31681);
                    return;
                }
            }
            AppMethodBeat.o(31681);
        } else if (!this.KlF) {
            this.KlF = true;
            if (this.KiD != null) {
                this.KjZ.GtP = this.KiD.aas();
                if (this.Kkh != null && this.Kkh.isShowing()) {
                    if (e.MODE_CANCEL == this.KlT) {
                        this.KkT = false;
                        this.KiD.ehL();
                        this.KjZ.setExitType(2);
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEW_VOICE2TXT_NEED_GUIDE_OPERATION_BOOLEAN_SYNC, Boolean.FALSE);
                        AppMethodBeat.o(31681);
                        return;
                    } else if (e.MODE_TRANS == this.KlT) {
                        if (this.KlE <= 0) {
                            this.KlE = (int) this.KiD.aas();
                        }
                        if (!Util.isNullOrNil(this.KiD.getFileName())) {
                            a.C0295a aVar3 = com.tencent.mm.cj.a.Owq;
                            a.C0295a.blJ(this.KiD.getFileName());
                        }
                        this.KiD.ehJ();
                        grk();
                        this.GvO.sendEmptyMessageDelayed(5000, 5000);
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEW_VOICE2TXT_NEED_GUIDE_OPERATION_BOOLEAN_SYNC, Boolean.FALSE);
                        AppMethodBeat.o(31681);
                        return;
                    } else if (e.MODE_VOICE == this.KlT) {
                        this.KkT = false;
                        this.KiD.ehI();
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEW_VOICE2TXT_NEED_GUIDE_VOICE_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                }
            }
            AppMethodBeat.o(31681);
        } else {
            AppMethodBeat.o(31681);
        }
    }

    public void setUserName(String str) {
        AppMethodBeat.i(31682);
        this.Kij = str;
        if (this.rum != null) {
            this.rum.setTalkerName(this.Kij);
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.Kik != null);
        Log.i("MicroMsg.ChatFooter", "setusername: %s, %s", objArr);
        if (this.Kik != null) {
            if (com.tencent.mm.model.ab.JE(this.Kij) || com.tencent.mm.model.ab.Jv(this.Kij)) {
                this.Kik.setServiceShowFlag(0);
                AppMethodBeat.o(31682);
                return;
            } else if (com.tencent.mm.model.ab.IT(this.Kij)) {
                this.Kik.setServiceShowFlag(4);
                AppMethodBeat.o(31682);
                return;
            } else if (com.tencent.mm.model.ab.Eq(this.Kij)) {
                this.Kik.setServiceShowFlag(2);
                AppMethodBeat.o(31682);
                return;
            } else {
                this.Kik.setServiceShowFlag(1);
            }
        }
        AppMethodBeat.o(31682);
    }

    public final void a(String str, Boolean bool, CharSequence charSequence) {
        AppMethodBeat.i(232302);
        if (bool.booleanValue()) {
            a.b.d(this.KiL, str);
        } else {
            a.b.c(this.KiL, str);
        }
        setHint(charSequence);
        this.KiL.setVisibility(0);
        AppMethodBeat.o(232302);
    }

    public void setFooterStatus(boolean z) {
    }

    public final void gqS() {
        AppMethodBeat.i(31683);
        bg.aVF();
        this.Kjw = ((Boolean) com.tencent.mm.model.c.azQ().get(66832, Boolean.FALSE)).booleanValue();
        if (this.ECK != null) {
            this.ECK.setEnableSendBtn(this.Kjw);
        }
        AppMethodBeat.o(31683);
    }

    public void setCattingRootLayoutId(int i2) {
        this.KlI = null;
        this.KlH = i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.h.a
    public int getYFromBottom() {
        int height;
        AppMethodBeat.i(31684);
        if (this.KiY == 0) {
            height = getHeight() - this.Kjj;
        } else {
            height = (getHeight() - this.Kjj) + getKeyBordHeightPX();
            if (this.Kjp != null) {
                height -= this.Kjp.dYg();
            }
        }
        AppMethodBeat.o(31684);
        return height;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.h.a
    public final boolean gqT() {
        AppMethodBeat.i(232303);
        if (this.Kjy == null || this.Kjy.grq() == null) {
            AppMethodBeat.o(232303);
            return true;
        } else if (((com.tencent.mm.ui.chatting.d.b.h) this.Kjy.grq().bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu() || ((com.tencent.mm.ui.chatting.d.b.i) this.Kjy.grq().bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw()) {
            AppMethodBeat.o(232303);
            return false;
        } else {
            AppMethodBeat.o(232303);
            return true;
        }
    }

    public View getPanel() {
        return this.Kip;
    }

    public final void gqU() {
        AppMethodBeat.i(31685);
        if (this.han == null || this.han.getVisibility() == 8) {
            AppMethodBeat.o(31685);
            return;
        }
        if (this.KlJ == 0) {
            this.KlJ = this.han.getWidth();
            this.KlK = this.Kir.getWidth();
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(this.KlJ, this.KlK);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass67 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(185386);
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = ChatFooter.this.han.getLayoutParams();
                layoutParams.width = intValue;
                ChatFooter.this.han.setLayoutParams(layoutParams);
                ChatFooter.this.han.setAlpha(((float) (intValue - ChatFooter.this.KlK)) / ((float) (ChatFooter.this.KlJ - ChatFooter.this.KlK)));
                AppMethodBeat.o(185386);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass68 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(232274);
                ChatFooter.this.han.setVisibility(0);
                AppMethodBeat.o(232274);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(232275);
                if (!ChatFooter.this.gYo) {
                    ChatFooter.this.han.setVisibility(8);
                    AppMethodBeat.o(232275);
                    return;
                }
                Log.i("MicroMsg.ChatFooter", "animHideSendBtn onAnimationEnd!! cansend change:%s", Boolean.valueOf(ChatFooter.this.gYo));
                ChatFooter.this.gqV();
                AppMethodBeat.o(232275);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(232276);
                ChatFooter.this.han.setVisibility(8);
                AppMethodBeat.o(232276);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        valueAnimator.setDuration(150L);
        valueAnimator.start();
        AppMethodBeat.o(31685);
    }

    public final void gqV() {
        AppMethodBeat.i(31686);
        if (this.han == null) {
            AppMethodBeat.o(31686);
            return;
        }
        if (this.KlJ == 0) {
            this.KlJ = this.han.getWidth();
            this.KlK = this.Kir.getWidth();
        }
        if (this.KlJ == 0) {
            this.han.startAnimation(this.Kjz);
            this.han.setVisibility(0);
            AppMethodBeat.o(31686);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(this.KlK, this.KlJ);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass69 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(185810);
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = ChatFooter.this.han.getLayoutParams();
                layoutParams.width = intValue;
                ChatFooter.this.han.setLayoutParams(layoutParams);
                ChatFooter.this.han.setAlpha(((float) (intValue - ChatFooter.this.KlK)) / ((float) (ChatFooter.this.KlJ - ChatFooter.this.KlK)));
                AppMethodBeat.o(185810);
            }
        });
        valueAnimator.setDuration(150L);
        valueAnimator.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass70 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(232277);
                ChatFooter.this.han.setVisibility(0);
                AppMethodBeat.o(232277);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(232278);
                ViewGroup.LayoutParams layoutParams = ChatFooter.this.han.getLayoutParams();
                layoutParams.width = -2;
                ChatFooter.this.han.setLayoutParams(layoutParams);
                ChatFooter.this.Kir.setVisibility(8);
                ChatFooter.j(ChatFooter.this, false);
                if (!ChatFooter.this.gYo) {
                    Log.i("MicroMsg.ChatFooter", "animShowSendBtn onAnimationEnd!! cansend change:%s", Boolean.valueOf(ChatFooter.this.gYo));
                    ChatFooter.this.Kir.setVisibility(0);
                    ChatFooter.j(ChatFooter.this, true);
                    ChatFooter.this.gqU();
                }
                AppMethodBeat.o(232278);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(232279);
                ChatFooter.this.han.setVisibility(0);
                ChatFooter.this.Kir.setVisibility(8);
                ChatFooter.j(ChatFooter.this, false);
                AppMethodBeat.o(232279);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        valueAnimator.start();
        AppMethodBeat.o(31686);
    }

    static boolean beY(String str) {
        AppMethodBeat.i(163219);
        boolean z = MultiProcessMMKV.getMMKV("plus_uncertain_enter").getBoolean(str, false);
        AppMethodBeat.o(163219);
        return z;
    }

    public final void gqW() {
        AppMethodBeat.i(232304);
        if (this.Kir == null || this.Kir.getVisibility() != 0) {
            AppMethodBeat.o(232304);
            return;
        }
        Am(true);
        AppMethodBeat.o(232304);
    }

    public final void Am(boolean z) {
        boolean z2;
        AppMethodBeat.i(163220);
        if (this.Kir == null) {
            Log.e("MicroMsg.ChatFooter", "mAttachButton is null");
            AppMethodBeat.o(163220);
            return;
        }
        if (this.Kis != null) {
            if (z && getAppPanelUnCertainEnterArrayList() != null && getAppPanelUnCertainEnterArrayList().size() > 0) {
                Iterator<a.C2027a> it = getAppPanelUnCertainEnterArrayList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    a.C2027a next = it.next();
                    if (next.KhR == 1 && !beY(next.KhQ)) {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    this.Kis.setVisibility(0);
                    AppMethodBeat.o(163220);
                    return;
                }
            }
            this.Kis.setVisibility(8);
        }
        AppMethodBeat.o(163220);
    }

    public void setLbsMode(boolean z) {
        this.KiI = z;
    }

    public boolean getIsVoiceInputPanleShow() {
        return this.Kds;
    }

    private static boolean isLandscape() {
        AppMethodBeat.i(185402);
        if (MMApplicationContext.getContext().getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(185402);
            return true;
        }
        AppMethodBeat.o(185402);
        return false;
    }

    private void gqX() {
        AppMethodBeat.i(31687);
        this.KjN.setVisibility(8);
        this.KjQ.setVisibility(8);
        this.KjN.setScaleX(0.5f);
        this.KjN.setScaleY(0.5f);
        this.KjQ.setScaleX(0.5f);
        this.KjQ.setScaleY(0.5f);
        this.KjN.setTranslationX((float) this.KlL);
        this.KjN.setTranslationY((float) (-this.KlM));
        this.KjQ.setTranslationX((float) (-this.KlL));
        this.KjQ.setTranslationY((float) (-this.KlM));
        gqY();
        gqZ();
        AppMethodBeat.o(31687);
    }

    private void gqY() {
        AppMethodBeat.i(31688);
        this.KjO.setIconColor(getResources().getColor(R.color.fq));
        this.KjP.setTextColor(getResources().getColor(R.color.ad1));
        this.KjN.setBackgroundDrawable(getResources().getDrawable(R.drawable.b27));
        AppMethodBeat.o(31688);
    }

    private void gqZ() {
        AppMethodBeat.i(31689);
        this.KjR.setIconColor(getResources().getColor(R.color.fq));
        this.KjS.setTextColor(getResources().getColor(R.color.ad1));
        this.KjQ.setBackgroundDrawable(getResources().getDrawable(R.drawable.b27));
        AppMethodBeat.o(31689);
    }

    private void gra() {
        AppMethodBeat.i(31690);
        String currentLanguage = LocaleUtil.getCurrentLanguage(getContext());
        if (currentLanguage.equals(LocaleUtil.CHINA) || currentLanguage.equals(LocaleUtil.HONGKONG) || currentLanguage.equals(LocaleUtil.TAIWAN)) {
            this.KjL.setImageResource(R.raw.voice2txt_hint_trans_chs);
            this.KjR.setImageResource(R.raw.voice2txt_trans_chs_img);
            AppMethodBeat.o(31690);
            return;
        }
        if (currentLanguage.equals(LocaleUtil.ENGLISH)) {
            this.KjL.setImageResource(R.raw.voice2txt_hint_trans_eng);
            this.KjR.setImageResource(R.raw.voice2txt_trans_eng_img);
        }
        AppMethodBeat.o(31690);
    }

    private void grb() {
        AppMethodBeat.i(185403);
        int width = this.Kkk.getWidth();
        int height = this.Kkk.getHeight();
        int i2 = 0;
        int i3 = 0;
        switch (this.KlT) {
            case MODE_VOICE:
                i2 = this.Klt;
                i3 = this.GyD;
                break;
            case MODE_TRANS:
                i2 = this.Kll;
                i3 = this.Klq;
                break;
            case MODE_CANCEL:
                i2 = this.Klm;
                i3 = this.GyD;
                break;
        }
        Log.i("MicroMsg.ChatFooter", "beginWidth:%s, endWidth:%s, beginHeight:%s, endHeight:%s", Integer.valueOf(width), Integer.valueOf(i2), Integer.valueOf(height), Integer.valueOf(i3));
        ValueAnimator duration = ValueAnimator.ofInt(width, i2).setDuration(200L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass75 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(232283);
                ((ViewGroup.MarginLayoutParams) ChatFooter.this.Kkk.getLayoutParams()).width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ChatFooter.this.Kkk.requestLayout();
                AppMethodBeat.o(232283);
            }
        });
        ValueAnimator duration2 = ValueAnimator.ofInt(height, i3).setDuration(200L);
        duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass77 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(232285);
                ((ViewGroup.MarginLayoutParams) ChatFooter.this.Kkk.getLayoutParams()).height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ChatFooter.this.Kkk.requestLayout();
                AppMethodBeat.o(232285);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2);
        animatorSet.start();
        AppMethodBeat.o(185403);
    }

    private void grc() {
        float f2 = 0.0f;
        AppMethodBeat.i(185404);
        float translationX = this.Kkk.getTranslationX();
        switch (this.KlT) {
            case MODE_CANCEL:
                f2 = (float) (-((au.az(getContext()).x / 2) - at.fromDPToPix(getContext(), 76)));
                break;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(translationX, f2).setDuration(200L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass78 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(232286);
                ChatFooter.this.Kkk.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(232286);
            }
        });
        duration.start();
        AppMethodBeat.o(185404);
    }

    private void grd() {
        AppMethodBeat.i(185405);
        this.Kkk.setAlpha(0.0f);
        this.Kkk.setTranslationY((float) at.fromDPToPix(getContext(), 56));
        this.Kkn.setAlpha(0);
        this.Kkn.setTranslationY((float) at.fromDPToPix(getContext(), 56));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Kkk, "translationY", this.Kkk.getTranslationY(), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Kkk, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.Kkn, "translationY", this.Kkn.getTranslationY(), 0.0f);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.Kkn, "alpha", 0, 255);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofInt);
        animatorSet.start();
        AppMethodBeat.o(185405);
    }

    private void gre() {
        AppMethodBeat.i(185406);
        this.Kkm.setVisibility(8);
        this.Kkp.setVisibility(0);
        this.Kkp.setTextColor(getContext().getResources().getColor(R.color.fm));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Kkt.getLayoutParams();
        layoutParams.addRule(13);
        layoutParams.removeRule(21);
        layoutParams.removeRule(12);
        this.Kkp.setText(String.format(getContext().getResources().getString(R.string.fcd), Integer.valueOf(this.Klu)));
        this.Kkt.requestLayout();
        AppMethodBeat.o(185406);
    }

    private void grf() {
        AppMethodBeat.i(185407);
        this.Kkm.setVisibility(8);
        this.Kkp.setVisibility(0);
        this.Kkp.setTextColor(getContext().getResources().getColor(R.color.u_));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Kkt.getLayoutParams();
        layoutParams.removeRule(13);
        layoutParams.addRule(21);
        layoutParams.addRule(12);
        this.Kkp.setText(String.format(getContext().getResources().getString(R.string.fcd), Integer.valueOf(this.Klu)));
        this.Kkt.requestLayout();
        AppMethodBeat.o(185407);
    }

    private void grg() {
        AppMethodBeat.i(185408);
        this.Kkm.setVisibility(0);
        this.Kkp.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Kkt.getLayoutParams();
        layoutParams.removeRule(21);
        layoutParams.removeRule(12);
        layoutParams.addRule(13);
        this.Kkt.requestLayout();
        ((RelativeLayout.LayoutParams) this.Kkm.getLayoutParams()).bottomMargin = 0;
        this.Kkm.requestLayout();
        AppMethodBeat.o(185408);
    }

    private void grh() {
        AppMethodBeat.i(185409);
        this.KkM.animate().translationY(0.0f).alpha(1.0f).setDuration(100).withEndAction(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass79 */

            public final void run() {
                AppMethodBeat.i(232287);
                ChatFooter.this.KkO.setVisibility(8);
                ChatFooter.this.KkP.C(ChatFooter.this.getResources().getColor(R.color.fm), 0.5f);
                AppMethodBeat.o(232287);
            }
        }).start();
        this.KkN.animate().translationY(0.0f).alpha(1.0f).setDuration(100).start();
        this.KkO.animate().translationY(0.0f).setDuration(100).start();
        if (this.Klu < 10) {
            gre();
        } else {
            grg();
            this.Kkm.a(SoundWaveView.d.NORMAL);
        }
        this.Kku.setVisibility(0);
        this.Kks.setVisibility(8);
        this.Kkl.setVisibility(8);
        this.Kkn.setImageDrawable(com.tencent.mm.ui.ar.m(getContext(), R.raw.icons_filled_voice2txt_cursor, getContext().getResources().getColor(R.color.LightGreen)));
        this.Kkn.animate().translationX(0.0f).setDuration(150).start();
        this.Kkk.setActivated(true);
        grb();
        grc();
        AppMethodBeat.o(185409);
    }

    private void gri() {
        AppMethodBeat.i(185410);
        this.KkB.setVisibility(4);
        this.Kkz.C(getResources().getColor(R.color.am), 0.5f);
        this.Kkx.setBackgroundDrawable(getResources().getDrawable(R.drawable.amx));
        this.Kkx.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).start();
        AppMethodBeat.o(185410);
    }

    private void grj() {
        AppMethodBeat.i(185411);
        this.KkC.setVisibility(4);
        this.KkA.C(getResources().getColor(R.color.am), 0.5f);
        this.Kky.setBackgroundDrawable(getResources().getDrawable(R.drawable.amx));
        this.Kky.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
        AppMethodBeat.o(185411);
    }

    private void grk() {
        int i2;
        AppMethodBeat.i(185412);
        int fromDPToPix = at.fromDPToPix(getContext(), 20);
        if (this.Kkl.getText() == null || this.Kkl.getText().length() <= 0) {
            i2 = 0;
        } else {
            i2 = this.Kkl.getText().length();
        }
        this.Kkl.setSelection(i2);
        this.Kkl.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        this.Kkw.setVisibility(8);
        this.Kku.setVisibility(8);
        this.KkL.setVisibility(4);
        this.KkD.setVisibility(0);
        this.Kkq.setVisibility(0);
        a.C0295a aVar = com.tencent.mm.cj.a.Owq;
        com.tencent.mm.cj.a.Owp = true;
        this.Kkp.setVisibility(8);
        this.Kkm.setVisibility(8);
        AppMethodBeat.o(185412);
    }

    /* access modifiers changed from: package-private */
    public enum e {
        MODE_VOICE,
        MODE_CANCEL,
        MODE_TRANS;

        public static e valueOf(String str) {
            AppMethodBeat.i(185397);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(185397);
            return eVar;
        }

        static {
            AppMethodBeat.i(185398);
            AppMethodBeat.o(185398);
        }
    }

    public void setExitType(int i2) {
        AppMethodBeat.i(185414);
        c.a aVar = com.tencent.mm.plugin.transvoice.a.c.Guc;
        com.tencent.mm.plugin.transvoice.a.c.fAu().setExitType(i2);
        AppMethodBeat.o(185414);
    }

    public final void a(int i2, boolean z, com.tencent.mm.modelvoiceaddr.h hVar, boolean z2) {
        AppMethodBeat.i(185826);
        Log.d("MicroMsg.ChatFooter", "startTrans, hasStartTrans: %s, isForce: %s.", Boolean.valueOf(this.KlW), Boolean.valueOf(z2));
        if (z2) {
            if (this.KlW) {
                if (this.GvE != null) {
                    this.GvE.az(false, true);
                }
                this.GvO.removeMessages(5000);
                this.GvL.stopTimer();
            }
        } else if (this.KlW) {
            AppMethodBeat.o(185826);
            return;
        }
        this.KlW = true;
        this.GvE = new com.tencent.mm.plugin.transvoice.a.b(hVar, i2, new g.b() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass82 */

            @Override // com.tencent.mm.modelvoiceaddr.g.b
            public final void b(String[] strArr, List<String> list) {
                AppMethodBeat.i(232290);
                Log.d("MicroMsg.ChatFooter", "newVoice2txt onRes, %s.", ChatFooter.this.GvE);
                ChatFooter.this.GvY.clear();
                if (!Util.isNullOrNil(list)) {
                    ChatFooter.this.GvY.addAll(list);
                }
                if (!ChatFooter.this.GvM) {
                    ChatFooter.this.GvM = true;
                    ChatFooter.this.Kkl.setFocusable(true);
                    ChatFooter.this.Kkl.setFocusableInTouchMode(true);
                    ChatFooter.this.Kkl.requestFocus();
                }
                if (ChatFooter.this.GvE != null && !ChatFooter.this.GvE.GtF) {
                    ChatFooter.this.GvO.removeMessages(5000);
                    ChatFooter.this.GvO.sendEmptyMessageDelayed(5000, 5000);
                }
                if (!Util.isNullOrNil(strArr[0])) {
                    ChatFooter.this.KlV.put(Integer.valueOf(ChatFooter.this.GtE), strArr[0]);
                    if (ChatFooter.this.KlV != null) {
                        ChatFooter.this.KjZ.GtV = strArr[0].length();
                    }
                    Log.d("MicroMsg.ChatFooter", "newVoice2txt onRes, curTxt: %s.", strArr[0]);
                }
                AppMethodBeat.o(232290);
            }

            @Override // com.tencent.mm.modelvoiceaddr.g.b
            public final void c(int i2, int i3, int i4, long j2) {
                AppMethodBeat.i(232291);
                Log.d("MicroMsg.ChatFooter", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2));
                ChatFooter.this.KjZ.GtY = 0;
                ChatFooter.this.KjZ.GtU = System.currentTimeMillis();
                ChatFooter.this.KlW = false;
                AppMethodBeat.o(232291);
            }

            @Override // com.tencent.mm.modelvoiceaddr.g.b
            public final void biv() {
                AppMethodBeat.i(232292);
                Log.d("MicroMsg.ChatFooter", "onRecordFin.");
                AppMethodBeat.o(232292);
            }

            @Override // com.tencent.mm.modelvoiceaddr.g.b
            public final void biz() {
                AppMethodBeat.i(232293);
                if (ChatFooter.this.GvE != null && !ChatFooter.this.GvE.GtF) {
                    Log.d("MicroMsg.ChatFooter", "onRecognizeFinish, %s.", Boolean.valueOf(ChatFooter.this.GvE.GtF));
                    ChatFooter.this.KjZ.GtY = 1;
                    ChatFooter.this.KjZ.GtU = System.currentTimeMillis();
                    ChatFooter.this.GvM = false;
                    ChatFooter.this.KlW = false;
                    ChatFooter.this.GvE = null;
                    ChatFooter.this.GvO.removeMessages(5000);
                    ChatFooter.this.GvL.stopTimer();
                    ChatFooter.aN(ChatFooter.this);
                }
                AppMethodBeat.o(232293);
            }
        });
        this.GvE.GtF = z;
        this.GvE.start();
        this.GvL.startTimer(500);
        AppMethodBeat.o(185826);
    }

    public final boolean grl() {
        AppMethodBeat.i(185416);
        if (this.Kkh == null || !this.Kkh.isShowing()) {
            AppMethodBeat.o(185416);
            return false;
        }
        AppMethodBeat.o(185416);
        return true;
    }

    private int getTransLangTypeByTalker() {
        boolean z;
        AppMethodBeat.i(185417);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("voice2txt_sp", 0);
        int i2 = sharedPreferences.getInt(this.Kij, com.tencent.mm.modelvoiceaddr.g.jwp);
        if (this.Kkr != null) {
            Iterator<a.C1843a> it = this.Kkr.Guo.gzD.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().Gwt == i2) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                int defaultLangType = getDefaultLangType();
                if (com.tencent.mm.modelvoiceaddr.g.jwp != defaultLangType) {
                    sharedPreferences.edit().putInt(this.Kij, defaultLangType).apply();
                }
                AppMethodBeat.o(185417);
                return defaultLangType;
            }
            AppMethodBeat.o(185417);
            return i2;
        }
        int defaultLangType2 = getDefaultLangType();
        if (com.tencent.mm.modelvoiceaddr.g.jwp != defaultLangType2) {
            sharedPreferences.edit().putInt(this.Kij, defaultLangType2).apply();
        }
        AppMethodBeat.o(185417);
        return defaultLangType2;
    }

    private int getDefaultLangType() {
        AppMethodBeat.i(185418);
        int i2 = com.tencent.mm.modelvoiceaddr.g.jwp;
        String currentLanguage = LocaleUtil.getCurrentLanguage(getContext());
        if (currentLanguage.equals(LocaleUtil.CHINA) || currentLanguage.equals(LocaleUtil.HONGKONG) || currentLanguage.equals(LocaleUtil.TAIWAN)) {
            i2 = com.tencent.mm.modelvoiceaddr.g.jwq;
        } else if (currentLanguage.equals(LocaleUtil.ENGLISH)) {
            i2 = com.tencent.mm.modelvoiceaddr.g.jws;
        }
        AppMethodBeat.o(185418);
        return i2;
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.a
    public final void a(buv buv) {
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.a
    public final void gf(String str, int i2) {
        AppMethodBeat.i(232305);
        if (i2 == 2) {
            appendText("#" + str + " ");
            AppMethodBeat.o(232305);
            return;
        }
        appendText(str + " ");
        AppMethodBeat.o(232305);
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.a
    public final void onDismiss() {
        AppMethodBeat.i(232306);
        this.ECK.gYJ();
        this.Kjg = false;
        showVKB();
        KiM = null;
        AppMethodBeat.o(232306);
    }

    public final void gqm() {
        boolean z = true;
        AppMethodBeat.i(31590);
        if (e.Knc != null && getContext() != null) {
            if (this.rum != null) {
                this.rum.destroy();
            }
            this.rum = e.Knc.eZ(getContext());
            if (this.rum != null) {
                this.rum.setEntranceScene(ChatFooterPanel.KbC);
                this.rum.setVisibility(8);
                this.rum.setFooterType(this.IFI);
                if (this.Kip != null) {
                    this.Kip.addView(this.rum, -1, -1);
                }
                this.rum.setOnTextOperationListener(this.KkU);
                ChatFooterPanel chatFooterPanel = this.rum;
                if (this.ECK.getText().length() <= 0) {
                    z = false;
                }
                chatFooterPanel.setSendButtonEnable(z);
                if (this.Kjy != null) {
                    this.rum.setTalkerName(this.Kjy.getTalkerUserName());
                }
                this.rum.onResume();
                if (this.KiV) {
                    goD();
                }
                setSmileyPanelCallback(this.KbA);
            }
            AppMethodBeat.o(31590);
        } else if (getContext() == null) {
            Log.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", Util.getStack());
            this.rum = new d(MMApplicationContext.getContext());
            AppMethodBeat.o(31590);
        } else {
            this.rum = new d(getContext());
            AppMethodBeat.o(31590);
        }
    }

    public void setLastText(String str) {
        AppMethodBeat.i(31606);
        z(str, -1, true);
        AppMethodBeat.o(31606);
    }

    public final void Ak(boolean z) {
        AppMethodBeat.i(258865);
        i(0, z, -1);
        AppMethodBeat.o(258865);
    }

    static /* synthetic */ void a(ChatFooter chatFooter, boolean z) {
        AppMethodBeat.i(184936);
        chatFooter.Ah(z);
        AppMethodBeat.o(184936);
    }

    static /* synthetic */ void a(ChatFooter chatFooter, int i2, String str) {
        AppMethodBeat.i(185828);
        if (Util.isNullOrNil(chatFooter.Kjy.getTalkerUserName())) {
            Log.e("MicroMsg.ChatFooter", "doSendImage : talker is null");
            AppMethodBeat.o(185828);
        } else if (str == null || str.equals("") || !s.YS(str)) {
            Log.e("MicroMsg.ChatFooter", " doSendImage : filePath is null or empty");
            AppMethodBeat.o(185828);
        } else {
            o.e tc = o.a(o.d.jdL).tc(4);
            tc.dRL = z.aTY();
            tc.toUser = chatFooter.Kjy.getTalkerUserName();
            tc.iZt = str;
            tc.iXp = i2;
            tc.jdS = null;
            tc.dQd = 0;
            tc.iXy = "";
            tc.thumbPath = "";
            tc.jdV = true;
            tc.jdU = R.drawable.c3h;
            tc.jdR = 11;
            tc.bdQ().execute();
            AppMethodBeat.o(185828);
        }
    }

    static /* synthetic */ void m(ChatFooter chatFooter) {
        AppMethodBeat.i(185829);
        chatFooter.postDelayed(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass62 */
            final /* synthetic */ boolean Kmd = false;

            public final void run() {
                AppMethodBeat.i(185381);
                ChatFooter.h(ChatFooter.this, this.Kmd);
                AppMethodBeat.o(185381);
            }
        }, 10);
        AppMethodBeat.o(185829);
    }

    static /* synthetic */ void a(ChatFooter chatFooter, int i2) {
        AppMethodBeat.i(185830);
        com.tencent.mm.g.b.a.j jVar = chatFooter.Kjs;
        jVar.eke = Util.nowMilliSecond();
        jVar.ekg = (long) i2;
        jVar.bfK();
        chatFooter.gqh();
        AppMethodBeat.o(185830);
    }

    static /* synthetic */ boolean a(ChatFooter chatFooter, String str) {
        AppMethodBeat.i(185831);
        if (chatFooter.Kix.getTag() != null && (chatFooter.Kix.getTag() instanceof ca) && chatFooter.Kiw.isShown() && chatFooter.Kix.isShown() && !Util.isNullOrNil(str)) {
            ca caVar = (ca) chatFooter.Kix.getTag();
            ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(caVar.field_msgId);
            if ((Hb.fqJ & 4) == 4 || Hb.getType() == 10000) {
                Log.e("MicroMsg.ChatFooter", "msg is revoked!");
            } else {
                String talkerUserName = chatFooter.Kjy.getTalkerUserName();
                String filterString = Util.getFilterString(str);
                ((com.tencent.mm.plugin.msgquote.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.msgquote.a.class)).sendQuoteMsg(caVar, com.tencent.mm.pluginsdk.model.app.m.ahM(caVar.getType()), talkerUserName, com.tencent.mm.plugin.msgquote.model.a.aH(caVar), filterString, chatFooter.gK(talkerUserName, 0), chatFooter.mD(talkerUserName, filterString));
                chatFooter.gqj();
                AppMethodBeat.o(185831);
                return true;
            }
        }
        AppMethodBeat.o(185831);
        return false;
    }

    static /* synthetic */ void b(ChatFooter chatFooter, final String str) {
        AppMethodBeat.i(232307);
        if (((com.tencent.mm.plugin.websearch.api.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineC2CTag()) {
            final String str2 = chatFooter.Kjo;
            final long aWB = (long) cl.aWB();
            com.tencent.f.h.RTc.b(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(232228);
                    Matcher matcher = k.a.Krb.matcher(str);
                    while (matcher.find()) {
                        ChatFooter.this.ECK.gYG();
                        com.tencent.mm.plugin.websearch.a.b.a(com.tencent.mm.model.ab.Eq(ChatFooter.this.Kij) ? 2 : 1, ChatFooter.this.Kij, str2, 3, matcher.group(), ChatFooter.this.mSessionId, 1, aWB);
                    }
                    AppMethodBeat.o(232228);
                }
            }, "WebSearchReportLogic.TagSearchReport");
            chatFooter.Kjo = com.tencent.mm.plugin.fts.a.d.Nj(73);
        }
        AppMethodBeat.o(232307);
    }

    static /* synthetic */ void z(ChatFooter chatFooter) {
        AppMethodBeat.i(185419);
        if (chatFooter.KiR == 1) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "");
            Log.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), chatFooter.activity);
            if (a2) {
                chatFooter.setMode(2);
                AppMethodBeat.o(185419);
                return;
            }
        } else {
            chatFooter.setMode(1);
            if (chatFooter.KiD != null) {
                chatFooter.KiD.qY(true);
                chatFooter.KiD.X(null);
            }
        }
        AppMethodBeat.o(185419);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void H(ChatFooter chatFooter) {
        AppMethodBeat.i(185836);
        Log.d("MicroMsg.ChatFooter", "triggerModeChange, lastMode: %s, nowMode: %s.", chatFooter.KlU, chatFooter.KlT);
        if (chatFooter.KlU != chatFooter.KlT) {
            switch (chatFooter.KlU) {
                case MODE_VOICE:
                    chatFooter.KkM.animate().translationY((float) chatFooter.KlR).alpha(0.0f).setDuration(100).withStartAction(new Runnable() {
                        /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass81 */

                        public final void run() {
                            AppMethodBeat.i(232289);
                            ChatFooter.this.KkO.setVisibility(0);
                            AppMethodBeat.o(232289);
                        }
                    }).withEndAction(new Runnable() {
                        /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass80 */

                        public final void run() {
                            AppMethodBeat.i(232288);
                            ChatFooter.this.KkP.C(ChatFooter.this.getResources().getColor(R.color.am), 0.5f);
                            AppMethodBeat.o(232288);
                        }
                    }).start();
                    chatFooter.KkN.animate().translationY((float) chatFooter.KlR).alpha(0.0f).setDuration(100).start();
                    chatFooter.KkO.animate().translationY((float) chatFooter.KlR).setDuration(100).start();
                    break;
                case MODE_TRANS:
                    chatFooter.grj();
                    break;
                case MODE_CANCEL:
                    chatFooter.gri();
                    break;
            }
            switch (chatFooter.KlT) {
                case MODE_VOICE:
                    chatFooter.grh();
                    AppMethodBeat.o(185836);
                    return;
                case MODE_TRANS:
                    chatFooter.KjZ.GtR = chatFooter.GtE;
                    chatFooter.a(chatFooter.GtE, true, chatFooter.KjX, false);
                    chatFooter.KkC.setVisibility(0);
                    chatFooter.KkA.C(chatFooter.getResources().getColor(R.color.fm), 0.9f);
                    chatFooter.Kky.setBackgroundDrawable(chatFooter.getResources().getDrawable(R.drawable.amt));
                    chatFooter.Kky.animate().scaleX(1.2f).scaleY(1.2f).setDuration(150).start();
                    chatFooter.Kku.setVisibility(8);
                    chatFooter.Kks.setVisibility(8);
                    chatFooter.Kkl.setVisibility(0);
                    chatFooter.Kkn.setImageDrawable(com.tencent.mm.ui.ar.m(chatFooter.getContext(), R.raw.icons_filled_voice2txt_cursor, chatFooter.getContext().getResources().getColor(R.color.LightGreen)));
                    chatFooter.Kkn.animate().translationX((((float) au.az(chatFooter.getContext()).x) / 2.0f) - ((float) at.fromDPToPix(chatFooter.getContext(), 75))).setDuration(150).start();
                    chatFooter.Kkk.setActivated(true);
                    if (chatFooter.Klu < 10) {
                        chatFooter.grf();
                    } else {
                        chatFooter.Kkm.setVisibility(0);
                        chatFooter.Kkp.setVisibility(8);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) chatFooter.Kkt.getLayoutParams();
                        layoutParams.addRule(21);
                        layoutParams.addRule(12);
                        layoutParams.removeRule(13);
                        chatFooter.Kkt.requestLayout();
                        ((RelativeLayout.LayoutParams) chatFooter.Kkm.getLayoutParams()).bottomMargin = at.fromDPToPix(chatFooter.getContext(), 8);
                        chatFooter.Kkm.requestLayout();
                        chatFooter.Kkm.a(SoundWaveView.d.MINI);
                    }
                    chatFooter.grb();
                    chatFooter.grc();
                    AppMethodBeat.o(185836);
                    return;
                case MODE_CANCEL:
                    chatFooter.KkB.setVisibility(0);
                    chatFooter.Kkz.C(chatFooter.getResources().getColor(R.color.fm), 0.9f);
                    chatFooter.Kkx.setBackgroundDrawable(chatFooter.getResources().getDrawable(R.drawable.amt));
                    chatFooter.Kkx.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).start();
                    chatFooter.grg();
                    chatFooter.Kku.setVisibility(8);
                    chatFooter.Kkm.a(SoundWaveView.d.MINI);
                    chatFooter.Kks.setVisibility(8);
                    chatFooter.Kkp.setVisibility(8);
                    chatFooter.Kkl.setVisibility(8);
                    chatFooter.Kkn.setImageDrawable(com.tencent.mm.ui.ar.m(chatFooter.getContext(), R.raw.icons_filled_voice2txt_cursor, chatFooter.getContext().getResources().getColor(R.color.Red)));
                    chatFooter.Kkn.animate().translationX(-((((float) au.az(chatFooter.getContext()).x) / 2.0f) - ((float) at.fromDPToPix(chatFooter.getContext(), 75)))).setDuration(150).start();
                    chatFooter.Kkk.setActivated(false);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) chatFooter.Kkt.getLayoutParams();
                    layoutParams2.removeRule(21);
                    layoutParams2.removeRule(12);
                    layoutParams2.addRule(13);
                    chatFooter.Kkt.requestLayout();
                    chatFooter.grb();
                    chatFooter.grc();
                    break;
            }
        }
        AppMethodBeat.o(185836);
    }

    static /* synthetic */ void K(ChatFooter chatFooter) {
        AppMethodBeat.i(232308);
        Log.d("MicroMsg.ChatFooter", "newVoice2txt, dismissThenResetNewVoice2txt.");
        if (chatFooter.Kkh != null && chatFooter.Kkh.isShowing()) {
            if (chatFooter.xfU) {
                chatFooter.KiQ.hideSoftInputFromWindow(chatFooter.Kkl.getWindowToken(), 0);
            }
            chatFooter.Kkh.dismiss();
        }
        AppMethodBeat.o(232308);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r2.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.ENGLISH) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        if (1 != com.tencent.mm.n.h.aqJ().getInt("NewVoiceInputOpenSwitch", 0)) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void N(com.tencent.mm.pluginsdk.ui.chat.ChatFooter r5) {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.chat.ChatFooter.N(com.tencent.mm.pluginsdk.ui.chat.ChatFooter):void");
    }

    static /* synthetic */ boolean O(ChatFooter chatFooter) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(232309);
        if (!chatFooter.KkZ) {
            b.a aVar = com.tencent.mm.plugin.transvoice.b.Gtz;
            if (-1 != com.tencent.mm.plugin.transvoice.b.Gty) {
                z2 = 1 == com.tencent.mm.plugin.transvoice.b.Gty;
            } else {
                String str = Build.MODEL;
                kotlin.g.b.p.g(str, "Build.MODEL");
                if (str == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(232309);
                    throw tVar;
                }
                String lowerCase = str.toLowerCase();
                kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
                Log.d("MicroMsg.TransVoiceUtils", "pennqin, model: %s.", lowerCase);
                String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_blur_black_list, "");
                if (!Util.isNullOrNil(a2)) {
                    kotlin.g.b.p.g(a2, "disableDeviceInfo");
                    if (n.a((CharSequence) a2, (CharSequence) lowerCase, false)) {
                        Log.i("MicroMsg.TransVoiceUtils", "model %s is hit, expt: %s.", lowerCase, a2);
                        z2 = false;
                    }
                }
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    z2 = true;
                } else {
                    if (1 == com.tencent.mm.n.h.aqJ().getInt("AndroidTransVoice2TxtBlurSwitch", 1)) {
                        z2 = true;
                    }
                    z2 = false;
                }
            }
            if (z2) {
                z = true;
                if (!z && j.MODE_BLUR != chatFooter.Kkb) {
                    chatFooter.Kkb = j.MODE_BLUR;
                    AppMethodBeat.o(232309);
                    return true;
                } else if (!z || j.MODE_NORMAL == chatFooter.Kkb) {
                    AppMethodBeat.o(232309);
                    return false;
                } else {
                    chatFooter.Kkb = j.MODE_NORMAL;
                    AppMethodBeat.o(232309);
                    return true;
                }
            }
        }
        z = false;
        if (!z) {
        }
        if (!z) {
        }
        AppMethodBeat.o(232309);
        return false;
    }

    static /* synthetic */ void am(ChatFooter chatFooter) {
        AppMethodBeat.i(232310);
        chatFooter.KjR.setIconColor(chatFooter.getResources().getColor(R.color.am));
        chatFooter.KjS.setTextColor(chatFooter.getResources().getColor(R.color.ag2));
        chatFooter.KjQ.setBackgroundDrawable(chatFooter.getResources().getDrawable(R.drawable.b28));
        chatFooter.KjQ.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).start();
        AppMethodBeat.o(232310);
    }

    static /* synthetic */ void an(ChatFooter chatFooter) {
        AppMethodBeat.i(232311);
        chatFooter.KjO.setIconColor(chatFooter.getResources().getColor(R.color.fq));
        chatFooter.KjP.setTextColor(chatFooter.getResources().getColor(R.color.ad1));
        chatFooter.KjN.setBackgroundDrawable(chatFooter.getResources().getDrawable(R.drawable.b27));
        chatFooter.KjN.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
        AppMethodBeat.o(232311);
    }

    static /* synthetic */ void ao(ChatFooter chatFooter) {
        AppMethodBeat.i(232312);
        chatFooter.KjO.setIconColor(chatFooter.getResources().getColor(R.color.am));
        chatFooter.KjP.setTextColor(chatFooter.getResources().getColor(R.color.ag2));
        chatFooter.KjN.setBackgroundDrawable(chatFooter.getResources().getDrawable(R.drawable.b25));
        chatFooter.KjN.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).start();
        AppMethodBeat.o(232312);
    }

    static /* synthetic */ void ap(ChatFooter chatFooter) {
        AppMethodBeat.i(185425);
        chatFooter.KjR.setIconColor(chatFooter.getResources().getColor(R.color.fq));
        chatFooter.KjS.setTextColor(chatFooter.getResources().getColor(R.color.ad1));
        chatFooter.KjQ.setBackgroundDrawable(chatFooter.getResources().getDrawable(R.drawable.b27));
        chatFooter.KjQ.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
        AppMethodBeat.o(185425);
    }

    static /* synthetic */ void ax(ChatFooter chatFooter) {
        AppMethodBeat.i(232315);
        if (com.tencent.mm.q.a.cC(chatFooter.getContext()) || com.tencent.mm.q.a.cA(chatFooter.getContext()) || com.tencent.mm.q.a.cE(chatFooter.getContext())) {
            Log.d("MicroMsg.ChatFooter", "voip is running, cann't record voice");
            AppMethodBeat.o(232315);
            return;
        }
        chatFooter.KiR = 1;
        chatFooter.Kim.setVisibility(8);
        chatFooter.aiw(R.drawable.oi);
        com.tencent.mm.emoji.c.b bVar = com.tencent.mm.emoji.c.b.hcd;
        com.tencent.mm.emoji.c.b.awb();
        chatFooter.i(3, false, -1);
        chatFooter.Ah(false);
        int keyBordHeightPX = chatFooter.getKeyBordHeightPX() + chatFooter.Kio.getHeight();
        if (chatFooter.Kdp == null) {
            chatFooter.Kdp = new n(chatFooter.getContext(), false, null);
            chatFooter.addView(chatFooter.Kdp, new ViewGroup.LayoutParams(-1, keyBordHeightPX));
            chatFooter.Kdp.setCallback(new n.a() {
                /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass27 */

                @Override // com.tencent.mm.pluginsdk.ui.chat.n.a
                public final void gpc() {
                    AppMethodBeat.i(232247);
                    ChatFooter.ay(ChatFooter.this);
                    AppMethodBeat.o(232247);
                }

                @Override // com.tencent.mm.pluginsdk.ui.chat.n.a
                public final void bez(String str) {
                    AppMethodBeat.i(232248);
                    if (ChatFooter.this.KiD != null) {
                        ChatFooter.this.KiD.aDN(str);
                    } else {
                        Log.e("MicroMsg.ChatFooter", "onSendMsg listener is null !!!");
                    }
                    ChatFooter.this.Kdp.reset();
                    AppMethodBeat.o(232248);
                }

                @Override // com.tencent.mm.pluginsdk.ui.chat.n.a
                public final void zQ(boolean z) {
                    AppMethodBeat.i(232249);
                    if (z) {
                        if (ChatFooter.this.Kju != null) {
                            Log.d("MicroMsg.ChatFooter", "onVoiceStart start");
                            ChatFooter.this.Kju.q(Boolean.TRUE);
                            AppMethodBeat.o(232249);
                            return;
                        }
                    } else if (ChatFooter.this.Kju != null) {
                        Log.d("MicroMsg.ChatFooter", "onVoiceStart end");
                        ChatFooter.this.Kju.q(Boolean.FALSE);
                    }
                    AppMethodBeat.o(232249);
                }
            });
        }
        ViewGroup.LayoutParams layoutParams = chatFooter.Kdp.getLayoutParams();
        if (!(layoutParams == null || layoutParams.height == keyBordHeightPX)) {
            layoutParams.height = keyBordHeightPX;
            chatFooter.Kdp.setLayoutParams(layoutParams);
        }
        chatFooter.Kdp.grz();
        chatFooter.Kdp.setToUser(chatFooter.toUser);
        chatFooter.Kdp.setVisibility(0);
        chatFooter.Kdp.setTranslationY((float) keyBordHeightPX);
        chatFooter.Kdp.animate().cancel();
        chatFooter.Kdp.animate().translationY(0.0f).start();
        chatFooter.Kds = true;
        AppMethodBeat.o(232315);
    }

    static /* synthetic */ void aI(ChatFooter chatFooter) {
        AppMethodBeat.i(185845);
        ValueAnimator duration = ValueAnimator.ofInt(chatFooter.Kkk.getHeight(), chatFooter.Klq).setDuration(200L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChatFooter.AnonymousClass73 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(232281);
                ((ViewGroup.MarginLayoutParams) ChatFooter.this.Kkk.getLayoutParams()).height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ChatFooter.this.Kkk.requestLayout();
                AppMethodBeat.o(232281);
            }
        });
        duration.start();
        AppMethodBeat.o(185845);
    }

    static /* synthetic */ void aK(ChatFooter chatFooter) {
        AppMethodBeat.i(232317);
        chatFooter.KkT = true;
        chatFooter.KlT = e.MODE_VOICE;
        chatFooter.KlU = chatFooter.KlT;
        chatFooter.KlV.clear();
        chatFooter.GvY.clear();
        chatFooter.KlW = false;
        if (chatFooter.GvE != null) {
            chatFooter.GvE.az(false, true);
        }
        chatFooter.GvE = null;
        chatFooter.Klq = chatFooter.Klk;
        chatFooter.Klt = at.fromDPToPix(chatFooter.getContext(), TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        chatFooter.Klu = 60;
        chatFooter.grh();
        chatFooter.gri();
        chatFooter.grj();
        chatFooter.KkD.setVisibility(8);
        chatFooter.KkJ.setVisibility(0);
        chatFooter.KkK.setVisibility(8);
        chatFooter.Kkw.setVisibility(0);
        chatFooter.KkL.setVisibility(0);
        chatFooter.Kkr.fAy();
        chatFooter.Kkw.setVisibility(0);
        chatFooter.KkD.setVisibility(8);
        chatFooter.Kkl.setText("");
        chatFooter.Kkl.removeTextChangedListener(chatFooter.Klb);
        chatFooter.KkO.setVisibility(8);
        chatFooter.KlE = 0;
        chatFooter.GvM = false;
        chatFooter.Kkl.setFocusable(false);
        chatFooter.Kkl.setFocusableInTouchMode(false);
        chatFooter.Kkj.setVisibility(0);
        chatFooter.Kkr.setVisibility(8);
        chatFooter.Kki.setVisibility(8);
        chatFooter.GvL.stopTimer();
        chatFooter.GvO.removeMessages(5000);
        AppMethodBeat.o(232317);
    }

    static /* synthetic */ void e(ChatFooter chatFooter, int i2) {
        AppMethodBeat.i(232318);
        chatFooter.j(i2, true, -1);
        AppMethodBeat.o(232318);
    }

    static /* synthetic */ void aN(ChatFooter chatFooter) {
        AppMethodBeat.i(232319);
        String str = chatFooter.KlV.get(Integer.valueOf(chatFooter.GtE));
        if (!Util.isNullOrNil(str)) {
            String trim = str.trim();
            String substring = trim.substring(trim.length() - 1);
            Log.d("MicroMsg.ChatFooter", "delPunctuation, msg = %s, msg.length() = %s, punctuation = %s.", Util.secPrint(trim), Integer.valueOf(trim.length()), substring);
            if (substring.equals("。") || substring.equals(".")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            chatFooter.Kkl.setText(trim);
            chatFooter.KkI.setEnabled(true);
            chatFooter.KkK.setVisibility(0);
            chatFooter.KkK.setImageDrawable(com.tencent.mm.ui.ar.m(chatFooter.getContext(), R.raw.icons_filled_done, chatFooter.getContext().getResources().getColor(R.color.Brand)));
            chatFooter.KkJ.setVisibility(8);
            chatFooter.Kkl.setSelection(trim.length());
            AppMethodBeat.o(232319);
        } else if (NetStatusUtil.isConnected(chatFooter.getContext())) {
            chatFooter.KjZ.setExitType(3);
            chatFooter.Kkq.setVisibility(8);
            chatFooter.KkI.setEnabled(false);
            chatFooter.Kkl.setText("");
            Drawable m = com.tencent.mm.ui.ar.m(chatFooter.getContext(), R.raw.icons_filled_error, -1);
            int fromDPToPix = at.fromDPToPix(chatFooter.getContext(), 24);
            m.setBounds(0, 0, fromDPToPix, fromDPToPix);
            chatFooter.Kks.setCompoundDrawables(m, null, null, null);
            chatFooter.Kks.setText(chatFooter.getContext().getResources().getString(R.string.fcf));
            chatFooter.Kks.setVisibility(0);
            chatFooter.Kkk.setActivated(false);
            chatFooter.Kkn.setImageDrawable(com.tencent.mm.ui.ar.m(chatFooter.getContext(), R.raw.icons_filled_voice2txt_cursor, chatFooter.getContext().getResources().getColor(R.color.Red)));
            chatFooter.KkK.setVisibility(0);
            chatFooter.KkK.setImageResource(R.raw.icons_filled_done);
            chatFooter.KkK.setIconColor(chatFooter.getContext().getResources().getColor(R.color.BW_100_Alpha_0_1));
            chatFooter.KkJ.setVisibility(8);
            chatFooter.Kkm.setVisibility(8);
            chatFooter.Kkl.setVisibility(8);
            AppMethodBeat.o(232319);
        } else {
            chatFooter.KjZ.setExitType(3);
            chatFooter.Kkq.setVisibility(8);
            chatFooter.KkI.setEnabled(false);
            chatFooter.Kkl.setText("");
            chatFooter.Kks.setCompoundDrawables(null, null, null, null);
            chatFooter.Kks.setText(chatFooter.getContext().getResources().getString(R.string.fce));
            chatFooter.Kks.setVisibility(0);
            chatFooter.Kkk.setActivated(false);
            chatFooter.Kkn.setImageDrawable(com.tencent.mm.ui.ar.m(chatFooter.getContext(), R.raw.icons_filled_voice2txt_cursor, chatFooter.getContext().getResources().getColor(R.color.Red)));
            chatFooter.KkK.setVisibility(0);
            chatFooter.KkK.setImageResource(R.raw.icons_filled_done);
            chatFooter.KkK.setIconColor(chatFooter.getContext().getResources().getColor(R.color.BW_100_Alpha_0_1));
            chatFooter.KkJ.setVisibility(8);
            chatFooter.Kkm.setVisibility(8);
            chatFooter.Kkl.setVisibility(8);
            AppMethodBeat.o(232319);
        }
    }

    static /* synthetic */ void aR(ChatFooter chatFooter) {
        AppMethodBeat.i(232320);
        chatFooter.Klq = chatFooter.getContext().getResources().getDimensionPixelSize(R.dimen.ahb);
        chatFooter.GyD = chatFooter.getContext().getResources().getDimensionPixelSize(R.dimen.aha);
        chatFooter.maxHeight = chatFooter.Kkk.getBottom() - at.fromDPToPix(chatFooter.getContext(), 52);
        if (chatFooter.maxHeight <= chatFooter.Klk) {
            Log.i("MicroMsg.ChatFooter", "invalid maxHeight, value:%s", Integer.valueOf(chatFooter.maxHeight));
            chatFooter.maxHeight = chatFooter.Klk * 2;
        }
        Log.i("MicroMsg.ChatFooter", "transMinHeight:%s, transHeight:%s, normalHeight:%s, maxHeight:%s, cancelWidth:%s, voiceWidth:%s, transWidth:%s", Integer.valueOf(chatFooter.Klk), Integer.valueOf(chatFooter.Klq), Integer.valueOf(chatFooter.GyD), Integer.valueOf(chatFooter.maxHeight), Integer.valueOf(chatFooter.Klm), Integer.valueOf(chatFooter.Klt), Integer.valueOf(chatFooter.Kll));
        AppMethodBeat.o(232320);
    }

    static /* synthetic */ void d(ChatFooter chatFooter, String str) {
        int i2;
        AppMethodBeat.i(232321);
        if (!Util.isNullOrNil(chatFooter.GvY)) {
            Log.i("MicroMsg.ChatFooter", "cgiReport size = %s", Integer.valueOf(chatFooter.GvY.size()));
            com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100235");
            if (Fu.isValid()) {
                i2 = Util.getInt(Fu.gzz().get("MMVoipVadOn"), 0);
            } else {
                i2 = 0;
            }
            Log.i("MicroMsg.ChatFooter", "cgiReport: abTestFlag = [%s]", Integer.valueOf(i2));
            chatFooter.GvX.a(chatFooter.GvY, str, String.valueOf(i2));
            chatFooter.GvY.clear();
        }
        AppMethodBeat.o(232321);
    }

    static /* synthetic */ void bb(ChatFooter chatFooter) {
        AppMethodBeat.i(232322);
        if (chatFooter.KlT == e.MODE_TRANS) {
            Log.d("MicroMsg.ChatFooter", "updateCurTxt!!!");
            String str = chatFooter.KlV.get(Integer.valueOf(chatFooter.GtE));
            if (str == null) {
                str = "";
            }
            int i2 = 0;
            if (str.length() > 3) {
                i2 = str.length() - 3;
            }
            String str2 = str + chatFooter.GvJ;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#4D000000")), i2, str2.length(), 18);
            chatFooter.Kkl.setText(spannableString);
            chatFooter.Kkl.setSelection(spannableString.length());
        }
        AppMethodBeat.o(232322);
    }

    static /* synthetic */ void bo(ChatFooter chatFooter) {
        String talkerUserName;
        AppMethodBeat.i(232324);
        try {
            int aiu = chatFooter.Kik.aiu(13);
            if (aiu != -1 && aiu == chatFooter.Kik.getCurScreen()) {
                if (chatFooter.Kjy == null) {
                    talkerUserName = chatFooter.Kij;
                } else {
                    talkerUserName = chatFooter.Kjy.getTalkerUserName();
                }
                gy gyVar = new gy();
                gyVar.uN(talkerUserName);
                if (chatFooter.Kis.getVisibility() == 0) {
                    gyVar.eLg = 1;
                } else {
                    gyVar.eLg = 0;
                }
                gyVar.uO("19");
                gyVar.eLj = aiu + 1;
                gyVar.bfK();
            }
            AppMethodBeat.o(232324);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChatFooter", "handleExposureReport Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(232324);
        }
    }

    static /* synthetic */ void bu(ChatFooter chatFooter) {
        AppMethodBeat.i(232329);
        chatFooter.KlC.removeMessages(4097);
        chatFooter.KlC.sendEmptyMessageDelayed(4097, 1);
        AppMethodBeat.o(232329);
    }
}
