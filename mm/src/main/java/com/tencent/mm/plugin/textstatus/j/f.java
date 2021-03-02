package com.tencent.mm.plugin.textstatus.j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004J,\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015J\u001c\u0010\u0018\u001a\u00020\u000f2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001aJ\u0018\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/util/UIHelper;", "", "()V", "TAG", "", "blurBitmap", "Landroid/graphics/Bitmap;", "bitmap", "context", "Landroid/content/Context;", "blurRadius", "", "getAvatarBitmap", ch.COL_USERNAME, "recurSetTextColor", "", "v", "Landroid/view/View;", "textColor", "", "oriMap", "", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "resetOriTextColor", "map", "", "roundCorner", "view", "cornerRadius", "plugin-textstatus_release"})
public final class f {
    public static final f Ggk = new f();

    static {
        AppMethodBeat.i(216708);
        AppMethodBeat.o(216708);
    }

    private f() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/textstatus/util/UIHelper$roundCorner$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-textstatus_release"})
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ float Ggl;

        a(float f2) {
            this.Ggl = f2;
        }

        public final void getOutline(View view, Outline outline) {
            AppMethodBeat.i(216701);
            p.h(view, "view");
            p.h(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.Ggl);
            AppMethodBeat.o(216701);
        }
    }

    public static void B(View view, float f2) {
        AppMethodBeat.i(216702);
        if (view != null) {
            view.setOutlineProvider(new a(f2));
        }
        if (view != null) {
            view.setClipToOutline(true);
            AppMethodBeat.o(216702);
            return;
        }
        AppMethodBeat.o(216702);
    }

    public static /* synthetic */ Bitmap a(Bitmap bitmap, Context context) {
        AppMethodBeat.i(216704);
        Bitmap a2 = a(bitmap, context, 3.5f);
        AppMethodBeat.o(216704);
        return a2;
    }

    public static Bitmap a(Bitmap bitmap, Context context, float f2) {
        Bitmap copy;
        AppMethodBeat.i(216703);
        p.h(context, "context");
        try {
            com.tencent.mm.ui.blur.f fVar = new com.tencent.mm.ui.blur.f(context);
            if (bitmap == null || (copy = bitmap.copy(bitmap.getConfig(), true)) == null) {
                AppMethodBeat.o(216703);
                return null;
            }
            Bitmap b2 = fVar.b(copy, f2);
            fVar.destroy();
            AppMethodBeat.o(216703);
            return b2;
        } catch (Throwable th) {
            AppMethodBeat.o(216703);
            return bitmap;
        }
    }

    public static Bitmap aTs(String str) {
        AppMethodBeat.i(216705);
        Bitmap K = com.tencent.mm.aj.p.aYD().K(str, false);
        if (K == null && p.j(com.tencent.mm.plugin.auth.a.a.ceA(), str)) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            com.tencent.mm.plugin.auth.a.a.ceA();
            K = com.tencent.mm.aj.e.Mq((String) aAh.azQ().i(ar.a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING));
        }
        if (K == null) {
            Log.e("MicroMsg.TxtStatus.UIHelper", "[getAvatarFromFile] bitmap=null");
        }
        AppMethodBeat.o(216705);
        return K;
    }

    public static void aT(Map<TextView, ? extends ColorStateList> map) {
        AppMethodBeat.i(216706);
        if (map == null) {
            AppMethodBeat.o(216706);
            return;
        }
        for (Map.Entry<TextView, ? extends ColorStateList> entry : map.entrySet()) {
            entry.getKey().setTextColor((ColorStateList) entry.getValue());
        }
        AppMethodBeat.o(216706);
    }

    public final void a(View view, int i2, Map<TextView, ColorStateList> map) {
        AppMethodBeat.i(216707);
        p.h(map, "oriMap");
        if (view == null) {
            AppMethodBeat.o(216707);
            return;
        }
        if (view instanceof ViewGroup) {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                a(((ViewGroup) view).getChildAt(i3), i2, map);
            }
        } else if (view instanceof TextView) {
            ColorStateList textColors = ((TextView) view).getTextColors();
            p.g(textColors, "v.textColors");
            map.put(view, textColors);
            ((TextView) view).setTextColor(i2);
        }
        AppMethodBeat.o(216707);
    }
}
