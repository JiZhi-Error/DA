package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.g;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/emoji/model/EggListParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "TAG", "", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "getEggList", "()Lcom/tencent/mm/modelpackage/EggList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "validEggInfo", "", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "Companion", "plugin-emojisdk_release"})
public final class i extends a {
    public static final a gXd = new a((byte) 0);
    private final String TAG = "MicroMsg.EggListParser";
    public final g gXc = new g();

    static {
        AppMethodBeat.i(160330);
        AppMethodBeat.o(160330);
    }

    public i() {
        AppMethodBeat.i(105507);
        AppMethodBeat.o(105507);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/emoji/model/EggListParser$Companion;", "", "()V", "CLIENT_SUPPORT_EGG_VERSION", "", "TYPE_AD_EGG", "TYPE_EGG_RED_ENVELOPE", "TYPE_GAME", "TYPE_NORMAL_EGG", "TYPE_SPRING_LUCKY_EGG", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.emoji.b.a
    public final void c(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(105505);
        p.h(xmlPullParser, "parser");
        this.gXc.jgT = (double) e(xmlPullParser, "version");
        super.c(xmlPullParser);
        AppMethodBeat.o(105505);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r6.hasNext() == false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        r0 = r6.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
        if (r0.jhn <= r3) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r0.jhn = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        if (r10.equals("ItemNew") != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (r5.type == 0) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        r5.type = 0;
        r3 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        if (r5.type == 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        r5.type = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (1 != r5.type) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        if (r5.gXT == null) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0086, code lost:
        if (r5.type != 2) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        if (r5.gWY != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0090, code lost:
        if (r5.type != 3) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0092, code lost:
        r0 = r5.gXT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0094, code lost:
        if (r0 == null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0096, code lost:
        r0 = r0.jhm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0098, code lost:
        if (r0 == null) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009a, code lost:
        r0 = r5.gXT.jhl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a0, code lost:
        if (r0 == null) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a6, code lost:
        if (r0.length() != 0) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a8, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
        if (r0 == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ab, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ad, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00af, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b3, code lost:
        if (r5.type != 4) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b5, code lost:
        r0 = r5.uBT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b7, code lost:
        if (r0 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b9, code lost:
        r0 = r0.jgJ;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bb, code lost:
        if (r0 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bd, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bf, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c1, code lost:
        com.tencent.mm.sdk.platformtools.Log.i(r9.TAG, "validEggInfo: " + r5.name + ", " + r5.jgP + ", " + r5.type + ", " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fd, code lost:
        if (r1 == false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (r10.equals("Item") != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ff, code lost:
        r9.gXc.jgS.add(r4.gWZ);
        com.tencent.matrix.trace.core.AppMethodBeat.o(105506);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010d, code lost:
        r3 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        r4 = new com.tencent.mm.emoji.b.h(kotlin.g.b.p.j(r10, "ItemNew"));
        r4.c(r11);
        r5 = r4.gWZ;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0040, code lost:
        switch(r5.jgP) {
            case 0: goto L_0x0067;
            case 1: goto L_0x006f;
            case 2: goto L_0x0076;
            case 3: goto L_0x0076;
            case 4: goto L_0x0083;
            case 5: goto L_0x008e;
            case 6: goto L_0x00b1;
            default: goto L_0x0043;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0043, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
        r6 = r5.jgQ.iterator();
     */
    @Override // com.tencent.mm.emoji.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
        // Method dump skipped, instructions count: 300
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.b.i.a(java.lang.String, org.xmlpull.v1.XmlPullParser):void");
    }
}
