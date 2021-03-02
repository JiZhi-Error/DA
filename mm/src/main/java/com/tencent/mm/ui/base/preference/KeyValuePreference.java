package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference extends Preference {
    protected TextView BfZ;
    private int NIs;
    public String OFU;
    public boolean OYB;
    private boolean OYC;
    private boolean OYD;
    private boolean OYE;
    private int OYF;
    public int OYG;
    protected ImageView OYH;
    public Drawable OYI;
    private List<View> OYJ;
    public int OYK;
    int OYL;
    private View contentView;
    public float gPN;
    protected TextView titleTv;

    public KeyValuePreference(Context context) {
        this(context, null);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142578);
        this.OYB = true;
        this.OYC = false;
        this.OFU = null;
        this.OYD = false;
        this.OYE = false;
        this.NIs = 17;
        this.OYF = 17;
        this.OYG = 0;
        this.OYH = null;
        this.OYI = null;
        this.OYJ = new LinkedList();
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(142578);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142579);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9b, viewGroup2);
        AppMethodBeat.o(142579);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public void onBindView(View view) {
        LinearLayout linearLayout;
        AppMethodBeat.i(142580);
        super.onBindView(view);
        this.contentView = view.findViewById(R.id.h8z);
        if (this.OZp != null) {
            this.contentView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.base.preference.KeyValuePreference.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(142576);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    KeyValuePreference.this.OZp.a(KeyValuePreference.this);
                    a.a(this, "com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(142576);
                }
            });
        }
        if (this.OZq != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.ui.base.preference.KeyValuePreference.AnonymousClass2 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(142577);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    boolean eFh = KeyValuePreference.this.OZq.eFh();
                    a.a(eFh, this, "com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(142577);
                    return eFh;
                }
            });
        }
        this.BfZ = (TextView) view.findViewById(16908304);
        if (this.BfZ != null) {
            this.BfZ.setSingleLine(this.OYB);
            if (this.OYE) {
                this.BfZ.setGravity(this.OYF);
            }
        }
        if (this.OYC) {
            setWidgetLayoutResource(R.layout.b_t);
        }
        this.titleTv = (TextView) view.findViewById(16908310);
        if (!Util.isNullOrNil(this.OFU)) {
            this.titleTv.setText(this.OFU);
        }
        if (this.titleTv != null) {
            ViewGroup.LayoutParams layoutParams = this.titleTv.getLayoutParams();
            layoutParams.width = this.OYK == 0 ? com.tencent.mm.cb.a.aG(this.mContext, R.dimen.em) : this.OYK;
            this.titleTv.setLayoutParams(layoutParams);
        }
        this.OYH = (ImageView) view.findViewById(R.id.dvz);
        if (this.OYI != null) {
            this.OYH.setVisibility(this.OYG);
            this.OYH.setImageDrawable(this.OYI);
        } else {
            this.OYH.setVisibility(8);
        }
        if (this.OYD && (linearLayout = (LinearLayout) view.findViewById(R.id.be3)) != null) {
            linearLayout.setGravity(this.NIs);
        }
        if (this.OYJ.size() > 0) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ieh);
            linearLayout2.removeAllViews();
            for (View view2 : this.OYJ) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                }
                linearLayout2.addView(view2);
            }
        }
        if (this.gPN != 0.0f) {
            this.titleTv.setTextSize(this.gPN);
            this.BfZ.setTextSize(this.gPN);
        }
        if (this.OYL > 0) {
            this.BfZ.setMaxLines(this.OYL);
        }
        AppMethodBeat.o(142580);
    }

    public final void alL(int i2) {
        AppMethodBeat.i(142581);
        this.OYL = i2;
        if (this.BfZ != null) {
            this.BfZ.setMaxLines(this.OYL);
        }
        AppMethodBeat.o(142581);
    }

    public final void BC(boolean z) {
        AppMethodBeat.i(142582);
        this.OYC = z;
        if (this.OYC) {
            setWidgetLayoutResource(R.layout.b_t);
        }
        AppMethodBeat.o(142582);
    }

    public final void gLI() {
        this.OYE = true;
        this.OYF = 5;
    }

    public final void gLJ() {
        AppMethodBeat.i(142583);
        this.OYJ.clear();
        AppMethodBeat.o(142583);
    }

    public final void gz(View view) {
        AppMethodBeat.i(142584);
        this.OYJ.add(view);
        AppMethodBeat.o(142584);
    }

    public final void gLK() {
        this.OYD = true;
        this.NIs = 49;
    }
}
