package com.tencent.mm.plugin.festival.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.festival.c.j;
import com.tencent.mm.plugin.festival.model.a.d;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u0019\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalFairyWandShareLogic;", "", "()V", "SaveDir", "", "TAG", "calender", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "capture", "", "root", "Landroid/view/ViewGroup;", "canvas", "Landroid/graphics/Canvas;", "doExportImage", "imgPath", "context", "Landroid/content/Context;", "getWaterMaskBg", "Landroid/graphics/drawable/Drawable;", "prepareWaterMask", "saveToLocalPath", "works", "Landroid/graphics/Bitmap;", "sendToFriend", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "shareSns", "plugin-festival_release"})
public final class f {
    private static final Calendar Usb = Calendar.getInstance();
    private static final String UxS = (b.aKC() + "festival2021/fairywand/");
    public static final f UxT = new f();

    static {
        AppMethodBeat.i(262935);
        AppMethodBeat.o(262935);
    }

    private f() {
    }

    public static void c(Context context, Bitmap bitmap) {
        AppMethodBeat.i(262930);
        p.h(context, "context");
        if (bitmap != null) {
            try {
                s.boN(UxS);
                String str = UxS + "snapshot.png";
                if (s.YS(str)) {
                    s.deleteFile(str);
                }
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, str, true);
                if (str == null) {
                    p.hyc();
                }
                com.tencent.mm.platformtools.p.a(context, str, new a(context));
                d dVar = d.UAc;
                d.a(d.a.SaveToLocal);
                AppMethodBeat.o(262930);
            } catch (Exception e2) {
                Log.e("FestivalFairyWandShareLogic", "saveToLocalPath e:".concat(String.valueOf(e2)));
                AppMethodBeat.o(262930);
            }
        } else {
            Log.e("FestivalFairyWandShareLogic", "saveToLocalPath bitmap null");
            AppMethodBeat.o(262930);
        }
    }

    public static void s(ViewGroup viewGroup) {
        AppMethodBeat.i(262931);
        p.h(viewGroup, "root");
        View inflate = aa.jQ(viewGroup.getContext()).inflate(R.layout.cee, (ViewGroup) null);
        viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.jvk);
        p.g(relativeLayout, "root.festival_water_mask");
        relativeLayout.setVisibility(4);
        p.g(inflate, "view");
        TextView textView = (TextView) inflate.findViewById(R.id.jvn);
        String format = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
        p.g(textView, LocaleUtil.ITALIAN);
        textView.setText(APLogFileUtil.SEPARATOR_LOG.concat(String.valueOf(format)));
        textView.setIncludeFontPadding(false);
        TextView textView2 = (TextView) inflate.findViewById(R.id.jvo);
        j jVar = j.UGJ;
        p.g(textView2, LocaleUtil.ITALIAN);
        j.g(textView2, String.valueOf(z.aUa()));
        textView2.setIncludeFontPadding(false);
        c cVar = new c(z.aTY(), 0.1f);
        cVar.zO(false);
        Bitmap createBitmap = Bitmap.createBitmap(16, 16, Bitmap.Config.ALPHA_8);
        cVar.draw(new Canvas(createBitmap));
        createBitmap.recycle();
        a.b.d((WeImageView) inflate.findViewById(R.id.jvl), z.aTY());
        AppMethodBeat.o(262931);
    }

    public static void a(Bitmap bitmap, com.tencent.mm.live.c.b bVar) {
        AppMethodBeat.i(262932);
        p.h(bVar, "statusMonitor");
        String str = UxS + System.currentTimeMillis();
        BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, str, true);
        b.c cVar = b.c.zen;
        Bundle bundle = new Bundle();
        bundle.putString("FariyWandPicPath", str);
        bVar.statusChange(cVar, bundle);
        AppMethodBeat.o(262932);
    }

    public static void b(Bitmap bitmap, com.tencent.mm.live.c.b bVar) {
        AppMethodBeat.i(262933);
        p.h(bVar, "statusMonitor");
        String str = UxS + System.currentTimeMillis();
        BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, str, true);
        b.c cVar = b.c.zeD;
        Bundle bundle = new Bundle();
        bundle.putString("FariyWandPicPath", str);
        bVar.statusChange(cVar, bundle);
        AppMethodBeat.o(262933);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/festival/model/FestivalFairyWandShareLogic$doExportImage$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-festival_release"})
    public static final class a implements p.a {
        final /* synthetic */ Context $context;

        a(Context context) {
            this.$context = context;
        }

        @Override // com.tencent.mm.platformtools.p.a
        public final void bP(String str, String str2) {
            AppMethodBeat.i(262928);
            kotlin.g.b.p.h(str, "srcPath");
            kotlin.g.b.p.h(str2, "destPath");
            Toast.makeText(this.$context, this.$context.getString(R.string.e2z, str2), 1).show();
            AndroidMediaUtil.refreshMediaScanner(str2, this.$context);
            AppMethodBeat.o(262928);
        }

        @Override // com.tencent.mm.platformtools.p.a
        public final void bQ(String str, String str2) {
            AppMethodBeat.i(262929);
            kotlin.g.b.p.h(str, "srcPath");
            kotlin.g.b.p.h(str2, "destPath");
            Toast.makeText(this.$context, this.$context.getString(R.string.gao), 1).show();
            AppMethodBeat.o(262929);
        }
    }

    public static Drawable me(Context context) {
        int i2;
        AppMethodBeat.i(262934);
        Calendar calendar = Usb;
        kotlin.g.b.p.g(calendar, "calender");
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i3 = Usb.get(11);
        if (6 <= i3 && 18 > i3) {
            i2 = R.drawable.cu5;
        } else {
            i2 = R.drawable.cu6;
        }
        Drawable l = android.support.v4.content.b.l(context, i2);
        AppMethodBeat.o(262934);
        return l;
    }
}
