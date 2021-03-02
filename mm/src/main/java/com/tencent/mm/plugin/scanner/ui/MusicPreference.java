package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference extends Preference {
    public String CEJ;
    public String CEK;
    public String CEL;
    private ImageButton CKH;
    a CKI;
    private boolean gVd;
    private View.OnClickListener ko;
    private View mView;

    public interface a {
        void d(MusicPreference musicPreference);
    }

    public MusicPreference(Context context) {
        this(context, null);
    }

    public MusicPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(51808);
        this.mView = null;
        this.CKH = null;
        this.CEJ = "";
        this.CEK = "";
        this.CEL = "";
        setLayoutResource(R.layout.b_j);
        AppMethodBeat.o(51808);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(51809);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(51809);
        return view2;
    }

    public final void tV(boolean z) {
        AppMethodBeat.i(51810);
        this.gVd = z;
        if (this.CKH != null) {
            if (z) {
                this.CKH.setImageResource(R.drawable.aor);
                AppMethodBeat.o(51810);
                return;
            }
            this.CKH.setImageResource(R.drawable.aoq);
        }
        AppMethodBeat.o(51810);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(51811);
        super.onBindView(view);
        if (this.ko == null) {
            this.ko = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.MusicPreference.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(51807);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (MusicPreference.this.CKI == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(51807);
                        return;
                    }
                    if (view.getId() == R.id.gg0) {
                        if (MusicPreference.this.gVd) {
                            MusicPreference.this.gVd = false;
                            MusicPreference.this.CKH.setImageResource(R.drawable.aoq);
                        } else {
                            MusicPreference.this.gVd = true;
                            MusicPreference.this.CKH.setImageResource(R.drawable.aor);
                        }
                        MusicPreference.this.CKI.d(MusicPreference.this);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(51807);
                }
            };
        }
        this.CKH = (ImageButton) view.findViewById(R.id.gg0);
        this.CKH.setOnClickListener(this.ko);
        if (this.gVd) {
            this.CKH.setImageResource(R.drawable.aor);
            AppMethodBeat.o(51811);
            return;
        }
        this.CKH.setImageResource(R.drawable.aoq);
        AppMethodBeat.o(51811);
    }
}
