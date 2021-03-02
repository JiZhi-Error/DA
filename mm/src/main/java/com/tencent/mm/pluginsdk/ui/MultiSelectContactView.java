package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MultiSelectContactView extends LinearLayout {
    ImageView Aww;
    int KcA = getResources().getDimensionPixelSize(R.dimen.aw);
    boolean KcB = false;
    MMEditText KcC;
    private RecyclerView Kct;
    private HashSet<String> Kcu;
    private Animation Kcv;
    private int Kcw = 0;
    private c Kcx;
    private d Kcy;
    private e Kcz;
    private View gvQ;
    private LayoutInflater kgB;
    private ArrayList<String> uae = new ArrayList<>();

    public interface c {
        void T(int i2, String str);
    }

    public interface d {
        void bey(String str);
    }

    public interface e {
        void goT();
    }

    static /* synthetic */ void a(MultiSelectContactView multiSelectContactView, String str) {
        AppMethodBeat.i(102798);
        multiSelectContactView.cY(str, true);
        AppMethodBeat.o(102798);
    }

    static /* synthetic */ void c(MultiSelectContactView multiSelectContactView) {
        AppMethodBeat.i(102799);
        multiSelectContactView.goQ();
        AppMethodBeat.o(102799);
    }

    static /* synthetic */ void g(MultiSelectContactView multiSelectContactView) {
        AppMethodBeat.i(102801);
        multiSelectContactView.goR();
        AppMethodBeat.o(102801);
    }

    public final void hYa() {
        AppMethodBeat.i(261603);
        if (this.KcC != null) {
            this.KcC.setHintTextColor(getResources().getColor(R.color.BW_100_Alpha_0_3));
            this.KcC.setTextColor(getResources().getColor(R.color.BW_100_Alpha_0_3));
        }
        AppMethodBeat.o(261603);
    }

    public final void hYb() {
        AppMethodBeat.i(261604);
        if (this.gvQ != null) {
            this.gvQ.setBackgroundColor(getResources().getColor(R.color.y));
        }
        AppMethodBeat.o(261604);
    }

    public MultiSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(102785);
        this.kgB = LayoutInflater.from(context);
        this.kgB.inflate(R.layout.beo, (ViewGroup) this, true);
        this.Kct = (RecyclerView) findViewById(R.id.fqw);
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        this.Kct.setLayoutManager(linearLayoutManager);
        this.Kct.setAdapter(new a());
        this.Kcu = new HashSet<>();
        this.Kcv = AnimationUtils.loadAnimation(context, R.anim.br);
        this.gvQ = findViewById(R.id.h8v);
        setBackgroundColor(context.getResources().getColor(R.color.f3045c));
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.MultiSelectContactView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(102774);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(102774);
            }
        });
        AppMethodBeat.o(102785);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(102786);
        super.onAttachedToWindow();
        AppMethodBeat.o(102786);
    }

    public void setOnContactDeselectListener(c cVar) {
        this.Kcx = cVar;
    }

    public void setOnSearchTextChangeListener(d dVar) {
        this.Kcy = dVar;
    }

    public void setOnSearchTextFouceChangeListener(e eVar) {
        this.Kcz = eVar;
    }

    public void clearFocus() {
        AppMethodBeat.i(102787);
        getInputText().clearFocus();
        goQ();
        AppMethodBeat.o(102787);
    }

    public final void it(List<String> list) {
        AppMethodBeat.i(102788);
        this.uae.clear();
        this.Kcu.clear();
        this.uae.addAll(list);
        this.Kcu.addAll(list);
        this.Kct.getAdapter().atj.notifyChanged();
        int itemCount = this.Kct.getAdapter().getItemCount();
        RecyclerView recyclerView = this.Kct;
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(itemCount - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
        goS();
        goR();
        AppMethodBeat.o(102788);
    }

    public final void bev(String str) {
        AppMethodBeat.i(102789);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(102789);
            return;
        }
        goQ();
        if (this.Kcu.contains(str)) {
            cY(str, false);
            AppMethodBeat.o(102789);
            return;
        }
        bex(str);
        AppMethodBeat.o(102789);
    }

    public final void bew(String str) {
        AppMethodBeat.i(102790);
        if (str != null) {
            cY(str, false);
            AppMethodBeat.o(102790);
            return;
        }
        AppMethodBeat.o(102790);
    }

    private void goQ() {
        AppMethodBeat.i(102791);
        if (this.Kct.getChildCount() == 1) {
            AppMethodBeat.o(102791);
            return;
        }
        View childAt = this.Kct.getChildAt(this.Kct.getChildCount() - 2);
        if (this.KcB) {
            if (childAt == null) {
                AppMethodBeat.o(102791);
                return;
            }
            this.KcB = false;
            View findViewById = childAt.findViewById(R.id.fa3);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        AppMethodBeat.o(102791);
    }

    public final void bex(String str) {
        AppMethodBeat.i(102792);
        this.Kcu.add(str);
        this.uae.add(str);
        int itemCount = this.Kct.getAdapter().getItemCount();
        this.Kct.getAdapter().cj(itemCount - 2);
        RecyclerView recyclerView = this.Kct;
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(itemCount - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
        goS();
        goR();
        if (this.Kcx != null) {
            this.Kcx.T(0, str);
        }
        AppMethodBeat.o(102792);
    }

    private void goR() {
        AppMethodBeat.i(102793);
        int max = Math.max(this.KcA * 2, this.Kct.getWidth() - ((this.uae.size() + 1) * this.KcA));
        if (!(getInputText() == null || getInputText().getWidth() == max)) {
            getInputText().setWidth(max);
        }
        AppMethodBeat.o(102793);
    }

    private void cY(String str, boolean z) {
        AppMethodBeat.i(102794);
        int indexOf = this.uae.indexOf(str);
        if (indexOf >= 0 && indexOf < this.uae.size()) {
            this.Kcu.remove(this.uae.remove(indexOf));
            this.Kct.getAdapter().ck(indexOf);
        }
        goS();
        goR();
        if (z && this.Kcx != null) {
            this.Kcx.T(1, str);
        }
        AppMethodBeat.o(102794);
    }

    private void goS() {
        AppMethodBeat.i(102795);
        if (getSearchIcon() != null) {
            getSearchIcon().setVisibility(this.Kct.getAdapter().getItemCount() <= 1 ? 0 : 8);
        }
        AppMethodBeat.o(102795);
    }

    public View getSearchIcon() {
        return this.Aww;
    }

    public String getSearchContent() {
        AppMethodBeat.i(102796);
        String obj = getInputText().getText().toString();
        AppMethodBeat.o(102796);
        return obj;
    }

    public void setHiddenSearchWord(String str) {
    }

    public EditText getInputText() {
        return this.KcC;
    }

    public b getSearchHolder() {
        AppMethodBeat.i(102797);
        b bVar = (b) this.Kct.k(this.Kct.getAdapter().getItemCount() - 1, false);
        AppMethodBeat.o(102797);
        return bVar;
    }

    class a extends RecyclerView.a<b> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            AppMethodBeat.i(102777);
            b bVar2 = bVar;
            if (getItemViewType(i2) != 1) {
                String str = (String) MultiSelectContactView.this.uae.get(i2);
                View view = bVar2.aus;
                view.findViewById(R.id.fa3).setVisibility(8);
                a.b.c(bVar2.gyr, str);
                bVar2.gyr.setContentDescription(((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str));
                view.setTag(str);
            }
            AppMethodBeat.o(102777);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(102775);
            if (i2 == getItemCount() - 1) {
                AppMethodBeat.o(102775);
                return 1;
            }
            AppMethodBeat.o(102775);
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(102776);
            int size = MultiSelectContactView.this.uae.size() + 1;
            AppMethodBeat.o(102776);
            return size;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(102778);
            if (i2 == 1) {
                b bVar = new b(MultiSelectContactView.this.kgB.inflate(R.layout.ben, (ViewGroup) null, false), i2);
                AppMethodBeat.o(102778);
                return bVar;
            }
            b bVar2 = new b(MultiSelectContactView.this.kgB.inflate(R.layout.bpe, (ViewGroup) null, false), i2);
            AppMethodBeat.o(102778);
            return bVar2;
        }
    }

    class b extends RecyclerView.v {
        ImageView gyr;

        public b(View view, int i2) {
            super(view);
            AppMethodBeat.i(102784);
            if (i2 != 1) {
                this.gyr = (ImageView) view.findViewById(R.id.wm);
                int i3 = MultiSelectContactView.this.KcA;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
                layoutParams.rightMargin = MultiSelectContactView.this.getResources().getDimensionPixelSize(R.dimen.f3062g);
                view.setLayoutParams(layoutParams);
                view.setOnClickListener(new View.OnClickListener(MultiSelectContactView.this) {
                    /* class com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(102779);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        MultiSelectContactView.a(MultiSelectContactView.this, (String) view.getTag());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(102779);
                    }
                });
                AppMethodBeat.o(102784);
                return;
            }
            MultiSelectContactView.this.Aww = (ImageView) view.findViewById(R.id.fqy);
            MultiSelectContactView.this.KcC = (MMEditText) view.findViewById(R.id.fqx);
            MultiSelectContactView.this.KcC.setWidth(MultiSelectContactView.this.getResources().getDisplayMetrics().widthPixels - (MultiSelectContactView.this.KcA * 2));
            com.tencent.mm.ui.tools.b.c.f(MultiSelectContactView.this.KcC).aoq(100).a((c.a) null);
            MultiSelectContactView.this.KcC.addTextChangedListener(new TextWatcher(MultiSelectContactView.this) {
                /* class com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b.AnonymousClass2 */

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    AppMethodBeat.i(102780);
                    MultiSelectContactView.c(MultiSelectContactView.this);
                    if (MultiSelectContactView.this.Kcy != null) {
                        MultiSelectContactView.this.Kcy.bey(charSequence.toString());
                    }
                    AppMethodBeat.o(102780);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
            MultiSelectContactView.this.KcC.setOnKeyListener(new View.OnKeyListener(MultiSelectContactView.this) {
                /* class com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b.AnonymousClass3 */

                public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    AppMethodBeat.i(102781);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.bm(keyEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                    if (i2 == 67 && keyEvent.getAction() == 0 && MultiSelectContactView.this.getInputText().getSelectionStart() == 0 && MultiSelectContactView.this.getInputText().getSelectionEnd() == 0) {
                        MultiSelectContactView.e(MultiSelectContactView.this);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(102781);
                    return false;
                }
            });
            MultiSelectContactView.this.KcC.clearFocus();
            MultiSelectContactView.this.KcC.setOnFocusChangeListener(new View.OnFocusChangeListener(MultiSelectContactView.this) {
                /* class com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b.AnonymousClass4 */

                public final void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(102782);
                    if (MultiSelectContactView.this.Kcz != null) {
                        MultiSelectContactView.this.Kcz.goT();
                    }
                    AppMethodBeat.o(102782);
                }
            });
            MultiSelectContactView.this.KcC.post(new Runnable(MultiSelectContactView.this) {
                /* class com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(102783);
                    MultiSelectContactView.g(MultiSelectContactView.this);
                    AppMethodBeat.o(102783);
                }
            });
            AppMethodBeat.o(102784);
        }
    }

    static /* synthetic */ void e(MultiSelectContactView multiSelectContactView) {
        AppMethodBeat.i(102800);
        if (multiSelectContactView.Kct.getChildCount() != 1) {
            View childAt = multiSelectContactView.Kct.getChildAt(multiSelectContactView.Kct.getChildCount() - 2);
            if (childAt == null || childAt.findViewById(R.id.fa3) == null) {
                AppMethodBeat.o(102800);
                return;
            }
            if (multiSelectContactView.KcB) {
                multiSelectContactView.cY((String) childAt.getTag(), true);
                multiSelectContactView.KcB = false;
            } else {
                multiSelectContactView.KcB = true;
                int itemCount = multiSelectContactView.Kct.getAdapter().getItemCount();
                RecyclerView recyclerView = multiSelectContactView.Kct;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(itemCount - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "scrollToLast", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "scrollToLast", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
                childAt.findViewById(R.id.fa3).setVisibility(0);
            }
            multiSelectContactView.getInputText().requestFocus();
        }
        AppMethodBeat.o(102800);
    }
}
