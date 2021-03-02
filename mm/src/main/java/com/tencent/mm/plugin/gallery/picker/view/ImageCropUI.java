package com.tencent.mm.plugin.gallery.picker.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.picker.b.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.g.b.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 |2\u00020\u0001:\u0001|B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010U\u001a\u00020VH\u0002J\u0012\u0010W\u001a\u0004\u0018\u0001022\u0006\u0010X\u001a\u000202H\u0002J\b\u0010Y\u001a\u00020VH\u0002J\n\u0010Z\u001a\u0004\u0018\u000102H\u0002J(\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\u00142\u0006\u0010`\u001a\u00020\u0014H\u0002J\b\u0010a\u001a\u00020bH\u0002J(\u0010c\u001a\u00020b2\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\u00142\u0006\u0010`\u001a\u00020\u0014H\u0002J\u0012\u0010f\u001a\u0004\u0018\u00010@2\u0006\u0010g\u001a\u00020\u0004H\u0002J\b\u0010h\u001a\u00020\u0014H\u0014J\b\u0010i\u001a\u00020VH\u0002J\b\u0010j\u001a\u00020VH\u0002J\b\u0010k\u001a\u00020VH\u0002J\u0018\u0010l\u001a\u00020V2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0014H\u0002J\b\u0010m\u001a\u00020VH\u0002J\b\u0010n\u001a\u00020VH\u0002J\b\u0010o\u001a\u00020VH\u0016J\u0012\u0010p\u001a\u00020V2\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J\b\u0010s\u001a\u00020VH\u0014J\u0010\u0010t\u001a\u00020V2\u0006\u0010u\u001a\u00020#H\u0002J\b\u0010v\u001a\u00020\u0004H\u0002J\"\u0010v\u001a\u00020#2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010w\u001a\u0002022\b\b\u0002\u0010x\u001a\u00020#H\u0002J\u0010\u0010y\u001a\u00020V2\u0006\u0010z\u001a\u00020\u0014H\u0017J\b\u0010{\u001a\u00020VH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0018\u001a\n \u000b*\u0004\u0018\u00010\u00190\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\n \u000b*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0001\u0010$\u001aw\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110)¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(*\u0012C\u0012A\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.0+¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020.0%X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b;\u0010\u000f\u001a\u0004\b:\u0010\u0006R\u000e\u0010<\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X.¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\bE\u0010\u000f\u001a\u0004\bD\u0010\u0006RY\u0010F\u001aJ\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020)\u00124\u00122\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.0+\u0012\u0004\u0012\u00020.0%¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR#\u0010I\u001a\n \u000b*\u0004\u0018\u00010)0)8BX\u0002¢\u0006\f\n\u0004\bL\u0010\u000f\u001a\u0004\bJ\u0010KR#\u0010M\u001a\n \u000b*\u0004\u0018\u00010N0N8BX\u0002¢\u0006\f\n\u0004\bQ\u0010\u000f\u001a\u0004\bO\u0010PR#\u0010R\u001a\n \u000b*\u0004\u0018\u00010N0N8BX\u0002¢\u0006\f\n\u0004\bT\u0010\u000f\u001a\u0004\bS\u0010P¨\u0006}"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "backupPath", "", "getBackupPath", "()Ljava/lang/String;", "setBackupPath", "(Ljava/lang/String;)V", "cancelCropButton", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getCancelCropButton", "()Landroid/widget/Button;", "cancelCropButton$delegate", "Lkotlin/Lazy;", "confirmCropButton", "getConfirmCropButton", "confirmCropButton$delegate", "cropImgMode", "", "getCropImgMode", "()I", "cropImgMode$delegate", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "cropOperateLayout", "Landroid/widget/LinearLayout;", "getCropOperateLayout", "()Landroid/widget/LinearLayout;", "cropOperateLayout$delegate", "cropping", "", "defaultImageContentCreator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "degree", "displayBitmap", "Landroid/graphics/Bitmap;", "getDisplayBitmap", "()Landroid/graphics/Bitmap;", "setDisplayBitmap", "(Landroid/graphics/Bitmap;)V", "emojiBmp", "imageLoaded", "imgPath", "getImgPath", "imgPath$delegate", "isGif", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mattingImageInfo", "", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "outputPath", "getOutputPath", "outputPath$delegate", "previewMatting", "getPreviewMatting", "()Lkotlin/jvm/functions/Function3;", "previewView", "getPreviewView", "()Landroid/widget/ImageView;", "previewView$delegate", "rotateButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getRotateButton", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rotateButton$delegate", "undoButton", "getUndoButton", "undoButton$delegate", "backgroundCrop", "", "compressMattingImage", "source", "cropAvatar", "getCropBackImg", "getCropMatrix", "Landroid/graphics/Matrix;", "imgWidth", "imgHeight", "scrWidth", "scrHeight", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getFullVisibilityRect", "w", "h", "getImageInfo", "imagePath", "getLayoutId", "initMMView", "initMattingCropLayout", "initShowView", "loadBackgroundPreviewImg", "loadPreview", "mattingCrop", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "previewCrop", "compress", "saveImg", "bm", "recycle", "setRequestedOrientation", "requestedOrientation", "showLoadingDialog", "Companion", "plugin-gallery_release"})
public final class ImageCropUI extends MMActivity {
    public static final a xlX = new a((byte) 0);
    private com.tencent.mm.ui.base.q gxX;
    private final kotlin.f vLg = kotlin.g.ah(new g(this));
    private com.tencent.mm.plugin.gallery.picker.b.b vLu;
    private final kotlin.f xlE = kotlin.g.ah(new x(this));
    private final kotlin.f xlF = kotlin.g.ah(new h(this));
    private final kotlin.f xlG = kotlin.g.ah(new c(this));
    private final kotlin.f xlH = kotlin.g.ah(new d(this));
    private final kotlin.f xlI = kotlin.g.ah(new z(this));
    private final kotlin.f xlJ = kotlin.g.ah(new y(this));
    private final kotlin.f xlK = kotlin.g.ah(new j(this));
    private final kotlin.f xlL = kotlin.g.ah(new f(this));
    private String xlM = "";
    Bitmap xlN;
    private final kotlin.f xlO = kotlin.g.ah(new v(this));
    private boolean xlP;
    private int xlQ;
    private boolean xlR;
    private int[] xlS;
    private Bitmap xlT;
    private boolean xlU;
    final kotlin.g.a.q<String, ImageView, kotlin.g.a.m<? super Integer, ? super Integer, ? extends Object>, Object> xlV = new w(this);
    private final kotlin.g.a.q<String, ImageView, kotlin.g.a.m<? super Integer, ? super Integer, ? extends Object>, Object> xlW = new i(this);

    static {
        AppMethodBeat.i(257836);
        AppMethodBeat.o(257836);
    }

    private final String ajP() {
        AppMethodBeat.i(257823);
        String str = (String) this.xlK.getValue();
        AppMethodBeat.o(257823);
        return str;
    }

    private final ImageView dRF() {
        AppMethodBeat.i(257822);
        ImageView imageView = (ImageView) this.xlE.getValue();
        AppMethodBeat.o(257822);
        return imageView;
    }

    private final int dRG() {
        AppMethodBeat.i(257824);
        int intValue = ((Number) this.xlL.getValue()).intValue();
        AppMethodBeat.o(257824);
        return intValue;
    }

    private final String dRH() {
        AppMethodBeat.i(257825);
        String str = (String) this.xlO.getValue();
        AppMethodBeat.o(257825);
        return str;
    }

    private final WxMediaCropLayout dzH() {
        AppMethodBeat.i(257821);
        WxMediaCropLayout wxMediaCropLayout = (WxMediaCropLayout) this.vLg.getValue();
        AppMethodBeat.o(257821);
        return wxMediaCropLayout;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        AppMethodBeat.at(this, z2);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\b"}, hxF = {"<anonymous>", "", "isSuccessful", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$cropAvatar$1$1$1", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$$special$$inlined$apply$lambda$1"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, b.f, kotlin.x> {
        final /* synthetic */ ImageCropUI xlY;
        final /* synthetic */ WxMediaCropLayout.b xma;
        final /* synthetic */ String xmb;
        final /* synthetic */ b.C1388b xmc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(WxMediaCropLayout.b bVar, String str, ImageCropUI imageCropUI, b.C1388b bVar2) {
            super(2);
            this.xma = bVar;
            this.xmb = str;
            this.xlY = imageCropUI;
            this.xmc = bVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Boolean bool, b.f fVar) {
            AppMethodBeat.i(257786);
            boolean booleanValue = bool.booleanValue();
            b.f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, "result");
            com.tencent.mm.ui.base.q qVar = this.xlY.gxX;
            if (qVar != null) {
                qVar.dismiss();
            }
            if (booleanValue) {
                a aVar = a.xlD;
                a.NH(9);
                Intent intent = new Intent();
                intent.putExtra("CropImage_OutputPath", fVar2.xli);
                this.xlY.setResult(-1, intent);
                Log.i("MicroMsg.AvatarCropUI", "finish avatar/cover crop");
                this.xlY.finish();
            } else {
                a aVar2 = a.xlD;
                a.NH(8);
                this.xlY.setResult(-1);
                Log.e("MicroMsg.AvatarCropUI", "avatar/cover crop error");
                this.xlY.finish();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257786);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007H\n¢\u0006\u0002\b\u000e"}, hxF = {"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.q<String, ImageView, kotlin.g.a.m<? super Integer, ? super Integer, ? extends Object>, kotlin.x> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(ImageCropUI imageCropUI) {
            super(3);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(String str, ImageView imageView, kotlin.g.a.m<? super Integer, ? super Integer, ? extends Object> mVar) {
            AppMethodBeat.i(257792);
            final String str2 = str;
            final ImageView imageView2 = imageView;
            final kotlin.g.a.m<? super Integer, ? super Integer, ? extends Object> mVar2 = mVar;
            kotlin.g.b.p.h(str2, "mediaPath");
            kotlin.g.b.p.h(imageView2, "imageView");
            kotlin.g.b.p.h(mVar2, "loadedCallback");
            com.tencent.mm.ac.d.i(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.i.AnonymousClass1 */
                final /* synthetic */ i xmd;

                {
                    this.xmd = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
                /* JADX WARNING: Removed duplicated region for block: B:40:0x00fb  */
                @Override // kotlin.g.a.a
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final /* synthetic */ kotlin.x invoke() {
                    /*
                    // Method dump skipped, instructions count: 402
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.i.AnonymousClass1.invoke():java.lang.Object");
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257792);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007H\n¢\u0006\u0002\b\u000e"}, hxF = {"<anonymous>", "", "imgPath", "", "imgView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.q<String, ImageView, kotlin.g.a.m<? super Integer, ? super Integer, ? extends Object>, kotlin.x> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(ImageCropUI imageCropUI) {
            super(3);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(String str, ImageView imageView, kotlin.g.a.m<? super Integer, ? super Integer, ? extends Object> mVar) {
            AppMethodBeat.i(257817);
            final String str2 = str;
            final ImageView imageView2 = imageView;
            final kotlin.g.a.m<? super Integer, ? super Integer, ? extends Object> mVar2 = mVar;
            kotlin.g.b.p.h(str2, "imgPath");
            kotlin.g.b.p.h(imageView2, "imgView");
            kotlin.g.b.p.h(mVar2, "loadedCallback");
            Log.i("MicroMsg.AvatarCropUI", "enter previewMatting");
            com.tencent.mm.ac.d.i(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.w.AnonymousClass1 */
                final /* synthetic */ w xmt;

                {
                    this.xmt = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0118  */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x0154  */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x0163  */
                /* JADX WARNING: Removed duplicated region for block: B:49:0x03b5  */
                /* JADX WARNING: Removed duplicated region for block: B:50:0x03b8  */
                @Override // kotlin.g.a.a
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final /* synthetic */ kotlin.x invoke() {
                    /*
                    // Method dump skipped, instructions count: 1010
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.w.AnonymousClass1.invoke():java.lang.Object");
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257817);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI$Companion;", "", "()V", "BMP_HEIGHT", "", "BMP_WIDTH", "CHATTING_FOOT_HEIGHT_DP", "", "COMPRESS_QUALITY", "CUSTOM_EMOJI_TYPE_GIF", "CUSTOM_EMOJI_TYPE_PNG", "LONG_IMAGE_LIMIT", "LONG_IMAGE_MAX_MULTIPLE", "MAT_BMP_HEIGHT", "MAT_BMP_WIDTH", "TAG", "", "plugin-gallery_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public ImageCropUI() {
        AppMethodBeat.i(257835);
        AppMethodBeat.o(257835);
    }

    public static final /* synthetic */ WxMediaCropLayout e(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257839);
        WxMediaCropLayout dzH = imageCropUI.dzH();
        AppMethodBeat.o(257839);
        return dzH;
    }

    public static final /* synthetic */ int f(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257840);
        int dRG = imageCropUI.dRG();
        AppMethodBeat.o(257840);
        return dRG;
    }

    public static final /* synthetic */ String l(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257845);
        String dRH = imageCropUI.dRH();
        AppMethodBeat.o(257845);
        return dRH;
    }

    public static final /* synthetic */ String m(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257846);
        String ajP = imageCropUI.ajP();
        AppMethodBeat.o(257846);
        return ajP;
    }

    public static final /* synthetic */ int[] n(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257848);
        int[] iArr = imageCropUI.xlS;
        if (iArr == null) {
            kotlin.g.b.p.btv("mattingImageInfo");
        }
        AppMethodBeat.o(257848);
        return iArr;
    }

    public static final /* synthetic */ boolean o(String str, Bitmap bitmap) {
        AppMethodBeat.i(257851);
        boolean a2 = a(str, bitmap, false);
        AppMethodBeat.o(257851);
        return a2;
    }

    public static final /* synthetic */ Bitmap p(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257850);
        Bitmap dRI = imageCropUI.dRI();
        AppMethodBeat.o(257850);
        return dRI;
    }

    public static final /* synthetic */ RectF q(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257852);
        RectF dzt = imageCropUI.dzt();
        AppMethodBeat.o(257852);
        return dzt;
    }

    public static final /* synthetic */ ImageView s(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257853);
        ImageView dRF = imageCropUI.dRF();
        AppMethodBeat.o(257853);
        return dRF;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.av1;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(257826);
        super.onCreate(bundle);
        a aVar = a.xlD;
        a.NH(10);
        setMMTitle("");
        if (dRG() == 1) {
            getWindow().setFlags(201327616, 201327616);
            setLightNavigationbarIcon();
            View findViewById = findViewById(R.id.dvc);
            findViewById.setPadding(0, 0, 0, au.aD(getContext()));
            findViewById.post(new k(this, findViewById));
            setActionbarColor(R.color.ac_);
            setActionbarColor(WebView.NIGHT_MODE_COLOR);
            fullScreenNoTitleBar(true, 0);
            LinearLayout linearLayout = (LinearLayout) this.xlF.getValue();
            kotlin.g.b.p.g(linearLayout, "cropOperateLayout");
            linearLayout.setVisibility(0);
            ((Button) this.xlG.getValue()).setOnClickListener(new l(this));
            ((Button) this.xlH.getValue()).setOnClickListener(new m(this));
            ((WeImageView) this.xlJ.getValue()).setOnClickListener(new n(this));
            ((WeImageView) this.xlI.getValue()).setOnClickListener(new o(this));
        } else {
            addTextOptionMenu(0, getString(R.string.dln), new p(this), null, t.b.GREEN);
            setBackBtn(new q(this));
        }
        this.xlU = false;
        bnj();
        switch (dRG()) {
            case 1:
                if (getIntent().getIntExtra("CropImage_from_scene", 0) == 3) {
                    a aVar2 = a.xlD;
                    a.NH(0);
                    Log.i("MicroMsg.AvatarCropUI", "scene avatar");
                } else {
                    a aVar3 = a.xlD;
                    a.NH(1);
                    Log.i("MicroMsg.AvatarCropUI", "scene cover");
                }
                WxMediaCropLayout dzH = dzH();
                dzH.setVisibility(0);
                dzH.setShowBorder(false);
                dzH.a(dzt(), WxCropOperationLayout.j.RECT_HARD);
                WxMediaCropLayout.a(dzH, System.currentTimeMillis(), ajP(), true, (WxMediaCropLayout.c) null, (kotlin.g.a.q) this.xlW, 8);
                AppMethodBeat.o(257826);
                return;
            case 2:
                a aVar4 = a.xlD;
                a.NH(2);
                Log.i("MicroMsg.AvatarCropUI", "scene background");
                ImageView dRF = dRF();
                dRF.post(new s(dRF, this));
                AppMethodBeat.o(257826);
                return;
            case 3:
                a aVar5 = a.xlD;
                a.NH(3);
                Log.i("MicroMsg.AvatarCropUI", "scene emoji");
                WxMediaCropLayout dzH2 = dzH();
                dzH2.setVisibility(0);
                dzH2.setShowBorder(false);
                dzH2.setCropLayoutScaleType(CropLayout.e.ALIGN_START);
                dzH2.dRJ();
                com.tencent.mm.ac.d.i(new r(dzH2, this));
                break;
            case 4:
                com.tencent.mm.ac.d.i(new t(this));
                AppMethodBeat.o(257826);
                return;
        }
        AppMethodBeat.o(257826);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(257827);
        super.onDestroy();
        this.xlN = null;
        if (!TextUtils.isEmpty(this.xlM) && com.tencent.mm.vfs.s.YS(this.xlM)) {
            com.tencent.mm.vfs.s.deleteFile(this.xlM);
        }
        AppMethodBeat.o(257827);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void setRequestedOrientation(int i2) {
        AppMethodBeat.i(257828);
        super.setRequestedOrientation(1);
        AppMethodBeat.o(257828);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initShowView$2$1"})
    static final class s implements Runnable {
        final /* synthetic */ ImageView tqC;
        final /* synthetic */ ImageCropUI xlY;

        s(ImageView imageView, ImageCropUI imageCropUI) {
            this.tqC = imageView;
            this.xlY = imageCropUI;
        }

        public final void run() {
            AppMethodBeat.i(257804);
            if (this.tqC.getWidth() == 0 || this.tqC.getHeight() == 0) {
                ah.a gJB = ah.gJB();
                ImageCropUI.a(this.xlY, gJB.width, gJB.height);
            } else {
                ImageCropUI.a(this.xlY, this.tqC.getWidth(), this.tqC.getHeight());
            }
            this.tqC.setVisibility(0);
            this.xlY.xlU = true;
            com.tencent.mm.ui.base.q qVar = this.xlY.gxX;
            if (qVar != null) {
                qVar.dismiss();
                AppMethodBeat.o(257804);
                return;
            }
            AppMethodBeat.o(257804);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ View uXn;
        final /* synthetic */ ImageCropUI xlY;

        k(ImageCropUI imageCropUI, View view) {
            this.xlY = imageCropUI;
            this.uXn = view;
        }

        public final void run() {
            AppMethodBeat.i(257794);
            this.uXn.setPadding(0, 0, 0, au.aD(this.xlY.getContext()));
            AppMethodBeat.o(257794);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ ImageCropUI xlY;

        l(ImageCropUI imageCropUI) {
            this.xlY = imageCropUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257795);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a aVar = a.xlD;
            a.NH(9);
            this.xlY.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257795);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ ImageCropUI xlY;

        m(ImageCropUI imageCropUI) {
            this.xlY = imageCropUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257796);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ImageCropUI.d(this.xlY);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257796);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class n implements View.OnClickListener {
        final /* synthetic */ ImageCropUI xlY;

        n(ImageCropUI imageCropUI) {
            this.xlY = imageCropUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257797);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ImageCropUI.e(this.xlY).getLayout().hba();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257797);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class o implements View.OnClickListener {
        final /* synthetic */ ImageCropUI xlY;

        o(ImageCropUI imageCropUI) {
            this.xlY = imageCropUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257798);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ImageCropUI.e(this.xlY).getLayout().hbb();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257798);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class p implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ImageCropUI xlY;

        p(ImageCropUI imageCropUI) {
            this.xlY = imageCropUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(257799);
            if (!this.xlY.xlU) {
                AppMethodBeat.o(257799);
            } else {
                switch (ImageCropUI.f(this.xlY)) {
                    case 1:
                        ImageCropUI.d(this.xlY);
                        break;
                    case 2:
                        ImageCropUI.h(this.xlY);
                        break;
                    case 3:
                        ImageCropUI.i(this.xlY);
                        break;
                    case 4:
                        ImageCropUI.g(this.xlY);
                        break;
                }
                AppMethodBeat.o(257799);
            }
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class q implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ImageCropUI xlY;

        q(ImageCropUI imageCropUI) {
            this.xlY = imageCropUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(257800);
            a aVar = a.xlD;
            a.NH(9);
            this.xlY.finish();
            AppMethodBeat.o(257800);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(257829);
        super.onBackPressed();
        com.tencent.mm.plugin.gallery.picker.b.b bVar = this.vLu;
        if (bVar != null) {
            bVar.destroy();
        }
        a aVar = a.xlD;
        a.NH(9);
        AppMethodBeat.o(257829);
    }

    private final Bitmap dRI() {
        AppMethodBeat.i(257830);
        ImageView dRF = dRF();
        kotlin.g.b.p.g(dRF, "previewView");
        int width = dRF.getWidth();
        ImageView dRF2 = dRF();
        kotlin.g.b.p.g(dRF2, "previewView");
        Bitmap createBitmap = BitmapUtil.createBitmap(width, dRF2.getHeight(), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            a aVar = a.xlD;
            a.NH(8);
            setResult(-1);
            finish();
            AppMethodBeat.o(257830);
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        dRF().draw(canvas);
        canvas.setBitmap(null);
        try {
            Bitmap cropBitmap = BitmapUtil.cropBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight() - com.tencent.mm.view.d.e(this, 56.0f), true);
            AppMethodBeat.o(257830);
            return cropBitmap;
        } catch (Throwable th) {
            a aVar2 = a.xlD;
            a.NH(8);
            setResult(-1);
            finish();
            AppMethodBeat.o(257830);
            return null;
        }
    }

    static /* synthetic */ boolean n(String str, Bitmap bitmap) {
        AppMethodBeat.i(257832);
        boolean a2 = a(str, bitmap, true);
        AppMethodBeat.o(257832);
        return a2;
    }

    private static boolean a(String str, Bitmap bitmap, boolean z2) {
        AppMethodBeat.i(257831);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(257831);
            return false;
        }
        try {
            BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, str, z2);
            Log.i("MicroMsg.AvatarCropUI", "saveBitmapToImage successful ");
            AppMethodBeat.o(257831);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AvatarCropUI", e2, "", new Object[0]);
            Log.e("MicroMsg.AvatarCropUI", "saveBitmapToImage failed: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(257831);
            return false;
        }
    }

    private final void bnj() {
        AppMethodBeat.i(257833);
        com.tencent.mm.ui.base.q qVar = this.gxX;
        if (qVar != null) {
            qVar.dismiss();
        }
        this.gxX = com.tencent.mm.ui.base.q.a(this, getString(R.string.ekc), false, 0, null);
        AppMethodBeat.o(257833);
    }

    private final RectF dzt() {
        AppMethodBeat.i(257834);
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        Resources resources = context.getResources();
        kotlin.g.b.p.g(resources, "context.resources");
        AppCompatActivity context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        float dimension = ((float) resources.getDisplayMetrics().widthPixels) - context2.getResources().getDimension(R.dimen.cn);
        AppCompatActivity context3 = getContext();
        kotlin.g.b.p.g(context3, "context");
        Resources resources2 = context3.getResources();
        kotlin.g.b.p.g(resources2, "context.resources");
        float f2 = (((float) resources2.getDisplayMetrics().heightPixels) - dimension) / 2.0f;
        AppCompatActivity context4 = getContext();
        kotlin.g.b.p.g(context4, "context");
        float dimension2 = context4.getResources().getDimension(R.dimen.ce);
        AppCompatActivity context5 = getContext();
        kotlin.g.b.p.g(context5, "context");
        RectF rectF = new RectF(dimension2, f2, context5.getResources().getDimension(R.dimen.ce) + dimension, dimension + f2);
        AppMethodBeat.o(257834);
        return rectF;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<WxMediaCropLayout> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WxMediaCropLayout invoke() {
            AppMethodBeat.i(257788);
            WxMediaCropLayout wxMediaCropLayout = (WxMediaCropLayout) this.xlY.findViewById(R.id.dv8);
            AppMethodBeat.o(257788);
            return wxMediaCropLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(257818);
            ImageView imageView = (ImageView) this.xlY.findViewById(R.id.dvb);
            AppMethodBeat.o(257818);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(257789);
            LinearLayout linearLayout = (LinearLayout) this.xlY.findViewById(R.id.dva);
            AppMethodBeat.o(257789);
            return linearLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Button> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Button invoke() {
            AppMethodBeat.i(257784);
            Button button = (Button) this.xlY.findViewById(R.id.dv6);
            AppMethodBeat.o(257784);
            return button;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Button> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Button invoke() {
            AppMethodBeat.i(257785);
            Button button = (Button) this.xlY.findViewById(R.id.dv7);
            AppMethodBeat.o(257785);
            return button;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(257820);
            WeImageView weImageView = (WeImageView) this.xlY.findViewById(R.id.dv_);
            AppMethodBeat.o(257820);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class y extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(257819);
            WeImageView weImageView = (WeImageView) this.xlY.findViewById(R.id.dv9);
            AppMethodBeat.o(257819);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(257793);
            String stringExtra = this.xlY.getIntent().getStringExtra("CropImage_ImgPath");
            if (stringExtra == null) {
                stringExtra = "";
            }
            AppMethodBeat.o(257793);
            return stringExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(257787);
            Integer valueOf = Integer.valueOf(this.xlY.getIntent().getIntExtra("CropImageMode", 0));
            AppMethodBeat.o(257787);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(257813);
            String stringExtra = this.xlY.getIntent().getStringExtra("CropImage_OutputPath");
            if (stringExtra == null) {
                StringBuilder append = new StringBuilder().append(com.tencent.mm.loader.j.b.aKV());
                String str = ImageCropUI.m(this.xlY) + System.currentTimeMillis();
                Charset charset = kotlin.n.d.UTF_8;
                if (str == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(257813);
                    throw tVar;
                }
                byte[] bytes = str.getBytes(charset);
                kotlin.g.b.p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                stringExtra = append.append(com.tencent.mm.b.g.getMessageDigest(bytes)).append("_crop.jpg").toString();
            }
            AppMethodBeat.o(257813);
            return stringExtra;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ ImageCropUI xlY;
        final /* synthetic */ z.f xmq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(ImageCropUI imageCropUI, z.f fVar, Intent intent) {
            super(0);
            this.xlY = imageCropUI;
            this.xmq = fVar;
            this.$intent = intent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(257812);
            if (!this.xlY.xlR) {
                try {
                    String mD5String = MD5Util.getMD5String(String.valueOf(System.currentTimeMillis()));
                    if (this.xlY.xlT == null) {
                        Log.e("MicroMsg.AvatarCropUI", "emojiBmp is null");
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                            /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.u.AnonymousClass1 */
                            final /* synthetic */ u xmr;

                            {
                                this.xmr = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ kotlin.x invoke() {
                                AppMethodBeat.i(257808);
                                a aVar = a.xlD;
                                a.NH(8);
                                com.tencent.mm.ui.base.q qVar = this.xmr.xlY.gxX;
                                if (qVar != null) {
                                    qVar.dismiss();
                                }
                                this.xmr.xlY.setResult(-2);
                                this.xmr.xlY.finish();
                                kotlin.x xVar = kotlin.x.SXb;
                                AppMethodBeat.o(257808);
                                return xVar;
                            }
                        });
                    } else {
                        Bitmap bitmap = this.xlY.xlT;
                        if (bitmap == null) {
                            kotlin.g.b.p.hyc();
                        }
                        Bitmap ae = ImageCropUI.ae(bitmap);
                        if (ae == null) {
                            Log.e("MicroMsg.AvatarCropUI", "commpressedImg is null");
                            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                                /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.u.AnonymousClass2 */
                                final /* synthetic */ u xmr;

                                {
                                    this.xmr = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ kotlin.x invoke() {
                                    AppMethodBeat.i(257809);
                                    a aVar = a.xlD;
                                    a.NH(8);
                                    com.tencent.mm.ui.base.q qVar = this.xmr.xlY.gxX;
                                    if (qVar != null) {
                                        qVar.dismiss();
                                    }
                                    this.xmr.xlY.setResult(-2);
                                    this.xmr.xlY.finish();
                                    kotlin.x xVar = kotlin.x.SXb;
                                    AppMethodBeat.o(257809);
                                    return xVar;
                                }
                            });
                        } else {
                            BitmapUtil.saveBitmapToImage(ae, 100, Bitmap.CompressFormat.PNG, ImageCropUI.l(this.xlY) + mD5String, false);
                            Log.i("MicroMsg.AvatarCropUI", "save bitmap to image successful");
                            byte[] aW = com.tencent.mm.vfs.s.aW(ImageCropUI.l(this.xlY) + mD5String, 0, -1);
                            z.f fVar = this.xmq;
                            T t = (T) MD5Util.getMD5String(aW);
                            kotlin.g.b.p.g(t, "MD5Util.getMD5String(fileData)");
                            fVar.SYG = t;
                            if (!com.tencent.mm.vfs.s.YS(ImageCropUI.l(this.xlY) + ((String) this.xmq.SYG))) {
                                com.tencent.mm.vfs.s.bo(ImageCropUI.l(this.xlY), mD5String, this.xmq.SYG);
                            } else {
                                com.tencent.mm.vfs.s.deleteFile(ImageCropUI.l(this.xlY) + mD5String);
                            }
                            this.$intent.putExtra("emoji_type", 0);
                            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                                /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.u.AnonymousClass4 */
                                final /* synthetic */ u xmr;

                                {
                                    this.xmr = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ kotlin.x invoke() {
                                    AppMethodBeat.i(257811);
                                    com.tencent.mm.ui.base.q qVar = this.xmr.xlY.gxX;
                                    if (qVar != null) {
                                        qVar.dismiss();
                                    }
                                    this.xmr.$intent.putExtra("CropImage_OutputPath", ImageCropUI.l(this.xmr.xlY) + ((String) this.xmr.xmq.SYG));
                                    this.xmr.xlY.setResult(-1, this.xmr.$intent);
                                    Log.i("MicroMsg.AvatarCropUI", "finish emoji crop");
                                    this.xmr.xlY.finish();
                                    kotlin.x xVar = kotlin.x.SXb;
                                    AppMethodBeat.o(257811);
                                    return xVar;
                                }
                            });
                        }
                    }
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.AvatarCropUI", e2, "", null);
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                        /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.u.AnonymousClass3 */
                        final /* synthetic */ u xmr;

                        {
                            this.xmr = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            AppMethodBeat.i(257810);
                            a aVar = a.xlD;
                            a.NH(8);
                            com.tencent.mm.ui.base.q qVar = this.xmr.xlY.gxX;
                            if (qVar != null) {
                                qVar.dismiss();
                            }
                            Log.printErrStackTrace("MicroMsg.AvatarCropUI", e2, "", null);
                            this.xmr.xlY.setResult(-2);
                            this.xmr.xlY.finish();
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(257810);
                            return xVar;
                        }
                    });
                }
            } else {
                byte[] aW2 = com.tencent.mm.vfs.s.aW(ImageCropUI.m(this.xlY), 0, -1);
                z.f fVar2 = this.xmq;
                T t2 = (T) MD5Util.getMD5String(aW2);
                kotlin.g.b.p.g(t2, "MD5Util.getMD5String(fileData)");
                fVar2.SYG = t2;
                if (!com.tencent.mm.vfs.s.YS(ImageCropUI.l(this.xlY) + ((String) this.xmq.SYG))) {
                    com.tencent.mm.vfs.s.f(ImageCropUI.l(this.xlY) + ((String) this.xmq.SYG), aW2, aW2.length);
                } else {
                    Log.i("MicroMsg.AvatarCropUI", "file is exist. do not need to copy!");
                }
                this.$intent.putExtra("emoji_type", 1);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.u.AnonymousClass4 */
                    final /* synthetic */ u xmr;

                    {
                        this.xmr = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(257811);
                        com.tencent.mm.ui.base.q qVar = this.xmr.xlY.gxX;
                        if (qVar != null) {
                            qVar.dismiss();
                        }
                        this.xmr.$intent.putExtra("CropImage_OutputPath", ImageCropUI.l(this.xmr.xlY) + ((String) this.xmr.xmq.SYG));
                        this.xmr.xlY.setResult(-1, this.xmr.$intent);
                        Log.i("MicroMsg.AvatarCropUI", "finish emoji crop");
                        this.xmr.xlY.finish();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(257811);
                        return xVar;
                    }
                });
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257812);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMattingCropLayout$1$1"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ ImageCropUI xlY;
        final /* synthetic */ WxMediaCropLayout xmk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(WxMediaCropLayout wxMediaCropLayout, ImageCropUI imageCropUI) {
            super(0);
            this.xmk = wxMediaCropLayout;
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(257803);
            int[] ayW = ImageCropUI.ayW(ImageCropUI.m(this.xlY));
            if (ayW == null) {
                Log.e("MicroMsg.AvatarCropUI", "load matting img info error");
                a aVar = a.xlD;
                a.NH(8);
                this.xlY.setResult(-1);
                this.xlY.finish();
            } else {
                this.xlY.xlS = ayW;
                this.xlY.xlQ = BackwardSupportUtil.ExifHelper.getExifOrientation(ImageCropUI.m(this.xlY));
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.r.AnonymousClass1 */
                    final /* synthetic */ r xmm;

                    {
                        this.xmm = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(257802);
                        this.xmm.xmk.post(new Runnable(this) {
                            /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.r.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 xmn;

                            {
                                this.xmn = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(257801);
                                this.xmn.xmm.xmk.a(ImageCropUI.a(this.xmn.xmm.xlY, ImageCropUI.n(this.xmn.xmm.xlY)[0], ImageCropUI.n(this.xmn.xmm.xlY)[1], this.xmn.xmm.xmk.getWidth(), this.xmn.xmm.xmk.getHeight()), WxCropOperationLayout.j.RECT_HARD);
                                WxMediaCropLayout.a(this.xmn.xmm.xmk, System.currentTimeMillis(), ImageCropUI.m(this.xmn.xmm.xlY), true, (WxMediaCropLayout.c) null, (kotlin.g.a.q) this.xmn.xmm.xlY.xlV, 8);
                                AppMethodBeat.o(257801);
                            }
                        });
                        this.xmm.xmk.postInvalidate();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(257802);
                        return xVar;
                    }
                });
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257803);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(257783);
            Bitmap p = ImageCropUI.p(this.xlY);
            String stringExtra = this.xlY.getIntent().getStringExtra("CropImage_bg_vertical");
            String stringExtra2 = this.xlY.getIntent().getStringExtra("CropImage_bg_horizontal");
            kotlin.g.b.p.g(stringExtra, "bgVerticalPath");
            if (p == null) {
                kotlin.g.b.p.hyc();
            }
            if (ImageCropUI.o(stringExtra, p)) {
                kotlin.g.b.p.g(stringExtra2, "bgHorizontalPath");
                if (ImageCropUI.n(stringExtra2, p)) {
                    Intent intent = new Intent();
                    intent.putExtra("CropImage_bg_vertical", stringExtra);
                    intent.putExtra("CropImage_bg_horizontal", stringExtra2);
                    this.xlY.setResult(-1, intent);
                    a aVar = a.xlD;
                    a.NH(9);
                    Log.i("MicroMsg.AvatarCropUI", "finish background crop");
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                        /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.b.AnonymousClass1 */
                        final /* synthetic */ b xlZ;

                        {
                            this.xlZ = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            AppMethodBeat.i(257782);
                            com.tencent.mm.ui.base.q qVar = this.xlZ.xlY.gxX;
                            if (qVar != null) {
                                qVar.dismiss();
                            }
                            this.xlZ.xlY.finish();
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(257782);
                            return xVar;
                        }
                    });
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(257783);
                    return xVar;
                }
            }
            a aVar2 = a.xlD;
            a.NH(8);
            this.xlY.setResult(-1);
            Log.e("MicroMsg.AvatarCropUI", "background crop error");
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.b.AnonymousClass1 */
                final /* synthetic */ b xlZ;

                {
                    this.xlZ = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(257782);
                    com.tencent.mm.ui.base.q qVar = this.xlZ.xlY.gxX;
                    if (qVar != null) {
                        qVar.dismiss();
                    }
                    this.xlZ.xlY.finish();
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(257782);
                    return xVar;
                }
            });
            kotlin.x xVar2 = kotlin.x.SXb;
            AppMethodBeat.o(257783);
            return xVar2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ ImageCropUI xlY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(ImageCropUI imageCropUI) {
            super(0);
            this.xlY = imageCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            final Bitmap bitmap;
            boolean z = false;
            AppMethodBeat.i(257807);
            this.xlY.xlQ = BackwardSupportUtil.ExifHelper.getExifOrientation(ImageCropUI.m(this.xlY));
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(ImageCropUI.m(this.xlY));
            boolean z2 = LongBitmapHandler.isLongHorizontal(imageOptions.outWidth, imageOptions.outHeight) && imageOptions.outWidth > 480;
            if (LongBitmapHandler.isLongVertical(imageOptions.outWidth, imageOptions.outHeight) && imageOptions.outHeight > 480) {
                z = true;
            }
            if (z2 || z) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.t.AnonymousClass1 */
                    final /* synthetic */ t xmo;

                    {
                        this.xmo = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(257805);
                        WxMediaCropLayout e2 = ImageCropUI.e(this.xmo.xlY);
                        e2.setVisibility(0);
                        e2.setShowBorder(false);
                        e2.a(ImageCropUI.q(this.xmo.xlY), WxCropOperationLayout.j.RECT_HARD);
                        WxMediaCropLayout.a(e2, System.currentTimeMillis(), ImageCropUI.m(this.xmo.xlY), true, (WxMediaCropLayout.c) null, this.xmo.xlY.xlW, 8);
                        e2.dRJ();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(257805);
                        return xVar;
                    }
                });
            } else {
                if (this.xlY.xlQ != 90) {
                    int unused = this.xlY.xlQ;
                }
                if (this.xlY.xlQ != 90) {
                    int unused2 = this.xlY.xlQ;
                }
                Bitmap extractThumbNail = BitmapUtil.extractThumbNail(ImageCropUI.m(this.xlY), 960, 960, true);
                if (extractThumbNail != null) {
                    bitmap = BitmapUtil.rotate(extractThumbNail, (float) this.xlY.xlQ);
                } else {
                    bitmap = null;
                }
                if (bitmap == null) {
                    a aVar = a.xlD;
                    a.NH(8);
                    this.xlY.setResult(-1);
                    this.xlY.finish();
                } else {
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                        /* class com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.t.AnonymousClass2 */
                        final /* synthetic */ t xmo;

                        {
                            this.xmo = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            AppMethodBeat.i(257806);
                            ImageView s = ImageCropUI.s(this.xmo.xlY);
                            s.setVisibility(0);
                            s.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            s.setImageBitmap(bitmap);
                            this.xmo.xlY.xlU = true;
                            com.tencent.mm.ui.base.q qVar = this.xmo.xlY.gxX;
                            if (qVar != null) {
                                qVar.dismiss();
                            }
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(257806);
                            return xVar;
                        }
                    });
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257807);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(ImageCropUI imageCropUI, int i2, int i3) {
        Bitmap bitmap;
        ImageView imageView;
        AppMethodBeat.i(257837);
        if (i2 == 0 || i3 == 0) {
            a aVar = a.xlD;
            a.NH(8);
            imageCropUI.setResult(-1);
            imageCropUI.finish();
            AppMethodBeat.o(257837);
            return;
        }
        imageCropUI.xlQ = BackwardSupportUtil.ExifHelper.getExifOrientation(imageCropUI.ajP());
        int i4 = (imageCropUI.xlQ == 90 || imageCropUI.xlQ == 270) ? i3 : i2;
        if (imageCropUI.xlQ == 90 || imageCropUI.xlQ == 270) {
            i3 = i2;
        }
        a aVar2 = a.xlD;
        a.NH(4);
        a aVar3 = a.xlD;
        a.NI(14);
        a aVar4 = a.xlD;
        a.NH(13);
        Log.i("MicroMsg.AvatarCropUI", "preview background");
        Bitmap extractThumbNail = BitmapUtil.extractThumbNail(imageCropUI.ajP(), i3, i4, true);
        if (extractThumbNail != null) {
            bitmap = BitmapUtil.rotate(extractThumbNail, (float) imageCropUI.xlQ);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            Log.i("MicroMsg.AvatarCropUI", "background image decode successful");
            a aVar5 = a.xlD;
            a.NI(20);
            a aVar6 = a.xlD;
            a.NH(19);
            imageView = imageCropUI.dRF();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            kotlin.g.b.p.g(imageView, "this");
            int width2 = imageView.getWidth();
            int height2 = imageView.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float f2 = ((float) width) / ((float) width2);
            float f3 = ((float) height) / ((float) height2);
            float f4 = f2 < f3 ? f2 : f3;
            float f5 = width2 > height2 ? (float) height2 : (float) width2;
            float f6 = f5 / ((float) width);
            float f7 = f5 / ((float) height);
            if (f6 <= f7) {
                f6 = f7;
            }
            if (((double) f4) < 1.0d) {
                matrix.postScale(f6, f6);
            }
            imageView.setImageMatrix(matrix);
            imageView.setImageBitmap(bitmap);
        } else {
            imageView = null;
        }
        if (imageView == null) {
            Log.i("MicroMsg.AvatarCropUI", "background image decode fail");
            a aVar7 = a.xlD;
            a.NH(8);
            imageCropUI.setResult(-1);
            imageCropUI.finish();
        }
        AppMethodBeat.o(257837);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00aa, code lost:
        if (r1 == null) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void d(com.tencent.mm.plugin.gallery.picker.view.ImageCropUI r12) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.d(com.tencent.mm.plugin.gallery.picker.view.ImageCropUI):void");
    }

    public static final /* synthetic */ void g(ImageCropUI imageCropUI) {
        String dRH;
        AppMethodBeat.i(257841);
        if (TextUtils.isEmpty(imageCropUI.dRH())) {
            dRH = imageCropUI.ajP();
        } else {
            byte[] aW = com.tencent.mm.vfs.s.aW(imageCropUI.ajP(), 0, -1);
            com.tencent.mm.vfs.s.f(imageCropUI.dRH(), aW, aW.length);
            dRH = imageCropUI.dRH();
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_Compress_Img", true);
        intent.putExtra("CropImage_OutputPath", dRH);
        intent.putExtra("from_source", imageCropUI.getIntent().getIntExtra("from_source", 0));
        a aVar = a.xlD;
        a.NH(9);
        imageCropUI.setResult(-1, intent);
        imageCropUI.finish();
        AppMethodBeat.o(257841);
    }

    public static final /* synthetic */ void h(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257842);
        if (!imageCropUI.xlP) {
            imageCropUI.xlP = true;
            imageCropUI.bnj();
            com.tencent.mm.ac.d.i(new b(imageCropUI));
        }
        AppMethodBeat.o(257842);
    }

    public static final /* synthetic */ void i(ImageCropUI imageCropUI) {
        AppMethodBeat.i(257843);
        if (!imageCropUI.xlP) {
            imageCropUI.xlP = true;
            imageCropUI.bnj();
            Intent intent = new Intent();
            z.f fVar = new z.f();
            fVar.SYG = "";
            com.tencent.mm.ac.d.i(new u(imageCropUI, fVar, intent));
        }
        AppMethodBeat.o(257843);
    }

    public static final /* synthetic */ Bitmap ae(Bitmap bitmap) {
        AppMethodBeat.i(257844);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 640 || height > 640) {
            if (width > height) {
                height = (int) (((float) (height * 640)) / ((float) width));
                width = 640;
            } else {
                width = (int) (((float) (width * 640)) / ((float) height));
                height = 640;
            }
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        AppMethodBeat.o(257844);
        return createScaledBitmap;
    }

    public static final /* synthetic */ int[] ayW(String str) {
        boolean z2;
        AppMethodBeat.i(257847);
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
        if (imageOptions != null) {
            if (imageOptions.outWidth <= 0 || imageOptions.outHeight <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                imageOptions = null;
            }
            if (imageOptions != null) {
                int[] iArr = {imageOptions.outWidth, imageOptions.outHeight};
                AppMethodBeat.o(257847);
                return iArr;
            }
        }
        AppMethodBeat.o(257847);
        return null;
    }

    public static final /* synthetic */ RectF a(ImageCropUI imageCropUI, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        AppMethodBeat.i(257849);
        int i6 = (imageCropUI.xlQ == 90 || imageCropUI.xlQ == 270) ? i3 : i2;
        if (imageCropUI.xlQ == 90 || imageCropUI.xlQ == 270) {
            i3 = i2;
        }
        if (i3 < i5 && i6 < i4) {
            float f6 = ((float) (i4 - i6)) / 2.0f;
            f2 = ((float) i6) + f6;
            f3 = ((float) (i5 - i3)) / 2.0f;
            f4 = f3 + ((float) i3);
            f5 = f6;
        } else if (LongBitmapHandler.isLongVertical(i6, i3)) {
            f2 = (float) i4;
            f4 = (float) i5;
            f3 = 0.0f;
            f5 = 0.0f;
        } else if (LongBitmapHandler.isLongHorizontal(i6, i3)) {
            f2 = (float) i4;
            f3 = ((float) (i5 - i3)) / 2.0f;
            f4 = f3 + ((float) i4);
            f5 = 0.0f;
        } else if (((float) i3) / ((float) i6) > ((float) i5) / ((float) i4)) {
            float f7 = ((float) (i6 * i5)) / ((float) i3);
            f4 = (float) i5;
            f5 = (((float) i4) - f7) / 2.0f;
            f2 = f7 + f5;
            f3 = 0.0f;
        } else {
            float f8 = ((float) (i4 * i3)) / ((float) i6);
            f2 = (float) i4;
            f3 = (((float) i5) - f8) / 2.0f;
            f4 = f3 + f8;
            f5 = 0.0f;
        }
        RectF rectF = new RectF(f5, f3, f2, f4);
        AppMethodBeat.o(257849);
        return rectF;
    }
}
