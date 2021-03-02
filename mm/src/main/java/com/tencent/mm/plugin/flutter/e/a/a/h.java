package com.tencent.mm.plugin.flutter.e.a.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\f¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorEmojiGroupInfoListFetcher;", "", "()V", "bitmapToByteArray", "", "bitmap", "Landroid/graphics/Bitmap;", "getAllGroupInfo", "", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getCustomEmojiBase64FromMd5", "md5", "", "getDesignerInfo", "Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "productId", "getDownloadCustomEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getEmojiAsBase64", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/EmojiInfo;", "getEmojiGifFromMd5", "getEmojiInfoList", "getEmojinName", "getGifSizeFromMd5", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/GifSize;", "getSystemEmojiMd5List", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showEmojiGroupDetail", "", "Companion", "plugin-flutter_release"})
public final class h {
    private static h wKa;
    public static final a wKb = new a((byte) 0);

    static {
        AppMethodBeat.i(241085);
        AppMethodBeat.o(241085);
    }

    private h() {
    }

    public /* synthetic */ h(byte b2) {
        this();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorEmojiGroupInfoListFetcher$Companion;", "", "()V", "mInstance", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorEmojiGroupInfoListFetcher;", "getInstance", "plugin-flutter_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static h dLW() {
            AppMethodBeat.i(241073);
            if (h.wKa == null) {
                h.wKa = new h((byte) 0);
            }
            h hVar = h.wKa;
            if (hVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(241073);
            return hVar;
        }
    }

    public static List<EmojiGroupInfo> dLS() {
        AppMethodBeat.i(241074);
        j auL = j.auL();
        p.g(auL, "EmojiStorageCache.getInstance()");
        ArrayList<EmojiGroupInfo> auP = auL.auP();
        p.g(auP, "EmojiStorageCache.getInstance().emojiGroupInfoList");
        ArrayList<EmojiGroupInfo> arrayList = auP;
        AppMethodBeat.o(241074);
        return arrayList;
    }

    public static List<EmojiInfo> axq(String str) {
        AppMethodBeat.i(241075);
        ArrayList<EmojiInfo> EQ = j.auL().EQ(str);
        p.g(EQ, "EmojiStorageCache.getIns…tEmojiInfoList(productId)");
        ArrayList<EmojiInfo> arrayList = EQ;
        AppMethodBeat.o(241075);
        return arrayList;
    }

    public static List<EmojiInfo> dLT() {
        AppMethodBeat.i(241076);
        ArrayList<EmojiInfo> auO = j.auL().auO();
        p.g(auO, "EmojiStorageCache.getIns….getDownloadCustomEmoji()");
        ArrayList<EmojiInfo> arrayList = auO;
        AppMethodBeat.o(241076);
        return arrayList;
    }

    public static ArrayList<String> dLU() {
        AppMethodBeat.i(241077);
        ArrayList<EmojiInfo> dT = j.auL().dT(true);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<EmojiInfo> it = dT.iterator();
        while (it.hasNext()) {
            EmojiInfo next = it.next();
            if (next.field_catalog == EmojiGroupInfo.VkO) {
                p.g(next, "emojiInfo");
                arrayList.add(next.getMd5());
            }
        }
        AppMethodBeat.o(241077);
        return arrayList;
    }

    public static byte[] axr(String str) {
        AppMethodBeat.i(241078);
        p.h(str, "md5");
        EmojiInfo amm = ((d) g.ah(d.class)).getEmojiMgr().amm(str);
        com.tencent.mm.kernel.b.a ah = g.ah(d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        byte[] a2 = ((d) ah).getEmojiMgr().a(amm);
        AppMethodBeat.o(241078);
        return a2;
    }

    public static d axs(String str) {
        AppMethodBeat.i(241079);
        p.h(str, "md5");
        com.tencent.mm.emoji.decode.d decoder = MMGIFJNIFactory.Companion.getDecoder(str);
        d dVar = new d();
        dVar.irm = Integer.valueOf(decoder.aus());
        dVar.irl = Integer.valueOf(decoder.aur());
        AppMethodBeat.o(241079);
        return dVar;
    }

    public static void axt(String str) {
        AppMethodBeat.i(241080);
        if (str != null) {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 3);
            intent.putExtra("download_entrance_scene", 16);
            intent.putExtra("from_popup", true);
            intent.putExtra("extra_id", str);
            c.b(MMApplicationContext.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFlutter.class);
            p.g(ah, "MMKernel.plugin(PluginFlutter::class.java)");
            com.tencent.mm.plugin.flutter.b.a flutterEngineMgr = ((PluginFlutter) ah).getFlutterEngineMgr();
            p.g(flutterEngineMgr, "MMKernel.plugin(PluginFl…ss.java).flutterEngineMgr");
            com.tencent.mm.plugin.flutter.ui.a dLs = flutterEngineMgr.dLs();
            p.g(dLs, "MMKernel.plugin(PluginFl…ngineMgr.currentContainer");
            dLs.getActivity().overridePendingTransition(R.anim.eq, R.anim.en);
        }
        AppMethodBeat.o(241080);
    }

    public static byte[] axu(String str) {
        AppMethodBeat.i(241081);
        byte[] ab = ab(((d) g.ah(d.class)).getEmojiMgr().amm(str).A(g.aAe().azG().aAZ(), 480));
        AppMethodBeat.o(241081);
        return ab;
    }

    public static String axv(String str) {
        AppMethodBeat.i(241082);
        p.h(str, "md5");
        com.tencent.mm.kernel.b.a ah = g.ah(d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        String amp = ((d) ah).getProvider().amp(str);
        AppMethodBeat.o(241082);
        return amp;
    }

    public static PersonalDesigner axw(String str) {
        AppMethodBeat.i(241083);
        PersonalDesigner ER = j.auL().ER(str);
        AppMethodBeat.o(241083);
        return ER;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[SYNTHETIC, Splitter:B:14:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048 A[SYNTHETIC, Splitter:B:22:0x0048] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] ab(android.graphics.Bitmap r7) {
        /*
            r3 = 0
            r6 = 241084(0x3adbc, float:3.3783E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            if (r7 == 0) goto L_0x005a
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0035, all -> 0x0044 }
            r2.<init>()     // Catch:{ IOException -> 0x0035, all -> 0x0044 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r5 = 100
            r0 = r2
            java.io.OutputStream r0 = (java.io.OutputStream) r0     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r1 = r0
            r7.compress(r4, r5, r1)     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r2.flush()     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r2.close()     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            byte[] r1 = r2.toByteArray()     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.lang.String r4 = "baos.toByteArray()"
            kotlin.g.b.p.g(r1, r4)     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
        L_0x0029:
            if (r2 == 0) goto L_0x0031
            r2.flush()     // Catch:{ IOException -> 0x0058 }
            r2.close()     // Catch:{ IOException -> 0x0058 }
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return r1
        L_0x0035:
            r1 = move-exception
            r2 = r3
        L_0x0037:
            if (r2 == 0) goto L_0x0042
            r2.flush()     // Catch:{ IOException -> 0x0041 }
            r2.close()     // Catch:{ IOException -> 0x0041 }
            r1 = r3
            goto L_0x0031
        L_0x0041:
            r1 = move-exception
        L_0x0042:
            r1 = r3
            goto L_0x0031
        L_0x0044:
            r1 = move-exception
            r2 = r3
        L_0x0046:
            if (r2 == 0) goto L_0x004e
            r2.flush()     // Catch:{ IOException -> 0x0052 }
            r2.close()     // Catch:{ IOException -> 0x0052 }
        L_0x004e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r1
        L_0x0052:
            r2 = move-exception
            goto L_0x004e
        L_0x0054:
            r1 = move-exception
            goto L_0x0046
        L_0x0056:
            r1 = move-exception
            goto L_0x0037
        L_0x0058:
            r2 = move-exception
            goto L_0x0031
        L_0x005a:
            r2 = r3
            r1 = r3
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.flutter.e.a.a.h.ab(android.graphics.Bitmap):byte[]");
    }
}
