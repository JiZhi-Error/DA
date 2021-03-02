package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/sns/ui/FinderPicWidget;", "Lcom/tencent/mm/plugin/sns/ui/PicWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "finderShareObject", "Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "mediaPath", "", "handlerOnCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "Landroid/view/View;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPrepareCommitPack", "packHelper", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "ThumbLoader", "plugin-sns_release"})
public final class by extends aq {
    private d EpQ;
    String mediaPath = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public by(MMActivity mMActivity) {
        super(mMActivity);
        p.h(mMActivity, "context");
        AppMethodBeat.i(259414);
        AppMethodBeat.o(259414);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad, com.tencent.mm.plugin.sns.ui.aq
    public final void aC(Bundle bundle) {
        Map<String, String> parseXml;
        AppMethodBeat.i(259411);
        super.aC(bundle);
        MMActivity mMActivity = this.gte;
        p.g(mMActivity, "context");
        String stringExtra = mMActivity.getIntent().getStringExtra("sns_kemdia_path");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mediaPath = stringExtra;
        MMActivity mMActivity2 = this.gte;
        p.g(mMActivity2, "context");
        String stringExtra2 = mMActivity2.getIntent().getStringExtra("ksnsupload_finder_live_xml");
        if (!Util.isNullOrNil(stringExtra2) && (parseXml = XmlParser.parseXml(stringExtra2, "finderLive", null)) != null) {
            d dVar = new d();
            dVar.j("", parseXml);
            this.EpQ = dVar;
        }
        AppMethodBeat.o(259411);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad, com.tencent.mm.plugin.sns.ui.aq
    public final View ffB() {
        AppMethodBeat.i(259412);
        View inflate = aa.jQ(this.gte).inflate(R.layout.cg4, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.k2h);
        d dVar = this.EpQ;
        if (!(dVar == null || dVar.jlf == null)) {
            int[] ha = ap.ha(this.gte);
            Pair<Integer, Integer> a2 = n.a(ha[0], ha[1], this.gte, false);
            Integer num = (Integer) a2.first;
            p.g(num, "smallSide");
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(num.intValue(), (int) ((((Number) a2.first).floatValue() * 3.5f) / 3.0f));
            p.g(inflate, "layout");
            inflate.setLayoutParams(layoutParams);
            inflate.requestLayout();
            p.g(imageView, "thumb");
            new a(imageView, this.mediaPath).y("");
            imageView.setOnClickListener(new b(this, inflate, imageView));
        }
        p.g(inflate, "layout");
        AppMethodBeat.o(259412);
        return inflate;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/sns/ui/FinderPicWidget$initView$1$1"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ by VaP;
        final /* synthetic */ View VaQ;
        final /* synthetic */ ImageView VaR;

        b(by byVar, View view, ImageView imageView) {
            this.VaP = byVar;
            this.VaQ = view;
            this.VaR = imageView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(259410);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/FinderPicWidget$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.setClass(this.VaP.gte, SnsUploadBrowseUI.class);
            intent.putExtra("k_need_delete", false);
            intent.putExtra("sns_gallery_position", 0);
            intent.putExtra("key_from_scene", 7);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.VaP.mediaPath);
            intent.putExtra("sns_gallery_temp_paths", arrayList);
            this.VaP.gte.startActivityForResult(intent, 7);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/FinderPicWidget$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(259410);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.aq
    public final void b(bf bfVar) {
        AppMethodBeat.i(259413);
        if (!(this.EpQ == null || bfVar == null)) {
            bfVar.a(this.EpQ);
        }
        super.b(bfVar);
        AppMethodBeat.o(259413);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad, com.tencent.mm.plugin.sns.ui.aq
    public final boolean k(int i2, Intent intent) {
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ%\u0010\u000b\u001a\u00020\u00042\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\r\"\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/sns/ui/FinderPicWidget$ThumbLoader;", "Lcom/tencent/mm/plugin/sns/model/MagicAsyncTask;", "", "", "", "iv", "Landroid/widget/ImageView;", "path", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "bm", "Landroid/graphics/Bitmap;", "doInBackground", NativeProtocol.WEB_DIALOG_PARAMS, "", "([Ljava/lang/String;)Ljava/lang/Boolean;", "getExecutor", "Ljava/util/concurrent/ExecutorService;", "onPostExecute", "", "result", "plugin-sns_release"})
    public static final class a extends h<String, Integer, Boolean> {
        private final ImageView dPk;
        private Bitmap iKs;
        private final String path;

        public a(ImageView imageView, String str) {
            p.h(imageView, "iv");
            p.h(str, "path");
            AppMethodBeat.i(259409);
            this.dPk = imageView;
            this.path = str;
            AppMethodBeat.o(259409);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ Boolean doInBackground(String[] strArr) {
            AppMethodBeat.i(259406);
            p.h(strArr, NativeProtocol.WEB_DIALOG_PARAMS);
            this.iKs = BitmapUtil.extractThumbNail(this.path, aj.fbb(), aj.fbb(), true);
            Exif fromFile = Exif.fromFile(this.path);
            p.g(fromFile, "Exif.fromFile(path)");
            int orientationInDegree = fromFile.getOrientationInDegree();
            Log.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", this.path, Integer.valueOf(orientationInDegree));
            this.iKs = BitmapUtil.rotate(this.iKs, (float) orientationInDegree);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(259406);
            return bool;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ void onPostExecute(Boolean bool) {
            AppMethodBeat.i(259407);
            super.onPostExecute(Boolean.valueOf(bool.booleanValue()));
            if (r.M(this.iKs)) {
                this.dPk.setImageBitmap(this.iKs);
            }
            AppMethodBeat.o(259407);
        }

        @Override // com.tencent.mm.plugin.sns.model.h
        public final ExecutorService eGk() {
            AppMethodBeat.i(259408);
            ExecutorService fay = aj.fay();
            p.g(fay, "SnsCore.getMediaExecutor()");
            AppMethodBeat.o(259408);
            return fay;
        }
    }
}
