package com.tencent.mm.plugin.transvoice.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.transvoice.ui.a.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.au;
import java.util.ArrayList;

public class LanguageChoiceLayout extends RelativeLayout {
    private RecyclerView Gun = null;
    public com.tencent.mm.plugin.transvoice.ui.a.a Guo = null;
    private a Gup = null;
    private Button hPX = null;
    private View hRx = null;
    private Button hSq = null;
    public ViewGroup hSz = null;

    public interface a {
        void acq(int i2);
    }

    public LanguageChoiceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(185271);
        init();
        AppMethodBeat.o(185271);
    }

    public LanguageChoiceLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(185272);
        init();
        AppMethodBeat.o(185272);
    }

    private void init() {
        AppMethodBeat.i(185273);
        View.inflate(getContext(), R.layout.bg3, this);
        this.hSz = (ViewGroup) findViewById(R.id.fy9);
        this.hSq = (Button) findViewById(R.id.fy8);
        this.hPX = (Button) findViewById(R.id.fyb);
        this.hRx = findViewById(R.id.fy7);
        this.Gun = (RecyclerView) findViewById(R.id.fya);
        this.Guo = new com.tencent.mm.plugin.transvoice.ui.a.a();
        RecyclerView recyclerView = this.Gun;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.Gun.setAdapter(this.Guo);
        fAx();
        this.hSz.setTranslationY((float) au.az(getContext()).y);
        this.hRx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(185265);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LanguageChoiceLayout.this.fAy();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(185265);
            }
        });
        this.hSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(185266);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LanguageChoiceLayout.this.fAy();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(185266);
            }
        });
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(185267);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (LanguageChoiceLayout.this.Gup != null) {
                    LanguageChoiceLayout.this.Gup.acq(LanguageChoiceLayout.this.Guo.Gwo);
                }
                LanguageChoiceLayout.this.fAy();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(185267);
            }
        });
        AppMethodBeat.o(185273);
    }

    private void fAx() {
        AppMethodBeat.i(185274);
        ArrayList arrayList = new ArrayList();
        int i2 = h.aqJ().getInt("VoiceInputLanguageSupportType", g.jwq);
        if (LocaleUtil.isChineseAppLang()) {
            arrayList.add(new a.C1843a(getContext().getString(R.string.ec2), g.jwq));
            if ((g.jwr & i2) != 0) {
                arrayList.add(new a.C1843a(getContext().getString(R.string.ec0), g.jwr));
            }
            if ((g.jws & i2) != 0) {
                arrayList.add(new a.C1843a(getContext().getString(R.string.ec1), g.jws));
            }
            if ((i2 & g.jwt) != 0) {
                arrayList.add(new a.C1843a(getContext().getString(R.string.ec3), g.jwt));
            }
        } else if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.ENGLISH)) {
            arrayList.add(new a.C1843a(getContext().getString(R.string.ec1), g.jws));
            arrayList.add(new a.C1843a(getContext().getString(R.string.ec2), g.jwq));
            if ((i2 & g.jwr) != 0) {
                arrayList.add(new a.C1843a(getContext().getString(R.string.ec0), g.jwr));
            }
        }
        this.Guo.hy(arrayList);
        this.Guo.atj.notifyChanged();
        AppMethodBeat.o(185274);
    }

    public void setSelectLanguageListener(a aVar) {
        this.Gup = aVar;
    }

    public final void fAy() {
        AppMethodBeat.i(185275);
        this.hSz.animate().translationY((float) au.az(getContext()).y).setDuration(200).setListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.AnonymousClass5 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(185270);
                LanguageChoiceLayout.this.setVisibility(8);
                AppMethodBeat.o(185270);
            }
        }).start();
        AppMethodBeat.o(185275);
    }

    public void setSelectedLang(int i2) {
        AppMethodBeat.i(185276);
        if (this.Guo != null) {
            this.Guo.Gwo = i2;
            this.Guo.atj.notifyChanged();
        }
        AppMethodBeat.o(185276);
    }
}
