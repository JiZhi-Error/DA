package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\r0\fH\u0016J3\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\r0\fH\u0002J@\u0010\u0012\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\r0\fH\u0016JL\u0010\u0016\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\r0\fH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0004\n\u0002\b\u0006¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "()V", "TAG", "", "TAG$1", "clear", "", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "Companion", "plugin-emojisdk_release"})
public final class b extends com.tencent.mm.loader.b.a.a<a> {
    private static final String TAG = TAG;
    public static final a gVC = new a((byte) 0);
    private final String gVB = "MicroMsg.EmojiThumbLoader";

    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<a> aVar, f<?> fVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        AppMethodBeat.i(105381);
        p.h(aVar, "url");
        p.h(fVar, "httpResponse");
        p.h(eVar, "opts");
        p.h(fVar2, "reaper");
        AppMethodBeat.o(105381);
        return true;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<a> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(105382);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        AppMethodBeat.o(105382);
        return true;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<a> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(105383);
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.b.a ah = g.ah(d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        com.tencent.mm.pluginsdk.a.e provider = ((d) ah).getProvider();
        p.g(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        String sb2 = sb.append(provider.getAccPath()).append("emoji/").toString();
        String hYf = aVar.value().gVA.hYf();
        p.g(hYf, "url.value().groupInfo.productID");
        String I = p.I(a.j(sb2, hYf, ""), "_panel_enable");
        if (s.YS(I)) {
            com.tencent.mm.loader.h.b.a Hk = com.tencent.mm.loader.h.b.a.Hk(I);
            AppMethodBeat.o(105383);
            return Hk;
        }
        AppMethodBeat.o(105383);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache$Companion;", "", "()V", "TAG", "", "getIconPath", "rootPath", "productId", "url", "getMD5", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String j(String str, String str2, String str3) {
            String str4 = null;
            AppMethodBeat.i(183951);
            p.h(str, "rootPath");
            p.h(str2, "productId");
            p.h(str3, "url");
            if (!Util.isNullOrNil(str2) || !Util.isNullOrNil(str3)) {
                String ao = ao(str2, str3);
                if (!Util.isNullOrNil(ao)) {
                    if (Util.isNullOrNil(str2)) {
                        StringBuilder append = new StringBuilder().append(str);
                        if (ao == null) {
                            p.hyc();
                        }
                        str4 = append.append(ao).toString();
                    } else {
                        str4 = str + str2 + FilePathGenerator.ANDROID_DIR_SEP + ao;
                    }
                }
                AppMethodBeat.o(183951);
            } else {
                Log.w(b.TAG, "[cpan] get icon path failed. productid and url are null.");
                AppMethodBeat.o(183951);
            }
            return str4;
        }

        private static String ao(String str, String str2) {
            String messageDigest;
            AppMethodBeat.i(183952);
            p.h(str, "productId");
            p.h(str2, "url");
            if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
                if (Util.isNullOrNil(str2)) {
                    byte[] bytes = str.getBytes(kotlin.n.d.UTF_8);
                    p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                    messageDigest = com.tencent.mm.b.g.getMessageDigest(bytes);
                } else {
                    byte[] bytes2 = str2.getBytes(kotlin.n.d.UTF_8);
                    p.g(bytes2, "(this as java.lang.String).getBytes(charset)");
                    messageDigest = com.tencent.mm.b.g.getMessageDigest(bytes2);
                }
                AppMethodBeat.o(183952);
                return messageDigest;
            }
            Log.e(b.TAG, "[cpan] product id and url are null.");
            AppMethodBeat.o(183952);
            return null;
        }
    }

    static {
        AppMethodBeat.i(183953);
        AppMethodBeat.o(183953);
    }
}
