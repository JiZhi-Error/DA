package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.PhotoView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.r;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u0000 F2\u00020\u0001:\u0001FB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0016J4\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u00142\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u000eH\u0016J\b\u00109\u001a\u00020:H\u0016J\n\u0010;\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020=H\u0016J\b\u0010?\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020=H\u0016J\b\u0010A\u001a\u00020=H\u0016J$\u0010B\u001a\u00020=2\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u000eH\u0016J\u0018\u0010C\u001a\u00020=2\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u000203H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\fj\b\u0012\u0004\u0012\u00020\u0014`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R\u001a\u0010&\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/content/Context;", "(Landroid/content/Context;)V", "mediaCountView", "Landroid/widget/TextView;", "getMediaCountView", "()Landroid/widget/TextView;", "setMediaCountView", "(Landroid/widget/TextView;)V", "mediaCropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getMediaCropInfoList", "()Ljava/util/ArrayList;", "setMediaCropInfoList", "(Ljava/util/ArrayList;)V", "mediaFileList", "", "getMediaFileList", "setMediaFileList", "mediaTypeList", "", "getMediaTypeList", "setMediaTypeList", "multiIcon", "Landroid/view/View;", "getMultiIcon", "()Landroid/view/View;", "setMultiIcon", "(Landroid/view/View;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Lcom/tencent/mm/view/PhotoView;", "getThumbIv", "()Lcom/tencent/mm/view/PhotoView;", "setThumbIv", "(Lcom/tencent/mm/view/PhotoView;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "setVideoPlayIcon", "(Landroid/widget/ImageView;)V", "checkData", "", "checkFileExist", "getThumbFile", FirebaseAnalytics.b.INDEX, "file", "mediaThumbList", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showMediaThumb", "showVideoThumb", "thumbFile", "showThumb", "Companion", "plugin-finder_release"})
public final class e extends a {
    private static final String TAG = TAG;
    public static final a wDd = new a((byte) 0);
    private View lJI;
    private View wCA;
    ArrayList<String> wCD = new ArrayList<>();
    public PhotoView wCW;
    public TextView wCX;
    protected ImageView wCY;
    public View wCZ;
    private ArrayList<String> wDa;
    private ArrayList<Integer> wDb;
    private ArrayList<cjx> wDc = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        p.h(context, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(168611);
        AppMethodBeat.o(168611);
    }

    public final PhotoView dJm() {
        AppMethodBeat.i(256124);
        PhotoView photoView = this.wCW;
        if (photoView == null) {
            p.btv("thumbIv");
        }
        AppMethodBeat.o(256124);
        return photoView;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(168612);
        AppMethodBeat.o(168612);
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.a
    public final void refresh() {
        AppMethodBeat.i(168610);
        super.refresh();
        if (this.wCb != null) {
            cjk cjk = this.wCb;
            if (cjk == null) {
                p.hyc();
            }
            if (!Util.isNullOrNil(cjk.mediaList)) {
                View view = this.wCA;
                if (view == null) {
                    p.btv("reprintIv");
                }
                view.setVisibility(0);
                cjk cjk2 = this.wCb;
                if (cjk2 == null) {
                    p.hyc();
                }
                if (cjk2.mediaList.size() > 1) {
                    TextView textView = this.wCX;
                    if (textView == null) {
                        p.btv("mediaCountView");
                    }
                    textView.setVisibility(8);
                    TextView textView2 = this.wCX;
                    if (textView2 == null) {
                        p.btv("mediaCountView");
                    }
                    Context context = this.context;
                    Object[] objArr = new Object[1];
                    cjk cjk3 = this.wCb;
                    if (cjk3 == null) {
                        p.hyc();
                    }
                    objArr[0] = Integer.valueOf(cjk3.mediaList.size());
                    textView2.setText(context.getString(R.string.cpb, objArr));
                    View view2 = this.wCZ;
                    if (view2 == null) {
                        p.btv("multiIcon");
                    }
                    view2.setVisibility(0);
                } else {
                    TextView textView3 = this.wCX;
                    if (textView3 == null) {
                        p.btv("mediaCountView");
                    }
                    textView3.setVisibility(8);
                }
                cjk cjk4 = this.wCb;
                if (cjk4 == null) {
                    p.hyc();
                }
                LinkedList<cjl> linkedList = cjk4.mediaList;
                p.g(linkedList, "refFeedContent!!.mediaList");
                cjl first = linkedList.getFirst();
                a.wCj = first != null ? first.MoM : null;
                y yVar = y.vXH;
                r<Integer, Integer, Integer> go = y.go((int) first.width, (int) first.height);
                PhotoView photoView = this.wCW;
                if (photoView == null) {
                    p.btv("thumbIv");
                }
                photoView.getLayoutParams().width = go.second.intValue();
                PhotoView photoView2 = this.wCW;
                if (photoView2 == null) {
                    p.btv("thumbIv");
                }
                photoView2.getLayoutParams().height = go.SWY.intValue();
                PhotoView photoView3 = this.wCW;
                if (photoView3 == null) {
                    p.btv("thumbIv");
                }
                photoView3.setScaleType(ImageView.ScaleType.values()[go.first.intValue()]);
                PhotoView photoView4 = this.wCW;
                if (photoView4 == null) {
                    p.btv("thumbIv");
                }
                photoView4.requestLayout();
                if (first.mediaType == 4) {
                    p.g(first, "mediaObj");
                    k kVar = new k(first, x.THUMB_IMAGE, null, null, 12);
                    m mVar = m.uJa;
                    com.tencent.mm.loader.d<o> djY = m.djY();
                    PhotoView photoView5 = this.wCW;
                    if (photoView5 == null) {
                        p.btv("thumbIv");
                    }
                    if (photoView5 == null) {
                        p.hyc();
                    }
                    m mVar2 = m.uJa;
                    djY.a(kVar, photoView5, m.a(m.a.TIMELINE));
                } else {
                    p.g(first, "mediaObj");
                    k kVar2 = new k(first, x.THUMB_IMAGE, null, null, 12);
                    m mVar3 = m.uJa;
                    com.tencent.mm.loader.d<o> djY2 = m.djY();
                    PhotoView photoView6 = this.wCW;
                    if (photoView6 == null) {
                        p.btv("thumbIv");
                    }
                    if (photoView6 == null) {
                        p.hyc();
                    }
                    m mVar4 = m.uJa;
                    djY2.a(kVar2, photoView6, m.a(m.a.TIMELINE));
                }
                PhotoView photoView7 = this.wCW;
                if (photoView7 == null) {
                    p.btv("thumbIv");
                }
                photoView7.setOnClickListener(new b(this));
                AppMethodBeat.o(168610);
                return;
            }
        }
        Bundle bundle = this.dQL;
        this.wDa = bundle != null ? bundle.getStringArrayList("MEDIA_FILE_LIST") : null;
        Bundle bundle2 = this.dQL;
        this.wDb = bundle2 != null ? bundle2.getIntegerArrayList("MEDIA_TYPE_LIST") : null;
        Bundle bundle3 = this.dQL;
        ArrayList<String> stringArrayList = bundle3 != null ? bundle3.getStringArrayList("MEDIA_THUMB_LIST") : null;
        Bundle bundle4 = this.dQL;
        if (bundle4 == null) {
            p.hyc();
        }
        ArrayList<Parcelable> parcelableArrayList = bundle4.getParcelableArrayList("VIDEO_CROP_LIST");
        if (parcelableArrayList != null) {
            for (Parcelable parcelable : parcelableArrayList) {
                if (parcelable == null || !(parcelable instanceof LocalVideoCropInfoParcelable)) {
                    this.wDc.add(null);
                } else {
                    this.wDc.add(((LocalVideoCropInfoParcelable) parcelable).uOR);
                }
            }
        }
        if (this.wDa != null) {
            ArrayList<String> arrayList = this.wDa;
            if (arrayList == null) {
                p.hyc();
            }
            if (arrayList.size() > 0) {
                ArrayList<String> arrayList2 = this.wDa;
                if (arrayList2 == null) {
                    p.hyc();
                }
                if (arrayList2.size() > 1) {
                    TextView textView4 = this.wCX;
                    if (textView4 == null) {
                        p.btv("mediaCountView");
                    }
                    textView4.setVisibility(8);
                    TextView textView5 = this.wCX;
                    if (textView5 == null) {
                        p.btv("mediaCountView");
                    }
                    Context context2 = this.context;
                    Object[] objArr2 = new Object[1];
                    ArrayList<String> arrayList3 = this.wDa;
                    if (arrayList3 == null) {
                        p.hyc();
                    }
                    objArr2[0] = Integer.valueOf(arrayList3.size());
                    textView5.setText(context2.getString(R.string.cpb, objArr2));
                    View view3 = this.wCZ;
                    if (view3 == null) {
                        p.btv("multiIcon");
                    }
                    view3.setVisibility(0);
                } else {
                    TextView textView6 = this.wCX;
                    if (textView6 == null) {
                        p.btv("mediaCountView");
                    }
                    textView6.setVisibility(8);
                }
                ThreadPool.post(new c(this, stringArrayList), "Finder_Post_Create_Media_Thumb");
            }
        }
        AppMethodBeat.o(168610);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ e wDe;

        b(e eVar) {
            this.wDe = eVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168600);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wDe.dJn();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168600);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ e wDe;
        final /* synthetic */ ArrayList wDf;

        c(e eVar, ArrayList arrayList) {
            this.wDe = eVar;
            this.wDf = arrayList;
        }

        public final void run() {
            AppMethodBeat.i(168607);
            this.wDe.an(this.wDf);
            AppMethodBeat.o(168607);
        }
    }

    public final void an(ArrayList<String> arrayList) {
        String avU;
        Bitmap decodeFile;
        AppMethodBeat.i(256126);
        ArrayList<String> arrayList2 = this.wDa;
        if (arrayList2 == null) {
            p.hyc();
        }
        int i2 = 0;
        for (T t : arrayList2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            boolean z = i2 == 0;
            a.wCj = t2;
            p.h(t2, "file");
            ArrayList<Integer> arrayList3 = this.wDb;
            if (arrayList3 == null) {
                p.hyc();
            }
            Integer num = arrayList3.get(i2);
            if (num != null && num.intValue() == 2) {
                if (arrayList == null || arrayList.size() <= i2 || Util.isNullOrNil(arrayList.get(i2))) {
                    f fVar = f.vSz;
                    avU = f.avU(t2);
                } else {
                    String str = arrayList.get(i2);
                    p.g(str, "mediaThumbList[index]");
                    avU = str;
                }
            } else if (arrayList == null || arrayList.size() <= i2 || Util.isNullOrNil(arrayList.get(i2)) || !s.YS(arrayList.get(i2))) {
                if (this.wDc.size() > i2 && this.wDc.get(i2) != null) {
                    cjx cjx = this.wDc.get(i2);
                    if (cjx == null) {
                        p.hyc();
                    }
                    if (cjx.Mps != null) {
                        f fVar2 = f.vSz;
                        cjx cjx2 = this.wDc.get(i2);
                        if (cjx2 == null) {
                            p.hyc();
                        }
                        erf erf = cjx2.Mps;
                        if (erf == null) {
                            p.hyc();
                        }
                        p.g(erf, "mediaCropInfoList[index]!!.thumbRect!!");
                        avU = fVar2.a(t2, erf);
                    }
                }
                Log.w(TAG, "no thumb & no thumbRect");
                f fVar3 = f.vSz;
                avU = f.avT(t2);
            } else {
                String str2 = arrayList.get(i2);
                p.g(str2, "mediaThumbList[index]");
                avU = str2;
            }
            p.h(avU, "thumbFile");
            Log.i(TAG, "showVideoThumb, thumbFile:" + avU + ", showThumb:" + z);
            if (!Util.isNullOrNil(avU) && (decodeFile = BitmapUtil.decodeFile(avU)) != null) {
                MMHandlerThread.postToMainThread(new d(decodeFile, this, avU, z, decodeFile));
            }
            if (z) {
                ImageView imageView = this.wCY;
                if (imageView == null) {
                    p.btv("videoPlayIcon");
                }
                imageView.setVisibility(8);
            }
            i2 = i3;
        }
        AppMethodBeat.o(256126);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$1$1"})
    public static final class d implements Runnable {
        final /* synthetic */ Bitmap qix;
        final /* synthetic */ String wCP;
        final /* synthetic */ boolean wCT;
        final /* synthetic */ e wDe;
        final /* synthetic */ Bitmap wDg;

        d(Bitmap bitmap, e eVar, String str, boolean z, Bitmap bitmap2) {
            this.qix = bitmap;
            this.wDe = eVar;
            this.wCP = str;
            this.wCT = z;
            this.wDg = bitmap2;
        }

        public final void run() {
            AppMethodBeat.i(256123);
            this.wDe.wCD.add(this.wCP);
            a aVar = e.wDd;
            Log.i(e.TAG, "add thumb file");
            if (this.wCT) {
                y yVar = y.vXH;
                r<Integer, Integer, Integer> go = y.go(this.wDg.getWidth(), this.wDg.getHeight());
                this.wDe.dJm().getLayoutParams().width = go.second.intValue();
                this.wDe.dJm().getLayoutParams().height = go.SWY.intValue();
                this.wDe.dJm().setScaleType(ImageView.ScaleType.values()[go.first.intValue()]);
                this.wDe.dJm().requestLayout();
                this.wDe.dJm().post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.widget.post.e.d.AnonymousClass1 */
                    final /* synthetic */ d wDh;

                    {
                        this.wDh = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(256121);
                        this.wDh.wDe.dJm().setImageBitmap(this.wDh.qix);
                        AppMethodBeat.o(256121);
                    }
                });
                this.wDe.dJm().setOnClickListener(new View.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.widget.post.e.d.AnonymousClass2 */
                    final /* synthetic */ d wDh;

                    {
                        this.wDh = r1;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(256122);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        this.wDh.wDe.dJn();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(256122);
                    }
                });
            }
            AppMethodBeat.o(256123);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dJn() {
        /*
        // Method dump skipped, instructions count: 259
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.widget.post.e.dJn():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0016  */
    @Override // com.tencent.mm.plugin.finder.widget.post.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cyn() {
        /*
            r5 = this;
            r4 = 256128(0x3e880, float:3.58912E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.util.ArrayList<java.lang.String> r0 = r5.wDa
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
            java.lang.String r3 = "[PostMixMediaWidget] widget file:"
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.widget.post.e.cyn():boolean");
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.b
    public final View dJg() {
        AppMethodBeat.i(168608);
        Context context = this.context;
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(168608);
            throw tVar;
        }
        View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.aig, (ViewGroup) null);
        p.g(inflate, "(context as Activity).la…_post_media_widget, null)");
        this.lJI = inflate;
        View view = this.lJI;
        if (view == null) {
            p.btv("rootView");
        }
        View findViewById = view.findViewById(R.id.ime);
        p.g(findViewById, "rootView.findViewById(R.id.thumb_view)");
        this.wCW = (PhotoView) findViewById;
        View view2 = this.lJI;
        if (view2 == null) {
            p.btv("rootView");
        }
        View findViewById2 = view2.findViewById(R.id.fbt);
        p.g(findViewById2, "rootView.findViewById(R.id.media_number)");
        this.wCX = (TextView) findViewById2;
        View view3 = this.lJI;
        if (view3 == null) {
            p.btv("rootView");
        }
        View findViewById3 = view3.findViewById(R.id.j5o);
        p.g(findViewById3, "rootView.findViewById(R.id.video_play_icon)");
        this.wCY = (ImageView) findViewById3;
        View view4 = this.lJI;
        if (view4 == null) {
            p.btv("rootView");
        }
        View findViewById4 = view4.findViewById(R.id.fnf);
        p.g(findViewById4, "rootView.findViewById(R.id.multi_icon)");
        this.wCZ = findViewById4;
        View view5 = this.lJI;
        if (view5 == null) {
            p.btv("rootView");
        }
        View findViewById5 = view5.findViewById(R.id.h3h);
        p.g(findViewById5, "rootView.findViewById(R.id.reprint_iv)");
        this.wCA = findViewById5;
        View view6 = this.lJI;
        if (view6 == null) {
            p.btv("rootView");
        }
        AppMethodBeat.o(168608);
        return view6;
    }

    @Override // com.tencent.mm.plugin.finder.widget.post.b
    public final g dJh() {
        boolean z;
        AppMethodBeat.i(256125);
        if (this.vTz == null || this.wCb == null) {
            ArrayList<String> arrayList = this.wDa;
            if (!(arrayList == null || arrayList.isEmpty())) {
                String str = TAG;
                StringBuilder sb = new StringBuilder("media list ");
                ArrayList<String> arrayList2 = this.wDa;
                if (arrayList2 == null) {
                    p.hyc();
                }
                Log.i(str, sb.append(arrayList2.size()).append(", thumb list ").append(this.wCD.size()).toString());
                ArrayList<String> arrayList3 = this.wDa;
                if (arrayList3 == null) {
                    p.hyc();
                }
                z = arrayList3.size() == this.wCD.size();
            } else {
                Log.i(TAG, "media list null");
                z = false;
            }
            if (z) {
                cjk cjk = new cjk();
                ArrayList<String> arrayList4 = this.wDa;
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
                    ArrayList<Integer> arrayList5 = this.wDb;
                    if (arrayList5 == null) {
                        p.hyc();
                    }
                    Integer num = arrayList5.get(i2);
                    if (num != null && num.intValue() == 2) {
                        LinkedList<cjl> linkedList = cjk.mediaList;
                        i iVar = i.vSX;
                        String str2 = this.wCD.get(i2);
                        p.g(str2, "thumbFileList[index]");
                        linkedList.add(i.hb(t2, str2));
                        i2 = i3;
                    } else {
                        LinkedList<cjl> linkedList2 = cjk.mediaList;
                        i iVar2 = i.vSX;
                        String nullAsNil = Util.nullAsNil(this.wCD.get(i2));
                        p.g(nullAsNil, "Util.nullAsNil(thumbFileList[index])");
                        linkedList2.add(i.a(t2, nullAsNil, this.wDc.size() > i2 ? this.wDc.get(i2) : null));
                        i2 = i3;
                    }
                }
                g gVar = new g(true, 8, cjk);
                AppMethodBeat.o(256125);
                return gVar;
            }
            g gVar2 = new g(false, 0, null);
            AppMethodBeat.o(256125);
            return gVar2;
        }
        g gVar3 = new g(true, 8, this.wCb);
        AppMethodBeat.o(256125);
        return gVar3;
    }
}
