package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.patmsg.a.c;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference extends Preference {
    private int KfX = -1;
    public q KfY;
    public s KfZ;

    public interface a {
        void amF();

        void e(ViewGroup viewGroup, int i2);

        void og(int i2);

        void oh(int i2);
    }

    public ContactListExpandPreference(Context context, int i2) {
        super(context);
        AppMethodBeat.i(152211);
        if (i2 == 0) {
            gpF();
        } else if (i2 == 1) {
            this.KfX = 1;
            this.KfZ = new s();
        }
        setLayoutResource(R.layout.b8x);
        AppMethodBeat.o(152211);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(152212);
        gpF();
        setLayoutResource(R.layout.b8x);
        AppMethodBeat.o(152212);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(152213);
        gpF();
        setLayoutResource(R.layout.b8x);
        AppMethodBeat.o(152213);
    }

    private void gpF() {
        AppMethodBeat.i(152214);
        this.KfX = 0;
        this.KfY = new q(this.mContext);
        AppMethodBeat.o(152214);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        ViewGroup viewGroup;
        View childAt;
        AppMethodBeat.i(152215);
        if (this.KfX == 1) {
            s sVar = this.KfZ;
            sVar.lJI = view;
            if (view.getId() == R.id.bce) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = (ViewGroup) view.findViewById(R.id.bce);
            }
            if (sVar.row == 0) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(R.dimen.i1), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(R.dimen.ib));
            } else if (sVar.row == (sVar.Kfo.getCount() / r.Kfx) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(R.dimen.i1));
            } else {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(R.dimen.ib), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(R.dimen.ib));
            }
            if ((sVar.Kfo.KfE % r.Kfx == r.Kfx - 1 || sVar.Kfo.KfE % r.Kfx == 0) && sVar.gue && sVar.row == (sVar.Kfo.getCount() / r.Kfx) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), 0);
            } else if (!sVar.gue && sVar.Kfo.KfE % r.Kfx == 0 && sVar.row == (sVar.Kfo.getCount() / r.Kfx) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), (int) viewGroup.getContext().getResources().getDimension(R.dimen.k5));
            }
            if (sVar.Kfo != null) {
                viewGroup.setOnClickListener(sVar.ko);
                if (viewGroup.getChildCount() > r.Kfx) {
                    viewGroup.removeViews(0, viewGroup.getChildCount() - r.Kfx);
                    viewGroup.requestLayout();
                }
                for (int i2 = 0; i2 < sVar.Kga; i2++) {
                    if (viewGroup.getChildAt(i2) == null) {
                        childAt = View.inflate(viewGroup.getContext(), R.layout.bnf, null);
                        viewGroup.addView(childAt);
                    } else {
                        childAt = viewGroup.getChildAt(i2);
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (r.Kfx == 4) {
                        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ir);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    } else {
                        int dimensionPixelSize2 = viewGroup.getResources().getDimensionPixelSize(R.dimen.ib);
                        layoutParams.setMargins(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                    }
                    if (!sVar.Kfo.gpC() && sVar.Kfo.KfE == 1) {
                        int dimensionPixelSize3 = viewGroup.getResources().getDimensionPixelSize(R.dimen.r);
                        layoutParams.setMargins(dimensionPixelSize3, 0, dimensionPixelSize3, 0);
                    }
                    childAt.setLayoutParams(layoutParams);
                    int i3 = (sVar.row * sVar.Kga) + i2;
                    sVar.Kfo.getView(i3, childAt, viewGroup);
                    if (sVar.Kfu != null) {
                        childAt.setOnClickListener(new View.OnClickListener(viewGroup, i3) {
                            /* class com.tencent.mm.pluginsdk.ui.applet.s.AnonymousClass3 */
                            final /* synthetic */ ViewGroup val$container;
                            final /* synthetic */ int vi;

                            {
                                this.val$container = r2;
                                this.vi = r3;
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.i(152231);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/applet/ContactListRow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                s.this.Kfu.m(this.val$container, this.vi);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ContactListRow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(152231);
                            }
                        });
                    }
                    if (sVar.Kgb != null) {
                        childAt.setOnLongClickListener(new View.OnLongClickListener(viewGroup, i3) {
                            /* class com.tencent.mm.pluginsdk.ui.applet.s.AnonymousClass4 */
                            final /* synthetic */ ViewGroup val$container;
                            final /* synthetic */ int vi;

                            {
                                this.val$container = r2;
                                this.vi = r3;
                            }

                            public final boolean onLongClick(View view) {
                                AppMethodBeat.i(152232);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/applet/ContactListRow$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                                boolean oi = s.this.Kgb.oi(this.vi);
                                com.tencent.mm.hellhoundlib.a.a.a(oi, this, "com/tencent/mm/pluginsdk/ui/applet/ContactListRow$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                                AppMethodBeat.o(152232);
                                return oi;
                            }
                        });
                    }
                    AvatarPatTipImageView avatarPatTipImageView = (AvatarPatTipImageView) childAt.findViewById(R.id.h8t);
                    avatarPatTipImageView.setOnDoubleClickListener(new c.a() {
                        /* class com.tencent.mm.pluginsdk.ui.applet.s.AnonymousClass5 */

                        @Override // com.tencent.mm.plugin.patmsg.a.c.a
                        public final boolean eF(View view) {
                            return !s.this.Kfn;
                        }
                    });
                    avatarPatTipImageView.setOnClickListener(new View.OnClickListener(viewGroup, i3) {
                        /* class com.tencent.mm.pluginsdk.ui.applet.s.AnonymousClass6 */
                        final /* synthetic */ ViewGroup val$container;
                        final /* synthetic */ int vi;

                        {
                            this.val$container = r2;
                            this.vi = r3;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(207175);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/applet/ContactListRow$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (s.this.Kfu != null) {
                                s.this.Kfu.m(this.val$container, this.vi);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ContactListRow$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(207175);
                        }
                    });
                }
                if (sVar.Kfo.gpC() || sVar.Kfo.KfE > 1) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else {
                    ((LinearLayout) viewGroup).setGravity(19);
                }
            }
        }
        super.onBindView(view);
        AppMethodBeat.o(152215);
    }

    public final void a(f fVar, String str) {
        AppMethodBeat.i(152216);
        if (this.KfY != null) {
            this.KfY.a(fVar, str);
        }
        AppMethodBeat.o(152216);
    }

    public final void a(e eVar) {
        if (this.KfY != null) {
            this.KfY.Kfo.KfF = eVar;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void notifyChanged() {
        AppMethodBeat.i(152217);
        if (this.KfY != null) {
            this.KfY.cax();
        }
        AppMethodBeat.o(152217);
    }

    public final void H(String str, List<String> list) {
        AppMethodBeat.i(152218);
        if (this.KfY != null) {
            this.KfY.H(str, list);
        }
        AppMethodBeat.o(152218);
    }

    public final void bg(ArrayList<as> arrayList) {
        AppMethodBeat.i(152219);
        if (this.KfY != null) {
            this.KfY.bg(arrayList);
        }
        AppMethodBeat.o(152219);
    }

    public final void gpG() {
        if (this.KfY != null) {
            this.KfY.Kfo.KfQ = false;
        }
    }

    public final void beT(String str) {
        if (this.KfY != null) {
            this.KfY.Kfo.KfM = str;
        }
    }

    public final boolean ail(int i2) {
        AppMethodBeat.i(152220);
        if (this.KfY != null) {
            boolean ail = this.KfY.Kfo.ail(i2);
            AppMethodBeat.o(152220);
            return ail;
        }
        AppMethodBeat.o(152220);
        return true;
    }

    public final boolean ain(int i2) {
        AppMethodBeat.i(152221);
        if (this.KfY != null) {
            boolean ain = this.KfY.Kfo.ain(i2);
            AppMethodBeat.o(152221);
            return ain;
        }
        AppMethodBeat.o(152221);
        return false;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(152222);
        if (this.KfY == null || !this.KfY.Kfo.ain(i2)) {
            AppMethodBeat.o(152222);
            return null;
        }
        Object item = this.KfY.Kfo.getItem(i2);
        AppMethodBeat.o(152222);
        return item;
    }

    public final String aio(int i2) {
        AppMethodBeat.i(152223);
        if (this.KfY == null || !this.KfY.Kfo.ain(i2)) {
            AppMethodBeat.o(152223);
            return "";
        }
        String str = ((as) this.KfY.Kfo.getItem(i2)).field_username;
        AppMethodBeat.o(152223);
        return str;
    }

    public final String aip(int i2) {
        AppMethodBeat.i(152224);
        if (this.KfY == null || !this.KfY.Kfo.ain(i2)) {
            AppMethodBeat.o(152224);
            return "";
        }
        String str = ((as) this.KfY.Kfo.getItem(i2)).field_nickname;
        AppMethodBeat.o(152224);
        return str;
    }

    public final String aiq(int i2) {
        AppMethodBeat.i(152225);
        if (this.KfY == null || !this.KfY.Kfo.ain(i2)) {
            AppMethodBeat.o(152225);
            return "";
        }
        String str = ((as) this.KfY.Kfo.getItem(i2)).field_conRemark;
        AppMethodBeat.o(152225);
        return str;
    }

    public final void gpE() {
        AppMethodBeat.i(152226);
        if (this.KfY != null) {
            this.KfY.Kfo.gpE();
        }
        AppMethodBeat.o(152226);
    }

    public final ContactListExpandPreference zU(boolean z) {
        if (this.KfY != null) {
            this.KfY.Kfo.KfH = z;
        }
        return this;
    }

    public final ContactListExpandPreference zV(boolean z) {
        if (this.KfY != null) {
            this.KfY.Kfo.KfG = z;
        }
        return this;
    }

    public final ContactListExpandPreference gpH() {
        if (this.KfY != null) {
            this.KfY.Kfo.KfI = false;
        }
        return this;
    }

    public final void gpA() {
        AppMethodBeat.i(152227);
        if (this.KfY != null) {
            this.KfY.gpA();
        }
        AppMethodBeat.o(152227);
    }

    public final void refresh() {
        AppMethodBeat.i(152228);
        if (this.KfY != null) {
            this.KfY.Kfo.amZ();
        }
        AppMethodBeat.o(152228);
    }

    public final void fm(List<String> list) {
        AppMethodBeat.i(152229);
        if (this.KfY != null) {
            this.KfY.Kfo.fm(list);
        }
        AppMethodBeat.o(152229);
    }

    public final void a(s.b bVar) {
        if (this.KfY != null) {
            this.KfY.Kfp = bVar;
        }
    }

    public final void a(a aVar) {
        if (this.KfY != null) {
            this.KfY.FjO = aVar;
        }
    }

    public final void zT(boolean z) {
        AppMethodBeat.i(207174);
        if (this.KfY != null) {
            this.KfY.zT(z);
        }
        if (this.KfZ != null) {
            this.KfZ.Kfn = z;
        }
        AppMethodBeat.o(207174);
    }
}
