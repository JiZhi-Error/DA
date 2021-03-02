package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ1\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u0010R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderFavUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "doFav", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "context", "Lcom/tencent/mm/ui/MMActivity;", "getFeedThumbInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "thumbPath", "plugin-finder_release"})
public final class g {
    private static final String TAG = TAG;
    public static final g vVq = new g();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "thumbPath", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ MMActivity $context;
        final /* synthetic */ BaseFinderFeed tEM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(BaseFinderFeed baseFinderFeed, MMActivity mMActivity) {
            super(1);
            this.tEM = baseFinderFeed;
            this.$context = mMActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(167873);
            String str2 = str;
            p.h(str2, "thumbPath");
            s.a aVar = s.vWt;
            FinderItem finderItem = this.tEM.feedObject;
            p.h(finderItem, "feed");
            p.h(str2, "thumbPath");
            cz czVar = new cz();
            anb anb = new anb();
            anh anh = new anh();
            anh.bhf(z.aTY());
            anh.bhk(new StringBuilder().append(finderItem.getId()).toString());
            anh.MA(finderItem.m21getCreateTime());
            anb.a(anh);
            anb.d(s.a.x(finderItem));
            czVar.dFZ.title = "";
            czVar.dFZ.dGb = anb;
            czVar.dFZ.type = 20;
            czVar.dFZ.activity = this.$context;
            g gVar = g.vVq;
            Log.i(g.getTAG(), "publish fav event, id:" + this.tEM.lT());
            EventCenter.instance.publish(czVar);
            x xVar = x.SXb;
            AppMethodBeat.o(167873);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(167881);
        AppMethodBeat.o(167881);
    }

    private g() {
    }

    public static String getTAG() {
        return TAG;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(BaseFinderFeed baseFinderFeed, MMActivity mMActivity) {
        AppMethodBeat.i(167880);
        p.h(baseFinderFeed, "feed");
        p.h(mMActivity, "context");
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.avp("share")) {
            AppMethodBeat.o(167880);
            return;
        }
        baseFinderFeed.feedObject.getMediaType();
        e.INSTANCE.idkeyStat(1278, 10, 1, false);
        k kVar = k.vfA;
        k.f(baseFinderFeed.feedObject);
        FinderObject feedObject = baseFinderFeed.feedObject.getFeedObject();
        a aVar2 = new a(baseFinderFeed, mMActivity);
        p.h(feedObject, "feed");
        p.h(aVar2, "callback");
        z.f fVar = new z.f();
        fVar.SYG = "";
        z.f fVar2 = new z.f();
        fVar2.SYG = "";
        FinderObjectDesc finderObjectDesc = feedObject.objectDesc;
        if (finderObjectDesc == null) {
            AppMethodBeat.o(167880);
        } else if (finderObjectDesc.media.size() < 0 || finderObjectDesc.media.size() != 0) {
            LinkedList<FinderMedia> linkedList = finderObjectDesc.media;
            p.g(linkedList, "it.media");
            FinderMedia first = linkedList.getFirst();
            switch (first.mediaType) {
                case 2:
                    c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    p.g(first, "firstMedia");
                    com.tencent.mm.plugin.finder.loader.k kVar2 = new com.tencent.mm.plugin.finder.loader.k(c.a.b(first), com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE, null, null, 12);
                    fVar.SYG = (T) kVar2.getPath();
                    fVar2.SYG = (T) kVar2.aBE();
                    if (com.tencent.mm.vfs.s.YS(fVar.SYG)) {
                        Log.i(TAG, "image thumbPath exist, callback");
                        aVar2.invoke(fVar.SYG);
                        AppMethodBeat.o(167880);
                        return;
                    }
                    Log.i(TAG, "image thumbPath not exist, download: " + ((String) fVar2.SYG));
                    m mVar = m.uJa;
                    com.tencent.mm.loader.a.b<o, Bitmap> bQ = m.djY().bQ(kVar2);
                    bQ.hYl = new c(feedObject, aVar2, fVar, fVar2);
                    bQ.aJw();
                    AppMethodBeat.o(167880);
                    return;
                case 4:
                    c.a aVar4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    p.g(first, "firstMedia");
                    com.tencent.mm.plugin.finder.loader.k kVar3 = new com.tencent.mm.plugin.finder.loader.k(c.a.b(first), com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE, null, null, 12);
                    fVar.SYG = (T) kVar3.getPath();
                    fVar2.SYG = (T) kVar3.aBE();
                    if (!com.tencent.mm.vfs.s.YS(fVar.SYG)) {
                        Log.i(TAG, "video thumbPath not exist, download: " + ((String) fVar2.SYG));
                        m mVar2 = m.uJa;
                        com.tencent.mm.loader.a.b<o, Bitmap> bQ2 = m.djY().bQ(kVar3);
                        bQ2.hYl = new d(feedObject, aVar2, fVar, fVar2);
                        bQ2.aJw();
                        break;
                    } else {
                        Log.i(TAG, "video thumbPath exist, callback");
                        aVar2.invoke(fVar.SYG);
                        AppMethodBeat.o(167880);
                        return;
                    }
            }
            AppMethodBeat.o(167880);
        } else {
            if (finderObjectDesc.mediaType == 1) {
                com.tencent.mm.ac.d.i(new b(feedObject, aVar2, fVar, fVar2));
            }
            AppMethodBeat.o(167880);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/utils/FinderFavUtil$getFeedThumbInfo$1$2", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "onImageDownload", "", "success", "", "extraObj", "", "", "(Z[Ljava/lang/Object;)V", "plugin-finder_release"})
    public static final class c implements com.tencent.mm.loader.f.a {
        final /* synthetic */ kotlin.g.a.b ipQ;
        final /* synthetic */ FinderObject vVr;
        final /* synthetic */ z.f vVs;
        final /* synthetic */ z.f vVt;

        c(FinderObject finderObject, kotlin.g.a.b bVar, z.f fVar, z.f fVar2) {
            this.vVr = finderObject;
            this.ipQ = bVar;
            this.vVs = fVar;
            this.vVt = fVar2;
        }

        @Override // com.tencent.mm.loader.f.a
        public final void a(boolean z, Object... objArr) {
            AppMethodBeat.i(167877);
            p.h(objArr, "extraObj");
            g gVar = g.vVq;
            Log.i(g.getTAG(), "image thumbPath download succ:".concat(String.valueOf(z)));
            if (z) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.utils.g.c.AnonymousClass1 */
                    final /* synthetic */ c vVv;

                    {
                        this.vVv = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* bridge */ /* synthetic */ x invoke() {
                        AppMethodBeat.i(167876);
                        this.vVv.ipQ.invoke(this.vVv.vVs.SYG);
                        x xVar = x.SXb;
                        AppMethodBeat.o(167876);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(167877);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/utils/FinderFavUtil$getFeedThumbInfo$1$3", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "onImageDownload", "", "success", "", "extraObj", "", "", "(Z[Ljava/lang/Object;)V", "plugin-finder_release"})
    public static final class d implements com.tencent.mm.loader.f.a {
        final /* synthetic */ kotlin.g.a.b ipQ;
        final /* synthetic */ FinderObject vVr;
        final /* synthetic */ z.f vVs;
        final /* synthetic */ z.f vVt;

        d(FinderObject finderObject, kotlin.g.a.b bVar, z.f fVar, z.f fVar2) {
            this.vVr = finderObject;
            this.ipQ = bVar;
            this.vVs = fVar;
            this.vVt = fVar2;
        }

        @Override // com.tencent.mm.loader.f.a
        public final void a(boolean z, Object... objArr) {
            AppMethodBeat.i(167879);
            p.h(objArr, "extraObj");
            g gVar = g.vVq;
            Log.i(g.getTAG(), "video thumbPath download succ:".concat(String.valueOf(z)));
            if (z) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.utils.g.d.AnonymousClass1 */
                    final /* synthetic */ d vVw;

                    {
                        this.vVw = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* bridge */ /* synthetic */ x invoke() {
                        AppMethodBeat.i(167878);
                        this.vVw.ipQ.invoke(this.vVw.vVs.SYG);
                        x xVar = x.SXb;
                        AppMethodBeat.o(167878);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(167879);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderFavUtil$getFeedThumbInfo$1$1"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.b ipQ;
        final /* synthetic */ FinderObject vVr;
        final /* synthetic */ z.f vVs;
        final /* synthetic */ z.f vVt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderObject finderObject, kotlin.g.a.b bVar, z.f fVar, z.f fVar2) {
            super(0);
            this.vVr = finderObject;
            this.ipQ = bVar;
            this.vVs = fVar;
            this.vVt = fVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            AppMethodBeat.i(167875);
            View inflate = LayoutInflater.from(MMApplicationContext.getContext()).inflate(R.layout.a_r, (ViewGroup) null);
            TextView textView = inflate != null ? (TextView) inflate.findViewById(R.id.cc1) : null;
            if (textView != null) {
                Context context = MMApplicationContext.getContext();
                FinderObjectDesc finderObjectDesc = this.vVr.objectDesc;
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, (finderObjectDesc == null || (str = finderObjectDesc.description) == null) ? "" : str));
            }
            int aH = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a57);
            inflate.measure(View.MeasureSpec.makeMeasureSpec(aH, 1073741824), View.MeasureSpec.makeMeasureSpec(aH, 1073741824));
            inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
            Bitmap createBitmap = Bitmap.createBitmap(aH, aH, Bitmap.Config.RGB_565);
            inflate.draw(new Canvas(createBitmap));
            StringBuilder sb = new StringBuilder();
            al alVar = al.waC;
            final String sb2 = sb.append(al.dEy()).append(com.tencent.mm.model.z.aTY()).append("/fav_").append(this.vVr.id).toString();
            if (BitmapUtil.saveBitmapToImage(createBitmap, 80, Bitmap.CompressFormat.JPEG, sb2, true)) {
                g gVar = g.vVq;
                Log.i(g.getTAG(), "gen text thumb succ, ".concat(String.valueOf(sb2)));
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.utils.g.b.AnonymousClass1 */
                    final /* synthetic */ b vVu;

                    {
                        this.vVu = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* bridge */ /* synthetic */ x invoke() {
                        AppMethodBeat.i(167874);
                        this.vVu.ipQ.invoke(sb2);
                        x xVar = x.SXb;
                        AppMethodBeat.o(167874);
                        return xVar;
                    }
                });
            } else {
                g gVar2 = g.vVq;
                Log.i(g.getTAG(), "gen text thumb failed.");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167875);
            return xVar;
        }
    }
}
