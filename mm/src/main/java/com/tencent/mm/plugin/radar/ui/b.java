package com.tencent.mm.plugin.radar.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.pluginsdk.ui.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable;", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "tag", "", "(Ljava/lang/String;)V", "isCrop", "", "(Ljava/lang/String;Z)V", "notifyChanged", "", "Factory", "plugin-radar_release"})
public final class b extends j implements e.a {
    public /* synthetic */ b(String str, byte b2) {
        this(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private b(String str) {
        super(a.eHn(), str);
        a aVar = a.Bzu;
        AppMethodBeat.i(138590);
        AppMethodBeat.o(138590);
    }

    @Override // com.tencent.mm.aj.e.a, com.tencent.mm.pluginsdk.ui.j
    public final void Mr(String str) {
        AppMethodBeat.i(138589);
        p.h(str, "tag");
        super.Mr(str);
        AppMethodBeat.o(138589);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable$Factory;", "", "()V", "aLoader", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getALoader", "()Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "setALoader", "(Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;)V", "attach", "", "iv", "Landroid/widget/ImageView;", "tag", "", "setLoader", "loader", "plugin-radar_release"})
    public static final class a {
        private static j.a Bzt;
        public static final a Bzu = new a();

        static {
            AppMethodBeat.i(138588);
            AppMethodBeat.o(138588);
        }

        private a() {
        }

        public static j.a eHn() {
            return Bzt;
        }

        public static void a(j.a aVar) {
            AppMethodBeat.i(138586);
            p.h(aVar, "loader");
            Bzt = aVar;
            AppMethodBeat.o(138586);
        }

        public static void c(ImageView imageView, String str) {
            b bVar;
            AppMethodBeat.i(138587);
            p.h(imageView, "iv");
            p.h(str, "tag");
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                bVar = new b(str, (byte) 0);
            } else {
                bVar = (b) drawable;
            }
            bVar.setTag(str);
            imageView.setImageDrawable(bVar);
            AppMethodBeat.o(138587);
        }
    }
}
