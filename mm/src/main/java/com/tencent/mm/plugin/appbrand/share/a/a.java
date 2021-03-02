package com.tencent.mm.plugin.appbrand.share.a;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a implements k {
    private final Map<String, SoftReference<b.f>> nNb = new ConcurrentHashMap();
    private final Map<String, SoftReference<b.h>> nNc = new ConcurrentHashMap();
    private final Map<Integer, AbstractC0794a> nNd = new ConcurrentHashMap();
    private final Map<Integer, Bundle> nNe = new ConcurrentHashMap();

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.share.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0794a {
        void S(Bundle bundle);
    }

    static /* synthetic */ void a(k.b bVar) {
        AppMethodBeat.i(48336);
        a(bVar, 0);
        AppMethodBeat.o(48336);
    }

    public a() {
        AppMethodBeat.i(48325);
        a(1, new AbstractC0794a() {
            /* class com.tencent.mm.plugin.appbrand.share.a.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.share.a.a.AbstractC0794a
            public final void S(Bundle bundle) {
                AppMethodBeat.i(48320);
                a.this.nNe.remove(2);
                AppMethodBeat.o(48320);
            }
        });
        AppMethodBeat.o(48325);
    }

    @Override // com.tencent.mm.modelappbrand.k
    public final View a(Context context, Bundle bundle, boolean z, k.c cVar) {
        AppMethodBeat.i(180363);
        Assert.assertNotNull(context);
        WxaShareMessagePage wxaShareMessagePage = new WxaShareMessagePage(context);
        if (bundle != null) {
            int i2 = bundle.getInt("key_biz", k.a.BUSINESS_MAX.ordinal());
            boolean z2 = bundle.getBoolean("is_video", false);
            if (k.a.isValid(i2) || z2) {
                wxaShareMessagePage.nNu = true;
                ViewGroup.LayoutParams layoutParams = wxaShareMessagePage.mvU.getLayoutParams();
                layoutParams.width = com.tencent.mm.cb.a.fromDPToPix(wxaShareMessagePage.getContext(), 112);
                layoutParams.height = com.tencent.mm.cb.a.fromDPToPix(wxaShareMessagePage.getContext(), 63);
                wxaShareMessagePage.mvU.setLayoutParams(layoutParams);
                wxaShareMessagePage.mvU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ViewGroup.LayoutParams layoutParams2 = wxaShareMessagePage.nNj.getLayoutParams();
                layoutParams2.width = com.tencent.mm.cb.a.fromDPToPix(wxaShareMessagePage.getContext(), 112);
                layoutParams2.height = com.tencent.mm.cb.a.fromDPToPix(wxaShareMessagePage.getContext(), 63);
                wxaShareMessagePage.nNj.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = wxaShareMessagePage.nNt.getLayoutParams();
                layoutParams3.width = com.tencent.mm.cb.a.fromDPToPix(wxaShareMessagePage.getContext(), 112);
                layoutParams3.height = com.tencent.mm.cb.a.fromDPToPix(wxaShareMessagePage.getContext(), 63);
                wxaShareMessagePage.nNt.setLayoutParams(layoutParams3);
                if (k.a.BUSINESS_MY_LIFE_AROUND.ordinal() == i2) {
                    wxaShareMessagePage.nNp.setImageResource(R.raw.my_life_around_default_icon);
                    wxaShareMessagePage.nNj.setImageResource(R.raw.app_msg_share_nearby_life_default);
                } else if (k.a.BUSINESS_OTHER.ordinal() == i2 || z2) {
                    String string = bundle.getString("key_footer_icon", "");
                    if (!Util.isNullOrNil(string)) {
                        q.bcU().a(string, new r.a(z2) {
                            /* class com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage.AnonymousClass3 */
                            final /* synthetic */ boolean nNx;

                            {
                                this.nNx = r2;
                            }

                            @Override // com.tencent.mm.av.r.a
                            public final void a(String str, final Bitmap bitmap, String str2) {
                                AppMethodBeat.i(180367);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage.AnonymousClass3.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(180366);
                                        WxaShareMessagePage.this.nNp.setImageBitmap(bitmap);
                                        WxaShareMessagePage.this.nNj.setImageBitmap(bitmap);
                                        AppMethodBeat.o(180366);
                                    }
                                });
                                AppMethodBeat.o(180367);
                            }
                        });
                    }
                }
                String string2 = bundle.getString("key_footer_text", "");
                String string3 = bundle.getString("key_footer_text_default", "");
                if (!string2.isEmpty()) {
                    wxaShareMessagePage.nNq.setText(string2);
                } else if (!string3.isEmpty()) {
                    wxaShareMessagePage.nNq.setText(string3);
                }
            }
        }
        if (z) {
            wxaShareMessagePage.nNm.setVisibility(0);
        } else {
            wxaShareMessagePage.nNm.setVisibility(8);
        }
        wxaShareMessagePage.nNs = cVar;
        ((LifecycleOwner) context).getLifecycle().addObserver(wxaShareMessagePage);
        AppMethodBeat.o(180363);
        return wxaShareMessagePage;
    }

    @Override // com.tencent.mm.modelappbrand.k
    public final boolean a(String str, View view, Bundle bundle) {
        AppMethodBeat.i(48327);
        boolean a2 = a(str, view, bundle, (k.b) null);
        AppMethodBeat.o(48327);
        return a2;
    }

    @Override // com.tencent.mm.modelappbrand.k
    public final boolean a(String str, View view, Bundle bundle, final k.b bVar) {
        Bitmap a2;
        Bitmap decodeByteArray;
        Bitmap bitmap = null;
        AppMethodBeat.i(48328);
        Assert.assertNotNull(view);
        Assert.assertNotNull(bundle);
        if (!(view instanceof WxaShareMessagePage)) {
            AppMethodBeat.o(48328);
            return false;
        }
        Log.i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", str, Integer.valueOf(view.hashCode()));
        final WxaShareMessagePage wxaShareMessagePage = (WxaShareMessagePage) view;
        boolean z = bundle.getBoolean("is_dynamic_page");
        wxaShareMessagePage.setTitle(bundle.getString("title", ""));
        boolean z2 = bundle.getBoolean("is_video", false);
        int i2 = bundle.getInt("sub_type", 0);
        if (z2 || i2 == 1) {
            wxaShareMessagePage.getVideoIcon().setVisibility(0);
        } else {
            wxaShareMessagePage.getVideoIcon().setVisibility(8);
        }
        if (z) {
            wxaShareMessagePage.getCoverImageView().setVisibility(4);
            IPCDynamicPageView widgetPageView = wxaShareMessagePage.getWidgetPageView();
            widgetPageView.setVisibility(0);
            bundle.putInt("view_init_width", wxaShareMessagePage.getWidgetWidth());
            bundle.putInt("view_init_height", wxaShareMessagePage.getWidgetHeight());
            ((g) com.tencent.mm.kernel.g.af(g.class)).a(str, widgetPageView, bundle, new ac(new h() {
                /* class com.tencent.mm.plugin.appbrand.share.a.a.AnonymousClass2 */

                @Override // com.tencent.mm.modelappbrand.h
                public final void L(View view, int i2) {
                    AppMethodBeat.i(48321);
                    switch (i2) {
                        case 0:
                            wxaShareMessagePage.getLoadingView().setVisibility(0);
                            wxaShareMessagePage.getErrorImageView().setVisibility(4);
                            wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                            wxaShareMessagePage.getLoadingView().gZh();
                            AppMethodBeat.o(48321);
                            return;
                        case 1:
                            wxaShareMessagePage.getLoadingView().gZi();
                            wxaShareMessagePage.getLoadingView().setVisibility(4);
                            wxaShareMessagePage.getErrorImageView().setVisibility(0);
                            wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                            wxaShareMessagePage.getErrorImageView().setImageResource(R.raw.dynamic_page_res_not_found);
                            AppMethodBeat.o(48321);
                            return;
                        case 2:
                        case 3:
                        default:
                            wxaShareMessagePage.getLoadingView().gZi();
                            wxaShareMessagePage.getLoadingView().setVisibility(4);
                            wxaShareMessagePage.getErrorImageView().setVisibility(0);
                            wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                            wxaShareMessagePage.getErrorImageView().setImageResource(R.raw.app_brand_share_page_cover_default);
                            AppMethodBeat.o(48321);
                            return;
                        case 4:
                            wxaShareMessagePage.getLoadingView().setVisibility(4);
                            wxaShareMessagePage.getErrorImageView().setVisibility(4);
                            wxaShareMessagePage.getWidgetPageView().setVisibility(0);
                            AppMethodBeat.o(48321);
                            return;
                    }
                }
            }));
            a(bVar, 0);
        } else {
            wxaShareMessagePage.getWidgetPageView().setVisibility(4);
            wxaShareMessagePage.getCoverImageView().setVisibility(0);
            byte[] byteArray = bundle.getByteArray(ImagesContract.IMAGE_DATA);
            if (byteArray == null || byteArray.length <= 0 || (decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length)) == null || decodeByteArray.isRecycled()) {
                String string = bundle.getString("delay_load_img_path");
                if (z2) {
                    String string2 = bundle.getString("video_path");
                    String string3 = bundle.getString("video_thumb_path");
                    if (!Util.isNullOrNil(string3)) {
                        Bitmap a3 = b.aXY().a(string3, (b.f) null);
                        if (a3 == null || a3.isRecycled()) {
                            wxaShareMessagePage.oD();
                            a(bVar, 1);
                        } else {
                            wxaShareMessagePage.setImageData(a3);
                            a(bVar, 0);
                            AppMethodBeat.o(48328);
                            return true;
                        }
                    }
                    if (!Util.isNullOrNil(string2)) {
                        wxaShareMessagePage.getCoverImageView().setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.appbrand.share.a.a.AnonymousClass3 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(48322);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/share/api/WxaShareMessageService$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/share/api/WxaShareMessageService$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(48322);
                            }
                        });
                    }
                } else if (!Util.isNullOrNil(string)) {
                    if (!string.startsWith("delayLoadFile://")) {
                        bitmap = b.aXY().a(string, (b.f) null);
                        Log.i("MicroMsg.WxaShareMessageService", "findCachedLocal(%s)", string);
                    } else if (this.nNe.containsKey(2)) {
                        bitmap = BitmapUtil.getBitmapNative(string.replace("delayLoadFile://", ""));
                        Log.i("MicroMsg.WxaShareMessageService", "getBitmapNative(%s)", string);
                    }
                    if (bitmap != null) {
                        if (!bitmap.isRecycled()) {
                            wxaShareMessagePage.setImageData(bitmap);
                            a(bVar, 0);
                        } else {
                            wxaShareMessagePage.setOnLoadImageResult(bVar);
                            wxaShareMessagePage.setImageUrl(string);
                        }
                        AppMethodBeat.o(48328);
                        return true;
                    }
                    Log.i("MicroMsg.WxaShareMessageService", "delay loadImage(%s)", string);
                    wxaShareMessagePage.getLoadingView().setVisibility(0);
                    wxaShareMessagePage.getErrorImageView().setVisibility(4);
                    wxaShareMessagePage.getCoverImageView().setVisibility(4);
                    wxaShareMessagePage.getLoadingView().gZh();
                    a(2, new AbstractC0794a() {
                        /* class com.tencent.mm.plugin.appbrand.share.a.a.AnonymousClass4 */

                        @Override // com.tencent.mm.plugin.appbrand.share.a.a.AbstractC0794a
                        public final void S(final Bundle bundle) {
                            AppMethodBeat.i(48324);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.share.a.a.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(48323);
                                    String string = bundle.getString("delay_load_img_path");
                                    wxaShareMessagePage.setImageUrl(string);
                                    Log.i("MicroMsg.WxaShareMessageService", "onLoadImageFinishedAction(%s)", string);
                                    a.a(bVar);
                                    AppMethodBeat.o(48323);
                                }
                            });
                            AppMethodBeat.o(48324);
                        }
                    });
                } else {
                    String string4 = bundle.getString(MessengerShareContentUtility.IMAGE_URL);
                    if (string4 != null && (string4.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || string4.startsWith(HttpWrapperBase.PROTOCAL_HTTPS))) {
                        wxaShareMessagePage.setOnLoadImageResult(bVar);
                        wxaShareMessagePage.setImageUrl(string4);
                    } else if (string4 == null || !string4.startsWith("file://") || (a2 = b.aXY().a(string4, (b.f) null)) == null || a2.isRecycled()) {
                        wxaShareMessagePage.oD();
                        a(bVar, 1);
                    } else {
                        wxaShareMessagePage.setImageData(a2);
                        a(bVar, 0);
                        AppMethodBeat.o(48328);
                        return true;
                    }
                }
            } else {
                wxaShareMessagePage.setImageData(decodeByteArray);
                a(bVar, 0);
                AppMethodBeat.o(48328);
                return true;
            }
        }
        AppMethodBeat.o(48328);
        return true;
    }

    private static void a(k.b bVar, int i2) {
        AppMethodBeat.i(48329);
        if (bVar != null) {
            bVar.sD(i2);
        }
        AppMethodBeat.o(48329);
    }

    @Override // com.tencent.mm.modelappbrand.k
    public final void a(String str, View view) {
        AppMethodBeat.i(48330);
        Assert.assertNotNull(view);
        if (!(view instanceof WxaShareMessagePage)) {
            AppMethodBeat.o(48330);
            return;
        }
        Log.i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", str, Integer.valueOf(view.hashCode()));
        ((g) com.tencent.mm.kernel.g.af(g.class)).a(str, ((WxaShareMessagePage) view).getWidgetPageView());
        this.nNd.remove(2);
        AppMethodBeat.o(48330);
    }

    @Override // com.tencent.mm.modelappbrand.k
    public final synchronized void g(int i2, Bundle bundle) {
        AppMethodBeat.i(48331);
        AbstractC0794a aVar = this.nNd.get(Integer.valueOf(i2));
        if (aVar != null) {
            aVar.S(bundle);
        }
        this.nNe.put(Integer.valueOf(i2), bundle);
        Log.i("MicroMsg.WxaShareMessageService", "onAction(%d, %s)", Integer.valueOf(i2), bundle);
        AppMethodBeat.o(48331);
    }

    @Override // com.tencent.mm.modelappbrand.k
    /* renamed from: do  reason: not valid java name */
    public final b.f m15do(int i2, int i3) {
        AppMethodBeat.i(48332);
        b.f a2 = a(i2, i3, k.a.DECODE_TYPE_DEFAULT);
        AppMethodBeat.o(48332);
        return a2;
    }

    @Override // com.tencent.mm.modelappbrand.k
    public final b.f a(int i2, int i3, k.a aVar) {
        b.f fVar;
        AppMethodBeat.i(48333);
        String format = String.format("%d-%d-dp", Integer.valueOf(i2), Integer.valueOf(i3));
        SoftReference<b.f> softReference = this.nNb.get(format);
        if (softReference == null || (fVar = softReference.get()) == null) {
            synchronized (this) {
                try {
                    SoftReference<b.f> softReference2 = this.nNb.get(format);
                    if (softReference2 == null || (fVar = softReference2.get()) == null) {
                        com.tencent.mm.plugin.appbrand.share.a aVar2 = new com.tencent.mm.plugin.appbrand.share.a(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), i2), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), i3));
                        aVar2.nMZ = aVar;
                        this.nNb.put(format, new SoftReference<>(aVar2));
                        fVar = aVar2;
                    }
                } finally {
                    AppMethodBeat.o(48333);
                }
            }
        }
        return fVar;
    }

    @Override // com.tencent.mm.modelappbrand.k
    public final b.h aXK() {
        b.h hVar;
        AppMethodBeat.i(48334);
        String format = String.format("%d-%d-dp", 112, 90);
        SoftReference<b.h> softReference = this.nNc.get(format);
        if (softReference == null || (hVar = softReference.get()) == null) {
            synchronized (this) {
                try {
                    SoftReference<b.h> softReference2 = this.nNc.get(format);
                    if (softReference2 == null || (hVar = softReference2.get()) == null) {
                        hVar = new com.tencent.mm.plugin.appbrand.share.b(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 112), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 90));
                        this.nNc.put(format, new SoftReference<>(hVar));
                    }
                } finally {
                    AppMethodBeat.o(48334);
                }
            }
        }
        return hVar;
    }

    private void a(int i2, AbstractC0794a aVar) {
        AppMethodBeat.i(48335);
        this.nNd.put(Integer.valueOf(i2), aVar);
        if (this.nNe.containsKey(Integer.valueOf(i2))) {
            aVar.S(this.nNe.get(Integer.valueOf(i2)));
        }
        AppMethodBeat.o(48335);
    }
}
