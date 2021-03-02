package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BaseActivity extends AppCompatActivity {
    private int IUs = 0;
    private TextView OxG;
    private View OxH;
    private View OxI;
    private WeImageView OxJ;
    private WeImageView OxK;
    private TextView OxL;
    private MenuItem OxM;
    private MenuItem OxN;
    private int OxO;
    private int OxP;
    private c OxQ;
    private a OxR = a.BACK;
    private boolean OxS = false;
    private int OxT;
    private int OxU;
    private LinkedList<b> OxV = new LinkedList<>();
    private View actionbarView;
    private int bIs = this.OxT;
    private TextView jUu;
    private ActionBar mActionBar;
    private Context mContext;
    private ImageView nZa;
    private int theme;

    public static final class b {
        int Oye = -1;
        int Oyf;
        View Oyg;
        View Oyh;
        View Oyi;
        c Oyj = c.CUSTOM;
        boolean enable = true;
        MenuItem.OnMenuItemClickListener kjh;
        String text;
        View.OnLongClickListener tib;
        boolean visible = true;
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i2 = getApplicationContext().getSharedPreferences("SETTING_COLOR", 0).getInt("APP_THEME_COLOR", WebView.NIGHT_MODE_COLOR);
        switch (i2) {
            case WebView.NIGHT_MODE_COLOR /*{ENCODED_INT: -16777216}*/:
                this.theme = R.style.a1d;
                break;
            case -16711936:
                this.theme = R.style.a1e;
                break;
        }
        setTheme(i2);
        setContentView(getLayoutId());
        this.mContext = this;
        this.mActionBar = getSupportActionBar();
        if (this.mActionBar != null) {
            this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.mActionBar.gt();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.gs();
            this.mActionBar.gu();
            this.mActionBar.setCustomView(LayoutInflater.from(this).inflate(R.layout.bh, (ViewGroup) null));
            if (this.IUs == 0) {
                this.IUs = at.aO(this.mContext, R.attr.bf);
            }
            this.OxS = ar.aln(this.IUs);
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.IUs));
            this.jUu = (TextView) findViewById(16908308);
            this.OxG = (TextView) findViewById(16908309);
            this.OxH = findViewById(R.id.iqp);
            this.OxI = findViewById(R.id.eh);
            this.nZa = (ImageView) findViewById(R.id.ei);
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.BaseActivity.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(159086);
                    BaseActivity.this.finish();
                    AppMethodBeat.o(159086);
                    return true;
                }
            });
        }
        this.OxT = at.aH(this.mContext, R.dimen.b9);
        this.OxU = at.aH(this.mContext, R.dimen.jw);
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.IUs == 0) {
                this.IUs = at.aO(this.mContext, R.attr.bf);
            }
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(this.IUs);
            gGK();
        }
    }

    public final void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        a(onMenuItemClickListener, 0, a.BACK);
    }

    public final void a(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        a(onMenuItemClickListener, R.raw.actionbar_icon_dark_close, a.CUSTOM);
    }

    private void a(final MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i2, a aVar) {
        if (this.mActionBar != null) {
            if (onMenuItemClickListener == null) {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
            } else {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
                if (this.OxI != null) {
                    this.OxI.setVisibility(0);
                    this.OxI.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.BaseActivity.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(159087);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/BaseActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            onMenuItemClickListener.onMenuItemClick(null);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/BaseActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(159087);
                        }
                    });
                }
            }
            this.OxR = aVar;
            if (i2 != 0) {
                this.OxO = i2;
            }
            if (this.OxR == a.NONE) {
                this.OxO = 0;
            }
            if (this.OxR == a.BACK) {
                this.OxO = R.drawable.bw7;
            } else if (this.OxR == a.CLOSE) {
                this.OxO = R.drawable.bw9;
            }
            if (!(this.nZa == null || this.OxO == 0)) {
                gGJ();
                this.nZa.setImageResource(this.OxO);
            }
            gGN();
        }
    }

    private void gGJ() {
        if (this.nZa != null) {
            this.nZa.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        if (this.mActionBar != null && this.jUu != null) {
            this.jUu.setText(charSequence.toString());
            updateTitle();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean z;
        as.d("BaseActivity", "on create option menu, menuCache size:%d", Integer.valueOf(this.OxV.size()));
        if (this.mActionBar == null || this.OxV.size() == 0) {
            as.w("BaseActivity", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.OxV.size()));
            z = false;
        } else {
            Iterator<b> it = this.OxV.iterator();
            while (it.hasNext()) {
                final b next = it.next();
                if (next.Oye != 16908332) {
                    if (next.Oyj == c.SEARCH) {
                        this.OxM = menu.add(0, next.Oye, 0, next.text);
                        AnonymousClass3 r5 = new View.OnClickListener() {
                            /* class com.tencent.mm.ui.BaseActivity.AnonymousClass3 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(159088);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/BaseActivity$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                BaseActivity.a(BaseActivity.this.OxM, next);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/BaseActivity$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(159088);
                            }
                        };
                        if (next.Oyi == null) {
                            next.Oyi = View.inflate(this.mContext, R.layout.ba, null);
                        }
                        this.OxK = (WeImageView) next.Oyi.findViewById(R.id.d8);
                        this.OxK.setVisibility(0);
                        gGM();
                        this.OxK.setOnClickListener(r5);
                        this.OxK.setEnabled(next.enable);
                        this.OxM.setActionView(next.Oyi);
                        this.OxM.setEnabled(next.enable);
                        this.OxM.setVisible(next.visible);
                    } else {
                        this.OxN = menu.add(0, next.Oye, 0, next.text);
                        AnonymousClass4 r52 = new View.OnClickListener() {
                            /* class com.tencent.mm.ui.BaseActivity.AnonymousClass4 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(159089);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/BaseActivity$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                BaseActivity.a(BaseActivity.this.OxN, next);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/BaseActivity$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(159089);
                            }
                        };
                        AnonymousClass5 r6 = new View.OnLongClickListener() {
                            /* class com.tencent.mm.ui.BaseActivity.AnonymousClass5 */

                            public final boolean onLongClick(View view) {
                                AppMethodBeat.i(159090);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                                boolean a2 = BaseActivity.a(view, next);
                                com.tencent.mm.hellhoundlib.a.a.a(a2, this, "com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                                AppMethodBeat.o(159090);
                                return a2;
                            }
                        };
                        this.OxQ = next.Oyj;
                        if (next.Oyj == c.GREEN_TEXT || next.Oyj == c.TEXT) {
                            if (next.Oyg == null) {
                                next.Oyg = View.inflate(this.mContext, R.layout.ba, null);
                            }
                            this.OxL = (TextView) next.Oyg.findViewById(R.id.d9);
                            this.OxL.setVisibility(0);
                            this.OxL.setText(next.text);
                            if (next.Oyj == c.GREEN_TEXT) {
                                this.OxL.setTextColor(this.mContext.getResources().getColorStateList(R.color.g_));
                            } else {
                                gGL();
                            }
                            this.OxL.setOnClickListener(r52);
                            this.OxL.setOnLongClickListener(r6);
                            this.OxL.setEnabled(next.enable);
                            this.OxN.setActionView(next.Oyg);
                        } else {
                            if (next.Oyf != 0) {
                                this.OxP = next.Oyf;
                            }
                            if (next.Oyj == c.NONE) {
                                this.OxP = 0;
                            }
                            if (next.Oyh == null) {
                                next.Oyh = View.inflate(this.mContext, R.layout.ba, null);
                            }
                            this.OxJ = (WeImageView) next.Oyh.findViewById(R.id.d8);
                            gGL();
                            if (this.OxP != 0) {
                                this.OxJ.setVisibility(0);
                                this.OxJ.setOnClickListener(r52);
                                this.OxJ.setOnLongClickListener(r6);
                                this.OxJ.setEnabled(next.enable);
                                this.OxN.setActionView(next.Oyh);
                            }
                        }
                        this.OxN.setEnabled(next.enable);
                        this.OxN.setVisible(next.visible);
                        if (this.OxN != null) {
                            this.OxN.setShowAsAction(2);
                        }
                    }
                }
            }
            if (this.OxM != null) {
                this.OxM.setShowAsAction(2);
            }
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public final void a(String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, c cVar) {
        b bVar = new b();
        bVar.Oye = 0;
        bVar.Oyf = 0;
        bVar.text = str;
        bVar.kjh = onMenuItemClickListener;
        bVar.tib = null;
        bVar.Oyj = cVar;
        if (bVar.Oyf == R.drawable.bw_ && (str == null || str.length() <= 0)) {
            bVar.text = getString(R.string.ct);
        }
        int i2 = bVar.Oye;
        int i3 = 0;
        while (true) {
            if (i3 >= this.OxV.size()) {
                break;
            } else if (this.OxV.get(i3).Oye == i2) {
                as.d("BaseActivity", "match menu, id ：" + i2 + ", remove it", new Object[0]);
                this.OxV.remove(i3);
                break;
            } else {
                i3++;
            }
        }
        this.OxV.add(bVar);
        new Handler().postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.BaseActivity.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(159091);
                BaseActivity.this.supportInvalidateOptionsMenu();
                AppMethodBeat.o(159091);
            }
        }, 200);
    }

    public final void removeAllOptionMenu() {
        if (!this.OxV.isEmpty()) {
            this.OxV.clear();
            supportInvalidateOptionsMenu();
        }
    }

    public final void a(String str, c cVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        a(str, onMenuItemClickListener, cVar);
    }

    public final void setActionBarColor(int i2) {
        if (this.mActionBar != null) {
            this.IUs = i2;
            this.OxS = ar.aln(this.IUs);
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.IUs));
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().setStatusBarColor(this.IUs);
            }
            gGK();
            gGN();
            gGL();
            updateTitle();
            if (this.OxG != null) {
                if (this.OxS) {
                    this.OxG.setTextColor(this.mContext.getResources().getColor(R.color.bt));
                } else {
                    this.OxG.setTextColor(this.mContext.getResources().getColor(R.color.bs));
                }
            }
            gGM();
        }
    }

    private void gGK() {
        int i2;
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (this.OxS) {
                i2 = systemUiVisibility & -8193;
            } else {
                i2 = systemUiVisibility | 8192;
            }
            decorView.setSystemUiVisibility(i2);
        }
    }

    private void gGL() {
        if (this.OxQ != c.TEXT) {
            if (this.OxQ == c.ADD) {
                this.OxP = R.drawable.bw6;
            } else if (this.OxQ == c.MORE) {
                this.OxP = R.drawable.bw_;
            } else if (this.OxQ == c.SEARCH) {
                this.OxP = R.drawable.bwa;
            }
            if (this.OxJ != null && this.OxP != 0) {
                this.OxJ.setImageResource(this.OxP);
                if (this.OxS) {
                    this.OxJ.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                } else {
                    this.OxJ.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, PorterDuff.Mode.SRC_ATOP);
                }
            }
        } else if (this.OxL != null) {
            if (this.OxS) {
                this.OxL.setTextColor(this.mContext.getResources().getColorStateList(R.color.ag5));
            } else {
                this.OxL.setTextColor(this.mContext.getResources().getColorStateList(R.color.fu));
            }
        }
    }

    private void gGM() {
        if (this.OxK != null) {
            if (this.OxS) {
                this.OxK.setImageResource(R.drawable.bwg);
            } else {
                this.OxK.setImageResource(R.drawable.bwa);
            }
        }
    }

    private void gGN() {
        if (this.OxS) {
            this.nZa.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        } else {
            this.nZa.setColorFilter(WebView.NIGHT_MODE_COLOR, PorterDuff.Mode.SRC_ATOP);
        }
    }

    private void updateTitle() {
        if (this.jUu != null) {
            if (this.OxS) {
                this.jUu.setTextColor(this.mContext.getResources().getColor(R.color.bw));
            } else {
                this.jUu.setTextColor(this.mContext.getResources().getColor(R.color.bv));
            }
        }
    }

    public static void showVKB(Activity activity) {
        InputMethodManager inputMethodManager;
        View currentFocus;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && (currentFocus = activity.getCurrentFocus()) != null && currentFocus.getWindowToken() != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }

    public enum c {
        CUSTOM,
        TEXT,
        GREEN_TEXT,
        ADD,
        MORE,
        SEARCH,
        NONE;

        public static c valueOf(String str) {
            AppMethodBeat.i(159096);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(159096);
            return cVar;
        }

        static {
            AppMethodBeat.i(159097);
            AppMethodBeat.o(159097);
        }
    }

    public enum a {
        CUSTOM,
        BACK,
        CLOSE,
        NONE;

        public static a valueOf(String str) {
            AppMethodBeat.i(159093);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(159093);
            return aVar;
        }

        static {
            AppMethodBeat.i(159094);
            AppMethodBeat.o(159094);
        }
    }

    static /* synthetic */ void a(MenuItem menuItem, b bVar) {
        if (bVar.kjh != null) {
            bVar.kjh.onMenuItemClick(menuItem);
        }
    }

    static /* synthetic */ boolean a(View view, b bVar) {
        if (bVar.tib != null) {
            return bVar.tib.onLongClick(view);
        }
        return false;
    }
}
