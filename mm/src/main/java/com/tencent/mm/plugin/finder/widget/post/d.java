package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.t;

public final class d extends a {
    private static final String TAG = TAG;
    private static final String wCI = wCI;
    private static final String wCJ = wCJ;
    private static final String wCK = wCK;
    private static final String wCL = wCL;
    public static final a wCM = new a((byte) 0);
    private View lJI;
    private azk musicInfo;
    private View wCA;
    public ArrayList<String> wCB;
    private ArrayList<Integer> wCC;
    private ArrayList<String> wCD;
    private clp wCE;
    private ArrayList<String> wCF;
    private ArrayList<String> wCG;
    private int wCH;
    private ArrayList<Rect> wCy;
    private ImageView wCz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private d(Context context) {
        super(context);
        p.h(context, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(168597);
        this.wCH = 2;
        this.wCD = new ArrayList<>();
        this.wCG = new ArrayList<>();
        AppMethodBeat.o(168597);
    }

    public /* synthetic */ d(Context context, byte b2) {
        this(context);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(168598);
        AppMethodBeat.o(168598);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0239, code lost:
        if (r3 == null) goto L_0x023b;
     */
    @Override // com.tencent.mm.plugin.finder.widget.post.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void refresh() {
        /*
        // Method dump skipped, instructions count: 656
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.widget.post.d.refresh():void");
    }

    static final class b implements View.OnClickListener {
        final /* synthetic */ d wCN;

        b(d dVar) {
            this.wCN = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168590);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d.a(this.wCN);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168590);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c implements Runnable {
        final /* synthetic */ d wCN;
        final /* synthetic */ ArrayList wCO;

        c(d dVar, ArrayList arrayList) {
            this.wCN = dVar;
            this.wCO = arrayList;
        }

        public final void run() {
            String avU;
            String str;
            AppMethodBeat.i(256117);
            ArrayList arrayList = this.wCN.wCB;
            if (arrayList == null) {
                p.hyc();
            }
            int i2 = 0;
            for (Object obj : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                String str2 = (String) obj;
                boolean z = i2 == 0;
                if (this.wCO == null || this.wCO.size() <= i2 || Util.isNullOrNil((String) this.wCO.get(i2))) {
                    f fVar = f.vSz;
                    avU = f.avU(str2);
                } else {
                    avU = (String) this.wCO.get(i2);
                }
                z.f fVar2 = new z.f();
                fVar2.SYG = null;
                ArrayList arrayList2 = this.wCN.wCF;
                if (!(arrayList2 == null || (str = (String) j.L(arrayList2, i2)) == null)) {
                    f fVar3 = f.vSz;
                    fVar2.SYG = (T) f.avU(str);
                }
                if (!Util.isNullOrNil(avU)) {
                    z.f fVar4 = new z.f();
                    fVar4.SYG = (T) BitmapUtil.decodeFile(avU);
                    Bitmap decodeFile = BitmapUtil.decodeFile(fVar2.SYG);
                    if (fVar4.SYG != null) {
                        MMHandlerThread.postToMainThread(new a(avU, fVar2, decodeFile, fVar4, i2, z, this));
                    }
                }
                i2 = i3;
            }
            AppMethodBeat.o(256117);
        }

        /* access modifiers changed from: package-private */
        public static final class a implements Runnable {
            final /* synthetic */ int vLN;
            final /* synthetic */ String wCP;
            final /* synthetic */ z.f wCQ;
            final /* synthetic */ Bitmap wCR;
            final /* synthetic */ z.f wCS;
            final /* synthetic */ boolean wCT;
            final /* synthetic */ c wCU;

            a(String str, z.f fVar, Bitmap bitmap, z.f fVar2, int i2, boolean z, c cVar) {
                this.wCP = str;
                this.wCQ = fVar;
                this.wCR = bitmap;
                this.wCS = fVar2;
                this.vLN = i2;
                this.wCT = z;
                this.wCU = cVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:51:0x019d  */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x01ac  */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x01ca  */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x01da  */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x01f0  */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x0200  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 623
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.widget.post.d.c.a.run():void");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0016  */
    @Override // com.tencent.mm.plugin.finder.widget.post.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cyn() {
        /*
            r5 = this;
            r4 = 256119(0x3e877, float:3.58899E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.util.ArrayList<java.lang.String> r0 = r5.wCB
            if (r0 == 0) goto L_0x0050
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r2 = r0.iterator()
        L_0x0010:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0050
            java.lang.Object r0 = r2.next()
            java.lang.String r0 = (java.lang.String) r0
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x002b
            boolean r1 = com.tencent.mm.vfs.s.YS(r0)
            if (r1 != 0) goto L_0x0010
        L_0x002b:
            com.tencent.mm.plugin.finder.widget.post.f$a r1 = com.tencent.mm.plugin.finder.widget.post.f.wDt
            java.lang.String r1 = com.tencent.mm.plugin.finder.widget.post.f.access$getTAG$cp()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "image widget file:"
            r2.<init>(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = " lost!"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.tencent.mm.sdk.platformtools.Log.i(r1, r0)
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x004f:
            return r0
        L_0x0050:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x004f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.widget.post.d.cyn():boolean");
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.a
    public final void dIX() {
        AppMethodBeat.i(256120);
        this.wCB = null;
        this.wCC = null;
        this.wCD.clear();
        this.wCE = null;
        this.musicInfo = null;
        this.wCF = null;
        this.wCG.clear();
        this.wCy = null;
        AppMethodBeat.o(256120);
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.b
    public final View dJg() {
        AppMethodBeat.i(168594);
        Context context = this.context;
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(168594);
            throw tVar;
        }
        this.lJI = ((Activity) context).getLayoutInflater().inflate(R.layout.aie, (ViewGroup) null);
        View view = this.lJI;
        if (view == null) {
            p.hyc();
        }
        this.wCz = (ImageView) view.findViewById(R.id.ime);
        View view2 = this.lJI;
        if (view2 == null) {
            p.hyc();
        }
        View findViewById = view2.findViewById(R.id.h3h);
        p.g(findViewById, "rootView!!.findViewById(R.id.reprint_iv)");
        this.wCA = findViewById;
        View view3 = this.lJI;
        AppMethodBeat.o(168594);
        return view3;
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.b
    public final g dJh() {
        boolean z;
        Integer num;
        String str = null;
        int i2 = 0;
        AppMethodBeat.i(256118);
        if (this.vTz == null || this.wCb == null) {
            ArrayList<String> arrayList = this.wCB;
            if (!(arrayList == null || arrayList.isEmpty())) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder("img list ");
                ArrayList<String> arrayList2 = this.wCB;
                if (arrayList2 == null) {
                    p.hyc();
                }
                Log.i(str2, sb.append(arrayList2.size()).append(", thumb list ").append(this.wCD.size()).toString());
                ArrayList<String> arrayList3 = this.wCB;
                if (arrayList3 == null) {
                    p.hyc();
                }
                z = arrayList3.size() == this.wCD.size();
            } else {
                Log.i(TAG, "img list null");
                z = false;
            }
            if (z) {
                cjk cjk = new cjk();
                if (this.wCH == 7) {
                    ArrayList<String> arrayList4 = this.wCB;
                    if (arrayList4 == null) {
                        p.hyc();
                    }
                    int i3 = 0;
                    for (T t : arrayList4) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            j.hxH();
                        }
                        LinkedList<cjl> linkedList = cjk.mediaList;
                        i iVar = i.vSX;
                        String str3 = this.wCD.get(i3);
                        p.g(str3, "thumbFileList[index]");
                        linkedList.add(i.hc(t, str3));
                        i3 = i4;
                    }
                } else {
                    ArrayList<String> arrayList5 = this.wCB;
                    if (arrayList5 == null) {
                        p.hyc();
                    }
                    int i5 = 0;
                    for (T t2 : arrayList5) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            j.hxH();
                        }
                        LinkedList<cjl> linkedList2 = cjk.mediaList;
                        i iVar2 = i.vSX;
                        String str4 = this.wCD.get(i5);
                        p.g(str4, "thumbFileList[index]");
                        cjl hb = i.hb(t2, str4);
                        ayg ayg = new ayg();
                        ArrayList<Integer> arrayList6 = this.wCC;
                        if (!(arrayList6 == null || (num = (Integer) j.L(arrayList6, i5)) == null)) {
                            int intValue = num.intValue();
                            ayg.LIx = (float) intValue;
                            Log.i(TAG, "codec_info hdimg_score:".concat(String.valueOf(intValue)));
                        }
                        hb.codec_info = ayg;
                        ArrayList<String> arrayList7 = this.wCF;
                        String str5 = arrayList7 != null ? (String) j.L(arrayList7, i5) : null;
                        String str6 = (String) j.L(this.wCG, i5);
                        ArrayList<Rect> arrayList8 = this.wCy;
                        Rect rect = arrayList8 != null ? (Rect) j.L(arrayList8, i5) : null;
                        if (!(str5 == null || str6 == null || rect == null)) {
                            car car = new car();
                            car.xve = str5;
                            y yVar = y.vXH;
                            Point awm = y.awm(str5);
                            car.width = (float) awm.x;
                            car.height = (float) awm.y;
                            car.thumbUrl = str6;
                            hb.MoX = car;
                            hb.thumbUrl = str6;
                            aty aty = new aty();
                            aty.left = (float) rect.left;
                            aty.top = (float) rect.top;
                            aty.right = (float) rect.right;
                            aty.bottom = (float) rect.bottom;
                            hb.MoU = aty;
                        }
                        linkedList2.add(hb);
                        i5 = i6;
                    }
                }
                Bundle bundle = this.dQL;
                cjk.vMX = bundle != null ? bundle.getString("ORIGIN_MUSIC_ID") : null;
                Bundle bundle2 = this.dQL;
                cjk.vMV = bundle2 != null ? bundle2.getString("ORIGIN_MUSIC_PATH") : null;
                Bundle bundle3 = this.dQL;
                if (bundle3 != null) {
                    str = bundle3.getString("ORIGIN_BGM_URL");
                }
                cjk.MoK = str;
                Bundle bundle4 = this.dQL;
                cjk.wCu = bundle4 != null ? bundle4.getBoolean("MEDIA_IS_MUTE", false) : false;
                Bundle bundle5 = this.dQL;
                cjk.wCv = bundle5 != null ? bundle5.getBoolean("MUSIC_IS_MUTE", false) : false;
                Bundle bundle6 = this.dQL;
                if (bundle6 != null) {
                    i2 = bundle6.getInt("SOUND_TRACK_TYPE", 0);
                }
                cjk.soundTrackType = i2;
                cjk.MoJ = this.musicInfo;
                if (this.wCH == 7) {
                    g gVar = new g(true, 7, cjk);
                    AppMethodBeat.o(256118);
                    return gVar;
                }
                g gVar2 = new g(true, 2, cjk);
                AppMethodBeat.o(256118);
                return gVar2;
            }
            g gVar3 = new g(false, 0, null);
            AppMethodBeat.o(256118);
            return gVar3;
        }
        g gVar4 = new g(true, 2, this.wCb);
        AppMethodBeat.o(256118);
        return gVar4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.finder.widget.post.d r12) {
        /*
        // Method dump skipped, instructions count: 294
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.widget.post.d.a(com.tencent.mm.plugin.finder.widget.post.d):void");
    }
}
