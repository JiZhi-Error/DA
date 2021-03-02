package com.tencent.mm.plugin.emoji;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Point;
import android.text.SpannableString;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ad;
import com.tencent.mm.ce.b;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.emoji.b.b;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.pluginsdk.ui.span.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.SmileyPanelImpl;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginEmoji extends f implements d {
    private com.tencent.mm.pluginsdk.a.d qWA;
    private long qWB = 838860800;
    e qWC;

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-emoji";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(104554);
        alias(d.class);
        AppMethodBeat.o(104554);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(104555);
        dependsOn(a.class);
        AppMethodBeat.o(104555);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(104556);
        f.a.a(com.tencent.mm.ce.g.gxZ());
        b.gxI();
        com.tencent.mm.pluginsdk.i.f.gns();
        com.tencent.mm.kernel.g.b(c.class, e.cEM());
        if (gVar.aBb()) {
            y.a("emoji", "emoji", this.qWB, 7776000000L, 3);
            String str = com.tencent.mm.loader.j.b.aKB() + "emoji/cover/";
            com.tencent.mm.vfs.g.hYQ().hYS().a("emoji-cover", new QuotaFileSystem(new NativeFileSystem(str), 52428800, 83886080, 7776000000L)).ns(str, "emoji-cover").commit();
        }
        AppMethodBeat.o(104556);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(104557);
        if (gVar.aBb()) {
            pin(f.cER());
            if (gVar.aBb()) {
                com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.e(new b()));
            }
            com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
            com.tencent.mm.sticker.loader.e.gzb();
        } else if (gVar.FY(":tools") || gVar.FY(":toolsmp")) {
            MMApplicationContext.getContext().registerReceiver(new EmojiUpdateReceiver(), new IntentFilter(EmojiUpdateReceiver.ACTION));
        }
        com.tencent.mm.ui.g.b.c.a(new com.tencent.mm.ui.g.b.b() {
            /* class com.tencent.mm.plugin.emoji.PluginEmoji.AnonymousClass1 */

            @Override // com.tencent.mm.ui.g.b.b
            public final com.tencent.mm.ui.g.b.a fP(String str, String str2) {
                AppMethodBeat.i(104546);
                try {
                    com.tencent.mm.plugin.gif.b hT = com.tencent.mm.plugin.gif.c.dXx().hT(str, str2);
                    AppMethodBeat.o(104546);
                    return hT;
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.PluginEmoji", e2, "", new Object[0]);
                    AppMethodBeat.o(104546);
                    return null;
                }
            }
        });
        com.tencent.mm.ui.g.c.b.a(new com.tencent.mm.ui.g.c.a() {
            /* class com.tencent.mm.plugin.emoji.PluginEmoji.AnonymousClass2 */

            @Override // com.tencent.mm.ui.g.c.a
            public final CharSequence a(Context context, CharSequence charSequence, int i2) {
                AppMethodBeat.i(199781);
                SpannableString b2 = com.tencent.mm.ce.g.gxZ().b(context, charSequence, i2);
                AppMethodBeat.o(199781);
                return b2;
            }

            @Override // com.tencent.mm.ui.g.c.a
            public final CharSequence c(Context context, CharSequence charSequence, float f2) {
                AppMethodBeat.i(104548);
                SpannableString a2 = com.tencent.mm.ce.g.gxZ().a(context, charSequence, f2);
                AppMethodBeat.o(104548);
                return a2;
            }

            @Override // com.tencent.mm.ui.g.c.a
            public final int db(String str, int i2) {
                int i3;
                AppMethodBeat.i(104549);
                com.tencent.mm.ce.g.gxZ();
                com.tencent.mm.ce.f gxT = com.tencent.mm.ce.f.gxT();
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(104549);
                    return i2;
                }
                int length = str.length();
                if (i2 == 0 || i2 == length) {
                    AppMethodBeat.o(104549);
                    return i2;
                }
                if (com.tencent.mm.ce.f.NLl == null) {
                    StringBuilder sb = new StringBuilder();
                    int length2 = gxT.NKX.length;
                    for (int i4 = 0; i4 < length2; i4++) {
                        sb.append(Pattern.quote(gxT.NKX[i4]));
                        if (i4 != length2 - 1) {
                            sb.append('|');
                        }
                    }
                    int length3 = gxT.NKY.length;
                    for (int i5 = 0; i5 < length3; i5++) {
                        sb.append(Pattern.quote(gxT.NKY[i5]));
                        if (i5 != length3 - 1) {
                            sb.append('|');
                        }
                    }
                    int length4 = gxT.NKZ.length;
                    for (int i6 = 0; i6 < length4; i6++) {
                        sb.append(Pattern.quote(gxT.NKZ[i6]));
                        if (i6 != length4 - 1) {
                            sb.append('|');
                        }
                    }
                    int length5 = gxT.NLa.length;
                    for (int i7 = 0; i7 < length5; i7++) {
                        sb.append(Pattern.quote(gxT.NLa[i7]));
                        if (i7 != length5 - 1) {
                            sb.append('|');
                        }
                    }
                    int length6 = gxT.NLb.length;
                    for (int i8 = 0; i8 < length6; i8++) {
                        sb.append(Pattern.quote(gxT.NLb[i8]));
                        if (i8 != length6 - 1) {
                            sb.append('|');
                        }
                    }
                    int length7 = gxT.NLc.length;
                    for (int i9 = 0; i9 < length7; i9++) {
                        sb.append(Pattern.quote(gxT.NLc[i9]));
                        if (i9 != length7 - 1) {
                            sb.append('|');
                        }
                    }
                    if (gxT.NLd != null && !gxT.NLd.isEmpty()) {
                        Iterator<SmileyInfo> it = gxT.NLd.iterator();
                        while (it.hasNext()) {
                            SmileyInfo next = it.next();
                            sb.append(Pattern.quote(next.field_key)).append("|");
                            if (!Util.isNullOrNil(next.field_cnValue)) {
                                sb.append(Pattern.quote(next.field_cnValue)).append("|");
                            }
                            if (!Util.isNullOrNil(next.field_enValue)) {
                                sb.append(Pattern.quote(next.field_enValue)).append("|");
                            }
                            if (!Util.isNullOrNil(next.field_qqValue)) {
                                sb.append(Pattern.quote(next.field_qqValue)).append("|");
                            }
                            if (!Util.isNullOrNil(next.field_twValue)) {
                                sb.append(Pattern.quote(next.field_twValue)).append("|");
                            }
                            if (!Util.isNullOrNil(next.field_thValue)) {
                                sb.append(Pattern.quote(next.field_thValue)).append("|");
                            }
                        }
                    }
                    com.tencent.mm.ce.f.NLl = Pattern.compile(sb.toString());
                }
                Matcher matcher = com.tencent.mm.ce.f.NLl.matcher(str.substring(i2 < 6 ? 0 : i2 - 6, i2 + 6 >= length ? length - 1 : i2 + 6));
                while (true) {
                    if (!matcher.find()) {
                        i3 = 6;
                        break;
                    }
                    if (6 > matcher.start() && 6 < matcher.end()) {
                        i3 = matcher.start();
                        break;
                    }
                }
                int i10 = i2 + (i3 + -6 > 0 ? i3 - 6 : 0);
                AppMethodBeat.o(104549);
                return i10;
            }
        });
        ad.djd = new ad.a() {
            /* class com.tencent.mm.plugin.emoji.PluginEmoji.AnonymousClass3 */

            @Override // com.tencent.mm.api.ad.a
            public final SmileyPanel bE(Context context) {
                AppMethodBeat.i(104550);
                SmileyPanel m = m(context, false);
                AppMethodBeat.o(104550);
                return m;
            }

            @Override // com.tencent.mm.api.ad.a
            public final SmileyPanel m(Context context, boolean z) {
                AppMethodBeat.i(104551);
                SmileyPanelImpl smileyPanelImpl = new SmileyPanelImpl(context, z);
                AppMethodBeat.o(104551);
                return smileyPanelImpl;
            }

            @Override // com.tencent.mm.api.ad.a
            public final int bD(Context context) {
                boolean z;
                Point point;
                int dimensionPixelOffset;
                AppMethodBeat.i(104552);
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.a32);
                int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.cp);
                boolean z2 = context.getResources().getConfiguration().orientation == 1;
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (com.tencent.mm.compatible.util.d.oD(24)) {
                        z = activity.isInMultiWindowMode();
                        point = new Point();
                        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
                        if (z2 || z) {
                            dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.a2v);
                            Log.i("MicroMsg.PluginEmoji", "getRecommendHeight: %s, %s, %s, %s", Boolean.valueOf(z2), Boolean.valueOf(z), Integer.valueOf(dimensionPixelOffset), Integer.valueOf(point.y));
                            if (point.y > 0 || dimensionPixelOffset <= point.y / 2) {
                                AppMethodBeat.o(104552);
                                return dimensionPixelOffset;
                            }
                            int i2 = point.y / 2;
                            AppMethodBeat.o(104552);
                            return i2;
                        }
                        int i3 = (point.y / 2) - dimensionPixelOffset3;
                        Log.i("MicroMsg.PluginEmoji", "getRecommendHeight: %s, %s", Integer.valueOf(i3), Integer.valueOf(dimensionPixelOffset2));
                        if (i3 <= 0 || i3 >= dimensionPixelOffset2) {
                            AppMethodBeat.o(104552);
                            return dimensionPixelOffset2;
                        }
                        AppMethodBeat.o(104552);
                        return i3;
                    }
                }
                z = false;
                point = new Point();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
                if (z2) {
                }
                dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.a2v);
                Log.i("MicroMsg.PluginEmoji", "getRecommendHeight: %s, %s, %s, %s", Boolean.valueOf(z2), Boolean.valueOf(z), Integer.valueOf(dimensionPixelOffset), Integer.valueOf(point.y));
                if (point.y > 0) {
                }
                AppMethodBeat.o(104552);
                return dimensionPixelOffset;
            }

            @Override // com.tencent.mm.api.ad.a
            public final ac VL() {
                AppMethodBeat.i(104553);
                k kVar = new k();
                AppMethodBeat.o(104553);
                return kVar;
            }
        };
        AppMethodBeat.o(104557);
    }

    @Override // com.tencent.mm.plugin.emoji.b.d
    public void setEmojiMgr() {
        AppMethodBeat.i(104558);
        if (this.qWA == null) {
            this.qWA = b.a.qYv.getEmojiMgr();
        }
        AppMethodBeat.o(104558);
    }

    @Override // com.tencent.mm.plugin.emoji.b.d
    public void removeEmojiMgr() {
        this.qWA = null;
    }

    @Override // com.tencent.mm.plugin.emoji.b.d
    public com.tencent.mm.pluginsdk.a.d getEmojiMgr() {
        AppMethodBeat.i(104559);
        setEmojiMgr();
        com.tencent.mm.pluginsdk.a.d dVar = this.qWA;
        AppMethodBeat.o(104559);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.emoji.b.d
    public e getProvider() {
        AppMethodBeat.i(104560);
        if (this.qWC == null) {
            this.qWC = new com.tencent.mm.ca.a();
        }
        e eVar = this.qWC;
        AppMethodBeat.o(104560);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.emoji.b.d
    public bj getEmojiStorageMgr() {
        AppMethodBeat.i(104561);
        bj emojiStorageMgr = b.a.qYv.getEmojiStorageMgr();
        AppMethodBeat.o(104561);
        return emojiStorageMgr;
    }

    @Override // com.tencent.mm.plugin.emoji.b.d
    public bf getEmojiDescMgr() {
        AppMethodBeat.i(104562);
        bf emojiDescMgr = b.a.qYv.getEmojiDescMgr();
        AppMethodBeat.o(104562);
        return emojiDescMgr;
    }
}
