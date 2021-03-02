package com.tencent.mm.ui.contact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.e;
import java.lang.ref.WeakReference;

public class CategoryTipView extends RelativeLayout implements c {
    private long Dqp = 0;
    private TextView PUg = null;
    private int mStatus = 0;
    private String vPa = "";

    static /* synthetic */ boolean b(CategoryTipView categoryTipView) {
        AppMethodBeat.i(37677);
        boolean gUv = categoryTipView.gUv();
        AppMethodBeat.o(37677);
        return gUv;
    }

    public CategoryTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(37670);
        init();
        AppMethodBeat.o(37670);
    }

    public CategoryTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(37671);
        init();
        AppMethodBeat.o(37671);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        boolean z = true;
        AppMethodBeat.i(37672);
        super.onVisibilityChanged(view, i2);
        Object[] objArr = new Object[1];
        if (i2 != 0) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.d("MicroMsg.CategoryTipView", "visibility == View.VISIBLE : %s", objArr);
        if (i2 == 0) {
            this.vPa = e.avA("6");
        }
        AppMethodBeat.o(37672);
    }

    private void init() {
        AppMethodBeat.i(37673);
        LayoutInflater.from(getContext()).inflate(R.layout.cg, (ViewGroup) this, true);
        this.PUg = (TextView) findViewById(R.id.bdu);
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.CategoryTipView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(37668);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/ui/contact/CategoryTipView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (Util.ticksToNow(CategoryTipView.this.Dqp) < 1000) {
                    a.a(this, "com/tencent/mm/ui/contact/CategoryTipView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37668);
                    return;
                }
                CategoryTipView.this.Dqp = Util.currentTicks();
                if (CategoryTipView.b(CategoryTipView.this)) {
                    h hVar = h.FuH;
                    h.fqi().wU(CategoryTipView.this.vPa);
                    h hVar2 = h.FuH;
                    h.fqi().eQv = 6;
                    o.a(CategoryTipView.this.getContext(), ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().fnc(), null, null);
                }
                a.a(this, "com/tencent/mm/ui/contact/CategoryTipView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37668);
            }
        });
        ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().h(new WeakReference<>(this));
        AppMethodBeat.o(37673);
    }

    public final void anG(int i2) {
        AppMethodBeat.i(37674);
        this.mStatus = i2;
        if (gUv()) {
            int i3 = com.tencent.mm.n.h.aqJ().getInt("StoryShouldShowEntraceInFavorFriend", 1);
            if (i3 == 1 && (i2 & 1) != 0) {
                Log.i("MicroMsg.CategoryTipView", "%s showStoryCategory has new story %s", this, Integer.valueOf(i3));
                setVisibility(0);
                this.PUg.setVisibility(0);
                Drawable drawable = getContext().getResources().getDrawable(R.raw.icon_outlined_one_day_video_blue);
                drawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(getContext(), 20));
                this.PUg.setCompoundDrawables(null, null, drawable, null);
                this.PUg.invalidate();
                AppMethodBeat.o(37674);
            } else if (i3 != 1 || (i2 & 2) == 0) {
                setVisibility(8);
                this.PUg.setVisibility(8);
                AppMethodBeat.o(37674);
            } else {
                Log.i("MicroMsg.CategoryTipView", "%s showStoryCategory has story %s", this, Integer.valueOf(i3));
                setVisibility(0);
                this.PUg.setVisibility(0);
                Drawable m = ar.m(getContext(), R.raw.icons_outlined_one_day_video, getContext().getResources().getColor(R.color.fo));
                m.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(getContext(), 20));
                this.PUg.setCompoundDrawables(null, null, m, null);
                this.PUg.invalidate();
                AppMethodBeat.o(37674);
            }
        } else {
            setVisibility(8);
            this.PUg.setVisibility(8);
            AppMethodBeat.o(37674);
        }
    }

    private boolean gUv() {
        boolean z;
        AppMethodBeat.i(37675);
        Object tag = getTag();
        if (tag == null || !(tag instanceof Integer) || ((Integer) tag).intValue() != 32) {
            z = false;
        } else {
            z = true;
        }
        Log.d("MicroMsg.CategoryTipView", "%s isFavourHeader=%s", this, Boolean.valueOf(z));
        AppMethodBeat.o(37675);
        return z;
    }

    @Override // com.tencent.mm.plugin.story.api.c
    public final void aaD(final int i2) {
        AppMethodBeat.i(37676);
        Log.d("MicroMsg.CategoryTipView", "%s mStatus=%s newStatus=%s", this, Integer.valueOf(this.mStatus), Integer.valueOf(i2));
        if (getVisibility() == 0 && gUv() && this.mStatus != i2) {
            post(new Runnable() {
                /* class com.tencent.mm.ui.contact.CategoryTipView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(37669);
                    CategoryTipView.a(CategoryTipView.this, i2);
                    AppMethodBeat.o(37669);
                }
            });
        }
        AppMethodBeat.o(37676);
    }

    static /* synthetic */ void a(CategoryTipView categoryTipView, int i2) {
        AppMethodBeat.i(37678);
        Log.d("MicroMsg.CategoryTipView", "%s invalidateByStatus %s", categoryTipView, Integer.valueOf(i2));
        categoryTipView.anG(i2);
        categoryTipView.invalidate();
        AppMethodBeat.o(37678);
    }
}
