package com.tencent.mm.plugin.radar;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.radar.ui.b;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/radar/SubCoreRadar;", "Lcom/tencent/mm/model/ISubCore;", "()V", "clearPluginData", "", "pluginFlag", "", "doRadar", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "updated", "", "onAccountRelease", "onSdcardMount", "mounted", "Companion", "plugin-radar_release"})
public final class b implements bd {
    public static final a Bya = new a((byte) 0);
    private static final String TAG = TAG;

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016J*\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b$b  reason: collision with other inner class name */
    public static final class C1619b implements j.a {
        private Bitmap Byb;
        private final com.tencent.mm.b.h<String, WeakReference<Bitmap>> Byc = new com.tencent.mm.b.h<>(15);
        private Bitmap dku;

        C1619b() {
            AppMethodBeat.i(138502);
            AppMethodBeat.o(138502);
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final void a(j jVar) {
            AppMethodBeat.i(138496);
            p.h(jVar, "drawable");
            if (jVar instanceof e.a) {
                com.tencent.mm.aj.p.aYn().a((e.a) jVar);
            }
            AppMethodBeat.o(138496);
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final Bitmap fZ(String str) {
            Bitmap bitmap;
            AppMethodBeat.i(138497);
            p.h(str, "tag");
            WeakReference weakReference = (WeakReference) this.Byc.get(str);
            if (!(weakReference == null || weakReference.get() == null)) {
                Object obj = weakReference.get();
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type android.graphics.Bitmap");
                    AppMethodBeat.o(138497);
                    throw tVar;
                } else if (!((Bitmap) obj).isRecycled() && !(!p.j((Bitmap) weakReference.get(), Wg()))) {
                    Bitmap bitmap2 = (Bitmap) weakReference.get();
                    AppMethodBeat.o(138497);
                    return bitmap2;
                }
            }
            Bitmap Mc = c.Mc(str);
            if (Mc == null || Mc.isRecycled()) {
                bitmap = eHf();
            } else {
                bitmap = BitmapUtil.getRoundedCornerBitmap(Mc, false, (float) (Mc.getWidth() / 2));
                this.Byc.x(str, new WeakReference<>(bitmap));
            }
            AppMethodBeat.o(138497);
            return bitmap;
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final Bitmap Wg() {
            AppMethodBeat.i(138498);
            if (this.dku == null) {
                try {
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    this.dku = BackwardSupportUtil.BitmapFactory.decodeStream(context.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
                } catch (IOException e2) {
                    Log.printErrStackTrace(b.TAG, e2, "", new Object[0]);
                }
            }
            Bitmap bitmap = this.dku;
            AppMethodBeat.o(138498);
            return bitmap;
        }

        private Bitmap eHf() {
            AppMethodBeat.i(138499);
            if (this.Byb == null && Wg() != null) {
                try {
                    Bitmap bitmap = this.dku;
                    Bitmap bitmap2 = this.dku;
                    if (bitmap2 == null) {
                        p.hyc();
                    }
                    this.Byb = BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) (bitmap2.getWidth() / 2));
                } catch (Exception e2) {
                    Log.printErrStackTrace(b.TAG, e2, "", new Object[0]);
                }
            }
            Bitmap bitmap3 = this.Byb;
            AppMethodBeat.o(138499);
            return bitmap3;
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final Bitmap ga(String str) {
            AppMethodBeat.i(138500);
            p.h(str, "tag");
            AppMethodBeat.o(138500);
            return null;
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final Bitmap a(String str, int i2, int i3, int i4) {
            AppMethodBeat.i(138501);
            p.h(str, "tag");
            AppMethodBeat.o(138501);
            return null;
        }
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(138503);
        b.a aVar = b.a.Bzu;
        b.a.a(new C1619b());
        AppMethodBeat.o(138503);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/SubCoreRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138504);
        AppMethodBeat.o(138504);
    }
}
