package com.tencent.mm.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a extends LinearLayout {
    private FTSEditTextView Awv;
    private WeImageView OxK;
    private View QnU;
    private LinearLayout QnV;
    private LinearLayout QnW;
    private View QnX;
    private boolean QnY;
    private TextView QnZ;
    private b Qoa;
    private AbstractC2125a Qob;
    private View uvi;

    /* renamed from: com.tencent.mm.ui.search.a$a  reason: collision with other inner class name */
    public interface AbstractC2125a {
    }

    public interface b {
        void onClickBackBtn(View view);
    }

    public interface c extends Comparable {
        String getTagName();
    }

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b2) {
        super(context);
        AppMethodBeat.i(205358);
        this.QnY = false;
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.amv, (ViewGroup) this, true);
        this.QnV = (LinearLayout) findViewById(R.id.hdn);
        this.QnW = (LinearLayout) findViewById(R.id.dq3);
        this.uvi = findViewById(R.id.aib);
        this.uvi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.search.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(164204);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.Qoa != null) {
                    a.this.Qoa.onClickBackBtn(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(164204);
            }
        });
        this.OxK = (WeImageView) findViewById(R.id.he6);
        this.OxK.setVisibility(0);
        this.Awv = (FTSEditTextView) findViewById(R.id.db_);
        if (this.QnY) {
            this.QnX = findViewById(R.id.dba);
            this.QnX.setVisibility(0);
            this.QnX.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.search.a.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(164205);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.Qob != null) {
                        AbstractC2125a unused = a.this.Qob;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(164205);
                }
            });
        }
        AppMethodBeat.o(205358);
    }

    public final void gXh() {
        AppMethodBeat.i(205359);
        this.QnU = findViewById(R.id.xt);
        this.QnU.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.search.a.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(205356);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.Qoa != null) {
                    a.this.Qoa.onClickBackBtn(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(205356);
            }
        });
        this.QnU.setVisibility(0);
        this.uvi.setVisibility(8);
        this.QnV.setBackgroundColor(getResources().getColor(R.color.BW_93));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Awv.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.cb));
        this.Awv.setLayoutParams(layoutParams);
        AppMethodBeat.o(205359);
    }

    public final LinearLayout getSearchContainer() {
        return this.QnV;
    }

    public final void j(View.OnClickListener onClickListener) {
        AppMethodBeat.i(205360);
        this.QnV.setVisibility(8);
        this.QnW.setVisibility(0);
        this.QnZ = (TextView) findViewById(R.id.dq4);
        this.QnU = findViewById(R.id.xt);
        this.QnU.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.search.a.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(205357);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.Qoa != null) {
                    a.this.Qoa.onClickBackBtn(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(205357);
            }
        });
        this.QnW.setClickable(true);
        this.QnW.setOnClickListener(onClickListener);
        this.QnU.setVisibility(0);
        this.uvi.setVisibility(8);
        AppMethodBeat.o(205360);
    }

    public final void setSearchViewListener(b bVar) {
        this.Qoa = bVar;
    }

    public final void setImageSearchListener(AbstractC2125a aVar) {
        this.Qob = aVar;
    }

    public final FTSEditTextView getFtsEditText() {
        return this.Awv;
    }

    public final WeImageView getSearchIcon() {
        return this.OxK;
    }
}
