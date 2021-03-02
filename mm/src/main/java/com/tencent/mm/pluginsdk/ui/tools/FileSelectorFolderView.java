package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class FileSelectorFolderView extends LinearLayout implements AdapterView.OnItemClickListener {
    private a Kub = null;
    private b Kuc;
    boolean jT = false;
    private FrameLayout xpS;
    private View xpT;
    private ListView xpU;
    private boolean xpW = false;

    public interface a {
        void aiQ(int i2);
    }

    static /* synthetic */ void c(FileSelectorFolderView fileSelectorFolderView) {
        AppMethodBeat.i(31959);
        fileSelectorFolderView.pD(false);
        AppMethodBeat.o(31959);
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(31954);
        init();
        AppMethodBeat.o(31954);
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(31955);
        init();
        AppMethodBeat.o(31955);
    }

    /* access modifiers changed from: package-private */
    public final void pD(boolean z) {
        AppMethodBeat.i(31956);
        if (this.jT == z) {
            Log.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", Boolean.valueOf(this.jT));
            AppMethodBeat.o(31956);
        } else if (this.xpW) {
            Log.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", Boolean.valueOf(z));
            AppMethodBeat.o(31956);
        } else if (this.jT) {
            this.xpW = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f6do);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.AnonymousClass1 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(31948);
                    FileSelectorFolderView.this.xpS.setVisibility(8);
                    FileSelectorFolderView.this.jT = false;
                    FileSelectorFolderView.this.xpW = false;
                    AppMethodBeat.o(31948);
                }
            });
            this.xpU.startAnimation(loadAnimation);
            this.xpT.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bs));
            AppMethodBeat.o(31956);
        } else {
            this.xpW = true;
            this.xpS.setVisibility(0);
            this.xpT.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.br));
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.dq);
            loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.AnonymousClass2 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(31949);
                    FileSelectorFolderView.this.jT = true;
                    FileSelectorFolderView.this.xpW = false;
                    AppMethodBeat.o(31949);
                }
            });
            this.xpU.startAnimation(loadAnimation2);
            AppMethodBeat.o(31956);
        }
    }

    private void init() {
        AppMethodBeat.i(31957);
        setOrientation(1);
        this.xpS = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.xpS.setVisibility(8);
        addView(this.xpS, layoutParams);
        this.xpT = new View(getContext());
        this.xpT.setBackgroundColor(-872415232);
        this.xpT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(31950);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FileSelectorFolderView.c(FileSelectorFolderView.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31950);
            }
        });
        this.xpS.addView(this.xpT, new FrameLayout.LayoutParams(-1, -1));
        this.xpU = new ListView(getContext());
        this.xpU.setCacheColorHint(0);
        this.xpU.setBackgroundColor(getContext().getResources().getColor(R.color.f3048f));
        this.xpU.setSelector(R.drawable.aij);
        this.xpU.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ir);
        this.xpU.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, 0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.b9);
        layoutParams2.gravity = 80;
        this.xpS.addView(this.xpU, layoutParams2);
        this.Kuc = new b(getContext());
        this.xpU.setAdapter((ListAdapter) this.Kuc);
        AppMethodBeat.o(31957);
    }

    public void setListener(a aVar) {
        this.Kub = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(31958);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        if (this.Kub != null) {
            this.Kub.aiQ(i2);
        }
        this.xpT.performClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31958);
    }

    public static class b extends BaseAdapter {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return 2;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(31951);
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(31951);
            return valueOf;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(31952);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.alw, (ViewGroup) null);
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            switch (i2) {
                case 0:
                    cVar.titleTv.setText(R.string.cdv);
                    break;
                case 1:
                    cVar.titleTv.setText(R.string.cdw);
                    break;
                default:
                    cVar.titleTv.setText(R.string.ty);
                    break;
            }
            AppMethodBeat.o(31952);
            return view;
        }
    }

    static class c {
        TextView titleTv;

        c(View view) {
            AppMethodBeat.i(31953);
            this.titleTv = (TextView) view.findViewById(R.id.e40);
            AppMethodBeat.o(31953);
        }
    }
}
