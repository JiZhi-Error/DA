package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Map;

public final class b implements View.OnClickListener {
    private WeImageView DxZ;
    private WeImageView Dya;
    private TextView Dyb;
    private View Dyc;
    private View Dyd;
    private WeImageView Dye;
    private View Dyf;
    private WeImageView Dyg;
    private View Dyh;
    private WeImageView Dyi;
    private View Dyj;
    ViewGroup Dyk;
    View Dyl;
    private TextView Dym;
    c Dyn;
    private AbstractC1712b Dyo;
    private TextView ayz;
    private View jBN;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.sns.ad.timeline.feedback.b$b  reason: collision with other inner class name */
    public interface AbstractC1712b {
        Map<String, Object> aNQ(String str);
    }

    public interface c {
        void a(View view, int i2, Object obj);
    }

    public static class d {
        public final int Dyq;
        public final String Dyr;

        d(int i2, String str) {
            this.Dyq = i2;
            this.Dyr = str;
        }
    }

    b(Context context, AbstractC1712b bVar, c cVar) {
        this.mContext = context;
        this.Dyo = bVar;
        this.Dyn = cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0204  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eY(android.view.View r12) {
        /*
        // Method dump skipped, instructions count: 571
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ad.timeline.feedback.b.eY(android.view.View):void");
    }

    public final void onClick(View view) {
        AppMethodBeat.i(202168);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        int id = view.getId();
        if (id == R.id.hup) {
            if (this.Dyk != null && this.Dyk.getChildCount() > 0) {
                this.Dyk.setVisibility(0);
                if (this.Dyj != null) {
                    this.Dyj.setVisibility(8);
                }
                if (this.ayz != null) {
                    this.ayz.setTextColor(com.tencent.mm.cb.a.n(this.ayz.getContext(), R.color.a8h));
                    this.ayz.setText(R.string.h4d);
                }
                if (this.Dym != null) {
                    this.Dym.setTextColor(com.tencent.mm.cb.a.n(this.Dym.getContext(), R.color.a8f));
                    this.Dym.setText(this.Dym.getContext().getString(R.string.h4e));
                }
            }
            if (this.Dyn != null) {
                com.tencent.mm.plugin.sns.data.c eXO = eXO();
                if (eXO != null) {
                    view.setTag(eXO);
                }
                this.Dyn.a(view, 1, null);
            }
        } else if (id == R.id.hue) {
            if (this.Dyn != null) {
                this.Dyn.a(view, 2, null);
            }
        } else if (id == R.id.hug) {
            if (this.Dyn != null) {
                this.Dyn.a(view, 3, null);
            }
        } else if (id == R.id.hui && this.Dyn != null) {
            com.tencent.mm.plugin.sns.data.c eXO2 = eXO();
            if (eXO2 != null) {
                view.setTag(eXO2);
            }
            this.Dyn.a(view, 4, null);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202168);
    }

    private com.tencent.mm.plugin.sns.data.c eXO() {
        AppMethodBeat.i(202169);
        Object obj = this.Dyo.aNQ("unlike_tag").get("unlike_tag");
        if (obj instanceof com.tencent.mm.plugin.sns.data.c) {
            com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) obj;
            AppMethodBeat.o(202169);
            return cVar;
        }
        AppMethodBeat.o(202169);
        return null;
    }

    public final void XM(int i2) {
        AppMethodBeat.i(202170);
        if (!(this.DxZ == null || this.Dya == null)) {
            if (i2 < 0) {
                this.DxZ.setVisibility(8);
                this.Dya.setVisibility(0);
                AppMethodBeat.o(202170);
                return;
            }
            this.DxZ.setVisibility(0);
            this.Dya.setVisibility(8);
        }
        AppMethodBeat.o(202170);
    }

    class a implements View.OnClickListener {
        a() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(202166);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            try {
                ViewGroup viewGroup = b.this.Dyk;
                if (viewGroup != null) {
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        viewGroup.getChildAt(i2).setSelected(false);
                    }
                }
                view.setSelected(true);
                if (b.this.Dyl != null) {
                    b.this.Dyl.setVisibility(0);
                }
                c cVar = b.this.Dyn;
                if (cVar != null) {
                    cVar.a(view, 5, view.getTag(R.id.hub));
                }
            } catch (Throwable th) {
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(202166);
        }
    }
}
