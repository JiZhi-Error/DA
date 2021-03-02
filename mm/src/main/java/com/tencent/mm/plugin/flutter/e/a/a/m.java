package com.tencent.mm.plugin.flutter.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.res.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m {
    private static m wKA;
    public static final a wKB = new a((byte) 0);
    private final String TAG;
    public final LinkedList<b> wKy;
    private final Map<String, Integer> wKz;

    static {
        AppMethodBeat.i(241108);
        AppMethodBeat.o(241108);
    }

    public /* synthetic */ m(byte b2) {
        this();
    }

    private m() {
        AppMethodBeat.i(241107);
        this.TAG = "MMVideoEditorTransitionFetcher";
        this.wKy = new LinkedList<>();
        this.wKz = ae.e(s.U("diehua.svg", Integer.valueOf((int) R.raw.diehua)), s.U("shanhei.svg", Integer.valueOf((int) R.raw.shanhei)), s.U("shanbai.svg", Integer.valueOf((int) R.raw.shanbai)), s.U("zuoyi.svg", Integer.valueOf((int) R.raw.zuoyi)), s.U("youyi.svg", Integer.valueOf((int) R.raw.youyi)), s.U("shangyi.svg", Integer.valueOf((int) R.raw.shangyi)), s.U("xiayi.svg", Integer.valueOf((int) R.raw.xiayi)), s.U("fangda.svg", Integer.valueOf((int) R.raw.fangda)), s.U("suoxiao.svg", Integer.valueOf((int) R.raw.suoxiao)), s.U("youzhuan.svg", Integer.valueOf((int) R.raw.youzhuan)), s.U("zuozhuan.svg", Integer.valueOf((int) R.raw.zuozhuan)));
        dMd();
        AppMethodBeat.o(241107);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b {
        public String assetPath;
        private long duration;
        public String name;
        int order;
        public String wKC;
        private long wKD;

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
            if (r5.wKD == r6.wKD) goto L_0x0042;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 241104(0x3add0, float:3.37859E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0042
                boolean r0 = r6 instanceof com.tencent.mm.plugin.flutter.e.a.a.m.b
                if (r0 == 0) goto L_0x0047
                com.tencent.mm.plugin.flutter.e.a.a.m$b r6 = (com.tencent.mm.plugin.flutter.e.a.a.m.b) r6
                java.lang.String r0 = r5.name
                java.lang.String r1 = r6.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                int r0 = r5.order
                int r1 = r6.order
                if (r0 != r1) goto L_0x0047
                java.lang.String r0 = r5.assetPath
                java.lang.String r1 = r6.assetPath
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                java.lang.String r0 = r5.wKC
                java.lang.String r1 = r6.wKC
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                long r0 = r5.duration
                long r2 = r6.duration
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0047
                long r0 = r5.wKD
                long r2 = r6.wKD
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0047
            L_0x0042:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0046:
                return r0
            L_0x0047:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0046
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.flutter.e.a.a.m.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(241103);
            String str = this.name;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.order) * 31;
            String str2 = this.assetPath;
            int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
            String str3 = this.wKC;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            long j2 = this.duration;
            long j3 = this.wKD;
            int i3 = ((((hashCode2 + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
            AppMethodBeat.o(241103);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(241102);
            String str = "TransEffectInfo(name=" + this.name + ", order=" + this.order + ", assetPath=" + this.assetPath + ", svgPath=" + this.wKC + ", duration=" + this.duration + ", effectId=" + this.wKD + ")";
            AppMethodBeat.o(241102);
            return str;
        }

        private /* synthetic */ b() {
            this("", 0, "", "", 0);
            AppMethodBeat.i(241101);
            AppMethodBeat.o(241101);
        }

        public b(String str, int i2, String str2, String str3, long j2) {
            p.h(str, "name");
            p.h(str2, "assetPath");
            p.h(str3, "svgPath");
            AppMethodBeat.i(241100);
            this.name = str;
            this.order = i2;
            this.assetPath = str2;
            this.wKC = str3;
            this.duration = 500;
            this.wKD = j2;
            AppMethodBeat.o(241100);
        }
    }

    private final void dMd() {
        AppMethodBeat.i(241106);
        String eLk = f.BYo.eLk();
        try {
            JSONArray eLn = f.BYo.eLn();
            if (eLn == null) {
                p.hyc();
            }
            int length = eLn.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = eLn.optJSONObject(i2);
                String optString = optJSONObject.optString("name");
                String string = optJSONObject.getString("pag");
                String string2 = optJSONObject.getString("svg");
                int i3 = optJSONObject.getInt("order");
                String str = eLk + string;
                if (string2 == null) {
                    string2 = "";
                }
                LinkedList<b> linkedList = this.wKy;
                p.g(optString, "transEffectName");
                linkedList.add(new b(optString, i3, str, string2, -1));
            }
            LinkedList<b> linkedList2 = this.wKy;
            if (linkedList2.size() > 1) {
                j.a((List) linkedList2, (Comparator) new c());
            }
            AppMethodBeat.o(241106);
        } catch (JSONException e2) {
            Log.printErrStackTrace(this.TAG, e2, "Cannot load transEffect config", new Object[0]);
            AppMethodBeat.o(241106);
        }
    }

    public static final class c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(241105);
            int a2 = kotlin.b.a.a(Integer.valueOf(t.order), Integer.valueOf(t2.order));
            AppMethodBeat.o(241105);
            return a2;
        }
    }
}
