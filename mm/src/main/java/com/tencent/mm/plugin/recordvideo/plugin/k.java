package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001.B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\b\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020!H\u0016J\b\u0010)\u001a\u00020!H\u0016J\b\u0010*\u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n \n*\u0004\u0018\u00010\u00130\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\n \n*\u0004\u0018\u00010\u00130\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getRotateImg", "()Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getUnDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"})
public final class k implements View.OnClickListener, t {
    public final ViewGroup BQB = ((ViewGroup) this.wgR.findViewById(R.id.dce));
    public final ViewGroup BQC = ((ViewGroup) this.wgR.findViewById(R.id.bie));
    public final ImageView BQD = ((ImageView) this.wgR.findViewById(R.id.bii));
    public final ImageView BQE = ((ImageView) this.wgR.findViewById(R.id.bih));
    public a BQF = a.DEFAULT;
    private Context context = this.wgR.getContext();
    private final Button hPX = ((Button) this.wgR.findViewById(R.id.bid));
    private final Button hSq = ((Button) this.wgR.findViewById(R.id.bib));
    public ViewGroup wgR;
    private d wgr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$FuncType;", "", "(Ljava/lang/String;I)V", "CROP_FUNC", "NORMAL_FUNC", "DEFAULT", "plugin-recordvideo_release"})
    public enum a {
        CROP_FUNC,
        NORMAL_FUNC,
        DEFAULT;

        static {
            AppMethodBeat.i(75542);
            AppMethodBeat.o(75542);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(75544);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(75544);
            return aVar;
        }
    }

    public k(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "view");
        p.h(dVar, "status");
        AppMethodBeat.i(75555);
        this.wgR = viewGroup;
        this.wgr = dVar;
        View findViewById = this.wgR.findViewById(R.id.bw2);
        int aD = au.aD(this.wgR.getContext());
        p.g(findViewById, "root");
        findViewById.setPadding(0, 0, 0, aD + findViewById.getPaddingBottom());
        this.BQD.setImageDrawable(ar.m(this.wgR.getContext(), R.raw.icons_filled_undo, -1));
        this.BQE.setImageDrawable(ar.m(this.wgR.getContext(), R.raw.icons_filled_rotate, -1));
        this.hSq.setOnClickListener(this);
        this.hPX.setOnClickListener(this);
        this.BQD.setOnClickListener(this);
        this.BQE.setOnClickListener(this);
        eKC();
        AppMethodBeat.o(75555);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237291);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237291);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75551);
        if (this.wgR.getVisibility() == i2) {
            AppMethodBeat.o(75551);
            return;
        }
        this.wgR.clearAnimation();
        if (i2 == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.n);
            loadAnimation.setAnimationListener(new b(this, i2));
            this.wgR.startAnimation(loadAnimation);
            AppMethodBeat.o(75551);
            return;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.context, R.anim.o);
        loadAnimation2.setAnimationListener(new c(this, i2));
        this.wgR.startAnimation(loadAnimation2);
        AppMethodBeat.o(75551);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
    public static final class b implements Animation.AnimationListener {
        final /* synthetic */ k BQK;
        final /* synthetic */ int hRm;

        b(k kVar, int i2) {
            this.BQK = kVar;
            this.hRm = i2;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(75545);
            p.h(animation, "animation");
            AppMethodBeat.o(75545);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(75546);
            p.h(animation, "animation");
            this.BQK.wgR.setVisibility(this.hRm);
            AppMethodBeat.o(75546);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.i(75547);
            p.h(animation, "animation");
            AppMethodBeat.o(75547);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
    public static final class c implements Animation.AnimationListener {
        final /* synthetic */ k BQK;
        final /* synthetic */ int hRm;

        c(k kVar, int i2) {
            this.BQK = kVar;
            this.hRm = i2;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(75548);
            p.h(animation, "animation");
            AppMethodBeat.o(75548);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(75549);
            p.h(animation, "animation");
            this.BQK.wgR.setVisibility(this.hRm);
            AppMethodBeat.o(75549);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.i(75550);
            p.h(animation, "animation");
            AppMethodBeat.o(75550);
        }
    }

    public final void eKC() {
        AppMethodBeat.i(75552);
        this.BQF = a.NORMAL_FUNC;
        ViewGroup viewGroup = this.BQB;
        p.g(viewGroup, "normalFuncLayout");
        viewGroup.setVisibility(0);
        ViewGroup viewGroup2 = this.BQC;
        p.g(viewGroup2, "cropFuncLayout");
        viewGroup2.setVisibility(4);
        AppMethodBeat.o(75552);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(75553);
        if (this.BQF == a.CROP_FUNC) {
            this.BQF = a.DEFAULT;
            d.b.a(this.wgr, d.c.BVO);
            AppMethodBeat.o(75553);
            return true;
        }
        AppMethodBeat.o(75553);
        return false;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(75554);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.bib) {
            ViewGroup viewGroup = this.BQB;
            p.g(viewGroup, "normalFuncLayout");
            viewGroup.setVisibility(0);
            ViewGroup viewGroup2 = this.BQC;
            p.g(viewGroup2, "cropFuncLayout");
            viewGroup2.setVisibility(4);
            d.b.a(this.wgr, d.c.BVO);
        } else if (valueOf != null && valueOf.intValue() == R.id.bid) {
            ViewGroup viewGroup3 = this.BQB;
            p.g(viewGroup3, "normalFuncLayout");
            viewGroup3.setVisibility(0);
            ViewGroup viewGroup4 = this.BQC;
            p.g(viewGroup4, "cropFuncLayout");
            viewGroup4.setVisibility(4);
            this.BQF = a.NORMAL_FUNC;
            d.b.a(this.wgr, d.c.BVP);
        } else if (valueOf != null && valueOf.intValue() == R.id.bii) {
            d.b.a(this.wgr, d.c.BVR);
        } else if (valueOf != null && valueOf.intValue() == R.id.bih) {
            d.b.a(this.wgr, d.c.BVQ);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75554);
    }
}
