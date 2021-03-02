package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.c;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.a.e;

public class ZoomImagePreviewer extends MMGestureGallery implements c.a {
    private int height = 0;
    private a lTB;
    private ArrayList<String> lTC = new ArrayList<>();
    private ac lTD;
    private HashMap<String, SoftReference<MultiTouchImageView>> lTE = new HashMap<>();
    private HashSet<String> lTF = new HashSet<>();
    private b lTG = new b(this, (byte) 0);
    private float scale = 1.0f;
    private int viewId = 0;
    private int width = 0;

    public ZoomImagePreviewer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(226750);
        init();
        AppMethodBeat.o(226750);
    }

    public ZoomImagePreviewer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(226751);
        init();
        AppMethodBeat.o(226751);
    }

    private void init() {
        AppMethodBeat.i(226752);
        this.lTB = new a(this, (byte) 0);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setAdapter((SpinnerAdapter) this.lTB);
        setSelection(0);
        AppMethodBeat.o(226752);
    }

    public void setComponent(ac acVar) {
        this.lTD = acVar;
    }

    public void setData(ArrayList<String> arrayList) {
        AppMethodBeat.i(226753);
        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "setData");
        if (this.lTD == null || arrayList == null) {
            Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "url is empty or component is null");
            AppMethodBeat.o(226753);
            return;
        }
        this.lTC.clear();
        this.lTC.addAll(arrayList);
        this.lTB.notifyDataSetChanged();
        AppMethodBeat.o(226753);
    }

    public final void C(ArrayList<String> arrayList) {
        AppMethodBeat.i(226754);
        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView");
        if (this.lTD == null) {
            Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView url is empty or component is null");
            AppMethodBeat.o(226754);
        } else if (!this.lTC.isEmpty() || arrayList.isEmpty()) {
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!this.lTC.contains(next)) {
                        arrayList2.add(next);
                        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "new url is added, url:%s", next);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "add new Data");
                    this.lTC.addAll(arrayList2);
                    this.lTB.notifyDataSetChanged();
                }
                Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data");
                Iterator<String> it2 = this.lTC.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    SoftReference<MultiTouchImageView> softReference = this.lTE.get(next2);
                    if (softReference == null || softReference.get() == null) {
                        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data url with view is recycle or not exist, url:%s", next2);
                    } else {
                        final MultiTouchImageView multiTouchImageView = softReference.get();
                        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data width:%d, height:%d, scale:%f", Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.scale));
                        multiTouchImageView.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.ZoomImagePreviewer.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(226744);
                                if (ZoomImagePreviewer.this.scale != multiTouchImageView.getOriginScale()) {
                                    multiTouchImageView.setOriginScale(ZoomImagePreviewer.this.scale);
                                    multiTouchImageView.cs(ZoomImagePreviewer.this.scale);
                                    multiTouchImageView.gKz();
                                }
                                AppMethodBeat.o(226744);
                            }
                        }, 100);
                    }
                }
            }
            AppMethodBeat.o(226754);
        } else {
            this.lTC.addAll(arrayList);
            this.lTB.notifyDataSetChanged();
            AppMethodBeat.o(226754);
        }
    }

    public void setScale(float f2) {
        this.scale = f2;
    }

    public final void ec(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.coverview.c.a
    public final void dr(String str, String str2) {
        AppMethodBeat.i(226755);
        if (!this.lTF.contains(str)) {
            this.lTF.add(str);
            b bVar = this.lTG;
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("reason", str2);
            hashMap.put("viewId", Integer.valueOf(ZoomImagePreviewer.this.viewId));
            bVar.L(hashMap).h(ZoomImagePreviewer.this.lTD.NY()).bEo();
        }
        AppMethodBeat.o(226755);
    }

    public void setViewId(int i2) {
        this.viewId = i2;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(ZoomImagePreviewer zoomImagePreviewer, byte b2) {
            this();
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.i(226746);
            ZoomImagePreviewer.this.lTD.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.ZoomImagePreviewer.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(226745);
                    ZoomImagePreviewer.this.lTF.clear();
                    AppMethodBeat.o(226745);
                }
            });
            super.notifyDataSetChanged();
            AppMethodBeat.o(226746);
        }

        public final int getCount() {
            AppMethodBeat.i(226747);
            int size = ZoomImagePreviewer.this.lTC.size();
            AppMethodBeat.o(226747);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(226748);
            Object obj = ZoomImagePreviewer.this.lTC.get(i2);
            AppMethodBeat.o(226748);
            return obj;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            MultiTouchImageView multiTouchImageView;
            AppMethodBeat.i(226749);
            if (view == null) {
                MultiTouchImageView multiTouchImageView2 = new MultiTouchImageView(ZoomImagePreviewer.this.getContext(), 0, 0, (byte) 0);
                multiTouchImageView2.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                C0657a aVar = new C0657a();
                aVar.lTJ = multiTouchImageView2;
                multiTouchImageView2.setTag(aVar);
                multiTouchImageView = multiTouchImageView2;
            } else {
                MultiTouchImageView multiTouchImageView3 = ((C0657a) view.getTag()).lTJ;
                Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView from holder");
                multiTouchImageView = multiTouchImageView3;
            }
            multiTouchImageView.setMinZoomLimit(0.5f);
            multiTouchImageView.setMaxZoomDoubleTab(true);
            multiTouchImageView.setOriginScale(ZoomImagePreviewer.this.scale);
            if (Build.VERSION.SDK_INT == 20) {
                multiTouchImageView.setLayerType(1, null);
            } else {
                ForceGpuUtil.decideLayerType(multiTouchImageView, ZoomImagePreviewer.this.width, ZoomImagePreviewer.this.height);
            }
            multiTouchImageView.setEnableHorLongBmpMode(false);
            String str = (String) getItem(i2);
            Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView url:%s", str);
            ac acVar = ZoomImagePreviewer.this.lTD;
            float f2 = ZoomImagePreviewer.this.scale;
            ZoomImagePreviewer zoomImagePreviewer = ZoomImagePreviewer.this;
            if (multiTouchImageView == null || str == null) {
                if (zoomImagePreviewer != null) {
                    zoomImagePreviewer.dr(str, "invalid imageView or url");
                }
            } else if (!TextUtils.isEmpty(str)) {
                String b2 = ((com.tencent.mm.plugin.appbrand.f.b) acVar.M(com.tencent.mm.plugin.appbrand.f.b.class)).b(acVar, str);
                ((com.tencent.mm.plugin.appbrand.f.a) acVar.M(com.tencent.mm.plugin.appbrand.f.a.class)).a(b2, new a.c(zoomImagePreviewer, str, b2, multiTouchImageView, f2) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.c.AnonymousClass1 */
                    final /* synthetic */ float dsJ;
                    final /* synthetic */ String iOH;
                    final /* synthetic */ MultiTouchImageView jUK;
                    final /* synthetic */ a lTj;
                    final /* synthetic */ String val$url;

                    {
                        this.lTj = r1;
                        this.val$url = r2;
                        this.iOH = r3;
                        this.jUK = r4;
                        this.dsJ = r5;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.f.a.c
                    public final void C(InputStream inputStream) {
                        AppMethodBeat.i(226735);
                        if (inputStream == null) {
                            if (this.lTj != null) {
                                this.lTj.dr(this.val$url, "null InputStream, finalUrl: " + this.iOH);
                            }
                            Log.e("MicroMsg.ImagePreviewerUtils", "openRead failed, url=%s", this.iOH);
                            AppMethodBeat.o(226735);
                            return;
                        }
                        InputStream F = com.tencent.mm.plugin.appbrand.jsapi.ac.c.F(inputStream);
                        F.mark(com.tencent.mm.plugin.appbrand.jsapi.ac.c.getCompatibleRewindBufferSize());
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        c.bGk().b(F, options);
                        String str = options.outMimeType;
                        char c2 = 65535;
                        switch (str.hashCode()) {
                            case -879299344:
                                if (str.equals("image/GIF")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case -879267568:
                                if (str.equals("image/gif")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                            case 1:
                                if (this.lTj != null) {
                                    this.lTj.dr(this.val$url, "not support gif");
                                }
                                Log.e("MicroMsg.ImagePreviewerUtils", "not support gift image");
                                AppMethodBeat.o(226735);
                                return;
                            default:
                                try {
                                    F.reset();
                                    Bitmap decodeStream = c.bGk().decodeStream(F);
                                    e.W(F);
                                    if (decodeStream == null || decodeStream.isRecycled()) {
                                        if (this.lTj != null) {
                                            this.lTj.dr(this.val$url, "bmp is null or recycled");
                                        }
                                        AppMethodBeat.o(226735);
                                        return;
                                    }
                                    this.jUK.setImageBitmap(decodeStream);
                                    this.jUK.cN(decodeStream.getWidth(), decodeStream.getHeight());
                                    this.jUK.postDelayed(new Runnable() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.c.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(226734);
                                            if (AnonymousClass1.this.dsJ >= 0.5f) {
                                                AnonymousClass1.this.jUK.cs(AnonymousClass1.this.dsJ);
                                                AnonymousClass1.this.jUK.gKz();
                                            }
                                            AppMethodBeat.o(226734);
                                        }
                                    }, 100);
                                    AppMethodBeat.o(226735);
                                    return;
                                } catch (Throwable th) {
                                    if (this.lTj != null) {
                                        this.lTj.dr(this.val$url, "exception found: " + th.toString());
                                    }
                                    Log.e("MicroMsg.ImagePreviewerUtils", "setImageBitmap failed, url=%s", this.iOH);
                                    AppMethodBeat.o(226735);
                                    return;
                                }
                        }
                    }
                });
            }
            multiTouchImageView.setTag(multiTouchImageView);
            ZoomImagePreviewer.this.lTE.put(str, new SoftReference(multiTouchImageView));
            AppMethodBeat.o(226749);
            return multiTouchImageView;
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.ZoomImagePreviewer$a$a  reason: collision with other inner class name */
        public class C0657a {
            public MultiTouchImageView lTJ;

            public C0657a() {
            }
        }
    }

    class b extends bc {
        private static final int CTRL_INDEX = -2;
        public static final String NAME = "onImagePreviewerLoadFail";

        private b() {
        }

        /* synthetic */ b(ZoomImagePreviewer zoomImagePreviewer, byte b2) {
            this();
        }
    }
}
