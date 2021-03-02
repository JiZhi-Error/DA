package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandDebugUI;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView;
import com.tencent.mm.ui.aa;
import java.util.List;

public class RecentAppBrandViewContainer extends LinearLayout {
    Runnable aco = null;
    private Context mContext;
    RecentAppBrandView onn;
    private View opu;
    boolean opv = true;
    private View.OnClickListener opw = null;

    public RecentAppBrandViewContainer(Context context) {
        super(context);
        AppMethodBeat.i(49704);
        init(context);
        AppMethodBeat.o(49704);
    }

    public RecentAppBrandViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49705);
        init(context);
        AppMethodBeat.o(49705);
    }

    public RecentAppBrandViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(49706);
        init(context);
        AppMethodBeat.o(49706);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(49707);
        if (this.onn != null) {
            caJ();
            this.onn.cax();
        }
        AppMethodBeat.o(49707);
    }

    public void setOnMoreClickListener(View.OnClickListener onClickListener) {
        this.opw = onClickListener;
    }

    public void setDataList(List<AppBrandDesktopView.c> list) {
        AppMethodBeat.i(49708);
        if (this.onn != null) {
            this.onn.setDataList(list);
            caJ();
        }
        AppMethodBeat.o(49708);
    }

    public int getShowLines() {
        AppMethodBeat.i(49709);
        if (this.onn != null) {
            int showLines = this.onn.getShowLines();
            AppMethodBeat.o(49709);
            return showLines;
        }
        AppMethodBeat.o(49709);
        return 0;
    }

    private void caJ() {
        AppMethodBeat.i(49710);
        if (this.onn.getDataCount() > this.onn.getMaxShowItemCountIncludeMore()) {
            this.opu.setVisibility(0);
            AppMethodBeat.o(49710);
            return;
        }
        this.opu.setVisibility(4);
        AppMethodBeat.o(49710);
    }

    public final void eH(int i2, int i3) {
        AppMethodBeat.i(227781);
        if (this.onn != null) {
            this.onn.setItemPadding(i2);
        }
        if (this.opu != null) {
            if (i3 > 0) {
                this.opu.getLayoutParams().width = i3 / 4;
            }
            this.opu.setPadding(i2, a.fromDPToPix(getContext(), 8), i2, a.fromDPToPix(getContext(), 16));
        }
        AppMethodBeat.o(227781);
    }

    public RecentAppBrandView getRecentView() {
        return this.onn;
    }

    private void init(final Context context) {
        AppMethodBeat.i(49712);
        this.mContext = context;
        View inflate = aa.jQ(context).inflate(R.layout.dm, this);
        this.onn = (RecentAppBrandView) inflate.findViewById(R.id.gu3);
        this.opu = inflate.findViewById(R.id.fkj);
        this.opu.getLayoutParams().width = a.jn(getContext()) / 4;
        d dVar = new d(this.opu);
        int ey = (int) b.ey(getContext());
        dVar.ooC.getLayoutParams().width = ((int) (((float) (a.aH(getContext(), R.dimen.k5) * 2)) * b.ez(getContext()))) + ey;
        dVar.nnL.getLayoutParams().width = ey;
        dVar.nnL.getLayoutParams().height = ey;
        dVar.ooB.getLayoutParams().width = ey;
        dVar.ooB.getLayoutParams().height = ey;
        dVar.nnL.setImageResource(R.raw.multitask_bar_more_btn);
        dVar.ooD.setVisibility(8);
        dVar.titleTv.setText("");
        dVar.aus.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(49702);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (RecentAppBrandViewContainer.this.opw != null) {
                    RecentAppBrandViewContainer.this.opw.onClick(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(49702);
            }
        });
        dVar.aus.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer.AnonymousClass3 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(227779);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (f.bWW()) {
                    Intent intent = new Intent(context, AppBrandDebugUI.class);
                    Context context = context;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(227779);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(227779);
                return false;
            }
        });
        AppMethodBeat.o(49712);
    }

    static /* synthetic */ void a(RecentAppBrandViewContainer recentAppBrandViewContainer) {
        AppMethodBeat.i(49713);
        if (recentAppBrandViewContainer.opu != null) {
            recentAppBrandViewContainer.opu.animate().scaleX(0.75f).scaleY(0.75f).setDuration(300).setListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppBrandDesktopView.c zW;
                    AppMethodBeat.i(227780);
                    RecentAppBrandViewContainer.this.opu.setVisibility(8);
                    RecentAppBrandViewContainer.this.opu.setScaleX(1.0f);
                    RecentAppBrandViewContainer.this.opu.setScaleY(1.0f);
                    if (RecentAppBrandViewContainer.this.onn != null) {
                        RecyclerView.a adapter = RecentAppBrandViewContainer.this.onn.getAdapter();
                        int maxShowItemCountIncludeMore = RecentAppBrandViewContainer.this.onn.getMaxShowItemCountIncludeMore() - 1;
                        if (!(adapter == null || maxShowItemCountIncludeMore >= RecentAppBrandViewContainer.this.onn.getDataCount() || (zW = RecentAppBrandViewContainer.this.onn.zW(maxShowItemCountIncludeMore)) == null)) {
                            RecentAppBrandViewContainer.this.onn.getShowList().add(maxShowItemCountIncludeMore, zW);
                            adapter.cj(maxShowItemCountIncludeMore);
                        }
                    }
                    AppMethodBeat.o(227780);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        AppMethodBeat.o(49713);
    }
}
