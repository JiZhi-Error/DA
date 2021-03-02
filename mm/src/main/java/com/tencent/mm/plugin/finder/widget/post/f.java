package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.ui.post.PostMainUIC;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.r;
import kotlin.t;

public final class f extends a {
    private static final String TAG = TAG;
    private static final int wDp = 1001;
    private static final String wDq = wDq;
    private static final String wDr = wDr;
    private static final String wDs = wDs;
    public static final a wDt = new a((byte) 0);
    private String coverUrl = "";
    private View jxm;
    private View lJI;
    private azk musicInfo;
    private String vTB = "";
    private View wCA;
    ArrayList<String> wCD = new ArrayList<>();
    private clp wCE;
    private String wCj = "";
    private ImageView wCz;
    public ArrayList<String> wDi;
    ArrayList<cjx> wDj = new ArrayList<>();
    public acn wDk;
    private int wDl;
    private String wDm = "";
    private Rect wDn;
    public cjx wDo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        p.h(context, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(168625);
        AppMethodBeat.o(168625);
    }

    public static final /* synthetic */ void b(f fVar, String str) {
        AppMethodBeat.i(256150);
        fVar.awX(str);
        AppMethodBeat.o(256150);
    }

    public static final /* synthetic */ ImageView e(f fVar) {
        AppMethodBeat.i(256148);
        ImageView imageView = fVar.wCz;
        if (imageView == null) {
            p.btv("thumbIv");
        }
        AppMethodBeat.o(256148);
        return imageView;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(168626);
        AppMethodBeat.o(168626);
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.b
    public final g dJh() {
        boolean z;
        String str;
        ArrayList<String> stringArrayList;
        AppMethodBeat.i(256140);
        cjk cjk = new cjk();
        Bundle bundle = this.dQL;
        cjk.vMX = bundle != null ? bundle.getString("ORIGIN_MUSIC_ID") : null;
        Bundle bundle2 = this.dQL;
        cjk.vMV = bundle2 != null ? bundle2.getString("ORIGIN_MUSIC_PATH") : null;
        Bundle bundle3 = this.dQL;
        cjk.MoK = bundle3 != null ? bundle3.getString("ORIGIN_BGM_URL") : null;
        Bundle bundle4 = this.dQL;
        cjk.wCu = bundle4 != null ? bundle4.getBoolean("MEDIA_IS_MUTE", false) : false;
        Bundle bundle5 = this.dQL;
        cjk.wCv = bundle5 != null ? bundle5.getBoolean("MUSIC_IS_MUTE", false) : false;
        Bundle bundle6 = this.dQL;
        cjk.soundTrackType = bundle6 != null ? bundle6.getInt("SOUND_TRACK_TYPE", 0) : 0;
        cjk.MoJ = this.musicInfo;
        Log.i(TAG, "getUploadData: " + cjk.vMX + ", " + cjk.wCv);
        if (this.wDk != null) {
            Bundle bundle7 = this.dQL;
            if (bundle7 == null || (stringArrayList = bundle7.getStringArrayList("VIDEO_THUMB_LIST")) == null || (str = (String) j.ks(stringArrayList)) == null) {
                str = "";
            }
            LinkedList<cjl> linkedList = cjk.mediaList;
            i iVar = i.vSX;
            acn acn = this.wDk;
            if (acn == null) {
                p.hyc();
            }
            cjl a2 = i.a(acn, this.wDm, str, this.coverUrl, this.wDn);
            ayg ayg = new ayg();
            ayg.LIu = (float) this.wDl;
            a2.codec_info = ayg;
            Log.i(TAG, "codec_info video_cover_score:" + this.wDl);
            linkedList.add(a2);
            g gVar = new g(true, 4, cjk, this.vTB);
            AppMethodBeat.o(256140);
            return gVar;
        } else if (this.vTz == null || this.wCb == null) {
            ArrayList<String> arrayList = this.wDi;
            if (!(arrayList == null || arrayList.isEmpty())) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder("video list ");
                ArrayList<String> arrayList2 = this.wDi;
                if (arrayList2 == null) {
                    p.hyc();
                }
                Log.i(str2, sb.append(arrayList2.size()).append(", thumb list ").append(this.wCD.size()).toString());
                ArrayList<String> arrayList3 = this.wDi;
                if (arrayList3 == null) {
                    p.hyc();
                }
                z = arrayList3.size() == this.wCD.size();
            } else {
                Log.i(TAG, "video list null");
                z = false;
            }
            if (z) {
                ArrayList<String> arrayList4 = this.wDi;
                if (arrayList4 == null) {
                    p.hyc();
                }
                int i2 = 0;
                for (T t : arrayList4) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    LinkedList<cjl> linkedList2 = cjk.mediaList;
                    i iVar2 = i.vSX;
                    String nullAsNil = Util.nullAsNil((String) j.L(this.wCD, i2));
                    p.g(nullAsNil, "Util.nullAsNil(thumbFileList.getOrNull(index))");
                    cjl a3 = i.a(t2, nullAsNil, this.wDj.size() > i2 ? this.wDj.get(i2) : null, this.coverUrl);
                    ayg ayg2 = new ayg();
                    ayg2.LIu = (float) this.wDl;
                    a3.codec_info = ayg2;
                    Log.i(TAG, "codec_info video_cover_score:" + this.wDl);
                    linkedList2.add(a3);
                    i2 = i3;
                }
                y yVar = y.vXH;
                g gVar2 = new g(true, y.a(cjk), cjk, this.vTB);
                AppMethodBeat.o(256140);
                return gVar2;
            }
            g gVar3 = new g(false, 0, null);
            AppMethodBeat.o(256140);
            return gVar3;
        } else {
            g gVar4 = new g(true, 4, this.wCb);
            AppMethodBeat.o(256140);
            return gVar4;
        }
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.a
    public final void refresh() {
        String str;
        int i2;
        Rect rect;
        byte[] bArr;
        ArrayList<String> arrayList;
        String str2;
        boolean z;
        ArrayList parcelableArrayList;
        byte[] byteArray;
        byte[] byteArray2;
        ArrayList<String> arrayList2 = null;
        AppMethodBeat.i(168624);
        super.refresh();
        Bundle bundle = this.dQL;
        if (!(bundle == null || (byteArray2 = bundle.getByteArray("MEDIA_EXTRA_MUSIC")) == null)) {
            clp clp = new clp();
            try {
                clp.parseFrom(byteArray2);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                clp = null;
            }
            this.wCE = clp;
            String str3 = TAG;
            StringBuilder sb = new StringBuilder("post video with music: ");
            clp clp2 = this.wCE;
            Log.i(str3, sb.append(clp2 != null ? Integer.valueOf(clp2.MqO) : null).toString());
            i iVar = i.vSX;
            this.musicInfo = i.a(this.wCE);
        }
        Bundle bundle2 = this.dQL;
        if (!(bundle2 == null || (byteArray = bundle2.getByteArray("ORIGIN_MUSIC_INFO")) == null)) {
            azk azk = new azk();
            try {
                azk.parseFrom(byteArray);
            } catch (Exception e3) {
                Log.printDebugStack("safeParser", "", e3);
                azk = null;
            }
            this.musicInfo = azk;
        }
        Bundle bundle3 = this.dQL;
        if (bundle3 == null || (str = bundle3.getString("VIDEO_COVER_URL")) == null) {
            str = "";
        }
        this.coverUrl = str;
        Bundle bundle4 = this.dQL;
        if (bundle4 != null) {
            i2 = bundle4.getInt("VIDEO_COVER_QUALITY", 0);
        } else {
            i2 = 0;
        }
        this.wDl = i2;
        Bundle bundle5 = this.dQL;
        if (bundle5 == null || (parcelableArrayList = bundle5.getParcelableArrayList("HALF_RECT_LIST")) == null) {
            rect = null;
        } else {
            rect = (Rect) j.L(parcelableArrayList, 0);
        }
        this.wDn = rect;
        if (!s.YS(this.coverUrl)) {
            this.coverUrl = "";
            this.wDl = 0;
        }
        Bundle bundle6 = this.dQL;
        if (bundle6 != null) {
            bArr = bundle6.getByteArray("video_composition");
        } else {
            bArr = null;
        }
        if (bArr != null) {
            dJo();
            AppMethodBeat.o(168624);
            return;
        }
        if (this.wCb != null) {
            cjk cjk = this.wCb;
            if (cjk == null) {
                p.hyc();
            }
            if (!Util.isNullOrNil(cjk.mediaList)) {
                View view = this.jxm;
                if (view == null) {
                    p.btv("container");
                }
                view.setVisibility(0);
                View view2 = this.wCA;
                if (view2 == null) {
                    p.btv("reprintIv");
                }
                view2.setVisibility(0);
                cjk cjk2 = this.wCb;
                if (cjk2 == null) {
                    p.hyc();
                }
                LinkedList<cjl> linkedList = cjk2.mediaList;
                p.g(linkedList, "refFeedContent!!.mediaList");
                cjl first = linkedList.getFirst();
                y yVar = y.vXH;
                r<Integer, Integer, Integer> go = y.go((int) first.width, (int) first.height);
                ImageView imageView = this.wCz;
                if (imageView == null) {
                    p.btv("thumbIv");
                }
                imageView.getLayoutParams().width = go.second.intValue();
                ImageView imageView2 = this.wCz;
                if (imageView2 == null) {
                    p.btv("thumbIv");
                }
                imageView2.getLayoutParams().height = go.SWY.intValue();
                ImageView imageView3 = this.wCz;
                if (imageView3 == null) {
                    p.btv("thumbIv");
                }
                int i3 = imageView3.getLayoutParams().width;
                ImageView imageView4 = this.wCz;
                if (imageView4 == null) {
                    p.btv("thumbIv");
                }
                gy(i3, imageView4.getLayoutParams().height);
                ImageView imageView5 = this.wCz;
                if (imageView5 == null) {
                    p.btv("thumbIv");
                }
                imageView5.setScaleType(ImageView.ScaleType.values()[go.first.intValue()]);
                ImageView imageView6 = this.wCz;
                if (imageView6 == null) {
                    p.btv("thumbIv");
                }
                imageView6.requestLayout();
                p.g(first, "mediaObj");
                k kVar = new k(first, x.THUMB_IMAGE, null, null, 12);
                m mVar = m.uJa;
                com.tencent.mm.loader.d<o> djY = m.djY();
                ImageView imageView7 = this.wCz;
                if (imageView7 == null) {
                    p.btv("thumbIv");
                }
                m mVar2 = m.uJa;
                djY.a(kVar, imageView7, m.a(m.a.TIMELINE));
                ImageView imageView8 = this.wCz;
                if (imageView8 == null) {
                    p.btv("thumbIv");
                }
                imageView8.setOnClickListener(new g(this));
                AppMethodBeat.o(168624);
                return;
            }
        }
        Bundle bundle7 = this.dQL;
        if (bundle7 != null) {
            arrayList = bundle7.getStringArrayList("video_file_list");
        } else {
            arrayList = null;
        }
        this.wDi = arrayList;
        Bundle bundle8 = this.dQL;
        if (bundle8 != null) {
            arrayList2 = bundle8.getStringArrayList("VIDEO_THUMB_LIST");
        }
        Bundle bundle9 = this.dQL;
        if (bundle9 == null || (str2 = bundle9.getString("VIDEO_COVER_URL")) == null) {
            str2 = "";
        }
        this.coverUrl = str2;
        Bundle bundle10 = this.dQL;
        this.wDl = bundle10 != null ? bundle10.getInt("VIDEO_COVER_QUALITY", 0) : 0;
        dJp();
        ArrayList<String> arrayList3 = this.wDi;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            View view3 = this.lJI;
            if (view3 == null) {
                p.btv("rootView");
            }
            view3.findViewById(R.id.hho).setOnClickListener(new e(this));
            View view4 = this.jxm;
            if (view4 == null) {
                p.btv("container");
            }
            view4.setVisibility(0);
            com.tencent.mm.ac.d.c("Finder_Post_Create_Video_Thumb", new C1356f(this, arrayList2));
        }
        AppMethodBeat.o(168624);
    }

    static final class g implements View.OnClickListener {
        final /* synthetic */ f wDv;

        g(f fVar) {
            this.wDv = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256139);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            f.a(this.wDv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$refresh$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256139);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void gy(int r10, int r11) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.widget.post.f.gy(int, int):void");
    }

    public static final class c implements View.OnClickListener {
        final /* synthetic */ z.f wDu;
        final /* synthetic */ f wDv;

        c(z.f fVar, f fVar2) {
            this.wDu = fVar;
            this.wDv = fVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256131);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            y yVar = y.vXH;
            if (y.isAnyEnableFullScreenEnjoy()) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((PostMainUIC) com.tencent.mm.ui.component.a.ko(this.wDv.context).get(PostMainUIC.class)).dAN();
            } else {
                cjk cjk = new cjk();
                LinkedList<cjl> linkedList = cjk.mediaList;
                i iVar = i.vSX;
                acn acn = this.wDv.wDk;
                if (acn == null) {
                    p.hyc();
                }
                linkedList.add(i.a(acn, this.wDv.wDm, this.wDu.SYG, this.wDv.coverUrl, this.wDv.wDn));
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = this.wDv.context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(256131);
                    throw tVar;
                }
                Activity activity = (Activity) context;
                ImageView e2 = f.e(this.wDv);
                Context context2 = this.wDv.context;
                if (context2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(256131);
                    throw tVar2;
                }
                Window window = ((MMActivity) context2).getWindow();
                p.g(window, "(context as MMActivity).window");
                com.tencent.mm.plugin.finder.utils.a.a(activity, ViewAnimHelper.q(e2, window.getDecorView()), cjk, this.wDv.vTz, false, 16);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256131);
        }
    }

    public static final class d implements View.OnClickListener {
        final /* synthetic */ z.f wDu;
        final /* synthetic */ f wDv;

        d(z.f fVar, f fVar2) {
            this.wDu = fVar;
            this.wDv = fVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256132);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            cjk cjk = new cjk();
            LinkedList<cjl> linkedList = cjk.mediaList;
            i iVar = i.vSX;
            acn acn = this.wDv.wDk;
            if (acn == null) {
                p.hyc();
            }
            linkedList.add(i.a(acn, this.wDv.wDm, this.wDu.SYG, this.wDv.coverUrl, this.wDv.wDn));
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.wDv.context;
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(256132);
                throw tVar;
            }
            Activity activity = (Activity) context;
            ImageView e2 = f.e(this.wDv);
            Context context2 = this.wDv.context;
            if (context2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(256132);
                throw tVar2;
            }
            Window window = ((MMActivity) context2).getWindow();
            p.g(window, "(context as MMActivity).window");
            ViewAnimHelper.ViewInfo q = ViewAnimHelper.q(e2, window.getDecorView());
            p.g(q, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
            a aVar2 = f.wDt;
            com.tencent.mm.plugin.finder.utils.a.a(activity, q, cjk, f.wDp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256132);
        }
    }

    static final class e implements View.OnClickListener {
        final /* synthetic */ f wDv;

        e(f fVar) {
            this.wDv = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256133);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            f.f(this.wDv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256133);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.finder.widget.post.f$f */
    public static final class C1356f extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ ArrayList wDf;
        final /* synthetic */ f wDv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1356f(f fVar, ArrayList arrayList) {
            super(0);
            this.wDv = fVar;
            this.wDf = arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.finder.widget.post.f$f$a */
        public static final class a implements Runnable {
            final /* synthetic */ C1356f wDA;
            final /* synthetic */ Bitmap wDy;
            final /* synthetic */ z.a wDz;

            a(Bitmap bitmap, z.a aVar, C1356f fVar) {
                this.wDy = bitmap;
                this.wDz = aVar;
                this.wDA = fVar;
            }

            public final void run() {
                AppMethodBeat.i(256135);
                a aVar = f.wDt;
                Log.i(f.TAG, "set coverUrl");
                f.a(this.wDA.wDv, this.wDy);
                f.e(this.wDA.wDv).setOnClickListener(new View.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.widget.post.f.C1356f.a.AnonymousClass1 */
                    final /* synthetic */ a wDB;

                    {
                        this.wDB = r1;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(256134);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        f.a(this.wDB.wDA.wDv);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(256134);
                    }
                });
                AppMethodBeat.o(256135);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.finder.widget.post.f$f$b */
        public static final class b implements Runnable {
            final /* synthetic */ int vLN;
            final /* synthetic */ String wCP;
            final /* synthetic */ C1356f wDA;
            final /* synthetic */ Bitmap wDg;
            final /* synthetic */ z.a wDz;

            b(String str, int i2, z.a aVar, Bitmap bitmap, C1356f fVar) {
                this.wCP = str;
                this.vLN = i2;
                this.wDz = aVar;
                this.wDg = bitmap;
                this.wDA = fVar;
            }

            public final void run() {
                AppMethodBeat.i(256137);
                if (this.wDz.SYB) {
                    f.a(this.wDA.wDv, this.wDg);
                    f.e(this.wDA.wDv).setOnClickListener(new View.OnClickListener(this) {
                        /* class com.tencent.mm.plugin.finder.widget.post.f.C1356f.b.AnonymousClass1 */
                        final /* synthetic */ b wDC;

                        {
                            this.wDC = r1;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(256136);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            f.a(this.wDC.wDA.wDv);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$forEachIndexed$lambda$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(256136);
                        }
                    });
                }
                AppMethodBeat.o(256137);
            }
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            String avT;
            Bitmap decodeFile;
            Bitmap decodeFile2;
            AppMethodBeat.i(256138);
            this.wDv.wCD.clear();
            ArrayList<String> arrayList = this.wDv.wDi;
            if (arrayList == null) {
                p.hyc();
            }
            int i2 = 0;
            for (T t : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t2 = t;
                z.a aVar = new z.a();
                aVar.SYB = i2 == 0;
                if (this.wDf == null || this.wDf.size() <= i2 || Util.isNullOrNil((String) this.wDf.get(i2))) {
                    if (this.wDv.wDj.size() > i2 && this.wDv.wDj.get(i2) != null) {
                        cjx cjx = this.wDv.wDj.get(i2);
                        if (cjx == null) {
                            p.hyc();
                        }
                        if (cjx.Mps != null) {
                            com.tencent.mm.plugin.finder.upload.f fVar = com.tencent.mm.plugin.finder.upload.f.vSz;
                            cjx cjx2 = this.wDv.wDj.get(i2);
                            if (cjx2 == null) {
                                p.hyc();
                            }
                            erf erf = cjx2.Mps;
                            if (erf == null) {
                                p.hyc();
                            }
                            p.g(erf, "cropInfoList[index]!!.thumbRect!!");
                            avT = fVar.a(t2, erf);
                        }
                    }
                    a aVar2 = f.wDt;
                    Log.w(f.TAG, "no thumb & no thumbRect");
                    com.tencent.mm.plugin.finder.upload.f fVar2 = com.tencent.mm.plugin.finder.upload.f.vSz;
                    avT = com.tencent.mm.plugin.finder.upload.f.avT(t2);
                } else {
                    avT = (String) this.wDf.get(i2);
                }
                f.b(this.wDv, avT);
                if (aVar.SYB && !Util.isNullOrNil(this.wDv.coverUrl) && s.YS(this.wDv.coverUrl) && (decodeFile2 = BitmapUtil.decodeFile(this.wDv.coverUrl)) != null) {
                    MMHandlerThread.postToMainThread(new a(decodeFile2, aVar, this));
                    aVar.SYB = false;
                }
                if (!Util.isNullOrNil(avT) && (decodeFile = BitmapUtil.decodeFile(avT)) != null) {
                    this.wDv.wCD.add(avT);
                    a aVar3 = f.wDt;
                    Log.i(f.TAG, "add thumb file, index:".concat(String.valueOf(i2)));
                    MMHandlerThread.postToMainThread(new b(avT, i2, aVar, decodeFile, this));
                }
                i2 = i3;
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(256138);
            return xVar;
        }
    }

    private final void awX(String str) {
        AppMethodBeat.i(256143);
        if (!Util.isNullOrNil(this.coverUrl)) {
            str = this.coverUrl;
        }
        this.wCj = str;
        AppMethodBeat.o(256143);
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.a
    public final boolean cyn() {
        AppMethodBeat.i(256145);
        if (this.wDk != null) {
            acn acn = this.wDk;
            if (acn == null) {
                p.hyc();
            }
            LinkedList<ejf> linkedList = acn.Lnd;
            p.g(linkedList, "compositionInfo!!.tracks");
            for (T t : linkedList) {
                if (!s.YS(t.path)) {
                    Log.i(TAG, "[compositionInfo]video widget file:" + t.path + " lost!");
                    AppMethodBeat.o(256145);
                    return false;
                }
            }
        } else {
            ArrayList<String> arrayList = this.wDi;
            if (arrayList != null) {
                for (T t2 : arrayList) {
                    if (!s.YS(t2)) {
                        Log.i(TAG, "[videoFileList]video widget file:" + ((String) t2) + " lost!");
                        AppMethodBeat.o(256145);
                        return false;
                    }
                }
            }
        }
        AppMethodBeat.o(256145);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.a
    public final void dIX() {
        AppMethodBeat.i(256146);
        this.wDi = null;
        this.wCD.clear();
        this.wDj.clear();
        this.wDk = null;
        this.wCE = null;
        this.musicInfo = null;
        this.wCj = null;
        this.coverUrl = "";
        this.wDl = 0;
        this.wDm = "";
        this.wDn = null;
        AppMethodBeat.o(256146);
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.b
    public final View dJg() {
        AppMethodBeat.i(168622);
        Context context = this.context;
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(168622);
            throw tVar;
        }
        View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.ail, (ViewGroup) null);
        p.g(inflate, "(context as Activity).la…_post_video_widget, null)");
        this.lJI = inflate;
        View view = this.lJI;
        if (view == null) {
            p.btv("rootView");
        }
        View findViewById = view.findViewById(R.id.j44);
        p.g(findViewById, "rootView.findViewById(R.id.video_container)");
        this.jxm = findViewById;
        View view2 = this.lJI;
        if (view2 == null) {
            p.btv("rootView");
        }
        View findViewById2 = view2.findViewById(R.id.ime);
        p.g(findViewById2, "rootView.findViewById(R.id.thumb_view)");
        this.wCz = (ImageView) findViewById2;
        View view3 = this.lJI;
        if (view3 == null) {
            p.btv("rootView");
        }
        View findViewById3 = view3.findViewById(R.id.h3h);
        p.g(findViewById3, "rootView.findViewById(R.id.reprint_iv)");
        this.wCA = findViewById3;
        View view4 = this.lJI;
        if (view4 == null) {
            p.btv("rootView");
        }
        AppMethodBeat.o(168622);
        return view4;
    }

    public static final class b extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ z.f wDu;
        final /* synthetic */ f wDv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(z.f fVar, f fVar2) {
            super(0);
            this.wDu = fVar;
            this.wDv = fVar2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(256130);
            final z.f fVar = new z.f();
            fVar.SYG = null;
            if (!Util.isNullOrNil(this.wDv.coverUrl)) {
                fVar.SYG = (T) MMBitmapFactory.decodeFile(this.wDv.coverUrl);
            }
            if (fVar.SYG == null) {
                if (!Util.isNullOrNil((String) this.wDu.SYG)) {
                    fVar.SYG = (T) MMBitmapFactory.decodeFile(this.wDu.SYG);
                }
                if (this.wDv.wDk == null) {
                    p.hyc();
                }
                acn acn = this.wDv.wDk;
                if (acn == null) {
                    p.hyc();
                }
                float f2 = acn.Gxw.Lnn;
                Rect rect = this.wDv.wDn;
                T t = rect != null ? (T) BitmapUtil.cropBitmap(fVar.SYG, (int) (((float) rect.left) * f2), (int) (((float) rect.top) * f2), (int) (((float) rect.width()) * f2), (int) (f2 * ((float) rect.height())), false) : null;
                if (t != null) {
                    f fVar2 = this.wDv;
                    StringBuilder sb = new StringBuilder();
                    p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
                    fVar2.wDm = sb.append(com.tencent.mm.modelvideo.o.getAccVideoPath()).append("vsg_half_thumb_").append(System.currentTimeMillis()).toString();
                    BitmapUtil.saveBitmapToImage(t, 60, Bitmap.CompressFormat.JPEG, this.wDv.wDm, false);
                    fVar.SYG = t;
                }
            }
            if (fVar.SYG != null) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.widget.post.f.b.AnonymousClass1 */
                    final /* synthetic */ b wDw;

                    {
                        this.wDw = r2;
                    }

                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(256129);
                        f.a(this.wDw.wDv, (Bitmap) fVar.SYG);
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(256129);
                        return xVar;
                    }
                });
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(256130);
            return xVar;
        }
    }

    private final boolean dJo() {
        byte[] byteArray;
        boolean z;
        AppMethodBeat.i(256142);
        Bundle bundle = this.dQL;
        if (bundle == null || (byteArray = bundle.getByteArray("video_composition")) == null) {
            AppMethodBeat.o(256142);
            return false;
        }
        try {
            Log.i(TAG, "initFakeVideoLogic");
            View view = this.jxm;
            if (view == null) {
                p.btv("container");
            }
            view.setVisibility(0);
            com.tencent.mm.bw.a parseFrom = new acn().parseFrom(byteArray);
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CompositionInfo");
                AppMethodBeat.o(256142);
                throw tVar;
            }
            this.wDk = (acn) parseFrom;
            Bundle bundle2 = this.dQL;
            ArrayList<String> stringArrayList = bundle2 != null ? bundle2.getStringArrayList("VIDEO_THUMB_LIST") : null;
            z.f fVar = new z.f();
            fVar.SYG = "";
            if (stringArrayList != null) {
                if (!stringArrayList.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Object ks = j.ks(stringArrayList);
                    p.g(ks, "mediaThumbList.first()");
                    fVar.SYG = (T) ((String) ks);
                }
            }
            awX(fVar.SYG);
            com.tencent.mm.ac.d.b("PostVideoWidget_initFakeVideoLogic", new b(fVar, this));
            ImageView imageView = this.wCz;
            if (imageView == null) {
                p.btv("thumbIv");
            }
            imageView.setOnClickListener(new c(fVar, this));
            View view2 = this.lJI;
            if (view2 == null) {
                p.btv("rootView");
            }
            view2.findViewById(R.id.hho).setOnClickListener(new d(fVar, this));
            AppMethodBeat.o(256142);
            return true;
        } catch (IOException e2) {
            Log.printErrStackTrace(TAG, e2, "parse error", new Object[0]);
        }
    }

    private final void dJp() {
        AppMethodBeat.i(256144);
        Bundle bundle = this.dQL;
        if (bundle != null) {
            String string = bundle.getString("video_before_cut_path");
            if (string == null) {
                string = "";
            }
            this.vTB = string;
            ArrayList<Parcelable> parcelableArrayList = bundle.getParcelableArrayList("VIDEO_CROP_LIST");
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                this.wDj.clear();
                for (Parcelable parcelable : parcelableArrayList) {
                    if (parcelable == null || !(parcelable instanceof LocalVideoCropInfoParcelable)) {
                        this.wDj.add(null);
                    } else {
                        this.wDj.add(((LocalVideoCropInfoParcelable) parcelable).uOR);
                    }
                }
            }
            AppMethodBeat.o(256144);
            return;
        }
        AppMethodBeat.o(256144);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.finder.widget.post.f r10) {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.widget.post.f.a(com.tencent.mm.plugin.finder.widget.post.f):void");
    }

    public static final /* synthetic */ void a(f fVar, Bitmap bitmap) {
        AppMethodBeat.i(256147);
        y yVar = y.vXH;
        r<Integer, Integer, Integer> go = y.go(bitmap.getWidth(), bitmap.getHeight());
        ImageView imageView = fVar.wCz;
        if (imageView == null) {
            p.btv("thumbIv");
        }
        imageView.getLayoutParams().width = go.second.intValue();
        ImageView imageView2 = fVar.wCz;
        if (imageView2 == null) {
            p.btv("thumbIv");
        }
        imageView2.getLayoutParams().height = go.SWY.intValue();
        ImageView imageView3 = fVar.wCz;
        if (imageView3 == null) {
            p.btv("thumbIv");
        }
        int i2 = imageView3.getLayoutParams().width;
        ImageView imageView4 = fVar.wCz;
        if (imageView4 == null) {
            p.btv("thumbIv");
        }
        fVar.gy(i2, imageView4.getLayoutParams().height);
        ImageView imageView5 = fVar.wCz;
        if (imageView5 == null) {
            p.btv("thumbIv");
        }
        imageView5.setScaleType(ImageView.ScaleType.values()[go.first.intValue()]);
        ImageView imageView6 = fVar.wCz;
        if (imageView6 == null) {
            p.btv("thumbIv");
        }
        imageView6.requestLayout();
        ImageView imageView7 = fVar.wCz;
        if (imageView7 == null) {
            p.btv("thumbIv");
        }
        imageView7.setImageBitmap(bitmap);
        AppMethodBeat.o(256147);
    }

    public static final /* synthetic */ void f(f fVar) {
        boolean z = false;
        AppMethodBeat.i(256149);
        cjk cjk = new cjk();
        ArrayList<String> arrayList = fVar.wDi;
        if (arrayList == null) {
            p.hyc();
        }
        int i2 = 0;
        for (T t : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            LinkedList<cjl> linkedList = cjk.mediaList;
            i iVar = i.vSX;
            String nullAsNil = Util.nullAsNil((String) j.L(fVar.wCD, i2));
            p.g(nullAsNil, "Util.nullAsNil(thumbFileList.getOrNull(index))");
            linkedList.add(i.a(t2, nullAsNil, fVar.wDj.size() > i2 ? fVar.wDj.get(i2) : null, fVar.coverUrl));
            i2 = i3;
        }
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        Context context = fVar.context;
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(256149);
            throw tVar;
        }
        Activity activity = (Activity) context;
        ImageView imageView = fVar.wCz;
        if (imageView == null) {
            p.btv("thumbIv");
        }
        ImageView imageView2 = imageView;
        Context context2 = fVar.context;
        if (context2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(256149);
            throw tVar2;
        }
        Window window = ((MMActivity) context2).getWindow();
        p.g(window, "(context as MMActivity).window");
        ViewAnimHelper.ViewInfo q = ViewAnimHelper.q(imageView2, window.getDecorView());
        p.g(q, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
        int i4 = wDp;
        Bundle bundle = fVar.dQL;
        if (bundle != null) {
            z = bundle.getBoolean(a.wCi, false);
        }
        com.tencent.mm.plugin.finder.utils.a.a(activity, q, cjk, i4, z);
        AppMethodBeat.o(256149);
    }
}
