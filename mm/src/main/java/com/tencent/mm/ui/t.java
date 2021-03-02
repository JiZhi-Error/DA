package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.LayoutListenerView;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class t {
    public static long OGB;
    private static byte[] OGD = {0};
    private static boolean OGi = false;
    private static final int OGz = R.layout.bl;
    private static PowerManager.WakeLock wakeLock = null;
    private final long EKO = 300;
    private long EKP = SystemClock.elapsedRealtime();
    public View GDE;
    private int IUs = 0;
    private View OFP;
    private View OFQ;
    private TextView OFR;
    private FrameLayout OFS;
    public boolean OFT = true;
    private String OFU = " ";
    private int OFV = 0;
    private int OFW = 0;
    private com.tencent.mm.ui.widget.a OFX = null;
    private com.tencent.mm.ui.widget.a OFY = null;
    private com.tencent.mm.ui.widget.a OFZ = null;
    private int OGA = -1;
    int OGC = 0;
    private a OGE;
    private MenuItem OGF;
    private Runnable OGH = new Runnable() {
        /* class com.tencent.mm.ui.t.AnonymousClass7 */

        public final void run() {
            AppMethodBeat.i(205112);
            t.this.OGe.getWindow().setFlags(1024, 1024);
            if (t.this.mActionBar != null) {
                t.this.mActionBar.hide();
            }
            AppMethodBeat.o(205112);
        }
    };
    private Runnable OGI = new Runnable() {
        /* class com.tencent.mm.ui.t.AnonymousClass8 */

        public final void run() {
            AppMethodBeat.i(205113);
            if (t.this.mActionBar != null) {
                t.this.mActionBar.show();
            }
            AppMethodBeat.o(205113);
        }
    };
    private com.tencent.mm.ui.widget.a OGa = null;
    private com.tencent.mm.ui.widget.a OGb = null;
    boolean OGc = false;
    private boolean OGd = false;
    public AppCompatActivity OGe;
    boolean OGf = false;
    private boolean OGg;
    private a OGh = new a();
    public TextView OGj;
    View OGk;
    WeImageView OGl;
    ProgressBar OGm;
    int OGn = 0;
    private ImageView OGo;
    private ViewGroup.LayoutParams OGp;
    View OGq;
    AlbumChooserView OGr;
    private View OGs;
    public boolean OGt = true;
    private int OGu = 0;
    private boolean OGv = false;
    private IListener OGx = new IListener<yg>() {
        /* class com.tencent.mm.ui.t.AnonymousClass1 */

        {
            AppMethodBeat.i(161104);
            this.__eventId = yg.class.getName().hashCode();
            AppMethodBeat.o(161104);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yg ygVar) {
            AppMethodBeat.i(141329);
            yg.a aVar = ygVar.eeB;
            if (aVar.dDH == 2) {
                String str = aVar.dDJ;
                int i2 = aVar.position;
                Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position[%d] noticeId[%s]", Integer.valueOf(i2), str);
                if (i2 <= 0 || i2 == t.this.OGu) {
                    t.this.a((t) aVar.dDI, (int) aVar.visible, (boolean) aVar.url, aVar.desc, str, (String) i2, false);
                } else {
                    Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position not match[%d, %d] ignore display", Integer.valueOf(i2), Integer.valueOf(t.this.OGu));
                }
            }
            AppMethodBeat.o(141329);
            return false;
        }
    };
    int OGy = R.layout.bi;
    View OxH;
    WeImageView OxJ;
    TextView OxL;
    private boolean OxS = false;
    int OxT;
    private int OxU;
    LinkedList<a> OxV = new LinkedList<>();
    private View actionbarView;
    int bIs = this.OxT;
    String className;
    View contentView;
    private boolean crv = false;
    private s gzP;
    private AudioManager jus;
    private LayoutInflater kgB;
    protected boolean landscapeMode = false;
    public ActionBar mActionBar;
    Context mContext;
    ArrayList<Dialog> ogl;
    TextView orb;
    private Button sUc;
    public int statusBarColor = -1;
    protected MMHandler wMu = new MMHandler(Looper.getMainLooper());
    private boolean zSX = false;

    public static final class a {
        public int OGQ = 0;
        public Drawable OGR;
        public b OGS = b.NORMAL;
        public int Oye = -1;
        public int Oyf;
        public View Oyg;
        public View Oyh;
        public boolean eho = false;
        public boolean enable = true;
        public MenuItem.OnMenuItemClickListener kjh;
        public String text;
        public int textColor;
        public View.OnLongClickListener tib;
        public View.OnTouchListener uwC;
        public boolean visible = true;
    }

    /* access modifiers changed from: protected */
    public abstract void dealContentView(View view);

    /* access modifiers changed from: protected */
    public abstract boolean fromFullScreenActivity();

    /* access modifiers changed from: protected */
    public abstract String getClassName();

    /* access modifiers changed from: protected */
    public abstract String getIdentString();

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public abstract View getLayoutView();

    /* access modifiers changed from: protected */
    public abstract void onCreateBeforeSetContentView();

    public abstract void onKeyboardStateChanged();

    public enum b {
        NORMAL,
        GREEN,
        RED,
        BLACK,
        TRANSPARENT,
        TRANSPARENT_RED_TEXT,
        TRANSPARENT_GREEN_TEXT,
        GOLDEN,
        TRANSPARENT_GOLD_TEXT,
        TRANSPARENT_GB_GREEN_TEXT,
        TRANSPARENT_BG_BLACK_TEXT,
        YELLOW,
        ORANGE,
        DARK_GREEN_MODE,
        SMART_GALLERY_SEARCH_ENTRY,
        FEED_FOLLOW,
        FEED_UNFOLLOW,
        FINDER_LIVE;

        public static b valueOf(String str) {
            AppMethodBeat.i(141352);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(141352);
            return bVar;
        }

        static {
            AppMethodBeat.i(141353);
            AppMethodBeat.o(141353);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(int i2, final boolean z, final String str, final String str2, final String str3, final int i3, boolean z2) {
        Log.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), str3, Integer.valueOf(i3), this.OFQ);
        if (needShowIdcError()) {
            if (!z && this.OFQ == null) {
                return;
            }
            if (this.mActionBar == null || this.mActionBar.isShowing()) {
                if (this.OFS == null) {
                    this.OFS = (FrameLayout) this.contentView.findViewById(R.id.ffv);
                }
                if (this.OFQ != null) {
                    this.OFS.removeView(this.OFQ);
                }
                if (i2 <= 0) {
                    i2 = R.layout.bap;
                }
                this.OFQ = this.kgB.inflate(i2, (ViewGroup) null);
                this.OFR = (TextView) this.OFQ.findViewById(R.id.g2n);
                this.OFQ.findViewById(R.id.g2g).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.t.AnonymousClass12 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(141341);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        ar arVar = new ar();
                        arVar.dDD.type = 1;
                        arVar.dDD.event = str3;
                        arVar.dDD.position = i3;
                        EventCenter.instance.publish(arVar);
                        t.this.OFQ.setVisibility(8);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(141341);
                    }
                });
                this.OFQ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.t.AnonymousClass16 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(141343);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (str != null) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(str));
                            Context context = t.this.mContext;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/MMActivityController$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(141343);
                    }
                });
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                if (this.OGv && Build.VERSION.SDK_INT >= 16) {
                    layoutParams.setMargins(0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.OGe, 48.0f), 0, 0);
                    Log.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.topMargin));
                }
                this.OFS.addView(this.OFQ, this.OFS.getChildCount(), layoutParams);
                if (this.OFQ == null) {
                    return;
                }
                if (z2) {
                    this.OFQ.setVisibility(z ? 0 : 8);
                    String string = this.mContext.getString(R.string.e2x);
                    if (Util.isNullOrNil(str2)) {
                        str2 = this.mContext.getString(R.string.bmz);
                    }
                    if (str != null) {
                        SpannableString spannableString = new SpannableString(str2 + string);
                        spannableString.setSpan(new ForegroundColorSpan(-10119449), str2.length(), string.length() + str2.length(), 33);
                        this.OFR.setText(spannableString);
                    } else {
                        Log.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
                        this.OFR.setText(str2);
                    }
                    this.OFQ.invalidate();
                    this.OFS.invalidate();
                    return;
                }
                this.OFQ.post(new Runnable() {
                    /* class com.tencent.mm.ui.t.AnonymousClass17 */

                    public final void run() {
                        AppMethodBeat.i(141344);
                        t.this.OFQ.setVisibility(z ? 0 : 8);
                        String string = t.this.mContext.getString(R.string.e2x);
                        String string2 = Util.isNullOrNil(str2) ? t.this.mContext.getString(R.string.bmz) : str2;
                        if (str != null) {
                            SpannableString spannableString = new SpannableString(string2 + string);
                            spannableString.setSpan(new ForegroundColorSpan(-10119449), string2.length(), string2.length() + string.length(), 33);
                            t.this.OFR.setText(spannableString);
                        } else {
                            Log.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
                            t.this.OFR.setText(string2);
                        }
                        t.this.OFQ.invalidate();
                        t.this.OFS.invalidate();
                        AppMethodBeat.o(141344);
                    }
                });
                return;
            }
            Log.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
        }
    }

    private View findViewById(int i2) {
        View findViewById = this.contentView.findViewById(i2);
        return findViewById != null ? findViewById : this.OGe.findViewById(i2);
    }

    public final void setBackGroundColorResource(int i2) {
        if (this.contentView != null) {
            if (this.OFS == null) {
                this.OFS = (FrameLayout) this.contentView.findViewById(R.id.ffv);
            }
            this.OFS.setBackgroundResource(i2);
            this.GDE.setBackgroundResource(i2);
        }
    }

    public final void bF(int i2, boolean z) {
        this.OGu = i2;
        this.OGv = z;
    }

    public static Locale initLanguage(Context context) {
        return initLanguage(context, LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context));
    }

    public static Locale initLanguage(Context context, String str) {
        if (str.equals(LocaleUtil.LANGUAGE_DEFAULT)) {
            LocaleUtil.updateApplicationResourceLocale(context, Locale.ENGLISH);
            return Locale.getDefault();
        }
        Locale transLanguageToLocale = LocaleUtil.transLanguageToLocale(str);
        LocaleUtil.updateApplicationResourceLocale(context, transLanguageToLocale);
        return transLanguageToLocale;
    }

    public ActionBar getSupportActionBar() {
        return this.OGe.getSupportActionBar();
    }

    /* access modifiers changed from: protected */
    public View provideCustomActivityContentView() {
        return null;
    }

    public final void a(Context context, AppCompatActivity appCompatActivity) {
        int dimensionPixelSize;
        this.mContext = appCompatActivity;
        this.OGe = appCompatActivity;
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = this.OGe.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.OGe.getWindow().setAttributes(attributes);
        }
        if (!noActionBar()) {
            boolean z = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
            MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).getBoolean("dark_actionbar", false);
            if (!z) {
                MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
                MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
            }
        }
        this.crv = ao.f(appCompatActivity.getResources());
        if (appCompatActivity != null) {
            if (this.crv) {
                if ((appCompatActivity instanceof MMActivity) && (bd(appCompatActivity) || ((MMActivity) appCompatActivity).transparentTheme)) {
                    appCompatActivity.setTheme(R.style.a3);
                } else if ((appCompatActivity instanceof MMActivity) && bf(appCompatActivity)) {
                    appCompatActivity.setTheme(R.style.a2);
                } else if (!(appCompatActivity instanceof MMActivity) || !be(appCompatActivity)) {
                    appCompatActivity.setTheme(R.style.a0);
                } else {
                    appCompatActivity.setTheme(R.style.a1);
                }
            } else if ((appCompatActivity instanceof MMActivity) && (((MMActivity) appCompatActivity).transparentTheme || bd(appCompatActivity))) {
                appCompatActivity.setTheme(R.style.a8);
            } else if ((appCompatActivity instanceof MMActivity) && bf(appCompatActivity)) {
                appCompatActivity.setTheme(R.style.a7);
            } else if (!(appCompatActivity instanceof MMActivity) || !be(appCompatActivity)) {
                appCompatActivity.setTheme(R.style.a5);
            } else {
                appCompatActivity.setTheme(R.style.a6);
            }
        }
        onCreateBeforeSetContentView();
        this.className = getClass().getName();
        am.dl(3, this.className);
        initLanguage(context);
        this.jus = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int layoutId = getLayoutId();
        this.kgB = LayoutInflater.from(this.mContext);
        this.contentView = provideCustomActivityContentView();
        if (this.contentView == null) {
            com.tencent.mm.kiss.a.b.aBh();
            this.contentView = com.tencent.mm.kiss.a.b.c(appCompatActivity, R.layout.b7c);
        }
        this.OFP = this.contentView.findViewById(R.id.fgg);
        this.OFS = (FrameLayout) this.contentView.findViewById(R.id.ffv);
        if (layoutId != -1) {
            this.GDE = getLayoutView();
            if (this.GDE == null) {
                this.GDE = this.kgB.inflate(getLayoutId(), (ViewGroup) null);
            } else if (this.GDE.getParent() != null) {
                ((ViewGroup) this.GDE.getParent()).removeView(this.GDE);
            }
            this.OFS.addView(this.GDE, 0);
        }
        dealContentView(this.contentView);
        if (fromFullScreenActivity()) {
            ao.p(ao.a(this.OGe.getWindow(), this.GDE), this.GDE);
            ((ViewGroup) this.GDE.getParent()).removeView(this.GDE);
            ((ViewGroup) this.OGe.getWindow().getDecorView()).addView(this.GDE, 0);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 25);
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.b8);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.b9);
            }
            this.GDE.setPadding(this.GDE.getPaddingLeft(), dimensionPixelSize + fromDPToPix + this.GDE.getPaddingTop(), this.GDE.getPaddingRight(), this.GDE.getPaddingBottom());
        }
        this.mActionBar = getSupportActionBar();
        Log.d("MicroMsg.MMActivityController", "onCreate, before.");
        bg(appCompatActivity);
        if (!noActionBar()) {
            this.OxT = at.aH(this.mContext, R.dimen.b9);
            this.OxU = at.aH(this.mContext, R.dimen.jw);
        }
        if (this.OFS != null) {
            this.OFS.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                /* class com.tencent.mm.ui.t.AnonymousClass18 */

                public final void onViewAttachedToWindow(View view) {
                }

                public final void onViewDetachedFromWindow(View view) {
                    AppMethodBeat.i(141345);
                    t.this.OFS.removeOnAttachStateChangeListener(this);
                    com.tencent.mm.kiss.a.b.aBi();
                    AppMethodBeat.o(141345);
                }
            });
        }
        if (this.OFS == null || !(this.OFS instanceof LayoutListenerView)) {
            Log.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
        } else {
            ((LayoutListenerView) this.OFS).setOnResizedListener(new LayoutListenerView.c() {
                /* class com.tencent.mm.ui.t.AnonymousClass19 */
                private final int OGP = com.tencent.mm.cb.a.fromDPToPix(t.this.mContext, 100);

                {
                    AppMethodBeat.i(141346);
                    AppMethodBeat.o(141346);
                }

                @Override // com.tencent.mm.ui.LayoutListenerView.c
                public final void onSizeChanged(int i2, int i3, int i4, int i5) {
                    AppMethodBeat.i(141347);
                    if (t.f(t.this)) {
                        AppMethodBeat.o(141347);
                        return;
                    }
                    if (!(i2 == 0 || i3 == 0 || i4 == 0 || i5 == 0 || i2 != i4)) {
                        if (i3 > i5 && i3 - i5 > this.OGP) {
                            t.g(t.this);
                            AppMethodBeat.o(141347);
                            return;
                        } else if (i5 > i3 && i5 - i3 > this.OGP) {
                            t.h(t.this);
                        }
                    }
                    AppMethodBeat.o(141347);
                }
            });
        }
        ar arVar = new ar();
        arVar.dDD.type = 2;
        arVar.dDD.position = this.OGu;
        EventCenter.instance.publish(arVar);
        if (arVar.dDE.dDH == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = arVar.dDE.dDJ;
            int i2 = arVar.dDE.position;
            Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", Integer.valueOf(i2), str, Util.getStack());
            if (i2 <= 0 || i2 == this.OGu) {
                a(arVar.dDE.dDI, arVar.dDE.visible, arVar.dDE.url, arVar.dDE.desc, str, i2, true);
            } else {
                Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", Integer.valueOf(i2), Integer.valueOf(this.OGu));
            }
            Log.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (needResetStatusBarColorOnActivityCreate() && Build.VERSION.SDK_INT >= 21) {
            if (this.IUs == 0) {
                this.IUs = gIN();
            }
            Window window = appCompatActivity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            p(appCompatActivity, this.IUs);
            gIS();
        }
    }

    private static boolean bd(Activity activity) {
        if (activity == null) {
            return false;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.a2h, typedValue, true);
        return typedValue.string != null && typedValue.string.equals(activity.getString(R.string.hrn));
    }

    private static boolean be(Activity activity) {
        if (activity == null) {
            return false;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.a2h, typedValue, true);
        return typedValue.string != null && typedValue.string.equals(activity.getString(R.string.dl5));
    }

    private static boolean bf(Activity activity) {
        if (activity == null) {
            return false;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.a2h, typedValue, true);
        return typedValue.string != null && typedValue.string.equals(activity.getString(R.string.fhw));
    }

    /* access modifiers changed from: protected */
    public boolean isActionbarCenterLayoutMode() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean needResetStatusBarColorOnActivityCreate() {
        return true;
    }

    public boolean noActionBar() {
        return false;
    }

    public final ActionBar gIM() {
        return this.mActionBar;
    }

    public final int gIN() {
        this.OxS = false;
        if (this.IUs == 0) {
            this.IUs = this.mContext.getResources().getColor(R.color.a2r);
        }
        return this.IUs;
    }

    private void bg(Activity activity) {
        if (this.mActionBar != null && !noActionBar()) {
            Log.d("MicroMsg.MMActivityController", "onCreate, after");
            if (this.IUs == 0) {
                this.IUs = gIN();
            }
            this.OxS = ar.aln(this.IUs);
            setActionbarColor(this.IUs);
            this.mActionBar.setLogo(new ColorDrawable(this.OGe.getResources().getColor(17170445)));
            this.mActionBar.gt();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.gs();
            this.mActionBar.gu();
            this.mActionBar.gr();
            if (this.OGA == -1) {
                this.mActionBar.setCustomView(aa.jQ(this.OGe).inflate(this.OGy, (ViewGroup) new LinearLayout(this.OGe), false));
            } else {
                this.mActionBar.setCustomView(aa.jQ(this.OGe).inflate(this.OGA, (ViewGroup) new LinearLayout(this.OGe), false));
            }
            this.OGj = (TextView) findViewById(16908308);
            this.orb = (TextView) findViewById(16908309);
            this.OxH = findViewById(R.id.iqp);
            this.OGm = (ProgressBar) findViewById(R.id.gl_);
            this.OGk = findViewById(R.id.eh);
            this.OGl = (WeImageView) findViewById(R.id.ei);
            this.OGk.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.t.AnonymousClass20 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(141348);
                    if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                        t.OGB = System.currentTimeMillis();
                    }
                    AppMethodBeat.o(141348);
                    return false;
                }
            });
            if (this.OGl != null) {
                this.OGl.setContentDescription(this.OGe.getString(R.string.he));
            }
            if (this.OGj != null) {
                this.OGj.setText(R.string.wx);
            }
            this.OGq = findViewById(R.id.e8);
            this.OGr = (AlbumChooserView) findViewById(R.id.dp);
            if (activity.getClass().getName() == "WebViewUI") {
                if (this.OGl != null) {
                    this.OGl.setVisibility(0);
                }
                if (this.OGk != null) {
                    this.OGk.setVisibility(0);
                }
            } else if (activity instanceof MMActivity) {
                if (this.OGl != null) {
                    this.OGl.setVisibility(0);
                }
                if (this.OGk != null) {
                    this.OGk.setVisibility(0);
                }
                if (this.OGj != null) {
                    this.OGj.setVisibility(0);
                    ao.a(this.OGj.getPaint(), 0.8f);
                }
            } else {
                if (this.OGl != null) {
                    this.OGl.setVisibility(8);
                }
                if (this.OGk != null) {
                    this.OGk.setVisibility(8);
                }
            }
            gIR();
            gIP();
        }
    }

    public final void setScreenEnable(boolean z) {
        boolean z2 = true;
        this.OFT = z;
        if (this.OFP == null && this.contentView != null) {
            this.OFP = this.contentView.findViewById(R.id.fgg);
        }
        if (this.OFP == null) {
            Log.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
            return;
        }
        this.OFP.setFocusable(!z);
        View view = this.OFP;
        if (z) {
            z2 = false;
        }
        view.setFocusableInTouchMode(z2);
        if (!z) {
            jL(this.OGe);
        } else {
            releaseWakeLock();
        }
    }

    private void jL(Context context) {
        synchronized (OGD) {
            if (wakeLock == null) {
                wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(32, "screen Lock");
            }
            if (!wakeLock.isHeld()) {
                wakeLock.acquire();
                Log.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
            } else {
                Log.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", toString());
            }
        }
    }

    private void releaseWakeLock() {
        synchronized (OGD) {
            if (wakeLock == null || !wakeLock.isHeld()) {
                Log.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", toString());
            } else {
                wakeLock.release();
                Log.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
                wakeLock = null;
            }
        }
    }

    public static boolean gIO() {
        boolean isHeld;
        synchronized (OGD) {
            isHeld = wakeLock != null ? wakeLock.isHeld() : false;
        }
        return isHeld;
    }

    /* access modifiers changed from: protected */
    public final void setBodyView(int i2) {
        if (this.OFS == null) {
            this.OFS = (FrameLayout) this.contentView.findViewById(R.id.ffv);
        }
        if (this.OFQ != null) {
            this.OFS.removeView(this.OFQ);
        }
        this.OFS.removeView(this.GDE);
        this.GDE = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(i2, (ViewGroup) null);
        this.OFS.addView(this.GDE, 0, new FrameLayout.LayoutParams(-1, -1));
        if (this.OFQ != null) {
            this.OFS.addView(this.OFQ, this.OFS.getChildCount(), new FrameLayout.LayoutParams(-1, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 47.0f)));
        }
        this.OFS.invalidate();
    }

    /* access modifiers changed from: protected */
    public int getForceOrientation() {
        return -1;
    }

    public final void onStart() {
        if (getForceOrientation() == -1) {
            this.landscapeMode = this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_landscape_mode", false);
            if (this.landscapeMode) {
                this.OGe.setRequestedOrientation(-1);
            } else {
                this.OGe.setRequestedOrientation(1);
            }
        } else {
            this.OGe.setRequestedOrientation(getForceOrientation());
        }
    }

    public final boolean getLandscapeMode() {
        return this.landscapeMode;
    }

    public final int getStreamVolume(int i2) {
        return this.jus.getStreamVolume(i2);
    }

    public final int getStreamMaxVolume(int i2) {
        return this.jus.getStreamMaxVolume(i2);
    }

    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82 || keyEvent.getAction() != 1) {
            return false;
        }
        if (this.OGE == null || !this.OGE.enable) {
            return true;
        }
        a(this.OGF, this.OGE);
        return true;
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        g.anG();
        g.anG();
        if (!this.OGg || this.gzP == null || !this.gzP.onKeyDown(i2, keyEvent)) {
            return false;
        }
        Log.d("MicroMsg.MMActivityController", "match search view on key down");
        if (this.OxS) {
            setActionbarColor(this.OGe.getResources().getColor(R.color.ko));
        } else {
            setActionbarColor(this.OGe.getResources().getColor(R.color.a2r));
        }
        return true;
    }

    public boolean needShowIdcError() {
        return true;
    }

    public final void onResume() {
        activateBroadcast(true);
        EventCenter.instance.addListener(this.OGx);
        ar arVar = new ar();
        arVar.dDD.type = 2;
        arVar.dDD.position = this.OGu;
        EventCenter.instance.publish(arVar);
        if (arVar.dDE.dDH == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = arVar.dDE.dDJ;
            int i2 = arVar.dDE.position;
            Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", Integer.valueOf(i2), str);
            if (i2 <= 0 || i2 == this.OGu) {
                a(arVar.dDE.dDI, arVar.dDE.visible, arVar.dDE.url, arVar.dDE.desc, str, i2, true);
            } else {
                Log.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", Integer.valueOf(i2), Integer.valueOf(this.OGu));
            }
            Log.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (com.tencent.mm.kernel.g.aAc() && com.tencent.mm.kernel.g.aAf().hpY && !MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)) {
            if (1.0f != com.tencent.mm.cb.a.ez(MMApplicationContext.getContext())) {
                MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
            } else if (1.0f != MMApplicationContext.getContext().getResources().getConfiguration().fontScale) {
                h.INSTANCE.a(15181, 1);
                f.a aVar = new f.a(MMApplicationContext.getContext());
                aVar.aC(this.OGe.getResources().getString(R.string.dgr)).bow(this.OGe.getResources().getString(R.string.dgo)).boA(this.OGe.getResources().getString(R.string.dgq)).boB(this.OGe.getResources().getString(R.string.dgp));
                aVar.c(new f.c() {
                    /* class com.tencent.mm.ui.t.AnonymousClass21 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(141349);
                        if (z) {
                            h.INSTANCE.a(15181, 3);
                            Intent intent = new Intent();
                            intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                            intent.addFlags(268435456);
                            Context context = MMApplicationContext.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(141349);
                            return;
                        }
                        h.INSTANCE.a(15181, 2);
                        AppMethodBeat.o(141349);
                    }
                }).show();
                MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
            }
        }
    }

    public final void addDialog(Dialog dialog) {
        if (dialog != null) {
            if (this.ogl == null) {
                this.ogl = new ArrayList<>();
            }
            this.ogl.add(dialog);
        }
    }

    public final void hideAllManagedDialogs() {
        if (this.ogl != null) {
            int size = this.ogl.size();
            for (int i2 = 0; i2 < size; i2++) {
                Dialog dialog = this.ogl.get(i2);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            this.ogl.clear();
            this.ogl = null;
        }
    }

    public final void jM(Context context) {
        EventCenter.instance.removeListener(this.OGx);
        hideAllManagedDialogs();
        AndroidContextUtil.fixInputMethodManagerLeak(context);
    }

    public final void activateBroadcast(final boolean z) {
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.ui.t.AnonymousClass22 */

            public final void run() {
                AppMethodBeat.i(205120);
                if (t.OGi || !z) {
                    aa.d(z, new Intent().putExtra("classname", t.this.getClassName() + t.this.getIdentString()));
                    AppMethodBeat.o(205120);
                    return;
                }
                aa.d(z, new Intent().putExtra("classname", t.this.getClassName()).putExtra("main_process", false));
                AppMethodBeat.o(205120);
            }
        }, "ActivateBroadcast-Thread");
    }

    public static void setMainProcess() {
        OGi = true;
    }

    public final void onPause() {
        activateBroadcast(false);
        EventCenter.instance.removeListener(this.OGx);
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        Log.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", Integer.valueOf(this.OxV.size()));
        if (this.mActionBar == null || this.OxV.size() == 0) {
            Log.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.OxV.size()));
            return false;
        }
        this.OGE = null;
        this.OGF = null;
        if (this.mActionBar.getHeight() == 0) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.mContext.getResources().getDimensionPixelSize(R.dimen.b8);
            } else {
                this.mContext.getResources().getDimensionPixelSize(R.dimen.b9);
            }
        }
        Iterator<a> it = this.OxV.iterator();
        while (it.hasNext()) {
            final a next = it.next();
            if (next.Oye == 16908332) {
                Log.v("MicroMsg.MMActivityController", "match back option menu, continue");
            } else if (next.Oye == R.id.fdi) {
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(this.OGg);
                objArr[1] = Boolean.valueOf(this.gzP == null);
                Log.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", objArr);
                if (this.OGg && this.gzP != null) {
                    this.gzP.a((FragmentActivity) this.OGe, menu);
                }
            } else {
                final MenuItem add = menu.add(0, next.Oye, 0, next.text);
                com.tencent.mm.compatible.h.a.a(add, getClass().getName());
                AnonymousClass2 r4 = new View.OnClickListener() {
                    /* class com.tencent.mm.ui.t.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(205109);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        t.this.a((t) add, (MenuItem) next);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(205109);
                    }
                };
                AnonymousClass3 r5 = new View.OnLongClickListener() {
                    /* class com.tencent.mm.ui.t.AnonymousClass3 */

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(205110);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                        boolean a2 = t.a(t.this, view, next);
                        com.tencent.mm.hellhoundlib.a.a.a(a2, this, "com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(205110);
                        return a2;
                    }
                };
                AnonymousClass4 r6 = new View.OnTouchListener() {
                    /* class com.tencent.mm.ui.t.AnonymousClass4 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(205111);
                        boolean a2 = t.a(t.this, view, motionEvent, next);
                        AppMethodBeat.o(205111);
                        return a2;
                    }
                };
                if (next.Oyf == 0 && next.OGR == null) {
                    if (next.Oyg == null) {
                        next.Oyg = View.inflate(this.mContext, R.layout.ba, null);
                    }
                    this.OxL = (TextView) next.Oyg.findViewById(R.id.d9);
                    this.OxL.setVisibility(0);
                    this.sUc = (Button) next.Oyg.findViewById(R.id.d6);
                    this.sUc.setVisibility(8);
                    this.OGs = next.Oyg.findViewById(R.id.ko);
                    this.OGs.setVisibility(8);
                    if (next.OGS == b.RED || next.OGS == b.TRANSPARENT_RED_TEXT) {
                        this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, R.color.a5f));
                        this.sUc.setVisibility(0);
                        this.sUc.setBackgroundResource(R.drawable.ctg);
                        this.OxL.setVisibility(8);
                    } else if (next.OGS == b.TRANSPARENT_GREEN_TEXT) {
                        this.sUc.setVisibility(0);
                        this.sUc.setBackgroundResource(R.drawable.kd);
                        this.sUc.setTextColor(com.tencent.mm.cb.a.m(this.OGe, R.color.ag0));
                        this.OxL.setVisibility(8);
                    } else if (next.OGS == b.GREEN) {
                        this.sUc.setVisibility(0);
                        this.sUc.setBackgroundResource(R.drawable.k8);
                        this.sUc.setTextColor(com.tencent.mm.cb.a.m(this.OGe, R.color.jq));
                        this.OxL.setVisibility(8);
                    } else {
                        if (next.OGS != b.BLACK) {
                            if (next.OGS == b.TRANSPARENT_GOLD_TEXT) {
                                this.OxL.setTextColor(this.OGe.getResources().getColor(R.color.yu));
                            } else if (next.OGS == b.GOLDEN) {
                                this.OxL.setTextColor(this.OGe.getResources().getColor(R.color.a5e));
                            } else if (next.OGS == b.YELLOW) {
                                this.sUc.setVisibility(0);
                                this.sUc.setBackgroundResource(R.drawable.kh);
                                this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, R.color.jq));
                                this.OxL.setVisibility(8);
                            } else if (b.DARK_GREEN_MODE == next.OGS) {
                                Log.i("MicroMsg.MMActivityController", "dark green mode.");
                                this.sUc.setVisibility(0);
                                this.sUc.setBackgroundResource(R.drawable.k4);
                                this.sUc.setTextColor(com.tencent.mm.cb.a.m(this.OGe, R.color.ry));
                                this.OxL.setVisibility(8);
                            } else if (next.OGS == b.ORANGE) {
                                this.sUc.setVisibility(0);
                                this.sUc.setBackgroundResource(R.drawable.ka);
                                this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, R.color.jq));
                                this.OxL.setVisibility(8);
                            } else if (b.SMART_GALLERY_SEARCH_ENTRY == next.OGS) {
                                Log.i("MicroMsg.MMActivityController", "smart gallery entry %s.", Boolean.valueOf(this.OGf));
                                this.OxL.setVisibility(8);
                                if (this.OGf) {
                                    this.OGs.setVisibility(0);
                                    this.OGs.setOnClickListener(r4);
                                } else {
                                    if (8 == this.OGs.getVisibility()) {
                                        this.OGs.setVisibility(4);
                                    } else if (this.OGs.getVisibility() == 0) {
                                        this.OGs.animate().alpha(0.0f).setDuration(200).withEndAction(new Runnable() {
                                            /* class com.tencent.mm.ui.t.AnonymousClass5 */

                                            public final void run() {
                                                AppMethodBeat.i(141333);
                                                t.this.OGs.setVisibility(4);
                                                AppMethodBeat.o(141333);
                                            }
                                        });
                                    }
                                    this.OGs.setOnClickListener(null);
                                }
                            } else if (b.FEED_FOLLOW == next.OGS) {
                                this.sUc.setVisibility(0);
                                this.sUc.setBackgroundResource(R.drawable.ka);
                                this.sUc.setTextColor(com.tencent.mm.cb.a.n(this.OGe, R.color.h7));
                                this.OxL.setVisibility(8);
                            } else if (b.FEED_UNFOLLOW == next.OGS) {
                                this.sUc.setVisibility(0);
                                this.sUc.setBackgroundResource(R.drawable.k6);
                                this.sUc.setTextColor(com.tencent.mm.cb.a.n(this.OGe, R.color.BW_0_Alpha_0_9));
                                this.OxL.setVisibility(8);
                            } else if (b.FINDER_LIVE == next.OGS) {
                                this.sUc.setVisibility(0);
                                this.sUc.setBackgroundResource(R.drawable.ctg);
                                this.sUc.setTextColor(com.tencent.mm.cb.a.n(this.OGe, R.color.BW_100_Alpha_0_8));
                                this.OxL.setVisibility(8);
                            } else if (this.OGn != 0) {
                                this.OxL.setTextColor(this.OGn);
                            } else if (this.OxS) {
                                this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, R.color.ag5));
                            }
                        }
                        this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.OGe, R.color.fu));
                    }
                    this.OxL.setText(next.text);
                    if (next.textColor != 0) {
                        this.OxL.setTextColor(next.textColor);
                    }
                    this.OxL.setOnClickListener(r4);
                    this.OxL.setOnLongClickListener(r5);
                    this.OxL.setEnabled(next.enable);
                    this.OxL.setOnTouchListener(r6);
                    this.sUc.setText(next.text);
                    this.sUc.setOnClickListener(r4);
                    this.sUc.setOnLongClickListener(r5);
                    this.sUc.setOnTouchListener(r6);
                    this.sUc.setEnabled(next.enable);
                    add.setActionView(next.Oyg);
                } else {
                    if (next.Oyh == null) {
                        next.Oyh = View.inflate(this.mContext, R.layout.ba, null);
                    }
                    ImageView imageView = (ImageView) next.Oyh.findViewById(R.id.brt);
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    this.OxJ = (WeImageView) next.Oyh.findViewById(R.id.d8);
                    this.OxJ.setVisibility(0);
                    if (next.OGR != null) {
                        this.OxJ.setImageDrawable(next.OGR);
                    } else {
                        this.OxJ.setImageResource(next.Oyf);
                    }
                    if (this.OGn != 0) {
                        WeImageView weImageView = this.OxJ;
                        int i2 = this.OGn;
                        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
                        a(weImageView, i2);
                    } else if (next.OGQ == 0) {
                        if (this.OxS) {
                            WeImageView weImageView2 = this.OxJ;
                            PorterDuff.Mode mode2 = PorterDuff.Mode.SRC_ATOP;
                            a(weImageView2, -1);
                        } else {
                            WeImageView weImageView3 = this.OxJ;
                            PorterDuff.Mode mode3 = PorterDuff.Mode.SRC_ATOP;
                            a(weImageView3, WebView.NIGHT_MODE_COLOR);
                        }
                    }
                    this.OxJ.setOnClickListener(r4);
                    this.OxJ.setEnabled(next.enable);
                    this.OxJ.setContentDescription(next.text);
                    if (next.tib != null) {
                        this.OxJ.setOnLongClickListener(r5);
                    }
                    this.OGo = (ImageView) next.Oyh.findViewById(R.id.bt8);
                    if (this.OGo != null) {
                        if (next.eho) {
                            this.OGo.setVisibility(0);
                        } else {
                            this.OGo.setVisibility(8);
                        }
                    }
                    add.setActionView(next.Oyh);
                }
                add.setEnabled(next.enable);
                add.setVisible(next.visible);
                add.setShowAsAction(2);
                if (next.Oyf == R.drawable.aii) {
                    this.OGE = next;
                    this.OGF = add;
                }
                Log.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", Integer.valueOf(next.Oye), next.text, Boolean.valueOf(next.enable), Boolean.valueOf(next.visible));
            }
        }
        gIP();
        return true;
    }

    private void gIP() {
        this.mActionBar.getCustomView().post(new Runnable() {
            /* class com.tencent.mm.ui.t.AnonymousClass6 */

            public final void run() {
                int measuredWidth;
                int i2;
                AppMethodBeat.i(141334);
                View customView = t.this.mActionBar.getCustomView();
                if (!(customView == null || customView.getMeasuredWidth() == 0)) {
                    int jn = com.tencent.mm.cb.a.jn(customView.getContext()) - customView.getMeasuredWidth();
                    if (!t.this.isActionbarCenterLayoutMode()) {
                        View findViewById = customView.findViewById(R.id.eh);
                        if (findViewById != null) {
                            jn = findViewById.getMeasuredWidth();
                            Log.i("MicroMsg.MMActivityController", "setActionTitleCenter, mActionBar SpaceCenterMode upIndicator width:%s", Integer.valueOf(findViewById.getMeasuredWidth()));
                        }
                        measuredWidth = jn;
                        if (t.this.OGq != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) t.this.OGq.getLayoutParams();
                            marginLayoutParams.leftMargin = 0;
                            t.this.OGq.setLayoutParams(marginLayoutParams);
                        }
                    } else {
                        measuredWidth = (!ao.gJK() || t.this.contentView == null) ? jn : t.this.contentView.getMeasuredWidth() - customView.getMeasuredWidth();
                    }
                    View findViewById2 = customView.findViewById(R.id.dz);
                    if (findViewById2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
                        marginLayoutParams2.leftMargin = measuredWidth;
                        if (measuredWidth != 0 || t.this.OGk == null) {
                            i2 = 0;
                        } else {
                            i2 = t.this.OGk.getMeasuredWidth();
                        }
                        findViewById2.setPadding(i2, 0, i2, 0);
                        findViewById2.setLayoutParams(marginLayoutParams2);
                    }
                }
                Log.i("MicroMsg.MMActivityController", "mActionBar center mode width:%s", Integer.valueOf(t.this.mActionBar.getCustomView().getMeasuredWidth()));
                AppMethodBeat.o(141334);
            }
        });
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        Log.d("MicroMsg.MMActivityController", "on prepare option menu");
        if (!this.OGg || this.gzP == null) {
            return true;
        }
        this.gzP.a((Activity) this.OGe, menu);
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Log.v("MicroMsg.MMActivityController", "on options item selected");
        if (!this.OFT) {
            Log.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
            return true;
        } else if (menuItem.getItemId() != this.OGh.Oye || !this.OGh.enable) {
            Iterator<a> it = this.OxV.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (menuItem.getItemId() == next.Oye) {
                    Log.d("MicroMsg.MMActivityController", "on option menu %d click", Integer.valueOf(menuItem.getItemId()));
                    a(menuItem, next);
                    return true;
                }
            }
            return false;
        } else {
            a(menuItem, this.OGh);
            return true;
        }
    }

    public final boolean callBackMenu() {
        if (this.OGh == null || !this.OGh.enable) {
            return false;
        }
        a((MenuItem) null, this.OGh);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(MenuItem menuItem, a aVar) {
        if (!this.OFT) {
            Log.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
        } else if (aVar.kjh != null) {
            aVar.kjh.onMenuItemClick(menuItem);
        }
    }

    public final void fullScreenNoTitleBar(boolean z) {
        if (z) {
            if (this.mActionBar != null) {
                this.mActionBar.hide();
            }
            this.wMu.removeCallbacks(this.OGI);
            this.wMu.removeCallbacks(this.OGH);
            this.wMu.postDelayed(this.OGH, 256);
            return;
        }
        this.OGe.getWindow().clearFlags(1024);
        this.wMu.removeCallbacks(this.OGH);
        this.wMu.removeCallbacks(this.OGI);
        this.wMu.postDelayed(this.OGI, 256);
    }

    public final void fullScreenNoTitleBar(boolean z, long j2) {
        if (z) {
            if (this.mActionBar != null) {
                this.mActionBar.hide();
            }
            this.wMu.removeCallbacks(this.OGI);
            this.wMu.removeCallbacks(this.OGH);
            this.wMu.postDelayed(this.OGH, j2);
            return;
        }
        this.OGe.getWindow().clearFlags(1024);
        this.wMu.removeCallbacks(this.OGH);
        this.wMu.removeCallbacks(this.OGI);
        this.wMu.postDelayed(this.OGI, j2);
    }

    public final void fullScreenWithTitleBar(boolean z) {
        if (z) {
            this.OGe.getWindow().setFlags(1024, 1024);
        } else {
            this.OGe.getWindow().clearFlags(1024);
        }
    }

    public final void setTitleVisibility(int i2) {
        if (this.mActionBar != null) {
            if (i2 == 0) {
                this.mActionBar.show();
                p(this.OGe, this.IUs);
                return;
            }
            this.mActionBar.hide();
            p(this.OGe, this.OGe.getResources().getColor(R.color.fm));
        }
    }

    public final void setMMTitle(String str) {
        if (this.mActionBar != null) {
            this.OFU = str;
            if (com.tencent.mm.cb.a.jk(this.OGe)) {
                this.OGj.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(this.OGe, R.dimen.f3058c)) * com.tencent.mm.cb.a.ji(this.OGe));
            }
            gIQ();
            updateDescription(str);
        }
    }

    public final void setMMTitle(CharSequence charSequence) {
        if (this.mActionBar != null) {
            this.OFU = charSequence.toString();
            this.OGj.setText(charSequence);
            if (com.tencent.mm.cb.a.jk(this.OGe)) {
                this.OGj.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(this.OGe, R.dimen.f3058c)) * com.tencent.mm.cb.a.ji(this.OGe));
            }
            updateDescription(charSequence.toString());
        }
    }

    public final void setMMTitle(int i2) {
        setMMTitle(this.mContext.getString(i2));
    }

    public final void setMMSubTitle(String str) {
        if (this.mActionBar != null) {
            if (str == null) {
                this.orb.setVisibility(8);
                return;
            }
            this.orb.setText(str);
            if (com.tencent.mm.cb.a.jk(this.OGe)) {
                this.orb.setTextSize(1, 14.0f);
                this.OGj.setTextSize(1, 18.0f);
            }
            this.orb.setVisibility(0);
            updateDescription(str);
        }
    }

    public final void setMMSubTitle(int i2) {
        if (this.mActionBar != null) {
            this.orb.setText(this.mContext.getString(i2));
            if (com.tencent.mm.cb.a.jk(this.OGe)) {
                this.orb.setTextSize(1, 14.0f);
                this.OGj.setTextSize(1, 18.0f);
            }
            this.orb.setVisibility(0);
            updateDescription(this.mContext.getString(i2));
        }
    }

    public final void setMMSingleTitle(String str, Animation animation) {
        if (this.mActionBar != null) {
            this.mActionBar.setCustomView(OGz);
            TextView textView = (TextView) this.mActionBar.getCustomView().findViewById(R.id.cd);
            if (textView != null) {
                textView.clearAnimation();
                if (animation != null) {
                    textView.startAnimation(animation);
                }
                if (!Util.isNullOrNil(str)) {
                    textView.setText(str);
                }
            }
        }
    }

    public final void setMMNormalView() {
        if (this.mContext != null) {
            bg(this.OGe);
        }
    }

    public final void setTitleLogo(int i2, int i3) {
        if (this.mActionBar != null) {
            if (i2 == 0) {
                this.OFV = 0;
                this.OFX = null;
            } else if (this.OFV != i2) {
                this.OFV = i2;
                this.OFX = kO(this.mContext.getResources().getDimensionPixelSize(R.dimen.l), this.OFV);
            }
            if (i3 == 0) {
                this.OFW = 0;
                this.OFY = null;
            } else if (this.OFW != i3) {
                this.OFW = i3;
                this.OFY = kO(this.mContext.getResources().getDimensionPixelSize(R.dimen.l), this.OFW);
            }
            gIQ();
        }
    }

    private com.tencent.mm.ui.widget.a kO(int i2, int i3) {
        Drawable drawable = this.mContext.getResources().getDrawable(i3);
        if (this.OxS) {
            drawable = ar.m(this.OGe, i3, -1);
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
        aVar.QBM = (drawable.getIntrinsicHeight() - i2) / 2;
        return aVar;
    }

    private com.tencent.mm.ui.widget.a a(int i2, Drawable drawable) {
        if (this.OxS) {
            drawable = ar.e(drawable, -1);
        }
        drawable.setBounds(0, 0, at.aH(this.OGe, R.dimen.cb), at.aH(this.OGe, R.dimen.cb));
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
        aVar.QBM = (drawable.getIntrinsicHeight() - i2) / 2;
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final void gIQ() {
        int i2;
        int i3;
        int i4;
        int i5;
        String str = "%s";
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.f3058c);
        if (this.OFV != 0) {
            str = "# ".concat(String.valueOf(str));
        }
        if (this.OFW != 0) {
            str = str + " #";
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.zSX) {
            str = str + " #";
            i2 += 2;
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.OGd) {
            str = str + " #";
            i3 += 2;
            i4 = 1;
            i5 = i2 + 2;
        } else {
            i4 = 0;
            i5 = i2;
        }
        String format = String.format(str, this.OFU);
        Log.v("MicroMsg.MMActivityController", "span title format %s", str);
        CharSequence a2 = com.tencent.mm.ui.g.c.b.a(this.mContext, format, dimensionPixelSize);
        if (a2 instanceof SpannableString) {
            SpannableString spannableString = (SpannableString) a2;
            if (this.OFV != 0) {
                spannableString.setSpan(this.OFX, 0, 1, 33);
            }
            if (this.OFW != 0) {
                int length = spannableString.length() - i5;
                spannableString.setSpan(this.OFY, length, length + 1, 33);
            }
            if (this.zSX) {
                if (this.OFZ == null) {
                    this.OFZ = a(dimensionPixelSize, ar.m(this.OGe, R.raw.icons_outlined_bellring_off, this.OGe.getResources().getColor(R.color.en)));
                }
                int length2 = spannableString.length() - i3;
                spannableString.setSpan(this.OFZ, length2, length2 + 1, 33);
            }
            if (this.OGd) {
                if (this.OGb == null) {
                    this.OGb = kO(dimensionPixelSize, R.raw.chat_phone_notify_title_icon);
                }
                int length3 = spannableString.length() - i4;
                spannableString.setSpan(this.OGb, length3, length3 + 1, 33);
            }
        }
        this.OGj.setText(a2);
    }

    public final void showHomeBtn(boolean z) {
        if (this.mActionBar != null) {
            this.mActionBar.setDisplayHomeAsUpEnabled(z);
            if (this.OGk != null) {
                this.OGk.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void supportInvalidateOptionsMenu() {
        this.OGe.supportInvalidateOptionsMenu();
    }

    public boolean interceptSupportInvalidateOptionsMenu() {
        return false;
    }

    public final void enableBackMenu(boolean z) {
        if (this.OGh != null && this.OGh.enable != z) {
            this.OGh.enable = z;
            supportInvalidateOptionsMenu();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(boolean z, int i2, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (z) {
            Iterator<a> it = this.OxV.iterator();
            z3 = false;
            while (it.hasNext()) {
                a next = it.next();
                if (next.enable != z2) {
                    next.enable = z2;
                    z6 = true;
                } else {
                    z6 = z3;
                }
                z3 = z6;
            }
        } else {
            Iterator<a> it2 = this.OxV.iterator();
            z3 = false;
            while (it2.hasNext()) {
                a next2 = it2.next();
                if (next2.Oye != i2 || next2.enable == z2) {
                    z5 = z3;
                } else {
                    next2.enable = z2;
                    z5 = true;
                }
                z3 = z5;
            }
        }
        if (this.gzP == null) {
            z4 = false;
        } else {
            z4 = this.gzP.Qwd;
        }
        if (!z4) {
            supportInvalidateOptionsMenu();
        }
        Log.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", Integer.valueOf(i2), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    /* access modifiers changed from: package-private */
    public final void d(boolean z, int i2, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (z) {
            Iterator<a> it = this.OxV.iterator();
            z3 = false;
            while (it.hasNext()) {
                a next = it.next();
                if (next.visible != z2) {
                    next.visible = z2;
                    z6 = true;
                } else {
                    z6 = z3;
                }
                z3 = z6;
            }
        } else {
            Iterator<a> it2 = this.OxV.iterator();
            z3 = false;
            while (it2.hasNext()) {
                a next2 = it2.next();
                if (next2.Oye != i2 || next2.visible == z2) {
                    z5 = z3;
                } else {
                    next2.visible = z2;
                    z5 = true;
                }
                z3 = z5;
            }
        }
        if (this.gzP == null) {
            z4 = false;
        } else {
            z4 = this.gzP.Qwd;
        }
        if (z3 && !z4) {
            supportInvalidateOptionsMenu();
        }
        Log.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", Integer.valueOf(i2), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    public final void addSearchMenu(boolean z, s sVar) {
        Log.v("MicroMsg.MMActivityController", "add search menu");
        a aVar = new a();
        aVar.Oye = R.id.fdi;
        aVar.text = this.mContext.getString(R.string.yn);
        aVar.Oyf = R.raw.actionbar_icon_dark_search;
        aVar.kjh = null;
        aVar.tib = null;
        removeOptionMenu(aVar.Oye);
        this.OxV.add(0, aVar);
        this.OGg = z;
        this.gzP = sVar;
        supportInvalidateOptionsMenu();
    }

    public final void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        a(i2, 0, str, false, onMenuItemClickListener, (View.OnLongClickListener) null, b.NORMAL);
    }

    public final void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        a(i2, 0, str, false, onMenuItemClickListener, onLongClickListener, b.NORMAL);
    }

    public final void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener, b bVar) {
        a(i2, 0, str, false, onMenuItemClickListener, onLongClickListener, bVar);
    }

    public final void addIconOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        a(i2, i3, "", false, onMenuItemClickListener, (View.OnLongClickListener) null, b.NORMAL);
    }

    public final void addIconOptionMenu(int i2, String str, Drawable drawable, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        a(i2, drawable, str, onMenuItemClickListener, b.NORMAL);
    }

    public final void addIconOptionMenu(int i2, String str, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        a(i2, i3, str, false, onMenuItemClickListener, (View.OnLongClickListener) null, b.NORMAL);
    }

    public final void addIconOptionMenu(int i2, int i3, int i4, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        a(i2, i4, this.mContext.getString(i3), false, onMenuItemClickListener, (View.OnLongClickListener) null, b.NORMAL);
    }

    public final void addIconOptionMenu(int i2, int i3, int i4, boolean z, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        a(i2, i4, this.mContext.getString(i3), z, onMenuItemClickListener, (View.OnLongClickListener) null, b.NORMAL);
    }

    public final void addIconOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        a(i2, i3, "", false, onMenuItemClickListener, onLongClickListener, b.NORMAL);
    }

    public final void addIconOptionMenu(int i2, int i3, int i4, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        a(i2, i4, this.mContext.getString(i3), false, onMenuItemClickListener, onLongClickListener, b.NORMAL);
    }

    public final void updateOptionMenuIcon(int i2, int i3) {
        a akX = akX(i2);
        if (akX != null && akX.Oyf != i3) {
            akX.Oyf = i3;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuRedDot(int i2, boolean z) {
        a akX = akX(i2);
        if (akX != null && akX.eho != z) {
            akX.eho = z;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuText(int i2, String str) {
        a akX = akX(i2);
        if (akX != null && !Util.nullAs(str, "").equals(akX.text)) {
            akX.text = str;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuListener(int i2, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        a akX = akX(i2);
        if (akX != null) {
            akX.kjh = onMenuItemClickListener;
            akX.tib = onLongClickListener;
        }
    }

    public final void setTitleBarDoubleClickListener(final Runnable runnable) {
        if (this.mActionBar != null && runnable != null) {
            this.mActionBar.getCustomView().setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.t.AnonymousClass9 */

                public final void onClick(View view) {
                    AppMethodBeat.i(141338);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (SystemClock.elapsedRealtime() - t.this.EKP < 300) {
                        runnable.run();
                    }
                    t.this.EKP = SystemClock.elapsedRealtime();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(141338);
                }
            });
        }
    }

    public final void setBackBtn(final MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i2) {
        if (this.mActionBar != null) {
            if (onMenuItemClickListener == null) {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
            } else {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
                if (this.OGk != null) {
                    this.OGk.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.t.AnonymousClass11 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(205116);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            view.setSelected(false);
                            view.setPressed(false);
                            view.clearFocus();
                            view.invalidate();
                            view.post(new Runnable() {
                                /* class com.tencent.mm.ui.t.AnonymousClass11.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(205115);
                                    onMenuItemClickListener.onMenuItemClick(null);
                                    AppMethodBeat.o(205115);
                                }
                            });
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(205116);
                        }
                    });
                }
            }
            if (i2 == 0 && this.OGl.getDrawable() == null) {
                i2 = R.raw.actionbar_icon_dark_back;
            }
            if (!(this.OGl == null || i2 == 0)) {
                this.OGl.setImageResource(i2);
            }
            this.OGh.Oye = 16908332;
            this.OGh.kjh = onMenuItemClickListener;
        }
    }

    public final void updateBackBtn(Drawable drawable) {
        if (this.mActionBar != null && this.OGl != null && drawable != null) {
            this.OGl.setImageDrawable(drawable);
            drawable.invalidateSelf();
        }
    }

    public final void setBackBtnColorFilter(int i2) {
        if (this.OGl != null) {
            this.OGl.getDrawable().setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public final void setBackBtnVisible(boolean z) {
        if (this.OGl != null) {
            if (z) {
                this.OGl.setVisibility(0);
            } else {
                this.OGl.setVisibility(8);
            }
        }
    }

    public final void removeAllOptionMenu() {
        if (!this.OxV.isEmpty()) {
            this.OxV.clear();
            supportInvalidateOptionsMenu();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean akW(int i2) {
        for (int i3 = 0; i3 < this.OxV.size(); i3++) {
            if (this.OxV.get(i3).Oye == i2) {
                Log.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i2));
                this.OxV.remove(i3);
                return true;
            }
        }
        return false;
    }

    public final boolean removeOptionMenu(int i2) {
        for (int i3 = 0; i3 < this.OxV.size(); i3++) {
            if (this.OxV.get(i3).Oye == i2) {
                Log.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i2));
                this.OxV.remove(i3);
                supportInvalidateOptionsMenu();
                return true;
            }
        }
        return false;
    }

    public final void a(a aVar) {
        akW(aVar.Oye);
        this.OxV.add(aVar);
        supportInvalidateOptionsMenu();
    }

    private void a(int i2, Drawable drawable, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, b bVar) {
        a aVar = new a();
        aVar.Oye = i2;
        aVar.OGR = drawable;
        aVar.text = str;
        aVar.kjh = onMenuItemClickListener;
        aVar.tib = null;
        aVar.OGS = bVar;
        akW(aVar.Oye);
        this.OxV.add(aVar);
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.t.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(205117);
                t.this.supportInvalidateOptionsMenu();
                AppMethodBeat.o(205117);
            }
        }, 200);
    }

    private void a(int i2, int i3, String str, boolean z, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener, b bVar) {
        a aVar = new a();
        aVar.Oye = i2;
        aVar.Oyf = i3;
        aVar.text = str;
        aVar.kjh = onMenuItemClickListener;
        aVar.tib = onLongClickListener;
        aVar.OGS = bVar;
        aVar.eho = z;
        if (aVar.Oyf == R.drawable.aii && Util.isNullOrNil(str)) {
            aVar.text = this.mContext.getString(R.string.wp);
        }
        akW(aVar.Oye);
        this.OxV.add(aVar);
        supportInvalidateOptionsMenu();
    }

    public final a akX(int i2) {
        Iterator<a> it = this.OxV.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.Oye == i2) {
                return next;
            }
        }
        return null;
    }

    public final CharSequence getMMTitle() {
        if (this.mActionBar == null) {
            return null;
        }
        return this.OFU != null ? this.OFU : this.mActionBar.getTitle();
    }

    public final void hideTitleView() {
        boolean z = true;
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.v("MicroMsg.MMActivityController", "hideTitleView hasTitle:%b", objArr);
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
    }

    public final void showTitleView() {
        boolean z = true;
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.v("MicroMsg.MMActivityController", "showTitleView hasTitle:%b", objArr);
        if (this.mActionBar != null) {
            this.mActionBar.show();
        }
    }

    public final boolean isTitleShowing() {
        boolean z = true;
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.v("MicroMsg.MMActivityController", "isTitleShowing hasTitle:%b", objArr);
        if (this.mActionBar == null) {
            return false;
        }
        return this.mActionBar.isShowing();
    }

    public final int getTitleLocation() {
        if (this.mActionBar == null) {
            return 0;
        }
        return this.mActionBar.getHeight();
    }

    public final void setTitlePhoneIconVisibility(int i2) {
        this.OGd = i2 == 0;
        gIQ();
    }

    public final void setTitleMuteIconVisibility(int i2) {
        this.zSX = i2 == 0;
        gIQ();
    }

    public final boolean hideVKB() {
        View currentFocus = this.OGe.getCurrentFocus();
        if (currentFocus == null) {
            return hideVKB(this.contentView);
        }
        return hideVKB(currentFocus);
    }

    public final boolean hideVKB(View view) {
        InputMethodManager inputMethodManager;
        IBinder windowToken;
        boolean z;
        if (view == null || (inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method")) == null || (windowToken = view.getWindowToken()) == null) {
            return false;
        }
        try {
            z = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", e2);
            z = false;
        }
        return z;
    }

    public static void showVKB(Activity activity) {
        View currentFocus;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null && (currentFocus = activity.getCurrentFocus()) != null && currentFocus.getWindowToken() != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }

    private void gIR() {
        if (this.OxS) {
            if (this.OGl != null) {
                WeImageView weImageView = this.OGl;
                PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
                a(weImageView, -1);
            }
            if (this.OGj != null && this.OGj.getVisibility() == 0) {
                this.OGj.setTextColor(this.mContext.getResources().getColor(R.color.bw));
            }
            if (this.orb != null && this.orb.getVisibility() == 0) {
                this.orb.setTextColor(this.mContext.getResources().getColor(R.color.bw));
            }
            if (this.OxJ == null || this.OxJ.getVisibility() != 0) {
                if (this.OxL != null && this.OxL.getVisibility() == 0) {
                    this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.mContext, R.color.ag5));
                }
            } else if (this.OxJ.getDrawable() != null) {
                b(this.OxJ.getDrawable(), -1, PorterDuff.Mode.SRC_ATOP);
            } else {
                WeImageView weImageView2 = this.OxJ;
                PorterDuff.Mode mode2 = PorterDuff.Mode.SRC_ATOP;
                a(weImageView2, -1);
            }
        } else {
            if (this.OGl != null) {
                WeImageView weImageView3 = this.OGl;
                PorterDuff.Mode mode3 = PorterDuff.Mode.SRC_ATOP;
                a(weImageView3, WebView.NIGHT_MODE_COLOR);
            }
            if (this.OGj != null && this.OGj.getVisibility() == 0) {
                this.OGj.setTextColor(this.mContext.getResources().getColor(R.color.ae));
            }
            if (this.orb != null && this.orb.getVisibility() == 0) {
                this.orb.setTextColor(this.mContext.getResources().getColor(R.color.ae));
            }
            if (this.OxJ == null || this.OxJ.getVisibility() != 0) {
                if (this.OxL != null && this.OxL.getVisibility() == 0) {
                    this.OxL.setTextColor(com.tencent.mm.cb.a.m(this.mContext, R.color.fu));
                }
            } else if (this.OxJ.getDrawable() != null) {
                b(this.OxJ.getDrawable(), WebView.NIGHT_MODE_COLOR, PorterDuff.Mode.SRC_ATOP);
            } else {
                WeImageView weImageView4 = this.OxJ;
                PorterDuff.Mode mode4 = PorterDuff.Mode.SRC_ATOP;
                a(weImageView4, WebView.NIGHT_MODE_COLOR);
            }
        }
    }

    private void a(WeImageView weImageView, int i2) {
        if (this.OGt) {
            weImageView.setIconColor(i2);
            return;
        }
        weImageView.setClearColorFilter(true);
        weImageView.clearColorFilter();
    }

    private void b(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (this.OGt) {
            drawable.setColorFilter(i2, mode);
        } else {
            drawable.clearColorFilter();
        }
    }

    private void gIS() {
        updataStatusBarIcon(this.OxS);
    }

    public final void updataStatusBarIcon(boolean z) {
        int i2;
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = this.OGe.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            Log.d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", Boolean.valueOf(z));
            if (z) {
                i2 = systemUiVisibility & -8193;
            } else {
                i2 = systemUiVisibility | 8192;
            }
            decorView.setSystemUiVisibility(i2);
        }
    }

    public final void setNavigationbarColor(int i2) {
        int i3;
        if (Build.VERSION.SDK_INT >= 26 && !r.gII()) {
            this.OGe.getWindow().setNavigationBarColor(i2);
            boolean aln = ar.aln(i2);
            View decorView = this.OGe.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (aln) {
                i3 = systemUiVisibility & -17;
            } else {
                i3 = systemUiVisibility | 16;
            }
            decorView.setSystemUiVisibility(i3);
        }
    }

    public final void setActionbarColor(int i2) {
        if (this.mActionBar != null) {
            this.IUs = i2;
            this.OxS = ar.aln(this.IUs);
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.IUs));
            p(this.OGe, this.IUs);
            gIS();
            gIR();
        }
    }

    public final void akY(int i2) {
        if (!noActionBar()) {
            if (i2 > this.OxT) {
                i2 = this.OxT;
            }
            if (i2 < this.OxU) {
                i2 = this.OxU;
            }
            this.bIs = i2;
            this.actionbarView = this.OGe.getWindow().getDecorView().findViewById(R.id.c_);
            if (this.actionbarView != null) {
                this.OGp = this.actionbarView.getLayoutParams();
            }
            if (!(this.actionbarView == null || this.OGp == null)) {
                this.OGp.height = this.actionbarView.getPaddingTop() + i2 + this.actionbarView.getPaddingBottom();
                this.actionbarView.setLayoutParams(this.OGp);
            }
            float min = Math.min(com.tencent.mm.cb.a.ez(this.OGe), com.tencent.mm.cb.a.ji(this.OGe));
            int aH = (int) (((float) at.aH(this.mContext, R.dimen.k7)) * min);
            int fromDPToPix = at.fromDPToPix(this.mContext, 14);
            float f2 = ((float) (i2 - this.OxU)) / ((float) (this.OxT - this.OxU));
            float aH2 = (((float) (((int) (min * ((float) at.aH(this.mContext, R.dimen.it)))) - aH)) * f2) + ((float) aH);
            setIconAlpha(f2);
            int fromDPToPix2 = (int) (((float) (fromDPToPix - at.fromDPToPix(this.mContext, 40))) * (1.0f - f2));
            int i3 = (int) ((((float) (this.OxU - this.OxT)) / 2.0f) * (1.0f - f2));
            if (this.OGj != null) {
                this.OGj.setTextSize(0, aH2);
                if (this.OxH != null) {
                    this.OxH.setTranslationX((float) fromDPToPix2);
                    this.OxH.setTranslationY((float) i3);
                }
            }
            if (this.OGl != null) {
                this.OGl.setTranslationY((float) i3);
            }
            if (this.OxJ != null) {
                this.OxJ.setTranslationY((float) i3);
            }
        }
    }

    public final void setIconAlpha(float f2) {
        if (this.OGk != null) {
            this.OGk.setAlpha(f2);
            if (f2 == 0.0f) {
                this.OGk.setEnabled(false);
            } else {
                this.OGk.setEnabled(true);
            }
        }
        if (this.OxJ != null) {
            this.OxJ.setAlpha(f2);
            if (f2 == 0.0f) {
                this.OxJ.setEnabled(false);
            } else {
                this.OxJ.setEnabled(true);
            }
        }
    }

    public final void Bi(boolean z) {
        this.OxS = z;
        gIS();
        gIR();
    }

    public final void hideActionbarLine() {
        if (Build.VERSION.SDK_INT >= 21 && getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0.0f);
        }
    }

    public final void showActionbarLine() {
        if (Build.VERSION.SDK_INT >= 21 && getSupportActionBar() != null) {
            getSupportActionBar().setElevation(1.0f);
        }
    }

    @TargetApi(21)
    public final void p(Activity activity, int i2) {
        int i3;
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 23 && !com.tencent.mm.compatible.util.g.isMIUIV8()) {
                i3 = i2;
            } else if (Build.VERSION.SDK_INT >= 21) {
                i3 = ar.v(activity.getResources().getColor(R.color.a_7), i2);
            } else {
                i3 = 0;
            }
            if (!(activity instanceof MMActivity) || !((MMActivity) activity).fixStatusbar || !((MMActivity) activity).isSupportNavigationSwipeBack()) {
                activity.getWindow().setStatusBarColor(i3);
            } else {
                com.tencent.mm.ui.statusbar.a.e(this.contentView, i3, d.f(activity.getWindow()));
            }
            setNavigationbarColor(activity.getResources().getColor(R.color.f3043a));
            this.statusBarColor = i2;
        }
    }

    public final void setStatusBarColor(int i2) {
        p(this.OGe, i2);
        updataStatusBarIcon(ar.aln(i2));
    }

    public final void setMMTitleVisibility(int i2) {
        this.OGj.setVisibility(i2);
    }

    /* access modifiers changed from: protected */
    public final void updateDescription(String str) {
        a.C2075a.gKe().p(this.OGe, str);
    }

    static /* synthetic */ boolean f(t tVar) {
        return (tVar.OGe.getWindow().getAttributes().flags & 1024) != 0;
    }

    static /* synthetic */ void g(t tVar) {
        tVar.OGC = 2;
        tVar.onKeyboardStateChanged();
    }

    static /* synthetic */ void h(t tVar) {
        tVar.OGC = 1;
        tVar.onKeyboardStateChanged();
    }

    static /* synthetic */ boolean a(t tVar, View view, a aVar) {
        if (!tVar.OFT) {
            Log.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
            return true;
        } else if (aVar.tib != null) {
            return aVar.tib.onLongClick(view);
        } else {
            return false;
        }
    }

    static /* synthetic */ boolean a(t tVar, View view, MotionEvent motionEvent, a aVar) {
        if (!tVar.OFT) {
            Log.w("MicroMsg.MMActivityController", "callTouchCallback screen not enable.");
            return true;
        } else if (aVar.uwC != null) {
            return aVar.uwC.onTouch(view, motionEvent);
        } else {
            return false;
        }
    }
}
