package com.tencent.mm.plugin.sight.draft.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class b extends s<j> {
    a Dom = new a(this, (byte) 0);
    private View$OnLongClickListenerC1697b Don = new View$OnLongClickListenerC1697b(this, (byte) 0);
    private c Doo = new c(this, (byte) 0);
    private Set<e> Dop = new HashSet();
    private d Doq = d.NORMAL;
    a Dor;
    int Dos = R.string.h21;
    int Dot = 0;
    private int Dou;
    private int Dov;
    private c Dow = new c() {
        /* class com.tencent.mm.plugin.sight.draft.ui.b.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.sight.draft.ui.c
        public final void s(String str, Bitmap bitmap) {
            AppMethodBeat.i(28666);
            Iterator it = b.this.Dop.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e eVar = (e) it.next();
                if (eVar.DoE != null && Util.nullAs(str, "").equals(eVar.DoE.field_fileName)) {
                    eVar.DoD.setThumbBmp(bitmap);
                    break;
                }
            }
            AppMethodBeat.o(28666);
        }
    };
    e Dox;
    private int kn;
    private int qmd;

    static /* synthetic */ void b(b bVar, e eVar) {
        AppMethodBeat.i(28684);
        bVar.a(eVar);
        AppMethodBeat.o(28684);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ j a(j jVar, Cursor cursor) {
        AppMethodBeat.i(28683);
        j jVar2 = jVar;
        if (jVar2 == null) {
            jVar2 = new j();
        }
        jVar2.convertFrom(cursor);
        AppMethodBeat.o(28683);
        return jVar2;
    }

    public enum d {
        NORMAL,
        EDIT;

        public static d valueOf(String str) {
            AppMethodBeat.i(28672);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(28672);
            return dVar;
        }

        static {
            AppMethodBeat.i(28673);
            AppMethodBeat.o(28673);
        }
    }

    public b(Context context, a aVar) {
        super(context, null);
        AppMethodBeat.i(28675);
        this.Dor = aVar;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.aj5) * 2;
        this.Dou = context.getResources().getDisplayMetrics().widthPixels / 3;
        this.qmd = this.Dou - dimensionPixelSize;
        this.kn = (this.qmd * 3) / 4;
        this.Dov = dimensionPixelSize + this.kn;
        AppMethodBeat.o(28675);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        f fVar;
        LinearLayout linearLayout;
        AppMethodBeat.i(28676);
        if (view == null) {
            f fVar2 = new f((byte) 0);
            LinearLayout linearLayout2 = new LinearLayout(viewGroup.getContext());
            linearLayout2.setOrientation(0);
            for (int i3 = 0; i3 < 3; i3++) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bsr, (ViewGroup) linearLayout2, false);
                e eVar = new e((byte) 0);
                eVar.jxm = inflate;
                eVar.jxm.setTag(eVar);
                eVar.DoC = inflate.findViewById(R.id.hrw);
                eVar.DoD = (com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.id.hs0);
                eVar.tlu = (ImageView) inflate.findViewById(R.id.hs1);
                eVar.Bnt = inflate.findViewById(R.id.hna);
                eVar.nnM = (TextView) inflate.findViewById(R.id.hrz);
                eVar.nnM.setText(this.Dos);
                eVar.DeA = (ImageView) inflate.findViewById(R.id.hrl);
                fVar2.DoF.add(eVar);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.height = this.Dov;
                linearLayout2.addView(inflate);
                inflate.setOnClickListener(this.Dom);
                eVar.DeA.setTag(eVar);
                eVar.DeA.setOnClickListener(this.Doo);
            }
            linearLayout2.setTag(fVar2);
            fVar = fVar2;
            linearLayout = linearLayout2;
        } else {
            fVar = (f) view.getTag();
            linearLayout = view;
        }
        for (int i4 = 0; i4 < fVar.DoF.size(); i4++) {
            int i5 = (i2 * 3) + i4;
            e eVar2 = fVar.DoF.get(i4);
            this.Dop.add(eVar2);
            eVar2.Bnt.setVisibility(8);
            eVar2.nnM.setVisibility(8);
            eVar2.tlu.setBackgroundResource(R.drawable.cnt);
            eVar2.DoD.e(null, false, 0);
            eVar2.DoD.setCanPlay(false);
            eVar2.DoD.setForceRecordState(false);
            ((ImageView) eVar2.DoD).setBackgroundResource(0);
            if (i5 >= getRealCount()) {
                eVar2.DoE = null;
                eVar2.jxm.setVisibility(4);
                com.tencent.mm.ui.tools.j.D(eVar2.DoC, 1.0f);
            } else {
                this.Dot--;
                j jVar = (j) getItem(i5);
                bg.aVF();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    eVar2.DoE = null;
                    eVar2.DoD.eVw();
                } else {
                    eVar2.DoE = jVar;
                    Bitmap z = this.Dow.z(jVar.field_fileName, k.Qi(jVar.field_fileName), this.Dot <= 0);
                    ((ImageView) eVar2.DoD).setScaleType(ImageView.ScaleType.CENTER_CROP);
                    eVar2.DoD.setThumbBmp(z);
                }
                if (d.EDIT == this.Doq) {
                    eVar2.DeA.setVisibility(0);
                    com.tencent.mm.ui.tools.j.D(eVar2.DoC, 0.95f);
                } else {
                    eVar2.DeA.setVisibility(8);
                    com.tencent.mm.ui.tools.j.D(eVar2.DoC, 1.0f);
                }
                eVar2.jxm.setVisibility(0);
            }
        }
        AppMethodBeat.o(28676);
        return linearLayout;
    }

    /* access modifiers changed from: package-private */
    public final void a(e eVar) {
        AppMethodBeat.i(28677);
        if (eVar == null) {
            for (e eVar2 : this.Dop) {
                eVar2.Bnt.setVisibility(8);
            }
            AppMethodBeat.o(28677);
            return;
        }
        Iterator<e> it = this.Dop.iterator();
        while (it.hasNext()) {
            e next = it.next();
            next.Bnt.setVisibility(eVar == next ? 8 : 0);
        }
        AppMethodBeat.o(28677);
    }

    /* access modifiers changed from: package-private */
    public class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.i(28667);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof e)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28667);
                return;
            }
            e eVar = (e) view.getTag();
            if (eVar.DoE == null) {
                Log.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", b.this.Doq);
                eVV();
                b.this.Dox = null;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28667);
                return;
            }
            if (b.this.Dox != eVar) {
                eVV();
                String Qh = k.Qh(eVar.DoE.field_fileName);
                eVar.DoD.setCanPlay(true);
                eVar.DoD.e(Qh, false, 0);
                eVar.tlu.setBackgroundResource(R.drawable.cnu);
                View view2 = eVar.DoC;
                if (view2 != null && !com.tencent.mm.compatible.util.d.oE(11)) {
                    Animator animator = (Animator) view2.getTag(R.id.glv);
                    if (animator != null) {
                        animator.cancel();
                    }
                    AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view2.getContext(), R.animator.f3013h);
                    animatorSet.setTarget(view2);
                    animatorSet.start();
                    view2.setTag(R.id.glv, animatorSet);
                }
                b.b(b.this, eVar);
                b.this.Dox = eVar;
            }
            if (b.this.Dor != null) {
                b.this.Dor.eVT();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28667);
        }

        public final boolean eVV() {
            AppMethodBeat.i(28668);
            if (b.this.Dox != null) {
                b.this.Dox.nnM.setVisibility(8);
                b.this.Dox.DoD.setCanPlay(false);
                b.this.Dox.DoD.e(null, false, 0);
                b.this.Dox.DoD.setThumbBmp(b.this.Dow.z(b.this.Dox.DoE.field_fileName, k.Qi(b.this.Dox.DoE.field_fileName), true));
                b.this.Dox.tlu.setBackgroundResource(R.drawable.cnt);
                com.tencent.mm.ui.tools.j.D(b.this.Dox.DoC, 1.0f);
                b.this.Dox = null;
                AppMethodBeat.o(28668);
                return true;
            }
            AppMethodBeat.o(28668);
            return false;
        }
    }

    public final boolean a(d dVar, boolean z) {
        AppMethodBeat.i(28678);
        if (dVar == this.Doq) {
            if (z && this.Dor != null) {
                this.Dor.eVU();
            }
            AppMethodBeat.o(28678);
            return false;
        }
        this.Doq = dVar;
        this.Dom.eVV();
        notifyDataSetChanged();
        if (z && this.Dor != null) {
            this.Dor.eVU();
        }
        AppMethodBeat.o(28678);
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.ui.s
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(28679);
        this.Dop.clear();
        super.onNotifyChange(str, mStorageEventData);
        AppMethodBeat.o(28679);
    }

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.b$b  reason: collision with other inner class name */
    class View$OnLongClickListenerC1697b implements View.OnLongClickListener {
        private View$OnLongClickListenerC1697b() {
        }

        /* synthetic */ View$OnLongClickListenerC1697b(b bVar, byte b2) {
            this();
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(28669);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (!(view.getTag() instanceof e)) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(28669);
            } else {
                e eVar = (e) view.getTag();
                if (eVar.DoE == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(28669);
                } else if (-1 == eVar.DoE.field_fileStatus) {
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(28669);
                } else {
                    b.this.a(d.EDIT, true);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(28669);
                }
            }
            return true;
        }
    }

    class c implements View.OnClickListener {
        private c() {
        }

        /* synthetic */ c(b bVar, byte b2) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.i(28670);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof e)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28670);
                return;
            }
            b.this.Dom.eVV();
            e eVar = (e) view.getTag();
            if (eVar.DoE == null) {
                Log.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28670);
                return;
            }
            eVar.DoE.field_fileStatus = 6;
            o.bhn().update(eVar.DoE, ch.COL_LOCALID);
            b.this.onNotifyChange(null, null);
            if (b.this.Dor != null) {
                a unused = b.this.Dor;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28670);
        }
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(28680);
        anq();
        super.notifyDataSetChanged();
        AppMethodBeat.o(28680);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(28681);
        setCursor(o.bhn().bhe());
        AppMethodBeat.o(28681);
    }

    @Override // com.tencent.mm.ui.s
    public final int getCount() {
        AppMethodBeat.i(28682);
        int count = (super.getCount() / 3) + 1;
        AppMethodBeat.o(28682);
        return count;
    }

    /* access modifiers changed from: package-private */
    public static final class e {
        View Bnt;
        ImageView DeA;
        View DoC;
        com.tencent.mm.plugin.sight.decode.a.a DoD;
        j DoE;
        View jxm;
        TextView nnM;
        ImageView tlu;

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }

    static final class f {
        List<e> DoF;

        private f() {
            AppMethodBeat.i(28674);
            this.DoF = new LinkedList();
            AppMethodBeat.o(28674);
        }

        /* synthetic */ f(byte b2) {
            this();
        }
    }
}
