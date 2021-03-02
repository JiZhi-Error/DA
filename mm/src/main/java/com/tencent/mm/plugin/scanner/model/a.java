package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.h;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\"#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bJ!\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ#\u0010\u001f\u001a\u00020 2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil;", "", "()V", "DEFAULT_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "", "Image_Search_Status_Local_Add_Cdn_Task_Error", "Image_Search_Status_Server_Error", "Image_Search_status_OK", "MAX_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "MIN_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "TAG", "", "configMaxImageSize", "getConfigMaxImageSize", "()I", "configMaxImageSize$delegate", "Lkotlin/Lazy;", "cancelUploadImage", "", "mediaId", "decodeBitmap", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "imagePath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMediaIdByPath", "filePath", "saveBitmapToFile", "bitmap", "Landroid/graphics/Bitmap;", "targetImagePath", "(Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadImage", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ImageSearchCdnUploadResult", "ImageSearchDecodeResult", "plugin-scan_release"})
public final class a {
    private static final kotlin.f CEx = g.ah(c.CEA);
    public static final a CEy = new a();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "", "()V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "fileID", "getFileID", "setFileID", "imageUrl", "getImageUrl", "setImageUrl", "plugin-scan_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.model.a$a  reason: collision with other inner class name */
    public static final class C1673a {
        public String aesKey;
        int errCode;
        public String fileID;
        public String imageUrl;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "", "()V", "originHeight", "", "getOriginHeight", "()I", "setOriginHeight", "(I)V", "originWidth", "getOriginWidth", "setOriginWidth", "resultImagePath", "", "getResultImagePath", "()Ljava/lang/String;", "setResultImagePath", "(Ljava/lang/String;)V", "plugin-scan_release"})
    public static final class b {
        String CEz;
        public int xlg;
        public int xlh;
    }

    static {
        AppMethodBeat.i(240376);
        AppMethodBeat.o(240376);
    }

    private a() {
    }

    public static String aMv(String str) {
        AppMethodBeat.i(240371);
        p.h(str, "filePath");
        String str2 = z.aTY() + "_image_search_" + str + "_" + System.currentTimeMillis();
        AppMethodBeat.o(240371);
        return str2;
    }

    static /* synthetic */ Object a(Bitmap bitmap, String str, kotlin.d.d<? super Boolean> dVar) {
        AppMethodBeat.i(240372);
        Object a2 = kotlinx.coroutines.g.a(ba.hMW(), new e(bitmap, str, null), dVar);
        AppMethodBeat.o(240372);
        return a2;
    }

    public static Object a(String str, kotlin.d.d<? super b> dVar) {
        AppMethodBeat.i(240373);
        Object a2 = kotlinx.coroutines.g.a(ba.hMW(), new d(str, null), dVar);
        AppMethodBeat.o(240373);
        return a2;
    }

    public static final Object a(String str, String str2, kotlin.d.d<? super C1673a> dVar) {
        AppMethodBeat.i(240374);
        h hVar = new h(kotlin.d.a.b.e(dVar));
        h hVar2 = hVar;
        if (str == null) {
            C1673a aVar = new C1673a();
            aVar.errCode = -1;
            Result.Companion companion = Result.Companion;
            hVar2.resumeWith(Result.m46constructorimpl(aVar));
        } else {
            Log.i("MicroMsg.AIScanImageCdnUploader", "alvinluo uploadImage using cdn mediaId: %s", str2);
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.taskName = "task_AiScanImagetUploadTask";
            gVar.field_mediaId = str2;
            gVar.field_fullpath = str;
            gVar.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            gVar.field_priority = com.tencent.mm.i.a.gpM;
            gVar.field_needStorage = false;
            gVar.field_needCompressImage = true;
            gVar.field_isStreamMedia = false;
            gVar.field_force_aeskeycdn = true;
            gVar.field_trysafecdn = false;
            gVar.gqD = 15;
            gVar.gqy = new f(hVar2);
            if (!com.tencent.mm.an.f.baQ().f(gVar)) {
                C1673a aVar2 = new C1673a();
                aVar2.errCode = -2;
                Result.Companion companion2 = Result.Companion;
                hVar2.resumeWith(Result.m46constructorimpl(aVar2));
            }
        }
        Object hxK = hVar.hxK();
        if (hxK == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            p.h(dVar, "frame");
        }
        AppMethodBeat.o(240374);
        return hxK;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$uploadImage$2$2", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "p1", "Ljava/io/ByteArrayOutputStream;", "plugin-scan_release"})
    public static final class f implements g.a {
        final /* synthetic */ kotlin.d.d iCb;

        f(kotlin.d.d dVar) {
            this.iCb = dVar;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(240368);
            Log.i("MicroMsg.AIScanImageCdnUploader", "getCdnAuthInfo, mediaId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(240368);
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            Long l = null;
            AppMethodBeat.i(240369);
            if (i2 != 0) {
                kotlin.d.d dVar2 = this.iCb;
                C1673a aVar = new C1673a();
                aVar.errCode = -1;
                Result.Companion companion = Result.Companion;
                dVar2.resumeWith(Result.m46constructorimpl(aVar));
                Log.e("MicroMsg.AIScanImageCdnUploader", "AIScanImageCdnUploader upload start fail: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(240369);
            } else {
                StringBuilder append = new StringBuilder("upload callback,id:").append(str).append(" len:").append(cVar != null ? Long.valueOf(cVar.field_finishedLength) : null).append(", totalLen:");
                if (cVar != null) {
                    l = Long.valueOf(cVar.field_toltalLength);
                }
                Log.i("MicroMsg.AIScanImageCdnUploader", append.append(l).toString());
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        Log.e("MicroMsg.AIScanImageCdnUploader", "AIScanImageCdnUploader upload result fail: " + dVar.field_retCode);
                        kotlin.d.d dVar3 = this.iCb;
                        C1673a aVar2 = new C1673a();
                        aVar2.errCode = -1;
                        Result.Companion companion2 = Result.Companion;
                        dVar3.resumeWith(Result.m46constructorimpl(aVar2));
                    } else {
                        Log.i("MicroMsg.AIScanImageCdnUploader", "AIScanImageCdnUploader success");
                        kotlin.d.d dVar4 = this.iCb;
                        C1673a aVar3 = new C1673a();
                        aVar3.errCode = 0;
                        aVar3.fileID = dVar.field_fileId;
                        aVar3.aesKey = dVar.field_aesKey;
                        aVar3.imageUrl = dVar.field_fileUrl;
                        Result.Companion companion3 = Result.Companion;
                        dVar4.resumeWith(Result.m46constructorimpl(aVar3));
                    }
                }
                AppMethodBeat.o(240369);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(240370);
            Log.i("MicroMsg.AIScanImageCdnUploader", "decodePrepareResponse, mediaId = %s", str);
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(240370);
            return bArr2;
        }
    }

    public static final boolean aMw(String str) {
        AppMethodBeat.i(240375);
        p.h(str, "mediaId");
        boolean Ob = com.tencent.mm.an.f.baQ().Ob(str);
        AppMethodBeat.o(240375);
        return Ob;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Integer> {
        public static final c CEA = new c();

        static {
            AppMethodBeat.i(240361);
            AppMethodBeat.o(240361);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            int i2;
            AppMethodBeat.i(240360);
            com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
            if (bVar != null) {
                i2 = bVar.a(b.a.clicfg_image_search_pic_max_size, 1843200);
            } else {
                i2 = 1843200;
            }
            if (i2 > 7372800 || i2 < 230400) {
                i2 = 1843200;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(240360);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.scanner.model.AIScanImageCdnUploadUtil$decodeBitmap$2", f = "AIScanImageCdnUploadUtil.kt", hxM = {121}, m = "invokeSuspend")
    static final class d extends j implements m<ai, kotlin.d.d<? super b>, Object> {
        int CEB;
        int CEC;
        float CED;
        Object L$0;
        int label;
        final /* synthetic */ String lbx;
        private ai p$;
        Object pED;
        Object pEE;
        Object pEF;
        Object pEG;
        int pEQ;
        int pER;
        int pES;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.lbx = str;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(240363);
            p.h(dVar, "completion");
            d dVar2 = new d(this.lbx, dVar);
            dVar2.p$ = (ai) obj;
            AppMethodBeat.o(240363);
            return dVar2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super b> dVar) {
            AppMethodBeat.i(240364);
            Object invokeSuspend = ((d) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(240364);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            int i2;
            int i3;
            String str;
            Object obj2;
            Bitmap bitmap;
            AppMethodBeat.i(240362);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapUtil.decodeFile(this.lbx, options);
                    i2 = options.outWidth;
                    i3 = options.outHeight;
                    if (i2 <= 0 || i3 <= 0) {
                        Log.e("MicroMsg.AiScanImageSceneUploader", "Error outWidth:" + i2 + ", outHeight:" + i3);
                        AppMethodBeat.o(240362);
                        return null;
                    }
                    int i4 = i2 * i3;
                    int i5 = 1;
                    a aVar2 = a.CEy;
                    float ePL = ((float) i4) / ((float) a.ePL());
                    if (ePL > 1.0f) {
                        i5 = (int) ((float) Math.ceil((double) ((float) Math.sqrt((double) ePL))));
                    }
                    StringBuilder append = new StringBuilder("rate:").append(ePL).append(", inSampleSize: ").append(i5).append(", originWidth:").append(options.outWidth).append(", originHeight:").append(options.outHeight).append(", configMaxImageSize:");
                    a aVar3 = a.CEy;
                    Log.i("MicroMsg.AiScanImageSceneUploader", append.append(a.ePL()).toString());
                    try {
                        int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(this.lbx);
                        options.inSampleSize = i5;
                        options.inJustDecodeBounds = false;
                        bitmap = BitmapUtil.rotate(BitmapUtil.decodeFile(this.lbx, options), (float) exifOrientation);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.AiScanImageSceneUploader", "decode error, " + th.getLocalizedMessage());
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        Log.e("MicroMsg.AiScanImageSceneUploader", "decode error, bitmap is null");
                        AppMethodBeat.o(240362);
                        return null;
                    }
                    Log.i("MicroMsg.AiScanImageSceneUploader", "decode result,width:" + bitmap.getWidth() + ", height:" + bitmap.getHeight());
                    String str2 = this.lbx;
                    Charset charset = kotlin.n.d.UTF_8;
                    if (str2 == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(240362);
                        throw tVar;
                    }
                    byte[] bytes = str2.getBytes(charset);
                    p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                    String messageDigest = com.tencent.mm.b.g.getMessageDigest(bytes);
                    str = "wcf://ImageSearchFilePath/".concat(String.valueOf(messageDigest));
                    a aVar4 = a.CEy;
                    this.L$0 = aiVar;
                    this.pED = options;
                    this.pEQ = i2;
                    this.pER = i3;
                    this.pES = i4;
                    this.CEB = i5;
                    this.CED = ePL;
                    this.CEC = i5;
                    this.pEE = bitmap;
                    this.pEF = messageDigest;
                    this.pEG = str;
                    this.label = 1;
                    obj2 = a.a(bitmap, str, this);
                    if (obj2 == aVar) {
                        AppMethodBeat.o(240362);
                        return aVar;
                    }
                    break;
                case 1:
                    i3 = this.pER;
                    i2 = this.pEQ;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    str = (String) this.pEG;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(240362);
                    throw illegalStateException;
            }
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            boolean YS = s.YS(str);
            if (!booleanValue || !YS) {
                Log.i("MicroMsg.AiScanImageSceneUploader", "save Image Fail, saveSuccess:" + booleanValue + ", fileExist:" + YS);
                AppMethodBeat.o(240362);
                return null;
            }
            b bVar = new b();
            bVar.xlh = i3;
            bVar.xlg = i2;
            bVar.CEz = str;
            AppMethodBeat.o(240362);
            return bVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.scanner.model.AIScanImageCdnUploadUtil$saveBitmapToFile$2", f = "AIScanImageCdnUploadUtil.kt", hxM = {}, m = "invokeSuspend")
    public static final class e extends j implements m<ai, kotlin.d.d<? super Boolean>, Object> {
        final /* synthetic */ String CEE;
        final /* synthetic */ Bitmap cKG;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Bitmap bitmap, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.cKG = bitmap;
            this.CEE = str;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(240366);
            p.h(dVar, "completion");
            e eVar = new e(this.cKG, this.CEE, dVar);
            eVar.p$ = (ai) obj;
            AppMethodBeat.o(240366);
            return eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super Boolean> dVar) {
            AppMethodBeat.i(240367);
            Object invokeSuspend = ((e) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(240367);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(240365);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    boolean z = false;
                    try {
                        z = BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.JPEG, this.CEE, true);
                    } catch (Throwable th) {
                        Log.i("MicroMsg.AIScanImageCdnUploader", "save bitmap to image fail:" + th.getLocalizedMessage());
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(240365);
                    return valueOf;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(240365);
                    throw illegalStateException;
            }
        }
    }

    public static final /* synthetic */ int ePL() {
        AppMethodBeat.i(240377);
        int intValue = ((Number) CEx.getValue()).intValue();
        AppMethodBeat.o(240377);
        return intValue;
    }
}
