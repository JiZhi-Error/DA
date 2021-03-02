package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0011R\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderLiveLogoAnim;", "Landroid/support/v7/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "setAnimType", "setVisibility", "visibility", "startAnim", "stopAnim", "Companion", "plugin-finder_release"})
public final class FinderLiveLogoAnim extends AppCompatImageView {
    private static final int wnq = 1;
    private static final int wnr = 2;
    private static final int wns = 3;
    public static final a wnt = new a((byte) 0);
    private final String TAG = "Finder.LiveLogoAnim";

    public final String getTAG() {
        return this.TAG;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderLiveLogoAnim$Companion;", "", "()V", "ANIM_CARD", "", "getANIM_CARD", "()I", "ANIM_RED", "getANIM_RED", "ANIM_WHITE", "getANIM_WHITE", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(254864);
        AppMethodBeat.o(254864);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLogoAnim(Context context, int i2) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(254861);
        setAnimType(i2);
        AppMethodBeat.o(254861);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLogoAnim(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254862);
        a(this);
        AppMethodBeat.o(254862);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLogoAnim(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254863);
        a(this);
        AppMethodBeat.o(254863);
    }

    private static /* synthetic */ void a(FinderLiveLogoAnim finderLiveLogoAnim) {
        AppMethodBeat.i(254856);
        finderLiveLogoAnim.setAnimType(wnq);
        AppMethodBeat.o(254856);
    }

    private final void setAnimType(int i2) {
        AppMethodBeat.i(254857);
        cEA();
        if (i2 == wnr) {
            setBackgroundResource(R.drawable.a_r);
            AppMethodBeat.o(254857);
        } else if (i2 == wns) {
            setBackgroundResource(R.drawable.a_p);
            AppMethodBeat.o(254857);
        } else {
            setBackgroundResource(R.drawable.a_q);
            AppMethodBeat.o(254857);
        }
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(254858);
        super.setVisibility(i2);
        if (i2 != 0) {
            cEA();
        }
        AppMethodBeat.o(254858);
    }

    public final void bWT() {
        AppMethodBeat.i(254859);
        Log.i(this.TAG, "startAnim");
        if (getBackground() instanceof AnimationDrawable) {
            Drawable background = getBackground();
            if (background == null) {
                t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                AppMethodBeat.o(254859);
                throw tVar;
            }
            ((AnimationDrawable) background).start();
        }
        AppMethodBeat.o(254859);
    }

    public final void cEA() {
        AppMethodBeat.i(254860);
        Log.i(this.TAG, "stopAnim");
        if (getBackground() instanceof AnimationDrawable) {
            Drawable background = getBackground();
            if (background == null) {
                t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                AppMethodBeat.o(254860);
                throw tVar;
            }
            AnimationDrawable animationDrawable = (AnimationDrawable) background;
            if (animationDrawable.isRunning()) {
                animationDrawable.stop();
            }
        }
        AppMethodBeat.o(254860);
    }
}
