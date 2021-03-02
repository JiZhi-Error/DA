package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.h;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import java.util.ArrayList;

public class s {
    boolean Qwc;
    public boolean Qwd;
    private boolean Qwe;
    private boolean Qwf;
    private boolean Qwg;
    public d Qwh;
    public b Qwi;
    private SearchViewNotRealTimeHelper.a Qwj;
    private boolean Qwk;
    private ArrayList<String> Qwl;
    private boolean Qwm;
    public int Qwn;
    private int Qwo;
    a Qwp;
    final String TAG;
    public boolean VlU;
    MMHandler hAk;
    MenuItem tfn;

    public interface a {
        void collapseActionView();

        void gXQ();
    }

    public interface b {
        boolean SN(String str);

        void SO(String str);

        void bnA();

        void bnB();

        void bny();

        void bnz();
    }

    public s() {
        AppMethodBeat.i(143240);
        this.Qwc = false;
        this.Qwd = false;
        this.Qwe = false;
        this.Qwf = true;
        this.Qwg = true;
        this.tfn = null;
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.Qwh = null;
        this.Qwk = true;
        this.Qwn = R.string.ty;
        this.Qwo = 0;
        this.VlU = false;
        this.Qwk = true;
        this.Qwc = false;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
        AppMethodBeat.o(143240);
    }

    public s(byte b2) {
        AppMethodBeat.i(143241);
        this.Qwc = false;
        this.Qwd = false;
        this.Qwe = false;
        this.Qwf = true;
        this.Qwg = true;
        this.tfn = null;
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.Qwh = null;
        this.Qwk = true;
        this.Qwn = R.string.ty;
        this.Qwo = 0;
        this.VlU = false;
        this.Qwk = true;
        this.Qwc = true;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
        AppMethodBeat.o(143241);
    }

    public final void a(b bVar) {
        this.Qwi = bVar;
    }

    public final String getSearchContent() {
        AppMethodBeat.i(143242);
        if (this.Qwh != null) {
            String searchContent = this.Qwh.getSearchContent();
            AppMethodBeat.o(143242);
            return searchContent;
        }
        AppMethodBeat.o(143242);
        return "";
    }

    public void setSearchContent(String str) {
        AppMethodBeat.i(143243);
        if (this.Qwh == null) {
            AppMethodBeat.o(143243);
            return;
        }
        this.Qwh.setSearchContent(str);
        AppMethodBeat.o(143243);
    }

    public final void setHint(CharSequence charSequence) {
        AppMethodBeat.i(143244);
        if (this.Qwh == null) {
            AppMethodBeat.o(143244);
            return;
        }
        this.Qwh.setHint(charSequence);
        AppMethodBeat.o(143244);
    }

    public final void clearFocus() {
        AppMethodBeat.i(143245);
        if (this.Qwh != null) {
            this.Qwh.gXo();
        }
        AppMethodBeat.o(143245);
    }

    /* access modifiers changed from: protected */
    public boolean biK() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void biL() {
    }

    /* access modifiers changed from: protected */
    public boolean gXO() {
        return this.Qwg;
    }

    /* access modifiers changed from: protected */
    public void c(Menu menu) {
        AppMethodBeat.i(143246);
        if (menu != null) {
            for (int i2 = 0; i2 < menu.size(); i2++) {
                MenuItem item = menu.getItem(i2);
                if (item.getItemId() != R.id.fdi) {
                    item.setVisible(true);
                }
            }
        }
        AppMethodBeat.o(143246);
    }

    public void a(final FragmentActivity fragmentActivity, final Menu menu) {
        AppMethodBeat.i(143247);
        Log.v(this.TAG, "on create options menu");
        if (fragmentActivity == null) {
            Log.w(this.TAG, "on add search menu, activity is null");
            AppMethodBeat.o(143247);
            return;
        }
        if (this.Qwh == null) {
            if (this.Qwk) {
                this.Qwh = new ActionBarSearchView(fragmentActivity);
                if (this.VlU) {
                    ((ActionBarSearchView) this.Qwh).hYb();
                }
            } else {
                this.Qwh = new SearchViewNotRealTimeHelper(fragmentActivity);
                this.Qwh.setNotRealCallBack(this.Qwj);
            }
            this.Qwh.setAutoMatchKeywords(this.Qwm);
            this.Qwh.setKeywords(this.Qwl);
        }
        this.Qwh.setCallBack(new ActionBarSearchView.b() {
            /* class com.tencent.mm.ui.tools.s.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.ActionBarSearchView.b
            public final void gXt() {
                AppMethodBeat.i(143223);
                if (!s.this.Qwd) {
                    Log.v(s.this.TAG, "onVoiceSearchRequired, but not in searching");
                    AppMethodBeat.o(143223);
                    return;
                }
                s.this.biL();
                AppMethodBeat.o(143223);
            }

            @Override // com.tencent.mm.ui.tools.ActionBarSearchView.b
            public final void gXs() {
                AppMethodBeat.i(143224);
                if (s.this.Qwi != null) {
                    s.this.Qwi.bnB();
                }
                AppMethodBeat.o(143224);
            }

            @Override // com.tencent.mm.ui.tools.ActionBarSearchView.b
            public final void bey(String str) {
                AppMethodBeat.i(143225);
                if (!s.this.Qwd) {
                    Log.v(s.this.TAG, "onSearchTextChange %s, but not in searching", str);
                    AppMethodBeat.o(143225);
                    return;
                }
                if (s.this.Qwi != null) {
                    s.this.Qwi.SO(str);
                }
                AppMethodBeat.o(143225);
            }

            @Override // com.tencent.mm.ui.tools.ActionBarSearchView.b
            public final void bnA() {
                AppMethodBeat.i(143226);
                if (s.this.Qwi != null) {
                    s.this.Qwi.bnA();
                }
                AppMethodBeat.o(143226);
            }
        });
        this.Qwh.CG(biK());
        this.Qwh.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.ui.tools.s.AnonymousClass5 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(143230);
                if (3 != i2 || s.this.Qwi == null) {
                    AppMethodBeat.o(143230);
                    return false;
                }
                boolean SN = s.this.Qwi.SN(s.this.getSearchContent());
                AppMethodBeat.o(143230);
                return SN;
            }
        });
        if (this.Qwo != 0) {
            this.Qwh.setSearchTipIcon(this.Qwo);
        }
        this.tfn = menu.add(0, R.id.fdi, 0, this.Qwn);
        this.tfn.setEnabled(this.Qwf);
        if (this.VlU) {
            this.tfn.setIcon(ar.m(fragmentActivity, R.raw.actionbar_icon_dark_search, fragmentActivity.getResources().getColor(R.color.BW_100_Alpha_0_8)));
        } else {
            this.tfn.setIcon(ar.m(fragmentActivity, R.raw.actionbar_icon_dark_search, fragmentActivity.getResources().getColor(R.color.FG_0)));
        }
        this.tfn.setActionView((View) this.Qwh);
        if (this.Qwc) {
            this.tfn.setShowAsAction(9);
        } else {
            this.tfn.setShowAsAction(2);
        }
        if (this.Qwc) {
            h.a(this.tfn, new h.a() {
                /* class com.tencent.mm.ui.tools.s.AnonymousClass6 */

                @Override // android.support.v4.view.h.a
                public final boolean fA() {
                    AppMethodBeat.i(143231);
                    s.this.a(fragmentActivity, false, menu);
                    AppMethodBeat.o(143231);
                    return true;
                }

                @Override // android.support.v4.view.h.a
                public final boolean fB() {
                    AppMethodBeat.i(143232);
                    s.this.b(fragmentActivity, false, menu);
                    AppMethodBeat.o(143232);
                    return true;
                }
            });
        } else {
            this.Qwp = new a() {
                /* class com.tencent.mm.ui.tools.s.AnonymousClass7 */

                @Override // com.tencent.mm.ui.tools.s.a
                public final void gXQ() {
                    AppMethodBeat.i(143233);
                    s.this.a(fragmentActivity, true, menu);
                    AppMethodBeat.o(143233);
                }

                @Override // com.tencent.mm.ui.tools.s.a
                public final void collapseActionView() {
                    AppMethodBeat.i(143234);
                    s.this.b(fragmentActivity, true, menu);
                    AppMethodBeat.o(143234);
                }
            };
        }
        this.Qwh.setBackClickCallback(new ActionBarSearchView.a() {
            /* class com.tencent.mm.ui.tools.s.AnonymousClass8 */

            @Override // com.tencent.mm.ui.tools.ActionBarSearchView.a
            public final void gXr() {
                ViewGroup viewGroup;
                AppMethodBeat.i(143235);
                if (s.this.Qwc) {
                    if (s.this.tfn != null) {
                        try {
                            if (Huawei.ifHUAWEI() && ao.gJN() && (viewGroup = (ViewGroup) s.this.tfn.getActionView().getParent()) != null) {
                                viewGroup.removeView(viewGroup.findViewById(R.id.bjn));
                            }
                        } catch (Exception e2) {
                        }
                        s.this.tfn.collapseActionView();
                        AppMethodBeat.o(143235);
                        return;
                    }
                } else if (s.this.Qwp != null) {
                    s.this.Qwp.collapseActionView();
                }
                AppMethodBeat.o(143235);
            }
        });
        AppMethodBeat.o(143247);
    }

    public void a(Activity activity, Menu menu) {
        AppMethodBeat.i(143248);
        Log.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", Boolean.valueOf(this.Qwd), Boolean.valueOf(this.Qwe), Boolean.valueOf(this.Qwf));
        if (activity == null) {
            Log.w(this.TAG, "on hanle status fail, activity is null");
            AppMethodBeat.o(143248);
            return;
        }
        this.tfn = menu.findItem(R.id.fdi);
        if (this.tfn == null) {
            Log.w(this.TAG, "can not find search menu, error");
            AppMethodBeat.o(143248);
            return;
        }
        this.tfn.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.s.AnonymousClass9 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        b(activity, menu);
        AppMethodBeat.o(143248);
    }

    private void b(final Activity activity, Menu menu) {
        AppMethodBeat.i(143249);
        if (this.Qwf && (this.Qwd || this.Qwe)) {
            this.Qwe = false;
            if (activity instanceof MMActivity) {
                if (this.VlU) {
                    ((MMActivity) activity).setActionbarColor(activity.getResources().getColor(R.color.w));
                } else {
                    ((MMActivity) activity).setActionbarColor(activity.getResources().getColor(R.color.f3043a));
                }
            }
            if (menu != null) {
                for (int i2 = 0; i2 < menu.size(); i2++) {
                    MenuItem item = menu.getItem(i2);
                    if (item.getItemId() != R.id.fdi) {
                        item.setVisible(false);
                    }
                }
            }
            this.hAk.postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.tools.s.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(143237);
                    if (s.this.tfn == null) {
                        Log.w(s.this.TAG, "on post expand search menu, but item is null");
                        AppMethodBeat.o(143237);
                        return;
                    }
                    Log.i(s.this.TAG, "try to expand action view, searchViewExpand %B", Boolean.valueOf(s.this.Qwd));
                    if (s.this.Qwc) {
                        if (!s.this.Qwd) {
                            s.this.tfn.expandActionView();
                        }
                    } else if (s.this.Qwp != null) {
                        s.this.Qwp.gXQ();
                    }
                    final View actionView = s.this.tfn.getActionView();
                    if (actionView != null && s.this.Qwd) {
                        actionView.findViewById(R.id.bxz).requestFocus();
                        if (s.this.gXO()) {
                            s.this.hAk.postDelayed(new Runnable() {
                                /* class com.tencent.mm.ui.tools.s.AnonymousClass10.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(143236);
                                    ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(actionView.findViewById(R.id.bxz), 0);
                                    AppMethodBeat.o(143236);
                                }
                            }, 128);
                        }
                    }
                    AppMethodBeat.o(143237);
                }
            }, 128);
        }
        AppMethodBeat.o(143249);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(143250);
        Log.v(this.TAG, "on key down, key code %d, expand %B", Integer.valueOf(i2), Boolean.valueOf(this.Qwd));
        if (4 != i2 || !this.Qwd) {
            AppMethodBeat.o(143250);
            return false;
        }
        gXP();
        AppMethodBeat.o(143250);
        return true;
    }

    public final void CK(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(143251);
        String str = this.TAG;
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.Qwd);
        if (this.tfn == null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        Log.d(str, "do expand, expanded[%B], search menu item null[%B]", objArr);
        if (this.Qwd) {
            AppMethodBeat.o(143251);
        } else if (!this.Qwf) {
            Log.w(this.TAG, "can not expand now");
            AppMethodBeat.o(143251);
        } else {
            this.Qwg = z;
            if (this.tfn != null) {
                this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.ui.tools.s.AnonymousClass11 */

                    public final void run() {
                        AppMethodBeat.i(143238);
                        if (s.this.tfn == null) {
                            Log.w(s.this.TAG, "post do expand search menu, but search menu item is null");
                            AppMethodBeat.o(143238);
                        } else if (s.this.Qwc) {
                            s.this.tfn.expandActionView();
                            AppMethodBeat.o(143238);
                        } else {
                            if (s.this.Qwp != null) {
                                s.this.Qwp.gXQ();
                            }
                            AppMethodBeat.o(143238);
                        }
                    }
                });
                AppMethodBeat.o(143251);
                return;
            }
            this.Qwe = true;
            AppMethodBeat.o(143251);
        }
    }

    public final void gXP() {
        AppMethodBeat.i(143252);
        Log.d(this.TAG, "do collapse");
        if (this.Qwd && this.tfn != null) {
            if (this.Qwc) {
                try {
                    ViewGroup viewGroup = (ViewGroup) this.tfn.getActionView().getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(viewGroup.findViewById(R.id.bjn));
                    }
                } catch (Exception e2) {
                }
                this.tfn.collapseActionView();
                AppMethodBeat.o(143252);
                return;
            } else if (this.Qwp != null) {
                this.Qwp.collapseActionView();
            }
        }
        AppMethodBeat.o(143252);
    }

    public final boolean gXp() {
        AppMethodBeat.i(143253);
        if (this.Qwh != null) {
            boolean gXp = this.Qwh.gXp();
            AppMethodBeat.o(143253);
            return gXp;
        }
        AppMethodBeat.o(143253);
        return false;
    }

    public final boolean gXq() {
        AppMethodBeat.i(143254);
        if (this.Qwh != null) {
            boolean gXq = this.Qwh.gXq();
            AppMethodBeat.o(143254);
            return gXq;
        }
        AppMethodBeat.o(143254);
        return false;
    }

    public final void a(final FragmentActivity fragmentActivity, final boolean z, Menu menu) {
        AppMethodBeat.i(143255);
        Log.d(this.TAG, "doNewExpand, searchViewExpand " + this.Qwd);
        if (!this.Qwd) {
            this.Qwd = true;
            b(fragmentActivity, menu);
            this.hAk.post(new Runnable() {
                /* class com.tencent.mm.ui.tools.s.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(143239);
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        Log.w(s.this.TAG, "want to expand search view, but activity status error");
                        AppMethodBeat.o(143239);
                        return;
                    }
                    if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                    AppMethodBeat.o(143239);
                }
            });
            if (this.Qwi != null) {
                this.Qwi.bnz();
            }
        }
        AppMethodBeat.o(143255);
    }

    public final void b(final FragmentActivity fragmentActivity, final boolean z, Menu menu) {
        ViewGroup viewGroup;
        AppMethodBeat.i(143256);
        Log.d(this.TAG, "doNewCollapse, searchViewExpand " + this.Qwd);
        if (this.Qwd) {
            this.Qwd = false;
            try {
                if (Huawei.ifHUAWEI() && ao.gJN() && this.tfn != null && (viewGroup = (ViewGroup) this.tfn.getActionView().getParent()) != null) {
                    viewGroup.removeView(viewGroup.findViewById(R.id.bjn));
                }
            } catch (Exception e2) {
            }
            c(menu);
            if (this.Qwh != null) {
                this.Qwh.CH(false);
            }
            this.hAk.post(new Runnable() {
                /* class com.tencent.mm.ui.tools.s.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(143227);
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        Log.w(s.this.TAG, "want to collapse search view, but activity status error");
                        AppMethodBeat.o(143227);
                        return;
                    }
                    if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                    AppMethodBeat.o(143227);
                }
            });
            if (this.Qwi != null) {
                this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.ui.tools.s.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(143228);
                        if (s.this.Qwi != null) {
                            s.this.Qwi.bny();
                        }
                        AppMethodBeat.o(143228);
                    }
                });
            }
        }
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.ui.tools.s.AnonymousClass4 */

            public final void run() {
                View findViewById;
                View currentFocus;
                IBinder windowToken;
                AppMethodBeat.i(143229);
                if (s.this.tfn == null) {
                    Log.w(s.this.TAG, "want to collapse search view, but search menu item is null");
                    AppMethodBeat.o(143229);
                    return;
                }
                if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
                    FragmentActivity fragmentActivity = fragmentActivity;
                    InputMethodManager inputMethodManager = (InputMethodManager) fragmentActivity.getSystemService("input_method");
                    if (!(inputMethodManager == null || (currentFocus = fragmentActivity.getCurrentFocus()) == null || (windowToken = currentFocus.getWindowToken()) == null)) {
                        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                    }
                }
                View actionView = s.this.tfn.getActionView();
                if (!(actionView == null || (findViewById = actionView.findViewById(R.id.bxz)) == null)) {
                    findViewById.clearFocus();
                }
                AppMethodBeat.o(143229);
            }
        });
        AppMethodBeat.o(143256);
    }
}
