package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b;
import com.tencent.mm.ui.base.n;

public class GameMenuView extends LinearLayout {
    private View Jse;
    private LinearLayout Jsf;
    private LinearLayout Jsg;
    private f Jsh;
    private b.c Jsi;
    private b.a Jsj;
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean mLL = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GameMenuView(Context context) {
        super(context, null);
        boolean z = false;
        AppMethodBeat.i(80983);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.mLL = displayMetrics.widthPixels > displayMetrics.heightPixels ? true : z;
        initView();
        AppMethodBeat.o(80983);
    }

    public void setAdapter(f fVar) {
        AppMethodBeat.i(80984);
        this.Jsh = fVar;
        fVar.registerDataSetObserver(new DataSetObserver() {
            /* class com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView.AnonymousClass1 */

            public final void onInvalidated() {
                AppMethodBeat.i(80980);
                GameMenuView.a(GameMenuView.this);
                AppMethodBeat.o(80980);
            }

            public final void onChanged() {
                AppMethodBeat.i(80981);
                GameMenuView.a(GameMenuView.this);
                AppMethodBeat.o(80981);
            }
        });
        fVar.notifyDataSetChanged();
        AppMethodBeat.o(80984);
    }

    public GameMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AppMethodBeat.i(80985);
        this.mContext = context;
        initView();
        AppMethodBeat.o(80985);
    }

    private void initView() {
        View inflate;
        AppMethodBeat.i(80986);
        if (this.mLL) {
            setOrientation(0);
            this.mInflater.inflate(R.layout.arn, (ViewGroup) this, true);
            inflate = this.mInflater.inflate(R.layout.ark, (ViewGroup) this, true);
        } else {
            setOrientation(1);
            this.mInflater.inflate(R.layout.aro, (ViewGroup) this, true);
            inflate = this.mInflater.inflate(R.layout.arl, (ViewGroup) this, true);
        }
        this.Jse = inflate.findViewById(R.id.dhf);
        this.Jsf = (LinearLayout) inflate.findViewById(R.id.dhe);
        this.Jsg = (LinearLayout) inflate.findViewById(R.id.dhg);
        AppMethodBeat.o(80986);
    }

    public void setGameMenuItemSelectedListener(b.c cVar) {
        this.Jsi = cVar;
    }

    public void setDismissListener(b.a aVar) {
        this.Jsj = aVar;
    }

    static /* synthetic */ void a(GameMenuView gameMenuView) {
        int jn;
        boolean z;
        int i2;
        LinearLayout.LayoutParams layoutParams;
        View childAt;
        View childAt2;
        AppMethodBeat.i(80987);
        int count = gameMenuView.Jsh.getCount();
        if (count != 0) {
            if (gameMenuView.mLL) {
                jn = a.jo(gameMenuView.mContext);
            } else {
                jn = a.jn(gameMenuView.mContext);
            }
            int aH = jn - (a.aH(gameMenuView.mContext, R.dimen.a8q) * 2);
            int aH2 = a.aH(gameMenuView.mContext, R.dimen.a8p);
            int aH3 = a.aH(gameMenuView.mContext, R.dimen.a8o);
            f fVar = gameMenuView.Jsh;
            if (fVar.HMc == null || fVar.HMc.size() == 0) {
                z = false;
            } else {
                z = (fVar.HMc.size() + 1) / 2 > 4;
            }
            if (z) {
                if (gameMenuView.mLL) {
                    i2 = (int) (((((double) aH) - (0.375d * ((double) aH3))) - ((double) (aH3 * 4))) / 9.0d);
                } else {
                    i2 = (int) (((((double) aH) - (0.5d * ((double) aH2))) - ((double) (aH2 * 4))) / 9.0d);
                }
            } else if (gameMenuView.mLL) {
                i2 = (int) (((double) (aH - (aH3 * 4))) / 8.0d);
            } else {
                i2 = (int) (((double) (aH - (aH2 * 4))) / 8.0d);
            }
            if (gameMenuView.mLL) {
                if (i2 > 0) {
                    layoutParams = new LinearLayout.LayoutParams(aH3, (i2 * 2) + aH3);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(aH3, aH3);
                }
            } else if (i2 > 0) {
                layoutParams = new LinearLayout.LayoutParams((i2 * 2) + aH2, aH2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(aH2, aH2);
            }
            for (int i3 = 0; i3 < count; i3++) {
                View view = gameMenuView.Jsh.getView(i3, null, gameMenuView.Jsf);
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(80982);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/game/menu/GameMenuView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (GameMenuView.this.Jsi != null) {
                                GameMenuView.this.Jsi.c((n) view.getTag());
                            }
                            if (GameMenuView.this.Jsj != null) {
                                GameMenuView.this.Jsj.onDismiss();
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/game/menu/GameMenuView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(80982);
                        }
                    });
                    view.setLayoutParams(layoutParams);
                    if (i3 % 2 == 0) {
                        gameMenuView.Jsf.addView(view);
                    } else {
                        gameMenuView.Jsg.addView(view);
                    }
                }
            }
            while (true) {
                int childCount = gameMenuView.Jsf.getChildCount();
                if (childCount > 0 && ((childAt2 = gameMenuView.Jsf.getChildAt(childCount - 1)) == null || childAt2.getTag() == null)) {
                    gameMenuView.Jsf.removeViewAt(childCount - 1);
                }
            }
            while (true) {
                int childCount2 = gameMenuView.Jsg.getChildCount();
                if (childCount2 > 0 && ((childAt = gameMenuView.Jsg.getChildAt(childCount2 - 1)) == null || childAt.getTag() == null)) {
                    gameMenuView.Jsg.removeViewAt(childCount2 - 1);
                }
            }
            if (gameMenuView.Jsf.getChildCount() == 0 && gameMenuView.Jsg.getChildCount() == 0) {
                if (gameMenuView.Jsj != null) {
                    gameMenuView.Jsj.onDismiss();
                    AppMethodBeat.o(80987);
                    return;
                }
            } else if (gameMenuView.Jsf.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.Jsf.getParent()).setVisibility(8);
                AppMethodBeat.o(80987);
                return;
            } else if (gameMenuView.Jsg.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.Jsg.getParent()).setVisibility(8);
            }
        }
        AppMethodBeat.o(80987);
    }
}
